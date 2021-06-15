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
 * This class is a wrapper for {@link CompDiscount}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompDiscount
 * @generated
 */
public class CompDiscountWrapper
	extends BaseModelWrapper<CompDiscount>
	implements CompDiscount, ModelWrapper<CompDiscount> {

	public CompDiscountWrapper(CompDiscount compDiscount) {
		super(compDiscount);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("iqamaId", getIqamaId());
		attributes.put("schemeCode", getSchemeCode());
		attributes.put("companyCode", getCompanyCode());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String iqamaId = (String)attributes.get("iqamaId");

		if (iqamaId != null) {
			setIqamaId(iqamaId);
		}

		String schemeCode = (String)attributes.get("schemeCode");

		if (schemeCode != null) {
			setSchemeCode(schemeCode);
		}

		String companyCode = (String)attributes.get("companyCode");

		if (companyCode != null) {
			setCompanyCode(companyCode);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	/**
	 * Returns the company code of this comp discount.
	 *
	 * @return the company code of this comp discount
	 */
	@Override
	public String getCompanyCode() {
		return model.getCompanyCode();
	}

	/**
	 * Returns the end date of this comp discount.
	 *
	 * @return the end date of this comp discount
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the iqama ID of this comp discount.
	 *
	 * @return the iqama ID of this comp discount
	 */
	@Override
	public String getIqamaId() {
		return model.getIqamaId();
	}

	/**
	 * Returns the primary key of this comp discount.
	 *
	 * @return the primary key of this comp discount
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the scheme code of this comp discount.
	 *
	 * @return the scheme code of this comp discount
	 */
	@Override
	public String getSchemeCode() {
		return model.getSchemeCode();
	}

	/**
	 * Returns the start date of this comp discount.
	 *
	 * @return the start date of this comp discount
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company code of this comp discount.
	 *
	 * @param companyCode the company code of this comp discount
	 */
	@Override
	public void setCompanyCode(String companyCode) {
		model.setCompanyCode(companyCode);
	}

	/**
	 * Sets the end date of this comp discount.
	 *
	 * @param endDate the end date of this comp discount
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the iqama ID of this comp discount.
	 *
	 * @param iqamaId the iqama ID of this comp discount
	 */
	@Override
	public void setIqamaId(String iqamaId) {
		model.setIqamaId(iqamaId);
	}

	/**
	 * Sets the primary key of this comp discount.
	 *
	 * @param primaryKey the primary key of this comp discount
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the scheme code of this comp discount.
	 *
	 * @param schemeCode the scheme code of this comp discount
	 */
	@Override
	public void setSchemeCode(String schemeCode) {
		model.setSchemeCode(schemeCode);
	}

	/**
	 * Sets the start date of this comp discount.
	 *
	 * @param startDate the start date of this comp discount
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	@Override
	protected CompDiscountWrapper wrap(CompDiscount compDiscount) {
		return new CompDiscountWrapper(compDiscount);
	}

}