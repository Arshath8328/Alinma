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

import com.ejada.atmc.acl.db.model.ClaimIntimationMtr;
import com.ejada.atmc.acl.db.service.persistence.ClaimIntimationMtrPersistence;
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
public abstract class ClaimIntimationMtrFinderBaseImpl
	extends BasePersistenceImpl<ClaimIntimationMtr> {

	public ClaimIntimationMtrFinderBaseImpl() {
		setModelClass(ClaimIntimationMtr.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("claimIntimationMotorId", "cim_sys_id");
		dbColumnNames.put("intimationReferenceNo", "intimation_ref");
		dbColumnNames.put("claimantType", "claimant_type");
		dbColumnNames.put("policyNo", "Policy_No");
		dbColumnNames.put("vehiclePlateNo", "Vehicle_Plate_No");
		dbColumnNames.put("sequenceNo", "Sequence_No");
		dbColumnNames.put("chassisNo", "Chassis_No");
		dbColumnNames.put("mobileNo", "Mobile_No");
		dbColumnNames.put("causeOfLoss", "Cause_of_loss");
		dbColumnNames.put("dateOfLoss", "Date_of_Loss");
		dbColumnNames.put("accidentCity", "Accident_City");
		dbColumnNames.put("descOfAccident", "Desc_of_Accident");
		dbColumnNames.put("srcOfAccidentReport", "src_accident_report");
		dbColumnNames.put("accidentReportNo", "Accident_Report_No");
		dbColumnNames.put("vehicleMake", "Vehicle_Make");
		dbColumnNames.put("vehicleModel", "vehicle_model");
		dbColumnNames.put("driverName", "Driver_Name");
		dbColumnNames.put("driverNationality", "Driver_Nationality");
		dbColumnNames.put("driverNationalId", "Driver_National_ID");
		dbColumnNames.put("driverBirthDate", "Driver_Birth_Date");
		dbColumnNames.put("driverGender", "Driver_Gender");
		dbColumnNames.put("attachmentReference", "attachment_reference");
		dbColumnNames.put("claimStatus", "claim_status");
		dbColumnNames.put("ibanNumber", "iban_no");
		dbColumnNames.put("bankName", "bank_name");
		dbColumnNames.put("emailId", "EMAIL_ID");

		setDBColumnNames(dbColumnNames);
	}

	@Override
	public Set<String> getBadColumnNames() {
		return claimIntimationMtrPersistence.getBadColumnNames();
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
	protected ClaimIntimationMtrPersistence claimIntimationMtrPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		ClaimIntimationMtrFinderBaseImpl.class);

}