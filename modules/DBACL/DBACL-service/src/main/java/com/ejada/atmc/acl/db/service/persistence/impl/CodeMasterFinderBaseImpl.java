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

import com.ejada.atmc.acl.db.model.CodeMaster;
import com.ejada.atmc.acl.db.service.persistence.CodeMasterPersistence;
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
public abstract class CodeMasterFinderBaseImpl
	extends BasePersistenceImpl<CodeMaster> {

	public CodeMasterFinderBaseImpl() {
		setModelClass(CodeMaster.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("systemId", "MDM_CODE_SYS_ID");
		dbColumnNames.put("effFromDate", "MDM_CODE_EFF_FM_DT");
		dbColumnNames.put("effToDate", "MDM_CODE_EFF_TO_DT");
		dbColumnNames.put("creationDate", "MDM_CODE_CR_DT");
		dbColumnNames.put("crUid", "MDM_CODE_CR_UID");
		dbColumnNames.put("updateDate", "MDM_CODE_UPD_DT");
		dbColumnNames.put("updateUid", "MDM_CODE_UPD_UID");
		dbColumnNames.put("code", "MDM_CODE");
		dbColumnNames.put("codeSub", "MDM_CODE_SUB");
		dbColumnNames.put("codeDesc", "MDM_CODE_DESC");
		dbColumnNames.put("codeDescAr", "MDM_CODE_DESC_AR");
		dbColumnNames.put("codeValue0", "MDM_CODE_VALUE_0");
		dbColumnNames.put("codeValue1", "MDM_CODE_VALUE_1");
		dbColumnNames.put("codeValue2", "MDM_CODE_VALUE_2");
		dbColumnNames.put("codeRef", "MDM_CODE_REF");
		dbColumnNames.put("codeSubRef", "MDM_CODE_SUB_REF");
		dbColumnNames.put("codeFreezYN", "MDM_CODE_FREEZ_YN");

		setDBColumnNames(dbColumnNames);
	}

	@Override
	public Set<String> getBadColumnNames() {
		return codeMasterPersistence.getBadColumnNames();
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
	protected CodeMasterPersistence codeMasterPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		CodeMasterFinderBaseImpl.class);

}