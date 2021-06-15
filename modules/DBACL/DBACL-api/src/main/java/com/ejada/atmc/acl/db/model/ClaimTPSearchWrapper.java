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

package com.ejada.atmc.acl.db.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ClaimTPSearch}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimTPSearch
 * @generated
 */
public class ClaimTPSearchWrapper
	extends BaseModelWrapper<ClaimTPSearch>
	implements ClaimTPSearch, ModelWrapper<ClaimTPSearch> {

	public ClaimTPSearchWrapper(ClaimTPSearch claimTPSearch) {
		super(claimTPSearch);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("reportNo", getReportNo());
		attributes.put("tpId", getTpId());
		attributes.put("tpDriverName", getTpDriverName());
		attributes.put("tpAge", getTpAge());
		attributes.put("vehicleSEQCustom", getVehicleSEQCustom());
		attributes.put("tpMobileNo", getTpMobileNo());
		attributes.put("tpNationality", getTpNationality());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String reportNo = (String)attributes.get("reportNo");

		if (reportNo != null) {
			setReportNo(reportNo);
		}

		String tpId = (String)attributes.get("tpId");

		if (tpId != null) {
			setTpId(tpId);
		}

		String tpDriverName = (String)attributes.get("tpDriverName");

		if (tpDriverName != null) {
			setTpDriverName(tpDriverName);
		}

		String tpAge = (String)attributes.get("tpAge");

		if (tpAge != null) {
			setTpAge(tpAge);
		}

		String vehicleSEQCustom = (String)attributes.get("vehicleSEQCustom");

		if (vehicleSEQCustom != null) {
			setVehicleSEQCustom(vehicleSEQCustom);
		}

		String tpMobileNo = (String)attributes.get("tpMobileNo");

		if (tpMobileNo != null) {
			setTpMobileNo(tpMobileNo);
		}

		String tpNationality = (String)attributes.get("tpNationality");

		if (tpNationality != null) {
			setTpNationality(tpNationality);
		}
	}

	/**
	 * Returns the primary key of this claim tp search.
	 *
	 * @return the primary key of this claim tp search
	 */
	@Override
	public com.ejada.atmc.acl.db.service.persistence.ClaimTPSearchPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the report no of this claim tp search.
	 *
	 * @return the report no of this claim tp search
	 */
	@Override
	public String getReportNo() {
		return model.getReportNo();
	}

	/**
	 * Returns the tp age of this claim tp search.
	 *
	 * @return the tp age of this claim tp search
	 */
	@Override
	public String getTpAge() {
		return model.getTpAge();
	}

	/**
	 * Returns the tp driver name of this claim tp search.
	 *
	 * @return the tp driver name of this claim tp search
	 */
	@Override
	public String getTpDriverName() {
		return model.getTpDriverName();
	}

	/**
	 * Returns the tp ID of this claim tp search.
	 *
	 * @return the tp ID of this claim tp search
	 */
	@Override
	public String getTpId() {
		return model.getTpId();
	}

	/**
	 * Returns the tp mobile no of this claim tp search.
	 *
	 * @return the tp mobile no of this claim tp search
	 */
	@Override
	public String getTpMobileNo() {
		return model.getTpMobileNo();
	}

	/**
	 * Returns the tp nationality of this claim tp search.
	 *
	 * @return the tp nationality of this claim tp search
	 */
	@Override
	public String getTpNationality() {
		return model.getTpNationality();
	}

	/**
	 * Returns the vehicle seq custom of this claim tp search.
	 *
	 * @return the vehicle seq custom of this claim tp search
	 */
	@Override
	public String getVehicleSEQCustom() {
		return model.getVehicleSEQCustom();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this claim tp search.
	 *
	 * @param primaryKey the primary key of this claim tp search
	 */
	@Override
	public void setPrimaryKey(
		com.ejada.atmc.acl.db.service.persistence.ClaimTPSearchPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the report no of this claim tp search.
	 *
	 * @param reportNo the report no of this claim tp search
	 */
	@Override
	public void setReportNo(String reportNo) {
		model.setReportNo(reportNo);
	}

	/**
	 * Sets the tp age of this claim tp search.
	 *
	 * @param tpAge the tp age of this claim tp search
	 */
	@Override
	public void setTpAge(String tpAge) {
		model.setTpAge(tpAge);
	}

	/**
	 * Sets the tp driver name of this claim tp search.
	 *
	 * @param tpDriverName the tp driver name of this claim tp search
	 */
	@Override
	public void setTpDriverName(String tpDriverName) {
		model.setTpDriverName(tpDriverName);
	}

	/**
	 * Sets the tp ID of this claim tp search.
	 *
	 * @param tpId the tp ID of this claim tp search
	 */
	@Override
	public void setTpId(String tpId) {
		model.setTpId(tpId);
	}

	/**
	 * Sets the tp mobile no of this claim tp search.
	 *
	 * @param tpMobileNo the tp mobile no of this claim tp search
	 */
	@Override
	public void setTpMobileNo(String tpMobileNo) {
		model.setTpMobileNo(tpMobileNo);
	}

	/**
	 * Sets the tp nationality of this claim tp search.
	 *
	 * @param tpNationality the tp nationality of this claim tp search
	 */
	@Override
	public void setTpNationality(String tpNationality) {
		model.setTpNationality(tpNationality);
	}

	/**
	 * Sets the vehicle seq custom of this claim tp search.
	 *
	 * @param vehicleSEQCustom the vehicle seq custom of this claim tp search
	 */
	@Override
	public void setVehicleSEQCustom(String vehicleSEQCustom) {
		model.setVehicleSEQCustom(vehicleSEQCustom);
	}

	@Override
	protected ClaimTPSearchWrapper wrap(ClaimTPSearch claimTPSearch) {
		return new ClaimTPSearchWrapper(claimTPSearch);
	}

}