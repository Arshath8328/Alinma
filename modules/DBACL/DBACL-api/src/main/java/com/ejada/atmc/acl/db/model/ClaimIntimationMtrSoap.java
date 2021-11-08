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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.ClaimIntimationMtrServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ClaimIntimationMtrSoap implements Serializable {

	public static ClaimIntimationMtrSoap toSoapModel(ClaimIntimationMtr model) {
		ClaimIntimationMtrSoap soapModel = new ClaimIntimationMtrSoap();

		soapModel.setClaimIntimationMotorId(model.getClaimIntimationMotorId());
		soapModel.setIntimationReferenceNo(model.getIntimationReferenceNo());
		soapModel.setClaimantType(model.getClaimantType());
		soapModel.setPolicyNo(model.getPolicyNo());
		soapModel.setVehiclePlateNo(model.getVehiclePlateNo());
		soapModel.setSequenceNo(model.getSequenceNo());
		soapModel.setChassisNo(model.getChassisNo());
		soapModel.setMobileNo(model.getMobileNo());
		soapModel.setCauseOfLoss(model.getCauseOfLoss());
		soapModel.setDateOfLoss(model.getDateOfLoss());
		soapModel.setAccidentCity(model.getAccidentCity());
		soapModel.setDescOfAccident(model.getDescOfAccident());
		soapModel.setSrcOfAccidentReport(model.getSrcOfAccidentReport());
		soapModel.setAccidentReportNo(model.getAccidentReportNo());
		soapModel.setVehicleMake(model.getVehicleMake());
		soapModel.setVehicleModel(model.getVehicleModel());
		soapModel.setDriverName(model.getDriverName());
		soapModel.setDriverNationality(model.getDriverNationality());
		soapModel.setDriverNationalId(model.getDriverNationalId());
		soapModel.setDriverBirthDate(model.getDriverBirthDate());
		soapModel.setDriverGender(model.getDriverGender());
		soapModel.setAttachmentReference(model.getAttachmentReference());
		soapModel.setClaimStatus(model.getClaimStatus());
		soapModel.setIbanNumber(model.getIbanNumber());
		soapModel.setBankName(model.getBankName());
		soapModel.setEmailId(model.getEmailId());

		return soapModel;
	}

	public static ClaimIntimationMtrSoap[] toSoapModels(
		ClaimIntimationMtr[] models) {

		ClaimIntimationMtrSoap[] soapModels =
			new ClaimIntimationMtrSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClaimIntimationMtrSoap[][] toSoapModels(
		ClaimIntimationMtr[][] models) {

		ClaimIntimationMtrSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ClaimIntimationMtrSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClaimIntimationMtrSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClaimIntimationMtrSoap[] toSoapModels(
		List<ClaimIntimationMtr> models) {

		List<ClaimIntimationMtrSoap> soapModels =
			new ArrayList<ClaimIntimationMtrSoap>(models.size());

		for (ClaimIntimationMtr model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new ClaimIntimationMtrSoap[soapModels.size()]);
	}

	public ClaimIntimationMtrSoap() {
	}

	public long getPrimaryKey() {
		return _claimIntimationMotorId;
	}

	public void setPrimaryKey(long pk) {
		setClaimIntimationMotorId(pk);
	}

	public long getClaimIntimationMotorId() {
		return _claimIntimationMotorId;
	}

	public void setClaimIntimationMotorId(long claimIntimationMotorId) {
		_claimIntimationMotorId = claimIntimationMotorId;
	}

	public String getIntimationReferenceNo() {
		return _intimationReferenceNo;
	}

	public void setIntimationReferenceNo(String intimationReferenceNo) {
		_intimationReferenceNo = intimationReferenceNo;
	}

	public String getClaimantType() {
		return _claimantType;
	}

	public void setClaimantType(String claimantType) {
		_claimantType = claimantType;
	}

	public String getPolicyNo() {
		return _policyNo;
	}

	public void setPolicyNo(String policyNo) {
		_policyNo = policyNo;
	}

	public String getVehiclePlateNo() {
		return _vehiclePlateNo;
	}

	public void setVehiclePlateNo(String vehiclePlateNo) {
		_vehiclePlateNo = vehiclePlateNo;
	}

	public long getSequenceNo() {
		return _sequenceNo;
	}

	public void setSequenceNo(long sequenceNo) {
		_sequenceNo = sequenceNo;
	}

	public String getChassisNo() {
		return _chassisNo;
	}

	public void setChassisNo(String chassisNo) {
		_chassisNo = chassisNo;
	}

	public String getMobileNo() {
		return _mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		_mobileNo = mobileNo;
	}

	public String getCauseOfLoss() {
		return _causeOfLoss;
	}

	public void setCauseOfLoss(String causeOfLoss) {
		_causeOfLoss = causeOfLoss;
	}

	public Date getDateOfLoss() {
		return _dateOfLoss;
	}

	public void setDateOfLoss(Date dateOfLoss) {
		_dateOfLoss = dateOfLoss;
	}

	public String getAccidentCity() {
		return _accidentCity;
	}

	public void setAccidentCity(String accidentCity) {
		_accidentCity = accidentCity;
	}

	public String getDescOfAccident() {
		return _descOfAccident;
	}

	public void setDescOfAccident(String descOfAccident) {
		_descOfAccident = descOfAccident;
	}

	public String getSrcOfAccidentReport() {
		return _srcOfAccidentReport;
	}

	public void setSrcOfAccidentReport(String srcOfAccidentReport) {
		_srcOfAccidentReport = srcOfAccidentReport;
	}

	public String getAccidentReportNo() {
		return _accidentReportNo;
	}

	public void setAccidentReportNo(String accidentReportNo) {
		_accidentReportNo = accidentReportNo;
	}

	public String getVehicleMake() {
		return _vehicleMake;
	}

	public void setVehicleMake(String vehicleMake) {
		_vehicleMake = vehicleMake;
	}

	public String getVehicleModel() {
		return _vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		_vehicleModel = vehicleModel;
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

	public long getDriverNationalId() {
		return _driverNationalId;
	}

	public void setDriverNationalId(long driverNationalId) {
		_driverNationalId = driverNationalId;
	}

	public Date getDriverBirthDate() {
		return _driverBirthDate;
	}

	public void setDriverBirthDate(Date driverBirthDate) {
		_driverBirthDate = driverBirthDate;
	}

	public String getDriverGender() {
		return _driverGender;
	}

	public void setDriverGender(String driverGender) {
		_driverGender = driverGender;
	}

	public String getAttachmentReference() {
		return _attachmentReference;
	}

	public void setAttachmentReference(String attachmentReference) {
		_attachmentReference = attachmentReference;
	}

	public int getClaimStatus() {
		return _claimStatus;
	}

	public void setClaimStatus(int claimStatus) {
		_claimStatus = claimStatus;
	}

	public String getIbanNumber() {
		return _ibanNumber;
	}

	public void setIbanNumber(String ibanNumber) {
		_ibanNumber = ibanNumber;
	}

	public String getBankName() {
		return _bankName;
	}

	public void setBankName(String bankName) {
		_bankName = bankName;
	}

	public String getEmailId() {
		return _emailId;
	}

	public void setEmailId(String emailId) {
		_emailId = emailId;
	}

	private long _claimIntimationMotorId;
	private String _intimationReferenceNo;
	private String _claimantType;
	private String _policyNo;
	private String _vehiclePlateNo;
	private long _sequenceNo;
	private String _chassisNo;
	private String _mobileNo;
	private String _causeOfLoss;
	private Date _dateOfLoss;
	private String _accidentCity;
	private String _descOfAccident;
	private String _srcOfAccidentReport;
	private String _accidentReportNo;
	private String _vehicleMake;
	private String _vehicleModel;
	private String _driverName;
	private String _driverNationality;
	private long _driverNationalId;
	private Date _driverBirthDate;
	private String _driverGender;
	private String _attachmentReference;
	private int _claimStatus;
	private String _ibanNumber;
	private String _bankName;
	private String _emailId;

}