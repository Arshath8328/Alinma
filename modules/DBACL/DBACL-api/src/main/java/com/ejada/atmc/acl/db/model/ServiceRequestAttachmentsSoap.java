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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.ServiceRequestAttachmentsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ServiceRequestAttachmentsSoap implements Serializable {

	public static ServiceRequestAttachmentsSoap toSoapModel(
		ServiceRequestAttachments model) {

		ServiceRequestAttachmentsSoap soapModel =
			new ServiceRequestAttachmentsSoap();

		soapModel.setFILE_ID(model.getFILE_ID());
		soapModel.setREFERENCE_NO(model.getREFERENCE_NO());
		soapModel.setACTION_ID(model.getACTION_ID());
		soapModel.setFILE_CONTENT(model.getFILE_CONTENT());
		soapModel.setFILE_NAME(model.getFILE_NAME());

		return soapModel;
	}

	public static ServiceRequestAttachmentsSoap[] toSoapModels(
		ServiceRequestAttachments[] models) {

		ServiceRequestAttachmentsSoap[] soapModels =
			new ServiceRequestAttachmentsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServiceRequestAttachmentsSoap[][] toSoapModels(
		ServiceRequestAttachments[][] models) {

		ServiceRequestAttachmentsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ServiceRequestAttachmentsSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new ServiceRequestAttachmentsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServiceRequestAttachmentsSoap[] toSoapModels(
		List<ServiceRequestAttachments> models) {

		List<ServiceRequestAttachmentsSoap> soapModels =
			new ArrayList<ServiceRequestAttachmentsSoap>(models.size());

		for (ServiceRequestAttachments model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new ServiceRequestAttachmentsSoap[soapModels.size()]);
	}

	public ServiceRequestAttachmentsSoap() {
	}

	public long getPrimaryKey() {
		return _FILE_ID;
	}

	public void setPrimaryKey(long pk) {
		setFILE_ID(pk);
	}

	public long getFILE_ID() {
		return _FILE_ID;
	}

	public void setFILE_ID(long FILE_ID) {
		_FILE_ID = FILE_ID;
	}

	public String getREFERENCE_NO() {
		return _REFERENCE_NO;
	}

	public void setREFERENCE_NO(String REFERENCE_NO) {
		_REFERENCE_NO = REFERENCE_NO;
	}

	public String getACTION_ID() {
		return _ACTION_ID;
	}

	public void setACTION_ID(String ACTION_ID) {
		_ACTION_ID = ACTION_ID;
	}

	public Blob getFILE_CONTENT() {
		return _FILE_CONTENT;
	}

	public void setFILE_CONTENT(Blob FILE_CONTENT) {
		_FILE_CONTENT = FILE_CONTENT;
	}

	public String getFILE_NAME() {
		return _FILE_NAME;
	}

	public void setFILE_NAME(String FILE_NAME) {
		_FILE_NAME = FILE_NAME;
	}

	private long _FILE_ID;

	private String _REFERENCE_NO;

	private String _ACTION_ID;

	private Blob _FILE_CONTENT;

	private String _FILE_NAME;

}