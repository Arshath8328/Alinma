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

package com.ejada.atmc.acl.db.service.http;

import com.ejada.atmc.acl.db.service.LNP2_PolicyMastrServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>LNP2_PolicyMastrServiceUtil</code> service
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
 * @see LNP2_PolicyMastrServiceSoap
 * @generated
 */
public class LNP2_PolicyMastrServiceHttp {

	public static Object findAllPSPolicyByIqamaId(
		HttpPrincipal httpPrincipal, String iqamaId) {

		try {
			MethodKey methodKey = new MethodKey(
				LNP2_PolicyMastrServiceUtil.class, "findAllPSPolicyByIqamaId",
				_findAllPSPolicyByIqamaIdParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, iqamaId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static Object findPSPolicyStatementDetailsById(
		HttpPrincipal httpPrincipal, String id, String fromDate,
		String toDate) {

		try {
			MethodKey methodKey = new MethodKey(
				LNP2_PolicyMastrServiceUtil.class,
				"findPSPolicyStatementDetailsById",
				_findPSPolicyStatementDetailsByIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, id, fromDate, toDate);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		LNP2_PolicyMastrServiceHttp.class);

	private static final Class<?>[] _findAllPSPolicyByIqamaIdParameterTypes0 =
		new Class[] {String.class};
	private static final Class<?>[]
		_findPSPolicyStatementDetailsByIdParameterTypes1 = new Class[] {
			String.class, String.class, String.class
		};

}