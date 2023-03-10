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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for UserMgmt. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.UserMgmtServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see UserMgmtService
 * @generated
 */
public class UserMgmtServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.UserMgmtServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<com.liferay.portal.kernel.model.User> changeFirstTimeLoginPassword(
			long userId, String password, String reminderQueryQuestion,
			String reminderQueryAnswer) {

		return getService().changeFirstTimeLoginPassword(
			userId, password, reminderQueryQuestion, reminderQueryAnswer);
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<com.liferay.portal.kernel.model.User> createUser(
			long companyId, String login, String password, String englishName,
			String arabicName, String language, String mobile, String email,
			String reminderQueryQuestion, String reminderQueryAnswer) {

		return getService().createUser(
			companyId, login, password, englishName, arabicName, language,
			mobile, email, reminderQueryQuestion, reminderQueryAnswer);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static UserMgmtService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserMgmtService, UserMgmtService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserMgmtService.class);

		ServiceTracker<UserMgmtService, UserMgmtService> serviceTracker =
			new ServiceTracker<UserMgmtService, UserMgmtService>(
				bundle.getBundleContext(), UserMgmtService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}