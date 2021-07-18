package com.ejada.atmc.rest.tameeniapi.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Ehab
 *
 */
@XmlRootElement
public class TpPurchaseNotificationsRequest {

	private long requestReferenceNo;
		
	private int insuranceCompanyCode;
	
	private int insuranceTypeID;
	
	private long quoteReferenceNo;
		
	private boolean isPurchased;
	
	private PurchaseNotificationsDetails details;
	
	@XmlElement(name = "RequestReferenceNo")
	public long getRequestReferenceNo() {
		return requestReferenceNo;
	}

	public void setRequestReferenceNo(long requestReferenceNo) {
		this.requestReferenceNo = requestReferenceNo;
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
