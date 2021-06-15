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

import com.ejada.atmc.acl.db.exception.NoSuchServiceRequestHistoryException;
import com.ejada.atmc.acl.db.model.ServiceRequestHistory;
import com.ejada.atmc.acl.db.model.impl.ServiceRequestHistoryImpl;
import com.ejada.atmc.acl.db.model.impl.ServiceRequestHistoryModelImpl;
import com.ejada.atmc.acl.db.service.persistence.ServiceRequestHistoryPersistence;
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

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the service request history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ServiceRequestHistoryPersistence.class)
public class ServiceRequestHistoryPersistenceImpl
	extends BasePersistenceImpl<ServiceRequestHistory>
	implements ServiceRequestHistoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ServiceRequestHistoryUtil</code> to access the service request history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ServiceRequestHistoryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByrefNo;
	private FinderPath _finderPathWithoutPaginationFindByrefNo;
	private FinderPath _finderPathCountByrefNo;

	/**
	 * Returns all the service request histories where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @return the matching service request histories
	 */
	@Override
	public List<ServiceRequestHistory> findByrefNo(String REFERENCE_NO) {
		return findByrefNo(
			REFERENCE_NO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service request histories where REFERENCE_NO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param start the lower bound of the range of service request histories
	 * @param end the upper bound of the range of service request histories (not inclusive)
	 * @return the range of matching service request histories
	 */
	@Override
	public List<ServiceRequestHistory> findByrefNo(
		String REFERENCE_NO, int start, int end) {

		return findByrefNo(REFERENCE_NO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service request histories where REFERENCE_NO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param start the lower bound of the range of service request histories
	 * @param end the upper bound of the range of service request histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service request histories
	 */
	@Override
	public List<ServiceRequestHistory> findByrefNo(
		String REFERENCE_NO, int start, int end,
		OrderByComparator<ServiceRequestHistory> orderByComparator) {

		return findByrefNo(REFERENCE_NO, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service request histories where REFERENCE_NO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param start the lower bound of the range of service request histories
	 * @param end the upper bound of the range of service request histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service request histories
	 */
	@Override
	public List<ServiceRequestHistory> findByrefNo(
		String REFERENCE_NO, int start, int end,
		OrderByComparator<ServiceRequestHistory> orderByComparator,
		boolean useFinderCache) {

		REFERENCE_NO = Objects.toString(REFERENCE_NO, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByrefNo;
				finderArgs = new Object[] {REFERENCE_NO};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByrefNo;
			finderArgs = new Object[] {
				REFERENCE_NO, start, end, orderByComparator
			};
		}

		List<ServiceRequestHistory> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequestHistory>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ServiceRequestHistory serviceRequestHistory : list) {
					if (!REFERENCE_NO.equals(
							serviceRequestHistory.getREFERENCE_NO())) {

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

			sb.append(_SQL_SELECT_SERVICEREQUESTHISTORY_WHERE);

			boolean bindREFERENCE_NO = false;

			if (REFERENCE_NO.isEmpty()) {
				sb.append(_FINDER_COLUMN_REFNO_REFERENCE_NO_3);
			}
			else {
				bindREFERENCE_NO = true;

				sb.append(_FINDER_COLUMN_REFNO_REFERENCE_NO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServiceRequestHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindREFERENCE_NO) {
					queryPos.add(REFERENCE_NO);
				}

				list = (List<ServiceRequestHistory>)QueryUtil.list(
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
	 * Returns the first service request history in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request history
	 * @throws NoSuchServiceRequestHistoryException if a matching service request history could not be found
	 */
	@Override
	public ServiceRequestHistory findByrefNo_First(
			String REFERENCE_NO,
			OrderByComparator<ServiceRequestHistory> orderByComparator)
		throws NoSuchServiceRequestHistoryException {

		ServiceRequestHistory serviceRequestHistory = fetchByrefNo_First(
			REFERENCE_NO, orderByComparator);

		if (serviceRequestHistory != null) {
			return serviceRequestHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("REFERENCE_NO=");
		sb.append(REFERENCE_NO);

		sb.append("}");

		throw new NoSuchServiceRequestHistoryException(sb.toString());
	}

	/**
	 * Returns the first service request history in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request history, or <code>null</code> if a matching service request history could not be found
	 */
	@Override
	public ServiceRequestHistory fetchByrefNo_First(
		String REFERENCE_NO,
		OrderByComparator<ServiceRequestHistory> orderByComparator) {

		List<ServiceRequestHistory> list = findByrefNo(
			REFERENCE_NO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service request history in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request history
	 * @throws NoSuchServiceRequestHistoryException if a matching service request history could not be found
	 */
	@Override
	public ServiceRequestHistory findByrefNo_Last(
			String REFERENCE_NO,
			OrderByComparator<ServiceRequestHistory> orderByComparator)
		throws NoSuchServiceRequestHistoryException {

		ServiceRequestHistory serviceRequestHistory = fetchByrefNo_Last(
			REFERENCE_NO, orderByComparator);

		if (serviceRequestHistory != null) {
			return serviceRequestHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("REFERENCE_NO=");
		sb.append(REFERENCE_NO);

		sb.append("}");

		throw new NoSuchServiceRequestHistoryException(sb.toString());
	}

	/**
	 * Returns the last service request history in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request history, or <code>null</code> if a matching service request history could not be found
	 */
	@Override
	public ServiceRequestHistory fetchByrefNo_Last(
		String REFERENCE_NO,
		OrderByComparator<ServiceRequestHistory> orderByComparator) {

		int count = countByrefNo(REFERENCE_NO);

		if (count == 0) {
			return null;
		}

		List<ServiceRequestHistory> list = findByrefNo(
			REFERENCE_NO, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service request histories before and after the current service request history in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param ACTION_ID the primary key of the current service request history
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request history
	 * @throws NoSuchServiceRequestHistoryException if a service request history with the primary key could not be found
	 */
	@Override
	public ServiceRequestHistory[] findByrefNo_PrevAndNext(
			long ACTION_ID, String REFERENCE_NO,
			OrderByComparator<ServiceRequestHistory> orderByComparator)
		throws NoSuchServiceRequestHistoryException {

		REFERENCE_NO = Objects.toString(REFERENCE_NO, "");

		ServiceRequestHistory serviceRequestHistory = findByPrimaryKey(
			ACTION_ID);

		Session session = null;

		try {
			session = openSession();

			ServiceRequestHistory[] array = new ServiceRequestHistoryImpl[3];

			array[0] = getByrefNo_PrevAndNext(
				session, serviceRequestHistory, REFERENCE_NO, orderByComparator,
				true);

			array[1] = serviceRequestHistory;

			array[2] = getByrefNo_PrevAndNext(
				session, serviceRequestHistory, REFERENCE_NO, orderByComparator,
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

	protected ServiceRequestHistory getByrefNo_PrevAndNext(
		Session session, ServiceRequestHistory serviceRequestHistory,
		String REFERENCE_NO,
		OrderByComparator<ServiceRequestHistory> orderByComparator,
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

		sb.append(_SQL_SELECT_SERVICEREQUESTHISTORY_WHERE);

		boolean bindREFERENCE_NO = false;

		if (REFERENCE_NO.isEmpty()) {
			sb.append(_FINDER_COLUMN_REFNO_REFERENCE_NO_3);
		}
		else {
			bindREFERENCE_NO = true;

			sb.append(_FINDER_COLUMN_REFNO_REFERENCE_NO_2);
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
			sb.append(ServiceRequestHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindREFERENCE_NO) {
			queryPos.add(REFERENCE_NO);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						serviceRequestHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ServiceRequestHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service request histories where REFERENCE_NO = &#63; from the database.
	 *
	 * @param REFERENCE_NO the reference_no
	 */
	@Override
	public void removeByrefNo(String REFERENCE_NO) {
		for (ServiceRequestHistory serviceRequestHistory :
				findByrefNo(
					REFERENCE_NO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(serviceRequestHistory);
		}
	}

	/**
	 * Returns the number of service request histories where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @return the number of matching service request histories
	 */
	@Override
	public int countByrefNo(String REFERENCE_NO) {
		REFERENCE_NO = Objects.toString(REFERENCE_NO, "");

		FinderPath finderPath = _finderPathCountByrefNo;

		Object[] finderArgs = new Object[] {REFERENCE_NO};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SERVICEREQUESTHISTORY_WHERE);

			boolean bindREFERENCE_NO = false;

			if (REFERENCE_NO.isEmpty()) {
				sb.append(_FINDER_COLUMN_REFNO_REFERENCE_NO_3);
			}
			else {
				bindREFERENCE_NO = true;

				sb.append(_FINDER_COLUMN_REFNO_REFERENCE_NO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindREFERENCE_NO) {
					queryPos.add(REFERENCE_NO);
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

	private static final String _FINDER_COLUMN_REFNO_REFERENCE_NO_2 =
		"serviceRequestHistory.REFERENCE_NO = ?";

	private static final String _FINDER_COLUMN_REFNO_REFERENCE_NO_3 =
		"(serviceRequestHistory.REFERENCE_NO IS NULL OR serviceRequestHistory.REFERENCE_NO = '')";

	public ServiceRequestHistoryPersistenceImpl() {
		setModelClass(ServiceRequestHistory.class);

		setModelImplClass(ServiceRequestHistoryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the service request history in the entity cache if it is enabled.
	 *
	 * @param serviceRequestHistory the service request history
	 */
	@Override
	public void cacheResult(ServiceRequestHistory serviceRequestHistory) {
		dummyEntityCache.putResult(
			ServiceRequestHistoryImpl.class,
			serviceRequestHistory.getPrimaryKey(), serviceRequestHistory);
	}

	/**
	 * Caches the service request histories in the entity cache if it is enabled.
	 *
	 * @param serviceRequestHistories the service request histories
	 */
	@Override
	public void cacheResult(
		List<ServiceRequestHistory> serviceRequestHistories) {

		for (ServiceRequestHistory serviceRequestHistory :
				serviceRequestHistories) {

			if (dummyEntityCache.getResult(
					ServiceRequestHistoryImpl.class,
					serviceRequestHistory.getPrimaryKey()) == null) {

				cacheResult(serviceRequestHistory);
			}
		}
	}

	/**
	 * Clears the cache for all service request histories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(ServiceRequestHistoryImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the service request history.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServiceRequestHistory serviceRequestHistory) {
		dummyEntityCache.removeResult(
			ServiceRequestHistoryImpl.class, serviceRequestHistory);
	}

	@Override
	public void clearCache(
		List<ServiceRequestHistory> serviceRequestHistories) {

		for (ServiceRequestHistory serviceRequestHistory :
				serviceRequestHistories) {

			dummyEntityCache.removeResult(
				ServiceRequestHistoryImpl.class, serviceRequestHistory);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				ServiceRequestHistoryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new service request history with the primary key. Does not add the service request history to the database.
	 *
	 * @param ACTION_ID the primary key for the new service request history
	 * @return the new service request history
	 */
	@Override
	public ServiceRequestHistory create(long ACTION_ID) {
		ServiceRequestHistory serviceRequestHistory =
			new ServiceRequestHistoryImpl();

		serviceRequestHistory.setNew(true);
		serviceRequestHistory.setPrimaryKey(ACTION_ID);

		return serviceRequestHistory;
	}

	/**
	 * Removes the service request history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ACTION_ID the primary key of the service request history
	 * @return the service request history that was removed
	 * @throws NoSuchServiceRequestHistoryException if a service request history with the primary key could not be found
	 */
	@Override
	public ServiceRequestHistory remove(long ACTION_ID)
		throws NoSuchServiceRequestHistoryException {

		return remove((Serializable)ACTION_ID);
	}

	/**
	 * Removes the service request history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the service request history
	 * @return the service request history that was removed
	 * @throws NoSuchServiceRequestHistoryException if a service request history with the primary key could not be found
	 */
	@Override
	public ServiceRequestHistory remove(Serializable primaryKey)
		throws NoSuchServiceRequestHistoryException {

		Session session = null;

		try {
			session = openSession();

			ServiceRequestHistory serviceRequestHistory =
				(ServiceRequestHistory)session.get(
					ServiceRequestHistoryImpl.class, primaryKey);

			if (serviceRequestHistory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServiceRequestHistoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(serviceRequestHistory);
		}
		catch (NoSuchServiceRequestHistoryException noSuchEntityException) {
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
	protected ServiceRequestHistory removeImpl(
		ServiceRequestHistory serviceRequestHistory) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(serviceRequestHistory)) {
				serviceRequestHistory = (ServiceRequestHistory)session.get(
					ServiceRequestHistoryImpl.class,
					serviceRequestHistory.getPrimaryKeyObj());
			}

			if (serviceRequestHistory != null) {
				session.delete(serviceRequestHistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (serviceRequestHistory != null) {
			clearCache(serviceRequestHistory);
		}

		return serviceRequestHistory;
	}

	@Override
	public ServiceRequestHistory updateImpl(
		ServiceRequestHistory serviceRequestHistory) {

		boolean isNew = serviceRequestHistory.isNew();

		if (!(serviceRequestHistory instanceof
				ServiceRequestHistoryModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(serviceRequestHistory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					serviceRequestHistory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in serviceRequestHistory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ServiceRequestHistory implementation " +
					serviceRequestHistory.getClass());
		}

		ServiceRequestHistoryModelImpl serviceRequestHistoryModelImpl =
			(ServiceRequestHistoryModelImpl)serviceRequestHistory;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(serviceRequestHistory);
			}
			else {
				serviceRequestHistory = (ServiceRequestHistory)session.merge(
					serviceRequestHistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			ServiceRequestHistoryImpl.class, serviceRequestHistoryModelImpl,
			false, true);

		if (isNew) {
			serviceRequestHistory.setNew(false);
		}

		serviceRequestHistory.resetOriginalValues();

		return serviceRequestHistory;
	}

	/**
	 * Returns the service request history with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service request history
	 * @return the service request history
	 * @throws NoSuchServiceRequestHistoryException if a service request history with the primary key could not be found
	 */
	@Override
	public ServiceRequestHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServiceRequestHistoryException {

		ServiceRequestHistory serviceRequestHistory = fetchByPrimaryKey(
			primaryKey);

		if (serviceRequestHistory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServiceRequestHistoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return serviceRequestHistory;
	}

	/**
	 * Returns the service request history with the primary key or throws a <code>NoSuchServiceRequestHistoryException</code> if it could not be found.
	 *
	 * @param ACTION_ID the primary key of the service request history
	 * @return the service request history
	 * @throws NoSuchServiceRequestHistoryException if a service request history with the primary key could not be found
	 */
	@Override
	public ServiceRequestHistory findByPrimaryKey(long ACTION_ID)
		throws NoSuchServiceRequestHistoryException {

		return findByPrimaryKey((Serializable)ACTION_ID);
	}

	/**
	 * Returns the service request history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ACTION_ID the primary key of the service request history
	 * @return the service request history, or <code>null</code> if a service request history with the primary key could not be found
	 */
	@Override
	public ServiceRequestHistory fetchByPrimaryKey(long ACTION_ID) {
		return fetchByPrimaryKey((Serializable)ACTION_ID);
	}

	/**
	 * Returns all the service request histories.
	 *
	 * @return the service request histories
	 */
	@Override
	public List<ServiceRequestHistory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service request histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request histories
	 * @param end the upper bound of the range of service request histories (not inclusive)
	 * @return the range of service request histories
	 */
	@Override
	public List<ServiceRequestHistory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the service request histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request histories
	 * @param end the upper bound of the range of service request histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service request histories
	 */
	@Override
	public List<ServiceRequestHistory> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestHistory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service request histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request histories
	 * @param end the upper bound of the range of service request histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of service request histories
	 */
	@Override
	public List<ServiceRequestHistory> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestHistory> orderByComparator,
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

		List<ServiceRequestHistory> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequestHistory>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SERVICEREQUESTHISTORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICEREQUESTHISTORY;

				sql = sql.concat(ServiceRequestHistoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ServiceRequestHistory>)QueryUtil.list(
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
	 * Removes all the service request histories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ServiceRequestHistory serviceRequestHistory : findAll()) {
			remove(serviceRequestHistory);
		}
	}

	/**
	 * Returns the number of service request histories.
	 *
	 * @return the number of service request histories
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
					_SQL_COUNT_SERVICEREQUESTHISTORY);

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
	protected EntityCache getEntityCache() {
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "ACTION_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SERVICEREQUESTHISTORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ServiceRequestHistoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the service request history persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ServiceRequestHistoryModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ServiceRequestHistory.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByrefNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByrefNo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"REFERENCE_NO"}, true);

		_finderPathWithoutPaginationFindByrefNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByrefNo",
			new String[] {String.class.getName()},
			new String[] {"REFERENCE_NO"}, true);

		_finderPathCountByrefNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByrefNo",
			new String[] {String.class.getName()},
			new String[] {"REFERENCE_NO"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(ServiceRequestHistoryImpl.class.getName());

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

	private static final String _SQL_SELECT_SERVICEREQUESTHISTORY =
		"SELECT serviceRequestHistory FROM ServiceRequestHistory serviceRequestHistory";

	private static final String _SQL_SELECT_SERVICEREQUESTHISTORY_WHERE =
		"SELECT serviceRequestHistory FROM ServiceRequestHistory serviceRequestHistory WHERE ";

	private static final String _SQL_COUNT_SERVICEREQUESTHISTORY =
		"SELECT COUNT(serviceRequestHistory) FROM ServiceRequestHistory serviceRequestHistory";

	private static final String _SQL_COUNT_SERVICEREQUESTHISTORY_WHERE =
		"SELECT COUNT(serviceRequestHistory) FROM ServiceRequestHistory serviceRequestHistory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"serviceRequestHistory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ServiceRequestHistory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ServiceRequestHistory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ServiceRequestHistoryPersistenceImpl.class);

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

	private static class ServiceRequestHistoryModelArgumentsResolver
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

			ServiceRequestHistoryModelImpl serviceRequestHistoryModelImpl =
				(ServiceRequestHistoryModelImpl)baseModel;

			long columnBitmask =
				serviceRequestHistoryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					serviceRequestHistoryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						serviceRequestHistoryModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					serviceRequestHistoryModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ServiceRequestHistoryModelImpl serviceRequestHistoryModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						serviceRequestHistoryModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						serviceRequestHistoryModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}