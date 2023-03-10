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

import com.ejada.atmc.acl.db.model.PayFortRef;
import com.ejada.atmc.acl.db.model.PayFortRefModel;
import com.ejada.atmc.acl.db.model.PayFortRefSoap;

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
 * The base model implementation for the PayFortRef service. Represents a row in the &quot;PAYFORT_REF&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>PayFortRefModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PayFortRefImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayFortRefImpl
 * @generated
 */
@JSON(strict = true)
public class PayFortRefModelImpl
	extends BaseModelImpl<PayFortRef> implements PayFortRefModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a pay fort ref model instance should use the <code>PayFortRef</code> interface instead.
	 */
	public static final String TABLE_NAME = "PAYFORT_REF";

	public static final Object[][] TABLE_COLUMNS = {
		{"Id", Types.INTEGER}, {"IQAMA_ID", Types.VARCHAR},
		{"PAYFORT_REF_NO", Types.VARCHAR}, {"STATUS", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("Id", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("IQAMA_ID", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("PAYFORT_REF_NO", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("STATUS", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table PAYFORT_REF (Id INTEGER not null primary key,IQAMA_ID VARCHAR(75) null,PAYFORT_REF_NO VARCHAR(75) null,STATUS VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table PAYFORT_REF";

	public static final String ORDER_BY_JPQL = " ORDER BY payFortRef.id ASC";

	public static final String ORDER_BY_SQL = " ORDER BY PAYFORT_REF.Id ASC";

	public static final String DATA_SOURCE = "extDS";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long PAYFORTREFNO_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long STATUS_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long ID_COLUMN_BITMASK = 4L;

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
	public static PayFortRef toModel(PayFortRefSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		PayFortRef model = new PayFortRefImpl();

		model.setId(soapModel.getId());
		model.setIqama_id(soapModel.getIqama_id());
		model.setPayFortRefNo(soapModel.getPayFortRefNo());
		model.setStatus(soapModel.getStatus());

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
	public static List<PayFortRef> toModels(PayFortRefSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<PayFortRef> models = new ArrayList<PayFortRef>(soapModels.length);

		for (PayFortRefSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public PayFortRefModelImpl() {
	}

	@Override
	public int getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PayFortRef.class;
	}

	@Override
	public String getModelClassName() {
		return PayFortRef.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<PayFortRef, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<PayFortRef, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PayFortRef, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((PayFortRef)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<PayFortRef, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<PayFortRef, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(PayFortRef)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<PayFortRef, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<PayFortRef, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, PayFortRef>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			PayFortRef.class.getClassLoader(), PayFortRef.class,
			ModelWrapper.class);

		try {
			Constructor<PayFortRef> constructor =
				(Constructor<PayFortRef>)proxyClass.getConstructor(
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

	private static final Map<String, Function<PayFortRef, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<PayFortRef, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<PayFortRef, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<PayFortRef, Object>>();
		Map<String, BiConsumer<PayFortRef, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<PayFortRef, ?>>();

		attributeGetterFunctions.put("id", PayFortRef::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<PayFortRef, Integer>)PayFortRef::setId);
		attributeGetterFunctions.put("iqama_id", PayFortRef::getIqama_id);
		attributeSetterBiConsumers.put(
			"iqama_id",
			(BiConsumer<PayFortRef, String>)PayFortRef::setIqama_id);
		attributeGetterFunctions.put(
			"payFortRefNo", PayFortRef::getPayFortRefNo);
		attributeSetterBiConsumers.put(
			"payFortRefNo",
			(BiConsumer<PayFortRef, String>)PayFortRef::setPayFortRefNo);
		attributeGetterFunctions.put("status", PayFortRef::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<PayFortRef, String>)PayFortRef::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public int getId() {
		return _id;
	}

	@Override
	public void setId(int id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_id = id;
	}

	@JSON
	@Override
	public String getIqama_id() {
		if (_iqama_id == null) {
			return "";
		}
		else {
			return _iqama_id;
		}
	}

	@Override
	public void setIqama_id(String iqama_id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_iqama_id = iqama_id;
	}

	@JSON
	@Override
	public String getPayFortRefNo() {
		if (_payFortRefNo == null) {
			return "";
		}
		else {
			return _payFortRefNo;
		}
	}

	@Override
	public void setPayFortRefNo(String payFortRefNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_payFortRefNo = payFortRefNo;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalPayFortRefNo() {
		return getColumnOriginalValue("PAYFORT_REF_NO");
	}

	@JSON
	@Override
	public String getStatus() {
		if (_status == null) {
			return "";
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalStatus() {
		return getColumnOriginalValue("STATUS");
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
	public PayFortRef toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, PayFortRef>
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
		PayFortRefImpl payFortRefImpl = new PayFortRefImpl();

		payFortRefImpl.setId(getId());
		payFortRefImpl.setIqama_id(getIqama_id());
		payFortRefImpl.setPayFortRefNo(getPayFortRefNo());
		payFortRefImpl.setStatus(getStatus());

		payFortRefImpl.resetOriginalValues();

		return payFortRefImpl;
	}

	@Override
	public int compareTo(PayFortRef payFortRef) {
		int primaryKey = payFortRef.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PayFortRef)) {
			return false;
		}

		PayFortRef payFortRef = (PayFortRef)object;

		int primaryKey = payFortRef.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
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
	public CacheModel<PayFortRef> toCacheModel() {
		PayFortRefCacheModel payFortRefCacheModel = new PayFortRefCacheModel();

		payFortRefCacheModel.id = getId();

		payFortRefCacheModel.iqama_id = getIqama_id();

		String iqama_id = payFortRefCacheModel.iqama_id;

		if ((iqama_id != null) && (iqama_id.length() == 0)) {
			payFortRefCacheModel.iqama_id = null;
		}

		payFortRefCacheModel.payFortRefNo = getPayFortRefNo();

		String payFortRefNo = payFortRefCacheModel.payFortRefNo;

		if ((payFortRefNo != null) && (payFortRefNo.length() == 0)) {
			payFortRefCacheModel.payFortRefNo = null;
		}

		payFortRefCacheModel.status = getStatus();

		String status = payFortRefCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			payFortRefCacheModel.status = null;
		}

		return payFortRefCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<PayFortRef, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<PayFortRef, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PayFortRef, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((PayFortRef)this));
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
		Map<String, Function<PayFortRef, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<PayFortRef, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PayFortRef, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((PayFortRef)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, PayFortRef>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private int _id;
	private String _iqama_id;
	private String _payFortRefNo;
	private String _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<PayFortRef, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((PayFortRef)this);
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

		_columnOriginalValues.put("Id", _id);
		_columnOriginalValues.put("IQAMA_ID", _iqama_id);
		_columnOriginalValues.put("PAYFORT_REF_NO", _payFortRefNo);
		_columnOriginalValues.put("STATUS", _status);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("Id", "id");
		attributeNames.put("IQAMA_ID", "iqama_id");
		attributeNames.put("PAYFORT_REF_NO", "payFortRefNo");
		attributeNames.put("STATUS", "status");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("Id", 1L);

		columnBitmasks.put("IQAMA_ID", 2L);

		columnBitmasks.put("PAYFORT_REF_NO", 4L);

		columnBitmasks.put("STATUS", 8L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private PayFortRef _escapedModel;

}