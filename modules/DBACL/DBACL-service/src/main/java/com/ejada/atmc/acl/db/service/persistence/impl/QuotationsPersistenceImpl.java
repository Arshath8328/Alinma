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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationsException;
import com.ejada.atmc.acl.db.model.Quotations;
import com.ejada.atmc.acl.db.model.impl.QuotationsImpl;
import com.ejada.atmc.acl.db.model.impl.QuotationsModelImpl;
import com.ejada.atmc.acl.db.service.persistence.QuotationsPersistence;
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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
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
 * The persistence implementation for the quotations service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = QuotationsPersistence.class)
public class QuotationsPersistenceImpl
	extends BasePersistenceImpl<Quotations> implements QuotationsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>QuotationsUtil</code> to access the quotations persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		QuotationsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByInsuredId;
	private FinderPath _finderPathWithoutPaginationFindByInsuredId;
	private FinderPath _finderPathCountByInsuredId;

	/**
	 * Returns all the quotationses where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @return the matching quotationses
	 */
	@Override
	public List<Quotations> findByInsuredId(long insuredId) {
		return findByInsuredId(
			insuredId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotationses where insuredId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	@Override
	public List<Quotations> findByInsuredId(
		long insuredId, int start, int end) {

		return findByInsuredId(insuredId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotationses where insuredId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByInsuredId(
		long insuredId, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return findByInsuredId(insuredId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotationses where insuredId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByInsuredId(
		long insuredId, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByInsuredId;
				finderArgs = new Object[] {insuredId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByInsuredId;
			finderArgs = new Object[] {
				insuredId, start, end, orderByComparator
			};
		}

		List<Quotations> list = null;

		if (useFinderCache) {
			list = (List<Quotations>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Quotations quotations : list) {
					if (insuredId != quotations.getInsuredId()) {
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

			sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

			sb.append(_FINDER_COLUMN_INSUREDID_INSUREDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(insuredId);

				list = (List<Quotations>)QueryUtil.list(
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
	 * Returns the first quotations in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	@Override
	public Quotations findByInsuredId_First(
			long insuredId, OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		Quotations quotations = fetchByInsuredId_First(
			insuredId, orderByComparator);

		if (quotations != null) {
			return quotations;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("insuredId=");
		sb.append(insuredId);

		sb.append("}");

		throw new NoSuchQuotationsException(sb.toString());
	}

	/**
	 * Returns the first quotations in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	@Override
	public Quotations fetchByInsuredId_First(
		long insuredId, OrderByComparator<Quotations> orderByComparator) {

		List<Quotations> list = findByInsuredId(
			insuredId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last quotations in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	@Override
	public Quotations findByInsuredId_Last(
			long insuredId, OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		Quotations quotations = fetchByInsuredId_Last(
			insuredId, orderByComparator);

		if (quotations != null) {
			return quotations;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("insuredId=");
		sb.append(insuredId);

		sb.append("}");

		throw new NoSuchQuotationsException(sb.toString());
	}

	/**
	 * Returns the last quotations in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	@Override
	public Quotations fetchByInsuredId_Last(
		long insuredId, OrderByComparator<Quotations> orderByComparator) {

		int count = countByInsuredId(insuredId);

		if (count == 0) {
			return null;
		}

		List<Quotations> list = findByInsuredId(
			insuredId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the quotationses before and after the current quotations in the ordered set where insuredId = &#63;.
	 *
	 * @param quotationId the primary key of the current quotations
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	@Override
	public Quotations[] findByInsuredId_PrevAndNext(
			long quotationId, long insuredId,
			OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		Quotations quotations = findByPrimaryKey(quotationId);

		Session session = null;

		try {
			session = openSession();

			Quotations[] array = new QuotationsImpl[3];

			array[0] = getByInsuredId_PrevAndNext(
				session, quotations, insuredId, orderByComparator, true);

			array[1] = quotations;

			array[2] = getByInsuredId_PrevAndNext(
				session, quotations, insuredId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Quotations getByInsuredId_PrevAndNext(
		Session session, Quotations quotations, long insuredId,
		OrderByComparator<Quotations> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

		sb.append(_FINDER_COLUMN_INSUREDID_INSUREDID_2);

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
			sb.append(QuotationsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(insuredId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(quotations)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Quotations> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the quotationses where insuredId = &#63; from the database.
	 *
	 * @param insuredId the insured ID
	 */
	@Override
	public void removeByInsuredId(long insuredId) {
		for (Quotations quotations :
				findByInsuredId(
					insuredId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(quotations);
		}
	}

	/**
	 * Returns the number of quotationses where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @return the number of matching quotationses
	 */
	@Override
	public int countByInsuredId(long insuredId) {
		FinderPath finderPath = _finderPathCountByInsuredId;

		Object[] finderArgs = new Object[] {insuredId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUOTATIONS_WHERE);

			sb.append(_FINDER_COLUMN_INSUREDID_INSUREDID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(insuredId);

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

	private static final String _FINDER_COLUMN_INSUREDID_INSUREDID_2 =
		"quotations.insuredId = ?";

	private FinderPath _finderPathWithPaginationFindByQuotationId;
	private FinderPath _finderPathWithoutPaginationFindByQuotationId;
	private FinderPath _finderPathCountByQuotationId;

	/**
	 * Returns all the quotationses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotationses
	 */
	@Override
	public List<Quotations> findByQuotationId(long quotationId) {
		return findByQuotationId(
			quotationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotationses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	@Override
	public List<Quotations> findByQuotationId(
		long quotationId, int start, int end) {

		return findByQuotationId(quotationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotationses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return findByQuotationId(
			quotationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotationses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
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

		List<Quotations> list = null;

		if (useFinderCache) {
			list = (List<Quotations>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Quotations quotations : list) {
					if (quotationId != quotations.getQuotationId()) {
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

			sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

			sb.append(_FINDER_COLUMN_QUOTATIONID_QUOTATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(quotationId);

				list = (List<Quotations>)QueryUtil.list(
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
	 * Returns the first quotations in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	@Override
	public Quotations findByQuotationId_First(
			long quotationId, OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		Quotations quotations = fetchByQuotationId_First(
			quotationId, orderByComparator);

		if (quotations != null) {
			return quotations;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quotationId=");
		sb.append(quotationId);

		sb.append("}");

		throw new NoSuchQuotationsException(sb.toString());
	}

	/**
	 * Returns the first quotations in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	@Override
	public Quotations fetchByQuotationId_First(
		long quotationId, OrderByComparator<Quotations> orderByComparator) {

		List<Quotations> list = findByQuotationId(
			quotationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last quotations in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	@Override
	public Quotations findByQuotationId_Last(
			long quotationId, OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		Quotations quotations = fetchByQuotationId_Last(
			quotationId, orderByComparator);

		if (quotations != null) {
			return quotations;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quotationId=");
		sb.append(quotationId);

		sb.append("}");

		throw new NoSuchQuotationsException(sb.toString());
	}

	/**
	 * Returns the last quotations in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	@Override
	public Quotations fetchByQuotationId_Last(
		long quotationId, OrderByComparator<Quotations> orderByComparator) {

		int count = countByQuotationId(quotationId);

		if (count == 0) {
			return null;
		}

		List<Quotations> list = findByQuotationId(
			quotationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the quotationses where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	@Override
	public void removeByQuotationId(long quotationId) {
		for (Quotations quotations :
				findByQuotationId(
					quotationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(quotations);
		}
	}

	/**
	 * Returns the number of quotationses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotationses
	 */
	@Override
	public int countByQuotationId(long quotationId) {
		FinderPath finderPath = _finderPathCountByQuotationId;

		Object[] finderArgs = new Object[] {quotationId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUOTATIONS_WHERE);

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
		"quotations.quotationId = ?";

	private FinderPath _finderPathWithPaginationFindByInsuredIdAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByInsuredIdAndStatus;
	private FinderPath _finderPathCountByInsuredIdAndStatus;
	private FinderPath _finderPathWithPaginationCountByInsuredIdAndStatus;

	/**
	 * Returns all the quotationses where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @return the matching quotationses
	 */
	@Override
	public List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String quoteStatus) {

		return findByInsuredIdAndStatus(
			insuredId, quoteStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotationses where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	@Override
	public List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String quoteStatus, int start, int end) {

		return findByInsuredIdAndStatus(
			insuredId, quoteStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotationses where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String quoteStatus, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return findByInsuredIdAndStatus(
			insuredId, quoteStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotationses where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String quoteStatus, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		quoteStatus = Objects.toString(quoteStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByInsuredIdAndStatus;
				finderArgs = new Object[] {insuredId, quoteStatus};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByInsuredIdAndStatus;
			finderArgs = new Object[] {
				insuredId, quoteStatus, start, end, orderByComparator
			};
		}

		List<Quotations> list = null;

		if (useFinderCache) {
			list = (List<Quotations>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Quotations quotations : list) {
					if ((insuredId != quotations.getInsuredId()) ||
						!quoteStatus.equals(quotations.getQuoteStatus())) {

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

			sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

			sb.append(_FINDER_COLUMN_INSUREDIDANDSTATUS_INSUREDID_2);

			boolean bindQuoteStatus = false;

			if (quoteStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_INSUREDIDANDSTATUS_QUOTESTATUS_3);
			}
			else {
				bindQuoteStatus = true;

				sb.append(_FINDER_COLUMN_INSUREDIDANDSTATUS_QUOTESTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(insuredId);

				if (bindQuoteStatus) {
					queryPos.add(quoteStatus);
				}

				list = (List<Quotations>)QueryUtil.list(
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
	 * Returns the first quotations in the ordered set where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	@Override
	public Quotations findByInsuredIdAndStatus_First(
			long insuredId, String quoteStatus,
			OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		Quotations quotations = fetchByInsuredIdAndStatus_First(
			insuredId, quoteStatus, orderByComparator);

		if (quotations != null) {
			return quotations;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("insuredId=");
		sb.append(insuredId);

		sb.append(", quoteStatus=");
		sb.append(quoteStatus);

		sb.append("}");

		throw new NoSuchQuotationsException(sb.toString());
	}

	/**
	 * Returns the first quotations in the ordered set where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	@Override
	public Quotations fetchByInsuredIdAndStatus_First(
		long insuredId, String quoteStatus,
		OrderByComparator<Quotations> orderByComparator) {

		List<Quotations> list = findByInsuredIdAndStatus(
			insuredId, quoteStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last quotations in the ordered set where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	@Override
	public Quotations findByInsuredIdAndStatus_Last(
			long insuredId, String quoteStatus,
			OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		Quotations quotations = fetchByInsuredIdAndStatus_Last(
			insuredId, quoteStatus, orderByComparator);

		if (quotations != null) {
			return quotations;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("insuredId=");
		sb.append(insuredId);

		sb.append(", quoteStatus=");
		sb.append(quoteStatus);

		sb.append("}");

		throw new NoSuchQuotationsException(sb.toString());
	}

	/**
	 * Returns the last quotations in the ordered set where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	@Override
	public Quotations fetchByInsuredIdAndStatus_Last(
		long insuredId, String quoteStatus,
		OrderByComparator<Quotations> orderByComparator) {

		int count = countByInsuredIdAndStatus(insuredId, quoteStatus);

		if (count == 0) {
			return null;
		}

		List<Quotations> list = findByInsuredIdAndStatus(
			insuredId, quoteStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the quotationses before and after the current quotations in the ordered set where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param quotationId the primary key of the current quotations
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	@Override
	public Quotations[] findByInsuredIdAndStatus_PrevAndNext(
			long quotationId, long insuredId, String quoteStatus,
			OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		quoteStatus = Objects.toString(quoteStatus, "");

		Quotations quotations = findByPrimaryKey(quotationId);

		Session session = null;

		try {
			session = openSession();

			Quotations[] array = new QuotationsImpl[3];

			array[0] = getByInsuredIdAndStatus_PrevAndNext(
				session, quotations, insuredId, quoteStatus, orderByComparator,
				true);

			array[1] = quotations;

			array[2] = getByInsuredIdAndStatus_PrevAndNext(
				session, quotations, insuredId, quoteStatus, orderByComparator,
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

	protected Quotations getByInsuredIdAndStatus_PrevAndNext(
		Session session, Quotations quotations, long insuredId,
		String quoteStatus, OrderByComparator<Quotations> orderByComparator,
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

		sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

		sb.append(_FINDER_COLUMN_INSUREDIDANDSTATUS_INSUREDID_2);

		boolean bindQuoteStatus = false;

		if (quoteStatus.isEmpty()) {
			sb.append(_FINDER_COLUMN_INSUREDIDANDSTATUS_QUOTESTATUS_3);
		}
		else {
			bindQuoteStatus = true;

			sb.append(_FINDER_COLUMN_INSUREDIDANDSTATUS_QUOTESTATUS_2);
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
			sb.append(QuotationsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(insuredId);

		if (bindQuoteStatus) {
			queryPos.add(quoteStatus);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(quotations)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Quotations> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the quotationses where insuredId = &#63; and quoteStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatuses the quote statuses
	 * @return the matching quotationses
	 */
	@Override
	public List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String[] quoteStatuses) {

		return findByInsuredIdAndStatus(
			insuredId, quoteStatuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the quotationses where insuredId = &#63; and quoteStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatuses the quote statuses
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	@Override
	public List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String[] quoteStatuses, int start, int end) {

		return findByInsuredIdAndStatus(
			insuredId, quoteStatuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotationses where insuredId = &#63; and quoteStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatuses the quote statuses
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String[] quoteStatuses, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return findByInsuredIdAndStatus(
			insuredId, quoteStatuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotationses where insuredId = &#63; and quoteStatus = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String[] quoteStatuses, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		if (quoteStatuses == null) {
			quoteStatuses = new String[0];
		}
		else if (quoteStatuses.length > 1) {
			for (int i = 0; i < quoteStatuses.length; i++) {
				quoteStatuses[i] = Objects.toString(quoteStatuses[i], "");
			}

			quoteStatuses = ArrayUtil.sortedUnique(quoteStatuses);
		}

		if (quoteStatuses.length == 1) {
			return findByInsuredIdAndStatus(
				insuredId, quoteStatuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					insuredId, StringUtil.merge(quoteStatuses)
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				insuredId, StringUtil.merge(quoteStatuses), start, end,
				orderByComparator
			};
		}

		List<Quotations> list = null;

		if (useFinderCache) {
			list = (List<Quotations>)dummyFinderCache.getResult(
				_finderPathWithPaginationFindByInsuredIdAndStatus, finderArgs,
				this);

			if ((list != null) && !list.isEmpty()) {
				for (Quotations quotations : list) {
					if ((insuredId != quotations.getInsuredId()) ||
						!ArrayUtil.contains(
							quoteStatuses, quotations.getQuoteStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

			sb.append(_FINDER_COLUMN_INSUREDIDANDSTATUS_INSUREDID_2);

			if (quoteStatuses.length > 0) {
				sb.append("(");

				for (int i = 0; i < quoteStatuses.length; i++) {
					String quoteStatus = quoteStatuses[i];

					if (quoteStatus.isEmpty()) {
						sb.append(
							_FINDER_COLUMN_INSUREDIDANDSTATUS_QUOTESTATUS_3);
					}
					else {
						sb.append(
							_FINDER_COLUMN_INSUREDIDANDSTATUS_QUOTESTATUS_2);
					}

					if ((i + 1) < quoteStatuses.length) {
						sb.append(WHERE_OR);
					}
				}

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(insuredId);

				for (String quoteStatus : quoteStatuses) {
					if ((quoteStatus != null) && !quoteStatus.isEmpty()) {
						queryPos.add(quoteStatus);
					}
				}

				list = (List<Quotations>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(
						_finderPathWithPaginationFindByInsuredIdAndStatus,
						finderArgs, list);
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
	 * Removes all the quotationses where insuredId = &#63; and quoteStatus = &#63; from the database.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 */
	@Override
	public void removeByInsuredIdAndStatus(long insuredId, String quoteStatus) {
		for (Quotations quotations :
				findByInsuredIdAndStatus(
					insuredId, quoteStatus, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(quotations);
		}
	}

	/**
	 * Returns the number of quotationses where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @return the number of matching quotationses
	 */
	@Override
	public int countByInsuredIdAndStatus(long insuredId, String quoteStatus) {
		quoteStatus = Objects.toString(quoteStatus, "");

		FinderPath finderPath = _finderPathCountByInsuredIdAndStatus;

		Object[] finderArgs = new Object[] {insuredId, quoteStatus};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_QUOTATIONS_WHERE);

			sb.append(_FINDER_COLUMN_INSUREDIDANDSTATUS_INSUREDID_2);

			boolean bindQuoteStatus = false;

			if (quoteStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_INSUREDIDANDSTATUS_QUOTESTATUS_3);
			}
			else {
				bindQuoteStatus = true;

				sb.append(_FINDER_COLUMN_INSUREDIDANDSTATUS_QUOTESTATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(insuredId);

				if (bindQuoteStatus) {
					queryPos.add(quoteStatus);
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

	/**
	 * Returns the number of quotationses where insuredId = &#63; and quoteStatus = any &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatuses the quote statuses
	 * @return the number of matching quotationses
	 */
	@Override
	public int countByInsuredIdAndStatus(
		long insuredId, String[] quoteStatuses) {

		if (quoteStatuses == null) {
			quoteStatuses = new String[0];
		}
		else if (quoteStatuses.length > 1) {
			for (int i = 0; i < quoteStatuses.length; i++) {
				quoteStatuses[i] = Objects.toString(quoteStatuses[i], "");
			}

			quoteStatuses = ArrayUtil.sortedUnique(quoteStatuses);
		}

		Object[] finderArgs = new Object[] {
			insuredId, StringUtil.merge(quoteStatuses)
		};

		Long count = (Long)dummyFinderCache.getResult(
			_finderPathWithPaginationCountByInsuredIdAndStatus, finderArgs,
			this);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_QUOTATIONS_WHERE);

			sb.append(_FINDER_COLUMN_INSUREDIDANDSTATUS_INSUREDID_2);

			if (quoteStatuses.length > 0) {
				sb.append("(");

				for (int i = 0; i < quoteStatuses.length; i++) {
					String quoteStatus = quoteStatuses[i];

					if (quoteStatus.isEmpty()) {
						sb.append(
							_FINDER_COLUMN_INSUREDIDANDSTATUS_QUOTESTATUS_3);
					}
					else {
						sb.append(
							_FINDER_COLUMN_INSUREDIDANDSTATUS_QUOTESTATUS_2);
					}

					if ((i + 1) < quoteStatuses.length) {
						sb.append(WHERE_OR);
					}
				}

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(insuredId);

				for (String quoteStatus : quoteStatuses) {
					if ((quoteStatus != null) && !quoteStatus.isEmpty()) {
						queryPos.add(quoteStatus);
					}
				}

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(
					_finderPathWithPaginationCountByInsuredIdAndStatus,
					finderArgs, count);
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

	private static final String _FINDER_COLUMN_INSUREDIDANDSTATUS_INSUREDID_2 =
		"quotations.insuredId = ? AND ";

	private static final String
		_FINDER_COLUMN_INSUREDIDANDSTATUS_QUOTESTATUS_2 =
			"quotations.quoteStatus = ?";

	private static final String
		_FINDER_COLUMN_INSUREDIDANDSTATUS_QUOTESTATUS_3 =
			"(quotations.quoteStatus IS NULL OR quotations.quoteStatus = '')";

	private FinderPath _finderPathWithPaginationFindByDateExpiredQuots;
	private FinderPath _finderPathWithPaginationCountByDateExpiredQuots;

	/**
	 * Returns all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @return the matching quotationses
	 */
	@Override
	public List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String quoteStatus) {

		return findByDateExpiredQuots(
			vehicleEstExpiryDate, quoteStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	@Override
	public List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String quoteStatus, int start, int end) {

		return findByDateExpiredQuots(
			vehicleEstExpiryDate, quoteStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String quoteStatus, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return findByDateExpiredQuots(
			vehicleEstExpiryDate, quoteStatus, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String quoteStatus, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		quoteStatus = Objects.toString(quoteStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByDateExpiredQuots;
		finderArgs = new Object[] {
			_getTime(vehicleEstExpiryDate), quoteStatus, start, end,
			orderByComparator
		};

		List<Quotations> list = null;

		if (useFinderCache) {
			list = (List<Quotations>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Quotations quotations : list) {
					if ((vehicleEstExpiryDate.getTime() <=
							quotations.getVehicleEstExpiryDate(
							).getTime()) ||
						!quoteStatus.equals(quotations.getQuoteStatus())) {

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

			sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

			boolean bindVehicleEstExpiryDate = false;

			if (vehicleEstExpiryDate == null) {
				sb.append(
					_FINDER_COLUMN_DATEEXPIREDQUOTS_VEHICLEESTEXPIRYDATE_1);
			}
			else {
				bindVehicleEstExpiryDate = true;

				sb.append(
					_FINDER_COLUMN_DATEEXPIREDQUOTS_VEHICLEESTEXPIRYDATE_2);
			}

			boolean bindQuoteStatus = false;

			if (quoteStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_DATEEXPIREDQUOTS_QUOTESTATUS_3);
			}
			else {
				bindQuoteStatus = true;

				sb.append(_FINDER_COLUMN_DATEEXPIREDQUOTS_QUOTESTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindVehicleEstExpiryDate) {
					queryPos.add(new Timestamp(vehicleEstExpiryDate.getTime()));
				}

				if (bindQuoteStatus) {
					queryPos.add(quoteStatus);
				}

				list = (List<Quotations>)QueryUtil.list(
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
	 * Returns the first quotations in the ordered set where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	@Override
	public Quotations findByDateExpiredQuots_First(
			Date vehicleEstExpiryDate, String quoteStatus,
			OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		Quotations quotations = fetchByDateExpiredQuots_First(
			vehicleEstExpiryDate, quoteStatus, orderByComparator);

		if (quotations != null) {
			return quotations;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("vehicleEstExpiryDate<");
		sb.append(vehicleEstExpiryDate);

		sb.append(", quoteStatus=");
		sb.append(quoteStatus);

		sb.append("}");

		throw new NoSuchQuotationsException(sb.toString());
	}

	/**
	 * Returns the first quotations in the ordered set where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	@Override
	public Quotations fetchByDateExpiredQuots_First(
		Date vehicleEstExpiryDate, String quoteStatus,
		OrderByComparator<Quotations> orderByComparator) {

		List<Quotations> list = findByDateExpiredQuots(
			vehicleEstExpiryDate, quoteStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last quotations in the ordered set where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	@Override
	public Quotations findByDateExpiredQuots_Last(
			Date vehicleEstExpiryDate, String quoteStatus,
			OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		Quotations quotations = fetchByDateExpiredQuots_Last(
			vehicleEstExpiryDate, quoteStatus, orderByComparator);

		if (quotations != null) {
			return quotations;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("vehicleEstExpiryDate<");
		sb.append(vehicleEstExpiryDate);

		sb.append(", quoteStatus=");
		sb.append(quoteStatus);

		sb.append("}");

		throw new NoSuchQuotationsException(sb.toString());
	}

	/**
	 * Returns the last quotations in the ordered set where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	@Override
	public Quotations fetchByDateExpiredQuots_Last(
		Date vehicleEstExpiryDate, String quoteStatus,
		OrderByComparator<Quotations> orderByComparator) {

		int count = countByDateExpiredQuots(vehicleEstExpiryDate, quoteStatus);

		if (count == 0) {
			return null;
		}

		List<Quotations> list = findByDateExpiredQuots(
			vehicleEstExpiryDate, quoteStatus, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the quotationses before and after the current quotations in the ordered set where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param quotationId the primary key of the current quotations
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	@Override
	public Quotations[] findByDateExpiredQuots_PrevAndNext(
			long quotationId, Date vehicleEstExpiryDate, String quoteStatus,
			OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		quoteStatus = Objects.toString(quoteStatus, "");

		Quotations quotations = findByPrimaryKey(quotationId);

		Session session = null;

		try {
			session = openSession();

			Quotations[] array = new QuotationsImpl[3];

			array[0] = getByDateExpiredQuots_PrevAndNext(
				session, quotations, vehicleEstExpiryDate, quoteStatus,
				orderByComparator, true);

			array[1] = quotations;

			array[2] = getByDateExpiredQuots_PrevAndNext(
				session, quotations, vehicleEstExpiryDate, quoteStatus,
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

	protected Quotations getByDateExpiredQuots_PrevAndNext(
		Session session, Quotations quotations, Date vehicleEstExpiryDate,
		String quoteStatus, OrderByComparator<Quotations> orderByComparator,
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

		sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

		boolean bindVehicleEstExpiryDate = false;

		if (vehicleEstExpiryDate == null) {
			sb.append(_FINDER_COLUMN_DATEEXPIREDQUOTS_VEHICLEESTEXPIRYDATE_1);
		}
		else {
			bindVehicleEstExpiryDate = true;

			sb.append(_FINDER_COLUMN_DATEEXPIREDQUOTS_VEHICLEESTEXPIRYDATE_2);
		}

		boolean bindQuoteStatus = false;

		if (quoteStatus.isEmpty()) {
			sb.append(_FINDER_COLUMN_DATEEXPIREDQUOTS_QUOTESTATUS_3);
		}
		else {
			bindQuoteStatus = true;

			sb.append(_FINDER_COLUMN_DATEEXPIREDQUOTS_QUOTESTATUS_2);
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
			sb.append(QuotationsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindVehicleEstExpiryDate) {
			queryPos.add(new Timestamp(vehicleEstExpiryDate.getTime()));
		}

		if (bindQuoteStatus) {
			queryPos.add(quoteStatus);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(quotations)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Quotations> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatuses the quote statuses
	 * @return the matching quotationses
	 */
	@Override
	public List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String[] quoteStatuses) {

		return findByDateExpiredQuots(
			vehicleEstExpiryDate, quoteStatuses, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatuses the quote statuses
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	@Override
	public List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String[] quoteStatuses, int start, int end) {

		return findByDateExpiredQuots(
			vehicleEstExpiryDate, quoteStatuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatuses the quote statuses
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String[] quoteStatuses, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return findByDateExpiredQuots(
			vehicleEstExpiryDate, quoteStatuses, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String[] quoteStatuses, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		if (quoteStatuses == null) {
			quoteStatuses = new String[0];
		}
		else if (quoteStatuses.length > 1) {
			for (int i = 0; i < quoteStatuses.length; i++) {
				quoteStatuses[i] = Objects.toString(quoteStatuses[i], "");
			}

			quoteStatuses = ArrayUtil.sortedUnique(quoteStatuses);
		}

		if (quoteStatuses.length == 1) {
			return findByDateExpiredQuots(
				vehicleEstExpiryDate, quoteStatuses[0], start, end,
				orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					_getTime(vehicleEstExpiryDate),
					StringUtil.merge(quoteStatuses)
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				_getTime(vehicleEstExpiryDate), StringUtil.merge(quoteStatuses),
				start, end, orderByComparator
			};
		}

		List<Quotations> list = null;

		if (useFinderCache) {
			list = (List<Quotations>)dummyFinderCache.getResult(
				_finderPathWithPaginationFindByDateExpiredQuots, finderArgs,
				this);

			if ((list != null) && !list.isEmpty()) {
				for (Quotations quotations : list) {
					if ((vehicleEstExpiryDate.getTime() <=
							quotations.getVehicleEstExpiryDate(
							).getTime()) ||
						!ArrayUtil.contains(
							quoteStatuses, quotations.getQuoteStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

			boolean bindVehicleEstExpiryDate = false;

			if (vehicleEstExpiryDate == null) {
				sb.append(
					_FINDER_COLUMN_DATEEXPIREDQUOTS_VEHICLEESTEXPIRYDATE_1);
			}
			else {
				bindVehicleEstExpiryDate = true;

				sb.append(
					_FINDER_COLUMN_DATEEXPIREDQUOTS_VEHICLEESTEXPIRYDATE_2);
			}

			if (quoteStatuses.length > 0) {
				sb.append("(");

				for (int i = 0; i < quoteStatuses.length; i++) {
					String quoteStatus = quoteStatuses[i];

					if (quoteStatus.isEmpty()) {
						sb.append(
							_FINDER_COLUMN_DATEEXPIREDQUOTS_QUOTESTATUS_3);
					}
					else {
						sb.append(
							_FINDER_COLUMN_DATEEXPIREDQUOTS_QUOTESTATUS_2);
					}

					if ((i + 1) < quoteStatuses.length) {
						sb.append(WHERE_OR);
					}
				}

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindVehicleEstExpiryDate) {
					queryPos.add(new Timestamp(vehicleEstExpiryDate.getTime()));
				}

				for (String quoteStatus : quoteStatuses) {
					if ((quoteStatus != null) && !quoteStatus.isEmpty()) {
						queryPos.add(quoteStatus);
					}
				}

				list = (List<Quotations>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(
						_finderPathWithPaginationFindByDateExpiredQuots,
						finderArgs, list);
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
	 * Removes all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63; from the database.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 */
	@Override
	public void removeByDateExpiredQuots(
		Date vehicleEstExpiryDate, String quoteStatus) {

		for (Quotations quotations :
				findByDateExpiredQuots(
					vehicleEstExpiryDate, quoteStatus, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(quotations);
		}
	}

	/**
	 * Returns the number of quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @return the number of matching quotationses
	 */
	@Override
	public int countByDateExpiredQuots(
		Date vehicleEstExpiryDate, String quoteStatus) {

		quoteStatus = Objects.toString(quoteStatus, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByDateExpiredQuots;

		Object[] finderArgs = new Object[] {
			_getTime(vehicleEstExpiryDate), quoteStatus
		};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_QUOTATIONS_WHERE);

			boolean bindVehicleEstExpiryDate = false;

			if (vehicleEstExpiryDate == null) {
				sb.append(
					_FINDER_COLUMN_DATEEXPIREDQUOTS_VEHICLEESTEXPIRYDATE_1);
			}
			else {
				bindVehicleEstExpiryDate = true;

				sb.append(
					_FINDER_COLUMN_DATEEXPIREDQUOTS_VEHICLEESTEXPIRYDATE_2);
			}

			boolean bindQuoteStatus = false;

			if (quoteStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_DATEEXPIREDQUOTS_QUOTESTATUS_3);
			}
			else {
				bindQuoteStatus = true;

				sb.append(_FINDER_COLUMN_DATEEXPIREDQUOTS_QUOTESTATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindVehicleEstExpiryDate) {
					queryPos.add(new Timestamp(vehicleEstExpiryDate.getTime()));
				}

				if (bindQuoteStatus) {
					queryPos.add(quoteStatus);
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

	/**
	 * Returns the number of quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = any &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatuses the quote statuses
	 * @return the number of matching quotationses
	 */
	@Override
	public int countByDateExpiredQuots(
		Date vehicleEstExpiryDate, String[] quoteStatuses) {

		if (quoteStatuses == null) {
			quoteStatuses = new String[0];
		}
		else if (quoteStatuses.length > 1) {
			for (int i = 0; i < quoteStatuses.length; i++) {
				quoteStatuses[i] = Objects.toString(quoteStatuses[i], "");
			}

			quoteStatuses = ArrayUtil.sortedUnique(quoteStatuses);
		}

		Object[] finderArgs = new Object[] {
			_getTime(vehicleEstExpiryDate), StringUtil.merge(quoteStatuses)
		};

		Long count = (Long)dummyFinderCache.getResult(
			_finderPathWithPaginationCountByDateExpiredQuots, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_QUOTATIONS_WHERE);

			boolean bindVehicleEstExpiryDate = false;

			if (vehicleEstExpiryDate == null) {
				sb.append(
					_FINDER_COLUMN_DATEEXPIREDQUOTS_VEHICLEESTEXPIRYDATE_1);
			}
			else {
				bindVehicleEstExpiryDate = true;

				sb.append(
					_FINDER_COLUMN_DATEEXPIREDQUOTS_VEHICLEESTEXPIRYDATE_2);
			}

			if (quoteStatuses.length > 0) {
				sb.append("(");

				for (int i = 0; i < quoteStatuses.length; i++) {
					String quoteStatus = quoteStatuses[i];

					if (quoteStatus.isEmpty()) {
						sb.append(
							_FINDER_COLUMN_DATEEXPIREDQUOTS_QUOTESTATUS_3);
					}
					else {
						sb.append(
							_FINDER_COLUMN_DATEEXPIREDQUOTS_QUOTESTATUS_2);
					}

					if ((i + 1) < quoteStatuses.length) {
						sb.append(WHERE_OR);
					}
				}

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindVehicleEstExpiryDate) {
					queryPos.add(new Timestamp(vehicleEstExpiryDate.getTime()));
				}

				for (String quoteStatus : quoteStatuses) {
					if ((quoteStatus != null) && !quoteStatus.isEmpty()) {
						queryPos.add(quoteStatus);
					}
				}

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(
					_finderPathWithPaginationCountByDateExpiredQuots,
					finderArgs, count);
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
		_FINDER_COLUMN_DATEEXPIREDQUOTS_VEHICLEESTEXPIRYDATE_1 =
			"quotations.vehicleEstExpiryDate IS NULL AND ";

	private static final String
		_FINDER_COLUMN_DATEEXPIREDQUOTS_VEHICLEESTEXPIRYDATE_2 =
			"quotations.vehicleEstExpiryDate < ? AND ";

	private static final String _FINDER_COLUMN_DATEEXPIREDQUOTS_QUOTESTATUS_2 =
		"quotations.quoteStatus = ?";

	private static final String _FINDER_COLUMN_DATEEXPIREDQUOTS_QUOTESTATUS_3 =
		"(quotations.quoteStatus IS NULL OR quotations.quoteStatus = '')";

	private FinderPath _finderPathWithPaginationFindByPendingQuots;
	private FinderPath _finderPathWithPaginationCountByPendingQuots;

	/**
	 * Returns all the quotationses where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @return the matching quotationses
	 */
	@Override
	public List<Quotations> findByPendingQuots(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag) {

		return findByPendingQuots(
			vehicleEstExpiryDate, quoteStatus, smsFlag, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotationses where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	@Override
	public List<Quotations> findByPendingQuots(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
		int start, int end) {

		return findByPendingQuots(
			vehicleEstExpiryDate, quoteStatus, smsFlag, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotationses where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByPendingQuots(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
		int start, int end, OrderByComparator<Quotations> orderByComparator) {

		return findByPendingQuots(
			vehicleEstExpiryDate, quoteStatus, smsFlag, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotationses where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByPendingQuots(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
		int start, int end, OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		quoteStatus = Objects.toString(quoteStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByPendingQuots;
		finderArgs = new Object[] {
			_getTime(vehicleEstExpiryDate), quoteStatus, smsFlag, start, end,
			orderByComparator
		};

		List<Quotations> list = null;

		if (useFinderCache) {
			list = (List<Quotations>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Quotations quotations : list) {
					if ((vehicleEstExpiryDate.getTime() >=
							quotations.getVehicleEstExpiryDate(
							).getTime()) ||
						!quoteStatus.equals(quotations.getQuoteStatus()) ||
						(smsFlag != quotations.isSmsFlag())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

			boolean bindVehicleEstExpiryDate = false;

			if (vehicleEstExpiryDate == null) {
				sb.append(_FINDER_COLUMN_PENDINGQUOTS_VEHICLEESTEXPIRYDATE_1);
			}
			else {
				bindVehicleEstExpiryDate = true;

				sb.append(_FINDER_COLUMN_PENDINGQUOTS_VEHICLEESTEXPIRYDATE_2);
			}

			boolean bindQuoteStatus = false;

			if (quoteStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_PENDINGQUOTS_QUOTESTATUS_3);
			}
			else {
				bindQuoteStatus = true;

				sb.append(_FINDER_COLUMN_PENDINGQUOTS_QUOTESTATUS_2);
			}

			sb.append(_FINDER_COLUMN_PENDINGQUOTS_SMSFLAG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindVehicleEstExpiryDate) {
					queryPos.add(new Timestamp(vehicleEstExpiryDate.getTime()));
				}

				if (bindQuoteStatus) {
					queryPos.add(quoteStatus);
				}

				queryPos.add(smsFlag);

				list = (List<Quotations>)QueryUtil.list(
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
	 * Returns the first quotations in the ordered set where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	@Override
	public Quotations findByPendingQuots_First(
			Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
			OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		Quotations quotations = fetchByPendingQuots_First(
			vehicleEstExpiryDate, quoteStatus, smsFlag, orderByComparator);

		if (quotations != null) {
			return quotations;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("vehicleEstExpiryDate>");
		sb.append(vehicleEstExpiryDate);

		sb.append(", quoteStatus=");
		sb.append(quoteStatus);

		sb.append(", smsFlag=");
		sb.append(smsFlag);

		sb.append("}");

		throw new NoSuchQuotationsException(sb.toString());
	}

	/**
	 * Returns the first quotations in the ordered set where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	@Override
	public Quotations fetchByPendingQuots_First(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
		OrderByComparator<Quotations> orderByComparator) {

		List<Quotations> list = findByPendingQuots(
			vehicleEstExpiryDate, quoteStatus, smsFlag, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last quotations in the ordered set where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	@Override
	public Quotations findByPendingQuots_Last(
			Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
			OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		Quotations quotations = fetchByPendingQuots_Last(
			vehicleEstExpiryDate, quoteStatus, smsFlag, orderByComparator);

		if (quotations != null) {
			return quotations;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("vehicleEstExpiryDate>");
		sb.append(vehicleEstExpiryDate);

		sb.append(", quoteStatus=");
		sb.append(quoteStatus);

		sb.append(", smsFlag=");
		sb.append(smsFlag);

		sb.append("}");

		throw new NoSuchQuotationsException(sb.toString());
	}

	/**
	 * Returns the last quotations in the ordered set where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	@Override
	public Quotations fetchByPendingQuots_Last(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
		OrderByComparator<Quotations> orderByComparator) {

		int count = countByPendingQuots(
			vehicleEstExpiryDate, quoteStatus, smsFlag);

		if (count == 0) {
			return null;
		}

		List<Quotations> list = findByPendingQuots(
			vehicleEstExpiryDate, quoteStatus, smsFlag, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the quotationses before and after the current quotations in the ordered set where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * @param quotationId the primary key of the current quotations
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	@Override
	public Quotations[] findByPendingQuots_PrevAndNext(
			long quotationId, Date vehicleEstExpiryDate, String quoteStatus,
			boolean smsFlag, OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		quoteStatus = Objects.toString(quoteStatus, "");

		Quotations quotations = findByPrimaryKey(quotationId);

		Session session = null;

		try {
			session = openSession();

			Quotations[] array = new QuotationsImpl[3];

			array[0] = getByPendingQuots_PrevAndNext(
				session, quotations, vehicleEstExpiryDate, quoteStatus, smsFlag,
				orderByComparator, true);

			array[1] = quotations;

			array[2] = getByPendingQuots_PrevAndNext(
				session, quotations, vehicleEstExpiryDate, quoteStatus, smsFlag,
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

	protected Quotations getByPendingQuots_PrevAndNext(
		Session session, Quotations quotations, Date vehicleEstExpiryDate,
		String quoteStatus, boolean smsFlag,
		OrderByComparator<Quotations> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

		boolean bindVehicleEstExpiryDate = false;

		if (vehicleEstExpiryDate == null) {
			sb.append(_FINDER_COLUMN_PENDINGQUOTS_VEHICLEESTEXPIRYDATE_1);
		}
		else {
			bindVehicleEstExpiryDate = true;

			sb.append(_FINDER_COLUMN_PENDINGQUOTS_VEHICLEESTEXPIRYDATE_2);
		}

		boolean bindQuoteStatus = false;

		if (quoteStatus.isEmpty()) {
			sb.append(_FINDER_COLUMN_PENDINGQUOTS_QUOTESTATUS_3);
		}
		else {
			bindQuoteStatus = true;

			sb.append(_FINDER_COLUMN_PENDINGQUOTS_QUOTESTATUS_2);
		}

		sb.append(_FINDER_COLUMN_PENDINGQUOTS_SMSFLAG_2);

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
			sb.append(QuotationsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindVehicleEstExpiryDate) {
			queryPos.add(new Timestamp(vehicleEstExpiryDate.getTime()));
		}

		if (bindQuoteStatus) {
			queryPos.add(quoteStatus);
		}

		queryPos.add(smsFlag);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(quotations)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Quotations> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the quotationses where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63; from the database.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 */
	@Override
	public void removeByPendingQuots(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag) {

		for (Quotations quotations :
				findByPendingQuots(
					vehicleEstExpiryDate, quoteStatus, smsFlag,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(quotations);
		}
	}

	/**
	 * Returns the number of quotationses where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @return the number of matching quotationses
	 */
	@Override
	public int countByPendingQuots(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag) {

		quoteStatus = Objects.toString(quoteStatus, "");

		FinderPath finderPath = _finderPathWithPaginationCountByPendingQuots;

		Object[] finderArgs = new Object[] {
			_getTime(vehicleEstExpiryDate), quoteStatus, smsFlag
		};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_QUOTATIONS_WHERE);

			boolean bindVehicleEstExpiryDate = false;

			if (vehicleEstExpiryDate == null) {
				sb.append(_FINDER_COLUMN_PENDINGQUOTS_VEHICLEESTEXPIRYDATE_1);
			}
			else {
				bindVehicleEstExpiryDate = true;

				sb.append(_FINDER_COLUMN_PENDINGQUOTS_VEHICLEESTEXPIRYDATE_2);
			}

			boolean bindQuoteStatus = false;

			if (quoteStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_PENDINGQUOTS_QUOTESTATUS_3);
			}
			else {
				bindQuoteStatus = true;

				sb.append(_FINDER_COLUMN_PENDINGQUOTS_QUOTESTATUS_2);
			}

			sb.append(_FINDER_COLUMN_PENDINGQUOTS_SMSFLAG_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindVehicleEstExpiryDate) {
					queryPos.add(new Timestamp(vehicleEstExpiryDate.getTime()));
				}

				if (bindQuoteStatus) {
					queryPos.add(quoteStatus);
				}

				queryPos.add(smsFlag);

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
		_FINDER_COLUMN_PENDINGQUOTS_VEHICLEESTEXPIRYDATE_1 =
			"quotations.vehicleEstExpiryDate IS NULL AND ";

	private static final String
		_FINDER_COLUMN_PENDINGQUOTS_VEHICLEESTEXPIRYDATE_2 =
			"quotations.vehicleEstExpiryDate > ? AND ";

	private static final String _FINDER_COLUMN_PENDINGQUOTS_QUOTESTATUS_2 =
		"quotations.quoteStatus = ? AND ";

	private static final String _FINDER_COLUMN_PENDINGQUOTS_QUOTESTATUS_3 =
		"(quotations.quoteStatus IS NULL OR quotations.quoteStatus = '') AND ";

	private static final String _FINDER_COLUMN_PENDINGQUOTS_SMSFLAG_2 =
		"quotations.smsFlag = ?";

	private FinderPath _finderPathWithPaginationFindByQuotsStatus;
	private FinderPath _finderPathWithoutPaginationFindByQuotsStatus;
	private FinderPath _finderPathCountByQuotsStatus;
	private FinderPath _finderPathWithPaginationCountByQuotsStatus;

	/**
	 * Returns all the quotationses where quoteStatus = &#63;.
	 *
	 * @param quoteStatus the quote status
	 * @return the matching quotationses
	 */
	@Override
	public List<Quotations> findByQuotsStatus(String quoteStatus) {
		return findByQuotsStatus(
			quoteStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotationses where quoteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	@Override
	public List<Quotations> findByQuotsStatus(
		String quoteStatus, int start, int end) {

		return findByQuotsStatus(quoteStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotationses where quoteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByQuotsStatus(
		String quoteStatus, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return findByQuotsStatus(
			quoteStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotationses where quoteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByQuotsStatus(
		String quoteStatus, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		quoteStatus = Objects.toString(quoteStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByQuotsStatus;
				finderArgs = new Object[] {quoteStatus};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByQuotsStatus;
			finderArgs = new Object[] {
				quoteStatus, start, end, orderByComparator
			};
		}

		List<Quotations> list = null;

		if (useFinderCache) {
			list = (List<Quotations>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Quotations quotations : list) {
					if (!quoteStatus.equals(quotations.getQuoteStatus())) {
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

			sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

			boolean bindQuoteStatus = false;

			if (quoteStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_QUOTSSTATUS_QUOTESTATUS_3);
			}
			else {
				bindQuoteStatus = true;

				sb.append(_FINDER_COLUMN_QUOTSSTATUS_QUOTESTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindQuoteStatus) {
					queryPos.add(quoteStatus);
				}

				list = (List<Quotations>)QueryUtil.list(
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
	 * Returns the first quotations in the ordered set where quoteStatus = &#63;.
	 *
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	@Override
	public Quotations findByQuotsStatus_First(
			String quoteStatus, OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		Quotations quotations = fetchByQuotsStatus_First(
			quoteStatus, orderByComparator);

		if (quotations != null) {
			return quotations;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quoteStatus=");
		sb.append(quoteStatus);

		sb.append("}");

		throw new NoSuchQuotationsException(sb.toString());
	}

	/**
	 * Returns the first quotations in the ordered set where quoteStatus = &#63;.
	 *
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	@Override
	public Quotations fetchByQuotsStatus_First(
		String quoteStatus, OrderByComparator<Quotations> orderByComparator) {

		List<Quotations> list = findByQuotsStatus(
			quoteStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last quotations in the ordered set where quoteStatus = &#63;.
	 *
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	@Override
	public Quotations findByQuotsStatus_Last(
			String quoteStatus, OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		Quotations quotations = fetchByQuotsStatus_Last(
			quoteStatus, orderByComparator);

		if (quotations != null) {
			return quotations;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quoteStatus=");
		sb.append(quoteStatus);

		sb.append("}");

		throw new NoSuchQuotationsException(sb.toString());
	}

	/**
	 * Returns the last quotations in the ordered set where quoteStatus = &#63;.
	 *
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	@Override
	public Quotations fetchByQuotsStatus_Last(
		String quoteStatus, OrderByComparator<Quotations> orderByComparator) {

		int count = countByQuotsStatus(quoteStatus);

		if (count == 0) {
			return null;
		}

		List<Quotations> list = findByQuotsStatus(
			quoteStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the quotationses before and after the current quotations in the ordered set where quoteStatus = &#63;.
	 *
	 * @param quotationId the primary key of the current quotations
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	@Override
	public Quotations[] findByQuotsStatus_PrevAndNext(
			long quotationId, String quoteStatus,
			OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		quoteStatus = Objects.toString(quoteStatus, "");

		Quotations quotations = findByPrimaryKey(quotationId);

		Session session = null;

		try {
			session = openSession();

			Quotations[] array = new QuotationsImpl[3];

			array[0] = getByQuotsStatus_PrevAndNext(
				session, quotations, quoteStatus, orderByComparator, true);

			array[1] = quotations;

			array[2] = getByQuotsStatus_PrevAndNext(
				session, quotations, quoteStatus, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Quotations getByQuotsStatus_PrevAndNext(
		Session session, Quotations quotations, String quoteStatus,
		OrderByComparator<Quotations> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

		boolean bindQuoteStatus = false;

		if (quoteStatus.isEmpty()) {
			sb.append(_FINDER_COLUMN_QUOTSSTATUS_QUOTESTATUS_3);
		}
		else {
			bindQuoteStatus = true;

			sb.append(_FINDER_COLUMN_QUOTSSTATUS_QUOTESTATUS_2);
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
			sb.append(QuotationsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindQuoteStatus) {
			queryPos.add(quoteStatus);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(quotations)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Quotations> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the quotationses where quoteStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quoteStatuses the quote statuses
	 * @return the matching quotationses
	 */
	@Override
	public List<Quotations> findByQuotsStatus(String[] quoteStatuses) {
		return findByQuotsStatus(
			quoteStatuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotationses where quoteStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quoteStatuses the quote statuses
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	@Override
	public List<Quotations> findByQuotsStatus(
		String[] quoteStatuses, int start, int end) {

		return findByQuotsStatus(quoteStatuses, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotationses where quoteStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quoteStatuses the quote statuses
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByQuotsStatus(
		String[] quoteStatuses, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return findByQuotsStatus(
			quoteStatuses, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotationses where quoteStatus = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByQuotsStatus(
		String[] quoteStatuses, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		if (quoteStatuses == null) {
			quoteStatuses = new String[0];
		}
		else if (quoteStatuses.length > 1) {
			for (int i = 0; i < quoteStatuses.length; i++) {
				quoteStatuses[i] = Objects.toString(quoteStatuses[i], "");
			}

			quoteStatuses = ArrayUtil.sortedUnique(quoteStatuses);
		}

		if (quoteStatuses.length == 1) {
			return findByQuotsStatus(
				quoteStatuses[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {StringUtil.merge(quoteStatuses)};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				StringUtil.merge(quoteStatuses), start, end, orderByComparator
			};
		}

		List<Quotations> list = null;

		if (useFinderCache) {
			list = (List<Quotations>)dummyFinderCache.getResult(
				_finderPathWithPaginationFindByQuotsStatus, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Quotations quotations : list) {
					if (!ArrayUtil.contains(
							quoteStatuses, quotations.getQuoteStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

			if (quoteStatuses.length > 0) {
				sb.append("(");

				for (int i = 0; i < quoteStatuses.length; i++) {
					String quoteStatus = quoteStatuses[i];

					if (quoteStatus.isEmpty()) {
						sb.append(_FINDER_COLUMN_QUOTSSTATUS_QUOTESTATUS_3);
					}
					else {
						sb.append(_FINDER_COLUMN_QUOTSSTATUS_QUOTESTATUS_2);
					}

					if ((i + 1) < quoteStatuses.length) {
						sb.append(WHERE_OR);
					}
				}

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				for (String quoteStatus : quoteStatuses) {
					if ((quoteStatus != null) && !quoteStatus.isEmpty()) {
						queryPos.add(quoteStatus);
					}
				}

				list = (List<Quotations>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(
						_finderPathWithPaginationFindByQuotsStatus, finderArgs,
						list);
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
	 * Removes all the quotationses where quoteStatus = &#63; from the database.
	 *
	 * @param quoteStatus the quote status
	 */
	@Override
	public void removeByQuotsStatus(String quoteStatus) {
		for (Quotations quotations :
				findByQuotsStatus(
					quoteStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(quotations);
		}
	}

	/**
	 * Returns the number of quotationses where quoteStatus = &#63;.
	 *
	 * @param quoteStatus the quote status
	 * @return the number of matching quotationses
	 */
	@Override
	public int countByQuotsStatus(String quoteStatus) {
		quoteStatus = Objects.toString(quoteStatus, "");

		FinderPath finderPath = _finderPathCountByQuotsStatus;

		Object[] finderArgs = new Object[] {quoteStatus};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUOTATIONS_WHERE);

			boolean bindQuoteStatus = false;

			if (quoteStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_QUOTSSTATUS_QUOTESTATUS_3);
			}
			else {
				bindQuoteStatus = true;

				sb.append(_FINDER_COLUMN_QUOTSSTATUS_QUOTESTATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindQuoteStatus) {
					queryPos.add(quoteStatus);
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

	/**
	 * Returns the number of quotationses where quoteStatus = any &#63;.
	 *
	 * @param quoteStatuses the quote statuses
	 * @return the number of matching quotationses
	 */
	@Override
	public int countByQuotsStatus(String[] quoteStatuses) {
		if (quoteStatuses == null) {
			quoteStatuses = new String[0];
		}
		else if (quoteStatuses.length > 1) {
			for (int i = 0; i < quoteStatuses.length; i++) {
				quoteStatuses[i] = Objects.toString(quoteStatuses[i], "");
			}

			quoteStatuses = ArrayUtil.sortedUnique(quoteStatuses);
		}

		Object[] finderArgs = new Object[] {StringUtil.merge(quoteStatuses)};

		Long count = (Long)dummyFinderCache.getResult(
			_finderPathWithPaginationCountByQuotsStatus, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_QUOTATIONS_WHERE);

			if (quoteStatuses.length > 0) {
				sb.append("(");

				for (int i = 0; i < quoteStatuses.length; i++) {
					String quoteStatus = quoteStatuses[i];

					if (quoteStatus.isEmpty()) {
						sb.append(_FINDER_COLUMN_QUOTSSTATUS_QUOTESTATUS_3);
					}
					else {
						sb.append(_FINDER_COLUMN_QUOTSSTATUS_QUOTESTATUS_2);
					}

					if ((i + 1) < quoteStatuses.length) {
						sb.append(WHERE_OR);
					}
				}

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				for (String quoteStatus : quoteStatuses) {
					if ((quoteStatus != null) && !quoteStatus.isEmpty()) {
						queryPos.add(quoteStatus);
					}
				}

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(
					_finderPathWithPaginationCountByQuotsStatus, finderArgs,
					count);
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

	private static final String _FINDER_COLUMN_QUOTSSTATUS_QUOTESTATUS_2 =
		"quotations.quoteStatus = ?";

	private static final String _FINDER_COLUMN_QUOTSSTATUS_QUOTESTATUS_3 =
		"(quotations.quoteStatus IS NULL OR quotations.quoteStatus = '')";

	private FinderPath _finderPathWithPaginationFindByReferenceNo;
	private FinderPath _finderPathWithoutPaginationFindByReferenceNo;
	private FinderPath _finderPathCountByReferenceNo;
	private FinderPath _finderPathWithPaginationCountByReferenceNo;

	/**
	 * Returns all the quotationses where referenceNo = &#63;.
	 *
	 * @param referenceNo the reference no
	 * @return the matching quotationses
	 */
	@Override
	public List<Quotations> findByReferenceNo(String referenceNo) {
		return findByReferenceNo(
			referenceNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotationses where referenceNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param referenceNo the reference no
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	@Override
	public List<Quotations> findByReferenceNo(
		String referenceNo, int start, int end) {

		return findByReferenceNo(referenceNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotationses where referenceNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param referenceNo the reference no
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByReferenceNo(
		String referenceNo, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return findByReferenceNo(
			referenceNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotationses where referenceNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param referenceNo the reference no
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByReferenceNo(
		String referenceNo, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		referenceNo = Objects.toString(referenceNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByReferenceNo;
				finderArgs = new Object[] {referenceNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByReferenceNo;
			finderArgs = new Object[] {
				referenceNo, start, end, orderByComparator
			};
		}

		List<Quotations> list = null;

		if (useFinderCache) {
			list = (List<Quotations>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Quotations quotations : list) {
					if (!referenceNo.equals(quotations.getReferenceNo())) {
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

			sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

			boolean bindReferenceNo = false;

			if (referenceNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_REFERENCENO_REFERENCENO_3);
			}
			else {
				bindReferenceNo = true;

				sb.append(_FINDER_COLUMN_REFERENCENO_REFERENCENO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindReferenceNo) {
					queryPos.add(referenceNo);
				}

				list = (List<Quotations>)QueryUtil.list(
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
	 * Returns the first quotations in the ordered set where referenceNo = &#63;.
	 *
	 * @param referenceNo the reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	@Override
	public Quotations findByReferenceNo_First(
			String referenceNo, OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		Quotations quotations = fetchByReferenceNo_First(
			referenceNo, orderByComparator);

		if (quotations != null) {
			return quotations;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("referenceNo=");
		sb.append(referenceNo);

		sb.append("}");

		throw new NoSuchQuotationsException(sb.toString());
	}

	/**
	 * Returns the first quotations in the ordered set where referenceNo = &#63;.
	 *
	 * @param referenceNo the reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	@Override
	public Quotations fetchByReferenceNo_First(
		String referenceNo, OrderByComparator<Quotations> orderByComparator) {

		List<Quotations> list = findByReferenceNo(
			referenceNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last quotations in the ordered set where referenceNo = &#63;.
	 *
	 * @param referenceNo the reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	@Override
	public Quotations findByReferenceNo_Last(
			String referenceNo, OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		Quotations quotations = fetchByReferenceNo_Last(
			referenceNo, orderByComparator);

		if (quotations != null) {
			return quotations;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("referenceNo=");
		sb.append(referenceNo);

		sb.append("}");

		throw new NoSuchQuotationsException(sb.toString());
	}

	/**
	 * Returns the last quotations in the ordered set where referenceNo = &#63;.
	 *
	 * @param referenceNo the reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	@Override
	public Quotations fetchByReferenceNo_Last(
		String referenceNo, OrderByComparator<Quotations> orderByComparator) {

		int count = countByReferenceNo(referenceNo);

		if (count == 0) {
			return null;
		}

		List<Quotations> list = findByReferenceNo(
			referenceNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the quotationses before and after the current quotations in the ordered set where referenceNo = &#63;.
	 *
	 * @param quotationId the primary key of the current quotations
	 * @param referenceNo the reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	@Override
	public Quotations[] findByReferenceNo_PrevAndNext(
			long quotationId, String referenceNo,
			OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		referenceNo = Objects.toString(referenceNo, "");

		Quotations quotations = findByPrimaryKey(quotationId);

		Session session = null;

		try {
			session = openSession();

			Quotations[] array = new QuotationsImpl[3];

			array[0] = getByReferenceNo_PrevAndNext(
				session, quotations, referenceNo, orderByComparator, true);

			array[1] = quotations;

			array[2] = getByReferenceNo_PrevAndNext(
				session, quotations, referenceNo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Quotations getByReferenceNo_PrevAndNext(
		Session session, Quotations quotations, String referenceNo,
		OrderByComparator<Quotations> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

		boolean bindReferenceNo = false;

		if (referenceNo.isEmpty()) {
			sb.append(_FINDER_COLUMN_REFERENCENO_REFERENCENO_3);
		}
		else {
			bindReferenceNo = true;

			sb.append(_FINDER_COLUMN_REFERENCENO_REFERENCENO_2);
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
			sb.append(QuotationsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindReferenceNo) {
			queryPos.add(referenceNo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(quotations)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Quotations> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the quotationses where referenceNo = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param referenceNos the reference nos
	 * @return the matching quotationses
	 */
	@Override
	public List<Quotations> findByReferenceNo(String[] referenceNos) {
		return findByReferenceNo(
			referenceNos, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotationses where referenceNo = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param referenceNos the reference nos
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	@Override
	public List<Quotations> findByReferenceNo(
		String[] referenceNos, int start, int end) {

		return findByReferenceNo(referenceNos, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotationses where referenceNo = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param referenceNos the reference nos
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByReferenceNo(
		String[] referenceNos, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return findByReferenceNo(
			referenceNos, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotationses where referenceNo = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param referenceNo the reference no
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByReferenceNo(
		String[] referenceNos, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		if (referenceNos == null) {
			referenceNos = new String[0];
		}
		else if (referenceNos.length > 1) {
			for (int i = 0; i < referenceNos.length; i++) {
				referenceNos[i] = Objects.toString(referenceNos[i], "");
			}

			referenceNos = ArrayUtil.sortedUnique(referenceNos);
		}

		if (referenceNos.length == 1) {
			return findByReferenceNo(
				referenceNos[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {StringUtil.merge(referenceNos)};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				StringUtil.merge(referenceNos), start, end, orderByComparator
			};
		}

		List<Quotations> list = null;

		if (useFinderCache) {
			list = (List<Quotations>)dummyFinderCache.getResult(
				_finderPathWithPaginationFindByReferenceNo, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Quotations quotations : list) {
					if (!ArrayUtil.contains(
							referenceNos, quotations.getReferenceNo())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

			if (referenceNos.length > 0) {
				sb.append("(");

				for (int i = 0; i < referenceNos.length; i++) {
					String referenceNo = referenceNos[i];

					if (referenceNo.isEmpty()) {
						sb.append(_FINDER_COLUMN_REFERENCENO_REFERENCENO_3);
					}
					else {
						sb.append(_FINDER_COLUMN_REFERENCENO_REFERENCENO_2);
					}

					if ((i + 1) < referenceNos.length) {
						sb.append(WHERE_OR);
					}
				}

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				for (String referenceNo : referenceNos) {
					if ((referenceNo != null) && !referenceNo.isEmpty()) {
						queryPos.add(referenceNo);
					}
				}

				list = (List<Quotations>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(
						_finderPathWithPaginationFindByReferenceNo, finderArgs,
						list);
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
	 * Removes all the quotationses where referenceNo = &#63; from the database.
	 *
	 * @param referenceNo the reference no
	 */
	@Override
	public void removeByReferenceNo(String referenceNo) {
		for (Quotations quotations :
				findByReferenceNo(
					referenceNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(quotations);
		}
	}

	/**
	 * Returns the number of quotationses where referenceNo = &#63;.
	 *
	 * @param referenceNo the reference no
	 * @return the number of matching quotationses
	 */
	@Override
	public int countByReferenceNo(String referenceNo) {
		referenceNo = Objects.toString(referenceNo, "");

		FinderPath finderPath = _finderPathCountByReferenceNo;

		Object[] finderArgs = new Object[] {referenceNo};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUOTATIONS_WHERE);

			boolean bindReferenceNo = false;

			if (referenceNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_REFERENCENO_REFERENCENO_3);
			}
			else {
				bindReferenceNo = true;

				sb.append(_FINDER_COLUMN_REFERENCENO_REFERENCENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindReferenceNo) {
					queryPos.add(referenceNo);
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

	/**
	 * Returns the number of quotationses where referenceNo = any &#63;.
	 *
	 * @param referenceNos the reference nos
	 * @return the number of matching quotationses
	 */
	@Override
	public int countByReferenceNo(String[] referenceNos) {
		if (referenceNos == null) {
			referenceNos = new String[0];
		}
		else if (referenceNos.length > 1) {
			for (int i = 0; i < referenceNos.length; i++) {
				referenceNos[i] = Objects.toString(referenceNos[i], "");
			}

			referenceNos = ArrayUtil.sortedUnique(referenceNos);
		}

		Object[] finderArgs = new Object[] {StringUtil.merge(referenceNos)};

		Long count = (Long)dummyFinderCache.getResult(
			_finderPathWithPaginationCountByReferenceNo, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_QUOTATIONS_WHERE);

			if (referenceNos.length > 0) {
				sb.append("(");

				for (int i = 0; i < referenceNos.length; i++) {
					String referenceNo = referenceNos[i];

					if (referenceNo.isEmpty()) {
						sb.append(_FINDER_COLUMN_REFERENCENO_REFERENCENO_3);
					}
					else {
						sb.append(_FINDER_COLUMN_REFERENCENO_REFERENCENO_2);
					}

					if ((i + 1) < referenceNos.length) {
						sb.append(WHERE_OR);
					}
				}

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				for (String referenceNo : referenceNos) {
					if ((referenceNo != null) && !referenceNo.isEmpty()) {
						queryPos.add(referenceNo);
					}
				}

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(
					_finderPathWithPaginationCountByReferenceNo, finderArgs,
					count);
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

	private static final String _FINDER_COLUMN_REFERENCENO_REFERENCENO_2 =
		"quotations.referenceNo = ?";

	private static final String _FINDER_COLUMN_REFERENCENO_REFERENCENO_3 =
		"(quotations.referenceNo IS NULL OR quotations.referenceNo = '')";

	private FinderPath _finderPathFetchByPolicyNo;
	private FinderPath _finderPathCountByPolicyNo;

	/**
	 * Returns the quotations where policyNo = &#63; or throws a <code>NoSuchQuotationsException</code> if it could not be found.
	 *
	 * @param policyNo the policy no
	 * @return the matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	@Override
	public Quotations findByPolicyNo(String policyNo)
		throws NoSuchQuotationsException {

		Quotations quotations = fetchByPolicyNo(policyNo);

		if (quotations == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("policyNo=");
			sb.append(policyNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchQuotationsException(sb.toString());
		}

		return quotations;
	}

	/**
	 * Returns the quotations where policyNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyNo the policy no
	 * @return the matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	@Override
	public Quotations fetchByPolicyNo(String policyNo) {
		return fetchByPolicyNo(policyNo, true);
	}

	/**
	 * Returns the quotations where policyNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyNo the policy no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	@Override
	public Quotations fetchByPolicyNo(String policyNo, boolean useFinderCache) {
		policyNo = Objects.toString(policyNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {policyNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByPolicyNo, finderArgs, this);
		}

		if (result instanceof Quotations) {
			Quotations quotations = (Quotations)result;

			if (!Objects.equals(policyNo, quotations.getPolicyNo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

			boolean bindPolicyNo = false;

			if (policyNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYNO_POLICYNO_3);
			}
			else {
				bindPolicyNo = true;

				sb.append(_FINDER_COLUMN_POLICYNO_POLICYNO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPolicyNo) {
					queryPos.add(policyNo);
				}

				List<Quotations> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByPolicyNo, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {policyNo};
							}

							_log.warn(
								"QuotationsPersistenceImpl.fetchByPolicyNo(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Quotations quotations = list.get(0);

					result = quotations;

					cacheResult(quotations);
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
			return (Quotations)result;
		}
	}

	/**
	 * Removes the quotations where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 * @return the quotations that was removed
	 */
	@Override
	public Quotations removeByPolicyNo(String policyNo)
		throws NoSuchQuotationsException {

		Quotations quotations = findByPolicyNo(policyNo);

		return remove(quotations);
	}

	/**
	 * Returns the number of quotationses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching quotationses
	 */
	@Override
	public int countByPolicyNo(String policyNo) {
		policyNo = Objects.toString(policyNo, "");

		FinderPath finderPath = _finderPathCountByPolicyNo;

		Object[] finderArgs = new Object[] {policyNo};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUOTATIONS_WHERE);

			boolean bindPolicyNo = false;

			if (policyNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYNO_POLICYNO_3);
			}
			else {
				bindPolicyNo = true;

				sb.append(_FINDER_COLUMN_POLICYNO_POLICYNO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPolicyNo) {
					queryPos.add(policyNo);
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

	private static final String _FINDER_COLUMN_POLICYNO_POLICYNO_2 =
		"quotations.policyNo = ?";

	private static final String _FINDER_COLUMN_POLICYNO_POLICYNO_3 =
		"(quotations.policyNo IS NULL OR quotations.policyNo = '')";

	private FinderPath _finderPathWithPaginationFindByinsuredMobile;
	private FinderPath _finderPathWithoutPaginationFindByinsuredMobile;
	private FinderPath _finderPathCountByinsuredMobile;

	/**
	 * Returns all the quotationses where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @return the matching quotationses
	 */
	@Override
	public List<Quotations> findByinsuredMobile(long insuredMobile) {
		return findByinsuredMobile(
			insuredMobile, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotationses where insuredMobile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredMobile the insured mobile
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	@Override
	public List<Quotations> findByinsuredMobile(
		long insuredMobile, int start, int end) {

		return findByinsuredMobile(insuredMobile, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotationses where insuredMobile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredMobile the insured mobile
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByinsuredMobile(
		long insuredMobile, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return findByinsuredMobile(
			insuredMobile, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotationses where insuredMobile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredMobile the insured mobile
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	@Override
	public List<Quotations> findByinsuredMobile(
		long insuredMobile, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByinsuredMobile;
				finderArgs = new Object[] {insuredMobile};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByinsuredMobile;
			finderArgs = new Object[] {
				insuredMobile, start, end, orderByComparator
			};
		}

		List<Quotations> list = null;

		if (useFinderCache) {
			list = (List<Quotations>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Quotations quotations : list) {
					if (insuredMobile != quotations.getInsuredMobile()) {
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

			sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

			sb.append(_FINDER_COLUMN_INSUREDMOBILE_INSUREDMOBILE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(insuredMobile);

				list = (List<Quotations>)QueryUtil.list(
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
	 * Returns the first quotations in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	@Override
	public Quotations findByinsuredMobile_First(
			long insuredMobile, OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		Quotations quotations = fetchByinsuredMobile_First(
			insuredMobile, orderByComparator);

		if (quotations != null) {
			return quotations;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("insuredMobile=");
		sb.append(insuredMobile);

		sb.append("}");

		throw new NoSuchQuotationsException(sb.toString());
	}

	/**
	 * Returns the first quotations in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	@Override
	public Quotations fetchByinsuredMobile_First(
		long insuredMobile, OrderByComparator<Quotations> orderByComparator) {

		List<Quotations> list = findByinsuredMobile(
			insuredMobile, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last quotations in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	@Override
	public Quotations findByinsuredMobile_Last(
			long insuredMobile, OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		Quotations quotations = fetchByinsuredMobile_Last(
			insuredMobile, orderByComparator);

		if (quotations != null) {
			return quotations;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("insuredMobile=");
		sb.append(insuredMobile);

		sb.append("}");

		throw new NoSuchQuotationsException(sb.toString());
	}

	/**
	 * Returns the last quotations in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	@Override
	public Quotations fetchByinsuredMobile_Last(
		long insuredMobile, OrderByComparator<Quotations> orderByComparator) {

		int count = countByinsuredMobile(insuredMobile);

		if (count == 0) {
			return null;
		}

		List<Quotations> list = findByinsuredMobile(
			insuredMobile, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the quotationses before and after the current quotations in the ordered set where insuredMobile = &#63;.
	 *
	 * @param quotationId the primary key of the current quotations
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	@Override
	public Quotations[] findByinsuredMobile_PrevAndNext(
			long quotationId, long insuredMobile,
			OrderByComparator<Quotations> orderByComparator)
		throws NoSuchQuotationsException {

		Quotations quotations = findByPrimaryKey(quotationId);

		Session session = null;

		try {
			session = openSession();

			Quotations[] array = new QuotationsImpl[3];

			array[0] = getByinsuredMobile_PrevAndNext(
				session, quotations, insuredMobile, orderByComparator, true);

			array[1] = quotations;

			array[2] = getByinsuredMobile_PrevAndNext(
				session, quotations, insuredMobile, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Quotations getByinsuredMobile_PrevAndNext(
		Session session, Quotations quotations, long insuredMobile,
		OrderByComparator<Quotations> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_QUOTATIONS_WHERE);

		sb.append(_FINDER_COLUMN_INSUREDMOBILE_INSUREDMOBILE_2);

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
			sb.append(QuotationsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(insuredMobile);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(quotations)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Quotations> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the quotationses where insuredMobile = &#63; from the database.
	 *
	 * @param insuredMobile the insured mobile
	 */
	@Override
	public void removeByinsuredMobile(long insuredMobile) {
		for (Quotations quotations :
				findByinsuredMobile(
					insuredMobile, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(quotations);
		}
	}

	/**
	 * Returns the number of quotationses where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @return the number of matching quotationses
	 */
	@Override
	public int countByinsuredMobile(long insuredMobile) {
		FinderPath finderPath = _finderPathCountByinsuredMobile;

		Object[] finderArgs = new Object[] {insuredMobile};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUOTATIONS_WHERE);

			sb.append(_FINDER_COLUMN_INSUREDMOBILE_INSUREDMOBILE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(insuredMobile);

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

	private static final String _FINDER_COLUMN_INSUREDMOBILE_INSUREDMOBILE_2 =
		"quotations.insuredMobile = ?";

	public QuotationsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("addressAddNo", "ADDRESS_ADD_NUMBER");
		dbColumnNames.put("addressBuildingNo", "ADDRESS_BLDG_NO");
		dbColumnNames.put("addressDistrict", "ADDRESS_DISTRICT");
		dbColumnNames.put("addressStreet", "ADDRESS_STREET");
		dbColumnNames.put("addressUnitNo", "ADDRESS_UNIT_NO");
		dbColumnNames.put("addressZipCode", "ADDRESS_ZIPCODE");
		dbColumnNames.put("addCover", "ADD_COVER");
		dbColumnNames.put("addDriver", "ADD_DRIVER");
		dbColumnNames.put("agencyRepair", "AGENCY_REPAIR");
		dbColumnNames.put("city", "CITY");
		dbColumnNames.put("deductibleValue", "DEDUCTIBLE_VALUE");
		dbColumnNames.put("insuredDob", "INSURED_DOB");
		dbColumnNames.put("insuredEmail", "INSURED_EMAIL");
		dbColumnNames.put("insuredGender", "INSURED_GENDER");
		dbColumnNames.put("insuredId", "INSURED_ID");
		dbColumnNames.put("insuredIdType", "INSURED_ID_TYPE");
		dbColumnNames.put("insuredMobile", "INSURED_MOBILE");
		dbColumnNames.put("insuredName", "INSURED_NAME");
		dbColumnNames.put("insuredNationality", "INSURED_NATIONALITY");
		dbColumnNames.put("insuredEducation", "INSURED_EDUCATION");
		dbColumnNames.put("insuredMaritalStatus", "INSURED_MARITAL_STATUS");
		dbColumnNames.put("insuredNoChildUnder16", "INSURED_NO_CHILD_UNDER_16");
		dbColumnNames.put("loyaltyDiscount", "LOYALTY_DISCOUNT");
		dbColumnNames.put("ncdYears", "NCD_YEARS");
		dbColumnNames.put("paymemtAmount", "PAYMENT_AMOUNT");
		dbColumnNames.put("paymentMethod", "PAYMENT_METHOD");
		dbColumnNames.put("paymentRefNo", "PAYMENT_REF_NO");
		dbColumnNames.put("policyEffFromNo", "POLICY_EFFECTIVE_FROM_NO");
		dbColumnNames.put("policyEffTo", "POLICY_EFFECTIVE_TO");
		dbColumnNames.put("policyEffDate", "POLICY_EFF_DATE");
		dbColumnNames.put("policyIssueDate", "POLICY_ISSUE_DATE");
		dbColumnNames.put("policyNo", "POLICY_NO");
		dbColumnNames.put("policyRefNo", "POLICY_REFERENCE_NO");
		dbColumnNames.put("policyStatusCode", "POLICY_STATUS_CODE");
		dbColumnNames.put("productCode", "PRODUCT_CODE");
		dbColumnNames.put("purposeOfVehicle", "PURPOSE_OF_VEHICLE");
		dbColumnNames.put("quotationId", "QUOTATIONS_ID");
		dbColumnNames.put("referenceNo", "REFERENCE_NO");
		dbColumnNames.put("source", "SOURCE");
		dbColumnNames.put("transaction", "TRANSACTION");
		dbColumnNames.put("vehicleBodyType", "VEHICLE_BODY_TYPE");
		dbColumnNames.put("vehicleCapacity", "VEHICLE_CAPACITY");
		dbColumnNames.put("vehicleChassisNo", "VEHICLE_CHASSIS_NO");
		dbColumnNames.put("vehicleColor", "VEHICLE_COLOR");
		dbColumnNames.put("vehicleCylinder", "VEHICLE_CYLINDER");
		dbColumnNames.put("vehicleEstExpiryDate", "VEHICLE_EST_EXP_DATE");
		dbColumnNames.put("vehicleId", "VEHICLE_ID");
		dbColumnNames.put("vehicleIdType", "VEHICLE_ID_TYPE");
		dbColumnNames.put("vehicleMake", "VEHICLE_MAKE");
		dbColumnNames.put("vehicleMfgYear", "VEHICLE_MFG_YEAR");
		dbColumnNames.put("vehicleModel", "VEHICLE_MODEL");
		dbColumnNames.put("vehiclePlateL1", "VEHICLE_PLATE_L1");
		dbColumnNames.put("vehiclePlateL2", "VEHICLE_PLATE_L2");
		dbColumnNames.put("vehiclePlateL3", "VEHICLE_PLATE_L3");
		dbColumnNames.put("vehiclePlateNo", "VEHICLE_PLATE_NO");
		dbColumnNames.put("vehiclePlateType", "VEHICLE_PLATE_TYPE");
		dbColumnNames.put("vehicleValue", "VEHICLE_VALUE");
		dbColumnNames.put("vehicleWeight", "VEHICLE_WEIGHT");
		dbColumnNames.put("vehicleCity", "VEHICLE_CITY");
		dbColumnNames.put("vehicleCurrentMileage", "VEHICLE_CURRENT_MILE");
		dbColumnNames.put(
			"vehicleLowerExpectedMileagePerYear", "VEHICLE_LOWER_MILE");
		dbColumnNames.put(
			"vehicleUpperExpectedMileagePerYear", "VEHICLE_UPPER_MILE");
		dbColumnNames.put("vehicleNightLocation", "VEHICLE_NIGHT_LOC");
		dbColumnNames.put("vehicleEngineSize", "VEHICLE_ENGINE_SIZE");
		dbColumnNames.put("vehicleTransType", "VEHICLE_TRANS_TYPE");
		dbColumnNames.put("vehAxleWeight", "VEHICLE_AXLE_WEIGHT");
		dbColumnNames.put("vehCarMods", "VEHICLE_CAR_MODS");
		dbColumnNames.put("vehSpecs", "VEHICLE_SPECS");
		dbColumnNames.put("occCode", "OCCUPATION_CODE");
		dbColumnNames.put("insuredIBAN", "INSURED_IBAN");
		dbColumnNames.put("insuredDobH", "INSURE_DOB_H");
		dbColumnNames.put("netPrem", "NET_PREMIUM");
		dbColumnNames.put("discountAmount", "NCD_DISCOUNT_AMOUNT");
		dbColumnNames.put("loyaltyDiscountAmount", "LOYALTY_DISCOUNT_AMOUNT");
		dbColumnNames.put("discountPrem", "NCD_DISCOUNT_PER");
		dbColumnNames.put("loyaltyDiscountPer", "LOYALTY_DISCOUNT_PER");
		dbColumnNames.put("loadingAmount", "LOADING_AMOUNT");
		dbColumnNames.put("policyTaxes", "POLICY_TAXES");
		dbColumnNames.put("policyFees", "POLICY_FEES");
		dbColumnNames.put("totalCoverPrem", "TOTAL_COVER_PREMIUM");
		dbColumnNames.put("grossPrem", "GROSS_PREMIUM");
		dbColumnNames.put("existingPolicyNo", "EXIST_POL_NO");
		dbColumnNames.put("existingCompanyName", "EXIST_COMP_NAME");
		dbColumnNames.put("existingExpDate", "EXIST_EXP_DATE");
		dbColumnNames.put("policyStatusMsg", "POLICY_STATUS_MESSAGE");
		dbColumnNames.put("yakeenRefNo", "YAKEEN_REFERENCE_NO");
		dbColumnNames.put("quoteSubmissionDate", "QUOTE_SUBMISSION_DATE");
		dbColumnNames.put("quoteStatus", "QUOTE_STATUS");
		dbColumnNames.put("saeedService", "SAEED_SERVICE");
		dbColumnNames.put("driverAccidents", "DRIVER_ACCIDENTS");
		dbColumnNames.put("driverAgeLess21", "DRIVER_AGE_LESS_21");
		dbColumnNames.put("agencyRepairOut", "AGENCY_REPAIR_OUT");
		dbColumnNames.put("totalAfterDiscount", "TOTAL_AFTER_DISCOUNT");
		dbColumnNames.put("totalBeforeDisc", "TOTAL_BEFORE_DISC");
		dbColumnNames.put("smsFlag", "SMS_FLAG");

		setDBColumnNames(dbColumnNames);

		setModelClass(Quotations.class);

		setModelImplClass(QuotationsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the quotations in the entity cache if it is enabled.
	 *
	 * @param quotations the quotations
	 */
	@Override
	public void cacheResult(Quotations quotations) {
		dummyEntityCache.putResult(
			QuotationsImpl.class, quotations.getPrimaryKey(), quotations);

		dummyFinderCache.putResult(
			_finderPathFetchByPolicyNo, new Object[] {quotations.getPolicyNo()},
			quotations);
	}

	/**
	 * Caches the quotationses in the entity cache if it is enabled.
	 *
	 * @param quotationses the quotationses
	 */
	@Override
	public void cacheResult(List<Quotations> quotationses) {
		for (Quotations quotations : quotationses) {
			if (dummyEntityCache.getResult(
					QuotationsImpl.class, quotations.getPrimaryKey()) == null) {

				cacheResult(quotations);
			}
		}
	}

	/**
	 * Clears the cache for all quotationses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(QuotationsImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the quotations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Quotations quotations) {
		dummyEntityCache.removeResult(QuotationsImpl.class, quotations);
	}

	@Override
	public void clearCache(List<Quotations> quotationses) {
		for (Quotations quotations : quotationses) {
			dummyEntityCache.removeResult(QuotationsImpl.class, quotations);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(QuotationsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		QuotationsModelImpl quotationsModelImpl) {

		Object[] args = new Object[] {quotationsModelImpl.getPolicyNo()};

		dummyFinderCache.putResult(
			_finderPathCountByPolicyNo, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchByPolicyNo, args, quotationsModelImpl, false);
	}

	/**
	 * Creates a new quotations with the primary key. Does not add the quotations to the database.
	 *
	 * @param quotationId the primary key for the new quotations
	 * @return the new quotations
	 */
	@Override
	public Quotations create(long quotationId) {
		Quotations quotations = new QuotationsImpl();

		quotations.setNew(true);
		quotations.setPrimaryKey(quotationId);

		return quotations;
	}

	/**
	 * Removes the quotations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quotationId the primary key of the quotations
	 * @return the quotations that was removed
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	@Override
	public Quotations remove(long quotationId)
		throws NoSuchQuotationsException {

		return remove((Serializable)quotationId);
	}

	/**
	 * Removes the quotations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the quotations
	 * @return the quotations that was removed
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	@Override
	public Quotations remove(Serializable primaryKey)
		throws NoSuchQuotationsException {

		Session session = null;

		try {
			session = openSession();

			Quotations quotations = (Quotations)session.get(
				QuotationsImpl.class, primaryKey);

			if (quotations == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuotationsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(quotations);
		}
		catch (NoSuchQuotationsException noSuchEntityException) {
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
	protected Quotations removeImpl(Quotations quotations) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(quotations)) {
				quotations = (Quotations)session.get(
					QuotationsImpl.class, quotations.getPrimaryKeyObj());
			}

			if (quotations != null) {
				session.delete(quotations);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (quotations != null) {
			clearCache(quotations);
		}

		return quotations;
	}

	@Override
	public Quotations updateImpl(Quotations quotations) {
		boolean isNew = quotations.isNew();

		if (!(quotations instanceof QuotationsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(quotations.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(quotations);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in quotations proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Quotations implementation " +
					quotations.getClass());
		}

		QuotationsModelImpl quotationsModelImpl =
			(QuotationsModelImpl)quotations;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(quotations);
			}
			else {
				quotations = (Quotations)session.merge(quotations);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			QuotationsImpl.class, quotationsModelImpl, false, true);

		cacheUniqueFindersCache(quotationsModelImpl);

		if (isNew) {
			quotations.setNew(false);
		}

		quotations.resetOriginalValues();

		return quotations;
	}

	/**
	 * Returns the quotations with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the quotations
	 * @return the quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	@Override
	public Quotations findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuotationsException {

		Quotations quotations = fetchByPrimaryKey(primaryKey);

		if (quotations == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuotationsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return quotations;
	}

	/**
	 * Returns the quotations with the primary key or throws a <code>NoSuchQuotationsException</code> if it could not be found.
	 *
	 * @param quotationId the primary key of the quotations
	 * @return the quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	@Override
	public Quotations findByPrimaryKey(long quotationId)
		throws NoSuchQuotationsException {

		return findByPrimaryKey((Serializable)quotationId);
	}

	/**
	 * Returns the quotations with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quotationId the primary key of the quotations
	 * @return the quotations, or <code>null</code> if a quotations with the primary key could not be found
	 */
	@Override
	public Quotations fetchByPrimaryKey(long quotationId) {
		return fetchByPrimaryKey((Serializable)quotationId);
	}

	/**
	 * Returns all the quotationses.
	 *
	 * @return the quotationses
	 */
	@Override
	public List<Quotations> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of quotationses
	 */
	@Override
	public List<Quotations> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotationses
	 */
	@Override
	public List<Quotations> findAll(
		int start, int end, OrderByComparator<Quotations> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotationses
	 */
	@Override
	public List<Quotations> findAll(
		int start, int end, OrderByComparator<Quotations> orderByComparator,
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

		List<Quotations> list = null;

		if (useFinderCache) {
			list = (List<Quotations>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_QUOTATIONS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_QUOTATIONS;

				sql = sql.concat(QuotationsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Quotations>)QueryUtil.list(
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
	 * Removes all the quotationses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Quotations quotations : findAll()) {
			remove(quotations);
		}
	}

	/**
	 * Returns the number of quotationses.
	 *
	 * @return the number of quotationses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_QUOTATIONS);

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
		return "QUOTATIONS_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_QUOTATIONS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QuotationsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the quotations persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new QuotationsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Quotations.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByInsuredId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInsuredId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"INSURED_ID"}, true);

		_finderPathWithoutPaginationFindByInsuredId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInsuredId",
			new String[] {Long.class.getName()}, new String[] {"INSURED_ID"},
			true);

		_finderPathCountByInsuredId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInsuredId",
			new String[] {Long.class.getName()}, new String[] {"INSURED_ID"},
			false);

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

		_finderPathWithPaginationFindByInsuredIdAndStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInsuredIdAndStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"INSURED_ID", "QUOTE_STATUS"}, true);

		_finderPathWithoutPaginationFindByInsuredIdAndStatus =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByInsuredIdAndStatus",
				new String[] {Long.class.getName(), String.class.getName()},
				new String[] {"INSURED_ID", "QUOTE_STATUS"}, true);

		_finderPathCountByInsuredIdAndStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByInsuredIdAndStatus",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"INSURED_ID", "QUOTE_STATUS"}, false);

		_finderPathWithPaginationCountByInsuredIdAndStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByInsuredIdAndStatus",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"INSURED_ID", "QUOTE_STATUS"}, false);

		_finderPathWithPaginationFindByDateExpiredQuots = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDateExpiredQuots",
			new String[] {
				Date.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"VEHICLE_EST_EXP_DATE", "QUOTE_STATUS"}, true);

		_finderPathWithPaginationCountByDateExpiredQuots = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByDateExpiredQuots",
			new String[] {Date.class.getName(), String.class.getName()},
			new String[] {"VEHICLE_EST_EXP_DATE", "QUOTE_STATUS"}, false);

		_finderPathWithPaginationFindByPendingQuots = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPendingQuots",
			new String[] {
				Date.class.getName(), String.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"VEHICLE_EST_EXP_DATE", "QUOTE_STATUS", "SMS_FLAG"},
			true);

		_finderPathWithPaginationCountByPendingQuots = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByPendingQuots",
			new String[] {
				Date.class.getName(), String.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"VEHICLE_EST_EXP_DATE", "QUOTE_STATUS", "SMS_FLAG"},
			false);

		_finderPathWithPaginationFindByQuotsStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQuotsStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"QUOTE_STATUS"}, true);

		_finderPathWithoutPaginationFindByQuotsStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuotsStatus",
			new String[] {String.class.getName()},
			new String[] {"QUOTE_STATUS"}, true);

		_finderPathCountByQuotsStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuotsStatus",
			new String[] {String.class.getName()},
			new String[] {"QUOTE_STATUS"}, false);

		_finderPathWithPaginationCountByQuotsStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByQuotsStatus",
			new String[] {String.class.getName()},
			new String[] {"QUOTE_STATUS"}, false);

		_finderPathWithPaginationFindByReferenceNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByReferenceNo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"REFERENCE_NO"}, true);

		_finderPathWithoutPaginationFindByReferenceNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReferenceNo",
			new String[] {String.class.getName()},
			new String[] {"REFERENCE_NO"}, true);

		_finderPathCountByReferenceNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReferenceNo",
			new String[] {String.class.getName()},
			new String[] {"REFERENCE_NO"}, false);

		_finderPathWithPaginationCountByReferenceNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByReferenceNo",
			new String[] {String.class.getName()},
			new String[] {"REFERENCE_NO"}, false);

		_finderPathFetchByPolicyNo = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByPolicyNo",
			new String[] {String.class.getName()}, new String[] {"POLICY_NO"},
			true);

		_finderPathCountByPolicyNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPolicyNo",
			new String[] {String.class.getName()}, new String[] {"POLICY_NO"},
			false);

		_finderPathWithPaginationFindByinsuredMobile = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByinsuredMobile",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"INSURED_MOBILE"}, true);

		_finderPathWithoutPaginationFindByinsuredMobile = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByinsuredMobile",
			new String[] {Long.class.getName()},
			new String[] {"INSURED_MOBILE"}, true);

		_finderPathCountByinsuredMobile = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByinsuredMobile",
			new String[] {Long.class.getName()},
			new String[] {"INSURED_MOBILE"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(QuotationsImpl.class.getName());

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

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_QUOTATIONS =
		"SELECT quotations FROM Quotations quotations";

	private static final String _SQL_SELECT_QUOTATIONS_WHERE =
		"SELECT quotations FROM Quotations quotations WHERE ";

	private static final String _SQL_COUNT_QUOTATIONS =
		"SELECT COUNT(quotations) FROM Quotations quotations";

	private static final String _SQL_COUNT_QUOTATIONS_WHERE =
		"SELECT COUNT(quotations) FROM Quotations quotations WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "quotations.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Quotations exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Quotations exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		QuotationsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"addressAddNo", "addressBuildingNo", "addressDistrict",
			"addressStreet", "addressUnitNo", "addressZipCode", "addCover",
			"addDriver", "agencyRepair", "city", "deductibleValue",
			"insuredDob", "insuredEmail", "insuredGender", "insuredId",
			"insuredIdType", "insuredMobile", "insuredName",
			"insuredNationality", "insuredEducation", "insuredMaritalStatus",
			"insuredNoChildUnder16", "loyaltyDiscount", "ncdYears",
			"paymemtAmount", "paymentMethod", "paymentRefNo", "policyEffFromNo",
			"policyEffTo", "policyEffDate", "policyIssueDate", "policyNo",
			"policyRefNo", "policyStatusCode", "productCode",
			"purposeOfVehicle", "quotationId", "referenceNo", "source",
			"transaction", "vehicleBodyType", "vehicleCapacity",
			"vehicleChassisNo", "vehicleColor", "vehicleCylinder",
			"vehicleEstExpiryDate", "vehicleId", "vehicleIdType", "vehicleMake",
			"vehicleMfgYear", "vehicleModel", "vehiclePlateL1",
			"vehiclePlateL2", "vehiclePlateL3", "vehiclePlateNo",
			"vehiclePlateType", "vehicleValue", "vehicleWeight", "vehicleCity",
			"vehicleCurrentMileage", "vehicleLowerExpectedMileagePerYear",
			"vehicleUpperExpectedMileagePerYear", "vehicleNightLocation",
			"vehicleEngineSize", "vehicleTransType", "vehAxleWeight",
			"vehCarMods", "vehSpecs", "occCode", "insuredIBAN", "insuredDobH",
			"netPrem", "discountAmount", "loyaltyDiscountAmount",
			"discountPrem", "loyaltyDiscountPer", "loadingAmount",
			"policyTaxes", "policyFees", "totalCoverPrem", "grossPrem",
			"existingPolicyNo", "existingCompanyName", "existingExpDate",
			"policyStatusMsg", "yakeenRefNo", "quoteSubmissionDate",
			"quoteStatus", "saeedService", "driverAccidents", "driverAgeLess21",
			"agencyRepairOut", "totalAfterDiscount", "totalBeforeDisc",
			"smsFlag"
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

	private static class QuotationsModelArgumentsResolver
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

			QuotationsModelImpl quotationsModelImpl =
				(QuotationsModelImpl)baseModel;

			Object[] values = _getValue(
				quotationsModelImpl, columnNames, original);

			if (!checkColumn ||
				!Arrays.equals(
					values,
					_getValue(quotationsModelImpl, columnNames, !original))) {

				return values;
			}

			return null;
		}

		private Object[] _getValue(
			QuotationsModelImpl quotationsModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = quotationsModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = quotationsModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}