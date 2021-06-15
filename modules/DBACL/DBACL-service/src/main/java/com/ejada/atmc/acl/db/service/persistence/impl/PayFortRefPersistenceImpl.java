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

import com.ejada.atmc.acl.db.exception.NoSuchPayFortRefException;
import com.ejada.atmc.acl.db.model.PayFortRef;
import com.ejada.atmc.acl.db.model.impl.PayFortRefImpl;
import com.ejada.atmc.acl.db.model.impl.PayFortRefModelImpl;
import com.ejada.atmc.acl.db.service.persistence.PayFortRefPersistence;
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
 * The persistence implementation for the pay fort ref service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PayFortRefPersistence.class)
public class PayFortRefPersistenceImpl
	extends BasePersistenceImpl<PayFortRef> implements PayFortRefPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PayFortRefUtil</code> to access the pay fort ref persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PayFortRefImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByrefNoStatus;
	private FinderPath _finderPathCountByrefNoStatus;

	/**
	 * Returns the pay fort ref where payFortRefNo = &#63; and status = &#63; or throws a <code>NoSuchPayFortRefException</code> if it could not be found.
	 *
	 * @param payFortRefNo the pay fort ref no
	 * @param status the status
	 * @return the matching pay fort ref
	 * @throws NoSuchPayFortRefException if a matching pay fort ref could not be found
	 */
	@Override
	public PayFortRef findByrefNoStatus(String payFortRefNo, String status)
		throws NoSuchPayFortRefException {

		PayFortRef payFortRef = fetchByrefNoStatus(payFortRefNo, status);

		if (payFortRef == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("payFortRefNo=");
			sb.append(payFortRefNo);

			sb.append(", status=");
			sb.append(status);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPayFortRefException(sb.toString());
		}

		return payFortRef;
	}

	/**
	 * Returns the pay fort ref where payFortRefNo = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param payFortRefNo the pay fort ref no
	 * @param status the status
	 * @return the matching pay fort ref, or <code>null</code> if a matching pay fort ref could not be found
	 */
	@Override
	public PayFortRef fetchByrefNoStatus(String payFortRefNo, String status) {
		return fetchByrefNoStatus(payFortRefNo, status, true);
	}

	/**
	 * Returns the pay fort ref where payFortRefNo = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param payFortRefNo the pay fort ref no
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pay fort ref, or <code>null</code> if a matching pay fort ref could not be found
	 */
	@Override
	public PayFortRef fetchByrefNoStatus(
		String payFortRefNo, String status, boolean useFinderCache) {

		payFortRefNo = Objects.toString(payFortRefNo, "");
		status = Objects.toString(status, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {payFortRefNo, status};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByrefNoStatus, finderArgs, this);
		}

		if (result instanceof PayFortRef) {
			PayFortRef payFortRef = (PayFortRef)result;

			if (!Objects.equals(payFortRefNo, payFortRef.getPayFortRefNo()) ||
				!Objects.equals(status, payFortRef.getStatus())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PAYFORTREF_WHERE);

			boolean bindPayFortRefNo = false;

			if (payFortRefNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_REFNOSTATUS_PAYFORTREFNO_3);
			}
			else {
				bindPayFortRefNo = true;

				sb.append(_FINDER_COLUMN_REFNOSTATUS_PAYFORTREFNO_2);
			}

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_REFNOSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_REFNOSTATUS_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPayFortRefNo) {
					queryPos.add(payFortRefNo);
				}

				if (bindStatus) {
					queryPos.add(status);
				}

				List<PayFortRef> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByrefNoStatus, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									payFortRefNo, status
								};
							}

							_log.warn(
								"PayFortRefPersistenceImpl.fetchByrefNoStatus(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PayFortRef payFortRef = list.get(0);

					result = payFortRef;

					cacheResult(payFortRef);
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
			return (PayFortRef)result;
		}
	}

	/**
	 * Removes the pay fort ref where payFortRefNo = &#63; and status = &#63; from the database.
	 *
	 * @param payFortRefNo the pay fort ref no
	 * @param status the status
	 * @return the pay fort ref that was removed
	 */
	@Override
	public PayFortRef removeByrefNoStatus(String payFortRefNo, String status)
		throws NoSuchPayFortRefException {

		PayFortRef payFortRef = findByrefNoStatus(payFortRefNo, status);

		return remove(payFortRef);
	}

	/**
	 * Returns the number of pay fort refs where payFortRefNo = &#63; and status = &#63;.
	 *
	 * @param payFortRefNo the pay fort ref no
	 * @param status the status
	 * @return the number of matching pay fort refs
	 */
	@Override
	public int countByrefNoStatus(String payFortRefNo, String status) {
		payFortRefNo = Objects.toString(payFortRefNo, "");
		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountByrefNoStatus;

		Object[] finderArgs = new Object[] {payFortRefNo, status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PAYFORTREF_WHERE);

			boolean bindPayFortRefNo = false;

			if (payFortRefNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_REFNOSTATUS_PAYFORTREFNO_3);
			}
			else {
				bindPayFortRefNo = true;

				sb.append(_FINDER_COLUMN_REFNOSTATUS_PAYFORTREFNO_2);
			}

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_REFNOSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_REFNOSTATUS_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPayFortRefNo) {
					queryPos.add(payFortRefNo);
				}

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

	private static final String _FINDER_COLUMN_REFNOSTATUS_PAYFORTREFNO_2 =
		"payFortRef.payFortRefNo = ? AND ";

	private static final String _FINDER_COLUMN_REFNOSTATUS_PAYFORTREFNO_3 =
		"(payFortRef.payFortRefNo IS NULL OR payFortRef.payFortRefNo = '') AND ";

	private static final String _FINDER_COLUMN_REFNOSTATUS_STATUS_2 =
		"payFortRef.status = ?";

	private static final String _FINDER_COLUMN_REFNOSTATUS_STATUS_3 =
		"(payFortRef.status IS NULL OR payFortRef.status = '')";

	public PayFortRefPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "Id");
		dbColumnNames.put("iqama_id", "IQAMA_ID");
		dbColumnNames.put("payFortRefNo", "PAYFORT_REF_NO");
		dbColumnNames.put("status", "STATUS");

		setDBColumnNames(dbColumnNames);

		setModelClass(PayFortRef.class);

		setModelImplClass(PayFortRefImpl.class);
		setModelPKClass(int.class);
	}

	/**
	 * Caches the pay fort ref in the entity cache if it is enabled.
	 *
	 * @param payFortRef the pay fort ref
	 */
	@Override
	public void cacheResult(PayFortRef payFortRef) {
		dummyEntityCache.putResult(
			PayFortRefImpl.class, payFortRef.getPrimaryKey(), payFortRef);

		dummyFinderCache.putResult(
			_finderPathFetchByrefNoStatus,
			new Object[] {payFortRef.getPayFortRefNo(), payFortRef.getStatus()},
			payFortRef);
	}

	/**
	 * Caches the pay fort refs in the entity cache if it is enabled.
	 *
	 * @param payFortRefs the pay fort refs
	 */
	@Override
	public void cacheResult(List<PayFortRef> payFortRefs) {
		for (PayFortRef payFortRef : payFortRefs) {
			if (dummyEntityCache.getResult(
					PayFortRefImpl.class, payFortRef.getPrimaryKey()) == null) {

				cacheResult(payFortRef);
			}
		}
	}

	/**
	 * Clears the cache for all pay fort refs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(PayFortRefImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pay fort ref.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PayFortRef payFortRef) {
		dummyEntityCache.removeResult(PayFortRefImpl.class, payFortRef);
	}

	@Override
	public void clearCache(List<PayFortRef> payFortRefs) {
		for (PayFortRef payFortRef : payFortRefs) {
			dummyEntityCache.removeResult(PayFortRefImpl.class, payFortRef);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(PayFortRefImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PayFortRefModelImpl payFortRefModelImpl) {

		Object[] args = new Object[] {
			payFortRefModelImpl.getPayFortRefNo(),
			payFortRefModelImpl.getStatus()
		};

		dummyFinderCache.putResult(
			_finderPathCountByrefNoStatus, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchByrefNoStatus, args, payFortRefModelImpl, false);
	}

	/**
	 * Creates a new pay fort ref with the primary key. Does not add the pay fort ref to the database.
	 *
	 * @param id the primary key for the new pay fort ref
	 * @return the new pay fort ref
	 */
	@Override
	public PayFortRef create(int id) {
		PayFortRef payFortRef = new PayFortRefImpl();

		payFortRef.setNew(true);
		payFortRef.setPrimaryKey(id);

		return payFortRef;
	}

	/**
	 * Removes the pay fort ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the pay fort ref
	 * @return the pay fort ref that was removed
	 * @throws NoSuchPayFortRefException if a pay fort ref with the primary key could not be found
	 */
	@Override
	public PayFortRef remove(int id) throws NoSuchPayFortRefException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the pay fort ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pay fort ref
	 * @return the pay fort ref that was removed
	 * @throws NoSuchPayFortRefException if a pay fort ref with the primary key could not be found
	 */
	@Override
	public PayFortRef remove(Serializable primaryKey)
		throws NoSuchPayFortRefException {

		Session session = null;

		try {
			session = openSession();

			PayFortRef payFortRef = (PayFortRef)session.get(
				PayFortRefImpl.class, primaryKey);

			if (payFortRef == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPayFortRefException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(payFortRef);
		}
		catch (NoSuchPayFortRefException noSuchEntityException) {
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
	protected PayFortRef removeImpl(PayFortRef payFortRef) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(payFortRef)) {
				payFortRef = (PayFortRef)session.get(
					PayFortRefImpl.class, payFortRef.getPrimaryKeyObj());
			}

			if (payFortRef != null) {
				session.delete(payFortRef);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (payFortRef != null) {
			clearCache(payFortRef);
		}

		return payFortRef;
	}

	@Override
	public PayFortRef updateImpl(PayFortRef payFortRef) {
		boolean isNew = payFortRef.isNew();

		if (!(payFortRef instanceof PayFortRefModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(payFortRef.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(payFortRef);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in payFortRef proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PayFortRef implementation " +
					payFortRef.getClass());
		}

		PayFortRefModelImpl payFortRefModelImpl =
			(PayFortRefModelImpl)payFortRef;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(payFortRef);
			}
			else {
				payFortRef = (PayFortRef)session.merge(payFortRef);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			PayFortRefImpl.class, payFortRefModelImpl, false, true);

		cacheUniqueFindersCache(payFortRefModelImpl);

		if (isNew) {
			payFortRef.setNew(false);
		}

		payFortRef.resetOriginalValues();

		return payFortRef;
	}

	/**
	 * Returns the pay fort ref with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pay fort ref
	 * @return the pay fort ref
	 * @throws NoSuchPayFortRefException if a pay fort ref with the primary key could not be found
	 */
	@Override
	public PayFortRef findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPayFortRefException {

		PayFortRef payFortRef = fetchByPrimaryKey(primaryKey);

		if (payFortRef == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPayFortRefException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return payFortRef;
	}

	/**
	 * Returns the pay fort ref with the primary key or throws a <code>NoSuchPayFortRefException</code> if it could not be found.
	 *
	 * @param id the primary key of the pay fort ref
	 * @return the pay fort ref
	 * @throws NoSuchPayFortRefException if a pay fort ref with the primary key could not be found
	 */
	@Override
	public PayFortRef findByPrimaryKey(int id)
		throws NoSuchPayFortRefException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the pay fort ref with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the pay fort ref
	 * @return the pay fort ref, or <code>null</code> if a pay fort ref with the primary key could not be found
	 */
	@Override
	public PayFortRef fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the pay fort refs.
	 *
	 * @return the pay fort refs
	 */
	@Override
	public List<PayFortRef> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pay fort refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayFortRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay fort refs
	 * @param end the upper bound of the range of pay fort refs (not inclusive)
	 * @return the range of pay fort refs
	 */
	@Override
	public List<PayFortRef> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pay fort refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayFortRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay fort refs
	 * @param end the upper bound of the range of pay fort refs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pay fort refs
	 */
	@Override
	public List<PayFortRef> findAll(
		int start, int end, OrderByComparator<PayFortRef> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pay fort refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayFortRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay fort refs
	 * @param end the upper bound of the range of pay fort refs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pay fort refs
	 */
	@Override
	public List<PayFortRef> findAll(
		int start, int end, OrderByComparator<PayFortRef> orderByComparator,
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

		List<PayFortRef> list = null;

		if (useFinderCache) {
			list = (List<PayFortRef>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PAYFORTREF);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PAYFORTREF;

				sql = sql.concat(PayFortRefModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PayFortRef>)QueryUtil.list(
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
	 * Removes all the pay fort refs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PayFortRef payFortRef : findAll()) {
			remove(payFortRef);
		}
	}

	/**
	 * Returns the number of pay fort refs.
	 *
	 * @return the number of pay fort refs
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PAYFORTREF);

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
		return "Id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PAYFORTREF;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PayFortRefModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pay fort ref persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PayFortRefModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PayFortRef.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByrefNoStatus = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByrefNoStatus",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"PAYFORT_REF_NO", "STATUS"}, true);

		_finderPathCountByrefNoStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByrefNoStatus",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"PAYFORT_REF_NO", "STATUS"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(PayFortRefImpl.class.getName());

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

	private static final String _SQL_SELECT_PAYFORTREF =
		"SELECT payFortRef FROM PayFortRef payFortRef";

	private static final String _SQL_SELECT_PAYFORTREF_WHERE =
		"SELECT payFortRef FROM PayFortRef payFortRef WHERE ";

	private static final String _SQL_COUNT_PAYFORTREF =
		"SELECT COUNT(payFortRef) FROM PayFortRef payFortRef";

	private static final String _SQL_COUNT_PAYFORTREF_WHERE =
		"SELECT COUNT(payFortRef) FROM PayFortRef payFortRef WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "payFortRef.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PayFortRef exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PayFortRef exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PayFortRefPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "iqama_id", "payFortRefNo", "status"});

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

	private static class PayFortRefModelArgumentsResolver
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

			PayFortRefModelImpl payFortRefModelImpl =
				(PayFortRefModelImpl)baseModel;

			long columnBitmask = payFortRefModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(payFortRefModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						payFortRefModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(payFortRefModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PayFortRefModelImpl payFortRefModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = payFortRefModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = payFortRefModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}