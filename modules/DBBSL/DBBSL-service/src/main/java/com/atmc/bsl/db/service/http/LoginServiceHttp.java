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

package com.atmc.bsl.db.service.http;

import com.atmc.bsl.db.service.LoginServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>LoginServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoginServiceSoap
 * @generated
 */
public class LoginServiceHttp {

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<java.util.Set<String>>
		getReminderQueryQuestions(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				LoginServiceUtil.class, "getReminderQueryQuestions",
				_getReminderQueryQuestionsParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<java.util.Set<String>>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<com.ejada.atmc.bsl.db.domain.AuthUser> validateUser(
			HttpPrincipal httpPrincipal, String idIqama, String email) {

		try {
			MethodKey methodKey = new MethodKey(
				LoginServiceUtil.class, "validateUser",
				_validateUserParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, idIqama, email);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput
				<com.ejada.atmc.bsl.db.domain.AuthUser>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<com.ejada.atmc.bsl.db.domain.AuthUser> authenticateUser(
			HttpPrincipal httpPrincipal, String login, String password) {

		try {
			MethodKey methodKey = new MethodKey(
				LoginServiceUtil.class, "authenticateUser",
				_authenticateUserParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, login, password);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput
				<com.ejada.atmc.bsl.db.domain.AuthUser>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<com.ejada.atmc.bsl.db.domain.AuthUser> login(
			HttpPrincipal httpPrincipal, String login, String password,
			String rememberMe) {

		try {
			MethodKey methodKey = new MethodKey(
				LoginServiceUtil.class, "login", _loginParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, login, password, rememberMe);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput
				<com.ejada.atmc.bsl.db.domain.AuthUser>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String> logout(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				LoginServiceUtil.class, "logout", _logoutParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(LoginServiceHttp.class);

	private static final Class<?>[] _getReminderQueryQuestionsParameterTypes0 =
		new Class[] {};
	private static final Class<?>[] _validateUserParameterTypes1 = new Class[] {
		String.class, String.class
	};
	private static final Class<?>[] _authenticateUserParameterTypes2 =
		new Class[] {String.class, String.class};
	private static final Class<?>[] _loginParameterTypes3 = new Class[] {
		String.class, String.class, String.class
	};
	private static final Class<?>[] _logoutParameterTypes4 = new Class[] {};

}