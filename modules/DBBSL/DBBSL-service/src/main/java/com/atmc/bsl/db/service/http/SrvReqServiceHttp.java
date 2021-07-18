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

import com.atmc.bsl.db.service.SrvReqServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>SrvReqServiceUtil</code> service
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
 * @see SrvReqServiceSoap
 * @generated
 */
public class SrvReqServiceHttp {

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.serviceRequest.ServiceRequest>>
				getServiceRequestsListByIdStatus(
					HttpPrincipal httpPrincipal, String iqamaId,
					String[] status)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SrvReqServiceUtil.class, "getServiceRequestsListByIdStatus",
				_getServiceRequestsListByIdStatusParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, iqamaId, status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput
				<java.util.List
					<com.atmc.bsl.db.domain.serviceRequest.ServiceRequest>>)
						returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
		addNewServiceRequest(
			HttpPrincipal httpPrincipal,
			com.atmc.bsl.db.domain.serviceRequest.ServiceRequest srvRequest,
			String lang) {

		try {
			MethodKey methodKey = new MethodKey(
				SrvReqServiceUtil.class, "addNewServiceRequest",
				_addNewServiceRequestParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, srvRequest, lang);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static boolean sendEmail(
		HttpPrincipal httpPrincipal, String mailTo, String emailMsg,
		String msgTitle) {

		try {
			MethodKey methodKey = new MethodKey(
				SrvReqServiceUtil.class, "sendEmail",
				_sendEmailParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, mailTo, emailMsg, msgTitle);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Boolean)returnObj).booleanValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void sendSMS(
		HttpPrincipal httpPrincipal, java.util.Locale locale,
		String mobileNumber, String refNo, String msgKey) {

		try {
			MethodKey methodKey = new MethodKey(
				SrvReqServiceUtil.class, "sendSMS", _sendSMSParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, locale, mobileNumber, refNo, msgKey);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SrvReqServiceHttp.class);

	private static final Class<?>[]
		_getServiceRequestsListByIdStatusParameterTypes0 = new Class[] {
			String.class, String[].class
		};
	private static final Class<?>[] _addNewServiceRequestParameterTypes2 =
		new Class[] {
			com.atmc.bsl.db.domain.serviceRequest.ServiceRequest.class,
			String.class
		};
	private static final Class<?>[] _sendEmailParameterTypes3 = new Class[] {
		String.class, String.class, String.class
	};
	private static final Class<?>[] _sendSMSParameterTypes4 = new Class[] {
		java.util.Locale.class, String.class, String.class, String.class
	};

}