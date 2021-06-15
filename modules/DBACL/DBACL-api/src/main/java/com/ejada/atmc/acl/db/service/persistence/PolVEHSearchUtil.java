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

import com.ejada.atmc.acl.db.model.PolVEHSearch;

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
 * The persistence utility for the pol veh search service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.PolVEHSearchPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolVEHSearchPersistence
 * @generated
 */
public class PolVEHSearchUtil {

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
	public static void clearCache(PolVEHSearch polVEHSearch) {
		getPersistence().clearCache(polVEHSearch);
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
	public static Map<Serializable, PolVEHSearch> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PolVEHSearch> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PolVEHSearch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PolVEHSearch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PolVEHSearch> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PolVEHSearch update(PolVEHSearch polVEHSearch) {
		return getPersistence().update(polVEHSearch);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PolVEHSearch update(
		PolVEHSearch polVEHSearch, ServiceContext serviceContext) {

		return getPersistence().update(polVEHSearch, serviceContext);
	}

	/**
	 * Caches the pol veh search in the entity cache if it is enabled.
	 *
	 * @param polVEHSearch the pol veh search
	 */
	public static void cacheResult(PolVEHSearch polVEHSearch) {
		getPersistence().cacheResult(polVEHSearch);
	}

	/**
	 * Caches the pol veh searches in the entity cache if it is enabled.
	 *
	 * @param polVEHSearches the pol veh searches
	 */
	public static void cacheResult(List<PolVEHSearch> polVEHSearches) {
		getPersistence().cacheResult(polVEHSearches);
	}

	/**
	 * Creates a new pol veh search with the primary key. Does not add the pol veh search to the database.
	 *
	 * @param polVEHSearchPK the primary key for the new pol veh search
	 * @return the new pol veh search
	 */
	public static PolVEHSearch create(PolVEHSearchPK polVEHSearchPK) {
		return getPersistence().create(polVEHSearchPK);
	}

	/**
	 * Removes the pol veh search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param polVEHSearchPK the primary key of the pol veh search
	 * @return the pol veh search that was removed
	 * @throws NoSuchPolVEHSearchException if a pol veh search with the primary key could not be found
	 */
	public static PolVEHSearch remove(PolVEHSearchPK polVEHSearchPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolVEHSearchException {

		return getPersistence().remove(polVEHSearchPK);
	}

	public static PolVEHSearch updateImpl(PolVEHSearch polVEHSearch) {
		return getPersistence().updateImpl(polVEHSearch);
	}

	/**
	 * Returns the pol veh search with the primary key or throws a <code>NoSuchPolVEHSearchException</code> if it could not be found.
	 *
	 * @param polVEHSearchPK the primary key of the pol veh search
	 * @return the pol veh search
	 * @throws NoSuchPolVEHSearchException if a pol veh search with the primary key could not be found
	 */
	public static PolVEHSearch findByPrimaryKey(PolVEHSearchPK polVEHSearchPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolVEHSearchException {

		return getPersistence().findByPrimaryKey(polVEHSearchPK);
	}

	/**
	 * Returns the pol veh search with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param polVEHSearchPK the primary key of the pol veh search
	 * @return the pol veh search, or <code>null</code> if a pol veh search with the primary key could not be found
	 */
	public static PolVEHSearch fetchByPrimaryKey(
		PolVEHSearchPK polVEHSearchPK) {

		return getPersistence().fetchByPrimaryKey(polVEHSearchPK);
	}

	/**
	 * Returns all the pol veh searches.
	 *
	 * @return the pol veh searches
	 */
	public static List<PolVEHSearch> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the pol veh searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolVEHSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pol veh searches
	 * @param end the upper bound of the range of pol veh searches (not inclusive)
	 * @return the range of pol veh searches
	 */
	public static List<PolVEHSearch> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the pol veh searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolVEHSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pol veh searches
	 * @param end the upper bound of the range of pol veh searches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pol veh searches
	 */
	public static List<PolVEHSearch> findAll(
		int start, int end, OrderByComparator<PolVEHSearch> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pol veh searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolVEHSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pol veh searches
	 * @param end the upper bound of the range of pol veh searches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pol veh searches
	 */
	public static List<PolVEHSearch> findAll(
		int start, int end, OrderByComparator<PolVEHSearch> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the pol veh searches from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pol veh searches.
	 *
	 * @return the number of pol veh searches
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static PolVEHSearchPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PolVEHSearchPersistence, PolVEHSearchPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PolVEHSearchPersistence.class);

		ServiceTracker<PolVEHSearchPersistence, PolVEHSearchPersistence>
			serviceTracker =
				new ServiceTracker
					<PolVEHSearchPersistence, PolVEHSearchPersistence>(
						bundle.getBundleContext(),
						PolVEHSearchPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}