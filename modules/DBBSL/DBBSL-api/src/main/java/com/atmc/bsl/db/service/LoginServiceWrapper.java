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
 * Provides a wrapper for {@link LoginService}.
 *
 * @author Brian Wing Shun Chan
 * @see LoginService
 * @generated
 */
public class LoginServiceWrapper
	implements LoginService, ServiceWrapper<LoginService> {

	public LoginServiceWrapper(LoginService loginService) {
		_loginService = loginService;
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.ServiceOutput<com.ejada.atmc.bsl.db.domain.AuthUser>
		authenticateUser(String login, String password) {

		return _loginService.authenticateUser(login, password);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _loginService.getOSGiServiceIdentifier();
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.ServiceOutput<java.util.Set<String>>
		getReminderQueryQuestions() {

		return _loginService.getReminderQueryQuestions();
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.ServiceOutput<com.ejada.atmc.bsl.db.domain.AuthUser>
		login(String login, String password, String rememberMe) {

		return _loginService.login(login, password, rememberMe);
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.ServiceOutput<String> logout() {
		return _loginService.logout();
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.ServiceOutput<com.ejada.atmc.bsl.db.domain.AuthUser>
		validateUser(String idIqama, String email) {

		return _loginService.validateUser(idIqama, email);
	}

	@Override
	public LoginService getWrappedService() {
		return _loginService;
	}

	@Override
	public void setWrappedService(LoginService loginService) {
		_loginService = loginService;
	}

	private LoginService _loginService;

}