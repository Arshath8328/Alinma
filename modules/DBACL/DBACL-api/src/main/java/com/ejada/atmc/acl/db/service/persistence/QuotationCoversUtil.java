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

import com.ejada.atmc.acl.db.model.QuotationCovers;

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
 * The persistence utility for the quotation covers service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.QuotationCoversPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationCoversPersistence
 * @generated
 */
public class QuotationCoversUtil {

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
	public static void clearCache(QuotationCovers quotationCovers) {
		getPersistence().clearCache(quotationCovers);
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
	public static Map<Serializable, QuotationCovers> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<QuotationCovers> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuotationCovers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuotationCovers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QuotationCovers> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QuotationCovers update(QuotationCovers quotationCovers) {
		return getPersistence().update(quotationCovers);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QuotationCovers update(
		QuotationCovers quotationCovers, ServiceContext serviceContext) {

		return getPersistence().update(quotationCovers, serviceContext);
	}

	/**
	 * Returns all the quotation coverses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation coverses
	 */
	public static List<QuotationCovers> findByQuotationId(long quotationId) {
		return getPersistence().findByQuotationId(quotationId);
	}

	/**
	 * Returns a range of all the quotation coverses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationCoversModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation coverses
	 * @param end the upper bound of the range of quotation coverses (not inclusive)
	 * @return the range of matching quotation coverses
	 */
	public static List<QuotationCovers> findByQuotationId(
		long quotationId, int start, int end) {

		return getPersistence().findByQuotationId(quotationId, start, end);
	}

	/**
	 * Returns an ordered range of all the quotation coverses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationCoversModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation coverses
	 * @param end the upper bound of the range of quotation coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotation coverses
	 */
	public static List<QuotationCovers> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<QuotationCovers> orderByComparator) {

		return getPersistence().findByQuotationId(
			quotationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the quotation coverses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationCoversModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation coverses
	 * @param end the upper bound of the range of quotation coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotation coverses
	 */
	public static List<QuotationCovers> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<QuotationCovers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByQuotationId(
			quotationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first quotation covers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation covers
	 * @throws NoSuchQuotationCoversException if a matching quotation covers could not be found
	 */
	public static QuotationCovers findByQuotationId_First(
			long quotationId,
			OrderByComparator<QuotationCovers> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationCoversException {

		return getPersistence().findByQuotationId_First(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the first quotation covers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation covers, or <code>null</code> if a matching quotation covers could not be found
	 */
	public static QuotationCovers fetchByQuotationId_First(
		long quotationId,
		OrderByComparator<QuotationCovers> orderByComparator) {

		return getPersistence().fetchByQuotationId_First(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the last quotation covers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation covers
	 * @throws NoSuchQuotationCoversException if a matching quotation covers could not be found
	 */
	public static QuotationCovers findByQuotationId_Last(
			long quotationId,
			OrderByComparator<QuotationCovers> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationCoversException {

		return getPersistence().findByQuotationId_Last(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the last quotation covers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation covers, or <code>null</code> if a matching quotation covers could not be found
	 */
	public static QuotationCovers fetchByQuotationId_Last(
		long quotationId,
		OrderByComparator<QuotationCovers> orderByComparator) {

		return getPersistence().fetchByQuotationId_Last(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the quotation coverses before and after the current quotation covers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationCoversPK the primary key of the current quotation covers
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation covers
	 * @throws NoSuchQuotationCoversException if a quotation covers with the primary key could not be found
	 */
	public static QuotationCovers[] findByQuotationId_PrevAndNext(
			QuotationCoversPK quotationCoversPK, long quotationId,
			OrderByComparator<QuotationCovers> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationCoversException {

		return getPersistence().findByQuotationId_PrevAndNext(
			quotationCoversPK, quotationId, orderByComparator);
	}

	/**
	 * Removes all the quotation coverses where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	public static void removeByQuotationId(long quotationId) {
		getPersistence().removeByQuotationId(quotationId);
	}

	/**
	 * Returns the number of quotation coverses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation coverses
	 */
	public static int countByQuotationId(long quotationId) {
		return getPersistence().countByQuotationId(quotationId);
	}

	/**
	 * Caches the quotation covers in the entity cache if it is enabled.
	 *
	 * @param quotationCovers the quotation covers
	 */
	public static void cacheResult(QuotationCovers quotationCovers) {
		getPersistence().cacheResult(quotationCovers);
	}

	/**
	 * Caches the quotation coverses in the entity cache if it is enabled.
	 *
	 * @param quotationCoverses the quotation coverses
	 */
	public static void cacheResult(List<QuotationCovers> quotationCoverses) {
		getPersistence().cacheResult(quotationCoverses);
	}

	/**
	 * Creates a new quotation covers with the primary key. Does not add the quotation covers to the database.
	 *
	 * @param quotationCoversPK the primary key for the new quotation covers
	 * @return the new quotation covers
	 */
	public static QuotationCovers create(QuotationCoversPK quotationCoversPK) {
		return getPersistence().create(quotationCoversPK);
	}

	/**
	 * Removes the quotation covers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quotationCoversPK the primary key of the quotation covers
	 * @return the quotation covers that was removed
	 * @throws NoSuchQuotationCoversException if a quotation covers with the primary key could not be found
	 */
	public static QuotationCovers remove(QuotationCoversPK quotationCoversPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationCoversException {

		return getPersistence().remove(quotationCoversPK);
	}

	public static QuotationCovers updateImpl(QuotationCovers quotationCovers) {
		return getPersistence().updateImpl(quotationCovers);
	}

	/**
	 * Returns the quotation covers with the primary key or throws a <code>NoSuchQuotationCoversException</code> if it could not be found.
	 *
	 * @param quotationCoversPK the primary key of the quotation covers
	 * @return the quotation covers
	 * @throws NoSuchQuotationCoversException if a quotation covers with the primary key could not be found
	 */
	public static QuotationCovers findByPrimaryKey(
			QuotationCoversPK quotationCoversPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationCoversException {

		return getPersistence().findByPrimaryKey(quotationCoversPK);
	}

	/**
	 * Returns the quotation covers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quotationCoversPK the primary key of the quotation covers
	 * @return the quotation covers, or <code>null</code> if a quotation covers with the primary key could not be found
	 */
	public static QuotationCovers fetchByPrimaryKey(
		QuotationCoversPK quotationCoversPK) {

		return getPersistence().fetchByPrimaryKey(quotationCoversPK);
	}

	/**
	 * Returns all the quotation coverses.
	 *
	 * @return the quotation coverses
	 */
	public static List<QuotationCovers> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the quotation coverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationCoversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation coverses
	 * @param end the upper bound of the range of quotation coverses (not inclusive)
	 * @return the range of quotation coverses
	 */
	public static List<QuotationCovers> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the quotation coverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationCoversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation coverses
	 * @param end the upper bound of the range of quotation coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotation coverses
	 */
	public static List<QuotationCovers> findAll(
		int start, int end,
		OrderByComparator<QuotationCovers> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the quotation coverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationCoversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation coverses
	 * @param end the upper bound of the range of quotation coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotation coverses
	 */
	public static List<QuotationCovers> findAll(
		int start, int end,
		OrderByComparator<QuotationCovers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the quotation coverses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of quotation coverses.
	 *
	 * @return the number of quotation coverses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static QuotationCoversPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QuotationCoversPersistence, QuotationCoversPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			QuotationCoversPersistence.class);

		ServiceTracker<QuotationCoversPersistence, QuotationCoversPersistence>
			serviceTracker =
				new ServiceTracker
					<QuotationCoversPersistence, QuotationCoversPersistence>(
						bundle.getBundleContext(),
						QuotationCoversPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}