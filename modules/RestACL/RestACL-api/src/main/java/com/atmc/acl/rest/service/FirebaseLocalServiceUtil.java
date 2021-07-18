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

package com.atmc.acl.rest.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Firebase. This utility wraps
 * <code>com.atmc.acl.rest.service.impl.FirebaseLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FirebaseLocalService
 * @generated
 */
public class FirebaseLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.atmc.acl.rest.service.impl.FirebaseLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @return the fcmUrl
	 */
	public static String getFcmUrl() {
		return getService().getFcmUrl();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @return the serverKey
	 */
	public static String getServerKey() {
		return getService().getServerKey();
	}

	public static void sendNotification(
		String tokenId, String title, String message) {

		getService().sendNotification(tokenId, title, message);
	}

	/**
	 * @param fcmUrl the fcmUrl to set
	 */
	public static void setFcmUrl(String fcmUrl) {
		getService().setFcmUrl(fcmUrl);
	}

	/**
	 * @param serverKey the serverKey to set
	 */
	public static void setServerKey(String serverKey) {
		getService().setServerKey(serverKey);
	}

	public static FirebaseLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FirebaseLocalService, FirebaseLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FirebaseLocalService.class);

		ServiceTracker<FirebaseLocalService, FirebaseLocalService>
			serviceTracker =
				new ServiceTracker<FirebaseLocalService, FirebaseLocalService>(
					bundle.getBundleContext(), FirebaseLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}