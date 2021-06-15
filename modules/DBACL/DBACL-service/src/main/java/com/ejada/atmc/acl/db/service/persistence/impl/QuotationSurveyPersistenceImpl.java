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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationSurveyException;
import com.ejada.atmc.acl.db.model.QuotationSurvey;
import com.ejada.atmc.acl.db.model.impl.QuotationSurveyImpl;
import com.ejada.atmc.acl.db.model.impl.QuotationSurveyModelImpl;
import com.ejada.atmc.acl.db.service.persistence.QuotationSurveyPersistence;
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
 * The persistence implementation for the quotation survey service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = QuotationSurveyPersistence.class)
public class QuotationSurveyPersistenceImpl
	extends BasePersistenceImpl<QuotationSurvey>
	implements QuotationSurveyPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>QuotationSurveyUtil</code> to access the quotation survey persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		QuotationSurveyImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByquotationId;
	private FinderPath _finderPathWithoutPaginationFindByquotationId;
	private FinderPath _finderPathCountByquotationId;

	/**
	 * Returns all the quotation surveys where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation surveys
	 */
	@Override
	public List<QuotationSurvey> findByquotationId(String quotationId) {
		return findByquotationId(
			quotationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotation surveys where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationSurveyModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation surveys
	 * @param end the upper bound of the range of quotation surveys (not inclusive)
	 * @return the range of matching quotation surveys
	 */
	@Override
	public List<QuotationSurvey> findByquotationId(
		String quotationId, int start, int end) {

		return findByquotationId(quotationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotation surveys where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationSurveyModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation surveys
	 * @param end the upper bound of the range of quotation surveys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotation surveys
	 */
	@Override
	public List<QuotationSurvey> findByquotationId(
		String quotationId, int start, int end,
		OrderByComparator<QuotationSurvey> orderByComparator) {

		return findByquotationId(
			quotationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotation surveys where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationSurveyModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation surveys
	 * @param end the upper bound of the range of quotation surveys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotation surveys
	 */
	@Override
	public List<QuotationSurvey> findByquotationId(
		String quotationId, int start, int end,
		OrderByComparator<QuotationSurvey> orderByComparator,
		boolean useFinderCache) {

		quotationId = Objects.toString(quotationId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByquotationId;
				finderArgs = new Object[] {quotationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByquotationId;
			finderArgs = new Object[] {
				quotationId, start, end, orderByComparator
			};
		}

		List<QuotationSurvey> list = null;

		if (useFinderCache) {
			list = (List<QuotationSurvey>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (QuotationSurvey quotationSurvey : list) {
					if (!quotationId.equals(quotationSurvey.getQuotationId())) {
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

			sb.append(_SQL_SELECT_QUOTATIONSURVEY_WHERE);

			boolean bindQuotationId = false;

			if (quotationId.isEmpty()) {
				sb.append(_FINDER_COLUMN_QUOTATIONID_QUOTATIONID_3);
			}
			else {
				bindQuotationId = true;

				sb.append(_FINDER_COLUMN_QUOTATIONID_QUOTATIONID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationSurveyModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindQuotationId) {
					queryPos.add(quotationId);
				}

				list = (List<QuotationSurvey>)QueryUtil.list(
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
	 * Returns the first quotation survey in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation survey
	 * @throws NoSuchQuotationSurveyException if a matching quotation survey could not be found
	 */
	@Override
	public QuotationSurvey findByquotationId_First(
			String quotationId,
			OrderByComparator<QuotationSurvey> orderByComparator)
		throws NoSuchQuotationSurveyException {

		QuotationSurvey quotationSurvey = fetchByquotationId_First(
			quotationId, orderByComparator);

		if (quotationSurvey != null) {
			return quotationSurvey;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quotationId=");
		sb.append(quotationId);

		sb.append("}");

		throw new NoSuchQuotationSurveyException(sb.toString());
	}

	/**
	 * Returns the first quotation survey in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation survey, or <code>null</code> if a matching quotation survey could not be found
	 */
	@Override
	public QuotationSurvey fetchByquotationId_First(
		String quotationId,
		OrderByComparator<QuotationSurvey> orderByComparator) {

		List<QuotationSurvey> list = findByquotationId(
			quotationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last quotation survey in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation survey
	 * @throws NoSuchQuotationSurveyException if a matching quotation survey could not be found
	 */
	@Override
	public QuotationSurvey findByquotationId_Last(
			String quotationId,
			OrderByComparator<QuotationSurvey> orderByComparator)
		throws NoSuchQuotationSurveyException {

		QuotationSurvey quotationSurvey = fetchByquotationId_Last(
			quotationId, orderByComparator);

		if (quotationSurvey != null) {
			return quotationSurvey;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quotationId=");
		sb.append(quotationId);

		sb.append("}");

		throw new NoSuchQuotationSurveyException(sb.toString());
	}

	/**
	 * Returns the last quotation survey in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation survey, or <code>null</code> if a matching quotation survey could not be found
	 */
	@Override
	public QuotationSurvey fetchByquotationId_Last(
		String quotationId,
		OrderByComparator<QuotationSurvey> orderByComparator) {

		int count = countByquotationId(quotationId);

		if (count == 0) {
			return null;
		}

		List<QuotationSurvey> list = findByquotationId(
			quotationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the quotation surveys before and after the current quotation survey in the ordered set where quotationId = &#63;.
	 *
	 * @param surveyId the primary key of the current quotation survey
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation survey
	 * @throws NoSuchQuotationSurveyException if a quotation survey with the primary key could not be found
	 */
	@Override
	public QuotationSurvey[] findByquotationId_PrevAndNext(
			long surveyId, String quotationId,
			OrderByComparator<QuotationSurvey> orderByComparator)
		throws NoSuchQuotationSurveyException {

		quotationId = Objects.toString(quotationId, "");

		QuotationSurvey quotationSurvey = findByPrimaryKey(surveyId);

		Session session = null;

		try {
			session = openSession();

			QuotationSurvey[] array = new QuotationSurveyImpl[3];

			array[0] = getByquotationId_PrevAndNext(
				session, quotationSurvey, quotationId, orderByComparator, true);

			array[1] = quotationSurvey;

			array[2] = getByquotationId_PrevAndNext(
				session, quotationSurvey, quotationId, orderByComparator,
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

	protected QuotationSurvey getByquotationId_PrevAndNext(
		Session session, QuotationSurvey quotationSurvey, String quotationId,
		OrderByComparator<QuotationSurvey> orderByComparator,
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

		sb.append(_SQL_SELECT_QUOTATIONSURVEY_WHERE);

		boolean bindQuotationId = false;

		if (quotationId.isEmpty()) {
			sb.append(_FINDER_COLUMN_QUOTATIONID_QUOTATIONID_3);
		}
		else {
			bindQuotationId = true;

			sb.append(_FINDER_COLUMN_QUOTATIONID_QUOTATIONID_2);
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
			sb.append(QuotationSurveyModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindQuotationId) {
			queryPos.add(quotationId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						quotationSurvey)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<QuotationSurvey> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the quotation surveys where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	@Override
	public void removeByquotationId(String quotationId) {
		for (QuotationSurvey quotationSurvey :
				findByquotationId(
					quotationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(quotationSurvey);
		}
	}

	/**
	 * Returns the number of quotation surveys where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation surveys
	 */
	@Override
	public int countByquotationId(String quotationId) {
		quotationId = Objects.toString(quotationId, "");

		FinderPath finderPath = _finderPathCountByquotationId;

		Object[] finderArgs = new Object[] {quotationId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUOTATIONSURVEY_WHERE);

			boolean bindQuotationId = false;

			if (quotationId.isEmpty()) {
				sb.append(_FINDER_COLUMN_QUOTATIONID_QUOTATIONID_3);
			}
			else {
				bindQuotationId = true;

				sb.append(_FINDER_COLUMN_QUOTATIONID_QUOTATIONID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindQuotationId) {
					queryPos.add(quotationId);
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

	private static final String _FINDER_COLUMN_QUOTATIONID_QUOTATIONID_2 =
		"quotationSurvey.quotationId = ?";

	private static final String _FINDER_COLUMN_QUOTATIONID_QUOTATIONID_3 =
		"(quotationSurvey.quotationId IS NULL OR quotationSurvey.quotationId = '')";

	public QuotationSurveyPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("surveyId", "QUOTATION_SURVEY_ID");
		dbColumnNames.put("quotationId", "QUOTATION_ID");
		dbColumnNames.put("surveyVideoFile", "SURVEY_VIDEO_FILE");
		dbColumnNames.put("surveyVideoFileName", "SURVEY_VIDEO_FILE_NAME");
		dbColumnNames.put("surveyDate", "SURVEY_DATE");

		setDBColumnNames(dbColumnNames);

		setModelClass(QuotationSurvey.class);

		setModelImplClass(QuotationSurveyImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the quotation survey in the entity cache if it is enabled.
	 *
	 * @param quotationSurvey the quotation survey
	 */
	@Override
	public void cacheResult(QuotationSurvey quotationSurvey) {
		dummyEntityCache.putResult(
			QuotationSurveyImpl.class, quotationSurvey.getPrimaryKey(),
			quotationSurvey);
	}

	/**
	 * Caches the quotation surveys in the entity cache if it is enabled.
	 *
	 * @param quotationSurveys the quotation surveys
	 */
	@Override
	public void cacheResult(List<QuotationSurvey> quotationSurveys) {
		for (QuotationSurvey quotationSurvey : quotationSurveys) {
			if (dummyEntityCache.getResult(
					QuotationSurveyImpl.class,
					quotationSurvey.getPrimaryKey()) == null) {

				cacheResult(quotationSurvey);
			}
		}
	}

	/**
	 * Clears the cache for all quotation surveys.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(QuotationSurveyImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the quotation survey.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuotationSurvey quotationSurvey) {
		dummyEntityCache.removeResult(
			QuotationSurveyImpl.class, quotationSurvey);
	}

	@Override
	public void clearCache(List<QuotationSurvey> quotationSurveys) {
		for (QuotationSurvey quotationSurvey : quotationSurveys) {
			dummyEntityCache.removeResult(
				QuotationSurveyImpl.class, quotationSurvey);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				QuotationSurveyImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new quotation survey with the primary key. Does not add the quotation survey to the database.
	 *
	 * @param surveyId the primary key for the new quotation survey
	 * @return the new quotation survey
	 */
	@Override
	public QuotationSurvey create(long surveyId) {
		QuotationSurvey quotationSurvey = new QuotationSurveyImpl();

		quotationSurvey.setNew(true);
		quotationSurvey.setPrimaryKey(surveyId);

		return quotationSurvey;
	}

	/**
	 * Removes the quotation survey with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surveyId the primary key of the quotation survey
	 * @return the quotation survey that was removed
	 * @throws NoSuchQuotationSurveyException if a quotation survey with the primary key could not be found
	 */
	@Override
	public QuotationSurvey remove(long surveyId)
		throws NoSuchQuotationSurveyException {

		return remove((Serializable)surveyId);
	}

	/**
	 * Removes the quotation survey with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the quotation survey
	 * @return the quotation survey that was removed
	 * @throws NoSuchQuotationSurveyException if a quotation survey with the primary key could not be found
	 */
	@Override
	public QuotationSurvey remove(Serializable primaryKey)
		throws NoSuchQuotationSurveyException {

		Session session = null;

		try {
			session = openSession();

			QuotationSurvey quotationSurvey = (QuotationSurvey)session.get(
				QuotationSurveyImpl.class, primaryKey);

			if (quotationSurvey == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuotationSurveyException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(quotationSurvey);
		}
		catch (NoSuchQuotationSurveyException noSuchEntityException) {
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
	protected QuotationSurvey removeImpl(QuotationSurvey quotationSurvey) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(quotationSurvey)) {
				quotationSurvey = (QuotationSurvey)session.get(
					QuotationSurveyImpl.class,
					quotationSurvey.getPrimaryKeyObj());
			}

			if (quotationSurvey != null) {
				session.delete(quotationSurvey);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (quotationSurvey != null) {
			clearCache(quotationSurvey);
		}

		return quotationSurvey;
	}

	@Override
	public QuotationSurvey updateImpl(QuotationSurvey quotationSurvey) {
		boolean isNew = quotationSurvey.isNew();

		if (!(quotationSurvey instanceof QuotationSurveyModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(quotationSurvey.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					quotationSurvey);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in quotationSurvey proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom QuotationSurvey implementation " +
					quotationSurvey.getClass());
		}

		QuotationSurveyModelImpl quotationSurveyModelImpl =
			(QuotationSurveyModelImpl)quotationSurvey;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(quotationSurvey);
			}
			else {
				session.evict(
					QuotationSurveyImpl.class,
					quotationSurvey.getPrimaryKeyObj());

				session.saveOrUpdate(quotationSurvey);
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
			QuotationSurveyImpl.class, quotationSurveyModelImpl, false, true);

		if (isNew) {
			quotationSurvey.setNew(false);
		}

		quotationSurvey.resetOriginalValues();

		return quotationSurvey;
	}

	/**
	 * Returns the quotation survey with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the quotation survey
	 * @return the quotation survey
	 * @throws NoSuchQuotationSurveyException if a quotation survey with the primary key could not be found
	 */
	@Override
	public QuotationSurvey findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuotationSurveyException {

		QuotationSurvey quotationSurvey = fetchByPrimaryKey(primaryKey);

		if (quotationSurvey == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuotationSurveyException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return quotationSurvey;
	}

	/**
	 * Returns the quotation survey with the primary key or throws a <code>NoSuchQuotationSurveyException</code> if it could not be found.
	 *
	 * @param surveyId the primary key of the quotation survey
	 * @return the quotation survey
	 * @throws NoSuchQuotationSurveyException if a quotation survey with the primary key could not be found
	 */
	@Override
	public QuotationSurvey findByPrimaryKey(long surveyId)
		throws NoSuchQuotationSurveyException {

		return findByPrimaryKey((Serializable)surveyId);
	}

	/**
	 * Returns the quotation survey with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surveyId the primary key of the quotation survey
	 * @return the quotation survey, or <code>null</code> if a quotation survey with the primary key could not be found
	 */
	@Override
	public QuotationSurvey fetchByPrimaryKey(long surveyId) {
		return fetchByPrimaryKey((Serializable)surveyId);
	}

	/**
	 * Returns all the quotation surveys.
	 *
	 * @return the quotation surveys
	 */
	@Override
	public List<QuotationSurvey> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotation surveys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationSurveyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation surveys
	 * @param end the upper bound of the range of quotation surveys (not inclusive)
	 * @return the range of quotation surveys
	 */
	@Override
	public List<QuotationSurvey> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotation surveys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationSurveyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation surveys
	 * @param end the upper bound of the range of quotation surveys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotation surveys
	 */
	@Override
	public List<QuotationSurvey> findAll(
		int start, int end,
		OrderByComparator<QuotationSurvey> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotation surveys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationSurveyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation surveys
	 * @param end the upper bound of the range of quotation surveys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotation surveys
	 */
	@Override
	public List<QuotationSurvey> findAll(
		int start, int end,
		OrderByComparator<QuotationSurvey> orderByComparator,
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

		List<QuotationSurvey> list = null;

		if (useFinderCache) {
			list = (List<QuotationSurvey>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_QUOTATIONSURVEY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_QUOTATIONSURVEY;

				sql = sql.concat(QuotationSurveyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<QuotationSurvey>)QueryUtil.list(
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
	 * Removes all the quotation surveys from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QuotationSurvey quotationSurvey : findAll()) {
			remove(quotationSurvey);
		}
	}

	/**
	 * Returns the number of quotation surveys.
	 *
	 * @return the number of quotation surveys
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_QUOTATIONSURVEY);

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
		return "QUOTATION_SURVEY_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_QUOTATIONSURVEY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QuotationSurveyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the quotation survey persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new QuotationSurveyModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", QuotationSurvey.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByquotationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByquotationId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"QUOTATION_ID"}, true);

		_finderPathWithoutPaginationFindByquotationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByquotationId",
			new String[] {String.class.getName()},
			new String[] {"QUOTATION_ID"}, true);

		_finderPathCountByquotationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByquotationId",
			new String[] {String.class.getName()},
			new String[] {"QUOTATION_ID"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(QuotationSurveyImpl.class.getName());

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

	private static final String _SQL_SELECT_QUOTATIONSURVEY =
		"SELECT quotationSurvey FROM QuotationSurvey quotationSurvey";

	private static final String _SQL_SELECT_QUOTATIONSURVEY_WHERE =
		"SELECT quotationSurvey FROM QuotationSurvey quotationSurvey WHERE ";

	private static final String _SQL_COUNT_QUOTATIONSURVEY =
		"SELECT COUNT(quotationSurvey) FROM QuotationSurvey quotationSurvey";

	private static final String _SQL_COUNT_QUOTATIONSURVEY_WHERE =
		"SELECT COUNT(quotationSurvey) FROM QuotationSurvey quotationSurvey WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "quotationSurvey.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No QuotationSurvey exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No QuotationSurvey exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		QuotationSurveyPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"surveyId", "quotationId", "surveyVideoFile", "surveyVideoFileName",
			"surveyDate"
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

	private static class QuotationSurveyModelArgumentsResolver
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

			QuotationSurveyModelImpl quotationSurveyModelImpl =
				(QuotationSurveyModelImpl)baseModel;

			long columnBitmask = quotationSurveyModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					quotationSurveyModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						quotationSurveyModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					quotationSurveyModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			QuotationSurveyModelImpl quotationSurveyModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						quotationSurveyModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = quotationSurveyModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}