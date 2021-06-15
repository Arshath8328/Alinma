/*
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
package com.atmc.bsl.db.domain.quotation;

/**
 * @author Kareem Kahil
 */
public class QuotationNajmDetails
{
	private long quotationId;
	
	private String CaseNumber;
	
	private String AccidentDate;
	
	private String Liability;
	
	private String DriverAge;
	
	private String CarModel;
	
	private String CarType;
	
	private String DriverID;
	
	private String SequenceNumber;
	
	private String OwnerID;
	
	private String EstimatedAmount;
	
	private String DamageParts;
	
	private String CauseOfAccident;

	public long getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(long quotationId) {
		this.quotationId = quotationId;
	}

	public String getCaseNumber() {
		return CaseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		CaseNumber = caseNumber;
	}

	public String getAccidentDate() {
		return AccidentDate;
	}

	public void setAccidentDate(String accidentDate) {
		AccidentDate = accidentDate;
	}

	public String getLiability() {
		return Liability;
	}

	public void setLiability(String liability) {
		Liability = liability;
	}

	public String getDriverAge() {
		return DriverAge;
	}

	public void setDriverAge(String driverAge) {
		DriverAge = driverAge;
	}

	public String getCarModel() {
		return CarModel;
	}

	public void setCarModel(String carModel) {
		CarModel = carModel;
	}

	public String getCarType() {
		return CarType;
	}

	public void setCarType(String carType) {
		CarType = carType;
	}

	public String getDriverID() {
		return DriverID;
	}

	public void setDriverID(String driverID) {
		DriverID = driverID;
	}

	public String getSequenceNumber() {
		return SequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		SequenceNumber = sequenceNumber;
	}

	public String getOwnerID() {
		return OwnerID;
	}

	public void setOwnerID(String ownerID) {
		OwnerID = ownerID;
	}

	public String getEstimatedAmount() {
		return EstimatedAmount;
	}

	public void setEstimatedAmount(String estimatedAmount) {
		EstimatedAmount = estimatedAmount;
	}

	public String getDamageParts() {
		return DamageParts;
	}

	public void setDamageParts(String damageParts) {
		DamageParts = damageParts;
	}

	public String getCauseOfAccident() {
		return CauseOfAccident;
	}

	public void setCauseOfAccident(String causeOfAccident) {
		CauseOfAccident = causeOfAccident;
	}
	
}
