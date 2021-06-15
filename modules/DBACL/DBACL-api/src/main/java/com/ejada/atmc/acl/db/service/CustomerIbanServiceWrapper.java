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
 * Provides a wrapper for {@link CustomerIbanService}.
 *
 * @author Brian Wing Shun Chan
 * @see CustomerIbanService
 * @generated
 */
public class CustomerIbanServiceWrapper
	implements CustomerIbanService, ServiceWrapper<CustomerIbanService> {

	public CustomerIbanServiceWrapper(CustomerIbanService customerIbanService) {
		_customerIbanService = customerIbanService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _customerIbanService.getOSGiServiceIdentifier();
	}

	@Override
	public CustomerIbanService getWrappedService() {
		return _customerIbanService;
	}

	@Override
	public void setWrappedService(CustomerIbanService customerIbanService) {
		_customerIbanService = customerIbanService;
	}

	private CustomerIbanService _customerIbanService;

}