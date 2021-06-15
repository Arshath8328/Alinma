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

import com.ejada.atmc.acl.db.model.ProductDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProductDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductDetailsCacheModel
	implements CacheModel<ProductDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductDetailsCacheModel)) {
			return false;
		}

		ProductDetailsCacheModel productDetailsCacheModel =
			(ProductDetailsCacheModel)object;

		if (sysId == productDetailsCacheModel.sysId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sysId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{sysId=");
		sb.append(sysId);
		sb.append(", lobSysId=");
		sb.append(lobSysId);
		sb.append(", effFmDate=");
		sb.append(effFmDate);
		sb.append(", effToDate=");
		sb.append(effToDate);
		sb.append(", crDate=");
		sb.append(crDate);
		sb.append(", crUid=");
		sb.append(crUid);
		sb.append(", updDate=");
		sb.append(updDate);
		sb.append(", updUid=");
		sb.append(updUid);
		sb.append(", productCode=");
		sb.append(productCode);
		sb.append(", productName=");
		sb.append(productName);
		sb.append(", productNameAr=");
		sb.append(productNameAr);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProductDetails toEntityModel() {
		ProductDetailsImpl productDetailsImpl = new ProductDetailsImpl();

		productDetailsImpl.setSysId(sysId);
		productDetailsImpl.setLobSysId(lobSysId);

		if (effFmDate == Long.MIN_VALUE) {
			productDetailsImpl.setEffFmDate(null);
		}
		else {
			productDetailsImpl.setEffFmDate(new Date(effFmDate));
		}

		if (effToDate == Long.MIN_VALUE) {
			productDetailsImpl.setEffToDate(null);
		}
		else {
			productDetailsImpl.setEffToDate(new Date(effToDate));
		}

		if (crDate == Long.MIN_VALUE) {
			productDetailsImpl.setCrDate(null);
		}
		else {
			productDetailsImpl.setCrDate(new Date(crDate));
		}

		if (crUid == null) {
			productDetailsImpl.setCrUid("");
		}
		else {
			productDetailsImpl.setCrUid(crUid);
		}

		if (updDate == null) {
			productDetailsImpl.setUpdDate("");
		}
		else {
			productDetailsImpl.setUpdDate(updDate);
		}

		if (updUid == null) {
			productDetailsImpl.setUpdUid("");
		}
		else {
			productDetailsImpl.setUpdUid(updUid);
		}

		if (productCode == null) {
			productDetailsImpl.setProductCode("");
		}
		else {
			productDetailsImpl.setProductCode(productCode);
		}

		if (productName == null) {
			productDetailsImpl.setProductName("");
		}
		else {
			productDetailsImpl.setProductName(productName);
		}

		if (productNameAr == null) {
			productDetailsImpl.setProductNameAr("");
		}
		else {
			productDetailsImpl.setProductNameAr(productNameAr);
		}

		productDetailsImpl.resetOriginalValues();

		return productDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sysId = objectInput.readLong();

		lobSysId = objectInput.readDouble();
		effFmDate = objectInput.readLong();
		effToDate = objectInput.readLong();
		crDate = objectInput.readLong();
		crUid = objectInput.readUTF();
		updDate = objectInput.readUTF();
		updUid = objectInput.readUTF();
		productCode = objectInput.readUTF();
		productName = objectInput.readUTF();
		productNameAr = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(sysId);

		objectOutput.writeDouble(lobSysId);
		objectOutput.writeLong(effFmDate);
		objectOutput.writeLong(effToDate);
		objectOutput.writeLong(crDate);

		if (crUid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(crUid);
		}

		if (updDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(updDate);
		}

		if (updUid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(updUid);
		}

		if (productCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productCode);
		}

		if (productName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productName);
		}

		if (productNameAr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productNameAr);
		}
	}

	public long sysId;
	public double lobSysId;
	public long effFmDate;
	public long effToDate;
	public long crDate;
	public String crUid;
	public String updDate;
	public String updUid;
	public String productCode;
	public String productName;
	public String productNameAr;

}