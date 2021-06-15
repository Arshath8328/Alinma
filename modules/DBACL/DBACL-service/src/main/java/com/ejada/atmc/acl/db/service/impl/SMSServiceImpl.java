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

package com.ejada.atmc.acl.db.service.impl;

import com.ejada.atmc.acl.db.service.base.SMSServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import java.sql.SQLException;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the Sms Table remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.db.service.SMSService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    SMSServiceBaseImpl
 */
@Component(
		property = { "json.web.service.context.name=dbacl", "json.web.service.context.path=SMS" },
		service = AopService.class
)
public class SMSServiceImpl extends SMSServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.ejada.atmc.acl.db.service.SMSServiceUtil</code> to access
	 * the Sms Table remote service.
	 */
	public void sendSms(String message, String mobile) throws PortalException, SQLException {

		smsLocalService.sendSms(message, mobile);

	}
}