/*
 * QuotationDriver.java Jan 21, 2018  
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

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author Ghada Shawkat
 */
public class QuotationDriver
{
	private long addDriverId;

	private long quotationId;

	private Date driverDob;
	
	private String driverDobH;
	
	private String driverEdu;
	
	private String driverNoChild;
	
	private String driverMaritalStatus;

	private String driverGender;

	private long driverId;

	private long driverIdType;

	private String driverName;

	private String driverNationality;
	
	private boolean isDriverUnder21;
	
	private List<QuotationDriverLicense> driverLicences;
	
	private int driverNOFault;
	
	private int driverNOClaim;
	
	private String driverConvictions;

	private String driverMedConds;
	
	private QuotationUserAddress driverNatAddress;
	
	private QuotationUserAddress driverOffNatAddress;
	
	private int ncdYears;
	
	private String insuredRelative;
	
	private String relationProofFileName;
	private String driverNationalityDescEN;
	private String driverNationalityDescAR;
	/**
	 * @return the addDriverId
	 */
	public long getAddDriverId()
	{
		return addDriverId;
	}

	/**
	 * @param addDriverId
	 *            the addDriverId to set
	 */
	public void setAddDriverId(long addDriverId)
	{
		this.addDriverId = addDriverId;
	}

	/**
	 * @return the quotationId
	 */
	public long getQuotationId()
	{
		return quotationId;
	}

	/**
	 * @param quotationId
	 *            the quotationId to set
	 */
	public void setQuotationId(long quotationId)
	{
		this.quotationId = quotationId;
	}

	/**
	 * @return the driverDob
	 */
	public Date getDriverDob()
	{
		return driverDob;
	}

	/**
	 * @param driverDob
	 *            the driverDob to set
	 */
	public void setDriverDob(Date driverDob)
	{
		this.driverDob = driverDob;
	}

	/**
	 * @return the driverGender
	 */
	public String getDriverGender()
	{
		return driverGender;
	}

	/**
	 * @param driverGender
	 *            the driverGender to set
	 */
	public void setDriverGender(String driverGender)
	{
		this.driverGender = driverGender;
	}

	/**
	 * @return the driverId
	 */
	public long getDriverId()
	{
		return driverId;
	}

	/**
	 * @param driverId
	 *            the driverId to set
	 */
	public void setDriverId(long driverId)
	{
		this.driverId = driverId;
	}

	/**
	 * @return the driverIdType
	 */
	public long getDriverIdType()
	{
		return driverIdType;
	}

	/**
	 * @param driverIdType
	 *            the driverIdType to set
	 */
	public void setDriverIdType(long driverIdType)
	{
		this.driverIdType = driverIdType;
	}

	/**
	 * @return the driverName
	 */
	public String getDriverName()
	{
		return driverName;
	}

	/**
	 * @param driverName
	 *            the driverName to set
	 */
	public void setDriverName(String driverName)
	{
		this.driverName = driverName;
	}

	/**
	 * @return the driverNationality
	 */
	public String getDriverNationality()
	{
		return driverNationality;
	}

	/**
	 * @param driverNationality
	 *            the driverNationality to set
	 */
	public void setDriverNationality(String driverNationality)
	{
		this.driverNationality = driverNationality;
	}

	/**
	 * @return the driverDobH
	 */
	public String getDriverDobH()
	{
		return driverDobH;
	}

	/**
	 * @param driverDobH the driverDobH to set
	 */
	public void setDriverDobH(String driverDobH)
	{
		this.driverDobH = driverDobH;
	}

	public boolean isDriverUnder21() {
		return isDriverUnder21;
	}

	public void setDriverUnder21(boolean isDriverUnder21) {
		this.isDriverUnder21 = isDriverUnder21;
	}

	/**
	 * @return the driverEdu
	 */
	public String getDriverEdu()
	{
		return driverEdu;
	}

	/**
	 * @param driverEdu the driverEdu to set
	 */
	public void setDriverEdu(String driverEdu)
	{
		this.driverEdu = driverEdu;
	}

	/**
	 * @return the driverNoChild
	 */
	public String getDriverNoChild()
	{
		return driverNoChild;
	}

	/**
	 * @param driverNoChild the driverNoChild to set
	 */
	public void setDriverNoChild(String driverNoChild)
	{
		this.driverNoChild = driverNoChild;
	}

	/**
	 * @return the driverMaritalStatus
	 */
	public String getDriverMaritalStatus()
	{
		return driverMaritalStatus;
	}

	/**
	 * @param driverMaritalStatus the driverMaritalStatus to set
	 */
	public void setDriverMaritalStatus(String driverMaritalStatus)
	{
		this.driverMaritalStatus = driverMaritalStatus;
	}

	/**
	 * @return the driverLicences
	 */
	public List<QuotationDriverLicense> getDriverLicences()
	{
		return driverLicences;
	}

	/**
	 * @param driverLicences the driverLicences to set
	 */
	public void setDriverLicences(List<QuotationDriverLicense> driverLicences)
	{
		this.driverLicences = driverLicences;
	}

	/**
	 * @return the driverNOFault
	 */
	public int getDriverNOFault()
	{
		return driverNOFault;
	}

	/**
	 * @param driverNOFault the driverNOFault to set
	 */
	public void setDriverNOFault(int driverNOFault)
	{
		this.driverNOFault = driverNOFault;
	}

	/**
	 * @return the driverNOClaim
	 */
	public int getDriverNOClaim()
	{
		return driverNOClaim;
	}

	/**
	 * @param driverNOClaim the driverNOClaim to set
	 */
	public void setDriverNOClaim(int driverNOClaim)
	{
		this.driverNOClaim = driverNOClaim;
	}

	/**
	 * @return the driverConvictions
	 */
	public String getDriverConvictions()
	{
		return driverConvictions;
	}

	/**
	 * @param driverConvictions the driverConvictions to set
	 */
	public void setDriverConvictions(String driverConvictions)
	{
		this.driverConvictions = driverConvictions;
	}

	/**
	 * @return the driverMedConds
	 */
	public String getDriverMedConds()
	{
		return driverMedConds;
	}

	/**
	 * @param driverMedConds the driverMedConds to set
	 */
	public void setDriverMedConds(String driverMedConds)
	{
		this.driverMedConds = driverMedConds;
	}

	/**
	 * @return the driverNatAddress
	 */
	public QuotationUserAddress getDriverNatAddress()
	{
		return driverNatAddress;
	}

	/**
	 * @param driverNatAddress the driverNatAddress to set
	 */
	public void setDriverNatAddress(QuotationUserAddress driverNatAddress)
	{
		this.driverNatAddress = driverNatAddress;
	}

	/**
	 * @return the driverOffNatAddress
	 */
	public QuotationUserAddress getDriverOffNatAddress()
	{
		return driverOffNatAddress;
	}

	/**
	 * @param driverOffNatAddress the driverOffNatAddress to set
	 */
	public void setDriverOffNatAddress(QuotationUserAddress driverOffNatAddress)
	{
		this.driverOffNatAddress = driverOffNatAddress;
	}

	/**
	 * @return the ncdYears
	 */
	public int getNcdYears()
	{
		return ncdYears;
	}

	/**
	 * @param ncdYears the ncdYears to set
	 */
	public void setNcdYears(int ncdYears)
	{
		this.ncdYears = ncdYears;
	}

	public String getInsuredRelative() {
		return insuredRelative;
	}

	public void setInsuredRelative(String insuredRelative) {
		this.insuredRelative = insuredRelative;
	}

	public String getRelationProofFileName() {
		return relationProofFileName;
	}

	public void setRelationProofFileName(String relationProofFileName) {
		this.relationProofFileName = relationProofFileName;
	}

	public String getDriverNationalityDescEN() {
		return driverNationalityDescEN;
	}

	public void setDriverNationalityDescEN(String driverNationalityDescEN) {
		this.driverNationalityDescEN = driverNationalityDescEN;
	}

	public String getDriverNationalityDescAR() {
		return driverNationalityDescAR;
	}

	public void setDriverNationalityDescAR(String driverNationalityDescAR) {
		this.driverNationalityDescAR = driverNationalityDescAR;
	}

}
