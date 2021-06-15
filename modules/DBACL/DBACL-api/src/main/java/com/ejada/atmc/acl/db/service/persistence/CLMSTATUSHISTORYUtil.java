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

import com.ejada.atmc.acl.db.model.CLMSTATUSHISTORY;

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
 * The persistence utility for the clmstatushistory service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.CLMSTATUSHISTORYPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CLMSTATUSHISTORYPersistence
 * @generated
 */
public class CLMSTATUSHISTORYUtil {

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
	public static void clearCache(CLMSTATUSHISTORY clmstatushistory) {
		getPersistence().clearCache(clmstatushistory);
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
	public static Map<Serializable, CLMSTATUSHISTORY> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CLMSTATUSHISTORY> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CLMSTATUSHISTORY> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CLMSTATUSHISTORY> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CLMSTATUSHISTORY> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CLMSTATUSHISTORY update(CLMSTATUSHISTORY clmstatushistory) {
		return getPersistence().update(clmstatushistory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CLMSTATUSHISTORY update(
		CLMSTATUSHISTORY clmstatushistory, ServiceContext serviceContext) {

		return getPersistence().update(clmstatushistory, serviceContext);
	}

	/**
	 * Returns all the clmstatushistories where RefNo = &#63;.
	 *
	 * @param RefNo the ref no
	 * @return the matching clmstatushistories
	 */
	public static List<CLMSTATUSHISTORY> findByRefNo(String RefNo) {
		return getPersistence().findByRefNo(RefNo);
	}

	/**
	 * Returns a range of all the clmstatushistories where RefNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSHISTORYModelImpl</code>.
	 * </p>
	 *
	 * @param RefNo the ref no
	 * @param start the lower bound of the range of clmstatushistories
	 * @param end the upper bound of the range of clmstatushistories (not inclusive)
	 * @return the range of matching clmstatushistories
	 */
	public static List<CLMSTATUSHISTORY> findByRefNo(
		String RefNo, int start, int end) {

		return getPersistence().findByRefNo(RefNo, start, end);
	}

	/**
	 * Returns an ordered range of all the clmstatushistories where RefNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSHISTORYModelImpl</code>.
	 * </p>
	 *
	 * @param RefNo the ref no
	 * @param start the lower bound of the range of clmstatushistories
	 * @param end the upper bound of the range of clmstatushistories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clmstatushistories
	 */
	public static List<CLMSTATUSHISTORY> findByRefNo(
		String RefNo, int start, int end,
		OrderByComparator<CLMSTATUSHISTORY> orderByComparator) {

		return getPersistence().findByRefNo(
			RefNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the clmstatushistories where RefNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSHISTORYModelImpl</code>.
	 * </p>
	 *
	 * @param RefNo the ref no
	 * @param start the lower bound of the range of clmstatushistories
	 * @param end the upper bound of the range of clmstatushistories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching clmstatushistories
	 */
	public static List<CLMSTATUSHISTORY> findByRefNo(
		String RefNo, int start, int end,
		OrderByComparator<CLMSTATUSHISTORY> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRefNo(
			RefNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first clmstatushistory in the ordered set where RefNo = &#63;.
	 *
	 * @param RefNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clmstatushistory
	 * @throws NoSuchCLMSTATUSHISTORYException if a matching clmstatushistory could not be found
	 */
	public static CLMSTATUSHISTORY findByRefNo_First(
			String RefNo, OrderByComparator<CLMSTATUSHISTORY> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMSTATUSHISTORYException {

		return getPersistence().findByRefNo_First(RefNo, orderByComparator);
	}

	/**
	 * Returns the first clmstatushistory in the ordered set where RefNo = &#63;.
	 *
	 * @param RefNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clmstatushistory, or <code>null</code> if a matching clmstatushistory could not be found
	 */
	public static CLMSTATUSHISTORY fetchByRefNo_First(
		String RefNo, OrderByComparator<CLMSTATUSHISTORY> orderByComparator) {

		return getPersistence().fetchByRefNo_First(RefNo, orderByComparator);
	}

	/**
	 * Returns the last clmstatushistory in the ordered set where RefNo = &#63;.
	 *
	 * @param RefNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clmstatushistory
	 * @throws NoSuchCLMSTATUSHISTORYException if a matching clmstatushistory could not be found
	 */
	public static CLMSTATUSHISTORY findByRefNo_Last(
			String RefNo, OrderByComparator<CLMSTATUSHISTORY> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMSTATUSHISTORYException {

		return getPersistence().findByRefNo_Last(RefNo, orderByComparator);
	}

	/**
	 * Returns the last clmstatushistory in the ordered set where RefNo = &#63;.
	 *
	 * @param RefNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clmstatushistory, or <code>null</code> if a matching clmstatushistory could not be found
	 */
	public static CLMSTATUSHISTORY fetchByRefNo_Last(
		String RefNo, OrderByComparator<CLMSTATUSHISTORY> orderByComparator) {

		return getPersistence().fetchByRefNo_Last(RefNo, orderByComparator);
	}

	/**
	 * Returns the clmstatushistories before and after the current clmstatushistory in the ordered set where RefNo = &#63;.
	 *
	 * @param id the primary key of the current clmstatushistory
	 * @param RefNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clmstatushistory
	 * @throws NoSuchCLMSTATUSHISTORYException if a clmstatushistory with the primary key could not be found
	 */
	public static CLMSTATUSHISTORY[] findByRefNo_PrevAndNext(
			int id, String RefNo,
			OrderByComparator<CLMSTATUSHISTORY> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMSTATUSHISTORYException {

		return getPersistence().findByRefNo_PrevAndNext(
			id, RefNo, orderByComparator);
	}

	/**
	 * Removes all the clmstatushistories where RefNo = &#63; from the database.
	 *
	 * @param RefNo the ref no
	 */
	public static void removeByRefNo(String RefNo) {
		getPersistence().removeByRefNo(RefNo);
	}

	/**
	 * Returns the number of clmstatushistories where RefNo = &#63;.
	 *
	 * @param RefNo the ref no
	 * @return the number of matching clmstatushistories
	 */
	public static int countByRefNo(String RefNo) {
		return getPersistence().countByRefNo(RefNo);
	}

	/**
	 * Caches the clmstatushistory in the entity cache if it is enabled.
	 *
	 * @param clmstatushistory the clmstatushistory
	 */
	public static void cacheResult(CLMSTATUSHISTORY clmstatushistory) {
		getPersistence().cacheResult(clmstatushistory);
	}

	/**
	 * Caches the clmstatushistories in the entity cache if it is enabled.
	 *
	 * @param clmstatushistories the clmstatushistories
	 */
	public static void cacheResult(List<CLMSTATUSHISTORY> clmstatushistories) {
		getPersistence().cacheResult(clmstatushistories);
	}

	/**
	 * Creates a new clmstatushistory with the primary key. Does not add the clmstatushistory to the database.
	 *
	 * @param id the primary key for the new clmstatushistory
	 * @return the new clmstatushistory
	 */
	public static CLMSTATUSHISTORY create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the clmstatushistory with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the clmstatushistory
	 * @return the clmstatushistory that was removed
	 * @throws NoSuchCLMSTATUSHISTORYException if a clmstatushistory with the primary key could not be found
	 */
	public static CLMSTATUSHISTORY remove(int id)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMSTATUSHISTORYException {

		return getPersistence().remove(id);
	}

	public static CLMSTATUSHISTORY updateImpl(
		CLMSTATUSHISTORY clmstatushistory) {

		return getPersistence().updateImpl(clmstatushistory);
	}

	/**
	 * Returns the clmstatushistory with the primary key or throws a <code>NoSuchCLMSTATUSHISTORYException</code> if it could not be found.
	 *
	 * @param id the primary key of the clmstatushistory
	 * @return the clmstatushistory
	 * @throws NoSuchCLMSTATUSHISTORYException if a clmstatushistory with the primary key could not be found
	 */
	public static CLMSTATUSHISTORY findByPrimaryKey(int id)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMSTATUSHISTORYException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the clmstatushistory with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the clmstatushistory
	 * @return the clmstatushistory, or <code>null</code> if a clmstatushistory with the primary key could not be found
	 */
	public static CLMSTATUSHISTORY fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the clmstatushistories.
	 *
	 * @return the clmstatushistories
	 */
	public static List<CLMSTATUSHISTORY> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the clmstatushistories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSHISTORYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatushistories
	 * @param end the upper bound of the range of clmstatushistories (not inclusive)
	 * @return the range of clmstatushistories
	 */
	public static List<CLMSTATUSHISTORY> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the clmstatushistories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSHISTORYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatushistories
	 * @param end the upper bound of the range of clmstatushistories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clmstatushistories
	 */
	public static List<CLMSTATUSHISTORY> findAll(
		int start, int end,
		OrderByComparator<CLMSTATUSHISTORY> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the clmstatushistories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSHISTORYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatushistories
	 * @param end the upper bound of the range of clmstatushistories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of clmstatushistories
	 */
	public static List<CLMSTATUSHISTORY> findAll(
		int start, int end,
		OrderByComparator<CLMSTATUSHISTORY> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the clmstatushistories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of clmstatushistories.
	 *
	 * @return the number of clmstatushistories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CLMSTATUSHISTORYPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CLMSTATUSHISTORYPersistence, CLMSTATUSHISTORYPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CLMSTATUSHISTORYPersistence.class);

		ServiceTracker<CLMSTATUSHISTORYPersistence, CLMSTATUSHISTORYPersistence>
			serviceTracker =
				new ServiceTracker
					<CLMSTATUSHISTORYPersistence, CLMSTATUSHISTORYPersistence>(
						bundle.getBundleContext(),
						CLMSTATUSHISTORYPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}