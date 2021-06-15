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

import com.ejada.atmc.acl.db.model.QuotationsSeq;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing QuotationsSeq in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class QuotationsSeqCacheModel
	implements CacheModel<QuotationsSeq>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof QuotationsSeqCacheModel)) {
			return false;
		}

		QuotationsSeqCacheModel quotationsSeqCacheModel =
			(QuotationsSeqCacheModel)object;

		if (key.equals(quotationsSeqCacheModel.key)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, key);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{key=");
		sb.append(key);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public QuotationsSeq toEntityModel() {
		QuotationsSeqImpl quotationsSeqImpl = new QuotationsSeqImpl();

		if (key == null) {
			quotationsSeqImpl.setKey("");
		}
		else {
			quotationsSeqImpl.setKey(key);
		}

		if (value == null) {
			quotationsSeqImpl.setValue("");
		}
		else {
			quotationsSeqImpl.setValue(value);
		}

		quotationsSeqImpl.resetOriginalValues();

		return quotationsSeqImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		key = objectInput.readUTF();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (key == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (value == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public String key;
	public String value;

}