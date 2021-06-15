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
public class WorkshopServiceWrapper
	implements ServiceWrapper<WorkshopService>, WorkshopService {

	public WorkshopServiceWrapper(WorkshopService workshopService) {
		_workshopService = workshopService;
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
	public WorkshopService getWrappedService() {
		return _workshopService;
	}

	@Override
	public void setWrappedService(WorkshopService workshopService) {
		_workshopService = workshopService;
	}

	private WorkshopService _workshopService;

}