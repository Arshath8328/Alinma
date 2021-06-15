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

package com.ejada.atmc.acl.db.model.impl;

import com.ejada.atmc.acl.db.model.Customer;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Customer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CustomerCacheModel
	implements CacheModel<Customer>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CustomerCacheModel)) {
			return false;
		}

		CustomerCacheModel customerCacheModel = (CustomerCacheModel)object;

		if (id.equals(customerCacheModel.id)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{id=");
		sb.append(id);
		sb.append(", nameEn=");
		sb.append(nameEn);
		sb.append(", nameAr=");
		sb.append(nameAr);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", email=");
		sb.append(email);
		sb.append(", nationality=");
		sb.append(nationality);
		sb.append(", customerBirthDay=");
		sb.append(customerBirthDay);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", buildingNo=");
		sb.append(buildingNo);
		sb.append(", unitNo=");
		sb.append(unitNo);
		sb.append(", street=");
		sb.append(street);
		sb.append(", district=");
		sb.append(district);
		sb.append(", zipCode=");
		sb.append(zipCode);
		sb.append(", additNo=");
		sb.append(additNo);
		sb.append(", city=");
		sb.append(city);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Customer toEntityModel() {
		CustomerImpl customerImpl = new CustomerImpl();

		if (id == null) {
			customerImpl.setId("");
		}
		else {
			customerImpl.setId(id);
		}

		if (nameEn == null) {
			customerImpl.setNameEn("");
		}
		else {
			customerImpl.setNameEn(nameEn);
		}

		if (nameAr == null) {
			customerImpl.setNameAr("");
		}
		else {
			customerImpl.setNameAr(nameAr);
		}

		if (phone == null) {
			customerImpl.setPhone("");
		}
		else {
			customerImpl.setPhone(phone);
		}

		if (email == null) {
			customerImpl.setEmail("");
		}
		else {
			customerImpl.setEmail(email);
		}

		if (nationality == null) {
			customerImpl.setNationality("");
		}
		else {
			customerImpl.setNationality(nationality);
		}

		if (customerBirthDay == Long.MIN_VALUE) {
			customerImpl.setCustomerBirthDay(null);
		}
		else {
			customerImpl.setCustomerBirthDay(new Date(customerBirthDay));
		}

		if (gender == null) {
			customerImpl.setGender("");
		}
		else {
			customerImpl.setGender(gender);
		}

		if (buildingNo == null) {
			customerImpl.setBuildingNo("");
		}
		else {
			customerImpl.setBuildingNo(buildingNo);
		}

		if (unitNo == null) {
			customerImpl.setUnitNo("");
		}
		else {
			customerImpl.setUnitNo(unitNo);
		}

		if (street == null) {
			customerImpl.setStreet("");
		}
		else {
			customerImpl.setStreet(street);
		}

		if (district == null) {
			customerImpl.setDistrict("");
		}
		else {
			customerImpl.setDistrict(district);
		}

		if (zipCode == null) {
			customerImpl.setZipCode("");
		}
		else {
			customerImpl.setZipCode(zipCode);
		}

		if (additNo == null) {
			customerImpl.setAdditNo("");
		}
		else {
			customerImpl.setAdditNo(additNo);
		}

		if (city == null) {
			customerImpl.setCity("");
		}
		else {
			customerImpl.setCity(city);
		}

		customerImpl.resetOriginalValues();

		return customerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readUTF();
		nameEn = objectInput.readUTF();
		nameAr = objectInput.readUTF();
		phone = objectInput.readUTF();
		email = objectInput.readUTF();
		nationality = objectInput.readUTF();
		customerBirthDay = objectInput.readLong();
		gender = objectInput.readUTF();
		buildingNo = objectInput.readUTF();
		unitNo = objectInput.readUTF();
		street = objectInput.readUTF();
		district = objectInput.readUTF();
		zipCode = objectInput.readUTF();
		additNo = objectInput.readUTF();
		city = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (id == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(id);
		}

		if (nameEn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameEn);
		}

		if (nameAr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameAr);
		}

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (nationality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationality);
		}

		objectOutput.writeLong(customerBirthDay);

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (buildingNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(buildingNo);
		}

		if (unitNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(unitNo);
		}

		if (street == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(street);
		}

		if (district == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(district);
		}

		if (zipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zipCode);
		}

		if (additNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(additNo);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}
	}

	public String id;
	public String nameEn;
	public String nameAr;
	public String phone;
	public String email;
	public String nationality;
	public long customerBirthDay;
	public String gender;
	public String buildingNo;
	public String unitNo;
	public String street;
	public String district;
	public String zipCode;
	public String additNo;
	public String city;

}