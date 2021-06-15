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
 * Provides a wrapper for {@link GsonUtilsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GsonUtilsLocalService
 * @generated
 */
public class GsonUtilsLocalServiceWrapper
	implements GsonUtilsLocalService, ServiceWrapper<GsonUtilsLocalService> {

	public GsonUtilsLocalServiceWrapper(
		GsonUtilsLocalService gsonUtilsLocalService) {

		_gsonUtilsLocalService = gsonUtilsLocalService;
	}

	@Override
	public Object fromGson(String gsonString, Class c) {
		return _gsonUtilsLocalService.fromGson(gsonString, c);
	}

	@Override
	public Object fromMobileGson(String gsonString, Class c) {
		return _gsonUtilsLocalService.fromMobileGson(gsonString, c);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _gsonUtilsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public String toGson(Object gsonObject) {
		return _gsonUtilsLocalService.toGson(gsonObject);
	}

	@Override
	public GsonUtilsLocalService getWrappedService() {
		return _gsonUtilsLocalService;
	}

	@Override
	public void setWrappedService(GsonUtilsLocalService gsonUtilsLocalService) {
		_gsonUtilsLocalService = gsonUtilsLocalService;
	}

	private GsonUtilsLocalService _gsonUtilsLocalService;

}