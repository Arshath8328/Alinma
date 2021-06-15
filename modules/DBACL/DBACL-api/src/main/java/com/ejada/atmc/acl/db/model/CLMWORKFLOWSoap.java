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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.CLMWORKFLOWServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CLMWORKFLOWSoap implements Serializable {

	public static CLMWORKFLOWSoap toSoapModel(CLMWORKFLOW model) {
		CLMWORKFLOWSoap soapModel = new CLMWORKFLOWSoap();

		soapModel.setId(model.getId());
		soapModel.setRole(model.getRole());
		soapModel.setInitialStatus(model.getInitialStatus());
		soapModel.setAction(model.getAction());
		soapModel.setNewStatus(model.getNewStatus());

		return soapModel;
	}

	public static CLMWORKFLOWSoap[] toSoapModels(CLMWORKFLOW[] models) {
		CLMWORKFLOWSoap[] soapModels = new CLMWORKFLOWSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CLMWORKFLOWSoap[][] toSoapModels(CLMWORKFLOW[][] models) {
		CLMWORKFLOWSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CLMWORKFLOWSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CLMWORKFLOWSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CLMWORKFLOWSoap[] toSoapModels(List<CLMWORKFLOW> models) {
		List<CLMWORKFLOWSoap> soapModels = new ArrayList<CLMWORKFLOWSoap>(
			models.size());

		for (CLMWORKFLOW model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CLMWORKFLOWSoap[soapModels.size()]);
	}

	public CLMWORKFLOWSoap() {
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

	public String getRole() {
		return _role;
	}

	public void setRole(String role) {
		_role = role;
	}

	public String getInitialStatus() {
		return _initialStatus;
	}

	public void setInitialStatus(String initialStatus) {
		_initialStatus = initialStatus;
	}

	public String getAction() {
		return _action;
	}

	public void setAction(String action) {
		_action = action;
	}

	public String getNewStatus() {
		return _newStatus;
	}

	public void setNewStatus(String newStatus) {
		_newStatus = newStatus;
	}

	private int _id;
	private String _role;
	private String _initialStatus;
	private String _action;
	private String _newStatus;

}