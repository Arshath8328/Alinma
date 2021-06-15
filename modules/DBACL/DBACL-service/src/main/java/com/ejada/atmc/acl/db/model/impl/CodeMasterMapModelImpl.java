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

package com.ejada.atmc.acl.db.model.impl;

import com.ejada.atmc.acl.db.model.CodeMasterMap;
import com.ejada.atmc.acl.db.model.CodeMasterMapModel;
import com.ejada.atmc.acl.db.model.CodeMasterMapSoap;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CodeMasterMap service. Represents a row in the &quot;PM_CODE_MASTER_MAP&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CodeMasterMapModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CodeMasterMapImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CodeMasterMapImpl
 * @generated
 */
@JSON(strict = true)
public class CodeMasterMapModelImpl
	extends BaseModelImpl<CodeMasterMap> implements CodeMasterMapModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a code master map model instance should use the <code>CodeMasterMap</code> interface instead.
	 */
	public static final String TABLE_NAME = "PM_CODE_MASTER_MAP";

	public static final Object[][] TABLE_COLUMNS = {
		{"MDM_SOURCE", Types.VARCHAR}, {"MDM_TYPE", Types.VARCHAR},
		{"MDM_SRC_TYPE", Types.VARCHAR}, {"MDM_SRC_SYS_ID", Types.VARCHAR},
		{"MDM_SRC_CODE", Types.VARCHAR}, {"MDM_SRC_DESC", Types.VARCHAR},
		{"MDM_CORE_TYPE", Types.VARCHAR}, {"MDM_CORE_SYS_ID", Types.VARCHAR},
		{"MDM_CORE_CODE", Types.VARCHAR}, {"MDM_CORE_DESC", Types.VARCHAR},
		{"MDM_EFF_FM_DT", Types.TIMESTAMP}, {"MDM_EFF_TO_DT", Types.TIMESTAMP},
		{"MDM_FREEZE_FLAG", Types.VARCHAR}, {"MDM_LVL1_TYPE", Types.VARCHAR},
		{"MDM_LVL1_SYS_ID", Types.VARCHAR}, {"MDM_LVL1_CODE", Types.VARCHAR},
		{"MDM_LVL1_DESC", Types.VARCHAR}, {"MDM_LVL2_TYPE", Types.VARCHAR},
		{"MDM_LVL2_SYS_ID", Types.VARCHAR}, {"MDM_LVL2_CODE", Types.VARCHAR},
		{"MDM_LVL2_DESC", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("MDM_SOURCE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MDM_TYPE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MDM_SRC_TYPE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MDM_SRC_SYS_ID", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MDM_SRC_CODE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MDM_SRC_DESC", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MDM_CORE_TYPE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MDM_CORE_SYS_ID", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MDM_CORE_CODE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MDM_CORE_DESC", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MDM_EFF_FM_DT", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("MDM_EFF_TO_DT", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("MDM_FREEZE_FLAG", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MDM_LVL1_TYPE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MDM_LVL1_SYS_ID", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MDM_LVL1_CODE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MDM_LVL1_DESC", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MDM_LVL2_TYPE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MDM_LVL2_SYS_ID", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MDM_LVL2_CODE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MDM_LVL2_DESC", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table PM_CODE_MASTER_MAP (MDM_SOURCE VARCHAR(75) not null primary key,MDM_TYPE VARCHAR(75) null,MDM_SRC_TYPE VARCHAR(75) null,MDM_SRC_SYS_ID VARCHAR(75) null,MDM_SRC_CODE VARCHAR(75) null,MDM_SRC_DESC VARCHAR(75) null,MDM_CORE_TYPE VARCHAR(75) null,MDM_CORE_SYS_ID VARCHAR(75) null,MDM_CORE_CODE VARCHAR(75) null,MDM_CORE_DESC VARCHAR(75) null,MDM_EFF_FM_DT DATE null,MDM_EFF_TO_DT DATE null,MDM_FREEZE_FLAG VARCHAR(75) null,MDM_LVL1_TYPE VARCHAR(75) null,MDM_LVL1_SYS_ID VARCHAR(75) null,MDM_LVL1_CODE VARCHAR(75) null,MDM_LVL1_DESC VARCHAR(75) null,MDM_LVL2_TYPE VARCHAR(75) null,MDM_LVL2_SYS_ID VARCHAR(75) null,MDM_LVL2_CODE VARCHAR(75) null,MDM_LVL2_DESC VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table PM_CODE_MASTER_MAP";

	public static final String ORDER_BY_JPQL =
		" ORDER BY codeMasterMap.source ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY PM_CODE_MASTER_MAP.MDM_SOURCE ASC";

	public static final String DATA_SOURCE = "extDS";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long CORECODE_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long LVL1CODE_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long SOURCECODE_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long SOURCETYPE_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long SOURCE_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static CodeMasterMap toModel(CodeMasterMapSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CodeMasterMap model = new CodeMasterMapImpl();

		model.setSource(soapModel.getSource());
		model.setType(soapModel.getType());
		model.setSourceType(soapModel.getSourceType());
		model.setSourceSystemId(soapModel.getSourceSystemId());
		model.setSourceCode(soapModel.getSourceCode());
		model.setSourceDesc(soapModel.getSourceDesc());
		model.setCoreType(soapModel.getCoreType());
		model.setCoreSystemId(soapModel.getCoreSystemId());
		model.setCoreCode(soapModel.getCoreCode());
		model.setCoreDesc(soapModel.getCoreDesc());
		model.setEffFromDate(soapModel.getEffFromDate());
		model.setEffToDate(soapModel.getEffToDate());
		model.setFreezeFlag(soapModel.getFreezeFlag());
		model.setLvl1Type(soapModel.getLvl1Type());
		model.setLvl1SysId(soapModel.getLvl1SysId());
		model.setLvl1Code(soapModel.getLvl1Code());
		model.setLvl1Desc(soapModel.getLvl1Desc());
		model.setLvl2Type(soapModel.getLvl2Type());
		model.setLvl2SysId(soapModel.getLvl2SysId());
		model.setLvl2Code(soapModel.getLvl2Code());
		model.setLvl2Desc(soapModel.getLvl2Desc());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<CodeMasterMap> toModels(CodeMasterMapSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CodeMasterMap> models = new ArrayList<CodeMasterMap>(
			soapModels.length);

		for (CodeMasterMapSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CodeMasterMapModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _source;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setSource(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _source;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return CodeMasterMap.class;
	}

	@Override
	public String getModelClassName() {
		return CodeMasterMap.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CodeMasterMap, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CodeMasterMap, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CodeMasterMap, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CodeMasterMap)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CodeMasterMap, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CodeMasterMap, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CodeMasterMap)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CodeMasterMap, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CodeMasterMap, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CodeMasterMap>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CodeMasterMap.class.getClassLoader(), CodeMasterMap.class,
			ModelWrapper.class);

		try {
			Constructor<CodeMasterMap> constructor =
				(Constructor<CodeMasterMap>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<CodeMasterMap, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CodeMasterMap, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CodeMasterMap, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CodeMasterMap, Object>>();
		Map<String, BiConsumer<CodeMasterMap, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CodeMasterMap, ?>>();

		attributeGetterFunctions.put("source", CodeMasterMap::getSource);
		attributeSetterBiConsumers.put(
			"source",
			(BiConsumer<CodeMasterMap, String>)CodeMasterMap::setSource);
		attributeGetterFunctions.put("type", CodeMasterMap::getType);
		attributeSetterBiConsumers.put(
			"type", (BiConsumer<CodeMasterMap, String>)CodeMasterMap::setType);
		attributeGetterFunctions.put(
			"sourceType", CodeMasterMap::getSourceType);
		attributeSetterBiConsumers.put(
			"sourceType",
			(BiConsumer<CodeMasterMap, String>)CodeMasterMap::setSourceType);
		attributeGetterFunctions.put(
			"sourceSystemId", CodeMasterMap::getSourceSystemId);
		attributeSetterBiConsumers.put(
			"sourceSystemId",
			(BiConsumer<CodeMasterMap, String>)
				CodeMasterMap::setSourceSystemId);
		attributeGetterFunctions.put(
			"sourceCode", CodeMasterMap::getSourceCode);
		attributeSetterBiConsumers.put(
			"sourceCode",
			(BiConsumer<CodeMasterMap, String>)CodeMasterMap::setSourceCode);
		attributeGetterFunctions.put(
			"sourceDesc", CodeMasterMap::getSourceDesc);
		attributeSetterBiConsumers.put(
			"sourceDesc",
			(BiConsumer<CodeMasterMap, String>)CodeMasterMap::setSourceDesc);
		attributeGetterFunctions.put("coreType", CodeMasterMap::getCoreType);
		attributeSetterBiConsumers.put(
			"coreType",
			(BiConsumer<CodeMasterMap, String>)CodeMasterMap::setCoreType);
		attributeGetterFunctions.put(
			"coreSystemId", CodeMasterMap::getCoreSystemId);
		attributeSetterBiConsumers.put(
			"coreSystemId",
			(BiConsumer<CodeMasterMap, String>)CodeMasterMap::setCoreSystemId);
		attributeGetterFunctions.put("coreCode", CodeMasterMap::getCoreCode);
		attributeSetterBiConsumers.put(
			"coreCode",
			(BiConsumer<CodeMasterMap, String>)CodeMasterMap::setCoreCode);
		attributeGetterFunctions.put("coreDesc", CodeMasterMap::getCoreDesc);
		attributeSetterBiConsumers.put(
			"coreDesc",
			(BiConsumer<CodeMasterMap, String>)CodeMasterMap::setCoreDesc);
		attributeGetterFunctions.put(
			"effFromDate", CodeMasterMap::getEffFromDate);
		attributeSetterBiConsumers.put(
			"effFromDate",
			(BiConsumer<CodeMasterMap, Date>)CodeMasterMap::setEffFromDate);
		attributeGetterFunctions.put("effToDate", CodeMasterMap::getEffToDate);
		attributeSetterBiConsumers.put(
			"effToDate",
			(BiConsumer<CodeMasterMap, Date>)CodeMasterMap::setEffToDate);
		attributeGetterFunctions.put(
			"freezeFlag", CodeMasterMap::getFreezeFlag);
		attributeSetterBiConsumers.put(
			"freezeFlag",
			(BiConsumer<CodeMasterMap, String>)CodeMasterMap::setFreezeFlag);
		attributeGetterFunctions.put("lvl1Type", CodeMasterMap::getLvl1Type);
		attributeSetterBiConsumers.put(
			"lvl1Type",
			(BiConsumer<CodeMasterMap, String>)CodeMasterMap::setLvl1Type);
		attributeGetterFunctions.put("lvl1SysId", CodeMasterMap::getLvl1SysId);
		attributeSetterBiConsumers.put(
			"lvl1SysId",
			(BiConsumer<CodeMasterMap, String>)CodeMasterMap::setLvl1SysId);
		attributeGetterFunctions.put("lvl1Code", CodeMasterMap::getLvl1Code);
		attributeSetterBiConsumers.put(
			"lvl1Code",
			(BiConsumer<CodeMasterMap, String>)CodeMasterMap::setLvl1Code);
		attributeGetterFunctions.put("lvl1Desc", CodeMasterMap::getLvl1Desc);
		attributeSetterBiConsumers.put(
			"lvl1Desc",
			(BiConsumer<CodeMasterMap, String>)CodeMasterMap::setLvl1Desc);
		attributeGetterFunctions.put("lvl2Type", CodeMasterMap::getLvl2Type);
		attributeSetterBiConsumers.put(
			"lvl2Type",
			(BiConsumer<CodeMasterMap, String>)CodeMasterMap::setLvl2Type);
		attributeGetterFunctions.put("lvl2SysId", CodeMasterMap::getLvl2SysId);
		attributeSetterBiConsumers.put(
			"lvl2SysId",
			(BiConsumer<CodeMasterMap, String>)CodeMasterMap::setLvl2SysId);
		attributeGetterFunctions.put("lvl2Code", CodeMasterMap::getLvl2Code);
		attributeSetterBiConsumers.put(
			"lvl2Code",
			(BiConsumer<CodeMasterMap, String>)CodeMasterMap::setLvl2Code);
		attributeGetterFunctions.put("lvl2Desc", CodeMasterMap::getLvl2Desc);
		attributeSetterBiConsumers.put(
			"lvl2Desc",
			(BiConsumer<CodeMasterMap, String>)CodeMasterMap::setLvl2Desc);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getSource() {
		if (_source == null) {
			return "";
		}
		else {
			return _source;
		}
	}

	@Override
	public void setSource(String source) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_source = source;
	}

	@JSON
	@Override
	public String getType() {
		if (_type == null) {
			return "";
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_type = type;
	}

	@JSON
	@Override
	public String getSourceType() {
		if (_sourceType == null) {
			return "";
		}
		else {
			return _sourceType;
		}
	}

	@Override
	public void setSourceType(String sourceType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sourceType = sourceType;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalSourceType() {
		return getColumnOriginalValue("MDM_SRC_TYPE");
	}

	@JSON
	@Override
	public String getSourceSystemId() {
		if (_sourceSystemId == null) {
			return "";
		}
		else {
			return _sourceSystemId;
		}
	}

	@Override
	public void setSourceSystemId(String sourceSystemId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sourceSystemId = sourceSystemId;
	}

	@JSON
	@Override
	public String getSourceCode() {
		if (_sourceCode == null) {
			return "";
		}
		else {
			return _sourceCode;
		}
	}

	@Override
	public void setSourceCode(String sourceCode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sourceCode = sourceCode;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalSourceCode() {
		return getColumnOriginalValue("MDM_SRC_CODE");
	}

	@JSON
	@Override
	public String getSourceDesc() {
		if (_sourceDesc == null) {
			return "";
		}
		else {
			return _sourceDesc;
		}
	}

	@Override
	public void setSourceDesc(String sourceDesc) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sourceDesc = sourceDesc;
	}

	@JSON
	@Override
	public String getCoreType() {
		if (_coreType == null) {
			return "";
		}
		else {
			return _coreType;
		}
	}

	@Override
	public void setCoreType(String coreType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_coreType = coreType;
	}

	@JSON
	@Override
	public String getCoreSystemId() {
		if (_coreSystemId == null) {
			return "";
		}
		else {
			return _coreSystemId;
		}
	}

	@Override
	public void setCoreSystemId(String coreSystemId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_coreSystemId = coreSystemId;
	}

	@JSON
	@Override
	public String getCoreCode() {
		if (_coreCode == null) {
			return "";
		}
		else {
			return _coreCode;
		}
	}

	@Override
	public void setCoreCode(String coreCode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_coreCode = coreCode;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalCoreCode() {
		return getColumnOriginalValue("MDM_CORE_CODE");
	}

	@JSON
	@Override
	public String getCoreDesc() {
		if (_coreDesc == null) {
			return "";
		}
		else {
			return _coreDesc;
		}
	}

	@Override
	public void setCoreDesc(String coreDesc) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_coreDesc = coreDesc;
	}

	@JSON
	@Override
	public Date getEffFromDate() {
		return _effFromDate;
	}

	@Override
	public void setEffFromDate(Date effFromDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_effFromDate = effFromDate;
	}

	@JSON
	@Override
	public Date getEffToDate() {
		return _effToDate;
	}

	@Override
	public void setEffToDate(Date effToDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_effToDate = effToDate;
	}

	@JSON
	@Override
	public String getFreezeFlag() {
		if (_freezeFlag == null) {
			return "";
		}
		else {
			return _freezeFlag;
		}
	}

	@Override
	public void setFreezeFlag(String freezeFlag) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_freezeFlag = freezeFlag;
	}

	@JSON
	@Override
	public String getLvl1Type() {
		if (_lvl1Type == null) {
			return "";
		}
		else {
			return _lvl1Type;
		}
	}

	@Override
	public void setLvl1Type(String lvl1Type) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lvl1Type = lvl1Type;
	}

	@JSON
	@Override
	public String getLvl1SysId() {
		if (_lvl1SysId == null) {
			return "";
		}
		else {
			return _lvl1SysId;
		}
	}

	@Override
	public void setLvl1SysId(String lvl1SysId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lvl1SysId = lvl1SysId;
	}

	@JSON
	@Override
	public String getLvl1Code() {
		if (_lvl1Code == null) {
			return "";
		}
		else {
			return _lvl1Code;
		}
	}

	@Override
	public void setLvl1Code(String lvl1Code) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lvl1Code = lvl1Code;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalLvl1Code() {
		return getColumnOriginalValue("MDM_LVL1_CODE");
	}

	@JSON
	@Override
	public String getLvl1Desc() {
		if (_lvl1Desc == null) {
			return "";
		}
		else {
			return _lvl1Desc;
		}
	}

	@Override
	public void setLvl1Desc(String lvl1Desc) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lvl1Desc = lvl1Desc;
	}

	@JSON
	@Override
	public String getLvl2Type() {
		if (_lvl2Type == null) {
			return "";
		}
		else {
			return _lvl2Type;
		}
	}

	@Override
	public void setLvl2Type(String lvl2Type) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lvl2Type = lvl2Type;
	}

	@JSON
	@Override
	public String getLvl2SysId() {
		if (_lvl2SysId == null) {
			return "";
		}
		else {
			return _lvl2SysId;
		}
	}

	@Override
	public void setLvl2SysId(String lvl2SysId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lvl2SysId = lvl2SysId;
	}

	@JSON
	@Override
	public String getLvl2Code() {
		if (_lvl2Code == null) {
			return "";
		}
		else {
			return _lvl2Code;
		}
	}

	@Override
	public void setLvl2Code(String lvl2Code) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lvl2Code = lvl2Code;
	}

	@JSON
	@Override
	public String getLvl2Desc() {
		if (_lvl2Desc == null) {
			return "";
		}
		else {
			return _lvl2Desc;
		}
	}

	@Override
	public void setLvl2Desc(String lvl2Desc) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lvl2Desc = lvl2Desc;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (entry.getValue() != getColumnValue(entry.getKey())) {
				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public CodeMasterMap toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CodeMasterMap>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CodeMasterMapImpl codeMasterMapImpl = new CodeMasterMapImpl();

		codeMasterMapImpl.setSource(getSource());
		codeMasterMapImpl.setType(getType());
		codeMasterMapImpl.setSourceType(getSourceType());
		codeMasterMapImpl.setSourceSystemId(getSourceSystemId());
		codeMasterMapImpl.setSourceCode(getSourceCode());
		codeMasterMapImpl.setSourceDesc(getSourceDesc());
		codeMasterMapImpl.setCoreType(getCoreType());
		codeMasterMapImpl.setCoreSystemId(getCoreSystemId());
		codeMasterMapImpl.setCoreCode(getCoreCode());
		codeMasterMapImpl.setCoreDesc(getCoreDesc());
		codeMasterMapImpl.setEffFromDate(getEffFromDate());
		codeMasterMapImpl.setEffToDate(getEffToDate());
		codeMasterMapImpl.setFreezeFlag(getFreezeFlag());
		codeMasterMapImpl.setLvl1Type(getLvl1Type());
		codeMasterMapImpl.setLvl1SysId(getLvl1SysId());
		codeMasterMapImpl.setLvl1Code(getLvl1Code());
		codeMasterMapImpl.setLvl1Desc(getLvl1Desc());
		codeMasterMapImpl.setLvl2Type(getLvl2Type());
		codeMasterMapImpl.setLvl2SysId(getLvl2SysId());
		codeMasterMapImpl.setLvl2Code(getLvl2Code());
		codeMasterMapImpl.setLvl2Desc(getLvl2Desc());

		codeMasterMapImpl.resetOriginalValues();

		return codeMasterMapImpl;
	}

	@Override
	public int compareTo(CodeMasterMap codeMasterMap) {
		String primaryKey = codeMasterMap.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CodeMasterMap)) {
			return false;
		}

		CodeMasterMap codeMasterMap = (CodeMasterMap)object;

		String primaryKey = codeMasterMap.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CodeMasterMap> toCacheModel() {
		CodeMasterMapCacheModel codeMasterMapCacheModel =
			new CodeMasterMapCacheModel();

		codeMasterMapCacheModel.source = getSource();

		String source = codeMasterMapCacheModel.source;

		if ((source != null) && (source.length() == 0)) {
			codeMasterMapCacheModel.source = null;
		}

		codeMasterMapCacheModel.type = getType();

		String type = codeMasterMapCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			codeMasterMapCacheModel.type = null;
		}

		codeMasterMapCacheModel.sourceType = getSourceType();

		String sourceType = codeMasterMapCacheModel.sourceType;

		if ((sourceType != null) && (sourceType.length() == 0)) {
			codeMasterMapCacheModel.sourceType = null;
		}

		codeMasterMapCacheModel.sourceSystemId = getSourceSystemId();

		String sourceSystemId = codeMasterMapCacheModel.sourceSystemId;

		if ((sourceSystemId != null) && (sourceSystemId.length() == 0)) {
			codeMasterMapCacheModel.sourceSystemId = null;
		}

		codeMasterMapCacheModel.sourceCode = getSourceCode();

		String sourceCode = codeMasterMapCacheModel.sourceCode;

		if ((sourceCode != null) && (sourceCode.length() == 0)) {
			codeMasterMapCacheModel.sourceCode = null;
		}

		codeMasterMapCacheModel.sourceDesc = getSourceDesc();

		String sourceDesc = codeMasterMapCacheModel.sourceDesc;

		if ((sourceDesc != null) && (sourceDesc.length() == 0)) {
			codeMasterMapCacheModel.sourceDesc = null;
		}

		codeMasterMapCacheModel.coreType = getCoreType();

		String coreType = codeMasterMapCacheModel.coreType;

		if ((coreType != null) && (coreType.length() == 0)) {
			codeMasterMapCacheModel.coreType = null;
		}

		codeMasterMapCacheModel.coreSystemId = getCoreSystemId();

		String coreSystemId = codeMasterMapCacheModel.coreSystemId;

		if ((coreSystemId != null) && (coreSystemId.length() == 0)) {
			codeMasterMapCacheModel.coreSystemId = null;
		}

		codeMasterMapCacheModel.coreCode = getCoreCode();

		String coreCode = codeMasterMapCacheModel.coreCode;

		if ((coreCode != null) && (coreCode.length() == 0)) {
			codeMasterMapCacheModel.coreCode = null;
		}

		codeMasterMapCacheModel.coreDesc = getCoreDesc();

		String coreDesc = codeMasterMapCacheModel.coreDesc;

		if ((coreDesc != null) && (coreDesc.length() == 0)) {
			codeMasterMapCacheModel.coreDesc = null;
		}

		Date effFromDate = getEffFromDate();

		if (effFromDate != null) {
			codeMasterMapCacheModel.effFromDate = effFromDate.getTime();
		}
		else {
			codeMasterMapCacheModel.effFromDate = Long.MIN_VALUE;
		}

		Date effToDate = getEffToDate();

		if (effToDate != null) {
			codeMasterMapCacheModel.effToDate = effToDate.getTime();
		}
		else {
			codeMasterMapCacheModel.effToDate = Long.MIN_VALUE;
		}

		codeMasterMapCacheModel.freezeFlag = getFreezeFlag();

		String freezeFlag = codeMasterMapCacheModel.freezeFlag;

		if ((freezeFlag != null) && (freezeFlag.length() == 0)) {
			codeMasterMapCacheModel.freezeFlag = null;
		}

		codeMasterMapCacheModel.lvl1Type = getLvl1Type();

		String lvl1Type = codeMasterMapCacheModel.lvl1Type;

		if ((lvl1Type != null) && (lvl1Type.length() == 0)) {
			codeMasterMapCacheModel.lvl1Type = null;
		}

		codeMasterMapCacheModel.lvl1SysId = getLvl1SysId();

		String lvl1SysId = codeMasterMapCacheModel.lvl1SysId;

		if ((lvl1SysId != null) && (lvl1SysId.length() == 0)) {
			codeMasterMapCacheModel.lvl1SysId = null;
		}

		codeMasterMapCacheModel.lvl1Code = getLvl1Code();

		String lvl1Code = codeMasterMapCacheModel.lvl1Code;

		if ((lvl1Code != null) && (lvl1Code.length() == 0)) {
			codeMasterMapCacheModel.lvl1Code = null;
		}

		codeMasterMapCacheModel.lvl1Desc = getLvl1Desc();

		String lvl1Desc = codeMasterMapCacheModel.lvl1Desc;

		if ((lvl1Desc != null) && (lvl1Desc.length() == 0)) {
			codeMasterMapCacheModel.lvl1Desc = null;
		}

		codeMasterMapCacheModel.lvl2Type = getLvl2Type();

		String lvl2Type = codeMasterMapCacheModel.lvl2Type;

		if ((lvl2Type != null) && (lvl2Type.length() == 0)) {
			codeMasterMapCacheModel.lvl2Type = null;
		}

		codeMasterMapCacheModel.lvl2SysId = getLvl2SysId();

		String lvl2SysId = codeMasterMapCacheModel.lvl2SysId;

		if ((lvl2SysId != null) && (lvl2SysId.length() == 0)) {
			codeMasterMapCacheModel.lvl2SysId = null;
		}

		codeMasterMapCacheModel.lvl2Code = getLvl2Code();

		String lvl2Code = codeMasterMapCacheModel.lvl2Code;

		if ((lvl2Code != null) && (lvl2Code.length() == 0)) {
			codeMasterMapCacheModel.lvl2Code = null;
		}

		codeMasterMapCacheModel.lvl2Desc = getLvl2Desc();

		String lvl2Desc = codeMasterMapCacheModel.lvl2Desc;

		if ((lvl2Desc != null) && (lvl2Desc.length() == 0)) {
			codeMasterMapCacheModel.lvl2Desc = null;
		}

		return codeMasterMapCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CodeMasterMap, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CodeMasterMap, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CodeMasterMap, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CodeMasterMap)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CodeMasterMap, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CodeMasterMap, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CodeMasterMap, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CodeMasterMap)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CodeMasterMap>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

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

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CodeMasterMap, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CodeMasterMap)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("MDM_SOURCE", _source);
		_columnOriginalValues.put("MDM_TYPE", _type);
		_columnOriginalValues.put("MDM_SRC_TYPE", _sourceType);
		_columnOriginalValues.put("MDM_SRC_SYS_ID", _sourceSystemId);
		_columnOriginalValues.put("MDM_SRC_CODE", _sourceCode);
		_columnOriginalValues.put("MDM_SRC_DESC", _sourceDesc);
		_columnOriginalValues.put("MDM_CORE_TYPE", _coreType);
		_columnOriginalValues.put("MDM_CORE_SYS_ID", _coreSystemId);
		_columnOriginalValues.put("MDM_CORE_CODE", _coreCode);
		_columnOriginalValues.put("MDM_CORE_DESC", _coreDesc);
		_columnOriginalValues.put("MDM_EFF_FM_DT", _effFromDate);
		_columnOriginalValues.put("MDM_EFF_TO_DT", _effToDate);
		_columnOriginalValues.put("MDM_FREEZE_FLAG", _freezeFlag);
		_columnOriginalValues.put("MDM_LVL1_TYPE", _lvl1Type);
		_columnOriginalValues.put("MDM_LVL1_SYS_ID", _lvl1SysId);
		_columnOriginalValues.put("MDM_LVL1_CODE", _lvl1Code);
		_columnOriginalValues.put("MDM_LVL1_DESC", _lvl1Desc);
		_columnOriginalValues.put("MDM_LVL2_TYPE", _lvl2Type);
		_columnOriginalValues.put("MDM_LVL2_SYS_ID", _lvl2SysId);
		_columnOriginalValues.put("MDM_LVL2_CODE", _lvl2Code);
		_columnOriginalValues.put("MDM_LVL2_DESC", _lvl2Desc);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("MDM_SOURCE", "source");
		attributeNames.put("MDM_TYPE", "type");
		attributeNames.put("MDM_SRC_TYPE", "sourceType");
		attributeNames.put("MDM_SRC_SYS_ID", "sourceSystemId");
		attributeNames.put("MDM_SRC_CODE", "sourceCode");
		attributeNames.put("MDM_SRC_DESC", "sourceDesc");
		attributeNames.put("MDM_CORE_TYPE", "coreType");
		attributeNames.put("MDM_CORE_SYS_ID", "coreSystemId");
		attributeNames.put("MDM_CORE_CODE", "coreCode");
		attributeNames.put("MDM_CORE_DESC", "coreDesc");
		attributeNames.put("MDM_EFF_FM_DT", "effFromDate");
		attributeNames.put("MDM_EFF_TO_DT", "effToDate");
		attributeNames.put("MDM_FREEZE_FLAG", "freezeFlag");
		attributeNames.put("MDM_LVL1_TYPE", "lvl1Type");
		attributeNames.put("MDM_LVL1_SYS_ID", "lvl1SysId");
		attributeNames.put("MDM_LVL1_CODE", "lvl1Code");
		attributeNames.put("MDM_LVL1_DESC", "lvl1Desc");
		attributeNames.put("MDM_LVL2_TYPE", "lvl2Type");
		attributeNames.put("MDM_LVL2_SYS_ID", "lvl2SysId");
		attributeNames.put("MDM_LVL2_CODE", "lvl2Code");
		attributeNames.put("MDM_LVL2_DESC", "lvl2Desc");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("MDM_SOURCE", 1L);

		columnBitmasks.put("MDM_TYPE", 2L);

		columnBitmasks.put("MDM_SRC_TYPE", 4L);

		columnBitmasks.put("MDM_SRC_SYS_ID", 8L);

		columnBitmasks.put("MDM_SRC_CODE", 16L);

		columnBitmasks.put("MDM_SRC_DESC", 32L);

		columnBitmasks.put("MDM_CORE_TYPE", 64L);

		columnBitmasks.put("MDM_CORE_SYS_ID", 128L);

		columnBitmasks.put("MDM_CORE_CODE", 256L);

		columnBitmasks.put("MDM_CORE_DESC", 512L);

		columnBitmasks.put("MDM_EFF_FM_DT", 1024L);

		columnBitmasks.put("MDM_EFF_TO_DT", 2048L);

		columnBitmasks.put("MDM_FREEZE_FLAG", 4096L);

		columnBitmasks.put("MDM_LVL1_TYPE", 8192L);

		columnBitmasks.put("MDM_LVL1_SYS_ID", 16384L);

		columnBitmasks.put("MDM_LVL1_CODE", 32768L);

		columnBitmasks.put("MDM_LVL1_DESC", 65536L);

		columnBitmasks.put("MDM_LVL2_TYPE", 131072L);

		columnBitmasks.put("MDM_LVL2_SYS_ID", 262144L);

		columnBitmasks.put("MDM_LVL2_CODE", 524288L);

		columnBitmasks.put("MDM_LVL2_DESC", 1048576L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CodeMasterMap _escapedModel;

}