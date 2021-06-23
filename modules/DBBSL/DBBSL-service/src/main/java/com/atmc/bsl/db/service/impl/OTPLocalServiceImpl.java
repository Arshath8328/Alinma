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

package com.atmc.bsl.db.service.impl;

import com.atmc.bsl.db.service.base.OTPLocalServiceBaseImpl;
import com.atmc.bsl.db.util.TOTPUtils;
import com.ejada.atmc.acl.db.service.SMSLocalServiceUtil;
import com.ejada.atmc.acl.db.service.SendEmailServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import java.sql.SQLException;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the otp local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.OTPLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OTPLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.atmc.bsl.db.model.OTP", service = AopService.class)
public class OTPLocalServiceImpl extends OTPLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.ejada.atmc.bsl.db.service.OTPLocalServiceUtil} to access the otp local
	 * service.
	 * 
	 * 
	 */

	public static final String SMS_TEMPLATE_KEY = "plz_activation_code";
	public static final String EMAIL_SUBJECT_KEY = "otp_email_subject";
	public static final String EMAIL_BODY_KEY = "otp_email_body";

	public boolean sendOTP(Locale locale, String otpSecret, String mobileNumber) {
		boolean otpSent = false;
		String otp = generateOTP(otpSecret);
		_log.info("Generated OTP:" + otp);
		if (otp != null) {
			String smsMsg = LanguageUtil.format(locale, SMS_TEMPLATE_KEY, otp);
			try {
				try {
					SMSLocalServiceUtil.sendSms(smsMsg, mobileNumber);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				otpSent = true;
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}

		return otpSent;
	}

	public boolean sendOTPToEmail(Locale locale, String otpSecret, String emailAddress) {
		boolean otpSent = false;
		String otp = generateOTP(otpSecret);
		_log.info("Generated OTP:" + otp);
		if (otp != null) {
			String emailMsg = LanguageUtil.format(locale, EMAIL_BODY_KEY, otp);
			otpSent = SendEmailServiceUtil.sendEmail(emailAddress, LanguageUtil.get(locale, EMAIL_SUBJECT_KEY),
					emailMsg, null, null);
		}

		return otpSent;
	}

	public String generateOTP(String otpSecret) {
		String otp = null;
		try {
			otp = String.valueOf(TOTPUtils.generateTOTP(otpSecret));
		} catch (Exception e) {
			_log.error("Failed to generate OTP", e);
			e.printStackTrace();
		}

		return Validator.isNotNull(PropsUtil.get("static.otp")) ? PropsUtil.get("static.otp") : otp;

	}

	public boolean validateOTP(String otpSecret, String otp) {
		_log.info("Validating OTP");
		boolean isValid = false;
		try {
			isValid = TOTPUtils.checkCode(otpSecret, Long.parseLong(otp));
		} catch (Exception e) {
			e.printStackTrace();
		}

		_log.info("OTP Validation Result:" + isValid);
		return isValid;
	}

	public String generateSecret() {
		return TOTPUtils.generateSecret();
	}

	private static final Log _log = LogFactoryUtil.getLog(OTPLocalServiceImpl.class);

}