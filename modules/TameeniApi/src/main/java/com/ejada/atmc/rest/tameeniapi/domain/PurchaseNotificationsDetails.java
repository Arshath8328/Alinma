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

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Kareem Kahil
 *
 */
@XmlRootElement
public class PurchaseNotificationsDetails
{
	private int purchaseStatus;
	
	private String email;
	
	private int mobileNo;
	
	private int buildingNumber;
	
	private String street;
	
	private String district;
	
	private String city;
	
	private int zipCode;
	
	private int additionalNumber;
	
	private long creditNoteNumber;
	
	private double creditAmount;
	
	private String ibanNumber;
	
	private String bankCode;
	
	private List<CustomizedParameter> customizedParameterList;

	@XmlElement(name = "PurchaseStatus")
	public int getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(int purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
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
	public long getCreditNoteNumber() {
		return creditNoteNumber;
	}

	public void setCreditNoteNumber(long creditNoteNumber) {
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
