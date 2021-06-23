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
 * Provides the local service utility for ForgotPassword. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.ForgotPasswordLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ForgotPasswordLocalService
 * @generated
 */
public class ForgotPasswordLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to
	 * <code>com.atmc.bsl.db.service.impl.ForgotPasswordLocalServiceImpl</code> and
	 * rerun ServiceBuilder to regenerate this class.
	 */
	public static void checkReminderQueries(String emailAddress, String answer, String captchaText) throws Exception {

		getService().checkReminderQueries(emailAddress, answer, captchaText);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.User validateUser(String emailAddress, String captchaText)
			throws Exception {

		return getService().validateUser(emailAddress, captchaText);
	}

	public static ForgotPasswordLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ForgotPasswordLocalService, ForgotPasswordLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ForgotPasswordLocalService.class);

		ServiceTracker<ForgotPasswordLocalService, ForgotPasswordLocalService> serviceTracker = new ServiceTracker<ForgotPasswordLocalService, ForgotPasswordLocalService>(
				bundle.getBundleContext(), ForgotPasswordLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}