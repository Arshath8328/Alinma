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
 * This class is a wrapper for {@link SMS}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SMS
 * @generated
 */
public class SMSWrapper
	extends BaseModelWrapper<SMS> implements ModelWrapper<SMS>, SMS {

	public SMSWrapper(SMS sms) {
		super(sms);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("message", getMessage());
		attributes.put("mobile", getMobile());
		attributes.put("smsType", getSmsType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID = (Long)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String smsType = (String)attributes.get("smsType");

		if (smsType != null) {
			setSmsType(smsType);
		}
	}

	/**
	 * Returns the ID of this Sms Table.
	 *
	 * @return the ID of this Sms Table
	 */
	@Override
	public long getID() {
		return model.getID();
	}

	/**
	 * Returns the message of this Sms Table.
	 *
	 * @return the message of this Sms Table
	 */
	@Override
	public String getMessage() {
		return model.getMessage();
	}

	/**
	 * Returns the mobile of this Sms Table.
	 *
	 * @return the mobile of this Sms Table
	 */
	@Override
	public String getMobile() {
		return model.getMobile();
	}

	/**
	 * Returns the primary key of this Sms Table.
	 *
	 * @return the primary key of this Sms Table
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sms type of this Sms Table.
	 *
	 * @return the sms type of this Sms Table
	 */
	@Override
	public String getSmsType() {
		return model.getSmsType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ID of this Sms Table.
	 *
	 * @param ID the ID of this Sms Table
	 */
	@Override
	public void setID(long ID) {
		model.setID(ID);
	}

	/**
	 * Sets the message of this Sms Table.
	 *
	 * @param message the message of this Sms Table
	 */
	@Override
	public void setMessage(String message) {
		model.setMessage(message);
	}

	/**
	 * Sets the mobile of this Sms Table.
	 *
	 * @param mobile the mobile of this Sms Table
	 */
	@Override
	public void setMobile(String mobile) {
		model.setMobile(mobile);
	}

	/**
	 * Sets the primary key of this Sms Table.
	 *
	 * @param primaryKey the primary key of this Sms Table
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sms type of this Sms Table.
	 *
	 * @param smsType the sms type of this Sms Table
	 */
	@Override
	public void setSmsType(String smsType) {
		model.setSmsType(smsType);
	}

	@Override
	protected SMSWrapper wrap(SMS sms) {
		return new SMSWrapper(sms);
	}

}