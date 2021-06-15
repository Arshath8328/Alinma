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

import com.ejada.atmc.acl.db.model.PolicyCancelation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PolicyCancelation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PolicyCancelationCacheModel
	implements CacheModel<PolicyCancelation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PolicyCancelationCacheModel)) {
			return false;
		}

		PolicyCancelationCacheModel policyCancelationCacheModel =
			(PolicyCancelationCacheModel)object;

		if (Id.equals(policyCancelationCacheModel.Id)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, Id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{Id=");
		sb.append(Id);
		sb.append(", policyNumber=");
		sb.append(policyNumber);
		sb.append(", policyExpiryDate=");
		sb.append(policyExpiryDate);
		sb.append(", insuredId=");
		sb.append(insuredId);
		sb.append(", insuredName=");
		sb.append(insuredName);
		sb.append(", vehicleSequence=");
		sb.append(vehicleSequence);
		sb.append(", vehicleChessisNo=");
		sb.append(vehicleChessisNo);
		sb.append(", status=");
		sb.append(status);
		sb.append(", cancllationReqDate=");
		sb.append(cancllationReqDate);
		sb.append(", reason=");
		sb.append(reason);
		sb.append(", servicemessage=");
		sb.append(servicemessage);
		sb.append(", cancellationEffdate=");
		sb.append(cancellationEffdate);
		sb.append(", vehMake=");
		sb.append(vehMake);
		sb.append(", vehModel=");
		sb.append(vehModel);
		sb.append(", plateNumber=");
		sb.append(plateNumber);
		sb.append(", anyAccident=");
		sb.append(anyAccident);
		sb.append(", lodgeClaim=");
		sb.append(lodgeClaim);
		sb.append(", ibanFileName=");
		sb.append(ibanFileName);
		sb.append(", validFileName=");
		sb.append(validFileName);
		sb.append(", policyInceptionDate=");
		sb.append(policyInceptionDate);
		sb.append(", insuredEmail=");
		sb.append(insuredEmail);
		sb.append(", insuredMobile=");
		sb.append(insuredMobile);
		sb.append(", rejReason=");
		sb.append(rejReason);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PolicyCancelation toEntityModel() {
		PolicyCancelationImpl policyCancelationImpl =
			new PolicyCancelationImpl();

		if (Id == null) {
			policyCancelationImpl.setId("");
		}
		else {
			policyCancelationImpl.setId(Id);
		}

		if (policyNumber == null) {
			policyCancelationImpl.setPolicyNumber("");
		}
		else {
			policyCancelationImpl.setPolicyNumber(policyNumber);
		}

		if (policyExpiryDate == Long.MIN_VALUE) {
			policyCancelationImpl.setPolicyExpiryDate(null);
		}
		else {
			policyCancelationImpl.setPolicyExpiryDate(
				new Date(policyExpiryDate));
		}

		if (insuredId == null) {
			policyCancelationImpl.setInsuredId("");
		}
		else {
			policyCancelationImpl.setInsuredId(insuredId);
		}

		if (insuredName == null) {
			policyCancelationImpl.setInsuredName("");
		}
		else {
			policyCancelationImpl.setInsuredName(insuredName);
		}

		if (vehicleSequence == null) {
			policyCancelationImpl.setVehicleSequence("");
		}
		else {
			policyCancelationImpl.setVehicleSequence(vehicleSequence);
		}

		if (vehicleChessisNo == null) {
			policyCancelationImpl.setVehicleChessisNo("");
		}
		else {
			policyCancelationImpl.setVehicleChessisNo(vehicleChessisNo);
		}

		if (status == null) {
			policyCancelationImpl.setStatus("");
		}
		else {
			policyCancelationImpl.setStatus(status);
		}

		if (cancllationReqDate == Long.MIN_VALUE) {
			policyCancelationImpl.setCancllationReqDate(null);
		}
		else {
			policyCancelationImpl.setCancllationReqDate(
				new Date(cancllationReqDate));
		}

		if (reason == null) {
			policyCancelationImpl.setReason("");
		}
		else {
			policyCancelationImpl.setReason(reason);
		}

		if (servicemessage == null) {
			policyCancelationImpl.setServicemessage("");
		}
		else {
			policyCancelationImpl.setServicemessage(servicemessage);
		}

		if (cancellationEffdate == Long.MIN_VALUE) {
			policyCancelationImpl.setCancellationEffdate(null);
		}
		else {
			policyCancelationImpl.setCancellationEffdate(
				new Date(cancellationEffdate));
		}

		if (vehMake == null) {
			policyCancelationImpl.setVehMake("");
		}
		else {
			policyCancelationImpl.setVehMake(vehMake);
		}

		if (vehModel == null) {
			policyCancelationImpl.setVehModel("");
		}
		else {
			policyCancelationImpl.setVehModel(vehModel);
		}

		if (plateNumber == null) {
			policyCancelationImpl.setPlateNumber("");
		}
		else {
			policyCancelationImpl.setPlateNumber(plateNumber);
		}

		if (anyAccident == null) {
			policyCancelationImpl.setAnyAccident("");
		}
		else {
			policyCancelationImpl.setAnyAccident(anyAccident);
		}

		if (lodgeClaim == null) {
			policyCancelationImpl.setLodgeClaim("");
		}
		else {
			policyCancelationImpl.setLodgeClaim(lodgeClaim);
		}

		if (ibanFileName == null) {
			policyCancelationImpl.setIbanFileName("");
		}
		else {
			policyCancelationImpl.setIbanFileName(ibanFileName);
		}

		if (validFileName == null) {
			policyCancelationImpl.setValidFileName("");
		}
		else {
			policyCancelationImpl.setValidFileName(validFileName);
		}

		if (policyInceptionDate == Long.MIN_VALUE) {
			policyCancelationImpl.setPolicyInceptionDate(null);
		}
		else {
			policyCancelationImpl.setPolicyInceptionDate(
				new Date(policyInceptionDate));
		}

		if (insuredEmail == null) {
			policyCancelationImpl.setInsuredEmail("");
		}
		else {
			policyCancelationImpl.setInsuredEmail(insuredEmail);
		}

		if (insuredMobile == null) {
			policyCancelationImpl.setInsuredMobile("");
		}
		else {
			policyCancelationImpl.setInsuredMobile(insuredMobile);
		}

		if (rejReason == null) {
			policyCancelationImpl.setRejReason("");
		}
		else {
			policyCancelationImpl.setRejReason(rejReason);
		}

		policyCancelationImpl.resetOriginalValues();

		return policyCancelationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		Id = objectInput.readUTF();
		policyNumber = objectInput.readUTF();
		policyExpiryDate = objectInput.readLong();
		insuredId = objectInput.readUTF();
		insuredName = objectInput.readUTF();
		vehicleSequence = objectInput.readUTF();
		vehicleChessisNo = objectInput.readUTF();
		status = objectInput.readUTF();
		cancllationReqDate = objectInput.readLong();
		reason = objectInput.readUTF();
		servicemessage = objectInput.readUTF();
		cancellationEffdate = objectInput.readLong();
		vehMake = objectInput.readUTF();
		vehModel = objectInput.readUTF();
		plateNumber = objectInput.readUTF();
		anyAccident = objectInput.readUTF();
		lodgeClaim = objectInput.readUTF();
		ibanFileName = objectInput.readUTF();
		validFileName = objectInput.readUTF();
		policyInceptionDate = objectInput.readLong();
		insuredEmail = objectInput.readUTF();
		insuredMobile = objectInput.readUTF();
		rejReason = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (Id == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Id);
		}

		if (policyNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyNumber);
		}

		objectOutput.writeLong(policyExpiryDate);

		if (insuredId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredId);
		}

		if (insuredName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredName);
		}

		if (vehicleSequence == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleSequence);
		}

		if (vehicleChessisNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleChessisNo);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(cancllationReqDate);

		if (reason == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reason);
		}

		if (servicemessage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(servicemessage);
		}

		objectOutput.writeLong(cancellationEffdate);

		if (vehMake == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehMake);
		}

		if (vehModel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehModel);
		}

		if (plateNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(plateNumber);
		}

		if (anyAccident == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(anyAccident);
		}

		if (lodgeClaim == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lodgeClaim);
		}

		if (ibanFileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ibanFileName);
		}

		if (validFileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(validFileName);
		}

		objectOutput.writeLong(policyInceptionDate);

		if (insuredEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredEmail);
		}

		if (insuredMobile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredMobile);
		}

		if (rejReason == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rejReason);
		}
	}

	public String Id;
	public String policyNumber;
	public long policyExpiryDate;
	public String insuredId;
	public String insuredName;
	public String vehicleSequence;
	public String vehicleChessisNo;
	public String status;
	public long cancllationReqDate;
	public String reason;
	public String servicemessage;
	public long cancellationEffdate;
	public String vehMake;
	public String vehModel;
	public String plateNumber;
	public String anyAccident;
	public String lodgeClaim;
	public String ibanFileName;
	public String validFileName;
	public long policyInceptionDate;
	public String insuredEmail;
	public String insuredMobile;
	public String rejReason;

}