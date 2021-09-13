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

import com.atmc.bsl.db.service.base.PolicyLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;
import com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException;
import com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException;
import com.ejada.atmc.acl.db.model.BeneficiaryDetails;
import com.ejada.atmc.acl.db.model.FundDetails;
import com.ejada.atmc.acl.db.model.PolicyMemberDetails;
import com.ejada.atmc.acl.db.model.PolicyHDR;
import com.ejada.atmc.acl.db.model.PolicyVEH;
import com.ejada.atmc.acl.db.model.PolicyVehCvr;
import com.ejada.atmc.acl.db.model.PolicyVehDrv;
import com.ejada.atmc.acl.db.service.PolicyHDRLocalServiceUtil;
import com.ejada.atmc.acl.db.service.PolicyVEHLocalServiceUtil;
import com.ejada.atmc.acl.db.service.persistence.PolicyVEHPK;
import com.atmc.bsl.db.domain.policy.Policy;
import com.atmc.bsl.db.domain.policy.PolicyBeneficiary;
import com.atmc.bsl.db.domain.policy.PolicyFund;
import com.atmc.bsl.db.domain.policy.PolicyMember;
import com.atmc.bsl.db.domain.policy.PolicyPayment;
import com.atmc.bsl.db.domain.policy.PolicyVehicle;
import com.atmc.bsl.db.domain.policy.PolicyVehicleCover;
import com.atmc.bsl.db.domain.policy.PolicyVehicleDriver;
import com.atmc.bsl.db.service.ClaimLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * The implementation of the policy local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.PolicyLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.atmc.bsl.db.model.Policy", service = AopService.class)
public class PolicyLocalServiceImpl extends PolicyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this class directly. Always use {@link
	 * com.ejada.atmc.bsl.db.service.PolicyLocalServiceUtil} to access the policy
	 * local service.
	 */
	private static final Log _log = LogFactoryUtil.getLog(PolicyLocalServiceImpl.class);

	public static final String[] ACTIVE_POLICY_STATUSES = { "A", "CO", "E", "N", "P", "R", "RF", "RP" };

	public List<Policy> getPoliciesByIqamaId(String iqamaId, int start, int end) throws PortalException {
		// _log.debug("performance test: before PolicyHDR");

		List<PolicyHDR> policyHdrList = PolicyHDRLocalServiceUtil.findByIqamaId(iqamaId, start, end);
		// _log.debug("performance test: after PolicyHDR");

		List<Policy> policyList = getCustomPoliciesForPolicyList(policyHdrList);

		return policyList;
	}

	public long getPoliciesCountByIqamaId(String iqamaId) throws PortalException {
		// _log.debug("performance test: before PolicyHDR");

		long policyCont = PolicyHDRLocalServiceUtil.findCountByIqamaId(iqamaId);
		// _log.debug("performance test: after PolicyHDR");

		return policyCont;
	}

	public Long getUpcomingRenewalsCount(String iqamaId) throws PortalException {
		Long renewalsCount = PolicyHDRLocalServiceUtil.findUpcomingRenewalsCount(iqamaId);
		return renewalsCount;
	}

	public List<Policy> getTopPolicies(String iqamaId) throws PortalException {
		List<PolicyHDR> PolicyHDRList = PolicyHDRLocalServiceUtil.findTopPolicies(iqamaId);
		List<Policy> policyList = getCustomTopPolicies(PolicyHDRList);
		return policyList;
	}

	private List<Policy> getCustomPoliciesForPolicyList(List<PolicyHDR> policyHdrList) throws PortalException {
		_log.info("getCustomPoliciesForPolicyList - Start");
		List<Policy> policyList = new ArrayList<>();

		if (policyHdrList != null && !policyHdrList.isEmpty()) {
			for (PolicyHDR policyHdr : policyHdrList) {
				String product = policyHdr.getProduct();
				Policy policy = new Policy();
				policy.setCountPremMissed(policyHdr.getCountPremMissed());
				policy.setCustBirthDate(policyHdr.getCustBirthDate());
				policy.setCustName(policyHdr.getCustName());
				policy.setEstExpiryDate(policyHdr.getEstExpiryDate());
				policy.setExpiryDate(policyHdr.getExpiryDate());
				policy.setInceptionDate(policyHdr.getInceptionDate());
				policy.setInsuredAddr(policyHdr.getInsuredAddr());
				policy.setInsuredBirthDate(policyHdr.getInsuredBirthDate());
				policy.setInsuredEmail(policyHdr.getInsuredEmail());
				policy.setInsuredId(policyHdr.getInsuredId());
				policy.setInsuredMobile(policyHdr.getInsuredMobile());
				policy.setInsuredName(policyHdr.getInsuredName());

				_log.info("Insured Gender:" + policyHdr.getInsuredGender());

				policy.setInsuredGender(policyHdr.getInsuredGender());
				policy.setIqamaId(policyHdr.getIqamaId());
				policy.setNextDueDate(policyHdr.getNextDueDate());
				policy.setMemberBenefits(policyHdr.getMemberBenefits());
				policy.setMemberScheme(policyHdr.getMemberScheme());
				policy.setModeOfPayment(policyHdr.getModeOfPayment());
				policy.setNajmStatus(policyHdr.getNajmStatus());
				policy.setNextRenwalDate(policyHdr.getNextRenwalDate());
				policy.setNoOfRisk(policyHdr.getNoOfRisk());
				policy.setOccuptation(policyHdr.getOccuptation());
				policy.setPolicyFees(policyHdr.getPolicyFees());
				policy.setPolicyNo(policyHdr.getPolicyNo());
				policy.setPolicyStatus(policyHdr.getPolicyStatus());
				policy.setPolicyTaxes(policyHdr.getPolicyTaxes());
				policy.setPolicyTerm(policyHdr.getPolicyTerm());
				policy.setPremium(policyHdr.getPremium());
				policy.setProduct(product);
				policy.setProductEn(policyHdr.getProductDescEn());
				policy.setProductAr(policyHdr.getProductDescAr());
				policy.setSumInsured(policyHdr.getSumInsured());
				policy.setSurrenderValue(policyHdr.getSurrenderValue());
				policy.setTotalPremium(policyHdr.getTotalPremium());
				policy.setPolicyStatus(policyHdr.getPolicyStatus());
				policy.setPolicyStatusAr(policyHdr.getStatusDescAr());
				policy.setPolicyStatusEn(policyHdr.getStatusDescEn());
				if (product.equals("13101") || product.equals("13102")) {
					List<PolicyVEH> policyVehList = policyHdr.getPolicyVEHs();
					if (policyVehList!=null && policyVehList.size() == 1  && !policyVehList.isEmpty()) {
						for (PolicyVEH pVeh : policyVehList) {
							// PolicyVEH pVeh = policyVehList.get(0);
							PolicyVehicle customPVeh = new PolicyVehicle();
							customPVeh.setAgencyRepair(pVeh.getAgencyRepair());
							customPVeh.setArPlateL1(pVeh.getArPlateL1());
							customPVeh.setArPlateL2(pVeh.getArPlateL2());
							customPVeh.setArPlateL3(pVeh.getArPlateL3());
							customPVeh.setArPlateNo(pVeh.getArPlateNo());
							customPVeh.setBodyType(pVeh.getBodyType());
							customPVeh.setBodyTypeEn(pVeh.getBodyTypeDescEn());
							customPVeh.setBodyTypeAr(pVeh.getBodyTypeDescAr());
							customPVeh.setChassisNo(pVeh.getChassisNo());
							customPVeh.setColor(pVeh.getColor());
							customPVeh.setColorEn(pVeh.getColorDescEn());
							customPVeh.setColorAr(pVeh.getColorDescAr());
							customPVeh.setDeductible(pVeh.getDeductible());
							customPVeh.setDiscounts(pVeh.getDiscounts());
							customPVeh.setEnPlateL1(pVeh.getEnPlateL1());
							customPVeh.setEnPlateL2(pVeh.getEnPlateL2());
							customPVeh.setEnPlateL3(pVeh.getEnPlateL3());
							customPVeh.setEnPlateNo(pVeh.getEnPlateNo());
							customPVeh.setLoading(pVeh.getLoading());
							customPVeh.setMake(pVeh.getMake());
							customPVeh.setMakeEn(pVeh.getMakeDescEn());
							customPVeh.setMakeAr(pVeh.getMakeDescAr());
							customPVeh.setMfgYear(pVeh.getMfgYear());
							customPVeh.setModel(pVeh.getVehModel());
							customPVeh.setModelEn(pVeh.getModelDescEn());
							customPVeh.setModelAr(pVeh.getModelDescAr());
							customPVeh.setNajmPlateType(pVeh.getNajmPlateType());
							customPVeh.setNajmPlateTypeEn(pVeh.getNajmPlateTypeDescEn());
							customPVeh.setNajmPlateTypeAr(pVeh.getNajmPlateTypeDescAr());
							customPVeh.setNajmStatus(pVeh.getNajmStatus());
							customPVeh.setNoofClaimFreeYears(pVeh.getNoofClaimFreeYears());
							customPVeh.setNoofPassengers(pVeh.getNoofPassengers());
							customPVeh.setPolicyNo(pVeh.getPolicyNo());
							customPVeh.setPremium(pVeh.getPremium());
							customPVeh.setTotalPremium(pVeh.getTotalPremium());
							customPVeh.setUseOfCehicle(pVeh.getUseOfCehicle());
							customPVeh.setUseOfCehicleEn(pVeh.getUseOfVehicleDescEn());
							customPVeh.setUseOfCehicleAr(pVeh.getUseOfVehicleDescAr());
							customPVeh.setVehicleDefType(pVeh.getVehicleDefType());
							customPVeh.setVehicleDefTypeDesc(pVeh.getVehicleDefTypeDescEn());
							customPVeh.setVehicleDefTypeDescAr(pVeh.getVehicleDefTypeDescAr());
							customPVeh.setVehicleSeqCustom(pVeh.getVehicleSeqCustom());
							customPVeh.setVehicleValue(pVeh.getVehicleValue());
							customPVeh.setVehId(pVeh.getVehId());
							customPVeh.setEstemaraExpiryDate(pVeh.getEstemaraExpiryDate());
							customPVeh.setGeoLocation(pVeh.getGeoLocation());

							policy.getPolicyVehs().add(customPVeh);
						}
					}
				}

				else if (product.equals("SMEE") || product.equals("CCHA")) {
					List<PolicyMemberDetails> policyMembersList = policyHdr.getPolicyMembers();
					if (policyMembersList != null & !policyMembersList.isEmpty())
						for (PolicyMemberDetails pMember : policyMembersList) {
							PolicyMember customMem = new PolicyMember();
							customMem.setMemberDob(pMember.getMemberDob());
							customMem.setMemberGender(pMember.getMemberGender());
							customMem.setMemberGenderEn(pMember.getGenderDescEn());
							customMem.setMemberGender(pMember.getGenderDescAr());
							customMem.setMemberId(pMember.getMemberId());
							customMem.setMemberLimit(pMember.getMemberLimit());
							customMem.setMemberName(pMember.getMemberName());
							customMem.setMemberSi(pMember.getMemberSi());
							customMem.setPolicyNo(pMember.getPolicyNo());

							policy.getPolicyMembers().add(customMem);
						}
				}

				else if (product.equals("430") || product.equals("450") || product.equals("470")
						|| product.equals("480") || product.equals("490")) {
					policy.setModeOfPaymentEn(policyHdr.getModeOfPmntDescEn());
					policy.setModeOfPaymentAr(policyHdr.getModeOfPmntDescAr());

				}
				policyList.add(policy);
			}
		}
		return policyList;
	}

	public PolicyVehicle getCustomVeh(String policyNo, String vehId) throws PortalException {
		PolicyVEHPK PolicyVEHPK = new PolicyVEHPK(policyNo, vehId);
		PolicyVEH pVeh = PolicyVEHLocalServiceUtil.fetchPolicyVEH(PolicyVEHPK);
		PolicyVehicle customPVeh = new PolicyVehicle();
		customPVeh.setAgencyRepair(pVeh.getAgencyRepair());
		customPVeh.setArPlateL1(pVeh.getArPlateL1());
		customPVeh.setArPlateL2(pVeh.getArPlateL2());
		customPVeh.setArPlateL3(pVeh.getArPlateL3());
		customPVeh.setArPlateNo(pVeh.getArPlateNo());
		customPVeh.setBodyType(pVeh.getBodyType());
		customPVeh.setBodyTypeEn(pVeh.getBodyTypeDescEn());
		customPVeh.setBodyTypeAr(pVeh.getBodyTypeDescAr());
		customPVeh.setChassisNo(pVeh.getChassisNo());
		customPVeh.setColor(pVeh.getColor());
		customPVeh.setColorEn(pVeh.getColorDescEn());
		customPVeh.setColorAr(pVeh.getColorDescAr());
		customPVeh.setDeductible(pVeh.getDeductible());
		customPVeh.setDiscounts(pVeh.getDiscounts());
		customPVeh.setEnPlateL1(pVeh.getEnPlateL1());
		customPVeh.setEnPlateL2(pVeh.getEnPlateL2());
		customPVeh.setEnPlateL3(pVeh.getEnPlateL3());
		customPVeh.setEnPlateNo(pVeh.getEnPlateNo());
		customPVeh.setLoading(pVeh.getLoading());
		customPVeh.setMake(pVeh.getMake());
		customPVeh.setMakeEn(pVeh.getMakeDescEn());
		customPVeh.setMakeAr(pVeh.getMakeDescAr());
		customPVeh.setMfgYear(pVeh.getMfgYear());
		customPVeh.setModel(pVeh.getVehModel());
		customPVeh.setModelEn(pVeh.getModelDescEn());
		customPVeh.setModelAr(pVeh.getModelDescAr());
		customPVeh.setNajmPlateType(pVeh.getNajmPlateType());
		customPVeh.setNajmPlateTypeEn(pVeh.getNajmPlateTypeDescEn());
		customPVeh.setNajmPlateTypeAr(pVeh.getNajmPlateTypeDescAr());
		customPVeh.setNajmStatus(pVeh.getNajmStatus());
		customPVeh.setNoofClaimFreeYears(pVeh.getNoofClaimFreeYears());
		customPVeh.setNoofPassengers(pVeh.getNoofPassengers());
		customPVeh.setPolicyNo(pVeh.getPolicyNo());
		customPVeh.setPremium(pVeh.getPremium());
		customPVeh.setTotalPremium(pVeh.getTotalPremium());
		customPVeh.setUseOfCehicle(pVeh.getUseOfCehicle());
		customPVeh.setUseOfCehicleEn(pVeh.getUseOfVehicleDescEn());
		customPVeh.setUseOfCehicleAr(pVeh.getUseOfVehicleDescAr());
		customPVeh.setVehicleDefType(pVeh.getVehicleDefType());
		customPVeh.setVehicleDefTypeDesc(pVeh.getVehicleDefTypeDescEn());
		customPVeh.setVehicleDefTypeDescAr(pVeh.getVehicleDefTypeDescAr());
		customPVeh.setVehicleSeqCustom(pVeh.getVehicleSeqCustom());
		customPVeh.setVehicleValue(pVeh.getVehicleValue());
		customPVeh.setVehId(pVeh.getVehId());
		customPVeh.setEstemaraExpiryDate(pVeh.getEstemaraExpiryDate());
		customPVeh.setGeoLocation(pVeh.getGeoLocation());
		// _log.debug("performance test: before getting Vehicle Drivers" );
		List<PolicyVehDrv> policyVehDriversList = pVeh.getVehDrivs();
		// _log.debug("performance test: after getting Vehicle Drivers, Vehicle Drivers
		// size"+policyVehDriversList.size() );
		if (policyVehDriversList != null & !policyVehDriversList.isEmpty())
			for (PolicyVehDrv pVehDrv : policyVehDriversList) {
				PolicyVehicleDriver customVehDrv = new PolicyVehicleDriver();
				customVehDrv.setDriverBirthDate(pVehDrv.getDriverBirthDate());
				customVehDrv.setDriverGenderEn(pVehDrv.getGenderDescEn());
				customVehDrv.setDriverGenderAr(pVehDrv.getGenderDescAr());
				customVehDrv.setDriverLicenseNo(pVehDrv.getDriverLicenseNo());
				customVehDrv.setDriverName(pVehDrv.getDriverName());
				customVehDrv.setDriverNationalityEn(pVehDrv.getNationalityDescEn());
				customVehDrv.setDriverNationalityAr(pVehDrv.getNationalityDescAr());
				customVehDrv.setPolicyNo(pVehDrv.getPolicyNo());
				customVehDrv.setVehId(pVehDrv.getVehId());

				customPVeh.getVehicleDrivers().add(customVehDrv);
			}
		// _log.debug("performance test: before getting Vehicle Covers" );
		List<PolicyVehCvr> policyVehCoversList = pVeh.getVehCvrs();
		// _log.debug("performance test: after getting Vehicle Covers, Vehicle Covers
		// size"+policyVehCoversList.size() );
		if (policyVehCoversList != null & !policyVehCoversList.isEmpty())
			for (PolicyVehCvr pVehCvr : policyVehCoversList) {
				PolicyVehicleCover customVehCvr = new PolicyVehicleCover();
				customVehCvr.setBenefitTerm(pVehCvr.getBenefitTerm());
				customVehCvr.setCvrType(pVehCvr.getCvrType());
				customVehCvr.setCvrCode(pVehCvr.getCvrCode());
				customVehCvr.setDescription(pVehCvr.getDescription());
				customVehCvr.setPolicyNo(pVehCvr.getPolicyNo());
				customVehCvr.setPremium(pVehCvr.getPremium());
				customVehCvr.setSumCovered(pVehCvr.getSumCovered());
				customVehCvr.setVehId(pVehCvr.getVehId());

				customPVeh.getVehicleCovers().add(customVehCvr);
			}
		return customPVeh;

	}

	private List<Policy> getCustomPolicies(List<PolicyHDR> policyHdrList) throws PortalException {
		_log.info("Policy Local Service - getCustomPolicies");
		List<Policy> policyList = new ArrayList<>();

		if (policyHdrList != null && !policyHdrList.isEmpty()) {
			for (PolicyHDR policyHdr : policyHdrList) {
				// _log.debug("performance test: policy number="+policyHdr.getPolicyNo());
				String product = policyHdr.getProduct();
				Policy policy = new Policy();
				policy.setCountPremMissed(policyHdr.getCountPremMissed());
				policy.setCustBirthDate(policyHdr.getCustBirthDate());
				policy.setCustName(policyHdr.getCustName());
				policy.setEstExpiryDate(policyHdr.getEstExpiryDate());
				policy.setExpiryDate(policyHdr.getExpiryDate());
				policy.setInceptionDate(policyHdr.getInceptionDate());
				policy.setInsuredAddr(policyHdr.getInsuredAddr());
				policy.setInsuredBirthDate(policyHdr.getInsuredBirthDate());
				policy.setInsuredEmail(policyHdr.getInsuredEmail());
				policy.setInsuredId(policyHdr.getInsuredId());
				policy.setInsuredMobile(policyHdr.getInsuredMobile());
				policy.setInsuredName(policyHdr.getInsuredName());

				_log.info("Insured Gender:" + policyHdr.getInsuredGender());
				policy.setInsuredGender(policyHdr.getInsuredGender());
				policy.setIqamaId(policyHdr.getIqamaId());
				policy.setNextDueDate(policyHdr.getNextDueDate());
				policy.setMemberBenefits(policyHdr.getMemberBenefits());
				policy.setMemberScheme(policyHdr.getMemberScheme());
				policy.setModeOfPayment(policyHdr.getModeOfPayment());
				policy.setNajmStatus(policyHdr.getNajmStatus());
				policy.setNextRenwalDate(policyHdr.getNextRenwalDate());
				policy.setNoOfRisk(policyHdr.getNoOfRisk());
				policy.setOccuptation(policyHdr.getOccuptation());
				policy.setPolicyFees(policyHdr.getPolicyFees());
				policy.setPolicyNo(policyHdr.getPolicyNo());
				policy.setPolicyStatus(policyHdr.getPolicyStatus());
				policy.setPolicyTaxes(policyHdr.getPolicyTaxes());
				policy.setPolicyTerm(policyHdr.getPolicyTerm());
				policy.setPremium(policyHdr.getPremium());
				policy.setProduct(product);
				policy.setProductEn(policyHdr.getProductDescEn());
				policy.setProductAr(policyHdr.getProductDescAr());
				policy.setSumInsured(policyHdr.getSumInsured());
				policy.setSurrenderValue(policyHdr.getSurrenderValue());
				policy.setTotalPremium(policyHdr.getTotalPremium());
				policy.setPolicyStatus(policyHdr.getPolicyStatus());
				policy.setPolicyStatusAr(policyHdr.getStatusDescAr());
				policy.setPolicyStatusEn(policyHdr.getStatusDescEn());

				if (product.equals("13101") || product.equals("13102")) {
					// _log.debug("performance test: before getting Vehicle List" );
					List<PolicyVEH> policyVehList = policyHdr.getPolicyVEHs();
					// _log.debug("performance test: after getting Vehicle List, Vehicle List
					// size"+policyVehList.size() );
					if (policyVehList != null && !policyVehList.isEmpty()) {
						for (PolicyVEH pVeh : policyVehList) {
							// PolicyVEH pVeh = policyVehList.get(0);
							PolicyVehicle customPVeh = new PolicyVehicle();
							customPVeh.setAgencyRepair(pVeh.getAgencyRepair());
							customPVeh.setArPlateL1(pVeh.getArPlateL1());
							customPVeh.setArPlateL2(pVeh.getArPlateL2());
							customPVeh.setArPlateL3(pVeh.getArPlateL3());
							customPVeh.setArPlateNo(pVeh.getArPlateNo());
							customPVeh.setBodyType(pVeh.getBodyType());
							customPVeh.setBodyTypeEn(pVeh.getBodyTypeDescEn());
							customPVeh.setBodyTypeAr(pVeh.getBodyTypeDescAr());
							customPVeh.setChassisNo(pVeh.getChassisNo());
							customPVeh.setColor(pVeh.getColor());
							customPVeh.setColorEn(pVeh.getColorDescEn());
							customPVeh.setColorAr(pVeh.getColorDescAr());
							customPVeh.setDeductible(pVeh.getDeductible());
							customPVeh.setDiscounts(pVeh.getDiscounts());
							customPVeh.setEnPlateL1(pVeh.getEnPlateL1());
							customPVeh.setEnPlateL2(pVeh.getEnPlateL2());
							customPVeh.setEnPlateL3(pVeh.getEnPlateL3());
							customPVeh.setEnPlateNo(pVeh.getEnPlateNo());
							customPVeh.setLoading(pVeh.getLoading());
							customPVeh.setMake(pVeh.getMake());
							customPVeh.setMakeEn(pVeh.getMakeDescEn());
							customPVeh.setMakeAr(pVeh.getMakeDescAr());
							customPVeh.setMfgYear(pVeh.getMfgYear());
							customPVeh.setModel(pVeh.getVehModel());
							customPVeh.setModelEn(pVeh.getModelDescEn());
							customPVeh.setModelAr(pVeh.getModelDescAr());
							customPVeh.setNajmPlateType(pVeh.getNajmPlateType());
							customPVeh.setNajmPlateTypeEn(pVeh.getNajmPlateTypeDescEn());
							customPVeh.setNajmPlateTypeAr(pVeh.getNajmPlateTypeDescAr());
							customPVeh.setNajmStatus(pVeh.getNajmStatus());
							customPVeh.setNoofClaimFreeYears(pVeh.getNoofClaimFreeYears());
							customPVeh.setNoofPassengers(pVeh.getNoofPassengers());
							customPVeh.setPolicyNo(pVeh.getPolicyNo());
							customPVeh.setPremium(pVeh.getPremium());
							customPVeh.setTotalPremium(pVeh.getTotalPremium());
							customPVeh.setUseOfCehicle(pVeh.getUseOfCehicle());
							customPVeh.setUseOfCehicleEn(pVeh.getUseOfVehicleDescEn());
							customPVeh.setUseOfCehicleAr(pVeh.getUseOfVehicleDescAr());
							customPVeh.setVehicleDefType(pVeh.getVehicleDefType());
							customPVeh.setVehicleDefTypeDesc(pVeh.getVehicleDefTypeDescEn());
							customPVeh.setVehicleDefTypeDescAr(pVeh.getVehicleDefTypeDescAr());
							customPVeh.setVehicleSeqCustom(pVeh.getVehicleSeqCustom());
							customPVeh.setVehicleValue(pVeh.getVehicleValue());
							customPVeh.setVehId(pVeh.getVehId());
							customPVeh.setEstemaraExpiryDate(pVeh.getEstemaraExpiryDate());
							customPVeh.setGeoLocation(pVeh.getGeoLocation());
							// _log.debug("performance test: before getting Vehicle Drivers" );
							List<PolicyVehDrv> policyVehDriversList = pVeh.getVehDrivs();
							// _log.debug("performance test: after getting Vehicle Drivers, Vehicle Drivers
							// size"+policyVehDriversList.size() );
							if (policyVehDriversList != null & !policyVehDriversList.isEmpty())
								for (PolicyVehDrv pVehDrv : policyVehDriversList) {
									PolicyVehicleDriver customVehDrv = new PolicyVehicleDriver();
									customVehDrv.setDriverBirthDate(pVehDrv.getDriverBirthDate());
									customVehDrv.setDriverGenderEn(pVehDrv.getGenderDescEn());
									customVehDrv.setDriverGenderAr(pVehDrv.getGenderDescAr());
									customVehDrv.setDriverGender(pVehDrv.getDriverGender());
									customVehDrv.setDriverLicenseNo(pVehDrv.getDriverLicenseNo());
									customVehDrv.setDriverName(pVehDrv.getDriverName());
									customVehDrv.setDriverNationalityEn(pVehDrv.getNationalityDescEn());
									customVehDrv.setDriverNationalityAr(pVehDrv.getNationalityDescAr());
									customVehDrv.setPolicyNo(pVehDrv.getPolicyNo());
									customVehDrv.setVehId(pVehDrv.getVehId());

									customPVeh.getVehicleDrivers().add(customVehDrv);
								}
							// _log.debug("performance test: before getting Vehicle Covers" );
							List<PolicyVehCvr> policyVehCoversList = pVeh.getVehCvrs();
							// _log.debug("performance test: after getting Vehicle Covers, Vehicle Covers
							// size"+policyVehCoversList.size() );
							if (policyVehCoversList != null & !policyVehCoversList.isEmpty())
								for (PolicyVehCvr pVehCvr : policyVehCoversList) {
									PolicyVehicleCover customVehCvr = new PolicyVehicleCover();
									customVehCvr.setBenefitTerm(pVehCvr.getBenefitTerm());
									customVehCvr.setCvrType(pVehCvr.getCvrType());
									customVehCvr.setCvrCode(pVehCvr.getCvrCode());
									customVehCvr.setDescription(pVehCvr.getDescription());
									customVehCvr.setPolicyNo(pVehCvr.getPolicyNo());
									customVehCvr.setPremium(pVehCvr.getPremium());
									customVehCvr.setSumCovered(pVehCvr.getSumCovered());
									customVehCvr.setVehId(pVehCvr.getVehId());

									customPVeh.getVehicleCovers().add(customVehCvr);
								}

							policy.getPolicyVehs().add(customPVeh);
						}
					}
				} else if (product.equals("SMEE") || product.equals("CCHA")) {
					// _log.debug("performance test: before getting policyMembersList" );
					List<PolicyMemberDetails> policyMembersList = policyHdr.getPolicyMembers();
					// _log.debug("performance test: after getting policyMembersList,
					// policyMembersList size"+policyMembersList.size() );
					if (policyMembersList != null & !policyMembersList.isEmpty())
						for (PolicyMemberDetails pMember : policyMembersList) {
							PolicyMember customMem = new PolicyMember();
							customMem.setMemberDob(pMember.getMemberDob());
							customMem.setMemberGender(pMember.getMemberGender());
							customMem.setMemberGenderEn(pMember.getGenderDescEn());
							customMem.setMemberGender(pMember.getGenderDescAr());
							customMem.setMemberId(pMember.getMemberId());
							customMem.setMemberLimit(pMember.getMemberLimit());
							customMem.setMemberName(pMember.getMemberName());
							customMem.setMemberSi(pMember.getMemberSi());
							customMem.setPolicyNo(pMember.getPolicyNo());

							policy.getPolicyMembers().add(customMem);
						}
				} else if (product.equals("430") || product.equals("450") || product.equals("470")
						|| product.equals("480") || product.equals("490")) {
					policy.setModeOfPaymentEn(policyHdr.getModeOfPmntDescEn());
					policy.setModeOfPaymentAr(policyHdr.getModeOfPmntDescAr());
					// _log.debug("performance test: before getting PolicyPayments" );
					List<com.ejada.atmc.acl.db.model.PolicyPayment> PolicyPayments = policyHdr.getPolicyPayments();
					// _log.debug("performance test: after getting PolicyPayments, PolicyPayments
					// size"+PolicyPayments.size() );
					if (PolicyPayments != null && !PolicyPayments.isEmpty()) {
						com.ejada.atmc.acl.db.model.PolicyPayment pmnt = PolicyPayments.get(0);
						PolicyPayment customPmnt = new PolicyPayment();
						customPmnt.setAmount(pmnt.getAmount());
						customPmnt.setClaimNo(pmnt.getClaimNo());
						customPmnt.setDocDate(pmnt.getDocDate());
						customPmnt.setDueDate(pmnt.getDueDate());
						customPmnt.setEndtNo(pmnt.getEndtNo());
						customPmnt.setPolicyNo(pmnt.getPolicyNo());
						customPmnt.setReference(pmnt.getReference());
						customPmnt.setVoucherNo(pmnt.getVoucherNo());

						policy.setPolicyPayment(customPmnt);
					}
					// _log.debug("performance test: before getting policyRidersList" );
					List<PolicyVehCvr> policyRidersList = policyHdr.getPolicyRiders();
					// _log.debug("performance test: after getting policyRidersList,
					// policyRidersList size"+policyRidersList.size() );
					if (policyRidersList != null & !policyRidersList.isEmpty())
						for (PolicyVehCvr pVehCvr : policyRidersList) {
							PolicyVehicleCover customPRider = new PolicyVehicleCover();
							customPRider.setBenefitTerm(pVehCvr.getBenefitTerm());
							customPRider.setCvrType(pVehCvr.getCvrType());
							customPRider.setDescription(pVehCvr.getDescription());
							customPRider.setPolicyNo(pVehCvr.getPolicyNo());
							customPRider.setPremium(pVehCvr.getPremium());
							customPRider.setSumCovered(pVehCvr.getSumCovered());
							customPRider.setVehId(pVehCvr.getVehId());

							policy.getPolicyRiders().add(customPRider);
						}
					// _log.debug("performance test: before getting policyFundsList" );
					List<FundDetails> policyFundsList = policyHdr.getPolicyFunds();
					// _log.debug("performance test: after getting policyFundsList, policyFundsList
					// size"+policyFundsList.size() );
					if (policyFundsList != null & !policyFundsList.isEmpty())
						for (FundDetails pFund : policyFundsList) {
							PolicyFund customFund = new PolicyFund();
							customFund.setFundDesc(pFund.getFundDesc());
							customFund.setFundName(pFund.getFundName());
							customFund.setFundPctg(pFund.getFundPctg());
							customFund.setFundsValue(pFund.getFundsValue());
							customFund.setPartFees(pFund.getPartFees());
							customFund.setPolicyNo(pFund.getPolicyNo());
							customFund.setRiskChg(pFund.getRiskChg());
							customFund.setUnitPrice(pFund.getUnitPrice());
							customFund.setUnitsSum(pFund.getUnitsSum());

							policy.getPolicyFunds().add(customFund);
						}
					// _log.debug("performance test: before getting policyBenfsList" );

					List<BeneficiaryDetails> policyBenfsList = policyHdr.getPolicyBenfs();
					// _log.debug("performance test: after getting policyBenfsList, policyBenfsList
					// size"+policyBenfsList.size() );

					if (policyBenfsList != null & !policyBenfsList.isEmpty())
						for (BeneficiaryDetails benf : policyBenfsList) {
							PolicyBeneficiary customBenf = new PolicyBeneficiary();
							customBenf.setBenfAge(benf.getBenfAge());
							customBenf.setBenfId(benf.getBenfId());
							customBenf.setBenfName(benf.getBenfName());
							customBenf.setBenfPct(benf.getBenfPct());
							customBenf.setBenfRel(benf.getBenfRel());
							customBenf.setBenfRelEn(benf.getBenfRelDescEn());
							customBenf.setBenfRelAr(benf.getBenfRelDescAr());
							customBenf.setBenfType(benf.getBenfType());
							customBenf.setPolicyNo(benf.getPolicyNo());

							policy.getPolicyBenfs().add(customBenf);
						}
				}
				policyList.add(policy);
			}
		}

		return policyList;
	}

	private List<Policy> getCustomTopPolicies(List<PolicyHDR> policyHdrList) throws PortalException {
		List<Policy> policyList = new ArrayList<>();

		if (policyHdrList != null && !policyHdrList.isEmpty()) {
			for (PolicyHDR policyHdr : policyHdrList) {
				Policy policy = new Policy();
				policy.setPolicyNo(policyHdr.getPolicyNo());
				policy.setNoOfRisk(policyHdr.getNoOfRisk());
				policy.setPolicyStatus(policyHdr.getPolicyStatus());
				policy.setPolicyStatusEn(policyHdr.getStatusDescEn());
				policy.setPolicyStatusAr(policyHdr.getStatusDescAr());
				policy.setProduct(policyHdr.getProduct());
				policy.setProductEn(policyHdr.getProductDescEn());
				policy.setProductAr(policyHdr.getProductDescAr());
				policy.setExpiryDate(policyHdr.getExpiryDate());

				policyList.add(policy);
			}
		}
		return policyList;
	}

	public Policy findPolicyByPolicyNo(String policyNo) throws PortalException {
		Policy customPolicy = null;
		PolicyHDR policy = PolicyHDRLocalServiceUtil.fetchPolicyHDR(policyNo);
		if (policy != null) {
			List<PolicyHDR> policies = new ArrayList<>();
			policies.add(policy);
			customPolicy = (getCustomPolicies(policies)).get(0);
		}
		return customPolicy;

	}

	public List<Policy> getUpcomingPolicyRenewals(String iqamaId) throws PortalException {
		List<PolicyHDR> PolicyHDRList = PolicyHDRLocalServiceUtil.getUpcomingPolicyRenewals(iqamaId);
		List<Policy> policyList = getCustomTopPolicies(PolicyHDRList);
		return policyList;
	}

	public List<HashMap<String, Object>> getPolicySummary(String iqamaId) throws PortalException {
		List<PolicyHDR> PolicyHDRList = PolicyHDRLocalServiceUtil.findPolicyList(iqamaId, ACTIVE_POLICY_STATUSES);

		List<PolicyHDR> medicalPoliciesList = new ArrayList<PolicyHDR>();
		List<PolicyHDR> lifePoliciesList = new ArrayList<PolicyHDR>();
		List<PolicyHDR> motorPoliciesList = new ArrayList<PolicyHDR>();

		Date upcomingMedicalDate = null;
		Date upcomingMotorDate = null;
		Date upcomingLifeDate = null;

		List<HashMap<String, Object>> policySummary = new ArrayList<HashMap<String, Object>>();

		for (PolicyHDR policyData : PolicyHDRList) {
			if (policyData.getProduct().equals("13101") || policyData.getProduct().equals("13102")) {
				motorPoliciesList.add(policyData);
				if (upcomingMotorDate == null) {
					upcomingMotorDate = policyData.getExpiryDate();
				} else if (upcomingMotorDate.compareTo(policyData.getExpiryDate()) > 0) {
					upcomingMotorDate = policyData.getExpiryDate();
				}
			} else if (policyData.getProduct().equals("SMEE") || policyData.getProduct().equals("CCHA")) {
				medicalPoliciesList.add(policyData);
				if (upcomingMedicalDate == null) {
					upcomingMedicalDate = policyData.getExpiryDate();
				} else if (upcomingMedicalDate.compareTo(policyData.getExpiryDate()) > 0) {
					upcomingMedicalDate = policyData.getExpiryDate();
				}
			} else if (policyData.getProduct().equals("430") || policyData.getProduct().equals("450")
					|| policyData.getProduct().equals("470") || policyData.getProduct().equals("480")
					|| policyData.getProduct().equals("490")) {
				lifePoliciesList.add(policyData);
				if (upcomingLifeDate == null) {
					upcomingLifeDate = policyData.getExpiryDate();
				} else if (upcomingLifeDate.compareTo(policyData.getExpiryDate()) > 0) {
					upcomingLifeDate = policyData.getExpiryDate();
				}
			}
		}

		if (motorPoliciesList.size() > 0) {
			HashMap<String, Object> motorPoliciesData = new HashMap<String, Object>();
			motorPoliciesData.put("PolicyType", "motor_insurance");
			motorPoliciesData.put("TotalCount", motorPoliciesList.size());
			motorPoliciesData.put("UpcomingRenwalDate", upcomingMotorDate);
			motorPoliciesData.put("icon", "car");

			policySummary.add(motorPoliciesData);
		}

		if (medicalPoliciesList.size() > 0) {
			HashMap<String, Object> medicalPoliciesData = new HashMap<String, Object>();
			medicalPoliciesData.put("PolicyType", "medical_insurance");
			medicalPoliciesData.put("TotalCount", medicalPoliciesList.size());
			medicalPoliciesData.put("UpcomingRenwalDate", upcomingMedicalDate);
			medicalPoliciesData.put("icon", "health");

			policySummary.add(medicalPoliciesData);
		}

		if (lifePoliciesList.size() > 0) {
			HashMap<String, Object> lifePoliciesData = new HashMap<String, Object>();
			lifePoliciesData.put("PolicyType", "life_insurance");
			lifePoliciesData.put("TotalCount", lifePoliciesList.size());
			lifePoliciesData.put("UpcomingRenwalDate", upcomingLifeDate);
			lifePoliciesData.put("icon", "life-shield");

			policySummary.add(lifePoliciesData);
		}

		return policySummary;
	}

	public Policy getPolicyByPolicyNo(String policyNo) throws PortalException {
		PolicyHDR policyHdr = PolicyHDRLocalServiceUtil.findByPolicyNo(policyNo);
		List<PolicyHDR> policyHdrList = new ArrayList<PolicyHDR>();

		policyHdrList.add(policyHdr);

		List<Policy> policyList = getCustomPolicies(policyHdrList);

		return policyList.get(0);
	}

	public Policy getVehiclePolicyData(String plateNo, String plateL1, String plateL2, String plateL3,
			String language) {
		Policy customPolicy = null;
		PolicyHDR policyHdr;
		try {
			policyHdr = ClaimLocalServiceUtil.getVehiclePolicy(plateNo, plateL1, plateL2, plateL3, language);

			if (policyHdr != null) {
				List<PolicyHDR> policies = new ArrayList<>();
				policies.add(policyHdr);
				customPolicy = (getCustomPolicies(policies)).get(0);

			}
		} catch (NoSuchPolicyHDRException | NoSuchPolicyVEHException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customPolicy;
	}

}