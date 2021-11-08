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

import com.ejada.atmc.acl.db.exception.NoSuchClaimIntimationMtrException;
import com.ejada.atmc.acl.db.model.ClaimIntimationMtr;
import com.ejada.atmc.acl.db.model.impl.ClaimIntimationMtrImpl;
import com.ejada.atmc.acl.db.model.impl.ClaimIntimationMtrModelImpl;
import com.ejada.atmc.acl.db.service.persistence.ClaimIntimationMtrPersistence;
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
 * The persistence implementation for the claim intimation mtr service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ClaimIntimationMtrPersistence.class)
public class ClaimIntimationMtrPersistenceImpl
	extends BasePersistenceImpl<ClaimIntimationMtr>
	implements ClaimIntimationMtrPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ClaimIntimationMtrUtil</code> to access the claim intimation mtr persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ClaimIntimationMtrImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByintimationReferenceNo;
	private FinderPath _finderPathWithoutPaginationFindByintimationReferenceNo;
	private FinderPath _finderPathCountByintimationReferenceNo;

	/**
	 * Returns all the claim intimation mtrs where intimationReferenceNo = &#63;.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @return the matching claim intimation mtrs
	 */
	@Override
	public List<ClaimIntimationMtr> findByintimationReferenceNo(
		String intimationReferenceNo) {

		return findByintimationReferenceNo(
			intimationReferenceNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the claim intimation mtrs where intimationReferenceNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @return the range of matching claim intimation mtrs
	 */
	@Override
	public List<ClaimIntimationMtr> findByintimationReferenceNo(
		String intimationReferenceNo, int start, int end) {

		return findByintimationReferenceNo(
			intimationReferenceNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the claim intimation mtrs where intimationReferenceNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim intimation mtrs
	 */
	@Override
	public List<ClaimIntimationMtr> findByintimationReferenceNo(
		String intimationReferenceNo, int start, int end,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		return findByintimationReferenceNo(
			intimationReferenceNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claim intimation mtrs where intimationReferenceNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim intimation mtrs
	 */
	@Override
	public List<ClaimIntimationMtr> findByintimationReferenceNo(
		String intimationReferenceNo, int start, int end,
		OrderByComparator<ClaimIntimationMtr> orderByComparator,
		boolean useFinderCache) {

		intimationReferenceNo = Objects.toString(intimationReferenceNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByintimationReferenceNo;
				finderArgs = new Object[] {intimationReferenceNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByintimationReferenceNo;
			finderArgs = new Object[] {
				intimationReferenceNo, start, end, orderByComparator
			};
		}

		List<ClaimIntimationMtr> list = null;

		if (useFinderCache) {
			list = (List<ClaimIntimationMtr>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClaimIntimationMtr claimIntimationMtr : list) {
					if (!intimationReferenceNo.equals(
							claimIntimationMtr.getIntimationReferenceNo())) {

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

			sb.append(_SQL_SELECT_CLAIMINTIMATIONMTR_WHERE);

			boolean bindIntimationReferenceNo = false;

			if (intimationReferenceNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_INTIMATIONREFERENCENO_INTIMATIONREFERENCENO_3);
			}
			else {
				bindIntimationReferenceNo = true;

				sb.append(
					_FINDER_COLUMN_INTIMATIONREFERENCENO_INTIMATIONREFERENCENO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClaimIntimationMtrModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIntimationReferenceNo) {
					queryPos.add(intimationReferenceNo);
				}

				list = (List<ClaimIntimationMtr>)QueryUtil.list(
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
	 * Returns the first claim intimation mtr in the ordered set where intimationReferenceNo = &#63;.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a matching claim intimation mtr could not be found
	 */
	@Override
	public ClaimIntimationMtr findByintimationReferenceNo_First(
			String intimationReferenceNo,
			OrderByComparator<ClaimIntimationMtr> orderByComparator)
		throws NoSuchClaimIntimationMtrException {

		ClaimIntimationMtr claimIntimationMtr =
			fetchByintimationReferenceNo_First(
				intimationReferenceNo, orderByComparator);

		if (claimIntimationMtr != null) {
			return claimIntimationMtr;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("intimationReferenceNo=");
		sb.append(intimationReferenceNo);

		sb.append("}");

		throw new NoSuchClaimIntimationMtrException(sb.toString());
	}

	/**
	 * Returns the first claim intimation mtr in the ordered set where intimationReferenceNo = &#63;.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim intimation mtr, or <code>null</code> if a matching claim intimation mtr could not be found
	 */
	@Override
	public ClaimIntimationMtr fetchByintimationReferenceNo_First(
		String intimationReferenceNo,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		List<ClaimIntimationMtr> list = findByintimationReferenceNo(
			intimationReferenceNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last claim intimation mtr in the ordered set where intimationReferenceNo = &#63;.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a matching claim intimation mtr could not be found
	 */
	@Override
	public ClaimIntimationMtr findByintimationReferenceNo_Last(
			String intimationReferenceNo,
			OrderByComparator<ClaimIntimationMtr> orderByComparator)
		throws NoSuchClaimIntimationMtrException {

		ClaimIntimationMtr claimIntimationMtr =
			fetchByintimationReferenceNo_Last(
				intimationReferenceNo, orderByComparator);

		if (claimIntimationMtr != null) {
			return claimIntimationMtr;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("intimationReferenceNo=");
		sb.append(intimationReferenceNo);

		sb.append("}");

		throw new NoSuchClaimIntimationMtrException(sb.toString());
	}

	/**
	 * Returns the last claim intimation mtr in the ordered set where intimationReferenceNo = &#63;.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim intimation mtr, or <code>null</code> if a matching claim intimation mtr could not be found
	 */
	@Override
	public ClaimIntimationMtr fetchByintimationReferenceNo_Last(
		String intimationReferenceNo,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		int count = countByintimationReferenceNo(intimationReferenceNo);

		if (count == 0) {
			return null;
		}

		List<ClaimIntimationMtr> list = findByintimationReferenceNo(
			intimationReferenceNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the claim intimation mtrs before and after the current claim intimation mtr in the ordered set where intimationReferenceNo = &#63;.
	 *
	 * @param claimIntimationMotorId the primary key of the current claim intimation mtr
	 * @param intimationReferenceNo the intimation reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a claim intimation mtr with the primary key could not be found
	 */
	@Override
	public ClaimIntimationMtr[] findByintimationReferenceNo_PrevAndNext(
			long claimIntimationMotorId, String intimationReferenceNo,
			OrderByComparator<ClaimIntimationMtr> orderByComparator)
		throws NoSuchClaimIntimationMtrException {

		intimationReferenceNo = Objects.toString(intimationReferenceNo, "");

		ClaimIntimationMtr claimIntimationMtr = findByPrimaryKey(
			claimIntimationMotorId);

		Session session = null;

		try {
			session = openSession();

			ClaimIntimationMtr[] array = new ClaimIntimationMtrImpl[3];

			array[0] = getByintimationReferenceNo_PrevAndNext(
				session, claimIntimationMtr, intimationReferenceNo,
				orderByComparator, true);

			array[1] = claimIntimationMtr;

			array[2] = getByintimationReferenceNo_PrevAndNext(
				session, claimIntimationMtr, intimationReferenceNo,
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

	protected ClaimIntimationMtr getByintimationReferenceNo_PrevAndNext(
		Session session, ClaimIntimationMtr claimIntimationMtr,
		String intimationReferenceNo,
		OrderByComparator<ClaimIntimationMtr> orderByComparator,
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

		sb.append(_SQL_SELECT_CLAIMINTIMATIONMTR_WHERE);

		boolean bindIntimationReferenceNo = false;

		if (intimationReferenceNo.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_INTIMATIONREFERENCENO_INTIMATIONREFERENCENO_3);
		}
		else {
			bindIntimationReferenceNo = true;

			sb.append(
				_FINDER_COLUMN_INTIMATIONREFERENCENO_INTIMATIONREFERENCENO_2);
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
			sb.append(ClaimIntimationMtrModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindIntimationReferenceNo) {
			queryPos.add(intimationReferenceNo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						claimIntimationMtr)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClaimIntimationMtr> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the claim intimation mtrs where intimationReferenceNo = &#63; from the database.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 */
	@Override
	public void removeByintimationReferenceNo(String intimationReferenceNo) {
		for (ClaimIntimationMtr claimIntimationMtr :
				findByintimationReferenceNo(
					intimationReferenceNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(claimIntimationMtr);
		}
	}

	/**
	 * Returns the number of claim intimation mtrs where intimationReferenceNo = &#63;.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @return the number of matching claim intimation mtrs
	 */
	@Override
	public int countByintimationReferenceNo(String intimationReferenceNo) {
		intimationReferenceNo = Objects.toString(intimationReferenceNo, "");

		FinderPath finderPath = _finderPathCountByintimationReferenceNo;

		Object[] finderArgs = new Object[] {intimationReferenceNo};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLAIMINTIMATIONMTR_WHERE);

			boolean bindIntimationReferenceNo = false;

			if (intimationReferenceNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_INTIMATIONREFERENCENO_INTIMATIONREFERENCENO_3);
			}
			else {
				bindIntimationReferenceNo = true;

				sb.append(
					_FINDER_COLUMN_INTIMATIONREFERENCENO_INTIMATIONREFERENCENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIntimationReferenceNo) {
					queryPos.add(intimationReferenceNo);
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
		_FINDER_COLUMN_INTIMATIONREFERENCENO_INTIMATIONREFERENCENO_2 =
			"claimIntimationMtr.intimationReferenceNo = ?";

	private static final String
		_FINDER_COLUMN_INTIMATIONREFERENCENO_INTIMATIONREFERENCENO_3 =
			"(claimIntimationMtr.intimationReferenceNo IS NULL OR claimIntimationMtr.intimationReferenceNo = '')";

	private FinderPath _finderPathWithPaginationFindBymobileNo;
	private FinderPath _finderPathWithoutPaginationFindBymobileNo;
	private FinderPath _finderPathCountBymobileNo;

	/**
	 * Returns all the claim intimation mtrs where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the matching claim intimation mtrs
	 */
	@Override
	public List<ClaimIntimationMtr> findBymobileNo(String mobileNo) {
		return findBymobileNo(
			mobileNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the claim intimation mtrs where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @return the range of matching claim intimation mtrs
	 */
	@Override
	public List<ClaimIntimationMtr> findBymobileNo(
		String mobileNo, int start, int end) {

		return findBymobileNo(mobileNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the claim intimation mtrs where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim intimation mtrs
	 */
	@Override
	public List<ClaimIntimationMtr> findBymobileNo(
		String mobileNo, int start, int end,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		return findBymobileNo(mobileNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claim intimation mtrs where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim intimation mtrs
	 */
	@Override
	public List<ClaimIntimationMtr> findBymobileNo(
		String mobileNo, int start, int end,
		OrderByComparator<ClaimIntimationMtr> orderByComparator,
		boolean useFinderCache) {

		mobileNo = Objects.toString(mobileNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBymobileNo;
				finderArgs = new Object[] {mobileNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBymobileNo;
			finderArgs = new Object[] {mobileNo, start, end, orderByComparator};
		}

		List<ClaimIntimationMtr> list = null;

		if (useFinderCache) {
			list = (List<ClaimIntimationMtr>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClaimIntimationMtr claimIntimationMtr : list) {
					if (!mobileNo.equals(claimIntimationMtr.getMobileNo())) {
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

			sb.append(_SQL_SELECT_CLAIMINTIMATIONMTR_WHERE);

			boolean bindMobileNo = false;

			if (mobileNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_MOBILENO_MOBILENO_3);
			}
			else {
				bindMobileNo = true;

				sb.append(_FINDER_COLUMN_MOBILENO_MOBILENO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClaimIntimationMtrModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMobileNo) {
					queryPos.add(mobileNo);
				}

				list = (List<ClaimIntimationMtr>)QueryUtil.list(
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
	 * Returns the first claim intimation mtr in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a matching claim intimation mtr could not be found
	 */
	@Override
	public ClaimIntimationMtr findBymobileNo_First(
			String mobileNo,
			OrderByComparator<ClaimIntimationMtr> orderByComparator)
		throws NoSuchClaimIntimationMtrException {

		ClaimIntimationMtr claimIntimationMtr = fetchBymobileNo_First(
			mobileNo, orderByComparator);

		if (claimIntimationMtr != null) {
			return claimIntimationMtr;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mobileNo=");
		sb.append(mobileNo);

		sb.append("}");

		throw new NoSuchClaimIntimationMtrException(sb.toString());
	}

	/**
	 * Returns the first claim intimation mtr in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim intimation mtr, or <code>null</code> if a matching claim intimation mtr could not be found
	 */
	@Override
	public ClaimIntimationMtr fetchBymobileNo_First(
		String mobileNo,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		List<ClaimIntimationMtr> list = findBymobileNo(
			mobileNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last claim intimation mtr in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a matching claim intimation mtr could not be found
	 */
	@Override
	public ClaimIntimationMtr findBymobileNo_Last(
			String mobileNo,
			OrderByComparator<ClaimIntimationMtr> orderByComparator)
		throws NoSuchClaimIntimationMtrException {

		ClaimIntimationMtr claimIntimationMtr = fetchBymobileNo_Last(
			mobileNo, orderByComparator);

		if (claimIntimationMtr != null) {
			return claimIntimationMtr;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mobileNo=");
		sb.append(mobileNo);

		sb.append("}");

		throw new NoSuchClaimIntimationMtrException(sb.toString());
	}

	/**
	 * Returns the last claim intimation mtr in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim intimation mtr, or <code>null</code> if a matching claim intimation mtr could not be found
	 */
	@Override
	public ClaimIntimationMtr fetchBymobileNo_Last(
		String mobileNo,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		int count = countBymobileNo(mobileNo);

		if (count == 0) {
			return null;
		}

		List<ClaimIntimationMtr> list = findBymobileNo(
			mobileNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the claim intimation mtrs before and after the current claim intimation mtr in the ordered set where mobileNo = &#63;.
	 *
	 * @param claimIntimationMotorId the primary key of the current claim intimation mtr
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a claim intimation mtr with the primary key could not be found
	 */
	@Override
	public ClaimIntimationMtr[] findBymobileNo_PrevAndNext(
			long claimIntimationMotorId, String mobileNo,
			OrderByComparator<ClaimIntimationMtr> orderByComparator)
		throws NoSuchClaimIntimationMtrException {

		mobileNo = Objects.toString(mobileNo, "");

		ClaimIntimationMtr claimIntimationMtr = findByPrimaryKey(
			claimIntimationMotorId);

		Session session = null;

		try {
			session = openSession();

			ClaimIntimationMtr[] array = new ClaimIntimationMtrImpl[3];

			array[0] = getBymobileNo_PrevAndNext(
				session, claimIntimationMtr, mobileNo, orderByComparator, true);

			array[1] = claimIntimationMtr;

			array[2] = getBymobileNo_PrevAndNext(
				session, claimIntimationMtr, mobileNo, orderByComparator,
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

	protected ClaimIntimationMtr getBymobileNo_PrevAndNext(
		Session session, ClaimIntimationMtr claimIntimationMtr, String mobileNo,
		OrderByComparator<ClaimIntimationMtr> orderByComparator,
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

		sb.append(_SQL_SELECT_CLAIMINTIMATIONMTR_WHERE);

		boolean bindMobileNo = false;

		if (mobileNo.isEmpty()) {
			sb.append(_FINDER_COLUMN_MOBILENO_MOBILENO_3);
		}
		else {
			bindMobileNo = true;

			sb.append(_FINDER_COLUMN_MOBILENO_MOBILENO_2);
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
			sb.append(ClaimIntimationMtrModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindMobileNo) {
			queryPos.add(mobileNo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						claimIntimationMtr)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClaimIntimationMtr> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the claim intimation mtrs where mobileNo = &#63; from the database.
	 *
	 * @param mobileNo the mobile no
	 */
	@Override
	public void removeBymobileNo(String mobileNo) {
		for (ClaimIntimationMtr claimIntimationMtr :
				findBymobileNo(
					mobileNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(claimIntimationMtr);
		}
	}

	/**
	 * Returns the number of claim intimation mtrs where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the number of matching claim intimation mtrs
	 */
	@Override
	public int countBymobileNo(String mobileNo) {
		mobileNo = Objects.toString(mobileNo, "");

		FinderPath finderPath = _finderPathCountBymobileNo;

		Object[] finderArgs = new Object[] {mobileNo};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLAIMINTIMATIONMTR_WHERE);

			boolean bindMobileNo = false;

			if (mobileNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_MOBILENO_MOBILENO_3);
			}
			else {
				bindMobileNo = true;

				sb.append(_FINDER_COLUMN_MOBILENO_MOBILENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMobileNo) {
					queryPos.add(mobileNo);
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

	private static final String _FINDER_COLUMN_MOBILENO_MOBILENO_2 =
		"claimIntimationMtr.mobileNo = ?";

	private static final String _FINDER_COLUMN_MOBILENO_MOBILENO_3 =
		"(claimIntimationMtr.mobileNo IS NULL OR claimIntimationMtr.mobileNo = '')";

	private FinderPath _finderPathWithPaginationFindBydriverNationalId;
	private FinderPath _finderPathWithoutPaginationFindBydriverNationalId;
	private FinderPath _finderPathCountBydriverNationalId;

	/**
	 * Returns all the claim intimation mtrs where driverNationalId = &#63;.
	 *
	 * @param driverNationalId the driver national ID
	 * @return the matching claim intimation mtrs
	 */
	@Override
	public List<ClaimIntimationMtr> findBydriverNationalId(
		long driverNationalId) {

		return findBydriverNationalId(
			driverNationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the claim intimation mtrs where driverNationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param driverNationalId the driver national ID
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @return the range of matching claim intimation mtrs
	 */
	@Override
	public List<ClaimIntimationMtr> findBydriverNationalId(
		long driverNationalId, int start, int end) {

		return findBydriverNationalId(driverNationalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the claim intimation mtrs where driverNationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param driverNationalId the driver national ID
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim intimation mtrs
	 */
	@Override
	public List<ClaimIntimationMtr> findBydriverNationalId(
		long driverNationalId, int start, int end,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		return findBydriverNationalId(
			driverNationalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claim intimation mtrs where driverNationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param driverNationalId the driver national ID
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim intimation mtrs
	 */
	@Override
	public List<ClaimIntimationMtr> findBydriverNationalId(
		long driverNationalId, int start, int end,
		OrderByComparator<ClaimIntimationMtr> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBydriverNationalId;
				finderArgs = new Object[] {driverNationalId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydriverNationalId;
			finderArgs = new Object[] {
				driverNationalId, start, end, orderByComparator
			};
		}

		List<ClaimIntimationMtr> list = null;

		if (useFinderCache) {
			list = (List<ClaimIntimationMtr>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClaimIntimationMtr claimIntimationMtr : list) {
					if (driverNationalId !=
							claimIntimationMtr.getDriverNationalId()) {

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

			sb.append(_SQL_SELECT_CLAIMINTIMATIONMTR_WHERE);

			sb.append(_FINDER_COLUMN_DRIVERNATIONALID_DRIVERNATIONALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClaimIntimationMtrModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(driverNationalId);

				list = (List<ClaimIntimationMtr>)QueryUtil.list(
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
	 * Returns the first claim intimation mtr in the ordered set where driverNationalId = &#63;.
	 *
	 * @param driverNationalId the driver national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a matching claim intimation mtr could not be found
	 */
	@Override
	public ClaimIntimationMtr findBydriverNationalId_First(
			long driverNationalId,
			OrderByComparator<ClaimIntimationMtr> orderByComparator)
		throws NoSuchClaimIntimationMtrException {

		ClaimIntimationMtr claimIntimationMtr = fetchBydriverNationalId_First(
			driverNationalId, orderByComparator);

		if (claimIntimationMtr != null) {
			return claimIntimationMtr;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("driverNationalId=");
		sb.append(driverNationalId);

		sb.append("}");

		throw new NoSuchClaimIntimationMtrException(sb.toString());
	}

	/**
	 * Returns the first claim intimation mtr in the ordered set where driverNationalId = &#63;.
	 *
	 * @param driverNationalId the driver national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim intimation mtr, or <code>null</code> if a matching claim intimation mtr could not be found
	 */
	@Override
	public ClaimIntimationMtr fetchBydriverNationalId_First(
		long driverNationalId,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		List<ClaimIntimationMtr> list = findBydriverNationalId(
			driverNationalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last claim intimation mtr in the ordered set where driverNationalId = &#63;.
	 *
	 * @param driverNationalId the driver national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a matching claim intimation mtr could not be found
	 */
	@Override
	public ClaimIntimationMtr findBydriverNationalId_Last(
			long driverNationalId,
			OrderByComparator<ClaimIntimationMtr> orderByComparator)
		throws NoSuchClaimIntimationMtrException {

		ClaimIntimationMtr claimIntimationMtr = fetchBydriverNationalId_Last(
			driverNationalId, orderByComparator);

		if (claimIntimationMtr != null) {
			return claimIntimationMtr;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("driverNationalId=");
		sb.append(driverNationalId);

		sb.append("}");

		throw new NoSuchClaimIntimationMtrException(sb.toString());
	}

	/**
	 * Returns the last claim intimation mtr in the ordered set where driverNationalId = &#63;.
	 *
	 * @param driverNationalId the driver national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim intimation mtr, or <code>null</code> if a matching claim intimation mtr could not be found
	 */
	@Override
	public ClaimIntimationMtr fetchBydriverNationalId_Last(
		long driverNationalId,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		int count = countBydriverNationalId(driverNationalId);

		if (count == 0) {
			return null;
		}

		List<ClaimIntimationMtr> list = findBydriverNationalId(
			driverNationalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the claim intimation mtrs before and after the current claim intimation mtr in the ordered set where driverNationalId = &#63;.
	 *
	 * @param claimIntimationMotorId the primary key of the current claim intimation mtr
	 * @param driverNationalId the driver national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a claim intimation mtr with the primary key could not be found
	 */
	@Override
	public ClaimIntimationMtr[] findBydriverNationalId_PrevAndNext(
			long claimIntimationMotorId, long driverNationalId,
			OrderByComparator<ClaimIntimationMtr> orderByComparator)
		throws NoSuchClaimIntimationMtrException {

		ClaimIntimationMtr claimIntimationMtr = findByPrimaryKey(
			claimIntimationMotorId);

		Session session = null;

		try {
			session = openSession();

			ClaimIntimationMtr[] array = new ClaimIntimationMtrImpl[3];

			array[0] = getBydriverNationalId_PrevAndNext(
				session, claimIntimationMtr, driverNationalId,
				orderByComparator, true);

			array[1] = claimIntimationMtr;

			array[2] = getBydriverNationalId_PrevAndNext(
				session, claimIntimationMtr, driverNationalId,
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

	protected ClaimIntimationMtr getBydriverNationalId_PrevAndNext(
		Session session, ClaimIntimationMtr claimIntimationMtr,
		long driverNationalId,
		OrderByComparator<ClaimIntimationMtr> orderByComparator,
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

		sb.append(_SQL_SELECT_CLAIMINTIMATIONMTR_WHERE);

		sb.append(_FINDER_COLUMN_DRIVERNATIONALID_DRIVERNATIONALID_2);

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
			sb.append(ClaimIntimationMtrModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(driverNationalId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						claimIntimationMtr)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ClaimIntimationMtr> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the claim intimation mtrs where driverNationalId = &#63; from the database.
	 *
	 * @param driverNationalId the driver national ID
	 */
	@Override
	public void removeBydriverNationalId(long driverNationalId) {
		for (ClaimIntimationMtr claimIntimationMtr :
				findBydriverNationalId(
					driverNationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(claimIntimationMtr);
		}
	}

	/**
	 * Returns the number of claim intimation mtrs where driverNationalId = &#63;.
	 *
	 * @param driverNationalId the driver national ID
	 * @return the number of matching claim intimation mtrs
	 */
	@Override
	public int countBydriverNationalId(long driverNationalId) {
		FinderPath finderPath = _finderPathCountBydriverNationalId;

		Object[] finderArgs = new Object[] {driverNationalId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLAIMINTIMATIONMTR_WHERE);

			sb.append(_FINDER_COLUMN_DRIVERNATIONALID_DRIVERNATIONALID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(driverNationalId);

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
		_FINDER_COLUMN_DRIVERNATIONALID_DRIVERNATIONALID_2 =
			"claimIntimationMtr.driverNationalId = ?";

	public ClaimIntimationMtrPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("claimIntimationMotorId", "cim_sys_id");
		dbColumnNames.put("intimationReferenceNo", "intimation_ref");
		dbColumnNames.put("claimantType", "claimant_type");
		dbColumnNames.put("policyNo", "Policy_No");
		dbColumnNames.put("vehiclePlateNo", "Vehicle_Plate_No");
		dbColumnNames.put("sequenceNo", "Sequence_No");
		dbColumnNames.put("chassisNo", "Chassis_No");
		dbColumnNames.put("mobileNo", "Mobile_No");
		dbColumnNames.put("causeOfLoss", "Cause_of_loss");
		dbColumnNames.put("dateOfLoss", "Date_of_Loss");
		dbColumnNames.put("accidentCity", "Accident_City");
		dbColumnNames.put("descOfAccident", "Desc_of_Accident");
		dbColumnNames.put("srcOfAccidentReport", "src_accident_report");
		dbColumnNames.put("accidentReportNo", "Accident_Report_No");
		dbColumnNames.put("vehicleMake", "Vehicle_Make");
		dbColumnNames.put("vehicleModel", "vehicle_model");
		dbColumnNames.put("driverName", "Driver_Name");
		dbColumnNames.put("driverNationality", "Driver_Nationality");
		dbColumnNames.put("driverNationalId", "Driver_National_ID");
		dbColumnNames.put("driverBirthDate", "Driver_Birth_Date");
		dbColumnNames.put("driverGender", "Driver_Gender");
		dbColumnNames.put("attachmentReference", "attachment_reference");
		dbColumnNames.put("claimStatus", "claim_status");
		dbColumnNames.put("ibanNumber", "iban_no");
		dbColumnNames.put("bankName", "bank_name");
		dbColumnNames.put("emailId", "EMAIL_ID");

		setDBColumnNames(dbColumnNames);

		setModelClass(ClaimIntimationMtr.class);

		setModelImplClass(ClaimIntimationMtrImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the claim intimation mtr in the entity cache if it is enabled.
	 *
	 * @param claimIntimationMtr the claim intimation mtr
	 */
	@Override
	public void cacheResult(ClaimIntimationMtr claimIntimationMtr) {
		dummyEntityCache.putResult(
			ClaimIntimationMtrImpl.class, claimIntimationMtr.getPrimaryKey(),
			claimIntimationMtr);
	}

	/**
	 * Caches the claim intimation mtrs in the entity cache if it is enabled.
	 *
	 * @param claimIntimationMtrs the claim intimation mtrs
	 */
	@Override
	public void cacheResult(List<ClaimIntimationMtr> claimIntimationMtrs) {
		for (ClaimIntimationMtr claimIntimationMtr : claimIntimationMtrs) {
			if (dummyEntityCache.getResult(
					ClaimIntimationMtrImpl.class,
					claimIntimationMtr.getPrimaryKey()) == null) {

				cacheResult(claimIntimationMtr);
			}
		}
	}

	/**
	 * Clears the cache for all claim intimation mtrs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(ClaimIntimationMtrImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the claim intimation mtr.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ClaimIntimationMtr claimIntimationMtr) {
		dummyEntityCache.removeResult(
			ClaimIntimationMtrImpl.class, claimIntimationMtr);
	}

	@Override
	public void clearCache(List<ClaimIntimationMtr> claimIntimationMtrs) {
		for (ClaimIntimationMtr claimIntimationMtr : claimIntimationMtrs) {
			dummyEntityCache.removeResult(
				ClaimIntimationMtrImpl.class, claimIntimationMtr);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				ClaimIntimationMtrImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new claim intimation mtr with the primary key. Does not add the claim intimation mtr to the database.
	 *
	 * @param claimIntimationMotorId the primary key for the new claim intimation mtr
	 * @return the new claim intimation mtr
	 */
	@Override
	public ClaimIntimationMtr create(long claimIntimationMotorId) {
		ClaimIntimationMtr claimIntimationMtr = new ClaimIntimationMtrImpl();

		claimIntimationMtr.setNew(true);
		claimIntimationMtr.setPrimaryKey(claimIntimationMotorId);

		return claimIntimationMtr;
	}

	/**
	 * Removes the claim intimation mtr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimIntimationMotorId the primary key of the claim intimation mtr
	 * @return the claim intimation mtr that was removed
	 * @throws NoSuchClaimIntimationMtrException if a claim intimation mtr with the primary key could not be found
	 */
	@Override
	public ClaimIntimationMtr remove(long claimIntimationMotorId)
		throws NoSuchClaimIntimationMtrException {

		return remove((Serializable)claimIntimationMotorId);
	}

	/**
	 * Removes the claim intimation mtr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the claim intimation mtr
	 * @return the claim intimation mtr that was removed
	 * @throws NoSuchClaimIntimationMtrException if a claim intimation mtr with the primary key could not be found
	 */
	@Override
	public ClaimIntimationMtr remove(Serializable primaryKey)
		throws NoSuchClaimIntimationMtrException {

		Session session = null;

		try {
			session = openSession();

			ClaimIntimationMtr claimIntimationMtr =
				(ClaimIntimationMtr)session.get(
					ClaimIntimationMtrImpl.class, primaryKey);

			if (claimIntimationMtr == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClaimIntimationMtrException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(claimIntimationMtr);
		}
		catch (NoSuchClaimIntimationMtrException noSuchEntityException) {
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
	protected ClaimIntimationMtr removeImpl(
		ClaimIntimationMtr claimIntimationMtr) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(claimIntimationMtr)) {
				claimIntimationMtr = (ClaimIntimationMtr)session.get(
					ClaimIntimationMtrImpl.class,
					claimIntimationMtr.getPrimaryKeyObj());
			}

			if (claimIntimationMtr != null) {
				session.delete(claimIntimationMtr);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (claimIntimationMtr != null) {
			clearCache(claimIntimationMtr);
		}

		return claimIntimationMtr;
	}

	@Override
	public ClaimIntimationMtr updateImpl(
		ClaimIntimationMtr claimIntimationMtr) {

		boolean isNew = claimIntimationMtr.isNew();

		if (!(claimIntimationMtr instanceof ClaimIntimationMtrModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(claimIntimationMtr.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					claimIntimationMtr);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in claimIntimationMtr proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ClaimIntimationMtr implementation " +
					claimIntimationMtr.getClass());
		}

		ClaimIntimationMtrModelImpl claimIntimationMtrModelImpl =
			(ClaimIntimationMtrModelImpl)claimIntimationMtr;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(claimIntimationMtr);
			}
			else {
				claimIntimationMtr = (ClaimIntimationMtr)session.merge(
					claimIntimationMtr);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			ClaimIntimationMtrImpl.class, claimIntimationMtrModelImpl, false,
			true);

		if (isNew) {
			claimIntimationMtr.setNew(false);
		}

		claimIntimationMtr.resetOriginalValues();

		return claimIntimationMtr;
	}

	/**
	 * Returns the claim intimation mtr with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the claim intimation mtr
	 * @return the claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a claim intimation mtr with the primary key could not be found
	 */
	@Override
	public ClaimIntimationMtr findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClaimIntimationMtrException {

		ClaimIntimationMtr claimIntimationMtr = fetchByPrimaryKey(primaryKey);

		if (claimIntimationMtr == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClaimIntimationMtrException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return claimIntimationMtr;
	}

	/**
	 * Returns the claim intimation mtr with the primary key or throws a <code>NoSuchClaimIntimationMtrException</code> if it could not be found.
	 *
	 * @param claimIntimationMotorId the primary key of the claim intimation mtr
	 * @return the claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a claim intimation mtr with the primary key could not be found
	 */
	@Override
	public ClaimIntimationMtr findByPrimaryKey(long claimIntimationMotorId)
		throws NoSuchClaimIntimationMtrException {

		return findByPrimaryKey((Serializable)claimIntimationMotorId);
	}

	/**
	 * Returns the claim intimation mtr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimIntimationMotorId the primary key of the claim intimation mtr
	 * @return the claim intimation mtr, or <code>null</code> if a claim intimation mtr with the primary key could not be found
	 */
	@Override
	public ClaimIntimationMtr fetchByPrimaryKey(long claimIntimationMotorId) {
		return fetchByPrimaryKey((Serializable)claimIntimationMotorId);
	}

	/**
	 * Returns all the claim intimation mtrs.
	 *
	 * @return the claim intimation mtrs
	 */
	@Override
	public List<ClaimIntimationMtr> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the claim intimation mtrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @return the range of claim intimation mtrs
	 */
	@Override
	public List<ClaimIntimationMtr> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the claim intimation mtrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of claim intimation mtrs
	 */
	@Override
	public List<ClaimIntimationMtr> findAll(
		int start, int end,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claim intimation mtrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of claim intimation mtrs
	 */
	@Override
	public List<ClaimIntimationMtr> findAll(
		int start, int end,
		OrderByComparator<ClaimIntimationMtr> orderByComparator,
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

		List<ClaimIntimationMtr> list = null;

		if (useFinderCache) {
			list = (List<ClaimIntimationMtr>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CLAIMINTIMATIONMTR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CLAIMINTIMATIONMTR;

				sql = sql.concat(ClaimIntimationMtrModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ClaimIntimationMtr>)QueryUtil.list(
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
	 * Removes all the claim intimation mtrs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ClaimIntimationMtr claimIntimationMtr : findAll()) {
			remove(claimIntimationMtr);
		}
	}

	/**
	 * Returns the number of claim intimation mtrs.
	 *
	 * @return the number of claim intimation mtrs
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
					_SQL_COUNT_CLAIMINTIMATIONMTR);

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
		return "cim_sys_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLAIMINTIMATIONMTR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ClaimIntimationMtrModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the claim intimation mtr persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ClaimIntimationMtrModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ClaimIntimationMtr.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByintimationReferenceNo =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByintimationReferenceNo",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"intimation_ref"}, true);

		_finderPathWithoutPaginationFindByintimationReferenceNo =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByintimationReferenceNo",
				new String[] {String.class.getName()},
				new String[] {"intimation_ref"}, true);

		_finderPathCountByintimationReferenceNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByintimationReferenceNo",
			new String[] {String.class.getName()},
			new String[] {"intimation_ref"}, false);

		_finderPathWithPaginationFindBymobileNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymobileNo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"Mobile_No"}, true);

		_finderPathWithoutPaginationFindBymobileNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymobileNo",
			new String[] {String.class.getName()}, new String[] {"Mobile_No"},
			true);

		_finderPathCountBymobileNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymobileNo",
			new String[] {String.class.getName()}, new String[] {"Mobile_No"},
			false);

		_finderPathWithPaginationFindBydriverNationalId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydriverNationalId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"Driver_National_ID"}, true);

		_finderPathWithoutPaginationFindBydriverNationalId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydriverNationalId",
			new String[] {Long.class.getName()},
			new String[] {"Driver_National_ID"}, true);

		_finderPathCountBydriverNationalId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydriverNationalId", new String[] {Long.class.getName()},
			new String[] {"Driver_National_ID"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(ClaimIntimationMtrImpl.class.getName());

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

	private static final String _SQL_SELECT_CLAIMINTIMATIONMTR =
		"SELECT claimIntimationMtr FROM ClaimIntimationMtr claimIntimationMtr";

	private static final String _SQL_SELECT_CLAIMINTIMATIONMTR_WHERE =
		"SELECT claimIntimationMtr FROM ClaimIntimationMtr claimIntimationMtr WHERE ";

	private static final String _SQL_COUNT_CLAIMINTIMATIONMTR =
		"SELECT COUNT(claimIntimationMtr) FROM ClaimIntimationMtr claimIntimationMtr";

	private static final String _SQL_COUNT_CLAIMINTIMATIONMTR_WHERE =
		"SELECT COUNT(claimIntimationMtr) FROM ClaimIntimationMtr claimIntimationMtr WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "claimIntimationMtr.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ClaimIntimationMtr exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ClaimIntimationMtr exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ClaimIntimationMtrPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"claimIntimationMotorId", "intimationReferenceNo", "claimantType",
			"policyNo", "vehiclePlateNo", "sequenceNo", "chassisNo", "mobileNo",
			"causeOfLoss", "dateOfLoss", "accidentCity", "descOfAccident",
			"srcOfAccidentReport", "accidentReportNo", "vehicleMake",
			"vehicleModel", "driverName", "driverNationality",
			"driverNationalId", "driverBirthDate", "driverGender",
			"attachmentReference", "claimStatus", "ibanNumber", "bankName",
			"emailId"
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

	private static class ClaimIntimationMtrModelArgumentsResolver
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

			ClaimIntimationMtrModelImpl claimIntimationMtrModelImpl =
				(ClaimIntimationMtrModelImpl)baseModel;

			long columnBitmask = claimIntimationMtrModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					claimIntimationMtrModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						claimIntimationMtrModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					claimIntimationMtrModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ClaimIntimationMtrModelImpl claimIntimationMtrModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						claimIntimationMtrModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = claimIntimationMtrModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}