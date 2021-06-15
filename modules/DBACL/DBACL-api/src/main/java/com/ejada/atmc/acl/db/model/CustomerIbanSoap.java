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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.CustomerIbanServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CustomerIbanSoap implements Serializable {

	public static CustomerIbanSoap toSoapModel(CustomerIban model) {
		CustomerIbanSoap soapModel = new CustomerIbanSoap();

		soapModel.setId(model.getId());
		soapModel.setRefCode(model.getRefCode());
		soapModel.setPremiaCCode(model.getPremiaCCode());
		soapModel.setIban(model.getIban());

		return soapModel;
	}

	public static CustomerIbanSoap[] toSoapModels(CustomerIban[] models) {
		CustomerIbanSoap[] soapModels = new CustomerIbanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CustomerIbanSoap[][] toSoapModels(CustomerIban[][] models) {
		CustomerIbanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CustomerIbanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CustomerIbanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CustomerIbanSoap[] toSoapModels(List<CustomerIban> models) {
		List<CustomerIbanSoap> soapModels = new ArrayList<CustomerIbanSoap>(
			models.size());

		for (CustomerIban model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CustomerIbanSoap[soapModels.size()]);
	}

	public CustomerIbanSoap() {
	}

	public String getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(String pk) {
		setId(pk);
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		_id = id;
	}

	public String getRefCode() {
		return _refCode;
	}

	public void setRefCode(String refCode) {
		_refCode = refCode;
	}

	public String getPremiaCCode() {
		return _premiaCCode;
	}

	public void setPremiaCCode(String premiaCCode) {
		_premiaCCode = premiaCCode;
	}

	public String getIban() {
		return _iban;
	}

	public void setIban(String iban) {
		_iban = iban;
	}

	private String _id;
	private String _refCode;
	private String _premiaCCode;
	private String _iban;

}