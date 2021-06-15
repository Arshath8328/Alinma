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
 * This class is a wrapper for {@link ServiceRequestHistory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestHistory
 * @generated
 */
public class ServiceRequestHistoryWrapper
	extends BaseModelWrapper<ServiceRequestHistory>
	implements ModelWrapper<ServiceRequestHistory>, ServiceRequestHistory {

	public ServiceRequestHistoryWrapper(
		ServiceRequestHistory serviceRequestHistory) {

		super(serviceRequestHistory);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ACTION_ID", getACTION_ID());
		attributes.put("REFERENCE_NO", getREFERENCE_NO());
		attributes.put("ACTION_TYPE", getACTION_TYPE());
		attributes.put("ACTION_DETAILS", getACTION_DETAILS());
		attributes.put("ACTION_REMARKS", getACTION_REMARKS());
		attributes.put("ACTION_DATE", getACTION_DATE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ACTION_ID = (Long)attributes.get("ACTION_ID");

		if (ACTION_ID != null) {
			setACTION_ID(ACTION_ID);
		}

		String REFERENCE_NO = (String)attributes.get("REFERENCE_NO");

		if (REFERENCE_NO != null) {
			setREFERENCE_NO(REFERENCE_NO);
		}

		String ACTION_TYPE = (String)attributes.get("ACTION_TYPE");

		if (ACTION_TYPE != null) {
			setACTION_TYPE(ACTION_TYPE);
		}

		String ACTION_DETAILS = (String)attributes.get("ACTION_DETAILS");

		if (ACTION_DETAILS != null) {
			setACTION_DETAILS(ACTION_DETAILS);
		}

		String ACTION_REMARKS = (String)attributes.get("ACTION_REMARKS");

		if (ACTION_REMARKS != null) {
			setACTION_REMARKS(ACTION_REMARKS);
		}

		Date ACTION_DATE = (Date)attributes.get("ACTION_DATE");

		if (ACTION_DATE != null) {
			setACTION_DATE(ACTION_DATE);
		}
	}

	/**
	 * Returns the action_date of this service request history.
	 *
	 * @return the action_date of this service request history
	 */
	@Override
	public Date getACTION_DATE() {
		return model.getACTION_DATE();
	}

	/**
	 * Returns the action_details of this service request history.
	 *
	 * @return the action_details of this service request history
	 */
	@Override
	public String getACTION_DETAILS() {
		return model.getACTION_DETAILS();
	}

	/**
	 * Returns the action_id of this service request history.
	 *
	 * @return the action_id of this service request history
	 */
	@Override
	public long getACTION_ID() {
		return model.getACTION_ID();
	}

	/**
	 * Returns the action_remarks of this service request history.
	 *
	 * @return the action_remarks of this service request history
	 */
	@Override
	public String getACTION_REMARKS() {
		return model.getACTION_REMARKS();
	}

	/**
	 * Returns the action_type of this service request history.
	 *
	 * @return the action_type of this service request history
	 */
	@Override
	public String getACTION_TYPE() {
		return model.getACTION_TYPE();
	}

	/**
	 * Returns the primary key of this service request history.
	 *
	 * @return the primary key of this service request history
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reference_no of this service request history.
	 *
	 * @return the reference_no of this service request history
	 */
	@Override
	public String getREFERENCE_NO() {
		return model.getREFERENCE_NO();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the action_date of this service request history.
	 *
	 * @param ACTION_DATE the action_date of this service request history
	 */
	@Override
	public void setACTION_DATE(Date ACTION_DATE) {
		model.setACTION_DATE(ACTION_DATE);
	}

	/**
	 * Sets the action_details of this service request history.
	 *
	 * @param ACTION_DETAILS the action_details of this service request history
	 */
	@Override
	public void setACTION_DETAILS(String ACTION_DETAILS) {
		model.setACTION_DETAILS(ACTION_DETAILS);
	}

	/**
	 * Sets the action_id of this service request history.
	 *
	 * @param ACTION_ID the action_id of this service request history
	 */
	@Override
	public void setACTION_ID(long ACTION_ID) {
		model.setACTION_ID(ACTION_ID);
	}

	/**
	 * Sets the action_remarks of this service request history.
	 *
	 * @param ACTION_REMARKS the action_remarks of this service request history
	 */
	@Override
	public void setACTION_REMARKS(String ACTION_REMARKS) {
		model.setACTION_REMARKS(ACTION_REMARKS);
	}

	/**
	 * Sets the action_type of this service request history.
	 *
	 * @param ACTION_TYPE the action_type of this service request history
	 */
	@Override
	public void setACTION_TYPE(String ACTION_TYPE) {
		model.setACTION_TYPE(ACTION_TYPE);
	}

	/**
	 * Sets the primary key of this service request history.
	 *
	 * @param primaryKey the primary key of this service request history
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reference_no of this service request history.
	 *
	 * @param REFERENCE_NO the reference_no of this service request history
	 */
	@Override
	public void setREFERENCE_NO(String REFERENCE_NO) {
		model.setREFERENCE_NO(REFERENCE_NO);
	}

	@Override
	protected ServiceRequestHistoryWrapper wrap(
		ServiceRequestHistory serviceRequestHistory) {

		return new ServiceRequestHistoryWrapper(serviceRequestHistory);
	}

}