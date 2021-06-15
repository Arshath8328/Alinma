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

import com.ejada.atmc.acl.db.model.ClaimHDR;
import com.ejada.atmc.acl.db.service.persistence.ClaimHDRPersistence;
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
public abstract class ClaimHDRFinderBaseImpl
	extends BasePersistenceImpl<ClaimHDR> {

	public ClaimHDRFinderBaseImpl() {
		setModelClass(ClaimHDR.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("policyNo", "ODS_POLICY_NO");
		dbColumnNames.put("claimNo", "ODS_CLAIM_NO");
		dbColumnNames.put("claimStatus", "ODS_CLAIM_STATUS");
		dbColumnNames.put("iqamaId", "ODS_IQAMA_ID");
		dbColumnNames.put("reportType", "ODS_REPORT_TYPE");
		dbColumnNames.put("reportNo", "ODS_REPORT_NO");
		dbColumnNames.put("enPlateNo", "ODS_ENG_PLATE_NO");
		dbColumnNames.put("enPlateL1", "ODS_ENG_PLATE_L1");
		dbColumnNames.put("enPlateL2", "ODS_ENG_PLATE_L2");
		dbColumnNames.put("enPlateL3", "ODS_ENG_PLATE_L3");
		dbColumnNames.put("arPlateNo", "ODS_ARB_PLATE_NO");
		dbColumnNames.put("arPlateL1", "ODS_ARB_PLATE_L1");
		dbColumnNames.put("arPlateL2", "ODS_ARB_PLATE_L2");
		dbColumnNames.put("arPlateL3", "ODS_ARB_PLATE_L3");
		dbColumnNames.put("natureOfLoss", "ODS_NATUREOF_LOSS");
		dbColumnNames.put("causeCode", "ODS_CAUSE_CODE");
		dbColumnNames.put("typeOfClaim", "ODS_TYPEOF_CLAIM");
		dbColumnNames.put("claimLossDate", "ODS_CLAIM_LOSS_DT");
		dbColumnNames.put("lossRemarks", "ODS_LOSS_REMARKS");
		dbColumnNames.put("faultPercent", "ODS_FAULT_PERCENT");
		dbColumnNames.put("lossLocation", "ODS_LOSS_LOCATION");
		dbColumnNames.put("claimAmount", "ODS_CLAIM_AMOUNT");
		dbColumnNames.put("claimIntmDate", "ODS_CLAIM_INTM_DT");
		dbColumnNames.put("claimSetlDate", "ODS_CLAIM_SETL_DT");
		dbColumnNames.put("claimantName", "ODS_CLAIMANT_NAME");
		dbColumnNames.put("driverName", "ODS_DRIVER_NAME");
		dbColumnNames.put("claimantPhone", "ODS_CLAIMANT_PHONE");
		dbColumnNames.put("iban", "ODS_IBAN");
		dbColumnNames.put("tpDriverName", "ODS_TP_DRIVER_NAME");
		dbColumnNames.put("tpAge", "ODS_TP_AGE");
		dbColumnNames.put("tpID", "ODS_TP_ID");
		dbColumnNames.put("tpPlateNo", "ODS_TP_PLATE_NO");
		dbColumnNames.put("tpPlateL1", "ODS_TP_PLATE_L1");
		dbColumnNames.put("tpPlateL2", "ODS_TP_PLATE_L2");
		dbColumnNames.put("tpPlateL3", "ODS_TP_PLATE_L3");
		dbColumnNames.put("tpInsuranceCo", "ODS_TP_INSURANCE_CO");
		dbColumnNames.put("tpMobileNo", "ODS_TP_MOBILE_NO");
		dbColumnNames.put("tpNationality", "ODS_TP_NATIONALITY");
		dbColumnNames.put("tpIban", "ODS_TP_IBAN");
		dbColumnNames.put("prodCode", "ODS_PROD_CODE");

		setDBColumnNames(dbColumnNames);
	}

	@Override
	public Set<String> getBadColumnNames() {
		return claimHDRPersistence.getBadColumnNames();
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
	protected ClaimHDRPersistence claimHDRPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		ClaimHDRFinderBaseImpl.class);

}