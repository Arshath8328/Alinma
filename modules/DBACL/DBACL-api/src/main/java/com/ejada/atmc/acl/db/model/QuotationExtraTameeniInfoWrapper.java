/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ejada.atmc.acl.db.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link QuotationExtraTameeniInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationExtraTameeniInfo
 * @generated
 */
public class QuotationExtraTameeniInfoWrapper
	extends BaseModelWrapper<QuotationExtraTameeniInfo>
	implements ModelWrapper<QuotationExtraTameeniInfo>,
			   QuotationExtraTameeniInfo {

	public QuotationExtraTameeniInfoWrapper(
		QuotationExtraTameeniInfo quotationExtraTameeniInfo) {

		super(quotationExtraTameeniInfo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("quotationId", getQuotationId());
		attributes.put("insuredFirstName", getInsuredFirstName());
		attributes.put("insuredMiddleName", getInsuredMiddleName());
		attributes.put("insuredLastName", getInsuredLastName());
		attributes.put("isDriverDisabled", isIsDriverDisabled());
		attributes.put("vehicleMakeCodeTameeni", getVehicleMakeCodeTameeni());
		attributes.put("coverAgeLimit", getCoverAgeLimit());
		attributes.put("insuredNameLang", getInsuredNameLang());
		attributes.put("policyTitleId", getPolicyTitleId());
		attributes.put("isRenewal", isIsRenewal());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long quotationId = (Long)attributes.get("quotationId");

		if (quotationId != null) {
			setQuotationId(quotationId);
		}

		String insuredFirstName = (String)attributes.get("insuredFirstName");

		if (insuredFirstName != null) {
			setInsuredFirstName(insuredFirstName);
		}

		String insuredMiddleName = (String)attributes.get("insuredMiddleName");

		if (insuredMiddleName != null) {
			setInsuredMiddleName(insuredMiddleName);
		}

		String insuredLastName = (String)attributes.get("insuredLastName");

		if (insuredLastName != null) {
			setInsuredLastName(insuredLastName);
		}

		Boolean isDriverDisabled = (Boolean)attributes.get("isDriverDisabled");

		if (isDriverDisabled != null) {
			setIsDriverDisabled(isDriverDisabled);
		}

		Long vehicleMakeCodeTameeni = (Long)attributes.get(
			"vehicleMakeCodeTameeni");

		if (vehicleMakeCodeTameeni != null) {
			setVehicleMakeCodeTameeni(vehicleMakeCodeTameeni);
		}

		Long coverAgeLimit = (Long)attributes.get("coverAgeLimit");

		if (coverAgeLimit != null) {
			setCoverAgeLimit(coverAgeLimit);
		}

		String insuredNameLang = (String)attributes.get("insuredNameLang");

		if (insuredNameLang != null) {
			setInsuredNameLang(insuredNameLang);
		}

		String policyTitleId = (String)attributes.get("policyTitleId");

		if (policyTitleId != null) {
			setPolicyTitleId(policyTitleId);
		}

		Boolean isRenewal = (Boolean)attributes.get("isRenewal");

		if (isRenewal != null) {
			setIsRenewal(isRenewal);
		}
	}

	/**
	 * Returns the cover age limit of this quotation extra tameeni info.
	 *
	 * @return the cover age limit of this quotation extra tameeni info
	 */
	@Override
	public long getCoverAgeLimit() {
		return model.getCoverAgeLimit();
	}

	/**
	 * Returns the insured first name of this quotation extra tameeni info.
	 *
	 * @return the insured first name of this quotation extra tameeni info
	 */
	@Override
	public String getInsuredFirstName() {
		return model.getInsuredFirstName();
	}

	/**
	 * Returns the insured last name of this quotation extra tameeni info.
	 *
	 * @return the insured last name of this quotation extra tameeni info
	 */
	@Override
	public String getInsuredLastName() {
		return model.getInsuredLastName();
	}

	/**
	 * Returns the insured middle name of this quotation extra tameeni info.
	 *
	 * @return the insured middle name of this quotation extra tameeni info
	 */
	@Override
	public String getInsuredMiddleName() {
		return model.getInsuredMiddleName();
	}

	/**
	 * Returns the insured name lang of this quotation extra tameeni info.
	 *
	 * @return the insured name lang of this quotation extra tameeni info
	 */
	@Override
	public String getInsuredNameLang() {
		return model.getInsuredNameLang();
	}

	/**
	 * Returns the is driver disabled of this quotation extra tameeni info.
	 *
	 * @return the is driver disabled of this quotation extra tameeni info
	 */
	@Override
	public boolean getIsDriverDisabled() {
		return model.getIsDriverDisabled();
	}

	/**
	 * Returns the is renewal of this quotation extra tameeni info.
	 *
	 * @return the is renewal of this quotation extra tameeni info
	 */
	@Override
	public boolean getIsRenewal() {
		return model.getIsRenewal();
	}

	/**
	 * Returns the policy title ID of this quotation extra tameeni info.
	 *
	 * @return the policy title ID of this quotation extra tameeni info
	 */
	@Override
	public String getPolicyTitleId() {
		return model.getPolicyTitleId();
	}

	/**
	 * Returns the primary key of this quotation extra tameeni info.
	 *
	 * @return the primary key of this quotation extra tameeni info
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quotation ID of this quotation extra tameeni info.
	 *
	 * @return the quotation ID of this quotation extra tameeni info
	 */
	@Override
	public long getQuotationId() {
		return model.getQuotationId();
	}

	/**
	 * Returns the vehicle make code tameeni of this quotation extra tameeni info.
	 *
	 * @return the vehicle make code tameeni of this quotation extra tameeni info
	 */
	@Override
	public long getVehicleMakeCodeTameeni() {
		return model.getVehicleMakeCodeTameeni();
	}

	/**
	 * Returns <code>true</code> if this quotation extra tameeni info is is driver disabled.
	 *
	 * @return <code>true</code> if this quotation extra tameeni info is is driver disabled; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsDriverDisabled() {
		return model.isIsDriverDisabled();
	}

	/**
	 * Returns <code>true</code> if this quotation extra tameeni info is is renewal.
	 *
	 * @return <code>true</code> if this quotation extra tameeni info is is renewal; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsRenewal() {
		return model.isIsRenewal();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cover age limit of this quotation extra tameeni info.
	 *
	 * @param coverAgeLimit the cover age limit of this quotation extra tameeni info
	 */
	@Override
	public void setCoverAgeLimit(long coverAgeLimit) {
		model.setCoverAgeLimit(coverAgeLimit);
	}

	/**
	 * Sets the insured first name of this quotation extra tameeni info.
	 *
	 * @param insuredFirstName the insured first name of this quotation extra tameeni info
	 */
	@Override
	public void setInsuredFirstName(String insuredFirstName) {
		model.setInsuredFirstName(insuredFirstName);
	}

	/**
	 * Sets the insured last name of this quotation extra tameeni info.
	 *
	 * @param insuredLastName the insured last name of this quotation extra tameeni info
	 */
	@Override
	public void setInsuredLastName(String insuredLastName) {
		model.setInsuredLastName(insuredLastName);
	}

	/**
	 * Sets the insured middle name of this quotation extra tameeni info.
	 *
	 * @param insuredMiddleName the insured middle name of this quotation extra tameeni info
	 */
	@Override
	public void setInsuredMiddleName(String insuredMiddleName) {
		model.setInsuredMiddleName(insuredMiddleName);
	}

	/**
	 * Sets the insured name lang of this quotation extra tameeni info.
	 *
	 * @param insuredNameLang the insured name lang of this quotation extra tameeni info
	 */
	@Override
	public void setInsuredNameLang(String insuredNameLang) {
		model.setInsuredNameLang(insuredNameLang);
	}

	/**
	 * Sets whether this quotation extra tameeni info is is driver disabled.
	 *
	 * @param isDriverDisabled the is driver disabled of this quotation extra tameeni info
	 */
	@Override
	public void setIsDriverDisabled(boolean isDriverDisabled) {
		model.setIsDriverDisabled(isDriverDisabled);
	}

	/**
	 * Sets whether this quotation extra tameeni info is is renewal.
	 *
	 * @param isRenewal the is renewal of this quotation extra tameeni info
	 */
	@Override
	public void setIsRenewal(boolean isRenewal) {
		model.setIsRenewal(isRenewal);
	}

	/**
	 * Sets the policy title ID of this quotation extra tameeni info.
	 *
	 * @param policyTitleId the policy title ID of this quotation extra tameeni info
	 */
	@Override
	public void setPolicyTitleId(String policyTitleId) {
		model.setPolicyTitleId(policyTitleId);
	}

	/**
	 * Sets the primary key of this quotation extra tameeni info.
	 *
	 * @param primaryKey the primary key of this quotation extra tameeni info
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quotation ID of this quotation extra tameeni info.
	 *
	 * @param quotationId the quotation ID of this quotation extra tameeni info
	 */
	@Override
	public void setQuotationId(long quotationId) {
		model.setQuotationId(quotationId);
	}

	/**
	 * Sets the vehicle make code tameeni of this quotation extra tameeni info.
	 *
	 * @param vehicleMakeCodeTameeni the vehicle make code tameeni of this quotation extra tameeni info
	 */
	@Override
	public void setVehicleMakeCodeTameeni(long vehicleMakeCodeTameeni) {
		model.setVehicleMakeCodeTameeni(vehicleMakeCodeTameeni);
	}

	@Override
	protected QuotationExtraTameeniInfoWrapper wrap(
		QuotationExtraTameeniInfo quotationExtraTameeniInfo) {

		return new QuotationExtraTameeniInfoWrapper(quotationExtraTameeniInfo);
	}

}