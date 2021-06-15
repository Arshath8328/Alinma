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

import com.ejada.atmc.acl.db.model.ServiceRequestHistory;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ServiceRequestHistory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ServiceRequestHistoryCacheModel
	implements CacheModel<ServiceRequestHistory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ServiceRequestHistoryCacheModel)) {
			return false;
		}

		ServiceRequestHistoryCacheModel serviceRequestHistoryCacheModel =
			(ServiceRequestHistoryCacheModel)object;

		if (ACTION_ID == serviceRequestHistoryCacheModel.ACTION_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ACTION_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{ACTION_ID=");
		sb.append(ACTION_ID);
		sb.append(", REFERENCE_NO=");
		sb.append(REFERENCE_NO);
		sb.append(", ACTION_TYPE=");
		sb.append(ACTION_TYPE);
		sb.append(", ACTION_DETAILS=");
		sb.append(ACTION_DETAILS);
		sb.append(", ACTION_REMARKS=");
		sb.append(ACTION_REMARKS);
		sb.append(", ACTION_DATE=");
		sb.append(ACTION_DATE);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServiceRequestHistory toEntityModel() {
		ServiceRequestHistoryImpl serviceRequestHistoryImpl =
			new ServiceRequestHistoryImpl();

		serviceRequestHistoryImpl.setACTION_ID(ACTION_ID);

		if (REFERENCE_NO == null) {
			serviceRequestHistoryImpl.setREFERENCE_NO("");
		}
		else {
			serviceRequestHistoryImpl.setREFERENCE_NO(REFERENCE_NO);
		}

		if (ACTION_TYPE == null) {
			serviceRequestHistoryImpl.setACTION_TYPE("");
		}
		else {
			serviceRequestHistoryImpl.setACTION_TYPE(ACTION_TYPE);
		}

		if (ACTION_DETAILS == null) {
			serviceRequestHistoryImpl.setACTION_DETAILS("");
		}
		else {
			serviceRequestHistoryImpl.setACTION_DETAILS(ACTION_DETAILS);
		}

		if (ACTION_REMARKS == null) {
			serviceRequestHistoryImpl.setACTION_REMARKS("");
		}
		else {
			serviceRequestHistoryImpl.setACTION_REMARKS(ACTION_REMARKS);
		}

		if (ACTION_DATE == Long.MIN_VALUE) {
			serviceRequestHistoryImpl.setACTION_DATE(null);
		}
		else {
			serviceRequestHistoryImpl.setACTION_DATE(new Date(ACTION_DATE));
		}

		serviceRequestHistoryImpl.resetOriginalValues();

		return serviceRequestHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ACTION_ID = objectInput.readLong();
		REFERENCE_NO = objectInput.readUTF();
		ACTION_TYPE = objectInput.readUTF();
		ACTION_DETAILS = objectInput.readUTF();
		ACTION_REMARKS = objectInput.readUTF();
		ACTION_DATE = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ACTION_ID);

		if (REFERENCE_NO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(REFERENCE_NO);
		}

		if (ACTION_TYPE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ACTION_TYPE);
		}

		if (ACTION_DETAILS == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ACTION_DETAILS);
		}

		if (ACTION_REMARKS == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ACTION_REMARKS);
		}

		objectOutput.writeLong(ACTION_DATE);
	}

	public long ACTION_ID;

	public String REFERENCE_NO;

	public String ACTION_TYPE;

	public String ACTION_DETAILS;

	public String ACTION_REMARKS;

	public long ACTION_DATE;

}