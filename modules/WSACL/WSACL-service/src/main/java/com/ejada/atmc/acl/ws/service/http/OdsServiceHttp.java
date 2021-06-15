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

package com.ejada.atmc.acl.ws.service.http;

import com.ejada.atmc.acl.ws.service.OdsServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>OdsServiceUtil</code> service
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
 * @see OdsServiceSoap
 * @generated
 */
public class OdsServiceHttp {

	public static com.ejada.atmc.acl.ws.domain.ods.ODSCIResponse
		claimIntimation(
			HttpPrincipal httpPrincipal,
			com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation odsClaimInt) {

		try {
			MethodKey methodKey = new MethodKey(
				OdsServiceUtil.class, "claimIntimation",
				_claimIntimationParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, odsClaimInt);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.acl.ws.domain.ods.ODSCIResponse)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.acl.ws.domain.ods.ODSPIResponse policyIssuance(
		HttpPrincipal httpPrincipal,
		com.ejada.atmc.acl.ws.domain.ods.ODSInsured insured,
		com.ejada.atmc.acl.ws.domain.ods.ODSPolicy policy,
		java.util.List<com.ejada.atmc.acl.ws.domain.ods.ODSVehicleInfo>
			vehicleInfoList) {

		try {
			MethodKey methodKey = new MethodKey(
				OdsServiceUtil.class, "policyIssuance",
				_policyIssuanceParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, insured, policy, vehicleInfoList);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.acl.ws.domain.ods.ODSPIResponse)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(OdsServiceHttp.class);

	private static final Class<?>[] _claimIntimationParameterTypes0 =
		new Class[] {com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation.class};
	private static final Class<?>[] _policyIssuanceParameterTypes1 =
		new Class[] {
			com.ejada.atmc.acl.ws.domain.ods.ODSInsured.class,
			com.ejada.atmc.acl.ws.domain.ods.ODSPolicy.class,
			java.util.List.class
		};

}