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
 * Provides a wrapper for {@link QuotationSurveyService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationSurveyService
 * @generated
 */
public class QuotationSurveyServiceWrapper
	implements QuotationSurveyService, ServiceWrapper<QuotationSurveyService> {

	public QuotationSurveyServiceWrapper(
		QuotationSurveyService quotationSurveyService) {

		_quotationSurveyService = quotationSurveyService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _quotationSurveyService.getOSGiServiceIdentifier();
	}

	@Override
	public QuotationSurveyService getWrappedService() {
		return _quotationSurveyService;
	}

	@Override
	public void setWrappedService(
		QuotationSurveyService quotationSurveyService) {

		_quotationSurveyService = quotationSurveyService;
	}

	private QuotationSurveyService _quotationSurveyService;

}