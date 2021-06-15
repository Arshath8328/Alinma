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
 * This class is a wrapper for {@link QuotationsSeq}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsSeq
 * @generated
 */
public class QuotationsSeqWrapper
	extends BaseModelWrapper<QuotationsSeq>
	implements ModelWrapper<QuotationsSeq>, QuotationsSeq {

	public QuotationsSeqWrapper(QuotationsSeq quotationsSeq) {
		super(quotationsSeq);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("key", getKey());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	 * Returns the key of this quotations seq.
	 *
	 * @return the key of this quotations seq
	 */
	@Override
	public String getKey() {
		return model.getKey();
	}

	/**
	 * Returns the primary key of this quotations seq.
	 *
	 * @return the primary key of this quotations seq
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the value of this quotations seq.
	 *
	 * @return the value of this quotations seq
	 */
	@Override
	public String getValue() {
		return model.getValue();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the key of this quotations seq.
	 *
	 * @param key the key of this quotations seq
	 */
	@Override
	public void setKey(String key) {
		model.setKey(key);
	}

	/**
	 * Sets the primary key of this quotations seq.
	 *
	 * @param primaryKey the primary key of this quotations seq
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the value of this quotations seq.
	 *
	 * @param value the value of this quotations seq
	 */
	@Override
	public void setValue(String value) {
		model.setValue(value);
	}

	@Override
	protected QuotationsSeqWrapper wrap(QuotationsSeq quotationsSeq) {
		return new QuotationsSeqWrapper(quotationsSeq);
	}

}