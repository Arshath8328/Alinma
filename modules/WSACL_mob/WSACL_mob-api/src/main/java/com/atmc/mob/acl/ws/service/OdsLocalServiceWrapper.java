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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OdsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OdsLocalService
 * @generated
 */
public class OdsLocalServiceWrapper
	implements OdsLocalService, ServiceWrapper<OdsLocalService> {

	public OdsLocalServiceWrapper(OdsLocalService odsLocalService) {
		_odsLocalService = odsLocalService;
	}

	/**
	 * @param odsClaimInt
	 * @return ODSCIResponse
	 * @see
	 */
	@Override
	public com.atmc.mob.acl.ws.domain.ods.ODSCIResponse claimIntimation(
		com.atmc.mob.acl.ws.domain.ods.ODSClaimIntimation odsClaimInt) {

		return _odsLocalService.claimIntimation(odsClaimInt);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _odsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @param insured
	 * @param policy
	 * @param vehicle
	 * @return ODSPIResponse
	 * @see
	 */
	@Override
	public com.atmc.mob.acl.ws.domain.ods.ODSPIResponse policyIssuance(
		com.atmc.mob.acl.ws.domain.ods.ODSInsured insured,
		com.atmc.mob.acl.ws.domain.ods.ODSPolicy policy,
		java.util.List<com.atmc.mob.acl.ws.domain.ods.ODSVehicleInfo>
			vehicleInfoList) {

		return _odsLocalService.policyIssuance(
			insured, policy, vehicleInfoList);
	}

	@Override
	public OdsLocalService getWrappedService() {
		return _odsLocalService;
	}

	@Override
	public void setWrappedService(OdsLocalService odsLocalService) {
		_odsLocalService = odsLocalService;
	}

	private OdsLocalService _odsLocalService;

}