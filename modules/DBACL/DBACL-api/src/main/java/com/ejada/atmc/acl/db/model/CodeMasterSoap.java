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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.CodeMasterServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CodeMasterSoap implements Serializable {

	public static CodeMasterSoap toSoapModel(CodeMaster model) {
		CodeMasterSoap soapModel = new CodeMasterSoap();

		soapModel.setSystemId(model.getSystemId());
		soapModel.setEffFromDate(model.getEffFromDate());
		soapModel.setEffToDate(model.getEffToDate());
		soapModel.setCreationDate(model.getCreationDate());
		soapModel.setCrUid(model.getCrUid());
		soapModel.setUpdateDate(model.getUpdateDate());
		soapModel.setUpdateUid(model.getUpdateUid());
		soapModel.setCode(model.getCode());
		soapModel.setCodeSub(model.getCodeSub());
		soapModel.setCodeDesc(model.getCodeDesc());
		soapModel.setCodeDescAr(model.getCodeDescAr());
		soapModel.setCodeValue0(model.getCodeValue0());
		soapModel.setCodeValue1(model.getCodeValue1());
		soapModel.setCodeValue2(model.getCodeValue2());
		soapModel.setCodeRef(model.getCodeRef());
		soapModel.setCodeSubRef(model.getCodeSubRef());
		soapModel.setCodeFreezYN(model.getCodeFreezYN());

		return soapModel;
	}

	public static CodeMasterSoap[] toSoapModels(CodeMaster[] models) {
		CodeMasterSoap[] soapModels = new CodeMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CodeMasterSoap[][] toSoapModels(CodeMaster[][] models) {
		CodeMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CodeMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CodeMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CodeMasterSoap[] toSoapModels(List<CodeMaster> models) {
		List<CodeMasterSoap> soapModels = new ArrayList<CodeMasterSoap>(
			models.size());

		for (CodeMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CodeMasterSoap[soapModels.size()]);
	}

	public CodeMasterSoap() {
	}

	public long getPrimaryKey() {
		return _systemId;
	}

	public void setPrimaryKey(long pk) {
		setSystemId(pk);
	}

	public long getSystemId() {
		return _systemId;
	}

	public void setSystemId(long systemId) {
		_systemId = systemId;
	}

	public Date getEffFromDate() {
		return _effFromDate;
	}

	public void setEffFromDate(Date effFromDate) {
		_effFromDate = effFromDate;
	}

	public Date getEffToDate() {
		return _effToDate;
	}

	public void setEffToDate(Date effToDate) {
		_effToDate = effToDate;
	}

	public Date getCreationDate() {
		return _creationDate;
	}

	public void setCreationDate(Date creationDate) {
		_creationDate = creationDate;
	}

	public String getCrUid() {
		return _crUid;
	}

	public void setCrUid(String crUid) {
		_crUid = crUid;
	}

	public String getUpdateDate() {
		return _updateDate;
	}

	public void setUpdateDate(String updateDate) {
		_updateDate = updateDate;
	}

	public long getUpdateUid() {
		return _updateUid;
	}

	public void setUpdateUid(long updateUid) {
		_updateUid = updateUid;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getCodeSub() {
		return _codeSub;
	}

	public void setCodeSub(String codeSub) {
		_codeSub = codeSub;
	}

	public String getCodeDesc() {
		return _codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		_codeDesc = codeDesc;
	}

	public String getCodeDescAr() {
		return _codeDescAr;
	}

	public void setCodeDescAr(String codeDescAr) {
		_codeDescAr = codeDescAr;
	}

	public String getCodeValue0() {
		return _codeValue0;
	}

	public void setCodeValue0(String codeValue0) {
		_codeValue0 = codeValue0;
	}

	public String getCodeValue1() {
		return _codeValue1;
	}

	public void setCodeValue1(String codeValue1) {
		_codeValue1 = codeValue1;
	}

	public String getCodeValue2() {
		return _codeValue2;
	}

	public void setCodeValue2(String codeValue2) {
		_codeValue2 = codeValue2;
	}

	public String getCodeRef() {
		return _codeRef;
	}

	public void setCodeRef(String codeRef) {
		_codeRef = codeRef;
	}

	public String getCodeSubRef() {
		return _codeSubRef;
	}

	public void setCodeSubRef(String codeSubRef) {
		_codeSubRef = codeSubRef;
	}

	public String getCodeFreezYN() {
		return _codeFreezYN;
	}

	public void setCodeFreezYN(String codeFreezYN) {
		_codeFreezYN = codeFreezYN;
	}

	private long _systemId;
	private Date _effFromDate;
	private Date _effToDate;
	private Date _creationDate;
	private String _crUid;
	private String _updateDate;
	private long _updateUid;
	private String _code;
	private String _codeSub;
	private String _codeDesc;
	private String _codeDescAr;
	private String _codeValue0;
	private String _codeValue1;
	private String _codeValue2;
	private String _codeRef;
	private String _codeSubRef;
	private String _codeFreezYN;

}