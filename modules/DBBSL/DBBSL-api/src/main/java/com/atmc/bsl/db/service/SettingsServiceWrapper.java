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
 * Provides a wrapper for {@link SettingsService}.
 *
 * @author Brian Wing Shun Chan
 * @see SettingsService
 * @generated
 */
public class SettingsServiceWrapper
	implements ServiceWrapper<SettingsService>, SettingsService {

	public SettingsServiceWrapper(SettingsService settingsService) {
		_settingsService = settingsService;
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> changePassword(
		String companyId, String screenName, String currentPassword,
		String password1, String password2) {

		return _settingsService.changePassword(
			companyId, screenName, currentPassword, password1, password2);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _settingsService.getOSGiServiceIdentifier();
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> updateEmail(
			String companyId, String screenName, String Email)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _settingsService.updateEmail(companyId, screenName, Email);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> updateMobile(
			String companyId, String screenName, String phoneNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _settingsService.updateMobile(companyId, screenName, phoneNo);
	}

	@Override
	public SettingsService getWrappedService() {
		return _settingsService;
	}

	@Override
	public void setWrappedService(SettingsService settingsService) {
		_settingsService = settingsService;
	}

	private SettingsService _settingsService;

}