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

import com.ejada.atmc.acl.db.model.PolicyMemberDetails;
import com.ejada.atmc.acl.db.model.PolicyMemberDetailsModel;
import com.ejada.atmc.acl.db.model.PolicyMemberDetailsSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
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
 * The base model implementation for the PolicyMemberDetails service. Represents a row in the &quot;ODS_MEMBER_DETAILS&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>PolicyMemberDetailsModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PolicyMemberDetailsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyMemberDetailsImpl
 * @generated
 */
@JSON(strict = true)
public class PolicyMemberDetailsModelImpl
	extends BaseModelImpl<PolicyMemberDetails>
	implements PolicyMemberDetailsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a policy member details model instance should use the <code>PolicyMemberDetails</code> interface instead.
	 */
	public static final String TABLE_NAME = "ODS_MEMBER_DETAILS";

	public static final Object[][] TABLE_COLUMNS = {
		{"ODS_POLICY_NO", Types.VARCHAR}, {"ODS_MEMBER_NAME", Types.VARCHAR},
		{"ODS_MEMBER_SI", Types.BIGINT}, {"ODS_MEMBER_ID", Types.BIGINT},
		{"ODS_MEMBER_GENDER", Types.VARCHAR},
		{"ODS_MEMBER_DOB", Types.TIMESTAMP}, {"ODS_MEMBER_LIMIT", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("ODS_POLICY_NO", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ODS_MEMBER_NAME", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ODS_MEMBER_SI", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ODS_MEMBER_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ODS_MEMBER_GENDER", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ODS_MEMBER_DOB", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("ODS_MEMBER_LIMIT", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ODS_MEMBER_DETAILS (ODS_POLICY_NO VARCHAR(75) null,ODS_MEMBER_NAME VARCHAR(75) null,ODS_MEMBER_SI LONG,ODS_MEMBER_ID LONG not null primary key,ODS_MEMBER_GENDER VARCHAR(75) null,ODS_MEMBER_DOB DATE null,ODS_MEMBER_LIMIT LONG)";

	public static final String TABLE_SQL_DROP = "drop table ODS_MEMBER_DETAILS";

	public static final String ORDER_BY_JPQL =
		" ORDER BY policyMemberDetails.memberId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ODS_MEMBER_DETAILS.ODS_MEMBER_ID ASC";

	public static final String DATA_SOURCE = "extDS";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long POLICYNO_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long MEMBERID_COLUMN_BITMASK = 2L;

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
	public static PolicyMemberDetails toModel(
		PolicyMemberDetailsSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		PolicyMemberDetails model = new PolicyMemberDetailsImpl();

		model.setPolicyNo(soapModel.getPolicyNo());
		model.setMemberName(soapModel.getMemberName());
		model.setMemberSi(soapModel.getMemberSi());
		model.setMemberId(soapModel.getMemberId());
		model.setMemberGender(soapModel.getMemberGender());
		model.setMemberDob(soapModel.getMemberDob());
		model.setMemberLimit(soapModel.getMemberLimit());

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
	public static List<PolicyMemberDetails> toModels(
		PolicyMemberDetailsSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<PolicyMemberDetails> models = new ArrayList<PolicyMemberDetails>(
			soapModels.length);

		for (PolicyMemberDetailsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public PolicyMemberDetailsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _memberId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMemberId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _memberId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PolicyMemberDetails.class;
	}

	@Override
	public String getModelClassName() {
		return PolicyMemberDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<PolicyMemberDetails, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<PolicyMemberDetails, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PolicyMemberDetails, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((PolicyMemberDetails)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<PolicyMemberDetails, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<PolicyMemberDetails, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(PolicyMemberDetails)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<PolicyMemberDetails, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<PolicyMemberDetails, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, PolicyMemberDetails>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			PolicyMemberDetails.class.getClassLoader(),
			PolicyMemberDetails.class, ModelWrapper.class);

		try {
			Constructor<PolicyMemberDetails> constructor =
				(Constructor<PolicyMemberDetails>)proxyClass.getConstructor(
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

	private static final Map<String, Function<PolicyMemberDetails, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<PolicyMemberDetails, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<PolicyMemberDetails, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<PolicyMemberDetails, Object>>();
		Map<String, BiConsumer<PolicyMemberDetails, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<PolicyMemberDetails, ?>>();

		attributeGetterFunctions.put(
			"policyNo", PolicyMemberDetails::getPolicyNo);
		attributeSetterBiConsumers.put(
			"policyNo",
			(BiConsumer<PolicyMemberDetails, String>)
				PolicyMemberDetails::setPolicyNo);
		attributeGetterFunctions.put(
			"memberName", PolicyMemberDetails::getMemberName);
		attributeSetterBiConsumers.put(
			"memberName",
			(BiConsumer<PolicyMemberDetails, String>)
				PolicyMemberDetails::setMemberName);
		attributeGetterFunctions.put(
			"memberSi", PolicyMemberDetails::getMemberSi);
		attributeSetterBiConsumers.put(
			"memberSi",
			(BiConsumer<PolicyMemberDetails, Long>)
				PolicyMemberDetails::setMemberSi);
		attributeGetterFunctions.put(
			"memberId", PolicyMemberDetails::getMemberId);
		attributeSetterBiConsumers.put(
			"memberId",
			(BiConsumer<PolicyMemberDetails, Long>)
				PolicyMemberDetails::setMemberId);
		attributeGetterFunctions.put(
			"memberGender", PolicyMemberDetails::getMemberGender);
		attributeSetterBiConsumers.put(
			"memberGender",
			(BiConsumer<PolicyMemberDetails, String>)
				PolicyMemberDetails::setMemberGender);
		attributeGetterFunctions.put(
			"memberDob", PolicyMemberDetails::getMemberDob);
		attributeSetterBiConsumers.put(
			"memberDob",
			(BiConsumer<PolicyMemberDetails, Date>)
				PolicyMemberDetails::setMemberDob);
		attributeGetterFunctions.put(
			"memberLimit", PolicyMemberDetails::getMemberLimit);
		attributeSetterBiConsumers.put(
			"memberLimit",
			(BiConsumer<PolicyMemberDetails, Long>)
				PolicyMemberDetails::setMemberLimit);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getPolicyNo() {
		if (_policyNo == null) {
			return "";
		}
		else {
			return _policyNo;
		}
	}

	@Override
	public void setPolicyNo(String policyNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_policyNo = policyNo;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalPolicyNo() {
		return getColumnOriginalValue("ODS_POLICY_NO");
	}

	@JSON
	@Override
	public String getMemberName() {
		if (_memberName == null) {
			return "";
		}
		else {
			return _memberName;
		}
	}

	@Override
	public void setMemberName(String memberName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_memberName = memberName;
	}

	@JSON
	@Override
	public long getMemberSi() {
		return _memberSi;
	}

	@Override
	public void setMemberSi(long memberSi) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_memberSi = memberSi;
	}

	@JSON
	@Override
	public long getMemberId() {
		return _memberId;
	}

	@Override
	public void setMemberId(long memberId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_memberId = memberId;
	}

	@JSON
	@Override
	public String getMemberGender() {
		if (_memberGender == null) {
			return "";
		}
		else {
			return _memberGender;
		}
	}

	@Override
	public void setMemberGender(String memberGender) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_memberGender = memberGender;
	}

	@JSON
	@Override
	public Date getMemberDob() {
		return _memberDob;
	}

	@Override
	public void setMemberDob(Date memberDob) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_memberDob = memberDob;
	}

	@JSON
	@Override
	public long getMemberLimit() {
		return _memberLimit;
	}

	@Override
	public void setMemberLimit(long memberLimit) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_memberLimit = memberLimit;
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
			0, PolicyMemberDetails.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PolicyMemberDetails toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, PolicyMemberDetails>
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
		PolicyMemberDetailsImpl policyMemberDetailsImpl =
			new PolicyMemberDetailsImpl();

		policyMemberDetailsImpl.setPolicyNo(getPolicyNo());
		policyMemberDetailsImpl.setMemberName(getMemberName());
		policyMemberDetailsImpl.setMemberSi(getMemberSi());
		policyMemberDetailsImpl.setMemberId(getMemberId());
		policyMemberDetailsImpl.setMemberGender(getMemberGender());
		policyMemberDetailsImpl.setMemberDob(getMemberDob());
		policyMemberDetailsImpl.setMemberLimit(getMemberLimit());

		policyMemberDetailsImpl.resetOriginalValues();

		return policyMemberDetailsImpl;
	}

	@Override
	public int compareTo(PolicyMemberDetails policyMemberDetails) {
		long primaryKey = policyMemberDetails.getPrimaryKey();

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

		if (!(object instanceof PolicyMemberDetails)) {
			return false;
		}

		PolicyMemberDetails policyMemberDetails = (PolicyMemberDetails)object;

		long primaryKey = policyMemberDetails.getPrimaryKey();

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
	public CacheModel<PolicyMemberDetails> toCacheModel() {
		PolicyMemberDetailsCacheModel policyMemberDetailsCacheModel =
			new PolicyMemberDetailsCacheModel();

		policyMemberDetailsCacheModel.policyNo = getPolicyNo();

		String policyNo = policyMemberDetailsCacheModel.policyNo;

		if ((policyNo != null) && (policyNo.length() == 0)) {
			policyMemberDetailsCacheModel.policyNo = null;
		}

		policyMemberDetailsCacheModel.memberName = getMemberName();

		String memberName = policyMemberDetailsCacheModel.memberName;

		if ((memberName != null) && (memberName.length() == 0)) {
			policyMemberDetailsCacheModel.memberName = null;
		}

		policyMemberDetailsCacheModel.memberSi = getMemberSi();

		policyMemberDetailsCacheModel.memberId = getMemberId();

		policyMemberDetailsCacheModel.memberGender = getMemberGender();

		String memberGender = policyMemberDetailsCacheModel.memberGender;

		if ((memberGender != null) && (memberGender.length() == 0)) {
			policyMemberDetailsCacheModel.memberGender = null;
		}

		Date memberDob = getMemberDob();

		if (memberDob != null) {
			policyMemberDetailsCacheModel.memberDob = memberDob.getTime();
		}
		else {
			policyMemberDetailsCacheModel.memberDob = Long.MIN_VALUE;
		}

		policyMemberDetailsCacheModel.memberLimit = getMemberLimit();

		return policyMemberDetailsCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<PolicyMemberDetails, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<PolicyMemberDetails, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PolicyMemberDetails, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((PolicyMemberDetails)this));
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
		Map<String, Function<PolicyMemberDetails, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<PolicyMemberDetails, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PolicyMemberDetails, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((PolicyMemberDetails)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, PolicyMemberDetails>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _policyNo;
	private String _memberName;
	private long _memberSi;
	private long _memberId;
	private String _memberGender;
	private Date _memberDob;
	private long _memberLimit;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<PolicyMemberDetails, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((PolicyMemberDetails)this);
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

		_columnOriginalValues.put("ODS_POLICY_NO", _policyNo);
		_columnOriginalValues.put("ODS_MEMBER_NAME", _memberName);
		_columnOriginalValues.put("ODS_MEMBER_SI", _memberSi);
		_columnOriginalValues.put("ODS_MEMBER_ID", _memberId);
		_columnOriginalValues.put("ODS_MEMBER_GENDER", _memberGender);
		_columnOriginalValues.put("ODS_MEMBER_DOB", _memberDob);
		_columnOriginalValues.put("ODS_MEMBER_LIMIT", _memberLimit);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("ODS_POLICY_NO", "policyNo");
		attributeNames.put("ODS_MEMBER_NAME", "memberName");
		attributeNames.put("ODS_MEMBER_SI", "memberSi");
		attributeNames.put("ODS_MEMBER_ID", "memberId");
		attributeNames.put("ODS_MEMBER_GENDER", "memberGender");
		attributeNames.put("ODS_MEMBER_DOB", "memberDob");
		attributeNames.put("ODS_MEMBER_LIMIT", "memberLimit");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("ODS_POLICY_NO", 1L);

		columnBitmasks.put("ODS_MEMBER_NAME", 2L);

		columnBitmasks.put("ODS_MEMBER_SI", 4L);

		columnBitmasks.put("ODS_MEMBER_ID", 8L);

		columnBitmasks.put("ODS_MEMBER_GENDER", 16L);

		columnBitmasks.put("ODS_MEMBER_DOB", 32L);

		columnBitmasks.put("ODS_MEMBER_LIMIT", 64L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private PolicyMemberDetails _escapedModel;

}