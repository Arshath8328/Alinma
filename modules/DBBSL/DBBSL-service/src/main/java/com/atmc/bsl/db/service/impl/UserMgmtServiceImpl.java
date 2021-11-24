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

import com.atmc.bsl.db.service.UserMgmtLocalServiceUtil;
import com.atmc.bsl.db.service.base.UserMgmtServiceBaseImpl;
import com.ejada.atmc.bsl.db.domain.ReturnCodes;
import com.ejada.atmc.bsl.db.domain.ServiceOutput;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.access.control.AccessControlUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

/**
 * The implementation of the user mgmt remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.UserMgmtService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserMgmtServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=dbbsl",
		"json.web.service.context.path=UserMgmt" }, service = AopService.class)
public class UserMgmtServiceImpl extends UserMgmtServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.atmc.bsl.db.service.UserMgmtServiceUtil} to access the user mgmt
	 * remote service.
	 */
	private static final Log _log = LogFactoryUtil.getLog(UserMgmtServiceImpl.class);

	public ServiceOutput<User> createUser(long companyId, String login, String password, String englishName,
			String arabicName, String language, String mobile, String email, String reminderQueryQuestion,
			String reminderQueryAnswer) {

		Locale locale;
		if (language.equals("en"))
			locale = new Locale("en", "US");
		else
			locale = new Locale("ar", "SA");

		HttpServletRequest request = AccessControlUtil.getAccessControlContext().getRequest();

		ServiceOutput<User> svcOutput = new ServiceOutput<User>();
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), request);
			User user = UserMgmtLocalServiceUtil.createUser(companyId, login, password, englishName, arabicName, locale,
					mobile, email, serviceContext, reminderQueryQuestion, reminderQueryAnswer);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(user);
		} catch (Exception e) {
			_log.error(e);
			svcOutput.setOutputCode(ReturnCodes.getErrorCode(e.getClass()));
		}

		return svcOutput;

	}

	public ServiceOutput<User> changeFirstTimeLoginPassword(long userId, String password, String reminderQueryQuestion,
			String reminderQueryAnswer) {

		ServiceOutput<User> svcOutput = new ServiceOutput<User>();
		try {
			User user = UserMgmtLocalServiceUtil.changeFirstTimeLoginPassword(userId, password, reminderQueryQuestion,
					reminderQueryAnswer);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(user);
		} catch (Exception e) {
			_log.error(e);
			svcOutput.setOutputCode(ReturnCodes.getErrorCode(e.getClass()));
		}

		return svcOutput;

	}

}