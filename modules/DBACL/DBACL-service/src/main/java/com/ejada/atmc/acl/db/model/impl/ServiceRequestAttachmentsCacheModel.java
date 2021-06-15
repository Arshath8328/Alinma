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

import com.ejada.atmc.acl.db.model.ServiceRequestAttachments;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ServiceRequestAttachments in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ServiceRequestAttachmentsCacheModel
	implements CacheModel<ServiceRequestAttachments>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ServiceRequestAttachmentsCacheModel)) {
			return false;
		}

		ServiceRequestAttachmentsCacheModel
			serviceRequestAttachmentsCacheModel =
				(ServiceRequestAttachmentsCacheModel)object;

		if (FILE_ID == serviceRequestAttachmentsCacheModel.FILE_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, FILE_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{FILE_ID=");
		sb.append(FILE_ID);
		sb.append(", REFERENCE_NO=");
		sb.append(REFERENCE_NO);
		sb.append(", ACTION_ID=");
		sb.append(ACTION_ID);
		sb.append(", FILE_NAME=");
		sb.append(FILE_NAME);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServiceRequestAttachments toEntityModel() {
		ServiceRequestAttachmentsImpl serviceRequestAttachmentsImpl =
			new ServiceRequestAttachmentsImpl();

		serviceRequestAttachmentsImpl.setFILE_ID(FILE_ID);

		if (REFERENCE_NO == null) {
			serviceRequestAttachmentsImpl.setREFERENCE_NO("");
		}
		else {
			serviceRequestAttachmentsImpl.setREFERENCE_NO(REFERENCE_NO);
		}

		if (ACTION_ID == null) {
			serviceRequestAttachmentsImpl.setACTION_ID("");
		}
		else {
			serviceRequestAttachmentsImpl.setACTION_ID(ACTION_ID);
		}

		if (FILE_NAME == null) {
			serviceRequestAttachmentsImpl.setFILE_NAME("");
		}
		else {
			serviceRequestAttachmentsImpl.setFILE_NAME(FILE_NAME);
		}

		serviceRequestAttachmentsImpl.resetOriginalValues();

		return serviceRequestAttachmentsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		FILE_ID = objectInput.readLong();
		REFERENCE_NO = objectInput.readUTF();
		ACTION_ID = objectInput.readUTF();
		FILE_NAME = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(FILE_ID);

		if (REFERENCE_NO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(REFERENCE_NO);
		}

		if (ACTION_ID == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ACTION_ID);
		}

		if (FILE_NAME == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(FILE_NAME);
		}
	}

	public long FILE_ID;

	public String REFERENCE_NO;

	public String ACTION_ID;

	public String FILE_NAME;

}