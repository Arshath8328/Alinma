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

package com.atmc.mob.acl.ws.service;

import com.atmc.mob.acl.ws.domain.ods.ODSCIResponse;
import com.atmc.mob.acl.ws.domain.ods.ODSClaimIntimation;
import com.atmc.mob.acl.ws.domain.ods.ODSInsured;
import com.atmc.mob.acl.ws.domain.ods.ODSPIResponse;
import com.atmc.mob.acl.ws.domain.ods.ODSPolicy;
import com.atmc.mob.acl.ws.domain.ods.ODSVehicleInfo;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Ods. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see OdsLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface OdsLocalService extends BaseLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.atmc.mob.acl.ws.service.impl.OdsLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the ods local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link OdsLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * @param odsClaimInt
	 * @return ODSCIResponse
	 * @see
	 */
	public ODSCIResponse claimIntimation(ODSClaimIntimation odsClaimInt);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @param insured
	 * @param policy
	 * @param vehicle
	 * @return ODSPIResponse
	 * @see
	 */
	public ODSPIResponse policyIssuance(
		ODSInsured insured, ODSPolicy policy,
		List<ODSVehicleInfo> vehicleInfoList);

}