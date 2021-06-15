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
 * Provides a wrapper for {@link QuotationAdminUploadsService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationAdminUploadsService
 * @generated
 */
public class QuotationAdminUploadsServiceWrapper
	implements QuotationAdminUploadsService,
			   ServiceWrapper<QuotationAdminUploadsService> {

	public QuotationAdminUploadsServiceWrapper(
		QuotationAdminUploadsService quotationAdminUploadsService) {

		_quotationAdminUploadsService = quotationAdminUploadsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _quotationAdminUploadsService.getOSGiServiceIdentifier();
	}

	@Override
	public QuotationAdminUploadsService getWrappedService() {
		return _quotationAdminUploadsService;
	}

	@Override
	public void setWrappedService(
		QuotationAdminUploadsService quotationAdminUploadsService) {

		_quotationAdminUploadsService = quotationAdminUploadsService;
	}

	private QuotationAdminUploadsService _quotationAdminUploadsService;

}