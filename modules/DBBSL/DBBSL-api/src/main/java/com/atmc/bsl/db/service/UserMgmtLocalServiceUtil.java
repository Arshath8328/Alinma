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
 * Provides the local service utility for UserMgmt. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.UserMgmtLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserMgmtLocalService
 * @generated
 */
public class UserMgmtLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.UserMgmtLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.User
			changeFirstTimeLoginPassword(
				long userId, String password, String reminderQueryQuestion,
				String reminderQueryAnswer)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().changeFirstTimeLoginPassword(
			userId, password, reminderQueryQuestion, reminderQueryAnswer);
	}

	public static boolean createOrg(
		String orgCRNumber, String orgName, String orgArabicName,
		com.liferay.portal.kernel.service.ServiceContext context) {

		return getService().createOrg(
			orgCRNumber, orgName, orgArabicName, context);
	}

	public static com.liferay.portal.kernel.model.User createUser(
			long companyId, String login, String password, String englishName,
			String arabicName, java.util.Locale language, String mobile,
			String email,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createUser(
			companyId, login, password, englishName, arabicName, language,
			mobile, email, serviceContext);
	}

	public static com.liferay.portal.kernel.model.User createUser(
			long companyId, String login, String password, String englishName,
			String arabicName, java.util.Locale language, String mobile,
			String email,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			String reminderQueryQuestion, String reminderQueryAnswer)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createUser(
			companyId, login, password, englishName, arabicName, language,
			mobile, email, serviceContext, reminderQueryQuestion,
			reminderQueryAnswer);
	}

	public static long getAdminId() {
		return getService().getAdminId();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void synchronizeOrgs(
		com.liferay.portal.kernel.service.ServiceContext context) {

		getService().synchronizeOrgs(context);
	}

	public static UserMgmtLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserMgmtLocalService, UserMgmtLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserMgmtLocalService.class);

		ServiceTracker<UserMgmtLocalService, UserMgmtLocalService>
			serviceTracker =
				new ServiceTracker<UserMgmtLocalService, UserMgmtLocalService>(
					bundle.getBundleContext(), UserMgmtLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}