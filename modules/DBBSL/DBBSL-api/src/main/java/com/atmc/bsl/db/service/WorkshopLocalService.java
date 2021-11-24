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

import com.ejada.atmc.bsl.db.domain.workshop.WorkshopVehicles;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Workshop. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see WorkshopLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface WorkshopLocalService extends BaseLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.WorkshopLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the workshop local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link WorkshopLocalServiceUtil} if injection and service tracking are not available.
	 */
	public void checkInVehicle(
		String customerName, String customerMobile, String manufacture,
		String plateNo, int workshopId, String claimRefNo, String status,
		String date, String serviceType, String desc, String vehMakeEn,
		String vehMakeAr, String vehModelEn, String vehModelAr,
		String customerIqamaId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WorkshopVehicles getcheckedInVehicleById(int id);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<WorkshopVehicles> getcheckedInVehicleByIqmaId(String iqamaId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<WorkshopVehicles> getcheckedInVehicleByStatus(
		String status, int workShopId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public void updateVehicleStatus(int id, String status);

}