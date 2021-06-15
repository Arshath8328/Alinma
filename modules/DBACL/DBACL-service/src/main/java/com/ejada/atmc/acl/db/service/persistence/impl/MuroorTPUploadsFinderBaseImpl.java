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

import com.ejada.atmc.acl.db.model.MuroorTPUploads;
import com.ejada.atmc.acl.db.service.persistence.MuroorTPUploadsPersistence;
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
public abstract class MuroorTPUploadsFinderBaseImpl
	extends BasePersistenceImpl<MuroorTPUploads> {

	public MuroorTPUploadsFinderBaseImpl() {
		setModelClass(MuroorTPUploads.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "FILE_ID");
		dbColumnNames.put("claimIntimationNo", "CLM_INTM_NO");
		dbColumnNames.put("iqamaId", "IQAMA_ID");
		dbColumnNames.put("driverLicense", "DRIVER_LICENSE");
		dbColumnNames.put("driverLicenseName", "DRIVER_LICENSE_NAME");
		dbColumnNames.put("vehRegist", "VEH_REGISTRATION");
		dbColumnNames.put("vehRegistName", "VEH_REGISTRATION_NAME");
		dbColumnNames.put("frontPhoto", "FRONT_PHOTO");
		dbColumnNames.put("frontPhotoName", "FRONT_PHOTO_NAME");
		dbColumnNames.put("rearPhoto", "RARE_PHOTO");
		dbColumnNames.put("rearPhotoName", "RARE_PHOTO_NAME");
		dbColumnNames.put("rightSidePhoto", "RIGHT_SIDE_PHOTO");
		dbColumnNames.put("rightSidePhotoName", "RIGHT_SIDE_PHOTO_NAME");
		dbColumnNames.put("leftSidePhoto", "LEFT_SIDE_PHOTO");
		dbColumnNames.put("leftSidePhotoName", "LEFT_SIDE_PHOTO_NAME");
		dbColumnNames.put("bankIban", "BANK_IBAN_COPY");
		dbColumnNames.put("bankIbanName", "BANK_IBAN_COPY_NAME");
		dbColumnNames.put("ownerId", "OWNER_ID");
		dbColumnNames.put("ownerIdName", "OWNER_ID_NAME");

		setDBColumnNames(dbColumnNames);
	}

	@Override
	public Set<String> getBadColumnNames() {
		return muroorTPUploadsPersistence.getBadColumnNames();
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
	protected MuroorTPUploadsPersistence muroorTPUploadsPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		MuroorTPUploadsFinderBaseImpl.class);

}