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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.CustUploadsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CustUploadsSoap implements Serializable {

	public static CustUploadsSoap toSoapModel(CustUploads model) {
		CustUploadsSoap soapModel = new CustUploadsSoap();

		soapModel.setId(model.getId());
		soapModel.setQuotId(model.getQuotId());
		soapModel.setIdFile(model.getIdFile());
		soapModel.setLicenseFile(model.getLicenseFile());
		soapModel.setIstCardFile(model.getIstCardFile());
		soapModel.setCarFrontFile(model.getCarFrontFile());
		soapModel.setCarBackFile(model.getCarBackFile());
		soapModel.setCarLeftFile(model.getCarLeftFile());
		soapModel.setCarRightFile(model.getCarRightFile());
		soapModel.setEngChassisNoFile(model.getEngChassisNoFile());
		soapModel.setLeaseFile(model.getLeaseFile());
		soapModel.setIdFileName(model.getIdFileName());
		soapModel.setLicenseFileName(model.getLicenseFileName());
		soapModel.setIstCardFileName(model.getIstCardFileName());
		soapModel.setCarFrontFileName(model.getCarFrontFileName());
		soapModel.setCarBackFileName(model.getCarBackFileName());
		soapModel.setCarLeftFileName(model.getCarLeftFileName());
		soapModel.setCarRightFileName(model.getCarRightFileName());
		soapModel.setEngChassisNoFileName(model.getEngChassisNoFileName());
		soapModel.setLeaseFileName(model.getLeaseFileName());

		return soapModel;
	}

	public static CustUploadsSoap[] toSoapModels(CustUploads[] models) {
		CustUploadsSoap[] soapModels = new CustUploadsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CustUploadsSoap[][] toSoapModels(CustUploads[][] models) {
		CustUploadsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CustUploadsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CustUploadsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CustUploadsSoap[] toSoapModels(List<CustUploads> models) {
		List<CustUploadsSoap> soapModels = new ArrayList<CustUploadsSoap>(
			models.size());

		for (CustUploads model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CustUploadsSoap[soapModels.size()]);
	}

	public CustUploadsSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getQuotId() {
		return _quotId;
	}

	public void setQuotId(String quotId) {
		_quotId = quotId;
	}

	public Blob getIdFile() {
		return _idFile;
	}

	public void setIdFile(Blob idFile) {
		_idFile = idFile;
	}

	public Blob getLicenseFile() {
		return _licenseFile;
	}

	public void setLicenseFile(Blob licenseFile) {
		_licenseFile = licenseFile;
	}

	public Blob getIstCardFile() {
		return _istCardFile;
	}

	public void setIstCardFile(Blob istCardFile) {
		_istCardFile = istCardFile;
	}

	public Blob getCarFrontFile() {
		return _carFrontFile;
	}

	public void setCarFrontFile(Blob carFrontFile) {
		_carFrontFile = carFrontFile;
	}

	public Blob getCarBackFile() {
		return _carBackFile;
	}

	public void setCarBackFile(Blob carBackFile) {
		_carBackFile = carBackFile;
	}

	public Blob getCarLeftFile() {
		return _carLeftFile;
	}

	public void setCarLeftFile(Blob carLeftFile) {
		_carLeftFile = carLeftFile;
	}

	public Blob getCarRightFile() {
		return _carRightFile;
	}

	public void setCarRightFile(Blob carRightFile) {
		_carRightFile = carRightFile;
	}

	public Blob getEngChassisNoFile() {
		return _engChassisNoFile;
	}

	public void setEngChassisNoFile(Blob engChassisNoFile) {
		_engChassisNoFile = engChassisNoFile;
	}

	public Blob getLeaseFile() {
		return _leaseFile;
	}

	public void setLeaseFile(Blob leaseFile) {
		_leaseFile = leaseFile;
	}

	public String getIdFileName() {
		return _idFileName;
	}

	public void setIdFileName(String idFileName) {
		_idFileName = idFileName;
	}

	public String getLicenseFileName() {
		return _licenseFileName;
	}

	public void setLicenseFileName(String licenseFileName) {
		_licenseFileName = licenseFileName;
	}

	public String getIstCardFileName() {
		return _istCardFileName;
	}

	public void setIstCardFileName(String istCardFileName) {
		_istCardFileName = istCardFileName;
	}

	public String getCarFrontFileName() {
		return _carFrontFileName;
	}

	public void setCarFrontFileName(String carFrontFileName) {
		_carFrontFileName = carFrontFileName;
	}

	public String getCarBackFileName() {
		return _carBackFileName;
	}

	public void setCarBackFileName(String carBackFileName) {
		_carBackFileName = carBackFileName;
	}

	public String getCarLeftFileName() {
		return _carLeftFileName;
	}

	public void setCarLeftFileName(String carLeftFileName) {
		_carLeftFileName = carLeftFileName;
	}

	public String getCarRightFileName() {
		return _carRightFileName;
	}

	public void setCarRightFileName(String carRightFileName) {
		_carRightFileName = carRightFileName;
	}

	public String getEngChassisNoFileName() {
		return _engChassisNoFileName;
	}

	public void setEngChassisNoFileName(String engChassisNoFileName) {
		_engChassisNoFileName = engChassisNoFileName;
	}

	public String getLeaseFileName() {
		return _leaseFileName;
	}

	public void setLeaseFileName(String leaseFileName) {
		_leaseFileName = leaseFileName;
	}

	private long _id;
	private String _quotId;
	private Blob _idFile;
	private Blob _licenseFile;
	private Blob _istCardFile;
	private Blob _carFrontFile;
	private Blob _carBackFile;
	private Blob _carLeftFile;
	private Blob _carRightFile;
	private Blob _engChassisNoFile;
	private Blob _leaseFile;
	private String _idFileName;
	private String _licenseFileName;
	private String _istCardFileName;
	private String _carFrontFileName;
	private String _carBackFileName;
	private String _carLeftFileName;
	private String _carRightFileName;
	private String _engChassisNoFileName;
	private String _leaseFileName;

}