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
 * Provides the remote service utility for Login. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.LoginServiceImpl</code> and is an access
 * point for service operations in application layer code running on a remote
 * server. Methods of this service are expected to have security checks based on
 * the propagated JAAS credentials because this service can be accessed
 * remotely.
 *
 * @author Brian Wing Shun Chan
 * @see LoginService
 * @generated
 */
public class LoginServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to
	 * <code>com.atmc.bsl.db.service.impl.LoginServiceImpl</code> and rerun
	 * ServiceBuilder to regenerate this class.
	 */
	public static com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.AuthUser> authenticateUser(String login,
			String password) {

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

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.Set<String>> getReminderQueryQuestions() {

		return getService().getReminderQueryQuestions();
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.AuthUser> login(String login,
			String password, String rememberMe) {

		return getService().login(login, password, rememberMe);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String> logout() {
		return getService().logout();
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.AuthUser> validateUser(String idIqama,
			String email) {

		return getService().validateUser(idIqama, email);
	}

	public static LoginService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LoginService, LoginService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LoginService.class);

		ServiceTracker<LoginService, LoginService> serviceTracker = new ServiceTracker<LoginService, LoginService>(
				bundle.getBundleContext(), LoginService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}