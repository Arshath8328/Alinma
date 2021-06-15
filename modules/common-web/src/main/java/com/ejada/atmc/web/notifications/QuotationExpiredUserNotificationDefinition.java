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

package com.ejada.atmc.web.notifications;

import com.ejada.atmc.web.constants.NotificationsPortletKeys;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.notifications.UserNotificationDefinition;
import com.liferay.portal.kernel.notifications.UserNotificationDeliveryType;

import org.osgi.service.component.annotations.Component;

/**
 * @author Basel Aziz
 */
@Component(
	immediate = true,
	property = {"javax.portlet.name=" + NotificationsPortletKeys.NOTIFICATIONS},
	service = UserNotificationDefinition.class
)
public class QuotationExpiredUserNotificationDefinition
	extends UserNotificationDefinition {

	public QuotationExpiredUserNotificationDefinition() {
		super(
				NotificationsPortletKeys.NOTIFICATIONS, 0,
				NotificationsPortletKeys.NOTIFICATION_TYPE_QUOT_EXPIRED,
			"receive-a-notification-when-quot-expired");
		
		addUserNotificationDeliveryType(
			new UserNotificationDeliveryType(
				"website", UserNotificationDeliveryConstants.TYPE_WEBSITE, true,
				true));
	}

}