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

package com.ejada.atmc.acl.ws.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NajmLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see NajmLocalService
 * @generated
 */
public class NajmLocalServiceWrapper
	implements NajmLocalService, ServiceWrapper<NajmLocalService> {

	public NajmLocalServiceWrapper(NajmLocalService najmLocalService) {
		_najmLocalService = najmLocalService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _najmLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.NCDEligibility ncdEligibility(
		Long policyHolderId, Integer vehicleIdentifier, Long vehicleId) {

		return _najmLocalService.ncdEligibility(
			policyHolderId, vehicleIdentifier, vehicleId);
	}

	@Override
	public NajmLocalService getWrappedService() {
		return _najmLocalService;
	}

	@Override
	public void setWrappedService(NajmLocalService najmLocalService) {
		_najmLocalService = najmLocalService;
	}

	private NajmLocalService _najmLocalService;

}