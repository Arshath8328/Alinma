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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ClaimODSearch}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimODSearch
 * @generated
 */
public class ClaimODSearchWrapper
	extends BaseModelWrapper<ClaimODSearch>
	implements ClaimODSearch, ModelWrapper<ClaimODSearch> {

	public ClaimODSearchWrapper(ClaimODSearch claimODSearch) {
		super(claimODSearch);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("policyNo", getPolicyNo());
		attributes.put("reportNo", getReportNo());
		attributes.put("vehicleSEQCustom", getVehicleSEQCustom());
		attributes.put("vehicleDevType", getVehicleDevType());
		attributes.put("natureofLoss", getNatureofLoss());
		attributes.put("causeCode", getCauseCode());
		attributes.put("typeOfClaim", getTypeOfClaim());
		attributes.put("claimLossDate", getClaimLossDate());
		attributes.put("lossRemarks", getLossRemarks());
		attributes.put("faultPercent", getFaultPercent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String policyNo = (String)attributes.get("policyNo");

		if (policyNo != null) {
			setPolicyNo(policyNo);
		}

		String reportNo = (String)attributes.get("reportNo");

		if (reportNo != null) {
			setReportNo(reportNo);
		}

		String vehicleSEQCustom = (String)attributes.get("vehicleSEQCustom");

		if (vehicleSEQCustom != null) {
			setVehicleSEQCustom(vehicleSEQCustom);
		}

		String vehicleDevType = (String)attributes.get("vehicleDevType");

		if (vehicleDevType != null) {
			setVehicleDevType(vehicleDevType);
		}

		String natureofLoss = (String)attributes.get("natureofLoss");

		if (natureofLoss != null) {
			setNatureofLoss(natureofLoss);
		}

		String causeCode = (String)attributes.get("causeCode");

		if (causeCode != null) {
			setCauseCode(causeCode);
		}

		String typeOfClaim = (String)attributes.get("typeOfClaim");

		if (typeOfClaim != null) {
			setTypeOfClaim(typeOfClaim);
		}

		Date claimLossDate = (Date)attributes.get("claimLossDate");

		if (claimLossDate != null) {
			setClaimLossDate(claimLossDate);
		}

		String lossRemarks = (String)attributes.get("lossRemarks");

		if (lossRemarks != null) {
			setLossRemarks(lossRemarks);
		}

		String faultPercent = (String)attributes.get("faultPercent");

		if (faultPercent != null) {
			setFaultPercent(faultPercent);
		}
	}

	/**
	 * Returns the cause code of this claim od search.
	 *
	 * @return the cause code of this claim od search
	 */
	@Override
	public String getCauseCode() {
		return model.getCauseCode();
	}

	/**
	 * Returns the claim loss date of this claim od search.
	 *
	 * @return the claim loss date of this claim od search
	 */
	@Override
	public Date getClaimLossDate() {
		return model.getClaimLossDate();
	}

	/**
	 * Returns the fault percent of this claim od search.
	 *
	 * @return the fault percent of this claim od search
	 */
	@Override
	public String getFaultPercent() {
		return model.getFaultPercent();
	}

	/**
	 * Returns the loss remarks of this claim od search.
	 *
	 * @return the loss remarks of this claim od search
	 */
	@Override
	public String getLossRemarks() {
		return model.getLossRemarks();
	}

	/**
	 * Returns the natureof loss of this claim od search.
	 *
	 * @return the natureof loss of this claim od search
	 */
	@Override
	public String getNatureofLoss() {
		return model.getNatureofLoss();
	}

	/**
	 * Returns the policy no of this claim od search.
	 *
	 * @return the policy no of this claim od search
	 */
	@Override
	public String getPolicyNo() {
		return model.getPolicyNo();
	}

	/**
	 * Returns the primary key of this claim od search.
	 *
	 * @return the primary key of this claim od search
	 */
	@Override
	public com.ejada.atmc.acl.db.service.persistence.ClaimODSearchPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the report no of this claim od search.
	 *
	 * @return the report no of this claim od search
	 */
	@Override
	public String getReportNo() {
		return model.getReportNo();
	}

	/**
	 * Returns the type of claim of this claim od search.
	 *
	 * @return the type of claim of this claim od search
	 */
	@Override
	public String getTypeOfClaim() {
		return model.getTypeOfClaim();
	}

	/**
	 * Returns the vehicle dev type of this claim od search.
	 *
	 * @return the vehicle dev type of this claim od search
	 */
	@Override
	public String getVehicleDevType() {
		return model.getVehicleDevType();
	}

	/**
	 * Returns the vehicle seq custom of this claim od search.
	 *
	 * @return the vehicle seq custom of this claim od search
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
	 * Sets the cause code of this claim od search.
	 *
	 * @param causeCode the cause code of this claim od search
	 */
	@Override
	public void setCauseCode(String causeCode) {
		model.setCauseCode(causeCode);
	}

	/**
	 * Sets the claim loss date of this claim od search.
	 *
	 * @param claimLossDate the claim loss date of this claim od search
	 */
	@Override
	public void setClaimLossDate(Date claimLossDate) {
		model.setClaimLossDate(claimLossDate);
	}

	/**
	 * Sets the fault percent of this claim od search.
	 *
	 * @param faultPercent the fault percent of this claim od search
	 */
	@Override
	public void setFaultPercent(String faultPercent) {
		model.setFaultPercent(faultPercent);
	}

	/**
	 * Sets the loss remarks of this claim od search.
	 *
	 * @param lossRemarks the loss remarks of this claim od search
	 */
	@Override
	public void setLossRemarks(String lossRemarks) {
		model.setLossRemarks(lossRemarks);
	}

	/**
	 * Sets the natureof loss of this claim od search.
	 *
	 * @param natureofLoss the natureof loss of this claim od search
	 */
	@Override
	public void setNatureofLoss(String natureofLoss) {
		model.setNatureofLoss(natureofLoss);
	}

	/**
	 * Sets the policy no of this claim od search.
	 *
	 * @param policyNo the policy no of this claim od search
	 */
	@Override
	public void setPolicyNo(String policyNo) {
		model.setPolicyNo(policyNo);
	}

	/**
	 * Sets the primary key of this claim od search.
	 *
	 * @param primaryKey the primary key of this claim od search
	 */
	@Override
	public void setPrimaryKey(
		com.ejada.atmc.acl.db.service.persistence.ClaimODSearchPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the report no of this claim od search.
	 *
	 * @param reportNo the report no of this claim od search
	 */
	@Override
	public void setReportNo(String reportNo) {
		model.setReportNo(reportNo);
	}

	/**
	 * Sets the type of claim of this claim od search.
	 *
	 * @param typeOfClaim the type of claim of this claim od search
	 */
	@Override
	public void setTypeOfClaim(String typeOfClaim) {
		model.setTypeOfClaim(typeOfClaim);
	}

	/**
	 * Sets the vehicle dev type of this claim od search.
	 *
	 * @param vehicleDevType the vehicle dev type of this claim od search
	 */
	@Override
	public void setVehicleDevType(String vehicleDevType) {
		model.setVehicleDevType(vehicleDevType);
	}

	/**
	 * Sets the vehicle seq custom of this claim od search.
	 *
	 * @param vehicleSEQCustom the vehicle seq custom of this claim od search
	 */
	@Override
	public void setVehicleSEQCustom(String vehicleSEQCustom) {
		model.setVehicleSEQCustom(vehicleSEQCustom);
	}

	@Override
	protected ClaimODSearchWrapper wrap(ClaimODSearch claimODSearch) {
		return new ClaimODSearchWrapper(claimODSearch);
	}

}