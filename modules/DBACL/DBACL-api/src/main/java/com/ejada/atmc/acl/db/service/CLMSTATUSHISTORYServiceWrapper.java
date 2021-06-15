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
 * Provides a wrapper for {@link CLMSTATUSHISTORYService}.
 *
 * @author Brian Wing Shun Chan
 * @see CLMSTATUSHISTORYService
 * @generated
 */
public class CLMSTATUSHISTORYServiceWrapper
	implements CLMSTATUSHISTORYService,
			   ServiceWrapper<CLMSTATUSHISTORYService> {

	public CLMSTATUSHISTORYServiceWrapper(
		CLMSTATUSHISTORYService clmstatushistoryService) {

		_clmstatushistoryService = clmstatushistoryService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _clmstatushistoryService.getOSGiServiceIdentifier();
	}

	@Override
	public CLMSTATUSHISTORYService getWrappedService() {
		return _clmstatushistoryService;
	}

	@Override
	public void setWrappedService(
		CLMSTATUSHISTORYService clmstatushistoryService) {

		_clmstatushistoryService = clmstatushistoryService;
	}

	private CLMSTATUSHISTORYService _clmstatushistoryService;

}