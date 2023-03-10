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

import com.ejada.atmc.acl.db.model.PolicyVehCvr;
import com.ejada.atmc.acl.db.model.PolicyVehCvrModel;
import com.ejada.atmc.acl.db.model.PolicyVehCvrSoap;
import com.ejada.atmc.acl.db.service.persistence.PolicyVehCvrPK;

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
 * The base model implementation for the PolicyVehCvr service. Represents a row in the &quot;ODS_POLICY_VEH_CVR&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>PolicyVehCvrModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PolicyVehCvrImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyVehCvrImpl
 * @generated
 */
@JSON(strict = true)
public class PolicyVehCvrModelImpl
	extends BaseModelImpl<PolicyVehCvr> implements PolicyVehCvrModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a policy veh cvr model instance should use the <code>PolicyVehCvr</code> interface instead.
	 */
	public static final String TABLE_NAME = "ODS_POLICY_VEH_CVR";

	public static final Object[][] TABLE_COLUMNS = {
		{"ODS_POLICY_NO", Types.VARCHAR}, {"ODS_VEH_ID", Types.VARCHAR},
		{"ODS_CVR_CODE", Types.VARCHAR}, {"ODS_DESCRIPTION", Types.VARCHAR},
		{"ODS_CVR_TYPE", Types.VARCHAR}, {"ODS_BENEFIT_TERM", Types.VARCHAR},
		{"ODS_PREMIUM_TERM", Types.VARCHAR}, {"ODS_PREMIUM", Types.BIGINT},
		{"ODS_SUM_COVERED", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("ODS_POLICY_NO", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ODS_VEH_ID", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ODS_CVR_CODE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ODS_DESCRIPTION", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ODS_CVR_TYPE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ODS_BENEFIT_TERM", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ODS_PREMIUM_TERM", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ODS_PREMIUM", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ODS_SUM_COVERED", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ODS_POLICY_VEH_CVR (ODS_POLICY_NO VARCHAR(75) not null,ODS_VEH_ID VARCHAR(75) not null,ODS_CVR_CODE VARCHAR(75) null,ODS_DESCRIPTION VARCHAR(75) not null,ODS_CVR_TYPE VARCHAR(75) null,ODS_BENEFIT_TERM VARCHAR(75) null,ODS_PREMIUM_TERM VARCHAR(75) null,ODS_PREMIUM LONG,ODS_SUM_COVERED LONG,primary key (ODS_POLICY_NO, ODS_VEH_ID, ODS_DESCRIPTION))";

	public static final String TABLE_SQL_DROP = "drop table ODS_POLICY_VEH_CVR";

	public static final String ORDER_BY_JPQL =
		" ORDER BY policyVehCvr.id.policyNo ASC, policyVehCvr.id.vehId ASC, policyVehCvr.id.description ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ODS_POLICY_VEH_CVR.ODS_POLICY_NO ASC, ODS_POLICY_VEH_CVR.ODS_VEH_ID ASC, ODS_POLICY_VEH_CVR.ODS_DESCRIPTION ASC";

	public static final String DATA_SOURCE = "extDS";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long POLICYNO_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long VEHID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long DESCRIPTION_COLUMN_BITMASK = 4L;

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
	public static PolicyVehCvr toModel(PolicyVehCvrSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		PolicyVehCvr model = new PolicyVehCvrImpl();

		model.setPolicyNo(soapModel.getPolicyNo());
		model.setVehId(soapModel.getVehId());
		model.setCvrCode(soapModel.getCvrCode());
		model.setDescription(soapModel.getDescription());
		model.setCvrType(soapModel.getCvrType());
		model.setBenefitTerm(soapModel.getBenefitTerm());
		model.setPremiumTerm(soapModel.getPremiumTerm());
		model.setPremium(soapModel.getPremium());
		model.setSumCovered(soapModel.getSumCovered());

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
	public static List<PolicyVehCvr> toModels(PolicyVehCvrSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<PolicyVehCvr> models = new ArrayList<PolicyVehCvr>(
			soapModels.length);

		for (PolicyVehCvrSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public PolicyVehCvrModelImpl() {
	}

	@Override
	public PolicyVehCvrPK getPrimaryKey() {
		return new PolicyVehCvrPK(_policyNo, _vehId, _description);
	}

	@Override
	public void setPrimaryKey(PolicyVehCvrPK primaryKey) {
		setPolicyNo(primaryKey.policyNo);
		setVehId(primaryKey.vehId);
		setDescription(primaryKey.description);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new PolicyVehCvrPK(_policyNo, _vehId, _description);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((PolicyVehCvrPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return PolicyVehCvr.class;
	}

	@Override
	public String getModelClassName() {
		return PolicyVehCvr.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<PolicyVehCvr, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<PolicyVehCvr, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PolicyVehCvr, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((PolicyVehCvr)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<PolicyVehCvr, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<PolicyVehCvr, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(PolicyVehCvr)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<PolicyVehCvr, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<PolicyVehCvr, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, PolicyVehCvr>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			PolicyVehCvr.class.getClassLoader(), PolicyVehCvr.class,
			ModelWrapper.class);

		try {
			Constructor<PolicyVehCvr> constructor =
				(Constructor<PolicyVehCvr>)proxyClass.getConstructor(
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

	private static final Map<String, Function<PolicyVehCvr, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<PolicyVehCvr, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<PolicyVehCvr, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<PolicyVehCvr, Object>>();
		Map<String, BiConsumer<PolicyVehCvr, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<PolicyVehCvr, ?>>();

		attributeGetterFunctions.put("policyNo", PolicyVehCvr::getPolicyNo);
		attributeSetterBiConsumers.put(
			"policyNo",
			(BiConsumer<PolicyVehCvr, String>)PolicyVehCvr::setPolicyNo);
		attributeGetterFunctions.put("vehId", PolicyVehCvr::getVehId);
		attributeSetterBiConsumers.put(
			"vehId", (BiConsumer<PolicyVehCvr, String>)PolicyVehCvr::setVehId);
		attributeGetterFunctions.put("cvrCode", PolicyVehCvr::getCvrCode);
		attributeSetterBiConsumers.put(
			"cvrCode",
			(BiConsumer<PolicyVehCvr, String>)PolicyVehCvr::setCvrCode);
		attributeGetterFunctions.put(
			"description", PolicyVehCvr::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<PolicyVehCvr, String>)PolicyVehCvr::setDescription);
		attributeGetterFunctions.put("cvrType", PolicyVehCvr::getCvrType);
		attributeSetterBiConsumers.put(
			"cvrType",
			(BiConsumer<PolicyVehCvr, String>)PolicyVehCvr::setCvrType);
		attributeGetterFunctions.put(
			"benefitTerm", PolicyVehCvr::getBenefitTerm);
		attributeSetterBiConsumers.put(
			"benefitTerm",
			(BiConsumer<PolicyVehCvr, String>)PolicyVehCvr::setBenefitTerm);
		attributeGetterFunctions.put(
			"premiumTerm", PolicyVehCvr::getPremiumTerm);
		attributeSetterBiConsumers.put(
			"premiumTerm",
			(BiConsumer<PolicyVehCvr, String>)PolicyVehCvr::setPremiumTerm);
		attributeGetterFunctions.put("premium", PolicyVehCvr::getPremium);
		attributeSetterBiConsumers.put(
			"premium",
			(BiConsumer<PolicyVehCvr, Long>)PolicyVehCvr::setPremium);
		attributeGetterFunctions.put("sumCovered", PolicyVehCvr::getSumCovered);
		attributeSetterBiConsumers.put(
			"sumCovered",
			(BiConsumer<PolicyVehCvr, Long>)PolicyVehCvr::setSumCovered);

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
	public String getVehId() {
		if (_vehId == null) {
			return "";
		}
		else {
			return _vehId;
		}
	}

	@Override
	public void setVehId(String vehId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_vehId = vehId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalVehId() {
		return getColumnOriginalValue("ODS_VEH_ID");
	}

	@JSON
	@Override
	public String getCvrCode() {
		if (_cvrCode == null) {
			return "";
		}
		else {
			return _cvrCode;
		}
	}

	@Override
	public void setCvrCode(String cvrCode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cvrCode = cvrCode;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@JSON
	@Override
	public String getCvrType() {
		if (_cvrType == null) {
			return "";
		}
		else {
			return _cvrType;
		}
	}

	@Override
	public void setCvrType(String cvrType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cvrType = cvrType;
	}

	@JSON
	@Override
	public String getBenefitTerm() {
		if (_benefitTerm == null) {
			return "";
		}
		else {
			return _benefitTerm;
		}
	}

	@Override
	public void setBenefitTerm(String benefitTerm) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_benefitTerm = benefitTerm;
	}

	@JSON
	@Override
	public String getPremiumTerm() {
		if (_premiumTerm == null) {
			return "";
		}
		else {
			return _premiumTerm;
		}
	}

	@Override
	public void setPremiumTerm(String premiumTerm) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_premiumTerm = premiumTerm;
	}

	@JSON
	@Override
	public long getPremium() {
		return _premium;
	}

	@Override
	public void setPremium(long premium) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_premium = premium;
	}

	@JSON
	@Override
	public long getSumCovered() {
		return _sumCovered;
	}

	@Override
	public void setSumCovered(long sumCovered) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sumCovered = sumCovered;
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
	public PolicyVehCvr toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, PolicyVehCvr>
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
		PolicyVehCvrImpl policyVehCvrImpl = new PolicyVehCvrImpl();

		policyVehCvrImpl.setPolicyNo(getPolicyNo());
		policyVehCvrImpl.setVehId(getVehId());
		policyVehCvrImpl.setCvrCode(getCvrCode());
		policyVehCvrImpl.setDescription(getDescription());
		policyVehCvrImpl.setCvrType(getCvrType());
		policyVehCvrImpl.setBenefitTerm(getBenefitTerm());
		policyVehCvrImpl.setPremiumTerm(getPremiumTerm());
		policyVehCvrImpl.setPremium(getPremium());
		policyVehCvrImpl.setSumCovered(getSumCovered());

		policyVehCvrImpl.resetOriginalValues();

		return policyVehCvrImpl;
	}

	@Override
	public int compareTo(PolicyVehCvr policyVehCvr) {
		PolicyVehCvrPK primaryKey = policyVehCvr.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PolicyVehCvr)) {
			return false;
		}

		PolicyVehCvr policyVehCvr = (PolicyVehCvr)object;

		PolicyVehCvrPK primaryKey = policyVehCvr.getPrimaryKey();

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
	public CacheModel<PolicyVehCvr> toCacheModel() {
		PolicyVehCvrCacheModel policyVehCvrCacheModel =
			new PolicyVehCvrCacheModel();

		policyVehCvrCacheModel.policyVehCvrPK = getPrimaryKey();

		policyVehCvrCacheModel.policyNo = getPolicyNo();

		String policyNo = policyVehCvrCacheModel.policyNo;

		if ((policyNo != null) && (policyNo.length() == 0)) {
			policyVehCvrCacheModel.policyNo = null;
		}

		policyVehCvrCacheModel.vehId = getVehId();

		String vehId = policyVehCvrCacheModel.vehId;

		if ((vehId != null) && (vehId.length() == 0)) {
			policyVehCvrCacheModel.vehId = null;
		}

		policyVehCvrCacheModel.cvrCode = getCvrCode();

		String cvrCode = policyVehCvrCacheModel.cvrCode;

		if ((cvrCode != null) && (cvrCode.length() == 0)) {
			policyVehCvrCacheModel.cvrCode = null;
		}

		policyVehCvrCacheModel.description = getDescription();

		String description = policyVehCvrCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			policyVehCvrCacheModel.description = null;
		}

		policyVehCvrCacheModel.cvrType = getCvrType();

		String cvrType = policyVehCvrCacheModel.cvrType;

		if ((cvrType != null) && (cvrType.length() == 0)) {
			policyVehCvrCacheModel.cvrType = null;
		}

		policyVehCvrCacheModel.benefitTerm = getBenefitTerm();

		String benefitTerm = policyVehCvrCacheModel.benefitTerm;

		if ((benefitTerm != null) && (benefitTerm.length() == 0)) {
			policyVehCvrCacheModel.benefitTerm = null;
		}

		policyVehCvrCacheModel.premiumTerm = getPremiumTerm();

		String premiumTerm = policyVehCvrCacheModel.premiumTerm;

		if ((premiumTerm != null) && (premiumTerm.length() == 0)) {
			policyVehCvrCacheModel.premiumTerm = null;
		}

		policyVehCvrCacheModel.premium = getPremium();

		policyVehCvrCacheModel.sumCovered = getSumCovered();

		return policyVehCvrCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<PolicyVehCvr, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<PolicyVehCvr, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PolicyVehCvr, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((PolicyVehCvr)this));
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
		Map<String, Function<PolicyVehCvr, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<PolicyVehCvr, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PolicyVehCvr, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((PolicyVehCvr)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, PolicyVehCvr>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _policyNo;
	private String _vehId;
	private String _cvrCode;
	private String _description;
	private String _cvrType;
	private String _benefitTerm;
	private String _premiumTerm;
	private long _premium;
	private long _sumCovered;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<PolicyVehCvr, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((PolicyVehCvr)this);
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
		_columnOriginalValues.put("ODS_VEH_ID", _vehId);
		_columnOriginalValues.put("ODS_CVR_CODE", _cvrCode);
		_columnOriginalValues.put("ODS_DESCRIPTION", _description);
		_columnOriginalValues.put("ODS_CVR_TYPE", _cvrType);
		_columnOriginalValues.put("ODS_BENEFIT_TERM", _benefitTerm);
		_columnOriginalValues.put("ODS_PREMIUM_TERM", _premiumTerm);
		_columnOriginalValues.put("ODS_PREMIUM", _premium);
		_columnOriginalValues.put("ODS_SUM_COVERED", _sumCovered);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("ODS_POLICY_NO", "policyNo");
		attributeNames.put("ODS_VEH_ID", "vehId");
		attributeNames.put("ODS_CVR_CODE", "cvrCode");
		attributeNames.put("ODS_DESCRIPTION", "description");
		attributeNames.put("ODS_CVR_TYPE", "cvrType");
		attributeNames.put("ODS_BENEFIT_TERM", "benefitTerm");
		attributeNames.put("ODS_PREMIUM_TERM", "premiumTerm");
		attributeNames.put("ODS_PREMIUM", "premium");
		attributeNames.put("ODS_SUM_COVERED", "sumCovered");

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

		columnBitmasks.put("ODS_VEH_ID", 2L);

		columnBitmasks.put("ODS_CVR_CODE", 4L);

		columnBitmasks.put("ODS_DESCRIPTION", 8L);

		columnBitmasks.put("ODS_CVR_TYPE", 16L);

		columnBitmasks.put("ODS_BENEFIT_TERM", 32L);

		columnBitmasks.put("ODS_PREMIUM_TERM", 64L);

		columnBitmasks.put("ODS_PREMIUM", 128L);

		columnBitmasks.put("ODS_SUM_COVERED", 256L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private PolicyVehCvr _escapedModel;

}