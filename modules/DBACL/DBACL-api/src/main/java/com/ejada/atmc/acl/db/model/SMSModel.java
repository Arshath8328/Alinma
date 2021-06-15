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
 * The base model interface for the SMS service. Represents a row in the &quot;sms&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ejada.atmc.acl.db.model.impl.SMSModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ejada.atmc.acl.db.model.impl.SMSImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SMS
 * @generated
 */
@ProviderType
public interface SMSModel extends BaseModel<SMS> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a Sms Table model instance should use the {@link SMS} interface instead.
	 */

	/**
	 * Returns the primary key of this Sms Table.
	 *
	 * @return the primary key of this Sms Table
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this Sms Table.
	 *
	 * @param primaryKey the primary key of this Sms Table
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this Sms Table.
	 *
	 * @return the ID of this Sms Table
	 */
	public long getID();

	/**
	 * Sets the ID of this Sms Table.
	 *
	 * @param ID the ID of this Sms Table
	 */
	public void setID(long ID);

	/**
	 * Returns the message of this Sms Table.
	 *
	 * @return the message of this Sms Table
	 */
	@AutoEscape
	public String getMessage();

	/**
	 * Sets the message of this Sms Table.
	 *
	 * @param message the message of this Sms Table
	 */
	public void setMessage(String message);

	/**
	 * Returns the mobile of this Sms Table.
	 *
	 * @return the mobile of this Sms Table
	 */
	@AutoEscape
	public String getMobile();

	/**
	 * Sets the mobile of this Sms Table.
	 *
	 * @param mobile the mobile of this Sms Table
	 */
	public void setMobile(String mobile);

	/**
	 * Returns the sms type of this Sms Table.
	 *
	 * @return the sms type of this Sms Table
	 */
	@AutoEscape
	public String getSmsType();

	/**
	 * Sets the sms type of this Sms Table.
	 *
	 * @param smsType the sms type of this Sms Table
	 */
	public void setSmsType(String smsType);

}