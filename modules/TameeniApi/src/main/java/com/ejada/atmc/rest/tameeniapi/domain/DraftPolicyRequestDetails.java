package com.ejada.atmc.rest.tameeniapi.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Ehab
 *
 */
@XmlRootElement
public class DraftPolicyRequestDetails {
	private String deductibleReferenceNo;
	
	private int deductibleAmount;
	
	private int policyPremium;
	
	private List<PolicyPremiumFeature> policyPremiumFeatureList;
	
	private List<CustomizedParameter> customizedParameterList;

	@XmlElement(name = "DeductibleReferenceNo")
	public String getDeductibleReferenceNo() {
		return deductibleReferenceNo;
	}

	public void setDeductibleReferenceNo(String deductibleReferenceNo) {
		this.deductibleReferenceNo = deductibleReferenceNo;
	}

	@XmlElement(name = "DeductibleAmount")
	public int getDeductibleAmount() {
		return deductibleAmount;
	}

	public void setDeductibleAmount(int deductibleAmount) {
		this.deductibleAmount = deductibleAmount;
	}

	@XmlElement(name = "PolicyPremium")
	public int getPolicyPremium() {
		return policyPremium;
	}

	public void setPolicyPremium(int policyPremium) {
		this.policyPremium = policyPremium;
	}

	@XmlElement(name = "PolicyPremiumFeatures")
	public List<PolicyPremiumFeature> getPolicyPremiumFeatureList() {
		return policyPremiumFeatureList;
	}

	public void setPolicyPremiumFeatureList(List<PolicyPremiumFeature> policyPremiumFeatureList) {
		this.policyPremiumFeatureList = policyPremiumFeatureList;
	}

	@XmlElement(name = "CustomizedParameter")
	public List<CustomizedParameter> getCustomizedParameterList() {
		return customizedParameterList;
	}

	public void setCustomizedParameterList(List<CustomizedParameter> customizedParameterList) {
		this.customizedParameterList = customizedParameterList;
	}
	
}
