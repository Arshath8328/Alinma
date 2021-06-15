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

package com.ejada.atmc.acl.db.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.QuotationsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class QuotationsSoap implements Serializable {

	public static QuotationsSoap toSoapModel(Quotations model) {
		QuotationsSoap soapModel = new QuotationsSoap();

		soapModel.setAddressAddNo(model.getAddressAddNo());
		soapModel.setAddressBuildingNo(model.getAddressBuildingNo());
		soapModel.setAddressDistrict(model.getAddressDistrict());
		soapModel.setAddressStreet(model.getAddressStreet());
		soapModel.setAddressUnitNo(model.getAddressUnitNo());
		soapModel.setAddressZipCode(model.getAddressZipCode());
		soapModel.setAddCover(model.getAddCover());
		soapModel.setAddDriver(model.getAddDriver());
		soapModel.setAgencyRepair(model.getAgencyRepair());
		soapModel.setCity(model.getCity());
		soapModel.setDeductibleValue(model.getDeductibleValue());
		soapModel.setInsuredDob(model.getInsuredDob());
		soapModel.setInsuredEmail(model.getInsuredEmail());
		soapModel.setInsuredGender(model.getInsuredGender());
		soapModel.setInsuredId(model.getInsuredId());
		soapModel.setInsuredIdType(model.getInsuredIdType());
		soapModel.setInsuredMobile(model.getInsuredMobile());
		soapModel.setInsuredName(model.getInsuredName());
		soapModel.setInsuredNationality(model.getInsuredNationality());
		soapModel.setInsuredEducation(model.getInsuredEducation());
		soapModel.setInsuredMaritalStatus(model.getInsuredMaritalStatus());
		soapModel.setInsuredNoChildUnder16(model.getInsuredNoChildUnder16());
		soapModel.setLoyaltyDiscount(model.getLoyaltyDiscount());
		soapModel.setNcdYears(model.getNcdYears());
		soapModel.setPaymemtAmount(model.getPaymemtAmount());
		soapModel.setPaymentMethod(model.getPaymentMethod());
		soapModel.setPaymentRefNo(model.getPaymentRefNo());
		soapModel.setPolicyEffFromNo(model.getPolicyEffFromNo());
		soapModel.setPolicyEffTo(model.getPolicyEffTo());
		soapModel.setPolicyEffDate(model.getPolicyEffDate());
		soapModel.setPolicyIssueDate(model.getPolicyIssueDate());
		soapModel.setPolicyNo(model.getPolicyNo());
		soapModel.setPolicyRefNo(model.getPolicyRefNo());
		soapModel.setPolicyStatusCode(model.getPolicyStatusCode());
		soapModel.setProductCode(model.getProductCode());
		soapModel.setPurposeOfVehicle(model.getPurposeOfVehicle());
		soapModel.setQuotationId(model.getQuotationId());
		soapModel.setReferenceNo(model.getReferenceNo());
		soapModel.setSource(model.getSource());
		soapModel.setTransaction(model.getTransaction());
		soapModel.setVehicleBodyType(model.getVehicleBodyType());
		soapModel.setVehicleCapacity(model.getVehicleCapacity());
		soapModel.setVehicleChassisNo(model.getVehicleChassisNo());
		soapModel.setVehicleColor(model.getVehicleColor());
		soapModel.setVehicleCylinder(model.getVehicleCylinder());
		soapModel.setVehicleEstExpiryDate(model.getVehicleEstExpiryDate());
		soapModel.setVehicleId(model.getVehicleId());
		soapModel.setVehicleIdType(model.getVehicleIdType());
		soapModel.setVehicleMake(model.getVehicleMake());
		soapModel.setVehicleMfgYear(model.getVehicleMfgYear());
		soapModel.setVehicleModel(model.getVehicleModel());
		soapModel.setVehiclePlateL1(model.getVehiclePlateL1());
		soapModel.setVehiclePlateL2(model.getVehiclePlateL2());
		soapModel.setVehiclePlateL3(model.getVehiclePlateL3());
		soapModel.setVehiclePlateNo(model.getVehiclePlateNo());
		soapModel.setVehiclePlateType(model.getVehiclePlateType());
		soapModel.setVehicleValue(model.getVehicleValue());
		soapModel.setVehicleWeight(model.getVehicleWeight());
		soapModel.setVehicleCity(model.getVehicleCity());
		soapModel.setVehicleCurrentMileage(model.getVehicleCurrentMileage());
		soapModel.setVehicleLowerExpectedMileagePerYear(
			model.getVehicleLowerExpectedMileagePerYear());
		soapModel.setVehicleUpperExpectedMileagePerYear(
			model.getVehicleUpperExpectedMileagePerYear());
		soapModel.setVehicleNightLocation(model.getVehicleNightLocation());
		soapModel.setVehicleEngineSize(model.getVehicleEngineSize());
		soapModel.setVehicleTransType(model.getVehicleTransType());
		soapModel.setVehAxleWeight(model.getVehAxleWeight());
		soapModel.setVehCarMods(model.getVehCarMods());
		soapModel.setVehSpecs(model.getVehSpecs());
		soapModel.setOccCode(model.getOccCode());
		soapModel.setInsuredIBAN(model.getInsuredIBAN());
		soapModel.setInsuredDobH(model.getInsuredDobH());
		soapModel.setNetPrem(model.getNetPrem());
		soapModel.setDiscountAmount(model.getDiscountAmount());
		soapModel.setLoyaltyDiscountAmount(model.getLoyaltyDiscountAmount());
		soapModel.setDiscountPrem(model.getDiscountPrem());
		soapModel.setLoyaltyDiscountPer(model.getLoyaltyDiscountPer());
		soapModel.setLoadingAmount(model.getLoadingAmount());
		soapModel.setPolicyTaxes(model.getPolicyTaxes());
		soapModel.setPolicyFees(model.getPolicyFees());
		soapModel.setTotalCoverPrem(model.getTotalCoverPrem());
		soapModel.setGrossPrem(model.getGrossPrem());
		soapModel.setExistingPolicyNo(model.getExistingPolicyNo());
		soapModel.setExistingCompanyName(model.getExistingCompanyName());
		soapModel.setExistingExpDate(model.getExistingExpDate());
		soapModel.setPolicyStatusMsg(model.getPolicyStatusMsg());
		soapModel.setYakeenRefNo(model.getYakeenRefNo());
		soapModel.setQuoteSubmissionDate(model.getQuoteSubmissionDate());
		soapModel.setQuoteStatus(model.getQuoteStatus());
		soapModel.setSaeedService(model.getSaeedService());
		soapModel.setDriverAccidents(model.getDriverAccidents());
		soapModel.setDriverAgeLess21(model.getDriverAgeLess21());
		soapModel.setAgencyRepairOut(model.getAgencyRepairOut());
		soapModel.setTotalAfterDiscount(model.getTotalAfterDiscount());
		soapModel.setTotalBeforeDisc(model.getTotalBeforeDisc());
		soapModel.setSmsFlag(model.isSmsFlag());

		return soapModel;
	}

	public static QuotationsSoap[] toSoapModels(Quotations[] models) {
		QuotationsSoap[] soapModels = new QuotationsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuotationsSoap[][] toSoapModels(Quotations[][] models) {
		QuotationsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new QuotationsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuotationsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuotationsSoap[] toSoapModels(List<Quotations> models) {
		List<QuotationsSoap> soapModels = new ArrayList<QuotationsSoap>(
			models.size());

		for (Quotations model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QuotationsSoap[soapModels.size()]);
	}

	public QuotationsSoap() {
	}

	public long getPrimaryKey() {
		return _quotationId;
	}

	public void setPrimaryKey(long pk) {
		setQuotationId(pk);
	}

	public long getAddressAddNo() {
		return _addressAddNo;
	}

	public void setAddressAddNo(long addressAddNo) {
		_addressAddNo = addressAddNo;
	}

	public long getAddressBuildingNo() {
		return _addressBuildingNo;
	}

	public void setAddressBuildingNo(long addressBuildingNo) {
		_addressBuildingNo = addressBuildingNo;
	}

	public String getAddressDistrict() {
		return _addressDistrict;
	}

	public void setAddressDistrict(String addressDistrict) {
		_addressDistrict = addressDistrict;
	}

	public String getAddressStreet() {
		return _addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		_addressStreet = addressStreet;
	}

	public long getAddressUnitNo() {
		return _addressUnitNo;
	}

	public void setAddressUnitNo(long addressUnitNo) {
		_addressUnitNo = addressUnitNo;
	}

	public long getAddressZipCode() {
		return _addressZipCode;
	}

	public void setAddressZipCode(long addressZipCode) {
		_addressZipCode = addressZipCode;
	}

	public String getAddCover() {
		return _addCover;
	}

	public void setAddCover(String addCover) {
		_addCover = addCover;
	}

	public String getAddDriver() {
		return _addDriver;
	}

	public void setAddDriver(String addDriver) {
		_addDriver = addDriver;
	}

	public String getAgencyRepair() {
		return _agencyRepair;
	}

	public void setAgencyRepair(String agencyRepair) {
		_agencyRepair = agencyRepair;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getDeductibleValue() {
		return _deductibleValue;
	}

	public void setDeductibleValue(String deductibleValue) {
		_deductibleValue = deductibleValue;
	}

	public Date getInsuredDob() {
		return _insuredDob;
	}

	public void setInsuredDob(Date insuredDob) {
		_insuredDob = insuredDob;
	}

	public String getInsuredEmail() {
		return _insuredEmail;
	}

	public void setInsuredEmail(String insuredEmail) {
		_insuredEmail = insuredEmail;
	}

	public String getInsuredGender() {
		return _insuredGender;
	}

	public void setInsuredGender(String insuredGender) {
		_insuredGender = insuredGender;
	}

	public long getInsuredId() {
		return _insuredId;
	}

	public void setInsuredId(long insuredId) {
		_insuredId = insuredId;
	}

	public long getInsuredIdType() {
		return _insuredIdType;
	}

	public void setInsuredIdType(long insuredIdType) {
		_insuredIdType = insuredIdType;
	}

	public long getInsuredMobile() {
		return _insuredMobile;
	}

	public void setInsuredMobile(long insuredMobile) {
		_insuredMobile = insuredMobile;
	}

	public String getInsuredName() {
		return _insuredName;
	}

	public void setInsuredName(String insuredName) {
		_insuredName = insuredName;
	}

	public String getInsuredNationality() {
		return _insuredNationality;
	}

	public void setInsuredNationality(String insuredNationality) {
		_insuredNationality = insuredNationality;
	}

	public String getInsuredEducation() {
		return _insuredEducation;
	}

	public void setInsuredEducation(String insuredEducation) {
		_insuredEducation = insuredEducation;
	}

	public String getInsuredMaritalStatus() {
		return _insuredMaritalStatus;
	}

	public void setInsuredMaritalStatus(String insuredMaritalStatus) {
		_insuredMaritalStatus = insuredMaritalStatus;
	}

	public long getInsuredNoChildUnder16() {
		return _insuredNoChildUnder16;
	}

	public void setInsuredNoChildUnder16(long insuredNoChildUnder16) {
		_insuredNoChildUnder16 = insuredNoChildUnder16;
	}

	public String getLoyaltyDiscount() {
		return _loyaltyDiscount;
	}

	public void setLoyaltyDiscount(String loyaltyDiscount) {
		_loyaltyDiscount = loyaltyDiscount;
	}

	public long getNcdYears() {
		return _ncdYears;
	}

	public void setNcdYears(long ncdYears) {
		_ncdYears = ncdYears;
	}

	public long getPaymemtAmount() {
		return _paymemtAmount;
	}

	public void setPaymemtAmount(long paymemtAmount) {
		_paymemtAmount = paymemtAmount;
	}

	public String getPaymentMethod() {
		return _paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		_paymentMethod = paymentMethod;
	}

	public String getPaymentRefNo() {
		return _paymentRefNo;
	}

	public void setPaymentRefNo(String paymentRefNo) {
		_paymentRefNo = paymentRefNo;
	}

	public Date getPolicyEffFromNo() {
		return _policyEffFromNo;
	}

	public void setPolicyEffFromNo(Date policyEffFromNo) {
		_policyEffFromNo = policyEffFromNo;
	}

	public Date getPolicyEffTo() {
		return _policyEffTo;
	}

	public void setPolicyEffTo(Date policyEffTo) {
		_policyEffTo = policyEffTo;
	}

	public Date getPolicyEffDate() {
		return _policyEffDate;
	}

	public void setPolicyEffDate(Date policyEffDate) {
		_policyEffDate = policyEffDate;
	}

	public Date getPolicyIssueDate() {
		return _policyIssueDate;
	}

	public void setPolicyIssueDate(Date policyIssueDate) {
		_policyIssueDate = policyIssueDate;
	}

	public String getPolicyNo() {
		return _policyNo;
	}

	public void setPolicyNo(String policyNo) {
		_policyNo = policyNo;
	}

	public String getPolicyRefNo() {
		return _policyRefNo;
	}

	public void setPolicyRefNo(String policyRefNo) {
		_policyRefNo = policyRefNo;
	}

	public String getPolicyStatusCode() {
		return _policyStatusCode;
	}

	public void setPolicyStatusCode(String policyStatusCode) {
		_policyStatusCode = policyStatusCode;
	}

	public String getProductCode() {
		return _productCode;
	}

	public void setProductCode(String productCode) {
		_productCode = productCode;
	}

	public String getPurposeOfVehicle() {
		return _purposeOfVehicle;
	}

	public void setPurposeOfVehicle(String purposeOfVehicle) {
		_purposeOfVehicle = purposeOfVehicle;
	}

	public long getQuotationId() {
		return _quotationId;
	}

	public void setQuotationId(long quotationId) {
		_quotationId = quotationId;
	}

	public String getReferenceNo() {
		return _referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		_referenceNo = referenceNo;
	}

	public String getSource() {
		return _source;
	}

	public void setSource(String source) {
		_source = source;
	}

	public String getTransaction() {
		return _transaction;
	}

	public void setTransaction(String transaction) {
		_transaction = transaction;
	}

	public String getVehicleBodyType() {
		return _vehicleBodyType;
	}

	public void setVehicleBodyType(String vehicleBodyType) {
		_vehicleBodyType = vehicleBodyType;
	}

	public long getVehicleCapacity() {
		return _vehicleCapacity;
	}

	public void setVehicleCapacity(long vehicleCapacity) {
		_vehicleCapacity = vehicleCapacity;
	}

	public String getVehicleChassisNo() {
		return _vehicleChassisNo;
	}

	public void setVehicleChassisNo(String vehicleChassisNo) {
		_vehicleChassisNo = vehicleChassisNo;
	}

	public String getVehicleColor() {
		return _vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		_vehicleColor = vehicleColor;
	}

	public long getVehicleCylinder() {
		return _vehicleCylinder;
	}

	public void setVehicleCylinder(long vehicleCylinder) {
		_vehicleCylinder = vehicleCylinder;
	}

	public Date getVehicleEstExpiryDate() {
		return _vehicleEstExpiryDate;
	}

	public void setVehicleEstExpiryDate(Date vehicleEstExpiryDate) {
		_vehicleEstExpiryDate = vehicleEstExpiryDate;
	}

	public long getVehicleId() {
		return _vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		_vehicleId = vehicleId;
	}

	public long getVehicleIdType() {
		return _vehicleIdType;
	}

	public void setVehicleIdType(long vehicleIdType) {
		_vehicleIdType = vehicleIdType;
	}

	public String getVehicleMake() {
		return _vehicleMake;
	}

	public void setVehicleMake(String vehicleMake) {
		_vehicleMake = vehicleMake;
	}

	public long getVehicleMfgYear() {
		return _vehicleMfgYear;
	}

	public void setVehicleMfgYear(long vehicleMfgYear) {
		_vehicleMfgYear = vehicleMfgYear;
	}

	public String getVehicleModel() {
		return _vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		_vehicleModel = vehicleModel;
	}

	public String getVehiclePlateL1() {
		return _vehiclePlateL1;
	}

	public void setVehiclePlateL1(String vehiclePlateL1) {
		_vehiclePlateL1 = vehiclePlateL1;
	}

	public String getVehiclePlateL2() {
		return _vehiclePlateL2;
	}

	public void setVehiclePlateL2(String vehiclePlateL2) {
		_vehiclePlateL2 = vehiclePlateL2;
	}

	public String getVehiclePlateL3() {
		return _vehiclePlateL3;
	}

	public void setVehiclePlateL3(String vehiclePlateL3) {
		_vehiclePlateL3 = vehiclePlateL3;
	}

	public long getVehiclePlateNo() {
		return _vehiclePlateNo;
	}

	public void setVehiclePlateNo(long vehiclePlateNo) {
		_vehiclePlateNo = vehiclePlateNo;
	}

	public String getVehiclePlateType() {
		return _vehiclePlateType;
	}

	public void setVehiclePlateType(String vehiclePlateType) {
		_vehiclePlateType = vehiclePlateType;
	}

	public long getVehicleValue() {
		return _vehicleValue;
	}

	public void setVehicleValue(long vehicleValue) {
		_vehicleValue = vehicleValue;
	}

	public long getVehicleWeight() {
		return _vehicleWeight;
	}

	public void setVehicleWeight(long vehicleWeight) {
		_vehicleWeight = vehicleWeight;
	}

	public String getVehicleCity() {
		return _vehicleCity;
	}

	public void setVehicleCity(String vehicleCity) {
		_vehicleCity = vehicleCity;
	}

	public long getVehicleCurrentMileage() {
		return _vehicleCurrentMileage;
	}

	public void setVehicleCurrentMileage(long vehicleCurrentMileage) {
		_vehicleCurrentMileage = vehicleCurrentMileage;
	}

	public long getVehicleLowerExpectedMileagePerYear() {
		return _vehicleLowerExpectedMileagePerYear;
	}

	public void setVehicleLowerExpectedMileagePerYear(
		long vehicleLowerExpectedMileagePerYear) {

		_vehicleLowerExpectedMileagePerYear =
			vehicleLowerExpectedMileagePerYear;
	}

	public long getVehicleUpperExpectedMileagePerYear() {
		return _vehicleUpperExpectedMileagePerYear;
	}

	public void setVehicleUpperExpectedMileagePerYear(
		long vehicleUpperExpectedMileagePerYear) {

		_vehicleUpperExpectedMileagePerYear =
			vehicleUpperExpectedMileagePerYear;
	}

	public String getVehicleNightLocation() {
		return _vehicleNightLocation;
	}

	public void setVehicleNightLocation(String vehicleNightLocation) {
		_vehicleNightLocation = vehicleNightLocation;
	}

	public String getVehicleEngineSize() {
		return _vehicleEngineSize;
	}

	public void setVehicleEngineSize(String vehicleEngineSize) {
		_vehicleEngineSize = vehicleEngineSize;
	}

	public String getVehicleTransType() {
		return _vehicleTransType;
	}

	public void setVehicleTransType(String vehicleTransType) {
		_vehicleTransType = vehicleTransType;
	}

	public long getVehAxleWeight() {
		return _vehAxleWeight;
	}

	public void setVehAxleWeight(long vehAxleWeight) {
		_vehAxleWeight = vehAxleWeight;
	}

	public String getVehCarMods() {
		return _vehCarMods;
	}

	public void setVehCarMods(String vehCarMods) {
		_vehCarMods = vehCarMods;
	}

	public String getVehSpecs() {
		return _vehSpecs;
	}

	public void setVehSpecs(String vehSpecs) {
		_vehSpecs = vehSpecs;
	}

	public String getOccCode() {
		return _occCode;
	}

	public void setOccCode(String occCode) {
		_occCode = occCode;
	}

	public String getInsuredIBAN() {
		return _insuredIBAN;
	}

	public void setInsuredIBAN(String insuredIBAN) {
		_insuredIBAN = insuredIBAN;
	}

	public String getInsuredDobH() {
		return _insuredDobH;
	}

	public void setInsuredDobH(String insuredDobH) {
		_insuredDobH = insuredDobH;
	}

	public double getNetPrem() {
		return _netPrem;
	}

	public void setNetPrem(double netPrem) {
		_netPrem = netPrem;
	}

	public double getDiscountAmount() {
		return _discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		_discountAmount = discountAmount;
	}

	public double getLoyaltyDiscountAmount() {
		return _loyaltyDiscountAmount;
	}

	public void setLoyaltyDiscountAmount(double loyaltyDiscountAmount) {
		_loyaltyDiscountAmount = loyaltyDiscountAmount;
	}

	public double getDiscountPrem() {
		return _discountPrem;
	}

	public void setDiscountPrem(double discountPrem) {
		_discountPrem = discountPrem;
	}

	public double getLoyaltyDiscountPer() {
		return _loyaltyDiscountPer;
	}

	public void setLoyaltyDiscountPer(double loyaltyDiscountPer) {
		_loyaltyDiscountPer = loyaltyDiscountPer;
	}

	public double getLoadingAmount() {
		return _loadingAmount;
	}

	public void setLoadingAmount(double loadingAmount) {
		_loadingAmount = loadingAmount;
	}

	public double getPolicyTaxes() {
		return _policyTaxes;
	}

	public void setPolicyTaxes(double policyTaxes) {
		_policyTaxes = policyTaxes;
	}

	public double getPolicyFees() {
		return _policyFees;
	}

	public void setPolicyFees(double policyFees) {
		_policyFees = policyFees;
	}

	public double getTotalCoverPrem() {
		return _totalCoverPrem;
	}

	public void setTotalCoverPrem(double totalCoverPrem) {
		_totalCoverPrem = totalCoverPrem;
	}

	public double getGrossPrem() {
		return _grossPrem;
	}

	public void setGrossPrem(double grossPrem) {
		_grossPrem = grossPrem;
	}

	public String getExistingPolicyNo() {
		return _existingPolicyNo;
	}

	public void setExistingPolicyNo(String existingPolicyNo) {
		_existingPolicyNo = existingPolicyNo;
	}

	public String getExistingCompanyName() {
		return _existingCompanyName;
	}

	public void setExistingCompanyName(String existingCompanyName) {
		_existingCompanyName = existingCompanyName;
	}

	public String getExistingExpDate() {
		return _existingExpDate;
	}

	public void setExistingExpDate(String existingExpDate) {
		_existingExpDate = existingExpDate;
	}

	public String getPolicyStatusMsg() {
		return _policyStatusMsg;
	}

	public void setPolicyStatusMsg(String policyStatusMsg) {
		_policyStatusMsg = policyStatusMsg;
	}

	public long getYakeenRefNo() {
		return _yakeenRefNo;
	}

	public void setYakeenRefNo(long yakeenRefNo) {
		_yakeenRefNo = yakeenRefNo;
	}

	public Date getQuoteSubmissionDate() {
		return _quoteSubmissionDate;
	}

	public void setQuoteSubmissionDate(Date quoteSubmissionDate) {
		_quoteSubmissionDate = quoteSubmissionDate;
	}

	public String getQuoteStatus() {
		return _quoteStatus;
	}

	public void setQuoteStatus(String quoteStatus) {
		_quoteStatus = quoteStatus;
	}

	public String getSaeedService() {
		return _saeedService;
	}

	public void setSaeedService(String saeedService) {
		_saeedService = saeedService;
	}

	public double getDriverAccidents() {
		return _driverAccidents;
	}

	public void setDriverAccidents(double driverAccidents) {
		_driverAccidents = driverAccidents;
	}

	public double getDriverAgeLess21() {
		return _driverAgeLess21;
	}

	public void setDriverAgeLess21(double driverAgeLess21) {
		_driverAgeLess21 = driverAgeLess21;
	}

	public double getAgencyRepairOut() {
		return _agencyRepairOut;
	}

	public void setAgencyRepairOut(double agencyRepairOut) {
		_agencyRepairOut = agencyRepairOut;
	}

	public double getTotalAfterDiscount() {
		return _totalAfterDiscount;
	}

	public void setTotalAfterDiscount(double totalAfterDiscount) {
		_totalAfterDiscount = totalAfterDiscount;
	}

	public double getTotalBeforeDisc() {
		return _totalBeforeDisc;
	}

	public void setTotalBeforeDisc(double totalBeforeDisc) {
		_totalBeforeDisc = totalBeforeDisc;
	}

	public boolean getSmsFlag() {
		return _smsFlag;
	}

	public boolean isSmsFlag() {
		return _smsFlag;
	}

	public void setSmsFlag(boolean smsFlag) {
		_smsFlag = smsFlag;
	}

	private long _addressAddNo;
	private long _addressBuildingNo;
	private String _addressDistrict;
	private String _addressStreet;
	private long _addressUnitNo;
	private long _addressZipCode;
	private String _addCover;
	private String _addDriver;
	private String _agencyRepair;
	private String _city;
	private String _deductibleValue;
	private Date _insuredDob;
	private String _insuredEmail;
	private String _insuredGender;
	private long _insuredId;
	private long _insuredIdType;
	private long _insuredMobile;
	private String _insuredName;
	private String _insuredNationality;
	private String _insuredEducation;
	private String _insuredMaritalStatus;
	private long _insuredNoChildUnder16;
	private String _loyaltyDiscount;
	private long _ncdYears;
	private long _paymemtAmount;
	private String _paymentMethod;
	private String _paymentRefNo;
	private Date _policyEffFromNo;
	private Date _policyEffTo;
	private Date _policyEffDate;
	private Date _policyIssueDate;
	private String _policyNo;
	private String _policyRefNo;
	private String _policyStatusCode;
	private String _productCode;
	private String _purposeOfVehicle;
	private long _quotationId;
	private String _referenceNo;
	private String _source;
	private String _transaction;
	private String _vehicleBodyType;
	private long _vehicleCapacity;
	private String _vehicleChassisNo;
	private String _vehicleColor;
	private long _vehicleCylinder;
	private Date _vehicleEstExpiryDate;
	private long _vehicleId;
	private long _vehicleIdType;
	private String _vehicleMake;
	private long _vehicleMfgYear;
	private String _vehicleModel;
	private String _vehiclePlateL1;
	private String _vehiclePlateL2;
	private String _vehiclePlateL3;
	private long _vehiclePlateNo;
	private String _vehiclePlateType;
	private long _vehicleValue;
	private long _vehicleWeight;
	private String _vehicleCity;
	private long _vehicleCurrentMileage;
	private long _vehicleLowerExpectedMileagePerYear;
	private long _vehicleUpperExpectedMileagePerYear;
	private String _vehicleNightLocation;
	private String _vehicleEngineSize;
	private String _vehicleTransType;
	private long _vehAxleWeight;
	private String _vehCarMods;
	private String _vehSpecs;
	private String _occCode;
	private String _insuredIBAN;
	private String _insuredDobH;
	private double _netPrem;
	private double _discountAmount;
	private double _loyaltyDiscountAmount;
	private double _discountPrem;
	private double _loyaltyDiscountPer;
	private double _loadingAmount;
	private double _policyTaxes;
	private double _policyFees;
	private double _totalCoverPrem;
	private double _grossPrem;
	private String _existingPolicyNo;
	private String _existingCompanyName;
	private String _existingExpDate;
	private String _policyStatusMsg;
	private long _yakeenRefNo;
	private Date _quoteSubmissionDate;
	private String _quoteStatus;
	private String _saeedService;
	private double _driverAccidents;
	private double _driverAgeLess21;
	private double _agencyRepairOut;
	private double _totalAfterDiscount;
	private double _totalBeforeDisc;
	private boolean _smsFlag;

}