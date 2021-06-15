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

import com.ejada.atmc.acl.db.model.CLMSTATUS;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CLMSTATUS in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CLMSTATUSCacheModel
	implements CacheModel<CLMSTATUS>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CLMSTATUSCacheModel)) {
			return false;
		}

		CLMSTATUSCacheModel clmstatusCacheModel = (CLMSTATUSCacheModel)object;

		if (RefNo.equals(clmstatusCacheModel.RefNo)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, RefNo);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{RefNo=");
		sb.append(RefNo);
		sb.append(", claimStatus=");
		sb.append(claimStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CLMSTATUS toEntityModel() {
		CLMSTATUSImpl clmstatusImpl = new CLMSTATUSImpl();

		if (RefNo == null) {
			clmstatusImpl.setRefNo("");
		}
		else {
			clmstatusImpl.setRefNo(RefNo);
		}

		if (claimStatus == null) {
			clmstatusImpl.setClaimStatus("");
		}
		else {
			clmstatusImpl.setClaimStatus(claimStatus);
		}

		clmstatusImpl.resetOriginalValues();

		return clmstatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		RefNo = objectInput.readUTF();
		claimStatus = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (RefNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(RefNo);
		}

		if (claimStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(claimStatus);
		}
	}

	public String RefNo;
	public String claimStatus;

}