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

import java.io.Serializable;

import java.sql.Blob;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.QuotationAdminUploadsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class QuotationAdminUploadsSoap implements Serializable {

	public static QuotationAdminUploadsSoap toSoapModel(
		QuotationAdminUploads model) {

		QuotationAdminUploadsSoap soapModel = new QuotationAdminUploadsSoap();

		soapModel.setId(model.getId());
		soapModel.setQuotationId(model.getQuotationId());
		soapModel.setFileName(model.getFileName());
		soapModel.setAdminFile(model.getAdminFile());

		return soapModel;
	}

	public static QuotationAdminUploadsSoap[] toSoapModels(
		QuotationAdminUploads[] models) {

		QuotationAdminUploadsSoap[] soapModels =
			new QuotationAdminUploadsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuotationAdminUploadsSoap[][] toSoapModels(
		QuotationAdminUploads[][] models) {

		QuotationAdminUploadsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new QuotationAdminUploadsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuotationAdminUploadsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuotationAdminUploadsSoap[] toSoapModels(
		List<QuotationAdminUploads> models) {

		List<QuotationAdminUploadsSoap> soapModels =
			new ArrayList<QuotationAdminUploadsSoap>(models.size());

		for (QuotationAdminUploads model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new QuotationAdminUploadsSoap[soapModels.size()]);
	}

	public QuotationAdminUploadsSoap() {
	}

	public int getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(int pk) {
		setId(pk);
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public long getQuotationId() {
		return _quotationId;
	}

	public void setQuotationId(long quotationId) {
		_quotationId = quotationId;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public Blob getAdminFile() {
		return _adminFile;
	}

	public void setAdminFile(Blob adminFile) {
		_adminFile = adminFile;
	}

	private int _id;
	private long _quotationId;
	private String _fileName;
	private Blob _adminFile;

}