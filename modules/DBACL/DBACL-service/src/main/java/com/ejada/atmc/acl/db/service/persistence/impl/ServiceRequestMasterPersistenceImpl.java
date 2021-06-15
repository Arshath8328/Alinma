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

import com.ejada.atmc.acl.db.exception.NoSuchServiceRequestMasterException;
import com.ejada.atmc.acl.db.model.ServiceRequestMaster;
import com.ejada.atmc.acl.db.model.impl.ServiceRequestMasterImpl;
import com.ejada.atmc.acl.db.model.impl.ServiceRequestMasterModelImpl;
import com.ejada.atmc.acl.db.service.persistence.ServiceRequestMasterPersistence;
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
 * The persistence implementation for the service request master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ServiceRequestMasterPersistence.class)
public class ServiceRequestMasterPersistenceImpl
	extends BasePersistenceImpl<ServiceRequestMaster>
	implements ServiceRequestMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ServiceRequestMasterUtil</code> to access the service request master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ServiceRequestMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByiqamaId;
	private FinderPath _finderPathWithoutPaginationFindByiqamaId;
	private FinderPath _finderPathCountByiqamaId;

	/**
	 * Returns all the service request masters where IQAMA_ID = &#63;.
	 *
	 * @param IQAMA_ID the iqama_id
	 * @return the matching service request masters
	 */
	@Override
	public List<ServiceRequestMaster> findByiqamaId(String IQAMA_ID) {
		return findByiqamaId(
			IQAMA_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service request masters where IQAMA_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param IQAMA_ID the iqama_id
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @return the range of matching service request masters
	 */
	@Override
	public List<ServiceRequestMaster> findByiqamaId(
		String IQAMA_ID, int start, int end) {

		return findByiqamaId(IQAMA_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service request masters where IQAMA_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param IQAMA_ID the iqama_id
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service request masters
	 */
	@Override
	public List<ServiceRequestMaster> findByiqamaId(
		String IQAMA_ID, int start, int end,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		return findByiqamaId(IQAMA_ID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service request masters where IQAMA_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param IQAMA_ID the iqama_id
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service request masters
	 */
	@Override
	public List<ServiceRequestMaster> findByiqamaId(
		String IQAMA_ID, int start, int end,
		OrderByComparator<ServiceRequestMaster> orderByComparator,
		boolean useFinderCache) {

		IQAMA_ID = Objects.toString(IQAMA_ID, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByiqamaId;
				finderArgs = new Object[] {IQAMA_ID};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByiqamaId;
			finderArgs = new Object[] {IQAMA_ID, start, end, orderByComparator};
		}

		List<ServiceRequestMaster> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequestMaster>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ServiceRequestMaster serviceRequestMaster : list) {
					if (!IQAMA_ID.equals(serviceRequestMaster.getIQAMA_ID())) {
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

			sb.append(_SQL_SELECT_SERVICEREQUESTMASTER_WHERE);

			boolean bindIQAMA_ID = false;

			if (IQAMA_ID.isEmpty()) {
				sb.append(_FINDER_COLUMN_IQAMAID_IQAMA_ID_3);
			}
			else {
				bindIQAMA_ID = true;

				sb.append(_FINDER_COLUMN_IQAMAID_IQAMA_ID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServiceRequestMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIQAMA_ID) {
					queryPos.add(IQAMA_ID);
				}

				list = (List<ServiceRequestMaster>)QueryUtil.list(
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
	 * Returns the first service request master in the ordered set where IQAMA_ID = &#63;.
	 *
	 * @param IQAMA_ID the iqama_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request master
	 * @throws NoSuchServiceRequestMasterException if a matching service request master could not be found
	 */
	@Override
	public ServiceRequestMaster findByiqamaId_First(
			String IQAMA_ID,
			OrderByComparator<ServiceRequestMaster> orderByComparator)
		throws NoSuchServiceRequestMasterException {

		ServiceRequestMaster serviceRequestMaster = fetchByiqamaId_First(
			IQAMA_ID, orderByComparator);

		if (serviceRequestMaster != null) {
			return serviceRequestMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("IQAMA_ID=");
		sb.append(IQAMA_ID);

		sb.append("}");

		throw new NoSuchServiceRequestMasterException(sb.toString());
	}

	/**
	 * Returns the first service request master in the ordered set where IQAMA_ID = &#63;.
	 *
	 * @param IQAMA_ID the iqama_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request master, or <code>null</code> if a matching service request master could not be found
	 */
	@Override
	public ServiceRequestMaster fetchByiqamaId_First(
		String IQAMA_ID,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		List<ServiceRequestMaster> list = findByiqamaId(
			IQAMA_ID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service request master in the ordered set where IQAMA_ID = &#63;.
	 *
	 * @param IQAMA_ID the iqama_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request master
	 * @throws NoSuchServiceRequestMasterException if a matching service request master could not be found
	 */
	@Override
	public ServiceRequestMaster findByiqamaId_Last(
			String IQAMA_ID,
			OrderByComparator<ServiceRequestMaster> orderByComparator)
		throws NoSuchServiceRequestMasterException {

		ServiceRequestMaster serviceRequestMaster = fetchByiqamaId_Last(
			IQAMA_ID, orderByComparator);

		if (serviceRequestMaster != null) {
			return serviceRequestMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("IQAMA_ID=");
		sb.append(IQAMA_ID);

		sb.append("}");

		throw new NoSuchServiceRequestMasterException(sb.toString());
	}

	/**
	 * Returns the last service request master in the ordered set where IQAMA_ID = &#63;.
	 *
	 * @param IQAMA_ID the iqama_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request master, or <code>null</code> if a matching service request master could not be found
	 */
	@Override
	public ServiceRequestMaster fetchByiqamaId_Last(
		String IQAMA_ID,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		int count = countByiqamaId(IQAMA_ID);

		if (count == 0) {
			return null;
		}

		List<ServiceRequestMaster> list = findByiqamaId(
			IQAMA_ID, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service request masters before and after the current service request master in the ordered set where IQAMA_ID = &#63;.
	 *
	 * @param REFERENCE_NO the primary key of the current service request master
	 * @param IQAMA_ID the iqama_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request master
	 * @throws NoSuchServiceRequestMasterException if a service request master with the primary key could not be found
	 */
	@Override
	public ServiceRequestMaster[] findByiqamaId_PrevAndNext(
			String REFERENCE_NO, String IQAMA_ID,
			OrderByComparator<ServiceRequestMaster> orderByComparator)
		throws NoSuchServiceRequestMasterException {

		IQAMA_ID = Objects.toString(IQAMA_ID, "");

		ServiceRequestMaster serviceRequestMaster = findByPrimaryKey(
			REFERENCE_NO);

		Session session = null;

		try {
			session = openSession();

			ServiceRequestMaster[] array = new ServiceRequestMasterImpl[3];

			array[0] = getByiqamaId_PrevAndNext(
				session, serviceRequestMaster, IQAMA_ID, orderByComparator,
				true);

			array[1] = serviceRequestMaster;

			array[2] = getByiqamaId_PrevAndNext(
				session, serviceRequestMaster, IQAMA_ID, orderByComparator,
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

	protected ServiceRequestMaster getByiqamaId_PrevAndNext(
		Session session, ServiceRequestMaster serviceRequestMaster,
		String IQAMA_ID,
		OrderByComparator<ServiceRequestMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_SERVICEREQUESTMASTER_WHERE);

		boolean bindIQAMA_ID = false;

		if (IQAMA_ID.isEmpty()) {
			sb.append(_FINDER_COLUMN_IQAMAID_IQAMA_ID_3);
		}
		else {
			bindIQAMA_ID = true;

			sb.append(_FINDER_COLUMN_IQAMAID_IQAMA_ID_2);
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
			sb.append(ServiceRequestMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindIQAMA_ID) {
			queryPos.add(IQAMA_ID);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						serviceRequestMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ServiceRequestMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service request masters where IQAMA_ID = &#63; from the database.
	 *
	 * @param IQAMA_ID the iqama_id
	 */
	@Override
	public void removeByiqamaId(String IQAMA_ID) {
		for (ServiceRequestMaster serviceRequestMaster :
				findByiqamaId(
					IQAMA_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(serviceRequestMaster);
		}
	}

	/**
	 * Returns the number of service request masters where IQAMA_ID = &#63;.
	 *
	 * @param IQAMA_ID the iqama_id
	 * @return the number of matching service request masters
	 */
	@Override
	public int countByiqamaId(String IQAMA_ID) {
		IQAMA_ID = Objects.toString(IQAMA_ID, "");

		FinderPath finderPath = _finderPathCountByiqamaId;

		Object[] finderArgs = new Object[] {IQAMA_ID};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SERVICEREQUESTMASTER_WHERE);

			boolean bindIQAMA_ID = false;

			if (IQAMA_ID.isEmpty()) {
				sb.append(_FINDER_COLUMN_IQAMAID_IQAMA_ID_3);
			}
			else {
				bindIQAMA_ID = true;

				sb.append(_FINDER_COLUMN_IQAMAID_IQAMA_ID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIQAMA_ID) {
					queryPos.add(IQAMA_ID);
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

	private static final String _FINDER_COLUMN_IQAMAID_IQAMA_ID_2 =
		"serviceRequestMaster.IQAMA_ID = ?";

	private static final String _FINDER_COLUMN_IQAMAID_IQAMA_ID_3 =
		"(serviceRequestMaster.IQAMA_ID IS NULL OR serviceRequestMaster.IQAMA_ID = '')";

	private FinderPath _finderPathWithPaginationFindByescalationFlag;
	private FinderPath _finderPathWithoutPaginationFindByescalationFlag;
	private FinderPath _finderPathCountByescalationFlag;

	/**
	 * Returns all the service request masters where ESCALATION_FLAG = &#63;.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @return the matching service request masters
	 */
	@Override
	public List<ServiceRequestMaster> findByescalationFlag(
		boolean ESCALATION_FLAG) {

		return findByescalationFlag(
			ESCALATION_FLAG, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service request masters where ESCALATION_FLAG = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @return the range of matching service request masters
	 */
	@Override
	public List<ServiceRequestMaster> findByescalationFlag(
		boolean ESCALATION_FLAG, int start, int end) {

		return findByescalationFlag(ESCALATION_FLAG, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service request masters where ESCALATION_FLAG = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service request masters
	 */
	@Override
	public List<ServiceRequestMaster> findByescalationFlag(
		boolean ESCALATION_FLAG, int start, int end,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		return findByescalationFlag(
			ESCALATION_FLAG, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service request masters where ESCALATION_FLAG = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service request masters
	 */
	@Override
	public List<ServiceRequestMaster> findByescalationFlag(
		boolean ESCALATION_FLAG, int start, int end,
		OrderByComparator<ServiceRequestMaster> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByescalationFlag;
				finderArgs = new Object[] {ESCALATION_FLAG};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByescalationFlag;
			finderArgs = new Object[] {
				ESCALATION_FLAG, start, end, orderByComparator
			};
		}

		List<ServiceRequestMaster> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequestMaster>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ServiceRequestMaster serviceRequestMaster : list) {
					if (ESCALATION_FLAG !=
							serviceRequestMaster.isESCALATION_FLAG()) {

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

			sb.append(_SQL_SELECT_SERVICEREQUESTMASTER_WHERE);

			sb.append(_FINDER_COLUMN_ESCALATIONFLAG_ESCALATION_FLAG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServiceRequestMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ESCALATION_FLAG);

				list = (List<ServiceRequestMaster>)QueryUtil.list(
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
	 * Returns the first service request master in the ordered set where ESCALATION_FLAG = &#63;.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request master
	 * @throws NoSuchServiceRequestMasterException if a matching service request master could not be found
	 */
	@Override
	public ServiceRequestMaster findByescalationFlag_First(
			boolean ESCALATION_FLAG,
			OrderByComparator<ServiceRequestMaster> orderByComparator)
		throws NoSuchServiceRequestMasterException {

		ServiceRequestMaster serviceRequestMaster = fetchByescalationFlag_First(
			ESCALATION_FLAG, orderByComparator);

		if (serviceRequestMaster != null) {
			return serviceRequestMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ESCALATION_FLAG=");
		sb.append(ESCALATION_FLAG);

		sb.append("}");

		throw new NoSuchServiceRequestMasterException(sb.toString());
	}

	/**
	 * Returns the first service request master in the ordered set where ESCALATION_FLAG = &#63;.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request master, or <code>null</code> if a matching service request master could not be found
	 */
	@Override
	public ServiceRequestMaster fetchByescalationFlag_First(
		boolean ESCALATION_FLAG,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		List<ServiceRequestMaster> list = findByescalationFlag(
			ESCALATION_FLAG, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service request master in the ordered set where ESCALATION_FLAG = &#63;.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request master
	 * @throws NoSuchServiceRequestMasterException if a matching service request master could not be found
	 */
	@Override
	public ServiceRequestMaster findByescalationFlag_Last(
			boolean ESCALATION_FLAG,
			OrderByComparator<ServiceRequestMaster> orderByComparator)
		throws NoSuchServiceRequestMasterException {

		ServiceRequestMaster serviceRequestMaster = fetchByescalationFlag_Last(
			ESCALATION_FLAG, orderByComparator);

		if (serviceRequestMaster != null) {
			return serviceRequestMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ESCALATION_FLAG=");
		sb.append(ESCALATION_FLAG);

		sb.append("}");

		throw new NoSuchServiceRequestMasterException(sb.toString());
	}

	/**
	 * Returns the last service request master in the ordered set where ESCALATION_FLAG = &#63;.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request master, or <code>null</code> if a matching service request master could not be found
	 */
	@Override
	public ServiceRequestMaster fetchByescalationFlag_Last(
		boolean ESCALATION_FLAG,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		int count = countByescalationFlag(ESCALATION_FLAG);

		if (count == 0) {
			return null;
		}

		List<ServiceRequestMaster> list = findByescalationFlag(
			ESCALATION_FLAG, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service request masters before and after the current service request master in the ordered set where ESCALATION_FLAG = &#63;.
	 *
	 * @param REFERENCE_NO the primary key of the current service request master
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request master
	 * @throws NoSuchServiceRequestMasterException if a service request master with the primary key could not be found
	 */
	@Override
	public ServiceRequestMaster[] findByescalationFlag_PrevAndNext(
			String REFERENCE_NO, boolean ESCALATION_FLAG,
			OrderByComparator<ServiceRequestMaster> orderByComparator)
		throws NoSuchServiceRequestMasterException {

		ServiceRequestMaster serviceRequestMaster = findByPrimaryKey(
			REFERENCE_NO);

		Session session = null;

		try {
			session = openSession();

			ServiceRequestMaster[] array = new ServiceRequestMasterImpl[3];

			array[0] = getByescalationFlag_PrevAndNext(
				session, serviceRequestMaster, ESCALATION_FLAG,
				orderByComparator, true);

			array[1] = serviceRequestMaster;

			array[2] = getByescalationFlag_PrevAndNext(
				session, serviceRequestMaster, ESCALATION_FLAG,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceRequestMaster getByescalationFlag_PrevAndNext(
		Session session, ServiceRequestMaster serviceRequestMaster,
		boolean ESCALATION_FLAG,
		OrderByComparator<ServiceRequestMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_SERVICEREQUESTMASTER_WHERE);

		sb.append(_FINDER_COLUMN_ESCALATIONFLAG_ESCALATION_FLAG_2);

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
			sb.append(ServiceRequestMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(ESCALATION_FLAG);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						serviceRequestMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ServiceRequestMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service request masters where ESCALATION_FLAG = &#63; from the database.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 */
	@Override
	public void removeByescalationFlag(boolean ESCALATION_FLAG) {
		for (ServiceRequestMaster serviceRequestMaster :
				findByescalationFlag(
					ESCALATION_FLAG, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(serviceRequestMaster);
		}
	}

	/**
	 * Returns the number of service request masters where ESCALATION_FLAG = &#63;.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @return the number of matching service request masters
	 */
	@Override
	public int countByescalationFlag(boolean ESCALATION_FLAG) {
		FinderPath finderPath = _finderPathCountByescalationFlag;

		Object[] finderArgs = new Object[] {ESCALATION_FLAG};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SERVICEREQUESTMASTER_WHERE);

			sb.append(_FINDER_COLUMN_ESCALATIONFLAG_ESCALATION_FLAG_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ESCALATION_FLAG);

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
		_FINDER_COLUMN_ESCALATIONFLAG_ESCALATION_FLAG_2 =
			"serviceRequestMaster.ESCALATION_FLAG = ?";

	private FinderPath _finderPathWithPaginationFindByreqStatus;
	private FinderPath _finderPathWithoutPaginationFindByreqStatus;
	private FinderPath _finderPathCountByreqStatus;

	/**
	 * Returns all the service request masters where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @return the matching service request masters
	 */
	@Override
	public List<ServiceRequestMaster> findByreqStatus(String REQUEST_STATUS) {
		return findByreqStatus(
			REQUEST_STATUS, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service request masters where REQUEST_STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @return the range of matching service request masters
	 */
	@Override
	public List<ServiceRequestMaster> findByreqStatus(
		String REQUEST_STATUS, int start, int end) {

		return findByreqStatus(REQUEST_STATUS, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service request masters where REQUEST_STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service request masters
	 */
	@Override
	public List<ServiceRequestMaster> findByreqStatus(
		String REQUEST_STATUS, int start, int end,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		return findByreqStatus(
			REQUEST_STATUS, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service request masters where REQUEST_STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service request masters
	 */
	@Override
	public List<ServiceRequestMaster> findByreqStatus(
		String REQUEST_STATUS, int start, int end,
		OrderByComparator<ServiceRequestMaster> orderByComparator,
		boolean useFinderCache) {

		REQUEST_STATUS = Objects.toString(REQUEST_STATUS, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByreqStatus;
				finderArgs = new Object[] {REQUEST_STATUS};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByreqStatus;
			finderArgs = new Object[] {
				REQUEST_STATUS, start, end, orderByComparator
			};
		}

		List<ServiceRequestMaster> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequestMaster>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ServiceRequestMaster serviceRequestMaster : list) {
					if (!REQUEST_STATUS.equals(
							serviceRequestMaster.getREQUEST_STATUS())) {

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

			sb.append(_SQL_SELECT_SERVICEREQUESTMASTER_WHERE);

			boolean bindREQUEST_STATUS = false;

			if (REQUEST_STATUS.isEmpty()) {
				sb.append(_FINDER_COLUMN_REQSTATUS_REQUEST_STATUS_3);
			}
			else {
				bindREQUEST_STATUS = true;

				sb.append(_FINDER_COLUMN_REQSTATUS_REQUEST_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServiceRequestMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindREQUEST_STATUS) {
					queryPos.add(REQUEST_STATUS);
				}

				list = (List<ServiceRequestMaster>)QueryUtil.list(
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
	 * Returns the first service request master in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request master
	 * @throws NoSuchServiceRequestMasterException if a matching service request master could not be found
	 */
	@Override
	public ServiceRequestMaster findByreqStatus_First(
			String REQUEST_STATUS,
			OrderByComparator<ServiceRequestMaster> orderByComparator)
		throws NoSuchServiceRequestMasterException {

		ServiceRequestMaster serviceRequestMaster = fetchByreqStatus_First(
			REQUEST_STATUS, orderByComparator);

		if (serviceRequestMaster != null) {
			return serviceRequestMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("REQUEST_STATUS=");
		sb.append(REQUEST_STATUS);

		sb.append("}");

		throw new NoSuchServiceRequestMasterException(sb.toString());
	}

	/**
	 * Returns the first service request master in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request master, or <code>null</code> if a matching service request master could not be found
	 */
	@Override
	public ServiceRequestMaster fetchByreqStatus_First(
		String REQUEST_STATUS,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		List<ServiceRequestMaster> list = findByreqStatus(
			REQUEST_STATUS, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service request master in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request master
	 * @throws NoSuchServiceRequestMasterException if a matching service request master could not be found
	 */
	@Override
	public ServiceRequestMaster findByreqStatus_Last(
			String REQUEST_STATUS,
			OrderByComparator<ServiceRequestMaster> orderByComparator)
		throws NoSuchServiceRequestMasterException {

		ServiceRequestMaster serviceRequestMaster = fetchByreqStatus_Last(
			REQUEST_STATUS, orderByComparator);

		if (serviceRequestMaster != null) {
			return serviceRequestMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("REQUEST_STATUS=");
		sb.append(REQUEST_STATUS);

		sb.append("}");

		throw new NoSuchServiceRequestMasterException(sb.toString());
	}

	/**
	 * Returns the last service request master in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request master, or <code>null</code> if a matching service request master could not be found
	 */
	@Override
	public ServiceRequestMaster fetchByreqStatus_Last(
		String REQUEST_STATUS,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		int count = countByreqStatus(REQUEST_STATUS);

		if (count == 0) {
			return null;
		}

		List<ServiceRequestMaster> list = findByreqStatus(
			REQUEST_STATUS, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service request masters before and after the current service request master in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REFERENCE_NO the primary key of the current service request master
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request master
	 * @throws NoSuchServiceRequestMasterException if a service request master with the primary key could not be found
	 */
	@Override
	public ServiceRequestMaster[] findByreqStatus_PrevAndNext(
			String REFERENCE_NO, String REQUEST_STATUS,
			OrderByComparator<ServiceRequestMaster> orderByComparator)
		throws NoSuchServiceRequestMasterException {

		REQUEST_STATUS = Objects.toString(REQUEST_STATUS, "");

		ServiceRequestMaster serviceRequestMaster = findByPrimaryKey(
			REFERENCE_NO);

		Session session = null;

		try {
			session = openSession();

			ServiceRequestMaster[] array = new ServiceRequestMasterImpl[3];

			array[0] = getByreqStatus_PrevAndNext(
				session, serviceRequestMaster, REQUEST_STATUS,
				orderByComparator, true);

			array[1] = serviceRequestMaster;

			array[2] = getByreqStatus_PrevAndNext(
				session, serviceRequestMaster, REQUEST_STATUS,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceRequestMaster getByreqStatus_PrevAndNext(
		Session session, ServiceRequestMaster serviceRequestMaster,
		String REQUEST_STATUS,
		OrderByComparator<ServiceRequestMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_SERVICEREQUESTMASTER_WHERE);

		boolean bindREQUEST_STATUS = false;

		if (REQUEST_STATUS.isEmpty()) {
			sb.append(_FINDER_COLUMN_REQSTATUS_REQUEST_STATUS_3);
		}
		else {
			bindREQUEST_STATUS = true;

			sb.append(_FINDER_COLUMN_REQSTATUS_REQUEST_STATUS_2);
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
			sb.append(ServiceRequestMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindREQUEST_STATUS) {
			queryPos.add(REQUEST_STATUS);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						serviceRequestMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ServiceRequestMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service request masters where REQUEST_STATUS = &#63; from the database.
	 *
	 * @param REQUEST_STATUS the request_status
	 */
	@Override
	public void removeByreqStatus(String REQUEST_STATUS) {
		for (ServiceRequestMaster serviceRequestMaster :
				findByreqStatus(
					REQUEST_STATUS, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(serviceRequestMaster);
		}
	}

	/**
	 * Returns the number of service request masters where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @return the number of matching service request masters
	 */
	@Override
	public int countByreqStatus(String REQUEST_STATUS) {
		REQUEST_STATUS = Objects.toString(REQUEST_STATUS, "");

		FinderPath finderPath = _finderPathCountByreqStatus;

		Object[] finderArgs = new Object[] {REQUEST_STATUS};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SERVICEREQUESTMASTER_WHERE);

			boolean bindREQUEST_STATUS = false;

			if (REQUEST_STATUS.isEmpty()) {
				sb.append(_FINDER_COLUMN_REQSTATUS_REQUEST_STATUS_3);
			}
			else {
				bindREQUEST_STATUS = true;

				sb.append(_FINDER_COLUMN_REQSTATUS_REQUEST_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindREQUEST_STATUS) {
					queryPos.add(REQUEST_STATUS);
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

	private static final String _FINDER_COLUMN_REQSTATUS_REQUEST_STATUS_2 =
		"serviceRequestMaster.REQUEST_STATUS = ?";

	private static final String _FINDER_COLUMN_REQSTATUS_REQUEST_STATUS_3 =
		"(serviceRequestMaster.REQUEST_STATUS IS NULL OR serviceRequestMaster.REQUEST_STATUS = '')";

	public ServiceRequestMasterPersistenceImpl() {
		setModelClass(ServiceRequestMaster.class);

		setModelImplClass(ServiceRequestMasterImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the service request master in the entity cache if it is enabled.
	 *
	 * @param serviceRequestMaster the service request master
	 */
	@Override
	public void cacheResult(ServiceRequestMaster serviceRequestMaster) {
		dummyEntityCache.putResult(
			ServiceRequestMasterImpl.class,
			serviceRequestMaster.getPrimaryKey(), serviceRequestMaster);
	}

	/**
	 * Caches the service request masters in the entity cache if it is enabled.
	 *
	 * @param serviceRequestMasters the service request masters
	 */
	@Override
	public void cacheResult(List<ServiceRequestMaster> serviceRequestMasters) {
		for (ServiceRequestMaster serviceRequestMaster :
				serviceRequestMasters) {

			if (dummyEntityCache.getResult(
					ServiceRequestMasterImpl.class,
					serviceRequestMaster.getPrimaryKey()) == null) {

				cacheResult(serviceRequestMaster);
			}
		}
	}

	/**
	 * Clears the cache for all service request masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(ServiceRequestMasterImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the service request master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServiceRequestMaster serviceRequestMaster) {
		dummyEntityCache.removeResult(
			ServiceRequestMasterImpl.class, serviceRequestMaster);
	}

	@Override
	public void clearCache(List<ServiceRequestMaster> serviceRequestMasters) {
		for (ServiceRequestMaster serviceRequestMaster :
				serviceRequestMasters) {

			dummyEntityCache.removeResult(
				ServiceRequestMasterImpl.class, serviceRequestMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				ServiceRequestMasterImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new service request master with the primary key. Does not add the service request master to the database.
	 *
	 * @param REFERENCE_NO the primary key for the new service request master
	 * @return the new service request master
	 */
	@Override
	public ServiceRequestMaster create(String REFERENCE_NO) {
		ServiceRequestMaster serviceRequestMaster =
			new ServiceRequestMasterImpl();

		serviceRequestMaster.setNew(true);
		serviceRequestMaster.setPrimaryKey(REFERENCE_NO);

		return serviceRequestMaster;
	}

	/**
	 * Removes the service request master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param REFERENCE_NO the primary key of the service request master
	 * @return the service request master that was removed
	 * @throws NoSuchServiceRequestMasterException if a service request master with the primary key could not be found
	 */
	@Override
	public ServiceRequestMaster remove(String REFERENCE_NO)
		throws NoSuchServiceRequestMasterException {

		return remove((Serializable)REFERENCE_NO);
	}

	/**
	 * Removes the service request master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the service request master
	 * @return the service request master that was removed
	 * @throws NoSuchServiceRequestMasterException if a service request master with the primary key could not be found
	 */
	@Override
	public ServiceRequestMaster remove(Serializable primaryKey)
		throws NoSuchServiceRequestMasterException {

		Session session = null;

		try {
			session = openSession();

			ServiceRequestMaster serviceRequestMaster =
				(ServiceRequestMaster)session.get(
					ServiceRequestMasterImpl.class, primaryKey);

			if (serviceRequestMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServiceRequestMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(serviceRequestMaster);
		}
		catch (NoSuchServiceRequestMasterException noSuchEntityException) {
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
	protected ServiceRequestMaster removeImpl(
		ServiceRequestMaster serviceRequestMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(serviceRequestMaster)) {
				serviceRequestMaster = (ServiceRequestMaster)session.get(
					ServiceRequestMasterImpl.class,
					serviceRequestMaster.getPrimaryKeyObj());
			}

			if (serviceRequestMaster != null) {
				session.delete(serviceRequestMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (serviceRequestMaster != null) {
			clearCache(serviceRequestMaster);
		}

		return serviceRequestMaster;
	}

	@Override
	public ServiceRequestMaster updateImpl(
		ServiceRequestMaster serviceRequestMaster) {

		boolean isNew = serviceRequestMaster.isNew();

		if (!(serviceRequestMaster instanceof ServiceRequestMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(serviceRequestMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					serviceRequestMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in serviceRequestMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ServiceRequestMaster implementation " +
					serviceRequestMaster.getClass());
		}

		ServiceRequestMasterModelImpl serviceRequestMasterModelImpl =
			(ServiceRequestMasterModelImpl)serviceRequestMaster;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(serviceRequestMaster);
			}
			else {
				serviceRequestMaster = (ServiceRequestMaster)session.merge(
					serviceRequestMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			ServiceRequestMasterImpl.class, serviceRequestMasterModelImpl,
			false, true);

		if (isNew) {
			serviceRequestMaster.setNew(false);
		}

		serviceRequestMaster.resetOriginalValues();

		return serviceRequestMaster;
	}

	/**
	 * Returns the service request master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service request master
	 * @return the service request master
	 * @throws NoSuchServiceRequestMasterException if a service request master with the primary key could not be found
	 */
	@Override
	public ServiceRequestMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServiceRequestMasterException {

		ServiceRequestMaster serviceRequestMaster = fetchByPrimaryKey(
			primaryKey);

		if (serviceRequestMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServiceRequestMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return serviceRequestMaster;
	}

	/**
	 * Returns the service request master with the primary key or throws a <code>NoSuchServiceRequestMasterException</code> if it could not be found.
	 *
	 * @param REFERENCE_NO the primary key of the service request master
	 * @return the service request master
	 * @throws NoSuchServiceRequestMasterException if a service request master with the primary key could not be found
	 */
	@Override
	public ServiceRequestMaster findByPrimaryKey(String REFERENCE_NO)
		throws NoSuchServiceRequestMasterException {

		return findByPrimaryKey((Serializable)REFERENCE_NO);
	}

	/**
	 * Returns the service request master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param REFERENCE_NO the primary key of the service request master
	 * @return the service request master, or <code>null</code> if a service request master with the primary key could not be found
	 */
	@Override
	public ServiceRequestMaster fetchByPrimaryKey(String REFERENCE_NO) {
		return fetchByPrimaryKey((Serializable)REFERENCE_NO);
	}

	/**
	 * Returns all the service request masters.
	 *
	 * @return the service request masters
	 */
	@Override
	public List<ServiceRequestMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service request masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @return the range of service request masters
	 */
	@Override
	public List<ServiceRequestMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the service request masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service request masters
	 */
	@Override
	public List<ServiceRequestMaster> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service request masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of service request masters
	 */
	@Override
	public List<ServiceRequestMaster> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestMaster> orderByComparator,
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

		List<ServiceRequestMaster> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequestMaster>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SERVICEREQUESTMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICEREQUESTMASTER;

				sql = sql.concat(ServiceRequestMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ServiceRequestMaster>)QueryUtil.list(
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
	 * Removes all the service request masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ServiceRequestMaster serviceRequestMaster : findAll()) {
			remove(serviceRequestMaster);
		}
	}

	/**
	 * Returns the number of service request masters.
	 *
	 * @return the number of service request masters
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
					_SQL_COUNT_SERVICEREQUESTMASTER);

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
		return "REFERENCE_NO";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SERVICEREQUESTMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ServiceRequestMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the service request master persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ServiceRequestMasterModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ServiceRequestMaster.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByiqamaId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByiqamaId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"IQAMA_ID"}, true);

		_finderPathWithoutPaginationFindByiqamaId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByiqamaId",
			new String[] {String.class.getName()}, new String[] {"IQAMA_ID"},
			true);

		_finderPathCountByiqamaId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByiqamaId",
			new String[] {String.class.getName()}, new String[] {"IQAMA_ID"},
			false);

		_finderPathWithPaginationFindByescalationFlag = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByescalationFlag",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"ESCALATION_FLAG"}, true);

		_finderPathWithoutPaginationFindByescalationFlag = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByescalationFlag",
			new String[] {Boolean.class.getName()},
			new String[] {"ESCALATION_FLAG"}, true);

		_finderPathCountByescalationFlag = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByescalationFlag",
			new String[] {Boolean.class.getName()},
			new String[] {"ESCALATION_FLAG"}, false);

		_finderPathWithPaginationFindByreqStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByreqStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"REQUEST_STATUS"}, true);

		_finderPathWithoutPaginationFindByreqStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByreqStatus",
			new String[] {String.class.getName()},
			new String[] {"REQUEST_STATUS"}, true);

		_finderPathCountByreqStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByreqStatus",
			new String[] {String.class.getName()},
			new String[] {"REQUEST_STATUS"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(ServiceRequestMasterImpl.class.getName());

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

	private static final String _SQL_SELECT_SERVICEREQUESTMASTER =
		"SELECT serviceRequestMaster FROM ServiceRequestMaster serviceRequestMaster";

	private static final String _SQL_SELECT_SERVICEREQUESTMASTER_WHERE =
		"SELECT serviceRequestMaster FROM ServiceRequestMaster serviceRequestMaster WHERE ";

	private static final String _SQL_COUNT_SERVICEREQUESTMASTER =
		"SELECT COUNT(serviceRequestMaster) FROM ServiceRequestMaster serviceRequestMaster";

	private static final String _SQL_COUNT_SERVICEREQUESTMASTER_WHERE =
		"SELECT COUNT(serviceRequestMaster) FROM ServiceRequestMaster serviceRequestMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"serviceRequestMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ServiceRequestMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ServiceRequestMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ServiceRequestMasterPersistenceImpl.class);

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

	private static class ServiceRequestMasterModelArgumentsResolver
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

			ServiceRequestMasterModelImpl serviceRequestMasterModelImpl =
				(ServiceRequestMasterModelImpl)baseModel;

			long columnBitmask =
				serviceRequestMasterModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					serviceRequestMasterModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						serviceRequestMasterModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					serviceRequestMasterModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ServiceRequestMasterModelImpl serviceRequestMasterModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						serviceRequestMasterModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = serviceRequestMasterModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}