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
public class PolicyVehDrvPK
	implements Comparable<PolicyVehDrvPK>, Serializable {

	public String policyNo;
	public long vehId;
	public String driverLicenseNo;

	public PolicyVehDrvPK() {
	}

	public PolicyVehDrvPK(String policyNo, long vehId, String driverLicenseNo) {
		this.policyNo = policyNo;
		this.vehId = vehId;
		this.driverLicenseNo = driverLicenseNo;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public long getVehId() {
		return vehId;
	}

	public void setVehId(long vehId) {
		this.vehId = vehId;
	}

	public String getDriverLicenseNo() {
		return driverLicenseNo;
	}

	public void setDriverLicenseNo(String driverLicenseNo) {
		this.driverLicenseNo = driverLicenseNo;
	}

	@Override
	public int compareTo(PolicyVehDrvPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = policyNo.compareTo(pk.policyNo);

		if (value != 0) {
			return value;
		}

		if (vehId < pk.vehId) {
			value = -1;
		}
		else if (vehId > pk.vehId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = driverLicenseNo.compareTo(pk.driverLicenseNo);

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

		if (!(object instanceof PolicyVehDrvPK)) {
			return false;
		}

		PolicyVehDrvPK pk = (PolicyVehDrvPK)object;

		if (policyNo.equals(pk.policyNo) && (vehId == pk.vehId) &&
			driverLicenseNo.equals(pk.driverLicenseNo)) {

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
		hashCode = HashUtil.hash(hashCode, vehId);
		hashCode = HashUtil.hash(hashCode, driverLicenseNo);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(8);

		sb.append("{");

		sb.append("policyNo=");

		sb.append(policyNo);
		sb.append(", vehId=");

		sb.append(vehId);
		sb.append(", driverLicenseNo=");

		sb.append(driverLicenseNo);

		sb.append("}");

		return sb.toString();
	}

}