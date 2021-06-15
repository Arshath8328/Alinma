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

import com.ejada.atmc.acl.db.exception.NoSuchWorkshopVehicleException;
import com.ejada.atmc.acl.db.model.WorkshopVehicle;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the workshop vehicle service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkshopVehicleUtil
 * @generated
 */
@ProviderType
public interface WorkshopVehiclePersistence
	extends BasePersistence<WorkshopVehicle> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkshopVehicleUtil} to access the workshop vehicle persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the workshop vehicles where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching workshop vehicles
	 */
	public java.util.List<WorkshopVehicle> findBystatus(String status);

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
	public java.util.List<WorkshopVehicle> findBystatus(
		String status, int start, int end);

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
	public java.util.List<WorkshopVehicle> findBystatus(
		String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
			orderByComparator);

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
	public java.util.List<WorkshopVehicle> findBystatus(
		String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first workshop vehicle in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a matching workshop vehicle could not be found
	 */
	public WorkshopVehicle findBystatus_First(
			String status,
			com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
				orderByComparator)
		throws NoSuchWorkshopVehicleException;

	/**
	 * Returns the first workshop vehicle in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshop vehicle, or <code>null</code> if a matching workshop vehicle could not be found
	 */
	public WorkshopVehicle fetchBystatus_First(
		String status,
		com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
			orderByComparator);

	/**
	 * Returns the last workshop vehicle in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a matching workshop vehicle could not be found
	 */
	public WorkshopVehicle findBystatus_Last(
			String status,
			com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
				orderByComparator)
		throws NoSuchWorkshopVehicleException;

	/**
	 * Returns the last workshop vehicle in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshop vehicle, or <code>null</code> if a matching workshop vehicle could not be found
	 */
	public WorkshopVehicle fetchBystatus_Last(
		String status,
		com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
			orderByComparator);

	/**
	 * Returns the workshop vehicles before and after the current workshop vehicle in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current workshop vehicle
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a workshop vehicle with the primary key could not be found
	 */
	public WorkshopVehicle[] findBystatus_PrevAndNext(
			int id, String status,
			com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
				orderByComparator)
		throws NoSuchWorkshopVehicleException;

	/**
	 * Removes all the workshop vehicles where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeBystatus(String status);

	/**
	 * Returns the number of workshop vehicles where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching workshop vehicles
	 */
	public int countBystatus(String status);

	/**
	 * Returns all the workshop vehicles where customerIqamaId = &#63;.
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @return the matching workshop vehicles
	 */
	public java.util.List<WorkshopVehicle> findBycustomerIqamaId(
		String customerIqamaId);

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
	public java.util.List<WorkshopVehicle> findBycustomerIqamaId(
		String customerIqamaId, int start, int end);

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
	public java.util.List<WorkshopVehicle> findBycustomerIqamaId(
		String customerIqamaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
			orderByComparator);

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
	public java.util.List<WorkshopVehicle> findBycustomerIqamaId(
		String customerIqamaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first workshop vehicle in the ordered set where customerIqamaId = &#63;.
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a matching workshop vehicle could not be found
	 */
	public WorkshopVehicle findBycustomerIqamaId_First(
			String customerIqamaId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
				orderByComparator)
		throws NoSuchWorkshopVehicleException;

	/**
	 * Returns the first workshop vehicle in the ordered set where customerIqamaId = &#63;.
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshop vehicle, or <code>null</code> if a matching workshop vehicle could not be found
	 */
	public WorkshopVehicle fetchBycustomerIqamaId_First(
		String customerIqamaId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
			orderByComparator);

	/**
	 * Returns the last workshop vehicle in the ordered set where customerIqamaId = &#63;.
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a matching workshop vehicle could not be found
	 */
	public WorkshopVehicle findBycustomerIqamaId_Last(
			String customerIqamaId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
				orderByComparator)
		throws NoSuchWorkshopVehicleException;

	/**
	 * Returns the last workshop vehicle in the ordered set where customerIqamaId = &#63;.
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshop vehicle, or <code>null</code> if a matching workshop vehicle could not be found
	 */
	public WorkshopVehicle fetchBycustomerIqamaId_Last(
		String customerIqamaId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
			orderByComparator);

	/**
	 * Returns the workshop vehicles before and after the current workshop vehicle in the ordered set where customerIqamaId = &#63;.
	 *
	 * @param id the primary key of the current workshop vehicle
	 * @param customerIqamaId the customer iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a workshop vehicle with the primary key could not be found
	 */
	public WorkshopVehicle[] findBycustomerIqamaId_PrevAndNext(
			int id, String customerIqamaId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
				orderByComparator)
		throws NoSuchWorkshopVehicleException;

	/**
	 * Removes all the workshop vehicles where customerIqamaId = &#63; from the database.
	 *
	 * @param customerIqamaId the customer iqama ID
	 */
	public void removeBycustomerIqamaId(String customerIqamaId);

	/**
	 * Returns the number of workshop vehicles where customerIqamaId = &#63;.
	 *
	 * @param customerIqamaId the customer iqama ID
	 * @return the number of matching workshop vehicles
	 */
	public int countBycustomerIqamaId(String customerIqamaId);

	/**
	 * Returns all the workshop vehicles where status = &#63; and workshopId = &#63;.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @return the matching workshop vehicles
	 */
	public java.util.List<WorkshopVehicle> findByStatusWorkshopId(
		String status, int workshopId);

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
	public java.util.List<WorkshopVehicle> findByStatusWorkshopId(
		String status, int workshopId, int start, int end);

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
	public java.util.List<WorkshopVehicle> findByStatusWorkshopId(
		String status, int workshopId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
			orderByComparator);

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
	public java.util.List<WorkshopVehicle> findByStatusWorkshopId(
		String status, int workshopId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first workshop vehicle in the ordered set where status = &#63; and workshopId = &#63;.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a matching workshop vehicle could not be found
	 */
	public WorkshopVehicle findByStatusWorkshopId_First(
			String status, int workshopId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
				orderByComparator)
		throws NoSuchWorkshopVehicleException;

	/**
	 * Returns the first workshop vehicle in the ordered set where status = &#63; and workshopId = &#63;.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workshop vehicle, or <code>null</code> if a matching workshop vehicle could not be found
	 */
	public WorkshopVehicle fetchByStatusWorkshopId_First(
		String status, int workshopId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
			orderByComparator);

	/**
	 * Returns the last workshop vehicle in the ordered set where status = &#63; and workshopId = &#63;.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a matching workshop vehicle could not be found
	 */
	public WorkshopVehicle findByStatusWorkshopId_Last(
			String status, int workshopId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
				orderByComparator)
		throws NoSuchWorkshopVehicleException;

	/**
	 * Returns the last workshop vehicle in the ordered set where status = &#63; and workshopId = &#63;.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workshop vehicle, or <code>null</code> if a matching workshop vehicle could not be found
	 */
	public WorkshopVehicle fetchByStatusWorkshopId_Last(
		String status, int workshopId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
			orderByComparator);

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
	public WorkshopVehicle[] findByStatusWorkshopId_PrevAndNext(
			int id, String status, int workshopId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
				orderByComparator)
		throws NoSuchWorkshopVehicleException;

	/**
	 * Removes all the workshop vehicles where status = &#63; and workshopId = &#63; from the database.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 */
	public void removeByStatusWorkshopId(String status, int workshopId);

	/**
	 * Returns the number of workshop vehicles where status = &#63; and workshopId = &#63;.
	 *
	 * @param status the status
	 * @param workshopId the workshop ID
	 * @return the number of matching workshop vehicles
	 */
	public int countByStatusWorkshopId(String status, int workshopId);

	/**
	 * Caches the workshop vehicle in the entity cache if it is enabled.
	 *
	 * @param workshopVehicle the workshop vehicle
	 */
	public void cacheResult(WorkshopVehicle workshopVehicle);

	/**
	 * Caches the workshop vehicles in the entity cache if it is enabled.
	 *
	 * @param workshopVehicles the workshop vehicles
	 */
	public void cacheResult(java.util.List<WorkshopVehicle> workshopVehicles);

	/**
	 * Creates a new workshop vehicle with the primary key. Does not add the workshop vehicle to the database.
	 *
	 * @param id the primary key for the new workshop vehicle
	 * @return the new workshop vehicle
	 */
	public WorkshopVehicle create(int id);

	/**
	 * Removes the workshop vehicle with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the workshop vehicle
	 * @return the workshop vehicle that was removed
	 * @throws NoSuchWorkshopVehicleException if a workshop vehicle with the primary key could not be found
	 */
	public WorkshopVehicle remove(int id) throws NoSuchWorkshopVehicleException;

	public WorkshopVehicle updateImpl(WorkshopVehicle workshopVehicle);

	/**
	 * Returns the workshop vehicle with the primary key or throws a <code>NoSuchWorkshopVehicleException</code> if it could not be found.
	 *
	 * @param id the primary key of the workshop vehicle
	 * @return the workshop vehicle
	 * @throws NoSuchWorkshopVehicleException if a workshop vehicle with the primary key could not be found
	 */
	public WorkshopVehicle findByPrimaryKey(int id)
		throws NoSuchWorkshopVehicleException;

	/**
	 * Returns the workshop vehicle with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the workshop vehicle
	 * @return the workshop vehicle, or <code>null</code> if a workshop vehicle with the primary key could not be found
	 */
	public WorkshopVehicle fetchByPrimaryKey(int id);

	/**
	 * Returns all the workshop vehicles.
	 *
	 * @return the workshop vehicles
	 */
	public java.util.List<WorkshopVehicle> findAll();

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
	public java.util.List<WorkshopVehicle> findAll(int start, int end);

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
	public java.util.List<WorkshopVehicle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
			orderByComparator);

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
	public java.util.List<WorkshopVehicle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkshopVehicle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the workshop vehicles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of workshop vehicles.
	 *
	 * @return the number of workshop vehicles
	 */
	public int countAll();

}