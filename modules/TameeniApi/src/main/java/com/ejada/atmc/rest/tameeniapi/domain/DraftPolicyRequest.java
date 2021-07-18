package com.ejada.atmc.rest.tameeniapi.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Ehab
 *
 */
@XmlRootElement
public class DraftPolicyRequest {

	private long policyRequestReferenceNo;
	
	private int insuranceCompanyCode;
	
	private long requestReferenceNo;
	
	private long quoteReferenceNo;
	
	private DraftPolicyRequestDetails details;

	@XmlElement(name = "PolicyRequestReferenceNo")
	public long getPolicyRequestReferenceNo() {
		return policyRequestReferenceNo;
	}

	public void setPolicyRequestReferenceNo(long policyRequestReferenceNo) {
		this.policyRequestReferenceNo = policyRequestReferenceNo;
	}

	@XmlElement(name = "InsuranceCompanyCode")
	public int getInsuranceCompanyCode() {
		return insuranceCompanyCode;
	}

	public void setInsuranceCompanyCode(int insuranceCompanyCode) {
		this.insuranceCompanyCode = insuranceCompanyCode;
	}

	@XmlElement(name = "RequestReferenceNo")
	public long getRequestReferenceNo() {
		return requestReferenceNo;
	}

	public void setRequestReferenceNo(long requestReferenceNo) {
		this.requestReferenceNo = requestReferenceNo;
	}

	@XmlElement(name = "QuoteReferenceNo")
	public long getQuoteReferenceNo() {
		return quoteReferenceNo;
	}

	public void setQuoteReferenceNo(long quoteReferenceNo) {
		this.quoteReferenceNo = quoteReferenceNo;
	}
	
	@XmlElement(name = "Details")
	public DraftPolicyRequestDetails getDetails() {
		return details;
	}

	public void setDetails(DraftPolicyRequestDetails details) {
		this.details = details;
	}
}
