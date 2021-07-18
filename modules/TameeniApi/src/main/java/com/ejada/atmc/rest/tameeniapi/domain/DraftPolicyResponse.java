package com.ejada.atmc.rest.tameeniapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 
 * @author Ehab
 *
 */
public class DraftPolicyResponse {

	@JsonProperty("PolicyRequestReferenceNo")
	private long policyRequestReferenceNo;
	
	@JsonProperty("InsuranceCompanyCode")
	private int insuranceCompanyCode;
	
	@JsonProperty("PolicyReferenceNo")
	private long policyReferenceNo;
	
	@JsonProperty("QuoteReferenceNo")
	private long quoteReferenceNo;
	
	@JsonProperty("RequestReferenceNo")
	private long requestReferenceNo;
	
	@JsonProperty("Details")
	private DraftPolicyResponseDetails details;
	
	public DraftPolicyResponseDetails getDetails() {
		return details;
	}

	public void setDetails(DraftPolicyResponseDetails details) {
		this.details = details;
	}

	@JsonProperty("Status")
	private boolean status;
	
	@JsonProperty("errors")
	private List<Error> errors;

	public long getPolicyRequestReferenceNo() {
		return policyRequestReferenceNo;
	}

	public void setPolicyRequestReferenceNo(long policyRequestReferenceNo) {
		this.policyRequestReferenceNo = policyRequestReferenceNo;
	}

	public int getInsuranceCompanyCode() {
		return insuranceCompanyCode;
	}

	public void setInsuranceCompanyCode(int insuranceCompanyCode) {
		this.insuranceCompanyCode = insuranceCompanyCode;
	}

	public long getPolicyReferenceNo() {
		return policyReferenceNo;
	}

	public void setPolicyReferenceNo(long policyReferenceNo) {
		this.policyReferenceNo = policyReferenceNo;
	}

	public long getQuoteReferenceNo() {
		return quoteReferenceNo;
	}

	public void setQuoteReferenceNo(long quoteReferenceNo) {
		this.quoteReferenceNo = quoteReferenceNo;
	}

	public long getRequestReferenceNo() {
		return requestReferenceNo;
	}

	public void setRequestReferenceNo(long requestReferenceNo) {
		this.requestReferenceNo = requestReferenceNo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

}
