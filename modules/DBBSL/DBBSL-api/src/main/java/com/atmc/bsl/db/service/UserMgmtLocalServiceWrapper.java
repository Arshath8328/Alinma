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
 * Provides a wrapper for {@link UserMgmtLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserMgmtLocalService
 * @generated
 */
public class UserMgmtLocalServiceWrapper
	implements ServiceWrapper<UserMgmtLocalService>, UserMgmtLocalService {

	public UserMgmtLocalServiceWrapper(
		UserMgmtLocalService userMgmtLocalService) {

		_userMgmtLocalService = userMgmtLocalService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userMgmtLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public UserMgmtLocalService getWrappedService() {
		return _userMgmtLocalService;
	}

	@Override
	public void setWrappedService(UserMgmtLocalService userMgmtLocalService) {
		_userMgmtLocalService = userMgmtLocalService;
	}

	private UserMgmtLocalService _userMgmtLocalService;

}