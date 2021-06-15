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
 * This class is a wrapper for {@link QuotationDriverseEndors}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationDriverseEndors
 * @generated
 */
public class QuotationDriverseEndorsWrapper
	extends BaseModelWrapper<QuotationDriverseEndors>
	implements ModelWrapper<QuotationDriverseEndors>, QuotationDriverseEndors {

	public QuotationDriverseEndorsWrapper(
		QuotationDriverseEndors quotationDriverseEndors) {

		super(quotationDriverseEndors);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addDriverId", getAddDriverId());
		attributes.put("quotationId", getQuotationId());
		attributes.put("policyNumber", getPolicyNumber());
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
		attributes.put("status", getStatus());
		attributes.put("requestedDate", getRequestedDate());
		attributes.put("buildNo", getBuildNo());
		attributes.put("zipCode", getZipCode());
		attributes.put("addNo", getAddNo());
		attributes.put("stNameEn", getStNameEn());
		attributes.put("stNameAr", getStNameAr());
		attributes.put("districtEn", getDistrictEn());
		attributes.put("districtAr", getDistrictAr());
		attributes.put("cityEn", getCityEn());
		attributes.put("cityAr", getCityAr());
		attributes.put("isNatAddress", isIsNatAddress());

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

		String policyNumber = (String)attributes.get("policyNumber");

		if (policyNumber != null) {
			setPolicyNumber(policyNumber);
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

		String driverId = (String)attributes.get("driverId");

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

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date requestedDate = (Date)attributes.get("requestedDate");

		if (requestedDate != null) {
			setRequestedDate(requestedDate);
		}

		String buildNo = (String)attributes.get("buildNo");

		if (buildNo != null) {
			setBuildNo(buildNo);
		}

		String zipCode = (String)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}

		String addNo = (String)attributes.get("addNo");

		if (addNo != null) {
			setAddNo(addNo);
		}

		String stNameEn = (String)attributes.get("stNameEn");

		if (stNameEn != null) {
			setStNameEn(stNameEn);
		}

		String stNameAr = (String)attributes.get("stNameAr");

		if (stNameAr != null) {
			setStNameAr(stNameAr);
		}

		String districtEn = (String)attributes.get("districtEn");

		if (districtEn != null) {
			setDistrictEn(districtEn);
		}

		String districtAr = (String)attributes.get("districtAr");

		if (districtAr != null) {
			setDistrictAr(districtAr);
		}

		String cityEn = (String)attributes.get("cityEn");

		if (cityEn != null) {
			setCityEn(cityEn);
		}

		String cityAr = (String)attributes.get("cityAr");

		if (cityAr != null) {
			setCityAr(cityAr);
		}

		Boolean isNatAddress = (Boolean)attributes.get("isNatAddress");

		if (isNatAddress != null) {
			setIsNatAddress(isNatAddress);
		}
	}

	/**
	 * Returns the add driver ID of this quotation driverse endors.
	 *
	 * @return the add driver ID of this quotation driverse endors
	 */
	@Override
	public long getAddDriverId() {
		return model.getAddDriverId();
	}

	/**
	 * Returns the add no of this quotation driverse endors.
	 *
	 * @return the add no of this quotation driverse endors
	 */
	@Override
	public String getAddNo() {
		return model.getAddNo();
	}

	/**
	 * Returns the build no of this quotation driverse endors.
	 *
	 * @return the build no of this quotation driverse endors
	 */
	@Override
	public String getBuildNo() {
		return model.getBuildNo();
	}

	/**
	 * Returns the city ar of this quotation driverse endors.
	 *
	 * @return the city ar of this quotation driverse endors
	 */
	@Override
	public String getCityAr() {
		return model.getCityAr();
	}

	/**
	 * Returns the city en of this quotation driverse endors.
	 *
	 * @return the city en of this quotation driverse endors
	 */
	@Override
	public String getCityEn() {
		return model.getCityEn();
	}

	/**
	 * Returns the district ar of this quotation driverse endors.
	 *
	 * @return the district ar of this quotation driverse endors
	 */
	@Override
	public String getDistrictAr() {
		return model.getDistrictAr();
	}

	/**
	 * Returns the district en of this quotation driverse endors.
	 *
	 * @return the district en of this quotation driverse endors
	 */
	@Override
	public String getDistrictEn() {
		return model.getDistrictEn();
	}

	/**
	 * Returns the driver convictions of this quotation driverse endors.
	 *
	 * @return the driver convictions of this quotation driverse endors
	 */
	@Override
	public String getDriverConvictions() {
		return model.getDriverConvictions();
	}

	/**
	 * Returns the driver dob of this quotation driverse endors.
	 *
	 * @return the driver dob of this quotation driverse endors
	 */
	@Override
	public Date getDriverDob() {
		return model.getDriverDob();
	}

	/**
	 * Returns the driver dob h of this quotation driverse endors.
	 *
	 * @return the driver dob h of this quotation driverse endors
	 */
	@Override
	public String getDriverDobH() {
		return model.getDriverDobH();
	}

	/**
	 * Returns the driver edu of this quotation driverse endors.
	 *
	 * @return the driver edu of this quotation driverse endors
	 */
	@Override
	public String getDriverEdu() {
		return model.getDriverEdu();
	}

	/**
	 * Returns the driver gender of this quotation driverse endors.
	 *
	 * @return the driver gender of this quotation driverse endors
	 */
	@Override
	public String getDriverGender() {
		return model.getDriverGender();
	}

	/**
	 * Returns the driver ID of this quotation driverse endors.
	 *
	 * @return the driver ID of this quotation driverse endors
	 */
	@Override
	public String getDriverId() {
		return model.getDriverId();
	}

	/**
	 * Returns the driver ID type of this quotation driverse endors.
	 *
	 * @return the driver ID type of this quotation driverse endors
	 */
	@Override
	public long getDriverIdType() {
		return model.getDriverIdType();
	}

	/**
	 * Returns the driver marital status of this quotation driverse endors.
	 *
	 * @return the driver marital status of this quotation driverse endors
	 */
	@Override
	public String getDriverMaritalStatus() {
		return model.getDriverMaritalStatus();
	}

	/**
	 * Returns the driver med conds of this quotation driverse endors.
	 *
	 * @return the driver med conds of this quotation driverse endors
	 */
	@Override
	public String getDriverMedConds() {
		return model.getDriverMedConds();
	}

	/**
	 * Returns the driver name of this quotation driverse endors.
	 *
	 * @return the driver name of this quotation driverse endors
	 */
	@Override
	public String getDriverName() {
		return model.getDriverName();
	}

	/**
	 * Returns the driver nationality of this quotation driverse endors.
	 *
	 * @return the driver nationality of this quotation driverse endors
	 */
	@Override
	public String getDriverNationality() {
		return model.getDriverNationality();
	}

	/**
	 * Returns the driver no child of this quotation driverse endors.
	 *
	 * @return the driver no child of this quotation driverse endors
	 */
	@Override
	public String getDriverNoChild() {
		return model.getDriverNoChild();
	}

	/**
	 * Returns the driver no claim of this quotation driverse endors.
	 *
	 * @return the driver no claim of this quotation driverse endors
	 */
	@Override
	public long getDriverNOClaim() {
		return model.getDriverNOClaim();
	}

	/**
	 * Returns the driver no fault of this quotation driverse endors.
	 *
	 * @return the driver no fault of this quotation driverse endors
	 */
	@Override
	public long getDriverNOFault() {
		return model.getDriverNOFault();
	}

	/**
	 * Returns the driver occup of this quotation driverse endors.
	 *
	 * @return the driver occup of this quotation driverse endors
	 */
	@Override
	public String getDriverOccup() {
		return model.getDriverOccup();
	}

	/**
	 * Returns the insured relation of this quotation driverse endors.
	 *
	 * @return the insured relation of this quotation driverse endors
	 */
	@Override
	public String getInsuredRelation() {
		return model.getInsuredRelation();
	}

	/**
	 * Returns the insured relation proof of this quotation driverse endors.
	 *
	 * @return the insured relation proof of this quotation driverse endors
	 */
	@Override
	public Blob getInsuredRelationProof() {
		return model.getInsuredRelationProof();
	}

	/**
	 * Returns the insured relation proof file name of this quotation driverse endors.
	 *
	 * @return the insured relation proof file name of this quotation driverse endors
	 */
	@Override
	public String getInsuredRelationProofFileName() {
		return model.getInsuredRelationProofFileName();
	}

	/**
	 * Returns the is driver under21 of this quotation driverse endors.
	 *
	 * @return the is driver under21 of this quotation driverse endors
	 */
	@Override
	public boolean getIsDriverUnder21() {
		return model.getIsDriverUnder21();
	}

	/**
	 * Returns the is nat address of this quotation driverse endors.
	 *
	 * @return the is nat address of this quotation driverse endors
	 */
	@Override
	public boolean getIsNatAddress() {
		return model.getIsNatAddress();
	}

	/**
	 * Returns the ncd years of this quotation driverse endors.
	 *
	 * @return the ncd years of this quotation driverse endors
	 */
	@Override
	public int getNcdYears() {
		return model.getNcdYears();
	}

	/**
	 * Returns the policy number of this quotation driverse endors.
	 *
	 * @return the policy number of this quotation driverse endors
	 */
	@Override
	public String getPolicyNumber() {
		return model.getPolicyNumber();
	}

	/**
	 * Returns the primary key of this quotation driverse endors.
	 *
	 * @return the primary key of this quotation driverse endors
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quotation ID of this quotation driverse endors.
	 *
	 * @return the quotation ID of this quotation driverse endors
	 */
	@Override
	public long getQuotationId() {
		return model.getQuotationId();
	}

	/**
	 * Returns the requested date of this quotation driverse endors.
	 *
	 * @return the requested date of this quotation driverse endors
	 */
	@Override
	public Date getRequestedDate() {
		return model.getRequestedDate();
	}

	/**
	 * Returns the status of this quotation driverse endors.
	 *
	 * @return the status of this quotation driverse endors
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the st name ar of this quotation driverse endors.
	 *
	 * @return the st name ar of this quotation driverse endors
	 */
	@Override
	public String getStNameAr() {
		return model.getStNameAr();
	}

	/**
	 * Returns the st name en of this quotation driverse endors.
	 *
	 * @return the st name en of this quotation driverse endors
	 */
	@Override
	public String getStNameEn() {
		return model.getStNameEn();
	}

	/**
	 * Returns the zip code of this quotation driverse endors.
	 *
	 * @return the zip code of this quotation driverse endors
	 */
	@Override
	public String getZipCode() {
		return model.getZipCode();
	}

	/**
	 * Returns <code>true</code> if this quotation driverse endors is is driver under21.
	 *
	 * @return <code>true</code> if this quotation driverse endors is is driver under21; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsDriverUnder21() {
		return model.isIsDriverUnder21();
	}

	/**
	 * Returns <code>true</code> if this quotation driverse endors is is nat address.
	 *
	 * @return <code>true</code> if this quotation driverse endors is is nat address; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsNatAddress() {
		return model.isIsNatAddress();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the add driver ID of this quotation driverse endors.
	 *
	 * @param addDriverId the add driver ID of this quotation driverse endors
	 */
	@Override
	public void setAddDriverId(long addDriverId) {
		model.setAddDriverId(addDriverId);
	}

	/**
	 * Sets the add no of this quotation driverse endors.
	 *
	 * @param addNo the add no of this quotation driverse endors
	 */
	@Override
	public void setAddNo(String addNo) {
		model.setAddNo(addNo);
	}

	/**
	 * Sets the build no of this quotation driverse endors.
	 *
	 * @param buildNo the build no of this quotation driverse endors
	 */
	@Override
	public void setBuildNo(String buildNo) {
		model.setBuildNo(buildNo);
	}

	/**
	 * Sets the city ar of this quotation driverse endors.
	 *
	 * @param cityAr the city ar of this quotation driverse endors
	 */
	@Override
	public void setCityAr(String cityAr) {
		model.setCityAr(cityAr);
	}

	/**
	 * Sets the city en of this quotation driverse endors.
	 *
	 * @param cityEn the city en of this quotation driverse endors
	 */
	@Override
	public void setCityEn(String cityEn) {
		model.setCityEn(cityEn);
	}

	/**
	 * Sets the district ar of this quotation driverse endors.
	 *
	 * @param districtAr the district ar of this quotation driverse endors
	 */
	@Override
	public void setDistrictAr(String districtAr) {
		model.setDistrictAr(districtAr);
	}

	/**
	 * Sets the district en of this quotation driverse endors.
	 *
	 * @param districtEn the district en of this quotation driverse endors
	 */
	@Override
	public void setDistrictEn(String districtEn) {
		model.setDistrictEn(districtEn);
	}

	/**
	 * Sets the driver convictions of this quotation driverse endors.
	 *
	 * @param driverConvictions the driver convictions of this quotation driverse endors
	 */
	@Override
	public void setDriverConvictions(String driverConvictions) {
		model.setDriverConvictions(driverConvictions);
	}

	/**
	 * Sets the driver dob of this quotation driverse endors.
	 *
	 * @param driverDob the driver dob of this quotation driverse endors
	 */
	@Override
	public void setDriverDob(Date driverDob) {
		model.setDriverDob(driverDob);
	}

	/**
	 * Sets the driver dob h of this quotation driverse endors.
	 *
	 * @param driverDobH the driver dob h of this quotation driverse endors
	 */
	@Override
	public void setDriverDobH(String driverDobH) {
		model.setDriverDobH(driverDobH);
	}

	/**
	 * Sets the driver edu of this quotation driverse endors.
	 *
	 * @param driverEdu the driver edu of this quotation driverse endors
	 */
	@Override
	public void setDriverEdu(String driverEdu) {
		model.setDriverEdu(driverEdu);
	}

	/**
	 * Sets the driver gender of this quotation driverse endors.
	 *
	 * @param driverGender the driver gender of this quotation driverse endors
	 */
	@Override
	public void setDriverGender(String driverGender) {
		model.setDriverGender(driverGender);
	}

	/**
	 * Sets the driver ID of this quotation driverse endors.
	 *
	 * @param driverId the driver ID of this quotation driverse endors
	 */
	@Override
	public void setDriverId(String driverId) {
		model.setDriverId(driverId);
	}

	/**
	 * Sets the driver ID type of this quotation driverse endors.
	 *
	 * @param driverIdType the driver ID type of this quotation driverse endors
	 */
	@Override
	public void setDriverIdType(long driverIdType) {
		model.setDriverIdType(driverIdType);
	}

	/**
	 * Sets the driver marital status of this quotation driverse endors.
	 *
	 * @param driverMaritalStatus the driver marital status of this quotation driverse endors
	 */
	@Override
	public void setDriverMaritalStatus(String driverMaritalStatus) {
		model.setDriverMaritalStatus(driverMaritalStatus);
	}

	/**
	 * Sets the driver med conds of this quotation driverse endors.
	 *
	 * @param driverMedConds the driver med conds of this quotation driverse endors
	 */
	@Override
	public void setDriverMedConds(String driverMedConds) {
		model.setDriverMedConds(driverMedConds);
	}

	/**
	 * Sets the driver name of this quotation driverse endors.
	 *
	 * @param driverName the driver name of this quotation driverse endors
	 */
	@Override
	public void setDriverName(String driverName) {
		model.setDriverName(driverName);
	}

	/**
	 * Sets the driver nationality of this quotation driverse endors.
	 *
	 * @param driverNationality the driver nationality of this quotation driverse endors
	 */
	@Override
	public void setDriverNationality(String driverNationality) {
		model.setDriverNationality(driverNationality);
	}

	/**
	 * Sets the driver no child of this quotation driverse endors.
	 *
	 * @param driverNoChild the driver no child of this quotation driverse endors
	 */
	@Override
	public void setDriverNoChild(String driverNoChild) {
		model.setDriverNoChild(driverNoChild);
	}

	/**
	 * Sets the driver no claim of this quotation driverse endors.
	 *
	 * @param driverNOClaim the driver no claim of this quotation driverse endors
	 */
	@Override
	public void setDriverNOClaim(long driverNOClaim) {
		model.setDriverNOClaim(driverNOClaim);
	}

	/**
	 * Sets the driver no fault of this quotation driverse endors.
	 *
	 * @param driverNOFault the driver no fault of this quotation driverse endors
	 */
	@Override
	public void setDriverNOFault(long driverNOFault) {
		model.setDriverNOFault(driverNOFault);
	}

	/**
	 * Sets the driver occup of this quotation driverse endors.
	 *
	 * @param driverOccup the driver occup of this quotation driverse endors
	 */
	@Override
	public void setDriverOccup(String driverOccup) {
		model.setDriverOccup(driverOccup);
	}

	/**
	 * Sets the insured relation of this quotation driverse endors.
	 *
	 * @param insuredRelation the insured relation of this quotation driverse endors
	 */
	@Override
	public void setInsuredRelation(String insuredRelation) {
		model.setInsuredRelation(insuredRelation);
	}

	/**
	 * Sets the insured relation proof of this quotation driverse endors.
	 *
	 * @param insuredRelationProof the insured relation proof of this quotation driverse endors
	 */
	@Override
	public void setInsuredRelationProof(Blob insuredRelationProof) {
		model.setInsuredRelationProof(insuredRelationProof);
	}

	/**
	 * Sets the insured relation proof file name of this quotation driverse endors.
	 *
	 * @param insuredRelationProofFileName the insured relation proof file name of this quotation driverse endors
	 */
	@Override
	public void setInsuredRelationProofFileName(
		String insuredRelationProofFileName) {

		model.setInsuredRelationProofFileName(insuredRelationProofFileName);
	}

	/**
	 * Sets whether this quotation driverse endors is is driver under21.
	 *
	 * @param isDriverUnder21 the is driver under21 of this quotation driverse endors
	 */
	@Override
	public void setIsDriverUnder21(boolean isDriverUnder21) {
		model.setIsDriverUnder21(isDriverUnder21);
	}

	/**
	 * Sets whether this quotation driverse endors is is nat address.
	 *
	 * @param isNatAddress the is nat address of this quotation driverse endors
	 */
	@Override
	public void setIsNatAddress(boolean isNatAddress) {
		model.setIsNatAddress(isNatAddress);
	}

	/**
	 * Sets the ncd years of this quotation driverse endors.
	 *
	 * @param ncdYears the ncd years of this quotation driverse endors
	 */
	@Override
	public void setNcdYears(int ncdYears) {
		model.setNcdYears(ncdYears);
	}

	/**
	 * Sets the policy number of this quotation driverse endors.
	 *
	 * @param policyNumber the policy number of this quotation driverse endors
	 */
	@Override
	public void setPolicyNumber(String policyNumber) {
		model.setPolicyNumber(policyNumber);
	}

	/**
	 * Sets the primary key of this quotation driverse endors.
	 *
	 * @param primaryKey the primary key of this quotation driverse endors
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quotation ID of this quotation driverse endors.
	 *
	 * @param quotationId the quotation ID of this quotation driverse endors
	 */
	@Override
	public void setQuotationId(long quotationId) {
		model.setQuotationId(quotationId);
	}

	/**
	 * Sets the requested date of this quotation driverse endors.
	 *
	 * @param requestedDate the requested date of this quotation driverse endors
	 */
	@Override
	public void setRequestedDate(Date requestedDate) {
		model.setRequestedDate(requestedDate);
	}

	/**
	 * Sets the status of this quotation driverse endors.
	 *
	 * @param status the status of this quotation driverse endors
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the st name ar of this quotation driverse endors.
	 *
	 * @param stNameAr the st name ar of this quotation driverse endors
	 */
	@Override
	public void setStNameAr(String stNameAr) {
		model.setStNameAr(stNameAr);
	}

	/**
	 * Sets the st name en of this quotation driverse endors.
	 *
	 * @param stNameEn the st name en of this quotation driverse endors
	 */
	@Override
	public void setStNameEn(String stNameEn) {
		model.setStNameEn(stNameEn);
	}

	/**
	 * Sets the zip code of this quotation driverse endors.
	 *
	 * @param zipCode the zip code of this quotation driverse endors
	 */
	@Override
	public void setZipCode(String zipCode) {
		model.setZipCode(zipCode);
	}

	@Override
	protected QuotationDriverseEndorsWrapper wrap(
		QuotationDriverseEndors quotationDriverseEndors) {

		return new QuotationDriverseEndorsWrapper(quotationDriverseEndors);
	}

}