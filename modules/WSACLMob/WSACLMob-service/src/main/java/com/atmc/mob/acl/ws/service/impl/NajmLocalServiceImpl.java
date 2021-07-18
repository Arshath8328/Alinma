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

import com.atmc.mob.acl.ws.domain.NCDEligibility;
import com.atmc.mob.acl.ws.marshal.najm.NCDEligibilityUnmarshaller;
import com.atmc.mob.acl.ws.proxy.najm.INCDService;
import com.atmc.mob.acl.ws.proxy.najm.NCDService;
import com.atmc.mob.acl.ws.security.NajmWSSecurityHandler;
import com.atmc.mob.acl.ws.service.base.NajmLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.soap.AddressingFeature;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the najm local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.atmc.mob.acl.ws.service.NajmLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NajmLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.atmc.mob.acl.ws.model.Najm",
	service = AopService.class
)
public class NajmLocalServiceImpl extends NajmLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ejada.atmc.acl.mob.ws.service.NajmLocalServiceUtil} to access the najm local service.
	 */
	
	public static final String ENDPOINT_ADDRESS = "https://portalservices1.najm.sa/NCDService/NCDService.svc";
	private static final Log _log = LogFactoryUtil.getLog(NajmLocalServiceImpl.class);
	
	public NCDEligibility ncdEligibility(Long policyHolderId, Integer vehicleIdentifier,Long vehicleId)
	{
		_log.info("ncd eligibility call - start");
		try
		{
			NCDService svc = new NCDService();
			INCDService port = svc.getWSHttpBindingINCDService(new AddressingFeature(true, true));
			BindingProvider bp = (BindingProvider) port;
			//TODO get this property from configuration
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ENDPOINT_ADDRESS);
			
			List<Handler> handlerList = bp.getBinding().getHandlerChain();
			if (handlerList == null)
			    handlerList = new ArrayList<Handler>();
	
			handlerList.add(new NajmWSSecurityHandler());
	
			bp.getBinding().setHandlerChain(handlerList);

			
			String response = port.ncdEligibility(policyHolderId, vehicleIdentifier, vehicleId);
			_log.info("NCD Response >>>" + response);
			
			NCDEligibility responseData = NCDEligibilityUnmarshaller.unmarshal(response);
			return responseData;
			
		}
		catch(Exception e)
		{
			_log.info("Exception in ncd call");
			_log.error(e);
			
			NCDEligibility responseData = new NCDEligibility();
			responseData.setStatusCode(NCDEligibilityUnmarshaller.STATUS_CODE_FAIL);
			responseData.setErrorCode(NCDEligibilityUnmarshaller.ERROR_CODE_GEN);
			responseData.setErrorMsg(NCDEligibilityUnmarshaller.ERROR_MSG_GEN);
			return responseData;
		}

	}

}