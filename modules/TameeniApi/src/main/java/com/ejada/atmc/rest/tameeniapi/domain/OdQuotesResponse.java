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

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Kareem Kahil
 */

@XmlRootElement
public class OdQuotesResponse
{
	private String requestReferenceNo;

	private int insuranceCompanyCode;
	
	private long quoteReferenceNo;
	
	private OdQuoteResponseDetails details;
	
	private boolean status;
	
	private List<Error> errors;

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
	
	@XmlElement(name = "QuoteReferenceNo")
	public long getQuoteReferenceNo() {
		return quoteReferenceNo;
	}

	public void setQuoteReferenceNo(long quoteReferenceNo) {
		this.quoteReferenceNo = quoteReferenceNo;
	}

	/**
	 * @return the quoteReferenceNo
	 */
	@XmlElement(name = "Details")
	public OdQuoteResponseDetails getDetails()
	{
		return details;
	}

	/**
	 * @param quoteReferenceNo
	 *            the quoteReferenceNo to set
	 */
	public void setDetails(OdQuoteResponseDetails details)
	{
		this.details = details;
	}

	@XmlElement(name = "Status")
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@XmlElement(name = "errors")
	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
}
