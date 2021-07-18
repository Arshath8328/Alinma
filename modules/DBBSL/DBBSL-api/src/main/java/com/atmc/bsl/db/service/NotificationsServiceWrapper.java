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
 * Provides a wrapper for {@link NotificationsService}.
 *
 * @author Brian Wing Shun Chan
 * @see NotificationsService
 * @generated
 */
public class NotificationsServiceWrapper
	implements NotificationsService, ServiceWrapper<NotificationsService> {

	public NotificationsServiceWrapper(
		NotificationsService notificationsService) {

		_notificationsService = notificationsService;
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.liferay.portal.kernel.model.UserNotificationEvent>>
			getNotifications(long userId) {

		return _notificationsService.getNotifications(userId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<Long> getNotificationsCount(
		long userId) {

		return _notificationsService.getNotificationsCount(userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _notificationsService.getOSGiServiceIdentifier();
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String>
		markAllNotificationsAsRead(long userId) {

		return _notificationsService.markAllNotificationsAsRead(userId);
	}

	@Override
	public NotificationsService getWrappedService() {
		return _notificationsService;
	}

	@Override
	public void setWrappedService(NotificationsService notificationsService) {
		_notificationsService = notificationsService;
	}

	private NotificationsService _notificationsService;

}