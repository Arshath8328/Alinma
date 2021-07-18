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

import com.atmc.bsl.db.domain.ServiceOutput;
import com.atmc.bsl.db.domain.workshop.WorkshopList;
import com.atmc.bsl.db.domain.workshop.WorkshopVehicles;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Workshop. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see WorkshopServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface WorkshopService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.WorkshopServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the workshop remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link WorkshopServiceUtil} if injection and service tracking are not available.
	 */
	public ServiceOutput<String> checkInVehicle(
		String customerName, String customerMobile, String manufacture,
		String plateNo, int workshopId, String claimRefNo, String status,
		String date, String serviceType, String desc, String vehMakeEn,
		String vehMakeAr, String vehModelEn, String vehModelAr,
		String customerIqamaId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<WorkshopVehicles> getcheckedInVehicleById(int id);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<WorkshopVehicles>> getcheckedInVehicleByIqmaId(
		String iqamaId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<WorkshopVehicles>> getcheckedInVehicleByStatus(
		String status, int workShopId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<WorkshopList>> getWorkShopList();

	public ServiceOutput<String> updateVehicleStatus(int id, String status);

}