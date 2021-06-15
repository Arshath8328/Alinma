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

import com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException;
import com.ejada.atmc.acl.db.model.PolicyVEH;
import com.ejada.atmc.acl.db.model.impl.PolicyVEHImpl;
import com.ejada.atmc.acl.db.model.impl.PolicyVEHModelImpl;
import com.ejada.atmc.acl.db.service.persistence.PolicyVEHPK;
import com.ejada.atmc.acl.db.service.persistence.PolicyVEHPersistence;
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
 * The persistence implementation for the policy veh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PolicyVEHPersistence.class)
public class PolicyVEHPersistenceImpl
	extends BasePersistenceImpl<PolicyVEH> implements PolicyVEHPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PolicyVEHUtil</code> to access the policy veh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PolicyVEHImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByPolicyNoVehicleSeqCustom;
	private FinderPath
		_finderPathWithoutPaginationFindByPolicyNoVehicleSeqCustom;
	private FinderPath _finderPathCountByPolicyNoVehicleSeqCustom;

	/**
	 * Returns all the policy vehs where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @return the matching policy vehs
	 */
	@Override
	public List<PolicyVEH> findByPolicyNoVehicleSeqCustom(
		String policyNo, String vehicleSeqCustom) {

		return findByPolicyNoVehicleSeqCustom(
			policyNo, vehicleSeqCustom, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the policy vehs where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @return the range of matching policy vehs
	 */
	@Override
	public List<PolicyVEH> findByPolicyNoVehicleSeqCustom(
		String policyNo, String vehicleSeqCustom, int start, int end) {

		return findByPolicyNoVehicleSeqCustom(
			policyNo, vehicleSeqCustom, start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy vehs where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy vehs
	 */
	@Override
	public List<PolicyVEH> findByPolicyNoVehicleSeqCustom(
		String policyNo, String vehicleSeqCustom, int start, int end,
		OrderByComparator<PolicyVEH> orderByComparator) {

		return findByPolicyNoVehicleSeqCustom(
			policyNo, vehicleSeqCustom, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy vehs where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy vehs
	 */
	@Override
	public List<PolicyVEH> findByPolicyNoVehicleSeqCustom(
		String policyNo, String vehicleSeqCustom, int start, int end,
		OrderByComparator<PolicyVEH> orderByComparator,
		boolean useFinderCache) {

		policyNo = Objects.toString(policyNo, "");
		vehicleSeqCustom = Objects.toString(vehicleSeqCustom, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByPolicyNoVehicleSeqCustom;
				finderArgs = new Object[] {policyNo, vehicleSeqCustom};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByPolicyNoVehicleSeqCustom;
			finderArgs = new Object[] {
				policyNo, vehicleSeqCustom, start, end, orderByComparator
			};
		}

		List<PolicyVEH> list = null;

		if (useFinderCache) {
			list = (List<PolicyVEH>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PolicyVEH policyVEH : list) {
					if (!policyNo.equals(policyVEH.getPolicyNo()) ||
						!vehicleSeqCustom.equals(
							policyVEH.getVehicleSeqCustom())) {

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

			sb.append(_SQL_SELECT_POLICYVEH_WHERE);

			boolean bindPolicyNo = false;

			if (policyNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYNOVEHICLESEQCUSTOM_POLICYNO_3);
			}
			else {
				bindPolicyNo = true;

				sb.append(_FINDER_COLUMN_POLICYNOVEHICLESEQCUSTOM_POLICYNO_2);
			}

			boolean bindVehicleSeqCustom = false;

			if (vehicleSeqCustom.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_POLICYNOVEHICLESEQCUSTOM_VEHICLESEQCUSTOM_3);
			}
			else {
				bindVehicleSeqCustom = true;

				sb.append(
					_FINDER_COLUMN_POLICYNOVEHICLESEQCUSTOM_VEHICLESEQCUSTOM_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PolicyVEHModelImpl.ORDER_BY_JPQL);
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

				if (bindVehicleSeqCustom) {
					queryPos.add(vehicleSeqCustom);
				}

				list = (List<PolicyVEH>)QueryUtil.list(
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
	 * Returns the first policy veh in the ordered set where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	@Override
	public PolicyVEH findByPolicyNoVehicleSeqCustom_First(
			String policyNo, String vehicleSeqCustom,
			OrderByComparator<PolicyVEH> orderByComparator)
		throws NoSuchPolicyVEHException {

		PolicyVEH policyVEH = fetchByPolicyNoVehicleSeqCustom_First(
			policyNo, vehicleSeqCustom, orderByComparator);

		if (policyVEH != null) {
			return policyVEH;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNo=");
		sb.append(policyNo);

		sb.append(", vehicleSeqCustom=");
		sb.append(vehicleSeqCustom);

		sb.append("}");

		throw new NoSuchPolicyVEHException(sb.toString());
	}

	/**
	 * Returns the first policy veh in the ordered set where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	@Override
	public PolicyVEH fetchByPolicyNoVehicleSeqCustom_First(
		String policyNo, String vehicleSeqCustom,
		OrderByComparator<PolicyVEH> orderByComparator) {

		List<PolicyVEH> list = findByPolicyNoVehicleSeqCustom(
			policyNo, vehicleSeqCustom, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last policy veh in the ordered set where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	@Override
	public PolicyVEH findByPolicyNoVehicleSeqCustom_Last(
			String policyNo, String vehicleSeqCustom,
			OrderByComparator<PolicyVEH> orderByComparator)
		throws NoSuchPolicyVEHException {

		PolicyVEH policyVEH = fetchByPolicyNoVehicleSeqCustom_Last(
			policyNo, vehicleSeqCustom, orderByComparator);

		if (policyVEH != null) {
			return policyVEH;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNo=");
		sb.append(policyNo);

		sb.append(", vehicleSeqCustom=");
		sb.append(vehicleSeqCustom);

		sb.append("}");

		throw new NoSuchPolicyVEHException(sb.toString());
	}

	/**
	 * Returns the last policy veh in the ordered set where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	@Override
	public PolicyVEH fetchByPolicyNoVehicleSeqCustom_Last(
		String policyNo, String vehicleSeqCustom,
		OrderByComparator<PolicyVEH> orderByComparator) {

		int count = countByPolicyNoVehicleSeqCustom(policyNo, vehicleSeqCustom);

		if (count == 0) {
			return null;
		}

		List<PolicyVEH> list = findByPolicyNoVehicleSeqCustom(
			policyNo, vehicleSeqCustom, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the policy vehs before and after the current policy veh in the ordered set where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyVEHPK the primary key of the current policy veh
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy veh
	 * @throws NoSuchPolicyVEHException if a policy veh with the primary key could not be found
	 */
	@Override
	public PolicyVEH[] findByPolicyNoVehicleSeqCustom_PrevAndNext(
			PolicyVEHPK policyVEHPK, String policyNo, String vehicleSeqCustom,
			OrderByComparator<PolicyVEH> orderByComparator)
		throws NoSuchPolicyVEHException {

		policyNo = Objects.toString(policyNo, "");
		vehicleSeqCustom = Objects.toString(vehicleSeqCustom, "");

		PolicyVEH policyVEH = findByPrimaryKey(policyVEHPK);

		Session session = null;

		try {
			session = openSession();

			PolicyVEH[] array = new PolicyVEHImpl[3];

			array[0] = getByPolicyNoVehicleSeqCustom_PrevAndNext(
				session, policyVEH, policyNo, vehicleSeqCustom,
				orderByComparator, true);

			array[1] = policyVEH;

			array[2] = getByPolicyNoVehicleSeqCustom_PrevAndNext(
				session, policyVEH, policyNo, vehicleSeqCustom,
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

	protected PolicyVEH getByPolicyNoVehicleSeqCustom_PrevAndNext(
		Session session, PolicyVEH policyVEH, String policyNo,
		String vehicleSeqCustom, OrderByComparator<PolicyVEH> orderByComparator,
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

		sb.append(_SQL_SELECT_POLICYVEH_WHERE);

		boolean bindPolicyNo = false;

		if (policyNo.isEmpty()) {
			sb.append(_FINDER_COLUMN_POLICYNOVEHICLESEQCUSTOM_POLICYNO_3);
		}
		else {
			bindPolicyNo = true;

			sb.append(_FINDER_COLUMN_POLICYNOVEHICLESEQCUSTOM_POLICYNO_2);
		}

		boolean bindVehicleSeqCustom = false;

		if (vehicleSeqCustom.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_POLICYNOVEHICLESEQCUSTOM_VEHICLESEQCUSTOM_3);
		}
		else {
			bindVehicleSeqCustom = true;

			sb.append(
				_FINDER_COLUMN_POLICYNOVEHICLESEQCUSTOM_VEHICLESEQCUSTOM_2);
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
			sb.append(PolicyVEHModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPolicyNo) {
			queryPos.add(policyNo);
		}

		if (bindVehicleSeqCustom) {
			queryPos.add(vehicleSeqCustom);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(policyVEH)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PolicyVEH> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the policy vehs where policyNo = &#63; and vehicleSeqCustom = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 */
	@Override
	public void removeByPolicyNoVehicleSeqCustom(
		String policyNo, String vehicleSeqCustom) {

		for (PolicyVEH policyVEH :
				findByPolicyNoVehicleSeqCustom(
					policyNo, vehicleSeqCustom, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(policyVEH);
		}
	}

	/**
	 * Returns the number of policy vehs where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @return the number of matching policy vehs
	 */
	@Override
	public int countByPolicyNoVehicleSeqCustom(
		String policyNo, String vehicleSeqCustom) {

		policyNo = Objects.toString(policyNo, "");
		vehicleSeqCustom = Objects.toString(vehicleSeqCustom, "");

		FinderPath finderPath = _finderPathCountByPolicyNoVehicleSeqCustom;

		Object[] finderArgs = new Object[] {policyNo, vehicleSeqCustom};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_POLICYVEH_WHERE);

			boolean bindPolicyNo = false;

			if (policyNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYNOVEHICLESEQCUSTOM_POLICYNO_3);
			}
			else {
				bindPolicyNo = true;

				sb.append(_FINDER_COLUMN_POLICYNOVEHICLESEQCUSTOM_POLICYNO_2);
			}

			boolean bindVehicleSeqCustom = false;

			if (vehicleSeqCustom.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_POLICYNOVEHICLESEQCUSTOM_VEHICLESEQCUSTOM_3);
			}
			else {
				bindVehicleSeqCustom = true;

				sb.append(
					_FINDER_COLUMN_POLICYNOVEHICLESEQCUSTOM_VEHICLESEQCUSTOM_2);
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

				if (bindVehicleSeqCustom) {
					queryPos.add(vehicleSeqCustom);
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
		_FINDER_COLUMN_POLICYNOVEHICLESEQCUSTOM_POLICYNO_2 =
			"policyVEH.id.policyNo = ? AND ";

	private static final String
		_FINDER_COLUMN_POLICYNOVEHICLESEQCUSTOM_POLICYNO_3 =
			"(policyVEH.id.policyNo IS NULL OR policyVEH.id.policyNo = '') AND ";

	private static final String
		_FINDER_COLUMN_POLICYNOVEHICLESEQCUSTOM_VEHICLESEQCUSTOM_2 =
			"policyVEH.vehicleSeqCustom = ?";

	private static final String
		_FINDER_COLUMN_POLICYNOVEHICLESEQCUSTOM_VEHICLESEQCUSTOM_3 =
			"(policyVEH.vehicleSeqCustom IS NULL OR policyVEH.vehicleSeqCustom = '')";

	private FinderPath _finderPathWithPaginationFindByVehicleSeqCustom;
	private FinderPath _finderPathWithoutPaginationFindByVehicleSeqCustom;
	private FinderPath _finderPathCountByVehicleSeqCustom;

	/**
	 * Returns all the policy vehs where vehicleSeqCustom = &#63;.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @return the matching policy vehs
	 */
	@Override
	public List<PolicyVEH> findByVehicleSeqCustom(String vehicleSeqCustom) {
		return findByVehicleSeqCustom(
			vehicleSeqCustom, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy vehs where vehicleSeqCustom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @return the range of matching policy vehs
	 */
	@Override
	public List<PolicyVEH> findByVehicleSeqCustom(
		String vehicleSeqCustom, int start, int end) {

		return findByVehicleSeqCustom(vehicleSeqCustom, start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy vehs where vehicleSeqCustom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy vehs
	 */
	@Override
	public List<PolicyVEH> findByVehicleSeqCustom(
		String vehicleSeqCustom, int start, int end,
		OrderByComparator<PolicyVEH> orderByComparator) {

		return findByVehicleSeqCustom(
			vehicleSeqCustom, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy vehs where vehicleSeqCustom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy vehs
	 */
	@Override
	public List<PolicyVEH> findByVehicleSeqCustom(
		String vehicleSeqCustom, int start, int end,
		OrderByComparator<PolicyVEH> orderByComparator,
		boolean useFinderCache) {

		vehicleSeqCustom = Objects.toString(vehicleSeqCustom, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByVehicleSeqCustom;
				finderArgs = new Object[] {vehicleSeqCustom};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByVehicleSeqCustom;
			finderArgs = new Object[] {
				vehicleSeqCustom, start, end, orderByComparator
			};
		}

		List<PolicyVEH> list = null;

		if (useFinderCache) {
			list = (List<PolicyVEH>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PolicyVEH policyVEH : list) {
					if (!vehicleSeqCustom.equals(
							policyVEH.getVehicleSeqCustom())) {

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

			sb.append(_SQL_SELECT_POLICYVEH_WHERE);

			boolean bindVehicleSeqCustom = false;

			if (vehicleSeqCustom.isEmpty()) {
				sb.append(_FINDER_COLUMN_VEHICLESEQCUSTOM_VEHICLESEQCUSTOM_3);
			}
			else {
				bindVehicleSeqCustom = true;

				sb.append(_FINDER_COLUMN_VEHICLESEQCUSTOM_VEHICLESEQCUSTOM_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PolicyVEHModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindVehicleSeqCustom) {
					queryPos.add(vehicleSeqCustom);
				}

				list = (List<PolicyVEH>)QueryUtil.list(
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
	 * Returns the first policy veh in the ordered set where vehicleSeqCustom = &#63;.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	@Override
	public PolicyVEH findByVehicleSeqCustom_First(
			String vehicleSeqCustom,
			OrderByComparator<PolicyVEH> orderByComparator)
		throws NoSuchPolicyVEHException {

		PolicyVEH policyVEH = fetchByVehicleSeqCustom_First(
			vehicleSeqCustom, orderByComparator);

		if (policyVEH != null) {
			return policyVEH;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("vehicleSeqCustom=");
		sb.append(vehicleSeqCustom);

		sb.append("}");

		throw new NoSuchPolicyVEHException(sb.toString());
	}

	/**
	 * Returns the first policy veh in the ordered set where vehicleSeqCustom = &#63;.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	@Override
	public PolicyVEH fetchByVehicleSeqCustom_First(
		String vehicleSeqCustom,
		OrderByComparator<PolicyVEH> orderByComparator) {

		List<PolicyVEH> list = findByVehicleSeqCustom(
			vehicleSeqCustom, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last policy veh in the ordered set where vehicleSeqCustom = &#63;.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	@Override
	public PolicyVEH findByVehicleSeqCustom_Last(
			String vehicleSeqCustom,
			OrderByComparator<PolicyVEH> orderByComparator)
		throws NoSuchPolicyVEHException {

		PolicyVEH policyVEH = fetchByVehicleSeqCustom_Last(
			vehicleSeqCustom, orderByComparator);

		if (policyVEH != null) {
			return policyVEH;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("vehicleSeqCustom=");
		sb.append(vehicleSeqCustom);

		sb.append("}");

		throw new NoSuchPolicyVEHException(sb.toString());
	}

	/**
	 * Returns the last policy veh in the ordered set where vehicleSeqCustom = &#63;.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	@Override
	public PolicyVEH fetchByVehicleSeqCustom_Last(
		String vehicleSeqCustom,
		OrderByComparator<PolicyVEH> orderByComparator) {

		int count = countByVehicleSeqCustom(vehicleSeqCustom);

		if (count == 0) {
			return null;
		}

		List<PolicyVEH> list = findByVehicleSeqCustom(
			vehicleSeqCustom, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the policy vehs before and after the current policy veh in the ordered set where vehicleSeqCustom = &#63;.
	 *
	 * @param policyVEHPK the primary key of the current policy veh
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy veh
	 * @throws NoSuchPolicyVEHException if a policy veh with the primary key could not be found
	 */
	@Override
	public PolicyVEH[] findByVehicleSeqCustom_PrevAndNext(
			PolicyVEHPK policyVEHPK, String vehicleSeqCustom,
			OrderByComparator<PolicyVEH> orderByComparator)
		throws NoSuchPolicyVEHException {

		vehicleSeqCustom = Objects.toString(vehicleSeqCustom, "");

		PolicyVEH policyVEH = findByPrimaryKey(policyVEHPK);

		Session session = null;

		try {
			session = openSession();

			PolicyVEH[] array = new PolicyVEHImpl[3];

			array[0] = getByVehicleSeqCustom_PrevAndNext(
				session, policyVEH, vehicleSeqCustom, orderByComparator, true);

			array[1] = policyVEH;

			array[2] = getByVehicleSeqCustom_PrevAndNext(
				session, policyVEH, vehicleSeqCustom, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PolicyVEH getByVehicleSeqCustom_PrevAndNext(
		Session session, PolicyVEH policyVEH, String vehicleSeqCustom,
		OrderByComparator<PolicyVEH> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_POLICYVEH_WHERE);

		boolean bindVehicleSeqCustom = false;

		if (vehicleSeqCustom.isEmpty()) {
			sb.append(_FINDER_COLUMN_VEHICLESEQCUSTOM_VEHICLESEQCUSTOM_3);
		}
		else {
			bindVehicleSeqCustom = true;

			sb.append(_FINDER_COLUMN_VEHICLESEQCUSTOM_VEHICLESEQCUSTOM_2);
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
			sb.append(PolicyVEHModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindVehicleSeqCustom) {
			queryPos.add(vehicleSeqCustom);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(policyVEH)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PolicyVEH> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the policy vehs where vehicleSeqCustom = &#63; from the database.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 */
	@Override
	public void removeByVehicleSeqCustom(String vehicleSeqCustom) {
		for (PolicyVEH policyVEH :
				findByVehicleSeqCustom(
					vehicleSeqCustom, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(policyVEH);
		}
	}

	/**
	 * Returns the number of policy vehs where vehicleSeqCustom = &#63;.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @return the number of matching policy vehs
	 */
	@Override
	public int countByVehicleSeqCustom(String vehicleSeqCustom) {
		vehicleSeqCustom = Objects.toString(vehicleSeqCustom, "");

		FinderPath finderPath = _finderPathCountByVehicleSeqCustom;

		Object[] finderArgs = new Object[] {vehicleSeqCustom};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POLICYVEH_WHERE);

			boolean bindVehicleSeqCustom = false;

			if (vehicleSeqCustom.isEmpty()) {
				sb.append(_FINDER_COLUMN_VEHICLESEQCUSTOM_VEHICLESEQCUSTOM_3);
			}
			else {
				bindVehicleSeqCustom = true;

				sb.append(_FINDER_COLUMN_VEHICLESEQCUSTOM_VEHICLESEQCUSTOM_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindVehicleSeqCustom) {
					queryPos.add(vehicleSeqCustom);
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
		_FINDER_COLUMN_VEHICLESEQCUSTOM_VEHICLESEQCUSTOM_2 =
			"policyVEH.vehicleSeqCustom = ?";

	private static final String
		_FINDER_COLUMN_VEHICLESEQCUSTOM_VEHICLESEQCUSTOM_3 =
			"(policyVEH.vehicleSeqCustom IS NULL OR policyVEH.vehicleSeqCustom = '')";

	private FinderPath _finderPathWithPaginationFindByEnPlateNo;
	private FinderPath _finderPathWithoutPaginationFindByEnPlateNo;
	private FinderPath _finderPathCountByEnPlateNo;

	/**
	 * Returns all the policy vehs where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @return the matching policy vehs
	 */
	@Override
	public List<PolicyVEH> findByEnPlateNo(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3) {

		return findByEnPlateNo(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy vehs where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @return the range of matching policy vehs
	 */
	@Override
	public List<PolicyVEH> findByEnPlateNo(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3,
		int start, int end) {

		return findByEnPlateNo(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3, start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy vehs where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy vehs
	 */
	@Override
	public List<PolicyVEH> findByEnPlateNo(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3,
		int start, int end, OrderByComparator<PolicyVEH> orderByComparator) {

		return findByEnPlateNo(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy vehs where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy vehs
	 */
	@Override
	public List<PolicyVEH> findByEnPlateNo(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3,
		int start, int end, OrderByComparator<PolicyVEH> orderByComparator,
		boolean useFinderCache) {

		enPlateL1 = Objects.toString(enPlateL1, "");
		enPlateL2 = Objects.toString(enPlateL2, "");
		enPlateL3 = Objects.toString(enPlateL3, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEnPlateNo;
				finderArgs = new Object[] {
					enPlateNo, enPlateL1, enPlateL2, enPlateL3
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEnPlateNo;
			finderArgs = new Object[] {
				enPlateNo, enPlateL1, enPlateL2, enPlateL3, start, end,
				orderByComparator
			};
		}

		List<PolicyVEH> list = null;

		if (useFinderCache) {
			list = (List<PolicyVEH>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PolicyVEH policyVEH : list) {
					if ((enPlateNo != policyVEH.getEnPlateNo()) ||
						!enPlateL1.equals(policyVEH.getEnPlateL1()) ||
						!enPlateL2.equals(policyVEH.getEnPlateL2()) ||
						!enPlateL3.equals(policyVEH.getEnPlateL3())) {

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
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_POLICYVEH_WHERE);

			sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATENO_2);

			boolean bindEnPlateL1 = false;

			if (enPlateL1.isEmpty()) {
				sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATEL1_3);
			}
			else {
				bindEnPlateL1 = true;

				sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATEL1_2);
			}

			boolean bindEnPlateL2 = false;

			if (enPlateL2.isEmpty()) {
				sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATEL2_3);
			}
			else {
				bindEnPlateL2 = true;

				sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATEL2_2);
			}

			boolean bindEnPlateL3 = false;

			if (enPlateL3.isEmpty()) {
				sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATEL3_3);
			}
			else {
				bindEnPlateL3 = true;

				sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATEL3_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PolicyVEHModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(enPlateNo);

				if (bindEnPlateL1) {
					queryPos.add(enPlateL1);
				}

				if (bindEnPlateL2) {
					queryPos.add(enPlateL2);
				}

				if (bindEnPlateL3) {
					queryPos.add(enPlateL3);
				}

				list = (List<PolicyVEH>)QueryUtil.list(
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
	 * Returns the first policy veh in the ordered set where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	@Override
	public PolicyVEH findByEnPlateNo_First(
			long enPlateNo, String enPlateL1, String enPlateL2,
			String enPlateL3, OrderByComparator<PolicyVEH> orderByComparator)
		throws NoSuchPolicyVEHException {

		PolicyVEH policyVEH = fetchByEnPlateNo_First(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3, orderByComparator);

		if (policyVEH != null) {
			return policyVEH;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("enPlateNo=");
		sb.append(enPlateNo);

		sb.append(", enPlateL1=");
		sb.append(enPlateL1);

		sb.append(", enPlateL2=");
		sb.append(enPlateL2);

		sb.append(", enPlateL3=");
		sb.append(enPlateL3);

		sb.append("}");

		throw new NoSuchPolicyVEHException(sb.toString());
	}

	/**
	 * Returns the first policy veh in the ordered set where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	@Override
	public PolicyVEH fetchByEnPlateNo_First(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3,
		OrderByComparator<PolicyVEH> orderByComparator) {

		List<PolicyVEH> list = findByEnPlateNo(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last policy veh in the ordered set where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	@Override
	public PolicyVEH findByEnPlateNo_Last(
			long enPlateNo, String enPlateL1, String enPlateL2,
			String enPlateL3, OrderByComparator<PolicyVEH> orderByComparator)
		throws NoSuchPolicyVEHException {

		PolicyVEH policyVEH = fetchByEnPlateNo_Last(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3, orderByComparator);

		if (policyVEH != null) {
			return policyVEH;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("enPlateNo=");
		sb.append(enPlateNo);

		sb.append(", enPlateL1=");
		sb.append(enPlateL1);

		sb.append(", enPlateL2=");
		sb.append(enPlateL2);

		sb.append(", enPlateL3=");
		sb.append(enPlateL3);

		sb.append("}");

		throw new NoSuchPolicyVEHException(sb.toString());
	}

	/**
	 * Returns the last policy veh in the ordered set where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	@Override
	public PolicyVEH fetchByEnPlateNo_Last(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3,
		OrderByComparator<PolicyVEH> orderByComparator) {

		int count = countByEnPlateNo(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3);

		if (count == 0) {
			return null;
		}

		List<PolicyVEH> list = findByEnPlateNo(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the policy vehs before and after the current policy veh in the ordered set where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * @param policyVEHPK the primary key of the current policy veh
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy veh
	 * @throws NoSuchPolicyVEHException if a policy veh with the primary key could not be found
	 */
	@Override
	public PolicyVEH[] findByEnPlateNo_PrevAndNext(
			PolicyVEHPK policyVEHPK, long enPlateNo, String enPlateL1,
			String enPlateL2, String enPlateL3,
			OrderByComparator<PolicyVEH> orderByComparator)
		throws NoSuchPolicyVEHException {

		enPlateL1 = Objects.toString(enPlateL1, "");
		enPlateL2 = Objects.toString(enPlateL2, "");
		enPlateL3 = Objects.toString(enPlateL3, "");

		PolicyVEH policyVEH = findByPrimaryKey(policyVEHPK);

		Session session = null;

		try {
			session = openSession();

			PolicyVEH[] array = new PolicyVEHImpl[3];

			array[0] = getByEnPlateNo_PrevAndNext(
				session, policyVEH, enPlateNo, enPlateL1, enPlateL2, enPlateL3,
				orderByComparator, true);

			array[1] = policyVEH;

			array[2] = getByEnPlateNo_PrevAndNext(
				session, policyVEH, enPlateNo, enPlateL1, enPlateL2, enPlateL3,
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

	protected PolicyVEH getByEnPlateNo_PrevAndNext(
		Session session, PolicyVEH policyVEH, long enPlateNo, String enPlateL1,
		String enPlateL2, String enPlateL3,
		OrderByComparator<PolicyVEH> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_POLICYVEH_WHERE);

		sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATENO_2);

		boolean bindEnPlateL1 = false;

		if (enPlateL1.isEmpty()) {
			sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATEL1_3);
		}
		else {
			bindEnPlateL1 = true;

			sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATEL1_2);
		}

		boolean bindEnPlateL2 = false;

		if (enPlateL2.isEmpty()) {
			sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATEL2_3);
		}
		else {
			bindEnPlateL2 = true;

			sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATEL2_2);
		}

		boolean bindEnPlateL3 = false;

		if (enPlateL3.isEmpty()) {
			sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATEL3_3);
		}
		else {
			bindEnPlateL3 = true;

			sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATEL3_2);
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
			sb.append(PolicyVEHModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(enPlateNo);

		if (bindEnPlateL1) {
			queryPos.add(enPlateL1);
		}

		if (bindEnPlateL2) {
			queryPos.add(enPlateL2);
		}

		if (bindEnPlateL3) {
			queryPos.add(enPlateL3);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(policyVEH)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PolicyVEH> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the policy vehs where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63; from the database.
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 */
	@Override
	public void removeByEnPlateNo(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3) {

		for (PolicyVEH policyVEH :
				findByEnPlateNo(
					enPlateNo, enPlateL1, enPlateL2, enPlateL3,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(policyVEH);
		}
	}

	/**
	 * Returns the number of policy vehs where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @return the number of matching policy vehs
	 */
	@Override
	public int countByEnPlateNo(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3) {

		enPlateL1 = Objects.toString(enPlateL1, "");
		enPlateL2 = Objects.toString(enPlateL2, "");
		enPlateL3 = Objects.toString(enPlateL3, "");

		FinderPath finderPath = _finderPathCountByEnPlateNo;

		Object[] finderArgs = new Object[] {
			enPlateNo, enPlateL1, enPlateL2, enPlateL3
		};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_POLICYVEH_WHERE);

			sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATENO_2);

			boolean bindEnPlateL1 = false;

			if (enPlateL1.isEmpty()) {
				sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATEL1_3);
			}
			else {
				bindEnPlateL1 = true;

				sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATEL1_2);
			}

			boolean bindEnPlateL2 = false;

			if (enPlateL2.isEmpty()) {
				sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATEL2_3);
			}
			else {
				bindEnPlateL2 = true;

				sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATEL2_2);
			}

			boolean bindEnPlateL3 = false;

			if (enPlateL3.isEmpty()) {
				sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATEL3_3);
			}
			else {
				bindEnPlateL3 = true;

				sb.append(_FINDER_COLUMN_ENPLATENO_ENPLATEL3_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(enPlateNo);

				if (bindEnPlateL1) {
					queryPos.add(enPlateL1);
				}

				if (bindEnPlateL2) {
					queryPos.add(enPlateL2);
				}

				if (bindEnPlateL3) {
					queryPos.add(enPlateL3);
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

	private static final String _FINDER_COLUMN_ENPLATENO_ENPLATENO_2 =
		"policyVEH.enPlateNo = ? AND ";

	private static final String _FINDER_COLUMN_ENPLATENO_ENPLATEL1_2 =
		"policyVEH.enPlateL1 = ? AND ";

	private static final String _FINDER_COLUMN_ENPLATENO_ENPLATEL1_3 =
		"(policyVEH.enPlateL1 IS NULL OR policyVEH.enPlateL1 = '') AND ";

	private static final String _FINDER_COLUMN_ENPLATENO_ENPLATEL2_2 =
		"policyVEH.enPlateL2 = ? AND ";

	private static final String _FINDER_COLUMN_ENPLATENO_ENPLATEL2_3 =
		"(policyVEH.enPlateL2 IS NULL OR policyVEH.enPlateL2 = '') AND ";

	private static final String _FINDER_COLUMN_ENPLATENO_ENPLATEL3_2 =
		"policyVEH.enPlateL3 = ?";

	private static final String _FINDER_COLUMN_ENPLATENO_ENPLATEL3_3 =
		"(policyVEH.enPlateL3 IS NULL OR policyVEH.enPlateL3 = '')";

	private FinderPath _finderPathFetchBypolicyNumber;
	private FinderPath _finderPathCountBypolicyNumber;

	/**
	 * Returns the policy veh where policyNo = &#63; or throws a <code>NoSuchPolicyVEHException</code> if it could not be found.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	@Override
	public PolicyVEH findBypolicyNumber(String policyNo)
		throws NoSuchPolicyVEHException {

		PolicyVEH policyVEH = fetchBypolicyNumber(policyNo);

		if (policyVEH == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("policyNo=");
			sb.append(policyNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPolicyVEHException(sb.toString());
		}

		return policyVEH;
	}

	/**
	 * Returns the policy veh where policyNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	@Override
	public PolicyVEH fetchBypolicyNumber(String policyNo) {
		return fetchBypolicyNumber(policyNo, true);
	}

	/**
	 * Returns the policy veh where policyNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyNo the policy no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	@Override
	public PolicyVEH fetchBypolicyNumber(
		String policyNo, boolean useFinderCache) {

		policyNo = Objects.toString(policyNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {policyNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchBypolicyNumber, finderArgs, this);
		}

		if (result instanceof PolicyVEH) {
			PolicyVEH policyVEH = (PolicyVEH)result;

			if (!Objects.equals(policyNo, policyVEH.getPolicyNo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_POLICYVEH_WHERE);

			boolean bindPolicyNo = false;

			if (policyNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYNUMBER_POLICYNO_3);
			}
			else {
				bindPolicyNo = true;

				sb.append(_FINDER_COLUMN_POLICYNUMBER_POLICYNO_2);
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

				List<PolicyVEH> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchBypolicyNumber, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {policyNo};
							}

							_log.warn(
								"PolicyVEHPersistenceImpl.fetchBypolicyNumber(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PolicyVEH policyVEH = list.get(0);

					result = policyVEH;

					cacheResult(policyVEH);
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
			return (PolicyVEH)result;
		}
	}

	/**
	 * Removes the policy veh where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 * @return the policy veh that was removed
	 */
	@Override
	public PolicyVEH removeBypolicyNumber(String policyNo)
		throws NoSuchPolicyVEHException {

		PolicyVEH policyVEH = findBypolicyNumber(policyNo);

		return remove(policyVEH);
	}

	/**
	 * Returns the number of policy vehs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching policy vehs
	 */
	@Override
	public int countBypolicyNumber(String policyNo) {
		policyNo = Objects.toString(policyNo, "");

		FinderPath finderPath = _finderPathCountBypolicyNumber;

		Object[] finderArgs = new Object[] {policyNo};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POLICYVEH_WHERE);

			boolean bindPolicyNo = false;

			if (policyNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYNUMBER_POLICYNO_3);
			}
			else {
				bindPolicyNo = true;

				sb.append(_FINDER_COLUMN_POLICYNUMBER_POLICYNO_2);
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

	private static final String _FINDER_COLUMN_POLICYNUMBER_POLICYNO_2 =
		"policyVEH.id.policyNo = ?";

	private static final String _FINDER_COLUMN_POLICYNUMBER_POLICYNO_3 =
		"(policyVEH.id.policyNo IS NULL OR policyVEH.id.policyNo = '')";

	private FinderPath _finderPathWithPaginationFindByArPlateNo;
	private FinderPath _finderPathWithoutPaginationFindByArPlateNo;
	private FinderPath _finderPathCountByArPlateNo;

	/**
	 * Returns all the policy vehs where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @return the matching policy vehs
	 */
	@Override
	public List<PolicyVEH> findByArPlateNo(
		String arPlateNo, String arPlateL1, String arPlateL2,
		String arPlateL3) {

		return findByArPlateNo(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy vehs where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @return the range of matching policy vehs
	 */
	@Override
	public List<PolicyVEH> findByArPlateNo(
		String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3,
		int start, int end) {

		return findByArPlateNo(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3, start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy vehs where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy vehs
	 */
	@Override
	public List<PolicyVEH> findByArPlateNo(
		String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3,
		int start, int end, OrderByComparator<PolicyVEH> orderByComparator) {

		return findByArPlateNo(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy vehs where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy vehs
	 */
	@Override
	public List<PolicyVEH> findByArPlateNo(
		String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3,
		int start, int end, OrderByComparator<PolicyVEH> orderByComparator,
		boolean useFinderCache) {

		arPlateNo = Objects.toString(arPlateNo, "");
		arPlateL1 = Objects.toString(arPlateL1, "");
		arPlateL2 = Objects.toString(arPlateL2, "");
		arPlateL3 = Objects.toString(arPlateL3, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByArPlateNo;
				finderArgs = new Object[] {
					arPlateNo, arPlateL1, arPlateL2, arPlateL3
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByArPlateNo;
			finderArgs = new Object[] {
				arPlateNo, arPlateL1, arPlateL2, arPlateL3, start, end,
				orderByComparator
			};
		}

		List<PolicyVEH> list = null;

		if (useFinderCache) {
			list = (List<PolicyVEH>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PolicyVEH policyVEH : list) {
					if (!arPlateNo.equals(policyVEH.getArPlateNo()) ||
						!arPlateL1.equals(policyVEH.getArPlateL1()) ||
						!arPlateL2.equals(policyVEH.getArPlateL2()) ||
						!arPlateL3.equals(policyVEH.getArPlateL3())) {

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
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_POLICYVEH_WHERE);

			boolean bindArPlateNo = false;

			if (arPlateNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATENO_3);
			}
			else {
				bindArPlateNo = true;

				sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATENO_2);
			}

			boolean bindArPlateL1 = false;

			if (arPlateL1.isEmpty()) {
				sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATEL1_3);
			}
			else {
				bindArPlateL1 = true;

				sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATEL1_2);
			}

			boolean bindArPlateL2 = false;

			if (arPlateL2.isEmpty()) {
				sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATEL2_3);
			}
			else {
				bindArPlateL2 = true;

				sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATEL2_2);
			}

			boolean bindArPlateL3 = false;

			if (arPlateL3.isEmpty()) {
				sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATEL3_3);
			}
			else {
				bindArPlateL3 = true;

				sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATEL3_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PolicyVEHModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindArPlateNo) {
					queryPos.add(arPlateNo);
				}

				if (bindArPlateL1) {
					queryPos.add(arPlateL1);
				}

				if (bindArPlateL2) {
					queryPos.add(arPlateL2);
				}

				if (bindArPlateL3) {
					queryPos.add(arPlateL3);
				}

				list = (List<PolicyVEH>)QueryUtil.list(
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
	 * Returns the first policy veh in the ordered set where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	@Override
	public PolicyVEH findByArPlateNo_First(
			String arPlateNo, String arPlateL1, String arPlateL2,
			String arPlateL3, OrderByComparator<PolicyVEH> orderByComparator)
		throws NoSuchPolicyVEHException {

		PolicyVEH policyVEH = fetchByArPlateNo_First(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3, orderByComparator);

		if (policyVEH != null) {
			return policyVEH;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("arPlateNo=");
		sb.append(arPlateNo);

		sb.append(", arPlateL1=");
		sb.append(arPlateL1);

		sb.append(", arPlateL2=");
		sb.append(arPlateL2);

		sb.append(", arPlateL3=");
		sb.append(arPlateL3);

		sb.append("}");

		throw new NoSuchPolicyVEHException(sb.toString());
	}

	/**
	 * Returns the first policy veh in the ordered set where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	@Override
	public PolicyVEH fetchByArPlateNo_First(
		String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3,
		OrderByComparator<PolicyVEH> orderByComparator) {

		List<PolicyVEH> list = findByArPlateNo(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last policy veh in the ordered set where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	@Override
	public PolicyVEH findByArPlateNo_Last(
			String arPlateNo, String arPlateL1, String arPlateL2,
			String arPlateL3, OrderByComparator<PolicyVEH> orderByComparator)
		throws NoSuchPolicyVEHException {

		PolicyVEH policyVEH = fetchByArPlateNo_Last(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3, orderByComparator);

		if (policyVEH != null) {
			return policyVEH;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("arPlateNo=");
		sb.append(arPlateNo);

		sb.append(", arPlateL1=");
		sb.append(arPlateL1);

		sb.append(", arPlateL2=");
		sb.append(arPlateL2);

		sb.append(", arPlateL3=");
		sb.append(arPlateL3);

		sb.append("}");

		throw new NoSuchPolicyVEHException(sb.toString());
	}

	/**
	 * Returns the last policy veh in the ordered set where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	@Override
	public PolicyVEH fetchByArPlateNo_Last(
		String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3,
		OrderByComparator<PolicyVEH> orderByComparator) {

		int count = countByArPlateNo(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3);

		if (count == 0) {
			return null;
		}

		List<PolicyVEH> list = findByArPlateNo(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the policy vehs before and after the current policy veh in the ordered set where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * @param policyVEHPK the primary key of the current policy veh
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy veh
	 * @throws NoSuchPolicyVEHException if a policy veh with the primary key could not be found
	 */
	@Override
	public PolicyVEH[] findByArPlateNo_PrevAndNext(
			PolicyVEHPK policyVEHPK, String arPlateNo, String arPlateL1,
			String arPlateL2, String arPlateL3,
			OrderByComparator<PolicyVEH> orderByComparator)
		throws NoSuchPolicyVEHException {

		arPlateNo = Objects.toString(arPlateNo, "");
		arPlateL1 = Objects.toString(arPlateL1, "");
		arPlateL2 = Objects.toString(arPlateL2, "");
		arPlateL3 = Objects.toString(arPlateL3, "");

		PolicyVEH policyVEH = findByPrimaryKey(policyVEHPK);

		Session session = null;

		try {
			session = openSession();

			PolicyVEH[] array = new PolicyVEHImpl[3];

			array[0] = getByArPlateNo_PrevAndNext(
				session, policyVEH, arPlateNo, arPlateL1, arPlateL2, arPlateL3,
				orderByComparator, true);

			array[1] = policyVEH;

			array[2] = getByArPlateNo_PrevAndNext(
				session, policyVEH, arPlateNo, arPlateL1, arPlateL2, arPlateL3,
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

	protected PolicyVEH getByArPlateNo_PrevAndNext(
		Session session, PolicyVEH policyVEH, String arPlateNo,
		String arPlateL1, String arPlateL2, String arPlateL3,
		OrderByComparator<PolicyVEH> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_POLICYVEH_WHERE);

		boolean bindArPlateNo = false;

		if (arPlateNo.isEmpty()) {
			sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATENO_3);
		}
		else {
			bindArPlateNo = true;

			sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATENO_2);
		}

		boolean bindArPlateL1 = false;

		if (arPlateL1.isEmpty()) {
			sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATEL1_3);
		}
		else {
			bindArPlateL1 = true;

			sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATEL1_2);
		}

		boolean bindArPlateL2 = false;

		if (arPlateL2.isEmpty()) {
			sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATEL2_3);
		}
		else {
			bindArPlateL2 = true;

			sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATEL2_2);
		}

		boolean bindArPlateL3 = false;

		if (arPlateL3.isEmpty()) {
			sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATEL3_3);
		}
		else {
			bindArPlateL3 = true;

			sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATEL3_2);
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
			sb.append(PolicyVEHModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindArPlateNo) {
			queryPos.add(arPlateNo);
		}

		if (bindArPlateL1) {
			queryPos.add(arPlateL1);
		}

		if (bindArPlateL2) {
			queryPos.add(arPlateL2);
		}

		if (bindArPlateL3) {
			queryPos.add(arPlateL3);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(policyVEH)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PolicyVEH> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the policy vehs where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63; from the database.
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 */
	@Override
	public void removeByArPlateNo(
		String arPlateNo, String arPlateL1, String arPlateL2,
		String arPlateL3) {

		for (PolicyVEH policyVEH :
				findByArPlateNo(
					arPlateNo, arPlateL1, arPlateL2, arPlateL3,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(policyVEH);
		}
	}

	/**
	 * Returns the number of policy vehs where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @return the number of matching policy vehs
	 */
	@Override
	public int countByArPlateNo(
		String arPlateNo, String arPlateL1, String arPlateL2,
		String arPlateL3) {

		arPlateNo = Objects.toString(arPlateNo, "");
		arPlateL1 = Objects.toString(arPlateL1, "");
		arPlateL2 = Objects.toString(arPlateL2, "");
		arPlateL3 = Objects.toString(arPlateL3, "");

		FinderPath finderPath = _finderPathCountByArPlateNo;

		Object[] finderArgs = new Object[] {
			arPlateNo, arPlateL1, arPlateL2, arPlateL3
		};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_POLICYVEH_WHERE);

			boolean bindArPlateNo = false;

			if (arPlateNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATENO_3);
			}
			else {
				bindArPlateNo = true;

				sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATENO_2);
			}

			boolean bindArPlateL1 = false;

			if (arPlateL1.isEmpty()) {
				sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATEL1_3);
			}
			else {
				bindArPlateL1 = true;

				sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATEL1_2);
			}

			boolean bindArPlateL2 = false;

			if (arPlateL2.isEmpty()) {
				sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATEL2_3);
			}
			else {
				bindArPlateL2 = true;

				sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATEL2_2);
			}

			boolean bindArPlateL3 = false;

			if (arPlateL3.isEmpty()) {
				sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATEL3_3);
			}
			else {
				bindArPlateL3 = true;

				sb.append(_FINDER_COLUMN_ARPLATENO_ARPLATEL3_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindArPlateNo) {
					queryPos.add(arPlateNo);
				}

				if (bindArPlateL1) {
					queryPos.add(arPlateL1);
				}

				if (bindArPlateL2) {
					queryPos.add(arPlateL2);
				}

				if (bindArPlateL3) {
					queryPos.add(arPlateL3);
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

	private static final String _FINDER_COLUMN_ARPLATENO_ARPLATENO_2 =
		"policyVEH.arPlateNo = ? AND ";

	private static final String _FINDER_COLUMN_ARPLATENO_ARPLATENO_3 =
		"(policyVEH.arPlateNo IS NULL OR policyVEH.arPlateNo = '') AND ";

	private static final String _FINDER_COLUMN_ARPLATENO_ARPLATEL1_2 =
		"policyVEH.arPlateL1 = ? AND ";

	private static final String _FINDER_COLUMN_ARPLATENO_ARPLATEL1_3 =
		"(policyVEH.arPlateL1 IS NULL OR policyVEH.arPlateL1 = '') AND ";

	private static final String _FINDER_COLUMN_ARPLATENO_ARPLATEL2_2 =
		"policyVEH.arPlateL2 = ? AND ";

	private static final String _FINDER_COLUMN_ARPLATENO_ARPLATEL2_3 =
		"(policyVEH.arPlateL2 IS NULL OR policyVEH.arPlateL2 = '') AND ";

	private static final String _FINDER_COLUMN_ARPLATENO_ARPLATEL3_2 =
		"policyVEH.arPlateL3 = ?";

	private static final String _FINDER_COLUMN_ARPLATENO_ARPLATEL3_3 =
		"(policyVEH.arPlateL3 IS NULL OR policyVEH.arPlateL3 = '')";

	public PolicyVEHPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("policyNo", "ODS_POLICY_NO");
		dbColumnNames.put("vehId", "ODS_VEH_ID");
		dbColumnNames.put("vehicleDefType", "ODS_VEHICLE_DEF_TYPE");
		dbColumnNames.put("vehicleSeqCustom", "ODS_VEHICLE_SEQ_CUSTOM");
		dbColumnNames.put("chassisNo", "ODS_CHASSIS_NO");
		dbColumnNames.put("bodyType", "ODS_BODY_TYPE");
		dbColumnNames.put("make", "ODS_MAKE");
		dbColumnNames.put("vehModel", "ODS_MODEL");
		dbColumnNames.put("mfgYear", "ODS_MFG_YEAR");
		dbColumnNames.put("color", "ODS_COLOR");
		dbColumnNames.put("agencyRepair", "ODS_AGENCY_REPAIR");
		dbColumnNames.put("noofPassengers", "ODS_NOOF_PASSENGERS");
		dbColumnNames.put("enPlateNo", "ODS_ENG_PLATE_NO");
		dbColumnNames.put("enPlateL1", "ODS_ENG_PLATE_L1");
		dbColumnNames.put("enPlateL2", "ODS_ENG_PLATE_L2");
		dbColumnNames.put("enPlateL3", "ODS_ENG_PLATE_L3");
		dbColumnNames.put("arPlateNo", "ODS_ARB_PLATE_NO");
		dbColumnNames.put("arPlateL1", "ODS_ARB_PLATE_L1");
		dbColumnNames.put("arPlateL2", "ODS_ARB_PLATE_L2");
		dbColumnNames.put("arPlateL3", "ODS_ARB_PLATE_L3");
		dbColumnNames.put("deductible", "ODS_DEDUCTIBLE");
		dbColumnNames.put("vehicleValue", "ODS_VEHICLE_VALUE");
		dbColumnNames.put("premium", "ODS_PREMIUM");
		dbColumnNames.put("discounts", "ODS_DISCOUNTS");
		dbColumnNames.put("loading", "ODS_LOADING");
		dbColumnNames.put("totalPremium", "ODS_TOTAL_PREMIUM");
		dbColumnNames.put("noofClaimFreeYears", "ODS_NOOF_CLAIM_FREE_YEARS");
		dbColumnNames.put("useOfCehicle", "ODS_USEOF_VEHICLE");
		dbColumnNames.put("najmPlateType", "ODS_NAJM_PLATE_TYPE");
		dbColumnNames.put("najmStatus", "ODS_NAJM_STATUS");
		dbColumnNames.put("estemaraExpiryDate", "ODS_ESTEMARA_EXP_DT");
		dbColumnNames.put("geoLocation", "ODS_GEOLOCATION");

		setDBColumnNames(dbColumnNames);

		setModelClass(PolicyVEH.class);

		setModelImplClass(PolicyVEHImpl.class);
		setModelPKClass(PolicyVEHPK.class);
	}

	/**
	 * Caches the policy veh in the entity cache if it is enabled.
	 *
	 * @param policyVEH the policy veh
	 */
	@Override
	public void cacheResult(PolicyVEH policyVEH) {
		dummyEntityCache.putResult(
			PolicyVEHImpl.class, policyVEH.getPrimaryKey(), policyVEH);

		dummyFinderCache.putResult(
			_finderPathFetchBypolicyNumber,
			new Object[] {policyVEH.getPolicyNo()}, policyVEH);
	}

	/**
	 * Caches the policy vehs in the entity cache if it is enabled.
	 *
	 * @param policyVEHs the policy vehs
	 */
	@Override
	public void cacheResult(List<PolicyVEH> policyVEHs) {
		for (PolicyVEH policyVEH : policyVEHs) {
			if (dummyEntityCache.getResult(
					PolicyVEHImpl.class, policyVEH.getPrimaryKey()) == null) {

				cacheResult(policyVEH);
			}
		}
	}

	/**
	 * Clears the cache for all policy vehs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(PolicyVEHImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the policy veh.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PolicyVEH policyVEH) {
		dummyEntityCache.removeResult(PolicyVEHImpl.class, policyVEH);
	}

	@Override
	public void clearCache(List<PolicyVEH> policyVEHs) {
		for (PolicyVEH policyVEH : policyVEHs) {
			dummyEntityCache.removeResult(PolicyVEHImpl.class, policyVEH);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(PolicyVEHImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PolicyVEHModelImpl policyVEHModelImpl) {

		Object[] args = new Object[] {policyVEHModelImpl.getPolicyNo()};

		dummyFinderCache.putResult(
			_finderPathCountBypolicyNumber, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchBypolicyNumber, args, policyVEHModelImpl, false);
	}

	/**
	 * Creates a new policy veh with the primary key. Does not add the policy veh to the database.
	 *
	 * @param policyVEHPK the primary key for the new policy veh
	 * @return the new policy veh
	 */
	@Override
	public PolicyVEH create(PolicyVEHPK policyVEHPK) {
		PolicyVEH policyVEH = new PolicyVEHImpl();

		policyVEH.setNew(true);
		policyVEH.setPrimaryKey(policyVEHPK);

		return policyVEH;
	}

	/**
	 * Removes the policy veh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyVEHPK the primary key of the policy veh
	 * @return the policy veh that was removed
	 * @throws NoSuchPolicyVEHException if a policy veh with the primary key could not be found
	 */
	@Override
	public PolicyVEH remove(PolicyVEHPK policyVEHPK)
		throws NoSuchPolicyVEHException {

		return remove((Serializable)policyVEHPK);
	}

	/**
	 * Removes the policy veh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the policy veh
	 * @return the policy veh that was removed
	 * @throws NoSuchPolicyVEHException if a policy veh with the primary key could not be found
	 */
	@Override
	public PolicyVEH remove(Serializable primaryKey)
		throws NoSuchPolicyVEHException {

		Session session = null;

		try {
			session = openSession();

			PolicyVEH policyVEH = (PolicyVEH)session.get(
				PolicyVEHImpl.class, primaryKey);

			if (policyVEH == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPolicyVEHException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(policyVEH);
		}
		catch (NoSuchPolicyVEHException noSuchEntityException) {
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
	protected PolicyVEH removeImpl(PolicyVEH policyVEH) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(policyVEH)) {
				policyVEH = (PolicyVEH)session.get(
					PolicyVEHImpl.class, policyVEH.getPrimaryKeyObj());
			}

			if (policyVEH != null) {
				session.delete(policyVEH);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (policyVEH != null) {
			clearCache(policyVEH);
		}

		return policyVEH;
	}

	@Override
	public PolicyVEH updateImpl(PolicyVEH policyVEH) {
		boolean isNew = policyVEH.isNew();

		if (!(policyVEH instanceof PolicyVEHModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(policyVEH.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(policyVEH);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in policyVEH proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PolicyVEH implementation " +
					policyVEH.getClass());
		}

		PolicyVEHModelImpl policyVEHModelImpl = (PolicyVEHModelImpl)policyVEH;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(policyVEH);
			}
			else {
				policyVEH = (PolicyVEH)session.merge(policyVEH);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			PolicyVEHImpl.class, policyVEHModelImpl, false, true);

		cacheUniqueFindersCache(policyVEHModelImpl);

		if (isNew) {
			policyVEH.setNew(false);
		}

		policyVEH.resetOriginalValues();

		return policyVEH;
	}

	/**
	 * Returns the policy veh with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the policy veh
	 * @return the policy veh
	 * @throws NoSuchPolicyVEHException if a policy veh with the primary key could not be found
	 */
	@Override
	public PolicyVEH findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPolicyVEHException {

		PolicyVEH policyVEH = fetchByPrimaryKey(primaryKey);

		if (policyVEH == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPolicyVEHException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return policyVEH;
	}

	/**
	 * Returns the policy veh with the primary key or throws a <code>NoSuchPolicyVEHException</code> if it could not be found.
	 *
	 * @param policyVEHPK the primary key of the policy veh
	 * @return the policy veh
	 * @throws NoSuchPolicyVEHException if a policy veh with the primary key could not be found
	 */
	@Override
	public PolicyVEH findByPrimaryKey(PolicyVEHPK policyVEHPK)
		throws NoSuchPolicyVEHException {

		return findByPrimaryKey((Serializable)policyVEHPK);
	}

	/**
	 * Returns the policy veh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyVEHPK the primary key of the policy veh
	 * @return the policy veh, or <code>null</code> if a policy veh with the primary key could not be found
	 */
	@Override
	public PolicyVEH fetchByPrimaryKey(PolicyVEHPK policyVEHPK) {
		return fetchByPrimaryKey((Serializable)policyVEHPK);
	}

	/**
	 * Returns all the policy vehs.
	 *
	 * @return the policy vehs
	 */
	@Override
	public List<PolicyVEH> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy vehs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @return the range of policy vehs
	 */
	@Override
	public List<PolicyVEH> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy vehs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy vehs
	 */
	@Override
	public List<PolicyVEH> findAll(
		int start, int end, OrderByComparator<PolicyVEH> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy vehs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy vehs
	 */
	@Override
	public List<PolicyVEH> findAll(
		int start, int end, OrderByComparator<PolicyVEH> orderByComparator,
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

		List<PolicyVEH> list = null;

		if (useFinderCache) {
			list = (List<PolicyVEH>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_POLICYVEH);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_POLICYVEH;

				sql = sql.concat(PolicyVEHModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PolicyVEH>)QueryUtil.list(
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
	 * Removes all the policy vehs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PolicyVEH policyVEH : findAll()) {
			remove(policyVEH);
		}
	}

	/**
	 * Returns the number of policy vehs.
	 *
	 * @return the number of policy vehs
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_POLICYVEH);

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
		return "policyVEHPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_POLICYVEH;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PolicyVEHModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the policy veh persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PolicyVEHModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PolicyVEH.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByPolicyNoVehicleSeqCustom =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByPolicyNoVehicleSeqCustom",
				new String[] {
					String.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"ODS_POLICY_NO", "ODS_VEHICLE_SEQ_CUSTOM"}, true);

		_finderPathWithoutPaginationFindByPolicyNoVehicleSeqCustom =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByPolicyNoVehicleSeqCustom",
				new String[] {String.class.getName(), String.class.getName()},
				new String[] {"ODS_POLICY_NO", "ODS_VEHICLE_SEQ_CUSTOM"}, true);

		_finderPathCountByPolicyNoVehicleSeqCustom = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPolicyNoVehicleSeqCustom",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"ODS_POLICY_NO", "ODS_VEHICLE_SEQ_CUSTOM"}, false);

		_finderPathWithPaginationFindByVehicleSeqCustom = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVehicleSeqCustom",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"ODS_VEHICLE_SEQ_CUSTOM"}, true);

		_finderPathWithoutPaginationFindByVehicleSeqCustom = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVehicleSeqCustom",
			new String[] {String.class.getName()},
			new String[] {"ODS_VEHICLE_SEQ_CUSTOM"}, true);

		_finderPathCountByVehicleSeqCustom = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVehicleSeqCustom", new String[] {String.class.getName()},
			new String[] {"ODS_VEHICLE_SEQ_CUSTOM"}, false);

		_finderPathWithPaginationFindByEnPlateNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEnPlateNo",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {
				"ODS_ENG_PLATE_NO", "ODS_ENG_PLATE_L1", "ODS_ENG_PLATE_L2",
				"ODS_ENG_PLATE_L3"
			},
			true);

		_finderPathWithoutPaginationFindByEnPlateNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEnPlateNo",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {
				"ODS_ENG_PLATE_NO", "ODS_ENG_PLATE_L1", "ODS_ENG_PLATE_L2",
				"ODS_ENG_PLATE_L3"
			},
			true);

		_finderPathCountByEnPlateNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEnPlateNo",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {
				"ODS_ENG_PLATE_NO", "ODS_ENG_PLATE_L1", "ODS_ENG_PLATE_L2",
				"ODS_ENG_PLATE_L3"
			},
			false);

		_finderPathFetchBypolicyNumber = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBypolicyNumber",
			new String[] {String.class.getName()},
			new String[] {"ODS_POLICY_NO"}, true);

		_finderPathCountBypolicyNumber = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypolicyNumber",
			new String[] {String.class.getName()},
			new String[] {"ODS_POLICY_NO"}, false);

		_finderPathWithPaginationFindByArPlateNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArPlateNo",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {
				"ODS_ARB_PLATE_NO", "ODS_ARB_PLATE_L1", "ODS_ARB_PLATE_L2",
				"ODS_ARB_PLATE_L3"
			},
			true);

		_finderPathWithoutPaginationFindByArPlateNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArPlateNo",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {
				"ODS_ARB_PLATE_NO", "ODS_ARB_PLATE_L1", "ODS_ARB_PLATE_L2",
				"ODS_ARB_PLATE_L3"
			},
			true);

		_finderPathCountByArPlateNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArPlateNo",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {
				"ODS_ARB_PLATE_NO", "ODS_ARB_PLATE_L1", "ODS_ARB_PLATE_L2",
				"ODS_ARB_PLATE_L3"
			},
			false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(PolicyVEHImpl.class.getName());

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

	private static final String _SQL_SELECT_POLICYVEH =
		"SELECT policyVEH FROM PolicyVEH policyVEH";

	private static final String _SQL_SELECT_POLICYVEH_WHERE =
		"SELECT policyVEH FROM PolicyVEH policyVEH WHERE ";

	private static final String _SQL_COUNT_POLICYVEH =
		"SELECT COUNT(policyVEH) FROM PolicyVEH policyVEH";

	private static final String _SQL_COUNT_POLICYVEH_WHERE =
		"SELECT COUNT(policyVEH) FROM PolicyVEH policyVEH WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "policyVEH.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PolicyVEH exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PolicyVEH exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PolicyVEHPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"policyNo", "vehId", "vehicleDefType", "vehicleSeqCustom",
			"chassisNo", "bodyType", "make", "vehModel", "mfgYear", "color",
			"agencyRepair", "noofPassengers", "enPlateNo", "enPlateL1",
			"enPlateL2", "enPlateL3", "arPlateNo", "arPlateL1", "arPlateL2",
			"arPlateL3", "deductible", "vehicleValue", "premium", "discounts",
			"loading", "totalPremium", "noofClaimFreeYears", "useOfCehicle",
			"najmPlateType", "najmStatus", "estemaraExpiryDate", "geoLocation"
		});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"policyNo", "vehId"});

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

	private static class PolicyVEHModelArgumentsResolver
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

			PolicyVEHModelImpl policyVEHModelImpl =
				(PolicyVEHModelImpl)baseModel;

			long columnBitmask = policyVEHModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(policyVEHModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						policyVEHModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(policyVEHModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PolicyVEHModelImpl policyVEHModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = policyVEHModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = policyVEHModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}