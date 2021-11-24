/*
 * QuotationUserAddress.java Jun 28, 2018  
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
 *
 */
public class QuotationUserAddress {
	private String buildNo;

	private String stName;

	private String district;

	private String city;

	private String zipCode;

	private String addNo;

	private long userAddressId;

	/**
	 * @return the buildNo
	 */
	public String getBuildNo() {
		return buildNo;
	}

	/**
	 * @param buildNo the buildNo to set
	 */
	public void setBuildNo(String buildNo) {
		this.buildNo = buildNo;
	}

	/**
	 * @return the stName
	 */
	public String getStName() {
		return stName;
	}

	/**
	 * @param stName the stName to set
	 */
	public void setStName(String stName) {
		this.stName = stName;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the addNo
	 */
	public String getAddNo() {
		return addNo;
	}

	/**
	 * @param addNo the addNo to set
	 */
	public void setAddNo(String addNo) {
		this.addNo = addNo;
	}

	/**
	 * @return the userAddressId
	 */
	public long getUserAddressId() {
		return userAddressId;
	}

	/**
	 * @param userAddressId the userAddressId to set
	 */
	public void setUserAddressId(long userAddressId) {
		this.userAddressId = userAddressId;
	}

}
