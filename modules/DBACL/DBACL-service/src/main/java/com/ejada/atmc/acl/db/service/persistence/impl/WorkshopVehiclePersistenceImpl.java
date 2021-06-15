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

import com.ejada.atmc.acl.db.exception.NoSuchWorkshopVehicleException;
import com.ejada.atmc.acl.db.model.WorkshopVehicle;
import com.ejada.atmc.acl.db.model.impl.WorkshopVehicleImpl;
import com.ejada.atmc.acl.db.model.impl.WorkshopVehicleModelImpl;
import com.ejada.atmc.acl.db.service.persistence.WorkshopVehiclePersistence;
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
 * The persistence implementation for the workshop vehicle service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = WorkshopVehiclePersistence.class)
public class WorkshopVehiclePersistenceImpl
	extends BasePersistenceImpl<WorkshopVehicle>
	implements WorkshopVehiclePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>WorkshopVehicleUtil</code> to access the workshop vehicle persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		WorkshopVehicleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBystatus;
	private FinderPath _finderPathWithoutPaginationFindBystatus;
	private FinderPath _finderPathCountBystatus;

	/**
	 * Returns all the workshop vehicles where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching workshop vehicles
	 */
	@Override
	public List<WorkshopVehicle> findBystatus(String status) {
		return findBystatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the workshop vehicles where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @return the range of matching workshop vehicles
	 */
	@Override
	public List<WorkshopVehicle> findBystatus(
		String status, int start, int end) {

		return findBystatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the workshop vehicles where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching workshop vehicles
	 */
	@Override
	public List<WorkshopVehicle> findBystatus(
		String status, int start, int end,
		OrderByComparator<WorkshopVehicle> orderByComparator) {

		return findBystatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the workshop vehicles where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching workshop vehicles
	 */
	@Override
	public List<WorkshopVehicle> findBystatus(
		String status, int start, int end,
		OrderByComparator<WorkshopVehicle> orderByComparator,
		boolean useFinderCache) {

		status = Objects.toString(status, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBystatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBystatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<WorkshopVehicle> list = null;

		if (useFinderCache) {
			list = (List<WorkshopVehicle>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkshopVehicle workshopVehicle : list) {
					if (!status.equals(workshopVehicle.getStatus())) {
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

			sb.append(_SQL_SELECT_WORKSHOPVEHICLE_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkshopVehicleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatus) {
					queryPos.add(status);
				}

				list = (List<WorkshopVehicle>)QueryUtil.list(
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
	 * Returns the first workshop vehicle in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a matching workshop vehicle could not be found
	 */
	@Override
	public WorkshopVehicle findBystatus_First(
			String status, OrderByComparator<WorkshopVehicle> orderByComparator)
		throws NoSuchWorkshopVehicleException {

		WorkshopVehicle workshopVehicle = fetchBystatus_First(
			status, orderByComparator);

		if (workshopVehicle != null) {
			return workshopVehicle;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchWorkshopVehicleException(sb.toString());
	}

	/**
	 * Returns the first workshop vehicle in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshop vehicle, or <code>null</code> if a matching workshop vehicle could not be found
	 */
	@Override
	public WorkshopVehicle fetchBystatus_First(
		String status, OrderByComparator<WorkshopVehicle> orderByComparator) {

		List<WorkshopVehicle> list = findBystatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last workshop vehicle in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a matching workshop vehicle could not be found
	 */
	@Override
	public WorkshopVehicle findBystatus_Last(
			String status, OrderByComparator<WorkshopVehicle> orderByComparator)
		throws NoSuchWorkshopVehicleException {

		WorkshopVehicle workshopVehicle = fetchBystatus_Last(
			status, orderByComparator);

		if (workshopVehicle != null) {
			return workshopVehicle;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchWorkshopVehicleException(sb.toString());
	}

	/**
	 * Returns the last workshop vehicle in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshop vehicle, or <code>null</code> if a matching workshop vehicle could not be found
	 */
	@Override
	public WorkshopVehicle fetchBystatus_Last(
		String status, OrderByComparator<WorkshopVehicle> orderByComparator) {

		int count = countBystatus(status);

		if (count == 0) {
			return null;
		}

		List<WorkshopVehicle> list = findBystatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the workshop vehicles before and after the current workshop vehicle in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current workshop vehicle
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a workshop vehicle with the primary key could not be found
	 */
	@Override
	public WorkshopVehicle[] findBystatus_PrevAndNext(
			int id, String status,
			OrderByComparator<WorkshopVehicle> orderByComparator)
		throws NoSuchWorkshopVehicleException {

		status = Objects.toString(status, "");

		WorkshopVehicle workshopVehicle = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			WorkshopVehicle[] array = new WorkshopVehicleImpl[3];

			array[0] = getBystatus_PrevAndNext(
				session, workshopVehicle, status, orderByComparator, true);

			array[1] = workshopVehicle;

			array[2] = getBystatus_PrevAndNext(
				session, workshopVehicle, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkshopVehicle getBystatus_PrevAndNext(
		Session session, WorkshopVehicle workshopVehicle, String status,
		OrderByComparator<WorkshopVehicle> orderByComparator,
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

		sb.append(_SQL_SELECT_WORKSHOPVEHICLE_WHERE);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			sb.append(_FINDER_COLUMN_STATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);
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
			sb.append(WorkshopVehicleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindStatus) {
			queryPos.add(status);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						workshopVehicle)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkshopVehicle> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the workshop vehicles where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeBystatus(String status) {
		for (WorkshopVehicle workshopVehicle :
				findBystatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(workshopVehicle);
		}
	}

	/**
	 * Returns the number of workshop vehicles where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching workshop vehicles
	 */
	@Override
	public int countBystatus(String status) {
		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountBystatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKSHOPVEHICLE_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"workshopVehicle.status = ?";

	private static final String _FINDER_COLUMN_STATUS_STATUS_3 =
		"(workshopVehicle.status IS NULL OR workshopVehicle.status = '')";

	private FinderPath _finderPathWithPaginationFindBycustomerIqamaId;
	private FinderPath _finderPathWithoutPaginationFindBycustomerIqamaId;
	private FinderPath _finderPathCountBycustomerIqamaId;

	/**
	 * Returns all the workshop vehicles where customerIqamaId = &#63;.
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @return the matching workshop vehicles
	 */
	@Override
	public List<WorkshopVehicle> findBycustomerIqamaId(String customerIqamaId) {
		return findBycustomerIqamaId(
			customerIqamaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the workshop vehicles where customerIqamaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @return the range of matching workshop vehicles
	 */
	@Override
	public List<WorkshopVehicle> findBycustomerIqamaId(
		String customerIqamaId, int start, int end) {

		return findBycustomerIqamaId(customerIqamaId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the workshop vehicles where customerIqamaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching workshop vehicles
	 */
	@Override
	public List<WorkshopVehicle> findBycustomerIqamaId(
		String customerIqamaId, int start, int end,
		OrderByComparator<WorkshopVehicle> orderByComparator) {

		return findBycustomerIqamaId(
			customerIqamaId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the workshop vehicles where customerIqamaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching workshop vehicles
	 */
	@Override
	public List<WorkshopVehicle> findBycustomerIqamaId(
		String customerIqamaId, int start, int end,
		OrderByComparator<WorkshopVehicle> orderByComparator,
		boolean useFinderCache) {

		customerIqamaId = Objects.toString(customerIqamaId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBycustomerIqamaId;
				finderArgs = new Object[] {customerIqamaId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycustomerIqamaId;
			finderArgs = new Object[] {
				customerIqamaId, start, end, orderByComparator
			};
		}

		List<WorkshopVehicle> list = null;

		if (useFinderCache) {
			list = (List<WorkshopVehicle>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkshopVehicle workshopVehicle : list) {
					if (!customerIqamaId.equals(
							workshopVehicle.getCustomerIqamaId())) {

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

			sb.append(_SQL_SELECT_WORKSHOPVEHICLE_WHERE);

			boolean bindCustomerIqamaId = false;

			if (customerIqamaId.isEmpty()) {
				sb.append(_FINDER_COLUMN_CUSTOMERIQAMAID_CUSTOMERIQAMAID_3);
			}
			else {
				bindCustomerIqamaId = true;

				sb.append(_FINDER_COLUMN_CUSTOMERIQAMAID_CUSTOMERIQAMAID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkshopVehicleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCustomerIqamaId) {
					queryPos.add(customerIqamaId);
				}

				list = (List<WorkshopVehicle>)QueryUtil.list(
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
	 * Returns the first workshop vehicle in the ordered set where customerIqamaId = &#63;.
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a matching workshop vehicle could not be found
	 */
	@Override
	public WorkshopVehicle findBycustomerIqamaId_First(
			String customerIqamaId,
			OrderByComparator<WorkshopVehicle> orderByComparator)
		throws NoSuchWorkshopVehicleException {

		WorkshopVehicle workshopVehicle = fetchBycustomerIqamaId_First(
			customerIqamaId, orderByComparator);

		if (workshopVehicle != null) {
			return workshopVehicle;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerIqamaId=");
		sb.append(customerIqamaId);

		sb.append("}");

		throw new NoSuchWorkshopVehicleException(sb.toString());
	}

	/**
	 * Returns the first workshop vehicle in the ordered set where customerIqamaId = &#63;.
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshop vehicle, or <code>null</code> if a matching workshop vehicle could not be found
	 */
	@Override
	public WorkshopVehicle fetchBycustomerIqamaId_First(
		String customerIqamaId,
		OrderByComparator<WorkshopVehicle> orderByComparator) {

		List<WorkshopVehicle> list = findBycustomerIqamaId(
			customerIqamaId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last workshop vehicle in the ordered set where customerIqamaId = &#63;.
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a matching workshop vehicle could not be found
	 */
	@Override
	public WorkshopVehicle findBycustomerIqamaId_Last(
			String customerIqamaId,
			OrderByComparator<WorkshopVehicle> orderByComparator)
		throws NoSuchWorkshopVehicleException {

		WorkshopVehicle workshopVehicle = fetchBycustomerIqamaId_Last(
			customerIqamaId, orderByComparator);

		if (workshopVehicle != null) {
			return workshopVehicle;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerIqamaId=");
		sb.append(customerIqamaId);

		sb.append("}");

		throw new NoSuchWorkshopVehicleException(sb.toString());
	}

	/**
	 * Returns the last workshop vehicle in the ordered set where customerIqamaId = &#63;.
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshop vehicle, or <code>null</code> if a matching workshop vehicle could not be found
	 */
	@Override
	public WorkshopVehicle fetchBycustomerIqamaId_Last(
		String customerIqamaId,
		OrderByComparator<WorkshopVehicle> orderByComparator) {

		int count = countBycustomerIqamaId(customerIqamaId);

		if (count == 0) {
			return null;
		}

		List<WorkshopVehicle> list = findBycustomerIqamaId(
			customerIqamaId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the workshop vehicles before and after the current workshop vehicle in the ordered set where customerIqamaId = &#63;.
	 *
	 * @param id the primary key of the current workshop vehicle
	 * @param customerIqamaId the customer iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a workshop vehicle with the primary key could not be found
	 */
	@Override
	public WorkshopVehicle[] findBycustomerIqamaId_PrevAndNext(
			int id, String customerIqamaId,
			OrderByComparator<WorkshopVehicle> orderByComparator)
		throws NoSuchWorkshopVehicleException {

		customerIqamaId = Objects.toString(customerIqamaId, "");

		WorkshopVehicle workshopVehicle = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			WorkshopVehicle[] array = new WorkshopVehicleImpl[3];

			array[0] = getBycustomerIqamaId_PrevAndNext(
				session, workshopVehicle, customerIqamaId, orderByComparator,
				true);

			array[1] = workshopVehicle;

			array[2] = getBycustomerIqamaId_PrevAndNext(
				session, workshopVehicle, customerIqamaId, orderByComparator,
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

	protected WorkshopVehicle getBycustomerIqamaId_PrevAndNext(
		Session session, WorkshopVehicle workshopVehicle,
		String customerIqamaId,
		OrderByComparator<WorkshopVehicle> orderByComparator,
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

		sb.append(_SQL_SELECT_WORKSHOPVEHICLE_WHERE);

		boolean bindCustomerIqamaId = false;

		if (customerIqamaId.isEmpty()) {
			sb.append(_FINDER_COLUMN_CUSTOMERIQAMAID_CUSTOMERIQAMAID_3);
		}
		else {
			bindCustomerIqamaId = true;

			sb.append(_FINDER_COLUMN_CUSTOMERIQAMAID_CUSTOMERIQAMAID_2);
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
			sb.append(WorkshopVehicleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCustomerIqamaId) {
			queryPos.add(customerIqamaId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						workshopVehicle)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkshopVehicle> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the workshop vehicles where customerIqamaId = &#63; from the database.
	 *
	 * @param customerIqamaId the customer iqama ID
	 */
	@Override
	public void removeBycustomerIqamaId(String customerIqamaId) {
		for (WorkshopVehicle workshopVehicle :
				findBycustomerIqamaId(
					customerIqamaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workshopVehicle);
		}
	}

	/**
	 * Returns the number of workshop vehicles where customerIqamaId = &#63;.
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @return the number of matching workshop vehicles
	 */
	@Override
	public int countBycustomerIqamaId(String customerIqamaId) {
		customerIqamaId = Objects.toString(customerIqamaId, "");

		FinderPath finderPath = _finderPathCountBycustomerIqamaId;

		Object[] finderArgs = new Object[] {customerIqamaId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKSHOPVEHICLE_WHERE);

			boolean bindCustomerIqamaId = false;

			if (customerIqamaId.isEmpty()) {
				sb.append(_FINDER_COLUMN_CUSTOMERIQAMAID_CUSTOMERIQAMAID_3);
			}
			else {
				bindCustomerIqamaId = true;

				sb.append(_FINDER_COLUMN_CUSTOMERIQAMAID_CUSTOMERIQAMAID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCustomerIqamaId) {
					queryPos.add(customerIqamaId);
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
		_FINDER_COLUMN_CUSTOMERIQAMAID_CUSTOMERIQAMAID_2 =
			"workshopVehicle.customerIqamaId = ?";

	private static final String
		_FINDER_COLUMN_CUSTOMERIQAMAID_CUSTOMERIQAMAID_3 =
			"(workshopVehicle.customerIqamaId IS NULL OR workshopVehicle.customerIqamaId = '')";

	private FinderPath _finderPathWithPaginationFindByStatusWorkshopId;
	private FinderPath _finderPathWithoutPaginationFindByStatusWorkshopId;
	private FinderPath _finderPathCountByStatusWorkshopId;

	/**
	 * Returns all the workshop vehicles where status = &#63; and workshopId = &#63;.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @return the matching workshop vehicles
	 */
	@Override
	public List<WorkshopVehicle> findByStatusWorkshopId(
		String status, int workshopId) {

		return findByStatusWorkshopId(
			status, workshopId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the workshop vehicles where status = &#63; and workshopId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @return the range of matching workshop vehicles
	 */
	@Override
	public List<WorkshopVehicle> findByStatusWorkshopId(
		String status, int workshopId, int start, int end) {

		return findByStatusWorkshopId(status, workshopId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the workshop vehicles where status = &#63; and workshopId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching workshop vehicles
	 */
	@Override
	public List<WorkshopVehicle> findByStatusWorkshopId(
		String status, int workshopId, int start, int end,
		OrderByComparator<WorkshopVehicle> orderByComparator) {

		return findByStatusWorkshopId(
			status, workshopId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the workshop vehicles where status = &#63; and workshopId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching workshop vehicles
	 */
	@Override
	public List<WorkshopVehicle> findByStatusWorkshopId(
		String status, int workshopId, int start, int end,
		OrderByComparator<WorkshopVehicle> orderByComparator,
		boolean useFinderCache) {

		status = Objects.toString(status, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatusWorkshopId;
				finderArgs = new Object[] {status, workshopId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatusWorkshopId;
			finderArgs = new Object[] {
				status, workshopId, start, end, orderByComparator
			};
		}

		List<WorkshopVehicle> list = null;

		if (useFinderCache) {
			list = (List<WorkshopVehicle>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkshopVehicle workshopVehicle : list) {
					if (!status.equals(workshopVehicle.getStatus()) ||
						(workshopId != workshopVehicle.getWorkshopId())) {

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

			sb.append(_SQL_SELECT_WORKSHOPVEHICLE_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUSWORKSHOPID_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_STATUSWORKSHOPID_STATUS_2);
			}

			sb.append(_FINDER_COLUMN_STATUSWORKSHOPID_WORKSHOPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkshopVehicleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatus) {
					queryPos.add(status);
				}

				queryPos.add(workshopId);

				list = (List<WorkshopVehicle>)QueryUtil.list(
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
	 * Returns the first workshop vehicle in the ordered set where status = &#63; and workshopId = &#63;.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a matching workshop vehicle could not be found
	 */
	@Override
	public WorkshopVehicle findByStatusWorkshopId_First(
			String status, int workshopId,
			OrderByComparator<WorkshopVehicle> orderByComparator)
		throws NoSuchWorkshopVehicleException {

		WorkshopVehicle workshopVehicle = fetchByStatusWorkshopId_First(
			status, workshopId, orderByComparator);

		if (workshopVehicle != null) {
			return workshopVehicle;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append(", workshopId=");
		sb.append(workshopId);

		sb.append("}");

		throw new NoSuchWorkshopVehicleException(sb.toString());
	}

	/**
	 * Returns the first workshop vehicle in the ordered set where status = &#63; and workshopId = &#63;.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshop vehicle, or <code>null</code> if a matching workshop vehicle could not be found
	 */
	@Override
	public WorkshopVehicle fetchByStatusWorkshopId_First(
		String status, int workshopId,
		OrderByComparator<WorkshopVehicle> orderByComparator) {

		List<WorkshopVehicle> list = findByStatusWorkshopId(
			status, workshopId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last workshop vehicle in the ordered set where status = &#63; and workshopId = &#63;.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a matching workshop vehicle could not be found
	 */
	@Override
	public WorkshopVehicle findByStatusWorkshopId_Last(
			String status, int workshopId,
			OrderByComparator<WorkshopVehicle> orderByComparator)
		throws NoSuchWorkshopVehicleException {

		WorkshopVehicle workshopVehicle = fetchByStatusWorkshopId_Last(
			status, workshopId, orderByComparator);

		if (workshopVehicle != null) {
			return workshopVehicle;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append(", workshopId=");
		sb.append(workshopId);

		sb.append("}");

		throw new NoSuchWorkshopVehicleException(sb.toString());
	}

	/**
	 * Returns the last workshop vehicle in the ordered set where status = &#63; and workshopId = &#63;.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshop vehicle, or <code>null</code> if a matching workshop vehicle could not be found
	 */
	@Override
	public WorkshopVehicle fetchByStatusWorkshopId_Last(
		String status, int workshopId,
		OrderByComparator<WorkshopVehicle> orderByComparator) {

		int count = countByStatusWorkshopId(status, workshopId);

		if (count == 0) {
			return null;
		}

		List<WorkshopVehicle> list = findByStatusWorkshopId(
			status, workshopId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the workshop vehicles before and after the current workshop vehicle in the ordered set where status = &#63; and workshopId = &#63;.
	 *
	 * @param id the primary key of the current workshop vehicle
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a workshop vehicle with the primary key could not be found
	 */
	@Override
	public WorkshopVehicle[] findByStatusWorkshopId_PrevAndNext(
			int id, String status, int workshopId,
			OrderByComparator<WorkshopVehicle> orderByComparator)
		throws NoSuchWorkshopVehicleException {

		status = Objects.toString(status, "");

		WorkshopVehicle workshopVehicle = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			WorkshopVehicle[] array = new WorkshopVehicleImpl[3];

			array[0] = getByStatusWorkshopId_PrevAndNext(
				session, workshopVehicle, status, workshopId, orderByComparator,
				true);

			array[1] = workshopVehicle;

			array[2] = getByStatusWorkshopId_PrevAndNext(
				session, workshopVehicle, status, workshopId, orderByComparator,
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

	protected WorkshopVehicle getByStatusWorkshopId_PrevAndNext(
		Session session, WorkshopVehicle workshopVehicle, String status,
		int workshopId, OrderByComparator<WorkshopVehicle> orderByComparator,
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

		sb.append(_SQL_SELECT_WORKSHOPVEHICLE_WHERE);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			sb.append(_FINDER_COLUMN_STATUSWORKSHOPID_STATUS_3);
		}
		else {
			bindStatus = true;

			sb.append(_FINDER_COLUMN_STATUSWORKSHOPID_STATUS_2);
		}

		sb.append(_FINDER_COLUMN_STATUSWORKSHOPID_WORKSHOPID_2);

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
			sb.append(WorkshopVehicleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindStatus) {
			queryPos.add(status);
		}

		queryPos.add(workshopId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						workshopVehicle)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkshopVehicle> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the workshop vehicles where status = &#63; and workshopId = &#63; from the database.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 */
	@Override
	public void removeByStatusWorkshopId(String status, int workshopId) {
		for (WorkshopVehicle workshopVehicle :
				findByStatusWorkshopId(
					status, workshopId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workshopVehicle);
		}
	}

	/**
	 * Returns the number of workshop vehicles where status = &#63; and workshopId = &#63;.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @return the number of matching workshop vehicles
	 */
	@Override
	public int countByStatusWorkshopId(String status, int workshopId) {
		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountByStatusWorkshopId;

		Object[] finderArgs = new Object[] {status, workshopId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKSHOPVEHICLE_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUSWORKSHOPID_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_STATUSWORKSHOPID_STATUS_2);
			}

			sb.append(_FINDER_COLUMN_STATUSWORKSHOPID_WORKSHOPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatus) {
					queryPos.add(status);
				}

				queryPos.add(workshopId);

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

	private static final String _FINDER_COLUMN_STATUSWORKSHOPID_STATUS_2 =
		"workshopVehicle.status = ? AND ";

	private static final String _FINDER_COLUMN_STATUSWORKSHOPID_STATUS_3 =
		"(workshopVehicle.status IS NULL OR workshopVehicle.status = '') AND ";

	private static final String _FINDER_COLUMN_STATUSWORKSHOPID_WORKSHOPID_2 =
		"workshopVehicle.workshopId = ?";

	public WorkshopVehiclePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "ID");
		dbColumnNames.put("customerName", "CUSTOMER_NAME");
		dbColumnNames.put("manufacture", "MANUFACTURE");
		dbColumnNames.put("plateNo", "PLATE_NO");
		dbColumnNames.put("workshopId", "WORKSHOP_ID");
		dbColumnNames.put("claimRefNo", "CLAIM_REFERENCE_NO");
		dbColumnNames.put("status", "STATUS");
		dbColumnNames.put("date", "CLAIM_DATE");
		dbColumnNames.put("serviceType", "SERVICE_TYPE");
		dbColumnNames.put("description", "DESCRIPTION");
		dbColumnNames.put("customerMobile", "CUSTOMER_MOBILE");
		dbColumnNames.put("vehMakeEn", "VEHICLE_MAKE_EN");
		dbColumnNames.put("vehMakeAr", "VEHICLE_MAKE_AR");
		dbColumnNames.put("vehModelEn", "VEHICLE_MODEL_EN");
		dbColumnNames.put("vehModelAr", "VEHICLE_MODEL_AR");
		dbColumnNames.put("customerIqamaId", "CUSTOMER_IQAMA_ID");

		setDBColumnNames(dbColumnNames);

		setModelClass(WorkshopVehicle.class);

		setModelImplClass(WorkshopVehicleImpl.class);
		setModelPKClass(int.class);
	}

	/**
	 * Caches the workshop vehicle in the entity cache if it is enabled.
	 *
	 * @param workshopVehicle the workshop vehicle
	 */
	@Override
	public void cacheResult(WorkshopVehicle workshopVehicle) {
		dummyEntityCache.putResult(
			WorkshopVehicleImpl.class, workshopVehicle.getPrimaryKey(),
			workshopVehicle);
	}

	/**
	 * Caches the workshop vehicles in the entity cache if it is enabled.
	 *
	 * @param workshopVehicles the workshop vehicles
	 */
	@Override
	public void cacheResult(List<WorkshopVehicle> workshopVehicles) {
		for (WorkshopVehicle workshopVehicle : workshopVehicles) {
			if (dummyEntityCache.getResult(
					WorkshopVehicleImpl.class,
					workshopVehicle.getPrimaryKey()) == null) {

				cacheResult(workshopVehicle);
			}
		}
	}

	/**
	 * Clears the cache for all workshop vehicles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(WorkshopVehicleImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the workshop vehicle.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkshopVehicle workshopVehicle) {
		dummyEntityCache.removeResult(
			WorkshopVehicleImpl.class, workshopVehicle);
	}

	@Override
	public void clearCache(List<WorkshopVehicle> workshopVehicles) {
		for (WorkshopVehicle workshopVehicle : workshopVehicles) {
			dummyEntityCache.removeResult(
				WorkshopVehicleImpl.class, workshopVehicle);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				WorkshopVehicleImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new workshop vehicle with the primary key. Does not add the workshop vehicle to the database.
	 *
	 * @param id the primary key for the new workshop vehicle
	 * @return the new workshop vehicle
	 */
	@Override
	public WorkshopVehicle create(int id) {
		WorkshopVehicle workshopVehicle = new WorkshopVehicleImpl();

		workshopVehicle.setNew(true);
		workshopVehicle.setPrimaryKey(id);

		return workshopVehicle;
	}

	/**
	 * Removes the workshop vehicle with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the workshop vehicle
	 * @return the workshop vehicle that was removed
	 * @throws NoSuchWorkshopVehicleException if a workshop vehicle with the primary key could not be found
	 */
	@Override
	public WorkshopVehicle remove(int id)
		throws NoSuchWorkshopVehicleException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the workshop vehicle with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the workshop vehicle
	 * @return the workshop vehicle that was removed
	 * @throws NoSuchWorkshopVehicleException if a workshop vehicle with the primary key could not be found
	 */
	@Override
	public WorkshopVehicle remove(Serializable primaryKey)
		throws NoSuchWorkshopVehicleException {

		Session session = null;

		try {
			session = openSession();

			WorkshopVehicle workshopVehicle = (WorkshopVehicle)session.get(
				WorkshopVehicleImpl.class, primaryKey);

			if (workshopVehicle == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkshopVehicleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(workshopVehicle);
		}
		catch (NoSuchWorkshopVehicleException noSuchEntityException) {
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
	protected WorkshopVehicle removeImpl(WorkshopVehicle workshopVehicle) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workshopVehicle)) {
				workshopVehicle = (WorkshopVehicle)session.get(
					WorkshopVehicleImpl.class,
					workshopVehicle.getPrimaryKeyObj());
			}

			if (workshopVehicle != null) {
				session.delete(workshopVehicle);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (workshopVehicle != null) {
			clearCache(workshopVehicle);
		}

		return workshopVehicle;
	}

	@Override
	public WorkshopVehicle updateImpl(WorkshopVehicle workshopVehicle) {
		boolean isNew = workshopVehicle.isNew();

		if (!(workshopVehicle instanceof WorkshopVehicleModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(workshopVehicle.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					workshopVehicle);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in workshopVehicle proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom WorkshopVehicle implementation " +
					workshopVehicle.getClass());
		}

		WorkshopVehicleModelImpl workshopVehicleModelImpl =
			(WorkshopVehicleModelImpl)workshopVehicle;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(workshopVehicle);
			}
			else {
				workshopVehicle = (WorkshopVehicle)session.merge(
					workshopVehicle);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			WorkshopVehicleImpl.class, workshopVehicleModelImpl, false, true);

		if (isNew) {
			workshopVehicle.setNew(false);
		}

		workshopVehicle.resetOriginalValues();

		return workshopVehicle;
	}

	/**
	 * Returns the workshop vehicle with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the workshop vehicle
	 * @return the workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a workshop vehicle with the primary key could not be found
	 */
	@Override
	public WorkshopVehicle findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkshopVehicleException {

		WorkshopVehicle workshopVehicle = fetchByPrimaryKey(primaryKey);

		if (workshopVehicle == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkshopVehicleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return workshopVehicle;
	}

	/**
	 * Returns the workshop vehicle with the primary key or throws a <code>NoSuchWorkshopVehicleException</code> if it could not be found.
	 *
	 * @param id the primary key of the workshop vehicle
	 * @return the workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a workshop vehicle with the primary key could not be found
	 */
	@Override
	public WorkshopVehicle findByPrimaryKey(int id)
		throws NoSuchWorkshopVehicleException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the workshop vehicle with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the workshop vehicle
	 * @return the workshop vehicle, or <code>null</code> if a workshop vehicle with the primary key could not be found
	 */
	@Override
	public WorkshopVehicle fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the workshop vehicles.
	 *
	 * @return the workshop vehicles
	 */
	@Override
	public List<WorkshopVehicle> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the workshop vehicles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @return the range of workshop vehicles
	 */
	@Override
	public List<WorkshopVehicle> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the workshop vehicles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of workshop vehicles
	 */
	@Override
	public List<WorkshopVehicle> findAll(
		int start, int end,
		OrderByComparator<WorkshopVehicle> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the workshop vehicles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of workshop vehicles
	 */
	@Override
	public List<WorkshopVehicle> findAll(
		int start, int end,
		OrderByComparator<WorkshopVehicle> orderByComparator,
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

		List<WorkshopVehicle> list = null;

		if (useFinderCache) {
			list = (List<WorkshopVehicle>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_WORKSHOPVEHICLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_WORKSHOPVEHICLE;

				sql = sql.concat(WorkshopVehicleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<WorkshopVehicle>)QueryUtil.list(
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
	 * Removes all the workshop vehicles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WorkshopVehicle workshopVehicle : findAll()) {
			remove(workshopVehicle);
		}
	}

	/**
	 * Returns the number of workshop vehicles.
	 *
	 * @return the number of workshop vehicles
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_WORKSHOPVEHICLE);

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
		return _SQL_SELECT_WORKSHOPVEHICLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return WorkshopVehicleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the workshop vehicle persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new WorkshopVehicleModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", WorkshopVehicle.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindBystatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"STATUS"}, true);

		_finderPathWithoutPaginationFindBystatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
			new String[] {String.class.getName()}, new String[] {"STATUS"},
			true);

		_finderPathCountBystatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] {String.class.getName()}, new String[] {"STATUS"},
			false);

		_finderPathWithPaginationFindBycustomerIqamaId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycustomerIqamaId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"CUSTOMER_IQAMA_ID"}, true);

		_finderPathWithoutPaginationFindBycustomerIqamaId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycustomerIqamaId",
			new String[] {String.class.getName()},
			new String[] {"CUSTOMER_IQAMA_ID"}, true);

		_finderPathCountBycustomerIqamaId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycustomerIqamaId",
			new String[] {String.class.getName()},
			new String[] {"CUSTOMER_IQAMA_ID"}, false);

		_finderPathWithPaginationFindByStatusWorkshopId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusWorkshopId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"STATUS", "WORKSHOP_ID"}, true);

		_finderPathWithoutPaginationFindByStatusWorkshopId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatusWorkshopId",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"STATUS", "WORKSHOP_ID"}, true);

		_finderPathCountByStatusWorkshopId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStatusWorkshopId",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"STATUS", "WORKSHOP_ID"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(WorkshopVehicleImpl.class.getName());

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

	private static final String _SQL_SELECT_WORKSHOPVEHICLE =
		"SELECT workshopVehicle FROM WorkshopVehicle workshopVehicle";

	private static final String _SQL_SELECT_WORKSHOPVEHICLE_WHERE =
		"SELECT workshopVehicle FROM WorkshopVehicle workshopVehicle WHERE ";

	private static final String _SQL_COUNT_WORKSHOPVEHICLE =
		"SELECT COUNT(workshopVehicle) FROM WorkshopVehicle workshopVehicle";

	private static final String _SQL_COUNT_WORKSHOPVEHICLE_WHERE =
		"SELECT COUNT(workshopVehicle) FROM WorkshopVehicle workshopVehicle WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "workshopVehicle.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No WorkshopVehicle exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No WorkshopVehicle exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		WorkshopVehiclePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"id", "customerName", "manufacture", "plateNo", "workshopId",
			"claimRefNo", "status", "date", "serviceType", "description",
			"customerMobile", "vehMakeEn", "vehMakeAr", "vehModelEn",
			"vehModelAr", "customerIqamaId"
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

	private static class WorkshopVehicleModelArgumentsResolver
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

			WorkshopVehicleModelImpl workshopVehicleModelImpl =
				(WorkshopVehicleModelImpl)baseModel;

			long columnBitmask = workshopVehicleModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					workshopVehicleModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						workshopVehicleModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					workshopVehicleModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			WorkshopVehicleModelImpl workshopVehicleModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						workshopVehicleModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = workshopVehicleModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}