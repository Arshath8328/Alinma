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
 * This class is a wrapper for {@link QuotationStatusHistory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationStatusHistory
 * @generated
 */
public class QuotationStatusHistoryWrapper
	extends BaseModelWrapper<QuotationStatusHistory>
	implements ModelWrapper<QuotationStatusHistory>, QuotationStatusHistory {

	public QuotationStatusHistoryWrapper(
		QuotationStatusHistory quotationStatusHistory) {

		super(quotationStatusHistory);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("historyId", getHistoryId());
		attributes.put("quotationId", getQuotationId());
		attributes.put("dateTime", getDateTime());
		attributes.put("userName", getUserName());
		attributes.put("status", getStatus());
		attributes.put("reason", getReason());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long historyId = (Long)attributes.get("historyId");

		if (historyId != null) {
			setHistoryId(historyId);
		}

		Long quotationId = (Long)attributes.get("quotationId");

		if (quotationId != null) {
			setQuotationId(quotationId);
		}

		Date dateTime = (Date)attributes.get("dateTime");

		if (dateTime != null) {
			setDateTime(dateTime);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
		}
	}

	/**
	 * Returns the date time of this quotation status history.
	 *
	 * @return the date time of this quotation status history
	 */
	@Override
	public Date getDateTime() {
		return model.getDateTime();
	}

	/**
	 * Returns the history ID of this quotation status history.
	 *
	 * @return the history ID of this quotation status history
	 */
	@Override
	public long getHistoryId() {
		return model.getHistoryId();
	}

	/**
	 * Returns the primary key of this quotation status history.
	 *
	 * @return the primary key of this quotation status history
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quotation ID of this quotation status history.
	 *
	 * @return the quotation ID of this quotation status history
	 */
	@Override
	public long getQuotationId() {
		return model.getQuotationId();
	}

	/**
	 * Returns the reason of this quotation status history.
	 *
	 * @return the reason of this quotation status history
	 */
	@Override
	public String getReason() {
		return model.getReason();
	}

	/**
	 * Returns the status of this quotation status history.
	 *
	 * @return the status of this quotation status history
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user name of this quotation status history.
	 *
	 * @return the user name of this quotation status history
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
	 * Sets the date time of this quotation status history.
	 *
	 * @param dateTime the date time of this quotation status history
	 */
	@Override
	public void setDateTime(Date dateTime) {
		model.setDateTime(dateTime);
	}

	/**
	 * Sets the history ID of this quotation status history.
	 *
	 * @param historyId the history ID of this quotation status history
	 */
	@Override
	public void setHistoryId(long historyId) {
		model.setHistoryId(historyId);
	}

	/**
	 * Sets the primary key of this quotation status history.
	 *
	 * @param primaryKey the primary key of this quotation status history
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quotation ID of this quotation status history.
	 *
	 * @param quotationId the quotation ID of this quotation status history
	 */
	@Override
	public void setQuotationId(long quotationId) {
		model.setQuotationId(quotationId);
	}

	/**
	 * Sets the reason of this quotation status history.
	 *
	 * @param reason the reason of this quotation status history
	 */
	@Override
	public void setReason(String reason) {
		model.setReason(reason);
	}

	/**
	 * Sets the status of this quotation status history.
	 *
	 * @param status the status of this quotation status history
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user name of this quotation status history.
	 *
	 * @param userName the user name of this quotation status history
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	@Override
	protected QuotationStatusHistoryWrapper wrap(
		QuotationStatusHistory quotationStatusHistory) {

		return new QuotationStatusHistoryWrapper(quotationStatusHistory);
	}

}