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

import com.ejada.atmc.acl.db.service.persistence.PolicyPaymentPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.PolicyPaymentServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PolicyPaymentSoap implements Serializable {

	public static PolicyPaymentSoap toSoapModel(PolicyPayment model) {
		PolicyPaymentSoap soapModel = new PolicyPaymentSoap();

		soapModel.setPolicyNo(model.getPolicyNo());
		soapModel.setVoucherNo(model.getVoucherNo());
		soapModel.setEndtNo(model.getEndtNo());
		soapModel.setClaimNo(model.getClaimNo());
		soapModel.setDueDate(model.getDueDate());
		soapModel.setDocDate(model.getDocDate());
		soapModel.setAmount(model.getAmount());
		soapModel.setReference(model.getReference());

		return soapModel;
	}

	public static PolicyPaymentSoap[] toSoapModels(PolicyPayment[] models) {
		PolicyPaymentSoap[] soapModels = new PolicyPaymentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PolicyPaymentSoap[][] toSoapModels(PolicyPayment[][] models) {
		PolicyPaymentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PolicyPaymentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PolicyPaymentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PolicyPaymentSoap[] toSoapModels(List<PolicyPayment> models) {
		List<PolicyPaymentSoap> soapModels = new ArrayList<PolicyPaymentSoap>(
			models.size());

		for (PolicyPayment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PolicyPaymentSoap[soapModels.size()]);
	}

	public PolicyPaymentSoap() {
	}

	public PolicyPaymentPK getPrimaryKey() {
		return new PolicyPaymentPK(_policyNo, _voucherNo);
	}

	public void setPrimaryKey(PolicyPaymentPK pk) {
		setPolicyNo(pk.policyNo);
		setVoucherNo(pk.voucherNo);
	}

	public String getPolicyNo() {
		return _policyNo;
	}

	public void setPolicyNo(String policyNo) {
		_policyNo = policyNo;
	}

	public String getVoucherNo() {
		return _voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		_voucherNo = voucherNo;
	}

	public String getEndtNo() {
		return _endtNo;
	}

	public void setEndtNo(String endtNo) {
		_endtNo = endtNo;
	}

	public String getClaimNo() {
		return _claimNo;
	}

	public void setClaimNo(String claimNo) {
		_claimNo = claimNo;
	}

	public Date getDueDate() {
		return _dueDate;
	}

	public void setDueDate(Date dueDate) {
		_dueDate = dueDate;
	}

	public Date getDocDate() {
		return _docDate;
	}

	public void setDocDate(Date docDate) {
		_docDate = docDate;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public String getReference() {
		return _reference;
	}

	public void setReference(String reference) {
		_reference = reference;
	}

	private String _policyNo;
	private String _voucherNo;
	private String _endtNo;
	private String _claimNo;
	private Date _dueDate;
	private Date _docDate;
	private double _amount;
	private String _reference;

}