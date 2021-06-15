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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.YakeenDataSaveServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class YakeenDataSaveSoap implements Serializable {

	public static YakeenDataSaveSoap toSoapModel(YakeenDataSave model) {
		YakeenDataSaveSoap soapModel = new YakeenDataSaveSoap();

		soapModel.setId(model.getId());
		soapModel.setOldId(model.getOldId());
		soapModel.setSequenceNumber(model.getSequenceNumber());
		soapModel.setDob(model.getDob());
		soapModel.setServiceName(model.getServiceName());
		soapModel.setCallingDate(model.getCallingDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setServiceOutput(model.getServiceOutput());
		soapModel.setServiceCalledDate(model.getServiceCalledDate());
		soapModel.setServiceErrorMessage(model.getServiceErrorMessage());

		return soapModel;
	}

	public static YakeenDataSaveSoap[] toSoapModels(YakeenDataSave[] models) {
		YakeenDataSaveSoap[] soapModels = new YakeenDataSaveSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static YakeenDataSaveSoap[][] toSoapModels(
		YakeenDataSave[][] models) {

		YakeenDataSaveSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new YakeenDataSaveSoap[models.length][models[0].length];
		}
		else {
			soapModels = new YakeenDataSaveSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static YakeenDataSaveSoap[] toSoapModels(
		List<YakeenDataSave> models) {

		List<YakeenDataSaveSoap> soapModels = new ArrayList<YakeenDataSaveSoap>(
			models.size());

		for (YakeenDataSave model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new YakeenDataSaveSoap[soapModels.size()]);
	}

	public YakeenDataSaveSoap() {
	}

	public String getPrimaryKey() {
		return _Id;
	}

	public void setPrimaryKey(String pk) {
		setId(pk);
	}

	public String getId() {
		return _Id;
	}

	public void setId(String Id) {
		_Id = Id;
	}

	public String getOldId() {
		return _OldId;
	}

	public void setOldId(String OldId) {
		_OldId = OldId;
	}

	public String getSequenceNumber() {
		return _sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		_sequenceNumber = sequenceNumber;
	}

	public Date getDob() {
		return _dob;
	}

	public void setDob(Date dob) {
		_dob = dob;
	}

	public String getServiceName() {
		return _serviceName;
	}

	public void setServiceName(String serviceName) {
		_serviceName = serviceName;
	}

	public Date getCallingDate() {
		return _callingDate;
	}

	public void setCallingDate(Date callingDate) {
		_callingDate = callingDate;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getServiceOutput() {
		return _serviceOutput;
	}

	public void setServiceOutput(String serviceOutput) {
		_serviceOutput = serviceOutput;
	}

	public Date getServiceCalledDate() {
		return _serviceCalledDate;
	}

	public void setServiceCalledDate(Date serviceCalledDate) {
		_serviceCalledDate = serviceCalledDate;
	}

	public String getServiceErrorMessage() {
		return _serviceErrorMessage;
	}

	public void setServiceErrorMessage(String serviceErrorMessage) {
		_serviceErrorMessage = serviceErrorMessage;
	}

	private String _Id;
	private String _OldId;
	private String _sequenceNumber;
	private Date _dob;
	private String _serviceName;
	private Date _callingDate;
	private String _status;
	private String _serviceOutput;
	private Date _serviceCalledDate;
	private String _serviceErrorMessage;

}