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
public class QuotationsNajmDetailsPK
	implements Comparable<QuotationsNajmDetailsPK>, Serializable {

	public String caseNumber;
	public long quotationId;

	public QuotationsNajmDetailsPK() {
	}

	public QuotationsNajmDetailsPK(String caseNumber, long quotationId) {
		this.caseNumber = caseNumber;
		this.quotationId = quotationId;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public long getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(long quotationId) {
		this.quotationId = quotationId;
	}

	@Override
	public int compareTo(QuotationsNajmDetailsPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = caseNumber.compareTo(pk.caseNumber);

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

		if (!(object instanceof QuotationsNajmDetailsPK)) {
			return false;
		}

		QuotationsNajmDetailsPK pk = (QuotationsNajmDetailsPK)object;

		if (caseNumber.equals(pk.caseNumber) &&
			(quotationId == pk.quotationId)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, caseNumber);
		hashCode = HashUtil.hash(hashCode, quotationId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("caseNumber=");

		sb.append(caseNumber);
		sb.append(", quotationId=");

		sb.append(quotationId);

		sb.append("}");

		return sb.toString();
	}

}