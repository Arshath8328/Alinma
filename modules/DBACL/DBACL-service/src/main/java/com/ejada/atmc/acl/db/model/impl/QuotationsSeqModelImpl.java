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

import com.ejada.atmc.acl.db.model.QuotationsSeq;
import com.ejada.atmc.acl.db.model.QuotationsSeqModel;
import com.ejada.atmc.acl.db.model.QuotationsSeqSoap;

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
 * The base model implementation for the QuotationsSeq service. Represents a row in the &quot;EJD_QUOTATIONS_SEQ&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>QuotationsSeqModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link QuotationsSeqImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsSeqImpl
 * @generated
 */
@JSON(strict = true)
public class QuotationsSeqModelImpl
	extends BaseModelImpl<QuotationsSeq> implements QuotationsSeqModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a quotations seq model instance should use the <code>QuotationsSeq</code> interface instead.
	 */
	public static final String TABLE_NAME = "EJD_QUOTATIONS_SEQ";

	public static final Object[][] TABLE_COLUMNS = {
		{"KEY", Types.VARCHAR}, {"VALUE", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("KEY", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("VALUE", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table EJD_QUOTATIONS_SEQ (KEY VARCHAR(75) not null primary key,VALUE VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table EJD_QUOTATIONS_SEQ";

	public static final String ORDER_BY_JPQL =
		" ORDER BY quotationsSeq.key ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY EJD_QUOTATIONS_SEQ.KEY ASC";

	public static final String DATA_SOURCE = "extDS";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long KEY_COLUMN_BITMASK = 1L;

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
	public static QuotationsSeq toModel(QuotationsSeqSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		QuotationsSeq model = new QuotationsSeqImpl();

		model.setKey(soapModel.getKey());
		model.setValue(soapModel.getValue());

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
	public static List<QuotationsSeq> toModels(QuotationsSeqSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<QuotationsSeq> models = new ArrayList<QuotationsSeq>(
			soapModels.length);

		for (QuotationsSeqSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public QuotationsSeqModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _key;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setKey(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _key;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return QuotationsSeq.class;
	}

	@Override
	public String getModelClassName() {
		return QuotationsSeq.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<QuotationsSeq, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<QuotationsSeq, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<QuotationsSeq, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((QuotationsSeq)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<QuotationsSeq, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<QuotationsSeq, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(QuotationsSeq)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<QuotationsSeq, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<QuotationsSeq, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, QuotationsSeq>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			QuotationsSeq.class.getClassLoader(), QuotationsSeq.class,
			ModelWrapper.class);

		try {
			Constructor<QuotationsSeq> constructor =
				(Constructor<QuotationsSeq>)proxyClass.getConstructor(
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

	private static final Map<String, Function<QuotationsSeq, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<QuotationsSeq, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<QuotationsSeq, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<QuotationsSeq, Object>>();
		Map<String, BiConsumer<QuotationsSeq, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<QuotationsSeq, ?>>();

		attributeGetterFunctions.put("key", QuotationsSeq::getKey);
		attributeSetterBiConsumers.put(
			"key", (BiConsumer<QuotationsSeq, String>)QuotationsSeq::setKey);
		attributeGetterFunctions.put("value", QuotationsSeq::getValue);
		attributeSetterBiConsumers.put(
			"value",
			(BiConsumer<QuotationsSeq, String>)QuotationsSeq::setValue);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getKey() {
		if (_key == null) {
			return "";
		}
		else {
			return _key;
		}
	}

	@Override
	public void setKey(String key) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_key = key;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalKey() {
		return getColumnOriginalValue("KEY");
	}

	@JSON
	@Override
	public String getValue() {
		if (_value == null) {
			return "";
		}
		else {
			return _value;
		}
	}

	@Override
	public void setValue(String value) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_value = value;
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
	public QuotationsSeq toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, QuotationsSeq>
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
		QuotationsSeqImpl quotationsSeqImpl = new QuotationsSeqImpl();

		quotationsSeqImpl.setKey(getKey());
		quotationsSeqImpl.setValue(getValue());

		quotationsSeqImpl.resetOriginalValues();

		return quotationsSeqImpl;
	}

	@Override
	public int compareTo(QuotationsSeq quotationsSeq) {
		String primaryKey = quotationsSeq.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof QuotationsSeq)) {
			return false;
		}

		QuotationsSeq quotationsSeq = (QuotationsSeq)object;

		String primaryKey = quotationsSeq.getPrimaryKey();

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
	public CacheModel<QuotationsSeq> toCacheModel() {
		QuotationsSeqCacheModel quotationsSeqCacheModel =
			new QuotationsSeqCacheModel();

		quotationsSeqCacheModel.key = getKey();

		String key = quotationsSeqCacheModel.key;

		if ((key != null) && (key.length() == 0)) {
			quotationsSeqCacheModel.key = null;
		}

		quotationsSeqCacheModel.value = getValue();

		String value = quotationsSeqCacheModel.value;

		if ((value != null) && (value.length() == 0)) {
			quotationsSeqCacheModel.value = null;
		}

		return quotationsSeqCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<QuotationsSeq, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<QuotationsSeq, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<QuotationsSeq, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((QuotationsSeq)this));
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
		Map<String, Function<QuotationsSeq, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<QuotationsSeq, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<QuotationsSeq, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((QuotationsSeq)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, QuotationsSeq>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _key;
	private String _value;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<QuotationsSeq, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((QuotationsSeq)this);
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

		_columnOriginalValues.put("KEY", _key);
		_columnOriginalValues.put("VALUE", _value);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("KEY", "key");
		attributeNames.put("VALUE", "value");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("KEY", 1L);

		columnBitmasks.put("VALUE", 2L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private QuotationsSeq _escapedModel;

}