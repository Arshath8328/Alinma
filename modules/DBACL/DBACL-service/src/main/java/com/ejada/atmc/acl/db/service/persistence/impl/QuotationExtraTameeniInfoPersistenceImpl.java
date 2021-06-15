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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationExtraTameeniInfoException;
import com.ejada.atmc.acl.db.model.QuotationExtraTameeniInfo;
import com.ejada.atmc.acl.db.model.impl.QuotationExtraTameeniInfoImpl;
import com.ejada.atmc.acl.db.model.impl.QuotationExtraTameeniInfoModelImpl;
import com.ejada.atmc.acl.db.service.persistence.QuotationExtraTameeniInfoPersistence;
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
 * The persistence implementation for the quotation extra tameeni info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = QuotationExtraTameeniInfoPersistence.class)
public class QuotationExtraTameeniInfoPersistenceImpl
	extends BasePersistenceImpl<QuotationExtraTameeniInfo>
	implements QuotationExtraTameeniInfoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>QuotationExtraTameeniInfoUtil</code> to access the quotation extra tameeni info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		QuotationExtraTameeniInfoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByQuotationId;
	private FinderPath _finderPathCountByQuotationId;

	/**
	 * Returns the quotation extra tameeni info where quotationId = &#63; or throws a <code>NoSuchQuotationExtraTameeniInfoException</code> if it could not be found.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation extra tameeni info
	 * @throws NoSuchQuotationExtraTameeniInfoException if a matching quotation extra tameeni info could not be found
	 */
	@Override
	public QuotationExtraTameeniInfo findByQuotationId(long quotationId)
		throws NoSuchQuotationExtraTameeniInfoException {

		QuotationExtraTameeniInfo quotationExtraTameeniInfo =
			fetchByQuotationId(quotationId);

		if (quotationExtraTameeniInfo == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("quotationId=");
			sb.append(quotationId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchQuotationExtraTameeniInfoException(sb.toString());
		}

		return quotationExtraTameeniInfo;
	}

	/**
	 * Returns the quotation extra tameeni info where quotationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation extra tameeni info, or <code>null</code> if a matching quotation extra tameeni info could not be found
	 */
	@Override
	public QuotationExtraTameeniInfo fetchByQuotationId(long quotationId) {
		return fetchByQuotationId(quotationId, true);
	}

	/**
	 * Returns the quotation extra tameeni info where quotationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quotationId the quotation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotation extra tameeni info, or <code>null</code> if a matching quotation extra tameeni info could not be found
	 */
	@Override
	public QuotationExtraTameeniInfo fetchByQuotationId(
		long quotationId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {quotationId};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByQuotationId, finderArgs, this);
		}

		if (result instanceof QuotationExtraTameeniInfo) {
			QuotationExtraTameeniInfo quotationExtraTameeniInfo =
				(QuotationExtraTameeniInfo)result;

			if (quotationId != quotationExtraTameeniInfo.getQuotationId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_QUOTATIONEXTRATAMEENIINFO_WHERE);

			sb.append(_FINDER_COLUMN_QUOTATIONID_QUOTATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(quotationId);

				List<QuotationExtraTameeniInfo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByQuotationId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {quotationId};
							}

							_log.warn(
								"QuotationExtraTameeniInfoPersistenceImpl.fetchByQuotationId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					QuotationExtraTameeniInfo quotationExtraTameeniInfo =
						list.get(0);

					result = quotationExtraTameeniInfo;

					cacheResult(quotationExtraTameeniInfo);
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
			return (QuotationExtraTameeniInfo)result;
		}
	}

	/**
	 * Removes the quotation extra tameeni info where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 * @return the quotation extra tameeni info that was removed
	 */
	@Override
	public QuotationExtraTameeniInfo removeByQuotationId(long quotationId)
		throws NoSuchQuotationExtraTameeniInfoException {

		QuotationExtraTameeniInfo quotationExtraTameeniInfo = findByQuotationId(
			quotationId);

		return remove(quotationExtraTameeniInfo);
	}

	/**
	 * Returns the number of quotation extra tameeni infos where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation extra tameeni infos
	 */
	@Override
	public int countByQuotationId(long quotationId) {
		FinderPath finderPath = _finderPathCountByQuotationId;

		Object[] finderArgs = new Object[] {quotationId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUOTATIONEXTRATAMEENIINFO_WHERE);

			sb.append(_FINDER_COLUMN_QUOTATIONID_QUOTATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(quotationId);

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

	private static final String _FINDER_COLUMN_QUOTATIONID_QUOTATIONID_2 =
		"quotationExtraTameeniInfo.quotationId = ?";

	public QuotationExtraTameeniInfoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("quotationId", "QUOTATION_ID");
		dbColumnNames.put("insuredFirstName", "INSURED_FIRST_NAME");
		dbColumnNames.put("insuredMiddleName", "INSURED_MIDDLE_NAME");
		dbColumnNames.put("insuredLastName", "INSURED_LAST_NAME");
		dbColumnNames.put("isDriverDisabled", "IS_DRIVER_DISABLED");
		dbColumnNames.put(
			"vehicleMakeCodeTameeni", "VEHICLE_MAKE_CODE_TAMEENI");
		dbColumnNames.put("coverAgeLimit", "COVER_AGE_LIMIT");
		dbColumnNames.put("insuredNameLang", "INSURED_NAME_LANG");
		dbColumnNames.put("policyTitleId", "POLICY_TITLE_ID");
		dbColumnNames.put("isRenewal", "IS_RENEWAL");

		setDBColumnNames(dbColumnNames);

		setModelClass(QuotationExtraTameeniInfo.class);

		setModelImplClass(QuotationExtraTameeniInfoImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the quotation extra tameeni info in the entity cache if it is enabled.
	 *
	 * @param quotationExtraTameeniInfo the quotation extra tameeni info
	 */
	@Override
	public void cacheResult(
		QuotationExtraTameeniInfo quotationExtraTameeniInfo) {

		dummyEntityCache.putResult(
			QuotationExtraTameeniInfoImpl.class,
			quotationExtraTameeniInfo.getPrimaryKey(),
			quotationExtraTameeniInfo);

		dummyFinderCache.putResult(
			_finderPathFetchByQuotationId,
			new Object[] {quotationExtraTameeniInfo.getQuotationId()},
			quotationExtraTameeniInfo);
	}

	/**
	 * Caches the quotation extra tameeni infos in the entity cache if it is enabled.
	 *
	 * @param quotationExtraTameeniInfos the quotation extra tameeni infos
	 */
	@Override
	public void cacheResult(
		List<QuotationExtraTameeniInfo> quotationExtraTameeniInfos) {

		for (QuotationExtraTameeniInfo quotationExtraTameeniInfo :
				quotationExtraTameeniInfos) {

			if (dummyEntityCache.getResult(
					QuotationExtraTameeniInfoImpl.class,
					quotationExtraTameeniInfo.getPrimaryKey()) == null) {

				cacheResult(quotationExtraTameeniInfo);
			}
		}
	}

	/**
	 * Clears the cache for all quotation extra tameeni infos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(QuotationExtraTameeniInfoImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the quotation extra tameeni info.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		QuotationExtraTameeniInfo quotationExtraTameeniInfo) {

		dummyEntityCache.removeResult(
			QuotationExtraTameeniInfoImpl.class, quotationExtraTameeniInfo);
	}

	@Override
	public void clearCache(
		List<QuotationExtraTameeniInfo> quotationExtraTameeniInfos) {

		for (QuotationExtraTameeniInfo quotationExtraTameeniInfo :
				quotationExtraTameeniInfos) {

			dummyEntityCache.removeResult(
				QuotationExtraTameeniInfoImpl.class, quotationExtraTameeniInfo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				QuotationExtraTameeniInfoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		QuotationExtraTameeniInfoModelImpl quotationExtraTameeniInfoModelImpl) {

		Object[] args = new Object[] {
			quotationExtraTameeniInfoModelImpl.getQuotationId()
		};

		dummyFinderCache.putResult(
			_finderPathCountByQuotationId, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchByQuotationId, args,
			quotationExtraTameeniInfoModelImpl, false);
	}

	/**
	 * Creates a new quotation extra tameeni info with the primary key. Does not add the quotation extra tameeni info to the database.
	 *
	 * @param quotationId the primary key for the new quotation extra tameeni info
	 * @return the new quotation extra tameeni info
	 */
	@Override
	public QuotationExtraTameeniInfo create(long quotationId) {
		QuotationExtraTameeniInfo quotationExtraTameeniInfo =
			new QuotationExtraTameeniInfoImpl();

		quotationExtraTameeniInfo.setNew(true);
		quotationExtraTameeniInfo.setPrimaryKey(quotationId);

		return quotationExtraTameeniInfo;
	}

	/**
	 * Removes the quotation extra tameeni info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quotationId the primary key of the quotation extra tameeni info
	 * @return the quotation extra tameeni info that was removed
	 * @throws NoSuchQuotationExtraTameeniInfoException if a quotation extra tameeni info with the primary key could not be found
	 */
	@Override
	public QuotationExtraTameeniInfo remove(long quotationId)
		throws NoSuchQuotationExtraTameeniInfoException {

		return remove((Serializable)quotationId);
	}

	/**
	 * Removes the quotation extra tameeni info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the quotation extra tameeni info
	 * @return the quotation extra tameeni info that was removed
	 * @throws NoSuchQuotationExtraTameeniInfoException if a quotation extra tameeni info with the primary key could not be found
	 */
	@Override
	public QuotationExtraTameeniInfo remove(Serializable primaryKey)
		throws NoSuchQuotationExtraTameeniInfoException {

		Session session = null;

		try {
			session = openSession();

			QuotationExtraTameeniInfo quotationExtraTameeniInfo =
				(QuotationExtraTameeniInfo)session.get(
					QuotationExtraTameeniInfoImpl.class, primaryKey);

			if (quotationExtraTameeniInfo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuotationExtraTameeniInfoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(quotationExtraTameeniInfo);
		}
		catch (NoSuchQuotationExtraTameeniInfoException noSuchEntityException) {
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
	protected QuotationExtraTameeniInfo removeImpl(
		QuotationExtraTameeniInfo quotationExtraTameeniInfo) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(quotationExtraTameeniInfo)) {
				quotationExtraTameeniInfo =
					(QuotationExtraTameeniInfo)session.get(
						QuotationExtraTameeniInfoImpl.class,
						quotationExtraTameeniInfo.getPrimaryKeyObj());
			}

			if (quotationExtraTameeniInfo != null) {
				session.delete(quotationExtraTameeniInfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (quotationExtraTameeniInfo != null) {
			clearCache(quotationExtraTameeniInfo);
		}

		return quotationExtraTameeniInfo;
	}

	@Override
	public QuotationExtraTameeniInfo updateImpl(
		QuotationExtraTameeniInfo quotationExtraTameeniInfo) {

		boolean isNew = quotationExtraTameeniInfo.isNew();

		if (!(quotationExtraTameeniInfo instanceof
				QuotationExtraTameeniInfoModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(quotationExtraTameeniInfo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					quotationExtraTameeniInfo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in quotationExtraTameeniInfo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom QuotationExtraTameeniInfo implementation " +
					quotationExtraTameeniInfo.getClass());
		}

		QuotationExtraTameeniInfoModelImpl quotationExtraTameeniInfoModelImpl =
			(QuotationExtraTameeniInfoModelImpl)quotationExtraTameeniInfo;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(quotationExtraTameeniInfo);
			}
			else {
				quotationExtraTameeniInfo =
					(QuotationExtraTameeniInfo)session.merge(
						quotationExtraTameeniInfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			QuotationExtraTameeniInfoImpl.class,
			quotationExtraTameeniInfoModelImpl, false, true);

		cacheUniqueFindersCache(quotationExtraTameeniInfoModelImpl);

		if (isNew) {
			quotationExtraTameeniInfo.setNew(false);
		}

		quotationExtraTameeniInfo.resetOriginalValues();

		return quotationExtraTameeniInfo;
	}

	/**
	 * Returns the quotation extra tameeni info with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the quotation extra tameeni info
	 * @return the quotation extra tameeni info
	 * @throws NoSuchQuotationExtraTameeniInfoException if a quotation extra tameeni info with the primary key could not be found
	 */
	@Override
	public QuotationExtraTameeniInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuotationExtraTameeniInfoException {

		QuotationExtraTameeniInfo quotationExtraTameeniInfo = fetchByPrimaryKey(
			primaryKey);

		if (quotationExtraTameeniInfo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuotationExtraTameeniInfoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return quotationExtraTameeniInfo;
	}

	/**
	 * Returns the quotation extra tameeni info with the primary key or throws a <code>NoSuchQuotationExtraTameeniInfoException</code> if it could not be found.
	 *
	 * @param quotationId the primary key of the quotation extra tameeni info
	 * @return the quotation extra tameeni info
	 * @throws NoSuchQuotationExtraTameeniInfoException if a quotation extra tameeni info with the primary key could not be found
	 */
	@Override
	public QuotationExtraTameeniInfo findByPrimaryKey(long quotationId)
		throws NoSuchQuotationExtraTameeniInfoException {

		return findByPrimaryKey((Serializable)quotationId);
	}

	/**
	 * Returns the quotation extra tameeni info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quotationId the primary key of the quotation extra tameeni info
	 * @return the quotation extra tameeni info, or <code>null</code> if a quotation extra tameeni info with the primary key could not be found
	 */
	@Override
	public QuotationExtraTameeniInfo fetchByPrimaryKey(long quotationId) {
		return fetchByPrimaryKey((Serializable)quotationId);
	}

	/**
	 * Returns all the quotation extra tameeni infos.
	 *
	 * @return the quotation extra tameeni infos
	 */
	@Override
	public List<QuotationExtraTameeniInfo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotation extra tameeni infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationExtraTameeniInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation extra tameeni infos
	 * @param end the upper bound of the range of quotation extra tameeni infos (not inclusive)
	 * @return the range of quotation extra tameeni infos
	 */
	@Override
	public List<QuotationExtraTameeniInfo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotation extra tameeni infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationExtraTameeniInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation extra tameeni infos
	 * @param end the upper bound of the range of quotation extra tameeni infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotation extra tameeni infos
	 */
	@Override
	public List<QuotationExtraTameeniInfo> findAll(
		int start, int end,
		OrderByComparator<QuotationExtraTameeniInfo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotation extra tameeni infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationExtraTameeniInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation extra tameeni infos
	 * @param end the upper bound of the range of quotation extra tameeni infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotation extra tameeni infos
	 */
	@Override
	public List<QuotationExtraTameeniInfo> findAll(
		int start, int end,
		OrderByComparator<QuotationExtraTameeniInfo> orderByComparator,
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

		List<QuotationExtraTameeniInfo> list = null;

		if (useFinderCache) {
			list = (List<QuotationExtraTameeniInfo>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_QUOTATIONEXTRATAMEENIINFO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_QUOTATIONEXTRATAMEENIINFO;

				sql = sql.concat(
					QuotationExtraTameeniInfoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<QuotationExtraTameeniInfo>)QueryUtil.list(
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
	 * Removes all the quotation extra tameeni infos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QuotationExtraTameeniInfo quotationExtraTameeniInfo : findAll()) {
			remove(quotationExtraTameeniInfo);
		}
	}

	/**
	 * Returns the number of quotation extra tameeni infos.
	 *
	 * @return the number of quotation extra tameeni infos
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
					_SQL_COUNT_QUOTATIONEXTRATAMEENIINFO);

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
		return "QUOTATION_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_QUOTATIONEXTRATAMEENIINFO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QuotationExtraTameeniInfoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the quotation extra tameeni info persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new QuotationExtraTameeniInfoModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", QuotationExtraTameeniInfo.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByQuotationId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByQuotationId",
			new String[] {Long.class.getName()}, new String[] {"QUOTATION_ID"},
			true);

		_finderPathCountByQuotationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuotationId",
			new String[] {Long.class.getName()}, new String[] {"QUOTATION_ID"},
			false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(
			QuotationExtraTameeniInfoImpl.class.getName());

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

	private static final String _SQL_SELECT_QUOTATIONEXTRATAMEENIINFO =
		"SELECT quotationExtraTameeniInfo FROM QuotationExtraTameeniInfo quotationExtraTameeniInfo";

	private static final String _SQL_SELECT_QUOTATIONEXTRATAMEENIINFO_WHERE =
		"SELECT quotationExtraTameeniInfo FROM QuotationExtraTameeniInfo quotationExtraTameeniInfo WHERE ";

	private static final String _SQL_COUNT_QUOTATIONEXTRATAMEENIINFO =
		"SELECT COUNT(quotationExtraTameeniInfo) FROM QuotationExtraTameeniInfo quotationExtraTameeniInfo";

	private static final String _SQL_COUNT_QUOTATIONEXTRATAMEENIINFO_WHERE =
		"SELECT COUNT(quotationExtraTameeniInfo) FROM QuotationExtraTameeniInfo quotationExtraTameeniInfo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"quotationExtraTameeniInfo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No QuotationExtraTameeniInfo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No QuotationExtraTameeniInfo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		QuotationExtraTameeniInfoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"quotationId", "insuredFirstName", "insuredMiddleName",
			"insuredLastName", "isDriverDisabled", "vehicleMakeCodeTameeni",
			"coverAgeLimit", "insuredNameLang", "policyTitleId", "isRenewal"
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

	private static class QuotationExtraTameeniInfoModelArgumentsResolver
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

			QuotationExtraTameeniInfoModelImpl
				quotationExtraTameeniInfoModelImpl =
					(QuotationExtraTameeniInfoModelImpl)baseModel;

			long columnBitmask =
				quotationExtraTameeniInfoModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					quotationExtraTameeniInfoModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						quotationExtraTameeniInfoModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					quotationExtraTameeniInfoModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			QuotationExtraTameeniInfoModelImpl
				quotationExtraTameeniInfoModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						quotationExtraTameeniInfoModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						quotationExtraTameeniInfoModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}