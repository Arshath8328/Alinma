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

import com.atmc.bsl.db.domain.quotation.Quotation;
import com.atmc.bsl.db.domain.quotation.QuotationDriver;
import com.atmc.bsl.db.exception.NajmException;
import com.atmc.bsl.db.exception.YaqeenException;
import com.atmc.bsl.db.service.base.CustomerVehicleDetailsLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.ejada.atmc.acl.db.exception.NoSuchAtmcYakeenMakeModelException;
import com.ejada.atmc.acl.db.exception.NoSuchYakeenDataSaveException;
import com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel;
import com.ejada.atmc.acl.db.model.CodeMasterMap;
import com.ejada.atmc.acl.db.model.YakeenDataSave;
import com.ejada.atmc.acl.db.service.AtmcYakeenMakeModelLocalServiceUtil;
import com.ejada.atmc.acl.db.service.CodeMasterMapLocalServiceUtil;
import com.ejada.atmc.acl.db.service.YakeenDataSaveLocalServiceUtil;
import com.ejada.atmc.acl.ws.domain.NCDEligibility;
import com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.BasicCarInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.CarInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.CitizenInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest;
import com.ejada.atmc.acl.ws.service.NajmLocalServiceUtil;
import com.ejada.atmc.acl.ws.service.YakeenLocalServiceUtil;
import com.atmc.bsl.db.service.base.CustomerVehicleDetailsLocalServiceBaseImpl;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

/**
 * The implementation of the customer vehicle details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.CustomerVehicleDetailsLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomerVehicleDetailsLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.atmc.bsl.db.model.CustomerVehicleDetails", service = AopService.class)
public class CustomerVehicleDetailsLocalServiceImpl extends CustomerVehicleDetailsLocalServiceBaseImpl {
	public static final String VEHICLE_ISTIMARA_CARD = "1";
	public static final String VEHICLE_CUSTOM_CARD = "2";
	public static final String VEHICLE_TRANSFER_OWNERSHIP_CARD = "3";
	public static final String PRODUCT_CODE_COMPREHENSIVE = "OD";
	public static final String PRODUCT_CODE_TPL = "TP";
	public static final String VEHICLE_ID_TYPE_SEQ_NO = "1";
	public static final String VEHICLE_ID_TYPE_CUSTOM_CARD = "2";
	public static final String ODS_SRC_TYPE_NATIONALITY = "NATIONALITY";
	public static final String ODS_SRC_TYPE_COLOR = "COLOR";
	public static final String ODS_SRC_TYPE_VEH_MAKE = "VEH_MAKE";
	public static final String ODS_SRC_TYPE_MAKE_NAT = "MAKE_NATIONALITY";
	public static final String ODS_SRC_TYPE_VEH_MOD = "VEH_MOD";
	public static final String ODS_SRC_TYPE_BODY_TYPE = "BODY_TYPE";
	public static final String ODS_SRC_TYPE_CITY = "CITY";
	public static final String ODS_SRC_TYPE_PLATE_TYPE = "PLATE_TYPE";
	public static final long ID_TYPE_SAUDI = 1;
	public static final long ID_TYPE_IQAMA = 2;
	public static final int YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED = 999999;
	private final static String VEHICLE_MAKE_CODE = "MOT_VEH_MAKE";
	private final static String VEHICLE_MODEL_CODE = "MOT_VEH_MOD";
	private final static String VEHICLE_BODY_TYPE_CODE = "MOT_BODY_TYP";
	private final static String VEHICLE_MAK_MOD_BODY_TYPE = "MAK_MOD_BODY";
	private String yaqeenUserName = PropsUtil.get("com.ejada.atmc.yaqeen.username");
	private String yaqeenPassword = PropsUtil.get("com.ejada.atmc.yaqeen.password");
	private String yaqeenRefNo = PropsUtil.get("com.ejada.atmc.yaqeen.referencenumber");
	private String yaqeenChargeCode = PropsUtil.get("com.ejada.atmc.yaqeen.chargecode");
	private static final String NCD_STATUS_CODE_SUCCESS = "1";
	private static final Log _log = LogFactoryUtil.getLog(CustomerVehicleDetailsLocalServiceImpl.class);
	private SimpleDateFormat yakeenHijriDateFormat = new SimpleDateFormat("MM-yyyy");
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat driverDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.ejada.atmc.bsl.db.service.CustomerVehicleDetailsLocalServiceUtil} to
	 * access the customer vehicle details local service.
	 */
	public AlienInfo getAlienInfoByIqama(ServiceRequest svcRequest, String iqamaNumber, String sponsorId) {
		return YakeenLocalServiceUtil.getAlienInfoByIqama(svcRequest, iqamaNumber, sponsorId);
	}

	public CitizenInfo getCitizenInfo(ServiceRequest svcRequest, String dateOfBirthH, String nin) {
		return YakeenLocalServiceUtil.getCitizenInfo(svcRequest, dateOfBirthH, nin);
	}

	public BasicCarInfo getCarInfoByCustom(ServiceRequest svcRequest, String customCardNumber, short modelYear) {
		return YakeenLocalServiceUtil.getCarInfoByCustom(svcRequest, customCardNumber, modelYear);
	}

	public CarInfo getCitizenCarInfoBySequence(ServiceRequest svcRequest, int sequenceNumber, long ownerNin) {
		return YakeenLocalServiceUtil.getCitizenCarInfoBySequence(svcRequest, sequenceNumber, ownerNin);
	}

	public CarInfo getAlienCarInfoBySequence(ServiceRequest svcRequest, int sequenceNumber, long ownerIqamaNumber) {
		return YakeenLocalServiceUtil.getAlienCarInfoBySequence(svcRequest, sequenceNumber, ownerIqamaNumber);
	}

	public Quotation getCustomerVehicleDetails(Quotation quot, String addLang, Locale locale)
			throws YaqeenException, NajmException {
		SimpleDateFormat yakeenCarDateFormat = new SimpleDateFormat("dd-MM-YYYY");
		// SimpleDateFormat yakeenAddressHijriDateFormat = new
		// SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat yakeenAddressGregDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String[] bodyTypes = { "011", "012", "013", "014", "406", "407", "408", "409" };

		List<String> bodyTypeList = Arrays.asList(bodyTypes);
		String vehicleIdentifier = "" + quot.getVehicleIdType();
		String iqamaId = "" + quot.getInsuredId();
		String dobH = quot.getInsuredDobH();
		String vehSeqNo = "" + quot.getVehicleId();
		String dobG = dateFormat.format(quot.getInsuredDob());
		quot.setInsuredNationality("03");
		String mfgYear = "" + quot.getVehicleMfgYear();
		String addressDobHFormatted = "";
		String addressDobGFormatted = "";
		String dobHFormatted = "";
		String dobGFormatted = "";
		AtmcYakeenMakeModel atmcYakeenMakeModel = null;
		YakeenDataSave yakeenDataSave = null;
		JAXBContext jaxbContext;
		CitizenInfo savedCitizenInfo = null;

		// NCD always retrieved from Najm service
		// Kareem Kahil 14/8/2018: As requested by Noman, in case of Transfer of
		// Ownership, we should pass the value 1 to ncdElegibility service not 3.
		// Confirmed by Arqum that
		// it should be that in design doc
		String vehicleIdentifierNajm = vehicleIdentifier;

		if (vehicleIdentifierNajm.equals("3")) // BuyMotorPolicyPortletKeys.VEHICLE_TRANSFER_OWNERSHIP_CARD
		{
			vehicleIdentifierNajm = "1";
		}

		_log.info("Invoking NDCEligibility opt");
		long s1Time = System.currentTimeMillis();
		NCDEligibility ncdRes = NajmLocalServiceUtil.ncdEligibility(Long.valueOf(iqamaId),
				Integer.valueOf(vehicleIdentifierNajm), Long.valueOf(vehSeqNo));
		_log.info("Back from NCDELigibility");
		long period1 = System.currentTimeMillis() - s1Time;
		_log.info("ncdEligibility took " + period1 + " ms");
		_log.info(ncdRes);
		if (ncdRes != null && ncdRes.getStatusCode().equals(NCD_STATUS_CODE_SUCCESS)) {
			_log.info("Najm status code:" + ncdRes.getStatusCode());
			if (ncdRes.getNCDFreeYears() != null) {
				_log.info("Najm NCD Returned:" + ncdRes.getNCDFreeYears());
				quot.setNcdYears(Long.valueOf(ncdRes.getNCDFreeYears()));
			}
		} else
			throw new NajmException(Integer.valueOf(ncdRes.getStatusCode()), ncdRes.getErrorMsg());

		try {
			// Date hijriDob = dateFormat.parse(dobH);
			Date gregDob = dateFormat.parse(dobG);
			dobHFormatted = (dobH != null && !dobH.equals("")) ? (dobH.split("-")[1] + "-" + dobH.split("-")[0]) : null;
			addressDobHFormatted = (dobH != null && !dobH.equals(""))
					? (dobH.split("-")[2] + "-" + dobH.split("-")[1] + "-" + dobH.split("-")[0])
					: null;
			dobGFormatted = yakeenHijriDateFormat.format(gregDob);
			addressDobGFormatted = yakeenAddressGregDateFormat.format(gregDob);
		} catch (ParseException e) {
			e.printStackTrace();
			_log.error(e.getMessage());
		}

		ServiceRequest req = new ServiceRequest();
		req.setUsername(yaqeenUserName);
		req.setPassword(yaqeenPassword);
		req.setReferenceNumber(yaqeenRefNo);
		req.setChargeCode(yaqeenChargeCode);
		if (iqamaId.startsWith("1")) {
			quot.setInsuredIdType(ID_TYPE_SAUDI);
			_log.info("Yakeen ServiceRequest 1 >>>> " + req.toString());
			_log.info("dobHFormatted >>>> " + dobHFormatted);
			_log.info("iqamaId >>>> " + iqamaId);
			long s2Time = System.currentTimeMillis();
			CitizenInfo citizenInfo;
			_log.info("Invoking getCitizenInfo");
			try {
				yakeenDataSave = YakeenDataSaveLocalServiceUtil.findByiqamaStatusServiceName("CitizenInfo", "0",
						iqamaId);
			} catch (NoSuchYakeenDataSaveException e) {
				_log.info("Citizen info not found for the iqama id in the database" + iqamaId);
				e.getMessage();
			}
			if (yakeenDataSave != null && !yakeenDataSave.equals("")) {
				try {
					SAXParserFactory spf = SAXParserFactory.newInstance();
					spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
					spf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

					Source xmlSource = new SAXSource(spf.newSAXParser().getXMLReader(),
							new InputSource(new StringReader(yakeenDataSave.getServiceOutput())));
					JAXBContext jc = JAXBContext.newInstance(CitizenInfo.class);
					Unmarshaller um = jc.createUnmarshaller();
					savedCitizenInfo = (CitizenInfo) um.unmarshal(xmlSource);

//					jaxbContext = JAXBContext.newInstance(CitizenInfo.class);
//					Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();
//					StringReader st = new StringReader(yakeenDataSave.getServiceOutput());
//					savedCitizenInfo = (CitizenInfo) jaxbMarshaller.unmarshal(st);
					_log.info(" unmarshelling completed  >>>>>>>>>>>>");
				} catch (Exception e) {
					e.printStackTrace();
				}

				if ((savedCitizenInfo.getErrorCode() != 0) && (savedCitizenInfo.getErrorMessage() != null)) {
					throw new YaqeenException(savedCitizenInfo.getErrorCode(),
							LanguageUtil.get(locale, "yaqeen_error_" + savedCitizenInfo.getErrorCode()));
				}
				quot.setInsuredName(
						savedCitizenInfo.getEnglishFirstName() + " " + savedCitizenInfo.getEnglishSecondName() + " "
								+ savedCitizenInfo.getEnglishThirdName() + " " + savedCitizenInfo.getEnglishLastName());
				quot.setInsuredGender(savedCitizenInfo.getGender());
				quot.setInsuredOccupationCode(savedCitizenInfo.getOccupationCode());

				/*---------------------------------------------------*/
				_log.info("Invoking getCitizenAddress");
				long sTime = System.currentTimeMillis();
				List<AddressInfo> citizenAddrInfo = YakeenLocalServiceUtil.getCitizenAddressInfo(req, iqamaId,
						addressDobHFormatted, addLang);
				_log.info("Back from getCitizenAddress");
				long period = System.currentTimeMillis() - sTime;
				_log.info("getCitizenAddressInfo took " + period + " ms");
				if (citizenAddrInfo != null && citizenAddrInfo.size() == 1 && citizenAddrInfo.get(0).getErrorCode() != 0
						&& citizenAddrInfo.get(0).getErrorMessage() != null) {
					throw new YaqeenException(citizenAddrInfo.get(0).getErrorCode(),
							LanguageUtil.get(locale, "yaqeen_error_" + citizenAddrInfo.get(0).getErrorCode()));
				} else {
					if (citizenAddrInfo != null && !citizenAddrInfo.isEmpty()) {
						AddressInfo info = citizenAddrInfo.get(0);
						if (info.getBuildingNumber() == null && info.getDistrict() == null
								&& info.getStreetName() == null && info.getPostCode() == null
								&& info.getAdditionalNumber() == null && info.getCity() == null)
							throw new YaqeenException(YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED, "Generic Error");
						else {
							quot.setAddressBuildingNo(
									(info.getBuildingNumber() != null) ? Long.valueOf(info.getBuildingNumber()) : 0L);
							quot.setAddressDistrict(
									(info.getDistrict() != null) ? info.getDistrict().replaceAll("'", "") : null);
							quot.setAddressStreet(
									(info.getStreetName() != null) ? info.getStreetName().replaceAll("'", "") : null);
							quot.setAddressZipCode(
									(info.getPostCode() != null) ? Long.valueOf(info.getPostCode()) : 0L);
							quot.setAddressAddNo(
									(info.getAdditionalNumber() != null) ? Long.valueOf(info.getAdditionalNumber())
											: 0L);
							quot.setCityDesc((info.getCity() != null) ? info.getCity().replaceAll("'", "") : null);
						}
					} else {
						throw new YaqeenException(YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED, "Generic Error");

					}
				}
				/*--------------------------------------------*/

			} else {
				citizenInfo = YakeenLocalServiceUtil.getCitizenInfo(req, dobHFormatted, iqamaId);
				_log.info("Back from getCitizenInfo");
				long period2 = System.currentTimeMillis() - s2Time;
				_log.info("getCitizenInfo took " + period2 + " ms");

				if (citizenInfo.getErrorCode() != 0 && citizenInfo.getErrorMessage() != null) {
					throw new YaqeenException(citizenInfo.getErrorCode(),
							LanguageUtil.get(locale, "yaqeen_error_" + citizenInfo.getErrorCode()));
				} else {
					quot.setInsuredName(citizenInfo.getEnglishFirstName() + " " + citizenInfo.getEnglishSecondName()
							+ " " + citizenInfo.getEnglishThirdName() + " " + citizenInfo.getEnglishLastName());
					quot.setInsuredGender(citizenInfo.getGender());
					quot.setInsuredOccupationCode(citizenInfo.getOccupationCode());

				}
				_log.info("Invoking getCitizenAddress");
				long sTime = System.currentTimeMillis();
				List<AddressInfo> citizenAddrInfo = YakeenLocalServiceUtil.getCitizenAddressInfo(req, iqamaId,
						addressDobHFormatted, addLang);
				_log.info("Back from getCitizenAddress");
				long period = System.currentTimeMillis() - sTime;
				_log.info("getCitizenAddressInfo took " + period + " ms");
				if (citizenAddrInfo != null && citizenAddrInfo.size() == 1 && citizenAddrInfo.get(0).getErrorCode() != 0
						&& citizenAddrInfo.get(0).getErrorMessage() != null) {
					throw new YaqeenException(citizenAddrInfo.get(0).getErrorCode(),
							LanguageUtil.get(locale, "yaqeen_error_" + citizenAddrInfo.get(0).getErrorCode()));
				} else {
					if (citizenAddrInfo != null && !citizenAddrInfo.isEmpty()) {
						AddressInfo info = citizenAddrInfo.get(0);
						if (info.getBuildingNumber() == null && info.getDistrict() == null
								&& info.getStreetName() == null && info.getPostCode() == null
								&& info.getAdditionalNumber() == null && info.getCity() == null)
							throw new YaqeenException(YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED, "Generic Error");
						else {
							quot.setAddressBuildingNo(
									(info.getBuildingNumber() != null) ? Long.valueOf(info.getBuildingNumber()) : 0L);
							quot.setAddressDistrict(
									(info.getDistrict() != null) ? info.getDistrict().replaceAll("'", "") : null);
							quot.setAddressStreet(
									(info.getStreetName() != null) ? info.getStreetName().replaceAll("'", "") : null);
							quot.setAddressZipCode(
									(info.getPostCode() != null) ? Long.valueOf(info.getPostCode()) : 0L);
							quot.setAddressAddNo(
									(info.getAdditionalNumber() != null) ? Long.valueOf(info.getAdditionalNumber())
											: 0L);
							quot.setCityDesc((info.getCity() != null) ? info.getCity().replaceAll("'", "") : null);
						}
					} else {
						throw new YaqeenException(YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED, "Generic Error");

					}
				}
			}
		} else {
			quot.setInsuredIdType(ID_TYPE_IQAMA);
			_log.info("Invoking  getAlienInfoByIqamaDOB");
			long sTime = System.currentTimeMillis();
			try {
				yakeenDataSave = YakeenDataSaveLocalServiceUtil.findByiqamaStatusServiceName("AlienInfo", "0", iqamaId);
			} catch (NoSuchYakeenDataSaveException e) {
				_log.info("Citizen info not found for the iqama id in the database" + iqamaId);
				e.getMessage();
			}
			if (yakeenDataSave != null && !yakeenDataSave.equals("")) {
				try {
					SAXParserFactory spf = SAXParserFactory.newInstance();
					spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
					spf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

					Source xmlSource = new SAXSource(spf.newSAXParser().getXMLReader(),
							new InputSource(new StringReader(yakeenDataSave.getServiceOutput())));
					JAXBContext jc = JAXBContext.newInstance(AlienInfo.class);
					Unmarshaller um = jc.createUnmarshaller();
					savedCitizenInfo = (AlienInfo) um.unmarshal(xmlSource);

//					jaxbContext = JAXBContext.newInstance(AlienInfo.class);
//					Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();
//					StringReader st = new StringReader(yakeenDataSave.getServiceOutput());
//					savedCitizenInfo = (AlienInfo) jaxbMarshaller.unmarshal(st);
					_log.info(" unmarshelling completed  >>>>>>>>>>>>");
				} catch (Exception e) {
					e.printStackTrace();
				}

				if ((savedCitizenInfo.getErrorCode() != 0) && (savedCitizenInfo.getErrorMessage() != null)) {
					throw new YaqeenException(savedCitizenInfo.getErrorCode(),
							LanguageUtil.get(locale, "yaqeen_error_" + savedCitizenInfo.getErrorCode()));
				}
				quot.setInsuredName(
						savedCitizenInfo.getEnglishFirstName() + " " + savedCitizenInfo.getEnglishSecondName() + " "
								+ savedCitizenInfo.getEnglishThirdName() + " " + savedCitizenInfo.getEnglishLastName());
				quot.setInsuredGender(savedCitizenInfo.getGender());
				quot.setInsuredOccupationCode(savedCitizenInfo.getOccupationCode());

				/*----------------------------------------*/
				_log.info("Invoking getAlienAddress");
				long s3Time = System.currentTimeMillis();
				List<AddressInfo> citizenAddrInfo = YakeenLocalServiceUtil.getAlienAddressInfo(req, iqamaId,
						addressDobGFormatted, addLang);
				_log.info("Back from getAlienAddress");
				long period3 = System.currentTimeMillis() - s3Time;
				_log.info("getAlienAddressInfo took " + period3 + " ms");

				if (citizenAddrInfo != null && citizenAddrInfo.size() == 1 && citizenAddrInfo.get(0).getErrorCode() != 0
						&& citizenAddrInfo.get(0).getErrorMessage() != null) {
					throw new YaqeenException(citizenAddrInfo.get(0).getErrorCode(),
							LanguageUtil.get(locale, "yaqeen_error_" + citizenAddrInfo.get(0).getErrorCode()));
				} else {
					if (citizenAddrInfo != null && !citizenAddrInfo.isEmpty()) {
						AddressInfo info = citizenAddrInfo.get(0);
						if (info.getBuildingNumber() == null && info.getDistrict() == null
								&& info.getStreetName() == null && info.getPostCode() == null
								&& info.getAdditionalNumber() == null && info.getCity() == null)
							throw new YaqeenException(YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED, "Generic Error");
						else {
							if (info.getBuildingNumber() != null)
								quot.setAddressBuildingNo(Long.valueOf(info.getBuildingNumber()));
							quot.setAddressDistrict(
									(info.getDistrict() != null) ? info.getDistrict().replaceAll("'", "") : null);
							quot.setAddressStreet(
									(info.getStreetName() != null) ? info.getStreetName().replaceAll("'", "") : null);
							if (info.getPostCode() != null)
								quot.setAddressZipCode(Long.valueOf(info.getPostCode()));
							if (info.getAdditionalNumber() != null)
								quot.setAddressAddNo(Long.valueOf(info.getAdditionalNumber()));
							quot.setCityDesc((info.getCity() != null) ? info.getCity().replaceAll("'", "") : null);
						}
					} else
						throw new YaqeenException(YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED, "Generic Error");
				}
				/*----------------------------------------*/
			} else {
				AlienInfo custInfo = YakeenLocalServiceUtil.getAlienInfoByIqamaAndDOB(req, iqamaId, dobGFormatted);
				_log.info("Back from getAlienInfoByIqamaDOB");
				long period = System.currentTimeMillis() - sTime;
				_log.info("getAlienInfoByIqamaAndDOB took " + period + " ms");
				if (custInfo.getErrorCode() != 0 && custInfo.getErrorMessage() != null) {
					throw new YaqeenException(custInfo.getErrorCode(),
							LanguageUtil.get(locale, "yaqeen_error_" + custInfo.getErrorCode()));
				} else {
					long s2Time = System.currentTimeMillis();
					CodeMasterMap natMap = CodeMasterMapLocalServiceUtil
							.findBySourceTypeSourceCode(ODS_SRC_TYPE_NATIONALITY, "" + custInfo.getNationalityCode());
					long period2 = System.currentTimeMillis() - s2Time;
					_log.info("Nationality Lookup took " + period2 + " ms");
					String transformedNationality = (natMap != null) ? natMap.getCoreCode() : "";
					quot.setInsuredNationality(transformedNationality);
					quot.setInsuredName(custInfo.getEnglishFirstName() + " " + custInfo.getEnglishSecondName() + " "
							+ custInfo.getEnglishThirdName() + " " + custInfo.getEnglishLastName());
					quot.setInsuredGender(custInfo.getGender());
					quot.setInsuredOccupationCode(custInfo.getOccupationCode());
					quot.setInsuredMaritalStatus("" + custInfo.getSocialStatusCode());
				}
				_log.info("Invoking getAlienAddress");
				long s3Time = System.currentTimeMillis();
				List<AddressInfo> citizenAddrInfo = YakeenLocalServiceUtil.getAlienAddressInfo(req, iqamaId,
						addressDobGFormatted, addLang);
				_log.info("Back from getAlienAddress");
				long period3 = System.currentTimeMillis() - s3Time;
				_log.info("getAlienAddressInfo took " + period3 + " ms");

				if (citizenAddrInfo != null && citizenAddrInfo.size() == 1 && citizenAddrInfo.get(0).getErrorCode() != 0
						&& citizenAddrInfo.get(0).getErrorMessage() != null) {
					throw new YaqeenException(citizenAddrInfo.get(0).getErrorCode(),
							LanguageUtil.get(locale, "yaqeen_error_" + citizenAddrInfo.get(0).getErrorCode()));
				} else {
					if (citizenAddrInfo != null && !citizenAddrInfo.isEmpty()) {
						AddressInfo info = citizenAddrInfo.get(0);
						if (info.getBuildingNumber() == null && info.getDistrict() == null
								&& info.getStreetName() == null && info.getPostCode() == null
								&& info.getAdditionalNumber() == null && info.getCity() == null)
							throw new YaqeenException(YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED, "Generic Error");
						else {
							if (info.getBuildingNumber() != null)
								quot.setAddressBuildingNo(Long.valueOf(info.getBuildingNumber()));
							quot.setAddressDistrict(
									(info.getDistrict() != null) ? info.getDistrict().replaceAll("'", "") : null);
							quot.setAddressStreet(
									(info.getStreetName() != null) ? info.getStreetName().replaceAll("'", "") : null);
							if (info.getPostCode() != null)
								quot.setAddressZipCode(Long.valueOf(info.getPostCode()));
							if (info.getAdditionalNumber() != null)
								quot.setAddressAddNo(Long.valueOf(info.getAdditionalNumber()));
							quot.setCityDesc((info.getCity() != null) ? info.getCity().replaceAll("'", "") : null);
						}
					} else
						throw new YaqeenException(YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED, "Generic Error");
				}
			}
		}

		if (vehicleIdentifier.equals(VEHICLE_CUSTOM_CARD)) {

			_log.info("Invoking getCarInfoByCustom");
			long sTime = System.currentTimeMillis();
			BasicCarInfo carInfo = YakeenLocalServiceUtil.getCarInfoByCustom(req, vehSeqNo, Short.valueOf(mfgYear)); // getCarInfoByCustom
			_log.info("Back from getCarInfoByCustom");
			long period = System.currentTimeMillis() - sTime;
			_log.info("getCarInfoByCustom took " + period + " ms");
			if (carInfo.getErrorCode() != 0 && carInfo.getErrorMessage() != null) {
				throw new YaqeenException(carInfo.getErrorCode(),
						LanguageUtil.get(locale, "yaqeen_error_" + carInfo.getErrorCode()));
			} else {
				long s2Time = System.currentTimeMillis();
				CodeMasterMap vehColorMap = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode(ODS_SRC_TYPE_COLOR,
						carInfo.getMajorColor());
				_log.info("VEHICLE CARD INFO CALLING for Vehicle make = " + carInfo.getVehicleMakerCode()
						+ "and model Code =  " + carInfo.getVehicleModelCode());
				try {
					atmcYakeenMakeModel = AtmcYakeenMakeModelLocalServiceUtil.findByYakeenMakeModelDetails(
							String.valueOf(String.valueOf(carInfo.getVehicleMakerCode())),
							String.valueOf(carInfo.getVehicleModelCode()));
				} catch (NoSuchAtmcYakeenMakeModelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				_log.info("recieved card details " + atmcYakeenMakeModel);
				String transformedVehicleColor = (vehColorMap != null) ? vehColorMap.getCoreCode() : null;

				quot.setVehicleBodyType(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getEskaBodyTypeId() : "");
				quot.setVehicleBodyTypeEn(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getAtmcBodyType() : "");
				quot.setVehicleBodyTypeAr(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getAtmcBodyType() : "");
				quot.setVehicleMake(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getEskaMakeId() : "");
				quot.setVehicleMakeEn(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenMakeDesc() : "");
				quot.setVehicleMakeAr(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenMakeDesc() : "");
				quot.setVehicleModel(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getEskaModelId() : "");
				quot.setVehicleModelEn(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenModelEnglish() : "");
				quot.setVehicleModelAr(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenModelArabic() : "");
				quot.setVehicleChassisNo(carInfo.getChassisNumber());
				quot.setVehicleColor(transformedVehicleColor);
				quot.setVehicleNationality(atmcYakeenMakeModel.getEskaVehNationalityId());
				quot.setVehicleWeight(carInfo.getVehicleWeight());
				quot.setVehicleCapacity(carInfo.getVehicleLoad());

				// quot.setVehicleCylinder(carInfo.getCylinders());
				// quot.setVehicleEstExpiryDate(dateFormat.parse(carInfo.getRegExpiryDate()));
				// quot.setCity(""+carInfo.getRegCityLocationCode());
			}
		} else if (vehicleIdentifier.equals(VEHICLE_ISTIMARA_CARD)
				|| vehicleIdentifier.equals(VEHICLE_TRANSFER_OWNERSHIP_CARD)) {
			CarInfo savedCarInfo = null;
			YakeenDataSave citizenCarInfoLocalData = null;
			com.ejada.atmc.acl.ws.domain.yakeen.CarInfo carInfo = null;
			long vSeqVal = Long.valueOf(vehSeqNo);
			if (vSeqVal < Integer.MIN_VALUE || vSeqVal > Integer.MAX_VALUE) {
				System.err.println("vehSeqNo:" + vehSeqNo + " cannot be cast to int without changing its value.");
			}
			if (iqamaId.startsWith("1")) {
				//// Ahmed AE Fattah : 14-04-2018
				//// As per Khatib's Mail To send the OLD Iqama/ID in case of transfer ownership
				//// to get his info as he is the current owner of the CAR
				String oldIqama = iqamaId;
				_log.info("vehicleIdentifier >>>>> " + vehicleIdentifier);
				_log.info("iqamaId Before >>>>> " + oldIqama);
				if (vehicleIdentifier.equals(VEHICLE_TRANSFER_OWNERSHIP_CARD))
					oldIqama = quot.getOldIqamaId();
				_log.info("iqamaId After >>>>> " + oldIqama);

				_log.info("Invoking getCitizenCarBySequence");
				long sTime = System.currentTimeMillis();

				try {
					SAXParserFactory spf = SAXParserFactory.newInstance();
					spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
					spf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

					citizenCarInfoLocalData = YakeenDataSaveLocalServiceUtil.findByIqamaSequence(oldIqama,
							String.valueOf(vSeqVal), "CitizenCarInfoBySequence", "0");
					Source xmlSource = new SAXSource(spf.newSAXParser().getXMLReader(),
							new InputSource(new StringReader(citizenCarInfoLocalData.getServiceOutput())));
					JAXBContext jc = JAXBContext.newInstance(BasicCarInfo.class, CarInfo.class);
					Unmarshaller um = jc.createUnmarshaller();
					savedCarInfo = (CarInfo) um.unmarshal(xmlSource);

//					citizenCarInfoLocalData = YakeenDataSaveLocalServiceUtil.findByIqamaSequence(oldIqama,String.valueOf(vSeqVal), "CitizenCarInfoBySequence", "0");
//					jaxbContext = JAXBContext.newInstance(BasicCarInfo.class,CarInfo.class);
//					Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();
//					StringReader st = new StringReader(citizenCarInfoLocalData.getServiceOutput());
//					savedCarInfo = (CarInfo) jaxbMarshaller.unmarshal(st);
					_log.info(" unmarshelling completed  >>>>>>>>>>>>");
				} catch (NoSuchYakeenDataSaveException | JAXBException | ParserConfigurationException
						| SAXException e) {
					e.printStackTrace();
				}
				if (citizenCarInfoLocalData == null) {
					carInfo = YakeenLocalServiceUtil.getCitizenCarInfoBySequence(req, (int) (vSeqVal),
							Long.valueOf(oldIqama));// getCitizenCarInfoBySequence
					_log.info("Back from getCitizenCarBySequence");
					long period = System.currentTimeMillis() - sTime;
					_log.info("getCitizenCarBySequence took " + period + " ms");
				}
			} else {
				String oldIqama = iqamaId;
				_log.info("vehicleIdentifier >>>>> " + vehicleIdentifier);
				_log.info("iqamaId Before >>>>> " + oldIqama);
				if (vehicleIdentifier.equals(VEHICLE_TRANSFER_OWNERSHIP_CARD))
					oldIqama = quot.getOldIqamaId();
				_log.info("iqamaId After >>>>> " + oldIqama);

				_log.info("Invoking getAlienCarSequence");
				long sTime = System.currentTimeMillis();

				try {
					SAXParserFactory spf = SAXParserFactory.newInstance();
					spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
					spf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

					citizenCarInfoLocalData = YakeenDataSaveLocalServiceUtil.findByIqamaSequence(oldIqama,
							String.valueOf(vSeqVal), "AlienCarInfoBySequence", "0");
					Source xmlSource = new SAXSource(spf.newSAXParser().getXMLReader(),
							new InputSource(new StringReader(citizenCarInfoLocalData.getServiceOutput())));
					JAXBContext jc = JAXBContext.newInstance(BasicCarInfo.class, CarInfo.class);
					Unmarshaller um = jc.createUnmarshaller();
					savedCarInfo = (CarInfo) um.unmarshal(xmlSource);

//					citizenCarInfoLocalData = YakeenDataSaveLocalServiceUtil.findByIqamaSequence(oldIqama,String.valueOf(vSeqVal), "AlienCarInfoBySequence", "0");
//					jaxbContext = JAXBContext.newInstance(BasicCarInfo.class,CarInfo.class);
//					Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();
//					StringReader st = new StringReader(citizenCarInfoLocalData.getServiceOutput());
//					savedCarInfo = (CarInfo) jaxbMarshaller.unmarshal(st);
					_log.info(" unmarshelling completed  >>>>>>>>>>>>");

				} catch (NoSuchYakeenDataSaveException | JAXBException | SAXException
						| ParserConfigurationException e) {
					e.printStackTrace();
				}

				if (citizenCarInfoLocalData == null) {
					carInfo = YakeenLocalServiceUtil.getAlienCarInfoBySequence(req, Integer.valueOf(vehSeqNo),
							Long.valueOf(oldIqama)); // getAlienCarInfoBySequence
				}

			}
			if (savedCarInfo != null) {
				long sTime = System.currentTimeMillis();
				CodeMasterMap vehColorMap = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode("COLOR",
						savedCarInfo.getMajorColor());
				CodeMasterMap cityMap = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode("CITY",
						"" + savedCarInfo.getRegCityLocationCode());
				CodeMasterMap vehPlateTypeMap = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode("PLATE_TYPE",
						"" + savedCarInfo.getPlateTypeCode());
				String transformedVehicleColor = vehColorMap != null ? vehColorMap.getCoreCode() : null;
				String transformedCityCode = cityMap != null ? cityMap.getCoreCode() : null;
				String transformedPlateType = vehPlateTypeMap != null ? vehPlateTypeMap.getCoreCode() : null;
				String plateDesc = vehPlateTypeMap != null ? vehPlateTypeMap.getCoreDesc() : "";
				try {
					_log.info("VEHICLE CARD INFO CALLING for Vehicle make = " + savedCarInfo.getVehicleMakerCode()
							+ "and model Code =  " + savedCarInfo.getVehicleModelCode());
					atmcYakeenMakeModel = AtmcYakeenMakeModelLocalServiceUtil.findByYakeenMakeModelDetails(
							String.valueOf(savedCarInfo.getVehicleMakerCode()),
							String.valueOf(savedCarInfo.getVehicleModelCode()));
					_log.info("recieved card details " + atmcYakeenMakeModel);
				} catch (NoSuchAtmcYakeenMakeModelException e) {
					// TODO: handle exception
				}
				quot.setVehiclePlateNo(savedCarInfo.getPlateNumber());
				quot.setVehiclePlateL1(savedCarInfo.getPlateText1());
				quot.setVehiclePlateL2(savedCarInfo.getPlateText2());
				quot.setVehiclePlateL3(savedCarInfo.getPlateText3());
				quot.setVehicleMfgYear(savedCarInfo.getModelYear());
				quot.setVehiclePlateType(transformedPlateType);
				quot.setVehicleWeight(savedCarInfo.getVehicleWeight());
				quot.setVehicleCapacity(savedCarInfo.getVehicleLoad());
				quot.setVehicleCylinder(savedCarInfo.getCylinders());
				Date date = null;
				if (savedCarInfo.getRegExpiryDate() != null) {
					try {
						date = new SimpleDateFormat("dd-MM-yyyy").parse(savedCarInfo.getRegExpiryDate());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					_log.info("new parsed date " + date);
					quot.setVehicleEstExpiryDate(date);
				}
				quot.setVehiclePlateTypeDesc(plateDesc);
				quot.setVehicleBodyType(atmcYakeenMakeModel.getEskaBodyTypeId());
				quot.setVehicleBodyTypeEn(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getAtmcBodyType() : "");
				quot.setVehicleBodyTypeAr(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getAtmcBodyType() : "");
				quot.setVehicleMake(atmcYakeenMakeModel.getEskaMakeId());
				quot.setVehicleMakeEn(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenMakeDesc() : "");
				quot.setVehicleMakeAr(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenMakeDesc() : "");
				quot.setVehicleModel(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getEskaModelId() : "");
				quot.setVehicleModelEn(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenModelEnglish() : "");
				quot.setVehicleModelAr(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenModelArabic() : "");
				quot.setVehicleChassisNo(savedCarInfo.getChassisNumber());
				quot.setVehicleColor(transformedVehicleColor);
				quot.setVehicleNationality(atmcYakeenMakeModel.getEskaVehNationalityId());
				quot.setVehicleCity(transformedCityCode);
			} else {
				if (carInfo.getErrorCode() != 0 && carInfo.getErrorMessage() != null) {
					throw new YaqeenException(carInfo.getErrorCode(),
							LanguageUtil.get(locale, "yaqeen_error_" + carInfo.getErrorCode()));
				} else {
					long sTime = System.currentTimeMillis();
					CodeMasterMap vehColorMap = CodeMasterMapLocalServiceUtil
							.findBySourceTypeSourceCode(ODS_SRC_TYPE_COLOR, carInfo.getMajorColor());
					CodeMasterMap cityMap = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode(ODS_SRC_TYPE_CITY,
							"" + carInfo.getRegCityLocationCode());
					CodeMasterMap vehPlateTypeMap = CodeMasterMapLocalServiceUtil
							.findBySourceTypeSourceCode(ODS_SRC_TYPE_PLATE_TYPE, "" + carInfo.getPlateTypeCode());
					String transformedCityCode = (cityMap != null) ? cityMap.getCoreCode() : null;
					String transformedPlateType = (vehPlateTypeMap != null) ? vehPlateTypeMap.getCoreCode() : null;
					String plateDesc = (vehPlateTypeMap != null) ? vehPlateTypeMap.getCoreDesc() : "";
					String transformedVehicleColor = (vehColorMap != null) ? vehColorMap.getCoreCode() : null;
					_log.info("VEHICLE CARD INFO CALLING for Vehicle make = " + carInfo.getVehicleMakerCode()
							+ "and model Code =  " + carInfo.getVehicleModelCode());
					try {
						atmcYakeenMakeModel = AtmcYakeenMakeModelLocalServiceUtil.findByYakeenMakeModelDetails(
								String.valueOf(String.valueOf(carInfo.getVehicleMakerCode())),
								String.valueOf(carInfo.getVehicleModelCode()));
					} catch (NoSuchAtmcYakeenMakeModelException e) {
						e.printStackTrace();
					}
					_log.info("recieved card details " + atmcYakeenMakeModel);

					quot.setVehiclePlateNo(carInfo.getPlateNumber());
					quot.setVehiclePlateL1(carInfo.getPlateText1());
					quot.setVehiclePlateL2(carInfo.getPlateText2());
					quot.setVehiclePlateL3(carInfo.getPlateText3());
					quot.setVehicleMfgYear(carInfo.getModelYear());
					quot.setVehiclePlateType(transformedPlateType);
					quot.setVehiclePlateTypeDesc(plateDesc);
					quot.setVehicleBodyType(atmcYakeenMakeModel.getEskaBodyTypeId());
					quot.setVehicleBodyTypeEn(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getAtmcBodyType() : "");
					quot.setVehicleBodyTypeAr(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getAtmcBodyType() : "");
					quot.setVehicleMake(atmcYakeenMakeModel.getEskaMakeId());
					quot.setVehicleMakeEn(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenMakeDesc() : "");
					quot.setVehicleMakeAr(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenMakeDesc() : "");
					quot.setVehicleModel(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getEskaModelId() : "");
					quot.setVehicleModelEn(
							atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenModelEnglish() : "");
					quot.setVehicleModelAr(
							atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenModelArabic() : "");
					quot.setVehicleChassisNo(carInfo.getChassisNumber());
					quot.setVehicleColor(transformedVehicleColor);
					quot.setVehicleNationality(atmcYakeenMakeModel.getEskaVehNationalityId());
					quot.setVehicleWeight(carInfo.getVehicleWeight());
					quot.setVehicleCapacity(carInfo.getVehicleLoad());
					quot.setVehicleCylinder(carInfo.getCylinders());
					quot.setVehicleCity(transformedCityCode);
					/*
					 * if(carInfo.getRegExpiryDate()!=null) { Date parsedDate = null; try {
					 * parsedDate = yakeenCarDateFormat.parse(carInfo.getRegExpiryDate()); } catch
					 * (ParseException e) { _log.error(e.getMessage()); e.printStackTrace(); }
					 * quot.setVehicleEstExpiryDate(parsedDate); }
					 */
					Date date = null;
					if (carInfo.getRegExpiryDate() != null) {
						try {
							date = new SimpleDateFormat("dd-MM-yyyy").parse(carInfo.getRegExpiryDate());
						} catch (ParseException e) {
							e.printStackTrace();
						}
						_log.info("new parsed date " + date);
						quot.setVehicleEstExpiryDate(date);
					}

				}
			}
		}

		return quot;
	}

	public Quotation getCustomerVehicleDetailsMob(Quotation quot, String addLang, Locale locale)
			throws YaqeenException, NajmException {
		SimpleDateFormat yakeenCarDateFormat = new SimpleDateFormat("dd-MM-YYYY");
		// SimpleDateFormat yakeenAddressHijriDateFormat = new
		// SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat yakeenAddressGregDateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String vehicleIdentifier = "" + quot.getVehicleIdType();
		String iqamaId = "" + quot.getInsuredId();
		String dobH = quot.getInsuredDobH();
		String vehSeqNo = "" + quot.getVehicleId();
		String dobG = dateFormat.format(quot.getInsuredDob());
		quot.setInsuredNationality("03");

		String mfgYear = "" + quot.getVehicleMfgYear();
		String addressDobHFormatted = "";
		String addressDobGFormatted = "";
		String dobHFormatted = "";
		String dobGFormatted = "";
		AtmcYakeenMakeModel atmcYakeenMakeModel = null;

		// NCD always retrieved from Najm service
		// Kareem Kahil 14/8/2018: As requested by Noman, in case of Transfer of
		// Ownership, we should pass the value 1 to ncdElegibility service not 3.
		// Confirmed by Arqum that
		// it should be that in design doc
		String vehicleIdentifierNajm = vehicleIdentifier;

		if (vehicleIdentifierNajm.equals("3")) // BuyMotorPolicyPortletKeys.VEHICLE_TRANSFER_OWNERSHIP_CARD
		{
			vehicleIdentifierNajm = "1";
		}

		_log.info("Invoking NDCEligibility opt");
		long s1Time = System.currentTimeMillis();
		com.atmc.mob.acl.ws.domain.NCDEligibility ncdRes = com.atmc.mob.acl.ws.service.NajmLocalServiceUtil
				.ncdEligibility(Long.valueOf(iqamaId), Integer.valueOf(vehicleIdentifierNajm), Long.valueOf(vehSeqNo));
		_log.info("Back from NCDELigibility");
		long period1 = System.currentTimeMillis() - s1Time;
		_log.info("ncdEligibility took " + period1 + " ms");
		_log.info(ncdRes);
		if (ncdRes != null && ncdRes.getStatusCode().equals(NCD_STATUS_CODE_SUCCESS)) {
			_log.info("Najm status code:" + ncdRes.getStatusCode());
			if (ncdRes.getNCDFreeYears() != null) {
				_log.info("Najm NCD Returned:" + ncdRes.getNCDFreeYears());
				quot.setNcdYears(Long.valueOf(ncdRes.getNCDFreeYears()));
			}
		} else
			throw new NajmException(Integer.valueOf(ncdRes.getStatusCode()), ncdRes.getErrorMsg());

		try {
			// Date hijriDob = dateFormat.parse(dobH);
			Date gregDob = dateFormat.parse(dobG);
			dobHFormatted = (dobH != null && !dobH.equals("")) ? (dobH.split("-")[1] + "-" + dobH.split("-")[0]) : null;
			addressDobHFormatted = (dobH != null && !dobH.equals(""))
					? (dobH.split("-")[2] + "-" + dobH.split("-")[1] + "-" + dobH.split("-")[0])
					: null;
			dobGFormatted = yakeenHijriDateFormat.format(gregDob);
			addressDobGFormatted = yakeenAddressGregDateFormat.format(gregDob);
		} catch (ParseException e) {
			e.printStackTrace();
			_log.error(e.getMessage());
		}

		com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest req = new com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest();
		req.setUsername(yaqeenUserName);
		req.setPassword(yaqeenPassword);
		req.setReferenceNumber(yaqeenRefNo);
		req.setChargeCode(yaqeenChargeCode);
		if (iqamaId.startsWith("1")) {
			quot.setInsuredIdType(ID_TYPE_SAUDI);

			_log.info("Yakeen ServiceRequest 1 >>>> " + req.toString());
			_log.info("dobHFormatted >>>> " + dobHFormatted);
			_log.info("iqamaId >>>> " + iqamaId);

			_log.info("Invoking getCitizenInfo");
			long s2Time = System.currentTimeMillis();
			com.atmc.mob.acl.ws.domain.yakeen.CitizenInfo citizenInfo = com.atmc.mob.acl.ws.service.YakeenLocalServiceUtil
					.getCitizenInfo(req, dobHFormatted, iqamaId);
			_log.info("Back from getCitizenInfo");
			long period2 = System.currentTimeMillis() - s2Time;
			_log.info("getCitizenInfo took " + period2 + " ms");

			if (citizenInfo.getErrorCode() != 0 && citizenInfo.getErrorMessage() != null) {
				throw new YaqeenException(citizenInfo.getErrorCode(),
						LanguageUtil.get(locale, "yaqeen_error_" + citizenInfo.getErrorCode()));
			} else {

				quot.setInsuredName(citizenInfo.getEnglishFirstName() + " " + citizenInfo.getEnglishSecondName() + " "
						+ citizenInfo.getEnglishThirdName() + " " + citizenInfo.getEnglishLastName());
				quot.setInsuredGender(citizenInfo.getGender());
				quot.setInsuredOccupationCode(citizenInfo.getOccupationCode());

				_log.info("Invoking getCitizenAddress");
				long sTime = System.currentTimeMillis();
				List<com.atmc.mob.acl.ws.domain.yakeen.AddressInfo> citizenAddrInfo = com.atmc.mob.acl.ws.service.YakeenLocalServiceUtil
						.getCitizenAddressInfo(req, iqamaId, addressDobHFormatted, addLang);
				_log.info("Back from getCitizenAddress");
				long period = System.currentTimeMillis() - sTime;
				_log.info("getCitizenAddressInfo took " + period + " ms");
				if (citizenAddrInfo != null && citizenAddrInfo.size() == 1 && citizenAddrInfo.get(0).getErrorCode() != 0
						&& citizenAddrInfo.get(0).getErrorMessage() != null) {
					throw new YaqeenException(citizenAddrInfo.get(0).getErrorCode(),
							LanguageUtil.get(locale, "yaqeen_error_" + citizenAddrInfo.get(0).getErrorCode()));
				} else {
					if (citizenAddrInfo != null && !citizenAddrInfo.isEmpty()) {
						com.atmc.mob.acl.ws.domain.yakeen.AddressInfo info = citizenAddrInfo.get(0);
						if (info.getBuildingNumber() == null && info.getDistrict() == null
								&& info.getStreetName() == null && info.getPostCode() == null
								&& info.getAdditionalNumber() == null && info.getCity() == null)
							throw new YaqeenException(YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED, "Generic Error");
						else {
							quot.setAddressBuildingNo(
									(info.getBuildingNumber() != null) ? Long.valueOf(info.getBuildingNumber()) : 0L);
							quot.setAddressDistrict(
									(info.getDistrict() != null) ? info.getDistrict().replaceAll("'", "") : null);
							quot.setAddressStreet(
									(info.getStreetName() != null) ? info.getStreetName().replaceAll("'", "") : null);
							quot.setAddressZipCode(
									(info.getPostCode() != null) ? Long.valueOf(info.getPostCode()) : 0L);
							quot.setAddressAddNo(
									(info.getAdditionalNumber() != null) ? Long.valueOf(info.getAdditionalNumber())
											: 0L);
							quot.setCityDesc((info.getCity() != null) ? info.getCity().replaceAll("'", "") : null);
						}
					} else
						throw new YaqeenException(YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED, "Generic Error");

				}
			}
		} else {
			quot.setInsuredIdType(ID_TYPE_IQAMA);
			_log.info("Invoking  getAlienInfoByIqamaDOB");
			long sTime = System.currentTimeMillis();
			com.atmc.mob.acl.ws.domain.yakeen.AlienInfo custInfo = com.atmc.mob.acl.ws.service.YakeenLocalServiceUtil
					.getAlienInfoByIqamaAndDOB(req, iqamaId, dobGFormatted);
			_log.info("Back from getAlienInfoByIqamaDOB");
			long period = System.currentTimeMillis() - sTime;
			_log.info("getAlienInfoByIqamaAndDOB took " + period + " ms");
			if (custInfo.getErrorCode() != 0 && custInfo.getErrorMessage() != null) {
				throw new YaqeenException(custInfo.getErrorCode(),
						LanguageUtil.get(locale, "yaqeen_error_" + custInfo.getErrorCode()));
			} else {
				long s2Time = System.currentTimeMillis();
				CodeMasterMap natMap = CodeMasterMapLocalServiceUtil
						.findBySourceTypeSourceCode(ODS_SRC_TYPE_NATIONALITY, "" + custInfo.getNationalityCode());
				long period2 = System.currentTimeMillis() - s2Time;
				_log.info("Nationality Lookup took " + period2 + " ms");
				String transformedNationality = (natMap != null) ? natMap.getCoreCode() : "";
				quot.setInsuredNationality(transformedNationality);
				quot.setInsuredName(custInfo.getEnglishFirstName() + " " + custInfo.getEnglishSecondName() + " "
						+ custInfo.getEnglishThirdName() + " " + custInfo.getEnglishLastName());
				quot.setInsuredGender(custInfo.getGender());
				quot.setInsuredOccupationCode(custInfo.getOccupationCode());
				quot.setInsuredMaritalStatus("" + custInfo.getSocialStatusCode());

				_log.info("Invoking getAlienAddress");
				long s3Time = System.currentTimeMillis();
				List<com.atmc.mob.acl.ws.domain.yakeen.AddressInfo> citizenAddrInfo = com.atmc.mob.acl.ws.service.YakeenLocalServiceUtil
						.getAlienAddressInfo(req, iqamaId, addressDobGFormatted, addLang);
				_log.info("Back from getAlienAddress");
				long period3 = System.currentTimeMillis() - s3Time;
				_log.info("getAlienAddressInfo took " + period3 + " ms");

				if (citizenAddrInfo != null && citizenAddrInfo.size() == 1 && citizenAddrInfo.get(0).getErrorCode() != 0
						&& citizenAddrInfo.get(0).getErrorMessage() != null) {
					throw new YaqeenException(citizenAddrInfo.get(0).getErrorCode(),
							LanguageUtil.get(locale, "yaqeen_error_" + citizenAddrInfo.get(0).getErrorCode()));
				} else {
					if (citizenAddrInfo != null && !citizenAddrInfo.isEmpty()) {
						com.atmc.mob.acl.ws.domain.yakeen.AddressInfo info = citizenAddrInfo.get(0);
						if (info.getBuildingNumber() == null && info.getDistrict() == null
								&& info.getStreetName() == null && info.getPostCode() == null
								&& info.getAdditionalNumber() == null && info.getCity() == null)
							throw new YaqeenException(YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED, "Generic Error");
						else {
							if (info.getBuildingNumber() != null)
								quot.setAddressBuildingNo(Long.valueOf(info.getBuildingNumber()));
							quot.setAddressDistrict(
									(info.getDistrict() != null) ? info.getDistrict().replaceAll("'", "") : null);
							quot.setAddressStreet(
									(info.getStreetName() != null) ? info.getStreetName().replaceAll("'", "") : null);
							if (info.getPostCode() != null)
								quot.setAddressZipCode(Long.valueOf(info.getPostCode()));
							if (info.getAdditionalNumber() != null)
								quot.setAddressAddNo(Long.valueOf(info.getAdditionalNumber()));
							quot.setCityDesc((info.getCity() != null) ? info.getCity().replaceAll("'", "") : null);
						}
					} else
						throw new YaqeenException(YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED, "Generic Error");
				}
			}
		}

		if (vehicleIdentifier.equals(VEHICLE_CUSTOM_CARD)) {

			_log.info("Invoking getCarInfoByCustom");
			long sTime = System.currentTimeMillis();
			com.atmc.mob.acl.ws.domain.yakeen.BasicCarInfo carInfo = com.atmc.mob.acl.ws.service.YakeenLocalServiceUtil
					.getCarInfoByCustom(req, vehSeqNo, Short.valueOf(mfgYear)); // getCarInfoByCustom
			_log.info("Back from getCarInfoByCustom");
			long period = System.currentTimeMillis() - sTime;
			_log.info("getCarInfoByCustom took " + period + " ms");
			if (carInfo.getErrorCode() != 0 && carInfo.getErrorMessage() != null) {
				throw new YaqeenException(carInfo.getErrorCode(),
						LanguageUtil.get(locale, "yaqeen_error_" + carInfo.getErrorCode()));
			} else {
				long s2Time = System.currentTimeMillis();

				CodeMasterMap vehColorMap = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode(ODS_SRC_TYPE_COLOR,
						carInfo.getMajorColor());

				_log.info("VEHICLE CARD INFO CALLING for Vehicle make = " + carInfo.getVehicleMakerCode()
						+ "and model Code =  " + carInfo.getVehicleModelCode());
				try {
					atmcYakeenMakeModel = AtmcYakeenMakeModelLocalServiceUtil.findByYakeenMakeModelDetails(
							String.valueOf(String.valueOf(carInfo.getVehicleMakerCode())),
							String.valueOf(carInfo.getVehicleModelCode()));
				} catch (NoSuchAtmcYakeenMakeModelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				_log.info("recieved card details " + atmcYakeenMakeModel);

				String transformedVehicleColor = (vehColorMap != null) ? vehColorMap.getCoreCode() : null;
				quot.setVehicleBodyType(atmcYakeenMakeModel.getEskaBodyTypeId());
				quot.setVehicleBodyTypeEn(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getAtmcBodyType() : "");
				quot.setVehicleBodyTypeAr(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getAtmcBodyType() : "");
				quot.setVehicleMake(atmcYakeenMakeModel.getEskaMakeId());
				quot.setVehicleMakeEn(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenMakeDesc() : "");
				quot.setVehicleMakeAr(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenMakeDesc() : "");
				quot.setVehicleModel(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getEskaModelId() : "");
				quot.setVehicleModelEn(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenModelEnglish() : "");
				quot.setVehicleModelAr(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenModelArabic() : "");
				quot.setVehicleNationality(atmcYakeenMakeModel.getEskaVehNationalityId());
				quot.setVehicleColor(transformedVehicleColor);
				quot.setVehicleWeight(carInfo.getVehicleWeight());
				quot.setVehicleCapacity(carInfo.getVehicleLoad());
				quot.setVehicleChassisNo(carInfo.getChassisNumber());
			}
		} else if (vehicleIdentifier.equals(VEHICLE_ISTIMARA_CARD)
				|| vehicleIdentifier.equals(VEHICLE_TRANSFER_OWNERSHIP_CARD)) {
			com.atmc.mob.acl.ws.domain.yakeen.CarInfo carInfo = null;
			long vSeqVal = Long.valueOf(vehSeqNo);
			if (vSeqVal < Integer.MIN_VALUE || vSeqVal > Integer.MAX_VALUE) {
				System.err.println("vehSeqNo:" + vehSeqNo + " cannot be cast to int without changing its value.");
			}
			if (iqamaId.startsWith("1")) {

				//// Ahmed AE Fattah : 14-04-2018
				//// As per Khatib's Mail To send the OLD Iqama/ID in case of transfer ownership
				//// to get his info as he is the current owner of the CAR
				String oldIqama = iqamaId;
				_log.info("vehicleIdentifier >>>>> " + vehicleIdentifier);
				_log.info("iqamaId Before >>>>> " + oldIqama);
				if (vehicleIdentifier.equals(VEHICLE_TRANSFER_OWNERSHIP_CARD))
					oldIqama = quot.getOldIqamaId();
				_log.info("iqamaId After >>>>> " + oldIqama);

				_log.info("Invoking getCitizenCarBySequence");
				long sTime = System.currentTimeMillis();
				carInfo = com.atmc.mob.acl.ws.service.YakeenLocalServiceUtil.getCitizenCarInfoBySequence(req,
						(int) (vSeqVal), Long.valueOf(oldIqama));// getCitizenCarInfoBySequence
				_log.info("Back from getCitizenCarBySequence");
				long period = System.currentTimeMillis() - sTime;
				_log.info("getCitizenCarBySequence took " + period + " ms");
			} else {
				String oldIqama = iqamaId;
				_log.info("vehicleIdentifier >>>>> " + vehicleIdentifier);
				_log.info("iqamaId Before >>>>> " + oldIqama);
				if (vehicleIdentifier.equals(VEHICLE_TRANSFER_OWNERSHIP_CARD))
					oldIqama = quot.getOldIqamaId();
				_log.info("iqamaId After >>>>> " + oldIqama);

				_log.info("Invoking getAlienCarSequence");
				long sTime = System.currentTimeMillis();
				carInfo = com.atmc.mob.acl.ws.service.YakeenLocalServiceUtil.getAlienCarInfoBySequence(req,
						Integer.valueOf(vehSeqNo), Long.valueOf(oldIqama)); // getAlienCarInfoBySequence
				_log.info("Back from getAlienCarSequence");
				long period = System.currentTimeMillis() - sTime;
				_log.info("getAlienCarInfoBySequence took " + period + " ms");
			}

			if (carInfo.getErrorCode() != 0 && carInfo.getErrorMessage() != null) {
				throw new YaqeenException(carInfo.getErrorCode(),
						LanguageUtil.get(locale, "yaqeen_error_" + carInfo.getErrorCode()));
			} else {

				long sTime = System.currentTimeMillis();
				CodeMasterMap vehColorMap = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode(ODS_SRC_TYPE_COLOR,
						carInfo.getMajorColor());
				CodeMasterMap cityMap = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode(ODS_SRC_TYPE_CITY,
						"" + carInfo.getRegCityLocationCode());
				_log.info("VEHICLE CARD INFO CALLING for Vehicle make = " + carInfo.getVehicleMakerCode()
						+ "and model Code =  " + carInfo.getVehicleModelCode());
				try {
					atmcYakeenMakeModel = AtmcYakeenMakeModelLocalServiceUtil.findByYakeenMakeModelDetails(
							String.valueOf(String.valueOf(carInfo.getVehicleMakerCode())),
							String.valueOf(carInfo.getVehicleModelCode()));
				} catch (NoSuchAtmcYakeenMakeModelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				_log.info("recieved card details " + atmcYakeenMakeModel);
				quot.setVehicleBodyType(atmcYakeenMakeModel.getEskaBodyTypeId());
				quot.setVehicleBodyTypeEn(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getAtmcBodyType() : "");
				quot.setVehicleBodyTypeAr(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getAtmcBodyType() : "");
				quot.setVehicleMake(atmcYakeenMakeModel.getEskaMakeId());
				quot.setVehicleMakeEn(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenMakeDesc() : "");
				quot.setVehicleMakeAr(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenMakeDesc() : "");
				quot.setVehicleModel(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getEskaModelId() : "");
				quot.setVehicleModelEn(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenModelEnglish() : "");
				quot.setVehicleModelAr(atmcYakeenMakeModel != null ? atmcYakeenMakeModel.getYakeenModelArabic() : "");
				quot.setVehicleNationality(atmcYakeenMakeModel.getEskaVehNationalityId());
				String transformedCityCode = (cityMap != null) ? cityMap.getCoreCode() : null;
				quot.setVehiclePlateNo(carInfo.getPlateNumber());
				quot.setVehiclePlateL1(carInfo.getPlateText1());
				quot.setVehiclePlateL2(carInfo.getPlateText2());
				quot.setVehiclePlateL3(carInfo.getPlateText3());
				quot.setVehicleMfgYear(carInfo.getModelYear());
				quot.setVehicleWeight(carInfo.getVehicleWeight());
				quot.setVehicleCapacity(carInfo.getVehicleLoad());
				quot.setVehicleCylinder(carInfo.getCylinders());
				// Kareem Fix: This color mapping was missed
				quot.setVehicleChassisNo(carInfo.getChassisNumber());
				String transformedVehicleColor = (vehColorMap != null) ? vehColorMap.getCoreCode() : null;
				quot.setVehicleColor(transformedVehicleColor);
				// End Kareem Fix
				/*
				 * if(carInfo.getRegExpiryDate()!=null) { Date parsedDate = null; try {
				 * parsedDate = yakeenCarDateFormat.parse(carInfo.getRegExpiryDate()); } catch
				 * (ParseException e) { _log.error(e.getMessage()); e.printStackTrace(); }
				 * quot.setVehicleEstExpiryDate(parsedDate); }
				 */
				Date date = null;
				if (carInfo.getRegExpiryDate() != null) {
					try {
						date = new SimpleDateFormat("dd-MM-yyyy").parse(carInfo.getRegExpiryDate());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					_log.info("new parsed date " + date);
					quot.setVehicleEstExpiryDate(date);
				}
				quot.setVehicleCity(transformedCityCode);
			}
		}

		return quot;
	}

	public void getDriverVehicleDetails(QuotationDriver driver, HttpServletRequest request, boolean isRelative)
			throws YaqeenException {
		NCDEligibility ncdRes = null;
		if (isRelative)
			ncdRes = NajmLocalServiceUtil.ncdEligibility(driver.getDriverId(), Integer.valueOf(3), Long.valueOf(0));
		if ((!isRelative) || (isRelative && ncdRes != null && ncdRes.getStatusCode().equals(NCD_STATUS_CODE_SUCCESS))) {
			if (isRelative && ncdRes.getNCDFreeYears() != null)
				driver.setNcdYears(Integer.valueOf(ncdRes.getNCDFreeYears()));

			ServiceRequest req = new ServiceRequest();
			req.setUsername(yaqeenUserName);
			req.setPassword(yaqeenPassword);
			req.setReferenceNumber(yaqeenRefNo);
			req.setChargeCode(yaqeenChargeCode);
			if (("" + driver.getDriverId()).startsWith("1")) {
				Date hijriDob = null;
				try {
					hijriDob = driverDateFormat.parse(driver.getDriverDobH());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				String dobHFormatted = yakeenHijriDateFormat.format(hijriDob);
				CitizenInfo citizenInfo = YakeenLocalServiceUtil.getCitizenInfo(req, dobHFormatted,
						"" + driver.getDriverId());

				if (citizenInfo.getErrorCode() != 0 && citizenInfo.getErrorMessage() != null) {
					throw new YaqeenException(citizenInfo.getErrorCode(),
							citizenInfo.getErrorMessage() + " ." + LanguageUtil.get(request, "ncd_driver_error"));
				} else {
					driver.setDriverName(citizenInfo.getEnglishFirstName() + " " + citizenInfo.getEnglishSecondName()
							+ " " + citizenInfo.getEnglishThirdName() + " " + citizenInfo.getEnglishLastName());
					driver.setDriverGender(citizenInfo.getGender());
					driver.setDriverNationality("03");
					// driver.setInsuredOccupationCode(citizenInfo.getOccupationCode());
				}
			} else {
				AlienInfo custInfo = YakeenLocalServiceUtil.getAlienInfoByIqamaAndDOB(req, "" + driver.getDriverId(),
						yakeenHijriDateFormat.format(driver.getDriverDob()));
				if (custInfo.getErrorCode() != 0 && custInfo.getErrorMessage() != null) {
					throw new YaqeenException(custInfo.getErrorCode(),
							custInfo.getErrorMessage() + " " + LanguageUtil.get(request, "ncd_driver_error"));
				} else {
					CodeMasterMap natMap = CodeMasterMapLocalServiceUtil
							.findBySourceTypeSourceCode(ODS_SRC_TYPE_NATIONALITY, "" + custInfo.getNationalityCode());
					String transformedNationality = (natMap != null) ? natMap.getCoreCode() : "";
					driver.setDriverName(custInfo.getEnglishFirstName() + " " + custInfo.getEnglishSecondName() + " ."
							+ custInfo.getEnglishThirdName() + " " + custInfo.getEnglishLastName());
					driver.setDriverGender(custInfo.getGender());
					driver.setDriverNationality(transformedNationality);
					// driver.setDriverMaritalStatus(""+custInfo.getSocialStatusCode());
					// driver.setInsuredOccupationCode(custInfo.getOccupationCode());
				}
			}
		} else {
			throw new YaqeenException(Integer.valueOf(ncdRes.getStatusCode()),
					LanguageUtil.get(request, "ncd_driver_error"));
		}
	}

	public void getDriverVehicleDetailsMob(QuotationDriver driver, HttpServletRequest request, boolean isRelative)
			throws YaqeenException {
		com.atmc.mob.acl.ws.domain.NCDEligibility ncdRes = null;
		if (isRelative)
			ncdRes = com.atmc.mob.acl.ws.service.NajmLocalServiceUtil.ncdEligibility(driver.getDriverId(),
					Integer.valueOf(3), Long.valueOf(0));
		if ((!isRelative) || (isRelative && ncdRes != null && ncdRes.getStatusCode().equals(NCD_STATUS_CODE_SUCCESS))) {
			if (isRelative && ncdRes.getNCDFreeYears() != null)
				driver.setNcdYears(Integer.valueOf(ncdRes.getNCDFreeYears()));

			com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest req = new com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest();
			req.setUsername(yaqeenUserName);
			req.setPassword(yaqeenPassword);
			req.setReferenceNumber(yaqeenRefNo);
			req.setChargeCode(yaqeenChargeCode);
			if (("" + driver.getDriverId()).startsWith("1")) {
				Date hijriDob = null;
				try {
					hijriDob = driverDateFormat.parse(driver.getDriverDobH());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				String dobHFormatted = yakeenHijriDateFormat.format(hijriDob);
				com.atmc.mob.acl.ws.domain.yakeen.CitizenInfo citizenInfo = com.atmc.mob.acl.ws.service.YakeenLocalServiceUtil
						.getCitizenInfo(req, dobHFormatted, "" + driver.getDriverId());

				if (citizenInfo.getErrorCode() != 0 && citizenInfo.getErrorMessage() != null) {
					throw new YaqeenException(citizenInfo.getErrorCode(),
							citizenInfo.getErrorMessage() + " ." + LanguageUtil.get(request, "ncd_driver_error"));
				} else {
					driver.setDriverName(citizenInfo.getEnglishFirstName() + " " + citizenInfo.getEnglishSecondName()
							+ " " + citizenInfo.getEnglishThirdName() + " " + citizenInfo.getEnglishLastName());
					driver.setDriverGender(citizenInfo.getGender());
					driver.setDriverNationality("03");
					// driver.setInsuredOccupationCode(citizenInfo.getOccupationCode());
				}
			} else {
				com.atmc.mob.acl.ws.domain.yakeen.AlienInfo custInfo = com.atmc.mob.acl.ws.service.YakeenLocalServiceUtil
						.getAlienInfoByIqamaAndDOB(req, "" + driver.getDriverId(),
								yakeenHijriDateFormat.format(driver.getDriverDob()));
				if (custInfo.getErrorCode() != 0 && custInfo.getErrorMessage() != null) {
					throw new YaqeenException(custInfo.getErrorCode(),
							custInfo.getErrorMessage() + " " + LanguageUtil.get(request, "ncd_driver_error"));
				} else {
					CodeMasterMap natMap = CodeMasterMapLocalServiceUtil
							.findBySourceTypeSourceCode(ODS_SRC_TYPE_NATIONALITY, "" + custInfo.getNationalityCode());
					String transformedNationality = (natMap != null) ? natMap.getCoreCode() : "";
					driver.setDriverName(custInfo.getEnglishFirstName() + " " + custInfo.getEnglishSecondName() + " ."
							+ custInfo.getEnglishThirdName() + " " + custInfo.getEnglishLastName());
					driver.setDriverGender(custInfo.getGender());
					driver.setDriverNationality(transformedNationality);
					// driver.setDriverMaritalStatus(""+custInfo.getSocialStatusCode());
					// driver.setInsuredOccupationCode(custInfo.getOccupationCode());
				}
			}
		} else {
			throw new YaqeenException(Integer.valueOf(ncdRes.getStatusCode()),
					LanguageUtil.get(request, "ncd_driver_error"));
		}
	}
}