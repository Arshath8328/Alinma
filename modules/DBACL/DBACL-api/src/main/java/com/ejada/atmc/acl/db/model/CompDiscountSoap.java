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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.CompDiscountServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CompDiscountSoap implements Serializable {

	public static CompDiscountSoap toSoapModel(CompDiscount model) {
		CompDiscountSoap soapModel = new CompDiscountSoap();

		soapModel.setIqamaId(model.getIqamaId());
		soapModel.setSchemeCode(model.getSchemeCode());
		soapModel.setCompanyCode(model.getCompanyCode());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());

		return soapModel;
	}

	public static CompDiscountSoap[] toSoapModels(CompDiscount[] models) {
		CompDiscountSoap[] soapModels = new CompDiscountSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CompDiscountSoap[][] toSoapModels(CompDiscount[][] models) {
		CompDiscountSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CompDiscountSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CompDiscountSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CompDiscountSoap[] toSoapModels(List<CompDiscount> models) {
		List<CompDiscountSoap> soapModels = new ArrayList<CompDiscountSoap>(
			models.size());

		for (CompDiscount model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CompDiscountSoap[soapModels.size()]);
	}

	public CompDiscountSoap() {
	}

	public String getPrimaryKey() {
		return _iqamaId;
	}

	public void setPrimaryKey(String pk) {
		setIqamaId(pk);
	}

	public String getIqamaId() {
		return _iqamaId;
	}

	public void setIqamaId(String iqamaId) {
		_iqamaId = iqamaId;
	}

	public String getSchemeCode() {
		return _schemeCode;
	}

	public void setSchemeCode(String schemeCode) {
		_schemeCode = schemeCode;
	}

	public String getCompanyCode() {
		return _companyCode;
	}

	public void setCompanyCode(String companyCode) {
		_companyCode = companyCode;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	private String _iqamaId;
	private String _schemeCode;
	private String _companyCode;
	private Date _startDate;
	private Date _endDate;

}