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

import com.atmc.bsl.db.service.WorkshopServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the <code>WorkshopServiceUtil</code> service
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
 * @see WorkshopServiceSoap
 * @generated
 */
public class WorkshopServiceHttp {

	public static com.atmc.bsl.db.domain.ServiceOutput<String> checkInVehicle(HttpPrincipal httpPrincipal,
			String customerName, String customerMobile, String manufacture, String plateNo, int workshopId,
			String claimRefNo, String status, String date, String serviceType, String desc, String vehMakeEn,
			String vehMakeAr, String vehModelEn, String vehModelAr, String customerIqamaId) {

		try {
			MethodKey methodKey = new MethodKey(WorkshopServiceUtil.class, "checkInVehicle",
					_checkInVehicleParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, customerName, customerMobile, manufacture,
					plateNo, workshopId, claimRefNo, status, date, serviceType, desc, vehMakeEn, vehMakeAr, vehModelEn,
					vehModelAr, customerIqamaId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<String>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopVehicles>> getcheckedInVehicleByStatus(
			HttpPrincipal httpPrincipal, String status, int workShopId) {

		try {
			MethodKey methodKey = new MethodKey(WorkshopServiceUtil.class, "getcheckedInVehicleByStatus",
					_getcheckedInVehicleByStatusParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, status, workShopId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopVehicles>>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.workshop.WorkshopVehicles> getcheckedInVehicleById(
			HttpPrincipal httpPrincipal, int id) {

		try {
			MethodKey methodKey = new MethodKey(WorkshopServiceUtil.class, "getcheckedInVehicleById",
					_getcheckedInVehicleByIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, id);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.workshop.WorkshopVehicles>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String> updateVehicleStatus(HttpPrincipal httpPrincipal, int id,
			String status) {

		try {
			MethodKey methodKey = new MethodKey(WorkshopServiceUtil.class, "updateVehicleStatus",
					_updateVehicleStatusParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, id, status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<String>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopVehicles>> getcheckedInVehicleByIqmaId(
			HttpPrincipal httpPrincipal, String iqamaId) {

		try {
			MethodKey methodKey = new MethodKey(WorkshopServiceUtil.class, "getcheckedInVehicleByIqmaId",
					_getcheckedInVehicleByIqmaIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, iqamaId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopVehicles>>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopList>> getWorkShopList(
			HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(WorkshopServiceUtil.class, "getWorkShopList",
					_getWorkShopListParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopList>>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(WorkshopServiceHttp.class);

	private static final Class<?>[] _checkInVehicleParameterTypes0 = new Class[] { String.class, String.class,
			String.class, String.class, int.class, String.class, String.class, String.class, String.class, String.class,
			String.class, String.class, String.class, String.class, String.class };
	private static final Class<?>[] _getcheckedInVehicleByStatusParameterTypes1 = new Class[] { String.class,
			int.class };
	private static final Class<?>[] _getcheckedInVehicleByIdParameterTypes2 = new Class[] { int.class };
	private static final Class<?>[] _updateVehicleStatusParameterTypes3 = new Class[] { int.class, String.class };
	private static final Class<?>[] _getcheckedInVehicleByIqmaIdParameterTypes4 = new Class[] { String.class };
	private static final Class<?>[] _getWorkShopListParameterTypes5 = new Class[] {};

}