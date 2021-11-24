/*
 * QuotationDriverLicense.java Jun 25, 2018  
 *
 * Copyright (c) 2005-2012 Ejada Solutions.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Ejada
 * Solutions, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Ejada.
 */
package com.ejada.atmc.bsl.db.domain.quotation;

/**
 * @author Ghada Shawkat
 */
public class QuotationDriverLicense {
	private String LicCountry;

	private String LicType;

	private int LicYrs;

	private long licenseId;

	/**
	 * @return the licCountry
	 */
	public String getLicCountry() {
		return LicCountry;
	}

	/**
	 * @param licCountry the licCountry to set
	 */
	public void setLicCountry(String licCountry) {
		LicCountry = licCountry;
	}

	/**
	 * @return the licType
	 */
	public String getLicType() {
		return LicType;
	}

	/**
	 * @param licType the licType to set
	 */
	public void setLicType(String licType) {
		LicType = licType;
	}

	/**
	 * @return the licYrs
	 */
	public int getLicYrs() {
		return LicYrs;
	}

	/**
	 * @param licYrs the licYrs to set
	 */
	public void setLicYrs(int licYrs) {
		LicYrs = licYrs;
	}

	/**
	 * @return the licenseId
	 */
	public long getLicenseId() {
		return licenseId;
	}

	/**
	 * @param licenseId the licenseId to set
	 */
	public void setLicenseId(long licenseId) {
		this.licenseId = licenseId;
	}

}
