package com.ejada.atmc.rest.tameeniapi.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Ehab
 *
 */
@XmlRootElement
public class PurchaseNotificationsRequest {

	private int requestReferenceNoTP;
	
	private int requestReferenceNoOD;
	
	private int insuranceCompanyCode;
	
	private int insuranceTypeID;
	
	private int quoteReferenceNoTP;
	
	private int PolicyReferenceNoOD;
	
	private boolean isPurchased;
	
	private String email;
	
	private int mobileNo;
	
	private int buildingNumber;
	
	private String street;
	
	private String district;
	
	private String city;
	
	private int zipCode;
	
	private int additionalNumber;
	
	private int creditNoteNumber;
	
	private double creditAmount;
	
	private String ibanNumber;
	
	private String bankCode;
	
	private List<CustomizedParameter> customizedParameterList;

	@XmlElement(name = "RequestReferenceNo")
	public int getRequestReferenceNoTP() {
		return requestReferenceNoTP;
	}

	public void setRequestReferenceNoTP(int requestReferenceNoTP) {
		this.requestReferenceNoTP = requestReferenceNoTP;
	}

	@XmlElement(name = "PolicyRequestReferenceNo")
	public int getRequestReferenceNoOD() {
		return requestReferenceNoOD;
	}

	public void setRequestReferenceNoOD(int requestReferenceNoOD) {
		this.requestReferenceNoOD = requestReferenceNoOD;
	}

	@XmlElement(name = "InsuranceCompanyCode")
	public int getInsuranceCompanyCode() {
		return insuranceCompanyCode;
	}

	public void setInsuranceCompanyCode(int insuranceCompanyCode) {
		this.insuranceCompanyCode = insuranceCompanyCode;
	}

	@XmlElement(name = "InsuranceTypeID")
	public int getInsuranceTypeID() {
		return insuranceTypeID;
	}

	public void setInsuranceTypeID(int insuranceTypeID) {
		this.insuranceTypeID = insuranceTypeID;
	}

	@XmlElement(name = "QuoteReferenceNo")
	public int getQuoteReferenceNoTP() {
		return quoteReferenceNoTP;
	}

	public void setQuoteReferenceNoTP(int quoteReferenceNoTP) {
		this.quoteReferenceNoTP = quoteReferenceNoTP;
	}

	@XmlElement(name = "PolicyReferenceNo")
	public int getPolicyReferenceNoOD() {
		return PolicyReferenceNoOD;
	}

	public void setPolicyReferenceNoOD(int policyReferenceNoOD) {
		PolicyReferenceNoOD = policyReferenceNoOD;
	}

	@XmlElement(name = "IsPurchased")
	public boolean isPurchased() {
		return isPurchased;
	}

	public void setPurchased(boolean isPurchased) {
		this.isPurchased = isPurchased;
	}

	@XmlElement(name = "Email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlElement(name = "MobileNo")
	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
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

	@XmlElement(name = "CreditNoteNumber")
	public int getCreditNoteNumber() {
		return creditNoteNumber;
	}

	public void setCreditNoteNumber(int creditNoteNumber) {
		this.creditNoteNumber = creditNoteNumber;
	}

	@XmlElement(name = "CreditAmount")
	public double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}

	@XmlElement(name = "IBANNumber")
	public String getIbanNumber() {
		return ibanNumber;
	}

	public void setIbanNumber(String ibanNumber) {
		this.ibanNumber = ibanNumber;
	}

	@XmlElement(name = "BankCode")
	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	@XmlElement(name = "CustomizedParameter")
	public List<CustomizedParameter> getCustomizedParameterList() {
		return customizedParameterList;
	}

	public void setCustomizedParameterList(List<CustomizedParameter> customizedParameterList) {
		this.customizedParameterList = customizedParameterList;
	}	
}
