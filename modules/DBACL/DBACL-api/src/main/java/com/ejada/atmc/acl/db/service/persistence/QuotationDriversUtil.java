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

package com.ejada.atmc.acl.db.service.persistence;

import com.ejada.atmc.acl.db.model.QuotationDrivers;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the quotation drivers service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.QuotationDriversPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationDriversPersistence
 * @generated
 */
public class QuotationDriversUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(QuotationDrivers quotationDrivers) {
		getPersistence().clearCache(quotationDrivers);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, QuotationDrivers> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<QuotationDrivers> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuotationDrivers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuotationDrivers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QuotationDrivers> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QuotationDrivers update(QuotationDrivers quotationDrivers) {
		return getPersistence().update(quotationDrivers);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QuotationDrivers update(
		QuotationDrivers quotationDrivers, ServiceContext serviceContext) {

		return getPersistence().update(quotationDrivers, serviceContext);
	}

	/**
	 * Returns the quotation drivers where addDriverId = &#63; and quotationId = &#63; or throws a <code>NoSuchQuotationDriversException</code> if it could not be found.
	 *
	 * @param addDriverId the add driver ID
	 * @param quotationId the quotation ID
	 * @return the matching quotation drivers
	 * @throws NoSuchQuotationDriversException if a matching quotation drivers could not be found
	 */
	public static QuotationDrivers findByAddDriverIdQuotationId(
			long addDriverId, long quotationId)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationDriversException {

		return getPersistence().findByAddDriverIdQuotationId(
			addDriverId, quotationId);
	}

	/**
	 * Returns the quotation drivers where addDriverId = &#63; and quotationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param addDriverId the add driver ID
	 * @param quotationId the quotation ID
	 * @return the matching quotation drivers, or <code>null</code> if a matching quotation drivers could not be found
	 */
	public static QuotationDrivers fetchByAddDriverIdQuotationId(
		long addDriverId, long quotationId) {

		return getPersistence().fetchByAddDriverIdQuotationId(
			addDriverId, quotationId);
	}

	/**
	 * Returns the quotation drivers where addDriverId = &#63; and quotationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param addDriverId the add driver ID
	 * @param quotationId the quotation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotation drivers, or <code>null</code> if a matching quotation drivers could not be found
	 */
	public static QuotationDrivers fetchByAddDriverIdQuotationId(
		long addDriverId, long quotationId, boolean useFinderCache) {

		return getPersistence().fetchByAddDriverIdQuotationId(
			addDriverId, quotationId, useFinderCache);
	}

	/**
	 * Removes the quotation drivers where addDriverId = &#63; and quotationId = &#63; from the database.
	 *
	 * @param addDriverId the add driver ID
	 * @param quotationId the quotation ID
	 * @return the quotation drivers that was removed
	 */
	public static QuotationDrivers removeByAddDriverIdQuotationId(
			long addDriverId, long quotationId)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationDriversException {

		return getPersistence().removeByAddDriverIdQuotationId(
			addDriverId, quotationId);
	}

	/**
	 * Returns the number of quotation driverses where addDriverId = &#63; and quotationId = &#63;.
	 *
	 * @param addDriverId the add driver ID
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation driverses
	 */
	public static int countByAddDriverIdQuotationId(
		long addDriverId, long quotationId) {

		return getPersistence().countByAddDriverIdQuotationId(
			addDriverId, quotationId);
	}

	/**
	 * Returns all the quotation driverses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation driverses
	 */
	public static List<QuotationDrivers> findByQuotationId(long quotationId) {
		return getPersistence().findByQuotationId(quotationId);
	}

	/**
	 * Returns a range of all the quotation driverses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @return the range of matching quotation driverses
	 */
	public static List<QuotationDrivers> findByQuotationId(
		long quotationId, int start, int end) {

		return getPersistence().findByQuotationId(quotationId, start, end);
	}

	/**
	 * Returns an ordered range of all the quotation driverses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotation driverses
	 */
	public static List<QuotationDrivers> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<QuotationDrivers> orderByComparator) {

		return getPersistence().findByQuotationId(
			quotationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the quotation driverses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotation driverses
	 */
	public static List<QuotationDrivers> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<QuotationDrivers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByQuotationId(
			quotationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first quotation drivers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation drivers
	 * @throws NoSuchQuotationDriversException if a matching quotation drivers could not be found
	 */
	public static QuotationDrivers findByQuotationId_First(
			long quotationId,
			OrderByComparator<QuotationDrivers> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationDriversException {

		return getPersistence().findByQuotationId_First(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the first quotation drivers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation drivers, or <code>null</code> if a matching quotation drivers could not be found
	 */
	public static QuotationDrivers fetchByQuotationId_First(
		long quotationId,
		OrderByComparator<QuotationDrivers> orderByComparator) {

		return getPersistence().fetchByQuotationId_First(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the last quotation drivers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation drivers
	 * @throws NoSuchQuotationDriversException if a matching quotation drivers could not be found
	 */
	public static QuotationDrivers findByQuotationId_Last(
			long quotationId,
			OrderByComparator<QuotationDrivers> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationDriversException {

		return getPersistence().findByQuotationId_Last(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the last quotation drivers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation drivers, or <code>null</code> if a matching quotation drivers could not be found
	 */
	public static QuotationDrivers fetchByQuotationId_Last(
		long quotationId,
		OrderByComparator<QuotationDrivers> orderByComparator) {

		return getPersistence().fetchByQuotationId_Last(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the quotation driverses before and after the current quotation drivers in the ordered set where quotationId = &#63;.
	 *
	 * @param addDriverId the primary key of the current quotation drivers
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation drivers
	 * @throws NoSuchQuotationDriversException if a quotation drivers with the primary key could not be found
	 */
	public static QuotationDrivers[] findByQuotationId_PrevAndNext(
			long addDriverId, long quotationId,
			OrderByComparator<QuotationDrivers> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationDriversException {

		return getPersistence().findByQuotationId_PrevAndNext(
			addDriverId, quotationId, orderByComparator);
	}

	/**
	 * Removes all the quotation driverses where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	public static void removeByQuotationId(long quotationId) {
		getPersistence().removeByQuotationId(quotationId);
	}

	/**
	 * Returns the number of quotation driverses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation driverses
	 */
	public static int countByQuotationId(long quotationId) {
		return getPersistence().countByQuotationId(quotationId);
	}

	/**
	 * Returns all the quotation driverses where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @return the matching quotation driverses
	 */
	public static List<QuotationDrivers> findByQuotationIdIsDriverUnder21(
		boolean isDriverUnder21, long quotationId) {

		return getPersistence().findByQuotationIdIsDriverUnder21(
			isDriverUnder21, quotationId);
	}

	/**
	 * Returns a range of all the quotation driverses where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @return the range of matching quotation driverses
	 */
	public static List<QuotationDrivers> findByQuotationIdIsDriverUnder21(
		boolean isDriverUnder21, long quotationId, int start, int end) {

		return getPersistence().findByQuotationIdIsDriverUnder21(
			isDriverUnder21, quotationId, start, end);
	}

	/**
	 * Returns an ordered range of all the quotation driverses where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotation driverses
	 */
	public static List<QuotationDrivers> findByQuotationIdIsDriverUnder21(
		boolean isDriverUnder21, long quotationId, int start, int end,
		OrderByComparator<QuotationDrivers> orderByComparator) {

		return getPersistence().findByQuotationIdIsDriverUnder21(
			isDriverUnder21, quotationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the quotation driverses where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotation driverses
	 */
	public static List<QuotationDrivers> findByQuotationIdIsDriverUnder21(
		boolean isDriverUnder21, long quotationId, int start, int end,
		OrderByComparator<QuotationDrivers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByQuotationIdIsDriverUnder21(
			isDriverUnder21, quotationId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first quotation drivers in the ordered set where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation drivers
	 * @throws NoSuchQuotationDriversException if a matching quotation drivers could not be found
	 */
	public static QuotationDrivers findByQuotationIdIsDriverUnder21_First(
			boolean isDriverUnder21, long quotationId,
			OrderByComparator<QuotationDrivers> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationDriversException {

		return getPersistence().findByQuotationIdIsDriverUnder21_First(
			isDriverUnder21, quotationId, orderByComparator);
	}

	/**
	 * Returns the first quotation drivers in the ordered set where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation drivers, or <code>null</code> if a matching quotation drivers could not be found
	 */
	public static QuotationDrivers fetchByQuotationIdIsDriverUnder21_First(
		boolean isDriverUnder21, long quotationId,
		OrderByComparator<QuotationDrivers> orderByComparator) {

		return getPersistence().fetchByQuotationIdIsDriverUnder21_First(
			isDriverUnder21, quotationId, orderByComparator);
	}

	/**
	 * Returns the last quotation drivers in the ordered set where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation drivers
	 * @throws NoSuchQuotationDriversException if a matching quotation drivers could not be found
	 */
	public static QuotationDrivers findByQuotationIdIsDriverUnder21_Last(
			boolean isDriverUnder21, long quotationId,
			OrderByComparator<QuotationDrivers> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationDriversException {

		return getPersistence().findByQuotationIdIsDriverUnder21_Last(
			isDriverUnder21, quotationId, orderByComparator);
	}

	/**
	 * Returns the last quotation drivers in the ordered set where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation drivers, or <code>null</code> if a matching quotation drivers could not be found
	 */
	public static QuotationDrivers fetchByQuotationIdIsDriverUnder21_Last(
		boolean isDriverUnder21, long quotationId,
		OrderByComparator<QuotationDrivers> orderByComparator) {

		return getPersistence().fetchByQuotationIdIsDriverUnder21_Last(
			isDriverUnder21, quotationId, orderByComparator);
	}

	/**
	 * Returns the quotation driverses before and after the current quotation drivers in the ordered set where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param addDriverId the primary key of the current quotation drivers
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation drivers
	 * @throws NoSuchQuotationDriversException if a quotation drivers with the primary key could not be found
	 */
	public static QuotationDrivers[]
			findByQuotationIdIsDriverUnder21_PrevAndNext(
				long addDriverId, boolean isDriverUnder21, long quotationId,
				OrderByComparator<QuotationDrivers> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationDriversException {

		return getPersistence().findByQuotationIdIsDriverUnder21_PrevAndNext(
			addDriverId, isDriverUnder21, quotationId, orderByComparator);
	}

	/**
	 * Removes all the quotation driverses where isDriverUnder21 = &#63; and quotationId = &#63; from the database.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 */
	public static void removeByQuotationIdIsDriverUnder21(
		boolean isDriverUnder21, long quotationId) {

		getPersistence().removeByQuotationIdIsDriverUnder21(
			isDriverUnder21, quotationId);
	}

	/**
	 * Returns the number of quotation driverses where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation driverses
	 */
	public static int countByQuotationIdIsDriverUnder21(
		boolean isDriverUnder21, long quotationId) {

		return getPersistence().countByQuotationIdIsDriverUnder21(
			isDriverUnder21, quotationId);
	}

	/**
	 * Caches the quotation drivers in the entity cache if it is enabled.
	 *
	 * @param quotationDrivers the quotation drivers
	 */
	public static void cacheResult(QuotationDrivers quotationDrivers) {
		getPersistence().cacheResult(quotationDrivers);
	}

	/**
	 * Caches the quotation driverses in the entity cache if it is enabled.
	 *
	 * @param quotationDriverses the quotation driverses
	 */
	public static void cacheResult(List<QuotationDrivers> quotationDriverses) {
		getPersistence().cacheResult(quotationDriverses);
	}

	/**
	 * Creates a new quotation drivers with the primary key. Does not add the quotation drivers to the database.
	 *
	 * @param addDriverId the primary key for the new quotation drivers
	 * @return the new quotation drivers
	 */
	public static QuotationDrivers create(long addDriverId) {
		return getPersistence().create(addDriverId);
	}

	/**
	 * Removes the quotation drivers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addDriverId the primary key of the quotation drivers
	 * @return the quotation drivers that was removed
	 * @throws NoSuchQuotationDriversException if a quotation drivers with the primary key could not be found
	 */
	public static QuotationDrivers remove(long addDriverId)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationDriversException {

		return getPersistence().remove(addDriverId);
	}

	public static QuotationDrivers updateImpl(
		QuotationDrivers quotationDrivers) {

		return getPersistence().updateImpl(quotationDrivers);
	}

	/**
	 * Returns the quotation drivers with the primary key or throws a <code>NoSuchQuotationDriversException</code> if it could not be found.
	 *
	 * @param addDriverId the primary key of the quotation drivers
	 * @return the quotation drivers
	 * @throws NoSuchQuotationDriversException if a quotation drivers with the primary key could not be found
	 */
	public static QuotationDrivers findByPrimaryKey(long addDriverId)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationDriversException {

		return getPersistence().findByPrimaryKey(addDriverId);
	}

	/**
	 * Returns the quotation drivers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addDriverId the primary key of the quotation drivers
	 * @return the quotation drivers, or <code>null</code> if a quotation drivers with the primary key could not be found
	 */
	public static QuotationDrivers fetchByPrimaryKey(long addDriverId) {
		return getPersistence().fetchByPrimaryKey(addDriverId);
	}

	/**
	 * Returns all the quotation driverses.
	 *
	 * @return the quotation driverses
	 */
	public static List<QuotationDrivers> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the quotation driverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @return the range of quotation driverses
	 */
	public static List<QuotationDrivers> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the quotation driverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotation driverses
	 */
	public static List<QuotationDrivers> findAll(
		int start, int end,
		OrderByComparator<QuotationDrivers> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the quotation driverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotation driverses
	 */
	public static List<QuotationDrivers> findAll(
		int start, int end,
		OrderByComparator<QuotationDrivers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the quotation driverses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of quotation driverses.
	 *
	 * @return the number of quotation driverses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QuotationDriversPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QuotationDriversPersistence, QuotationDriversPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			QuotationDriversPersistence.class);

		ServiceTracker<QuotationDriversPersistence, QuotationDriversPersistence>
			serviceTracker =
				new ServiceTracker
					<QuotationDriversPersistence, QuotationDriversPersistence>(
						bundle.getBundleContext(),
						QuotationDriversPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}