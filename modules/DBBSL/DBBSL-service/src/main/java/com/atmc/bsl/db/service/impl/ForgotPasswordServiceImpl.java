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
import com.atmc.bsl.db.service.ForgotPasswordLocalServiceUtil;
import com.atmc.bsl.db.service.base.ForgotPasswordServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the forgot password remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.ForgotPasswordService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ForgotPasswordServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=dbbsl",
		"json.web.service.context.path=ForgotPassword" }, service = AopService.class)
public class ForgotPasswordServiceImpl extends ForgotPasswordServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.atmc.bsl.db.service.ForgotPasswordServiceUtil} to access the forgot
	 * password remote service.
	 */
	private static final Log _log = LogFactoryUtil.getLog(ForgotPasswordServiceImpl.class);

	public ServiceOutput<User> validateUser(String emailAddress, String captchaText) {

		ServiceOutput<User> svcOutput = new ServiceOutput<User>();
		try {
			User user = ForgotPasswordLocalServiceUtil.validateUser(emailAddress, captchaText);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(user);
		} catch (Exception e) {
			_log.error(e);
			svcOutput.setOutputCode(ReturnCodes.getErrorCode(e.getClass()));
		}

		return svcOutput;

	}

	public ServiceOutput<String> checkReminderQueries(String emailAddress, String answer, String captchaText) {

		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			ForgotPasswordLocalServiceUtil.checkReminderQueries(emailAddress, answer, captchaText);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
		} catch (Exception e) {
			_log.error(e);
			svcOutput.setOutputCode(ReturnCodes.getErrorCode(e.getClass()));
		}

		return svcOutput;

	}

}