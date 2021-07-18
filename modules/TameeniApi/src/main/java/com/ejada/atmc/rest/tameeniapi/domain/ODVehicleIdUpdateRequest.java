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
public class ODVehicleIdUpdateRequest
{
	private String policyRequestReferenceNo;

	private int insuranceCompanyCode;

	private long policyReferenceNo;
	
	private int insuranceTypeID;

	private long najmVehicleId;

	private String policyUploadedDateTime;

	private List<CustomizedParameter> customizedParameterList;

	/**
	 * @return the policyRequestReferenceNo
	 */
	@XmlElement(name = "PolicyRequestReferenceNo")
	public String getPolicyRequestReferenceNo()
	{
		return policyRequestReferenceNo;
	}

	/**
	 * @param policyRequestReferenceNo the policyRequestReferenceNo to set
	 */
	public void setPolicyRequestReferenceNo(String policyRequestReferenceNo)
	{
		this.policyRequestReferenceNo = policyRequestReferenceNo;
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
	 * @return the policyReferenceNo
	 */
	@XmlElement(name = "PolicyReferenceNo")
	public long getPolicyReferenceNo()
	{
		return policyReferenceNo;
	}

	/**
	 * @param policyReferenceNo the policyReferenceNo to set
	 */
	public void setPolicyReferenceNo(long policyReferenceNo)
	{
		this.policyReferenceNo = policyReferenceNo;
	}

	
	/**
	 * @return the insuranceTypeID
	 */
	@XmlElement(name = "InsuranceTypeID")
	public int getInsuranceTypeID()
	{
		return insuranceTypeID;
	}

	/**
	 * @param insuranceTypeID the insuranceTypeID to set
	 */
	public void setInsuranceTypeID(int insuranceTypeID)
	{
		this.insuranceTypeID = insuranceTypeID;
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
	public String getPolicyUploadedDateTime()
	{
		return policyUploadedDateTime;
	}

	/**
	 * @param policyUploadedDateTime
	 *            the policyUploadedDateTime to set
	 */
	public void setPolicyUploadedDateTime(String policyUploadedDateTime)
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
