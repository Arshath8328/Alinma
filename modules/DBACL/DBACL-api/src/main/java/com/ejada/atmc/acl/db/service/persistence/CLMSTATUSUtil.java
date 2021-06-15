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

import com.ejada.atmc.acl.db.model.CLMSTATUS;

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
 * The persistence utility for the clmstatus service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.CLMSTATUSPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CLMSTATUSPersistence
 * @generated
 */
public class CLMSTATUSUtil {

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
	public static void clearCache(CLMSTATUS clmstatus) {
		getPersistence().clearCache(clmstatus);
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
	public static Map<Serializable, CLMSTATUS> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CLMSTATUS> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CLMSTATUS> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CLMSTATUS> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CLMSTATUS> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CLMSTATUS update(CLMSTATUS clmstatus) {
		return getPersistence().update(clmstatus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CLMSTATUS update(
		CLMSTATUS clmstatus, ServiceContext serviceContext) {

		return getPersistence().update(clmstatus, serviceContext);
	}

	/**
	 * Caches the clmstatus in the entity cache if it is enabled.
	 *
	 * @param clmstatus the clmstatus
	 */
	public static void cacheResult(CLMSTATUS clmstatus) {
		getPersistence().cacheResult(clmstatus);
	}

	/**
	 * Caches the clmstatuses in the entity cache if it is enabled.
	 *
	 * @param clmstatuses the clmstatuses
	 */
	public static void cacheResult(List<CLMSTATUS> clmstatuses) {
		getPersistence().cacheResult(clmstatuses);
	}

	/**
	 * Creates a new clmstatus with the primary key. Does not add the clmstatus to the database.
	 *
	 * @param RefNo the primary key for the new clmstatus
	 * @return the new clmstatus
	 */
	public static CLMSTATUS create(String RefNo) {
		return getPersistence().create(RefNo);
	}

	/**
	 * Removes the clmstatus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param RefNo the primary key of the clmstatus
	 * @return the clmstatus that was removed
	 * @throws NoSuchCLMSTATUSException if a clmstatus with the primary key could not be found
	 */
	public static CLMSTATUS remove(String RefNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMSTATUSException {

		return getPersistence().remove(RefNo);
	}

	public static CLMSTATUS updateImpl(CLMSTATUS clmstatus) {
		return getPersistence().updateImpl(clmstatus);
	}

	/**
	 * Returns the clmstatus with the primary key or throws a <code>NoSuchCLMSTATUSException</code> if it could not be found.
	 *
	 * @param RefNo the primary key of the clmstatus
	 * @return the clmstatus
	 * @throws NoSuchCLMSTATUSException if a clmstatus with the primary key could not be found
	 */
	public static CLMSTATUS findByPrimaryKey(String RefNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMSTATUSException {

		return getPersistence().findByPrimaryKey(RefNo);
	}

	/**
	 * Returns the clmstatus with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param RefNo the primary key of the clmstatus
	 * @return the clmstatus, or <code>null</code> if a clmstatus with the primary key could not be found
	 */
	public static CLMSTATUS fetchByPrimaryKey(String RefNo) {
		return getPersistence().fetchByPrimaryKey(RefNo);
	}

	/**
	 * Returns all the clmstatuses.
	 *
	 * @return the clmstatuses
	 */
	public static List<CLMSTATUS> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the clmstatuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatuses
	 * @param end the upper bound of the range of clmstatuses (not inclusive)
	 * @return the range of clmstatuses
	 */
	public static List<CLMSTATUS> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the clmstatuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatuses
	 * @param end the upper bound of the range of clmstatuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clmstatuses
	 */
	public static List<CLMSTATUS> findAll(
		int start, int end, OrderByComparator<CLMSTATUS> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the clmstatuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatuses
	 * @param end the upper bound of the range of clmstatuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of clmstatuses
	 */
	public static List<CLMSTATUS> findAll(
		int start, int end, OrderByComparator<CLMSTATUS> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the clmstatuses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of clmstatuses.
	 *
	 * @return the number of clmstatuses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CLMSTATUSPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CLMSTATUSPersistence, CLMSTATUSPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CLMSTATUSPersistence.class);

		ServiceTracker<CLMSTATUSPersistence, CLMSTATUSPersistence>
			serviceTracker =
				new ServiceTracker<CLMSTATUSPersistence, CLMSTATUSPersistence>(
					bundle.getBundleContext(), CLMSTATUSPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}