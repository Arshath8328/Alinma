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

package com.atmc.mob.acl.ws.service.impl;

import com.atmc.mob.acl.ws.domain.yakeen.AddressInfo;
import com.atmc.mob.acl.ws.domain.yakeen.AlienDepInfo;
import com.atmc.mob.acl.ws.domain.yakeen.AlienInfo;
import com.atmc.mob.acl.ws.domain.yakeen.AlienLegalStatusInfo;
import com.atmc.mob.acl.ws.domain.yakeen.BasicCarInfo;
import com.atmc.mob.acl.ws.domain.yakeen.CarInfo;
import com.atmc.mob.acl.ws.domain.yakeen.CitizenInfo;
import com.atmc.mob.acl.ws.domain.yakeen.CompanyInfo;
import com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest;
import com.atmc.mob.acl.ws.domain.yakeen.ServiceResponse;
import com.atmc.mob.acl.ws.marshal.yakeen.AddressInfoUnmarshaller;
import com.atmc.mob.acl.ws.marshal.yakeen.CarInfoUnmarshaller;
import com.atmc.mob.acl.ws.marshal.yakeen.InfoMarshaller;
import com.atmc.mob.acl.ws.marshal.yakeen.InfoUnmarshaller;
import com.atmc.mob.acl.ws.marshal.yakeen.PersonalInfoUnmarshaller;
import com.atmc.mob.acl.ws.proxy.yakeen.AlienAddressInfoRequest;
import com.atmc.mob.acl.ws.proxy.yakeen.AlienAddressInfoResult;
import com.atmc.mob.acl.ws.proxy.yakeen.AlienAllDepInfoByIqamaRequest;
import com.atmc.mob.acl.ws.proxy.yakeen.AlienAllDepInfoByIqamaResult;
import com.atmc.mob.acl.ws.proxy.yakeen.AlienCarInfoBySequenceRequest;
import com.atmc.mob.acl.ws.proxy.yakeen.AlienCarInfoBySequenceResult;
import com.atmc.mob.acl.ws.proxy.yakeen.AlienInfoByBorderNumberRequest;
import com.atmc.mob.acl.ws.proxy.yakeen.AlienInfoByBorderNumberResult;
import com.atmc.mob.acl.ws.proxy.yakeen.AlienInfoByIqamaAndDOBRequest;
import com.atmc.mob.acl.ws.proxy.yakeen.AlienInfoByIqamaAndDOBResult;
import com.atmc.mob.acl.ws.proxy.yakeen.AlienInfoByIqamaRequest;
import com.atmc.mob.acl.ws.proxy.yakeen.AlienInfoByIqamaResult;
import com.atmc.mob.acl.ws.proxy.yakeen.AlienLegalStatusInfoRequest;
import com.atmc.mob.acl.ws.proxy.yakeen.AlienLegalStatusInfoResult;
import com.atmc.mob.acl.ws.proxy.yakeen.AlienSingleDepInfoByIqamaRequest;
import com.atmc.mob.acl.ws.proxy.yakeen.AlienSingleDepInfoByIqamaResult;
import com.atmc.mob.acl.ws.proxy.yakeen.CarInfoByCustomRequest;
import com.atmc.mob.acl.ws.proxy.yakeen.CarInfoByCustomResult;
import com.atmc.mob.acl.ws.proxy.yakeen.CitizenAddressInfoRequest;
import com.atmc.mob.acl.ws.proxy.yakeen.CitizenAddressInfoResult;
import com.atmc.mob.acl.ws.proxy.yakeen.CitizenCarInfoBySequenceRequest;
import com.atmc.mob.acl.ws.proxy.yakeen.CitizenCarInfoBySequenceResult;
import com.atmc.mob.acl.ws.proxy.yakeen.CitizenInfoRequest;
import com.atmc.mob.acl.ws.proxy.yakeen.CitizenInfoResult;
import com.atmc.mob.acl.ws.proxy.yakeen.CompanyAddressInfoByCrRequest;
import com.atmc.mob.acl.ws.proxy.yakeen.CompanyAddressInfoByCrResult;
import com.atmc.mob.acl.ws.proxy.yakeen.CompanyCarInfoBySequenceRequest;
import com.atmc.mob.acl.ws.proxy.yakeen.CompanyCarInfoBySequenceResult;
import com.atmc.mob.acl.ws.proxy.yakeen.CompanyInfoBySponseredIqamaRequest;
import com.atmc.mob.acl.ws.proxy.yakeen.CompanyInfoBySponseredIqamaResult;
import com.atmc.mob.acl.ws.proxy.yakeen.Yakeen4AlinmaTM;
import com.atmc.mob.acl.ws.proxy.yakeen.Yakeen4AlinmaTMFault_Exception;
import com.atmc.mob.acl.ws.proxy.yakeen.Yakeen4AlinmaTMService;
import com.atmc.mob.acl.ws.security.WSLogHandler;
import com.atmc.mob.acl.ws.service.base.YakeenLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.util.PropsUtil;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the yakeen local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.atmc.mob.acl.ws.service.YakeenLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see YakeenLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.atmc.mob.acl.ws.model.Yakeen",
	service = AopService.class
)
public class YakeenLocalServiceImpl extends YakeenLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ejada.atmc.acl.mob.ws.service.YakeenLocalServiceUtil} to access the yakeen local service.
	 */
	private String yaqeenEndPointAddress = PropsUtil.get("com.ejada.atmc.yaqeen.endpointaddress");//"http://localhost:8095/Yakeen4AlinmaTM/Yakeen4AlinmaTM";
	private static final int ERROR_CODE_GENERIC = 9999;
	private static final String ERROR_TYPE_GENERIC = "GEN";
	private static final String ERROR_MSG_GENERIC = "Generic Error";
	
	public AlienInfo getAlienInfoByIqama(ServiceRequest svcRequest,String iqamaNumber, String sponsorId)
	{
		
		try 
		{
			
			//marshal request
			AlienInfoByIqamaRequest request = InfoMarshaller.marshalAlienInfoByIqama(svcRequest, iqamaNumber, sponsorId);
			
			// call service
			AlienInfoByIqamaResult response = getPort().getAlienInfoByIqama(request);
			
			// unmarshall response
			return PersonalInfoUnmarshaller.unmarshalAlienInfoByIqama(response);
		} 
		catch (Exception e) 
		{
			AlienInfo response = new AlienInfo();
			handleError(e, response);
			return response;
		}
	}
	
	public AlienInfo getAlienInfoByIqamaAndDOB(ServiceRequest svcRequest,String iqamaNumber, String dateOfBirth)
	{
		
		try 
		{
			
			//marshal request
			AlienInfoByIqamaAndDOBRequest request = InfoMarshaller.marshalAlienInfoByIqamaAndDOB(svcRequest, iqamaNumber, dateOfBirth);
			
			// call service
			AlienInfoByIqamaAndDOBResult response = getPort().getAlienInfoByIqamaAndDOB(request);
			
			// unmarshall response
			return PersonalInfoUnmarshaller.unmarshalAlienInfoByIqamaAndDOB(response);
		} 
		catch (Exception e) 
		{
			AlienInfo response = new AlienInfo();
			handleError(e, response);
			return response;
		}
	}

	
	public AlienInfo getAlienInfoByBorderNumber(ServiceRequest svcRequest,String borderNumber, String sponsorId)
	{
		
		try 
		{
			
			//marshal request
			AlienInfoByBorderNumberRequest request = InfoMarshaller.marshalAlienInfoByBorderNo(svcRequest, borderNumber, sponsorId);
			
			// call service
			AlienInfoByBorderNumberResult response = getPort().getAlienInfoByBorderNumber(request);
			
			// unmarshall response
			return PersonalInfoUnmarshaller.unmarshalAlienInfoByBorderNumber(response);
		} 
		catch (Exception e) 
		{
			AlienInfo response = new AlienInfo();
			handleError(e, response);
			return response;
		}
	}
	
	public CitizenInfo getCitizenInfo(ServiceRequest svcRequest,String dateOfBirthH, String nin)
	{
		
		try 
		{
			
			//marshal request
			CitizenInfoRequest request = InfoMarshaller.marshalCitizenInfo(svcRequest, dateOfBirthH, nin);
			
			// call service
			CitizenInfoResult response = getPort().getCitizenInfo(request);
			
			// unmarshall response
			return PersonalInfoUnmarshaller.unmarshalCitizenInfo(response);
		} 
		catch (Exception e) 
		{
			CitizenInfo response = new CitizenInfo();
			handleError(e, response);
			return response;
		}
	}
	
	public List<AlienDepInfo> getAlienAllDepInfoByIqama(ServiceRequest svcRequest,String iqamaNumber, String depIqama)
	{
		
		try 
		{
			
			//marshal request
			AlienAllDepInfoByIqamaRequest request = InfoMarshaller.marshalAlienAllDepInfoByIqama(svcRequest, iqamaNumber, depIqama);
			
			// call service
			AlienAllDepInfoByIqamaResult response = getPort().getAlienAllDepInfoByIqama(request);
			
			// unmarshall response
			return PersonalInfoUnmarshaller.unmarshalAlienAllDepInfoByIqama(response);
		} 
		catch (Exception e) 
		{
			List<AlienDepInfo> alienList = new ArrayList<AlienDepInfo>();
			AlienDepInfo response = new AlienDepInfo();
			handleError(e, response);
			alienList.add(response);
			return alienList;
		}
	}

	public List<AlienDepInfo> getAlienSingleDepInfoByIqama(ServiceRequest svcRequest,String iqamaNumber, String depIqama)
	{
		
		try 
		{
			
			//marshal request
			AlienSingleDepInfoByIqamaRequest request = InfoMarshaller.marshalAlienSingleDepInfoByIqama(svcRequest, iqamaNumber, depIqama);
			
			// call service
			AlienSingleDepInfoByIqamaResult response = getPort().getAlienSingleDepInfoByIqama(request);
			
			// unmarshall response
			return PersonalInfoUnmarshaller.unmarshalAlienSingleDepInfoByIqama(response);
		} 
		catch (Exception e) 
		{
			List<AlienDepInfo> alienList = new ArrayList<AlienDepInfo>();
			AlienDepInfo response = new AlienDepInfo();
			handleError(e, response);
			alienList.add(response);
			return alienList;
		}
	}

	public BasicCarInfo getCarInfoByCustom(ServiceRequest svcRequest,String customCardNumber, short modelYear)
	{
		
		try 
		{
			
			//marshal request
			CarInfoByCustomRequest request = InfoMarshaller.marshalCarInfoByCustom(svcRequest, customCardNumber, modelYear);
			
			// call service
			CarInfoByCustomResult response = getPort().getCarInfoByCustom(request);
			
			// unmarshall response
			return CarInfoUnmarshaller.unmarshalBasicCarInfo(response);
		} 
		catch (Exception e) 
		{
			BasicCarInfo response = new BasicCarInfo();
			handleError(e, response);
			return response;
		}
	}
	

	public CarInfo getAlienCarInfoBySequence(ServiceRequest svcRequest,int sequenceNumber, long ownerIqamaNumber)
	{
		
		try 
		{
			
			//marshal request
			AlienCarInfoBySequenceRequest request = InfoMarshaller.marshalAlienCarInfoBySequence(svcRequest, sequenceNumber, ownerIqamaNumber);
			
			// call service
			AlienCarInfoBySequenceResult response = getPort().getAlienCarInfoBySequence(request);
			
			// unmarshall response
			return CarInfoUnmarshaller.unmarshalCarInfo(response);
		} 
		catch (Exception e) 
		{
			CarInfo response = new CarInfo();
			handleError(e, response);
			return response;
		}
	}
	
	public CarInfo getCompanyCarInfoBySequence(ServiceRequest svcRequest,int sequenceNumber, long companyMOINumber)
	{
		
		try 
		{
			
			//marshal request
			CompanyCarInfoBySequenceRequest request = InfoMarshaller.marshalCompanyCarInfoBySequence(svcRequest, sequenceNumber, companyMOINumber);
			
			// call service
			CompanyCarInfoBySequenceResult response = getPort().getCompanyCarInfoBySequence(request);
			
			// unmarshall response
			return CarInfoUnmarshaller.unmarshalCarInfo(response);
		} 
		catch (Exception e) 
		{
			CarInfo response = new CarInfo();
			handleError(e, response);
			return response;
		}
	}

	public CarInfo getCitizenCarInfoBySequence(ServiceRequest svcRequest,int sequenceNumber, long ownerNin)
	{
		
		try 
		{
			
			//marshal request
			CitizenCarInfoBySequenceRequest request = InfoMarshaller.marshalCitizenCarInfoBySequence(svcRequest, sequenceNumber, ownerNin);
			
			// call service
			CitizenCarInfoBySequenceResult response = getPort().getCitizenCarInfoBySequence(request);
			
			// unmarshall response
			return CarInfoUnmarshaller.unmarshalCarInfo(response);
		} 
		catch (Exception e) 
		{
			CarInfo response = new CarInfo();
			handleError(e, response);
			return response;
		}
	}

	public AlienLegalStatusInfo getAlienLegalStatusInfo(ServiceRequest svcRequest,String iqamaNumber, String sponsorId)
	{
		
		try 
		{
			
			//marshal request
			AlienLegalStatusInfoRequest request = InfoMarshaller.marshalAlienLegalStatusInfo(svcRequest, iqamaNumber, sponsorId);
			
			// call service
			AlienLegalStatusInfoResult response = getPort().getAlienLegalStatusInfo(request);
			
			// unmarshall response
			return InfoUnmarshaller.unmarshalAlienLegalStatusInfo(response);
		} 
		catch (Exception e) 
		{
			AlienLegalStatusInfo response = new AlienLegalStatusInfo();
			handleError(e, response);
			return response;
		}
	}
	
	public CompanyInfo getCompanyInfoBySponseredIqama(ServiceRequest svcRequest,String iqamaNumber, String sponsorNumber, String depIqama)
	{
		
		try 
		{
			
			//marshal request
			CompanyInfoBySponseredIqamaRequest request = InfoMarshaller.marshalCompanyInfoBySponseredIqama(svcRequest, iqamaNumber, sponsorNumber, depIqama);
			
			// call service
			CompanyInfoBySponseredIqamaResult response = getPort().getCompanyInfoBySponseredIqama(request);
			
			// unmarshall response
			return InfoUnmarshaller.unmarshalCompanyInfo(response);
		} 
		catch (Exception e) 
		{
			CompanyInfo response = new CompanyInfo();
			handleError(e, response);
			return response;
		}
	}
	
	
	public List<AddressInfo> getAlienAddressInfo(ServiceRequest svcRequest,String iqamaNumber, String dateOfBirth, String addressLanguage)
	{
		
		try 
		{
			
			//marshal request
			AlienAddressInfoRequest request = InfoMarshaller.marshalAlienAddressInfo(svcRequest, iqamaNumber, dateOfBirth, addressLanguage);
			
			// call service
			AlienAddressInfoResult response = getPort().getAlienAddressInfo(request);
			
			// unmarshall response
			return AddressInfoUnmarshaller.unmarshalAlienAddressInfo(response);
		} 
		catch (Exception e) 
		{
			List<AddressInfo> addressList = new ArrayList<AddressInfo>();
			AddressInfo response = new AddressInfo();
			handleError(e, response);
			addressList.add(response);
			return addressList;
		}
	}
	
	public List<AddressInfo> getCitizenAddressInfo(ServiceRequest svcRequest,String nin, String dateOfBirth, String addressLanguage)
	{
		
		try 
		{
			
			//marshal request
			CitizenAddressInfoRequest request = InfoMarshaller.marshalCitizenAddressInfo(svcRequest, nin, dateOfBirth, addressLanguage);
			
			// call service
			CitizenAddressInfoResult response = getPort().getCitizenAddressInfo(request);
			
			// unmarshall response
			return AddressInfoUnmarshaller.unmarshalCitizenAddressInfo(response);
		} 
		catch (Exception e) 
		{
			List<AddressInfo> addressList = new ArrayList<AddressInfo>();
			AddressInfo response = new AddressInfo();
			handleError(e, response);
			addressList.add(response);
			return addressList;
		}
	}
	
	public List<AddressInfo> getCompanyAddressInfoByCr(ServiceRequest svcRequest,long crNumber, String addressLanguage)
	{
		
		try 
		{
			
			//marshal request
			CompanyAddressInfoByCrRequest request = InfoMarshaller.marshalCompanyAddressInfoByCr(svcRequest, crNumber, addressLanguage);
			
			// call service
			CompanyAddressInfoByCrResult response = getPort().getCompanyAddressInfoByCr(request);
			
			// unmarshall response
			return AddressInfoUnmarshaller.unmarshalCompanyAddressInfoByCr(response);
		} 
		catch (Exception e) 
		{
			List<AddressInfo> addressList = new ArrayList<AddressInfo>();
			AddressInfo response = new AddressInfo();
			handleError(e, response);
			addressList.add(response);
			return addressList;
		}
	}

	
	private void handleError(Exception e, ServiceResponse response)
	{
		e.printStackTrace();
		if (e instanceof Yakeen4AlinmaTMFault_Exception)
		{
			Yakeen4AlinmaTMFault_Exception yakeenException  = (Yakeen4AlinmaTMFault_Exception)e;
			response.setErrorCode(yakeenException.getFaultInfo().getCommonErrorObject().getErrorCode());
			response.setErrorMessage(yakeenException.getFaultInfo().getCommonErrorObject().getErrorMessage());
			response.setErrorType(yakeenException.getFaultInfo().getCommonErrorObject().getType());
		}
		else
		{
			response.setErrorCode(ERROR_CODE_GENERIC);
			response.setErrorMessage(ERROR_MSG_GENERIC);
			response.setErrorType(ERROR_TYPE_GENERIC);
		}
	}

	
	
	private Yakeen4AlinmaTM getPort()
	{

		Yakeen4AlinmaTMService service = new Yakeen4AlinmaTMService();
		Yakeen4AlinmaTM port = service.getYakeen4AlinmaTMPort();  
        
        BindingProvider bp = (BindingProvider)port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, yaqeenEndPointAddress);

		List<Handler> handlerList = bp.getBinding().getHandlerChain();
		if (handlerList == null)
		    handlerList = new ArrayList<Handler>();

		handlerList.add(new WSLogHandler());

		bp.getBinding().setHandlerChain(handlerList);
		
		return port;

	}
}