package com.ejada.atmc.rest.tameeniapi.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**.
 * 
 * @author Ehab
 *
 */
@XmlRootElement
public class PolicyPremiumFeature {
	
	private int featureID;
	
	private int featureTypeID;
	
	private int featureAmount;
	
	private int featureTaxableAmount;

	@XmlElement(name = "FeatureID")
	public int getFeatureID() {
		return featureID;
	}

	public void setFeatureID(int featureID) {
		this.featureID = featureID;
	}

	@XmlElement(name = "FeatureTypeID")
	public int getFeatureTypeID() {
		return featureTypeID;
	}

	public void setFeatureTypeID(int featureTypeID) {
		this.featureTypeID = featureTypeID;
	}

	@XmlElement(name = "FeatureAmount")
	public int getFeatureAmount() {
		return featureAmount;
	}

	public void setFeatureAmount(int featureAmount) {
		this.featureAmount = featureAmount;
	}

	@XmlElement(name = "FeatureTaxableAmount")
	public int getFeatureTaxableAmount() {
		return featureTaxableAmount;
	}

	public void setFeatureTaxableAmount(int featureTaxableAmount) {
		this.featureTaxableAmount = featureTaxableAmount;
	}
	
}
