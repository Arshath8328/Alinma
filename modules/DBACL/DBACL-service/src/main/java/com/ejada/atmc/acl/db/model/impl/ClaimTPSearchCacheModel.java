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

import com.ejada.atmc.acl.db.model.ClaimTPSearch;
import com.ejada.atmc.acl.db.service.persistence.ClaimTPSearchPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ClaimTPSearch in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ClaimTPSearchCacheModel
	implements CacheModel<ClaimTPSearch>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ClaimTPSearchCacheModel)) {
			return false;
		}

		ClaimTPSearchCacheModel claimTPSearchCacheModel =
			(ClaimTPSearchCacheModel)object;

		if (claimTPSearchPK.equals(claimTPSearchCacheModel.claimTPSearchPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, claimTPSearchPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{reportNo=");
		sb.append(reportNo);
		sb.append(", tpId=");
		sb.append(tpId);
		sb.append(", tpDriverName=");
		sb.append(tpDriverName);
		sb.append(", tpAge=");
		sb.append(tpAge);
		sb.append(", vehicleSEQCustom=");
		sb.append(vehicleSEQCustom);
		sb.append(", tpMobileNo=");
		sb.append(tpMobileNo);
		sb.append(", tpNationality=");
		sb.append(tpNationality);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ClaimTPSearch toEntityModel() {
		ClaimTPSearchImpl claimTPSearchImpl = new ClaimTPSearchImpl();

		if (reportNo == null) {
			claimTPSearchImpl.setReportNo("");
		}
		else {
			claimTPSearchImpl.setReportNo(reportNo);
		}

		if (tpId == null) {
			claimTPSearchImpl.setTpId("");
		}
		else {
			claimTPSearchImpl.setTpId(tpId);
		}

		if (tpDriverName == null) {
			claimTPSearchImpl.setTpDriverName("");
		}
		else {
			claimTPSearchImpl.setTpDriverName(tpDriverName);
		}

		if (tpAge == null) {
			claimTPSearchImpl.setTpAge("");
		}
		else {
			claimTPSearchImpl.setTpAge(tpAge);
		}

		if (vehicleSEQCustom == null) {
			claimTPSearchImpl.setVehicleSEQCustom("");
		}
		else {
			claimTPSearchImpl.setVehicleSEQCustom(vehicleSEQCustom);
		}

		if (tpMobileNo == null) {
			claimTPSearchImpl.setTpMobileNo("");
		}
		else {
			claimTPSearchImpl.setTpMobileNo(tpMobileNo);
		}

		if (tpNationality == null) {
			claimTPSearchImpl.setTpNationality("");
		}
		else {
			claimTPSearchImpl.setTpNationality(tpNationality);
		}

		claimTPSearchImpl.resetOriginalValues();

		return claimTPSearchImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		reportNo = objectInput.readUTF();
		tpId = objectInput.readUTF();
		tpDriverName = objectInput.readUTF();
		tpAge = objectInput.readUTF();
		vehicleSEQCustom = objectInput.readUTF();
		tpMobileNo = objectInput.readUTF();
		tpNationality = objectInput.readUTF();

		claimTPSearchPK = new ClaimTPSearchPK(reportNo, tpId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (reportNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reportNo);
		}

		if (tpId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tpId);
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

		if (vehicleSEQCustom == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleSEQCustom);
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
	}

	public String reportNo;
	public String tpId;
	public String tpDriverName;
	public String tpAge;
	public String vehicleSEQCustom;
	public String tpMobileNo;
	public String tpNationality;
	public transient ClaimTPSearchPK claimTPSearchPK;

}