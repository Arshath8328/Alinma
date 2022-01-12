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

import com.ejada.atmc.acl.db.service.base.SMSLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the Sms Table local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.db.service.SMSLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    SMSLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.ejada.atmc.acl.db.model.SMS",
		service = AopService.class
)
public class SMSLocalServiceImpl extends SMSLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.atmc.bsl.db.service.SMSLocalService</code> via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.atmc.bsl.db.service.SMSLocalServiceUtil</code>.
	 */

	private static final Log		logger				= LogFactoryUtil.getLog(SMSLocalServiceImpl.class);
	private static final boolean	IS_PRODUCTION_ENV	= Boolean.parseBoolean(PropsUtil.get("production.env") != null ? PropsUtil.get("production.env") : "false");
	private static final String		PROC_NAME			= "ATMCSMS";
	private static final String		EVENT_TYPE			= "Evt_Atmc";

	public void sendSms(String message, String mobile) throws PortalException, SQLException {
		if (IS_PRODUCTION_ENV) {
			logger.info("Inside SMSLocalServiceImpl.sendSms for mobile:" + mobile + "...message:" + message);
			Connection connection = null;
			try {

				DataSource src = smsPersistence.getDataSource();
				connection = src.getConnection();

				CallableStatement cs = connection.prepareCall("{Call " + PROC_NAME + "(?,?,?)}");

				cs.setString(1, EVENT_TYPE); // type
				cs.setString(2, message); // message
				cs.setString(3, mobile); // mobile
				// cs.registerOutParameter(4, java.sql.Types.INTEGER); // procedure return

				cs.executeQuery();

				logger.info("Stored Procedure " + PROC_NAME + " called successfully");
				// cs.getObject(4));

			} catch (Exception e) {
				logger.error("Failed to send SMS", e);
				e.printStackTrace();
				throw new PortalException(e);
			} finally {
				if (connection != null)
					connection.close();
			}
		} else {
			logger.info("Not production server!");
		}
	}

}