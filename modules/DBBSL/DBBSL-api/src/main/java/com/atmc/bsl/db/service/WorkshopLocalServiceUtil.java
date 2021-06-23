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
 * Provides the local service utility for Workshop. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.WorkshopLocalServiceImpl</code> and is an
 * access point for service operations in application layer code running on the
 * local server. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WorkshopLocalService
 * @generated
 */
public class WorkshopLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to
	 * <code>com.atmc.bsl.db.service.impl.WorkshopLocalServiceImpl</code> and rerun
	 * ServiceBuilder to regenerate this class.
	 */
	public static void checkInVehicle(String customerName, String customerMobile, String manufacture, String plateNo,
			int workshopId, String claimRefNo, String status, String date, String serviceType, String desc,
			String vehMakeEn, String vehMakeAr, String vehModelEn, String vehModelAr, String customerIqamaId) {

		getService().checkInVehicle(customerName, customerMobile, manufacture, plateNo, workshopId, claimRefNo, status,
				date, serviceType, desc, vehMakeEn, vehMakeAr, vehModelEn, vehModelAr, customerIqamaId);
	}

	public static com.atmc.bsl.db.domain.workshop.WorkshopVehicles getcheckedInVehicleById(int id) {

		return getService().getcheckedInVehicleById(id);
	}

	public static java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopVehicles> getcheckedInVehicleByIqmaId(
			String iqamaId) {

		return getService().getcheckedInVehicleByIqmaId(iqamaId);
	}

	public static java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopVehicles> getcheckedInVehicleByStatus(
			String status, int workShopId) {

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

	public static void updateVehicleStatus(int id, String status) {
		getService().updateVehicleStatus(id, status);
	}

	public static WorkshopLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WorkshopLocalService, WorkshopLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(WorkshopLocalService.class);

		ServiceTracker<WorkshopLocalService, WorkshopLocalService> serviceTracker = new ServiceTracker<WorkshopLocalService, WorkshopLocalService>(
				bundle.getBundleContext(), WorkshopLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}