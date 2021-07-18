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

package com.ejada.email.service.impl;

import com.ejada.email.resources.MySmtpSender;
import com.ejada.email.service.base.myEntityServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the my entity remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.email.service.myEntityService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    myEntityServiceBaseImpl
 */
@Component(
		property =
		{ "json.web.service.context.name=ejadaemail", "json.web.service.context.path=myEntity" },
		service = AopService.class
)
public class myEntityServiceImpl extends myEntityServiceBaseImpl {

	public void printStmnt() {
		System.out.println("in email service printStatment function !!!!!!!!!!");

		MySmtpSender sender = new MySmtpSender();

		String mailTo = "other_email@gmail.com";
		String mailSubject = "subject";
		String mailText = "welcome";

		sender.sendMail(mailTo, mailSubject, mailText);
	}
}