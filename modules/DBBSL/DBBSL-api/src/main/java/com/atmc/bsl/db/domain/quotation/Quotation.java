/*
 * Quotation.java Jan 21, 2018  
 *
 * Copyright (c) 2005-2012 Ejada Solutions.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Ejada
 * Solutions, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Ejada.
 */
package com.atmc.bsl.db.domain.quotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ghada Shawkat
 */
public class Quotation {
	private boolean accDeath;

	private boolean vehMotorAcc;

	private boolean convTraffViols;

	private long addressAddNo;

	private long addressBuildingNo;

	private String addressDistrict;

	private String addressStreet;

	private long addressUnitNo;

	private long addressZipCode;

	private String addCover;

	private String addDriver;

	private String agencyRepair;

	private double agencyRepairOut;

	private double driverAgeLess21;

	private String city;

	private String cityDesc;

	private String deductibleValue;

	private Date insuredDob;

	private String insuredDobH;

	private String insuredEmail;

	private String insuredGender;

	private long insuredId;

	private long insuredIdType;

	private String insuredMobile;

	private String insuredName;

	private String insuredNationality;

	private String insuredOccupationCode;

	private String loyaltyDiscount;

	private long ncdYears;

	private long paymemtAmount;

	private String paymentMethod;

	private String paymentRefNo;

	private Date policyEffFromNo;

	private Date policyEffTo;

	private Date policyEffDate;

	private Date policyIssueDate;

	private String policyNo;

	private String policyRefNo;

	private String policyStatusCode;

	private String productCode;

	private String purposeOfVehicle;

	private String purposeOfVehicleDesc;

	private long quotationId;

	private String referenceNo;

	private String source;

	private String transaction;

	private String vehicleBodyType;

	private String vehicleBodyTypeEn;

	private String vehicleBodyTypeAr;

	private long vehicleCapacity;

	private String vehicleChassisNo;

	private String vehicleColor;

	private String vehicleColorEn;

	private String vehicleColorAr;

	private long vehicleCylinder;

	private Date vehicleEstExpiryDate;

	private long vehicleId;

	private long vehicleIdType;

	private String vehicleMake;

	private String vehicleMakeEn;

	private String vehicleMakeAr;

	private long vehicleMfgYear;

	private String vehicleModel;

	private String vehicleModelEn;

	private String vehicleModelAr;

	private String vehiclePlateL1;

	private String vehiclePlateL2;

	private String vehiclePlateL3;

	private long vehiclePlateNo;

	private String vehiclePlateType;

	private String vehiclePlateTypeDesc;

	private long vehicleValue;

	private long vehicleWeight;

	private String vehicleCity;

	private List<QuotationCover> coversList;

	private List<QuotationDriver> quotationDrivers;

	private List<QuotationDriver> under21Drivers;

	private String licenseFileName;

	private String idFileName;

	private String carRightFileName;

	private String istCardFileName;

	private String custCardFileName;

	private String carFrontFileName;

	private String carBackFileName;

	private String carLeftFileName;

	private String engChassisNoFileName;

	private String leaseFileName;

	private String productDescEn;

	private String productDescAr;

	private String vehicleIdDescEn;

	private String vehicleIdDescAr;

	private List<QuotationAdminUpload> adminFilesUplods;
	// private QuotationCustUploads custFilesUplods;

	private List<QuotationHistory> quotationHistory;

	private String existingPolicyNo;

	private String existingCompanyName;

	private String existingExpDate;

	private double netPrem;

	private double claimLoading;

	private double discountAmount;

	private double discountPrem;

	private double loyaltyDiscountPer;

	private int loyaltyDiscountFlag;

	private double loadingAmount;

	private double policyTaxes;

	private double policyFees;

	private double totalCoverPrem;

	private double grossPrem;

	private String policyStatusMsg;

	private long yakeenRefNo;

	private Date quoteSubmissionDate;

	private String quoteStatus;

	private String olpEstn;

	private boolean isMainDriver;

	private String oldIqamaId;

	private String vehicleOwnerIban;

	private String vehicleNationality;

	private String driverAdditionReason;

	private boolean underAgeDriver;

	private String saeedService;

	private double driverAccidents;

	private double totalAfterDiscount;

	private double totalBeforeDiscount;

	private boolean smsFlag;

	private boolean renew;

	private String insuredEducation;

	private String insuredMaritalStatus;

	private int insuredNoChildUnder16;

	private long vehicleCurrentMileage;

	private long vehicleLowerExpectedMileagePerYear;

	private long vehicleUpperExpectedMileagePerYear;

	private String vehicleNightLocation;

	private String vehicleEngineSize;

	private String vehicleTransType;

	private String vehicleSpecs;

	private long vehAxleWeight;

	private String vehCarMods;

	private QuotationUserAddress natAddress;

	private QuotationUserAddress offAddress;

	private boolean productChanged;

	private String schemeCode;

	/**
	 * @return the addressAddNo
	 */
	public double getClaimLoading() {
		return claimLoading;
	}

	public void setClaimLoading(double claimLoading) {
		this.claimLoading = claimLoading;
	}

	public long getAddressAddNo() {
		return addressAddNo;
	}

	/**
	 * @param addressAddNo the addressAddNo to set
	 */
	public void setAddressAddNo(long addressAddNo) {
		this.addressAddNo = addressAddNo;
	}

	/**
	 * @return the addressBuildingNo
	 */
	public long getAddressBuildingNo() {
		return addressBuildingNo;
	}

	/**
	 * @param addressBuildingNo the addressBuildingNo to set
	 */
	public void setAddressBuildingNo(long addressBuildingNo) {
		this.addressBuildingNo = addressBuildingNo;
	}

	/**
	 * @return the addressDistrict
	 */
	public String getAddressDistrict() {
		return addressDistrict;
	}

	/**
	 * @param addressDistrict the addressDistrict to set
	 */
	public void setAddressDistrict(String addressDistrict) {
		this.addressDistrict = addressDistrict;
	}

	/**
	 * @return the addressStreet
	 */
	public String getAddressStreet() {
		return addressStreet;
	}

	/**
	 * @param addressStreet the addressStreet to set
	 */
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	/**
	 * @return the addressUnitNo
	 */
	public long getAddressUnitNo() {
		return addressUnitNo;
	}

	/**
	 * @param addressUnitNo the addressUnitNo to set
	 */
	public void setAddressUnitNo(long addressUnitNo) {
		this.addressUnitNo = addressUnitNo;
	}

	/**
	 * @return the addressZipCode
	 */
	public long getAddressZipCode() {
		return addressZipCode;
	}

	/**
	 * @param addressZipCode the addressZipCode to set
	 */
	public void setAddressZipCode(long addressZipCode) {
		this.addressZipCode = addressZipCode;
	}

	/**
	 * @return the addCover
	 */
	public String getAddCover() {
		return addCover;
	}

	/**
	 * @param addCover the addCover to set
	 */
	public void setAddCover(String addCover) {
		this.addCover = addCover;
	}

	/**
	 * @return the addDriver
	 */
	public String getAddDriver() {
		return addDriver;
	}

	/**
	 * @param addDriver the addDriver to set
	 */
	public void setAddDriver(String addDriver) {
		this.addDriver = addDriver;
	}

	/**
	 * @return the agencyRepair
	 */
	public String getAgencyRepair() {
		return agencyRepair;
	}

	/**
	 * @param agencyRepair the agencyRepair to set
	 */
	public void setAgencyRepair(String agencyRepair) {
		this.agencyRepair = agencyRepair;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the deductibleValue
	 */
	public String getDeductibleValue() {
		return deductibleValue;
	}

	/**
	 * @param deductibleValue the deductibleValue to set
	 */
	public void setDeductibleValue(String deductibleValue) {
		this.deductibleValue = deductibleValue;
	}

	/**
	 * @return the insuredDob
	 */
	public Date getInsuredDob() {
		return insuredDob;
	}

	/**
	 * @param insuredDob the insuredDob to set
	 */
	public void setInsuredDob(Date insuredDob) {
		this.insuredDob = insuredDob;
	}

	/**
	 * @return the insuredEmail
	 */
	public String getInsuredEmail() {
		return insuredEmail;
	}

	/**
	 * @param insuredEmail the insuredEmail to set
	 */
	public void setInsuredEmail(String insuredEmail) {
		this.insuredEmail = insuredEmail;
	}

	/**
	 * @return the insuredGender
	 */
	public String getInsuredGender() {
		return insuredGender;
	}

	/**
	 * @param insuredGender the insuredGender to set
	 */
	public void setInsuredGender(String insuredGender) {
		this.insuredGender = insuredGender;
	}

	/**
	 * @return the insuredId
	 */
	public long getInsuredId() {
		return insuredId;
	}

	/**
	 * @param insuredId the insuredId to set
	 */
	public void setInsuredId(long insuredId) {
		this.insuredId = insuredId;
	}

	/**
	 * @return the insuredIdType
	 */
	public long getInsuredIdType() {
		return insuredIdType;
	}

	/**
	 * @param insuredIdType the insuredIdType to set
	 */
	public void setInsuredIdType(long insuredIdType) {
		this.insuredIdType = insuredIdType;
	}

	/**
	 * @return the insuredMobile
	 */
	public String getInsuredMobile() {
		return insuredMobile;
	}

	/**
	 * @param insuredMobile the insuredMobile to set
	 */
	public void setInsuredMobile(String insuredMobile) {
		this.insuredMobile = insuredMobile;
	}

	/**
	 * @return the insuredName
	 */
	public String getInsuredName() {
		return insuredName;
	}

	/**
	 * @param insuredName the insuredName to set
	 */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	/**
	 * @return the insuredNationality
	 */
	public String getInsuredNationality() {
		return insuredNationality;
	}

	/**
	 * @param insuredNationality the insuredNationality to set
	 */
	public void setInsuredNationality(String insuredNationality) {
		this.insuredNationality = insuredNationality;
	}

	/**
	 * @return the loyaltyDiscount
	 */
	public String getLoyaltyDiscount() {
		return loyaltyDiscount;
	}

	/**
	 * @param loyaltyDiscount the loyaltyDiscount to set
	 */
	public void setLoyaltyDiscount(String loyaltyDiscount) {
		this.loyaltyDiscount = loyaltyDiscount;
	}

	/**
	 * @return the ncdYears
	 */
	public long getNcdYears() {
		return ncdYears;
	}

	/**
	 * @param ncdYears the ncdYears to set
	 */
	public void setNcdYears(long ncdYears) {
		this.ncdYears = ncdYears;
	}

	/**
	 * @return the paymemtAmount
	 */
	public long getPaymemtAmount() {
		return paymemtAmount;
	}

	/**
	 * @param paymemtAmount the paymemtAmount to set
	 */
	public void setPaymemtAmount(long paymemtAmount) {
		this.paymemtAmount = paymemtAmount;
	}

	/**
	 * @return the paymentMethod
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * @return the paymentRefNo
	 */
	public String getPaymentRefNo() {
		return paymentRefNo;
	}

	/**
	 * @param paymentRefNo the paymentRefNo to set
	 */
	public void setPaymentRefNo(String paymentRefNo) {
		this.paymentRefNo = paymentRefNo;
	}

	/**
	 * @return the policyEffFromNo
	 */
	public Date getPolicyEffFromNo() {
		return policyEffFromNo;
	}

	/**
	 * @param policyEffFromNo the policyEffFromNo to set
	 */
	public void setPolicyEffFromNo(Date policyEffFromNo) {
		this.policyEffFromNo = policyEffFromNo;
	}

	/**
	 * @return the policyEffTo
	 */
	public Date getPolicyEffTo() {
		return policyEffTo;
	}

	/**
	 * @param policyEffTo the policyEffTo to set
	 */
	public void setPolicyEffTo(Date policyEffTo) {
		this.policyEffTo = policyEffTo;
	}

	/**
	 * @return the policyEffDate
	 */
	public Date getPolicyEffDate() {
		return policyEffDate;
	}

	/**
	 * @param policyEffDate the policyEffDate to set
	 */
	public void setPolicyEffDate(Date policyEffDate) {
		this.policyEffDate = policyEffDate;
	}

	/**
	 * @return the policyIssueDate
	 */
	public Date getPolicyIssueDate() {
		return policyIssueDate;
	}

	/**
	 * @param policyIssueDate the policyIssueDate to set
	 */
	public void setPolicyIssueDate(Date policyIssueDate) {
		this.policyIssueDate = policyIssueDate;
	}

	/**
	 * @return the policyNo
	 */
	public String getPolicyNo() {
		return policyNo;
	}

	/**
	 * @param policyNo the policyNo to set
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	/**
	 * @return the policyRefNo
	 */
	public String getPolicyRefNo() {
		return policyRefNo;
	}

	/**
	 * @param policyRefNo the policyRefNo to set
	 */
	public void setPolicyRefNo(String policyRefNo) {
		this.policyRefNo = policyRefNo;
	}

	/**
	 * @return the policyStatusCode
	 */
	public String getPolicyStatusCode() {
		return policyStatusCode;
	}

	/**
	 * @param policyStatusCode the policyStatusCode to set
	 */
	public void setPolicyStatusCode(String policyStatusCode) {
		this.policyStatusCode = policyStatusCode;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the purposeOfVehicle
	 */
	public String getPurposeOfVehicle() {
		return purposeOfVehicle;
	}

	/**
	 * @param purposeOfVehicle the purposeOfVehicle to set
	 */
	public void setPurposeOfVehicle(String purposeOfVehicle) {
		this.purposeOfVehicle = purposeOfVehicle;
	}

	/**
	 * @return the quotationId
	 */
	public long getQuotationId() {
		return quotationId;
	}

	/**
	 * @param quotationId the quotationId to set
	 */
	public void setQuotationId(long quotationId) {
		this.quotationId = quotationId;
	}

	/**
	 * @return the referenceNo
	 */
	public String getReferenceNo() {
		return referenceNo;
	}

	/**
	 * @param referenceNo the referenceNo to set
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the transaction
	 */
	public String getTransaction() {
		return transaction;
	}

	/**
	 * @param transaction the transaction to set
	 */
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	/**
	 * @return the vehicleBodyType
	 */
	public String getVehicleBodyType() {
		return vehicleBodyType;
	}

	/**
	 * @param vehicleBodyType the vehicleBodyType to set
	 */
	public void setVehicleBodyType(String vehicleBodyType) {
		this.vehicleBodyType = vehicleBodyType;
	}

	/**
	 * @return the vehicleCapacity
	 */
	public long getVehicleCapacity() {
		return vehicleCapacity;
	}

	/**
	 * @param vehicleCapacity the vehicleCapacity to set
	 */
	public void setVehicleCapacity(long vehicleCapacity) {
		this.vehicleCapacity = vehicleCapacity;
	}

	/**
	 * @return the vehicleChassisNo
	 */
	public String getVehicleChassisNo() {
		return vehicleChassisNo;
	}

	/**
	 * @param vehicleChassisNo the vehicleChassisNo to set
	 */
	public void setVehicleChassisNo(String vehicleChassisNo) {
		this.vehicleChassisNo = vehicleChassisNo;
	}

	/**
	 * @return the veicleColor
	 */
	public String getVehicleColor() {
		return vehicleColor;
	}

	/**
	 * @param veicleColor the veicleColor to set
	 */
	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	/**
	 * @return the vehicleCylinder
	 */
	public long getVehicleCylinder() {
		return vehicleCylinder;
	}

	/**
	 * @param vehicleCylinder the vehicleCylinder to set
	 */
	public void setVehicleCylinder(long vehicleCylinder) {
		this.vehicleCylinder = vehicleCylinder;
	}

	/**
	 * @return the vehicleEstExpiryDate
	 */
	public Date getVehicleEstExpiryDate() {
		return vehicleEstExpiryDate;
	}

	/**
	 * @param vehicleEstExpiryDate the vehicleEstExpiryDate to set
	 */
	public void setVehicleEstExpiryDate(Date vehicleEstExpiryDate) {
		this.vehicleEstExpiryDate = vehicleEstExpiryDate;
	}

	/**
	 * @return the vehicleId
	 */
	public long getVehicleId() {
		return vehicleId;
	}

	/**
	 * @param vehicleId the vehicleId to set
	 */
	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	/**
	 * @return the vehicleIdType
	 */
	public long getVehicleIdType() {
		return vehicleIdType;
	}

	/**
	 * @param vehicleIdType the vehicleIdType to set
	 */
	public void setVehicleIdType(long vehicleIdType) {
		this.vehicleIdType = vehicleIdType;
	}

	/**
	 * @return the vehicleMake
	 */
	public String getVehicleMake() {
		return vehicleMake;
	}

	/**
	 * @param vehicleMake the vehicleMake to set
	 */
	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	/**
	 * @return the vehicleMfgYear
	 */
	public long getVehicleMfgYear() {
		return vehicleMfgYear;
	}

	/**
	 * @param vehicleMfgYear the vehicleMfgYear to set
	 */
	public void setVehicleMfgYear(long vehicleMfgYear) {
		this.vehicleMfgYear = vehicleMfgYear;
	}

	/**
	 * @return the vehicleModel
	 */
	public String getVehicleModel() {
		return vehicleModel;
	}

	/**
	 * @param vehicleModel the vehicleModel to set
	 */
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	/**
	 * @return the vehiclePlateL1
	 */
	public String getVehiclePlateL1() {
		return vehiclePlateL1;
	}

	/**
	 * @param vehiclePlateL1 the vehiclePlateL1 to set
	 */
	public void setVehiclePlateL1(String vehiclePlateL1) {
		this.vehiclePlateL1 = vehiclePlateL1;
	}

	/**
	 * @return the vehiclePlateL2
	 */
	public String getVehiclePlateL2() {
		return vehiclePlateL2;
	}

	/**
	 * @param vehiclePlateL2 the vehiclePlateL2 to set
	 */
	public void setVehiclePlateL2(String vehiclePlateL2) {
		this.vehiclePlateL2 = vehiclePlateL2;
	}

	/**
	 * @return the vehiclePlateL3
	 */
	public String getVehiclePlateL3() {
		return vehiclePlateL3;
	}

	/**
	 * @param vehiclePlateL3 the vehiclePlateL3 to set
	 */
	public void setVehiclePlateL3(String vehiclePlateL3) {
		this.vehiclePlateL3 = vehiclePlateL3;
	}

	/**
	 * @return the vehiclePlateNo
	 */
	public long getVehiclePlateNo() {
		return vehiclePlateNo;
	}

	/**
	 * @param vehiclePlateNo the vehiclePlateNo to set
	 */
	public void setVehiclePlateNo(long vehiclePlateNo) {
		this.vehiclePlateNo = vehiclePlateNo;
	}

	/**
	 * @return the vehiclePlateType
	 */
	public String getVehiclePlateType() {
		return vehiclePlateType;
	}

	/**
	 * @param vehiclePlateType the vehiclePlateType to set
	 */
	public void setVehiclePlateType(String vehiclePlateType) {
		this.vehiclePlateType = vehiclePlateType;
	}

	/**
	 * @return the vehicleValue
	 */
	public long getVehicleValue() {
		return vehicleValue;
	}

	/**
	 * @param vehicleValue the vehicleValue to set
	 */
	public void setVehicleValue(long vehicleValue) {
		this.vehicleValue = vehicleValue;
	}

	/**
	 * @return the vehicleWeight
	 */
	public long getVehicleWeight() {
		return vehicleWeight;
	}

	/**
	 * @param vehicleWeight the vehicleWeight to set
	 */
	public void setVehicleWeight(long vehicleWeight) {
		this.vehicleWeight = vehicleWeight;
	}

	/**
	 * @return the vehicleCity
	 */
	public String getVehicleCity() {
		return vehicleCity;
	}

	/**
	 * @param vehicleCity the vehicleCity to set
	 */
	public void setVehicleCity(String vehicleCity) {
		this.vehicleCity = vehicleCity;
	}

	/**
	 * @return the coversList
	 */
	public List<QuotationCover> getCoversList() {
		if (coversList == null)
			coversList = new ArrayList<>();

		return coversList;
	}

	/**
	 * @param coversList the coversList to set
	 */
	public void setCoversList(List<QuotationCover> coversList) {
		this.coversList = coversList;
	}

	/**
	 * @return the quotationDrivers
	 */
	public List<QuotationDriver> getQuotationDrivers() {
		if (this.quotationDrivers == null)
			this.quotationDrivers = new ArrayList<>();
		return quotationDrivers;
	}

	/**
	 * @param quotationDrivers the quotationDrivers to set
	 */
	public void setQuotationDrivers(List<QuotationDriver> quotationDrivers) {
		this.quotationDrivers = quotationDrivers;
	}

	public List<QuotationDriver> getUnder21Drivers() {
		return under21Drivers;
	}

	public void setUnder21Drivers(List<QuotationDriver> under21Drivers) {
		this.under21Drivers = under21Drivers;
	}

	/**
	 * @return the vehicleMakeEn
	 */
	public String getVehicleMakeEn() {
		return vehicleMakeEn;
	}

	/**
	 * @param vehicleMakeEn the vehicleMakeEn to set
	 */
	public void setVehicleMakeEn(String vehicleMakeEn) {
		this.vehicleMakeEn = vehicleMakeEn;
	}

	/**
	 * @return the vehicleMakeAr
	 */
	public String getVehicleMakeAr() {
		return vehicleMakeAr;
	}

	/**
	 * @param vehicleMakeAr the vehicleMakeAr to set
	 */
	public void setVehicleMakeAr(String vehicleMakeAr) {
		this.vehicleMakeAr = vehicleMakeAr;
	}

	public String getProductDescEn() {
		return productDescEn;
	}

	public void setProductDescEn(String productDescEn) {
		this.productDescEn = productDescEn;
	}

	public String getProductDescAr() {
		return productDescAr;
	}

	public void setProductDescAr(String productDescAr) {
		this.productDescAr = productDescAr;
	}

	public List<QuotationAdminUpload> getAdminFilesUplods() {
		return adminFilesUplods;
	}

	public void setAdminFilesUplods(List<QuotationAdminUpload> adminFilesUplods) {
		this.adminFilesUplods = adminFilesUplods;
	}

	public List<QuotationHistory> getQuotationHistory() {
		return quotationHistory;
	}

	/**
	 * @return the licenseFileName
	 */
	public String getLicenseFileName() {
		return licenseFileName;
	}

	/**
	 * @param licenseFileName the licenseFileName to set
	 */
	public void setLicenseFileName(String licenseFileName) {
		this.licenseFileName = licenseFileName;
	}

	/**
	 * @return the idFileName
	 */
	public String getIdFileName() {
		return idFileName;
	}

	/**
	 * @param idFileName the idFileName to set
	 */
	public void setIdFileName(String idFileName) {
		this.idFileName = idFileName;
	}

	/**
	 * @return the cityDesc
	 */
	public String getCityDesc() {
		return cityDesc;
	}

	/**
	 * @param cityDesc the cityDesc to set
	 */
	public void setCityDesc(String cityDesc) {
		this.cityDesc = cityDesc;
	}

	/**
	 * @return the vehiclePlateTypeDesc
	 */
	public String getVehiclePlateTypeDesc() {
		return vehiclePlateTypeDesc;
	}

	/**
	 * @param vehiclePlateTypeDesc the vehiclePlateTypeDesc to set
	 */
	public void setVehiclePlateTypeDesc(String vehiclePlateTypeDesc) {
		this.vehiclePlateTypeDesc = vehiclePlateTypeDesc;
	}

	/**
	 * @return the carRightFileName
	 */
	public String getCarRightFileName() {
		return carRightFileName;
	}

	/**
	 * @param carRightFileName the carRightFileName to set
	 */
	public void setCarRightFileName(String carRightFileName) {
		this.carRightFileName = carRightFileName;
	}

	/**
	 * @return the istCardFileName
	 */
	public String getIstCardFileName() {
		return istCardFileName;
	}

	/**
	 * @param istCardFileName the istCardFileName to set
	 */
	public void setIstCardFileName(String istCardFileName) {
		this.istCardFileName = istCardFileName;
	}

	/**
	 * @return the custCardFileName
	 */
	public String getCustCardFileName() {
		return custCardFileName;
	}

	/**
	 * @param custCardFileName the custCardFileName to set
	 */
	public void setCustCardFileName(String custCardFileName) {
		this.custCardFileName = custCardFileName;
	}

	/**
	 * @return the carFronFileName
	 */
	public String getCarFrontFileName() {
		return carFrontFileName;
	}

	/**
	 * @param carFronFileName the carFronFileName to set
	 */
	public void setCarFrontFileName(String carFrontFileName) {
		this.carFrontFileName = carFrontFileName;
	}

	/**
	 * @return the carBackFileName
	 */
	public String getCarBackFileName() {
		return carBackFileName;
	}

	/**
	 * @param carBackFileName the carBackFileName to set
	 */
	public void setCarBackFileName(String carBackFileName) {
		this.carBackFileName = carBackFileName;
	}

	/**
	 * @return the carLeftFileName
	 */
	public String getCarLeftFileName() {
		return carLeftFileName;
	}

	/**
	 * @param carLeftFileName the carLeftFileName to set
	 */
	public void setCarLeftFileName(String carLeftFileName) {
		this.carLeftFileName = carLeftFileName;
	}

	/**
	 * @return the vehicleModelEn
	 */
	public String getVehicleModelEn() {
		return vehicleModelEn;
	}

	/**
	 * @param vehicleModelEn the vehicleModelEn to set
	 */
	public void setVehicleModelEn(String vehicleModelEn) {
		this.vehicleModelEn = vehicleModelEn;
	}

	/**
	 * @return the vehicleModelAr
	 */
	public String getVehicleModelAr() {
		return vehicleModelAr;
	}

	/**
	 * @param vehicleModelAr the vehicleModelAr to set
	 */
	public void setVehicleModelAr(String vehicleModelAr) {
		this.vehicleModelAr = vehicleModelAr;
	}

	public void setQuotationHistory(List<QuotationHistory> quotationHistory) {
		this.quotationHistory = quotationHistory;
	}

	/**
	 * @return the insuredOccupationCode
	 */
	public String getInsuredOccupationCode() {
		return insuredOccupationCode;
	}

	/**
	 * @param insuredOccupationCode the insuredOccupationCode to set
	 */
	public void setInsuredOccupationCode(String insuredOccupationCode) {
		this.insuredOccupationCode = insuredOccupationCode;
	}

	/**
	 * @return the insuredDobH
	 */
	public String getInsuredDobH() {
		return insuredDobH;
	}

	/**
	 * @param insuredDobH the insuredDobH to set
	 */
	public void setInsuredDobH(String insuredDobH) {
		this.insuredDobH = insuredDobH;
	}

	/**
	 * @return the existingPolicyNo
	 */
	public String getExistingPolicyNo() {
		return existingPolicyNo;
	}

	/**
	 * @param existingPolicyNo the existingPolicyNo to set
	 */
	public void setExistingPolicyNo(String existingPolicyNo) {
		this.existingPolicyNo = existingPolicyNo;
	}

	/**
	 * @return the existingCompanyName
	 */
	public String getExistingCompanyName() {
		return existingCompanyName;
	}

	/**
	 * @param existingCompanyName the existingCompanyName to set
	 */
	public void setExistingCompanyName(String existingCompanyName) {
		this.existingCompanyName = existingCompanyName;
	}

	/**
	 * @return the existingExpDate
	 */
	public String getExistingExpDate() {
		return existingExpDate;
	}

	/**
	 * @param existingExpDate the existingExpDate to set
	 */
	public void setExistingExpDate(String existingExpDate) {
		this.existingExpDate = existingExpDate;
	}

	public String getVehicleIdDescEn() {
		return vehicleIdDescEn;
	}

	public void setVehicleIdDescEn(String vehicleIdDescEn) {
		this.vehicleIdDescEn = vehicleIdDescEn;
	}

	public String getVehicleIdDescAr() {
		return vehicleIdDescAr;
	}

	public void setVehicleIdDescAr(String vehicleIdDescAr) {
		this.vehicleIdDescAr = vehicleIdDescAr;
	}

	/**
	 * @return the netPrem
	 */
	public double getNetPrem() {
		return netPrem;
	}

	/**
	 * @param netPrem the netPrem to set
	 */
	public void setNetPrem(double netPrem) {
		this.netPrem = netPrem;
	}

	/**
	 * @return the discountAmount
	 */
	public double getDiscountAmount() {
		return discountAmount;
	}

	/**
	 * @param discountAmount the discountAmount to set
	 */
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	/**
	 * @return the discountPrem
	 */
	public double getDiscountPrem() {
		return discountPrem;
	}

	/**
	 * @param discountPrem the discountPrem to set
	 */
	public void setDiscountPrem(double discountPrem) {
		this.discountPrem = discountPrem;
	}

	/**
	 * @return the loyaltyDiscountPer
	 */
	public double getLoyaltyDiscountPer() {
		return loyaltyDiscountPer;
	}

	/**
	 * @param loyaltyDiscountPer the loyaltyDiscountPer to set
	 */
	public void setLoyaltyDiscountPer(double loyaltyDiscountPer) {
		this.loyaltyDiscountPer = loyaltyDiscountPer;
	}

	/**
	 * @return the loadingAmount
	 */
	public double getLoadingAmount() {
		return loadingAmount;
	}

	/**
	 * @param loadingAmount the loadingAmount to set
	 */
	public void setLoadingAmount(double loadingAmount) {
		this.loadingAmount = loadingAmount;
	}

	/**
	 * @return the policyTaxes
	 */
	public double getPolicyTaxes() {
		return policyTaxes;
	}

	/**
	 * @param policyTaxes the policyTaxes to set
	 */
	public void setPolicyTaxes(double policyTaxes) {
		this.policyTaxes = policyTaxes;
	}

	/**
	 * @return the policyFees
	 */
	public double getPolicyFees() {
		return policyFees;
	}

	/**
	 * @param policyFees the policyFees to set
	 */
	public void setPolicyFees(double policyFees) {
		this.policyFees = policyFees;
	}

	/**
	 * @return the totalCoverPrem
	 */
	public double getTotalCoverPrem() {
		return totalCoverPrem;
	}

	/**
	 * @param totalCoverPrem the totalCoverPrem to set
	 */
	public void setTotalCoverPrem(double totalCoverPrem) {
		this.totalCoverPrem = totalCoverPrem;
	}

	/**
	 * @return the grossPrem
	 */
	public double getGrossPrem() {
		return grossPrem;
	}

	/**
	 * @param grossPrem the grossPrem to set
	 */
	public void setGrossPrem(double grossPrem) {
		this.grossPrem = grossPrem;
	}

	/**
	 * @return the policyStatusMsg
	 */
	public String getPolicyStatusMsg() {
		return policyStatusMsg;
	}

	/**
	 * @param policyStatusMsg the policyStatusMsg to set
	 */
	public void setPolicyStatusMsg(String policyStatusMsg) {
		this.policyStatusMsg = policyStatusMsg;
	}

	/**
	 * @return the yakeenRefNo
	 */
	public long getYakeenRefNo() {
		return yakeenRefNo;
	}

	/**
	 * @param yakeenRefNo the yakeenRefNo to set
	 */
	public void setYakeenRefNo(long yakeenRefNo) {
		this.yakeenRefNo = yakeenRefNo;
	}

	/**
	 * @return the quoteSubmissionDate
	 */
	public Date getQuoteSubmissionDate() {
		return quoteSubmissionDate;
	}

	/**
	 * @param quoteSubmissionDate the quoteSubmissionDate to set
	 */
	public void setQuoteSubmissionDate(Date quoteSubmissionDate) {
		this.quoteSubmissionDate = quoteSubmissionDate;
	}

	/**
	 * @return the quoteStatus
	 */
	public String getQuoteStatus() {
		return quoteStatus;
	}

	/**
	 * @param quoteStatus the quoteStatus to set
	 */
	public void setQuoteStatus(String quoteStatus) {
		this.quoteStatus = quoteStatus;
	}

	/**
	 * @return the purposeOfVehicleDesc
	 */
	public String getPurposeOfVehicleDesc() {
		return purposeOfVehicleDesc;
	}

	/**
	 * @param purposeOfVehicleDesc the purposeOfVehicleDesc to set
	 */
	public void setPurposeOfVehicleDesc(String purposeOfVehicleDesc) {
		this.purposeOfVehicleDesc = purposeOfVehicleDesc;
	}

	/**
	 * @return the olpEstn
	 */
	public String getOlpEstn() {
		return olpEstn;
	}

	/**
	 * @param olpEstn the olpEstn to set
	 */
	public void setOlpEstn(String olpEstn) {
		this.olpEstn = olpEstn;
	}

	/**
	 * @return the isMainDriver
	 */
	public boolean isMainDriver() {
		return isMainDriver;
	}

	/**
	 * @param isMainDriver the isMainDriver to set
	 */
	public void setMainDriver(boolean isMainDriver) {
		this.isMainDriver = isMainDriver;
	}

	/**
	 * @return the oldIqamaId
	 */
	public String getOldIqamaId() {
		return oldIqamaId;
	}

	/**
	 * @param oldIqamaId the oldIqamaId to set
	 */
	public void setOldIqamaId(String oldIqamaId) {
		this.oldIqamaId = oldIqamaId;
	}

	/**
	 * @return the vehicleOwnerIban
	 */
	public String getVehicleOwnerIban() {
		return vehicleOwnerIban;
	}

	/**
	 * @param vehicleOwnerIban the vehicleOwnerIban to set
	 */
	public void setVehicleOwnerIban(String vehicleOwnerIban) {
		this.vehicleOwnerIban = vehicleOwnerIban;
	}

	/**
	 * @return the driverAdditionReason
	 */
	public String getDriverAdditionReason() {
		return driverAdditionReason;
	}

	/**
	 * @param driverAdditionReason the driverAdditionReason to set
	 */
	public void setDriverAdditionReason(String driverAdditionReason) {
		this.driverAdditionReason = driverAdditionReason;
	}

	/**
	 * @return the underAgeDriver
	 */
	public boolean isUnderAgeDriver() {
		return underAgeDriver;
	}

	/**
	 * @param underAgeDriver the underAgeDriver to set
	 */
	public void setUnderAgeDriver(boolean underAgeDriver) {
		this.underAgeDriver = underAgeDriver;
	}

	/**
	 * @return the accDeath
	 */
	public boolean isAccDeath() {
		return accDeath;
	}

	/**
	 * @param accDeath the accDeath to set
	 */
	public void setAccDeath(boolean accDeath) {
		this.accDeath = accDeath;
	}

	/**
	 * @return the vehMotorAcc
	 */
	public boolean isVehMotorAcc() {
		return vehMotorAcc;
	}

	/**
	 * @param vehMotorAcc the vehMotorAcc to set
	 */
	public void setVehMotorAcc(boolean vehMotorAcc) {
		this.vehMotorAcc = vehMotorAcc;
	}

	/**
	 * @return the convTraffViols
	 */
	public boolean isConvTraffViols() {
		return convTraffViols;
	}

	/**
	 * @param convTraffViols the convTraffViols to set
	 */
	public void setConvTraffViols(boolean convTraffViols) {
		this.convTraffViols = convTraffViols;
	}

	/**
	 * @return the leaseFileName
	 */
	public String getLeaseFileName() {
		return leaseFileName;
	}

	/**
	 * @param leaseFileName the leaseFileName to set
	 */
	public void setLeaseFileName(String leaseFileName) {
		this.leaseFileName = leaseFileName;
	}

	/**
	 * @return the vehicleBodyTypeEn
	 */
	public String getVehicleBodyTypeEn() {
		return vehicleBodyTypeEn;
	}

	/**
	 * @param vehicleBodyTypeEn the vehicleBodyTypeEn to set
	 */
	public void setVehicleBodyTypeEn(String vehicleBodyTypeEn) {
		this.vehicleBodyTypeEn = vehicleBodyTypeEn;
	}

	/**
	 * @return the vehicleBodyTypeAr
	 */
	public String getVehicleBodyTypeAr() {
		return vehicleBodyTypeAr;
	}

	/**
	 * @param vehicleBodyTypeAr the vehicleBodyTypeAr to set
	 */
	public void setVehicleBodyTypeAr(String vehicleBodyTypeAr) {
		this.vehicleBodyTypeAr = vehicleBodyTypeAr;
	}

	/**
	 * @return the saeedService
	 */
	public String getSaeedService() {
		return saeedService;
	}

	/**
	 * @param saeedService the saeedService to set
	 */
	public void setSaeedService(String saeedService) {
		this.saeedService = saeedService;
	}

	/**
	 * @return the driverAccidents
	 */
	public double getDriverAccidents() {
		return driverAccidents;
	}

	/**
	 * @param driverAccidents the driverAccidents to set
	 */
	public void setDriverAccidents(double driverAccidents) {
		this.driverAccidents = driverAccidents;
	}

	/**
	 * @return the totalAfterDiscount
	 */
	public double getTotalAfterDiscount() {
		return totalAfterDiscount;
	}

	/**
	 * @param totalAfterDiscount the totalAfterDiscount to set
	 */
	public void setTotalAfterDiscount(double totalAfterDiscount) {
		this.totalAfterDiscount = totalAfterDiscount;
	}

	/**
	 * @return the totalBeforeDiscount
	 */
	public double getTotalBeforeDiscount() {
		return totalBeforeDiscount;
	}

	/**
	 * @param totalBeforeDiscount the totalBeforeDiscount to set
	 */
	public void setTotalBeforeDiscount(double totalBeforeDiscount) {
		this.totalBeforeDiscount = totalBeforeDiscount;
	}

	/**
	 * @return the smsFlag
	 */
	public boolean isSmsFlag() {
		return smsFlag;
	}

	/**
	 * @param smsFlag the smsFlag to set
	 */
	public void setSmsFlag(boolean smsFlag) {
		this.smsFlag = smsFlag;
	}

	/**
	 * @return the loyaltyDiscountFlag
	 */
	public int getLoyaltyDiscountFlag() {
		return loyaltyDiscountFlag;
	}

	/**
	 * @param loyaltyDiscountFlag the loyaltyDiscountFlag to set
	 */
	public void setLoyaltyDiscountFlag(int loyaltyDiscountFlag) {
		this.loyaltyDiscountFlag = loyaltyDiscountFlag;
	}

	/**
	 * @return the vehicleNationality
	 */
	public String getVehicleNationality() {
		return vehicleNationality;
	}

	/**
	 * @param vehicleNationality the vehicleNationality to set
	 */
	public void setVehicleNationality(String vehicleNationality) {
		this.vehicleNationality = vehicleNationality;
	}

	/**
	 * @return the agencyRepairOut
	 */
	public double getAgencyRepairOut() {
		return agencyRepairOut;
	}

	/**
	 * @param agencyRepairOut the agencyRepairOut to set
	 */
	public void setAgencyRepairOut(double agencyRepairOut) {
		this.agencyRepairOut = agencyRepairOut;
	}

	/**
	 * @return the driverAgeLess21
	 */
	public double getDriverAgeLess21() {
		return driverAgeLess21;
	}

	/**
	 * @param driverAgeLess21 the driverAgeLess21 to set
	 */
	public void setDriverAgeLess21(double driverAgeLess21) {
		this.driverAgeLess21 = driverAgeLess21;
	}

	public String getVehicleColorEn() {
		return vehicleColorEn;
	}

	public void setVehicleColorEn(String vehicleColorEn) {
		this.vehicleColorEn = vehicleColorEn;
	}

	public String getVehicleColorAr() {
		return vehicleColorAr;
	}

	public void setVehicleColorAr(String vehicleColorAr) {
		this.vehicleColorAr = vehicleColorAr;
	}

	/**
	 * @return the renew
	 */
	public boolean isRenew() {
		return renew;
	}

	/**
	 * @param renew the renew to set
	 */
	public void setRenew(boolean renew) {
		this.renew = renew;
	}

	/**
	 * @return the insuredEducation
	 */
	public String getInsuredEducation() {
		return insuredEducation;
	}

	/**
	 * @param insuredEducation the insuredEducation to set
	 */
	public void setInsuredEducation(String insuredEducation) {
		this.insuredEducation = insuredEducation;
	}

	/**
	 * @return the insuredMaritalStatus
	 */
	public String getInsuredMaritalStatus() {
		return insuredMaritalStatus;
	}

	/**
	 * @param insuredMaritalStatus the insuredMaritalStatus to set
	 */
	public void setInsuredMaritalStatus(String insuredMaritalStatus) {
		this.insuredMaritalStatus = insuredMaritalStatus;
	}

	/**
	 * @return the insuredNoChildUnder16
	 */
	public int getInsuredNoChildUnder16() {
		return insuredNoChildUnder16;
	}

	/**
	 * @param insuredNoChildUnder16 the insuredNoChildUnder16 to set
	 */
	public void setInsuredNoChildUnder16(int insuredNoChildUnder16) {
		this.insuredNoChildUnder16 = insuredNoChildUnder16;
	}

	/**
	 * @return the vehicleCurrentMileage
	 */
	public long getVehicleCurrentMileage() {
		return vehicleCurrentMileage;
	}

	/**
	 * @param vehicleCurrentMileage the vehicleCurrentMileage to set
	 */
	public void setVehicleCurrentMileage(long vehicleCurrentMileage) {
		this.vehicleCurrentMileage = vehicleCurrentMileage;
	}

	/**
	 * @return the vehicleLowerExpectedMileagePerYear
	 */
	public long getVehicleLowerExpectedMileagePerYear() {
		return vehicleLowerExpectedMileagePerYear;
	}

	/**
	 * @param vehicleLowerExpectedMileagePerYear the
	 *                                           vehicleLowerExpectedMileagePerYear
	 *                                           to set
	 */
	public void setVehicleLowerExpectedMileagePerYear(long vehicleLowerExpectedMileagePerYear) {
		this.vehicleLowerExpectedMileagePerYear = vehicleLowerExpectedMileagePerYear;
	}

	/**
	 * @return the vehicleUpperExpectedMileagePerYear
	 */
	public long getVehicleUpperExpectedMileagePerYear() {
		return vehicleUpperExpectedMileagePerYear;
	}

	/**
	 * @param vehicleUpperExpectedMileagePerYear the
	 *                                           vehicleUpperExpectedMileagePerYear
	 *                                           to set
	 */
	public void setVehicleUpperExpectedMileagePerYear(long vehicleUpperExpectedMileagePerYear) {
		this.vehicleUpperExpectedMileagePerYear = vehicleUpperExpectedMileagePerYear;
	}

	/**
	 * @return the vehicleNightLocation
	 */
	public String getVehicleNightLocation() {
		return vehicleNightLocation;
	}

	/**
	 * @param vehicleNightLocation the vehicleNightLocation to set
	 */
	public void setVehicleNightLocation(String vehicleNightLocation) {
		this.vehicleNightLocation = vehicleNightLocation;
	}

	/**
	 * @return the vehicleEngineSize
	 */
	public String getVehicleEngineSize() {
		return vehicleEngineSize;
	}

	/**
	 * @param vehicleEngineSize the vehicleEngineSize to set
	 */
	public void setVehicleEngineSize(String vehicleEngineSize) {
		this.vehicleEngineSize = vehicleEngineSize;
	}

	/**
	 * @return the vehicleTransType
	 */
	public String getVehicleTransType() {
		return vehicleTransType;
	}

	/**
	 * @param vehicleTransType the vehicleTransType to set
	 */
	public void setVehicleTransType(String vehicleTransType) {
		this.vehicleTransType = vehicleTransType;
	}

	/**
	 * @return the vehAxleWeight
	 */
	public long getVehAxleWeight() {
		return vehAxleWeight;
	}

	/**
	 * @param vehAxleWeight the vehAxleWeight to set
	 */
	public void setVehAxleWeight(long vehAxleWeight) {
		this.vehAxleWeight = vehAxleWeight;
	}

	/**
	 * @return the vehCarMods
	 */
	public String getVehCarMods() {
		return vehCarMods;
	}

	/**
	 * @param vehCarMods the vehCarMods to set
	 */
	public void setVehCarMods(String vehCarMods) {
		this.vehCarMods = vehCarMods;
	}

	/**
	 * @return the vehicleSpecs
	 */
	public String getVehicleSpecs() {
		return vehicleSpecs;
	}

	/**
	 * @param vehicleSpecs the vehicleSpecs to set
	 */
	public void setVehicleSpecs(String vehicleSpecs) {
		this.vehicleSpecs = vehicleSpecs;
	}

	/**
	 * @return the natAddress
	 */
	public QuotationUserAddress getNatAddress() {
		return natAddress;
	}

	/**
	 * @param natAddress the natAddress to set
	 */
	public void setNatAddress(QuotationUserAddress natAddress) {
		this.natAddress = natAddress;
	}

	/**
	 * @return the offAddress
	 */
	public QuotationUserAddress getOffAddress() {
		return offAddress;
	}

	/**
	 * @param offAddress the offAddress to set
	 */
	public void setOffAddress(QuotationUserAddress offAddress) {
		this.offAddress = offAddress;
	}

	/**
	 * @return the productChanged
	 */
	public boolean isProductChanged() {
		return productChanged;
	}

	/**
	 * @param productChanged the productChanged to set
	 */
	public void setProductChanged(boolean productChanged) {
		this.productChanged = productChanged;
	}

	/**
	 * @return the engChassisNoFileName
	 */
	public String getEngChassisNoFileName() {
		return engChassisNoFileName;
	}

	/**
	 * @param engChassisNoFileName the engChassisNoFileName to set
	 */
	public void setEngChassisNoFileName(String engChassisNoFileName) {
		this.engChassisNoFileName = engChassisNoFileName;
	}

	public String getSchemeCode() {
		return schemeCode;
	}

	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}

	public String toString() {
		String objectStr = "";
		objectStr += "\n\n accDeath : " + accDeath;
		objectStr += "\n\n vehMotorAcc : " + vehMotorAcc;
		objectStr += "\n\n convTraffViols : " + convTraffViols;
		objectStr += "\n\n addressAddNo : " + addressAddNo;
		objectStr += "\n\n addressBuildingNo : " + addressBuildingNo;
		objectStr += "\n\n addressDistrict : " + addressDistrict;
		objectStr += "\n\n addressStreet : " + addressStreet;
		objectStr += "\n\n addressUnitNo : " + addressUnitNo;
		objectStr += "\n\n addressZipCode : " + addressZipCode;
		objectStr += "\n\n agencyRepair : " + agencyRepair;
		objectStr += "\n\n agencyRepairOut : " + agencyRepairOut;
		objectStr += "\n\n vehicleValue : " + vehicleValue;
		objectStr += "\n\n driverAgeLess21 : " + driverAgeLess21;
		objectStr += "\n\n city : " + city;
		objectStr += "\n\n cityDesc : " + cityDesc;
		objectStr += "\n\n deductibleValue : " + deductibleValue;
		objectStr += "\n\n insuredDob : " + insuredDob;
		objectStr += "\n\n insuredDobH : " + insuredDobH;
		objectStr += "\n\n insuredEmail : " + insuredEmail;
		objectStr += "\n\n insuredGender : " + insuredGender;
		objectStr += "\n\n insuredId : " + insuredId;
		objectStr += "\n\n insuredIdType : " + insuredIdType;
		objectStr += "\n\n insuredMobile : " + insuredMobile;
		objectStr += "\n\n insuredName : " + insuredName;
		objectStr += "\n\n insuredNationality : " + insuredNationality;
		objectStr += "\n\n insuredOccupationCode : " + insuredOccupationCode;
		objectStr += "\n\n loyaltyDiscount : " + loyaltyDiscount;
		objectStr += "\n\n ncdYears : " + ncdYears;
		objectStr += "\n\n paymemtAmount : " + paymemtAmount;
		objectStr += "\n\n paymentMethod : " + paymentMethod;
		objectStr += "\n\n paymentRefNo : " + paymentRefNo;
		objectStr += "\n\n policyEffFromNo : " + policyEffFromNo;
		objectStr += "\n\n policyEffTo : " + policyEffTo;
		objectStr += "\n\n policyEffDate : " + policyEffDate;
		objectStr += "\n\n policyIssueDate : " + policyIssueDate;
		objectStr += "\n\n policyNo : " + policyNo;
		objectStr += "\n\n policyRefNo : " + policyRefNo;
		objectStr += "\n\n policyStatusCode : " + policyStatusCode;
		objectStr += "\n\n productCode : " + productCode;
		objectStr += "\n\n purposeOfVehicle : " + purposeOfVehicle;
		objectStr += "\n\n purposeOfVehicleDesc : " + purposeOfVehicleDesc;
		objectStr += "\n\n referenceNo : " + referenceNo;
		objectStr += "\n\n source : " + source;
		objectStr += "\n\n transaction : " + transaction;
		objectStr += "\n\n vehicleBodyType : " + vehicleBodyType;
		objectStr += "\n\n vehicleBodyTypeEn : " + vehicleBodyTypeEn;
		objectStr += "\n\n vehicleBodyTypeAr : " + vehicleBodyTypeAr;
		objectStr += "\n\n vehicleCapacity : " + vehicleCapacity;
		objectStr += "\n\n vehicleChassisNo : " + vehicleChassisNo;
		objectStr += "\n\n quotationId : " + quotationId;
		objectStr += "\n\n schemeCode : " + schemeCode;

		return objectStr;
	}
}
