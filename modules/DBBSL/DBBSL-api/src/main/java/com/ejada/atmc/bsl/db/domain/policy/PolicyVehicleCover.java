/*
 * PolicyVehicleCover.java Jan 18, 2018  
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
package com.ejada.atmc.bsl.db.domain.policy;

/**
 * @author Ghada Shawkat
 */
public class PolicyVehicleCover {
	private String policyNo;

	private String vehId;

	private String cvrType;

	private String cvrCode;

	private String description;

	private String benefitTerm;

	private String premiumTerm;

	private long premium;

	private long sumCovered;

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
	 * @return the vehId
	 */
	public String getVehId() {
		return vehId;
	}

	/**
	 * @param vehId the vehId to set
	 */
	public void setVehId(String vehId) {
		this.vehId = vehId;
	}

	/**
	 * @return the cvrType
	 */
	public String getCvrType() {
		return cvrType;
	}

	/**
	 * @param cvrType the cvrType to set
	 */
	public void setCvrType(String cvrType) {
		this.cvrType = cvrType;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the benefitTerm
	 */
	public String getBenefitTerm() {
		return benefitTerm;
	}

	/**
	 * @param benefitTerm the benefitTerm to set
	 */
	public void setBenefitTerm(String benefitTerm) {
		this.benefitTerm = benefitTerm;
	}

	/**
	 * @return the premiumTerm
	 */
	public String getPremiumTerm() {
		return premiumTerm;
	}

	/**
	 * @param premiumTerm the premiumTerm to set
	 */
	public void setPremiumTerm(String premiumTerm) {
		this.premiumTerm = premiumTerm;
	}

	/**
	 * @return the premium
	 */
	public long getPremium() {
		return premium;
	}

	/**
	 * @param premium the premium to set
	 */
	public void setPremium(long premium) {
		this.premium = premium;
	}

	/**
	 * @return the sumCovered
	 */
	public long getSumCovered() {
		return sumCovered;
	}

	/**
	 * @param sumCovered the sumCovered to set
	 */
	public void setSumCovered(long sumCovered) {
		this.sumCovered = sumCovered;
	}

	/**
	 * @return the cvrCode
	 */
	public String getCvrCode() {
		return cvrCode;
	}

	/**
	 * @param cvrCode the cvrCode to set
	 */
	public void setCvrCode(String cvrCode) {
		this.cvrCode = cvrCode;
	}

}
