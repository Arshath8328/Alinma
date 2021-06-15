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

import com.ejada.atmc.acl.db.service.persistence.QuotationsNajmDetailsPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.QuotationsNajmDetailsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class QuotationsNajmDetailsSoap implements Serializable {

	public static QuotationsNajmDetailsSoap toSoapModel(
		QuotationsNajmDetails model) {

		QuotationsNajmDetailsSoap soapModel = new QuotationsNajmDetailsSoap();

		soapModel.setCaseNumber(model.getCaseNumber());
		soapModel.setQuotationId(model.getQuotationId());
		soapModel.setAccidentDate(model.getAccidentDate());
		soapModel.setLiability(model.getLiability());
		soapModel.setDriverAge(model.getDriverAge());
		soapModel.setCarModel(model.getCarModel());
		soapModel.setCarType(model.getCarType());
		soapModel.setDriverID(model.getDriverID());
		soapModel.setSequenceNumber(model.getSequenceNumber());
		soapModel.setOwnerID(model.getOwnerID());
		soapModel.setEstimatedAmount(model.getEstimatedAmount());
		soapModel.setDamageParts(model.getDamageParts());
		soapModel.setCauseOfAccident(model.getCauseOfAccident());

		return soapModel;
	}

	public static QuotationsNajmDetailsSoap[] toSoapModels(
		QuotationsNajmDetails[] models) {

		QuotationsNajmDetailsSoap[] soapModels =
			new QuotationsNajmDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuotationsNajmDetailsSoap[][] toSoapModels(
		QuotationsNajmDetails[][] models) {

		QuotationsNajmDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new QuotationsNajmDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuotationsNajmDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuotationsNajmDetailsSoap[] toSoapModels(
		List<QuotationsNajmDetails> models) {

		List<QuotationsNajmDetailsSoap> soapModels =
			new ArrayList<QuotationsNajmDetailsSoap>(models.size());

		for (QuotationsNajmDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new QuotationsNajmDetailsSoap[soapModels.size()]);
	}

	public QuotationsNajmDetailsSoap() {
	}

	public QuotationsNajmDetailsPK getPrimaryKey() {
		return new QuotationsNajmDetailsPK(_caseNumber, _quotationId);
	}

	public void setPrimaryKey(QuotationsNajmDetailsPK pk) {
		setCaseNumber(pk.caseNumber);
		setQuotationId(pk.quotationId);
	}

	public String getCaseNumber() {
		return _caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		_caseNumber = caseNumber;
	}

	public long getQuotationId() {
		return _quotationId;
	}

	public void setQuotationId(long quotationId) {
		_quotationId = quotationId;
	}

	public String getAccidentDate() {
		return _accidentDate;
	}

	public void setAccidentDate(String accidentDate) {
		_accidentDate = accidentDate;
	}

	public String getLiability() {
		return _liability;
	}

	public void setLiability(String liability) {
		_liability = liability;
	}

	public String getDriverAge() {
		return _driverAge;
	}

	public void setDriverAge(String driverAge) {
		_driverAge = driverAge;
	}

	public String getCarModel() {
		return _carModel;
	}

	public void setCarModel(String carModel) {
		_carModel = carModel;
	}

	public String getCarType() {
		return _carType;
	}

	public void setCarType(String carType) {
		_carType = carType;
	}

	public String getDriverID() {
		return _driverID;
	}

	public void setDriverID(String driverID) {
		_driverID = driverID;
	}

	public String getSequenceNumber() {
		return _sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		_sequenceNumber = sequenceNumber;
	}

	public String getOwnerID() {
		return _ownerID;
	}

	public void setOwnerID(String ownerID) {
		_ownerID = ownerID;
	}

	public String getEstimatedAmount() {
		return _estimatedAmount;
	}

	public void setEstimatedAmount(String estimatedAmount) {
		_estimatedAmount = estimatedAmount;
	}

	public String getDamageParts() {
		return _damageParts;
	}

	public void setDamageParts(String damageParts) {
		_damageParts = damageParts;
	}

	public String getCauseOfAccident() {
		return _causeOfAccident;
	}

	public void setCauseOfAccident(String causeOfAccident) {
		_causeOfAccident = causeOfAccident;
	}

	private String _caseNumber;
	private long _quotationId;
	private String _accidentDate;
	private String _liability;
	private String _driverAge;
	private String _carModel;
	private String _carType;
	private String _driverID;
	private String _sequenceNumber;
	private String _ownerID;
	private String _estimatedAmount;
	private String _damageParts;
	private String _causeOfAccident;

}