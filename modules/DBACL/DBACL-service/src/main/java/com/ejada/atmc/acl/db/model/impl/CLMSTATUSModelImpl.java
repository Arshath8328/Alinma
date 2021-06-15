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

import com.ejada.atmc.acl.db.model.CLMSTATUS;
import com.ejada.atmc.acl.db.model.CLMSTATUSModel;
import com.ejada.atmc.acl.db.model.CLMSTATUSSoap;

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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CLMSTATUS service. Represents a row in the &quot;EJD_CLAIMS_STATUS&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CLMSTATUSModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CLMSTATUSImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CLMSTATUSImpl
 * @generated
 */
@JSON(strict = true)
public class CLMSTATUSModelImpl
	extends BaseModelImpl<CLMSTATUS> implements CLMSTATUSModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a clmstatus model instance should use the <code>CLMSTATUS</code> interface instead.
	 */
	public static final String TABLE_NAME = "EJD_CLAIMS_STATUS";

	public static final Object[][] TABLE_COLUMNS = {
		{"REFERENCE_NO", Types.VARCHAR}, {"STATUS", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("REFERENCE_NO", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("STATUS", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table EJD_CLAIMS_STATUS (REFERENCE_NO VARCHAR(75) not null primary key,STATUS VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table EJD_CLAIMS_STATUS";

	public static final String ORDER_BY_JPQL = " ORDER BY clmstatus.RefNo ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY EJD_CLAIMS_STATUS.REFERENCE_NO ASC";

	public static final String DATA_SOURCE = "extDS";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long REFNO_COLUMN_BITMASK = 1L;

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
	public static CLMSTATUS toModel(CLMSTATUSSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CLMSTATUS model = new CLMSTATUSImpl();

		model.setRefNo(soapModel.getRefNo());
		model.setClaimStatus(soapModel.getClaimStatus());

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
	public static List<CLMSTATUS> toModels(CLMSTATUSSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CLMSTATUS> models = new ArrayList<CLMSTATUS>(soapModels.length);

		for (CLMSTATUSSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CLMSTATUSModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _RefNo;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setRefNo(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _RefNo;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return CLMSTATUS.class;
	}

	@Override
	public String getModelClassName() {
		return CLMSTATUS.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CLMSTATUS, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CLMSTATUS, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CLMSTATUS, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((CLMSTATUS)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CLMSTATUS, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CLMSTATUS, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CLMSTATUS)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CLMSTATUS, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CLMSTATUS, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CLMSTATUS>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CLMSTATUS.class.getClassLoader(), CLMSTATUS.class,
			ModelWrapper.class);

		try {
			Constructor<CLMSTATUS> constructor =
				(Constructor<CLMSTATUS>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CLMSTATUS, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CLMSTATUS, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CLMSTATUS, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CLMSTATUS, Object>>();
		Map<String, BiConsumer<CLMSTATUS, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CLMSTATUS, ?>>();

		attributeGetterFunctions.put("RefNo", CLMSTATUS::getRefNo);
		attributeSetterBiConsumers.put(
			"RefNo", (BiConsumer<CLMSTATUS, String>)CLMSTATUS::setRefNo);
		attributeGetterFunctions.put("claimStatus", CLMSTATUS::getClaimStatus);
		attributeSetterBiConsumers.put(
			"claimStatus",
			(BiConsumer<CLMSTATUS, String>)CLMSTATUS::setClaimStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getRefNo() {
		if (_RefNo == null) {
			return "";
		}
		else {
			return _RefNo;
		}
	}

	@Override
	public void setRefNo(String RefNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_RefNo = RefNo;
	}

	@JSON
	@Override
	public String getClaimStatus() {
		if (_claimStatus == null) {
			return "";
		}
		else {
			return _claimStatus;
		}
	}

	@Override
	public void setClaimStatus(String claimStatus) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_claimStatus = claimStatus;
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
	public CLMSTATUS toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CLMSTATUS>
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
		CLMSTATUSImpl clmstatusImpl = new CLMSTATUSImpl();

		clmstatusImpl.setRefNo(getRefNo());
		clmstatusImpl.setClaimStatus(getClaimStatus());

		clmstatusImpl.resetOriginalValues();

		return clmstatusImpl;
	}

	@Override
	public int compareTo(CLMSTATUS clmstatus) {
		String primaryKey = clmstatus.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CLMSTATUS)) {
			return false;
		}

		CLMSTATUS clmstatus = (CLMSTATUS)object;

		String primaryKey = clmstatus.getPrimaryKey();

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
	public CacheModel<CLMSTATUS> toCacheModel() {
		CLMSTATUSCacheModel clmstatusCacheModel = new CLMSTATUSCacheModel();

		clmstatusCacheModel.RefNo = getRefNo();

		String RefNo = clmstatusCacheModel.RefNo;

		if ((RefNo != null) && (RefNo.length() == 0)) {
			clmstatusCacheModel.RefNo = null;
		}

		clmstatusCacheModel.claimStatus = getClaimStatus();

		String claimStatus = clmstatusCacheModel.claimStatus;

		if ((claimStatus != null) && (claimStatus.length() == 0)) {
			clmstatusCacheModel.claimStatus = null;
		}

		return clmstatusCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CLMSTATUS, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CLMSTATUS, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CLMSTATUS, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CLMSTATUS)this));
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
		Map<String, Function<CLMSTATUS, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CLMSTATUS, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CLMSTATUS, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CLMSTATUS)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CLMSTATUS>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _RefNo;
	private String _claimStatus;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CLMSTATUS, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CLMSTATUS)this);
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

		_columnOriginalValues.put("REFERENCE_NO", _RefNo);
		_columnOriginalValues.put("STATUS", _claimStatus);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("REFERENCE_NO", "RefNo");
		attributeNames.put("STATUS", "claimStatus");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("REFERENCE_NO", 1L);

		columnBitmasks.put("STATUS", 2L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CLMSTATUS _escapedModel;

}