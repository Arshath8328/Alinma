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

import com.ejada.atmc.acl.db.model.CLMSTATUSHISTORY;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CLMSTATUSHISTORY in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CLMSTATUSHISTORYCacheModel
	implements CacheModel<CLMSTATUSHISTORY>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CLMSTATUSHISTORYCacheModel)) {
			return false;
		}

		CLMSTATUSHISTORYCacheModel clmstatushistoryCacheModel =
			(CLMSTATUSHISTORYCacheModel)object;

		if (id == clmstatushistoryCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", RefNo=");
		sb.append(RefNo);
		sb.append(", date=");
		sb.append(date);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", claimStatus=");
		sb.append(claimStatus);
		sb.append(", reason=");
		sb.append(reason);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CLMSTATUSHISTORY toEntityModel() {
		CLMSTATUSHISTORYImpl clmstatushistoryImpl = new CLMSTATUSHISTORYImpl();

		clmstatushistoryImpl.setId(id);

		if (RefNo == null) {
			clmstatushistoryImpl.setRefNo("");
		}
		else {
			clmstatushistoryImpl.setRefNo(RefNo);
		}

		if (date == Long.MIN_VALUE) {
			clmstatushistoryImpl.setDate(null);
		}
		else {
			clmstatushistoryImpl.setDate(new Date(date));
		}

		if (userName == null) {
			clmstatushistoryImpl.setUserName("");
		}
		else {
			clmstatushistoryImpl.setUserName(userName);
		}

		if (claimStatus == null) {
			clmstatushistoryImpl.setClaimStatus("");
		}
		else {
			clmstatushistoryImpl.setClaimStatus(claimStatus);
		}

		if (reason == null) {
			clmstatushistoryImpl.setReason("");
		}
		else {
			clmstatushistoryImpl.setReason(reason);
		}

		clmstatushistoryImpl.resetOriginalValues();

		return clmstatushistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		RefNo = objectInput.readUTF();
		date = objectInput.readLong();
		userName = objectInput.readUTF();
		claimStatus = objectInput.readUTF();
		reason = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		if (RefNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(RefNo);
		}

		objectOutput.writeLong(date);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (claimStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(claimStatus);
		}

		if (reason == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reason);
		}
	}

	public int id;
	public String RefNo;
	public long date;
	public String userName;
	public String claimStatus;
	public String reason;

}