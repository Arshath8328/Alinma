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
 * Provides the local service utility for Login. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.LoginLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LoginLocalService
 * @generated
 */
public class LoginLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.LoginLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.ejada.atmc.bsl.db.domain.AuthUser authenticateUser(
			String login, String password)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().authenticateUser(login, password);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.Set<String> getReminderQueryQuestions()
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getReminderQueryQuestions();
	}

	public static com.ejada.atmc.bsl.db.domain.AuthUser login(
			String login, String password, String rememberMe)
		throws Exception {

		return getService().login(login, password, rememberMe);
	}

	public static void logout() throws Exception {
		getService().logout();
	}

	public static com.ejada.atmc.bsl.db.domain.AuthUser validateUser(
			String idIqama, String email)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().validateUser(idIqama, email);
	}

	public static LoginLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LoginLocalService, LoginLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LoginLocalService.class);

		ServiceTracker<LoginLocalService, LoginLocalService> serviceTracker =
			new ServiceTracker<LoginLocalService, LoginLocalService>(
				bundle.getBundleContext(), LoginLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}