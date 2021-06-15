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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationStatusHistoryException;
import com.ejada.atmc.acl.db.model.QuotationStatusHistory;
import com.ejada.atmc.acl.db.model.impl.QuotationStatusHistoryImpl;
import com.ejada.atmc.acl.db.model.impl.QuotationStatusHistoryModelImpl;
import com.ejada.atmc.acl.db.service.persistence.QuotationStatusHistoryPersistence;
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

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the quotation status history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = QuotationStatusHistoryPersistence.class)
public class QuotationStatusHistoryPersistenceImpl
	extends BasePersistenceImpl<QuotationStatusHistory>
	implements QuotationStatusHistoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>QuotationStatusHistoryUtil</code> to access the quotation status history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		QuotationStatusHistoryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByQuotationId;
	private FinderPath _finderPathWithoutPaginationFindByQuotationId;
	private FinderPath _finderPathCountByQuotationId;

	/**
	 * Returns all the quotation status histories where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation status histories
	 */
	@Override
	public List<QuotationStatusHistory> findByQuotationId(long quotationId) {
		return findByQuotationId(
			quotationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotation status histories where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationStatusHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation status histories
	 * @param end the upper bound of the range of quotation status histories (not inclusive)
	 * @return the range of matching quotation status histories
	 */
	@Override
	public List<QuotationStatusHistory> findByQuotationId(
		long quotationId, int start, int end) {

		return findByQuotationId(quotationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotation status histories where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationStatusHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation status histories
	 * @param end the upper bound of the range of quotation status histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotation status histories
	 */
	@Override
	public List<QuotationStatusHistory> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<QuotationStatusHistory> orderByComparator) {

		return findByQuotationId(
			quotationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotation status histories where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationStatusHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation status histories
	 * @param end the upper bound of the range of quotation status histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotation status histories
	 */
	@Override
	public List<QuotationStatusHistory> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<QuotationStatusHistory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByQuotationId;
				finderArgs = new Object[] {quotationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByQuotationId;
			finderArgs = new Object[] {
				quotationId, start, end, orderByComparator
			};
		}

		List<QuotationStatusHistory> list = null;

		if (useFinderCache) {
			list = (List<QuotationStatusHistory>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (QuotationStatusHistory quotationStatusHistory : list) {
					if (quotationId !=
							quotationStatusHistory.getQuotationId()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_QUOTATIONSTATUSHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_QUOTATIONID_QUOTATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationStatusHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(quotationId);

				list = (List<QuotationStatusHistory>)QueryUtil.list(
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
	 * Returns the first quotation status history in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation status history
	 * @throws NoSuchQuotationStatusHistoryException if a matching quotation status history could not be found
	 */
	@Override
	public QuotationStatusHistory findByQuotationId_First(
			long quotationId,
			OrderByComparator<QuotationStatusHistory> orderByComparator)
		throws NoSuchQuotationStatusHistoryException {

		QuotationStatusHistory quotationStatusHistory =
			fetchByQuotationId_First(quotationId, orderByComparator);

		if (quotationStatusHistory != null) {
			return quotationStatusHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quotationId=");
		sb.append(quotationId);

		sb.append("}");

		throw new NoSuchQuotationStatusHistoryException(sb.toString());
	}

	/**
	 * Returns the first quotation status history in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation status history, or <code>null</code> if a matching quotation status history could not be found
	 */
	@Override
	public QuotationStatusHistory fetchByQuotationId_First(
		long quotationId,
		OrderByComparator<QuotationStatusHistory> orderByComparator) {

		List<QuotationStatusHistory> list = findByQuotationId(
			quotationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last quotation status history in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation status history
	 * @throws NoSuchQuotationStatusHistoryException if a matching quotation status history could not be found
	 */
	@Override
	public QuotationStatusHistory findByQuotationId_Last(
			long quotationId,
			OrderByComparator<QuotationStatusHistory> orderByComparator)
		throws NoSuchQuotationStatusHistoryException {

		QuotationStatusHistory quotationStatusHistory = fetchByQuotationId_Last(
			quotationId, orderByComparator);

		if (quotationStatusHistory != null) {
			return quotationStatusHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quotationId=");
		sb.append(quotationId);

		sb.append("}");

		throw new NoSuchQuotationStatusHistoryException(sb.toString());
	}

	/**
	 * Returns the last quotation status history in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation status history, or <code>null</code> if a matching quotation status history could not be found
	 */
	@Override
	public QuotationStatusHistory fetchByQuotationId_Last(
		long quotationId,
		OrderByComparator<QuotationStatusHistory> orderByComparator) {

		int count = countByQuotationId(quotationId);

		if (count == 0) {
			return null;
		}

		List<QuotationStatusHistory> list = findByQuotationId(
			quotationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the quotation status histories before and after the current quotation status history in the ordered set where quotationId = &#63;.
	 *
	 * @param historyId the primary key of the current quotation status history
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation status history
	 * @throws NoSuchQuotationStatusHistoryException if a quotation status history with the primary key could not be found
	 */
	@Override
	public QuotationStatusHistory[] findByQuotationId_PrevAndNext(
			long historyId, long quotationId,
			OrderByComparator<QuotationStatusHistory> orderByComparator)
		throws NoSuchQuotationStatusHistoryException {

		QuotationStatusHistory quotationStatusHistory = findByPrimaryKey(
			historyId);

		Session session = null;

		try {
			session = openSession();

			QuotationStatusHistory[] array = new QuotationStatusHistoryImpl[3];

			array[0] = getByQuotationId_PrevAndNext(
				session, quotationStatusHistory, quotationId, orderByComparator,
				true);

			array[1] = quotationStatusHistory;

			array[2] = getByQuotationId_PrevAndNext(
				session, quotationStatusHistory, quotationId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected QuotationStatusHistory getByQuotationId_PrevAndNext(
		Session session, QuotationStatusHistory quotationStatusHistory,
		long quotationId,
		OrderByComparator<QuotationStatusHistory> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_QUOTATIONSTATUSHISTORY_WHERE);

		sb.append(_FINDER_COLUMN_QUOTATIONID_QUOTATIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(QuotationStatusHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(quotationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						quotationStatusHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<QuotationStatusHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the quotation status histories where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	@Override
	public void removeByQuotationId(long quotationId) {
		for (QuotationStatusHistory quotationStatusHistory :
				findByQuotationId(
					quotationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(quotationStatusHistory);
		}
	}

	/**
	 * Returns the number of quotation status histories where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation status histories
	 */
	@Override
	public int countByQuotationId(long quotationId) {
		FinderPath finderPath = _finderPathCountByQuotationId;

		Object[] finderArgs = new Object[] {quotationId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUOTATIONSTATUSHISTORY_WHERE);

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
		"quotationStatusHistory.quotationId = ?";

	public QuotationStatusHistoryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("historyId", "HISTORY_ID");
		dbColumnNames.put("quotationId", "QUOTATION_ID");
		dbColumnNames.put("dateTime", "DATE_TIME");
		dbColumnNames.put("userName", "USER_NAME");
		dbColumnNames.put("status", "STATUS");
		dbColumnNames.put("reason", "REASON");

		setDBColumnNames(dbColumnNames);

		setModelClass(QuotationStatusHistory.class);

		setModelImplClass(QuotationStatusHistoryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the quotation status history in the entity cache if it is enabled.
	 *
	 * @param quotationStatusHistory the quotation status history
	 */
	@Override
	public void cacheResult(QuotationStatusHistory quotationStatusHistory) {
		dummyEntityCache.putResult(
			QuotationStatusHistoryImpl.class,
			quotationStatusHistory.getPrimaryKey(), quotationStatusHistory);
	}

	/**
	 * Caches the quotation status histories in the entity cache if it is enabled.
	 *
	 * @param quotationStatusHistories the quotation status histories
	 */
	@Override
	public void cacheResult(
		List<QuotationStatusHistory> quotationStatusHistories) {

		for (QuotationStatusHistory quotationStatusHistory :
				quotationStatusHistories) {

			if (dummyEntityCache.getResult(
					QuotationStatusHistoryImpl.class,
					quotationStatusHistory.getPrimaryKey()) == null) {

				cacheResult(quotationStatusHistory);
			}
		}
	}

	/**
	 * Clears the cache for all quotation status histories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(QuotationStatusHistoryImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the quotation status history.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuotationStatusHistory quotationStatusHistory) {
		dummyEntityCache.removeResult(
			QuotationStatusHistoryImpl.class, quotationStatusHistory);
	}

	@Override
	public void clearCache(
		List<QuotationStatusHistory> quotationStatusHistories) {

		for (QuotationStatusHistory quotationStatusHistory :
				quotationStatusHistories) {

			dummyEntityCache.removeResult(
				QuotationStatusHistoryImpl.class, quotationStatusHistory);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				QuotationStatusHistoryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new quotation status history with the primary key. Does not add the quotation status history to the database.
	 *
	 * @param historyId the primary key for the new quotation status history
	 * @return the new quotation status history
	 */
	@Override
	public QuotationStatusHistory create(long historyId) {
		QuotationStatusHistory quotationStatusHistory =
			new QuotationStatusHistoryImpl();

		quotationStatusHistory.setNew(true);
		quotationStatusHistory.setPrimaryKey(historyId);

		return quotationStatusHistory;
	}

	/**
	 * Removes the quotation status history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param historyId the primary key of the quotation status history
	 * @return the quotation status history that was removed
	 * @throws NoSuchQuotationStatusHistoryException if a quotation status history with the primary key could not be found
	 */
	@Override
	public QuotationStatusHistory remove(long historyId)
		throws NoSuchQuotationStatusHistoryException {

		return remove((Serializable)historyId);
	}

	/**
	 * Removes the quotation status history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the quotation status history
	 * @return the quotation status history that was removed
	 * @throws NoSuchQuotationStatusHistoryException if a quotation status history with the primary key could not be found
	 */
	@Override
	public QuotationStatusHistory remove(Serializable primaryKey)
		throws NoSuchQuotationStatusHistoryException {

		Session session = null;

		try {
			session = openSession();

			QuotationStatusHistory quotationStatusHistory =
				(QuotationStatusHistory)session.get(
					QuotationStatusHistoryImpl.class, primaryKey);

			if (quotationStatusHistory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuotationStatusHistoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(quotationStatusHistory);
		}
		catch (NoSuchQuotationStatusHistoryException noSuchEntityException) {
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
	protected QuotationStatusHistory removeImpl(
		QuotationStatusHistory quotationStatusHistory) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(quotationStatusHistory)) {
				quotationStatusHistory = (QuotationStatusHistory)session.get(
					QuotationStatusHistoryImpl.class,
					quotationStatusHistory.getPrimaryKeyObj());
			}

			if (quotationStatusHistory != null) {
				session.delete(quotationStatusHistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (quotationStatusHistory != null) {
			clearCache(quotationStatusHistory);
		}

		return quotationStatusHistory;
	}

	@Override
	public QuotationStatusHistory updateImpl(
		QuotationStatusHistory quotationStatusHistory) {

		boolean isNew = quotationStatusHistory.isNew();

		if (!(quotationStatusHistory instanceof
				QuotationStatusHistoryModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(quotationStatusHistory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					quotationStatusHistory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in quotationStatusHistory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom QuotationStatusHistory implementation " +
					quotationStatusHistory.getClass());
		}

		QuotationStatusHistoryModelImpl quotationStatusHistoryModelImpl =
			(QuotationStatusHistoryModelImpl)quotationStatusHistory;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(quotationStatusHistory);
			}
			else {
				quotationStatusHistory = (QuotationStatusHistory)session.merge(
					quotationStatusHistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			QuotationStatusHistoryImpl.class, quotationStatusHistoryModelImpl,
			false, true);

		if (isNew) {
			quotationStatusHistory.setNew(false);
		}

		quotationStatusHistory.resetOriginalValues();

		return quotationStatusHistory;
	}

	/**
	 * Returns the quotation status history with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the quotation status history
	 * @return the quotation status history
	 * @throws NoSuchQuotationStatusHistoryException if a quotation status history with the primary key could not be found
	 */
	@Override
	public QuotationStatusHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuotationStatusHistoryException {

		QuotationStatusHistory quotationStatusHistory = fetchByPrimaryKey(
			primaryKey);

		if (quotationStatusHistory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuotationStatusHistoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return quotationStatusHistory;
	}

	/**
	 * Returns the quotation status history with the primary key or throws a <code>NoSuchQuotationStatusHistoryException</code> if it could not be found.
	 *
	 * @param historyId the primary key of the quotation status history
	 * @return the quotation status history
	 * @throws NoSuchQuotationStatusHistoryException if a quotation status history with the primary key could not be found
	 */
	@Override
	public QuotationStatusHistory findByPrimaryKey(long historyId)
		throws NoSuchQuotationStatusHistoryException {

		return findByPrimaryKey((Serializable)historyId);
	}

	/**
	 * Returns the quotation status history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param historyId the primary key of the quotation status history
	 * @return the quotation status history, or <code>null</code> if a quotation status history with the primary key could not be found
	 */
	@Override
	public QuotationStatusHistory fetchByPrimaryKey(long historyId) {
		return fetchByPrimaryKey((Serializable)historyId);
	}

	/**
	 * Returns all the quotation status histories.
	 *
	 * @return the quotation status histories
	 */
	@Override
	public List<QuotationStatusHistory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotation status histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationStatusHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation status histories
	 * @param end the upper bound of the range of quotation status histories (not inclusive)
	 * @return the range of quotation status histories
	 */
	@Override
	public List<QuotationStatusHistory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotation status histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationStatusHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation status histories
	 * @param end the upper bound of the range of quotation status histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotation status histories
	 */
	@Override
	public List<QuotationStatusHistory> findAll(
		int start, int end,
		OrderByComparator<QuotationStatusHistory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotation status histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationStatusHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation status histories
	 * @param end the upper bound of the range of quotation status histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotation status histories
	 */
	@Override
	public List<QuotationStatusHistory> findAll(
		int start, int end,
		OrderByComparator<QuotationStatusHistory> orderByComparator,
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

		List<QuotationStatusHistory> list = null;

		if (useFinderCache) {
			list = (List<QuotationStatusHistory>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_QUOTATIONSTATUSHISTORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_QUOTATIONSTATUSHISTORY;

				sql = sql.concat(QuotationStatusHistoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<QuotationStatusHistory>)QueryUtil.list(
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
	 * Removes all the quotation status histories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QuotationStatusHistory quotationStatusHistory : findAll()) {
			remove(quotationStatusHistory);
		}
	}

	/**
	 * Returns the number of quotation status histories.
	 *
	 * @return the number of quotation status histories
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
					_SQL_COUNT_QUOTATIONSTATUSHISTORY);

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
		return "HISTORY_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_QUOTATIONSTATUSHISTORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QuotationStatusHistoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the quotation status history persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new QuotationStatusHistoryModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", QuotationStatusHistory.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByQuotationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQuotationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"QUOTATION_ID"}, true);

		_finderPathWithoutPaginationFindByQuotationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuotationId",
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
			QuotationStatusHistoryImpl.class.getName());

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

	private static final String _SQL_SELECT_QUOTATIONSTATUSHISTORY =
		"SELECT quotationStatusHistory FROM QuotationStatusHistory quotationStatusHistory";

	private static final String _SQL_SELECT_QUOTATIONSTATUSHISTORY_WHERE =
		"SELECT quotationStatusHistory FROM QuotationStatusHistory quotationStatusHistory WHERE ";

	private static final String _SQL_COUNT_QUOTATIONSTATUSHISTORY =
		"SELECT COUNT(quotationStatusHistory) FROM QuotationStatusHistory quotationStatusHistory";

	private static final String _SQL_COUNT_QUOTATIONSTATUSHISTORY_WHERE =
		"SELECT COUNT(quotationStatusHistory) FROM QuotationStatusHistory quotationStatusHistory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"quotationStatusHistory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No QuotationStatusHistory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No QuotationStatusHistory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		QuotationStatusHistoryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"historyId", "quotationId", "dateTime", "userName", "status",
			"reason"
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

	private static class QuotationStatusHistoryModelArgumentsResolver
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

			QuotationStatusHistoryModelImpl quotationStatusHistoryModelImpl =
				(QuotationStatusHistoryModelImpl)baseModel;

			long columnBitmask =
				quotationStatusHistoryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					quotationStatusHistoryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						quotationStatusHistoryModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					quotationStatusHistoryModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			QuotationStatusHistoryModelImpl quotationStatusHistoryModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						quotationStatusHistoryModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						quotationStatusHistoryModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}