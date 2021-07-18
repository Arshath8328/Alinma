/*
 * VehicleIdUpdateRequest.java Apr 18, 2018  
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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Kareem Kahil
 */

@XmlRootElement
public class TpQuotesRequest
{
	private String requestReferenceNo;

	private int insuranceCompanyCode;
	
	private TpQuoteDetails details;

	/**
	 * @return the requestReferenceNo
	 */
	@XmlElement(name = "RequestReferenceNo")
	public String getRequestReferenceNo()
	{
		return requestReferenceNo;
	}

	/**
	 * @param requestReferenceNo
	 *            the requestReferenceNo to set
	 */
	public void setRequestReferenceNo(String requestReferenceNo)
	{
		this.requestReferenceNo = requestReferenceNo;
	}

	/**
	 * @return the insuranceCompanyCode
	 */
	@XmlElement(name = "InsuranceCompanyCode")
	public int getInsuranceCompanyCode()
	{
		return insuranceCompanyCode;
	}

	/**
	 * @param insuranceCompanyCode
	 *            the insuranceCompanyCode to set
	 */
	public void setInsuranceCompanyCode(int insuranceCompanyCode)
	{
		this.insuranceCompanyCode = insuranceCompanyCode;
	}

	/**
	 * @return the quoteReferenceNo
	 */
	@XmlElement(name = "Details")
	public TpQuoteDetails getDetails()
	{
		return details;
	}

	/**
	 * @param quoteReferenceNo
	 *            the quoteReferenceNo to set
	 */
	public void setDetails(TpQuoteDetails details)
	{
		this.details = details;
	}
}
