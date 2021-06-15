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

import com.ejada.atmc.acl.db.model.CustomerIban;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CustomerIban in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CustomerIbanCacheModel
	implements CacheModel<CustomerIban>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CustomerIbanCacheModel)) {
			return false;
		}

		CustomerIbanCacheModel customerIbanCacheModel =
			(CustomerIbanCacheModel)object;

		if (id.equals(customerIbanCacheModel.id)) {
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
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", refCode=");
		sb.append(refCode);
		sb.append(", premiaCCode=");
		sb.append(premiaCCode);
		sb.append(", iban=");
		sb.append(iban);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CustomerIban toEntityModel() {
		CustomerIbanImpl customerIbanImpl = new CustomerIbanImpl();

		if (id == null) {
			customerIbanImpl.setId("");
		}
		else {
			customerIbanImpl.setId(id);
		}

		if (refCode == null) {
			customerIbanImpl.setRefCode("");
		}
		else {
			customerIbanImpl.setRefCode(refCode);
		}

		if (premiaCCode == null) {
			customerIbanImpl.setPremiaCCode("");
		}
		else {
			customerIbanImpl.setPremiaCCode(premiaCCode);
		}

		if (iban == null) {
			customerIbanImpl.setIban("");
		}
		else {
			customerIbanImpl.setIban(iban);
		}

		customerIbanImpl.resetOriginalValues();

		return customerIbanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readUTF();
		refCode = objectInput.readUTF();
		premiaCCode = objectInput.readUTF();
		iban = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (id == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(id);
		}

		if (refCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(refCode);
		}

		if (premiaCCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(premiaCCode);
		}

		if (iban == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(iban);
		}
	}

	public String id;
	public String refCode;
	public String premiaCCode;
	public String iban;

}