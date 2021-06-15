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

import com.ejada.atmc.acl.db.exception.NoSuchCLMWORKFLOWException;
import com.ejada.atmc.acl.db.model.CLMWORKFLOW;
import com.ejada.atmc.acl.db.model.impl.CLMWORKFLOWImpl;
import com.ejada.atmc.acl.db.model.impl.CLMWORKFLOWModelImpl;
import com.ejada.atmc.acl.db.service.persistence.CLMWORKFLOWPersistence;
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
 * The persistence implementation for the clmworkflow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CLMWORKFLOWPersistence.class)
public class CLMWORKFLOWPersistenceImpl
	extends BasePersistenceImpl<CLMWORKFLOW> implements CLMWORKFLOWPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CLMWORKFLOWUtil</code> to access the clmworkflow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CLMWORKFLOWImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByrole;
	private FinderPath _finderPathWithoutPaginationFindByrole;
	private FinderPath _finderPathCountByrole;

	/**
	 * Returns all the clmworkflows where role = &#63;.
	 *
	 * @param role the role
	 * @return the matching clmworkflows
	 */
	@Override
	public List<CLMWORKFLOW> findByrole(String role) {
		return findByrole(role, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clmworkflows where role = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMWORKFLOWModelImpl</code>.
	 * </p>
	 *
	 * @param role the role
	 * @param start the lower bound of the range of clmworkflows
	 * @param end the upper bound of the range of clmworkflows (not inclusive)
	 * @return the range of matching clmworkflows
	 */
	@Override
	public List<CLMWORKFLOW> findByrole(String role, int start, int end) {
		return findByrole(role, start, end, null);
	}

	/**
	 * Returns an ordered range of all the clmworkflows where role = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMWORKFLOWModelImpl</code>.
	 * </p>
	 *
	 * @param role the role
	 * @param start the lower bound of the range of clmworkflows
	 * @param end the upper bound of the range of clmworkflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clmworkflows
	 */
	@Override
	public List<CLMWORKFLOW> findByrole(
		String role, int start, int end,
		OrderByComparator<CLMWORKFLOW> orderByComparator) {

		return findByrole(role, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the clmworkflows where role = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMWORKFLOWModelImpl</code>.
	 * </p>
	 *
	 * @param role the role
	 * @param start the lower bound of the range of clmworkflows
	 * @param end the upper bound of the range of clmworkflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching clmworkflows
	 */
	@Override
	public List<CLMWORKFLOW> findByrole(
		String role, int start, int end,
		OrderByComparator<CLMWORKFLOW> orderByComparator,
		boolean useFinderCache) {

		role = Objects.toString(role, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByrole;
				finderArgs = new Object[] {role};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByrole;
			finderArgs = new Object[] {role, start, end, orderByComparator};
		}

		List<CLMWORKFLOW> list = null;

		if (useFinderCache) {
			list = (List<CLMWORKFLOW>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CLMWORKFLOW clmworkflow : list) {
					if (!role.equals(clmworkflow.getRole())) {
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

			sb.append(_SQL_SELECT_CLMWORKFLOW_WHERE);

			boolean bindRole = false;

			if (role.isEmpty()) {
				sb.append(_FINDER_COLUMN_ROLE_ROLE_3);
			}
			else {
				bindRole = true;

				sb.append(_FINDER_COLUMN_ROLE_ROLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CLMWORKFLOWModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRole) {
					queryPos.add(role);
				}

				list = (List<CLMWORKFLOW>)QueryUtil.list(
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
	 * Returns the first clmworkflow in the ordered set where role = &#63;.
	 *
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a matching clmworkflow could not be found
	 */
	@Override
	public CLMWORKFLOW findByrole_First(
			String role, OrderByComparator<CLMWORKFLOW> orderByComparator)
		throws NoSuchCLMWORKFLOWException {

		CLMWORKFLOW clmworkflow = fetchByrole_First(role, orderByComparator);

		if (clmworkflow != null) {
			return clmworkflow;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("role=");
		sb.append(role);

		sb.append("}");

		throw new NoSuchCLMWORKFLOWException(sb.toString());
	}

	/**
	 * Returns the first clmworkflow in the ordered set where role = &#63;.
	 *
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clmworkflow, or <code>null</code> if a matching clmworkflow could not be found
	 */
	@Override
	public CLMWORKFLOW fetchByrole_First(
		String role, OrderByComparator<CLMWORKFLOW> orderByComparator) {

		List<CLMWORKFLOW> list = findByrole(role, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last clmworkflow in the ordered set where role = &#63;.
	 *
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a matching clmworkflow could not be found
	 */
	@Override
	public CLMWORKFLOW findByrole_Last(
			String role, OrderByComparator<CLMWORKFLOW> orderByComparator)
		throws NoSuchCLMWORKFLOWException {

		CLMWORKFLOW clmworkflow = fetchByrole_Last(role, orderByComparator);

		if (clmworkflow != null) {
			return clmworkflow;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("role=");
		sb.append(role);

		sb.append("}");

		throw new NoSuchCLMWORKFLOWException(sb.toString());
	}

	/**
	 * Returns the last clmworkflow in the ordered set where role = &#63;.
	 *
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clmworkflow, or <code>null</code> if a matching clmworkflow could not be found
	 */
	@Override
	public CLMWORKFLOW fetchByrole_Last(
		String role, OrderByComparator<CLMWORKFLOW> orderByComparator) {

		int count = countByrole(role);

		if (count == 0) {
			return null;
		}

		List<CLMWORKFLOW> list = findByrole(
			role, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the clmworkflows before and after the current clmworkflow in the ordered set where role = &#63;.
	 *
	 * @param id the primary key of the current clmworkflow
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a clmworkflow with the primary key could not be found
	 */
	@Override
	public CLMWORKFLOW[] findByrole_PrevAndNext(
			int id, String role,
			OrderByComparator<CLMWORKFLOW> orderByComparator)
		throws NoSuchCLMWORKFLOWException {

		role = Objects.toString(role, "");

		CLMWORKFLOW clmworkflow = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CLMWORKFLOW[] array = new CLMWORKFLOWImpl[3];

			array[0] = getByrole_PrevAndNext(
				session, clmworkflow, role, orderByComparator, true);

			array[1] = clmworkflow;

			array[2] = getByrole_PrevAndNext(
				session, clmworkflow, role, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CLMWORKFLOW getByrole_PrevAndNext(
		Session session, CLMWORKFLOW clmworkflow, String role,
		OrderByComparator<CLMWORKFLOW> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLMWORKFLOW_WHERE);

		boolean bindRole = false;

		if (role.isEmpty()) {
			sb.append(_FINDER_COLUMN_ROLE_ROLE_3);
		}
		else {
			bindRole = true;

			sb.append(_FINDER_COLUMN_ROLE_ROLE_2);
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
			sb.append(CLMWORKFLOWModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRole) {
			queryPos.add(role);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(clmworkflow)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CLMWORKFLOW> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the clmworkflows where role = &#63; from the database.
	 *
	 * @param role the role
	 */
	@Override
	public void removeByrole(String role) {
		for (CLMWORKFLOW clmworkflow :
				findByrole(role, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(clmworkflow);
		}
	}

	/**
	 * Returns the number of clmworkflows where role = &#63;.
	 *
	 * @param role the role
	 * @return the number of matching clmworkflows
	 */
	@Override
	public int countByrole(String role) {
		role = Objects.toString(role, "");

		FinderPath finderPath = _finderPathCountByrole;

		Object[] finderArgs = new Object[] {role};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLMWORKFLOW_WHERE);

			boolean bindRole = false;

			if (role.isEmpty()) {
				sb.append(_FINDER_COLUMN_ROLE_ROLE_3);
			}
			else {
				bindRole = true;

				sb.append(_FINDER_COLUMN_ROLE_ROLE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRole) {
					queryPos.add(role);
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

	private static final String _FINDER_COLUMN_ROLE_ROLE_2 =
		"clmworkflow.role = ?";

	private static final String _FINDER_COLUMN_ROLE_ROLE_3 =
		"(clmworkflow.role IS NULL OR clmworkflow.role = '')";

	private FinderPath _finderPathWithPaginationFindByroleStatus;
	private FinderPath _finderPathWithoutPaginationFindByroleStatus;
	private FinderPath _finderPathCountByroleStatus;

	/**
	 * Returns all the clmworkflows where role = &#63; and initialStatus = &#63;.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @return the matching clmworkflows
	 */
	@Override
	public List<CLMWORKFLOW> findByroleStatus(
		String role, String initialStatus) {

		return findByroleStatus(
			role, initialStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clmworkflows where role = &#63; and initialStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMWORKFLOWModelImpl</code>.
	 * </p>
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param start the lower bound of the range of clmworkflows
	 * @param end the upper bound of the range of clmworkflows (not inclusive)
	 * @return the range of matching clmworkflows
	 */
	@Override
	public List<CLMWORKFLOW> findByroleStatus(
		String role, String initialStatus, int start, int end) {

		return findByroleStatus(role, initialStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the clmworkflows where role = &#63; and initialStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMWORKFLOWModelImpl</code>.
	 * </p>
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param start the lower bound of the range of clmworkflows
	 * @param end the upper bound of the range of clmworkflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clmworkflows
	 */
	@Override
	public List<CLMWORKFLOW> findByroleStatus(
		String role, String initialStatus, int start, int end,
		OrderByComparator<CLMWORKFLOW> orderByComparator) {

		return findByroleStatus(
			role, initialStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the clmworkflows where role = &#63; and initialStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMWORKFLOWModelImpl</code>.
	 * </p>
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param start the lower bound of the range of clmworkflows
	 * @param end the upper bound of the range of clmworkflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching clmworkflows
	 */
	@Override
	public List<CLMWORKFLOW> findByroleStatus(
		String role, String initialStatus, int start, int end,
		OrderByComparator<CLMWORKFLOW> orderByComparator,
		boolean useFinderCache) {

		role = Objects.toString(role, "");
		initialStatus = Objects.toString(initialStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByroleStatus;
				finderArgs = new Object[] {role, initialStatus};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByroleStatus;
			finderArgs = new Object[] {
				role, initialStatus, start, end, orderByComparator
			};
		}

		List<CLMWORKFLOW> list = null;

		if (useFinderCache) {
			list = (List<CLMWORKFLOW>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CLMWORKFLOW clmworkflow : list) {
					if (!role.equals(clmworkflow.getRole()) ||
						!initialStatus.equals(clmworkflow.getInitialStatus())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CLMWORKFLOW_WHERE);

			boolean bindRole = false;

			if (role.isEmpty()) {
				sb.append(_FINDER_COLUMN_ROLESTATUS_ROLE_3);
			}
			else {
				bindRole = true;

				sb.append(_FINDER_COLUMN_ROLESTATUS_ROLE_2);
			}

			boolean bindInitialStatus = false;

			if (initialStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_ROLESTATUS_INITIALSTATUS_3);
			}
			else {
				bindInitialStatus = true;

				sb.append(_FINDER_COLUMN_ROLESTATUS_INITIALSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CLMWORKFLOWModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRole) {
					queryPos.add(role);
				}

				if (bindInitialStatus) {
					queryPos.add(initialStatus);
				}

				list = (List<CLMWORKFLOW>)QueryUtil.list(
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
	 * Returns the first clmworkflow in the ordered set where role = &#63; and initialStatus = &#63;.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a matching clmworkflow could not be found
	 */
	@Override
	public CLMWORKFLOW findByroleStatus_First(
			String role, String initialStatus,
			OrderByComparator<CLMWORKFLOW> orderByComparator)
		throws NoSuchCLMWORKFLOWException {

		CLMWORKFLOW clmworkflow = fetchByroleStatus_First(
			role, initialStatus, orderByComparator);

		if (clmworkflow != null) {
			return clmworkflow;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("role=");
		sb.append(role);

		sb.append(", initialStatus=");
		sb.append(initialStatus);

		sb.append("}");

		throw new NoSuchCLMWORKFLOWException(sb.toString());
	}

	/**
	 * Returns the first clmworkflow in the ordered set where role = &#63; and initialStatus = &#63;.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clmworkflow, or <code>null</code> if a matching clmworkflow could not be found
	 */
	@Override
	public CLMWORKFLOW fetchByroleStatus_First(
		String role, String initialStatus,
		OrderByComparator<CLMWORKFLOW> orderByComparator) {

		List<CLMWORKFLOW> list = findByroleStatus(
			role, initialStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last clmworkflow in the ordered set where role = &#63; and initialStatus = &#63;.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a matching clmworkflow could not be found
	 */
	@Override
	public CLMWORKFLOW findByroleStatus_Last(
			String role, String initialStatus,
			OrderByComparator<CLMWORKFLOW> orderByComparator)
		throws NoSuchCLMWORKFLOWException {

		CLMWORKFLOW clmworkflow = fetchByroleStatus_Last(
			role, initialStatus, orderByComparator);

		if (clmworkflow != null) {
			return clmworkflow;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("role=");
		sb.append(role);

		sb.append(", initialStatus=");
		sb.append(initialStatus);

		sb.append("}");

		throw new NoSuchCLMWORKFLOWException(sb.toString());
	}

	/**
	 * Returns the last clmworkflow in the ordered set where role = &#63; and initialStatus = &#63;.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clmworkflow, or <code>null</code> if a matching clmworkflow could not be found
	 */
	@Override
	public CLMWORKFLOW fetchByroleStatus_Last(
		String role, String initialStatus,
		OrderByComparator<CLMWORKFLOW> orderByComparator) {

		int count = countByroleStatus(role, initialStatus);

		if (count == 0) {
			return null;
		}

		List<CLMWORKFLOW> list = findByroleStatus(
			role, initialStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the clmworkflows before and after the current clmworkflow in the ordered set where role = &#63; and initialStatus = &#63;.
	 *
	 * @param id the primary key of the current clmworkflow
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a clmworkflow with the primary key could not be found
	 */
	@Override
	public CLMWORKFLOW[] findByroleStatus_PrevAndNext(
			int id, String role, String initialStatus,
			OrderByComparator<CLMWORKFLOW> orderByComparator)
		throws NoSuchCLMWORKFLOWException {

		role = Objects.toString(role, "");
		initialStatus = Objects.toString(initialStatus, "");

		CLMWORKFLOW clmworkflow = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CLMWORKFLOW[] array = new CLMWORKFLOWImpl[3];

			array[0] = getByroleStatus_PrevAndNext(
				session, clmworkflow, role, initialStatus, orderByComparator,
				true);

			array[1] = clmworkflow;

			array[2] = getByroleStatus_PrevAndNext(
				session, clmworkflow, role, initialStatus, orderByComparator,
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

	protected CLMWORKFLOW getByroleStatus_PrevAndNext(
		Session session, CLMWORKFLOW clmworkflow, String role,
		String initialStatus, OrderByComparator<CLMWORKFLOW> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CLMWORKFLOW_WHERE);

		boolean bindRole = false;

		if (role.isEmpty()) {
			sb.append(_FINDER_COLUMN_ROLESTATUS_ROLE_3);
		}
		else {
			bindRole = true;

			sb.append(_FINDER_COLUMN_ROLESTATUS_ROLE_2);
		}

		boolean bindInitialStatus = false;

		if (initialStatus.isEmpty()) {
			sb.append(_FINDER_COLUMN_ROLESTATUS_INITIALSTATUS_3);
		}
		else {
			bindInitialStatus = true;

			sb.append(_FINDER_COLUMN_ROLESTATUS_INITIALSTATUS_2);
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
			sb.append(CLMWORKFLOWModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRole) {
			queryPos.add(role);
		}

		if (bindInitialStatus) {
			queryPos.add(initialStatus);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(clmworkflow)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CLMWORKFLOW> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the clmworkflows where role = &#63; and initialStatus = &#63; from the database.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 */
	@Override
	public void removeByroleStatus(String role, String initialStatus) {
		for (CLMWORKFLOW clmworkflow :
				findByroleStatus(
					role, initialStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(clmworkflow);
		}
	}

	/**
	 * Returns the number of clmworkflows where role = &#63; and initialStatus = &#63;.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @return the number of matching clmworkflows
	 */
	@Override
	public int countByroleStatus(String role, String initialStatus) {
		role = Objects.toString(role, "");
		initialStatus = Objects.toString(initialStatus, "");

		FinderPath finderPath = _finderPathCountByroleStatus;

		Object[] finderArgs = new Object[] {role, initialStatus};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CLMWORKFLOW_WHERE);

			boolean bindRole = false;

			if (role.isEmpty()) {
				sb.append(_FINDER_COLUMN_ROLESTATUS_ROLE_3);
			}
			else {
				bindRole = true;

				sb.append(_FINDER_COLUMN_ROLESTATUS_ROLE_2);
			}

			boolean bindInitialStatus = false;

			if (initialStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_ROLESTATUS_INITIALSTATUS_3);
			}
			else {
				bindInitialStatus = true;

				sb.append(_FINDER_COLUMN_ROLESTATUS_INITIALSTATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRole) {
					queryPos.add(role);
				}

				if (bindInitialStatus) {
					queryPos.add(initialStatus);
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

	private static final String _FINDER_COLUMN_ROLESTATUS_ROLE_2 =
		"clmworkflow.role = ? AND ";

	private static final String _FINDER_COLUMN_ROLESTATUS_ROLE_3 =
		"(clmworkflow.role IS NULL OR clmworkflow.role = '') AND ";

	private static final String _FINDER_COLUMN_ROLESTATUS_INITIALSTATUS_2 =
		"clmworkflow.initialStatus = ?";

	private static final String _FINDER_COLUMN_ROLESTATUS_INITIALSTATUS_3 =
		"(clmworkflow.initialStatus IS NULL OR clmworkflow.initialStatus = '')";

	public CLMWORKFLOWPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "ID");
		dbColumnNames.put("role", "ROLE");
		dbColumnNames.put("initialStatus", "INITIAL_STATUS");
		dbColumnNames.put("action", "ACTION");
		dbColumnNames.put("newStatus", "NEW_STATUS");

		setDBColumnNames(dbColumnNames);

		setModelClass(CLMWORKFLOW.class);

		setModelImplClass(CLMWORKFLOWImpl.class);
		setModelPKClass(int.class);
	}

	/**
	 * Caches the clmworkflow in the entity cache if it is enabled.
	 *
	 * @param clmworkflow the clmworkflow
	 */
	@Override
	public void cacheResult(CLMWORKFLOW clmworkflow) {
		dummyEntityCache.putResult(
			CLMWORKFLOWImpl.class, clmworkflow.getPrimaryKey(), clmworkflow);
	}

	/**
	 * Caches the clmworkflows in the entity cache if it is enabled.
	 *
	 * @param clmworkflows the clmworkflows
	 */
	@Override
	public void cacheResult(List<CLMWORKFLOW> clmworkflows) {
		for (CLMWORKFLOW clmworkflow : clmworkflows) {
			if (dummyEntityCache.getResult(
					CLMWORKFLOWImpl.class, clmworkflow.getPrimaryKey()) ==
						null) {

				cacheResult(clmworkflow);
			}
		}
	}

	/**
	 * Clears the cache for all clmworkflows.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(CLMWORKFLOWImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the clmworkflow.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CLMWORKFLOW clmworkflow) {
		dummyEntityCache.removeResult(CLMWORKFLOWImpl.class, clmworkflow);
	}

	@Override
	public void clearCache(List<CLMWORKFLOW> clmworkflows) {
		for (CLMWORKFLOW clmworkflow : clmworkflows) {
			dummyEntityCache.removeResult(CLMWORKFLOWImpl.class, clmworkflow);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(CLMWORKFLOWImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new clmworkflow with the primary key. Does not add the clmworkflow to the database.
	 *
	 * @param id the primary key for the new clmworkflow
	 * @return the new clmworkflow
	 */
	@Override
	public CLMWORKFLOW create(int id) {
		CLMWORKFLOW clmworkflow = new CLMWORKFLOWImpl();

		clmworkflow.setNew(true);
		clmworkflow.setPrimaryKey(id);

		return clmworkflow;
	}

	/**
	 * Removes the clmworkflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the clmworkflow
	 * @return the clmworkflow that was removed
	 * @throws NoSuchCLMWORKFLOWException if a clmworkflow with the primary key could not be found
	 */
	@Override
	public CLMWORKFLOW remove(int id) throws NoSuchCLMWORKFLOWException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the clmworkflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the clmworkflow
	 * @return the clmworkflow that was removed
	 * @throws NoSuchCLMWORKFLOWException if a clmworkflow with the primary key could not be found
	 */
	@Override
	public CLMWORKFLOW remove(Serializable primaryKey)
		throws NoSuchCLMWORKFLOWException {

		Session session = null;

		try {
			session = openSession();

			CLMWORKFLOW clmworkflow = (CLMWORKFLOW)session.get(
				CLMWORKFLOWImpl.class, primaryKey);

			if (clmworkflow == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCLMWORKFLOWException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(clmworkflow);
		}
		catch (NoSuchCLMWORKFLOWException noSuchEntityException) {
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
	protected CLMWORKFLOW removeImpl(CLMWORKFLOW clmworkflow) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(clmworkflow)) {
				clmworkflow = (CLMWORKFLOW)session.get(
					CLMWORKFLOWImpl.class, clmworkflow.getPrimaryKeyObj());
			}

			if (clmworkflow != null) {
				session.delete(clmworkflow);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (clmworkflow != null) {
			clearCache(clmworkflow);
		}

		return clmworkflow;
	}

	@Override
	public CLMWORKFLOW updateImpl(CLMWORKFLOW clmworkflow) {
		boolean isNew = clmworkflow.isNew();

		if (!(clmworkflow instanceof CLMWORKFLOWModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(clmworkflow.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(clmworkflow);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in clmworkflow proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CLMWORKFLOW implementation " +
					clmworkflow.getClass());
		}

		CLMWORKFLOWModelImpl clmworkflowModelImpl =
			(CLMWORKFLOWModelImpl)clmworkflow;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(clmworkflow);
			}
			else {
				clmworkflow = (CLMWORKFLOW)session.merge(clmworkflow);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			CLMWORKFLOWImpl.class, clmworkflowModelImpl, false, true);

		if (isNew) {
			clmworkflow.setNew(false);
		}

		clmworkflow.resetOriginalValues();

		return clmworkflow;
	}

	/**
	 * Returns the clmworkflow with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the clmworkflow
	 * @return the clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a clmworkflow with the primary key could not be found
	 */
	@Override
	public CLMWORKFLOW findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCLMWORKFLOWException {

		CLMWORKFLOW clmworkflow = fetchByPrimaryKey(primaryKey);

		if (clmworkflow == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCLMWORKFLOWException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return clmworkflow;
	}

	/**
	 * Returns the clmworkflow with the primary key or throws a <code>NoSuchCLMWORKFLOWException</code> if it could not be found.
	 *
	 * @param id the primary key of the clmworkflow
	 * @return the clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a clmworkflow with the primary key could not be found
	 */
	@Override
	public CLMWORKFLOW findByPrimaryKey(int id)
		throws NoSuchCLMWORKFLOWException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the clmworkflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the clmworkflow
	 * @return the clmworkflow, or <code>null</code> if a clmworkflow with the primary key could not be found
	 */
	@Override
	public CLMWORKFLOW fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the clmworkflows.
	 *
	 * @return the clmworkflows
	 */
	@Override
	public List<CLMWORKFLOW> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clmworkflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMWORKFLOWModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmworkflows
	 * @param end the upper bound of the range of clmworkflows (not inclusive)
	 * @return the range of clmworkflows
	 */
	@Override
	public List<CLMWORKFLOW> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the clmworkflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMWORKFLOWModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmworkflows
	 * @param end the upper bound of the range of clmworkflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clmworkflows
	 */
	@Override
	public List<CLMWORKFLOW> findAll(
		int start, int end, OrderByComparator<CLMWORKFLOW> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the clmworkflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMWORKFLOWModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmworkflows
	 * @param end the upper bound of the range of clmworkflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of clmworkflows
	 */
	@Override
	public List<CLMWORKFLOW> findAll(
		int start, int end, OrderByComparator<CLMWORKFLOW> orderByComparator,
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

		List<CLMWORKFLOW> list = null;

		if (useFinderCache) {
			list = (List<CLMWORKFLOW>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CLMWORKFLOW);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CLMWORKFLOW;

				sql = sql.concat(CLMWORKFLOWModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CLMWORKFLOW>)QueryUtil.list(
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
	 * Removes all the clmworkflows from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CLMWORKFLOW clmworkflow : findAll()) {
			remove(clmworkflow);
		}
	}

	/**
	 * Returns the number of clmworkflows.
	 *
	 * @return the number of clmworkflows
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CLMWORKFLOW);

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
		return _SQL_SELECT_CLMWORKFLOW;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CLMWORKFLOWModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the clmworkflow persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CLMWORKFLOWModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CLMWORKFLOW.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByrole = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByrole",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"ROLE"}, true);

		_finderPathWithoutPaginationFindByrole = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByrole",
			new String[] {String.class.getName()}, new String[] {"ROLE"}, true);

		_finderPathCountByrole = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByrole",
			new String[] {String.class.getName()}, new String[] {"ROLE"},
			false);

		_finderPathWithPaginationFindByroleStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByroleStatus",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"ROLE", "INITIAL_STATUS"}, true);

		_finderPathWithoutPaginationFindByroleStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByroleStatus",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"ROLE", "INITIAL_STATUS"}, true);

		_finderPathCountByroleStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByroleStatus",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"ROLE", "INITIAL_STATUS"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(CLMWORKFLOWImpl.class.getName());

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

	private static final String _SQL_SELECT_CLMWORKFLOW =
		"SELECT clmworkflow FROM CLMWORKFLOW clmworkflow";

	private static final String _SQL_SELECT_CLMWORKFLOW_WHERE =
		"SELECT clmworkflow FROM CLMWORKFLOW clmworkflow WHERE ";

	private static final String _SQL_COUNT_CLMWORKFLOW =
		"SELECT COUNT(clmworkflow) FROM CLMWORKFLOW clmworkflow";

	private static final String _SQL_COUNT_CLMWORKFLOW_WHERE =
		"SELECT COUNT(clmworkflow) FROM CLMWORKFLOW clmworkflow WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "clmworkflow.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CLMWORKFLOW exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CLMWORKFLOW exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CLMWORKFLOWPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "role", "initialStatus", "action", "newStatus"});

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

	private static class CLMWORKFLOWModelArgumentsResolver
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

			CLMWORKFLOWModelImpl clmworkflowModelImpl =
				(CLMWORKFLOWModelImpl)baseModel;

			long columnBitmask = clmworkflowModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(clmworkflowModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						clmworkflowModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(clmworkflowModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			CLMWORKFLOWModelImpl clmworkflowModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = clmworkflowModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = clmworkflowModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}