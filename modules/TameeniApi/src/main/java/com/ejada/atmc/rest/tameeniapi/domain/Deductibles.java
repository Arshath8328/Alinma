
package com.ejada.atmc.rest.tameeniapi.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Kareem Kahil
 *
 */
@XmlRootElement
public class Deductibles
{
	private long deductibleAmount;
	
	private double policyPremium;

	private List<PremiumBreakdown> premiumBreakdownList;

	private double taxableAmount;
	
	private List<Discounts> discountsList;
	
	private String deductibleReferenceNo;

	@XmlElement(name = "DeductibleAmount")
	public long getDeductibleAmount() {
		return deductibleAmount;
	}

	public void setDeductibleAmount(long deductibleAmount) {
		this.deductibleAmount = deductibleAmount;
	}

	@XmlElement(name = "PolicyPremium")
	public double getPolicyPremium() {
		return policyPremium;
	}

	public void setPolicyPremium(double policyPremium) {
		this.policyPremium = policyPremium;
	}

	@XmlElement(name = "PremiumBreakdown")
	public List<PremiumBreakdown> getPremiumBreakdownList() {
		return premiumBreakdownList;
	}

	public void setPremiumBreakdownList(List<PremiumBreakdown> premiumBreakdownList) {
		this.premiumBreakdownList = premiumBreakdownList;
	}

	@XmlElement(name = "TaxableAmount")
	public double getTaxableAmount() {
		return taxableAmount;
	}

	public void setTaxableAmount(double taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	@XmlElement(name = "Discounts")
	public List<Discounts> getDiscountsList() {
		return discountsList;
	}

	public void setDiscountsList(List<Discounts> discountsList) {
		this.discountsList = discountsList;
	}

	@XmlElement(name = "DeductibleReferenceNo")
	public String getDeductibleReferenceNo() {
		return deductibleReferenceNo;
	}

	public void setDeductibleReferenceNo(String deductibleReferenceNo) {
		this.deductibleReferenceNo = deductibleReferenceNo;
	}
	
}
