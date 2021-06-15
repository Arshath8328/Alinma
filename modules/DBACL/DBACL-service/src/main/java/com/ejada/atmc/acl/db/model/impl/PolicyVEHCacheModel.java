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

import com.ejada.atmc.acl.db.model.PolicyVEH;
import com.ejada.atmc.acl.db.service.persistence.PolicyVEHPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PolicyVEH in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PolicyVEHCacheModel
	implements CacheModel<PolicyVEH>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PolicyVEHCacheModel)) {
			return false;
		}

		PolicyVEHCacheModel policyVEHCacheModel = (PolicyVEHCacheModel)object;

		if (policyVEHPK.equals(policyVEHCacheModel.policyVEHPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, policyVEHPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(65);

		sb.append("{policyNo=");
		sb.append(policyNo);
		sb.append(", vehId=");
		sb.append(vehId);
		sb.append(", vehicleDefType=");
		sb.append(vehicleDefType);
		sb.append(", vehicleSeqCustom=");
		sb.append(vehicleSeqCustom);
		sb.append(", chassisNo=");
		sb.append(chassisNo);
		sb.append(", bodyType=");
		sb.append(bodyType);
		sb.append(", make=");
		sb.append(make);
		sb.append(", vehModel=");
		sb.append(vehModel);
		sb.append(", mfgYear=");
		sb.append(mfgYear);
		sb.append(", color=");
		sb.append(color);
		sb.append(", agencyRepair=");
		sb.append(agencyRepair);
		sb.append(", noofPassengers=");
		sb.append(noofPassengers);
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
		sb.append(", deductible=");
		sb.append(deductible);
		sb.append(", vehicleValue=");
		sb.append(vehicleValue);
		sb.append(", premium=");
		sb.append(premium);
		sb.append(", discounts=");
		sb.append(discounts);
		sb.append(", loading=");
		sb.append(loading);
		sb.append(", totalPremium=");
		sb.append(totalPremium);
		sb.append(", noofClaimFreeYears=");
		sb.append(noofClaimFreeYears);
		sb.append(", useOfCehicle=");
		sb.append(useOfCehicle);
		sb.append(", najmPlateType=");
		sb.append(najmPlateType);
		sb.append(", najmStatus=");
		sb.append(najmStatus);
		sb.append(", estemaraExpiryDate=");
		sb.append(estemaraExpiryDate);
		sb.append(", geoLocation=");
		sb.append(geoLocation);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PolicyVEH toEntityModel() {
		PolicyVEHImpl policyVEHImpl = new PolicyVEHImpl();

		if (policyNo == null) {
			policyVEHImpl.setPolicyNo("");
		}
		else {
			policyVEHImpl.setPolicyNo(policyNo);
		}

		if (vehId == null) {
			policyVEHImpl.setVehId("");
		}
		else {
			policyVEHImpl.setVehId(vehId);
		}

		if (vehicleDefType == null) {
			policyVEHImpl.setVehicleDefType("");
		}
		else {
			policyVEHImpl.setVehicleDefType(vehicleDefType);
		}

		if (vehicleSeqCustom == null) {
			policyVEHImpl.setVehicleSeqCustom("");
		}
		else {
			policyVEHImpl.setVehicleSeqCustom(vehicleSeqCustom);
		}

		if (chassisNo == null) {
			policyVEHImpl.setChassisNo("");
		}
		else {
			policyVEHImpl.setChassisNo(chassisNo);
		}

		if (bodyType == null) {
			policyVEHImpl.setBodyType("");
		}
		else {
			policyVEHImpl.setBodyType(bodyType);
		}

		if (make == null) {
			policyVEHImpl.setMake("");
		}
		else {
			policyVEHImpl.setMake(make);
		}

		if (vehModel == null) {
			policyVEHImpl.setVehModel("");
		}
		else {
			policyVEHImpl.setVehModel(vehModel);
		}

		policyVEHImpl.setMfgYear(mfgYear);

		if (color == null) {
			policyVEHImpl.setColor("");
		}
		else {
			policyVEHImpl.setColor(color);
		}

		if (agencyRepair == null) {
			policyVEHImpl.setAgencyRepair("");
		}
		else {
			policyVEHImpl.setAgencyRepair(agencyRepair);
		}

		policyVEHImpl.setNoofPassengers(noofPassengers);
		policyVEHImpl.setEnPlateNo(enPlateNo);

		if (enPlateL1 == null) {
			policyVEHImpl.setEnPlateL1("");
		}
		else {
			policyVEHImpl.setEnPlateL1(enPlateL1);
		}

		if (enPlateL2 == null) {
			policyVEHImpl.setEnPlateL2("");
		}
		else {
			policyVEHImpl.setEnPlateL2(enPlateL2);
		}

		if (enPlateL3 == null) {
			policyVEHImpl.setEnPlateL3("");
		}
		else {
			policyVEHImpl.setEnPlateL3(enPlateL3);
		}

		if (arPlateNo == null) {
			policyVEHImpl.setArPlateNo("");
		}
		else {
			policyVEHImpl.setArPlateNo(arPlateNo);
		}

		if (arPlateL1 == null) {
			policyVEHImpl.setArPlateL1("");
		}
		else {
			policyVEHImpl.setArPlateL1(arPlateL1);
		}

		if (arPlateL2 == null) {
			policyVEHImpl.setArPlateL2("");
		}
		else {
			policyVEHImpl.setArPlateL2(arPlateL2);
		}

		if (arPlateL3 == null) {
			policyVEHImpl.setArPlateL3("");
		}
		else {
			policyVEHImpl.setArPlateL3(arPlateL3);
		}

		policyVEHImpl.setDeductible(deductible);
		policyVEHImpl.setVehicleValue(vehicleValue);
		policyVEHImpl.setPremium(premium);
		policyVEHImpl.setDiscounts(discounts);
		policyVEHImpl.setLoading(loading);
		policyVEHImpl.setTotalPremium(totalPremium);
		policyVEHImpl.setNoofClaimFreeYears(noofClaimFreeYears);

		if (useOfCehicle == null) {
			policyVEHImpl.setUseOfCehicle("");
		}
		else {
			policyVEHImpl.setUseOfCehicle(useOfCehicle);
		}

		if (najmPlateType == null) {
			policyVEHImpl.setNajmPlateType("");
		}
		else {
			policyVEHImpl.setNajmPlateType(najmPlateType);
		}

		if (najmStatus == null) {
			policyVEHImpl.setNajmStatus("");
		}
		else {
			policyVEHImpl.setNajmStatus(najmStatus);
		}

		if (estemaraExpiryDate == null) {
			policyVEHImpl.setEstemaraExpiryDate("");
		}
		else {
			policyVEHImpl.setEstemaraExpiryDate(estemaraExpiryDate);
		}

		if (geoLocation == null) {
			policyVEHImpl.setGeoLocation("");
		}
		else {
			policyVEHImpl.setGeoLocation(geoLocation);
		}

		policyVEHImpl.resetOriginalValues();

		return policyVEHImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		policyNo = objectInput.readUTF();
		vehId = objectInput.readUTF();
		vehicleDefType = objectInput.readUTF();
		vehicleSeqCustom = objectInput.readUTF();
		chassisNo = objectInput.readUTF();
		bodyType = objectInput.readUTF();
		make = objectInput.readUTF();
		vehModel = objectInput.readUTF();

		mfgYear = objectInput.readLong();
		color = objectInput.readUTF();
		agencyRepair = objectInput.readUTF();

		noofPassengers = objectInput.readLong();

		enPlateNo = objectInput.readLong();
		enPlateL1 = objectInput.readUTF();
		enPlateL2 = objectInput.readUTF();
		enPlateL3 = objectInput.readUTF();
		arPlateNo = objectInput.readUTF();
		arPlateL1 = objectInput.readUTF();
		arPlateL2 = objectInput.readUTF();
		arPlateL3 = objectInput.readUTF();

		deductible = objectInput.readLong();

		vehicleValue = objectInput.readLong();

		premium = objectInput.readLong();

		discounts = objectInput.readLong();

		loading = objectInput.readLong();

		totalPremium = objectInput.readLong();

		noofClaimFreeYears = objectInput.readLong();
		useOfCehicle = objectInput.readUTF();
		najmPlateType = objectInput.readUTF();
		najmStatus = objectInput.readUTF();
		estemaraExpiryDate = objectInput.readUTF();
		geoLocation = objectInput.readUTF();

		policyVEHPK = new PolicyVEHPK(policyNo, vehId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (policyNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyNo);
		}

		if (vehId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehId);
		}

		if (vehicleDefType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleDefType);
		}

		if (vehicleSeqCustom == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleSeqCustom);
		}

		if (chassisNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(chassisNo);
		}

		if (bodyType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bodyType);
		}

		if (make == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(make);
		}

		if (vehModel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehModel);
		}

		objectOutput.writeLong(mfgYear);

		if (color == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(color);
		}

		if (agencyRepair == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(agencyRepair);
		}

		objectOutput.writeLong(noofPassengers);

		objectOutput.writeLong(enPlateNo);

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

		objectOutput.writeLong(deductible);

		objectOutput.writeLong(vehicleValue);

		objectOutput.writeLong(premium);

		objectOutput.writeLong(discounts);

		objectOutput.writeLong(loading);

		objectOutput.writeLong(totalPremium);

		objectOutput.writeLong(noofClaimFreeYears);

		if (useOfCehicle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(useOfCehicle);
		}

		if (najmPlateType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(najmPlateType);
		}

		if (najmStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(najmStatus);
		}

		if (estemaraExpiryDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(estemaraExpiryDate);
		}

		if (geoLocation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(geoLocation);
		}
	}

	public String policyNo;
	public String vehId;
	public String vehicleDefType;
	public String vehicleSeqCustom;
	public String chassisNo;
	public String bodyType;
	public String make;
	public String vehModel;
	public long mfgYear;
	public String color;
	public String agencyRepair;
	public long noofPassengers;
	public long enPlateNo;
	public String enPlateL1;
	public String enPlateL2;
	public String enPlateL3;
	public String arPlateNo;
	public String arPlateL1;
	public String arPlateL2;
	public String arPlateL3;
	public long deductible;
	public long vehicleValue;
	public long premium;
	public long discounts;
	public long loading;
	public long totalPremium;
	public long noofClaimFreeYears;
	public String useOfCehicle;
	public String najmPlateType;
	public String najmStatus;
	public String estemaraExpiryDate;
	public String geoLocation;
	public transient PolicyVEHPK policyVEHPK;

}