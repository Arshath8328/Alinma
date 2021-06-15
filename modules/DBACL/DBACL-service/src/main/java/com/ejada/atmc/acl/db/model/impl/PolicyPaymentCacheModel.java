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

package com.ejada.atmc.acl.db.model.impl;

import com.ejada.atmc.acl.db.model.PolicyPayment;
import com.ejada.atmc.acl.db.service.persistence.PolicyPaymentPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PolicyPayment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PolicyPaymentCacheModel
	implements CacheModel<PolicyPayment>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PolicyPaymentCacheModel)) {
			return false;
		}

		PolicyPaymentCacheModel policyPaymentCacheModel =
			(PolicyPaymentCacheModel)object;

		if (policyPaymentPK.equals(policyPaymentCacheModel.policyPaymentPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, policyPaymentPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{policyNo=");
		sb.append(policyNo);
		sb.append(", voucherNo=");
		sb.append(voucherNo);
		sb.append(", endtNo=");
		sb.append(endtNo);
		sb.append(", claimNo=");
		sb.append(claimNo);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append(", docDate=");
		sb.append(docDate);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", reference=");
		sb.append(reference);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PolicyPayment toEntityModel() {
		PolicyPaymentImpl policyPaymentImpl = new PolicyPaymentImpl();

		if (policyNo == null) {
			policyPaymentImpl.setPolicyNo("");
		}
		else {
			policyPaymentImpl.setPolicyNo(policyNo);
		}

		if (voucherNo == null) {
			policyPaymentImpl.setVoucherNo("");
		}
		else {
			policyPaymentImpl.setVoucherNo(voucherNo);
		}

		if (endtNo == null) {
			policyPaymentImpl.setEndtNo("");
		}
		else {
			policyPaymentImpl.setEndtNo(endtNo);
		}

		if (claimNo == null) {
			policyPaymentImpl.setClaimNo("");
		}
		else {
			policyPaymentImpl.setClaimNo(claimNo);
		}

		if (dueDate == Long.MIN_VALUE) {
			policyPaymentImpl.setDueDate(null);
		}
		else {
			policyPaymentImpl.setDueDate(new Date(dueDate));
		}

		if (docDate == Long.MIN_VALUE) {
			policyPaymentImpl.setDocDate(null);
		}
		else {
			policyPaymentImpl.setDocDate(new Date(docDate));
		}

		policyPaymentImpl.setAmount(amount);

		if (reference == null) {
			policyPaymentImpl.setReference("");
		}
		else {
			policyPaymentImpl.setReference(reference);
		}

		policyPaymentImpl.resetOriginalValues();

		return policyPaymentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		policyNo = objectInput.readUTF();
		voucherNo = objectInput.readUTF();
		endtNo = objectInput.readUTF();
		claimNo = objectInput.readUTF();
		dueDate = objectInput.readLong();
		docDate = objectInput.readLong();

		amount = objectInput.readDouble();
		reference = objectInput.readUTF();

		policyPaymentPK = new PolicyPaymentPK(policyNo, voucherNo);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (policyNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyNo);
		}

		if (voucherNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(voucherNo);
		}

		if (endtNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(endtNo);
		}

		if (claimNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(claimNo);
		}

		objectOutput.writeLong(dueDate);
		objectOutput.writeLong(docDate);

		objectOutput.writeDouble(amount);

		if (reference == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reference);
		}
	}

	public String policyNo;
	public String voucherNo;
	public String endtNo;
	public String claimNo;
	public long dueDate;
	public long docDate;
	public double amount;
	public String reference;
	public transient PolicyPaymentPK policyPaymentPK;

}