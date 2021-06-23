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
 * Provides the local service utility for Settings. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.SettingsLocalServiceImpl</code> and is an
 * access point for service operations in application layer code running on the
 * local server. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SettingsLocalService
 * @generated
 */
public class SettingsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to
	 * <code>com.atmc.bsl.db.service.impl.SettingsLocalServiceImpl</code> and rerun
	 * ServiceBuilder to regenerate this class.
	 */
	public static void changePassword(com.liferay.portal.kernel.model.User user, String currentPassword,
			String password1, String password2) throws com.liferay.portal.kernel.exception.PortalException {

		getService().changePassword(user, currentPassword, password1, password2);
	}

	public static void changePasswordFn(long companyId, String screenName, String currentPassword, String password1,
			String password2) {

		getService().changePasswordFn(companyId, screenName, currentPassword, password1, password2);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static boolean updateEmail(com.liferay.portal.kernel.model.User user, String userEmail)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateEmail(user, userEmail);
	}

	public static boolean updateEmailFn(long companyId, String screenName, String Email)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateEmailFn(companyId, screenName, Email);
	}

	public static boolean updateMobile(com.liferay.portal.kernel.model.User user, String phone)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateMobile(user, phone);
	}

	public static boolean updateMobileFn(long companyId, String screenName, String phoneNo)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateMobileFn(companyId, screenName, phoneNo);
	}

	public static SettingsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SettingsLocalService, SettingsLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SettingsLocalService.class);

		ServiceTracker<SettingsLocalService, SettingsLocalService> serviceTracker = new ServiceTracker<SettingsLocalService, SettingsLocalService>(
				bundle.getBundleContext(), SettingsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}