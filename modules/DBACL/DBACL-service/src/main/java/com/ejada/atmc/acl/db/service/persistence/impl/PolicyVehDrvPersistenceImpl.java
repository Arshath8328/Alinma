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

import com.ejada.atmc.acl.db.exception.NoSuchPolicyVehDrvException;
import com.ejada.atmc.acl.db.model.PolicyVehDrv;
import com.ejada.atmc.acl.db.model.impl.PolicyVehDrvImpl;
import com.ejada.atmc.acl.db.model.impl.PolicyVehDrvModelImpl;
import com.ejada.atmc.acl.db.service.persistence.PolicyVehDrvPK;
import com.ejada.atmc.acl.db.service.persistence.PolicyVehDrvPersistence;
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
 * The persistence implementation for the policy veh drv service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PolicyVehDrvPersistence.class)
public class PolicyVehDrvPersistenceImpl
	extends BasePersistenceImpl<PolicyVehDrv>
	implements PolicyVehDrvPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PolicyVehDrvUtil</code> to access the policy veh drv persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PolicyVehDrvImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBypolNumber;
	private FinderPath _finderPathWithoutPaginationFindBypolNumber;
	private FinderPath _finderPathCountBypolNumber;

	/**
	 * Returns all the policy veh drvs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy veh drvs
	 */
	@Override
	public List<PolicyVehDrv> findBypolNumber(String policyNo) {
		return findBypolNumber(
			policyNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy veh drvs where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehDrvModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy veh drvs
	 * @param end the upper bound of the range of policy veh drvs (not inclusive)
	 * @return the range of matching policy veh drvs
	 */
	@Override
	public List<PolicyVehDrv> findBypolNumber(
		String policyNo, int start, int end) {

		return findBypolNumber(policyNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy veh drvs where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehDrvModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy veh drvs
	 * @param end the upper bound of the range of policy veh drvs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy veh drvs
	 */
	@Override
	public List<PolicyVehDrv> findBypolNumber(
		String policyNo, int start, int end,
		OrderByComparator<PolicyVehDrv> orderByComparator) {

		return findBypolNumber(policyNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy veh drvs where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehDrvModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy veh drvs
	 * @param end the upper bound of the range of policy veh drvs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy veh drvs
	 */
	@Override
	public List<PolicyVehDrv> findBypolNumber(
		String policyNo, int start, int end,
		OrderByComparator<PolicyVehDrv> orderByComparator,
		boolean useFinderCache) {

		policyNo = Objects.toString(policyNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBypolNumber;
				finderArgs = new Object[] {policyNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBypolNumber;
			finderArgs = new Object[] {policyNo, start, end, orderByComparator};
		}

		List<PolicyVehDrv> list = null;

		if (useFinderCache) {
			list = (List<PolicyVehDrv>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PolicyVehDrv policyVehDrv : list) {
					if (!policyNo.equals(policyVehDrv.getPolicyNo())) {
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

			sb.append(_SQL_SELECT_POLICYVEHDRV_WHERE);

			boolean bindPolicyNo = false;

			if (policyNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLNUMBER_POLICYNO_3);
			}
			else {
				bindPolicyNo = true;

				sb.append(_FINDER_COLUMN_POLNUMBER_POLICYNO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PolicyVehDrvModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPolicyNo) {
					queryPos.add(policyNo);
				}

				list = (List<PolicyVehDrv>)QueryUtil.list(
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
	 * Returns the first policy veh drv in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh drv
	 * @throws NoSuchPolicyVehDrvException if a matching policy veh drv could not be found
	 */
	@Override
	public PolicyVehDrv findBypolNumber_First(
			String policyNo, OrderByComparator<PolicyVehDrv> orderByComparator)
		throws NoSuchPolicyVehDrvException {

		PolicyVehDrv policyVehDrv = fetchBypolNumber_First(
			policyNo, orderByComparator);

		if (policyVehDrv != null) {
			return policyVehDrv;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNo=");
		sb.append(policyNo);

		sb.append("}");

		throw new NoSuchPolicyVehDrvException(sb.toString());
	}

	/**
	 * Returns the first policy veh drv in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh drv, or <code>null</code> if a matching policy veh drv could not be found
	 */
	@Override
	public PolicyVehDrv fetchBypolNumber_First(
		String policyNo, OrderByComparator<PolicyVehDrv> orderByComparator) {

		List<PolicyVehDrv> list = findBypolNumber(
			policyNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last policy veh drv in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh drv
	 * @throws NoSuchPolicyVehDrvException if a matching policy veh drv could not be found
	 */
	@Override
	public PolicyVehDrv findBypolNumber_Last(
			String policyNo, OrderByComparator<PolicyVehDrv> orderByComparator)
		throws NoSuchPolicyVehDrvException {

		PolicyVehDrv policyVehDrv = fetchBypolNumber_Last(
			policyNo, orderByComparator);

		if (policyVehDrv != null) {
			return policyVehDrv;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNo=");
		sb.append(policyNo);

		sb.append("}");

		throw new NoSuchPolicyVehDrvException(sb.toString());
	}

	/**
	 * Returns the last policy veh drv in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh drv, or <code>null</code> if a matching policy veh drv could not be found
	 */
	@Override
	public PolicyVehDrv fetchBypolNumber_Last(
		String policyNo, OrderByComparator<PolicyVehDrv> orderByComparator) {

		int count = countBypolNumber(policyNo);

		if (count == 0) {
			return null;
		}

		List<PolicyVehDrv> list = findBypolNumber(
			policyNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the policy veh drvs before and after the current policy veh drv in the ordered set where policyNo = &#63;.
	 *
	 * @param policyVehDrvPK the primary key of the current policy veh drv
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy veh drv
	 * @throws NoSuchPolicyVehDrvException if a policy veh drv with the primary key could not be found
	 */
	@Override
	public PolicyVehDrv[] findBypolNumber_PrevAndNext(
			PolicyVehDrvPK policyVehDrvPK, String policyNo,
			OrderByComparator<PolicyVehDrv> orderByComparator)
		throws NoSuchPolicyVehDrvException {

		policyNo = Objects.toString(policyNo, "");

		PolicyVehDrv policyVehDrv = findByPrimaryKey(policyVehDrvPK);

		Session session = null;

		try {
			session = openSession();

			PolicyVehDrv[] array = new PolicyVehDrvImpl[3];

			array[0] = getBypolNumber_PrevAndNext(
				session, policyVehDrv, policyNo, orderByComparator, true);

			array[1] = policyVehDrv;

			array[2] = getBypolNumber_PrevAndNext(
				session, policyVehDrv, policyNo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PolicyVehDrv getBypolNumber_PrevAndNext(
		Session session, PolicyVehDrv policyVehDrv, String policyNo,
		OrderByComparator<PolicyVehDrv> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_POLICYVEHDRV_WHERE);

		boolean bindPolicyNo = false;

		if (policyNo.isEmpty()) {
			sb.append(_FINDER_COLUMN_POLNUMBER_POLICYNO_3);
		}
		else {
			bindPolicyNo = true;

			sb.append(_FINDER_COLUMN_POLNUMBER_POLICYNO_2);
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
			sb.append(PolicyVehDrvModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPolicyNo) {
			queryPos.add(policyNo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(policyVehDrv)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PolicyVehDrv> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the policy veh drvs where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 */
	@Override
	public void removeBypolNumber(String policyNo) {
		for (PolicyVehDrv policyVehDrv :
				findBypolNumber(
					policyNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(policyVehDrv);
		}
	}

	/**
	 * Returns the number of policy veh drvs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching policy veh drvs
	 */
	@Override
	public int countBypolNumber(String policyNo) {
		policyNo = Objects.toString(policyNo, "");

		FinderPath finderPath = _finderPathCountBypolNumber;

		Object[] finderArgs = new Object[] {policyNo};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POLICYVEHDRV_WHERE);

			boolean bindPolicyNo = false;

			if (policyNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLNUMBER_POLICYNO_3);
			}
			else {
				bindPolicyNo = true;

				sb.append(_FINDER_COLUMN_POLNUMBER_POLICYNO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPolicyNo) {
					queryPos.add(policyNo);
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

	private static final String _FINDER_COLUMN_POLNUMBER_POLICYNO_2 =
		"policyVehDrv.id.policyNo = ?";

	private static final String _FINDER_COLUMN_POLNUMBER_POLICYNO_3 =
		"(policyVehDrv.id.policyNo IS NULL OR policyVehDrv.id.policyNo = '')";

	public PolicyVehDrvPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("policyNo", "ODS_POLICY_NO");
		dbColumnNames.put("vehId", "ODS_VEH_ID");
		dbColumnNames.put("driverLicenseNo", "ODS_DRIVER_LICENSE_NO");
		dbColumnNames.put("driverName", "ODS_DRIVER_NAME");
		dbColumnNames.put("driverBirthDate", "ODS_DRIVER_DOB");
		dbColumnNames.put("driverNationality", "ODS_DRIVER_NATIONALITY");
		dbColumnNames.put("driverGender", "ODS_DRIVER_GENDER");

		setDBColumnNames(dbColumnNames);

		setModelClass(PolicyVehDrv.class);

		setModelImplClass(PolicyVehDrvImpl.class);
		setModelPKClass(PolicyVehDrvPK.class);
	}

	/**
	 * Caches the policy veh drv in the entity cache if it is enabled.
	 *
	 * @param policyVehDrv the policy veh drv
	 */
	@Override
	public void cacheResult(PolicyVehDrv policyVehDrv) {
		dummyEntityCache.putResult(
			PolicyVehDrvImpl.class, policyVehDrv.getPrimaryKey(), policyVehDrv);
	}

	/**
	 * Caches the policy veh drvs in the entity cache if it is enabled.
	 *
	 * @param policyVehDrvs the policy veh drvs
	 */
	@Override
	public void cacheResult(List<PolicyVehDrv> policyVehDrvs) {
		for (PolicyVehDrv policyVehDrv : policyVehDrvs) {
			if (dummyEntityCache.getResult(
					PolicyVehDrvImpl.class, policyVehDrv.getPrimaryKey()) ==
						null) {

				cacheResult(policyVehDrv);
			}
		}
	}

	/**
	 * Clears the cache for all policy veh drvs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(PolicyVehDrvImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the policy veh drv.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PolicyVehDrv policyVehDrv) {
		dummyEntityCache.removeResult(PolicyVehDrvImpl.class, policyVehDrv);
	}

	@Override
	public void clearCache(List<PolicyVehDrv> policyVehDrvs) {
		for (PolicyVehDrv policyVehDrv : policyVehDrvs) {
			dummyEntityCache.removeResult(PolicyVehDrvImpl.class, policyVehDrv);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(PolicyVehDrvImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new policy veh drv with the primary key. Does not add the policy veh drv to the database.
	 *
	 * @param policyVehDrvPK the primary key for the new policy veh drv
	 * @return the new policy veh drv
	 */
	@Override
	public PolicyVehDrv create(PolicyVehDrvPK policyVehDrvPK) {
		PolicyVehDrv policyVehDrv = new PolicyVehDrvImpl();

		policyVehDrv.setNew(true);
		policyVehDrv.setPrimaryKey(policyVehDrvPK);

		return policyVehDrv;
	}

	/**
	 * Removes the policy veh drv with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyVehDrvPK the primary key of the policy veh drv
	 * @return the policy veh drv that was removed
	 * @throws NoSuchPolicyVehDrvException if a policy veh drv with the primary key could not be found
	 */
	@Override
	public PolicyVehDrv remove(PolicyVehDrvPK policyVehDrvPK)
		throws NoSuchPolicyVehDrvException {

		return remove((Serializable)policyVehDrvPK);
	}

	/**
	 * Removes the policy veh drv with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the policy veh drv
	 * @return the policy veh drv that was removed
	 * @throws NoSuchPolicyVehDrvException if a policy veh drv with the primary key could not be found
	 */
	@Override
	public PolicyVehDrv remove(Serializable primaryKey)
		throws NoSuchPolicyVehDrvException {

		Session session = null;

		try {
			session = openSession();

			PolicyVehDrv policyVehDrv = (PolicyVehDrv)session.get(
				PolicyVehDrvImpl.class, primaryKey);

			if (policyVehDrv == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPolicyVehDrvException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(policyVehDrv);
		}
		catch (NoSuchPolicyVehDrvException noSuchEntityException) {
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
	protected PolicyVehDrv removeImpl(PolicyVehDrv policyVehDrv) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(policyVehDrv)) {
				policyVehDrv = (PolicyVehDrv)session.get(
					PolicyVehDrvImpl.class, policyVehDrv.getPrimaryKeyObj());
			}

			if (policyVehDrv != null) {
				session.delete(policyVehDrv);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (policyVehDrv != null) {
			clearCache(policyVehDrv);
		}

		return policyVehDrv;
	}

	@Override
	public PolicyVehDrv updateImpl(PolicyVehDrv policyVehDrv) {
		boolean isNew = policyVehDrv.isNew();

		if (!(policyVehDrv instanceof PolicyVehDrvModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(policyVehDrv.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					policyVehDrv);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in policyVehDrv proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PolicyVehDrv implementation " +
					policyVehDrv.getClass());
		}

		PolicyVehDrvModelImpl policyVehDrvModelImpl =
			(PolicyVehDrvModelImpl)policyVehDrv;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(policyVehDrv);
			}
			else {
				policyVehDrv = (PolicyVehDrv)session.merge(policyVehDrv);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			PolicyVehDrvImpl.class, policyVehDrvModelImpl, false, true);

		if (isNew) {
			policyVehDrv.setNew(false);
		}

		policyVehDrv.resetOriginalValues();

		return policyVehDrv;
	}

	/**
	 * Returns the policy veh drv with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the policy veh drv
	 * @return the policy veh drv
	 * @throws NoSuchPolicyVehDrvException if a policy veh drv with the primary key could not be found
	 */
	@Override
	public PolicyVehDrv findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPolicyVehDrvException {

		PolicyVehDrv policyVehDrv = fetchByPrimaryKey(primaryKey);

		if (policyVehDrv == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPolicyVehDrvException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return policyVehDrv;
	}

	/**
	 * Returns the policy veh drv with the primary key or throws a <code>NoSuchPolicyVehDrvException</code> if it could not be found.
	 *
	 * @param policyVehDrvPK the primary key of the policy veh drv
	 * @return the policy veh drv
	 * @throws NoSuchPolicyVehDrvException if a policy veh drv with the primary key could not be found
	 */
	@Override
	public PolicyVehDrv findByPrimaryKey(PolicyVehDrvPK policyVehDrvPK)
		throws NoSuchPolicyVehDrvException {

		return findByPrimaryKey((Serializable)policyVehDrvPK);
	}

	/**
	 * Returns the policy veh drv with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyVehDrvPK the primary key of the policy veh drv
	 * @return the policy veh drv, or <code>null</code> if a policy veh drv with the primary key could not be found
	 */
	@Override
	public PolicyVehDrv fetchByPrimaryKey(PolicyVehDrvPK policyVehDrvPK) {
		return fetchByPrimaryKey((Serializable)policyVehDrvPK);
	}

	/**
	 * Returns all the policy veh drvs.
	 *
	 * @return the policy veh drvs
	 */
	@Override
	public List<PolicyVehDrv> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy veh drvs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehDrvModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy veh drvs
	 * @param end the upper bound of the range of policy veh drvs (not inclusive)
	 * @return the range of policy veh drvs
	 */
	@Override
	public List<PolicyVehDrv> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy veh drvs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehDrvModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy veh drvs
	 * @param end the upper bound of the range of policy veh drvs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy veh drvs
	 */
	@Override
	public List<PolicyVehDrv> findAll(
		int start, int end, OrderByComparator<PolicyVehDrv> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy veh drvs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehDrvModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy veh drvs
	 * @param end the upper bound of the range of policy veh drvs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy veh drvs
	 */
	@Override
	public List<PolicyVehDrv> findAll(
		int start, int end, OrderByComparator<PolicyVehDrv> orderByComparator,
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

		List<PolicyVehDrv> list = null;

		if (useFinderCache) {
			list = (List<PolicyVehDrv>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_POLICYVEHDRV);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_POLICYVEHDRV;

				sql = sql.concat(PolicyVehDrvModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PolicyVehDrv>)QueryUtil.list(
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
	 * Removes all the policy veh drvs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PolicyVehDrv policyVehDrv : findAll()) {
			remove(policyVehDrv);
		}
	}

	/**
	 * Returns the number of policy veh drvs.
	 *
	 * @return the number of policy veh drvs
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_POLICYVEHDRV);

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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "policyVehDrvPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_POLICYVEHDRV;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PolicyVehDrvModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the policy veh drv persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PolicyVehDrvModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PolicyVehDrv.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindBypolNumber = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypolNumber",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"ODS_POLICY_NO"}, true);

		_finderPathWithoutPaginationFindBypolNumber = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypolNumber",
			new String[] {String.class.getName()},
			new String[] {"ODS_POLICY_NO"}, true);

		_finderPathCountBypolNumber = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypolNumber",
			new String[] {String.class.getName()},
			new String[] {"ODS_POLICY_NO"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(PolicyVehDrvImpl.class.getName());

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

	private static final String _SQL_SELECT_POLICYVEHDRV =
		"SELECT policyVehDrv FROM PolicyVehDrv policyVehDrv";

	private static final String _SQL_SELECT_POLICYVEHDRV_WHERE =
		"SELECT policyVehDrv FROM PolicyVehDrv policyVehDrv WHERE ";

	private static final String _SQL_COUNT_POLICYVEHDRV =
		"SELECT COUNT(policyVehDrv) FROM PolicyVehDrv policyVehDrv";

	private static final String _SQL_COUNT_POLICYVEHDRV_WHERE =
		"SELECT COUNT(policyVehDrv) FROM PolicyVehDrv policyVehDrv WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "policyVehDrv.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PolicyVehDrv exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PolicyVehDrv exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PolicyVehDrvPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"policyNo", "vehId", "driverLicenseNo", "driverName",
			"driverBirthDate", "driverNationality", "driverGender"
		});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"policyNo", "vehId", "driverLicenseNo"});

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

	private static class PolicyVehDrvModelArgumentsResolver
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

			PolicyVehDrvModelImpl policyVehDrvModelImpl =
				(PolicyVehDrvModelImpl)baseModel;

			long columnBitmask = policyVehDrvModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(policyVehDrvModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						policyVehDrvModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(policyVehDrvModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PolicyVehDrvModelImpl policyVehDrvModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = policyVehDrvModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = policyVehDrvModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}