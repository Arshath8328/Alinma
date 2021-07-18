package com.ejada.atmc.rest.tameeniapi.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Ehab
 *
 */
@XmlRootElement
public class OdPurchaseNotificationsRequest {
	
	private long policyRequestReferenceNo;
	
	private int insuranceCompanyCode;
	
	private int requestType;
	
	private int insuranceTypeID;
	
	private long quoteReferenceNo;
	
	private long policyReferenceNo;
	
	private boolean isPurchased;
	
	private PurchaseNotificationsDetails details;
	
	public int getRequestType() {
		return requestType;
	}

	public void setRequestType(int requestType) {
		this.requestType = requestType;
	}

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

	@XmlElement(name = "InsuranceTypeID")
	public int getInsuranceTypeID() {
		return insuranceTypeID;
	}

	public void setInsuranceTypeID(int insuranceTypeID) {
		this.insuranceTypeID = insuranceTypeID;
	}

	@XmlElement(name = "QuoteReferenceNo")
	public long getQuoteReferenceNo() {
		return quoteReferenceNo;
	}

	public void setQuoteReferenceNo(long quoteReferenceNo) {
		this.quoteReferenceNo = quoteReferenceNo;
	}

	@XmlElement(name = "PolicyReferenceNo")
	public long getPolicyReferenceNo() {
		return policyReferenceNo;
	}

	public void setPolicyReferenceNo(long policyReferenceNo) {
		this.policyReferenceNo = policyReferenceNo;
	}

	@XmlElement(name = "IsPurchased")
	public boolean isPurchased() {
		return isPurchased;
	}

	public void setPurchased(boolean isPurchased) {
		this.isPurchased = isPurchased;
	}

	public PurchaseNotificationsDetails getDetails() {
		return details;
	}

	@XmlElement(name = "Details")
	public void setDetails(PurchaseNotificationsDetails details) {
		this.details = details;
	}
	
}
