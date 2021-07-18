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
 * Provides a wrapper for {@link YakeenService}.
 *
 * @author Brian Wing Shun Chan
 * @see YakeenService
 * @generated
 */
public class YakeenServiceWrapper
	implements ServiceWrapper<YakeenService>, YakeenService {

	public YakeenServiceWrapper(YakeenService yakeenService) {
		_yakeenService = yakeenService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _yakeenService.getOSGiServiceIdentifier();
	}

	@Override
	public YakeenService getWrappedService() {
		return _yakeenService;
	}

	@Override
	public void setWrappedService(YakeenService yakeenService) {
		_yakeenService = yakeenService;
	}

	private YakeenService _yakeenService;

}