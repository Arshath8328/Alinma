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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.MuroorTPUploadsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MuroorTPUploadsSoap implements Serializable {

	public static MuroorTPUploadsSoap toSoapModel(MuroorTPUploads model) {
		MuroorTPUploadsSoap soapModel = new MuroorTPUploadsSoap();

		soapModel.setId(model.getId());
		soapModel.setClaimIntimationNo(model.getClaimIntimationNo());
		soapModel.setIqamaId(model.getIqamaId());
		soapModel.setDriverLicense(model.getDriverLicense());
		soapModel.setDriverLicenseName(model.getDriverLicenseName());
		soapModel.setVehRegist(model.getVehRegist());
		soapModel.setVehRegistName(model.getVehRegistName());
		soapModel.setFrontPhoto(model.getFrontPhoto());
		soapModel.setFrontPhotoName(model.getFrontPhotoName());
		soapModel.setRearPhoto(model.getRearPhoto());
		soapModel.setRearPhotoName(model.getRearPhotoName());
		soapModel.setRightSidePhoto(model.getRightSidePhoto());
		soapModel.setRightSidePhotoName(model.getRightSidePhotoName());
		soapModel.setLeftSidePhoto(model.getLeftSidePhoto());
		soapModel.setLeftSidePhotoName(model.getLeftSidePhotoName());
		soapModel.setBankIban(model.getBankIban());
		soapModel.setBankIbanName(model.getBankIbanName());
		soapModel.setOwnerId(model.getOwnerId());
		soapModel.setOwnerIdName(model.getOwnerIdName());

		return soapModel;
	}

	public static MuroorTPUploadsSoap[] toSoapModels(MuroorTPUploads[] models) {
		MuroorTPUploadsSoap[] soapModels =
			new MuroorTPUploadsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MuroorTPUploadsSoap[][] toSoapModels(
		MuroorTPUploads[][] models) {

		MuroorTPUploadsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new MuroorTPUploadsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MuroorTPUploadsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MuroorTPUploadsSoap[] toSoapModels(
		List<MuroorTPUploads> models) {

		List<MuroorTPUploadsSoap> soapModels =
			new ArrayList<MuroorTPUploadsSoap>(models.size());

		for (MuroorTPUploads model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MuroorTPUploadsSoap[soapModels.size()]);
	}

	public MuroorTPUploadsSoap() {
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

	public Blob getFrontPhoto() {
		return _frontPhoto;
	}

	public void setFrontPhoto(Blob frontPhoto) {
		_frontPhoto = frontPhoto;
	}

	public String getFrontPhotoName() {
		return _frontPhotoName;
	}

	public void setFrontPhotoName(String frontPhotoName) {
		_frontPhotoName = frontPhotoName;
	}

	public Blob getRearPhoto() {
		return _rearPhoto;
	}

	public void setRearPhoto(Blob rearPhoto) {
		_rearPhoto = rearPhoto;
	}

	public String getRearPhotoName() {
		return _rearPhotoName;
	}

	public void setRearPhotoName(String rearPhotoName) {
		_rearPhotoName = rearPhotoName;
	}

	public Blob getRightSidePhoto() {
		return _rightSidePhoto;
	}

	public void setRightSidePhoto(Blob rightSidePhoto) {
		_rightSidePhoto = rightSidePhoto;
	}

	public String getRightSidePhotoName() {
		return _rightSidePhotoName;
	}

	public void setRightSidePhotoName(String rightSidePhotoName) {
		_rightSidePhotoName = rightSidePhotoName;
	}

	public Blob getLeftSidePhoto() {
		return _leftSidePhoto;
	}

	public void setLeftSidePhoto(Blob leftSidePhoto) {
		_leftSidePhoto = leftSidePhoto;
	}

	public String getLeftSidePhotoName() {
		return _leftSidePhotoName;
	}

	public void setLeftSidePhotoName(String leftSidePhotoName) {
		_leftSidePhotoName = leftSidePhotoName;
	}

	public Blob getBankIban() {
		return _bankIban;
	}

	public void setBankIban(Blob bankIban) {
		_bankIban = bankIban;
	}

	public String getBankIbanName() {
		return _bankIbanName;
	}

	public void setBankIbanName(String bankIbanName) {
		_bankIbanName = bankIbanName;
	}

	public Blob getOwnerId() {
		return _ownerId;
	}

	public void setOwnerId(Blob ownerId) {
		_ownerId = ownerId;
	}

	public String getOwnerIdName() {
		return _ownerIdName;
	}

	public void setOwnerIdName(String ownerIdName) {
		_ownerIdName = ownerIdName;
	}

	private int _id;
	private String _claimIntimationNo;
	private String _iqamaId;
	private Blob _driverLicense;
	private String _driverLicenseName;
	private Blob _vehRegist;
	private String _vehRegistName;
	private Blob _frontPhoto;
	private String _frontPhotoName;
	private Blob _rearPhoto;
	private String _rearPhotoName;
	private Blob _rightSidePhoto;
	private String _rightSidePhotoName;
	private Blob _leftSidePhoto;
	private String _leftSidePhotoName;
	private Blob _bankIban;
	private String _bankIbanName;
	private Blob _ownerId;
	private String _ownerIdName;

}