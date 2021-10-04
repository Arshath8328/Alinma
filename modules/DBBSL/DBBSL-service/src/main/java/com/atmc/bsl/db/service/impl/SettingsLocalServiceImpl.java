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

import com.atmc.bsl.db.service.base.SettingsLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.PasswordTrackerLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the settings local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.SettingsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SettingsLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.atmc.bsl.db.model.Settings", service = AopService.class)
public class SettingsLocalServiceImpl extends SettingsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.atmc.bsl.db.service.SettingsLocalServiceUtil} to access the
	 * settings local service.
	 */
	public boolean updateEmail(User user, String userEmail) throws PortalException {

		user.setEmailAddress(userEmail);
		User updatedUser = UserLocalServiceUtil.fetchUserByEmailAddress(user.getCompanyId(), userEmail);
		if (updatedUser != null) {
			UserEmailAddressException.MustNotBeDuplicate e = new UserEmailAddressException.MustNotBeDuplicate(
					user.getUserId(), userEmail);
			throw e;
		} else {
			UserLocalServiceUtil.updateUser(user);
		}

		return true;

	}

	public boolean updateMobile(User user, String phone) throws PortalException {
		try {

			Phone userPhone = PhoneLocalServiceUtil
					.getPhones(user.getCompanyId(), Contact.class.getName(), user.getContactId()).get(0);
			userPhone.setNumber(phone);
			PhoneLocalServiceUtil.updatePhone(userPhone);
			UserLocalServiceUtil.updateUser(user);
			return true;
		} catch (Exception e) {
			// TDO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public void changePassword(User user, String currentPassword, String password1, String password2)
			throws PortalException {

		if (!PasswordTrackerLocalServiceUtil.isSameAsCurrentPassword(user.getUserId(), currentPassword)) {
			UserPasswordException.MustMatchCurrentPassword e = new UserPasswordException.MustMatchCurrentPassword(
					user.getUserId());

			throw e;
		}
//			if(PasswordTrackerLocalServiceUtil.isValidPassword(user.getUserId(), password1)){
//				return "notValid";
//			}
		UserLocalServiceUtil.updatePassword(user.getUserId(), password1, password2, false);

	}

	public boolean updateEmailFn(long companyId, String screenName, String Email) throws PortalException {
		User user = UserLocalServiceUtil.fetchUserByScreenName(companyId, screenName);
		return updateEmail(user, Email);
	}

	public boolean updateMobileFn(long companyId, String screenName, String phoneNo) throws PortalException {
		User user = UserLocalServiceUtil.fetchUserByScreenName(companyId, screenName);
		return updateMobile(user, phoneNo);
	}

	public void changePasswordFn(long companyId, String screenName, String currentPassword, String password1,
			String password2) {
		User user = UserLocalServiceUtil.fetchUserByScreenName(companyId, screenName);
		try {
			changePassword(user, currentPassword, password1, password2);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}