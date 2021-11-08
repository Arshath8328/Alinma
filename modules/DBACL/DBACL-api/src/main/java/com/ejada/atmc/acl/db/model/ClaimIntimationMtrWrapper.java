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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ClaimIntimationMtr}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimIntimationMtr
 * @generated
 */
public class ClaimIntimationMtrWrapper
	extends BaseModelWrapper<ClaimIntimationMtr>
	implements ClaimIntimationMtr, ModelWrapper<ClaimIntimationMtr> {

	public ClaimIntimationMtrWrapper(ClaimIntimationMtr claimIntimationMtr) {
		super(claimIntimationMtr);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("claimIntimationMotorId", getClaimIntimationMotorId());
		attributes.put("intimationReferenceNo", getIntimationReferenceNo());
		attributes.put("claimantType", getClaimantType());
		attributes.put("policyNo", getPolicyNo());
		attributes.put("vehiclePlateNo", getVehiclePlateNo());
		attributes.put("sequenceNo", getSequenceNo());
		attributes.put("chassisNo", getChassisNo());
		attributes.put("mobileNo", getMobileNo());
		attributes.put("causeOfLoss", getCauseOfLoss());
		attributes.put("dateOfLoss", getDateOfLoss());
		attributes.put("accidentCity", getAccidentCity());
		attributes.put("descOfAccident", getDescOfAccident());
		attributes.put("srcOfAccidentReport", getSrcOfAccidentReport());
		attributes.put("accidentReportNo", getAccidentReportNo());
		attributes.put("vehicleMake", getVehicleMake());
		attributes.put("vehicleModel", getVehicleModel());
		attributes.put("driverName", getDriverName());
		attributes.put("driverNationality", getDriverNationality());
		attributes.put("driverNationalId", getDriverNationalId());
		attributes.put("driverBirthDate", getDriverBirthDate());
		attributes.put("driverGender", getDriverGender());
		attributes.put("attachmentReference", getAttachmentReference());
		attributes.put("claimStatus", getClaimStatus());
		attributes.put("ibanNumber", getIbanNumber());
		attributes.put("bankName", getBankName());
		attributes.put("emailId", getEmailId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long claimIntimationMotorId = (Long)attributes.get(
			"claimIntimationMotorId");

		if (claimIntimationMotorId != null) {
			setClaimIntimationMotorId(claimIntimationMotorId);
		}

		String intimationReferenceNo = (String)attributes.get(
			"intimationReferenceNo");

		if (intimationReferenceNo != null) {
			setIntimationReferenceNo(intimationReferenceNo);
		}

		String claimantType = (String)attributes.get("claimantType");

		if (claimantType != null) {
			setClaimantType(claimantType);
		}

		String policyNo = (String)attributes.get("policyNo");

		if (policyNo != null) {
			setPolicyNo(policyNo);
		}

		String vehiclePlateNo = (String)attributes.get("vehiclePlateNo");

		if (vehiclePlateNo != null) {
			setVehiclePlateNo(vehiclePlateNo);
		}

		Long sequenceNo = (Long)attributes.get("sequenceNo");

		if (sequenceNo != null) {
			setSequenceNo(sequenceNo);
		}

		String chassisNo = (String)attributes.get("chassisNo");

		if (chassisNo != null) {
			setChassisNo(chassisNo);
		}

		String mobileNo = (String)attributes.get("mobileNo");

		if (mobileNo != null) {
			setMobileNo(mobileNo);
		}

		String causeOfLoss = (String)attributes.get("causeOfLoss");

		if (causeOfLoss != null) {
			setCauseOfLoss(causeOfLoss);
		}

		Date dateOfLoss = (Date)attributes.get("dateOfLoss");

		if (dateOfLoss != null) {
			setDateOfLoss(dateOfLoss);
		}

		String accidentCity = (String)attributes.get("accidentCity");

		if (accidentCity != null) {
			setAccidentCity(accidentCity);
		}

		String descOfAccident = (String)attributes.get("descOfAccident");

		if (descOfAccident != null) {
			setDescOfAccident(descOfAccident);
		}

		String srcOfAccidentReport = (String)attributes.get(
			"srcOfAccidentReport");

		if (srcOfAccidentReport != null) {
			setSrcOfAccidentReport(srcOfAccidentReport);
		}

		String accidentReportNo = (String)attributes.get("accidentReportNo");

		if (accidentReportNo != null) {
			setAccidentReportNo(accidentReportNo);
		}

		String vehicleMake = (String)attributes.get("vehicleMake");

		if (vehicleMake != null) {
			setVehicleMake(vehicleMake);
		}

		String vehicleModel = (String)attributes.get("vehicleModel");

		if (vehicleModel != null) {
			setVehicleModel(vehicleModel);
		}

		String driverName = (String)attributes.get("driverName");

		if (driverName != null) {
			setDriverName(driverName);
		}

		String driverNationality = (String)attributes.get("driverNationality");

		if (driverNationality != null) {
			setDriverNationality(driverNationality);
		}

		Long driverNationalId = (Long)attributes.get("driverNationalId");

		if (driverNationalId != null) {
			setDriverNationalId(driverNationalId);
		}

		Date driverBirthDate = (Date)attributes.get("driverBirthDate");

		if (driverBirthDate != null) {
			setDriverBirthDate(driverBirthDate);
		}

		String driverGender = (String)attributes.get("driverGender");

		if (driverGender != null) {
			setDriverGender(driverGender);
		}

		String attachmentReference = (String)attributes.get(
			"attachmentReference");

		if (attachmentReference != null) {
			setAttachmentReference(attachmentReference);
		}

		Integer claimStatus = (Integer)attributes.get("claimStatus");

		if (claimStatus != null) {
			setClaimStatus(claimStatus);
		}

		String ibanNumber = (String)attributes.get("ibanNumber");

		if (ibanNumber != null) {
			setIbanNumber(ibanNumber);
		}

		String bankName = (String)attributes.get("bankName");

		if (bankName != null) {
			setBankName(bankName);
		}

		String emailId = (String)attributes.get("emailId");

		if (emailId != null) {
			setEmailId(emailId);
		}
	}

	/**
	 * Returns the accident city of this claim intimation mtr.
	 *
	 * @return the accident city of this claim intimation mtr
	 */
	@Override
	public String getAccidentCity() {
		return model.getAccidentCity();
	}

	/**
	 * Returns the accident report no of this claim intimation mtr.
	 *
	 * @return the accident report no of this claim intimation mtr
	 */
	@Override
	public String getAccidentReportNo() {
		return model.getAccidentReportNo();
	}

	/**
	 * Returns the attachment reference of this claim intimation mtr.
	 *
	 * @return the attachment reference of this claim intimation mtr
	 */
	@Override
	public String getAttachmentReference() {
		return model.getAttachmentReference();
	}

	/**
	 * Returns the bank name of this claim intimation mtr.
	 *
	 * @return the bank name of this claim intimation mtr
	 */
	@Override
	public String getBankName() {
		return model.getBankName();
	}

	/**
	 * Returns the cause of loss of this claim intimation mtr.
	 *
	 * @return the cause of loss of this claim intimation mtr
	 */
	@Override
	public String getCauseOfLoss() {
		return model.getCauseOfLoss();
	}

	/**
	 * Returns the chassis no of this claim intimation mtr.
	 *
	 * @return the chassis no of this claim intimation mtr
	 */
	@Override
	public String getChassisNo() {
		return model.getChassisNo();
	}

	/**
	 * Returns the claimant type of this claim intimation mtr.
	 *
	 * @return the claimant type of this claim intimation mtr
	 */
	@Override
	public String getClaimantType() {
		return model.getClaimantType();
	}

	/**
	 * Returns the claim intimation motor ID of this claim intimation mtr.
	 *
	 * @return the claim intimation motor ID of this claim intimation mtr
	 */
	@Override
	public long getClaimIntimationMotorId() {
		return model.getClaimIntimationMotorId();
	}

	/**
	 * Returns the claim status of this claim intimation mtr.
	 *
	 * @return the claim status of this claim intimation mtr
	 */
	@Override
	public int getClaimStatus() {
		return model.getClaimStatus();
	}

	/**
	 * Returns the date of loss of this claim intimation mtr.
	 *
	 * @return the date of loss of this claim intimation mtr
	 */
	@Override
	public Date getDateOfLoss() {
		return model.getDateOfLoss();
	}

	/**
	 * Returns the desc of accident of this claim intimation mtr.
	 *
	 * @return the desc of accident of this claim intimation mtr
	 */
	@Override
	public String getDescOfAccident() {
		return model.getDescOfAccident();
	}

	/**
	 * Returns the driver birth date of this claim intimation mtr.
	 *
	 * @return the driver birth date of this claim intimation mtr
	 */
	@Override
	public Date getDriverBirthDate() {
		return model.getDriverBirthDate();
	}

	/**
	 * Returns the driver gender of this claim intimation mtr.
	 *
	 * @return the driver gender of this claim intimation mtr
	 */
	@Override
	public String getDriverGender() {
		return model.getDriverGender();
	}

	/**
	 * Returns the driver name of this claim intimation mtr.
	 *
	 * @return the driver name of this claim intimation mtr
	 */
	@Override
	public String getDriverName() {
		return model.getDriverName();
	}

	/**
	 * Returns the driver national ID of this claim intimation mtr.
	 *
	 * @return the driver national ID of this claim intimation mtr
	 */
	@Override
	public long getDriverNationalId() {
		return model.getDriverNationalId();
	}

	/**
	 * Returns the driver nationality of this claim intimation mtr.
	 *
	 * @return the driver nationality of this claim intimation mtr
	 */
	@Override
	public String getDriverNationality() {
		return model.getDriverNationality();
	}

	/**
	 * Returns the email ID of this claim intimation mtr.
	 *
	 * @return the email ID of this claim intimation mtr
	 */
	@Override
	public String getEmailId() {
		return model.getEmailId();
	}

	/**
	 * Returns the iban number of this claim intimation mtr.
	 *
	 * @return the iban number of this claim intimation mtr
	 */
	@Override
	public String getIbanNumber() {
		return model.getIbanNumber();
	}

	/**
	 * Returns the intimation reference no of this claim intimation mtr.
	 *
	 * @return the intimation reference no of this claim intimation mtr
	 */
	@Override
	public String getIntimationReferenceNo() {
		return model.getIntimationReferenceNo();
	}

	/**
	 * Returns the mobile no of this claim intimation mtr.
	 *
	 * @return the mobile no of this claim intimation mtr
	 */
	@Override
	public String getMobileNo() {
		return model.getMobileNo();
	}

	/**
	 * Returns the policy no of this claim intimation mtr.
	 *
	 * @return the policy no of this claim intimation mtr
	 */
	@Override
	public String getPolicyNo() {
		return model.getPolicyNo();
	}

	/**
	 * Returns the primary key of this claim intimation mtr.
	 *
	 * @return the primary key of this claim intimation mtr
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sequence no of this claim intimation mtr.
	 *
	 * @return the sequence no of this claim intimation mtr
	 */
	@Override
	public long getSequenceNo() {
		return model.getSequenceNo();
	}

	/**
	 * Returns the src of accident report of this claim intimation mtr.
	 *
	 * @return the src of accident report of this claim intimation mtr
	 */
	@Override
	public String getSrcOfAccidentReport() {
		return model.getSrcOfAccidentReport();
	}

	/**
	 * Returns the vehicle make of this claim intimation mtr.
	 *
	 * @return the vehicle make of this claim intimation mtr
	 */
	@Override
	public String getVehicleMake() {
		return model.getVehicleMake();
	}

	/**
	 * Returns the vehicle model of this claim intimation mtr.
	 *
	 * @return the vehicle model of this claim intimation mtr
	 */
	@Override
	public String getVehicleModel() {
		return model.getVehicleModel();
	}

	/**
	 * Returns the vehicle plate no of this claim intimation mtr.
	 *
	 * @return the vehicle plate no of this claim intimation mtr
	 */
	@Override
	public String getVehiclePlateNo() {
		return model.getVehiclePlateNo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the accident city of this claim intimation mtr.
	 *
	 * @param accidentCity the accident city of this claim intimation mtr
	 */
	@Override
	public void setAccidentCity(String accidentCity) {
		model.setAccidentCity(accidentCity);
	}

	/**
	 * Sets the accident report no of this claim intimation mtr.
	 *
	 * @param accidentReportNo the accident report no of this claim intimation mtr
	 */
	@Override
	public void setAccidentReportNo(String accidentReportNo) {
		model.setAccidentReportNo(accidentReportNo);
	}

	/**
	 * Sets the attachment reference of this claim intimation mtr.
	 *
	 * @param attachmentReference the attachment reference of this claim intimation mtr
	 */
	@Override
	public void setAttachmentReference(String attachmentReference) {
		model.setAttachmentReference(attachmentReference);
	}

	/**
	 * Sets the bank name of this claim intimation mtr.
	 *
	 * @param bankName the bank name of this claim intimation mtr
	 */
	@Override
	public void setBankName(String bankName) {
		model.setBankName(bankName);
	}

	/**
	 * Sets the cause of loss of this claim intimation mtr.
	 *
	 * @param causeOfLoss the cause of loss of this claim intimation mtr
	 */
	@Override
	public void setCauseOfLoss(String causeOfLoss) {
		model.setCauseOfLoss(causeOfLoss);
	}

	/**
	 * Sets the chassis no of this claim intimation mtr.
	 *
	 * @param chassisNo the chassis no of this claim intimation mtr
	 */
	@Override
	public void setChassisNo(String chassisNo) {
		model.setChassisNo(chassisNo);
	}

	/**
	 * Sets the claimant type of this claim intimation mtr.
	 *
	 * @param claimantType the claimant type of this claim intimation mtr
	 */
	@Override
	public void setClaimantType(String claimantType) {
		model.setClaimantType(claimantType);
	}

	/**
	 * Sets the claim intimation motor ID of this claim intimation mtr.
	 *
	 * @param claimIntimationMotorId the claim intimation motor ID of this claim intimation mtr
	 */
	@Override
	public void setClaimIntimationMotorId(long claimIntimationMotorId) {
		model.setClaimIntimationMotorId(claimIntimationMotorId);
	}

	/**
	 * Sets the claim status of this claim intimation mtr.
	 *
	 * @param claimStatus the claim status of this claim intimation mtr
	 */
	@Override
	public void setClaimStatus(int claimStatus) {
		model.setClaimStatus(claimStatus);
	}

	/**
	 * Sets the date of loss of this claim intimation mtr.
	 *
	 * @param dateOfLoss the date of loss of this claim intimation mtr
	 */
	@Override
	public void setDateOfLoss(Date dateOfLoss) {
		model.setDateOfLoss(dateOfLoss);
	}

	/**
	 * Sets the desc of accident of this claim intimation mtr.
	 *
	 * @param descOfAccident the desc of accident of this claim intimation mtr
	 */
	@Override
	public void setDescOfAccident(String descOfAccident) {
		model.setDescOfAccident(descOfAccident);
	}

	/**
	 * Sets the driver birth date of this claim intimation mtr.
	 *
	 * @param driverBirthDate the driver birth date of this claim intimation mtr
	 */
	@Override
	public void setDriverBirthDate(Date driverBirthDate) {
		model.setDriverBirthDate(driverBirthDate);
	}

	/**
	 * Sets the driver gender of this claim intimation mtr.
	 *
	 * @param driverGender the driver gender of this claim intimation mtr
	 */
	@Override
	public void setDriverGender(String driverGender) {
		model.setDriverGender(driverGender);
	}

	/**
	 * Sets the driver name of this claim intimation mtr.
	 *
	 * @param driverName the driver name of this claim intimation mtr
	 */
	@Override
	public void setDriverName(String driverName) {
		model.setDriverName(driverName);
	}

	/**
	 * Sets the driver national ID of this claim intimation mtr.
	 *
	 * @param driverNationalId the driver national ID of this claim intimation mtr
	 */
	@Override
	public void setDriverNationalId(long driverNationalId) {
		model.setDriverNationalId(driverNationalId);
	}

	/**
	 * Sets the driver nationality of this claim intimation mtr.
	 *
	 * @param driverNationality the driver nationality of this claim intimation mtr
	 */
	@Override
	public void setDriverNationality(String driverNationality) {
		model.setDriverNationality(driverNationality);
	}

	/**
	 * Sets the email ID of this claim intimation mtr.
	 *
	 * @param emailId the email ID of this claim intimation mtr
	 */
	@Override
	public void setEmailId(String emailId) {
		model.setEmailId(emailId);
	}

	/**
	 * Sets the iban number of this claim intimation mtr.
	 *
	 * @param ibanNumber the iban number of this claim intimation mtr
	 */
	@Override
	public void setIbanNumber(String ibanNumber) {
		model.setIbanNumber(ibanNumber);
	}

	/**
	 * Sets the intimation reference no of this claim intimation mtr.
	 *
	 * @param intimationReferenceNo the intimation reference no of this claim intimation mtr
	 */
	@Override
	public void setIntimationReferenceNo(String intimationReferenceNo) {
		model.setIntimationReferenceNo(intimationReferenceNo);
	}

	/**
	 * Sets the mobile no of this claim intimation mtr.
	 *
	 * @param mobileNo the mobile no of this claim intimation mtr
	 */
	@Override
	public void setMobileNo(String mobileNo) {
		model.setMobileNo(mobileNo);
	}

	/**
	 * Sets the policy no of this claim intimation mtr.
	 *
	 * @param policyNo the policy no of this claim intimation mtr
	 */
	@Override
	public void setPolicyNo(String policyNo) {
		model.setPolicyNo(policyNo);
	}

	/**
	 * Sets the primary key of this claim intimation mtr.
	 *
	 * @param primaryKey the primary key of this claim intimation mtr
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sequence no of this claim intimation mtr.
	 *
	 * @param sequenceNo the sequence no of this claim intimation mtr
	 */
	@Override
	public void setSequenceNo(long sequenceNo) {
		model.setSequenceNo(sequenceNo);
	}

	/**
	 * Sets the src of accident report of this claim intimation mtr.
	 *
	 * @param srcOfAccidentReport the src of accident report of this claim intimation mtr
	 */
	@Override
	public void setSrcOfAccidentReport(String srcOfAccidentReport) {
		model.setSrcOfAccidentReport(srcOfAccidentReport);
	}

	/**
	 * Sets the vehicle make of this claim intimation mtr.
	 *
	 * @param vehicleMake the vehicle make of this claim intimation mtr
	 */
	@Override
	public void setVehicleMake(String vehicleMake) {
		model.setVehicleMake(vehicleMake);
	}

	/**
	 * Sets the vehicle model of this claim intimation mtr.
	 *
	 * @param vehicleModel the vehicle model of this claim intimation mtr
	 */
	@Override
	public void setVehicleModel(String vehicleModel) {
		model.setVehicleModel(vehicleModel);
	}

	/**
	 * Sets the vehicle plate no of this claim intimation mtr.
	 *
	 * @param vehiclePlateNo the vehicle plate no of this claim intimation mtr
	 */
	@Override
	public void setVehiclePlateNo(String vehiclePlateNo) {
		model.setVehiclePlateNo(vehiclePlateNo);
	}

	@Override
	protected ClaimIntimationMtrWrapper wrap(
		ClaimIntimationMtr claimIntimationMtr) {

		return new ClaimIntimationMtrWrapper(claimIntimationMtr);
	}

}