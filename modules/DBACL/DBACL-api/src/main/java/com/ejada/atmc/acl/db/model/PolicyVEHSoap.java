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

import com.ejada.atmc.acl.db.service.persistence.PolicyVEHPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.PolicyVEHServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PolicyVEHSoap implements Serializable {

	public static PolicyVEHSoap toSoapModel(PolicyVEH model) {
		PolicyVEHSoap soapModel = new PolicyVEHSoap();

		soapModel.setPolicyNo(model.getPolicyNo());
		soapModel.setVehId(model.getVehId());
		soapModel.setVehicleDefType(model.getVehicleDefType());
		soapModel.setVehicleSeqCustom(model.getVehicleSeqCustom());
		soapModel.setChassisNo(model.getChassisNo());
		soapModel.setBodyType(model.getBodyType());
		soapModel.setMake(model.getMake());
		soapModel.setVehModel(model.getVehModel());
		soapModel.setMfgYear(model.getMfgYear());
		soapModel.setColor(model.getColor());
		soapModel.setAgencyRepair(model.getAgencyRepair());
		soapModel.setNoofPassengers(model.getNoofPassengers());
		soapModel.setEnPlateNo(model.getEnPlateNo());
		soapModel.setEnPlateL1(model.getEnPlateL1());
		soapModel.setEnPlateL2(model.getEnPlateL2());
		soapModel.setEnPlateL3(model.getEnPlateL3());
		soapModel.setArPlateNo(model.getArPlateNo());
		soapModel.setArPlateL1(model.getArPlateL1());
		soapModel.setArPlateL2(model.getArPlateL2());
		soapModel.setArPlateL3(model.getArPlateL3());
		soapModel.setDeductible(model.getDeductible());
		soapModel.setVehicleValue(model.getVehicleValue());
		soapModel.setPremium(model.getPremium());
		soapModel.setDiscounts(model.getDiscounts());
		soapModel.setLoading(model.getLoading());
		soapModel.setTotalPremium(model.getTotalPremium());
		soapModel.setNoofClaimFreeYears(model.getNoofClaimFreeYears());
		soapModel.setUseOfCehicle(model.getUseOfCehicle());
		soapModel.setNajmPlateType(model.getNajmPlateType());
		soapModel.setNajmStatus(model.getNajmStatus());
		soapModel.setEstemaraExpiryDate(model.getEstemaraExpiryDate());
		soapModel.setGeoLocation(model.getGeoLocation());

		return soapModel;
	}

	public static PolicyVEHSoap[] toSoapModels(PolicyVEH[] models) {
		PolicyVEHSoap[] soapModels = new PolicyVEHSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PolicyVEHSoap[][] toSoapModels(PolicyVEH[][] models) {
		PolicyVEHSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PolicyVEHSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PolicyVEHSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PolicyVEHSoap[] toSoapModels(List<PolicyVEH> models) {
		List<PolicyVEHSoap> soapModels = new ArrayList<PolicyVEHSoap>(
			models.size());

		for (PolicyVEH model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PolicyVEHSoap[soapModels.size()]);
	}

	public PolicyVEHSoap() {
	}

	public PolicyVEHPK getPrimaryKey() {
		return new PolicyVEHPK(_policyNo, _vehId);
	}

	public void setPrimaryKey(PolicyVEHPK pk) {
		setPolicyNo(pk.policyNo);
		setVehId(pk.vehId);
	}

	public String getPolicyNo() {
		return _policyNo;
	}

	public void setPolicyNo(String policyNo) {
		_policyNo = policyNo;
	}

	public String getVehId() {
		return _vehId;
	}

	public void setVehId(String vehId) {
		_vehId = vehId;
	}

	public String getVehicleDefType() {
		return _vehicleDefType;
	}

	public void setVehicleDefType(String vehicleDefType) {
		_vehicleDefType = vehicleDefType;
	}

	public String getVehicleSeqCustom() {
		return _vehicleSeqCustom;
	}

	public void setVehicleSeqCustom(String vehicleSeqCustom) {
		_vehicleSeqCustom = vehicleSeqCustom;
	}

	public String getChassisNo() {
		return _chassisNo;
	}

	public void setChassisNo(String chassisNo) {
		_chassisNo = chassisNo;
	}

	public String getBodyType() {
		return _bodyType;
	}

	public void setBodyType(String bodyType) {
		_bodyType = bodyType;
	}

	public String getMake() {
		return _make;
	}

	public void setMake(String make) {
		_make = make;
	}

	public String getVehModel() {
		return _vehModel;
	}

	public void setVehModel(String vehModel) {
		_vehModel = vehModel;
	}

	public long getMfgYear() {
		return _mfgYear;
	}

	public void setMfgYear(long mfgYear) {
		_mfgYear = mfgYear;
	}

	public String getColor() {
		return _color;
	}

	public void setColor(String color) {
		_color = color;
	}

	public String getAgencyRepair() {
		return _agencyRepair;
	}

	public void setAgencyRepair(String agencyRepair) {
		_agencyRepair = agencyRepair;
	}

	public long getNoofPassengers() {
		return _noofPassengers;
	}

	public void setNoofPassengers(long noofPassengers) {
		_noofPassengers = noofPassengers;
	}

	public long getEnPlateNo() {
		return _enPlateNo;
	}

	public void setEnPlateNo(long enPlateNo) {
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

	public long getDeductible() {
		return _deductible;
	}

	public void setDeductible(long deductible) {
		_deductible = deductible;
	}

	public long getVehicleValue() {
		return _vehicleValue;
	}

	public void setVehicleValue(long vehicleValue) {
		_vehicleValue = vehicleValue;
	}

	public long getPremium() {
		return _premium;
	}

	public void setPremium(long premium) {
		_premium = premium;
	}

	public long getDiscounts() {
		return _discounts;
	}

	public void setDiscounts(long discounts) {
		_discounts = discounts;
	}

	public long getLoading() {
		return _loading;
	}

	public void setLoading(long loading) {
		_loading = loading;
	}

	public long getTotalPremium() {
		return _totalPremium;
	}

	public void setTotalPremium(long totalPremium) {
		_totalPremium = totalPremium;
	}

	public long getNoofClaimFreeYears() {
		return _noofClaimFreeYears;
	}

	public void setNoofClaimFreeYears(long noofClaimFreeYears) {
		_noofClaimFreeYears = noofClaimFreeYears;
	}

	public String getUseOfCehicle() {
		return _useOfCehicle;
	}

	public void setUseOfCehicle(String useOfCehicle) {
		_useOfCehicle = useOfCehicle;
	}

	public String getNajmPlateType() {
		return _najmPlateType;
	}

	public void setNajmPlateType(String najmPlateType) {
		_najmPlateType = najmPlateType;
	}

	public String getNajmStatus() {
		return _najmStatus;
	}

	public void setNajmStatus(String najmStatus) {
		_najmStatus = najmStatus;
	}

	public String getEstemaraExpiryDate() {
		return _estemaraExpiryDate;
	}

	public void setEstemaraExpiryDate(String estemaraExpiryDate) {
		_estemaraExpiryDate = estemaraExpiryDate;
	}

	public String getGeoLocation() {
		return _geoLocation;
	}

	public void setGeoLocation(String geoLocation) {
		_geoLocation = geoLocation;
	}

	private String _policyNo;
	private String _vehId;
	private String _vehicleDefType;
	private String _vehicleSeqCustom;
	private String _chassisNo;
	private String _bodyType;
	private String _make;
	private String _vehModel;
	private long _mfgYear;
	private String _color;
	private String _agencyRepair;
	private long _noofPassengers;
	private long _enPlateNo;
	private String _enPlateL1;
	private String _enPlateL2;
	private String _enPlateL3;
	private String _arPlateNo;
	private String _arPlateL1;
	private String _arPlateL2;
	private String _arPlateL3;
	private long _deductible;
	private long _vehicleValue;
	private long _premium;
	private long _discounts;
	private long _loading;
	private long _totalPremium;
	private long _noofClaimFreeYears;
	private String _useOfCehicle;
	private String _najmPlateType;
	private String _najmStatus;
	private String _estemaraExpiryDate;
	private String _geoLocation;

}