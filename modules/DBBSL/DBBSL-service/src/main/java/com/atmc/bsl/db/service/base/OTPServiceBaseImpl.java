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

package com.atmc.bsl.db.service.base;

import com.atmc.bsl.db.service.OTPService;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the otp remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service
 * methods generated by ServiceBuilder. All custom service methods should be put
 * in {@link com.atmc.bsl.db.service.impl.OTPServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.atmc.bsl.db.service.impl.OTPServiceImpl
 * @generated
 */
public abstract class OTPServiceBaseImpl extends BaseServiceImpl
		implements AopService, IdentifiableOSGiService, OTPService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>OTPService</code>
	 * via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.atmc.bsl.db.service.OTPServiceUtil</code>.
	 */
	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] { OTPService.class, IdentifiableOSGiService.class };
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		otpService = (OTPService) aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return OTPService.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = InfrastructureUtil.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource, sql);

			sqlUpdate.update();
		} catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected com.atmc.bsl.db.service.OTPLocalService otpLocalService;

	protected OTPService otpService;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

}