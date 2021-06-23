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

import com.atmc.mob.acl.ws.domain.ods.ODSCIResponse;
import com.atmc.mob.acl.ws.domain.ods.ODSClaimIntimation;
import com.atmc.mob.acl.ws.domain.ods.ODSInsured;
import com.atmc.mob.acl.ws.domain.ods.ODSPIResponse;
import com.atmc.mob.acl.ws.domain.ods.ODSPolicy;
import com.atmc.mob.acl.ws.domain.ods.ODSVehicleInfo;
import com.atmc.mob.acl.ws.marshal.ods.ClaimODSIntimationMarshaller;
import com.atmc.mob.acl.ws.marshal.ods.ClaimODSIntimationUnmarshaller;
import com.atmc.mob.acl.ws.marshal.ods.IssueODSPolicyMarshaller;
import com.atmc.mob.acl.ws.marshal.ods.IssueODSPolicyUnmarshaller;
import com.atmc.mob.acl.ws.proxy.ods.IService;
import com.atmc.mob.acl.ws.proxy.ods.Service;
import com.atmc.mob.acl.ws.proxy.ods.ClaimIntimation.XmlRequest;
import com.atmc.mob.acl.ws.proxy.ods.ClaimIntimationResponse.ClaimIntimationResult;
import com.atmc.mob.acl.ws.proxy.ods.PolicyIssuanceResponse.PolicyIssuanceResult;
import com.atmc.mob.acl.ws.security.WSLogHandler;
import com.atmc.mob.acl.ws.service.base.OdsLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.util.PropsUtil;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the ods local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.atmc.mob.acl.ws.service.OdsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OdsLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.atmc.mob.acl.ws.model.Ods",
	service = AopService.class
)
public class OdsLocalServiceImpl extends OdsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ejada.atmc.acl.mob.ws.service.OdsLocalServiceUtil} to access the ods local service.
	 */
	public static final String ENDPOINT_ADDRESS = "http://localhost:8095/mockBasicHttpBinding_IService";

	/**
	 * @param odsClaimInt
	 * @return ODSCIResponse
	 * @see
	 */
	public ODSCIResponse claimIntimation(ODSClaimIntimation odsClaimInt)
	{

		XmlRequest req = ClaimODSIntimationMarshaller.marshal(odsClaimInt);

		ClaimIntimationResult result = getPort().claimIntimation(req);
		return ClaimODSIntimationUnmarshaller.unmarshal(result);
	}

	/**
	 * @param insured
	 * @param policy
	 * @param vehicle
	 * @return ODSPIResponse
	 * @see
	 */
	public ODSPIResponse policyIssuance(ODSInsured insured, ODSPolicy policy, List<ODSVehicleInfo> vehicleInfoList)
	{
		com.atmc.mob.acl.ws.proxy.ods.PolicyIssuance.XmlRequest req = IssueODSPolicyMarshaller.marshal(insured, policy, vehicleInfoList);

		PolicyIssuanceResult result = getPort().policyIssuance(req);
		return IssueODSPolicyUnmarshaller.unmarshal(result);
	}

	/**
	 * @return IService
	 * @see
	 */
	private IService getPort()
	{
		String endpointAddress = PropsUtil.get("com.ejada.atmc.ods.endpointaddress");
		
		Service svc = new Service();
		IService port = svc.getBasicHttpBindingIService();
		BindingProvider bp = (BindingProvider) port;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointAddress);

		List<Handler> handlerList = bp.getBinding().getHandlerChain();
		if(handlerList == null)
			handlerList = new ArrayList<Handler>();

		handlerList.add(new WSLogHandler());
		bp.getBinding().setHandlerChain(handlerList);

		return port;
	}
}