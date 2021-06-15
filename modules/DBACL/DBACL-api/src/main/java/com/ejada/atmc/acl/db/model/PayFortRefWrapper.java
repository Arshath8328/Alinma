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
 * This class is a wrapper for {@link PayFortRef}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayFortRef
 * @generated
 */
public class PayFortRefWrapper
	extends BaseModelWrapper<PayFortRef>
	implements ModelWrapper<PayFortRef>, PayFortRef {

	public PayFortRefWrapper(PayFortRef payFortRef) {
		super(payFortRef);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("iqama_id", getIqama_id());
		attributes.put("payFortRefNo", getPayFortRefNo());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String iqama_id = (String)attributes.get("iqama_id");

		if (iqama_id != null) {
			setIqama_id(iqama_id);
		}

		String payFortRefNo = (String)attributes.get("payFortRefNo");

		if (payFortRefNo != null) {
			setPayFortRefNo(payFortRefNo);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the ID of this pay fort ref.
	 *
	 * @return the ID of this pay fort ref
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the iqama_id of this pay fort ref.
	 *
	 * @return the iqama_id of this pay fort ref
	 */
	@Override
	public String getIqama_id() {
		return model.getIqama_id();
	}

	/**
	 * Returns the pay fort ref no of this pay fort ref.
	 *
	 * @return the pay fort ref no of this pay fort ref
	 */
	@Override
	public String getPayFortRefNo() {
		return model.getPayFortRefNo();
	}

	/**
	 * Returns the primary key of this pay fort ref.
	 *
	 * @return the primary key of this pay fort ref
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this pay fort ref.
	 *
	 * @return the status of this pay fort ref
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ID of this pay fort ref.
	 *
	 * @param id the ID of this pay fort ref
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the iqama_id of this pay fort ref.
	 *
	 * @param iqama_id the iqama_id of this pay fort ref
	 */
	@Override
	public void setIqama_id(String iqama_id) {
		model.setIqama_id(iqama_id);
	}

	/**
	 * Sets the pay fort ref no of this pay fort ref.
	 *
	 * @param payFortRefNo the pay fort ref no of this pay fort ref
	 */
	@Override
	public void setPayFortRefNo(String payFortRefNo) {
		model.setPayFortRefNo(payFortRefNo);
	}

	/**
	 * Sets the primary key of this pay fort ref.
	 *
	 * @param primaryKey the primary key of this pay fort ref
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this pay fort ref.
	 *
	 * @param status the status of this pay fort ref
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	@Override
	protected PayFortRefWrapper wrap(PayFortRef payFortRef) {
		return new PayFortRefWrapper(payFortRef);
	}

}