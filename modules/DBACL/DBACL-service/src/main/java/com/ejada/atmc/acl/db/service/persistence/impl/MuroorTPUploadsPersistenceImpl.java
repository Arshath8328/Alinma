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

import com.ejada.atmc.acl.db.exception.NoSuchMuroorTPUploadsException;
import com.ejada.atmc.acl.db.model.MuroorTPUploads;
import com.ejada.atmc.acl.db.model.impl.MuroorTPUploadsImpl;
import com.ejada.atmc.acl.db.model.impl.MuroorTPUploadsModelImpl;
import com.ejada.atmc.acl.db.service.persistence.MuroorTPUploadsPersistence;
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
 * The persistence implementation for the muroor tp uploads service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MuroorTPUploadsPersistence.class)
public class MuroorTPUploadsPersistenceImpl
	extends BasePersistenceImpl<MuroorTPUploads>
	implements MuroorTPUploadsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MuroorTPUploadsUtil</code> to access the muroor tp uploads persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MuroorTPUploadsImpl.class.getName();

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
	 * Returns the muroor tp uploads where claimIntimationNo = &#63; or throws a <code>NoSuchMuroorTPUploadsException</code> if it could not be found.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the matching muroor tp uploads
	 * @throws NoSuchMuroorTPUploadsException if a matching muroor tp uploads could not be found
	 */
	@Override
	public MuroorTPUploads findByclaimIntimationNo(String claimIntimationNo)
		throws NoSuchMuroorTPUploadsException {

		MuroorTPUploads muroorTPUploads = fetchByclaimIntimationNo(
			claimIntimationNo);

		if (muroorTPUploads == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("claimIntimationNo=");
			sb.append(claimIntimationNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMuroorTPUploadsException(sb.toString());
		}

		return muroorTPUploads;
	}

	/**
	 * Returns the muroor tp uploads where claimIntimationNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the matching muroor tp uploads, or <code>null</code> if a matching muroor tp uploads could not be found
	 */
	@Override
	public MuroorTPUploads fetchByclaimIntimationNo(String claimIntimationNo) {
		return fetchByclaimIntimationNo(claimIntimationNo, true);
	}

	/**
	 * Returns the muroor tp uploads where claimIntimationNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching muroor tp uploads, or <code>null</code> if a matching muroor tp uploads could not be found
	 */
	@Override
	public MuroorTPUploads fetchByclaimIntimationNo(
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

		if (result instanceof MuroorTPUploads) {
			MuroorTPUploads muroorTPUploads = (MuroorTPUploads)result;

			if (!Objects.equals(
					claimIntimationNo,
					muroorTPUploads.getClaimIntimationNo())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_MUROORTPUPLOADS_WHERE);

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

				List<MuroorTPUploads> list = query.list();

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
								"MuroorTPUploadsPersistenceImpl.fetchByclaimIntimationNo(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MuroorTPUploads muroorTPUploads = list.get(0);

					result = muroorTPUploads;

					cacheResult(muroorTPUploads);
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
			return (MuroorTPUploads)result;
		}
	}

	/**
	 * Removes the muroor tp uploads where claimIntimationNo = &#63; from the database.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the muroor tp uploads that was removed
	 */
	@Override
	public MuroorTPUploads removeByclaimIntimationNo(String claimIntimationNo)
		throws NoSuchMuroorTPUploadsException {

		MuroorTPUploads muroorTPUploads = findByclaimIntimationNo(
			claimIntimationNo);

		return remove(muroorTPUploads);
	}

	/**
	 * Returns the number of muroor tp uploadses where claimIntimationNo = &#63;.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the number of matching muroor tp uploadses
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

			sb.append(_SQL_COUNT_MUROORTPUPLOADS_WHERE);

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
			"muroorTPUploads.claimIntimationNo = ?";

	private static final String
		_FINDER_COLUMN_CLAIMINTIMATIONNO_CLAIMINTIMATIONNO_3 =
			"(muroorTPUploads.claimIntimationNo IS NULL OR muroorTPUploads.claimIntimationNo = '')";

	public MuroorTPUploadsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "FILE_ID");
		dbColumnNames.put("claimIntimationNo", "CLM_INTM_NO");
		dbColumnNames.put("iqamaId", "IQAMA_ID");
		dbColumnNames.put("driverLicense", "DRIVER_LICENSE");
		dbColumnNames.put("driverLicenseName", "DRIVER_LICENSE_NAME");
		dbColumnNames.put("vehRegist", "VEH_REGISTRATION");
		dbColumnNames.put("vehRegistName", "VEH_REGISTRATION_NAME");
		dbColumnNames.put("frontPhoto", "FRONT_PHOTO");
		dbColumnNames.put("frontPhotoName", "FRONT_PHOTO_NAME");
		dbColumnNames.put("rearPhoto", "RARE_PHOTO");
		dbColumnNames.put("rearPhotoName", "RARE_PHOTO_NAME");
		dbColumnNames.put("rightSidePhoto", "RIGHT_SIDE_PHOTO");
		dbColumnNames.put("rightSidePhotoName", "RIGHT_SIDE_PHOTO_NAME");
		dbColumnNames.put("leftSidePhoto", "LEFT_SIDE_PHOTO");
		dbColumnNames.put("leftSidePhotoName", "LEFT_SIDE_PHOTO_NAME");
		dbColumnNames.put("bankIban", "BANK_IBAN_COPY");
		dbColumnNames.put("bankIbanName", "BANK_IBAN_COPY_NAME");
		dbColumnNames.put("ownerId", "OWNER_ID");
		dbColumnNames.put("ownerIdName", "OWNER_ID_NAME");

		setDBColumnNames(dbColumnNames);

		setModelClass(MuroorTPUploads.class);

		setModelImplClass(MuroorTPUploadsImpl.class);
		setModelPKClass(int.class);
	}

	/**
	 * Caches the muroor tp uploads in the entity cache if it is enabled.
	 *
	 * @param muroorTPUploads the muroor tp uploads
	 */
	@Override
	public void cacheResult(MuroorTPUploads muroorTPUploads) {
		dummyEntityCache.putResult(
			MuroorTPUploadsImpl.class, muroorTPUploads.getPrimaryKey(),
			muroorTPUploads);

		dummyFinderCache.putResult(
			_finderPathFetchByclaimIntimationNo,
			new Object[] {muroorTPUploads.getClaimIntimationNo()},
			muroorTPUploads);
	}

	/**
	 * Caches the muroor tp uploadses in the entity cache if it is enabled.
	 *
	 * @param muroorTPUploadses the muroor tp uploadses
	 */
	@Override
	public void cacheResult(List<MuroorTPUploads> muroorTPUploadses) {
		for (MuroorTPUploads muroorTPUploads : muroorTPUploadses) {
			if (dummyEntityCache.getResult(
					MuroorTPUploadsImpl.class,
					muroorTPUploads.getPrimaryKey()) == null) {

				cacheResult(muroorTPUploads);
			}
		}
	}

	/**
	 * Clears the cache for all muroor tp uploadses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(MuroorTPUploadsImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the muroor tp uploads.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MuroorTPUploads muroorTPUploads) {
		dummyEntityCache.removeResult(
			MuroorTPUploadsImpl.class, muroorTPUploads);
	}

	@Override
	public void clearCache(List<MuroorTPUploads> muroorTPUploadses) {
		for (MuroorTPUploads muroorTPUploads : muroorTPUploadses) {
			dummyEntityCache.removeResult(
				MuroorTPUploadsImpl.class, muroorTPUploads);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				MuroorTPUploadsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		MuroorTPUploadsModelImpl muroorTPUploadsModelImpl) {

		Object[] args = new Object[] {
			muroorTPUploadsModelImpl.getClaimIntimationNo()
		};

		dummyFinderCache.putResult(
			_finderPathCountByclaimIntimationNo, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchByclaimIntimationNo, args, muroorTPUploadsModelImpl,
			false);
	}

	/**
	 * Creates a new muroor tp uploads with the primary key. Does not add the muroor tp uploads to the database.
	 *
	 * @param id the primary key for the new muroor tp uploads
	 * @return the new muroor tp uploads
	 */
	@Override
	public MuroorTPUploads create(int id) {
		MuroorTPUploads muroorTPUploads = new MuroorTPUploadsImpl();

		muroorTPUploads.setNew(true);
		muroorTPUploads.setPrimaryKey(id);

		return muroorTPUploads;
	}

	/**
	 * Removes the muroor tp uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the muroor tp uploads
	 * @return the muroor tp uploads that was removed
	 * @throws NoSuchMuroorTPUploadsException if a muroor tp uploads with the primary key could not be found
	 */
	@Override
	public MuroorTPUploads remove(int id)
		throws NoSuchMuroorTPUploadsException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the muroor tp uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the muroor tp uploads
	 * @return the muroor tp uploads that was removed
	 * @throws NoSuchMuroorTPUploadsException if a muroor tp uploads with the primary key could not be found
	 */
	@Override
	public MuroorTPUploads remove(Serializable primaryKey)
		throws NoSuchMuroorTPUploadsException {

		Session session = null;

		try {
			session = openSession();

			MuroorTPUploads muroorTPUploads = (MuroorTPUploads)session.get(
				MuroorTPUploadsImpl.class, primaryKey);

			if (muroorTPUploads == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMuroorTPUploadsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(muroorTPUploads);
		}
		catch (NoSuchMuroorTPUploadsException noSuchEntityException) {
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
	protected MuroorTPUploads removeImpl(MuroorTPUploads muroorTPUploads) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(muroorTPUploads)) {
				muroorTPUploads = (MuroorTPUploads)session.get(
					MuroorTPUploadsImpl.class,
					muroorTPUploads.getPrimaryKeyObj());
			}

			if (muroorTPUploads != null) {
				session.delete(muroorTPUploads);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (muroorTPUploads != null) {
			clearCache(muroorTPUploads);
		}

		return muroorTPUploads;
	}

	@Override
	public MuroorTPUploads updateImpl(MuroorTPUploads muroorTPUploads) {
		boolean isNew = muroorTPUploads.isNew();

		if (!(muroorTPUploads instanceof MuroorTPUploadsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(muroorTPUploads.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					muroorTPUploads);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in muroorTPUploads proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MuroorTPUploads implementation " +
					muroorTPUploads.getClass());
		}

		MuroorTPUploadsModelImpl muroorTPUploadsModelImpl =
			(MuroorTPUploadsModelImpl)muroorTPUploads;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(muroorTPUploads);
			}
			else {
				session.evict(
					MuroorTPUploadsImpl.class,
					muroorTPUploads.getPrimaryKeyObj());

				session.saveOrUpdate(muroorTPUploads);
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
			MuroorTPUploadsImpl.class, muroorTPUploadsModelImpl, false, true);

		cacheUniqueFindersCache(muroorTPUploadsModelImpl);

		if (isNew) {
			muroorTPUploads.setNew(false);
		}

		muroorTPUploads.resetOriginalValues();

		return muroorTPUploads;
	}

	/**
	 * Returns the muroor tp uploads with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the muroor tp uploads
	 * @return the muroor tp uploads
	 * @throws NoSuchMuroorTPUploadsException if a muroor tp uploads with the primary key could not be found
	 */
	@Override
	public MuroorTPUploads findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMuroorTPUploadsException {

		MuroorTPUploads muroorTPUploads = fetchByPrimaryKey(primaryKey);

		if (muroorTPUploads == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMuroorTPUploadsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return muroorTPUploads;
	}

	/**
	 * Returns the muroor tp uploads with the primary key or throws a <code>NoSuchMuroorTPUploadsException</code> if it could not be found.
	 *
	 * @param id the primary key of the muroor tp uploads
	 * @return the muroor tp uploads
	 * @throws NoSuchMuroorTPUploadsException if a muroor tp uploads with the primary key could not be found
	 */
	@Override
	public MuroorTPUploads findByPrimaryKey(int id)
		throws NoSuchMuroorTPUploadsException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the muroor tp uploads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the muroor tp uploads
	 * @return the muroor tp uploads, or <code>null</code> if a muroor tp uploads with the primary key could not be found
	 */
	@Override
	public MuroorTPUploads fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the muroor tp uploadses.
	 *
	 * @return the muroor tp uploadses
	 */
	@Override
	public List<MuroorTPUploads> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the muroor tp uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MuroorTPUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of muroor tp uploadses
	 * @param end the upper bound of the range of muroor tp uploadses (not inclusive)
	 * @return the range of muroor tp uploadses
	 */
	@Override
	public List<MuroorTPUploads> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the muroor tp uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MuroorTPUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of muroor tp uploadses
	 * @param end the upper bound of the range of muroor tp uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of muroor tp uploadses
	 */
	@Override
	public List<MuroorTPUploads> findAll(
		int start, int end,
		OrderByComparator<MuroorTPUploads> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the muroor tp uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MuroorTPUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of muroor tp uploadses
	 * @param end the upper bound of the range of muroor tp uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of muroor tp uploadses
	 */
	@Override
	public List<MuroorTPUploads> findAll(
		int start, int end,
		OrderByComparator<MuroorTPUploads> orderByComparator,
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

		List<MuroorTPUploads> list = null;

		if (useFinderCache) {
			list = (List<MuroorTPUploads>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MUROORTPUPLOADS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MUROORTPUPLOADS;

				sql = sql.concat(MuroorTPUploadsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MuroorTPUploads>)QueryUtil.list(
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
	 * Removes all the muroor tp uploadses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MuroorTPUploads muroorTPUploads : findAll()) {
			remove(muroorTPUploads);
		}
	}

	/**
	 * Returns the number of muroor tp uploadses.
	 *
	 * @return the number of muroor tp uploadses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MUROORTPUPLOADS);

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
		return _SQL_SELECT_MUROORTPUPLOADS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MuroorTPUploadsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the muroor tp uploads persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new MuroorTPUploadsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", MuroorTPUploads.class.getName()));

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
		dummyEntityCache.removeCache(MuroorTPUploadsImpl.class.getName());

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

	private static final String _SQL_SELECT_MUROORTPUPLOADS =
		"SELECT muroorTPUploads FROM MuroorTPUploads muroorTPUploads";

	private static final String _SQL_SELECT_MUROORTPUPLOADS_WHERE =
		"SELECT muroorTPUploads FROM MuroorTPUploads muroorTPUploads WHERE ";

	private static final String _SQL_COUNT_MUROORTPUPLOADS =
		"SELECT COUNT(muroorTPUploads) FROM MuroorTPUploads muroorTPUploads";

	private static final String _SQL_COUNT_MUROORTPUPLOADS_WHERE =
		"SELECT COUNT(muroorTPUploads) FROM MuroorTPUploads muroorTPUploads WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "muroorTPUploads.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MuroorTPUploads exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MuroorTPUploads exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MuroorTPUploadsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"id", "claimIntimationNo", "iqamaId", "driverLicense",
			"driverLicenseName", "vehRegist", "vehRegistName", "frontPhoto",
			"frontPhotoName", "rearPhoto", "rearPhotoName", "rightSidePhoto",
			"rightSidePhotoName", "leftSidePhoto", "leftSidePhotoName",
			"bankIban", "bankIbanName", "ownerId", "ownerIdName"
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

	private static class MuroorTPUploadsModelArgumentsResolver
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

			MuroorTPUploadsModelImpl muroorTPUploadsModelImpl =
				(MuroorTPUploadsModelImpl)baseModel;

			long columnBitmask = muroorTPUploadsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					muroorTPUploadsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						muroorTPUploadsModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					muroorTPUploadsModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			MuroorTPUploadsModelImpl muroorTPUploadsModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						muroorTPUploadsModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = muroorTPUploadsModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}