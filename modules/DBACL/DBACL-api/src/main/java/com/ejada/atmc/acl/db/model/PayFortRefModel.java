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
 * The base model interface for the PayFortRef service. Represents a row in the &quot;PAYFORT_REF&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ejada.atmc.acl.db.model.impl.PayFortRefModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ejada.atmc.acl.db.model.impl.PayFortRefImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayFortRef
 * @generated
 */
@ProviderType
public interface PayFortRefModel extends BaseModel<PayFortRef> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a pay fort ref model instance should use the {@link PayFortRef} interface instead.
	 */

	/**
	 * Returns the primary key of this pay fort ref.
	 *
	 * @return the primary key of this pay fort ref
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this pay fort ref.
	 *
	 * @param primaryKey the primary key of this pay fort ref
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the ID of this pay fort ref.
	 *
	 * @return the ID of this pay fort ref
	 */
	public int getId();

	/**
	 * Sets the ID of this pay fort ref.
	 *
	 * @param id the ID of this pay fort ref
	 */
	public void setId(int id);

	/**
	 * Returns the iqama_id of this pay fort ref.
	 *
	 * @return the iqama_id of this pay fort ref
	 */
	@AutoEscape
	public String getIqama_id();

	/**
	 * Sets the iqama_id of this pay fort ref.
	 *
	 * @param iqama_id the iqama_id of this pay fort ref
	 */
	public void setIqama_id(String iqama_id);

	/**
	 * Returns the pay fort ref no of this pay fort ref.
	 *
	 * @return the pay fort ref no of this pay fort ref
	 */
	@AutoEscape
	public String getPayFortRefNo();

	/**
	 * Sets the pay fort ref no of this pay fort ref.
	 *
	 * @param payFortRefNo the pay fort ref no of this pay fort ref
	 */
	public void setPayFortRefNo(String payFortRefNo);

	/**
	 * Returns the status of this pay fort ref.
	 *
	 * @return the status of this pay fort ref
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this pay fort ref.
	 *
	 * @param status the status of this pay fort ref
	 */
	public void setStatus(String status);

}