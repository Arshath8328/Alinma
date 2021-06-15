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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.CustomerServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CustomerSoap implements Serializable {

	public static CustomerSoap toSoapModel(Customer model) {
		CustomerSoap soapModel = new CustomerSoap();

		soapModel.setId(model.getId());
		soapModel.setNameEn(model.getNameEn());
		soapModel.setNameAr(model.getNameAr());
		soapModel.setPhone(model.getPhone());
		soapModel.setEmail(model.getEmail());
		soapModel.setNationality(model.getNationality());
		soapModel.setCustomerBirthDay(model.getCustomerBirthDay());
		soapModel.setGender(model.getGender());
		soapModel.setBuildingNo(model.getBuildingNo());
		soapModel.setUnitNo(model.getUnitNo());
		soapModel.setStreet(model.getStreet());
		soapModel.setDistrict(model.getDistrict());
		soapModel.setZipCode(model.getZipCode());
		soapModel.setAdditNo(model.getAdditNo());
		soapModel.setCity(model.getCity());

		return soapModel;
	}

	public static CustomerSoap[] toSoapModels(Customer[] models) {
		CustomerSoap[] soapModels = new CustomerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CustomerSoap[][] toSoapModels(Customer[][] models) {
		CustomerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CustomerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CustomerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CustomerSoap[] toSoapModels(List<Customer> models) {
		List<CustomerSoap> soapModels = new ArrayList<CustomerSoap>(
			models.size());

		for (Customer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CustomerSoap[soapModels.size()]);
	}

	public CustomerSoap() {
	}

	public String getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(String pk) {
		setId(pk);
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		_id = id;
	}

	public String getNameEn() {
		return _nameEn;
	}

	public void setNameEn(String nameEn) {
		_nameEn = nameEn;
	}

	public String getNameAr() {
		return _nameAr;
	}

	public void setNameAr(String nameAr) {
		_nameAr = nameAr;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getNationality() {
		return _nationality;
	}

	public void setNationality(String nationality) {
		_nationality = nationality;
	}

	public Date getCustomerBirthDay() {
		return _customerBirthDay;
	}

	public void setCustomerBirthDay(Date customerBirthDay) {
		_customerBirthDay = customerBirthDay;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public String getBuildingNo() {
		return _buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		_buildingNo = buildingNo;
	}

	public String getUnitNo() {
		return _unitNo;
	}

	public void setUnitNo(String unitNo) {
		_unitNo = unitNo;
	}

	public String getStreet() {
		return _street;
	}

	public void setStreet(String street) {
		_street = street;
	}

	public String getDistrict() {
		return _district;
	}

	public void setDistrict(String district) {
		_district = district;
	}

	public String getZipCode() {
		return _zipCode;
	}

	public void setZipCode(String zipCode) {
		_zipCode = zipCode;
	}

	public String getAdditNo() {
		return _additNo;
	}

	public void setAdditNo(String additNo) {
		_additNo = additNo;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	private String _id;
	private String _nameEn;
	private String _nameAr;
	private String _phone;
	private String _email;
	private String _nationality;
	private Date _customerBirthDay;
	private String _gender;
	private String _buildingNo;
	private String _unitNo;
	private String _street;
	private String _district;
	private String _zipCode;
	private String _additNo;
	private String _city;

}