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

import com.ejada.atmc.acl.db.model.ServiceRequestMaster;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ServiceRequestMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ServiceRequestMasterCacheModel
	implements CacheModel<ServiceRequestMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ServiceRequestMasterCacheModel)) {
			return false;
		}

		ServiceRequestMasterCacheModel serviceRequestMasterCacheModel =
			(ServiceRequestMasterCacheModel)object;

		if (REFERENCE_NO.equals(serviceRequestMasterCacheModel.REFERENCE_NO)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, REFERENCE_NO);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{REFERENCE_NO=");
		sb.append(REFERENCE_NO);
		sb.append(", SOURCE=");
		sb.append(SOURCE);
		sb.append(", REQUEST_CATEGORY=");
		sb.append(REQUEST_CATEGORY);
		sb.append(", REQUEST_TYPE=");
		sb.append(REQUEST_TYPE);
		sb.append(", PRODUCT_TYPE=");
		sb.append(PRODUCT_TYPE);
		sb.append(", REQUEST_MESSAGE=");
		sb.append(REQUEST_MESSAGE);
		sb.append(", IQAMA_ID=");
		sb.append(IQAMA_ID);
		sb.append(", EMAIL=");
		sb.append(EMAIL);
		sb.append(", MOBILE=");
		sb.append(MOBILE);
		sb.append(", REQUEST_STATUS=");
		sb.append(REQUEST_STATUS);
		sb.append(", EMAIL_FLAG=");
		sb.append(EMAIL_FLAG);
		sb.append(", CREATOR_USER_ID=");
		sb.append(CREATOR_USER_ID);
		sb.append(", CREATION_DATE=");
		sb.append(CREATION_DATE);
		sb.append(", CREATOR_USER_TYPE=");
		sb.append(CREATOR_USER_TYPE);
		sb.append(", ASSIGNED_TO=");
		sb.append(ASSIGNED_TO);
		sb.append(", USER_NAME=");
		sb.append(USER_NAME);
		sb.append(", IBAN_NUMBER=");
		sb.append(IBAN_NUMBER);
		sb.append(", ESCALATION_FLAG=");
		sb.append(ESCALATION_FLAG);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServiceRequestMaster toEntityModel() {
		ServiceRequestMasterImpl serviceRequestMasterImpl =
			new ServiceRequestMasterImpl();

		if (REFERENCE_NO == null) {
			serviceRequestMasterImpl.setREFERENCE_NO("");
		}
		else {
			serviceRequestMasterImpl.setREFERENCE_NO(REFERENCE_NO);
		}

		if (SOURCE == null) {
			serviceRequestMasterImpl.setSOURCE("");
		}
		else {
			serviceRequestMasterImpl.setSOURCE(SOURCE);
		}

		if (REQUEST_CATEGORY == null) {
			serviceRequestMasterImpl.setREQUEST_CATEGORY("");
		}
		else {
			serviceRequestMasterImpl.setREQUEST_CATEGORY(REQUEST_CATEGORY);
		}

		if (REQUEST_TYPE == null) {
			serviceRequestMasterImpl.setREQUEST_TYPE("");
		}
		else {
			serviceRequestMasterImpl.setREQUEST_TYPE(REQUEST_TYPE);
		}

		if (PRODUCT_TYPE == null) {
			serviceRequestMasterImpl.setPRODUCT_TYPE("");
		}
		else {
			serviceRequestMasterImpl.setPRODUCT_TYPE(PRODUCT_TYPE);
		}

		if (REQUEST_MESSAGE == null) {
			serviceRequestMasterImpl.setREQUEST_MESSAGE("");
		}
		else {
			serviceRequestMasterImpl.setREQUEST_MESSAGE(REQUEST_MESSAGE);
		}

		if (IQAMA_ID == null) {
			serviceRequestMasterImpl.setIQAMA_ID("");
		}
		else {
			serviceRequestMasterImpl.setIQAMA_ID(IQAMA_ID);
		}

		if (EMAIL == null) {
			serviceRequestMasterImpl.setEMAIL("");
		}
		else {
			serviceRequestMasterImpl.setEMAIL(EMAIL);
		}

		if (MOBILE == null) {
			serviceRequestMasterImpl.setMOBILE("");
		}
		else {
			serviceRequestMasterImpl.setMOBILE(MOBILE);
		}

		if (REQUEST_STATUS == null) {
			serviceRequestMasterImpl.setREQUEST_STATUS("");
		}
		else {
			serviceRequestMasterImpl.setREQUEST_STATUS(REQUEST_STATUS);
		}

		serviceRequestMasterImpl.setEMAIL_FLAG(EMAIL_FLAG);

		if (CREATOR_USER_ID == null) {
			serviceRequestMasterImpl.setCREATOR_USER_ID("");
		}
		else {
			serviceRequestMasterImpl.setCREATOR_USER_ID(CREATOR_USER_ID);
		}

		if (CREATION_DATE == Long.MIN_VALUE) {
			serviceRequestMasterImpl.setCREATION_DATE(null);
		}
		else {
			serviceRequestMasterImpl.setCREATION_DATE(new Date(CREATION_DATE));
		}

		if (CREATOR_USER_TYPE == null) {
			serviceRequestMasterImpl.setCREATOR_USER_TYPE("");
		}
		else {
			serviceRequestMasterImpl.setCREATOR_USER_TYPE(CREATOR_USER_TYPE);
		}

		if (ASSIGNED_TO == null) {
			serviceRequestMasterImpl.setASSIGNED_TO("");
		}
		else {
			serviceRequestMasterImpl.setASSIGNED_TO(ASSIGNED_TO);
		}

		if (USER_NAME == null) {
			serviceRequestMasterImpl.setUSER_NAME("");
		}
		else {
			serviceRequestMasterImpl.setUSER_NAME(USER_NAME);
		}

		if (IBAN_NUMBER == null) {
			serviceRequestMasterImpl.setIBAN_NUMBER("");
		}
		else {
			serviceRequestMasterImpl.setIBAN_NUMBER(IBAN_NUMBER);
		}

		serviceRequestMasterImpl.setESCALATION_FLAG(ESCALATION_FLAG);

		serviceRequestMasterImpl.resetOriginalValues();

		return serviceRequestMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		REFERENCE_NO = objectInput.readUTF();
		SOURCE = objectInput.readUTF();
		REQUEST_CATEGORY = objectInput.readUTF();
		REQUEST_TYPE = objectInput.readUTF();
		PRODUCT_TYPE = objectInput.readUTF();
		REQUEST_MESSAGE = objectInput.readUTF();
		IQAMA_ID = objectInput.readUTF();
		EMAIL = objectInput.readUTF();
		MOBILE = objectInput.readUTF();
		REQUEST_STATUS = objectInput.readUTF();

		EMAIL_FLAG = objectInput.readBoolean();
		CREATOR_USER_ID = objectInput.readUTF();
		CREATION_DATE = objectInput.readLong();
		CREATOR_USER_TYPE = objectInput.readUTF();
		ASSIGNED_TO = objectInput.readUTF();
		USER_NAME = objectInput.readUTF();
		IBAN_NUMBER = objectInput.readUTF();

		ESCALATION_FLAG = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (REFERENCE_NO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(REFERENCE_NO);
		}

		if (SOURCE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(SOURCE);
		}

		if (REQUEST_CATEGORY == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(REQUEST_CATEGORY);
		}

		if (REQUEST_TYPE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(REQUEST_TYPE);
		}

		if (PRODUCT_TYPE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PRODUCT_TYPE);
		}

		if (REQUEST_MESSAGE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(REQUEST_MESSAGE);
		}

		if (IQAMA_ID == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(IQAMA_ID);
		}

		if (EMAIL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(EMAIL);
		}

		if (MOBILE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(MOBILE);
		}

		if (REQUEST_STATUS == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(REQUEST_STATUS);
		}

		objectOutput.writeBoolean(EMAIL_FLAG);

		if (CREATOR_USER_ID == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CREATOR_USER_ID);
		}

		objectOutput.writeLong(CREATION_DATE);

		if (CREATOR_USER_TYPE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CREATOR_USER_TYPE);
		}

		if (ASSIGNED_TO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ASSIGNED_TO);
		}

		if (USER_NAME == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(USER_NAME);
		}

		if (IBAN_NUMBER == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(IBAN_NUMBER);
		}

		objectOutput.writeBoolean(ESCALATION_FLAG);
	}

	public String REFERENCE_NO;

	public String SOURCE;

	public String REQUEST_CATEGORY;

	public String REQUEST_TYPE;

	public String PRODUCT_TYPE;

	public String REQUEST_MESSAGE;

	public String IQAMA_ID;

	public String EMAIL;

	public String MOBILE;

	public String REQUEST_STATUS;

	public boolean EMAIL_FLAG;

	public String CREATOR_USER_ID;

	public long CREATION_DATE;

	public String CREATOR_USER_TYPE;

	public String ASSIGNED_TO;

	public String USER_NAME;

	public String IBAN_NUMBER;

	public boolean ESCALATION_FLAG;

}