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
 * Provides a wrapper for {@link NotificationsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see NotificationsLocalService
 * @generated
 */
public class NotificationsLocalServiceWrapper
	implements NotificationsLocalService,
			   ServiceWrapper<NotificationsLocalService> {

	public NotificationsLocalServiceWrapper(
		NotificationsLocalService notificationsLocalService) {

		_notificationsLocalService = notificationsLocalService;
	}

	@Override
	public void addNotification(
		long userId, String msgKey, String[] params, String notificationType,
		long companyId) {

		_notificationsLocalService.addNotification(
			userId, msgKey, params, notificationType, companyId);
	}

	@Override
	public void deleteAllNotifications(long[] userNotificationEventIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		_notificationsLocalService.deleteAllNotifications(
			userNotificationEventIds);
	}

	@Override
	public void deleteUserNotificationEvent(long userNotificationEventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_notificationsLocalService.deleteUserNotificationEvent(
			userNotificationEventId);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.UserNotificationEvent>
			getAllNotifications(long userId, boolean actionRequired)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notificationsLocalService.getAllNotifications(
			userId, actionRequired);
	}

	@Override
	public long getAllNotificationsCount(long userId, boolean actionRequired)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notificationsLocalService.getAllNotificationsCount(
			userId, actionRequired);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.UserNotificationEvent>
			getNotifications(
				long userId, boolean actionRequired, String mode, int start,
				int end)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notificationsLocalService.getNotifications(
			userId, actionRequired, mode, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _notificationsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public long getUnreadNotificationsCount(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notificationsLocalService.getUnreadNotificationsCount(userId);
	}

	@Override
	public void markAllNotificationsAsRead(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_notificationsLocalService.markAllNotificationsAsRead(userId);
	}

	@Override
	public void markNotificationAsRead(long userNotificationEventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_notificationsLocalService.markNotificationAsRead(
			userNotificationEventId);
	}

	@Override
	public void markNotificationAsUnread(long userNotificationEventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_notificationsLocalService.markNotificationAsUnread(
			userNotificationEventId);
	}

	@Override
	public void markNotificationsAsRead(long[] userNotificationEventIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		_notificationsLocalService.markNotificationsAsRead(
			userNotificationEventIds);
	}

	@Override
	public void markNotificationsAsUnread(long[] userNotificationEventIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		_notificationsLocalService.markNotificationsAsUnread(
			userNotificationEventIds);
	}

	@Override
	public void notifyUser(
			java.util.Locale locale, String notificationType, String mailTo,
			String mobileNo, String[] mailParams, String[] smsParams,
			java.util.List<java.io.File> attachedFiles,
			java.util.List<String> filesName, String[] portalNotificationParams,
			long userId, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_notificationsLocalService.notifyUser(
			locale, notificationType, mailTo, mobileNo, mailParams, smsParams,
			attachedFiles, filesName, portalNotificationParams, userId,
			companyId);
	}

	@Override
	public NotificationsLocalService getWrappedService() {
		return _notificationsLocalService;
	}

	@Override
	public void setWrappedService(
		NotificationsLocalService notificationsLocalService) {

		_notificationsLocalService = notificationsLocalService;
	}

	private NotificationsLocalService _notificationsLocalService;

}