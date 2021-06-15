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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.FundDetailsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class FundDetailsSoap implements Serializable {

	public static FundDetailsSoap toSoapModel(FundDetails model) {
		FundDetailsSoap soapModel = new FundDetailsSoap();

		soapModel.setPolicyNo(model.getPolicyNo());
		soapModel.setFundName(model.getFundName());
		soapModel.setFundDesc(model.getFundDesc());
		soapModel.setFundPctg(model.getFundPctg());
		soapModel.setUnitsSum(model.getUnitsSum());
		soapModel.setUnitPrice(model.getUnitPrice());
		soapModel.setFundsValue(model.getFundsValue());
		soapModel.setRiskChg(model.getRiskChg());
		soapModel.setPartFees(model.getPartFees());

		return soapModel;
	}

	public static FundDetailsSoap[] toSoapModels(FundDetails[] models) {
		FundDetailsSoap[] soapModels = new FundDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FundDetailsSoap[][] toSoapModels(FundDetails[][] models) {
		FundDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FundDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FundDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FundDetailsSoap[] toSoapModels(List<FundDetails> models) {
		List<FundDetailsSoap> soapModels = new ArrayList<FundDetailsSoap>(
			models.size());

		for (FundDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FundDetailsSoap[soapModels.size()]);
	}

	public FundDetailsSoap() {
	}

	public String getPrimaryKey() {
		return _fundName;
	}

	public void setPrimaryKey(String pk) {
		setFundName(pk);
	}

	public String getPolicyNo() {
		return _policyNo;
	}

	public void setPolicyNo(String policyNo) {
		_policyNo = policyNo;
	}

	public String getFundName() {
		return _fundName;
	}

	public void setFundName(String fundName) {
		_fundName = fundName;
	}

	public String getFundDesc() {
		return _fundDesc;
	}

	public void setFundDesc(String fundDesc) {
		_fundDesc = fundDesc;
	}

	public String getFundPctg() {
		return _fundPctg;
	}

	public void setFundPctg(String fundPctg) {
		_fundPctg = fundPctg;
	}

	public double getUnitsSum() {
		return _unitsSum;
	}

	public void setUnitsSum(double unitsSum) {
		_unitsSum = unitsSum;
	}

	public double getUnitPrice() {
		return _unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		_unitPrice = unitPrice;
	}

	public double getFundsValue() {
		return _fundsValue;
	}

	public void setFundsValue(double fundsValue) {
		_fundsValue = fundsValue;
	}

	public double getRiskChg() {
		return _riskChg;
	}

	public void setRiskChg(double riskChg) {
		_riskChg = riskChg;
	}

	public double getPartFees() {
		return _partFees;
	}

	public void setPartFees(double partFees) {
		_partFees = partFees;
	}

	private String _policyNo;
	private String _fundName;
	private String _fundDesc;
	private String _fundPctg;
	private double _unitsSum;
	private double _unitPrice;
	private double _fundsValue;
	private double _riskChg;
	private double _partFees;

}