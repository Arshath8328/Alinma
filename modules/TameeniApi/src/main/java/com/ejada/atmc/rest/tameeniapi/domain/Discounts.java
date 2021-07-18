package com.ejada.atmc.rest.tameeniapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Ehab
 *
 */
public class Discounts {

	@JsonProperty("DiscountTypeID")
	private int discountTypeID;
	
	@JsonProperty("DiscountPercentage")
	private double discountPercentage;
	
	@JsonProperty("DiscountAmount")
	private double discountAmount;
	
	@JsonProperty("NCDEligibility")
	private int ncdEligibility;

	public int getDiscountTypeID() {
		return discountTypeID;
	}

	public void setDiscountTypeID(int discountTypeID) {
		this.discountTypeID = discountTypeID;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public int getNcdEligibility() {
		return ncdEligibility;
	}

	public void setNcdEligibility(int ncdEligibility) {
		this.ncdEligibility = ncdEligibility;
	}
}
