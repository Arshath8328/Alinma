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

import com.ejada.atmc.acl.db.model.QuotationDriverseEndors;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing QuotationDriverseEndors in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class QuotationDriverseEndorsCacheModel
	implements CacheModel<QuotationDriverseEndors>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof QuotationDriverseEndorsCacheModel)) {
			return false;
		}

		QuotationDriverseEndorsCacheModel quotationDriverseEndorsCacheModel =
			(QuotationDriverseEndorsCacheModel)object;

		if (addDriverId == quotationDriverseEndorsCacheModel.addDriverId) {
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
		StringBundler sb = new StringBundler(69);

		sb.append("{addDriverId=");
		sb.append(addDriverId);
		sb.append(", quotationId=");
		sb.append(quotationId);
		sb.append(", policyNumber=");
		sb.append(policyNumber);
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
		sb.append(", status=");
		sb.append(status);
		sb.append(", requestedDate=");
		sb.append(requestedDate);
		sb.append(", buildNo=");
		sb.append(buildNo);
		sb.append(", zipCode=");
		sb.append(zipCode);
		sb.append(", addNo=");
		sb.append(addNo);
		sb.append(", stNameEn=");
		sb.append(stNameEn);
		sb.append(", stNameAr=");
		sb.append(stNameAr);
		sb.append(", districtEn=");
		sb.append(districtEn);
		sb.append(", districtAr=");
		sb.append(districtAr);
		sb.append(", cityEn=");
		sb.append(cityEn);
		sb.append(", cityAr=");
		sb.append(cityAr);
		sb.append(", isNatAddress=");
		sb.append(isNatAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public QuotationDriverseEndors toEntityModel() {
		QuotationDriverseEndorsImpl quotationDriverseEndorsImpl =
			new QuotationDriverseEndorsImpl();

		quotationDriverseEndorsImpl.setAddDriverId(addDriverId);
		quotationDriverseEndorsImpl.setQuotationId(quotationId);

		if (policyNumber == null) {
			quotationDriverseEndorsImpl.setPolicyNumber("");
		}
		else {
			quotationDriverseEndorsImpl.setPolicyNumber(policyNumber);
		}

		if (driverDob == Long.MIN_VALUE) {
			quotationDriverseEndorsImpl.setDriverDob(null);
		}
		else {
			quotationDriverseEndorsImpl.setDriverDob(new Date(driverDob));
		}

		if (driverDobH == null) {
			quotationDriverseEndorsImpl.setDriverDobH("");
		}
		else {
			quotationDriverseEndorsImpl.setDriverDobH(driverDobH);
		}

		if (driverGender == null) {
			quotationDriverseEndorsImpl.setDriverGender("");
		}
		else {
			quotationDriverseEndorsImpl.setDriverGender(driverGender);
		}

		if (driverId == null) {
			quotationDriverseEndorsImpl.setDriverId("");
		}
		else {
			quotationDriverseEndorsImpl.setDriverId(driverId);
		}

		quotationDriverseEndorsImpl.setDriverIdType(driverIdType);

		if (driverName == null) {
			quotationDriverseEndorsImpl.setDriverName("");
		}
		else {
			quotationDriverseEndorsImpl.setDriverName(driverName);
		}

		if (driverNationality == null) {
			quotationDriverseEndorsImpl.setDriverNationality("");
		}
		else {
			quotationDriverseEndorsImpl.setDriverNationality(driverNationality);
		}

		if (driverOccup == null) {
			quotationDriverseEndorsImpl.setDriverOccup("");
		}
		else {
			quotationDriverseEndorsImpl.setDriverOccup(driverOccup);
		}

		quotationDriverseEndorsImpl.setIsDriverUnder21(isDriverUnder21);

		if (driverEdu == null) {
			quotationDriverseEndorsImpl.setDriverEdu("");
		}
		else {
			quotationDriverseEndorsImpl.setDriverEdu(driverEdu);
		}

		if (driverNoChild == null) {
			quotationDriverseEndorsImpl.setDriverNoChild("");
		}
		else {
			quotationDriverseEndorsImpl.setDriverNoChild(driverNoChild);
		}

		if (driverMaritalStatus == null) {
			quotationDriverseEndorsImpl.setDriverMaritalStatus("");
		}
		else {
			quotationDriverseEndorsImpl.setDriverMaritalStatus(
				driverMaritalStatus);
		}

		quotationDriverseEndorsImpl.setDriverNOFault(driverNOFault);
		quotationDriverseEndorsImpl.setDriverNOClaim(driverNOClaim);

		if (driverConvictions == null) {
			quotationDriverseEndorsImpl.setDriverConvictions("");
		}
		else {
			quotationDriverseEndorsImpl.setDriverConvictions(driverConvictions);
		}

		if (driverMedConds == null) {
			quotationDriverseEndorsImpl.setDriverMedConds("");
		}
		else {
			quotationDriverseEndorsImpl.setDriverMedConds(driverMedConds);
		}

		quotationDriverseEndorsImpl.setNcdYears(ncdYears);

		if (insuredRelation == null) {
			quotationDriverseEndorsImpl.setInsuredRelation("");
		}
		else {
			quotationDriverseEndorsImpl.setInsuredRelation(insuredRelation);
		}

		if (insuredRelationProofFileName == null) {
			quotationDriverseEndorsImpl.setInsuredRelationProofFileName("");
		}
		else {
			quotationDriverseEndorsImpl.setInsuredRelationProofFileName(
				insuredRelationProofFileName);
		}

		if (status == null) {
			quotationDriverseEndorsImpl.setStatus("");
		}
		else {
			quotationDriverseEndorsImpl.setStatus(status);
		}

		if (requestedDate == Long.MIN_VALUE) {
			quotationDriverseEndorsImpl.setRequestedDate(null);
		}
		else {
			quotationDriverseEndorsImpl.setRequestedDate(
				new Date(requestedDate));
		}

		if (buildNo == null) {
			quotationDriverseEndorsImpl.setBuildNo("");
		}
		else {
			quotationDriverseEndorsImpl.setBuildNo(buildNo);
		}

		if (zipCode == null) {
			quotationDriverseEndorsImpl.setZipCode("");
		}
		else {
			quotationDriverseEndorsImpl.setZipCode(zipCode);
		}

		if (addNo == null) {
			quotationDriverseEndorsImpl.setAddNo("");
		}
		else {
			quotationDriverseEndorsImpl.setAddNo(addNo);
		}

		if (stNameEn == null) {
			quotationDriverseEndorsImpl.setStNameEn("");
		}
		else {
			quotationDriverseEndorsImpl.setStNameEn(stNameEn);
		}

		if (stNameAr == null) {
			quotationDriverseEndorsImpl.setStNameAr("");
		}
		else {
			quotationDriverseEndorsImpl.setStNameAr(stNameAr);
		}

		if (districtEn == null) {
			quotationDriverseEndorsImpl.setDistrictEn("");
		}
		else {
			quotationDriverseEndorsImpl.setDistrictEn(districtEn);
		}

		if (districtAr == null) {
			quotationDriverseEndorsImpl.setDistrictAr("");
		}
		else {
			quotationDriverseEndorsImpl.setDistrictAr(districtAr);
		}

		if (cityEn == null) {
			quotationDriverseEndorsImpl.setCityEn("");
		}
		else {
			quotationDriverseEndorsImpl.setCityEn(cityEn);
		}

		if (cityAr == null) {
			quotationDriverseEndorsImpl.setCityAr("");
		}
		else {
			quotationDriverseEndorsImpl.setCityAr(cityAr);
		}

		quotationDriverseEndorsImpl.setIsNatAddress(isNatAddress);

		quotationDriverseEndorsImpl.resetOriginalValues();

		return quotationDriverseEndorsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		addDriverId = objectInput.readLong();

		quotationId = objectInput.readLong();
		policyNumber = objectInput.readUTF();
		driverDob = objectInput.readLong();
		driverDobH = objectInput.readUTF();
		driverGender = objectInput.readUTF();
		driverId = objectInput.readUTF();

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
		status = objectInput.readUTF();
		requestedDate = objectInput.readLong();
		buildNo = objectInput.readUTF();
		zipCode = objectInput.readUTF();
		addNo = objectInput.readUTF();
		stNameEn = objectInput.readUTF();
		stNameAr = objectInput.readUTF();
		districtEn = objectInput.readUTF();
		districtAr = objectInput.readUTF();
		cityEn = objectInput.readUTF();
		cityAr = objectInput.readUTF();

		isNatAddress = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(addDriverId);

		objectOutput.writeLong(quotationId);

		if (policyNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyNumber);
		}

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

		if (driverId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverId);
		}

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

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(requestedDate);

		if (buildNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(buildNo);
		}

		if (zipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zipCode);
		}

		if (addNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addNo);
		}

		if (stNameEn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stNameEn);
		}

		if (stNameAr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stNameAr);
		}

		if (districtEn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(districtEn);
		}

		if (districtAr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(districtAr);
		}

		if (cityEn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cityEn);
		}

		if (cityAr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cityAr);
		}

		objectOutput.writeBoolean(isNatAddress);
	}

	public long addDriverId;
	public long quotationId;
	public String policyNumber;
	public long driverDob;
	public String driverDobH;
	public String driverGender;
	public String driverId;
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
	public String status;
	public long requestedDate;
	public String buildNo;
	public String zipCode;
	public String addNo;
	public String stNameEn;
	public String stNameAr;
	public String districtEn;
	public String districtAr;
	public String cityEn;
	public String cityAr;
	public boolean isNatAddress;

}