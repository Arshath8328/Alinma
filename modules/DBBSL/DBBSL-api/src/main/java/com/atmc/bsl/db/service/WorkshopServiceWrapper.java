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
 * Provides a wrapper for {@link WorkshopService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkshopService
 * @generated
 */
public class WorkshopServiceWrapper implements ServiceWrapper<WorkshopService>, WorkshopService {

	public WorkshopServiceWrapper(WorkshopService workshopService) {
		_workshopService = workshopService;
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> checkInVehicle(String customerName, String customerMobile,
			String manufacture, String plateNo, int workshopId, String claimRefNo, String status, String date,
			String serviceType, String desc, String vehMakeEn, String vehMakeAr, String vehModelEn, String vehModelAr,
			String customerIqamaId) {

		return _workshopService.checkInVehicle(customerName, customerMobile, manufacture, plateNo, workshopId,
				claimRefNo, status, date, serviceType, desc, vehMakeEn, vehMakeAr, vehModelEn, vehModelAr,
				customerIqamaId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.workshop.WorkshopVehicles> getcheckedInVehicleById(
			int id) {

		return _workshopService.getcheckedInVehicleById(id);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopVehicles>> getcheckedInVehicleByIqmaId(
			String iqamaId) {

		return _workshopService.getcheckedInVehicleByIqmaId(iqamaId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopVehicles>> getcheckedInVehicleByStatus(
			String status, int workShopId) {

		return _workshopService.getcheckedInVehicleByStatus(status, workShopId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _workshopService.getOSGiServiceIdentifier();
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.workshop.WorkshopList>> getWorkShopList() {

		return _workshopService.getWorkShopList();
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> updateVehicleStatus(int id, String status) {

		return _workshopService.updateVehicleStatus(id, status);
	}

	@Override
	public WorkshopService getWrappedService() {
		return _workshopService;
	}

	@Override
	public void setWrappedService(WorkshopService workshopService) {
		_workshopService = workshopService;
	}

	private WorkshopService _workshopService;

}