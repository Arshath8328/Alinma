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

package com.ejada.atmc.acl.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ServiceRequestMessagesService}.
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestMessagesService
 * @generated
 */
public class ServiceRequestMessagesServiceWrapper
	implements ServiceRequestMessagesService,
			   ServiceWrapper<ServiceRequestMessagesService> {

	public ServiceRequestMessagesServiceWrapper(
		ServiceRequestMessagesService serviceRequestMessagesService) {

		_serviceRequestMessagesService = serviceRequestMessagesService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _serviceRequestMessagesService.getOSGiServiceIdentifier();
	}

	@Override
	public ServiceRequestMessagesService getWrappedService() {
		return _serviceRequestMessagesService;
	}

	@Override
	public void setWrappedService(
		ServiceRequestMessagesService serviceRequestMessagesService) {

		_serviceRequestMessagesService = serviceRequestMessagesService;
	}

	private ServiceRequestMessagesService _serviceRequestMessagesService;

}