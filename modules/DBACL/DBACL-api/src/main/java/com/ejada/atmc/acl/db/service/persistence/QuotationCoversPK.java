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

package com.ejada.atmc.acl.db.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class QuotationCoversPK
	implements Comparable<QuotationCoversPK>, Serializable {

	public long addCoverId;
	public long quotationId;

	public QuotationCoversPK() {
	}

	public QuotationCoversPK(long addCoverId, long quotationId) {
		this.addCoverId = addCoverId;
		this.quotationId = quotationId;
	}

	public long getAddCoverId() {
		return addCoverId;
	}

	public void setAddCoverId(long addCoverId) {
		this.addCoverId = addCoverId;
	}

	public long getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(long quotationId) {
		this.quotationId = quotationId;
	}

	@Override
	public int compareTo(QuotationCoversPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (addCoverId < pk.addCoverId) {
			value = -1;
		}
		else if (addCoverId > pk.addCoverId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (quotationId < pk.quotationId) {
			value = -1;
		}
		else if (quotationId > pk.quotationId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof QuotationCoversPK)) {
			return false;
		}

		QuotationCoversPK pk = (QuotationCoversPK)object;

		if ((addCoverId == pk.addCoverId) && (quotationId == pk.quotationId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, addCoverId);
		hashCode = HashUtil.hash(hashCode, quotationId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("addCoverId=");

		sb.append(addCoverId);
		sb.append(", quotationId=");

		sb.append(quotationId);

		sb.append("}");

		return sb.toString();
	}

}