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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.CLMNajmUploadsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CLMNajmUploadsSoap implements Serializable {

	public static CLMNajmUploadsSoap toSoapModel(CLMNajmUploads model) {
		CLMNajmUploadsSoap soapModel = new CLMNajmUploadsSoap();

		soapModel.setId(model.getId());
		soapModel.setCaseNo(model.getCaseNo());
		soapModel.setCipiId(model.getCipiId());
		soapModel.setNajmSlip(model.getNajmSlip());
		soapModel.setNajmSlipName(model.getNajmSlipName());
		soapModel.setDamageEstQuot(model.getDamageEstQuot());
		soapModel.setDamageEstQuotName(model.getDamageEstQuotName());
		soapModel.setBankIban(model.getBankIban());
		soapModel.setBankIbanName(model.getBankIbanName());
		soapModel.setOwnerId(model.getOwnerId());
		soapModel.setOwnerIdName(model.getOwnerIdName());
		soapModel.setClaimRefNo(model.getClaimRefNo());

		return soapModel;
	}

	public static CLMNajmUploadsSoap[] toSoapModels(CLMNajmUploads[] models) {
		CLMNajmUploadsSoap[] soapModels = new CLMNajmUploadsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CLMNajmUploadsSoap[][] toSoapModels(
		CLMNajmUploads[][] models) {

		CLMNajmUploadsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CLMNajmUploadsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CLMNajmUploadsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CLMNajmUploadsSoap[] toSoapModels(
		List<CLMNajmUploads> models) {

		List<CLMNajmUploadsSoap> soapModels = new ArrayList<CLMNajmUploadsSoap>(
			models.size());

		for (CLMNajmUploads model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CLMNajmUploadsSoap[soapModels.size()]);
	}

	public CLMNajmUploadsSoap() {
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

	public String getCaseNo() {
		return _caseNo;
	}

	public void setCaseNo(String caseNo) {
		_caseNo = caseNo;
	}

	public String getCipiId() {
		return _cipiId;
	}

	public void setCipiId(String cipiId) {
		_cipiId = cipiId;
	}

	public Blob getNajmSlip() {
		return _najmSlip;
	}

	public void setNajmSlip(Blob najmSlip) {
		_najmSlip = najmSlip;
	}

	public String getNajmSlipName() {
		return _najmSlipName;
	}

	public void setNajmSlipName(String najmSlipName) {
		_najmSlipName = najmSlipName;
	}

	public Blob getDamageEstQuot() {
		return _damageEstQuot;
	}

	public void setDamageEstQuot(Blob damageEstQuot) {
		_damageEstQuot = damageEstQuot;
	}

	public String getDamageEstQuotName() {
		return _damageEstQuotName;
	}

	public void setDamageEstQuotName(String damageEstQuotName) {
		_damageEstQuotName = damageEstQuotName;
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

	public String getClaimRefNo() {
		return _claimRefNo;
	}

	public void setClaimRefNo(String claimRefNo) {
		_claimRefNo = claimRefNo;
	}

	private int _id;
	private String _caseNo;
	private String _cipiId;
	private Blob _najmSlip;
	private String _najmSlipName;
	private Blob _damageEstQuot;
	private String _damageEstQuotName;
	private Blob _bankIban;
	private String _bankIbanName;
	private Blob _ownerId;
	private String _ownerIdName;
	private String _claimRefNo;

}