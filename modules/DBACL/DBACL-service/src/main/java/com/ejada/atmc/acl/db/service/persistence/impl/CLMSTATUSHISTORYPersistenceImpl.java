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

import com.ejada.atmc.acl.db.exception.NoSuchCLMSTATUSHISTORYException;
import com.ejada.atmc.acl.db.model.CLMSTATUSHISTORY;
import com.ejada.atmc.acl.db.model.impl.CLMSTATUSHISTORYImpl;
import com.ejada.atmc.acl.db.model.impl.CLMSTATUSHISTORYModelImpl;
import com.ejada.atmc.acl.db.service.persistence.CLMSTATUSHISTORYPersistence;
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
 * The persistence implementation for the clmstatushistory service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CLMSTATUSHISTORYPersistence.class)
public class CLMSTATUSHISTORYPersistenceImpl
	extends BasePersistenceImpl<CLMSTATUSHISTORY>
	implements CLMSTATUSHISTORYPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CLMSTATUSHISTORYUtil</code> to access the clmstatushistory persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CLMSTATUSHISTORYImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByRefNo;
	private FinderPath _finderPathWithoutPaginationFindByRefNo;
	private FinderPath _finderPathCountByRefNo;

	/**
	 * Returns all the clmstatushistories where RefNo = &#63;.
	 *
	 * @param RefNo the ref no
	 * @return the matching clmstatushistories
	 */
	@Override
	public List<CLMSTATUSHISTORY> findByRefNo(String RefNo) {
		return findByRefNo(RefNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clmstatushistories where RefNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSHISTORYModelImpl</code>.
	 * </p>
	 *
	 * @param RefNo the ref no
	 * @param start the lower bound of the range of clmstatushistories
	 * @param end the upper bound of the range of clmstatushistories (not inclusive)
	 * @return the range of matching clmstatushistories
	 */
	@Override
	public List<CLMSTATUSHISTORY> findByRefNo(
		String RefNo, int start, int end) {

		return findByRefNo(RefNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the clmstatushistories where RefNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSHISTORYModelImpl</code>.
	 * </p>
	 *
	 * @param RefNo the ref no
	 * @param start the lower bound of the range of clmstatushistories
	 * @param end the upper bound of the range of clmstatushistories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clmstatushistories
	 */
	@Override
	public List<CLMSTATUSHISTORY> findByRefNo(
		String RefNo, int start, int end,
		OrderByComparator<CLMSTATUSHISTORY> orderByComparator) {

		return findByRefNo(RefNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the clmstatushistories where RefNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSHISTORYModelImpl</code>.
	 * </p>
	 *
	 * @param RefNo the ref no
	 * @param start the lower bound of the range of clmstatushistories
	 * @param end the upper bound of the range of clmstatushistories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching clmstatushistories
	 */
	@Override
	public List<CLMSTATUSHISTORY> findByRefNo(
		String RefNo, int start, int end,
		OrderByComparator<CLMSTATUSHISTORY> orderByComparator,
		boolean useFinderCache) {

		RefNo = Objects.toString(RefNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRefNo;
				finderArgs = new Object[] {RefNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRefNo;
			finderArgs = new Object[] {RefNo, start, end, orderByComparator};
		}

		List<CLMSTATUSHISTORY> list = null;

		if (useFinderCache) {
			list = (List<CLMSTATUSHISTORY>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CLMSTATUSHISTORY clmstatushistory : list) {
					if (!RefNo.equals(clmstatushistory.getRefNo())) {
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

			sb.append(_SQL_SELECT_CLMSTATUSHISTORY_WHERE);

			boolean bindRefNo = false;

			if (RefNo.isEmpty()) {
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
				sb.append(CLMSTATUSHISTORYModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRefNo) {
					queryPos.add(RefNo);
				}

				list = (List<CLMSTATUSHISTORY>)QueryUtil.list(
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
	 * Returns the first clmstatushistory in the ordered set where RefNo = &#63;.
	 *
	 * @param RefNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clmstatushistory
	 * @throws NoSuchCLMSTATUSHISTORYException if a matching clmstatushistory could not be found
	 */
	@Override
	public CLMSTATUSHISTORY findByRefNo_First(
			String RefNo, OrderByComparator<CLMSTATUSHISTORY> orderByComparator)
		throws NoSuchCLMSTATUSHISTORYException {

		CLMSTATUSHISTORY clmstatushistory = fetchByRefNo_First(
			RefNo, orderByComparator);

		if (clmstatushistory != null) {
			return clmstatushistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("RefNo=");
		sb.append(RefNo);

		sb.append("}");

		throw new NoSuchCLMSTATUSHISTORYException(sb.toString());
	}

	/**
	 * Returns the first clmstatushistory in the ordered set where RefNo = &#63;.
	 *
	 * @param RefNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clmstatushistory, or <code>null</code> if a matching clmstatushistory could not be found
	 */
	@Override
	public CLMSTATUSHISTORY fetchByRefNo_First(
		String RefNo, OrderByComparator<CLMSTATUSHISTORY> orderByComparator) {

		List<CLMSTATUSHISTORY> list = findByRefNo(
			RefNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last clmstatushistory in the ordered set where RefNo = &#63;.
	 *
	 * @param RefNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clmstatushistory
	 * @throws NoSuchCLMSTATUSHISTORYException if a matching clmstatushistory could not be found
	 */
	@Override
	public CLMSTATUSHISTORY findByRefNo_Last(
			String RefNo, OrderByComparator<CLMSTATUSHISTORY> orderByComparator)
		throws NoSuchCLMSTATUSHISTORYException {

		CLMSTATUSHISTORY clmstatushistory = fetchByRefNo_Last(
			RefNo, orderByComparator);

		if (clmstatushistory != null) {
			return clmstatushistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("RefNo=");
		sb.append(RefNo);

		sb.append("}");

		throw new NoSuchCLMSTATUSHISTORYException(sb.toString());
	}

	/**
	 * Returns the last clmstatushistory in the ordered set where RefNo = &#63;.
	 *
	 * @param RefNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clmstatushistory, or <code>null</code> if a matching clmstatushistory could not be found
	 */
	@Override
	public CLMSTATUSHISTORY fetchByRefNo_Last(
		String RefNo, OrderByComparator<CLMSTATUSHISTORY> orderByComparator) {

		int count = countByRefNo(RefNo);

		if (count == 0) {
			return null;
		}

		List<CLMSTATUSHISTORY> list = findByRefNo(
			RefNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the clmstatushistories before and after the current clmstatushistory in the ordered set where RefNo = &#63;.
	 *
	 * @param id the primary key of the current clmstatushistory
	 * @param RefNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clmstatushistory
	 * @throws NoSuchCLMSTATUSHISTORYException if a clmstatushistory with the primary key could not be found
	 */
	@Override
	public CLMSTATUSHISTORY[] findByRefNo_PrevAndNext(
			int id, String RefNo,
			OrderByComparator<CLMSTATUSHISTORY> orderByComparator)
		throws NoSuchCLMSTATUSHISTORYException {

		RefNo = Objects.toString(RefNo, "");

		CLMSTATUSHISTORY clmstatushistory = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CLMSTATUSHISTORY[] array = new CLMSTATUSHISTORYImpl[3];

			array[0] = getByRefNo_PrevAndNext(
				session, clmstatushistory, RefNo, orderByComparator, true);

			array[1] = clmstatushistory;

			array[2] = getByRefNo_PrevAndNext(
				session, clmstatushistory, RefNo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CLMSTATUSHISTORY getByRefNo_PrevAndNext(
		Session session, CLMSTATUSHISTORY clmstatushistory, String RefNo,
		OrderByComparator<CLMSTATUSHISTORY> orderByComparator,
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

		sb.append(_SQL_SELECT_CLMSTATUSHISTORY_WHERE);

		boolean bindRefNo = false;

		if (RefNo.isEmpty()) {
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
			sb.append(CLMSTATUSHISTORYModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRefNo) {
			queryPos.add(RefNo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						clmstatushistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CLMSTATUSHISTORY> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the clmstatushistories where RefNo = &#63; from the database.
	 *
	 * @param RefNo the ref no
	 */
	@Override
	public void removeByRefNo(String RefNo) {
		for (CLMSTATUSHISTORY clmstatushistory :
				findByRefNo(
					RefNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(clmstatushistory);
		}
	}

	/**
	 * Returns the number of clmstatushistories where RefNo = &#63;.
	 *
	 * @param RefNo the ref no
	 * @return the number of matching clmstatushistories
	 */
	@Override
	public int countByRefNo(String RefNo) {
		RefNo = Objects.toString(RefNo, "");

		FinderPath finderPath = _finderPathCountByRefNo;

		Object[] finderArgs = new Object[] {RefNo};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLMSTATUSHISTORY_WHERE);

			boolean bindRefNo = false;

			if (RefNo.isEmpty()) {
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
					queryPos.add(RefNo);
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
		"clmstatushistory.RefNo = ?";

	private static final String _FINDER_COLUMN_REFNO_REFNO_3 =
		"(clmstatushistory.RefNo IS NULL OR clmstatushistory.RefNo = '')";

	public CLMSTATUSHISTORYPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "HISTORY_ID");
		dbColumnNames.put("RefNo", "REFERENCE_NO");
		dbColumnNames.put("date", "HISTORY_DATE");
		dbColumnNames.put("userName", "USER_NAME");
		dbColumnNames.put("claimStatus", "STATUS");
		dbColumnNames.put("reason", "REASON");

		setDBColumnNames(dbColumnNames);

		setModelClass(CLMSTATUSHISTORY.class);

		setModelImplClass(CLMSTATUSHISTORYImpl.class);
		setModelPKClass(int.class);
	}

	/**
	 * Caches the clmstatushistory in the entity cache if it is enabled.
	 *
	 * @param clmstatushistory the clmstatushistory
	 */
	@Override
	public void cacheResult(CLMSTATUSHISTORY clmstatushistory) {
		dummyEntityCache.putResult(
			CLMSTATUSHISTORYImpl.class, clmstatushistory.getPrimaryKey(),
			clmstatushistory);
	}

	/**
	 * Caches the clmstatushistories in the entity cache if it is enabled.
	 *
	 * @param clmstatushistories the clmstatushistories
	 */
	@Override
	public void cacheResult(List<CLMSTATUSHISTORY> clmstatushistories) {
		for (CLMSTATUSHISTORY clmstatushistory : clmstatushistories) {
			if (dummyEntityCache.getResult(
					CLMSTATUSHISTORYImpl.class,
					clmstatushistory.getPrimaryKey()) == null) {

				cacheResult(clmstatushistory);
			}
		}
	}

	/**
	 * Clears the cache for all clmstatushistories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(CLMSTATUSHISTORYImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the clmstatushistory.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CLMSTATUSHISTORY clmstatushistory) {
		dummyEntityCache.removeResult(
			CLMSTATUSHISTORYImpl.class, clmstatushistory);
	}

	@Override
	public void clearCache(List<CLMSTATUSHISTORY> clmstatushistories) {
		for (CLMSTATUSHISTORY clmstatushistory : clmstatushistories) {
			dummyEntityCache.removeResult(
				CLMSTATUSHISTORYImpl.class, clmstatushistory);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				CLMSTATUSHISTORYImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new clmstatushistory with the primary key. Does not add the clmstatushistory to the database.
	 *
	 * @param id the primary key for the new clmstatushistory
	 * @return the new clmstatushistory
	 */
	@Override
	public CLMSTATUSHISTORY create(int id) {
		CLMSTATUSHISTORY clmstatushistory = new CLMSTATUSHISTORYImpl();

		clmstatushistory.setNew(true);
		clmstatushistory.setPrimaryKey(id);

		return clmstatushistory;
	}

	/**
	 * Removes the clmstatushistory with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the clmstatushistory
	 * @return the clmstatushistory that was removed
	 * @throws NoSuchCLMSTATUSHISTORYException if a clmstatushistory with the primary key could not be found
	 */
	@Override
	public CLMSTATUSHISTORY remove(int id)
		throws NoSuchCLMSTATUSHISTORYException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the clmstatushistory with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the clmstatushistory
	 * @return the clmstatushistory that was removed
	 * @throws NoSuchCLMSTATUSHISTORYException if a clmstatushistory with the primary key could not be found
	 */
	@Override
	public CLMSTATUSHISTORY remove(Serializable primaryKey)
		throws NoSuchCLMSTATUSHISTORYException {

		Session session = null;

		try {
			session = openSession();

			CLMSTATUSHISTORY clmstatushistory = (CLMSTATUSHISTORY)session.get(
				CLMSTATUSHISTORYImpl.class, primaryKey);

			if (clmstatushistory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCLMSTATUSHISTORYException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(clmstatushistory);
		}
		catch (NoSuchCLMSTATUSHISTORYException noSuchEntityException) {
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
	protected CLMSTATUSHISTORY removeImpl(CLMSTATUSHISTORY clmstatushistory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(clmstatushistory)) {
				clmstatushistory = (CLMSTATUSHISTORY)session.get(
					CLMSTATUSHISTORYImpl.class,
					clmstatushistory.getPrimaryKeyObj());
			}

			if (clmstatushistory != null) {
				session.delete(clmstatushistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (clmstatushistory != null) {
			clearCache(clmstatushistory);
		}

		return clmstatushistory;
	}

	@Override
	public CLMSTATUSHISTORY updateImpl(CLMSTATUSHISTORY clmstatushistory) {
		boolean isNew = clmstatushistory.isNew();

		if (!(clmstatushistory instanceof CLMSTATUSHISTORYModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(clmstatushistory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					clmstatushistory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in clmstatushistory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CLMSTATUSHISTORY implementation " +
					clmstatushistory.getClass());
		}

		CLMSTATUSHISTORYModelImpl clmstatushistoryModelImpl =
			(CLMSTATUSHISTORYModelImpl)clmstatushistory;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(clmstatushistory);
			}
			else {
				clmstatushistory = (CLMSTATUSHISTORY)session.merge(
					clmstatushistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			CLMSTATUSHISTORYImpl.class, clmstatushistoryModelImpl, false, true);

		if (isNew) {
			clmstatushistory.setNew(false);
		}

		clmstatushistory.resetOriginalValues();

		return clmstatushistory;
	}

	/**
	 * Returns the clmstatushistory with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the clmstatushistory
	 * @return the clmstatushistory
	 * @throws NoSuchCLMSTATUSHISTORYException if a clmstatushistory with the primary key could not be found
	 */
	@Override
	public CLMSTATUSHISTORY findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCLMSTATUSHISTORYException {

		CLMSTATUSHISTORY clmstatushistory = fetchByPrimaryKey(primaryKey);

		if (clmstatushistory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCLMSTATUSHISTORYException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return clmstatushistory;
	}

	/**
	 * Returns the clmstatushistory with the primary key or throws a <code>NoSuchCLMSTATUSHISTORYException</code> if it could not be found.
	 *
	 * @param id the primary key of the clmstatushistory
	 * @return the clmstatushistory
	 * @throws NoSuchCLMSTATUSHISTORYException if a clmstatushistory with the primary key could not be found
	 */
	@Override
	public CLMSTATUSHISTORY findByPrimaryKey(int id)
		throws NoSuchCLMSTATUSHISTORYException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the clmstatushistory with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the clmstatushistory
	 * @return the clmstatushistory, or <code>null</code> if a clmstatushistory with the primary key could not be found
	 */
	@Override
	public CLMSTATUSHISTORY fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the clmstatushistories.
	 *
	 * @return the clmstatushistories
	 */
	@Override
	public List<CLMSTATUSHISTORY> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clmstatushistories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSHISTORYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatushistories
	 * @param end the upper bound of the range of clmstatushistories (not inclusive)
	 * @return the range of clmstatushistories
	 */
	@Override
	public List<CLMSTATUSHISTORY> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the clmstatushistories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSHISTORYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatushistories
	 * @param end the upper bound of the range of clmstatushistories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clmstatushistories
	 */
	@Override
	public List<CLMSTATUSHISTORY> findAll(
		int start, int end,
		OrderByComparator<CLMSTATUSHISTORY> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the clmstatushistories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSHISTORYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatushistories
	 * @param end the upper bound of the range of clmstatushistories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of clmstatushistories
	 */
	@Override
	public List<CLMSTATUSHISTORY> findAll(
		int start, int end,
		OrderByComparator<CLMSTATUSHISTORY> orderByComparator,
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

		List<CLMSTATUSHISTORY> list = null;

		if (useFinderCache) {
			list = (List<CLMSTATUSHISTORY>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CLMSTATUSHISTORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CLMSTATUSHISTORY;

				sql = sql.concat(CLMSTATUSHISTORYModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CLMSTATUSHISTORY>)QueryUtil.list(
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
	 * Removes all the clmstatushistories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CLMSTATUSHISTORY clmstatushistory : findAll()) {
			remove(clmstatushistory);
		}
	}

	/**
	 * Returns the number of clmstatushistories.
	 *
	 * @return the number of clmstatushistories
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CLMSTATUSHISTORY);

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
		return "HISTORY_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLMSTATUSHISTORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CLMSTATUSHISTORYModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the clmstatushistory persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new CLMSTATUSHISTORYModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CLMSTATUSHISTORY.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByRefNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRefNo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"REFERENCE_NO"}, true);

		_finderPathWithoutPaginationFindByRefNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRefNo",
			new String[] {String.class.getName()},
			new String[] {"REFERENCE_NO"}, true);

		_finderPathCountByRefNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRefNo",
			new String[] {String.class.getName()},
			new String[] {"REFERENCE_NO"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(CLMSTATUSHISTORYImpl.class.getName());

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

	private static final String _SQL_SELECT_CLMSTATUSHISTORY =
		"SELECT clmstatushistory FROM CLMSTATUSHISTORY clmstatushistory";

	private static final String _SQL_SELECT_CLMSTATUSHISTORY_WHERE =
		"SELECT clmstatushistory FROM CLMSTATUSHISTORY clmstatushistory WHERE ";

	private static final String _SQL_COUNT_CLMSTATUSHISTORY =
		"SELECT COUNT(clmstatushistory) FROM CLMSTATUSHISTORY clmstatushistory";

	private static final String _SQL_COUNT_CLMSTATUSHISTORY_WHERE =
		"SELECT COUNT(clmstatushistory) FROM CLMSTATUSHISTORY clmstatushistory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "clmstatushistory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CLMSTATUSHISTORY exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CLMSTATUSHISTORY exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CLMSTATUSHISTORYPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"id", "RefNo", "date", "userName", "claimStatus", "reason"
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

	private static class CLMSTATUSHISTORYModelArgumentsResolver
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

			CLMSTATUSHISTORYModelImpl clmstatushistoryModelImpl =
				(CLMSTATUSHISTORYModelImpl)baseModel;

			long columnBitmask = clmstatushistoryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					clmstatushistoryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						clmstatushistoryModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					clmstatushistoryModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			CLMSTATUSHISTORYModelImpl clmstatushistoryModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						clmstatushistoryModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = clmstatushistoryModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}