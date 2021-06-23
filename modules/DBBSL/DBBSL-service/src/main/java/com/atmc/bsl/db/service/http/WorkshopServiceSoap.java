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

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the <code>WorkshopServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkshopServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class WorkshopServiceSoap {

	public static com.atmc.bsl.db.domain.ServiceOutput<String> checkInVehicle(String customerName,
			String customerMobile, String manufacture, String plateNo, int workshopId, String claimRefNo, String status,
			String date, String serviceType, String desc, String vehMakeEn, String vehMakeAr, String vehModelEn,
			String vehModelAr, String customerIqamaId) throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue = WorkshopServiceUtil.checkInVehicle(customerName,
					customerMobile, manufacture, plateNo, workshopId, claimRefNo, status, date, serviceType, desc,
					vehMakeEn, vehMakeAr, vehModelEn, vehModelAr, customerIqamaId);

			return returnValue;
		} catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopVehicles>> getcheckedInVehicleByStatus(
			String status, int workShopId) throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopVehicles>> returnValue = WorkshopServiceUtil
					.getcheckedInVehicleByStatus(status, workShopId);

			return returnValue;
		} catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.workshop.WorkshopVehicles> getcheckedInVehicleById(
			int id) throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.workshop.WorkshopVehicles> returnValue = WorkshopServiceUtil
					.getcheckedInVehicleById(id);

			return returnValue;
		} catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String> updateVehicleStatus(int id, String status)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue = WorkshopServiceUtil.updateVehicleStatus(id,
					status);

			return returnValue;
		} catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopVehicles>> getcheckedInVehicleByIqmaId(
			String iqamaId) throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopVehicles>> returnValue = WorkshopServiceUtil
					.getcheckedInVehicleByIqmaId(iqamaId);

			return returnValue;
		} catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopList>> getWorkShopList()
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopList>> returnValue = WorkshopServiceUtil
					.getWorkShopList();

			return returnValue;
		} catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(WorkshopServiceSoap.class);

}