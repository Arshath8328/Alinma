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

import com.ejada.atmc.acl.ws.domain.ods.ODSCIResponse;
import com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation;
import com.ejada.atmc.acl.ws.domain.ods.ODSInsured;
import com.ejada.atmc.acl.ws.domain.ods.ODSPIResponse;
import com.ejada.atmc.acl.ws.domain.ods.ODSPolicy;
import com.ejada.atmc.acl.ws.domain.ods.ODSVehicleInfo;
import com.ejada.atmc.acl.ws.service.base.OdsServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the ods remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.ws.service.OdsService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    OdsServiceBaseImpl
 */
@Component(
		property = { "json.web.service.context.name=wsacl", "json.web.service.context.path=Ods" },
		service = AopService.class
)
public class OdsServiceImpl extends OdsServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this class directly. Always use {@link
	 * com.ejada.atmc.acl.ws.service.OdsServiceUtil} to access the ods remote service.
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ejada.atmc.acl.ws.service.OdsService#claimIntimation(com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation)
	 */
	public ODSCIResponse claimIntimation(ODSClaimIntimation odsClaimInt) {
		return odsLocalService.claimIntimation(odsClaimInt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ejada.atmc.acl.ws.service.OdsService#policyIssuance(com.ejada.atmc.acl.ws.domain.ODSInsured,
	 * com.ejada.atmc.acl.ws.domain.ODSPolicy, java.util.List)
	 */
	public ODSPIResponse policyIssuance(ODSInsured insured, ODSPolicy policy, List<ODSVehicleInfo> vehicleInfoList) {
		return odsLocalService.policyIssuance(insured, policy, vehicleInfoList);
	}
}