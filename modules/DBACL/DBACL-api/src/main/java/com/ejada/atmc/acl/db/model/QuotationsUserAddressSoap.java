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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.QuotationsUserAddressServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class QuotationsUserAddressSoap implements Serializable {

	public static QuotationsUserAddressSoap toSoapModel(
		QuotationsUserAddress model) {

		QuotationsUserAddressSoap soapModel = new QuotationsUserAddressSoap();

		soapModel.setUserAddressId(model.getUserAddressId());
		soapModel.setDriverId(model.getDriverId());
		soapModel.setQuotationId(model.getQuotationId());
		soapModel.setBuildNo(model.getBuildNo());
		soapModel.setZipCode(model.getZipCode());
		soapModel.setAddNo(model.getAddNo());
		soapModel.setStNameEn(model.getStNameEn());
		soapModel.setStNameAr(model.getStNameAr());
		soapModel.setDistrictEn(model.getDistrictEn());
		soapModel.setDistrictAr(model.getDistrictAr());
		soapModel.setCityEn(model.getCityEn());
		soapModel.setCityAr(model.getCityAr());
		soapModel.setIsNatAddress(model.isIsNatAddress());

		return soapModel;
	}

	public static QuotationsUserAddressSoap[] toSoapModels(
		QuotationsUserAddress[] models) {

		QuotationsUserAddressSoap[] soapModels =
			new QuotationsUserAddressSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuotationsUserAddressSoap[][] toSoapModels(
		QuotationsUserAddress[][] models) {

		QuotationsUserAddressSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new QuotationsUserAddressSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuotationsUserAddressSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuotationsUserAddressSoap[] toSoapModels(
		List<QuotationsUserAddress> models) {

		List<QuotationsUserAddressSoap> soapModels =
			new ArrayList<QuotationsUserAddressSoap>(models.size());

		for (QuotationsUserAddress model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new QuotationsUserAddressSoap[soapModels.size()]);
	}

	public QuotationsUserAddressSoap() {
	}

	public long getPrimaryKey() {
		return _userAddressId;
	}

	public void setPrimaryKey(long pk) {
		setUserAddressId(pk);
	}

	public long getUserAddressId() {
		return _userAddressId;
	}

	public void setUserAddressId(long userAddressId) {
		_userAddressId = userAddressId;
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

	public String getBuildNo() {
		return _buildNo;
	}

	public void setBuildNo(String buildNo) {
		_buildNo = buildNo;
	}

	public String getZipCode() {
		return _zipCode;
	}

	public void setZipCode(String zipCode) {
		_zipCode = zipCode;
	}

	public String getAddNo() {
		return _addNo;
	}

	public void setAddNo(String addNo) {
		_addNo = addNo;
	}

	public String getStNameEn() {
		return _stNameEn;
	}

	public void setStNameEn(String stNameEn) {
		_stNameEn = stNameEn;
	}

	public String getStNameAr() {
		return _stNameAr;
	}

	public void setStNameAr(String stNameAr) {
		_stNameAr = stNameAr;
	}

	public String getDistrictEn() {
		return _districtEn;
	}

	public void setDistrictEn(String districtEn) {
		_districtEn = districtEn;
	}

	public String getDistrictAr() {
		return _districtAr;
	}

	public void setDistrictAr(String districtAr) {
		_districtAr = districtAr;
	}

	public String getCityEn() {
		return _cityEn;
	}

	public void setCityEn(String cityEn) {
		_cityEn = cityEn;
	}

	public String getCityAr() {
		return _cityAr;
	}

	public void setCityAr(String cityAr) {
		_cityAr = cityAr;
	}

	public boolean getIsNatAddress() {
		return _isNatAddress;
	}

	public boolean isIsNatAddress() {
		return _isNatAddress;
	}

	public void setIsNatAddress(boolean isNatAddress) {
		_isNatAddress = isNatAddress;
	}

	private long _userAddressId;
	private long _driverId;
	private long _quotationId;
	private String _buildNo;
	private String _zipCode;
	private String _addNo;
	private String _stNameEn;
	private String _stNameAr;
	private String _districtEn;
	private String _districtAr;
	private String _cityEn;
	private String _cityAr;
	private boolean _isNatAddress;

}