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
 * Provides a wrapper for {@link OTPLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OTPLocalService
 * @generated
 */
public class OTPLocalServiceWrapper implements OTPLocalService, ServiceWrapper<OTPLocalService> {

	public OTPLocalServiceWrapper(OTPLocalService otpLocalService) {
		_otpLocalService = otpLocalService;
	}

	@Override
	public String generateOTP(String otpSecret) {
		return _otpLocalService.generateOTP(otpSecret);
	}

	@Override
	public String generateSecret() {
		return _otpLocalService.generateSecret();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _otpLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public boolean sendOTP(java.util.Locale locale, String otpSecret, String mobileNumber) {

		return _otpLocalService.sendOTP(locale, otpSecret, mobileNumber);
	}

	@Override
	public boolean sendOTPToEmail(java.util.Locale locale, String otpSecret, String emailAddress) {

		return _otpLocalService.sendOTPToEmail(locale, otpSecret, emailAddress);
	}

	@Override
	public boolean validateOTP(String otpSecret, String otp) {
		return _otpLocalService.validateOTP(otpSecret, otp);
	}

	@Override
	public OTPLocalService getWrappedService() {
		return _otpLocalService;
	}

	@Override
	public void setWrappedService(OTPLocalService otpLocalService) {
		_otpLocalService = otpLocalService;
	}

	private OTPLocalService _otpLocalService;

}