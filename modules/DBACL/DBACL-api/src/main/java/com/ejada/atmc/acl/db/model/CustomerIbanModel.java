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

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CustomerIban service. Represents a row in the &quot;MDM_CUSTOMER_IBAN&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ejada.atmc.acl.db.model.impl.CustomerIbanModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ejada.atmc.acl.db.model.impl.CustomerIbanImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomerIban
 * @generated
 */
@ProviderType
public interface CustomerIbanModel extends BaseModel<CustomerIban> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a customer iban model instance should use the {@link CustomerIban} interface instead.
	 */

	/**
	 * Returns the primary key of this customer iban.
	 *
	 * @return the primary key of this customer iban
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this customer iban.
	 *
	 * @param primaryKey the primary key of this customer iban
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the ID of this customer iban.
	 *
	 * @return the ID of this customer iban
	 */
	@AutoEscape
	public String getId();

	/**
	 * Sets the ID of this customer iban.
	 *
	 * @param id the ID of this customer iban
	 */
	public void setId(String id);

	/**
	 * Returns the ref code of this customer iban.
	 *
	 * @return the ref code of this customer iban
	 */
	@AutoEscape
	public String getRefCode();

	/**
	 * Sets the ref code of this customer iban.
	 *
	 * @param refCode the ref code of this customer iban
	 */
	public void setRefCode(String refCode);

	/**
	 * Returns the premia c code of this customer iban.
	 *
	 * @return the premia c code of this customer iban
	 */
	@AutoEscape
	public String getPremiaCCode();

	/**
	 * Sets the premia c code of this customer iban.
	 *
	 * @param premiaCCode the premia c code of this customer iban
	 */
	public void setPremiaCCode(String premiaCCode);

	/**
	 * Returns the iban of this customer iban.
	 *
	 * @return the iban of this customer iban
	 */
	@AutoEscape
	public String getIban();

	/**
	 * Sets the iban of this customer iban.
	 *
	 * @param iban the iban of this customer iban
	 */
	public void setIban(String iban);

}