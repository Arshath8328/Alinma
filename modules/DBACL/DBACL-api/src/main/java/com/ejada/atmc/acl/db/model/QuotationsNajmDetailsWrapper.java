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
 * This class is a wrapper for {@link QuotationsNajmDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsNajmDetails
 * @generated
 */
public class QuotationsNajmDetailsWrapper
	extends BaseModelWrapper<QuotationsNajmDetails>
	implements ModelWrapper<QuotationsNajmDetails>, QuotationsNajmDetails {

	public QuotationsNajmDetailsWrapper(
		QuotationsNajmDetails quotationsNajmDetails) {

		super(quotationsNajmDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("caseNumber", getCaseNumber());
		attributes.put("quotationId", getQuotationId());
		attributes.put("accidentDate", getAccidentDate());
		attributes.put("liability", getLiability());
		attributes.put("driverAge", getDriverAge());
		attributes.put("carModel", getCarModel());
		attributes.put("carType", getCarType());
		attributes.put("driverID", getDriverID());
		attributes.put("sequenceNumber", getSequenceNumber());
		attributes.put("ownerID", getOwnerID());
		attributes.put("estimatedAmount", getEstimatedAmount());
		attributes.put("damageParts", getDamageParts());
		attributes.put("causeOfAccident", getCauseOfAccident());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String caseNumber = (String)attributes.get("caseNumber");

		if (caseNumber != null) {
			setCaseNumber(caseNumber);
		}

		Long quotationId = (Long)attributes.get("quotationId");

		if (quotationId != null) {
			setQuotationId(quotationId);
		}

		String accidentDate = (String)attributes.get("accidentDate");

		if (accidentDate != null) {
			setAccidentDate(accidentDate);
		}

		String liability = (String)attributes.get("liability");

		if (liability != null) {
			setLiability(liability);
		}

		String driverAge = (String)attributes.get("driverAge");

		if (driverAge != null) {
			setDriverAge(driverAge);
		}

		String carModel = (String)attributes.get("carModel");

		if (carModel != null) {
			setCarModel(carModel);
		}

		String carType = (String)attributes.get("carType");

		if (carType != null) {
			setCarType(carType);
		}

		String driverID = (String)attributes.get("driverID");

		if (driverID != null) {
			setDriverID(driverID);
		}

		String sequenceNumber = (String)attributes.get("sequenceNumber");

		if (sequenceNumber != null) {
			setSequenceNumber(sequenceNumber);
		}

		String ownerID = (String)attributes.get("ownerID");

		if (ownerID != null) {
			setOwnerID(ownerID);
		}

		String estimatedAmount = (String)attributes.get("estimatedAmount");

		if (estimatedAmount != null) {
			setEstimatedAmount(estimatedAmount);
		}

		String damageParts = (String)attributes.get("damageParts");

		if (damageParts != null) {
			setDamageParts(damageParts);
		}

		String causeOfAccident = (String)attributes.get("causeOfAccident");

		if (causeOfAccident != null) {
			setCauseOfAccident(causeOfAccident);
		}
	}

	/**
	 * Returns the accident date of this quotations najm details.
	 *
	 * @return the accident date of this quotations najm details
	 */
	@Override
	public String getAccidentDate() {
		return model.getAccidentDate();
	}

	/**
	 * Returns the car model of this quotations najm details.
	 *
	 * @return the car model of this quotations najm details
	 */
	@Override
	public String getCarModel() {
		return model.getCarModel();
	}

	/**
	 * Returns the car type of this quotations najm details.
	 *
	 * @return the car type of this quotations najm details
	 */
	@Override
	public String getCarType() {
		return model.getCarType();
	}

	/**
	 * Returns the case number of this quotations najm details.
	 *
	 * @return the case number of this quotations najm details
	 */
	@Override
	public String getCaseNumber() {
		return model.getCaseNumber();
	}

	/**
	 * Returns the cause of accident of this quotations najm details.
	 *
	 * @return the cause of accident of this quotations najm details
	 */
	@Override
	public String getCauseOfAccident() {
		return model.getCauseOfAccident();
	}

	/**
	 * Returns the damage parts of this quotations najm details.
	 *
	 * @return the damage parts of this quotations najm details
	 */
	@Override
	public String getDamageParts() {
		return model.getDamageParts();
	}

	/**
	 * Returns the driver age of this quotations najm details.
	 *
	 * @return the driver age of this quotations najm details
	 */
	@Override
	public String getDriverAge() {
		return model.getDriverAge();
	}

	/**
	 * Returns the driver ID of this quotations najm details.
	 *
	 * @return the driver ID of this quotations najm details
	 */
	@Override
	public String getDriverID() {
		return model.getDriverID();
	}

	/**
	 * Returns the estimated amount of this quotations najm details.
	 *
	 * @return the estimated amount of this quotations najm details
	 */
	@Override
	public String getEstimatedAmount() {
		return model.getEstimatedAmount();
	}

	/**
	 * Returns the liability of this quotations najm details.
	 *
	 * @return the liability of this quotations najm details
	 */
	@Override
	public String getLiability() {
		return model.getLiability();
	}

	/**
	 * Returns the owner ID of this quotations najm details.
	 *
	 * @return the owner ID of this quotations najm details
	 */
	@Override
	public String getOwnerID() {
		return model.getOwnerID();
	}

	/**
	 * Returns the primary key of this quotations najm details.
	 *
	 * @return the primary key of this quotations najm details
	 */
	@Override
	public com.ejada.atmc.acl.db.service.persistence.QuotationsNajmDetailsPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the quotation ID of this quotations najm details.
	 *
	 * @return the quotation ID of this quotations najm details
	 */
	@Override
	public long getQuotationId() {
		return model.getQuotationId();
	}

	/**
	 * Returns the sequence number of this quotations najm details.
	 *
	 * @return the sequence number of this quotations najm details
	 */
	@Override
	public String getSequenceNumber() {
		return model.getSequenceNumber();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the accident date of this quotations najm details.
	 *
	 * @param accidentDate the accident date of this quotations najm details
	 */
	@Override
	public void setAccidentDate(String accidentDate) {
		model.setAccidentDate(accidentDate);
	}

	/**
	 * Sets the car model of this quotations najm details.
	 *
	 * @param carModel the car model of this quotations najm details
	 */
	@Override
	public void setCarModel(String carModel) {
		model.setCarModel(carModel);
	}

	/**
	 * Sets the car type of this quotations najm details.
	 *
	 * @param carType the car type of this quotations najm details
	 */
	@Override
	public void setCarType(String carType) {
		model.setCarType(carType);
	}

	/**
	 * Sets the case number of this quotations najm details.
	 *
	 * @param caseNumber the case number of this quotations najm details
	 */
	@Override
	public void setCaseNumber(String caseNumber) {
		model.setCaseNumber(caseNumber);
	}

	/**
	 * Sets the cause of accident of this quotations najm details.
	 *
	 * @param causeOfAccident the cause of accident of this quotations najm details
	 */
	@Override
	public void setCauseOfAccident(String causeOfAccident) {
		model.setCauseOfAccident(causeOfAccident);
	}

	/**
	 * Sets the damage parts of this quotations najm details.
	 *
	 * @param damageParts the damage parts of this quotations najm details
	 */
	@Override
	public void setDamageParts(String damageParts) {
		model.setDamageParts(damageParts);
	}

	/**
	 * Sets the driver age of this quotations najm details.
	 *
	 * @param driverAge the driver age of this quotations najm details
	 */
	@Override
	public void setDriverAge(String driverAge) {
		model.setDriverAge(driverAge);
	}

	/**
	 * Sets the driver ID of this quotations najm details.
	 *
	 * @param driverID the driver ID of this quotations najm details
	 */
	@Override
	public void setDriverID(String driverID) {
		model.setDriverID(driverID);
	}

	/**
	 * Sets the estimated amount of this quotations najm details.
	 *
	 * @param estimatedAmount the estimated amount of this quotations najm details
	 */
	@Override
	public void setEstimatedAmount(String estimatedAmount) {
		model.setEstimatedAmount(estimatedAmount);
	}

	/**
	 * Sets the liability of this quotations najm details.
	 *
	 * @param liability the liability of this quotations najm details
	 */
	@Override
	public void setLiability(String liability) {
		model.setLiability(liability);
	}

	/**
	 * Sets the owner ID of this quotations najm details.
	 *
	 * @param ownerID the owner ID of this quotations najm details
	 */
	@Override
	public void setOwnerID(String ownerID) {
		model.setOwnerID(ownerID);
	}

	/**
	 * Sets the primary key of this quotations najm details.
	 *
	 * @param primaryKey the primary key of this quotations najm details
	 */
	@Override
	public void setPrimaryKey(
		com.ejada.atmc.acl.db.service.persistence.QuotationsNajmDetailsPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quotation ID of this quotations najm details.
	 *
	 * @param quotationId the quotation ID of this quotations najm details
	 */
	@Override
	public void setQuotationId(long quotationId) {
		model.setQuotationId(quotationId);
	}

	/**
	 * Sets the sequence number of this quotations najm details.
	 *
	 * @param sequenceNumber the sequence number of this quotations najm details
	 */
	@Override
	public void setSequenceNumber(String sequenceNumber) {
		model.setSequenceNumber(sequenceNumber);
	}

	@Override
	protected QuotationsNajmDetailsWrapper wrap(
		QuotationsNajmDetails quotationsNajmDetails) {

		return new QuotationsNajmDetailsWrapper(quotationsNajmDetails);
	}

}