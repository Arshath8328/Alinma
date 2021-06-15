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

import com.ejada.atmc.acl.db.service.persistence.ClaimTPSearchPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.ClaimTPSearchServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ClaimTPSearchSoap implements Serializable {

	public static ClaimTPSearchSoap toSoapModel(ClaimTPSearch model) {
		ClaimTPSearchSoap soapModel = new ClaimTPSearchSoap();

		soapModel.setReportNo(model.getReportNo());
		soapModel.setTpId(model.getTpId());
		soapModel.setTpDriverName(model.getTpDriverName());
		soapModel.setTpAge(model.getTpAge());
		soapModel.setVehicleSEQCustom(model.getVehicleSEQCustom());
		soapModel.setTpMobileNo(model.getTpMobileNo());
		soapModel.setTpNationality(model.getTpNationality());

		return soapModel;
	}

	public static ClaimTPSearchSoap[] toSoapModels(ClaimTPSearch[] models) {
		ClaimTPSearchSoap[] soapModels = new ClaimTPSearchSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClaimTPSearchSoap[][] toSoapModels(ClaimTPSearch[][] models) {
		ClaimTPSearchSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClaimTPSearchSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClaimTPSearchSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClaimTPSearchSoap[] toSoapModels(List<ClaimTPSearch> models) {
		List<ClaimTPSearchSoap> soapModels = new ArrayList<ClaimTPSearchSoap>(
			models.size());

		for (ClaimTPSearch model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClaimTPSearchSoap[soapModels.size()]);
	}

	public ClaimTPSearchSoap() {
	}

	public ClaimTPSearchPK getPrimaryKey() {
		return new ClaimTPSearchPK(_reportNo, _tpId);
	}

	public void setPrimaryKey(ClaimTPSearchPK pk) {
		setReportNo(pk.reportNo);
		setTpId(pk.tpId);
	}

	public String getReportNo() {
		return _reportNo;
	}

	public void setReportNo(String reportNo) {
		_reportNo = reportNo;
	}

	public String getTpId() {
		return _tpId;
	}

	public void setTpId(String tpId) {
		_tpId = tpId;
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

	public String getVehicleSEQCustom() {
		return _vehicleSEQCustom;
	}

	public void setVehicleSEQCustom(String vehicleSEQCustom) {
		_vehicleSEQCustom = vehicleSEQCustom;
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

	private String _reportNo;
	private String _tpId;
	private String _tpDriverName;
	private String _tpAge;
	private String _vehicleSEQCustom;
	private String _tpMobileNo;
	private String _tpNationality;

}