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

import com.atmc.bsl.db.service.base.ForgotPasswordLocalServiceBaseImpl;
import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.RequiredReminderQueryException;
import com.liferay.portal.kernel.exception.UserActiveException;
import com.liferay.portal.kernel.exception.UserReminderQueryException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.access.control.AccessControlUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the forgot password local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.ForgotPasswordLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ForgotPasswordLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.atmc.bsl.db.model.ForgotPassword", service = AopService.class)
public class ForgotPasswordLocalServiceImpl extends ForgotPasswordLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.ejada.atmc.bsl.db.service.ForgotPasswordLocalServiceUtil} to access the
	 * forgot password local service.
	 */

	public User validateUser(String emailAddress, String captchaText) throws Exception {
		HttpServletRequest request = PortalUtil
				.getOriginalServletRequest(AccessControlUtil.getAccessControlContext().getRequest());
		HttpSession session = request.getSession();
		Company company = PortalUtil.getCompany(request);
		session.setAttribute(WebKeys.CAPTCHA_COUNT, new Integer(0));
		CaptchaUtil.check(request);
		session.removeAttribute(WebKeys.FORGOT_PASSWORD_REMINDER_ATTEMPTS);
		User user = getUser(company.getCompanyId(), emailAddress);
		return user;
	}

	public void checkReminderQueries(String emailAddress, String answer, String captchaText) throws Exception {

		HttpServletRequest request = PortalUtil
				.getOriginalServletRequest(AccessControlUtil.getAccessControlContext().getRequest());
		HttpSession session = request.getSession();

		Company company = PortalUtil.getCompany(request);

		User user = getUser(company.getCompanyId(), emailAddress);

		Integer reminderAttempts = (Integer) session.getAttribute(WebKeys.FORGOT_PASSWORD_REMINDER_ATTEMPTS);

		if (reminderAttempts == null) {
			reminderAttempts = 0;
		} else if (reminderAttempts > 2) {
			session.setAttribute(WebKeys.CAPTCHA_COUNT, new Integer(0));
			CaptchaUtil.check(request);
		}

		reminderAttempts++;

		session.setAttribute(WebKeys.FORGOT_PASSWORD_REMINDER_ATTEMPTS, reminderAttempts);

		if (GetterUtil.getBoolean(PropsUtil.get(PropsKeys.USERS_REMINDER_QUERIES_ENABLED))) {
			if (GetterUtil.getBoolean(PropsUtil.get(PropsKeys.USERS_REMINDER_QUERIES_REQUIRED))
					&& !user.hasReminderQuery()) {

				throw new RequiredReminderQueryException(
						"No reminder query or answer is defined for user " + user.getUserId());
			}

			if (!user.getReminderQueryAnswer().equals(answer)) {
				throw new UserReminderQueryException("Reminder query answer does not match answer");
			}
		}

		sendPassword(emailAddress, request);

	}

	protected User getUser(long companyId, String emailAddress) throws Exception {

		User user = null;

		if (Validator.isNotNull(emailAddress)) {
			user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
		}

		if (!user.isActive()) {
			throw new UserActiveException("Inactive user " + user.getUuid());
		}

		UserLocalServiceUtil.checkLockout(user);

		return user;
	}

	protected void sendPassword(String emailAddress, HttpServletRequest request) throws Exception {

		String emailFromName = null;
		String emailFromAddress = null;
		String emailToAddress = emailAddress;
		String subject = null;
		String body = null;
		Company company = PortalUtil.getCompany(request);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), request);

		UserLocalServiceUtil.sendPassword(company.getCompanyId(), emailToAddress, emailFromName, emailFromAddress,
				subject, body, serviceContext);

	}

}