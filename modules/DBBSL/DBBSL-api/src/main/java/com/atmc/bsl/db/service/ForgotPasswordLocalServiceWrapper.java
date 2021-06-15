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
 * Provides a wrapper for {@link ForgotPasswordLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ForgotPasswordLocalService
 * @generated
 */
public class ForgotPasswordLocalServiceWrapper
	implements ForgotPasswordLocalService,
			   ServiceWrapper<ForgotPasswordLocalService> {

	public ForgotPasswordLocalServiceWrapper(
		ForgotPasswordLocalService forgotPasswordLocalService) {

		_forgotPasswordLocalService = forgotPasswordLocalService;
	}

	@Override
	public void checkReminderQueries(
			String emailAddress, String answer, String captchaText)
		throws Exception {

		_forgotPasswordLocalService.checkReminderQueries(
			emailAddress, answer, captchaText);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _forgotPasswordLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.User validateUser(
			String emailAddress, String captchaText)
		throws Exception {

		return _forgotPasswordLocalService.validateUser(
			emailAddress, captchaText);
	}

	@Override
	public ForgotPasswordLocalService getWrappedService() {
		return _forgotPasswordLocalService;
	}

	@Override
	public void setWrappedService(
		ForgotPasswordLocalService forgotPasswordLocalService) {

		_forgotPasswordLocalService = forgotPasswordLocalService;
	}

	private ForgotPasswordLocalService _forgotPasswordLocalService;

}