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

import com.ejada.atmc.acl.db.exception.NoSuchClaimAdminUploadsException;
import com.ejada.atmc.acl.db.model.ClaimAdminUploads;
import com.ejada.atmc.acl.db.model.impl.ClaimAdminUploadsImpl;
import com.ejada.atmc.acl.db.model.impl.ClaimAdminUploadsModelImpl;
import com.ejada.atmc.acl.db.service.persistence.ClaimAdminUploadsPersistence;
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
 * The persistence implementation for the claim admin uploads service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ClaimAdminUploadsPersistence.class)
public class ClaimAdminUploadsPersistenceImpl
	extends BasePersistenceImpl<ClaimAdminUploads>
	implements ClaimAdminUploadsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ClaimAdminUploadsUtil</code> to access the claim admin uploads persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ClaimAdminUploadsImpl.class.getName();

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
	 * Returns all the claim admin uploadses where refNo = &#63;.
	 *
	 * @param refNo the ref no
	 * @return the matching claim admin uploadses
	 */
	@Override
	public List<ClaimAdminUploads> findByrefNo(String refNo) {
		return findByrefNo(refNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the claim admin uploadses where refNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param refNo the ref no
	 * @param start the lower bound of the range of claim admin uploadses
	 * @param end the upper bound of the range of claim admin uploadses (not inclusive)
	 * @return the range of matching claim admin uploadses
	 */
	@Override
	public List<ClaimAdminUploads> findByrefNo(
		String refNo, int start, int end) {

		return findByrefNo(refNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the claim admin uploadses where refNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param refNo the ref no
	 * @param start the lower bound of the range of claim admin uploadses
	 * @param end the upper bound of the range of claim admin uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim admin uploadses
	 */
	@Override
	public List<ClaimAdminUploads> findByrefNo(
		String refNo, int start, int end,
		OrderByComparator<ClaimAdminUploads> orderByComparator) {

		return findByrefNo(refNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claim admin uploadses where refNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param refNo the ref no
	 * @param start the lower bound of the range of claim admin uploadses
	 * @param end the upper bound of the range of claim admin uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim admin uploadses
	 */
	@Override
	public List<ClaimAdminUploads> findByrefNo(
		String refNo, int start, int end,
		OrderByComparator<ClaimAdminUploads> orderByComparator,
		boolean useFinderCache) {

		refNo = Objects.toString(refNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByrefNo;
				finderArgs = new Object[] {refNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByrefNo;
			finderArgs = new Object[] {refNo, start, end, orderByComparator};
		}

		List<ClaimAdminUploads> list = null;

		if (useFinderCache) {
			list = (List<ClaimAdminUploads>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClaimAdminUploads claimAdminUploads : list) {
					if (!refNo.equals(claimAdminUploads.getRefNo())) {
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

			sb.append(_SQL_SELECT_CLAIMADMINUPLOADS_WHERE);

			boolean bindRefNo = false;

			if (refNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_REFNO_REFNO_3);
			}
			else {
				bindRefNo = true;

				sb.append(_FINDER_COLUMN_REFNO_REFNO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClaimAdminUploadsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRefNo) {
					queryPos.add(refNo);
				}

				list = (List<ClaimAdminUploads>)QueryUtil.list(
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
	 * Returns the first claim admin uploads in the ordered set where refNo = &#63;.
	 *
	 * @param refNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim admin uploads
	 * @throws NoSuchClaimAdminUploadsException if a matching claim admin uploads could not be found
	 */
	@Override
	public ClaimAdminUploads findByrefNo_First(
			String refNo,
			OrderByComparator<ClaimAdminUploads> orderByComparator)
		throws NoSuchClaimAdminUploadsException {

		ClaimAdminUploads claimAdminUploads = fetchByrefNo_First(
			refNo, orderByComparator);

		if (claimAdminUploads != null) {
			return claimAdminUploads;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("refNo=");
		sb.append(refNo);

		sb.append("}");

		throw new NoSuchClaimAdminUploadsException(sb.toString());
	}

	/**
	 * Returns the first claim admin uploads in the ordered set where refNo = &#63;.
	 *
	 * @param refNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim admin uploads, or <code>null</code> if a matching claim admin uploads could not be found
	 */
	@Override
	public ClaimAdminUploads fetchByrefNo_First(
		String refNo, OrderByComparator<ClaimAdminUploads> orderByComparator) {

		List<ClaimAdminUploads> list = findByrefNo(
			refNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last claim admin uploads in the ordered set where refNo = &#63;.
	 *
	 * @param refNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim admin uploads
	 * @throws NoSuchClaimAdminUploadsException if a matching claim admin uploads could not be found
	 */
	@Override
	public ClaimAdminUploads findByrefNo_Last(
			String refNo,
			OrderByComparator<ClaimAdminUploads> orderByComparator)
		throws NoSuchClaimAdminUploadsException {

		ClaimAdminUploads claimAdminUploads = fetchByrefNo_Last(
			refNo, orderByComparator);

		if (claimAdminUploads != null) {
			return claimAdminUploads;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("refNo=");
		sb.append(refNo);

		sb.append("}");

		throw new NoSuchClaimAdminUploadsException(sb.toString());
	}

	/**
	 * Returns the last claim admin uploads in the ordered set where refNo = &#63;.
	 *
	 * @param refNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim admin uploads, or <code>null</code> if a matching claim admin uploads could not be found
	 */
	@Override
	public ClaimAdminUploads fetchByrefNo_Last(
		String refNo, OrderByComparator<ClaimAdminUploads> orderByComparator) {

		int count = countByrefNo(refNo);

		if (count == 0) {
			return null;
		}

		List<ClaimAdminUploads> list = findByrefNo(
			refNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the claim admin uploadses before and after the current claim admin uploads in the ordered set where refNo = &#63;.
	 *
	 * @param id the primary key of the current claim admin uploads
	 * @param refNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim admin uploads
	 * @throws NoSuchClaimAdminUploadsException if a claim admin uploads with the primary key could not be found
	 */
	@Override
	public ClaimAdminUploads[] findByrefNo_PrevAndNext(
			int id, String refNo,
			OrderByComparator<ClaimAdminUploads> orderByComparator)
		throws NoSuchClaimAdminUploadsException {

		refNo = Objects.toString(refNo, "");

		ClaimAdminUploads claimAdminUploads = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ClaimAdminUploads[] array = new ClaimAdminUploadsImpl[3];

			array[0] = getByrefNo_PrevAndNext(
				session, claimAdminUploads, refNo, orderByComparator, true);

			array[1] = claimAdminUploads;

			array[2] = getByrefNo_PrevAndNext(
				session, claimAdminUploads, refNo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ClaimAdminUploads getByrefNo_PrevAndNext(
		Session session, ClaimAdminUploads claimAdminUploads, String refNo,
		OrderByComparator<ClaimAdminUploads> orderByComparator,
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

		sb.append(_SQL_SELECT_CLAIMADMINUPLOADS_WHERE);

		boolean bindRefNo = false;

		if (refNo.isEmpty()) {
			sb.append(_FINDER_COLUMN_REFNO_REFNO_3);
		}
		else {
			bindRefNo = true;

			sb.append(_FINDER_COLUMN_REFNO_REFNO_2);
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
			sb.append(ClaimAdminUploadsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRefNo) {
			queryPos.add(refNo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						claimAdminUploads)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClaimAdminUploads> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the claim admin uploadses where refNo = &#63; from the database.
	 *
	 * @param refNo the ref no
	 */
	@Override
	public void removeByrefNo(String refNo) {
		for (ClaimAdminUploads claimAdminUploads :
				findByrefNo(
					refNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(claimAdminUploads);
		}
	}

	/**
	 * Returns the number of claim admin uploadses where refNo = &#63;.
	 *
	 * @param refNo the ref no
	 * @return the number of matching claim admin uploadses
	 */
	@Override
	public int countByrefNo(String refNo) {
		refNo = Objects.toString(refNo, "");

		FinderPath finderPath = _finderPathCountByrefNo;

		Object[] finderArgs = new Object[] {refNo};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLAIMADMINUPLOADS_WHERE);

			boolean bindRefNo = false;

			if (refNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_REFNO_REFNO_3);
			}
			else {
				bindRefNo = true;

				sb.append(_FINDER_COLUMN_REFNO_REFNO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRefNo) {
					queryPos.add(refNo);
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

	private static final String _FINDER_COLUMN_REFNO_REFNO_2 =
		"claimAdminUploads.refNo = ?";

	private static final String _FINDER_COLUMN_REFNO_REFNO_3 =
		"(claimAdminUploads.refNo IS NULL OR claimAdminUploads.refNo = '')";

	public ClaimAdminUploadsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "CLM_FILE_ID");
		dbColumnNames.put("refNo", "CLM_REFERENCE_NO");
		dbColumnNames.put("fileName", "CLM_FILE_NAME");
		dbColumnNames.put("adminFile", "CLM_FILE");

		setDBColumnNames(dbColumnNames);

		setModelClass(ClaimAdminUploads.class);

		setModelImplClass(ClaimAdminUploadsImpl.class);
		setModelPKClass(int.class);
	}

	/**
	 * Caches the claim admin uploads in the entity cache if it is enabled.
	 *
	 * @param claimAdminUploads the claim admin uploads
	 */
	@Override
	public void cacheResult(ClaimAdminUploads claimAdminUploads) {
		dummyEntityCache.putResult(
			ClaimAdminUploadsImpl.class, claimAdminUploads.getPrimaryKey(),
			claimAdminUploads);
	}

	/**
	 * Caches the claim admin uploadses in the entity cache if it is enabled.
	 *
	 * @param claimAdminUploadses the claim admin uploadses
	 */
	@Override
	public void cacheResult(List<ClaimAdminUploads> claimAdminUploadses) {
		for (ClaimAdminUploads claimAdminUploads : claimAdminUploadses) {
			if (dummyEntityCache.getResult(
					ClaimAdminUploadsImpl.class,
					claimAdminUploads.getPrimaryKey()) == null) {

				cacheResult(claimAdminUploads);
			}
		}
	}

	/**
	 * Clears the cache for all claim admin uploadses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(ClaimAdminUploadsImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the claim admin uploads.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ClaimAdminUploads claimAdminUploads) {
		dummyEntityCache.removeResult(
			ClaimAdminUploadsImpl.class, claimAdminUploads);
	}

	@Override
	public void clearCache(List<ClaimAdminUploads> claimAdminUploadses) {
		for (ClaimAdminUploads claimAdminUploads : claimAdminUploadses) {
			dummyEntityCache.removeResult(
				ClaimAdminUploadsImpl.class, claimAdminUploads);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				ClaimAdminUploadsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new claim admin uploads with the primary key. Does not add the claim admin uploads to the database.
	 *
	 * @param id the primary key for the new claim admin uploads
	 * @return the new claim admin uploads
	 */
	@Override
	public ClaimAdminUploads create(int id) {
		ClaimAdminUploads claimAdminUploads = new ClaimAdminUploadsImpl();

		claimAdminUploads.setNew(true);
		claimAdminUploads.setPrimaryKey(id);

		return claimAdminUploads;
	}

	/**
	 * Removes the claim admin uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the claim admin uploads
	 * @return the claim admin uploads that was removed
	 * @throws NoSuchClaimAdminUploadsException if a claim admin uploads with the primary key could not be found
	 */
	@Override
	public ClaimAdminUploads remove(int id)
		throws NoSuchClaimAdminUploadsException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the claim admin uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the claim admin uploads
	 * @return the claim admin uploads that was removed
	 * @throws NoSuchClaimAdminUploadsException if a claim admin uploads with the primary key could not be found
	 */
	@Override
	public ClaimAdminUploads remove(Serializable primaryKey)
		throws NoSuchClaimAdminUploadsException {

		Session session = null;

		try {
			session = openSession();

			ClaimAdminUploads claimAdminUploads =
				(ClaimAdminUploads)session.get(
					ClaimAdminUploadsImpl.class, primaryKey);

			if (claimAdminUploads == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClaimAdminUploadsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(claimAdminUploads);
		}
		catch (NoSuchClaimAdminUploadsException noSuchEntityException) {
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
	protected ClaimAdminUploads removeImpl(
		ClaimAdminUploads claimAdminUploads) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(claimAdminUploads)) {
				claimAdminUploads = (ClaimAdminUploads)session.get(
					ClaimAdminUploadsImpl.class,
					claimAdminUploads.getPrimaryKeyObj());
			}

			if (claimAdminUploads != null) {
				session.delete(claimAdminUploads);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (claimAdminUploads != null) {
			clearCache(claimAdminUploads);
		}

		return claimAdminUploads;
	}

	@Override
	public ClaimAdminUploads updateImpl(ClaimAdminUploads claimAdminUploads) {
		boolean isNew = claimAdminUploads.isNew();

		if (!(claimAdminUploads instanceof ClaimAdminUploadsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(claimAdminUploads.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					claimAdminUploads);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in claimAdminUploads proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ClaimAdminUploads implementation " +
					claimAdminUploads.getClass());
		}

		ClaimAdminUploadsModelImpl claimAdminUploadsModelImpl =
			(ClaimAdminUploadsModelImpl)claimAdminUploads;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(claimAdminUploads);
			}
			else {
				session.evict(
					ClaimAdminUploadsImpl.class,
					claimAdminUploads.getPrimaryKeyObj());

				session.saveOrUpdate(claimAdminUploads);
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
			ClaimAdminUploadsImpl.class, claimAdminUploadsModelImpl, false,
			true);

		if (isNew) {
			claimAdminUploads.setNew(false);
		}

		claimAdminUploads.resetOriginalValues();

		return claimAdminUploads;
	}

	/**
	 * Returns the claim admin uploads with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the claim admin uploads
	 * @return the claim admin uploads
	 * @throws NoSuchClaimAdminUploadsException if a claim admin uploads with the primary key could not be found
	 */
	@Override
	public ClaimAdminUploads findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClaimAdminUploadsException {

		ClaimAdminUploads claimAdminUploads = fetchByPrimaryKey(primaryKey);

		if (claimAdminUploads == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClaimAdminUploadsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return claimAdminUploads;
	}

	/**
	 * Returns the claim admin uploads with the primary key or throws a <code>NoSuchClaimAdminUploadsException</code> if it could not be found.
	 *
	 * @param id the primary key of the claim admin uploads
	 * @return the claim admin uploads
	 * @throws NoSuchClaimAdminUploadsException if a claim admin uploads with the primary key could not be found
	 */
	@Override
	public ClaimAdminUploads findByPrimaryKey(int id)
		throws NoSuchClaimAdminUploadsException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the claim admin uploads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the claim admin uploads
	 * @return the claim admin uploads, or <code>null</code> if a claim admin uploads with the primary key could not be found
	 */
	@Override
	public ClaimAdminUploads fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the claim admin uploadses.
	 *
	 * @return the claim admin uploadses
	 */
	@Override
	public List<ClaimAdminUploads> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the claim admin uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim admin uploadses
	 * @param end the upper bound of the range of claim admin uploadses (not inclusive)
	 * @return the range of claim admin uploadses
	 */
	@Override
	public List<ClaimAdminUploads> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the claim admin uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim admin uploadses
	 * @param end the upper bound of the range of claim admin uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of claim admin uploadses
	 */
	@Override
	public List<ClaimAdminUploads> findAll(
		int start, int end,
		OrderByComparator<ClaimAdminUploads> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claim admin uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim admin uploadses
	 * @param end the upper bound of the range of claim admin uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of claim admin uploadses
	 */
	@Override
	public List<ClaimAdminUploads> findAll(
		int start, int end,
		OrderByComparator<ClaimAdminUploads> orderByComparator,
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

		List<ClaimAdminUploads> list = null;

		if (useFinderCache) {
			list = (List<ClaimAdminUploads>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CLAIMADMINUPLOADS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CLAIMADMINUPLOADS;

				sql = sql.concat(ClaimAdminUploadsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ClaimAdminUploads>)QueryUtil.list(
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
	 * Removes all the claim admin uploadses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ClaimAdminUploads claimAdminUploads : findAll()) {
			remove(claimAdminUploads);
		}
	}

	/**
	 * Returns the number of claim admin uploadses.
	 *
	 * @return the number of claim admin uploadses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CLAIMADMINUPLOADS);

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
		return "CLM_FILE_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLAIMADMINUPLOADS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ClaimAdminUploadsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the claim admin uploads persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ClaimAdminUploadsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ClaimAdminUploads.class.getName()));

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
			new String[] {"CLM_REFERENCE_NO"}, true);

		_finderPathWithoutPaginationFindByrefNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByrefNo",
			new String[] {String.class.getName()},
			new String[] {"CLM_REFERENCE_NO"}, true);

		_finderPathCountByrefNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByrefNo",
			new String[] {String.class.getName()},
			new String[] {"CLM_REFERENCE_NO"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(ClaimAdminUploadsImpl.class.getName());

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

	private static final String _SQL_SELECT_CLAIMADMINUPLOADS =
		"SELECT claimAdminUploads FROM ClaimAdminUploads claimAdminUploads";

	private static final String _SQL_SELECT_CLAIMADMINUPLOADS_WHERE =
		"SELECT claimAdminUploads FROM ClaimAdminUploads claimAdminUploads WHERE ";

	private static final String _SQL_COUNT_CLAIMADMINUPLOADS =
		"SELECT COUNT(claimAdminUploads) FROM ClaimAdminUploads claimAdminUploads";

	private static final String _SQL_COUNT_CLAIMADMINUPLOADS_WHERE =
		"SELECT COUNT(claimAdminUploads) FROM ClaimAdminUploads claimAdminUploads WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "claimAdminUploads.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ClaimAdminUploads exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ClaimAdminUploads exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ClaimAdminUploadsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "refNo", "fileName", "adminFile"});

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

	private static class ClaimAdminUploadsModelArgumentsResolver
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

			ClaimAdminUploadsModelImpl claimAdminUploadsModelImpl =
				(ClaimAdminUploadsModelImpl)baseModel;

			long columnBitmask = claimAdminUploadsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					claimAdminUploadsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						claimAdminUploadsModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					claimAdminUploadsModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ClaimAdminUploadsModelImpl claimAdminUploadsModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						claimAdminUploadsModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = claimAdminUploadsModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}