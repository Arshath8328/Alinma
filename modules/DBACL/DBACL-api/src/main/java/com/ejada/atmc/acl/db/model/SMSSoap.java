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

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.SMSServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SMSSoap implements Serializable {

	public static SMSSoap toSoapModel(SMS model) {
		SMSSoap soapModel = new SMSSoap();

		soapModel.setID(model.getID());
		soapModel.setMessage(model.getMessage());
		soapModel.setMobile(model.getMobile());
		soapModel.setSmsType(model.getSmsType());

		return soapModel;
	}

	public static SMSSoap[] toSoapModels(SMS[] models) {
		SMSSoap[] soapModels = new SMSSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SMSSoap[][] toSoapModels(SMS[][] models) {
		SMSSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SMSSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SMSSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SMSSoap[] toSoapModels(List<SMS> models) {
		List<SMSSoap> soapModels = new ArrayList<SMSSoap>(models.size());

		for (SMS model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SMSSoap[soapModels.size()]);
	}

	public SMSSoap() {
	}

	public long getPrimaryKey() {
		return _ID;
	}

	public void setPrimaryKey(long pk) {
		setID(pk);
	}

	public long getID() {
		return _ID;
	}

	public void setID(long ID) {
		_ID = ID;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public String getMobile() {
		return _mobile;
	}

	public void setMobile(String mobile) {
		_mobile = mobile;
	}

	public String getSmsType() {
		return _smsType;
	}

	public void setSmsType(String smsType) {
		_smsType = smsType;
	}

	private long _ID;

	private String _message;
	private String _mobile;
	private String _smsType;

}