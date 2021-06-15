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

import com.ejada.atmc.acl.db.exception.NoSuchServiceRequestAttachmentsException;
import com.ejada.atmc.acl.db.model.ServiceRequestAttachments;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the service request attachments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestAttachmentsUtil
 * @generated
 */
@ProviderType
public interface ServiceRequestAttachmentsPersistence
	extends BasePersistence<ServiceRequestAttachments> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServiceRequestAttachmentsUtil} to access the service request attachments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the service request attachmentses where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @return the matching service request attachmentses
	 */
	public java.util.List<ServiceRequestAttachments> findByrefNo(
		String REFERENCE_NO);

	/**
	 * Returns a range of all the service request attachmentses where REFERENCE_NO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param start the lower bound of the range of service request attachmentses
	 * @param end the upper bound of the range of service request attachmentses (not inclusive)
	 * @return the range of matching service request attachmentses
	 */
	public java.util.List<ServiceRequestAttachments> findByrefNo(
		String REFERENCE_NO, int start, int end);

	/**
	 * Returns an ordered range of all the service request attachmentses where REFERENCE_NO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param start the lower bound of the range of service request attachmentses
	 * @param end the upper bound of the range of service request attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service request attachmentses
	 */
	public java.util.List<ServiceRequestAttachments> findByrefNo(
		String REFERENCE_NO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ServiceRequestAttachments> orderByComparator);

	/**
	 * Returns an ordered range of all the service request attachmentses where REFERENCE_NO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param start the lower bound of the range of service request attachmentses
	 * @param end the upper bound of the range of service request attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service request attachmentses
	 */
	public java.util.List<ServiceRequestAttachments> findByrefNo(
		String REFERENCE_NO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ServiceRequestAttachments> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first service request attachments in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a matching service request attachments could not be found
	 */
	public ServiceRequestAttachments findByrefNo_First(
			String REFERENCE_NO,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestAttachments> orderByComparator)
		throws NoSuchServiceRequestAttachmentsException;

	/**
	 * Returns the first service request attachments in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request attachments, or <code>null</code> if a matching service request attachments could not be found
	 */
	public ServiceRequestAttachments fetchByrefNo_First(
		String REFERENCE_NO,
		com.liferay.portal.kernel.util.OrderByComparator
			<ServiceRequestAttachments> orderByComparator);

	/**
	 * Returns the last service request attachments in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a matching service request attachments could not be found
	 */
	public ServiceRequestAttachments findByrefNo_Last(
			String REFERENCE_NO,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestAttachments> orderByComparator)
		throws NoSuchServiceRequestAttachmentsException;

	/**
	 * Returns the last service request attachments in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request attachments, or <code>null</code> if a matching service request attachments could not be found
	 */
	public ServiceRequestAttachments fetchByrefNo_Last(
		String REFERENCE_NO,
		com.liferay.portal.kernel.util.OrderByComparator
			<ServiceRequestAttachments> orderByComparator);

	/**
	 * Returns the service request attachmentses before and after the current service request attachments in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param FILE_ID the primary key of the current service request attachments
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a service request attachments with the primary key could not be found
	 */
	public ServiceRequestAttachments[] findByrefNo_PrevAndNext(
			long FILE_ID, String REFERENCE_NO,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestAttachments> orderByComparator)
		throws NoSuchServiceRequestAttachmentsException;

	/**
	 * Removes all the service request attachmentses where REFERENCE_NO = &#63; from the database.
	 *
	 * @param REFERENCE_NO the reference_no
	 */
	public void removeByrefNo(String REFERENCE_NO);

	/**
	 * Returns the number of service request attachmentses where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @return the number of matching service request attachmentses
	 */
	public int countByrefNo(String REFERENCE_NO);

	/**
	 * Returns all the service request attachmentses where ACTION_ID = &#63;.
	 *
	 * @param ACTION_ID the action_id
	 * @return the matching service request attachmentses
	 */
	public java.util.List<ServiceRequestAttachments> findByactionId(
		String ACTION_ID);

	/**
	 * Returns a range of all the service request attachmentses where ACTION_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param ACTION_ID the action_id
	 * @param start the lower bound of the range of service request attachmentses
	 * @param end the upper bound of the range of service request attachmentses (not inclusive)
	 * @return the range of matching service request attachmentses
	 */
	public java.util.List<ServiceRequestAttachments> findByactionId(
		String ACTION_ID, int start, int end);

	/**
	 * Returns an ordered range of all the service request attachmentses where ACTION_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param ACTION_ID the action_id
	 * @param start the lower bound of the range of service request attachmentses
	 * @param end the upper bound of the range of service request attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service request attachmentses
	 */
	public java.util.List<ServiceRequestAttachments> findByactionId(
		String ACTION_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ServiceRequestAttachments> orderByComparator);

	/**
	 * Returns an ordered range of all the service request attachmentses where ACTION_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param ACTION_ID the action_id
	 * @param start the lower bound of the range of service request attachmentses
	 * @param end the upper bound of the range of service request attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service request attachmentses
	 */
	public java.util.List<ServiceRequestAttachments> findByactionId(
		String ACTION_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ServiceRequestAttachments> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first service request attachments in the ordered set where ACTION_ID = &#63;.
	 *
	 * @param ACTION_ID the action_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a matching service request attachments could not be found
	 */
	public ServiceRequestAttachments findByactionId_First(
			String ACTION_ID,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestAttachments> orderByComparator)
		throws NoSuchServiceRequestAttachmentsException;

	/**
	 * Returns the first service request attachments in the ordered set where ACTION_ID = &#63;.
	 *
	 * @param ACTION_ID the action_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request attachments, or <code>null</code> if a matching service request attachments could not be found
	 */
	public ServiceRequestAttachments fetchByactionId_First(
		String ACTION_ID,
		com.liferay.portal.kernel.util.OrderByComparator
			<ServiceRequestAttachments> orderByComparator);

	/**
	 * Returns the last service request attachments in the ordered set where ACTION_ID = &#63;.
	 *
	 * @param ACTION_ID the action_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a matching service request attachments could not be found
	 */
	public ServiceRequestAttachments findByactionId_Last(
			String ACTION_ID,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestAttachments> orderByComparator)
		throws NoSuchServiceRequestAttachmentsException;

	/**
	 * Returns the last service request attachments in the ordered set where ACTION_ID = &#63;.
	 *
	 * @param ACTION_ID the action_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request attachments, or <code>null</code> if a matching service request attachments could not be found
	 */
	public ServiceRequestAttachments fetchByactionId_Last(
		String ACTION_ID,
		com.liferay.portal.kernel.util.OrderByComparator
			<ServiceRequestAttachments> orderByComparator);

	/**
	 * Returns the service request attachmentses before and after the current service request attachments in the ordered set where ACTION_ID = &#63;.
	 *
	 * @param FILE_ID the primary key of the current service request attachments
	 * @param ACTION_ID the action_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a service request attachments with the primary key could not be found
	 */
	public ServiceRequestAttachments[] findByactionId_PrevAndNext(
			long FILE_ID, String ACTION_ID,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestAttachments> orderByComparator)
		throws NoSuchServiceRequestAttachmentsException;

	/**
	 * Removes all the service request attachmentses where ACTION_ID = &#63; from the database.
	 *
	 * @param ACTION_ID the action_id
	 */
	public void removeByactionId(String ACTION_ID);

	/**
	 * Returns the number of service request attachmentses where ACTION_ID = &#63;.
	 *
	 * @param ACTION_ID the action_id
	 * @return the number of matching service request attachmentses
	 */
	public int countByactionId(String ACTION_ID);

	/**
	 * Caches the service request attachments in the entity cache if it is enabled.
	 *
	 * @param serviceRequestAttachments the service request attachments
	 */
	public void cacheResult(
		ServiceRequestAttachments serviceRequestAttachments);

	/**
	 * Caches the service request attachmentses in the entity cache if it is enabled.
	 *
	 * @param serviceRequestAttachmentses the service request attachmentses
	 */
	public void cacheResult(
		java.util.List<ServiceRequestAttachments> serviceRequestAttachmentses);

	/**
	 * Creates a new service request attachments with the primary key. Does not add the service request attachments to the database.
	 *
	 * @param FILE_ID the primary key for the new service request attachments
	 * @return the new service request attachments
	 */
	public ServiceRequestAttachments create(long FILE_ID);

	/**
	 * Removes the service request attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param FILE_ID the primary key of the service request attachments
	 * @return the service request attachments that was removed
	 * @throws NoSuchServiceRequestAttachmentsException if a service request attachments with the primary key could not be found
	 */
	public ServiceRequestAttachments remove(long FILE_ID)
		throws NoSuchServiceRequestAttachmentsException;

	public ServiceRequestAttachments updateImpl(
		ServiceRequestAttachments serviceRequestAttachments);

	/**
	 * Returns the service request attachments with the primary key or throws a <code>NoSuchServiceRequestAttachmentsException</code> if it could not be found.
	 *
	 * @param FILE_ID the primary key of the service request attachments
	 * @return the service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a service request attachments with the primary key could not be found
	 */
	public ServiceRequestAttachments findByPrimaryKey(long FILE_ID)
		throws NoSuchServiceRequestAttachmentsException;

	/**
	 * Returns the service request attachments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param FILE_ID the primary key of the service request attachments
	 * @return the service request attachments, or <code>null</code> if a service request attachments with the primary key could not be found
	 */
	public ServiceRequestAttachments fetchByPrimaryKey(long FILE_ID);

	/**
	 * Returns all the service request attachmentses.
	 *
	 * @return the service request attachmentses
	 */
	public java.util.List<ServiceRequestAttachments> findAll();

	/**
	 * Returns a range of all the service request attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request attachmentses
	 * @param end the upper bound of the range of service request attachmentses (not inclusive)
	 * @return the range of service request attachmentses
	 */
	public java.util.List<ServiceRequestAttachments> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the service request attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request attachmentses
	 * @param end the upper bound of the range of service request attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service request attachmentses
	 */
	public java.util.List<ServiceRequestAttachments> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ServiceRequestAttachments> orderByComparator);

	/**
	 * Returns an ordered range of all the service request attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request attachmentses
	 * @param end the upper bound of the range of service request attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of service request attachmentses
	 */
	public java.util.List<ServiceRequestAttachments> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ServiceRequestAttachments> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the service request attachmentses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of service request attachmentses.
	 *
	 * @return the number of service request attachmentses
	 */
	public int countAll();

}