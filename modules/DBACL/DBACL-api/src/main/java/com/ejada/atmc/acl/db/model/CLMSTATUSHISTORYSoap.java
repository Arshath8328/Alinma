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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.CLMSTATUSHISTORYServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CLMSTATUSHISTORYSoap implements Serializable {

	public static CLMSTATUSHISTORYSoap toSoapModel(CLMSTATUSHISTORY model) {
		CLMSTATUSHISTORYSoap soapModel = new CLMSTATUSHISTORYSoap();

		soapModel.setId(model.getId());
		soapModel.setRefNo(model.getRefNo());
		soapModel.setDate(model.getDate());
		soapModel.setUserName(model.getUserName());
		soapModel.setClaimStatus(model.getClaimStatus());
		soapModel.setReason(model.getReason());

		return soapModel;
	}

	public static CLMSTATUSHISTORYSoap[] toSoapModels(
		CLMSTATUSHISTORY[] models) {

		CLMSTATUSHISTORYSoap[] soapModels =
			new CLMSTATUSHISTORYSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CLMSTATUSHISTORYSoap[][] toSoapModels(
		CLMSTATUSHISTORY[][] models) {

		CLMSTATUSHISTORYSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CLMSTATUSHISTORYSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CLMSTATUSHISTORYSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CLMSTATUSHISTORYSoap[] toSoapModels(
		List<CLMSTATUSHISTORY> models) {

		List<CLMSTATUSHISTORYSoap> soapModels =
			new ArrayList<CLMSTATUSHISTORYSoap>(models.size());

		for (CLMSTATUSHISTORY model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CLMSTATUSHISTORYSoap[soapModels.size()]);
	}

	public CLMSTATUSHISTORYSoap() {
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

	public String getRefNo() {
		return _RefNo;
	}

	public void setRefNo(String RefNo) {
		_RefNo = RefNo;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public String getClaimStatus() {
		return _claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		_claimStatus = claimStatus;
	}

	public String getReason() {
		return _reason;
	}

	public void setReason(String reason) {
		_reason = reason;
	}

	private int _id;
	private String _RefNo;
	private Date _date;
	private String _userName;
	private String _claimStatus;
	private String _reason;

}