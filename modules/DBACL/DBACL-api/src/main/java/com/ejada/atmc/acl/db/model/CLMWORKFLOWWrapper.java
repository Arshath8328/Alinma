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
 * This class is a wrapper for {@link CLMWORKFLOW}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CLMWORKFLOW
 * @generated
 */
public class CLMWORKFLOWWrapper
	extends BaseModelWrapper<CLMWORKFLOW>
	implements CLMWORKFLOW, ModelWrapper<CLMWORKFLOW> {

	public CLMWORKFLOWWrapper(CLMWORKFLOW clmworkflow) {
		super(clmworkflow);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("role", getRole());
		attributes.put("initialStatus", getInitialStatus());
		attributes.put("action", getAction());
		attributes.put("newStatus", getNewStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String role = (String)attributes.get("role");

		if (role != null) {
			setRole(role);
		}

		String initialStatus = (String)attributes.get("initialStatus");

		if (initialStatus != null) {
			setInitialStatus(initialStatus);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		String newStatus = (String)attributes.get("newStatus");

		if (newStatus != null) {
			setNewStatus(newStatus);
		}
	}

	/**
	 * Returns the action of this clmworkflow.
	 *
	 * @return the action of this clmworkflow
	 */
	@Override
	public String getAction() {
		return model.getAction();
	}

	/**
	 * Returns the ID of this clmworkflow.
	 *
	 * @return the ID of this clmworkflow
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the initial status of this clmworkflow.
	 *
	 * @return the initial status of this clmworkflow
	 */
	@Override
	public String getInitialStatus() {
		return model.getInitialStatus();
	}

	/**
	 * Returns the new status of this clmworkflow.
	 *
	 * @return the new status of this clmworkflow
	 */
	@Override
	public String getNewStatus() {
		return model.getNewStatus();
	}

	/**
	 * Returns the primary key of this clmworkflow.
	 *
	 * @return the primary key of this clmworkflow
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role of this clmworkflow.
	 *
	 * @return the role of this clmworkflow
	 */
	@Override
	public String getRole() {
		return model.getRole();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the action of this clmworkflow.
	 *
	 * @param action the action of this clmworkflow
	 */
	@Override
	public void setAction(String action) {
		model.setAction(action);
	}

	/**
	 * Sets the ID of this clmworkflow.
	 *
	 * @param id the ID of this clmworkflow
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the initial status of this clmworkflow.
	 *
	 * @param initialStatus the initial status of this clmworkflow
	 */
	@Override
	public void setInitialStatus(String initialStatus) {
		model.setInitialStatus(initialStatus);
	}

	/**
	 * Sets the new status of this clmworkflow.
	 *
	 * @param newStatus the new status of this clmworkflow
	 */
	@Override
	public void setNewStatus(String newStatus) {
		model.setNewStatus(newStatus);
	}

	/**
	 * Sets the primary key of this clmworkflow.
	 *
	 * @param primaryKey the primary key of this clmworkflow
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role of this clmworkflow.
	 *
	 * @param role the role of this clmworkflow
	 */
	@Override
	public void setRole(String role) {
		model.setRole(role);
	}

	@Override
	protected CLMWORKFLOWWrapper wrap(CLMWORKFLOW clmworkflow) {
		return new CLMWORKFLOWWrapper(clmworkflow);
	}

}