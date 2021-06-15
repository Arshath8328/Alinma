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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link QuotationDrivers}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationDrivers
 * @generated
 */
public class QuotationDriversWrapper
	extends BaseModelWrapper<QuotationDrivers>
	implements ModelWrapper<QuotationDrivers>, QuotationDrivers {

	public QuotationDriversWrapper(QuotationDrivers quotationDrivers) {
		super(quotationDrivers);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addDriverId", getAddDriverId());
		attributes.put("quotationId", getQuotationId());
		attributes.put("driverDob", getDriverDob());
		attributes.put("driverDobH", getDriverDobH());
		attributes.put("driverGender", getDriverGender());
		attributes.put("driverId", getDriverId());
		attributes.put("driverIdType", getDriverIdType());
		attributes.put("driverName", getDriverName());
		attributes.put("driverNationality", getDriverNationality());
		attributes.put("driverOccup", getDriverOccup());
		attributes.put("isDriverUnder21", isIsDriverUnder21());
		attributes.put("driverEdu", getDriverEdu());
		attributes.put("driverNoChild", getDriverNoChild());
		attributes.put("driverMaritalStatus", getDriverMaritalStatus());
		attributes.put("driverNOFault", getDriverNOFault());
		attributes.put("driverNOClaim", getDriverNOClaim());
		attributes.put("driverConvictions", getDriverConvictions());
		attributes.put("driverMedConds", getDriverMedConds());
		attributes.put("ncdYears", getNcdYears());
		attributes.put("insuredRelation", getInsuredRelation());
		attributes.put("insuredRelationProof", getInsuredRelationProof());
		attributes.put(
			"insuredRelationProofFileName", getInsuredRelationProofFileName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addDriverId = (Long)attributes.get("addDriverId");

		if (addDriverId != null) {
			setAddDriverId(addDriverId);
		}

		Long quotationId = (Long)attributes.get("quotationId");

		if (quotationId != null) {
			setQuotationId(quotationId);
		}

		Date driverDob = (Date)attributes.get("driverDob");

		if (driverDob != null) {
			setDriverDob(driverDob);
		}

		String driverDobH = (String)attributes.get("driverDobH");

		if (driverDobH != null) {
			setDriverDobH(driverDobH);
		}

		String driverGender = (String)attributes.get("driverGender");

		if (driverGender != null) {
			setDriverGender(driverGender);
		}

		Long driverId = (Long)attributes.get("driverId");

		if (driverId != null) {
			setDriverId(driverId);
		}

		Long driverIdType = (Long)attributes.get("driverIdType");

		if (driverIdType != null) {
			setDriverIdType(driverIdType);
		}

		String driverName = (String)attributes.get("driverName");

		if (driverName != null) {
			setDriverName(driverName);
		}

		String driverNationality = (String)attributes.get("driverNationality");

		if (driverNationality != null) {
			setDriverNationality(driverNationality);
		}

		String driverOccup = (String)attributes.get("driverOccup");

		if (driverOccup != null) {
			setDriverOccup(driverOccup);
		}

		Boolean isDriverUnder21 = (Boolean)attributes.get("isDriverUnder21");

		if (isDriverUnder21 != null) {
			setIsDriverUnder21(isDriverUnder21);
		}

		String driverEdu = (String)attributes.get("driverEdu");

		if (driverEdu != null) {
			setDriverEdu(driverEdu);
		}

		String driverNoChild = (String)attributes.get("driverNoChild");

		if (driverNoChild != null) {
			setDriverNoChild(driverNoChild);
		}

		String driverMaritalStatus = (String)attributes.get(
			"driverMaritalStatus");

		if (driverMaritalStatus != null) {
			setDriverMaritalStatus(driverMaritalStatus);
		}

		Long driverNOFault = (Long)attributes.get("driverNOFault");

		if (driverNOFault != null) {
			setDriverNOFault(driverNOFault);
		}

		Long driverNOClaim = (Long)attributes.get("driverNOClaim");

		if (driverNOClaim != null) {
			setDriverNOClaim(driverNOClaim);
		}

		String driverConvictions = (String)attributes.get("driverConvictions");

		if (driverConvictions != null) {
			setDriverConvictions(driverConvictions);
		}

		String driverMedConds = (String)attributes.get("driverMedConds");

		if (driverMedConds != null) {
			setDriverMedConds(driverMedConds);
		}

		Integer ncdYears = (Integer)attributes.get("ncdYears");

		if (ncdYears != null) {
			setNcdYears(ncdYears);
		}

		String insuredRelation = (String)attributes.get("insuredRelation");

		if (insuredRelation != null) {
			setInsuredRelation(insuredRelation);
		}

		Blob insuredRelationProof = (Blob)attributes.get(
			"insuredRelationProof");

		if (insuredRelationProof != null) {
			setInsuredRelationProof(insuredRelationProof);
		}

		String insuredRelationProofFileName = (String)attributes.get(
			"insuredRelationProofFileName");

		if (insuredRelationProofFileName != null) {
			setInsuredRelationProofFileName(insuredRelationProofFileName);
		}
	}

	/**
	 * Returns the add driver ID of this quotation drivers.
	 *
	 * @return the add driver ID of this quotation drivers
	 */
	@Override
	public long getAddDriverId() {
		return model.getAddDriverId();
	}

	/**
	 * Returns the driver convictions of this quotation drivers.
	 *
	 * @return the driver convictions of this quotation drivers
	 */
	@Override
	public String getDriverConvictions() {
		return model.getDriverConvictions();
	}

	/**
	 * Returns the driver dob of this quotation drivers.
	 *
	 * @return the driver dob of this quotation drivers
	 */
	@Override
	public Date getDriverDob() {
		return model.getDriverDob();
	}

	/**
	 * Returns the driver dob h of this quotation drivers.
	 *
	 * @return the driver dob h of this quotation drivers
	 */
	@Override
	public String getDriverDobH() {
		return model.getDriverDobH();
	}

	/**
	 * Returns the driver edu of this quotation drivers.
	 *
	 * @return the driver edu of this quotation drivers
	 */
	@Override
	public String getDriverEdu() {
		return model.getDriverEdu();
	}

	/**
	 * Returns the driver gender of this quotation drivers.
	 *
	 * @return the driver gender of this quotation drivers
	 */
	@Override
	public String getDriverGender() {
		return model.getDriverGender();
	}

	/**
	 * Returns the driver ID of this quotation drivers.
	 *
	 * @return the driver ID of this quotation drivers
	 */
	@Override
	public long getDriverId() {
		return model.getDriverId();
	}

	/**
	 * Returns the driver ID type of this quotation drivers.
	 *
	 * @return the driver ID type of this quotation drivers
	 */
	@Override
	public long getDriverIdType() {
		return model.getDriverIdType();
	}

	/**
	 * Returns the driver marital status of this quotation drivers.
	 *
	 * @return the driver marital status of this quotation drivers
	 */
	@Override
	public String getDriverMaritalStatus() {
		return model.getDriverMaritalStatus();
	}

	/**
	 * Returns the driver med conds of this quotation drivers.
	 *
	 * @return the driver med conds of this quotation drivers
	 */
	@Override
	public String getDriverMedConds() {
		return model.getDriverMedConds();
	}

	/**
	 * Returns the driver name of this quotation drivers.
	 *
	 * @return the driver name of this quotation drivers
	 */
	@Override
	public String getDriverName() {
		return model.getDriverName();
	}

	/**
	 * Returns the driver nationality of this quotation drivers.
	 *
	 * @return the driver nationality of this quotation drivers
	 */
	@Override
	public String getDriverNationality() {
		return model.getDriverNationality();
	}

	/**
	 * Returns the driver no child of this quotation drivers.
	 *
	 * @return the driver no child of this quotation drivers
	 */
	@Override
	public String getDriverNoChild() {
		return model.getDriverNoChild();
	}

	/**
	 * Returns the driver no claim of this quotation drivers.
	 *
	 * @return the driver no claim of this quotation drivers
	 */
	@Override
	public long getDriverNOClaim() {
		return model.getDriverNOClaim();
	}

	/**
	 * Returns the driver no fault of this quotation drivers.
	 *
	 * @return the driver no fault of this quotation drivers
	 */
	@Override
	public long getDriverNOFault() {
		return model.getDriverNOFault();
	}

	/**
	 * Returns the driver occup of this quotation drivers.
	 *
	 * @return the driver occup of this quotation drivers
	 */
	@Override
	public String getDriverOccup() {
		return model.getDriverOccup();
	}

	/**
	 * Returns the insured relation of this quotation drivers.
	 *
	 * @return the insured relation of this quotation drivers
	 */
	@Override
	public String getInsuredRelation() {
		return model.getInsuredRelation();
	}

	/**
	 * Returns the insured relation proof of this quotation drivers.
	 *
	 * @return the insured relation proof of this quotation drivers
	 */
	@Override
	public Blob getInsuredRelationProof() {
		return model.getInsuredRelationProof();
	}

	/**
	 * Returns the insured relation proof file name of this quotation drivers.
	 *
	 * @return the insured relation proof file name of this quotation drivers
	 */
	@Override
	public String getInsuredRelationProofFileName() {
		return model.getInsuredRelationProofFileName();
	}

	/**
	 * Returns the is driver under21 of this quotation drivers.
	 *
	 * @return the is driver under21 of this quotation drivers
	 */
	@Override
	public boolean getIsDriverUnder21() {
		return model.getIsDriverUnder21();
	}

	/**
	 * Returns the ncd years of this quotation drivers.
	 *
	 * @return the ncd years of this quotation drivers
	 */
	@Override
	public int getNcdYears() {
		return model.getNcdYears();
	}

	/**
	 * Returns the primary key of this quotation drivers.
	 *
	 * @return the primary key of this quotation drivers
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quotation ID of this quotation drivers.
	 *
	 * @return the quotation ID of this quotation drivers
	 */
	@Override
	public long getQuotationId() {
		return model.getQuotationId();
	}

	/**
	 * Returns <code>true</code> if this quotation drivers is is driver under21.
	 *
	 * @return <code>true</code> if this quotation drivers is is driver under21; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsDriverUnder21() {
		return model.isIsDriverUnder21();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the add driver ID of this quotation drivers.
	 *
	 * @param addDriverId the add driver ID of this quotation drivers
	 */
	@Override
	public void setAddDriverId(long addDriverId) {
		model.setAddDriverId(addDriverId);
	}

	/**
	 * Sets the driver convictions of this quotation drivers.
	 *
	 * @param driverConvictions the driver convictions of this quotation drivers
	 */
	@Override
	public void setDriverConvictions(String driverConvictions) {
		model.setDriverConvictions(driverConvictions);
	}

	/**
	 * Sets the driver dob of this quotation drivers.
	 *
	 * @param driverDob the driver dob of this quotation drivers
	 */
	@Override
	public void setDriverDob(Date driverDob) {
		model.setDriverDob(driverDob);
	}

	/**
	 * Sets the driver dob h of this quotation drivers.
	 *
	 * @param driverDobH the driver dob h of this quotation drivers
	 */
	@Override
	public void setDriverDobH(String driverDobH) {
		model.setDriverDobH(driverDobH);
	}

	/**
	 * Sets the driver edu of this quotation drivers.
	 *
	 * @param driverEdu the driver edu of this quotation drivers
	 */
	@Override
	public void setDriverEdu(String driverEdu) {
		model.setDriverEdu(driverEdu);
	}

	/**
	 * Sets the driver gender of this quotation drivers.
	 *
	 * @param driverGender the driver gender of this quotation drivers
	 */
	@Override
	public void setDriverGender(String driverGender) {
		model.setDriverGender(driverGender);
	}

	/**
	 * Sets the driver ID of this quotation drivers.
	 *
	 * @param driverId the driver ID of this quotation drivers
	 */
	@Override
	public void setDriverId(long driverId) {
		model.setDriverId(driverId);
	}

	/**
	 * Sets the driver ID type of this quotation drivers.
	 *
	 * @param driverIdType the driver ID type of this quotation drivers
	 */
	@Override
	public void setDriverIdType(long driverIdType) {
		model.setDriverIdType(driverIdType);
	}

	/**
	 * Sets the driver marital status of this quotation drivers.
	 *
	 * @param driverMaritalStatus the driver marital status of this quotation drivers
	 */
	@Override
	public void setDriverMaritalStatus(String driverMaritalStatus) {
		model.setDriverMaritalStatus(driverMaritalStatus);
	}

	/**
	 * Sets the driver med conds of this quotation drivers.
	 *
	 * @param driverMedConds the driver med conds of this quotation drivers
	 */
	@Override
	public void setDriverMedConds(String driverMedConds) {
		model.setDriverMedConds(driverMedConds);
	}

	/**
	 * Sets the driver name of this quotation drivers.
	 *
	 * @param driverName the driver name of this quotation drivers
	 */
	@Override
	public void setDriverName(String driverName) {
		model.setDriverName(driverName);
	}

	/**
	 * Sets the driver nationality of this quotation drivers.
	 *
	 * @param driverNationality the driver nationality of this quotation drivers
	 */
	@Override
	public void setDriverNationality(String driverNationality) {
		model.setDriverNationality(driverNationality);
	}

	/**
	 * Sets the driver no child of this quotation drivers.
	 *
	 * @param driverNoChild the driver no child of this quotation drivers
	 */
	@Override
	public void setDriverNoChild(String driverNoChild) {
		model.setDriverNoChild(driverNoChild);
	}

	/**
	 * Sets the driver no claim of this quotation drivers.
	 *
	 * @param driverNOClaim the driver no claim of this quotation drivers
	 */
	@Override
	public void setDriverNOClaim(long driverNOClaim) {
		model.setDriverNOClaim(driverNOClaim);
	}

	/**
	 * Sets the driver no fault of this quotation drivers.
	 *
	 * @param driverNOFault the driver no fault of this quotation drivers
	 */
	@Override
	public void setDriverNOFault(long driverNOFault) {
		model.setDriverNOFault(driverNOFault);
	}

	/**
	 * Sets the driver occup of this quotation drivers.
	 *
	 * @param driverOccup the driver occup of this quotation drivers
	 */
	@Override
	public void setDriverOccup(String driverOccup) {
		model.setDriverOccup(driverOccup);
	}

	/**
	 * Sets the insured relation of this quotation drivers.
	 *
	 * @param insuredRelation the insured relation of this quotation drivers
	 */
	@Override
	public void setInsuredRelation(String insuredRelation) {
		model.setInsuredRelation(insuredRelation);
	}

	/**
	 * Sets the insured relation proof of this quotation drivers.
	 *
	 * @param insuredRelationProof the insured relation proof of this quotation drivers
	 */
	@Override
	public void setInsuredRelationProof(Blob insuredRelationProof) {
		model.setInsuredRelationProof(insuredRelationProof);
	}

	/**
	 * Sets the insured relation proof file name of this quotation drivers.
	 *
	 * @param insuredRelationProofFileName the insured relation proof file name of this quotation drivers
	 */
	@Override
	public void setInsuredRelationProofFileName(
		String insuredRelationProofFileName) {

		model.setInsuredRelationProofFileName(insuredRelationProofFileName);
	}

	/**
	 * Sets whether this quotation drivers is is driver under21.
	 *
	 * @param isDriverUnder21 the is driver under21 of this quotation drivers
	 */
	@Override
	public void setIsDriverUnder21(boolean isDriverUnder21) {
		model.setIsDriverUnder21(isDriverUnder21);
	}

	/**
	 * Sets the ncd years of this quotation drivers.
	 *
	 * @param ncdYears the ncd years of this quotation drivers
	 */
	@Override
	public void setNcdYears(int ncdYears) {
		model.setNcdYears(ncdYears);
	}

	/**
	 * Sets the primary key of this quotation drivers.
	 *
	 * @param primaryKey the primary key of this quotation drivers
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quotation ID of this quotation drivers.
	 *
	 * @param quotationId the quotation ID of this quotation drivers
	 */
	@Override
	public void setQuotationId(long quotationId) {
		model.setQuotationId(quotationId);
	}

	@Override
	protected QuotationDriversWrapper wrap(QuotationDrivers quotationDrivers) {
		return new QuotationDriversWrapper(quotationDrivers);
	}

}