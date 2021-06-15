/*
 * TariffOutput.java Feb 1, 2018  
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
package com.ejada.atmc.acl.db.domain.tariff;

/**
 * @author Sarah Taher
 *
 */

public class TariffOutput {
	private String flag;
	private double baseRate;
	private double basePremium;
	//updated by staher
	private double agencyRepair;
	private double driverAgeLess21;
	private double ded500Prem;
	private double ded1000Prem;
	private double ded1500Prem;
	private double ded2000Prem;
	private double ded2500Prem;
	private double ded5000Prem;
	private double pabPassenger;
	private double motorLoading;
	private double loyalityDiscount;
	private double loyalityPercentage;
	private double ncdDiscount;
	private double ncdPercentage;
	private double policyFees;
	private double vatFees;
	private String uniqueIdentifier;
	private Integer serialNumber;
	private String code;
	private String tameeniCode;
	private String productName;
	private String coverType;
	private String premiumRate;
	private String loadingPercentage; 
	private String minimumPremium;
	private String excessAmount;
	private String isAutofill;
	private String premiumAmount;
	private String applicableCoverType;
	private String basicCover;
	private String reason;
	
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getLoadingPercentage() {
		return loadingPercentage;
	}
	public void setLoadingPercentage(String loadingPercentage) {
		this.loadingPercentage = loadingPercentage;
	}
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTameeniCode() {
		return tameeniCode;
	}
	public void setTameeniCode(String tameeniCode) {
		this.tameeniCode = tameeniCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productCode) {
		this.productName = productCode;
	}
	public String getCoverType() {
		return coverType;
	}
	public void setCoverType(String coverType) {
		this.coverType = coverType;
	}
	public String getPremiumRate() {
		return premiumRate;
	}
	public void setPremiumRate(String premiumRate) {
		this.premiumRate = premiumRate;
	}
	public String getMinimumPremium() {
		return minimumPremium;
	}
	public void setMinimumPremium(String minimumPremium) {
		this.minimumPremium = minimumPremium;
	}
	public String getExcessAmount() {
		return excessAmount;
	}
	public void setExcessAmount(String excessAmount) {
		this.excessAmount = excessAmount;
	}
	public String getIsAutofill() {
		return isAutofill;
	}
	public void setIsAutofill(String isAutofill) {
		this.isAutofill = isAutofill;
	}
	public String getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(String premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public String getApplicableCoverType() {
		return applicableCoverType;
	}
	public void setApplicableCoverType(String applicableCoverType) {
		this.applicableCoverType = applicableCoverType;
	}
	public String getBasicCover() {
		return basicCover;
	}
	public void setBasicCover(String basicCover) {
		this.basicCover = basicCover;
	}

	
	
	@Override
	public String toString() {
		return "TariffOutput [uniqueIdentifier=" + uniqueIdentifier + ", serialNumber=" + serialNumber + ", code="
				+ code + ", tameeniCode=" + tameeniCode + ", productName=" + productName + ", coverType=" + coverType
				+ ", premiumRate=" + premiumRate + ", minimumPremium=" + minimumPremium + ", excessAmount="
				+ excessAmount + ", isAutofill=" + isAutofill + ", premiumAmount=" + premiumAmount
				+ ", applicableCoverType=" + applicableCoverType + ", basicCover=" + basicCover + ",reason=" + reason +"]";
	}
	
	
	
	
	
	public String getUniqueIdentifier() {
		return uniqueIdentifier;
	}
	public void setUniqueIdentifier(String uniqueIdentifier) {
		this.uniqueIdentifier = uniqueIdentifier;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public double getBaseRate() {
		return baseRate;
	}
	public void setBaseRate(double baseRate) {
		this.baseRate = baseRate;
	}
	/**
	 * @return the basePremium
	 */
	public double getBasePremium() {
		return basePremium;
	}
	/**
	 * @param basePremium the basePremium to set
	 */
	public void setBasePremium(double basePremium) {
		this.basePremium = basePremium;
	}
	/**
	 * @return the agencyRepair
	 */
	public double getAgencyRepair() {
		return agencyRepair;
	}
	/**
	 * @param agencyRepair the agencyRepair to set
	 */
	public void setAgencyRepair(double agencyRepair) {
		this.agencyRepair = agencyRepair;
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
	/**
	 * @return the ded500Prem
	 */
	public double getDed500Prem() {
		return ded500Prem;
	}
	/**
	 * @param ded500Prem the ded500Prem to set
	 */
	public void setDed500Prem(double ded500Prem) {
		this.ded500Prem = ded500Prem;
	}
	/**
	 * @return the ded1000Prem
	 */
	public double getDed1000Prem() {
		return ded1000Prem;
	}
	/**
	 * @param ded1000Prem the ded1000Prem to set
	 */
	public void setDed1000Prem(double ded1000Prem) {
		this.ded1000Prem = ded1000Prem;
	}
	/**
	 * @return the ded1500Prem
	 */
	public double getDed1500Prem() {
		return ded1500Prem;
	}
	/**
	 * @param ded1500Prem the ded1500Prem to set
	 */
	public void setDed1500Prem(double ded1500Prem) {
		this.ded1500Prem = ded1500Prem;
	}
	/**
	 * @return the ded2000Prem
	 */
	public double getDed2000Prem() {
		return ded2000Prem;
	}
	/**
	 * @param ded2000Prem the ded2000Prem to set
	 */
	public void setDed2000Prem(double ded2000Prem) {
		this.ded2000Prem = ded2000Prem;
	}
	/**
	 * @return the ded2500Prem
	 */
	public double getDed2500Prem() {
		return ded2500Prem;
	}
	/**
	 * @param ded2500Prem the ded2500Prem to set
	 */
	public void setDed2500Prem(double ded2500Prem) {
		this.ded2500Prem = ded2500Prem;
	}
	/**
	 * @return the ded5000Prem
	 */
	public double getDed5000Prem() {
		return ded5000Prem;
	}
	/**
	 * @param ded5000Prem the ded5000Prem to set
	 */
	public void setDed5000Prem(double ded5000Prem) {
		this.ded5000Prem = ded5000Prem;
	}
	/**
	 * @return the pabPassenger
	 */
	public double getPabPassenger() {
		return pabPassenger;
	}
	/**
	 * @param pabPassenger the pabPassenger to set
	 */
	public void setPabPassenger(double pabPassenger) {
		this.pabPassenger = pabPassenger;
	}
	/**
	 * @return the motorLoading
	 */
	public double getMotorLoading() {
		return motorLoading;
	}
	/**
	 * @param motorLoading the motorLoading to set
	 */
	public void setMotorLoading(double motorLoading) {
		this.motorLoading = motorLoading;
	}
	/**
	 * @return the loyalityDiscount
	 */
	public double getLoyalityDiscount() {
		return loyalityDiscount;
	}
	/**
	 * @param loyalityDiscount the loyalityDiscount to set
	 */
	public void setLoyalityDiscount(double loyalityDiscount) {
		this.loyalityDiscount = loyalityDiscount;
	}
	/**
	 * @return the loyalityPercentage
	 */
	public double getLoyalityPercentage() {
		return loyalityPercentage;
	}
	/**
	 * @param loyalityPercentage the loyalityPercentage to set
	 */
	public void setLoyalityPercentage(double loyalityPercentage) {
		this.loyalityPercentage = loyalityPercentage;
	}
	/**
	 * @return the ncdDiscount
	 */
	public double getNcdDiscount() {
		return ncdDiscount;
	}
	/**
	 * @param ncdDiscount the ncdDiscount to set
	 */
	public void setNcdDiscount(double ncdDiscount) {
		this.ncdDiscount = ncdDiscount;
	}
	/**
	 * @return the ncdPercentage
	 */
	public double getNcdPercentage() {
		return ncdPercentage;
	}
	/**
	 * @param ncdPercentage the ncdPercentage to set
	 */
	public void setNcdPercentage(double ncdPercentage) {
		this.ncdPercentage = ncdPercentage;
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
	 * @return the vatFees
	 */
	public double getVatFees() {
		return vatFees;
	}
	/**
	 * @param vatFees the vatFees to set
	 */
	public void setVatFees(double vatFees) {
		this.vatFees = vatFees;
	}
}
