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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Workshop. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.WorkshopServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see WorkshopService
 * @generated
 */
public class WorkshopServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.WorkshopServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.atmc.bsl.db.domain.ServiceOutput<String> checkInVehicle(
		String customerName, String customerMobile, String manufacture,
		String plateNo, int workshopId, String claimRefNo, String status,
		String date, String serviceType, String desc, String vehMakeEn,
		String vehMakeAr, String vehModelEn, String vehModelAr,
		String customerIqamaId) {

		return getService().checkInVehicle(
			customerName, customerMobile, manufacture, plateNo, workshopId,
			claimRefNo, status, date, serviceType, desc, vehMakeEn, vehMakeAr,
			vehModelEn, vehModelAr, customerIqamaId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.workshop.WorkshopVehicles>
			getcheckedInVehicleById(int id) {

		return getService().getcheckedInVehicleById(id);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopVehicles>>
			getcheckedInVehicleByIqmaId(String iqamaId) {

		return getService().getcheckedInVehicleByIqmaId(iqamaId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopVehicles>>
			getcheckedInVehicleByStatus(String status, int workShopId) {

		return getService().getcheckedInVehicleByStatus(status, workShopId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopList>>
			getWorkShopList() {

		return getService().getWorkShopList();
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
		updateVehicleStatus(int id, String status) {

		return getService().updateVehicleStatus(id, status);
	}

	public static WorkshopService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WorkshopService, WorkshopService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(WorkshopService.class);

		ServiceTracker<WorkshopService, WorkshopService> serviceTracker =
			new ServiceTracker<WorkshopService, WorkshopService>(
				bundle.getBundleContext(), WorkshopService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}