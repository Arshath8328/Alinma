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

import com.ejada.atmc.acl.db.model.QuotationsNajmDetails;
import com.ejada.atmc.acl.db.service.persistence.QuotationsNajmDetailsPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing QuotationsNajmDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class QuotationsNajmDetailsCacheModel
	implements CacheModel<QuotationsNajmDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof QuotationsNajmDetailsCacheModel)) {
			return false;
		}

		QuotationsNajmDetailsCacheModel quotationsNajmDetailsCacheModel =
			(QuotationsNajmDetailsCacheModel)object;

		if (quotationsNajmDetailsPK.equals(
				quotationsNajmDetailsCacheModel.quotationsNajmDetailsPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, quotationsNajmDetailsPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{caseNumber=");
		sb.append(caseNumber);
		sb.append(", quotationId=");
		sb.append(quotationId);
		sb.append(", accidentDate=");
		sb.append(accidentDate);
		sb.append(", liability=");
		sb.append(liability);
		sb.append(", driverAge=");
		sb.append(driverAge);
		sb.append(", carModel=");
		sb.append(carModel);
		sb.append(", carType=");
		sb.append(carType);
		sb.append(", driverID=");
		sb.append(driverID);
		sb.append(", sequenceNumber=");
		sb.append(sequenceNumber);
		sb.append(", ownerID=");
		sb.append(ownerID);
		sb.append(", estimatedAmount=");
		sb.append(estimatedAmount);
		sb.append(", damageParts=");
		sb.append(damageParts);
		sb.append(", causeOfAccident=");
		sb.append(causeOfAccident);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public QuotationsNajmDetails toEntityModel() {
		QuotationsNajmDetailsImpl quotationsNajmDetailsImpl =
			new QuotationsNajmDetailsImpl();

		if (caseNumber == null) {
			quotationsNajmDetailsImpl.setCaseNumber("");
		}
		else {
			quotationsNajmDetailsImpl.setCaseNumber(caseNumber);
		}

		quotationsNajmDetailsImpl.setQuotationId(quotationId);

		if (accidentDate == null) {
			quotationsNajmDetailsImpl.setAccidentDate("");
		}
		else {
			quotationsNajmDetailsImpl.setAccidentDate(accidentDate);
		}

		if (liability == null) {
			quotationsNajmDetailsImpl.setLiability("");
		}
		else {
			quotationsNajmDetailsImpl.setLiability(liability);
		}

		if (driverAge == null) {
			quotationsNajmDetailsImpl.setDriverAge("");
		}
		else {
			quotationsNajmDetailsImpl.setDriverAge(driverAge);
		}

		if (carModel == null) {
			quotationsNajmDetailsImpl.setCarModel("");
		}
		else {
			quotationsNajmDetailsImpl.setCarModel(carModel);
		}

		if (carType == null) {
			quotationsNajmDetailsImpl.setCarType("");
		}
		else {
			quotationsNajmDetailsImpl.setCarType(carType);
		}

		if (driverID == null) {
			quotationsNajmDetailsImpl.setDriverID("");
		}
		else {
			quotationsNajmDetailsImpl.setDriverID(driverID);
		}

		if (sequenceNumber == null) {
			quotationsNajmDetailsImpl.setSequenceNumber("");
		}
		else {
			quotationsNajmDetailsImpl.setSequenceNumber(sequenceNumber);
		}

		if (ownerID == null) {
			quotationsNajmDetailsImpl.setOwnerID("");
		}
		else {
			quotationsNajmDetailsImpl.setOwnerID(ownerID);
		}

		if (estimatedAmount == null) {
			quotationsNajmDetailsImpl.setEstimatedAmount("");
		}
		else {
			quotationsNajmDetailsImpl.setEstimatedAmount(estimatedAmount);
		}

		if (damageParts == null) {
			quotationsNajmDetailsImpl.setDamageParts("");
		}
		else {
			quotationsNajmDetailsImpl.setDamageParts(damageParts);
		}

		if (causeOfAccident == null) {
			quotationsNajmDetailsImpl.setCauseOfAccident("");
		}
		else {
			quotationsNajmDetailsImpl.setCauseOfAccident(causeOfAccident);
		}

		quotationsNajmDetailsImpl.resetOriginalValues();

		return quotationsNajmDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		caseNumber = objectInput.readUTF();

		quotationId = objectInput.readLong();
		accidentDate = objectInput.readUTF();
		liability = objectInput.readUTF();
		driverAge = objectInput.readUTF();
		carModel = objectInput.readUTF();
		carType = objectInput.readUTF();
		driverID = objectInput.readUTF();
		sequenceNumber = objectInput.readUTF();
		ownerID = objectInput.readUTF();
		estimatedAmount = objectInput.readUTF();
		damageParts = objectInput.readUTF();
		causeOfAccident = objectInput.readUTF();

		quotationsNajmDetailsPK = new QuotationsNajmDetailsPK(
			caseNumber, quotationId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (caseNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(caseNumber);
		}

		objectOutput.writeLong(quotationId);

		if (accidentDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accidentDate);
		}

		if (liability == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(liability);
		}

		if (driverAge == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverAge);
		}

		if (carModel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(carModel);
		}

		if (carType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(carType);
		}

		if (driverID == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverID);
		}

		if (sequenceNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sequenceNumber);
		}

		if (ownerID == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ownerID);
		}

		if (estimatedAmount == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(estimatedAmount);
		}

		if (damageParts == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(damageParts);
		}

		if (causeOfAccident == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(causeOfAccident);
		}
	}

	public String caseNumber;
	public long quotationId;
	public String accidentDate;
	public String liability;
	public String driverAge;
	public String carModel;
	public String carType;
	public String driverID;
	public String sequenceNumber;
	public String ownerID;
	public String estimatedAmount;
	public String damageParts;
	public String causeOfAccident;
	public transient QuotationsNajmDetailsPK quotationsNajmDetailsPK;

}