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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.PolicyCancelationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PolicyCancelationSoap implements Serializable {

	public static PolicyCancelationSoap toSoapModel(PolicyCancelation model) {
		PolicyCancelationSoap soapModel = new PolicyCancelationSoap();

		soapModel.setId(model.getId());
		soapModel.setPolicyNumber(model.getPolicyNumber());
		soapModel.setPolicyExpiryDate(model.getPolicyExpiryDate());
		soapModel.setInsuredId(model.getInsuredId());
		soapModel.setInsuredName(model.getInsuredName());
		soapModel.setVehicleSequence(model.getVehicleSequence());
		soapModel.setVehicleChessisNo(model.getVehicleChessisNo());
		soapModel.setStatus(model.getStatus());
		soapModel.setCancllationReqDate(model.getCancllationReqDate());
		soapModel.setReason(model.getReason());
		soapModel.setServicemessage(model.getServicemessage());
		soapModel.setCancellationEffdate(model.getCancellationEffdate());
		soapModel.setIbanImage(model.getIbanImage());
		soapModel.setValidFile(model.getValidFile());
		soapModel.setOtherFile(model.getOtherFile());
		soapModel.setVehMake(model.getVehMake());
		soapModel.setVehModel(model.getVehModel());
		soapModel.setPlateNumber(model.getPlateNumber());
		soapModel.setAnyAccident(model.getAnyAccident());
		soapModel.setLodgeClaim(model.getLodgeClaim());
		soapModel.setIbanFileName(model.getIbanFileName());
		soapModel.setValidFileName(model.getValidFileName());
		soapModel.setPolicyInceptionDate(model.getPolicyInceptionDate());
		soapModel.setInsuredEmail(model.getInsuredEmail());
		soapModel.setInsuredMobile(model.getInsuredMobile());
		soapModel.setRejReason(model.getRejReason());

		return soapModel;
	}

	public static PolicyCancelationSoap[] toSoapModels(
		PolicyCancelation[] models) {

		PolicyCancelationSoap[] soapModels =
			new PolicyCancelationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PolicyCancelationSoap[][] toSoapModels(
		PolicyCancelation[][] models) {

		PolicyCancelationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PolicyCancelationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PolicyCancelationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PolicyCancelationSoap[] toSoapModels(
		List<PolicyCancelation> models) {

		List<PolicyCancelationSoap> soapModels =
			new ArrayList<PolicyCancelationSoap>(models.size());

		for (PolicyCancelation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PolicyCancelationSoap[soapModels.size()]);
	}

	public PolicyCancelationSoap() {
	}

	public String getPrimaryKey() {
		return _Id;
	}

	public void setPrimaryKey(String pk) {
		setId(pk);
	}

	public String getId() {
		return _Id;
	}

	public void setId(String Id) {
		_Id = Id;
	}

	public String getPolicyNumber() {
		return _policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		_policyNumber = policyNumber;
	}

	public Date getPolicyExpiryDate() {
		return _policyExpiryDate;
	}

	public void setPolicyExpiryDate(Date policyExpiryDate) {
		_policyExpiryDate = policyExpiryDate;
	}

	public String getInsuredId() {
		return _insuredId;
	}

	public void setInsuredId(String insuredId) {
		_insuredId = insuredId;
	}

	public String getInsuredName() {
		return _insuredName;
	}

	public void setInsuredName(String insuredName) {
		_insuredName = insuredName;
	}

	public String getVehicleSequence() {
		return _vehicleSequence;
	}

	public void setVehicleSequence(String vehicleSequence) {
		_vehicleSequence = vehicleSequence;
	}

	public String getVehicleChessisNo() {
		return _vehicleChessisNo;
	}

	public void setVehicleChessisNo(String vehicleChessisNo) {
		_vehicleChessisNo = vehicleChessisNo;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public Date getCancllationReqDate() {
		return _cancllationReqDate;
	}

	public void setCancllationReqDate(Date cancllationReqDate) {
		_cancllationReqDate = cancllationReqDate;
	}

	public String getReason() {
		return _reason;
	}

	public void setReason(String reason) {
		_reason = reason;
	}

	public String getServicemessage() {
		return _servicemessage;
	}

	public void setServicemessage(String servicemessage) {
		_servicemessage = servicemessage;
	}

	public Date getCancellationEffdate() {
		return _cancellationEffdate;
	}

	public void setCancellationEffdate(Date cancellationEffdate) {
		_cancellationEffdate = cancellationEffdate;
	}

	public Blob getIbanImage() {
		return _ibanImage;
	}

	public void setIbanImage(Blob ibanImage) {
		_ibanImage = ibanImage;
	}

	public Blob getValidFile() {
		return _validFile;
	}

	public void setValidFile(Blob validFile) {
		_validFile = validFile;
	}

	public Blob getOtherFile() {
		return _otherFile;
	}

	public void setOtherFile(Blob otherFile) {
		_otherFile = otherFile;
	}

	public String getVehMake() {
		return _vehMake;
	}

	public void setVehMake(String vehMake) {
		_vehMake = vehMake;
	}

	public String getVehModel() {
		return _vehModel;
	}

	public void setVehModel(String vehModel) {
		_vehModel = vehModel;
	}

	public String getPlateNumber() {
		return _plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		_plateNumber = plateNumber;
	}

	public String getAnyAccident() {
		return _anyAccident;
	}

	public void setAnyAccident(String anyAccident) {
		_anyAccident = anyAccident;
	}

	public String getLodgeClaim() {
		return _lodgeClaim;
	}

	public void setLodgeClaim(String lodgeClaim) {
		_lodgeClaim = lodgeClaim;
	}

	public String getIbanFileName() {
		return _ibanFileName;
	}

	public void setIbanFileName(String ibanFileName) {
		_ibanFileName = ibanFileName;
	}

	public String getValidFileName() {
		return _validFileName;
	}

	public void setValidFileName(String validFileName) {
		_validFileName = validFileName;
	}

	public Date getPolicyInceptionDate() {
		return _policyInceptionDate;
	}

	public void setPolicyInceptionDate(Date policyInceptionDate) {
		_policyInceptionDate = policyInceptionDate;
	}

	public String getInsuredEmail() {
		return _insuredEmail;
	}

	public void setInsuredEmail(String insuredEmail) {
		_insuredEmail = insuredEmail;
	}

	public String getInsuredMobile() {
		return _insuredMobile;
	}

	public void setInsuredMobile(String insuredMobile) {
		_insuredMobile = insuredMobile;
	}

	public String getRejReason() {
		return _rejReason;
	}

	public void setRejReason(String rejReason) {
		_rejReason = rejReason;
	}

	private String _Id;
	private String _policyNumber;
	private Date _policyExpiryDate;
	private String _insuredId;
	private String _insuredName;
	private String _vehicleSequence;
	private String _vehicleChessisNo;
	private String _status;
	private Date _cancllationReqDate;
	private String _reason;
	private String _servicemessage;
	private Date _cancellationEffdate;
	private Blob _ibanImage;
	private Blob _validFile;
	private Blob _otherFile;
	private String _vehMake;
	private String _vehModel;
	private String _plateNumber;
	private String _anyAccident;
	private String _lodgeClaim;
	private String _ibanFileName;
	private String _validFileName;
	private Date _policyInceptionDate;
	private String _insuredEmail;
	private String _insuredMobile;
	private String _rejReason;

}