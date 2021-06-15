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
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import aQute.bnd.annotation.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class QuotationDriversPK implements Comparable<QuotationDriversPK>,
	Serializable {
	public long addDriverId;
	public long quotationId;

	public QuotationDriversPK() {
	}

	public QuotationDriversPK(long addDriverId, long quotationId) {
		this.addDriverId = addDriverId;
		this.quotationId = quotationId;
	}

	public long getAddDriverId() {
		return addDriverId;
	}

	public void setAddDriverId(long addDriverId) {
		this.addDriverId = addDriverId;
	}

	public long getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(long quotationId) {
		this.quotationId = quotationId;
	}

	@Override
	public int compareTo(QuotationDriversPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (addDriverId < pk.addDriverId) {
			value = -1;
		}
		else if (addDriverId > pk.addDriverId) {
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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QuotationDriversPK)) {
			return false;
		}

		QuotationDriversPK pk = (QuotationDriversPK)obj;

		if ((addDriverId == pk.addDriverId) && (quotationId == pk.quotationId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, addDriverId);
		hashCode = HashUtil.hash(hashCode, quotationId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("addDriverId");
		sb.append(StringPool.EQUAL);
		sb.append(addDriverId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("quotationId");
		sb.append(StringPool.EQUAL);
		sb.append(quotationId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}