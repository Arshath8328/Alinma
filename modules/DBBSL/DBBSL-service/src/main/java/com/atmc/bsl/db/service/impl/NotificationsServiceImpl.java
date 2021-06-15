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

package com.atmc.bsl.db.service.impl;

import com.atmc.bsl.db.domain.ReturnCodes;
import com.atmc.bsl.db.domain.ServiceOutput;
import com.atmc.bsl.db.service.base.NotificationsServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the notifications remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.atmc.bsl.db.service.NotificationsService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotificationsServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=dbbsl",
		"json.web.service.context.path=Notifications"
	},
	service = AopService.class
)
public class NotificationsServiceImpl extends NotificationsServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ejada.atmc.bsl.db.service.NotificationsServiceUtil} to access the notifications remote service.
	 */
	private static final Log _log = LogFactoryUtil.getLog(NotificationsServiceImpl.class);
	public ServiceOutput<List<UserNotificationEvent>> getNotifications(long userId)
	{
		ServiceOutput<List<UserNotificationEvent>> svcOutput = new ServiceOutput<List<UserNotificationEvent>>();
		try
		{
			List<UserNotificationEvent> notifications = notificationsLocalService.getAllNotifications(userId, false);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(notifications);
		}
		catch(Exception e)
		{
			_log.error(e);
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;
	}

	public ServiceOutput<Long> getNotificationsCount(long userId)
	{
		ServiceOutput<Long> svcOutput = new ServiceOutput<Long>();
		try
		{
			long notificationsCount = notificationsLocalService.getUnreadNotificationsCount(userId);

			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(notificationsCount);
		}
		catch(Exception e)
		{
			_log.error(e);
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;
	}


	public ServiceOutput<String> markAllNotificationsAsRead(long userId)
	{
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try
		{
			notificationsLocalService.markAllNotificationsAsRead(userId);

			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
		}
		catch(Exception e)
		{
			_log.error(e);
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;
	}



}