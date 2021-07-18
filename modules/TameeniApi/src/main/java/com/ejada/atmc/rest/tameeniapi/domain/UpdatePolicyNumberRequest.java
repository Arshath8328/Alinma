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
public class UpdatePolicyNumberRequest
{
	private long policyRequestReferenceNo;

	private long insuranceCompanyCode;

	private long policyReferenceNo;

	private String oldPolicyNumber;
	
	private String newPolicyNumber;
	
	//TP
	private long requestReferenceNo;

	private long insuranceTypeId;

	private long quoteReferenceNo;
	
	private List<CustomizedParameter> customizedParameterList;

	@XmlElement(name = "PolicyRequestReferenceNo")
	public long getPolicyRequestReferenceNo() {
		return policyRequestReferenceNo;
	}

	public void setPolicyRequestReferenceNo(long policyRequestReferenceNo) {
		this.policyRequestReferenceNo = policyRequestReferenceNo;
	}

	@XmlElement(name = "InsuranceCompanyCode")
	public long getInsuranceCompanyCode() {
		return insuranceCompanyCode;
	}

	public void setInsuranceCompanyCode(long insuranceCompanyCode) {
		this.insuranceCompanyCode = insuranceCompanyCode;
	}

	@XmlElement(name = "PolicyReferenceNo")
	public long getPolicyReferenceNo() {
		return policyReferenceNo;
	}

	public void setPolicyReferenceNo(long policyReferenceNo) {
		this.policyReferenceNo = policyReferenceNo;
	}
	
	
	@XmlElement(name = "RequestReferenceNo")
	public long getRequestReferenceNo() {
		return requestReferenceNo;
	}

	public void setRequestReferenceNo(long requestReferenceNo) {
		this.requestReferenceNo = requestReferenceNo;
	}

	@XmlElement(name = "InsuranceTypeId")
	public long getInsuranceTypeId() {
		return insuranceTypeId;
	}

	public void setInsuranceTypeId(long insuranceTypeId) {
		this.insuranceTypeId = insuranceTypeId;
	}

	@XmlElement(name = "QuoteReferenceNo")
	public long getQuoteReferenceNo() {
		return quoteReferenceNo;
	}

	public void setQuoteReferenceNo(long quoteReferenceNo) {
		this.quoteReferenceNo = quoteReferenceNo;
	}

	@XmlElement(name = "OldPolicyNumber")
	public String getOldPolicyNumber() {
		return oldPolicyNumber;
	}

	public void setOldPolicyNumber(String oldPolicyNumber) {
		this.oldPolicyNumber = oldPolicyNumber;
	}

	@XmlElement(name = "NewPolicyNumber")
	public String getNewPolicyNumber() {
		return newPolicyNumber;
	}

	public void setNewPolicyNumber(String newPolicyNumber) {
		this.newPolicyNumber = newPolicyNumber;
	}

	@XmlElement(name = "CustomizedParameter")
	public List<CustomizedParameter> getCustomizedParameterList() {
		return customizedParameterList;
	}

	public void setCustomizedParameterList(List<CustomizedParameter> customizedParameterList) {
		this.customizedParameterList = customizedParameterList;
	}

}
