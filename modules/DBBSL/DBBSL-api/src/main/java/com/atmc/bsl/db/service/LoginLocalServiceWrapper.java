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
 * Provides a wrapper for {@link LoginLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LoginLocalService
 * @generated
 */
public class LoginLocalServiceWrapper
	implements LoginLocalService, ServiceWrapper<LoginLocalService> {

	public LoginLocalServiceWrapper(LoginLocalService loginLocalService) {
		_loginLocalService = loginLocalService;
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.AuthUser authenticateUser(
			String login, String password)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loginLocalService.authenticateUser(login, password);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _loginLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.Set<String> getReminderQueryQuestions()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loginLocalService.getReminderQueryQuestions();
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.AuthUser login(
			String login, String password, String rememberMe)
		throws Exception {

		return _loginLocalService.login(login, password, rememberMe);
	}

	@Override
	public void logout() throws Exception {
		_loginLocalService.logout();
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.AuthUser validateUser(
			String idIqama, String email)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loginLocalService.validateUser(idIqama, email);
	}

	@Override
	public LoginLocalService getWrappedService() {
		return _loginLocalService;
	}

	@Override
	public void setWrappedService(LoginLocalService loginLocalService) {
		_loginLocalService = loginLocalService;
	}

	private LoginLocalService _loginLocalService;

}