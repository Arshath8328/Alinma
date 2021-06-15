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

import java.io.Serializable;

import java.sql.Blob;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.ODMuroorUploadsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ODMuroorUploadsSoap implements Serializable {

	public static ODMuroorUploadsSoap toSoapModel(ODMuroorUploads model) {
		ODMuroorUploadsSoap soapModel = new ODMuroorUploadsSoap();

		soapModel.setId(model.getId());
		soapModel.setClaimIntimationNo(model.getClaimIntimationNo());
		soapModel.setIqamaId(model.getIqamaId());
		soapModel.setDriverLicense(model.getDriverLicense());
		soapModel.setDriverLicenseName(model.getDriverLicenseName());
		soapModel.setVehRegist(model.getVehRegist());
		soapModel.setVehRegistName(model.getVehRegistName());
		soapModel.setPolicyCopy(model.getPolicyCopy());
		soapModel.setPolicyCopyName(model.getPolicyCopyName());

		return soapModel;
	}

	public static ODMuroorUploadsSoap[] toSoapModels(ODMuroorUploads[] models) {
		ODMuroorUploadsSoap[] soapModels =
			new ODMuroorUploadsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ODMuroorUploadsSoap[][] toSoapModels(
		ODMuroorUploads[][] models) {

		ODMuroorUploadsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ODMuroorUploadsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ODMuroorUploadsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ODMuroorUploadsSoap[] toSoapModels(
		List<ODMuroorUploads> models) {

		List<ODMuroorUploadsSoap> soapModels =
			new ArrayList<ODMuroorUploadsSoap>(models.size());

		for (ODMuroorUploads model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ODMuroorUploadsSoap[soapModels.size()]);
	}

	public ODMuroorUploadsSoap() {
	}

	public int getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(int pk) {
		setId(pk);
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public String getClaimIntimationNo() {
		return _claimIntimationNo;
	}

	public void setClaimIntimationNo(String claimIntimationNo) {
		_claimIntimationNo = claimIntimationNo;
	}

	public String getIqamaId() {
		return _iqamaId;
	}

	public void setIqamaId(String iqamaId) {
		_iqamaId = iqamaId;
	}

	public Blob getDriverLicense() {
		return _driverLicense;
	}

	public void setDriverLicense(Blob driverLicense) {
		_driverLicense = driverLicense;
	}

	public String getDriverLicenseName() {
		return _driverLicenseName;
	}

	public void setDriverLicenseName(String driverLicenseName) {
		_driverLicenseName = driverLicenseName;
	}

	public Blob getVehRegist() {
		return _vehRegist;
	}

	public void setVehRegist(Blob vehRegist) {
		_vehRegist = vehRegist;
	}

	public String getVehRegistName() {
		return _vehRegistName;
	}

	public void setVehRegistName(String vehRegistName) {
		_vehRegistName = vehRegistName;
	}

	public Blob getPolicyCopy() {
		return _policyCopy;
	}

	public void setPolicyCopy(Blob policyCopy) {
		_policyCopy = policyCopy;
	}

	public String getPolicyCopyName() {
		return _policyCopyName;
	}

	public void setPolicyCopyName(String policyCopyName) {
		_policyCopyName = policyCopyName;
	}

	private int _id;
	private String _claimIntimationNo;
	private String _iqamaId;
	private Blob _driverLicense;
	private String _driverLicenseName;
	private Blob _vehRegist;
	private String _vehRegistName;
	private Blob _policyCopy;
	private String _policyCopyName;

}