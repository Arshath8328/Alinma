/*
 * PolicyVehicleDriver.java Jan 17, 2018  
 *
 * Copyright (c) 2005-2012 Ejada Solutions.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Ejada
 * Solutions, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Ejada.
 */
package com.ejada.atmc.bsl.db.domain.policy;

import java.util.Date;

/**
 * @author Ghada Shawkat
 */
public class PolicyVehicleDriver {
	private String policyNo;

	private long vehId;

	private String driverName;

	private String driverLicenseNo;

	private Date driverBirthDate;

	private String driverNationality;

	private String driverNationalityEn;

	private String driverNationalityAr;

	private String driverGender;

	private String driverGenderEn;

	private String driverGenderAr;

	/**
	 * @return the policyNo
	 */
	public String getPolicyNo() {
		return policyNo;
	}

	/**
	 * @param policyNo the policyNo to set
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	/**
	 * @return the vehId
	 */
	public long getVehId() {
		return vehId;
	}

	/**
	 * @param vehId the vehId to set
	 */
	public void setVehId(long vehId) {
		this.vehId = vehId;
	}

	/**
	 * @return the driverName
	 */
	public String getDriverName() {
		return driverName;
	}

	/**
	 * @param driverName the driverName to set
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	/**
	 * @return the driverLicenseNo
	 */
	public String getDriverLicenseNo() {
		return driverLicenseNo;
	}

	/**
	 * @param driverLicenseNo the driverLicenseNo to set
	 */
	public void setDriverLicenseNo(String driverLicenseNo) {
		this.driverLicenseNo = driverLicenseNo;
	}

	/**
	 * @return the driverBirthDate
	 */
	public Date getDriverBirthDate() {
		return driverBirthDate;
	}

	/**
	 * @param driverBirthDate the driverBirthDate to set
	 */
	public void setDriverBirthDate(Date driverBirthDate) {
		this.driverBirthDate = driverBirthDate;
	}

	/**
	 * @return the driverNationality
	 */
	public String getDriverNationality() {
		return driverNationality;
	}

	/**
	 * @param driverNationality the driverNationality to set
	 */
	public void setDriverNationality(String driverNationality) {
		this.driverNationality = driverNationality;
	}

	/**
	 * @return the driverGender
	 */
	public String getDriverGender() {
		return driverGender;
	}

	/**
	 * @param driverGender the driverGender to set
	 */
	public void setDriverGender(String driverGender) {
		this.driverGender = driverGender;
	}

	/**
	 * @return the driverNationalityEn
	 */
	public String getDriverNationalityEn() {
		return driverNationalityEn;
	}

	/**
	 * @param driverNationalityEn the driverNationalityEn to set
	 */
	public void setDriverNationalityEn(String driverNationalityEn) {
		this.driverNationalityEn = driverNationalityEn;
	}

	/**
	 * @return the driverNationalityAr
	 */
	public String getDriverNationalityAr() {
		return driverNationalityAr;
	}

	/**
	 * @param driverNationalityAr the driverNationalityAr to set
	 */
	public void setDriverNationalityAr(String driverNationalityAr) {
		this.driverNationalityAr = driverNationalityAr;
	}

	/**
	 * @return the driverGenderEn
	 */
	public String getDriverGenderEn() {
		return driverGenderEn;
	}

	/**
	 * @param driverGenderEn the driverGenderEn to set
	 */
	public void setDriverGenderEn(String driverGenderEn) {
		this.driverGenderEn = driverGenderEn;
	}

	/**
	 * @return the driverGenderAr
	 */
	public String getDriverGenderAr() {
		return driverGenderAr;
	}

	/**
	 * @param driverGenderAr the driverGenderAr to set
	 */
	public void setDriverGenderAr(String driverGenderAr) {
		this.driverGenderAr = driverGenderAr;
	}

}
