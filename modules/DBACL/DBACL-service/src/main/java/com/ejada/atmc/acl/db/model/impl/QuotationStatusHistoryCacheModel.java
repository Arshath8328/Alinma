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

import com.ejada.atmc.acl.db.model.QuotationStatusHistory;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing QuotationStatusHistory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class QuotationStatusHistoryCacheModel
	implements CacheModel<QuotationStatusHistory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof QuotationStatusHistoryCacheModel)) {
			return false;
		}

		QuotationStatusHistoryCacheModel quotationStatusHistoryCacheModel =
			(QuotationStatusHistoryCacheModel)object;

		if (historyId == quotationStatusHistoryCacheModel.historyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, historyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{historyId=");
		sb.append(historyId);
		sb.append(", quotationId=");
		sb.append(quotationId);
		sb.append(", dateTime=");
		sb.append(dateTime);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", status=");
		sb.append(status);
		sb.append(", reason=");
		sb.append(reason);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public QuotationStatusHistory toEntityModel() {
		QuotationStatusHistoryImpl quotationStatusHistoryImpl =
			new QuotationStatusHistoryImpl();

		quotationStatusHistoryImpl.setHistoryId(historyId);
		quotationStatusHistoryImpl.setQuotationId(quotationId);

		if (dateTime == Long.MIN_VALUE) {
			quotationStatusHistoryImpl.setDateTime(null);
		}
		else {
			quotationStatusHistoryImpl.setDateTime(new Date(dateTime));
		}

		if (userName == null) {
			quotationStatusHistoryImpl.setUserName("");
		}
		else {
			quotationStatusHistoryImpl.setUserName(userName);
		}

		if (status == null) {
			quotationStatusHistoryImpl.setStatus("");
		}
		else {
			quotationStatusHistoryImpl.setStatus(status);
		}

		if (reason == null) {
			quotationStatusHistoryImpl.setReason("");
		}
		else {
			quotationStatusHistoryImpl.setReason(reason);
		}

		quotationStatusHistoryImpl.resetOriginalValues();

		return quotationStatusHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		historyId = objectInput.readLong();

		quotationId = objectInput.readLong();
		dateTime = objectInput.readLong();
		userName = objectInput.readUTF();
		status = objectInput.readUTF();
		reason = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(historyId);

		objectOutput.writeLong(quotationId);
		objectOutput.writeLong(dateTime);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (reason == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reason);
		}
	}

	public long historyId;
	public long quotationId;
	public long dateTime;
	public String userName;
	public String status;
	public String reason;

}