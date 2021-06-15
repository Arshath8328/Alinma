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

import com.ejada.atmc.acl.db.model.PolicyHDR;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PolicyHDR in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PolicyHDRCacheModel
	implements CacheModel<PolicyHDR>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PolicyHDRCacheModel)) {
			return false;
		}

		PolicyHDRCacheModel policyHDRCacheModel = (PolicyHDRCacheModel)object;

		if (policyNo.equals(policyHDRCacheModel.policyNo)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, policyNo);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(65);

		sb.append("{policyNo=");
		sb.append(policyNo);
		sb.append(", iqamaId=");
		sb.append(iqamaId);
		sb.append(", policyStatus=");
		sb.append(policyStatus);
		sb.append(", product=");
		sb.append(product);
		sb.append(", inceptionDate=");
		sb.append(inceptionDate);
		sb.append(", expiryDate=");
		sb.append(expiryDate);
		sb.append(", sumInsured=");
		sb.append(sumInsured);
		sb.append(", totalPremium=");
		sb.append(totalPremium);
		sb.append(", policyFees=");
		sb.append(policyFees);
		sb.append(", policyTaxes=");
		sb.append(policyTaxes);
		sb.append(", policyTerm=");
		sb.append(policyTerm);
		sb.append(", premium=");
		sb.append(premium);
		sb.append(", nextDueDate=");
		sb.append(nextDueDate);
		sb.append(", countPremMissed=");
		sb.append(countPremMissed);
		sb.append(", modeOfPayment=");
		sb.append(modeOfPayment);
		sb.append(", nextRenwalDate=");
		sb.append(nextRenwalDate);
		sb.append(", custName=");
		sb.append(custName);
		sb.append(", custBirthDate=");
		sb.append(custBirthDate);
		sb.append(", insuredName=");
		sb.append(insuredName);
		sb.append(", insuredBirthDate=");
		sb.append(insuredBirthDate);
		sb.append(", insuredId=");
		sb.append(insuredId);
		sb.append(", insuredMobile=");
		sb.append(insuredMobile);
		sb.append(", insuredEmail=");
		sb.append(insuredEmail);
		sb.append(", insuredAddr=");
		sb.append(insuredAddr);
		sb.append(", insuredGender=");
		sb.append(insuredGender);
		sb.append(", occuptation=");
		sb.append(occuptation);
		sb.append(", estExpiryDate=");
		sb.append(estExpiryDate);
		sb.append(", najmStatus=");
		sb.append(najmStatus);
		sb.append(", surrenderValue=");
		sb.append(surrenderValue);
		sb.append(", noOfRisk=");
		sb.append(noOfRisk);
		sb.append(", memberScheme=");
		sb.append(memberScheme);
		sb.append(", memberBenefits=");
		sb.append(memberBenefits);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PolicyHDR toEntityModel() {
		PolicyHDRImpl policyHDRImpl = new PolicyHDRImpl();

		if (policyNo == null) {
			policyHDRImpl.setPolicyNo("");
		}
		else {
			policyHDRImpl.setPolicyNo(policyNo);
		}

		if (iqamaId == null) {
			policyHDRImpl.setIqamaId("");
		}
		else {
			policyHDRImpl.setIqamaId(iqamaId);
		}

		if (policyStatus == null) {
			policyHDRImpl.setPolicyStatus("");
		}
		else {
			policyHDRImpl.setPolicyStatus(policyStatus);
		}

		if (product == null) {
			policyHDRImpl.setProduct("");
		}
		else {
			policyHDRImpl.setProduct(product);
		}

		if (inceptionDate == Long.MIN_VALUE) {
			policyHDRImpl.setInceptionDate(null);
		}
		else {
			policyHDRImpl.setInceptionDate(new Date(inceptionDate));
		}

		if (expiryDate == Long.MIN_VALUE) {
			policyHDRImpl.setExpiryDate(null);
		}
		else {
			policyHDRImpl.setExpiryDate(new Date(expiryDate));
		}

		policyHDRImpl.setSumInsured(sumInsured);
		policyHDRImpl.setTotalPremium(totalPremium);
		policyHDRImpl.setPolicyFees(policyFees);

		if (policyTaxes == null) {
			policyHDRImpl.setPolicyTaxes("");
		}
		else {
			policyHDRImpl.setPolicyTaxes(policyTaxes);
		}

		policyHDRImpl.setPolicyTerm(policyTerm);

		if (premium == null) {
			policyHDRImpl.setPremium("");
		}
		else {
			policyHDRImpl.setPremium(premium);
		}

		if (nextDueDate == Long.MIN_VALUE) {
			policyHDRImpl.setNextDueDate(null);
		}
		else {
			policyHDRImpl.setNextDueDate(new Date(nextDueDate));
		}

		policyHDRImpl.setCountPremMissed(countPremMissed);

		if (modeOfPayment == null) {
			policyHDRImpl.setModeOfPayment("");
		}
		else {
			policyHDRImpl.setModeOfPayment(modeOfPayment);
		}

		if (nextRenwalDate == Long.MIN_VALUE) {
			policyHDRImpl.setNextRenwalDate(null);
		}
		else {
			policyHDRImpl.setNextRenwalDate(new Date(nextRenwalDate));
		}

		if (custName == null) {
			policyHDRImpl.setCustName("");
		}
		else {
			policyHDRImpl.setCustName(custName);
		}

		if (custBirthDate == Long.MIN_VALUE) {
			policyHDRImpl.setCustBirthDate(null);
		}
		else {
			policyHDRImpl.setCustBirthDate(new Date(custBirthDate));
		}

		if (insuredName == null) {
			policyHDRImpl.setInsuredName("");
		}
		else {
			policyHDRImpl.setInsuredName(insuredName);
		}

		if (insuredBirthDate == Long.MIN_VALUE) {
			policyHDRImpl.setInsuredBirthDate(null);
		}
		else {
			policyHDRImpl.setInsuredBirthDate(new Date(insuredBirthDate));
		}

		if (insuredId == null) {
			policyHDRImpl.setInsuredId("");
		}
		else {
			policyHDRImpl.setInsuredId(insuredId);
		}

		if (insuredMobile == null) {
			policyHDRImpl.setInsuredMobile("");
		}
		else {
			policyHDRImpl.setInsuredMobile(insuredMobile);
		}

		if (insuredEmail == null) {
			policyHDRImpl.setInsuredEmail("");
		}
		else {
			policyHDRImpl.setInsuredEmail(insuredEmail);
		}

		if (insuredAddr == null) {
			policyHDRImpl.setInsuredAddr("");
		}
		else {
			policyHDRImpl.setInsuredAddr(insuredAddr);
		}

		if (insuredGender == null) {
			policyHDRImpl.setInsuredGender("");
		}
		else {
			policyHDRImpl.setInsuredGender(insuredGender);
		}

		if (occuptation == null) {
			policyHDRImpl.setOccuptation("");
		}
		else {
			policyHDRImpl.setOccuptation(occuptation);
		}

		if (estExpiryDate == Long.MIN_VALUE) {
			policyHDRImpl.setEstExpiryDate(null);
		}
		else {
			policyHDRImpl.setEstExpiryDate(new Date(estExpiryDate));
		}

		if (najmStatus == null) {
			policyHDRImpl.setNajmStatus("");
		}
		else {
			policyHDRImpl.setNajmStatus(najmStatus);
		}

		policyHDRImpl.setSurrenderValue(surrenderValue);
		policyHDRImpl.setNoOfRisk(noOfRisk);

		if (memberScheme == null) {
			policyHDRImpl.setMemberScheme("");
		}
		else {
			policyHDRImpl.setMemberScheme(memberScheme);
		}

		if (memberBenefits == null) {
			policyHDRImpl.setMemberBenefits("");
		}
		else {
			policyHDRImpl.setMemberBenefits(memberBenefits);
		}

		policyHDRImpl.resetOriginalValues();

		return policyHDRImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		policyNo = objectInput.readUTF();
		iqamaId = objectInput.readUTF();
		policyStatus = objectInput.readUTF();
		product = objectInput.readUTF();
		inceptionDate = objectInput.readLong();
		expiryDate = objectInput.readLong();

		sumInsured = objectInput.readLong();

		totalPremium = objectInput.readLong();

		policyFees = objectInput.readLong();
		policyTaxes = objectInput.readUTF();

		policyTerm = objectInput.readLong();
		premium = objectInput.readUTF();
		nextDueDate = objectInput.readLong();

		countPremMissed = objectInput.readLong();
		modeOfPayment = objectInput.readUTF();
		nextRenwalDate = objectInput.readLong();
		custName = objectInput.readUTF();
		custBirthDate = objectInput.readLong();
		insuredName = objectInput.readUTF();
		insuredBirthDate = objectInput.readLong();
		insuredId = objectInput.readUTF();
		insuredMobile = objectInput.readUTF();
		insuredEmail = objectInput.readUTF();
		insuredAddr = objectInput.readUTF();
		insuredGender = objectInput.readUTF();
		occuptation = objectInput.readUTF();
		estExpiryDate = objectInput.readLong();
		najmStatus = objectInput.readUTF();

		surrenderValue = objectInput.readLong();

		noOfRisk = objectInput.readLong();
		memberScheme = objectInput.readUTF();
		memberBenefits = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (policyNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyNo);
		}

		if (iqamaId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(iqamaId);
		}

		if (policyStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyStatus);
		}

		if (product == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(product);
		}

		objectOutput.writeLong(inceptionDate);
		objectOutput.writeLong(expiryDate);

		objectOutput.writeLong(sumInsured);

		objectOutput.writeLong(totalPremium);

		objectOutput.writeLong(policyFees);

		if (policyTaxes == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyTaxes);
		}

		objectOutput.writeLong(policyTerm);

		if (premium == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(premium);
		}

		objectOutput.writeLong(nextDueDate);

		objectOutput.writeLong(countPremMissed);

		if (modeOfPayment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(modeOfPayment);
		}

		objectOutput.writeLong(nextRenwalDate);

		if (custName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(custName);
		}

		objectOutput.writeLong(custBirthDate);

		if (insuredName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredName);
		}

		objectOutput.writeLong(insuredBirthDate);

		if (insuredId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredId);
		}

		if (insuredMobile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredMobile);
		}

		if (insuredEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredEmail);
		}

		if (insuredAddr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredAddr);
		}

		if (insuredGender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredGender);
		}

		if (occuptation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(occuptation);
		}

		objectOutput.writeLong(estExpiryDate);

		if (najmStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(najmStatus);
		}

		objectOutput.writeLong(surrenderValue);

		objectOutput.writeLong(noOfRisk);

		if (memberScheme == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(memberScheme);
		}

		if (memberBenefits == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(memberBenefits);
		}
	}

	public String policyNo;
	public String iqamaId;
	public String policyStatus;
	public String product;
	public long inceptionDate;
	public long expiryDate;
	public long sumInsured;
	public long totalPremium;
	public long policyFees;
	public String policyTaxes;
	public long policyTerm;
	public String premium;
	public long nextDueDate;
	public long countPremMissed;
	public String modeOfPayment;
	public long nextRenwalDate;
	public String custName;
	public long custBirthDate;
	public String insuredName;
	public long insuredBirthDate;
	public String insuredId;
	public String insuredMobile;
	public String insuredEmail;
	public String insuredAddr;
	public String insuredGender;
	public String occuptation;
	public long estExpiryDate;
	public String najmStatus;
	public long surrenderValue;
	public long noOfRisk;
	public String memberScheme;
	public String memberBenefits;

}