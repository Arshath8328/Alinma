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

import com.ejada.atmc.acl.db.exception.NoSuchFundDetailsException;
import com.ejada.atmc.acl.db.model.FundDetails;
import com.ejada.atmc.acl.db.model.impl.FundDetailsImpl;
import com.ejada.atmc.acl.db.model.impl.FundDetailsModelImpl;
import com.ejada.atmc.acl.db.service.persistence.FundDetailsPersistence;
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
 * The persistence implementation for the fund details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FundDetailsPersistence.class)
public class FundDetailsPersistenceImpl
	extends BasePersistenceImpl<FundDetails> implements FundDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FundDetailsUtil</code> to access the fund details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FundDetailsImpl.class.getName();

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
	 * Returns all the fund detailses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the matching fund detailses
	 */
	@Override
	public List<FundDetails> findByPolicyNo(String policyNo) {
		return findByPolicyNo(
			policyNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fund detailses where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FundDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of fund detailses
	 * @param end the upper bound of the range of fund detailses (not inclusive)
	 * @return the range of matching fund detailses
	 */
	@Override
	public List<FundDetails> findByPolicyNo(
		String policyNo, int start, int end) {

		return findByPolicyNo(policyNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fund detailses where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FundDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of fund detailses
	 * @param end the upper bound of the range of fund detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fund detailses
	 */
	@Override
	public List<FundDetails> findByPolicyNo(
		String policyNo, int start, int end,
		OrderByComparator<FundDetails> orderByComparator) {

		return findByPolicyNo(policyNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fund detailses where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FundDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of fund detailses
	 * @param end the upper bound of the range of fund detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fund detailses
	 */
	@Override
	public List<FundDetails> findByPolicyNo(
		String policyNo, int start, int end,
		OrderByComparator<FundDetails> orderByComparator,
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

		List<FundDetails> list = null;

		if (useFinderCache) {
			list = (List<FundDetails>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FundDetails fundDetails : list) {
					if (!policyNo.equals(fundDetails.getPolicyNo())) {
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

			sb.append(_SQL_SELECT_FUNDDETAILS_WHERE);

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
				sb.append(FundDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<FundDetails>)QueryUtil.list(
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
	 * Returns the first fund details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund details
	 * @throws NoSuchFundDetailsException if a matching fund details could not be found
	 */
	@Override
	public FundDetails findByPolicyNo_First(
			String policyNo, OrderByComparator<FundDetails> orderByComparator)
		throws NoSuchFundDetailsException {

		FundDetails fundDetails = fetchByPolicyNo_First(
			policyNo, orderByComparator);

		if (fundDetails != null) {
			return fundDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNo=");
		sb.append(policyNo);

		sb.append("}");

		throw new NoSuchFundDetailsException(sb.toString());
	}

	/**
	 * Returns the first fund details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund details, or <code>null</code> if a matching fund details could not be found
	 */
	@Override
	public FundDetails fetchByPolicyNo_First(
		String policyNo, OrderByComparator<FundDetails> orderByComparator) {

		List<FundDetails> list = findByPolicyNo(
			policyNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fund details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund details
	 * @throws NoSuchFundDetailsException if a matching fund details could not be found
	 */
	@Override
	public FundDetails findByPolicyNo_Last(
			String policyNo, OrderByComparator<FundDetails> orderByComparator)
		throws NoSuchFundDetailsException {

		FundDetails fundDetails = fetchByPolicyNo_Last(
			policyNo, orderByComparator);

		if (fundDetails != null) {
			return fundDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNo=");
		sb.append(policyNo);

		sb.append("}");

		throw new NoSuchFundDetailsException(sb.toString());
	}

	/**
	 * Returns the last fund details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund details, or <code>null</code> if a matching fund details could not be found
	 */
	@Override
	public FundDetails fetchByPolicyNo_Last(
		String policyNo, OrderByComparator<FundDetails> orderByComparator) {

		int count = countByPolicyNo(policyNo);

		if (count == 0) {
			return null;
		}

		List<FundDetails> list = findByPolicyNo(
			policyNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fund detailses before and after the current fund details in the ordered set where policyNo = &#63;.
	 *
	 * @param fundName the primary key of the current fund details
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fund details
	 * @throws NoSuchFundDetailsException if a fund details with the primary key could not be found
	 */
	@Override
	public FundDetails[] findByPolicyNo_PrevAndNext(
			String fundName, String policyNo,
			OrderByComparator<FundDetails> orderByComparator)
		throws NoSuchFundDetailsException {

		policyNo = Objects.toString(policyNo, "");

		FundDetails fundDetails = findByPrimaryKey(fundName);

		Session session = null;

		try {
			session = openSession();

			FundDetails[] array = new FundDetailsImpl[3];

			array[0] = getByPolicyNo_PrevAndNext(
				session, fundDetails, policyNo, orderByComparator, true);

			array[1] = fundDetails;

			array[2] = getByPolicyNo_PrevAndNext(
				session, fundDetails, policyNo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FundDetails getByPolicyNo_PrevAndNext(
		Session session, FundDetails fundDetails, String policyNo,
		OrderByComparator<FundDetails> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FUNDDETAILS_WHERE);

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
			sb.append(FundDetailsModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(fundDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FundDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fund detailses where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 */
	@Override
	public void removeByPolicyNo(String policyNo) {
		for (FundDetails fundDetails :
				findByPolicyNo(
					policyNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fundDetails);
		}
	}

	/**
	 * Returns the number of fund detailses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching fund detailses
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

			sb.append(_SQL_COUNT_FUNDDETAILS_WHERE);

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
		"fundDetails.policyNo = ?";

	private static final String _FINDER_COLUMN_POLICYNO_POLICYNO_3 =
		"(fundDetails.policyNo IS NULL OR fundDetails.policyNo = '')";

	public FundDetailsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("policyNo", "ODS_POLICY_NO");
		dbColumnNames.put("fundName", "ODS_FUND_NAME");
		dbColumnNames.put("fundDesc", "ODS_FUND_DESC");
		dbColumnNames.put("fundPctg", "ODS_FUND_PCTG");
		dbColumnNames.put("unitsSum", "ODS_UNITS_SUM");
		dbColumnNames.put("unitPrice", "ODS_UNIT_PRICE");
		dbColumnNames.put("fundsValue", "ODS_FUNDS_VALUE");
		dbColumnNames.put("riskChg", "ODS_RISK_CHG");
		dbColumnNames.put("partFees", "ODS_PART_FEES");

		setDBColumnNames(dbColumnNames);

		setModelClass(FundDetails.class);

		setModelImplClass(FundDetailsImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the fund details in the entity cache if it is enabled.
	 *
	 * @param fundDetails the fund details
	 */
	@Override
	public void cacheResult(FundDetails fundDetails) {
		dummyEntityCache.putResult(
			FundDetailsImpl.class, fundDetails.getPrimaryKey(), fundDetails);
	}

	/**
	 * Caches the fund detailses in the entity cache if it is enabled.
	 *
	 * @param fundDetailses the fund detailses
	 */
	@Override
	public void cacheResult(List<FundDetails> fundDetailses) {
		for (FundDetails fundDetails : fundDetailses) {
			if (dummyEntityCache.getResult(
					FundDetailsImpl.class, fundDetails.getPrimaryKey()) ==
						null) {

				cacheResult(fundDetails);
			}
		}
	}

	/**
	 * Clears the cache for all fund detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(FundDetailsImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fund details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FundDetails fundDetails) {
		dummyEntityCache.removeResult(FundDetailsImpl.class, fundDetails);
	}

	@Override
	public void clearCache(List<FundDetails> fundDetailses) {
		for (FundDetails fundDetails : fundDetailses) {
			dummyEntityCache.removeResult(FundDetailsImpl.class, fundDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(FundDetailsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new fund details with the primary key. Does not add the fund details to the database.
	 *
	 * @param fundName the primary key for the new fund details
	 * @return the new fund details
	 */
	@Override
	public FundDetails create(String fundName) {
		FundDetails fundDetails = new FundDetailsImpl();

		fundDetails.setNew(true);
		fundDetails.setPrimaryKey(fundName);

		return fundDetails;
	}

	/**
	 * Removes the fund details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fundName the primary key of the fund details
	 * @return the fund details that was removed
	 * @throws NoSuchFundDetailsException if a fund details with the primary key could not be found
	 */
	@Override
	public FundDetails remove(String fundName)
		throws NoSuchFundDetailsException {

		return remove((Serializable)fundName);
	}

	/**
	 * Removes the fund details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fund details
	 * @return the fund details that was removed
	 * @throws NoSuchFundDetailsException if a fund details with the primary key could not be found
	 */
	@Override
	public FundDetails remove(Serializable primaryKey)
		throws NoSuchFundDetailsException {

		Session session = null;

		try {
			session = openSession();

			FundDetails fundDetails = (FundDetails)session.get(
				FundDetailsImpl.class, primaryKey);

			if (fundDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFundDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(fundDetails);
		}
		catch (NoSuchFundDetailsException noSuchEntityException) {
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
	protected FundDetails removeImpl(FundDetails fundDetails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fundDetails)) {
				fundDetails = (FundDetails)session.get(
					FundDetailsImpl.class, fundDetails.getPrimaryKeyObj());
			}

			if (fundDetails != null) {
				session.delete(fundDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (fundDetails != null) {
			clearCache(fundDetails);
		}

		return fundDetails;
	}

	@Override
	public FundDetails updateImpl(FundDetails fundDetails) {
		boolean isNew = fundDetails.isNew();

		if (!(fundDetails instanceof FundDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(fundDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(fundDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in fundDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FundDetails implementation " +
					fundDetails.getClass());
		}

		FundDetailsModelImpl fundDetailsModelImpl =
			(FundDetailsModelImpl)fundDetails;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(fundDetails);
			}
			else {
				fundDetails = (FundDetails)session.merge(fundDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			FundDetailsImpl.class, fundDetailsModelImpl, false, true);

		if (isNew) {
			fundDetails.setNew(false);
		}

		fundDetails.resetOriginalValues();

		return fundDetails;
	}

	/**
	 * Returns the fund details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fund details
	 * @return the fund details
	 * @throws NoSuchFundDetailsException if a fund details with the primary key could not be found
	 */
	@Override
	public FundDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFundDetailsException {

		FundDetails fundDetails = fetchByPrimaryKey(primaryKey);

		if (fundDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFundDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return fundDetails;
	}

	/**
	 * Returns the fund details with the primary key or throws a <code>NoSuchFundDetailsException</code> if it could not be found.
	 *
	 * @param fundName the primary key of the fund details
	 * @return the fund details
	 * @throws NoSuchFundDetailsException if a fund details with the primary key could not be found
	 */
	@Override
	public FundDetails findByPrimaryKey(String fundName)
		throws NoSuchFundDetailsException {

		return findByPrimaryKey((Serializable)fundName);
	}

	/**
	 * Returns the fund details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fundName the primary key of the fund details
	 * @return the fund details, or <code>null</code> if a fund details with the primary key could not be found
	 */
	@Override
	public FundDetails fetchByPrimaryKey(String fundName) {
		return fetchByPrimaryKey((Serializable)fundName);
	}

	/**
	 * Returns all the fund detailses.
	 *
	 * @return the fund detailses
	 */
	@Override
	public List<FundDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fund detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FundDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fund detailses
	 * @param end the upper bound of the range of fund detailses (not inclusive)
	 * @return the range of fund detailses
	 */
	@Override
	public List<FundDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fund detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FundDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fund detailses
	 * @param end the upper bound of the range of fund detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fund detailses
	 */
	@Override
	public List<FundDetails> findAll(
		int start, int end, OrderByComparator<FundDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fund detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FundDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fund detailses
	 * @param end the upper bound of the range of fund detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of fund detailses
	 */
	@Override
	public List<FundDetails> findAll(
		int start, int end, OrderByComparator<FundDetails> orderByComparator,
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

		List<FundDetails> list = null;

		if (useFinderCache) {
			list = (List<FundDetails>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FUNDDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FUNDDETAILS;

				sql = sql.concat(FundDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FundDetails>)QueryUtil.list(
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
	 * Removes all the fund detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FundDetails fundDetails : findAll()) {
			remove(fundDetails);
		}
	}

	/**
	 * Returns the number of fund detailses.
	 *
	 * @return the number of fund detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FUNDDETAILS);

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
		return "ODS_FUND_NAME";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FUNDDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FundDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the fund details persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new FundDetailsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", FundDetails.class.getName()));

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
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(FundDetailsImpl.class.getName());

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

	private static final String _SQL_SELECT_FUNDDETAILS =
		"SELECT fundDetails FROM FundDetails fundDetails";

	private static final String _SQL_SELECT_FUNDDETAILS_WHERE =
		"SELECT fundDetails FROM FundDetails fundDetails WHERE ";

	private static final String _SQL_COUNT_FUNDDETAILS =
		"SELECT COUNT(fundDetails) FROM FundDetails fundDetails";

	private static final String _SQL_COUNT_FUNDDETAILS_WHERE =
		"SELECT COUNT(fundDetails) FROM FundDetails fundDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "fundDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FundDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FundDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FundDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"policyNo", "fundName", "fundDesc", "fundPctg", "unitsSum",
			"unitPrice", "fundsValue", "riskChg", "partFees"
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

	private static class FundDetailsModelArgumentsResolver
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

			FundDetailsModelImpl fundDetailsModelImpl =
				(FundDetailsModelImpl)baseModel;

			long columnBitmask = fundDetailsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(fundDetailsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						fundDetailsModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(fundDetailsModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			FundDetailsModelImpl fundDetailsModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = fundDetailsModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = fundDetailsModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}