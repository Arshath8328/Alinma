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
 * Provides a wrapper for {@link UserMgmtLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserMgmtLocalService
 * @generated
 */
public class UserMgmtLocalServiceWrapper
	implements ServiceWrapper<UserMgmtLocalService>, UserMgmtLocalService {

	public UserMgmtLocalServiceWrapper(
		UserMgmtLocalService userMgmtLocalService) {

		_userMgmtLocalService = userMgmtLocalService;
	}

	@Override
	public com.liferay.portal.kernel.model.User changeFirstTimeLoginPassword(
			long userId, String password, String reminderQueryQuestion,
			String reminderQueryAnswer)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userMgmtLocalService.changeFirstTimeLoginPassword(
			userId, password, reminderQueryQuestion, reminderQueryAnswer);
	}

	@Override
	public boolean createOrg(
		String orgCRNumber, String orgName, String orgArabicName,
		com.liferay.portal.kernel.service.ServiceContext context) {

		return _userMgmtLocalService.createOrg(
			orgCRNumber, orgName, orgArabicName, context);
	}

	@Override
	public com.liferay.portal.kernel.model.User createUser(
			long companyId, String login, String password, String englishName,
			String arabicName, java.util.Locale language, String mobile,
			String email,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userMgmtLocalService.createUser(
			companyId, login, password, englishName, arabicName, language,
			mobile, email, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.model.User createUser(
			long companyId, String login, String password, String englishName,
			String arabicName, java.util.Locale language, String mobile,
			String email,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			String reminderQueryQuestion, String reminderQueryAnswer)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userMgmtLocalService.createUser(
			companyId, login, password, englishName, arabicName, language,
			mobile, email, serviceContext, reminderQueryQuestion,
			reminderQueryAnswer);
	}

	@Override
	public long getAdminId() {
		return _userMgmtLocalService.getAdminId();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userMgmtLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public void synchronizeOrgs(
		com.liferay.portal.kernel.service.ServiceContext context) {

		_userMgmtLocalService.synchronizeOrgs(context);
	}

	@Override
	public UserMgmtLocalService getWrappedService() {
		return _userMgmtLocalService;
	}

	@Override
	public void setWrappedService(UserMgmtLocalService userMgmtLocalService) {
		_userMgmtLocalService = userMgmtLocalService;
	}

	private UserMgmtLocalService _userMgmtLocalService;

}