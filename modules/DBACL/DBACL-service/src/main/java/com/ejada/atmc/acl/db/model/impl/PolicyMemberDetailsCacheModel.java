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

import com.ejada.atmc.acl.db.model.PolicyMemberDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PolicyMemberDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PolicyMemberDetailsCacheModel
	implements CacheModel<PolicyMemberDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PolicyMemberDetailsCacheModel)) {
			return false;
		}

		PolicyMemberDetailsCacheModel policyMemberDetailsCacheModel =
			(PolicyMemberDetailsCacheModel)object;

		if (memberId == policyMemberDetailsCacheModel.memberId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, memberId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{policyNo=");
		sb.append(policyNo);
		sb.append(", memberName=");
		sb.append(memberName);
		sb.append(", memberSi=");
		sb.append(memberSi);
		sb.append(", memberId=");
		sb.append(memberId);
		sb.append(", memberGender=");
		sb.append(memberGender);
		sb.append(", memberDob=");
		sb.append(memberDob);
		sb.append(", memberLimit=");
		sb.append(memberLimit);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PolicyMemberDetails toEntityModel() {
		PolicyMemberDetailsImpl policyMemberDetailsImpl =
			new PolicyMemberDetailsImpl();

		if (policyNo == null) {
			policyMemberDetailsImpl.setPolicyNo("");
		}
		else {
			policyMemberDetailsImpl.setPolicyNo(policyNo);
		}

		if (memberName == null) {
			policyMemberDetailsImpl.setMemberName("");
		}
		else {
			policyMemberDetailsImpl.setMemberName(memberName);
		}

		policyMemberDetailsImpl.setMemberSi(memberSi);
		policyMemberDetailsImpl.setMemberId(memberId);

		if (memberGender == null) {
			policyMemberDetailsImpl.setMemberGender("");
		}
		else {
			policyMemberDetailsImpl.setMemberGender(memberGender);
		}

		if (memberDob == Long.MIN_VALUE) {
			policyMemberDetailsImpl.setMemberDob(null);
		}
		else {
			policyMemberDetailsImpl.setMemberDob(new Date(memberDob));
		}

		policyMemberDetailsImpl.setMemberLimit(memberLimit);

		policyMemberDetailsImpl.resetOriginalValues();

		return policyMemberDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		policyNo = objectInput.readUTF();
		memberName = objectInput.readUTF();

		memberSi = objectInput.readLong();

		memberId = objectInput.readLong();
		memberGender = objectInput.readUTF();
		memberDob = objectInput.readLong();

		memberLimit = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (policyNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyNo);
		}

		if (memberName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(memberName);
		}

		objectOutput.writeLong(memberSi);

		objectOutput.writeLong(memberId);

		if (memberGender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(memberGender);
		}

		objectOutput.writeLong(memberDob);

		objectOutput.writeLong(memberLimit);
	}

	public String policyNo;
	public String memberName;
	public long memberSi;
	public long memberId;
	public String memberGender;
	public long memberDob;
	public long memberLimit;

}