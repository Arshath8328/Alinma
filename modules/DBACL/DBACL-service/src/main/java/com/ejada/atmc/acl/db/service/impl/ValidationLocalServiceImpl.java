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

import com.ejada.atmc.acl.db.service.base.ValidationLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the validation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.db.service.ValidationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    ValidationLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.ejada.atmc.acl.db.model.Validation",
		service = AopService.class
)
public class ValidationLocalServiceImpl extends ValidationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ejada.atmc.acl.db.service.ValidationLocalServiceUtil} to
	 * access the validation local service.
	 */

	private static final String PROC_NAME = "EJD_PR_IBAN_VALIDATION";

	public int IbanValidation(String countryCode, String bankCode, String accNo) throws PortalException, SQLException {
		Connection connection = null;
		try {

			DataSource src = smsPersistence.getDataSource();
			connection = src.getConnection();

			CallableStatement cs = connection.prepareCall("{Call " + PROC_NAME + "(?,?,?,?)}");

			cs.setString(1, countryCode); // countryCode
			cs.setString(2, bankCode); // bankCode
			cs.setString(3, accNo); // accNo
			cs.registerOutParameter(4, java.sql.Types.INTEGER);

			cs.executeQuery();
			int flag = (int) cs.getObject(4);

			// logger.debug("Stored Procedure " + PROC_NAME + " called successfully");
			return flag;

		} catch (Exception e) {
			e.printStackTrace();
			throw new PortalException(e);
		} finally {
			if (connection != null)
				connection.close();
		}
	}
}