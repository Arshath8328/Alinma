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
 * This class is a wrapper for {@link ServiceRequestMessages}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestMessages
 * @generated
 */
public class ServiceRequestMessagesWrapper
	extends BaseModelWrapper<ServiceRequestMessages>
	implements ModelWrapper<ServiceRequestMessages>, ServiceRequestMessages {

	public ServiceRequestMessagesWrapper(
		ServiceRequestMessages serviceRequestMessages) {

		super(serviceRequestMessages);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("MESSAGE_ID", getMESSAGE_ID());
		attributes.put("REFERENCE_NO", getREFERENCE_NO());
		attributes.put("USER_ID", getUSER_ID());
		attributes.put("USER_NAME", getUSER_NAME());
		attributes.put("USER_TYPE", getUSER_TYPE());
		attributes.put("USER_MESSAGE", getUSER_MESSAGE());
		attributes.put("TIME_STAMP", getTIME_STAMP());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long MESSAGE_ID = (Long)attributes.get("MESSAGE_ID");

		if (MESSAGE_ID != null) {
			setMESSAGE_ID(MESSAGE_ID);
		}

		String REFERENCE_NO = (String)attributes.get("REFERENCE_NO");

		if (REFERENCE_NO != null) {
			setREFERENCE_NO(REFERENCE_NO);
		}

		String USER_ID = (String)attributes.get("USER_ID");

		if (USER_ID != null) {
			setUSER_ID(USER_ID);
		}

		String USER_NAME = (String)attributes.get("USER_NAME");

		if (USER_NAME != null) {
			setUSER_NAME(USER_NAME);
		}

		String USER_TYPE = (String)attributes.get("USER_TYPE");

		if (USER_TYPE != null) {
			setUSER_TYPE(USER_TYPE);
		}

		String USER_MESSAGE = (String)attributes.get("USER_MESSAGE");

		if (USER_MESSAGE != null) {
			setUSER_MESSAGE(USER_MESSAGE);
		}

		Date TIME_STAMP = (Date)attributes.get("TIME_STAMP");

		if (TIME_STAMP != null) {
			setTIME_STAMP(TIME_STAMP);
		}
	}

	/**
	 * Returns the message_id of this service request messages.
	 *
	 * @return the message_id of this service request messages
	 */
	@Override
	public long getMESSAGE_ID() {
		return model.getMESSAGE_ID();
	}

	/**
	 * Returns the primary key of this service request messages.
	 *
	 * @return the primary key of this service request messages
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reference_no of this service request messages.
	 *
	 * @return the reference_no of this service request messages
	 */
	@Override
	public String getREFERENCE_NO() {
		return model.getREFERENCE_NO();
	}

	/**
	 * Returns the time_stamp of this service request messages.
	 *
	 * @return the time_stamp of this service request messages
	 */
	@Override
	public Date getTIME_STAMP() {
		return model.getTIME_STAMP();
	}

	/**
	 * Returns the user_id of this service request messages.
	 *
	 * @return the user_id of this service request messages
	 */
	@Override
	public String getUSER_ID() {
		return model.getUSER_ID();
	}

	/**
	 * Returns the user_message of this service request messages.
	 *
	 * @return the user_message of this service request messages
	 */
	@Override
	public String getUSER_MESSAGE() {
		return model.getUSER_MESSAGE();
	}

	/**
	 * Returns the user_name of this service request messages.
	 *
	 * @return the user_name of this service request messages
	 */
	@Override
	public String getUSER_NAME() {
		return model.getUSER_NAME();
	}

	/**
	 * Returns the user_type of this service request messages.
	 *
	 * @return the user_type of this service request messages
	 */
	@Override
	public String getUSER_TYPE() {
		return model.getUSER_TYPE();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the message_id of this service request messages.
	 *
	 * @param MESSAGE_ID the message_id of this service request messages
	 */
	@Override
	public void setMESSAGE_ID(long MESSAGE_ID) {
		model.setMESSAGE_ID(MESSAGE_ID);
	}

	/**
	 * Sets the primary key of this service request messages.
	 *
	 * @param primaryKey the primary key of this service request messages
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reference_no of this service request messages.
	 *
	 * @param REFERENCE_NO the reference_no of this service request messages
	 */
	@Override
	public void setREFERENCE_NO(String REFERENCE_NO) {
		model.setREFERENCE_NO(REFERENCE_NO);
	}

	/**
	 * Sets the time_stamp of this service request messages.
	 *
	 * @param TIME_STAMP the time_stamp of this service request messages
	 */
	@Override
	public void setTIME_STAMP(Date TIME_STAMP) {
		model.setTIME_STAMP(TIME_STAMP);
	}

	/**
	 * Sets the user_id of this service request messages.
	 *
	 * @param USER_ID the user_id of this service request messages
	 */
	@Override
	public void setUSER_ID(String USER_ID) {
		model.setUSER_ID(USER_ID);
	}

	/**
	 * Sets the user_message of this service request messages.
	 *
	 * @param USER_MESSAGE the user_message of this service request messages
	 */
	@Override
	public void setUSER_MESSAGE(String USER_MESSAGE) {
		model.setUSER_MESSAGE(USER_MESSAGE);
	}

	/**
	 * Sets the user_name of this service request messages.
	 *
	 * @param USER_NAME the user_name of this service request messages
	 */
	@Override
	public void setUSER_NAME(String USER_NAME) {
		model.setUSER_NAME(USER_NAME);
	}

	/**
	 * Sets the user_type of this service request messages.
	 *
	 * @param USER_TYPE the user_type of this service request messages
	 */
	@Override
	public void setUSER_TYPE(String USER_TYPE) {
		model.setUSER_TYPE(USER_TYPE);
	}

	@Override
	protected ServiceRequestMessagesWrapper wrap(
		ServiceRequestMessages serviceRequestMessages) {

		return new ServiceRequestMessagesWrapper(serviceRequestMessages);
	}

}