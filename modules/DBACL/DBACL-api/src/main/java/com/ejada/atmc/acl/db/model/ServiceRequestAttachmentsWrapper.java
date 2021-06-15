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

import java.sql.Blob;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ServiceRequestAttachments}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestAttachments
 * @generated
 */
public class ServiceRequestAttachmentsWrapper
	extends BaseModelWrapper<ServiceRequestAttachments>
	implements ModelWrapper<ServiceRequestAttachments>,
			   ServiceRequestAttachments {

	public ServiceRequestAttachmentsWrapper(
		ServiceRequestAttachments serviceRequestAttachments) {

		super(serviceRequestAttachments);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("FILE_ID", getFILE_ID());
		attributes.put("REFERENCE_NO", getREFERENCE_NO());
		attributes.put("ACTION_ID", getACTION_ID());
		attributes.put("FILE_CONTENT", getFILE_CONTENT());
		attributes.put("FILE_NAME", getFILE_NAME());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long FILE_ID = (Long)attributes.get("FILE_ID");

		if (FILE_ID != null) {
			setFILE_ID(FILE_ID);
		}

		String REFERENCE_NO = (String)attributes.get("REFERENCE_NO");

		if (REFERENCE_NO != null) {
			setREFERENCE_NO(REFERENCE_NO);
		}

		String ACTION_ID = (String)attributes.get("ACTION_ID");

		if (ACTION_ID != null) {
			setACTION_ID(ACTION_ID);
		}

		Blob FILE_CONTENT = (Blob)attributes.get("FILE_CONTENT");

		if (FILE_CONTENT != null) {
			setFILE_CONTENT(FILE_CONTENT);
		}

		String FILE_NAME = (String)attributes.get("FILE_NAME");

		if (FILE_NAME != null) {
			setFILE_NAME(FILE_NAME);
		}
	}

	/**
	 * Returns the action_id of this service request attachments.
	 *
	 * @return the action_id of this service request attachments
	 */
	@Override
	public String getACTION_ID() {
		return model.getACTION_ID();
	}

	/**
	 * Returns the file_content of this service request attachments.
	 *
	 * @return the file_content of this service request attachments
	 */
	@Override
	public Blob getFILE_CONTENT() {
		return model.getFILE_CONTENT();
	}

	/**
	 * Returns the file_id of this service request attachments.
	 *
	 * @return the file_id of this service request attachments
	 */
	@Override
	public long getFILE_ID() {
		return model.getFILE_ID();
	}

	/**
	 * Returns the file_name of this service request attachments.
	 *
	 * @return the file_name of this service request attachments
	 */
	@Override
	public String getFILE_NAME() {
		return model.getFILE_NAME();
	}

	/**
	 * Returns the primary key of this service request attachments.
	 *
	 * @return the primary key of this service request attachments
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reference_no of this service request attachments.
	 *
	 * @return the reference_no of this service request attachments
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
	 * Sets the action_id of this service request attachments.
	 *
	 * @param ACTION_ID the action_id of this service request attachments
	 */
	@Override
	public void setACTION_ID(String ACTION_ID) {
		model.setACTION_ID(ACTION_ID);
	}

	/**
	 * Sets the file_content of this service request attachments.
	 *
	 * @param FILE_CONTENT the file_content of this service request attachments
	 */
	@Override
	public void setFILE_CONTENT(Blob FILE_CONTENT) {
		model.setFILE_CONTENT(FILE_CONTENT);
	}

	/**
	 * Sets the file_id of this service request attachments.
	 *
	 * @param FILE_ID the file_id of this service request attachments
	 */
	@Override
	public void setFILE_ID(long FILE_ID) {
		model.setFILE_ID(FILE_ID);
	}

	/**
	 * Sets the file_name of this service request attachments.
	 *
	 * @param FILE_NAME the file_name of this service request attachments
	 */
	@Override
	public void setFILE_NAME(String FILE_NAME) {
		model.setFILE_NAME(FILE_NAME);
	}

	/**
	 * Sets the primary key of this service request attachments.
	 *
	 * @param primaryKey the primary key of this service request attachments
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reference_no of this service request attachments.
	 *
	 * @param REFERENCE_NO the reference_no of this service request attachments
	 */
	@Override
	public void setREFERENCE_NO(String REFERENCE_NO) {
		model.setREFERENCE_NO(REFERENCE_NO);
	}

	@Override
	protected ServiceRequestAttachmentsWrapper wrap(
		ServiceRequestAttachments serviceRequestAttachments) {

		return new ServiceRequestAttachmentsWrapper(serviceRequestAttachments);
	}

}