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

import com.ejada.atmc.acl.db.exception.NoSuchPolicyMemberDetailsException;
import com.ejada.atmc.acl.db.model.PolicyMemberDetails;
import com.ejada.atmc.acl.db.model.impl.PolicyMemberDetailsImpl;
import com.ejada.atmc.acl.db.model.impl.PolicyMemberDetailsModelImpl;
import com.ejada.atmc.acl.db.service.persistence.PolicyMemberDetailsPersistence;
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
 * The persistence implementation for the policy member details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PolicyMemberDetailsPersistence.class)
public class PolicyMemberDetailsPersistenceImpl
	extends BasePersistenceImpl<PolicyMemberDetails>
	implements PolicyMemberDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PolicyMemberDetailsUtil</code> to access the policy member details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PolicyMemberDetailsImpl.class.getName();

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
	 * Returns all the policy member detailses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy member detailses
	 */
	@Override
	public List<PolicyMemberDetails> findByPolicyNo(String policyNo) {
		return findByPolicyNo(
			policyNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy member detailses where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyMemberDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy member detailses
	 * @param end the upper bound of the range of policy member detailses (not inclusive)
	 * @return the range of matching policy member detailses
	 */
	@Override
	public List<PolicyMemberDetails> findByPolicyNo(
		String policyNo, int start, int end) {

		return findByPolicyNo(policyNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy member detailses where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyMemberDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy member detailses
	 * @param end the upper bound of the range of policy member detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy member detailses
	 */
	@Override
	public List<PolicyMemberDetails> findByPolicyNo(
		String policyNo, int start, int end,
		OrderByComparator<PolicyMemberDetails> orderByComparator) {

		return findByPolicyNo(policyNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy member detailses where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyMemberDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy member detailses
	 * @param end the upper bound of the range of policy member detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy member detailses
	 */
	@Override
	public List<PolicyMemberDetails> findByPolicyNo(
		String policyNo, int start, int end,
		OrderByComparator<PolicyMemberDetails> orderByComparator,
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

		List<PolicyMemberDetails> list = null;

		if (useFinderCache) {
			list = (List<PolicyMemberDetails>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PolicyMemberDetails policyMemberDetails : list) {
					if (!policyNo.equals(policyMemberDetails.getPolicyNo())) {
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

			sb.append(_SQL_SELECT_POLICYMEMBERDETAILS_WHERE);

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
				sb.append(PolicyMemberDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<PolicyMemberDetails>)QueryUtil.list(
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
	 * Returns the first policy member details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy member details
	 * @throws NoSuchPolicyMemberDetailsException if a matching policy member details could not be found
	 */
	@Override
	public PolicyMemberDetails findByPolicyNo_First(
			String policyNo,
			OrderByComparator<PolicyMemberDetails> orderByComparator)
		throws NoSuchPolicyMemberDetailsException {

		PolicyMemberDetails policyMemberDetails = fetchByPolicyNo_First(
			policyNo, orderByComparator);

		if (policyMemberDetails != null) {
			return policyMemberDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNo=");
		sb.append(policyNo);

		sb.append("}");

		throw new NoSuchPolicyMemberDetailsException(sb.toString());
	}

	/**
	 * Returns the first policy member details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy member details, or <code>null</code> if a matching policy member details could not be found
	 */
	@Override
	public PolicyMemberDetails fetchByPolicyNo_First(
		String policyNo,
		OrderByComparator<PolicyMemberDetails> orderByComparator) {

		List<PolicyMemberDetails> list = findByPolicyNo(
			policyNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last policy member details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy member details
	 * @throws NoSuchPolicyMemberDetailsException if a matching policy member details could not be found
	 */
	@Override
	public PolicyMemberDetails findByPolicyNo_Last(
			String policyNo,
			OrderByComparator<PolicyMemberDetails> orderByComparator)
		throws NoSuchPolicyMemberDetailsException {

		PolicyMemberDetails policyMemberDetails = fetchByPolicyNo_Last(
			policyNo, orderByComparator);

		if (policyMemberDetails != null) {
			return policyMemberDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNo=");
		sb.append(policyNo);

		sb.append("}");

		throw new NoSuchPolicyMemberDetailsException(sb.toString());
	}

	/**
	 * Returns the last policy member details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy member details, or <code>null</code> if a matching policy member details could not be found
	 */
	@Override
	public PolicyMemberDetails fetchByPolicyNo_Last(
		String policyNo,
		OrderByComparator<PolicyMemberDetails> orderByComparator) {

		int count = countByPolicyNo(policyNo);

		if (count == 0) {
			return null;
		}

		List<PolicyMemberDetails> list = findByPolicyNo(
			policyNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the policy member detailses before and after the current policy member details in the ordered set where policyNo = &#63;.
	 *
	 * @param memberId the primary key of the current policy member details
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy member details
	 * @throws NoSuchPolicyMemberDetailsException if a policy member details with the primary key could not be found
	 */
	@Override
	public PolicyMemberDetails[] findByPolicyNo_PrevAndNext(
			long memberId, String policyNo,
			OrderByComparator<PolicyMemberDetails> orderByComparator)
		throws NoSuchPolicyMemberDetailsException {

		policyNo = Objects.toString(policyNo, "");

		PolicyMemberDetails policyMemberDetails = findByPrimaryKey(memberId);

		Session session = null;

		try {
			session = openSession();

			PolicyMemberDetails[] array = new PolicyMemberDetailsImpl[3];

			array[0] = getByPolicyNo_PrevAndNext(
				session, policyMemberDetails, policyNo, orderByComparator,
				true);

			array[1] = policyMemberDetails;

			array[2] = getByPolicyNo_PrevAndNext(
				session, policyMemberDetails, policyNo, orderByComparator,
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

	protected PolicyMemberDetails getByPolicyNo_PrevAndNext(
		Session session, PolicyMemberDetails policyMemberDetails,
		String policyNo,
		OrderByComparator<PolicyMemberDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_POLICYMEMBERDETAILS_WHERE);

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
			sb.append(PolicyMemberDetailsModelImpl.ORDER_BY_JPQL);
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
						policyMemberDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PolicyMemberDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the policy member detailses where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 */
	@Override
	public void removeByPolicyNo(String policyNo) {
		for (PolicyMemberDetails policyMemberDetails :
				findByPolicyNo(
					policyNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(policyMemberDetails);
		}
	}

	/**
	 * Returns the number of policy member detailses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching policy member detailses
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

			sb.append(_SQL_COUNT_POLICYMEMBERDETAILS_WHERE);

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
		"policyMemberDetails.policyNo = ?";

	private static final String _FINDER_COLUMN_POLICYNO_POLICYNO_3 =
		"(policyMemberDetails.policyNo IS NULL OR policyMemberDetails.policyNo = '')";

	public PolicyMemberDetailsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("policyNo", "ODS_POLICY_NO");
		dbColumnNames.put("memberName", "ODS_MEMBER_NAME");
		dbColumnNames.put("memberSi", "ODS_MEMBER_SI");
		dbColumnNames.put("memberId", "ODS_MEMBER_ID");
		dbColumnNames.put("memberGender", "ODS_MEMBER_GENDER");
		dbColumnNames.put("memberDob", "ODS_MEMBER_DOB");
		dbColumnNames.put("memberLimit", "ODS_MEMBER_LIMIT");

		setDBColumnNames(dbColumnNames);

		setModelClass(PolicyMemberDetails.class);

		setModelImplClass(PolicyMemberDetailsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the policy member details in the entity cache if it is enabled.
	 *
	 * @param policyMemberDetails the policy member details
	 */
	@Override
	public void cacheResult(PolicyMemberDetails policyMemberDetails) {
		dummyEntityCache.putResult(
			PolicyMemberDetailsImpl.class, policyMemberDetails.getPrimaryKey(),
			policyMemberDetails);
	}

	/**
	 * Caches the policy member detailses in the entity cache if it is enabled.
	 *
	 * @param policyMemberDetailses the policy member detailses
	 */
	@Override
	public void cacheResult(List<PolicyMemberDetails> policyMemberDetailses) {
		for (PolicyMemberDetails policyMemberDetails : policyMemberDetailses) {
			if (dummyEntityCache.getResult(
					PolicyMemberDetailsImpl.class,
					policyMemberDetails.getPrimaryKey()) == null) {

				cacheResult(policyMemberDetails);
			}
		}
	}

	/**
	 * Clears the cache for all policy member detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(PolicyMemberDetailsImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the policy member details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PolicyMemberDetails policyMemberDetails) {
		dummyEntityCache.removeResult(
			PolicyMemberDetailsImpl.class, policyMemberDetails);
	}

	@Override
	public void clearCache(List<PolicyMemberDetails> policyMemberDetailses) {
		for (PolicyMemberDetails policyMemberDetails : policyMemberDetailses) {
			dummyEntityCache.removeResult(
				PolicyMemberDetailsImpl.class, policyMemberDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				PolicyMemberDetailsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new policy member details with the primary key. Does not add the policy member details to the database.
	 *
	 * @param memberId the primary key for the new policy member details
	 * @return the new policy member details
	 */
	@Override
	public PolicyMemberDetails create(long memberId) {
		PolicyMemberDetails policyMemberDetails = new PolicyMemberDetailsImpl();

		policyMemberDetails.setNew(true);
		policyMemberDetails.setPrimaryKey(memberId);

		return policyMemberDetails;
	}

	/**
	 * Removes the policy member details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberId the primary key of the policy member details
	 * @return the policy member details that was removed
	 * @throws NoSuchPolicyMemberDetailsException if a policy member details with the primary key could not be found
	 */
	@Override
	public PolicyMemberDetails remove(long memberId)
		throws NoSuchPolicyMemberDetailsException {

		return remove((Serializable)memberId);
	}

	/**
	 * Removes the policy member details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the policy member details
	 * @return the policy member details that was removed
	 * @throws NoSuchPolicyMemberDetailsException if a policy member details with the primary key could not be found
	 */
	@Override
	public PolicyMemberDetails remove(Serializable primaryKey)
		throws NoSuchPolicyMemberDetailsException {

		Session session = null;

		try {
			session = openSession();

			PolicyMemberDetails policyMemberDetails =
				(PolicyMemberDetails)session.get(
					PolicyMemberDetailsImpl.class, primaryKey);

			if (policyMemberDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPolicyMemberDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(policyMemberDetails);
		}
		catch (NoSuchPolicyMemberDetailsException noSuchEntityException) {
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
	protected PolicyMemberDetails removeImpl(
		PolicyMemberDetails policyMemberDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(policyMemberDetails)) {
				policyMemberDetails = (PolicyMemberDetails)session.get(
					PolicyMemberDetailsImpl.class,
					policyMemberDetails.getPrimaryKeyObj());
			}

			if (policyMemberDetails != null) {
				session.delete(policyMemberDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (policyMemberDetails != null) {
			clearCache(policyMemberDetails);
		}

		return policyMemberDetails;
	}

	@Override
	public PolicyMemberDetails updateImpl(
		PolicyMemberDetails policyMemberDetails) {

		boolean isNew = policyMemberDetails.isNew();

		if (!(policyMemberDetails instanceof PolicyMemberDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(policyMemberDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					policyMemberDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in policyMemberDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PolicyMemberDetails implementation " +
					policyMemberDetails.getClass());
		}

		PolicyMemberDetailsModelImpl policyMemberDetailsModelImpl =
			(PolicyMemberDetailsModelImpl)policyMemberDetails;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(policyMemberDetails);
			}
			else {
				policyMemberDetails = (PolicyMemberDetails)session.merge(
					policyMemberDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			PolicyMemberDetailsImpl.class, policyMemberDetailsModelImpl, false,
			true);

		if (isNew) {
			policyMemberDetails.setNew(false);
		}

		policyMemberDetails.resetOriginalValues();

		return policyMemberDetails;
	}

	/**
	 * Returns the policy member details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the policy member details
	 * @return the policy member details
	 * @throws NoSuchPolicyMemberDetailsException if a policy member details with the primary key could not be found
	 */
	@Override
	public PolicyMemberDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPolicyMemberDetailsException {

		PolicyMemberDetails policyMemberDetails = fetchByPrimaryKey(primaryKey);

		if (policyMemberDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPolicyMemberDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return policyMemberDetails;
	}

	/**
	 * Returns the policy member details with the primary key or throws a <code>NoSuchPolicyMemberDetailsException</code> if it could not be found.
	 *
	 * @param memberId the primary key of the policy member details
	 * @return the policy member details
	 * @throws NoSuchPolicyMemberDetailsException if a policy member details with the primary key could not be found
	 */
	@Override
	public PolicyMemberDetails findByPrimaryKey(long memberId)
		throws NoSuchPolicyMemberDetailsException {

		return findByPrimaryKey((Serializable)memberId);
	}

	/**
	 * Returns the policy member details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberId the primary key of the policy member details
	 * @return the policy member details, or <code>null</code> if a policy member details with the primary key could not be found
	 */
	@Override
	public PolicyMemberDetails fetchByPrimaryKey(long memberId) {
		return fetchByPrimaryKey((Serializable)memberId);
	}

	/**
	 * Returns all the policy member detailses.
	 *
	 * @return the policy member detailses
	 */
	@Override
	public List<PolicyMemberDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy member detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyMemberDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy member detailses
	 * @param end the upper bound of the range of policy member detailses (not inclusive)
	 * @return the range of policy member detailses
	 */
	@Override
	public List<PolicyMemberDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy member detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyMemberDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy member detailses
	 * @param end the upper bound of the range of policy member detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy member detailses
	 */
	@Override
	public List<PolicyMemberDetails> findAll(
		int start, int end,
		OrderByComparator<PolicyMemberDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy member detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyMemberDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy member detailses
	 * @param end the upper bound of the range of policy member detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy member detailses
	 */
	@Override
	public List<PolicyMemberDetails> findAll(
		int start, int end,
		OrderByComparator<PolicyMemberDetails> orderByComparator,
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

		List<PolicyMemberDetails> list = null;

		if (useFinderCache) {
			list = (List<PolicyMemberDetails>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_POLICYMEMBERDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_POLICYMEMBERDETAILS;

				sql = sql.concat(PolicyMemberDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PolicyMemberDetails>)QueryUtil.list(
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
	 * Removes all the policy member detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PolicyMemberDetails policyMemberDetails : findAll()) {
			remove(policyMemberDetails);
		}
	}

	/**
	 * Returns the number of policy member detailses.
	 *
	 * @return the number of policy member detailses
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
					_SQL_COUNT_POLICYMEMBERDETAILS);

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
		return "ODS_MEMBER_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_POLICYMEMBERDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PolicyMemberDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the policy member details persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new PolicyMemberDetailsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PolicyMemberDetails.class.getName()));

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
		dummyEntityCache.removeCache(PolicyMemberDetailsImpl.class.getName());

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

	private static final String _SQL_SELECT_POLICYMEMBERDETAILS =
		"SELECT policyMemberDetails FROM PolicyMemberDetails policyMemberDetails";

	private static final String _SQL_SELECT_POLICYMEMBERDETAILS_WHERE =
		"SELECT policyMemberDetails FROM PolicyMemberDetails policyMemberDetails WHERE ";

	private static final String _SQL_COUNT_POLICYMEMBERDETAILS =
		"SELECT COUNT(policyMemberDetails) FROM PolicyMemberDetails policyMemberDetails";

	private static final String _SQL_COUNT_POLICYMEMBERDETAILS_WHERE =
		"SELECT COUNT(policyMemberDetails) FROM PolicyMemberDetails policyMemberDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "policyMemberDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PolicyMemberDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PolicyMemberDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PolicyMemberDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"policyNo", "memberName", "memberSi", "memberId", "memberGender",
			"memberDob", "memberLimit"
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

	private static class PolicyMemberDetailsModelArgumentsResolver
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

			PolicyMemberDetailsModelImpl policyMemberDetailsModelImpl =
				(PolicyMemberDetailsModelImpl)baseModel;

			long columnBitmask =
				policyMemberDetailsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					policyMemberDetailsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						policyMemberDetailsModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					policyMemberDetailsModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PolicyMemberDetailsModelImpl policyMemberDetailsModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						policyMemberDetailsModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = policyMemberDetailsModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}