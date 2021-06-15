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

import com.ejada.atmc.acl.db.model.CodeMaster;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CodeMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CodeMasterCacheModel
	implements CacheModel<CodeMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CodeMasterCacheModel)) {
			return false;
		}

		CodeMasterCacheModel codeMasterCacheModel =
			(CodeMasterCacheModel)object;

		if (systemId == codeMasterCacheModel.systemId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, systemId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{systemId=");
		sb.append(systemId);
		sb.append(", effFromDate=");
		sb.append(effFromDate);
		sb.append(", effToDate=");
		sb.append(effToDate);
		sb.append(", creationDate=");
		sb.append(creationDate);
		sb.append(", crUid=");
		sb.append(crUid);
		sb.append(", updateDate=");
		sb.append(updateDate);
		sb.append(", updateUid=");
		sb.append(updateUid);
		sb.append(", code=");
		sb.append(code);
		sb.append(", codeSub=");
		sb.append(codeSub);
		sb.append(", codeDesc=");
		sb.append(codeDesc);
		sb.append(", codeDescAr=");
		sb.append(codeDescAr);
		sb.append(", codeValue0=");
		sb.append(codeValue0);
		sb.append(", codeValue1=");
		sb.append(codeValue1);
		sb.append(", codeValue2=");
		sb.append(codeValue2);
		sb.append(", codeRef=");
		sb.append(codeRef);
		sb.append(", codeSubRef=");
		sb.append(codeSubRef);
		sb.append(", codeFreezYN=");
		sb.append(codeFreezYN);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CodeMaster toEntityModel() {
		CodeMasterImpl codeMasterImpl = new CodeMasterImpl();

		codeMasterImpl.setSystemId(systemId);

		if (effFromDate == Long.MIN_VALUE) {
			codeMasterImpl.setEffFromDate(null);
		}
		else {
			codeMasterImpl.setEffFromDate(new Date(effFromDate));
		}

		if (effToDate == Long.MIN_VALUE) {
			codeMasterImpl.setEffToDate(null);
		}
		else {
			codeMasterImpl.setEffToDate(new Date(effToDate));
		}

		if (creationDate == Long.MIN_VALUE) {
			codeMasterImpl.setCreationDate(null);
		}
		else {
			codeMasterImpl.setCreationDate(new Date(creationDate));
		}

		if (crUid == null) {
			codeMasterImpl.setCrUid("");
		}
		else {
			codeMasterImpl.setCrUid(crUid);
		}

		if (updateDate == null) {
			codeMasterImpl.setUpdateDate("");
		}
		else {
			codeMasterImpl.setUpdateDate(updateDate);
		}

		codeMasterImpl.setUpdateUid(updateUid);

		if (code == null) {
			codeMasterImpl.setCode("");
		}
		else {
			codeMasterImpl.setCode(code);
		}

		if (codeSub == null) {
			codeMasterImpl.setCodeSub("");
		}
		else {
			codeMasterImpl.setCodeSub(codeSub);
		}

		if (codeDesc == null) {
			codeMasterImpl.setCodeDesc("");
		}
		else {
			codeMasterImpl.setCodeDesc(codeDesc);
		}

		if (codeDescAr == null) {
			codeMasterImpl.setCodeDescAr("");
		}
		else {
			codeMasterImpl.setCodeDescAr(codeDescAr);
		}

		if (codeValue0 == null) {
			codeMasterImpl.setCodeValue0("");
		}
		else {
			codeMasterImpl.setCodeValue0(codeValue0);
		}

		if (codeValue1 == null) {
			codeMasterImpl.setCodeValue1("");
		}
		else {
			codeMasterImpl.setCodeValue1(codeValue1);
		}

		if (codeValue2 == null) {
			codeMasterImpl.setCodeValue2("");
		}
		else {
			codeMasterImpl.setCodeValue2(codeValue2);
		}

		if (codeRef == null) {
			codeMasterImpl.setCodeRef("");
		}
		else {
			codeMasterImpl.setCodeRef(codeRef);
		}

		if (codeSubRef == null) {
			codeMasterImpl.setCodeSubRef("");
		}
		else {
			codeMasterImpl.setCodeSubRef(codeSubRef);
		}

		if (codeFreezYN == null) {
			codeMasterImpl.setCodeFreezYN("");
		}
		else {
			codeMasterImpl.setCodeFreezYN(codeFreezYN);
		}

		codeMasterImpl.resetOriginalValues();

		return codeMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		systemId = objectInput.readLong();
		effFromDate = objectInput.readLong();
		effToDate = objectInput.readLong();
		creationDate = objectInput.readLong();
		crUid = objectInput.readUTF();
		updateDate = objectInput.readUTF();

		updateUid = objectInput.readLong();
		code = objectInput.readUTF();
		codeSub = objectInput.readUTF();
		codeDesc = objectInput.readUTF();
		codeDescAr = objectInput.readUTF();
		codeValue0 = objectInput.readUTF();
		codeValue1 = objectInput.readUTF();
		codeValue2 = objectInput.readUTF();
		codeRef = objectInput.readUTF();
		codeSubRef = objectInput.readUTF();
		codeFreezYN = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(systemId);
		objectOutput.writeLong(effFromDate);
		objectOutput.writeLong(effToDate);
		objectOutput.writeLong(creationDate);

		if (crUid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(crUid);
		}

		if (updateDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(updateDate);
		}

		objectOutput.writeLong(updateUid);

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (codeSub == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codeSub);
		}

		if (codeDesc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codeDesc);
		}

		if (codeDescAr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codeDescAr);
		}

		if (codeValue0 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codeValue0);
		}

		if (codeValue1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codeValue1);
		}

		if (codeValue2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codeValue2);
		}

		if (codeRef == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codeRef);
		}

		if (codeSubRef == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codeSubRef);
		}

		if (codeFreezYN == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codeFreezYN);
		}
	}

	public long systemId;
	public long effFromDate;
	public long effToDate;
	public long creationDate;
	public String crUid;
	public String updateDate;
	public long updateUid;
	public String code;
	public String codeSub;
	public String codeDesc;
	public String codeDescAr;
	public String codeValue0;
	public String codeValue1;
	public String codeValue2;
	public String codeRef;
	public String codeSubRef;
	public String codeFreezYN;

}