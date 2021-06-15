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

package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.model.CustUploads;
import com.ejada.atmc.acl.db.service.persistence.CustUploadsPersistence;
import com.ejada.atmc.acl.db.service.persistence.impl.constants.DBACLPersistenceConstants;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class CustUploadsFinderBaseImpl
	extends BasePersistenceImpl<CustUploads> {

	public CustUploadsFinderBaseImpl() {
		setModelClass(CustUploads.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "ID");
		dbColumnNames.put("quotId", "QUOTATION_ID");
		dbColumnNames.put("idFile", "ID_FILE");
		dbColumnNames.put("licenseFile", "LICENSE_FILE");
		dbColumnNames.put("istCardFile", "IST_CARD_FILE");
		dbColumnNames.put("carFrontFile", "CAR_FRONT_FILE");
		dbColumnNames.put("carBackFile", "CAR_BACK_FILE");
		dbColumnNames.put("carLeftFile", "CAR_LEFT_FILE");
		dbColumnNames.put("carRightFile", "CAR_RIGHT_FILE");
		dbColumnNames.put("engChassisNoFile", "ENG_CHASSIS_NO_FILE");
		dbColumnNames.put("leaseFile", "LEASE_FILE");
		dbColumnNames.put("idFileName", "ID_FILE_NAME");
		dbColumnNames.put("licenseFileName", "LICENSE_FILE_NANE");
		dbColumnNames.put("istCardFileName", "IST_CARD_FILE_NAME");
		dbColumnNames.put("carFrontFileName", "CAR_FRONT_FILE_NAME");
		dbColumnNames.put("carBackFileName", "CAR_BACK_FILE_NAME");
		dbColumnNames.put("carLeftFileName", "CAR_LEFT_FILE_NAME");
		dbColumnNames.put("carRightFileName", "CAR_RIGHT_FILE_NAME");
		dbColumnNames.put("engChassisNoFileName", "ENG_CHASSIS_NO_FILE_NAME");
		dbColumnNames.put("leaseFileName", "LEASE_FILE_NAME");

		setDBColumnNames(dbColumnNames);
	}

	@Override
	public Set<String> getBadColumnNames() {
		return custUploadsPersistence.getBadColumnNames();
	}

	@Override
	@Reference(
		target = DBACLPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DBACLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DBACLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected CustUploadsPersistence custUploadsPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		CustUploadsFinderBaseImpl.class);

}