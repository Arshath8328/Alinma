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
 * The base model interface for the ServiceRequestHistory service. Represents a row in the &quot;SERVICE_REQUEST_ACTION_HISTORY&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ejada.atmc.acl.db.model.impl.ServiceRequestHistoryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ejada.atmc.acl.db.model.impl.ServiceRequestHistoryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestHistory
 * @generated
 */
@ProviderType
public interface ServiceRequestHistoryModel
	extends BaseModel<ServiceRequestHistory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a service request history model instance should use the {@link ServiceRequestHistory} interface instead.
	 */

	/**
	 * Returns the primary key of this service request history.
	 *
	 * @return the primary key of this service request history
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this service request history.
	 *
	 * @param primaryKey the primary key of this service request history
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the action_id of this service request history.
	 *
	 * @return the action_id of this service request history
	 */
	public long getACTION_ID();

	/**
	 * Sets the action_id of this service request history.
	 *
	 * @param ACTION_ID the action_id of this service request history
	 */
	public void setACTION_ID(long ACTION_ID);

	/**
	 * Returns the reference_no of this service request history.
	 *
	 * @return the reference_no of this service request history
	 */
	@AutoEscape
	public String getREFERENCE_NO();

	/**
	 * Sets the reference_no of this service request history.
	 *
	 * @param REFERENCE_NO the reference_no of this service request history
	 */
	public void setREFERENCE_NO(String REFERENCE_NO);

	/**
	 * Returns the action_type of this service request history.
	 *
	 * @return the action_type of this service request history
	 */
	@AutoEscape
	public String getACTION_TYPE();

	/**
	 * Sets the action_type of this service request history.
	 *
	 * @param ACTION_TYPE the action_type of this service request history
	 */
	public void setACTION_TYPE(String ACTION_TYPE);

	/**
	 * Returns the action_details of this service request history.
	 *
	 * @return the action_details of this service request history
	 */
	@AutoEscape
	public String getACTION_DETAILS();

	/**
	 * Sets the action_details of this service request history.
	 *
	 * @param ACTION_DETAILS the action_details of this service request history
	 */
	public void setACTION_DETAILS(String ACTION_DETAILS);

	/**
	 * Returns the action_remarks of this service request history.
	 *
	 * @return the action_remarks of this service request history
	 */
	@AutoEscape
	public String getACTION_REMARKS();

	/**
	 * Sets the action_remarks of this service request history.
	 *
	 * @param ACTION_REMARKS the action_remarks of this service request history
	 */
	public void setACTION_REMARKS(String ACTION_REMARKS);

	/**
	 * Returns the action_date of this service request history.
	 *
	 * @return the action_date of this service request history
	 */
	public Date getACTION_DATE();

	/**
	 * Sets the action_date of this service request history.
	 *
	 * @param ACTION_DATE the action_date of this service request history
	 */
	public void setACTION_DATE(Date ACTION_DATE);

}