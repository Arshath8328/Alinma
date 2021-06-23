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

import com.atmc.bsl.db.domain.codemaster.CodeMasterDetails;
import com.atmc.bsl.db.domain.policy.Policy;
import com.atmc.bsl.db.domain.policy.PolicyVehicle;
import com.atmc.bsl.db.domain.policy.PolicyVehicleCover;
import com.atmc.bsl.db.domain.policy.PolicyVehicleDriver;
import com.atmc.bsl.db.domain.quotation.CustomerMapDetails;
import com.atmc.bsl.db.domain.quotation.Quotation;
import com.atmc.bsl.db.domain.quotation.QuotationAdminUpload;
import com.atmc.bsl.db.domain.quotation.QuotationCover;
import com.atmc.bsl.db.domain.quotation.QuotationCustUploads;
import com.atmc.bsl.db.domain.quotation.QuotationDriver;
import com.atmc.bsl.db.domain.quotation.QuotationDriverLicense;
import com.atmc.bsl.db.domain.quotation.QuotationHistory;
import com.atmc.bsl.db.domain.quotation.QuotationNajmDetails;
import com.atmc.bsl.db.domain.quotation.QuotationTameeniExtraDetails;
import com.atmc.bsl.db.domain.quotation.QuotationUserAddress;
import com.atmc.bsl.db.domain.quotation.QuotationVehicleImage;
import com.atmc.bsl.db.exception.NajmException;
import com.atmc.bsl.db.exception.YaqeenException;
import com.atmc.bsl.db.service.CodeMasterDetailsLocalServiceUtil;
import com.atmc.bsl.db.service.NotificationsLocalServiceUtil;
import com.atmc.bsl.db.service.QuotationLocalServiceUtil;
import com.atmc.bsl.db.service.UserMgmtLocalServiceUtil;
import com.atmc.bsl.db.service.base.QuotationLocalServiceBaseImpl;
import com.ejada.atmc.acl.db.domain.tariff.TariffInput;
import com.ejada.atmc.acl.db.domain.tariff.TariffOutput;
import com.ejada.atmc.acl.db.exception.NoSuchAtmcYakeenMakeModelException;
import com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException;
import com.ejada.atmc.acl.db.exception.NoSuchCustUploadsException;
import com.ejada.atmc.acl.db.exception.NoSuchProductDetailsException;
import com.ejada.atmc.acl.db.exception.NoSuchQuotationAdminUploadsException;
import com.ejada.atmc.acl.db.exception.NoSuchQuotationsException;
import com.ejada.atmc.acl.db.exception.NoSuchQuotationsSeqException;
import com.ejada.atmc.acl.db.exception.NoSuchYakeenDataSaveException;
import com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel;
import com.ejada.atmc.acl.db.model.CodeMaster;
import com.ejada.atmc.acl.db.model.CodeMasterMap;
import com.ejada.atmc.acl.db.model.CompDiscount;
import com.ejada.atmc.acl.db.model.CustUploads;
import com.ejada.atmc.acl.db.model.CustUploadsCarBackFileBlobModel;
import com.ejada.atmc.acl.db.model.CustUploadsCarFrontFileBlobModel;
import com.ejada.atmc.acl.db.model.CustUploadsCarLeftFileBlobModel;
import com.ejada.atmc.acl.db.model.CustUploadsCarRightFileBlobModel;
import com.ejada.atmc.acl.db.model.CustUploadsEngChassisNoFileBlobModel;
import com.ejada.atmc.acl.db.model.CustUploadsIstCardFileBlobModel;
import com.ejada.atmc.acl.db.model.CustUploadsLeaseFileBlobModel;
import com.ejada.atmc.acl.db.model.Customer;
import com.ejada.atmc.acl.db.model.CustomerIban;
import com.ejada.atmc.acl.db.model.CustomerMap;
import com.ejada.atmc.acl.db.model.PolicyHDR;
import com.ejada.atmc.acl.db.model.PolicyVEH;
import com.ejada.atmc.acl.db.model.ProductCovers;
import com.ejada.atmc.acl.db.model.ProductDetails;
import com.ejada.atmc.acl.db.model.QuotationAdminUploads;
import com.ejada.atmc.acl.db.model.QuotationCovers;
import com.ejada.atmc.acl.db.model.QuotationDrivers;
import com.ejada.atmc.acl.db.model.QuotationDriversInsuredRelationProofBlobModel;
import com.ejada.atmc.acl.db.model.QuotationExtraTameeniInfo;
import com.ejada.atmc.acl.db.model.QuotationStatusHistory;
import com.ejada.atmc.acl.db.model.QuotationSurvey;
import com.ejada.atmc.acl.db.model.QuotationSurveySurveyVideoFileBlobModel;
import com.ejada.atmc.acl.db.model.Quotations;
import com.ejada.atmc.acl.db.model.QuotationsDriverLicense;
import com.ejada.atmc.acl.db.model.QuotationsNajmDetails;
import com.ejada.atmc.acl.db.model.QuotationsSeq;
import com.ejada.atmc.acl.db.model.QuotationsUserAddress;
import com.ejada.atmc.acl.db.model.YakeenDataSave;
import com.ejada.atmc.acl.db.service.AtmcYakeenMakeModelLocalServiceUtil;
import com.ejada.atmc.acl.db.service.CodeMasterLocalServiceUtil;
import com.ejada.atmc.acl.db.service.CodeMasterMapLocalServiceUtil;
import com.ejada.atmc.acl.db.service.CompDiscountLocalServiceUtil;
import com.ejada.atmc.acl.db.service.CustUploadsLocalServiceUtil;
import com.ejada.atmc.acl.db.service.CustomerIbanLocalServiceUtil;
import com.ejada.atmc.acl.db.service.CustomerLocalServiceUtil;
import com.ejada.atmc.acl.db.service.CustomerMapLocalServiceUtil;
import com.ejada.atmc.acl.db.service.PolicyHDRLocalServiceUtil;
import com.ejada.atmc.acl.db.service.PolicyVEHLocalServiceUtil;
import com.ejada.atmc.acl.db.service.PolicyVehCvrLocalServiceUtil;
import com.ejada.atmc.acl.db.service.ProductCoversLocalServiceUtil;
import com.ejada.atmc.acl.db.service.ProductDetailsLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationCoversLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationDriversLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationExtraTameeniInfoLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationStatusHistoryLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationSurveyLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationsDriverLicenseLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationsLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationsNajmDetailsLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationsSeqLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationsUserAddressLocalServiceUtil;
import com.ejada.atmc.acl.db.service.TariffLocalServiceUtil;
import com.ejada.atmc.acl.db.service.YakeenDataSaveLocalServiceUtil;
import com.ejada.atmc.acl.db.service.persistence.CustUploadsUtil;
import com.ejada.atmc.acl.db.service.persistence.PolicyVehCvrPK;
import com.ejada.atmc.acl.db.service.persistence.QuotationAdminUploadsUtil;
import com.ejada.atmc.acl.db.service.persistence.QuotationCoversPK;
import com.ejada.atmc.acl.db.service.persistence.QuotationCoversUtil;
import com.ejada.atmc.acl.db.service.persistence.QuotationDriversPK;
import com.ejada.atmc.acl.db.service.persistence.QuotationExtraTameeniInfoUtil;
import com.ejada.atmc.acl.db.service.persistence.QuotationStatusHistoryUtil;
import com.ejada.atmc.acl.db.service.persistence.QuotationSurveyUtil;
import com.ejada.atmc.acl.db.service.persistence.QuotationsNajmDetailsPK;
import com.ejada.atmc.acl.db.service.persistence.QuotationsUtil;
import com.ejada.atmc.acl.ws.domain.InitiateOLPPayment;
import com.ejada.atmc.acl.ws.domain.NCDEligibility;
import com.ejada.atmc.acl.ws.domain.ods.ODSAddDriver;
import com.ejada.atmc.acl.ws.domain.ods.ODSCover;
import com.ejada.atmc.acl.ws.domain.ods.ODSInsured;
import com.ejada.atmc.acl.ws.domain.ods.ODSPIResponse;
import com.ejada.atmc.acl.ws.domain.ods.ODSPolicy;
import com.ejada.atmc.acl.ws.domain.ods.ODSVehicleInfo;
import com.ejada.atmc.acl.ws.domain.payFort.PurchaseRequest;
import com.ejada.atmc.acl.ws.domain.payFort.PurchaseResponse;
import com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.BasicCarInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.CarInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest;
import com.ejada.atmc.acl.ws.service.NajmLocalServiceUtil;
import com.ejada.atmc.acl.ws.service.OLPPaymentLocalServiceUtil;
import com.ejada.atmc.acl.ws.service.OdsLocalServiceUtil;
import com.ejada.atmc.acl.ws.service.PayFortLocalServiceUtil;
import com.ejada.atmc.acl.ws.service.YakeenLocalServiceUtil;
import com.ejada.atmc.utils.api.ReportsUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.ByteArrayFileInputStream;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.access.control.AccessControlUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;

import org.apache.commons.codec.binary.Hex;
import org.osgi.service.component.annotations.Component;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * The implementation of the quotation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.QuotationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.atmc.bsl.db.model.Quotation", service = AopService.class)
public class QuotationLocalServiceImpl extends QuotationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this class directly. Always use {@link
	 * com.ejada.atmc.bsl.db.service.QuotationLocalServiceUtil} to access the
	 * quotation local service.
	 */
	final static private String PURPOSE_OF_VEHICLE_CODE = "MOT_VEHI_USE";

	final static private String DEDUCTIBLE_VALUE_CODE = "MOT_DED";

	final static private String PARKING_LOCATION_CODE = "PARKING_LOCATION";

	final static private String ENGINE_SIZE_CODE = "ENGINE_SIZE";

	private static final String NATIONALITY_CODE = "NATIONALITY";

	private static final String LICENSE_TYPE_CODE = "TYPE_OF_LICENSE";

	private static final String EDUCATION_CODE = "EDUCATION";

	private static final String CITY_CODE = "CITY";

	final static private String CUSTOMER_CATG_CUSTOMER = "024";

	final static private String CUSTOMER_TYPE_CUSTOMER = "CUSTOMER";

	public static final int PRODUCT_CODE_COMPREHENSIVE_VAL = 13101;

	public static final int SECTION_CODE_PRODUCT_CODE_TPL = 1310401;

	public static final int SECTION_CODE_PRODUCT_CODE_COMPREHENSIVE = 1310301;

	public static final int PRODUCT_CODE_TPL_VAL = 13102;

	public static final String PRODUCT_CODE_COMPREHENSIVE = "MCC";

	public static final String PRODUCT_CODE_TPL = "MTP";

	public static final String PRODUCT_CODE_COMPREHENSIVE_REF = "Q1310301";

	public static final String PRODUCT_CODE_TPL_REF = "Q1310401";

	public static final String QUOTATION_STATUS_PENDING_PAYMENT = "PP";

	public static final String QUOTATION_STATUS_PENDING_SURVEY = "PS";

	public static final String QUOTATION_STATUS_REJECTED = "RJ";

	public static final String POLICY_STATUS_ACTIVE = "PA";

	private static final String POLICY_STATUS_CODE = "VEH_DFN_TYPE";

	private CodeMaster statusDetails;

	private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

	private SimpleDateFormat odsDateFormatter = new SimpleDateFormat("yyyy-MM-dd");

	private static final Log _log = LogFactoryUtil.getLog(QuotationLocalServiceBaseImpl.class);

	public static final String VEHICLE_ISTIMARA_CARD = "1";

	public static final String VEHICLE_CUSTOM_CARD = "2";

	public static final String VEHICLE_TRANSFER_OWNERSHIP_CARD = "3";

	public static final String ODS_SRC_TYPE_MAKE_NAT = "VEH_NATIONALITY";

	public final static long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;

	public static final long ID_TYPE_SAUDI = 1;

	public static final long ID_TYPE_IQAMA = 2;

	public static final String ODS_SRC_TYPE_COLOR = "COLOR";

	private static final String NCD_STATUS_CODE_SUCCESS = "1";

	public static final int YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED = 999999;

	public static final String YAKEEN_INSURED_GENDER_MALE = "M";

	public static final String YAKEEN_INSURED_GENDER_FEMALE = "F";

	public static final int INSURED_GENDER_MALE = 1;

	public static final int INSURED_GENDER_FEMALE = 2;

	public static final int TARIF_NO_ADDITIONAL_DRIVER = 99;

	public static final long RENEWABLE_POLICY_EXISTS = 1;

	public static final long NON_EXPIRED_POLICY_EXISTS = 2;
	DecimalFormat decimalFormat = new DecimalFormat("#.00");

	public List<Quotation> getQuotationsByIqamaId(long iqamaId) throws PortalException {
		List<Quotations> quotationsList = QuotationsLocalServiceUtil.findByIqamaId(iqamaId);
		List<Quotation> customQuotationList = getCustomQuotations(quotationsList);

		return customQuotationList;
	}

	public List<Quotation> getPendingQuotations(long iqamaId) {
		String[] status = { QUOTATION_STATUS_PENDING_PAYMENT };
		List<Quotations> allQuotsList = QuotationsLocalServiceUtil.findByIqamaIdAndStatus(iqamaId, status);
		List<Quotations> quotationsList = new ArrayList<Quotations>();
		List<Quotation> customQuotationList = new ArrayList<>();
		if (allQuotsList.size() > 0) {
			for (int i = 0; i < allQuotsList.size(); i++) {
				Quotations quot = allQuotsList.get(i);
				Date today = new Date();
				if (quot.getVehicleEstExpiryDate() != null && quot.getQuoteStatus() != null) {
					if (!(quot.getVehicleEstExpiryDate().compareTo(today) < 0)) {
						quotationsList.add(quot);
					}
				}
			}
			customQuotationList = getCustomQuotations(quotationsList);
		}
		return customQuotationList;
	}

	public List<Quotation> getPendingPaymentSurveyQuotations(long iqamaId) {
		String[] status = { QUOTATION_STATUS_PENDING_PAYMENT, QUOTATION_STATUS_PENDING_SURVEY };
		List<Quotations> allQuotsList = QuotationsLocalServiceUtil.findByIqamaIdAndStatus(iqamaId, status);
		List<Quotations> quotationsList = new ArrayList<Quotations>();
		List<Quotation> customQuotationList = new ArrayList<>();
		if (allQuotsList.size() > 0) {
			for (int i = 0; i < allQuotsList.size(); i++) {
				Quotations quot = allQuotsList.get(i);
				Date today = new Date();
				if (quot.getVehicleEstExpiryDate() != null && quot.getQuoteStatus() != null) {
					if (!(quot.getVehicleEstExpiryDate().compareTo(today) < 0)) {
						quotationsList.add(quot);
					}
				}
			}
			customQuotationList = getCustomQuotations(quotationsList);
		}
		return customQuotationList;
	}

	public Quotation getQuotationByQuotationId(long quotationId) throws PortalException {
		List<Quotations> quotationsList = (List<Quotations>) QuotationsLocalServiceUtil.findByQuotationId(quotationId);
		List<Quotation> customQuotationList = getCustomQuotations(quotationsList);

		return customQuotationList.get(0);
	}

	public Quotation getQuotationByReferenceNo(String referenceNo) throws PortalException {
		List<Quotations> quotationsList = (List<Quotations>) QuotationsLocalServiceUtil.findByReferenceNo(referenceNo);
		List<Quotation> customQuotationList = getCustomQuotations(quotationsList, true);

		if (customQuotationList.size() > 0)
			return customQuotationList.get(0);
		else
			return null;
	}

	private ProductDetails prodDetails;

	public String getProductDescEn(String productCode) {
		ProductDetails prodDetails = null;
		try {
			productCode = (productCode.equals(PRODUCT_CODE_COMPREHENSIVE))
					? String.valueOf(PRODUCT_CODE_COMPREHENSIVE_VAL)
					: String.valueOf(PRODUCT_CODE_TPL_VAL);
			prodDetails = ProductDetailsLocalServiceUtil.findByProductCode(productCode);
		} catch (NoSuchProductDetailsException e) {
			_log.error(e.getMessage());
			return "";
		} catch (NumberFormatException e) {
			_log.error(e.getMessage());
			return "";
		}
		return (prodDetails != null) ? prodDetails.getProductName() : "";
	}

	public String getProductDescAr(String productCode) {

		try {
			productCode = (productCode.equals(PRODUCT_CODE_COMPREHENSIVE))
					? String.valueOf(PRODUCT_CODE_COMPREHENSIVE_VAL)
					: String.valueOf(PRODUCT_CODE_TPL_VAL);
			prodDetails = ProductDetailsLocalServiceUtil.findByProductCode(productCode);
		} catch (NoSuchProductDetailsException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		} catch (NumberFormatException e) {
			_log.error(e.getMessage());
			return "";
		}
		return (prodDetails != null) ? prodDetails.getProductNameAr() : "";
	}

	public String getVehicleIdDescEn(String vichelIdype) {
		CodeMaster obj = null;
		try {
			if (obj == null && vichelIdype != null && !vichelIdype.equals(""))
				obj = CodeMasterLocalServiceUtil.findByCodeCodeSub(POLICY_STATUS_CODE, vichelIdype);
		} catch (NoSuchCodeMasterException e) {
			_log.error(e.getMessage());
			return "";
		}
		return (obj != null) ? obj.getCodeDesc() : "";
	}

	/**
	 * @return the statusDescAr
	 */
	public String getVehicleIdDescAr(String vichelIdype) {
		CodeMaster obj = null;
		try {
			if (obj == null && vichelIdype != null && !vichelIdype.equals(""))
				obj = CodeMasterLocalServiceUtil.findByCodeCodeSub(POLICY_STATUS_CODE, vichelIdype);
		} catch (NoSuchCodeMasterException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
			return "";
		}
		return (obj != null) ? obj.getCodeDescAr() : "";
	}

	private List<Quotation> getCustomQuotations(List<Quotations> quotationsList) {
		return getCustomQuotations(quotationsList, false);
	}

	public List<Quotation> getCustomQuotations(List<Quotations> quotationsList, boolean isTameeni) {
		List<Quotation> customQuotations = new ArrayList<Quotation>();
		for (Quotations quot : quotationsList) {
			Quotation customQuot = new Quotation();
			customQuot.setAddCover(quot.getAddCover());
			customQuot.setAddDriver(quot.getAddDriver());
			customQuot.setAddressAddNo(quot.getAddressAddNo());
			customQuot.setAddressBuildingNo(quot.getAddressBuildingNo());
			customQuot.setAddressDistrict(quot.getAddressDistrict());
			customQuot.setAddressStreet(quot.getAddressStreet());
			customQuot.setAddressUnitNo(quot.getAddressUnitNo());
			customQuot.setAddressZipCode(quot.getAddressZipCode());
			customQuot.setAgencyRepair(quot.getAgencyRepair());
			if (quot.getCity() != null) {
				try {
					customQuot.setCity(quot.getCity());
					CodeMaster cityDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(CITY_CODE, quot.getCity());
					if (cityDetails != null)
						customQuot.setCityDesc(cityDetails.getCodeDesc());
				} catch (NoSuchCodeMasterException e) {
					e.printStackTrace();
				}
			}
			customQuot.setQuoteStatus(quot.getQuoteStatus());
			customQuot.setVehicleMfgYear(quot.getVehicleMfgYear());
			customQuot.setVehicleCity(quot.getVehicleCity());
			customQuot.setPurposeOfVehicleDesc(quot.getPurposeVehicleDesc());
			customQuot.setDriverAgeLess21(quot.getDriverAgeLess21());
			customQuot.setAgencyRepairOut(quot.getAgencyRepairOut());
			// customQuot.getCoversList().add(quot.getQuotationCovers());
			customQuot.setDeductibleValue(quot.getDeductibleValue());
			customQuot.setInsuredDob(quot.getInsuredDob());
			customQuot.setInsuredEmail(quot.getInsuredEmail());
			customQuot.setInsuredGender(quot.getInsuredGender());
			customQuot.setInsuredId(quot.getInsuredId());
			customQuot.setInsuredIdType(quot.getInsuredIdType());
			customQuot.setInsuredMobile("" + quot.getInsuredMobile());
			customQuot.setInsuredName(quot.getInsuredName());
			customQuot.setInsuredNationality(quot.getInsuredNationality());
			customQuot.setInsuredOccupationCode(quot.getOccCode());
			customQuot.setVehicleOwnerIban(quot.getInsuredIBAN());
			customQuot
					.setLoyaltyDiscountFlag((quot.getLoyaltyDiscount() != null && !quot.getLoyaltyDiscount().equals(""))
							? Double.valueOf(quot.getLoyaltyDiscount()).intValue()
							: 0);
			customQuot.setLoyaltyDiscount("" + quot.getLoyaltyDiscountAmount());
			customQuot.setLoyaltyDiscountPer(quot.getLoyaltyDiscountPer());
			customQuot.setNcdYears(quot.getNcdYears());
			customQuot.setPaymemtAmount(quot.getPaymemtAmount());
			customQuot.setPaymentMethod(quot.getPaymentMethod());
			customQuot.setPaymentRefNo(quot.getPaymentRefNo());
			customQuot.setPolicyEffDate(quot.getPolicyEffDate());
			customQuot.setPolicyEffFromNo(quot.getPolicyEffFromNo());
			customQuot.setPolicyEffTo(quot.getPolicyEffTo());
			customQuot.setPolicyIssueDate(quot.getPolicyIssueDate());
			customQuot.setPolicyNo(quot.getPolicyNo());
			customQuot.setPolicyRefNo(quot.getPolicyRefNo());
			customQuot.setPolicyStatusCode(quot.getPolicyStatusCode());
			customQuot.setProductCode(quot.getProductCode());
			customQuot.setPurposeOfVehicle(quot.getPurposeOfVehicle());
			// customQuot.setQuotationDriver(quot.getQuotationDriver());

			// Setting additional driver data who is not under age 21 (IS_DRIVER_UNDER_21
			// column in DB = false). Should be only 1
			List<QuotationDrivers> qDrivers = QuotationDriversLocalServiceUtil.findByQuotationId(quot.getQuotationId());
			if (qDrivers != null && qDrivers.size() > 0) {
				for (QuotationDrivers addDriver : qDrivers) {
					QuotationDriver additionalDriver = new QuotationDriver();
					additionalDriver.setAddDriverId(addDriver.getAddDriverId());
					additionalDriver.setDriverId(addDriver.getDriverId());
					additionalDriver.setDriverName(addDriver.getDriverName());
					additionalDriver.setDriverIdType(addDriver.getDriverIdType());
					additionalDriver.setDriverDob(addDriver.getDriverDob());

					_log.info("getCustomQuotations. Hijri DOB:" + addDriver.getDriverDobH());
					additionalDriver.setDriverDobH(addDriver.getDriverDobH());
					additionalDriver.setQuotationId(addDriver.getQuotationId());
					additionalDriver.setDriverGender(addDriver.getDriverGender());
					additionalDriver.setDriverUnder21(false);
					additionalDriver.setNcdYears(addDriver.getNcdYears());
					additionalDriver.setDriverNationality(addDriver.getDriverNationality());
					additionalDriver.setInsuredRelative(addDriver.getInsuredRelation());
					additionalDriver.setRelationProofFileName(addDriver.getInsuredRelationProofFileName());
					additionalDriver
							.setDriverNationalityDescEN(getDriverNationalityEn(addDriver.getDriverNationality()));
					additionalDriver
							.setDriverNationalityDescAR(getDriverNationalityAr(addDriver.getDriverNationality()));
					customQuot.getQuotationDrivers().add(additionalDriver);
				}
			}

			if (isTameeni) {
				// Setting underage drivers data (IS_DRIVER_UNDER_21 column in DB = true). Can
				// be multiple
				List<QuotationDrivers> underageDrivers = QuotationDriversLocalServiceUtil
						.findUnderAgeDriversByQuotationId(quot.getQuotationId());

				if (underageDrivers.size() > 0) {
					ArrayList<QuotationDriver> underAgeDriversList = new ArrayList<QuotationDriver>();

					for (QuotationDrivers ud : underageDrivers) {
						QuotationDriver underAgeDriver = new QuotationDriver();

						underAgeDriver.setAddDriverId(ud.getAddDriverId());
						underAgeDriver.setDriverId(ud.getDriverId());
						underAgeDriver.setDriverName(ud.getDriverName());
						underAgeDriver.setDriverIdType(ud.getDriverIdType());
						underAgeDriver.setDriverDob(ud.getDriverDob());
						// underAgeDriver.setDriverDobH(ud.getDriverDob());
						underAgeDriver.setQuotationId(ud.getQuotationId());
						underAgeDriver.setDriverGender(ud.getDriverGender());
						underAgeDriver.setDriverUnder21(true);

						underAgeDriversList.add(underAgeDriver);
					}

					customQuot.setUnder21Drivers(underAgeDriversList);
				}
			}
			customQuot.setQuotationId(quot.getQuotationId());
			customQuot.setReferenceNo(quot.getReferenceNo());
			customQuot.setSource(quot.getSource());
			customQuot.setTransaction(quot.getTransaction());
			customQuot.setVehicleBodyType(quot.getVehicleBodyType());
			customQuot.setVehicleBodyTypeEn(quot.getBodyTypeEn());
			customQuot.setVehicleBodyTypeAr(quot.getBodyTypeAr());
			customQuot.setVehicleCapacity(quot.getVehicleCapacity());
			customQuot.setVehicleChassisNo(quot.getVehicleChassisNo());
			customQuot.setVehicleCylinder(quot.getVehicleCylinder());
			customQuot.setVehicleEstExpiryDate(quot.getVehicleEstExpiryDate());
			customQuot.setVehicleId(quot.getVehicleId());
			customQuot.setVehicleIdType(quot.getVehicleIdType());
			customQuot.setVehicleModel(quot.getVehicleModel());
			customQuot.setVehicleModelEn(quot.getModelEn());
			customQuot.setVehicleModelAr(quot.getModelAr());
			customQuot.setVehiclePlateL1(quot.getVehiclePlateL1());
			customQuot.setVehiclePlateL2(quot.getVehiclePlateL2());
			customQuot.setVehiclePlateL3(quot.getVehiclePlateL3());
			customQuot.setVehiclePlateNo(quot.getVehiclePlateNo());
			customQuot.setVehiclePlateType(quot.getVehiclePlateType());
			customQuot.setVehiclePlateTypeDesc(quot.getVehiclePlateTypeDescEn());
			customQuot.setVehicleValue(quot.getVehicleValue());
			customQuot.setVehicleWeight(quot.getVehicleWeight());
			customQuot.setVehicleColor(quot.getVehicleColor());
			customQuot.setVehicleColorAr(quot.getColorDescAr());
			customQuot.setVehicleColorEn(quot.getColorDescEn());
			customQuot.setVehicleMake(quot.getVehicleMake());
			customQuot.setVehicleMakeEn(quot.getMakeDescEn());
			customQuot.setVehicleMakeAr(quot.getMakeDescAr());
			customQuot.setProductDescEn(getProductDescEn(quot.getProductCode()));
			customQuot.setProductDescAr(getProductDescAr(quot.getProductCode()));

			customQuot.setSaeedService(quot.getSaeedService());
			customQuot.setTotalAfterDiscount(quot.getTotalAfterDiscount());
			customQuot.setTotalBeforeDiscount(quot.getTotalBeforeDisc());
			customQuot.setDriverAccidents(quot.getDriverAccidents());
			customQuot.setSmsFlag(quot.getSmsFlag());
			customQuot.setGrossPrem(quot.getGrossPrem());
			customQuot.setNetPrem(quot.getNetPrem());
			customQuot.setDiscountAmount(quot.getDiscountAmount());
			customQuot.setDiscountPrem(quot.getDiscountPrem());
			customQuot.setPolicyTaxes(quot.getPolicyTaxes());
			customQuot.setPolicyFees(quot.getPolicyFees());
			// Ahmed AE Fattah : 10-5-2018 / Add Mapping for Total Cover Premium
			customQuot.setTotalCoverPrem(quot.getTotalCoverPrem());
			// Ahmed AE Fattah : 10-5-2018 / Add Mapping for Quotation Submission Date
			customQuot.setQuoteSubmissionDate(quot.getQuoteSubmissionDate());
			customQuot.setLoadingAmount(quot.getLoadingAmount());
			customQuot.setExistingCompanyName(quot.getExistingCompanyName());
			customQuot.setExistingPolicyNo(quot.getExistingPolicyNo());
			customQuot.setExistingExpDate(quot.getExistingExpDate());
			customQuotations.add(customQuot);

		}
		return customQuotations;
	}

	public List<CodeMasterDetails> getPurposeOfVehicle() {
		List<CodeMasterDetails> codesList = new ArrayList<>();
		try {
			codesList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(PURPOSE_OF_VEHICLE_CODE);
		} catch (NoSuchCodeMasterException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		return codesList;
	}

	public List<CodeMasterDetails> getDeductibleValues() {
		List<CodeMasterDetails> codesList = new ArrayList<>();
		try {
			codesList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(DEDUCTIBLE_VALUE_CODE);
			Collections.sort(codesList, new Comparator<CodeMasterDetails>() {
				public int compare(CodeMasterDetails o1, CodeMasterDetails o2) {
					if (o1.getCodeDesc() != null && o2.getCodeDesc() != null
							&& Long.valueOf(o1.getCodeDesc()) == Long.valueOf(o2.getCodeDesc()))
						return 0;
					else if (o1.getCodeDesc() != null && o2.getCodeDesc() != null
							&& Long.valueOf(o1.getCodeDesc()) < Long.valueOf(o2.getCodeDesc()))
						return -1;
					else
						return 1;
				}
			});
		} catch (PortalException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		return codesList;
	}

	public List<CodeMasterDetails> getParkingLocations() {
		List<CodeMasterDetails> codesList = new ArrayList<>();
		try {
			codesList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(PARKING_LOCATION_CODE);

		} catch (PortalException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		return codesList;
	}

	public List<CodeMasterDetails> geEngineSizes() {
		List<CodeMasterDetails> codesList = new ArrayList<>();
		try {
			codesList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ENGINE_SIZE_CODE);

		} catch (PortalException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		return codesList;
	}

	public List<CodeMasterDetails> getCountries() {
		List<CodeMasterDetails> codesList = new ArrayList<>();
		try {
			codesList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(NATIONALITY_CODE);
		} catch (NoSuchCodeMasterException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		return codesList;
	}

	public List<CodeMasterDetails> getLicenseTypes() {
		List<CodeMasterDetails> codesList = new ArrayList<>();
		try {
			codesList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(LICENSE_TYPE_CODE);
		} catch (NoSuchCodeMasterException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		return codesList;
	}

	public List<CodeMasterDetails> getEducationList() {
		List<CodeMasterDetails> codesList = new ArrayList<>();
		try {
			codesList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(EDUCATION_CODE);
		} catch (NoSuchCodeMasterException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		return codesList;
	}

	public List<CodeMasterDetails> getCities() {
		List<CodeMasterDetails> codesList = new ArrayList<>();
		try {
			codesList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(CITY_CODE);
		} catch (NoSuchCodeMasterException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		return codesList;
	}

	public String getDriverNationalityEn(String driverNa) {
		CodeMaster driverNationality = null;
		try {
			driverNationality = CodeMasterLocalServiceUtil.findByCodeCodeSub(NATIONALITY_CODE, driverNa);
		} catch (NoSuchCodeMasterException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		return (driverNationality != null && driverNationality.equals("")) ? driverNationality.getCodeDesc() : "";
	}

	public String getDriverNationalityAr(String driverNa) {
		CodeMaster driverNationality = null;
		try {
			driverNationality = CodeMasterLocalServiceUtil.findByCodeCodeSub(NATIONALITY_CODE, driverNa);
		} catch (NoSuchCodeMasterException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		return (driverNationality != null && driverNationality.equals("")) ? driverNationality.getCodeDescAr() : "";
	}

	public List<CustomerMapDetails> getInsuranceCompanies() {
		List<CustomerMap> custs = CustomerMapLocalServiceUtil.findByCustCatgAndType(CUSTOMER_CATG_CUSTOMER,
				CUSTOMER_TYPE_CUSTOMER);
		List<CustomerMapDetails> cutsList = new ArrayList<>();
		if (custs != null)
			for (CustomerMap cust : custs) {
				CustomerMapDetails custDets = new CustomerMapDetails();
				custDets.setCode(cust.getPremiaCode());
				custDets.setName(cust.getName());
				custDets.setNameAr(cust.getNameAr());

				cutsList.add(custDets);
			}
		return cutsList;
	}

	public List<CustomerMapDetails> getInsuranceCompany(String premiaCode) {
		List<CustomerMap> custs = CustomerMapLocalServiceUtil.findByCustCatgTypeCode(CUSTOMER_CATG_CUSTOMER,
				CUSTOMER_TYPE_CUSTOMER, premiaCode);
		List<CustomerMapDetails> cutsList = new ArrayList<>();
		if (custs != null)
			for (CustomerMap cust : custs) {
				CustomerMapDetails custDets = new CustomerMapDetails();
				custDets.setCode(cust.getPremiaCode());
				custDets.setName(cust.getName());
				custDets.setNameAr(cust.getNameAr());

				cutsList.add(custDets);
			}
		return cutsList;
	}

	public List<QuotationCover> getCoverList(String productCode) {
		// the product code value is hardcoded because they expect "OD" or "TP" while
		// this field is numberic in the DB
		// table !
		int productCodeVal = (productCode.equals(PRODUCT_CODE_COMPREHENSIVE)) ? PRODUCT_CODE_COMPREHENSIVE_VAL
				: PRODUCT_CODE_TPL_VAL;
		List<ProductCovers> productCovers = ProductCoversLocalServiceUtil.findByProductCode(productCodeVal);
		List<QuotationCover> qCovers = getCustomCovers(productCovers);

		return qCovers;
	}

	public List<QuotationCover> getCustomCovers(List<ProductCovers> pCovers) {
		List<QuotationCover> qCovers = new ArrayList<>();
		if (pCovers != null)
			for (ProductCovers pCover : pCovers) {
				QuotationCover qCover = new QuotationCover();
				qCover.setCoverCode(pCover.getCoverCode());
				if (pCover.getCoverPremium() != null)
					qCover.setCoverPrem(Long.valueOf(pCover.getCoverPremium()));
				qCover.setCoverName(pCover.getCoverName());
				qCover.setCoverNameAr(pCover.getCoverNameAr());
				qCover.setCoverDesc(pCover.getCoverDesc());
				qCover.setCoverDescAr(pCover.getCoverDescAr());
				qCover.setField1(pCover.getCoverFld1());
				qCover.setField2(pCover.getCoverFld2());
				qCover.setField3(pCover.getCoverFld3());
				qCover.setField4(pCover.getCoverFld4());
				qCover.setSectionCode(pCover.getSectionCode());
				// qCover.setCoverEffToDate(pCover.getCoverToDate());
				// qCover.setCoverPrem(Long.valueOf(pCover.getDrltPremium()));
				// qCover.setCoverRate(pCover.get);

				qCovers.add(qCover);
			}
		return qCovers;
	}

	@Transactional(readOnly = false, rollbackFor = { PortalException.class, SystemException.class,
			ModelListenerException.class }, propagation = Propagation.REQUIRED)
	public Quotation submitQuotation(Quotation customQuot, String userId) {
		_log.info("submitQuotation fn -- Start");
		_log.info("Custom Quotation");
		_log.info(customQuot.toString());
		Quotations quot = QuotationsLocalServiceUtil.createQuotations((int) CounterLocalServiceUtil.increment());
		quot.setAddressAddNo(customQuot.getAddressAddNo());
		quot.setAddressBuildingNo(customQuot.getAddressBuildingNo());
		quot.setAddressDistrict(customQuot.getAddressDistrict());
		quot.setAddressStreet(customQuot.getAddressStreet());
		quot.setAddressUnitNo(customQuot.getAddressUnitNo());
		quot.setAddressZipCode(customQuot.getAddressZipCode());
		quot.setAgencyRepair(customQuot.getAgencyRepair());
		quot.setCity(customQuot.getCity());
		quot.setDeductibleValue(customQuot.getDeductibleValue());
		quot.setInsuredDob(customQuot.getInsuredDob());
		quot.setInsuredDobH(customQuot.getInsuredDobH());
		quot.setExistingCompanyName(customQuot.getExistingCompanyName());
		quot.setExistingExpDate(customQuot.getExistingExpDate());
		quot.setExistingPolicyNo(customQuot.getExistingPolicyNo());
		quot.setInsuredEmail(customQuot.getInsuredEmail());
		quot.setInsuredGender(customQuot.getInsuredGender());
		quot.setInsuredId(customQuot.getInsuredId());
		quot.setInsuredIdType(customQuot.getInsuredIdType());
		quot.setInsuredMobile(Long.valueOf(customQuot.getInsuredMobile()));
		quot.setOccCode(customQuot.getInsuredOccupationCode());
		quot.setInsuredIBAN(customQuot.getVehicleOwnerIban());
		quot.setInsuredName(customQuot.getInsuredName());
		quot.setInsuredNationality(customQuot.getInsuredNationality());
		quot.setInsuredEducation(customQuot.getInsuredEducation());
		quot.setInsuredMaritalStatus(customQuot.getInsuredMaritalStatus());
		quot.setInsuredNoChildUnder16(customQuot.getInsuredNoChildUnder16());
		quot.setLoyaltyDiscount("" + customQuot.getLoyaltyDiscountFlag());
		quot.setNcdYears(customQuot.getNcdYears());
		quot.setPolicyEffDate(customQuot.getPolicyEffDate());
		quot.setPolicyEffFromNo(customQuot.getPolicyEffFromNo());
		quot.setPolicyEffTo(customQuot.getPolicyEffTo());
		quot.setPolicyIssueDate(customQuot.getPolicyIssueDate());
		// quot.setPolicyNo(customQuot.getPolicyNo());
		quot.setProductCode(customQuot.getProductCode());
		quot.setPurposeOfVehicle(customQuot.getPurposeOfVehicle());
		quot.setSaeedService(customQuot.getSaeedService());
		if (customQuot.getReferenceNo() == null)
			quot.setReferenceNo(generateRefNo(customQuot.getProductCode()));
		else
			quot.setReferenceNo(customQuot.getReferenceNo());
		// Kareem Setting policy number as reference number for now
		quot.setPolicyNo(quot.getReferenceNo());

		quot.setTransaction(customQuot.getTransaction());
		quot.setVehicleBodyType(customQuot.getVehicleBodyType());
		quot.setVehicleCapacity(customQuot.getVehicleCapacity());
		quot.setSource(customQuot.getSource());
		quot.setVehicleChassisNo(customQuot.getVehicleChassisNo());
		quot.setVehicleColor(customQuot.getVehicleColor());
		quot.setVehicleCylinder(customQuot.getVehicleCylinder());
		quot.setVehicleCity(customQuot.getVehicleCity());
		// Ahmed AE Fattah : 15-4-2018
		// Temp Change for testing
		// quot.setVehicleEstExpiryDate(customQuot.getVehicleEstExpiryDate());
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DATE, 3);
		quot.setVehicleEstExpiryDate(c.getTime());
		quot.setVehicleId(customQuot.getVehicleId());
		quot.setVehicleIdType(customQuot.getVehicleIdType());
		quot.setVehicleMake(customQuot.getVehicleMake());
		quot.setVehicleMfgYear(customQuot.getVehicleMfgYear());
		quot.setVehicleModel(customQuot.getVehicleModel());
		quot.setVehiclePlateL1(customQuot.getVehiclePlateL1());
		quot.setVehiclePlateL2(customQuot.getVehiclePlateL2());
		quot.setVehiclePlateL3(customQuot.getVehiclePlateL3());
		quot.setVehiclePlateType(customQuot.getVehiclePlateType());
		quot.setVehiclePlateNo(customQuot.getVehiclePlateNo());
		quot.setVehicleValue(customQuot.getVehicleValue());
		quot.setVehicleWeight(customQuot.getVehicleWeight());
		quot.setVehicleCurrentMileage(customQuot.getVehicleCurrentMileage());
		quot.setVehicleUpperExpectedMileagePerYear(customQuot.getVehicleUpperExpectedMileagePerYear());
		quot.setVehicleLowerExpectedMileagePerYear(customQuot.getVehicleLowerExpectedMileagePerYear());
		quot.setVehicleNightLocation(customQuot.getVehicleNightLocation());
		quot.setVehicleEngineSize(customQuot.getVehicleEngineSize());
		quot.setVehicleTransType(customQuot.getVehicleTransType());
		quot.setVehAxleWeight(customQuot.getVehAxleWeight());
		quot.setVehCarMods(customQuot.getVehCarMods());
		quot.setVehSpecs(customQuot.getVehicleSpecs());

		quot.setNetPrem(customQuot.getNetPrem());
		quot.setDiscountAmount(customQuot.getDiscountAmount());
		if (customQuot.getLoyaltyDiscount() != null && !customQuot.getLoyaltyDiscount().equals(""))
			quot.setLoyaltyDiscountAmount(Double.valueOf(customQuot.getLoyaltyDiscount()));
		quot.setDiscountPrem(customQuot.getDiscountPrem());
		quot.setLoyaltyDiscountPer(customQuot.getLoyaltyDiscountPer());
		quot.setLoadingAmount(customQuot.getLoadingAmount());
		quot.setPolicyTaxes(customQuot.getPolicyTaxes());
		quot.setPolicyFees(customQuot.getPolicyFees());
		quot.setTotalCoverPrem(customQuot.getTotalCoverPrem());
		quot.setGrossPrem(customQuot.getGrossPrem());
		if (customQuot.isRenew() && customQuot.getQuoteStatus() != null)
			quot.setQuoteStatus(customQuot.getQuoteStatus());
		else
			// quot.setQuoteStatus((quot.getProductCode().equals(PRODUCT_CODE_TPL)) ?
			// QUOTATION_STATUS_PENDING_PAYMENT : QUOTATION_STATUS_PENDING_SURVEY);
			quot.setQuoteStatus((quot.getProductCode().equals(PRODUCT_CODE_TPL)) ? QUOTATION_STATUS_PENDING_PAYMENT
					: QUOTATION_STATUS_PENDING_PAYMENT);

		// Ahmed AE Fattah : 15-4-2018 / Save Quotation Submission Date
		quot.setQuoteSubmissionDate(new Date());
		quot.setAgencyRepairOut(customQuot.getAgencyRepairOut());
		quot.setDriverAgeLess21(customQuot.getDriverAgeLess21());

		quot = QuotationsLocalServiceUtil.addQuotations(quot);

		_log.info(
				"After addQuotations. Reference:" + quot.getReferenceNo() + ". Quotation ID:" + quot.getQuotationId());

		customQuot.setReferenceNo(quot.getReferenceNo());
		customQuot.setQuotationId(quot.getQuotationId());
		if (!customQuot.isRenew() && customQuot.getQuoteStatus() == null)
			// customQuot.setQuoteStatus((quot.getProductCode().equals(PRODUCT_CODE_TPL)) ?
			// QUOTATION_STATUS_PENDING_PAYMENT : QUOTATION_STATUS_PENDING_SURVEY);
			customQuot
					.setQuoteStatus((quot.getProductCode().equals(PRODUCT_CODE_TPL)) ? QUOTATION_STATUS_PENDING_PAYMENT
							: QUOTATION_STATUS_PENDING_PAYMENT);

		customQuot.setPolicyNo(quot.getPolicyNo());

		double finalNetPrem = quot.getNetPrem() - quot.getDiscountAmount() - quot.getLoyaltyDiscountAmount()
				+ quot.getLoadingAmount() + quot.getPolicyFees() + quot.getTotalCoverPrem();
		// double vat = (0.05 * finalNetPrem);
		double vat = (0.15 * finalNetPrem);
		finalNetPrem += vat;
		quot.setNetPrem(finalNetPrem);

		// Saving National address
		_log.info("Calling createQuotationsUserAddress");
		QuotationsUserAddress insuredNatAdd = QuotationsUserAddressLocalServiceUtil
				.createQuotationsUserAddress((int) CounterLocalServiceUtil.increment());
		insuredNatAdd.setAddNo("" + customQuot.getAddressAddNo());
		insuredNatAdd.setBuildNo("" + customQuot.getAddressBuildingNo());
		insuredNatAdd.setZipCode("" + customQuot.getAddressZipCode());
		insuredNatAdd.setCityAr(customQuot.getCityDesc());
		insuredNatAdd.setCityEn(customQuot.getCityDesc());
		insuredNatAdd.setDistrictAr(customQuot.getAddressDistrict());
		insuredNatAdd.setDistrictEn(customQuot.getAddressDistrict());
		insuredNatAdd.setStNameAr(customQuot.getAddressStreet());
		insuredNatAdd.setStNameEn(customQuot.getAddressStreet());
		insuredNatAdd.setIsNatAddress(true);
		insuredNatAdd.setQuotationId(customQuot.getQuotationId());
		insuredNatAdd.setDriverId(customQuot.getInsuredId());
		_log.info("addQuotationsUserAddress -- before");
		insuredNatAdd = QuotationsUserAddressLocalServiceUtil.addQuotationsUserAddress(insuredNatAdd);
		_log.info("addQuotationsUserAddress -- after");

		if (customQuot.getCoversList() != null && !customQuot.getCoversList().isEmpty()) {
			for (QuotationCover customCover : customQuot.getCoversList()) {
				QuotationCoversPK pk = new QuotationCoversPK();
				pk.setAddCoverId((int) CounterLocalServiceUtil.increment());
				pk.setQuotationId(quot.getQuotationId());
				QuotationCovers cover = QuotationCoversLocalServiceUtil.createQuotationCovers(pk);
				cover.setCoverCode(customCover.getCoverCode());
				cover.setCoverEffFromDate(customCover.getCoverEffFromDate());
				cover.setCoverEffToDate(customCover.getCoverEffToDate());
				cover.setCoverPrem(customCover.getCoverPrem());
				cover.setCoverRate(customCover.getCoverRate());
				cover.setSectionCode(customCover.getSectionCode());
				cover = QuotationCoversLocalServiceUtil.addQuotationCovers(cover);
				customCover.setAddCoverId(cover.getAddCoverId());
			}
		}

		if (customQuot.getQuotationDrivers() != null && !customQuot.getQuotationDrivers().isEmpty()) {
			for (QuotationDriver customDrv : customQuot.getQuotationDrivers()) {
				QuotationDriversPK pk = new QuotationDriversPK();
				pk.setAddDriverId((int) CounterLocalServiceUtil.increment());
				// pk.setQuotationId(quot.getQuotationId());
				QuotationDrivers driver = QuotationDriversLocalServiceUtil
						.createQuotationDrivers((int) CounterLocalServiceUtil.increment());
				driver.setDriverDob(customDrv.getDriverDob());

				_log.info("Add Driver Hijri DOB:" + customDrv.getDriverDobH());

				if (customDrv.getDriverDobH().indexOf("/") > 0) {
					String[] hijriDob = customDrv.getDriverDobH().split("/");
					driver.setDriverDobH(hijriDob[2] + "-" + hijriDob[1] + "-" + hijriDob[0]);
					_log.info("Saving Driver Hijri DOB:" + driver.getDriverDobH());
				}

				driver.setQuotationId(quot.getQuotationId());
				driver.setDriverGender(customDrv.getDriverGender());
				driver.setDriverId(customDrv.getDriverId());
				driver.setDriverIdType(customDrv.getDriverIdType());
				driver.setDriverName(customDrv.getDriverName());
				driver.setDriverNationality(customDrv.getDriverNationality());
				driver.setIsDriverUnder21(false);

				driver.setDriverEdu(customDrv.getDriverEdu());
				driver.setDriverNoChild(customDrv.getDriverNoChild());
				driver.setDriverMaritalStatus(customDrv.getDriverMaritalStatus());
				driver.setDriverNOFault(customDrv.getDriverNOFault());
				driver.setDriverNOClaim(customDrv.getDriverNOClaim());
				driver.setDriverConvictions(customDrv.getDriverConvictions());
				driver.setDriverMedConds(customDrv.getDriverMedConds());
				driver.setNcdYears(customDrv.getNcdYears());

				// Ahmed AE Fattah - NCD CR - Requested By Gasser
				// move the uploaded files from temp folder into DB
				if (customDrv.getRelationProofFileName() != null) {
					ByteArrayFileInputStream inputStream = null;
					File file = null;
					String uploadDir = PropsUtil.get("policy.upload.dir");
					uploadDir += "/" + customDrv.getDriverId() + "/";
					file = new File(uploadDir + customDrv.getRelationProofFileName());
					inputStream = new ByteArrayFileInputStream(file, 1024);

					try {
						driver.setInsuredRelationProof(
								new javax.sql.rowset.serial.SerialBlob(FileUtil.getBytes(inputStream)));
						driver.setInsuredRelationProofFileName(customDrv.getRelationProofFileName());
					} catch (SerialException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				driver.setInsuredRelation(customDrv.getInsuredRelative());

				// END
				_log.info("addQuotationDrivers -- before");
				driver = QuotationDriversLocalServiceUtil.addQuotationDrivers(driver);
				_log.info("addQuotationDrivers -- after");
				customDrv.setAddDriverId(driver.getAddDriverId());

				if (customDrv.getDriverNatAddress() != null) {
					QuotationUserAddress custUserNatAddr = customDrv.getDriverNatAddress();
					QuotationsUserAddress userNatAdd = QuotationsUserAddressLocalServiceUtil
							.createQuotationsUserAddress((int) CounterLocalServiceUtil.increment());

					userNatAdd.setAddNo(custUserNatAddr.getAddNo());
					userNatAdd.setBuildNo(custUserNatAddr.getBuildNo());
					userNatAdd.setZipCode(custUserNatAddr.getZipCode());

					userNatAdd.setCityAr(custUserNatAddr.getCity());
					userNatAdd.setCityEn(custUserNatAddr.getCity());
					userNatAdd.setDistrictAr(custUserNatAddr.getDistrict());
					userNatAdd.setDistrictEn(custUserNatAddr.getDistrict());
					userNatAdd.setStNameAr(custUserNatAddr.getStName());
					userNatAdd.setStNameEn(custUserNatAddr.getStName());
					userNatAdd.setIsNatAddress(true);

					userNatAdd.setQuotationId(quot.getQuotationId());
					userNatAdd.setDriverId(driver.getDriverId());
					_log.info("addQuotationsUserAddress -- before");
					userNatAdd = QuotationsUserAddressLocalServiceUtil.addQuotationsUserAddress(userNatAdd);
					_log.info("addQuotationsUserAddress -- after");
					custUserNatAddr.setUserAddressId(userNatAdd.getUserAddressId());
				}

				if (customDrv.getDriverOffNatAddress() != null) {
					QuotationUserAddress custUserOffAddr = customDrv.getDriverOffNatAddress();
					QuotationsUserAddress userOffAdd = QuotationsUserAddressLocalServiceUtil
							.createQuotationsUserAddress((int) CounterLocalServiceUtil.increment());

					userOffAdd.setAddNo(custUserOffAddr.getAddNo());
					userOffAdd.setBuildNo(custUserOffAddr.getBuildNo());
					userOffAdd.setZipCode(custUserOffAddr.getZipCode());

					userOffAdd.setCityAr(custUserOffAddr.getCity());
					userOffAdd.setCityEn(custUserOffAddr.getCity());
					userOffAdd.setDistrictAr(custUserOffAddr.getDistrict());
					userOffAdd.setDistrictEn(custUserOffAddr.getDistrict());
					userOffAdd.setStNameAr(custUserOffAddr.getStName());
					userOffAdd.setStNameEn(custUserOffAddr.getStName());
					userOffAdd.setIsNatAddress(false);

					userOffAdd.setQuotationId(quot.getQuotationId());
					userOffAdd.setDriverId(driver.getDriverId());

					userOffAdd = QuotationsUserAddressLocalServiceUtil.addQuotationsUserAddress(userOffAdd);
					custUserOffAddr.setUserAddressId(userOffAdd.getUserAddressId());
				}

				if (customDrv.getDriverLicences() != null && !customDrv.getDriverLicences().isEmpty()) {
					for (QuotationDriverLicense customLic : customDrv.getDriverLicences()) {
						QuotationsDriverLicense drvLic = QuotationsDriverLicenseLocalServiceUtil
								.createQuotationsDriverLicense((int) CounterLocalServiceUtil.increment());
						drvLic.setDriverId(driver.getDriverId());
						drvLic.setQuotationId(quot.getQuotationId());

						drvLic.setLicCountry(customLic.getLicCountry());
						drvLic.setLicType(customLic.getLicType());
						drvLic.setLicYrs(customLic.getLicYrs());

						drvLic = QuotationsDriverLicenseLocalServiceUtil.addQuotationsDriverLicense(drvLic);
						customLic.setLicenseId(drvLic.getLicenseId());
					}
				}
			}
		}

		if (customQuot.getUnder21Drivers() != null) {
			for (QuotationDriver driver : customQuot.getUnder21Drivers()) {
				QuotationDriversPK pk = new QuotationDriversPK();
				pk.setAddDriverId((int) CounterLocalServiceUtil.increment());
				pk.setQuotationId(quot.getQuotationId());
				QuotationDrivers underAgeDriver = QuotationDriversLocalServiceUtil
						.createQuotationDrivers((int) CounterLocalServiceUtil.increment());
				underAgeDriver.setDriverDob(driver.getDriverDob());
				underAgeDriver.setDriverGender(driver.getDriverGender());
				underAgeDriver.setDriverId(driver.getDriverId());
				underAgeDriver.setDriverIdType(driver.getDriverIdType());
				underAgeDriver.setDriverName(driver.getDriverName());
				underAgeDriver.setDriverNationality(driver.getDriverNationality());
				underAgeDriver.setIsDriverUnder21(true);
				_log.info("addQuotationDrivers -- before");
				underAgeDriver = QuotationDriversLocalServiceUtil.addQuotationDrivers(underAgeDriver);
				_log.info("addQuotationDrivers -- after");
			}
		}

		ByteArrayFileInputStream inputStream = null;
		File file = null;
		String uploadDir = PropsUtil.get("policy.upload.dir");
		uploadDir += "/" + userId + "/";

		_log.info("uploadDir:" + uploadDir);
		CustUploads uploads = CustUploadsLocalServiceUtil.createCustUploads((int) CounterLocalServiceUtil.increment());
		uploads.setQuotId("" + quot.getQuotationId());
		if (customQuot.getIdFileName() != null && !customQuot.getIdFileName().equals("")) {
			try {
				file = new File(uploadDir + customQuot.getIdFileName());
				inputStream = new ByteArrayFileInputStream(file, 1024);
				uploads.setIdFile(new javax.sql.rowset.serial.SerialBlob(FileUtil.getBytes(inputStream)));
				uploads.setIdFileName(customQuot.getIdFileName());
			} catch (Exception e) {
				_log.error(e.getMessage());
				e.printStackTrace();
			}
		}
		if (customQuot.getLicenseFileName() != null && !customQuot.getLicenseFileName().equals("")) {
			try {
				file = new File(uploadDir + customQuot.getLicenseFileName());
				inputStream = new ByteArrayFileInputStream(file, 1024);
				uploads.setLicenseFile(new javax.sql.rowset.serial.SerialBlob(FileUtil.getBytes(inputStream)));
				uploads.setLicenseFileName(customQuot.getLicenseFileName());
			} catch (Exception e) {
				_log.error(e.getMessage());
				e.printStackTrace();
			}
		}
		if (customQuot.getIstCardFileName() != null && !customQuot.getIstCardFileName().equals("")) {
			try {
				file = new File(uploadDir + customQuot.getIstCardFileName());
				inputStream = new ByteArrayFileInputStream(file, 1024);
				uploads.setIstCardFile(new javax.sql.rowset.serial.SerialBlob(FileUtil.getBytes(inputStream)));
				uploads.setIstCardFileName(customQuot.getIstCardFileName());
			} catch (Exception e) {
				_log.error(e.getMessage());
				e.printStackTrace();
			}
		}

		if (customQuot.getCustCardFileName() != null && !customQuot.getCustCardFileName().equals("")) {
			try {
				file = new File(uploadDir + customQuot.getCustCardFileName());
				inputStream = new ByteArrayFileInputStream(file, 1024);
				uploads.setIstCardFile(new javax.sql.rowset.serial.SerialBlob(FileUtil.getBytes(inputStream)));
				uploads.setIstCardFileName(customQuot.getCustCardFileName());
			} catch (Exception e) {
				_log.error(e.getMessage());
				e.printStackTrace();
			}
		}

		if (customQuot.getCarFrontFileName() != null && !customQuot.getCarFrontFileName().equals("")) {
			try {
				file = new File(uploadDir + customQuot.getCarFrontFileName());
				inputStream = new ByteArrayFileInputStream(file, 1024);
				uploads.setCarFrontFile(new javax.sql.rowset.serial.SerialBlob(FileUtil.getBytes(inputStream)));
				uploads.setCarFrontFileName(customQuot.getCarFrontFileName());
			} catch (Exception e) {
				_log.error(e.getMessage());
				e.printStackTrace();
			}
		}
		if (customQuot.getCarBackFileName() != null && !customQuot.getCarBackFileName().equals("")) {
			try {
				file = new File(uploadDir + customQuot.getCarBackFileName());
				inputStream = new ByteArrayFileInputStream(file, 1024);
				uploads.setCarBackFile(new javax.sql.rowset.serial.SerialBlob(FileUtil.getBytes(inputStream)));
				uploads.setCarBackFileName(customQuot.getCarBackFileName());
			} catch (Exception e) {
				_log.error(e.getMessage());
				e.printStackTrace();
			}
		}
		if (customQuot.getCarLeftFileName() != null && !customQuot.getCarLeftFileName().equals("")) {
			try {
				file = new File(uploadDir + customQuot.getCarLeftFileName());
				inputStream = new ByteArrayFileInputStream(file, 1024);
				uploads.setCarLeftFile(new javax.sql.rowset.serial.SerialBlob(FileUtil.getBytes(inputStream)));
				uploads.setCarLeftFileName(customQuot.getCarLeftFileName());
			} catch (Exception e) {
				_log.error(e.getMessage());
				e.printStackTrace();
			}
		}
		if (customQuot.getCarRightFileName() != null && !customQuot.getCarRightFileName().equals("")) {
			try {
				file = new File(uploadDir + customQuot.getCarRightFileName());
				inputStream = new ByteArrayFileInputStream(file, 1024);
				uploads.setCarRightFile(new javax.sql.rowset.serial.SerialBlob(FileUtil.getBytes(inputStream)));
				uploads.setCarRightFileName(customQuot.getCarRightFileName());
			} catch (Exception e) {
				_log.error(e.getMessage());
				e.printStackTrace();
			}
		}
		if (customQuot.getEngChassisNoFileName() != null && !customQuot.getEngChassisNoFileName().equals("")) {
			try {
				file = new File(uploadDir + customQuot.getEngChassisNoFileName());
				inputStream = new ByteArrayFileInputStream(file, 1024);
				uploads.setEngChassisNoFile(new javax.sql.rowset.serial.SerialBlob(FileUtil.getBytes(inputStream)));
				uploads.setEngChassisNoFileName(customQuot.getEngChassisNoFileName());
			} catch (Exception e) {
				_log.error(e.getMessage());
				e.printStackTrace();
			}
		}

		if (customQuot.getLeaseFileName() != null && !customQuot.getLeaseFileName().equals("")) {
			try {
				file = new File(uploadDir + customQuot.getLeaseFileName());
				inputStream = new ByteArrayFileInputStream(file, 1024);
				uploads.setLeaseFile(new javax.sql.rowset.serial.SerialBlob(FileUtil.getBytes(inputStream)));
				uploads.setLeaseFileName(customQuot.getLeaseFileName());
			} catch (Exception e) {
				_log.error(e.getMessage());
				e.printStackTrace();
			}
		}

		try {
			if (uploads.getCarBackFile() != null || uploads.getCarFrontFile() != null
					|| uploads.getCarRightFile() != null || uploads.getCarLeftFile() != null
					|| uploads.getLeaseFile() != null || uploads.getIdFile() != null || uploads.getLicenseFile() != null
					|| uploads.getIstCardFile() != null || uploads.getEngChassisNoFile() != null) {
				_log.info("Adding cust uploads");
				uploads = CustUploadsLocalServiceUtil.addCustUploads(uploads);

				File destFolder = new File(uploadDir);
				File[] files = destFolder.listFiles();
				if (files != null) {
					for (File f : files) {
						f.delete();
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		_log.info("Adding quotation history");
		QuotationStatusHistory history = QuotationStatusHistoryLocalServiceUtil
				.createQuotationStatusHistory((int) CounterLocalServiceUtil.increment());
		history.setDateTime(new Date());
		history.setQuotationId(quot.getQuotationId());
		history.setUserName("" + quot.getInsuredId());
		history.setStatus(quot.getProductCode().equals(PRODUCT_CODE_TPL) ? QUOTATION_STATUS_PENDING_PAYMENT
				: QUOTATION_STATUS_PENDING_PAYMENT);
		history = QuotationStatusHistoryLocalServiceUtil.addQuotationStatusHistory(history);
		_log.info("Quotation Submitted Successfully");

		customQuot.setQuoteSubmissionDate(new Date());

		_log.info("submitQuotation fn -- End");
		return customQuot;
	}

	private synchronized String generateRefNo(String productCode) {
		String refNo = (productCode.equals(PRODUCT_CODE_COMPREHENSIVE)) ? PRODUCT_CODE_COMPREHENSIVE_REF
				: PRODUCT_CODE_TPL_REF;
		try {
			Calendar cal = new GregorianCalendar();
			cal.setTime(new Date());
			int year = cal.get(Calendar.YEAR);

			refNo += year;

			long refSeq = 1;
			QuotationsSeq seq = null;
			try {
				seq = QuotationsSeqLocalServiceUtil.findByKey("SEQ_" + year);
			} catch (NoSuchQuotationsSeqException e) {
				_log.error(e.getMessage());
				System.out.println(e.getMessage());
			}

			if (seq != null) {
				refSeq = Long.valueOf(seq.getValue()) + 1;
				seq.setValue("" + refSeq);
				QuotationsSeqLocalServiceUtil.updateQuotationsSeq(seq);
			} else {
				QuotationsSeq quotSeq = QuotationsSeqLocalServiceUtil.createQuotationsSeq("SEQ_" + year);
				quotSeq.setValue("" + refSeq);
				QuotationsSeqLocalServiceUtil.addQuotationsSeq(quotSeq);
			}

			refNo += refSeq;
		} catch (Exception e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		return refNo;
	}

	private List<QuotationAdminUpload> getCustomQuotationAdminUploads(
			List<QuotationAdminUploads> quotationAdminUploadsList) throws PortalException {
		List<QuotationAdminUpload> customQuotationAdminUploads = new ArrayList<QuotationAdminUpload>();
		for (QuotationAdminUploads quotAdminUploads : quotationAdminUploadsList) {
			QuotationAdminUpload customAdminUploads = new QuotationAdminUpload();
			customAdminUploads.setId(quotAdminUploads.getId());
			customAdminUploads.setQuotationId(quotAdminUploads.getQuotationId());
			customAdminUploads.setFileName(quotAdminUploads.getFileName());
			customQuotationAdminUploads.add(customAdminUploads);
		}
		return (customQuotationAdminUploads);
	}

	public QuotationCustUploads getCustomQuotationCustUploads(String quotationId) throws PortalException {
		_log.info("getCustomQuotationCustUploads-start");
		try {
			QuotationCustUploads customCustUploads = new QuotationCustUploads();
			_log.info("Finding by quotId:" + quotationId);
			CustUploads uploads = CustUploadsUtil.findByquotId(quotationId);

			_log.info("Car file names now:" + uploads.getCarFrontFileName() + " " + uploads.getCarBackFileName() + " "
					+ uploads.getCarLeftFileName() + " " + uploads.getCarRightFileName() + " "
					+ uploads.getEngChassisNoFileName() + " ");

			customCustUploads.setId(CustUploadsLocalServiceUtil.findIdByQuotationId(quotationId));
			// customCustUploads.setQuotationId(quotationCustUploads.getQuotId());
			customCustUploads.setIdFileName(CustUploadsLocalServiceUtil.findidFileNameByQuotationId(quotationId));
			customCustUploads.setLicenseFileName(CustUploadsLocalServiceUtil.findlicenseByQuotationId(quotationId));
			customCustUploads.setIstFileName(CustUploadsLocalServiceUtil.findistCardByQuotationId(quotationId));

			customCustUploads.setCarFrontFileName(uploads.getCarFrontFileName());
			customCustUploads.setCarBackFileName(uploads.getCarBackFileName());
			customCustUploads.setCarLeftFileName(uploads.getCarLeftFileName());
			customCustUploads.setCarRightFileName(uploads.getCarRightFileName());
			customCustUploads.setEngineChassisNoFileName(uploads.getEngChassisNoFileName());
			customCustUploads.setLeaseFileName(uploads.getLeaseFileName());

			return (customCustUploads);
		} catch (Exception e) {
			_log.error(e.getMessage());
			return new QuotationCustUploads();
		}
	}

	private List<QuotationHistory> getCustomQuotationHistory(List<QuotationStatusHistory> quotationStatusHistoryList)
			throws PortalException {
		List<QuotationHistory> customQuotationHistory = new ArrayList<QuotationHistory>();
		for (QuotationStatusHistory quotHis : quotationStatusHistoryList) {
			QuotationHistory customQuoHistory = new QuotationHistory();
			customQuoHistory.setHistoryId(quotHis.getHistoryId());
			customQuoHistory.setQuotationId(quotHis.getQuotationId());
			customQuoHistory.setUserName(quotHis.getUserName());
			customQuoHistory.setDateTime(quotHis.getDateTime());
			customQuoHistory.setStatus(quotHis.getStatus());
			customQuoHistory.setReason(quotHis.getReason());
			customQuotationHistory.add(customQuoHistory);
		}
		return (customQuotationHistory);
	}

	private List<QuotationCover> getCustomQuotationCovers(List<QuotationCovers> quotationCoversList, long productCode)
			throws PortalException {
		List<QuotationCover> customQuotationCover = new ArrayList<QuotationCover>();
		for (QuotationCovers quotCover : quotationCoversList) {
			QuotationCover customQuoCover = new QuotationCover();
			customQuoCover.setCoverCode(quotCover.getCoverCode());
			customQuoCover.setCoverPrem(quotCover.getCoverPrem());
			customQuoCover.setCoverSi(quotCover.getCoverSi());
			customQuoCover.setAddCoverId(quotCover.getAddCoverId());
			// customQuoCover.setCoverDesc(quotCover.get);
			customQuoCover.setCoverEffFromDate(quotCover.getCoverEffFromDate());
			customQuoCover.setCoverEffToDate(quotCover.getCoverEffToDate());
			customQuoCover.setCoverName(quotCover.getCoverNameEn(productCode));
			customQuoCover.setCoverNameAr(quotCover.getCoverNameAr(productCode));
			customQuoCover.setCoverDesc(quotCover.getCoverDescEn(productCode));
			customQuoCover.setCoverDescAr(quotCover.getCoverDescAr(productCode));
			customQuoCover.setCoverRate(quotCover.getCoverRate());
			customQuoCover.setSectionCode(quotCover.getSectionCode());
			// customQuoCover.setField1(quotCover.get);
			customQuoCover.setQuotationId(quotCover.getQuotationId());
			customQuotationCover.add(customQuoCover);
		}
		return (customQuotationCover);
	}

	private List<QuotationCover> getCustomAdminQuotationCovers(List<QuotationCovers> quotationCoversList,
			long productCode, String policyNo, String vehId) throws PortalException {
		List<QuotationCover> customQuotationCover = new ArrayList<QuotationCover>();
		for (QuotationCovers quotCover : quotationCoversList) {
			QuotationCover customQuoCover = new QuotationCover();
			customQuoCover.setCoverCode(quotCover.getCoverCode());
			customQuoCover.setCoverPrem(quotCover.getCoverPrem());
			customQuoCover.setCoverSi(quotCover.getCoverSi());
			customQuoCover.setAddCoverId(quotCover.getAddCoverId());
			// customQuoCover.setCoverDesc(quotCover.get);
			customQuoCover.setCoverEffFromDate(quotCover.getCoverEffFromDate());
			customQuoCover.setCoverEffToDate(quotCover.getCoverEffToDate());
			customQuoCover.setCoverName(quotCover.getCoverNameEn(productCode));
			customQuoCover.setCoverNameAr(quotCover.getCoverNameAr(productCode));
			customQuoCover.setCoverDesc(quotCover.getCoverDescEn(productCode));
			customQuoCover.setCoverDescAr(quotCover.getCoverDescAr(productCode));
			customQuoCover.setCoverRate(quotCover.getCoverRate());
			customQuoCover.setSectionCode(quotCover.getSectionCode());
			PolicyVehCvrPK PolicyVehCvrPKObj = new PolicyVehCvrPK();
			PolicyVehCvrPKObj.setDescription(customQuoCover.getCoverDesc());
			PolicyVehCvrPKObj.setPolicyNo(policyNo);
			PolicyVehCvrPKObj.setVehId(vehId);
			try {
				customQuoCover.setBenfTerm(
						PolicyVehCvrLocalServiceUtil.fetchPolicyVehCvr(PolicyVehCvrPKObj).getBenefitTerm());

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			// customQuoCover.setField1(quotCover.get);
			customQuoCover.setQuotationId(quotCover.getQuotationId());
			customQuotationCover.add(customQuoCover);
		}
		return (customQuotationCover);
	}

	private QuotationDriver getCustomQuotationDriver(QuotationDrivers driver) throws PortalException {
		QuotationDriver customDriver = new QuotationDriver();
		customDriver.setAddDriverId(driver.getAddDriverId());
		customDriver.setDriverDob(driver.getDriverDob());

		_log.info("getCustomQuotationDriver. Hijri Date:" + driver.getDriverDobH());
		customDriver.setDriverDobH(driver.getDriverDobH());
		customDriver.setDriverGender(driver.getDriverGender());
		customDriver.setDriverId(driver.getDriverId());
		customDriver.setDriverIdType(driver.getDriverIdType());
		customDriver.setDriverName(driver.getDriverName());
		customDriver.setDriverNationality(driver.getDriverNationality());
		customDriver.setQuotationId(driver.getQuotationId());

		return customDriver;
	}

	public QuotationTameeniExtraDetails getQuotationTameeniExtras(long quotationId) throws PortalException {
		QuotationTameeniExtraDetails details = new QuotationTameeniExtraDetails();

		try {
			QuotationExtraTameeniInfo extraInfo = QuotationExtraTameeniInfoUtil.findByQuotationId(quotationId);

			details.setQuotationId(extraInfo.getQuotationId());

			details.setInsuredFirstName(extraInfo.getInsuredFirstName());
			details.setInsuredMiddleName(extraInfo.getInsuredMiddleName());
			details.setInsuredLastName(extraInfo.getInsuredLastName());
			details.setDriverDisabled(extraInfo.isIsDriverDisabled());
			details.setVehicleMakeCodeTameeni(extraInfo.getVehicleMakeCodeTameeni());
			details.setCoverAgeLimit(extraInfo.getCoverAgeLimit());
			details.setInsuredNameLang(extraInfo.getInsuredNameLang());
			details.setPolicyTitleID(Integer.parseInt(extraInfo.getPolicyTitleId()));
			details.setRenewal(extraInfo.isIsRenewal());

		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e.getMessage());
		}

		return details;
	}

	public void updateQuotationTameeniExtras(QuotationTameeniExtraDetails details) {
		try {
			QuotationExtraTameeniInfo extraInfo = QuotationExtraTameeniInfoUtil.create(details.getQuotationId());
			extraInfo.setInsuredFirstName(details.getInsuredFirstName());
			extraInfo.setInsuredMiddleName(details.getInsuredMiddleName());
			extraInfo.setInsuredLastName(details.getInsuredLastName());
			extraInfo.setIsDriverDisabled(details.isDriverDisabled());
			extraInfo.setVehicleMakeCodeTameeni(details.getVehicleMakeCodeTameeni());
			extraInfo.setCoverAgeLimit(details.getCoverAgeLimit());
			extraInfo.setInsuredNameLang(details.getInsuredNameLang());
			extraInfo.setPolicyTitleId(String.valueOf(details.getPolicyTitleID()));
			extraInfo.setIsRenewal(details.isRenewal());

			QuotationExtraTameeniInfoLocalServiceUtil.updateQuotationExtraTameeniInfo(extraInfo);
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e.getMessage());
		}
	}

	public void saveNajmCaseDetails(ArrayList<QuotationNajmDetails> najmDetailsList, long quotationId) {
		try {
			for (QuotationNajmDetails qnd : najmDetailsList) {
				QuotationsNajmDetailsPK quotationsNajmDetailsPK = new QuotationsNajmDetailsPK(qnd.getCaseNumber(),
						quotationId);
				QuotationsNajmDetails najmDetails = QuotationsNajmDetailsLocalServiceUtil
						.createQuotationsNajmDetails(quotationsNajmDetailsPK);

				najmDetails.setAccidentDate(qnd.getAccidentDate());
				najmDetails.setCarModel(qnd.getCarModel());
				najmDetails.setCarType(qnd.getCarType());
				najmDetails.setCauseOfAccident(qnd.getCauseOfAccident());
				najmDetails.setDriverAge(qnd.getDriverAge());
				najmDetails.setDriverID(qnd.getDriverID());
				najmDetails.setDamageParts(qnd.getDamageParts());
				najmDetails.setEstimatedAmount(qnd.getEstimatedAmount());
				najmDetails.setLiability(qnd.getLiability());
				najmDetails.setOwnerID(qnd.getOwnerID());
				najmDetails.setSequenceNumber(qnd.getSequenceNumber());

				QuotationsNajmDetailsLocalServiceUtil.updateQuotationsNajmDetails(najmDetails);
			}
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e.getMessage());
		}
	}

	public List<QuotationDriver> getUnderAgeDriversList(long quotationId) {
		try {
			List<QuotationDriver> underAgeDrivers = new ArrayList<QuotationDriver>();
			List<QuotationDrivers> driversList = QuotationDriversLocalServiceUtil
					.findUnderAgeDriversByQuotationId(quotationId);

			for (QuotationDrivers d : driversList) {
				QuotationDriver ud = new QuotationDriver();
				ud.setAddDriverId(d.getAddDriverId());
				ud.setDriverId(d.getDriverId());
				ud.setDriverIdType(d.getDriverIdType());
				ud.setDriverName(d.getDriverName());
				ud.setDriverGender(d.getDriverGender());
				ud.setDriverDob(d.getDriverDob());
				ud.setQuotationId(d.getQuotationId());
				ud.setDriverUnder21(d.isIsDriverUnder21());

				underAgeDrivers.add(ud);
			}
			return underAgeDrivers;
		} catch (Exception e) {
			_log.info("Failed to retrieve Under age drivers list for quotation Id:" + quotationId);
			e.printStackTrace();
			_log.error(e.getMessage());
			return null;
		}
	}

	public void saveAdminFiles(long quotationId, File adminFile, String fileName) {

		ByteArrayFileInputStream inputStream = null;
		inputStream = new ByteArrayFileInputStream(adminFile, 1024);
		byte[] idData;
		try {
			QuotationAdminUploads quotationAdminUploads = QuotationAdminUploadsUtil
					.create((int) CounterLocalServiceUtil.increment());
			quotationAdminUploads.setQuotationId(quotationId);
			quotationAdminUploads.setFileName(fileName);
			idData = FileUtil.getBytes(inputStream);
			quotationAdminUploads.setAdminFile(new javax.sql.rowset.serial.SerialBlob(idData));
			QuotationAdminUploadsUtil.update(quotationAdminUploads);
		} catch (IOException e) {
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

	public void removeAdminFiles(int fileId) {
		try {
			QuotationAdminUploadsUtil.remove(fileId);
		} catch (NoSuchQuotationAdminUploadsException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public QuotationAdminUploads downloadAdminFiles(int fileId) {

		QuotationAdminUploads file;
		try {
			file = QuotationAdminUploadsUtil.findByPrimaryKey(fileId);
			System.out.println(file.getId());
			return file;
		} catch (NoSuchQuotationAdminUploadsException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	public CustUploads downloadCustFiles(long fileId) {
		CustUploads file;
		try {
			file = CustUploadsUtil.findByPrimaryKey(fileId);
			return file;
		} catch (NoSuchCustUploadsException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	private List<Quotation> getAdminCustomQuotationsList(List<Quotation> customQuotation) throws PortalException {
		List<Quotation> customQuotations = new ArrayList<Quotation>();
		for (Quotation quot : customQuotation) {
			List<QuotationHistory> quotationHistory = getCustomQuotationHistory(
					QuotationStatusHistoryUtil.findByQuotationId(quot.getQuotationId()));
			quot.setQuotationHistory(quotationHistory);
			quot.setVehicleIdDescEn(getVehicleIdDescEn(quot.getVehicleIdType() + ""));
			quot.setVehicleIdDescAr(getVehicleIdDescAr(quot.getVehicleIdType() + ""));

			customQuotations.add(quot);
		}
		return customQuotations;
	}

	private Quotation getAdminCustomQuotations(Quotation customQuotation) throws PortalException {

		List<QuotationAdminUpload> quotationAdminUploads = getCustomQuotationAdminUploads(
				QuotationAdminUploadsUtil.findByQuotationId(customQuotation.getQuotationId()));
		customQuotation.setAdminFilesUplods(quotationAdminUploads);
		// try {
		// System.out.println("customer"+);
		//// QuotationCustUploads quotationCustUploads=
		// getCustomQuotationCustUploads(CustUploadsLocalServiceUtil.findByQuotationId(quot.getQuotationId()+""));
		//// quot.setCustFilesUplods(quotationCustUploads);
		// }
		// catch (Exception e) {
		// // TODO: handle exception
		// e.printStackTrace();
		// }

		List<QuotationHistory> quotationHistory = getCustomQuotationHistory(
				QuotationStatusHistoryUtil.findByQuotationId(customQuotation.getQuotationId()));
		customQuotation.setQuotationHistory(quotationHistory);
		List<QuotationCover> quotationCover = getCustomAdminQuotationCovers(
				QuotationCoversUtil.findByQuotationId(customQuotation.getQuotationId()),
				(customQuotation.getProductCode().equals(PRODUCT_CODE_COMPREHENSIVE)) ? PRODUCT_CODE_COMPREHENSIVE_VAL
						: PRODUCT_CODE_TPL_VAL,
				customQuotation.getPolicyNo(), String.valueOf(customQuotation.getVehicleId()));
		customQuotation.setCoversList(quotationCover);
		customQuotation.setVehicleIdDescEn(getVehicleIdDescEn(customQuotation.getVehicleIdType() + ""));
		customQuotation.setVehicleIdDescAr(getVehicleIdDescAr(customQuotation.getVehicleIdType() + ""));

		return customQuotation;

	}

	public List<Quotation> getAdminQuotations(int start, int end) throws PortalException {
		List<Quotations> quotationsList = QuotationsUtil.findAll(start, end);
		List<Quotation> customQuotationList = getCustomQuotations(quotationsList);
		List<Quotation> adminCustomQuotationsList = getAdminCustomQuotationsList(customQuotationList);
		return adminCustomQuotationsList;
	}

	public int getAdminQuotationsCount() throws PortalException {
		int quotationsCount = QuotationsUtil.countAll();
		return quotationsCount;
	}

	public List<Quotation> getQuotationsByIqamaIdAndStatus(long iqamaId) throws PortalException {
		String[] status = { "PP", "PS", "EX", "RJ" };

		List<Quotations> quotationsList = QuotationsLocalServiceUtil.findByIqamaIdAndStatus(iqamaId, status);

		List<Quotation> customQuotationList = getCustomQuotations(quotationsList);

		return customQuotationList;
	}

	public Quotation getAdminQuotationByQuotationId(long quotationId) throws PortalException {
		List<Quotations> quotationsList = (List<Quotations>) QuotationsLocalServiceUtil.findByQuotationId(quotationId);
		List<Quotation> customQuotationList = getCustomQuotations(quotationsList);
		Quotation adminCustomQuotationsList = getAdminCustomQuotations(customQuotationList.get(0));
		return adminCustomQuotationsList;
	}

	public void rejectQuotation(long quotationId, String userName, Date date, String reason, String status) {
		QuotationStatusHistory quotationStatusHistory = QuotationStatusHistoryUtil
				.create((long) CounterLocalServiceUtil.increment());
		quotationStatusHistory.setQuotationId(quotationId);
		quotationStatusHistory.setUserName(userName);
		quotationStatusHistory.setDateTime(date);
		quotationStatusHistory.setReason(reason);
		quotationStatusHistory.setStatus(status == null ? "RJ" : status);
		QuotationStatusHistoryUtil.update(quotationStatusHistory);
		try {
			Quotations quot = (Quotations) QuotationsLocalServiceUtil.findByQuotationId(quotationId).get(0);
			quot.setQuoteStatus(status == null ? "RJ" : status);
			QuotationsLocalServiceUtil.updateQuotations(quot);
		} catch (NoSuchQuotationsException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}

	}

	public String acceptQuotation(long quotationId, String userName, Date date, String reason) {
		QuotationStatusHistory quotationStatusHistory = QuotationStatusHistoryUtil
				.create((long) CounterLocalServiceUtil.increment());
		quotationStatusHistory.setQuotationId(quotationId);
		quotationStatusHistory.setUserName(userName);
		quotationStatusHistory.setDateTime(date);
		quotationStatusHistory.setReason(reason);
		quotationStatusHistory.setStatus("PP");
		QuotationStatusHistoryUtil.update(quotationStatusHistory);
		try {
			Quotations quot = (Quotations) QuotationsLocalServiceUtil.findByQuotationId(quotationId).get(0);
			quot.setQuoteStatus("PP");
			QuotationsLocalServiceUtil.updateQuotations(quot);
			return "succ";
		} catch (NoSuchQuotationsException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
			return "F";
		}

	}

	public Quotation getTariffDets(Quotation quot, boolean isRenewal) throws PortalException {
		CarInfo savedCarInfo = null;
		int cardetail = 0;
		AtmcYakeenMakeModel makemodel = null;
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			spf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

			YakeenDataSave citizenCarInfoLocalData = YakeenDataSaveLocalServiceUtil
					.findByVehicleSequence(String.valueOf(quot.getVehicleId()));
			Source xmlSource = new SAXSource(spf.newSAXParser().getXMLReader(),
					new InputSource(new StringReader(citizenCarInfoLocalData.getServiceOutput())));
			JAXBContext jc = JAXBContext.newInstance(BasicCarInfo.class, CarInfo.class);
			Unmarshaller um = jc.createUnmarshaller();
			savedCarInfo = (CarInfo) um.unmarshal(xmlSource);

//			 YakeenDataSave  citizenCarInfoLocalData = YakeenDataSaveLocalServiceUtil.findByVehicleSequence(String.valueOf(quot.getVehicleId()));
//			 JAXBContext jaxbContext = JAXBContext.newInstance(BasicCarInfo.class,CarInfo.class);
//				Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();
//				StringReader st = new StringReader(citizenCarInfoLocalData.getServiceOutput());
//				 savedCarInfo = (CarInfo) jaxbMarshaller.unmarshal(st);
			_log.info("savedCarInfo >>>>>>>>>>>>" + savedCarInfo.toString());
		} catch (NoSuchYakeenDataSaveException | JAXBException | ParserConfigurationException | SAXException e) {
			_log.info("inside catch block make" + quot.getVehicleMake());
			_log.info("inside catch block make" + quot.getVehicleModel());
			makemodel = AtmcYakeenMakeModelLocalServiceUtil.findByEskaMakeModelDetails(quot.getVehicleMake(),
					quot.getVehicleModel());
			_log.info("yakeen make " + makemodel.getYakeenMakeValue());
			_log.info("yakeen model" + makemodel.getYakeenModelValue());
			cardetail = Integer.valueOf(makemodel.getYakeenMakeValue());
		}

		CompDiscount compDiscount = CompDiscountLocalServiceUtil.fetchCompDiscount(String.valueOf(quot.getInsuredId()));
		_log.info("getTariffDets fn Start");
		_log.info("city description >>>>>>>>>>>>>" + quot.getCityDesc());
		TariffInput tInput = new TariffInput();
		Calendar currTime = new GregorianCalendar();
		currTime.setTime(new Date());
		if (quot.getInsuredDob() != null) {
			java.sql.Date sqlDate = new java.sql.Date(quot.getInsuredDob().getTime());
			tInput.setDriverAge(sqlDate);
		}
		tInput.setBodyType(quot.getVehicleBodyType());
		tInput.setClmFreeYears((int) quot.getNcdYears());
		tInput.setColor((quot.getVehicleColor() != null && !quot.getVehicleColor().equals(""))
				? Integer.valueOf(quot.getVehicleColor())
				: 0);
		tInput.setEffFromDate(
				(quot.getPolicyEffDate() != null) ? new java.sql.Date(quot.getPolicyEffDate().getTime()) : null);
		// tInput.setMake(savedCarInfo.getVehicleMakerCode());
		if (savedCarInfo != null)
//			tInput.setMake(savedCarInfo.getVehicleMakerCode());
			tInput.setMake(Integer.parseInt(quot.getVehicleMake()));
		else
			tInput.setMake(cardetail);
		tInput.setVehicleModel(Integer.parseInt(quot.getVehicleModel()));
		tInput.setMFGYear((int) quot.getVehicleMfgYear());
		tInput.setProductCode(quot.getProductCode());
		tInput.setInsuredid(quot.getInsuredId());
		tInput.setChassisno(quot.getVehicleChassisNo());
		// tInput.setMaritalStatus(Integer.valueOf(quot.getInsuredMaritalStatus()));
		CodeMasterMap maritalstatus = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode("MARITAL_STATUS",
				quot.getInsuredMaritalStatus());
		tInput.setMaritalStatus(Integer.valueOf(maritalstatus.getCoreCode()));
		if (quot.getVehiclePlateType() != null)
			tInput.setPurposeVeh(Integer.valueOf(quot.getVehiclePlateType()));
		if (quot.getCityDesc() != null)
			tInput.setRegion(quot.getCityDesc());
		else
			tInput.setRegion("0");
		tInput.setUniqueIdentifier("12345678");
		tInput.setRepair((quot.getAgencyRepair() != null && !quot.getAgencyRepair().equals(""))
				? Integer.valueOf(quot.getAgencyRepair())
				: 0);
		tInput.setVehicleValue((int) quot.getVehicleValue());
		// Kareem Kahil: Mapping Insured Gender as per SAMA CR design document
		String insuredGender = quot.getInsuredGender();
		_log.info("Insured Gender: " + insuredGender);
		if (insuredGender != null && !insuredGender.equals("")) {
			if (insuredGender.equalsIgnoreCase(YAKEEN_INSURED_GENDER_MALE))
				tInput.setGender(INSURED_GENDER_MALE);
			else if (insuredGender.equalsIgnoreCase(YAKEEN_INSURED_GENDER_FEMALE))
				tInput.setGender(INSURED_GENDER_FEMALE);
			else {
				// Gender value doesn't need manipulation. (Such as renewal case)
				_log.info("Gender doesn't need transformation");

				try {
					tInput.setGender(Integer.parseInt(insuredGender));
				} catch (Exception e) {
					_log.info("Gender value is not allowed");
					e.printStackTrace();
				}
			}
		} else {
			_log.info("Error Insured Gender Scenario. Setting Gender as Zero to throw exception");
			tInput.setGender(0);
		}
		if (compDiscount != null) {

			_log.info("during renewal  Alinma");
			tInput.setSchemeCode("SCHEME_011");
			tInput.setSpecialDiscount(compDiscount.getSchemeCode());
			tInput.setLoyalty((quot.isRenew() ? 1 : 2));
			_log.info("loyalty flag :::::" + tInput.getLoyalty());
		} else {
			_log.info("during renewal  Normal");
			tInput.setSchemeCode("SCHEME_011");
			tInput.setSpecialDiscount(null);
			_log.info("during renewal  loyalty flag" + quot.getLoyaltyDiscountFlag());
			_log.info("checking renew or not >>>>>>>>>>>>" + quot.isRenew());
			// tInput.setLoyalty(quot.getLoyaltyDiscountFlag());
			tInput.setLoyalty((quot.isRenew() ? 1 : 0));
		}
		List<QuotationDriver> drvList = quot.getQuotationDrivers();

		if (drvList != null && !drvList.isEmpty()) {
			if (drvList.size() == 1) {
				_log.info("ncd years before my code " + quot.getNcdYears());
				tInput.setNcdDrv1(((QuotationDriver) drvList.get(0)).getNcdYears());
				tInput.setNcdDrv2(TARIF_NO_ADDITIONAL_DRIVER);
				tInput.setNcdDrv3(TARIF_NO_ADDITIONAL_DRIVER);
				tInput.setNcdDrv4(TARIF_NO_ADDITIONAL_DRIVER);
				tInput.setNcdDrv5(TARIF_NO_ADDITIONAL_DRIVER);
			} else if (drvList.size() == 2) {
				_log.info("ncd years before my code " + quot.getNcdYears());
				tInput.setNcdDrv1(((QuotationDriver) drvList.get(0)).getNcdYears());
				tInput.setNcdDrv2(((QuotationDriver) drvList.get(1)).getNcdYears());
				tInput.setNcdDrv3(TARIF_NO_ADDITIONAL_DRIVER);
				tInput.setNcdDrv4(TARIF_NO_ADDITIONAL_DRIVER);
				tInput.setNcdDrv5(TARIF_NO_ADDITIONAL_DRIVER);
			} else if (drvList.size() == 3) {
				_log.info("ncd years before my code " + quot.getNcdYears());
				tInput.setNcdDrv1(((QuotationDriver) drvList.get(0)).getNcdYears());
				tInput.setNcdDrv2(((QuotationDriver) drvList.get(1)).getNcdYears());
				tInput.setNcdDrv3(((QuotationDriver) drvList.get(2)).getNcdYears());
				tInput.setNcdDrv4(TARIF_NO_ADDITIONAL_DRIVER);
				tInput.setNcdDrv5(TARIF_NO_ADDITIONAL_DRIVER);
			} else if (drvList.size() == 4) {
				_log.info("ncd years before my code " + quot.getNcdYears());
				tInput.setNcdDrv1(((QuotationDriver) drvList.get(0)).getNcdYears());
				tInput.setNcdDrv2(((QuotationDriver) drvList.get(1)).getNcdYears());
				tInput.setNcdDrv3(((QuotationDriver) drvList.get(2)).getNcdYears());
				tInput.setNcdDrv4(((QuotationDriver) drvList.get(3)).getNcdYears());
				tInput.setNcdDrv5(TARIF_NO_ADDITIONAL_DRIVER);
			} else if (drvList.size() == 5) {
				tInput.setNcdDrv1(((QuotationDriver) drvList.get(0)).getNcdYears());
				tInput.setNcdDrv2(((QuotationDriver) drvList.get(1)).getNcdYears());
				tInput.setNcdDrv3(((QuotationDriver) drvList.get(2)).getNcdYears());
				tInput.setNcdDrv4(((QuotationDriver) drvList.get(3)).getNcdYears());
				tInput.setNcdDrv5(((QuotationDriver) drvList.get(4)).getNcdYears());
			}
		} else {
			tInput.setNcdDrv1(TARIF_NO_ADDITIONAL_DRIVER);
			tInput.setNcdDrv2(TARIF_NO_ADDITIONAL_DRIVER);
			tInput.setNcdDrv3(TARIF_NO_ADDITIONAL_DRIVER);
			tInput.setNcdDrv4(TARIF_NO_ADDITIONAL_DRIVER);
			tInput.setNcdDrv5(TARIF_NO_ADDITIONAL_DRIVER);
		}
		ArrayList<TariffOutput> tOut = null;

		try {
			double ncdPermiumRate = 0;
			double loyaltyDisPremRate = 0;
			double specialDiscountRate = 0;
			double premiumAmount = 0;
			double specialDiscountAmount = 0;
			double ncdDiscountAmount = 0;
			double loyaltyDiscount = 0;
			double ncdPercentage = 0;
			double loyaltyDiscountPercentage = 0;
			double loadingamount = 0;
			double specialDiscountRatesafedrive = 0;
			double specialDiscountAmountsafeDrive = 0;
			tOut = TariffLocalServiceUtil.getTariffData(tInput);
			_log.info("Tariff Input Data : " + tInput);
			_log.info("after tariff call ");
			if (quot.getProductCode().equals(PRODUCT_CODE_TPL)) {
				_log.info("MTP :::::::" + quot.getProductCode());
				for (TariffOutput tout : tOut) {
					if ((tout.getCode() != null) && (tout.getCode().equals("2066"))) {
						_log.info("toutput >>>>>>>>>>>>>" + tout.toString());
						premiumAmount = Double.valueOf(tout.getPremiumAmount());
						_log.info(" PremiumAmount " + tout.getPremiumAmount());
					}
					if ((tout.getCode() != null) && (tout.getCode().equals("106"))) {
						loyaltyDisPremRate = Double.valueOf(tout.getPremiumRate());
						_log.info("loyalty Discount Rate >>>>>>>>>>" + loyaltyDisPremRate * 100);
						loyaltyDiscount = (premiumAmount * loyaltyDisPremRate);
						_log.info("loyalty discount amount " + loyaltyDiscount);
					}
					if ((tout.getCode() != null) && (tout.getCode().equals("85"))) {
						ncdPermiumRate = Double.valueOf(tout.getPremiumRate());
						ncdPercentage = ncdPermiumRate * 100;
						_log.info("ncdPercentage >>>>>>>" + ncdPercentage);
						if (quot.getNcdYears() != 0) {
							ncdDiscountAmount = (premiumAmount * ncdPermiumRate);
							_log.info("ncdDiscountAmount>>>>>>>>>>>>>" + ncdDiscountAmount);
						} else {
							loadingamount = premiumAmount * ncdPermiumRate;
							_log.info("loadingamount >>>>>>>>>" + loadingamount);
						}
					}
					if ((tout.getCode() != null) && (tout.getCode().equals("107") || tout.getCode().equals("147")
							|| tout.getCode().equals("148"))) {
						specialDiscountRate = Double.valueOf(tout.getPremiumRate());
						_log.info("staff discount percentage " + specialDiscountRate);
						specialDiscountAmount = (premiumAmount * specialDiscountRate);
						_log.info("specialDiscountAmount >>>>>>" + specialDiscountAmount);
					}
					if ((tout.getCode() != null) && (tout.getCode().equals("289"))) {
						specialDiscountRatesafedrive = Double.valueOf(tout.getPremiumRate());
						specialDiscountAmountsafeDrive = (premiumAmount * specialDiscountRatesafedrive);
						_log.info("specialDiscountAmount >>>>>>>>>>>>" + specialDiscountAmountsafeDrive);
					}

				}
			} else {
				_log.info("MCC :::::::" + quot.getProductCode());
				for (TariffOutput tout : tOut) {
					// _log.info("Tariff Output"+tout.toString());
					if (tout.getCode().equals("2062") && tout.getExcessAmount().equals(quot.getDeductibleValue())) {
						premiumAmount = (Double.valueOf(tout.getPremiumAmount()));
						_log.info("premiumAmount >>>>>>>>>>" + tout.getPremiumAmount());
						/*
						 * if(premiumAmount < Double.valueOf(tout.getMinimumPremium())) {
						 * quot.setNetPrem(Double.valueOf(tout.getMinimumPremium())); premiumAmount =
						 * Double.valueOf(tout.getMinimumPremium());
						 * _log.info("minimum premium Amount >>>>>>>>>>>>>>>>"+premiumAmount); } else {
						 * quot.setNetPrem(Double.valueOf(premiumAmount));
						 * _log.info("PremiumAmount >>>>>>>>>>"+premiumAmount); }
						 */
						quot.setNetPrem(Double.valueOf(premiumAmount));

					}
					if ((tout.getCode() != null) && (tout.getCode().equals("85"))) {
						ncdPermiumRate = Double.valueOf(tout.getPremiumRate());

						ncdPercentage = ncdPermiumRate * 100;
						_log.info("ncdPercentage >>>>>>>" + ncdPercentage);
						if (quot.getNcdYears() != 0) {
							ncdDiscountAmount = (premiumAmount * ncdPermiumRate);
							_log.info("ncdDiscountAmount>>>>>>>>>>>>>" + ncdDiscountAmount);
						} else {
							loadingamount = premiumAmount * ncdPermiumRate;
							_log.info("loadingamount >>>>>>>>>" + loadingamount);
						}
					}
					if ((tout.getCode() != null) && (tout.getCode().equals("106"))) {
						loyaltyDisPremRate = Double.valueOf(tout.getPremiumRate());
						_log.info("loyalty Discount Rate >>>>>>>>>>" + loyaltyDisPremRate * 100);
						loyaltyDiscount = (premiumAmount * loyaltyDisPremRate);
						_log.info("loyalty discount amount " + loyaltyDiscount);
					}
					if ((tout.getCode() != null) && (tout.getCode().equals("107") || tout.getCode().equals("147")
							|| tout.getCode().equals("148"))) {
						specialDiscountRate = Double.valueOf(tout.getPremiumRate());
						_log.info("staff discount percentage " + specialDiscountRate);
						specialDiscountAmount = (premiumAmount * specialDiscountRate);
						_log.info("specialDiscountAmount >>>>>>" + specialDiscountAmount);
					}
					if ((tout.getCode() != null) && (tout.getCode().equals("289"))) {
						specialDiscountRatesafedrive = Double.valueOf(tout.getPremiumRate());
						// specialDiscountRate = specialDiscountRate*100;
						_log.info("specialDiscountRatesafedrive >>>>>>>>>>" + specialDiscountRatesafedrive);
						specialDiscountAmountsafeDrive = (premiumAmount * specialDiscountRatesafedrive);
						_log.info("specialDiscountAmount >>>>>>>>>>>>" + specialDiscountAmountsafeDrive);
					}
				}
			}

			double totalDiscAmount = loyaltyDiscount + ncdDiscountAmount + specialDiscountAmount
					+ specialDiscountAmountsafeDrive;
			double totalPremPayable = premiumAmount + Math.abs(loadingamount) - totalDiscAmount;
			_log.info("totalDiscAmount >>>" + totalDiscAmount);
			_log.info("totalPremPayable without tax >>>" + totalPremPayable);
			// double vatAmount = totalPremPayable * 0.05;
			double vatAmount = totalPremPayable * 0.15;
			_log.info("vat amount " + vatAmount);
			double payableAmount = totalPremPayable + vatAmount;
			_log.info("total premium payable with tax" + payableAmount);
			loyaltyDiscountPercentage = ncdPermiumRate + loyaltyDisPremRate + (specialDiscountRate * 100)
					+ (specialDiscountRatesafedrive * 100);
			_log.info("total loyalty and ncd percentage todays " + loyaltyDiscountPercentage);
			loyaltyDiscount = loyaltyDiscount + specialDiscountAmount + specialDiscountAmountsafeDrive;
			quot.setDiscountAmount(ncdDiscountAmount);
			// quot.setPolicyTaxes(0.05);
			quot.setPolicyTaxes(0.15);
			quot.setNetPrem(premiumAmount);
			if (quot.getNcdYears() != 0)
				// quot.setDiscountPrem(ncdPercentage+(specialDiscountRate*100)+(loyaltyDisPremRate*100)+(specialDiscountRatesafedrive*100));
				quot.setDiscountPrem(ncdPercentage);
			else
				quot.setDiscountPrem(0.0);
			quot.setLoyaltyDiscountPer(
					loyaltyDisPremRate + (specialDiscountRate * 100) + (specialDiscountRatesafedrive * 100));
			quot.setGrossPrem(payableAmount);
			quot.setLoyaltyDiscount("" + loyaltyDiscount);
			quot.setNetPrem(premiumAmount);
			quot.setSaeedService(String.valueOf(decimalFormat.format(specialDiscountAmountsafeDrive)));
			_log.info("total loyalty discount>>>>>>>>>>>>>>" + quot.getLoyaltyDiscount());
			quot.setLoadingAmount(Math.abs(loadingamount));

			/*
			 * if(loyaltyDisPremRate != 0 ) { loyaltyDiscount = loyaltyDisPremRate *
			 * premiumAmount ; loyaltyDiscountPercentage = loyaltyDisPremRate * 100 ;
			 * _log.info("Loyalty discount amount "+loyaltyDiscount);
			 * _log.info("Loyalty discount Percentage "+loyaltyDiscountPercentage); } {
			 * loyaltyDiscount = 0; } if(ncdPermiumRate != 0 ) { ncdDiscountAmount =
			 * ncdPermiumRate * premiumAmount ; ncdPercentage = ncdPermiumRate * 100 ;
			 * _log.info("NCD discount amount "+ncdDiscountAmount);
			 * _log.info("NCD discount Percentage "+ncdPercentage); } else {
			 * ncdDiscountAmount = 0; } if(specialDiscountRate != 0 ) {
			 * specialDiscountAmount = specialDiscountRate * premiumAmount ; double
			 * spclDiscPercentage = specialDiscountRate * 100 ;
			 * _log.info("Special discount amount "+specialDiscountAmount);
			 * _log.info("NCD discount Percentage "+spclDiscPercentage); } else {
			 * specialDiscountAmount = 0; }
			 */

			// quot.setPolicyFees(payableAmount);

			// quot.setPolicyFees(vatAmount);

			/*
			 * quot.setPolicyFees(tOut.getPolicyFees());
			 * quot.setAgencyRepairOut(tOut.getAgencyRepair());
			 * quot.setDriverAgeLess21(tOut.getDriverAgeLess21());
			 * //quot.setTotalCoverPrem(tOut.getNetPrem());
			 * quot.setDiscountAmount(tOut.getNcdDiscount());
			 * quot.setGrossPrem(tOut.getBasePremium());
			 */
			// quot.setLoyaltyDiscount(loyaltyDiscount);
			/*
			 * quot.setNetPrem(tOut.getBasePremium()); quot.setLoyaltyDiscount("" +
			 * tOut.getLoyalityDiscount()); quot.setDiscountPrem(tOut.getNcdPercentage());
			 * quot.setLoyaltyDiscountPer(tOut.getLoyalityPercentage());
			 * quot.setLoadingAmount(tOut.getMotorLoading());
			 * quot.setPolicyTaxes(tOut.getVatFees());
			 * quot.setPolicyFees(tOut.getPolicyFees());
			 * quot.setAgencyRepairOut(tOut.getAgencyRepair());
			 * quot.setDriverAgeLess21(tOut.getDriverAgeLess21());
			 * //quot.setTotalCoverPrem(tOut.getNetPrem());
			 * quot.setDiscountAmount(tOut.getNcdDiscount());
			 * quot.setGrossPrem(tOut.getBasePremium());
			 */

			/*
			 * if(compDiscount != null ) { _log.info("inside discount condition");
			 * quot.setSaeedService(compDiscount.getSchemeCode()); } else {
			 * _log.info("inside non discount condition");
			 * quot.setSaeedService("SCHEME_001");
			 * 
			 * }
			 */

			// quot.setSaeedService(compDiscount != null ? compDiscount.getSchemeCode() :
			// "SCHEME_001");

			/*
			 * _log.info("saeed service added "+quot.getSaeedService());
			 * _log.info(""+tOut.getBasePremium());
			 * _log.info("LoyalityDiscount  "+tOut.getLoyalityDiscount());
			 * _log.info("NcdPercentage  "+tOut.getNcdPercentage());
			 * _log.info("getLoyalityPercentage"+tOut.getLoyalityPercentage());
			 * _log.info("getMotorLoading"+tOut.getMotorLoading());
			 * _log.info("getLoyalityDiscount "+tOut.getLoyalityDiscount());
			 * 
			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(e.getMessage());
			return null;
		}
		_log.info("getTariffDets fn End");
		return quot;
	}

	public PurchaseResponse payFortPurchase(double amount, String currency, String customerEmail, String language,
			String merchantReference, String tokenName, String paymentOption, String cardSecurityCode,
			String clientIpAddress, String returnUrl) {
		_log.info("payFortPurchase start. customerEmail:" + customerEmail);
		PurchaseResponse response = null;
		String requestPhrase = PropsUtil.get("com.ejada.atmc.payfort.sha.requestPhrase");
		String merchantIdentifier = PropsUtil.get("com.ejada.atmc.payfort.merchantIdentifier");
		String accessCode = PropsUtil.get("com.ejada.atmc.payfort.accessCode");

		try {
			amount *= 100;
			long amountVal = (new Double(amount)).longValue();

			language = (language.equals("en_US") ? "en" : "ar");

			_log.info("clientIpAddress before change check:" + clientIpAddress);

			if (clientIpAddress.indexOf(":") > -1) {
				_log.info("clientIpAddress needs change");
				clientIpAddress = clientIpAddress.substring(0, clientIpAddress.indexOf(":"));
				_log.info("Customer IP after change:" + clientIpAddress);
			}

			// Propably the user is using a proxy, we need the original client address
			if (clientIpAddress.indexOf(",") > -1) {
				_log.info("clientIpAddress needs change");
				clientIpAddress = clientIpAddress.substring(0, clientIpAddress.indexOf(","));
				_log.info("Customer IP after change:" + clientIpAddress);

			}

			PurchaseRequest req = new PurchaseRequest();
			req.setAccess_code(accessCode);
			req.setAmount("" + amountVal);
			req.setCustomer_ip(clientIpAddress);
			req.setCommand("PURCHASE");
			req.setCurrency(currency);
			req.setCustomer_email(customerEmail);
			req.setLanguage(language);
			req.setMerchant_identifier(merchantIdentifier);
			req.setMerchant_reference(merchantReference);
			req.setPayment_option(paymentOption);
			req.setToken_name(tokenName);
			req.setReturn_url(returnUrl);
			// req.setCard_security_code(cardSecurityCode);

			String signature = requestPhrase + "access_code=" + accessCode + "amount=" + amountVal
					+ "command=PURCHASEcurrency=" + currency + "customer_email=" + customerEmail + "customer_ip="
					+ clientIpAddress + "language=" + language + "merchant_identifier=" + merchantIdentifier
					+ "merchant_reference=" + merchantReference + "payment_option=" + paymentOption + "return_url="
					+ returnUrl + "token_name=" + tokenName + requestPhrase;
			MessageDigest sha25 = MessageDigest.getInstance("SHA-256");

			sha25.update(signature.getBytes("UTF-8"));

			signature = new String(Hex.encodeHex(sha25.digest()));

			req.setSignature(signature);
			_log.info(" ---------------- PAYFORT PURCHASE REQUEST ----------------");
			_log.info(req.log());
			_log.info(" ---------------- END PAYFORT PURCHASE REQUEST ----------------");
			response = PayFortLocalServiceUtil.doPurchase(req);
			_log.info(" ---------------- PAYFORT PURCHASE RESPONSE ----------------");
			_log.info(response.log());
			_log.info(" ---------------- END PAYFORT PURCHASE RESPONSE ----------------");
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	public String olpInitiatePmnt(String olpAlias, double amount, String currency, String merchantLandingURL,
			String merchantFailureURL) {
		InitiateOLPPayment initPmnt = OLPPaymentLocalServiceUtil.initiatePayment(olpAlias, amount, currency,
				merchantLandingURL, merchantFailureURL);
		return initPmnt.getIbURL();
	}

	@Transactional(readOnly = false, rollbackFor = { PortalException.class, SystemException.class,
			ModelListenerException.class }, propagation = Propagation.REQUIRED)
	public void issuePolicy(Quotation quot) {
		_log.info("issuePolicy - start");
		Quotation quotation = null;
		_log.info("issuePolicy - start");
		try {
			quotation = getQuotationByQuotationId(quot.getQuotationId());
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ODSInsured insured = new ODSInsured();
		insured.setAddressaddnumber((int) quot.getAddressAddNo());
		insured.setAddressbldgno((int) quot.getAddressBuildingNo());
		insured.setAddresscity(quot.getCity());
		insured.setAddressdistrict(quot.getAddressDistrict());
		insured.setAddressstreet(quot.getAddressStreet());
		insured.setAddressunitno((int) quot.getAddressUnitNo());
		insured.setAddresszipcode((int) quot.getAddressZipCode());
		if (quot.getInsuredDob() != null)
			insured.setInsureddob(odsDateFormatter.format(quot.getInsuredDob()));
		insured.setInsuredemail(quot.getInsuredEmail());
		insured.setInsuredfirstname((quot.getInsuredName() != null) ? quot.getInsuredName().split(" ")[0] : "-");

		if (quot.getInsuredGender().equals(String.valueOf(INSURED_GENDER_MALE)))
			insured.setInsuredgender(YAKEEN_INSURED_GENDER_MALE);
		else if (quot.getInsuredGender().equals(String.valueOf(INSURED_GENDER_FEMALE)))
			insured.setInsuredgender(YAKEEN_INSURED_GENDER_FEMALE);
		else
			insured.setInsuredgender(quot.getInsuredGender());
		_log.info("ods Gender:" + insured.getInsuredgender());
		if (quot.getVehicleOwnerIban() != null)
			insured.setInsurediban(quot.getVehicleOwnerIban());
		else
			insured.setInsurediban(quotation.getVehicleOwnerIban());
		insured.setInsuredid(quot.getInsuredId());
		insured.setInsuredidtype((int) quot.getInsuredIdType());
		insured.setInsuredlastname((quot.getInsuredName() != null && quot.getInsuredName().split(" ").length > 2)
				? quot.getInsuredName().split(" ")[2]
				: "-");
		insured.setInsuredmiddlename((quot.getInsuredName() != null && quot.getInsuredName().split(" ").length > 1)
				? quot.getInsuredName().split(" ")[1]
				: "-");
		insured.setInsuredmobile(quot.getInsuredMobile());
		insured.setInsurednationality(quot.getInsuredNationality());
		insured.setInsuredOccupation(quot.getInsuredOccupationCode());

		ODSPolicy policy = new ODSPolicy();
		policy.setPaymentamount(quot.getGrossPrem());
		policy.setPaymentmethod(quot.getPaymentMethod());
		policy.setPaymentrefno(quot.getPaymentRefNo());
		if (quot.getPolicyEffDate() != null)
			policy.setPolicyeffdate(odsDateFormatter.format(quot.getPolicyEffDate()));
		if (quot.getProductCode().equals("MTP") || quot.getProductCode().equals("TP"))
			policy.setProductcode("TP");
		else
			policy.setProductcode("OD");
		policy.setReferenceno(quot.getReferenceNo());
		policy.setSource(quot.getSource());
		policy.setTransaction("01");

		ODSVehicleInfo vInfo = new ODSVehicleInfo();
		vInfo.setAddCoverCount((quot.getCoversList() != null) ? quot.getCoversList().size() : 0);
		vInfo.setAddDriverCount((quot.getQuotationDrivers() != null && !quot.getQuotationDrivers().isEmpty())
				? quot.getQuotationDrivers().size()
				: 0);
		vInfo.setAgencyRepair(quot.getAgencyRepair());
		vInfo.setCity(quot.getVehicleCity());
		vInfo.setDeductibleValue(quot.getDeductibleValue());
		vInfo.setGrossPremium(quot.getGrossPrem());
		vInfo.setLoadingAmount(quot.getLoadingAmount());
		vInfo.setLoyaltyDiscount("" + quot.getLoyaltyDiscountFlag());
		vInfo.setLoyaltyDiscountAmount((quot.getLoyaltyDiscount() != null && !quot.getLoyaltyDiscount().equals(""))
				? Double.valueOf(quot.getLoyaltyDiscount())
				: 0.0);
		vInfo.setLoyaltyDiscountPer(quot.getLoyaltyDiscountPer());
		vInfo.setNcdDiscountAmount(quot.getDiscountAmount());
		vInfo.setNcdDiscountPer(quot.getDiscountPrem());
		vInfo.setNcdYears((int) quot.getNcdYears());
		vInfo.setNetPremium(quot.getNetPrem() + quot.getAgencyRepairOut() + quot.getDriverAgeLess21());
		vInfo.setPolicyFees(quot.getPolicyFees());
		vInfo.setPolicyTaxes((quot.getGrossPrem() / (1 + quot.getPolicyTaxes())) * quot.getPolicyTaxes());
		// vInfo.setPostCity(quot.getpost);
		vInfo.setPurposeOfVehicle(quot.getPurposeOfVehicle());
		vInfo.setTotalCoverPremium(quot.getTotalCoverPrem());
		vInfo.setVehicleBodyType(quot.getVehicleBodyType());
		vInfo.setVehicleCapacity((int) quot.getVehicleCapacity());
		vInfo.setVehicleChassisNo(quot.getVehicleChassisNo());
		vInfo.setVehicleColor(quot.getVehicleColor());
		vInfo.setVehicleCylinder((int) quot.getVehicleCylinder());
		if (quot.getVehicleEstExpiryDate() != null)
			vInfo.setVehicleEstExpDate(odsDateFormatter.format(quot.getVehicleEstExpiryDate()));
		vInfo.setVehicleId(quot.getVehicleId());
		vInfo.setVehicleIdType((VEHICLE_TRANSFER_OWNERSHIP_CARD.equals("" + quot.getVehicleIdType())) ? (1)
				: (int) quot.getVehicleIdType());
		vInfo.setVehicleMake(quot.getVehicleMake());
		vInfo.setVehicleMfgYear((int) quot.getVehicleMfgYear());
		vInfo.setVehicleModel(quot.getVehicleModel());
		vInfo.setVehiclePlateL1(quot.getVehiclePlateL1());
		vInfo.setVehiclePlateL2(quot.getVehiclePlateL2());
		vInfo.setVehiclePlateL3(quot.getVehiclePlateL3());
		vInfo.setVehiclePlateNo((int) quot.getVehiclePlateNo());
		vInfo.setVehiclePlateType(quot.getVehiclePlateType());
		vInfo.setVehicleValue(quot.getVehicleValue());
		vInfo.setVehicleWeight((int) quot.getVehicleWeight());
		vInfo.setExistingPolicyNo(quot.getExistingPolicyNo());
		vInfo.setExistingCompanyName(quot.getExistingCompanyName());
		if (quot.getExistingExpDate() != null && !quot.getExistingExpDate().equals("")) {
			try {
				Date existDate = dateFormatter.parse(quot.getExistingExpDate());
				vInfo.setExisitingExpiryDate(odsDateFormatter.format(existDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (quot.getCoversList() != null && !quot.getCoversList().isEmpty()) {
			List<ODSCover> odsCoversList = new ArrayList<>();
			for (QuotationCover qCover : quot.getCoversList()) {
				ODSCover cover = new ODSCover();
				String coverCode = qCover.getCoverCode();
				long coverPrem = qCover.getCoverPrem();
				cover.setCovercode(coverCode);
				cover.setCoverprem(coverPrem);
				cover.setCoverrate(qCover.getCoverRate());
				cover.setCoversi(qCover.getCoverSi());
				if (qCover.getCoverEffFromDate() != null)
					cover.setCoverefffrmdate(odsDateFormatter.format(qCover.getCoverEffFromDate()));
				else {
					_log.debug(" -------- Cover with code: " + cover.getCovercode()
							+ " has no CoverEffFromDate - Setting the value to policy Effective Date -------- ");
					cover.setCoverefffrmdate(odsDateFormatter.format(quot.getPolicyEffDate()));
				}
				if (qCover.getCoverEffToDate() != null)
					cover.setCoverefftodate(odsDateFormatter.format(qCover.getCoverEffToDate()));
				else {
					_log.debug(" -------- Cover with code: " + cover.getCovercode()
							+ " has no Coverefftodate - Setting the value to policy Effective to Date -------- ");
					cover.setCoverefftodate(odsDateFormatter.format(quot.getPolicyEffTo()));

				}
				cover.setCoverrate(qCover.getCoverRate());
				odsCoversList.add(cover);
			}
			vInfo.setCoverList(odsCoversList);
		}
		if (quot.getQuotationDrivers() != null && !quot.getQuotationDrivers().isEmpty()) {
			List<ODSAddDriver> driverList = new ArrayList<>();
			for (QuotationDriver qDriver : quot.getQuotationDrivers()) {
				ODSAddDriver driver = new ODSAddDriver();
				_log.info("qDriver.getDriverDob():" + qDriver.getDriverDob());

				if (qDriver.getDriverDob() != null && !qDriver.getDriverDob().equals(""))
					driver.setDriverdob(odsDateFormatter.format(qDriver.getDriverDob()));
				else {
					_log.info("Driver is a national. Convert Hijri dob:" + qDriver.getDriverDobH()); // yyyy-MM-dd

					if (qDriver.getDriverDobH() != null && !qDriver.getDriverDobH().equals("")
							&& qDriver.getDriverDobH().indexOf("-") > -1) {
						String[] splittedHijri = qDriver.getDriverDobH().split("-");
						String converetdGregDate = null;

						HijrahDate date = HijrahChronology.INSTANCE.date(Integer.parseInt(splittedHijri[0]),
								Integer.parseInt(splittedHijri[1]), Integer.parseInt(splittedHijri[2]));
						_log.info("Chrono Hijri:" + date);
						converetdGregDate = IsoChronology.INSTANCE.date(date).toString();
						_log.info("Converted Chrono Gregorian:" + converetdGregDate);

						driver.setDriverdob(converetdGregDate);
					} else {
						_log.info("Error in DOB of driver:" + qDriver.getDriverId());
						driver.setDriverdob("");
					}
				}
				driver.setDrivergender(qDriver.getDriverGender());
				driver.setDriverid(qDriver.getDriverId());
				driver.setDriveridtype((int) qDriver.getDriverIdType());
				driver.setDrivername(qDriver.getDriverName());
				driver.setDrivernationality(qDriver.getDriverNationality());
				driver.setDriverNcd(qDriver.getNcdYears());

				driverList.add(driver);
			}
			vInfo.setAddDriverList(driverList);
		}

		List<ODSVehicleInfo> vehicleInfoList = new ArrayList<>();
		vehicleInfoList.add(vInfo);
		ODSPIResponse response = OdsLocalServiceUtil.policyIssuance(insured, policy, vehicleInfoList);
		try {
			Quotations dbQuot = QuotationsLocalServiceUtil.getQuotations(quot.getQuotationId());

			QuotationStatusHistory history = QuotationStatusHistoryLocalServiceUtil
					.createQuotationStatusHistory((int) CounterLocalServiceUtil.increment());
			if (response != null && response.getStatuscode().equals("S")) {
				if (response.getPolicyeffectivefrom() != null)
					dbQuot.setPolicyEffFromNo(odsDateFormatter.parse(response.getPolicyeffectivefrom()));
				if (response.getPolicyeffectiveto() != null)
					dbQuot.setPolicyEffTo(odsDateFormatter.parse(response.getPolicyeffectiveto()));
				dbQuot.setPolicyNo(response.getPolicyno());
				dbQuot.setPolicyRefNo(response.getReferenceno());
				dbQuot.setQuoteStatus(POLICY_STATUS_ACTIVE);
				if (response.getPolicyissuedate() != null)
					dbQuot.setPolicyIssueDate(odsDateFormatter.parse(response.getPolicyissuedate()));
				dbQuot.setPolicyStatusCode(response.getStatuscode());
				QuotationsLocalServiceUtil.updateQuotations(dbQuot);

				history.setDateTime(new Date());
				history.setQuotationId(quot.getQuotationId());
				history.setUserName("" + quot.getInsuredId());
				history.setStatus(POLICY_STATUS_ACTIVE);
				QuotationStatusHistoryLocalServiceUtil.addQuotationStatusHistory(history);

				quot.setPolicyRefNo(response.getReferenceno());
				quot.setPolicyNo(response.getPolicyno());
				quot.setQuoteStatus(POLICY_STATUS_ACTIVE);
			} else if (response != null && response.getStatuscode().equals("F")) {
				dbQuot.setQuoteStatus(QUOTATION_STATUS_REJECTED);
				QuotationsLocalServiceUtil.updateQuotations(dbQuot);

				history.setDateTime(new Date());
				history.setQuotationId(quot.getQuotationId());
				history.setUserName("" + quot.getInsuredId());
				history.setStatus(QUOTATION_STATUS_REJECTED);
				history.setReason(response.getMessage());
				QuotationStatusHistoryLocalServiceUtil.addQuotationStatusHistory(history);

				quot.setQuoteStatus(QUOTATION_STATUS_REJECTED);
			}
		} catch (PortalException | ParseException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public Quotation getPolicyQuot(Policy policy) throws YaqeenException {
		Quotation quot = new Quotation();
		quot.setRenew(true);
		// BAs: To get loyalty discount from tariff procedure you need to pass 1 in the
		// Loyality flag in the input. This needs to be passed for renewal cases even if
		// the customer is not logged in
		quot.setLoyaltyDiscountFlag(1);
		// In buy motor, by default this value is set to true unless changed yb the
		// user.
		quot.setMainDriver(true);
		quot.setProductCode(
				(policy.getProduct() != null && policy.getProduct().equals("" + PRODUCT_CODE_TPL_VAL) ? PRODUCT_CODE_TPL
						: PRODUCT_CODE_COMPREHENSIVE));

		Date policyExpiryDate = policy.getExpiryDate();
		// Expiry date is older than current date
		if (policyExpiryDate.compareTo(new Date()) < 0) {
			Calendar currCal = new GregorianCalendar();
			currCal.setTime(new Date());
			currCal.add(Calendar.DAY_OF_YEAR, 1);

			quot.setPolicyEffDate(currCal.getTime());
		} else {
			Calendar cal = new GregorianCalendar();
			cal.setTime(policyExpiryDate);
			cal.add(Calendar.DAY_OF_YEAR, 1);

			quot.setPolicyEffDate(cal.getTime());
		}
		// set policy expiry date
		Calendar calTO = new GregorianCalendar();
		calTO.setTime(quot.getPolicyEffDate());
		calTO.add(Calendar.YEAR, 1);
		calTO.add(Calendar.DAY_OF_YEAR, -1);
		Date policyExpDate = calTO.getTime();
		quot.setPolicyEffTo(policyExpDate);

		quot.setPaymemtAmount(policy.getTotalPremium());
		quot.setInsuredIdType((policy.getInsuredId() != null && policy.getInsuredId().startsWith("1")) ? ID_TYPE_SAUDI
				: ID_TYPE_IQAMA);
		quot.setInsuredId((policy.getInsuredId() != null) ? Long.valueOf(policy.getInsuredId()) : 0);
		quot.setInsuredDob(policy.getInsuredBirthDate());
		quot.setInsuredName(policy.getInsuredName());
		if (policy.getInsuredId() != null && policy.getInsuredId().startsWith("1"))
			quot.setInsuredNationality("03");
		quot.setInsuredMobile(policy.getInsuredMobile());
		quot.setInsuredEmail(policy.getInsuredEmail());
		quot.setInsuredGender((policy.getInsuredGender() != null && policy.getInsuredGender().equals("1")) ? "M" : "F");

		if (policy.getOccuptation() != null && !policy.getOccuptation().equals(""))
			quot.setInsuredOccupationCode(policy.getOccuptation());

		if (policy.getPolicyVehs() != null && !policy.getPolicyVehs().isEmpty()) {
			PolicyVehicle pVeh = policy.getPolicyVehs().get(0);
			if (pVeh.getVehicleDrivers() != null && !pVeh.getVehicleDrivers().isEmpty()) {
				List<PolicyVehicleDriver> pDrivers = pVeh.getVehicleDrivers();
				for (PolicyVehicleDriver pDriver : pDrivers) {
					QuotationDriver qDriver = new QuotationDriver();

					qDriver.setDriverDob(pDriver.getDriverBirthDate());
					qDriver.setDriverName(pDriver.getDriverName());
					qDriver.setDriverNationality(pDriver.getDriverNationality());
					qDriver.setDriverGender(pDriver.getDriverGender());
					if (pDriver.getDriverLicenseNo() != null) {
						qDriver.setDriverId(Long.valueOf(pDriver.getDriverLicenseNo()));
						if (pDriver.getDriverLicenseNo().startsWith("1"))
							qDriver.setDriverIdType(1);
						else
							qDriver.setDriverIdType(2);
					}

					quot.getQuotationDrivers().add(qDriver);
				}
			}

			quot.setVehicleIdType((pVeh.getVehicleDefType() != null) ? Long.valueOf(pVeh.getVehicleDefType()) : 0);
			quot.setVehicleId((pVeh.getVehicleSeqCustom() != null) ? Long.valueOf(pVeh.getVehicleSeqCustom()) : 0);
			quot.setVehiclePlateType(pVeh.getNajmPlateType());
			try {
				quot.setVehiclePlateTypeDesc(CodeMasterDetailsLocalServiceUtil.getCodeMasterDesc("VEH_TYPE",
						pVeh.getNajmPlateType(), "en_US"));
			} catch (PortalException e1) {
				_log.error(e1.getMessage());
				e1.printStackTrace();
			}
			quot.setVehiclePlateNo(pVeh.getEnPlateNo());
			quot.setVehiclePlateL1(pVeh.getEnPlateL1());
			quot.setVehiclePlateL2(pVeh.getEnPlateL2());
			quot.setVehiclePlateL3(pVeh.getEnPlateL3());
			quot.setPurposeOfVehicle(pVeh.getUseOfCehicle());
			quot.setVehicleMake(pVeh.getMake());
			quot.setVehicleMakeEn(pVeh.getMakeEn());
			quot.setVehicleMakeAr(pVeh.getMakeAr());
			quot.setVehicleModel(pVeh.getModel());
			quot.setVehicleModelEn(pVeh.getModelEn());
			quot.setVehicleModelAr(pVeh.getModelAr());
			quot.setVehicleMfgYear(pVeh.getMfgYear());
			quot.setVehicleColor(pVeh.getColor());
			quot.setVehicleBodyType(pVeh.getBodyType());
			quot.setVehicleBodyTypeEn(pVeh.getBodyTypeEn());
			quot.setVehicleBodyTypeAr(pVeh.getBodyTypeAr());
			quot.setVehicleChassisNo(pVeh.getChassisNo());
			quot.setVehicleCity(pVeh.getGeoLocation());
			try {
				SimpleDateFormat yakeenCarDateFormat = new SimpleDateFormat("dd-MM-YYYY");
				if (pVeh.getEstemaraExpiryDate() != null)
					quot.setVehicleEstExpiryDate(yakeenCarDateFormat.parse(pVeh.getEstemaraExpiryDate()));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			if (quot.getProductCode().equals(PRODUCT_CODE_COMPREHENSIVE)) {
				quot.setDeductibleValue("" + pVeh.getDeductible());
				quot.setVehicleValue(pVeh.getVehicleValue());

				Calendar cal = new GregorianCalendar();
				cal.setTime(new Date());
				long mfgYear = quot.getVehicleMfgYear();
				long diff = cal.get(Calendar.YEAR) - mfgYear;
				// If mnf year older than 5 years then Workshop Repair is automatically selected
				if (diff > 5)
					quot.setAgencyRepair("0");
				else
					quot.setAgencyRepair(pVeh.getAgencyRepair());
			}
			quot.setVehicleCapacity(pVeh.getNoofPassengers());

			ServiceRequest req = new ServiceRequest();
			req.setUsername(PropsUtil.get("com.ejada.atmc.yaqeen.username"));
			req.setPassword(PropsUtil.get("com.ejada.atmc.yaqeen.password"));
			req.setReferenceNumber(PropsUtil.get("com.ejada.atmc.yaqeen.referencenumber"));
			req.setChargeCode(PropsUtil.get("com.ejada.atmc.yaqeen.chargecode"));
			/****
			 * GS: 1/10/2018 - In case of renewals, Yakeen shouldn't be called for Vehicle
			 * Information. TT defect #599 - Renewal: Calling Yakeen Issue - 1R-132
			 */
			/*
			 * if(pVeh.getVehicleDefType().equals(VEHICLE_CUSTOM_CARD)) {
			 * 
			 * BasicCarInfo carInfo = YakeenLocalServiceUtil.getCarInfoByCustom(req,
			 * ""+quot.getVehicleId(), Short.valueOf(""+pVeh.getMfgYear()));
			 * if(carInfo.getErrorCode() != 0 && carInfo.getErrorMessage()!=null) { throw
			 * new YaqeenException(carInfo.getErrorCode(), carInfo.getErrorMessage()); }
			 * else { quot.setVehicleWeight(carInfo.getVehicleWeight());
			 * quot.setVehicleCapacity(carInfo.getVehicleLoad()); } } else
			 * if(pVeh.getVehicleDefType().equals(VEHICLE_ISTIMARA_CARD) ||
			 * pVeh.getVehicleDefType().equals(VEHICLE_TRANSFER_OWNERSHIP_CARD)) { CarInfo
			 * carInfo = null; if(policy.getInsuredId()!=null &&
			 * policy.getInsuredId().startsWith("1")) { carInfo =
			 * YakeenLocalServiceUtil.getCitizenCarInfoBySequence(req,
			 * (int)(quot.getVehicleId()), Long.valueOf(policy.getInsuredId())); } else
			 * carInfo = YakeenLocalServiceUtil.getAlienCarInfoBySequence(req,
			 * (int)(quot.getVehicleId()), Long.valueOf(policy.getInsuredId()));
			 * 
			 * if(carInfo.getErrorCode() != 0 && carInfo.getErrorMessage()!=null) { throw
			 * new YaqeenException(carInfo.getErrorCode(), carInfo.getErrorMessage()); }
			 * else { quot.setVehicleWeight(carInfo.getVehicleWeight());
			 * quot.setVehicleCylinder(carInfo.getCylinders()); } }
			 */

			if (pVeh.getVehicleCovers() != null && !pVeh.getVehicleCovers().isEmpty()) {
				List<PolicyVehicleCover> policyCovers = pVeh.getVehicleCovers();
				List<QuotationCover> quotCovers = new ArrayList<>();
				double totalCoverPrem = 0.0;
				for (PolicyVehicleCover pCover : policyCovers) {
					QuotationCover qCover = new QuotationCover();
					qCover.setCoverCode(pCover.getCvrCode()); /// ???
					qCover.setCoverDesc(pCover.getDescription());
					qCover.setCoverDescAr(pCover.getDescription()); /// ???
					// qCover.setCoverEffFromDate(pCover.get);
					// qCover.setCoverEffToDate(pCover.get);
					qCover.setCoverName(pCover.getDescription());
					qCover.setCoverNameAr(pCover.getDescription());
					// qCover.setCoverSi(pCover.get);
					// qCover.setField1(pCover.get);
					// qCover.setField2(pCover.get);
					// qCover.setField3(pCover.get);
					// qCover.setField4(pCover.get);
					qCover.setCoverPrem(pCover.getPremium());
					Date policyEffDate = quot.getPolicyEffDate();
					qCover.setCoverEffFromDate(policyEffDate);
					qCover.setCoverEffToDate(policyExpDate);

					if (pCover.getCvrType() != null && (pCover.getCvrType().equals("31051")
							|| pCover.getCvrType().equals("31052") || pCover.getCvrType().equals("131004"))) {
						int coverMonths = 0;
						try {
							coverMonths = (pCover.getBenefitTerm() != null) ? Integer.valueOf(pCover.getBenefitTerm())
									: 0;
						} catch (NumberFormatException e) {

						}
						Calendar coverCal = new GregorianCalendar();
						coverCal.setTime(policyEffDate);
						coverCal.add(Calendar.MONTH, coverMonths);
						qCover.setCoverPrem(pCover.getPremium() * ((coverMonths != 0) ? coverMonths : 1));

						if (pCover.getCvrCode() != null
								&& (pCover.getCvrCode().equals("31051") || pCover.getCvrCode().equals("31052")))
							qCover.setCoverEffToDate(coverCal.getTime());

						if (pCover.getCvrCode() != null && pCover.getCvrCode().equals("131004"))
							qCover.setCoverRate(coverMonths);
					}

					List<ProductCovers> productCovers = ProductCoversLocalServiceUtil
							.findByCoverCodeProductCode(qCover.getCoverCode(), Long.valueOf(policy.getProduct()));
					if (productCovers != null && !productCovers.isEmpty()) {
						qCover.setCoverDesc(productCovers.get(0).getCoverDesc());
						qCover.setCoverDescAr(productCovers.get(0).getCoverDescAr());
						qCover.setCoverName(productCovers.get(0).getCoverDesc());
						qCover.setCoverNameAr(productCovers.get(0).getCoverDescAr());
						qCover.setSectionCode(productCovers.get(0).getSectionCode());
					}
					totalCoverPrem += pCover.getPremium();
					// qCover.setCoverRate(pCover.getSumCovered());

					quotCovers.add(qCover);
				}
				quot.setCoversList(quotCovers);
				quot.setTotalCoverPrem(totalCoverPrem);

			}
		}

		CodeMasterMap vehMakeNatMap = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode(ODS_SRC_TYPE_MAKE_NAT,
				quot.getVehicleMake());
		String vehMakeNat = (vehMakeNatMap != null) ? vehMakeNatMap.getCoreCode() : null;
		quot.setVehicleNationality(vehMakeNat);

		quot.setExistingCompanyName("0240000036");
		quot.setExistingPolicyNo(policy.getPolicyNo());

		quot.setQuoteStatus(QUOTATION_STATUS_PENDING_PAYMENT);
		if (policy.getExpiryDate() != null && !policy.getExpiryDate().equals("")) {
			quot.setExistingExpDate(dateFormatter.format(policy.getExpiryDate()));
			boolean odRenewPolicyExpired = false;

			if (quot.getProductCode().equals(PRODUCT_CODE_COMPREHENSIVE)) {

				try {
					Date today = new Date();
					Date todayWithZeroTime = dateFormatter.parse(dateFormatter.format(today));
					odRenewPolicyExpired = policy.getExpiryDate().compareTo(todayWithZeroTime) < 0;
					if (odRenewPolicyExpired)
						quot.setQuoteStatus(QUOTATION_STATUS_PENDING_PAYMENT);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

		}
		// CustomerIban custIban =
		// CustomerIbanLocalServiceUtil.fetchCustomerIban(policy.getInsuredId());
		List<CustomerIban> custIban = null;
		try {
			_log.info("inside iban ");
			custIban = CustomerIbanLocalServiceUtil.findByCustomerIbanDetails(policy.getInsuredId());
			_log.info("iban number >>>>>>>>> 0" + custIban.get(0).getIban());
		} catch (NoSuchAtmcYakeenMakeModelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (custIban != null)
			quot.setVehicleOwnerIban(custIban.get(0).getIban());

		try {
			CodeMaster purposeDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(PURPOSE_OF_VEHICLE_CODE,
					quot.getPurposeOfVehicle());
			if (purposeDetails != null)
				quot.setPurposeOfVehicleDesc(purposeDetails.getCodeDesc());
		} catch (PortalException e) {
			e.printStackTrace();
			_log.error(e.getMessage());
		}
		return quot;
	}

	public Quotation getQuotationDetails(Quotation quot) {
		try {
			// CodeMasterMap vehMakeNatMap =
			// CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode(ODS_SRC_TYPE_MAKE_NAT,
			// quot.getVehicleMake());
			// String vehMakeNat = (vehMakeNatMap!=null)?vehMakeNatMap.getCoreCode():null;
			// quot.setVehicleNationality(vehMakeNat);

			List<QuotationCover> quotationCover = getCustomQuotationCovers(
					QuotationCoversUtil.findByQuotationId(quot.getQuotationId()),
					(quot.getProductCode().equals(PRODUCT_CODE_COMPREHENSIVE)) ? PRODUCT_CODE_COMPREHENSIVE_VAL
							: PRODUCT_CODE_TPL_VAL);
			quot.setCoversList(quotationCover);

			/*
			 * List<QuotationDrivers> driversList =
			 * QuotationDriversUtil.findByQuotationId(quot.getQuotationId()); if(driversList
			 * != null && !driversList.isEmpty()) { for(QuotationDrivers drv:driversList) {
			 * QuotationDriver customDriver = getCustomQuotationDriver(drv);
			 * quot.getQuotationDrivers().add(customDriver); } }
			 */
			CodeMasterMap vehMakeMap = null;
			if (quot.getVehicleModel() != null && !quot.getVehicleModel().equals(""))
				vehMakeMap = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode(
						CustomerVehicleDetailsLocalServiceImpl.ODS_SRC_TYPE_VEH_MAKE, "" + quot.getVehicleModel());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return quot;
	}

	public List<Quotation> getQuotations(String status, long iqamaId, boolean andSearch, int start, int end)
			throws SystemException {
		DynamicQuery dynamicQuery = buildStudentDynamicQuery(status, iqamaId, andSearch);
		List<Quotations> quotationsList = QuotationsLocalServiceUtil.dynamicQuery(dynamicQuery, start, end);
		List<Quotation> customQuotationList = getCustomQuotations(quotationsList);

		List<Quotation> adminCustomQuotationsList = null;
		try {
			adminCustomQuotationsList = getAdminCustomQuotationsList(customQuotationList);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminCustomQuotationsList;
	}

	public Long getQuotationsCount(String status, long iqamaId, boolean andSearch) throws SystemException {
		DynamicQuery dynamicQuery = buildStudentDynamicQuery(status, iqamaId, andSearch)
				.setProjection(ProjectionFactoryUtil.rowCount());
		List entries = QuotationsLocalServiceUtil.dynamicQuery(dynamicQuery);
		return (Long) entries.get(0);
	}

	protected DynamicQuery buildStudentDynamicQuery(String status, long iqamaId, boolean andSearch) {
		Junction junction = null;
		if (andSearch)
			junction = RestrictionsFactoryUtil.conjunction();
		else
			junction = RestrictionsFactoryUtil.disjunction();

		if (Validator.isNotNull(status)) {
			Property property = PropertyFactoryUtil.forName("quoteStatus");
			String value = (new StringBuilder("%")).append(status).append("%").toString();
			junction.add(property.like(value));
		}
		if (Validator.isNotNull(iqamaId)) {
			Property property = PropertyFactoryUtil.forName("insuredId");
			junction.add(property.eq(iqamaId));
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Quotations.class, getClassLoader());
		return dynamicQuery.add(junction);
	}

	public List<Quotation> getAllPendingQuotations(Date expiryDate, String quoteStatus, boolean smsFlag)
			throws PortalException {
		List<Quotations> quotationsList = QuotationsLocalServiceUtil.getPendingPayment(expiryDate, quoteStatus,
				smsFlag);

		List<Quotations> pendingQuots = new ArrayList<Quotations>();
		Date today = new Date();

		for (int i = 0; i < quotationsList.size(); i++) {
			Quotations quot = quotationsList.get(i);
			Date vehExpiryDate = quot.getVehicleEstExpiryDate();
			boolean pendingFlag = Math.abs(vehExpiryDate.getTime() - today.getTime()) <= MILLIS_PER_DAY;
			if (pendingFlag)
				pendingQuots.add(quot);
		}

		List<Quotation> customQuotationList = new ArrayList<Quotation>();
		if (pendingQuots != null && pendingQuots.size() > 0)
			customQuotationList = getCustomQuotations(pendingQuots);

		return customQuotationList;
	}

	public List<Quotation> getExpiredQuotsByDate(Date expiryDate, String[] status) throws PortalException {
		List<Quotations> quotationsList = QuotationsLocalServiceUtil.getDateExpiredQuots(expiryDate, status);
		List<Quotation> customQuotationList = getCustomQuotations(quotationsList);

		return customQuotationList;
	}

	public void updateQuoteFlag(long quotId, boolean smsFlag) throws PortalException {
		Quotations dbQuot = QuotationsLocalServiceUtil.getQuotations(quotId);
		dbQuot.setSmsFlag(smsFlag);
		QuotationsLocalServiceUtil.updateQuotations(dbQuot);
	}

	public void updateQuoteStatus(long quotId, String status) throws PortalException {
		Quotations quote = QuotationsLocalServiceUtil.getQuotations(quotId);

		QuotationStatusHistory history = QuotationStatusHistoryLocalServiceUtil
				.createQuotationStatusHistory((int) CounterLocalServiceUtil.increment());
		quote.setQuoteStatus(status);
		QuotationsLocalServiceUtil.updateQuotations(quote);

		history.setDateTime(new Date());
		history.setQuotationId(quote.getQuotationId());
		history.setUserName("" + quote.getInsuredId());
		history.setStatus(status);
		QuotationStatusHistoryLocalServiceUtil.addQuotationStatusHistory(history);

		QuotationsLocalServiceUtil.updateQuotations(quote);
	}

	public void vehicleImagesUpload(long quotationId, List<QuotationVehicleImage> vehicleImagesList) {
		_log.info("Saving vehicle images to DB. Number of images:" + vehicleImagesList.size());

		try {
			CustUploads uploads = CustUploadsLocalServiceUtil
					.createCustUploads((int) CounterLocalServiceUtil.increment());
			uploads.setQuotId(String.valueOf(quotationId));

			for (QuotationVehicleImage i : vehicleImagesList) {
				int imageType = i.getImageTitle();
				String imageBase64Str = i.getImageMedia();
				byte[] decodedBytes = Base64.getDecoder().decode(imageBase64Str);

				if (imageType == 1) {
					uploads.setCarFrontFile(new javax.sql.rowset.serial.SerialBlob(decodedBytes));
				} else if (imageType == 2) {
					uploads.setCarBackFile(new javax.sql.rowset.serial.SerialBlob(decodedBytes));
				} else if (imageType == 3) {
					uploads.setCarLeftFile(new javax.sql.rowset.serial.SerialBlob(decodedBytes));
				} else if (imageType == 4) {
					uploads.setCarRightFile(new javax.sql.rowset.serial.SerialBlob(decodedBytes));
				} else {
					_log.info("No Handling for Image with Title:" + imageType);
				}
			}

			uploads = CustUploadsLocalServiceUtil.addCustUploads(uploads);
		} catch (Exception e) {
			_log.info("Error trying to save vehicle images to DB");
			e.printStackTrace();
			_log.error(e.getMessage());
		}
	}

	public void notifyUser(HttpServletRequest httpRequest, Quotation quot, Locale local, User user) {
		try {
			Map<String, Object> paramsMap = getQuoteDetailsReportParams(httpRequest, quot);
			double driverAccids = 0.0;
			double passAccids = 0.0;
			if (quot.getCoversList() != null && !quot.getCoversList().isEmpty()) {
				for (QuotationCover qCover : quot.getCoversList()) {
					if (qCover.getCoverCode() != null && qCover.getCoverCode().equals("131002"))
						driverAccids = qCover.getCoverPrem();
					else if (qCover.getCoverCode() != null && qCover.getCoverCode().equals("131004"))
						passAccids = qCover.getCoverPrem();
				}
			}
			paramsMap.put("driverAccids", driverAccids);
			paramsMap.put("passAccids", passAccids);
			List<Quotation> ds = new ArrayList<>();
			ds.add(quot);

			File directory = new File(PropsUtil.get("com.ejada.atmc.quote.report.path"));
			if (!directory.exists()) {
				directory.mkdirs();
			}

			File qFile = new File(
					PropsUtil.get("com.ejada.atmc.quote.report.path") + "/quotation_" + quot.getReferenceNo() + ".pdf");
			if (!qFile.exists())
				qFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(qFile);
			ReportsUtil.fillAndExportPDFReport("quote_dets.jasper", ds, paramsMap, fos);
			List<File> fileList = new ArrayList<>();
			fileList.add(qFile);
			List<String> fileNames = new ArrayList<String>();
			fileNames.add("quotation_" + quot.getReferenceNo() + ".pdf");

			String notifType = (quot.getProductCode().equals(PRODUCT_CODE_TPL)) ? "QUOTATION_GENERATION_TPL"
					: "QUOTATION_GENERATION_TPL";
			String[] mailParams = { quot.getInsuredName(), PropsUtil.get("dashboardURL") };
			String[] smsParams = { PropsUtil.get("dashboardURL") };
			NotificationsLocalServiceUtil.notifyUser(local, notifType, quot.getInsuredEmail(), quot.getInsuredMobile(),
					mailParams, smsParams, fileList, fileNames, mailParams, user.getUserId(), user.getCompanyId());

			if (qFile.exists())
				qFile.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Map<String, Object> getQuoteDetailsReportParams(HttpServletRequest httpReq, Quotation quot) {
		Map<String, Object> paramsMap = new HashMap<>();
		String currLocale = httpReq.getLocale().toString();
		paramsMap.put("cover_type",
				(quot.getProductCode().equals(PRODUCT_CODE_COMPREHENSIVE)) ? LanguageUtil.get(httpReq, "comp_product")
						: LanguageUtil.get(httpReq, "tpl_product"));
		paramsMap.put("quot_no", LanguageUtil.get(httpReq, "quote_no"));
		paramsMap.put("veh_make_val", (currLocale.equals("en_US")) ? quot.getVehicleMakeEn() : quot.getVehicleMakeAr());
		paramsMap.put("veh_model_val",
				(currLocale.equals("en_US")) ? quot.getVehicleModelEn() : quot.getVehicleModelAr());
		paramsMap.put("from", LanguageUtil.get(httpReq, "from"));
		paramsMap.put("to", LanguageUtil.get(httpReq, "to"));

		Date fromDate = quot.getQuoteSubmissionDate() != null ? quot.getQuoteSubmissionDate() : new Date();

		Calendar cal = new GregorianCalendar();
		cal.setTime(fromDate);
		cal.add(Calendar.DAY_OF_YEAR, 3);
		Date effToDate = cal.getTime();
		/*
		 * my changes start Calendar calTO = new GregorianCalendar();
		 * cal.setTime(fromDate); calTO.add(Calendar.YEAR, 1);
		 * calTO.add(Calendar.DAY_OF_MONTH, 60); calTO.add(Calendar.DAY_OF_YEAR, -1);
		 * Date quotExpDate = calTO.getTime();
		 * _log.info("probable expiry date from table "+quot.getPolicyEffTo());
		 * _log.info("probable expiry date calculated "+quotExpDate); my changes end
		 */
		paramsMap.put("quotProbableExpDate", dateFormatter.format(quot.getPolicyEffTo()));
		paramsMap.put("from_val", dateFormatter.format(fromDate));
		paramsMap.put("to_val", dateFormatter.format(effToDate));
		paramsMap.put("page_no", LanguageUtil.get(httpReq, "page_no"));
		paramsMap.put("owner_dets", LanguageUtil.get(httpReq, "owner_dets"));
		paramsMap.put("ist_card", LanguageUtil.get(httpReq, "ist_card"));
		paramsMap.put("ins_type", LanguageUtil.get(httpReq, "ins_type"));
		paramsMap.put("iqama_no", LanguageUtil.get(httpReq, "iqama_no"));
		paramsMap.put("driver_dob", LanguageUtil.get(httpReq, "driver_dob"));
		paramsMap.put("email", LanguageUtil.get(httpReq, "email"));
		paramsMap.put("mob_no", LanguageUtil.get(httpReq, "mob_no"));
		paramsMap.put("add_driver", LanguageUtil.get(httpReq, "add_driver"));
		paramsMap.put("veh_owner", LanguageUtil.get(httpReq, "veh_owner"));
		paramsMap.put("driver_iqama_id", LanguageUtil.get(httpReq, "driver_iqama_id"));
		paramsMap.put("age", LanguageUtil.get(httpReq, "age"));
		paramsMap.put("veh_det", LanguageUtil.get(httpReq, "veh_det"));
		paramsMap.put("make", LanguageUtil.get(httpReq, "make"));
		paramsMap.put("mod_ver", LanguageUtil.get(httpReq, "mod_ver"));
		paramsMap.put("body_type", LanguageUtil.get(httpReq, "body_type"));
		paramsMap.put("year_make", LanguageUtil.get(httpReq, "year_make"));
		paramsMap.put("plate_no", LanguageUtil.get(httpReq, "plate_no"));
		paramsMap.put("veh_use", LanguageUtil.get(httpReq, "veh_use"));
		paramsMap.put("chassis_no", LanguageUtil.get(httpReq, "chassis_no_report"));
		paramsMap.put("seq_no", LanguageUtil.get(httpReq, "seq_no"));
		paramsMap.put("add_ben", LanguageUtil.get(httpReq, "add_ben"));
		paramsMap.put("pmnt_dets", LanguageUtil.get(httpReq, "pmnt_dets"));
		paramsMap.put("premium", LanguageUtil.get(httpReq, "premium"));
		paramsMap.put("val_veh_rate", LanguageUtil.get(httpReq, "val_veh_rate"));
		paramsMap.put("no_claim", LanguageUtil.get(httpReq, "no_claim"));
		paramsMap.put("discount_rate", LanguageUtil.get(httpReq, "discount_rate"));
		paramsMap.put("policy_tax", LanguageUtil.get(httpReq, "policy_tax"));
		paramsMap.put("quot_valid_until", LanguageUtil.get(httpReq, "quot_valid_until"));
		paramsMap.put("quot_ind_veh_ins_pol", LanguageUtil.get(httpReq, "quot_ind_veh_ins_pol"));
		paramsMap.put("company_name", LanguageUtil.get(httpReq, "company_name_report"));
		paramsMap.put("quot_issue_name", LanguageUtil.get(httpReq, "quot_issue_name"));
		paramsMap.put("online", LanguageUtil.get(httpReq, "online"));
		paramsMap.put("issue_date", LanguageUtil.get(httpReq, "issue_date"));
		paramsMap.put("job_no", LanguageUtil.get(httpReq, "job_no"));
		paramsMap.put("city", LanguageUtil.get(httpReq, "city"));
		paramsMap.put("veh_owner_det", LanguageUtil.get(httpReq, "veh_owner_det"));
		paramsMap.put("veh_data", LanguageUtil.get(httpReq, "veh_data"));
		paramsMap.put("client_name", LanguageUtil.get(httpReq, "client_name"));
		paramsMap.put("id_number", LanguageUtil.get(httpReq, "id_number"));
		paramsMap.put("birth_date", LanguageUtil.get(httpReq, "birth_date"));
		paramsMap.put("gender", LanguageUtil.get(httpReq, "gender"));
		paramsMap.put("prof", LanguageUtil.get(httpReq, "prof"));
		paramsMap.put("resid_id", LanguageUtil.get(httpReq, "resid_id"));
		paramsMap.put("nat_addr", LanguageUtil.get(httpReq, "nat_addr"));
		paramsMap.put("iban", LanguageUtil.get(httpReq, "iban"));
		paramsMap.put("bank_name", LanguageUtil.get(httpReq, "bank_name"));
		paramsMap.put("veh_type_model", LanguageUtil.get(httpReq, "veh_type_model"));
		paramsMap.put("cityVal", quot.getCityDesc());
		paramsMap.put("veh_color", LanguageUtil.get(httpReq, "veh_color"));
		paramsMap.put("ser_cust_no", LanguageUtil.get(httpReq, "ser_cust_no"));
		paramsMap.put("reg_type", LanguageUtil.get(httpReq, "reg_type"));
		paramsMap.put("use_type", LanguageUtil.get(httpReq, "use_type"));
		paramsMap.put("mnf_year", LanguageUtil.get(httpReq, "mnf_year"));
		paramsMap.put("curr_ins", LanguageUtil.get(httpReq, "curr_ins"));
		paramsMap.put("policy_no", LanguageUtil.get(httpReq, "policy_no"));
		paramsMap.put("exp_date", LanguageUtil.get(httpReq, "exp_date"));
		paramsMap.put("drv_data", LanguageUtil.get(httpReq, "drv_data"));
		paramsMap.put("driver_name", LanguageUtil.get(httpReq, "driver_name"));
		paramsMap.put("tpl_civ_ins", LanguageUtil.get(httpReq, "tpl_civ_ins"));
		paramsMap.put("cov_driver_under_age", LanguageUtil.get(httpReq, "cov_driver_under_age"));
		paramsMap.put("ins_ins_veh", LanguageUtil.get(httpReq, "ins_ins_veh"));
		paramsMap.put("ins_agnst_othrs", LanguageUtil.get(httpReq, "ins_agnst_othrs"));
		paramsMap.put("price", LanguageUtil.get(httpReq, "price"));
		paramsMap.put("comp", LanguageUtil.get(httpReq, "comp"));
		paramsMap.put("ins_val", LanguageUtil.get(httpReq, "ins_val"));
		paramsMap.put("ded_amnt", LanguageUtil.get(httpReq, "ded_amnt"));
		paramsMap.put("max_comp_tot_loss", LanguageUtil.get(httpReq, "max_comp_tot_loss"));
		paramsMap.put("ded_amount_inc", LanguageUtil.get(httpReq, "ded_amount_inc"));
		paramsMap.put("add_opts", LanguageUtil.get(httpReq, "add_opts"));
		paramsMap.put("agency_repair", LanguageUtil.get(httpReq, "agency_repair"));
		paramsMap.put("prov_repl_veh", LanguageUtil.get(httpReq, "prov_repl_veh"));
		paramsMap.put("saeed_serv", LanguageUtil.get(httpReq, "saeed_serv"));
		paramsMap.put("drv_pers_accid", LanguageUtil.get(httpReq, "drv_pers_accid"));
		paramsMap.put("pass_pers_accid", LanguageUtil.get(httpReq, "pass_pers_accid"));
		paramsMap.put("admin_fees", LanguageUtil.get(httpReq, "admin_fees"));
		paramsMap.put("commission", LanguageUtil.get(httpReq, "commission"));
		paramsMap.put("vat", LanguageUtil.get(httpReq, "vat"));
		paramsMap.put("absc_claims", LanguageUtil.get(httpReq, "absc_claims"));
		paramsMap.put("loyalty", LanguageUtil.get(httpReq, "loyalty"));
		paramsMap.put("exp_add_ded", LanguageUtil.get(httpReq, "exp_add_ded"));
		paramsMap.put("tot_bf_disc", LanguageUtil.get(httpReq, "tot_bf_disc"));
		paramsMap.put("tot_after_ded", LanguageUtil.get(httpReq, "tot_after_ded"));
		paramsMap.put("avail_choices", LanguageUtil.get(httpReq, "avail_choices"));
		paramsMap.put("exp_geoc_scope", LanguageUtil.get(httpReq, "exp_geoc_scope"));
		paramsMap.put("count_counts", LanguageUtil.get(httpReq, "count_counts"));
		paramsMap.put("non_app_dep_cond", LanguageUtil.get(httpReq, "non_app_dep_cond"));
		paramsMap.put("not_wish_insure", LanguageUtil.get(httpReq, "not_wish_insure"));
		paramsMap.put("ack_read_quot", LanguageUtil.get(httpReq, "ack_read_quot"));
		paramsMap.put("client_name", LanguageUtil.get(httpReq, "client_name"));
		paramsMap.put("signature", LanguageUtil.get(httpReq, "signature"));
		paramsMap.put("date_time", LanguageUtil.get(httpReq, "date_time"));
		paramsMap.put("disc_due", LanguageUtil.get(httpReq, "disc_due"));
		paramsMap.put("loading", LanguageUtil.get(httpReq, "loading"));
		paramsMap.put("quot", LanguageUtil.get(httpReq, "quot"));
		paramsMap.put("loading_amt", LanguageUtil.get(httpReq, "loading_amt"));
		paramsMap.put("cncl_fees", LanguageUtil.get(httpReq, "policy_cncl_fees"));
		paramsMap.put("probableExpDate", LanguageUtil.get(httpReq, "probable_Exp_date"));

		// paramsMap.put("rentCar", 0.0);

		double driverAccids = 0.0;
		double passAccids = 0.0;
		double rentCar = 0.0;
		double totalCovers = 0.0;
		if (quot.getCoversList() != null && !quot.getCoversList().isEmpty()) {
			for (QuotationCover qCover : quot.getCoversList()) {
				if (qCover.getCoverCode() != null && qCover.getCoverCode().equals("131002"))
					driverAccids = qCover.getCoverPrem();
				else if (qCover.getCoverCode() != null && qCover.getCoverCode().equals("131004"))
					passAccids = qCover.getCoverPrem();
				else if (qCover.getCoverCode() != null && qCover.getCoverCode().equals("131014"))
					rentCar = qCover.getCoverPrem();
				if (qCover.getCoverCode() != null && qCover.getCoverCode().equals("31052")) {
					paramsMap.put("geoCover", qCover.getCoverPrem());
				}
				totalCovers += qCover.getCoverPrem();
			}
		}

		CodeMasterMap vehColorMap = CodeMasterMapLocalServiceUtil.findBySourceTypeCoreCode(ODS_SRC_TYPE_COLOR,
				quot.getVehicleColor());
		try {
			quot.setVehicleColorEn(vehColorMap.getCoreDesc());
			quot.setVehicleColorAr(vehColorMap.getCoreDesc());
		} catch (Exception e) {
			e.printStackTrace();
		}

		_log.debug(" --------------- SAMA Report - totalCovers = " + totalCovers + " --------------- ");
		paramsMap.put("driverAccids", driverAccids);
		paramsMap.put("passAccids", passAccids);
		paramsMap.put("rentCar", rentCar);
		paramsMap.put("totalCovers", totalCovers);

		return paramsMap;
	}

	public Quotation reviewQuotation(Quotation quot, boolean isUserSignedIn, String lang) throws PortalException {
		_log.info("Inside Review Quotation start");
		quot = getTariffDets(quot, false);

		double loyaltyDiscountAmount = 0.0;
		if (quot.getLoyaltyDiscount() != null)
			loyaltyDiscountAmount = Double.valueOf(quot.getLoyaltyDiscount());
		double finalNetPrem = quot.getNetPrem() + quot.getAgencyRepairOut() + quot.getDriverAgeLess21()
				- quot.getDiscountAmount() - loyaltyDiscountAmount + quot.getLoadingAmount() + quot.getPolicyFees()
				+ quot.getTotalCoverPrem();
		double vat = (quot.getPolicyTaxes() * finalNetPrem);
		finalNetPrem += vat;
		quot.setGrossPrem(finalNetPrem);

		_log.info("Reference number:" + quot.getReferenceNo());

		if (quot.getQuotationId() != 0 && quot.isRenew()) {
			// quot = QuotationLocalServiceUtil.getTariffDets(quot);

			long qID = quot.getQuotationId();
			if (quot.getCoversList() != null && !quot.getCoversList().isEmpty()) {
				for (QuotationCover qCover : quot.getCoversList()) {
					QuotationCoversPK covPk = new QuotationCoversPK(qCover.getAddCoverId(), qID);
					QuotationCovers qCvr = QuotationCoversLocalServiceUtil.fetchQuotationCovers(covPk);
					if (qCvr != null)
						QuotationCoversLocalServiceUtil.deleteQuotationCovers(covPk);
				}

				if (quot.isProductChanged() && quot.getProductCode().equals(PRODUCT_CODE_TPL)) {
					quot.setCoversList(null);
					quot.setTotalCoverPrem(0);
				}
			}
			if (quot.getQuotationDrivers() != null && !quot.getQuotationDrivers().isEmpty()) {
				for (QuotationDriver drv : quot.getQuotationDrivers()) {
					QuotationDriversPK qDrvPK = new QuotationDriversPK(drv.getAddDriverId(), qID);
					QuotationDrivers qDrv = QuotationDriversLocalServiceUtil
							.fetchQuotationDrivers(drv.getAddDriverId());
					if (qDrv != null) {
						List<QuotationDriverLicense> driverLicenseList = drv.getDriverLicences();
						if (driverLicenseList != null && !driverLicenseList.isEmpty()) {
							for (QuotationDriverLicense drvLic : driverLicenseList) {
								QuotationsDriverLicense lic = QuotationsDriverLicenseLocalServiceUtil
										.fetchQuotationsDriverLicense(drvLic.getLicenseId());
								if (lic != null)
									QuotationsDriverLicenseLocalServiceUtil.deleteQuotationsDriverLicense(lic);
							}
						}
						if (drv.getDriverNatAddress() != null) {
							QuotationsUserAddress addr = QuotationsUserAddressLocalServiceUtil
									.fetchQuotationsUserAddress(drv.getDriverNatAddress().getUserAddressId());
							if (addr != null)
								QuotationsUserAddressLocalServiceUtil.deleteQuotationsUserAddress(addr);
						}
						if (drv.getDriverOffNatAddress() != null) {
							QuotationsUserAddress addr = QuotationsUserAddressLocalServiceUtil
									.fetchQuotationsUserAddress(drv.getDriverOffNatAddress().getUserAddressId());
							if (addr != null)
								QuotationsUserAddressLocalServiceUtil.deleteQuotationsUserAddress(addr);
						}
						QuotationDriversLocalServiceUtil.deleteQuotationDrivers(drv.getAddDriverId());
					}
				}
			}
			if (quot.getNatAddress() != null) {
				QuotationsUserAddress addr = QuotationsUserAddressLocalServiceUtil
						.fetchQuotationsUserAddress(quot.getNatAddress().getUserAddressId());
				if (addr != null)
					QuotationsUserAddressLocalServiceUtil.deleteQuotationsUserAddress(addr);
			}
			if (quot.getOffAddress() != null) {
				QuotationsUserAddress addr = QuotationsUserAddressLocalServiceUtil
						.fetchQuotationsUserAddress(quot.getOffAddress().getUserAddressId());
				if (addr != null)
					QuotationsUserAddressLocalServiceUtil.deleteQuotationsUserAddress(addr);
			}
			long qUploadsID = CustUploadsLocalServiceUtil.findIdByQuotationId("" + qID);
			if (qUploadsID != 0)
				CustUploadsLocalServiceUtil.deleteCustUploads(qUploadsID);

			List<QuotationStatusHistory> qHistList = QuotationStatusHistoryLocalServiceUtil.findByQuotationId(qID);

			if (qHistList != null && !qHistList.isEmpty()) {
				for (QuotationStatusHistory qHist : qHistList) {
					QuotationStatusHistoryLocalServiceUtil.deleteQuotationStatusHistory(qHist);
				}
			}

			Quotations dbQuot = QuotationsLocalServiceUtil.fetchQuotations(qID);

			// Th product code has been changed, should generate a new refernce no.
			if (dbQuot != null && !dbQuot.getProductCode().equals(quot.getProductCode()))
				quot.setReferenceNo(null);

			if (dbQuot != null)
				QuotationsLocalServiceUtil.deleteQuotations(qID);
			// quot.setReferenceNo(null);
		}
		if (quot.isRenew() || quot.getReferenceNo() == null)
			quot = submitQuotation(quot, "" + quot.getInsuredId());

		Locale locale = (lang.equals("en")) ? new Locale(lang, "US") : new Locale(lang, "SA");
		HttpServletRequest request = PortalUtil
				.getOriginalServletRequest(AccessControlUtil.getAccessControlContext().getRequest());
		User user = null;
		Company company = PortalUtil.getCompany(request);
		user = UserLocalServiceUtil.fetchUserByScreenName(company.getCompanyId(), "" + quot.getInsuredId());
		if (!isUserSignedIn) {
			if (user == null) {
				long companyId = company.getCompanyId();

				ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), request);
//				user = UserMgmtLocalServiceUtil.createUser(companyId, "" + quot.getInsuredId(), null,
//						quot.getInsuredName(), quot.getInsuredName(), locale, "" + quot.getInsuredMobile(),
//						quot.getInsuredEmail(), serviceContext);
			}

		}

		request.getSession().setAttribute("quot", quot);
		// notifyUser(request, quot, locale,user);

		return quot;
	}

	public void saveQuoteUserAddress(QuotationUserAddress custUserNatAddr, long quotationId, long insuredId,
			boolean isNatAddress) {
		QuotationsUserAddress userNatAdd = QuotationsUserAddressLocalServiceUtil.findByQuotationIdDriverId(quotationId,
				insuredId, isNatAddress);
		boolean isUpdate = true;
		if (userNatAdd == null) {
			isUpdate = false;
			userNatAdd = QuotationsUserAddressLocalServiceUtil
					.createQuotationsUserAddress((int) CounterLocalServiceUtil.increment());
		}

		userNatAdd.setAddNo(custUserNatAddr.getAddNo());
		userNatAdd.setBuildNo(custUserNatAddr.getBuildNo());
		userNatAdd.setZipCode(custUserNatAddr.getZipCode());

		userNatAdd.setCityAr(custUserNatAddr.getCity());
		userNatAdd.setCityEn(custUserNatAddr.getCity());
		userNatAdd.setDistrictAr(custUserNatAddr.getDistrict());
		userNatAdd.setDistrictEn(custUserNatAddr.getDistrict());
		userNatAdd.setStNameAr(custUserNatAddr.getStName());
		userNatAdd.setStNameEn(custUserNatAddr.getStName());
		userNatAdd.setIsNatAddress(isNatAddress);

		userNatAdd.setQuotationId(quotationId);
		userNatAdd.setDriverId(insuredId);

		if (isUpdate)
			userNatAdd = QuotationsUserAddressLocalServiceUtil.updateQuotationsUserAddress(userNatAdd);
		else
			userNatAdd = QuotationsUserAddressLocalServiceUtil.addQuotationsUserAddress(userNatAdd);
		custUserNatAddr.setUserAddressId(userNatAdd.getUserAddressId());
	}

	private void getAddressDets(Quotation quot, ServiceRequest req, Locale locale) throws YaqeenException {
		SimpleDateFormat yakeenAddressHijriDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat yakeenAddressGregDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dobG = yakeenAddressGregDateFormat.format(quot.getInsuredDob());
		List<CodeMasterDetails> citiyList = getCities();
		String cityCode = null;

		if (("" + quot.getInsuredId()).startsWith("1")) {
			_log.info("Invoking getCitizenAddressInfo. DOB " + quot.getInsuredDobH() + " " + quot.getInsuredDob());

			// Kareem: Passing DOB G even though it should be Hijri. Don't have Higri date
			// here. It is not saved in ODSPolicyHDR table
			List<AddressInfo> citizenAddrInfo = YakeenLocalServiceUtil.getCitizenAddressInfo(req,
					"" + quot.getInsuredId(), dobG, "E");

			for (AddressInfo addressInfo : citizenAddrInfo) {
				for (CodeMasterDetails cd : citiyList) {
					if (addressInfo.getCity().equalsIgnoreCase(cd.getCodeDesc())) {
						_log.info("codemaster city >>" + addressInfo.getCity() + "yakeen city >>>>>>>"
								+ cd.getCodeDesc());
						cityCode = cd.getCodeSub();
					}
				}

			}

			if (citizenAddrInfo != null && citizenAddrInfo.size() == 1 && citizenAddrInfo.get(0).getErrorCode() != 0
					&& citizenAddrInfo.get(0).getErrorMessage() != null) {
				// throw new YaqeenException(YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED,
				// LanguageUtil.get(locale, "renew_addr_missing"));
				throw new YaqeenException(citizenAddrInfo.get(0).getErrorCode(),
						LanguageUtil.get(locale, "yaqeen_error_" + citizenAddrInfo.get(0).getErrorCode()));
			} else {
				if (citizenAddrInfo != null && !citizenAddrInfo.isEmpty()) {
					AddressInfo info = citizenAddrInfo.get(0);
					if (info.getBuildingNumber() == null && info.getDistrict() == null && info.getStreetName() == null
							&& info.getPostCode() == null && info.getAdditionalNumber() == null
							&& info.getCity() == null)
						throw new YaqeenException(YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED,
								LanguageUtil.get(locale, "renew_addr_missing"));
					else {
						quot.setAddressBuildingNo(
								(info.getBuildingNumber() != null) ? Long.valueOf(info.getBuildingNumber()) : 0L);
						quot.setAddressDistrict(info.getDistrict());
						quot.setAddressStreet(info.getStreetName());
						quot.setAddressZipCode((info.getPostCode() != null) ? Long.valueOf(info.getPostCode()) : 0L);
						quot.setAddressAddNo(
								(info.getAdditionalNumber() != null) ? Long.valueOf(info.getAdditionalNumber()) : 0L);
						quot.setCity(cityCode);
						quot.setCityDesc(info.getCity());
					}
				} else
					throw new YaqeenException(YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED,
							LanguageUtil.get(locale, "renew_addr_missing"));
			}
		} else {
			_log.info("Invoking getAlienAddressInfo. DOB " + dobG + " " + quot.getInsuredDobH());
			List<AddressInfo> citizenAddrInfo = YakeenLocalServiceUtil.getAlienAddressInfo(req,
					"" + quot.getInsuredId(), dobG, "E");
			for (AddressInfo addressInfo : citizenAddrInfo) {
				for (CodeMasterDetails cd : citiyList) {
					if (addressInfo.getCity().equalsIgnoreCase(cd.getCodeDesc())) {
						_log.info("codemaster city >>" + addressInfo.getCity() + "yakeen city >>>>>>>"
								+ cd.getCodeDesc());
						cityCode = cd.getCodeSub();
					}
				}

			}
			if (citizenAddrInfo != null && citizenAddrInfo.size() == 1 && citizenAddrInfo.get(0).getErrorCode() != 0
					&& citizenAddrInfo.get(0).getErrorMessage() != null) {
				throw new YaqeenException(YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED,
						LanguageUtil.get(locale, "renew_addr_missing"));
			} else {
				if (citizenAddrInfo != null && !citizenAddrInfo.isEmpty()) {
					AddressInfo info = citizenAddrInfo.get(0);
					if (info.getBuildingNumber() == null && info.getDistrict() == null && info.getStreetName() == null
							&& info.getPostCode() == null && info.getAdditionalNumber() == null
							&& info.getCity() == null)
						throw new YaqeenException(YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED,
								LanguageUtil.get(locale, "renew_addr_missing"));
					else {
						if (info.getBuildingNumber() != null)
							quot.setAddressBuildingNo(Long.valueOf(info.getBuildingNumber()));
						quot.setAddressDistrict(info.getDistrict());
						quot.setAddressStreet(info.getStreetName());
						if (info.getPostCode() != null)
							quot.setAddressZipCode(Long.valueOf(info.getPostCode()));
						if (info.getAdditionalNumber() != null)
							quot.setAddressAddNo(Long.valueOf(info.getAdditionalNumber()));
						quot.setCity(cityCode);
						quot.setCityDesc(info.getCity());
					}
				} else
					throw new YaqeenException(YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED,
							LanguageUtil.get(locale, "renew_addr_missing"));
			}
		}
	}

	public void renewNcdInquiry(Quotation quot) throws NajmException {
		_log.info("Renew NCD Inquiry - start");
		NCDEligibility ncdRes = NajmLocalServiceUtil.ncdEligibility(quot.getInsuredId(),
				Integer.valueOf("" + quot.getVehicleIdType()), quot.getVehicleId());
		if (ncdRes != null && ncdRes.getStatusCode().equals(NCD_STATUS_CODE_SUCCESS)) {
			if (ncdRes.getNCDFreeYears() != null)
				quot.setNcdYears(Long.valueOf(ncdRes.getNCDFreeYears()));
		} else {
			_log.info("Najm exception. Code " + ncdRes.getStatusCode() + ". Message:" + ncdRes.getErrorMsg());
			throw new NajmException(Integer.valueOf(ncdRes.getStatusCode()), ncdRes.getErrorMsg());
		}

		if (quot.getQuotationDrivers() != null && !quot.getQuotationDrivers().isEmpty()) {
			_log.info("ncd calls for additional drivers");
			List<QuotationDriver> qDrivers = quot.getQuotationDrivers();
			for (QuotationDriver qDriver : qDrivers) {
				NCDEligibility ncdRes2 = NajmLocalServiceUtil.ncdEligibility(qDriver.getDriverId(), Integer.valueOf(3),
						Long.valueOf(0));
				if (ncdRes2 != null && ncdRes2.getStatusCode().equals(NCD_STATUS_CODE_SUCCESS)) {
					if (ncdRes2.getNCDFreeYears() != null)
						qDriver.setNcdYears(Integer.valueOf(ncdRes2.getNCDFreeYears()));
				} else
					throw new NajmException(Integer.valueOf(ncdRes2.getStatusCode()), ncdRes.getErrorMsg());
			}
		}
	}

	public void renewAddressInquiry(Quotation quot, Locale locale) throws YaqeenException {
		ServiceRequest req = new ServiceRequest();
		req.setUsername(PropsUtil.get("com.ejada.atmc.yaqeen.username"));
		req.setPassword(PropsUtil.get("com.ejada.atmc.yaqeen.password"));
		req.setReferenceNumber(PropsUtil.get("com.ejada.atmc.yaqeen.referencenumber"));
		req.setChargeCode(PropsUtil.get("com.ejada.atmc.yaqeen.chargecode"));
		// Customer cust =
		// CustomerLocalServiceUtil.fetchCustomer(""+quot.getInsuredId());
		Customer cust;
		List<Customer> customer = CustomerLocalServiceUtil.findByCustomerIban(String.valueOf(quot.getInsuredId()));
		cust = customer.get(0);
		/*
		 * Customer cust = null; _log.info("before try"); try { _log.info("inside try");
		 * cust = CustomerLocalServiceUtil.fetchCustomer(""+quot.getInsuredId());
		 * _log.info("after calling try"); } catch (Exception e) { // TODO: handle
		 * exception }
		 */
		// Ahmed AE Fattah : TT #460
		// Add Insured Nationality in case of renew to be passed in policy issuance call

		_log.info("Renew Address Inquiry");
		if (cust != null) {
			_log.info(cust.getCustomerBirthDay());
			_log.info(cust.getCustomerBirthDay().toString());
			if (cust.getBuildingNo() == null || cust.getBuildingNo().equals("") || cust.getZipCode() == null
					|| cust.getZipCode().equals("") || cust.getCity() == null || cust.getCity().equals("")) {
				_log.info("Empty Address Data exists. Need to call Yakeen");
				getAddressDets(quot, req, locale);
			} else {
				quot.setInsuredGender((cust.getGender().equals("1") ? "M" : "F"));
				quot.setAddressBuildingNo(Long.valueOf(cust.getBuildingNo()));

				if (cust.getUnitNo() != null && !cust.getUnitNo().equals(""))
					quot.setAddressUnitNo(Long.valueOf(cust.getUnitNo()));
				else
					quot.setAddressUnitNo(0L);

				quot.setAddressStreet(cust.getStreet());
				quot.setAddressDistrict(cust.getDistrict());
				if (cust.getZipCode() != null && !cust.getZipCode().equals(""))
					quot.setAddressZipCode(Long.valueOf(cust.getZipCode()));
				if (cust.getAdditNo() != null && !cust.getAdditNo().equals(""))
					quot.setAddressAddNo(Long.valueOf(cust.getAdditNo()));
				quot.setCity(cust.getCity());
				try {
					CodeMaster cityDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(CITY_CODE, quot.getCity());
					if (cityDetails != null)
						quot.setCityDesc(cityDetails.getCodeDesc());
				} catch (NoSuchCodeMasterException e) {
					e.printStackTrace();
				}
				quot.setInsuredNationality(cust.getNationality());
			}
		} else {
			getAddressDets(quot, req, locale);
		}
	}

	public void renewTariffInquiry(Quotation quot) {

		_log.info("renew tariff inquiry - start");
		try {
			/*
			 * CompDiscount compDiscount =
			 * CompDiscountLocalServiceUtil.getCompDiscount(String.valueOf(quot.getInsuredId
			 * ())); _log.info("quote insured id is >>>>>>>>>>>>>>>" +quot.getInsuredId());
			 */

			// BAs: To get loyalty discount from tariff procedure you need to pass 1 in the
			// Loyality flag in the input. This needs to be passed for renewal cases even if
			// the customer is not logged in
			// if(compDiscount!=null)
			// quot.setSchemeCode("SCHEME_003");
			// quot.setLoyaltyDiscountFlag(1);

			quot = getTariffDets(quot, true);
			quot.getNcdYears();

			double loyaltyDiscountAmount = 0.0;
			if (quot.getLoyaltyDiscount() != null)
				loyaltyDiscountAmount = Double.valueOf(quot.getLoyaltyDiscount());
			double finalNetPrem = quot.getNetPrem() + quot.getAgencyRepairOut() + quot.getDriverAgeLess21()
					- quot.getDiscountAmount() - loyaltyDiscountAmount + quot.getLoadingAmount() + quot.getPolicyFees()
					+ quot.getTotalCoverPrem();// + quot.getPolicyTaxes();
			_log.info("net premium   " + quot.getNetPrem());
			_log.info("net premium   " + quot.getAgencyRepairOut());
			_log.info("net premium   " + quot.getDriverAgeLess21());
			_log.info("net premium   " + quot.getDiscountAmount());
			_log.info("net premium   " + loyaltyDiscountAmount);
			_log.info("net premium   " + quot.getLoadingAmount());
			_log.info("net premium   " + quot.getPolicyFees());
			_log.info("net premium   " + quot.getTotalCoverPrem());
			double vat = (quot.getPolicyTaxes() * finalNetPrem);
			finalNetPrem += vat;
			quot.setGrossPrem(finalNetPrem);
		} catch (PortalException e) {
			e.printStackTrace();
		}

	}

	public boolean validatePolicyData(String policyNo) {
		Quotations quot = null;
		try {
			quot = QuotationsLocalServiceUtil.findByPolicyNo(policyNo);
		} catch (NoSuchQuotationsException e) {
			e.printStackTrace();
		}

		if (quot != null)
			return true;
		else
			return false;
	}

	public String findPolicyNajmStatus(String policyNo) throws PortalException {
		return PolicyHDRLocalServiceUtil.findPolicyNajmStatus(policyNo);
	}

	public String getNajmStatusByPolicyNo(String policyNo) throws PortalException {
		try {
			return PolicyVEHLocalServiceUtil.findByPolicyNumber(policyNo).get(0).getNajmStatus();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public long checkExistingPolicy(String iqamaId, String vehId) {
		_log.info("Checking Existing policies for :" + iqamaId + " and veh Id: " + vehId);
		long sTime1 = System.currentTimeMillis();

		List<PolicyHDR> policiesList = PolicyHDRLocalServiceUtil.getUpcomingPolicyRenewals(iqamaId);

		long period1 = System.currentTimeMillis() - sTime1;
		_log.info("PolicyHDRLocalServiceUtil.getUpcomingPolicyRenewals took " + period1 + " ms");

		_log.info("Retrieved upcoming policies for renewal of count:" + policiesList.size());

		if (policiesList != null && !policiesList.isEmpty()) {
			long sTime = System.currentTimeMillis();
			for (PolicyHDR policy : policiesList) {
				_log.info("findByPolicyNumberVehicleCustomNo for policy:" + policy.getPolicyNo() + "...Vehicle Id:"
						+ vehId);
				List<PolicyVEH> pVehs = PolicyVEHLocalServiceUtil
						.findByPolicyNumberVehicleCustomNo(policy.getPolicyNo(), vehId);

				if (pVehs != null) {
					_log.info("pVehs count:" + pVehs.size());

					if (pVehs.size() > 0) {
						// PolicyVEH pVeh = PolicyVehLocalServiceUtil.fetchPolicyVeh(PolicyVehPK);
						PolicyVEH pVeh = pVehs.get(0);

						if (pVeh != null)
							return RENEWABLE_POLICY_EXISTS;
					}

				}
			}
			long period = System.currentTimeMillis() - sTime;
			_log.info("Looping took " + period + " ms");
		}

		long period2 = System.currentTimeMillis() - sTime1;
		_log.info("total checkExistingPolicy took " + period2 + " ms");
		return 0;
	}

	public PolicyHDR checkActivePolicy(String iqamaId, String vehId) {
		_log.info("Checking Active policies for :" + iqamaId + " and veh Id: " + vehId);

		long sTime1 = System.currentTimeMillis();
		List<PolicyHDR> allPoliciesList = PolicyHDRLocalServiceUtil.findByIqamaId(iqamaId, 0, 0);
		long period1 = System.currentTimeMillis() - sTime1;
		_log.info("PolicyHDRLocalServiceUtil.findByIqamaId took " + period1 + " ms");

		if (allPoliciesList != null && !allPoliciesList.isEmpty()) {
			Date currDate = new Date();

			long sTime = System.currentTimeMillis();

			for (PolicyHDR policy : allPoliciesList) {
				if (policy.getExpiryDate() != null && policy.getExpiryDate().compareTo(currDate) > 0) {
					_log.info("Active Policy with expiry date " + policy.getExpiryDate());
					_log.info("checkActivePolicy-findByPolicyNumberVehicleCustomNo for policy:" + policy.getPolicyNo()
							+ "...Vehicle Id:" + vehId);

					List<PolicyVEH> pVehs = PolicyVEHLocalServiceUtil
							.findByPolicyNumberVehicleCustomNo(policy.getPolicyNo(), vehId);

					if (pVehs != null) {
						_log.info("pVehs count:" + pVehs.size());

						if (pVehs.size() > 0) {
							// PolicyVEH pVeh = PolicyVehLocalServiceUtil.fetchPolicyVeh(PolicyVehPK);
							PolicyVEH pVeh = pVehs.get(0);

							if (pVeh != null) {
								_log.info("Active Policy Found for vehicle sequence" + vehId);

								Calendar cal = new GregorianCalendar();
								cal.setTime(new Date());

								Calendar expCal = new GregorianCalendar();
								expCal.setTime(policy.getExpiryDate());

								_log.info("Comparing date with now");
								_log.info(cal.getTime());
								_log.info(expCal.getTime());

								long diff = policy.getExpiryDate().getTime() - currDate.getTime();
								long diffDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

								_log.info("Difference in days is:" + diffDays);

								if (diffDays > 30) {
									_log.info("Returning active policy " + policy.getPolicyNo());
									return policy;
								}
							}

						}
					}
				}
			}

			long period = System.currentTimeMillis() - sTime;
			_log.info("Looping took " + period + " ms");
		}

		long period2 = System.currentTimeMillis() - sTime1;
		_log.info("total checkActivePolicy took " + period2 + " ms");
		return null;
	}

	public byte[] findCustuploadsVehRight(long id) {
		CustUploadsCarRightFileBlobModel carRight = CustUploadsLocalServiceUtil.getCarRightFileBlobModel(id);
		byte[] carRightFile;
		try {
			carRightFile = carRight.getCarRightFileBlob().getBytes(1, (int) carRight.getCarRightFileBlob().length());
			return carRightFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public byte[] findCustuploadsVehBack(long id) {
		CustUploadsCarBackFileBlobModel carBack = CustUploadsLocalServiceUtil.getCarBackFileBlobModel(id);
		byte[] carBackFile;
		try {
			carBackFile = carBack.getCarBackFileBlob().getBytes(1, (int) carBack.getCarBackFileBlob().length());
			return carBackFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public byte[] findCustuploadsVehFront(long id) {
		CustUploadsCarFrontFileBlobModel carFront = CustUploadsLocalServiceUtil.getCarFrontFileBlobModel(id);
		byte[] carFrontFile;
		try {
			carFrontFile = carFront.getCarFrontFileBlob().getBytes(1, (int) carFront.getCarFrontFileBlob().length());
			return carFrontFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public byte[] findCustuploadsVehLeft(long id) {
		CustUploadsCarLeftFileBlobModel carLeft = CustUploadsLocalServiceUtil.getCarLeftFileBlobModel(id);
		byte[] carLeftFile;
		try {
			carLeftFile = carLeft.getCarLeftFileBlob().getBytes(1, (int) carLeft.getCarLeftFileBlob().length());
			return carLeftFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public byte[] findInsuredRelationProof(long addDriverId) {
		QuotationDriversInsuredRelationProofBlobModel insuredRelationProof = QuotationDriversLocalServiceUtil
				.getInsuredRelationProofBlobModel(addDriverId);
		byte[] insuredRelationProofFile;
		try {
			insuredRelationProofFile = insuredRelationProof.getInsuredRelationProofBlob().getBytes(1,
					(int) insuredRelationProof.getInsuredRelationProofBlob().length());
			return insuredRelationProofFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public byte[] findCustuploadsChassisNo(long id) {
		CustUploadsEngChassisNoFileBlobModel ChassisNo = CustUploadsLocalServiceUtil.getEngChassisNoFileBlobModel(id);
		byte[] ChassisNoFile;
		try {
			ChassisNoFile = ChassisNo.getEngChassisNoFileBlob().getBytes(1,
					(int) ChassisNo.getEngChassisNoFileBlob().length());
			return ChassisNoFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public byte[] findCustuploadsIstCardFile(long id) {
		CustUploadsIstCardFileBlobModel istCardNo = CustUploadsLocalServiceUtil.getIstCardFileBlobModel(id);
		byte[] isstCardNoFile;
		try {
			isstCardNoFile = istCardNo.getIstCardFileBlob().getBytes(1, (int) istCardNo.getIstCardFileBlob().length());
			return isstCardNoFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public byte[] findCustuploadsLeaseFile(long id) {
		CustUploadsLeaseFileBlobModel lease = CustUploadsLocalServiceUtil.getLeaseFileBlobModel(id);
		byte[] leaseFile;
		try {
			leaseFile = lease.getLeaseFileBlob().getBytes(1, (int) lease.getLeaseFileBlob().length());
			return leaseFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public List<QuotationSurvey> findQuotationSurveyVideo(String quoteID) {
		List<QuotationSurvey> videoList = QuotationSurveyUtil.findByquotationId(quoteID);

		return videoList;
	}

	public int countQuotationSurveyVideo(String quoteID) {
		int countVideos = QuotationSurveyUtil.countByquotationId(quoteID);
		return countVideos;
	}

	public byte[] findQuotationSurveyFile(long id) {
		QuotationSurveySurveyVideoFileBlobModel file = QuotationSurveyLocalServiceUtil.getSurveyVideoFileBlobModel(id);
		byte[] surveyFile;
		try {
			surveyFile = file.getSurveyVideoFileBlob().getBytes(1, (int) file.getSurveyVideoFileBlob().length());
			return surveyFile;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public boolean saveQuotSurvey(String quotationId, byte[] surveyVideo, String name, Date date) {
		try {
			QuotationSurvey qoutSurvey = QuotationSurveyLocalServiceUtil
					.createQuotationSurvey((long) CounterLocalServiceUtil.increment());
			qoutSurvey.setQuotationId(quotationId);
			Blob surveyVideoFile;
			surveyVideoFile = new javax.sql.rowset.serial.SerialBlob(surveyVideo);
			qoutSurvey.setSurveyVideoFile(surveyVideoFile);
			qoutSurvey.setSurveyVideoFileName(name);
			qoutSurvey.setSurveyDate(date);
			QuotationSurveyLocalServiceUtil.updateQuotationSurvey(qoutSurvey);

			List<Quotations> quoteList = QuotationsLocalServiceUtil.findByReferenceNo(quotationId);
			if (quoteList != null && !quoteList.isEmpty()) {
				quoteList.get(0).setQuoteStatus("PSA");
				QuotationsLocalServiceUtil.updateQuotations(quoteList.get(0));
			}

			return true;
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (NoSuchQuotationsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public File downloadQuotDetsReport(String quoteId, String lang) throws Exception {
		Quotation quot = getQuotationByQuotationId(Long.valueOf(quoteId));
		quot = getQuotationDetails(quot);

		String fileName = "";
		if (lang.equals("en")) {
			fileName = "quote_dets";
		} else {
			fileName = "quote_dets_ar";
		}
		Map<String, Object> paramsMap = getQuoteDetailsReportParams(lang, quot);

		if (quot.getExistingCompanyName() != null) {
			List<CustomerMapDetails> existComps = getInsuranceCompany(quot.getExistingCompanyName());
			String existCoNameVal = "";
			if (existComps != null && !existComps.isEmpty())
				existCoNameVal = existComps.get(0).getName();

			paramsMap.put("existCoNameVal", existCoNameVal);
		}

		List ds = new ArrayList<>();
		ds.add(quot);
		File directory = new File(PropsUtil.get("com.ejada.atmc.quote.report.path"));
		if (!directory.exists()) {
			directory.mkdirs();
		}

		File qFile = new File(
				PropsUtil.get("com.ejada.atmc.quote.report.path") + "/quotation_" + quot.getReferenceNo() + ".pdf");
		if (!qFile.exists())
			qFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(qFile);
		ReportsUtil.fillAndExportPDFReport(fileName + ".jasper", ds, paramsMap, fos);

		return qFile;
	}

	public File downloadPolicyReport(String quoteId, String policyNo, String lang) throws Exception {
		List ds = new ArrayList<>();
		Map<String, Object> paramsMap = new HashMap<>();
		Locale locale = (lang.equals("en")) ? new Locale(lang, "US") : new Locale(lang, "SA");
		String fileName = "";
		String reportName = "";

		Quotation quot = getQuotationByQuotationId(Long.valueOf(quoteId));
		// quot = QuotationLocalServiceUtil.getQuotationDetails(quot);
		Policy policy = new Policy();// PolicyLocalServiceUtil.findPolicyByPolicyNo(policyNo);
		policy.setPolicyNo(policyNo);
		policy.setInsuredName(quot.getInsuredName());
		policy.setInsuredId("" + quot.getInsuredId());
		policy.setInceptionDate(quot.getPolicyEffDate());
		policy.setExpiryDate(quot.getPolicyEffTo());

		PolicyVehicle pVeh = new PolicyVehicle();
		pVeh.setBodyTypeAr(quot.getVehicleBodyTypeAr());
		pVeh.setBodyTypeEn(quot.getVehicleBodyTypeEn());
		pVeh.setArPlateNo("" + quot.getVehiclePlateNo());
		pVeh.setArPlateL1(quot.getVehiclePlateL1());
		pVeh.setArPlateL2(quot.getVehiclePlateL2());
		pVeh.setArPlateL3(quot.getVehiclePlateL3());
		pVeh.setEnPlateL1(quot.getVehiclePlateL1());
		pVeh.setEnPlateL2(quot.getVehiclePlateL2());
		pVeh.setEnPlateL3(quot.getVehiclePlateL3());
		pVeh.setVehId("" + quot.getVehicleId());
		pVeh.setMfgYear(quot.getVehicleMfgYear());
		pVeh.setChassisNo(quot.getVehicleChassisNo());

		List<PolicyVehicle> pVehs = new ArrayList<>();
		pVehs.add(pVeh);
		policy.setPolicyVehs(pVehs);

		String productType = quot.getProductCode();

		paramsMap.put("pVeh", pVeh);
		paramsMap.put("pType", productType);
		paramsMap.put("page_no", LanguageUtil.get(locale, "page_no"));

		fileName = "policy_certificate";
		reportName = fileName + "_" + productType;

		ds.add(policy);
		File directory = new File(PropsUtil.get("com.ejada.atmc.quote.report.path"));
		if (!directory.exists()) {
			directory.mkdirs();
		}

		File pFile = new File(PropsUtil.get("com.ejada.atmc.quote.report.path") + "/" + reportName + ".pdf");
		if (!pFile.exists())
			pFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(pFile);
		ReportsUtil.fillAndExportPDFReport(fileName + ".jasper", ds, paramsMap, fos);

		return pFile;
	}

	public Map<String, Object> getQuoteDetailsReportParams(String lang, Quotation quot) {
		Map<String, Object> paramsMap = new HashMap<>();
		Locale locale = (lang.equals("en")) ? new Locale(lang, "US") : new Locale(lang, "SA");
		paramsMap.put("cover_type",
				(quot.getProductCode().equals(PRODUCT_CODE_COMPREHENSIVE)) ? LanguageUtil.get(locale, "comp_product")
						: LanguageUtil.get(locale, "tpl_product"));
		paramsMap.put("quot_no", LanguageUtil.get(locale, "quote_no"));
		paramsMap.put("veh_make_val", (lang.equals("en")) ? quot.getVehicleMakeEn() : quot.getVehicleMakeAr());
		paramsMap.put("veh_model_val", (lang.equals("en")) ? quot.getVehicleModelEn() : quot.getVehicleModelAr());
		paramsMap.put("from", LanguageUtil.get(locale, "from"));
		paramsMap.put("to", LanguageUtil.get(locale, "to"));

		Date fromDate = quot.getQuoteSubmissionDate() != null ? quot.getQuoteSubmissionDate() : new Date();

		Calendar cal = new GregorianCalendar();
		cal.setTime(fromDate);
		cal.add(Calendar.DAY_OF_YEAR, 3);
		Date effToDate = cal.getTime();

		paramsMap.put("from_val", dateFormatter.format(fromDate));
		paramsMap.put("to_val", dateFormatter.format(effToDate));

		paramsMap.put("page_no", LanguageUtil.get(locale, "page_no"));
		paramsMap.put("owner_dets", LanguageUtil.get(locale, "owner_dets"));
		paramsMap.put("ist_card", LanguageUtil.get(locale, "ist_card"));
		paramsMap.put("ins_type", LanguageUtil.get(locale, "ins_type"));
		paramsMap.put("iqama_no", LanguageUtil.get(locale, "iqama_no"));
		paramsMap.put("driver_dob", LanguageUtil.get(locale, "driver_dob"));
		paramsMap.put("email", LanguageUtil.get(locale, "email"));
		paramsMap.put("mob_no", LanguageUtil.get(locale, "mob_no"));
		paramsMap.put("add_driver", LanguageUtil.get(locale, "add_driver"));
		paramsMap.put("veh_owner", LanguageUtil.get(locale, "veh_owner"));
		paramsMap.put("driver_iqama_id", LanguageUtil.get(locale, "driver_iqama_id"));
		paramsMap.put("age", LanguageUtil.get(locale, "age"));
		paramsMap.put("veh_det", LanguageUtil.get(locale, "veh_det"));
		paramsMap.put("make", LanguageUtil.get(locale, "make"));
		paramsMap.put("mod_ver", LanguageUtil.get(locale, "mod_ver"));
		paramsMap.put("body_type", LanguageUtil.get(locale, "body_type"));
		paramsMap.put("year_make", LanguageUtil.get(locale, "year_make"));
		paramsMap.put("plate_no", LanguageUtil.get(locale, "plate_no"));
		paramsMap.put("veh_use", LanguageUtil.get(locale, "veh_use"));
		paramsMap.put("chassis_no", LanguageUtil.get(locale, "chassis_no_report"));
		paramsMap.put("seq_no", LanguageUtil.get(locale, "seq_no"));
		paramsMap.put("add_ben", LanguageUtil.get(locale, "add_ben"));
		paramsMap.put("pmnt_dets", LanguageUtil.get(locale, "pmnt_dets"));
		paramsMap.put("premium", LanguageUtil.get(locale, "premium"));
		paramsMap.put("val_veh_rate", LanguageUtil.get(locale, "val_veh_rate"));
		paramsMap.put("no_claim", LanguageUtil.get(locale, "no_claim"));
		paramsMap.put("discount_rate", LanguageUtil.get(locale, "discount_rate"));
		paramsMap.put("policy_tax", LanguageUtil.get(locale, "policy_tax"));
		paramsMap.put("quot_valid_until", LanguageUtil.get(locale, "quot_valid_until"));
		paramsMap.put("quot_ind_veh_ins_pol", LanguageUtil.get(locale, "quot_ind_veh_ins_pol"));
		paramsMap.put("company_name", LanguageUtil.get(locale, "company_name_report"));
		paramsMap.put("quot_issue_name", LanguageUtil.get(locale, "quot_issue_name"));
		paramsMap.put("online", LanguageUtil.get(locale, "online"));
		paramsMap.put("issue_date", LanguageUtil.get(locale, "issue_date"));
		paramsMap.put("job_no", LanguageUtil.get(locale, "job_no"));
		paramsMap.put("city", LanguageUtil.get(locale, "city"));
		paramsMap.put("veh_owner_det", LanguageUtil.get(locale, "veh_owner_det"));
		paramsMap.put("veh_data", LanguageUtil.get(locale, "veh_data"));
		paramsMap.put("client_name", LanguageUtil.get(locale, "client_name"));
		paramsMap.put("id_number", LanguageUtil.get(locale, "id_number"));
		paramsMap.put("birth_date", LanguageUtil.get(locale, "birth_date"));
		paramsMap.put("gender", LanguageUtil.get(locale, "gender"));
		paramsMap.put("prof", LanguageUtil.get(locale, "prof"));
		paramsMap.put("resid_id", LanguageUtil.get(locale, "resid_id"));
		paramsMap.put("nat_addr", LanguageUtil.get(locale, "nat_addr"));
		paramsMap.put("iban", LanguageUtil.get(locale, "iban"));
		paramsMap.put("bank_name", LanguageUtil.get(locale, "bank_name"));
		paramsMap.put("veh_type_model", LanguageUtil.get(locale, "veh_type_model"));
		paramsMap.put("cityVal", quot.getCityDesc());
		paramsMap.put("veh_color", LanguageUtil.get(locale, "veh_color"));
		paramsMap.put("ser_cust_no", LanguageUtil.get(locale, "ser_cust_no"));
		paramsMap.put("reg_type", LanguageUtil.get(locale, "reg_type"));
		paramsMap.put("use_type", LanguageUtil.get(locale, "use_type"));
		paramsMap.put("mnf_year", LanguageUtil.get(locale, "mnf_year"));
		paramsMap.put("curr_ins", LanguageUtil.get(locale, "curr_ins"));
		paramsMap.put("policy_no", LanguageUtil.get(locale, "policy_no"));
		paramsMap.put("exp_date", LanguageUtil.get(locale, "exp_date"));
		paramsMap.put("drv_data", LanguageUtil.get(locale, "drv_data"));
		paramsMap.put("driver_name", LanguageUtil.get(locale, "driver_name"));
		paramsMap.put("tpl_civ_ins", LanguageUtil.get(locale, "tpl_civ_ins"));
		paramsMap.put("cov_driver_under_age", LanguageUtil.get(locale, "cov_driver_under_age"));
		paramsMap.put("ins_ins_veh", LanguageUtil.get(locale, "ins_ins_veh"));
		paramsMap.put("ins_agnst_othrs", LanguageUtil.get(locale, "ins_agnst_othrs"));
		paramsMap.put("price", LanguageUtil.get(locale, "price"));
		paramsMap.put("comp", LanguageUtil.get(locale, "comp"));
		paramsMap.put("ins_val", LanguageUtil.get(locale, "ins_val"));
		paramsMap.put("ded_amnt", LanguageUtil.get(locale, "ded_amnt"));
		paramsMap.put("max_comp_tot_loss", LanguageUtil.get(locale, "max_comp_tot_loss"));
		paramsMap.put("ded_amount_inc", LanguageUtil.get(locale, "ded_amount_inc"));
		paramsMap.put("add_opts", LanguageUtil.get(locale, "add_opts"));
		paramsMap.put("agency_repair", LanguageUtil.get(locale, "agency_repair"));
		paramsMap.put("prov_repl_veh", LanguageUtil.get(locale, "prov_repl_veh"));
		paramsMap.put("saeed_serv", LanguageUtil.get(locale, "saeed_serv"));
		paramsMap.put("drv_pers_accid", LanguageUtil.get(locale, "drv_pers_accid"));
		paramsMap.put("pass_pers_accid", LanguageUtil.get(locale, "pass_pers_accid"));
		paramsMap.put("admin_fees", LanguageUtil.get(locale, "admin_fees"));
		paramsMap.put("commission", LanguageUtil.get(locale, "commission"));
		paramsMap.put("vat", LanguageUtil.get(locale, "vat"));
		paramsMap.put("absc_claims", LanguageUtil.get(locale, "absc_claims"));
		paramsMap.put("loyalty", LanguageUtil.get(locale, "loyalty"));
		paramsMap.put("exp_add_ded", LanguageUtil.get(locale, "exp_add_ded"));
		paramsMap.put("tot_bf_disc", LanguageUtil.get(locale, "tot_bf_disc"));
		paramsMap.put("tot_after_ded", LanguageUtil.get(locale, "tot_after_ded"));
		paramsMap.put("avail_choices", LanguageUtil.get(locale, "avail_choices"));
		paramsMap.put("exp_geoc_scope", LanguageUtil.get(locale, "exp_geoc_scope"));
		paramsMap.put("count_counts", LanguageUtil.get(locale, "count_counts"));
		paramsMap.put("non_app_dep_cond", LanguageUtil.get(locale, "non_app_dep_cond"));
		paramsMap.put("not_wish_insure", LanguageUtil.get(locale, "not_wish_insure"));
		paramsMap.put("ack_read_quot", LanguageUtil.get(locale, "ack_read_quot"));
		paramsMap.put("client_name", LanguageUtil.get(locale, "client_name"));
		paramsMap.put("signature", LanguageUtil.get(locale, "signature"));
		paramsMap.put("date_time", LanguageUtil.get(locale, "date_time"));
		paramsMap.put("disc_due", LanguageUtil.get(locale, "disc_due"));
		paramsMap.put("quot", LanguageUtil.get(locale, "quot"));

		// paramsMap.put("rentCar", 0.0);

		double driverAccids = 0.0;
		double passAccids = 0.0;
		double rentCar = 0.0;
		double totalCovers = 0.0;
		if (quot.getCoversList() != null && !quot.getCoversList().isEmpty()) {
			for (QuotationCover qCover : quot.getCoversList()) {
				if (qCover.getCoverCode() != null && qCover.getCoverCode().equals("131002"))
					driverAccids = qCover.getCoverPrem();
				else if (qCover.getCoverCode() != null && qCover.getCoverCode().equals("131004"))
					passAccids = qCover.getCoverPrem();
				else if (qCover.getCoverCode() != null && qCover.getCoverCode().equals("131014"))
					rentCar = qCover.getCoverPrem();
				if (qCover.getCoverCode() != null && qCover.getCoverCode().equals("31052")) {
					paramsMap.put("geoCover", qCover.getCoverPrem());
				}
				totalCovers += qCover.getCoverPrem();
			}
		}

		CodeMasterMap vehColorMap = CodeMasterMapLocalServiceUtil.findBySourceTypeCoreCode(ODS_SRC_TYPE_COLOR,
				quot.getVehicleColor());
		try {
			quot.setVehicleColorEn(vehColorMap.getCoreDesc());
			quot.setVehicleColorAr(vehColorMap.getCoreDesc());
		} catch (Exception e) {
			e.printStackTrace();
		}

		_log.debug(" --------------- SAMA Report - totalCovers = " + totalCovers + " --------------- ");
		paramsMap.put("driverAccids", driverAccids);
		paramsMap.put("passAccids", passAccids);
		paramsMap.put("rentCar", rentCar);
		paramsMap.put("totalCovers", totalCovers);

		return paramsMap;
	}

	public List<Quotations> getQuotsByQuoteStatus(String quoteStatus) {
		try {
			return QuotationsLocalServiceUtil.findByQuoteStatus(quoteStatus);
		} catch (NoSuchQuotationsException e) {
			_log.error(e.getMessage(), e);
		}
		return null;
	}
}