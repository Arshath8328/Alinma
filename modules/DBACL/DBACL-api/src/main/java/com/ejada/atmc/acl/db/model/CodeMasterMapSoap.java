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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.CodeMasterMapServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CodeMasterMapSoap implements Serializable {

	public static CodeMasterMapSoap toSoapModel(CodeMasterMap model) {
		CodeMasterMapSoap soapModel = new CodeMasterMapSoap();

		soapModel.setSource(model.getSource());
		soapModel.setType(model.getType());
		soapModel.setSourceType(model.getSourceType());
		soapModel.setSourceSystemId(model.getSourceSystemId());
		soapModel.setSourceCode(model.getSourceCode());
		soapModel.setSourceDesc(model.getSourceDesc());
		soapModel.setCoreType(model.getCoreType());
		soapModel.setCoreSystemId(model.getCoreSystemId());
		soapModel.setCoreCode(model.getCoreCode());
		soapModel.setCoreDesc(model.getCoreDesc());
		soapModel.setEffFromDate(model.getEffFromDate());
		soapModel.setEffToDate(model.getEffToDate());
		soapModel.setFreezeFlag(model.getFreezeFlag());
		soapModel.setLvl1Type(model.getLvl1Type());
		soapModel.setLvl1SysId(model.getLvl1SysId());
		soapModel.setLvl1Code(model.getLvl1Code());
		soapModel.setLvl1Desc(model.getLvl1Desc());
		soapModel.setLvl2Type(model.getLvl2Type());
		soapModel.setLvl2SysId(model.getLvl2SysId());
		soapModel.setLvl2Code(model.getLvl2Code());
		soapModel.setLvl2Desc(model.getLvl2Desc());

		return soapModel;
	}

	public static CodeMasterMapSoap[] toSoapModels(CodeMasterMap[] models) {
		CodeMasterMapSoap[] soapModels = new CodeMasterMapSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CodeMasterMapSoap[][] toSoapModels(CodeMasterMap[][] models) {
		CodeMasterMapSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CodeMasterMapSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CodeMasterMapSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CodeMasterMapSoap[] toSoapModels(List<CodeMasterMap> models) {
		List<CodeMasterMapSoap> soapModels = new ArrayList<CodeMasterMapSoap>(
			models.size());

		for (CodeMasterMap model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CodeMasterMapSoap[soapModels.size()]);
	}

	public CodeMasterMapSoap() {
	}

	public String getPrimaryKey() {
		return _source;
	}

	public void setPrimaryKey(String pk) {
		setSource(pk);
	}

	public String getSource() {
		return _source;
	}

	public void setSource(String source) {
		_source = source;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getSourceType() {
		return _sourceType;
	}

	public void setSourceType(String sourceType) {
		_sourceType = sourceType;
	}

	public String getSourceSystemId() {
		return _sourceSystemId;
	}

	public void setSourceSystemId(String sourceSystemId) {
		_sourceSystemId = sourceSystemId;
	}

	public String getSourceCode() {
		return _sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		_sourceCode = sourceCode;
	}

	public String getSourceDesc() {
		return _sourceDesc;
	}

	public void setSourceDesc(String sourceDesc) {
		_sourceDesc = sourceDesc;
	}

	public String getCoreType() {
		return _coreType;
	}

	public void setCoreType(String coreType) {
		_coreType = coreType;
	}

	public String getCoreSystemId() {
		return _coreSystemId;
	}

	public void setCoreSystemId(String coreSystemId) {
		_coreSystemId = coreSystemId;
	}

	public String getCoreCode() {
		return _coreCode;
	}

	public void setCoreCode(String coreCode) {
		_coreCode = coreCode;
	}

	public String getCoreDesc() {
		return _coreDesc;
	}

	public void setCoreDesc(String coreDesc) {
		_coreDesc = coreDesc;
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

	public String getFreezeFlag() {
		return _freezeFlag;
	}

	public void setFreezeFlag(String freezeFlag) {
		_freezeFlag = freezeFlag;
	}

	public String getLvl1Type() {
		return _lvl1Type;
	}

	public void setLvl1Type(String lvl1Type) {
		_lvl1Type = lvl1Type;
	}

	public String getLvl1SysId() {
		return _lvl1SysId;
	}

	public void setLvl1SysId(String lvl1SysId) {
		_lvl1SysId = lvl1SysId;
	}

	public String getLvl1Code() {
		return _lvl1Code;
	}

	public void setLvl1Code(String lvl1Code) {
		_lvl1Code = lvl1Code;
	}

	public String getLvl1Desc() {
		return _lvl1Desc;
	}

	public void setLvl1Desc(String lvl1Desc) {
		_lvl1Desc = lvl1Desc;
	}

	public String getLvl2Type() {
		return _lvl2Type;
	}

	public void setLvl2Type(String lvl2Type) {
		_lvl2Type = lvl2Type;
	}

	public String getLvl2SysId() {
		return _lvl2SysId;
	}

	public void setLvl2SysId(String lvl2SysId) {
		_lvl2SysId = lvl2SysId;
	}

	public String getLvl2Code() {
		return _lvl2Code;
	}

	public void setLvl2Code(String lvl2Code) {
		_lvl2Code = lvl2Code;
	}

	public String getLvl2Desc() {
		return _lvl2Desc;
	}

	public void setLvl2Desc(String lvl2Desc) {
		_lvl2Desc = lvl2Desc;
	}

	private String _source;
	private String _type;
	private String _sourceType;
	private String _sourceSystemId;
	private String _sourceCode;
	private String _sourceDesc;
	private String _coreType;
	private String _coreSystemId;
	private String _coreCode;
	private String _coreDesc;
	private Date _effFromDate;
	private Date _effToDate;
	private String _freezeFlag;
	private String _lvl1Type;
	private String _lvl1SysId;
	private String _lvl1Code;
	private String _lvl1Desc;
	private String _lvl2Type;
	private String _lvl2SysId;
	private String _lvl2Code;
	private String _lvl2Desc;

}