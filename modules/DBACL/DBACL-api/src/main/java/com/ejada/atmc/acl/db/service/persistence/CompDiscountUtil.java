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

import com.ejada.atmc.acl.db.model.CompDiscount;

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
 * The persistence utility for the comp discount service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.CompDiscountPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompDiscountPersistence
 * @generated
 */
public class CompDiscountUtil {

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
	public static void clearCache(CompDiscount compDiscount) {
		getPersistence().clearCache(compDiscount);
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
	public static Map<Serializable, CompDiscount> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CompDiscount> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CompDiscount> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CompDiscount> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CompDiscount> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CompDiscount update(CompDiscount compDiscount) {
		return getPersistence().update(compDiscount);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CompDiscount update(
		CompDiscount compDiscount, ServiceContext serviceContext) {

		return getPersistence().update(compDiscount, serviceContext);
	}

	/**
	 * Caches the comp discount in the entity cache if it is enabled.
	 *
	 * @param compDiscount the comp discount
	 */
	public static void cacheResult(CompDiscount compDiscount) {
		getPersistence().cacheResult(compDiscount);
	}

	/**
	 * Caches the comp discounts in the entity cache if it is enabled.
	 *
	 * @param compDiscounts the comp discounts
	 */
	public static void cacheResult(List<CompDiscount> compDiscounts) {
		getPersistence().cacheResult(compDiscounts);
	}

	/**
	 * Creates a new comp discount with the primary key. Does not add the comp discount to the database.
	 *
	 * @param iqamaId the primary key for the new comp discount
	 * @return the new comp discount
	 */
	public static CompDiscount create(String iqamaId) {
		return getPersistence().create(iqamaId);
	}

	/**
	 * Removes the comp discount with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param iqamaId the primary key of the comp discount
	 * @return the comp discount that was removed
	 * @throws NoSuchCompDiscountException if a comp discount with the primary key could not be found
	 */
	public static CompDiscount remove(String iqamaId)
		throws com.ejada.atmc.acl.db.exception.NoSuchCompDiscountException {

		return getPersistence().remove(iqamaId);
	}

	public static CompDiscount updateImpl(CompDiscount compDiscount) {
		return getPersistence().updateImpl(compDiscount);
	}

	/**
	 * Returns the comp discount with the primary key or throws a <code>NoSuchCompDiscountException</code> if it could not be found.
	 *
	 * @param iqamaId the primary key of the comp discount
	 * @return the comp discount
	 * @throws NoSuchCompDiscountException if a comp discount with the primary key could not be found
	 */
	public static CompDiscount findByPrimaryKey(String iqamaId)
		throws com.ejada.atmc.acl.db.exception.NoSuchCompDiscountException {

		return getPersistence().findByPrimaryKey(iqamaId);
	}

	/**
	 * Returns the comp discount with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param iqamaId the primary key of the comp discount
	 * @return the comp discount, or <code>null</code> if a comp discount with the primary key could not be found
	 */
	public static CompDiscount fetchByPrimaryKey(String iqamaId) {
		return getPersistence().fetchByPrimaryKey(iqamaId);
	}

	/**
	 * Returns all the comp discounts.
	 *
	 * @return the comp discounts
	 */
	public static List<CompDiscount> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the comp discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompDiscountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comp discounts
	 * @param end the upper bound of the range of comp discounts (not inclusive)
	 * @return the range of comp discounts
	 */
	public static List<CompDiscount> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the comp discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompDiscountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comp discounts
	 * @param end the upper bound of the range of comp discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comp discounts
	 */
	public static List<CompDiscount> findAll(
		int start, int end, OrderByComparator<CompDiscount> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comp discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompDiscountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comp discounts
	 * @param end the upper bound of the range of comp discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of comp discounts
	 */
	public static List<CompDiscount> findAll(
		int start, int end, OrderByComparator<CompDiscount> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the comp discounts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of comp discounts.
	 *
	 * @return the number of comp discounts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CompDiscountPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CompDiscountPersistence, CompDiscountPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CompDiscountPersistence.class);

		ServiceTracker<CompDiscountPersistence, CompDiscountPersistence>
			serviceTracker =
				new ServiceTracker
					<CompDiscountPersistence, CompDiscountPersistence>(
						bundle.getBundleContext(),
						CompDiscountPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}