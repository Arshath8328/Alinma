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
 * This class is a wrapper for {@link QuotationsDriverLicense}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsDriverLicense
 * @generated
 */
public class QuotationsDriverLicenseWrapper
	extends BaseModelWrapper<QuotationsDriverLicense>
	implements ModelWrapper<QuotationsDriverLicense>, QuotationsDriverLicense {

	public QuotationsDriverLicenseWrapper(
		QuotationsDriverLicense quotationsDriverLicense) {

		super(quotationsDriverLicense);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("licenseId", getLicenseId());
		attributes.put("driverId", getDriverId());
		attributes.put("quotationId", getQuotationId());
		attributes.put("LicCountry", getLicCountry());
		attributes.put("LicType", getLicType());
		attributes.put("LicYrs", getLicYrs());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long licenseId = (Long)attributes.get("licenseId");

		if (licenseId != null) {
			setLicenseId(licenseId);
		}

		Long driverId = (Long)attributes.get("driverId");

		if (driverId != null) {
			setDriverId(driverId);
		}

		Long quotationId = (Long)attributes.get("quotationId");

		if (quotationId != null) {
			setQuotationId(quotationId);
		}

		String LicCountry = (String)attributes.get("LicCountry");

		if (LicCountry != null) {
			setLicCountry(LicCountry);
		}

		String LicType = (String)attributes.get("LicType");

		if (LicType != null) {
			setLicType(LicType);
		}

		Integer LicYrs = (Integer)attributes.get("LicYrs");

		if (LicYrs != null) {
			setLicYrs(LicYrs);
		}
	}

	/**
	 * Returns the driver ID of this quotations driver license.
	 *
	 * @return the driver ID of this quotations driver license
	 */
	@Override
	public long getDriverId() {
		return model.getDriverId();
	}

	/**
	 * Returns the lic country of this quotations driver license.
	 *
	 * @return the lic country of this quotations driver license
	 */
	@Override
	public String getLicCountry() {
		return model.getLicCountry();
	}

	/**
	 * Returns the license ID of this quotations driver license.
	 *
	 * @return the license ID of this quotations driver license
	 */
	@Override
	public long getLicenseId() {
		return model.getLicenseId();
	}

	/**
	 * Returns the lic type of this quotations driver license.
	 *
	 * @return the lic type of this quotations driver license
	 */
	@Override
	public String getLicType() {
		return model.getLicType();
	}

	/**
	 * Returns the lic yrs of this quotations driver license.
	 *
	 * @return the lic yrs of this quotations driver license
	 */
	@Override
	public int getLicYrs() {
		return model.getLicYrs();
	}

	/**
	 * Returns the primary key of this quotations driver license.
	 *
	 * @return the primary key of this quotations driver license
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quotation ID of this quotations driver license.
	 *
	 * @return the quotation ID of this quotations driver license
	 */
	@Override
	public long getQuotationId() {
		return model.getQuotationId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the driver ID of this quotations driver license.
	 *
	 * @param driverId the driver ID of this quotations driver license
	 */
	@Override
	public void setDriverId(long driverId) {
		model.setDriverId(driverId);
	}

	/**
	 * Sets the lic country of this quotations driver license.
	 *
	 * @param LicCountry the lic country of this quotations driver license
	 */
	@Override
	public void setLicCountry(String LicCountry) {
		model.setLicCountry(LicCountry);
	}

	/**
	 * Sets the license ID of this quotations driver license.
	 *
	 * @param licenseId the license ID of this quotations driver license
	 */
	@Override
	public void setLicenseId(long licenseId) {
		model.setLicenseId(licenseId);
	}

	/**
	 * Sets the lic type of this quotations driver license.
	 *
	 * @param LicType the lic type of this quotations driver license
	 */
	@Override
	public void setLicType(String LicType) {
		model.setLicType(LicType);
	}

	/**
	 * Sets the lic yrs of this quotations driver license.
	 *
	 * @param LicYrs the lic yrs of this quotations driver license
	 */
	@Override
	public void setLicYrs(int LicYrs) {
		model.setLicYrs(LicYrs);
	}

	/**
	 * Sets the primary key of this quotations driver license.
	 *
	 * @param primaryKey the primary key of this quotations driver license
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quotation ID of this quotations driver license.
	 *
	 * @param quotationId the quotation ID of this quotations driver license
	 */
	@Override
	public void setQuotationId(long quotationId) {
		model.setQuotationId(quotationId);
	}

	@Override
	protected QuotationsDriverLicenseWrapper wrap(
		QuotationsDriverLicense quotationsDriverLicense) {

		return new QuotationsDriverLicenseWrapper(quotationsDriverLicense);
	}

}