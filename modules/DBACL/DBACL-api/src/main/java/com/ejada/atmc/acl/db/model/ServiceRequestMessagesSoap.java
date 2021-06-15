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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.ServiceRequestMessagesServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ServiceRequestMessagesSoap implements Serializable {

	public static ServiceRequestMessagesSoap toSoapModel(
		ServiceRequestMessages model) {

		ServiceRequestMessagesSoap soapModel = new ServiceRequestMessagesSoap();

		soapModel.setMESSAGE_ID(model.getMESSAGE_ID());
		soapModel.setREFERENCE_NO(model.getREFERENCE_NO());
		soapModel.setUSER_ID(model.getUSER_ID());
		soapModel.setUSER_NAME(model.getUSER_NAME());
		soapModel.setUSER_TYPE(model.getUSER_TYPE());
		soapModel.setUSER_MESSAGE(model.getUSER_MESSAGE());
		soapModel.setTIME_STAMP(model.getTIME_STAMP());

		return soapModel;
	}

	public static ServiceRequestMessagesSoap[] toSoapModels(
		ServiceRequestMessages[] models) {

		ServiceRequestMessagesSoap[] soapModels =
			new ServiceRequestMessagesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServiceRequestMessagesSoap[][] toSoapModels(
		ServiceRequestMessages[][] models) {

		ServiceRequestMessagesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ServiceRequestMessagesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServiceRequestMessagesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServiceRequestMessagesSoap[] toSoapModels(
		List<ServiceRequestMessages> models) {

		List<ServiceRequestMessagesSoap> soapModels =
			new ArrayList<ServiceRequestMessagesSoap>(models.size());

		for (ServiceRequestMessages model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new ServiceRequestMessagesSoap[soapModels.size()]);
	}

	public ServiceRequestMessagesSoap() {
	}

	public long getPrimaryKey() {
		return _MESSAGE_ID;
	}

	public void setPrimaryKey(long pk) {
		setMESSAGE_ID(pk);
	}

	public long getMESSAGE_ID() {
		return _MESSAGE_ID;
	}

	public void setMESSAGE_ID(long MESSAGE_ID) {
		_MESSAGE_ID = MESSAGE_ID;
	}

	public String getREFERENCE_NO() {
		return _REFERENCE_NO;
	}

	public void setREFERENCE_NO(String REFERENCE_NO) {
		_REFERENCE_NO = REFERENCE_NO;
	}

	public String getUSER_ID() {
		return _USER_ID;
	}

	public void setUSER_ID(String USER_ID) {
		_USER_ID = USER_ID;
	}

	public String getUSER_NAME() {
		return _USER_NAME;
	}

	public void setUSER_NAME(String USER_NAME) {
		_USER_NAME = USER_NAME;
	}

	public String getUSER_TYPE() {
		return _USER_TYPE;
	}

	public void setUSER_TYPE(String USER_TYPE) {
		_USER_TYPE = USER_TYPE;
	}

	public String getUSER_MESSAGE() {
		return _USER_MESSAGE;
	}

	public void setUSER_MESSAGE(String USER_MESSAGE) {
		_USER_MESSAGE = USER_MESSAGE;
	}

	public Date getTIME_STAMP() {
		return _TIME_STAMP;
	}

	public void setTIME_STAMP(Date TIME_STAMP) {
		_TIME_STAMP = TIME_STAMP;
	}

	private long _MESSAGE_ID;

	private String _REFERENCE_NO;

	private String _USER_ID;

	private String _USER_NAME;

	private String _USER_TYPE;

	private String _USER_MESSAGE;

	private Date _TIME_STAMP;

}