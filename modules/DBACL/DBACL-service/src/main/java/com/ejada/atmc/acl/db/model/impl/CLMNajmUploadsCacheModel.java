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

import com.ejada.atmc.acl.db.model.CLMNajmUploads;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CLMNajmUploads in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CLMNajmUploadsCacheModel
	implements CacheModel<CLMNajmUploads>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CLMNajmUploadsCacheModel)) {
			return false;
		}

		CLMNajmUploadsCacheModel clmNajmUploadsCacheModel =
			(CLMNajmUploadsCacheModel)object;

		if (id == clmNajmUploadsCacheModel.id) {
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
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(id);
		sb.append(", caseNo=");
		sb.append(caseNo);
		sb.append(", cipiId=");
		sb.append(cipiId);
		sb.append(", najmSlipName=");
		sb.append(najmSlipName);
		sb.append(", damageEstQuotName=");
		sb.append(damageEstQuotName);
		sb.append(", bankIbanName=");
		sb.append(bankIbanName);
		sb.append(", ownerIdName=");
		sb.append(ownerIdName);
		sb.append(", claimRefNo=");
		sb.append(claimRefNo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CLMNajmUploads toEntityModel() {
		CLMNajmUploadsImpl clmNajmUploadsImpl = new CLMNajmUploadsImpl();

		clmNajmUploadsImpl.setId(id);

		if (caseNo == null) {
			clmNajmUploadsImpl.setCaseNo("");
		}
		else {
			clmNajmUploadsImpl.setCaseNo(caseNo);
		}

		if (cipiId == null) {
			clmNajmUploadsImpl.setCipiId("");
		}
		else {
			clmNajmUploadsImpl.setCipiId(cipiId);
		}

		if (najmSlipName == null) {
			clmNajmUploadsImpl.setNajmSlipName("");
		}
		else {
			clmNajmUploadsImpl.setNajmSlipName(najmSlipName);
		}

		if (damageEstQuotName == null) {
			clmNajmUploadsImpl.setDamageEstQuotName("");
		}
		else {
			clmNajmUploadsImpl.setDamageEstQuotName(damageEstQuotName);
		}

		if (bankIbanName == null) {
			clmNajmUploadsImpl.setBankIbanName("");
		}
		else {
			clmNajmUploadsImpl.setBankIbanName(bankIbanName);
		}

		if (ownerIdName == null) {
			clmNajmUploadsImpl.setOwnerIdName("");
		}
		else {
			clmNajmUploadsImpl.setOwnerIdName(ownerIdName);
		}

		if (claimRefNo == null) {
			clmNajmUploadsImpl.setClaimRefNo("");
		}
		else {
			clmNajmUploadsImpl.setClaimRefNo(claimRefNo);
		}

		clmNajmUploadsImpl.resetOriginalValues();

		return clmNajmUploadsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		caseNo = objectInput.readUTF();
		cipiId = objectInput.readUTF();
		najmSlipName = objectInput.readUTF();
		damageEstQuotName = objectInput.readUTF();
		bankIbanName = objectInput.readUTF();
		ownerIdName = objectInput.readUTF();
		claimRefNo = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		if (caseNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(caseNo);
		}

		if (cipiId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cipiId);
		}

		if (najmSlipName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(najmSlipName);
		}

		if (damageEstQuotName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(damageEstQuotName);
		}

		if (bankIbanName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankIbanName);
		}

		if (ownerIdName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ownerIdName);
		}

		if (claimRefNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(claimRefNo);
		}
	}

	public int id;
	public String caseNo;
	public String cipiId;
	public String najmSlipName;
	public String damageEstQuotName;
	public String bankIbanName;
	public String ownerIdName;
	public String claimRefNo;

}