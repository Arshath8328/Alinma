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
 * Provides a wrapper for {@link SettingsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SettingsLocalService
 * @generated
 */
public class SettingsLocalServiceWrapper
	implements ServiceWrapper<SettingsLocalService>, SettingsLocalService {

	public SettingsLocalServiceWrapper(
		SettingsLocalService settingsLocalService) {

		_settingsLocalService = settingsLocalService;
	}

	@Override
	public void changePassword(
			com.liferay.portal.kernel.model.User user, String currentPassword,
			String password1, String password2)
		throws com.liferay.portal.kernel.exception.PortalException {

		_settingsLocalService.changePassword(
			user, currentPassword, password1, password2);
	}

	@Override
	public void changePasswordFn(
		long companyId, String screenName, String currentPassword,
		String password1, String password2) {

		_settingsLocalService.changePasswordFn(
			companyId, screenName, currentPassword, password1, password2);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _settingsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public boolean updateEmail(
			com.liferay.portal.kernel.model.User user, String userEmail)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _settingsLocalService.updateEmail(user, userEmail);
	}

	@Override
	public boolean updateEmailFn(
			long companyId, String screenName, String Email)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _settingsLocalService.updateEmailFn(
			companyId, screenName, Email);
	}

	@Override
	public boolean updateMobile(
			com.liferay.portal.kernel.model.User user, String phone)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _settingsLocalService.updateMobile(user, phone);
	}

	@Override
	public boolean updateMobileFn(
			long companyId, String screenName, String phoneNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _settingsLocalService.updateMobileFn(
			companyId, screenName, phoneNo);
	}

	@Override
	public SettingsLocalService getWrappedService() {
		return _settingsLocalService;
	}

	@Override
	public void setWrappedService(SettingsLocalService settingsLocalService) {
		_settingsLocalService = settingsLocalService;
	}

	private SettingsLocalService _settingsLocalService;

}