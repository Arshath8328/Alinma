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

import java.sql.Blob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.QuotationDriverseEndorsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class QuotationDriverseEndorsSoap implements Serializable {

	public static QuotationDriverseEndorsSoap toSoapModel(
		QuotationDriverseEndors model) {

		QuotationDriverseEndorsSoap soapModel =
			new QuotationDriverseEndorsSoap();

		soapModel.setAddDriverId(model.getAddDriverId());
		soapModel.setQuotationId(model.getQuotationId());
		soapModel.setPolicyNumber(model.getPolicyNumber());
		soapModel.setDriverDob(model.getDriverDob());
		soapModel.setDriverDobH(model.getDriverDobH());
		soapModel.setDriverGender(model.getDriverGender());
		soapModel.setDriverId(model.getDriverId());
		soapModel.setDriverIdType(model.getDriverIdType());
		soapModel.setDriverName(model.getDriverName());
		soapModel.setDriverNationality(model.getDriverNationality());
		soapModel.setDriverOccup(model.getDriverOccup());
		soapModel.setIsDriverUnder21(model.isIsDriverUnder21());
		soapModel.setDriverEdu(model.getDriverEdu());
		soapModel.setDriverNoChild(model.getDriverNoChild());
		soapModel.setDriverMaritalStatus(model.getDriverMaritalStatus());
		soapModel.setDriverNOFault(model.getDriverNOFault());
		soapModel.setDriverNOClaim(model.getDriverNOClaim());
		soapModel.setDriverConvictions(model.getDriverConvictions());
		soapModel.setDriverMedConds(model.getDriverMedConds());
		soapModel.setNcdYears(model.getNcdYears());
		soapModel.setInsuredRelation(model.getInsuredRelation());
		soapModel.setInsuredRelationProof(model.getInsuredRelationProof());
		soapModel.setInsuredRelationProofFileName(
			model.getInsuredRelationProofFileName());
		soapModel.setStatus(model.getStatus());
		soapModel.setRequestedDate(model.getRequestedDate());
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

	public static QuotationDriverseEndorsSoap[] toSoapModels(
		QuotationDriverseEndors[] models) {

		QuotationDriverseEndorsSoap[] soapModels =
			new QuotationDriverseEndorsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuotationDriverseEndorsSoap[][] toSoapModels(
		QuotationDriverseEndors[][] models) {

		QuotationDriverseEndorsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new QuotationDriverseEndorsSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new QuotationDriverseEndorsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuotationDriverseEndorsSoap[] toSoapModels(
		List<QuotationDriverseEndors> models) {

		List<QuotationDriverseEndorsSoap> soapModels =
			new ArrayList<QuotationDriverseEndorsSoap>(models.size());

		for (QuotationDriverseEndors model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new QuotationDriverseEndorsSoap[soapModels.size()]);
	}

	public QuotationDriverseEndorsSoap() {
	}

	public long getPrimaryKey() {
		return _addDriverId;
	}

	public void setPrimaryKey(long pk) {
		setAddDriverId(pk);
	}

	public long getAddDriverId() {
		return _addDriverId;
	}

	public void setAddDriverId(long addDriverId) {
		_addDriverId = addDriverId;
	}

	public long getQuotationId() {
		return _quotationId;
	}

	public void setQuotationId(long quotationId) {
		_quotationId = quotationId;
	}

	public String getPolicyNumber() {
		return _policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		_policyNumber = policyNumber;
	}

	public Date getDriverDob() {
		return _driverDob;
	}

	public void setDriverDob(Date driverDob) {
		_driverDob = driverDob;
	}

	public String getDriverDobH() {
		return _driverDobH;
	}

	public void setDriverDobH(String driverDobH) {
		_driverDobH = driverDobH;
	}

	public String getDriverGender() {
		return _driverGender;
	}

	public void setDriverGender(String driverGender) {
		_driverGender = driverGender;
	}

	public String getDriverId() {
		return _driverId;
	}

	public void setDriverId(String driverId) {
		_driverId = driverId;
	}

	public long getDriverIdType() {
		return _driverIdType;
	}

	public void setDriverIdType(long driverIdType) {
		_driverIdType = driverIdType;
	}

	public String getDriverName() {
		return _driverName;
	}

	public void setDriverName(String driverName) {
		_driverName = driverName;
	}

	public String getDriverNationality() {
		return _driverNationality;
	}

	public void setDriverNationality(String driverNationality) {
		_driverNationality = driverNationality;
	}

	public String getDriverOccup() {
		return _driverOccup;
	}

	public void setDriverOccup(String driverOccup) {
		_driverOccup = driverOccup;
	}

	public boolean getIsDriverUnder21() {
		return _isDriverUnder21;
	}

	public boolean isIsDriverUnder21() {
		return _isDriverUnder21;
	}

	public void setIsDriverUnder21(boolean isDriverUnder21) {
		_isDriverUnder21 = isDriverUnder21;
	}

	public String getDriverEdu() {
		return _driverEdu;
	}

	public void setDriverEdu(String driverEdu) {
		_driverEdu = driverEdu;
	}

	public String getDriverNoChild() {
		return _driverNoChild;
	}

	public void setDriverNoChild(String driverNoChild) {
		_driverNoChild = driverNoChild;
	}

	public String getDriverMaritalStatus() {
		return _driverMaritalStatus;
	}

	public void setDriverMaritalStatus(String driverMaritalStatus) {
		_driverMaritalStatus = driverMaritalStatus;
	}

	public long getDriverNOFault() {
		return _driverNOFault;
	}

	public void setDriverNOFault(long driverNOFault) {
		_driverNOFault = driverNOFault;
	}

	public long getDriverNOClaim() {
		return _driverNOClaim;
	}

	public void setDriverNOClaim(long driverNOClaim) {
		_driverNOClaim = driverNOClaim;
	}

	public String getDriverConvictions() {
		return _driverConvictions;
	}

	public void setDriverConvictions(String driverConvictions) {
		_driverConvictions = driverConvictions;
	}

	public String getDriverMedConds() {
		return _driverMedConds;
	}

	public void setDriverMedConds(String driverMedConds) {
		_driverMedConds = driverMedConds;
	}

	public int getNcdYears() {
		return _ncdYears;
	}

	public void setNcdYears(int ncdYears) {
		_ncdYears = ncdYears;
	}

	public String getInsuredRelation() {
		return _insuredRelation;
	}

	public void setInsuredRelation(String insuredRelation) {
		_insuredRelation = insuredRelation;
	}

	public Blob getInsuredRelationProof() {
		return _insuredRelationProof;
	}

	public void setInsuredRelationProof(Blob insuredRelationProof) {
		_insuredRelationProof = insuredRelationProof;
	}

	public String getInsuredRelationProofFileName() {
		return _insuredRelationProofFileName;
	}

	public void setInsuredRelationProofFileName(
		String insuredRelationProofFileName) {

		_insuredRelationProofFileName = insuredRelationProofFileName;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public Date getRequestedDate() {
		return _requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		_requestedDate = requestedDate;
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

	private long _addDriverId;
	private long _quotationId;
	private String _policyNumber;
	private Date _driverDob;
	private String _driverDobH;
	private String _driverGender;
	private String _driverId;
	private long _driverIdType;
	private String _driverName;
	private String _driverNationality;
	private String _driverOccup;
	private boolean _isDriverUnder21;
	private String _driverEdu;
	private String _driverNoChild;
	private String _driverMaritalStatus;
	private long _driverNOFault;
	private long _driverNOClaim;
	private String _driverConvictions;
	private String _driverMedConds;
	private int _ncdYears;
	private String _insuredRelation;
	private Blob _insuredRelationProof;
	private String _insuredRelationProofFileName;
	private String _status;
	private Date _requestedDate;
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