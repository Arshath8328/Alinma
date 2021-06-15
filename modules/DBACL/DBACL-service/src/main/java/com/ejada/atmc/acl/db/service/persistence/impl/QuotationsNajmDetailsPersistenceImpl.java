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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationsNajmDetailsException;
import com.ejada.atmc.acl.db.model.QuotationsNajmDetails;
import com.ejada.atmc.acl.db.model.impl.QuotationsNajmDetailsImpl;
import com.ejada.atmc.acl.db.model.impl.QuotationsNajmDetailsModelImpl;
import com.ejada.atmc.acl.db.service.persistence.QuotationsNajmDetailsPK;
import com.ejada.atmc.acl.db.service.persistence.QuotationsNajmDetailsPersistence;
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
 * The persistence implementation for the quotations najm details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = QuotationsNajmDetailsPersistence.class)
public class QuotationsNajmDetailsPersistenceImpl
	extends BasePersistenceImpl<QuotationsNajmDetails>
	implements QuotationsNajmDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>QuotationsNajmDetailsUtil</code> to access the quotations najm details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		QuotationsNajmDetailsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByCaseNumberQuotationId;
	private FinderPath _finderPathCountByCaseNumberQuotationId;

	/**
	 * Returns the quotations najm details where caseNumber = &#63; and quotationId = &#63; or throws a <code>NoSuchQuotationsNajmDetailsException</code> if it could not be found.
	 *
	 * @param caseNumber the case number
	 * @param quotationId the quotation ID
	 * @return the matching quotations najm details
	 * @throws NoSuchQuotationsNajmDetailsException if a matching quotations najm details could not be found
	 */
	@Override
	public QuotationsNajmDetails findByCaseNumberQuotationId(
			String caseNumber, long quotationId)
		throws NoSuchQuotationsNajmDetailsException {

		QuotationsNajmDetails quotationsNajmDetails =
			fetchByCaseNumberQuotationId(caseNumber, quotationId);

		if (quotationsNajmDetails == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("caseNumber=");
			sb.append(caseNumber);

			sb.append(", quotationId=");
			sb.append(quotationId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchQuotationsNajmDetailsException(sb.toString());
		}

		return quotationsNajmDetails;
	}

	/**
	 * Returns the quotations najm details where caseNumber = &#63; and quotationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param caseNumber the case number
	 * @param quotationId the quotation ID
	 * @return the matching quotations najm details, or <code>null</code> if a matching quotations najm details could not be found
	 */
	@Override
	public QuotationsNajmDetails fetchByCaseNumberQuotationId(
		String caseNumber, long quotationId) {

		return fetchByCaseNumberQuotationId(caseNumber, quotationId, true);
	}

	/**
	 * Returns the quotations najm details where caseNumber = &#63; and quotationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param caseNumber the case number
	 * @param quotationId the quotation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotations najm details, or <code>null</code> if a matching quotations najm details could not be found
	 */
	@Override
	public QuotationsNajmDetails fetchByCaseNumberQuotationId(
		String caseNumber, long quotationId, boolean useFinderCache) {

		caseNumber = Objects.toString(caseNumber, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {caseNumber, quotationId};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByCaseNumberQuotationId, finderArgs, this);
		}

		if (result instanceof QuotationsNajmDetails) {
			QuotationsNajmDetails quotationsNajmDetails =
				(QuotationsNajmDetails)result;

			if (!Objects.equals(
					caseNumber, quotationsNajmDetails.getCaseNumber()) ||
				(quotationId != quotationsNajmDetails.getQuotationId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_QUOTATIONSNAJMDETAILS_WHERE);

			boolean bindCaseNumber = false;

			if (caseNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_CASENUMBERQUOTATIONID_CASENUMBER_3);
			}
			else {
				bindCaseNumber = true;

				sb.append(_FINDER_COLUMN_CASENUMBERQUOTATIONID_CASENUMBER_2);
			}

			sb.append(_FINDER_COLUMN_CASENUMBERQUOTATIONID_QUOTATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCaseNumber) {
					queryPos.add(caseNumber);
				}

				queryPos.add(quotationId);

				List<QuotationsNajmDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByCaseNumberQuotationId, finderArgs,
							list);
					}
				}
				else {
					QuotationsNajmDetails quotationsNajmDetails = list.get(0);

					result = quotationsNajmDetails;

					cacheResult(quotationsNajmDetails);
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
			return (QuotationsNajmDetails)result;
		}
	}

	/**
	 * Removes the quotations najm details where caseNumber = &#63; and quotationId = &#63; from the database.
	 *
	 * @param caseNumber the case number
	 * @param quotationId the quotation ID
	 * @return the quotations najm details that was removed
	 */
	@Override
	public QuotationsNajmDetails removeByCaseNumberQuotationId(
			String caseNumber, long quotationId)
		throws NoSuchQuotationsNajmDetailsException {

		QuotationsNajmDetails quotationsNajmDetails =
			findByCaseNumberQuotationId(caseNumber, quotationId);

		return remove(quotationsNajmDetails);
	}

	/**
	 * Returns the number of quotations najm detailses where caseNumber = &#63; and quotationId = &#63;.
	 *
	 * @param caseNumber the case number
	 * @param quotationId the quotation ID
	 * @return the number of matching quotations najm detailses
	 */
	@Override
	public int countByCaseNumberQuotationId(
		String caseNumber, long quotationId) {

		caseNumber = Objects.toString(caseNumber, "");

		FinderPath finderPath = _finderPathCountByCaseNumberQuotationId;

		Object[] finderArgs = new Object[] {caseNumber, quotationId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_QUOTATIONSNAJMDETAILS_WHERE);

			boolean bindCaseNumber = false;

			if (caseNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_CASENUMBERQUOTATIONID_CASENUMBER_3);
			}
			else {
				bindCaseNumber = true;

				sb.append(_FINDER_COLUMN_CASENUMBERQUOTATIONID_CASENUMBER_2);
			}

			sb.append(_FINDER_COLUMN_CASENUMBERQUOTATIONID_QUOTATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCaseNumber) {
					queryPos.add(caseNumber);
				}

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
		_FINDER_COLUMN_CASENUMBERQUOTATIONID_CASENUMBER_2 =
			"quotationsNajmDetails.id.caseNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_CASENUMBERQUOTATIONID_CASENUMBER_3 =
			"(quotationsNajmDetails.id.caseNumber IS NULL OR quotationsNajmDetails.id.caseNumber = '') AND ";

	private static final String
		_FINDER_COLUMN_CASENUMBERQUOTATIONID_QUOTATIONID_2 =
			"quotationsNajmDetails.id.quotationId = ?";

	private FinderPath _finderPathWithPaginationFindByQuotationId;
	private FinderPath _finderPathWithoutPaginationFindByQuotationId;
	private FinderPath _finderPathCountByQuotationId;

	/**
	 * Returns all the quotations najm detailses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotations najm detailses
	 */
	@Override
	public List<QuotationsNajmDetails> findByQuotationId(long quotationId) {
		return findByQuotationId(
			quotationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotations najm detailses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsNajmDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotations najm detailses
	 * @param end the upper bound of the range of quotations najm detailses (not inclusive)
	 * @return the range of matching quotations najm detailses
	 */
	@Override
	public List<QuotationsNajmDetails> findByQuotationId(
		long quotationId, int start, int end) {

		return findByQuotationId(quotationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotations najm detailses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsNajmDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotations najm detailses
	 * @param end the upper bound of the range of quotations najm detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotations najm detailses
	 */
	@Override
	public List<QuotationsNajmDetails> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<QuotationsNajmDetails> orderByComparator) {

		return findByQuotationId(
			quotationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotations najm detailses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsNajmDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotations najm detailses
	 * @param end the upper bound of the range of quotations najm detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotations najm detailses
	 */
	@Override
	public List<QuotationsNajmDetails> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<QuotationsNajmDetails> orderByComparator,
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

		List<QuotationsNajmDetails> list = null;

		if (useFinderCache) {
			list = (List<QuotationsNajmDetails>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (QuotationsNajmDetails quotationsNajmDetails : list) {
					if (quotationId != quotationsNajmDetails.getQuotationId()) {
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

			sb.append(_SQL_SELECT_QUOTATIONSNAJMDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_QUOTATIONID_QUOTATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationsNajmDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(quotationId);

				list = (List<QuotationsNajmDetails>)QueryUtil.list(
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
	 * Returns the first quotations najm details in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations najm details
	 * @throws NoSuchQuotationsNajmDetailsException if a matching quotations najm details could not be found
	 */
	@Override
	public QuotationsNajmDetails findByQuotationId_First(
			long quotationId,
			OrderByComparator<QuotationsNajmDetails> orderByComparator)
		throws NoSuchQuotationsNajmDetailsException {

		QuotationsNajmDetails quotationsNajmDetails = fetchByQuotationId_First(
			quotationId, orderByComparator);

		if (quotationsNajmDetails != null) {
			return quotationsNajmDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quotationId=");
		sb.append(quotationId);

		sb.append("}");

		throw new NoSuchQuotationsNajmDetailsException(sb.toString());
	}

	/**
	 * Returns the first quotations najm details in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations najm details, or <code>null</code> if a matching quotations najm details could not be found
	 */
	@Override
	public QuotationsNajmDetails fetchByQuotationId_First(
		long quotationId,
		OrderByComparator<QuotationsNajmDetails> orderByComparator) {

		List<QuotationsNajmDetails> list = findByQuotationId(
			quotationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last quotations najm details in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations najm details
	 * @throws NoSuchQuotationsNajmDetailsException if a matching quotations najm details could not be found
	 */
	@Override
	public QuotationsNajmDetails findByQuotationId_Last(
			long quotationId,
			OrderByComparator<QuotationsNajmDetails> orderByComparator)
		throws NoSuchQuotationsNajmDetailsException {

		QuotationsNajmDetails quotationsNajmDetails = fetchByQuotationId_Last(
			quotationId, orderByComparator);

		if (quotationsNajmDetails != null) {
			return quotationsNajmDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quotationId=");
		sb.append(quotationId);

		sb.append("}");

		throw new NoSuchQuotationsNajmDetailsException(sb.toString());
	}

	/**
	 * Returns the last quotations najm details in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations najm details, or <code>null</code> if a matching quotations najm details could not be found
	 */
	@Override
	public QuotationsNajmDetails fetchByQuotationId_Last(
		long quotationId,
		OrderByComparator<QuotationsNajmDetails> orderByComparator) {

		int count = countByQuotationId(quotationId);

		if (count == 0) {
			return null;
		}

		List<QuotationsNajmDetails> list = findByQuotationId(
			quotationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the quotations najm detailses before and after the current quotations najm details in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationsNajmDetailsPK the primary key of the current quotations najm details
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations najm details
	 * @throws NoSuchQuotationsNajmDetailsException if a quotations najm details with the primary key could not be found
	 */
	@Override
	public QuotationsNajmDetails[] findByQuotationId_PrevAndNext(
			QuotationsNajmDetailsPK quotationsNajmDetailsPK, long quotationId,
			OrderByComparator<QuotationsNajmDetails> orderByComparator)
		throws NoSuchQuotationsNajmDetailsException {

		QuotationsNajmDetails quotationsNajmDetails = findByPrimaryKey(
			quotationsNajmDetailsPK);

		Session session = null;

		try {
			session = openSession();

			QuotationsNajmDetails[] array = new QuotationsNajmDetailsImpl[3];

			array[0] = getByQuotationId_PrevAndNext(
				session, quotationsNajmDetails, quotationId, orderByComparator,
				true);

			array[1] = quotationsNajmDetails;

			array[2] = getByQuotationId_PrevAndNext(
				session, quotationsNajmDetails, quotationId, orderByComparator,
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

	protected QuotationsNajmDetails getByQuotationId_PrevAndNext(
		Session session, QuotationsNajmDetails quotationsNajmDetails,
		long quotationId,
		OrderByComparator<QuotationsNajmDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_QUOTATIONSNAJMDETAILS_WHERE);

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
			sb.append(QuotationsNajmDetailsModelImpl.ORDER_BY_JPQL);
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
						quotationsNajmDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<QuotationsNajmDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the quotations najm detailses where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	@Override
	public void removeByQuotationId(long quotationId) {
		for (QuotationsNajmDetails quotationsNajmDetails :
				findByQuotationId(
					quotationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(quotationsNajmDetails);
		}
	}

	/**
	 * Returns the number of quotations najm detailses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotations najm detailses
	 */
	@Override
	public int countByQuotationId(long quotationId) {
		FinderPath finderPath = _finderPathCountByQuotationId;

		Object[] finderArgs = new Object[] {quotationId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUOTATIONSNAJMDETAILS_WHERE);

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
		"quotationsNajmDetails.id.quotationId = ?";

	public QuotationsNajmDetailsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("caseNumber", "CASE_NUMBER");
		dbColumnNames.put("quotationId", "QUOTATION_ID");
		dbColumnNames.put("accidentDate", "ACCIDENT_DATE");
		dbColumnNames.put("liability", "LIABILITY");
		dbColumnNames.put("driverAge", "DRIVER_AGE");
		dbColumnNames.put("carModel", "CAR_MODEL");
		dbColumnNames.put("carType", "CAR_TYPE");
		dbColumnNames.put("driverID", "DRIVER_ID");
		dbColumnNames.put("sequenceNumber", "SEQUENCE_NUMBER");
		dbColumnNames.put("ownerID", "OWNER_ID");
		dbColumnNames.put("estimatedAmount", "ESTIMATED_AMOUNT");
		dbColumnNames.put("damageParts", "DAMAGE_PARTS");
		dbColumnNames.put("causeOfAccident", "CAUSE_OF_ACCIDENT");

		setDBColumnNames(dbColumnNames);

		setModelClass(QuotationsNajmDetails.class);

		setModelImplClass(QuotationsNajmDetailsImpl.class);
		setModelPKClass(QuotationsNajmDetailsPK.class);
	}

	/**
	 * Caches the quotations najm details in the entity cache if it is enabled.
	 *
	 * @param quotationsNajmDetails the quotations najm details
	 */
	@Override
	public void cacheResult(QuotationsNajmDetails quotationsNajmDetails) {
		dummyEntityCache.putResult(
			QuotationsNajmDetailsImpl.class,
			quotationsNajmDetails.getPrimaryKey(), quotationsNajmDetails);

		dummyFinderCache.putResult(
			_finderPathFetchByCaseNumberQuotationId,
			new Object[] {
				quotationsNajmDetails.getCaseNumber(),
				quotationsNajmDetails.getQuotationId()
			},
			quotationsNajmDetails);
	}

	/**
	 * Caches the quotations najm detailses in the entity cache if it is enabled.
	 *
	 * @param quotationsNajmDetailses the quotations najm detailses
	 */
	@Override
	public void cacheResult(
		List<QuotationsNajmDetails> quotationsNajmDetailses) {

		for (QuotationsNajmDetails quotationsNajmDetails :
				quotationsNajmDetailses) {

			if (dummyEntityCache.getResult(
					QuotationsNajmDetailsImpl.class,
					quotationsNajmDetails.getPrimaryKey()) == null) {

				cacheResult(quotationsNajmDetails);
			}
		}
	}

	/**
	 * Clears the cache for all quotations najm detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(QuotationsNajmDetailsImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the quotations najm details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuotationsNajmDetails quotationsNajmDetails) {
		dummyEntityCache.removeResult(
			QuotationsNajmDetailsImpl.class, quotationsNajmDetails);
	}

	@Override
	public void clearCache(
		List<QuotationsNajmDetails> quotationsNajmDetailses) {

		for (QuotationsNajmDetails quotationsNajmDetails :
				quotationsNajmDetailses) {

			dummyEntityCache.removeResult(
				QuotationsNajmDetailsImpl.class, quotationsNajmDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				QuotationsNajmDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		QuotationsNajmDetailsModelImpl quotationsNajmDetailsModelImpl) {

		Object[] args = new Object[] {
			quotationsNajmDetailsModelImpl.getCaseNumber(),
			quotationsNajmDetailsModelImpl.getQuotationId()
		};

		dummyFinderCache.putResult(
			_finderPathCountByCaseNumberQuotationId, args, Long.valueOf(1),
			false);
		dummyFinderCache.putResult(
			_finderPathFetchByCaseNumberQuotationId, args,
			quotationsNajmDetailsModelImpl, false);
	}

	/**
	 * Creates a new quotations najm details with the primary key. Does not add the quotations najm details to the database.
	 *
	 * @param quotationsNajmDetailsPK the primary key for the new quotations najm details
	 * @return the new quotations najm details
	 */
	@Override
	public QuotationsNajmDetails create(
		QuotationsNajmDetailsPK quotationsNajmDetailsPK) {

		QuotationsNajmDetails quotationsNajmDetails =
			new QuotationsNajmDetailsImpl();

		quotationsNajmDetails.setNew(true);
		quotationsNajmDetails.setPrimaryKey(quotationsNajmDetailsPK);

		return quotationsNajmDetails;
	}

	/**
	 * Removes the quotations najm details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quotationsNajmDetailsPK the primary key of the quotations najm details
	 * @return the quotations najm details that was removed
	 * @throws NoSuchQuotationsNajmDetailsException if a quotations najm details with the primary key could not be found
	 */
	@Override
	public QuotationsNajmDetails remove(
			QuotationsNajmDetailsPK quotationsNajmDetailsPK)
		throws NoSuchQuotationsNajmDetailsException {

		return remove((Serializable)quotationsNajmDetailsPK);
	}

	/**
	 * Removes the quotations najm details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the quotations najm details
	 * @return the quotations najm details that was removed
	 * @throws NoSuchQuotationsNajmDetailsException if a quotations najm details with the primary key could not be found
	 */
	@Override
	public QuotationsNajmDetails remove(Serializable primaryKey)
		throws NoSuchQuotationsNajmDetailsException {

		Session session = null;

		try {
			session = openSession();

			QuotationsNajmDetails quotationsNajmDetails =
				(QuotationsNajmDetails)session.get(
					QuotationsNajmDetailsImpl.class, primaryKey);

			if (quotationsNajmDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuotationsNajmDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(quotationsNajmDetails);
		}
		catch (NoSuchQuotationsNajmDetailsException noSuchEntityException) {
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
	protected QuotationsNajmDetails removeImpl(
		QuotationsNajmDetails quotationsNajmDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(quotationsNajmDetails)) {
				quotationsNajmDetails = (QuotationsNajmDetails)session.get(
					QuotationsNajmDetailsImpl.class,
					quotationsNajmDetails.getPrimaryKeyObj());
			}

			if (quotationsNajmDetails != null) {
				session.delete(quotationsNajmDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (quotationsNajmDetails != null) {
			clearCache(quotationsNajmDetails);
		}

		return quotationsNajmDetails;
	}

	@Override
	public QuotationsNajmDetails updateImpl(
		QuotationsNajmDetails quotationsNajmDetails) {

		boolean isNew = quotationsNajmDetails.isNew();

		if (!(quotationsNajmDetails instanceof
				QuotationsNajmDetailsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(quotationsNajmDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					quotationsNajmDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in quotationsNajmDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom QuotationsNajmDetails implementation " +
					quotationsNajmDetails.getClass());
		}

		QuotationsNajmDetailsModelImpl quotationsNajmDetailsModelImpl =
			(QuotationsNajmDetailsModelImpl)quotationsNajmDetails;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(quotationsNajmDetails);
			}
			else {
				quotationsNajmDetails = (QuotationsNajmDetails)session.merge(
					quotationsNajmDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			QuotationsNajmDetailsImpl.class, quotationsNajmDetailsModelImpl,
			false, true);

		cacheUniqueFindersCache(quotationsNajmDetailsModelImpl);

		if (isNew) {
			quotationsNajmDetails.setNew(false);
		}

		quotationsNajmDetails.resetOriginalValues();

		return quotationsNajmDetails;
	}

	/**
	 * Returns the quotations najm details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the quotations najm details
	 * @return the quotations najm details
	 * @throws NoSuchQuotationsNajmDetailsException if a quotations najm details with the primary key could not be found
	 */
	@Override
	public QuotationsNajmDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuotationsNajmDetailsException {

		QuotationsNajmDetails quotationsNajmDetails = fetchByPrimaryKey(
			primaryKey);

		if (quotationsNajmDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuotationsNajmDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return quotationsNajmDetails;
	}

	/**
	 * Returns the quotations najm details with the primary key or throws a <code>NoSuchQuotationsNajmDetailsException</code> if it could not be found.
	 *
	 * @param quotationsNajmDetailsPK the primary key of the quotations najm details
	 * @return the quotations najm details
	 * @throws NoSuchQuotationsNajmDetailsException if a quotations najm details with the primary key could not be found
	 */
	@Override
	public QuotationsNajmDetails findByPrimaryKey(
			QuotationsNajmDetailsPK quotationsNajmDetailsPK)
		throws NoSuchQuotationsNajmDetailsException {

		return findByPrimaryKey((Serializable)quotationsNajmDetailsPK);
	}

	/**
	 * Returns the quotations najm details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quotationsNajmDetailsPK the primary key of the quotations najm details
	 * @return the quotations najm details, or <code>null</code> if a quotations najm details with the primary key could not be found
	 */
	@Override
	public QuotationsNajmDetails fetchByPrimaryKey(
		QuotationsNajmDetailsPK quotationsNajmDetailsPK) {

		return fetchByPrimaryKey((Serializable)quotationsNajmDetailsPK);
	}

	/**
	 * Returns all the quotations najm detailses.
	 *
	 * @return the quotations najm detailses
	 */
	@Override
	public List<QuotationsNajmDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotations najm detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsNajmDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations najm detailses
	 * @param end the upper bound of the range of quotations najm detailses (not inclusive)
	 * @return the range of quotations najm detailses
	 */
	@Override
	public List<QuotationsNajmDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotations najm detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsNajmDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations najm detailses
	 * @param end the upper bound of the range of quotations najm detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotations najm detailses
	 */
	@Override
	public List<QuotationsNajmDetails> findAll(
		int start, int end,
		OrderByComparator<QuotationsNajmDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotations najm detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsNajmDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations najm detailses
	 * @param end the upper bound of the range of quotations najm detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotations najm detailses
	 */
	@Override
	public List<QuotationsNajmDetails> findAll(
		int start, int end,
		OrderByComparator<QuotationsNajmDetails> orderByComparator,
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

		List<QuotationsNajmDetails> list = null;

		if (useFinderCache) {
			list = (List<QuotationsNajmDetails>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_QUOTATIONSNAJMDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_QUOTATIONSNAJMDETAILS;

				sql = sql.concat(QuotationsNajmDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<QuotationsNajmDetails>)QueryUtil.list(
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
	 * Removes all the quotations najm detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QuotationsNajmDetails quotationsNajmDetails : findAll()) {
			remove(quotationsNajmDetails);
		}
	}

	/**
	 * Returns the number of quotations najm detailses.
	 *
	 * @return the number of quotations najm detailses
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
					_SQL_COUNT_QUOTATIONSNAJMDETAILS);

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
		return "quotationsNajmDetailsPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_QUOTATIONSNAJMDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QuotationsNajmDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the quotations najm details persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new QuotationsNajmDetailsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", QuotationsNajmDetails.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByCaseNumberQuotationId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCaseNumberQuotationId",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"CASE_NUMBER", "QUOTATION_ID"}, true);

		_finderPathCountByCaseNumberQuotationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCaseNumberQuotationId",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"CASE_NUMBER", "QUOTATION_ID"}, false);

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
		dummyEntityCache.removeCache(QuotationsNajmDetailsImpl.class.getName());

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

	private static final String _SQL_SELECT_QUOTATIONSNAJMDETAILS =
		"SELECT quotationsNajmDetails FROM QuotationsNajmDetails quotationsNajmDetails";

	private static final String _SQL_SELECT_QUOTATIONSNAJMDETAILS_WHERE =
		"SELECT quotationsNajmDetails FROM QuotationsNajmDetails quotationsNajmDetails WHERE ";

	private static final String _SQL_COUNT_QUOTATIONSNAJMDETAILS =
		"SELECT COUNT(quotationsNajmDetails) FROM QuotationsNajmDetails quotationsNajmDetails";

	private static final String _SQL_COUNT_QUOTATIONSNAJMDETAILS_WHERE =
		"SELECT COUNT(quotationsNajmDetails) FROM QuotationsNajmDetails quotationsNajmDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"quotationsNajmDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No QuotationsNajmDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No QuotationsNajmDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		QuotationsNajmDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"caseNumber", "quotationId", "accidentDate", "liability",
			"driverAge", "carModel", "carType", "driverID", "sequenceNumber",
			"ownerID", "estimatedAmount", "damageParts", "causeOfAccident"
		});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"caseNumber", "quotationId"});

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

	private static class QuotationsNajmDetailsModelArgumentsResolver
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

			QuotationsNajmDetailsModelImpl quotationsNajmDetailsModelImpl =
				(QuotationsNajmDetailsModelImpl)baseModel;

			long columnBitmask =
				quotationsNajmDetailsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					quotationsNajmDetailsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						quotationsNajmDetailsModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					quotationsNajmDetailsModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			QuotationsNajmDetailsModelImpl quotationsNajmDetailsModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						quotationsNajmDetailsModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						quotationsNajmDetailsModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}