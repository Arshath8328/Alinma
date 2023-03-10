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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CompDiscount service. Represents a row in the &quot;COMP_DISCOUNT&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ejada.atmc.acl.db.model.impl.CompDiscountModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ejada.atmc.acl.db.model.impl.CompDiscountImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompDiscount
 * @generated
 */
@ProviderType
public interface CompDiscountModel extends BaseModel<CompDiscount> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a comp discount model instance should use the {@link CompDiscount} interface instead.
	 */

	/**
	 * Returns the primary key of this comp discount.
	 *
	 * @return the primary key of this comp discount
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this comp discount.
	 *
	 * @param primaryKey the primary key of this comp discount
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the iqama ID of this comp discount.
	 *
	 * @return the iqama ID of this comp discount
	 */
	@AutoEscape
	public String getIqamaId();

	/**
	 * Sets the iqama ID of this comp discount.
	 *
	 * @param iqamaId the iqama ID of this comp discount
	 */
	public void setIqamaId(String iqamaId);

	/**
	 * Returns the scheme code of this comp discount.
	 *
	 * @return the scheme code of this comp discount
	 */
	@AutoEscape
	public String getSchemeCode();

	/**
	 * Sets the scheme code of this comp discount.
	 *
	 * @param schemeCode the scheme code of this comp discount
	 */
	public void setSchemeCode(String schemeCode);

	/**
	 * Returns the company code of this comp discount.
	 *
	 * @return the company code of this comp discount
	 */
	@AutoEscape
	public String getCompanyCode();

	/**
	 * Sets the company code of this comp discount.
	 *
	 * @param companyCode the company code of this comp discount
	 */
	public void setCompanyCode(String companyCode);

	/**
	 * Returns the start date of this comp discount.
	 *
	 * @return the start date of this comp discount
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this comp discount.
	 *
	 * @param startDate the start date of this comp discount
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this comp discount.
	 *
	 * @return the end date of this comp discount
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this comp discount.
	 *
	 * @param endDate the end date of this comp discount
	 */
	public void setEndDate(Date endDate);

}