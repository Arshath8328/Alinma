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

import com.ejada.atmc.acl.db.model.CustomerMap;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CustomerMap in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CustomerMapCacheModel
	implements CacheModel<CustomerMap>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CustomerMapCacheModel)) {
			return false;
		}

		CustomerMapCacheModel customerMapCacheModel =
			(CustomerMapCacheModel)object;

		if (refCode.equals(customerMapCacheModel.refCode)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, refCode);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{civilId=");
		sb.append(civilId);
		sb.append(", effFromDate=");
		sb.append(effFromDate);
		sb.append(", crDare=");
		sb.append(crDare);
		sb.append(", crUid=");
		sb.append(crUid);
		sb.append(", updateDt=");
		sb.append(updateDt);
		sb.append(", updUid=");
		sb.append(updUid);
		sb.append(", name=");
		sb.append(name);
		sb.append(", nameAr=");
		sb.append(nameAr);
		sb.append(", custType=");
		sb.append(custType);
		sb.append(", custCatg=");
		sb.append(custCatg);
		sb.append(", custCatgDesc=");
		sb.append(custCatgDesc);
		sb.append(", dob=");
		sb.append(dob);
		sb.append(", mobileNo=");
		sb.append(mobileNo);
		sb.append(", premiaCode=");
		sb.append(premiaCode);
		sb.append(", medCode=");
		sb.append(medCode);
		sb.append(", ilasCode=");
		sb.append(ilasCode);
		sb.append(", glasCode=");
		sb.append(glasCode);
		sb.append(", nationality=");
		sb.append(nationality);
		sb.append(", nameShort=");
		sb.append(nameShort);
		sb.append(", version=");
		sb.append(version);
		sb.append(", vip=");
		sb.append(vip);
		sb.append(", phoneNo=");
		sb.append(phoneNo);
		sb.append(", address=");
		sb.append(address);
		sb.append(", email=");
		sb.append(email);
		sb.append(", refCode=");
		sb.append(refCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CustomerMap toEntityModel() {
		CustomerMapImpl customerMapImpl = new CustomerMapImpl();

		if (civilId == null) {
			customerMapImpl.setCivilId("");
		}
		else {
			customerMapImpl.setCivilId(civilId);
		}

		if (effFromDate == Long.MIN_VALUE) {
			customerMapImpl.setEffFromDate(null);
		}
		else {
			customerMapImpl.setEffFromDate(new Date(effFromDate));
		}

		if (crDare == Long.MIN_VALUE) {
			customerMapImpl.setCrDare(null);
		}
		else {
			customerMapImpl.setCrDare(new Date(crDare));
		}

		if (crUid == null) {
			customerMapImpl.setCrUid("");
		}
		else {
			customerMapImpl.setCrUid(crUid);
		}

		if (updateDt == null) {
			customerMapImpl.setUpdateDt("");
		}
		else {
			customerMapImpl.setUpdateDt(updateDt);
		}

		if (updUid == null) {
			customerMapImpl.setUpdUid("");
		}
		else {
			customerMapImpl.setUpdUid(updUid);
		}

		if (name == null) {
			customerMapImpl.setName("");
		}
		else {
			customerMapImpl.setName(name);
		}

		if (nameAr == null) {
			customerMapImpl.setNameAr("");
		}
		else {
			customerMapImpl.setNameAr(nameAr);
		}

		if (custType == null) {
			customerMapImpl.setCustType("");
		}
		else {
			customerMapImpl.setCustType(custType);
		}

		if (custCatg == null) {
			customerMapImpl.setCustCatg("");
		}
		else {
			customerMapImpl.setCustCatg(custCatg);
		}

		if (custCatgDesc == null) {
			customerMapImpl.setCustCatgDesc("");
		}
		else {
			customerMapImpl.setCustCatgDesc(custCatgDesc);
		}

		if (dob == Long.MIN_VALUE) {
			customerMapImpl.setDob(null);
		}
		else {
			customerMapImpl.setDob(new Date(dob));
		}

		if (mobileNo == null) {
			customerMapImpl.setMobileNo("");
		}
		else {
			customerMapImpl.setMobileNo(mobileNo);
		}

		if (premiaCode == null) {
			customerMapImpl.setPremiaCode("");
		}
		else {
			customerMapImpl.setPremiaCode(premiaCode);
		}

		if (medCode == null) {
			customerMapImpl.setMedCode("");
		}
		else {
			customerMapImpl.setMedCode(medCode);
		}

		if (ilasCode == null) {
			customerMapImpl.setIlasCode("");
		}
		else {
			customerMapImpl.setIlasCode(ilasCode);
		}

		if (glasCode == null) {
			customerMapImpl.setGlasCode("");
		}
		else {
			customerMapImpl.setGlasCode(glasCode);
		}

		if (nationality == null) {
			customerMapImpl.setNationality("");
		}
		else {
			customerMapImpl.setNationality(nationality);
		}

		if (nameShort == null) {
			customerMapImpl.setNameShort("");
		}
		else {
			customerMapImpl.setNameShort(nameShort);
		}

		if (version == null) {
			customerMapImpl.setVersion("");
		}
		else {
			customerMapImpl.setVersion(version);
		}

		if (vip == null) {
			customerMapImpl.setVip("");
		}
		else {
			customerMapImpl.setVip(vip);
		}

		if (phoneNo == null) {
			customerMapImpl.setPhoneNo("");
		}
		else {
			customerMapImpl.setPhoneNo(phoneNo);
		}

		if (address == null) {
			customerMapImpl.setAddress("");
		}
		else {
			customerMapImpl.setAddress(address);
		}

		if (email == null) {
			customerMapImpl.setEmail("");
		}
		else {
			customerMapImpl.setEmail(email);
		}

		if (refCode == null) {
			customerMapImpl.setRefCode("");
		}
		else {
			customerMapImpl.setRefCode(refCode);
		}

		customerMapImpl.resetOriginalValues();

		return customerMapImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		civilId = objectInput.readUTF();
		effFromDate = objectInput.readLong();
		crDare = objectInput.readLong();
		crUid = objectInput.readUTF();
		updateDt = objectInput.readUTF();
		updUid = objectInput.readUTF();
		name = objectInput.readUTF();
		nameAr = objectInput.readUTF();
		custType = objectInput.readUTF();
		custCatg = objectInput.readUTF();
		custCatgDesc = objectInput.readUTF();
		dob = objectInput.readLong();
		mobileNo = objectInput.readUTF();
		premiaCode = objectInput.readUTF();
		medCode = objectInput.readUTF();
		ilasCode = objectInput.readUTF();
		glasCode = objectInput.readUTF();
		nationality = objectInput.readUTF();
		nameShort = objectInput.readUTF();
		version = objectInput.readUTF();
		vip = objectInput.readUTF();
		phoneNo = objectInput.readUTF();
		address = objectInput.readUTF();
		email = objectInput.readUTF();
		refCode = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (civilId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(civilId);
		}

		objectOutput.writeLong(effFromDate);
		objectOutput.writeLong(crDare);

		if (crUid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(crUid);
		}

		if (updateDt == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(updateDt);
		}

		if (updUid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(updUid);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (nameAr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameAr);
		}

		if (custType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(custType);
		}

		if (custCatg == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(custCatg);
		}

		if (custCatgDesc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(custCatgDesc);
		}

		objectOutput.writeLong(dob);

		if (mobileNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobileNo);
		}

		if (premiaCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(premiaCode);
		}

		if (medCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(medCode);
		}

		if (ilasCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ilasCode);
		}

		if (glasCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(glasCode);
		}

		if (nationality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationality);
		}

		if (nameShort == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameShort);
		}

		if (version == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(version);
		}

		if (vip == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vip);
		}

		if (phoneNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phoneNo);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (refCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(refCode);
		}
	}

	public String civilId;
	public long effFromDate;
	public long crDare;
	public String crUid;
	public String updateDt;
	public String updUid;
	public String name;
	public String nameAr;
	public String custType;
	public String custCatg;
	public String custCatgDesc;
	public long dob;
	public String mobileNo;
	public String premiaCode;
	public String medCode;
	public String ilasCode;
	public String glasCode;
	public String nationality;
	public String nameShort;
	public String version;
	public String vip;
	public String phoneNo;
	public String address;
	public String email;
	public String refCode;

}