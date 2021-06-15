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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Customer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Customer
 * @generated
 */
public class CustomerWrapper
	extends BaseModelWrapper<Customer>
	implements Customer, ModelWrapper<Customer> {

	public CustomerWrapper(Customer customer) {
		super(customer);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("nameEn", getNameEn());
		attributes.put("nameAr", getNameAr());
		attributes.put("phone", getPhone());
		attributes.put("email", getEmail());
		attributes.put("nationality", getNationality());
		attributes.put("customerBirthDay", getCustomerBirthDay());
		attributes.put("gender", getGender());
		attributes.put("buildingNo", getBuildingNo());
		attributes.put("unitNo", getUnitNo());
		attributes.put("street", getStreet());
		attributes.put("district", getDistrict());
		attributes.put("zipCode", getZipCode());
		attributes.put("additNo", getAdditNo());
		attributes.put("city", getCity());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String id = (String)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String nameEn = (String)attributes.get("nameEn");

		if (nameEn != null) {
			setNameEn(nameEn);
		}

		String nameAr = (String)attributes.get("nameAr");

		if (nameAr != null) {
			setNameAr(nameAr);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String nationality = (String)attributes.get("nationality");

		if (nationality != null) {
			setNationality(nationality);
		}

		Date customerBirthDay = (Date)attributes.get("customerBirthDay");

		if (customerBirthDay != null) {
			setCustomerBirthDay(customerBirthDay);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String buildingNo = (String)attributes.get("buildingNo");

		if (buildingNo != null) {
			setBuildingNo(buildingNo);
		}

		String unitNo = (String)attributes.get("unitNo");

		if (unitNo != null) {
			setUnitNo(unitNo);
		}

		String street = (String)attributes.get("street");

		if (street != null) {
			setStreet(street);
		}

		String district = (String)attributes.get("district");

		if (district != null) {
			setDistrict(district);
		}

		String zipCode = (String)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}

		String additNo = (String)attributes.get("additNo");

		if (additNo != null) {
			setAdditNo(additNo);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}
	}

	/**
	 * Returns the addit no of this customer.
	 *
	 * @return the addit no of this customer
	 */
	@Override
	public String getAdditNo() {
		return model.getAdditNo();
	}

	/**
	 * Returns the building no of this customer.
	 *
	 * @return the building no of this customer
	 */
	@Override
	public String getBuildingNo() {
		return model.getBuildingNo();
	}

	/**
	 * Returns the city of this customer.
	 *
	 * @return the city of this customer
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the customer birth day of this customer.
	 *
	 * @return the customer birth day of this customer
	 */
	@Override
	public Date getCustomerBirthDay() {
		return model.getCustomerBirthDay();
	}

	/**
	 * Returns the district of this customer.
	 *
	 * @return the district of this customer
	 */
	@Override
	public String getDistrict() {
		return model.getDistrict();
	}

	/**
	 * Returns the email of this customer.
	 *
	 * @return the email of this customer
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the gender of this customer.
	 *
	 * @return the gender of this customer
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the ID of this customer.
	 *
	 * @return the ID of this customer
	 */
	@Override
	public String getId() {
		return model.getId();
	}

	/**
	 * Returns the name ar of this customer.
	 *
	 * @return the name ar of this customer
	 */
	@Override
	public String getNameAr() {
		return model.getNameAr();
	}

	/**
	 * Returns the name en of this customer.
	 *
	 * @return the name en of this customer
	 */
	@Override
	public String getNameEn() {
		return model.getNameEn();
	}

	/**
	 * Returns the nationality of this customer.
	 *
	 * @return the nationality of this customer
	 */
	@Override
	public String getNationality() {
		return model.getNationality();
	}

	/**
	 * Returns the phone of this customer.
	 *
	 * @return the phone of this customer
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the primary key of this customer.
	 *
	 * @return the primary key of this customer
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the street of this customer.
	 *
	 * @return the street of this customer
	 */
	@Override
	public String getStreet() {
		return model.getStreet();
	}

	/**
	 * Returns the unit no of this customer.
	 *
	 * @return the unit no of this customer
	 */
	@Override
	public String getUnitNo() {
		return model.getUnitNo();
	}

	/**
	 * Returns the zip code of this customer.
	 *
	 * @return the zip code of this customer
	 */
	@Override
	public String getZipCode() {
		return model.getZipCode();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the addit no of this customer.
	 *
	 * @param additNo the addit no of this customer
	 */
	@Override
	public void setAdditNo(String additNo) {
		model.setAdditNo(additNo);
	}

	/**
	 * Sets the building no of this customer.
	 *
	 * @param buildingNo the building no of this customer
	 */
	@Override
	public void setBuildingNo(String buildingNo) {
		model.setBuildingNo(buildingNo);
	}

	/**
	 * Sets the city of this customer.
	 *
	 * @param city the city of this customer
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the customer birth day of this customer.
	 *
	 * @param customerBirthDay the customer birth day of this customer
	 */
	@Override
	public void setCustomerBirthDay(Date customerBirthDay) {
		model.setCustomerBirthDay(customerBirthDay);
	}

	/**
	 * Sets the district of this customer.
	 *
	 * @param district the district of this customer
	 */
	@Override
	public void setDistrict(String district) {
		model.setDistrict(district);
	}

	/**
	 * Sets the email of this customer.
	 *
	 * @param email the email of this customer
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the gender of this customer.
	 *
	 * @param gender the gender of this customer
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the ID of this customer.
	 *
	 * @param id the ID of this customer
	 */
	@Override
	public void setId(String id) {
		model.setId(id);
	}

	/**
	 * Sets the name ar of this customer.
	 *
	 * @param nameAr the name ar of this customer
	 */
	@Override
	public void setNameAr(String nameAr) {
		model.setNameAr(nameAr);
	}

	/**
	 * Sets the name en of this customer.
	 *
	 * @param nameEn the name en of this customer
	 */
	@Override
	public void setNameEn(String nameEn) {
		model.setNameEn(nameEn);
	}

	/**
	 * Sets the nationality of this customer.
	 *
	 * @param nationality the nationality of this customer
	 */
	@Override
	public void setNationality(String nationality) {
		model.setNationality(nationality);
	}

	/**
	 * Sets the phone of this customer.
	 *
	 * @param phone the phone of this customer
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the primary key of this customer.
	 *
	 * @param primaryKey the primary key of this customer
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the street of this customer.
	 *
	 * @param street the street of this customer
	 */
	@Override
	public void setStreet(String street) {
		model.setStreet(street);
	}

	/**
	 * Sets the unit no of this customer.
	 *
	 * @param unitNo the unit no of this customer
	 */
	@Override
	public void setUnitNo(String unitNo) {
		model.setUnitNo(unitNo);
	}

	/**
	 * Sets the zip code of this customer.
	 *
	 * @param zipCode the zip code of this customer
	 */
	@Override
	public void setZipCode(String zipCode) {
		model.setZipCode(zipCode);
	}

	@Override
	protected CustomerWrapper wrap(Customer customer) {
		return new CustomerWrapper(customer);
	}

}