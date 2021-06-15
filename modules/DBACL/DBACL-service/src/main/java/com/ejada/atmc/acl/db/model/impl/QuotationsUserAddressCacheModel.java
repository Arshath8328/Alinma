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

import com.ejada.atmc.acl.db.model.QuotationsUserAddress;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing QuotationsUserAddress in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class QuotationsUserAddressCacheModel
	implements CacheModel<QuotationsUserAddress>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof QuotationsUserAddressCacheModel)) {
			return false;
		}

		QuotationsUserAddressCacheModel quotationsUserAddressCacheModel =
			(QuotationsUserAddressCacheModel)object;

		if (userAddressId == quotationsUserAddressCacheModel.userAddressId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userAddressId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{userAddressId=");
		sb.append(userAddressId);
		sb.append(", driverId=");
		sb.append(driverId);
		sb.append(", quotationId=");
		sb.append(quotationId);
		sb.append(", buildNo=");
		sb.append(buildNo);
		sb.append(", zipCode=");
		sb.append(zipCode);
		sb.append(", addNo=");
		sb.append(addNo);
		sb.append(", stNameEn=");
		sb.append(stNameEn);
		sb.append(", stNameAr=");
		sb.append(stNameAr);
		sb.append(", districtEn=");
		sb.append(districtEn);
		sb.append(", districtAr=");
		sb.append(districtAr);
		sb.append(", cityEn=");
		sb.append(cityEn);
		sb.append(", cityAr=");
		sb.append(cityAr);
		sb.append(", isNatAddress=");
		sb.append(isNatAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public QuotationsUserAddress toEntityModel() {
		QuotationsUserAddressImpl quotationsUserAddressImpl =
			new QuotationsUserAddressImpl();

		quotationsUserAddressImpl.setUserAddressId(userAddressId);
		quotationsUserAddressImpl.setDriverId(driverId);
		quotationsUserAddressImpl.setQuotationId(quotationId);

		if (buildNo == null) {
			quotationsUserAddressImpl.setBuildNo("");
		}
		else {
			quotationsUserAddressImpl.setBuildNo(buildNo);
		}

		if (zipCode == null) {
			quotationsUserAddressImpl.setZipCode("");
		}
		else {
			quotationsUserAddressImpl.setZipCode(zipCode);
		}

		if (addNo == null) {
			quotationsUserAddressImpl.setAddNo("");
		}
		else {
			quotationsUserAddressImpl.setAddNo(addNo);
		}

		if (stNameEn == null) {
			quotationsUserAddressImpl.setStNameEn("");
		}
		else {
			quotationsUserAddressImpl.setStNameEn(stNameEn);
		}

		if (stNameAr == null) {
			quotationsUserAddressImpl.setStNameAr("");
		}
		else {
			quotationsUserAddressImpl.setStNameAr(stNameAr);
		}

		if (districtEn == null) {
			quotationsUserAddressImpl.setDistrictEn("");
		}
		else {
			quotationsUserAddressImpl.setDistrictEn(districtEn);
		}

		if (districtAr == null) {
			quotationsUserAddressImpl.setDistrictAr("");
		}
		else {
			quotationsUserAddressImpl.setDistrictAr(districtAr);
		}

		if (cityEn == null) {
			quotationsUserAddressImpl.setCityEn("");
		}
		else {
			quotationsUserAddressImpl.setCityEn(cityEn);
		}

		if (cityAr == null) {
			quotationsUserAddressImpl.setCityAr("");
		}
		else {
			quotationsUserAddressImpl.setCityAr(cityAr);
		}

		quotationsUserAddressImpl.setIsNatAddress(isNatAddress);

		quotationsUserAddressImpl.resetOriginalValues();

		return quotationsUserAddressImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userAddressId = objectInput.readLong();

		driverId = objectInput.readLong();

		quotationId = objectInput.readLong();
		buildNo = objectInput.readUTF();
		zipCode = objectInput.readUTF();
		addNo = objectInput.readUTF();
		stNameEn = objectInput.readUTF();
		stNameAr = objectInput.readUTF();
		districtEn = objectInput.readUTF();
		districtAr = objectInput.readUTF();
		cityEn = objectInput.readUTF();
		cityAr = objectInput.readUTF();

		isNatAddress = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userAddressId);

		objectOutput.writeLong(driverId);

		objectOutput.writeLong(quotationId);

		if (buildNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(buildNo);
		}

		if (zipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zipCode);
		}

		if (addNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addNo);
		}

		if (stNameEn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stNameEn);
		}

		if (stNameAr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stNameAr);
		}

		if (districtEn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(districtEn);
		}

		if (districtAr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(districtAr);
		}

		if (cityEn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cityEn);
		}

		if (cityAr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cityAr);
		}

		objectOutput.writeBoolean(isNatAddress);
	}

	public long userAddressId;
	public long driverId;
	public long quotationId;
	public String buildNo;
	public String zipCode;
	public String addNo;
	public String stNameEn;
	public String stNameAr;
	public String districtEn;
	public String districtAr;
	public String cityEn;
	public String cityAr;
	public boolean isNatAddress;

}