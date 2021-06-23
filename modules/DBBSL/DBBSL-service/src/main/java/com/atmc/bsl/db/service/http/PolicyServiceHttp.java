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

import com.atmc.bsl.db.service.PolicyServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the <code>PolicyServiceUtil</code> service
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
 * @see PolicyServiceSoap
 * @generated
 */
public class PolicyServiceHttp {

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.policy.Policy>> getPoliciesByIqamaId(
			HttpPrincipal httpPrincipal, String iqamaId, int startRow, int endRow)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(PolicyServiceUtil.class, "getPoliciesByIqamaId",
					_getPoliciesByIqamaIdParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, iqamaId, startRow, endRow);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				if (exception instanceof com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException) exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.policy.Policy>>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Long> getPoliciesCountByIqamaId(HttpPrincipal httpPrincipal,
			String iqamaId) throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(PolicyServiceUtil.class, "getPoliciesCountByIqamaId",
					_getPoliciesCountByIqamaIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, iqamaId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				if (exception instanceof com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException) exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<Long>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.policy.Policy>> getUpcomingPolicyRenewals(
			HttpPrincipal httpPrincipal, String iqamaId) throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(PolicyServiceUtil.class, "getUpcomingPolicyRenewals",
					_getUpcomingPolicyRenewalsParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, iqamaId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				if (exception instanceof com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException) exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.policy.Policy>>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<java.util.HashMap<String, Object>>> getPolicySummary(
			HttpPrincipal httpPrincipal, String iqamaId) throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(PolicyServiceUtil.class, "getPolicySummary",
					_getPolicySummaryParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, iqamaId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				if (exception instanceof com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException) exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<java.util.List<java.util.HashMap<String, Object>>>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.policy.Policy> getPolicyByPolicyNo(
			HttpPrincipal httpPrincipal, String policyNo) throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(PolicyServiceUtil.class, "getPolicyByPolicyNo",
					_getPolicyByPolicyNoParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, policyNo);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				if (exception instanceof com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException) exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.policy.Policy>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PolicyServiceHttp.class);

	private static final Class<?>[] _getPoliciesByIqamaIdParameterTypes0 = new Class[] { String.class, int.class,
			int.class };
	private static final Class<?>[] _getPoliciesCountByIqamaIdParameterTypes1 = new Class[] { String.class };
	private static final Class<?>[] _getUpcomingPolicyRenewalsParameterTypes2 = new Class[] { String.class };
	private static final Class<?>[] _getPolicySummaryParameterTypes3 = new Class[] { String.class };
	private static final Class<?>[] _getPolicyByPolicyNoParameterTypes4 = new Class[] { String.class };

}