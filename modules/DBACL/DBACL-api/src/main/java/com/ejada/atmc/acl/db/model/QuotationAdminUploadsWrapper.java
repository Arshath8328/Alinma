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
 * This class is a wrapper for {@link QuotationAdminUploads}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationAdminUploads
 * @generated
 */
public class QuotationAdminUploadsWrapper
	extends BaseModelWrapper<QuotationAdminUploads>
	implements ModelWrapper<QuotationAdminUploads>, QuotationAdminUploads {

	public QuotationAdminUploadsWrapper(
		QuotationAdminUploads quotationAdminUploads) {

		super(quotationAdminUploads);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("quotationId", getQuotationId());
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

		Long quotationId = (Long)attributes.get("quotationId");

		if (quotationId != null) {
			setQuotationId(quotationId);
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
	 * Returns the admin file of this quotation admin uploads.
	 *
	 * @return the admin file of this quotation admin uploads
	 */
	@Override
	public Blob getAdminFile() {
		return model.getAdminFile();
	}

	/**
	 * Returns the file name of this quotation admin uploads.
	 *
	 * @return the file name of this quotation admin uploads
	 */
	@Override
	public String getFileName() {
		return model.getFileName();
	}

	/**
	 * Returns the ID of this quotation admin uploads.
	 *
	 * @return the ID of this quotation admin uploads
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this quotation admin uploads.
	 *
	 * @return the primary key of this quotation admin uploads
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quotation ID of this quotation admin uploads.
	 *
	 * @return the quotation ID of this quotation admin uploads
	 */
	@Override
	public long getQuotationId() {
		return model.getQuotationId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the admin file of this quotation admin uploads.
	 *
	 * @param adminFile the admin file of this quotation admin uploads
	 */
	@Override
	public void setAdminFile(Blob adminFile) {
		model.setAdminFile(adminFile);
	}

	/**
	 * Sets the file name of this quotation admin uploads.
	 *
	 * @param fileName the file name of this quotation admin uploads
	 */
	@Override
	public void setFileName(String fileName) {
		model.setFileName(fileName);
	}

	/**
	 * Sets the ID of this quotation admin uploads.
	 *
	 * @param id the ID of this quotation admin uploads
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this quotation admin uploads.
	 *
	 * @param primaryKey the primary key of this quotation admin uploads
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quotation ID of this quotation admin uploads.
	 *
	 * @param quotationId the quotation ID of this quotation admin uploads
	 */
	@Override
	public void setQuotationId(long quotationId) {
		model.setQuotationId(quotationId);
	}

	@Override
	protected QuotationAdminUploadsWrapper wrap(
		QuotationAdminUploads quotationAdminUploads) {

		return new QuotationAdminUploadsWrapper(quotationAdminUploads);
	}

}