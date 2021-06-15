/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.atmc.bsl.db.service.impl;

import com.atmc.bsl.db.domain.claim.*;
import com.atmc.bsl.db.domain.policy.Policy;
import com.atmc.bsl.db.domain.quotation.CustomerMapDetails;
import com.atmc.bsl.db.service.CodeMasterDetailsLocalServiceUtil;
import com.atmc.bsl.db.service.PolicyLocalServiceUtil;
import com.atmc.bsl.db.service.base.ClaimLocalServiceBaseImpl;
import com.ejada.atmc.acl.db.exception.*;
import com.ejada.atmc.acl.db.model.MuroorTPUploads;
import com.ejada.atmc.acl.db.model.*;
import com.ejada.atmc.acl.db.service.*;
import com.ejada.atmc.acl.db.service.persistence.*;
import com.ejada.atmc.acl.ws.domain.ods.ODSCIResponse;
import com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation;
import com.ejada.atmc.acl.ws.service.OdsLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.io.ByteArrayFileInputStream;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.util.PropsUtil;
import org.osgi.service.component.annotations.Component;

import javax.sql.rowset.serial.SerialException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * The implementation of the claim local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.atmc.bsl.db.service.ClaimLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.atmc.bsl.db.model.Claim",
	service = AopService.class
)
public class ClaimLocalServiceImpl extends ClaimLocalServiceBaseImpl {


	private static final String CUSTOMER_CATG_CUSTOMER = "024";
	private static final String CUSTOMER_TYPE_CUSTOMER = "CUSTOMER";
	private static final String ATMC_ENGLISH_NAME = "18";
	private static final String STATUS_SUBMITTED = "SUBMITTED";
	private static final String USERNAME_CUSTOMER = "CUSTOMER";
	private static final String CLAIM_INTIMATION_SOURCE = "01";
	private static final String PRODUCT_CODE_TPL = "13102";
	private static final String PRODUCT_CODE_COMPREHENSIVE = "13101";
	private static final String NAJM_INS_COMPANY = "NAJM_INS_CO";

	private static final String VEHICLE_IDENT_TYPE_CUSTOM = "2";
	private static final String VEHICLE_IDENT_TYPE_PLATE_NUMBER = "1";
	private static final String REPORT_MODE_NAJM = "03";
	private static final String REPORT_MODE_MUROOR = "01";
	private static final String TRX_TPL = "TP";
	private static final String TRX_COMPREHENSIVE = "OD";
	private static final String CODE_CAUSE_LOSS = "CAUSE_LOSS";
	private static final String CODE_NAT_OF_LOSS = "NAT_OF_LOSS";
	private static final String PRODUCT_TPL = "13102";
	private static final String PRODUCT_COMPREHENSIVE = "13101";
	private static final String CLAIM_INTIMATION_OBJ = "claimIntimation";
	private static final String NAJM_CLAIM_INTIMATION_OBJ = "najmclaimIntimation";
	private static final String CLAIM_TYPE_VEHICLE = "V";
	private static final String CLAIM_TYPE_PROPERTY = "P";



	private static final String NAJM_CITY = "NAJM_CITY";
	private static final String VEHICLE_MODEL_CODE = "MOT_VEH_MOD";
	private static final String CODE_FREEZ_YN = "N";
	private static final String STATUS_CLOSED = "Closed";
	private static final Log _log = LogFactoryUtil.getLog(ClaimLocalServiceImpl.class);
	private static final String SUCCESS_CODE = "S";
	private static final String CITY_CODE = "CITY";

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.atmc.bsl.db.service.ClaimLocalServiceUtil} to access the claim local service.
	 */
	public List<Claim> getClaimsByIqamaId(String iqamaId) throws PortalException
	{
		_log.info("getClaimsByIqamaId for ID:" + iqamaId);
		List<ClaimHDR> claimsHdrList = ClaimHDRLocalServiceUtil.findClaimsByIqamaId(iqamaId);
		List<Claim> claimsList = getCustomClaims(claimsHdrList);
		return claimsList;
	}

	//	public NajmClaim getNajmClaimByNajmPlateNumber(String caseNo,String najmPlateNo) throws PortalException
//	{
//		CLMNajm claimNajm = CLMNajmUtil.findByCASE_PLATE(caseNo, najmPlateNo);
//		NajmClaim claimsList = getCustomNajmClaim(claimNajm);
//		return claimsList;
//	}
//	public NajmClaim getNajmClaimByCustomId(String caseNo,String customId) throws PortalException
//	{
//		CLMNajm claimNajm = CLMNajmUtil.findByCASE_CUSTOM(caseNo, customId);
//		NajmClaim claimsList = getCustomNajmClaim(claimNajm);
//		return claimsList;
//	}
	public List<NajmClaim> getNajmClaimByCaseNo(String caseNo)
	{
		List<CLMNajm> claimNajm = CLMNajmUtil.findBycaseNo(caseNo);
		List<NajmClaim> claimsList = getCustomNajmClaim(claimNajm);
		return claimsList;
	}

	public List<Claim> getClaimsSummary(String iqamaId) throws PortalException
	{
		List<ClaimHDR> claimsHdrList = ClaimHDRUtil.findByIqamaId(iqamaId);
		List<Claim> claimsList = getCustomClaims(claimsHdrList);

		return claimsList;
	}

	public List<Claim> getAllClaims(String status,String surveyor, String refNo,int from , int to) throws PortalException
	{
		List<Object[]> claimsHdrList = ClaimHDRLocalServiceUtil.findClaimsPolicyStatusAdmin(status,surveyor,refNo, from , to);
		List<Claim> claimsList = getClaimsWithPolicyDStausetails(claimsHdrList);
		List<Claim> claimsAdList = getAdminCustomClaimsSummary(claimsList);
		return claimsAdList;
	}

	public Claim getClaimDetails(String claimNumber, String policyNumber) throws PortalException
	{
		ClaimHDRPK claimPK = new ClaimHDRPK(policyNumber, claimNumber);
		ClaimHDR claimHdr = ClaimHDRLocalServiceUtil.getClaimHDR(claimPK);
		Claim customClaim=getCustomClaim(claimHdr);
		return getAdminCustomClaims(customClaim);
	}
	public Claim getClaimDetailsByClaimNO(String claimNumber) throws PortalException
	{
		ClaimHDR claimHdr = ClaimHDRUtil.findByclaimNo(claimNumber).get(0);
		Claim customClaim=getClaimsWithClaimNO(claimHdr);
		return customClaim;
	}


	private List<Claim> getCustomClaims(List<ClaimHDR> claimsHdrList) throws PortalException
	{
		List<Claim> claimList = new ArrayList<>();

		if(claimsHdrList != null && !claimsHdrList.isEmpty())
		{
			for(ClaimHDR claimHdr : claimsHdrList)
			{

				claimList.add(getCustomClaim(claimHdr));
			}

		}
		return claimList;
	}

	private List<Claim> getAdminCustomClaimsSummary(List<Claim> customClaim) throws PortalException
	{


		for(Claim claim : customClaim)
		{

			List<ClaimHistory> claimHistory = getCustomClaimHistory(CLMSTATUSHISTORYUtil.findByRefNo(claim.getClaimNo()));
			claim.setClaimHistory(claimHistory);
		}


		return customClaim;

	}

	private Claim getCustomClaim(ClaimHDR claimHdr)
	{
		Claim claim = new Claim();

		claim.setClaimNo(claimHdr.getClaimNo());
		claim.setIqamaId(claimHdr.getIqamaId());
		claim.setPolicyNo(claimHdr.getPolicyNo());
		claim.setArPlateL1(claimHdr.getArPlateL1());
		claim.setArPlateL2(claimHdr.getArPlateL2());
		claim.setArPlateL3(claimHdr.getArPlateL3());
		claim.setArPlateNo(claimHdr.getArPlateNo());
		claim.setCauseCode(claimHdr.getCauseCode());
		claim.setClaimAntName(claimHdr.getClaimantName());
		claim.setClaimAntPhone(claimHdr.getClaimantName());
		claim.setClaimAntPhone(claimHdr.getClaimantPhone());
		claim.setClaimIntmDate(claimHdr.getClaimIntmDate());
		claim.setClaimLossDate(claimHdr.getClaimLossDate());
		claim.setClaimSetlDate(claimHdr.getClaimSetlDate());
		claim.setClaimStatus(claimHdr.getClaimStatus());
		claim.setDriverName(claimHdr.getDriverName());
		claim.setEnPlateL1(claimHdr.getEnPlateL1());
		claim.setEnPlateL2(claimHdr.getEnPlateL2());
		claim.setEnPlateL3(claimHdr.getEnPlateL3());
		claim.setEnPlateNo(claimHdr.getEnPlateNo());
		claim.setFaultPercent(claimHdr.getFaultPercent());
		claim.setIban(claimHdr.getIban());
		claim.setLossRemarks(claimHdr.getLossRemarks());
		claim.setNatureOfLoss(claimHdr.getNatureOfLoss());
		claim.setReportNo(claimHdr.getReportNo());
		claim.setReportType(claimHdr.getReportType());
		claim.setTpAge(claimHdr.getTpAge());
		claim.setTpDriverName(claimHdr.getTpDriverName());
		claim.setTpIban(claimHdr.getTpIban());
		claim.setTpID(claimHdr.getTpID());
		claim.setTpInsuranceCo(claimHdr.getTpInsuranceCo());
		claim.setTpMobileNo(claimHdr.getTpMobileNo());
		claim.setTpNationality(claimHdr.getTpNationality());
		claim.setTpPlateL1(claimHdr.getTpPlateL1());
		claim.setTpPlateL2(claimHdr.getTpPlateL2());
		claim.setTpPlateL3(claimHdr.getTpPlateL3());
		claim.setTpPlateNo(claimHdr.getTpPlateNo());
		claim.setTypeOfClaim(claimHdr.getTypeOfClaim());
		claim.setClaimAmount(claimHdr.getClaimAmount());
		claim.setLossLocation(claimHdr.getLossLocationCityEn());
		claim.setLossLocationAr(claimHdr.getLossLocationCityAr());
		claim.setWorkflowStatus(claimHdr.getWorkflowStatus());
		claim.setProduct(claimHdr.getProdCode());
		claim.setProductDescAr(claimHdr.getProductDescAr());
		claim.setProductDescEn(claimHdr.getProductDescEn());

		return claim;

	}

	//	private List<Claim> getClaimsWithPolicyDetails(List<ClaimHDR> claimsList) throws PortalException
//	{
//		List<Claim> claimList = new ArrayList<>();
//
//		if(claimsList != null && !claimsList.isEmpty())
//		{
//			for(ClaimHDR claimHdr : claimsList)
//			{
//
//
//
//				Claim claim = getCustomClaim(claimHdr);
//				claim.setProduct(claimHdr.getProdCode());
//				claim.setProductDescAr(claimHdr.getProductDescAr());
//				claim.setProductDescEn(claimHdr.getProductDescEn());
//
//				claimList.add(claim);
//
//			}
//
//		}
//		return claimList;
//
//	}
	private Claim getClaimsWithClaimNO(ClaimHDR claimHdr) throws PortalException
	{

		Claim claim = getCustomClaim(claimHdr);
		try {
			if( (claimHdr.getEnPlateNo()!=null||claimHdr.getEnPlateNo().equals("")) && (claimHdr.getEnPlateL1()!=null || claimHdr.getEnPlateL1().equals("")) && (claimHdr.getEnPlateL2()!=null || claimHdr.getEnPlateL2().equals("")) && (claimHdr.getEnPlateL3()!=null || claimHdr.getEnPlateL3().equals(""))){
				PolicyVEH vehicle= PolicyVEHLocalServiceUtil.findByEnPlateNo(Long.valueOf(claimHdr.getEnPlateNo()), claimHdr.getEnPlateL1(), claimHdr.getEnPlateL2(), claimHdr.getEnPlateL3()).get(0);
				claim.setVehMakeEn(vehicle.getMakeDescEn());
				claim.setVehMakeAr(vehicle.getMakeDescAr());
				claim.setVehModelAr(vehicle.getModelDescAr());
				claim.setVehModelEn(vehicle.getModelDescEn());
				claim.setMfgYear(vehicle.getMfgYear());
			}
			else {
				return null;
			}
		} catch (NoSuchPolicyVEHException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		};
		return claim;

	}

	private List<NajmClaim> getCustomNajmClaim(List<CLMNajm> clmNajmList){
		List<NajmClaim> najmClaimList= new ArrayList<>();
		for(CLMNajm clmNajm:clmNajmList){
			NajmClaim najmClaim = new NajmClaim();

			najmClaim.setCaseNo(clmNajm.getCaseNo());
			najmClaim.setCipiId(clmNajm.getCipiId());
			najmClaim.setCallDt(clmNajm.getCallDt());
			najmClaim.setCity(clmNajm.getCity());
			najmClaim.setPhoneNo(clmNajm.getPhoneNo());
			najmClaim.setAge(clmNajm.getAge());
			najmClaim.setNationality(clmNajm.getNationality());
			najmClaim.setPlateNo(clmNajm.getPlateNo());
			najmClaim.setLiabiltiyPerc(clmNajm.getLiabiltiyPerc());
			najmClaim.setLiabiltiyAmt(clmNajm.getLiabiltiyAmt());
			najmClaim.setCustomId(clmNajm.getCustomId());
			najmClaim.setSeqNo(clmNajm.getSeqNo());
			najmClaim.setEnglishName(clmNajm.getEnglishName());
			najmClaim.setPolNo(clmNajm.getPolNo());
			najmClaim.setNajmPlateNo(clmNajm.getNajmPlateNo());
			najmClaim.setNajmChassisNo(clmNajm.getNajmChassisNo());
			najmClaim.setNajmVEHNo(clmNajm.getNajmVEHNo());
			najmClaim.setCauseAr(clmNajm.getCauseAr());
			najmClaim.setCauseEn(clmNajm.getCauseEn());
			najmClaim.setCityDesEN(getCityDescEn(clmNajm.getCity()));
			najmClaim.setCityDesAr(getCityDescAr(clmNajm.getCity()));
			najmClaim.setName(clmNajm.getName());
			najmClaim.setInsComp(getInsuranceCompany(clmNajm.getEnglishName()));
			najmClaimList.add(najmClaim);
		}


		return najmClaimList;
	}

	public String getCityDescEn(String cityCode)
	{
		CodeMasterMap codeMasterMap=null;
		try
		{

			codeMasterMap = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode(NAJM_CITY, cityCode);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		return (codeMasterMap!=null)?codeMasterMap.getSourceDesc():"";
	}

	public String getCityDescAr(String cityCode)
	{
		CodeMasterMap	codeMasterMap=null;
		try
		{

			codeMasterMap = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode(NAJM_CITY, cityCode);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		return (codeMasterMap!=null)?codeMasterMap.getSourceDesc():"";
	}
	public String getCityCoreCode(String cityCode)
	{
		CodeMasterMap	codeMasterMap=null;
		try
		{

			codeMasterMap = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode(NAJM_CITY, cityCode);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		return (codeMasterMap!=null)?codeMasterMap.getCoreCode():"";
	}


	private String getInsuranceCompany (String insCompany)
	{
		CodeMasterMap	codeMasterMap=null;
		try{
			codeMasterMap = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode(NAJM_INS_COMPANY, insCompany);

		}catch (Exception e) {
			// TODO: handle exception]
			return "";
		}


		return (codeMasterMap!=null)?codeMasterMap.getSourceDesc():"";
	}

	public  int checkIbanValidation(String iban){
		int expFlag=0;
		try{
			if(Pattern.compile("^(SA)([0-9 A-Z]){22}$").matcher(iban).find()) {
				String countryCode = iban.substring(0, 4);
				String bankCode = iban.substring(4, 6);
				String accNo = iban.substring(6, iban.length());
				expFlag = ValidationLocalServiceUtil.IbanValidation(countryCode, bankCode, accNo);
				System.out.println("expFlag" + expFlag);
			}
			return expFlag;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return expFlag;
	}

	public ODSCIResponse submitClaim(ODSClaimIntimation odsClaimInt) throws PortalException{

		// setting reference number and source before submitting
		String claimReferenceNo = "CLM" + counterLocalService.increment();
		odsClaimInt.setReferenceno(claimReferenceNo);
		odsClaimInt.setSource(CLAIM_INTIMATION_SOURCE);
		ODSCIResponse odsCIResponse= OdsLocalServiceUtil.claimIntimation(odsClaimInt);

		if(odsCIResponse.getStatus().equals(SUCCESS_CODE)){
			_log.info("Claim submitted successfully. adding workflow status");
			addWorkflowStatus(odsCIResponse.getClaimintimationno());
		}
		return odsCIResponse;

	}

	public void saveNajmSubmitedDoc(String caseNo, String cipiId, File najmSlipFile, String najmSlipFileName, File damageEstQuotFile, String damageEstQuotFileName, File bankIbanFile, String bankIbanFileName, File ownerIdFile, String ownerIdFileName, String claimRefNo){

		ByteArrayFileInputStream najmSlipInputStream = null;
		ByteArrayFileInputStream damageEstQuotInputStream = null;
		ByteArrayFileInputStream bankIbanInputStream = null;
		ByteArrayFileInputStream ownerIdInputStream = null;

		najmSlipInputStream = new ByteArrayFileInputStream(najmSlipFile, 1024);
		if(damageEstQuotFile!=null)
		{
			damageEstQuotInputStream = new ByteArrayFileInputStream(damageEstQuotFile, 1024);
		}
		if(bankIbanFile!=null)
		{
			bankIbanInputStream = new ByteArrayFileInputStream(bankIbanFile, 1024);
		}
		if(ownerIdFile!=null)
		{
			ownerIdInputStream = new ByteArrayFileInputStream(ownerIdFile, 1024);
		}
		byte[] najmSlipData;
		byte[] damageEstQuotData;
		byte[] bankIbanData;
		byte[] ownerIdData;
		try {
			CLMNajmUploads clmNajmuploads= CLMNajmUploadsUtil.create((int) CounterLocalServiceUtil.increment());
			clmNajmuploads.setCaseNo(caseNo);
			clmNajmuploads.setCipiId(cipiId);
			clmNajmuploads.setClaimRefNo(claimRefNo);
			clmNajmuploads.setNajmSlipName(najmSlipFileName);
			clmNajmuploads.setDamageEstQuotName(damageEstQuotFileName);
			clmNajmuploads.setBankIbanName(bankIbanFileName);
			clmNajmuploads.setOwnerIdName(ownerIdFileName);

			najmSlipData = FileUtil.getBytes(najmSlipInputStream);

			damageEstQuotData = FileUtil.getBytes(damageEstQuotInputStream);
			bankIbanData = FileUtil.getBytes(bankIbanInputStream);
			ownerIdData = FileUtil.getBytes(ownerIdInputStream);

			clmNajmuploads.setNajmSlip(new javax.sql.rowset.serial.SerialBlob(najmSlipData));
			clmNajmuploads.setDamageEstQuot(new javax.sql.rowset.serial.SerialBlob(damageEstQuotData));
			clmNajmuploads.setBankIban(new javax.sql.rowset.serial.SerialBlob(bankIbanData));
			clmNajmuploads.setOwnerId(new javax.sql.rowset.serial.SerialBlob(ownerIdData));

			CLMNajmUploadsUtil.update(clmNajmuploads);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	public PolicyHDR getNajmOtherPartyPolicy(String najmCaseNo)
	{
		String englishName = "Alinma Tokio Marine";

		try {
			CLMNajm clmNajm = CLMNajmLocalServiceUtil.findByCaseNoEnglishName(najmCaseNo, englishName);
			return PolicyHDRLocalServiceUtil.getPolicyHDR(clmNajm.getPolNo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private String getNajmPlateNumber(String najmViewVehiclePlateNumber, String language)
	{
		if (najmViewVehiclePlateNumber.contains(","))
		{
			String[] plateNumbersEnAr = najmViewVehiclePlateNumber.split(",");
			if (language.equals("en_US"))
				return (plateNumbersEnAr[0]);
			else
				return (plateNumbersEnAr[1]).trim();
		}
		else
			_log.error("getNajmPlateNumber: ERROR Invalid Format for given vehicle plate number:" + najmViewVehiclePlateNumber);

		return "";
	}

	private NajmClaimIntimation getNajmCaseTwoParties(List<NajmClaim> clmNajmList, String vehiclePlateNumber, String vehicleCustomId, String language) throws PortalException
	{
		NajmClaimIntimation najmClaimIntimation = new NajmClaimIntimation();
		for (NajmClaim najmClaim : clmNajmList) {
			if (vehicleCustomId != null && najmClaim.getCustomId().equals(vehicleCustomId) ||
					(vehiclePlateNumber != null && getNajmPlateNumber(najmClaim.getPlateNo(),language).equals(vehiclePlateNumber)))
			{
				_log.info("getNajmCaseTwoParties:MATCH found for claimant");
				najmClaimIntimation.setClaimant(najmClaim);
				if (najmClaim.getEnglishName().equals(ATMC_ENGLISH_NAME))
				{
					_log.info("getNajmCaseTwoParties:claimant is ATMC");
					najmClaimIntimation.setClaimantATMC(true);
					najmClaimIntimation.setClaimantPolicyType(PolicyHDRLocalServiceUtil.getPolicyHDR(najmClaim.getPolNo()).getProduct());
				}
				else
				{
					_log.info("getNajmCaseTwoParties:claimant is NONATMC");
					najmClaimIntimation.setClaimantATMC(false);
				}
				break;
			}
		}

		if (najmClaimIntimation.getClaimant() == null)
			throw new NoSuchNajmVehicleNoException();

		if (!najmClaimIntimation.isClaimantATMC() || (najmClaimIntimation.isClaimantATMC() && najmClaimIntimation.getClaimantPolicyType().equals(PRODUCT_CODE_TPL)))
		{
			for (NajmClaim najmClaim : clmNajmList) {
				if (vehicleCustomId != null && !(najmClaim.getCustomId()).equals(vehicleCustomId) && najmClaim.getEnglishName().equals(ATMC_ENGLISH_NAME) ||
						vehiclePlateNumber != null && !(getNajmPlateNumber(najmClaim.getPlateNo(),language)).equals(vehiclePlateNumber) && najmClaim.getEnglishName().equals(ATMC_ENGLISH_NAME))
				{
					_log.info("getNajmCaseTwoParties:MATCH found for other ATMC party");
					najmClaimIntimation.setOtherParty(najmClaim);
					najmClaimIntimation.setOtherPartyATMC(true);
					najmClaimIntimation.setOtherPartyPolicyType(PolicyHDRLocalServiceUtil.getPolicyHDR(najmClaim.getPolNo()).getProduct());
					break;
				}

			}

			if (najmClaimIntimation.getOtherParty() == null)
				throw new NoSuchNajmOtherPartyException();


		}


		return najmClaimIntimation;
	}
	public NajmClaimIntimation getNajmClaimIntimationByCustomId(String caseNo, String vehicleCustomId, String language) throws PortalException
	{

		List<NajmClaim>	clmNajmList = getNajmClaimByCaseNo(caseNo);

		if (clmNajmList == null || clmNajmList.isEmpty())
		{
			_log.error("getNajmClaimIntimationByCustomId: case no " + caseNo + " is not found in CLMNAJM View" );
			throw new NoSuchNajmCaseNoException();
		}

		return getNajmCaseTwoParties(clmNajmList, null, vehicleCustomId,language);
	}

	public NajmClaimIntimation getNajmClaimIntimationByPlateNumber(String caseNo, String plateNumber,String language) throws PortalException
	{
		List<NajmClaim>	clmNajmList = getNajmClaimByCaseNo(caseNo);
		if (clmNajmList == null || clmNajmList.isEmpty())
		{
			_log.error("getNajmClaimIntimationByPlateNumber: case no " + caseNo + " is not found in CLMNAJM View" );
			throw new NoSuchNajmCaseNoException();
		}

		return getNajmCaseTwoParties(clmNajmList, plateNumber, null,language);
	}

//	private NajmClaimIntimation getNajmClaimIntimation(CLMNajm claimant,CLMNajm otherParty) throws PortalException
//	{
//		NajmClaimIntimation najmClaimIntimation = new NajmClaimIntimation();
//
//
//		if (claimant.getEnglishName().equals(ATMC_ENGLISH_NAME))
//		{
//			najmClaimIntimation.setClaimantATMC(true);
//			najmClaimIntimation.setClaimantPolicyNumber(claimant.getPolNo());
//			najmClaimIntimation.setClaimantPolicyType(PolicyHDRLocalServiceUtil.getPolicyHDR(claimant.getPolNo()).getProduct());
//		}
//		else
//		{
//			najmClaimIntimation.setClaimantATMC(false);
//		}
//
//		if (otherParty != null)
//		{
//			if (otherParty.getEnglishName().equals(ATMC_ENGLISH_NAME))
//			{
//				najmClaimIntimation.setOtherPartyATMC(true);
//				najmClaimIntimation.setOtherPartyPolicyNumber(otherParty.getPolNo());
//				najmClaimIntimation.setOtherPartyPolicyType(PolicyHDRLocalServiceUtil.getPolicyHDR(otherParty.getPolNo()).getProduct());
//			}
//			else
//			{
//				najmClaimIntimation.setOtherPartyATMC(false);
//			}
//		}
//
//		return najmClaimIntimation;
//
//	}


	public PolicyHDR getVehiclePolicy(String vehicleSeqCustom) throws NoSuchPolicyVEHException, NoSuchPolicyHDRException
	{
		return getVehiclePolicy(vehicleSeqCustom, null, null, null, null, null, null, null, null);
	}


	public PolicyHDR getVehiclePolicy(String plateNo, String plateL1, String plateL2, String plateL3, String language) throws NoSuchPolicyVEHException, NoSuchPolicyHDRException
	{
		if (language.equals("en_US") || language.equals("en"))
			return getVehiclePolicy(null, plateNo, plateL1, plateL2, plateL3, null, null, null, null);
		else
			return getVehiclePolicy(null, null, null, null, null, plateNo, plateL1, plateL2, plateL3);
	}



	private PolicyHDR getVehiclePolicy(String vehicleSeqCustom, String enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3, String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3) throws NoSuchPolicyVEHException, NoSuchPolicyHDRException
	{
		List<? extends PersistedModel> policyVehicles = null;
		if (vehicleSeqCustom != null)
			policyVehicles = PolicyVEHLocalServiceUtil.findByVehicleCustomNo(vehicleSeqCustom);
		else if (enPlateNo != null && enPlateL1!= null && enPlateL2!= null && enPlateL3!= null)
			policyVehicles = PolicyVEHLocalServiceUtil.findByEnPlateNo(Long.valueOf(enPlateNo), enPlateL1, enPlateL2, enPlateL3);
		else if (arPlateNo != null && arPlateL1!= null && arPlateL2!= null && arPlateL3!= null)
			policyVehicles = PolicyVEHLocalServiceUtil.findByArPlateNo(arPlateNo, arPlateL1, arPlateL2, arPlateL3);

		if (policyVehicles == null || policyVehicles.isEmpty())
			throw new NoSuchPolicyVEHException();
		else
			return getPolicy(policyVehicles);
	}

	private PolicyHDR getPolicy(List<? extends PersistedModel> objList) throws NoSuchPolicyHDRException
	{
		List<String> policyNumbers = new ArrayList<String>();

		for (Object obj : objList) {
			if (obj instanceof PolicyVEH && ((PolicyVEH)obj).getPolicyNo() != null)
				policyNumbers.add(((PolicyVEH)obj).getPolicyNo());
			else if (obj instanceof CLMNajm && ((CLMNajm)obj).getPolNo() != null)
				policyNumbers.add(((CLMNajm)obj).getPolNo());
		}

		if (policyNumbers.isEmpty())
			return null;
		else
		{
			List<PolicyHDR> policyList = PolicyHDRLocalServiceUtil.findMultiPolicies(policyNumbers.toArray(new String[policyNumbers.size()]));
			if (policyList!= null && !policyList.isEmpty())
				return policyList.iterator().next();
			else
				throw new NoSuchPolicyHDRException();

		}

	}


	public List<CustomerMapDetails> getInsuranceCompanies()
	{
		List<CustomerMap> custs = CustomerMapLocalServiceUtil.findByCustCatgAndType(CUSTOMER_CATG_CUSTOMER, CUSTOMER_TYPE_CUSTOMER);
		List<CustomerMapDetails> cutsList = new ArrayList<>();
		if(custs != null)
			for(CustomerMap cust : custs)
			{
				CustomerMapDetails custDets = new CustomerMapDetails();
				custDets.setCode(cust.getPremiaCode());
				custDets.setName(cust.getName());
				custDets.setNameAr(cust.getNameAr());

				cutsList.add(custDets);
			}
		return cutsList;
	}

	public CLMNajmUploads getNajmFileUploads(String claimRefNo){
		CLMNajmUploads claimNajmUploads = null;
		try {
			claimNajmUploads = CLMNajmUploadsUtil.findByClaimRefNo(claimRefNo);

		} catch (NoSuchCLMNajmUploadsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return claimNajmUploads;
	}

	public void saveODMuroorDoc(String iqamaId,String clmIntimationNo,File driverLicenseFile, String driverLicenseFileName,File vehRegistFile, String vehRegistFileName,File policyCopyFile, String policyCopyFileName)
	{
		ByteArrayFileInputStream driverLicenseInputStream = null;
		ByteArrayFileInputStream vehRegistInputStream = null;
		ByteArrayFileInputStream policyCopyInputStream = null;
		if(driverLicenseFile!=null && driverLicenseFileName!=null)
			driverLicenseInputStream = new ByteArrayFileInputStream(driverLicenseFile, 1024);
		if(vehRegistFile!=null && vehRegistFileName!=null)
			vehRegistInputStream = new ByteArrayFileInputStream(vehRegistFile, 1024);
		if(policyCopyFile!=null && policyCopyFileName!=null)
			policyCopyInputStream = new ByteArrayFileInputStream(policyCopyFile, 1024);

		byte[] driverLicenseData;
		byte[] vehRegistData;
		byte[] policyCopyData;
		try {
			ODMuroorUploads odMuroorUploads= ODMuroorUploadsUtil.create((int) CounterLocalServiceUtil.increment());
			odMuroorUploads.setIqamaId(iqamaId);
			odMuroorUploads.setClaimIntimationNo(clmIntimationNo);

			if(driverLicenseFile!=null && driverLicenseFileName!=null)
			{
				odMuroorUploads.setDriverLicenseName(driverLicenseFileName);
				driverLicenseData = FileUtil.getBytes(driverLicenseInputStream);
				odMuroorUploads.setDriverLicense(new javax.sql.rowset.serial.SerialBlob(driverLicenseData));
			}

			if(vehRegistFile!=null && vehRegistFileName!=null)
			{
				odMuroorUploads.setVehRegistName(vehRegistFileName);
				vehRegistData = FileUtil.getBytes(vehRegistInputStream);
				odMuroorUploads.setVehRegist(new javax.sql.rowset.serial.SerialBlob(vehRegistData));
			}

			if(policyCopyFile!=null && policyCopyFileName!=null)
			{
				odMuroorUploads.setPolicyCopyName(policyCopyFileName);
				policyCopyData = FileUtil.getBytes(policyCopyInputStream);
				odMuroorUploads.setPolicyCopy(new javax.sql.rowset.serial.SerialBlob(policyCopyData));
			}

			ODMuroorUploadsUtil.update(odMuroorUploads);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void saveTPMuroorDoc(String iqamaId,String clmIntimationNo,File driverLicenseFile, String driverLicenseFileName,File vehRegistFile, String vehRegistFileName,File frontPhoto, String frontPhotoName,File rarePhoto, String rarePhotoName,File rightSidePhoto, String rightSidePhotoName,File leftSidePhoto, String leftSidePhotoName,File bankIbanFile, String bankIbanFileName,File ownerIdFile, String ownerIdFileName)
	{
		ByteArrayFileInputStream driverLicenseInputStream = null;
		ByteArrayFileInputStream vehRegistInputStream = null;
		ByteArrayFileInputStream frontPhotoIS = null;
		ByteArrayFileInputStream rarePhotoIS = null;
		ByteArrayFileInputStream rightSidePhotoIS = null;
		ByteArrayFileInputStream leftSidePhotoIS = null;
		ByteArrayFileInputStream bankIbanInputStream = null;
		ByteArrayFileInputStream ownerIdInputStream = null;

		if(driverLicenseFile!=null && driverLicenseFileName!=null)
			driverLicenseInputStream = new ByteArrayFileInputStream(driverLicenseFile, 1024);
		if(vehRegistFile!=null && vehRegistFileName!=null)
			vehRegistInputStream = new ByteArrayFileInputStream(vehRegistFile, 1024);
		if(frontPhoto!=null && frontPhotoName!=null)
			frontPhotoIS = new ByteArrayFileInputStream(frontPhoto, 1024);
		if(rarePhoto!=null && rarePhotoName!=null)
			rarePhotoIS = new ByteArrayFileInputStream(rarePhoto, 1024);
		if(rightSidePhoto!=null && rightSidePhotoName!=null)
			rightSidePhotoIS = new ByteArrayFileInputStream(rightSidePhoto, 1024);
		if(leftSidePhoto!=null && leftSidePhotoName!=null)
			leftSidePhotoIS = new ByteArrayFileInputStream(leftSidePhoto, 1024);
		if(bankIbanFile!=null && bankIbanFileName!=null)
			bankIbanInputStream = new ByteArrayFileInputStream(bankIbanFile, 1024);
		if(ownerIdFile!=null && ownerIdFileName!=null)
			ownerIdInputStream = new ByteArrayFileInputStream(ownerIdFile, 1024);

		byte[] driverLicenseData;
		byte[] vehRegistData;
		byte[] frontPhotoData;
		byte[] rarePhotoData;
		byte[] rightSidePhotoData;
		byte[] leftSidePhotoData;
		byte[] bankIbanData;
		byte[] ownerIdData;
		try {
			MuroorTPUploads tpMuroorUploads= MuroorTPUploadsUtil.create((int) CounterLocalServiceUtil.increment());
			tpMuroorUploads.setIqamaId(iqamaId);
			tpMuroorUploads.setClaimIntimationNo(clmIntimationNo);

			if(driverLicenseFile!=null && driverLicenseFileName!=null)
			{
				tpMuroorUploads.setDriverLicenseName(driverLicenseFileName);
				driverLicenseData = FileUtil.getBytes(driverLicenseInputStream);
				tpMuroorUploads.setDriverLicense(new javax.sql.rowset.serial.SerialBlob(driverLicenseData));
			}

			if(vehRegistFile!=null && vehRegistFileName!=null)
			{
				tpMuroorUploads.setVehRegistName(vehRegistFileName);
				vehRegistData = FileUtil.getBytes(vehRegistInputStream);
				tpMuroorUploads.setVehRegist(new javax.sql.rowset.serial.SerialBlob(vehRegistData));
			}

			if(frontPhoto!=null && frontPhotoName!=null)
			{
				tpMuroorUploads.setFrontPhotoName(frontPhotoName);
				frontPhotoData = FileUtil.getBytes(frontPhotoIS);
				tpMuroorUploads.setFrontPhoto(new javax.sql.rowset.serial.SerialBlob(frontPhotoData));
			}


			if(rarePhoto!=null && rarePhotoName!=null)
			{
				tpMuroorUploads.setRearPhotoName(rarePhotoName);
				rarePhotoData = FileUtil.getBytes(rarePhotoIS);
				tpMuroorUploads.setRearPhoto(new javax.sql.rowset.serial.SerialBlob(rarePhotoData));
			}

			if(rightSidePhoto!=null && rightSidePhotoName!=null)
			{
				tpMuroorUploads.setRightSidePhotoName(rightSidePhotoName);
				rightSidePhotoData = FileUtil.getBytes(rightSidePhotoIS);
				tpMuroorUploads.setRightSidePhoto(new javax.sql.rowset.serial.SerialBlob(rightSidePhotoData));
			}

			if(leftSidePhoto!=null && leftSidePhotoName!=null)
			{
				tpMuroorUploads.setLeftSidePhotoName(leftSidePhotoName);
				leftSidePhotoData = FileUtil.getBytes(leftSidePhotoIS);
				tpMuroorUploads.setLeftSidePhoto(new javax.sql.rowset.serial.SerialBlob(leftSidePhotoData));
			}

			if(bankIbanFile!=null && bankIbanFileName!=null)
			{
				tpMuroorUploads.setBankIbanName(bankIbanFileName);
				bankIbanData = FileUtil.getBytes(bankIbanInputStream);
				tpMuroorUploads.setBankIban(new javax.sql.rowset.serial.SerialBlob(bankIbanData));
			}

			if(ownerIdFile!=null && ownerIdFileName!=null)
			{
				tpMuroorUploads.setOwnerIdName(ownerIdFileName);
				ownerIdData = FileUtil.getBytes(ownerIdInputStream);
				tpMuroorUploads.setOwnerId(new javax.sql.rowset.serial.SerialBlob(ownerIdData));
			}

			MuroorTPUploadsUtil.update(tpMuroorUploads);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<ClaimWorkflow> getRoleWorkflow(String role)
	{
		List<ClaimWorkflow> claimsWorkflow = new ArrayList<ClaimWorkflow>();
		List<CLMWORKFLOW> claims = CLMWORKFLOWUtil.findByrole(role);
		if (claims != null && !claims.isEmpty())
		{
			for (CLMWORKFLOW clmworkflow : claims) {
				ClaimWorkflow claimWorkflow = new ClaimWorkflow();
				claimWorkflow.setAction(clmworkflow.getAction());
				claimWorkflow.setInitialStatus(clmworkflow.getInitialStatus());
				claimWorkflow.setNewStatus(clmworkflow.getNewStatus());
				claimWorkflow.setRole(clmworkflow.getRole());
				claimsWorkflow.add(claimWorkflow);
			}
		}
		return claimsWorkflow;
	}

	private List<ClaimHistory> getCustomClaimHistory(List<CLMSTATUSHISTORY> claimStatusHistoryList) throws PortalException
	{
		List<ClaimHistory> customClaimHistory = new ArrayList<ClaimHistory>();
		for(CLMSTATUSHISTORY clmHis : claimStatusHistoryList)
		{
			ClaimHistory customClmHistory = new ClaimHistory();
			customClmHistory.setHistoryId(clmHis.getId());
			customClmHistory.setReferenceNo(clmHis.getRefNo());
			customClmHistory.setUserName(clmHis.getUserName());
			customClmHistory.setHisoryDate(clmHis.getDate());
			customClmHistory.setStatus(clmHis.getClaimStatus());
			customClmHistory.setReason(clmHis.getReason());
			customClaimHistory.add(customClmHistory);
		}
		return (customClaimHistory);
	}

	private Claim getAdminCustomClaims(Claim customClaim) throws PortalException
	{



		List<ClaimHistory> claimHistory = getCustomClaimHistory(CLMSTATUSHISTORYUtil.findByRefNo(customClaim.getClaimNo()));
		customClaim.setClaimHistory(claimHistory);
		List<ClaimAdminUpload> claimAdminUploads = getCustomClaimAdminUploads(ClaimAdminUploadsUtil.findByrefNo(customClaim.getClaimNo()));
		customClaim.setClaimAdminUpload(claimAdminUploads);

		return customClaim;

	}

	public void saveAdminFiles(String refNo, File adminFile, String fileName)
	{

		ByteArrayFileInputStream inputStream = null;
		inputStream = new ByteArrayFileInputStream(adminFile, 1024);
		byte[] idData;
		try
		{
			ClaimAdminUploads claimAdminUploads = ClaimAdminUploadsUtil.create((int) CounterLocalServiceUtil.increment());
			claimAdminUploads.setRefNo(refNo);;
			claimAdminUploads.setFileName(fileName);
			idData = FileUtil.getBytes(inputStream);
			claimAdminUploads.setAdminFile(new javax.sql.rowset.serial.SerialBlob(idData));
			ClaimAdminUploadsUtil.update(claimAdminUploads);
		}
		catch (IOException e)
		{
			_log.error(e.getMessage());
			e.printStackTrace();
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void removeAdminFiles(int fileId)
	{
		try
		{
			ClaimAdminUploadsUtil.remove(fileId);
		}
		catch (NoSuchClaimAdminUploadsException e)
		{
			_log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<ClaimWorkflow> getRoleWorkflowByRoleStatus(String role,String status)
	{
		List<ClaimWorkflow> claimsWorkflow = new ArrayList<ClaimWorkflow>();
		List<CLMWORKFLOW> claims = CLMWORKFLOWUtil.findByroleStatus(role,status);
		if (claims != null && !claims.isEmpty())
		{
			for (CLMWORKFLOW clmworkflow : claims) {
				ClaimWorkflow claimWorkflow = new ClaimWorkflow();
				claimWorkflow.setAction(clmworkflow.getAction());
				claimWorkflow.setInitialStatus(clmworkflow.getInitialStatus());
				claimWorkflow.setNewStatus(clmworkflow.getNewStatus());
				claimWorkflow.setRole(clmworkflow.getRole());
				claimsWorkflow.add(claimWorkflow);
			}
		}
		return claimsWorkflow;
	}

	public ODMuroorUploads getMuroorODFileUploads(String claimRefNo){
		ODMuroorUploads odMuroorUploads = null;
		try {
			odMuroorUploads = ODMuroorUploadsUtil.findByclaimIntimationNo(claimRefNo);
		} catch (NoSuchODMuroorUploadsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return odMuroorUploads;
	}

	public MuroorTPUploads getMuroorTPFileUploads(String claimRefNo){
		MuroorTPUploads tpMuroorUploads = null;
		try {
			tpMuroorUploads = MuroorTPUploadsUtil.findByclaimIntimationNo(claimRefNo);
		} catch (NoSuchMuroorTPUploadsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tpMuroorUploads;
	}

	public void addWorkflowStatus(String claimRefNo) throws PortalException
	{
		doUpdateWorkflowStatus(claimRefNo,USERNAME_CUSTOMER, STATUS_SUBMITTED, "", true);
	}

	public void updateWorkflowStatus(String claimRefNo, String username, String newStatus, String reason) throws PortalException
	{
		doUpdateWorkflowStatus(claimRefNo, username, newStatus, reason, false);
	}

	private void doUpdateWorkflowStatus(String claimRefNo, String username , String newStatus, String reason,boolean isNew) throws PortalException
	{
		CLMSTATUS claimStatus;
		if (isNew)
			claimStatus = CLMSTATUSLocalServiceUtil.createCLMSTATUS(claimRefNo);
		else
			claimStatus = CLMSTATUSLocalServiceUtil.getCLMSTATUS(claimRefNo);

		claimStatus.setClaimStatus(newStatus);
		CLMSTATUSLocalServiceUtil.updateCLMSTATUS(claimStatus);


		CLMSTATUSHISTORY claimStatusHistory = CLMSTATUSHISTORYLocalServiceUtil.createCLMSTATUSHISTORY((int)counterLocalService.increment());
		claimStatusHistory.setRefNo(claimRefNo);
		claimStatusHistory.setReason(reason);
		claimStatusHistory.setClaimStatus(newStatus);
		claimStatusHistory.setDate(new Date());
		claimStatusHistory.setUserName(username);

		CLMSTATUSHISTORYLocalServiceUtil.updateCLMSTATUSHISTORY(claimStatusHistory);

	}

	private List<ClaimAdminUpload> getCustomClaimAdminUploads(List<ClaimAdminUploads> claimAdminUploadsList) throws PortalException
	{
		List<ClaimAdminUpload> customClaimAdminUploads = new ArrayList<ClaimAdminUpload>();
		for(ClaimAdminUploads clmAdminUploads : claimAdminUploadsList)
		{
			ClaimAdminUpload customAdminUploads = new ClaimAdminUpload();
			customAdminUploads.setId(clmAdminUploads.getId());
			customAdminUploads.setRefNo(clmAdminUploads.getRefNo());
			customAdminUploads.setFileName(clmAdminUploads.getFileName());
			customClaimAdminUploads.add(customAdminUploads);
		}
		return (customClaimAdminUploads);
	}

	public String submitClaimFn(String referenceno,String source,String transaction,String policyno,String reportmode,String reportno,String vehidentitype,String vehidentivalue,String lossnature,String losscause,String lossdate,String lossremarks,int faultpercent,String losslocation,String tpdrivername,String tpdob,String tpid,String tpvehidentitype ,String tpvehidentivalue,String tpplateno,String tpinsco,String tpmobile,String tpiban, String tpnationality,double amount,String damageflag) throws PortalException{
		ODSClaimIntimation odsClaimInt= new ODSClaimIntimation();

		odsClaimInt.setReferenceno(referenceno);
		odsClaimInt.setSource(source);
		odsClaimInt.setTransaction(transaction);
		odsClaimInt.setPolicyno(policyno);
		odsClaimInt.setReportmode(reportmode);
		odsClaimInt.setReportno(reportno);
		odsClaimInt.setVehidentitype(tpvehidentitype);
		odsClaimInt.setVehidentivalue(tpvehidentivalue);
		odsClaimInt.setLossnature(lossnature);
		odsClaimInt.setLosscause(losscause);
		odsClaimInt.setLossdate(lossdate);
		odsClaimInt.setLossremarks(lossremarks);
		odsClaimInt.setFaultpercent(faultpercent);
		odsClaimInt.setLosslocation(losslocation);
		odsClaimInt.setTpdrivername(tpdrivername);
		odsClaimInt.setTpdob(tpdob);
		odsClaimInt.setTpid(tpid);
		odsClaimInt.setTpvehidentitype(tpvehidentitype);
		odsClaimInt.setTpvehidentivalue(tpvehidentivalue);
		odsClaimInt.setTpplateno(tpplateno);
		odsClaimInt.setTpinsco(tpinsco);
		odsClaimInt.setTpmobile(tpmobile);
		odsClaimInt.setTpiban(tpiban);
		odsClaimInt.setTpnationality(tpnationality);
		odsClaimInt.setAmount(amount);
		odsClaimInt.setDamageflag(damageflag);
		try{
			submitClaim(odsClaimInt);
			return "success";
		}catch (Exception e) {
			// TODO: handle exception
			return "failed";
		}

	}

	public List<Object[]> getNajmUploadsFilesName(String refNo){
		List<Object[]> filesName=CLMNajmUploadsLocalServiceUtil.findFilesNames(refNo);
		return filesName;
	}

	public HashMap<String,Object> getClaimsOutline(String iqamaId) throws PortalException
	{
		_log.info("getClaimsOutline for id:" + iqamaId);
		HashMap<String, Object> summary = new HashMap<String, Object>();
		List<ClaimHDR> claimsList = ClaimHDRLocalServiceUtil.findClaimsByExcludeStatus(iqamaId, STATUS_CLOSED);
		_log.info("Outline retrieved count:" + claimsList.size());
		summary.put("CLAIMS_COUNT", claimsList.size());
		if(claimsList.size()>0)
		{
			summary.put("LAST_UPDATE", claimsList.get(0).getClaimIntmDate());
		}
		return summary;
	}



	public ClaimIntimation intimateClaim(String claimType, String vehicleIdentType, String vehicleIdentNumber, String plateL1, String plateL2, String plateL3, String reportMode, String reportNumber, String causeOfLoss, String natureOfLoss, Locale locale) throws Exception
	{
		ClaimIntimation feClaimIntimation = new ClaimIntimation();
		ODSClaimIntimation odsClaimIntimation = new ODSClaimIntimation();
		NajmClaimIntimation najmClaimIntimation=null;

		if (claimType.equals(CLAIM_TYPE_PROPERTY))
		{
			// property claims are always third party
			odsClaimIntimation.setTransaction(TRX_TPL);

			if (reportMode.equals(REPORT_MODE_NAJM))
			{
				List<NajmClaim> najmClaims = getNajmClaimByCaseNo(reportNumber);
				if (najmClaims == null || najmClaims.isEmpty())
				{
					_log.error("ClaimIntimationERROR:Invalid Najm case number");
					throw new NoSuchNajmCaseNoException();
				}
			}

			if (vehicleIdentType.equals(VEHICLE_IDENT_TYPE_CUSTOM))
			{
				_log.info("ClaimIntimation:Vehicle Ident Type CUSTOM");
				odsClaimIntimation.setVehidentitype(vehicleIdentType);
				odsClaimIntimation.setVehidentivalue(vehicleIdentNumber);
				PolicyHDR atmcPolicy = getVehiclePolicy(vehicleIdentNumber);
				odsClaimIntimation.setPolicyno(atmcPolicy.getPolicyNo());

			}
			else
			{
				String vehicleIdentValue = plateL1 + "-" + plateL2 + "-" + plateL3 + "-" + vehicleIdentNumber;

				odsClaimIntimation.setVehidentitype(vehicleIdentType);
				odsClaimIntimation.setVehidentivalue(vehicleIdentValue);

				PolicyHDR atmcPolicy = getVehiclePolicy(vehicleIdentNumber, plateL1, plateL2, plateL3, locale.toString());
				odsClaimIntimation.setPolicyno(atmcPolicy.getPolicyNo());

			}

		}
		else
		{

			if (vehicleIdentType.equals(VEHICLE_IDENT_TYPE_CUSTOM))
			{
				_log.info("ClaimIntimation:Vehicle Ident Type CUSTOM");

				if (reportMode.equals(REPORT_MODE_NAJM))
				{
					_log.info("ClaimIntimation:REPORT MODE NAJM");

					najmClaimIntimation  = getNajmClaimIntimationByCustomId(reportNumber, vehicleIdentNumber,locale.toString());
					najmClaimIntimation.setClaimantVehicleType(VEHICLE_IDENT_TYPE_CUSTOM);
					najmClaimIntimation.setClaimantVehicleNumber(vehicleIdentNumber);

					setNajmPolicyNumber(najmClaimIntimation,odsClaimIntimation);
					setNajmTransaction(najmClaimIntimation, odsClaimIntimation);
				}
				else
				{
					_log.info("ClaimIntimation:REPORT MODE MUROOR");
					PolicyHDR claimantPolicy = null;
					try
					{
						claimantPolicy = getVehiclePolicy(vehicleIdentNumber);
						if (claimantPolicy!= null)
							odsClaimIntimation.setPolicyno(claimantPolicy.getPolicyNo());

					}
					catch(Exception e)
					{
						_log.info("given vehicle custom number does not exist.MUROOR TP CASE");
					}

					setMuroorTransaction(claimantPolicy, odsClaimIntimation);
					setMuroorVehicleIdent(odsClaimIntimation, vehicleIdentType, vehicleIdentNumber);
				}

			}
			else
			{
//					String plateL1 = ParamUtil.getString(request, "plateL1");
//					String plateL2 = ParamUtil.getString(request, "plateL2");
//					String plateL3 = ParamUtil.getString(request, "plateL3");
//					String plateNumber = ParamUtil.getString(request, "plateNumber");
				String vehicleIdentValue = plateL1 + "-" + plateL2 + "-" + plateL3 + "-" + vehicleIdentNumber;
				String plateNumberBE = vehicleIdentNumber +  " " + plateL1 + " " + plateL2 + " " + plateL3;

				//claimIntimation.setVehidentivalue(vehicleIdentValue);

				if (reportMode.equals(REPORT_MODE_NAJM))
				{

					najmClaimIntimation  = getNajmClaimIntimationByPlateNumber(reportNumber, plateNumberBE,locale.toString());
					najmClaimIntimation.setClaimantVehicleType(VEHICLE_IDENT_TYPE_PLATE_NUMBER);
					najmClaimIntimation.setClaimantVehicleNumber(vehicleIdentValue);

					setNajmPolicyNumber(najmClaimIntimation,odsClaimIntimation);
					setNajmTransaction(najmClaimIntimation, odsClaimIntimation);
				}
				else
				{
					_log.info("ClaimIntimationPortlet:REPORT MODE MUROOR");
					PolicyHDR claimantPolicy = null;
					try
					{
						claimantPolicy = getVehiclePolicy(vehicleIdentNumber, plateL1, plateL2, plateL3, locale.toString());
						if (claimantPolicy!= null)
							odsClaimIntimation.setPolicyno(claimantPolicy.getPolicyNo());

					}
					catch(Exception e)
					{
						_log.info("given vehicle plate number does not exist.MUROOR TP CASE");
					}

					setMuroorTransaction(claimantPolicy, odsClaimIntimation);
					setMuroorVehicleIdent(odsClaimIntimation, vehicleIdentType, vehicleIdentValue);

				}

			}


		}


		odsClaimIntimation.setDamageflag(claimType);
		odsClaimIntimation.setReportmode(reportMode);
		odsClaimIntimation.setReportno(reportNumber);
		odsClaimIntimation.setLosscause(causeOfLoss);
		odsClaimIntimation.setLossnature(natureOfLoss);


		feClaimIntimation.setOdsClaimIntimation(odsClaimIntimation);
		feClaimIntimation.setNajmClaimIntimation(najmClaimIntimation);

		return feClaimIntimation;

	}

	private void setNajmTransaction(NajmClaimIntimation najmClaimIntimation, ODSClaimIntimation claimIntimation)
	{
		if (!najmClaimIntimation.isClaimantATMC())
		{
			_log.info("ClaimIntimationPortlet:NAjm Transaction Type TPL. Claimant is not ATMC");
			claimIntimation.setTransaction(TRX_TPL);
		}
		else
		{
			if (najmClaimIntimation.getClaimantPolicyType().equals(PRODUCT_COMPREHENSIVE))
			{
				_log.info("ClaimIntimationPortlet:NAjm Transaction Type COMPREHENSIVE. Claimant Policy of type COMPREHENSIVE");
				claimIntimation.setTransaction(TRX_COMPREHENSIVE);
			}
			else
			{
				_log.info("ClaimIntimationPortlet:NAjm Transaction Type TPL. Claimant Policy of type TPL");
				claimIntimation.setTransaction(TRX_TPL);
			}

		}

	}


	private void setMuroorTransaction(PolicyHDR claimantPolicy, ODSClaimIntimation claimIntimation)
	{
		if (claimantPolicy == null)
		{
			_log.info("ClaimIntimationPortlet:Muroor Transaction Type TPL. Claimant Policy NULL");
			claimIntimation.setTransaction(TRX_TPL);
		}
		else
		{
			if (claimantPolicy.getProduct().equals(PRODUCT_COMPREHENSIVE))
			{
				_log.info("ClaimIntimationPortlet:Muroor Transaction Type COMPREHENSIVE. Claimant Policy of type COMPREHENSIVE");
				claimIntimation.setTransaction(TRX_COMPREHENSIVE);
			}
			else
			{
				_log.info("ClaimIntimationPortlet:Muroor Transaction Type TPL. Claimant Policy of type TPL");
				claimIntimation.setTransaction(TRX_TPL);
			}

		}

	}

	private void setMuroorVehicleIdent(ODSClaimIntimation claimIntimation,String vehicleIdentType, String vehicleIdentValue)
	{
		if(claimIntimation.getTransaction().equals(TRX_TPL)){
			claimIntimation.setVehidentitype(vehicleIdentType);
			claimIntimation.setTpvehidentitype(vehicleIdentType);
			claimIntimation.setTpvehidentivalue(vehicleIdentValue);
			claimIntimation.setTpplateno(vehicleIdentValue);

		}
		else
		{
			claimIntimation.setVehidentitype(vehicleIdentType);
			claimIntimation.setVehidentivalue(vehicleIdentValue);

		}

	}


	private void setNajmPolicyNumber(NajmClaimIntimation najmClaimIntimation, ODSClaimIntimation claimIntimation)
	{
		if (!najmClaimIntimation.isClaimantATMC() || (najmClaimIntimation.isClaimantATMC() && najmClaimIntimation.isOtherPartyATMC()))
		{
			_log.info("ClaimIntimationPortlet:Setting Policy Number to Other Party Policy number.");
			claimIntimation.setPolicyno(najmClaimIntimation.getOtherParty().getPolNo());
		}
		else if (najmClaimIntimation.isClaimantATMC() && !najmClaimIntimation.isOtherPartyATMC())
		{
			_log.info("ClaimIntimationPortlet:Setting Policy Number to Claimant Policy number.");
			claimIntimation.setPolicyno(najmClaimIntimation.getClaimant().getPolNo());
		}

	}

	public byte[] findNajmSlipFile(int id){
		CLMNajmUploadsNajmSlipBlobModel najm=CLMNajmUploadsLocalServiceUtil.getNajmSlipBlobModel(id);
		byte[] najmSlipFile;
		try {
			najmSlipFile = najm.getNajmSlipBlob().getBytes(1, (int)najm.getNajmSlipBlob().length());
			System.out.println(najmSlipFile);
			return najmSlipFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}



	public byte[] findDamageEstQuotFile(int id){
		CLMNajmUploadsDamageEstQuotBlobModel najm=CLMNajmUploadsLocalServiceUtil.getDamageEstQuotBlobModel(id);
		byte[] damageEstQuotFile;
		try {
			damageEstQuotFile = najm.getDamageEstQuotBlob().getBytes(1, (int)najm.getDamageEstQuotBlob().length());
			return damageEstQuotFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	public byte[] findBankIbanFile(int id){
		CLMNajmUploadsBankIbanBlobModel najm=CLMNajmUploadsLocalServiceUtil.getBankIbanBlobModel(id);
		byte[] bankIbanFile;
		try {
			bankIbanFile = najm.getBankIbanBlob().getBytes(1, (int)najm.getBankIbanBlob().length());
			return bankIbanFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	public byte[] findOwnerIdFile(int id){
		CLMNajmUploadsOwnerIdBlobModel najm=CLMNajmUploadsLocalServiceUtil.getOwnerIdBlobModel(id);
		byte[] ownerIdFile;
		try {
			ownerIdFile = najm.getOwnerIdBlob().getBytes(1, (int)najm.getOwnerIdBlob().length());
			return ownerIdFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public List<Claim> getClaimsSummaryFiter(String iqamaId,String status,String policyType ) throws PortalException
	{
		List<Object[]> claimsHdrList = ClaimHDRLocalServiceUtil.findClaimsPolicyStatus( iqamaId,status, policyType,null,null);
		List<Claim> claimsList = getClaimsWithPolicyDStausetails(claimsHdrList);
		System.out.println(claimsHdrList.size());

		return claimsList;
	}


	private List<Claim> getClaimsWithPolicyDStausetails(List<Object[]> claimsPolicyList) throws PortalException
	{
		List<Claim> claimList = new ArrayList<>();

		if(claimsPolicyList != null && !claimsPolicyList.isEmpty())
		{
			for(Object[] claimPolicy : claimsPolicyList)
			{

				ClaimHDR claimHdr = (ClaimHDR)claimPolicy[0];
				CLMSTATUS claimStatus=(CLMSTATUS)claimPolicy[1];

				Claim claim = getCustomClaim(claimHdr);
				claim.setProduct(claimHdr.getProdCode());
				claim.setProductDescAr(claimHdr.getProductDescAr());
				claim.setProductDescEn(claimHdr.getProductDescEn());
				if(claimStatus!=null)
					claim.setWorkflowStatus(claimStatus.getClaimStatus());
				claimList.add(claim);

			}

		}
		return claimList;

	}
	public void saveNajmSubmitedFiles(String caseNo,String cipiId,File najmSlipFile, String najmSlipFileName,File damageEstQuotFile, String damageEstQuotFileName,File bankIbanFile, String bankIbanFileName,File ownerIdFile,String ownerIdFileName,String claimRefNo){
		ByteArrayFileInputStream najmSlipInputStream = null;
		ByteArrayFileInputStream damageEstQuotInputStream = null;
		ByteArrayFileInputStream bankIbanInputStream = null;
		ByteArrayFileInputStream ownerIdInputStream = null;

		if(najmSlipFile!=null && !najmSlipFileName.equals("null")){
			najmSlipInputStream = new ByteArrayFileInputStream(najmSlipFile, 1024);
		}
		if(damageEstQuotFile!=null && !damageEstQuotFileName.equals("null") )
		{
			damageEstQuotInputStream = new ByteArrayFileInputStream(damageEstQuotFile, 1024);
		}
		if(bankIbanFile!=null && !bankIbanFileName.equals("null"))
		{
			bankIbanInputStream = new ByteArrayFileInputStream(bankIbanFile, 1024);
		}
		if(ownerIdFile!=null && !ownerIdFileName.equals("null"))
		{
			ownerIdInputStream = new ByteArrayFileInputStream(ownerIdFile, 1024);
		}
		byte[] najmSlipData;
		byte[] damageEstQuotData;
		byte[] bankIbanData;
		byte[] ownerIdData;
		try {
			CLMNajmUploads clmNajmuploads=CLMNajmUploadsUtil.create((int) CounterLocalServiceUtil.increment());
			clmNajmuploads.setCaseNo(caseNo);
			clmNajmuploads.setCipiId(cipiId);
			clmNajmuploads.setClaimRefNo(claimRefNo);
			if(najmSlipFile!=null && !najmSlipFileName.equals("null")){
				clmNajmuploads.setNajmSlipName(najmSlipFileName);
				najmSlipData = FileUtil.getBytes(najmSlipInputStream);
				clmNajmuploads.setNajmSlip(new javax.sql.rowset.serial.SerialBlob(najmSlipData));

			}
			if(damageEstQuotFile!=null && !damageEstQuotFileName.equals("null") )
			{
				clmNajmuploads.setDamageEstQuotName(damageEstQuotFileName);
				damageEstQuotData = FileUtil.getBytes(damageEstQuotInputStream);
				clmNajmuploads.setDamageEstQuot(new javax.sql.rowset.serial.SerialBlob(damageEstQuotData));

			}
			if(bankIbanFile!=null && !bankIbanFileName.equals("null"))
			{
				clmNajmuploads.setBankIbanName(bankIbanFileName);
				bankIbanData = FileUtil.getBytes(bankIbanInputStream);
				clmNajmuploads.setBankIban(new javax.sql.rowset.serial.SerialBlob(bankIbanData));

			}
			if(ownerIdFile!=null && !ownerIdFileName.equals("null"))
			{
				clmNajmuploads.setOwnerIdName(ownerIdFileName);
				ownerIdData = FileUtil.getBytes(ownerIdInputStream);
				clmNajmuploads.setOwnerId(new javax.sql.rowset.serial.SerialBlob(ownerIdData));

			}
			CLMNajmUploadsUtil.update(clmNajmuploads);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public File downloadClaimReport(ODSClaimIntimation odsClaimInt,String claimintName, String claimintMobile, String claimintEmail, String claimintId,String lang){
		_log.info("downloadClaimReport start");

		NajmClaimReportObj najmClaimReportObj= new NajmClaimReportObj();

		_log.info("Path:" + PropsUtil.get("com.ejada.atmc.claim.report.path"));
		File directory = new File(PropsUtil.get("com.ejada.atmc.claim.report.path"));
		if (! directory.exists()){
			directory.mkdirs();
		}

		File qFile = new File(PropsUtil.get("com.ejada.atmc.claim.report.path")+"/claim"+odsClaimInt.getReferenceno()+".pdf");
		if(!qFile.exists())
			try {
				qFile.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(qFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		_log.info("Product type:" + odsClaimInt.getTransaction());

		if(odsClaimInt.getTransaction().equals(TRX_TPL)){
			_log.info("TPL");
			Locale locale = new Locale("ar","SA");
			najmClaimReportObj.setClaimantName(claimintName);
			najmClaimReportObj.setClaimNo(odsClaimInt.getReferenceno());
			Policy policyData;
			if(odsClaimInt.getReportmode().equals(REPORT_MODE_MUROOR))
			{
				String[] plateData = odsClaimInt.getTpplateno().split("-");
				String plateNo = plateData[3];
				String l1 = plateData[0];
				String l2 = plateData[1];
				String l3 = plateData[2];

				try{
					policyData = PolicyLocalServiceUtil.getVehiclePolicyData(plateNo, l1, l2, l3, lang);

					if(policyData!= null)
						najmClaimReportObj.setPolicyNo(odsClaimInt.getPolicyno());
					else
						najmClaimReportObj.setPolicyNo("");
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				najmClaimReportObj.setPolicyNo(odsClaimInt.getPolicyno());
			}
			najmClaimReportObj.setClaimAmount(odsClaimInt.getAmount());
			najmClaimReportObj.setDamageFlag(odsClaimInt.getDamageflag());
			najmClaimReportObj.setPlateNoAr(odsClaimInt.getTpplateno());
			najmClaimReportObj.setClaimantEmail(claimintEmail);
			najmClaimReportObj.setClaimantIqamaId(claimintId);

			najmClaimReportObj.setClaimantPhoneNo(claimintMobile);
			najmClaimReportObj.setInsuredDOb(odsClaimInt.getTpdob());
			najmClaimReportObj.setLossLocation(odsClaimInt.getAccidentLocation());
			najmClaimReportObj.setLossDate(odsClaimInt.getLossdate());
			najmClaimReportObj.setReportType(LanguageUtil.get(locale, "claim_status_"+odsClaimInt.getReportmode()));
			najmClaimReportObj.setReportNo(odsClaimInt.getReportno());
			najmClaimReportObj.setFaultPercent(odsClaimInt.getFaultpercent());
			najmClaimReportObj.setLossRemarks(odsClaimInt.getLossremarks());
			najmClaimReportObj.setIban(odsClaimInt.getTpiban());
			najmClaimReportObj.setClaimDate((new Date()).toString());

			List<NajmClaimReportObj> najmClaimReportObjList= new ArrayList<>();
			najmClaimReportObjList.add(najmClaimReportObj);


			HashMap<String,Object> najmClaimParam= new HashMap<String,Object>();

			najmClaimParam.put("reportTitle",LanguageUtil.get(locale , "report_title"));
			najmClaimParam.put("claimNo", LanguageUtil.get(locale, "claim_no"));
			najmClaimParam.put("firstReportHeader", LanguageUtil.get(locale, "first_report_header"));
			najmClaimParam.put("firstReportTip", LanguageUtil.get(locale, "first_report_tip"));
			najmClaimParam.put("policyNo", LanguageUtil.get(locale, "policy_no"));
			najmClaimParam.put("compensationAmount", LanguageUtil.get(locale, "compensation_amount"));
			najmClaimParam.put("currency", LanguageUtil.get(locale, "currency"));
			najmClaimParam.put("claimType", LanguageUtil.get(locale, "claim_type"));
			najmClaimParam.put("car", LanguageUtil.get(locale, "car"));
			najmClaimParam.put("injuries", LanguageUtil.get(locale, "injuries"));
			najmClaimParam.put("fire", LanguageUtil.get(locale, "fire"));
			najmClaimParam.put("poperties", LanguageUtil.get(locale, "poperties"));
			najmClaimParam.put("deaths", LanguageUtil.get(locale, "deaths"));
			najmClaimParam.put("others", LanguageUtil.get(locale, "others"));
			najmClaimParam.put("ownerName", LanguageUtil.get(locale, "owner_name"));
			najmClaimParam.put("ownerIqamaId", LanguageUtil.get(locale, "owner_iqama_id"));
			najmClaimParam.put("ownerEmail", LanguageUtil.get(locale, "owner_email"));
			najmClaimParam.put("ownerPhone", LanguageUtil.get(locale, "owner_phone"));
			najmClaimParam.put("postalCode", LanguageUtil.get(locale, "postal_code"));
			najmClaimParam.put("driverIqamaId", LanguageUtil.get(locale, "driver_iqama_id"));
			najmClaimParam.put("driverName", LanguageUtil.get(locale, "driver_name"));
			najmClaimParam.put("driverDob", LanguageUtil.get(locale, "drivers_age"));
			najmClaimParam.put("driverCarOwner", LanguageUtil.get(locale, "driver_car_owner"));
			najmClaimParam.put("yes", LanguageUtil.get(locale, "yes"));
			najmClaimParam.put("no", LanguageUtil.get(locale, "no"));
			najmClaimParam.put("secReportHeader", LanguageUtil.get(locale, "sec_report_header"));
			najmClaimParam.put("accLocation", LanguageUtil.get(locale, "acc_location"));
			najmClaimParam.put("accTime", LanguageUtil.get(locale, "acc_time"));
			najmClaimParam.put("pm", LanguageUtil.get(locale, "pm"));
			najmClaimParam.put("am", LanguageUtil.get(locale, "am"));
			najmClaimParam.put("reportMode", LanguageUtil.get(locale, "report_mode"));
			najmClaimParam.put("reportNo", LanguageUtil.get(locale, "report_no"));
			najmClaimParam.put("faultPercent", LanguageUtil.get(locale, "fault_percent"));
			najmClaimParam.put("plateNo", LanguageUtil.get(locale, "third_party_plate_no"));
			najmClaimParam.put("secReportTip", LanguageUtil.get(locale, "sec_report_tip"));
			najmClaimParam.put("reportIban", LanguageUtil.get(locale, "report_iban"));
			najmClaimParam.put("claimantPresented", LanguageUtil.get(locale, "claimant_presented"));
			najmClaimParam.put("carOwner", LanguageUtil.get(locale, "car_owner"));
			najmClaimParam.put("anotherPerson", LanguageUtil.get(locale, "another_person"));
			najmClaimParam.put("claimantIqamaId", LanguageUtil.get(locale, "claimant_iqama_id"));
			najmClaimParam.put("claimantMobile", LanguageUtil.get(locale, "claimant_mobile"));
			najmClaimParam.put("date", LanguageUtil.get(locale, "date"));
			najmClaimParam.put("signature", LanguageUtil.get(locale, "signature"));
			najmClaimParam.put("phoneNo", LanguageUtil.get(locale, "phone_no"));
			najmClaimParam.put("claimantName", LanguageUtil.get(locale, "claimant_name"));
			najmClaimParam.put("thirdReportHeader", LanguageUtil.get(locale, "third_report_header"));
			najmClaimParam.put("thirdReportTip", LanguageUtil.get(locale, "third_report_tip"));
			najmClaimParam.put("fourthReportTip", LanguageUtil.get(locale, "fourth_report_tip"));
			najmClaimParam.put("najm", LanguageUtil.get(locale, "najm_status_3"));

			najmClaimParam.put("claimantEmail", najmClaimReportObj.getClaimantEmail());
			najmClaimParam.put("claimantPhoneNo", najmClaimReportObj.getClaimantPhoneNo());
			najmClaimParam.put("iban", najmClaimReportObj.getIban());

			System.out.println(najmClaimReportObjList.get(0).getClaimNo());
			System.out.println(najmClaimReportObjList.get(0).getPolicyNo());
			//response.setProperty("Content-Disposition", "attachment; filename=\"" + "claimTPL.pdf"+ "\"");
			try {
				ReportsUtil.fillAndExportPDFReport("claimTPL.jasper", najmClaimReportObjList,najmClaimParam, fos);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else{
			_log.info("OD");
			Policy policyData = null;
			try {
				policyData = PolicyLocalServiceUtil.findPolicyByPolicyNo(odsClaimInt.getPolicyno());
			} catch (PortalException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			String[] plateData = odsClaimInt.getVehidentivalue().split("-");
			String plateNo = plateData[3];
			String l1 = plateData[0];
			String l2 = plateData[1];
			String l3 = plateData[2];

			List<PolicyVEH> policyVehs = null;
			if(lang.equals("en_US"))
			{
				try {
					policyVehs = PolicyVEHLocalServiceUtil.findByEnPlateNo(Long.valueOf(plateNo), l1, l2, l3);
				} catch (NoSuchPolicyVEHException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				try {
					policyVehs = PolicyVEHLocalServiceUtil.findByArPlateNo(plateNo, l1, l2, l3);
				} catch (NoSuchPolicyVEHException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ClaimODReportObj odReportObj = new ClaimODReportObj();
			if(policyVehs!=null && !policyVehs.isEmpty() ){
				PolicyVEH policyVeh = policyVehs.get(0);
				if(lang.equals("en_US"))
				{
					odReportObj.setMake(policyVeh.getMakeDescEn());
				}
				else
				{
					odReportObj.setMake(policyVeh.getMakeDescAr());
				}
				odReportObj.setMfgYr(policyVeh.getMfgYear());

			}else{
				odReportObj.setMake("");
				odReportObj.setMfgYr(null);
			}
			odReportObj.setPolicyNo(odsClaimInt.getPolicyno());
			odReportObj.setInsuredEmail(claimintEmail);
			odReportObj.setInsuredName(claimintName);
			odReportObj.setInsuredMobNo(claimintMobile);

			odReportObj.setPlateNo(odsClaimInt.getVehidentivalue());
			SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
			odReportObj.setExpiryDate(dateFormatter.format(policyData.getExpiryDate()));
			if(odsClaimInt.getReportmode().equals(REPORT_MODE_MUROOR))
			{
				odReportObj.setAccidentDate(odsClaimInt.getAccidentDate());
				try {
					SimpleDateFormat formate = new SimpleDateFormat("hh:mm a");
					SimpleDateFormat oldFormat = new SimpleDateFormat("hh:mm");
					Date accidentDateTime = oldFormat.parse(odsClaimInt.getAccidentTime());
					String accTime=formate.format(accidentDateTime);
					odReportObj.setTimeGroup(accTime.split(" ")[1]);
					odReportObj.setAccidentTime(accTime.split(" ")[0]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			else
			{
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy hhmm");
				Date accDate = null;
				try {
					accDate = sdf.parse(odsClaimInt.getLossdate());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				SimpleDateFormat formate = new SimpleDateFormat("hh:mm a");
				String accTime=formate.format(accDate);
				System.out.println(formate.format(accDate));
				odReportObj.setAccidentDate(odsClaimInt.getLossdate().split(" ")[0]);
				odReportObj.setAccidentTime(accTime.split(" ")[0]);
				odReportObj.setTimeGroup(accTime.split(" ")[1]);
			}

			odReportObj.setAccidentCity(odsClaimInt.getAccidentLocation());
			odReportObj.setDamageFlag(odsClaimInt.getDamageflag());
			odReportObj.setTransaction(odsClaimInt.getTransaction());

			Customer cust = CustomerLocalServiceUtil.fetchCustomer(policyData.getInsuredId());
			odReportObj.setInsuredZIPCode(cust.getZipCode());
			try{
				String city = CodeMasterDetailsLocalServiceUtil.getCodeMasterDesc(CITY_CODE, cust.getCity(), lang);
				odReportObj.setInsuredCity(city);
			}
			catch(PortalException e)
			{
				e.printStackTrace();
			}

			odReportObj.setDescription(odsClaimInt.getLossremarks());

			List<ClaimODReportObj> claimReportObjList= new ArrayList<ClaimODReportObj>();
			claimReportObjList.add(odReportObj);

			try {
				ReportsUtil.fillAndExportPDFReport("ClaimODReport.jasper", claimReportObjList,null, fos);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return qFile;

	}

	public byte[] adminUploadFile(int id){
		ClaimAdminUploadsAdminFileBlobModel admin=ClaimAdminUploadsLocalServiceUtil.getAdminFileBlobModel(id);
		byte[] ownerIdFile;
		try {
			ownerIdFile = admin.getAdminFileBlob().getBytes(1, (int)admin.getAdminFileBlob().length());
			return ownerIdFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	public int findClaimsCountsPolicyStatusAdmin(String status,String Surveyor,String refNo) throws PortalException{
		return ClaimHDRLocalServiceUtil.findClaimsCountsPolicyStatusAdmin(status,Surveyor,refNo);
	}


	public void updateNajmSubmitedFiles(String  claimNumber,String username,String reason,File najmSlipFile, String najmSlipFileName,File damageEstQuotFile, String damageEstQuotFileName,File bankIbanFile, String bankIbanFileName,File ownerIdFile,String ownerIdFileName){
		ByteArrayFileInputStream najmSlipInputStream = null;
		ByteArrayFileInputStream damageEstQuotInputStream = null;
		ByteArrayFileInputStream bankIbanInputStream = null;
		ByteArrayFileInputStream ownerIdInputStream = null;

		if(najmSlipFile!=null && !najmSlipFileName.equals("null")){
			najmSlipInputStream = new ByteArrayFileInputStream(najmSlipFile, 1024);
		}
		if(damageEstQuotFile!=null && !damageEstQuotFileName.equals("null") )
		{
			damageEstQuotInputStream = new ByteArrayFileInputStream(damageEstQuotFile, 1024);
		}
		if(bankIbanFile!=null && !bankIbanFileName.equals("null"))
		{
			bankIbanInputStream = new ByteArrayFileInputStream(bankIbanFile, 1024);
		}
		if(ownerIdFile!=null && !ownerIdFileName.equals("null"))
		{
			ownerIdInputStream = new ByteArrayFileInputStream(ownerIdFile, 1024);
		}
		byte[] najmSlipData;
		byte[] damageEstQuotData;
		byte[] bankIbanData;
		byte[] ownerIdData;
		try {
			CLMNajmUploads clmNajmuploads=CLMNajmUploadsUtil.findByClaimRefNo(claimNumber);

			if(najmSlipFile!=null && !najmSlipFileName.equals("null")){
				clmNajmuploads.setNajmSlipName(najmSlipFileName);
				najmSlipData = FileUtil.getBytes(najmSlipInputStream);
				clmNajmuploads.setNajmSlip(new javax.sql.rowset.serial.SerialBlob(najmSlipData));

			}
			if(damageEstQuotFile!=null && !damageEstQuotFileName.equals("null") )
			{
				clmNajmuploads.setDamageEstQuotName(damageEstQuotFileName);
				damageEstQuotData = FileUtil.getBytes(damageEstQuotInputStream);
				clmNajmuploads.setDamageEstQuot(new javax.sql.rowset.serial.SerialBlob(damageEstQuotData));

			}
			if(bankIbanFile!=null && !bankIbanFileName.equals("null"))
			{
				clmNajmuploads.setBankIbanName(bankIbanFileName);
				bankIbanData = FileUtil.getBytes(bankIbanInputStream);
				clmNajmuploads.setBankIban(new javax.sql.rowset.serial.SerialBlob(bankIbanData));

			}
			if(ownerIdFile!=null && !ownerIdFileName.equals("null"))
			{
				clmNajmuploads.setOwnerIdName(ownerIdFileName);
				ownerIdData = FileUtil.getBytes(ownerIdInputStream);
				clmNajmuploads.setOwnerId(new javax.sql.rowset.serial.SerialBlob(ownerIdData));

			}
			CLMNajmUploadsUtil.update(clmNajmuploads);
			doUpdateWorkflowStatus(clmNajmuploads.getClaimRefNo(),username ,STATUS_SUBMITTED, reason,false);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public MuroorODUploads getMuroorODUploadsData(String refNo){
		Object[] uploadsObj=ODMuroorUploadsLocalServiceUtil.findUploadsData(refNo);
		MuroorODUploads odUploadsData = new MuroorODUploads();
		if(uploadsObj!=null)
		{
			odUploadsData.setClaimIntimationNo((uploadsObj[0]!=null)?uploadsObj[0].toString():null);
			odUploadsData.setDriverLicenseName((uploadsObj[1]!=null)?uploadsObj[1].toString():null);
			odUploadsData.setVehRegistName((uploadsObj[2]!=null)?uploadsObj[2].toString():null);
			odUploadsData.setPolicyCopyName((uploadsObj[3]!=null)?uploadsObj[3].toString():null);
			odUploadsData.setFileId((uploadsObj[4]!=null)?Integer.valueOf(uploadsObj[4].toString()):null);
		}
		return odUploadsData;
	}

	public com.atmc.bsl.db.domain.claim.MuroorTPUploads getMuroorTPUploadsData(String refNo){
		Object[] uploadsObj=MuroorTPUploadsLocalServiceUtil.findUploadsData(refNo);
		com.atmc.bsl.db.domain.claim.MuroorTPUploads tpUploadsData = new com.atmc.bsl.db.domain.claim.MuroorTPUploads();
		if(uploadsObj!=null)
		{
			tpUploadsData.setClaimIntimationNo((uploadsObj[0]!=null)?uploadsObj[0].toString():null);
			tpUploadsData.setDriverLicenseName((uploadsObj[1]!=null)?uploadsObj[1].toString():null);
			tpUploadsData.setVehRegistName((uploadsObj[2]!=null)?uploadsObj[2].toString():null);
			tpUploadsData.setFrontPhotoName((uploadsObj[3]!=null)?uploadsObj[3].toString():null);
			tpUploadsData.setRearPhotoName((uploadsObj[4]!=null)?uploadsObj[4].toString():null);
			tpUploadsData.setRightSidePhotoName((uploadsObj[5]!=null)?uploadsObj[5].toString():null);
			tpUploadsData.setLeftSidePhotoName((uploadsObj[6]!=null)?uploadsObj[6].toString():null);
			tpUploadsData.setBankIbanName((uploadsObj[7]!=null)?uploadsObj[7].toString():null);
			tpUploadsData.setOwnerIdName((uploadsObj[8]!=null)?uploadsObj[8].toString():null);
			tpUploadsData.setFileId((uploadsObj[9]!=null)?Integer.valueOf(uploadsObj[9].toString()):null);
		}
		return tpUploadsData;
	}

	public byte[] findTPBankIbanFile(int id){
		MuroorTPUploadsBankIbanBlobModel muroor=MuroorTPUploadsLocalServiceUtil.getBankIbanBlobModel(id);
		byte[] bankIbanFile;
		try {
			bankIbanFile = muroor.getBankIbanBlob().getBytes(1, (int)muroor.getBankIbanBlob().length());
			return bankIbanFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public byte[] findTPOwnerIdFile(int id)
	{
		MuroorTPUploadsOwnerIdBlobModel muroor = MuroorTPUploadsLocalServiceUtil.getOwnerIdBlobModel(id);
		byte[] ownerIdFile;
		try {
			ownerIdFile = muroor.getOwnerIdBlob().getBytes(1, (int)muroor.getOwnerIdBlob().length());
			return ownerIdFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public byte[] findTPDriverLicenseFile(int id)
	{
		MuroorTPUploadsDriverLicenseBlobModel muroor = MuroorTPUploadsLocalServiceUtil.getDriverLicenseBlobModel(id);
		byte[] driverLicenseFile;
		try {
			driverLicenseFile = muroor.getDriverLicenseBlob().getBytes(1, (int)muroor.getDriverLicenseBlob().length());
			return driverLicenseFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public byte[] findTPVehRegistFile(int id)
	{
		MuroorTPUploadsVehRegistBlobModel muroor = MuroorTPUploadsLocalServiceUtil.getVehRegistBlobModel(id);
		byte[] vehRegistFile;
		try {
			vehRegistFile = muroor.getVehRegistBlob().getBytes(1, (int)muroor.getVehRegistBlob().length());
			return vehRegistFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public byte[] findTPFrontPhotoFile(int id)
	{
		MuroorTPUploadsFrontPhotoBlobModel muroor = MuroorTPUploadsLocalServiceUtil.getFrontPhotoBlobModel(id);
		byte[] frontPhotoFile;
		try {
			frontPhotoFile = muroor.getFrontPhotoBlob().getBytes(1, (int)muroor.getFrontPhotoBlob().length());
			return frontPhotoFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public byte[] findTPRearPhotoFile(int id)
	{
		MuroorTPUploadsRearPhotoBlobModel muroor = MuroorTPUploadsLocalServiceUtil.getRearPhotoBlobModel(id);
		byte[] rearPhotoFile;
		try {
			rearPhotoFile = muroor.getRearPhotoBlob().getBytes(1, (int)muroor.getRearPhotoBlob().length());
			return rearPhotoFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public byte[] findTPRightSidePhotoFile(int id)
	{
		MuroorTPUploadsRightSidePhotoBlobModel muroor = MuroorTPUploadsLocalServiceUtil.getRightSidePhotoBlobModel(id);
		byte[] rightSidePhotoFile;
		try {
			rightSidePhotoFile = muroor.getRightSidePhotoBlob().getBytes(1, (int)muroor.getRightSidePhotoBlob().length());
			return rightSidePhotoFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public byte[] findTPLeftSidePhotoFile(int id)
	{
		MuroorTPUploadsLeftSidePhotoBlobModel muroor = MuroorTPUploadsLocalServiceUtil.getLeftSidePhotoBlobModel(id);
		byte[] leftSidePhotoFile;
		try {
			leftSidePhotoFile = muroor.getLeftSidePhotoBlob().getBytes(1, (int)muroor.getLeftSidePhotoBlob().length());
			return leftSidePhotoFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public byte[] findODDriverLicenseFile(int id)
	{
		ODMuroorUploadsDriverLicenseBlobModel muroor = ODMuroorUploadsLocalServiceUtil.getDriverLicenseBlobModel(id);
		byte[] driverLicenseFile;
		try {
			driverLicenseFile = muroor.getDriverLicenseBlob().getBytes(1, (int)muroor.getDriverLicenseBlob().length());
			return driverLicenseFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public byte[] findODVehRegistFile(int id)
	{
		ODMuroorUploadsVehRegistBlobModel muroor = ODMuroorUploadsLocalServiceUtil.getVehRegistBlobModel(id);
		byte[] vehRegistFile;
		try {
			vehRegistFile = muroor.getVehRegistBlob().getBytes(1, (int)muroor.getVehRegistBlob().length());
			return vehRegistFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public byte[] findODPolicyCopyFile(int id)
	{
		ODMuroorUploadsPolicyCopyBlobModel muroor = ODMuroorUploadsLocalServiceUtil.getPolicyCopyBlobModel(id);
		byte[] policyCopyFile;
		try {
			policyCopyFile = muroor.getPolicyCopyBlob().getBytes(1, (int)muroor.getPolicyCopyBlob().length());
			return policyCopyFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void updateMuroorODSubmitedFiles(String  claimNumber,String username,String reason,File driverLicenseFile, String driverLicenseFileName,File vehRegistFile, String vehRegistFileName,File policyCopyFile, String policyCopyFileName){
		ByteArrayFileInputStream driverLicenseInputStream = null;
		ByteArrayFileInputStream vehRegistInputStream = null;
		ByteArrayFileInputStream policyCopyInputStream = null;

		if(driverLicenseFile!=null && driverLicenseFileName!=null)
			driverLicenseInputStream = new ByteArrayFileInputStream(driverLicenseFile, 1024);
		if(vehRegistFile!=null && vehRegistFileName!=null)
			vehRegistInputStream = new ByteArrayFileInputStream(vehRegistFile, 1024);
		if(policyCopyFile!=null && policyCopyFileName!=null)
			policyCopyInputStream = new ByteArrayFileInputStream(policyCopyFile, 1024);

		byte[] driverLicenseData;
		byte[] vehRegistData;
		byte[] policyCopyData;
		try {
			ODMuroorUploads odMuroorUploads=ODMuroorUploadsUtil.findByclaimIntimationNo(claimNumber);

			if(driverLicenseFile!=null && driverLicenseFileName!=null)
			{
				odMuroorUploads.setDriverLicenseName(driverLicenseFileName);
				driverLicenseData = FileUtil.getBytes(driverLicenseInputStream);
				odMuroorUploads.setDriverLicense(new javax.sql.rowset.serial.SerialBlob(driverLicenseData));
			}

			if(vehRegistFile!=null && vehRegistFileName!=null)
			{
				odMuroorUploads.setVehRegistName(vehRegistFileName);
				vehRegistData = FileUtil.getBytes(vehRegistInputStream);
				odMuroorUploads.setVehRegist(new javax.sql.rowset.serial.SerialBlob(vehRegistData));
			}

			if(policyCopyFile!=null && policyCopyFileName!=null)
			{
				odMuroorUploads.setPolicyCopyName(policyCopyFileName);
				policyCopyData = FileUtil.getBytes(policyCopyInputStream);
				odMuroorUploads.setPolicyCopy(new javax.sql.rowset.serial.SerialBlob(policyCopyData));
			}

			ODMuroorUploadsUtil.update(odMuroorUploads);
			doUpdateWorkflowStatus(odMuroorUploads.getClaimIntimationNo(),username ,STATUS_SUBMITTED, reason,false);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateMuroorTPSubmitedFiles(String  claimNumber, String username, String reason, File driverLicenseFile, String driverLicenseFileName, File vehRegistFile, String vehRegistFileName, File frontPhoto, String frontPhotoName, File rarePhoto, String rarePhotoName, File rightSidePhoto, String rightSidePhotoName, File leftSidePhoto, String leftSidePhotoName, File bankIbanFile, String bankIbanFileName, File ownerIdFile, String ownerIdFileName){
		ByteArrayFileInputStream driverLicenseInputStream = null;
		ByteArrayFileInputStream vehRegistInputStream = null;
		ByteArrayFileInputStream frontPhotoIS = null;
		ByteArrayFileInputStream rarePhotoIS = null;
		ByteArrayFileInputStream rightSidePhotoIS = null;
		ByteArrayFileInputStream leftSidePhotoIS = null;
		ByteArrayFileInputStream bankIbanInputStream = null;
		ByteArrayFileInputStream ownerIdInputStream = null;

		if(driverLicenseFile!=null && driverLicenseFileName!=null)
			driverLicenseInputStream = new ByteArrayFileInputStream(driverLicenseFile, 1024);
		if(vehRegistFile!=null && vehRegistFileName!=null)
			vehRegistInputStream = new ByteArrayFileInputStream(vehRegistFile, 1024);
		if(frontPhoto!=null && frontPhotoName!=null)
			frontPhotoIS = new ByteArrayFileInputStream(frontPhoto, 1024);
		if(rarePhoto!=null && rarePhotoName!=null)
			rarePhotoIS = new ByteArrayFileInputStream(rarePhoto, 1024);
		if(rightSidePhoto!=null && rightSidePhotoName!=null)
			rightSidePhotoIS = new ByteArrayFileInputStream(rightSidePhoto, 1024);
		if(leftSidePhoto!=null && leftSidePhotoName!=null)
			leftSidePhotoIS = new ByteArrayFileInputStream(leftSidePhoto, 1024);
		if(bankIbanFile!=null && bankIbanFileName!=null)
			bankIbanInputStream = new ByteArrayFileInputStream(bankIbanFile, 1024);
		if(ownerIdFile!=null && ownerIdFileName!=null)
			ownerIdInputStream = new ByteArrayFileInputStream(ownerIdFile, 1024);


		byte[] driverLicenseData;
		byte[] vehRegistData;
		byte[] frontPhotoData;
		byte[] rarePhotoData;
		byte[] rightSidePhotoData;
		byte[] leftSidePhotoData;
		byte[] bankIbanData;
		byte[] ownerIdData;

		try {
			MuroorTPUploads tpMuroorUploads=MuroorTPUploadsUtil.findByclaimIntimationNo(claimNumber);

			if(driverLicenseFile!=null && driverLicenseFileName!=null)
			{
				tpMuroorUploads.setDriverLicenseName(driverLicenseFileName);
				driverLicenseData = FileUtil.getBytes(driverLicenseInputStream);
				tpMuroorUploads.setDriverLicense(new javax.sql.rowset.serial.SerialBlob(driverLicenseData));
			}

			if(vehRegistFile!=null && vehRegistFileName!=null)
			{
				tpMuroorUploads.setVehRegistName(vehRegistFileName);
				vehRegistData = FileUtil.getBytes(vehRegistInputStream);
				tpMuroorUploads.setVehRegist(new javax.sql.rowset.serial.SerialBlob(vehRegistData));
			}

			if(frontPhoto!=null && frontPhotoName!=null)
			{
				tpMuroorUploads.setFrontPhotoName(frontPhotoName);
				frontPhotoData = FileUtil.getBytes(frontPhotoIS);
				tpMuroorUploads.setFrontPhoto(new javax.sql.rowset.serial.SerialBlob(frontPhotoData));
			}


			if(rarePhoto!=null && rarePhotoName!=null)
			{
				tpMuroorUploads.setRearPhotoName(rarePhotoName);
				rarePhotoData = FileUtil.getBytes(rarePhotoIS);
				tpMuroorUploads.setRearPhoto(new javax.sql.rowset.serial.SerialBlob(rarePhotoData));
			}

			if(rightSidePhoto!=null && rightSidePhotoName!=null)
			{
				tpMuroorUploads.setRightSidePhotoName(rightSidePhotoName);
				rightSidePhotoData = FileUtil.getBytes(rightSidePhotoIS);
				tpMuroorUploads.setRightSidePhoto(new javax.sql.rowset.serial.SerialBlob(rightSidePhotoData));
			}

			if(leftSidePhoto!=null && leftSidePhotoName!=null)
			{
				tpMuroorUploads.setLeftSidePhotoName(leftSidePhotoName);
				leftSidePhotoData = FileUtil.getBytes(leftSidePhotoIS);
				tpMuroorUploads.setLeftSidePhoto(new javax.sql.rowset.serial.SerialBlob(leftSidePhotoData));
			}

			if(bankIbanFile!=null && bankIbanFileName!=null)
			{
				tpMuroorUploads.setBankIbanName(bankIbanFileName);
				bankIbanData = FileUtil.getBytes(bankIbanInputStream);
				tpMuroorUploads.setBankIban(new javax.sql.rowset.serial.SerialBlob(bankIbanData));
			}

			if(ownerIdFile!=null && ownerIdFileName!=null)
			{
				tpMuroorUploads.setOwnerIdName(ownerIdFileName);
				ownerIdData = FileUtil.getBytes(ownerIdInputStream);
				tpMuroorUploads.setOwnerId(new javax.sql.rowset.serial.SerialBlob(ownerIdData));
			}

			MuroorTPUploadsUtil.update(tpMuroorUploads);
			doUpdateWorkflowStatus(tpMuroorUploads.getClaimIntimationNo(),username ,STATUS_SUBMITTED, reason,false);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}