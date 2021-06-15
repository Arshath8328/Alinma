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

import com.ejada.atmc.acl.db.model.CLMWORKFLOW;

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
 * The persistence utility for the clmworkflow service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.CLMWORKFLOWPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CLMWORKFLOWPersistence
 * @generated
 */
public class CLMWORKFLOWUtil {

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
	public static void clearCache(CLMWORKFLOW clmworkflow) {
		getPersistence().clearCache(clmworkflow);
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
	public static Map<Serializable, CLMWORKFLOW> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CLMWORKFLOW> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CLMWORKFLOW> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CLMWORKFLOW> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CLMWORKFLOW> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CLMWORKFLOW update(CLMWORKFLOW clmworkflow) {
		return getPersistence().update(clmworkflow);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CLMWORKFLOW update(
		CLMWORKFLOW clmworkflow, ServiceContext serviceContext) {

		return getPersistence().update(clmworkflow, serviceContext);
	}

	/**
	 * Returns all the clmworkflows where role = &#63;.
	 *
	 * @param role the role
	 * @return the matching clmworkflows
	 */
	public static List<CLMWORKFLOW> findByrole(String role) {
		return getPersistence().findByrole(role);
	}

	/**
	 * Returns a range of all the clmworkflows where role = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMWORKFLOWModelImpl</code>.
	 * </p>
	 *
	 * @param role the role
	 * @param start the lower bound of the range of clmworkflows
	 * @param end the upper bound of the range of clmworkflows (not inclusive)
	 * @return the range of matching clmworkflows
	 */
	public static List<CLMWORKFLOW> findByrole(
		String role, int start, int end) {

		return getPersistence().findByrole(role, start, end);
	}

	/**
	 * Returns an ordered range of all the clmworkflows where role = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMWORKFLOWModelImpl</code>.
	 * </p>
	 *
	 * @param role the role
	 * @param start the lower bound of the range of clmworkflows
	 * @param end the upper bound of the range of clmworkflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clmworkflows
	 */
	public static List<CLMWORKFLOW> findByrole(
		String role, int start, int end,
		OrderByComparator<CLMWORKFLOW> orderByComparator) {

		return getPersistence().findByrole(role, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the clmworkflows where role = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMWORKFLOWModelImpl</code>.
	 * </p>
	 *
	 * @param role the role
	 * @param start the lower bound of the range of clmworkflows
	 * @param end the upper bound of the range of clmworkflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching clmworkflows
	 */
	public static List<CLMWORKFLOW> findByrole(
		String role, int start, int end,
		OrderByComparator<CLMWORKFLOW> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByrole(
			role, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first clmworkflow in the ordered set where role = &#63;.
	 *
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a matching clmworkflow could not be found
	 */
	public static CLMWORKFLOW findByrole_First(
			String role, OrderByComparator<CLMWORKFLOW> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMWORKFLOWException {

		return getPersistence().findByrole_First(role, orderByComparator);
	}

	/**
	 * Returns the first clmworkflow in the ordered set where role = &#63;.
	 *
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clmworkflow, or <code>null</code> if a matching clmworkflow could not be found
	 */
	public static CLMWORKFLOW fetchByrole_First(
		String role, OrderByComparator<CLMWORKFLOW> orderByComparator) {

		return getPersistence().fetchByrole_First(role, orderByComparator);
	}

	/**
	 * Returns the last clmworkflow in the ordered set where role = &#63;.
	 *
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a matching clmworkflow could not be found
	 */
	public static CLMWORKFLOW findByrole_Last(
			String role, OrderByComparator<CLMWORKFLOW> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMWORKFLOWException {

		return getPersistence().findByrole_Last(role, orderByComparator);
	}

	/**
	 * Returns the last clmworkflow in the ordered set where role = &#63;.
	 *
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clmworkflow, or <code>null</code> if a matching clmworkflow could not be found
	 */
	public static CLMWORKFLOW fetchByrole_Last(
		String role, OrderByComparator<CLMWORKFLOW> orderByComparator) {

		return getPersistence().fetchByrole_Last(role, orderByComparator);
	}

	/**
	 * Returns the clmworkflows before and after the current clmworkflow in the ordered set where role = &#63;.
	 *
	 * @param id the primary key of the current clmworkflow
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a clmworkflow with the primary key could not be found
	 */
	public static CLMWORKFLOW[] findByrole_PrevAndNext(
			int id, String role,
			OrderByComparator<CLMWORKFLOW> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMWORKFLOWException {

		return getPersistence().findByrole_PrevAndNext(
			id, role, orderByComparator);
	}

	/**
	 * Removes all the clmworkflows where role = &#63; from the database.
	 *
	 * @param role the role
	 */
	public static void removeByrole(String role) {
		getPersistence().removeByrole(role);
	}

	/**
	 * Returns the number of clmworkflows where role = &#63;.
	 *
	 * @param role the role
	 * @return the number of matching clmworkflows
	 */
	public static int countByrole(String role) {
		return getPersistence().countByrole(role);
	}

	/**
	 * Returns all the clmworkflows where role = &#63; and initialStatus = &#63;.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @return the matching clmworkflows
	 */
	public static List<CLMWORKFLOW> findByroleStatus(
		String role, String initialStatus) {

		return getPersistence().findByroleStatus(role, initialStatus);
	}

	/**
	 * Returns a range of all the clmworkflows where role = &#63; and initialStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMWORKFLOWModelImpl</code>.
	 * </p>
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param start the lower bound of the range of clmworkflows
	 * @param end the upper bound of the range of clmworkflows (not inclusive)
	 * @return the range of matching clmworkflows
	 */
	public static List<CLMWORKFLOW> findByroleStatus(
		String role, String initialStatus, int start, int end) {

		return getPersistence().findByroleStatus(
			role, initialStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the clmworkflows where role = &#63; and initialStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMWORKFLOWModelImpl</code>.
	 * </p>
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param start the lower bound of the range of clmworkflows
	 * @param end the upper bound of the range of clmworkflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clmworkflows
	 */
	public static List<CLMWORKFLOW> findByroleStatus(
		String role, String initialStatus, int start, int end,
		OrderByComparator<CLMWORKFLOW> orderByComparator) {

		return getPersistence().findByroleStatus(
			role, initialStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the clmworkflows where role = &#63; and initialStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMWORKFLOWModelImpl</code>.
	 * </p>
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param start the lower bound of the range of clmworkflows
	 * @param end the upper bound of the range of clmworkflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching clmworkflows
	 */
	public static List<CLMWORKFLOW> findByroleStatus(
		String role, String initialStatus, int start, int end,
		OrderByComparator<CLMWORKFLOW> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByroleStatus(
			role, initialStatus, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first clmworkflow in the ordered set where role = &#63; and initialStatus = &#63;.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a matching clmworkflow could not be found
	 */
	public static CLMWORKFLOW findByroleStatus_First(
			String role, String initialStatus,
			OrderByComparator<CLMWORKFLOW> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMWORKFLOWException {

		return getPersistence().findByroleStatus_First(
			role, initialStatus, orderByComparator);
	}

	/**
	 * Returns the first clmworkflow in the ordered set where role = &#63; and initialStatus = &#63;.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clmworkflow, or <code>null</code> if a matching clmworkflow could not be found
	 */
	public static CLMWORKFLOW fetchByroleStatus_First(
		String role, String initialStatus,
		OrderByComparator<CLMWORKFLOW> orderByComparator) {

		return getPersistence().fetchByroleStatus_First(
			role, initialStatus, orderByComparator);
	}

	/**
	 * Returns the last clmworkflow in the ordered set where role = &#63; and initialStatus = &#63;.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a matching clmworkflow could not be found
	 */
	public static CLMWORKFLOW findByroleStatus_Last(
			String role, String initialStatus,
			OrderByComparator<CLMWORKFLOW> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMWORKFLOWException {

		return getPersistence().findByroleStatus_Last(
			role, initialStatus, orderByComparator);
	}

	/**
	 * Returns the last clmworkflow in the ordered set where role = &#63; and initialStatus = &#63;.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clmworkflow, or <code>null</code> if a matching clmworkflow could not be found
	 */
	public static CLMWORKFLOW fetchByroleStatus_Last(
		String role, String initialStatus,
		OrderByComparator<CLMWORKFLOW> orderByComparator) {

		return getPersistence().fetchByroleStatus_Last(
			role, initialStatus, orderByComparator);
	}

	/**
	 * Returns the clmworkflows before and after the current clmworkflow in the ordered set where role = &#63; and initialStatus = &#63;.
	 *
	 * @param id the primary key of the current clmworkflow
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a clmworkflow with the primary key could not be found
	 */
	public static CLMWORKFLOW[] findByroleStatus_PrevAndNext(
			int id, String role, String initialStatus,
			OrderByComparator<CLMWORKFLOW> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMWORKFLOWException {

		return getPersistence().findByroleStatus_PrevAndNext(
			id, role, initialStatus, orderByComparator);
	}

	/**
	 * Removes all the clmworkflows where role = &#63; and initialStatus = &#63; from the database.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 */
	public static void removeByroleStatus(String role, String initialStatus) {
		getPersistence().removeByroleStatus(role, initialStatus);
	}

	/**
	 * Returns the number of clmworkflows where role = &#63; and initialStatus = &#63;.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @return the number of matching clmworkflows
	 */
	public static int countByroleStatus(String role, String initialStatus) {
		return getPersistence().countByroleStatus(role, initialStatus);
	}

	/**
	 * Caches the clmworkflow in the entity cache if it is enabled.
	 *
	 * @param clmworkflow the clmworkflow
	 */
	public static void cacheResult(CLMWORKFLOW clmworkflow) {
		getPersistence().cacheResult(clmworkflow);
	}

	/**
	 * Caches the clmworkflows in the entity cache if it is enabled.
	 *
	 * @param clmworkflows the clmworkflows
	 */
	public static void cacheResult(List<CLMWORKFLOW> clmworkflows) {
		getPersistence().cacheResult(clmworkflows);
	}

	/**
	 * Creates a new clmworkflow with the primary key. Does not add the clmworkflow to the database.
	 *
	 * @param id the primary key for the new clmworkflow
	 * @return the new clmworkflow
	 */
	public static CLMWORKFLOW create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the clmworkflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the clmworkflow
	 * @return the clmworkflow that was removed
	 * @throws NoSuchCLMWORKFLOWException if a clmworkflow with the primary key could not be found
	 */
	public static CLMWORKFLOW remove(int id)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMWORKFLOWException {

		return getPersistence().remove(id);
	}

	public static CLMWORKFLOW updateImpl(CLMWORKFLOW clmworkflow) {
		return getPersistence().updateImpl(clmworkflow);
	}

	/**
	 * Returns the clmworkflow with the primary key or throws a <code>NoSuchCLMWORKFLOWException</code> if it could not be found.
	 *
	 * @param id the primary key of the clmworkflow
	 * @return the clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a clmworkflow with the primary key could not be found
	 */
	public static CLMWORKFLOW findByPrimaryKey(int id)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMWORKFLOWException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the clmworkflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the clmworkflow
	 * @return the clmworkflow, or <code>null</code> if a clmworkflow with the primary key could not be found
	 */
	public static CLMWORKFLOW fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the clmworkflows.
	 *
	 * @return the clmworkflows
	 */
	public static List<CLMWORKFLOW> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the clmworkflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMWORKFLOWModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmworkflows
	 * @param end the upper bound of the range of clmworkflows (not inclusive)
	 * @return the range of clmworkflows
	 */
	public static List<CLMWORKFLOW> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the clmworkflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMWORKFLOWModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmworkflows
	 * @param end the upper bound of the range of clmworkflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clmworkflows
	 */
	public static List<CLMWORKFLOW> findAll(
		int start, int end, OrderByComparator<CLMWORKFLOW> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the clmworkflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMWORKFLOWModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmworkflows
	 * @param end the upper bound of the range of clmworkflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of clmworkflows
	 */
	public static List<CLMWORKFLOW> findAll(
		int start, int end, OrderByComparator<CLMWORKFLOW> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the clmworkflows from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of clmworkflows.
	 *
	 * @return the number of clmworkflows
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CLMWORKFLOWPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CLMWORKFLOWPersistence, CLMWORKFLOWPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CLMWORKFLOWPersistence.class);

		ServiceTracker<CLMWORKFLOWPersistence, CLMWORKFLOWPersistence>
			serviceTracker =
				new ServiceTracker
					<CLMWORKFLOWPersistence, CLMWORKFLOWPersistence>(
						bundle.getBundleContext(), CLMWORKFLOWPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}