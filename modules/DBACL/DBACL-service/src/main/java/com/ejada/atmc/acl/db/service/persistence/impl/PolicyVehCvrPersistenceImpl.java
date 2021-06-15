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

import com.ejada.atmc.acl.db.exception.NoSuchPolicyVehCvrException;
import com.ejada.atmc.acl.db.model.PolicyVehCvr;
import com.ejada.atmc.acl.db.model.impl.PolicyVehCvrImpl;
import com.ejada.atmc.acl.db.model.impl.PolicyVehCvrModelImpl;
import com.ejada.atmc.acl.db.service.persistence.PolicyVehCvrPK;
import com.ejada.atmc.acl.db.service.persistence.PolicyVehCvrPersistence;
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
 * The persistence implementation for the policy veh cvr service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PolicyVehCvrPersistence.class)
public class PolicyVehCvrPersistenceImpl
	extends BasePersistenceImpl<PolicyVehCvr>
	implements PolicyVehCvrPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PolicyVehCvrUtil</code> to access the policy veh cvr persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PolicyVehCvrImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByPolicyNo;
	private FinderPath _finderPathWithoutPaginationFindByPolicyNo;
	private FinderPath _finderPathCountByPolicyNo;

	/**
	 * Returns all the policy veh cvrs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy veh cvrs
	 */
	@Override
	public List<PolicyVehCvr> findByPolicyNo(String policyNo) {
		return findByPolicyNo(
			policyNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy veh cvrs where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehCvrModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy veh cvrs
	 * @param end the upper bound of the range of policy veh cvrs (not inclusive)
	 * @return the range of matching policy veh cvrs
	 */
	@Override
	public List<PolicyVehCvr> findByPolicyNo(
		String policyNo, int start, int end) {

		return findByPolicyNo(policyNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy veh cvrs where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehCvrModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy veh cvrs
	 * @param end the upper bound of the range of policy veh cvrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy veh cvrs
	 */
	@Override
	public List<PolicyVehCvr> findByPolicyNo(
		String policyNo, int start, int end,
		OrderByComparator<PolicyVehCvr> orderByComparator) {

		return findByPolicyNo(policyNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy veh cvrs where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehCvrModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy veh cvrs
	 * @param end the upper bound of the range of policy veh cvrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy veh cvrs
	 */
	@Override
	public List<PolicyVehCvr> findByPolicyNo(
		String policyNo, int start, int end,
		OrderByComparator<PolicyVehCvr> orderByComparator,
		boolean useFinderCache) {

		policyNo = Objects.toString(policyNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPolicyNo;
				finderArgs = new Object[] {policyNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPolicyNo;
			finderArgs = new Object[] {policyNo, start, end, orderByComparator};
		}

		List<PolicyVehCvr> list = null;

		if (useFinderCache) {
			list = (List<PolicyVehCvr>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PolicyVehCvr policyVehCvr : list) {
					if (!policyNo.equals(policyVehCvr.getPolicyNo())) {
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

			sb.append(_SQL_SELECT_POLICYVEHCVR_WHERE);

			boolean bindPolicyNo = false;

			if (policyNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYNO_POLICYNO_3);
			}
			else {
				bindPolicyNo = true;

				sb.append(_FINDER_COLUMN_POLICYNO_POLICYNO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PolicyVehCvrModelImpl.ORDER_BY_JPQL);
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

				list = (List<PolicyVehCvr>)QueryUtil.list(
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
	 * Returns the first policy veh cvr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a matching policy veh cvr could not be found
	 */
	@Override
	public PolicyVehCvr findByPolicyNo_First(
			String policyNo, OrderByComparator<PolicyVehCvr> orderByComparator)
		throws NoSuchPolicyVehCvrException {

		PolicyVehCvr policyVehCvr = fetchByPolicyNo_First(
			policyNo, orderByComparator);

		if (policyVehCvr != null) {
			return policyVehCvr;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNo=");
		sb.append(policyNo);

		sb.append("}");

		throw new NoSuchPolicyVehCvrException(sb.toString());
	}

	/**
	 * Returns the first policy veh cvr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh cvr, or <code>null</code> if a matching policy veh cvr could not be found
	 */
	@Override
	public PolicyVehCvr fetchByPolicyNo_First(
		String policyNo, OrderByComparator<PolicyVehCvr> orderByComparator) {

		List<PolicyVehCvr> list = findByPolicyNo(
			policyNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last policy veh cvr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a matching policy veh cvr could not be found
	 */
	@Override
	public PolicyVehCvr findByPolicyNo_Last(
			String policyNo, OrderByComparator<PolicyVehCvr> orderByComparator)
		throws NoSuchPolicyVehCvrException {

		PolicyVehCvr policyVehCvr = fetchByPolicyNo_Last(
			policyNo, orderByComparator);

		if (policyVehCvr != null) {
			return policyVehCvr;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNo=");
		sb.append(policyNo);

		sb.append("}");

		throw new NoSuchPolicyVehCvrException(sb.toString());
	}

	/**
	 * Returns the last policy veh cvr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh cvr, or <code>null</code> if a matching policy veh cvr could not be found
	 */
	@Override
	public PolicyVehCvr fetchByPolicyNo_Last(
		String policyNo, OrderByComparator<PolicyVehCvr> orderByComparator) {

		int count = countByPolicyNo(policyNo);

		if (count == 0) {
			return null;
		}

		List<PolicyVehCvr> list = findByPolicyNo(
			policyNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the policy veh cvrs before and after the current policy veh cvr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyVehCvrPK the primary key of the current policy veh cvr
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a policy veh cvr with the primary key could not be found
	 */
	@Override
	public PolicyVehCvr[] findByPolicyNo_PrevAndNext(
			PolicyVehCvrPK policyVehCvrPK, String policyNo,
			OrderByComparator<PolicyVehCvr> orderByComparator)
		throws NoSuchPolicyVehCvrException {

		policyNo = Objects.toString(policyNo, "");

		PolicyVehCvr policyVehCvr = findByPrimaryKey(policyVehCvrPK);

		Session session = null;

		try {
			session = openSession();

			PolicyVehCvr[] array = new PolicyVehCvrImpl[3];

			array[0] = getByPolicyNo_PrevAndNext(
				session, policyVehCvr, policyNo, orderByComparator, true);

			array[1] = policyVehCvr;

			array[2] = getByPolicyNo_PrevAndNext(
				session, policyVehCvr, policyNo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PolicyVehCvr getByPolicyNo_PrevAndNext(
		Session session, PolicyVehCvr policyVehCvr, String policyNo,
		OrderByComparator<PolicyVehCvr> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_POLICYVEHCVR_WHERE);

		boolean bindPolicyNo = false;

		if (policyNo.isEmpty()) {
			sb.append(_FINDER_COLUMN_POLICYNO_POLICYNO_3);
		}
		else {
			bindPolicyNo = true;

			sb.append(_FINDER_COLUMN_POLICYNO_POLICYNO_2);
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
			sb.append(PolicyVehCvrModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(policyVehCvr)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PolicyVehCvr> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the policy veh cvrs where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 */
	@Override
	public void removeByPolicyNo(String policyNo) {
		for (PolicyVehCvr policyVehCvr :
				findByPolicyNo(
					policyNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(policyVehCvr);
		}
	}

	/**
	 * Returns the number of policy veh cvrs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching policy veh cvrs
	 */
	@Override
	public int countByPolicyNo(String policyNo) {
		policyNo = Objects.toString(policyNo, "");

		FinderPath finderPath = _finderPathCountByPolicyNo;

		Object[] finderArgs = new Object[] {policyNo};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POLICYVEHCVR_WHERE);

			boolean bindPolicyNo = false;

			if (policyNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYNO_POLICYNO_3);
			}
			else {
				bindPolicyNo = true;

				sb.append(_FINDER_COLUMN_POLICYNO_POLICYNO_2);
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

	private static final String _FINDER_COLUMN_POLICYNO_POLICYNO_2 =
		"policyVehCvr.id.policyNo = ?";

	private static final String _FINDER_COLUMN_POLICYNO_POLICYNO_3 =
		"(policyVehCvr.id.policyNo IS NULL OR policyVehCvr.id.policyNo = '')";

	private FinderPath _finderPathWithPaginationFindByPolicyNoVehId;
	private FinderPath _finderPathWithoutPaginationFindByPolicyNoVehId;
	private FinderPath _finderPathCountByPolicyNoVehId;

	/**
	 * Returns all the policy veh cvrs where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @return the matching policy veh cvrs
	 */
	@Override
	public List<PolicyVehCvr> findByPolicyNoVehId(
		String policyNo, String vehId) {

		return findByPolicyNoVehId(
			policyNo, vehId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy veh cvrs where policyNo = &#63; and vehId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehCvrModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param start the lower bound of the range of policy veh cvrs
	 * @param end the upper bound of the range of policy veh cvrs (not inclusive)
	 * @return the range of matching policy veh cvrs
	 */
	@Override
	public List<PolicyVehCvr> findByPolicyNoVehId(
		String policyNo, String vehId, int start, int end) {

		return findByPolicyNoVehId(policyNo, vehId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy veh cvrs where policyNo = &#63; and vehId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehCvrModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param start the lower bound of the range of policy veh cvrs
	 * @param end the upper bound of the range of policy veh cvrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy veh cvrs
	 */
	@Override
	public List<PolicyVehCvr> findByPolicyNoVehId(
		String policyNo, String vehId, int start, int end,
		OrderByComparator<PolicyVehCvr> orderByComparator) {

		return findByPolicyNoVehId(
			policyNo, vehId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy veh cvrs where policyNo = &#63; and vehId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehCvrModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param start the lower bound of the range of policy veh cvrs
	 * @param end the upper bound of the range of policy veh cvrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy veh cvrs
	 */
	@Override
	public List<PolicyVehCvr> findByPolicyNoVehId(
		String policyNo, String vehId, int start, int end,
		OrderByComparator<PolicyVehCvr> orderByComparator,
		boolean useFinderCache) {

		policyNo = Objects.toString(policyNo, "");
		vehId = Objects.toString(vehId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPolicyNoVehId;
				finderArgs = new Object[] {policyNo, vehId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPolicyNoVehId;
			finderArgs = new Object[] {
				policyNo, vehId, start, end, orderByComparator
			};
		}

		List<PolicyVehCvr> list = null;

		if (useFinderCache) {
			list = (List<PolicyVehCvr>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PolicyVehCvr policyVehCvr : list) {
					if (!policyNo.equals(policyVehCvr.getPolicyNo()) ||
						!vehId.equals(policyVehCvr.getVehId())) {

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

			sb.append(_SQL_SELECT_POLICYVEHCVR_WHERE);

			boolean bindPolicyNo = false;

			if (policyNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYNOVEHID_POLICYNO_3);
			}
			else {
				bindPolicyNo = true;

				sb.append(_FINDER_COLUMN_POLICYNOVEHID_POLICYNO_2);
			}

			boolean bindVehId = false;

			if (vehId.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYNOVEHID_VEHID_3);
			}
			else {
				bindVehId = true;

				sb.append(_FINDER_COLUMN_POLICYNOVEHID_VEHID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PolicyVehCvrModelImpl.ORDER_BY_JPQL);
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

				if (bindVehId) {
					queryPos.add(vehId);
				}

				list = (List<PolicyVehCvr>)QueryUtil.list(
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
	 * Returns the first policy veh cvr in the ordered set where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a matching policy veh cvr could not be found
	 */
	@Override
	public PolicyVehCvr findByPolicyNoVehId_First(
			String policyNo, String vehId,
			OrderByComparator<PolicyVehCvr> orderByComparator)
		throws NoSuchPolicyVehCvrException {

		PolicyVehCvr policyVehCvr = fetchByPolicyNoVehId_First(
			policyNo, vehId, orderByComparator);

		if (policyVehCvr != null) {
			return policyVehCvr;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNo=");
		sb.append(policyNo);

		sb.append(", vehId=");
		sb.append(vehId);

		sb.append("}");

		throw new NoSuchPolicyVehCvrException(sb.toString());
	}

	/**
	 * Returns the first policy veh cvr in the ordered set where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh cvr, or <code>null</code> if a matching policy veh cvr could not be found
	 */
	@Override
	public PolicyVehCvr fetchByPolicyNoVehId_First(
		String policyNo, String vehId,
		OrderByComparator<PolicyVehCvr> orderByComparator) {

		List<PolicyVehCvr> list = findByPolicyNoVehId(
			policyNo, vehId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last policy veh cvr in the ordered set where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a matching policy veh cvr could not be found
	 */
	@Override
	public PolicyVehCvr findByPolicyNoVehId_Last(
			String policyNo, String vehId,
			OrderByComparator<PolicyVehCvr> orderByComparator)
		throws NoSuchPolicyVehCvrException {

		PolicyVehCvr policyVehCvr = fetchByPolicyNoVehId_Last(
			policyNo, vehId, orderByComparator);

		if (policyVehCvr != null) {
			return policyVehCvr;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNo=");
		sb.append(policyNo);

		sb.append(", vehId=");
		sb.append(vehId);

		sb.append("}");

		throw new NoSuchPolicyVehCvrException(sb.toString());
	}

	/**
	 * Returns the last policy veh cvr in the ordered set where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh cvr, or <code>null</code> if a matching policy veh cvr could not be found
	 */
	@Override
	public PolicyVehCvr fetchByPolicyNoVehId_Last(
		String policyNo, String vehId,
		OrderByComparator<PolicyVehCvr> orderByComparator) {

		int count = countByPolicyNoVehId(policyNo, vehId);

		if (count == 0) {
			return null;
		}

		List<PolicyVehCvr> list = findByPolicyNoVehId(
			policyNo, vehId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the policy veh cvrs before and after the current policy veh cvr in the ordered set where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyVehCvrPK the primary key of the current policy veh cvr
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a policy veh cvr with the primary key could not be found
	 */
	@Override
	public PolicyVehCvr[] findByPolicyNoVehId_PrevAndNext(
			PolicyVehCvrPK policyVehCvrPK, String policyNo, String vehId,
			OrderByComparator<PolicyVehCvr> orderByComparator)
		throws NoSuchPolicyVehCvrException {

		policyNo = Objects.toString(policyNo, "");
		vehId = Objects.toString(vehId, "");

		PolicyVehCvr policyVehCvr = findByPrimaryKey(policyVehCvrPK);

		Session session = null;

		try {
			session = openSession();

			PolicyVehCvr[] array = new PolicyVehCvrImpl[3];

			array[0] = getByPolicyNoVehId_PrevAndNext(
				session, policyVehCvr, policyNo, vehId, orderByComparator,
				true);

			array[1] = policyVehCvr;

			array[2] = getByPolicyNoVehId_PrevAndNext(
				session, policyVehCvr, policyNo, vehId, orderByComparator,
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

	protected PolicyVehCvr getByPolicyNoVehId_PrevAndNext(
		Session session, PolicyVehCvr policyVehCvr, String policyNo,
		String vehId, OrderByComparator<PolicyVehCvr> orderByComparator,
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

		sb.append(_SQL_SELECT_POLICYVEHCVR_WHERE);

		boolean bindPolicyNo = false;

		if (policyNo.isEmpty()) {
			sb.append(_FINDER_COLUMN_POLICYNOVEHID_POLICYNO_3);
		}
		else {
			bindPolicyNo = true;

			sb.append(_FINDER_COLUMN_POLICYNOVEHID_POLICYNO_2);
		}

		boolean bindVehId = false;

		if (vehId.isEmpty()) {
			sb.append(_FINDER_COLUMN_POLICYNOVEHID_VEHID_3);
		}
		else {
			bindVehId = true;

			sb.append(_FINDER_COLUMN_POLICYNOVEHID_VEHID_2);
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
			sb.append(PolicyVehCvrModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPolicyNo) {
			queryPos.add(policyNo);
		}

		if (bindVehId) {
			queryPos.add(vehId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(policyVehCvr)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PolicyVehCvr> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the policy veh cvrs where policyNo = &#63; and vehId = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 */
	@Override
	public void removeByPolicyNoVehId(String policyNo, String vehId) {
		for (PolicyVehCvr policyVehCvr :
				findByPolicyNoVehId(
					policyNo, vehId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(policyVehCvr);
		}
	}

	/**
	 * Returns the number of policy veh cvrs where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @return the number of matching policy veh cvrs
	 */
	@Override
	public int countByPolicyNoVehId(String policyNo, String vehId) {
		policyNo = Objects.toString(policyNo, "");
		vehId = Objects.toString(vehId, "");

		FinderPath finderPath = _finderPathCountByPolicyNoVehId;

		Object[] finderArgs = new Object[] {policyNo, vehId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_POLICYVEHCVR_WHERE);

			boolean bindPolicyNo = false;

			if (policyNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYNOVEHID_POLICYNO_3);
			}
			else {
				bindPolicyNo = true;

				sb.append(_FINDER_COLUMN_POLICYNOVEHID_POLICYNO_2);
			}

			boolean bindVehId = false;

			if (vehId.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYNOVEHID_VEHID_3);
			}
			else {
				bindVehId = true;

				sb.append(_FINDER_COLUMN_POLICYNOVEHID_VEHID_2);
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

				if (bindVehId) {
					queryPos.add(vehId);
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

	private static final String _FINDER_COLUMN_POLICYNOVEHID_POLICYNO_2 =
		"policyVehCvr.id.policyNo = ? AND ";

	private static final String _FINDER_COLUMN_POLICYNOVEHID_POLICYNO_3 =
		"(policyVehCvr.id.policyNo IS NULL OR policyVehCvr.id.policyNo = '') AND ";

	private static final String _FINDER_COLUMN_POLICYNOVEHID_VEHID_2 =
		"policyVehCvr.id.vehId = ?";

	private static final String _FINDER_COLUMN_POLICYNOVEHID_VEHID_3 =
		"(policyVehCvr.id.vehId IS NULL OR policyVehCvr.id.vehId = '')";

	public PolicyVehCvrPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("policyNo", "ODS_POLICY_NO");
		dbColumnNames.put("vehId", "ODS_VEH_ID");
		dbColumnNames.put("cvrCode", "ODS_CVR_CODE");
		dbColumnNames.put("description", "ODS_DESCRIPTION");
		dbColumnNames.put("cvrType", "ODS_CVR_TYPE");
		dbColumnNames.put("benefitTerm", "ODS_BENEFIT_TERM");
		dbColumnNames.put("premiumTerm", "ODS_PREMIUM_TERM");
		dbColumnNames.put("premium", "ODS_PREMIUM");
		dbColumnNames.put("sumCovered", "ODS_SUM_COVERED");

		setDBColumnNames(dbColumnNames);

		setModelClass(PolicyVehCvr.class);

		setModelImplClass(PolicyVehCvrImpl.class);
		setModelPKClass(PolicyVehCvrPK.class);
	}

	/**
	 * Caches the policy veh cvr in the entity cache if it is enabled.
	 *
	 * @param policyVehCvr the policy veh cvr
	 */
	@Override
	public void cacheResult(PolicyVehCvr policyVehCvr) {
		dummyEntityCache.putResult(
			PolicyVehCvrImpl.class, policyVehCvr.getPrimaryKey(), policyVehCvr);
	}

	/**
	 * Caches the policy veh cvrs in the entity cache if it is enabled.
	 *
	 * @param policyVehCvrs the policy veh cvrs
	 */
	@Override
	public void cacheResult(List<PolicyVehCvr> policyVehCvrs) {
		for (PolicyVehCvr policyVehCvr : policyVehCvrs) {
			if (dummyEntityCache.getResult(
					PolicyVehCvrImpl.class, policyVehCvr.getPrimaryKey()) ==
						null) {

				cacheResult(policyVehCvr);
			}
		}
	}

	/**
	 * Clears the cache for all policy veh cvrs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(PolicyVehCvrImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the policy veh cvr.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PolicyVehCvr policyVehCvr) {
		dummyEntityCache.removeResult(PolicyVehCvrImpl.class, policyVehCvr);
	}

	@Override
	public void clearCache(List<PolicyVehCvr> policyVehCvrs) {
		for (PolicyVehCvr policyVehCvr : policyVehCvrs) {
			dummyEntityCache.removeResult(PolicyVehCvrImpl.class, policyVehCvr);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(PolicyVehCvrImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new policy veh cvr with the primary key. Does not add the policy veh cvr to the database.
	 *
	 * @param policyVehCvrPK the primary key for the new policy veh cvr
	 * @return the new policy veh cvr
	 */
	@Override
	public PolicyVehCvr create(PolicyVehCvrPK policyVehCvrPK) {
		PolicyVehCvr policyVehCvr = new PolicyVehCvrImpl();

		policyVehCvr.setNew(true);
		policyVehCvr.setPrimaryKey(policyVehCvrPK);

		return policyVehCvr;
	}

	/**
	 * Removes the policy veh cvr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyVehCvrPK the primary key of the policy veh cvr
	 * @return the policy veh cvr that was removed
	 * @throws NoSuchPolicyVehCvrException if a policy veh cvr with the primary key could not be found
	 */
	@Override
	public PolicyVehCvr remove(PolicyVehCvrPK policyVehCvrPK)
		throws NoSuchPolicyVehCvrException {

		return remove((Serializable)policyVehCvrPK);
	}

	/**
	 * Removes the policy veh cvr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the policy veh cvr
	 * @return the policy veh cvr that was removed
	 * @throws NoSuchPolicyVehCvrException if a policy veh cvr with the primary key could not be found
	 */
	@Override
	public PolicyVehCvr remove(Serializable primaryKey)
		throws NoSuchPolicyVehCvrException {

		Session session = null;

		try {
			session = openSession();

			PolicyVehCvr policyVehCvr = (PolicyVehCvr)session.get(
				PolicyVehCvrImpl.class, primaryKey);

			if (policyVehCvr == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPolicyVehCvrException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(policyVehCvr);
		}
		catch (NoSuchPolicyVehCvrException noSuchEntityException) {
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
	protected PolicyVehCvr removeImpl(PolicyVehCvr policyVehCvr) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(policyVehCvr)) {
				policyVehCvr = (PolicyVehCvr)session.get(
					PolicyVehCvrImpl.class, policyVehCvr.getPrimaryKeyObj());
			}

			if (policyVehCvr != null) {
				session.delete(policyVehCvr);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (policyVehCvr != null) {
			clearCache(policyVehCvr);
		}

		return policyVehCvr;
	}

	@Override
	public PolicyVehCvr updateImpl(PolicyVehCvr policyVehCvr) {
		boolean isNew = policyVehCvr.isNew();

		if (!(policyVehCvr instanceof PolicyVehCvrModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(policyVehCvr.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					policyVehCvr);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in policyVehCvr proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PolicyVehCvr implementation " +
					policyVehCvr.getClass());
		}

		PolicyVehCvrModelImpl policyVehCvrModelImpl =
			(PolicyVehCvrModelImpl)policyVehCvr;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(policyVehCvr);
			}
			else {
				policyVehCvr = (PolicyVehCvr)session.merge(policyVehCvr);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			PolicyVehCvrImpl.class, policyVehCvrModelImpl, false, true);

		if (isNew) {
			policyVehCvr.setNew(false);
		}

		policyVehCvr.resetOriginalValues();

		return policyVehCvr;
	}

	/**
	 * Returns the policy veh cvr with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the policy veh cvr
	 * @return the policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a policy veh cvr with the primary key could not be found
	 */
	@Override
	public PolicyVehCvr findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPolicyVehCvrException {

		PolicyVehCvr policyVehCvr = fetchByPrimaryKey(primaryKey);

		if (policyVehCvr == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPolicyVehCvrException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return policyVehCvr;
	}

	/**
	 * Returns the policy veh cvr with the primary key or throws a <code>NoSuchPolicyVehCvrException</code> if it could not be found.
	 *
	 * @param policyVehCvrPK the primary key of the policy veh cvr
	 * @return the policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a policy veh cvr with the primary key could not be found
	 */
	@Override
	public PolicyVehCvr findByPrimaryKey(PolicyVehCvrPK policyVehCvrPK)
		throws NoSuchPolicyVehCvrException {

		return findByPrimaryKey((Serializable)policyVehCvrPK);
	}

	/**
	 * Returns the policy veh cvr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyVehCvrPK the primary key of the policy veh cvr
	 * @return the policy veh cvr, or <code>null</code> if a policy veh cvr with the primary key could not be found
	 */
	@Override
	public PolicyVehCvr fetchByPrimaryKey(PolicyVehCvrPK policyVehCvrPK) {
		return fetchByPrimaryKey((Serializable)policyVehCvrPK);
	}

	/**
	 * Returns all the policy veh cvrs.
	 *
	 * @return the policy veh cvrs
	 */
	@Override
	public List<PolicyVehCvr> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy veh cvrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehCvrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy veh cvrs
	 * @param end the upper bound of the range of policy veh cvrs (not inclusive)
	 * @return the range of policy veh cvrs
	 */
	@Override
	public List<PolicyVehCvr> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy veh cvrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehCvrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy veh cvrs
	 * @param end the upper bound of the range of policy veh cvrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy veh cvrs
	 */
	@Override
	public List<PolicyVehCvr> findAll(
		int start, int end, OrderByComparator<PolicyVehCvr> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy veh cvrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehCvrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy veh cvrs
	 * @param end the upper bound of the range of policy veh cvrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy veh cvrs
	 */
	@Override
	public List<PolicyVehCvr> findAll(
		int start, int end, OrderByComparator<PolicyVehCvr> orderByComparator,
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

		List<PolicyVehCvr> list = null;

		if (useFinderCache) {
			list = (List<PolicyVehCvr>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_POLICYVEHCVR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_POLICYVEHCVR;

				sql = sql.concat(PolicyVehCvrModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PolicyVehCvr>)QueryUtil.list(
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
	 * Removes all the policy veh cvrs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PolicyVehCvr policyVehCvr : findAll()) {
			remove(policyVehCvr);
		}
	}

	/**
	 * Returns the number of policy veh cvrs.
	 *
	 * @return the number of policy veh cvrs
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_POLICYVEHCVR);

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
		return "policyVehCvrPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_POLICYVEHCVR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PolicyVehCvrModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the policy veh cvr persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PolicyVehCvrModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PolicyVehCvr.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByPolicyNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPolicyNo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"ODS_POLICY_NO"}, true);

		_finderPathWithoutPaginationFindByPolicyNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPolicyNo",
			new String[] {String.class.getName()},
			new String[] {"ODS_POLICY_NO"}, true);

		_finderPathCountByPolicyNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPolicyNo",
			new String[] {String.class.getName()},
			new String[] {"ODS_POLICY_NO"}, false);

		_finderPathWithPaginationFindByPolicyNoVehId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPolicyNoVehId",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"ODS_POLICY_NO", "ODS_VEH_ID"}, true);

		_finderPathWithoutPaginationFindByPolicyNoVehId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPolicyNoVehId",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"ODS_POLICY_NO", "ODS_VEH_ID"}, true);

		_finderPathCountByPolicyNoVehId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPolicyNoVehId",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"ODS_POLICY_NO", "ODS_VEH_ID"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(PolicyVehCvrImpl.class.getName());

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

	private static final String _SQL_SELECT_POLICYVEHCVR =
		"SELECT policyVehCvr FROM PolicyVehCvr policyVehCvr";

	private static final String _SQL_SELECT_POLICYVEHCVR_WHERE =
		"SELECT policyVehCvr FROM PolicyVehCvr policyVehCvr WHERE ";

	private static final String _SQL_COUNT_POLICYVEHCVR =
		"SELECT COUNT(policyVehCvr) FROM PolicyVehCvr policyVehCvr";

	private static final String _SQL_COUNT_POLICYVEHCVR_WHERE =
		"SELECT COUNT(policyVehCvr) FROM PolicyVehCvr policyVehCvr WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "policyVehCvr.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PolicyVehCvr exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PolicyVehCvr exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PolicyVehCvrPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"policyNo", "vehId", "cvrCode", "description", "cvrType",
			"benefitTerm", "premiumTerm", "premium", "sumCovered"
		});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"policyNo", "vehId", "description"});

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

	private static class PolicyVehCvrModelArgumentsResolver
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

			PolicyVehCvrModelImpl policyVehCvrModelImpl =
				(PolicyVehCvrModelImpl)baseModel;

			long columnBitmask = policyVehCvrModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(policyVehCvrModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						policyVehCvrModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(policyVehCvrModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PolicyVehCvrModelImpl policyVehCvrModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = policyVehCvrModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = policyVehCvrModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}