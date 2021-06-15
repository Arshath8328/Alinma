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

import com.ejada.atmc.acl.db.exception.NoSuchServiceRequestHistoryException;
import com.ejada.atmc.acl.db.model.ServiceRequestHistory;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the service request history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestHistoryUtil
 * @generated
 */
@ProviderType
public interface ServiceRequestHistoryPersistence
	extends BasePersistence<ServiceRequestHistory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServiceRequestHistoryUtil} to access the service request history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the service request histories where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @return the matching service request histories
	 */
	public java.util.List<ServiceRequestHistory> findByrefNo(
		String REFERENCE_NO);

	/**
	 * Returns a range of all the service request histories where REFERENCE_NO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param start the lower bound of the range of service request histories
	 * @param end the upper bound of the range of service request histories (not inclusive)
	 * @return the range of matching service request histories
	 */
	public java.util.List<ServiceRequestHistory> findByrefNo(
		String REFERENCE_NO, int start, int end);

	/**
	 * Returns an ordered range of all the service request histories where REFERENCE_NO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param start the lower bound of the range of service request histories
	 * @param end the upper bound of the range of service request histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service request histories
	 */
	public java.util.List<ServiceRequestHistory> findByrefNo(
		String REFERENCE_NO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the service request histories where REFERENCE_NO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param start the lower bound of the range of service request histories
	 * @param end the upper bound of the range of service request histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service request histories
	 */
	public java.util.List<ServiceRequestHistory> findByrefNo(
		String REFERENCE_NO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first service request history in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request history
	 * @throws NoSuchServiceRequestHistoryException if a matching service request history could not be found
	 */
	public ServiceRequestHistory findByrefNo_First(
			String REFERENCE_NO,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestHistory> orderByComparator)
		throws NoSuchServiceRequestHistoryException;

	/**
	 * Returns the first service request history in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request history, or <code>null</code> if a matching service request history could not be found
	 */
	public ServiceRequestHistory fetchByrefNo_First(
		String REFERENCE_NO,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestHistory>
			orderByComparator);

	/**
	 * Returns the last service request history in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request history
	 * @throws NoSuchServiceRequestHistoryException if a matching service request history could not be found
	 */
	public ServiceRequestHistory findByrefNo_Last(
			String REFERENCE_NO,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestHistory> orderByComparator)
		throws NoSuchServiceRequestHistoryException;

	/**
	 * Returns the last service request history in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request history, or <code>null</code> if a matching service request history could not be found
	 */
	public ServiceRequestHistory fetchByrefNo_Last(
		String REFERENCE_NO,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestHistory>
			orderByComparator);

	/**
	 * Returns the service request histories before and after the current service request history in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param ACTION_ID the primary key of the current service request history
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request history
	 * @throws NoSuchServiceRequestHistoryException if a service request history with the primary key could not be found
	 */
	public ServiceRequestHistory[] findByrefNo_PrevAndNext(
			long ACTION_ID, String REFERENCE_NO,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestHistory> orderByComparator)
		throws NoSuchServiceRequestHistoryException;

	/**
	 * Removes all the service request histories where REFERENCE_NO = &#63; from the database.
	 *
	 * @param REFERENCE_NO the reference_no
	 */
	public void removeByrefNo(String REFERENCE_NO);

	/**
	 * Returns the number of service request histories where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @return the number of matching service request histories
	 */
	public int countByrefNo(String REFERENCE_NO);

	/**
	 * Caches the service request history in the entity cache if it is enabled.
	 *
	 * @param serviceRequestHistory the service request history
	 */
	public void cacheResult(ServiceRequestHistory serviceRequestHistory);

	/**
	 * Caches the service request histories in the entity cache if it is enabled.
	 *
	 * @param serviceRequestHistories the service request histories
	 */
	public void cacheResult(
		java.util.List<ServiceRequestHistory> serviceRequestHistories);

	/**
	 * Creates a new service request history with the primary key. Does not add the service request history to the database.
	 *
	 * @param ACTION_ID the primary key for the new service request history
	 * @return the new service request history
	 */
	public ServiceRequestHistory create(long ACTION_ID);

	/**
	 * Removes the service request history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ACTION_ID the primary key of the service request history
	 * @return the service request history that was removed
	 * @throws NoSuchServiceRequestHistoryException if a service request history with the primary key could not be found
	 */
	public ServiceRequestHistory remove(long ACTION_ID)
		throws NoSuchServiceRequestHistoryException;

	public ServiceRequestHistory updateImpl(
		ServiceRequestHistory serviceRequestHistory);

	/**
	 * Returns the service request history with the primary key or throws a <code>NoSuchServiceRequestHistoryException</code> if it could not be found.
	 *
	 * @param ACTION_ID the primary key of the service request history
	 * @return the service request history
	 * @throws NoSuchServiceRequestHistoryException if a service request history with the primary key could not be found
	 */
	public ServiceRequestHistory findByPrimaryKey(long ACTION_ID)
		throws NoSuchServiceRequestHistoryException;

	/**
	 * Returns the service request history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ACTION_ID the primary key of the service request history
	 * @return the service request history, or <code>null</code> if a service request history with the primary key could not be found
	 */
	public ServiceRequestHistory fetchByPrimaryKey(long ACTION_ID);

	/**
	 * Returns all the service request histories.
	 *
	 * @return the service request histories
	 */
	public java.util.List<ServiceRequestHistory> findAll();

	/**
	 * Returns a range of all the service request histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request histories
	 * @param end the upper bound of the range of service request histories (not inclusive)
	 * @return the range of service request histories
	 */
	public java.util.List<ServiceRequestHistory> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the service request histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request histories
	 * @param end the upper bound of the range of service request histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service request histories
	 */
	public java.util.List<ServiceRequestHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the service request histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request histories
	 * @param end the upper bound of the range of service request histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of service request histories
	 */
	public java.util.List<ServiceRequestHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the service request histories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of service request histories.
	 *
	 * @return the number of service request histories
	 */
	public int countAll();

}