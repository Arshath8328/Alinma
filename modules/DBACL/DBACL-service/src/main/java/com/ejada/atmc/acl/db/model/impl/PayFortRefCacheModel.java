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

import com.ejada.atmc.acl.db.model.PayFortRef;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PayFortRef in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PayFortRefCacheModel
	implements CacheModel<PayFortRef>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PayFortRefCacheModel)) {
			return false;
		}

		PayFortRefCacheModel payFortRefCacheModel =
			(PayFortRefCacheModel)object;

		if (id == payFortRefCacheModel.id) {
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
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", iqama_id=");
		sb.append(iqama_id);
		sb.append(", payFortRefNo=");
		sb.append(payFortRefNo);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PayFortRef toEntityModel() {
		PayFortRefImpl payFortRefImpl = new PayFortRefImpl();

		payFortRefImpl.setId(id);

		if (iqama_id == null) {
			payFortRefImpl.setIqama_id("");
		}
		else {
			payFortRefImpl.setIqama_id(iqama_id);
		}

		if (payFortRefNo == null) {
			payFortRefImpl.setPayFortRefNo("");
		}
		else {
			payFortRefImpl.setPayFortRefNo(payFortRefNo);
		}

		if (status == null) {
			payFortRefImpl.setStatus("");
		}
		else {
			payFortRefImpl.setStatus(status);
		}

		payFortRefImpl.resetOriginalValues();

		return payFortRefImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		iqama_id = objectInput.readUTF();
		payFortRefNo = objectInput.readUTF();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		if (iqama_id == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(iqama_id);
		}

		if (payFortRefNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(payFortRefNo);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public int id;
	public String iqama_id;
	public String payFortRefNo;
	public String status;

}