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

import com.ejada.atmc.acl.db.model.ServiceRequestMessages;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ServiceRequestMessages in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ServiceRequestMessagesCacheModel
	implements CacheModel<ServiceRequestMessages>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ServiceRequestMessagesCacheModel)) {
			return false;
		}

		ServiceRequestMessagesCacheModel serviceRequestMessagesCacheModel =
			(ServiceRequestMessagesCacheModel)object;

		if (MESSAGE_ID == serviceRequestMessagesCacheModel.MESSAGE_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, MESSAGE_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{MESSAGE_ID=");
		sb.append(MESSAGE_ID);
		sb.append(", REFERENCE_NO=");
		sb.append(REFERENCE_NO);
		sb.append(", USER_ID=");
		sb.append(USER_ID);
		sb.append(", USER_NAME=");
		sb.append(USER_NAME);
		sb.append(", USER_TYPE=");
		sb.append(USER_TYPE);
		sb.append(", USER_MESSAGE=");
		sb.append(USER_MESSAGE);
		sb.append(", TIME_STAMP=");
		sb.append(TIME_STAMP);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServiceRequestMessages toEntityModel() {
		ServiceRequestMessagesImpl serviceRequestMessagesImpl =
			new ServiceRequestMessagesImpl();

		serviceRequestMessagesImpl.setMESSAGE_ID(MESSAGE_ID);

		if (REFERENCE_NO == null) {
			serviceRequestMessagesImpl.setREFERENCE_NO("");
		}
		else {
			serviceRequestMessagesImpl.setREFERENCE_NO(REFERENCE_NO);
		}

		if (USER_ID == null) {
			serviceRequestMessagesImpl.setUSER_ID("");
		}
		else {
			serviceRequestMessagesImpl.setUSER_ID(USER_ID);
		}

		if (USER_NAME == null) {
			serviceRequestMessagesImpl.setUSER_NAME("");
		}
		else {
			serviceRequestMessagesImpl.setUSER_NAME(USER_NAME);
		}

		if (USER_TYPE == null) {
			serviceRequestMessagesImpl.setUSER_TYPE("");
		}
		else {
			serviceRequestMessagesImpl.setUSER_TYPE(USER_TYPE);
		}

		if (USER_MESSAGE == null) {
			serviceRequestMessagesImpl.setUSER_MESSAGE("");
		}
		else {
			serviceRequestMessagesImpl.setUSER_MESSAGE(USER_MESSAGE);
		}

		if (TIME_STAMP == Long.MIN_VALUE) {
			serviceRequestMessagesImpl.setTIME_STAMP(null);
		}
		else {
			serviceRequestMessagesImpl.setTIME_STAMP(new Date(TIME_STAMP));
		}

		serviceRequestMessagesImpl.resetOriginalValues();

		return serviceRequestMessagesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		MESSAGE_ID = objectInput.readLong();
		REFERENCE_NO = objectInput.readUTF();
		USER_ID = objectInput.readUTF();
		USER_NAME = objectInput.readUTF();
		USER_TYPE = objectInput.readUTF();
		USER_MESSAGE = objectInput.readUTF();
		TIME_STAMP = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(MESSAGE_ID);

		if (REFERENCE_NO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(REFERENCE_NO);
		}

		if (USER_ID == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(USER_ID);
		}

		if (USER_NAME == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(USER_NAME);
		}

		if (USER_TYPE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(USER_TYPE);
		}

		if (USER_MESSAGE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(USER_MESSAGE);
		}

		objectOutput.writeLong(TIME_STAMP);
	}

	public long MESSAGE_ID;

	public String REFERENCE_NO;

	public String USER_ID;

	public String USER_NAME;

	public String USER_TYPE;

	public String USER_MESSAGE;

	public long TIME_STAMP;

}