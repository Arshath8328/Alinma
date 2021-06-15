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

import com.ejada.atmc.acl.db.model.FundDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FundDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FundDetailsCacheModel
	implements CacheModel<FundDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FundDetailsCacheModel)) {
			return false;
		}

		FundDetailsCacheModel fundDetailsCacheModel =
			(FundDetailsCacheModel)object;

		if (fundName.equals(fundDetailsCacheModel.fundName)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fundName);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{policyNo=");
		sb.append(policyNo);
		sb.append(", fundName=");
		sb.append(fundName);
		sb.append(", fundDesc=");
		sb.append(fundDesc);
		sb.append(", fundPctg=");
		sb.append(fundPctg);
		sb.append(", unitsSum=");
		sb.append(unitsSum);
		sb.append(", unitPrice=");
		sb.append(unitPrice);
		sb.append(", fundsValue=");
		sb.append(fundsValue);
		sb.append(", riskChg=");
		sb.append(riskChg);
		sb.append(", partFees=");
		sb.append(partFees);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FundDetails toEntityModel() {
		FundDetailsImpl fundDetailsImpl = new FundDetailsImpl();

		if (policyNo == null) {
			fundDetailsImpl.setPolicyNo("");
		}
		else {
			fundDetailsImpl.setPolicyNo(policyNo);
		}

		if (fundName == null) {
			fundDetailsImpl.setFundName("");
		}
		else {
			fundDetailsImpl.setFundName(fundName);
		}

		if (fundDesc == null) {
			fundDetailsImpl.setFundDesc("");
		}
		else {
			fundDetailsImpl.setFundDesc(fundDesc);
		}

		if (fundPctg == null) {
			fundDetailsImpl.setFundPctg("");
		}
		else {
			fundDetailsImpl.setFundPctg(fundPctg);
		}

		fundDetailsImpl.setUnitsSum(unitsSum);
		fundDetailsImpl.setUnitPrice(unitPrice);
		fundDetailsImpl.setFundsValue(fundsValue);
		fundDetailsImpl.setRiskChg(riskChg);
		fundDetailsImpl.setPartFees(partFees);

		fundDetailsImpl.resetOriginalValues();

		return fundDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		policyNo = objectInput.readUTF();
		fundName = objectInput.readUTF();
		fundDesc = objectInput.readUTF();
		fundPctg = objectInput.readUTF();

		unitsSum = objectInput.readDouble();

		unitPrice = objectInput.readDouble();

		fundsValue = objectInput.readDouble();

		riskChg = objectInput.readDouble();

		partFees = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (policyNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyNo);
		}

		if (fundName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fundName);
		}

		if (fundDesc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fundDesc);
		}

		if (fundPctg == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fundPctg);
		}

		objectOutput.writeDouble(unitsSum);

		objectOutput.writeDouble(unitPrice);

		objectOutput.writeDouble(fundsValue);

		objectOutput.writeDouble(riskChg);

		objectOutput.writeDouble(partFees);
	}

	public String policyNo;
	public String fundName;
	public String fundDesc;
	public String fundPctg;
	public double unitsSum;
	public double unitPrice;
	public double fundsValue;
	public double riskChg;
	public double partFees;

}