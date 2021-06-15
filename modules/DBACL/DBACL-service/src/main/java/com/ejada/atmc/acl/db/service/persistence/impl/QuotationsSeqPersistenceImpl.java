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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationsSeqException;
import com.ejada.atmc.acl.db.model.QuotationsSeq;
import com.ejada.atmc.acl.db.model.impl.QuotationsSeqImpl;
import com.ejada.atmc.acl.db.model.impl.QuotationsSeqModelImpl;
import com.ejada.atmc.acl.db.service.persistence.QuotationsSeqPersistence;
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
 * The persistence implementation for the quotations seq service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = QuotationsSeqPersistence.class)
public class QuotationsSeqPersistenceImpl
	extends BasePersistenceImpl<QuotationsSeq>
	implements QuotationsSeqPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>QuotationsSeqUtil</code> to access the quotations seq persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		QuotationsSeqImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByKey;
	private FinderPath _finderPathCountByKey;

	/**
	 * Returns the quotations seq where key = &#63; or throws a <code>NoSuchQuotationsSeqException</code> if it could not be found.
	 *
	 * @param key the key
	 * @return the matching quotations seq
	 * @throws NoSuchQuotationsSeqException if a matching quotations seq could not be found
	 */
	@Override
	public QuotationsSeq findByKey(String key)
		throws NoSuchQuotationsSeqException {

		QuotationsSeq quotationsSeq = fetchByKey(key);

		if (quotationsSeq == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("key=");
			sb.append(key);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchQuotationsSeqException(sb.toString());
		}

		return quotationsSeq;
	}

	/**
	 * Returns the quotations seq where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching quotations seq, or <code>null</code> if a matching quotations seq could not be found
	 */
	@Override
	public QuotationsSeq fetchByKey(String key) {
		return fetchByKey(key, true);
	}

	/**
	 * Returns the quotations seq where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotations seq, or <code>null</code> if a matching quotations seq could not be found
	 */
	@Override
	public QuotationsSeq fetchByKey(String key, boolean useFinderCache) {
		key = Objects.toString(key, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {key};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByKey, finderArgs, this);
		}

		if (result instanceof QuotationsSeq) {
			QuotationsSeq quotationsSeq = (QuotationsSeq)result;

			if (!Objects.equals(key, quotationsSeq.getKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_QUOTATIONSSEQ_WHERE);

			boolean bindKey = false;

			if (key.isEmpty()) {
				sb.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				sb.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindKey) {
					queryPos.add(key);
				}

				List<QuotationsSeq> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByKey, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {key};
							}

							_log.warn(
								"QuotationsSeqPersistenceImpl.fetchByKey(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					QuotationsSeq quotationsSeq = list.get(0);

					result = quotationsSeq;

					cacheResult(quotationsSeq);
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
			return (QuotationsSeq)result;
		}
	}

	/**
	 * Removes the quotations seq where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the quotations seq that was removed
	 */
	@Override
	public QuotationsSeq removeByKey(String key)
		throws NoSuchQuotationsSeqException {

		QuotationsSeq quotationsSeq = findByKey(key);

		return remove(quotationsSeq);
	}

	/**
	 * Returns the number of quotations seqs where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching quotations seqs
	 */
	@Override
	public int countByKey(String key) {
		key = Objects.toString(key, "");

		FinderPath finderPath = _finderPathCountByKey;

		Object[] finderArgs = new Object[] {key};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUOTATIONSSEQ_WHERE);

			boolean bindKey = false;

			if (key.isEmpty()) {
				sb.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				sb.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindKey) {
					queryPos.add(key);
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

	private static final String _FINDER_COLUMN_KEY_KEY_2 =
		"quotationsSeq.key = ?";

	private static final String _FINDER_COLUMN_KEY_KEY_3 =
		"(quotationsSeq.key IS NULL OR quotationsSeq.key = '')";

	public QuotationsSeqPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("key", "KEY");
		dbColumnNames.put("value", "VALUE");

		setDBColumnNames(dbColumnNames);

		setModelClass(QuotationsSeq.class);

		setModelImplClass(QuotationsSeqImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the quotations seq in the entity cache if it is enabled.
	 *
	 * @param quotationsSeq the quotations seq
	 */
	@Override
	public void cacheResult(QuotationsSeq quotationsSeq) {
		dummyEntityCache.putResult(
			QuotationsSeqImpl.class, quotationsSeq.getPrimaryKey(),
			quotationsSeq);

		dummyFinderCache.putResult(
			_finderPathFetchByKey, new Object[] {quotationsSeq.getKey()},
			quotationsSeq);
	}

	/**
	 * Caches the quotations seqs in the entity cache if it is enabled.
	 *
	 * @param quotationsSeqs the quotations seqs
	 */
	@Override
	public void cacheResult(List<QuotationsSeq> quotationsSeqs) {
		for (QuotationsSeq quotationsSeq : quotationsSeqs) {
			if (dummyEntityCache.getResult(
					QuotationsSeqImpl.class, quotationsSeq.getPrimaryKey()) ==
						null) {

				cacheResult(quotationsSeq);
			}
		}
	}

	/**
	 * Clears the cache for all quotations seqs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(QuotationsSeqImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the quotations seq.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuotationsSeq quotationsSeq) {
		dummyEntityCache.removeResult(QuotationsSeqImpl.class, quotationsSeq);
	}

	@Override
	public void clearCache(List<QuotationsSeq> quotationsSeqs) {
		for (QuotationsSeq quotationsSeq : quotationsSeqs) {
			dummyEntityCache.removeResult(
				QuotationsSeqImpl.class, quotationsSeq);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(QuotationsSeqImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		QuotationsSeqModelImpl quotationsSeqModelImpl) {

		Object[] args = new Object[] {quotationsSeqModelImpl.getKey()};

		dummyFinderCache.putResult(
			_finderPathCountByKey, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchByKey, args, quotationsSeqModelImpl, false);
	}

	/**
	 * Creates a new quotations seq with the primary key. Does not add the quotations seq to the database.
	 *
	 * @param key the primary key for the new quotations seq
	 * @return the new quotations seq
	 */
	@Override
	public QuotationsSeq create(String key) {
		QuotationsSeq quotationsSeq = new QuotationsSeqImpl();

		quotationsSeq.setNew(true);
		quotationsSeq.setPrimaryKey(key);

		return quotationsSeq;
	}

	/**
	 * Removes the quotations seq with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param key the primary key of the quotations seq
	 * @return the quotations seq that was removed
	 * @throws NoSuchQuotationsSeqException if a quotations seq with the primary key could not be found
	 */
	@Override
	public QuotationsSeq remove(String key)
		throws NoSuchQuotationsSeqException {

		return remove((Serializable)key);
	}

	/**
	 * Removes the quotations seq with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the quotations seq
	 * @return the quotations seq that was removed
	 * @throws NoSuchQuotationsSeqException if a quotations seq with the primary key could not be found
	 */
	@Override
	public QuotationsSeq remove(Serializable primaryKey)
		throws NoSuchQuotationsSeqException {

		Session session = null;

		try {
			session = openSession();

			QuotationsSeq quotationsSeq = (QuotationsSeq)session.get(
				QuotationsSeqImpl.class, primaryKey);

			if (quotationsSeq == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuotationsSeqException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(quotationsSeq);
		}
		catch (NoSuchQuotationsSeqException noSuchEntityException) {
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
	protected QuotationsSeq removeImpl(QuotationsSeq quotationsSeq) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(quotationsSeq)) {
				quotationsSeq = (QuotationsSeq)session.get(
					QuotationsSeqImpl.class, quotationsSeq.getPrimaryKeyObj());
			}

			if (quotationsSeq != null) {
				session.delete(quotationsSeq);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (quotationsSeq != null) {
			clearCache(quotationsSeq);
		}

		return quotationsSeq;
	}

	@Override
	public QuotationsSeq updateImpl(QuotationsSeq quotationsSeq) {
		boolean isNew = quotationsSeq.isNew();

		if (!(quotationsSeq instanceof QuotationsSeqModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(quotationsSeq.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					quotationsSeq);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in quotationsSeq proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom QuotationsSeq implementation " +
					quotationsSeq.getClass());
		}

		QuotationsSeqModelImpl quotationsSeqModelImpl =
			(QuotationsSeqModelImpl)quotationsSeq;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(quotationsSeq);
			}
			else {
				quotationsSeq = (QuotationsSeq)session.merge(quotationsSeq);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			QuotationsSeqImpl.class, quotationsSeqModelImpl, false, true);

		cacheUniqueFindersCache(quotationsSeqModelImpl);

		if (isNew) {
			quotationsSeq.setNew(false);
		}

		quotationsSeq.resetOriginalValues();

		return quotationsSeq;
	}

	/**
	 * Returns the quotations seq with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the quotations seq
	 * @return the quotations seq
	 * @throws NoSuchQuotationsSeqException if a quotations seq with the primary key could not be found
	 */
	@Override
	public QuotationsSeq findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuotationsSeqException {

		QuotationsSeq quotationsSeq = fetchByPrimaryKey(primaryKey);

		if (quotationsSeq == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuotationsSeqException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return quotationsSeq;
	}

	/**
	 * Returns the quotations seq with the primary key or throws a <code>NoSuchQuotationsSeqException</code> if it could not be found.
	 *
	 * @param key the primary key of the quotations seq
	 * @return the quotations seq
	 * @throws NoSuchQuotationsSeqException if a quotations seq with the primary key could not be found
	 */
	@Override
	public QuotationsSeq findByPrimaryKey(String key)
		throws NoSuchQuotationsSeqException {

		return findByPrimaryKey((Serializable)key);
	}

	/**
	 * Returns the quotations seq with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param key the primary key of the quotations seq
	 * @return the quotations seq, or <code>null</code> if a quotations seq with the primary key could not be found
	 */
	@Override
	public QuotationsSeq fetchByPrimaryKey(String key) {
		return fetchByPrimaryKey((Serializable)key);
	}

	/**
	 * Returns all the quotations seqs.
	 *
	 * @return the quotations seqs
	 */
	@Override
	public List<QuotationsSeq> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotations seqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsSeqModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations seqs
	 * @param end the upper bound of the range of quotations seqs (not inclusive)
	 * @return the range of quotations seqs
	 */
	@Override
	public List<QuotationsSeq> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotations seqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsSeqModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations seqs
	 * @param end the upper bound of the range of quotations seqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotations seqs
	 */
	@Override
	public List<QuotationsSeq> findAll(
		int start, int end,
		OrderByComparator<QuotationsSeq> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotations seqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsSeqModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations seqs
	 * @param end the upper bound of the range of quotations seqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotations seqs
	 */
	@Override
	public List<QuotationsSeq> findAll(
		int start, int end, OrderByComparator<QuotationsSeq> orderByComparator,
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

		List<QuotationsSeq> list = null;

		if (useFinderCache) {
			list = (List<QuotationsSeq>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_QUOTATIONSSEQ);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_QUOTATIONSSEQ;

				sql = sql.concat(QuotationsSeqModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<QuotationsSeq>)QueryUtil.list(
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
	 * Removes all the quotations seqs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QuotationsSeq quotationsSeq : findAll()) {
			remove(quotationsSeq);
		}
	}

	/**
	 * Returns the number of quotations seqs.
	 *
	 * @return the number of quotations seqs
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_QUOTATIONSSEQ);

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
		return "KEY";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_QUOTATIONSSEQ;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QuotationsSeqModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the quotations seq persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new QuotationsSeqModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", QuotationsSeq.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByKey = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByKey",
			new String[] {String.class.getName()}, new String[] {"KEY"}, true);

		_finderPathCountByKey = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKey",
			new String[] {String.class.getName()}, new String[] {"KEY"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(QuotationsSeqImpl.class.getName());

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

	private static final String _SQL_SELECT_QUOTATIONSSEQ =
		"SELECT quotationsSeq FROM QuotationsSeq quotationsSeq";

	private static final String _SQL_SELECT_QUOTATIONSSEQ_WHERE =
		"SELECT quotationsSeq FROM QuotationsSeq quotationsSeq WHERE ";

	private static final String _SQL_COUNT_QUOTATIONSSEQ =
		"SELECT COUNT(quotationsSeq) FROM QuotationsSeq quotationsSeq";

	private static final String _SQL_COUNT_QUOTATIONSSEQ_WHERE =
		"SELECT COUNT(quotationsSeq) FROM QuotationsSeq quotationsSeq WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "quotationsSeq.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No QuotationsSeq exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No QuotationsSeq exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		QuotationsSeqPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"key", "value"});

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

	private static class QuotationsSeqModelArgumentsResolver
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

			QuotationsSeqModelImpl quotationsSeqModelImpl =
				(QuotationsSeqModelImpl)baseModel;

			long columnBitmask = quotationsSeqModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(quotationsSeqModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						quotationsSeqModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(quotationsSeqModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			QuotationsSeqModelImpl quotationsSeqModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						quotationsSeqModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = quotationsSeqModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}