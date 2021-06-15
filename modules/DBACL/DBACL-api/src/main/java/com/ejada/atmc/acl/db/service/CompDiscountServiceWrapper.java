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
 * Provides a wrapper for {@link CompDiscountService}.
 *
 * @author Brian Wing Shun Chan
 * @see CompDiscountService
 * @generated
 */
public class CompDiscountServiceWrapper
	implements CompDiscountService, ServiceWrapper<CompDiscountService> {

	public CompDiscountServiceWrapper(CompDiscountService compDiscountService) {
		_compDiscountService = compDiscountService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _compDiscountService.getOSGiServiceIdentifier();
	}

	@Override
	public CompDiscountService getWrappedService() {
		return _compDiscountService;
	}

	@Override
	public void setWrappedService(CompDiscountService compDiscountService) {
		_compDiscountService = compDiscountService;
	}

	private CompDiscountService _compDiscountService;

}