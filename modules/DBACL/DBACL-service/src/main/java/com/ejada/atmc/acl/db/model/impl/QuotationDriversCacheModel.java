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

import com.ejada.atmc.acl.db.model.QuotationDrivers;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing QuotationDrivers in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class QuotationDriversCacheModel
	implements CacheModel<QuotationDrivers>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof QuotationDriversCacheModel)) {
			return false;
		}

		QuotationDriversCacheModel quotationDriversCacheModel =
			(QuotationDriversCacheModel)object;

		if (addDriverId == quotationDriversCacheModel.addDriverId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, addDriverId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{addDriverId=");
		sb.append(addDriverId);
		sb.append(", quotationId=");
		sb.append(quotationId);
		sb.append(", driverDob=");
		sb.append(driverDob);
		sb.append(", driverDobH=");
		sb.append(driverDobH);
		sb.append(", driverGender=");
		sb.append(driverGender);
		sb.append(", driverId=");
		sb.append(driverId);
		sb.append(", driverIdType=");
		sb.append(driverIdType);
		sb.append(", driverName=");
		sb.append(driverName);
		sb.append(", driverNationality=");
		sb.append(driverNationality);
		sb.append(", driverOccup=");
		sb.append(driverOccup);
		sb.append(", isDriverUnder21=");
		sb.append(isDriverUnder21);
		sb.append(", driverEdu=");
		sb.append(driverEdu);
		sb.append(", driverNoChild=");
		sb.append(driverNoChild);
		sb.append(", driverMaritalStatus=");
		sb.append(driverMaritalStatus);
		sb.append(", driverNOFault=");
		sb.append(driverNOFault);
		sb.append(", driverNOClaim=");
		sb.append(driverNOClaim);
		sb.append(", driverConvictions=");
		sb.append(driverConvictions);
		sb.append(", driverMedConds=");
		sb.append(driverMedConds);
		sb.append(", ncdYears=");
		sb.append(ncdYears);
		sb.append(", insuredRelation=");
		sb.append(insuredRelation);
		sb.append(", insuredRelationProofFileName=");
		sb.append(insuredRelationProofFileName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public QuotationDrivers toEntityModel() {
		QuotationDriversImpl quotationDriversImpl = new QuotationDriversImpl();

		quotationDriversImpl.setAddDriverId(addDriverId);
		quotationDriversImpl.setQuotationId(quotationId);

		if (driverDob == Long.MIN_VALUE) {
			quotationDriversImpl.setDriverDob(null);
		}
		else {
			quotationDriversImpl.setDriverDob(new Date(driverDob));
		}

		if (driverDobH == null) {
			quotationDriversImpl.setDriverDobH("");
		}
		else {
			quotationDriversImpl.setDriverDobH(driverDobH);
		}

		if (driverGender == null) {
			quotationDriversImpl.setDriverGender("");
		}
		else {
			quotationDriversImpl.setDriverGender(driverGender);
		}

		quotationDriversImpl.setDriverId(driverId);
		quotationDriversImpl.setDriverIdType(driverIdType);

		if (driverName == null) {
			quotationDriversImpl.setDriverName("");
		}
		else {
			quotationDriversImpl.setDriverName(driverName);
		}

		if (driverNationality == null) {
			quotationDriversImpl.setDriverNationality("");
		}
		else {
			quotationDriversImpl.setDriverNationality(driverNationality);
		}

		if (driverOccup == null) {
			quotationDriversImpl.setDriverOccup("");
		}
		else {
			quotationDriversImpl.setDriverOccup(driverOccup);
		}

		quotationDriversImpl.setIsDriverUnder21(isDriverUnder21);

		if (driverEdu == null) {
			quotationDriversImpl.setDriverEdu("");
		}
		else {
			quotationDriversImpl.setDriverEdu(driverEdu);
		}

		if (driverNoChild == null) {
			quotationDriversImpl.setDriverNoChild("");
		}
		else {
			quotationDriversImpl.setDriverNoChild(driverNoChild);
		}

		if (driverMaritalStatus == null) {
			quotationDriversImpl.setDriverMaritalStatus("");
		}
		else {
			quotationDriversImpl.setDriverMaritalStatus(driverMaritalStatus);
		}

		quotationDriversImpl.setDriverNOFault(driverNOFault);
		quotationDriversImpl.setDriverNOClaim(driverNOClaim);

		if (driverConvictions == null) {
			quotationDriversImpl.setDriverConvictions("");
		}
		else {
			quotationDriversImpl.setDriverConvictions(driverConvictions);
		}

		if (driverMedConds == null) {
			quotationDriversImpl.setDriverMedConds("");
		}
		else {
			quotationDriversImpl.setDriverMedConds(driverMedConds);
		}

		quotationDriversImpl.setNcdYears(ncdYears);

		if (insuredRelation == null) {
			quotationDriversImpl.setInsuredRelation("");
		}
		else {
			quotationDriversImpl.setInsuredRelation(insuredRelation);
		}

		if (insuredRelationProofFileName == null) {
			quotationDriversImpl.setInsuredRelationProofFileName("");
		}
		else {
			quotationDriversImpl.setInsuredRelationProofFileName(
				insuredRelationProofFileName);
		}

		quotationDriversImpl.resetOriginalValues();

		return quotationDriversImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		addDriverId = objectInput.readLong();

		quotationId = objectInput.readLong();
		driverDob = objectInput.readLong();
		driverDobH = objectInput.readUTF();
		driverGender = objectInput.readUTF();

		driverId = objectInput.readLong();

		driverIdType = objectInput.readLong();
		driverName = objectInput.readUTF();
		driverNationality = objectInput.readUTF();
		driverOccup = objectInput.readUTF();

		isDriverUnder21 = objectInput.readBoolean();
		driverEdu = objectInput.readUTF();
		driverNoChild = objectInput.readUTF();
		driverMaritalStatus = objectInput.readUTF();

		driverNOFault = objectInput.readLong();

		driverNOClaim = objectInput.readLong();
		driverConvictions = objectInput.readUTF();
		driverMedConds = objectInput.readUTF();

		ncdYears = objectInput.readInt();
		insuredRelation = objectInput.readUTF();
		insuredRelationProofFileName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(addDriverId);

		objectOutput.writeLong(quotationId);
		objectOutput.writeLong(driverDob);

		if (driverDobH == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverDobH);
		}

		if (driverGender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverGender);
		}

		objectOutput.writeLong(driverId);

		objectOutput.writeLong(driverIdType);

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

		if (driverOccup == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverOccup);
		}

		objectOutput.writeBoolean(isDriverUnder21);

		if (driverEdu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverEdu);
		}

		if (driverNoChild == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverNoChild);
		}

		if (driverMaritalStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverMaritalStatus);
		}

		objectOutput.writeLong(driverNOFault);

		objectOutput.writeLong(driverNOClaim);

		if (driverConvictions == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverConvictions);
		}

		if (driverMedConds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverMedConds);
		}

		objectOutput.writeInt(ncdYears);

		if (insuredRelation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredRelation);
		}

		if (insuredRelationProofFileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredRelationProofFileName);
		}
	}

	public long addDriverId;
	public long quotationId;
	public long driverDob;
	public String driverDobH;
	public String driverGender;
	public long driverId;
	public long driverIdType;
	public String driverName;
	public String driverNationality;
	public String driverOccup;
	public boolean isDriverUnder21;
	public String driverEdu;
	public String driverNoChild;
	public String driverMaritalStatus;
	public long driverNOFault;
	public long driverNOClaim;
	public String driverConvictions;
	public String driverMedConds;
	public int ncdYears;
	public String insuredRelation;
	public String insuredRelationProofFileName;

}