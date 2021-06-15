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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationsDriverLicenseException;
import com.ejada.atmc.acl.db.model.QuotationsDriverLicense;
import com.ejada.atmc.acl.db.model.impl.QuotationsDriverLicenseImpl;
import com.ejada.atmc.acl.db.model.impl.QuotationsDriverLicenseModelImpl;
import com.ejada.atmc.acl.db.service.persistence.QuotationsDriverLicensePersistence;
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
 * The persistence implementation for the quotations driver license service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = QuotationsDriverLicensePersistence.class)
public class QuotationsDriverLicensePersistenceImpl
	extends BasePersistenceImpl<QuotationsDriverLicense>
	implements QuotationsDriverLicensePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>QuotationsDriverLicenseUtil</code> to access the quotations driver license persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		QuotationsDriverLicenseImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByQuotationIdDriverId;
	private FinderPath _finderPathWithoutPaginationFindByQuotationIdDriverId;
	private FinderPath _finderPathCountByQuotationIdDriverId;

	/**
	 * Returns all the quotations driver licenses where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @return the matching quotations driver licenses
	 */
	@Override
	public List<QuotationsDriverLicense> findByQuotationIdDriverId(
		long quotationId, long driverId) {

		return findByQuotationIdDriverId(
			quotationId, driverId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotations driver licenses where quotationId = &#63; and driverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsDriverLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param start the lower bound of the range of quotations driver licenses
	 * @param end the upper bound of the range of quotations driver licenses (not inclusive)
	 * @return the range of matching quotations driver licenses
	 */
	@Override
	public List<QuotationsDriverLicense> findByQuotationIdDriverId(
		long quotationId, long driverId, int start, int end) {

		return findByQuotationIdDriverId(
			quotationId, driverId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotations driver licenses where quotationId = &#63; and driverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsDriverLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param start the lower bound of the range of quotations driver licenses
	 * @param end the upper bound of the range of quotations driver licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotations driver licenses
	 */
	@Override
	public List<QuotationsDriverLicense> findByQuotationIdDriverId(
		long quotationId, long driverId, int start, int end,
		OrderByComparator<QuotationsDriverLicense> orderByComparator) {

		return findByQuotationIdDriverId(
			quotationId, driverId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotations driver licenses where quotationId = &#63; and driverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsDriverLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param start the lower bound of the range of quotations driver licenses
	 * @param end the upper bound of the range of quotations driver licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotations driver licenses
	 */
	@Override
	public List<QuotationsDriverLicense> findByQuotationIdDriverId(
		long quotationId, long driverId, int start, int end,
		OrderByComparator<QuotationsDriverLicense> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByQuotationIdDriverId;
				finderArgs = new Object[] {quotationId, driverId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByQuotationIdDriverId;
			finderArgs = new Object[] {
				quotationId, driverId, start, end, orderByComparator
			};
		}

		List<QuotationsDriverLicense> list = null;

		if (useFinderCache) {
			list = (List<QuotationsDriverLicense>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (QuotationsDriverLicense quotationsDriverLicense : list) {
					if ((quotationId !=
							quotationsDriverLicense.getQuotationId()) ||
						(driverId != quotationsDriverLicense.getDriverId())) {

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

			sb.append(_SQL_SELECT_QUOTATIONSDRIVERLICENSE_WHERE);

			sb.append(_FINDER_COLUMN_QUOTATIONIDDRIVERID_QUOTATIONID_2);

			sb.append(_FINDER_COLUMN_QUOTATIONIDDRIVERID_DRIVERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuotationsDriverLicenseModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(quotationId);

				queryPos.add(driverId);

				list = (List<QuotationsDriverLicense>)QueryUtil.list(
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
	 * Returns the first quotations driver license in the ordered set where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations driver license
	 * @throws NoSuchQuotationsDriverLicenseException if a matching quotations driver license could not be found
	 */
	@Override
	public QuotationsDriverLicense findByQuotationIdDriverId_First(
			long quotationId, long driverId,
			OrderByComparator<QuotationsDriverLicense> orderByComparator)
		throws NoSuchQuotationsDriverLicenseException {

		QuotationsDriverLicense quotationsDriverLicense =
			fetchByQuotationIdDriverId_First(
				quotationId, driverId, orderByComparator);

		if (quotationsDriverLicense != null) {
			return quotationsDriverLicense;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quotationId=");
		sb.append(quotationId);

		sb.append(", driverId=");
		sb.append(driverId);

		sb.append("}");

		throw new NoSuchQuotationsDriverLicenseException(sb.toString());
	}

	/**
	 * Returns the first quotations driver license in the ordered set where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations driver license, or <code>null</code> if a matching quotations driver license could not be found
	 */
	@Override
	public QuotationsDriverLicense fetchByQuotationIdDriverId_First(
		long quotationId, long driverId,
		OrderByComparator<QuotationsDriverLicense> orderByComparator) {

		List<QuotationsDriverLicense> list = findByQuotationIdDriverId(
			quotationId, driverId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last quotations driver license in the ordered set where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations driver license
	 * @throws NoSuchQuotationsDriverLicenseException if a matching quotations driver license could not be found
	 */
	@Override
	public QuotationsDriverLicense findByQuotationIdDriverId_Last(
			long quotationId, long driverId,
			OrderByComparator<QuotationsDriverLicense> orderByComparator)
		throws NoSuchQuotationsDriverLicenseException {

		QuotationsDriverLicense quotationsDriverLicense =
			fetchByQuotationIdDriverId_Last(
				quotationId, driverId, orderByComparator);

		if (quotationsDriverLicense != null) {
			return quotationsDriverLicense;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quotationId=");
		sb.append(quotationId);

		sb.append(", driverId=");
		sb.append(driverId);

		sb.append("}");

		throw new NoSuchQuotationsDriverLicenseException(sb.toString());
	}

	/**
	 * Returns the last quotations driver license in the ordered set where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations driver license, or <code>null</code> if a matching quotations driver license could not be found
	 */
	@Override
	public QuotationsDriverLicense fetchByQuotationIdDriverId_Last(
		long quotationId, long driverId,
		OrderByComparator<QuotationsDriverLicense> orderByComparator) {

		int count = countByQuotationIdDriverId(quotationId, driverId);

		if (count == 0) {
			return null;
		}

		List<QuotationsDriverLicense> list = findByQuotationIdDriverId(
			quotationId, driverId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the quotations driver licenses before and after the current quotations driver license in the ordered set where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param licenseId the primary key of the current quotations driver license
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations driver license
	 * @throws NoSuchQuotationsDriverLicenseException if a quotations driver license with the primary key could not be found
	 */
	@Override
	public QuotationsDriverLicense[] findByQuotationIdDriverId_PrevAndNext(
			long licenseId, long quotationId, long driverId,
			OrderByComparator<QuotationsDriverLicense> orderByComparator)
		throws NoSuchQuotationsDriverLicenseException {

		QuotationsDriverLicense quotationsDriverLicense = findByPrimaryKey(
			licenseId);

		Session session = null;

		try {
			session = openSession();

			QuotationsDriverLicense[] array =
				new QuotationsDriverLicenseImpl[3];

			array[0] = getByQuotationIdDriverId_PrevAndNext(
				session, quotationsDriverLicense, quotationId, driverId,
				orderByComparator, true);

			array[1] = quotationsDriverLicense;

			array[2] = getByQuotationIdDriverId_PrevAndNext(
				session, quotationsDriverLicense, quotationId, driverId,
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

	protected QuotationsDriverLicense getByQuotationIdDriverId_PrevAndNext(
		Session session, QuotationsDriverLicense quotationsDriverLicense,
		long quotationId, long driverId,
		OrderByComparator<QuotationsDriverLicense> orderByComparator,
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

		sb.append(_SQL_SELECT_QUOTATIONSDRIVERLICENSE_WHERE);

		sb.append(_FINDER_COLUMN_QUOTATIONIDDRIVERID_QUOTATIONID_2);

		sb.append(_FINDER_COLUMN_QUOTATIONIDDRIVERID_DRIVERID_2);

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
			sb.append(QuotationsDriverLicenseModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(quotationId);

		queryPos.add(driverId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						quotationsDriverLicense)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<QuotationsDriverLicense> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the quotations driver licenses where quotationId = &#63; and driverId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 */
	@Override
	public void removeByQuotationIdDriverId(long quotationId, long driverId) {
		for (QuotationsDriverLicense quotationsDriverLicense :
				findByQuotationIdDriverId(
					quotationId, driverId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(quotationsDriverLicense);
		}
	}

	/**
	 * Returns the number of quotations driver licenses where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @return the number of matching quotations driver licenses
	 */
	@Override
	public int countByQuotationIdDriverId(long quotationId, long driverId) {
		FinderPath finderPath = _finderPathCountByQuotationIdDriverId;

		Object[] finderArgs = new Object[] {quotationId, driverId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_QUOTATIONSDRIVERLICENSE_WHERE);

			sb.append(_FINDER_COLUMN_QUOTATIONIDDRIVERID_QUOTATIONID_2);

			sb.append(_FINDER_COLUMN_QUOTATIONIDDRIVERID_DRIVERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(quotationId);

				queryPos.add(driverId);

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
		_FINDER_COLUMN_QUOTATIONIDDRIVERID_QUOTATIONID_2 =
			"quotationsDriverLicense.quotationId = ? AND ";

	private static final String _FINDER_COLUMN_QUOTATIONIDDRIVERID_DRIVERID_2 =
		"quotationsDriverLicense.driverId = ?";

	public QuotationsDriverLicensePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("licenseId", "LICENSE_ID");
		dbColumnNames.put("driverId", "DRIVER_ID");
		dbColumnNames.put("quotationId", "QUOTATIONS_ID");
		dbColumnNames.put("LicCountry", "LICENSE_COUNTRY");
		dbColumnNames.put("LicType", "LICENSE_TYPE");
		dbColumnNames.put("LicYrs", "LICENSE_YEARS");

		setDBColumnNames(dbColumnNames);

		setModelClass(QuotationsDriverLicense.class);

		setModelImplClass(QuotationsDriverLicenseImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the quotations driver license in the entity cache if it is enabled.
	 *
	 * @param quotationsDriverLicense the quotations driver license
	 */
	@Override
	public void cacheResult(QuotationsDriverLicense quotationsDriverLicense) {
		dummyEntityCache.putResult(
			QuotationsDriverLicenseImpl.class,
			quotationsDriverLicense.getPrimaryKey(), quotationsDriverLicense);
	}

	/**
	 * Caches the quotations driver licenses in the entity cache if it is enabled.
	 *
	 * @param quotationsDriverLicenses the quotations driver licenses
	 */
	@Override
	public void cacheResult(
		List<QuotationsDriverLicense> quotationsDriverLicenses) {

		for (QuotationsDriverLicense quotationsDriverLicense :
				quotationsDriverLicenses) {

			if (dummyEntityCache.getResult(
					QuotationsDriverLicenseImpl.class,
					quotationsDriverLicense.getPrimaryKey()) == null) {

				cacheResult(quotationsDriverLicense);
			}
		}
	}

	/**
	 * Clears the cache for all quotations driver licenses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(QuotationsDriverLicenseImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the quotations driver license.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuotationsDriverLicense quotationsDriverLicense) {
		dummyEntityCache.removeResult(
			QuotationsDriverLicenseImpl.class, quotationsDriverLicense);
	}

	@Override
	public void clearCache(
		List<QuotationsDriverLicense> quotationsDriverLicenses) {

		for (QuotationsDriverLicense quotationsDriverLicense :
				quotationsDriverLicenses) {

			dummyEntityCache.removeResult(
				QuotationsDriverLicenseImpl.class, quotationsDriverLicense);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				QuotationsDriverLicenseImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new quotations driver license with the primary key. Does not add the quotations driver license to the database.
	 *
	 * @param licenseId the primary key for the new quotations driver license
	 * @return the new quotations driver license
	 */
	@Override
	public QuotationsDriverLicense create(long licenseId) {
		QuotationsDriverLicense quotationsDriverLicense =
			new QuotationsDriverLicenseImpl();

		quotationsDriverLicense.setNew(true);
		quotationsDriverLicense.setPrimaryKey(licenseId);

		return quotationsDriverLicense;
	}

	/**
	 * Removes the quotations driver license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param licenseId the primary key of the quotations driver license
	 * @return the quotations driver license that was removed
	 * @throws NoSuchQuotationsDriverLicenseException if a quotations driver license with the primary key could not be found
	 */
	@Override
	public QuotationsDriverLicense remove(long licenseId)
		throws NoSuchQuotationsDriverLicenseException {

		return remove((Serializable)licenseId);
	}

	/**
	 * Removes the quotations driver license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the quotations driver license
	 * @return the quotations driver license that was removed
	 * @throws NoSuchQuotationsDriverLicenseException if a quotations driver license with the primary key could not be found
	 */
	@Override
	public QuotationsDriverLicense remove(Serializable primaryKey)
		throws NoSuchQuotationsDriverLicenseException {

		Session session = null;

		try {
			session = openSession();

			QuotationsDriverLicense quotationsDriverLicense =
				(QuotationsDriverLicense)session.get(
					QuotationsDriverLicenseImpl.class, primaryKey);

			if (quotationsDriverLicense == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuotationsDriverLicenseException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(quotationsDriverLicense);
		}
		catch (NoSuchQuotationsDriverLicenseException noSuchEntityException) {
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
	protected QuotationsDriverLicense removeImpl(
		QuotationsDriverLicense quotationsDriverLicense) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(quotationsDriverLicense)) {
				quotationsDriverLicense = (QuotationsDriverLicense)session.get(
					QuotationsDriverLicenseImpl.class,
					quotationsDriverLicense.getPrimaryKeyObj());
			}

			if (quotationsDriverLicense != null) {
				session.delete(quotationsDriverLicense);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (quotationsDriverLicense != null) {
			clearCache(quotationsDriverLicense);
		}

		return quotationsDriverLicense;
	}

	@Override
	public QuotationsDriverLicense updateImpl(
		QuotationsDriverLicense quotationsDriverLicense) {

		boolean isNew = quotationsDriverLicense.isNew();

		if (!(quotationsDriverLicense instanceof
				QuotationsDriverLicenseModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(quotationsDriverLicense.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					quotationsDriverLicense);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in quotationsDriverLicense proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom QuotationsDriverLicense implementation " +
					quotationsDriverLicense.getClass());
		}

		QuotationsDriverLicenseModelImpl quotationsDriverLicenseModelImpl =
			(QuotationsDriverLicenseModelImpl)quotationsDriverLicense;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(quotationsDriverLicense);
			}
			else {
				quotationsDriverLicense =
					(QuotationsDriverLicense)session.merge(
						quotationsDriverLicense);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			QuotationsDriverLicenseImpl.class, quotationsDriverLicenseModelImpl,
			false, true);

		if (isNew) {
			quotationsDriverLicense.setNew(false);
		}

		quotationsDriverLicense.resetOriginalValues();

		return quotationsDriverLicense;
	}

	/**
	 * Returns the quotations driver license with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the quotations driver license
	 * @return the quotations driver license
	 * @throws NoSuchQuotationsDriverLicenseException if a quotations driver license with the primary key could not be found
	 */
	@Override
	public QuotationsDriverLicense findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuotationsDriverLicenseException {

		QuotationsDriverLicense quotationsDriverLicense = fetchByPrimaryKey(
			primaryKey);

		if (quotationsDriverLicense == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuotationsDriverLicenseException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return quotationsDriverLicense;
	}

	/**
	 * Returns the quotations driver license with the primary key or throws a <code>NoSuchQuotationsDriverLicenseException</code> if it could not be found.
	 *
	 * @param licenseId the primary key of the quotations driver license
	 * @return the quotations driver license
	 * @throws NoSuchQuotationsDriverLicenseException if a quotations driver license with the primary key could not be found
	 */
	@Override
	public QuotationsDriverLicense findByPrimaryKey(long licenseId)
		throws NoSuchQuotationsDriverLicenseException {

		return findByPrimaryKey((Serializable)licenseId);
	}

	/**
	 * Returns the quotations driver license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param licenseId the primary key of the quotations driver license
	 * @return the quotations driver license, or <code>null</code> if a quotations driver license with the primary key could not be found
	 */
	@Override
	public QuotationsDriverLicense fetchByPrimaryKey(long licenseId) {
		return fetchByPrimaryKey((Serializable)licenseId);
	}

	/**
	 * Returns all the quotations driver licenses.
	 *
	 * @return the quotations driver licenses
	 */
	@Override
	public List<QuotationsDriverLicense> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotations driver licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsDriverLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations driver licenses
	 * @param end the upper bound of the range of quotations driver licenses (not inclusive)
	 * @return the range of quotations driver licenses
	 */
	@Override
	public List<QuotationsDriverLicense> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotations driver licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsDriverLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations driver licenses
	 * @param end the upper bound of the range of quotations driver licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotations driver licenses
	 */
	@Override
	public List<QuotationsDriverLicense> findAll(
		int start, int end,
		OrderByComparator<QuotationsDriverLicense> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotations driver licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsDriverLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations driver licenses
	 * @param end the upper bound of the range of quotations driver licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotations driver licenses
	 */
	@Override
	public List<QuotationsDriverLicense> findAll(
		int start, int end,
		OrderByComparator<QuotationsDriverLicense> orderByComparator,
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

		List<QuotationsDriverLicense> list = null;

		if (useFinderCache) {
			list = (List<QuotationsDriverLicense>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_QUOTATIONSDRIVERLICENSE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_QUOTATIONSDRIVERLICENSE;

				sql = sql.concat(
					QuotationsDriverLicenseModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<QuotationsDriverLicense>)QueryUtil.list(
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
	 * Removes all the quotations driver licenses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QuotationsDriverLicense quotationsDriverLicense : findAll()) {
			remove(quotationsDriverLicense);
		}
	}

	/**
	 * Returns the number of quotations driver licenses.
	 *
	 * @return the number of quotations driver licenses
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
					_SQL_COUNT_QUOTATIONSDRIVERLICENSE);

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
		return "LICENSE_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_QUOTATIONSDRIVERLICENSE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QuotationsDriverLicenseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the quotations driver license persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new QuotationsDriverLicenseModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", QuotationsDriverLicense.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByQuotationIdDriverId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQuotationIdDriverId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"QUOTATIONS_ID", "DRIVER_ID"}, true);

		_finderPathWithoutPaginationFindByQuotationIdDriverId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByQuotationIdDriverId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"QUOTATIONS_ID", "DRIVER_ID"}, true);

		_finderPathCountByQuotationIdDriverId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByQuotationIdDriverId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"QUOTATIONS_ID", "DRIVER_ID"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(
			QuotationsDriverLicenseImpl.class.getName());

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

	private static final String _SQL_SELECT_QUOTATIONSDRIVERLICENSE =
		"SELECT quotationsDriverLicense FROM QuotationsDriverLicense quotationsDriverLicense";

	private static final String _SQL_SELECT_QUOTATIONSDRIVERLICENSE_WHERE =
		"SELECT quotationsDriverLicense FROM QuotationsDriverLicense quotationsDriverLicense WHERE ";

	private static final String _SQL_COUNT_QUOTATIONSDRIVERLICENSE =
		"SELECT COUNT(quotationsDriverLicense) FROM QuotationsDriverLicense quotationsDriverLicense";

	private static final String _SQL_COUNT_QUOTATIONSDRIVERLICENSE_WHERE =
		"SELECT COUNT(quotationsDriverLicense) FROM QuotationsDriverLicense quotationsDriverLicense WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"quotationsDriverLicense.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No QuotationsDriverLicense exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No QuotationsDriverLicense exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		QuotationsDriverLicensePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"licenseId", "driverId", "quotationId", "LicCountry", "LicType",
			"LicYrs"
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

	private static class QuotationsDriverLicenseModelArgumentsResolver
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

			QuotationsDriverLicenseModelImpl quotationsDriverLicenseModelImpl =
				(QuotationsDriverLicenseModelImpl)baseModel;

			long columnBitmask =
				quotationsDriverLicenseModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					quotationsDriverLicenseModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						quotationsDriverLicenseModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					quotationsDriverLicenseModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			QuotationsDriverLicenseModelImpl quotationsDriverLicenseModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						quotationsDriverLicenseModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						quotationsDriverLicenseModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}