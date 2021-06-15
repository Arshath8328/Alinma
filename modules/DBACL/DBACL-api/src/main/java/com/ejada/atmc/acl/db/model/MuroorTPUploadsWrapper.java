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
 * This class is a wrapper for {@link MuroorTPUploads}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MuroorTPUploads
 * @generated
 */
public class MuroorTPUploadsWrapper
	extends BaseModelWrapper<MuroorTPUploads>
	implements ModelWrapper<MuroorTPUploads>, MuroorTPUploads {

	public MuroorTPUploadsWrapper(MuroorTPUploads muroorTPUploads) {
		super(muroorTPUploads);
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
		attributes.put("frontPhoto", getFrontPhoto());
		attributes.put("frontPhotoName", getFrontPhotoName());
		attributes.put("rearPhoto", getRearPhoto());
		attributes.put("rearPhotoName", getRearPhotoName());
		attributes.put("rightSidePhoto", getRightSidePhoto());
		attributes.put("rightSidePhotoName", getRightSidePhotoName());
		attributes.put("leftSidePhoto", getLeftSidePhoto());
		attributes.put("leftSidePhotoName", getLeftSidePhotoName());
		attributes.put("bankIban", getBankIban());
		attributes.put("bankIbanName", getBankIbanName());
		attributes.put("ownerId", getOwnerId());
		attributes.put("ownerIdName", getOwnerIdName());

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

		Blob frontPhoto = (Blob)attributes.get("frontPhoto");

		if (frontPhoto != null) {
			setFrontPhoto(frontPhoto);
		}

		String frontPhotoName = (String)attributes.get("frontPhotoName");

		if (frontPhotoName != null) {
			setFrontPhotoName(frontPhotoName);
		}

		Blob rearPhoto = (Blob)attributes.get("rearPhoto");

		if (rearPhoto != null) {
			setRearPhoto(rearPhoto);
		}

		String rearPhotoName = (String)attributes.get("rearPhotoName");

		if (rearPhotoName != null) {
			setRearPhotoName(rearPhotoName);
		}

		Blob rightSidePhoto = (Blob)attributes.get("rightSidePhoto");

		if (rightSidePhoto != null) {
			setRightSidePhoto(rightSidePhoto);
		}

		String rightSidePhotoName = (String)attributes.get(
			"rightSidePhotoName");

		if (rightSidePhotoName != null) {
			setRightSidePhotoName(rightSidePhotoName);
		}

		Blob leftSidePhoto = (Blob)attributes.get("leftSidePhoto");

		if (leftSidePhoto != null) {
			setLeftSidePhoto(leftSidePhoto);
		}

		String leftSidePhotoName = (String)attributes.get("leftSidePhotoName");

		if (leftSidePhotoName != null) {
			setLeftSidePhotoName(leftSidePhotoName);
		}

		Blob bankIban = (Blob)attributes.get("bankIban");

		if (bankIban != null) {
			setBankIban(bankIban);
		}

		String bankIbanName = (String)attributes.get("bankIbanName");

		if (bankIbanName != null) {
			setBankIbanName(bankIbanName);
		}

		Blob ownerId = (Blob)attributes.get("ownerId");

		if (ownerId != null) {
			setOwnerId(ownerId);
		}

		String ownerIdName = (String)attributes.get("ownerIdName");

		if (ownerIdName != null) {
			setOwnerIdName(ownerIdName);
		}
	}

	/**
	 * Returns the bank iban of this muroor tp uploads.
	 *
	 * @return the bank iban of this muroor tp uploads
	 */
	@Override
	public Blob getBankIban() {
		return model.getBankIban();
	}

	/**
	 * Returns the bank iban name of this muroor tp uploads.
	 *
	 * @return the bank iban name of this muroor tp uploads
	 */
	@Override
	public String getBankIbanName() {
		return model.getBankIbanName();
	}

	/**
	 * Returns the claim intimation no of this muroor tp uploads.
	 *
	 * @return the claim intimation no of this muroor tp uploads
	 */
	@Override
	public String getClaimIntimationNo() {
		return model.getClaimIntimationNo();
	}

	/**
	 * Returns the driver license of this muroor tp uploads.
	 *
	 * @return the driver license of this muroor tp uploads
	 */
	@Override
	public Blob getDriverLicense() {
		return model.getDriverLicense();
	}

	/**
	 * Returns the driver license name of this muroor tp uploads.
	 *
	 * @return the driver license name of this muroor tp uploads
	 */
	@Override
	public String getDriverLicenseName() {
		return model.getDriverLicenseName();
	}

	/**
	 * Returns the front photo of this muroor tp uploads.
	 *
	 * @return the front photo of this muroor tp uploads
	 */
	@Override
	public Blob getFrontPhoto() {
		return model.getFrontPhoto();
	}

	/**
	 * Returns the front photo name of this muroor tp uploads.
	 *
	 * @return the front photo name of this muroor tp uploads
	 */
	@Override
	public String getFrontPhotoName() {
		return model.getFrontPhotoName();
	}

	/**
	 * Returns the ID of this muroor tp uploads.
	 *
	 * @return the ID of this muroor tp uploads
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the iqama ID of this muroor tp uploads.
	 *
	 * @return the iqama ID of this muroor tp uploads
	 */
	@Override
	public String getIqamaId() {
		return model.getIqamaId();
	}

	/**
	 * Returns the left side photo of this muroor tp uploads.
	 *
	 * @return the left side photo of this muroor tp uploads
	 */
	@Override
	public Blob getLeftSidePhoto() {
		return model.getLeftSidePhoto();
	}

	/**
	 * Returns the left side photo name of this muroor tp uploads.
	 *
	 * @return the left side photo name of this muroor tp uploads
	 */
	@Override
	public String getLeftSidePhotoName() {
		return model.getLeftSidePhotoName();
	}

	/**
	 * Returns the owner ID of this muroor tp uploads.
	 *
	 * @return the owner ID of this muroor tp uploads
	 */
	@Override
	public Blob getOwnerId() {
		return model.getOwnerId();
	}

	/**
	 * Returns the owner ID name of this muroor tp uploads.
	 *
	 * @return the owner ID name of this muroor tp uploads
	 */
	@Override
	public String getOwnerIdName() {
		return model.getOwnerIdName();
	}

	/**
	 * Returns the primary key of this muroor tp uploads.
	 *
	 * @return the primary key of this muroor tp uploads
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rear photo of this muroor tp uploads.
	 *
	 * @return the rear photo of this muroor tp uploads
	 */
	@Override
	public Blob getRearPhoto() {
		return model.getRearPhoto();
	}

	/**
	 * Returns the rear photo name of this muroor tp uploads.
	 *
	 * @return the rear photo name of this muroor tp uploads
	 */
	@Override
	public String getRearPhotoName() {
		return model.getRearPhotoName();
	}

	/**
	 * Returns the right side photo of this muroor tp uploads.
	 *
	 * @return the right side photo of this muroor tp uploads
	 */
	@Override
	public Blob getRightSidePhoto() {
		return model.getRightSidePhoto();
	}

	/**
	 * Returns the right side photo name of this muroor tp uploads.
	 *
	 * @return the right side photo name of this muroor tp uploads
	 */
	@Override
	public String getRightSidePhotoName() {
		return model.getRightSidePhotoName();
	}

	/**
	 * Returns the veh regist of this muroor tp uploads.
	 *
	 * @return the veh regist of this muroor tp uploads
	 */
	@Override
	public Blob getVehRegist() {
		return model.getVehRegist();
	}

	/**
	 * Returns the veh regist name of this muroor tp uploads.
	 *
	 * @return the veh regist name of this muroor tp uploads
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
	 * Sets the bank iban of this muroor tp uploads.
	 *
	 * @param bankIban the bank iban of this muroor tp uploads
	 */
	@Override
	public void setBankIban(Blob bankIban) {
		model.setBankIban(bankIban);
	}

	/**
	 * Sets the bank iban name of this muroor tp uploads.
	 *
	 * @param bankIbanName the bank iban name of this muroor tp uploads
	 */
	@Override
	public void setBankIbanName(String bankIbanName) {
		model.setBankIbanName(bankIbanName);
	}

	/**
	 * Sets the claim intimation no of this muroor tp uploads.
	 *
	 * @param claimIntimationNo the claim intimation no of this muroor tp uploads
	 */
	@Override
	public void setClaimIntimationNo(String claimIntimationNo) {
		model.setClaimIntimationNo(claimIntimationNo);
	}

	/**
	 * Sets the driver license of this muroor tp uploads.
	 *
	 * @param driverLicense the driver license of this muroor tp uploads
	 */
	@Override
	public void setDriverLicense(Blob driverLicense) {
		model.setDriverLicense(driverLicense);
	}

	/**
	 * Sets the driver license name of this muroor tp uploads.
	 *
	 * @param driverLicenseName the driver license name of this muroor tp uploads
	 */
	@Override
	public void setDriverLicenseName(String driverLicenseName) {
		model.setDriverLicenseName(driverLicenseName);
	}

	/**
	 * Sets the front photo of this muroor tp uploads.
	 *
	 * @param frontPhoto the front photo of this muroor tp uploads
	 */
	@Override
	public void setFrontPhoto(Blob frontPhoto) {
		model.setFrontPhoto(frontPhoto);
	}

	/**
	 * Sets the front photo name of this muroor tp uploads.
	 *
	 * @param frontPhotoName the front photo name of this muroor tp uploads
	 */
	@Override
	public void setFrontPhotoName(String frontPhotoName) {
		model.setFrontPhotoName(frontPhotoName);
	}

	/**
	 * Sets the ID of this muroor tp uploads.
	 *
	 * @param id the ID of this muroor tp uploads
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the iqama ID of this muroor tp uploads.
	 *
	 * @param iqamaId the iqama ID of this muroor tp uploads
	 */
	@Override
	public void setIqamaId(String iqamaId) {
		model.setIqamaId(iqamaId);
	}

	/**
	 * Sets the left side photo of this muroor tp uploads.
	 *
	 * @param leftSidePhoto the left side photo of this muroor tp uploads
	 */
	@Override
	public void setLeftSidePhoto(Blob leftSidePhoto) {
		model.setLeftSidePhoto(leftSidePhoto);
	}

	/**
	 * Sets the left side photo name of this muroor tp uploads.
	 *
	 * @param leftSidePhotoName the left side photo name of this muroor tp uploads
	 */
	@Override
	public void setLeftSidePhotoName(String leftSidePhotoName) {
		model.setLeftSidePhotoName(leftSidePhotoName);
	}

	/**
	 * Sets the owner ID of this muroor tp uploads.
	 *
	 * @param ownerId the owner ID of this muroor tp uploads
	 */
	@Override
	public void setOwnerId(Blob ownerId) {
		model.setOwnerId(ownerId);
	}

	/**
	 * Sets the owner ID name of this muroor tp uploads.
	 *
	 * @param ownerIdName the owner ID name of this muroor tp uploads
	 */
	@Override
	public void setOwnerIdName(String ownerIdName) {
		model.setOwnerIdName(ownerIdName);
	}

	/**
	 * Sets the primary key of this muroor tp uploads.
	 *
	 * @param primaryKey the primary key of this muroor tp uploads
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rear photo of this muroor tp uploads.
	 *
	 * @param rearPhoto the rear photo of this muroor tp uploads
	 */
	@Override
	public void setRearPhoto(Blob rearPhoto) {
		model.setRearPhoto(rearPhoto);
	}

	/**
	 * Sets the rear photo name of this muroor tp uploads.
	 *
	 * @param rearPhotoName the rear photo name of this muroor tp uploads
	 */
	@Override
	public void setRearPhotoName(String rearPhotoName) {
		model.setRearPhotoName(rearPhotoName);
	}

	/**
	 * Sets the right side photo of this muroor tp uploads.
	 *
	 * @param rightSidePhoto the right side photo of this muroor tp uploads
	 */
	@Override
	public void setRightSidePhoto(Blob rightSidePhoto) {
		model.setRightSidePhoto(rightSidePhoto);
	}

	/**
	 * Sets the right side photo name of this muroor tp uploads.
	 *
	 * @param rightSidePhotoName the right side photo name of this muroor tp uploads
	 */
	@Override
	public void setRightSidePhotoName(String rightSidePhotoName) {
		model.setRightSidePhotoName(rightSidePhotoName);
	}

	/**
	 * Sets the veh regist of this muroor tp uploads.
	 *
	 * @param vehRegist the veh regist of this muroor tp uploads
	 */
	@Override
	public void setVehRegist(Blob vehRegist) {
		model.setVehRegist(vehRegist);
	}

	/**
	 * Sets the veh regist name of this muroor tp uploads.
	 *
	 * @param vehRegistName the veh regist name of this muroor tp uploads
	 */
	@Override
	public void setVehRegistName(String vehRegistName) {
		model.setVehRegistName(vehRegistName);
	}

	@Override
	protected MuroorTPUploadsWrapper wrap(MuroorTPUploads muroorTPUploads) {
		return new MuroorTPUploadsWrapper(muroorTPUploads);
	}

}