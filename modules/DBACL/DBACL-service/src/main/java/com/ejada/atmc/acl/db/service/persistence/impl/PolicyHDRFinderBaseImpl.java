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

import com.ejada.atmc.acl.db.model.PolicyHDR;
import com.ejada.atmc.acl.db.service.persistence.PolicyHDRPersistence;
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
public abstract class PolicyHDRFinderBaseImpl
	extends BasePersistenceImpl<PolicyHDR> {

	public PolicyHDRFinderBaseImpl() {
		setModelClass(PolicyHDR.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("policyNo", "ODS_POLICY_NO");
		dbColumnNames.put("iqamaId", "ODS_IQAMA_ID");
		dbColumnNames.put("policyStatus", "ODS_POLICY_STATUS");
		dbColumnNames.put("product", "ODS_PRODUCT");
		dbColumnNames.put("inceptionDate", "ODS_INCEPTION_DT");
		dbColumnNames.put("expiryDate", "ODS_EXPIRY_DT");
		dbColumnNames.put("sumInsured", "ODS_SUM_INSURED");
		dbColumnNames.put("totalPremium", "ODS_TOTAL_PREMIUM");
		dbColumnNames.put("policyFees", "ODS_POLICY_FEES");
		dbColumnNames.put("policyTaxes", "ODS_POLICY_TAXES");
		dbColumnNames.put("policyTerm", "ODS_POLICY_TERM");
		dbColumnNames.put("premium", "ODS_OS_PREMIUM");
		dbColumnNames.put("nextDueDate", "ODS_NEXT_DUE_DT");
		dbColumnNames.put("countPremMissed", "ODS_COUNT_PREM_MISSED");
		dbColumnNames.put("modeOfPayment", "ODS_MODEOF_PAYMENT");
		dbColumnNames.put("nextRenwalDate", "ODS_NEXT_RENEWAL_DT");
		dbColumnNames.put("custName", "ODS_CUST_NAME");
		dbColumnNames.put("custBirthDate", "ODS_CUST_DOB");
		dbColumnNames.put("insuredName", "ODS_INSURED_NAME");
		dbColumnNames.put("insuredBirthDate", "ODS_INSURED_DOB");
		dbColumnNames.put("insuredId", "ODS_INSURED_ID");
		dbColumnNames.put("insuredMobile", "ODS_INSURED_MOBILE");
		dbColumnNames.put("insuredEmail", "ODS_INSURED_EMAIL");
		dbColumnNames.put("insuredAddr", "ODS_INSURED_ADDR");
		dbColumnNames.put("insuredGender", "ODS_INSURED_GENDER");
		dbColumnNames.put("occuptation", "ODS_OCCUPTATION");
		dbColumnNames.put("estExpiryDate", "ODS_EST_EXPIRY_DT");
		dbColumnNames.put("najmStatus", "ODS_NAJM_STATUS");
		dbColumnNames.put("surrenderValue", "ODS_SURRENDER_VALUE");
		dbColumnNames.put("noOfRisk", "ODS_NOOF_RISK");
		dbColumnNames.put("memberScheme", "ODS_MEMBER_SCHEME");
		dbColumnNames.put("memberBenefits", "ODS_MEMBER_BENEFITS");

		setDBColumnNames(dbColumnNames);
	}

	@Override
	public Set<String> getBadColumnNames() {
		return policyHDRPersistence.getBadColumnNames();
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
	protected PolicyHDRPersistence policyHDRPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		PolicyHDRFinderBaseImpl.class);

}