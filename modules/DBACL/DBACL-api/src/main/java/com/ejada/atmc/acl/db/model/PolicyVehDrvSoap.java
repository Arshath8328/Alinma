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

import com.ejada.atmc.acl.db.service.persistence.PolicyVehDrvPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.PolicyVehDrvServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PolicyVehDrvSoap implements Serializable {

	public static PolicyVehDrvSoap toSoapModel(PolicyVehDrv model) {
		PolicyVehDrvSoap soapModel = new PolicyVehDrvSoap();

		soapModel.setPolicyNo(model.getPolicyNo());
		soapModel.setVehId(model.getVehId());
		soapModel.setDriverLicenseNo(model.getDriverLicenseNo());
		soapModel.setDriverName(model.getDriverName());
		soapModel.setDriverBirthDate(model.getDriverBirthDate());
		soapModel.setDriverNationality(model.getDriverNationality());
		soapModel.setDriverGender(model.getDriverGender());

		return soapModel;
	}

	public static PolicyVehDrvSoap[] toSoapModels(PolicyVehDrv[] models) {
		PolicyVehDrvSoap[] soapModels = new PolicyVehDrvSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PolicyVehDrvSoap[][] toSoapModels(PolicyVehDrv[][] models) {
		PolicyVehDrvSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PolicyVehDrvSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PolicyVehDrvSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PolicyVehDrvSoap[] toSoapModels(List<PolicyVehDrv> models) {
		List<PolicyVehDrvSoap> soapModels = new ArrayList<PolicyVehDrvSoap>(
			models.size());

		for (PolicyVehDrv model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PolicyVehDrvSoap[soapModels.size()]);
	}

	public PolicyVehDrvSoap() {
	}

	public PolicyVehDrvPK getPrimaryKey() {
		return new PolicyVehDrvPK(_policyNo, _vehId, _driverLicenseNo);
	}

	public void setPrimaryKey(PolicyVehDrvPK pk) {
		setPolicyNo(pk.policyNo);
		setVehId(pk.vehId);
		setDriverLicenseNo(pk.driverLicenseNo);
	}

	public String getPolicyNo() {
		return _policyNo;
	}

	public void setPolicyNo(String policyNo) {
		_policyNo = policyNo;
	}

	public long getVehId() {
		return _vehId;
	}

	public void setVehId(long vehId) {
		_vehId = vehId;
	}

	public String getDriverLicenseNo() {
		return _driverLicenseNo;
	}

	public void setDriverLicenseNo(String driverLicenseNo) {
		_driverLicenseNo = driverLicenseNo;
	}

	public String getDriverName() {
		return _driverName;
	}

	public void setDriverName(String driverName) {
		_driverName = driverName;
	}

	public Date getDriverBirthDate() {
		return _driverBirthDate;
	}

	public void setDriverBirthDate(Date driverBirthDate) {
		_driverBirthDate = driverBirthDate;
	}

	public String getDriverNationality() {
		return _driverNationality;
	}

	public void setDriverNationality(String driverNationality) {
		_driverNationality = driverNationality;
	}

	public String getDriverGender() {
		return _driverGender;
	}

	public void setDriverGender(String driverGender) {
		_driverGender = driverGender;
	}

	private String _policyNo;
	private long _vehId;
	private String _driverLicenseNo;
	private String _driverName;
	private Date _driverBirthDate;
	private String _driverNationality;
	private String _driverGender;

}