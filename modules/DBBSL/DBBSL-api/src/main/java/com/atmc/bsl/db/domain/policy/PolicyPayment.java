/*
 * PolicyPayment.java Jan 28, 2018  
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

import java.util.Date;

/**
 * @author Ghada Shawkat
 */
public class PolicyPayment
{
	private String policyNo;

	private String voucherNo;

	private String endtNo;

	private String claimNo;

	private Date dueDate;

	private Date docDate;

	private double amount;

	private String reference;

	/**
	 * @return the policyNo
	 */
	public String getPolicyNo()
	{
		return policyNo;
	}

	/**
	 * @param policyNo
	 *            the policyNo to set
	 */
	public void setPolicyNo(String policyNo)
	{
		this.policyNo = policyNo;
	}

	/**
	 * @return the voucherNo
	 */
	public String getVoucherNo()
	{
		return voucherNo;
	}

	/**
	 * @param voucherNo
	 *            the voucherNo to set
	 */
	public void setVoucherNo(String voucherNo)
	{
		this.voucherNo = voucherNo;
	}

	/**
	 * @return the endtNo
	 */
	public String getEndtNo()
	{
		return endtNo;
	}

	/**
	 * @param endtNo
	 *            the endtNo to set
	 */
	public void setEndtNo(String endtNo)
	{
		this.endtNo = endtNo;
	}

	/**
	 * @return the claimNo
	 */
	public String getClaimNo()
	{
		return claimNo;
	}

	/**
	 * @param claimNo
	 *            the claimNo to set
	 */
	public void setClaimNo(String claimNo)
	{
		this.claimNo = claimNo;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate()
	{
		return dueDate;
	}

	/**
	 * @param dueDate
	 *            the dueDate to set
	 */
	public void setDueDate(Date dueDate)
	{
		this.dueDate = dueDate;
	}

	/**
	 * @return the docDate
	 */
	public Date getDocDate()
	{
		return docDate;
	}

	/**
	 * @param docDate
	 *            the docDate to set
	 */
	public void setDocDate(Date docDate)
	{
		this.docDate = docDate;
	}

	/**
	 * @return the amount
	 */
	public double getAmount()
	{
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	/**
	 * @return the reference
	 */
	public String getReference()
	{
		return reference;
	}

	/**
	 * @param reference
	 *            the reference to set
	 */
	public void setReference(String reference)
	{
		this.reference = reference;
	}

}
