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
 * Provides a wrapper for {@link NCDDetailsService}.
 *
 * @author Brian Wing Shun Chan
 * @see NCDDetailsService
 * @generated
 */
public class NCDDetailsServiceWrapper
	implements NCDDetailsService, ServiceWrapper<NCDDetailsService> {

	public NCDDetailsServiceWrapper(NCDDetailsService ncdDetailsService) {
		_ncdDetailsService = ncdDetailsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ncdDetailsService.getOSGiServiceIdentifier();
	}

	@Override
	public NCDDetailsService getWrappedService() {
		return _ncdDetailsService;
	}

	@Override
	public void setWrappedService(NCDDetailsService ncdDetailsService) {
		_ncdDetailsService = ncdDetailsService;
	}

	private NCDDetailsService _ncdDetailsService;

}