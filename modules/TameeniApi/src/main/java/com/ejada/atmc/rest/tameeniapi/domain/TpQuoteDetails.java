/*
 * CustomizedParameter.java Apr 18, 2018  
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
package com.ejada.atmc.rest.tameeniapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Kareem Kahil 
 *
 */
@XmlRootElement
public class TpQuoteDetails
{
	private int policyHolderIdentityTypeCode;
	
	private long policyHolderID;
	
	private String policyHolderIDExpiry;
	
	private int purposeOfVehicleUseID;
	
	private int insuranceTypeID;
	
	private int quoteRequestSourceID;
	
	private String fullName;
	
	private String arabicFirstName;
	
	private String arabicMiddleName;
	
	private String arabicLastName;
	
	private String englishFirstName;
	
	private String englishMiddleName;
	
	private String englishLastName;
	
	private String dateOfBirthG;
	
	private String dateOfBirthH;
	
	private String occupation;
	
	private int cylinders;
	
	private long vehicleCapacity;
	
	private int policyHolderNationalityID;
	
	private int vehicleUniqueTypeID;
	
	private long vehicleSequenceNumber;
	
	private long vehicleCustomID;
	
	private boolean isDriverDisabled;
	
	private int policyHolderGender;
	
	private int vehicleDriveRegionID;
	
	private int vehicleDriveCityID;
	
	private int vehiclePlateTypeID;
	
	private int vehiclePlateNumber;
	
	private int firstPlateLetterID;
	
	private int secondPlateLetterID;
	
	private int thirdPlateLetterID;
	
	private int vehicleMakeCodeNajm;
	
	private int vehicleMakeCodeNIC;
	
	private String vehicleMakeTextNIC;
	
	private int vehicleMakeCodeTameeni;
	
	private int vehicleModelCodeNajm;
	
	private int vehicleModelCodeNIC;
	
	private String vehicleModelTextNIC;
	
	private int vehicleModelCodeTameeni;
	
	private int manufactureYear;
	
	private int vehicleColorCode;

	private String vehicleRegistrationCityCode;
	
	private String vehicleVIN;
	
	private String vehicleRegistrationExpiryDate;

	private long policyEffectiveDate;
	
	private long policyExpiryDate;
	
	private String mobileNo;
	
	private int buildingNumber;
	
	private String street;
	
	private String district;
	
	private String city;
	
	private int zipCode;
	
	private int additionalNumber;
	
	private int vehicleWeight;
	
	private int vehicleBodyCode;

	private int coverAgeLimitID;
	
	private List<DriverDetails> driverDetails;
	
	private int najmNoOfAccidents;
	
	private String najmDriverName;
	
	private List<NajmCaseDetails> najmCaseDetails;
	
	private String nCDFreeYears;
	
	private String nCDReference;
	
	private boolean isPrimaryDriver;
	
	private long primaryDriverID;
	
	private String primaryDriverName;
	
	private String primaryDriverDateOfBirthG;
	
	private String primaryDriverDateOfBirthH;
	
	private int primaryDriverGender;
	
	private boolean isRenewal;
	
	private boolean isScheme;
	
	private List<SchemeDetails> schemeDetails;
	
	private List<CustomizedParameter> customizedParameter;
	
	
	/**Repsonse Only Fields**/
	private double policyAmount;
	
	private double policyTaxableAmount;
	
	private List<PremiumBreakdown> premiumBreakdown;
	
	private int[] policyFeatures;
	
	private long maxLiability;
	
	private String policyNumber;
	
	private long policyIssueDate;
	
	@JsonProperty("Discounts")
	private List<Discounts> discounts;

	@XmlElement(name = "PolicyholderIdentityTypeCode")
	public int getPolicyHolderIdentityTypeCode() {
		return policyHolderIdentityTypeCode;
	}

	public void setPolicyHolderIdentityTypeCode(int policyHolderIdentityTypeCode) {
		this.policyHolderIdentityTypeCode = policyHolderIdentityTypeCode;
	}
	
	@XmlElement(name = "PolicyHolderID")
	public long getPolicyHolderID() {
		return policyHolderID;
	}

	public void setPolicyHolderID(long policyHolderID) {
		this.policyHolderID = policyHolderID;
	}

	@XmlElement(name = "PolicyholderIDExpiry")
	public String getPolicyHolderIDExpiry() {
		return policyHolderIDExpiry;
	}

	public void setPolicyHolderIDExpiry(String policyHolderIDExpiry) {
		this.policyHolderIDExpiry = policyHolderIDExpiry;
	}

	@XmlElement(name = "PurposeofVehicleUseID")
	public int getPurposeOfVehicleUseID() {
		return purposeOfVehicleUseID;
	}

	public void setPurposeOfVehicleUseID(int purposeOfVehicleUseID) {
		this.purposeOfVehicleUseID = purposeOfVehicleUseID;
	}

	@XmlElement(name = "InsuranceTypeID")
	public int getInsuranceTypeID() {
		return insuranceTypeID;
	}

	public void setInsuranceTypeID(int insuranceTypeID) {
		this.insuranceTypeID = insuranceTypeID;
	}

	@XmlElement(name = "QuoteRequestSourceID")
	public int getQuoteRequestSourceID() {
		return quoteRequestSourceID;
	}

	public void setQuoteRequestSourceID(int quoteRequestSourceID) {
		this.quoteRequestSourceID = quoteRequestSourceID;
	}

	@XmlElement(name = "FullName")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@XmlElement(name = "ArabicFirstName")
	public String getArabicFirstName() {
		return arabicFirstName;
	}

	public void setArabicFirstName(String arabicFirstName) {
		this.arabicFirstName = arabicFirstName;
	}

	@XmlElement(name = "ArabicMiddleName")
	public String getArabicMiddleName() {
		return arabicMiddleName;
	}

	public void setArabicMiddleName(String arabicMiddleName) {
		this.arabicMiddleName = arabicMiddleName;
	}

	@XmlElement(name = "ArabicLastName")
	public String getArabicLastName() {
		return arabicLastName;
	}

	public void setArabicLastName(String arabicLastName) {
		this.arabicLastName = arabicLastName;
	}

	@XmlElement(name = "EnglishFirstName")
	public String getEnglishFirstName() {
		return englishFirstName;
	}

	public void setEnglishFirstName(String englishFirstName) {
		this.englishFirstName = englishFirstName;
	}

	@XmlElement(name = "EnglishMiddleName")
	public String getEnglishMiddleName() {
		return englishMiddleName;
	}

	public void setEnglishMiddleName(String englishMiddleName) {
		this.englishMiddleName = englishMiddleName;
	}

	@XmlElement(name = "EnglishLastName")
	public String getEnglishLastName() {
		return englishLastName;
	}

	public void setEnglishLastName(String englishLastName) {
		this.englishLastName = englishLastName;
	}

	@XmlElement(name = "DateOfBirthG")
	public String getDateOfBirthG() {
		return dateOfBirthG;
	}

	public void setDateOfBirthG(String dateOfBirthG) {
		this.dateOfBirthG = dateOfBirthG;
	}

	@XmlElement(name = "DateOfBirthH")
	public String getDateOfBirthH() {
		return dateOfBirthH;
	}

	public void setDateOfBirthH(String dateOfBirthH) {
		this.dateOfBirthH = dateOfBirthH;
	}

	@XmlElement(name = "Occupation")
	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@XmlElement(name = "Cylinders")
	public int getCylinders() {
		return cylinders;
	}

	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}

	@XmlElement(name = "VehicleCapacity")
	public long getVehicleCapacity() {
		return vehicleCapacity;
	}

	public void setVehicleCapacity(long vehicleCapacity) {
		this.vehicleCapacity = vehicleCapacity;
	}

	@XmlElement(name = "PolicyholderNationalityID")
	public int getPolicyHolderNationalityID() {
		return policyHolderNationalityID;
	}

	public void setPolicyHolderNationalityID(int policyHolderNationalityID) {
		this.policyHolderNationalityID = policyHolderNationalityID;
	}

	@XmlElement(name = "VehicleUniqueTypeID")
	public int getVehicleUniqueTypeID() {
		return vehicleUniqueTypeID;
	}

	public void setVehicleUniqueTypeID(int vehicleUniqueTypeID) {
		this.vehicleUniqueTypeID = vehicleUniqueTypeID;
	}

	@XmlElement(name = "VehicleSequenceNumber")
	public long getVehicleSequenceNumber() {
		return vehicleSequenceNumber;
	}

	public void setVehicleSequenceNumber(long vehicleSequenceNumber) {
		this.vehicleSequenceNumber = vehicleSequenceNumber;
	}

	@XmlElement(name = "VehicleCustomID")
	public long getVehicleCustomID() {
		return vehicleCustomID;
	}

	public void setVehicleCustomID(long vehicleCustomID) {
		this.vehicleCustomID = vehicleCustomID;
	}

	@XmlElement(name = "IsDriverDisabled")
	public boolean isDriverDisabled() {
		return isDriverDisabled;
	}

	public void setDriverDisabled(boolean isDriverDisabled) {
		this.isDriverDisabled = isDriverDisabled;
	}

	@XmlElement(name = "PolicyholderGender")
	public int getPolicyHolderGender() {
		return policyHolderGender;
	}

	public void setPolicyHolderGender(int policyHolderGender) {
		this.policyHolderGender = policyHolderGender;
	}

	@XmlElement(name = "VehicleDriveRegionID")
	public int getVehicleDriveRegionID() {
		return vehicleDriveRegionID;
	}

	public void setVehicleDriveRegionID(int vehicleDriveRegionID) {
		this.vehicleDriveRegionID = vehicleDriveRegionID;
	}

	@XmlElement(name = "VehicleDriveCityID")
	public int getVehicleDriveCityID() {
		return vehicleDriveCityID;
	}

	public void setVehicleDriveCityID(int vehicleDriveCityID) {
		this.vehicleDriveCityID = vehicleDriveCityID;
	}

	@XmlElement(name = "VehiclePlateTypeID")
	public int getVehiclePlateTypeID() {
		return vehiclePlateTypeID;
	}

	public void setVehiclePlateTypeID(int vehiclePlateTypeID) {
		this.vehiclePlateTypeID = vehiclePlateTypeID;
	}

	@XmlElement(name = "VehiclePlateNumber")
	public int getVehiclePlateNumber() {
		return vehiclePlateNumber;
	}

	public void setVehiclePlateNumber(int vehiclePlateNumber) {
		this.vehiclePlateNumber = vehiclePlateNumber;
	}

	@XmlElement(name = "FirstPlateLetterID")
	public int getFirstPlateLetterID() {
		return firstPlateLetterID;
	}

	public void setFirstPlateLetterID(int firstPlateLetterID) {
		this.firstPlateLetterID = firstPlateLetterID;
	}

	@XmlElement(name = "SecondPlateLetterID")
	public int getSecondPlateLetterID() {
		return secondPlateLetterID;
	}

	public void setSecondPlateLetterID(int secondPlateLetterID) {
		this.secondPlateLetterID = secondPlateLetterID;
	}

	@XmlElement(name = "ThirdPlateLetterID")
	public int getThirdPlateLetterID() {
		return thirdPlateLetterID;
	}

	public void setThirdPlateLetterID(int thirdPlateLetterID) {
		this.thirdPlateLetterID = thirdPlateLetterID;
	}

	@XmlElement(name = "VehicleMakeCodeNajm")
	public int getVehicleMakeCodeNajm() {
		return vehicleMakeCodeNajm;
	}

	public void setVehicleMakeCodeNajm(int vehicleMakeCodeNajm) {
		this.vehicleMakeCodeNajm = vehicleMakeCodeNajm;
	}

	@XmlElement(name = "VehicleMakeCodeNIC")
	public int getVehicleMakeCodeNIC() {
		return vehicleMakeCodeNIC;
	}

	public void setVehicleMakeCodeNIC(int vehicleMakeCodeNIC) {
		this.vehicleMakeCodeNIC = vehicleMakeCodeNIC;
	}

	@XmlElement(name = "VehicleMakeTextNIC")
	public String getVehicleMakeTextNIC() {
		return vehicleMakeTextNIC;
	}

	public void setVehicleMakeTextNIC(String vehicleMakeTextNIC) {
		this.vehicleMakeTextNIC = vehicleMakeTextNIC;
	}

	@XmlElement(name = "VehicleMakeCodeTameeni")
	public int getVehicleMakeCodeTameeni() {
		return vehicleMakeCodeTameeni;
	}

	public void setVehicleMakeCodeTameeni(int vehicleMakeCodeTameeni) {
		this.vehicleMakeCodeTameeni = vehicleMakeCodeTameeni;
	}

	@XmlElement(name = "VehicleModelCodeNajm")
	public int getVehicleModelCodeNajm() {
		return vehicleModelCodeNajm;
	}

	public void setVehicleModelCodeNajm(int vehicleModelCodeNajm) {
		this.vehicleModelCodeNajm = vehicleModelCodeNajm;
	}

	@XmlElement(name = "VehicleModelCodeNIC")
	public int getVehicleModelCodeNIC() {
		return vehicleModelCodeNIC;
	}

	public void setVehicleModelCodeNIC(int vehicleModelCodeNIC) {
		this.vehicleModelCodeNIC = vehicleModelCodeNIC;
	}

	@XmlElement(name = "VehicleModelTextNIC")
	public String getVehicleModelTextNIC() {
		return vehicleModelTextNIC;
	}

	public void setVehicleModelTextNIC(String vehicleModelTextNIC) {
		this.vehicleModelTextNIC = vehicleModelTextNIC;
	}

	@XmlElement(name = "VehicleModelCodeTameeni")
	public int getVehicleModelCodeTameeni() {
		return vehicleModelCodeTameeni;
	}

	public void setVehicleModelCodeTameeni(int vehicleModelCodeTameeni) {
		this.vehicleModelCodeTameeni = vehicleModelCodeTameeni;
	}

	@XmlElement(name = "ManufactureYear")
	public int getManufactureYear() {
		return manufactureYear;
	}

	public void setManufactureYear(int manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	@XmlElement(name = "VehicleColorCode")
	public int getVehicleColorCode() {
		return vehicleColorCode;
	}

	public void setVehicleColorCode(int vehicleColorCode) {
		this.vehicleColorCode = vehicleColorCode;
	}

	@XmlElement(name = "VehicleRegistrationCityCode")
	public String getVehicleRegistrationCityCode() {
		return vehicleRegistrationCityCode;
	}

	public void setVehicleRegistrationCityCode(String vehicleRegistrationCityCode) {
		this.vehicleRegistrationCityCode = vehicleRegistrationCityCode;
	}

	@XmlElement(name = "VehicleVIN")
	public String getVehicleVIN() {
		return vehicleVIN;
	}

	public void setVehicleVIN(String vehicleVIN) {
		this.vehicleVIN = vehicleVIN;
	}

	@XmlElement(name = "VehicleRegistrationExpiryDate")
	public String getVehicleRegistrationExpiryDate() {
		return vehicleRegistrationExpiryDate;
	}

	public void setVehicleRegistrationExpiryDate(String vehicleRegistrationExpiryDate) {
		this.vehicleRegistrationExpiryDate = vehicleRegistrationExpiryDate;
	}

	@XmlElement(name = "PolicyEffectiveDate")
	public long getPolicyEffectiveDate() {
		return policyEffectiveDate;
	}

	public void setPolicyEffectiveDate(long policyEffectiveDate) {
		this.policyEffectiveDate = policyEffectiveDate;
	}

	@XmlElement(name = "PolicyExpiryDate")
	public long getPolicyExpiryDate() {
		return policyExpiryDate;
	}

	public void setPolicyExpiryDate(long policyExpiryDate) {
		this.policyExpiryDate = policyExpiryDate;
	}

	@XmlElement(name = "MobileNo")
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@XmlElement(name = "BuildingNumber")
	public int getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(int buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	@XmlElement(name = "Street")
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@XmlElement(name = "District")
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@XmlElement(name = "City")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@XmlElement(name = "ZipCode")
	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@XmlElement(name = "AdditionalNumber")
	public int getAdditionalNumber() {
		return additionalNumber;
	}

	public void setAdditionalNumber(int additionalNumber) {
		this.additionalNumber = additionalNumber;
	}

	@XmlElement(name = "VehicleWeight")
	public int getVehicleWeight() {
		return vehicleWeight;
	}

	public void setVehicleWeight(int vehicleWeight) {
		this.vehicleWeight = vehicleWeight;
	}

	@XmlElement(name = "VehicleBodyCode")
	public int getVehicleBodyCode() {
		return vehicleBodyCode;
	}

	public void setVehicleBodyCode(int vehicleBodyCode) {
		this.vehicleBodyCode = vehicleBodyCode;
	}

	@XmlElement(name = "CoverAgeLimitID")
	public int getCoverAgeLimitID() {
		return coverAgeLimitID;
	}

	public void setCoverAgeLimitID(int coverAgeLimitID) {
		this.coverAgeLimitID = coverAgeLimitID;
	}

	@XmlElement(name = "DriverDetails")
	public List<DriverDetails> getDriverDetails() {
		return driverDetails;
	}

	public void setDriverDetails(List<DriverDetails> driverDetails) {
		this.driverDetails = driverDetails;
	}

	@XmlElement(name = "NajmNoOfAccidents")
	public int getNajmNoOfAccidents() {
		return najmNoOfAccidents;
	}

	public void setNajmNoOfAccidents(int najmNoOfAccidents) {
		this.najmNoOfAccidents = najmNoOfAccidents;
	}

	@XmlElement(name = "NajmDriverName")
	public String getNajmDriverName() {
		return najmDriverName;
	}

	public void setNajmDriverName(String najmDriverName) {
		this.najmDriverName = najmDriverName;
	}

	@XmlElement(name = "NajmCaseDetails")
	public List<NajmCaseDetails> getNajmCaseDetails() {
		return najmCaseDetails;
	}

	public void setNajmCaseDetails(List<NajmCaseDetails> najmCaseDetails) {
		this.najmCaseDetails = najmCaseDetails;
	}

	@XmlElement(name = "NCDFreeYears")
	public String getnCDFreeYears() {
		return nCDFreeYears;
	}

	public void setnCDFreeYears(String nCDFreeYears) {
		this.nCDFreeYears = nCDFreeYears;
	}

	@XmlElement(name = "NCDReference")
	public String getnCDReference() {
		return nCDReference;
	}

	public void setnCDReference(String nCDReference) {
		this.nCDReference = nCDReference;
	}

	@XmlElement(name = "IsPrimaryDriver")
	public boolean isPrimaryDriver() {
		return isPrimaryDriver;
	}

	public void setPrimaryDriver(boolean isPrimaryDriver) {
		this.isPrimaryDriver = isPrimaryDriver;
	}

	@XmlElement(name = "PrimaryDriverID")
	public long getPrimaryDriverID() {
		return primaryDriverID;
	}

	public void setPrimaryDriverID(long primaryDriverID) {
		this.primaryDriverID = primaryDriverID;
	}

	@XmlElement(name = "PrimaryDriverName")
	public String getPrimaryDriverName() {
		return primaryDriverName;
	}

	public void setPrimaryDriverName(String primaryDriverName) {
		this.primaryDriverName = primaryDriverName;
	}

	@XmlElement(name = "PrimaryDriverDateOfBirthG")
	public String getPrimaryDriverDateOfBirthG() {
		return primaryDriverDateOfBirthG;
	}

	public void setPrimaryDriverDateOfBirthG(String primaryDriverDateOfBirthG) {
		this.primaryDriverDateOfBirthG = primaryDriverDateOfBirthG;
	}

	@XmlElement(name = "PrimaryDriverDateOfBirthH")
	public String getPrimaryDriverDateOfBirthH() {
		return primaryDriverDateOfBirthH;
	}

	public void setPrimaryDriverDateOfBirthH(String primaryDriverDateOfBirthH) {
		this.primaryDriverDateOfBirthH = primaryDriverDateOfBirthH;
	}

	@XmlElement(name = "PrimaryDriverGender")
	public int getPrimaryDriverGender() {
		return primaryDriverGender;
	}

	public void setPrimaryDriverGender(int primaryDriverGender) {
		this.primaryDriverGender = primaryDriverGender;
	}

	@XmlElement(name = "IsRenewal")
	public boolean isRenewal() {
		return isRenewal;
	}

	public void setRenewal(boolean isRenewal) {
		this.isRenewal = isRenewal;
	}

	@XmlElement(name = "IsScheme")
	public boolean isScheme() {
		return isScheme;
	}

	public void setScheme(boolean isScheme) {
		this.isScheme = isScheme;
	}

	@XmlElement(name = "SchemeDetails")
	public List<SchemeDetails> getSchemeDetails() {
		return schemeDetails;
	}

	public void setSchemeDetails(List<SchemeDetails> schemeDetails) {
		this.schemeDetails = schemeDetails;
	}

	@XmlElement(name = "CustomizedParameter")
	public List<CustomizedParameter> getCustomizedParameter() {
		return customizedParameter;
	}

	public void setCustomizedParameter(List<CustomizedParameter> customizedParameter) {
		this.customizedParameter = customizedParameter;
	}

	@XmlElement(name = "PolicyAmount")
	public double getPolicyAmount() {
		return policyAmount;
	}

	public void setPolicyAmount(double policyAmount) {
		this.policyAmount = policyAmount;
	}

	@XmlElement(name = "PolicyTaxableAmount")
	public double getPolicyTaxableAmount() {
		return policyTaxableAmount;
	}

	public void setPolicyTaxableAmount(double policyTaxableAmount) {
		this.policyTaxableAmount = policyTaxableAmount;
	}

	@XmlElement(name = "PremiumBreakdown")
	public List<PremiumBreakdown> getPremiumBreakdown() {
		return premiumBreakdown;
	}

	public void setPremiumBreakdown(List<PremiumBreakdown> premiumBreakdown) {
		this.premiumBreakdown = premiumBreakdown;
	}

	@XmlElement(name = "PolicyFeatures")
	public int[] getPolicyFeatures() {
		return policyFeatures;
	}

	public void setPolicyFeatures(int[] policyFeatures) {
		this.policyFeatures = policyFeatures;
	}

	@XmlElement(name = "MaxLiability")
	public long getMaxLiability() {
		return maxLiability;
	}

	public void setMaxLiability(long maxLiability) {
		this.maxLiability = maxLiability;
	}

	@XmlElement(name = "PolicyNumber")
	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	@XmlElement(name = "PolicyIssueDate")
	public long getPolicyIssueDate() {
		return policyIssueDate;
	}

	public void setPolicyIssueDate(long policyIssueDate) {
		this.policyIssueDate = policyIssueDate;
	}

	@XmlElement(name = "Discounts")
	public List<Discounts> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<Discounts> discounts) {
		this.discounts = discounts;
	}
	
	
}
