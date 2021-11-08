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

package com.ejada.atmc.acl.db.model.impl;

import com.ejada.atmc.acl.db.model.ClaimIntimationMtr;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ClaimIntimationMtr in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ClaimIntimationMtrCacheModel
	implements CacheModel<ClaimIntimationMtr>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ClaimIntimationMtrCacheModel)) {
			return false;
		}

		ClaimIntimationMtrCacheModel claimIntimationMtrCacheModel =
			(ClaimIntimationMtrCacheModel)object;

		if (claimIntimationMotorId ==
				claimIntimationMtrCacheModel.claimIntimationMotorId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, claimIntimationMotorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{claimIntimationMotorId=");
		sb.append(claimIntimationMotorId);
		sb.append(", intimationReferenceNo=");
		sb.append(intimationReferenceNo);
		sb.append(", claimantType=");
		sb.append(claimantType);
		sb.append(", policyNo=");
		sb.append(policyNo);
		sb.append(", vehiclePlateNo=");
		sb.append(vehiclePlateNo);
		sb.append(", sequenceNo=");
		sb.append(sequenceNo);
		sb.append(", chassisNo=");
		sb.append(chassisNo);
		sb.append(", mobileNo=");
		sb.append(mobileNo);
		sb.append(", causeOfLoss=");
		sb.append(causeOfLoss);
		sb.append(", dateOfLoss=");
		sb.append(dateOfLoss);
		sb.append(", accidentCity=");
		sb.append(accidentCity);
		sb.append(", descOfAccident=");
		sb.append(descOfAccident);
		sb.append(", srcOfAccidentReport=");
		sb.append(srcOfAccidentReport);
		sb.append(", accidentReportNo=");
		sb.append(accidentReportNo);
		sb.append(", vehicleMake=");
		sb.append(vehicleMake);
		sb.append(", vehicleModel=");
		sb.append(vehicleModel);
		sb.append(", driverName=");
		sb.append(driverName);
		sb.append(", driverNationality=");
		sb.append(driverNationality);
		sb.append(", driverNationalId=");
		sb.append(driverNationalId);
		sb.append(", driverBirthDate=");
		sb.append(driverBirthDate);
		sb.append(", driverGender=");
		sb.append(driverGender);
		sb.append(", attachmentReference=");
		sb.append(attachmentReference);
		sb.append(", claimStatus=");
		sb.append(claimStatus);
		sb.append(", ibanNumber=");
		sb.append(ibanNumber);
		sb.append(", bankName=");
		sb.append(bankName);
		sb.append(", emailId=");
		sb.append(emailId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ClaimIntimationMtr toEntityModel() {
		ClaimIntimationMtrImpl claimIntimationMtrImpl =
			new ClaimIntimationMtrImpl();

		claimIntimationMtrImpl.setClaimIntimationMotorId(
			claimIntimationMotorId);

		if (intimationReferenceNo == null) {
			claimIntimationMtrImpl.setIntimationReferenceNo("");
		}
		else {
			claimIntimationMtrImpl.setIntimationReferenceNo(
				intimationReferenceNo);
		}

		if (claimantType == null) {
			claimIntimationMtrImpl.setClaimantType("");
		}
		else {
			claimIntimationMtrImpl.setClaimantType(claimantType);
		}

		if (policyNo == null) {
			claimIntimationMtrImpl.setPolicyNo("");
		}
		else {
			claimIntimationMtrImpl.setPolicyNo(policyNo);
		}

		if (vehiclePlateNo == null) {
			claimIntimationMtrImpl.setVehiclePlateNo("");
		}
		else {
			claimIntimationMtrImpl.setVehiclePlateNo(vehiclePlateNo);
		}

		claimIntimationMtrImpl.setSequenceNo(sequenceNo);

		if (chassisNo == null) {
			claimIntimationMtrImpl.setChassisNo("");
		}
		else {
			claimIntimationMtrImpl.setChassisNo(chassisNo);
		}

		if (mobileNo == null) {
			claimIntimationMtrImpl.setMobileNo("");
		}
		else {
			claimIntimationMtrImpl.setMobileNo(mobileNo);
		}

		if (causeOfLoss == null) {
			claimIntimationMtrImpl.setCauseOfLoss("");
		}
		else {
			claimIntimationMtrImpl.setCauseOfLoss(causeOfLoss);
		}

		if (dateOfLoss == Long.MIN_VALUE) {
			claimIntimationMtrImpl.setDateOfLoss(null);
		}
		else {
			claimIntimationMtrImpl.setDateOfLoss(new Date(dateOfLoss));
		}

		if (accidentCity == null) {
			claimIntimationMtrImpl.setAccidentCity("");
		}
		else {
			claimIntimationMtrImpl.setAccidentCity(accidentCity);
		}

		if (descOfAccident == null) {
			claimIntimationMtrImpl.setDescOfAccident("");
		}
		else {
			claimIntimationMtrImpl.setDescOfAccident(descOfAccident);
		}

		if (srcOfAccidentReport == null) {
			claimIntimationMtrImpl.setSrcOfAccidentReport("");
		}
		else {
			claimIntimationMtrImpl.setSrcOfAccidentReport(srcOfAccidentReport);
		}

		if (accidentReportNo == null) {
			claimIntimationMtrImpl.setAccidentReportNo("");
		}
		else {
			claimIntimationMtrImpl.setAccidentReportNo(accidentReportNo);
		}

		if (vehicleMake == null) {
			claimIntimationMtrImpl.setVehicleMake("");
		}
		else {
			claimIntimationMtrImpl.setVehicleMake(vehicleMake);
		}

		if (vehicleModel == null) {
			claimIntimationMtrImpl.setVehicleModel("");
		}
		else {
			claimIntimationMtrImpl.setVehicleModel(vehicleModel);
		}

		if (driverName == null) {
			claimIntimationMtrImpl.setDriverName("");
		}
		else {
			claimIntimationMtrImpl.setDriverName(driverName);
		}

		if (driverNationality == null) {
			claimIntimationMtrImpl.setDriverNationality("");
		}
		else {
			claimIntimationMtrImpl.setDriverNationality(driverNationality);
		}

		claimIntimationMtrImpl.setDriverNationalId(driverNationalId);

		if (driverBirthDate == Long.MIN_VALUE) {
			claimIntimationMtrImpl.setDriverBirthDate(null);
		}
		else {
			claimIntimationMtrImpl.setDriverBirthDate(
				new Date(driverBirthDate));
		}

		if (driverGender == null) {
			claimIntimationMtrImpl.setDriverGender("");
		}
		else {
			claimIntimationMtrImpl.setDriverGender(driverGender);
		}

		if (attachmentReference == null) {
			claimIntimationMtrImpl.setAttachmentReference("");
		}
		else {
			claimIntimationMtrImpl.setAttachmentReference(attachmentReference);
		}

		claimIntimationMtrImpl.setClaimStatus(claimStatus);

		if (ibanNumber == null) {
			claimIntimationMtrImpl.setIbanNumber("");
		}
		else {
			claimIntimationMtrImpl.setIbanNumber(ibanNumber);
		}

		if (bankName == null) {
			claimIntimationMtrImpl.setBankName("");
		}
		else {
			claimIntimationMtrImpl.setBankName(bankName);
		}

		if (emailId == null) {
			claimIntimationMtrImpl.setEmailId("");
		}
		else {
			claimIntimationMtrImpl.setEmailId(emailId);
		}

		claimIntimationMtrImpl.resetOriginalValues();

		return claimIntimationMtrImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		claimIntimationMotorId = objectInput.readLong();
		intimationReferenceNo = objectInput.readUTF();
		claimantType = objectInput.readUTF();
		policyNo = objectInput.readUTF();
		vehiclePlateNo = objectInput.readUTF();

		sequenceNo = objectInput.readLong();
		chassisNo = objectInput.readUTF();
		mobileNo = objectInput.readUTF();
		causeOfLoss = objectInput.readUTF();
		dateOfLoss = objectInput.readLong();
		accidentCity = objectInput.readUTF();
		descOfAccident = objectInput.readUTF();
		srcOfAccidentReport = objectInput.readUTF();
		accidentReportNo = objectInput.readUTF();
		vehicleMake = objectInput.readUTF();
		vehicleModel = objectInput.readUTF();
		driverName = objectInput.readUTF();
		driverNationality = objectInput.readUTF();

		driverNationalId = objectInput.readLong();
		driverBirthDate = objectInput.readLong();
		driverGender = objectInput.readUTF();
		attachmentReference = objectInput.readUTF();

		claimStatus = objectInput.readInt();
		ibanNumber = objectInput.readUTF();
		bankName = objectInput.readUTF();
		emailId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(claimIntimationMotorId);

		if (intimationReferenceNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(intimationReferenceNo);
		}

		if (claimantType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(claimantType);
		}

		if (policyNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyNo);
		}

		if (vehiclePlateNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehiclePlateNo);
		}

		objectOutput.writeLong(sequenceNo);

		if (chassisNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(chassisNo);
		}

		if (mobileNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobileNo);
		}

		if (causeOfLoss == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(causeOfLoss);
		}

		objectOutput.writeLong(dateOfLoss);

		if (accidentCity == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accidentCity);
		}

		if (descOfAccident == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descOfAccident);
		}

		if (srcOfAccidentReport == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(srcOfAccidentReport);
		}

		if (accidentReportNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accidentReportNo);
		}

		if (vehicleMake == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleMake);
		}

		if (vehicleModel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleModel);
		}

		if (driverName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverName);
		}

		if (driverNationality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverNationality);
		}

		objectOutput.writeLong(driverNationalId);
		objectOutput.writeLong(driverBirthDate);

		if (driverGender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverGender);
		}

		if (attachmentReference == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(attachmentReference);
		}

		objectOutput.writeInt(claimStatus);

		if (ibanNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ibanNumber);
		}

		if (bankName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankName);
		}

		if (emailId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailId);
		}
	}

	public long claimIntimationMotorId;
	public String intimationReferenceNo;
	public String claimantType;
	public String policyNo;
	public String vehiclePlateNo;
	public long sequenceNo;
	public String chassisNo;
	public String mobileNo;
	public String causeOfLoss;
	public long dateOfLoss;
	public String accidentCity;
	public String descOfAccident;
	public String srcOfAccidentReport;
	public String accidentReportNo;
	public String vehicleMake;
	public String vehicleModel;
	public String driverName;
	public String driverNationality;
	public long driverNationalId;
	public long driverBirthDate;
	public String driverGender;
	public String attachmentReference;
	public int claimStatus;
	public String ibanNumber;
	public String bankName;
	public String emailId;

}