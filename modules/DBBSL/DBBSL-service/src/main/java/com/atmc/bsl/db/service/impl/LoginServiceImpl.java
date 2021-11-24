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

package com.atmc.bsl.db.service.impl;

import com.atmc.bsl.db.service.base.LoginServiceBaseImpl;
import com.ejada.atmc.bsl.db.domain.AuthUser;
import com.ejada.atmc.bsl.db.domain.ReturnCodes;
import com.ejada.atmc.bsl.db.domain.ServiceOutput;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PasswordExpiredException;
import com.liferay.portal.kernel.exception.UserLockoutException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.AuthException;

import java.util.Set;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the login remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.LoginService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoginServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=dbbsl",
		"json.web.service.context.path=Login" }, service = AopService.class)
public class LoginServiceImpl extends LoginServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.atmc.bsl.db.service.LoginServiceUtil} to access the login remote
	 * service.
	 */

	private static final Log _log = LogFactoryUtil.getLog(LoginServiceImpl.class);

	public ServiceOutput<Set<String>> getReminderQueryQuestions() {
		ServiceOutput<Set<String>> svcOutput = new ServiceOutput<Set<String>>();
		try {
			Set<String> questions = loginLocalService.getReminderQueryQuestions();
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(questions);
		} catch (Exception e) {
			_log.error(e);
			svcOutput.setOutputCode(getOutputCode(e));
		}

		return svcOutput;
	}

	public ServiceOutput<AuthUser> validateUser(String idIqama, String email) {
		ServiceOutput<AuthUser> svcOutput = new ServiceOutput<AuthUser>();
		try {
			AuthUser user = loginLocalService.validateUser(idIqama, email);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(user);
		} catch (Exception e) {
			_log.error(e);
			svcOutput.setOutputCode(getOutputCode(e));
		}

		return svcOutput;
	}

	public ServiceOutput<AuthUser> authenticateUser(String login, String password) {
		ServiceOutput<AuthUser> svcOutput = new ServiceOutput<AuthUser>();
		try {
			AuthUser user = loginLocalService.authenticateUser(login, password);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(user);
		} catch (Exception e) {
			_log.error(e);
			svcOutput.setOutputCode(getOutputCode(e));
		}

		return svcOutput;
	}

	public ServiceOutput<AuthUser> login(String login, String password, String rememberMe) {
		ServiceOutput<AuthUser> svcOutput = new ServiceOutput<AuthUser>();
		try {
			AuthUser user = loginLocalService.login(login, password, rememberMe);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(user);
		} catch (Exception e) {
			_log.error(e);
			svcOutput.setOutputCode(getOutputCode(e));
		}

		return svcOutput;
	}

	public ServiceOutput<String> logout() {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			loginLocalService.logout();
			;
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
		} catch (Exception e) {
			_log.error(e);
			svcOutput.setOutputCode(getOutputCode(e));
		}

		return svcOutput;
	}

	private String getOutputCode(Exception e) {
		if (e instanceof AuthException) {
			Throwable cause = e.getCause();
			if (cause instanceof PasswordExpiredException || cause instanceof UserLockoutException) {
				return ReturnCodes.getErrorCode(cause.getClass());
			}
		}

		return ReturnCodes.getErrorCode(e.getClass());
	}

}