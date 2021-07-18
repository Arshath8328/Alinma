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
 * Provides a wrapper for {@link UserMgmtService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserMgmtService
 * @generated
 */
public class UserMgmtServiceWrapper
	implements ServiceWrapper<UserMgmtService>, UserMgmtService {

	public UserMgmtServiceWrapper(UserMgmtService userMgmtService) {
		_userMgmtService = userMgmtService;
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<com.liferay.portal.kernel.model.User> changeFirstTimeLoginPassword(
			long userId, String password, String reminderQueryQuestion,
			String reminderQueryAnswer) {

		return _userMgmtService.changeFirstTimeLoginPassword(
			userId, password, reminderQueryQuestion, reminderQueryAnswer);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<com.liferay.portal.kernel.model.User> createUser(
			long companyId, String login, String password, String englishName,
			String arabicName, String language, String mobile, String email,
			String reminderQueryQuestion, String reminderQueryAnswer) {

		return _userMgmtService.createUser(
			companyId, login, password, englishName, arabicName, language,
			mobile, email, reminderQueryQuestion, reminderQueryAnswer);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userMgmtService.getOSGiServiceIdentifier();
	}

	@Override
	public UserMgmtService getWrappedService() {
		return _userMgmtService;
	}

	@Override
	public void setWrappedService(UserMgmtService userMgmtService) {
		_userMgmtService = userMgmtService;
	}

	private UserMgmtService _userMgmtService;

}