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

import com.ejada.atmc.acl.db.model.QuotationExtraTameeniInfo;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing QuotationExtraTameeniInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class QuotationExtraTameeniInfoCacheModel
	implements CacheModel<QuotationExtraTameeniInfo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof QuotationExtraTameeniInfoCacheModel)) {
			return false;
		}

		QuotationExtraTameeniInfoCacheModel
			quotationExtraTameeniInfoCacheModel =
				(QuotationExtraTameeniInfoCacheModel)object;

		if (quotationId == quotationExtraTameeniInfoCacheModel.quotationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, quotationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{quotationId=");
		sb.append(quotationId);
		sb.append(", insuredFirstName=");
		sb.append(insuredFirstName);
		sb.append(", insuredMiddleName=");
		sb.append(insuredMiddleName);
		sb.append(", insuredLastName=");
		sb.append(insuredLastName);
		sb.append(", isDriverDisabled=");
		sb.append(isDriverDisabled);
		sb.append(", vehicleMakeCodeTameeni=");
		sb.append(vehicleMakeCodeTameeni);
		sb.append(", coverAgeLimit=");
		sb.append(coverAgeLimit);
		sb.append(", insuredNameLang=");
		sb.append(insuredNameLang);
		sb.append(", policyTitleId=");
		sb.append(policyTitleId);
		sb.append(", isRenewal=");
		sb.append(isRenewal);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public QuotationExtraTameeniInfo toEntityModel() {
		QuotationExtraTameeniInfoImpl quotationExtraTameeniInfoImpl =
			new QuotationExtraTameeniInfoImpl();

		quotationExtraTameeniInfoImpl.setQuotationId(quotationId);

		if (insuredFirstName == null) {
			quotationExtraTameeniInfoImpl.setInsuredFirstName("");
		}
		else {
			quotationExtraTameeniInfoImpl.setInsuredFirstName(insuredFirstName);
		}

		if (insuredMiddleName == null) {
			quotationExtraTameeniInfoImpl.setInsuredMiddleName("");
		}
		else {
			quotationExtraTameeniInfoImpl.setInsuredMiddleName(
				insuredMiddleName);
		}

		if (insuredLastName == null) {
			quotationExtraTameeniInfoImpl.setInsuredLastName("");
		}
		else {
			quotationExtraTameeniInfoImpl.setInsuredLastName(insuredLastName);
		}

		quotationExtraTameeniInfoImpl.setIsDriverDisabled(isDriverDisabled);
		quotationExtraTameeniInfoImpl.setVehicleMakeCodeTameeni(
			vehicleMakeCodeTameeni);
		quotationExtraTameeniInfoImpl.setCoverAgeLimit(coverAgeLimit);

		if (insuredNameLang == null) {
			quotationExtraTameeniInfoImpl.setInsuredNameLang("");
		}
		else {
			quotationExtraTameeniInfoImpl.setInsuredNameLang(insuredNameLang);
		}

		if (policyTitleId == null) {
			quotationExtraTameeniInfoImpl.setPolicyTitleId("");
		}
		else {
			quotationExtraTameeniInfoImpl.setPolicyTitleId(policyTitleId);
		}

		quotationExtraTameeniInfoImpl.setIsRenewal(isRenewal);

		quotationExtraTameeniInfoImpl.resetOriginalValues();

		return quotationExtraTameeniInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		quotationId = objectInput.readLong();
		insuredFirstName = objectInput.readUTF();
		insuredMiddleName = objectInput.readUTF();
		insuredLastName = objectInput.readUTF();

		isDriverDisabled = objectInput.readBoolean();

		vehicleMakeCodeTameeni = objectInput.readLong();

		coverAgeLimit = objectInput.readLong();
		insuredNameLang = objectInput.readUTF();
		policyTitleId = objectInput.readUTF();

		isRenewal = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(quotationId);

		if (insuredFirstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredFirstName);
		}

		if (insuredMiddleName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredMiddleName);
		}

		if (insuredLastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredLastName);
		}

		objectOutput.writeBoolean(isDriverDisabled);

		objectOutput.writeLong(vehicleMakeCodeTameeni);

		objectOutput.writeLong(coverAgeLimit);

		if (insuredNameLang == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredNameLang);
		}

		if (policyTitleId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyTitleId);
		}

		objectOutput.writeBoolean(isRenewal);
	}

	public long quotationId;
	public String insuredFirstName;
	public String insuredMiddleName;
	public String insuredLastName;
	public boolean isDriverDisabled;
	public long vehicleMakeCodeTameeni;
	public long coverAgeLimit;
	public String insuredNameLang;
	public String policyTitleId;
	public boolean isRenewal;

}