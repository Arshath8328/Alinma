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

import com.ejada.atmc.acl.db.model.PolVEHSearch;
import com.ejada.atmc.acl.db.service.persistence.PolVEHSearchPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PolVEHSearch in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PolVEHSearchCacheModel
	implements CacheModel<PolVEHSearch>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PolVEHSearchCacheModel)) {
			return false;
		}

		PolVEHSearchCacheModel polVEHSearchCacheModel =
			(PolVEHSearchCacheModel)object;

		if (polVEHSearchPK.equals(polVEHSearchCacheModel.polVEHSearchPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, polVEHSearchPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{policyNo=");
		sb.append(policyNo);
		sb.append(", vehicleSEQCustom=");
		sb.append(vehicleSEQCustom);
		sb.append(", chassisNo=");
		sb.append(chassisNo);
		sb.append(", vehicleDevType=");
		sb.append(vehicleDevType);
		sb.append(", inceptionDate=");
		sb.append(inceptionDate);
		sb.append(", expiryDate=");
		sb.append(expiryDate);
		sb.append(", engPlateNo=");
		sb.append(engPlateNo);
		sb.append(", engPlateL1=");
		sb.append(engPlateL1);
		sb.append(", engPlateL2=");
		sb.append(engPlateL2);
		sb.append(", engPlateL3=");
		sb.append(engPlateL3);
		sb.append(", arbPlateNo=");
		sb.append(arbPlateNo);
		sb.append(", arbPlateL1=");
		sb.append(arbPlateL1);
		sb.append(", arbPlateL2=");
		sb.append(arbPlateL2);
		sb.append(", arbPlateL3=");
		sb.append(arbPlateL3);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PolVEHSearch toEntityModel() {
		PolVEHSearchImpl polVEHSearchImpl = new PolVEHSearchImpl();

		if (policyNo == null) {
			polVEHSearchImpl.setPolicyNo("");
		}
		else {
			polVEHSearchImpl.setPolicyNo(policyNo);
		}

		if (vehicleSEQCustom == null) {
			polVEHSearchImpl.setVehicleSEQCustom("");
		}
		else {
			polVEHSearchImpl.setVehicleSEQCustom(vehicleSEQCustom);
		}

		if (chassisNo == null) {
			polVEHSearchImpl.setChassisNo("");
		}
		else {
			polVEHSearchImpl.setChassisNo(chassisNo);
		}

		if (vehicleDevType == null) {
			polVEHSearchImpl.setVehicleDevType("");
		}
		else {
			polVEHSearchImpl.setVehicleDevType(vehicleDevType);
		}

		if (inceptionDate == Long.MIN_VALUE) {
			polVEHSearchImpl.setInceptionDate(null);
		}
		else {
			polVEHSearchImpl.setInceptionDate(new Date(inceptionDate));
		}

		if (expiryDate == Long.MIN_VALUE) {
			polVEHSearchImpl.setExpiryDate(null);
		}
		else {
			polVEHSearchImpl.setExpiryDate(new Date(expiryDate));
		}

		polVEHSearchImpl.setEngPlateNo(engPlateNo);

		if (engPlateL1 == null) {
			polVEHSearchImpl.setEngPlateL1("");
		}
		else {
			polVEHSearchImpl.setEngPlateL1(engPlateL1);
		}

		if (engPlateL2 == null) {
			polVEHSearchImpl.setEngPlateL2("");
		}
		else {
			polVEHSearchImpl.setEngPlateL2(engPlateL2);
		}

		if (engPlateL3 == null) {
			polVEHSearchImpl.setEngPlateL3("");
		}
		else {
			polVEHSearchImpl.setEngPlateL3(engPlateL3);
		}

		if (arbPlateNo == null) {
			polVEHSearchImpl.setArbPlateNo("");
		}
		else {
			polVEHSearchImpl.setArbPlateNo(arbPlateNo);
		}

		if (arbPlateL1 == null) {
			polVEHSearchImpl.setArbPlateL1("");
		}
		else {
			polVEHSearchImpl.setArbPlateL1(arbPlateL1);
		}

		if (arbPlateL2 == null) {
			polVEHSearchImpl.setArbPlateL2("");
		}
		else {
			polVEHSearchImpl.setArbPlateL2(arbPlateL2);
		}

		if (arbPlateL3 == null) {
			polVEHSearchImpl.setArbPlateL3("");
		}
		else {
			polVEHSearchImpl.setArbPlateL3(arbPlateL3);
		}

		polVEHSearchImpl.resetOriginalValues();

		return polVEHSearchImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		policyNo = objectInput.readUTF();
		vehicleSEQCustom = objectInput.readUTF();
		chassisNo = objectInput.readUTF();
		vehicleDevType = objectInput.readUTF();
		inceptionDate = objectInput.readLong();
		expiryDate = objectInput.readLong();

		engPlateNo = objectInput.readLong();
		engPlateL1 = objectInput.readUTF();
		engPlateL2 = objectInput.readUTF();
		engPlateL3 = objectInput.readUTF();
		arbPlateNo = objectInput.readUTF();
		arbPlateL1 = objectInput.readUTF();
		arbPlateL2 = objectInput.readUTF();
		arbPlateL3 = objectInput.readUTF();

		polVEHSearchPK = new PolVEHSearchPK(policyNo, vehicleSEQCustom);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (policyNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyNo);
		}

		if (vehicleSEQCustom == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleSEQCustom);
		}

		if (chassisNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(chassisNo);
		}

		if (vehicleDevType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleDevType);
		}

		objectOutput.writeLong(inceptionDate);
		objectOutput.writeLong(expiryDate);

		objectOutput.writeLong(engPlateNo);

		if (engPlateL1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(engPlateL1);
		}

		if (engPlateL2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(engPlateL2);
		}

		if (engPlateL3 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(engPlateL3);
		}

		if (arbPlateNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(arbPlateNo);
		}

		if (arbPlateL1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(arbPlateL1);
		}

		if (arbPlateL2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(arbPlateL2);
		}

		if (arbPlateL3 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(arbPlateL3);
		}
	}

	public String policyNo;
	public String vehicleSEQCustom;
	public String chassisNo;
	public String vehicleDevType;
	public long inceptionDate;
	public long expiryDate;
	public long engPlateNo;
	public String engPlateL1;
	public String engPlateL2;
	public String engPlateL3;
	public String arbPlateNo;
	public String arbPlateL1;
	public String arbPlateL2;
	public String arbPlateL3;
	public transient PolVEHSearchPK polVEHSearchPK;

}