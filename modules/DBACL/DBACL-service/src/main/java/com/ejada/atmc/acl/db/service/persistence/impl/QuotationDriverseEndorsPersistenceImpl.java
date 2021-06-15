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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationDriverseEndorsException;
import com.ejada.atmc.acl.db.model.QuotationDriverseEndors;
import com.ejada.atmc.acl.db.model.impl.QuotationDriverseEndorsImpl;
import com.ejada.atmc.acl.db.model.impl.QuotationDriverseEndorsModelImpl;
import com.ejada.atmc.acl.db.service.persistence.QuotationDriverseEndorsPersistence;
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
 * The persistence implementation for the quotation driverse endors service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = QuotationDriverseEndorsPersistence.class)
public class QuotationDriverseEndorsPersistenceImpl
	extends BasePersistenceImpl<QuotationDriverseEndors>
	implements QuotationDriverseEndorsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>QuotationDriverseEndorsUtil</code> to access the quotation driverse endors persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		QuotationDriverseEndorsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the quotation driverse endorses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching quotation driverse endorses
	 */
	@Override
	public List<QuotationDriverseEndors> findByStatus(String status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotation driverse endorses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriverseEndorsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of quotation driverse endorses
	 * @param end the upper bound of the range of quotation driverse endorses (not inclusive)
	 * @return the range of matching quotation driverse endorses
	 */
	@Override
	public List<QuotationDriverseEndors> findByStatus(
		String status, int start, int end) {

		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotation driverse endorses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriverseEndorsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of quotation driverse endorses
	 * @param end the upper bound of the range of quotation driverse endorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotation driverse endorses
	 */
	@Override
	public List<QuotationDriverseEndors> findByStatus(
		String status, int start, int end,
		OrderByComparator<QuotationDriverseEndors> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotation driverse endorses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriverseEndorsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of quotation driverse endorses
	 * @param end the upper bound of the range of quotation driverse endorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotation driverse endorses
	 */
	@Override
	public List<QuotationDriverseEndors> findByStatus(
		String status, int start, int end,
		OrderByComparator<QuotationDriverseEndors> orderByComparator,
		boolean useFinderCache) {

		status = Objects.toString(status, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<QuotationDriverseEndors> list = null;

		if (useFinderCache) {
			list = (List<QuotationDriverseEndors>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (QuotationDriverseEndors quotationDriverseEndors : list) {
					if (!status.equals(quotationDriverseEndors.getStatus())) {
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

			sb.append(_SQL_SELECT_QUOTATIONDRIVERSEENDORS_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationDriverseEndorsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatus) {
					queryPos.add(status);
				}

				list = (List<QuotationDriverseEndors>)QueryUtil.list(
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
	 * Returns the first quotation driverse endors in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a matching quotation driverse endors could not be found
	 */
	@Override
	public QuotationDriverseEndors findByStatus_First(
			String status,
			OrderByComparator<QuotationDriverseEndors> orderByComparator)
		throws NoSuchQuotationDriverseEndorsException {

		QuotationDriverseEndors quotationDriverseEndors = fetchByStatus_First(
			status, orderByComparator);

		if (quotationDriverseEndors != null) {
			return quotationDriverseEndors;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchQuotationDriverseEndorsException(sb.toString());
	}

	/**
	 * Returns the first quotation driverse endors in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	@Override
	public QuotationDriverseEndors fetchByStatus_First(
		String status,
		OrderByComparator<QuotationDriverseEndors> orderByComparator) {

		List<QuotationDriverseEndors> list = findByStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last quotation driverse endors in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a matching quotation driverse endors could not be found
	 */
	@Override
	public QuotationDriverseEndors findByStatus_Last(
			String status,
			OrderByComparator<QuotationDriverseEndors> orderByComparator)
		throws NoSuchQuotationDriverseEndorsException {

		QuotationDriverseEndors quotationDriverseEndors = fetchByStatus_Last(
			status, orderByComparator);

		if (quotationDriverseEndors != null) {
			return quotationDriverseEndors;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchQuotationDriverseEndorsException(sb.toString());
	}

	/**
	 * Returns the last quotation driverse endors in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	@Override
	public QuotationDriverseEndors fetchByStatus_Last(
		String status,
		OrderByComparator<QuotationDriverseEndors> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<QuotationDriverseEndors> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the quotation driverse endorses before and after the current quotation driverse endors in the ordered set where status = &#63;.
	 *
	 * @param addDriverId the primary key of the current quotation driverse endors
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a quotation driverse endors with the primary key could not be found
	 */
	@Override
	public QuotationDriverseEndors[] findByStatus_PrevAndNext(
			long addDriverId, String status,
			OrderByComparator<QuotationDriverseEndors> orderByComparator)
		throws NoSuchQuotationDriverseEndorsException {

		status = Objects.toString(status, "");

		QuotationDriverseEndors quotationDriverseEndors = findByPrimaryKey(
			addDriverId);

		Session session = null;

		try {
			session = openSession();

			QuotationDriverseEndors[] array =
				new QuotationDriverseEndorsImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, quotationDriverseEndors, status, orderByComparator,
				true);

			array[1] = quotationDriverseEndors;

			array[2] = getByStatus_PrevAndNext(
				session, quotationDriverseEndors, status, orderByComparator,
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

	protected QuotationDriverseEndors getByStatus_PrevAndNext(
		Session session, QuotationDriverseEndors quotationDriverseEndors,
		String status,
		OrderByComparator<QuotationDriverseEndors> orderByComparator,
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

		sb.append(_SQL_SELECT_QUOTATIONDRIVERSEENDORS_WHERE);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			sb.append(_FINDER_COLUMN_STATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);
		}

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
			sb.append(QuotationDriverseEndorsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindStatus) {
			queryPos.add(status);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						quotationDriverseEndors)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<QuotationDriverseEndors> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the quotation driverse endorses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(String status) {
		for (QuotationDriverseEndors quotationDriverseEndors :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(quotationDriverseEndors);
		}
	}

	/**
	 * Returns the number of quotation driverse endorses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching quotation driverse endorses
	 */
	@Override
	public int countByStatus(String status) {
		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUOTATIONDRIVERSEENDORS_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatus) {
					queryPos.add(status);
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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"quotationDriverseEndors.status = ?";

	private static final String _FINDER_COLUMN_STATUS_STATUS_3 =
		"(quotationDriverseEndors.status IS NULL OR quotationDriverseEndors.status = '')";

	private FinderPath _finderPathFetchByeachStatus;
	private FinderPath _finderPathCountByeachStatus;

	/**
	 * Returns the quotation driverse endors where status = &#63; or throws a <code>NoSuchQuotationDriverseEndorsException</code> if it could not be found.
	 *
	 * @param status the status
	 * @return the matching quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a matching quotation driverse endors could not be found
	 */
	@Override
	public QuotationDriverseEndors findByeachStatus(String status)
		throws NoSuchQuotationDriverseEndorsException {

		QuotationDriverseEndors quotationDriverseEndors = fetchByeachStatus(
			status);

		if (quotationDriverseEndors == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("status=");
			sb.append(status);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchQuotationDriverseEndorsException(sb.toString());
		}

		return quotationDriverseEndors;
	}

	/**
	 * Returns the quotation driverse endors where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param status the status
	 * @return the matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	@Override
	public QuotationDriverseEndors fetchByeachStatus(String status) {
		return fetchByeachStatus(status, true);
	}

	/**
	 * Returns the quotation driverse endors where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	@Override
	public QuotationDriverseEndors fetchByeachStatus(
		String status, boolean useFinderCache) {

		status = Objects.toString(status, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {status};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByeachStatus, finderArgs, this);
		}

		if (result instanceof QuotationDriverseEndors) {
			QuotationDriverseEndors quotationDriverseEndors =
				(QuotationDriverseEndors)result;

			if (!Objects.equals(status, quotationDriverseEndors.getStatus())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_QUOTATIONDRIVERSEENDORS_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_EACHSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_EACHSTATUS_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatus) {
					queryPos.add(status);
				}

				List<QuotationDriverseEndors> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByeachStatus, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {status};
							}

							_log.warn(
								"QuotationDriverseEndorsPersistenceImpl.fetchByeachStatus(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					QuotationDriverseEndors quotationDriverseEndors = list.get(
						0);

					result = quotationDriverseEndors;

					cacheResult(quotationDriverseEndors);
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
			return (QuotationDriverseEndors)result;
		}
	}

	/**
	 * Removes the quotation driverse endors where status = &#63; from the database.
	 *
	 * @param status the status
	 * @return the quotation driverse endors that was removed
	 */
	@Override
	public QuotationDriverseEndors removeByeachStatus(String status)
		throws NoSuchQuotationDriverseEndorsException {

		QuotationDriverseEndors quotationDriverseEndors = findByeachStatus(
			status);

		return remove(quotationDriverseEndors);
	}

	/**
	 * Returns the number of quotation driverse endorses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching quotation driverse endorses
	 */
	@Override
	public int countByeachStatus(String status) {
		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountByeachStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUOTATIONDRIVERSEENDORS_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_EACHSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_EACHSTATUS_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatus) {
					queryPos.add(status);
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

	private static final String _FINDER_COLUMN_EACHSTATUS_STATUS_2 =
		"quotationDriverseEndors.status = ?";

	private static final String _FINDER_COLUMN_EACHSTATUS_STATUS_3 =
		"(quotationDriverseEndors.status IS NULL OR quotationDriverseEndors.status = '')";

	private FinderPath _finderPathFetchByDriverId;
	private FinderPath _finderPathCountByDriverId;

	/**
	 * Returns the quotation driverse endors where driverId = &#63; or throws a <code>NoSuchQuotationDriverseEndorsException</code> if it could not be found.
	 *
	 * @param driverId the driver ID
	 * @return the matching quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a matching quotation driverse endors could not be found
	 */
	@Override
	public QuotationDriverseEndors findByDriverId(String driverId)
		throws NoSuchQuotationDriverseEndorsException {

		QuotationDriverseEndors quotationDriverseEndors = fetchByDriverId(
			driverId);

		if (quotationDriverseEndors == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("driverId=");
			sb.append(driverId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchQuotationDriverseEndorsException(sb.toString());
		}

		return quotationDriverseEndors;
	}

	/**
	 * Returns the quotation driverse endors where driverId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param driverId the driver ID
	 * @return the matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	@Override
	public QuotationDriverseEndors fetchByDriverId(String driverId) {
		return fetchByDriverId(driverId, true);
	}

	/**
	 * Returns the quotation driverse endors where driverId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param driverId the driver ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	@Override
	public QuotationDriverseEndors fetchByDriverId(
		String driverId, boolean useFinderCache) {

		driverId = Objects.toString(driverId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {driverId};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByDriverId, finderArgs, this);
		}

		if (result instanceof QuotationDriverseEndors) {
			QuotationDriverseEndors quotationDriverseEndors =
				(QuotationDriverseEndors)result;

			if (!Objects.equals(
					driverId, quotationDriverseEndors.getDriverId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_QUOTATIONDRIVERSEENDORS_WHERE);

			boolean bindDriverId = false;

			if (driverId.isEmpty()) {
				sb.append(_FINDER_COLUMN_DRIVERID_DRIVERID_3);
			}
			else {
				bindDriverId = true;

				sb.append(_FINDER_COLUMN_DRIVERID_DRIVERID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDriverId) {
					queryPos.add(driverId);
				}

				List<QuotationDriverseEndors> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByDriverId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {driverId};
							}

							_log.warn(
								"QuotationDriverseEndorsPersistenceImpl.fetchByDriverId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					QuotationDriverseEndors quotationDriverseEndors = list.get(
						0);

					result = quotationDriverseEndors;

					cacheResult(quotationDriverseEndors);
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
			return (QuotationDriverseEndors)result;
		}
	}

	/**
	 * Removes the quotation driverse endors where driverId = &#63; from the database.
	 *
	 * @param driverId the driver ID
	 * @return the quotation driverse endors that was removed
	 */
	@Override
	public QuotationDriverseEndors removeByDriverId(String driverId)
		throws NoSuchQuotationDriverseEndorsException {

		QuotationDriverseEndors quotationDriverseEndors = findByDriverId(
			driverId);

		return remove(quotationDriverseEndors);
	}

	/**
	 * Returns the number of quotation driverse endorses where driverId = &#63;.
	 *
	 * @param driverId the driver ID
	 * @return the number of matching quotation driverse endorses
	 */
	@Override
	public int countByDriverId(String driverId) {
		driverId = Objects.toString(driverId, "");

		FinderPath finderPath = _finderPathCountByDriverId;

		Object[] finderArgs = new Object[] {driverId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUOTATIONDRIVERSEENDORS_WHERE);

			boolean bindDriverId = false;

			if (driverId.isEmpty()) {
				sb.append(_FINDER_COLUMN_DRIVERID_DRIVERID_3);
			}
			else {
				bindDriverId = true;

				sb.append(_FINDER_COLUMN_DRIVERID_DRIVERID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDriverId) {
					queryPos.add(driverId);
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

	private static final String _FINDER_COLUMN_DRIVERID_DRIVERID_2 =
		"quotationDriverseEndors.driverId = ?";

	private static final String _FINDER_COLUMN_DRIVERID_DRIVERID_3 =
		"(quotationDriverseEndors.driverId IS NULL OR quotationDriverseEndors.driverId = '')";

	private FinderPath _finderPathFetchBypolicyNumber;
	private FinderPath _finderPathCountBypolicyNumber;

	/**
	 * Returns the quotation driverse endors where policyNumber = &#63; or throws a <code>NoSuchQuotationDriverseEndorsException</code> if it could not be found.
	 *
	 * @param policyNumber the policy number
	 * @return the matching quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a matching quotation driverse endors could not be found
	 */
	@Override
	public QuotationDriverseEndors findBypolicyNumber(String policyNumber)
		throws NoSuchQuotationDriverseEndorsException {

		QuotationDriverseEndors quotationDriverseEndors = fetchBypolicyNumber(
			policyNumber);

		if (quotationDriverseEndors == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("policyNumber=");
			sb.append(policyNumber);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchQuotationDriverseEndorsException(sb.toString());
		}

		return quotationDriverseEndors;
	}

	/**
	 * Returns the quotation driverse endors where policyNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyNumber the policy number
	 * @return the matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	@Override
	public QuotationDriverseEndors fetchBypolicyNumber(String policyNumber) {
		return fetchBypolicyNumber(policyNumber, true);
	}

	/**
	 * Returns the quotation driverse endors where policyNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyNumber the policy number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	@Override
	public QuotationDriverseEndors fetchBypolicyNumber(
		String policyNumber, boolean useFinderCache) {

		policyNumber = Objects.toString(policyNumber, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {policyNumber};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchBypolicyNumber, finderArgs, this);
		}

		if (result instanceof QuotationDriverseEndors) {
			QuotationDriverseEndors quotationDriverseEndors =
				(QuotationDriverseEndors)result;

			if (!Objects.equals(
					policyNumber, quotationDriverseEndors.getPolicyNumber())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_QUOTATIONDRIVERSEENDORS_WHERE);

			boolean bindPolicyNumber = false;

			if (policyNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYNUMBER_POLICYNUMBER_3);
			}
			else {
				bindPolicyNumber = true;

				sb.append(_FINDER_COLUMN_POLICYNUMBER_POLICYNUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPolicyNumber) {
					queryPos.add(policyNumber);
				}

				List<QuotationDriverseEndors> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchBypolicyNumber, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {policyNumber};
							}

							_log.warn(
								"QuotationDriverseEndorsPersistenceImpl.fetchBypolicyNumber(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					QuotationDriverseEndors quotationDriverseEndors = list.get(
						0);

					result = quotationDriverseEndors;

					cacheResult(quotationDriverseEndors);
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
			return (QuotationDriverseEndors)result;
		}
	}

	/**
	 * Removes the quotation driverse endors where policyNumber = &#63; from the database.
	 *
	 * @param policyNumber the policy number
	 * @return the quotation driverse endors that was removed
	 */
	@Override
	public QuotationDriverseEndors removeBypolicyNumber(String policyNumber)
		throws NoSuchQuotationDriverseEndorsException {

		QuotationDriverseEndors quotationDriverseEndors = findBypolicyNumber(
			policyNumber);

		return remove(quotationDriverseEndors);
	}

	/**
	 * Returns the number of quotation driverse endorses where policyNumber = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @return the number of matching quotation driverse endorses
	 */
	@Override
	public int countBypolicyNumber(String policyNumber) {
		policyNumber = Objects.toString(policyNumber, "");

		FinderPath finderPath = _finderPathCountBypolicyNumber;

		Object[] finderArgs = new Object[] {policyNumber};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUOTATIONDRIVERSEENDORS_WHERE);

			boolean bindPolicyNumber = false;

			if (policyNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYNUMBER_POLICYNUMBER_3);
			}
			else {
				bindPolicyNumber = true;

				sb.append(_FINDER_COLUMN_POLICYNUMBER_POLICYNUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPolicyNumber) {
					queryPos.add(policyNumber);
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

	private static final String _FINDER_COLUMN_POLICYNUMBER_POLICYNUMBER_2 =
		"quotationDriverseEndors.policyNumber = ?";

	private static final String _FINDER_COLUMN_POLICYNUMBER_POLICYNUMBER_3 =
		"(quotationDriverseEndors.policyNumber IS NULL OR quotationDriverseEndors.policyNumber = '')";

	public QuotationDriverseEndorsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("addDriverId", "ADD_DRIVER_ID");
		dbColumnNames.put("quotationId", "QUOTATIONS_ID");
		dbColumnNames.put("policyNumber", "POLICY_NUMBER");
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
		dbColumnNames.put("status", "STATUS");
		dbColumnNames.put("requestedDate", "REQUESTED_DATE");
		dbColumnNames.put("buildNo", "BUILD_NO");
		dbColumnNames.put("zipCode", "ZIP_CODE");
		dbColumnNames.put("addNo", "ADD_NO");
		dbColumnNames.put("stNameEn", "ST_NAME_EN");
		dbColumnNames.put("stNameAr", "ST_NAME_AR");
		dbColumnNames.put("districtEn", "DISTRICT_EN");
		dbColumnNames.put("districtAr", "DISTRICT_AR");
		dbColumnNames.put("cityEn", "CITY_EN");
		dbColumnNames.put("cityAr", "CITY_AR");
		dbColumnNames.put("isNatAddress", "IS_NAT_ADDRESS");

		setDBColumnNames(dbColumnNames);

		setModelClass(QuotationDriverseEndors.class);

		setModelImplClass(QuotationDriverseEndorsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the quotation driverse endors in the entity cache if it is enabled.
	 *
	 * @param quotationDriverseEndors the quotation driverse endors
	 */
	@Override
	public void cacheResult(QuotationDriverseEndors quotationDriverseEndors) {
		dummyEntityCache.putResult(
			QuotationDriverseEndorsImpl.class,
			quotationDriverseEndors.getPrimaryKey(), quotationDriverseEndors);

		dummyFinderCache.putResult(
			_finderPathFetchByeachStatus,
			new Object[] {quotationDriverseEndors.getStatus()},
			quotationDriverseEndors);

		dummyFinderCache.putResult(
			_finderPathFetchByDriverId,
			new Object[] {quotationDriverseEndors.getDriverId()},
			quotationDriverseEndors);

		dummyFinderCache.putResult(
			_finderPathFetchBypolicyNumber,
			new Object[] {quotationDriverseEndors.getPolicyNumber()},
			quotationDriverseEndors);
	}

	/**
	 * Caches the quotation driverse endorses in the entity cache if it is enabled.
	 *
	 * @param quotationDriverseEndorses the quotation driverse endorses
	 */
	@Override
	public void cacheResult(
		List<QuotationDriverseEndors> quotationDriverseEndorses) {

		for (QuotationDriverseEndors quotationDriverseEndors :
				quotationDriverseEndorses) {

			if (dummyEntityCache.getResult(
					QuotationDriverseEndorsImpl.class,
					quotationDriverseEndors.getPrimaryKey()) == null) {

				cacheResult(quotationDriverseEndors);
			}
		}
	}

	/**
	 * Clears the cache for all quotation driverse endorses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(QuotationDriverseEndorsImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the quotation driverse endors.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuotationDriverseEndors quotationDriverseEndors) {
		dummyEntityCache.removeResult(
			QuotationDriverseEndorsImpl.class, quotationDriverseEndors);
	}

	@Override
	public void clearCache(
		List<QuotationDriverseEndors> quotationDriverseEndorses) {

		for (QuotationDriverseEndors quotationDriverseEndors :
				quotationDriverseEndorses) {

			dummyEntityCache.removeResult(
				QuotationDriverseEndorsImpl.class, quotationDriverseEndors);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				QuotationDriverseEndorsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		QuotationDriverseEndorsModelImpl quotationDriverseEndorsModelImpl) {

		Object[] args = new Object[] {
			quotationDriverseEndorsModelImpl.getStatus()
		};

		dummyFinderCache.putResult(
			_finderPathCountByeachStatus, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchByeachStatus, args,
			quotationDriverseEndorsModelImpl, false);

		args = new Object[] {quotationDriverseEndorsModelImpl.getDriverId()};

		dummyFinderCache.putResult(
			_finderPathCountByDriverId, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchByDriverId, args, quotationDriverseEndorsModelImpl,
			false);

		args = new Object[] {
			quotationDriverseEndorsModelImpl.getPolicyNumber()
		};

		dummyFinderCache.putResult(
			_finderPathCountBypolicyNumber, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchBypolicyNumber, args,
			quotationDriverseEndorsModelImpl, false);
	}

	/**
	 * Creates a new quotation driverse endors with the primary key. Does not add the quotation driverse endors to the database.
	 *
	 * @param addDriverId the primary key for the new quotation driverse endors
	 * @return the new quotation driverse endors
	 */
	@Override
	public QuotationDriverseEndors create(long addDriverId) {
		QuotationDriverseEndors quotationDriverseEndors =
			new QuotationDriverseEndorsImpl();

		quotationDriverseEndors.setNew(true);
		quotationDriverseEndors.setPrimaryKey(addDriverId);

		return quotationDriverseEndors;
	}

	/**
	 * Removes the quotation driverse endors with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addDriverId the primary key of the quotation driverse endors
	 * @return the quotation driverse endors that was removed
	 * @throws NoSuchQuotationDriverseEndorsException if a quotation driverse endors with the primary key could not be found
	 */
	@Override
	public QuotationDriverseEndors remove(long addDriverId)
		throws NoSuchQuotationDriverseEndorsException {

		return remove((Serializable)addDriverId);
	}

	/**
	 * Removes the quotation driverse endors with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the quotation driverse endors
	 * @return the quotation driverse endors that was removed
	 * @throws NoSuchQuotationDriverseEndorsException if a quotation driverse endors with the primary key could not be found
	 */
	@Override
	public QuotationDriverseEndors remove(Serializable primaryKey)
		throws NoSuchQuotationDriverseEndorsException {

		Session session = null;

		try {
			session = openSession();

			QuotationDriverseEndors quotationDriverseEndors =
				(QuotationDriverseEndors)session.get(
					QuotationDriverseEndorsImpl.class, primaryKey);

			if (quotationDriverseEndors == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuotationDriverseEndorsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(quotationDriverseEndors);
		}
		catch (NoSuchQuotationDriverseEndorsException noSuchEntityException) {
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
	protected QuotationDriverseEndors removeImpl(
		QuotationDriverseEndors quotationDriverseEndors) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(quotationDriverseEndors)) {
				quotationDriverseEndors = (QuotationDriverseEndors)session.get(
					QuotationDriverseEndorsImpl.class,
					quotationDriverseEndors.getPrimaryKeyObj());
			}

			if (quotationDriverseEndors != null) {
				session.delete(quotationDriverseEndors);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (quotationDriverseEndors != null) {
			clearCache(quotationDriverseEndors);
		}

		return quotationDriverseEndors;
	}

	@Override
	public QuotationDriverseEndors updateImpl(
		QuotationDriverseEndors quotationDriverseEndors) {

		boolean isNew = quotationDriverseEndors.isNew();

		if (!(quotationDriverseEndors instanceof
				QuotationDriverseEndorsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(quotationDriverseEndors.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					quotationDriverseEndors);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in quotationDriverseEndors proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom QuotationDriverseEndors implementation " +
					quotationDriverseEndors.getClass());
		}

		QuotationDriverseEndorsModelImpl quotationDriverseEndorsModelImpl =
			(QuotationDriverseEndorsModelImpl)quotationDriverseEndors;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(quotationDriverseEndors);
			}
			else {
				session.evict(
					QuotationDriverseEndorsImpl.class,
					quotationDriverseEndors.getPrimaryKeyObj());

				session.saveOrUpdate(quotationDriverseEndors);
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
			QuotationDriverseEndorsImpl.class, quotationDriverseEndorsModelImpl,
			false, true);

		cacheUniqueFindersCache(quotationDriverseEndorsModelImpl);

		if (isNew) {
			quotationDriverseEndors.setNew(false);
		}

		quotationDriverseEndors.resetOriginalValues();

		return quotationDriverseEndors;
	}

	/**
	 * Returns the quotation driverse endors with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the quotation driverse endors
	 * @return the quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a quotation driverse endors with the primary key could not be found
	 */
	@Override
	public QuotationDriverseEndors findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuotationDriverseEndorsException {

		QuotationDriverseEndors quotationDriverseEndors = fetchByPrimaryKey(
			primaryKey);

		if (quotationDriverseEndors == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuotationDriverseEndorsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return quotationDriverseEndors;
	}

	/**
	 * Returns the quotation driverse endors with the primary key or throws a <code>NoSuchQuotationDriverseEndorsException</code> if it could not be found.
	 *
	 * @param addDriverId the primary key of the quotation driverse endors
	 * @return the quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a quotation driverse endors with the primary key could not be found
	 */
	@Override
	public QuotationDriverseEndors findByPrimaryKey(long addDriverId)
		throws NoSuchQuotationDriverseEndorsException {

		return findByPrimaryKey((Serializable)addDriverId);
	}

	/**
	 * Returns the quotation driverse endors with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addDriverId the primary key of the quotation driverse endors
	 * @return the quotation driverse endors, or <code>null</code> if a quotation driverse endors with the primary key could not be found
	 */
	@Override
	public QuotationDriverseEndors fetchByPrimaryKey(long addDriverId) {
		return fetchByPrimaryKey((Serializable)addDriverId);
	}

	/**
	 * Returns all the quotation driverse endorses.
	 *
	 * @return the quotation driverse endorses
	 */
	@Override
	public List<QuotationDriverseEndors> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotation driverse endorses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriverseEndorsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation driverse endorses
	 * @param end the upper bound of the range of quotation driverse endorses (not inclusive)
	 * @return the range of quotation driverse endorses
	 */
	@Override
	public List<QuotationDriverseEndors> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotation driverse endorses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriverseEndorsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation driverse endorses
	 * @param end the upper bound of the range of quotation driverse endorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotation driverse endorses
	 */
	@Override
	public List<QuotationDriverseEndors> findAll(
		int start, int end,
		OrderByComparator<QuotationDriverseEndors> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotation driverse endorses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriverseEndorsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation driverse endorses
	 * @param end the upper bound of the range of quotation driverse endorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotation driverse endorses
	 */
	@Override
	public List<QuotationDriverseEndors> findAll(
		int start, int end,
		OrderByComparator<QuotationDriverseEndors> orderByComparator,
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

		List<QuotationDriverseEndors> list = null;

		if (useFinderCache) {
			list = (List<QuotationDriverseEndors>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_QUOTATIONDRIVERSEENDORS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_QUOTATIONDRIVERSEENDORS;

				sql = sql.concat(
					QuotationDriverseEndorsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<QuotationDriverseEndors>)QueryUtil.list(
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
	 * Removes all the quotation driverse endorses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QuotationDriverseEndors quotationDriverseEndors : findAll()) {
			remove(quotationDriverseEndors);
		}
	}

	/**
	 * Returns the number of quotation driverse endorses.
	 *
	 * @return the number of quotation driverse endorses
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
					_SQL_COUNT_QUOTATIONDRIVERSEENDORS);

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
		return _SQL_SELECT_QUOTATIONDRIVERSEENDORS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QuotationDriverseEndorsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the quotation driverse endors persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new QuotationDriverseEndorsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", QuotationDriverseEndors.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"STATUS"}, true);

		_finderPathWithoutPaginationFindByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {String.class.getName()}, new String[] {"STATUS"},
			true);

		_finderPathCountByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {String.class.getName()}, new String[] {"STATUS"},
			false);

		_finderPathFetchByeachStatus = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByeachStatus",
			new String[] {String.class.getName()}, new String[] {"STATUS"},
			true);

		_finderPathCountByeachStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByeachStatus",
			new String[] {String.class.getName()}, new String[] {"STATUS"},
			false);

		_finderPathFetchByDriverId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDriverId",
			new String[] {String.class.getName()}, new String[] {"DRIVER_ID"},
			true);

		_finderPathCountByDriverId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDriverId",
			new String[] {String.class.getName()}, new String[] {"DRIVER_ID"},
			false);

		_finderPathFetchBypolicyNumber = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBypolicyNumber",
			new String[] {String.class.getName()},
			new String[] {"POLICY_NUMBER"}, true);

		_finderPathCountBypolicyNumber = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypolicyNumber",
			new String[] {String.class.getName()},
			new String[] {"POLICY_NUMBER"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(
			QuotationDriverseEndorsImpl.class.getName());

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

	private static final String _SQL_SELECT_QUOTATIONDRIVERSEENDORS =
		"SELECT quotationDriverseEndors FROM QuotationDriverseEndors quotationDriverseEndors";

	private static final String _SQL_SELECT_QUOTATIONDRIVERSEENDORS_WHERE =
		"SELECT quotationDriverseEndors FROM QuotationDriverseEndors quotationDriverseEndors WHERE ";

	private static final String _SQL_COUNT_QUOTATIONDRIVERSEENDORS =
		"SELECT COUNT(quotationDriverseEndors) FROM QuotationDriverseEndors quotationDriverseEndors";

	private static final String _SQL_COUNT_QUOTATIONDRIVERSEENDORS_WHERE =
		"SELECT COUNT(quotationDriverseEndors) FROM QuotationDriverseEndors quotationDriverseEndors WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"quotationDriverseEndors.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No QuotationDriverseEndors exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No QuotationDriverseEndors exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		QuotationDriverseEndorsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"addDriverId", "quotationId", "policyNumber", "driverDob",
			"driverDobH", "driverGender", "driverId", "driverIdType",
			"driverName", "driverNationality", "driverOccup", "isDriverUnder21",
			"driverEdu", "driverNoChild", "driverMaritalStatus",
			"driverNOFault", "driverNOClaim", "driverConvictions",
			"driverMedConds", "ncdYears", "insuredRelation",
			"insuredRelationProof", "insuredRelationProofFileName", "status",
			"requestedDate", "buildNo", "zipCode", "addNo", "stNameEn",
			"stNameAr", "districtEn", "districtAr", "cityEn", "cityAr",
			"isNatAddress"
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

	private static class QuotationDriverseEndorsModelArgumentsResolver
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

			QuotationDriverseEndorsModelImpl quotationDriverseEndorsModelImpl =
				(QuotationDriverseEndorsModelImpl)baseModel;

			long columnBitmask =
				quotationDriverseEndorsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					quotationDriverseEndorsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						quotationDriverseEndorsModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					quotationDriverseEndorsModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			QuotationDriverseEndorsModelImpl quotationDriverseEndorsModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						quotationDriverseEndorsModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						quotationDriverseEndorsModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}