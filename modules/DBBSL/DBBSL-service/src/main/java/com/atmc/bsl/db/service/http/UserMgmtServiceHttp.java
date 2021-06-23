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

import com.atmc.bsl.db.service.UserMgmtServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the <code>UserMgmtServiceUtil</code> service
 * utility. The static methods of this class calls the same methods of the
 * service utility. However, the signatures are different because it requires an
 * additional <code>HttpPrincipal</code> parameter.
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
 * @see UserMgmtServiceSoap
 * @generated
 */
public class UserMgmtServiceHttp {

	public static com.atmc.bsl.db.domain.ServiceOutput<com.liferay.portal.kernel.model.User> createUser(
			HttpPrincipal httpPrincipal, long companyId, String login, String password, String englishName,
			String arabicName, String language, String mobile, String email, String reminderQueryQuestion,
			String reminderQueryAnswer) {

		try {
			MethodKey methodKey = new MethodKey(UserMgmtServiceUtil.class, "createUser", _createUserParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, companyId, login, password, englishName,
					arabicName, language, mobile, email, reminderQueryQuestion, reminderQueryAnswer);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<com.liferay.portal.kernel.model.User>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.liferay.portal.kernel.model.User> changeFirstTimeLoginPassword(
			HttpPrincipal httpPrincipal, long userId, String password, String reminderQueryQuestion,
			String reminderQueryAnswer) {

		try {
			MethodKey methodKey = new MethodKey(UserMgmtServiceUtil.class, "changeFirstTimeLoginPassword",
					_changeFirstTimeLoginPasswordParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId, password, reminderQueryQuestion,
					reminderQueryAnswer);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<com.liferay.portal.kernel.model.User>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(UserMgmtServiceHttp.class);

	private static final Class<?>[] _createUserParameterTypes0 = new Class[] { long.class, String.class, String.class,
			String.class, String.class, String.class, String.class, String.class, String.class, String.class };
	private static final Class<?>[] _changeFirstTimeLoginPasswordParameterTypes1 = new Class[] { long.class,
			String.class, String.class, String.class };

}