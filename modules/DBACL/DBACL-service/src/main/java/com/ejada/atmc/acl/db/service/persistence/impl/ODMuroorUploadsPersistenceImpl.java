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

import com.ejada.atmc.acl.db.exception.NoSuchODMuroorUploadsException;
import com.ejada.atmc.acl.db.model.ODMuroorUploads;
import com.ejada.atmc.acl.db.model.impl.ODMuroorUploadsImpl;
import com.ejada.atmc.acl.db.model.impl.ODMuroorUploadsModelImpl;
import com.ejada.atmc.acl.db.service.persistence.ODMuroorUploadsPersistence;
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
 * The persistence implementation for the od muroor uploads service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ODMuroorUploadsPersistence.class)
public class ODMuroorUploadsPersistenceImpl
	extends BasePersistenceImpl<ODMuroorUploads>
	implements ODMuroorUploadsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ODMuroorUploadsUtil</code> to access the od muroor uploads persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ODMuroorUploadsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByclaimIntimationNo;
	private FinderPath _finderPathCountByclaimIntimationNo;

	/**
	 * Returns the od muroor uploads where claimIntimationNo = &#63; or throws a <code>NoSuchODMuroorUploadsException</code> if it could not be found.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the matching od muroor uploads
	 * @throws NoSuchODMuroorUploadsException if a matching od muroor uploads could not be found
	 */
	@Override
	public ODMuroorUploads findByclaimIntimationNo(String claimIntimationNo)
		throws NoSuchODMuroorUploadsException {

		ODMuroorUploads odMuroorUploads = fetchByclaimIntimationNo(
			claimIntimationNo);

		if (odMuroorUploads == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("claimIntimationNo=");
			sb.append(claimIntimationNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchODMuroorUploadsException(sb.toString());
		}

		return odMuroorUploads;
	}

	/**
	 * Returns the od muroor uploads where claimIntimationNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the matching od muroor uploads, or <code>null</code> if a matching od muroor uploads could not be found
	 */
	@Override
	public ODMuroorUploads fetchByclaimIntimationNo(String claimIntimationNo) {
		return fetchByclaimIntimationNo(claimIntimationNo, true);
	}

	/**
	 * Returns the od muroor uploads where claimIntimationNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching od muroor uploads, or <code>null</code> if a matching od muroor uploads could not be found
	 */
	@Override
	public ODMuroorUploads fetchByclaimIntimationNo(
		String claimIntimationNo, boolean useFinderCache) {

		claimIntimationNo = Objects.toString(claimIntimationNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {claimIntimationNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByclaimIntimationNo, finderArgs, this);
		}

		if (result instanceof ODMuroorUploads) {
			ODMuroorUploads odMuroorUploads = (ODMuroorUploads)result;

			if (!Objects.equals(
					claimIntimationNo,
					odMuroorUploads.getClaimIntimationNo())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_ODMUROORUPLOADS_WHERE);

			boolean bindClaimIntimationNo = false;

			if (claimIntimationNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_CLAIMINTIMATIONNO_CLAIMINTIMATIONNO_3);
			}
			else {
				bindClaimIntimationNo = true;

				sb.append(_FINDER_COLUMN_CLAIMINTIMATIONNO_CLAIMINTIMATIONNO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClaimIntimationNo) {
					queryPos.add(claimIntimationNo);
				}

				List<ODMuroorUploads> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByclaimIntimationNo, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {claimIntimationNo};
							}

							_log.warn(
								"ODMuroorUploadsPersistenceImpl.fetchByclaimIntimationNo(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ODMuroorUploads odMuroorUploads = list.get(0);

					result = odMuroorUploads;

					cacheResult(odMuroorUploads);
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
			return (ODMuroorUploads)result;
		}
	}

	/**
	 * Removes the od muroor uploads where claimIntimationNo = &#63; from the database.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the od muroor uploads that was removed
	 */
	@Override
	public ODMuroorUploads removeByclaimIntimationNo(String claimIntimationNo)
		throws NoSuchODMuroorUploadsException {

		ODMuroorUploads odMuroorUploads = findByclaimIntimationNo(
			claimIntimationNo);

		return remove(odMuroorUploads);
	}

	/**
	 * Returns the number of od muroor uploadses where claimIntimationNo = &#63;.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the number of matching od muroor uploadses
	 */
	@Override
	public int countByclaimIntimationNo(String claimIntimationNo) {
		claimIntimationNo = Objects.toString(claimIntimationNo, "");

		FinderPath finderPath = _finderPathCountByclaimIntimationNo;

		Object[] finderArgs = new Object[] {claimIntimationNo};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ODMUROORUPLOADS_WHERE);

			boolean bindClaimIntimationNo = false;

			if (claimIntimationNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_CLAIMINTIMATIONNO_CLAIMINTIMATIONNO_3);
			}
			else {
				bindClaimIntimationNo = true;

				sb.append(_FINDER_COLUMN_CLAIMINTIMATIONNO_CLAIMINTIMATIONNO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClaimIntimationNo) {
					queryPos.add(claimIntimationNo);
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

	private static final String
		_FINDER_COLUMN_CLAIMINTIMATIONNO_CLAIMINTIMATIONNO_2 =
			"odMuroorUploads.claimIntimationNo = ?";

	private static final String
		_FINDER_COLUMN_CLAIMINTIMATIONNO_CLAIMINTIMATIONNO_3 =
			"(odMuroorUploads.claimIntimationNo IS NULL OR odMuroorUploads.claimIntimationNo = '')";

	public ODMuroorUploadsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "FILE_ID");
		dbColumnNames.put("claimIntimationNo", "CLM_INTM_NO");
		dbColumnNames.put("iqamaId", "IQAMA_ID");
		dbColumnNames.put("driverLicense", "DRIVER_LICENSE");
		dbColumnNames.put("driverLicenseName", "DRIVER_LICENSE_NAME");
		dbColumnNames.put("vehRegist", "VEH_REGISTRATION");
		dbColumnNames.put("vehRegistName", "VEH_REGISTRATION_NAME");
		dbColumnNames.put("policyCopy", "POLICY_COPY");
		dbColumnNames.put("policyCopyName", "POLICY_COPY_NAME");

		setDBColumnNames(dbColumnNames);

		setModelClass(ODMuroorUploads.class);

		setModelImplClass(ODMuroorUploadsImpl.class);
		setModelPKClass(int.class);
	}

	/**
	 * Caches the od muroor uploads in the entity cache if it is enabled.
	 *
	 * @param odMuroorUploads the od muroor uploads
	 */
	@Override
	public void cacheResult(ODMuroorUploads odMuroorUploads) {
		dummyEntityCache.putResult(
			ODMuroorUploadsImpl.class, odMuroorUploads.getPrimaryKey(),
			odMuroorUploads);

		dummyFinderCache.putResult(
			_finderPathFetchByclaimIntimationNo,
			new Object[] {odMuroorUploads.getClaimIntimationNo()},
			odMuroorUploads);
	}

	/**
	 * Caches the od muroor uploadses in the entity cache if it is enabled.
	 *
	 * @param odMuroorUploadses the od muroor uploadses
	 */
	@Override
	public void cacheResult(List<ODMuroorUploads> odMuroorUploadses) {
		for (ODMuroorUploads odMuroorUploads : odMuroorUploadses) {
			if (dummyEntityCache.getResult(
					ODMuroorUploadsImpl.class,
					odMuroorUploads.getPrimaryKey()) == null) {

				cacheResult(odMuroorUploads);
			}
		}
	}

	/**
	 * Clears the cache for all od muroor uploadses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(ODMuroorUploadsImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the od muroor uploads.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ODMuroorUploads odMuroorUploads) {
		dummyEntityCache.removeResult(
			ODMuroorUploadsImpl.class, odMuroorUploads);
	}

	@Override
	public void clearCache(List<ODMuroorUploads> odMuroorUploadses) {
		for (ODMuroorUploads odMuroorUploads : odMuroorUploadses) {
			dummyEntityCache.removeResult(
				ODMuroorUploadsImpl.class, odMuroorUploads);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				ODMuroorUploadsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ODMuroorUploadsModelImpl odMuroorUploadsModelImpl) {

		Object[] args = new Object[] {
			odMuroorUploadsModelImpl.getClaimIntimationNo()
		};

		dummyFinderCache.putResult(
			_finderPathCountByclaimIntimationNo, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchByclaimIntimationNo, args, odMuroorUploadsModelImpl,
			false);
	}

	/**
	 * Creates a new od muroor uploads with the primary key. Does not add the od muroor uploads to the database.
	 *
	 * @param id the primary key for the new od muroor uploads
	 * @return the new od muroor uploads
	 */
	@Override
	public ODMuroorUploads create(int id) {
		ODMuroorUploads odMuroorUploads = new ODMuroorUploadsImpl();

		odMuroorUploads.setNew(true);
		odMuroorUploads.setPrimaryKey(id);

		return odMuroorUploads;
	}

	/**
	 * Removes the od muroor uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the od muroor uploads
	 * @return the od muroor uploads that was removed
	 * @throws NoSuchODMuroorUploadsException if a od muroor uploads with the primary key could not be found
	 */
	@Override
	public ODMuroorUploads remove(int id)
		throws NoSuchODMuroorUploadsException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the od muroor uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the od muroor uploads
	 * @return the od muroor uploads that was removed
	 * @throws NoSuchODMuroorUploadsException if a od muroor uploads with the primary key could not be found
	 */
	@Override
	public ODMuroorUploads remove(Serializable primaryKey)
		throws NoSuchODMuroorUploadsException {

		Session session = null;

		try {
			session = openSession();

			ODMuroorUploads odMuroorUploads = (ODMuroorUploads)session.get(
				ODMuroorUploadsImpl.class, primaryKey);

			if (odMuroorUploads == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchODMuroorUploadsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(odMuroorUploads);
		}
		catch (NoSuchODMuroorUploadsException noSuchEntityException) {
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
	protected ODMuroorUploads removeImpl(ODMuroorUploads odMuroorUploads) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(odMuroorUploads)) {
				odMuroorUploads = (ODMuroorUploads)session.get(
					ODMuroorUploadsImpl.class,
					odMuroorUploads.getPrimaryKeyObj());
			}

			if (odMuroorUploads != null) {
				session.delete(odMuroorUploads);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (odMuroorUploads != null) {
			clearCache(odMuroorUploads);
		}

		return odMuroorUploads;
	}

	@Override
	public ODMuroorUploads updateImpl(ODMuroorUploads odMuroorUploads) {
		boolean isNew = odMuroorUploads.isNew();

		if (!(odMuroorUploads instanceof ODMuroorUploadsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(odMuroorUploads.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					odMuroorUploads);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in odMuroorUploads proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ODMuroorUploads implementation " +
					odMuroorUploads.getClass());
		}

		ODMuroorUploadsModelImpl odMuroorUploadsModelImpl =
			(ODMuroorUploadsModelImpl)odMuroorUploads;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(odMuroorUploads);
			}
			else {
				session.evict(
					ODMuroorUploadsImpl.class,
					odMuroorUploads.getPrimaryKeyObj());

				session.saveOrUpdate(odMuroorUploads);
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
			ODMuroorUploadsImpl.class, odMuroorUploadsModelImpl, false, true);

		cacheUniqueFindersCache(odMuroorUploadsModelImpl);

		if (isNew) {
			odMuroorUploads.setNew(false);
		}

		odMuroorUploads.resetOriginalValues();

		return odMuroorUploads;
	}

	/**
	 * Returns the od muroor uploads with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the od muroor uploads
	 * @return the od muroor uploads
	 * @throws NoSuchODMuroorUploadsException if a od muroor uploads with the primary key could not be found
	 */
	@Override
	public ODMuroorUploads findByPrimaryKey(Serializable primaryKey)
		throws NoSuchODMuroorUploadsException {

		ODMuroorUploads odMuroorUploads = fetchByPrimaryKey(primaryKey);

		if (odMuroorUploads == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchODMuroorUploadsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return odMuroorUploads;
	}

	/**
	 * Returns the od muroor uploads with the primary key or throws a <code>NoSuchODMuroorUploadsException</code> if it could not be found.
	 *
	 * @param id the primary key of the od muroor uploads
	 * @return the od muroor uploads
	 * @throws NoSuchODMuroorUploadsException if a od muroor uploads with the primary key could not be found
	 */
	@Override
	public ODMuroorUploads findByPrimaryKey(int id)
		throws NoSuchODMuroorUploadsException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the od muroor uploads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the od muroor uploads
	 * @return the od muroor uploads, or <code>null</code> if a od muroor uploads with the primary key could not be found
	 */
	@Override
	public ODMuroorUploads fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the od muroor uploadses.
	 *
	 * @return the od muroor uploadses
	 */
	@Override
	public List<ODMuroorUploads> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the od muroor uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ODMuroorUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of od muroor uploadses
	 * @param end the upper bound of the range of od muroor uploadses (not inclusive)
	 * @return the range of od muroor uploadses
	 */
	@Override
	public List<ODMuroorUploads> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the od muroor uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ODMuroorUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of od muroor uploadses
	 * @param end the upper bound of the range of od muroor uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of od muroor uploadses
	 */
	@Override
	public List<ODMuroorUploads> findAll(
		int start, int end,
		OrderByComparator<ODMuroorUploads> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the od muroor uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ODMuroorUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of od muroor uploadses
	 * @param end the upper bound of the range of od muroor uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of od muroor uploadses
	 */
	@Override
	public List<ODMuroorUploads> findAll(
		int start, int end,
		OrderByComparator<ODMuroorUploads> orderByComparator,
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

		List<ODMuroorUploads> list = null;

		if (useFinderCache) {
			list = (List<ODMuroorUploads>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ODMUROORUPLOADS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ODMUROORUPLOADS;

				sql = sql.concat(ODMuroorUploadsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ODMuroorUploads>)QueryUtil.list(
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
	 * Removes all the od muroor uploadses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ODMuroorUploads odMuroorUploads : findAll()) {
			remove(odMuroorUploads);
		}
	}

	/**
	 * Returns the number of od muroor uploadses.
	 *
	 * @return the number of od muroor uploadses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ODMUROORUPLOADS);

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
		return _SQL_SELECT_ODMUROORUPLOADS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ODMuroorUploadsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the od muroor uploads persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ODMuroorUploadsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ODMuroorUploads.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByclaimIntimationNo = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByclaimIntimationNo",
			new String[] {String.class.getName()}, new String[] {"CLM_INTM_NO"},
			true);

		_finderPathCountByclaimIntimationNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByclaimIntimationNo", new String[] {String.class.getName()},
			new String[] {"CLM_INTM_NO"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(ODMuroorUploadsImpl.class.getName());

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

	private static final String _SQL_SELECT_ODMUROORUPLOADS =
		"SELECT odMuroorUploads FROM ODMuroorUploads odMuroorUploads";

	private static final String _SQL_SELECT_ODMUROORUPLOADS_WHERE =
		"SELECT odMuroorUploads FROM ODMuroorUploads odMuroorUploads WHERE ";

	private static final String _SQL_COUNT_ODMUROORUPLOADS =
		"SELECT COUNT(odMuroorUploads) FROM ODMuroorUploads odMuroorUploads";

	private static final String _SQL_COUNT_ODMUROORUPLOADS_WHERE =
		"SELECT COUNT(odMuroorUploads) FROM ODMuroorUploads odMuroorUploads WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "odMuroorUploads.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ODMuroorUploads exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ODMuroorUploads exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ODMuroorUploadsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"id", "claimIntimationNo", "iqamaId", "driverLicense",
			"driverLicenseName", "vehRegist", "vehRegistName", "policyCopy",
			"policyCopyName"
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

	private static class ODMuroorUploadsModelArgumentsResolver
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

			ODMuroorUploadsModelImpl odMuroorUploadsModelImpl =
				(ODMuroorUploadsModelImpl)baseModel;

			long columnBitmask = odMuroorUploadsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					odMuroorUploadsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						odMuroorUploadsModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					odMuroorUploadsModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ODMuroorUploadsModelImpl odMuroorUploadsModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						odMuroorUploadsModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = odMuroorUploadsModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}