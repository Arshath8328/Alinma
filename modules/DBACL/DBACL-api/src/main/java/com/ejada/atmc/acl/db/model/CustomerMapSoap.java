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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.CustomerMapServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CustomerMapSoap implements Serializable {

	public static CustomerMapSoap toSoapModel(CustomerMap model) {
		CustomerMapSoap soapModel = new CustomerMapSoap();

		soapModel.setCivilId(model.getCivilId());
		soapModel.setEffFromDate(model.getEffFromDate());
		soapModel.setCrDare(model.getCrDare());
		soapModel.setCrUid(model.getCrUid());
		soapModel.setUpdateDt(model.getUpdateDt());
		soapModel.setUpdUid(model.getUpdUid());
		soapModel.setName(model.getName());
		soapModel.setNameAr(model.getNameAr());
		soapModel.setCustType(model.getCustType());
		soapModel.setCustCatg(model.getCustCatg());
		soapModel.setCustCatgDesc(model.getCustCatgDesc());
		soapModel.setDob(model.getDob());
		soapModel.setMobileNo(model.getMobileNo());
		soapModel.setPremiaCode(model.getPremiaCode());
		soapModel.setMedCode(model.getMedCode());
		soapModel.setIlasCode(model.getIlasCode());
		soapModel.setGlasCode(model.getGlasCode());
		soapModel.setNationality(model.getNationality());
		soapModel.setNameShort(model.getNameShort());
		soapModel.setVersion(model.getVersion());
		soapModel.setVip(model.getVip());
		soapModel.setPhoneNo(model.getPhoneNo());
		soapModel.setAddress(model.getAddress());
		soapModel.setEmail(model.getEmail());
		soapModel.setRefCode(model.getRefCode());

		return soapModel;
	}

	public static CustomerMapSoap[] toSoapModels(CustomerMap[] models) {
		CustomerMapSoap[] soapModels = new CustomerMapSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CustomerMapSoap[][] toSoapModels(CustomerMap[][] models) {
		CustomerMapSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CustomerMapSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CustomerMapSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CustomerMapSoap[] toSoapModels(List<CustomerMap> models) {
		List<CustomerMapSoap> soapModels = new ArrayList<CustomerMapSoap>(
			models.size());

		for (CustomerMap model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CustomerMapSoap[soapModels.size()]);
	}

	public CustomerMapSoap() {
	}

	public String getPrimaryKey() {
		return _refCode;
	}

	public void setPrimaryKey(String pk) {
		setRefCode(pk);
	}

	public String getCivilId() {
		return _civilId;
	}

	public void setCivilId(String civilId) {
		_civilId = civilId;
	}

	public Date getEffFromDate() {
		return _effFromDate;
	}

	public void setEffFromDate(Date effFromDate) {
		_effFromDate = effFromDate;
	}

	public Date getCrDare() {
		return _crDare;
	}

	public void setCrDare(Date crDare) {
		_crDare = crDare;
	}

	public String getCrUid() {
		return _crUid;
	}

	public void setCrUid(String crUid) {
		_crUid = crUid;
	}

	public String getUpdateDt() {
		return _updateDt;
	}

	public void setUpdateDt(String updateDt) {
		_updateDt = updateDt;
	}

	public String getUpdUid() {
		return _updUid;
	}

	public void setUpdUid(String updUid) {
		_updUid = updUid;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getNameAr() {
		return _nameAr;
	}

	public void setNameAr(String nameAr) {
		_nameAr = nameAr;
	}

	public String getCustType() {
		return _custType;
	}

	public void setCustType(String custType) {
		_custType = custType;
	}

	public String getCustCatg() {
		return _custCatg;
	}

	public void setCustCatg(String custCatg) {
		_custCatg = custCatg;
	}

	public String getCustCatgDesc() {
		return _custCatgDesc;
	}

	public void setCustCatgDesc(String custCatgDesc) {
		_custCatgDesc = custCatgDesc;
	}

	public Date getDob() {
		return _dob;
	}

	public void setDob(Date dob) {
		_dob = dob;
	}

	public String getMobileNo() {
		return _mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		_mobileNo = mobileNo;
	}

	public String getPremiaCode() {
		return _premiaCode;
	}

	public void setPremiaCode(String premiaCode) {
		_premiaCode = premiaCode;
	}

	public String getMedCode() {
		return _medCode;
	}

	public void setMedCode(String medCode) {
		_medCode = medCode;
	}

	public String getIlasCode() {
		return _ilasCode;
	}

	public void setIlasCode(String ilasCode) {
		_ilasCode = ilasCode;
	}

	public String getGlasCode() {
		return _glasCode;
	}

	public void setGlasCode(String glasCode) {
		_glasCode = glasCode;
	}

	public String getNationality() {
		return _nationality;
	}

	public void setNationality(String nationality) {
		_nationality = nationality;
	}

	public String getNameShort() {
		return _nameShort;
	}

	public void setNameShort(String nameShort) {
		_nameShort = nameShort;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String version) {
		_version = version;
	}

	public String getVip() {
		return _vip;
	}

	public void setVip(String vip) {
		_vip = vip;
	}

	public String getPhoneNo() {
		return _phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		_phoneNo = phoneNo;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getRefCode() {
		return _refCode;
	}

	public void setRefCode(String refCode) {
		_refCode = refCode;
	}

	private String _civilId;
	private Date _effFromDate;
	private Date _crDare;
	private String _crUid;
	private String _updateDt;
	private String _updUid;
	private String _name;
	private String _nameAr;
	private String _custType;
	private String _custCatg;
	private String _custCatgDesc;
	private Date _dob;
	private String _mobileNo;
	private String _premiaCode;
	private String _medCode;
	private String _ilasCode;
	private String _glasCode;
	private String _nationality;
	private String _nameShort;
	private String _version;
	private String _vip;
	private String _phoneNo;
	private String _address;
	private String _email;
	private String _refCode;

}