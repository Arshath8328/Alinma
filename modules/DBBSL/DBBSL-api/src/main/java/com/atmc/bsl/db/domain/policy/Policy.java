/*
 * Policy.java Jan 4, 2018  
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
package com.atmc.bsl.db.domain.policy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ghada Shawkat
 *
 */
public class Policy {
	private String policyNo;
	private String iqamaId;
	private String policyStatus;
	private String policyStatusAr;
	private String policyStatusEn;
	private String product;
	private String productEn;
	private String productAr;
	private Date inceptionDate;
	private Date expiryDate;
	private long sumInsured;
	private long totalPremium;
	private long policyFees;
	private String policyTaxes;
	private long policyTerm;
	private String premium;
	private long countPremMissed;
	private String modeOfPayment;
	private String modeOfPaymentEn;
	private String modeOfPaymentAr;
	private Date nextRenwalDate;
	private Date nextDueDate;
	private String custName;
	private Date custBirthDate;
	private String insuredName;
	private Date insuredBirthDate;
	private String insuredId;
	private String insuredMobile;
	private String insuredEmail;
	private String insuredAddr;
	private String insuredGender;
	private String occuptation;
	private Date estExpiryDate;
	private String najmStatus;
	private long surrenderValue;
	private long noOfRisk;
	private String memberScheme;
	private String memberBenefits;
	private List<PolicyVehicle> policyVehs;
	private List<PolicyMember> policyMembers;
	private PolicyPayment policyPayment;
	private List<PolicyVehicleCover> policyRiders;
	private List<PolicyFund> policyFunds;
	private List<PolicyBeneficiary> policyBenfs;

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
	 * @return the iqamaId
	 */
	public String getIqamaId() {
		return iqamaId;
	}

	/**
	 * @param iqamaId the iqamaId to set
	 */
	public void setIqamaId(String iqamaId) {
		this.iqamaId = iqamaId;
	}

	/**
	 * @return the policyStatus
	 */
	public String getPolicyStatus() {
		return policyStatus;
	}

	/**
	 * @param policyStatus the policyStatus to set
	 */
	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	/**
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}

	/**
	 * @return the inceptionDate
	 */
	public Date getInceptionDate() {
		return inceptionDate;
	}

	/**
	 * @param inceptionDate the inceptionDate to set
	 */
	public void setInceptionDate(Date inceptionDate) {
		this.inceptionDate = inceptionDate;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the sumInsured
	 */
	public long getSumInsured() {
		return sumInsured;
	}

	/**
	 * @param sumInsured the sumInsured to set
	 */
	public void setSumInsured(long sumInsured) {
		this.sumInsured = sumInsured;
	}

	/**
	 * @return the totalPremium
	 */
	public long getTotalPremium() {
		return totalPremium;
	}

	/**
	 * @param totalPremium the totalPremium to set
	 */
	public void setTotalPremium(long totalPremium) {
		this.totalPremium = totalPremium;
	}

	/**
	 * @return the policyFees
	 */
	public long getPolicyFees() {
		return policyFees;
	}

	/**
	 * @param policyFees the policyFees to set
	 */
	public void setPolicyFees(long policyFees) {
		this.policyFees = policyFees;
	}

	/**
	 * @return the policyTaxes
	 */
	public String getPolicyTaxes() {
		return policyTaxes;
	}

	/**
	 * @param policyTaxes the policyTaxes to set
	 */
	public void setPolicyTaxes(String policyTaxes) {
		this.policyTaxes = policyTaxes;
	}

	/**
	 * @return the policyTerm
	 */
	public long getPolicyTerm() {
		return policyTerm;
	}

	/**
	 * @param policyTerm the policyTerm to set
	 */
	public void setPolicyTerm(long policyTerm) {
		this.policyTerm = policyTerm;
	}

	/**
	 * @return the premium
	 */
	public String getPremium() {
		return premium;
	}

	/**
	 * @param premium the premium to set
	 */
	public void setPremium(String premium) {
		this.premium = premium;
	}

	/**
	 * @return the countPremMissed
	 */
	public long getCountPremMissed() {
		return countPremMissed;
	}

	/**
	 * @param countPremMissed the countPremMissed to set
	 */
	public void setCountPremMissed(long countPremMissed) {
		this.countPremMissed = countPremMissed;
	}

	/**
	 * @return the modeOfPayment
	 */
	public String getModeOfPayment() {
		return modeOfPayment;
	}

	/**
	 * @param modeOfPayment the modeOfPayment to set
	 */
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	/**
	 * @return the nextRenwalDate
	 */
	public Date getNextRenwalDate() {
		return nextRenwalDate;
	}

	/**
	 * @param nextRenwalDate the nextRenwalDate to set
	 */
	public void setNextRenwalDate(Date nextRenwalDate) {
		this.nextRenwalDate = nextRenwalDate;
	}

	/**
	 * @return the custName
	 */
	public String getCustName() {
		return custName;
	}

	/**
	 * @param custName the custName to set
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * @return the custBirthDate
	 */
	public Date getCustBirthDate() {
		return custBirthDate;
	}

	/**
	 * @param custBirthDate the custBirthDate to set
	 */
	public void setCustBirthDate(Date custBirthDate) {
		this.custBirthDate = custBirthDate;
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
	 * @return the insuredBirthDate
	 */
	public Date getInsuredBirthDate() {
		return insuredBirthDate;
	}

	/**
	 * @param insuredBirthDate the insuredBirthDate to set
	 */
	public void setInsuredBirthDate(Date insuredBirthDate) {
		this.insuredBirthDate = insuredBirthDate;
	}

	/**
	 * @return the insuredId
	 */
	public String getInsuredId() {
		return insuredId;
	}

	/**
	 * @param insuredId the insuredId to set
	 */
	public void setInsuredId(String insuredId) {
		this.insuredId = insuredId;
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
	 * @return the insuredAddr
	 */
	public String getInsuredAddr() {
		return insuredAddr;
	}

	/**
	 * @param insuredAddr the insuredAddr to set
	 */
	public void setInsuredAddr(String insuredAddr) {
		this.insuredAddr = insuredAddr;
	}

	public String getInsuredGender() {
		return insuredGender;
	}

	public void setInsuredGender(String insuredGender) {
		this.insuredGender = insuredGender;
	}

	/**
	 * @return the occuptation
	 */
	public String getOccuptation() {
		return occuptation;
	}

	/**
	 * @param occuptation the occuptation to set
	 */
	public void setOccuptation(String occuptation) {
		this.occuptation = occuptation;
	}

	/**
	 * @return the estExpiryDate
	 */
	public Date getEstExpiryDate() {
		return estExpiryDate;
	}

	/**
	 * @param estExpiryDate the estExpiryDate to set
	 */
	public void setEstExpiryDate(Date estExpiryDate) {
		this.estExpiryDate = estExpiryDate;
	}

	/**
	 * @return the najmStatus
	 */
	public String getNajmStatus() {
		return najmStatus;
	}

	/**
	 * @param najmStatus the najmStatus to set
	 */
	public void setNajmStatus(String najmStatus) {
		this.najmStatus = najmStatus;
	}

	/**
	 * @return the surrenderValue
	 */
	public long getSurrenderValue() {
		return surrenderValue;
	}

	/**
	 * @param surrenderValue the surrenderValue to set
	 */
	public void setSurrenderValue(long surrenderValue) {
		this.surrenderValue = surrenderValue;
	}

	/**
	 * @return the noOfRisk
	 */
	public long getNoOfRisk() {
		return noOfRisk;
	}

	/**
	 * @param noOfRisk the noOfRisk to set
	 */
	public void setNoOfRisk(long noOfRisk) {
		this.noOfRisk = noOfRisk;
	}

	/**
	 * @return the memberScheme
	 */
	public String getMemberScheme() {
		return memberScheme;
	}

	/**
	 * @param memberScheme the memberScheme to set
	 */
	public void setMemberScheme(String memberScheme) {
		this.memberScheme = memberScheme;
	}

	/**
	 * @return the memberBenefits
	 */
	public String getMemberBenefits() {
		return memberBenefits;
	}

	/**
	 * @param memberBenefits the memberBenefits to set
	 */
	public void setMemberBenefits(String memberBenefits) {
		this.memberBenefits = memberBenefits;
	}

	/**
	 * @return the policyVehs
	 */
	public List<PolicyVehicle> getPolicyVehs() {
		if (policyVehs == null)
			policyVehs = new ArrayList<>();
		return policyVehs;
	}

	/**
	 * @param policyVehs the policyVehs to set
	 */
	public void setPolicyVehs(List<PolicyVehicle> policyVehs) {
		this.policyVehs = policyVehs;
	}

	/**
	 * @return the nextDueDate
	 */
	public Date getNextDueDate() {
		return nextDueDate;
	}

	/**
	 * @param nextDueDate the nextDueDate to set
	 */
	public void setNextDueDate(Date nextDueDate) {
		this.nextDueDate = nextDueDate;
	}

	/**
	 * @return the policyStatusAr
	 */
	public String getPolicyStatusAr() {
		return policyStatusAr;
	}

	/**
	 * @param policyStatusAr the policyStatusAr to set
	 */
	public void setPolicyStatusAr(String policyStatusAr) {
		this.policyStatusAr = policyStatusAr;
	}

	/**
	 * @return the policyStatusEn
	 */
	public String getPolicyStatusEn() {
		return policyStatusEn;
	}

	/**
	 * @param policyStatusEn the policyStatusEn to set
	 */
	public void setPolicyStatusEn(String policyStatusEn) {
		this.policyStatusEn = policyStatusEn;
	}

	/**
	 * @return the policyMembers
	 */
	public List<PolicyMember> getPolicyMembers() {
		if (policyMembers == null)
			policyMembers = new ArrayList<>();
		return policyMembers;
	}

	/**
	 * @param policyMembers the policyMembers to set
	 */
	public void setPolicyMembers(List<PolicyMember> policyMembers) {
		this.policyMembers = policyMembers;
	}

	/**
	 * @return the policyPayment
	 */
	public PolicyPayment getPolicyPayment() {
		return policyPayment;
	}

	/**
	 * @param policyPayment the policyPayment to set
	 */
	public void setPolicyPayment(PolicyPayment policyPayment) {
		this.policyPayment = policyPayment;
	}

	/**
	 * @return the modeOfPaymentEn
	 */
	public String getModeOfPaymentEn() {
		return modeOfPaymentEn;
	}

	/**
	 * @param modeOfPaymentEn the modeOfPaymentEn to set
	 */
	public void setModeOfPaymentEn(String modeOfPaymentEn) {
		this.modeOfPaymentEn = modeOfPaymentEn;
	}

	/**
	 * @return the modeOfPaymentAr
	 */
	public String getModeOfPaymentAr() {
		return modeOfPaymentAr;
	}

	/**
	 * @param modeOfPaymentAr the modeOfPaymentAr to set
	 */
	public void setModeOfPaymentAr(String modeOfPaymentAr) {
		this.modeOfPaymentAr = modeOfPaymentAr;
	}

	/**
	 * @return the policyRiders
	 */
	public List<PolicyVehicleCover> getPolicyRiders() {
		if (policyRiders == null)
			policyRiders = new ArrayList<>();
		return policyRiders;
	}

	/**
	 * @param policyRiders the policyRiders to set
	 */
	public void setPolicyRiders(List<PolicyVehicleCover> policyRiders) {
		this.policyRiders = policyRiders;
	}

	/**
	 * @return the policyFunds
	 */
	public List<PolicyFund> getPolicyFunds() {
		if (policyFunds == null)
			policyFunds = new ArrayList<>();
		return policyFunds;
	}

	/**
	 * @param policyFunds the policyFunds to set
	 */
	public void setPolicyFunds(List<PolicyFund> policyFunds) {
		this.policyFunds = policyFunds;
	}

	/**
	 * @return the policyBenfs
	 */
	public List<PolicyBeneficiary> getPolicyBenfs() {
		if (policyBenfs == null)
			policyBenfs = new ArrayList<>();
		return policyBenfs;
	}

	/**
	 * @param policyBenfs the policyBenfs to set
	 */
	public void setPolicyBenfs(List<PolicyBeneficiary> policyBenfs) {
		this.policyBenfs = policyBenfs;
	}

	/**
	 * @return the productEn
	 */
	public String getProductEn() {
		return productEn;
	}

	/**
	 * @param productEn the productEn to set
	 */
	public void setProductEn(String productEn) {
		this.productEn = productEn;
	}

	/**
	 * @return the productAr
	 */
	public String getProductAr() {
		return productAr;
	}

	/**
	 * @param productAr the productAr to set
	 */
	public void setProductAr(String productAr) {
		this.productAr = productAr;
	}

}
