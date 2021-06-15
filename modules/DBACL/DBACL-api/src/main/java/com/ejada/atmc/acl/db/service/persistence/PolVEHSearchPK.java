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
public class PolVEHSearchPK
	implements Comparable<PolVEHSearchPK>, Serializable {

	public String policyNo;
	public String vehicleSEQCustom;

	public PolVEHSearchPK() {
	}

	public PolVEHSearchPK(String policyNo, String vehicleSEQCustom) {
		this.policyNo = policyNo;
		this.vehicleSEQCustom = vehicleSEQCustom;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getVehicleSEQCustom() {
		return vehicleSEQCustom;
	}

	public void setVehicleSEQCustom(String vehicleSEQCustom) {
		this.vehicleSEQCustom = vehicleSEQCustom;
	}

	@Override
	public int compareTo(PolVEHSearchPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = policyNo.compareTo(pk.policyNo);

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

		if (!(object instanceof PolVEHSearchPK)) {
			return false;
		}

		PolVEHSearchPK pk = (PolVEHSearchPK)object;

		if (policyNo.equals(pk.policyNo) &&
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
		hashCode = HashUtil.hash(hashCode, vehicleSEQCustom);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("policyNo=");

		sb.append(policyNo);
		sb.append(", vehicleSEQCustom=");

		sb.append(vehicleSEQCustom);

		sb.append("}");

		return sb.toString();
	}

}