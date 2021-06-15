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

import com.ejada.atmc.acl.db.service.persistence.ClaimODSearchPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.ClaimODSearchServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ClaimODSearchSoap implements Serializable {

	public static ClaimODSearchSoap toSoapModel(ClaimODSearch model) {
		ClaimODSearchSoap soapModel = new ClaimODSearchSoap();

		soapModel.setPolicyNo(model.getPolicyNo());
		soapModel.setReportNo(model.getReportNo());
		soapModel.setVehicleSEQCustom(model.getVehicleSEQCustom());
		soapModel.setVehicleDevType(model.getVehicleDevType());
		soapModel.setNatureofLoss(model.getNatureofLoss());
		soapModel.setCauseCode(model.getCauseCode());
		soapModel.setTypeOfClaim(model.getTypeOfClaim());
		soapModel.setClaimLossDate(model.getClaimLossDate());
		soapModel.setLossRemarks(model.getLossRemarks());
		soapModel.setFaultPercent(model.getFaultPercent());

		return soapModel;
	}

	public static ClaimODSearchSoap[] toSoapModels(ClaimODSearch[] models) {
		ClaimODSearchSoap[] soapModels = new ClaimODSearchSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClaimODSearchSoap[][] toSoapModels(ClaimODSearch[][] models) {
		ClaimODSearchSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClaimODSearchSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClaimODSearchSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClaimODSearchSoap[] toSoapModels(List<ClaimODSearch> models) {
		List<ClaimODSearchSoap> soapModels = new ArrayList<ClaimODSearchSoap>(
			models.size());

		for (ClaimODSearch model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClaimODSearchSoap[soapModels.size()]);
	}

	public ClaimODSearchSoap() {
	}

	public ClaimODSearchPK getPrimaryKey() {
		return new ClaimODSearchPK(_policyNo, _reportNo, _vehicleSEQCustom);
	}

	public void setPrimaryKey(ClaimODSearchPK pk) {
		setPolicyNo(pk.policyNo);
		setReportNo(pk.reportNo);
		setVehicleSEQCustom(pk.vehicleSEQCustom);
	}

	public String getPolicyNo() {
		return _policyNo;
	}

	public void setPolicyNo(String policyNo) {
		_policyNo = policyNo;
	}

	public String getReportNo() {
		return _reportNo;
	}

	public void setReportNo(String reportNo) {
		_reportNo = reportNo;
	}

	public String getVehicleSEQCustom() {
		return _vehicleSEQCustom;
	}

	public void setVehicleSEQCustom(String vehicleSEQCustom) {
		_vehicleSEQCustom = vehicleSEQCustom;
	}

	public String getVehicleDevType() {
		return _vehicleDevType;
	}

	public void setVehicleDevType(String vehicleDevType) {
		_vehicleDevType = vehicleDevType;
	}

	public String getNatureofLoss() {
		return _natureofLoss;
	}

	public void setNatureofLoss(String natureofLoss) {
		_natureofLoss = natureofLoss;
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

	private String _policyNo;
	private String _reportNo;
	private String _vehicleSEQCustom;
	private String _vehicleDevType;
	private String _natureofLoss;
	private String _causeCode;
	private String _typeOfClaim;
	private Date _claimLossDate;
	private String _lossRemarks;
	private String _faultPercent;

}