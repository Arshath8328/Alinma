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

import com.ejada.atmc.acl.db.model.ProductCovers;
import com.ejada.atmc.acl.db.service.persistence.ProductCoversPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ProductCovers in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductCoversCacheModel
	implements CacheModel<ProductCovers>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductCoversCacheModel)) {
			return false;
		}

		ProductCoversCacheModel productCoversCacheModel =
			(ProductCoversCacheModel)object;

		if (productCoversPK.equals(productCoversCacheModel.productCoversPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, productCoversPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{productCode=");
		sb.append(productCode);
		sb.append(", sectionCode=");
		sb.append(sectionCode);
		sb.append(", coverCode=");
		sb.append(coverCode);
		sb.append(", coverName=");
		sb.append(coverName);
		sb.append(", coverNameAr=");
		sb.append(coverNameAr);
		sb.append(", coverDesc=");
		sb.append(coverDesc);
		sb.append(", coverDescAr=");
		sb.append(coverDescAr);
		sb.append(", coverPremium=");
		sb.append(coverPremium);
		sb.append(", coverFld1=");
		sb.append(coverFld1);
		sb.append(", coverFld2=");
		sb.append(coverFld2);
		sb.append(", coverFld3=");
		sb.append(coverFld3);
		sb.append(", coverFld4=");
		sb.append(coverFld4);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProductCovers toEntityModel() {
		ProductCoversImpl productCoversImpl = new ProductCoversImpl();

		productCoversImpl.setProductCode(productCode);
		productCoversImpl.setSectionCode(sectionCode);

		if (coverCode == null) {
			productCoversImpl.setCoverCode("");
		}
		else {
			productCoversImpl.setCoverCode(coverCode);
		}

		if (coverName == null) {
			productCoversImpl.setCoverName("");
		}
		else {
			productCoversImpl.setCoverName(coverName);
		}

		if (coverNameAr == null) {
			productCoversImpl.setCoverNameAr("");
		}
		else {
			productCoversImpl.setCoverNameAr(coverNameAr);
		}

		if (coverDesc == null) {
			productCoversImpl.setCoverDesc("");
		}
		else {
			productCoversImpl.setCoverDesc(coverDesc);
		}

		if (coverDescAr == null) {
			productCoversImpl.setCoverDescAr("");
		}
		else {
			productCoversImpl.setCoverDescAr(coverDescAr);
		}

		if (coverPremium == null) {
			productCoversImpl.setCoverPremium("");
		}
		else {
			productCoversImpl.setCoverPremium(coverPremium);
		}

		if (coverFld1 == null) {
			productCoversImpl.setCoverFld1("");
		}
		else {
			productCoversImpl.setCoverFld1(coverFld1);
		}

		if (coverFld2 == null) {
			productCoversImpl.setCoverFld2("");
		}
		else {
			productCoversImpl.setCoverFld2(coverFld2);
		}

		if (coverFld3 == null) {
			productCoversImpl.setCoverFld3("");
		}
		else {
			productCoversImpl.setCoverFld3(coverFld3);
		}

		if (coverFld4 == null) {
			productCoversImpl.setCoverFld4("");
		}
		else {
			productCoversImpl.setCoverFld4(coverFld4);
		}

		productCoversImpl.resetOriginalValues();

		return productCoversImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		productCode = objectInput.readLong();

		sectionCode = objectInput.readLong();
		coverCode = objectInput.readUTF();
		coverName = objectInput.readUTF();
		coverNameAr = objectInput.readUTF();
		coverDesc = objectInput.readUTF();
		coverDescAr = objectInput.readUTF();
		coverPremium = objectInput.readUTF();
		coverFld1 = objectInput.readUTF();
		coverFld2 = objectInput.readUTF();
		coverFld3 = objectInput.readUTF();
		coverFld4 = objectInput.readUTF();

		productCoversPK = new ProductCoversPK(
			productCode, sectionCode, coverCode);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(productCode);

		objectOutput.writeLong(sectionCode);

		if (coverCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coverCode);
		}

		if (coverName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coverName);
		}

		if (coverNameAr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coverNameAr);
		}

		if (coverDesc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coverDesc);
		}

		if (coverDescAr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coverDescAr);
		}

		if (coverPremium == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coverPremium);
		}

		if (coverFld1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coverFld1);
		}

		if (coverFld2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coverFld2);
		}

		if (coverFld3 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coverFld3);
		}

		if (coverFld4 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coverFld4);
		}
	}

	public long productCode;
	public long sectionCode;
	public String coverCode;
	public String coverName;
	public String coverNameAr;
	public String coverDesc;
	public String coverDescAr;
	public String coverPremium;
	public String coverFld1;
	public String coverFld2;
	public String coverFld3;
	public String coverFld4;
	public transient ProductCoversPK productCoversPK;

}