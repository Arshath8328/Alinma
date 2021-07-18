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
 * @author Ghada Shawkat
 */

@XmlRootElement
public class TriggerVehicleIdUpdateRequest
{
	private long requestReferenceNo;

	private long insuranceCompanyCode;

	private long quoteReferenceNo;

	private long najmVehicleId;

	private long policyUploadedDateTime;

	private List<CustomizedParameter> customizedParameterList;

	/**
	 * @return the requestReferenceNo
	 */
	@XmlElement(name = "RequestReferenceNo")
	public long getRequestReferenceNo()
	{
		return requestReferenceNo;
	}

	/**
	 * @param requestReferenceNo
	 *            the requestReferenceNo to set
	 */
	public void setRequestReferenceNo(long requestReferenceNo)
	{
		this.requestReferenceNo = requestReferenceNo;
	}

	/**
	 * @return the insuranceCompanyCode
	 */
	@XmlElement(name = "InsuranceCompanyCode")
	public long getInsuranceCompanyCode()
	{
		return insuranceCompanyCode;
	}

	/**
	 * @param insuranceCompanyCode
	 *            the insuranceCompanyCode to set
	 */
	public void setInsuranceCompanyCode(long insuranceCompanyCode)
	{
		this.insuranceCompanyCode = insuranceCompanyCode;
	}

	/**
	 * @return the quoteReferenceNo
	 */
	@XmlElement(name = "QuoteReferenceNo")
	public long getQuoteReferenceNo()
	{
		return quoteReferenceNo;
	}

	/**
	 * @param quoteReferenceNo
	 *            the quoteReferenceNo to set
	 */
	public void setQuoteReferenceNo(long quoteReferenceNo)
	{
		this.quoteReferenceNo = quoteReferenceNo;
	}

	/**
	 * @return the najmVehicleId
	 */
	@XmlElement(name = "NajmVehicleId")
	public long getNajmVehicleId()
	{
		return najmVehicleId;
	}

	/**
	 * @param najmVehicleId
	 *            the najmVehicleId to set
	 */
	public void setNajmVehicleId(long najmVehicleId)
	{
		this.najmVehicleId = najmVehicleId;
	}

	/**
	 * @return the policyUploadedDateTime
	 */
	@XmlElement(name = "PolicyUploadedDateTime")
	public long getPolicyUploadedDateTime()
	{
		return policyUploadedDateTime;
	}

	/**
	 * @param policyUploadedDateTime
	 *            the policyUploadedDateTime to set
	 */
	public void setPolicyUploadedDateTime(long policyUploadedDateTime)
	{
		this.policyUploadedDateTime = policyUploadedDateTime;
	}

	/**
	 * @return the customizedParameterList
	 */
	@XmlElement(name = "CustomizedParameter")
	public List<CustomizedParameter> getCustomizedParameterList()
	{
		return customizedParameterList;
	}

	/**
	 * @param customizedParameterList
	 *            the customizedParameterList to set
	 */
	public void setCustomizedParameterList(List<CustomizedParameter> customizedParameterList)
	{
		this.customizedParameterList = customizedParameterList;
	}
}
