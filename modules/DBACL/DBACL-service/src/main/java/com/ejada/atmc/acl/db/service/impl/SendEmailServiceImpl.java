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

import com.ejada.atmc.acl.db.service.base.SendEmailServiceBaseImpl;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.File;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the send email remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.db.service.SendEmailService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    SendEmailServiceBaseImpl
 */
@Component(
		property =
		{ "json.web.service.context.name=dbacl", "json.web.service.context.path=SendEmail" },
		service = AopService.class
)
public class SendEmailServiceImpl extends SendEmailServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ejada.atmc.acl.db.service.SendEmailServiceUtil} to access
	 * the send email remote service.
	 */
	private static final boolean IS_PRODUCTION_ENV = Boolean.parseBoolean(PropsUtil.get("production.env") != null ? PropsUtil.get("production.env") : "false");

	public boolean sendEmail(String mailTo, String mailSubject, String mailMessage, List<String> fileName, List<File> attachedFile) {
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;

		_log.info("Inside SendEmailServiceImpl.sendEmail");
		if (IS_PRODUCTION_ENV) {
			try {
				_log.info("fromAddress:" + PropsUtil.get("mailFrom"));

				fromAddress = new InternetAddress(PropsUtil.get("mailFrom"));
				toAddress = new InternetAddress(mailTo);
				MailMessage mailMsg = new MailMessage();
				mailMsg.setFrom(fromAddress);
				mailMsg.setTo(toAddress);
				mailMsg.setSubject(mailSubject);
				mailMsg.setBody(mailMessage);
				if (attachedFile != null && fileName != null && !attachedFile.isEmpty() && !fileName.isEmpty()) {
					for (int i = 0; i < attachedFile.size(); i++) {
						mailMsg.addFileAttachment(attachedFile.get(i), fileName.get(i));
						_log.info(fileName.get(i) + " attached to Email");
					}
				}
				_log.info("Sending email...");
				MailServiceUtil.sendEmail(mailMsg);
				_log.info("Email sent Successfully");
			} catch (AddressException e) {
				_log.error("Failed to send Email", e);
				return false;
			} catch (Exception e) {
				_log.error("Failed to send Email", e);
				return false;
			}
		} else
			_log.info("Not production server!");
		return true;
	}

	private static final Log _log = LogFactoryUtil.getLog(SendEmailServiceImpl.class);
}