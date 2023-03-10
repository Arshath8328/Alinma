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

import com.ejada.atmc.acl.db.model.QuotationsDriverLicense;
import com.ejada.atmc.acl.db.model.QuotationsDriverLicenseModel;
import com.ejada.atmc.acl.db.model.QuotationsDriverLicenseSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
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
 * The base model implementation for the QuotationsDriverLicense service. Represents a row in the &quot;EJD_QUOTATIONS_DRIVER_LICENSE&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>QuotationsDriverLicenseModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link QuotationsDriverLicenseImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsDriverLicenseImpl
 * @generated
 */
@JSON(strict = true)
public class QuotationsDriverLicenseModelImpl
	extends BaseModelImpl<QuotationsDriverLicense>
	implements QuotationsDriverLicenseModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a quotations driver license model instance should use the <code>QuotationsDriverLicense</code> interface instead.
	 */
	public static final String TABLE_NAME = "EJD_QUOTATIONS_DRIVER_LICENSE";

	public static final Object[][] TABLE_COLUMNS = {
		{"LICENSE_ID", Types.BIGINT}, {"DRIVER_ID", Types.BIGINT},
		{"QUOTATIONS_ID", Types.BIGINT}, {"LICENSE_COUNTRY", Types.VARCHAR},
		{"LICENSE_TYPE", Types.VARCHAR}, {"LICENSE_YEARS", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("LICENSE_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("DRIVER_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("QUOTATIONS_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("LICENSE_COUNTRY", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("LICENSE_TYPE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("LICENSE_YEARS", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table EJD_QUOTATIONS_DRIVER_LICENSE (LICENSE_ID LONG not null primary key,DRIVER_ID LONG,QUOTATIONS_ID LONG,LICENSE_COUNTRY VARCHAR(75) null,LICENSE_TYPE VARCHAR(75) null,LICENSE_YEARS INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table EJD_QUOTATIONS_DRIVER_LICENSE";

	public static final String ORDER_BY_JPQL =
		" ORDER BY quotationsDriverLicense.licenseId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY EJD_QUOTATIONS_DRIVER_LICENSE.LICENSE_ID ASC";

	public static final String DATA_SOURCE = "extDS";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long DRIVERID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long QUOTATIONID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long LICENSEID_COLUMN_BITMASK = 4L;

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
	public static QuotationsDriverLicense toModel(
		QuotationsDriverLicenseSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		QuotationsDriverLicense model = new QuotationsDriverLicenseImpl();

		model.setLicenseId(soapModel.getLicenseId());
		model.setDriverId(soapModel.getDriverId());
		model.setQuotationId(soapModel.getQuotationId());
		model.setLicCountry(soapModel.getLicCountry());
		model.setLicType(soapModel.getLicType());
		model.setLicYrs(soapModel.getLicYrs());

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
	public static List<QuotationsDriverLicense> toModels(
		QuotationsDriverLicenseSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<QuotationsDriverLicense> models =
			new ArrayList<QuotationsDriverLicense>(soapModels.length);

		for (QuotationsDriverLicenseSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public QuotationsDriverLicenseModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _licenseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLicenseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _licenseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return QuotationsDriverLicense.class;
	}

	@Override
	public String getModelClassName() {
		return QuotationsDriverLicense.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<QuotationsDriverLicense, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<QuotationsDriverLicense, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<QuotationsDriverLicense, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((QuotationsDriverLicense)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<QuotationsDriverLicense, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<QuotationsDriverLicense, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(QuotationsDriverLicense)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<QuotationsDriverLicense, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<QuotationsDriverLicense, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, QuotationsDriverLicense>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			QuotationsDriverLicense.class.getClassLoader(),
			QuotationsDriverLicense.class, ModelWrapper.class);

		try {
			Constructor<QuotationsDriverLicense> constructor =
				(Constructor<QuotationsDriverLicense>)proxyClass.getConstructor(
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

	private static final Map<String, Function<QuotationsDriverLicense, Object>>
		_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<QuotationsDriverLicense, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<QuotationsDriverLicense, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<QuotationsDriverLicense, Object>>();
		Map<String, BiConsumer<QuotationsDriverLicense, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<QuotationsDriverLicense, ?>>();

		attributeGetterFunctions.put(
			"licenseId", QuotationsDriverLicense::getLicenseId);
		attributeSetterBiConsumers.put(
			"licenseId",
			(BiConsumer<QuotationsDriverLicense, Long>)
				QuotationsDriverLicense::setLicenseId);
		attributeGetterFunctions.put(
			"driverId", QuotationsDriverLicense::getDriverId);
		attributeSetterBiConsumers.put(
			"driverId",
			(BiConsumer<QuotationsDriverLicense, Long>)
				QuotationsDriverLicense::setDriverId);
		attributeGetterFunctions.put(
			"quotationId", QuotationsDriverLicense::getQuotationId);
		attributeSetterBiConsumers.put(
			"quotationId",
			(BiConsumer<QuotationsDriverLicense, Long>)
				QuotationsDriverLicense::setQuotationId);
		attributeGetterFunctions.put(
			"LicCountry", QuotationsDriverLicense::getLicCountry);
		attributeSetterBiConsumers.put(
			"LicCountry",
			(BiConsumer<QuotationsDriverLicense, String>)
				QuotationsDriverLicense::setLicCountry);
		attributeGetterFunctions.put(
			"LicType", QuotationsDriverLicense::getLicType);
		attributeSetterBiConsumers.put(
			"LicType",
			(BiConsumer<QuotationsDriverLicense, String>)
				QuotationsDriverLicense::setLicType);
		attributeGetterFunctions.put(
			"LicYrs", QuotationsDriverLicense::getLicYrs);
		attributeSetterBiConsumers.put(
			"LicYrs",
			(BiConsumer<QuotationsDriverLicense, Integer>)
				QuotationsDriverLicense::setLicYrs);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getLicenseId() {
		return _licenseId;
	}

	@Override
	public void setLicenseId(long licenseId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_licenseId = licenseId;
	}

	@JSON
	@Override
	public long getDriverId() {
		return _driverId;
	}

	@Override
	public void setDriverId(long driverId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_driverId = driverId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalDriverId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("DRIVER_ID"));
	}

	@JSON
	@Override
	public long getQuotationId() {
		return _quotationId;
	}

	@Override
	public void setQuotationId(long quotationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_quotationId = quotationId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalQuotationId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("QUOTATIONS_ID"));
	}

	@JSON
	@Override
	public String getLicCountry() {
		if (_LicCountry == null) {
			return "";
		}
		else {
			return _LicCountry;
		}
	}

	@Override
	public void setLicCountry(String LicCountry) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_LicCountry = LicCountry;
	}

	@JSON
	@Override
	public String getLicType() {
		if (_LicType == null) {
			return "";
		}
		else {
			return _LicType;
		}
	}

	@Override
	public void setLicType(String LicType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_LicType = LicType;
	}

	@JSON
	@Override
	public int getLicYrs() {
		return _LicYrs;
	}

	@Override
	public void setLicYrs(int LicYrs) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_LicYrs = LicYrs;
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
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, QuotationsDriverLicense.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public QuotationsDriverLicense toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, QuotationsDriverLicense>
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
		QuotationsDriverLicenseImpl quotationsDriverLicenseImpl =
			new QuotationsDriverLicenseImpl();

		quotationsDriverLicenseImpl.setLicenseId(getLicenseId());
		quotationsDriverLicenseImpl.setDriverId(getDriverId());
		quotationsDriverLicenseImpl.setQuotationId(getQuotationId());
		quotationsDriverLicenseImpl.setLicCountry(getLicCountry());
		quotationsDriverLicenseImpl.setLicType(getLicType());
		quotationsDriverLicenseImpl.setLicYrs(getLicYrs());

		quotationsDriverLicenseImpl.resetOriginalValues();

		return quotationsDriverLicenseImpl;
	}

	@Override
	public int compareTo(QuotationsDriverLicense quotationsDriverLicense) {
		long primaryKey = quotationsDriverLicense.getPrimaryKey();

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

		if (!(object instanceof QuotationsDriverLicense)) {
			return false;
		}

		QuotationsDriverLicense quotationsDriverLicense =
			(QuotationsDriverLicense)object;

		long primaryKey = quotationsDriverLicense.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
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
	public CacheModel<QuotationsDriverLicense> toCacheModel() {
		QuotationsDriverLicenseCacheModel quotationsDriverLicenseCacheModel =
			new QuotationsDriverLicenseCacheModel();

		quotationsDriverLicenseCacheModel.licenseId = getLicenseId();

		quotationsDriverLicenseCacheModel.driverId = getDriverId();

		quotationsDriverLicenseCacheModel.quotationId = getQuotationId();

		quotationsDriverLicenseCacheModel.LicCountry = getLicCountry();

		String LicCountry = quotationsDriverLicenseCacheModel.LicCountry;

		if ((LicCountry != null) && (LicCountry.length() == 0)) {
			quotationsDriverLicenseCacheModel.LicCountry = null;
		}

		quotationsDriverLicenseCacheModel.LicType = getLicType();

		String LicType = quotationsDriverLicenseCacheModel.LicType;

		if ((LicType != null) && (LicType.length() == 0)) {
			quotationsDriverLicenseCacheModel.LicType = null;
		}

		quotationsDriverLicenseCacheModel.LicYrs = getLicYrs();

		return quotationsDriverLicenseCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<QuotationsDriverLicense, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<QuotationsDriverLicense, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<QuotationsDriverLicense, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((QuotationsDriverLicense)this));
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
		Map<String, Function<QuotationsDriverLicense, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<QuotationsDriverLicense, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<QuotationsDriverLicense, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((QuotationsDriverLicense)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, QuotationsDriverLicense>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private long _licenseId;
	private long _driverId;
	private long _quotationId;
	private String _LicCountry;
	private String _LicType;
	private int _LicYrs;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<QuotationsDriverLicense, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((QuotationsDriverLicense)this);
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

		_columnOriginalValues.put("LICENSE_ID", _licenseId);
		_columnOriginalValues.put("DRIVER_ID", _driverId);
		_columnOriginalValues.put("QUOTATIONS_ID", _quotationId);
		_columnOriginalValues.put("LICENSE_COUNTRY", _LicCountry);
		_columnOriginalValues.put("LICENSE_TYPE", _LicType);
		_columnOriginalValues.put("LICENSE_YEARS", _LicYrs);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("LICENSE_ID", "licenseId");
		attributeNames.put("DRIVER_ID", "driverId");
		attributeNames.put("QUOTATIONS_ID", "quotationId");
		attributeNames.put("LICENSE_COUNTRY", "LicCountry");
		attributeNames.put("LICENSE_TYPE", "LicType");
		attributeNames.put("LICENSE_YEARS", "LicYrs");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("LICENSE_ID", 1L);

		columnBitmasks.put("DRIVER_ID", 2L);

		columnBitmasks.put("QUOTATIONS_ID", 4L);

		columnBitmasks.put("LICENSE_COUNTRY", 8L);

		columnBitmasks.put("LICENSE_TYPE", 16L);

		columnBitmasks.put("LICENSE_YEARS", 32L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private QuotationsDriverLicense _escapedModel;

}