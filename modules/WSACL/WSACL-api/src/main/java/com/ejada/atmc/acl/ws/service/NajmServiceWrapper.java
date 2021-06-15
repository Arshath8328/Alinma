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
 * Provides a wrapper for {@link NajmService}.
 *
 * @author Brian Wing Shun Chan
 * @see NajmService
 * @generated
 */
public class NajmServiceWrapper
	implements NajmService, ServiceWrapper<NajmService> {

	public NajmServiceWrapper(NajmService najmService) {
		_najmService = najmService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _najmService.getOSGiServiceIdentifier();
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.NCDEligibility ncdEligibility(
		Long policyHolderId, Integer vehicleIdentifier, Long vehicleId) {

		return _najmService.ncdEligibility(
			policyHolderId, vehicleIdentifier, vehicleId);
	}

	@Override
	public NajmService getWrappedService() {
		return _najmService;
	}

	@Override
	public void setWrappedService(NajmService najmService) {
		_najmService = najmService;
	}

	private NajmService _najmService;

}