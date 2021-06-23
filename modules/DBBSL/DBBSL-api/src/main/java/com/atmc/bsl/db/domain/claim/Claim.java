/*
 * Claim.java Feb 1, 2018  
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
package com.atmc.bsl.db.domain.claim;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Sarah Taher
 *
 */

public class Claim {

	private String policyNo;
	private String claimNo;
	private String claimStatus;
	private String iqamaId;
	private String reportType;
	private String reportNo;
	private String enPlateNo;
	private String enPlateL1;
	private String enPlateL2;
	private String enPlateL3;
	private String arPlateNo;
	private String arPlateL1;
	private String arPlateL2;
	private String arPlateL3;
	private String natureOfLoss;
	private String causeCode;
	private String typeOfClaim;
	private Date claimLossDate;
	private String lossRemarks;
	private String faultPercent;
	private String lossLocation;
	private String lossLocationAr;
	private String claimAmount;
	private Date claimIntmDate;
	private Date claimSetlDate;
	private String claimAntName;
	private String driverName;
	private String claimAntPhone;
	private String iban;
	private String tpDriverName;
	private String tpAge;
	private String tpID;
	private String tpPlateNo;
	private String tpPlateL1;
	private String tpPlateL2;
	private String tpPlateL3;
	private String tpInsuranceCo;
	private String tpMobileNo;
	private String tpNationality;
	private String tpIban;
	private String productDescEn;
	private String productDescAr;
	private String product;
	private String workflowStatus;
	private List<ClaimHistory> claimHistory;
	private List<ClaimAdminUpload> claimAdminUpload;
	private String vehMakeEn;
	private String vehMakeAr;
	private String vehModelEn;
	private String vehModelAr;
	private long mfgYear;

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getIqamaId() {
		return iqamaId;
	}

	public void setIqamaId(String iqamaId) {
		this.iqamaId = iqamaId;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	public String getEnPlateNo() {
		return enPlateNo;
	}

	public void setEnPlateNo(String enPlateNo) {
		this.enPlateNo = enPlateNo;
	}

	public String getEnPlateL1() {
		return enPlateL1;
	}

	public void setEnPlateL1(String enPlateL1) {
		this.enPlateL1 = enPlateL1;
	}

	public String getEnPlateL2() {
		return enPlateL2;
	}

	public void setEnPlateL2(String enPlateL2) {
		this.enPlateL2 = enPlateL2;
	}

	public String getEnPlateL3() {
		return enPlateL3;
	}

	public void setEnPlateL3(String enPlateL3) {
		this.enPlateL3 = enPlateL3;
	}

	public String getArPlateNo() {
		return arPlateNo;
	}

	public void setArPlateNo(String arPlateNo) {
		this.arPlateNo = arPlateNo;
	}

	public String getArPlateL1() {
		return arPlateL1;
	}

	public void setArPlateL1(String arPlateL1) {
		this.arPlateL1 = arPlateL1;
	}

	public String getArPlateL2() {
		return arPlateL2;
	}

	public void setArPlateL2(String arPlateL2) {
		this.arPlateL2 = arPlateL2;
	}

	public String getArPlateL3() {
		return arPlateL3;
	}

	public void setArPlateL3(String arPlateL3) {
		this.arPlateL3 = arPlateL3;
	}

	public String getNatureOfLoss() {
		return natureOfLoss;
	}

	public void setNatureOfLoss(String natureOfLoss) {
		this.natureOfLoss = natureOfLoss;
	}

	public String getCauseCode() {
		return causeCode;
	}

	public void setCauseCode(String causeCode) {
		this.causeCode = causeCode;
	}

	public String getTypeOfClaim() {
		return typeOfClaim;
	}

	public void setTypeOfClaim(String typeOfClaim) {
		this.typeOfClaim = typeOfClaim;
	}

	public Date getClaimLossDate() {
		return claimLossDate;
	}

	public void setClaimLossDate(Date claimLossDate) {
		this.claimLossDate = claimLossDate;
	}

	public String getLossRemarks() {
		return lossRemarks;
	}

	public void setLossRemarks(String lossRemarks) {
		this.lossRemarks = lossRemarks;
	}

	public String getFaultPercent() {
		return faultPercent;
	}

	public void setFaultPercent(String faultPercent) {
		this.faultPercent = faultPercent;
	}

	public String getLossLocation() {
		return lossLocation;
	}

	public void setLossLocation(String lossLocation) {
		this.lossLocation = lossLocation;
	}

	public Date getClaimIntmDate() {
		return claimIntmDate;
	}

	public void setClaimIntmDate(Date claimIntmDate) {
		this.claimIntmDate = claimIntmDate;
	}

	public Date getClaimSetlDate() {
		return claimSetlDate;
	}

	public void setClaimSetlDate(Date claimSetlDate) {
		this.claimSetlDate = claimSetlDate;
	}

	public String getClaimAntName() {
		return claimAntName;
	}

	public void setClaimAntName(String claimAntName) {
		this.claimAntName = claimAntName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getClaimAntPhone() {
		return claimAntPhone;
	}

	public void setClaimAntPhone(String claimAntPhone) {
		this.claimAntPhone = claimAntPhone;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getTpDriverName() {
		return tpDriverName;
	}

	public void setTpDriverName(String tpDriverName) {
		this.tpDriverName = tpDriverName;
	}

	public String getTpAge() {
		return tpAge;
	}

	public void setTpAge(String tpAge) {
		this.tpAge = tpAge;
	}

	public String getTpID() {
		return tpID;
	}

	public void setTpID(String tpID) {
		this.tpID = tpID;
	}

	public String getTpPlateNo() {
		return tpPlateNo;
	}

	public void setTpPlateNo(String tpPlateNo) {
		this.tpPlateNo = tpPlateNo;
	}

	public String getTpPlateL1() {
		return tpPlateL1;
	}

	public void setTpPlateL1(String tpPlateL1) {
		this.tpPlateL1 = tpPlateL1;
	}

	public String getTpPlateL2() {
		return tpPlateL2;
	}

	public void setTpPlateL2(String tpPlateL2) {
		this.tpPlateL2 = tpPlateL2;
	}

	public String getTpPlateL3() {
		return tpPlateL3;
	}

	public void setTpPlateL3(String tpPlateL3) {
		this.tpPlateL3 = tpPlateL3;
	}

	public String getTpInsuranceCo() {
		return tpInsuranceCo;
	}

	public void setTpInsuranceCo(String tpInsuranceCo) {
		this.tpInsuranceCo = tpInsuranceCo;
	}

	public String getTpMobileNo() {
		return tpMobileNo;
	}

	public void setTpMobileNo(String tpMobileNo) {
		this.tpMobileNo = tpMobileNo;
	}

	public String getTpNationality() {
		return tpNationality;
	}

	public void setTpNationality(String tpNationality) {
		this.tpNationality = tpNationality;
	}

	public String getTpIban() {
		return tpIban;
	}

	public void setTpIban(String tpIban) {
		this.tpIban = tpIban;
	}

	public String getProductDescEn() {
		return productDescEn;
	}

	public void setProductDescEn(String productDescEn) {
		this.productDescEn = productDescEn;
	}

	public String getProductDescAr() {
		return productDescAr;
	}

	public void setProductDescAr(String productDescAr) {
		this.productDescAr = productDescAr;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(String claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getLossLocationAr() {
		return lossLocationAr;
	}

	public void setLossLocationAr(String lossLocationAr) {
		this.lossLocationAr = lossLocationAr;
	}

	/**
	 * @return the workflowStatus
	 */
	public String getWorkflowStatus() {
		return workflowStatus;
	}

	/**
	 * @param workflowStatus the workflowStatus to set
	 */
	public void setWorkflowStatus(String workflowStatus) {
		this.workflowStatus = workflowStatus;
	}

	public List<ClaimHistory> getClaimHistory() {
		return claimHistory;
	}

	public void setClaimHistory(List<ClaimHistory> claimHistory) {
		this.claimHistory = claimHistory;
	}

	public List<ClaimAdminUpload> getClaimAdminUpload() {
		return claimAdminUpload;
	}

	public void setClaimAdminUpload(List<ClaimAdminUpload> claimAdminUpload) {
		this.claimAdminUpload = claimAdminUpload;
	}

	public String getVehMakeEn() {
		return vehMakeEn;
	}

	public void setVehMakeEn(String vehMakeEn) {
		this.vehMakeEn = vehMakeEn;
	}

	public String getVehMakeAr() {
		return vehMakeAr;
	}

	public void setVehMakeAr(String vehMakeAr) {
		this.vehMakeAr = vehMakeAr;
	}

	public String getVehModelEn() {
		return vehModelEn;
	}

	public void setVehModelEn(String vehModelEn) {
		this.vehModelEn = vehModelEn;
	}

	public String getVehModelAr() {
		return vehModelAr;
	}

	public void setVehModelAr(String vehModelAr) {
		this.vehModelAr = vehModelAr;
	}

	public long getMfgYear() {
		return mfgYear;
	}

	public void setMfgYear(long mfgYear) {
		this.mfgYear = mfgYear;
	}

	public String toString() {
		String objectStr = "";
		objectStr += "\n\n policyNo : " + policyNo;
		objectStr += "\n\n claimNo : " + claimNo;
		objectStr += "\n\n claimStatus : " + claimStatus;
		objectStr += "\n\n iqamaId : " + iqamaId;
		objectStr += "\n\n reportType : " + reportType;
		objectStr += "\n\n reportNo : " + reportNo;
		objectStr += "\n\n enPlateNo : " + enPlateNo;
		objectStr += "\n\n enPlateL1 : " + enPlateL1;
		objectStr += "\n\n enPlateL2 : " + enPlateL2;
		objectStr += "\n\n enPlateL3 : " + enPlateL3;
		objectStr += "\n\n arPlateNo : " + arPlateNo;
		objectStr += "\n\n arPlateL1 : " + arPlateL1;
		objectStr += "\n\n arPlateL2 : " + arPlateL2;
		objectStr += "\n\n arPlateL3 : " + arPlateL3;
		objectStr += "\n\n natureOfLoss : " + natureOfLoss;
		objectStr += "\n\n causeCode : " + causeCode;
		objectStr += "\n\n typeOfClaim : " + typeOfClaim;
		objectStr += "\n\n claimLossDate : " + claimLossDate;
		objectStr += "\n\n lossRemarks : " + lossRemarks;
		objectStr += "\n\n faultPercent : " + faultPercent;
		objectStr += "\n\n lossLocation : " + lossLocation;
		objectStr += "\n\n lossLocationAr : " + lossLocationAr;
		objectStr += "\n\n claimAmount : " + claimAmount;
		objectStr += "\n\n claimIntmDate : " + claimIntmDate;
		objectStr += "\n\n claimSetlDate : " + claimSetlDate;
		objectStr += "\n\n claimAntName : " + claimAntName;
		objectStr += "\n\n driverName : " + driverName;
		objectStr += "\n\n claimAntPhone : " + claimAntPhone;
		objectStr += "\n\n iban : " + iban;
		objectStr += "\n\n tpDriverName : " + tpDriverName;
		objectStr += "\n\n tpAge : " + tpAge;
		objectStr += "\n\n tpID : " + tpID;
		objectStr += "\n\n tpPlateNo : " + tpPlateNo;
		objectStr += "\n\n tpPlateL1 : " + tpPlateL1;
		objectStr += "\n\n tpPlateL2 : " + tpPlateL2;
		objectStr += "\n\n tpPlateL3 : " + tpPlateL3;
		objectStr += "\n\n tpInsuranceCo : " + tpInsuranceCo;
		objectStr += "\n\n tpMobileNo : " + tpMobileNo;
		objectStr += "\n\n tpNationality : " + tpNationality;
		objectStr += "\n\n tpIban : " + tpIban;
		objectStr += "\n\n productDescEn : " + productDescEn;
		objectStr += "\n\n productDescAr : " + productDescAr;
		objectStr += "\n\n product : " + product;
		objectStr += "\n\n workflowStatus : " + workflowStatus;
		objectStr += "\n\n claimHistory : " + Arrays.toString(claimHistory.toArray());
		objectStr += "\n\n claimAdminUpload : " + claimAdminUpload;
		objectStr += "\n\n vehMakeEn : " + vehMakeEn;
		objectStr += "\n\n vehMakeAr : " + vehMakeAr;
		objectStr += "\n\n vehModelEn : " + vehModelEn;
		objectStr += "\n\n vehModelAr : " + vehModelAr;
		objectStr += "\n\n mfgYear : " + mfgYear;

		return objectStr;
	}

}
