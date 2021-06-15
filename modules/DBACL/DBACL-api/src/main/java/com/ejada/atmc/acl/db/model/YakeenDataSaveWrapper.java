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
 * This class is a wrapper for {@link YakeenDataSave}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see YakeenDataSave
 * @generated
 */
public class YakeenDataSaveWrapper
	extends BaseModelWrapper<YakeenDataSave>
	implements ModelWrapper<YakeenDataSave>, YakeenDataSave {

	public YakeenDataSaveWrapper(YakeenDataSave yakeenDataSave) {
		super(yakeenDataSave);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("Id", getId());
		attributes.put("OldId", getOldId());
		attributes.put("sequenceNumber", getSequenceNumber());
		attributes.put("dob", getDob());
		attributes.put("serviceName", getServiceName());
		attributes.put("callingDate", getCallingDate());
		attributes.put("status", getStatus());
		attributes.put("serviceOutput", getServiceOutput());
		attributes.put("serviceCalledDate", getServiceCalledDate());
		attributes.put("serviceErrorMessage", getServiceErrorMessage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String Id = (String)attributes.get("Id");

		if (Id != null) {
			setId(Id);
		}

		String OldId = (String)attributes.get("OldId");

		if (OldId != null) {
			setOldId(OldId);
		}

		String sequenceNumber = (String)attributes.get("sequenceNumber");

		if (sequenceNumber != null) {
			setSequenceNumber(sequenceNumber);
		}

		Date dob = (Date)attributes.get("dob");

		if (dob != null) {
			setDob(dob);
		}

		String serviceName = (String)attributes.get("serviceName");

		if (serviceName != null) {
			setServiceName(serviceName);
		}

		Date callingDate = (Date)attributes.get("callingDate");

		if (callingDate != null) {
			setCallingDate(callingDate);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String serviceOutput = (String)attributes.get("serviceOutput");

		if (serviceOutput != null) {
			setServiceOutput(serviceOutput);
		}

		Date serviceCalledDate = (Date)attributes.get("serviceCalledDate");

		if (serviceCalledDate != null) {
			setServiceCalledDate(serviceCalledDate);
		}

		String serviceErrorMessage = (String)attributes.get(
			"serviceErrorMessage");

		if (serviceErrorMessage != null) {
			setServiceErrorMessage(serviceErrorMessage);
		}
	}

	/**
	 * Returns the calling date of this yakeen data save.
	 *
	 * @return the calling date of this yakeen data save
	 */
	@Override
	public Date getCallingDate() {
		return model.getCallingDate();
	}

	/**
	 * Returns the dob of this yakeen data save.
	 *
	 * @return the dob of this yakeen data save
	 */
	@Override
	public Date getDob() {
		return model.getDob();
	}

	/**
	 * Returns the ID of this yakeen data save.
	 *
	 * @return the ID of this yakeen data save
	 */
	@Override
	public String getId() {
		return model.getId();
	}

	/**
	 * Returns the old ID of this yakeen data save.
	 *
	 * @return the old ID of this yakeen data save
	 */
	@Override
	public String getOldId() {
		return model.getOldId();
	}

	/**
	 * Returns the primary key of this yakeen data save.
	 *
	 * @return the primary key of this yakeen data save
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sequence number of this yakeen data save.
	 *
	 * @return the sequence number of this yakeen data save
	 */
	@Override
	public String getSequenceNumber() {
		return model.getSequenceNumber();
	}

	/**
	 * Returns the service called date of this yakeen data save.
	 *
	 * @return the service called date of this yakeen data save
	 */
	@Override
	public Date getServiceCalledDate() {
		return model.getServiceCalledDate();
	}

	/**
	 * Returns the service error message of this yakeen data save.
	 *
	 * @return the service error message of this yakeen data save
	 */
	@Override
	public String getServiceErrorMessage() {
		return model.getServiceErrorMessage();
	}

	/**
	 * Returns the service name of this yakeen data save.
	 *
	 * @return the service name of this yakeen data save
	 */
	@Override
	public String getServiceName() {
		return model.getServiceName();
	}

	/**
	 * Returns the service output of this yakeen data save.
	 *
	 * @return the service output of this yakeen data save
	 */
	@Override
	public String getServiceOutput() {
		return model.getServiceOutput();
	}

	/**
	 * Returns the status of this yakeen data save.
	 *
	 * @return the status of this yakeen data save
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the calling date of this yakeen data save.
	 *
	 * @param callingDate the calling date of this yakeen data save
	 */
	@Override
	public void setCallingDate(Date callingDate) {
		model.setCallingDate(callingDate);
	}

	/**
	 * Sets the dob of this yakeen data save.
	 *
	 * @param dob the dob of this yakeen data save
	 */
	@Override
	public void setDob(Date dob) {
		model.setDob(dob);
	}

	/**
	 * Sets the ID of this yakeen data save.
	 *
	 * @param Id the ID of this yakeen data save
	 */
	@Override
	public void setId(String Id) {
		model.setId(Id);
	}

	/**
	 * Sets the old ID of this yakeen data save.
	 *
	 * @param OldId the old ID of this yakeen data save
	 */
	@Override
	public void setOldId(String OldId) {
		model.setOldId(OldId);
	}

	/**
	 * Sets the primary key of this yakeen data save.
	 *
	 * @param primaryKey the primary key of this yakeen data save
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sequence number of this yakeen data save.
	 *
	 * @param sequenceNumber the sequence number of this yakeen data save
	 */
	@Override
	public void setSequenceNumber(String sequenceNumber) {
		model.setSequenceNumber(sequenceNumber);
	}

	/**
	 * Sets the service called date of this yakeen data save.
	 *
	 * @param serviceCalledDate the service called date of this yakeen data save
	 */
	@Override
	public void setServiceCalledDate(Date serviceCalledDate) {
		model.setServiceCalledDate(serviceCalledDate);
	}

	/**
	 * Sets the service error message of this yakeen data save.
	 *
	 * @param serviceErrorMessage the service error message of this yakeen data save
	 */
	@Override
	public void setServiceErrorMessage(String serviceErrorMessage) {
		model.setServiceErrorMessage(serviceErrorMessage);
	}

	/**
	 * Sets the service name of this yakeen data save.
	 *
	 * @param serviceName the service name of this yakeen data save
	 */
	@Override
	public void setServiceName(String serviceName) {
		model.setServiceName(serviceName);
	}

	/**
	 * Sets the service output of this yakeen data save.
	 *
	 * @param serviceOutput the service output of this yakeen data save
	 */
	@Override
	public void setServiceOutput(String serviceOutput) {
		model.setServiceOutput(serviceOutput);
	}

	/**
	 * Sets the status of this yakeen data save.
	 *
	 * @param status the status of this yakeen data save
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	@Override
	protected YakeenDataSaveWrapper wrap(YakeenDataSave yakeenDataSave) {
		return new YakeenDataSaveWrapper(yakeenDataSave);
	}

}