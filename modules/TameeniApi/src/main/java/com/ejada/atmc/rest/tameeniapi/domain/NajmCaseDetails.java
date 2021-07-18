/*
 * CustomizedParameter.java Apr 18, 2018  
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
package com.ejada.atmc.rest.tameeniapi.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ghada Shawkat
 *
 */
@XmlRootElement
public class NajmCaseDetails
{
	private String caseNumber;

	private String accidentDate;

	private String liability;

	private String driverAge;

	private String carModel;
	
	private String carType;
	
	private String driverID;

	private String sequenceNumber;

	private String ownerID;

	private String estimatedAmount;
	
	private String damageParts;

	private String causeOfAccident;
	
	@XmlElement(name = "CaseNumber")
	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	
	@XmlElement(name = "AccidentDate")
	public String getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(String accidentDate) {
		this.accidentDate = accidentDate;
	}

	@XmlElement(name = "Liability")
	public String getLiability() {
		return liability;
	}

	public void setLiability(String liability) {
		this.liability = liability;
	}

	@XmlElement(name = "DriverAge")
	public String getDriverAge() {
		return driverAge;
	}

	public void setDriverAge(String driverAge) {
		this.driverAge = driverAge;
	}

	@XmlElement(name = "CarModel")
	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	@XmlElement(name = "CarType")
	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	@XmlElement(name = "DriverID")
	public String getDriverID() {
		return driverID;
	}

	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}

	@XmlElement(name = "SequenceNumber")
	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	@XmlElement(name = "OwnerID")
	public String getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}

	@XmlElement(name = "EstimatedAmount")
	public String getEstimatedAmount() {
		return estimatedAmount;
	}

	public void setEstimatedAmount(String estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}

	@XmlElement(name = "DamageParts")
	public String getDamageParts() {
		return damageParts;
	}

	public void setDamageParts(String damageParts) {
		this.damageParts = damageParts;
	}

	@XmlElement(name = "CauseOfAccident")
	public String getCauseOfAccident() {
		return causeOfAccident;
	}

	public void setCauseOfAccident(String causeOfAccident) {
		this.causeOfAccident = causeOfAccident;
	}

}
