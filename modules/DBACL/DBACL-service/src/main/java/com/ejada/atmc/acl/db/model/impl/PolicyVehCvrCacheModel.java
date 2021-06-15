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

import com.ejada.atmc.acl.db.model.PolicyVehCvr;
import com.ejada.atmc.acl.db.service.persistence.PolicyVehCvrPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PolicyVehCvr in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PolicyVehCvrCacheModel
	implements CacheModel<PolicyVehCvr>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PolicyVehCvrCacheModel)) {
			return false;
		}

		PolicyVehCvrCacheModel policyVehCvrCacheModel =
			(PolicyVehCvrCacheModel)object;

		if (policyVehCvrPK.equals(policyVehCvrCacheModel.policyVehCvrPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, policyVehCvrPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{policyNo=");
		sb.append(policyNo);
		sb.append(", vehId=");
		sb.append(vehId);
		sb.append(", cvrCode=");
		sb.append(cvrCode);
		sb.append(", description=");
		sb.append(description);
		sb.append(", cvrType=");
		sb.append(cvrType);
		sb.append(", benefitTerm=");
		sb.append(benefitTerm);
		sb.append(", premiumTerm=");
		sb.append(premiumTerm);
		sb.append(", premium=");
		sb.append(premium);
		sb.append(", sumCovered=");
		sb.append(sumCovered);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PolicyVehCvr toEntityModel() {
		PolicyVehCvrImpl policyVehCvrImpl = new PolicyVehCvrImpl();

		if (policyNo == null) {
			policyVehCvrImpl.setPolicyNo("");
		}
		else {
			policyVehCvrImpl.setPolicyNo(policyNo);
		}

		if (vehId == null) {
			policyVehCvrImpl.setVehId("");
		}
		else {
			policyVehCvrImpl.setVehId(vehId);
		}

		if (cvrCode == null) {
			policyVehCvrImpl.setCvrCode("");
		}
		else {
			policyVehCvrImpl.setCvrCode(cvrCode);
		}

		if (description == null) {
			policyVehCvrImpl.setDescription("");
		}
		else {
			policyVehCvrImpl.setDescription(description);
		}

		if (cvrType == null) {
			policyVehCvrImpl.setCvrType("");
		}
		else {
			policyVehCvrImpl.setCvrType(cvrType);
		}

		if (benefitTerm == null) {
			policyVehCvrImpl.setBenefitTerm("");
		}
		else {
			policyVehCvrImpl.setBenefitTerm(benefitTerm);
		}

		if (premiumTerm == null) {
			policyVehCvrImpl.setPremiumTerm("");
		}
		else {
			policyVehCvrImpl.setPremiumTerm(premiumTerm);
		}

		policyVehCvrImpl.setPremium(premium);
		policyVehCvrImpl.setSumCovered(sumCovered);

		policyVehCvrImpl.resetOriginalValues();

		return policyVehCvrImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		policyNo = objectInput.readUTF();
		vehId = objectInput.readUTF();
		cvrCode = objectInput.readUTF();
		description = objectInput.readUTF();
		cvrType = objectInput.readUTF();
		benefitTerm = objectInput.readUTF();
		premiumTerm = objectInput.readUTF();

		premium = objectInput.readLong();

		sumCovered = objectInput.readLong();

		policyVehCvrPK = new PolicyVehCvrPK(policyNo, vehId, description);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (policyNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyNo);
		}

		if (vehId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehId);
		}

		if (cvrCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cvrCode);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (cvrType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cvrType);
		}

		if (benefitTerm == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(benefitTerm);
		}

		if (premiumTerm == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(premiumTerm);
		}

		objectOutput.writeLong(premium);

		objectOutput.writeLong(sumCovered);
	}

	public String policyNo;
	public String vehId;
	public String cvrCode;
	public String description;
	public String cvrType;
	public String benefitTerm;
	public String premiumTerm;
	public long premium;
	public long sumCovered;
	public transient PolicyVehCvrPK policyVehCvrPK;

}