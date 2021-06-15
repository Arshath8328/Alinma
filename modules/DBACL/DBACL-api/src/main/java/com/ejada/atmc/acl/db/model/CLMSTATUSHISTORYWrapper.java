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
 * This class is a wrapper for {@link CLMSTATUSHISTORY}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CLMSTATUSHISTORY
 * @generated
 */
public class CLMSTATUSHISTORYWrapper
	extends BaseModelWrapper<CLMSTATUSHISTORY>
	implements CLMSTATUSHISTORY, ModelWrapper<CLMSTATUSHISTORY> {

	public CLMSTATUSHISTORYWrapper(CLMSTATUSHISTORY clmstatushistory) {
		super(clmstatushistory);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("RefNo", getRefNo());
		attributes.put("date", getDate());
		attributes.put("userName", getUserName());
		attributes.put("claimStatus", getClaimStatus());
		attributes.put("reason", getReason());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String RefNo = (String)attributes.get("RefNo");

		if (RefNo != null) {
			setRefNo(RefNo);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String claimStatus = (String)attributes.get("claimStatus");

		if (claimStatus != null) {
			setClaimStatus(claimStatus);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
		}
	}

	/**
	 * Returns the claim status of this clmstatushistory.
	 *
	 * @return the claim status of this clmstatushistory
	 */
	@Override
	public String getClaimStatus() {
		return model.getClaimStatus();
	}

	/**
	 * Returns the date of this clmstatushistory.
	 *
	 * @return the date of this clmstatushistory
	 */
	@Override
	public Date getDate() {
		return model.getDate();
	}

	/**
	 * Returns the ID of this clmstatushistory.
	 *
	 * @return the ID of this clmstatushistory
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this clmstatushistory.
	 *
	 * @return the primary key of this clmstatushistory
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reason of this clmstatushistory.
	 *
	 * @return the reason of this clmstatushistory
	 */
	@Override
	public String getReason() {
		return model.getReason();
	}

	/**
	 * Returns the ref no of this clmstatushistory.
	 *
	 * @return the ref no of this clmstatushistory
	 */
	@Override
	public String getRefNo() {
		return model.getRefNo();
	}

	/**
	 * Returns the user name of this clmstatushistory.
	 *
	 * @return the user name of this clmstatushistory
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the claim status of this clmstatushistory.
	 *
	 * @param claimStatus the claim status of this clmstatushistory
	 */
	@Override
	public void setClaimStatus(String claimStatus) {
		model.setClaimStatus(claimStatus);
	}

	/**
	 * Sets the date of this clmstatushistory.
	 *
	 * @param date the date of this clmstatushistory
	 */
	@Override
	public void setDate(Date date) {
		model.setDate(date);
	}

	/**
	 * Sets the ID of this clmstatushistory.
	 *
	 * @param id the ID of this clmstatushistory
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this clmstatushistory.
	 *
	 * @param primaryKey the primary key of this clmstatushistory
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reason of this clmstatushistory.
	 *
	 * @param reason the reason of this clmstatushistory
	 */
	@Override
	public void setReason(String reason) {
		model.setReason(reason);
	}

	/**
	 * Sets the ref no of this clmstatushistory.
	 *
	 * @param RefNo the ref no of this clmstatushistory
	 */
	@Override
	public void setRefNo(String RefNo) {
		model.setRefNo(RefNo);
	}

	/**
	 * Sets the user name of this clmstatushistory.
	 *
	 * @param userName the user name of this clmstatushistory
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	@Override
	protected CLMSTATUSHISTORYWrapper wrap(CLMSTATUSHISTORY clmstatushistory) {
		return new CLMSTATUSHISTORYWrapper(clmstatushistory);
	}

}