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
 * Provides the remote service utility for Settings. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.SettingsServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SettingsService
 * @generated
 */
public class SettingsServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.SettingsServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String> changePassword(
		String companyId, String screenName, String currentPassword,
		String password1, String password2) {

		return getService().changePassword(
			companyId, screenName, currentPassword, password1, password2);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String> updateEmail(
			String companyId, String screenName, String Email)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateEmail(companyId, screenName, Email);
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String> updateMobile(
			String companyId, String screenName, String phoneNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateMobile(companyId, screenName, phoneNo);
	}

	public static SettingsService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SettingsService, SettingsService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SettingsService.class);

		ServiceTracker<SettingsService, SettingsService> serviceTracker =
			new ServiceTracker<SettingsService, SettingsService>(
				bundle.getBundleContext(), SettingsService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}