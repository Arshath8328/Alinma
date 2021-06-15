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
 * This class is a wrapper for {@link ClaimAdminUploads}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimAdminUploads
 * @generated
 */
public class ClaimAdminUploadsWrapper
	extends BaseModelWrapper<ClaimAdminUploads>
	implements ClaimAdminUploads, ModelWrapper<ClaimAdminUploads> {

	public ClaimAdminUploadsWrapper(ClaimAdminUploads claimAdminUploads) {
		super(claimAdminUploads);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("refNo", getRefNo());
		attributes.put("fileName", getFileName());
		attributes.put("adminFile", getAdminFile());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String refNo = (String)attributes.get("refNo");

		if (refNo != null) {
			setRefNo(refNo);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		Blob adminFile = (Blob)attributes.get("adminFile");

		if (adminFile != null) {
			setAdminFile(adminFile);
		}
	}

	/**
	 * Returns the admin file of this claim admin uploads.
	 *
	 * @return the admin file of this claim admin uploads
	 */
	@Override
	public Blob getAdminFile() {
		return model.getAdminFile();
	}

	/**
	 * Returns the file name of this claim admin uploads.
	 *
	 * @return the file name of this claim admin uploads
	 */
	@Override
	public String getFileName() {
		return model.getFileName();
	}

	/**
	 * Returns the ID of this claim admin uploads.
	 *
	 * @return the ID of this claim admin uploads
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this claim admin uploads.
	 *
	 * @return the primary key of this claim admin uploads
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ref no of this claim admin uploads.
	 *
	 * @return the ref no of this claim admin uploads
	 */
	@Override
	public String getRefNo() {
		return model.getRefNo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the admin file of this claim admin uploads.
	 *
	 * @param adminFile the admin file of this claim admin uploads
	 */
	@Override
	public void setAdminFile(Blob adminFile) {
		model.setAdminFile(adminFile);
	}

	/**
	 * Sets the file name of this claim admin uploads.
	 *
	 * @param fileName the file name of this claim admin uploads
	 */
	@Override
	public void setFileName(String fileName) {
		model.setFileName(fileName);
	}

	/**
	 * Sets the ID of this claim admin uploads.
	 *
	 * @param id the ID of this claim admin uploads
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this claim admin uploads.
	 *
	 * @param primaryKey the primary key of this claim admin uploads
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ref no of this claim admin uploads.
	 *
	 * @param refNo the ref no of this claim admin uploads
	 */
	@Override
	public void setRefNo(String refNo) {
		model.setRefNo(refNo);
	}

	@Override
	protected ClaimAdminUploadsWrapper wrap(
		ClaimAdminUploads claimAdminUploads) {

		return new ClaimAdminUploadsWrapper(claimAdminUploads);
	}

}