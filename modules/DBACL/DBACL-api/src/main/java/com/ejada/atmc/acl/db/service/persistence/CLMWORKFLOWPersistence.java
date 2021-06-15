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

import com.ejada.atmc.acl.db.exception.NoSuchCLMWORKFLOWException;
import com.ejada.atmc.acl.db.model.CLMWORKFLOW;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the clmworkflow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CLMWORKFLOWUtil
 * @generated
 */
@ProviderType
public interface CLMWORKFLOWPersistence extends BasePersistence<CLMWORKFLOW> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CLMWORKFLOWUtil} to access the clmworkflow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the clmworkflows where role = &#63;.
	 *
	 * @param role the role
	 * @return the matching clmworkflows
	 */
	public java.util.List<CLMWORKFLOW> findByrole(String role);

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
	public java.util.List<CLMWORKFLOW> findByrole(
		String role, int start, int end);

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
	public java.util.List<CLMWORKFLOW> findByrole(
		String role, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMWORKFLOW>
			orderByComparator);

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
	public java.util.List<CLMWORKFLOW> findByrole(
		String role, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMWORKFLOW>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first clmworkflow in the ordered set where role = &#63;.
	 *
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a matching clmworkflow could not be found
	 */
	public CLMWORKFLOW findByrole_First(
			String role,
			com.liferay.portal.kernel.util.OrderByComparator<CLMWORKFLOW>
				orderByComparator)
		throws NoSuchCLMWORKFLOWException;

	/**
	 * Returns the first clmworkflow in the ordered set where role = &#63;.
	 *
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clmworkflow, or <code>null</code> if a matching clmworkflow could not be found
	 */
	public CLMWORKFLOW fetchByrole_First(
		String role,
		com.liferay.portal.kernel.util.OrderByComparator<CLMWORKFLOW>
			orderByComparator);

	/**
	 * Returns the last clmworkflow in the ordered set where role = &#63;.
	 *
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a matching clmworkflow could not be found
	 */
	public CLMWORKFLOW findByrole_Last(
			String role,
			com.liferay.portal.kernel.util.OrderByComparator<CLMWORKFLOW>
				orderByComparator)
		throws NoSuchCLMWORKFLOWException;

	/**
	 * Returns the last clmworkflow in the ordered set where role = &#63;.
	 *
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clmworkflow, or <code>null</code> if a matching clmworkflow could not be found
	 */
	public CLMWORKFLOW fetchByrole_Last(
		String role,
		com.liferay.portal.kernel.util.OrderByComparator<CLMWORKFLOW>
			orderByComparator);

	/**
	 * Returns the clmworkflows before and after the current clmworkflow in the ordered set where role = &#63;.
	 *
	 * @param id the primary key of the current clmworkflow
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a clmworkflow with the primary key could not be found
	 */
	public CLMWORKFLOW[] findByrole_PrevAndNext(
			int id, String role,
			com.liferay.portal.kernel.util.OrderByComparator<CLMWORKFLOW>
				orderByComparator)
		throws NoSuchCLMWORKFLOWException;

	/**
	 * Removes all the clmworkflows where role = &#63; from the database.
	 *
	 * @param role the role
	 */
	public void removeByrole(String role);

	/**
	 * Returns the number of clmworkflows where role = &#63;.
	 *
	 * @param role the role
	 * @return the number of matching clmworkflows
	 */
	public int countByrole(String role);

	/**
	 * Returns all the clmworkflows where role = &#63; and initialStatus = &#63;.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @return the matching clmworkflows
	 */
	public java.util.List<CLMWORKFLOW> findByroleStatus(
		String role, String initialStatus);

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
	public java.util.List<CLMWORKFLOW> findByroleStatus(
		String role, String initialStatus, int start, int end);

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
	public java.util.List<CLMWORKFLOW> findByroleStatus(
		String role, String initialStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMWORKFLOW>
			orderByComparator);

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
	public java.util.List<CLMWORKFLOW> findByroleStatus(
		String role, String initialStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMWORKFLOW>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first clmworkflow in the ordered set where role = &#63; and initialStatus = &#63;.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a matching clmworkflow could not be found
	 */
	public CLMWORKFLOW findByroleStatus_First(
			String role, String initialStatus,
			com.liferay.portal.kernel.util.OrderByComparator<CLMWORKFLOW>
				orderByComparator)
		throws NoSuchCLMWORKFLOWException;

	/**
	 * Returns the first clmworkflow in the ordered set where role = &#63; and initialStatus = &#63;.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clmworkflow, or <code>null</code> if a matching clmworkflow could not be found
	 */
	public CLMWORKFLOW fetchByroleStatus_First(
		String role, String initialStatus,
		com.liferay.portal.kernel.util.OrderByComparator<CLMWORKFLOW>
			orderByComparator);

	/**
	 * Returns the last clmworkflow in the ordered set where role = &#63; and initialStatus = &#63;.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a matching clmworkflow could not be found
	 */
	public CLMWORKFLOW findByroleStatus_Last(
			String role, String initialStatus,
			com.liferay.portal.kernel.util.OrderByComparator<CLMWORKFLOW>
				orderByComparator)
		throws NoSuchCLMWORKFLOWException;

	/**
	 * Returns the last clmworkflow in the ordered set where role = &#63; and initialStatus = &#63;.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clmworkflow, or <code>null</code> if a matching clmworkflow could not be found
	 */
	public CLMWORKFLOW fetchByroleStatus_Last(
		String role, String initialStatus,
		com.liferay.portal.kernel.util.OrderByComparator<CLMWORKFLOW>
			orderByComparator);

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
	public CLMWORKFLOW[] findByroleStatus_PrevAndNext(
			int id, String role, String initialStatus,
			com.liferay.portal.kernel.util.OrderByComparator<CLMWORKFLOW>
				orderByComparator)
		throws NoSuchCLMWORKFLOWException;

	/**
	 * Removes all the clmworkflows where role = &#63; and initialStatus = &#63; from the database.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 */
	public void removeByroleStatus(String role, String initialStatus);

	/**
	 * Returns the number of clmworkflows where role = &#63; and initialStatus = &#63;.
	 *
	 * @param role the role
	 * @param initialStatus the initial status
	 * @return the number of matching clmworkflows
	 */
	public int countByroleStatus(String role, String initialStatus);

	/**
	 * Caches the clmworkflow in the entity cache if it is enabled.
	 *
	 * @param clmworkflow the clmworkflow
	 */
	public void cacheResult(CLMWORKFLOW clmworkflow);

	/**
	 * Caches the clmworkflows in the entity cache if it is enabled.
	 *
	 * @param clmworkflows the clmworkflows
	 */
	public void cacheResult(java.util.List<CLMWORKFLOW> clmworkflows);

	/**
	 * Creates a new clmworkflow with the primary key. Does not add the clmworkflow to the database.
	 *
	 * @param id the primary key for the new clmworkflow
	 * @return the new clmworkflow
	 */
	public CLMWORKFLOW create(int id);

	/**
	 * Removes the clmworkflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the clmworkflow
	 * @return the clmworkflow that was removed
	 * @throws NoSuchCLMWORKFLOWException if a clmworkflow with the primary key could not be found
	 */
	public CLMWORKFLOW remove(int id) throws NoSuchCLMWORKFLOWException;

	public CLMWORKFLOW updateImpl(CLMWORKFLOW clmworkflow);

	/**
	 * Returns the clmworkflow with the primary key or throws a <code>NoSuchCLMWORKFLOWException</code> if it could not be found.
	 *
	 * @param id the primary key of the clmworkflow
	 * @return the clmworkflow
	 * @throws NoSuchCLMWORKFLOWException if a clmworkflow with the primary key could not be found
	 */
	public CLMWORKFLOW findByPrimaryKey(int id)
		throws NoSuchCLMWORKFLOWException;

	/**
	 * Returns the clmworkflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the clmworkflow
	 * @return the clmworkflow, or <code>null</code> if a clmworkflow with the primary key could not be found
	 */
	public CLMWORKFLOW fetchByPrimaryKey(int id);

	/**
	 * Returns all the clmworkflows.
	 *
	 * @return the clmworkflows
	 */
	public java.util.List<CLMWORKFLOW> findAll();

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
	public java.util.List<CLMWORKFLOW> findAll(int start, int end);

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
	public java.util.List<CLMWORKFLOW> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMWORKFLOW>
			orderByComparator);

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
	public java.util.List<CLMWORKFLOW> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMWORKFLOW>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the clmworkflows from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of clmworkflows.
	 *
	 * @return the number of clmworkflows
	 */
	public int countAll();

}