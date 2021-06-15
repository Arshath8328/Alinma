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
public class CLMNajmPK implements Comparable<CLMNajmPK>, Serializable {

	public String caseNo;
	public String cipiId;

	public CLMNajmPK() {
	}

	public CLMNajmPK(String caseNo, String cipiId) {
		this.caseNo = caseNo;
		this.cipiId = cipiId;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getCipiId() {
		return cipiId;
	}

	public void setCipiId(String cipiId) {
		this.cipiId = cipiId;
	}

	@Override
	public int compareTo(CLMNajmPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = caseNo.compareTo(pk.caseNo);

		if (value != 0) {
			return value;
		}

		value = cipiId.compareTo(pk.cipiId);

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

		if (!(object instanceof CLMNajmPK)) {
			return false;
		}

		CLMNajmPK pk = (CLMNajmPK)object;

		if (caseNo.equals(pk.caseNo) && cipiId.equals(pk.cipiId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, caseNo);
		hashCode = HashUtil.hash(hashCode, cipiId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("caseNo=");

		sb.append(caseNo);
		sb.append(", cipiId=");

		sb.append(cipiId);

		sb.append("}");

		return sb.toString();
	}

}