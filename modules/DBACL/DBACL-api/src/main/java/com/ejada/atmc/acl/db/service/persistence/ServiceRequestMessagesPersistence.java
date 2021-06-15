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

import com.ejada.atmc.acl.db.exception.NoSuchServiceRequestMessagesException;
import com.ejada.atmc.acl.db.model.ServiceRequestMessages;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the service request messages service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestMessagesUtil
 * @generated
 */
@ProviderType
public interface ServiceRequestMessagesPersistence
	extends BasePersistence<ServiceRequestMessages> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServiceRequestMessagesUtil} to access the service request messages persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the service request messageses where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @return the matching service request messageses
	 */
	public java.util.List<ServiceRequestMessages> findByrefNo(
		String REFERENCE_NO);

	/**
	 * Returns a range of all the service request messageses where REFERENCE_NO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMessagesModelImpl</code>.
	 * </p>
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param start the lower bound of the range of service request messageses
	 * @param end the upper bound of the range of service request messageses (not inclusive)
	 * @return the range of matching service request messageses
	 */
	public java.util.List<ServiceRequestMessages> findByrefNo(
		String REFERENCE_NO, int start, int end);

	/**
	 * Returns an ordered range of all the service request messageses where REFERENCE_NO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMessagesModelImpl</code>.
	 * </p>
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param start the lower bound of the range of service request messageses
	 * @param end the upper bound of the range of service request messageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service request messageses
	 */
	public java.util.List<ServiceRequestMessages> findByrefNo(
		String REFERENCE_NO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMessages>
			orderByComparator);

	/**
	 * Returns an ordered range of all the service request messageses where REFERENCE_NO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMessagesModelImpl</code>.
	 * </p>
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param start the lower bound of the range of service request messageses
	 * @param end the upper bound of the range of service request messageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service request messageses
	 */
	public java.util.List<ServiceRequestMessages> findByrefNo(
		String REFERENCE_NO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMessages>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first service request messages in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request messages
	 * @throws NoSuchServiceRequestMessagesException if a matching service request messages could not be found
	 */
	public ServiceRequestMessages findByrefNo_First(
			String REFERENCE_NO,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestMessages> orderByComparator)
		throws NoSuchServiceRequestMessagesException;

	/**
	 * Returns the first service request messages in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request messages, or <code>null</code> if a matching service request messages could not be found
	 */
	public ServiceRequestMessages fetchByrefNo_First(
		String REFERENCE_NO,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMessages>
			orderByComparator);

	/**
	 * Returns the last service request messages in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request messages
	 * @throws NoSuchServiceRequestMessagesException if a matching service request messages could not be found
	 */
	public ServiceRequestMessages findByrefNo_Last(
			String REFERENCE_NO,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestMessages> orderByComparator)
		throws NoSuchServiceRequestMessagesException;

	/**
	 * Returns the last service request messages in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request messages, or <code>null</code> if a matching service request messages could not be found
	 */
	public ServiceRequestMessages fetchByrefNo_Last(
		String REFERENCE_NO,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMessages>
			orderByComparator);

	/**
	 * Returns the service request messageses before and after the current service request messages in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param MESSAGE_ID the primary key of the current service request messages
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request messages
	 * @throws NoSuchServiceRequestMessagesException if a service request messages with the primary key could not be found
	 */
	public ServiceRequestMessages[] findByrefNo_PrevAndNext(
			long MESSAGE_ID, String REFERENCE_NO,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestMessages> orderByComparator)
		throws NoSuchServiceRequestMessagesException;

	/**
	 * Removes all the service request messageses where REFERENCE_NO = &#63; from the database.
	 *
	 * @param REFERENCE_NO the reference_no
	 */
	public void removeByrefNo(String REFERENCE_NO);

	/**
	 * Returns the number of service request messageses where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @return the number of matching service request messageses
	 */
	public int countByrefNo(String REFERENCE_NO);

	/**
	 * Caches the service request messages in the entity cache if it is enabled.
	 *
	 * @param serviceRequestMessages the service request messages
	 */
	public void cacheResult(ServiceRequestMessages serviceRequestMessages);

	/**
	 * Caches the service request messageses in the entity cache if it is enabled.
	 *
	 * @param serviceRequestMessageses the service request messageses
	 */
	public void cacheResult(
		java.util.List<ServiceRequestMessages> serviceRequestMessageses);

	/**
	 * Creates a new service request messages with the primary key. Does not add the service request messages to the database.
	 *
	 * @param MESSAGE_ID the primary key for the new service request messages
	 * @return the new service request messages
	 */
	public ServiceRequestMessages create(long MESSAGE_ID);

	/**
	 * Removes the service request messages with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param MESSAGE_ID the primary key of the service request messages
	 * @return the service request messages that was removed
	 * @throws NoSuchServiceRequestMessagesException if a service request messages with the primary key could not be found
	 */
	public ServiceRequestMessages remove(long MESSAGE_ID)
		throws NoSuchServiceRequestMessagesException;

	public ServiceRequestMessages updateImpl(
		ServiceRequestMessages serviceRequestMessages);

	/**
	 * Returns the service request messages with the primary key or throws a <code>NoSuchServiceRequestMessagesException</code> if it could not be found.
	 *
	 * @param MESSAGE_ID the primary key of the service request messages
	 * @return the service request messages
	 * @throws NoSuchServiceRequestMessagesException if a service request messages with the primary key could not be found
	 */
	public ServiceRequestMessages findByPrimaryKey(long MESSAGE_ID)
		throws NoSuchServiceRequestMessagesException;

	/**
	 * Returns the service request messages with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param MESSAGE_ID the primary key of the service request messages
	 * @return the service request messages, or <code>null</code> if a service request messages with the primary key could not be found
	 */
	public ServiceRequestMessages fetchByPrimaryKey(long MESSAGE_ID);

	/**
	 * Returns all the service request messageses.
	 *
	 * @return the service request messageses
	 */
	public java.util.List<ServiceRequestMessages> findAll();

	/**
	 * Returns a range of all the service request messageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMessagesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request messageses
	 * @param end the upper bound of the range of service request messageses (not inclusive)
	 * @return the range of service request messageses
	 */
	public java.util.List<ServiceRequestMessages> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the service request messageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMessagesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request messageses
	 * @param end the upper bound of the range of service request messageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service request messageses
	 */
	public java.util.List<ServiceRequestMessages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMessages>
			orderByComparator);

	/**
	 * Returns an ordered range of all the service request messageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMessagesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request messageses
	 * @param end the upper bound of the range of service request messageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of service request messageses
	 */
	public java.util.List<ServiceRequestMessages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMessages>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the service request messageses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of service request messageses.
	 *
	 * @return the number of service request messageses
	 */
	public int countAll();

}