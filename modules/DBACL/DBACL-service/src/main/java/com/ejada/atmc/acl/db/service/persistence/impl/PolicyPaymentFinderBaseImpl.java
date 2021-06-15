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

import com.ejada.atmc.acl.db.model.PolicyPayment;
import com.ejada.atmc.acl.db.service.persistence.PolicyPaymentPersistence;
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
public abstract class PolicyPaymentFinderBaseImpl
	extends BasePersistenceImpl<PolicyPayment> {

	public PolicyPaymentFinderBaseImpl() {
		setModelClass(PolicyPayment.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("policyNo", "ODS_POLICY_NO");
		dbColumnNames.put("voucherNo", "ODS_VOUCHER_NO");
		dbColumnNames.put("endtNo", "ODS_ENDT_NO");
		dbColumnNames.put("claimNo", "ODS_CLAIM_NO");
		dbColumnNames.put("dueDate", "ODS_DUE_DT");
		dbColumnNames.put("docDate", "ODS_DOC_DT");
		dbColumnNames.put("amount", "ODS_AMOUNT");
		dbColumnNames.put("reference", "ODS_REFERENCE");

		setDBColumnNames(dbColumnNames);
	}

	@Override
	public Set<String> getBadColumnNames() {
		return policyPaymentPersistence.getBadColumnNames();
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
	protected PolicyPaymentPersistence policyPaymentPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		PolicyPaymentFinderBaseImpl.class);

}