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

package com.atmc.bsl.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MuroorODUploadsService}.
 *
 * @author Brian Wing Shun Chan
 * @see MuroorODUploadsService
 * @generated
 */
public class MuroorODUploadsServiceWrapper implements MuroorODUploadsService, ServiceWrapper<MuroorODUploadsService> {

	public MuroorODUploadsServiceWrapper(MuroorODUploadsService muroorODUploadsService) {

		_muroorODUploadsService = muroorODUploadsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _muroorODUploadsService.getOSGiServiceIdentifier();
	}

	@Override
	public MuroorODUploadsService getWrappedService() {
		return _muroorODUploadsService;
	}

	@Override
	public void setWrappedService(MuroorODUploadsService muroorODUploadsService) {

		_muroorODUploadsService = muroorODUploadsService;
	}

	private MuroorODUploadsService _muroorODUploadsService;

}