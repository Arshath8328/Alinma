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

import com.ejada.atmc.acl.db.service.persistence.CLMNajmPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.CLMNajmServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CLMNajmSoap implements Serializable {

	public static CLMNajmSoap toSoapModel(CLMNajm model) {
		CLMNajmSoap soapModel = new CLMNajmSoap();

		soapModel.setCaseNo(model.getCaseNo());
		soapModel.setCipiId(model.getCipiId());
		soapModel.setCallDt(model.getCallDt());
		soapModel.setCity(model.getCity());
		soapModel.setName(model.getName());
		soapModel.setPhoneNo(model.getPhoneNo());
		soapModel.setAge(model.getAge());
		soapModel.setNationality(model.getNationality());
		soapModel.setPlateNo(model.getPlateNo());
		soapModel.setLiabiltiyPerc(model.getLiabiltiyPerc());
		soapModel.setLiabiltiyAmt(model.getLiabiltiyAmt());
		soapModel.setCustomId(model.getCustomId());
		soapModel.setSeqNo(model.getSeqNo());
		soapModel.setEnglishName(model.getEnglishName());
		soapModel.setPolNo(model.getPolNo());
		soapModel.setNajmPlateNo(model.getNajmPlateNo());
		soapModel.setNajmChassisNo(model.getNajmChassisNo());
		soapModel.setNajmVEHNo(model.getNajmVEHNo());
		soapModel.setCauseAr(model.getCauseAr());
		soapModel.setCauseEn(model.getCauseEn());

		return soapModel;
	}

	public static CLMNajmSoap[] toSoapModels(CLMNajm[] models) {
		CLMNajmSoap[] soapModels = new CLMNajmSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CLMNajmSoap[][] toSoapModels(CLMNajm[][] models) {
		CLMNajmSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CLMNajmSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CLMNajmSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CLMNajmSoap[] toSoapModels(List<CLMNajm> models) {
		List<CLMNajmSoap> soapModels = new ArrayList<CLMNajmSoap>(
			models.size());

		for (CLMNajm model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CLMNajmSoap[soapModels.size()]);
	}

	public CLMNajmSoap() {
	}

	public CLMNajmPK getPrimaryKey() {
		return new CLMNajmPK(_caseNo, _cipiId);
	}

	public void setPrimaryKey(CLMNajmPK pk) {
		setCaseNo(pk.caseNo);
		setCipiId(pk.cipiId);
	}

	public String getCaseNo() {
		return _caseNo;
	}

	public void setCaseNo(String caseNo) {
		_caseNo = caseNo;
	}

	public String getCipiId() {
		return _cipiId;
	}

	public void setCipiId(String cipiId) {
		_cipiId = cipiId;
	}

	public String getCallDt() {
		return _callDt;
	}

	public void setCallDt(String callDt) {
		_callDt = callDt;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getPhoneNo() {
		return _phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		_phoneNo = phoneNo;
	}

	public String getAge() {
		return _age;
	}

	public void setAge(String age) {
		_age = age;
	}

	public String getNationality() {
		return _nationality;
	}

	public void setNationality(String nationality) {
		_nationality = nationality;
	}

	public String getPlateNo() {
		return _plateNo;
	}

	public void setPlateNo(String plateNo) {
		_plateNo = plateNo;
	}

	public String getLiabiltiyPerc() {
		return _liabiltiyPerc;
	}

	public void setLiabiltiyPerc(String liabiltiyPerc) {
		_liabiltiyPerc = liabiltiyPerc;
	}

	public String getLiabiltiyAmt() {
		return _liabiltiyAmt;
	}

	public void setLiabiltiyAmt(String liabiltiyAmt) {
		_liabiltiyAmt = liabiltiyAmt;
	}

	public String getCustomId() {
		return _customId;
	}

	public void setCustomId(String customId) {
		_customId = customId;
	}

	public String getSeqNo() {
		return _seqNo;
	}

	public void setSeqNo(String seqNo) {
		_seqNo = seqNo;
	}

	public String getEnglishName() {
		return _englishName;
	}

	public void setEnglishName(String englishName) {
		_englishName = englishName;
	}

	public String getPolNo() {
		return _polNo;
	}

	public void setPolNo(String polNo) {
		_polNo = polNo;
	}

	public String getNajmPlateNo() {
		return _najmPlateNo;
	}

	public void setNajmPlateNo(String najmPlateNo) {
		_najmPlateNo = najmPlateNo;
	}

	public String getNajmChassisNo() {
		return _najmChassisNo;
	}

	public void setNajmChassisNo(String najmChassisNo) {
		_najmChassisNo = najmChassisNo;
	}

	public String getNajmVEHNo() {
		return _najmVEHNo;
	}

	public void setNajmVEHNo(String najmVEHNo) {
		_najmVEHNo = najmVEHNo;
	}

	public String getCauseAr() {
		return _causeAr;
	}

	public void setCauseAr(String causeAr) {
		_causeAr = causeAr;
	}

	public String getCauseEn() {
		return _causeEn;
	}

	public void setCauseEn(String causeEn) {
		_causeEn = causeEn;
	}

	private String _caseNo;
	private String _cipiId;
	private String _callDt;
	private String _city;
	private String _name;
	private String _phoneNo;
	private String _age;
	private String _nationality;
	private String _plateNo;
	private String _liabiltiyPerc;
	private String _liabiltiyAmt;
	private String _customId;
	private String _seqNo;
	private String _englishName;
	private String _polNo;
	private String _najmPlateNo;
	private String _najmChassisNo;
	private String _najmVEHNo;
	private String _causeAr;
	private String _causeEn;

}