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

import com.ejada.atmc.acl.db.exception.NoSuchCustUploadsException;
import com.ejada.atmc.acl.db.model.CustUploads;
import com.ejada.atmc.acl.db.model.impl.CustUploadsImpl;
import com.ejada.atmc.acl.db.model.impl.CustUploadsModelImpl;
import com.ejada.atmc.acl.db.service.persistence.CustUploadsPersistence;
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
 * The persistence implementation for the cust uploads service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CustUploadsPersistence.class)
public class CustUploadsPersistenceImpl
	extends BasePersistenceImpl<CustUploads> implements CustUploadsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CustUploadsUtil</code> to access the cust uploads persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CustUploadsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByquotId;
	private FinderPath _finderPathCountByquotId;

	/**
	 * Returns the cust uploads where quotId = &#63; or throws a <code>NoSuchCustUploadsException</code> if it could not be found.
	 *
	 * @param quotId the quot ID
	 * @return the matching cust uploads
	 * @throws NoSuchCustUploadsException if a matching cust uploads could not be found
	 */
	@Override
	public CustUploads findByquotId(String quotId)
		throws NoSuchCustUploadsException {

		CustUploads custUploads = fetchByquotId(quotId);

		if (custUploads == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("quotId=");
			sb.append(quotId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCustUploadsException(sb.toString());
		}

		return custUploads;
	}

	/**
	 * Returns the cust uploads where quotId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quotId the quot ID
	 * @return the matching cust uploads, or <code>null</code> if a matching cust uploads could not be found
	 */
	@Override
	public CustUploads fetchByquotId(String quotId) {
		return fetchByquotId(quotId, true);
	}

	/**
	 * Returns the cust uploads where quotId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quotId the quot ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cust uploads, or <code>null</code> if a matching cust uploads could not be found
	 */
	@Override
	public CustUploads fetchByquotId(String quotId, boolean useFinderCache) {
		quotId = Objects.toString(quotId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {quotId};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByquotId, finderArgs, this);
		}

		if (result instanceof CustUploads) {
			CustUploads custUploads = (CustUploads)result;

			if (!Objects.equals(quotId, custUploads.getQuotId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CUSTUPLOADS_WHERE);

			boolean bindQuotId = false;

			if (quotId.isEmpty()) {
				sb.append(_FINDER_COLUMN_QUOTID_QUOTID_3);
			}
			else {
				bindQuotId = true;

				sb.append(_FINDER_COLUMN_QUOTID_QUOTID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindQuotId) {
					queryPos.add(quotId);
				}

				List<CustUploads> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByquotId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {quotId};
							}

							_log.warn(
								"CustUploadsPersistenceImpl.fetchByquotId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CustUploads custUploads = list.get(0);

					result = custUploads;

					cacheResult(custUploads);
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
			return (CustUploads)result;
		}
	}

	/**
	 * Removes the cust uploads where quotId = &#63; from the database.
	 *
	 * @param quotId the quot ID
	 * @return the cust uploads that was removed
	 */
	@Override
	public CustUploads removeByquotId(String quotId)
		throws NoSuchCustUploadsException {

		CustUploads custUploads = findByquotId(quotId);

		return remove(custUploads);
	}

	/**
	 * Returns the number of cust uploadses where quotId = &#63;.
	 *
	 * @param quotId the quot ID
	 * @return the number of matching cust uploadses
	 */
	@Override
	public int countByquotId(String quotId) {
		quotId = Objects.toString(quotId, "");

		FinderPath finderPath = _finderPathCountByquotId;

		Object[] finderArgs = new Object[] {quotId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CUSTUPLOADS_WHERE);

			boolean bindQuotId = false;

			if (quotId.isEmpty()) {
				sb.append(_FINDER_COLUMN_QUOTID_QUOTID_3);
			}
			else {
				bindQuotId = true;

				sb.append(_FINDER_COLUMN_QUOTID_QUOTID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindQuotId) {
					queryPos.add(quotId);
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

	private static final String _FINDER_COLUMN_QUOTID_QUOTID_2 =
		"custUploads.quotId = ?";

	private static final String _FINDER_COLUMN_QUOTID_QUOTID_3 =
		"(custUploads.quotId IS NULL OR custUploads.quotId = '')";

	public CustUploadsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "ID");
		dbColumnNames.put("quotId", "QUOTATION_ID");
		dbColumnNames.put("idFile", "ID_FILE");
		dbColumnNames.put("licenseFile", "LICENSE_FILE");
		dbColumnNames.put("istCardFile", "IST_CARD_FILE");
		dbColumnNames.put("carFrontFile", "CAR_FRONT_FILE");
		dbColumnNames.put("carBackFile", "CAR_BACK_FILE");
		dbColumnNames.put("carLeftFile", "CAR_LEFT_FILE");
		dbColumnNames.put("carRightFile", "CAR_RIGHT_FILE");
		dbColumnNames.put("engChassisNoFile", "ENG_CHASSIS_NO_FILE");
		dbColumnNames.put("leaseFile", "LEASE_FILE");
		dbColumnNames.put("idFileName", "ID_FILE_NAME");
		dbColumnNames.put("licenseFileName", "LICENSE_FILE_NANE");
		dbColumnNames.put("istCardFileName", "IST_CARD_FILE_NAME");
		dbColumnNames.put("carFrontFileName", "CAR_FRONT_FILE_NAME");
		dbColumnNames.put("carBackFileName", "CAR_BACK_FILE_NAME");
		dbColumnNames.put("carLeftFileName", "CAR_LEFT_FILE_NAME");
		dbColumnNames.put("carRightFileName", "CAR_RIGHT_FILE_NAME");
		dbColumnNames.put("engChassisNoFileName", "ENG_CHASSIS_NO_FILE_NAME");
		dbColumnNames.put("leaseFileName", "LEASE_FILE_NAME");

		setDBColumnNames(dbColumnNames);

		setModelClass(CustUploads.class);

		setModelImplClass(CustUploadsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the cust uploads in the entity cache if it is enabled.
	 *
	 * @param custUploads the cust uploads
	 */
	@Override
	public void cacheResult(CustUploads custUploads) {
		dummyEntityCache.putResult(
			CustUploadsImpl.class, custUploads.getPrimaryKey(), custUploads);

		dummyFinderCache.putResult(
			_finderPathFetchByquotId, new Object[] {custUploads.getQuotId()},
			custUploads);
	}

	/**
	 * Caches the cust uploadses in the entity cache if it is enabled.
	 *
	 * @param custUploadses the cust uploadses
	 */
	@Override
	public void cacheResult(List<CustUploads> custUploadses) {
		for (CustUploads custUploads : custUploadses) {
			if (dummyEntityCache.getResult(
					CustUploadsImpl.class, custUploads.getPrimaryKey()) ==
						null) {

				cacheResult(custUploads);
			}
		}
	}

	/**
	 * Clears the cache for all cust uploadses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(CustUploadsImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cust uploads.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CustUploads custUploads) {
		dummyEntityCache.removeResult(CustUploadsImpl.class, custUploads);
	}

	@Override
	public void clearCache(List<CustUploads> custUploadses) {
		for (CustUploads custUploads : custUploadses) {
			dummyEntityCache.removeResult(CustUploadsImpl.class, custUploads);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(CustUploadsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CustUploadsModelImpl custUploadsModelImpl) {

		Object[] args = new Object[] {custUploadsModelImpl.getQuotId()};

		dummyFinderCache.putResult(
			_finderPathCountByquotId, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchByquotId, args, custUploadsModelImpl, false);
	}

	/**
	 * Creates a new cust uploads with the primary key. Does not add the cust uploads to the database.
	 *
	 * @param id the primary key for the new cust uploads
	 * @return the new cust uploads
	 */
	@Override
	public CustUploads create(long id) {
		CustUploads custUploads = new CustUploadsImpl();

		custUploads.setNew(true);
		custUploads.setPrimaryKey(id);

		return custUploads;
	}

	/**
	 * Removes the cust uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cust uploads
	 * @return the cust uploads that was removed
	 * @throws NoSuchCustUploadsException if a cust uploads with the primary key could not be found
	 */
	@Override
	public CustUploads remove(long id) throws NoSuchCustUploadsException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the cust uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cust uploads
	 * @return the cust uploads that was removed
	 * @throws NoSuchCustUploadsException if a cust uploads with the primary key could not be found
	 */
	@Override
	public CustUploads remove(Serializable primaryKey)
		throws NoSuchCustUploadsException {

		Session session = null;

		try {
			session = openSession();

			CustUploads custUploads = (CustUploads)session.get(
				CustUploadsImpl.class, primaryKey);

			if (custUploads == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustUploadsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(custUploads);
		}
		catch (NoSuchCustUploadsException noSuchEntityException) {
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
	protected CustUploads removeImpl(CustUploads custUploads) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(custUploads)) {
				custUploads = (CustUploads)session.get(
					CustUploadsImpl.class, custUploads.getPrimaryKeyObj());
			}

			if (custUploads != null) {
				session.delete(custUploads);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (custUploads != null) {
			clearCache(custUploads);
		}

		return custUploads;
	}

	@Override
	public CustUploads updateImpl(CustUploads custUploads) {
		boolean isNew = custUploads.isNew();

		if (!(custUploads instanceof CustUploadsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(custUploads.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(custUploads);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in custUploads proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CustUploads implementation " +
					custUploads.getClass());
		}

		CustUploadsModelImpl custUploadsModelImpl =
			(CustUploadsModelImpl)custUploads;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(custUploads);
			}
			else {
				session.evict(
					CustUploadsImpl.class, custUploads.getPrimaryKeyObj());

				session.saveOrUpdate(custUploads);
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
			CustUploadsImpl.class, custUploadsModelImpl, false, true);

		cacheUniqueFindersCache(custUploadsModelImpl);

		if (isNew) {
			custUploads.setNew(false);
		}

		custUploads.resetOriginalValues();

		return custUploads;
	}

	/**
	 * Returns the cust uploads with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cust uploads
	 * @return the cust uploads
	 * @throws NoSuchCustUploadsException if a cust uploads with the primary key could not be found
	 */
	@Override
	public CustUploads findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustUploadsException {

		CustUploads custUploads = fetchByPrimaryKey(primaryKey);

		if (custUploads == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustUploadsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return custUploads;
	}

	/**
	 * Returns the cust uploads with the primary key or throws a <code>NoSuchCustUploadsException</code> if it could not be found.
	 *
	 * @param id the primary key of the cust uploads
	 * @return the cust uploads
	 * @throws NoSuchCustUploadsException if a cust uploads with the primary key could not be found
	 */
	@Override
	public CustUploads findByPrimaryKey(long id)
		throws NoSuchCustUploadsException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the cust uploads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cust uploads
	 * @return the cust uploads, or <code>null</code> if a cust uploads with the primary key could not be found
	 */
	@Override
	public CustUploads fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the cust uploadses.
	 *
	 * @return the cust uploadses
	 */
	@Override
	public List<CustUploads> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cust uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cust uploadses
	 * @param end the upper bound of the range of cust uploadses (not inclusive)
	 * @return the range of cust uploadses
	 */
	@Override
	public List<CustUploads> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cust uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cust uploadses
	 * @param end the upper bound of the range of cust uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cust uploadses
	 */
	@Override
	public List<CustUploads> findAll(
		int start, int end, OrderByComparator<CustUploads> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cust uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cust uploadses
	 * @param end the upper bound of the range of cust uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cust uploadses
	 */
	@Override
	public List<CustUploads> findAll(
		int start, int end, OrderByComparator<CustUploads> orderByComparator,
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

		List<CustUploads> list = null;

		if (useFinderCache) {
			list = (List<CustUploads>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CUSTUPLOADS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTUPLOADS;

				sql = sql.concat(CustUploadsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CustUploads>)QueryUtil.list(
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
	 * Removes all the cust uploadses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CustUploads custUploads : findAll()) {
			remove(custUploads);
		}
	}

	/**
	 * Returns the number of cust uploadses.
	 *
	 * @return the number of cust uploadses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CUSTUPLOADS);

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
		return "ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CUSTUPLOADS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CustUploadsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cust uploads persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CustUploadsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CustUploads.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByquotId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByquotId",
			new String[] {String.class.getName()},
			new String[] {"QUOTATION_ID"}, true);

		_finderPathCountByquotId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByquotId",
			new String[] {String.class.getName()},
			new String[] {"QUOTATION_ID"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(CustUploadsImpl.class.getName());

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

	private static final String _SQL_SELECT_CUSTUPLOADS =
		"SELECT custUploads FROM CustUploads custUploads";

	private static final String _SQL_SELECT_CUSTUPLOADS_WHERE =
		"SELECT custUploads FROM CustUploads custUploads WHERE ";

	private static final String _SQL_COUNT_CUSTUPLOADS =
		"SELECT COUNT(custUploads) FROM CustUploads custUploads";

	private static final String _SQL_COUNT_CUSTUPLOADS_WHERE =
		"SELECT COUNT(custUploads) FROM CustUploads custUploads WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "custUploads.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CustUploads exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CustUploads exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CustUploadsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"id", "quotId", "idFile", "licenseFile", "istCardFile",
			"carFrontFile", "carBackFile", "carLeftFile", "carRightFile",
			"engChassisNoFile", "leaseFile", "idFileName", "licenseFileName",
			"istCardFileName", "carFrontFileName", "carBackFileName",
			"carLeftFileName", "carRightFileName", "engChassisNoFileName",
			"leaseFileName"
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

	private static class CustUploadsModelArgumentsResolver
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

			CustUploadsModelImpl custUploadsModelImpl =
				(CustUploadsModelImpl)baseModel;

			long columnBitmask = custUploadsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(custUploadsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						custUploadsModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(custUploadsModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			CustUploadsModelImpl custUploadsModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = custUploadsModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = custUploadsModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}