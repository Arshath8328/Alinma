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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.CLMSTATUSServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CLMSTATUSSoap implements Serializable {

	public static CLMSTATUSSoap toSoapModel(CLMSTATUS model) {
		CLMSTATUSSoap soapModel = new CLMSTATUSSoap();

		soapModel.setRefNo(model.getRefNo());
		soapModel.setClaimStatus(model.getClaimStatus());

		return soapModel;
	}

	public static CLMSTATUSSoap[] toSoapModels(CLMSTATUS[] models) {
		CLMSTATUSSoap[] soapModels = new CLMSTATUSSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CLMSTATUSSoap[][] toSoapModels(CLMSTATUS[][] models) {
		CLMSTATUSSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CLMSTATUSSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CLMSTATUSSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CLMSTATUSSoap[] toSoapModels(List<CLMSTATUS> models) {
		List<CLMSTATUSSoap> soapModels = new ArrayList<CLMSTATUSSoap>(
			models.size());

		for (CLMSTATUS model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CLMSTATUSSoap[soapModels.size()]);
	}

	public CLMSTATUSSoap() {
	}

	public String getPrimaryKey() {
		return _RefNo;
	}

	public void setPrimaryKey(String pk) {
		setRefNo(pk);
	}

	public String getRefNo() {
		return _RefNo;
	}

	public void setRefNo(String RefNo) {
		_RefNo = RefNo;
	}

	public String getClaimStatus() {
		return _claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		_claimStatus = claimStatus;
	}

	private String _RefNo;
	private String _claimStatus;

}