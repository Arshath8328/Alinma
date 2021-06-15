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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationCoversException;
import com.ejada.atmc.acl.db.model.QuotationCovers;
import com.ejada.atmc.acl.db.model.impl.QuotationCoversImpl;
import com.ejada.atmc.acl.db.model.impl.QuotationCoversModelImpl;
import com.ejada.atmc.acl.db.service.persistence.QuotationCoversPK;
import com.ejada.atmc.acl.db.service.persistence.QuotationCoversPersistence;
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
 * The persistence implementation for the quotation covers service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = QuotationCoversPersistence.class)
public class QuotationCoversPersistenceImpl
	extends BasePersistenceImpl<QuotationCovers>
	implements QuotationCoversPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>QuotationCoversUtil</code> to access the quotation covers persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		QuotationCoversImpl.class.getName();

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
	 * Returns all the quotation coverses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation coverses
	 */
	@Override
	public List<QuotationCovers> findByQuotationId(long quotationId) {
		return findByQuotationId(
			quotationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotation coverses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationCoversModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation coverses
	 * @param end the upper bound of the range of quotation coverses (not inclusive)
	 * @return the range of matching quotation coverses
	 */
	@Override
	public List<QuotationCovers> findByQuotationId(
		long quotationId, int start, int end) {

		return findByQuotationId(quotationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotation coverses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationCoversModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation coverses
	 * @param end the upper bound of the range of quotation coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotation coverses
	 */
	@Override
	public List<QuotationCovers> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<QuotationCovers> orderByComparator) {

		return findByQuotationId(
			quotationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotation coverses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationCoversModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation coverses
	 * @param end the upper bound of the range of quotation coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotation coverses
	 */
	@Override
	public List<QuotationCovers> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<QuotationCovers> orderByComparator,
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

		List<QuotationCovers> list = null;

		if (useFinderCache) {
			list = (List<QuotationCovers>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (QuotationCovers quotationCovers : list) {
					if (quotationId != quotationCovers.getQuotationId()) {
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

			sb.append(_SQL_SELECT_QUOTATIONCOVERS_WHERE);

			sb.append(_FINDER_COLUMN_QUOTATIONID_QUOTATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationCoversModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(quotationId);

				list = (List<QuotationCovers>)QueryUtil.list(
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
	 * Returns the first quotation covers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation covers
	 * @throws NoSuchQuotationCoversException if a matching quotation covers could not be found
	 */
	@Override
	public QuotationCovers findByQuotationId_First(
			long quotationId,
			OrderByComparator<QuotationCovers> orderByComparator)
		throws NoSuchQuotationCoversException {

		QuotationCovers quotationCovers = fetchByQuotationId_First(
			quotationId, orderByComparator);

		if (quotationCovers != null) {
			return quotationCovers;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quotationId=");
		sb.append(quotationId);

		sb.append("}");

		throw new NoSuchQuotationCoversException(sb.toString());
	}

	/**
	 * Returns the first quotation covers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation covers, or <code>null</code> if a matching quotation covers could not be found
	 */
	@Override
	public QuotationCovers fetchByQuotationId_First(
		long quotationId,
		OrderByComparator<QuotationCovers> orderByComparator) {

		List<QuotationCovers> list = findByQuotationId(
			quotationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last quotation covers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation covers
	 * @throws NoSuchQuotationCoversException if a matching quotation covers could not be found
	 */
	@Override
	public QuotationCovers findByQuotationId_Last(
			long quotationId,
			OrderByComparator<QuotationCovers> orderByComparator)
		throws NoSuchQuotationCoversException {

		QuotationCovers quotationCovers = fetchByQuotationId_Last(
			quotationId, orderByComparator);

		if (quotationCovers != null) {
			return quotationCovers;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quotationId=");
		sb.append(quotationId);

		sb.append("}");

		throw new NoSuchQuotationCoversException(sb.toString());
	}

	/**
	 * Returns the last quotation covers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation covers, or <code>null</code> if a matching quotation covers could not be found
	 */
	@Override
	public QuotationCovers fetchByQuotationId_Last(
		long quotationId,
		OrderByComparator<QuotationCovers> orderByComparator) {

		int count = countByQuotationId(quotationId);

		if (count == 0) {
			return null;
		}

		List<QuotationCovers> list = findByQuotationId(
			quotationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the quotation coverses before and after the current quotation covers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationCoversPK the primary key of the current quotation covers
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation covers
	 * @throws NoSuchQuotationCoversException if a quotation covers with the primary key could not be found
	 */
	@Override
	public QuotationCovers[] findByQuotationId_PrevAndNext(
			QuotationCoversPK quotationCoversPK, long quotationId,
			OrderByComparator<QuotationCovers> orderByComparator)
		throws NoSuchQuotationCoversException {

		QuotationCovers quotationCovers = findByPrimaryKey(quotationCoversPK);

		Session session = null;

		try {
			session = openSession();

			QuotationCovers[] array = new QuotationCoversImpl[3];

			array[0] = getByQuotationId_PrevAndNext(
				session, quotationCovers, quotationId, orderByComparator, true);

			array[1] = quotationCovers;

			array[2] = getByQuotationId_PrevAndNext(
				session, quotationCovers, quotationId, orderByComparator,
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

	protected QuotationCovers getByQuotationId_PrevAndNext(
		Session session, QuotationCovers quotationCovers, long quotationId,
		OrderByComparator<QuotationCovers> orderByComparator,
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

		sb.append(_SQL_SELECT_QUOTATIONCOVERS_WHERE);

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
			sb.append(QuotationCoversModelImpl.ORDER_BY_JPQL);
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
						quotationCovers)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<QuotationCovers> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the quotation coverses where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	@Override
	public void removeByQuotationId(long quotationId) {
		for (QuotationCovers quotationCovers :
				findByQuotationId(
					quotationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(quotationCovers);
		}
	}

	/**
	 * Returns the number of quotation coverses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation coverses
	 */
	@Override
	public int countByQuotationId(long quotationId) {
		FinderPath finderPath = _finderPathCountByQuotationId;

		Object[] finderArgs = new Object[] {quotationId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUOTATIONCOVERS_WHERE);

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
		"quotationCovers.id.quotationId = ?";

	public QuotationCoversPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("addCoverId", "ADD_COVER_ID");
		dbColumnNames.put("quotationId", "QUOTATIONS_ID");
		dbColumnNames.put("coverCode", "COVER_CODE");
		dbColumnNames.put("sectionCode", "SECTION_CODE");
		dbColumnNames.put("coverEffFromDate", "COVER_EFF_FRM_DATE");
		dbColumnNames.put("coverEffToDate", "COVER_EFF_TO_DATE");
		dbColumnNames.put("coverPrem", "COVER_PREM");
		dbColumnNames.put("coverRate", "COVER_RATE");
		dbColumnNames.put("coverSi", "COVER_SI");

		setDBColumnNames(dbColumnNames);

		setModelClass(QuotationCovers.class);

		setModelImplClass(QuotationCoversImpl.class);
		setModelPKClass(QuotationCoversPK.class);
	}

	/**
	 * Caches the quotation covers in the entity cache if it is enabled.
	 *
	 * @param quotationCovers the quotation covers
	 */
	@Override
	public void cacheResult(QuotationCovers quotationCovers) {
		dummyEntityCache.putResult(
			QuotationCoversImpl.class, quotationCovers.getPrimaryKey(),
			quotationCovers);
	}

	/**
	 * Caches the quotation coverses in the entity cache if it is enabled.
	 *
	 * @param quotationCoverses the quotation coverses
	 */
	@Override
	public void cacheResult(List<QuotationCovers> quotationCoverses) {
		for (QuotationCovers quotationCovers : quotationCoverses) {
			if (dummyEntityCache.getResult(
					QuotationCoversImpl.class,
					quotationCovers.getPrimaryKey()) == null) {

				cacheResult(quotationCovers);
			}
		}
	}

	/**
	 * Clears the cache for all quotation coverses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(QuotationCoversImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the quotation covers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuotationCovers quotationCovers) {
		dummyEntityCache.removeResult(
			QuotationCoversImpl.class, quotationCovers);
	}

	@Override
	public void clearCache(List<QuotationCovers> quotationCoverses) {
		for (QuotationCovers quotationCovers : quotationCoverses) {
			dummyEntityCache.removeResult(
				QuotationCoversImpl.class, quotationCovers);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				QuotationCoversImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new quotation covers with the primary key. Does not add the quotation covers to the database.
	 *
	 * @param quotationCoversPK the primary key for the new quotation covers
	 * @return the new quotation covers
	 */
	@Override
	public QuotationCovers create(QuotationCoversPK quotationCoversPK) {
		QuotationCovers quotationCovers = new QuotationCoversImpl();

		quotationCovers.setNew(true);
		quotationCovers.setPrimaryKey(quotationCoversPK);

		return quotationCovers;
	}

	/**
	 * Removes the quotation covers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quotationCoversPK the primary key of the quotation covers
	 * @return the quotation covers that was removed
	 * @throws NoSuchQuotationCoversException if a quotation covers with the primary key could not be found
	 */
	@Override
	public QuotationCovers remove(QuotationCoversPK quotationCoversPK)
		throws NoSuchQuotationCoversException {

		return remove((Serializable)quotationCoversPK);
	}

	/**
	 * Removes the quotation covers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the quotation covers
	 * @return the quotation covers that was removed
	 * @throws NoSuchQuotationCoversException if a quotation covers with the primary key could not be found
	 */
	@Override
	public QuotationCovers remove(Serializable primaryKey)
		throws NoSuchQuotationCoversException {

		Session session = null;

		try {
			session = openSession();

			QuotationCovers quotationCovers = (QuotationCovers)session.get(
				QuotationCoversImpl.class, primaryKey);

			if (quotationCovers == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuotationCoversException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(quotationCovers);
		}
		catch (NoSuchQuotationCoversException noSuchEntityException) {
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
	protected QuotationCovers removeImpl(QuotationCovers quotationCovers) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(quotationCovers)) {
				quotationCovers = (QuotationCovers)session.get(
					QuotationCoversImpl.class,
					quotationCovers.getPrimaryKeyObj());
			}

			if (quotationCovers != null) {
				session.delete(quotationCovers);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (quotationCovers != null) {
			clearCache(quotationCovers);
		}

		return quotationCovers;
	}

	@Override
	public QuotationCovers updateImpl(QuotationCovers quotationCovers) {
		boolean isNew = quotationCovers.isNew();

		if (!(quotationCovers instanceof QuotationCoversModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(quotationCovers.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					quotationCovers);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in quotationCovers proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom QuotationCovers implementation " +
					quotationCovers.getClass());
		}

		QuotationCoversModelImpl quotationCoversModelImpl =
			(QuotationCoversModelImpl)quotationCovers;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(quotationCovers);
			}
			else {
				quotationCovers = (QuotationCovers)session.merge(
					quotationCovers);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			QuotationCoversImpl.class, quotationCoversModelImpl, false, true);

		if (isNew) {
			quotationCovers.setNew(false);
		}

		quotationCovers.resetOriginalValues();

		return quotationCovers;
	}

	/**
	 * Returns the quotation covers with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the quotation covers
	 * @return the quotation covers
	 * @throws NoSuchQuotationCoversException if a quotation covers with the primary key could not be found
	 */
	@Override
	public QuotationCovers findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuotationCoversException {

		QuotationCovers quotationCovers = fetchByPrimaryKey(primaryKey);

		if (quotationCovers == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuotationCoversException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return quotationCovers;
	}

	/**
	 * Returns the quotation covers with the primary key or throws a <code>NoSuchQuotationCoversException</code> if it could not be found.
	 *
	 * @param quotationCoversPK the primary key of the quotation covers
	 * @return the quotation covers
	 * @throws NoSuchQuotationCoversException if a quotation covers with the primary key could not be found
	 */
	@Override
	public QuotationCovers findByPrimaryKey(QuotationCoversPK quotationCoversPK)
		throws NoSuchQuotationCoversException {

		return findByPrimaryKey((Serializable)quotationCoversPK);
	}

	/**
	 * Returns the quotation covers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quotationCoversPK the primary key of the quotation covers
	 * @return the quotation covers, or <code>null</code> if a quotation covers with the primary key could not be found
	 */
	@Override
	public QuotationCovers fetchByPrimaryKey(
		QuotationCoversPK quotationCoversPK) {

		return fetchByPrimaryKey((Serializable)quotationCoversPK);
	}

	/**
	 * Returns all the quotation coverses.
	 *
	 * @return the quotation coverses
	 */
	@Override
	public List<QuotationCovers> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotation coverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationCoversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation coverses
	 * @param end the upper bound of the range of quotation coverses (not inclusive)
	 * @return the range of quotation coverses
	 */
	@Override
	public List<QuotationCovers> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotation coverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationCoversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation coverses
	 * @param end the upper bound of the range of quotation coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotation coverses
	 */
	@Override
	public List<QuotationCovers> findAll(
		int start, int end,
		OrderByComparator<QuotationCovers> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotation coverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationCoversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation coverses
	 * @param end the upper bound of the range of quotation coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotation coverses
	 */
	@Override
	public List<QuotationCovers> findAll(
		int start, int end,
		OrderByComparator<QuotationCovers> orderByComparator,
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

		List<QuotationCovers> list = null;

		if (useFinderCache) {
			list = (List<QuotationCovers>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_QUOTATIONCOVERS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_QUOTATIONCOVERS;

				sql = sql.concat(QuotationCoversModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<QuotationCovers>)QueryUtil.list(
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
	 * Removes all the quotation coverses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QuotationCovers quotationCovers : findAll()) {
			remove(quotationCovers);
		}
	}

	/**
	 * Returns the number of quotation coverses.
	 *
	 * @return the number of quotation coverses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_QUOTATIONCOVERS);

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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "quotationCoversPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_QUOTATIONCOVERS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QuotationCoversModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the quotation covers persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new QuotationCoversModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", QuotationCovers.class.getName()));

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
			new String[] {"QUOTATIONS_ID"}, true);

		_finderPathWithoutPaginationFindByQuotationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuotationId",
			new String[] {Long.class.getName()}, new String[] {"QUOTATIONS_ID"},
			true);

		_finderPathCountByQuotationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuotationId",
			new String[] {Long.class.getName()}, new String[] {"QUOTATIONS_ID"},
			false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(QuotationCoversImpl.class.getName());

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

	private static final String _SQL_SELECT_QUOTATIONCOVERS =
		"SELECT quotationCovers FROM QuotationCovers quotationCovers";

	private static final String _SQL_SELECT_QUOTATIONCOVERS_WHERE =
		"SELECT quotationCovers FROM QuotationCovers quotationCovers WHERE ";

	private static final String _SQL_COUNT_QUOTATIONCOVERS =
		"SELECT COUNT(quotationCovers) FROM QuotationCovers quotationCovers";

	private static final String _SQL_COUNT_QUOTATIONCOVERS_WHERE =
		"SELECT COUNT(quotationCovers) FROM QuotationCovers quotationCovers WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "quotationCovers.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No QuotationCovers exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No QuotationCovers exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		QuotationCoversPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"addCoverId", "quotationId", "coverCode", "sectionCode",
			"coverEffFromDate", "coverEffToDate", "coverPrem", "coverRate",
			"coverSi"
		});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"addCoverId", "quotationId"});

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

	private static class QuotationCoversModelArgumentsResolver
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

			QuotationCoversModelImpl quotationCoversModelImpl =
				(QuotationCoversModelImpl)baseModel;

			long columnBitmask = quotationCoversModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					quotationCoversModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						quotationCoversModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					quotationCoversModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			QuotationCoversModelImpl quotationCoversModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						quotationCoversModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = quotationCoversModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}