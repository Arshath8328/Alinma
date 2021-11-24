/*
 * PolicyFunds.java Jan 29, 2018  
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
public class PolicyFund {
	private String policyNo;

	private String fundName;

	private String fundDesc;

	private String fundPctg;

	private double unitsSum;

	private double unitPrice;

	private double fundsValue;

	private double riskChg;

	private double partFees;

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
	 * @return the fundName
	 */
	public String getFundName() {
		return fundName;
	}

	/**
	 * @param fundName the fundName to set
	 */
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	/**
	 * @return the fundDesc
	 */
	public String getFundDesc() {
		return fundDesc;
	}

	/**
	 * @param fundDesc the fundDesc to set
	 */
	public void setFundDesc(String fundDesc) {
		this.fundDesc = fundDesc;
	}

	/**
	 * @return the fundPctg
	 */
	public String getFundPctg() {
		return fundPctg;
	}

	/**
	 * @param fundPctg the fundPctg to set
	 */
	public void setFundPctg(String fundPctg) {
		this.fundPctg = fundPctg;
	}

	/**
	 * @return the unitsSum
	 */
	public double getUnitsSum() {
		return unitsSum;
	}

	/**
	 * @param unitsSum the unitsSum to set
	 */
	public void setUnitsSum(double unitsSum) {
		this.unitsSum = unitsSum;
	}

	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the fundsValue
	 */
	public double getFundsValue() {
		return fundsValue;
	}

	/**
	 * @param fundsValue the fundsValue to set
	 */
	public void setFundsValue(double fundsValue) {
		this.fundsValue = fundsValue;
	}

	/**
	 * @return the riskChg
	 */
	public double getRiskChg() {
		return riskChg;
	}

	/**
	 * @param riskChg the riskChg to set
	 */
	public void setRiskChg(double riskChg) {
		this.riskChg = riskChg;
	}

	/**
	 * @return the partFees
	 */
	public double getPartFees() {
		return partFees;
	}

	/**
	 * @param partFees the partFees to set
	 */
	public void setPartFees(double partFees) {
		this.partFees = partFees;
	}

}
