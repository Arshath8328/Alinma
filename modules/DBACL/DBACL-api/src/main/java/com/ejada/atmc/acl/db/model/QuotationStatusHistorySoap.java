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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.QuotationStatusHistoryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class QuotationStatusHistorySoap implements Serializable {

	public static QuotationStatusHistorySoap toSoapModel(
		QuotationStatusHistory model) {

		QuotationStatusHistorySoap soapModel = new QuotationStatusHistorySoap();

		soapModel.setHistoryId(model.getHistoryId());
		soapModel.setQuotationId(model.getQuotationId());
		soapModel.setDateTime(model.getDateTime());
		soapModel.setUserName(model.getUserName());
		soapModel.setStatus(model.getStatus());
		soapModel.setReason(model.getReason());

		return soapModel;
	}

	public static QuotationStatusHistorySoap[] toSoapModels(
		QuotationStatusHistory[] models) {

		QuotationStatusHistorySoap[] soapModels =
			new QuotationStatusHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuotationStatusHistorySoap[][] toSoapModels(
		QuotationStatusHistory[][] models) {

		QuotationStatusHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new QuotationStatusHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuotationStatusHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuotationStatusHistorySoap[] toSoapModels(
		List<QuotationStatusHistory> models) {

		List<QuotationStatusHistorySoap> soapModels =
			new ArrayList<QuotationStatusHistorySoap>(models.size());

		for (QuotationStatusHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new QuotationStatusHistorySoap[soapModels.size()]);
	}

	public QuotationStatusHistorySoap() {
	}

	public long getPrimaryKey() {
		return _historyId;
	}

	public void setPrimaryKey(long pk) {
		setHistoryId(pk);
	}

	public long getHistoryId() {
		return _historyId;
	}

	public void setHistoryId(long historyId) {
		_historyId = historyId;
	}

	public long getQuotationId() {
		return _quotationId;
	}

	public void setQuotationId(long quotationId) {
		_quotationId = quotationId;
	}

	public Date getDateTime() {
		return _dateTime;
	}

	public void setDateTime(Date dateTime) {
		_dateTime = dateTime;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getReason() {
		return _reason;
	}

	public void setReason(String reason) {
		_reason = reason;
	}

	private long _historyId;
	private long _quotationId;
	private Date _dateTime;
	private String _userName;
	private String _status;
	private String _reason;

}