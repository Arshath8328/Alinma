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

package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.exception.NoSuchAtmcYakeenMakeModelException;
import com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel;
import com.ejada.atmc.acl.db.model.impl.AtmcYakeenMakeModelImpl;
import com.ejada.atmc.acl.db.model.impl.AtmcYakeenMakeModelModelImpl;
import com.ejada.atmc.acl.db.service.persistence.AtmcYakeenMakeModelPersistence;
import com.ejada.atmc.acl.db.service.persistence.impl.constants.DBACLPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the atmc yakeen make model service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AtmcYakeenMakeModelPersistence.class)
public class AtmcYakeenMakeModelPersistenceImpl
	extends BasePersistenceImpl<AtmcYakeenMakeModel>
	implements AtmcYakeenMakeModelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AtmcYakeenMakeModelUtil</code> to access the atmc yakeen make model persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AtmcYakeenMakeModelImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByYakeenMakeModelDetails;
	private FinderPath _finderPathCountByYakeenMakeModelDetails;

	/**
	 * Returns the atmc yakeen make model where yakeenMakeValue = &#63; and yakeenModelValue = &#63; or throws a <code>NoSuchAtmcYakeenMakeModelException</code> if it could not be found.
	 *
	 * @param yakeenMakeValue the yakeen make value
	 * @param yakeenModelValue the yakeen model value
	 * @return the matching atmc yakeen make model
	 * @throws NoSuchAtmcYakeenMakeModelException if a matching atmc yakeen make model could not be found
	 */
	@Override
	public AtmcYakeenMakeModel findByYakeenMakeModelDetails(
			String yakeenMakeValue, String yakeenModelValue)
		throws NoSuchAtmcYakeenMakeModelException {

		AtmcYakeenMakeModel atmcYakeenMakeModel = fetchByYakeenMakeModelDetails(
			yakeenMakeValue, yakeenModelValue);

		if (atmcYakeenMakeModel == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("yakeenMakeValue=");
			sb.append(yakeenMakeValue);

			sb.append(", yakeenModelValue=");
			sb.append(yakeenModelValue);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAtmcYakeenMakeModelException(sb.toString());
		}

		return atmcYakeenMakeModel;
	}

	/**
	 * Returns the atmc yakeen make model where yakeenMakeValue = &#63; and yakeenModelValue = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param yakeenMakeValue the yakeen make value
	 * @param yakeenModelValue the yakeen model value
	 * @return the matching atmc yakeen make model, or <code>null</code> if a matching atmc yakeen make model could not be found
	 */
	@Override
	public AtmcYakeenMakeModel fetchByYakeenMakeModelDetails(
		String yakeenMakeValue, String yakeenModelValue) {

		return fetchByYakeenMakeModelDetails(
			yakeenMakeValue, yakeenModelValue, true);
	}

	/**
	 * Returns the atmc yakeen make model where yakeenMakeValue = &#63; and yakeenModelValue = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param yakeenMakeValue the yakeen make value
	 * @param yakeenModelValue the yakeen model value
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching atmc yakeen make model, or <code>null</code> if a matching atmc yakeen make model could not be found
	 */
	@Override
	public AtmcYakeenMakeModel fetchByYakeenMakeModelDetails(
		String yakeenMakeValue, String yakeenModelValue,
		boolean useFinderCache) {

		yakeenMakeValue = Objects.toString(yakeenMakeValue, "");
		yakeenModelValue = Objects.toString(yakeenModelValue, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {yakeenMakeValue, yakeenModelValue};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByYakeenMakeModelDetails, finderArgs, this);
		}

		if (result instanceof AtmcYakeenMakeModel) {
			AtmcYakeenMakeModel atmcYakeenMakeModel =
				(AtmcYakeenMakeModel)result;

			if (!Objects.equals(
					yakeenMakeValue,
					atmcYakeenMakeModel.getYakeenMakeValue()) ||
				!Objects.equals(
					yakeenModelValue,
					atmcYakeenMakeModel.getYakeenModelValue())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ATMCYAKEENMAKEMODEL_WHERE);

			boolean bindYakeenMakeValue = false;

			if (yakeenMakeValue.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_YAKEENMAKEMODELDETAILS_YAKEENMAKEVALUE_3);
			}
			else {
				bindYakeenMakeValue = true;

				sb.append(
					_FINDER_COLUMN_YAKEENMAKEMODELDETAILS_YAKEENMAKEVALUE_2);
			}

			boolean bindYakeenModelValue = false;

			if (yakeenModelValue.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_YAKEENMAKEMODELDETAILS_YAKEENMODELVALUE_3);
			}
			else {
				bindYakeenModelValue = true;

				sb.append(
					_FINDER_COLUMN_YAKEENMAKEMODELDETAILS_YAKEENMODELVALUE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindYakeenMakeValue) {
					queryPos.add(yakeenMakeValue);
				}

				if (bindYakeenModelValue) {
					queryPos.add(yakeenModelValue);
				}

				List<AtmcYakeenMakeModel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByYakeenMakeModelDetails,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									yakeenMakeValue, yakeenModelValue
								};
							}

							_log.warn(
								"AtmcYakeenMakeModelPersistenceImpl.fetchByYakeenMakeModelDetails(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AtmcYakeenMakeModel atmcYakeenMakeModel = list.get(0);

					result = atmcYakeenMakeModel;

					cacheResult(atmcYakeenMakeModel);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (AtmcYakeenMakeModel)result;
		}
	}

	/**
	 * Removes the atmc yakeen make model where yakeenMakeValue = &#63; and yakeenModelValue = &#63; from the database.
	 *
	 * @param yakeenMakeValue the yakeen make value
	 * @param yakeenModelValue the yakeen model value
	 * @return the atmc yakeen make model that was removed
	 */
	@Override
	public AtmcYakeenMakeModel removeByYakeenMakeModelDetails(
			String yakeenMakeValue, String yakeenModelValue)
		throws NoSuchAtmcYakeenMakeModelException {

		AtmcYakeenMakeModel atmcYakeenMakeModel = findByYakeenMakeModelDetails(
			yakeenMakeValue, yakeenModelValue);

		return remove(atmcYakeenMakeModel);
	}

	/**
	 * Returns the number of atmc yakeen make models where yakeenMakeValue = &#63; and yakeenModelValue = &#63;.
	 *
	 * @param yakeenMakeValue the yakeen make value
	 * @param yakeenModelValue the yakeen model value
	 * @return the number of matching atmc yakeen make models
	 */
	@Override
	public int countByYakeenMakeModelDetails(
		String yakeenMakeValue, String yakeenModelValue) {

		yakeenMakeValue = Objects.toString(yakeenMakeValue, "");
		yakeenModelValue = Objects.toString(yakeenModelValue, "");

		FinderPath finderPath = _finderPathCountByYakeenMakeModelDetails;

		Object[] finderArgs = new Object[] {yakeenMakeValue, yakeenModelValue};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ATMCYAKEENMAKEMODEL_WHERE);

			boolean bindYakeenMakeValue = false;

			if (yakeenMakeValue.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_YAKEENMAKEMODELDETAILS_YAKEENMAKEVALUE_3);
			}
			else {
				bindYakeenMakeValue = true;

				sb.append(
					_FINDER_COLUMN_YAKEENMAKEMODELDETAILS_YAKEENMAKEVALUE_2);
			}

			boolean bindYakeenModelValue = false;

			if (yakeenModelValue.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_YAKEENMAKEMODELDETAILS_YAKEENMODELVALUE_3);
			}
			else {
				bindYakeenModelValue = true;

				sb.append(
					_FINDER_COLUMN_YAKEENMAKEMODELDETAILS_YAKEENMODELVALUE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindYakeenMakeValue) {
					queryPos.add(yakeenMakeValue);
				}

				if (bindYakeenModelValue) {
					queryPos.add(yakeenModelValue);
				}

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_YAKEENMAKEMODELDETAILS_YAKEENMAKEVALUE_2 =
			"atmcYakeenMakeModel.yakeenMakeValue = ? AND ";

	private static final String
		_FINDER_COLUMN_YAKEENMAKEMODELDETAILS_YAKEENMAKEVALUE_3 =
			"(atmcYakeenMakeModel.yakeenMakeValue IS NULL OR atmcYakeenMakeModel.yakeenMakeValue = '') AND ";

	private static final String
		_FINDER_COLUMN_YAKEENMAKEMODELDETAILS_YAKEENMODELVALUE_2 =
			"atmcYakeenMakeModel.yakeenModelValue = ?";

	private static final String
		_FINDER_COLUMN_YAKEENMAKEMODELDETAILS_YAKEENMODELVALUE_3 =
			"(atmcYakeenMakeModel.yakeenModelValue IS NULL OR atmcYakeenMakeModel.yakeenModelValue = '')";

	private FinderPath _finderPathFetchByEskaMakeModelDetails;
	private FinderPath _finderPathCountByEskaMakeModelDetails;

	/**
	 * Returns the atmc yakeen make model where eskaMakeId = &#63; and eskaModelId = &#63; or throws a <code>NoSuchAtmcYakeenMakeModelException</code> if it could not be found.
	 *
	 * @param eskaMakeId the eska make ID
	 * @param eskaModelId the eska model ID
	 * @return the matching atmc yakeen make model
	 * @throws NoSuchAtmcYakeenMakeModelException if a matching atmc yakeen make model could not be found
	 */
	@Override
	public AtmcYakeenMakeModel findByEskaMakeModelDetails(
			String eskaMakeId, String eskaModelId)
		throws NoSuchAtmcYakeenMakeModelException {

		AtmcYakeenMakeModel atmcYakeenMakeModel = fetchByEskaMakeModelDetails(
			eskaMakeId, eskaModelId);

		if (atmcYakeenMakeModel == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("eskaMakeId=");
			sb.append(eskaMakeId);

			sb.append(", eskaModelId=");
			sb.append(eskaModelId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAtmcYakeenMakeModelException(sb.toString());
		}

		return atmcYakeenMakeModel;
	}

	/**
	 * Returns the atmc yakeen make model where eskaMakeId = &#63; and eskaModelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param eskaMakeId the eska make ID
	 * @param eskaModelId the eska model ID
	 * @return the matching atmc yakeen make model, or <code>null</code> if a matching atmc yakeen make model could not be found
	 */
	@Override
	public AtmcYakeenMakeModel fetchByEskaMakeModelDetails(
		String eskaMakeId, String eskaModelId) {

		return fetchByEskaMakeModelDetails(eskaMakeId, eskaModelId, true);
	}

	/**
	 * Returns the atmc yakeen make model where eskaMakeId = &#63; and eskaModelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param eskaMakeId the eska make ID
	 * @param eskaModelId the eska model ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching atmc yakeen make model, or <code>null</code> if a matching atmc yakeen make model could not be found
	 */
	@Override
	public AtmcYakeenMakeModel fetchByEskaMakeModelDetails(
		String eskaMakeId, String eskaModelId, boolean useFinderCache) {

		eskaMakeId = Objects.toString(eskaMakeId, "");
		eskaModelId = Objects.toString(eskaModelId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {eskaMakeId, eskaModelId};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByEskaMakeModelDetails, finderArgs, this);
		}

		if (result instanceof AtmcYakeenMakeModel) {
			AtmcYakeenMakeModel atmcYakeenMakeModel =
				(AtmcYakeenMakeModel)result;

			if (!Objects.equals(
					eskaMakeId, atmcYakeenMakeModel.getEskaMakeId()) ||
				!Objects.equals(
					eskaModelId, atmcYakeenMakeModel.getEskaModelId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ATMCYAKEENMAKEMODEL_WHERE);

			boolean bindEskaMakeId = false;

			if (eskaMakeId.isEmpty()) {
				sb.append(_FINDER_COLUMN_ESKAMAKEMODELDETAILS_ESKAMAKEID_3);
			}
			else {
				bindEskaMakeId = true;

				sb.append(_FINDER_COLUMN_ESKAMAKEMODELDETAILS_ESKAMAKEID_2);
			}

			boolean bindEskaModelId = false;

			if (eskaModelId.isEmpty()) {
				sb.append(_FINDER_COLUMN_ESKAMAKEMODELDETAILS_ESKAMODELID_3);
			}
			else {
				bindEskaModelId = true;

				sb.append(_FINDER_COLUMN_ESKAMAKEMODELDETAILS_ESKAMODELID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEskaMakeId) {
					queryPos.add(eskaMakeId);
				}

				if (bindEskaModelId) {
					queryPos.add(eskaModelId);
				}

				List<AtmcYakeenMakeModel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByEskaMakeModelDetails, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									eskaMakeId, eskaModelId
								};
							}

							_log.warn(
								"AtmcYakeenMakeModelPersistenceImpl.fetchByEskaMakeModelDetails(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AtmcYakeenMakeModel atmcYakeenMakeModel = list.get(0);

					result = atmcYakeenMakeModel;

					cacheResult(atmcYakeenMakeModel);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (AtmcYakeenMakeModel)result;
		}
	}

	/**
	 * Removes the atmc yakeen make model where eskaMakeId = &#63; and eskaModelId = &#63; from the database.
	 *
	 * @param eskaMakeId the eska make ID
	 * @param eskaModelId the eska model ID
	 * @return the atmc yakeen make model that was removed
	 */
	@Override
	public AtmcYakeenMakeModel removeByEskaMakeModelDetails(
			String eskaMakeId, String eskaModelId)
		throws NoSuchAtmcYakeenMakeModelException {

		AtmcYakeenMakeModel atmcYakeenMakeModel = findByEskaMakeModelDetails(
			eskaMakeId, eskaModelId);

		return remove(atmcYakeenMakeModel);
	}

	/**
	 * Returns the number of atmc yakeen make models where eskaMakeId = &#63; and eskaModelId = &#63;.
	 *
	 * @param eskaMakeId the eska make ID
	 * @param eskaModelId the eska model ID
	 * @return the number of matching atmc yakeen make models
	 */
	@Override
	public int countByEskaMakeModelDetails(
		String eskaMakeId, String eskaModelId) {

		eskaMakeId = Objects.toString(eskaMakeId, "");
		eskaModelId = Objects.toString(eskaModelId, "");

		FinderPath finderPath = _finderPathCountByEskaMakeModelDetails;

		Object[] finderArgs = new Object[] {eskaMakeId, eskaModelId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ATMCYAKEENMAKEMODEL_WHERE);

			boolean bindEskaMakeId = false;

			if (eskaMakeId.isEmpty()) {
				sb.append(_FINDER_COLUMN_ESKAMAKEMODELDETAILS_ESKAMAKEID_3);
			}
			else {
				bindEskaMakeId = true;

				sb.append(_FINDER_COLUMN_ESKAMAKEMODELDETAILS_ESKAMAKEID_2);
			}

			boolean bindEskaModelId = false;

			if (eskaModelId.isEmpty()) {
				sb.append(_FINDER_COLUMN_ESKAMAKEMODELDETAILS_ESKAMODELID_3);
			}
			else {
				bindEskaModelId = true;

				sb.append(_FINDER_COLUMN_ESKAMAKEMODELDETAILS_ESKAMODELID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEskaMakeId) {
					queryPos.add(eskaMakeId);
				}

				if (bindEskaModelId) {
					queryPos.add(eskaModelId);
				}

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_ESKAMAKEMODELDETAILS_ESKAMAKEID_2 =
			"atmcYakeenMakeModel.eskaMakeId = ? AND ";

	private static final String
		_FINDER_COLUMN_ESKAMAKEMODELDETAILS_ESKAMAKEID_3 =
			"(atmcYakeenMakeModel.eskaMakeId IS NULL OR atmcYakeenMakeModel.eskaMakeId = '') AND ";

	private static final String
		_FINDER_COLUMN_ESKAMAKEMODELDETAILS_ESKAMODELID_2 =
			"atmcYakeenMakeModel.eskaModelId = ?";

	private static final String
		_FINDER_COLUMN_ESKAMAKEMODELDETAILS_ESKAMODELID_3 =
			"(atmcYakeenMakeModel.eskaModelId IS NULL OR atmcYakeenMakeModel.eskaModelId = '')";

	public AtmcYakeenMakeModelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("yakeenMakeId", "YAKEENMAKEID");
		dbColumnNames.put("yakeenMakeValue", "YAKEENELMMAKEVALUE");
		dbColumnNames.put("yakeenMakeDesc", "YAKEENMAKEDESC");
		dbColumnNames.put("yakeenMakeMap", "YAKEENMAKEMAP");
		dbColumnNames.put("yakeenModelId", "YAKEENMODELID");
		dbColumnNames.put("yakeenModelArabic", "YAKEENMODELARABIC");
		dbColumnNames.put("yakeenModelEnglish", "YAKEENMODELENGLISH");
		dbColumnNames.put("yakeenNodelMap", "YAKEENMODELMAP");
		dbColumnNames.put("yakeenModelValue", "YAKEENELMMODELVALUE");
		dbColumnNames.put("atmcVehicleNationality", "ATMCVEHICLENATIONALITY");
		dbColumnNames.put("atmcBodyType", "ATMCBODYTYPE");
		dbColumnNames.put("atmcSeatingCapacity", "ATMCSEATINGCAPACITY");
		dbColumnNames.put("mapMakeModelName", "MAPMAKEMODELNAME");
		dbColumnNames.put("eskaMakeId", "ESKAMAKEID");
		dbColumnNames.put("eskaModelId", "ESKAMODELID");
		dbColumnNames.put("mapMakeModelId", "MAPMAKEMODELID");
		dbColumnNames.put("eskaBodyTypeId", "ESKABODYTYPEID");
		dbColumnNames.put("eskaVehNationalityId", "ESKAVEHNALTIONALITYID");

		setDBColumnNames(dbColumnNames);

		setModelClass(AtmcYakeenMakeModel.class);

		setModelImplClass(AtmcYakeenMakeModelImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the atmc yakeen make model in the entity cache if it is enabled.
	 *
	 * @param atmcYakeenMakeModel the atmc yakeen make model
	 */
	@Override
	public void cacheResult(AtmcYakeenMakeModel atmcYakeenMakeModel) {
		dummyEntityCache.putResult(
			AtmcYakeenMakeModelImpl.class, atmcYakeenMakeModel.getPrimaryKey(),
			atmcYakeenMakeModel);

		dummyFinderCache.putResult(
			_finderPathFetchByYakeenMakeModelDetails,
			new Object[] {
				atmcYakeenMakeModel.getYakeenMakeValue(),
				atmcYakeenMakeModel.getYakeenModelValue()
			},
			atmcYakeenMakeModel);

		dummyFinderCache.putResult(
			_finderPathFetchByEskaMakeModelDetails,
			new Object[] {
				atmcYakeenMakeModel.getEskaMakeId(),
				atmcYakeenMakeModel.getEskaModelId()
			},
			atmcYakeenMakeModel);
	}

	/**
	 * Caches the atmc yakeen make models in the entity cache if it is enabled.
	 *
	 * @param atmcYakeenMakeModels the atmc yakeen make models
	 */
	@Override
	public void cacheResult(List<AtmcYakeenMakeModel> atmcYakeenMakeModels) {
		for (AtmcYakeenMakeModel atmcYakeenMakeModel : atmcYakeenMakeModels) {
			if (dummyEntityCache.getResult(
					AtmcYakeenMakeModelImpl.class,
					atmcYakeenMakeModel.getPrimaryKey()) == null) {

				cacheResult(atmcYakeenMakeModel);
			}
		}
	}

	/**
	 * Clears the cache for all atmc yakeen make models.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(AtmcYakeenMakeModelImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the atmc yakeen make model.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AtmcYakeenMakeModel atmcYakeenMakeModel) {
		dummyEntityCache.removeResult(
			AtmcYakeenMakeModelImpl.class, atmcYakeenMakeModel);
	}

	@Override
	public void clearCache(List<AtmcYakeenMakeModel> atmcYakeenMakeModels) {
		for (AtmcYakeenMakeModel atmcYakeenMakeModel : atmcYakeenMakeModels) {
			dummyEntityCache.removeResult(
				AtmcYakeenMakeModelImpl.class, atmcYakeenMakeModel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				AtmcYakeenMakeModelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AtmcYakeenMakeModelModelImpl atmcYakeenMakeModelModelImpl) {

		Object[] args = new Object[] {
			atmcYakeenMakeModelModelImpl.getYakeenMakeValue(),
			atmcYakeenMakeModelModelImpl.getYakeenModelValue()
		};

		dummyFinderCache.putResult(
			_finderPathCountByYakeenMakeModelDetails, args, Long.valueOf(1),
			false);
		dummyFinderCache.putResult(
			_finderPathFetchByYakeenMakeModelDetails, args,
			atmcYakeenMakeModelModelImpl, false);

		args = new Object[] {
			atmcYakeenMakeModelModelImpl.getEskaMakeId(),
			atmcYakeenMakeModelModelImpl.getEskaModelId()
		};

		dummyFinderCache.putResult(
			_finderPathCountByEskaMakeModelDetails, args, Long.valueOf(1),
			false);
		dummyFinderCache.putResult(
			_finderPathFetchByEskaMakeModelDetails, args,
			atmcYakeenMakeModelModelImpl, false);
	}

	/**
	 * Creates a new atmc yakeen make model with the primary key. Does not add the atmc yakeen make model to the database.
	 *
	 * @param yakeenMakeId the primary key for the new atmc yakeen make model
	 * @return the new atmc yakeen make model
	 */
	@Override
	public AtmcYakeenMakeModel create(long yakeenMakeId) {
		AtmcYakeenMakeModel atmcYakeenMakeModel = new AtmcYakeenMakeModelImpl();

		atmcYakeenMakeModel.setNew(true);
		atmcYakeenMakeModel.setPrimaryKey(yakeenMakeId);

		return atmcYakeenMakeModel;
	}

	/**
	 * Removes the atmc yakeen make model with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param yakeenMakeId the primary key of the atmc yakeen make model
	 * @return the atmc yakeen make model that was removed
	 * @throws NoSuchAtmcYakeenMakeModelException if a atmc yakeen make model with the primary key could not be found
	 */
	@Override
	public AtmcYakeenMakeModel remove(long yakeenMakeId)
		throws NoSuchAtmcYakeenMakeModelException {

		return remove((Serializable)yakeenMakeId);
	}

	/**
	 * Removes the atmc yakeen make model with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the atmc yakeen make model
	 * @return the atmc yakeen make model that was removed
	 * @throws NoSuchAtmcYakeenMakeModelException if a atmc yakeen make model with the primary key could not be found
	 */
	@Override
	public AtmcYakeenMakeModel remove(Serializable primaryKey)
		throws NoSuchAtmcYakeenMakeModelException {

		Session session = null;

		try {
			session = openSession();

			AtmcYakeenMakeModel atmcYakeenMakeModel =
				(AtmcYakeenMakeModel)session.get(
					AtmcYakeenMakeModelImpl.class, primaryKey);

			if (atmcYakeenMakeModel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAtmcYakeenMakeModelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(atmcYakeenMakeModel);
		}
		catch (NoSuchAtmcYakeenMakeModelException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AtmcYakeenMakeModel removeImpl(
		AtmcYakeenMakeModel atmcYakeenMakeModel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(atmcYakeenMakeModel)) {
				atmcYakeenMakeModel = (AtmcYakeenMakeModel)session.get(
					AtmcYakeenMakeModelImpl.class,
					atmcYakeenMakeModel.getPrimaryKeyObj());
			}

			if (atmcYakeenMakeModel != null) {
				session.delete(atmcYakeenMakeModel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (atmcYakeenMakeModel != null) {
			clearCache(atmcYakeenMakeModel);
		}

		return atmcYakeenMakeModel;
	}

	@Override
	public AtmcYakeenMakeModel updateImpl(
		AtmcYakeenMakeModel atmcYakeenMakeModel) {

		boolean isNew = atmcYakeenMakeModel.isNew();

		if (!(atmcYakeenMakeModel instanceof AtmcYakeenMakeModelModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(atmcYakeenMakeModel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					atmcYakeenMakeModel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in atmcYakeenMakeModel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AtmcYakeenMakeModel implementation " +
					atmcYakeenMakeModel.getClass());
		}

		AtmcYakeenMakeModelModelImpl atmcYakeenMakeModelModelImpl =
			(AtmcYakeenMakeModelModelImpl)atmcYakeenMakeModel;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(atmcYakeenMakeModel);
			}
			else {
				atmcYakeenMakeModel = (AtmcYakeenMakeModel)session.merge(
					atmcYakeenMakeModel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			AtmcYakeenMakeModelImpl.class, atmcYakeenMakeModelModelImpl, false,
			true);

		cacheUniqueFindersCache(atmcYakeenMakeModelModelImpl);

		if (isNew) {
			atmcYakeenMakeModel.setNew(false);
		}

		atmcYakeenMakeModel.resetOriginalValues();

		return atmcYakeenMakeModel;
	}

	/**
	 * Returns the atmc yakeen make model with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the atmc yakeen make model
	 * @return the atmc yakeen make model
	 * @throws NoSuchAtmcYakeenMakeModelException if a atmc yakeen make model with the primary key could not be found
	 */
	@Override
	public AtmcYakeenMakeModel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAtmcYakeenMakeModelException {

		AtmcYakeenMakeModel atmcYakeenMakeModel = fetchByPrimaryKey(primaryKey);

		if (atmcYakeenMakeModel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAtmcYakeenMakeModelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return atmcYakeenMakeModel;
	}

	/**
	 * Returns the atmc yakeen make model with the primary key or throws a <code>NoSuchAtmcYakeenMakeModelException</code> if it could not be found.
	 *
	 * @param yakeenMakeId the primary key of the atmc yakeen make model
	 * @return the atmc yakeen make model
	 * @throws NoSuchAtmcYakeenMakeModelException if a atmc yakeen make model with the primary key could not be found
	 */
	@Override
	public AtmcYakeenMakeModel findByPrimaryKey(long yakeenMakeId)
		throws NoSuchAtmcYakeenMakeModelException {

		return findByPrimaryKey((Serializable)yakeenMakeId);
	}

	/**
	 * Returns the atmc yakeen make model with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param yakeenMakeId the primary key of the atmc yakeen make model
	 * @return the atmc yakeen make model, or <code>null</code> if a atmc yakeen make model with the primary key could not be found
	 */
	@Override
	public AtmcYakeenMakeModel fetchByPrimaryKey(long yakeenMakeId) {
		return fetchByPrimaryKey((Serializable)yakeenMakeId);
	}

	/**
	 * Returns all the atmc yakeen make models.
	 *
	 * @return the atmc yakeen make models
	 */
	@Override
	public List<AtmcYakeenMakeModel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the atmc yakeen make models.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AtmcYakeenMakeModelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of atmc yakeen make models
	 * @param end the upper bound of the range of atmc yakeen make models (not inclusive)
	 * @return the range of atmc yakeen make models
	 */
	@Override
	public List<AtmcYakeenMakeModel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the atmc yakeen make models.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AtmcYakeenMakeModelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of atmc yakeen make models
	 * @param end the upper bound of the range of atmc yakeen make models (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of atmc yakeen make models
	 */
	@Override
	public List<AtmcYakeenMakeModel> findAll(
		int start, int end,
		OrderByComparator<AtmcYakeenMakeModel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the atmc yakeen make models.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AtmcYakeenMakeModelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of atmc yakeen make models
	 * @param end the upper bound of the range of atmc yakeen make models (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of atmc yakeen make models
	 */
	@Override
	public List<AtmcYakeenMakeModel> findAll(
		int start, int end,
		OrderByComparator<AtmcYakeenMakeModel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<AtmcYakeenMakeModel> list = null;

		if (useFinderCache) {
			list = (List<AtmcYakeenMakeModel>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ATMCYAKEENMAKEMODEL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ATMCYAKEENMAKEMODEL;

				sql = sql.concat(AtmcYakeenMakeModelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AtmcYakeenMakeModel>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the atmc yakeen make models from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AtmcYakeenMakeModel atmcYakeenMakeModel : findAll()) {
			remove(atmcYakeenMakeModel);
		}
	}

	/**
	 * Returns the number of atmc yakeen make models.
	 *
	 * @return the number of atmc yakeen make models
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_ATMCYAKEENMAKEMODEL);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "YAKEENMAKEID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ATMCYAKEENMAKEMODEL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AtmcYakeenMakeModelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the atmc yakeen make model persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new AtmcYakeenMakeModelModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", AtmcYakeenMakeModel.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByYakeenMakeModelDetails = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByYakeenMakeModelDetails",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"YAKEENELMMAKEVALUE", "YAKEENELMMODELVALUE"}, true);

		_finderPathCountByYakeenMakeModelDetails = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByYakeenMakeModelDetails",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"YAKEENELMMAKEVALUE", "YAKEENELMMODELVALUE"}, false);

		_finderPathFetchByEskaMakeModelDetails = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByEskaMakeModelDetails",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"ESKAMAKEID", "ESKAMODELID"}, true);

		_finderPathCountByEskaMakeModelDetails = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEskaMakeModelDetails",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"ESKAMAKEID", "ESKAMODELID"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(AtmcYakeenMakeModelImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = DBACLPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DBACLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DBACLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	private static final String _SQL_SELECT_ATMCYAKEENMAKEMODEL =
		"SELECT atmcYakeenMakeModel FROM AtmcYakeenMakeModel atmcYakeenMakeModel";

	private static final String _SQL_SELECT_ATMCYAKEENMAKEMODEL_WHERE =
		"SELECT atmcYakeenMakeModel FROM AtmcYakeenMakeModel atmcYakeenMakeModel WHERE ";

	private static final String _SQL_COUNT_ATMCYAKEENMAKEMODEL =
		"SELECT COUNT(atmcYakeenMakeModel) FROM AtmcYakeenMakeModel atmcYakeenMakeModel";

	private static final String _SQL_COUNT_ATMCYAKEENMAKEMODEL_WHERE =
		"SELECT COUNT(atmcYakeenMakeModel) FROM AtmcYakeenMakeModel atmcYakeenMakeModel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "atmcYakeenMakeModel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AtmcYakeenMakeModel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AtmcYakeenMakeModel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AtmcYakeenMakeModelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"yakeenMakeId", "yakeenMakeValue", "yakeenMakeDesc",
			"yakeenMakeMap", "yakeenModelId", "yakeenModelArabic",
			"yakeenModelEnglish", "yakeenNodelMap", "yakeenModelValue",
			"atmcVehicleNationality", "atmcBodyType", "atmcSeatingCapacity",
			"mapMakeModelName", "eskaMakeId", "eskaModelId", "mapMakeModelId",
			"eskaBodyTypeId", "eskaVehNationalityId"
		});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class AtmcYakeenMakeModelModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			AtmcYakeenMakeModelModelImpl atmcYakeenMakeModelModelImpl =
				(AtmcYakeenMakeModelModelImpl)baseModel;

			long columnBitmask =
				atmcYakeenMakeModelModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					atmcYakeenMakeModelModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						atmcYakeenMakeModelModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					atmcYakeenMakeModelModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			AtmcYakeenMakeModelModelImpl atmcYakeenMakeModelModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						atmcYakeenMakeModelModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = atmcYakeenMakeModelModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}