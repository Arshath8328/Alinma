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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationDriversException;
import com.ejada.atmc.acl.db.model.QuotationDrivers;
import com.ejada.atmc.acl.db.model.impl.QuotationDriversImpl;
import com.ejada.atmc.acl.db.model.impl.QuotationDriversModelImpl;
import com.ejada.atmc.acl.db.service.persistence.QuotationDriversPersistence;
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
 * The persistence implementation for the quotation drivers service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = QuotationDriversPersistence.class)
public class QuotationDriversPersistenceImpl
	extends BasePersistenceImpl<QuotationDrivers>
	implements QuotationDriversPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>QuotationDriversUtil</code> to access the quotation drivers persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		QuotationDriversImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByAddDriverIdQuotationId;
	private FinderPath _finderPathCountByAddDriverIdQuotationId;

	/**
	 * Returns the quotation drivers where addDriverId = &#63; and quotationId = &#63; or throws a <code>NoSuchQuotationDriversException</code> if it could not be found.
	 *
	 * @param addDriverId the add driver ID
	 * @param quotationId the quotation ID
	 * @return the matching quotation drivers
	 * @throws NoSuchQuotationDriversException if a matching quotation drivers could not be found
	 */
	@Override
	public QuotationDrivers findByAddDriverIdQuotationId(
			long addDriverId, long quotationId)
		throws NoSuchQuotationDriversException {

		QuotationDrivers quotationDrivers = fetchByAddDriverIdQuotationId(
			addDriverId, quotationId);

		if (quotationDrivers == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("addDriverId=");
			sb.append(addDriverId);

			sb.append(", quotationId=");
			sb.append(quotationId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchQuotationDriversException(sb.toString());
		}

		return quotationDrivers;
	}

	/**
	 * Returns the quotation drivers where addDriverId = &#63; and quotationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param addDriverId the add driver ID
	 * @param quotationId the quotation ID
	 * @return the matching quotation drivers, or <code>null</code> if a matching quotation drivers could not be found
	 */
	@Override
	public QuotationDrivers fetchByAddDriverIdQuotationId(
		long addDriverId, long quotationId) {

		return fetchByAddDriverIdQuotationId(addDriverId, quotationId, true);
	}

	/**
	 * Returns the quotation drivers where addDriverId = &#63; and quotationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param addDriverId the add driver ID
	 * @param quotationId the quotation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotation drivers, or <code>null</code> if a matching quotation drivers could not be found
	 */
	@Override
	public QuotationDrivers fetchByAddDriverIdQuotationId(
		long addDriverId, long quotationId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {addDriverId, quotationId};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByAddDriverIdQuotationId, finderArgs, this);
		}

		if (result instanceof QuotationDrivers) {
			QuotationDrivers quotationDrivers = (QuotationDrivers)result;

			if ((addDriverId != quotationDrivers.getAddDriverId()) ||
				(quotationId != quotationDrivers.getQuotationId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_QUOTATIONDRIVERS_WHERE);

			sb.append(_FINDER_COLUMN_ADDDRIVERIDQUOTATIONID_ADDDRIVERID_2);

			sb.append(_FINDER_COLUMN_ADDDRIVERIDQUOTATIONID_QUOTATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(addDriverId);

				queryPos.add(quotationId);

				List<QuotationDrivers> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByAddDriverIdQuotationId,
							finderArgs, list);
					}
				}
				else {
					QuotationDrivers quotationDrivers = list.get(0);

					result = quotationDrivers;

					cacheResult(quotationDrivers);
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
			return (QuotationDrivers)result;
		}
	}

	/**
	 * Removes the quotation drivers where addDriverId = &#63; and quotationId = &#63; from the database.
	 *
	 * @param addDriverId the add driver ID
	 * @param quotationId the quotation ID
	 * @return the quotation drivers that was removed
	 */
	@Override
	public QuotationDrivers removeByAddDriverIdQuotationId(
			long addDriverId, long quotationId)
		throws NoSuchQuotationDriversException {

		QuotationDrivers quotationDrivers = findByAddDriverIdQuotationId(
			addDriverId, quotationId);

		return remove(quotationDrivers);
	}

	/**
	 * Returns the number of quotation driverses where addDriverId = &#63; and quotationId = &#63;.
	 *
	 * @param addDriverId the add driver ID
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation driverses
	 */
	@Override
	public int countByAddDriverIdQuotationId(
		long addDriverId, long quotationId) {

		FinderPath finderPath = _finderPathCountByAddDriverIdQuotationId;

		Object[] finderArgs = new Object[] {addDriverId, quotationId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_QUOTATIONDRIVERS_WHERE);

			sb.append(_FINDER_COLUMN_ADDDRIVERIDQUOTATIONID_ADDDRIVERID_2);

			sb.append(_FINDER_COLUMN_ADDDRIVERIDQUOTATIONID_QUOTATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(addDriverId);

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

	private static final String
		_FINDER_COLUMN_ADDDRIVERIDQUOTATIONID_ADDDRIVERID_2 =
			"quotationDrivers.addDriverId = ? AND ";

	private static final String
		_FINDER_COLUMN_ADDDRIVERIDQUOTATIONID_QUOTATIONID_2 =
			"quotationDrivers.quotationId = ?";

	private FinderPath _finderPathWithPaginationFindByQuotationId;
	private FinderPath _finderPathWithoutPaginationFindByQuotationId;
	private FinderPath _finderPathCountByQuotationId;

	/**
	 * Returns all the quotation driverses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation driverses
	 */
	@Override
	public List<QuotationDrivers> findByQuotationId(long quotationId) {
		return findByQuotationId(
			quotationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotation driverses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @return the range of matching quotation driverses
	 */
	@Override
	public List<QuotationDrivers> findByQuotationId(
		long quotationId, int start, int end) {

		return findByQuotationId(quotationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotation driverses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotation driverses
	 */
	@Override
	public List<QuotationDrivers> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<QuotationDrivers> orderByComparator) {

		return findByQuotationId(
			quotationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotation driverses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotation driverses
	 */
	@Override
	public List<QuotationDrivers> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<QuotationDrivers> orderByComparator,
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

		List<QuotationDrivers> list = null;

		if (useFinderCache) {
			list = (List<QuotationDrivers>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (QuotationDrivers quotationDrivers : list) {
					if (quotationId != quotationDrivers.getQuotationId()) {
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

			sb.append(_SQL_SELECT_QUOTATIONDRIVERS_WHERE);

			sb.append(_FINDER_COLUMN_QUOTATIONID_QUOTATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationDriversModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(quotationId);

				list = (List<QuotationDrivers>)QueryUtil.list(
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
	 * Returns the first quotation drivers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation drivers
	 * @throws NoSuchQuotationDriversException if a matching quotation drivers could not be found
	 */
	@Override
	public QuotationDrivers findByQuotationId_First(
			long quotationId,
			OrderByComparator<QuotationDrivers> orderByComparator)
		throws NoSuchQuotationDriversException {

		QuotationDrivers quotationDrivers = fetchByQuotationId_First(
			quotationId, orderByComparator);

		if (quotationDrivers != null) {
			return quotationDrivers;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quotationId=");
		sb.append(quotationId);

		sb.append("}");

		throw new NoSuchQuotationDriversException(sb.toString());
	}

	/**
	 * Returns the first quotation drivers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation drivers, or <code>null</code> if a matching quotation drivers could not be found
	 */
	@Override
	public QuotationDrivers fetchByQuotationId_First(
		long quotationId,
		OrderByComparator<QuotationDrivers> orderByComparator) {

		List<QuotationDrivers> list = findByQuotationId(
			quotationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last quotation drivers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation drivers
	 * @throws NoSuchQuotationDriversException if a matching quotation drivers could not be found
	 */
	@Override
	public QuotationDrivers findByQuotationId_Last(
			long quotationId,
			OrderByComparator<QuotationDrivers> orderByComparator)
		throws NoSuchQuotationDriversException {

		QuotationDrivers quotationDrivers = fetchByQuotationId_Last(
			quotationId, orderByComparator);

		if (quotationDrivers != null) {
			return quotationDrivers;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quotationId=");
		sb.append(quotationId);

		sb.append("}");

		throw new NoSuchQuotationDriversException(sb.toString());
	}

	/**
	 * Returns the last quotation drivers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation drivers, or <code>null</code> if a matching quotation drivers could not be found
	 */
	@Override
	public QuotationDrivers fetchByQuotationId_Last(
		long quotationId,
		OrderByComparator<QuotationDrivers> orderByComparator) {

		int count = countByQuotationId(quotationId);

		if (count == 0) {
			return null;
		}

		List<QuotationDrivers> list = findByQuotationId(
			quotationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the quotation driverses before and after the current quotation drivers in the ordered set where quotationId = &#63;.
	 *
	 * @param addDriverId the primary key of the current quotation drivers
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation drivers
	 * @throws NoSuchQuotationDriversException if a quotation drivers with the primary key could not be found
	 */
	@Override
	public QuotationDrivers[] findByQuotationId_PrevAndNext(
			long addDriverId, long quotationId,
			OrderByComparator<QuotationDrivers> orderByComparator)
		throws NoSuchQuotationDriversException {

		QuotationDrivers quotationDrivers = findByPrimaryKey(addDriverId);

		Session session = null;

		try {
			session = openSession();

			QuotationDrivers[] array = new QuotationDriversImpl[3];

			array[0] = getByQuotationId_PrevAndNext(
				session, quotationDrivers, quotationId, orderByComparator,
				true);

			array[1] = quotationDrivers;

			array[2] = getByQuotationId_PrevAndNext(
				session, quotationDrivers, quotationId, orderByComparator,
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

	protected QuotationDrivers getByQuotationId_PrevAndNext(
		Session session, QuotationDrivers quotationDrivers, long quotationId,
		OrderByComparator<QuotationDrivers> orderByComparator,
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

		sb.append(_SQL_SELECT_QUOTATIONDRIVERS_WHERE);

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
			sb.append(QuotationDriversModelImpl.ORDER_BY_JPQL);
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
						quotationDrivers)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<QuotationDrivers> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the quotation driverses where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	@Override
	public void removeByQuotationId(long quotationId) {
		for (QuotationDrivers quotationDrivers :
				findByQuotationId(
					quotationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(quotationDrivers);
		}
	}

	/**
	 * Returns the number of quotation driverses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation driverses
	 */
	@Override
	public int countByQuotationId(long quotationId) {
		FinderPath finderPath = _finderPathCountByQuotationId;

		Object[] finderArgs = new Object[] {quotationId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUOTATIONDRIVERS_WHERE);

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
		"quotationDrivers.quotationId = ?";

	private FinderPath
		_finderPathWithPaginationFindByQuotationIdIsDriverUnder21;
	private FinderPath
		_finderPathWithoutPaginationFindByQuotationIdIsDriverUnder21;
	private FinderPath _finderPathCountByQuotationIdIsDriverUnder21;

	/**
	 * Returns all the quotation driverses where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @return the matching quotation driverses
	 */
	@Override
	public List<QuotationDrivers> findByQuotationIdIsDriverUnder21(
		boolean isDriverUnder21, long quotationId) {

		return findByQuotationIdIsDriverUnder21(
			isDriverUnder21, quotationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the quotation driverses where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @return the range of matching quotation driverses
	 */
	@Override
	public List<QuotationDrivers> findByQuotationIdIsDriverUnder21(
		boolean isDriverUnder21, long quotationId, int start, int end) {

		return findByQuotationIdIsDriverUnder21(
			isDriverUnder21, quotationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotation driverses where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotation driverses
	 */
	@Override
	public List<QuotationDrivers> findByQuotationIdIsDriverUnder21(
		boolean isDriverUnder21, long quotationId, int start, int end,
		OrderByComparator<QuotationDrivers> orderByComparator) {

		return findByQuotationIdIsDriverUnder21(
			isDriverUnder21, quotationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotation driverses where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotation driverses
	 */
	@Override
	public List<QuotationDrivers> findByQuotationIdIsDriverUnder21(
		boolean isDriverUnder21, long quotationId, int start, int end,
		OrderByComparator<QuotationDrivers> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByQuotationIdIsDriverUnder21;
				finderArgs = new Object[] {isDriverUnder21, quotationId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByQuotationIdIsDriverUnder21;
			finderArgs = new Object[] {
				isDriverUnder21, quotationId, start, end, orderByComparator
			};
		}

		List<QuotationDrivers> list = null;

		if (useFinderCache) {
			list = (List<QuotationDrivers>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (QuotationDrivers quotationDrivers : list) {
					if ((isDriverUnder21 !=
							quotationDrivers.isIsDriverUnder21()) ||
						(quotationId != quotationDrivers.getQuotationId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_QUOTATIONDRIVERS_WHERE);

			sb.append(
				_FINDER_COLUMN_QUOTATIONIDISDRIVERUNDER21_ISDRIVERUNDER21_2);

			sb.append(_FINDER_COLUMN_QUOTATIONIDISDRIVERUNDER21_QUOTATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationDriversModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isDriverUnder21);

				queryPos.add(quotationId);

				list = (List<QuotationDrivers>)QueryUtil.list(
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
	 * Returns the first quotation drivers in the ordered set where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation drivers
	 * @throws NoSuchQuotationDriversException if a matching quotation drivers could not be found
	 */
	@Override
	public QuotationDrivers findByQuotationIdIsDriverUnder21_First(
			boolean isDriverUnder21, long quotationId,
			OrderByComparator<QuotationDrivers> orderByComparator)
		throws NoSuchQuotationDriversException {

		QuotationDrivers quotationDrivers =
			fetchByQuotationIdIsDriverUnder21_First(
				isDriverUnder21, quotationId, orderByComparator);

		if (quotationDrivers != null) {
			return quotationDrivers;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isDriverUnder21=");
		sb.append(isDriverUnder21);

		sb.append(", quotationId=");
		sb.append(quotationId);

		sb.append("}");

		throw new NoSuchQuotationDriversException(sb.toString());
	}

	/**
	 * Returns the first quotation drivers in the ordered set where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation drivers, or <code>null</code> if a matching quotation drivers could not be found
	 */
	@Override
	public QuotationDrivers fetchByQuotationIdIsDriverUnder21_First(
		boolean isDriverUnder21, long quotationId,
		OrderByComparator<QuotationDrivers> orderByComparator) {

		List<QuotationDrivers> list = findByQuotationIdIsDriverUnder21(
			isDriverUnder21, quotationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last quotation drivers in the ordered set where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation drivers
	 * @throws NoSuchQuotationDriversException if a matching quotation drivers could not be found
	 */
	@Override
	public QuotationDrivers findByQuotationIdIsDriverUnder21_Last(
			boolean isDriverUnder21, long quotationId,
			OrderByComparator<QuotationDrivers> orderByComparator)
		throws NoSuchQuotationDriversException {

		QuotationDrivers quotationDrivers =
			fetchByQuotationIdIsDriverUnder21_Last(
				isDriverUnder21, quotationId, orderByComparator);

		if (quotationDrivers != null) {
			return quotationDrivers;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isDriverUnder21=");
		sb.append(isDriverUnder21);

		sb.append(", quotationId=");
		sb.append(quotationId);

		sb.append("}");

		throw new NoSuchQuotationDriversException(sb.toString());
	}

	/**
	 * Returns the last quotation drivers in the ordered set where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation drivers, or <code>null</code> if a matching quotation drivers could not be found
	 */
	@Override
	public QuotationDrivers fetchByQuotationIdIsDriverUnder21_Last(
		boolean isDriverUnder21, long quotationId,
		OrderByComparator<QuotationDrivers> orderByComparator) {

		int count = countByQuotationIdIsDriverUnder21(
			isDriverUnder21, quotationId);

		if (count == 0) {
			return null;
		}

		List<QuotationDrivers> list = findByQuotationIdIsDriverUnder21(
			isDriverUnder21, quotationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the quotation driverses before and after the current quotation drivers in the ordered set where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param addDriverId the primary key of the current quotation drivers
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation drivers
	 * @throws NoSuchQuotationDriversException if a quotation drivers with the primary key could not be found
	 */
	@Override
	public QuotationDrivers[] findByQuotationIdIsDriverUnder21_PrevAndNext(
			long addDriverId, boolean isDriverUnder21, long quotationId,
			OrderByComparator<QuotationDrivers> orderByComparator)
		throws NoSuchQuotationDriversException {

		QuotationDrivers quotationDrivers = findByPrimaryKey(addDriverId);

		Session session = null;

		try {
			session = openSession();

			QuotationDrivers[] array = new QuotationDriversImpl[3];

			array[0] = getByQuotationIdIsDriverUnder21_PrevAndNext(
				session, quotationDrivers, isDriverUnder21, quotationId,
				orderByComparator, true);

			array[1] = quotationDrivers;

			array[2] = getByQuotationIdIsDriverUnder21_PrevAndNext(
				session, quotationDrivers, isDriverUnder21, quotationId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected QuotationDrivers getByQuotationIdIsDriverUnder21_PrevAndNext(
		Session session, QuotationDrivers quotationDrivers,
		boolean isDriverUnder21, long quotationId,
		OrderByComparator<QuotationDrivers> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_QUOTATIONDRIVERS_WHERE);

		sb.append(_FINDER_COLUMN_QUOTATIONIDISDRIVERUNDER21_ISDRIVERUNDER21_2);

		sb.append(_FINDER_COLUMN_QUOTATIONIDISDRIVERUNDER21_QUOTATIONID_2);

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
			sb.append(QuotationDriversModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isDriverUnder21);

		queryPos.add(quotationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						quotationDrivers)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<QuotationDrivers> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the quotation driverses where isDriverUnder21 = &#63; and quotationId = &#63; from the database.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 */
	@Override
	public void removeByQuotationIdIsDriverUnder21(
		boolean isDriverUnder21, long quotationId) {

		for (QuotationDrivers quotationDrivers :
				findByQuotationIdIsDriverUnder21(
					isDriverUnder21, quotationId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(quotationDrivers);
		}
	}

	/**
	 * Returns the number of quotation driverses where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation driverses
	 */
	@Override
	public int countByQuotationIdIsDriverUnder21(
		boolean isDriverUnder21, long quotationId) {

		FinderPath finderPath = _finderPathCountByQuotationIdIsDriverUnder21;

		Object[] finderArgs = new Object[] {isDriverUnder21, quotationId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_QUOTATIONDRIVERS_WHERE);

			sb.append(
				_FINDER_COLUMN_QUOTATIONIDISDRIVERUNDER21_ISDRIVERUNDER21_2);

			sb.append(_FINDER_COLUMN_QUOTATIONIDISDRIVERUNDER21_QUOTATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isDriverUnder21);

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

	private static final String
		_FINDER_COLUMN_QUOTATIONIDISDRIVERUNDER21_ISDRIVERUNDER21_2 =
			"quotationDrivers.isDriverUnder21 = ? AND ";

	private static final String
		_FINDER_COLUMN_QUOTATIONIDISDRIVERUNDER21_QUOTATIONID_2 =
			"quotationDrivers.quotationId = ?";

	public QuotationDriversPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("addDriverId", "ADD_DRIVER_ID");
		dbColumnNames.put("quotationId", "QUOTATIONS_ID");
		dbColumnNames.put("driverDob", "DRIVER_DOB");
		dbColumnNames.put("driverDobH", "DRIVER_DOB_H");
		dbColumnNames.put("driverGender", "DRIVER_GENDER");
		dbColumnNames.put("driverId", "DRIVER_ID");
		dbColumnNames.put("driverIdType", "DRIVER_ID_TYPE");
		dbColumnNames.put("driverName", "DRIVER_NAME");
		dbColumnNames.put("driverNationality", "DRIVER_NATIONALITY");
		dbColumnNames.put("driverOccup", "DRIVER_OCCUP");
		dbColumnNames.put("isDriverUnder21", "IS_DRIVER_UNDER_21");
		dbColumnNames.put("driverEdu", "DRIVER_EDU");
		dbColumnNames.put("driverNoChild", "DRIVER_NO_CHILD");
		dbColumnNames.put("driverMaritalStatus", "DRIVER_MARITAL_STATUS");
		dbColumnNames.put("driverNOFault", "DRIVER_NO_FAULT");
		dbColumnNames.put("driverNOClaim", "DRIVER_NO_CLAIM");
		dbColumnNames.put("driverConvictions", "DRIVER_CONVICS");
		dbColumnNames.put("driverMedConds", "DRIVER_MED_CONDS");
		dbColumnNames.put("ncdYears", "DRIVER_NCD_YEARS");
		dbColumnNames.put("insuredRelation", "INSURED_RELATION");
		dbColumnNames.put("insuredRelationProof", "INSURED_RELATION_PROOF");
		dbColumnNames.put(
			"insuredRelationProofFileName", "RELATION_PROOF_FILE_NAME");

		setDBColumnNames(dbColumnNames);

		setModelClass(QuotationDrivers.class);

		setModelImplClass(QuotationDriversImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the quotation drivers in the entity cache if it is enabled.
	 *
	 * @param quotationDrivers the quotation drivers
	 */
	@Override
	public void cacheResult(QuotationDrivers quotationDrivers) {
		dummyEntityCache.putResult(
			QuotationDriversImpl.class, quotationDrivers.getPrimaryKey(),
			quotationDrivers);

		dummyFinderCache.putResult(
			_finderPathFetchByAddDriverIdQuotationId,
			new Object[] {
				quotationDrivers.getAddDriverId(),
				quotationDrivers.getQuotationId()
			},
			quotationDrivers);
	}

	/**
	 * Caches the quotation driverses in the entity cache if it is enabled.
	 *
	 * @param quotationDriverses the quotation driverses
	 */
	@Override
	public void cacheResult(List<QuotationDrivers> quotationDriverses) {
		for (QuotationDrivers quotationDrivers : quotationDriverses) {
			if (dummyEntityCache.getResult(
					QuotationDriversImpl.class,
					quotationDrivers.getPrimaryKey()) == null) {

				cacheResult(quotationDrivers);
			}
		}
	}

	/**
	 * Clears the cache for all quotation driverses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(QuotationDriversImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the quotation drivers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuotationDrivers quotationDrivers) {
		dummyEntityCache.removeResult(
			QuotationDriversImpl.class, quotationDrivers);
	}

	@Override
	public void clearCache(List<QuotationDrivers> quotationDriverses) {
		for (QuotationDrivers quotationDrivers : quotationDriverses) {
			dummyEntityCache.removeResult(
				QuotationDriversImpl.class, quotationDrivers);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				QuotationDriversImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		QuotationDriversModelImpl quotationDriversModelImpl) {

		Object[] args = new Object[] {
			quotationDriversModelImpl.getAddDriverId(),
			quotationDriversModelImpl.getQuotationId()
		};

		dummyFinderCache.putResult(
			_finderPathCountByAddDriverIdQuotationId, args, Long.valueOf(1),
			false);
		dummyFinderCache.putResult(
			_finderPathFetchByAddDriverIdQuotationId, args,
			quotationDriversModelImpl, false);
	}

	/**
	 * Creates a new quotation drivers with the primary key. Does not add the quotation drivers to the database.
	 *
	 * @param addDriverId the primary key for the new quotation drivers
	 * @return the new quotation drivers
	 */
	@Override
	public QuotationDrivers create(long addDriverId) {
		QuotationDrivers quotationDrivers = new QuotationDriversImpl();

		quotationDrivers.setNew(true);
		quotationDrivers.setPrimaryKey(addDriverId);

		return quotationDrivers;
	}

	/**
	 * Removes the quotation drivers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addDriverId the primary key of the quotation drivers
	 * @return the quotation drivers that was removed
	 * @throws NoSuchQuotationDriversException if a quotation drivers with the primary key could not be found
	 */
	@Override
	public QuotationDrivers remove(long addDriverId)
		throws NoSuchQuotationDriversException {

		return remove((Serializable)addDriverId);
	}

	/**
	 * Removes the quotation drivers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the quotation drivers
	 * @return the quotation drivers that was removed
	 * @throws NoSuchQuotationDriversException if a quotation drivers with the primary key could not be found
	 */
	@Override
	public QuotationDrivers remove(Serializable primaryKey)
		throws NoSuchQuotationDriversException {

		Session session = null;

		try {
			session = openSession();

			QuotationDrivers quotationDrivers = (QuotationDrivers)session.get(
				QuotationDriversImpl.class, primaryKey);

			if (quotationDrivers == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuotationDriversException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(quotationDrivers);
		}
		catch (NoSuchQuotationDriversException noSuchEntityException) {
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
	protected QuotationDrivers removeImpl(QuotationDrivers quotationDrivers) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(quotationDrivers)) {
				quotationDrivers = (QuotationDrivers)session.get(
					QuotationDriversImpl.class,
					quotationDrivers.getPrimaryKeyObj());
			}

			if (quotationDrivers != null) {
				session.delete(quotationDrivers);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (quotationDrivers != null) {
			clearCache(quotationDrivers);
		}

		return quotationDrivers;
	}

	@Override
	public QuotationDrivers updateImpl(QuotationDrivers quotationDrivers) {
		boolean isNew = quotationDrivers.isNew();

		if (!(quotationDrivers instanceof QuotationDriversModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(quotationDrivers.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					quotationDrivers);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in quotationDrivers proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom QuotationDrivers implementation " +
					quotationDrivers.getClass());
		}

		QuotationDriversModelImpl quotationDriversModelImpl =
			(QuotationDriversModelImpl)quotationDrivers;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(quotationDrivers);
			}
			else {
				session.evict(
					QuotationDriversImpl.class,
					quotationDrivers.getPrimaryKeyObj());

				session.saveOrUpdate(quotationDrivers);
			}

			session.flush();
			session.clear();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			QuotationDriversImpl.class, quotationDriversModelImpl, false, true);

		cacheUniqueFindersCache(quotationDriversModelImpl);

		if (isNew) {
			quotationDrivers.setNew(false);
		}

		quotationDrivers.resetOriginalValues();

		return quotationDrivers;
	}

	/**
	 * Returns the quotation drivers with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the quotation drivers
	 * @return the quotation drivers
	 * @throws NoSuchQuotationDriversException if a quotation drivers with the primary key could not be found
	 */
	@Override
	public QuotationDrivers findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuotationDriversException {

		QuotationDrivers quotationDrivers = fetchByPrimaryKey(primaryKey);

		if (quotationDrivers == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuotationDriversException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return quotationDrivers;
	}

	/**
	 * Returns the quotation drivers with the primary key or throws a <code>NoSuchQuotationDriversException</code> if it could not be found.
	 *
	 * @param addDriverId the primary key of the quotation drivers
	 * @return the quotation drivers
	 * @throws NoSuchQuotationDriversException if a quotation drivers with the primary key could not be found
	 */
	@Override
	public QuotationDrivers findByPrimaryKey(long addDriverId)
		throws NoSuchQuotationDriversException {

		return findByPrimaryKey((Serializable)addDriverId);
	}

	/**
	 * Returns the quotation drivers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addDriverId the primary key of the quotation drivers
	 * @return the quotation drivers, or <code>null</code> if a quotation drivers with the primary key could not be found
	 */
	@Override
	public QuotationDrivers fetchByPrimaryKey(long addDriverId) {
		return fetchByPrimaryKey((Serializable)addDriverId);
	}

	/**
	 * Returns all the quotation driverses.
	 *
	 * @return the quotation driverses
	 */
	@Override
	public List<QuotationDrivers> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotation driverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @return the range of quotation driverses
	 */
	@Override
	public List<QuotationDrivers> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotation driverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotation driverses
	 */
	@Override
	public List<QuotationDrivers> findAll(
		int start, int end,
		OrderByComparator<QuotationDrivers> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotation driverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotation driverses
	 */
	@Override
	public List<QuotationDrivers> findAll(
		int start, int end,
		OrderByComparator<QuotationDrivers> orderByComparator,
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

		List<QuotationDrivers> list = null;

		if (useFinderCache) {
			list = (List<QuotationDrivers>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_QUOTATIONDRIVERS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_QUOTATIONDRIVERS;

				sql = sql.concat(QuotationDriversModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<QuotationDrivers>)QueryUtil.list(
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
	 * Removes all the quotation driverses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QuotationDrivers quotationDrivers : findAll()) {
			remove(quotationDrivers);
		}
	}

	/**
	 * Returns the number of quotation driverses.
	 *
	 * @return the number of quotation driverses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_QUOTATIONDRIVERS);

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
		return "ADD_DRIVER_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_QUOTATIONDRIVERS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QuotationDriversModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the quotation drivers persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new QuotationDriversModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", QuotationDrivers.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByAddDriverIdQuotationId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByAddDriverIdQuotationId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"ADD_DRIVER_ID", "QUOTATIONS_ID"}, true);

		_finderPathCountByAddDriverIdQuotationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAddDriverIdQuotationId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"ADD_DRIVER_ID", "QUOTATIONS_ID"}, false);

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

		_finderPathWithPaginationFindByQuotationIdIsDriverUnder21 =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByQuotationIdIsDriverUnder21",
				new String[] {
					Boolean.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"IS_DRIVER_UNDER_21", "QUOTATIONS_ID"}, true);

		_finderPathWithoutPaginationFindByQuotationIdIsDriverUnder21 =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByQuotationIdIsDriverUnder21",
				new String[] {Boolean.class.getName(), Long.class.getName()},
				new String[] {"IS_DRIVER_UNDER_21", "QUOTATIONS_ID"}, true);

		_finderPathCountByQuotationIdIsDriverUnder21 = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByQuotationIdIsDriverUnder21",
			new String[] {Boolean.class.getName(), Long.class.getName()},
			new String[] {"IS_DRIVER_UNDER_21", "QUOTATIONS_ID"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(QuotationDriversImpl.class.getName());

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

	private static final String _SQL_SELECT_QUOTATIONDRIVERS =
		"SELECT quotationDrivers FROM QuotationDrivers quotationDrivers";

	private static final String _SQL_SELECT_QUOTATIONDRIVERS_WHERE =
		"SELECT quotationDrivers FROM QuotationDrivers quotationDrivers WHERE ";

	private static final String _SQL_COUNT_QUOTATIONDRIVERS =
		"SELECT COUNT(quotationDrivers) FROM QuotationDrivers quotationDrivers";

	private static final String _SQL_COUNT_QUOTATIONDRIVERS_WHERE =
		"SELECT COUNT(quotationDrivers) FROM QuotationDrivers quotationDrivers WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "quotationDrivers.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No QuotationDrivers exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No QuotationDrivers exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		QuotationDriversPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"addDriverId", "quotationId", "driverDob", "driverDobH",
			"driverGender", "driverId", "driverIdType", "driverName",
			"driverNationality", "driverOccup", "isDriverUnder21", "driverEdu",
			"driverNoChild", "driverMaritalStatus", "driverNOFault",
			"driverNOClaim", "driverConvictions", "driverMedConds", "ncdYears",
			"insuredRelation", "insuredRelationProof",
			"insuredRelationProofFileName"
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

	private static class QuotationDriversModelArgumentsResolver
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

			QuotationDriversModelImpl quotationDriversModelImpl =
				(QuotationDriversModelImpl)baseModel;

			long columnBitmask = quotationDriversModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					quotationDriversModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						quotationDriversModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					quotationDriversModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			QuotationDriversModelImpl quotationDriversModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						quotationDriversModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = quotationDriversModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}