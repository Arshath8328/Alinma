/*
 * TariffInput.java Feb 1, 2018  
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
package com.ejada.atmc.acl.db.domain.tariff;

import java.sql.Date;

/**
 * @author Sarah Taher
 *
 */

public class TariffInput {
	private String 	productCode;
	private int 	vehicleValue;
	private Date 	effFromDate;
	private String 	schemeCode;
	private String 	region;
	private int 	gender;
	private Date 	driverAge;
	private int 	make;
	private int 	MFGYear;
	private String 	bodyType; 
	private int 	color;
	private String 	arabicColor;
	private int 	purposeVeh;
	private int 	repair;
	private int 	loyalty;
	private String 	uniqueIdentifier;
	private int 	clmFreeYears;
	private int 	ncdDrv1;
	private int 	ncdDrv2;
	private int 	ncdDrv3;
	private int 	ncdDrv4;
	private int 	ncdDrv5;
	private String specialDiscount;
	private long 	insuredid;
	private String  chassisno;
	private int  MaritalStatus;	
	private int  vehicleModel;
	
	public int getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(int vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public long getInsuredid() {
		return insuredid;
	}
	public void setInsuredid(long insuredid) {
		this.insuredid = insuredid;
	}
	public String getChassisno() {
		return chassisno;
	}
	public void setChassisno(String chassisno) {
		this.chassisno = chassisno;
	}
	public int getMaritalStatus() {
		return MaritalStatus;
	}
	public void setMaritalStatus(int maritalStatus) {
		MaritalStatus = maritalStatus;
	}
	public String getArabicColor() {
		return arabicColor;
	}
	public void setArabicColor(String arabicColor) {
		this.arabicColor = arabicColor;
	}
	public String getSpecialDiscount() {
		return specialDiscount;
	}
	public void setSpecialDiscount(String specialDiscount) {
		this.specialDiscount = specialDiscount;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public int getVehicleValue() {
		return vehicleValue;
	}
	public void setVehicleValue(int vehicleValue) {
		this.vehicleValue = vehicleValue;
	}
	public Date getEffFromDate() {
		return effFromDate;
	}
	public void setEffFromDate(Date effFromDate) {
		this.effFromDate = effFromDate;
	}
	public String getSchemeCode() {
		return schemeCode;
	}
	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public Date getDriverAge() {
		return driverAge;
	}
	public void setDriverAge(Date driverAge) {
		this.driverAge = driverAge;
	}
	public int getMake() {
		return make;
	}
	public void setMake(int make) {
		this.make = make;
	}
	public int getMFGYear() {
		return MFGYear;
	}
	public void setMFGYear(int mFGYear) {
		MFGYear = mFGYear;
	}
	public String getBodyType() {
		return bodyType;
	}
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getPurposeVeh() {
		return purposeVeh;
	}
	public void setPurposeVeh(int purposeVeh) {
		this.purposeVeh = purposeVeh;
	}
	public int getRepair() {
		return repair;
	}
	public void setRepair(int repair) {
		this.repair = repair;
	}
	public int getLoyalty() {
		return loyalty;
	}
	public void setLoyalty(int loyalty) {
		this.loyalty = loyalty;
	}
	public String getUniqueIdentifier() {
		return uniqueIdentifier;
	}
	public void setUniqueIdentifier(String uniqueIdentifier) {
		this.uniqueIdentifier = uniqueIdentifier;
	}
	public int getClmFreeYears() {
		return clmFreeYears;
	}
	public void setClmFreeYears(int clmFreeYears) {
		this.clmFreeYears = clmFreeYears;
	}
	public int getNcdDrv1() {
		return ncdDrv1;
	}
	public void setNcdDrv1(int ncdDrv1) {
		this.ncdDrv1 = ncdDrv1;
	}
	public int getNcdDrv2() {
		return ncdDrv2;
	}
	public void setNcdDrv2(int ncdDrv2) {
		this.ncdDrv2 = ncdDrv2;
	}
	public int getNcdDrv3() {
		return ncdDrv3;
	}
	public void setNcdDrv3(int ncdDrv3) {
		this.ncdDrv3 = ncdDrv3;
	}
	public int getNcdDrv4() {
		return ncdDrv4;
	}
	public void setNcdDrv4(int ncdDrv4) {
		this.ncdDrv4 = ncdDrv4;
	}
	public int getNcdDrv5() {
		return ncdDrv5;
	}
	public void setNcdDrv5(int ncdDrv5) {
		this.ncdDrv5 = ncdDrv5;
	}
	@Override
	public String toString() {
		return "TariffInput [productCode=" + productCode + ", vehicleValue=" + vehicleValue + ", effFromDate="
				+ effFromDate + ", schemeCode=" + schemeCode + ", region=" + region + ", gender=" + gender
				+ ", driverAge=" + driverAge + ", make=" + make + ", MFGYear=" + MFGYear + ", bodyType=" + bodyType
				+ ", color=" + color + ", arabicColor=" + arabicColor + ", purposeVeh=" + purposeVeh + ", repair="
				+ repair + ", loyalty=" + loyalty + ", uniqueIdentifier=" + uniqueIdentifier + ", clmFreeYears="
				+ clmFreeYears + ", ncdDrv1=" + ncdDrv1 + ", ncdDrv2=" + ncdDrv2 + ", ncdDrv3=" + ncdDrv3 + ", ncdDrv4="
				+ ncdDrv4 + ", ncdDrv5=" + ncdDrv5 + ", specialDiscount=" + specialDiscount + ", insuredid=" + insuredid
				+ ", chassisno=" + chassisno + ", MaritalStatus=" + MaritalStatus + ", vehicleModel=" + vehicleModel
				+ "]";
	}
}
