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

import com.atmc.bsl.db.domain.ReturnCodes;
import com.atmc.bsl.db.domain.ServiceOutput;
import com.atmc.bsl.db.domain.codemaster.CodeMasterDetails;
import com.atmc.bsl.db.domain.policy.Policy;
import com.atmc.bsl.db.domain.policy.PolicyVehicle;
import com.atmc.bsl.db.domain.quotation.CustomerMapDetails;
import com.atmc.bsl.db.domain.quotation.Quotation;
import com.atmc.bsl.db.domain.quotation.QuotationCover;
import com.atmc.bsl.db.domain.quotation.QuotationDriver;
import com.atmc.bsl.db.domain.quotation.QuotationDriverLicense;
import com.atmc.bsl.db.domain.quotation.QuotationUserAddress;
import com.atmc.bsl.db.exception.NajmException;
import com.atmc.bsl.db.exception.YaqeenException;
import com.atmc.bsl.db.service.CustomerVehicleDetailsLocalServiceUtil;
import com.atmc.bsl.db.service.GsonUtilsLocalServiceUtil;
import com.atmc.bsl.db.service.QuotationLocalServiceUtil;
import com.atmc.bsl.db.service.base.QuotationServiceBaseImpl;
import com.ejada.atmc.acl.db.domain.tariff.TariffInput;
import com.ejada.atmc.acl.db.domain.tariff.TariffOutput;
import com.ejada.atmc.acl.db.model.CodeMasterMap;
import com.ejada.atmc.acl.db.model.PolicyHDR;
import com.ejada.atmc.acl.db.service.CodeMasterMapLocalServiceUtil;
import com.ejada.atmc.acl.db.service.TariffLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.io.ByteArrayFileInputStream;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.access.control.AccessControlUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.springframework.util.FileCopyUtils;

/**
 * The implementation of the quotation remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.QuotationService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=dbbsl",
		"json.web.service.context.path=Quotation" }, service = AopService.class)
public class QuotationServiceImpl extends QuotationServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.atmc.bsl.db.service.QuotationServiceUtil} to access the quotation
	 * remote service.
	 */
	public static final String YAKEEN_INSURED_GENDER_MALE = "M";
	public static final String YAKEEN_INSURED_GENDER_FEMALE = "F";
	public static final int INSURED_GENDER_MALE = 1;
	public static final int INSURED_GENDER_FEMALE = 2;
	public static final String PRODUCT_CODE_COMPREHENSIVE = "OD";
	public static final String PRODUCT_CODE_TPL = "TP";
	public static final int TARIFF_QUICKQUOTE_COLOR = 25244;

	private static final Log _log = LogFactoryUtil.getLog(QuotationServiceImpl.class);

	public ServiceOutput<List<CodeMasterDetails>> getCountries() {
		ServiceOutput<List<CodeMasterDetails>> svcOutput = new ServiceOutput<List<CodeMasterDetails>>();
		List<CodeMasterDetails> countriesList = QuotationLocalServiceUtil.getCountries();

		if (countriesList != null && !countriesList.isEmpty()) {
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(countriesList);
		} else
			svcOutput.setOutputCode(ReturnCodes.FAIL);

		return svcOutput;
	}

	public ServiceOutput<List<CodeMasterDetails>> getCities() {
		ServiceOutput<List<CodeMasterDetails>> svcOutput = new ServiceOutput<List<CodeMasterDetails>>();
		List<CodeMasterDetails> citiesList = QuotationLocalServiceUtil.getCities();

		if (citiesList != null && !citiesList.isEmpty()) {
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(citiesList);
		} else
			svcOutput.setOutputCode(ReturnCodes.FAIL);

		return svcOutput;
	}

	public ServiceOutput<List<CodeMasterDetails>> getParkingLocations() {
		ServiceOutput<List<CodeMasterDetails>> svcOutput = new ServiceOutput<List<CodeMasterDetails>>();
		List<CodeMasterDetails> locationsList = QuotationLocalServiceUtil.getParkingLocations();

		if (locationsList != null && !locationsList.isEmpty()) {
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(locationsList);
		} else
			svcOutput.setOutputCode(ReturnCodes.FAIL);

		return svcOutput;
	}

	public ServiceOutput<List<CodeMasterDetails>> getEngineSizes() {
		ServiceOutput<List<CodeMasterDetails>> svcOutput = new ServiceOutput<List<CodeMasterDetails>>();
		List<CodeMasterDetails> enginesList = QuotationLocalServiceUtil.geEngineSizes();

		if (enginesList != null && !enginesList.isEmpty()) {
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(enginesList);
		} else
			svcOutput.setOutputCode(ReturnCodes.FAIL);

		return svcOutput;
	}

	public ServiceOutput<List<CodeMasterDetails>> getDeductibleValues() {
		ServiceOutput<List<CodeMasterDetails>> svcOutput = new ServiceOutput<List<CodeMasterDetails>>();
		List<CodeMasterDetails> deductsList = QuotationLocalServiceUtil.getDeductibleValues();

		if (deductsList != null && !deductsList.isEmpty()) {
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(deductsList);
		} else
			svcOutput.setOutputCode(ReturnCodes.FAIL);

		return svcOutput;
	}

	public ServiceOutput<List<CodeMasterDetails>> getPurposeOfVehicle() {
		ServiceOutput<List<CodeMasterDetails>> svcOutput = new ServiceOutput<List<CodeMasterDetails>>();
		List<CodeMasterDetails> pVehsList = QuotationLocalServiceUtil.getPurposeOfVehicle();

		if (pVehsList != null && !pVehsList.isEmpty()) {
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(pVehsList);
		} else
			svcOutput.setOutputCode(ReturnCodes.FAIL);

		return svcOutput;
	}

	public ServiceOutput<List<CustomerMapDetails>> getInsuranceCompanies() {
		ServiceOutput<List<CustomerMapDetails>> svcOutput = new ServiceOutput<List<CustomerMapDetails>>();
		List<CustomerMapDetails> companiesList = QuotationLocalServiceUtil.getInsuranceCompanies();

		if (companiesList != null && !companiesList.isEmpty()) {
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(companiesList);
		} else
			svcOutput.setOutputCode(ReturnCodes.FAIL);

		return svcOutput;
	}

	@JSONWebService(value = "personal-info", method = "POST")
	public ServiceOutput<Quotation> personalInfo(Quotation quot, boolean isUserSignedIn) {
		ServiceOutput<Quotation> svcOutput = new ServiceOutput<Quotation>();
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(AccessControlUtil.getAccessControlContext().getRequest());
		try {
			if (!isUserSignedIn
					&& quot.getVehicleIdType() == Long.valueOf(QuotationLocalServiceImpl.VEHICLE_ISTIMARA_CARD)) {
				long checkPolicyResult = QuotationLocalServiceUtil.checkExistingPolicy("" + quot.getInsuredId(),
						"" + quot.getVehicleId());
				if (checkPolicyResult == QuotationLocalServiceImpl.RENEWABLE_POLICY_EXISTS) {
					Company company = null;
					try {
						company = PortalUtil.getCompany(httpRequest);
					} catch (PortalException e) {
						e.printStackTrace();
					}
					User user = UserLocalServiceUtil.fetchUserByScreenName(company.getCompanyId(),
							"" + quot.getInsuredId());
					if (user != null) {
						svcOutput.setOutputCode(ReturnCodes.RENEWABLE_POLICY_EXISTS_LOGIN_ERROR + ":"
								+ LanguageUtil.get(httpRequest, "ren_policy_exists_login"));
					} else {
						svcOutput.setOutputCode(ReturnCodes.RENEWABLE_POLICY_EXISTS_REG_ERROR + ":"
								+ LanguageUtil.get(httpRequest, "ren_policy_exists_reg"));
					}
					svcOutput.setOutputObject(quot);
					return svcOutput;
				} else if (checkPolicyResult == 0) {
					PolicyHDR activePolicy = QuotationLocalServiceUtil.checkActivePolicy("" + quot.getInsuredId(),
							"" + quot.getVehicleId());
					if (activePolicy != null) {

						Calendar expCal = new GregorianCalendar();
						expCal.setTime(activePolicy.getExpiryDate());
						expCal.add(Calendar.DAY_OF_YEAR, -30);
						SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM dd, yyyy");

						svcOutput.setOutputCode(ReturnCodes.POLICY_EXISTS_ERROR + ":"
								+ LanguageUtil.get(httpRequest, "non_exp_policy_err") + " <b>"
								+ dateFormatter.format(expCal.getTime()) + "</b>.");
						svcOutput.setOutputObject(quot);
						return svcOutput;
					}
				}
			}

			quot = CustomerVehicleDetailsLocalServiceUtil.getCustomerVehicleDetailsMob(quot, "E",
					new Locale("en", "US"));

			long vehMfgYear = quot.getVehicleMfgYear();
			Calendar cal = new GregorianCalendar();
			cal.setTime(new Date());
			int currentYear = cal.get(Calendar.YEAR);

			if (currentYear > vehMfgYear && (currentYear - vehMfgYear >= 10)) {
				svcOutput.setOutputObject(quot);
				svcOutput.setOutputCode(ReturnCodes.YAQEEN_ERROR_VEH_AGE_OLD);
				return svcOutput;
			}

			svcOutput.setOutputObject(quot);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
		} catch (YaqeenException e) {
			svcOutput.setOutputObject(quot);
			svcOutput.setOutputCode("YAQEEN_MESSAGE:" + e.getMessage());
		} catch (NajmException e) {
			svcOutput.setOutputObject(quot);
			svcOutput.setOutputCode("YAQEEN_MESSAGE:" + e.getMessage());
		}
		return svcOutput;
	}

	public ServiceOutput<List<Quotation>> getPendingQuotations(String iqamaId) {
		ServiceOutput<List<Quotation>> srvOutput = new ServiceOutput<List<Quotation>>();
		try {
			List<Quotation> pendingQuots = QuotationLocalServiceUtil
					.getPendingPaymentSurveyQuotations(Long.valueOf(iqamaId));
			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
			srvOutput.setOutputObject(pendingQuots);
		} catch (Exception e) {
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;
	}

	@JSONWebService(value = "upload-quote-file", method = "POST")
	public ServiceOutput<Boolean> uploadQuoteFile(File attachFile, String fileName, String insuredId) {
		_log.info("Uploading file from mobile");

		ServiceOutput<Boolean> srvOutput = new ServiceOutput<Boolean>();

		HashSet<String> acceptedTypes = new HashSet<>();
		acceptedTypes.add("application/pdf");
		acceptedTypes.add("image/png");
		acceptedTypes.add("image/jpg");
		acceptedTypes.add("image/jpeg");

		try {
			if (attachFile == null || !attachFile.exists()) {
				_log.info("File is Empty");
			} else if ((attachFile != null) && attachFile.exists()) {
				_log.info("We have File to upload");
				_log.info("File Name:" + attachFile.getName());
				_log.info("File Length:" + attachFile.length());

				boolean isFileTypeAccepted = com.ejada.atmc.utils.api.FileUtil.isAcceptedFileType(attachFile,
						acceptedTypes);
				boolean isFileExecutable = com.ejada.atmc.utils.api.FileUtil.isExecutable(attachFile);

				if (isFileTypeAccepted && !isFileExecutable) {
					String uploadDir = PropsUtil.get("policy.upload.dir");
					File destFolder = new File(uploadDir + "/" + insuredId);
					if (!destFolder.exists())
						destFolder.mkdirs();

					ByteArrayFileInputStream inputStream = new ByteArrayFileInputStream(attachFile, 1024);

					byte[] idData = FileUtil.getBytes(inputStream);

					FileOutputStream out = new FileOutputStream(uploadDir + "/" + insuredId + "/" + fileName);
					out.write(idData);
					out.close();
				}
			}

			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
		} catch (IOException e) {
			e.printStackTrace();
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;
	}

	public ServiceOutput<Boolean> uploadVideo(String baseArray, String fileName, String quotationId, Date videoDate) {
		_log.info("inUploadSrv");
		_log.info("fileName" + fileName);
		_log.info("quotationId" + quotationId);
		ServiceOutput<Boolean> srvOutput = new ServiceOutput<Boolean>();
		// ByteArrayFileInputStream inputStream = new
		// ByteArrayFileInputStream(attachFile, 1024);
		// make([]byte, base64.StdEncoding.EncodedLen(len(data)))
		byte[] idData = org.apache.commons.codec.binary.Base64.decodeBase64(baseArray);
		boolean succUploadFlag = QuotationLocalServiceUtil.saveQuotSurvey(quotationId, idData, fileName, videoDate);
//			FileOutputStream out = new FileOutputStream(uploadDir+fileName);
//			out.write(idData);
//			out.close();
//			
		srvOutput.setOutputCode(ReturnCodes.SUCCESS);
		srvOutput.setOutputObject(succUploadFlag);
		return srvOutput;
	}

	public ServiceOutput<Boolean> clearQuoteFile(String fileName, String insuredId) {
		ServiceOutput<Boolean> srvOutput = new ServiceOutput<Boolean>();
		String uploadDir = PropsUtil.get("policy.upload.dir") + "/" + insuredId + "/" + fileName;

		File qFile = new File(uploadDir);
		if (qFile.exists())
			qFile.delete();

		srvOutput.setOutputCode(ReturnCodes.SUCCESS);
		return srvOutput;
	}

	public ServiceOutput<TariffOutput> getTariffData(TariffInput tariffInput) throws PortalException {
		ServiceOutput<TariffOutput> srvOutput = new ServiceOutput<TariffOutput>();
		try {
			ArrayList<TariffOutput> output = TariffLocalServiceUtil.getTariffData(tariffInput);
			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
			// srvOutput.setOutputObject(output);
		} catch (Exception e) {
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;
	}

	public ServiceOutput<CodeMasterMap> getBySourceTypeSourceCode(String sourceType, String sourceCode)
			throws PortalException {
		ServiceOutput<CodeMasterMap> srvOutput = new ServiceOutput<CodeMasterMap>();
		try {
			CodeMasterMap codeMasterObject = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode(sourceType,
					sourceCode);
			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
			srvOutput.setOutputObject(codeMasterObject);
		} catch (Exception e) {
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;
	}

	public ServiceOutput<List<QuotationCover>> getCoverList(String productCode) {
		ServiceOutput<List<QuotationCover>> srvOutput = new ServiceOutput<List<QuotationCover>>();
		try {
			List<QuotationCover> coversList = QuotationLocalServiceUtil.getCoverList(productCode);
			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
			srvOutput.setOutputObject(coversList);
		} catch (Exception e) {
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;
	}

//	@JSONWebService(value = "submit-quotation", method = "POST")
//	public ServiceOutput<Quotation> submitQuotation(Quotation quot, List<QuotationDriver> drivers,
//			List<QuotationCover> coversList, boolean isUserSignedIn, String lang, List driverNatAddrs,
//			List driverOffAddrs) {
//		_log.info("JSON submitQuotation fn -- Start");
//		ServiceOutput<Quotation> svcOutput = new ServiceOutput<Quotation>();
//		try {
//			if (coversList != null && !coversList.isEmpty()) {
//				for (QuotationCover cover : coversList) {
//					if (cover.getMonths() != null && !cover.getMonths().equals("")) {
//						int coverMonths = Integer.valueOf(cover.getMonths());
//						cover.setCoverPrem(coverMonths * cover.getCoverPrem());
//
//						Date policyEffDate = quot.getPolicyEffDate();
//						Calendar coverCal = new GregorianCalendar();
//						coverCal.setTime(policyEffDate);
//						coverCal.add(Calendar.MONTH, coverMonths);
//						if (quot.getPolicyEffDate() != null)
//							cover.setCoverEffFromDate(quot.getPolicyEffDate());
//						// Incase of GEO extension covers '31051' or '31052', cover eff to date is
//						// policy eff date plus selected months
//						if (cover.getCoverCode() != null
//								&& (cover.getCoverCode().equals("31051") || cover.getCoverCode().equals("31052")))
//							cover.setCoverEffToDate(coverCal.getTime());
//						else
//							cover.setCoverEffToDate(quot.getPolicyEffTo());
//
//						// GS: TT defect #382 - COVER_RATE in case of PAB (Driver + Passenger) should
//						// contain the no of passengers
//						if (cover.getCoverCode() != null && cover.getCoverCode().equals("131004"))
//							cover.setCoverRate(coverMonths);
//					}
//				}
//			}
//
//			quot.setCoversList(coversList);
//			quot.getQuotationDrivers().clear();
//			quot.setQuotationDrivers(drivers);
//
//			// Workaround, the QuotationDriverLicense are comming as List<HashMap> instead
//			// of List<QuotationDriverLicense>
//			if (drivers != null)
//				checkSubmittedDrivers(drivers, driverNatAddrs, driverOffAddrs);
//
//			_log.info("Calling ReviewQuotation");
//			quot = QuotationLocalServiceUtil.reviewQuotation(quot, isUserSignedIn, lang);
//
//			_log.info("JSON submitQuotation fn -- After reviewQuotation");
//
//			quot.setPolicyTaxes(0.05);
//			svcOutput.setOutputObject(quot);
//
//			_log.info("Net Premium:" + quot.getNetPrem());
//			if (quot.getNetPrem() == 0) {
//				_log.info("Zero Premium Error");
//				svcOutput.setOutputCode(ReturnCodes.ZERO_BASE_PREMIUM);
//			} else
//				svcOutput.setOutputCode(ReturnCodes.SUCCESS);
//		}
//
//		catch (PortalException e) {
//			svcOutput.setOutputObject(quot);
//			svcOutput.setOutputCode("Error:" + e.getMessage());
//			e.printStackTrace();
//		}
//
//		_log.info("JSON submitQuotation fn -- End");
//		return svcOutput;
//	}

	public ServiceOutput<Quotation> tokenizationResult(String status) {
		ServiceOutput<Quotation> svcOutput = new ServiceOutput<Quotation>();
		HttpServletRequest request = PortalUtil
				.getOriginalServletRequest(AccessControlUtil.getAccessControlContext().getRequest());
		Quotation quot = (Quotation) request.getSession().getAttribute("quot");
		try {
			svcOutput.setOutputObject(quot);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
		}

		catch (Exception e) {
			svcOutput.setOutputObject(quot);
			svcOutput.setOutputCode("Error:" + e.getMessage());
			e.printStackTrace();
		}
		return svcOutput;
	}

	public ServiceOutput<QuotationDriver> addDriver(QuotationDriver driver, QuotationUserAddress driverNatAddress,
			QuotationUserAddress driverOffNatAddress) {
		ServiceOutput<QuotationDriver> svcOutput = new ServiceOutput<QuotationDriver>();
		HttpServletRequest request = PortalUtil
				.getOriginalServletRequest(AccessControlUtil.getAccessControlContext().getRequest());
		try {
			driver.setDriverNatAddress(driverNatAddress);
			driver.setDriverOffNatAddress(driverOffNatAddress);
			CustomerVehicleDetailsLocalServiceUtil.getDriverVehicleDetailsMob(driver, request, true);
			svcOutput.setOutputObject(driver);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
		} catch (YaqeenException e) {
			svcOutput.setOutputObject(driver);
			svcOutput.setOutputCode("Error:" + e.getErrorCode() + " " + e.getMessage());
			e.printStackTrace();
		}
		return svcOutput;
	}

	public ServiceOutput<List<CodeMasterDetails>> getEducationList() {
		ServiceOutput<List<CodeMasterDetails>> svcOutput = new ServiceOutput<List<CodeMasterDetails>>();
		List<CodeMasterDetails> eduList = QuotationLocalServiceUtil.getEducationList();

		if (eduList != null && !eduList.isEmpty()) {
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(eduList);
		} else
			svcOutput.setOutputCode(ReturnCodes.FAIL);

		return svcOutput;
	}

	public ServiceOutput<List<CodeMasterDetails>> getLicenseTypes() {
		ServiceOutput<List<CodeMasterDetails>> svcOutput = new ServiceOutput<List<CodeMasterDetails>>();
		List<CodeMasterDetails> licList = QuotationLocalServiceUtil.getLicenseTypes();

		if (licList != null && !licList.isEmpty()) {
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(licList);
		} else
			svcOutput.setOutputCode(ReturnCodes.FAIL);

		return svcOutput;
	}

	@JSONWebService(value = "renew-policy", method = "POST")
	public ServiceOutput<Quotation> renewPolicy(Policy policy, PolicyVehicle pVeh) {
		ServiceOutput<Quotation> svcOutput = new ServiceOutput<Quotation>();
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(AccessControlUtil.getAccessControlContext().getRequest());

		try {
			policy.getPolicyVehs().clear();
			policy.getPolicyVehs().add(pVeh);

			Quotation quot = QuotationLocalServiceUtil.getPolicyQuot(policy);
			quot.setSource("01");

			QuotationLocalServiceUtil.renewNcdInquiry(quot);

			QuotationLocalServiceUtil.renewAddressInquiry(quot, new Locale("en_US"));

			if (QuotationLocalServiceUtil.validatePolicyData(policy.getPolicyNo())) {
				QuotationLocalServiceUtil.renewTariffInquiry(quot);

				if (quot.getNetPrem() == 0) {
					svcOutput.setOutputObject(quot);
					svcOutput.setOutputCode("Error:" + LanguageUtil.get(httpRequest, "tariff_err"));
				} else {
					quot = QuotationLocalServiceUtil.submitQuotation(quot,
							PortalUtil.getUser(httpRequest).getScreenName());
					// notifyUser(httpRequest, quot,
					// themeDisplay.getLocale(),PortalUtil.getUser(httpRequest));
					svcOutput.setOutputObject(quot);
					svcOutput.setOutputCode(ReturnCodes.SUCCESS);
				}
			} else {
				svcOutput.setOutputObject(quot);
				svcOutput.setOutputCode("Error:missingRenewParams");
			}
		} catch (YaqeenException | NajmException e) {
			String errorCode = (e instanceof YaqeenException) ? ("" + ((YaqeenException) e).getErrorCode())
					: ("" + ((NajmException) e).getErrorCode());
			String errorMsg = (e instanceof YaqeenException) ? ("" + ((YaqeenException) e).getMessage())
					: ("" + ((NajmException) e).getMessage());
			// svcOutput.setOutputObject(quot);
			svcOutput.setOutputCode(errorCode + ":" + errorMsg);
		} catch (PortalException e) {
			String errorMsg = LanguageUtil.get(httpRequest, "renew_data_error");
			svcOutput.setOutputCode(errorMsg);
		}
		return svcOutput;
	}

	public ServiceOutput<String> getConfigurableValues(List<String> keys) {
		ServiceOutput<String> srvOutput = new ServiceOutput<String>();
		Map<String, String> dataMap = new HashMap<String, String>();
		for (String key : keys) {
			if (key != null)
				dataMap.put(key, PropsUtil.get(key));
			else {
				srvOutput.setOutputCode(ReturnCodes.FAIL);
				return srvOutput;
			}
		}

		String jsonMap = GsonUtilsLocalServiceUtil.toGson(dataMap);
		srvOutput.setOutputObject(jsonMap);
		srvOutput.setOutputCode(ReturnCodes.SUCCESS);
		return srvOutput;
	}

	public ServiceOutput<Double> quickQuoteInquiry(Quotation quot) {
		ServiceOutput<Double> srvOutput = new ServiceOutput<Double>();
		try {
			Calendar ageCal = new GregorianCalendar();
			ageCal.setTime(quot.getInsuredDob());
			Calendar cal = new GregorianCalendar();
			cal.setTime(new Date());

			int currentYear = cal.get(Calendar.YEAR);
			int birthYear = ageCal.get(Calendar.YEAR);
			int userDriverAge = currentYear - birthYear;
			int m = cal.get(Calendar.MONTH) - ageCal.get(Calendar.MONTH);
			if (m < 0 || (m == 0 && cal.getTimeInMillis() < ageCal.getTimeInMillis())) {
				userDriverAge--;
			}

			int driverAge = 0;
			if (userDriverAge <= 25)
				driverAge = 24;
			else if (userDriverAge > 25 && userDriverAge <= 35)
				driverAge = 30;
			else if (userDriverAge > 35)
				driverAge = 40;

			TariffInput tariffInput = new TariffInput();
			tariffInput.setBodyType(quot.getVehicleBodyType());
			tariffInput.setClmFreeYears(1);
			// tariffInput.setClmPastYears(0);
			tariffInput.setColor(TARIFF_QUICKQUOTE_COLOR);
			// tariffInput.setDeductible(500);
			// tariffInput.setDriverAge(driverAge);
			tariffInput.setEffFromDate(new java.sql.Date(quot.getPolicyEffDate().getTime()));

			// Kareem Kahil: Mapping Insured Gender as per SAMA CR design document
			String insuredGender = quot.getInsuredGender();

			if (insuredGender != null && !insuredGender.equals("")) {
				if (insuredGender.equalsIgnoreCase(YAKEEN_INSURED_GENDER_MALE))
					tariffInput.setGender(INSURED_GENDER_MALE);
				else
					tariffInput.setGender(INSURED_GENDER_FEMALE);
			} else
				tariffInput.setGender(0);

			tariffInput.setLoyalty(0);
			tariffInput.setMake((quot.getVehicleMake() != null && !quot.getVehicleMake().equals(""))
					? Integer.valueOf(quot.getVehicleMake())
					: 0);
			tariffInput.setMFGYear((int) quot.getVehicleMfgYear());
			tariffInput.setVehicleModel(Integer.parseInt(quot.getVehicleModel()));
			// tariffInput.setModel(23);
			// tariffInput.setNoPass(0);
			// tariffInput.setOffences(0);
			tariffInput.setProductCode("13102");

			try {
				if (quot.getVehiclePlateType() != null)
					tariffInput.setPurposeVeh(Integer.parseInt(quot.getVehiclePlateType()));
				else
					tariffInput.setPurposeVeh(1);
			} catch (Exception e) {
				e.printStackTrace();
				_log.info("Vehicle Plate Type is not a valid number.Setting as 1");
				tariffInput.setPurposeVeh(1);
			}
			// tariffInput.setPurposeVeh(1);
			if (quot.getCity() != null) {
				CodeMasterMap cityMap = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode("CITY_REGION",
						quot.getCity());
				String transformedCityCode = (cityMap != null) ? cityMap.getCoreCode() : null;
				tariffInput.setRegion(transformedCityCode);
			}
			tariffInput.setRepair(0);
			tariffInput.setSchemeCode("SCHEME_000");
			// tariffInput.setSectionCode("1310401");
			// tariffInput.setVehicleAge(currentYear - (int)quot.getVehicleMfgYear());
			tariffInput.setVehicleValue((int) quot.getVehicleValue());

			if (quot.getVehicleNationality() != null && !quot.getVehicleNationality().equals(""))
				// tariffInput.setVehNationality(quot.getVehicleNationality());
				// else
				// tariffInput.setVehNationality("01");

				if (quot.getProductCode().equals(PRODUCT_CODE_TPL)) {
					tariffInput.setProductCode("13101");
					// tariffInput.setSectionCode("1310301");
				}

			ArrayList<TariffOutput> tariffOutput = TariffLocalServiceUtil.getTariffData(tariffInput);

			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
			// srvOutput.setOutputObject(tariffOutput.getBasePremium());
		} catch (Exception e) {
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;
	}

	public ServiceOutput<Integer> countQuotationSurveyVideo(String quoteID) {
		ServiceOutput<Integer> svcOutput = new ServiceOutput<Integer>();
		try {
			int count = QuotationLocalServiceUtil.countQuotationSurveyVideo(quoteID);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(count);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return svcOutput;
	}

	public ServiceOutput<String> downloadQuotDetsFile(String quoteId, String lang) throws PortalException {

		ServiceOutput<String> srvOutput = new ServiceOutput<String>();
		try {
			File quoteDetsFile = QuotationLocalServiceUtil.downloadQuotDetsReport(quoteId, lang);
			String base64 = Base64.encode(FileCopyUtils.copyToByteArray(quoteDetsFile));
			srvOutput.setOutputObject(base64);
			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
		} catch (Exception e) {
			srvOutput.setOutputCode(ReturnCodes.FAIL);
			_log.error(e.getStackTrace());
		}
		return srvOutput;
	}

	public ServiceOutput<String> downloadPolicyFile(String quoteId, String policyNo, String lang)
			throws PortalException {

		ServiceOutput<String> srvOutput = new ServiceOutput<String>();
		try {
			File policyFile = QuotationLocalServiceUtil.downloadPolicyReport(quoteId, policyNo, lang);
			String base64 = Base64.encode(FileCopyUtils.copyToByteArray(policyFile));
			srvOutput.setOutputObject(base64);
			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
		} catch (Exception e) {
			srvOutput.setOutputCode(ReturnCodes.FAIL);
			_log.error(e.getStackTrace());
		}
		return srvOutput;
	}

	public ServiceOutput<Quotation> getQuotationDetails(String quotId) {
		ServiceOutput<Quotation> svcOutput = new ServiceOutput<Quotation>();

		try {
			Quotation quot = QuotationLocalServiceUtil.getQuotationByQuotationId(Long.valueOf(quotId));
			quot = QuotationLocalServiceUtil.getQuotationDetails(quot);

			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(quot);

		} catch (NumberFormatException | PortalException e) {
			// TODO Auto-generated catch block
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return svcOutput;
	}

	public ServiceOutput<Quotation> getTariffDetails(Quotation quot, List<QuotationDriver> drivers)
			throws PortalException {
		ServiceOutput<Quotation> srvOutput = new ServiceOutput<Quotation>();

		try {
			quot.getQuotationDrivers().clear();
			// Workaround, the QuotationDriverLicense are comming as List<HashMap> instead
			// of List<QuotationDriverLicense>
			if (drivers != null) {
				checkSubmittedDrivers(drivers, null, null);
				quot.setQuotationDrivers(drivers);
			}

			quot = QuotationLocalServiceUtil.getTariffDets(quot, false);

			double loyaltyDiscountAmount = 0.0;
			if (quot.getLoyaltyDiscount() != null)
				loyaltyDiscountAmount = Double.valueOf(quot.getLoyaltyDiscount());
			double finalNetPrem = quot.getNetPrem() + quot.getAgencyRepairOut() + quot.getDriverAgeLess21()
					- quot.getDiscountAmount() - loyaltyDiscountAmount + quot.getLoadingAmount() + quot.getPolicyFees();// +
																														// quot.getPolicyTaxes();
			double vat = (quot.getPolicyTaxes() * finalNetPrem);
			finalNetPrem += vat;
			quot.setGrossPrem(finalNetPrem);

			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
			srvOutput.setOutputObject(quot);
		} catch (Exception e) {
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;
	}

	private void checkSubmittedDrivers(List<QuotationDriver> drivers, List driverNatAddrs, List driverOffAddrs) {
		for (QuotationDriver drv : drivers) {
			if (drv.getDriverLicences() != null && !drv.getDriverLicences().isEmpty()) {
				List<QuotationDriverLicense> drvLics = new ArrayList<>();
				for (int licCount = 0; licCount < drv.getDriverLicences().size(); licCount++) {
					Object dLic = drv.getDriverLicences().get(licCount);
					if (dLic instanceof HashMap) {
						HashMap dLicMap = (HashMap) dLic;
						QuotationDriverLicense lic = new QuotationDriverLicense();
						lic.setLicCountry("" + dLicMap.get("LicCountry"));
						lic.setLicType("" + dLicMap.get("LicType"));
						lic.setLicYrs(
								(dLicMap.get("LicYrs") != null) ? Integer.valueOf("" + dLicMap.get("LicYrs")) : 0);

						drvLics.add(lic);
					}
				}
				drv.setDriverLicences(drvLics);
			}
			if (driverNatAddrs != null && !driverNatAddrs.isEmpty()) {
				QuotationUserAddress addr = null;
				for (int natAddrCount = 0; natAddrCount < driverNatAddrs.size(); natAddrCount++) {
					Object natAddr = driverNatAddrs.get(natAddrCount);
					if (natAddr instanceof HashMap) {
						HashMap natAddrMap = (HashMap) natAddr;
						String id = natAddrMap.get("key").toString();
						if (natAddrMap.get("key") != null
								&& natAddrMap.get("key").toString().equals("" + drv.getDriverId())) {
							addr = (QuotationUserAddress) GsonUtilsLocalServiceUtil
									.fromGson(natAddrMap.get("value").toString(), QuotationUserAddress.class);
							break;
						}

					}
				}
				drv.setDriverNatAddress(addr);
			}
			if (driverOffAddrs != null && !driverOffAddrs.isEmpty()) {
				QuotationUserAddress addr = null;
				for (int offAddrCount = 0; offAddrCount < driverOffAddrs.size(); offAddrCount++) {
					Object offAddr = driverOffAddrs.get(offAddrCount);
					if (offAddr instanceof HashMap) {
						HashMap offAddrMap = (HashMap) offAddr;
						String id = offAddrMap.get("key").toString();
						if (offAddrMap.get("key") != null
								&& offAddrMap.get("key").toString().equals("" + drv.getDriverId())) {
							addr = (QuotationUserAddress) GsonUtilsLocalServiceUtil
									.fromGson(offAddrMap.get("value").toString(), QuotationUserAddress.class);
							break;
						}

					}
				}
				drv.setDriverOffNatAddress(addr);
			}
		}
	}
}