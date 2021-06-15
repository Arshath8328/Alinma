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

package com.ejada.atmc.acl.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ClaimHDRService}.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimHDRService
 * @generated
 */
public class ClaimHDRServiceWrapper
	implements ClaimHDRService, ServiceWrapper<ClaimHDRService> {

	public ClaimHDRServiceWrapper(ClaimHDRService claimHDRService) {
		_claimHDRService = claimHDRService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _claimHDRService.getOSGiServiceIdentifier();
	}

	@Override
	public ClaimHDRService getWrappedService() {
		return _claimHDRService;
	}

	@Override
	public void setWrappedService(ClaimHDRService claimHDRService) {
		_claimHDRService = claimHDRService;
	}

	private ClaimHDRService _claimHDRService;

}