package com.ejada.atmc.rest.tameeniapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 
 * @author Ehab
 *
 */
public class DraftPolicyResponseDetails {

	@JsonProperty("PolicyholderIdentityTypeCode")
	private long policyholderIdentityTypeCode;
	
	@JsonProperty("PolicyHolderID")
	private long policyHolderID;
	
	@JsonProperty("PurposeofVehicleUseID")
	private long purposeofVehicleUseID;
	
	@JsonProperty("QuoteRequestSourceID")
	private int quoteRequestSourceID;
	
	@JsonProperty("FullName")
	private String fullName;
	
	@JsonProperty("ArabicFirstName")
	private String arabicFirstName;
	
	@JsonProperty("ArabicMiddleName")
	private String arabicMiddleName;
	
	@JsonProperty("ArabicLastName")
	private String arabicLastName;
	
	@JsonProperty("EnglishFirstName")
	private String englishFirstName;
	
	@JsonProperty("EnglishMiddleName")
	private String englishMiddleName;
	
	@JsonProperty("EnglishLastName")
	private String englishLastName;
	
	@JsonProperty("DateOfBirthG")
	private String dateOfBirthG;
	
	@JsonProperty("DateOfBirthH")
	private String dateOfBirthH;
	
	@JsonProperty("Occupation")
	private String occupation;
	
	@JsonProperty("Cylinders")
	private long cylinders;
	
	@JsonProperty("VehicleCapacity")
	private int vehicleCapacity;
	
	@JsonProperty("PolicyholderNationalityID")
	private int policyholderNationalityID;
	
	@JsonProperty("VehicleUniqueTypeID")
	private int vehicleUniqueTypeID;
	
	@JsonProperty("VehicleSequenceNumber")
	private long vehicleSequenceNumber;
	
	@JsonProperty("VehicleCustomID")
	private int vehicleCustomID;
	
	@JsonProperty("IsDriverDisabled")
	private boolean isDriverDisabled;
	
	@JsonProperty("PolicyholderGender")
	private int policyholderGender;
	
	@JsonProperty("VehicleDriveCityID")
	private int vehicleDriveCityID;
	
	@JsonProperty("VehiclePlateTypeID")
	private int vehiclePlateTypeID;
	
	@JsonProperty("VehiclePlateNumber")
	private long vehiclePlateNumber;
	
	@JsonProperty("FirstPlateLetterID")
	private String firstPlateLetterID;
	
	@JsonProperty("SecondPlateLetterID")
	private String secondPlateLetterID;
	
	@JsonProperty("ThirdPlateLetterID")
	private String thirdPlateLetterID;
	
	@JsonProperty("VehicleMakeCodeNajm")
	private int vehicleMakeCodeNajm;
	
	@JsonProperty("VehicleMakeCodeNIC")
	private int vehicleMakeCodeNIC;
	
	@JsonProperty("VehicleMakeTextNIC")
	private String vehicleMakeTextNIC;
	
	@JsonProperty("VehicleMakeCodeTameeni")
	private int vehicleMakeCodeTameeni;
	
	@JsonProperty("VehicleModelCodeNajm")
	private int vehicleModelCodeNajm;
	
	@JsonProperty("VehicleModelCodeNIC")
	private int vehicleModelCodeNIC;
	
	@JsonProperty("VehicleModelTextNIC")
	private String vehicleModelTextNIC;
	
	@JsonProperty("VehicleModelCodeTameeni")
	private int vehicleModelCodeTameeni;
	
	@JsonProperty("ManufactureYear")
	private int manufactureYear;
	
	@JsonProperty("VehicleColorCode")
	private int vehicleColorCode;
	
	@JsonProperty("VehicleRegistrationCityCode")
	private int vehicleRegistrationCityCode;
	
	@JsonProperty("VehicleVIN")
	private String vehicleVIN;
	
	@JsonProperty("VehicleRegistrationExpiryDate")
	private String vehicleRegistrationExpiryDate;
	
	@JsonProperty("PolicyTitleID")
	private int policyTitleID;
	
	@JsonProperty("PolicyNumber")
	private String policyNumber;
	
	@JsonProperty("PolicyIssueDate")
	private String policyIssueDate;
	
	@JsonProperty("PolicyEffectiveDate")
	private String policyEffectiveDate;
	
	@JsonProperty("PolicyExpiryDate")
	private String policyExpiryDate;
	
	@JsonProperty("MobileNo")
	private String mobileNo;
	
	@JsonProperty("BuildingNumber")
	private String buildingNumber;
	
	@JsonProperty("Street")
	private String street;
	
	@JsonProperty("District")
	private String district;
	
	@JsonProperty("City")
	private String city;
	
	@JsonProperty("ZipCode")
	private int zipCode;
	
	@JsonProperty("AdditionalNumber")
	private int additionalNumber;
	
	@JsonProperty("VehicleWeight")
	private int vehicleWeight;
	
	@JsonProperty("VehicleBodyCode")
	private int vehicleBodyCode;
	
	@JsonProperty("CoverAgeLimitID")
	private int coverAgeLimitID;
	
	@JsonProperty("DriverDetails")
	private List<DriverDetails> driverDetailsList;
	
	@JsonProperty("VehicleSumInsured")
	private int vehicleSumInsured;
	
	@JsonProperty("RepairMethod")
	private int repairMethod;
	
	@JsonProperty("DeductibleAmount")
	private int deductibleAmount;
	
	@JsonProperty("PolicyPremium")
	private int policyPremium;
	
	@JsonProperty("PremiumBreakdown")
	private List<PremiumBreakdown> premiumBreakdownList;
	
	@JsonProperty("PolicyPremiumFeatures")
	private List<PolicyPremiumFeature> policyPremiumFeaturesList;
	
	@JsonProperty("IsPrimaryDriver")
	private boolean isPrimaryDriver;
	
	@JsonProperty("PrimaryDriverID")
	private int primaryDriverID;
	
	@JsonProperty("PrimaryDriverName")
	private String primaryDriverName;
	
	@JsonProperty("PrimaryDriverDateOfBirthG")
	private String primaryDriverDateOfBirthG;
	
	@JsonProperty("PrimaryDriverDateOfBirthH")
	private String primaryDriverDateOfBirthH;
	
	@JsonProperty("PrimaryDriverGender")
	private int primaryDriverGender;
	
	@JsonProperty("IsRenewal")
	private boolean isRenewal;
	
	@JsonProperty("Discounts")
	private List<Discounts> discountsList;
	
	@JsonProperty("CustomizedParameter")
	private List<CustomizedParameter> customizedParameterList;

	public long getPolicyholderIdentityTypeCode() {
		return policyholderIdentityTypeCode;
	}

	public void setPolicyholderIdentityTypeCode(long policyholderIdentityTypeCode) {
		this.policyholderIdentityTypeCode = policyholderIdentityTypeCode;
	}

	public long getPolicyHolderID() {
		return policyHolderID;
	}

	public void setPolicyHolderID(long policyHolderID) {
		this.policyHolderID = policyHolderID;
	}

	public long getPurposeofVehicleUseID() {
		return purposeofVehicleUseID;
	}

	public void setPurposeofVehicleUseID(long purposeofVehicleUseID) {
		this.purposeofVehicleUseID = purposeofVehicleUseID;
	}

	public int getQuoteRequestSourceID() {
		return quoteRequestSourceID;
	}

	public void setQuoteRequestSourceID(int quoteRequestSourceID) {
		this.quoteRequestSourceID = quoteRequestSourceID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getArabicFirstName() {
		return arabicFirstName;
	}

	public void setArabicFirstName(String arabicFirstName) {
		this.arabicFirstName = arabicFirstName;
	}

	public String getArabicMiddleName() {
		return arabicMiddleName;
	}

	public void setArabicMiddleName(String arabicMiddleName) {
		this.arabicMiddleName = arabicMiddleName;
	}

	public String getArabicLastName() {
		return arabicLastName;
	}

	public void setArabicLastName(String arabicLastName) {
		this.arabicLastName = arabicLastName;
	}

	public String getEnglishFirstName() {
		return englishFirstName;
	}

	public void setEnglishFirstName(String englishFirstName) {
		this.englishFirstName = englishFirstName;
	}

	public String getEnglishMiddleName() {
		return englishMiddleName;
	}

	public void setEnglishMiddleName(String englishMiddleName) {
		this.englishMiddleName = englishMiddleName;
	}

	public String getEnglishLastName() {
		return englishLastName;
	}

	public void setEnglishLastName(String englishLastName) {
		this.englishLastName = englishLastName;
	}

	public String getDateOfBirthG() {
		return dateOfBirthG;
	}

	public void setDateOfBirthG(String dateOfBirthG) {
		this.dateOfBirthG = dateOfBirthG;
	}

	public String getDateOfBirthH() {
		return dateOfBirthH;
	}

	public void setDateOfBirthH(String dateOfBirthH) {
		this.dateOfBirthH = dateOfBirthH;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public long getCylinders() {
		return cylinders;
	}

	public void setCylinders(long cylinders) {
		this.cylinders = cylinders;
	}

	public int getVehicleCapacity() {
		return vehicleCapacity;
	}

	public void setVehicleCapacity(int vehicleCapacity) {
		this.vehicleCapacity = vehicleCapacity;
	}

	public int getPolicyholderNationalityID() {
		return policyholderNationalityID;
	}

	public void setPolicyholderNationalityID(int policyholderNationalityID) {
		this.policyholderNationalityID = policyholderNationalityID;
	}

	public int getVehicleUniqueTypeID() {
		return vehicleUniqueTypeID;
	}

	public void setVehicleUniqueTypeID(int vehicleUniqueTypeID) {
		this.vehicleUniqueTypeID = vehicleUniqueTypeID;
	}

	public long getVehicleSequenceNumber() {
		return vehicleSequenceNumber;
	}

	public void setVehicleSequenceNumber(long vehicleSequenceNumber) {
		this.vehicleSequenceNumber = vehicleSequenceNumber;
	}

	public int getVehicleCustomID() {
		return vehicleCustomID;
	}

	public void setVehicleCustomID(int vehicleCustomID) {
		this.vehicleCustomID = vehicleCustomID;
	}

	public boolean isDriverDisabled() {
		return isDriverDisabled;
	}

	public void setDriverDisabled(boolean isDriverDisabled) {
		this.isDriverDisabled = isDriverDisabled;
	}

	public int getPolicyholderGender() {
		return policyholderGender;
	}

	public void setPolicyholderGender(int policyholderGender) {
		this.policyholderGender = policyholderGender;
	}

	public int getVehicleDriveCityID() {
		return vehicleDriveCityID;
	}

	public void setVehicleDriveCityID(int vehicleDriveCityID) {
		this.vehicleDriveCityID = vehicleDriveCityID;
	}

	public int getVehiclePlateTypeID() {
		return vehiclePlateTypeID;
	}

	public void setVehiclePlateTypeID(int vehiclePlateTypeID) {
		this.vehiclePlateTypeID = vehiclePlateTypeID;
	}

	public long getVehiclePlateNumber() {
		return vehiclePlateNumber;
	}

	public void setVehiclePlateNumber(long vehiclePlateNumber) {
		this.vehiclePlateNumber = vehiclePlateNumber;
	}

	public String getFirstPlateLetterID() {
		return firstPlateLetterID;
	}

	public void setFirstPlateLetterID(String firstPlateLetterID) {
		this.firstPlateLetterID = firstPlateLetterID;
	}

	public String getSecondPlateLetterID() {
		return secondPlateLetterID;
	}

	public void setSecondPlateLetterID(String secondPlateLetterID) {
		this.secondPlateLetterID = secondPlateLetterID;
	}

	public String getThirdPlateLetterID() {
		return thirdPlateLetterID;
	}

	public void setThirdPlateLetterID(String thirdPlateLetterID) {
		this.thirdPlateLetterID = thirdPlateLetterID;
	}

	public int getVehicleMakeCodeNajm() {
		return vehicleMakeCodeNajm;
	}

	public void setVehicleMakeCodeNajm(int vehicleMakeCodeNajm) {
		this.vehicleMakeCodeNajm = vehicleMakeCodeNajm;
	}

	public int getVehicleMakeCodeNIC() {
		return vehicleMakeCodeNIC;
	}

	public void setVehicleMakeCodeNIC(int vehicleMakeCodeNIC) {
		this.vehicleMakeCodeNIC = vehicleMakeCodeNIC;
	}

	public String getVehicleMakeTextNIC() {
		return vehicleMakeTextNIC;
	}

	public void setVehicleMakeTextNIC(String vehicleMakeTextNIC) {
		this.vehicleMakeTextNIC = vehicleMakeTextNIC;
	}

	public int getVehicleMakeCodeTameeni() {
		return vehicleMakeCodeTameeni;
	}

	public void setVehicleMakeCodeTameeni(int vehicleMakeCodeTameeni) {
		this.vehicleMakeCodeTameeni = vehicleMakeCodeTameeni;
	}

	public int getVehicleModelCodeNajm() {
		return vehicleModelCodeNajm;
	}

	public void setVehicleModelCodeNajm(int vehicleModelCodeNajm) {
		this.vehicleModelCodeNajm = vehicleModelCodeNajm;
	}

	public int getVehicleModelCodeNIC() {
		return vehicleModelCodeNIC;
	}

	public void setVehicleModelCodeNIC(int vehicleModelCodeNIC) {
		this.vehicleModelCodeNIC = vehicleModelCodeNIC;
	}

	public String getVehicleModelTextNIC() {
		return vehicleModelTextNIC;
	}

	public void setVehicleModelTextNIC(String vehicleModelTextNIC) {
		this.vehicleModelTextNIC = vehicleModelTextNIC;
	}

	public int getVehicleModelCodeTameeni() {
		return vehicleModelCodeTameeni;
	}

	public void setVehicleModelCodeTameeni(int vehicleModelCodeTameeni) {
		this.vehicleModelCodeTameeni = vehicleModelCodeTameeni;
	}

	public int getManufactureYear() {
		return manufactureYear;
	}

	public void setManufactureYear(int manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	public int getVehicleColorCode() {
		return vehicleColorCode;
	}

	public void setVehicleColorCode(int vehicleColorCode) {
		this.vehicleColorCode = vehicleColorCode;
	}

	public int getVehicleRegistrationCityCode() {
		return vehicleRegistrationCityCode;
	}

	public void setVehicleRegistrationCityCode(int vehicleRegistrationCityCode) {
		this.vehicleRegistrationCityCode = vehicleRegistrationCityCode;
	}

	public String getVehicleVIN() {
		return vehicleVIN;
	}

	public void setVehicleVIN(String vehicleVIN) {
		this.vehicleVIN = vehicleVIN;
	}

	public String getVehicleRegistrationExpiryDate() {
		return vehicleRegistrationExpiryDate;
	}

	public void setVehicleRegistrationExpiryDate(String vehicleRegistrationExpiryDate) {
		this.vehicleRegistrationExpiryDate = vehicleRegistrationExpiryDate;
	}

	public int getPolicyTitleID() {
		return policyTitleID;
	}

	public void setPolicyTitleID(int policyTitleID) {
		this.policyTitleID = policyTitleID;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicyIssueDate() {
		return policyIssueDate;
	}

	public void setPolicyIssueDate(String policyIssueDate) {
		this.policyIssueDate = policyIssueDate;
	}

	public String getPolicyEffectiveDate() {
		return policyEffectiveDate;
	}

	public void setPolicyEffectiveDate(String policyEffectiveDate) {
		this.policyEffectiveDate = policyEffectiveDate;
	}

	public String getPolicyExpiryDate() {
		return policyExpiryDate;
	}

	public void setPolicyExpiryDate(String policyExpiryDate) {
		this.policyExpiryDate = policyExpiryDate;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getAdditionalNumber() {
		return additionalNumber;
	}

	public void setAdditionalNumber(int additionalNumber) {
		this.additionalNumber = additionalNumber;
	}

	public int getVehicleWeight() {
		return vehicleWeight;
	}

	public void setVehicleWeight(int vehicleWeight) {
		this.vehicleWeight = vehicleWeight;
	}

	public int getVehicleBodyCode() {
		return vehicleBodyCode;
	}

	public void setVehicleBodyCode(int vehicleBodyCode) {
		this.vehicleBodyCode = vehicleBodyCode;
	}

	public int getCoverAgeLimitID() {
		return coverAgeLimitID;
	}

	public void setCoverAgeLimitID(int coverAgeLimitID) {
		this.coverAgeLimitID = coverAgeLimitID;
	}

	public List<DriverDetails> getDriverDetailsList() {
		return driverDetailsList;
	}

	public void setDriverDetailsList(List<DriverDetails> driverDetailsList) {
		this.driverDetailsList = driverDetailsList;
	}

	public int getVehicleSumInsured() {
		return vehicleSumInsured;
	}

	public void setVehicleSumInsured(int vehicleSumInsured) {
		this.vehicleSumInsured = vehicleSumInsured;
	}

	public int getRepairMethod() {
		return repairMethod;
	}

	public void setRepairMethod(int repairMethod) {
		this.repairMethod = repairMethod;
	}

	public int getDeductibleAmount() {
		return deductibleAmount;
	}

	public void setDeductibleAmount(int deductibleAmount) {
		this.deductibleAmount = deductibleAmount;
	}

	public int getPolicyPremium() {
		return policyPremium;
	}

	public void setPolicyPremium(int policyPremium) {
		this.policyPremium = policyPremium;
	}

	public List<PremiumBreakdown> getPremiumBreakdownList() {
		return premiumBreakdownList;
	}

	public void setPremiumBreakdownList(List<PremiumBreakdown> premiumBreakdownList) {
		this.premiumBreakdownList = premiumBreakdownList;
	}

	public List<PolicyPremiumFeature> getPolicyPremiumFeaturesList() {
		return policyPremiumFeaturesList;
	}

	public void setPolicyPremiumFeaturesList(List<PolicyPremiumFeature> policyPremiumFeaturesList) {
		this.policyPremiumFeaturesList = policyPremiumFeaturesList;
	}

	public boolean isPrimaryDriver() {
		return isPrimaryDriver;
	}

	public void setPrimaryDriver(boolean isPrimaryDriver) {
		this.isPrimaryDriver = isPrimaryDriver;
	}

	public int getPrimaryDriverID() {
		return primaryDriverID;
	}

	public void setPrimaryDriverID(int primaryDriverID) {
		this.primaryDriverID = primaryDriverID;
	}

	public String getPrimaryDriverName() {
		return primaryDriverName;
	}

	public void setPrimaryDriverName(String primaryDriverName) {
		this.primaryDriverName = primaryDriverName;
	}

	public String getPrimaryDriverDateOfBirthG() {
		return primaryDriverDateOfBirthG;
	}

	public void setPrimaryDriverDateOfBirthG(String primaryDriverDateOfBirthG) {
		this.primaryDriverDateOfBirthG = primaryDriverDateOfBirthG;
	}

	public String getPrimaryDriverDateOfBirthH() {
		return primaryDriverDateOfBirthH;
	}

	public void setPrimaryDriverDateOfBirthH(String primaryDriverDateOfBirthH) {
		this.primaryDriverDateOfBirthH = primaryDriverDateOfBirthH;
	}

	public int getPrimaryDriverGender() {
		return primaryDriverGender;
	}

	public void setPrimaryDriverGender(int primaryDriverGender) {
		this.primaryDriverGender = primaryDriverGender;
	}

	public boolean isRenewal() {
		return isRenewal;
	}

	public void setRenewal(boolean isRenewal) {
		this.isRenewal = isRenewal;
	}

	public List<Discounts> getDiscountsList() {
		return discountsList;
	}

	public void setDiscountsList(List<Discounts> discountsList) {
		this.discountsList = discountsList;
	}

	public List<CustomizedParameter> getCustomizedParameterList() {
		return customizedParameterList;
	}

	public void setCustomizedParameterList(List<CustomizedParameter> customizedParameterList) {
		this.customizedParameterList = customizedParameterList;
	}
	
}
