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

import com.ejada.atmc.acl.db.model.PayFortRef;

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
 * The persistence utility for the pay fort ref service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.PayFortRefPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayFortRefPersistence
 * @generated
 */
public class PayFortRefUtil {

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
	public static void clearCache(PayFortRef payFortRef) {
		getPersistence().clearCache(payFortRef);
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
	public static Map<Serializable, PayFortRef> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PayFortRef> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PayFortRef> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PayFortRef> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PayFortRef> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PayFortRef update(PayFortRef payFortRef) {
		return getPersistence().update(payFortRef);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PayFortRef update(
		PayFortRef payFortRef, ServiceContext serviceContext) {

		return getPersistence().update(payFortRef, serviceContext);
	}

	/**
	 * Returns the pay fort ref where payFortRefNo = &#63; and status = &#63; or throws a <code>NoSuchPayFortRefException</code> if it could not be found.
	 *
	 * @param payFortRefNo the pay fort ref no
	 * @param status the status
	 * @return the matching pay fort ref
	 * @throws NoSuchPayFortRefException if a matching pay fort ref could not be found
	 */
	public static PayFortRef findByrefNoStatus(
			String payFortRefNo, String status)
		throws com.ejada.atmc.acl.db.exception.NoSuchPayFortRefException {

		return getPersistence().findByrefNoStatus(payFortRefNo, status);
	}

	/**
	 * Returns the pay fort ref where payFortRefNo = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param payFortRefNo the pay fort ref no
	 * @param status the status
	 * @return the matching pay fort ref, or <code>null</code> if a matching pay fort ref could not be found
	 */
	public static PayFortRef fetchByrefNoStatus(
		String payFortRefNo, String status) {

		return getPersistence().fetchByrefNoStatus(payFortRefNo, status);
	}

	/**
	 * Returns the pay fort ref where payFortRefNo = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param payFortRefNo the pay fort ref no
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pay fort ref, or <code>null</code> if a matching pay fort ref could not be found
	 */
	public static PayFortRef fetchByrefNoStatus(
		String payFortRefNo, String status, boolean useFinderCache) {

		return getPersistence().fetchByrefNoStatus(
			payFortRefNo, status, useFinderCache);
	}

	/**
	 * Removes the pay fort ref where payFortRefNo = &#63; and status = &#63; from the database.
	 *
	 * @param payFortRefNo the pay fort ref no
	 * @param status the status
	 * @return the pay fort ref that was removed
	 */
	public static PayFortRef removeByrefNoStatus(
			String payFortRefNo, String status)
		throws com.ejada.atmc.acl.db.exception.NoSuchPayFortRefException {

		return getPersistence().removeByrefNoStatus(payFortRefNo, status);
	}

	/**
	 * Returns the number of pay fort refs where payFortRefNo = &#63; and status = &#63;.
	 *
	 * @param payFortRefNo the pay fort ref no
	 * @param status the status
	 * @return the number of matching pay fort refs
	 */
	public static int countByrefNoStatus(String payFortRefNo, String status) {
		return getPersistence().countByrefNoStatus(payFortRefNo, status);
	}

	/**
	 * Caches the pay fort ref in the entity cache if it is enabled.
	 *
	 * @param payFortRef the pay fort ref
	 */
	public static void cacheResult(PayFortRef payFortRef) {
		getPersistence().cacheResult(payFortRef);
	}

	/**
	 * Caches the pay fort refs in the entity cache if it is enabled.
	 *
	 * @param payFortRefs the pay fort refs
	 */
	public static void cacheResult(List<PayFortRef> payFortRefs) {
		getPersistence().cacheResult(payFortRefs);
	}

	/**
	 * Creates a new pay fort ref with the primary key. Does not add the pay fort ref to the database.
	 *
	 * @param id the primary key for the new pay fort ref
	 * @return the new pay fort ref
	 */
	public static PayFortRef create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the pay fort ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the pay fort ref
	 * @return the pay fort ref that was removed
	 * @throws NoSuchPayFortRefException if a pay fort ref with the primary key could not be found
	 */
	public static PayFortRef remove(int id)
		throws com.ejada.atmc.acl.db.exception.NoSuchPayFortRefException {

		return getPersistence().remove(id);
	}

	public static PayFortRef updateImpl(PayFortRef payFortRef) {
		return getPersistence().updateImpl(payFortRef);
	}

	/**
	 * Returns the pay fort ref with the primary key or throws a <code>NoSuchPayFortRefException</code> if it could not be found.
	 *
	 * @param id the primary key of the pay fort ref
	 * @return the pay fort ref
	 * @throws NoSuchPayFortRefException if a pay fort ref with the primary key could not be found
	 */
	public static PayFortRef findByPrimaryKey(int id)
		throws com.ejada.atmc.acl.db.exception.NoSuchPayFortRefException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the pay fort ref with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the pay fort ref
	 * @return the pay fort ref, or <code>null</code> if a pay fort ref with the primary key could not be found
	 */
	public static PayFortRef fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the pay fort refs.
	 *
	 * @return the pay fort refs
	 */
	public static List<PayFortRef> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the pay fort refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayFortRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay fort refs
	 * @param end the upper bound of the range of pay fort refs (not inclusive)
	 * @return the range of pay fort refs
	 */
	public static List<PayFortRef> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the pay fort refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayFortRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay fort refs
	 * @param end the upper bound of the range of pay fort refs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pay fort refs
	 */
	public static List<PayFortRef> findAll(
		int start, int end, OrderByComparator<PayFortRef> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pay fort refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayFortRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay fort refs
	 * @param end the upper bound of the range of pay fort refs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pay fort refs
	 */
	public static List<PayFortRef> findAll(
		int start, int end, OrderByComparator<PayFortRef> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the pay fort refs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pay fort refs.
	 *
	 * @return the number of pay fort refs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PayFortRefPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PayFortRefPersistence, PayFortRefPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PayFortRefPersistence.class);

		ServiceTracker<PayFortRefPersistence, PayFortRefPersistence>
			serviceTracker =
				new ServiceTracker
					<PayFortRefPersistence, PayFortRefPersistence>(
						bundle.getBundleContext(), PayFortRefPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}