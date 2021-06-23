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
 * Provides a wrapper for {@link ForgotPasswordService}.
 *
 * @author Brian Wing Shun Chan
 * @see ForgotPasswordService
 * @generated
 */
public class ForgotPasswordServiceWrapper implements ForgotPasswordService, ServiceWrapper<ForgotPasswordService> {

	public ForgotPasswordServiceWrapper(ForgotPasswordService forgotPasswordService) {

		_forgotPasswordService = forgotPasswordService;
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> checkReminderQueries(String emailAddress, String answer,
			String captchaText) {

		return _forgotPasswordService.checkReminderQueries(emailAddress, answer, captchaText);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _forgotPasswordService.getOSGiServiceIdentifier();
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<com.liferay.portal.kernel.model.User> validateUser(String emailAddress,
			String captchaText) {

		return _forgotPasswordService.validateUser(emailAddress, captchaText);
	}

	@Override
	public ForgotPasswordService getWrappedService() {
		return _forgotPasswordService;
	}

	@Override
	public void setWrappedService(ForgotPasswordService forgotPasswordService) {
		_forgotPasswordService = forgotPasswordService;
	}

	private ForgotPasswordService _forgotPasswordService;

}