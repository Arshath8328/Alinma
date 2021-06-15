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

import com.ejada.atmc.acl.db.model.PolicyVehDrv;
import com.ejada.atmc.acl.db.service.persistence.PolicyVehDrvPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PolicyVehDrv in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PolicyVehDrvCacheModel
	implements CacheModel<PolicyVehDrv>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PolicyVehDrvCacheModel)) {
			return false;
		}

		PolicyVehDrvCacheModel policyVehDrvCacheModel =
			(PolicyVehDrvCacheModel)object;

		if (policyVehDrvPK.equals(policyVehDrvCacheModel.policyVehDrvPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, policyVehDrvPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{policyNo=");
		sb.append(policyNo);
		sb.append(", vehId=");
		sb.append(vehId);
		sb.append(", driverLicenseNo=");
		sb.append(driverLicenseNo);
		sb.append(", driverName=");
		sb.append(driverName);
		sb.append(", driverBirthDate=");
		sb.append(driverBirthDate);
		sb.append(", driverNationality=");
		sb.append(driverNationality);
		sb.append(", driverGender=");
		sb.append(driverGender);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PolicyVehDrv toEntityModel() {
		PolicyVehDrvImpl policyVehDrvImpl = new PolicyVehDrvImpl();

		if (policyNo == null) {
			policyVehDrvImpl.setPolicyNo("");
		}
		else {
			policyVehDrvImpl.setPolicyNo(policyNo);
		}

		policyVehDrvImpl.setVehId(vehId);

		if (driverLicenseNo == null) {
			policyVehDrvImpl.setDriverLicenseNo("");
		}
		else {
			policyVehDrvImpl.setDriverLicenseNo(driverLicenseNo);
		}

		if (driverName == null) {
			policyVehDrvImpl.setDriverName("");
		}
		else {
			policyVehDrvImpl.setDriverName(driverName);
		}

		if (driverBirthDate == Long.MIN_VALUE) {
			policyVehDrvImpl.setDriverBirthDate(null);
		}
		else {
			policyVehDrvImpl.setDriverBirthDate(new Date(driverBirthDate));
		}

		if (driverNationality == null) {
			policyVehDrvImpl.setDriverNationality("");
		}
		else {
			policyVehDrvImpl.setDriverNationality(driverNationality);
		}

		if (driverGender == null) {
			policyVehDrvImpl.setDriverGender("");
		}
		else {
			policyVehDrvImpl.setDriverGender(driverGender);
		}

		policyVehDrvImpl.resetOriginalValues();

		return policyVehDrvImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		policyNo = objectInput.readUTF();

		vehId = objectInput.readLong();
		driverLicenseNo = objectInput.readUTF();
		driverName = objectInput.readUTF();
		driverBirthDate = objectInput.readLong();
		driverNationality = objectInput.readUTF();
		driverGender = objectInput.readUTF();

		policyVehDrvPK = new PolicyVehDrvPK(policyNo, vehId, driverLicenseNo);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (policyNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyNo);
		}

		objectOutput.writeLong(vehId);

		if (driverLicenseNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverLicenseNo);
		}

		if (driverName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverName);
		}

		objectOutput.writeLong(driverBirthDate);

		if (driverNationality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverNationality);
		}

		if (driverGender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverGender);
		}
	}

	public String policyNo;
	public long vehId;
	public String driverLicenseNo;
	public String driverName;
	public long driverBirthDate;
	public String driverNationality;
	public String driverGender;
	public transient PolicyVehDrvPK policyVehDrvPK;

}