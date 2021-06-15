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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.ServiceRequestHistoryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ServiceRequestHistorySoap implements Serializable {

	public static ServiceRequestHistorySoap toSoapModel(
		ServiceRequestHistory model) {

		ServiceRequestHistorySoap soapModel = new ServiceRequestHistorySoap();

		soapModel.setACTION_ID(model.getACTION_ID());
		soapModel.setREFERENCE_NO(model.getREFERENCE_NO());
		soapModel.setACTION_TYPE(model.getACTION_TYPE());
		soapModel.setACTION_DETAILS(model.getACTION_DETAILS());
		soapModel.setACTION_REMARKS(model.getACTION_REMARKS());
		soapModel.setACTION_DATE(model.getACTION_DATE());

		return soapModel;
	}

	public static ServiceRequestHistorySoap[] toSoapModels(
		ServiceRequestHistory[] models) {

		ServiceRequestHistorySoap[] soapModels =
			new ServiceRequestHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServiceRequestHistorySoap[][] toSoapModels(
		ServiceRequestHistory[][] models) {

		ServiceRequestHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ServiceRequestHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServiceRequestHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServiceRequestHistorySoap[] toSoapModels(
		List<ServiceRequestHistory> models) {

		List<ServiceRequestHistorySoap> soapModels =
			new ArrayList<ServiceRequestHistorySoap>(models.size());

		for (ServiceRequestHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new ServiceRequestHistorySoap[soapModels.size()]);
	}

	public ServiceRequestHistorySoap() {
	}

	public long getPrimaryKey() {
		return _ACTION_ID;
	}

	public void setPrimaryKey(long pk) {
		setACTION_ID(pk);
	}

	public long getACTION_ID() {
		return _ACTION_ID;
	}

	public void setACTION_ID(long ACTION_ID) {
		_ACTION_ID = ACTION_ID;
	}

	public String getREFERENCE_NO() {
		return _REFERENCE_NO;
	}

	public void setREFERENCE_NO(String REFERENCE_NO) {
		_REFERENCE_NO = REFERENCE_NO;
	}

	public String getACTION_TYPE() {
		return _ACTION_TYPE;
	}

	public void setACTION_TYPE(String ACTION_TYPE) {
		_ACTION_TYPE = ACTION_TYPE;
	}

	public String getACTION_DETAILS() {
		return _ACTION_DETAILS;
	}

	public void setACTION_DETAILS(String ACTION_DETAILS) {
		_ACTION_DETAILS = ACTION_DETAILS;
	}

	public String getACTION_REMARKS() {
		return _ACTION_REMARKS;
	}

	public void setACTION_REMARKS(String ACTION_REMARKS) {
		_ACTION_REMARKS = ACTION_REMARKS;
	}

	public Date getACTION_DATE() {
		return _ACTION_DATE;
	}

	public void setACTION_DATE(Date ACTION_DATE) {
		_ACTION_DATE = ACTION_DATE;
	}

	private long _ACTION_ID;

	private String _REFERENCE_NO;

	private String _ACTION_TYPE;

	private String _ACTION_DETAILS;

	private String _ACTION_REMARKS;

	private Date _ACTION_DATE;

}