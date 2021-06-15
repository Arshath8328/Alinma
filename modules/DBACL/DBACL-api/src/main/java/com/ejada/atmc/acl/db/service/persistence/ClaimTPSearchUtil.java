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

import com.ejada.atmc.acl.db.model.ClaimTPSearch;

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
 * The persistence utility for the claim tp search service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.ClaimTPSearchPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimTPSearchPersistence
 * @generated
 */
public class ClaimTPSearchUtil {

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
	public static void clearCache(ClaimTPSearch claimTPSearch) {
		getPersistence().clearCache(claimTPSearch);
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
	public static Map<Serializable, ClaimTPSearch> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ClaimTPSearch> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ClaimTPSearch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ClaimTPSearch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ClaimTPSearch> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ClaimTPSearch update(ClaimTPSearch claimTPSearch) {
		return getPersistence().update(claimTPSearch);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ClaimTPSearch update(
		ClaimTPSearch claimTPSearch, ServiceContext serviceContext) {

		return getPersistence().update(claimTPSearch, serviceContext);
	}

	/**
	 * Caches the claim tp search in the entity cache if it is enabled.
	 *
	 * @param claimTPSearch the claim tp search
	 */
	public static void cacheResult(ClaimTPSearch claimTPSearch) {
		getPersistence().cacheResult(claimTPSearch);
	}

	/**
	 * Caches the claim tp searches in the entity cache if it is enabled.
	 *
	 * @param claimTPSearches the claim tp searches
	 */
	public static void cacheResult(List<ClaimTPSearch> claimTPSearches) {
		getPersistence().cacheResult(claimTPSearches);
	}

	/**
	 * Creates a new claim tp search with the primary key. Does not add the claim tp search to the database.
	 *
	 * @param claimTPSearchPK the primary key for the new claim tp search
	 * @return the new claim tp search
	 */
	public static ClaimTPSearch create(ClaimTPSearchPK claimTPSearchPK) {
		return getPersistence().create(claimTPSearchPK);
	}

	/**
	 * Removes the claim tp search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimTPSearchPK the primary key of the claim tp search
	 * @return the claim tp search that was removed
	 * @throws NoSuchClaimTPSearchException if a claim tp search with the primary key could not be found
	 */
	public static ClaimTPSearch remove(ClaimTPSearchPK claimTPSearchPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchClaimTPSearchException {

		return getPersistence().remove(claimTPSearchPK);
	}

	public static ClaimTPSearch updateImpl(ClaimTPSearch claimTPSearch) {
		return getPersistence().updateImpl(claimTPSearch);
	}

	/**
	 * Returns the claim tp search with the primary key or throws a <code>NoSuchClaimTPSearchException</code> if it could not be found.
	 *
	 * @param claimTPSearchPK the primary key of the claim tp search
	 * @return the claim tp search
	 * @throws NoSuchClaimTPSearchException if a claim tp search with the primary key could not be found
	 */
	public static ClaimTPSearch findByPrimaryKey(
			ClaimTPSearchPK claimTPSearchPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchClaimTPSearchException {

		return getPersistence().findByPrimaryKey(claimTPSearchPK);
	}

	/**
	 * Returns the claim tp search with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimTPSearchPK the primary key of the claim tp search
	 * @return the claim tp search, or <code>null</code> if a claim tp search with the primary key could not be found
	 */
	public static ClaimTPSearch fetchByPrimaryKey(
		ClaimTPSearchPK claimTPSearchPK) {

		return getPersistence().fetchByPrimaryKey(claimTPSearchPK);
	}

	/**
	 * Returns all the claim tp searches.
	 *
	 * @return the claim tp searches
	 */
	public static List<ClaimTPSearch> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the claim tp searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimTPSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim tp searches
	 * @param end the upper bound of the range of claim tp searches (not inclusive)
	 * @return the range of claim tp searches
	 */
	public static List<ClaimTPSearch> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the claim tp searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimTPSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim tp searches
	 * @param end the upper bound of the range of claim tp searches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of claim tp searches
	 */
	public static List<ClaimTPSearch> findAll(
		int start, int end,
		OrderByComparator<ClaimTPSearch> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the claim tp searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimTPSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim tp searches
	 * @param end the upper bound of the range of claim tp searches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of claim tp searches
	 */
	public static List<ClaimTPSearch> findAll(
		int start, int end, OrderByComparator<ClaimTPSearch> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the claim tp searches from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of claim tp searches.
	 *
	 * @return the number of claim tp searches
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static ClaimTPSearchPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ClaimTPSearchPersistence, ClaimTPSearchPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ClaimTPSearchPersistence.class);

		ServiceTracker<ClaimTPSearchPersistence, ClaimTPSearchPersistence>
			serviceTracker =
				new ServiceTracker
					<ClaimTPSearchPersistence, ClaimTPSearchPersistence>(
						bundle.getBundleContext(),
						ClaimTPSearchPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}