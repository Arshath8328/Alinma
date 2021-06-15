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

import com.ejada.atmc.acl.db.model.Quotations;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Quotations in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class QuotationsCacheModel
	implements CacheModel<Quotations>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof QuotationsCacheModel)) {
			return false;
		}

		QuotationsCacheModel quotationsCacheModel =
			(QuotationsCacheModel)object;

		if (quotationId == quotationsCacheModel.quotationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, quotationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(191);

		sb.append("{addressAddNo=");
		sb.append(addressAddNo);
		sb.append(", addressBuildingNo=");
		sb.append(addressBuildingNo);
		sb.append(", addressDistrict=");
		sb.append(addressDistrict);
		sb.append(", addressStreet=");
		sb.append(addressStreet);
		sb.append(", addressUnitNo=");
		sb.append(addressUnitNo);
		sb.append(", addressZipCode=");
		sb.append(addressZipCode);
		sb.append(", addCover=");
		sb.append(addCover);
		sb.append(", addDriver=");
		sb.append(addDriver);
		sb.append(", agencyRepair=");
		sb.append(agencyRepair);
		sb.append(", city=");
		sb.append(city);
		sb.append(", deductibleValue=");
		sb.append(deductibleValue);
		sb.append(", insuredDob=");
		sb.append(insuredDob);
		sb.append(", insuredEmail=");
		sb.append(insuredEmail);
		sb.append(", insuredGender=");
		sb.append(insuredGender);
		sb.append(", insuredId=");
		sb.append(insuredId);
		sb.append(", insuredIdType=");
		sb.append(insuredIdType);
		sb.append(", insuredMobile=");
		sb.append(insuredMobile);
		sb.append(", insuredName=");
		sb.append(insuredName);
		sb.append(", insuredNationality=");
		sb.append(insuredNationality);
		sb.append(", insuredEducation=");
		sb.append(insuredEducation);
		sb.append(", insuredMaritalStatus=");
		sb.append(insuredMaritalStatus);
		sb.append(", insuredNoChildUnder16=");
		sb.append(insuredNoChildUnder16);
		sb.append(", loyaltyDiscount=");
		sb.append(loyaltyDiscount);
		sb.append(", ncdYears=");
		sb.append(ncdYears);
		sb.append(", paymemtAmount=");
		sb.append(paymemtAmount);
		sb.append(", paymentMethod=");
		sb.append(paymentMethod);
		sb.append(", paymentRefNo=");
		sb.append(paymentRefNo);
		sb.append(", policyEffFromNo=");
		sb.append(policyEffFromNo);
		sb.append(", policyEffTo=");
		sb.append(policyEffTo);
		sb.append(", policyEffDate=");
		sb.append(policyEffDate);
		sb.append(", policyIssueDate=");
		sb.append(policyIssueDate);
		sb.append(", policyNo=");
		sb.append(policyNo);
		sb.append(", policyRefNo=");
		sb.append(policyRefNo);
		sb.append(", policyStatusCode=");
		sb.append(policyStatusCode);
		sb.append(", productCode=");
		sb.append(productCode);
		sb.append(", purposeOfVehicle=");
		sb.append(purposeOfVehicle);
		sb.append(", quotationId=");
		sb.append(quotationId);
		sb.append(", referenceNo=");
		sb.append(referenceNo);
		sb.append(", source=");
		sb.append(source);
		sb.append(", transaction=");
		sb.append(transaction);
		sb.append(", vehicleBodyType=");
		sb.append(vehicleBodyType);
		sb.append(", vehicleCapacity=");
		sb.append(vehicleCapacity);
		sb.append(", vehicleChassisNo=");
		sb.append(vehicleChassisNo);
		sb.append(", vehicleColor=");
		sb.append(vehicleColor);
		sb.append(", vehicleCylinder=");
		sb.append(vehicleCylinder);
		sb.append(", vehicleEstExpiryDate=");
		sb.append(vehicleEstExpiryDate);
		sb.append(", vehicleId=");
		sb.append(vehicleId);
		sb.append(", vehicleIdType=");
		sb.append(vehicleIdType);
		sb.append(", vehicleMake=");
		sb.append(vehicleMake);
		sb.append(", vehicleMfgYear=");
		sb.append(vehicleMfgYear);
		sb.append(", vehicleModel=");
		sb.append(vehicleModel);
		sb.append(", vehiclePlateL1=");
		sb.append(vehiclePlateL1);
		sb.append(", vehiclePlateL2=");
		sb.append(vehiclePlateL2);
		sb.append(", vehiclePlateL3=");
		sb.append(vehiclePlateL3);
		sb.append(", vehiclePlateNo=");
		sb.append(vehiclePlateNo);
		sb.append(", vehiclePlateType=");
		sb.append(vehiclePlateType);
		sb.append(", vehicleValue=");
		sb.append(vehicleValue);
		sb.append(", vehicleWeight=");
		sb.append(vehicleWeight);
		sb.append(", vehicleCity=");
		sb.append(vehicleCity);
		sb.append(", vehicleCurrentMileage=");
		sb.append(vehicleCurrentMileage);
		sb.append(", vehicleLowerExpectedMileagePerYear=");
		sb.append(vehicleLowerExpectedMileagePerYear);
		sb.append(", vehicleUpperExpectedMileagePerYear=");
		sb.append(vehicleUpperExpectedMileagePerYear);
		sb.append(", vehicleNightLocation=");
		sb.append(vehicleNightLocation);
		sb.append(", vehicleEngineSize=");
		sb.append(vehicleEngineSize);
		sb.append(", vehicleTransType=");
		sb.append(vehicleTransType);
		sb.append(", vehAxleWeight=");
		sb.append(vehAxleWeight);
		sb.append(", vehCarMods=");
		sb.append(vehCarMods);
		sb.append(", vehSpecs=");
		sb.append(vehSpecs);
		sb.append(", occCode=");
		sb.append(occCode);
		sb.append(", insuredIBAN=");
		sb.append(insuredIBAN);
		sb.append(", insuredDobH=");
		sb.append(insuredDobH);
		sb.append(", netPrem=");
		sb.append(netPrem);
		sb.append(", discountAmount=");
		sb.append(discountAmount);
		sb.append(", loyaltyDiscountAmount=");
		sb.append(loyaltyDiscountAmount);
		sb.append(", discountPrem=");
		sb.append(discountPrem);
		sb.append(", loyaltyDiscountPer=");
		sb.append(loyaltyDiscountPer);
		sb.append(", loadingAmount=");
		sb.append(loadingAmount);
		sb.append(", policyTaxes=");
		sb.append(policyTaxes);
		sb.append(", policyFees=");
		sb.append(policyFees);
		sb.append(", totalCoverPrem=");
		sb.append(totalCoverPrem);
		sb.append(", grossPrem=");
		sb.append(grossPrem);
		sb.append(", existingPolicyNo=");
		sb.append(existingPolicyNo);
		sb.append(", existingCompanyName=");
		sb.append(existingCompanyName);
		sb.append(", existingExpDate=");
		sb.append(existingExpDate);
		sb.append(", policyStatusMsg=");
		sb.append(policyStatusMsg);
		sb.append(", yakeenRefNo=");
		sb.append(yakeenRefNo);
		sb.append(", quoteSubmissionDate=");
		sb.append(quoteSubmissionDate);
		sb.append(", quoteStatus=");
		sb.append(quoteStatus);
		sb.append(", saeedService=");
		sb.append(saeedService);
		sb.append(", driverAccidents=");
		sb.append(driverAccidents);
		sb.append(", driverAgeLess21=");
		sb.append(driverAgeLess21);
		sb.append(", agencyRepairOut=");
		sb.append(agencyRepairOut);
		sb.append(", totalAfterDiscount=");
		sb.append(totalAfterDiscount);
		sb.append(", totalBeforeDisc=");
		sb.append(totalBeforeDisc);
		sb.append(", smsFlag=");
		sb.append(smsFlag);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Quotations toEntityModel() {
		QuotationsImpl quotationsImpl = new QuotationsImpl();

		quotationsImpl.setAddressAddNo(addressAddNo);
		quotationsImpl.setAddressBuildingNo(addressBuildingNo);

		if (addressDistrict == null) {
			quotationsImpl.setAddressDistrict("");
		}
		else {
			quotationsImpl.setAddressDistrict(addressDistrict);
		}

		if (addressStreet == null) {
			quotationsImpl.setAddressStreet("");
		}
		else {
			quotationsImpl.setAddressStreet(addressStreet);
		}

		quotationsImpl.setAddressUnitNo(addressUnitNo);
		quotationsImpl.setAddressZipCode(addressZipCode);

		if (addCover == null) {
			quotationsImpl.setAddCover("");
		}
		else {
			quotationsImpl.setAddCover(addCover);
		}

		if (addDriver == null) {
			quotationsImpl.setAddDriver("");
		}
		else {
			quotationsImpl.setAddDriver(addDriver);
		}

		if (agencyRepair == null) {
			quotationsImpl.setAgencyRepair("");
		}
		else {
			quotationsImpl.setAgencyRepair(agencyRepair);
		}

		if (city == null) {
			quotationsImpl.setCity("");
		}
		else {
			quotationsImpl.setCity(city);
		}

		if (deductibleValue == null) {
			quotationsImpl.setDeductibleValue("");
		}
		else {
			quotationsImpl.setDeductibleValue(deductibleValue);
		}

		if (insuredDob == Long.MIN_VALUE) {
			quotationsImpl.setInsuredDob(null);
		}
		else {
			quotationsImpl.setInsuredDob(new Date(insuredDob));
		}

		if (insuredEmail == null) {
			quotationsImpl.setInsuredEmail("");
		}
		else {
			quotationsImpl.setInsuredEmail(insuredEmail);
		}

		if (insuredGender == null) {
			quotationsImpl.setInsuredGender("");
		}
		else {
			quotationsImpl.setInsuredGender(insuredGender);
		}

		quotationsImpl.setInsuredId(insuredId);
		quotationsImpl.setInsuredIdType(insuredIdType);
		quotationsImpl.setInsuredMobile(insuredMobile);

		if (insuredName == null) {
			quotationsImpl.setInsuredName("");
		}
		else {
			quotationsImpl.setInsuredName(insuredName);
		}

		if (insuredNationality == null) {
			quotationsImpl.setInsuredNationality("");
		}
		else {
			quotationsImpl.setInsuredNationality(insuredNationality);
		}

		if (insuredEducation == null) {
			quotationsImpl.setInsuredEducation("");
		}
		else {
			quotationsImpl.setInsuredEducation(insuredEducation);
		}

		if (insuredMaritalStatus == null) {
			quotationsImpl.setInsuredMaritalStatus("");
		}
		else {
			quotationsImpl.setInsuredMaritalStatus(insuredMaritalStatus);
		}

		quotationsImpl.setInsuredNoChildUnder16(insuredNoChildUnder16);

		if (loyaltyDiscount == null) {
			quotationsImpl.setLoyaltyDiscount("");
		}
		else {
			quotationsImpl.setLoyaltyDiscount(loyaltyDiscount);
		}

		quotationsImpl.setNcdYears(ncdYears);
		quotationsImpl.setPaymemtAmount(paymemtAmount);

		if (paymentMethod == null) {
			quotationsImpl.setPaymentMethod("");
		}
		else {
			quotationsImpl.setPaymentMethod(paymentMethod);
		}

		if (paymentRefNo == null) {
			quotationsImpl.setPaymentRefNo("");
		}
		else {
			quotationsImpl.setPaymentRefNo(paymentRefNo);
		}

		if (policyEffFromNo == Long.MIN_VALUE) {
			quotationsImpl.setPolicyEffFromNo(null);
		}
		else {
			quotationsImpl.setPolicyEffFromNo(new Date(policyEffFromNo));
		}

		if (policyEffTo == Long.MIN_VALUE) {
			quotationsImpl.setPolicyEffTo(null);
		}
		else {
			quotationsImpl.setPolicyEffTo(new Date(policyEffTo));
		}

		if (policyEffDate == Long.MIN_VALUE) {
			quotationsImpl.setPolicyEffDate(null);
		}
		else {
			quotationsImpl.setPolicyEffDate(new Date(policyEffDate));
		}

		if (policyIssueDate == Long.MIN_VALUE) {
			quotationsImpl.setPolicyIssueDate(null);
		}
		else {
			quotationsImpl.setPolicyIssueDate(new Date(policyIssueDate));
		}

		if (policyNo == null) {
			quotationsImpl.setPolicyNo("");
		}
		else {
			quotationsImpl.setPolicyNo(policyNo);
		}

		if (policyRefNo == null) {
			quotationsImpl.setPolicyRefNo("");
		}
		else {
			quotationsImpl.setPolicyRefNo(policyRefNo);
		}

		if (policyStatusCode == null) {
			quotationsImpl.setPolicyStatusCode("");
		}
		else {
			quotationsImpl.setPolicyStatusCode(policyStatusCode);
		}

		if (productCode == null) {
			quotationsImpl.setProductCode("");
		}
		else {
			quotationsImpl.setProductCode(productCode);
		}

		if (purposeOfVehicle == null) {
			quotationsImpl.setPurposeOfVehicle("");
		}
		else {
			quotationsImpl.setPurposeOfVehicle(purposeOfVehicle);
		}

		quotationsImpl.setQuotationId(quotationId);

		if (referenceNo == null) {
			quotationsImpl.setReferenceNo("");
		}
		else {
			quotationsImpl.setReferenceNo(referenceNo);
		}

		if (source == null) {
			quotationsImpl.setSource("");
		}
		else {
			quotationsImpl.setSource(source);
		}

		if (transaction == null) {
			quotationsImpl.setTransaction("");
		}
		else {
			quotationsImpl.setTransaction(transaction);
		}

		if (vehicleBodyType == null) {
			quotationsImpl.setVehicleBodyType("");
		}
		else {
			quotationsImpl.setVehicleBodyType(vehicleBodyType);
		}

		quotationsImpl.setVehicleCapacity(vehicleCapacity);

		if (vehicleChassisNo == null) {
			quotationsImpl.setVehicleChassisNo("");
		}
		else {
			quotationsImpl.setVehicleChassisNo(vehicleChassisNo);
		}

		if (vehicleColor == null) {
			quotationsImpl.setVehicleColor("");
		}
		else {
			quotationsImpl.setVehicleColor(vehicleColor);
		}

		quotationsImpl.setVehicleCylinder(vehicleCylinder);

		if (vehicleEstExpiryDate == Long.MIN_VALUE) {
			quotationsImpl.setVehicleEstExpiryDate(null);
		}
		else {
			quotationsImpl.setVehicleEstExpiryDate(
				new Date(vehicleEstExpiryDate));
		}

		quotationsImpl.setVehicleId(vehicleId);
		quotationsImpl.setVehicleIdType(vehicleIdType);

		if (vehicleMake == null) {
			quotationsImpl.setVehicleMake("");
		}
		else {
			quotationsImpl.setVehicleMake(vehicleMake);
		}

		quotationsImpl.setVehicleMfgYear(vehicleMfgYear);

		if (vehicleModel == null) {
			quotationsImpl.setVehicleModel("");
		}
		else {
			quotationsImpl.setVehicleModel(vehicleModel);
		}

		if (vehiclePlateL1 == null) {
			quotationsImpl.setVehiclePlateL1("");
		}
		else {
			quotationsImpl.setVehiclePlateL1(vehiclePlateL1);
		}

		if (vehiclePlateL2 == null) {
			quotationsImpl.setVehiclePlateL2("");
		}
		else {
			quotationsImpl.setVehiclePlateL2(vehiclePlateL2);
		}

		if (vehiclePlateL3 == null) {
			quotationsImpl.setVehiclePlateL3("");
		}
		else {
			quotationsImpl.setVehiclePlateL3(vehiclePlateL3);
		}

		quotationsImpl.setVehiclePlateNo(vehiclePlateNo);

		if (vehiclePlateType == null) {
			quotationsImpl.setVehiclePlateType("");
		}
		else {
			quotationsImpl.setVehiclePlateType(vehiclePlateType);
		}

		quotationsImpl.setVehicleValue(vehicleValue);
		quotationsImpl.setVehicleWeight(vehicleWeight);

		if (vehicleCity == null) {
			quotationsImpl.setVehicleCity("");
		}
		else {
			quotationsImpl.setVehicleCity(vehicleCity);
		}

		quotationsImpl.setVehicleCurrentMileage(vehicleCurrentMileage);
		quotationsImpl.setVehicleLowerExpectedMileagePerYear(
			vehicleLowerExpectedMileagePerYear);
		quotationsImpl.setVehicleUpperExpectedMileagePerYear(
			vehicleUpperExpectedMileagePerYear);

		if (vehicleNightLocation == null) {
			quotationsImpl.setVehicleNightLocation("");
		}
		else {
			quotationsImpl.setVehicleNightLocation(vehicleNightLocation);
		}

		if (vehicleEngineSize == null) {
			quotationsImpl.setVehicleEngineSize("");
		}
		else {
			quotationsImpl.setVehicleEngineSize(vehicleEngineSize);
		}

		if (vehicleTransType == null) {
			quotationsImpl.setVehicleTransType("");
		}
		else {
			quotationsImpl.setVehicleTransType(vehicleTransType);
		}

		quotationsImpl.setVehAxleWeight(vehAxleWeight);

		if (vehCarMods == null) {
			quotationsImpl.setVehCarMods("");
		}
		else {
			quotationsImpl.setVehCarMods(vehCarMods);
		}

		if (vehSpecs == null) {
			quotationsImpl.setVehSpecs("");
		}
		else {
			quotationsImpl.setVehSpecs(vehSpecs);
		}

		if (occCode == null) {
			quotationsImpl.setOccCode("");
		}
		else {
			quotationsImpl.setOccCode(occCode);
		}

		if (insuredIBAN == null) {
			quotationsImpl.setInsuredIBAN("");
		}
		else {
			quotationsImpl.setInsuredIBAN(insuredIBAN);
		}

		if (insuredDobH == null) {
			quotationsImpl.setInsuredDobH("");
		}
		else {
			quotationsImpl.setInsuredDobH(insuredDobH);
		}

		quotationsImpl.setNetPrem(netPrem);
		quotationsImpl.setDiscountAmount(discountAmount);
		quotationsImpl.setLoyaltyDiscountAmount(loyaltyDiscountAmount);
		quotationsImpl.setDiscountPrem(discountPrem);
		quotationsImpl.setLoyaltyDiscountPer(loyaltyDiscountPer);
		quotationsImpl.setLoadingAmount(loadingAmount);
		quotationsImpl.setPolicyTaxes(policyTaxes);
		quotationsImpl.setPolicyFees(policyFees);
		quotationsImpl.setTotalCoverPrem(totalCoverPrem);
		quotationsImpl.setGrossPrem(grossPrem);

		if (existingPolicyNo == null) {
			quotationsImpl.setExistingPolicyNo("");
		}
		else {
			quotationsImpl.setExistingPolicyNo(existingPolicyNo);
		}

		if (existingCompanyName == null) {
			quotationsImpl.setExistingCompanyName("");
		}
		else {
			quotationsImpl.setExistingCompanyName(existingCompanyName);
		}

		if (existingExpDate == null) {
			quotationsImpl.setExistingExpDate("");
		}
		else {
			quotationsImpl.setExistingExpDate(existingExpDate);
		}

		if (policyStatusMsg == null) {
			quotationsImpl.setPolicyStatusMsg("");
		}
		else {
			quotationsImpl.setPolicyStatusMsg(policyStatusMsg);
		}

		quotationsImpl.setYakeenRefNo(yakeenRefNo);

		if (quoteSubmissionDate == Long.MIN_VALUE) {
			quotationsImpl.setQuoteSubmissionDate(null);
		}
		else {
			quotationsImpl.setQuoteSubmissionDate(
				new Date(quoteSubmissionDate));
		}

		if (quoteStatus == null) {
			quotationsImpl.setQuoteStatus("");
		}
		else {
			quotationsImpl.setQuoteStatus(quoteStatus);
		}

		if (saeedService == null) {
			quotationsImpl.setSaeedService("");
		}
		else {
			quotationsImpl.setSaeedService(saeedService);
		}

		quotationsImpl.setDriverAccidents(driverAccidents);
		quotationsImpl.setDriverAgeLess21(driverAgeLess21);
		quotationsImpl.setAgencyRepairOut(agencyRepairOut);
		quotationsImpl.setTotalAfterDiscount(totalAfterDiscount);
		quotationsImpl.setTotalBeforeDisc(totalBeforeDisc);
		quotationsImpl.setSmsFlag(smsFlag);

		quotationsImpl.resetOriginalValues();

		return quotationsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		addressAddNo = objectInput.readLong();

		addressBuildingNo = objectInput.readLong();
		addressDistrict = objectInput.readUTF();
		addressStreet = objectInput.readUTF();

		addressUnitNo = objectInput.readLong();

		addressZipCode = objectInput.readLong();
		addCover = objectInput.readUTF();
		addDriver = objectInput.readUTF();
		agencyRepair = objectInput.readUTF();
		city = objectInput.readUTF();
		deductibleValue = objectInput.readUTF();
		insuredDob = objectInput.readLong();
		insuredEmail = objectInput.readUTF();
		insuredGender = objectInput.readUTF();

		insuredId = objectInput.readLong();

		insuredIdType = objectInput.readLong();

		insuredMobile = objectInput.readLong();
		insuredName = objectInput.readUTF();
		insuredNationality = objectInput.readUTF();
		insuredEducation = objectInput.readUTF();
		insuredMaritalStatus = objectInput.readUTF();

		insuredNoChildUnder16 = objectInput.readLong();
		loyaltyDiscount = objectInput.readUTF();

		ncdYears = objectInput.readLong();

		paymemtAmount = objectInput.readLong();
		paymentMethod = objectInput.readUTF();
		paymentRefNo = objectInput.readUTF();
		policyEffFromNo = objectInput.readLong();
		policyEffTo = objectInput.readLong();
		policyEffDate = objectInput.readLong();
		policyIssueDate = objectInput.readLong();
		policyNo = objectInput.readUTF();
		policyRefNo = objectInput.readUTF();
		policyStatusCode = objectInput.readUTF();
		productCode = objectInput.readUTF();
		purposeOfVehicle = objectInput.readUTF();

		quotationId = objectInput.readLong();
		referenceNo = objectInput.readUTF();
		source = objectInput.readUTF();
		transaction = objectInput.readUTF();
		vehicleBodyType = objectInput.readUTF();

		vehicleCapacity = objectInput.readLong();
		vehicleChassisNo = objectInput.readUTF();
		vehicleColor = objectInput.readUTF();

		vehicleCylinder = objectInput.readLong();
		vehicleEstExpiryDate = objectInput.readLong();

		vehicleId = objectInput.readLong();

		vehicleIdType = objectInput.readLong();
		vehicleMake = objectInput.readUTF();

		vehicleMfgYear = objectInput.readLong();
		vehicleModel = objectInput.readUTF();
		vehiclePlateL1 = objectInput.readUTF();
		vehiclePlateL2 = objectInput.readUTF();
		vehiclePlateL3 = objectInput.readUTF();

		vehiclePlateNo = objectInput.readLong();
		vehiclePlateType = objectInput.readUTF();

		vehicleValue = objectInput.readLong();

		vehicleWeight = objectInput.readLong();
		vehicleCity = objectInput.readUTF();

		vehicleCurrentMileage = objectInput.readLong();

		vehicleLowerExpectedMileagePerYear = objectInput.readLong();

		vehicleUpperExpectedMileagePerYear = objectInput.readLong();
		vehicleNightLocation = objectInput.readUTF();
		vehicleEngineSize = objectInput.readUTF();
		vehicleTransType = objectInput.readUTF();

		vehAxleWeight = objectInput.readLong();
		vehCarMods = objectInput.readUTF();
		vehSpecs = objectInput.readUTF();
		occCode = objectInput.readUTF();
		insuredIBAN = objectInput.readUTF();
		insuredDobH = objectInput.readUTF();

		netPrem = objectInput.readDouble();

		discountAmount = objectInput.readDouble();

		loyaltyDiscountAmount = objectInput.readDouble();

		discountPrem = objectInput.readDouble();

		loyaltyDiscountPer = objectInput.readDouble();

		loadingAmount = objectInput.readDouble();

		policyTaxes = objectInput.readDouble();

		policyFees = objectInput.readDouble();

		totalCoverPrem = objectInput.readDouble();

		grossPrem = objectInput.readDouble();
		existingPolicyNo = objectInput.readUTF();
		existingCompanyName = objectInput.readUTF();
		existingExpDate = objectInput.readUTF();
		policyStatusMsg = objectInput.readUTF();

		yakeenRefNo = objectInput.readLong();
		quoteSubmissionDate = objectInput.readLong();
		quoteStatus = objectInput.readUTF();
		saeedService = objectInput.readUTF();

		driverAccidents = objectInput.readDouble();

		driverAgeLess21 = objectInput.readDouble();

		agencyRepairOut = objectInput.readDouble();

		totalAfterDiscount = objectInput.readDouble();

		totalBeforeDisc = objectInput.readDouble();

		smsFlag = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(addressAddNo);

		objectOutput.writeLong(addressBuildingNo);

		if (addressDistrict == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressDistrict);
		}

		if (addressStreet == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressStreet);
		}

		objectOutput.writeLong(addressUnitNo);

		objectOutput.writeLong(addressZipCode);

		if (addCover == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addCover);
		}

		if (addDriver == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addDriver);
		}

		if (agencyRepair == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(agencyRepair);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (deductibleValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deductibleValue);
		}

		objectOutput.writeLong(insuredDob);

		if (insuredEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredEmail);
		}

		if (insuredGender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredGender);
		}

		objectOutput.writeLong(insuredId);

		objectOutput.writeLong(insuredIdType);

		objectOutput.writeLong(insuredMobile);

		if (insuredName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredName);
		}

		if (insuredNationality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredNationality);
		}

		if (insuredEducation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredEducation);
		}

		if (insuredMaritalStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredMaritalStatus);
		}

		objectOutput.writeLong(insuredNoChildUnder16);

		if (loyaltyDiscount == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(loyaltyDiscount);
		}

		objectOutput.writeLong(ncdYears);

		objectOutput.writeLong(paymemtAmount);

		if (paymentMethod == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paymentMethod);
		}

		if (paymentRefNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paymentRefNo);
		}

		objectOutput.writeLong(policyEffFromNo);
		objectOutput.writeLong(policyEffTo);
		objectOutput.writeLong(policyEffDate);
		objectOutput.writeLong(policyIssueDate);

		if (policyNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyNo);
		}

		if (policyRefNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyRefNo);
		}

		if (policyStatusCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyStatusCode);
		}

		if (productCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productCode);
		}

		if (purposeOfVehicle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(purposeOfVehicle);
		}

		objectOutput.writeLong(quotationId);

		if (referenceNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(referenceNo);
		}

		if (source == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(source);
		}

		if (transaction == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(transaction);
		}

		if (vehicleBodyType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleBodyType);
		}

		objectOutput.writeLong(vehicleCapacity);

		if (vehicleChassisNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleChassisNo);
		}

		if (vehicleColor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleColor);
		}

		objectOutput.writeLong(vehicleCylinder);
		objectOutput.writeLong(vehicleEstExpiryDate);

		objectOutput.writeLong(vehicleId);

		objectOutput.writeLong(vehicleIdType);

		if (vehicleMake == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleMake);
		}

		objectOutput.writeLong(vehicleMfgYear);

		if (vehicleModel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleModel);
		}

		if (vehiclePlateL1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehiclePlateL1);
		}

		if (vehiclePlateL2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehiclePlateL2);
		}

		if (vehiclePlateL3 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehiclePlateL3);
		}

		objectOutput.writeLong(vehiclePlateNo);

		if (vehiclePlateType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehiclePlateType);
		}

		objectOutput.writeLong(vehicleValue);

		objectOutput.writeLong(vehicleWeight);

		if (vehicleCity == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleCity);
		}

		objectOutput.writeLong(vehicleCurrentMileage);

		objectOutput.writeLong(vehicleLowerExpectedMileagePerYear);

		objectOutput.writeLong(vehicleUpperExpectedMileagePerYear);

		if (vehicleNightLocation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleNightLocation);
		}

		if (vehicleEngineSize == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleEngineSize);
		}

		if (vehicleTransType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleTransType);
		}

		objectOutput.writeLong(vehAxleWeight);

		if (vehCarMods == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehCarMods);
		}

		if (vehSpecs == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehSpecs);
		}

		if (occCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(occCode);
		}

		if (insuredIBAN == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredIBAN);
		}

		if (insuredDobH == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredDobH);
		}

		objectOutput.writeDouble(netPrem);

		objectOutput.writeDouble(discountAmount);

		objectOutput.writeDouble(loyaltyDiscountAmount);

		objectOutput.writeDouble(discountPrem);

		objectOutput.writeDouble(loyaltyDiscountPer);

		objectOutput.writeDouble(loadingAmount);

		objectOutput.writeDouble(policyTaxes);

		objectOutput.writeDouble(policyFees);

		objectOutput.writeDouble(totalCoverPrem);

		objectOutput.writeDouble(grossPrem);

		if (existingPolicyNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(existingPolicyNo);
		}

		if (existingCompanyName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(existingCompanyName);
		}

		if (existingExpDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(existingExpDate);
		}

		if (policyStatusMsg == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyStatusMsg);
		}

		objectOutput.writeLong(yakeenRefNo);
		objectOutput.writeLong(quoteSubmissionDate);

		if (quoteStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(quoteStatus);
		}

		if (saeedService == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(saeedService);
		}

		objectOutput.writeDouble(driverAccidents);

		objectOutput.writeDouble(driverAgeLess21);

		objectOutput.writeDouble(agencyRepairOut);

		objectOutput.writeDouble(totalAfterDiscount);

		objectOutput.writeDouble(totalBeforeDisc);

		objectOutput.writeBoolean(smsFlag);
	}

	public long addressAddNo;
	public long addressBuildingNo;
	public String addressDistrict;
	public String addressStreet;
	public long addressUnitNo;
	public long addressZipCode;
	public String addCover;
	public String addDriver;
	public String agencyRepair;
	public String city;
	public String deductibleValue;
	public long insuredDob;
	public String insuredEmail;
	public String insuredGender;
	public long insuredId;
	public long insuredIdType;
	public long insuredMobile;
	public String insuredName;
	public String insuredNationality;
	public String insuredEducation;
	public String insuredMaritalStatus;
	public long insuredNoChildUnder16;
	public String loyaltyDiscount;
	public long ncdYears;
	public long paymemtAmount;
	public String paymentMethod;
	public String paymentRefNo;
	public long policyEffFromNo;
	public long policyEffTo;
	public long policyEffDate;
	public long policyIssueDate;
	public String policyNo;
	public String policyRefNo;
	public String policyStatusCode;
	public String productCode;
	public String purposeOfVehicle;
	public long quotationId;
	public String referenceNo;
	public String source;
	public String transaction;
	public String vehicleBodyType;
	public long vehicleCapacity;
	public String vehicleChassisNo;
	public String vehicleColor;
	public long vehicleCylinder;
	public long vehicleEstExpiryDate;
	public long vehicleId;
	public long vehicleIdType;
	public String vehicleMake;
	public long vehicleMfgYear;
	public String vehicleModel;
	public String vehiclePlateL1;
	public String vehiclePlateL2;
	public String vehiclePlateL3;
	public long vehiclePlateNo;
	public String vehiclePlateType;
	public long vehicleValue;
	public long vehicleWeight;
	public String vehicleCity;
	public long vehicleCurrentMileage;
	public long vehicleLowerExpectedMileagePerYear;
	public long vehicleUpperExpectedMileagePerYear;
	public String vehicleNightLocation;
	public String vehicleEngineSize;
	public String vehicleTransType;
	public long vehAxleWeight;
	public String vehCarMods;
	public String vehSpecs;
	public String occCode;
	public String insuredIBAN;
	public String insuredDobH;
	public double netPrem;
	public double discountAmount;
	public double loyaltyDiscountAmount;
	public double discountPrem;
	public double loyaltyDiscountPer;
	public double loadingAmount;
	public double policyTaxes;
	public double policyFees;
	public double totalCoverPrem;
	public double grossPrem;
	public String existingPolicyNo;
	public String existingCompanyName;
	public String existingExpDate;
	public String policyStatusMsg;
	public long yakeenRefNo;
	public long quoteSubmissionDate;
	public String quoteStatus;
	public String saeedService;
	public double driverAccidents;
	public double driverAgeLess21;
	public double agencyRepairOut;
	public double totalAfterDiscount;
	public double totalBeforeDisc;
	public boolean smsFlag;

}