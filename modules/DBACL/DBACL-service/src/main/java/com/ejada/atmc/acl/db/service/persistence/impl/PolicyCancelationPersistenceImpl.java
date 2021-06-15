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

import com.ejada.atmc.acl.db.exception.NoSuchPolicyCancelationException;
import com.ejada.atmc.acl.db.model.PolicyCancelation;
import com.ejada.atmc.acl.db.model.impl.PolicyCancelationImpl;
import com.ejada.atmc.acl.db.model.impl.PolicyCancelationModelImpl;
import com.ejada.atmc.acl.db.service.persistence.PolicyCancelationPersistence;
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
 * The persistence implementation for the policy cancelation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PolicyCancelationPersistence.class)
public class PolicyCancelationPersistenceImpl
	extends BasePersistenceImpl<PolicyCancelation>
	implements PolicyCancelationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PolicyCancelationUtil</code> to access the policy cancelation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PolicyCancelationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBypolicyNum;
	private FinderPath _finderPathCountBypolicyNum;

	/**
	 * Returns the policy cancelation where policyNumber = &#63; or throws a <code>NoSuchPolicyCancelationException</code> if it could not be found.
	 *
	 * @param policyNumber the policy number
	 * @return the matching policy cancelation
	 * @throws NoSuchPolicyCancelationException if a matching policy cancelation could not be found
	 */
	@Override
	public PolicyCancelation findBypolicyNum(String policyNumber)
		throws NoSuchPolicyCancelationException {

		PolicyCancelation policyCancelation = fetchBypolicyNum(policyNumber);

		if (policyCancelation == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("policyNumber=");
			sb.append(policyNumber);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPolicyCancelationException(sb.toString());
		}

		return policyCancelation;
	}

	/**
	 * Returns the policy cancelation where policyNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyNumber the policy number
	 * @return the matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	@Override
	public PolicyCancelation fetchBypolicyNum(String policyNumber) {
		return fetchBypolicyNum(policyNumber, true);
	}

	/**
	 * Returns the policy cancelation where policyNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyNumber the policy number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	@Override
	public PolicyCancelation fetchBypolicyNum(
		String policyNumber, boolean useFinderCache) {

		policyNumber = Objects.toString(policyNumber, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {policyNumber};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchBypolicyNum, finderArgs, this);
		}

		if (result instanceof PolicyCancelation) {
			PolicyCancelation policyCancelation = (PolicyCancelation)result;

			if (!Objects.equals(
					policyNumber, policyCancelation.getPolicyNumber())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_POLICYCANCELATION_WHERE);

			boolean bindPolicyNumber = false;

			if (policyNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYNUM_POLICYNUMBER_3);
			}
			else {
				bindPolicyNumber = true;

				sb.append(_FINDER_COLUMN_POLICYNUM_POLICYNUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPolicyNumber) {
					queryPos.add(policyNumber);
				}

				List<PolicyCancelation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchBypolicyNum, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {policyNumber};
							}

							_log.warn(
								"PolicyCancelationPersistenceImpl.fetchBypolicyNum(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PolicyCancelation policyCancelation = list.get(0);

					result = policyCancelation;

					cacheResult(policyCancelation);
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
			return (PolicyCancelation)result;
		}
	}

	/**
	 * Removes the policy cancelation where policyNumber = &#63; from the database.
	 *
	 * @param policyNumber the policy number
	 * @return the policy cancelation that was removed
	 */
	@Override
	public PolicyCancelation removeBypolicyNum(String policyNumber)
		throws NoSuchPolicyCancelationException {

		PolicyCancelation policyCancelation = findBypolicyNum(policyNumber);

		return remove(policyCancelation);
	}

	/**
	 * Returns the number of policy cancelations where policyNumber = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @return the number of matching policy cancelations
	 */
	@Override
	public int countBypolicyNum(String policyNumber) {
		policyNumber = Objects.toString(policyNumber, "");

		FinderPath finderPath = _finderPathCountBypolicyNum;

		Object[] finderArgs = new Object[] {policyNumber};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POLICYCANCELATION_WHERE);

			boolean bindPolicyNumber = false;

			if (policyNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYNUM_POLICYNUMBER_3);
			}
			else {
				bindPolicyNumber = true;

				sb.append(_FINDER_COLUMN_POLICYNUM_POLICYNUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPolicyNumber) {
					queryPos.add(policyNumber);
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

	private static final String _FINDER_COLUMN_POLICYNUM_POLICYNUMBER_2 =
		"policyCancelation.policyNumber = ?";

	private static final String _FINDER_COLUMN_POLICYNUM_POLICYNUMBER_3 =
		"(policyCancelation.policyNumber IS NULL OR policyCancelation.policyNumber = '')";

	private FinderPath _finderPathWithPaginationFindByinsuredId;
	private FinderPath _finderPathWithoutPaginationFindByinsuredId;
	private FinderPath _finderPathCountByinsuredId;

	/**
	 * Returns all the policy cancelations where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @return the matching policy cancelations
	 */
	@Override
	public List<PolicyCancelation> findByinsuredId(String insuredId) {
		return findByinsuredId(
			insuredId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy cancelations where insuredId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @return the range of matching policy cancelations
	 */
	@Override
	public List<PolicyCancelation> findByinsuredId(
		String insuredId, int start, int end) {

		return findByinsuredId(insuredId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy cancelations where insuredId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy cancelations
	 */
	@Override
	public List<PolicyCancelation> findByinsuredId(
		String insuredId, int start, int end,
		OrderByComparator<PolicyCancelation> orderByComparator) {

		return findByinsuredId(insuredId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy cancelations where insuredId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy cancelations
	 */
	@Override
	public List<PolicyCancelation> findByinsuredId(
		String insuredId, int start, int end,
		OrderByComparator<PolicyCancelation> orderByComparator,
		boolean useFinderCache) {

		insuredId = Objects.toString(insuredId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByinsuredId;
				finderArgs = new Object[] {insuredId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByinsuredId;
			finderArgs = new Object[] {
				insuredId, start, end, orderByComparator
			};
		}

		List<PolicyCancelation> list = null;

		if (useFinderCache) {
			list = (List<PolicyCancelation>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PolicyCancelation policyCancelation : list) {
					if (!insuredId.equals(policyCancelation.getInsuredId())) {
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

			sb.append(_SQL_SELECT_POLICYCANCELATION_WHERE);

			boolean bindInsuredId = false;

			if (insuredId.isEmpty()) {
				sb.append(_FINDER_COLUMN_INSUREDID_INSUREDID_3);
			}
			else {
				bindInsuredId = true;

				sb.append(_FINDER_COLUMN_INSUREDID_INSUREDID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PolicyCancelationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindInsuredId) {
					queryPos.add(insuredId);
				}

				list = (List<PolicyCancelation>)QueryUtil.list(
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
	 * Returns the first policy cancelation in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy cancelation
	 * @throws NoSuchPolicyCancelationException if a matching policy cancelation could not be found
	 */
	@Override
	public PolicyCancelation findByinsuredId_First(
			String insuredId,
			OrderByComparator<PolicyCancelation> orderByComparator)
		throws NoSuchPolicyCancelationException {

		PolicyCancelation policyCancelation = fetchByinsuredId_First(
			insuredId, orderByComparator);

		if (policyCancelation != null) {
			return policyCancelation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("insuredId=");
		sb.append(insuredId);

		sb.append("}");

		throw new NoSuchPolicyCancelationException(sb.toString());
	}

	/**
	 * Returns the first policy cancelation in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	@Override
	public PolicyCancelation fetchByinsuredId_First(
		String insuredId,
		OrderByComparator<PolicyCancelation> orderByComparator) {

		List<PolicyCancelation> list = findByinsuredId(
			insuredId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last policy cancelation in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy cancelation
	 * @throws NoSuchPolicyCancelationException if a matching policy cancelation could not be found
	 */
	@Override
	public PolicyCancelation findByinsuredId_Last(
			String insuredId,
			OrderByComparator<PolicyCancelation> orderByComparator)
		throws NoSuchPolicyCancelationException {

		PolicyCancelation policyCancelation = fetchByinsuredId_Last(
			insuredId, orderByComparator);

		if (policyCancelation != null) {
			return policyCancelation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("insuredId=");
		sb.append(insuredId);

		sb.append("}");

		throw new NoSuchPolicyCancelationException(sb.toString());
	}

	/**
	 * Returns the last policy cancelation in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	@Override
	public PolicyCancelation fetchByinsuredId_Last(
		String insuredId,
		OrderByComparator<PolicyCancelation> orderByComparator) {

		int count = countByinsuredId(insuredId);

		if (count == 0) {
			return null;
		}

		List<PolicyCancelation> list = findByinsuredId(
			insuredId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the policy cancelations before and after the current policy cancelation in the ordered set where insuredId = &#63;.
	 *
	 * @param Id the primary key of the current policy cancelation
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy cancelation
	 * @throws NoSuchPolicyCancelationException if a policy cancelation with the primary key could not be found
	 */
	@Override
	public PolicyCancelation[] findByinsuredId_PrevAndNext(
			String Id, String insuredId,
			OrderByComparator<PolicyCancelation> orderByComparator)
		throws NoSuchPolicyCancelationException {

		insuredId = Objects.toString(insuredId, "");

		PolicyCancelation policyCancelation = findByPrimaryKey(Id);

		Session session = null;

		try {
			session = openSession();

			PolicyCancelation[] array = new PolicyCancelationImpl[3];

			array[0] = getByinsuredId_PrevAndNext(
				session, policyCancelation, insuredId, orderByComparator, true);

			array[1] = policyCancelation;

			array[2] = getByinsuredId_PrevAndNext(
				session, policyCancelation, insuredId, orderByComparator,
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

	protected PolicyCancelation getByinsuredId_PrevAndNext(
		Session session, PolicyCancelation policyCancelation, String insuredId,
		OrderByComparator<PolicyCancelation> orderByComparator,
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

		sb.append(_SQL_SELECT_POLICYCANCELATION_WHERE);

		boolean bindInsuredId = false;

		if (insuredId.isEmpty()) {
			sb.append(_FINDER_COLUMN_INSUREDID_INSUREDID_3);
		}
		else {
			bindInsuredId = true;

			sb.append(_FINDER_COLUMN_INSUREDID_INSUREDID_2);
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
			sb.append(PolicyCancelationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindInsuredId) {
			queryPos.add(insuredId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						policyCancelation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PolicyCancelation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the policy cancelations where insuredId = &#63; from the database.
	 *
	 * @param insuredId the insured ID
	 */
	@Override
	public void removeByinsuredId(String insuredId) {
		for (PolicyCancelation policyCancelation :
				findByinsuredId(
					insuredId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(policyCancelation);
		}
	}

	/**
	 * Returns the number of policy cancelations where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @return the number of matching policy cancelations
	 */
	@Override
	public int countByinsuredId(String insuredId) {
		insuredId = Objects.toString(insuredId, "");

		FinderPath finderPath = _finderPathCountByinsuredId;

		Object[] finderArgs = new Object[] {insuredId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POLICYCANCELATION_WHERE);

			boolean bindInsuredId = false;

			if (insuredId.isEmpty()) {
				sb.append(_FINDER_COLUMN_INSUREDID_INSUREDID_3);
			}
			else {
				bindInsuredId = true;

				sb.append(_FINDER_COLUMN_INSUREDID_INSUREDID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindInsuredId) {
					queryPos.add(insuredId);
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

	private static final String _FINDER_COLUMN_INSUREDID_INSUREDID_2 =
		"policyCancelation.insuredId = ?";

	private static final String _FINDER_COLUMN_INSUREDID_INSUREDID_3 =
		"(policyCancelation.insuredId IS NULL OR policyCancelation.insuredId = '')";

	private FinderPath _finderPathWithPaginationFindBystatusAll;
	private FinderPath _finderPathWithoutPaginationFindBystatusAll;
	private FinderPath _finderPathCountBystatusAll;

	/**
	 * Returns all the policy cancelations where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching policy cancelations
	 */
	@Override
	public List<PolicyCancelation> findBystatusAll(String status) {
		return findBystatusAll(
			status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy cancelations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @return the range of matching policy cancelations
	 */
	@Override
	public List<PolicyCancelation> findBystatusAll(
		String status, int start, int end) {

		return findBystatusAll(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy cancelations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy cancelations
	 */
	@Override
	public List<PolicyCancelation> findBystatusAll(
		String status, int start, int end,
		OrderByComparator<PolicyCancelation> orderByComparator) {

		return findBystatusAll(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy cancelations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy cancelations
	 */
	@Override
	public List<PolicyCancelation> findBystatusAll(
		String status, int start, int end,
		OrderByComparator<PolicyCancelation> orderByComparator,
		boolean useFinderCache) {

		status = Objects.toString(status, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBystatusAll;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBystatusAll;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<PolicyCancelation> list = null;

		if (useFinderCache) {
			list = (List<PolicyCancelation>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PolicyCancelation policyCancelation : list) {
					if (!status.equals(policyCancelation.getStatus())) {
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

			sb.append(_SQL_SELECT_POLICYCANCELATION_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUSALL_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_STATUSALL_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PolicyCancelationModelImpl.ORDER_BY_JPQL);
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

				list = (List<PolicyCancelation>)QueryUtil.list(
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
	 * Returns the first policy cancelation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy cancelation
	 * @throws NoSuchPolicyCancelationException if a matching policy cancelation could not be found
	 */
	@Override
	public PolicyCancelation findBystatusAll_First(
			String status,
			OrderByComparator<PolicyCancelation> orderByComparator)
		throws NoSuchPolicyCancelationException {

		PolicyCancelation policyCancelation = fetchBystatusAll_First(
			status, orderByComparator);

		if (policyCancelation != null) {
			return policyCancelation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchPolicyCancelationException(sb.toString());
	}

	/**
	 * Returns the first policy cancelation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	@Override
	public PolicyCancelation fetchBystatusAll_First(
		String status, OrderByComparator<PolicyCancelation> orderByComparator) {

		List<PolicyCancelation> list = findBystatusAll(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last policy cancelation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy cancelation
	 * @throws NoSuchPolicyCancelationException if a matching policy cancelation could not be found
	 */
	@Override
	public PolicyCancelation findBystatusAll_Last(
			String status,
			OrderByComparator<PolicyCancelation> orderByComparator)
		throws NoSuchPolicyCancelationException {

		PolicyCancelation policyCancelation = fetchBystatusAll_Last(
			status, orderByComparator);

		if (policyCancelation != null) {
			return policyCancelation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchPolicyCancelationException(sb.toString());
	}

	/**
	 * Returns the last policy cancelation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	@Override
	public PolicyCancelation fetchBystatusAll_Last(
		String status, OrderByComparator<PolicyCancelation> orderByComparator) {

		int count = countBystatusAll(status);

		if (count == 0) {
			return null;
		}

		List<PolicyCancelation> list = findBystatusAll(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the policy cancelations before and after the current policy cancelation in the ordered set where status = &#63;.
	 *
	 * @param Id the primary key of the current policy cancelation
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy cancelation
	 * @throws NoSuchPolicyCancelationException if a policy cancelation with the primary key could not be found
	 */
	@Override
	public PolicyCancelation[] findBystatusAll_PrevAndNext(
			String Id, String status,
			OrderByComparator<PolicyCancelation> orderByComparator)
		throws NoSuchPolicyCancelationException {

		status = Objects.toString(status, "");

		PolicyCancelation policyCancelation = findByPrimaryKey(Id);

		Session session = null;

		try {
			session = openSession();

			PolicyCancelation[] array = new PolicyCancelationImpl[3];

			array[0] = getBystatusAll_PrevAndNext(
				session, policyCancelation, status, orderByComparator, true);

			array[1] = policyCancelation;

			array[2] = getBystatusAll_PrevAndNext(
				session, policyCancelation, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PolicyCancelation getBystatusAll_PrevAndNext(
		Session session, PolicyCancelation policyCancelation, String status,
		OrderByComparator<PolicyCancelation> orderByComparator,
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

		sb.append(_SQL_SELECT_POLICYCANCELATION_WHERE);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			sb.append(_FINDER_COLUMN_STATUSALL_STATUS_3);
		}
		else {
			bindStatus = true;

			sb.append(_FINDER_COLUMN_STATUSALL_STATUS_2);
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
			sb.append(PolicyCancelationModelImpl.ORDER_BY_JPQL);
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
						policyCancelation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PolicyCancelation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the policy cancelations where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeBystatusAll(String status) {
		for (PolicyCancelation policyCancelation :
				findBystatusAll(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(policyCancelation);
		}
	}

	/**
	 * Returns the number of policy cancelations where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching policy cancelations
	 */
	@Override
	public int countBystatusAll(String status) {
		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountBystatusAll;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POLICYCANCELATION_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUSALL_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_STATUSALL_STATUS_2);
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

	private static final String _FINDER_COLUMN_STATUSALL_STATUS_2 =
		"policyCancelation.status = ?";

	private static final String _FINDER_COLUMN_STATUSALL_STATUS_3 =
		"(policyCancelation.status IS NULL OR policyCancelation.status = '')";

	private FinderPath _finderPathFetchBystatus;
	private FinderPath _finderPathCountBystatus;

	/**
	 * Returns the policy cancelation where status = &#63; or throws a <code>NoSuchPolicyCancelationException</code> if it could not be found.
	 *
	 * @param status the status
	 * @return the matching policy cancelation
	 * @throws NoSuchPolicyCancelationException if a matching policy cancelation could not be found
	 */
	@Override
	public PolicyCancelation findBystatus(String status)
		throws NoSuchPolicyCancelationException {

		PolicyCancelation policyCancelation = fetchBystatus(status);

		if (policyCancelation == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("status=");
			sb.append(status);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPolicyCancelationException(sb.toString());
		}

		return policyCancelation;
	}

	/**
	 * Returns the policy cancelation where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param status the status
	 * @return the matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	@Override
	public PolicyCancelation fetchBystatus(String status) {
		return fetchBystatus(status, true);
	}

	/**
	 * Returns the policy cancelation where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	@Override
	public PolicyCancelation fetchBystatus(
		String status, boolean useFinderCache) {

		status = Objects.toString(status, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {status};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchBystatus, finderArgs, this);
		}

		if (result instanceof PolicyCancelation) {
			PolicyCancelation policyCancelation = (PolicyCancelation)result;

			if (!Objects.equals(status, policyCancelation.getStatus())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_POLICYCANCELATION_WHERE);

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

				List<PolicyCancelation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchBystatus, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {status};
							}

							_log.warn(
								"PolicyCancelationPersistenceImpl.fetchBystatus(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PolicyCancelation policyCancelation = list.get(0);

					result = policyCancelation;

					cacheResult(policyCancelation);
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
			return (PolicyCancelation)result;
		}
	}

	/**
	 * Removes the policy cancelation where status = &#63; from the database.
	 *
	 * @param status the status
	 * @return the policy cancelation that was removed
	 */
	@Override
	public PolicyCancelation removeBystatus(String status)
		throws NoSuchPolicyCancelationException {

		PolicyCancelation policyCancelation = findBystatus(status);

		return remove(policyCancelation);
	}

	/**
	 * Returns the number of policy cancelations where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching policy cancelations
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

			sb.append(_SQL_COUNT_POLICYCANCELATION_WHERE);

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
		"policyCancelation.status = ?";

	private static final String _FINDER_COLUMN_STATUS_STATUS_3 =
		"(policyCancelation.status IS NULL OR policyCancelation.status = '')";

	public PolicyCancelationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("Id", "ID");
		dbColumnNames.put("policyNumber", "POLICYNUMBER");
		dbColumnNames.put("policyExpiryDate", "POLICYEXPIRYDATE");
		dbColumnNames.put("insuredId", "INSUREDID");
		dbColumnNames.put("insuredName", "INSUREDNAME");
		dbColumnNames.put("vehicleSequence", "VEHICLESEQ");
		dbColumnNames.put("vehicleChessisNo", "CHESSISNUMBER");
		dbColumnNames.put("cancllationReqDate", "CANCELLATIONREQDATE");
		dbColumnNames.put("reason", "CANCELLATIONREASON");
		dbColumnNames.put("servicemessage", "SERVICE_MESSAGE");
		dbColumnNames.put("cancellationEffdate", "CANCELLATIONEFFDATE");
		dbColumnNames.put("ibanImage", "IBANFILE");
		dbColumnNames.put("validFile", "VALIDFILE");
		dbColumnNames.put("otherFile", "OTHERFILE");
		dbColumnNames.put("vehMake", "VEHMAKE");
		dbColumnNames.put("vehModel", "VEHMODEL");
		dbColumnNames.put("plateNumber", "PLATE_NUMBER");
		dbColumnNames.put("anyAccident", "ANY_ACCIDENT");
		dbColumnNames.put("lodgeClaim", "LODGE_CLAIM");
		dbColumnNames.put("ibanFileName", "IBAN_FILE_NAME");
		dbColumnNames.put("validFileName", "VALID_FILE_NAME");
		dbColumnNames.put("policyInceptionDate", "POLICY_INCEPTION_DATE");
		dbColumnNames.put("insuredEmail", "INSURED_EMAIL");
		dbColumnNames.put("insuredMobile", "INSURED_MOBILE");
		dbColumnNames.put("rejReason", "REJ_REASON");

		setDBColumnNames(dbColumnNames);

		setModelClass(PolicyCancelation.class);

		setModelImplClass(PolicyCancelationImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the policy cancelation in the entity cache if it is enabled.
	 *
	 * @param policyCancelation the policy cancelation
	 */
	@Override
	public void cacheResult(PolicyCancelation policyCancelation) {
		dummyEntityCache.putResult(
			PolicyCancelationImpl.class, policyCancelation.getPrimaryKey(),
			policyCancelation);

		dummyFinderCache.putResult(
			_finderPathFetchBypolicyNum,
			new Object[] {policyCancelation.getPolicyNumber()},
			policyCancelation);

		dummyFinderCache.putResult(
			_finderPathFetchBystatus,
			new Object[] {policyCancelation.getStatus()}, policyCancelation);
	}

	/**
	 * Caches the policy cancelations in the entity cache if it is enabled.
	 *
	 * @param policyCancelations the policy cancelations
	 */
	@Override
	public void cacheResult(List<PolicyCancelation> policyCancelations) {
		for (PolicyCancelation policyCancelation : policyCancelations) {
			if (dummyEntityCache.getResult(
					PolicyCancelationImpl.class,
					policyCancelation.getPrimaryKey()) == null) {

				cacheResult(policyCancelation);
			}
		}
	}

	/**
	 * Clears the cache for all policy cancelations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(PolicyCancelationImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the policy cancelation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PolicyCancelation policyCancelation) {
		dummyEntityCache.removeResult(
			PolicyCancelationImpl.class, policyCancelation);
	}

	@Override
	public void clearCache(List<PolicyCancelation> policyCancelations) {
		for (PolicyCancelation policyCancelation : policyCancelations) {
			dummyEntityCache.removeResult(
				PolicyCancelationImpl.class, policyCancelation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				PolicyCancelationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PolicyCancelationModelImpl policyCancelationModelImpl) {

		Object[] args = new Object[] {
			policyCancelationModelImpl.getPolicyNumber()
		};

		dummyFinderCache.putResult(
			_finderPathCountBypolicyNum, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchBypolicyNum, args, policyCancelationModelImpl,
			false);

		args = new Object[] {policyCancelationModelImpl.getStatus()};

		dummyFinderCache.putResult(
			_finderPathCountBystatus, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchBystatus, args, policyCancelationModelImpl, false);
	}

	/**
	 * Creates a new policy cancelation with the primary key. Does not add the policy cancelation to the database.
	 *
	 * @param Id the primary key for the new policy cancelation
	 * @return the new policy cancelation
	 */
	@Override
	public PolicyCancelation create(String Id) {
		PolicyCancelation policyCancelation = new PolicyCancelationImpl();

		policyCancelation.setNew(true);
		policyCancelation.setPrimaryKey(Id);

		return policyCancelation;
	}

	/**
	 * Removes the policy cancelation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the policy cancelation
	 * @return the policy cancelation that was removed
	 * @throws NoSuchPolicyCancelationException if a policy cancelation with the primary key could not be found
	 */
	@Override
	public PolicyCancelation remove(String Id)
		throws NoSuchPolicyCancelationException {

		return remove((Serializable)Id);
	}

	/**
	 * Removes the policy cancelation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the policy cancelation
	 * @return the policy cancelation that was removed
	 * @throws NoSuchPolicyCancelationException if a policy cancelation with the primary key could not be found
	 */
	@Override
	public PolicyCancelation remove(Serializable primaryKey)
		throws NoSuchPolicyCancelationException {

		Session session = null;

		try {
			session = openSession();

			PolicyCancelation policyCancelation =
				(PolicyCancelation)session.get(
					PolicyCancelationImpl.class, primaryKey);

			if (policyCancelation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPolicyCancelationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(policyCancelation);
		}
		catch (NoSuchPolicyCancelationException noSuchEntityException) {
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
	protected PolicyCancelation removeImpl(
		PolicyCancelation policyCancelation) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(policyCancelation)) {
				policyCancelation = (PolicyCancelation)session.get(
					PolicyCancelationImpl.class,
					policyCancelation.getPrimaryKeyObj());
			}

			if (policyCancelation != null) {
				session.delete(policyCancelation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (policyCancelation != null) {
			clearCache(policyCancelation);
		}

		return policyCancelation;
	}

	@Override
	public PolicyCancelation updateImpl(PolicyCancelation policyCancelation) {
		boolean isNew = policyCancelation.isNew();

		if (!(policyCancelation instanceof PolicyCancelationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(policyCancelation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					policyCancelation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in policyCancelation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PolicyCancelation implementation " +
					policyCancelation.getClass());
		}

		PolicyCancelationModelImpl policyCancelationModelImpl =
			(PolicyCancelationModelImpl)policyCancelation;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(policyCancelation);
			}
			else {
				session.evict(
					PolicyCancelationImpl.class,
					policyCancelation.getPrimaryKeyObj());

				session.saveOrUpdate(policyCancelation);
			}

			session.flush();
			session.clear();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			PolicyCancelationImpl.class, policyCancelationModelImpl, false,
			true);

		cacheUniqueFindersCache(policyCancelationModelImpl);

		if (isNew) {
			policyCancelation.setNew(false);
		}

		policyCancelation.resetOriginalValues();

		return policyCancelation;
	}

	/**
	 * Returns the policy cancelation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the policy cancelation
	 * @return the policy cancelation
	 * @throws NoSuchPolicyCancelationException if a policy cancelation with the primary key could not be found
	 */
	@Override
	public PolicyCancelation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPolicyCancelationException {

		PolicyCancelation policyCancelation = fetchByPrimaryKey(primaryKey);

		if (policyCancelation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPolicyCancelationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return policyCancelation;
	}

	/**
	 * Returns the policy cancelation with the primary key or throws a <code>NoSuchPolicyCancelationException</code> if it could not be found.
	 *
	 * @param Id the primary key of the policy cancelation
	 * @return the policy cancelation
	 * @throws NoSuchPolicyCancelationException if a policy cancelation with the primary key could not be found
	 */
	@Override
	public PolicyCancelation findByPrimaryKey(String Id)
		throws NoSuchPolicyCancelationException {

		return findByPrimaryKey((Serializable)Id);
	}

	/**
	 * Returns the policy cancelation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the policy cancelation
	 * @return the policy cancelation, or <code>null</code> if a policy cancelation with the primary key could not be found
	 */
	@Override
	public PolicyCancelation fetchByPrimaryKey(String Id) {
		return fetchByPrimaryKey((Serializable)Id);
	}

	/**
	 * Returns all the policy cancelations.
	 *
	 * @return the policy cancelations
	 */
	@Override
	public List<PolicyCancelation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy cancelations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @return the range of policy cancelations
	 */
	@Override
	public List<PolicyCancelation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy cancelations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy cancelations
	 */
	@Override
	public List<PolicyCancelation> findAll(
		int start, int end,
		OrderByComparator<PolicyCancelation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy cancelations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy cancelations
	 */
	@Override
	public List<PolicyCancelation> findAll(
		int start, int end,
		OrderByComparator<PolicyCancelation> orderByComparator,
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

		List<PolicyCancelation> list = null;

		if (useFinderCache) {
			list = (List<PolicyCancelation>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_POLICYCANCELATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_POLICYCANCELATION;

				sql = sql.concat(PolicyCancelationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PolicyCancelation>)QueryUtil.list(
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
	 * Removes all the policy cancelations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PolicyCancelation policyCancelation : findAll()) {
			remove(policyCancelation);
		}
	}

	/**
	 * Returns the number of policy cancelations.
	 *
	 * @return the number of policy cancelations
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_POLICYCANCELATION);

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
		return _SQL_SELECT_POLICYCANCELATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PolicyCancelationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the policy cancelation persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new PolicyCancelationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PolicyCancelation.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchBypolicyNum = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBypolicyNum",
			new String[] {String.class.getName()},
			new String[] {"POLICYNUMBER"}, true);

		_finderPathCountBypolicyNum = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypolicyNum",
			new String[] {String.class.getName()},
			new String[] {"POLICYNUMBER"}, false);

		_finderPathWithPaginationFindByinsuredId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByinsuredId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"INSUREDID"}, true);

		_finderPathWithoutPaginationFindByinsuredId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByinsuredId",
			new String[] {String.class.getName()}, new String[] {"INSUREDID"},
			true);

		_finderPathCountByinsuredId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByinsuredId",
			new String[] {String.class.getName()}, new String[] {"INSUREDID"},
			false);

		_finderPathWithPaginationFindBystatusAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatusAll",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindBystatusAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatusAll",
			new String[] {String.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountBystatusAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatusAll",
			new String[] {String.class.getName()}, new String[] {"status"},
			false);

		_finderPathFetchBystatus = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBystatus",
			new String[] {String.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountBystatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] {String.class.getName()}, new String[] {"status"},
			false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(PolicyCancelationImpl.class.getName());

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

	private static final String _SQL_SELECT_POLICYCANCELATION =
		"SELECT policyCancelation FROM PolicyCancelation policyCancelation";

	private static final String _SQL_SELECT_POLICYCANCELATION_WHERE =
		"SELECT policyCancelation FROM PolicyCancelation policyCancelation WHERE ";

	private static final String _SQL_COUNT_POLICYCANCELATION =
		"SELECT COUNT(policyCancelation) FROM PolicyCancelation policyCancelation";

	private static final String _SQL_COUNT_POLICYCANCELATION_WHERE =
		"SELECT COUNT(policyCancelation) FROM PolicyCancelation policyCancelation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "policyCancelation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PolicyCancelation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PolicyCancelation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PolicyCancelationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"Id", "policyNumber", "policyExpiryDate", "insuredId",
			"insuredName", "vehicleSequence", "vehicleChessisNo",
			"cancllationReqDate", "reason", "servicemessage",
			"cancellationEffdate", "ibanImage", "validFile", "otherFile",
			"vehMake", "vehModel", "plateNumber", "anyAccident", "lodgeClaim",
			"ibanFileName", "validFileName", "policyInceptionDate",
			"insuredEmail", "insuredMobile", "rejReason"
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

	private static class PolicyCancelationModelArgumentsResolver
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

			PolicyCancelationModelImpl policyCancelationModelImpl =
				(PolicyCancelationModelImpl)baseModel;

			long columnBitmask = policyCancelationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					policyCancelationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						policyCancelationModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					policyCancelationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PolicyCancelationModelImpl policyCancelationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						policyCancelationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = policyCancelationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}