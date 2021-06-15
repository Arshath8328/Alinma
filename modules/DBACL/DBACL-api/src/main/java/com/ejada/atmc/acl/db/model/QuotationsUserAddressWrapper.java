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
 * This class is a wrapper for {@link QuotationsUserAddress}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsUserAddress
 * @generated
 */
public class QuotationsUserAddressWrapper
	extends BaseModelWrapper<QuotationsUserAddress>
	implements ModelWrapper<QuotationsUserAddress>, QuotationsUserAddress {

	public QuotationsUserAddressWrapper(
		QuotationsUserAddress quotationsUserAddress) {

		super(quotationsUserAddress);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userAddressId", getUserAddressId());
		attributes.put("driverId", getDriverId());
		attributes.put("quotationId", getQuotationId());
		attributes.put("buildNo", getBuildNo());
		attributes.put("zipCode", getZipCode());
		attributes.put("addNo", getAddNo());
		attributes.put("stNameEn", getStNameEn());
		attributes.put("stNameAr", getStNameAr());
		attributes.put("districtEn", getDistrictEn());
		attributes.put("districtAr", getDistrictAr());
		attributes.put("cityEn", getCityEn());
		attributes.put("cityAr", getCityAr());
		attributes.put("isNatAddress", isIsNatAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userAddressId = (Long)attributes.get("userAddressId");

		if (userAddressId != null) {
			setUserAddressId(userAddressId);
		}

		Long driverId = (Long)attributes.get("driverId");

		if (driverId != null) {
			setDriverId(driverId);
		}

		Long quotationId = (Long)attributes.get("quotationId");

		if (quotationId != null) {
			setQuotationId(quotationId);
		}

		String buildNo = (String)attributes.get("buildNo");

		if (buildNo != null) {
			setBuildNo(buildNo);
		}

		String zipCode = (String)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}

		String addNo = (String)attributes.get("addNo");

		if (addNo != null) {
			setAddNo(addNo);
		}

		String stNameEn = (String)attributes.get("stNameEn");

		if (stNameEn != null) {
			setStNameEn(stNameEn);
		}

		String stNameAr = (String)attributes.get("stNameAr");

		if (stNameAr != null) {
			setStNameAr(stNameAr);
		}

		String districtEn = (String)attributes.get("districtEn");

		if (districtEn != null) {
			setDistrictEn(districtEn);
		}

		String districtAr = (String)attributes.get("districtAr");

		if (districtAr != null) {
			setDistrictAr(districtAr);
		}

		String cityEn = (String)attributes.get("cityEn");

		if (cityEn != null) {
			setCityEn(cityEn);
		}

		String cityAr = (String)attributes.get("cityAr");

		if (cityAr != null) {
			setCityAr(cityAr);
		}

		Boolean isNatAddress = (Boolean)attributes.get("isNatAddress");

		if (isNatAddress != null) {
			setIsNatAddress(isNatAddress);
		}
	}

	/**
	 * Returns the add no of this quotations user address.
	 *
	 * @return the add no of this quotations user address
	 */
	@Override
	public String getAddNo() {
		return model.getAddNo();
	}

	/**
	 * Returns the build no of this quotations user address.
	 *
	 * @return the build no of this quotations user address
	 */
	@Override
	public String getBuildNo() {
		return model.getBuildNo();
	}

	/**
	 * Returns the city ar of this quotations user address.
	 *
	 * @return the city ar of this quotations user address
	 */
	@Override
	public String getCityAr() {
		return model.getCityAr();
	}

	/**
	 * Returns the city en of this quotations user address.
	 *
	 * @return the city en of this quotations user address
	 */
	@Override
	public String getCityEn() {
		return model.getCityEn();
	}

	/**
	 * Returns the district ar of this quotations user address.
	 *
	 * @return the district ar of this quotations user address
	 */
	@Override
	public String getDistrictAr() {
		return model.getDistrictAr();
	}

	/**
	 * Returns the district en of this quotations user address.
	 *
	 * @return the district en of this quotations user address
	 */
	@Override
	public String getDistrictEn() {
		return model.getDistrictEn();
	}

	/**
	 * Returns the driver ID of this quotations user address.
	 *
	 * @return the driver ID of this quotations user address
	 */
	@Override
	public long getDriverId() {
		return model.getDriverId();
	}

	/**
	 * Returns the is nat address of this quotations user address.
	 *
	 * @return the is nat address of this quotations user address
	 */
	@Override
	public boolean getIsNatAddress() {
		return model.getIsNatAddress();
	}

	/**
	 * Returns the primary key of this quotations user address.
	 *
	 * @return the primary key of this quotations user address
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quotation ID of this quotations user address.
	 *
	 * @return the quotation ID of this quotations user address
	 */
	@Override
	public long getQuotationId() {
		return model.getQuotationId();
	}

	/**
	 * Returns the st name ar of this quotations user address.
	 *
	 * @return the st name ar of this quotations user address
	 */
	@Override
	public String getStNameAr() {
		return model.getStNameAr();
	}

	/**
	 * Returns the st name en of this quotations user address.
	 *
	 * @return the st name en of this quotations user address
	 */
	@Override
	public String getStNameEn() {
		return model.getStNameEn();
	}

	/**
	 * Returns the user address ID of this quotations user address.
	 *
	 * @return the user address ID of this quotations user address
	 */
	@Override
	public long getUserAddressId() {
		return model.getUserAddressId();
	}

	/**
	 * Returns the zip code of this quotations user address.
	 *
	 * @return the zip code of this quotations user address
	 */
	@Override
	public String getZipCode() {
		return model.getZipCode();
	}

	/**
	 * Returns <code>true</code> if this quotations user address is is nat address.
	 *
	 * @return <code>true</code> if this quotations user address is is nat address; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsNatAddress() {
		return model.isIsNatAddress();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the add no of this quotations user address.
	 *
	 * @param addNo the add no of this quotations user address
	 */
	@Override
	public void setAddNo(String addNo) {
		model.setAddNo(addNo);
	}

	/**
	 * Sets the build no of this quotations user address.
	 *
	 * @param buildNo the build no of this quotations user address
	 */
	@Override
	public void setBuildNo(String buildNo) {
		model.setBuildNo(buildNo);
	}

	/**
	 * Sets the city ar of this quotations user address.
	 *
	 * @param cityAr the city ar of this quotations user address
	 */
	@Override
	public void setCityAr(String cityAr) {
		model.setCityAr(cityAr);
	}

	/**
	 * Sets the city en of this quotations user address.
	 *
	 * @param cityEn the city en of this quotations user address
	 */
	@Override
	public void setCityEn(String cityEn) {
		model.setCityEn(cityEn);
	}

	/**
	 * Sets the district ar of this quotations user address.
	 *
	 * @param districtAr the district ar of this quotations user address
	 */
	@Override
	public void setDistrictAr(String districtAr) {
		model.setDistrictAr(districtAr);
	}

	/**
	 * Sets the district en of this quotations user address.
	 *
	 * @param districtEn the district en of this quotations user address
	 */
	@Override
	public void setDistrictEn(String districtEn) {
		model.setDistrictEn(districtEn);
	}

	/**
	 * Sets the driver ID of this quotations user address.
	 *
	 * @param driverId the driver ID of this quotations user address
	 */
	@Override
	public void setDriverId(long driverId) {
		model.setDriverId(driverId);
	}

	/**
	 * Sets whether this quotations user address is is nat address.
	 *
	 * @param isNatAddress the is nat address of this quotations user address
	 */
	@Override
	public void setIsNatAddress(boolean isNatAddress) {
		model.setIsNatAddress(isNatAddress);
	}

	/**
	 * Sets the primary key of this quotations user address.
	 *
	 * @param primaryKey the primary key of this quotations user address
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quotation ID of this quotations user address.
	 *
	 * @param quotationId the quotation ID of this quotations user address
	 */
	@Override
	public void setQuotationId(long quotationId) {
		model.setQuotationId(quotationId);
	}

	/**
	 * Sets the st name ar of this quotations user address.
	 *
	 * @param stNameAr the st name ar of this quotations user address
	 */
	@Override
	public void setStNameAr(String stNameAr) {
		model.setStNameAr(stNameAr);
	}

	/**
	 * Sets the st name en of this quotations user address.
	 *
	 * @param stNameEn the st name en of this quotations user address
	 */
	@Override
	public void setStNameEn(String stNameEn) {
		model.setStNameEn(stNameEn);
	}

	/**
	 * Sets the user address ID of this quotations user address.
	 *
	 * @param userAddressId the user address ID of this quotations user address
	 */
	@Override
	public void setUserAddressId(long userAddressId) {
		model.setUserAddressId(userAddressId);
	}

	/**
	 * Sets the zip code of this quotations user address.
	 *
	 * @param zipCode the zip code of this quotations user address
	 */
	@Override
	public void setZipCode(String zipCode) {
		model.setZipCode(zipCode);
	}

	@Override
	protected QuotationsUserAddressWrapper wrap(
		QuotationsUserAddress quotationsUserAddress) {

		return new QuotationsUserAddressWrapper(quotationsUserAddress);
	}

}