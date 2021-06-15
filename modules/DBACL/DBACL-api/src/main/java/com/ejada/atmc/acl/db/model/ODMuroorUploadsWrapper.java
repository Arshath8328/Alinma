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

import java.sql.Blob;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ODMuroorUploads}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ODMuroorUploads
 * @generated
 */
public class ODMuroorUploadsWrapper
	extends BaseModelWrapper<ODMuroorUploads>
	implements ModelWrapper<ODMuroorUploads>, ODMuroorUploads {

	public ODMuroorUploadsWrapper(ODMuroorUploads odMuroorUploads) {
		super(odMuroorUploads);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("claimIntimationNo", getClaimIntimationNo());
		attributes.put("iqamaId", getIqamaId());
		attributes.put("driverLicense", getDriverLicense());
		attributes.put("driverLicenseName", getDriverLicenseName());
		attributes.put("vehRegist", getVehRegist());
		attributes.put("vehRegistName", getVehRegistName());
		attributes.put("policyCopy", getPolicyCopy());
		attributes.put("policyCopyName", getPolicyCopyName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String claimIntimationNo = (String)attributes.get("claimIntimationNo");

		if (claimIntimationNo != null) {
			setClaimIntimationNo(claimIntimationNo);
		}

		String iqamaId = (String)attributes.get("iqamaId");

		if (iqamaId != null) {
			setIqamaId(iqamaId);
		}

		Blob driverLicense = (Blob)attributes.get("driverLicense");

		if (driverLicense != null) {
			setDriverLicense(driverLicense);
		}

		String driverLicenseName = (String)attributes.get("driverLicenseName");

		if (driverLicenseName != null) {
			setDriverLicenseName(driverLicenseName);
		}

		Blob vehRegist = (Blob)attributes.get("vehRegist");

		if (vehRegist != null) {
			setVehRegist(vehRegist);
		}

		String vehRegistName = (String)attributes.get("vehRegistName");

		if (vehRegistName != null) {
			setVehRegistName(vehRegistName);
		}

		Blob policyCopy = (Blob)attributes.get("policyCopy");

		if (policyCopy != null) {
			setPolicyCopy(policyCopy);
		}

		String policyCopyName = (String)attributes.get("policyCopyName");

		if (policyCopyName != null) {
			setPolicyCopyName(policyCopyName);
		}
	}

	/**
	 * Returns the claim intimation no of this od muroor uploads.
	 *
	 * @return the claim intimation no of this od muroor uploads
	 */
	@Override
	public String getClaimIntimationNo() {
		return model.getClaimIntimationNo();
	}

	/**
	 * Returns the driver license of this od muroor uploads.
	 *
	 * @return the driver license of this od muroor uploads
	 */
	@Override
	public Blob getDriverLicense() {
		return model.getDriverLicense();
	}

	/**
	 * Returns the driver license name of this od muroor uploads.
	 *
	 * @return the driver license name of this od muroor uploads
	 */
	@Override
	public String getDriverLicenseName() {
		return model.getDriverLicenseName();
	}

	/**
	 * Returns the ID of this od muroor uploads.
	 *
	 * @return the ID of this od muroor uploads
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the iqama ID of this od muroor uploads.
	 *
	 * @return the iqama ID of this od muroor uploads
	 */
	@Override
	public String getIqamaId() {
		return model.getIqamaId();
	}

	/**
	 * Returns the policy copy of this od muroor uploads.
	 *
	 * @return the policy copy of this od muroor uploads
	 */
	@Override
	public Blob getPolicyCopy() {
		return model.getPolicyCopy();
	}

	/**
	 * Returns the policy copy name of this od muroor uploads.
	 *
	 * @return the policy copy name of this od muroor uploads
	 */
	@Override
	public String getPolicyCopyName() {
		return model.getPolicyCopyName();
	}

	/**
	 * Returns the primary key of this od muroor uploads.
	 *
	 * @return the primary key of this od muroor uploads
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the veh regist of this od muroor uploads.
	 *
	 * @return the veh regist of this od muroor uploads
	 */
	@Override
	public Blob getVehRegist() {
		return model.getVehRegist();
	}

	/**
	 * Returns the veh regist name of this od muroor uploads.
	 *
	 * @return the veh regist name of this od muroor uploads
	 */
	@Override
	public String getVehRegistName() {
		return model.getVehRegistName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the claim intimation no of this od muroor uploads.
	 *
	 * @param claimIntimationNo the claim intimation no of this od muroor uploads
	 */
	@Override
	public void setClaimIntimationNo(String claimIntimationNo) {
		model.setClaimIntimationNo(claimIntimationNo);
	}

	/**
	 * Sets the driver license of this od muroor uploads.
	 *
	 * @param driverLicense the driver license of this od muroor uploads
	 */
	@Override
	public void setDriverLicense(Blob driverLicense) {
		model.setDriverLicense(driverLicense);
	}

	/**
	 * Sets the driver license name of this od muroor uploads.
	 *
	 * @param driverLicenseName the driver license name of this od muroor uploads
	 */
	@Override
	public void setDriverLicenseName(String driverLicenseName) {
		model.setDriverLicenseName(driverLicenseName);
	}

	/**
	 * Sets the ID of this od muroor uploads.
	 *
	 * @param id the ID of this od muroor uploads
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the iqama ID of this od muroor uploads.
	 *
	 * @param iqamaId the iqama ID of this od muroor uploads
	 */
	@Override
	public void setIqamaId(String iqamaId) {
		model.setIqamaId(iqamaId);
	}

	/**
	 * Sets the policy copy of this od muroor uploads.
	 *
	 * @param policyCopy the policy copy of this od muroor uploads
	 */
	@Override
	public void setPolicyCopy(Blob policyCopy) {
		model.setPolicyCopy(policyCopy);
	}

	/**
	 * Sets the policy copy name of this od muroor uploads.
	 *
	 * @param policyCopyName the policy copy name of this od muroor uploads
	 */
	@Override
	public void setPolicyCopyName(String policyCopyName) {
		model.setPolicyCopyName(policyCopyName);
	}

	/**
	 * Sets the primary key of this od muroor uploads.
	 *
	 * @param primaryKey the primary key of this od muroor uploads
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the veh regist of this od muroor uploads.
	 *
	 * @param vehRegist the veh regist of this od muroor uploads
	 */
	@Override
	public void setVehRegist(Blob vehRegist) {
		model.setVehRegist(vehRegist);
	}

	/**
	 * Sets the veh regist name of this od muroor uploads.
	 *
	 * @param vehRegistName the veh regist name of this od muroor uploads
	 */
	@Override
	public void setVehRegistName(String vehRegistName) {
		model.setVehRegistName(vehRegistName);
	}

	@Override
	protected ODMuroorUploadsWrapper wrap(ODMuroorUploads odMuroorUploads) {
		return new ODMuroorUploadsWrapper(odMuroorUploads);
	}

}