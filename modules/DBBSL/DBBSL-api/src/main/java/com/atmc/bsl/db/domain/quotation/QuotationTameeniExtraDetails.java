package com.atmc.bsl.db.domain.quotation;

/**
 * @author Kareem Kahil
 */
public class QuotationTameeniExtraDetails 
{
	private long quotationId;

	private String insuredFirstName;
	
	private String insuredMiddleName;
	
	private String insuredLastName;
	
	private boolean isDriverDisabled;
	
	private long vehicleMakeCodeTameeni;
	
	private long coverAgeLimit;
	
	private String insuredNameLang;
	
	private int policyTitleID;
	
	private boolean isRenewal;

	public long getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(long quotationId) {
		this.quotationId = quotationId;
	}

	public String getInsuredFirstName() {
		return insuredFirstName;
	}

	public void setInsuredFirstName(String insuredFirstName) {
		this.insuredFirstName = insuredFirstName;
	}

	public String getInsuredMiddleName() {
		return insuredMiddleName;
	}

	public void setInsuredMiddleName(String insuredMiddleName) {
		this.insuredMiddleName = insuredMiddleName;
	}

	public String getInsuredLastName() {
		return insuredLastName;
	}

	public void setInsuredLastName(String insuredLastName) {
		this.insuredLastName = insuredLastName;
	}

	public boolean isDriverDisabled() {
		return isDriverDisabled;
	}

	public void setDriverDisabled(boolean isDriverDisabled) {
		this.isDriverDisabled = isDriverDisabled;
	}

	public long getVehicleMakeCodeTameeni() {
		return vehicleMakeCodeTameeni;
	}

	public void setVehicleMakeCodeTameeni(long vehicleMakeCodeTameeni) {
		this.vehicleMakeCodeTameeni = vehicleMakeCodeTameeni;
	}

	public long getCoverAgeLimit() {
		return coverAgeLimit;
	}

	public void setCoverAgeLimit(long coverAgeLimit) {
		this.coverAgeLimit = coverAgeLimit;
	}

	public String getInsuredNameLang() {
		return insuredNameLang;
	}

	public void setInsuredNameLang(String insuredNameLang) {
		this.insuredNameLang = insuredNameLang;
	}

	public int getPolicyTitleID() {
		return policyTitleID;
	}

	public void setPolicyTitleID(int policyTitleID) {
		this.policyTitleID = policyTitleID;
	}

	public boolean isRenewal() {
		return isRenewal;
	}

	public void setRenewal(boolean isRenewal) {
		this.isRenewal = isRenewal;
	}
	
	
}
