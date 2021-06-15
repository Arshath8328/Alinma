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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ClaimHDR}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimHDR
 * @generated
 */
public class ClaimHDRWrapper
	extends BaseModelWrapper<ClaimHDR>
	implements ClaimHDR, ModelWrapper<ClaimHDR> {

	public ClaimHDRWrapper(ClaimHDR claimHDR) {
		super(claimHDR);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("policyNo", getPolicyNo());
		attributes.put("claimNo", getClaimNo());
		attributes.put("claimStatus", getClaimStatus());
		attributes.put("iqamaId", getIqamaId());
		attributes.put("reportType", getReportType());
		attributes.put("reportNo", getReportNo());
		attributes.put("enPlateNo", getEnPlateNo());
		attributes.put("enPlateL1", getEnPlateL1());
		attributes.put("enPlateL2", getEnPlateL2());
		attributes.put("enPlateL3", getEnPlateL3());
		attributes.put("arPlateNo", getArPlateNo());
		attributes.put("arPlateL1", getArPlateL1());
		attributes.put("arPlateL2", getArPlateL2());
		attributes.put("arPlateL3", getArPlateL3());
		attributes.put("natureOfLoss", getNatureOfLoss());
		attributes.put("causeCode", getCauseCode());
		attributes.put("typeOfClaim", getTypeOfClaim());
		attributes.put("claimLossDate", getClaimLossDate());
		attributes.put("lossRemarks", getLossRemarks());
		attributes.put("faultPercent", getFaultPercent());
		attributes.put("lossLocation", getLossLocation());
		attributes.put("claimAmount", getClaimAmount());
		attributes.put("claimIntmDate", getClaimIntmDate());
		attributes.put("claimSetlDate", getClaimSetlDate());
		attributes.put("claimantName", getClaimantName());
		attributes.put("driverName", getDriverName());
		attributes.put("claimantPhone", getClaimantPhone());
		attributes.put("iban", getIban());
		attributes.put("tpDriverName", getTpDriverName());
		attributes.put("tpAge", getTpAge());
		attributes.put("tpID", getTpID());
		attributes.put("tpPlateNo", getTpPlateNo());
		attributes.put("tpPlateL1", getTpPlateL1());
		attributes.put("tpPlateL2", getTpPlateL2());
		attributes.put("tpPlateL3", getTpPlateL3());
		attributes.put("tpInsuranceCo", getTpInsuranceCo());
		attributes.put("tpMobileNo", getTpMobileNo());
		attributes.put("tpNationality", getTpNationality());
		attributes.put("tpIban", getTpIban());
		attributes.put("prodCode", getProdCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String policyNo = (String)attributes.get("policyNo");

		if (policyNo != null) {
			setPolicyNo(policyNo);
		}

		String claimNo = (String)attributes.get("claimNo");

		if (claimNo != null) {
			setClaimNo(claimNo);
		}

		String claimStatus = (String)attributes.get("claimStatus");

		if (claimStatus != null) {
			setClaimStatus(claimStatus);
		}

		String iqamaId = (String)attributes.get("iqamaId");

		if (iqamaId != null) {
			setIqamaId(iqamaId);
		}

		String reportType = (String)attributes.get("reportType");

		if (reportType != null) {
			setReportType(reportType);
		}

		String reportNo = (String)attributes.get("reportNo");

		if (reportNo != null) {
			setReportNo(reportNo);
		}

		String enPlateNo = (String)attributes.get("enPlateNo");

		if (enPlateNo != null) {
			setEnPlateNo(enPlateNo);
		}

		String enPlateL1 = (String)attributes.get("enPlateL1");

		if (enPlateL1 != null) {
			setEnPlateL1(enPlateL1);
		}

		String enPlateL2 = (String)attributes.get("enPlateL2");

		if (enPlateL2 != null) {
			setEnPlateL2(enPlateL2);
		}

		String enPlateL3 = (String)attributes.get("enPlateL3");

		if (enPlateL3 != null) {
			setEnPlateL3(enPlateL3);
		}

		String arPlateNo = (String)attributes.get("arPlateNo");

		if (arPlateNo != null) {
			setArPlateNo(arPlateNo);
		}

		String arPlateL1 = (String)attributes.get("arPlateL1");

		if (arPlateL1 != null) {
			setArPlateL1(arPlateL1);
		}

		String arPlateL2 = (String)attributes.get("arPlateL2");

		if (arPlateL2 != null) {
			setArPlateL2(arPlateL2);
		}

		String arPlateL3 = (String)attributes.get("arPlateL3");

		if (arPlateL3 != null) {
			setArPlateL3(arPlateL3);
		}

		String natureOfLoss = (String)attributes.get("natureOfLoss");

		if (natureOfLoss != null) {
			setNatureOfLoss(natureOfLoss);
		}

		String causeCode = (String)attributes.get("causeCode");

		if (causeCode != null) {
			setCauseCode(causeCode);
		}

		String typeOfClaim = (String)attributes.get("typeOfClaim");

		if (typeOfClaim != null) {
			setTypeOfClaim(typeOfClaim);
		}

		Date claimLossDate = (Date)attributes.get("claimLossDate");

		if (claimLossDate != null) {
			setClaimLossDate(claimLossDate);
		}

		String lossRemarks = (String)attributes.get("lossRemarks");

		if (lossRemarks != null) {
			setLossRemarks(lossRemarks);
		}

		String faultPercent = (String)attributes.get("faultPercent");

		if (faultPercent != null) {
			setFaultPercent(faultPercent);
		}

		String lossLocation = (String)attributes.get("lossLocation");

		if (lossLocation != null) {
			setLossLocation(lossLocation);
		}

		String claimAmount = (String)attributes.get("claimAmount");

		if (claimAmount != null) {
			setClaimAmount(claimAmount);
		}

		Date claimIntmDate = (Date)attributes.get("claimIntmDate");

		if (claimIntmDate != null) {
			setClaimIntmDate(claimIntmDate);
		}

		Date claimSetlDate = (Date)attributes.get("claimSetlDate");

		if (claimSetlDate != null) {
			setClaimSetlDate(claimSetlDate);
		}

		String claimantName = (String)attributes.get("claimantName");

		if (claimantName != null) {
			setClaimantName(claimantName);
		}

		String driverName = (String)attributes.get("driverName");

		if (driverName != null) {
			setDriverName(driverName);
		}

		String claimantPhone = (String)attributes.get("claimantPhone");

		if (claimantPhone != null) {
			setClaimantPhone(claimantPhone);
		}

		String iban = (String)attributes.get("iban");

		if (iban != null) {
			setIban(iban);
		}

		String tpDriverName = (String)attributes.get("tpDriverName");

		if (tpDriverName != null) {
			setTpDriverName(tpDriverName);
		}

		String tpAge = (String)attributes.get("tpAge");

		if (tpAge != null) {
			setTpAge(tpAge);
		}

		String tpID = (String)attributes.get("tpID");

		if (tpID != null) {
			setTpID(tpID);
		}

		String tpPlateNo = (String)attributes.get("tpPlateNo");

		if (tpPlateNo != null) {
			setTpPlateNo(tpPlateNo);
		}

		String tpPlateL1 = (String)attributes.get("tpPlateL1");

		if (tpPlateL1 != null) {
			setTpPlateL1(tpPlateL1);
		}

		String tpPlateL2 = (String)attributes.get("tpPlateL2");

		if (tpPlateL2 != null) {
			setTpPlateL2(tpPlateL2);
		}

		String tpPlateL3 = (String)attributes.get("tpPlateL3");

		if (tpPlateL3 != null) {
			setTpPlateL3(tpPlateL3);
		}

		String tpInsuranceCo = (String)attributes.get("tpInsuranceCo");

		if (tpInsuranceCo != null) {
			setTpInsuranceCo(tpInsuranceCo);
		}

		String tpMobileNo = (String)attributes.get("tpMobileNo");

		if (tpMobileNo != null) {
			setTpMobileNo(tpMobileNo);
		}

		String tpNationality = (String)attributes.get("tpNationality");

		if (tpNationality != null) {
			setTpNationality(tpNationality);
		}

		String tpIban = (String)attributes.get("tpIban");

		if (tpIban != null) {
			setTpIban(tpIban);
		}

		String prodCode = (String)attributes.get("prodCode");

		if (prodCode != null) {
			setProdCode(prodCode);
		}
	}

	/**
	 * Returns the ar plate l1 of this claim hdr.
	 *
	 * @return the ar plate l1 of this claim hdr
	 */
	@Override
	public String getArPlateL1() {
		return model.getArPlateL1();
	}

	/**
	 * Returns the ar plate l2 of this claim hdr.
	 *
	 * @return the ar plate l2 of this claim hdr
	 */
	@Override
	public String getArPlateL2() {
		return model.getArPlateL2();
	}

	/**
	 * Returns the ar plate l3 of this claim hdr.
	 *
	 * @return the ar plate l3 of this claim hdr
	 */
	@Override
	public String getArPlateL3() {
		return model.getArPlateL3();
	}

	/**
	 * Returns the ar plate no of this claim hdr.
	 *
	 * @return the ar plate no of this claim hdr
	 */
	@Override
	public String getArPlateNo() {
		return model.getArPlateNo();
	}

	/**
	 * Returns the cause code of this claim hdr.
	 *
	 * @return the cause code of this claim hdr
	 */
	@Override
	public String getCauseCode() {
		return model.getCauseCode();
	}

	/**
	 * Returns the claim amount of this claim hdr.
	 *
	 * @return the claim amount of this claim hdr
	 */
	@Override
	public String getClaimAmount() {
		return model.getClaimAmount();
	}

	/**
	 * Returns the claimant name of this claim hdr.
	 *
	 * @return the claimant name of this claim hdr
	 */
	@Override
	public String getClaimantName() {
		return model.getClaimantName();
	}

	/**
	 * Returns the claimant phone of this claim hdr.
	 *
	 * @return the claimant phone of this claim hdr
	 */
	@Override
	public String getClaimantPhone() {
		return model.getClaimantPhone();
	}

	/**
	 * Returns the claim intm date of this claim hdr.
	 *
	 * @return the claim intm date of this claim hdr
	 */
	@Override
	public Date getClaimIntmDate() {
		return model.getClaimIntmDate();
	}

	/**
	 * Returns the claim loss date of this claim hdr.
	 *
	 * @return the claim loss date of this claim hdr
	 */
	@Override
	public Date getClaimLossDate() {
		return model.getClaimLossDate();
	}

	/**
	 * Returns the claim no of this claim hdr.
	 *
	 * @return the claim no of this claim hdr
	 */
	@Override
	public String getClaimNo() {
		return model.getClaimNo();
	}

	/**
	 * Returns the claim setl date of this claim hdr.
	 *
	 * @return the claim setl date of this claim hdr
	 */
	@Override
	public Date getClaimSetlDate() {
		return model.getClaimSetlDate();
	}

	/**
	 * Returns the claim status of this claim hdr.
	 *
	 * @return the claim status of this claim hdr
	 */
	@Override
	public String getClaimStatus() {
		return model.getClaimStatus();
	}

	/**
	 * Returns the driver name of this claim hdr.
	 *
	 * @return the driver name of this claim hdr
	 */
	@Override
	public String getDriverName() {
		return model.getDriverName();
	}

	/**
	 * Returns the en plate l1 of this claim hdr.
	 *
	 * @return the en plate l1 of this claim hdr
	 */
	@Override
	public String getEnPlateL1() {
		return model.getEnPlateL1();
	}

	/**
	 * Returns the en plate l2 of this claim hdr.
	 *
	 * @return the en plate l2 of this claim hdr
	 */
	@Override
	public String getEnPlateL2() {
		return model.getEnPlateL2();
	}

	/**
	 * Returns the en plate l3 of this claim hdr.
	 *
	 * @return the en plate l3 of this claim hdr
	 */
	@Override
	public String getEnPlateL3() {
		return model.getEnPlateL3();
	}

	/**
	 * Returns the en plate no of this claim hdr.
	 *
	 * @return the en plate no of this claim hdr
	 */
	@Override
	public String getEnPlateNo() {
		return model.getEnPlateNo();
	}

	/**
	 * Returns the fault percent of this claim hdr.
	 *
	 * @return the fault percent of this claim hdr
	 */
	@Override
	public String getFaultPercent() {
		return model.getFaultPercent();
	}

	/**
	 * Returns the iban of this claim hdr.
	 *
	 * @return the iban of this claim hdr
	 */
	@Override
	public String getIban() {
		return model.getIban();
	}

	/**
	 * Returns the iqama ID of this claim hdr.
	 *
	 * @return the iqama ID of this claim hdr
	 */
	@Override
	public String getIqamaId() {
		return model.getIqamaId();
	}

	/**
	 * Returns the loss location of this claim hdr.
	 *
	 * @return the loss location of this claim hdr
	 */
	@Override
	public String getLossLocation() {
		return model.getLossLocation();
	}

	/**
	 * @return the statusDescAr
	 */
	@Override
	public String getLossLocationCityAr() {
		return model.getLossLocationCityAr();
	}

	@Override
	public String getLossLocationCityEn() {
		return model.getLossLocationCityEn();
	}

	/**
	 * Returns the loss remarks of this claim hdr.
	 *
	 * @return the loss remarks of this claim hdr
	 */
	@Override
	public String getLossRemarks() {
		return model.getLossRemarks();
	}

	/**
	 * Returns the nature of loss of this claim hdr.
	 *
	 * @return the nature of loss of this claim hdr
	 */
	@Override
	public String getNatureOfLoss() {
		return model.getNatureOfLoss();
	}

	/**
	 * Returns the policy no of this claim hdr.
	 *
	 * @return the policy no of this claim hdr
	 */
	@Override
	public String getPolicyNo() {
		return model.getPolicyNo();
	}

	/**
	 * Returns the primary key of this claim hdr.
	 *
	 * @return the primary key of this claim hdr
	 */
	@Override
	public com.ejada.atmc.acl.db.service.persistence.ClaimHDRPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the prod code of this claim hdr.
	 *
	 * @return the prod code of this claim hdr
	 */
	@Override
	public String getProdCode() {
		return model.getProdCode();
	}

	@Override
	public String getProductDescAr() {
		return model.getProductDescAr();
	}

	@Override
	public String getProductDescEn() {
		return model.getProductDescEn();
	}

	/**
	 * Returns the report no of this claim hdr.
	 *
	 * @return the report no of this claim hdr
	 */
	@Override
	public String getReportNo() {
		return model.getReportNo();
	}

	/**
	 * Returns the report type of this claim hdr.
	 *
	 * @return the report type of this claim hdr
	 */
	@Override
	public String getReportType() {
		return model.getReportType();
	}

	/**
	 * Returns the tp age of this claim hdr.
	 *
	 * @return the tp age of this claim hdr
	 */
	@Override
	public String getTpAge() {
		return model.getTpAge();
	}

	/**
	 * Returns the tp driver name of this claim hdr.
	 *
	 * @return the tp driver name of this claim hdr
	 */
	@Override
	public String getTpDriverName() {
		return model.getTpDriverName();
	}

	/**
	 * Returns the tp iban of this claim hdr.
	 *
	 * @return the tp iban of this claim hdr
	 */
	@Override
	public String getTpIban() {
		return model.getTpIban();
	}

	/**
	 * Returns the tp ID of this claim hdr.
	 *
	 * @return the tp ID of this claim hdr
	 */
	@Override
	public String getTpID() {
		return model.getTpID();
	}

	/**
	 * Returns the tp insurance co of this claim hdr.
	 *
	 * @return the tp insurance co of this claim hdr
	 */
	@Override
	public String getTpInsuranceCo() {
		return model.getTpInsuranceCo();
	}

	/**
	 * Returns the tp mobile no of this claim hdr.
	 *
	 * @return the tp mobile no of this claim hdr
	 */
	@Override
	public String getTpMobileNo() {
		return model.getTpMobileNo();
	}

	/**
	 * Returns the tp nationality of this claim hdr.
	 *
	 * @return the tp nationality of this claim hdr
	 */
	@Override
	public String getTpNationality() {
		return model.getTpNationality();
	}

	/**
	 * Returns the tp plate l1 of this claim hdr.
	 *
	 * @return the tp plate l1 of this claim hdr
	 */
	@Override
	public String getTpPlateL1() {
		return model.getTpPlateL1();
	}

	/**
	 * Returns the tp plate l2 of this claim hdr.
	 *
	 * @return the tp plate l2 of this claim hdr
	 */
	@Override
	public String getTpPlateL2() {
		return model.getTpPlateL2();
	}

	/**
	 * Returns the tp plate l3 of this claim hdr.
	 *
	 * @return the tp plate l3 of this claim hdr
	 */
	@Override
	public String getTpPlateL3() {
		return model.getTpPlateL3();
	}

	/**
	 * Returns the tp plate no of this claim hdr.
	 *
	 * @return the tp plate no of this claim hdr
	 */
	@Override
	public String getTpPlateNo() {
		return model.getTpPlateNo();
	}

	/**
	 * Returns the type of claim of this claim hdr.
	 *
	 * @return the type of claim of this claim hdr
	 */
	@Override
	public String getTypeOfClaim() {
		return model.getTypeOfClaim();
	}

	@Override
	public String getWorkflowStatus() {
		return model.getWorkflowStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ar plate l1 of this claim hdr.
	 *
	 * @param arPlateL1 the ar plate l1 of this claim hdr
	 */
	@Override
	public void setArPlateL1(String arPlateL1) {
		model.setArPlateL1(arPlateL1);
	}

	/**
	 * Sets the ar plate l2 of this claim hdr.
	 *
	 * @param arPlateL2 the ar plate l2 of this claim hdr
	 */
	@Override
	public void setArPlateL2(String arPlateL2) {
		model.setArPlateL2(arPlateL2);
	}

	/**
	 * Sets the ar plate l3 of this claim hdr.
	 *
	 * @param arPlateL3 the ar plate l3 of this claim hdr
	 */
	@Override
	public void setArPlateL3(String arPlateL3) {
		model.setArPlateL3(arPlateL3);
	}

	/**
	 * Sets the ar plate no of this claim hdr.
	 *
	 * @param arPlateNo the ar plate no of this claim hdr
	 */
	@Override
	public void setArPlateNo(String arPlateNo) {
		model.setArPlateNo(arPlateNo);
	}

	/**
	 * Sets the cause code of this claim hdr.
	 *
	 * @param causeCode the cause code of this claim hdr
	 */
	@Override
	public void setCauseCode(String causeCode) {
		model.setCauseCode(causeCode);
	}

	/**
	 * Sets the claim amount of this claim hdr.
	 *
	 * @param claimAmount the claim amount of this claim hdr
	 */
	@Override
	public void setClaimAmount(String claimAmount) {
		model.setClaimAmount(claimAmount);
	}

	/**
	 * Sets the claimant name of this claim hdr.
	 *
	 * @param claimantName the claimant name of this claim hdr
	 */
	@Override
	public void setClaimantName(String claimantName) {
		model.setClaimantName(claimantName);
	}

	/**
	 * Sets the claimant phone of this claim hdr.
	 *
	 * @param claimantPhone the claimant phone of this claim hdr
	 */
	@Override
	public void setClaimantPhone(String claimantPhone) {
		model.setClaimantPhone(claimantPhone);
	}

	/**
	 * Sets the claim intm date of this claim hdr.
	 *
	 * @param claimIntmDate the claim intm date of this claim hdr
	 */
	@Override
	public void setClaimIntmDate(Date claimIntmDate) {
		model.setClaimIntmDate(claimIntmDate);
	}

	/**
	 * Sets the claim loss date of this claim hdr.
	 *
	 * @param claimLossDate the claim loss date of this claim hdr
	 */
	@Override
	public void setClaimLossDate(Date claimLossDate) {
		model.setClaimLossDate(claimLossDate);
	}

	/**
	 * Sets the claim no of this claim hdr.
	 *
	 * @param claimNo the claim no of this claim hdr
	 */
	@Override
	public void setClaimNo(String claimNo) {
		model.setClaimNo(claimNo);
	}

	/**
	 * Sets the claim setl date of this claim hdr.
	 *
	 * @param claimSetlDate the claim setl date of this claim hdr
	 */
	@Override
	public void setClaimSetlDate(Date claimSetlDate) {
		model.setClaimSetlDate(claimSetlDate);
	}

	/**
	 * Sets the claim status of this claim hdr.
	 *
	 * @param claimStatus the claim status of this claim hdr
	 */
	@Override
	public void setClaimStatus(String claimStatus) {
		model.setClaimStatus(claimStatus);
	}

	/**
	 * Sets the driver name of this claim hdr.
	 *
	 * @param driverName the driver name of this claim hdr
	 */
	@Override
	public void setDriverName(String driverName) {
		model.setDriverName(driverName);
	}

	/**
	 * Sets the en plate l1 of this claim hdr.
	 *
	 * @param enPlateL1 the en plate l1 of this claim hdr
	 */
	@Override
	public void setEnPlateL1(String enPlateL1) {
		model.setEnPlateL1(enPlateL1);
	}

	/**
	 * Sets the en plate l2 of this claim hdr.
	 *
	 * @param enPlateL2 the en plate l2 of this claim hdr
	 */
	@Override
	public void setEnPlateL2(String enPlateL2) {
		model.setEnPlateL2(enPlateL2);
	}

	/**
	 * Sets the en plate l3 of this claim hdr.
	 *
	 * @param enPlateL3 the en plate l3 of this claim hdr
	 */
	@Override
	public void setEnPlateL3(String enPlateL3) {
		model.setEnPlateL3(enPlateL3);
	}

	/**
	 * Sets the en plate no of this claim hdr.
	 *
	 * @param enPlateNo the en plate no of this claim hdr
	 */
	@Override
	public void setEnPlateNo(String enPlateNo) {
		model.setEnPlateNo(enPlateNo);
	}

	/**
	 * Sets the fault percent of this claim hdr.
	 *
	 * @param faultPercent the fault percent of this claim hdr
	 */
	@Override
	public void setFaultPercent(String faultPercent) {
		model.setFaultPercent(faultPercent);
	}

	/**
	 * Sets the iban of this claim hdr.
	 *
	 * @param iban the iban of this claim hdr
	 */
	@Override
	public void setIban(String iban) {
		model.setIban(iban);
	}

	/**
	 * Sets the iqama ID of this claim hdr.
	 *
	 * @param iqamaId the iqama ID of this claim hdr
	 */
	@Override
	public void setIqamaId(String iqamaId) {
		model.setIqamaId(iqamaId);
	}

	/**
	 * Sets the loss location of this claim hdr.
	 *
	 * @param lossLocation the loss location of this claim hdr
	 */
	@Override
	public void setLossLocation(String lossLocation) {
		model.setLossLocation(lossLocation);
	}

	/**
	 * Sets the loss remarks of this claim hdr.
	 *
	 * @param lossRemarks the loss remarks of this claim hdr
	 */
	@Override
	public void setLossRemarks(String lossRemarks) {
		model.setLossRemarks(lossRemarks);
	}

	/**
	 * Sets the nature of loss of this claim hdr.
	 *
	 * @param natureOfLoss the nature of loss of this claim hdr
	 */
	@Override
	public void setNatureOfLoss(String natureOfLoss) {
		model.setNatureOfLoss(natureOfLoss);
	}

	/**
	 * Sets the policy no of this claim hdr.
	 *
	 * @param policyNo the policy no of this claim hdr
	 */
	@Override
	public void setPolicyNo(String policyNo) {
		model.setPolicyNo(policyNo);
	}

	/**
	 * Sets the primary key of this claim hdr.
	 *
	 * @param primaryKey the primary key of this claim hdr
	 */
	@Override
	public void setPrimaryKey(
		com.ejada.atmc.acl.db.service.persistence.ClaimHDRPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the prod code of this claim hdr.
	 *
	 * @param prodCode the prod code of this claim hdr
	 */
	@Override
	public void setProdCode(String prodCode) {
		model.setProdCode(prodCode);
	}

	/**
	 * Sets the report no of this claim hdr.
	 *
	 * @param reportNo the report no of this claim hdr
	 */
	@Override
	public void setReportNo(String reportNo) {
		model.setReportNo(reportNo);
	}

	/**
	 * Sets the report type of this claim hdr.
	 *
	 * @param reportType the report type of this claim hdr
	 */
	@Override
	public void setReportType(String reportType) {
		model.setReportType(reportType);
	}

	/**
	 * Sets the tp age of this claim hdr.
	 *
	 * @param tpAge the tp age of this claim hdr
	 */
	@Override
	public void setTpAge(String tpAge) {
		model.setTpAge(tpAge);
	}

	/**
	 * Sets the tp driver name of this claim hdr.
	 *
	 * @param tpDriverName the tp driver name of this claim hdr
	 */
	@Override
	public void setTpDriverName(String tpDriverName) {
		model.setTpDriverName(tpDriverName);
	}

	/**
	 * Sets the tp iban of this claim hdr.
	 *
	 * @param tpIban the tp iban of this claim hdr
	 */
	@Override
	public void setTpIban(String tpIban) {
		model.setTpIban(tpIban);
	}

	/**
	 * Sets the tp ID of this claim hdr.
	 *
	 * @param tpID the tp ID of this claim hdr
	 */
	@Override
	public void setTpID(String tpID) {
		model.setTpID(tpID);
	}

	/**
	 * Sets the tp insurance co of this claim hdr.
	 *
	 * @param tpInsuranceCo the tp insurance co of this claim hdr
	 */
	@Override
	public void setTpInsuranceCo(String tpInsuranceCo) {
		model.setTpInsuranceCo(tpInsuranceCo);
	}

	/**
	 * Sets the tp mobile no of this claim hdr.
	 *
	 * @param tpMobileNo the tp mobile no of this claim hdr
	 */
	@Override
	public void setTpMobileNo(String tpMobileNo) {
		model.setTpMobileNo(tpMobileNo);
	}

	/**
	 * Sets the tp nationality of this claim hdr.
	 *
	 * @param tpNationality the tp nationality of this claim hdr
	 */
	@Override
	public void setTpNationality(String tpNationality) {
		model.setTpNationality(tpNationality);
	}

	/**
	 * Sets the tp plate l1 of this claim hdr.
	 *
	 * @param tpPlateL1 the tp plate l1 of this claim hdr
	 */
	@Override
	public void setTpPlateL1(String tpPlateL1) {
		model.setTpPlateL1(tpPlateL1);
	}

	/**
	 * Sets the tp plate l2 of this claim hdr.
	 *
	 * @param tpPlateL2 the tp plate l2 of this claim hdr
	 */
	@Override
	public void setTpPlateL2(String tpPlateL2) {
		model.setTpPlateL2(tpPlateL2);
	}

	/**
	 * Sets the tp plate l3 of this claim hdr.
	 *
	 * @param tpPlateL3 the tp plate l3 of this claim hdr
	 */
	@Override
	public void setTpPlateL3(String tpPlateL3) {
		model.setTpPlateL3(tpPlateL3);
	}

	/**
	 * Sets the tp plate no of this claim hdr.
	 *
	 * @param tpPlateNo the tp plate no of this claim hdr
	 */
	@Override
	public void setTpPlateNo(String tpPlateNo) {
		model.setTpPlateNo(tpPlateNo);
	}

	/**
	 * Sets the type of claim of this claim hdr.
	 *
	 * @param typeOfClaim the type of claim of this claim hdr
	 */
	@Override
	public void setTypeOfClaim(String typeOfClaim) {
		model.setTypeOfClaim(typeOfClaim);
	}

	@Override
	protected ClaimHDRWrapper wrap(ClaimHDR claimHDR) {
		return new ClaimHDRWrapper(claimHDR);
	}

}