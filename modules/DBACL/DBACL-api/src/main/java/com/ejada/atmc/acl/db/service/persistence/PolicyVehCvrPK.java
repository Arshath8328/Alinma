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
public class PolicyVehCvrPK
	implements Comparable<PolicyVehCvrPK>, Serializable {

	public String policyNo;
	public String vehId;
	public String description;

	public PolicyVehCvrPK() {
	}

	public PolicyVehCvrPK(String policyNo, String vehId, String description) {
		this.policyNo = policyNo;
		this.vehId = vehId;
		this.description = description;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getVehId() {
		return vehId;
	}

	public void setVehId(String vehId) {
		this.vehId = vehId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int compareTo(PolicyVehCvrPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = policyNo.compareTo(pk.policyNo);

		if (value != 0) {
			return value;
		}

		value = vehId.compareTo(pk.vehId);

		if (value != 0) {
			return value;
		}

		value = description.compareTo(pk.description);

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

		if (!(object instanceof PolicyVehCvrPK)) {
			return false;
		}

		PolicyVehCvrPK pk = (PolicyVehCvrPK)object;

		if (policyNo.equals(pk.policyNo) && vehId.equals(pk.vehId) &&
			description.equals(pk.description)) {

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
		hashCode = HashUtil.hash(hashCode, description);

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
		sb.append(", description=");

		sb.append(description);

		sb.append("}");

		return sb.toString();
	}

}