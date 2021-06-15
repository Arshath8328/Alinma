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

import com.ejada.atmc.acl.db.model.ClaimAdminUploads;
import com.ejada.atmc.acl.db.model.ClaimAdminUploadsAdminFileBlobModel;
import com.ejada.atmc.acl.db.model.ClaimAdminUploadsModel;
import com.ejada.atmc.acl.db.model.ClaimAdminUploadsSoap;
import com.ejada.atmc.acl.db.service.ClaimAdminUploadsLocalServiceUtil;

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

import java.sql.Blob;
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
 * The base model implementation for the ClaimAdminUploads service. Represents a row in the &quot;EJD_CLM_ADMIN_UPLOADS&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ClaimAdminUploadsModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ClaimAdminUploadsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimAdminUploadsImpl
 * @generated
 */
@JSON(strict = true)
public class ClaimAdminUploadsModelImpl
	extends BaseModelImpl<ClaimAdminUploads> implements ClaimAdminUploadsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a claim admin uploads model instance should use the <code>ClaimAdminUploads</code> interface instead.
	 */
	public static final String TABLE_NAME = "EJD_CLM_ADMIN_UPLOADS";

	public static final Object[][] TABLE_COLUMNS = {
		{"CLM_FILE_ID", Types.INTEGER}, {"CLM_REFERENCE_NO", Types.VARCHAR},
		{"CLM_FILE_NAME", Types.VARCHAR}, {"CLM_FILE", Types.BLOB}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("CLM_FILE_ID", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("CLM_REFERENCE_NO", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CLM_FILE_NAME", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CLM_FILE", Types.BLOB);
	}

	public static final String TABLE_SQL_CREATE =
		"create table EJD_CLM_ADMIN_UPLOADS (CLM_FILE_ID INTEGER not null primary key,CLM_REFERENCE_NO VARCHAR(75) null,CLM_FILE_NAME VARCHAR(75) null,CLM_FILE BLOB)";

	public static final String TABLE_SQL_DROP =
		"drop table EJD_CLM_ADMIN_UPLOADS";

	public static final String ORDER_BY_JPQL =
		" ORDER BY claimAdminUploads.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY EJD_CLM_ADMIN_UPLOADS.CLM_FILE_ID ASC";

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
	public static final long ID_COLUMN_BITMASK = 2L;

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
	public static ClaimAdminUploads toModel(ClaimAdminUploadsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ClaimAdminUploads model = new ClaimAdminUploadsImpl();

		model.setId(soapModel.getId());
		model.setRefNo(soapModel.getRefNo());
		model.setFileName(soapModel.getFileName());
		model.setAdminFile(soapModel.getAdminFile());

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
	public static List<ClaimAdminUploads> toModels(
		ClaimAdminUploadsSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<ClaimAdminUploads> models = new ArrayList<ClaimAdminUploads>(
			soapModels.length);

		for (ClaimAdminUploadsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ClaimAdminUploadsModelImpl() {
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
		return ClaimAdminUploads.class;
	}

	@Override
	public String getModelClassName() {
		return ClaimAdminUploads.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ClaimAdminUploads, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ClaimAdminUploads, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ClaimAdminUploads, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ClaimAdminUploads)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ClaimAdminUploads, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ClaimAdminUploads, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ClaimAdminUploads)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ClaimAdminUploads, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ClaimAdminUploads, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ClaimAdminUploads>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ClaimAdminUploads.class.getClassLoader(), ClaimAdminUploads.class,
			ModelWrapper.class);

		try {
			Constructor<ClaimAdminUploads> constructor =
				(Constructor<ClaimAdminUploads>)proxyClass.getConstructor(
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

	private static final Map<String, Function<ClaimAdminUploads, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ClaimAdminUploads, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ClaimAdminUploads, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<ClaimAdminUploads, Object>>();
		Map<String, BiConsumer<ClaimAdminUploads, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<ClaimAdminUploads, ?>>();

		attributeGetterFunctions.put("id", ClaimAdminUploads::getId);
		attributeSetterBiConsumers.put(
			"id",
			(BiConsumer<ClaimAdminUploads, Integer>)ClaimAdminUploads::setId);
		attributeGetterFunctions.put("refNo", ClaimAdminUploads::getRefNo);
		attributeSetterBiConsumers.put(
			"refNo",
			(BiConsumer<ClaimAdminUploads, String>)ClaimAdminUploads::setRefNo);
		attributeGetterFunctions.put(
			"fileName", ClaimAdminUploads::getFileName);
		attributeSetterBiConsumers.put(
			"fileName",
			(BiConsumer<ClaimAdminUploads, String>)
				ClaimAdminUploads::setFileName);
		attributeGetterFunctions.put(
			"adminFile", ClaimAdminUploads::getAdminFile);
		attributeSetterBiConsumers.put(
			"adminFile",
			(BiConsumer<ClaimAdminUploads, Blob>)
				ClaimAdminUploads::setAdminFile);

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
		if (_refNo == null) {
			return "";
		}
		else {
			return _refNo;
		}
	}

	@Override
	public void setRefNo(String refNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_refNo = refNo;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalRefNo() {
		return getColumnOriginalValue("CLM_REFERENCE_NO");
	}

	@JSON
	@Override
	public String getFileName() {
		if (_fileName == null) {
			return "";
		}
		else {
			return _fileName;
		}
	}

	@Override
	public void setFileName(String fileName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileName = fileName;
	}

	@JSON
	@Override
	public Blob getAdminFile() {
		if (_adminFileBlobModel == null) {
			try {
				_adminFileBlobModel =
					ClaimAdminUploadsLocalServiceUtil.getAdminFileBlobModel(
						getPrimaryKey());
			}
			catch (Exception exception) {
			}
		}

		Blob blob = null;

		if (_adminFileBlobModel != null) {
			blob = _adminFileBlobModel.getAdminFileBlob();
		}

		return blob;
	}

	@Override
	public void setAdminFile(Blob adminFile) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		if (_adminFileBlobModel == null) {
			_adminFileBlobModel = new ClaimAdminUploadsAdminFileBlobModel(
				getPrimaryKey(), adminFile);
		}
		else {
			_adminFileBlobModel.setAdminFileBlob(adminFile);
		}
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
	public ClaimAdminUploads toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ClaimAdminUploads>
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
		ClaimAdminUploadsImpl claimAdminUploadsImpl =
			new ClaimAdminUploadsImpl();

		claimAdminUploadsImpl.setId(getId());
		claimAdminUploadsImpl.setRefNo(getRefNo());
		claimAdminUploadsImpl.setFileName(getFileName());

		claimAdminUploadsImpl.resetOriginalValues();

		return claimAdminUploadsImpl;
	}

	@Override
	public int compareTo(ClaimAdminUploads claimAdminUploads) {
		int primaryKey = claimAdminUploads.getPrimaryKey();

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

		if (!(object instanceof ClaimAdminUploads)) {
			return false;
		}

		ClaimAdminUploads claimAdminUploads = (ClaimAdminUploads)object;

		int primaryKey = claimAdminUploads.getPrimaryKey();

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

		_adminFileBlobModel = null;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<ClaimAdminUploads> toCacheModel() {
		ClaimAdminUploadsCacheModel claimAdminUploadsCacheModel =
			new ClaimAdminUploadsCacheModel();

		claimAdminUploadsCacheModel.id = getId();

		claimAdminUploadsCacheModel.refNo = getRefNo();

		String refNo = claimAdminUploadsCacheModel.refNo;

		if ((refNo != null) && (refNo.length() == 0)) {
			claimAdminUploadsCacheModel.refNo = null;
		}

		claimAdminUploadsCacheModel.fileName = getFileName();

		String fileName = claimAdminUploadsCacheModel.fileName;

		if ((fileName != null) && (fileName.length() == 0)) {
			claimAdminUploadsCacheModel.fileName = null;
		}

		return claimAdminUploadsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", refNo=");
		sb.append(getRefNo());
		sb.append(", fileName=");
		sb.append(getFileName());

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.ejada.atmc.acl.db.model.ClaimAdminUploads");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>refNo</column-name><column-value><![CDATA[");
		sb.append(getRefNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileName</column-name><column-value><![CDATA[");
		sb.append(getFileName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ClaimAdminUploads>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private int _id;
	private String _refNo;
	private String _fileName;
	private ClaimAdminUploadsAdminFileBlobModel _adminFileBlobModel;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ClaimAdminUploads, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ClaimAdminUploads)this);
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

		_columnOriginalValues.put("CLM_FILE_ID", _id);
		_columnOriginalValues.put("CLM_REFERENCE_NO", _refNo);
		_columnOriginalValues.put("CLM_FILE_NAME", _fileName);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("CLM_FILE_ID", "id");
		attributeNames.put("CLM_REFERENCE_NO", "refNo");
		attributeNames.put("CLM_FILE_NAME", "fileName");
		attributeNames.put("CLM_FILE", "adminFile");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("CLM_FILE_ID", 1L);

		columnBitmasks.put("CLM_REFERENCE_NO", 2L);

		columnBitmasks.put("CLM_FILE_NAME", 4L);

		columnBitmasks.put("CLM_FILE", 8L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ClaimAdminUploads _escapedModel;

}