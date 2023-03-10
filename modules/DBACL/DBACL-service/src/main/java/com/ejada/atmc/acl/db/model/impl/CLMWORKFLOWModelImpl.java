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

import com.ejada.atmc.acl.db.model.CLMWORKFLOW;
import com.ejada.atmc.acl.db.model.CLMWORKFLOWModel;
import com.ejada.atmc.acl.db.model.CLMWORKFLOWSoap;

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
 * The base model implementation for the CLMWORKFLOW service. Represents a row in the &quot;EJD_CLAIMS_WORKFLOW&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CLMWORKFLOWModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CLMWORKFLOWImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CLMWORKFLOWImpl
 * @generated
 */
@JSON(strict = true)
public class CLMWORKFLOWModelImpl
	extends BaseModelImpl<CLMWORKFLOW> implements CLMWORKFLOWModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a clmworkflow model instance should use the <code>CLMWORKFLOW</code> interface instead.
	 */
	public static final String TABLE_NAME = "EJD_CLAIMS_WORKFLOW";

	public static final Object[][] TABLE_COLUMNS = {
		{"ID", Types.INTEGER}, {"ROLE", Types.VARCHAR},
		{"INITIAL_STATUS", Types.VARCHAR}, {"ACTION", Types.VARCHAR},
		{"NEW_STATUS", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("ID", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("ROLE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("INITIAL_STATUS", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ACTION", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("NEW_STATUS", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table EJD_CLAIMS_WORKFLOW (ID INTEGER not null primary key,ROLE VARCHAR(75) null,INITIAL_STATUS VARCHAR(75) null,ACTION VARCHAR(75) null,NEW_STATUS VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table EJD_CLAIMS_WORKFLOW";

	public static final String ORDER_BY_JPQL = " ORDER BY clmworkflow.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY EJD_CLAIMS_WORKFLOW.ID ASC";

	public static final String DATA_SOURCE = "extDS";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long INITIALSTATUS_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long ROLE_COLUMN_BITMASK = 2L;

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
	public static CLMWORKFLOW toModel(CLMWORKFLOWSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CLMWORKFLOW model = new CLMWORKFLOWImpl();

		model.setId(soapModel.getId());
		model.setRole(soapModel.getRole());
		model.setInitialStatus(soapModel.getInitialStatus());
		model.setAction(soapModel.getAction());
		model.setNewStatus(soapModel.getNewStatus());

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
	public static List<CLMWORKFLOW> toModels(CLMWORKFLOWSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CLMWORKFLOW> models = new ArrayList<CLMWORKFLOW>(
			soapModels.length);

		for (CLMWORKFLOWSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CLMWORKFLOWModelImpl() {
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
		return CLMWORKFLOW.class;
	}

	@Override
	public String getModelClassName() {
		return CLMWORKFLOW.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CLMWORKFLOW, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CLMWORKFLOW, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CLMWORKFLOW, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CLMWORKFLOW)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CLMWORKFLOW, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CLMWORKFLOW, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CLMWORKFLOW)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CLMWORKFLOW, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CLMWORKFLOW, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CLMWORKFLOW>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CLMWORKFLOW.class.getClassLoader(), CLMWORKFLOW.class,
			ModelWrapper.class);

		try {
			Constructor<CLMWORKFLOW> constructor =
				(Constructor<CLMWORKFLOW>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CLMWORKFLOW, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CLMWORKFLOW, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CLMWORKFLOW, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CLMWORKFLOW, Object>>();
		Map<String, BiConsumer<CLMWORKFLOW, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CLMWORKFLOW, ?>>();

		attributeGetterFunctions.put("id", CLMWORKFLOW::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<CLMWORKFLOW, Integer>)CLMWORKFLOW::setId);
		attributeGetterFunctions.put("role", CLMWORKFLOW::getRole);
		attributeSetterBiConsumers.put(
			"role", (BiConsumer<CLMWORKFLOW, String>)CLMWORKFLOW::setRole);
		attributeGetterFunctions.put(
			"initialStatus", CLMWORKFLOW::getInitialStatus);
		attributeSetterBiConsumers.put(
			"initialStatus",
			(BiConsumer<CLMWORKFLOW, String>)CLMWORKFLOW::setInitialStatus);
		attributeGetterFunctions.put("action", CLMWORKFLOW::getAction);
		attributeSetterBiConsumers.put(
			"action", (BiConsumer<CLMWORKFLOW, String>)CLMWORKFLOW::setAction);
		attributeGetterFunctions.put("newStatus", CLMWORKFLOW::getNewStatus);
		attributeSetterBiConsumers.put(
			"newStatus",
			(BiConsumer<CLMWORKFLOW, String>)CLMWORKFLOW::setNewStatus);

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
	public String getRole() {
		if (_role == null) {
			return "";
		}
		else {
			return _role;
		}
	}

	@Override
	public void setRole(String role) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_role = role;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalRole() {
		return getColumnOriginalValue("ROLE");
	}

	@JSON
	@Override
	public String getInitialStatus() {
		if (_initialStatus == null) {
			return "";
		}
		else {
			return _initialStatus;
		}
	}

	@Override
	public void setInitialStatus(String initialStatus) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_initialStatus = initialStatus;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalInitialStatus() {
		return getColumnOriginalValue("INITIAL_STATUS");
	}

	@JSON
	@Override
	public String getAction() {
		if (_action == null) {
			return "";
		}
		else {
			return _action;
		}
	}

	@Override
	public void setAction(String action) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_action = action;
	}

	@JSON
	@Override
	public String getNewStatus() {
		if (_newStatus == null) {
			return "";
		}
		else {
			return _newStatus;
		}
	}

	@Override
	public void setNewStatus(String newStatus) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_newStatus = newStatus;
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
	public CLMWORKFLOW toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CLMWORKFLOW>
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
		CLMWORKFLOWImpl clmworkflowImpl = new CLMWORKFLOWImpl();

		clmworkflowImpl.setId(getId());
		clmworkflowImpl.setRole(getRole());
		clmworkflowImpl.setInitialStatus(getInitialStatus());
		clmworkflowImpl.setAction(getAction());
		clmworkflowImpl.setNewStatus(getNewStatus());

		clmworkflowImpl.resetOriginalValues();

		return clmworkflowImpl;
	}

	@Override
	public int compareTo(CLMWORKFLOW clmworkflow) {
		int primaryKey = clmworkflow.getPrimaryKey();

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

		if (!(object instanceof CLMWORKFLOW)) {
			return false;
		}

		CLMWORKFLOW clmworkflow = (CLMWORKFLOW)object;

		int primaryKey = clmworkflow.getPrimaryKey();

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
	public CacheModel<CLMWORKFLOW> toCacheModel() {
		CLMWORKFLOWCacheModel clmworkflowCacheModel =
			new CLMWORKFLOWCacheModel();

		clmworkflowCacheModel.id = getId();

		clmworkflowCacheModel.role = getRole();

		String role = clmworkflowCacheModel.role;

		if ((role != null) && (role.length() == 0)) {
			clmworkflowCacheModel.role = null;
		}

		clmworkflowCacheModel.initialStatus = getInitialStatus();

		String initialStatus = clmworkflowCacheModel.initialStatus;

		if ((initialStatus != null) && (initialStatus.length() == 0)) {
			clmworkflowCacheModel.initialStatus = null;
		}

		clmworkflowCacheModel.action = getAction();

		String action = clmworkflowCacheModel.action;

		if ((action != null) && (action.length() == 0)) {
			clmworkflowCacheModel.action = null;
		}

		clmworkflowCacheModel.newStatus = getNewStatus();

		String newStatus = clmworkflowCacheModel.newStatus;

		if ((newStatus != null) && (newStatus.length() == 0)) {
			clmworkflowCacheModel.newStatus = null;
		}

		return clmworkflowCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CLMWORKFLOW, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CLMWORKFLOW, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CLMWORKFLOW, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CLMWORKFLOW)this));
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
		Map<String, Function<CLMWORKFLOW, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CLMWORKFLOW, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CLMWORKFLOW, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CLMWORKFLOW)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CLMWORKFLOW>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private int _id;
	private String _role;
	private String _initialStatus;
	private String _action;
	private String _newStatus;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CLMWORKFLOW, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CLMWORKFLOW)this);
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

		_columnOriginalValues.put("ID", _id);
		_columnOriginalValues.put("ROLE", _role);
		_columnOriginalValues.put("INITIAL_STATUS", _initialStatus);
		_columnOriginalValues.put("ACTION", _action);
		_columnOriginalValues.put("NEW_STATUS", _newStatus);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("ID", "id");
		attributeNames.put("ROLE", "role");
		attributeNames.put("INITIAL_STATUS", "initialStatus");
		attributeNames.put("ACTION", "action");
		attributeNames.put("NEW_STATUS", "newStatus");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("ID", 1L);

		columnBitmasks.put("ROLE", 2L);

		columnBitmasks.put("INITIAL_STATUS", 4L);

		columnBitmasks.put("ACTION", 8L);

		columnBitmasks.put("NEW_STATUS", 16L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CLMWORKFLOW _escapedModel;

}