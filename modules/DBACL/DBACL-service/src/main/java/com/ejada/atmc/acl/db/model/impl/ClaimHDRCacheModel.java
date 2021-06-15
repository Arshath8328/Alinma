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

import com.ejada.atmc.acl.db.model.ClaimHDR;
import com.ejada.atmc.acl.db.service.persistence.ClaimHDRPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ClaimHDR in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ClaimHDRCacheModel
	implements CacheModel<ClaimHDR>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ClaimHDRCacheModel)) {
			return false;
		}

		ClaimHDRCacheModel claimHDRCacheModel = (ClaimHDRCacheModel)object;

		if (claimHDRPK.equals(claimHDRCacheModel.claimHDRPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, claimHDRPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(81);

		sb.append("{policyNo=");
		sb.append(policyNo);
		sb.append(", claimNo=");
		sb.append(claimNo);
		sb.append(", claimStatus=");
		sb.append(claimStatus);
		sb.append(", iqamaId=");
		sb.append(iqamaId);
		sb.append(", reportType=");
		sb.append(reportType);
		sb.append(", reportNo=");
		sb.append(reportNo);
		sb.append(", enPlateNo=");
		sb.append(enPlateNo);
		sb.append(", enPlateL1=");
		sb.append(enPlateL1);
		sb.append(", enPlateL2=");
		sb.append(enPlateL2);
		sb.append(", enPlateL3=");
		sb.append(enPlateL3);
		sb.append(", arPlateNo=");
		sb.append(arPlateNo);
		sb.append(", arPlateL1=");
		sb.append(arPlateL1);
		sb.append(", arPlateL2=");
		sb.append(arPlateL2);
		sb.append(", arPlateL3=");
		sb.append(arPlateL3);
		sb.append(", natureOfLoss=");
		sb.append(natureOfLoss);
		sb.append(", causeCode=");
		sb.append(causeCode);
		sb.append(", typeOfClaim=");
		sb.append(typeOfClaim);
		sb.append(", claimLossDate=");
		sb.append(claimLossDate);
		sb.append(", lossRemarks=");
		sb.append(lossRemarks);
		sb.append(", faultPercent=");
		sb.append(faultPercent);
		sb.append(", lossLocation=");
		sb.append(lossLocation);
		sb.append(", claimAmount=");
		sb.append(claimAmount);
		sb.append(", claimIntmDate=");
		sb.append(claimIntmDate);
		sb.append(", claimSetlDate=");
		sb.append(claimSetlDate);
		sb.append(", claimantName=");
		sb.append(claimantName);
		sb.append(", driverName=");
		sb.append(driverName);
		sb.append(", claimantPhone=");
		sb.append(claimantPhone);
		sb.append(", iban=");
		sb.append(iban);
		sb.append(", tpDriverName=");
		sb.append(tpDriverName);
		sb.append(", tpAge=");
		sb.append(tpAge);
		sb.append(", tpID=");
		sb.append(tpID);
		sb.append(", tpPlateNo=");
		sb.append(tpPlateNo);
		sb.append(", tpPlateL1=");
		sb.append(tpPlateL1);
		sb.append(", tpPlateL2=");
		sb.append(tpPlateL2);
		sb.append(", tpPlateL3=");
		sb.append(tpPlateL3);
		sb.append(", tpInsuranceCo=");
		sb.append(tpInsuranceCo);
		sb.append(", tpMobileNo=");
		sb.append(tpMobileNo);
		sb.append(", tpNationality=");
		sb.append(tpNationality);
		sb.append(", tpIban=");
		sb.append(tpIban);
		sb.append(", prodCode=");
		sb.append(prodCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ClaimHDR toEntityModel() {
		ClaimHDRImpl claimHDRImpl = new ClaimHDRImpl();

		if (policyNo == null) {
			claimHDRImpl.setPolicyNo("");
		}
		else {
			claimHDRImpl.setPolicyNo(policyNo);
		}

		if (claimNo == null) {
			claimHDRImpl.setClaimNo("");
		}
		else {
			claimHDRImpl.setClaimNo(claimNo);
		}

		if (claimStatus == null) {
			claimHDRImpl.setClaimStatus("");
		}
		else {
			claimHDRImpl.setClaimStatus(claimStatus);
		}

		if (iqamaId == null) {
			claimHDRImpl.setIqamaId("");
		}
		else {
			claimHDRImpl.setIqamaId(iqamaId);
		}

		if (reportType == null) {
			claimHDRImpl.setReportType("");
		}
		else {
			claimHDRImpl.setReportType(reportType);
		}

		if (reportNo == null) {
			claimHDRImpl.setReportNo("");
		}
		else {
			claimHDRImpl.setReportNo(reportNo);
		}

		if (enPlateNo == null) {
			claimHDRImpl.setEnPlateNo("");
		}
		else {
			claimHDRImpl.setEnPlateNo(enPlateNo);
		}

		if (enPlateL1 == null) {
			claimHDRImpl.setEnPlateL1("");
		}
		else {
			claimHDRImpl.setEnPlateL1(enPlateL1);
		}

		if (enPlateL2 == null) {
			claimHDRImpl.setEnPlateL2("");
		}
		else {
			claimHDRImpl.setEnPlateL2(enPlateL2);
		}

		if (enPlateL3 == null) {
			claimHDRImpl.setEnPlateL3("");
		}
		else {
			claimHDRImpl.setEnPlateL3(enPlateL3);
		}

		if (arPlateNo == null) {
			claimHDRImpl.setArPlateNo("");
		}
		else {
			claimHDRImpl.setArPlateNo(arPlateNo);
		}

		if (arPlateL1 == null) {
			claimHDRImpl.setArPlateL1("");
		}
		else {
			claimHDRImpl.setArPlateL1(arPlateL1);
		}

		if (arPlateL2 == null) {
			claimHDRImpl.setArPlateL2("");
		}
		else {
			claimHDRImpl.setArPlateL2(arPlateL2);
		}

		if (arPlateL3 == null) {
			claimHDRImpl.setArPlateL3("");
		}
		else {
			claimHDRImpl.setArPlateL3(arPlateL3);
		}

		if (natureOfLoss == null) {
			claimHDRImpl.setNatureOfLoss("");
		}
		else {
			claimHDRImpl.setNatureOfLoss(natureOfLoss);
		}

		if (causeCode == null) {
			claimHDRImpl.setCauseCode("");
		}
		else {
			claimHDRImpl.setCauseCode(causeCode);
		}

		if (typeOfClaim == null) {
			claimHDRImpl.setTypeOfClaim("");
		}
		else {
			claimHDRImpl.setTypeOfClaim(typeOfClaim);
		}

		if (claimLossDate == Long.MIN_VALUE) {
			claimHDRImpl.setClaimLossDate(null);
		}
		else {
			claimHDRImpl.setClaimLossDate(new Date(claimLossDate));
		}

		if (lossRemarks == null) {
			claimHDRImpl.setLossRemarks("");
		}
		else {
			claimHDRImpl.setLossRemarks(lossRemarks);
		}

		if (faultPercent == null) {
			claimHDRImpl.setFaultPercent("");
		}
		else {
			claimHDRImpl.setFaultPercent(faultPercent);
		}

		if (lossLocation == null) {
			claimHDRImpl.setLossLocation("");
		}
		else {
			claimHDRImpl.setLossLocation(lossLocation);
		}

		if (claimAmount == null) {
			claimHDRImpl.setClaimAmount("");
		}
		else {
			claimHDRImpl.setClaimAmount(claimAmount);
		}

		if (claimIntmDate == Long.MIN_VALUE) {
			claimHDRImpl.setClaimIntmDate(null);
		}
		else {
			claimHDRImpl.setClaimIntmDate(new Date(claimIntmDate));
		}

		if (claimSetlDate == Long.MIN_VALUE) {
			claimHDRImpl.setClaimSetlDate(null);
		}
		else {
			claimHDRImpl.setClaimSetlDate(new Date(claimSetlDate));
		}

		if (claimantName == null) {
			claimHDRImpl.setClaimantName("");
		}
		else {
			claimHDRImpl.setClaimantName(claimantName);
		}

		if (driverName == null) {
			claimHDRImpl.setDriverName("");
		}
		else {
			claimHDRImpl.setDriverName(driverName);
		}

		if (claimantPhone == null) {
			claimHDRImpl.setClaimantPhone("");
		}
		else {
			claimHDRImpl.setClaimantPhone(claimantPhone);
		}

		if (iban == null) {
			claimHDRImpl.setIban("");
		}
		else {
			claimHDRImpl.setIban(iban);
		}

		if (tpDriverName == null) {
			claimHDRImpl.setTpDriverName("");
		}
		else {
			claimHDRImpl.setTpDriverName(tpDriverName);
		}

		if (tpAge == null) {
			claimHDRImpl.setTpAge("");
		}
		else {
			claimHDRImpl.setTpAge(tpAge);
		}

		if (tpID == null) {
			claimHDRImpl.setTpID("");
		}
		else {
			claimHDRImpl.setTpID(tpID);
		}

		if (tpPlateNo == null) {
			claimHDRImpl.setTpPlateNo("");
		}
		else {
			claimHDRImpl.setTpPlateNo(tpPlateNo);
		}

		if (tpPlateL1 == null) {
			claimHDRImpl.setTpPlateL1("");
		}
		else {
			claimHDRImpl.setTpPlateL1(tpPlateL1);
		}

		if (tpPlateL2 == null) {
			claimHDRImpl.setTpPlateL2("");
		}
		else {
			claimHDRImpl.setTpPlateL2(tpPlateL2);
		}

		if (tpPlateL3 == null) {
			claimHDRImpl.setTpPlateL3("");
		}
		else {
			claimHDRImpl.setTpPlateL3(tpPlateL3);
		}

		if (tpInsuranceCo == null) {
			claimHDRImpl.setTpInsuranceCo("");
		}
		else {
			claimHDRImpl.setTpInsuranceCo(tpInsuranceCo);
		}

		if (tpMobileNo == null) {
			claimHDRImpl.setTpMobileNo("");
		}
		else {
			claimHDRImpl.setTpMobileNo(tpMobileNo);
		}

		if (tpNationality == null) {
			claimHDRImpl.setTpNationality("");
		}
		else {
			claimHDRImpl.setTpNationality(tpNationality);
		}

		if (tpIban == null) {
			claimHDRImpl.setTpIban("");
		}
		else {
			claimHDRImpl.setTpIban(tpIban);
		}

		if (prodCode == null) {
			claimHDRImpl.setProdCode("");
		}
		else {
			claimHDRImpl.setProdCode(prodCode);
		}

		claimHDRImpl.resetOriginalValues();

		return claimHDRImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		policyNo = objectInput.readUTF();
		claimNo = objectInput.readUTF();
		claimStatus = objectInput.readUTF();
		iqamaId = objectInput.readUTF();
		reportType = objectInput.readUTF();
		reportNo = objectInput.readUTF();
		enPlateNo = objectInput.readUTF();
		enPlateL1 = objectInput.readUTF();
		enPlateL2 = objectInput.readUTF();
		enPlateL3 = objectInput.readUTF();
		arPlateNo = objectInput.readUTF();
		arPlateL1 = objectInput.readUTF();
		arPlateL2 = objectInput.readUTF();
		arPlateL3 = objectInput.readUTF();
		natureOfLoss = objectInput.readUTF();
		causeCode = objectInput.readUTF();
		typeOfClaim = objectInput.readUTF();
		claimLossDate = objectInput.readLong();
		lossRemarks = objectInput.readUTF();
		faultPercent = objectInput.readUTF();
		lossLocation = objectInput.readUTF();
		claimAmount = objectInput.readUTF();
		claimIntmDate = objectInput.readLong();
		claimSetlDate = objectInput.readLong();
		claimantName = objectInput.readUTF();
		driverName = objectInput.readUTF();
		claimantPhone = objectInput.readUTF();
		iban = objectInput.readUTF();
		tpDriverName = objectInput.readUTF();
		tpAge = objectInput.readUTF();
		tpID = objectInput.readUTF();
		tpPlateNo = objectInput.readUTF();
		tpPlateL1 = objectInput.readUTF();
		tpPlateL2 = objectInput.readUTF();
		tpPlateL3 = objectInput.readUTF();
		tpInsuranceCo = objectInput.readUTF();
		tpMobileNo = objectInput.readUTF();
		tpNationality = objectInput.readUTF();
		tpIban = objectInput.readUTF();
		prodCode = objectInput.readUTF();

		claimHDRPK = new ClaimHDRPK(policyNo, claimNo);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (policyNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyNo);
		}

		if (claimNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(claimNo);
		}

		if (claimStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(claimStatus);
		}

		if (iqamaId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(iqamaId);
		}

		if (reportType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reportType);
		}

		if (reportNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reportNo);
		}

		if (enPlateNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(enPlateNo);
		}

		if (enPlateL1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(enPlateL1);
		}

		if (enPlateL2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(enPlateL2);
		}

		if (enPlateL3 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(enPlateL3);
		}

		if (arPlateNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(arPlateNo);
		}

		if (arPlateL1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(arPlateL1);
		}

		if (arPlateL2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(arPlateL2);
		}

		if (arPlateL3 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(arPlateL3);
		}

		if (natureOfLoss == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(natureOfLoss);
		}

		if (causeCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(causeCode);
		}

		if (typeOfClaim == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(typeOfClaim);
		}

		objectOutput.writeLong(claimLossDate);

		if (lossRemarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lossRemarks);
		}

		if (faultPercent == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(faultPercent);
		}

		if (lossLocation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lossLocation);
		}

		if (claimAmount == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(claimAmount);
		}

		objectOutput.writeLong(claimIntmDate);
		objectOutput.writeLong(claimSetlDate);

		if (claimantName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(claimantName);
		}

		if (driverName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverName);
		}

		if (claimantPhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(claimantPhone);
		}

		if (iban == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(iban);
		}

		if (tpDriverName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tpDriverName);
		}

		if (tpAge == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tpAge);
		}

		if (tpID == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tpID);
		}

		if (tpPlateNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tpPlateNo);
		}

		if (tpPlateL1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tpPlateL1);
		}

		if (tpPlateL2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tpPlateL2);
		}

		if (tpPlateL3 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tpPlateL3);
		}

		if (tpInsuranceCo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tpInsuranceCo);
		}

		if (tpMobileNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tpMobileNo);
		}

		if (tpNationality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tpNationality);
		}

		if (tpIban == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tpIban);
		}

		if (prodCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prodCode);
		}
	}

	public String policyNo;
	public String claimNo;
	public String claimStatus;
	public String iqamaId;
	public String reportType;
	public String reportNo;
	public String enPlateNo;
	public String enPlateL1;
	public String enPlateL2;
	public String enPlateL3;
	public String arPlateNo;
	public String arPlateL1;
	public String arPlateL2;
	public String arPlateL3;
	public String natureOfLoss;
	public String causeCode;
	public String typeOfClaim;
	public long claimLossDate;
	public String lossRemarks;
	public String faultPercent;
	public String lossLocation;
	public String claimAmount;
	public long claimIntmDate;
	public long claimSetlDate;
	public String claimantName;
	public String driverName;
	public String claimantPhone;
	public String iban;
	public String tpDriverName;
	public String tpAge;
	public String tpID;
	public String tpPlateNo;
	public String tpPlateL1;
	public String tpPlateL2;
	public String tpPlateL3;
	public String tpInsuranceCo;
	public String tpMobileNo;
	public String tpNationality;
	public String tpIban;
	public String prodCode;
	public transient ClaimHDRPK claimHDRPK;

}