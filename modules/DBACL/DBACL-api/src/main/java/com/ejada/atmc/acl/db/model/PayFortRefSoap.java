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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.PayFortRefServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PayFortRefSoap implements Serializable {

	public static PayFortRefSoap toSoapModel(PayFortRef model) {
		PayFortRefSoap soapModel = new PayFortRefSoap();

		soapModel.setId(model.getId());
		soapModel.setIqama_id(model.getIqama_id());
		soapModel.setPayFortRefNo(model.getPayFortRefNo());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static PayFortRefSoap[] toSoapModels(PayFortRef[] models) {
		PayFortRefSoap[] soapModels = new PayFortRefSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PayFortRefSoap[][] toSoapModels(PayFortRef[][] models) {
		PayFortRefSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PayFortRefSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PayFortRefSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PayFortRefSoap[] toSoapModels(List<PayFortRef> models) {
		List<PayFortRefSoap> soapModels = new ArrayList<PayFortRefSoap>(
			models.size());

		for (PayFortRef model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PayFortRefSoap[soapModels.size()]);
	}

	public PayFortRefSoap() {
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

	public String getIqama_id() {
		return _iqama_id;
	}

	public void setIqama_id(String iqama_id) {
		_iqama_id = iqama_id;
	}

	public String getPayFortRefNo() {
		return _payFortRefNo;
	}

	public void setPayFortRefNo(String payFortRefNo) {
		_payFortRefNo = payFortRefNo;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	private int _id;
	private String _iqama_id;
	private String _payFortRefNo;
	private String _status;

}