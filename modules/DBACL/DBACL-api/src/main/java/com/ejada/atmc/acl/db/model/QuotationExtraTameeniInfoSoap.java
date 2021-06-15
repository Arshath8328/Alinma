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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.QuotationExtraTameeniInfoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class QuotationExtraTameeniInfoSoap implements Serializable {

	public static QuotationExtraTameeniInfoSoap toSoapModel(
		QuotationExtraTameeniInfo model) {

		QuotationExtraTameeniInfoSoap soapModel =
			new QuotationExtraTameeniInfoSoap();

		soapModel.setQuotationId(model.getQuotationId());
		soapModel.setInsuredFirstName(model.getInsuredFirstName());
		soapModel.setInsuredMiddleName(model.getInsuredMiddleName());
		soapModel.setInsuredLastName(model.getInsuredLastName());
		soapModel.setIsDriverDisabled(model.isIsDriverDisabled());
		soapModel.setVehicleMakeCodeTameeni(model.getVehicleMakeCodeTameeni());
		soapModel.setCoverAgeLimit(model.getCoverAgeLimit());
		soapModel.setInsuredNameLang(model.getInsuredNameLang());
		soapModel.setPolicyTitleId(model.getPolicyTitleId());
		soapModel.setIsRenewal(model.isIsRenewal());

		return soapModel;
	}

	public static QuotationExtraTameeniInfoSoap[] toSoapModels(
		QuotationExtraTameeniInfo[] models) {

		QuotationExtraTameeniInfoSoap[] soapModels =
			new QuotationExtraTameeniInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuotationExtraTameeniInfoSoap[][] toSoapModels(
		QuotationExtraTameeniInfo[][] models) {

		QuotationExtraTameeniInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new QuotationExtraTameeniInfoSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new QuotationExtraTameeniInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuotationExtraTameeniInfoSoap[] toSoapModels(
		List<QuotationExtraTameeniInfo> models) {

		List<QuotationExtraTameeniInfoSoap> soapModels =
			new ArrayList<QuotationExtraTameeniInfoSoap>(models.size());

		for (QuotationExtraTameeniInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new QuotationExtraTameeniInfoSoap[soapModels.size()]);
	}

	public QuotationExtraTameeniInfoSoap() {
	}

	public long getPrimaryKey() {
		return _quotationId;
	}

	public void setPrimaryKey(long pk) {
		setQuotationId(pk);
	}

	public long getQuotationId() {
		return _quotationId;
	}

	public void setQuotationId(long quotationId) {
		_quotationId = quotationId;
	}

	public String getInsuredFirstName() {
		return _insuredFirstName;
	}

	public void setInsuredFirstName(String insuredFirstName) {
		_insuredFirstName = insuredFirstName;
	}

	public String getInsuredMiddleName() {
		return _insuredMiddleName;
	}

	public void setInsuredMiddleName(String insuredMiddleName) {
		_insuredMiddleName = insuredMiddleName;
	}

	public String getInsuredLastName() {
		return _insuredLastName;
	}

	public void setInsuredLastName(String insuredLastName) {
		_insuredLastName = insuredLastName;
	}

	public boolean getIsDriverDisabled() {
		return _isDriverDisabled;
	}

	public boolean isIsDriverDisabled() {
		return _isDriverDisabled;
	}

	public void setIsDriverDisabled(boolean isDriverDisabled) {
		_isDriverDisabled = isDriverDisabled;
	}

	public long getVehicleMakeCodeTameeni() {
		return _vehicleMakeCodeTameeni;
	}

	public void setVehicleMakeCodeTameeni(long vehicleMakeCodeTameeni) {
		_vehicleMakeCodeTameeni = vehicleMakeCodeTameeni;
	}

	public long getCoverAgeLimit() {
		return _coverAgeLimit;
	}

	public void setCoverAgeLimit(long coverAgeLimit) {
		_coverAgeLimit = coverAgeLimit;
	}

	public String getInsuredNameLang() {
		return _insuredNameLang;
	}

	public void setInsuredNameLang(String insuredNameLang) {
		_insuredNameLang = insuredNameLang;
	}

	public String getPolicyTitleId() {
		return _policyTitleId;
	}

	public void setPolicyTitleId(String policyTitleId) {
		_policyTitleId = policyTitleId;
	}

	public boolean getIsRenewal() {
		return _isRenewal;
	}

	public boolean isIsRenewal() {
		return _isRenewal;
	}

	public void setIsRenewal(boolean isRenewal) {
		_isRenewal = isRenewal;
	}

	private long _quotationId;
	private String _insuredFirstName;
	private String _insuredMiddleName;
	private String _insuredLastName;
	private boolean _isDriverDisabled;
	private long _vehicleMakeCodeTameeni;
	private long _coverAgeLimit;
	private String _insuredNameLang;
	private String _policyTitleId;
	private boolean _isRenewal;

}