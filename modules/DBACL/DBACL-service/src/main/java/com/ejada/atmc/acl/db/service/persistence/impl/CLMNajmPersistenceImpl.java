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

import com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException;
import com.ejada.atmc.acl.db.model.CLMNajm;
import com.ejada.atmc.acl.db.model.impl.CLMNajmImpl;
import com.ejada.atmc.acl.db.model.impl.CLMNajmModelImpl;
import com.ejada.atmc.acl.db.service.persistence.CLMNajmPK;
import com.ejada.atmc.acl.db.service.persistence.CLMNajmPersistence;
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
 * The persistence implementation for the clm najm service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CLMNajmPersistence.class)
public class CLMNajmPersistenceImpl
	extends BasePersistenceImpl<CLMNajm> implements CLMNajmPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CLMNajmUtil</code> to access the clm najm persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CLMNajmImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByCASE_PLATE;
	private FinderPath _finderPathCountByCASE_PLATE;

	/**
	 * Returns the clm najm where caseNo = &#63; and najmPlateNo = &#63; or throws a <code>NoSuchCLMNajmException</code> if it could not be found.
	 *
	 * @param caseNo the case no
	 * @param najmPlateNo the najm plate no
	 * @return the matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm findByCASE_PLATE(String caseNo, String najmPlateNo)
		throws NoSuchCLMNajmException {

		CLMNajm clmNajm = fetchByCASE_PLATE(caseNo, najmPlateNo);

		if (clmNajm == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("caseNo=");
			sb.append(caseNo);

			sb.append(", najmPlateNo=");
			sb.append(najmPlateNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCLMNajmException(sb.toString());
		}

		return clmNajm;
	}

	/**
	 * Returns the clm najm where caseNo = &#63; and najmPlateNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param caseNo the case no
	 * @param najmPlateNo the najm plate no
	 * @return the matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm fetchByCASE_PLATE(String caseNo, String najmPlateNo) {
		return fetchByCASE_PLATE(caseNo, najmPlateNo, true);
	}

	/**
	 * Returns the clm najm where caseNo = &#63; and najmPlateNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param caseNo the case no
	 * @param najmPlateNo the najm plate no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm fetchByCASE_PLATE(
		String caseNo, String najmPlateNo, boolean useFinderCache) {

		caseNo = Objects.toString(caseNo, "");
		najmPlateNo = Objects.toString(najmPlateNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {caseNo, najmPlateNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByCASE_PLATE, finderArgs, this);
		}

		if (result instanceof CLMNajm) {
			CLMNajm clmNajm = (CLMNajm)result;

			if (!Objects.equals(caseNo, clmNajm.getCaseNo()) ||
				!Objects.equals(najmPlateNo, clmNajm.getNajmPlateNo())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CLMNAJM_WHERE);

			boolean bindCaseNo = false;

			if (caseNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_CASE_PLATE_CASENO_3);
			}
			else {
				bindCaseNo = true;

				sb.append(_FINDER_COLUMN_CASE_PLATE_CASENO_2);
			}

			boolean bindNajmPlateNo = false;

			if (najmPlateNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_CASE_PLATE_NAJMPLATENO_3);
			}
			else {
				bindNajmPlateNo = true;

				sb.append(_FINDER_COLUMN_CASE_PLATE_NAJMPLATENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCaseNo) {
					queryPos.add(caseNo);
				}

				if (bindNajmPlateNo) {
					queryPos.add(najmPlateNo);
				}

				List<CLMNajm> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByCASE_PLATE, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {caseNo, najmPlateNo};
							}

							_log.warn(
								"CLMNajmPersistenceImpl.fetchByCASE_PLATE(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CLMNajm clmNajm = list.get(0);

					result = clmNajm;

					cacheResult(clmNajm);
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
			return (CLMNajm)result;
		}
	}

	/**
	 * Removes the clm najm where caseNo = &#63; and najmPlateNo = &#63; from the database.
	 *
	 * @param caseNo the case no
	 * @param najmPlateNo the najm plate no
	 * @return the clm najm that was removed
	 */
	@Override
	public CLMNajm removeByCASE_PLATE(String caseNo, String najmPlateNo)
		throws NoSuchCLMNajmException {

		CLMNajm clmNajm = findByCASE_PLATE(caseNo, najmPlateNo);

		return remove(clmNajm);
	}

	/**
	 * Returns the number of clm najms where caseNo = &#63; and najmPlateNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @param najmPlateNo the najm plate no
	 * @return the number of matching clm najms
	 */
	@Override
	public int countByCASE_PLATE(String caseNo, String najmPlateNo) {
		caseNo = Objects.toString(caseNo, "");
		najmPlateNo = Objects.toString(najmPlateNo, "");

		FinderPath finderPath = _finderPathCountByCASE_PLATE;

		Object[] finderArgs = new Object[] {caseNo, najmPlateNo};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CLMNAJM_WHERE);

			boolean bindCaseNo = false;

			if (caseNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_CASE_PLATE_CASENO_3);
			}
			else {
				bindCaseNo = true;

				sb.append(_FINDER_COLUMN_CASE_PLATE_CASENO_2);
			}

			boolean bindNajmPlateNo = false;

			if (najmPlateNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_CASE_PLATE_NAJMPLATENO_3);
			}
			else {
				bindNajmPlateNo = true;

				sb.append(_FINDER_COLUMN_CASE_PLATE_NAJMPLATENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCaseNo) {
					queryPos.add(caseNo);
				}

				if (bindNajmPlateNo) {
					queryPos.add(najmPlateNo);
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

	private static final String _FINDER_COLUMN_CASE_PLATE_CASENO_2 =
		"clmNajm.id.caseNo = ? AND ";

	private static final String _FINDER_COLUMN_CASE_PLATE_CASENO_3 =
		"(clmNajm.id.caseNo IS NULL OR clmNajm.id.caseNo = '') AND ";

	private static final String _FINDER_COLUMN_CASE_PLATE_NAJMPLATENO_2 =
		"clmNajm.najmPlateNo = ?";

	private static final String _FINDER_COLUMN_CASE_PLATE_NAJMPLATENO_3 =
		"(clmNajm.najmPlateNo IS NULL OR clmNajm.najmPlateNo = '')";

	private FinderPath _finderPathFetchByCASE_CUSTOM;
	private FinderPath _finderPathCountByCASE_CUSTOM;

	/**
	 * Returns the clm najm where caseNo = &#63; and customId = &#63; or throws a <code>NoSuchCLMNajmException</code> if it could not be found.
	 *
	 * @param caseNo the case no
	 * @param customId the custom ID
	 * @return the matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm findByCASE_CUSTOM(String caseNo, String customId)
		throws NoSuchCLMNajmException {

		CLMNajm clmNajm = fetchByCASE_CUSTOM(caseNo, customId);

		if (clmNajm == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("caseNo=");
			sb.append(caseNo);

			sb.append(", customId=");
			sb.append(customId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCLMNajmException(sb.toString());
		}

		return clmNajm;
	}

	/**
	 * Returns the clm najm where caseNo = &#63; and customId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param caseNo the case no
	 * @param customId the custom ID
	 * @return the matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm fetchByCASE_CUSTOM(String caseNo, String customId) {
		return fetchByCASE_CUSTOM(caseNo, customId, true);
	}

	/**
	 * Returns the clm najm where caseNo = &#63; and customId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param caseNo the case no
	 * @param customId the custom ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm fetchByCASE_CUSTOM(
		String caseNo, String customId, boolean useFinderCache) {

		caseNo = Objects.toString(caseNo, "");
		customId = Objects.toString(customId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {caseNo, customId};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByCASE_CUSTOM, finderArgs, this);
		}

		if (result instanceof CLMNajm) {
			CLMNajm clmNajm = (CLMNajm)result;

			if (!Objects.equals(caseNo, clmNajm.getCaseNo()) ||
				!Objects.equals(customId, clmNajm.getCustomId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CLMNAJM_WHERE);

			boolean bindCaseNo = false;

			if (caseNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_CASE_CUSTOM_CASENO_3);
			}
			else {
				bindCaseNo = true;

				sb.append(_FINDER_COLUMN_CASE_CUSTOM_CASENO_2);
			}

			boolean bindCustomId = false;

			if (customId.isEmpty()) {
				sb.append(_FINDER_COLUMN_CASE_CUSTOM_CUSTOMID_3);
			}
			else {
				bindCustomId = true;

				sb.append(_FINDER_COLUMN_CASE_CUSTOM_CUSTOMID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCaseNo) {
					queryPos.add(caseNo);
				}

				if (bindCustomId) {
					queryPos.add(customId);
				}

				List<CLMNajm> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByCASE_CUSTOM, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {caseNo, customId};
							}

							_log.warn(
								"CLMNajmPersistenceImpl.fetchByCASE_CUSTOM(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CLMNajm clmNajm = list.get(0);

					result = clmNajm;

					cacheResult(clmNajm);
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
			return (CLMNajm)result;
		}
	}

	/**
	 * Removes the clm najm where caseNo = &#63; and customId = &#63; from the database.
	 *
	 * @param caseNo the case no
	 * @param customId the custom ID
	 * @return the clm najm that was removed
	 */
	@Override
	public CLMNajm removeByCASE_CUSTOM(String caseNo, String customId)
		throws NoSuchCLMNajmException {

		CLMNajm clmNajm = findByCASE_CUSTOM(caseNo, customId);

		return remove(clmNajm);
	}

	/**
	 * Returns the number of clm najms where caseNo = &#63; and customId = &#63;.
	 *
	 * @param caseNo the case no
	 * @param customId the custom ID
	 * @return the number of matching clm najms
	 */
	@Override
	public int countByCASE_CUSTOM(String caseNo, String customId) {
		caseNo = Objects.toString(caseNo, "");
		customId = Objects.toString(customId, "");

		FinderPath finderPath = _finderPathCountByCASE_CUSTOM;

		Object[] finderArgs = new Object[] {caseNo, customId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CLMNAJM_WHERE);

			boolean bindCaseNo = false;

			if (caseNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_CASE_CUSTOM_CASENO_3);
			}
			else {
				bindCaseNo = true;

				sb.append(_FINDER_COLUMN_CASE_CUSTOM_CASENO_2);
			}

			boolean bindCustomId = false;

			if (customId.isEmpty()) {
				sb.append(_FINDER_COLUMN_CASE_CUSTOM_CUSTOMID_3);
			}
			else {
				bindCustomId = true;

				sb.append(_FINDER_COLUMN_CASE_CUSTOM_CUSTOMID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCaseNo) {
					queryPos.add(caseNo);
				}

				if (bindCustomId) {
					queryPos.add(customId);
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

	private static final String _FINDER_COLUMN_CASE_CUSTOM_CASENO_2 =
		"clmNajm.id.caseNo = ? AND ";

	private static final String _FINDER_COLUMN_CASE_CUSTOM_CASENO_3 =
		"(clmNajm.id.caseNo IS NULL OR clmNajm.id.caseNo = '') AND ";

	private static final String _FINDER_COLUMN_CASE_CUSTOM_CUSTOMID_2 =
		"clmNajm.customId = ?";

	private static final String _FINDER_COLUMN_CASE_CUSTOM_CUSTOMID_3 =
		"(clmNajm.customId IS NULL OR clmNajm.customId = '')";

	private FinderPath _finderPathWithPaginationFindByNajmPlateNo;
	private FinderPath _finderPathWithoutPaginationFindByNajmPlateNo;
	private FinderPath _finderPathCountByNajmPlateNo;

	/**
	 * Returns all the clm najms where najmPlateNo = &#63;.
	 *
	 * @param najmPlateNo the najm plate no
	 * @return the matching clm najms
	 */
	@Override
	public List<CLMNajm> findByNajmPlateNo(String najmPlateNo) {
		return findByNajmPlateNo(
			najmPlateNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clm najms where najmPlateNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param najmPlateNo the najm plate no
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @return the range of matching clm najms
	 */
	@Override
	public List<CLMNajm> findByNajmPlateNo(
		String najmPlateNo, int start, int end) {

		return findByNajmPlateNo(najmPlateNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the clm najms where najmPlateNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param najmPlateNo the najm plate no
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clm najms
	 */
	@Override
	public List<CLMNajm> findByNajmPlateNo(
		String najmPlateNo, int start, int end,
		OrderByComparator<CLMNajm> orderByComparator) {

		return findByNajmPlateNo(
			najmPlateNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the clm najms where najmPlateNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param najmPlateNo the najm plate no
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching clm najms
	 */
	@Override
	public List<CLMNajm> findByNajmPlateNo(
		String najmPlateNo, int start, int end,
		OrderByComparator<CLMNajm> orderByComparator, boolean useFinderCache) {

		najmPlateNo = Objects.toString(najmPlateNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByNajmPlateNo;
				finderArgs = new Object[] {najmPlateNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByNajmPlateNo;
			finderArgs = new Object[] {
				najmPlateNo, start, end, orderByComparator
			};
		}

		List<CLMNajm> list = null;

		if (useFinderCache) {
			list = (List<CLMNajm>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CLMNajm clmNajm : list) {
					if (!najmPlateNo.equals(clmNajm.getNajmPlateNo())) {
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

			sb.append(_SQL_SELECT_CLMNAJM_WHERE);

			boolean bindNajmPlateNo = false;

			if (najmPlateNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAJMPLATENO_NAJMPLATENO_3);
			}
			else {
				bindNajmPlateNo = true;

				sb.append(_FINDER_COLUMN_NAJMPLATENO_NAJMPLATENO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CLMNajmModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNajmPlateNo) {
					queryPos.add(najmPlateNo);
				}

				list = (List<CLMNajm>)QueryUtil.list(
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
	 * Returns the first clm najm in the ordered set where najmPlateNo = &#63;.
	 *
	 * @param najmPlateNo the najm plate no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm findByNajmPlateNo_First(
			String najmPlateNo, OrderByComparator<CLMNajm> orderByComparator)
		throws NoSuchCLMNajmException {

		CLMNajm clmNajm = fetchByNajmPlateNo_First(
			najmPlateNo, orderByComparator);

		if (clmNajm != null) {
			return clmNajm;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("najmPlateNo=");
		sb.append(najmPlateNo);

		sb.append("}");

		throw new NoSuchCLMNajmException(sb.toString());
	}

	/**
	 * Returns the first clm najm in the ordered set where najmPlateNo = &#63;.
	 *
	 * @param najmPlateNo the najm plate no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm fetchByNajmPlateNo_First(
		String najmPlateNo, OrderByComparator<CLMNajm> orderByComparator) {

		List<CLMNajm> list = findByNajmPlateNo(
			najmPlateNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last clm najm in the ordered set where najmPlateNo = &#63;.
	 *
	 * @param najmPlateNo the najm plate no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm findByNajmPlateNo_Last(
			String najmPlateNo, OrderByComparator<CLMNajm> orderByComparator)
		throws NoSuchCLMNajmException {

		CLMNajm clmNajm = fetchByNajmPlateNo_Last(
			najmPlateNo, orderByComparator);

		if (clmNajm != null) {
			return clmNajm;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("najmPlateNo=");
		sb.append(najmPlateNo);

		sb.append("}");

		throw new NoSuchCLMNajmException(sb.toString());
	}

	/**
	 * Returns the last clm najm in the ordered set where najmPlateNo = &#63;.
	 *
	 * @param najmPlateNo the najm plate no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm fetchByNajmPlateNo_Last(
		String najmPlateNo, OrderByComparator<CLMNajm> orderByComparator) {

		int count = countByNajmPlateNo(najmPlateNo);

		if (count == 0) {
			return null;
		}

		List<CLMNajm> list = findByNajmPlateNo(
			najmPlateNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the clm najms before and after the current clm najm in the ordered set where najmPlateNo = &#63;.
	 *
	 * @param clmNajmPK the primary key of the current clm najm
	 * @param najmPlateNo the najm plate no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clm najm
	 * @throws NoSuchCLMNajmException if a clm najm with the primary key could not be found
	 */
	@Override
	public CLMNajm[] findByNajmPlateNo_PrevAndNext(
			CLMNajmPK clmNajmPK, String najmPlateNo,
			OrderByComparator<CLMNajm> orderByComparator)
		throws NoSuchCLMNajmException {

		najmPlateNo = Objects.toString(najmPlateNo, "");

		CLMNajm clmNajm = findByPrimaryKey(clmNajmPK);

		Session session = null;

		try {
			session = openSession();

			CLMNajm[] array = new CLMNajmImpl[3];

			array[0] = getByNajmPlateNo_PrevAndNext(
				session, clmNajm, najmPlateNo, orderByComparator, true);

			array[1] = clmNajm;

			array[2] = getByNajmPlateNo_PrevAndNext(
				session, clmNajm, najmPlateNo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CLMNajm getByNajmPlateNo_PrevAndNext(
		Session session, CLMNajm clmNajm, String najmPlateNo,
		OrderByComparator<CLMNajm> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLMNAJM_WHERE);

		boolean bindNajmPlateNo = false;

		if (najmPlateNo.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAJMPLATENO_NAJMPLATENO_3);
		}
		else {
			bindNajmPlateNo = true;

			sb.append(_FINDER_COLUMN_NAJMPLATENO_NAJMPLATENO_2);
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
			sb.append(CLMNajmModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNajmPlateNo) {
			queryPos.add(najmPlateNo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(clmNajm)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CLMNajm> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the clm najms where najmPlateNo = &#63; from the database.
	 *
	 * @param najmPlateNo the najm plate no
	 */
	@Override
	public void removeByNajmPlateNo(String najmPlateNo) {
		for (CLMNajm clmNajm :
				findByNajmPlateNo(
					najmPlateNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(clmNajm);
		}
	}

	/**
	 * Returns the number of clm najms where najmPlateNo = &#63;.
	 *
	 * @param najmPlateNo the najm plate no
	 * @return the number of matching clm najms
	 */
	@Override
	public int countByNajmPlateNo(String najmPlateNo) {
		najmPlateNo = Objects.toString(najmPlateNo, "");

		FinderPath finderPath = _finderPathCountByNajmPlateNo;

		Object[] finderArgs = new Object[] {najmPlateNo};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLMNAJM_WHERE);

			boolean bindNajmPlateNo = false;

			if (najmPlateNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAJMPLATENO_NAJMPLATENO_3);
			}
			else {
				bindNajmPlateNo = true;

				sb.append(_FINDER_COLUMN_NAJMPLATENO_NAJMPLATENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNajmPlateNo) {
					queryPos.add(najmPlateNo);
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

	private static final String _FINDER_COLUMN_NAJMPLATENO_NAJMPLATENO_2 =
		"clmNajm.najmPlateNo = ?";

	private static final String _FINDER_COLUMN_NAJMPLATENO_NAJMPLATENO_3 =
		"(clmNajm.najmPlateNo IS NULL OR clmNajm.najmPlateNo = '')";

	private FinderPath _finderPathWithPaginationFindByCustomId;
	private FinderPath _finderPathWithoutPaginationFindByCustomId;
	private FinderPath _finderPathCountByCustomId;

	/**
	 * Returns all the clm najms where customId = &#63;.
	 *
	 * @param customId the custom ID
	 * @return the matching clm najms
	 */
	@Override
	public List<CLMNajm> findByCustomId(String customId) {
		return findByCustomId(
			customId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clm najms where customId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param customId the custom ID
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @return the range of matching clm najms
	 */
	@Override
	public List<CLMNajm> findByCustomId(String customId, int start, int end) {
		return findByCustomId(customId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the clm najms where customId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param customId the custom ID
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clm najms
	 */
	@Override
	public List<CLMNajm> findByCustomId(
		String customId, int start, int end,
		OrderByComparator<CLMNajm> orderByComparator) {

		return findByCustomId(customId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the clm najms where customId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param customId the custom ID
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching clm najms
	 */
	@Override
	public List<CLMNajm> findByCustomId(
		String customId, int start, int end,
		OrderByComparator<CLMNajm> orderByComparator, boolean useFinderCache) {

		customId = Objects.toString(customId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCustomId;
				finderArgs = new Object[] {customId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCustomId;
			finderArgs = new Object[] {customId, start, end, orderByComparator};
		}

		List<CLMNajm> list = null;

		if (useFinderCache) {
			list = (List<CLMNajm>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CLMNajm clmNajm : list) {
					if (!customId.equals(clmNajm.getCustomId())) {
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

			sb.append(_SQL_SELECT_CLMNAJM_WHERE);

			boolean bindCustomId = false;

			if (customId.isEmpty()) {
				sb.append(_FINDER_COLUMN_CUSTOMID_CUSTOMID_3);
			}
			else {
				bindCustomId = true;

				sb.append(_FINDER_COLUMN_CUSTOMID_CUSTOMID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CLMNajmModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCustomId) {
					queryPos.add(customId);
				}

				list = (List<CLMNajm>)QueryUtil.list(
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
	 * Returns the first clm najm in the ordered set where customId = &#63;.
	 *
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm findByCustomId_First(
			String customId, OrderByComparator<CLMNajm> orderByComparator)
		throws NoSuchCLMNajmException {

		CLMNajm clmNajm = fetchByCustomId_First(customId, orderByComparator);

		if (clmNajm != null) {
			return clmNajm;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customId=");
		sb.append(customId);

		sb.append("}");

		throw new NoSuchCLMNajmException(sb.toString());
	}

	/**
	 * Returns the first clm najm in the ordered set where customId = &#63;.
	 *
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm fetchByCustomId_First(
		String customId, OrderByComparator<CLMNajm> orderByComparator) {

		List<CLMNajm> list = findByCustomId(customId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last clm najm in the ordered set where customId = &#63;.
	 *
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm findByCustomId_Last(
			String customId, OrderByComparator<CLMNajm> orderByComparator)
		throws NoSuchCLMNajmException {

		CLMNajm clmNajm = fetchByCustomId_Last(customId, orderByComparator);

		if (clmNajm != null) {
			return clmNajm;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customId=");
		sb.append(customId);

		sb.append("}");

		throw new NoSuchCLMNajmException(sb.toString());
	}

	/**
	 * Returns the last clm najm in the ordered set where customId = &#63;.
	 *
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm fetchByCustomId_Last(
		String customId, OrderByComparator<CLMNajm> orderByComparator) {

		int count = countByCustomId(customId);

		if (count == 0) {
			return null;
		}

		List<CLMNajm> list = findByCustomId(
			customId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the clm najms before and after the current clm najm in the ordered set where customId = &#63;.
	 *
	 * @param clmNajmPK the primary key of the current clm najm
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clm najm
	 * @throws NoSuchCLMNajmException if a clm najm with the primary key could not be found
	 */
	@Override
	public CLMNajm[] findByCustomId_PrevAndNext(
			CLMNajmPK clmNajmPK, String customId,
			OrderByComparator<CLMNajm> orderByComparator)
		throws NoSuchCLMNajmException {

		customId = Objects.toString(customId, "");

		CLMNajm clmNajm = findByPrimaryKey(clmNajmPK);

		Session session = null;

		try {
			session = openSession();

			CLMNajm[] array = new CLMNajmImpl[3];

			array[0] = getByCustomId_PrevAndNext(
				session, clmNajm, customId, orderByComparator, true);

			array[1] = clmNajm;

			array[2] = getByCustomId_PrevAndNext(
				session, clmNajm, customId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CLMNajm getByCustomId_PrevAndNext(
		Session session, CLMNajm clmNajm, String customId,
		OrderByComparator<CLMNajm> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLMNAJM_WHERE);

		boolean bindCustomId = false;

		if (customId.isEmpty()) {
			sb.append(_FINDER_COLUMN_CUSTOMID_CUSTOMID_3);
		}
		else {
			bindCustomId = true;

			sb.append(_FINDER_COLUMN_CUSTOMID_CUSTOMID_2);
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
			sb.append(CLMNajmModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCustomId) {
			queryPos.add(customId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(clmNajm)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CLMNajm> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the clm najms where customId = &#63; from the database.
	 *
	 * @param customId the custom ID
	 */
	@Override
	public void removeByCustomId(String customId) {
		for (CLMNajm clmNajm :
				findByCustomId(
					customId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(clmNajm);
		}
	}

	/**
	 * Returns the number of clm najms where customId = &#63;.
	 *
	 * @param customId the custom ID
	 * @return the number of matching clm najms
	 */
	@Override
	public int countByCustomId(String customId) {
		customId = Objects.toString(customId, "");

		FinderPath finderPath = _finderPathCountByCustomId;

		Object[] finderArgs = new Object[] {customId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLMNAJM_WHERE);

			boolean bindCustomId = false;

			if (customId.isEmpty()) {
				sb.append(_FINDER_COLUMN_CUSTOMID_CUSTOMID_3);
			}
			else {
				bindCustomId = true;

				sb.append(_FINDER_COLUMN_CUSTOMID_CUSTOMID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCustomId) {
					queryPos.add(customId);
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

	private static final String _FINDER_COLUMN_CUSTOMID_CUSTOMID_2 =
		"clmNajm.customId = ?";

	private static final String _FINDER_COLUMN_CUSTOMID_CUSTOMID_3 =
		"(clmNajm.customId IS NULL OR clmNajm.customId = '')";

	private FinderPath _finderPathFetchByCASE_NAMEEN;
	private FinderPath _finderPathCountByCASE_NAMEEN;

	/**
	 * Returns the clm najm where caseNo = &#63; and englishName = &#63; or throws a <code>NoSuchCLMNajmException</code> if it could not be found.
	 *
	 * @param caseNo the case no
	 * @param englishName the english name
	 * @return the matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm findByCASE_NAMEEN(String caseNo, String englishName)
		throws NoSuchCLMNajmException {

		CLMNajm clmNajm = fetchByCASE_NAMEEN(caseNo, englishName);

		if (clmNajm == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("caseNo=");
			sb.append(caseNo);

			sb.append(", englishName=");
			sb.append(englishName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCLMNajmException(sb.toString());
		}

		return clmNajm;
	}

	/**
	 * Returns the clm najm where caseNo = &#63; and englishName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param caseNo the case no
	 * @param englishName the english name
	 * @return the matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm fetchByCASE_NAMEEN(String caseNo, String englishName) {
		return fetchByCASE_NAMEEN(caseNo, englishName, true);
	}

	/**
	 * Returns the clm najm where caseNo = &#63; and englishName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param caseNo the case no
	 * @param englishName the english name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm fetchByCASE_NAMEEN(
		String caseNo, String englishName, boolean useFinderCache) {

		caseNo = Objects.toString(caseNo, "");
		englishName = Objects.toString(englishName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {caseNo, englishName};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByCASE_NAMEEN, finderArgs, this);
		}

		if (result instanceof CLMNajm) {
			CLMNajm clmNajm = (CLMNajm)result;

			if (!Objects.equals(caseNo, clmNajm.getCaseNo()) ||
				!Objects.equals(englishName, clmNajm.getEnglishName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CLMNAJM_WHERE);

			boolean bindCaseNo = false;

			if (caseNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_CASE_NAMEEN_CASENO_3);
			}
			else {
				bindCaseNo = true;

				sb.append(_FINDER_COLUMN_CASE_NAMEEN_CASENO_2);
			}

			boolean bindEnglishName = false;

			if (englishName.isEmpty()) {
				sb.append(_FINDER_COLUMN_CASE_NAMEEN_ENGLISHNAME_3);
			}
			else {
				bindEnglishName = true;

				sb.append(_FINDER_COLUMN_CASE_NAMEEN_ENGLISHNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCaseNo) {
					queryPos.add(caseNo);
				}

				if (bindEnglishName) {
					queryPos.add(englishName);
				}

				List<CLMNajm> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByCASE_NAMEEN, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {caseNo, englishName};
							}

							_log.warn(
								"CLMNajmPersistenceImpl.fetchByCASE_NAMEEN(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CLMNajm clmNajm = list.get(0);

					result = clmNajm;

					cacheResult(clmNajm);
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
			return (CLMNajm)result;
		}
	}

	/**
	 * Removes the clm najm where caseNo = &#63; and englishName = &#63; from the database.
	 *
	 * @param caseNo the case no
	 * @param englishName the english name
	 * @return the clm najm that was removed
	 */
	@Override
	public CLMNajm removeByCASE_NAMEEN(String caseNo, String englishName)
		throws NoSuchCLMNajmException {

		CLMNajm clmNajm = findByCASE_NAMEEN(caseNo, englishName);

		return remove(clmNajm);
	}

	/**
	 * Returns the number of clm najms where caseNo = &#63; and englishName = &#63;.
	 *
	 * @param caseNo the case no
	 * @param englishName the english name
	 * @return the number of matching clm najms
	 */
	@Override
	public int countByCASE_NAMEEN(String caseNo, String englishName) {
		caseNo = Objects.toString(caseNo, "");
		englishName = Objects.toString(englishName, "");

		FinderPath finderPath = _finderPathCountByCASE_NAMEEN;

		Object[] finderArgs = new Object[] {caseNo, englishName};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CLMNAJM_WHERE);

			boolean bindCaseNo = false;

			if (caseNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_CASE_NAMEEN_CASENO_3);
			}
			else {
				bindCaseNo = true;

				sb.append(_FINDER_COLUMN_CASE_NAMEEN_CASENO_2);
			}

			boolean bindEnglishName = false;

			if (englishName.isEmpty()) {
				sb.append(_FINDER_COLUMN_CASE_NAMEEN_ENGLISHNAME_3);
			}
			else {
				bindEnglishName = true;

				sb.append(_FINDER_COLUMN_CASE_NAMEEN_ENGLISHNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCaseNo) {
					queryPos.add(caseNo);
				}

				if (bindEnglishName) {
					queryPos.add(englishName);
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

	private static final String _FINDER_COLUMN_CASE_NAMEEN_CASENO_2 =
		"clmNajm.id.caseNo = ? AND ";

	private static final String _FINDER_COLUMN_CASE_NAMEEN_CASENO_3 =
		"(clmNajm.id.caseNo IS NULL OR clmNajm.id.caseNo = '') AND ";

	private static final String _FINDER_COLUMN_CASE_NAMEEN_ENGLISHNAME_2 =
		"clmNajm.englishName = ?";

	private static final String _FINDER_COLUMN_CASE_NAMEEN_ENGLISHNAME_3 =
		"(clmNajm.englishName IS NULL OR clmNajm.englishName = '')";

	private FinderPath _finderPathWithPaginationFindBycaseNo;
	private FinderPath _finderPathWithoutPaginationFindBycaseNo;
	private FinderPath _finderPathCountBycaseNo;

	/**
	 * Returns all the clm najms where caseNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @return the matching clm najms
	 */
	@Override
	public List<CLMNajm> findBycaseNo(String caseNo) {
		return findBycaseNo(caseNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clm najms where caseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param caseNo the case no
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @return the range of matching clm najms
	 */
	@Override
	public List<CLMNajm> findBycaseNo(String caseNo, int start, int end) {
		return findBycaseNo(caseNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the clm najms where caseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param caseNo the case no
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clm najms
	 */
	@Override
	public List<CLMNajm> findBycaseNo(
		String caseNo, int start, int end,
		OrderByComparator<CLMNajm> orderByComparator) {

		return findBycaseNo(caseNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the clm najms where caseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param caseNo the case no
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching clm najms
	 */
	@Override
	public List<CLMNajm> findBycaseNo(
		String caseNo, int start, int end,
		OrderByComparator<CLMNajm> orderByComparator, boolean useFinderCache) {

		caseNo = Objects.toString(caseNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBycaseNo;
				finderArgs = new Object[] {caseNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycaseNo;
			finderArgs = new Object[] {caseNo, start, end, orderByComparator};
		}

		List<CLMNajm> list = null;

		if (useFinderCache) {
			list = (List<CLMNajm>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CLMNajm clmNajm : list) {
					if (!caseNo.equals(clmNajm.getCaseNo())) {
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

			sb.append(_SQL_SELECT_CLMNAJM_WHERE);

			boolean bindCaseNo = false;

			if (caseNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_CASENO_CASENO_3);
			}
			else {
				bindCaseNo = true;

				sb.append(_FINDER_COLUMN_CASENO_CASENO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CLMNajmModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCaseNo) {
					queryPos.add(caseNo);
				}

				list = (List<CLMNajm>)QueryUtil.list(
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
	 * Returns the first clm najm in the ordered set where caseNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm findBycaseNo_First(
			String caseNo, OrderByComparator<CLMNajm> orderByComparator)
		throws NoSuchCLMNajmException {

		CLMNajm clmNajm = fetchBycaseNo_First(caseNo, orderByComparator);

		if (clmNajm != null) {
			return clmNajm;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("caseNo=");
		sb.append(caseNo);

		sb.append("}");

		throw new NoSuchCLMNajmException(sb.toString());
	}

	/**
	 * Returns the first clm najm in the ordered set where caseNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm fetchBycaseNo_First(
		String caseNo, OrderByComparator<CLMNajm> orderByComparator) {

		List<CLMNajm> list = findBycaseNo(caseNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last clm najm in the ordered set where caseNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm findBycaseNo_Last(
			String caseNo, OrderByComparator<CLMNajm> orderByComparator)
		throws NoSuchCLMNajmException {

		CLMNajm clmNajm = fetchBycaseNo_Last(caseNo, orderByComparator);

		if (clmNajm != null) {
			return clmNajm;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("caseNo=");
		sb.append(caseNo);

		sb.append("}");

		throw new NoSuchCLMNajmException(sb.toString());
	}

	/**
	 * Returns the last clm najm in the ordered set where caseNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	@Override
	public CLMNajm fetchBycaseNo_Last(
		String caseNo, OrderByComparator<CLMNajm> orderByComparator) {

		int count = countBycaseNo(caseNo);

		if (count == 0) {
			return null;
		}

		List<CLMNajm> list = findBycaseNo(
			caseNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the clm najms before and after the current clm najm in the ordered set where caseNo = &#63;.
	 *
	 * @param clmNajmPK the primary key of the current clm najm
	 * @param caseNo the case no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clm najm
	 * @throws NoSuchCLMNajmException if a clm najm with the primary key could not be found
	 */
	@Override
	public CLMNajm[] findBycaseNo_PrevAndNext(
			CLMNajmPK clmNajmPK, String caseNo,
			OrderByComparator<CLMNajm> orderByComparator)
		throws NoSuchCLMNajmException {

		caseNo = Objects.toString(caseNo, "");

		CLMNajm clmNajm = findByPrimaryKey(clmNajmPK);

		Session session = null;

		try {
			session = openSession();

			CLMNajm[] array = new CLMNajmImpl[3];

			array[0] = getBycaseNo_PrevAndNext(
				session, clmNajm, caseNo, orderByComparator, true);

			array[1] = clmNajm;

			array[2] = getBycaseNo_PrevAndNext(
				session, clmNajm, caseNo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CLMNajm getBycaseNo_PrevAndNext(
		Session session, CLMNajm clmNajm, String caseNo,
		OrderByComparator<CLMNajm> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLMNAJM_WHERE);

		boolean bindCaseNo = false;

		if (caseNo.isEmpty()) {
			sb.append(_FINDER_COLUMN_CASENO_CASENO_3);
		}
		else {
			bindCaseNo = true;

			sb.append(_FINDER_COLUMN_CASENO_CASENO_2);
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
			sb.append(CLMNajmModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCaseNo) {
			queryPos.add(caseNo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(clmNajm)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CLMNajm> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the clm najms where caseNo = &#63; from the database.
	 *
	 * @param caseNo the case no
	 */
	@Override
	public void removeBycaseNo(String caseNo) {
		for (CLMNajm clmNajm :
				findBycaseNo(
					caseNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(clmNajm);
		}
	}

	/**
	 * Returns the number of clm najms where caseNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @return the number of matching clm najms
	 */
	@Override
	public int countBycaseNo(String caseNo) {
		caseNo = Objects.toString(caseNo, "");

		FinderPath finderPath = _finderPathCountBycaseNo;

		Object[] finderArgs = new Object[] {caseNo};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLMNAJM_WHERE);

			boolean bindCaseNo = false;

			if (caseNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_CASENO_CASENO_3);
			}
			else {
				bindCaseNo = true;

				sb.append(_FINDER_COLUMN_CASENO_CASENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCaseNo) {
					queryPos.add(caseNo);
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

	private static final String _FINDER_COLUMN_CASENO_CASENO_2 =
		"clmNajm.id.caseNo = ?";

	private static final String _FINDER_COLUMN_CASENO_CASENO_3 =
		"(clmNajm.id.caseNo IS NULL OR clmNajm.id.caseNo = '')";

	public CLMNajmPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("caseNo", "CIAI_CASE_NO");
		dbColumnNames.put("cipiId", "CIPI_ID");
		dbColumnNames.put("callDt", "CIAI_CALL_DT");
		dbColumnNames.put("city", "CIAI_CITY");
		dbColumnNames.put("name", "CIPI_NAME");
		dbColumnNames.put("phoneNo", "CIPI_PHONE_NO");
		dbColumnNames.put("age", "CIPI_AGE");
		dbColumnNames.put("nationality", "CIPI_NATIONALITY");
		dbColumnNames.put("plateNo", "CIPI_PLATE_NO");
		dbColumnNames.put("liabiltiyPerc", "CIPI_LIABILITY_PERC");
		dbColumnNames.put("liabiltiyAmt", "CIPI_LIABILITY_AMT");
		dbColumnNames.put("customId", "CIPI_CUSTOM_ID");
		dbColumnNames.put("seqNo", "CIPI_SEQ_NO");
		dbColumnNames.put("englishName", "CIII_ENGLISH_NAME");
		dbColumnNames.put("polNo", "CIII_POL_NO");
		dbColumnNames.put("najmPlateNo", "CIII_NAJM_PLATE_NO");
		dbColumnNames.put("najmChassisNo", "CIII_NAJM_CHASSIS_NO");
		dbColumnNames.put("najmVEHNo", "CIII_NAJM_VEH_ID");
		dbColumnNames.put("causeAr", "CIAAI_CAUSE_ARB");
		dbColumnNames.put("causeEn", "CIAAI_CAUSE_ENG");

		setDBColumnNames(dbColumnNames);

		setModelClass(CLMNajm.class);

		setModelImplClass(CLMNajmImpl.class);
		setModelPKClass(CLMNajmPK.class);
	}

	/**
	 * Caches the clm najm in the entity cache if it is enabled.
	 *
	 * @param clmNajm the clm najm
	 */
	@Override
	public void cacheResult(CLMNajm clmNajm) {
		dummyEntityCache.putResult(
			CLMNajmImpl.class, clmNajm.getPrimaryKey(), clmNajm);

		dummyFinderCache.putResult(
			_finderPathFetchByCASE_PLATE,
			new Object[] {clmNajm.getCaseNo(), clmNajm.getNajmPlateNo()},
			clmNajm);

		dummyFinderCache.putResult(
			_finderPathFetchByCASE_CUSTOM,
			new Object[] {clmNajm.getCaseNo(), clmNajm.getCustomId()}, clmNajm);

		dummyFinderCache.putResult(
			_finderPathFetchByCASE_NAMEEN,
			new Object[] {clmNajm.getCaseNo(), clmNajm.getEnglishName()},
			clmNajm);
	}

	/**
	 * Caches the clm najms in the entity cache if it is enabled.
	 *
	 * @param clmNajms the clm najms
	 */
	@Override
	public void cacheResult(List<CLMNajm> clmNajms) {
		for (CLMNajm clmNajm : clmNajms) {
			if (dummyEntityCache.getResult(
					CLMNajmImpl.class, clmNajm.getPrimaryKey()) == null) {

				cacheResult(clmNajm);
			}
		}
	}

	/**
	 * Clears the cache for all clm najms.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(CLMNajmImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the clm najm.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CLMNajm clmNajm) {
		dummyEntityCache.removeResult(CLMNajmImpl.class, clmNajm);
	}

	@Override
	public void clearCache(List<CLMNajm> clmNajms) {
		for (CLMNajm clmNajm : clmNajms) {
			dummyEntityCache.removeResult(CLMNajmImpl.class, clmNajm);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(CLMNajmImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(CLMNajmModelImpl clmNajmModelImpl) {
		Object[] args = new Object[] {
			clmNajmModelImpl.getCaseNo(), clmNajmModelImpl.getNajmPlateNo()
		};

		dummyFinderCache.putResult(
			_finderPathCountByCASE_PLATE, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchByCASE_PLATE, args, clmNajmModelImpl, false);

		args = new Object[] {
			clmNajmModelImpl.getCaseNo(), clmNajmModelImpl.getCustomId()
		};

		dummyFinderCache.putResult(
			_finderPathCountByCASE_CUSTOM, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchByCASE_CUSTOM, args, clmNajmModelImpl, false);

		args = new Object[] {
			clmNajmModelImpl.getCaseNo(), clmNajmModelImpl.getEnglishName()
		};

		dummyFinderCache.putResult(
			_finderPathCountByCASE_NAMEEN, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchByCASE_NAMEEN, args, clmNajmModelImpl, false);
	}

	/**
	 * Creates a new clm najm with the primary key. Does not add the clm najm to the database.
	 *
	 * @param clmNajmPK the primary key for the new clm najm
	 * @return the new clm najm
	 */
	@Override
	public CLMNajm create(CLMNajmPK clmNajmPK) {
		CLMNajm clmNajm = new CLMNajmImpl();

		clmNajm.setNew(true);
		clmNajm.setPrimaryKey(clmNajmPK);

		return clmNajm;
	}

	/**
	 * Removes the clm najm with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clmNajmPK the primary key of the clm najm
	 * @return the clm najm that was removed
	 * @throws NoSuchCLMNajmException if a clm najm with the primary key could not be found
	 */
	@Override
	public CLMNajm remove(CLMNajmPK clmNajmPK) throws NoSuchCLMNajmException {
		return remove((Serializable)clmNajmPK);
	}

	/**
	 * Removes the clm najm with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the clm najm
	 * @return the clm najm that was removed
	 * @throws NoSuchCLMNajmException if a clm najm with the primary key could not be found
	 */
	@Override
	public CLMNajm remove(Serializable primaryKey)
		throws NoSuchCLMNajmException {

		Session session = null;

		try {
			session = openSession();

			CLMNajm clmNajm = (CLMNajm)session.get(
				CLMNajmImpl.class, primaryKey);

			if (clmNajm == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCLMNajmException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(clmNajm);
		}
		catch (NoSuchCLMNajmException noSuchEntityException) {
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
	protected CLMNajm removeImpl(CLMNajm clmNajm) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(clmNajm)) {
				clmNajm = (CLMNajm)session.get(
					CLMNajmImpl.class, clmNajm.getPrimaryKeyObj());
			}

			if (clmNajm != null) {
				session.delete(clmNajm);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (clmNajm != null) {
			clearCache(clmNajm);
		}

		return clmNajm;
	}

	@Override
	public CLMNajm updateImpl(CLMNajm clmNajm) {
		boolean isNew = clmNajm.isNew();

		if (!(clmNajm instanceof CLMNajmModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(clmNajm.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(clmNajm);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in clmNajm proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CLMNajm implementation " +
					clmNajm.getClass());
		}

		CLMNajmModelImpl clmNajmModelImpl = (CLMNajmModelImpl)clmNajm;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(clmNajm);
			}
			else {
				clmNajm = (CLMNajm)session.merge(clmNajm);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			CLMNajmImpl.class, clmNajmModelImpl, false, true);

		cacheUniqueFindersCache(clmNajmModelImpl);

		if (isNew) {
			clmNajm.setNew(false);
		}

		clmNajm.resetOriginalValues();

		return clmNajm;
	}

	/**
	 * Returns the clm najm with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the clm najm
	 * @return the clm najm
	 * @throws NoSuchCLMNajmException if a clm najm with the primary key could not be found
	 */
	@Override
	public CLMNajm findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCLMNajmException {

		CLMNajm clmNajm = fetchByPrimaryKey(primaryKey);

		if (clmNajm == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCLMNajmException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return clmNajm;
	}

	/**
	 * Returns the clm najm with the primary key or throws a <code>NoSuchCLMNajmException</code> if it could not be found.
	 *
	 * @param clmNajmPK the primary key of the clm najm
	 * @return the clm najm
	 * @throws NoSuchCLMNajmException if a clm najm with the primary key could not be found
	 */
	@Override
	public CLMNajm findByPrimaryKey(CLMNajmPK clmNajmPK)
		throws NoSuchCLMNajmException {

		return findByPrimaryKey((Serializable)clmNajmPK);
	}

	/**
	 * Returns the clm najm with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clmNajmPK the primary key of the clm najm
	 * @return the clm najm, or <code>null</code> if a clm najm with the primary key could not be found
	 */
	@Override
	public CLMNajm fetchByPrimaryKey(CLMNajmPK clmNajmPK) {
		return fetchByPrimaryKey((Serializable)clmNajmPK);
	}

	/**
	 * Returns all the clm najms.
	 *
	 * @return the clm najms
	 */
	@Override
	public List<CLMNajm> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clm najms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @return the range of clm najms
	 */
	@Override
	public List<CLMNajm> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the clm najms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clm najms
	 */
	@Override
	public List<CLMNajm> findAll(
		int start, int end, OrderByComparator<CLMNajm> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the clm najms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of clm najms
	 */
	@Override
	public List<CLMNajm> findAll(
		int start, int end, OrderByComparator<CLMNajm> orderByComparator,
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

		List<CLMNajm> list = null;

		if (useFinderCache) {
			list = (List<CLMNajm>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CLMNAJM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CLMNAJM;

				sql = sql.concat(CLMNajmModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CLMNajm>)QueryUtil.list(
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
	 * Removes all the clm najms from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CLMNajm clmNajm : findAll()) {
			remove(clmNajm);
		}
	}

	/**
	 * Returns the number of clm najms.
	 *
	 * @return the number of clm najms
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CLMNAJM);

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
		return "clmNajmPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLMNAJM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CLMNajmModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the clm najm persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CLMNajmModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CLMNajm.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByCASE_PLATE = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCASE_PLATE",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"CIAI_CASE_NO", "CIII_NAJM_PLATE_NO"}, true);

		_finderPathCountByCASE_PLATE = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCASE_PLATE",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"CIAI_CASE_NO", "CIII_NAJM_PLATE_NO"}, false);

		_finderPathFetchByCASE_CUSTOM = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCASE_CUSTOM",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"CIAI_CASE_NO", "CIPI_CUSTOM_ID"}, true);

		_finderPathCountByCASE_CUSTOM = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCASE_CUSTOM",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"CIAI_CASE_NO", "CIPI_CUSTOM_ID"}, false);

		_finderPathWithPaginationFindByNajmPlateNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNajmPlateNo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"CIII_NAJM_PLATE_NO"}, true);

		_finderPathWithoutPaginationFindByNajmPlateNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNajmPlateNo",
			new String[] {String.class.getName()},
			new String[] {"CIII_NAJM_PLATE_NO"}, true);

		_finderPathCountByNajmPlateNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNajmPlateNo",
			new String[] {String.class.getName()},
			new String[] {"CIII_NAJM_PLATE_NO"}, false);

		_finderPathWithPaginationFindByCustomId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCustomId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"CIPI_CUSTOM_ID"}, true);

		_finderPathWithoutPaginationFindByCustomId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCustomId",
			new String[] {String.class.getName()},
			new String[] {"CIPI_CUSTOM_ID"}, true);

		_finderPathCountByCustomId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCustomId",
			new String[] {String.class.getName()},
			new String[] {"CIPI_CUSTOM_ID"}, false);

		_finderPathFetchByCASE_NAMEEN = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCASE_NAMEEN",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"CIAI_CASE_NO", "CIII_ENGLISH_NAME"}, true);

		_finderPathCountByCASE_NAMEEN = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCASE_NAMEEN",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"CIAI_CASE_NO", "CIII_ENGLISH_NAME"}, false);

		_finderPathWithPaginationFindBycaseNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycaseNo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"CIAI_CASE_NO"}, true);

		_finderPathWithoutPaginationFindBycaseNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycaseNo",
			new String[] {String.class.getName()},
			new String[] {"CIAI_CASE_NO"}, true);

		_finderPathCountBycaseNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycaseNo",
			new String[] {String.class.getName()},
			new String[] {"CIAI_CASE_NO"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(CLMNajmImpl.class.getName());

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

	private static final String _SQL_SELECT_CLMNAJM =
		"SELECT clmNajm FROM CLMNajm clmNajm";

	private static final String _SQL_SELECT_CLMNAJM_WHERE =
		"SELECT clmNajm FROM CLMNajm clmNajm WHERE ";

	private static final String _SQL_COUNT_CLMNAJM =
		"SELECT COUNT(clmNajm) FROM CLMNajm clmNajm";

	private static final String _SQL_COUNT_CLMNAJM_WHERE =
		"SELECT COUNT(clmNajm) FROM CLMNajm clmNajm WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "clmNajm.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CLMNajm exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CLMNajm exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CLMNajmPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"caseNo", "cipiId", "callDt", "city", "name", "phoneNo", "age",
			"nationality", "plateNo", "liabiltiyPerc", "liabiltiyAmt",
			"customId", "seqNo", "englishName", "polNo", "najmPlateNo",
			"najmChassisNo", "najmVEHNo", "causeAr", "causeEn"
		});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"caseNo", "cipiId"});

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

	private static class CLMNajmModelArgumentsResolver
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

			CLMNajmModelImpl clmNajmModelImpl = (CLMNajmModelImpl)baseModel;

			long columnBitmask = clmNajmModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(clmNajmModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						clmNajmModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(clmNajmModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			CLMNajmModelImpl clmNajmModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = clmNajmModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = clmNajmModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}