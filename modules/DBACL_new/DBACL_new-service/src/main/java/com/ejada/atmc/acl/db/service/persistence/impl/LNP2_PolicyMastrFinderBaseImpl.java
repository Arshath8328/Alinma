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

import com.ejada.atmc.acl.db.model.LNP2_PolicyMastr;
import com.ejada.atmc.acl.db.service.persistence.LNP2_PolicyMastrPersistence;
import com.ejada.atmc.acl.db.service.persistence.impl.constants.DBACL_NEWPersistenceConstants;

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
public abstract class LNP2_PolicyMastrFinderBaseImpl
	extends BasePersistenceImpl<LNP2_PolicyMastr> {

	public LNP2_PolicyMastrFinderBaseImpl() {
		setModelClass(LNP2_PolicyMastr.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("np1_proposal", "NP1_PROPOSAL");
		dbColumnNames.put("np2_setno", "NP2_SETNO");
		dbColumnNames.put("cfr_forfeitucd", "CFR_FORFEITUCD");
		dbColumnNames.put("cmo_mode", "CMO_MODE");
		dbColumnNames.put("pcu_currcode", "PCU_CURRCODE");
		dbColumnNames.put("aag_agcode", "AAG_AGCODE");
		dbColumnNames.put("ccl_categorycd", "CCL_CATEGORYCD");
		dbColumnNames.put("use_userid", "USE_USERID");
		dbColumnNames.put("use_datetime", "USE_DATETIME");
		dbColumnNames.put("np2_grosprm", "NP2_GROSPRM");
		dbColumnNames.put("np2_ageprem", "NP2_AGEPREM");
		dbColumnNames.put("np2_commendate", "NP2_COMMENDATE");
		dbColumnNames.put("np2_sumatrisk", "NP2_SUMATRISK");
		dbColumnNames.put("np2_substandar", "NP2_SUBSTANDAR");
		dbColumnNames.put("np2_effectdate", "NP2_EFFECTDATE");
		dbColumnNames.put("np2_expirydate", "NP2_EXPIRYDATE");
		dbColumnNames.put("np2_endofprmdt", "NP2_ENDOFPRMDT");
		dbColumnNames.put("np2_paidupamt", "NP2_PAIDUPAMT");
		dbColumnNames.put("np2_diffinprem", "NP2_DIFFINPREM");
		dbColumnNames.put("np2_diffinfyco", "NP2_DIFFINFYCO");
		dbColumnNames.put("np2_charges", "NP2_CHARGES");
		dbColumnNames.put("np2_totload", "NP2_TOTLOAD");
		dbColumnNames.put("np2_nextduedat", "NP2_NEXTDUEDAT");
		dbColumnNames.put("np2_ageadmitt", "NP2_AGEADMITT");
		dbColumnNames.put("np2_optimaindex", "NP2_OPTIMAINDEX");
		dbColumnNames.put("np2_ageprem2nd", "NP2_AGEPREM2ND");
		dbColumnNames.put("np2_policyfees", "NP2_POLICYFEES");
		dbColumnNames.put("np2_sar", "NP2_SAR");
		dbColumnNames.put("np2_totpremium", "NP2_TOTPREMIUM");
		dbColumnNames.put("np2_approved", "NP2_APPROVED");
		dbColumnNames.put("np2_endorsementno", "NP2_ENDORSEMENTNO");
		dbColumnNames.put("pfs_acntyear", "PFS_ACNTYEAR");
		dbColumnNames.put("arq_requestype", "ARQ_REQUESTYPE");
		dbColumnNames.put("arq_requestno", "ARQ_REQUESTNO");
		dbColumnNames.put("np2_forfeitdat", "NP2_FORFEITDAT");
		dbColumnNames.put("convert", "CONVERT");
		dbColumnNames.put("np2_notionalage", "NP2_NOTIONALAGE");
		dbColumnNames.put("cop_occupaticd", "COP_OCCUPATICD");
		dbColumnNames.put("np2_dob", "NP2_DOB");
		dbColumnNames.put("np2_accr_proc", "NP2_ACCR_PROC");
		dbColumnNames.put("np2_effectiveage", "NP2_EFFECTIVEAGE");
		dbColumnNames.put("np2_nom2ndlife", "NP2_NOM2NDLIFE");
		dbColumnNames.put("np2_dob_2nd", "NP2_DOB_2ND");
		dbColumnNames.put("np2_lastrevbonus", "NP2_LASTREVBONUS");
		dbColumnNames.put("np2_reversionary", "NP2_REVERSIONARY");
		dbColumnNames.put("np2_rider_bonus", "NP2_RIDER_BONUS");
		dbColumnNames.put("np2_last_rider_bonus", "NP2_LAST_RIDER_BONUS");
		dbColumnNames.put("np2_ageprem_actual", "NP2_AGEPREM_ACTUAL");
		dbColumnNames.put("np2_ageprem2nd_actual", "NP2_AGEPREM2ND_ACTUAL");

		setDBColumnNames(dbColumnNames);
	}

	@Override
	public Set<String> getBadColumnNames() {
		return lnp2_PolicyMastrPersistence.getBadColumnNames();
	}

	@Override
	@Reference(
		target = DBACL_NEWPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DBACL_NEWPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DBACL_NEWPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected LNP2_PolicyMastrPersistence lnp2_PolicyMastrPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		LNP2_PolicyMastrFinderBaseImpl.class);

}