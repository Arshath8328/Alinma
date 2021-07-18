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
 * Provides the local service utility for Notifications. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.NotificationsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see NotificationsLocalService
 * @generated
 */
public class NotificationsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.NotificationsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addNotification(
		long userId, String msgKey, String[] params, String notificationType,
		long companyId) {

		getService().addNotification(
			userId, msgKey, params, notificationType, companyId);
	}

	public static void deleteAllNotifications(long[] userNotificationEventIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteAllNotifications(userNotificationEventIds);
	}

	public static void deleteUserNotificationEvent(long userNotificationEventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteUserNotificationEvent(userNotificationEventId);
	}

	public static java.util.List
		<com.liferay.portal.kernel.model.UserNotificationEvent>
				getAllNotifications(long userId, boolean actionRequired)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAllNotifications(userId, actionRequired);
	}

	public static long getAllNotificationsCount(
			long userId, boolean actionRequired)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAllNotificationsCount(userId, actionRequired);
	}

	public static java.util.List
		<com.liferay.portal.kernel.model.UserNotificationEvent>
				getNotifications(
					long userId, boolean actionRequired, String mode, int start,
					int end)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getNotifications(
			userId, actionRequired, mode, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static long getUnreadNotificationsCount(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUnreadNotificationsCount(userId);
	}

	public static void markAllNotificationsAsRead(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().markAllNotificationsAsRead(userId);
	}

	public static void markNotificationAsRead(long userNotificationEventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().markNotificationAsRead(userNotificationEventId);
	}

	public static void markNotificationAsUnread(long userNotificationEventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().markNotificationAsUnread(userNotificationEventId);
	}

	public static void markNotificationsAsRead(long[] userNotificationEventIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().markNotificationsAsRead(userNotificationEventIds);
	}

	public static void markNotificationsAsUnread(
			long[] userNotificationEventIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().markNotificationsAsUnread(userNotificationEventIds);
	}

	public static void notifyUser(
			java.util.Locale locale, String notificationType, String mailTo,
			String mobileNo, String[] mailParams, String[] smsParams,
			java.util.List<java.io.File> attachedFiles,
			java.util.List<String> filesName, String[] portalNotificationParams,
			long userId, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().notifyUser(
			locale, notificationType, mailTo, mobileNo, mailParams, smsParams,
			attachedFiles, filesName, portalNotificationParams, userId,
			companyId);
	}

	public static NotificationsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<NotificationsLocalService, NotificationsLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			NotificationsLocalService.class);

		ServiceTracker<NotificationsLocalService, NotificationsLocalService>
			serviceTracker =
				new ServiceTracker
					<NotificationsLocalService, NotificationsLocalService>(
						bundle.getBundleContext(),
						NotificationsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}