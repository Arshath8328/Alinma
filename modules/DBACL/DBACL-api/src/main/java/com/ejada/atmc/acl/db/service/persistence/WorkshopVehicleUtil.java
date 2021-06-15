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

import com.ejada.atmc.acl.db.model.WorkshopVehicle;

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
 * The persistence utility for the workshop vehicle service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.WorkshopVehiclePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkshopVehiclePersistence
 * @generated
 */
public class WorkshopVehicleUtil {

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
	public static void clearCache(WorkshopVehicle workshopVehicle) {
		getPersistence().clearCache(workshopVehicle);
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
	public static Map<Serializable, WorkshopVehicle> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WorkshopVehicle> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkshopVehicle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkshopVehicle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorkshopVehicle> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorkshopVehicle update(WorkshopVehicle workshopVehicle) {
		return getPersistence().update(workshopVehicle);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorkshopVehicle update(
		WorkshopVehicle workshopVehicle, ServiceContext serviceContext) {

		return getPersistence().update(workshopVehicle, serviceContext);
	}

	/**
	 * Returns all the workshop vehicles where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching workshop vehicles
	 */
	public static List<WorkshopVehicle> findBystatus(String status) {
		return getPersistence().findBystatus(status);
	}

	/**
	 * Returns a range of all the workshop vehicles where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @return the range of matching workshop vehicles
	 */
	public static List<WorkshopVehicle> findBystatus(
		String status, int start, int end) {

		return getPersistence().findBystatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the workshop vehicles where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching workshop vehicles
	 */
	public static List<WorkshopVehicle> findBystatus(
		String status, int start, int end,
		OrderByComparator<WorkshopVehicle> orderByComparator) {

		return getPersistence().findBystatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the workshop vehicles where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching workshop vehicles
	 */
	public static List<WorkshopVehicle> findBystatus(
		String status, int start, int end,
		OrderByComparator<WorkshopVehicle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBystatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first workshop vehicle in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a matching workshop vehicle could not be found
	 */
	public static WorkshopVehicle findBystatus_First(
			String status, OrderByComparator<WorkshopVehicle> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchWorkshopVehicleException {

		return getPersistence().findBystatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first workshop vehicle in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshop vehicle, or <code>null</code> if a matching workshop vehicle could not be found
	 */
	public static WorkshopVehicle fetchBystatus_First(
		String status, OrderByComparator<WorkshopVehicle> orderByComparator) {

		return getPersistence().fetchBystatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last workshop vehicle in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a matching workshop vehicle could not be found
	 */
	public static WorkshopVehicle findBystatus_Last(
			String status, OrderByComparator<WorkshopVehicle> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchWorkshopVehicleException {

		return getPersistence().findBystatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last workshop vehicle in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshop vehicle, or <code>null</code> if a matching workshop vehicle could not be found
	 */
	public static WorkshopVehicle fetchBystatus_Last(
		String status, OrderByComparator<WorkshopVehicle> orderByComparator) {

		return getPersistence().fetchBystatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the workshop vehicles before and after the current workshop vehicle in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current workshop vehicle
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a workshop vehicle with the primary key could not be found
	 */
	public static WorkshopVehicle[] findBystatus_PrevAndNext(
			int id, String status,
			OrderByComparator<WorkshopVehicle> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchWorkshopVehicleException {

		return getPersistence().findBystatus_PrevAndNext(
			id, status, orderByComparator);
	}

	/**
	 * Removes all the workshop vehicles where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeBystatus(String status) {
		getPersistence().removeBystatus(status);
	}

	/**
	 * Returns the number of workshop vehicles where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching workshop vehicles
	 */
	public static int countBystatus(String status) {
		return getPersistence().countBystatus(status);
	}

	/**
	 * Returns all the workshop vehicles where customerIqamaId = &#63;.
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @return the matching workshop vehicles
	 */
	public static List<WorkshopVehicle> findBycustomerIqamaId(
		String customerIqamaId) {

		return getPersistence().findBycustomerIqamaId(customerIqamaId);
	}

	/**
	 * Returns a range of all the workshop vehicles where customerIqamaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @return the range of matching workshop vehicles
	 */
	public static List<WorkshopVehicle> findBycustomerIqamaId(
		String customerIqamaId, int start, int end) {

		return getPersistence().findBycustomerIqamaId(
			customerIqamaId, start, end);
	}

	/**
	 * Returns an ordered range of all the workshop vehicles where customerIqamaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching workshop vehicles
	 */
	public static List<WorkshopVehicle> findBycustomerIqamaId(
		String customerIqamaId, int start, int end,
		OrderByComparator<WorkshopVehicle> orderByComparator) {

		return getPersistence().findBycustomerIqamaId(
			customerIqamaId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the workshop vehicles where customerIqamaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching workshop vehicles
	 */
	public static List<WorkshopVehicle> findBycustomerIqamaId(
		String customerIqamaId, int start, int end,
		OrderByComparator<WorkshopVehicle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBycustomerIqamaId(
			customerIqamaId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first workshop vehicle in the ordered set where customerIqamaId = &#63;.
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a matching workshop vehicle could not be found
	 */
	public static WorkshopVehicle findBycustomerIqamaId_First(
			String customerIqamaId,
			OrderByComparator<WorkshopVehicle> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchWorkshopVehicleException {

		return getPersistence().findBycustomerIqamaId_First(
			customerIqamaId, orderByComparator);
	}

	/**
	 * Returns the first workshop vehicle in the ordered set where customerIqamaId = &#63;.
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshop vehicle, or <code>null</code> if a matching workshop vehicle could not be found
	 */
	public static WorkshopVehicle fetchBycustomerIqamaId_First(
		String customerIqamaId,
		OrderByComparator<WorkshopVehicle> orderByComparator) {

		return getPersistence().fetchBycustomerIqamaId_First(
			customerIqamaId, orderByComparator);
	}

	/**
	 * Returns the last workshop vehicle in the ordered set where customerIqamaId = &#63;.
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a matching workshop vehicle could not be found
	 */
	public static WorkshopVehicle findBycustomerIqamaId_Last(
			String customerIqamaId,
			OrderByComparator<WorkshopVehicle> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchWorkshopVehicleException {

		return getPersistence().findBycustomerIqamaId_Last(
			customerIqamaId, orderByComparator);
	}

	/**
	 * Returns the last workshop vehicle in the ordered set where customerIqamaId = &#63;.
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshop vehicle, or <code>null</code> if a matching workshop vehicle could not be found
	 */
	public static WorkshopVehicle fetchBycustomerIqamaId_Last(
		String customerIqamaId,
		OrderByComparator<WorkshopVehicle> orderByComparator) {

		return getPersistence().fetchBycustomerIqamaId_Last(
			customerIqamaId, orderByComparator);
	}

	/**
	 * Returns the workshop vehicles before and after the current workshop vehicle in the ordered set where customerIqamaId = &#63;.
	 *
	 * @param id the primary key of the current workshop vehicle
	 * @param customerIqamaId the customer iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a workshop vehicle with the primary key could not be found
	 */
	public static WorkshopVehicle[] findBycustomerIqamaId_PrevAndNext(
			int id, String customerIqamaId,
			OrderByComparator<WorkshopVehicle> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchWorkshopVehicleException {

		return getPersistence().findBycustomerIqamaId_PrevAndNext(
			id, customerIqamaId, orderByComparator);
	}

	/**
	 * Removes all the workshop vehicles where customerIqamaId = &#63; from the database.
	 *
	 * @param customerIqamaId the customer iqama ID
	 */
	public static void removeBycustomerIqamaId(String customerIqamaId) {
		getPersistence().removeBycustomerIqamaId(customerIqamaId);
	}

	/**
	 * Returns the number of workshop vehicles where customerIqamaId = &#63;.
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @return the number of matching workshop vehicles
	 */
	public static int countBycustomerIqamaId(String customerIqamaId) {
		return getPersistence().countBycustomerIqamaId(customerIqamaId);
	}

	/**
	 * Returns all the workshop vehicles where status = &#63; and workshopId = &#63;.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @return the matching workshop vehicles
	 */
	public static List<WorkshopVehicle> findByStatusWorkshopId(
		String status, int workshopId) {

		return getPersistence().findByStatusWorkshopId(status, workshopId);
	}

	/**
	 * Returns a range of all the workshop vehicles where status = &#63; and workshopId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @return the range of matching workshop vehicles
	 */
	public static List<WorkshopVehicle> findByStatusWorkshopId(
		String status, int workshopId, int start, int end) {

		return getPersistence().findByStatusWorkshopId(
			status, workshopId, start, end);
	}

	/**
	 * Returns an ordered range of all the workshop vehicles where status = &#63; and workshopId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching workshop vehicles
	 */
	public static List<WorkshopVehicle> findByStatusWorkshopId(
		String status, int workshopId, int start, int end,
		OrderByComparator<WorkshopVehicle> orderByComparator) {

		return getPersistence().findByStatusWorkshopId(
			status, workshopId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the workshop vehicles where status = &#63; and workshopId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching workshop vehicles
	 */
	public static List<WorkshopVehicle> findByStatusWorkshopId(
		String status, int workshopId, int start, int end,
		OrderByComparator<WorkshopVehicle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatusWorkshopId(
			status, workshopId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first workshop vehicle in the ordered set where status = &#63; and workshopId = &#63;.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a matching workshop vehicle could not be found
	 */
	public static WorkshopVehicle findByStatusWorkshopId_First(
			String status, int workshopId,
			OrderByComparator<WorkshopVehicle> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchWorkshopVehicleException {

		return getPersistence().findByStatusWorkshopId_First(
			status, workshopId, orderByComparator);
	}

	/**
	 * Returns the first workshop vehicle in the ordered set where status = &#63; and workshopId = &#63;.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshop vehicle, or <code>null</code> if a matching workshop vehicle could not be found
	 */
	public static WorkshopVehicle fetchByStatusWorkshopId_First(
		String status, int workshopId,
		OrderByComparator<WorkshopVehicle> orderByComparator) {

		return getPersistence().fetchByStatusWorkshopId_First(
			status, workshopId, orderByComparator);
	}

	/**
	 * Returns the last workshop vehicle in the ordered set where status = &#63; and workshopId = &#63;.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a matching workshop vehicle could not be found
	 */
	public static WorkshopVehicle findByStatusWorkshopId_Last(
			String status, int workshopId,
			OrderByComparator<WorkshopVehicle> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchWorkshopVehicleException {

		return getPersistence().findByStatusWorkshopId_Last(
			status, workshopId, orderByComparator);
	}

	/**
	 * Returns the last workshop vehicle in the ordered set where status = &#63; and workshopId = &#63;.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshop vehicle, or <code>null</code> if a matching workshop vehicle could not be found
	 */
	public static WorkshopVehicle fetchByStatusWorkshopId_Last(
		String status, int workshopId,
		OrderByComparator<WorkshopVehicle> orderByComparator) {

		return getPersistence().fetchByStatusWorkshopId_Last(
			status, workshopId, orderByComparator);
	}

	/**
	 * Returns the workshop vehicles before and after the current workshop vehicle in the ordered set where status = &#63; and workshopId = &#63;.
	 *
	 * @param id the primary key of the current workshop vehicle
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a workshop vehicle with the primary key could not be found
	 */
	public static WorkshopVehicle[] findByStatusWorkshopId_PrevAndNext(
			int id, String status, int workshopId,
			OrderByComparator<WorkshopVehicle> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchWorkshopVehicleException {

		return getPersistence().findByStatusWorkshopId_PrevAndNext(
			id, status, workshopId, orderByComparator);
	}

	/**
	 * Removes all the workshop vehicles where status = &#63; and workshopId = &#63; from the database.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 */
	public static void removeByStatusWorkshopId(String status, int workshopId) {
		getPersistence().removeByStatusWorkshopId(status, workshopId);
	}

	/**
	 * Returns the number of workshop vehicles where status = &#63; and workshopId = &#63;.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @return the number of matching workshop vehicles
	 */
	public static int countByStatusWorkshopId(String status, int workshopId) {
		return getPersistence().countByStatusWorkshopId(status, workshopId);
	}

	/**
	 * Caches the workshop vehicle in the entity cache if it is enabled.
	 *
	 * @param workshopVehicle the workshop vehicle
	 */
	public static void cacheResult(WorkshopVehicle workshopVehicle) {
		getPersistence().cacheResult(workshopVehicle);
	}

	/**
	 * Caches the workshop vehicles in the entity cache if it is enabled.
	 *
	 * @param workshopVehicles the workshop vehicles
	 */
	public static void cacheResult(List<WorkshopVehicle> workshopVehicles) {
		getPersistence().cacheResult(workshopVehicles);
	}

	/**
	 * Creates a new workshop vehicle with the primary key. Does not add the workshop vehicle to the database.
	 *
	 * @param id the primary key for the new workshop vehicle
	 * @return the new workshop vehicle
	 */
	public static WorkshopVehicle create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the workshop vehicle with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the workshop vehicle
	 * @return the workshop vehicle that was removed
	 * @throws NoSuchWorkshopVehicleException if a workshop vehicle with the primary key could not be found
	 */
	public static WorkshopVehicle remove(int id)
		throws com.ejada.atmc.acl.db.exception.NoSuchWorkshopVehicleException {

		return getPersistence().remove(id);
	}

	public static WorkshopVehicle updateImpl(WorkshopVehicle workshopVehicle) {
		return getPersistence().updateImpl(workshopVehicle);
	}

	/**
	 * Returns the workshop vehicle with the primary key or throws a <code>NoSuchWorkshopVehicleException</code> if it could not be found.
	 *
	 * @param id the primary key of the workshop vehicle
	 * @return the workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a workshop vehicle with the primary key could not be found
	 */
	public static WorkshopVehicle findByPrimaryKey(int id)
		throws com.ejada.atmc.acl.db.exception.NoSuchWorkshopVehicleException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the workshop vehicle with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the workshop vehicle
	 * @return the workshop vehicle, or <code>null</code> if a workshop vehicle with the primary key could not be found
	 */
	public static WorkshopVehicle fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the workshop vehicles.
	 *
	 * @return the workshop vehicles
	 */
	public static List<WorkshopVehicle> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the workshop vehicles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @return the range of workshop vehicles
	 */
	public static List<WorkshopVehicle> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the workshop vehicles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of workshop vehicles
	 */
	public static List<WorkshopVehicle> findAll(
		int start, int end,
		OrderByComparator<WorkshopVehicle> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the workshop vehicles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of workshop vehicles
	 */
	public static List<WorkshopVehicle> findAll(
		int start, int end,
		OrderByComparator<WorkshopVehicle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the workshop vehicles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of workshop vehicles.
	 *
	 * @return the number of workshop vehicles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WorkshopVehiclePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<WorkshopVehiclePersistence, WorkshopVehiclePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			WorkshopVehiclePersistence.class);

		ServiceTracker<WorkshopVehiclePersistence, WorkshopVehiclePersistence>
			serviceTracker =
				new ServiceTracker
					<WorkshopVehiclePersistence, WorkshopVehiclePersistence>(
						bundle.getBundleContext(),
						WorkshopVehiclePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}