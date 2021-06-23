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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WorkshopLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkshopLocalService
 * @generated
 */
public class WorkshopLocalServiceWrapper implements ServiceWrapper<WorkshopLocalService>, WorkshopLocalService {

	public WorkshopLocalServiceWrapper(WorkshopLocalService workshopLocalService) {

		_workshopLocalService = workshopLocalService;
	}

	@Override
	public void checkInVehicle(String customerName, String customerMobile, String manufacture, String plateNo,
			int workshopId, String claimRefNo, String status, String date, String serviceType, String desc,
			String vehMakeEn, String vehMakeAr, String vehModelEn, String vehModelAr, String customerIqamaId) {

		_workshopLocalService.checkInVehicle(customerName, customerMobile, manufacture, plateNo, workshopId, claimRefNo,
				status, date, serviceType, desc, vehMakeEn, vehMakeAr, vehModelEn, vehModelAr, customerIqamaId);
	}

	@Override
	public com.atmc.bsl.db.domain.workshop.WorkshopVehicles getcheckedInVehicleById(int id) {

		return _workshopLocalService.getcheckedInVehicleById(id);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopVehicles> getcheckedInVehicleByIqmaId(
			String iqamaId) {

		return _workshopLocalService.getcheckedInVehicleByIqmaId(iqamaId);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopVehicles> getcheckedInVehicleByStatus(String status,
			int workShopId) {

		return _workshopLocalService.getcheckedInVehicleByStatus(status, workShopId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _workshopLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public void updateVehicleStatus(int id, String status) {
		_workshopLocalService.updateVehicleStatus(id, status);
	}

	@Override
	public WorkshopLocalService getWrappedService() {
		return _workshopLocalService;
	}

	@Override
	public void setWrappedService(WorkshopLocalService workshopLocalService) {
		_workshopLocalService = workshopLocalService;
	}

	private WorkshopLocalService _workshopLocalService;

}