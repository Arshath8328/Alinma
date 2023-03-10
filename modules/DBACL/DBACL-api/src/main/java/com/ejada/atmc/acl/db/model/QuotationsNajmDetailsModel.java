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

import com.ejada.atmc.acl.db.service.persistence.QuotationsNajmDetailsPK;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the QuotationsNajmDetails service. Represents a row in the &quot;EJD_QUOTATIONS_NAJM_DETAILS&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ejada.atmc.acl.db.model.impl.QuotationsNajmDetailsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ejada.atmc.acl.db.model.impl.QuotationsNajmDetailsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsNajmDetails
 * @generated
 */
@ProviderType
public interface QuotationsNajmDetailsModel
	extends BaseModel<QuotationsNajmDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a quotations najm details model instance should use the {@link QuotationsNajmDetails} interface instead.
	 */

	/**
	 * Returns the primary key of this quotations najm details.
	 *
	 * @return the primary key of this quotations najm details
	 */
	public QuotationsNajmDetailsPK getPrimaryKey();

	/**
	 * Sets the primary key of this quotations najm details.
	 *
	 * @param primaryKey the primary key of this quotations najm details
	 */
	public void setPrimaryKey(QuotationsNajmDetailsPK primaryKey);

	/**
	 * Returns the case number of this quotations najm details.
	 *
	 * @return the case number of this quotations najm details
	 */
	@AutoEscape
	public String getCaseNumber();

	/**
	 * Sets the case number of this quotations najm details.
	 *
	 * @param caseNumber the case number of this quotations najm details
	 */
	public void setCaseNumber(String caseNumber);

	/**
	 * Returns the quotation ID of this quotations najm details.
	 *
	 * @return the quotation ID of this quotations najm details
	 */
	public long getQuotationId();

	/**
	 * Sets the quotation ID of this quotations najm details.
	 *
	 * @param quotationId the quotation ID of this quotations najm details
	 */
	public void setQuotationId(long quotationId);

	/**
	 * Returns the accident date of this quotations najm details.
	 *
	 * @return the accident date of this quotations najm details
	 */
	@AutoEscape
	public String getAccidentDate();

	/**
	 * Sets the accident date of this quotations najm details.
	 *
	 * @param accidentDate the accident date of this quotations najm details
	 */
	public void setAccidentDate(String accidentDate);

	/**
	 * Returns the liability of this quotations najm details.
	 *
	 * @return the liability of this quotations najm details
	 */
	@AutoEscape
	public String getLiability();

	/**
	 * Sets the liability of this quotations najm details.
	 *
	 * @param liability the liability of this quotations najm details
	 */
	public void setLiability(String liability);

	/**
	 * Returns the driver age of this quotations najm details.
	 *
	 * @return the driver age of this quotations najm details
	 */
	@AutoEscape
	public String getDriverAge();

	/**
	 * Sets the driver age of this quotations najm details.
	 *
	 * @param driverAge the driver age of this quotations najm details
	 */
	public void setDriverAge(String driverAge);

	/**
	 * Returns the car model of this quotations najm details.
	 *
	 * @return the car model of this quotations najm details
	 */
	@AutoEscape
	public String getCarModel();

	/**
	 * Sets the car model of this quotations najm details.
	 *
	 * @param carModel the car model of this quotations najm details
	 */
	public void setCarModel(String carModel);

	/**
	 * Returns the car type of this quotations najm details.
	 *
	 * @return the car type of this quotations najm details
	 */
	@AutoEscape
	public String getCarType();

	/**
	 * Sets the car type of this quotations najm details.
	 *
	 * @param carType the car type of this quotations najm details
	 */
	public void setCarType(String carType);

	/**
	 * Returns the driver ID of this quotations najm details.
	 *
	 * @return the driver ID of this quotations najm details
	 */
	@AutoEscape
	public String getDriverID();

	/**
	 * Sets the driver ID of this quotations najm details.
	 *
	 * @param driverID the driver ID of this quotations najm details
	 */
	public void setDriverID(String driverID);

	/**
	 * Returns the sequence number of this quotations najm details.
	 *
	 * @return the sequence number of this quotations najm details
	 */
	@AutoEscape
	public String getSequenceNumber();

	/**
	 * Sets the sequence number of this quotations najm details.
	 *
	 * @param sequenceNumber the sequence number of this quotations najm details
	 */
	public void setSequenceNumber(String sequenceNumber);

	/**
	 * Returns the owner ID of this quotations najm details.
	 *
	 * @return the owner ID of this quotations najm details
	 */
	@AutoEscape
	public String getOwnerID();

	/**
	 * Sets the owner ID of this quotations najm details.
	 *
	 * @param ownerID the owner ID of this quotations najm details
	 */
	public void setOwnerID(String ownerID);

	/**
	 * Returns the estimated amount of this quotations najm details.
	 *
	 * @return the estimated amount of this quotations najm details
	 */
	@AutoEscape
	public String getEstimatedAmount();

	/**
	 * Sets the estimated amount of this quotations najm details.
	 *
	 * @param estimatedAmount the estimated amount of this quotations najm details
	 */
	public void setEstimatedAmount(String estimatedAmount);

	/**
	 * Returns the damage parts of this quotations najm details.
	 *
	 * @return the damage parts of this quotations najm details
	 */
	@AutoEscape
	public String getDamageParts();

	/**
	 * Sets the damage parts of this quotations najm details.
	 *
	 * @param damageParts the damage parts of this quotations najm details
	 */
	public void setDamageParts(String damageParts);

	/**
	 * Returns the cause of accident of this quotations najm details.
	 *
	 * @return the cause of accident of this quotations najm details
	 */
	@AutoEscape
	public String getCauseOfAccident();

	/**
	 * Sets the cause of accident of this quotations najm details.
	 *
	 * @param causeOfAccident the cause of accident of this quotations najm details
	 */
	public void setCauseOfAccident(String causeOfAccident);

}