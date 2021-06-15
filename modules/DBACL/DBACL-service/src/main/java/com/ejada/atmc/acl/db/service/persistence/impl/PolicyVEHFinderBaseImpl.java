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

import com.ejada.atmc.acl.db.model.PolicyVEH;
import com.ejada.atmc.acl.db.service.persistence.PolicyVEHPersistence;
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
public abstract class PolicyVEHFinderBaseImpl
	extends BasePersistenceImpl<PolicyVEH> {

	public PolicyVEHFinderBaseImpl() {
		setModelClass(PolicyVEH.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("policyNo", "ODS_POLICY_NO");
		dbColumnNames.put("vehId", "ODS_VEH_ID");
		dbColumnNames.put("vehicleDefType", "ODS_VEHICLE_DEF_TYPE");
		dbColumnNames.put("vehicleSeqCustom", "ODS_VEHICLE_SEQ_CUSTOM");
		dbColumnNames.put("chassisNo", "ODS_CHASSIS_NO");
		dbColumnNames.put("bodyType", "ODS_BODY_TYPE");
		dbColumnNames.put("make", "ODS_MAKE");
		dbColumnNames.put("vehModel", "ODS_MODEL");
		dbColumnNames.put("mfgYear", "ODS_MFG_YEAR");
		dbColumnNames.put("color", "ODS_COLOR");
		dbColumnNames.put("agencyRepair", "ODS_AGENCY_REPAIR");
		dbColumnNames.put("noofPassengers", "ODS_NOOF_PASSENGERS");
		dbColumnNames.put("enPlateNo", "ODS_ENG_PLATE_NO");
		dbColumnNames.put("enPlateL1", "ODS_ENG_PLATE_L1");
		dbColumnNames.put("enPlateL2", "ODS_ENG_PLATE_L2");
		dbColumnNames.put("enPlateL3", "ODS_ENG_PLATE_L3");
		dbColumnNames.put("arPlateNo", "ODS_ARB_PLATE_NO");
		dbColumnNames.put("arPlateL1", "ODS_ARB_PLATE_L1");
		dbColumnNames.put("arPlateL2", "ODS_ARB_PLATE_L2");
		dbColumnNames.put("arPlateL3", "ODS_ARB_PLATE_L3");
		dbColumnNames.put("deductible", "ODS_DEDUCTIBLE");
		dbColumnNames.put("vehicleValue", "ODS_VEHICLE_VALUE");
		dbColumnNames.put("premium", "ODS_PREMIUM");
		dbColumnNames.put("discounts", "ODS_DISCOUNTS");
		dbColumnNames.put("loading", "ODS_LOADING");
		dbColumnNames.put("totalPremium", "ODS_TOTAL_PREMIUM");
		dbColumnNames.put("noofClaimFreeYears", "ODS_NOOF_CLAIM_FREE_YEARS");
		dbColumnNames.put("useOfCehicle", "ODS_USEOF_VEHICLE");
		dbColumnNames.put("najmPlateType", "ODS_NAJM_PLATE_TYPE");
		dbColumnNames.put("najmStatus", "ODS_NAJM_STATUS");
		dbColumnNames.put("estemaraExpiryDate", "ODS_ESTEMARA_EXP_DT");
		dbColumnNames.put("geoLocation", "ODS_GEOLOCATION");

		setDBColumnNames(dbColumnNames);
	}

	@Override
	public Set<String> getBadColumnNames() {
		return policyVEHPersistence.getBadColumnNames();
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
	protected PolicyVEHPersistence policyVEHPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		PolicyVEHFinderBaseImpl.class);

}