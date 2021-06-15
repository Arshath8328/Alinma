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
 * This class is a wrapper for {@link CLMSTATUS}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CLMSTATUS
 * @generated
 */
public class CLMSTATUSWrapper
	extends BaseModelWrapper<CLMSTATUS>
	implements CLMSTATUS, ModelWrapper<CLMSTATUS> {

	public CLMSTATUSWrapper(CLMSTATUS clmstatus) {
		super(clmstatus);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("RefNo", getRefNo());
		attributes.put("claimStatus", getClaimStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String RefNo = (String)attributes.get("RefNo");

		if (RefNo != null) {
			setRefNo(RefNo);
		}

		String claimStatus = (String)attributes.get("claimStatus");

		if (claimStatus != null) {
			setClaimStatus(claimStatus);
		}
	}

	/**
	 * Returns the claim status of this clmstatus.
	 *
	 * @return the claim status of this clmstatus
	 */
	@Override
	public String getClaimStatus() {
		return model.getClaimStatus();
	}

	/**
	 * Returns the primary key of this clmstatus.
	 *
	 * @return the primary key of this clmstatus
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ref no of this clmstatus.
	 *
	 * @return the ref no of this clmstatus
	 */
	@Override
	public String getRefNo() {
		return model.getRefNo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the claim status of this clmstatus.
	 *
	 * @param claimStatus the claim status of this clmstatus
	 */
	@Override
	public void setClaimStatus(String claimStatus) {
		model.setClaimStatus(claimStatus);
	}

	/**
	 * Sets the primary key of this clmstatus.
	 *
	 * @param primaryKey the primary key of this clmstatus
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ref no of this clmstatus.
	 *
	 * @param RefNo the ref no of this clmstatus
	 */
	@Override
	public void setRefNo(String RefNo) {
		model.setRefNo(RefNo);
	}

	@Override
	protected CLMSTATUSWrapper wrap(CLMSTATUS clmstatus) {
		return new CLMSTATUSWrapper(clmstatus);
	}

}