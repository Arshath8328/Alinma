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
public class ClaimODSearchPK
	implements Comparable<ClaimODSearchPK>, Serializable {

	public String policyNo;
	public String reportNo;
	public String vehicleSEQCustom;

	public ClaimODSearchPK() {
	}

	public ClaimODSearchPK(
		String policyNo, String reportNo, String vehicleSEQCustom) {

		this.policyNo = policyNo;
		this.reportNo = reportNo;
		this.vehicleSEQCustom = vehicleSEQCustom;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	public String getVehicleSEQCustom() {
		return vehicleSEQCustom;
	}

	public void setVehicleSEQCustom(String vehicleSEQCustom) {
		this.vehicleSEQCustom = vehicleSEQCustom;
	}

	@Override
	public int compareTo(ClaimODSearchPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = policyNo.compareTo(pk.policyNo);

		if (value != 0) {
			return value;
		}

		value = reportNo.compareTo(pk.reportNo);

		if (value != 0) {
			return value;
		}

		value = vehicleSEQCustom.compareTo(pk.vehicleSEQCustom);

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

		if (!(object instanceof ClaimODSearchPK)) {
			return false;
		}

		ClaimODSearchPK pk = (ClaimODSearchPK)object;

		if (policyNo.equals(pk.policyNo) && reportNo.equals(pk.reportNo) &&
			vehicleSEQCustom.equals(pk.vehicleSEQCustom)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, policyNo);
		hashCode = HashUtil.hash(hashCode, reportNo);
		hashCode = HashUtil.hash(hashCode, vehicleSEQCustom);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(8);

		sb.append("{");

		sb.append("policyNo=");

		sb.append(policyNo);
		sb.append(", reportNo=");

		sb.append(reportNo);
		sb.append(", vehicleSEQCustom=");

		sb.append(vehicleSEQCustom);

		sb.append("}");

		return sb.toString();
	}

}