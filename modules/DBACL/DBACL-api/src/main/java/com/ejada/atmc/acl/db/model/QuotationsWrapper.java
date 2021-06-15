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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Quotations}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Quotations
 * @generated
 */
public class QuotationsWrapper
	extends BaseModelWrapper<Quotations>
	implements ModelWrapper<Quotations>, Quotations {

	public QuotationsWrapper(Quotations quotations) {
		super(quotations);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressAddNo", getAddressAddNo());
		attributes.put("addressBuildingNo", getAddressBuildingNo());
		attributes.put("addressDistrict", getAddressDistrict());
		attributes.put("addressStreet", getAddressStreet());
		attributes.put("addressUnitNo", getAddressUnitNo());
		attributes.put("addressZipCode", getAddressZipCode());
		attributes.put("addCover", getAddCover());
		attributes.put("addDriver", getAddDriver());
		attributes.put("agencyRepair", getAgencyRepair());
		attributes.put("city", getCity());
		attributes.put("deductibleValue", getDeductibleValue());
		attributes.put("insuredDob", getInsuredDob());
		attributes.put("insuredEmail", getInsuredEmail());
		attributes.put("insuredGender", getInsuredGender());
		attributes.put("insuredId", getInsuredId());
		attributes.put("insuredIdType", getInsuredIdType());
		attributes.put("insuredMobile", getInsuredMobile());
		attributes.put("insuredName", getInsuredName());
		attributes.put("insuredNationality", getInsuredNationality());
		attributes.put("insuredEducation", getInsuredEducation());
		attributes.put("insuredMaritalStatus", getInsuredMaritalStatus());
		attributes.put("insuredNoChildUnder16", getInsuredNoChildUnder16());
		attributes.put("loyaltyDiscount", getLoyaltyDiscount());
		attributes.put("ncdYears", getNcdYears());
		attributes.put("paymemtAmount", getPaymemtAmount());
		attributes.put("paymentMethod", getPaymentMethod());
		attributes.put("paymentRefNo", getPaymentRefNo());
		attributes.put("policyEffFromNo", getPolicyEffFromNo());
		attributes.put("policyEffTo", getPolicyEffTo());
		attributes.put("policyEffDate", getPolicyEffDate());
		attributes.put("policyIssueDate", getPolicyIssueDate());
		attributes.put("policyNo", getPolicyNo());
		attributes.put("policyRefNo", getPolicyRefNo());
		attributes.put("policyStatusCode", getPolicyStatusCode());
		attributes.put("productCode", getProductCode());
		attributes.put("purposeOfVehicle", getPurposeOfVehicle());
		attributes.put("quotationId", getQuotationId());
		attributes.put("referenceNo", getReferenceNo());
		attributes.put("source", getSource());
		attributes.put("transaction", getTransaction());
		attributes.put("vehicleBodyType", getVehicleBodyType());
		attributes.put("vehicleCapacity", getVehicleCapacity());
		attributes.put("vehicleChassisNo", getVehicleChassisNo());
		attributes.put("vehicleColor", getVehicleColor());
		attributes.put("vehicleCylinder", getVehicleCylinder());
		attributes.put("vehicleEstExpiryDate", getVehicleEstExpiryDate());
		attributes.put("vehicleId", getVehicleId());
		attributes.put("vehicleIdType", getVehicleIdType());
		attributes.put("vehicleMake", getVehicleMake());
		attributes.put("vehicleMfgYear", getVehicleMfgYear());
		attributes.put("vehicleModel", getVehicleModel());
		attributes.put("vehiclePlateL1", getVehiclePlateL1());
		attributes.put("vehiclePlateL2", getVehiclePlateL2());
		attributes.put("vehiclePlateL3", getVehiclePlateL3());
		attributes.put("vehiclePlateNo", getVehiclePlateNo());
		attributes.put("vehiclePlateType", getVehiclePlateType());
		attributes.put("vehicleValue", getVehicleValue());
		attributes.put("vehicleWeight", getVehicleWeight());
		attributes.put("vehicleCity", getVehicleCity());
		attributes.put("vehicleCurrentMileage", getVehicleCurrentMileage());
		attributes.put(
			"vehicleLowerExpectedMileagePerYear",
			getVehicleLowerExpectedMileagePerYear());
		attributes.put(
			"vehicleUpperExpectedMileagePerYear",
			getVehicleUpperExpectedMileagePerYear());
		attributes.put("vehicleNightLocation", getVehicleNightLocation());
		attributes.put("vehicleEngineSize", getVehicleEngineSize());
		attributes.put("vehicleTransType", getVehicleTransType());
		attributes.put("vehAxleWeight", getVehAxleWeight());
		attributes.put("vehCarMods", getVehCarMods());
		attributes.put("vehSpecs", getVehSpecs());
		attributes.put("occCode", getOccCode());
		attributes.put("insuredIBAN", getInsuredIBAN());
		attributes.put("insuredDobH", getInsuredDobH());
		attributes.put("netPrem", getNetPrem());
		attributes.put("discountAmount", getDiscountAmount());
		attributes.put("loyaltyDiscountAmount", getLoyaltyDiscountAmount());
		attributes.put("discountPrem", getDiscountPrem());
		attributes.put("loyaltyDiscountPer", getLoyaltyDiscountPer());
		attributes.put("loadingAmount", getLoadingAmount());
		attributes.put("policyTaxes", getPolicyTaxes());
		attributes.put("policyFees", getPolicyFees());
		attributes.put("totalCoverPrem", getTotalCoverPrem());
		attributes.put("grossPrem", getGrossPrem());
		attributes.put("existingPolicyNo", getExistingPolicyNo());
		attributes.put("existingCompanyName", getExistingCompanyName());
		attributes.put("existingExpDate", getExistingExpDate());
		attributes.put("policyStatusMsg", getPolicyStatusMsg());
		attributes.put("yakeenRefNo", getYakeenRefNo());
		attributes.put("quoteSubmissionDate", getQuoteSubmissionDate());
		attributes.put("quoteStatus", getQuoteStatus());
		attributes.put("saeedService", getSaeedService());
		attributes.put("driverAccidents", getDriverAccidents());
		attributes.put("driverAgeLess21", getDriverAgeLess21());
		attributes.put("agencyRepairOut", getAgencyRepairOut());
		attributes.put("totalAfterDiscount", getTotalAfterDiscount());
		attributes.put("totalBeforeDisc", getTotalBeforeDisc());
		attributes.put("smsFlag", isSmsFlag());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressAddNo = (Long)attributes.get("addressAddNo");

		if (addressAddNo != null) {
			setAddressAddNo(addressAddNo);
		}

		Long addressBuildingNo = (Long)attributes.get("addressBuildingNo");

		if (addressBuildingNo != null) {
			setAddressBuildingNo(addressBuildingNo);
		}

		String addressDistrict = (String)attributes.get("addressDistrict");

		if (addressDistrict != null) {
			setAddressDistrict(addressDistrict);
		}

		String addressStreet = (String)attributes.get("addressStreet");

		if (addressStreet != null) {
			setAddressStreet(addressStreet);
		}

		Long addressUnitNo = (Long)attributes.get("addressUnitNo");

		if (addressUnitNo != null) {
			setAddressUnitNo(addressUnitNo);
		}

		Long addressZipCode = (Long)attributes.get("addressZipCode");

		if (addressZipCode != null) {
			setAddressZipCode(addressZipCode);
		}

		String addCover = (String)attributes.get("addCover");

		if (addCover != null) {
			setAddCover(addCover);
		}

		String addDriver = (String)attributes.get("addDriver");

		if (addDriver != null) {
			setAddDriver(addDriver);
		}

		String agencyRepair = (String)attributes.get("agencyRepair");

		if (agencyRepair != null) {
			setAgencyRepair(agencyRepair);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String deductibleValue = (String)attributes.get("deductibleValue");

		if (deductibleValue != null) {
			setDeductibleValue(deductibleValue);
		}

		Date insuredDob = (Date)attributes.get("insuredDob");

		if (insuredDob != null) {
			setInsuredDob(insuredDob);
		}

		String insuredEmail = (String)attributes.get("insuredEmail");

		if (insuredEmail != null) {
			setInsuredEmail(insuredEmail);
		}

		String insuredGender = (String)attributes.get("insuredGender");

		if (insuredGender != null) {
			setInsuredGender(insuredGender);
		}

		Long insuredId = (Long)attributes.get("insuredId");

		if (insuredId != null) {
			setInsuredId(insuredId);
		}

		Long insuredIdType = (Long)attributes.get("insuredIdType");

		if (insuredIdType != null) {
			setInsuredIdType(insuredIdType);
		}

		Long insuredMobile = (Long)attributes.get("insuredMobile");

		if (insuredMobile != null) {
			setInsuredMobile(insuredMobile);
		}

		String insuredName = (String)attributes.get("insuredName");

		if (insuredName != null) {
			setInsuredName(insuredName);
		}

		String insuredNationality = (String)attributes.get(
			"insuredNationality");

		if (insuredNationality != null) {
			setInsuredNationality(insuredNationality);
		}

		String insuredEducation = (String)attributes.get("insuredEducation");

		if (insuredEducation != null) {
			setInsuredEducation(insuredEducation);
		}

		String insuredMaritalStatus = (String)attributes.get(
			"insuredMaritalStatus");

		if (insuredMaritalStatus != null) {
			setInsuredMaritalStatus(insuredMaritalStatus);
		}

		Long insuredNoChildUnder16 = (Long)attributes.get(
			"insuredNoChildUnder16");

		if (insuredNoChildUnder16 != null) {
			setInsuredNoChildUnder16(insuredNoChildUnder16);
		}

		String loyaltyDiscount = (String)attributes.get("loyaltyDiscount");

		if (loyaltyDiscount != null) {
			setLoyaltyDiscount(loyaltyDiscount);
		}

		Long ncdYears = (Long)attributes.get("ncdYears");

		if (ncdYears != null) {
			setNcdYears(ncdYears);
		}

		Long paymemtAmount = (Long)attributes.get("paymemtAmount");

		if (paymemtAmount != null) {
			setPaymemtAmount(paymemtAmount);
		}

		String paymentMethod = (String)attributes.get("paymentMethod");

		if (paymentMethod != null) {
			setPaymentMethod(paymentMethod);
		}

		String paymentRefNo = (String)attributes.get("paymentRefNo");

		if (paymentRefNo != null) {
			setPaymentRefNo(paymentRefNo);
		}

		Date policyEffFromNo = (Date)attributes.get("policyEffFromNo");

		if (policyEffFromNo != null) {
			setPolicyEffFromNo(policyEffFromNo);
		}

		Date policyEffTo = (Date)attributes.get("policyEffTo");

		if (policyEffTo != null) {
			setPolicyEffTo(policyEffTo);
		}

		Date policyEffDate = (Date)attributes.get("policyEffDate");

		if (policyEffDate != null) {
			setPolicyEffDate(policyEffDate);
		}

		Date policyIssueDate = (Date)attributes.get("policyIssueDate");

		if (policyIssueDate != null) {
			setPolicyIssueDate(policyIssueDate);
		}

		String policyNo = (String)attributes.get("policyNo");

		if (policyNo != null) {
			setPolicyNo(policyNo);
		}

		String policyRefNo = (String)attributes.get("policyRefNo");

		if (policyRefNo != null) {
			setPolicyRefNo(policyRefNo);
		}

		String policyStatusCode = (String)attributes.get("policyStatusCode");

		if (policyStatusCode != null) {
			setPolicyStatusCode(policyStatusCode);
		}

		String productCode = (String)attributes.get("productCode");

		if (productCode != null) {
			setProductCode(productCode);
		}

		String purposeOfVehicle = (String)attributes.get("purposeOfVehicle");

		if (purposeOfVehicle != null) {
			setPurposeOfVehicle(purposeOfVehicle);
		}

		Long quotationId = (Long)attributes.get("quotationId");

		if (quotationId != null) {
			setQuotationId(quotationId);
		}

		String referenceNo = (String)attributes.get("referenceNo");

		if (referenceNo != null) {
			setReferenceNo(referenceNo);
		}

		String source = (String)attributes.get("source");

		if (source != null) {
			setSource(source);
		}

		String transaction = (String)attributes.get("transaction");

		if (transaction != null) {
			setTransaction(transaction);
		}

		String vehicleBodyType = (String)attributes.get("vehicleBodyType");

		if (vehicleBodyType != null) {
			setVehicleBodyType(vehicleBodyType);
		}

		Long vehicleCapacity = (Long)attributes.get("vehicleCapacity");

		if (vehicleCapacity != null) {
			setVehicleCapacity(vehicleCapacity);
		}

		String vehicleChassisNo = (String)attributes.get("vehicleChassisNo");

		if (vehicleChassisNo != null) {
			setVehicleChassisNo(vehicleChassisNo);
		}

		String vehicleColor = (String)attributes.get("vehicleColor");

		if (vehicleColor != null) {
			setVehicleColor(vehicleColor);
		}

		Long vehicleCylinder = (Long)attributes.get("vehicleCylinder");

		if (vehicleCylinder != null) {
			setVehicleCylinder(vehicleCylinder);
		}

		Date vehicleEstExpiryDate = (Date)attributes.get(
			"vehicleEstExpiryDate");

		if (vehicleEstExpiryDate != null) {
			setVehicleEstExpiryDate(vehicleEstExpiryDate);
		}

		Long vehicleId = (Long)attributes.get("vehicleId");

		if (vehicleId != null) {
			setVehicleId(vehicleId);
		}

		Long vehicleIdType = (Long)attributes.get("vehicleIdType");

		if (vehicleIdType != null) {
			setVehicleIdType(vehicleIdType);
		}

		String vehicleMake = (String)attributes.get("vehicleMake");

		if (vehicleMake != null) {
			setVehicleMake(vehicleMake);
		}

		Long vehicleMfgYear = (Long)attributes.get("vehicleMfgYear");

		if (vehicleMfgYear != null) {
			setVehicleMfgYear(vehicleMfgYear);
		}

		String vehicleModel = (String)attributes.get("vehicleModel");

		if (vehicleModel != null) {
			setVehicleModel(vehicleModel);
		}

		String vehiclePlateL1 = (String)attributes.get("vehiclePlateL1");

		if (vehiclePlateL1 != null) {
			setVehiclePlateL1(vehiclePlateL1);
		}

		String vehiclePlateL2 = (String)attributes.get("vehiclePlateL2");

		if (vehiclePlateL2 != null) {
			setVehiclePlateL2(vehiclePlateL2);
		}

		String vehiclePlateL3 = (String)attributes.get("vehiclePlateL3");

		if (vehiclePlateL3 != null) {
			setVehiclePlateL3(vehiclePlateL3);
		}

		Long vehiclePlateNo = (Long)attributes.get("vehiclePlateNo");

		if (vehiclePlateNo != null) {
			setVehiclePlateNo(vehiclePlateNo);
		}

		String vehiclePlateType = (String)attributes.get("vehiclePlateType");

		if (vehiclePlateType != null) {
			setVehiclePlateType(vehiclePlateType);
		}

		Long vehicleValue = (Long)attributes.get("vehicleValue");

		if (vehicleValue != null) {
			setVehicleValue(vehicleValue);
		}

		Long vehicleWeight = (Long)attributes.get("vehicleWeight");

		if (vehicleWeight != null) {
			setVehicleWeight(vehicleWeight);
		}

		String vehicleCity = (String)attributes.get("vehicleCity");

		if (vehicleCity != null) {
			setVehicleCity(vehicleCity);
		}

		Long vehicleCurrentMileage = (Long)attributes.get(
			"vehicleCurrentMileage");

		if (vehicleCurrentMileage != null) {
			setVehicleCurrentMileage(vehicleCurrentMileage);
		}

		Long vehicleLowerExpectedMileagePerYear = (Long)attributes.get(
			"vehicleLowerExpectedMileagePerYear");

		if (vehicleLowerExpectedMileagePerYear != null) {
			setVehicleLowerExpectedMileagePerYear(
				vehicleLowerExpectedMileagePerYear);
		}

		Long vehicleUpperExpectedMileagePerYear = (Long)attributes.get(
			"vehicleUpperExpectedMileagePerYear");

		if (vehicleUpperExpectedMileagePerYear != null) {
			setVehicleUpperExpectedMileagePerYear(
				vehicleUpperExpectedMileagePerYear);
		}

		String vehicleNightLocation = (String)attributes.get(
			"vehicleNightLocation");

		if (vehicleNightLocation != null) {
			setVehicleNightLocation(vehicleNightLocation);
		}

		String vehicleEngineSize = (String)attributes.get("vehicleEngineSize");

		if (vehicleEngineSize != null) {
			setVehicleEngineSize(vehicleEngineSize);
		}

		String vehicleTransType = (String)attributes.get("vehicleTransType");

		if (vehicleTransType != null) {
			setVehicleTransType(vehicleTransType);
		}

		Long vehAxleWeight = (Long)attributes.get("vehAxleWeight");

		if (vehAxleWeight != null) {
			setVehAxleWeight(vehAxleWeight);
		}

		String vehCarMods = (String)attributes.get("vehCarMods");

		if (vehCarMods != null) {
			setVehCarMods(vehCarMods);
		}

		String vehSpecs = (String)attributes.get("vehSpecs");

		if (vehSpecs != null) {
			setVehSpecs(vehSpecs);
		}

		String occCode = (String)attributes.get("occCode");

		if (occCode != null) {
			setOccCode(occCode);
		}

		String insuredIBAN = (String)attributes.get("insuredIBAN");

		if (insuredIBAN != null) {
			setInsuredIBAN(insuredIBAN);
		}

		String insuredDobH = (String)attributes.get("insuredDobH");

		if (insuredDobH != null) {
			setInsuredDobH(insuredDobH);
		}

		Double netPrem = (Double)attributes.get("netPrem");

		if (netPrem != null) {
			setNetPrem(netPrem);
		}

		Double discountAmount = (Double)attributes.get("discountAmount");

		if (discountAmount != null) {
			setDiscountAmount(discountAmount);
		}

		Double loyaltyDiscountAmount = (Double)attributes.get(
			"loyaltyDiscountAmount");

		if (loyaltyDiscountAmount != null) {
			setLoyaltyDiscountAmount(loyaltyDiscountAmount);
		}

		Double discountPrem = (Double)attributes.get("discountPrem");

		if (discountPrem != null) {
			setDiscountPrem(discountPrem);
		}

		Double loyaltyDiscountPer = (Double)attributes.get(
			"loyaltyDiscountPer");

		if (loyaltyDiscountPer != null) {
			setLoyaltyDiscountPer(loyaltyDiscountPer);
		}

		Double loadingAmount = (Double)attributes.get("loadingAmount");

		if (loadingAmount != null) {
			setLoadingAmount(loadingAmount);
		}

		Double policyTaxes = (Double)attributes.get("policyTaxes");

		if (policyTaxes != null) {
			setPolicyTaxes(policyTaxes);
		}

		Double policyFees = (Double)attributes.get("policyFees");

		if (policyFees != null) {
			setPolicyFees(policyFees);
		}

		Double totalCoverPrem = (Double)attributes.get("totalCoverPrem");

		if (totalCoverPrem != null) {
			setTotalCoverPrem(totalCoverPrem);
		}

		Double grossPrem = (Double)attributes.get("grossPrem");

		if (grossPrem != null) {
			setGrossPrem(grossPrem);
		}

		String existingPolicyNo = (String)attributes.get("existingPolicyNo");

		if (existingPolicyNo != null) {
			setExistingPolicyNo(existingPolicyNo);
		}

		String existingCompanyName = (String)attributes.get(
			"existingCompanyName");

		if (existingCompanyName != null) {
			setExistingCompanyName(existingCompanyName);
		}

		String existingExpDate = (String)attributes.get("existingExpDate");

		if (existingExpDate != null) {
			setExistingExpDate(existingExpDate);
		}

		String policyStatusMsg = (String)attributes.get("policyStatusMsg");

		if (policyStatusMsg != null) {
			setPolicyStatusMsg(policyStatusMsg);
		}

		Long yakeenRefNo = (Long)attributes.get("yakeenRefNo");

		if (yakeenRefNo != null) {
			setYakeenRefNo(yakeenRefNo);
		}

		Date quoteSubmissionDate = (Date)attributes.get("quoteSubmissionDate");

		if (quoteSubmissionDate != null) {
			setQuoteSubmissionDate(quoteSubmissionDate);
		}

		String quoteStatus = (String)attributes.get("quoteStatus");

		if (quoteStatus != null) {
			setQuoteStatus(quoteStatus);
		}

		String saeedService = (String)attributes.get("saeedService");

		if (saeedService != null) {
			setSaeedService(saeedService);
		}

		Double driverAccidents = (Double)attributes.get("driverAccidents");

		if (driverAccidents != null) {
			setDriverAccidents(driverAccidents);
		}

		Double driverAgeLess21 = (Double)attributes.get("driverAgeLess21");

		if (driverAgeLess21 != null) {
			setDriverAgeLess21(driverAgeLess21);
		}

		Double agencyRepairOut = (Double)attributes.get("agencyRepairOut");

		if (agencyRepairOut != null) {
			setAgencyRepairOut(agencyRepairOut);
		}

		Double totalAfterDiscount = (Double)attributes.get(
			"totalAfterDiscount");

		if (totalAfterDiscount != null) {
			setTotalAfterDiscount(totalAfterDiscount);
		}

		Double totalBeforeDisc = (Double)attributes.get("totalBeforeDisc");

		if (totalBeforeDisc != null) {
			setTotalBeforeDisc(totalBeforeDisc);
		}

		Boolean smsFlag = (Boolean)attributes.get("smsFlag");

		if (smsFlag != null) {
			setSmsFlag(smsFlag);
		}
	}

	/**
	 * Returns the add cover of this quotations.
	 *
	 * @return the add cover of this quotations
	 */
	@Override
	public String getAddCover() {
		return model.getAddCover();
	}

	/**
	 * Returns the add driver of this quotations.
	 *
	 * @return the add driver of this quotations
	 */
	@Override
	public String getAddDriver() {
		return model.getAddDriver();
	}

	/**
	 * Returns the address add no of this quotations.
	 *
	 * @return the address add no of this quotations
	 */
	@Override
	public long getAddressAddNo() {
		return model.getAddressAddNo();
	}

	/**
	 * Returns the address building no of this quotations.
	 *
	 * @return the address building no of this quotations
	 */
	@Override
	public long getAddressBuildingNo() {
		return model.getAddressBuildingNo();
	}

	/**
	 * Returns the address district of this quotations.
	 *
	 * @return the address district of this quotations
	 */
	@Override
	public String getAddressDistrict() {
		return model.getAddressDistrict();
	}

	/**
	 * Returns the address street of this quotations.
	 *
	 * @return the address street of this quotations
	 */
	@Override
	public String getAddressStreet() {
		return model.getAddressStreet();
	}

	/**
	 * Returns the address unit no of this quotations.
	 *
	 * @return the address unit no of this quotations
	 */
	@Override
	public long getAddressUnitNo() {
		return model.getAddressUnitNo();
	}

	/**
	 * Returns the address zip code of this quotations.
	 *
	 * @return the address zip code of this quotations
	 */
	@Override
	public long getAddressZipCode() {
		return model.getAddressZipCode();
	}

	/**
	 * Returns the agency repair of this quotations.
	 *
	 * @return the agency repair of this quotations
	 */
	@Override
	public String getAgencyRepair() {
		return model.getAgencyRepair();
	}

	/**
	 * Returns the agency repair out of this quotations.
	 *
	 * @return the agency repair out of this quotations
	 */
	@Override
	public double getAgencyRepairOut() {
		return model.getAgencyRepairOut();
	}

	/**
	 * Returns the city of this quotations.
	 *
	 * @return the city of this quotations
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the deductible value of this quotations.
	 *
	 * @return the deductible value of this quotations
	 */
	@Override
	public String getDeductibleValue() {
		return model.getDeductibleValue();
	}

	/**
	 * Returns the discount amount of this quotations.
	 *
	 * @return the discount amount of this quotations
	 */
	@Override
	public double getDiscountAmount() {
		return model.getDiscountAmount();
	}

	/**
	 * Returns the discount prem of this quotations.
	 *
	 * @return the discount prem of this quotations
	 */
	@Override
	public double getDiscountPrem() {
		return model.getDiscountPrem();
	}

	/**
	 * Returns the driver accidents of this quotations.
	 *
	 * @return the driver accidents of this quotations
	 */
	@Override
	public double getDriverAccidents() {
		return model.getDriverAccidents();
	}

	/**
	 * Returns the driver age less21 of this quotations.
	 *
	 * @return the driver age less21 of this quotations
	 */
	@Override
	public double getDriverAgeLess21() {
		return model.getDriverAgeLess21();
	}

	/**
	 * Returns the existing company name of this quotations.
	 *
	 * @return the existing company name of this quotations
	 */
	@Override
	public String getExistingCompanyName() {
		return model.getExistingCompanyName();
	}

	/**
	 * Returns the existing exp date of this quotations.
	 *
	 * @return the existing exp date of this quotations
	 */
	@Override
	public String getExistingExpDate() {
		return model.getExistingExpDate();
	}

	/**
	 * Returns the existing policy no of this quotations.
	 *
	 * @return the existing policy no of this quotations
	 */
	@Override
	public String getExistingPolicyNo() {
		return model.getExistingPolicyNo();
	}

	/**
	 * Returns the gross prem of this quotations.
	 *
	 * @return the gross prem of this quotations
	 */
	@Override
	public double getGrossPrem() {
		return model.getGrossPrem();
	}

	/**
	 * Returns the insured dob of this quotations.
	 *
	 * @return the insured dob of this quotations
	 */
	@Override
	public Date getInsuredDob() {
		return model.getInsuredDob();
	}

	/**
	 * Returns the insured dob h of this quotations.
	 *
	 * @return the insured dob h of this quotations
	 */
	@Override
	public String getInsuredDobH() {
		return model.getInsuredDobH();
	}

	/**
	 * Returns the insured education of this quotations.
	 *
	 * @return the insured education of this quotations
	 */
	@Override
	public String getInsuredEducation() {
		return model.getInsuredEducation();
	}

	/**
	 * Returns the insured email of this quotations.
	 *
	 * @return the insured email of this quotations
	 */
	@Override
	public String getInsuredEmail() {
		return model.getInsuredEmail();
	}

	/**
	 * Returns the insured gender of this quotations.
	 *
	 * @return the insured gender of this quotations
	 */
	@Override
	public String getInsuredGender() {
		return model.getInsuredGender();
	}

	/**
	 * Returns the insured iban of this quotations.
	 *
	 * @return the insured iban of this quotations
	 */
	@Override
	public String getInsuredIBAN() {
		return model.getInsuredIBAN();
	}

	/**
	 * Returns the insured ID of this quotations.
	 *
	 * @return the insured ID of this quotations
	 */
	@Override
	public long getInsuredId() {
		return model.getInsuredId();
	}

	/**
	 * Returns the insured ID type of this quotations.
	 *
	 * @return the insured ID type of this quotations
	 */
	@Override
	public long getInsuredIdType() {
		return model.getInsuredIdType();
	}

	/**
	 * Returns the insured marital status of this quotations.
	 *
	 * @return the insured marital status of this quotations
	 */
	@Override
	public String getInsuredMaritalStatus() {
		return model.getInsuredMaritalStatus();
	}

	/**
	 * Returns the insured mobile of this quotations.
	 *
	 * @return the insured mobile of this quotations
	 */
	@Override
	public long getInsuredMobile() {
		return model.getInsuredMobile();
	}

	/**
	 * Returns the insured name of this quotations.
	 *
	 * @return the insured name of this quotations
	 */
	@Override
	public String getInsuredName() {
		return model.getInsuredName();
	}

	/**
	 * Returns the insured nationality of this quotations.
	 *
	 * @return the insured nationality of this quotations
	 */
	@Override
	public String getInsuredNationality() {
		return model.getInsuredNationality();
	}

	/**
	 * Returns the insured no child under16 of this quotations.
	 *
	 * @return the insured no child under16 of this quotations
	 */
	@Override
	public long getInsuredNoChildUnder16() {
		return model.getInsuredNoChildUnder16();
	}

	/**
	 * Returns the loading amount of this quotations.
	 *
	 * @return the loading amount of this quotations
	 */
	@Override
	public double getLoadingAmount() {
		return model.getLoadingAmount();
	}

	/**
	 * Returns the loyalty discount of this quotations.
	 *
	 * @return the loyalty discount of this quotations
	 */
	@Override
	public String getLoyaltyDiscount() {
		return model.getLoyaltyDiscount();
	}

	/**
	 * Returns the loyalty discount amount of this quotations.
	 *
	 * @return the loyalty discount amount of this quotations
	 */
	@Override
	public double getLoyaltyDiscountAmount() {
		return model.getLoyaltyDiscountAmount();
	}

	/**
	 * Returns the loyalty discount per of this quotations.
	 *
	 * @return the loyalty discount per of this quotations
	 */
	@Override
	public double getLoyaltyDiscountPer() {
		return model.getLoyaltyDiscountPer();
	}

	/**
	 * Returns the ncd years of this quotations.
	 *
	 * @return the ncd years of this quotations
	 */
	@Override
	public long getNcdYears() {
		return model.getNcdYears();
	}

	/**
	 * Returns the net prem of this quotations.
	 *
	 * @return the net prem of this quotations
	 */
	@Override
	public double getNetPrem() {
		return model.getNetPrem();
	}

	/**
	 * Returns the occ code of this quotations.
	 *
	 * @return the occ code of this quotations
	 */
	@Override
	public String getOccCode() {
		return model.getOccCode();
	}

	/**
	 * Returns the paymemt amount of this quotations.
	 *
	 * @return the paymemt amount of this quotations
	 */
	@Override
	public long getPaymemtAmount() {
		return model.getPaymemtAmount();
	}

	/**
	 * Returns the payment method of this quotations.
	 *
	 * @return the payment method of this quotations
	 */
	@Override
	public String getPaymentMethod() {
		return model.getPaymentMethod();
	}

	/**
	 * Returns the payment ref no of this quotations.
	 *
	 * @return the payment ref no of this quotations
	 */
	@Override
	public String getPaymentRefNo() {
		return model.getPaymentRefNo();
	}

	/**
	 * Returns the policy eff date of this quotations.
	 *
	 * @return the policy eff date of this quotations
	 */
	@Override
	public Date getPolicyEffDate() {
		return model.getPolicyEffDate();
	}

	/**
	 * Returns the policy eff from no of this quotations.
	 *
	 * @return the policy eff from no of this quotations
	 */
	@Override
	public Date getPolicyEffFromNo() {
		return model.getPolicyEffFromNo();
	}

	/**
	 * Returns the policy eff to of this quotations.
	 *
	 * @return the policy eff to of this quotations
	 */
	@Override
	public Date getPolicyEffTo() {
		return model.getPolicyEffTo();
	}

	/**
	 * Returns the policy fees of this quotations.
	 *
	 * @return the policy fees of this quotations
	 */
	@Override
	public double getPolicyFees() {
		return model.getPolicyFees();
	}

	/**
	 * Returns the policy issue date of this quotations.
	 *
	 * @return the policy issue date of this quotations
	 */
	@Override
	public Date getPolicyIssueDate() {
		return model.getPolicyIssueDate();
	}

	/**
	 * Returns the policy no of this quotations.
	 *
	 * @return the policy no of this quotations
	 */
	@Override
	public String getPolicyNo() {
		return model.getPolicyNo();
	}

	/**
	 * Returns the policy ref no of this quotations.
	 *
	 * @return the policy ref no of this quotations
	 */
	@Override
	public String getPolicyRefNo() {
		return model.getPolicyRefNo();
	}

	/**
	 * Returns the policy status code of this quotations.
	 *
	 * @return the policy status code of this quotations
	 */
	@Override
	public String getPolicyStatusCode() {
		return model.getPolicyStatusCode();
	}

	/**
	 * Returns the policy status msg of this quotations.
	 *
	 * @return the policy status msg of this quotations
	 */
	@Override
	public String getPolicyStatusMsg() {
		return model.getPolicyStatusMsg();
	}

	/**
	 * Returns the policy taxes of this quotations.
	 *
	 * @return the policy taxes of this quotations
	 */
	@Override
	public double getPolicyTaxes() {
		return model.getPolicyTaxes();
	}

	/**
	 * Returns the primary key of this quotations.
	 *
	 * @return the primary key of this quotations
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product code of this quotations.
	 *
	 * @return the product code of this quotations
	 */
	@Override
	public String getProductCode() {
		return model.getProductCode();
	}

	/**
	 * Returns the purpose of vehicle of this quotations.
	 *
	 * @return the purpose of vehicle of this quotations
	 */
	@Override
	public String getPurposeOfVehicle() {
		return model.getPurposeOfVehicle();
	}

	/**
	 * Returns the quotation ID of this quotations.
	 *
	 * @return the quotation ID of this quotations
	 */
	@Override
	public long getQuotationId() {
		return model.getQuotationId();
	}

	/**
	 * Returns the quote status of this quotations.
	 *
	 * @return the quote status of this quotations
	 */
	@Override
	public String getQuoteStatus() {
		return model.getQuoteStatus();
	}

	/**
	 * Returns the quote submission date of this quotations.
	 *
	 * @return the quote submission date of this quotations
	 */
	@Override
	public Date getQuoteSubmissionDate() {
		return model.getQuoteSubmissionDate();
	}

	/**
	 * Returns the reference no of this quotations.
	 *
	 * @return the reference no of this quotations
	 */
	@Override
	public String getReferenceNo() {
		return model.getReferenceNo();
	}

	/**
	 * Returns the saeed service of this quotations.
	 *
	 * @return the saeed service of this quotations
	 */
	@Override
	public String getSaeedService() {
		return model.getSaeedService();
	}

	/**
	 * Returns the sms flag of this quotations.
	 *
	 * @return the sms flag of this quotations
	 */
	@Override
	public boolean getSmsFlag() {
		return model.getSmsFlag();
	}

	/**
	 * Returns the source of this quotations.
	 *
	 * @return the source of this quotations
	 */
	@Override
	public String getSource() {
		return model.getSource();
	}

	/**
	 * Returns the total after discount of this quotations.
	 *
	 * @return the total after discount of this quotations
	 */
	@Override
	public double getTotalAfterDiscount() {
		return model.getTotalAfterDiscount();
	}

	/**
	 * Returns the total before disc of this quotations.
	 *
	 * @return the total before disc of this quotations
	 */
	@Override
	public double getTotalBeforeDisc() {
		return model.getTotalBeforeDisc();
	}

	/**
	 * Returns the total cover prem of this quotations.
	 *
	 * @return the total cover prem of this quotations
	 */
	@Override
	public double getTotalCoverPrem() {
		return model.getTotalCoverPrem();
	}

	/**
	 * Returns the transaction of this quotations.
	 *
	 * @return the transaction of this quotations
	 */
	@Override
	public String getTransaction() {
		return model.getTransaction();
	}

	/**
	 * Returns the veh axle weight of this quotations.
	 *
	 * @return the veh axle weight of this quotations
	 */
	@Override
	public long getVehAxleWeight() {
		return model.getVehAxleWeight();
	}

	/**
	 * Returns the veh car mods of this quotations.
	 *
	 * @return the veh car mods of this quotations
	 */
	@Override
	public String getVehCarMods() {
		return model.getVehCarMods();
	}

	/**
	 * Returns the vehicle body type of this quotations.
	 *
	 * @return the vehicle body type of this quotations
	 */
	@Override
	public String getVehicleBodyType() {
		return model.getVehicleBodyType();
	}

	/**
	 * Returns the vehicle capacity of this quotations.
	 *
	 * @return the vehicle capacity of this quotations
	 */
	@Override
	public long getVehicleCapacity() {
		return model.getVehicleCapacity();
	}

	/**
	 * Returns the vehicle chassis no of this quotations.
	 *
	 * @return the vehicle chassis no of this quotations
	 */
	@Override
	public String getVehicleChassisNo() {
		return model.getVehicleChassisNo();
	}

	/**
	 * Returns the vehicle city of this quotations.
	 *
	 * @return the vehicle city of this quotations
	 */
	@Override
	public String getVehicleCity() {
		return model.getVehicleCity();
	}

	/**
	 * Returns the vehicle color of this quotations.
	 *
	 * @return the vehicle color of this quotations
	 */
	@Override
	public String getVehicleColor() {
		return model.getVehicleColor();
	}

	/**
	 * Returns the vehicle current mileage of this quotations.
	 *
	 * @return the vehicle current mileage of this quotations
	 */
	@Override
	public long getVehicleCurrentMileage() {
		return model.getVehicleCurrentMileage();
	}

	/**
	 * Returns the vehicle cylinder of this quotations.
	 *
	 * @return the vehicle cylinder of this quotations
	 */
	@Override
	public long getVehicleCylinder() {
		return model.getVehicleCylinder();
	}

	/**
	 * Returns the vehicle engine size of this quotations.
	 *
	 * @return the vehicle engine size of this quotations
	 */
	@Override
	public String getVehicleEngineSize() {
		return model.getVehicleEngineSize();
	}

	/**
	 * Returns the vehicle est expiry date of this quotations.
	 *
	 * @return the vehicle est expiry date of this quotations
	 */
	@Override
	public Date getVehicleEstExpiryDate() {
		return model.getVehicleEstExpiryDate();
	}

	/**
	 * Returns the vehicle ID of this quotations.
	 *
	 * @return the vehicle ID of this quotations
	 */
	@Override
	public long getVehicleId() {
		return model.getVehicleId();
	}

	/**
	 * Returns the vehicle ID type of this quotations.
	 *
	 * @return the vehicle ID type of this quotations
	 */
	@Override
	public long getVehicleIdType() {
		return model.getVehicleIdType();
	}

	/**
	 * Returns the vehicle lower expected mileage per year of this quotations.
	 *
	 * @return the vehicle lower expected mileage per year of this quotations
	 */
	@Override
	public long getVehicleLowerExpectedMileagePerYear() {
		return model.getVehicleLowerExpectedMileagePerYear();
	}

	/**
	 * Returns the vehicle make of this quotations.
	 *
	 * @return the vehicle make of this quotations
	 */
	@Override
	public String getVehicleMake() {
		return model.getVehicleMake();
	}

	/**
	 * Returns the vehicle mfg year of this quotations.
	 *
	 * @return the vehicle mfg year of this quotations
	 */
	@Override
	public long getVehicleMfgYear() {
		return model.getVehicleMfgYear();
	}

	/**
	 * Returns the vehicle model of this quotations.
	 *
	 * @return the vehicle model of this quotations
	 */
	@Override
	public String getVehicleModel() {
		return model.getVehicleModel();
	}

	/**
	 * Returns the vehicle night location of this quotations.
	 *
	 * @return the vehicle night location of this quotations
	 */
	@Override
	public String getVehicleNightLocation() {
		return model.getVehicleNightLocation();
	}

	/**
	 * Returns the vehicle plate l1 of this quotations.
	 *
	 * @return the vehicle plate l1 of this quotations
	 */
	@Override
	public String getVehiclePlateL1() {
		return model.getVehiclePlateL1();
	}

	/**
	 * Returns the vehicle plate l2 of this quotations.
	 *
	 * @return the vehicle plate l2 of this quotations
	 */
	@Override
	public String getVehiclePlateL2() {
		return model.getVehiclePlateL2();
	}

	/**
	 * Returns the vehicle plate l3 of this quotations.
	 *
	 * @return the vehicle plate l3 of this quotations
	 */
	@Override
	public String getVehiclePlateL3() {
		return model.getVehiclePlateL3();
	}

	/**
	 * Returns the vehicle plate no of this quotations.
	 *
	 * @return the vehicle plate no of this quotations
	 */
	@Override
	public long getVehiclePlateNo() {
		return model.getVehiclePlateNo();
	}

	/**
	 * Returns the vehicle plate type of this quotations.
	 *
	 * @return the vehicle plate type of this quotations
	 */
	@Override
	public String getVehiclePlateType() {
		return model.getVehiclePlateType();
	}

	/**
	 * Returns the vehicle trans type of this quotations.
	 *
	 * @return the vehicle trans type of this quotations
	 */
	@Override
	public String getVehicleTransType() {
		return model.getVehicleTransType();
	}

	/**
	 * Returns the vehicle upper expected mileage per year of this quotations.
	 *
	 * @return the vehicle upper expected mileage per year of this quotations
	 */
	@Override
	public long getVehicleUpperExpectedMileagePerYear() {
		return model.getVehicleUpperExpectedMileagePerYear();
	}

	/**
	 * Returns the vehicle value of this quotations.
	 *
	 * @return the vehicle value of this quotations
	 */
	@Override
	public long getVehicleValue() {
		return model.getVehicleValue();
	}

	/**
	 * Returns the vehicle weight of this quotations.
	 *
	 * @return the vehicle weight of this quotations
	 */
	@Override
	public long getVehicleWeight() {
		return model.getVehicleWeight();
	}

	/**
	 * Returns the veh specs of this quotations.
	 *
	 * @return the veh specs of this quotations
	 */
	@Override
	public String getVehSpecs() {
		return model.getVehSpecs();
	}

	/**
	 * Returns the yakeen ref no of this quotations.
	 *
	 * @return the yakeen ref no of this quotations
	 */
	@Override
	public long getYakeenRefNo() {
		return model.getYakeenRefNo();
	}

	/**
	 * Returns <code>true</code> if this quotations is sms flag.
	 *
	 * @return <code>true</code> if this quotations is sms flag; <code>false</code> otherwise
	 */
	@Override
	public boolean isSmsFlag() {
		return model.isSmsFlag();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the add cover of this quotations.
	 *
	 * @param addCover the add cover of this quotations
	 */
	@Override
	public void setAddCover(String addCover) {
		model.setAddCover(addCover);
	}

	/**
	 * Sets the add driver of this quotations.
	 *
	 * @param addDriver the add driver of this quotations
	 */
	@Override
	public void setAddDriver(String addDriver) {
		model.setAddDriver(addDriver);
	}

	/**
	 * Sets the address add no of this quotations.
	 *
	 * @param addressAddNo the address add no of this quotations
	 */
	@Override
	public void setAddressAddNo(long addressAddNo) {
		model.setAddressAddNo(addressAddNo);
	}

	/**
	 * Sets the address building no of this quotations.
	 *
	 * @param addressBuildingNo the address building no of this quotations
	 */
	@Override
	public void setAddressBuildingNo(long addressBuildingNo) {
		model.setAddressBuildingNo(addressBuildingNo);
	}

	/**
	 * Sets the address district of this quotations.
	 *
	 * @param addressDistrict the address district of this quotations
	 */
	@Override
	public void setAddressDistrict(String addressDistrict) {
		model.setAddressDistrict(addressDistrict);
	}

	/**
	 * Sets the address street of this quotations.
	 *
	 * @param addressStreet the address street of this quotations
	 */
	@Override
	public void setAddressStreet(String addressStreet) {
		model.setAddressStreet(addressStreet);
	}

	/**
	 * Sets the address unit no of this quotations.
	 *
	 * @param addressUnitNo the address unit no of this quotations
	 */
	@Override
	public void setAddressUnitNo(long addressUnitNo) {
		model.setAddressUnitNo(addressUnitNo);
	}

	/**
	 * Sets the address zip code of this quotations.
	 *
	 * @param addressZipCode the address zip code of this quotations
	 */
	@Override
	public void setAddressZipCode(long addressZipCode) {
		model.setAddressZipCode(addressZipCode);
	}

	/**
	 * Sets the agency repair of this quotations.
	 *
	 * @param agencyRepair the agency repair of this quotations
	 */
	@Override
	public void setAgencyRepair(String agencyRepair) {
		model.setAgencyRepair(agencyRepair);
	}

	/**
	 * Sets the agency repair out of this quotations.
	 *
	 * @param agencyRepairOut the agency repair out of this quotations
	 */
	@Override
	public void setAgencyRepairOut(double agencyRepairOut) {
		model.setAgencyRepairOut(agencyRepairOut);
	}

	/**
	 * Sets the city of this quotations.
	 *
	 * @param city the city of this quotations
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the deductible value of this quotations.
	 *
	 * @param deductibleValue the deductible value of this quotations
	 */
	@Override
	public void setDeductibleValue(String deductibleValue) {
		model.setDeductibleValue(deductibleValue);
	}

	/**
	 * Sets the discount amount of this quotations.
	 *
	 * @param discountAmount the discount amount of this quotations
	 */
	@Override
	public void setDiscountAmount(double discountAmount) {
		model.setDiscountAmount(discountAmount);
	}

	/**
	 * Sets the discount prem of this quotations.
	 *
	 * @param discountPrem the discount prem of this quotations
	 */
	@Override
	public void setDiscountPrem(double discountPrem) {
		model.setDiscountPrem(discountPrem);
	}

	/**
	 * Sets the driver accidents of this quotations.
	 *
	 * @param driverAccidents the driver accidents of this quotations
	 */
	@Override
	public void setDriverAccidents(double driverAccidents) {
		model.setDriverAccidents(driverAccidents);
	}

	/**
	 * Sets the driver age less21 of this quotations.
	 *
	 * @param driverAgeLess21 the driver age less21 of this quotations
	 */
	@Override
	public void setDriverAgeLess21(double driverAgeLess21) {
		model.setDriverAgeLess21(driverAgeLess21);
	}

	/**
	 * Sets the existing company name of this quotations.
	 *
	 * @param existingCompanyName the existing company name of this quotations
	 */
	@Override
	public void setExistingCompanyName(String existingCompanyName) {
		model.setExistingCompanyName(existingCompanyName);
	}

	/**
	 * Sets the existing exp date of this quotations.
	 *
	 * @param existingExpDate the existing exp date of this quotations
	 */
	@Override
	public void setExistingExpDate(String existingExpDate) {
		model.setExistingExpDate(existingExpDate);
	}

	/**
	 * Sets the existing policy no of this quotations.
	 *
	 * @param existingPolicyNo the existing policy no of this quotations
	 */
	@Override
	public void setExistingPolicyNo(String existingPolicyNo) {
		model.setExistingPolicyNo(existingPolicyNo);
	}

	/**
	 * Sets the gross prem of this quotations.
	 *
	 * @param grossPrem the gross prem of this quotations
	 */
	@Override
	public void setGrossPrem(double grossPrem) {
		model.setGrossPrem(grossPrem);
	}

	/**
	 * Sets the insured dob of this quotations.
	 *
	 * @param insuredDob the insured dob of this quotations
	 */
	@Override
	public void setInsuredDob(Date insuredDob) {
		model.setInsuredDob(insuredDob);
	}

	/**
	 * Sets the insured dob h of this quotations.
	 *
	 * @param insuredDobH the insured dob h of this quotations
	 */
	@Override
	public void setInsuredDobH(String insuredDobH) {
		model.setInsuredDobH(insuredDobH);
	}

	/**
	 * Sets the insured education of this quotations.
	 *
	 * @param insuredEducation the insured education of this quotations
	 */
	@Override
	public void setInsuredEducation(String insuredEducation) {
		model.setInsuredEducation(insuredEducation);
	}

	/**
	 * Sets the insured email of this quotations.
	 *
	 * @param insuredEmail the insured email of this quotations
	 */
	@Override
	public void setInsuredEmail(String insuredEmail) {
		model.setInsuredEmail(insuredEmail);
	}

	/**
	 * Sets the insured gender of this quotations.
	 *
	 * @param insuredGender the insured gender of this quotations
	 */
	@Override
	public void setInsuredGender(String insuredGender) {
		model.setInsuredGender(insuredGender);
	}

	/**
	 * Sets the insured iban of this quotations.
	 *
	 * @param insuredIBAN the insured iban of this quotations
	 */
	@Override
	public void setInsuredIBAN(String insuredIBAN) {
		model.setInsuredIBAN(insuredIBAN);
	}

	/**
	 * Sets the insured ID of this quotations.
	 *
	 * @param insuredId the insured ID of this quotations
	 */
	@Override
	public void setInsuredId(long insuredId) {
		model.setInsuredId(insuredId);
	}

	/**
	 * Sets the insured ID type of this quotations.
	 *
	 * @param insuredIdType the insured ID type of this quotations
	 */
	@Override
	public void setInsuredIdType(long insuredIdType) {
		model.setInsuredIdType(insuredIdType);
	}

	/**
	 * Sets the insured marital status of this quotations.
	 *
	 * @param insuredMaritalStatus the insured marital status of this quotations
	 */
	@Override
	public void setInsuredMaritalStatus(String insuredMaritalStatus) {
		model.setInsuredMaritalStatus(insuredMaritalStatus);
	}

	/**
	 * Sets the insured mobile of this quotations.
	 *
	 * @param insuredMobile the insured mobile of this quotations
	 */
	@Override
	public void setInsuredMobile(long insuredMobile) {
		model.setInsuredMobile(insuredMobile);
	}

	/**
	 * Sets the insured name of this quotations.
	 *
	 * @param insuredName the insured name of this quotations
	 */
	@Override
	public void setInsuredName(String insuredName) {
		model.setInsuredName(insuredName);
	}

	/**
	 * Sets the insured nationality of this quotations.
	 *
	 * @param insuredNationality the insured nationality of this quotations
	 */
	@Override
	public void setInsuredNationality(String insuredNationality) {
		model.setInsuredNationality(insuredNationality);
	}

	/**
	 * Sets the insured no child under16 of this quotations.
	 *
	 * @param insuredNoChildUnder16 the insured no child under16 of this quotations
	 */
	@Override
	public void setInsuredNoChildUnder16(long insuredNoChildUnder16) {
		model.setInsuredNoChildUnder16(insuredNoChildUnder16);
	}

	/**
	 * Sets the loading amount of this quotations.
	 *
	 * @param loadingAmount the loading amount of this quotations
	 */
	@Override
	public void setLoadingAmount(double loadingAmount) {
		model.setLoadingAmount(loadingAmount);
	}

	/**
	 * Sets the loyalty discount of this quotations.
	 *
	 * @param loyaltyDiscount the loyalty discount of this quotations
	 */
	@Override
	public void setLoyaltyDiscount(String loyaltyDiscount) {
		model.setLoyaltyDiscount(loyaltyDiscount);
	}

	/**
	 * Sets the loyalty discount amount of this quotations.
	 *
	 * @param loyaltyDiscountAmount the loyalty discount amount of this quotations
	 */
	@Override
	public void setLoyaltyDiscountAmount(double loyaltyDiscountAmount) {
		model.setLoyaltyDiscountAmount(loyaltyDiscountAmount);
	}

	/**
	 * Sets the loyalty discount per of this quotations.
	 *
	 * @param loyaltyDiscountPer the loyalty discount per of this quotations
	 */
	@Override
	public void setLoyaltyDiscountPer(double loyaltyDiscountPer) {
		model.setLoyaltyDiscountPer(loyaltyDiscountPer);
	}

	/**
	 * Sets the ncd years of this quotations.
	 *
	 * @param ncdYears the ncd years of this quotations
	 */
	@Override
	public void setNcdYears(long ncdYears) {
		model.setNcdYears(ncdYears);
	}

	/**
	 * Sets the net prem of this quotations.
	 *
	 * @param netPrem the net prem of this quotations
	 */
	@Override
	public void setNetPrem(double netPrem) {
		model.setNetPrem(netPrem);
	}

	/**
	 * Sets the occ code of this quotations.
	 *
	 * @param occCode the occ code of this quotations
	 */
	@Override
	public void setOccCode(String occCode) {
		model.setOccCode(occCode);
	}

	/**
	 * Sets the paymemt amount of this quotations.
	 *
	 * @param paymemtAmount the paymemt amount of this quotations
	 */
	@Override
	public void setPaymemtAmount(long paymemtAmount) {
		model.setPaymemtAmount(paymemtAmount);
	}

	/**
	 * Sets the payment method of this quotations.
	 *
	 * @param paymentMethod the payment method of this quotations
	 */
	@Override
	public void setPaymentMethod(String paymentMethod) {
		model.setPaymentMethod(paymentMethod);
	}

	/**
	 * Sets the payment ref no of this quotations.
	 *
	 * @param paymentRefNo the payment ref no of this quotations
	 */
	@Override
	public void setPaymentRefNo(String paymentRefNo) {
		model.setPaymentRefNo(paymentRefNo);
	}

	/**
	 * Sets the policy eff date of this quotations.
	 *
	 * @param policyEffDate the policy eff date of this quotations
	 */
	@Override
	public void setPolicyEffDate(Date policyEffDate) {
		model.setPolicyEffDate(policyEffDate);
	}

	/**
	 * Sets the policy eff from no of this quotations.
	 *
	 * @param policyEffFromNo the policy eff from no of this quotations
	 */
	@Override
	public void setPolicyEffFromNo(Date policyEffFromNo) {
		model.setPolicyEffFromNo(policyEffFromNo);
	}

	/**
	 * Sets the policy eff to of this quotations.
	 *
	 * @param policyEffTo the policy eff to of this quotations
	 */
	@Override
	public void setPolicyEffTo(Date policyEffTo) {
		model.setPolicyEffTo(policyEffTo);
	}

	/**
	 * Sets the policy fees of this quotations.
	 *
	 * @param policyFees the policy fees of this quotations
	 */
	@Override
	public void setPolicyFees(double policyFees) {
		model.setPolicyFees(policyFees);
	}

	/**
	 * Sets the policy issue date of this quotations.
	 *
	 * @param policyIssueDate the policy issue date of this quotations
	 */
	@Override
	public void setPolicyIssueDate(Date policyIssueDate) {
		model.setPolicyIssueDate(policyIssueDate);
	}

	/**
	 * Sets the policy no of this quotations.
	 *
	 * @param policyNo the policy no of this quotations
	 */
	@Override
	public void setPolicyNo(String policyNo) {
		model.setPolicyNo(policyNo);
	}

	/**
	 * Sets the policy ref no of this quotations.
	 *
	 * @param policyRefNo the policy ref no of this quotations
	 */
	@Override
	public void setPolicyRefNo(String policyRefNo) {
		model.setPolicyRefNo(policyRefNo);
	}

	/**
	 * Sets the policy status code of this quotations.
	 *
	 * @param policyStatusCode the policy status code of this quotations
	 */
	@Override
	public void setPolicyStatusCode(String policyStatusCode) {
		model.setPolicyStatusCode(policyStatusCode);
	}

	/**
	 * Sets the policy status msg of this quotations.
	 *
	 * @param policyStatusMsg the policy status msg of this quotations
	 */
	@Override
	public void setPolicyStatusMsg(String policyStatusMsg) {
		model.setPolicyStatusMsg(policyStatusMsg);
	}

	/**
	 * Sets the policy taxes of this quotations.
	 *
	 * @param policyTaxes the policy taxes of this quotations
	 */
	@Override
	public void setPolicyTaxes(double policyTaxes) {
		model.setPolicyTaxes(policyTaxes);
	}

	/**
	 * Sets the primary key of this quotations.
	 *
	 * @param primaryKey the primary key of this quotations
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product code of this quotations.
	 *
	 * @param productCode the product code of this quotations
	 */
	@Override
	public void setProductCode(String productCode) {
		model.setProductCode(productCode);
	}

	/**
	 * Sets the purpose of vehicle of this quotations.
	 *
	 * @param purposeOfVehicle the purpose of vehicle of this quotations
	 */
	@Override
	public void setPurposeOfVehicle(String purposeOfVehicle) {
		model.setPurposeOfVehicle(purposeOfVehicle);
	}

	/**
	 * Sets the quotation ID of this quotations.
	 *
	 * @param quotationId the quotation ID of this quotations
	 */
	@Override
	public void setQuotationId(long quotationId) {
		model.setQuotationId(quotationId);
	}

	/**
	 * Sets the quote status of this quotations.
	 *
	 * @param quoteStatus the quote status of this quotations
	 */
	@Override
	public void setQuoteStatus(String quoteStatus) {
		model.setQuoteStatus(quoteStatus);
	}

	/**
	 * Sets the quote submission date of this quotations.
	 *
	 * @param quoteSubmissionDate the quote submission date of this quotations
	 */
	@Override
	public void setQuoteSubmissionDate(Date quoteSubmissionDate) {
		model.setQuoteSubmissionDate(quoteSubmissionDate);
	}

	/**
	 * Sets the reference no of this quotations.
	 *
	 * @param referenceNo the reference no of this quotations
	 */
	@Override
	public void setReferenceNo(String referenceNo) {
		model.setReferenceNo(referenceNo);
	}

	/**
	 * Sets the saeed service of this quotations.
	 *
	 * @param saeedService the saeed service of this quotations
	 */
	@Override
	public void setSaeedService(String saeedService) {
		model.setSaeedService(saeedService);
	}

	/**
	 * Sets whether this quotations is sms flag.
	 *
	 * @param smsFlag the sms flag of this quotations
	 */
	@Override
	public void setSmsFlag(boolean smsFlag) {
		model.setSmsFlag(smsFlag);
	}

	/**
	 * Sets the source of this quotations.
	 *
	 * @param source the source of this quotations
	 */
	@Override
	public void setSource(String source) {
		model.setSource(source);
	}

	/**
	 * Sets the total after discount of this quotations.
	 *
	 * @param totalAfterDiscount the total after discount of this quotations
	 */
	@Override
	public void setTotalAfterDiscount(double totalAfterDiscount) {
		model.setTotalAfterDiscount(totalAfterDiscount);
	}

	/**
	 * Sets the total before disc of this quotations.
	 *
	 * @param totalBeforeDisc the total before disc of this quotations
	 */
	@Override
	public void setTotalBeforeDisc(double totalBeforeDisc) {
		model.setTotalBeforeDisc(totalBeforeDisc);
	}

	/**
	 * Sets the total cover prem of this quotations.
	 *
	 * @param totalCoverPrem the total cover prem of this quotations
	 */
	@Override
	public void setTotalCoverPrem(double totalCoverPrem) {
		model.setTotalCoverPrem(totalCoverPrem);
	}

	/**
	 * Sets the transaction of this quotations.
	 *
	 * @param transaction the transaction of this quotations
	 */
	@Override
	public void setTransaction(String transaction) {
		model.setTransaction(transaction);
	}

	/**
	 * Sets the veh axle weight of this quotations.
	 *
	 * @param vehAxleWeight the veh axle weight of this quotations
	 */
	@Override
	public void setVehAxleWeight(long vehAxleWeight) {
		model.setVehAxleWeight(vehAxleWeight);
	}

	/**
	 * Sets the veh car mods of this quotations.
	 *
	 * @param vehCarMods the veh car mods of this quotations
	 */
	@Override
	public void setVehCarMods(String vehCarMods) {
		model.setVehCarMods(vehCarMods);
	}

	/**
	 * Sets the vehicle body type of this quotations.
	 *
	 * @param vehicleBodyType the vehicle body type of this quotations
	 */
	@Override
	public void setVehicleBodyType(String vehicleBodyType) {
		model.setVehicleBodyType(vehicleBodyType);
	}

	/**
	 * Sets the vehicle capacity of this quotations.
	 *
	 * @param vehicleCapacity the vehicle capacity of this quotations
	 */
	@Override
	public void setVehicleCapacity(long vehicleCapacity) {
		model.setVehicleCapacity(vehicleCapacity);
	}

	/**
	 * Sets the vehicle chassis no of this quotations.
	 *
	 * @param vehicleChassisNo the vehicle chassis no of this quotations
	 */
	@Override
	public void setVehicleChassisNo(String vehicleChassisNo) {
		model.setVehicleChassisNo(vehicleChassisNo);
	}

	/**
	 * Sets the vehicle city of this quotations.
	 *
	 * @param vehicleCity the vehicle city of this quotations
	 */
	@Override
	public void setVehicleCity(String vehicleCity) {
		model.setVehicleCity(vehicleCity);
	}

	/**
	 * Sets the vehicle color of this quotations.
	 *
	 * @param vehicleColor the vehicle color of this quotations
	 */
	@Override
	public void setVehicleColor(String vehicleColor) {
		model.setVehicleColor(vehicleColor);
	}

	/**
	 * Sets the vehicle current mileage of this quotations.
	 *
	 * @param vehicleCurrentMileage the vehicle current mileage of this quotations
	 */
	@Override
	public void setVehicleCurrentMileage(long vehicleCurrentMileage) {
		model.setVehicleCurrentMileage(vehicleCurrentMileage);
	}

	/**
	 * Sets the vehicle cylinder of this quotations.
	 *
	 * @param vehicleCylinder the vehicle cylinder of this quotations
	 */
	@Override
	public void setVehicleCylinder(long vehicleCylinder) {
		model.setVehicleCylinder(vehicleCylinder);
	}

	/**
	 * Sets the vehicle engine size of this quotations.
	 *
	 * @param vehicleEngineSize the vehicle engine size of this quotations
	 */
	@Override
	public void setVehicleEngineSize(String vehicleEngineSize) {
		model.setVehicleEngineSize(vehicleEngineSize);
	}

	/**
	 * Sets the vehicle est expiry date of this quotations.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date of this quotations
	 */
	@Override
	public void setVehicleEstExpiryDate(Date vehicleEstExpiryDate) {
		model.setVehicleEstExpiryDate(vehicleEstExpiryDate);
	}

	/**
	 * Sets the vehicle ID of this quotations.
	 *
	 * @param vehicleId the vehicle ID of this quotations
	 */
	@Override
	public void setVehicleId(long vehicleId) {
		model.setVehicleId(vehicleId);
	}

	/**
	 * Sets the vehicle ID type of this quotations.
	 *
	 * @param vehicleIdType the vehicle ID type of this quotations
	 */
	@Override
	public void setVehicleIdType(long vehicleIdType) {
		model.setVehicleIdType(vehicleIdType);
	}

	/**
	 * Sets the vehicle lower expected mileage per year of this quotations.
	 *
	 * @param vehicleLowerExpectedMileagePerYear the vehicle lower expected mileage per year of this quotations
	 */
	@Override
	public void setVehicleLowerExpectedMileagePerYear(
		long vehicleLowerExpectedMileagePerYear) {

		model.setVehicleLowerExpectedMileagePerYear(
			vehicleLowerExpectedMileagePerYear);
	}

	/**
	 * Sets the vehicle make of this quotations.
	 *
	 * @param vehicleMake the vehicle make of this quotations
	 */
	@Override
	public void setVehicleMake(String vehicleMake) {
		model.setVehicleMake(vehicleMake);
	}

	/**
	 * Sets the vehicle mfg year of this quotations.
	 *
	 * @param vehicleMfgYear the vehicle mfg year of this quotations
	 */
	@Override
	public void setVehicleMfgYear(long vehicleMfgYear) {
		model.setVehicleMfgYear(vehicleMfgYear);
	}

	/**
	 * Sets the vehicle model of this quotations.
	 *
	 * @param vehicleModel the vehicle model of this quotations
	 */
	@Override
	public void setVehicleModel(String vehicleModel) {
		model.setVehicleModel(vehicleModel);
	}

	/**
	 * Sets the vehicle night location of this quotations.
	 *
	 * @param vehicleNightLocation the vehicle night location of this quotations
	 */
	@Override
	public void setVehicleNightLocation(String vehicleNightLocation) {
		model.setVehicleNightLocation(vehicleNightLocation);
	}

	/**
	 * Sets the vehicle plate l1 of this quotations.
	 *
	 * @param vehiclePlateL1 the vehicle plate l1 of this quotations
	 */
	@Override
	public void setVehiclePlateL1(String vehiclePlateL1) {
		model.setVehiclePlateL1(vehiclePlateL1);
	}

	/**
	 * Sets the vehicle plate l2 of this quotations.
	 *
	 * @param vehiclePlateL2 the vehicle plate l2 of this quotations
	 */
	@Override
	public void setVehiclePlateL2(String vehiclePlateL2) {
		model.setVehiclePlateL2(vehiclePlateL2);
	}

	/**
	 * Sets the vehicle plate l3 of this quotations.
	 *
	 * @param vehiclePlateL3 the vehicle plate l3 of this quotations
	 */
	@Override
	public void setVehiclePlateL3(String vehiclePlateL3) {
		model.setVehiclePlateL3(vehiclePlateL3);
	}

	/**
	 * Sets the vehicle plate no of this quotations.
	 *
	 * @param vehiclePlateNo the vehicle plate no of this quotations
	 */
	@Override
	public void setVehiclePlateNo(long vehiclePlateNo) {
		model.setVehiclePlateNo(vehiclePlateNo);
	}

	/**
	 * Sets the vehicle plate type of this quotations.
	 *
	 * @param vehiclePlateType the vehicle plate type of this quotations
	 */
	@Override
	public void setVehiclePlateType(String vehiclePlateType) {
		model.setVehiclePlateType(vehiclePlateType);
	}

	/**
	 * Sets the vehicle trans type of this quotations.
	 *
	 * @param vehicleTransType the vehicle trans type of this quotations
	 */
	@Override
	public void setVehicleTransType(String vehicleTransType) {
		model.setVehicleTransType(vehicleTransType);
	}

	/**
	 * Sets the vehicle upper expected mileage per year of this quotations.
	 *
	 * @param vehicleUpperExpectedMileagePerYear the vehicle upper expected mileage per year of this quotations
	 */
	@Override
	public void setVehicleUpperExpectedMileagePerYear(
		long vehicleUpperExpectedMileagePerYear) {

		model.setVehicleUpperExpectedMileagePerYear(
			vehicleUpperExpectedMileagePerYear);
	}

	/**
	 * Sets the vehicle value of this quotations.
	 *
	 * @param vehicleValue the vehicle value of this quotations
	 */
	@Override
	public void setVehicleValue(long vehicleValue) {
		model.setVehicleValue(vehicleValue);
	}

	/**
	 * Sets the vehicle weight of this quotations.
	 *
	 * @param vehicleWeight the vehicle weight of this quotations
	 */
	@Override
	public void setVehicleWeight(long vehicleWeight) {
		model.setVehicleWeight(vehicleWeight);
	}

	/**
	 * Sets the veh specs of this quotations.
	 *
	 * @param vehSpecs the veh specs of this quotations
	 */
	@Override
	public void setVehSpecs(String vehSpecs) {
		model.setVehSpecs(vehSpecs);
	}

	/**
	 * Sets the yakeen ref no of this quotations.
	 *
	 * @param yakeenRefNo the yakeen ref no of this quotations
	 */
	@Override
	public void setYakeenRefNo(long yakeenRefNo) {
		model.setYakeenRefNo(yakeenRefNo);
	}

	@Override
	protected QuotationsWrapper wrap(Quotations quotations) {
		return new QuotationsWrapper(quotations);
	}

}