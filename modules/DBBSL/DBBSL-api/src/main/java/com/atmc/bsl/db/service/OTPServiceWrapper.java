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
 * Provides a wrapper for {@link OTPService}.
 *
 * @author Brian Wing Shun Chan
 * @see OTPService
 * @generated
 */
public class OTPServiceWrapper
	implements OTPService, ServiceWrapper<OTPService> {

	public OTPServiceWrapper(OTPService otpService) {
		_otpService = otpService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _otpService.getOSGiServiceIdentifier();
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> resendOTP(
		String language, String mobileNumber, String chkVal) {

		return _otpService.resendOTP(language, mobileNumber, chkVal);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> sendOTP(
		String language, String otpSecret, String mobileNumber, String chkVal) {

		return _otpService.sendOTP(language, otpSecret, mobileNumber, chkVal);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> validateOTP(
		String otpSecret, String otp) {

		return _otpService.validateOTP(otpSecret, otp);
	}

	@Override
	public OTPService getWrappedService() {
		return _otpService;
	}

	@Override
	public void setWrappedService(OTPService otpService) {
		_otpService = otpService;
	}

	private OTPService _otpService;

}