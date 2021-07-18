package com.ejada.atmc.rest.tameeniapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Ehab
 *
 */
public class PremiumBreakdown {

	@JsonProperty("BreakdownTypeID")
	private int breakdownTypeID;
	
	@JsonProperty("BreakdownAmount")
	private double breakdownAmount;
	
	@JsonProperty("BreakdownPercentage")
	private double breakdownPercentage;

	public int getBreakdownTypeID() {
		return breakdownTypeID;
	}

	public void setBreakdownTypeID(int breakdownTypeID) {
		this.breakdownTypeID = breakdownTypeID;
	}

	public double getBreakdownAmount() {
		return breakdownAmount;
	}

	public void setBreakdownAmount(double breakdownAmount) {
		this.breakdownAmount = breakdownAmount;
	}

	public double getBreakdownPercentage() {
		return breakdownPercentage;
	}

	public void setBreakdownPercentage(double breakdownPercentage) {
		this.breakdownPercentage = breakdownPercentage;
	}
}
