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

import com.ejada.atmc.acl.db.model.QuotationCovers;
import com.ejada.atmc.acl.db.service.persistence.QuotationCoversPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing QuotationCovers in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class QuotationCoversCacheModel
	implements CacheModel<QuotationCovers>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof QuotationCoversCacheModel)) {
			return false;
		}

		QuotationCoversCacheModel quotationCoversCacheModel =
			(QuotationCoversCacheModel)object;

		if (quotationCoversPK.equals(
				quotationCoversCacheModel.quotationCoversPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, quotationCoversPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{addCoverId=");
		sb.append(addCoverId);
		sb.append(", quotationId=");
		sb.append(quotationId);
		sb.append(", coverCode=");
		sb.append(coverCode);
		sb.append(", sectionCode=");
		sb.append(sectionCode);
		sb.append(", coverEffFromDate=");
		sb.append(coverEffFromDate);
		sb.append(", coverEffToDate=");
		sb.append(coverEffToDate);
		sb.append(", coverPrem=");
		sb.append(coverPrem);
		sb.append(", coverRate=");
		sb.append(coverRate);
		sb.append(", coverSi=");
		sb.append(coverSi);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public QuotationCovers toEntityModel() {
		QuotationCoversImpl quotationCoversImpl = new QuotationCoversImpl();

		quotationCoversImpl.setAddCoverId(addCoverId);
		quotationCoversImpl.setQuotationId(quotationId);

		if (coverCode == null) {
			quotationCoversImpl.setCoverCode("");
		}
		else {
			quotationCoversImpl.setCoverCode(coverCode);
		}

		quotationCoversImpl.setSectionCode(sectionCode);

		if (coverEffFromDate == Long.MIN_VALUE) {
			quotationCoversImpl.setCoverEffFromDate(null);
		}
		else {
			quotationCoversImpl.setCoverEffFromDate(new Date(coverEffFromDate));
		}

		if (coverEffToDate == Long.MIN_VALUE) {
			quotationCoversImpl.setCoverEffToDate(null);
		}
		else {
			quotationCoversImpl.setCoverEffToDate(new Date(coverEffToDate));
		}

		quotationCoversImpl.setCoverPrem(coverPrem);
		quotationCoversImpl.setCoverRate(coverRate);
		quotationCoversImpl.setCoverSi(coverSi);

		quotationCoversImpl.resetOriginalValues();

		return quotationCoversImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		addCoverId = objectInput.readLong();

		quotationId = objectInput.readLong();
		coverCode = objectInput.readUTF();

		sectionCode = objectInput.readLong();
		coverEffFromDate = objectInput.readLong();
		coverEffToDate = objectInput.readLong();

		coverPrem = objectInput.readLong();

		coverRate = objectInput.readLong();

		coverSi = objectInput.readLong();

		quotationCoversPK = new QuotationCoversPK(addCoverId, quotationId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(addCoverId);

		objectOutput.writeLong(quotationId);

		if (coverCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coverCode);
		}

		objectOutput.writeLong(sectionCode);
		objectOutput.writeLong(coverEffFromDate);
		objectOutput.writeLong(coverEffToDate);

		objectOutput.writeLong(coverPrem);

		objectOutput.writeLong(coverRate);

		objectOutput.writeLong(coverSi);
	}

	public long addCoverId;
	public long quotationId;
	public String coverCode;
	public long sectionCode;
	public long coverEffFromDate;
	public long coverEffToDate;
	public long coverPrem;
	public long coverRate;
	public long coverSi;
	public transient QuotationCoversPK quotationCoversPK;

}