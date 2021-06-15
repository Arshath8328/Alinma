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
 * This class is a wrapper for {@link CustomerIban}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomerIban
 * @generated
 */
public class CustomerIbanWrapper
	extends BaseModelWrapper<CustomerIban>
	implements CustomerIban, ModelWrapper<CustomerIban> {

	public CustomerIbanWrapper(CustomerIban customerIban) {
		super(customerIban);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("refCode", getRefCode());
		attributes.put("premiaCCode", getPremiaCCode());
		attributes.put("iban", getIban());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String id = (String)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String refCode = (String)attributes.get("refCode");

		if (refCode != null) {
			setRefCode(refCode);
		}

		String premiaCCode = (String)attributes.get("premiaCCode");

		if (premiaCCode != null) {
			setPremiaCCode(premiaCCode);
		}

		String iban = (String)attributes.get("iban");

		if (iban != null) {
			setIban(iban);
		}
	}

	/**
	 * Returns the iban of this customer iban.
	 *
	 * @return the iban of this customer iban
	 */
	@Override
	public String getIban() {
		return model.getIban();
	}

	/**
	 * Returns the ID of this customer iban.
	 *
	 * @return the ID of this customer iban
	 */
	@Override
	public String getId() {
		return model.getId();
	}

	/**
	 * Returns the premia c code of this customer iban.
	 *
	 * @return the premia c code of this customer iban
	 */
	@Override
	public String getPremiaCCode() {
		return model.getPremiaCCode();
	}

	/**
	 * Returns the primary key of this customer iban.
	 *
	 * @return the primary key of this customer iban
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ref code of this customer iban.
	 *
	 * @return the ref code of this customer iban
	 */
	@Override
	public String getRefCode() {
		return model.getRefCode();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the iban of this customer iban.
	 *
	 * @param iban the iban of this customer iban
	 */
	@Override
	public void setIban(String iban) {
		model.setIban(iban);
	}

	/**
	 * Sets the ID of this customer iban.
	 *
	 * @param id the ID of this customer iban
	 */
	@Override
	public void setId(String id) {
		model.setId(id);
	}

	/**
	 * Sets the premia c code of this customer iban.
	 *
	 * @param premiaCCode the premia c code of this customer iban
	 */
	@Override
	public void setPremiaCCode(String premiaCCode) {
		model.setPremiaCCode(premiaCCode);
	}

	/**
	 * Sets the primary key of this customer iban.
	 *
	 * @param primaryKey the primary key of this customer iban
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ref code of this customer iban.
	 *
	 * @param refCode the ref code of this customer iban
	 */
	@Override
	public void setRefCode(String refCode) {
		model.setRefCode(refCode);
	}

	@Override
	protected CustomerIbanWrapper wrap(CustomerIban customerIban) {
		return new CustomerIbanWrapper(customerIban);
	}

}