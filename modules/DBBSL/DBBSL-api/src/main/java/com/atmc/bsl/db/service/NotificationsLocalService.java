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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.io.File;

import java.util.*;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Notifications. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see NotificationsLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface NotificationsLocalService extends BaseLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.NotificationsLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the notifications local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link NotificationsLocalServiceUtil} if injection and service tracking are not available.
	 */
	public void addNotification(
		long userId, String msgKey, String[] params, String notificationType,
		long companyId);

	public void deleteAllNotifications(long[] userNotificationEventIds)
		throws PortalException;

	public void deleteUserNotificationEvent(long userNotificationEventId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<UserNotificationEvent> getAllNotifications(
			long userId, boolean actionRequired)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getAllNotificationsCount(long userId, boolean actionRequired)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<UserNotificationEvent> getNotifications(
			long userId, boolean actionRequired, String mode, int start,
			int end)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getUnreadNotificationsCount(long userId) throws PortalException;

	public void markAllNotificationsAsRead(long userId) throws PortalException;

	public void markNotificationAsRead(long userNotificationEventId)
		throws PortalException;

	public void markNotificationAsUnread(long userNotificationEventId)
		throws PortalException;

	public void markNotificationsAsRead(long[] userNotificationEventIds)
		throws PortalException;

	public void markNotificationsAsUnread(long[] userNotificationEventIds)
		throws PortalException;

	public void notifyUser(
			java.util.Locale locale, String notificationType, String mailTo,
			String mobileNo, String[] mailParams, String[] smsParams,
			java.util.List<File> attachedFiles,
			java.util.List<String> filesName, String[] portalNotificationParams,
			long userId, long companyId)
		throws PortalException;

}