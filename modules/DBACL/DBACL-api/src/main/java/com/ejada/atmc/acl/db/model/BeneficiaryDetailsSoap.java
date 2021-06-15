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

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.BeneficiaryDetailsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class BeneficiaryDetailsSoap implements Serializable {

	public static BeneficiaryDetailsSoap toSoapModel(BeneficiaryDetails model) {
		BeneficiaryDetailsSoap soapModel = new BeneficiaryDetailsSoap();

		soapModel.setPolicyNo(model.getPolicyNo());
		soapModel.setBenfName(model.getBenfName());
		soapModel.setBenfPct(model.getBenfPct());
		soapModel.setBenfRel(model.getBenfRel());
		soapModel.setBenfId(model.getBenfId());
		soapModel.setBenfAge(model.getBenfAge());
		soapModel.setBenfType(model.getBenfType());

		return soapModel;
	}

	public static BeneficiaryDetailsSoap[] toSoapModels(
		BeneficiaryDetails[] models) {

		BeneficiaryDetailsSoap[] soapModels =
			new BeneficiaryDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BeneficiaryDetailsSoap[][] toSoapModels(
		BeneficiaryDetails[][] models) {

		BeneficiaryDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new BeneficiaryDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BeneficiaryDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BeneficiaryDetailsSoap[] toSoapModels(
		List<BeneficiaryDetails> models) {

		List<BeneficiaryDetailsSoap> soapModels =
			new ArrayList<BeneficiaryDetailsSoap>(models.size());

		for (BeneficiaryDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new BeneficiaryDetailsSoap[soapModels.size()]);
	}

	public BeneficiaryDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _benfId;
	}

	public void setPrimaryKey(long pk) {
		setBenfId(pk);
	}

	public String getPolicyNo() {
		return _policyNo;
	}

	public void setPolicyNo(String policyNo) {
		_policyNo = policyNo;
	}

	public String getBenfName() {
		return _benfName;
	}

	public void setBenfName(String benfName) {
		_benfName = benfName;
	}

	public String getBenfPct() {
		return _benfPct;
	}

	public void setBenfPct(String benfPct) {
		_benfPct = benfPct;
	}

	public String getBenfRel() {
		return _benfRel;
	}

	public void setBenfRel(String benfRel) {
		_benfRel = benfRel;
	}

	public long getBenfId() {
		return _benfId;
	}

	public void setBenfId(long benfId) {
		_benfId = benfId;
	}

	public String getBenfAge() {
		return _benfAge;
	}

	public void setBenfAge(String benfAge) {
		_benfAge = benfAge;
	}

	public String getBenfType() {
		return _benfType;
	}

	public void setBenfType(String benfType) {
		_benfType = benfType;
	}

	private String _policyNo;
	private String _benfName;
	private String _benfPct;
	private String _benfRel;
	private long _benfId;
	private String _benfAge;
	private String _benfType;

}