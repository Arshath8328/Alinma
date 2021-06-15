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

import com.ejada.atmc.acl.db.model.BeneficiaryDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BeneficiaryDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BeneficiaryDetailsCacheModel
	implements CacheModel<BeneficiaryDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BeneficiaryDetailsCacheModel)) {
			return false;
		}

		BeneficiaryDetailsCacheModel beneficiaryDetailsCacheModel =
			(BeneficiaryDetailsCacheModel)object;

		if (benfId == beneficiaryDetailsCacheModel.benfId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, benfId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{policyNo=");
		sb.append(policyNo);
		sb.append(", benfName=");
		sb.append(benfName);
		sb.append(", benfPct=");
		sb.append(benfPct);
		sb.append(", benfRel=");
		sb.append(benfRel);
		sb.append(", benfId=");
		sb.append(benfId);
		sb.append(", benfAge=");
		sb.append(benfAge);
		sb.append(", benfType=");
		sb.append(benfType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BeneficiaryDetails toEntityModel() {
		BeneficiaryDetailsImpl beneficiaryDetailsImpl =
			new BeneficiaryDetailsImpl();

		if (policyNo == null) {
			beneficiaryDetailsImpl.setPolicyNo("");
		}
		else {
			beneficiaryDetailsImpl.setPolicyNo(policyNo);
		}

		if (benfName == null) {
			beneficiaryDetailsImpl.setBenfName("");
		}
		else {
			beneficiaryDetailsImpl.setBenfName(benfName);
		}

		if (benfPct == null) {
			beneficiaryDetailsImpl.setBenfPct("");
		}
		else {
			beneficiaryDetailsImpl.setBenfPct(benfPct);
		}

		if (benfRel == null) {
			beneficiaryDetailsImpl.setBenfRel("");
		}
		else {
			beneficiaryDetailsImpl.setBenfRel(benfRel);
		}

		beneficiaryDetailsImpl.setBenfId(benfId);

		if (benfAge == null) {
			beneficiaryDetailsImpl.setBenfAge("");
		}
		else {
			beneficiaryDetailsImpl.setBenfAge(benfAge);
		}

		if (benfType == null) {
			beneficiaryDetailsImpl.setBenfType("");
		}
		else {
			beneficiaryDetailsImpl.setBenfType(benfType);
		}

		beneficiaryDetailsImpl.resetOriginalValues();

		return beneficiaryDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		policyNo = objectInput.readUTF();
		benfName = objectInput.readUTF();
		benfPct = objectInput.readUTF();
		benfRel = objectInput.readUTF();

		benfId = objectInput.readLong();
		benfAge = objectInput.readUTF();
		benfType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (policyNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyNo);
		}

		if (benfName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(benfName);
		}

		if (benfPct == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(benfPct);
		}

		if (benfRel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(benfRel);
		}

		objectOutput.writeLong(benfId);

		if (benfAge == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(benfAge);
		}

		if (benfType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(benfType);
		}
	}

	public String policyNo;
	public String benfName;
	public String benfPct;
	public String benfRel;
	public long benfId;
	public String benfAge;
	public String benfType;

}