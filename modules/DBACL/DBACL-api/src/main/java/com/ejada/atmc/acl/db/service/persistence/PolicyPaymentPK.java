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
public class PolicyPaymentPK
	implements Comparable<PolicyPaymentPK>, Serializable {

	public String policyNo;
	public String voucherNo;

	public PolicyPaymentPK() {
	}

	public PolicyPaymentPK(String policyNo, String voucherNo) {
		this.policyNo = policyNo;
		this.voucherNo = voucherNo;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

	@Override
	public int compareTo(PolicyPaymentPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = policyNo.compareTo(pk.policyNo);

		if (value != 0) {
			return value;
		}

		value = voucherNo.compareTo(pk.voucherNo);

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

		if (!(object instanceof PolicyPaymentPK)) {
			return false;
		}

		PolicyPaymentPK pk = (PolicyPaymentPK)object;

		if (policyNo.equals(pk.policyNo) && voucherNo.equals(pk.voucherNo)) {
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
		hashCode = HashUtil.hash(hashCode, voucherNo);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("policyNo=");

		sb.append(policyNo);
		sb.append(", voucherNo=");

		sb.append(voucherNo);

		sb.append("}");

		return sb.toString();
	}

}