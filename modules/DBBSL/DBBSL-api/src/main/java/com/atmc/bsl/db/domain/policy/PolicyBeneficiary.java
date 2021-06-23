/*
 * PolicyBeneficiary.java Jan 29, 2018  
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

/**
 * @author Ghada Shawkat
 */
public class PolicyBeneficiary {
	private String policyNo;

	private String benfName;

	private String benfPct;

	private String benfRel;

	private String benfRelEn;

	private String benfRelAr;

	private long benfId;

	private String benfAge;

	private String benfType;

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
	 * @return the benfName
	 */
	public String getBenfName() {
		return benfName;
	}

	/**
	 * @param benfName the benfName to set
	 */
	public void setBenfName(String benfName) {
		this.benfName = benfName;
	}

	/**
	 * @return the benfPct
	 */
	public String getBenfPct() {
		return benfPct;
	}

	/**
	 * @param benfPct the benfPct to set
	 */
	public void setBenfPct(String benfPct) {
		this.benfPct = benfPct;
	}

	/**
	 * @return the benfRel
	 */
	public String getBenfRel() {
		return benfRel;
	}

	/**
	 * @param benfRel the benfRel to set
	 */
	public void setBenfRel(String benfRel) {
		this.benfRel = benfRel;
	}

	/**
	 * @return the benfId
	 */
	public long getBenfId() {
		return benfId;
	}

	/**
	 * @param benfId the benfId to set
	 */
	public void setBenfId(long benfId) {
		this.benfId = benfId;
	}

	/**
	 * @return the benfAge
	 */
	public String getBenfAge() {
		return benfAge;
	}

	/**
	 * @param benfAge the benfAge to set
	 */
	public void setBenfAge(String benfAge) {
		this.benfAge = benfAge;
	}

	/**
	 * @return the benfType
	 */
	public String getBenfType() {
		return benfType;
	}

	/**
	 * @param benfType the benfType to set
	 */
	public void setBenfType(String benfType) {
		this.benfType = benfType;
	}

	/**
	 * @return the benfRelEn
	 */
	public String getBenfRelEn() {
		return benfRelEn;
	}

	/**
	 * @param benfRelEn the benfRelEn to set
	 */
	public void setBenfRelEn(String benfRelEn) {
		this.benfRelEn = benfRelEn;
	}

	/**
	 * @return the benfRelAr
	 */
	public String getBenfRelAr() {
		return benfRelAr;
	}

	/**
	 * @param benfRelAr the benfRelAr to set
	 */
	public void setBenfRelAr(String benfRelAr) {
		this.benfRelAr = benfRelAr;
	}

}
