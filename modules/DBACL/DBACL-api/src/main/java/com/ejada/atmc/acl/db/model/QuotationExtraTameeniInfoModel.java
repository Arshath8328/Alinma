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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the QuotationExtraTameeniInfo service. Represents a row in the &quot;EJD_QUOTATIONS_TAMEENI_EXTRAS&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ejada.atmc.acl.db.model.impl.QuotationExtraTameeniInfoModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ejada.atmc.acl.db.model.impl.QuotationExtraTameeniInfoImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationExtraTameeniInfo
 * @generated
 */
@ProviderType
public interface QuotationExtraTameeniInfoModel
	extends BaseModel<QuotationExtraTameeniInfo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a quotation extra tameeni info model instance should use the {@link QuotationExtraTameeniInfo} interface instead.
	 */

	/**
	 * Returns the primary key of this quotation extra tameeni info.
	 *
	 * @return the primary key of this quotation extra tameeni info
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this quotation extra tameeni info.
	 *
	 * @param primaryKey the primary key of this quotation extra tameeni info
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the quotation ID of this quotation extra tameeni info.
	 *
	 * @return the quotation ID of this quotation extra tameeni info
	 */
	public long getQuotationId();

	/**
	 * Sets the quotation ID of this quotation extra tameeni info.
	 *
	 * @param quotationId the quotation ID of this quotation extra tameeni info
	 */
	public void setQuotationId(long quotationId);

	/**
	 * Returns the insured first name of this quotation extra tameeni info.
	 *
	 * @return the insured first name of this quotation extra tameeni info
	 */
	@AutoEscape
	public String getInsuredFirstName();

	/**
	 * Sets the insured first name of this quotation extra tameeni info.
	 *
	 * @param insuredFirstName the insured first name of this quotation extra tameeni info
	 */
	public void setInsuredFirstName(String insuredFirstName);

	/**
	 * Returns the insured middle name of this quotation extra tameeni info.
	 *
	 * @return the insured middle name of this quotation extra tameeni info
	 */
	@AutoEscape
	public String getInsuredMiddleName();

	/**
	 * Sets the insured middle name of this quotation extra tameeni info.
	 *
	 * @param insuredMiddleName the insured middle name of this quotation extra tameeni info
	 */
	public void setInsuredMiddleName(String insuredMiddleName);

	/**
	 * Returns the insured last name of this quotation extra tameeni info.
	 *
	 * @return the insured last name of this quotation extra tameeni info
	 */
	@AutoEscape
	public String getInsuredLastName();

	/**
	 * Sets the insured last name of this quotation extra tameeni info.
	 *
	 * @param insuredLastName the insured last name of this quotation extra tameeni info
	 */
	public void setInsuredLastName(String insuredLastName);

	/**
	 * Returns the is driver disabled of this quotation extra tameeni info.
	 *
	 * @return the is driver disabled of this quotation extra tameeni info
	 */
	public boolean getIsDriverDisabled();

	/**
	 * Returns <code>true</code> if this quotation extra tameeni info is is driver disabled.
	 *
	 * @return <code>true</code> if this quotation extra tameeni info is is driver disabled; <code>false</code> otherwise
	 */
	public boolean isIsDriverDisabled();

	/**
	 * Sets whether this quotation extra tameeni info is is driver disabled.
	 *
	 * @param isDriverDisabled the is driver disabled of this quotation extra tameeni info
	 */
	public void setIsDriverDisabled(boolean isDriverDisabled);

	/**
	 * Returns the vehicle make code tameeni of this quotation extra tameeni info.
	 *
	 * @return the vehicle make code tameeni of this quotation extra tameeni info
	 */
	public long getVehicleMakeCodeTameeni();

	/**
	 * Sets the vehicle make code tameeni of this quotation extra tameeni info.
	 *
	 * @param vehicleMakeCodeTameeni the vehicle make code tameeni of this quotation extra tameeni info
	 */
	public void setVehicleMakeCodeTameeni(long vehicleMakeCodeTameeni);

	/**
	 * Returns the cover age limit of this quotation extra tameeni info.
	 *
	 * @return the cover age limit of this quotation extra tameeni info
	 */
	public long getCoverAgeLimit();

	/**
	 * Sets the cover age limit of this quotation extra tameeni info.
	 *
	 * @param coverAgeLimit the cover age limit of this quotation extra tameeni info
	 */
	public void setCoverAgeLimit(long coverAgeLimit);

	/**
	 * Returns the insured name lang of this quotation extra tameeni info.
	 *
	 * @return the insured name lang of this quotation extra tameeni info
	 */
	@AutoEscape
	public String getInsuredNameLang();

	/**
	 * Sets the insured name lang of this quotation extra tameeni info.
	 *
	 * @param insuredNameLang the insured name lang of this quotation extra tameeni info
	 */
	public void setInsuredNameLang(String insuredNameLang);

	/**
	 * Returns the policy title ID of this quotation extra tameeni info.
	 *
	 * @return the policy title ID of this quotation extra tameeni info
	 */
	@AutoEscape
	public String getPolicyTitleId();

	/**
	 * Sets the policy title ID of this quotation extra tameeni info.
	 *
	 * @param policyTitleId the policy title ID of this quotation extra tameeni info
	 */
	public void setPolicyTitleId(String policyTitleId);

	/**
	 * Returns the is renewal of this quotation extra tameeni info.
	 *
	 * @return the is renewal of this quotation extra tameeni info
	 */
	public boolean getIsRenewal();

	/**
	 * Returns <code>true</code> if this quotation extra tameeni info is is renewal.
	 *
	 * @return <code>true</code> if this quotation extra tameeni info is is renewal; <code>false</code> otherwise
	 */
	public boolean isIsRenewal();

	/**
	 * Sets whether this quotation extra tameeni info is is renewal.
	 *
	 * @param isRenewal the is renewal of this quotation extra tameeni info
	 */
	public void setIsRenewal(boolean isRenewal);

}