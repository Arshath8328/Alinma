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

import com.ejada.atmc.acl.db.service.persistence.PolVEHSearchPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.PolVEHSearchServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PolVEHSearchSoap implements Serializable {

	public static PolVEHSearchSoap toSoapModel(PolVEHSearch model) {
		PolVEHSearchSoap soapModel = new PolVEHSearchSoap();

		soapModel.setPolicyNo(model.getPolicyNo());
		soapModel.setVehicleSEQCustom(model.getVehicleSEQCustom());
		soapModel.setChassisNo(model.getChassisNo());
		soapModel.setVehicleDevType(model.getVehicleDevType());
		soapModel.setInceptionDate(model.getInceptionDate());
		soapModel.setExpiryDate(model.getExpiryDate());
		soapModel.setEngPlateNo(model.getEngPlateNo());
		soapModel.setEngPlateL1(model.getEngPlateL1());
		soapModel.setEngPlateL2(model.getEngPlateL2());
		soapModel.setEngPlateL3(model.getEngPlateL3());
		soapModel.setArbPlateNo(model.getArbPlateNo());
		soapModel.setArbPlateL1(model.getArbPlateL1());
		soapModel.setArbPlateL2(model.getArbPlateL2());
		soapModel.setArbPlateL3(model.getArbPlateL3());

		return soapModel;
	}

	public static PolVEHSearchSoap[] toSoapModels(PolVEHSearch[] models) {
		PolVEHSearchSoap[] soapModels = new PolVEHSearchSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PolVEHSearchSoap[][] toSoapModels(PolVEHSearch[][] models) {
		PolVEHSearchSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PolVEHSearchSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PolVEHSearchSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PolVEHSearchSoap[] toSoapModels(List<PolVEHSearch> models) {
		List<PolVEHSearchSoap> soapModels = new ArrayList<PolVEHSearchSoap>(
			models.size());

		for (PolVEHSearch model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PolVEHSearchSoap[soapModels.size()]);
	}

	public PolVEHSearchSoap() {
	}

	public PolVEHSearchPK getPrimaryKey() {
		return new PolVEHSearchPK(_policyNo, _vehicleSEQCustom);
	}

	public void setPrimaryKey(PolVEHSearchPK pk) {
		setPolicyNo(pk.policyNo);
		setVehicleSEQCustom(pk.vehicleSEQCustom);
	}

	public String getPolicyNo() {
		return _policyNo;
	}

	public void setPolicyNo(String policyNo) {
		_policyNo = policyNo;
	}

	public String getVehicleSEQCustom() {
		return _vehicleSEQCustom;
	}

	public void setVehicleSEQCustom(String vehicleSEQCustom) {
		_vehicleSEQCustom = vehicleSEQCustom;
	}

	public String getChassisNo() {
		return _chassisNo;
	}

	public void setChassisNo(String chassisNo) {
		_chassisNo = chassisNo;
	}

	public String getVehicleDevType() {
		return _vehicleDevType;
	}

	public void setVehicleDevType(String vehicleDevType) {
		_vehicleDevType = vehicleDevType;
	}

	public Date getInceptionDate() {
		return _inceptionDate;
	}

	public void setInceptionDate(Date inceptionDate) {
		_inceptionDate = inceptionDate;
	}

	public Date getExpiryDate() {
		return _expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		_expiryDate = expiryDate;
	}

	public long getEngPlateNo() {
		return _engPlateNo;
	}

	public void setEngPlateNo(long engPlateNo) {
		_engPlateNo = engPlateNo;
	}

	public String getEngPlateL1() {
		return _engPlateL1;
	}

	public void setEngPlateL1(String engPlateL1) {
		_engPlateL1 = engPlateL1;
	}

	public String getEngPlateL2() {
		return _engPlateL2;
	}

	public void setEngPlateL2(String engPlateL2) {
		_engPlateL2 = engPlateL2;
	}

	public String getEngPlateL3() {
		return _engPlateL3;
	}

	public void setEngPlateL3(String engPlateL3) {
		_engPlateL3 = engPlateL3;
	}

	public String getArbPlateNo() {
		return _arbPlateNo;
	}

	public void setArbPlateNo(String arbPlateNo) {
		_arbPlateNo = arbPlateNo;
	}

	public String getArbPlateL1() {
		return _arbPlateL1;
	}

	public void setArbPlateL1(String arbPlateL1) {
		_arbPlateL1 = arbPlateL1;
	}

	public String getArbPlateL2() {
		return _arbPlateL2;
	}

	public void setArbPlateL2(String arbPlateL2) {
		_arbPlateL2 = arbPlateL2;
	}

	public String getArbPlateL3() {
		return _arbPlateL3;
	}

	public void setArbPlateL3(String arbPlateL3) {
		_arbPlateL3 = arbPlateL3;
	}

	private String _policyNo;
	private String _vehicleSEQCustom;
	private String _chassisNo;
	private String _vehicleDevType;
	private Date _inceptionDate;
	private Date _expiryDate;
	private long _engPlateNo;
	private String _engPlateL1;
	private String _engPlateL2;
	private String _engPlateL3;
	private String _arbPlateNo;
	private String _arbPlateL1;
	private String _arbPlateL2;
	private String _arbPlateL3;

}