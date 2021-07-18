/*
 * CustomizedParameter.java Apr 18, 2018  
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
 *
 */
@XmlRootElement
public class OdQuoteResponseDetails
{
	private int policyTitleID;
	
	private long maxLiability;
	
	private String policyEffectiveDate;
	
	private String policyExpiryDate;
	
	private List<Deductibles> deductiblesList;
	
	private List<PolicyPremiumFeatures> policyPremiumFeatures;
	
	private int inspectionTypeID;
	
	private List<CustomizedParameter> customizedParameter;
	
	@XmlElement(name = "PolicyTitleID")
	public int getPolicyTitleID() {
		return policyTitleID;
	}
	
	public void setPolicyTitleID(int policyTitleID) {
		this.policyTitleID = policyTitleID;
	}
	
	@XmlElement(name = "MaxLiability")
	public long getMaxLiability() {
		return maxLiability;
	}
	
	public void setMaxLiability(long maxLiability) {
		this.maxLiability = maxLiability;
	}
	
	@XmlElement(name = "PolicyEffectiveDate")
	public String getPolicyEffectiveDate() {
		return policyEffectiveDate;
	}
	
	public void setPolicyEffectiveDate(String policyEffectiveDate) {
		this.policyEffectiveDate = policyEffectiveDate;
	}
	
	@XmlElement(name = "PolicyExpiryDate")
	public String getPolicyExpiryDate() {
		return policyExpiryDate;
	}
	
	public void setPolicyExpiryDate(String policyExpiryDate) {
		this.policyExpiryDate = policyExpiryDate;
	}
	
	@XmlElement(name = "Deductibles")
	public List<Deductibles> getDeductiblesList() {
		return deductiblesList;
	}
	
	public void setDeductiblesList(List<Deductibles> deductiblesList) {
		this.deductiblesList = deductiblesList;
	}
	
	@XmlElement(name = "PolicyPremiumFeatures")
	public List<PolicyPremiumFeatures> getPolicyPremiumFeatures() {
		return policyPremiumFeatures;
	}
	
	public void setPolicyPremiumFeatures(List<PolicyPremiumFeatures> policyPremiumFeatures) {
		this.policyPremiumFeatures = policyPremiumFeatures;
	}
	
	@XmlElement(name = "InspectionTypeID")
	public int getInspectionTypeID() {
		return inspectionTypeID;
	}
	
	public void setInspectionTypeID(int inspectionTypeID) {
		this.inspectionTypeID = inspectionTypeID;
	}
	
	@XmlElement(name = "CustomizedParameter")
	public List<CustomizedParameter> getCustomizedParameter() {
		return customizedParameter;
	}
	
	public void setCustomizedParameter(List<CustomizedParameter> customizedParameter) {
		this.customizedParameter = customizedParameter;
	}
}
