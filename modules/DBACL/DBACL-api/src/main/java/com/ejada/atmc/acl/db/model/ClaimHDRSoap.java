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

import com.ejada.atmc.acl.db.service.persistence.ClaimHDRPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.ClaimHDRServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ClaimHDRSoap implements Serializable {

	public static ClaimHDRSoap toSoapModel(ClaimHDR model) {
		ClaimHDRSoap soapModel = new ClaimHDRSoap();

		soapModel.setPolicyNo(model.getPolicyNo());
		soapModel.setClaimNo(model.getClaimNo());
		soapModel.setClaimStatus(model.getClaimStatus());
		soapModel.setIqamaId(model.getIqamaId());
		soapModel.setReportType(model.getReportType());
		soapModel.setReportNo(model.getReportNo());
		soapModel.setEnPlateNo(model.getEnPlateNo());
		soapModel.setEnPlateL1(model.getEnPlateL1());
		soapModel.setEnPlateL2(model.getEnPlateL2());
		soapModel.setEnPlateL3(model.getEnPlateL3());
		soapModel.setArPlateNo(model.getArPlateNo());
		soapModel.setArPlateL1(model.getArPlateL1());
		soapModel.setArPlateL2(model.getArPlateL2());
		soapModel.setArPlateL3(model.getArPlateL3());
		soapModel.setNatureOfLoss(model.getNatureOfLoss());
		soapModel.setCauseCode(model.getCauseCode());
		soapModel.setTypeOfClaim(model.getTypeOfClaim());
		soapModel.setClaimLossDate(model.getClaimLossDate());
		soapModel.setLossRemarks(model.getLossRemarks());
		soapModel.setFaultPercent(model.getFaultPercent());
		soapModel.setLossLocation(model.getLossLocation());
		soapModel.setClaimAmount(model.getClaimAmount());
		soapModel.setClaimIntmDate(model.getClaimIntmDate());
		soapModel.setClaimSetlDate(model.getClaimSetlDate());
		soapModel.setClaimantName(model.getClaimantName());
		soapModel.setDriverName(model.getDriverName());
		soapModel.setClaimantPhone(model.getClaimantPhone());
		soapModel.setIban(model.getIban());
		soapModel.setTpDriverName(model.getTpDriverName());
		soapModel.setTpAge(model.getTpAge());
		soapModel.setTpID(model.getTpID());
		soapModel.setTpPlateNo(model.getTpPlateNo());
		soapModel.setTpPlateL1(model.getTpPlateL1());
		soapModel.setTpPlateL2(model.getTpPlateL2());
		soapModel.setTpPlateL3(model.getTpPlateL3());
		soapModel.setTpInsuranceCo(model.getTpInsuranceCo());
		soapModel.setTpMobileNo(model.getTpMobileNo());
		soapModel.setTpNationality(model.getTpNationality());
		soapModel.setTpIban(model.getTpIban());
		soapModel.setProdCode(model.getProdCode());

		return soapModel;
	}

	public static ClaimHDRSoap[] toSoapModels(ClaimHDR[] models) {
		ClaimHDRSoap[] soapModels = new ClaimHDRSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClaimHDRSoap[][] toSoapModels(ClaimHDR[][] models) {
		ClaimHDRSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClaimHDRSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClaimHDRSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClaimHDRSoap[] toSoapModels(List<ClaimHDR> models) {
		List<ClaimHDRSoap> soapModels = new ArrayList<ClaimHDRSoap>(
			models.size());

		for (ClaimHDR model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClaimHDRSoap[soapModels.size()]);
	}

	public ClaimHDRSoap() {
	}

	public ClaimHDRPK getPrimaryKey() {
		return new ClaimHDRPK(_policyNo, _claimNo);
	}

	public void setPrimaryKey(ClaimHDRPK pk) {
		setPolicyNo(pk.policyNo);
		setClaimNo(pk.claimNo);
	}

	public String getPolicyNo() {
		return _policyNo;
	}

	public void setPolicyNo(String policyNo) {
		_policyNo = policyNo;
	}

	public String getClaimNo() {
		return _claimNo;
	}

	public void setClaimNo(String claimNo) {
		_claimNo = claimNo;
	}

	public String getClaimStatus() {
		return _claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		_claimStatus = claimStatus;
	}

	public String getIqamaId() {
		return _iqamaId;
	}

	public void setIqamaId(String iqamaId) {
		_iqamaId = iqamaId;
	}

	public String getReportType() {
		return _reportType;
	}

	public void setReportType(String reportType) {
		_reportType = reportType;
	}

	public String getReportNo() {
		return _reportNo;
	}

	public void setReportNo(String reportNo) {
		_reportNo = reportNo;
	}

	public String getEnPlateNo() {
		return _enPlateNo;
	}

	public void setEnPlateNo(String enPlateNo) {
		_enPlateNo = enPlateNo;
	}

	public String getEnPlateL1() {
		return _enPlateL1;
	}

	public void setEnPlateL1(String enPlateL1) {
		_enPlateL1 = enPlateL1;
	}

	public String getEnPlateL2() {
		return _enPlateL2;
	}

	public void setEnPlateL2(String enPlateL2) {
		_enPlateL2 = enPlateL2;
	}

	public String getEnPlateL3() {
		return _enPlateL3;
	}

	public void setEnPlateL3(String enPlateL3) {
		_enPlateL3 = enPlateL3;
	}

	public String getArPlateNo() {
		return _arPlateNo;
	}

	public void setArPlateNo(String arPlateNo) {
		_arPlateNo = arPlateNo;
	}

	public String getArPlateL1() {
		return _arPlateL1;
	}

	public void setArPlateL1(String arPlateL1) {
		_arPlateL1 = arPlateL1;
	}

	public String getArPlateL2() {
		return _arPlateL2;
	}

	public void setArPlateL2(String arPlateL2) {
		_arPlateL2 = arPlateL2;
	}

	public String getArPlateL3() {
		return _arPlateL3;
	}

	public void setArPlateL3(String arPlateL3) {
		_arPlateL3 = arPlateL3;
	}

	public String getNatureOfLoss() {
		return _natureOfLoss;
	}

	public void setNatureOfLoss(String natureOfLoss) {
		_natureOfLoss = natureOfLoss;
	}

	public String getCauseCode() {
		return _causeCode;
	}

	public void setCauseCode(String causeCode) {
		_causeCode = causeCode;
	}

	public String getTypeOfClaim() {
		return _typeOfClaim;
	}

	public void setTypeOfClaim(String typeOfClaim) {
		_typeOfClaim = typeOfClaim;
	}

	public Date getClaimLossDate() {
		return _claimLossDate;
	}

	public void setClaimLossDate(Date claimLossDate) {
		_claimLossDate = claimLossDate;
	}

	public String getLossRemarks() {
		return _lossRemarks;
	}

	public void setLossRemarks(String lossRemarks) {
		_lossRemarks = lossRemarks;
	}

	public String getFaultPercent() {
		return _faultPercent;
	}

	public void setFaultPercent(String faultPercent) {
		_faultPercent = faultPercent;
	}

	public String getLossLocation() {
		return _lossLocation;
	}

	public void setLossLocation(String lossLocation) {
		_lossLocation = lossLocation;
	}

	public String getClaimAmount() {
		return _claimAmount;
	}

	public void setClaimAmount(String claimAmount) {
		_claimAmount = claimAmount;
	}

	public Date getClaimIntmDate() {
		return _claimIntmDate;
	}

	public void setClaimIntmDate(Date claimIntmDate) {
		_claimIntmDate = claimIntmDate;
	}

	public Date getClaimSetlDate() {
		return _claimSetlDate;
	}

	public void setClaimSetlDate(Date claimSetlDate) {
		_claimSetlDate = claimSetlDate;
	}

	public String getClaimantName() {
		return _claimantName;
	}

	public void setClaimantName(String claimantName) {
		_claimantName = claimantName;
	}

	public String getDriverName() {
		return _driverName;
	}

	public void setDriverName(String driverName) {
		_driverName = driverName;
	}

	public String getClaimantPhone() {
		return _claimantPhone;
	}

	public void setClaimantPhone(String claimantPhone) {
		_claimantPhone = claimantPhone;
	}

	public String getIban() {
		return _iban;
	}

	public void setIban(String iban) {
		_iban = iban;
	}

	public String getTpDriverName() {
		return _tpDriverName;
	}

	public void setTpDriverName(String tpDriverName) {
		_tpDriverName = tpDriverName;
	}

	public String getTpAge() {
		return _tpAge;
	}

	public void setTpAge(String tpAge) {
		_tpAge = tpAge;
	}

	public String getTpID() {
		return _tpID;
	}

	public void setTpID(String tpID) {
		_tpID = tpID;
	}

	public String getTpPlateNo() {
		return _tpPlateNo;
	}

	public void setTpPlateNo(String tpPlateNo) {
		_tpPlateNo = tpPlateNo;
	}

	public String getTpPlateL1() {
		return _tpPlateL1;
	}

	public void setTpPlateL1(String tpPlateL1) {
		_tpPlateL1 = tpPlateL1;
	}

	public String getTpPlateL2() {
		return _tpPlateL2;
	}

	public void setTpPlateL2(String tpPlateL2) {
		_tpPlateL2 = tpPlateL2;
	}

	public String getTpPlateL3() {
		return _tpPlateL3;
	}

	public void setTpPlateL3(String tpPlateL3) {
		_tpPlateL3 = tpPlateL3;
	}

	public String getTpInsuranceCo() {
		return _tpInsuranceCo;
	}

	public void setTpInsuranceCo(String tpInsuranceCo) {
		_tpInsuranceCo = tpInsuranceCo;
	}

	public String getTpMobileNo() {
		return _tpMobileNo;
	}

	public void setTpMobileNo(String tpMobileNo) {
		_tpMobileNo = tpMobileNo;
	}

	public String getTpNationality() {
		return _tpNationality;
	}

	public void setTpNationality(String tpNationality) {
		_tpNationality = tpNationality;
	}

	public String getTpIban() {
		return _tpIban;
	}

	public void setTpIban(String tpIban) {
		_tpIban = tpIban;
	}

	public String getProdCode() {
		return _prodCode;
	}

	public void setProdCode(String prodCode) {
		_prodCode = prodCode;
	}

	private String _policyNo;
	private String _claimNo;
	private String _claimStatus;
	private String _iqamaId;
	private String _reportType;
	private String _reportNo;
	private String _enPlateNo;
	private String _enPlateL1;
	private String _enPlateL2;
	private String _enPlateL3;
	private String _arPlateNo;
	private String _arPlateL1;
	private String _arPlateL2;
	private String _arPlateL3;
	private String _natureOfLoss;
	private String _causeCode;
	private String _typeOfClaim;
	private Date _claimLossDate;
	private String _lossRemarks;
	private String _faultPercent;
	private String _lossLocation;
	private String _claimAmount;
	private Date _claimIntmDate;
	private Date _claimSetlDate;
	private String _claimantName;
	private String _driverName;
	private String _claimantPhone;
	private String _iban;
	private String _tpDriverName;
	private String _tpAge;
	private String _tpID;
	private String _tpPlateNo;
	private String _tpPlateL1;
	private String _tpPlateL2;
	private String _tpPlateL3;
	private String _tpInsuranceCo;
	private String _tpMobileNo;
	private String _tpNationality;
	private String _tpIban;
	private String _prodCode;

}