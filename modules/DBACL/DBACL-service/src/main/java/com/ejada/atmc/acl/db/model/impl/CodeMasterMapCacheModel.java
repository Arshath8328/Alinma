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

import com.ejada.atmc.acl.db.model.CodeMasterMap;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CodeMasterMap in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CodeMasterMapCacheModel
	implements CacheModel<CodeMasterMap>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CodeMasterMapCacheModel)) {
			return false;
		}

		CodeMasterMapCacheModel codeMasterMapCacheModel =
			(CodeMasterMapCacheModel)object;

		if (source.equals(codeMasterMapCacheModel.source)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, source);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{source=");
		sb.append(source);
		sb.append(", type=");
		sb.append(type);
		sb.append(", sourceType=");
		sb.append(sourceType);
		sb.append(", sourceSystemId=");
		sb.append(sourceSystemId);
		sb.append(", sourceCode=");
		sb.append(sourceCode);
		sb.append(", sourceDesc=");
		sb.append(sourceDesc);
		sb.append(", coreType=");
		sb.append(coreType);
		sb.append(", coreSystemId=");
		sb.append(coreSystemId);
		sb.append(", coreCode=");
		sb.append(coreCode);
		sb.append(", coreDesc=");
		sb.append(coreDesc);
		sb.append(", effFromDate=");
		sb.append(effFromDate);
		sb.append(", effToDate=");
		sb.append(effToDate);
		sb.append(", freezeFlag=");
		sb.append(freezeFlag);
		sb.append(", lvl1Type=");
		sb.append(lvl1Type);
		sb.append(", lvl1SysId=");
		sb.append(lvl1SysId);
		sb.append(", lvl1Code=");
		sb.append(lvl1Code);
		sb.append(", lvl1Desc=");
		sb.append(lvl1Desc);
		sb.append(", lvl2Type=");
		sb.append(lvl2Type);
		sb.append(", lvl2SysId=");
		sb.append(lvl2SysId);
		sb.append(", lvl2Code=");
		sb.append(lvl2Code);
		sb.append(", lvl2Desc=");
		sb.append(lvl2Desc);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CodeMasterMap toEntityModel() {
		CodeMasterMapImpl codeMasterMapImpl = new CodeMasterMapImpl();

		if (source == null) {
			codeMasterMapImpl.setSource("");
		}
		else {
			codeMasterMapImpl.setSource(source);
		}

		if (type == null) {
			codeMasterMapImpl.setType("");
		}
		else {
			codeMasterMapImpl.setType(type);
		}

		if (sourceType == null) {
			codeMasterMapImpl.setSourceType("");
		}
		else {
			codeMasterMapImpl.setSourceType(sourceType);
		}

		if (sourceSystemId == null) {
			codeMasterMapImpl.setSourceSystemId("");
		}
		else {
			codeMasterMapImpl.setSourceSystemId(sourceSystemId);
		}

		if (sourceCode == null) {
			codeMasterMapImpl.setSourceCode("");
		}
		else {
			codeMasterMapImpl.setSourceCode(sourceCode);
		}

		if (sourceDesc == null) {
			codeMasterMapImpl.setSourceDesc("");
		}
		else {
			codeMasterMapImpl.setSourceDesc(sourceDesc);
		}

		if (coreType == null) {
			codeMasterMapImpl.setCoreType("");
		}
		else {
			codeMasterMapImpl.setCoreType(coreType);
		}

		if (coreSystemId == null) {
			codeMasterMapImpl.setCoreSystemId("");
		}
		else {
			codeMasterMapImpl.setCoreSystemId(coreSystemId);
		}

		if (coreCode == null) {
			codeMasterMapImpl.setCoreCode("");
		}
		else {
			codeMasterMapImpl.setCoreCode(coreCode);
		}

		if (coreDesc == null) {
			codeMasterMapImpl.setCoreDesc("");
		}
		else {
			codeMasterMapImpl.setCoreDesc(coreDesc);
		}

		if (effFromDate == Long.MIN_VALUE) {
			codeMasterMapImpl.setEffFromDate(null);
		}
		else {
			codeMasterMapImpl.setEffFromDate(new Date(effFromDate));
		}

		if (effToDate == Long.MIN_VALUE) {
			codeMasterMapImpl.setEffToDate(null);
		}
		else {
			codeMasterMapImpl.setEffToDate(new Date(effToDate));
		}

		if (freezeFlag == null) {
			codeMasterMapImpl.setFreezeFlag("");
		}
		else {
			codeMasterMapImpl.setFreezeFlag(freezeFlag);
		}

		if (lvl1Type == null) {
			codeMasterMapImpl.setLvl1Type("");
		}
		else {
			codeMasterMapImpl.setLvl1Type(lvl1Type);
		}

		if (lvl1SysId == null) {
			codeMasterMapImpl.setLvl1SysId("");
		}
		else {
			codeMasterMapImpl.setLvl1SysId(lvl1SysId);
		}

		if (lvl1Code == null) {
			codeMasterMapImpl.setLvl1Code("");
		}
		else {
			codeMasterMapImpl.setLvl1Code(lvl1Code);
		}

		if (lvl1Desc == null) {
			codeMasterMapImpl.setLvl1Desc("");
		}
		else {
			codeMasterMapImpl.setLvl1Desc(lvl1Desc);
		}

		if (lvl2Type == null) {
			codeMasterMapImpl.setLvl2Type("");
		}
		else {
			codeMasterMapImpl.setLvl2Type(lvl2Type);
		}

		if (lvl2SysId == null) {
			codeMasterMapImpl.setLvl2SysId("");
		}
		else {
			codeMasterMapImpl.setLvl2SysId(lvl2SysId);
		}

		if (lvl2Code == null) {
			codeMasterMapImpl.setLvl2Code("");
		}
		else {
			codeMasterMapImpl.setLvl2Code(lvl2Code);
		}

		if (lvl2Desc == null) {
			codeMasterMapImpl.setLvl2Desc("");
		}
		else {
			codeMasterMapImpl.setLvl2Desc(lvl2Desc);
		}

		codeMasterMapImpl.resetOriginalValues();

		return codeMasterMapImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		source = objectInput.readUTF();
		type = objectInput.readUTF();
		sourceType = objectInput.readUTF();
		sourceSystemId = objectInput.readUTF();
		sourceCode = objectInput.readUTF();
		sourceDesc = objectInput.readUTF();
		coreType = objectInput.readUTF();
		coreSystemId = objectInput.readUTF();
		coreCode = objectInput.readUTF();
		coreDesc = objectInput.readUTF();
		effFromDate = objectInput.readLong();
		effToDate = objectInput.readLong();
		freezeFlag = objectInput.readUTF();
		lvl1Type = objectInput.readUTF();
		lvl1SysId = objectInput.readUTF();
		lvl1Code = objectInput.readUTF();
		lvl1Desc = objectInput.readUTF();
		lvl2Type = objectInput.readUTF();
		lvl2SysId = objectInput.readUTF();
		lvl2Code = objectInput.readUTF();
		lvl2Desc = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (source == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(source);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (sourceType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sourceType);
		}

		if (sourceSystemId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sourceSystemId);
		}

		if (sourceCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sourceCode);
		}

		if (sourceDesc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sourceDesc);
		}

		if (coreType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coreType);
		}

		if (coreSystemId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coreSystemId);
		}

		if (coreCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coreCode);
		}

		if (coreDesc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coreDesc);
		}

		objectOutput.writeLong(effFromDate);
		objectOutput.writeLong(effToDate);

		if (freezeFlag == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(freezeFlag);
		}

		if (lvl1Type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lvl1Type);
		}

		if (lvl1SysId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lvl1SysId);
		}

		if (lvl1Code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lvl1Code);
		}

		if (lvl1Desc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lvl1Desc);
		}

		if (lvl2Type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lvl2Type);
		}

		if (lvl2SysId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lvl2SysId);
		}

		if (lvl2Code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lvl2Code);
		}

		if (lvl2Desc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lvl2Desc);
		}
	}

	public String source;
	public String type;
	public String sourceType;
	public String sourceSystemId;
	public String sourceCode;
	public String sourceDesc;
	public String coreType;
	public String coreSystemId;
	public String coreCode;
	public String coreDesc;
	public long effFromDate;
	public long effToDate;
	public String freezeFlag;
	public String lvl1Type;
	public String lvl1SysId;
	public String lvl1Code;
	public String lvl1Desc;
	public String lvl2Type;
	public String lvl2SysId;
	public String lvl2Code;
	public String lvl2Desc;

}