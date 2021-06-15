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

import com.ejada.atmc.acl.db.model.CLMNajm;
import com.ejada.atmc.acl.db.service.persistence.CLMNajmPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CLMNajm in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CLMNajmCacheModel implements CacheModel<CLMNajm>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CLMNajmCacheModel)) {
			return false;
		}

		CLMNajmCacheModel clmNajmCacheModel = (CLMNajmCacheModel)object;

		if (clmNajmPK.equals(clmNajmCacheModel.clmNajmPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, clmNajmPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{caseNo=");
		sb.append(caseNo);
		sb.append(", cipiId=");
		sb.append(cipiId);
		sb.append(", callDt=");
		sb.append(callDt);
		sb.append(", city=");
		sb.append(city);
		sb.append(", name=");
		sb.append(name);
		sb.append(", phoneNo=");
		sb.append(phoneNo);
		sb.append(", age=");
		sb.append(age);
		sb.append(", nationality=");
		sb.append(nationality);
		sb.append(", plateNo=");
		sb.append(plateNo);
		sb.append(", liabiltiyPerc=");
		sb.append(liabiltiyPerc);
		sb.append(", liabiltiyAmt=");
		sb.append(liabiltiyAmt);
		sb.append(", customId=");
		sb.append(customId);
		sb.append(", seqNo=");
		sb.append(seqNo);
		sb.append(", englishName=");
		sb.append(englishName);
		sb.append(", polNo=");
		sb.append(polNo);
		sb.append(", najmPlateNo=");
		sb.append(najmPlateNo);
		sb.append(", najmChassisNo=");
		sb.append(najmChassisNo);
		sb.append(", najmVEHNo=");
		sb.append(najmVEHNo);
		sb.append(", causeAr=");
		sb.append(causeAr);
		sb.append(", causeEn=");
		sb.append(causeEn);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CLMNajm toEntityModel() {
		CLMNajmImpl clmNajmImpl = new CLMNajmImpl();

		if (caseNo == null) {
			clmNajmImpl.setCaseNo("");
		}
		else {
			clmNajmImpl.setCaseNo(caseNo);
		}

		if (cipiId == null) {
			clmNajmImpl.setCipiId("");
		}
		else {
			clmNajmImpl.setCipiId(cipiId);
		}

		if (callDt == null) {
			clmNajmImpl.setCallDt("");
		}
		else {
			clmNajmImpl.setCallDt(callDt);
		}

		if (city == null) {
			clmNajmImpl.setCity("");
		}
		else {
			clmNajmImpl.setCity(city);
		}

		if (name == null) {
			clmNajmImpl.setName("");
		}
		else {
			clmNajmImpl.setName(name);
		}

		if (phoneNo == null) {
			clmNajmImpl.setPhoneNo("");
		}
		else {
			clmNajmImpl.setPhoneNo(phoneNo);
		}

		if (age == null) {
			clmNajmImpl.setAge("");
		}
		else {
			clmNajmImpl.setAge(age);
		}

		if (nationality == null) {
			clmNajmImpl.setNationality("");
		}
		else {
			clmNajmImpl.setNationality(nationality);
		}

		if (plateNo == null) {
			clmNajmImpl.setPlateNo("");
		}
		else {
			clmNajmImpl.setPlateNo(plateNo);
		}

		if (liabiltiyPerc == null) {
			clmNajmImpl.setLiabiltiyPerc("");
		}
		else {
			clmNajmImpl.setLiabiltiyPerc(liabiltiyPerc);
		}

		if (liabiltiyAmt == null) {
			clmNajmImpl.setLiabiltiyAmt("");
		}
		else {
			clmNajmImpl.setLiabiltiyAmt(liabiltiyAmt);
		}

		if (customId == null) {
			clmNajmImpl.setCustomId("");
		}
		else {
			clmNajmImpl.setCustomId(customId);
		}

		if (seqNo == null) {
			clmNajmImpl.setSeqNo("");
		}
		else {
			clmNajmImpl.setSeqNo(seqNo);
		}

		if (englishName == null) {
			clmNajmImpl.setEnglishName("");
		}
		else {
			clmNajmImpl.setEnglishName(englishName);
		}

		if (polNo == null) {
			clmNajmImpl.setPolNo("");
		}
		else {
			clmNajmImpl.setPolNo(polNo);
		}

		if (najmPlateNo == null) {
			clmNajmImpl.setNajmPlateNo("");
		}
		else {
			clmNajmImpl.setNajmPlateNo(najmPlateNo);
		}

		if (najmChassisNo == null) {
			clmNajmImpl.setNajmChassisNo("");
		}
		else {
			clmNajmImpl.setNajmChassisNo(najmChassisNo);
		}

		if (najmVEHNo == null) {
			clmNajmImpl.setNajmVEHNo("");
		}
		else {
			clmNajmImpl.setNajmVEHNo(najmVEHNo);
		}

		if (causeAr == null) {
			clmNajmImpl.setCauseAr("");
		}
		else {
			clmNajmImpl.setCauseAr(causeAr);
		}

		if (causeEn == null) {
			clmNajmImpl.setCauseEn("");
		}
		else {
			clmNajmImpl.setCauseEn(causeEn);
		}

		clmNajmImpl.resetOriginalValues();

		return clmNajmImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		caseNo = objectInput.readUTF();
		cipiId = objectInput.readUTF();
		callDt = objectInput.readUTF();
		city = objectInput.readUTF();
		name = objectInput.readUTF();
		phoneNo = objectInput.readUTF();
		age = objectInput.readUTF();
		nationality = objectInput.readUTF();
		plateNo = objectInput.readUTF();
		liabiltiyPerc = objectInput.readUTF();
		liabiltiyAmt = objectInput.readUTF();
		customId = objectInput.readUTF();
		seqNo = objectInput.readUTF();
		englishName = objectInput.readUTF();
		polNo = objectInput.readUTF();
		najmPlateNo = objectInput.readUTF();
		najmChassisNo = objectInput.readUTF();
		najmVEHNo = objectInput.readUTF();
		causeAr = objectInput.readUTF();
		causeEn = objectInput.readUTF();

		clmNajmPK = new CLMNajmPK(caseNo, cipiId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
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

		if (callDt == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(callDt);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (phoneNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phoneNo);
		}

		if (age == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(age);
		}

		if (nationality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationality);
		}

		if (plateNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(plateNo);
		}

		if (liabiltiyPerc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(liabiltiyPerc);
		}

		if (liabiltiyAmt == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(liabiltiyAmt);
		}

		if (customId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customId);
		}

		if (seqNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(seqNo);
		}

		if (englishName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(englishName);
		}

		if (polNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(polNo);
		}

		if (najmPlateNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(najmPlateNo);
		}

		if (najmChassisNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(najmChassisNo);
		}

		if (najmVEHNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(najmVEHNo);
		}

		if (causeAr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(causeAr);
		}

		if (causeEn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(causeEn);
		}
	}

	public String caseNo;
	public String cipiId;
	public String callDt;
	public String city;
	public String name;
	public String phoneNo;
	public String age;
	public String nationality;
	public String plateNo;
	public String liabiltiyPerc;
	public String liabiltiyAmt;
	public String customId;
	public String seqNo;
	public String englishName;
	public String polNo;
	public String najmPlateNo;
	public String najmChassisNo;
	public String najmVEHNo;
	public String causeAr;
	public String causeEn;
	public transient CLMNajmPK clmNajmPK;

}