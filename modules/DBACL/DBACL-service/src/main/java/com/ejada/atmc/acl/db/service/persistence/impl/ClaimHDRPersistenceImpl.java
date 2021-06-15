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

import com.ejada.atmc.acl.db.exception.NoSuchClaimHDRException;
import com.ejada.atmc.acl.db.model.ClaimHDR;
import com.ejada.atmc.acl.db.model.impl.ClaimHDRImpl;
import com.ejada.atmc.acl.db.model.impl.ClaimHDRModelImpl;
import com.ejada.atmc.acl.db.service.persistence.ClaimHDRPK;
import com.ejada.atmc.acl.db.service.persistence.ClaimHDRPersistence;
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
 * The persistence implementation for the claim hdr service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ClaimHDRPersistence.class)
public class ClaimHDRPersistenceImpl
	extends BasePersistenceImpl<ClaimHDR> implements ClaimHDRPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ClaimHDRUtil</code> to access the claim hdr persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ClaimHDRImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByIqamaId;
	private FinderPath _finderPathWithoutPaginationFindByIqamaId;
	private FinderPath _finderPathCountByIqamaId;

	/**
	 * Returns all the claim hdrs where iqamaId = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @return the matching claim hdrs
	 */
	@Override
	public List<ClaimHDR> findByIqamaId(String iqamaId) {
		return findByIqamaId(
			iqamaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the claim hdrs where iqamaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param iqamaId the iqama ID
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @return the range of matching claim hdrs
	 */
	@Override
	public List<ClaimHDR> findByIqamaId(String iqamaId, int start, int end) {
		return findByIqamaId(iqamaId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the claim hdrs where iqamaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param iqamaId the iqama ID
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim hdrs
	 */
	@Override
	public List<ClaimHDR> findByIqamaId(
		String iqamaId, int start, int end,
		OrderByComparator<ClaimHDR> orderByComparator) {

		return findByIqamaId(iqamaId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claim hdrs where iqamaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param iqamaId the iqama ID
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim hdrs
	 */
	@Override
	public List<ClaimHDR> findByIqamaId(
		String iqamaId, int start, int end,
		OrderByComparator<ClaimHDR> orderByComparator, boolean useFinderCache) {

		iqamaId = Objects.toString(iqamaId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIqamaId;
				finderArgs = new Object[] {iqamaId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIqamaId;
			finderArgs = new Object[] {iqamaId, start, end, orderByComparator};
		}

		List<ClaimHDR> list = null;

		if (useFinderCache) {
			list = (List<ClaimHDR>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClaimHDR claimHDR : list) {
					if (!iqamaId.equals(claimHDR.getIqamaId())) {
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

			sb.append(_SQL_SELECT_CLAIMHDR_WHERE);

			boolean bindIqamaId = false;

			if (iqamaId.isEmpty()) {
				sb.append(_FINDER_COLUMN_IQAMAID_IQAMAID_3);
			}
			else {
				bindIqamaId = true;

				sb.append(_FINDER_COLUMN_IQAMAID_IQAMAID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClaimHDRModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIqamaId) {
					queryPos.add(iqamaId);
				}

				list = (List<ClaimHDR>)QueryUtil.list(
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
	 * Returns the first claim hdr in the ordered set where iqamaId = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim hdr
	 * @throws NoSuchClaimHDRException if a matching claim hdr could not be found
	 */
	@Override
	public ClaimHDR findByIqamaId_First(
			String iqamaId, OrderByComparator<ClaimHDR> orderByComparator)
		throws NoSuchClaimHDRException {

		ClaimHDR claimHDR = fetchByIqamaId_First(iqamaId, orderByComparator);

		if (claimHDR != null) {
			return claimHDR;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("iqamaId=");
		sb.append(iqamaId);

		sb.append("}");

		throw new NoSuchClaimHDRException(sb.toString());
	}

	/**
	 * Returns the first claim hdr in the ordered set where iqamaId = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim hdr, or <code>null</code> if a matching claim hdr could not be found
	 */
	@Override
	public ClaimHDR fetchByIqamaId_First(
		String iqamaId, OrderByComparator<ClaimHDR> orderByComparator) {

		List<ClaimHDR> list = findByIqamaId(iqamaId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last claim hdr in the ordered set where iqamaId = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim hdr
	 * @throws NoSuchClaimHDRException if a matching claim hdr could not be found
	 */
	@Override
	public ClaimHDR findByIqamaId_Last(
			String iqamaId, OrderByComparator<ClaimHDR> orderByComparator)
		throws NoSuchClaimHDRException {

		ClaimHDR claimHDR = fetchByIqamaId_Last(iqamaId, orderByComparator);

		if (claimHDR != null) {
			return claimHDR;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("iqamaId=");
		sb.append(iqamaId);

		sb.append("}");

		throw new NoSuchClaimHDRException(sb.toString());
	}

	/**
	 * Returns the last claim hdr in the ordered set where iqamaId = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim hdr, or <code>null</code> if a matching claim hdr could not be found
	 */
	@Override
	public ClaimHDR fetchByIqamaId_Last(
		String iqamaId, OrderByComparator<ClaimHDR> orderByComparator) {

		int count = countByIqamaId(iqamaId);

		if (count == 0) {
			return null;
		}

		List<ClaimHDR> list = findByIqamaId(
			iqamaId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the claim hdrs before and after the current claim hdr in the ordered set where iqamaId = &#63;.
	 *
	 * @param claimHDRPK the primary key of the current claim hdr
	 * @param iqamaId the iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim hdr
	 * @throws NoSuchClaimHDRException if a claim hdr with the primary key could not be found
	 */
	@Override
	public ClaimHDR[] findByIqamaId_PrevAndNext(
			ClaimHDRPK claimHDRPK, String iqamaId,
			OrderByComparator<ClaimHDR> orderByComparator)
		throws NoSuchClaimHDRException {

		iqamaId = Objects.toString(iqamaId, "");

		ClaimHDR claimHDR = findByPrimaryKey(claimHDRPK);

		Session session = null;

		try {
			session = openSession();

			ClaimHDR[] array = new ClaimHDRImpl[3];

			array[0] = getByIqamaId_PrevAndNext(
				session, claimHDR, iqamaId, orderByComparator, true);

			array[1] = claimHDR;

			array[2] = getByIqamaId_PrevAndNext(
				session, claimHDR, iqamaId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ClaimHDR getByIqamaId_PrevAndNext(
		Session session, ClaimHDR claimHDR, String iqamaId,
		OrderByComparator<ClaimHDR> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLAIMHDR_WHERE);

		boolean bindIqamaId = false;

		if (iqamaId.isEmpty()) {
			sb.append(_FINDER_COLUMN_IQAMAID_IQAMAID_3);
		}
		else {
			bindIqamaId = true;

			sb.append(_FINDER_COLUMN_IQAMAID_IQAMAID_2);
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
			sb.append(ClaimHDRModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindIqamaId) {
			queryPos.add(iqamaId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(claimHDR)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClaimHDR> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the claim hdrs where iqamaId = &#63; from the database.
	 *
	 * @param iqamaId the iqama ID
	 */
	@Override
	public void removeByIqamaId(String iqamaId) {
		for (ClaimHDR claimHDR :
				findByIqamaId(
					iqamaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(claimHDR);
		}
	}

	/**
	 * Returns the number of claim hdrs where iqamaId = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @return the number of matching claim hdrs
	 */
	@Override
	public int countByIqamaId(String iqamaId) {
		iqamaId = Objects.toString(iqamaId, "");

		FinderPath finderPath = _finderPathCountByIqamaId;

		Object[] finderArgs = new Object[] {iqamaId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLAIMHDR_WHERE);

			boolean bindIqamaId = false;

			if (iqamaId.isEmpty()) {
				sb.append(_FINDER_COLUMN_IQAMAID_IQAMAID_3);
			}
			else {
				bindIqamaId = true;

				sb.append(_FINDER_COLUMN_IQAMAID_IQAMAID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIqamaId) {
					queryPos.add(iqamaId);
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

	private static final String _FINDER_COLUMN_IQAMAID_IQAMAID_2 =
		"claimHDR.iqamaId = ?";

	private static final String _FINDER_COLUMN_IQAMAID_IQAMAID_3 =
		"(claimHDR.iqamaId IS NULL OR claimHDR.iqamaId = '')";

	private FinderPath _finderPathWithPaginationFindByclaimNo;
	private FinderPath _finderPathWithoutPaginationFindByclaimNo;
	private FinderPath _finderPathCountByclaimNo;

	/**
	 * Returns all the claim hdrs where claimNo = &#63;.
	 *
	 * @param claimNo the claim no
	 * @return the matching claim hdrs
	 */
	@Override
	public List<ClaimHDR> findByclaimNo(String claimNo) {
		return findByclaimNo(
			claimNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the claim hdrs where claimNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param claimNo the claim no
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @return the range of matching claim hdrs
	 */
	@Override
	public List<ClaimHDR> findByclaimNo(String claimNo, int start, int end) {
		return findByclaimNo(claimNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the claim hdrs where claimNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param claimNo the claim no
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim hdrs
	 */
	@Override
	public List<ClaimHDR> findByclaimNo(
		String claimNo, int start, int end,
		OrderByComparator<ClaimHDR> orderByComparator) {

		return findByclaimNo(claimNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claim hdrs where claimNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param claimNo the claim no
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim hdrs
	 */
	@Override
	public List<ClaimHDR> findByclaimNo(
		String claimNo, int start, int end,
		OrderByComparator<ClaimHDR> orderByComparator, boolean useFinderCache) {

		claimNo = Objects.toString(claimNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByclaimNo;
				finderArgs = new Object[] {claimNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByclaimNo;
			finderArgs = new Object[] {claimNo, start, end, orderByComparator};
		}

		List<ClaimHDR> list = null;

		if (useFinderCache) {
			list = (List<ClaimHDR>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClaimHDR claimHDR : list) {
					if (!claimNo.equals(claimHDR.getClaimNo())) {
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

			sb.append(_SQL_SELECT_CLAIMHDR_WHERE);

			boolean bindClaimNo = false;

			if (claimNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_CLAIMNO_CLAIMNO_3);
			}
			else {
				bindClaimNo = true;

				sb.append(_FINDER_COLUMN_CLAIMNO_CLAIMNO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClaimHDRModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClaimNo) {
					queryPos.add(claimNo);
				}

				list = (List<ClaimHDR>)QueryUtil.list(
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
	 * Returns the first claim hdr in the ordered set where claimNo = &#63;.
	 *
	 * @param claimNo the claim no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim hdr
	 * @throws NoSuchClaimHDRException if a matching claim hdr could not be found
	 */
	@Override
	public ClaimHDR findByclaimNo_First(
			String claimNo, OrderByComparator<ClaimHDR> orderByComparator)
		throws NoSuchClaimHDRException {

		ClaimHDR claimHDR = fetchByclaimNo_First(claimNo, orderByComparator);

		if (claimHDR != null) {
			return claimHDR;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("claimNo=");
		sb.append(claimNo);

		sb.append("}");

		throw new NoSuchClaimHDRException(sb.toString());
	}

	/**
	 * Returns the first claim hdr in the ordered set where claimNo = &#63;.
	 *
	 * @param claimNo the claim no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim hdr, or <code>null</code> if a matching claim hdr could not be found
	 */
	@Override
	public ClaimHDR fetchByclaimNo_First(
		String claimNo, OrderByComparator<ClaimHDR> orderByComparator) {

		List<ClaimHDR> list = findByclaimNo(claimNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last claim hdr in the ordered set where claimNo = &#63;.
	 *
	 * @param claimNo the claim no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim hdr
	 * @throws NoSuchClaimHDRException if a matching claim hdr could not be found
	 */
	@Override
	public ClaimHDR findByclaimNo_Last(
			String claimNo, OrderByComparator<ClaimHDR> orderByComparator)
		throws NoSuchClaimHDRException {

		ClaimHDR claimHDR = fetchByclaimNo_Last(claimNo, orderByComparator);

		if (claimHDR != null) {
			return claimHDR;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("claimNo=");
		sb.append(claimNo);

		sb.append("}");

		throw new NoSuchClaimHDRException(sb.toString());
	}

	/**
	 * Returns the last claim hdr in the ordered set where claimNo = &#63;.
	 *
	 * @param claimNo the claim no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim hdr, or <code>null</code> if a matching claim hdr could not be found
	 */
	@Override
	public ClaimHDR fetchByclaimNo_Last(
		String claimNo, OrderByComparator<ClaimHDR> orderByComparator) {

		int count = countByclaimNo(claimNo);

		if (count == 0) {
			return null;
		}

		List<ClaimHDR> list = findByclaimNo(
			claimNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the claim hdrs before and after the current claim hdr in the ordered set where claimNo = &#63;.
	 *
	 * @param claimHDRPK the primary key of the current claim hdr
	 * @param claimNo the claim no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim hdr
	 * @throws NoSuchClaimHDRException if a claim hdr with the primary key could not be found
	 */
	@Override
	public ClaimHDR[] findByclaimNo_PrevAndNext(
			ClaimHDRPK claimHDRPK, String claimNo,
			OrderByComparator<ClaimHDR> orderByComparator)
		throws NoSuchClaimHDRException {

		claimNo = Objects.toString(claimNo, "");

		ClaimHDR claimHDR = findByPrimaryKey(claimHDRPK);

		Session session = null;

		try {
			session = openSession();

			ClaimHDR[] array = new ClaimHDRImpl[3];

			array[0] = getByclaimNo_PrevAndNext(
				session, claimHDR, claimNo, orderByComparator, true);

			array[1] = claimHDR;

			array[2] = getByclaimNo_PrevAndNext(
				session, claimHDR, claimNo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ClaimHDR getByclaimNo_PrevAndNext(
		Session session, ClaimHDR claimHDR, String claimNo,
		OrderByComparator<ClaimHDR> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLAIMHDR_WHERE);

		boolean bindClaimNo = false;

		if (claimNo.isEmpty()) {
			sb.append(_FINDER_COLUMN_CLAIMNO_CLAIMNO_3);
		}
		else {
			bindClaimNo = true;

			sb.append(_FINDER_COLUMN_CLAIMNO_CLAIMNO_2);
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
			sb.append(ClaimHDRModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindClaimNo) {
			queryPos.add(claimNo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(claimHDR)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClaimHDR> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the claim hdrs where claimNo = &#63; from the database.
	 *
	 * @param claimNo the claim no
	 */
	@Override
	public void removeByclaimNo(String claimNo) {
		for (ClaimHDR claimHDR :
				findByclaimNo(
					claimNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(claimHDR);
		}
	}

	/**
	 * Returns the number of claim hdrs where claimNo = &#63;.
	 *
	 * @param claimNo the claim no
	 * @return the number of matching claim hdrs
	 */
	@Override
	public int countByclaimNo(String claimNo) {
		claimNo = Objects.toString(claimNo, "");

		FinderPath finderPath = _finderPathCountByclaimNo;

		Object[] finderArgs = new Object[] {claimNo};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLAIMHDR_WHERE);

			boolean bindClaimNo = false;

			if (claimNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_CLAIMNO_CLAIMNO_3);
			}
			else {
				bindClaimNo = true;

				sb.append(_FINDER_COLUMN_CLAIMNO_CLAIMNO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClaimNo) {
					queryPos.add(claimNo);
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

	private static final String _FINDER_COLUMN_CLAIMNO_CLAIMNO_2 =
		"claimHDR.id.claimNo = ?";

	private static final String _FINDER_COLUMN_CLAIMNO_CLAIMNO_3 =
		"(claimHDR.id.claimNo IS NULL OR claimHDR.id.claimNo = '')";

	public ClaimHDRPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("policyNo", "ODS_POLICY_NO");
		dbColumnNames.put("claimNo", "ODS_CLAIM_NO");
		dbColumnNames.put("claimStatus", "ODS_CLAIM_STATUS");
		dbColumnNames.put("iqamaId", "ODS_IQAMA_ID");
		dbColumnNames.put("reportType", "ODS_REPORT_TYPE");
		dbColumnNames.put("reportNo", "ODS_REPORT_NO");
		dbColumnNames.put("enPlateNo", "ODS_ENG_PLATE_NO");
		dbColumnNames.put("enPlateL1", "ODS_ENG_PLATE_L1");
		dbColumnNames.put("enPlateL2", "ODS_ENG_PLATE_L2");
		dbColumnNames.put("enPlateL3", "ODS_ENG_PLATE_L3");
		dbColumnNames.put("arPlateNo", "ODS_ARB_PLATE_NO");
		dbColumnNames.put("arPlateL1", "ODS_ARB_PLATE_L1");
		dbColumnNames.put("arPlateL2", "ODS_ARB_PLATE_L2");
		dbColumnNames.put("arPlateL3", "ODS_ARB_PLATE_L3");
		dbColumnNames.put("natureOfLoss", "ODS_NATUREOF_LOSS");
		dbColumnNames.put("causeCode", "ODS_CAUSE_CODE");
		dbColumnNames.put("typeOfClaim", "ODS_TYPEOF_CLAIM");
		dbColumnNames.put("claimLossDate", "ODS_CLAIM_LOSS_DT");
		dbColumnNames.put("lossRemarks", "ODS_LOSS_REMARKS");
		dbColumnNames.put("faultPercent", "ODS_FAULT_PERCENT");
		dbColumnNames.put("lossLocation", "ODS_LOSS_LOCATION");
		dbColumnNames.put("claimAmount", "ODS_CLAIM_AMOUNT");
		dbColumnNames.put("claimIntmDate", "ODS_CLAIM_INTM_DT");
		dbColumnNames.put("claimSetlDate", "ODS_CLAIM_SETL_DT");
		dbColumnNames.put("claimantName", "ODS_CLAIMANT_NAME");
		dbColumnNames.put("driverName", "ODS_DRIVER_NAME");
		dbColumnNames.put("claimantPhone", "ODS_CLAIMANT_PHONE");
		dbColumnNames.put("iban", "ODS_IBAN");
		dbColumnNames.put("tpDriverName", "ODS_TP_DRIVER_NAME");
		dbColumnNames.put("tpAge", "ODS_TP_AGE");
		dbColumnNames.put("tpID", "ODS_TP_ID");
		dbColumnNames.put("tpPlateNo", "ODS_TP_PLATE_NO");
		dbColumnNames.put("tpPlateL1", "ODS_TP_PLATE_L1");
		dbColumnNames.put("tpPlateL2", "ODS_TP_PLATE_L2");
		dbColumnNames.put("tpPlateL3", "ODS_TP_PLATE_L3");
		dbColumnNames.put("tpInsuranceCo", "ODS_TP_INSURANCE_CO");
		dbColumnNames.put("tpMobileNo", "ODS_TP_MOBILE_NO");
		dbColumnNames.put("tpNationality", "ODS_TP_NATIONALITY");
		dbColumnNames.put("tpIban", "ODS_TP_IBAN");
		dbColumnNames.put("prodCode", "ODS_PROD_CODE");

		setDBColumnNames(dbColumnNames);

		setModelClass(ClaimHDR.class);

		setModelImplClass(ClaimHDRImpl.class);
		setModelPKClass(ClaimHDRPK.class);
	}

	/**
	 * Caches the claim hdr in the entity cache if it is enabled.
	 *
	 * @param claimHDR the claim hdr
	 */
	@Override
	public void cacheResult(ClaimHDR claimHDR) {
		dummyEntityCache.putResult(
			ClaimHDRImpl.class, claimHDR.getPrimaryKey(), claimHDR);
	}

	/**
	 * Caches the claim hdrs in the entity cache if it is enabled.
	 *
	 * @param claimHDRs the claim hdrs
	 */
	@Override
	public void cacheResult(List<ClaimHDR> claimHDRs) {
		for (ClaimHDR claimHDR : claimHDRs) {
			if (dummyEntityCache.getResult(
					ClaimHDRImpl.class, claimHDR.getPrimaryKey()) == null) {

				cacheResult(claimHDR);
			}
		}
	}

	/**
	 * Clears the cache for all claim hdrs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(ClaimHDRImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the claim hdr.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ClaimHDR claimHDR) {
		dummyEntityCache.removeResult(ClaimHDRImpl.class, claimHDR);
	}

	@Override
	public void clearCache(List<ClaimHDR> claimHDRs) {
		for (ClaimHDR claimHDR : claimHDRs) {
			dummyEntityCache.removeResult(ClaimHDRImpl.class, claimHDR);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(ClaimHDRImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new claim hdr with the primary key. Does not add the claim hdr to the database.
	 *
	 * @param claimHDRPK the primary key for the new claim hdr
	 * @return the new claim hdr
	 */
	@Override
	public ClaimHDR create(ClaimHDRPK claimHDRPK) {
		ClaimHDR claimHDR = new ClaimHDRImpl();

		claimHDR.setNew(true);
		claimHDR.setPrimaryKey(claimHDRPK);

		return claimHDR;
	}

	/**
	 * Removes the claim hdr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimHDRPK the primary key of the claim hdr
	 * @return the claim hdr that was removed
	 * @throws NoSuchClaimHDRException if a claim hdr with the primary key could not be found
	 */
	@Override
	public ClaimHDR remove(ClaimHDRPK claimHDRPK)
		throws NoSuchClaimHDRException {

		return remove((Serializable)claimHDRPK);
	}

	/**
	 * Removes the claim hdr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the claim hdr
	 * @return the claim hdr that was removed
	 * @throws NoSuchClaimHDRException if a claim hdr with the primary key could not be found
	 */
	@Override
	public ClaimHDR remove(Serializable primaryKey)
		throws NoSuchClaimHDRException {

		Session session = null;

		try {
			session = openSession();

			ClaimHDR claimHDR = (ClaimHDR)session.get(
				ClaimHDRImpl.class, primaryKey);

			if (claimHDR == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClaimHDRException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(claimHDR);
		}
		catch (NoSuchClaimHDRException noSuchEntityException) {
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
	protected ClaimHDR removeImpl(ClaimHDR claimHDR) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(claimHDR)) {
				claimHDR = (ClaimHDR)session.get(
					ClaimHDRImpl.class, claimHDR.getPrimaryKeyObj());
			}

			if (claimHDR != null) {
				session.delete(claimHDR);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (claimHDR != null) {
			clearCache(claimHDR);
		}

		return claimHDR;
	}

	@Override
	public ClaimHDR updateImpl(ClaimHDR claimHDR) {
		boolean isNew = claimHDR.isNew();

		if (!(claimHDR instanceof ClaimHDRModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(claimHDR.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(claimHDR);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in claimHDR proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ClaimHDR implementation " +
					claimHDR.getClass());
		}

		ClaimHDRModelImpl claimHDRModelImpl = (ClaimHDRModelImpl)claimHDR;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(claimHDR);
			}
			else {
				claimHDR = (ClaimHDR)session.merge(claimHDR);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			ClaimHDRImpl.class, claimHDRModelImpl, false, true);

		if (isNew) {
			claimHDR.setNew(false);
		}

		claimHDR.resetOriginalValues();

		return claimHDR;
	}

	/**
	 * Returns the claim hdr with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the claim hdr
	 * @return the claim hdr
	 * @throws NoSuchClaimHDRException if a claim hdr with the primary key could not be found
	 */
	@Override
	public ClaimHDR findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClaimHDRException {

		ClaimHDR claimHDR = fetchByPrimaryKey(primaryKey);

		if (claimHDR == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClaimHDRException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return claimHDR;
	}

	/**
	 * Returns the claim hdr with the primary key or throws a <code>NoSuchClaimHDRException</code> if it could not be found.
	 *
	 * @param claimHDRPK the primary key of the claim hdr
	 * @return the claim hdr
	 * @throws NoSuchClaimHDRException if a claim hdr with the primary key could not be found
	 */
	@Override
	public ClaimHDR findByPrimaryKey(ClaimHDRPK claimHDRPK)
		throws NoSuchClaimHDRException {

		return findByPrimaryKey((Serializable)claimHDRPK);
	}

	/**
	 * Returns the claim hdr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimHDRPK the primary key of the claim hdr
	 * @return the claim hdr, or <code>null</code> if a claim hdr with the primary key could not be found
	 */
	@Override
	public ClaimHDR fetchByPrimaryKey(ClaimHDRPK claimHDRPK) {
		return fetchByPrimaryKey((Serializable)claimHDRPK);
	}

	/**
	 * Returns all the claim hdrs.
	 *
	 * @return the claim hdrs
	 */
	@Override
	public List<ClaimHDR> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the claim hdrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @return the range of claim hdrs
	 */
	@Override
	public List<ClaimHDR> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the claim hdrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of claim hdrs
	 */
	@Override
	public List<ClaimHDR> findAll(
		int start, int end, OrderByComparator<ClaimHDR> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claim hdrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of claim hdrs
	 */
	@Override
	public List<ClaimHDR> findAll(
		int start, int end, OrderByComparator<ClaimHDR> orderByComparator,
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

		List<ClaimHDR> list = null;

		if (useFinderCache) {
			list = (List<ClaimHDR>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CLAIMHDR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CLAIMHDR;

				sql = sql.concat(ClaimHDRModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ClaimHDR>)QueryUtil.list(
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
	 * Removes all the claim hdrs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ClaimHDR claimHDR : findAll()) {
			remove(claimHDR);
		}
	}

	/**
	 * Returns the number of claim hdrs.
	 *
	 * @return the number of claim hdrs
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CLAIMHDR);

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
		return "claimHDRPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLAIMHDR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ClaimHDRModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the claim hdr persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ClaimHDRModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ClaimHDR.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByIqamaId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIqamaId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"ODS_IQAMA_ID"}, true);

		_finderPathWithoutPaginationFindByIqamaId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIqamaId",
			new String[] {String.class.getName()},
			new String[] {"ODS_IQAMA_ID"}, true);

		_finderPathCountByIqamaId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIqamaId",
			new String[] {String.class.getName()},
			new String[] {"ODS_IQAMA_ID"}, false);

		_finderPathWithPaginationFindByclaimNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByclaimNo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"ODS_CLAIM_NO"}, true);

		_finderPathWithoutPaginationFindByclaimNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByclaimNo",
			new String[] {String.class.getName()},
			new String[] {"ODS_CLAIM_NO"}, true);

		_finderPathCountByclaimNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByclaimNo",
			new String[] {String.class.getName()},
			new String[] {"ODS_CLAIM_NO"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(ClaimHDRImpl.class.getName());

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

	private static final String _SQL_SELECT_CLAIMHDR =
		"SELECT claimHDR FROM ClaimHDR claimHDR";

	private static final String _SQL_SELECT_CLAIMHDR_WHERE =
		"SELECT claimHDR FROM ClaimHDR claimHDR WHERE ";

	private static final String _SQL_COUNT_CLAIMHDR =
		"SELECT COUNT(claimHDR) FROM ClaimHDR claimHDR";

	private static final String _SQL_COUNT_CLAIMHDR_WHERE =
		"SELECT COUNT(claimHDR) FROM ClaimHDR claimHDR WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "claimHDR.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ClaimHDR exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ClaimHDR exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ClaimHDRPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"policyNo", "claimNo", "claimStatus", "iqamaId", "reportType",
			"reportNo", "enPlateNo", "enPlateL1", "enPlateL2", "enPlateL3",
			"arPlateNo", "arPlateL1", "arPlateL2", "arPlateL3", "natureOfLoss",
			"causeCode", "typeOfClaim", "claimLossDate", "lossRemarks",
			"faultPercent", "lossLocation", "claimAmount", "claimIntmDate",
			"claimSetlDate", "claimantName", "driverName", "claimantPhone",
			"iban", "tpDriverName", "tpAge", "tpID", "tpPlateNo", "tpPlateL1",
			"tpPlateL2", "tpPlateL3", "tpInsuranceCo", "tpMobileNo",
			"tpNationality", "tpIban", "prodCode"
		});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"policyNo", "claimNo"});

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

	private static class ClaimHDRModelArgumentsResolver
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

			ClaimHDRModelImpl claimHDRModelImpl = (ClaimHDRModelImpl)baseModel;

			long columnBitmask = claimHDRModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(claimHDRModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						claimHDRModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(claimHDRModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ClaimHDRModelImpl claimHDRModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = claimHDRModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = claimHDRModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}