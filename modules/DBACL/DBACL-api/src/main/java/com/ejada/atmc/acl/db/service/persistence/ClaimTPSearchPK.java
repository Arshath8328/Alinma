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
public class ClaimTPSearchPK
	implements Comparable<ClaimTPSearchPK>, Serializable {

	public String reportNo;
	public String tpId;

	public ClaimTPSearchPK() {
	}

	public ClaimTPSearchPK(String reportNo, String tpId) {
		this.reportNo = reportNo;
		this.tpId = tpId;
	}

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	public String getTpId() {
		return tpId;
	}

	public void setTpId(String tpId) {
		this.tpId = tpId;
	}

	@Override
	public int compareTo(ClaimTPSearchPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = reportNo.compareTo(pk.reportNo);

		if (value != 0) {
			return value;
		}

		value = tpId.compareTo(pk.tpId);

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

		if (!(object instanceof ClaimTPSearchPK)) {
			return false;
		}

		ClaimTPSearchPK pk = (ClaimTPSearchPK)object;

		if (reportNo.equals(pk.reportNo) && tpId.equals(pk.tpId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, reportNo);
		hashCode = HashUtil.hash(hashCode, tpId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("reportNo=");

		sb.append(reportNo);
		sb.append(", tpId=");

		sb.append(tpId);

		sb.append("}");

		return sb.toString();
	}

}