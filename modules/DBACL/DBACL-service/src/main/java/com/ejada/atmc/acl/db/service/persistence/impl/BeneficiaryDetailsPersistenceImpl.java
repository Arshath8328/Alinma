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

import com.ejada.atmc.acl.db.exception.NoSuchBeneficiaryDetailsException;
import com.ejada.atmc.acl.db.model.BeneficiaryDetails;
import com.ejada.atmc.acl.db.model.impl.BeneficiaryDetailsImpl;
import com.ejada.atmc.acl.db.model.impl.BeneficiaryDetailsModelImpl;
import com.ejada.atmc.acl.db.service.persistence.BeneficiaryDetailsPersistence;
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
 * The persistence implementation for the beneficiary details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BeneficiaryDetailsPersistence.class)
public class BeneficiaryDetailsPersistenceImpl
	extends BasePersistenceImpl<BeneficiaryDetails>
	implements BeneficiaryDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BeneficiaryDetailsUtil</code> to access the beneficiary details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BeneficiaryDetailsImpl.class.getName();

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
	 * Returns all the beneficiary detailses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the matching beneficiary detailses
	 */
	@Override
	public List<BeneficiaryDetails> findByPolicyNo(String policyNo) {
		return findByPolicyNo(
			policyNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the beneficiary detailses where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BeneficiaryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of beneficiary detailses
	 * @param end the upper bound of the range of beneficiary detailses (not inclusive)
	 * @return the range of matching beneficiary detailses
	 */
	@Override
	public List<BeneficiaryDetails> findByPolicyNo(
		String policyNo, int start, int end) {

		return findByPolicyNo(policyNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the beneficiary detailses where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BeneficiaryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of beneficiary detailses
	 * @param end the upper bound of the range of beneficiary detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching beneficiary detailses
	 */
	@Override
	public List<BeneficiaryDetails> findByPolicyNo(
		String policyNo, int start, int end,
		OrderByComparator<BeneficiaryDetails> orderByComparator) {

		return findByPolicyNo(policyNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the beneficiary detailses where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BeneficiaryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of beneficiary detailses
	 * @param end the upper bound of the range of beneficiary detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching beneficiary detailses
	 */
	@Override
	public List<BeneficiaryDetails> findByPolicyNo(
		String policyNo, int start, int end,
		OrderByComparator<BeneficiaryDetails> orderByComparator,
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

		List<BeneficiaryDetails> list = null;

		if (useFinderCache) {
			list = (List<BeneficiaryDetails>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BeneficiaryDetails beneficiaryDetails : list) {
					if (!policyNo.equals(beneficiaryDetails.getPolicyNo())) {
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

			sb.append(_SQL_SELECT_BENEFICIARYDETAILS_WHERE);

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
				sb.append(BeneficiaryDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<BeneficiaryDetails>)QueryUtil.list(
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
	 * Returns the first beneficiary details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching beneficiary details
	 * @throws NoSuchBeneficiaryDetailsException if a matching beneficiary details could not be found
	 */
	@Override
	public BeneficiaryDetails findByPolicyNo_First(
			String policyNo,
			OrderByComparator<BeneficiaryDetails> orderByComparator)
		throws NoSuchBeneficiaryDetailsException {

		BeneficiaryDetails beneficiaryDetails = fetchByPolicyNo_First(
			policyNo, orderByComparator);

		if (beneficiaryDetails != null) {
			return beneficiaryDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNo=");
		sb.append(policyNo);

		sb.append("}");

		throw new NoSuchBeneficiaryDetailsException(sb.toString());
	}

	/**
	 * Returns the first beneficiary details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching beneficiary details, or <code>null</code> if a matching beneficiary details could not be found
	 */
	@Override
	public BeneficiaryDetails fetchByPolicyNo_First(
		String policyNo,
		OrderByComparator<BeneficiaryDetails> orderByComparator) {

		List<BeneficiaryDetails> list = findByPolicyNo(
			policyNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last beneficiary details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching beneficiary details
	 * @throws NoSuchBeneficiaryDetailsException if a matching beneficiary details could not be found
	 */
	@Override
	public BeneficiaryDetails findByPolicyNo_Last(
			String policyNo,
			OrderByComparator<BeneficiaryDetails> orderByComparator)
		throws NoSuchBeneficiaryDetailsException {

		BeneficiaryDetails beneficiaryDetails = fetchByPolicyNo_Last(
			policyNo, orderByComparator);

		if (beneficiaryDetails != null) {
			return beneficiaryDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNo=");
		sb.append(policyNo);

		sb.append("}");

		throw new NoSuchBeneficiaryDetailsException(sb.toString());
	}

	/**
	 * Returns the last beneficiary details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching beneficiary details, or <code>null</code> if a matching beneficiary details could not be found
	 */
	@Override
	public BeneficiaryDetails fetchByPolicyNo_Last(
		String policyNo,
		OrderByComparator<BeneficiaryDetails> orderByComparator) {

		int count = countByPolicyNo(policyNo);

		if (count == 0) {
			return null;
		}

		List<BeneficiaryDetails> list = findByPolicyNo(
			policyNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the beneficiary detailses before and after the current beneficiary details in the ordered set where policyNo = &#63;.
	 *
	 * @param benfId the primary key of the current beneficiary details
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next beneficiary details
	 * @throws NoSuchBeneficiaryDetailsException if a beneficiary details with the primary key could not be found
	 */
	@Override
	public BeneficiaryDetails[] findByPolicyNo_PrevAndNext(
			long benfId, String policyNo,
			OrderByComparator<BeneficiaryDetails> orderByComparator)
		throws NoSuchBeneficiaryDetailsException {

		policyNo = Objects.toString(policyNo, "");

		BeneficiaryDetails beneficiaryDetails = findByPrimaryKey(benfId);

		Session session = null;

		try {
			session = openSession();

			BeneficiaryDetails[] array = new BeneficiaryDetailsImpl[3];

			array[0] = getByPolicyNo_PrevAndNext(
				session, beneficiaryDetails, policyNo, orderByComparator, true);

			array[1] = beneficiaryDetails;

			array[2] = getByPolicyNo_PrevAndNext(
				session, beneficiaryDetails, policyNo, orderByComparator,
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

	protected BeneficiaryDetails getByPolicyNo_PrevAndNext(
		Session session, BeneficiaryDetails beneficiaryDetails, String policyNo,
		OrderByComparator<BeneficiaryDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_BENEFICIARYDETAILS_WHERE);

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
			sb.append(BeneficiaryDetailsModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						beneficiaryDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BeneficiaryDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the beneficiary detailses where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 */
	@Override
	public void removeByPolicyNo(String policyNo) {
		for (BeneficiaryDetails beneficiaryDetails :
				findByPolicyNo(
					policyNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(beneficiaryDetails);
		}
	}

	/**
	 * Returns the number of beneficiary detailses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching beneficiary detailses
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

			sb.append(_SQL_COUNT_BENEFICIARYDETAILS_WHERE);

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
		"beneficiaryDetails.policyNo = ?";

	private static final String _FINDER_COLUMN_POLICYNO_POLICYNO_3 =
		"(beneficiaryDetails.policyNo IS NULL OR beneficiaryDetails.policyNo = '')";

	public BeneficiaryDetailsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("policyNo", "ODS_POLICY_NO");
		dbColumnNames.put("benfName", "ODS_BENF_NAME");
		dbColumnNames.put("benfPct", "ODS_BENF_PCT");
		dbColumnNames.put("benfRel", "ODS_BENF_REL");
		dbColumnNames.put("benfId", "ODS_BENF_ID");
		dbColumnNames.put("benfAge", "ODS_BENF_AGE");
		dbColumnNames.put("benfType", "ODS_BENF_TYPE");

		setDBColumnNames(dbColumnNames);

		setModelClass(BeneficiaryDetails.class);

		setModelImplClass(BeneficiaryDetailsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the beneficiary details in the entity cache if it is enabled.
	 *
	 * @param beneficiaryDetails the beneficiary details
	 */
	@Override
	public void cacheResult(BeneficiaryDetails beneficiaryDetails) {
		dummyEntityCache.putResult(
			BeneficiaryDetailsImpl.class, beneficiaryDetails.getPrimaryKey(),
			beneficiaryDetails);
	}

	/**
	 * Caches the beneficiary detailses in the entity cache if it is enabled.
	 *
	 * @param beneficiaryDetailses the beneficiary detailses
	 */
	@Override
	public void cacheResult(List<BeneficiaryDetails> beneficiaryDetailses) {
		for (BeneficiaryDetails beneficiaryDetails : beneficiaryDetailses) {
			if (dummyEntityCache.getResult(
					BeneficiaryDetailsImpl.class,
					beneficiaryDetails.getPrimaryKey()) == null) {

				cacheResult(beneficiaryDetails);
			}
		}
	}

	/**
	 * Clears the cache for all beneficiary detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(BeneficiaryDetailsImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the beneficiary details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BeneficiaryDetails beneficiaryDetails) {
		dummyEntityCache.removeResult(
			BeneficiaryDetailsImpl.class, beneficiaryDetails);
	}

	@Override
	public void clearCache(List<BeneficiaryDetails> beneficiaryDetailses) {
		for (BeneficiaryDetails beneficiaryDetails : beneficiaryDetailses) {
			dummyEntityCache.removeResult(
				BeneficiaryDetailsImpl.class, beneficiaryDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				BeneficiaryDetailsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new beneficiary details with the primary key. Does not add the beneficiary details to the database.
	 *
	 * @param benfId the primary key for the new beneficiary details
	 * @return the new beneficiary details
	 */
	@Override
	public BeneficiaryDetails create(long benfId) {
		BeneficiaryDetails beneficiaryDetails = new BeneficiaryDetailsImpl();

		beneficiaryDetails.setNew(true);
		beneficiaryDetails.setPrimaryKey(benfId);

		return beneficiaryDetails;
	}

	/**
	 * Removes the beneficiary details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param benfId the primary key of the beneficiary details
	 * @return the beneficiary details that was removed
	 * @throws NoSuchBeneficiaryDetailsException if a beneficiary details with the primary key could not be found
	 */
	@Override
	public BeneficiaryDetails remove(long benfId)
		throws NoSuchBeneficiaryDetailsException {

		return remove((Serializable)benfId);
	}

	/**
	 * Removes the beneficiary details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the beneficiary details
	 * @return the beneficiary details that was removed
	 * @throws NoSuchBeneficiaryDetailsException if a beneficiary details with the primary key could not be found
	 */
	@Override
	public BeneficiaryDetails remove(Serializable primaryKey)
		throws NoSuchBeneficiaryDetailsException {

		Session session = null;

		try {
			session = openSession();

			BeneficiaryDetails beneficiaryDetails =
				(BeneficiaryDetails)session.get(
					BeneficiaryDetailsImpl.class, primaryKey);

			if (beneficiaryDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBeneficiaryDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(beneficiaryDetails);
		}
		catch (NoSuchBeneficiaryDetailsException noSuchEntityException) {
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
	protected BeneficiaryDetails removeImpl(
		BeneficiaryDetails beneficiaryDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(beneficiaryDetails)) {
				beneficiaryDetails = (BeneficiaryDetails)session.get(
					BeneficiaryDetailsImpl.class,
					beneficiaryDetails.getPrimaryKeyObj());
			}

			if (beneficiaryDetails != null) {
				session.delete(beneficiaryDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (beneficiaryDetails != null) {
			clearCache(beneficiaryDetails);
		}

		return beneficiaryDetails;
	}

	@Override
	public BeneficiaryDetails updateImpl(
		BeneficiaryDetails beneficiaryDetails) {

		boolean isNew = beneficiaryDetails.isNew();

		if (!(beneficiaryDetails instanceof BeneficiaryDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(beneficiaryDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					beneficiaryDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in beneficiaryDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BeneficiaryDetails implementation " +
					beneficiaryDetails.getClass());
		}

		BeneficiaryDetailsModelImpl beneficiaryDetailsModelImpl =
			(BeneficiaryDetailsModelImpl)beneficiaryDetails;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(beneficiaryDetails);
			}
			else {
				beneficiaryDetails = (BeneficiaryDetails)session.merge(
					beneficiaryDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			BeneficiaryDetailsImpl.class, beneficiaryDetailsModelImpl, false,
			true);

		if (isNew) {
			beneficiaryDetails.setNew(false);
		}

		beneficiaryDetails.resetOriginalValues();

		return beneficiaryDetails;
	}

	/**
	 * Returns the beneficiary details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the beneficiary details
	 * @return the beneficiary details
	 * @throws NoSuchBeneficiaryDetailsException if a beneficiary details with the primary key could not be found
	 */
	@Override
	public BeneficiaryDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBeneficiaryDetailsException {

		BeneficiaryDetails beneficiaryDetails = fetchByPrimaryKey(primaryKey);

		if (beneficiaryDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBeneficiaryDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return beneficiaryDetails;
	}

	/**
	 * Returns the beneficiary details with the primary key or throws a <code>NoSuchBeneficiaryDetailsException</code> if it could not be found.
	 *
	 * @param benfId the primary key of the beneficiary details
	 * @return the beneficiary details
	 * @throws NoSuchBeneficiaryDetailsException if a beneficiary details with the primary key could not be found
	 */
	@Override
	public BeneficiaryDetails findByPrimaryKey(long benfId)
		throws NoSuchBeneficiaryDetailsException {

		return findByPrimaryKey((Serializable)benfId);
	}

	/**
	 * Returns the beneficiary details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param benfId the primary key of the beneficiary details
	 * @return the beneficiary details, or <code>null</code> if a beneficiary details with the primary key could not be found
	 */
	@Override
	public BeneficiaryDetails fetchByPrimaryKey(long benfId) {
		return fetchByPrimaryKey((Serializable)benfId);
	}

	/**
	 * Returns all the beneficiary detailses.
	 *
	 * @return the beneficiary detailses
	 */
	@Override
	public List<BeneficiaryDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the beneficiary detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BeneficiaryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of beneficiary detailses
	 * @param end the upper bound of the range of beneficiary detailses (not inclusive)
	 * @return the range of beneficiary detailses
	 */
	@Override
	public List<BeneficiaryDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the beneficiary detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BeneficiaryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of beneficiary detailses
	 * @param end the upper bound of the range of beneficiary detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of beneficiary detailses
	 */
	@Override
	public List<BeneficiaryDetails> findAll(
		int start, int end,
		OrderByComparator<BeneficiaryDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the beneficiary detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BeneficiaryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of beneficiary detailses
	 * @param end the upper bound of the range of beneficiary detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of beneficiary detailses
	 */
	@Override
	public List<BeneficiaryDetails> findAll(
		int start, int end,
		OrderByComparator<BeneficiaryDetails> orderByComparator,
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

		List<BeneficiaryDetails> list = null;

		if (useFinderCache) {
			list = (List<BeneficiaryDetails>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BENEFICIARYDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BENEFICIARYDETAILS;

				sql = sql.concat(BeneficiaryDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BeneficiaryDetails>)QueryUtil.list(
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
	 * Removes all the beneficiary detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BeneficiaryDetails beneficiaryDetails : findAll()) {
			remove(beneficiaryDetails);
		}
	}

	/**
	 * Returns the number of beneficiary detailses.
	 *
	 * @return the number of beneficiary detailses
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
					_SQL_COUNT_BENEFICIARYDETAILS);

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
		return "ODS_BENF_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BENEFICIARYDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BeneficiaryDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the beneficiary details persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new BeneficiaryDetailsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", BeneficiaryDetails.class.getName()));

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
		dummyEntityCache.removeCache(BeneficiaryDetailsImpl.class.getName());

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

	private static final String _SQL_SELECT_BENEFICIARYDETAILS =
		"SELECT beneficiaryDetails FROM BeneficiaryDetails beneficiaryDetails";

	private static final String _SQL_SELECT_BENEFICIARYDETAILS_WHERE =
		"SELECT beneficiaryDetails FROM BeneficiaryDetails beneficiaryDetails WHERE ";

	private static final String _SQL_COUNT_BENEFICIARYDETAILS =
		"SELECT COUNT(beneficiaryDetails) FROM BeneficiaryDetails beneficiaryDetails";

	private static final String _SQL_COUNT_BENEFICIARYDETAILS_WHERE =
		"SELECT COUNT(beneficiaryDetails) FROM BeneficiaryDetails beneficiaryDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "beneficiaryDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BeneficiaryDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BeneficiaryDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BeneficiaryDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"policyNo", "benfName", "benfPct", "benfRel", "benfId", "benfAge",
			"benfType"
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

	private static class BeneficiaryDetailsModelArgumentsResolver
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

			BeneficiaryDetailsModelImpl beneficiaryDetailsModelImpl =
				(BeneficiaryDetailsModelImpl)baseModel;

			long columnBitmask = beneficiaryDetailsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					beneficiaryDetailsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						beneficiaryDetailsModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					beneficiaryDetailsModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			BeneficiaryDetailsModelImpl beneficiaryDetailsModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						beneficiaryDetailsModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = beneficiaryDetailsModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}