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

import com.ejada.atmc.acl.db.model.QuotationAdminUploads;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing QuotationAdminUploads in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class QuotationAdminUploadsCacheModel
	implements CacheModel<QuotationAdminUploads>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof QuotationAdminUploadsCacheModel)) {
			return false;
		}

		QuotationAdminUploadsCacheModel quotationAdminUploadsCacheModel =
			(QuotationAdminUploadsCacheModel)object;

		if (id == quotationAdminUploadsCacheModel.id) {
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
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", quotationId=");
		sb.append(quotationId);
		sb.append(", fileName=");
		sb.append(fileName);

		return sb.toString();
	}

	@Override
	public QuotationAdminUploads toEntityModel() {
		QuotationAdminUploadsImpl quotationAdminUploadsImpl =
			new QuotationAdminUploadsImpl();

		quotationAdminUploadsImpl.setId(id);
		quotationAdminUploadsImpl.setQuotationId(quotationId);

		if (fileName == null) {
			quotationAdminUploadsImpl.setFileName("");
		}
		else {
			quotationAdminUploadsImpl.setFileName(fileName);
		}

		quotationAdminUploadsImpl.resetOriginalValues();

		return quotationAdminUploadsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();

		quotationId = objectInput.readLong();
		fileName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		objectOutput.writeLong(quotationId);

		if (fileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileName);
		}
	}

	public int id;
	public long quotationId;
	public String fileName;

}