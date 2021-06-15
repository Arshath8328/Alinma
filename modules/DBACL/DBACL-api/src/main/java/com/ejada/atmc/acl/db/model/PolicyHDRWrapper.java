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
 * This class is a wrapper for {@link PolicyHDR}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyHDR
 * @generated
 */
public class PolicyHDRWrapper
	extends BaseModelWrapper<PolicyHDR>
	implements ModelWrapper<PolicyHDR>, PolicyHDR {

	public PolicyHDRWrapper(PolicyHDR policyHDR) {
		super(policyHDR);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("policyNo", getPolicyNo());
		attributes.put("iqamaId", getIqamaId());
		attributes.put("policyStatus", getPolicyStatus());
		attributes.put("product", getProduct());
		attributes.put("inceptionDate", getInceptionDate());
		attributes.put("expiryDate", getExpiryDate());
		attributes.put("sumInsured", getSumInsured());
		attributes.put("totalPremium", getTotalPremium());
		attributes.put("policyFees", getPolicyFees());
		attributes.put("policyTaxes", getPolicyTaxes());
		attributes.put("policyTerm", getPolicyTerm());
		attributes.put("premium", getPremium());
		attributes.put("nextDueDate", getNextDueDate());
		attributes.put("countPremMissed", getCountPremMissed());
		attributes.put("modeOfPayment", getModeOfPayment());
		attributes.put("nextRenwalDate", getNextRenwalDate());
		attributes.put("custName", getCustName());
		attributes.put("custBirthDate", getCustBirthDate());
		attributes.put("insuredName", getInsuredName());
		attributes.put("insuredBirthDate", getInsuredBirthDate());
		attributes.put("insuredId", getInsuredId());
		attributes.put("insuredMobile", getInsuredMobile());
		attributes.put("insuredEmail", getInsuredEmail());
		attributes.put("insuredAddr", getInsuredAddr());
		attributes.put("insuredGender", getInsuredGender());
		attributes.put("occuptation", getOccuptation());
		attributes.put("estExpiryDate", getEstExpiryDate());
		attributes.put("najmStatus", getNajmStatus());
		attributes.put("surrenderValue", getSurrenderValue());
		attributes.put("noOfRisk", getNoOfRisk());
		attributes.put("memberScheme", getMemberScheme());
		attributes.put("memberBenefits", getMemberBenefits());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String policyNo = (String)attributes.get("policyNo");

		if (policyNo != null) {
			setPolicyNo(policyNo);
		}

		String iqamaId = (String)attributes.get("iqamaId");

		if (iqamaId != null) {
			setIqamaId(iqamaId);
		}

		String policyStatus = (String)attributes.get("policyStatus");

		if (policyStatus != null) {
			setPolicyStatus(policyStatus);
		}

		String product = (String)attributes.get("product");

		if (product != null) {
			setProduct(product);
		}

		Date inceptionDate = (Date)attributes.get("inceptionDate");

		if (inceptionDate != null) {
			setInceptionDate(inceptionDate);
		}

		Date expiryDate = (Date)attributes.get("expiryDate");

		if (expiryDate != null) {
			setExpiryDate(expiryDate);
		}

		Long sumInsured = (Long)attributes.get("sumInsured");

		if (sumInsured != null) {
			setSumInsured(sumInsured);
		}

		Long totalPremium = (Long)attributes.get("totalPremium");

		if (totalPremium != null) {
			setTotalPremium(totalPremium);
		}

		Long policyFees = (Long)attributes.get("policyFees");

		if (policyFees != null) {
			setPolicyFees(policyFees);
		}

		String policyTaxes = (String)attributes.get("policyTaxes");

		if (policyTaxes != null) {
			setPolicyTaxes(policyTaxes);
		}

		Long policyTerm = (Long)attributes.get("policyTerm");

		if (policyTerm != null) {
			setPolicyTerm(policyTerm);
		}

		String premium = (String)attributes.get("premium");

		if (premium != null) {
			setPremium(premium);
		}

		Date nextDueDate = (Date)attributes.get("nextDueDate");

		if (nextDueDate != null) {
			setNextDueDate(nextDueDate);
		}

		Long countPremMissed = (Long)attributes.get("countPremMissed");

		if (countPremMissed != null) {
			setCountPremMissed(countPremMissed);
		}

		String modeOfPayment = (String)attributes.get("modeOfPayment");

		if (modeOfPayment != null) {
			setModeOfPayment(modeOfPayment);
		}

		Date nextRenwalDate = (Date)attributes.get("nextRenwalDate");

		if (nextRenwalDate != null) {
			setNextRenwalDate(nextRenwalDate);
		}

		String custName = (String)attributes.get("custName");

		if (custName != null) {
			setCustName(custName);
		}

		Date custBirthDate = (Date)attributes.get("custBirthDate");

		if (custBirthDate != null) {
			setCustBirthDate(custBirthDate);
		}

		String insuredName = (String)attributes.get("insuredName");

		if (insuredName != null) {
			setInsuredName(insuredName);
		}

		Date insuredBirthDate = (Date)attributes.get("insuredBirthDate");

		if (insuredBirthDate != null) {
			setInsuredBirthDate(insuredBirthDate);
		}

		String insuredId = (String)attributes.get("insuredId");

		if (insuredId != null) {
			setInsuredId(insuredId);
		}

		String insuredMobile = (String)attributes.get("insuredMobile");

		if (insuredMobile != null) {
			setInsuredMobile(insuredMobile);
		}

		String insuredEmail = (String)attributes.get("insuredEmail");

		if (insuredEmail != null) {
			setInsuredEmail(insuredEmail);
		}

		String insuredAddr = (String)attributes.get("insuredAddr");

		if (insuredAddr != null) {
			setInsuredAddr(insuredAddr);
		}

		String insuredGender = (String)attributes.get("insuredGender");

		if (insuredGender != null) {
			setInsuredGender(insuredGender);
		}

		String occuptation = (String)attributes.get("occuptation");

		if (occuptation != null) {
			setOccuptation(occuptation);
		}

		Date estExpiryDate = (Date)attributes.get("estExpiryDate");

		if (estExpiryDate != null) {
			setEstExpiryDate(estExpiryDate);
		}

		String najmStatus = (String)attributes.get("najmStatus");

		if (najmStatus != null) {
			setNajmStatus(najmStatus);
		}

		Long surrenderValue = (Long)attributes.get("surrenderValue");

		if (surrenderValue != null) {
			setSurrenderValue(surrenderValue);
		}

		Long noOfRisk = (Long)attributes.get("noOfRisk");

		if (noOfRisk != null) {
			setNoOfRisk(noOfRisk);
		}

		String memberScheme = (String)attributes.get("memberScheme");

		if (memberScheme != null) {
			setMemberScheme(memberScheme);
		}

		String memberBenefits = (String)attributes.get("memberBenefits");

		if (memberBenefits != null) {
			setMemberBenefits(memberBenefits);
		}
	}

	/**
	 * Returns the count prem missed of this policy hdr.
	 *
	 * @return the count prem missed of this policy hdr
	 */
	@Override
	public long getCountPremMissed() {
		return model.getCountPremMissed();
	}

	/**
	 * Returns the cust birth date of this policy hdr.
	 *
	 * @return the cust birth date of this policy hdr
	 */
	@Override
	public Date getCustBirthDate() {
		return model.getCustBirthDate();
	}

	/**
	 * Returns the cust name of this policy hdr.
	 *
	 * @return the cust name of this policy hdr
	 */
	@Override
	public String getCustName() {
		return model.getCustName();
	}

	/**
	 * Returns the est expiry date of this policy hdr.
	 *
	 * @return the est expiry date of this policy hdr
	 */
	@Override
	public Date getEstExpiryDate() {
		return model.getEstExpiryDate();
	}

	/**
	 * Returns the expiry date of this policy hdr.
	 *
	 * @return the expiry date of this policy hdr
	 */
	@Override
	public Date getExpiryDate() {
		return model.getExpiryDate();
	}

	/**
	 * Returns the inception date of this policy hdr.
	 *
	 * @return the inception date of this policy hdr
	 */
	@Override
	public Date getInceptionDate() {
		return model.getInceptionDate();
	}

	/**
	 * Returns the insured addr of this policy hdr.
	 *
	 * @return the insured addr of this policy hdr
	 */
	@Override
	public String getInsuredAddr() {
		return model.getInsuredAddr();
	}

	/**
	 * Returns the insured birth date of this policy hdr.
	 *
	 * @return the insured birth date of this policy hdr
	 */
	@Override
	public Date getInsuredBirthDate() {
		return model.getInsuredBirthDate();
	}

	/**
	 * Returns the insured email of this policy hdr.
	 *
	 * @return the insured email of this policy hdr
	 */
	@Override
	public String getInsuredEmail() {
		return model.getInsuredEmail();
	}

	/**
	 * Returns the insured gender of this policy hdr.
	 *
	 * @return the insured gender of this policy hdr
	 */
	@Override
	public String getInsuredGender() {
		return model.getInsuredGender();
	}

	/**
	 * Returns the insured ID of this policy hdr.
	 *
	 * @return the insured ID of this policy hdr
	 */
	@Override
	public String getInsuredId() {
		return model.getInsuredId();
	}

	/**
	 * Returns the insured mobile of this policy hdr.
	 *
	 * @return the insured mobile of this policy hdr
	 */
	@Override
	public String getInsuredMobile() {
		return model.getInsuredMobile();
	}

	/**
	 * Returns the insured name of this policy hdr.
	 *
	 * @return the insured name of this policy hdr
	 */
	@Override
	public String getInsuredName() {
		return model.getInsuredName();
	}

	/**
	 * Returns the iqama ID of this policy hdr.
	 *
	 * @return the iqama ID of this policy hdr
	 */
	@Override
	public String getIqamaId() {
		return model.getIqamaId();
	}

	/**
	 * Returns the member benefits of this policy hdr.
	 *
	 * @return the member benefits of this policy hdr
	 */
	@Override
	public String getMemberBenefits() {
		return model.getMemberBenefits();
	}

	/**
	 * Returns the member scheme of this policy hdr.
	 *
	 * @return the member scheme of this policy hdr
	 */
	@Override
	public String getMemberScheme() {
		return model.getMemberScheme();
	}

	/**
	 * Returns the mode of payment of this policy hdr.
	 *
	 * @return the mode of payment of this policy hdr
	 */
	@Override
	public String getModeOfPayment() {
		return model.getModeOfPayment();
	}

	@Override
	public String getModeOfPmntDescAr() {
		return model.getModeOfPmntDescAr();
	}

	@Override
	public String getModeOfPmntDescEn() {
		return model.getModeOfPmntDescEn();
	}

	/**
	 * Returns the najm status of this policy hdr.
	 *
	 * @return the najm status of this policy hdr
	 */
	@Override
	public String getNajmStatus() {
		return model.getNajmStatus();
	}

	/**
	 * Returns the next due date of this policy hdr.
	 *
	 * @return the next due date of this policy hdr
	 */
	@Override
	public Date getNextDueDate() {
		return model.getNextDueDate();
	}

	/**
	 * Returns the next renwal date of this policy hdr.
	 *
	 * @return the next renwal date of this policy hdr
	 */
	@Override
	public Date getNextRenwalDate() {
		return model.getNextRenwalDate();
	}

	/**
	 * Returns the no of risk of this policy hdr.
	 *
	 * @return the no of risk of this policy hdr
	 */
	@Override
	public long getNoOfRisk() {
		return model.getNoOfRisk();
	}

	/**
	 * Returns the occuptation of this policy hdr.
	 *
	 * @return the occuptation of this policy hdr
	 */
	@Override
	public String getOccuptation() {
		return model.getOccuptation();
	}

	@Override
	public java.util.List<BeneficiaryDetails> getPolicyBenfs()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return model.getPolicyBenfs();
	}

	/**
	 * Returns the policy fees of this policy hdr.
	 *
	 * @return the policy fees of this policy hdr
	 */
	@Override
	public long getPolicyFees() {
		return model.getPolicyFees();
	}

	@Override
	public java.util.List<FundDetails> getPolicyFunds()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return model.getPolicyFunds();
	}

	@Override
	public java.util.List<PolicyMemberDetails> getPolicyMembers()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return model.getPolicyMembers();
	}

	/**
	 * Returns the policy no of this policy hdr.
	 *
	 * @return the policy no of this policy hdr
	 */
	@Override
	public String getPolicyNo() {
		return model.getPolicyNo();
	}

	@Override
	public java.util.List<PolicyPayment> getPolicyPayments()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return model.getPolicyPayments();
	}

	@Override
	public java.util.List<PolicyVehCvr> getPolicyRiders()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return model.getPolicyRiders();
	}

	/**
	 * Returns the policy status of this policy hdr.
	 *
	 * @return the policy status of this policy hdr
	 */
	@Override
	public String getPolicyStatus() {
		return model.getPolicyStatus();
	}

	/**
	 * Returns the policy taxes of this policy hdr.
	 *
	 * @return the policy taxes of this policy hdr
	 */
	@Override
	public String getPolicyTaxes() {
		return model.getPolicyTaxes();
	}

	/**
	 * Returns the policy term of this policy hdr.
	 *
	 * @return the policy term of this policy hdr
	 */
	@Override
	public long getPolicyTerm() {
		return model.getPolicyTerm();
	}

	@Override
	public java.util.List<PolicyVEH> getPolicyVEHs()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return model.getPolicyVEHs();
	}

	/**
	 * Returns the premium of this policy hdr.
	 *
	 * @return the premium of this policy hdr
	 */
	@Override
	public String getPremium() {
		return model.getPremium();
	}

	/**
	 * Returns the primary key of this policy hdr.
	 *
	 * @return the primary key of this policy hdr
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product of this policy hdr.
	 *
	 * @return the product of this policy hdr
	 */
	@Override
	public String getProduct() {
		return model.getProduct();
	}

	@Override
	public String getProductDescAr() {
		return model.getProductDescAr();
	}

	@Override
	public String getProductDescEn() {
		return model.getProductDescEn();
	}

	/**
	 * @return the statusDescAr
	 */
	@Override
	public String getStatusDescAr() {
		return model.getStatusDescAr();
	}

	@Override
	public String getStatusDescEn() {
		return model.getStatusDescEn();
	}

	/**
	 * Returns the sum insured of this policy hdr.
	 *
	 * @return the sum insured of this policy hdr
	 */
	@Override
	public long getSumInsured() {
		return model.getSumInsured();
	}

	/**
	 * Returns the surrender value of this policy hdr.
	 *
	 * @return the surrender value of this policy hdr
	 */
	@Override
	public long getSurrenderValue() {
		return model.getSurrenderValue();
	}

	/**
	 * Returns the total premium of this policy hdr.
	 *
	 * @return the total premium of this policy hdr
	 */
	@Override
	public long getTotalPremium() {
		return model.getTotalPremium();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the count prem missed of this policy hdr.
	 *
	 * @param countPremMissed the count prem missed of this policy hdr
	 */
	@Override
	public void setCountPremMissed(long countPremMissed) {
		model.setCountPremMissed(countPremMissed);
	}

	/**
	 * Sets the cust birth date of this policy hdr.
	 *
	 * @param custBirthDate the cust birth date of this policy hdr
	 */
	@Override
	public void setCustBirthDate(Date custBirthDate) {
		model.setCustBirthDate(custBirthDate);
	}

	/**
	 * Sets the cust name of this policy hdr.
	 *
	 * @param custName the cust name of this policy hdr
	 */
	@Override
	public void setCustName(String custName) {
		model.setCustName(custName);
	}

	/**
	 * Sets the est expiry date of this policy hdr.
	 *
	 * @param estExpiryDate the est expiry date of this policy hdr
	 */
	@Override
	public void setEstExpiryDate(Date estExpiryDate) {
		model.setEstExpiryDate(estExpiryDate);
	}

	/**
	 * Sets the expiry date of this policy hdr.
	 *
	 * @param expiryDate the expiry date of this policy hdr
	 */
	@Override
	public void setExpiryDate(Date expiryDate) {
		model.setExpiryDate(expiryDate);
	}

	/**
	 * Sets the inception date of this policy hdr.
	 *
	 * @param inceptionDate the inception date of this policy hdr
	 */
	@Override
	public void setInceptionDate(Date inceptionDate) {
		model.setInceptionDate(inceptionDate);
	}

	/**
	 * Sets the insured addr of this policy hdr.
	 *
	 * @param insuredAddr the insured addr of this policy hdr
	 */
	@Override
	public void setInsuredAddr(String insuredAddr) {
		model.setInsuredAddr(insuredAddr);
	}

	/**
	 * Sets the insured birth date of this policy hdr.
	 *
	 * @param insuredBirthDate the insured birth date of this policy hdr
	 */
	@Override
	public void setInsuredBirthDate(Date insuredBirthDate) {
		model.setInsuredBirthDate(insuredBirthDate);
	}

	/**
	 * Sets the insured email of this policy hdr.
	 *
	 * @param insuredEmail the insured email of this policy hdr
	 */
	@Override
	public void setInsuredEmail(String insuredEmail) {
		model.setInsuredEmail(insuredEmail);
	}

	/**
	 * Sets the insured gender of this policy hdr.
	 *
	 * @param insuredGender the insured gender of this policy hdr
	 */
	@Override
	public void setInsuredGender(String insuredGender) {
		model.setInsuredGender(insuredGender);
	}

	/**
	 * Sets the insured ID of this policy hdr.
	 *
	 * @param insuredId the insured ID of this policy hdr
	 */
	@Override
	public void setInsuredId(String insuredId) {
		model.setInsuredId(insuredId);
	}

	/**
	 * Sets the insured mobile of this policy hdr.
	 *
	 * @param insuredMobile the insured mobile of this policy hdr
	 */
	@Override
	public void setInsuredMobile(String insuredMobile) {
		model.setInsuredMobile(insuredMobile);
	}

	/**
	 * Sets the insured name of this policy hdr.
	 *
	 * @param insuredName the insured name of this policy hdr
	 */
	@Override
	public void setInsuredName(String insuredName) {
		model.setInsuredName(insuredName);
	}

	/**
	 * Sets the iqama ID of this policy hdr.
	 *
	 * @param iqamaId the iqama ID of this policy hdr
	 */
	@Override
	public void setIqamaId(String iqamaId) {
		model.setIqamaId(iqamaId);
	}

	/**
	 * Sets the member benefits of this policy hdr.
	 *
	 * @param memberBenefits the member benefits of this policy hdr
	 */
	@Override
	public void setMemberBenefits(String memberBenefits) {
		model.setMemberBenefits(memberBenefits);
	}

	/**
	 * Sets the member scheme of this policy hdr.
	 *
	 * @param memberScheme the member scheme of this policy hdr
	 */
	@Override
	public void setMemberScheme(String memberScheme) {
		model.setMemberScheme(memberScheme);
	}

	/**
	 * Sets the mode of payment of this policy hdr.
	 *
	 * @param modeOfPayment the mode of payment of this policy hdr
	 */
	@Override
	public void setModeOfPayment(String modeOfPayment) {
		model.setModeOfPayment(modeOfPayment);
	}

	/**
	 * Sets the najm status of this policy hdr.
	 *
	 * @param najmStatus the najm status of this policy hdr
	 */
	@Override
	public void setNajmStatus(String najmStatus) {
		model.setNajmStatus(najmStatus);
	}

	/**
	 * Sets the next due date of this policy hdr.
	 *
	 * @param nextDueDate the next due date of this policy hdr
	 */
	@Override
	public void setNextDueDate(Date nextDueDate) {
		model.setNextDueDate(nextDueDate);
	}

	/**
	 * Sets the next renwal date of this policy hdr.
	 *
	 * @param nextRenwalDate the next renwal date of this policy hdr
	 */
	@Override
	public void setNextRenwalDate(Date nextRenwalDate) {
		model.setNextRenwalDate(nextRenwalDate);
	}

	/**
	 * Sets the no of risk of this policy hdr.
	 *
	 * @param noOfRisk the no of risk of this policy hdr
	 */
	@Override
	public void setNoOfRisk(long noOfRisk) {
		model.setNoOfRisk(noOfRisk);
	}

	/**
	 * Sets the occuptation of this policy hdr.
	 *
	 * @param occuptation the occuptation of this policy hdr
	 */
	@Override
	public void setOccuptation(String occuptation) {
		model.setOccuptation(occuptation);
	}

	/**
	 * Sets the policy fees of this policy hdr.
	 *
	 * @param policyFees the policy fees of this policy hdr
	 */
	@Override
	public void setPolicyFees(long policyFees) {
		model.setPolicyFees(policyFees);
	}

	/**
	 * Sets the policy no of this policy hdr.
	 *
	 * @param policyNo the policy no of this policy hdr
	 */
	@Override
	public void setPolicyNo(String policyNo) {
		model.setPolicyNo(policyNo);
	}

	/**
	 * Sets the policy status of this policy hdr.
	 *
	 * @param policyStatus the policy status of this policy hdr
	 */
	@Override
	public void setPolicyStatus(String policyStatus) {
		model.setPolicyStatus(policyStatus);
	}

	/**
	 * Sets the policy taxes of this policy hdr.
	 *
	 * @param policyTaxes the policy taxes of this policy hdr
	 */
	@Override
	public void setPolicyTaxes(String policyTaxes) {
		model.setPolicyTaxes(policyTaxes);
	}

	/**
	 * Sets the policy term of this policy hdr.
	 *
	 * @param policyTerm the policy term of this policy hdr
	 */
	@Override
	public void setPolicyTerm(long policyTerm) {
		model.setPolicyTerm(policyTerm);
	}

	/**
	 * Sets the premium of this policy hdr.
	 *
	 * @param premium the premium of this policy hdr
	 */
	@Override
	public void setPremium(String premium) {
		model.setPremium(premium);
	}

	/**
	 * Sets the primary key of this policy hdr.
	 *
	 * @param primaryKey the primary key of this policy hdr
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product of this policy hdr.
	 *
	 * @param product the product of this policy hdr
	 */
	@Override
	public void setProduct(String product) {
		model.setProduct(product);
	}

	/**
	 * Sets the sum insured of this policy hdr.
	 *
	 * @param sumInsured the sum insured of this policy hdr
	 */
	@Override
	public void setSumInsured(long sumInsured) {
		model.setSumInsured(sumInsured);
	}

	/**
	 * Sets the surrender value of this policy hdr.
	 *
	 * @param surrenderValue the surrender value of this policy hdr
	 */
	@Override
	public void setSurrenderValue(long surrenderValue) {
		model.setSurrenderValue(surrenderValue);
	}

	/**
	 * Sets the total premium of this policy hdr.
	 *
	 * @param totalPremium the total premium of this policy hdr
	 */
	@Override
	public void setTotalPremium(long totalPremium) {
		model.setTotalPremium(totalPremium);
	}

	@Override
	protected PolicyHDRWrapper wrap(PolicyHDR policyHDR) {
		return new PolicyHDRWrapper(policyHDR);
	}

}