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

import com.ejada.atmc.acl.db.model.SMS;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SMS in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SMSCacheModel implements CacheModel<SMS>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SMSCacheModel)) {
			return false;
		}

		SMSCacheModel smsCacheModel = (SMSCacheModel)object;

		if (ID == smsCacheModel.ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", message=");
		sb.append(message);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", smsType=");
		sb.append(smsType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SMS toEntityModel() {
		SMSImpl smsImpl = new SMSImpl();

		smsImpl.setID(ID);

		if (message == null) {
			smsImpl.setMessage("");
		}
		else {
			smsImpl.setMessage(message);
		}

		if (mobile == null) {
			smsImpl.setMobile("");
		}
		else {
			smsImpl.setMobile(mobile);
		}

		if (smsType == null) {
			smsImpl.setSmsType("");
		}
		else {
			smsImpl.setSmsType(smsType);
		}

		smsImpl.resetOriginalValues();

		return smsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID = objectInput.readLong();
		message = objectInput.readUTF();
		mobile = objectInput.readUTF();
		smsType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ID);

		if (message == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(message);
		}

		if (mobile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobile);
		}

		if (smsType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(smsType);
		}
	}

	public long ID;

	public String message;
	public String mobile;
	public String smsType;

}