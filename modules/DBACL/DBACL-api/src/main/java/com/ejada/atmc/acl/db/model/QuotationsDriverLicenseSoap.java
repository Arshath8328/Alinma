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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.QuotationsDriverLicenseServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class QuotationsDriverLicenseSoap implements Serializable {

	public static QuotationsDriverLicenseSoap toSoapModel(
		QuotationsDriverLicense model) {

		QuotationsDriverLicenseSoap soapModel =
			new QuotationsDriverLicenseSoap();

		soapModel.setLicenseId(model.getLicenseId());
		soapModel.setDriverId(model.getDriverId());
		soapModel.setQuotationId(model.getQuotationId());
		soapModel.setLicCountry(model.getLicCountry());
		soapModel.setLicType(model.getLicType());
		soapModel.setLicYrs(model.getLicYrs());

		return soapModel;
	}

	public static QuotationsDriverLicenseSoap[] toSoapModels(
		QuotationsDriverLicense[] models) {

		QuotationsDriverLicenseSoap[] soapModels =
			new QuotationsDriverLicenseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuotationsDriverLicenseSoap[][] toSoapModels(
		QuotationsDriverLicense[][] models) {

		QuotationsDriverLicenseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new QuotationsDriverLicenseSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new QuotationsDriverLicenseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuotationsDriverLicenseSoap[] toSoapModels(
		List<QuotationsDriverLicense> models) {

		List<QuotationsDriverLicenseSoap> soapModels =
			new ArrayList<QuotationsDriverLicenseSoap>(models.size());

		for (QuotationsDriverLicense model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new QuotationsDriverLicenseSoap[soapModels.size()]);
	}

	public QuotationsDriverLicenseSoap() {
	}

	public long getPrimaryKey() {
		return _licenseId;
	}

	public void setPrimaryKey(long pk) {
		setLicenseId(pk);
	}

	public long getLicenseId() {
		return _licenseId;
	}

	public void setLicenseId(long licenseId) {
		_licenseId = licenseId;
	}

	public long getDriverId() {
		return _driverId;
	}

	public void setDriverId(long driverId) {
		_driverId = driverId;
	}

	public long getQuotationId() {
		return _quotationId;
	}

	public void setQuotationId(long quotationId) {
		_quotationId = quotationId;
	}

	public String getLicCountry() {
		return _LicCountry;
	}

	public void setLicCountry(String LicCountry) {
		_LicCountry = LicCountry;
	}

	public String getLicType() {
		return _LicType;
	}

	public void setLicType(String LicType) {
		_LicType = LicType;
	}

	public int getLicYrs() {
		return _LicYrs;
	}

	public void setLicYrs(int LicYrs) {
		_LicYrs = LicYrs;
	}

	private long _licenseId;
	private long _driverId;
	private long _quotationId;
	private String _LicCountry;
	private String _LicType;
	private int _LicYrs;

}