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

import com.ejada.atmc.acl.db.model.CLMSTATUSHISTORY;
import com.ejada.atmc.acl.db.model.CLMSTATUSHISTORYModel;
import com.ejada.atmc.acl.db.model.CLMSTATUSHISTORYSoap;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.DateUtil;
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
 * The base model implementation for the CLMSTATUSHISTORY service. Represents a row in the &quot;EJD_CLAIMS_STATUS_HISTORY&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CLMSTATUSHISTORYModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CLMSTATUSHISTORYImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CLMSTATUSHISTORYImpl
 * @generated
 */
@JSON(strict = true)
public class CLMSTATUSHISTORYModelImpl
	extends BaseModelImpl<CLMSTATUSHISTORY> implements CLMSTATUSHISTORYModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a clmstatushistory model instance should use the <code>CLMSTATUSHISTORY</code> interface instead.
	 */
	public static final String TABLE_NAME = "EJD_CLAIMS_STATUS_HISTORY";

	public static final Object[][] TABLE_COLUMNS = {
		{"HISTORY_ID", Types.INTEGER}, {"REFERENCE_NO", Types.VARCHAR},
		{"HISTORY_DATE", Types.TIMESTAMP}, {"USER_NAME", Types.VARCHAR},
		{"STATUS", Types.VARCHAR}, {"REASON", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("HISTORY_ID", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("REFERENCE_NO", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("HISTORY_DATE", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("USER_NAME", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("STATUS", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("REASON", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table EJD_CLAIMS_STATUS_HISTORY (HISTORY_ID INTEGER not null primary key,REFERENCE_NO VARCHAR(75) null,HISTORY_DATE DATE null,USER_NAME VARCHAR(75) null,STATUS VARCHAR(75) null,REASON VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table EJD_CLAIMS_STATUS_HISTORY";

	public static final String ORDER_BY_JPQL =
		" ORDER BY clmstatushistory.date DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY EJD_CLAIMS_STATUS_HISTORY.HISTORY_DATE DESC";

	public static final String DATA_SOURCE = "extDS";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long REFNO_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long DATE_COLUMN_BITMASK = 2L;

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
	public static CLMSTATUSHISTORY toModel(CLMSTATUSHISTORYSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CLMSTATUSHISTORY model = new CLMSTATUSHISTORYImpl();

		model.setId(soapModel.getId());
		model.setRefNo(soapModel.getRefNo());
		model.setDate(soapModel.getDate());
		model.setUserName(soapModel.getUserName());
		model.setClaimStatus(soapModel.getClaimStatus());
		model.setReason(soapModel.getReason());

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
	public static List<CLMSTATUSHISTORY> toModels(
		CLMSTATUSHISTORYSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CLMSTATUSHISTORY> models = new ArrayList<CLMSTATUSHISTORY>(
			soapModels.length);

		for (CLMSTATUSHISTORYSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CLMSTATUSHISTORYModelImpl() {
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
		return CLMSTATUSHISTORY.class;
	}

	@Override
	public String getModelClassName() {
		return CLMSTATUSHISTORY.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CLMSTATUSHISTORY, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CLMSTATUSHISTORY, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CLMSTATUSHISTORY, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CLMSTATUSHISTORY)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CLMSTATUSHISTORY, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CLMSTATUSHISTORY, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CLMSTATUSHISTORY)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CLMSTATUSHISTORY, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CLMSTATUSHISTORY, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CLMSTATUSHISTORY>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CLMSTATUSHISTORY.class.getClassLoader(), CLMSTATUSHISTORY.class,
			ModelWrapper.class);

		try {
			Constructor<CLMSTATUSHISTORY> constructor =
				(Constructor<CLMSTATUSHISTORY>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CLMSTATUSHISTORY, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CLMSTATUSHISTORY, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CLMSTATUSHISTORY, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<CLMSTATUSHISTORY, Object>>();
		Map<String, BiConsumer<CLMSTATUSHISTORY, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<CLMSTATUSHISTORY, ?>>();

		attributeGetterFunctions.put("id", CLMSTATUSHISTORY::getId);
		attributeSetterBiConsumers.put(
			"id",
			(BiConsumer<CLMSTATUSHISTORY, Integer>)CLMSTATUSHISTORY::setId);
		attributeGetterFunctions.put("RefNo", CLMSTATUSHISTORY::getRefNo);
		attributeSetterBiConsumers.put(
			"RefNo",
			(BiConsumer<CLMSTATUSHISTORY, String>)CLMSTATUSHISTORY::setRefNo);
		attributeGetterFunctions.put("date", CLMSTATUSHISTORY::getDate);
		attributeSetterBiConsumers.put(
			"date",
			(BiConsumer<CLMSTATUSHISTORY, Date>)CLMSTATUSHISTORY::setDate);
		attributeGetterFunctions.put("userName", CLMSTATUSHISTORY::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CLMSTATUSHISTORY, String>)
				CLMSTATUSHISTORY::setUserName);
		attributeGetterFunctions.put(
			"claimStatus", CLMSTATUSHISTORY::getClaimStatus);
		attributeSetterBiConsumers.put(
			"claimStatus",
			(BiConsumer<CLMSTATUSHISTORY, String>)
				CLMSTATUSHISTORY::setClaimStatus);
		attributeGetterFunctions.put("reason", CLMSTATUSHISTORY::getReason);
		attributeSetterBiConsumers.put(
			"reason",
			(BiConsumer<CLMSTATUSHISTORY, String>)CLMSTATUSHISTORY::setReason);

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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalRefNo() {
		return getColumnOriginalValue("REFERENCE_NO");
	}

	@JSON
	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_date = date;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
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

	@JSON
	@Override
	public String getReason() {
		if (_reason == null) {
			return "";
		}
		else {
			return _reason;
		}
	}

	@Override
	public void setReason(String reason) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_reason = reason;
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
	public CLMSTATUSHISTORY toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CLMSTATUSHISTORY>
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
		CLMSTATUSHISTORYImpl clmstatushistoryImpl = new CLMSTATUSHISTORYImpl();

		clmstatushistoryImpl.setId(getId());
		clmstatushistoryImpl.setRefNo(getRefNo());
		clmstatushistoryImpl.setDate(getDate());
		clmstatushistoryImpl.setUserName(getUserName());
		clmstatushistoryImpl.setClaimStatus(getClaimStatus());
		clmstatushistoryImpl.setReason(getReason());

		clmstatushistoryImpl.resetOriginalValues();

		return clmstatushistoryImpl;
	}

	@Override
	public int compareTo(CLMSTATUSHISTORY clmstatushistory) {
		int value = 0;

		value = DateUtil.compareTo(getDate(), clmstatushistory.getDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CLMSTATUSHISTORY)) {
			return false;
		}

		CLMSTATUSHISTORY clmstatushistory = (CLMSTATUSHISTORY)object;

		int primaryKey = clmstatushistory.getPrimaryKey();

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
	public CacheModel<CLMSTATUSHISTORY> toCacheModel() {
		CLMSTATUSHISTORYCacheModel clmstatushistoryCacheModel =
			new CLMSTATUSHISTORYCacheModel();

		clmstatushistoryCacheModel.id = getId();

		clmstatushistoryCacheModel.RefNo = getRefNo();

		String RefNo = clmstatushistoryCacheModel.RefNo;

		if ((RefNo != null) && (RefNo.length() == 0)) {
			clmstatushistoryCacheModel.RefNo = null;
		}

		Date date = getDate();

		if (date != null) {
			clmstatushistoryCacheModel.date = date.getTime();
		}
		else {
			clmstatushistoryCacheModel.date = Long.MIN_VALUE;
		}

		clmstatushistoryCacheModel.userName = getUserName();

		String userName = clmstatushistoryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			clmstatushistoryCacheModel.userName = null;
		}

		clmstatushistoryCacheModel.claimStatus = getClaimStatus();

		String claimStatus = clmstatushistoryCacheModel.claimStatus;

		if ((claimStatus != null) && (claimStatus.length() == 0)) {
			clmstatushistoryCacheModel.claimStatus = null;
		}

		clmstatushistoryCacheModel.reason = getReason();

		String reason = clmstatushistoryCacheModel.reason;

		if ((reason != null) && (reason.length() == 0)) {
			clmstatushistoryCacheModel.reason = null;
		}

		return clmstatushistoryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CLMSTATUSHISTORY, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CLMSTATUSHISTORY, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CLMSTATUSHISTORY, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CLMSTATUSHISTORY)this));
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
		Map<String, Function<CLMSTATUSHISTORY, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CLMSTATUSHISTORY, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CLMSTATUSHISTORY, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CLMSTATUSHISTORY)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CLMSTATUSHISTORY>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private int _id;
	private String _RefNo;
	private Date _date;
	private String _userName;
	private String _claimStatus;
	private String _reason;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CLMSTATUSHISTORY, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CLMSTATUSHISTORY)this);
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

		_columnOriginalValues.put("HISTORY_ID", _id);
		_columnOriginalValues.put("REFERENCE_NO", _RefNo);
		_columnOriginalValues.put("HISTORY_DATE", _date);
		_columnOriginalValues.put("USER_NAME", _userName);
		_columnOriginalValues.put("STATUS", _claimStatus);
		_columnOriginalValues.put("REASON", _reason);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("HISTORY_ID", "id");
		attributeNames.put("REFERENCE_NO", "RefNo");
		attributeNames.put("HISTORY_DATE", "date");
		attributeNames.put("USER_NAME", "userName");
		attributeNames.put("STATUS", "claimStatus");
		attributeNames.put("REASON", "reason");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("HISTORY_ID", 1L);

		columnBitmasks.put("REFERENCE_NO", 2L);

		columnBitmasks.put("HISTORY_DATE", 4L);

		columnBitmasks.put("USER_NAME", 8L);

		columnBitmasks.put("STATUS", 16L);

		columnBitmasks.put("REASON", 32L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CLMSTATUSHISTORY _escapedModel;

}