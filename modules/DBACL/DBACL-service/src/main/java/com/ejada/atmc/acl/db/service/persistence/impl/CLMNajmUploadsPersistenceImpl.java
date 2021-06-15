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

import com.ejada.atmc.acl.db.exception.NoSuchCLMNajmUploadsException;
import com.ejada.atmc.acl.db.model.CLMNajmUploads;
import com.ejada.atmc.acl.db.model.impl.CLMNajmUploadsImpl;
import com.ejada.atmc.acl.db.model.impl.CLMNajmUploadsModelImpl;
import com.ejada.atmc.acl.db.service.persistence.CLMNajmUploadsPersistence;
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
 * The persistence implementation for the clm najm uploads service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CLMNajmUploadsPersistence.class)
public class CLMNajmUploadsPersistenceImpl
	extends BasePersistenceImpl<CLMNajmUploads>
	implements CLMNajmUploadsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CLMNajmUploadsUtil</code> to access the clm najm uploads persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CLMNajmUploadsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByClaimRefNo;
	private FinderPath _finderPathCountByClaimRefNo;

	/**
	 * Returns the clm najm uploads where claimRefNo = &#63; or throws a <code>NoSuchCLMNajmUploadsException</code> if it could not be found.
	 *
	 * @param claimRefNo the claim ref no
	 * @return the matching clm najm uploads
	 * @throws NoSuchCLMNajmUploadsException if a matching clm najm uploads could not be found
	 */
	@Override
	public CLMNajmUploads findByClaimRefNo(String claimRefNo)
		throws NoSuchCLMNajmUploadsException {

		CLMNajmUploads clmNajmUploads = fetchByClaimRefNo(claimRefNo);

		if (clmNajmUploads == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("claimRefNo=");
			sb.append(claimRefNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCLMNajmUploadsException(sb.toString());
		}

		return clmNajmUploads;
	}

	/**
	 * Returns the clm najm uploads where claimRefNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param claimRefNo the claim ref no
	 * @return the matching clm najm uploads, or <code>null</code> if a matching clm najm uploads could not be found
	 */
	@Override
	public CLMNajmUploads fetchByClaimRefNo(String claimRefNo) {
		return fetchByClaimRefNo(claimRefNo, true);
	}

	/**
	 * Returns the clm najm uploads where claimRefNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param claimRefNo the claim ref no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching clm najm uploads, or <code>null</code> if a matching clm najm uploads could not be found
	 */
	@Override
	public CLMNajmUploads fetchByClaimRefNo(
		String claimRefNo, boolean useFinderCache) {

		claimRefNo = Objects.toString(claimRefNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {claimRefNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByClaimRefNo, finderArgs, this);
		}

		if (result instanceof CLMNajmUploads) {
			CLMNajmUploads clmNajmUploads = (CLMNajmUploads)result;

			if (!Objects.equals(claimRefNo, clmNajmUploads.getClaimRefNo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CLMNAJMUPLOADS_WHERE);

			boolean bindClaimRefNo = false;

			if (claimRefNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_CLAIMREFNO_CLAIMREFNO_3);
			}
			else {
				bindClaimRefNo = true;

				sb.append(_FINDER_COLUMN_CLAIMREFNO_CLAIMREFNO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClaimRefNo) {
					queryPos.add(claimRefNo);
				}

				List<CLMNajmUploads> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByClaimRefNo, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {claimRefNo};
							}

							_log.warn(
								"CLMNajmUploadsPersistenceImpl.fetchByClaimRefNo(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CLMNajmUploads clmNajmUploads = list.get(0);

					result = clmNajmUploads;

					cacheResult(clmNajmUploads);
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
			return (CLMNajmUploads)result;
		}
	}

	/**
	 * Removes the clm najm uploads where claimRefNo = &#63; from the database.
	 *
	 * @param claimRefNo the claim ref no
	 * @return the clm najm uploads that was removed
	 */
	@Override
	public CLMNajmUploads removeByClaimRefNo(String claimRefNo)
		throws NoSuchCLMNajmUploadsException {

		CLMNajmUploads clmNajmUploads = findByClaimRefNo(claimRefNo);

		return remove(clmNajmUploads);
	}

	/**
	 * Returns the number of clm najm uploadses where claimRefNo = &#63;.
	 *
	 * @param claimRefNo the claim ref no
	 * @return the number of matching clm najm uploadses
	 */
	@Override
	public int countByClaimRefNo(String claimRefNo) {
		claimRefNo = Objects.toString(claimRefNo, "");

		FinderPath finderPath = _finderPathCountByClaimRefNo;

		Object[] finderArgs = new Object[] {claimRefNo};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLMNAJMUPLOADS_WHERE);

			boolean bindClaimRefNo = false;

			if (claimRefNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_CLAIMREFNO_CLAIMREFNO_3);
			}
			else {
				bindClaimRefNo = true;

				sb.append(_FINDER_COLUMN_CLAIMREFNO_CLAIMREFNO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClaimRefNo) {
					queryPos.add(claimRefNo);
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

	private static final String _FINDER_COLUMN_CLAIMREFNO_CLAIMREFNO_2 =
		"clmNajmUploads.claimRefNo = ?";

	private static final String _FINDER_COLUMN_CLAIMREFNO_CLAIMREFNO_3 =
		"(clmNajmUploads.claimRefNo IS NULL OR clmNajmUploads.claimRefNo = '')";

	public CLMNajmUploadsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "FILE_ID");
		dbColumnNames.put("caseNo", "CASE_NO");
		dbColumnNames.put("cipiId", "CIPI_ID");
		dbColumnNames.put("najmSlip", "NAJM_SLIP");
		dbColumnNames.put("najmSlipName", "NAJM_SLIP_NAME");
		dbColumnNames.put("damageEstQuot", "DAMAGE_EST_QUOT");
		dbColumnNames.put("damageEstQuotName", "DAMAGE_EST_QUOT_NAME");
		dbColumnNames.put("bankIban", "BANK_IBAN");
		dbColumnNames.put("bankIbanName", "BANK_IBAN_NAME");
		dbColumnNames.put("ownerId", "OWNER_ID");
		dbColumnNames.put("ownerIdName", "OWNER_ID_NAME");
		dbColumnNames.put("claimRefNo", "CLAIM_REF_NO");

		setDBColumnNames(dbColumnNames);

		setModelClass(CLMNajmUploads.class);

		setModelImplClass(CLMNajmUploadsImpl.class);
		setModelPKClass(int.class);
	}

	/**
	 * Caches the clm najm uploads in the entity cache if it is enabled.
	 *
	 * @param clmNajmUploads the clm najm uploads
	 */
	@Override
	public void cacheResult(CLMNajmUploads clmNajmUploads) {
		dummyEntityCache.putResult(
			CLMNajmUploadsImpl.class, clmNajmUploads.getPrimaryKey(),
			clmNajmUploads);

		dummyFinderCache.putResult(
			_finderPathFetchByClaimRefNo,
			new Object[] {clmNajmUploads.getClaimRefNo()}, clmNajmUploads);
	}

	/**
	 * Caches the clm najm uploadses in the entity cache if it is enabled.
	 *
	 * @param clmNajmUploadses the clm najm uploadses
	 */
	@Override
	public void cacheResult(List<CLMNajmUploads> clmNajmUploadses) {
		for (CLMNajmUploads clmNajmUploads : clmNajmUploadses) {
			if (dummyEntityCache.getResult(
					CLMNajmUploadsImpl.class, clmNajmUploads.getPrimaryKey()) ==
						null) {

				cacheResult(clmNajmUploads);
			}
		}
	}

	/**
	 * Clears the cache for all clm najm uploadses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(CLMNajmUploadsImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the clm najm uploads.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CLMNajmUploads clmNajmUploads) {
		dummyEntityCache.removeResult(CLMNajmUploadsImpl.class, clmNajmUploads);
	}

	@Override
	public void clearCache(List<CLMNajmUploads> clmNajmUploadses) {
		for (CLMNajmUploads clmNajmUploads : clmNajmUploadses) {
			dummyEntityCache.removeResult(
				CLMNajmUploadsImpl.class, clmNajmUploads);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(CLMNajmUploadsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CLMNajmUploadsModelImpl clmNajmUploadsModelImpl) {

		Object[] args = new Object[] {clmNajmUploadsModelImpl.getClaimRefNo()};

		dummyFinderCache.putResult(
			_finderPathCountByClaimRefNo, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchByClaimRefNo, args, clmNajmUploadsModelImpl, false);
	}

	/**
	 * Creates a new clm najm uploads with the primary key. Does not add the clm najm uploads to the database.
	 *
	 * @param id the primary key for the new clm najm uploads
	 * @return the new clm najm uploads
	 */
	@Override
	public CLMNajmUploads create(int id) {
		CLMNajmUploads clmNajmUploads = new CLMNajmUploadsImpl();

		clmNajmUploads.setNew(true);
		clmNajmUploads.setPrimaryKey(id);

		return clmNajmUploads;
	}

	/**
	 * Removes the clm najm uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the clm najm uploads
	 * @return the clm najm uploads that was removed
	 * @throws NoSuchCLMNajmUploadsException if a clm najm uploads with the primary key could not be found
	 */
	@Override
	public CLMNajmUploads remove(int id) throws NoSuchCLMNajmUploadsException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the clm najm uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the clm najm uploads
	 * @return the clm najm uploads that was removed
	 * @throws NoSuchCLMNajmUploadsException if a clm najm uploads with the primary key could not be found
	 */
	@Override
	public CLMNajmUploads remove(Serializable primaryKey)
		throws NoSuchCLMNajmUploadsException {

		Session session = null;

		try {
			session = openSession();

			CLMNajmUploads clmNajmUploads = (CLMNajmUploads)session.get(
				CLMNajmUploadsImpl.class, primaryKey);

			if (clmNajmUploads == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCLMNajmUploadsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(clmNajmUploads);
		}
		catch (NoSuchCLMNajmUploadsException noSuchEntityException) {
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
	protected CLMNajmUploads removeImpl(CLMNajmUploads clmNajmUploads) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(clmNajmUploads)) {
				clmNajmUploads = (CLMNajmUploads)session.get(
					CLMNajmUploadsImpl.class,
					clmNajmUploads.getPrimaryKeyObj());
			}

			if (clmNajmUploads != null) {
				session.delete(clmNajmUploads);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (clmNajmUploads != null) {
			clearCache(clmNajmUploads);
		}

		return clmNajmUploads;
	}

	@Override
	public CLMNajmUploads updateImpl(CLMNajmUploads clmNajmUploads) {
		boolean isNew = clmNajmUploads.isNew();

		if (!(clmNajmUploads instanceof CLMNajmUploadsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(clmNajmUploads.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					clmNajmUploads);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in clmNajmUploads proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CLMNajmUploads implementation " +
					clmNajmUploads.getClass());
		}

		CLMNajmUploadsModelImpl clmNajmUploadsModelImpl =
			(CLMNajmUploadsModelImpl)clmNajmUploads;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(clmNajmUploads);
			}
			else {
				session.evict(
					CLMNajmUploadsImpl.class,
					clmNajmUploads.getPrimaryKeyObj());

				session.saveOrUpdate(clmNajmUploads);
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
			CLMNajmUploadsImpl.class, clmNajmUploadsModelImpl, false, true);

		cacheUniqueFindersCache(clmNajmUploadsModelImpl);

		if (isNew) {
			clmNajmUploads.setNew(false);
		}

		clmNajmUploads.resetOriginalValues();

		return clmNajmUploads;
	}

	/**
	 * Returns the clm najm uploads with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the clm najm uploads
	 * @return the clm najm uploads
	 * @throws NoSuchCLMNajmUploadsException if a clm najm uploads with the primary key could not be found
	 */
	@Override
	public CLMNajmUploads findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCLMNajmUploadsException {

		CLMNajmUploads clmNajmUploads = fetchByPrimaryKey(primaryKey);

		if (clmNajmUploads == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCLMNajmUploadsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return clmNajmUploads;
	}

	/**
	 * Returns the clm najm uploads with the primary key or throws a <code>NoSuchCLMNajmUploadsException</code> if it could not be found.
	 *
	 * @param id the primary key of the clm najm uploads
	 * @return the clm najm uploads
	 * @throws NoSuchCLMNajmUploadsException if a clm najm uploads with the primary key could not be found
	 */
	@Override
	public CLMNajmUploads findByPrimaryKey(int id)
		throws NoSuchCLMNajmUploadsException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the clm najm uploads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the clm najm uploads
	 * @return the clm najm uploads, or <code>null</code> if a clm najm uploads with the primary key could not be found
	 */
	@Override
	public CLMNajmUploads fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the clm najm uploadses.
	 *
	 * @return the clm najm uploadses
	 */
	@Override
	public List<CLMNajmUploads> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clm najm uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clm najm uploadses
	 * @param end the upper bound of the range of clm najm uploadses (not inclusive)
	 * @return the range of clm najm uploadses
	 */
	@Override
	public List<CLMNajmUploads> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the clm najm uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clm najm uploadses
	 * @param end the upper bound of the range of clm najm uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clm najm uploadses
	 */
	@Override
	public List<CLMNajmUploads> findAll(
		int start, int end,
		OrderByComparator<CLMNajmUploads> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the clm najm uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clm najm uploadses
	 * @param end the upper bound of the range of clm najm uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of clm najm uploadses
	 */
	@Override
	public List<CLMNajmUploads> findAll(
		int start, int end, OrderByComparator<CLMNajmUploads> orderByComparator,
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

		List<CLMNajmUploads> list = null;

		if (useFinderCache) {
			list = (List<CLMNajmUploads>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CLMNAJMUPLOADS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CLMNAJMUPLOADS;

				sql = sql.concat(CLMNajmUploadsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CLMNajmUploads>)QueryUtil.list(
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
	 * Removes all the clm najm uploadses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CLMNajmUploads clmNajmUploads : findAll()) {
			remove(clmNajmUploads);
		}
	}

	/**
	 * Returns the number of clm najm uploadses.
	 *
	 * @return the number of clm najm uploadses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CLMNAJMUPLOADS);

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
		return "FILE_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLMNAJMUPLOADS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CLMNajmUploadsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the clm najm uploads persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CLMNajmUploadsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CLMNajmUploads.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByClaimRefNo = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByClaimRefNo",
			new String[] {String.class.getName()},
			new String[] {"CLAIM_REF_NO"}, true);

		_finderPathCountByClaimRefNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClaimRefNo",
			new String[] {String.class.getName()},
			new String[] {"CLAIM_REF_NO"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(CLMNajmUploadsImpl.class.getName());

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

	private static final String _SQL_SELECT_CLMNAJMUPLOADS =
		"SELECT clmNajmUploads FROM CLMNajmUploads clmNajmUploads";

	private static final String _SQL_SELECT_CLMNAJMUPLOADS_WHERE =
		"SELECT clmNajmUploads FROM CLMNajmUploads clmNajmUploads WHERE ";

	private static final String _SQL_COUNT_CLMNAJMUPLOADS =
		"SELECT COUNT(clmNajmUploads) FROM CLMNajmUploads clmNajmUploads";

	private static final String _SQL_COUNT_CLMNAJMUPLOADS_WHERE =
		"SELECT COUNT(clmNajmUploads) FROM CLMNajmUploads clmNajmUploads WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "clmNajmUploads.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CLMNajmUploads exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CLMNajmUploads exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CLMNajmUploadsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"id", "caseNo", "cipiId", "najmSlip", "najmSlipName",
			"damageEstQuot", "damageEstQuotName", "bankIban", "bankIbanName",
			"ownerId", "ownerIdName", "claimRefNo"
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

	private static class CLMNajmUploadsModelArgumentsResolver
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

			CLMNajmUploadsModelImpl clmNajmUploadsModelImpl =
				(CLMNajmUploadsModelImpl)baseModel;

			long columnBitmask = clmNajmUploadsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					clmNajmUploadsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						clmNajmUploadsModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					clmNajmUploadsModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			CLMNajmUploadsModelImpl clmNajmUploadsModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						clmNajmUploadsModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = clmNajmUploadsModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}