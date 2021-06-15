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

import com.ejada.atmc.acl.db.model.YakeenDataSave;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing YakeenDataSave in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class YakeenDataSaveCacheModel
	implements CacheModel<YakeenDataSave>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof YakeenDataSaveCacheModel)) {
			return false;
		}

		YakeenDataSaveCacheModel yakeenDataSaveCacheModel =
			(YakeenDataSaveCacheModel)object;

		if (Id.equals(yakeenDataSaveCacheModel.Id)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, Id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{Id=");
		sb.append(Id);
		sb.append(", OldId=");
		sb.append(OldId);
		sb.append(", sequenceNumber=");
		sb.append(sequenceNumber);
		sb.append(", dob=");
		sb.append(dob);
		sb.append(", serviceName=");
		sb.append(serviceName);
		sb.append(", callingDate=");
		sb.append(callingDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", serviceOutput=");
		sb.append(serviceOutput);
		sb.append(", serviceCalledDate=");
		sb.append(serviceCalledDate);
		sb.append(", serviceErrorMessage=");
		sb.append(serviceErrorMessage);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public YakeenDataSave toEntityModel() {
		YakeenDataSaveImpl yakeenDataSaveImpl = new YakeenDataSaveImpl();

		if (Id == null) {
			yakeenDataSaveImpl.setId("");
		}
		else {
			yakeenDataSaveImpl.setId(Id);
		}

		if (OldId == null) {
			yakeenDataSaveImpl.setOldId("");
		}
		else {
			yakeenDataSaveImpl.setOldId(OldId);
		}

		if (sequenceNumber == null) {
			yakeenDataSaveImpl.setSequenceNumber("");
		}
		else {
			yakeenDataSaveImpl.setSequenceNumber(sequenceNumber);
		}

		if (dob == Long.MIN_VALUE) {
			yakeenDataSaveImpl.setDob(null);
		}
		else {
			yakeenDataSaveImpl.setDob(new Date(dob));
		}

		if (serviceName == null) {
			yakeenDataSaveImpl.setServiceName("");
		}
		else {
			yakeenDataSaveImpl.setServiceName(serviceName);
		}

		if (callingDate == Long.MIN_VALUE) {
			yakeenDataSaveImpl.setCallingDate(null);
		}
		else {
			yakeenDataSaveImpl.setCallingDate(new Date(callingDate));
		}

		if (status == null) {
			yakeenDataSaveImpl.setStatus("");
		}
		else {
			yakeenDataSaveImpl.setStatus(status);
		}

		if (serviceOutput == null) {
			yakeenDataSaveImpl.setServiceOutput("");
		}
		else {
			yakeenDataSaveImpl.setServiceOutput(serviceOutput);
		}

		if (serviceCalledDate == Long.MIN_VALUE) {
			yakeenDataSaveImpl.setServiceCalledDate(null);
		}
		else {
			yakeenDataSaveImpl.setServiceCalledDate(
				new Date(serviceCalledDate));
		}

		if (serviceErrorMessage == null) {
			yakeenDataSaveImpl.setServiceErrorMessage("");
		}
		else {
			yakeenDataSaveImpl.setServiceErrorMessage(serviceErrorMessage);
		}

		yakeenDataSaveImpl.resetOriginalValues();

		return yakeenDataSaveImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		Id = objectInput.readUTF();
		OldId = objectInput.readUTF();
		sequenceNumber = objectInput.readUTF();
		dob = objectInput.readLong();
		serviceName = objectInput.readUTF();
		callingDate = objectInput.readLong();
		status = objectInput.readUTF();
		serviceOutput = objectInput.readUTF();
		serviceCalledDate = objectInput.readLong();
		serviceErrorMessage = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (Id == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Id);
		}

		if (OldId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(OldId);
		}

		if (sequenceNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sequenceNumber);
		}

		objectOutput.writeLong(dob);

		if (serviceName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serviceName);
		}

		objectOutput.writeLong(callingDate);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (serviceOutput == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serviceOutput);
		}

		objectOutput.writeLong(serviceCalledDate);

		if (serviceErrorMessage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serviceErrorMessage);
		}
	}

	public String Id;
	public String OldId;
	public String sequenceNumber;
	public long dob;
	public String serviceName;
	public long callingDate;
	public String status;
	public String serviceOutput;
	public long serviceCalledDate;
	public String serviceErrorMessage;

}