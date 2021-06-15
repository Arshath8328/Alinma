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

import com.ejada.atmc.acl.db.model.CompDiscount;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CompDiscount in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CompDiscountCacheModel
	implements CacheModel<CompDiscount>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CompDiscountCacheModel)) {
			return false;
		}

		CompDiscountCacheModel compDiscountCacheModel =
			(CompDiscountCacheModel)object;

		if (iqamaId.equals(compDiscountCacheModel.iqamaId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, iqamaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{iqamaId=");
		sb.append(iqamaId);
		sb.append(", schemeCode=");
		sb.append(schemeCode);
		sb.append(", companyCode=");
		sb.append(companyCode);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CompDiscount toEntityModel() {
		CompDiscountImpl compDiscountImpl = new CompDiscountImpl();

		if (iqamaId == null) {
			compDiscountImpl.setIqamaId("");
		}
		else {
			compDiscountImpl.setIqamaId(iqamaId);
		}

		if (schemeCode == null) {
			compDiscountImpl.setSchemeCode("");
		}
		else {
			compDiscountImpl.setSchemeCode(schemeCode);
		}

		if (companyCode == null) {
			compDiscountImpl.setCompanyCode("");
		}
		else {
			compDiscountImpl.setCompanyCode(companyCode);
		}

		if (startDate == Long.MIN_VALUE) {
			compDiscountImpl.setStartDate(null);
		}
		else {
			compDiscountImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			compDiscountImpl.setEndDate(null);
		}
		else {
			compDiscountImpl.setEndDate(new Date(endDate));
		}

		compDiscountImpl.resetOriginalValues();

		return compDiscountImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		iqamaId = objectInput.readUTF();
		schemeCode = objectInput.readUTF();
		companyCode = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (iqamaId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(iqamaId);
		}

		if (schemeCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(schemeCode);
		}

		if (companyCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(companyCode);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
	}

	public String iqamaId;
	public String schemeCode;
	public String companyCode;
	public long startDate;
	public long endDate;

}