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

import com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException;
import com.ejada.atmc.acl.db.model.PolicyHDR;
import com.ejada.atmc.acl.db.model.impl.PolicyHDRImpl;
import com.ejada.atmc.acl.db.model.impl.PolicyHDRModelImpl;
import com.ejada.atmc.acl.db.service.persistence.PolicyHDRPersistence;
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
import com.liferay.portal.kernel.util.ArrayUtil;
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
 * The persistence implementation for the policy hdr service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PolicyHDRPersistence.class)
public class PolicyHDRPersistenceImpl
	extends BasePersistenceImpl<PolicyHDR> implements PolicyHDRPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PolicyHDRUtil</code> to access the policy hdr persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PolicyHDRImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByPolicyNo;
	private FinderPath _finderPathCountByPolicyNo;

	/**
	 * Returns the policy hdr where policyNo = &#63; or throws a <code>NoSuchPolicyHDRException</code> if it could not be found.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	@Override
	public PolicyHDR findByPolicyNo(String policyNo)
		throws NoSuchPolicyHDRException {

		PolicyHDR policyHDR = fetchByPolicyNo(policyNo);

		if (policyHDR == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("policyNo=");
			sb.append(policyNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPolicyHDRException(sb.toString());
		}

		return policyHDR;
	}

	/**
	 * Returns the policy hdr where policyNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	@Override
	public PolicyHDR fetchByPolicyNo(String policyNo) {
		return fetchByPolicyNo(policyNo, true);
	}

	/**
	 * Returns the policy hdr where policyNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyNo the policy no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	@Override
	public PolicyHDR fetchByPolicyNo(String policyNo, boolean useFinderCache) {
		policyNo = Objects.toString(policyNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {policyNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByPolicyNo, finderArgs, this);
		}

		if (result instanceof PolicyHDR) {
			PolicyHDR policyHDR = (PolicyHDR)result;

			if (!Objects.equals(policyNo, policyHDR.getPolicyNo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_POLICYHDR_WHERE);

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

				List<PolicyHDR> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByPolicyNo, finderArgs, list);
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
								"PolicyHDRPersistenceImpl.fetchByPolicyNo(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PolicyHDR policyHDR = list.get(0);

					result = policyHDR;

					cacheResult(policyHDR);
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
			return (PolicyHDR)result;
		}
	}

	/**
	 * Removes the policy hdr where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 * @return the policy hdr that was removed
	 */
	@Override
	public PolicyHDR removeByPolicyNo(String policyNo)
		throws NoSuchPolicyHDRException {

		PolicyHDR policyHDR = findByPolicyNo(policyNo);

		return remove(policyHDR);
	}

	/**
	 * Returns the number of policy hdrs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching policy hdrs
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

			sb.append(_SQL_COUNT_POLICYHDR_WHERE);

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
		"policyHDR.policyNo = ?";

	private static final String _FINDER_COLUMN_POLICYNO_POLICYNO_3 =
		"(policyHDR.policyNo IS NULL OR policyHDR.policyNo = '')";

	private FinderPath _finderPathWithPaginationFindByMULTI_POLICY;
	private FinderPath _finderPathWithoutPaginationFindByMULTI_POLICY;
	private FinderPath _finderPathCountByMULTI_POLICY;
	private FinderPath _finderPathWithPaginationCountByMULTI_POLICY;

	/**
	 * Returns all the policy hdrs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy hdrs
	 */
	@Override
	public List<PolicyHDR> findByMULTI_POLICY(String policyNo) {
		return findByMULTI_POLICY(
			policyNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy hdrs where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @return the range of matching policy hdrs
	 */
	@Override
	public List<PolicyHDR> findByMULTI_POLICY(
		String policyNo, int start, int end) {

		return findByMULTI_POLICY(policyNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy hdrs where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy hdrs
	 */
	@Override
	public List<PolicyHDR> findByMULTI_POLICY(
		String policyNo, int start, int end,
		OrderByComparator<PolicyHDR> orderByComparator) {

		return findByMULTI_POLICY(
			policyNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy hdrs where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy hdrs
	 */
	@Override
	public List<PolicyHDR> findByMULTI_POLICY(
		String policyNo, int start, int end,
		OrderByComparator<PolicyHDR> orderByComparator,
		boolean useFinderCache) {

		policyNo = Objects.toString(policyNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByMULTI_POLICY;
				finderArgs = new Object[] {policyNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByMULTI_POLICY;
			finderArgs = new Object[] {policyNo, start, end, orderByComparator};
		}

		List<PolicyHDR> list = null;

		if (useFinderCache) {
			list = (List<PolicyHDR>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PolicyHDR policyHDR : list) {
					if (!policyNo.equals(policyHDR.getPolicyNo())) {
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

			sb.append(_SQL_SELECT_POLICYHDR_WHERE);

			boolean bindPolicyNo = false;

			if (policyNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_MULTI_POLICY_POLICYNO_3);
			}
			else {
				bindPolicyNo = true;

				sb.append(_FINDER_COLUMN_MULTI_POLICY_POLICYNO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PolicyHDRModelImpl.ORDER_BY_JPQL);
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

				list = (List<PolicyHDR>)QueryUtil.list(
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
	 * Returns the first policy hdr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	@Override
	public PolicyHDR findByMULTI_POLICY_First(
			String policyNo, OrderByComparator<PolicyHDR> orderByComparator)
		throws NoSuchPolicyHDRException {

		PolicyHDR policyHDR = fetchByMULTI_POLICY_First(
			policyNo, orderByComparator);

		if (policyHDR != null) {
			return policyHDR;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNo=");
		sb.append(policyNo);

		sb.append("}");

		throw new NoSuchPolicyHDRException(sb.toString());
	}

	/**
	 * Returns the first policy hdr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	@Override
	public PolicyHDR fetchByMULTI_POLICY_First(
		String policyNo, OrderByComparator<PolicyHDR> orderByComparator) {

		List<PolicyHDR> list = findByMULTI_POLICY(
			policyNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last policy hdr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	@Override
	public PolicyHDR findByMULTI_POLICY_Last(
			String policyNo, OrderByComparator<PolicyHDR> orderByComparator)
		throws NoSuchPolicyHDRException {

		PolicyHDR policyHDR = fetchByMULTI_POLICY_Last(
			policyNo, orderByComparator);

		if (policyHDR != null) {
			return policyHDR;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNo=");
		sb.append(policyNo);

		sb.append("}");

		throw new NoSuchPolicyHDRException(sb.toString());
	}

	/**
	 * Returns the last policy hdr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	@Override
	public PolicyHDR fetchByMULTI_POLICY_Last(
		String policyNo, OrderByComparator<PolicyHDR> orderByComparator) {

		int count = countByMULTI_POLICY(policyNo);

		if (count == 0) {
			return null;
		}

		List<PolicyHDR> list = findByMULTI_POLICY(
			policyNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns all the policy hdrs where policyNo = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param policyNos the policy nos
	 * @return the matching policy hdrs
	 */
	@Override
	public List<PolicyHDR> findByMULTI_POLICY(String[] policyNos) {
		return findByMULTI_POLICY(
			policyNos, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy hdrs where policyNo = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param policyNos the policy nos
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @return the range of matching policy hdrs
	 */
	@Override
	public List<PolicyHDR> findByMULTI_POLICY(
		String[] policyNos, int start, int end) {

		return findByMULTI_POLICY(policyNos, start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy hdrs where policyNo = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param policyNos the policy nos
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy hdrs
	 */
	@Override
	public List<PolicyHDR> findByMULTI_POLICY(
		String[] policyNos, int start, int end,
		OrderByComparator<PolicyHDR> orderByComparator) {

		return findByMULTI_POLICY(
			policyNos, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy hdrs where policyNo = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy hdrs
	 */
	@Override
	public List<PolicyHDR> findByMULTI_POLICY(
		String[] policyNos, int start, int end,
		OrderByComparator<PolicyHDR> orderByComparator,
		boolean useFinderCache) {

		if (policyNos == null) {
			policyNos = new String[0];
		}
		else if (policyNos.length > 1) {
			for (int i = 0; i < policyNos.length; i++) {
				policyNos[i] = Objects.toString(policyNos[i], "");
			}

			policyNos = ArrayUtil.sortedUnique(policyNos);
		}

		if (policyNos.length == 1) {
			return findByMULTI_POLICY(
				policyNos[0], start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {StringUtil.merge(policyNos)};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				StringUtil.merge(policyNos), start, end, orderByComparator
			};
		}

		List<PolicyHDR> list = null;

		if (useFinderCache) {
			list = (List<PolicyHDR>)dummyFinderCache.getResult(
				_finderPathWithPaginationFindByMULTI_POLICY, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PolicyHDR policyHDR : list) {
					if (!ArrayUtil.contains(
							policyNos, policyHDR.getPolicyNo())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_SELECT_POLICYHDR_WHERE);

			if (policyNos.length > 0) {
				sb.append("(");

				for (int i = 0; i < policyNos.length; i++) {
					String policyNo = policyNos[i];

					if (policyNo.isEmpty()) {
						sb.append(_FINDER_COLUMN_MULTI_POLICY_POLICYNO_3);
					}
					else {
						sb.append(_FINDER_COLUMN_MULTI_POLICY_POLICYNO_2);
					}

					if ((i + 1) < policyNos.length) {
						sb.append(WHERE_OR);
					}
				}

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PolicyHDRModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				for (String policyNo : policyNos) {
					if ((policyNo != null) && !policyNo.isEmpty()) {
						queryPos.add(policyNo);
					}
				}

				list = (List<PolicyHDR>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(
						_finderPathWithPaginationFindByMULTI_POLICY, finderArgs,
						list);
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
	 * Removes all the policy hdrs where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 */
	@Override
	public void removeByMULTI_POLICY(String policyNo) {
		for (PolicyHDR policyHDR :
				findByMULTI_POLICY(
					policyNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(policyHDR);
		}
	}

	/**
	 * Returns the number of policy hdrs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching policy hdrs
	 */
	@Override
	public int countByMULTI_POLICY(String policyNo) {
		policyNo = Objects.toString(policyNo, "");

		FinderPath finderPath = _finderPathCountByMULTI_POLICY;

		Object[] finderArgs = new Object[] {policyNo};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POLICYHDR_WHERE);

			boolean bindPolicyNo = false;

			if (policyNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_MULTI_POLICY_POLICYNO_3);
			}
			else {
				bindPolicyNo = true;

				sb.append(_FINDER_COLUMN_MULTI_POLICY_POLICYNO_2);
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

	/**
	 * Returns the number of policy hdrs where policyNo = any &#63;.
	 *
	 * @param policyNos the policy nos
	 * @return the number of matching policy hdrs
	 */
	@Override
	public int countByMULTI_POLICY(String[] policyNos) {
		if (policyNos == null) {
			policyNos = new String[0];
		}
		else if (policyNos.length > 1) {
			for (int i = 0; i < policyNos.length; i++) {
				policyNos[i] = Objects.toString(policyNos[i], "");
			}

			policyNos = ArrayUtil.sortedUnique(policyNos);
		}

		Object[] finderArgs = new Object[] {StringUtil.merge(policyNos)};

		Long count = (Long)dummyFinderCache.getResult(
			_finderPathWithPaginationCountByMULTI_POLICY, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler();

			sb.append(_SQL_COUNT_POLICYHDR_WHERE);

			if (policyNos.length > 0) {
				sb.append("(");

				for (int i = 0; i < policyNos.length; i++) {
					String policyNo = policyNos[i];

					if (policyNo.isEmpty()) {
						sb.append(_FINDER_COLUMN_MULTI_POLICY_POLICYNO_3);
					}
					else {
						sb.append(_FINDER_COLUMN_MULTI_POLICY_POLICYNO_2);
					}

					if ((i + 1) < policyNos.length) {
						sb.append(WHERE_OR);
					}
				}

				sb.append(")");
			}

			sb.setStringAt(
				removeConjunction(sb.stringAt(sb.index() - 1)), sb.index() - 1);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				for (String policyNo : policyNos) {
					if ((policyNo != null) && !policyNo.isEmpty()) {
						queryPos.add(policyNo);
					}
				}

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(
					_finderPathWithPaginationCountByMULTI_POLICY, finderArgs,
					count);
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

	private static final String _FINDER_COLUMN_MULTI_POLICY_POLICYNO_2 =
		"policyHDR.policyNo = ?";

	private static final String _FINDER_COLUMN_MULTI_POLICY_POLICYNO_3 =
		"(policyHDR.policyNo IS NULL OR policyHDR.policyNo = '')";

	private FinderPath _finderPathWithPaginationFindByinsuredMobileNo;
	private FinderPath _finderPathWithoutPaginationFindByinsuredMobileNo;
	private FinderPath _finderPathCountByinsuredMobileNo;

	/**
	 * Returns all the policy hdrs where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @return the matching policy hdrs
	 */
	@Override
	public List<PolicyHDR> findByinsuredMobileNo(String insuredMobile) {
		return findByinsuredMobileNo(
			insuredMobile, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy hdrs where insuredMobile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param insuredMobile the insured mobile
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @return the range of matching policy hdrs
	 */
	@Override
	public List<PolicyHDR> findByinsuredMobileNo(
		String insuredMobile, int start, int end) {

		return findByinsuredMobileNo(insuredMobile, start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy hdrs where insuredMobile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param insuredMobile the insured mobile
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy hdrs
	 */
	@Override
	public List<PolicyHDR> findByinsuredMobileNo(
		String insuredMobile, int start, int end,
		OrderByComparator<PolicyHDR> orderByComparator) {

		return findByinsuredMobileNo(
			insuredMobile, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy hdrs where insuredMobile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param insuredMobile the insured mobile
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy hdrs
	 */
	@Override
	public List<PolicyHDR> findByinsuredMobileNo(
		String insuredMobile, int start, int end,
		OrderByComparator<PolicyHDR> orderByComparator,
		boolean useFinderCache) {

		insuredMobile = Objects.toString(insuredMobile, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByinsuredMobileNo;
				finderArgs = new Object[] {insuredMobile};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByinsuredMobileNo;
			finderArgs = new Object[] {
				insuredMobile, start, end, orderByComparator
			};
		}

		List<PolicyHDR> list = null;

		if (useFinderCache) {
			list = (List<PolicyHDR>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PolicyHDR policyHDR : list) {
					if (!insuredMobile.equals(policyHDR.getInsuredMobile())) {
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

			sb.append(_SQL_SELECT_POLICYHDR_WHERE);

			boolean bindInsuredMobile = false;

			if (insuredMobile.isEmpty()) {
				sb.append(_FINDER_COLUMN_INSUREDMOBILENO_INSUREDMOBILE_3);
			}
			else {
				bindInsuredMobile = true;

				sb.append(_FINDER_COLUMN_INSUREDMOBILENO_INSUREDMOBILE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PolicyHDRModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindInsuredMobile) {
					queryPos.add(insuredMobile);
				}

				list = (List<PolicyHDR>)QueryUtil.list(
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
	 * Returns the first policy hdr in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	@Override
	public PolicyHDR findByinsuredMobileNo_First(
			String insuredMobile,
			OrderByComparator<PolicyHDR> orderByComparator)
		throws NoSuchPolicyHDRException {

		PolicyHDR policyHDR = fetchByinsuredMobileNo_First(
			insuredMobile, orderByComparator);

		if (policyHDR != null) {
			return policyHDR;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("insuredMobile=");
		sb.append(insuredMobile);

		sb.append("}");

		throw new NoSuchPolicyHDRException(sb.toString());
	}

	/**
	 * Returns the first policy hdr in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	@Override
	public PolicyHDR fetchByinsuredMobileNo_First(
		String insuredMobile, OrderByComparator<PolicyHDR> orderByComparator) {

		List<PolicyHDR> list = findByinsuredMobileNo(
			insuredMobile, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last policy hdr in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	@Override
	public PolicyHDR findByinsuredMobileNo_Last(
			String insuredMobile,
			OrderByComparator<PolicyHDR> orderByComparator)
		throws NoSuchPolicyHDRException {

		PolicyHDR policyHDR = fetchByinsuredMobileNo_Last(
			insuredMobile, orderByComparator);

		if (policyHDR != null) {
			return policyHDR;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("insuredMobile=");
		sb.append(insuredMobile);

		sb.append("}");

		throw new NoSuchPolicyHDRException(sb.toString());
	}

	/**
	 * Returns the last policy hdr in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	@Override
	public PolicyHDR fetchByinsuredMobileNo_Last(
		String insuredMobile, OrderByComparator<PolicyHDR> orderByComparator) {

		int count = countByinsuredMobileNo(insuredMobile);

		if (count == 0) {
			return null;
		}

		List<PolicyHDR> list = findByinsuredMobileNo(
			insuredMobile, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the policy hdrs before and after the current policy hdr in the ordered set where insuredMobile = &#63;.
	 *
	 * @param policyNo the primary key of the current policy hdr
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy hdr
	 * @throws NoSuchPolicyHDRException if a policy hdr with the primary key could not be found
	 */
	@Override
	public PolicyHDR[] findByinsuredMobileNo_PrevAndNext(
			String policyNo, String insuredMobile,
			OrderByComparator<PolicyHDR> orderByComparator)
		throws NoSuchPolicyHDRException {

		insuredMobile = Objects.toString(insuredMobile, "");

		PolicyHDR policyHDR = findByPrimaryKey(policyNo);

		Session session = null;

		try {
			session = openSession();

			PolicyHDR[] array = new PolicyHDRImpl[3];

			array[0] = getByinsuredMobileNo_PrevAndNext(
				session, policyHDR, insuredMobile, orderByComparator, true);

			array[1] = policyHDR;

			array[2] = getByinsuredMobileNo_PrevAndNext(
				session, policyHDR, insuredMobile, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PolicyHDR getByinsuredMobileNo_PrevAndNext(
		Session session, PolicyHDR policyHDR, String insuredMobile,
		OrderByComparator<PolicyHDR> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_POLICYHDR_WHERE);

		boolean bindInsuredMobile = false;

		if (insuredMobile.isEmpty()) {
			sb.append(_FINDER_COLUMN_INSUREDMOBILENO_INSUREDMOBILE_3);
		}
		else {
			bindInsuredMobile = true;

			sb.append(_FINDER_COLUMN_INSUREDMOBILENO_INSUREDMOBILE_2);
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
			sb.append(PolicyHDRModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindInsuredMobile) {
			queryPos.add(insuredMobile);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(policyHDR)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PolicyHDR> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the policy hdrs where insuredMobile = &#63; from the database.
	 *
	 * @param insuredMobile the insured mobile
	 */
	@Override
	public void removeByinsuredMobileNo(String insuredMobile) {
		for (PolicyHDR policyHDR :
				findByinsuredMobileNo(
					insuredMobile, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(policyHDR);
		}
	}

	/**
	 * Returns the number of policy hdrs where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @return the number of matching policy hdrs
	 */
	@Override
	public int countByinsuredMobileNo(String insuredMobile) {
		insuredMobile = Objects.toString(insuredMobile, "");

		FinderPath finderPath = _finderPathCountByinsuredMobileNo;

		Object[] finderArgs = new Object[] {insuredMobile};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POLICYHDR_WHERE);

			boolean bindInsuredMobile = false;

			if (insuredMobile.isEmpty()) {
				sb.append(_FINDER_COLUMN_INSUREDMOBILENO_INSUREDMOBILE_3);
			}
			else {
				bindInsuredMobile = true;

				sb.append(_FINDER_COLUMN_INSUREDMOBILENO_INSUREDMOBILE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindInsuredMobile) {
					queryPos.add(insuredMobile);
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

	private static final String _FINDER_COLUMN_INSUREDMOBILENO_INSUREDMOBILE_2 =
		"policyHDR.insuredMobile = ?";

	private static final String _FINDER_COLUMN_INSUREDMOBILENO_INSUREDMOBILE_3 =
		"(policyHDR.insuredMobile IS NULL OR policyHDR.insuredMobile = '')";

	private FinderPath _finderPathWithPaginationFindByiqamaIdAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByiqamaIdAndStatus;
	private FinderPath _finderPathCountByiqamaIdAndStatus;

	/**
	 * Returns all the policy hdrs where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @return the matching policy hdrs
	 */
	@Override
	public List<PolicyHDR> findByiqamaIdAndStatus(
		String iqamaId, String policyStatus) {

		return findByiqamaIdAndStatus(
			iqamaId, policyStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy hdrs where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @return the range of matching policy hdrs
	 */
	@Override
	public List<PolicyHDR> findByiqamaIdAndStatus(
		String iqamaId, String policyStatus, int start, int end) {

		return findByiqamaIdAndStatus(iqamaId, policyStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy hdrs where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy hdrs
	 */
	@Override
	public List<PolicyHDR> findByiqamaIdAndStatus(
		String iqamaId, String policyStatus, int start, int end,
		OrderByComparator<PolicyHDR> orderByComparator) {

		return findByiqamaIdAndStatus(
			iqamaId, policyStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy hdrs where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy hdrs
	 */
	@Override
	public List<PolicyHDR> findByiqamaIdAndStatus(
		String iqamaId, String policyStatus, int start, int end,
		OrderByComparator<PolicyHDR> orderByComparator,
		boolean useFinderCache) {

		iqamaId = Objects.toString(iqamaId, "");
		policyStatus = Objects.toString(policyStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByiqamaIdAndStatus;
				finderArgs = new Object[] {iqamaId, policyStatus};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByiqamaIdAndStatus;
			finderArgs = new Object[] {
				iqamaId, policyStatus, start, end, orderByComparator
			};
		}

		List<PolicyHDR> list = null;

		if (useFinderCache) {
			list = (List<PolicyHDR>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PolicyHDR policyHDR : list) {
					if (!iqamaId.equals(policyHDR.getIqamaId()) ||
						!policyStatus.equals(policyHDR.getPolicyStatus())) {

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

			sb.append(_SQL_SELECT_POLICYHDR_WHERE);

			boolean bindIqamaId = false;

			if (iqamaId.isEmpty()) {
				sb.append(_FINDER_COLUMN_IQAMAIDANDSTATUS_IQAMAID_3);
			}
			else {
				bindIqamaId = true;

				sb.append(_FINDER_COLUMN_IQAMAIDANDSTATUS_IQAMAID_2);
			}

			boolean bindPolicyStatus = false;

			if (policyStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_IQAMAIDANDSTATUS_POLICYSTATUS_3);
			}
			else {
				bindPolicyStatus = true;

				sb.append(_FINDER_COLUMN_IQAMAIDANDSTATUS_POLICYSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PolicyHDRModelImpl.ORDER_BY_JPQL);
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

				if (bindPolicyStatus) {
					queryPos.add(policyStatus);
				}

				list = (List<PolicyHDR>)QueryUtil.list(
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
	 * Returns the first policy hdr in the ordered set where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	@Override
	public PolicyHDR findByiqamaIdAndStatus_First(
			String iqamaId, String policyStatus,
			OrderByComparator<PolicyHDR> orderByComparator)
		throws NoSuchPolicyHDRException {

		PolicyHDR policyHDR = fetchByiqamaIdAndStatus_First(
			iqamaId, policyStatus, orderByComparator);

		if (policyHDR != null) {
			return policyHDR;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("iqamaId=");
		sb.append(iqamaId);

		sb.append(", policyStatus=");
		sb.append(policyStatus);

		sb.append("}");

		throw new NoSuchPolicyHDRException(sb.toString());
	}

	/**
	 * Returns the first policy hdr in the ordered set where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	@Override
	public PolicyHDR fetchByiqamaIdAndStatus_First(
		String iqamaId, String policyStatus,
		OrderByComparator<PolicyHDR> orderByComparator) {

		List<PolicyHDR> list = findByiqamaIdAndStatus(
			iqamaId, policyStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last policy hdr in the ordered set where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	@Override
	public PolicyHDR findByiqamaIdAndStatus_Last(
			String iqamaId, String policyStatus,
			OrderByComparator<PolicyHDR> orderByComparator)
		throws NoSuchPolicyHDRException {

		PolicyHDR policyHDR = fetchByiqamaIdAndStatus_Last(
			iqamaId, policyStatus, orderByComparator);

		if (policyHDR != null) {
			return policyHDR;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("iqamaId=");
		sb.append(iqamaId);

		sb.append(", policyStatus=");
		sb.append(policyStatus);

		sb.append("}");

		throw new NoSuchPolicyHDRException(sb.toString());
	}

	/**
	 * Returns the last policy hdr in the ordered set where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	@Override
	public PolicyHDR fetchByiqamaIdAndStatus_Last(
		String iqamaId, String policyStatus,
		OrderByComparator<PolicyHDR> orderByComparator) {

		int count = countByiqamaIdAndStatus(iqamaId, policyStatus);

		if (count == 0) {
			return null;
		}

		List<PolicyHDR> list = findByiqamaIdAndStatus(
			iqamaId, policyStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the policy hdrs before and after the current policy hdr in the ordered set where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param policyNo the primary key of the current policy hdr
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy hdr
	 * @throws NoSuchPolicyHDRException if a policy hdr with the primary key could not be found
	 */
	@Override
	public PolicyHDR[] findByiqamaIdAndStatus_PrevAndNext(
			String policyNo, String iqamaId, String policyStatus,
			OrderByComparator<PolicyHDR> orderByComparator)
		throws NoSuchPolicyHDRException {

		iqamaId = Objects.toString(iqamaId, "");
		policyStatus = Objects.toString(policyStatus, "");

		PolicyHDR policyHDR = findByPrimaryKey(policyNo);

		Session session = null;

		try {
			session = openSession();

			PolicyHDR[] array = new PolicyHDRImpl[3];

			array[0] = getByiqamaIdAndStatus_PrevAndNext(
				session, policyHDR, iqamaId, policyStatus, orderByComparator,
				true);

			array[1] = policyHDR;

			array[2] = getByiqamaIdAndStatus_PrevAndNext(
				session, policyHDR, iqamaId, policyStatus, orderByComparator,
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

	protected PolicyHDR getByiqamaIdAndStatus_PrevAndNext(
		Session session, PolicyHDR policyHDR, String iqamaId,
		String policyStatus, OrderByComparator<PolicyHDR> orderByComparator,
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

		sb.append(_SQL_SELECT_POLICYHDR_WHERE);

		boolean bindIqamaId = false;

		if (iqamaId.isEmpty()) {
			sb.append(_FINDER_COLUMN_IQAMAIDANDSTATUS_IQAMAID_3);
		}
		else {
			bindIqamaId = true;

			sb.append(_FINDER_COLUMN_IQAMAIDANDSTATUS_IQAMAID_2);
		}

		boolean bindPolicyStatus = false;

		if (policyStatus.isEmpty()) {
			sb.append(_FINDER_COLUMN_IQAMAIDANDSTATUS_POLICYSTATUS_3);
		}
		else {
			bindPolicyStatus = true;

			sb.append(_FINDER_COLUMN_IQAMAIDANDSTATUS_POLICYSTATUS_2);
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
			sb.append(PolicyHDRModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindIqamaId) {
			queryPos.add(iqamaId);
		}

		if (bindPolicyStatus) {
			queryPos.add(policyStatus);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(policyHDR)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PolicyHDR> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the policy hdrs where iqamaId = &#63; and policyStatus = &#63; from the database.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 */
	@Override
	public void removeByiqamaIdAndStatus(String iqamaId, String policyStatus) {
		for (PolicyHDR policyHDR :
				findByiqamaIdAndStatus(
					iqamaId, policyStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(policyHDR);
		}
	}

	/**
	 * Returns the number of policy hdrs where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @return the number of matching policy hdrs
	 */
	@Override
	public int countByiqamaIdAndStatus(String iqamaId, String policyStatus) {
		iqamaId = Objects.toString(iqamaId, "");
		policyStatus = Objects.toString(policyStatus, "");

		FinderPath finderPath = _finderPathCountByiqamaIdAndStatus;

		Object[] finderArgs = new Object[] {iqamaId, policyStatus};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_POLICYHDR_WHERE);

			boolean bindIqamaId = false;

			if (iqamaId.isEmpty()) {
				sb.append(_FINDER_COLUMN_IQAMAIDANDSTATUS_IQAMAID_3);
			}
			else {
				bindIqamaId = true;

				sb.append(_FINDER_COLUMN_IQAMAIDANDSTATUS_IQAMAID_2);
			}

			boolean bindPolicyStatus = false;

			if (policyStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_IQAMAIDANDSTATUS_POLICYSTATUS_3);
			}
			else {
				bindPolicyStatus = true;

				sb.append(_FINDER_COLUMN_IQAMAIDANDSTATUS_POLICYSTATUS_2);
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

				if (bindPolicyStatus) {
					queryPos.add(policyStatus);
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

	private static final String _FINDER_COLUMN_IQAMAIDANDSTATUS_IQAMAID_2 =
		"policyHDR.iqamaId = ? AND ";

	private static final String _FINDER_COLUMN_IQAMAIDANDSTATUS_IQAMAID_3 =
		"(policyHDR.iqamaId IS NULL OR policyHDR.iqamaId = '') AND ";

	private static final String _FINDER_COLUMN_IQAMAIDANDSTATUS_POLICYSTATUS_2 =
		"policyHDR.policyStatus = ?";

	private static final String _FINDER_COLUMN_IQAMAIDANDSTATUS_POLICYSTATUS_3 =
		"(policyHDR.policyStatus IS NULL OR policyHDR.policyStatus = '')";

	public PolicyHDRPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("policyNo", "ODS_POLICY_NO");
		dbColumnNames.put("iqamaId", "ODS_IQAMA_ID");
		dbColumnNames.put("policyStatus", "ODS_POLICY_STATUS");
		dbColumnNames.put("product", "ODS_PRODUCT");
		dbColumnNames.put("inceptionDate", "ODS_INCEPTION_DT");
		dbColumnNames.put("expiryDate", "ODS_EXPIRY_DT");
		dbColumnNames.put("sumInsured", "ODS_SUM_INSURED");
		dbColumnNames.put("totalPremium", "ODS_TOTAL_PREMIUM");
		dbColumnNames.put("policyFees", "ODS_POLICY_FEES");
		dbColumnNames.put("policyTaxes", "ODS_POLICY_TAXES");
		dbColumnNames.put("policyTerm", "ODS_POLICY_TERM");
		dbColumnNames.put("premium", "ODS_OS_PREMIUM");
		dbColumnNames.put("nextDueDate", "ODS_NEXT_DUE_DT");
		dbColumnNames.put("countPremMissed", "ODS_COUNT_PREM_MISSED");
		dbColumnNames.put("modeOfPayment", "ODS_MODEOF_PAYMENT");
		dbColumnNames.put("nextRenwalDate", "ODS_NEXT_RENEWAL_DT");
		dbColumnNames.put("custName", "ODS_CUST_NAME");
		dbColumnNames.put("custBirthDate", "ODS_CUST_DOB");
		dbColumnNames.put("insuredName", "ODS_INSURED_NAME");
		dbColumnNames.put("insuredBirthDate", "ODS_INSURED_DOB");
		dbColumnNames.put("insuredId", "ODS_INSURED_ID");
		dbColumnNames.put("insuredMobile", "ODS_INSURED_MOBILE");
		dbColumnNames.put("insuredEmail", "ODS_INSURED_EMAIL");
		dbColumnNames.put("insuredAddr", "ODS_INSURED_ADDR");
		dbColumnNames.put("insuredGender", "ODS_INSURED_GENDER");
		dbColumnNames.put("occuptation", "ODS_OCCUPTATION");
		dbColumnNames.put("estExpiryDate", "ODS_EST_EXPIRY_DT");
		dbColumnNames.put("najmStatus", "ODS_NAJM_STATUS");
		dbColumnNames.put("surrenderValue", "ODS_SURRENDER_VALUE");
		dbColumnNames.put("noOfRisk", "ODS_NOOF_RISK");
		dbColumnNames.put("memberScheme", "ODS_MEMBER_SCHEME");
		dbColumnNames.put("memberBenefits", "ODS_MEMBER_BENEFITS");

		setDBColumnNames(dbColumnNames);

		setModelClass(PolicyHDR.class);

		setModelImplClass(PolicyHDRImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the policy hdr in the entity cache if it is enabled.
	 *
	 * @param policyHDR the policy hdr
	 */
	@Override
	public void cacheResult(PolicyHDR policyHDR) {
		dummyEntityCache.putResult(
			PolicyHDRImpl.class, policyHDR.getPrimaryKey(), policyHDR);

		dummyFinderCache.putResult(
			_finderPathFetchByPolicyNo, new Object[] {policyHDR.getPolicyNo()},
			policyHDR);
	}

	/**
	 * Caches the policy hdrs in the entity cache if it is enabled.
	 *
	 * @param policyHDRs the policy hdrs
	 */
	@Override
	public void cacheResult(List<PolicyHDR> policyHDRs) {
		for (PolicyHDR policyHDR : policyHDRs) {
			if (dummyEntityCache.getResult(
					PolicyHDRImpl.class, policyHDR.getPrimaryKey()) == null) {

				cacheResult(policyHDR);
			}
		}
	}

	/**
	 * Clears the cache for all policy hdrs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(PolicyHDRImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the policy hdr.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PolicyHDR policyHDR) {
		dummyEntityCache.removeResult(PolicyHDRImpl.class, policyHDR);
	}

	@Override
	public void clearCache(List<PolicyHDR> policyHDRs) {
		for (PolicyHDR policyHDR : policyHDRs) {
			dummyEntityCache.removeResult(PolicyHDRImpl.class, policyHDR);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(PolicyHDRImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PolicyHDRModelImpl policyHDRModelImpl) {

		Object[] args = new Object[] {policyHDRModelImpl.getPolicyNo()};

		dummyFinderCache.putResult(
			_finderPathCountByPolicyNo, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchByPolicyNo, args, policyHDRModelImpl, false);
	}

	/**
	 * Creates a new policy hdr with the primary key. Does not add the policy hdr to the database.
	 *
	 * @param policyNo the primary key for the new policy hdr
	 * @return the new policy hdr
	 */
	@Override
	public PolicyHDR create(String policyNo) {
		PolicyHDR policyHDR = new PolicyHDRImpl();

		policyHDR.setNew(true);
		policyHDR.setPrimaryKey(policyNo);

		return policyHDR;
	}

	/**
	 * Removes the policy hdr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyNo the primary key of the policy hdr
	 * @return the policy hdr that was removed
	 * @throws NoSuchPolicyHDRException if a policy hdr with the primary key could not be found
	 */
	@Override
	public PolicyHDR remove(String policyNo) throws NoSuchPolicyHDRException {
		return remove((Serializable)policyNo);
	}

	/**
	 * Removes the policy hdr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the policy hdr
	 * @return the policy hdr that was removed
	 * @throws NoSuchPolicyHDRException if a policy hdr with the primary key could not be found
	 */
	@Override
	public PolicyHDR remove(Serializable primaryKey)
		throws NoSuchPolicyHDRException {

		Session session = null;

		try {
			session = openSession();

			PolicyHDR policyHDR = (PolicyHDR)session.get(
				PolicyHDRImpl.class, primaryKey);

			if (policyHDR == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPolicyHDRException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(policyHDR);
		}
		catch (NoSuchPolicyHDRException noSuchEntityException) {
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
	protected PolicyHDR removeImpl(PolicyHDR policyHDR) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(policyHDR)) {
				policyHDR = (PolicyHDR)session.get(
					PolicyHDRImpl.class, policyHDR.getPrimaryKeyObj());
			}

			if (policyHDR != null) {
				session.delete(policyHDR);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (policyHDR != null) {
			clearCache(policyHDR);
		}

		return policyHDR;
	}

	@Override
	public PolicyHDR updateImpl(PolicyHDR policyHDR) {
		boolean isNew = policyHDR.isNew();

		if (!(policyHDR instanceof PolicyHDRModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(policyHDR.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(policyHDR);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in policyHDR proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PolicyHDR implementation " +
					policyHDR.getClass());
		}

		PolicyHDRModelImpl policyHDRModelImpl = (PolicyHDRModelImpl)policyHDR;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(policyHDR);
			}
			else {
				policyHDR = (PolicyHDR)session.merge(policyHDR);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			PolicyHDRImpl.class, policyHDRModelImpl, false, true);

		cacheUniqueFindersCache(policyHDRModelImpl);

		if (isNew) {
			policyHDR.setNew(false);
		}

		policyHDR.resetOriginalValues();

		return policyHDR;
	}

	/**
	 * Returns the policy hdr with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the policy hdr
	 * @return the policy hdr
	 * @throws NoSuchPolicyHDRException if a policy hdr with the primary key could not be found
	 */
	@Override
	public PolicyHDR findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPolicyHDRException {

		PolicyHDR policyHDR = fetchByPrimaryKey(primaryKey);

		if (policyHDR == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPolicyHDRException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return policyHDR;
	}

	/**
	 * Returns the policy hdr with the primary key or throws a <code>NoSuchPolicyHDRException</code> if it could not be found.
	 *
	 * @param policyNo the primary key of the policy hdr
	 * @return the policy hdr
	 * @throws NoSuchPolicyHDRException if a policy hdr with the primary key could not be found
	 */
	@Override
	public PolicyHDR findByPrimaryKey(String policyNo)
		throws NoSuchPolicyHDRException {

		return findByPrimaryKey((Serializable)policyNo);
	}

	/**
	 * Returns the policy hdr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyNo the primary key of the policy hdr
	 * @return the policy hdr, or <code>null</code> if a policy hdr with the primary key could not be found
	 */
	@Override
	public PolicyHDR fetchByPrimaryKey(String policyNo) {
		return fetchByPrimaryKey((Serializable)policyNo);
	}

	/**
	 * Returns all the policy hdrs.
	 *
	 * @return the policy hdrs
	 */
	@Override
	public List<PolicyHDR> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy hdrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @return the range of policy hdrs
	 */
	@Override
	public List<PolicyHDR> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy hdrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy hdrs
	 */
	@Override
	public List<PolicyHDR> findAll(
		int start, int end, OrderByComparator<PolicyHDR> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy hdrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy hdrs
	 */
	@Override
	public List<PolicyHDR> findAll(
		int start, int end, OrderByComparator<PolicyHDR> orderByComparator,
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

		List<PolicyHDR> list = null;

		if (useFinderCache) {
			list = (List<PolicyHDR>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_POLICYHDR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_POLICYHDR;

				sql = sql.concat(PolicyHDRModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PolicyHDR>)QueryUtil.list(
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
	 * Removes all the policy hdrs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PolicyHDR policyHDR : findAll()) {
			remove(policyHDR);
		}
	}

	/**
	 * Returns the number of policy hdrs.
	 *
	 * @return the number of policy hdrs
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_POLICYHDR);

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
		return "ODS_POLICY_NO";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_POLICYHDR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PolicyHDRModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the policy hdr persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PolicyHDRModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PolicyHDR.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByPolicyNo = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByPolicyNo",
			new String[] {String.class.getName()},
			new String[] {"ODS_POLICY_NO"}, true);

		_finderPathCountByPolicyNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPolicyNo",
			new String[] {String.class.getName()},
			new String[] {"ODS_POLICY_NO"}, false);

		_finderPathWithPaginationFindByMULTI_POLICY = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMULTI_POLICY",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"ODS_POLICY_NO"}, true);

		_finderPathWithoutPaginationFindByMULTI_POLICY = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMULTI_POLICY",
			new String[] {String.class.getName()},
			new String[] {"ODS_POLICY_NO"}, true);

		_finderPathCountByMULTI_POLICY = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMULTI_POLICY",
			new String[] {String.class.getName()},
			new String[] {"ODS_POLICY_NO"}, false);

		_finderPathWithPaginationCountByMULTI_POLICY = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByMULTI_POLICY",
			new String[] {String.class.getName()},
			new String[] {"ODS_POLICY_NO"}, false);

		_finderPathWithPaginationFindByinsuredMobileNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByinsuredMobileNo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"ODS_INSURED_MOBILE"}, true);

		_finderPathWithoutPaginationFindByinsuredMobileNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByinsuredMobileNo",
			new String[] {String.class.getName()},
			new String[] {"ODS_INSURED_MOBILE"}, true);

		_finderPathCountByinsuredMobileNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByinsuredMobileNo",
			new String[] {String.class.getName()},
			new String[] {"ODS_INSURED_MOBILE"}, false);

		_finderPathWithPaginationFindByiqamaIdAndStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByiqamaIdAndStatus",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"ODS_IQAMA_ID", "ODS_POLICY_STATUS"}, true);

		_finderPathWithoutPaginationFindByiqamaIdAndStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByiqamaIdAndStatus",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"ODS_IQAMA_ID", "ODS_POLICY_STATUS"}, true);

		_finderPathCountByiqamaIdAndStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByiqamaIdAndStatus",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"ODS_IQAMA_ID", "ODS_POLICY_STATUS"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(PolicyHDRImpl.class.getName());

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

	private static final String _SQL_SELECT_POLICYHDR =
		"SELECT policyHDR FROM PolicyHDR policyHDR";

	private static final String _SQL_SELECT_POLICYHDR_WHERE =
		"SELECT policyHDR FROM PolicyHDR policyHDR WHERE ";

	private static final String _SQL_COUNT_POLICYHDR =
		"SELECT COUNT(policyHDR) FROM PolicyHDR policyHDR";

	private static final String _SQL_COUNT_POLICYHDR_WHERE =
		"SELECT COUNT(policyHDR) FROM PolicyHDR policyHDR WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "policyHDR.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PolicyHDR exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PolicyHDR exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PolicyHDRPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"policyNo", "iqamaId", "policyStatus", "product", "inceptionDate",
			"expiryDate", "sumInsured", "totalPremium", "policyFees",
			"policyTaxes", "policyTerm", "premium", "nextDueDate",
			"countPremMissed", "modeOfPayment", "nextRenwalDate", "custName",
			"custBirthDate", "insuredName", "insuredBirthDate", "insuredId",
			"insuredMobile", "insuredEmail", "insuredAddr", "insuredGender",
			"occuptation", "estExpiryDate", "najmStatus", "surrenderValue",
			"noOfRisk", "memberScheme", "memberBenefits"
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

	private static class PolicyHDRModelArgumentsResolver
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

			PolicyHDRModelImpl policyHDRModelImpl =
				(PolicyHDRModelImpl)baseModel;

			long columnBitmask = policyHDRModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(policyHDRModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						policyHDRModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(policyHDRModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PolicyHDRModelImpl policyHDRModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = policyHDRModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = policyHDRModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}