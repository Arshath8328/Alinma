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

import com.atmc.bsl.db.domain.ReturnCodes;
import com.atmc.bsl.db.domain.ServiceOutput;
import com.atmc.bsl.db.service.base.OTPServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.apache.commons.codec.binary.Hex;
import org.osgi.service.component.annotations.Component;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/**
 * The implementation of the otp remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.atmc.bsl.db.service.OTPService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OTPServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=dbbsl",
		"json.web.service.context.path=OTP"
	},
	service = AopService.class
)
public class OTPServiceImpl extends OTPServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ejada.atmc.bsl.db.service.OTPServiceUtil} to access the otp remote service.
	 */
	private static final Log _log = LogFactoryUtil.getLog(OTPServiceImpl.class);
	public ServiceOutput<String> sendOTP(String language, String otpSecret, String mobileNumber, String chkVal)
	{
		String mobileHashCheck = generateHash("CHECKQUOT" + mobileNumber + "CHECKQUOT");
		_log.info(chkVal);
		_log.info(mobileHashCheck);

		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		Locale locale ;
		if (language.equals("en"))
			locale = new Locale("en","US");
		else
			locale = new Locale("ar","SA");

		if(chkVal.equals(mobileHashCheck))
		{
			boolean otpSent = otpLocalService.sendOTP(locale, otpSecret, mobileNumber);
			if (otpSent)
				svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			else
				svcOutput.setOutputCode(ReturnCodes.FAIL);
		}
		else
		{
			_log.info("Mobile Number Tampered");
			svcOutput.setOutputCode(ReturnCodes.PARAM_TAMPERING_ERROR);
		}

		return svcOutput;
	}


	public ServiceOutput<String> resendOTP(String language, String mobileNumber,String chkVal)
	{
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		Locale locale ;
		if (language.equals("en"))
			locale = new Locale("en","US");
		else
			locale = new Locale("ar","SA");

		String mobileHashCheck = generateHash("CHECKQUOT" + mobileNumber + "CHECKQUOT");
		_log.info(chkVal);
		_log.info(mobileHashCheck);

		if(chkVal.equals(mobileHashCheck))
		{
			String otpSecret = otpLocalService.generateSecret();
			boolean otpSent = otpLocalService.sendOTP(locale, otpSecret, mobileNumber);
			if (otpSent)
			{
				svcOutput.setOutputCode(ReturnCodes.SUCCESS);
				svcOutput.setOutputObject(otpSecret);
			}
			else
				svcOutput.setOutputCode(ReturnCodes.FAIL);
		}
		else
		{
			_log.info("Mobile Number Tampered");
			svcOutput.setOutputCode(ReturnCodes.PARAM_TAMPERING_ERROR);
		}

		return svcOutput;
	}

	public ServiceOutput<String> validateOTP(String otpSecret, String otp)
	{
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		boolean otpValidated = otpLocalService.validateOTP(otpSecret, otp);
		if (otpValidated)
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
		else
			svcOutput.setOutputCode(ReturnCodes.FAIL);

		return svcOutput;

	}

	private static String generateHash(String data)
	{
		try
		{
//			MessageDigest sha1 = MessageDigest.getInstance("SHA1");
			MessageDigest sha1 = MessageDigest.getInstance("SHA-256");
			sha1.update(data.getBytes("UTF-8"));
			return new String(Hex.encodeHex(sha1.digest()));

		}
		catch (NoSuchAlgorithmException | UnsupportedEncodingException e)
		{
			_log.error("Error Generating quot Hash" + data);

			e.printStackTrace();
		}
		return null;
	}
}