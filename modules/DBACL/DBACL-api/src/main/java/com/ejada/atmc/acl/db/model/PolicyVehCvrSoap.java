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

import com.ejada.atmc.acl.db.service.persistence.PolicyVehCvrPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.PolicyVehCvrServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PolicyVehCvrSoap implements Serializable {

	public static PolicyVehCvrSoap toSoapModel(PolicyVehCvr model) {
		PolicyVehCvrSoap soapModel = new PolicyVehCvrSoap();

		soapModel.setPolicyNo(model.getPolicyNo());
		soapModel.setVehId(model.getVehId());
		soapModel.setCvrCode(model.getCvrCode());
		soapModel.setDescription(model.getDescription());
		soapModel.setCvrType(model.getCvrType());
		soapModel.setBenefitTerm(model.getBenefitTerm());
		soapModel.setPremiumTerm(model.getPremiumTerm());
		soapModel.setPremium(model.getPremium());
		soapModel.setSumCovered(model.getSumCovered());

		return soapModel;
	}

	public static PolicyVehCvrSoap[] toSoapModels(PolicyVehCvr[] models) {
		PolicyVehCvrSoap[] soapModels = new PolicyVehCvrSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PolicyVehCvrSoap[][] toSoapModels(PolicyVehCvr[][] models) {
		PolicyVehCvrSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PolicyVehCvrSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PolicyVehCvrSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PolicyVehCvrSoap[] toSoapModels(List<PolicyVehCvr> models) {
		List<PolicyVehCvrSoap> soapModels = new ArrayList<PolicyVehCvrSoap>(
			models.size());

		for (PolicyVehCvr model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PolicyVehCvrSoap[soapModels.size()]);
	}

	public PolicyVehCvrSoap() {
	}

	public PolicyVehCvrPK getPrimaryKey() {
		return new PolicyVehCvrPK(_policyNo, _vehId, _description);
	}

	public void setPrimaryKey(PolicyVehCvrPK pk) {
		setPolicyNo(pk.policyNo);
		setVehId(pk.vehId);
		setDescription(pk.description);
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

	public String getCvrCode() {
		return _cvrCode;
	}

	public void setCvrCode(String cvrCode) {
		_cvrCode = cvrCode;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getCvrType() {
		return _cvrType;
	}

	public void setCvrType(String cvrType) {
		_cvrType = cvrType;
	}

	public String getBenefitTerm() {
		return _benefitTerm;
	}

	public void setBenefitTerm(String benefitTerm) {
		_benefitTerm = benefitTerm;
	}

	public String getPremiumTerm() {
		return _premiumTerm;
	}

	public void setPremiumTerm(String premiumTerm) {
		_premiumTerm = premiumTerm;
	}

	public long getPremium() {
		return _premium;
	}

	public void setPremium(long premium) {
		_premium = premium;
	}

	public long getSumCovered() {
		return _sumCovered;
	}

	public void setSumCovered(long sumCovered) {
		_sumCovered = sumCovered;
	}

	private String _policyNo;
	private String _vehId;
	private String _cvrCode;
	private String _description;
	private String _cvrType;
	private String _benefitTerm;
	private String _premiumTerm;
	private long _premium;
	private long _sumCovered;

}