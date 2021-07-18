package com.ejada.atmc.rest.tameeniapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Ehab
 *
 */
public class PolicyPremiumFeatures {

	@JsonProperty("FeatureID")
	private int featureID;
	
	@JsonProperty("FeatureTypeID")
	private int featureTypeID;
	
	@JsonProperty("FeatureAmount")
	private double featureAmount;
	
	@JsonProperty("FeatureTaxableAmount")
	private double featureTaxableAmount;

	public int getFeatureID() {
		return featureID;
	}

	public void setFeatureID(int featureID) {
		this.featureID = featureID;
	}

	public int getFeatureTypeID() {
		return featureTypeID;
	}

	public void setFeatureTypeID(int featureTypeID) {
		this.featureTypeID = featureTypeID;
	}

	public double getFeatureAmount() {
		return featureAmount;
	}

	public void setFeatureAmount(double featureAmount) {
		this.featureAmount = featureAmount;
	}

	public double getFeatureTaxableAmount() {
		return featureTaxableAmount;
	}

	public void setFeatureTaxableAmount(double featureTaxableAmount) {
		this.featureTaxableAmount = featureTaxableAmount;
	}
}
