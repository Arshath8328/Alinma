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

import com.ejada.atmc.acl.db.model.ClaimODSearch;
import com.ejada.atmc.acl.db.service.persistence.ClaimODSearchPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ClaimODSearch in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ClaimODSearchCacheModel
	implements CacheModel<ClaimODSearch>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ClaimODSearchCacheModel)) {
			return false;
		}

		ClaimODSearchCacheModel claimODSearchCacheModel =
			(ClaimODSearchCacheModel)object;

		if (claimODSearchPK.equals(claimODSearchCacheModel.claimODSearchPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, claimODSearchPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{policyNo=");
		sb.append(policyNo);
		sb.append(", reportNo=");
		sb.append(reportNo);
		sb.append(", vehicleSEQCustom=");
		sb.append(vehicleSEQCustom);
		sb.append(", vehicleDevType=");
		sb.append(vehicleDevType);
		sb.append(", natureofLoss=");
		sb.append(natureofLoss);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ClaimODSearch toEntityModel() {
		ClaimODSearchImpl claimODSearchImpl = new ClaimODSearchImpl();

		if (policyNo == null) {
			claimODSearchImpl.setPolicyNo("");
		}
		else {
			claimODSearchImpl.setPolicyNo(policyNo);
		}

		if (reportNo == null) {
			claimODSearchImpl.setReportNo("");
		}
		else {
			claimODSearchImpl.setReportNo(reportNo);
		}

		if (vehicleSEQCustom == null) {
			claimODSearchImpl.setVehicleSEQCustom("");
		}
		else {
			claimODSearchImpl.setVehicleSEQCustom(vehicleSEQCustom);
		}

		if (vehicleDevType == null) {
			claimODSearchImpl.setVehicleDevType("");
		}
		else {
			claimODSearchImpl.setVehicleDevType(vehicleDevType);
		}

		if (natureofLoss == null) {
			claimODSearchImpl.setNatureofLoss("");
		}
		else {
			claimODSearchImpl.setNatureofLoss(natureofLoss);
		}

		if (causeCode == null) {
			claimODSearchImpl.setCauseCode("");
		}
		else {
			claimODSearchImpl.setCauseCode(causeCode);
		}

		if (typeOfClaim == null) {
			claimODSearchImpl.setTypeOfClaim("");
		}
		else {
			claimODSearchImpl.setTypeOfClaim(typeOfClaim);
		}

		if (claimLossDate == Long.MIN_VALUE) {
			claimODSearchImpl.setClaimLossDate(null);
		}
		else {
			claimODSearchImpl.setClaimLossDate(new Date(claimLossDate));
		}

		if (lossRemarks == null) {
			claimODSearchImpl.setLossRemarks("");
		}
		else {
			claimODSearchImpl.setLossRemarks(lossRemarks);
		}

		if (faultPercent == null) {
			claimODSearchImpl.setFaultPercent("");
		}
		else {
			claimODSearchImpl.setFaultPercent(faultPercent);
		}

		claimODSearchImpl.resetOriginalValues();

		return claimODSearchImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		policyNo = objectInput.readUTF();
		reportNo = objectInput.readUTF();
		vehicleSEQCustom = objectInput.readUTF();
		vehicleDevType = objectInput.readUTF();
		natureofLoss = objectInput.readUTF();
		causeCode = objectInput.readUTF();
		typeOfClaim = objectInput.readUTF();
		claimLossDate = objectInput.readLong();
		lossRemarks = objectInput.readUTF();
		faultPercent = objectInput.readUTF();

		claimODSearchPK = new ClaimODSearchPK(
			policyNo, reportNo, vehicleSEQCustom);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (policyNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyNo);
		}

		if (reportNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reportNo);
		}

		if (vehicleSEQCustom == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleSEQCustom);
		}

		if (vehicleDevType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleDevType);
		}

		if (natureofLoss == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(natureofLoss);
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
	}

	public String policyNo;
	public String reportNo;
	public String vehicleSEQCustom;
	public String vehicleDevType;
	public String natureofLoss;
	public String causeCode;
	public String typeOfClaim;
	public long claimLossDate;
	public String lossRemarks;
	public String faultPercent;
	public transient ClaimODSearchPK claimODSearchPK;

}