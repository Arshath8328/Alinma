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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CodeMasterMap}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CodeMasterMap
 * @generated
 */
public class CodeMasterMapWrapper
	extends BaseModelWrapper<CodeMasterMap>
	implements CodeMasterMap, ModelWrapper<CodeMasterMap> {

	public CodeMasterMapWrapper(CodeMasterMap codeMasterMap) {
		super(codeMasterMap);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("source", getSource());
		attributes.put("type", getType());
		attributes.put("sourceType", getSourceType());
		attributes.put("sourceSystemId", getSourceSystemId());
		attributes.put("sourceCode", getSourceCode());
		attributes.put("sourceDesc", getSourceDesc());
		attributes.put("coreType", getCoreType());
		attributes.put("coreSystemId", getCoreSystemId());
		attributes.put("coreCode", getCoreCode());
		attributes.put("coreDesc", getCoreDesc());
		attributes.put("effFromDate", getEffFromDate());
		attributes.put("effToDate", getEffToDate());
		attributes.put("freezeFlag", getFreezeFlag());
		attributes.put("lvl1Type", getLvl1Type());
		attributes.put("lvl1SysId", getLvl1SysId());
		attributes.put("lvl1Code", getLvl1Code());
		attributes.put("lvl1Desc", getLvl1Desc());
		attributes.put("lvl2Type", getLvl2Type());
		attributes.put("lvl2SysId", getLvl2SysId());
		attributes.put("lvl2Code", getLvl2Code());
		attributes.put("lvl2Desc", getLvl2Desc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String source = (String)attributes.get("source");

		if (source != null) {
			setSource(source);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String sourceType = (String)attributes.get("sourceType");

		if (sourceType != null) {
			setSourceType(sourceType);
		}

		String sourceSystemId = (String)attributes.get("sourceSystemId");

		if (sourceSystemId != null) {
			setSourceSystemId(sourceSystemId);
		}

		String sourceCode = (String)attributes.get("sourceCode");

		if (sourceCode != null) {
			setSourceCode(sourceCode);
		}

		String sourceDesc = (String)attributes.get("sourceDesc");

		if (sourceDesc != null) {
			setSourceDesc(sourceDesc);
		}

		String coreType = (String)attributes.get("coreType");

		if (coreType != null) {
			setCoreType(coreType);
		}

		String coreSystemId = (String)attributes.get("coreSystemId");

		if (coreSystemId != null) {
			setCoreSystemId(coreSystemId);
		}

		String coreCode = (String)attributes.get("coreCode");

		if (coreCode != null) {
			setCoreCode(coreCode);
		}

		String coreDesc = (String)attributes.get("coreDesc");

		if (coreDesc != null) {
			setCoreDesc(coreDesc);
		}

		Date effFromDate = (Date)attributes.get("effFromDate");

		if (effFromDate != null) {
			setEffFromDate(effFromDate);
		}

		Date effToDate = (Date)attributes.get("effToDate");

		if (effToDate != null) {
			setEffToDate(effToDate);
		}

		String freezeFlag = (String)attributes.get("freezeFlag");

		if (freezeFlag != null) {
			setFreezeFlag(freezeFlag);
		}

		String lvl1Type = (String)attributes.get("lvl1Type");

		if (lvl1Type != null) {
			setLvl1Type(lvl1Type);
		}

		String lvl1SysId = (String)attributes.get("lvl1SysId");

		if (lvl1SysId != null) {
			setLvl1SysId(lvl1SysId);
		}

		String lvl1Code = (String)attributes.get("lvl1Code");

		if (lvl1Code != null) {
			setLvl1Code(lvl1Code);
		}

		String lvl1Desc = (String)attributes.get("lvl1Desc");

		if (lvl1Desc != null) {
			setLvl1Desc(lvl1Desc);
		}

		String lvl2Type = (String)attributes.get("lvl2Type");

		if (lvl2Type != null) {
			setLvl2Type(lvl2Type);
		}

		String lvl2SysId = (String)attributes.get("lvl2SysId");

		if (lvl2SysId != null) {
			setLvl2SysId(lvl2SysId);
		}

		String lvl2Code = (String)attributes.get("lvl2Code");

		if (lvl2Code != null) {
			setLvl2Code(lvl2Code);
		}

		String lvl2Desc = (String)attributes.get("lvl2Desc");

		if (lvl2Desc != null) {
			setLvl2Desc(lvl2Desc);
		}
	}

	/**
	 * Returns the core code of this code master map.
	 *
	 * @return the core code of this code master map
	 */
	@Override
	public String getCoreCode() {
		return model.getCoreCode();
	}

	/**
	 * Returns the core desc of this code master map.
	 *
	 * @return the core desc of this code master map
	 */
	@Override
	public String getCoreDesc() {
		return model.getCoreDesc();
	}

	/**
	 * Returns the core system ID of this code master map.
	 *
	 * @return the core system ID of this code master map
	 */
	@Override
	public String getCoreSystemId() {
		return model.getCoreSystemId();
	}

	/**
	 * Returns the core type of this code master map.
	 *
	 * @return the core type of this code master map
	 */
	@Override
	public String getCoreType() {
		return model.getCoreType();
	}

	/**
	 * Returns the eff from date of this code master map.
	 *
	 * @return the eff from date of this code master map
	 */
	@Override
	public Date getEffFromDate() {
		return model.getEffFromDate();
	}

	/**
	 * Returns the eff to date of this code master map.
	 *
	 * @return the eff to date of this code master map
	 */
	@Override
	public Date getEffToDate() {
		return model.getEffToDate();
	}

	/**
	 * Returns the freeze flag of this code master map.
	 *
	 * @return the freeze flag of this code master map
	 */
	@Override
	public String getFreezeFlag() {
		return model.getFreezeFlag();
	}

	/**
	 * Returns the lvl1 code of this code master map.
	 *
	 * @return the lvl1 code of this code master map
	 */
	@Override
	public String getLvl1Code() {
		return model.getLvl1Code();
	}

	/**
	 * Returns the lvl1 desc of this code master map.
	 *
	 * @return the lvl1 desc of this code master map
	 */
	@Override
	public String getLvl1Desc() {
		return model.getLvl1Desc();
	}

	/**
	 * Returns the lvl1 sys ID of this code master map.
	 *
	 * @return the lvl1 sys ID of this code master map
	 */
	@Override
	public String getLvl1SysId() {
		return model.getLvl1SysId();
	}

	/**
	 * Returns the lvl1 type of this code master map.
	 *
	 * @return the lvl1 type of this code master map
	 */
	@Override
	public String getLvl1Type() {
		return model.getLvl1Type();
	}

	/**
	 * Returns the lvl2 code of this code master map.
	 *
	 * @return the lvl2 code of this code master map
	 */
	@Override
	public String getLvl2Code() {
		return model.getLvl2Code();
	}

	/**
	 * Returns the lvl2 desc of this code master map.
	 *
	 * @return the lvl2 desc of this code master map
	 */
	@Override
	public String getLvl2Desc() {
		return model.getLvl2Desc();
	}

	/**
	 * Returns the lvl2 sys ID of this code master map.
	 *
	 * @return the lvl2 sys ID of this code master map
	 */
	@Override
	public String getLvl2SysId() {
		return model.getLvl2SysId();
	}

	/**
	 * Returns the lvl2 type of this code master map.
	 *
	 * @return the lvl2 type of this code master map
	 */
	@Override
	public String getLvl2Type() {
		return model.getLvl2Type();
	}

	/**
	 * Returns the primary key of this code master map.
	 *
	 * @return the primary key of this code master map
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the source of this code master map.
	 *
	 * @return the source of this code master map
	 */
	@Override
	public String getSource() {
		return model.getSource();
	}

	/**
	 * Returns the source code of this code master map.
	 *
	 * @return the source code of this code master map
	 */
	@Override
	public String getSourceCode() {
		return model.getSourceCode();
	}

	/**
	 * Returns the source desc of this code master map.
	 *
	 * @return the source desc of this code master map
	 */
	@Override
	public String getSourceDesc() {
		return model.getSourceDesc();
	}

	/**
	 * Returns the source system ID of this code master map.
	 *
	 * @return the source system ID of this code master map
	 */
	@Override
	public String getSourceSystemId() {
		return model.getSourceSystemId();
	}

	/**
	 * Returns the source type of this code master map.
	 *
	 * @return the source type of this code master map
	 */
	@Override
	public String getSourceType() {
		return model.getSourceType();
	}

	/**
	 * Returns the type of this code master map.
	 *
	 * @return the type of this code master map
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the core code of this code master map.
	 *
	 * @param coreCode the core code of this code master map
	 */
	@Override
	public void setCoreCode(String coreCode) {
		model.setCoreCode(coreCode);
	}

	/**
	 * Sets the core desc of this code master map.
	 *
	 * @param coreDesc the core desc of this code master map
	 */
	@Override
	public void setCoreDesc(String coreDesc) {
		model.setCoreDesc(coreDesc);
	}

	/**
	 * Sets the core system ID of this code master map.
	 *
	 * @param coreSystemId the core system ID of this code master map
	 */
	@Override
	public void setCoreSystemId(String coreSystemId) {
		model.setCoreSystemId(coreSystemId);
	}

	/**
	 * Sets the core type of this code master map.
	 *
	 * @param coreType the core type of this code master map
	 */
	@Override
	public void setCoreType(String coreType) {
		model.setCoreType(coreType);
	}

	/**
	 * Sets the eff from date of this code master map.
	 *
	 * @param effFromDate the eff from date of this code master map
	 */
	@Override
	public void setEffFromDate(Date effFromDate) {
		model.setEffFromDate(effFromDate);
	}

	/**
	 * Sets the eff to date of this code master map.
	 *
	 * @param effToDate the eff to date of this code master map
	 */
	@Override
	public void setEffToDate(Date effToDate) {
		model.setEffToDate(effToDate);
	}

	/**
	 * Sets the freeze flag of this code master map.
	 *
	 * @param freezeFlag the freeze flag of this code master map
	 */
	@Override
	public void setFreezeFlag(String freezeFlag) {
		model.setFreezeFlag(freezeFlag);
	}

	/**
	 * Sets the lvl1 code of this code master map.
	 *
	 * @param lvl1Code the lvl1 code of this code master map
	 */
	@Override
	public void setLvl1Code(String lvl1Code) {
		model.setLvl1Code(lvl1Code);
	}

	/**
	 * Sets the lvl1 desc of this code master map.
	 *
	 * @param lvl1Desc the lvl1 desc of this code master map
	 */
	@Override
	public void setLvl1Desc(String lvl1Desc) {
		model.setLvl1Desc(lvl1Desc);
	}

	/**
	 * Sets the lvl1 sys ID of this code master map.
	 *
	 * @param lvl1SysId the lvl1 sys ID of this code master map
	 */
	@Override
	public void setLvl1SysId(String lvl1SysId) {
		model.setLvl1SysId(lvl1SysId);
	}

	/**
	 * Sets the lvl1 type of this code master map.
	 *
	 * @param lvl1Type the lvl1 type of this code master map
	 */
	@Override
	public void setLvl1Type(String lvl1Type) {
		model.setLvl1Type(lvl1Type);
	}

	/**
	 * Sets the lvl2 code of this code master map.
	 *
	 * @param lvl2Code the lvl2 code of this code master map
	 */
	@Override
	public void setLvl2Code(String lvl2Code) {
		model.setLvl2Code(lvl2Code);
	}

	/**
	 * Sets the lvl2 desc of this code master map.
	 *
	 * @param lvl2Desc the lvl2 desc of this code master map
	 */
	@Override
	public void setLvl2Desc(String lvl2Desc) {
		model.setLvl2Desc(lvl2Desc);
	}

	/**
	 * Sets the lvl2 sys ID of this code master map.
	 *
	 * @param lvl2SysId the lvl2 sys ID of this code master map
	 */
	@Override
	public void setLvl2SysId(String lvl2SysId) {
		model.setLvl2SysId(lvl2SysId);
	}

	/**
	 * Sets the lvl2 type of this code master map.
	 *
	 * @param lvl2Type the lvl2 type of this code master map
	 */
	@Override
	public void setLvl2Type(String lvl2Type) {
		model.setLvl2Type(lvl2Type);
	}

	/**
	 * Sets the primary key of this code master map.
	 *
	 * @param primaryKey the primary key of this code master map
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the source of this code master map.
	 *
	 * @param source the source of this code master map
	 */
	@Override
	public void setSource(String source) {
		model.setSource(source);
	}

	/**
	 * Sets the source code of this code master map.
	 *
	 * @param sourceCode the source code of this code master map
	 */
	@Override
	public void setSourceCode(String sourceCode) {
		model.setSourceCode(sourceCode);
	}

	/**
	 * Sets the source desc of this code master map.
	 *
	 * @param sourceDesc the source desc of this code master map
	 */
	@Override
	public void setSourceDesc(String sourceDesc) {
		model.setSourceDesc(sourceDesc);
	}

	/**
	 * Sets the source system ID of this code master map.
	 *
	 * @param sourceSystemId the source system ID of this code master map
	 */
	@Override
	public void setSourceSystemId(String sourceSystemId) {
		model.setSourceSystemId(sourceSystemId);
	}

	/**
	 * Sets the source type of this code master map.
	 *
	 * @param sourceType the source type of this code master map
	 */
	@Override
	public void setSourceType(String sourceType) {
		model.setSourceType(sourceType);
	}

	/**
	 * Sets the type of this code master map.
	 *
	 * @param type the type of this code master map
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	@Override
	protected CodeMasterMapWrapper wrap(CodeMasterMap codeMasterMap) {
		return new CodeMasterMapWrapper(codeMasterMap);
	}

}