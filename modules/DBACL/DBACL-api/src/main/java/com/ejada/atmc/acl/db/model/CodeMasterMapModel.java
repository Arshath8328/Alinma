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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CodeMasterMap service. Represents a row in the &quot;PM_CODE_MASTER_MAP&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ejada.atmc.acl.db.model.impl.CodeMasterMapModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ejada.atmc.acl.db.model.impl.CodeMasterMapImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CodeMasterMap
 * @generated
 */
@ProviderType
public interface CodeMasterMapModel extends BaseModel<CodeMasterMap> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a code master map model instance should use the {@link CodeMasterMap} interface instead.
	 */

	/**
	 * Returns the primary key of this code master map.
	 *
	 * @return the primary key of this code master map
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this code master map.
	 *
	 * @param primaryKey the primary key of this code master map
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the source of this code master map.
	 *
	 * @return the source of this code master map
	 */
	@AutoEscape
	public String getSource();

	/**
	 * Sets the source of this code master map.
	 *
	 * @param source the source of this code master map
	 */
	public void setSource(String source);

	/**
	 * Returns the type of this code master map.
	 *
	 * @return the type of this code master map
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this code master map.
	 *
	 * @param type the type of this code master map
	 */
	public void setType(String type);

	/**
	 * Returns the source type of this code master map.
	 *
	 * @return the source type of this code master map
	 */
	@AutoEscape
	public String getSourceType();

	/**
	 * Sets the source type of this code master map.
	 *
	 * @param sourceType the source type of this code master map
	 */
	public void setSourceType(String sourceType);

	/**
	 * Returns the source system ID of this code master map.
	 *
	 * @return the source system ID of this code master map
	 */
	@AutoEscape
	public String getSourceSystemId();

	/**
	 * Sets the source system ID of this code master map.
	 *
	 * @param sourceSystemId the source system ID of this code master map
	 */
	public void setSourceSystemId(String sourceSystemId);

	/**
	 * Returns the source code of this code master map.
	 *
	 * @return the source code of this code master map
	 */
	@AutoEscape
	public String getSourceCode();

	/**
	 * Sets the source code of this code master map.
	 *
	 * @param sourceCode the source code of this code master map
	 */
	public void setSourceCode(String sourceCode);

	/**
	 * Returns the source desc of this code master map.
	 *
	 * @return the source desc of this code master map
	 */
	@AutoEscape
	public String getSourceDesc();

	/**
	 * Sets the source desc of this code master map.
	 *
	 * @param sourceDesc the source desc of this code master map
	 */
	public void setSourceDesc(String sourceDesc);

	/**
	 * Returns the core type of this code master map.
	 *
	 * @return the core type of this code master map
	 */
	@AutoEscape
	public String getCoreType();

	/**
	 * Sets the core type of this code master map.
	 *
	 * @param coreType the core type of this code master map
	 */
	public void setCoreType(String coreType);

	/**
	 * Returns the core system ID of this code master map.
	 *
	 * @return the core system ID of this code master map
	 */
	@AutoEscape
	public String getCoreSystemId();

	/**
	 * Sets the core system ID of this code master map.
	 *
	 * @param coreSystemId the core system ID of this code master map
	 */
	public void setCoreSystemId(String coreSystemId);

	/**
	 * Returns the core code of this code master map.
	 *
	 * @return the core code of this code master map
	 */
	@AutoEscape
	public String getCoreCode();

	/**
	 * Sets the core code of this code master map.
	 *
	 * @param coreCode the core code of this code master map
	 */
	public void setCoreCode(String coreCode);

	/**
	 * Returns the core desc of this code master map.
	 *
	 * @return the core desc of this code master map
	 */
	@AutoEscape
	public String getCoreDesc();

	/**
	 * Sets the core desc of this code master map.
	 *
	 * @param coreDesc the core desc of this code master map
	 */
	public void setCoreDesc(String coreDesc);

	/**
	 * Returns the eff from date of this code master map.
	 *
	 * @return the eff from date of this code master map
	 */
	public Date getEffFromDate();

	/**
	 * Sets the eff from date of this code master map.
	 *
	 * @param effFromDate the eff from date of this code master map
	 */
	public void setEffFromDate(Date effFromDate);

	/**
	 * Returns the eff to date of this code master map.
	 *
	 * @return the eff to date of this code master map
	 */
	public Date getEffToDate();

	/**
	 * Sets the eff to date of this code master map.
	 *
	 * @param effToDate the eff to date of this code master map
	 */
	public void setEffToDate(Date effToDate);

	/**
	 * Returns the freeze flag of this code master map.
	 *
	 * @return the freeze flag of this code master map
	 */
	@AutoEscape
	public String getFreezeFlag();

	/**
	 * Sets the freeze flag of this code master map.
	 *
	 * @param freezeFlag the freeze flag of this code master map
	 */
	public void setFreezeFlag(String freezeFlag);

	/**
	 * Returns the lvl1 type of this code master map.
	 *
	 * @return the lvl1 type of this code master map
	 */
	@AutoEscape
	public String getLvl1Type();

	/**
	 * Sets the lvl1 type of this code master map.
	 *
	 * @param lvl1Type the lvl1 type of this code master map
	 */
	public void setLvl1Type(String lvl1Type);

	/**
	 * Returns the lvl1 sys ID of this code master map.
	 *
	 * @return the lvl1 sys ID of this code master map
	 */
	@AutoEscape
	public String getLvl1SysId();

	/**
	 * Sets the lvl1 sys ID of this code master map.
	 *
	 * @param lvl1SysId the lvl1 sys ID of this code master map
	 */
	public void setLvl1SysId(String lvl1SysId);

	/**
	 * Returns the lvl1 code of this code master map.
	 *
	 * @return the lvl1 code of this code master map
	 */
	@AutoEscape
	public String getLvl1Code();

	/**
	 * Sets the lvl1 code of this code master map.
	 *
	 * @param lvl1Code the lvl1 code of this code master map
	 */
	public void setLvl1Code(String lvl1Code);

	/**
	 * Returns the lvl1 desc of this code master map.
	 *
	 * @return the lvl1 desc of this code master map
	 */
	@AutoEscape
	public String getLvl1Desc();

	/**
	 * Sets the lvl1 desc of this code master map.
	 *
	 * @param lvl1Desc the lvl1 desc of this code master map
	 */
	public void setLvl1Desc(String lvl1Desc);

	/**
	 * Returns the lvl2 type of this code master map.
	 *
	 * @return the lvl2 type of this code master map
	 */
	@AutoEscape
	public String getLvl2Type();

	/**
	 * Sets the lvl2 type of this code master map.
	 *
	 * @param lvl2Type the lvl2 type of this code master map
	 */
	public void setLvl2Type(String lvl2Type);

	/**
	 * Returns the lvl2 sys ID of this code master map.
	 *
	 * @return the lvl2 sys ID of this code master map
	 */
	@AutoEscape
	public String getLvl2SysId();

	/**
	 * Sets the lvl2 sys ID of this code master map.
	 *
	 * @param lvl2SysId the lvl2 sys ID of this code master map
	 */
	public void setLvl2SysId(String lvl2SysId);

	/**
	 * Returns the lvl2 code of this code master map.
	 *
	 * @return the lvl2 code of this code master map
	 */
	@AutoEscape
	public String getLvl2Code();

	/**
	 * Sets the lvl2 code of this code master map.
	 *
	 * @param lvl2Code the lvl2 code of this code master map
	 */
	public void setLvl2Code(String lvl2Code);

	/**
	 * Returns the lvl2 desc of this code master map.
	 *
	 * @return the lvl2 desc of this code master map
	 */
	@AutoEscape
	public String getLvl2Desc();

	/**
	 * Sets the lvl2 desc of this code master map.
	 *
	 * @param lvl2Desc the lvl2 desc of this code master map
	 */
	public void setLvl2Desc(String lvl2Desc);

}