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
 * This class is a wrapper for {@link PolicyVehDrv}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyVehDrv
 * @generated
 */
public class PolicyVehDrvWrapper
	extends BaseModelWrapper<PolicyVehDrv>
	implements ModelWrapper<PolicyVehDrv>, PolicyVehDrv {

	public PolicyVehDrvWrapper(PolicyVehDrv policyVehDrv) {
		super(policyVehDrv);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("policyNo", getPolicyNo());
		attributes.put("vehId", getVehId());
		attributes.put("driverLicenseNo", getDriverLicenseNo());
		attributes.put("driverName", getDriverName());
		attributes.put("driverBirthDate", getDriverBirthDate());
		attributes.put("driverNationality", getDriverNationality());
		attributes.put("driverGender", getDriverGender());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String policyNo = (String)attributes.get("policyNo");

		if (policyNo != null) {
			setPolicyNo(policyNo);
		}

		Long vehId = (Long)attributes.get("vehId");

		if (vehId != null) {
			setVehId(vehId);
		}

		String driverLicenseNo = (String)attributes.get("driverLicenseNo");

		if (driverLicenseNo != null) {
			setDriverLicenseNo(driverLicenseNo);
		}

		String driverName = (String)attributes.get("driverName");

		if (driverName != null) {
			setDriverName(driverName);
		}

		Date driverBirthDate = (Date)attributes.get("driverBirthDate");

		if (driverBirthDate != null) {
			setDriverBirthDate(driverBirthDate);
		}

		String driverNationality = (String)attributes.get("driverNationality");

		if (driverNationality != null) {
			setDriverNationality(driverNationality);
		}

		String driverGender = (String)attributes.get("driverGender");

		if (driverGender != null) {
			setDriverGender(driverGender);
		}
	}

	/**
	 * Returns the driver birth date of this policy veh drv.
	 *
	 * @return the driver birth date of this policy veh drv
	 */
	@Override
	public Date getDriverBirthDate() {
		return model.getDriverBirthDate();
	}

	/**
	 * Returns the driver gender of this policy veh drv.
	 *
	 * @return the driver gender of this policy veh drv
	 */
	@Override
	public String getDriverGender() {
		return model.getDriverGender();
	}

	/**
	 * Returns the driver license no of this policy veh drv.
	 *
	 * @return the driver license no of this policy veh drv
	 */
	@Override
	public String getDriverLicenseNo() {
		return model.getDriverLicenseNo();
	}

	/**
	 * Returns the driver name of this policy veh drv.
	 *
	 * @return the driver name of this policy veh drv
	 */
	@Override
	public String getDriverName() {
		return model.getDriverName();
	}

	/**
	 * Returns the driver nationality of this policy veh drv.
	 *
	 * @return the driver nationality of this policy veh drv
	 */
	@Override
	public String getDriverNationality() {
		return model.getDriverNationality();
	}

	@Override
	public String getGenderDescAr() {
		return model.getGenderDescAr();
	}

	@Override
	public String getGenderDescEn() {
		return model.getGenderDescEn();
	}

	@Override
	public String getNationalityDescAr() {
		return model.getNationalityDescAr();
	}

	@Override
	public String getNationalityDescEn() {
		return model.getNationalityDescEn();
	}

	/**
	 * Returns the policy no of this policy veh drv.
	 *
	 * @return the policy no of this policy veh drv
	 */
	@Override
	public String getPolicyNo() {
		return model.getPolicyNo();
	}

	/**
	 * Returns the primary key of this policy veh drv.
	 *
	 * @return the primary key of this policy veh drv
	 */
	@Override
	public com.ejada.atmc.acl.db.service.persistence.PolicyVehDrvPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the veh ID of this policy veh drv.
	 *
	 * @return the veh ID of this policy veh drv
	 */
	@Override
	public long getVehId() {
		return model.getVehId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the driver birth date of this policy veh drv.
	 *
	 * @param driverBirthDate the driver birth date of this policy veh drv
	 */
	@Override
	public void setDriverBirthDate(Date driverBirthDate) {
		model.setDriverBirthDate(driverBirthDate);
	}

	/**
	 * Sets the driver gender of this policy veh drv.
	 *
	 * @param driverGender the driver gender of this policy veh drv
	 */
	@Override
	public void setDriverGender(String driverGender) {
		model.setDriverGender(driverGender);
	}

	/**
	 * Sets the driver license no of this policy veh drv.
	 *
	 * @param driverLicenseNo the driver license no of this policy veh drv
	 */
	@Override
	public void setDriverLicenseNo(String driverLicenseNo) {
		model.setDriverLicenseNo(driverLicenseNo);
	}

	/**
	 * Sets the driver name of this policy veh drv.
	 *
	 * @param driverName the driver name of this policy veh drv
	 */
	@Override
	public void setDriverName(String driverName) {
		model.setDriverName(driverName);
	}

	/**
	 * Sets the driver nationality of this policy veh drv.
	 *
	 * @param driverNationality the driver nationality of this policy veh drv
	 */
	@Override
	public void setDriverNationality(String driverNationality) {
		model.setDriverNationality(driverNationality);
	}

	/**
	 * Sets the policy no of this policy veh drv.
	 *
	 * @param policyNo the policy no of this policy veh drv
	 */
	@Override
	public void setPolicyNo(String policyNo) {
		model.setPolicyNo(policyNo);
	}

	/**
	 * Sets the primary key of this policy veh drv.
	 *
	 * @param primaryKey the primary key of this policy veh drv
	 */
	@Override
	public void setPrimaryKey(
		com.ejada.atmc.acl.db.service.persistence.PolicyVehDrvPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the veh ID of this policy veh drv.
	 *
	 * @param vehId the veh ID of this policy veh drv
	 */
	@Override
	public void setVehId(long vehId) {
		model.setVehId(vehId);
	}

	@Override
	protected PolicyVehDrvWrapper wrap(PolicyVehDrv policyVehDrv) {
		return new PolicyVehDrvWrapper(policyVehDrv);
	}

}