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

package com.ejada.atmc.acl.ws.service.impl;

import com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.AlienDepInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.AlienLegalStatusInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.BasicCarInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.CarInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.CitizenInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.CompanyInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest;
import com.ejada.atmc.acl.ws.domain.yakeen.ServiceResponse;
import com.ejada.atmc.acl.ws.marshal.yakeen.AddressInfoUnmarshaller;
import com.ejada.atmc.acl.ws.marshal.yakeen.CarInfoUnmarshaller;
import com.ejada.atmc.acl.ws.marshal.yakeen.InfoMarshaller;
import com.ejada.atmc.acl.ws.marshal.yakeen.InfoUnmarshaller;
import com.ejada.atmc.acl.ws.marshal.yakeen.PersonalInfoUnmarshaller;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienAddressInfoRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienAddressInfoResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienAllDepInfoByIqamaRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienAllDepInfoByIqamaResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienCarInfoBySequenceRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienCarInfoBySequenceResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienInfoByBorderNumberRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienInfoByBorderNumberResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienInfoByIqamaAndDOBRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienInfoByIqamaAndDOBResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienInfoByIqamaRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienInfoByIqamaResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienLegalStatusInfoRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienLegalStatusInfoResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienSingleDepInfoByIqamaRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienSingleDepInfoByIqamaResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.CarInfoByCustomRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.CarInfoByCustomResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.CitizenAddressInfoRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.CitizenAddressInfoResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.CitizenCarInfoBySequenceRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.CitizenCarInfoBySequenceResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.CitizenInfoRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.CitizenInfoResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.CompanyAddressInfoByCrRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.CompanyAddressInfoByCrResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.CompanyCarInfoBySequenceRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.CompanyCarInfoBySequenceResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.CompanyInfoBySponseredIqamaRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.CompanyInfoBySponseredIqamaResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.Yakeen4AlinmaTM;
import com.ejada.atmc.acl.ws.proxy.yakeen.Yakeen4AlinmaTMFault_Exception;
import com.ejada.atmc.acl.ws.proxy.yakeen.Yakeen4AlinmaTMService;
import com.ejada.atmc.acl.ws.security.WSLogHandler;
import com.ejada.atmc.acl.ws.service.base.YakeenLocalServiceBaseImpl;
import com.ejada.atmc.acl.ws.utils.SOAPUtils;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the yakeen local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.ws.service.YakeenLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    YakeenLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.ejada.atmc.acl.ws.model.Yakeen",
		service = AopService.class
)
public class YakeenLocalServiceImpl extends YakeenLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ejada.atmc.acl.ws.service.YakeenLocalServiceUtil} to
	 * access the yakeen local service.
	 */

	private String				yaqeenEndPointAddress	= PropsUtil.get("com.ejada.atmc.yaqeen.endpointaddress");
	private static final int	ERROR_CODE_GENERIC		= 9999;
	private static final String	ERROR_TYPE_GENERIC		= "GEN";
	private static final String	ERROR_MSG_GENERIC		= "Generic Error";

	public AlienInfo getAlienInfoByIqama(ServiceRequest svcRequest, String iqamaNumber, String sponsorId) {

		try {

			// marshal request
			AlienInfoByIqamaRequest request = InfoMarshaller.marshalAlienInfoByIqama(svcRequest, iqamaNumber, sponsorId);

			// call service
			AlienInfoByIqamaResult response = getPort().getAlienInfoByIqama(request);

			// unmarshall response
			return PersonalInfoUnmarshaller.unmarshalAlienInfoByIqama(response);
		} catch (Exception e) {
			AlienInfo response = new AlienInfo();
			handleError(e, response);
			return response;
		}
	}

	public AlienInfo getAlienInfoByIqamaAndDOB(ServiceRequest svcRequest, String iqamaNumber, String dateOfBirth) {

		try {
			String alienInfoDets = null;
			// marshal request
			AlienInfoByIqamaAndDOBRequest request = InfoMarshaller.marshalAlienInfoByIqamaAndDOB(svcRequest, iqamaNumber, dateOfBirth);

			// call service
			AlienInfoByIqamaAndDOBResult response = getPort().getAlienInfoByIqamaAndDOB(request);

			// unmarshall response
			AlienInfo alienInfo = PersonalInfoUnmarshaller.unmarshalAlienInfoByIqamaAndDOB(response);
			_log.info("inside yakeen info");
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(AlienInfo.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				StringWriter st = new StringWriter();
				jaxbMarshaller.marshal(alienInfo, st);
				alienInfoDets = st.toString();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
			SOAPUtils.updateOrSaveYakeenDataAlienInfo(alienInfo, iqamaNumber, alienInfoDets);
			return alienInfo;
		} catch (Exception e) {
			AlienInfo response = new AlienInfo();
			handleError(e, response);
			return response;
		}
	}

	public AlienInfo getAlienInfoByBorderNumber(ServiceRequest svcRequest, String borderNumber, String sponsorId) {

		try {

			// marshal request
			AlienInfoByBorderNumberRequest request = InfoMarshaller.marshalAlienInfoByBorderNo(svcRequest, borderNumber, sponsorId);

			// call service
			AlienInfoByBorderNumberResult response = getPort().getAlienInfoByBorderNumber(request);

			// unmarshall response
			return PersonalInfoUnmarshaller.unmarshalAlienInfoByBorderNumber(response);
		} catch (Exception e) {
			AlienInfo response = new AlienInfo();
			handleError(e, response);
			return response;
		}
	}

	public CitizenInfo getCitizenInfo(ServiceRequest svcRequest, String dateOfBirthH, String nin) {

		try {
			String outputXml = null;
			// marshal request
			CitizenInfoRequest request = InfoMarshaller.marshalCitizenInfo(svcRequest, dateOfBirthH, nin);

			// call service
			CitizenInfoResult response = getPort().getCitizenInfo(request);

			// unmarshall response
			CitizenInfo citizenInfo = PersonalInfoUnmarshaller.unmarshalCitizenInfo(response);

			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(CitizenInfo.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				StringWriter st = new StringWriter();
				jaxbMarshaller.marshal(citizenInfo, st);
				outputXml = st.toString();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
			SOAPUtils.updateOrSaveYakeenData(citizenInfo, nin, outputXml);
			return citizenInfo;
		} catch (Exception e) {
			CitizenInfo response = new CitizenInfo();
			handleError(e, response);
			return response;
		}
	}

	public List<AlienDepInfo> getAlienAllDepInfoByIqama(ServiceRequest svcRequest, String iqamaNumber, String depIqama) {

		try {

			// marshal request
			AlienAllDepInfoByIqamaRequest request = InfoMarshaller.marshalAlienAllDepInfoByIqama(svcRequest, iqamaNumber, depIqama);

			// call service
			AlienAllDepInfoByIqamaResult response = getPort().getAlienAllDepInfoByIqama(request);

			// unmarshall response
			return PersonalInfoUnmarshaller.unmarshalAlienAllDepInfoByIqama(response);
		} catch (Exception e) {
			List<AlienDepInfo> alienList = new ArrayList<AlienDepInfo>();
			AlienDepInfo response = new AlienDepInfo();
			handleError(e, response);
			alienList.add(response);
			return alienList;
		}
	}

	public List<AlienDepInfo> getAlienSingleDepInfoByIqama(ServiceRequest svcRequest, String iqamaNumber, String depIqama) {

		try {

			// marshal request
			AlienSingleDepInfoByIqamaRequest request = InfoMarshaller.marshalAlienSingleDepInfoByIqama(svcRequest, iqamaNumber, depIqama);

			// call service
			AlienSingleDepInfoByIqamaResult response = getPort().getAlienSingleDepInfoByIqama(request);

			// unmarshall response
			return PersonalInfoUnmarshaller.unmarshalAlienSingleDepInfoByIqama(response);
		} catch (Exception e) {
			List<AlienDepInfo> alienList = new ArrayList<AlienDepInfo>();
			AlienDepInfo response = new AlienDepInfo();
			handleError(e, response);
			alienList.add(response);
			return alienList;
		}
	}

	public BasicCarInfo getCarInfoByCustom(ServiceRequest svcRequest, String customCardNumber, short modelYear) {

		try {

			// marshal request
			CarInfoByCustomRequest request = InfoMarshaller.marshalCarInfoByCustom(svcRequest, customCardNumber, modelYear);

			// call service
			CarInfoByCustomResult response = getPort().getCarInfoByCustom(request);

			// unmarshall response
			return CarInfoUnmarshaller.unmarshalBasicCarInfo(response);
		} catch (Exception e) {
			BasicCarInfo response = new BasicCarInfo();
			handleError(e, response);
			return response;
		}
	}

	public CarInfo getAlienCarInfoBySequence(ServiceRequest svcRequest, int sequenceNumber, long ownerIqamaNumber) {

		try {
			String alienCarInfo = null;
			// marshal request
			AlienCarInfoBySequenceRequest request = InfoMarshaller.marshalAlienCarInfoBySequence(svcRequest, sequenceNumber, ownerIqamaNumber);

			// call service
			AlienCarInfoBySequenceResult response = getPort().getAlienCarInfoBySequence(request);

			// unmarshall response
			CarInfo alienCarInfoBySeq = CarInfoUnmarshaller.unmarshalCarInfo(response);
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(CarInfo.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				StringWriter st = new StringWriter();
				jaxbMarshaller.marshal(alienCarInfoBySeq, st);
				alienCarInfo = st.toString();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
			SOAPUtils.updateAlienCarInfo(alienCarInfoBySeq, String.valueOf(ownerIqamaNumber), alienCarInfo, String.valueOf(sequenceNumber));
			return alienCarInfoBySeq;
		} catch (Exception e) {
			CarInfo response = new CarInfo();
			handleError(e, response);
			return response;
		}
	}

	public CarInfo getCompanyCarInfoBySequence(ServiceRequest svcRequest, int sequenceNumber, long companyMOINumber) {

		try {

			// marshal request
			CompanyCarInfoBySequenceRequest request = InfoMarshaller.marshalCompanyCarInfoBySequence(svcRequest, sequenceNumber, companyMOINumber);

			// call service
			CompanyCarInfoBySequenceResult response = getPort().getCompanyCarInfoBySequence(request);

			// unmarshall response
			return CarInfoUnmarshaller.unmarshalCarInfo(response);
		} catch (Exception e) {
			CarInfo response = new CarInfo();
			handleError(e, response);
			return response;
		}
	}

	public CarInfo getCitizenCarInfoBySequence(ServiceRequest svcRequest, int sequenceNumber, long ownerNin) {

		try {
			String carInfo = null;
			// marshal request
			CitizenCarInfoBySequenceRequest request = InfoMarshaller.marshalCitizenCarInfoBySequence(svcRequest, sequenceNumber, ownerNin);

			// call service
			CitizenCarInfoBySequenceResult response = getPort().getCitizenCarInfoBySequence(request);

			// unmarshall response
			CarInfo citizenCarInfoBySeq = CarInfoUnmarshaller.unmarshalCarInfo(response);
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(CarInfo.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				StringWriter st = new StringWriter();
				jaxbMarshaller.marshal(citizenCarInfoBySeq, st);
				carInfo = st.toString();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
			SOAPUtils.updateCitizenCarInfo(citizenCarInfoBySeq, String.valueOf(ownerNin), carInfo, String.valueOf(sequenceNumber));
			return citizenCarInfoBySeq;
		} catch (Exception e) {
			CarInfo response = new CarInfo();
			handleError(e, response);
			return response;
		}
	}

	public AlienLegalStatusInfo getAlienLegalStatusInfo(ServiceRequest svcRequest, String iqamaNumber, String sponsorId) {

		try {

			// marshal request
			AlienLegalStatusInfoRequest request = InfoMarshaller.marshalAlienLegalStatusInfo(svcRequest, iqamaNumber, sponsorId);

			// call service
			AlienLegalStatusInfoResult response = getPort().getAlienLegalStatusInfo(request);

			// unmarshall response
			return InfoUnmarshaller.unmarshalAlienLegalStatusInfo(response);
		} catch (Exception e) {
			AlienLegalStatusInfo response = new AlienLegalStatusInfo();
			handleError(e, response);
			return response;
		}
	}

	public CompanyInfo getCompanyInfoBySponseredIqama(ServiceRequest svcRequest, String iqamaNumber, String sponsorNumber, String depIqama) {

		try {

			// marshal request
			CompanyInfoBySponseredIqamaRequest request = InfoMarshaller.marshalCompanyInfoBySponseredIqama(svcRequest, iqamaNumber, sponsorNumber, depIqama);

			// call service
			CompanyInfoBySponseredIqamaResult response = getPort().getCompanyInfoBySponseredIqama(request);

			// unmarshall response
			return InfoUnmarshaller.unmarshalCompanyInfo(response);
		} catch (Exception e) {
			CompanyInfo response = new CompanyInfo();
			handleError(e, response);
			return response;
		}
	}

	public List<AddressInfo> getAlienAddressInfo(ServiceRequest svcRequest, String iqamaNumber, String dateOfBirth, String addressLanguage) {

		try {
			_log.info("Inside getAlienAddressInfo : .........................................");
			// marshal request
			AlienAddressInfoRequest request = InfoMarshaller.marshalAlienAddressInfo(svcRequest, iqamaNumber, dateOfBirth, addressLanguage);

			// call service
			AlienAddressInfoResult response = getPort().getAlienAddressInfo(request);
			
			_log.info("Response Of getAlienAddressInfo : ......................................." + response);	//This line is not getting printed!!! So, the above line throws the error...

			// unmarshall response
			return AddressInfoUnmarshaller.unmarshalAlienAddressInfo(response);
		} catch (Yakeen4AlinmaTMFault_Exception e) {
			_log.info("Yakeen4AlinmaTMFault_Exception occurred!");
			List<AddressInfo> addressList = new ArrayList<>();
			AddressInfo response = new AddressInfo();
			handleError(e, response);
			addressList.add(response);
			return addressList;
		}
	}

	public List<AddressInfo> getCitizenAddressInfo(ServiceRequest svcRequest, String nin, String dateOfBirth, String addressLanguage) {

		try {
			_log.info("Inside getCitizenAddressInfo : .........................................");
			//marshal request
			CitizenAddressInfoRequest request = InfoMarshaller.marshalCitizenAddressInfo(svcRequest, nin, dateOfBirth, addressLanguage);
			
			// call service
			CitizenAddressInfoResult response = getPort().getCitizenAddressInfo(request);
			
			_log.info("Response Of getCitizenAddressInfo : ......................................." + response);	//This line is not getting printed!!! So, the above line throws the error...
			// unmarshall response
			return AddressInfoUnmarshaller.unmarshalCitizenAddressInfo(response);
		} catch (Exception e) {
			List<AddressInfo> addressList = new ArrayList<AddressInfo>();
			AddressInfo response = new AddressInfo();
			handleError(e, response);
			addressList.add(response);
			return addressList;
		}
	}

	public List<AddressInfo> getCompanyAddressInfoByCr(ServiceRequest svcRequest, long crNumber, String addressLanguage) {

		try {

			// marshal request
			CompanyAddressInfoByCrRequest request = InfoMarshaller.marshalCompanyAddressInfoByCr(svcRequest, crNumber, addressLanguage);

			// call service
			CompanyAddressInfoByCrResult response = getPort().getCompanyAddressInfoByCr(request);

			// unmarshall response
			return AddressInfoUnmarshaller.unmarshalCompanyAddressInfoByCr(response);
		} catch (Exception e) {
			List<AddressInfo> addressList = new ArrayList<AddressInfo>();
			AddressInfo response = new AddressInfo();
			handleError(e, response);
			addressList.add(response);
			return addressList;
		}
	}

	private void handleError(Exception e, ServiceResponse response) {
		e.printStackTrace();
		if (e instanceof Yakeen4AlinmaTMFault_Exception) {
			Yakeen4AlinmaTMFault_Exception yakeenException = (Yakeen4AlinmaTMFault_Exception) e;
			response.setErrorCode(yakeenException.getFaultInfo().getCommonErrorObject().getErrorCode());
			response.setErrorMessage(yakeenException.getFaultInfo().getCommonErrorObject().getErrorMessage());
			response.setErrorType(yakeenException.getFaultInfo().getCommonErrorObject().getType());
		} else {
			response.setErrorCode(ERROR_CODE_GENERIC);
			response.setErrorMessage(ERROR_MSG_GENERIC);
			response.setErrorType(ERROR_TYPE_GENERIC);
		}
	}

	private Yakeen4AlinmaTM getPort() {

		Yakeen4AlinmaTMService service = new Yakeen4AlinmaTMService();
		Yakeen4AlinmaTM port = service.getYakeen4AlinmaTMPort();

		BindingProvider bp = (BindingProvider) port;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, yaqeenEndPointAddress);

		List<Handler> handlerList = bp.getBinding().getHandlerChain();
		if (handlerList == null)
			handlerList = new ArrayList<Handler>();

		handlerList.add(new WSLogHandler());

		bp.getBinding().setHandlerChain(handlerList);

		return port;

	}

	Log _log = LogFactoryUtil.getLog(YakeenLocalServiceImpl.class);
}