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

import com.ejada.atmc.acl.db.model.ServiceRequestAttachments;

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
 * The persistence utility for the service request attachments service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.ServiceRequestAttachmentsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestAttachmentsPersistence
 * @generated
 */
public class ServiceRequestAttachmentsUtil {

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
	public static void clearCache(
		ServiceRequestAttachments serviceRequestAttachments) {

		getPersistence().clearCache(serviceRequestAttachments);
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
	public static Map<Serializable, ServiceRequestAttachments>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ServiceRequestAttachments> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ServiceRequestAttachments> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ServiceRequestAttachments> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ServiceRequestAttachments> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ServiceRequestAttachments update(
		ServiceRequestAttachments serviceRequestAttachments) {

		return getPersistence().update(serviceRequestAttachments);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ServiceRequestAttachments update(
		ServiceRequestAttachments serviceRequestAttachments,
		ServiceContext serviceContext) {

		return getPersistence().update(
			serviceRequestAttachments, serviceContext);
	}

	/**
	 * Returns all the service request attachmentses where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @return the matching service request attachmentses
	 */
	public static List<ServiceRequestAttachments> findByrefNo(
		String REFERENCE_NO) {

		return getPersistence().findByrefNo(REFERENCE_NO);
	}

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
	public static List<ServiceRequestAttachments> findByrefNo(
		String REFERENCE_NO, int start, int end) {

		return getPersistence().findByrefNo(REFERENCE_NO, start, end);
	}

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
	public static List<ServiceRequestAttachments> findByrefNo(
		String REFERENCE_NO, int start, int end,
		OrderByComparator<ServiceRequestAttachments> orderByComparator) {

		return getPersistence().findByrefNo(
			REFERENCE_NO, start, end, orderByComparator);
	}

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
	public static List<ServiceRequestAttachments> findByrefNo(
		String REFERENCE_NO, int start, int end,
		OrderByComparator<ServiceRequestAttachments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByrefNo(
			REFERENCE_NO, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first service request attachments in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a matching service request attachments could not be found
	 */
	public static ServiceRequestAttachments findByrefNo_First(
			String REFERENCE_NO,
			OrderByComparator<ServiceRequestAttachments> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestAttachmentsException {

		return getPersistence().findByrefNo_First(
			REFERENCE_NO, orderByComparator);
	}

	/**
	 * Returns the first service request attachments in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request attachments, or <code>null</code> if a matching service request attachments could not be found
	 */
	public static ServiceRequestAttachments fetchByrefNo_First(
		String REFERENCE_NO,
		OrderByComparator<ServiceRequestAttachments> orderByComparator) {

		return getPersistence().fetchByrefNo_First(
			REFERENCE_NO, orderByComparator);
	}

	/**
	 * Returns the last service request attachments in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a matching service request attachments could not be found
	 */
	public static ServiceRequestAttachments findByrefNo_Last(
			String REFERENCE_NO,
			OrderByComparator<ServiceRequestAttachments> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestAttachmentsException {

		return getPersistence().findByrefNo_Last(
			REFERENCE_NO, orderByComparator);
	}

	/**
	 * Returns the last service request attachments in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request attachments, or <code>null</code> if a matching service request attachments could not be found
	 */
	public static ServiceRequestAttachments fetchByrefNo_Last(
		String REFERENCE_NO,
		OrderByComparator<ServiceRequestAttachments> orderByComparator) {

		return getPersistence().fetchByrefNo_Last(
			REFERENCE_NO, orderByComparator);
	}

	/**
	 * Returns the service request attachmentses before and after the current service request attachments in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param FILE_ID the primary key of the current service request attachments
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a service request attachments with the primary key could not be found
	 */
	public static ServiceRequestAttachments[] findByrefNo_PrevAndNext(
			long FILE_ID, String REFERENCE_NO,
			OrderByComparator<ServiceRequestAttachments> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestAttachmentsException {

		return getPersistence().findByrefNo_PrevAndNext(
			FILE_ID, REFERENCE_NO, orderByComparator);
	}

	/**
	 * Removes all the service request attachmentses where REFERENCE_NO = &#63; from the database.
	 *
	 * @param REFERENCE_NO the reference_no
	 */
	public static void removeByrefNo(String REFERENCE_NO) {
		getPersistence().removeByrefNo(REFERENCE_NO);
	}

	/**
	 * Returns the number of service request attachmentses where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @return the number of matching service request attachmentses
	 */
	public static int countByrefNo(String REFERENCE_NO) {
		return getPersistence().countByrefNo(REFERENCE_NO);
	}

	/**
	 * Returns all the service request attachmentses where ACTION_ID = &#63;.
	 *
	 * @param ACTION_ID the action_id
	 * @return the matching service request attachmentses
	 */
	public static List<ServiceRequestAttachments> findByactionId(
		String ACTION_ID) {

		return getPersistence().findByactionId(ACTION_ID);
	}

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
	public static List<ServiceRequestAttachments> findByactionId(
		String ACTION_ID, int start, int end) {

		return getPersistence().findByactionId(ACTION_ID, start, end);
	}

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
	public static List<ServiceRequestAttachments> findByactionId(
		String ACTION_ID, int start, int end,
		OrderByComparator<ServiceRequestAttachments> orderByComparator) {

		return getPersistence().findByactionId(
			ACTION_ID, start, end, orderByComparator);
	}

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
	public static List<ServiceRequestAttachments> findByactionId(
		String ACTION_ID, int start, int end,
		OrderByComparator<ServiceRequestAttachments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByactionId(
			ACTION_ID, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first service request attachments in the ordered set where ACTION_ID = &#63;.
	 *
	 * @param ACTION_ID the action_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a matching service request attachments could not be found
	 */
	public static ServiceRequestAttachments findByactionId_First(
			String ACTION_ID,
			OrderByComparator<ServiceRequestAttachments> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestAttachmentsException {

		return getPersistence().findByactionId_First(
			ACTION_ID, orderByComparator);
	}

	/**
	 * Returns the first service request attachments in the ordered set where ACTION_ID = &#63;.
	 *
	 * @param ACTION_ID the action_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request attachments, or <code>null</code> if a matching service request attachments could not be found
	 */
	public static ServiceRequestAttachments fetchByactionId_First(
		String ACTION_ID,
		OrderByComparator<ServiceRequestAttachments> orderByComparator) {

		return getPersistence().fetchByactionId_First(
			ACTION_ID, orderByComparator);
	}

	/**
	 * Returns the last service request attachments in the ordered set where ACTION_ID = &#63;.
	 *
	 * @param ACTION_ID the action_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a matching service request attachments could not be found
	 */
	public static ServiceRequestAttachments findByactionId_Last(
			String ACTION_ID,
			OrderByComparator<ServiceRequestAttachments> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestAttachmentsException {

		return getPersistence().findByactionId_Last(
			ACTION_ID, orderByComparator);
	}

	/**
	 * Returns the last service request attachments in the ordered set where ACTION_ID = &#63;.
	 *
	 * @param ACTION_ID the action_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request attachments, or <code>null</code> if a matching service request attachments could not be found
	 */
	public static ServiceRequestAttachments fetchByactionId_Last(
		String ACTION_ID,
		OrderByComparator<ServiceRequestAttachments> orderByComparator) {

		return getPersistence().fetchByactionId_Last(
			ACTION_ID, orderByComparator);
	}

	/**
	 * Returns the service request attachmentses before and after the current service request attachments in the ordered set where ACTION_ID = &#63;.
	 *
	 * @param FILE_ID the primary key of the current service request attachments
	 * @param ACTION_ID the action_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a service request attachments with the primary key could not be found
	 */
	public static ServiceRequestAttachments[] findByactionId_PrevAndNext(
			long FILE_ID, String ACTION_ID,
			OrderByComparator<ServiceRequestAttachments> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestAttachmentsException {

		return getPersistence().findByactionId_PrevAndNext(
			FILE_ID, ACTION_ID, orderByComparator);
	}

	/**
	 * Removes all the service request attachmentses where ACTION_ID = &#63; from the database.
	 *
	 * @param ACTION_ID the action_id
	 */
	public static void removeByactionId(String ACTION_ID) {
		getPersistence().removeByactionId(ACTION_ID);
	}

	/**
	 * Returns the number of service request attachmentses where ACTION_ID = &#63;.
	 *
	 * @param ACTION_ID the action_id
	 * @return the number of matching service request attachmentses
	 */
	public static int countByactionId(String ACTION_ID) {
		return getPersistence().countByactionId(ACTION_ID);
	}

	/**
	 * Caches the service request attachments in the entity cache if it is enabled.
	 *
	 * @param serviceRequestAttachments the service request attachments
	 */
	public static void cacheResult(
		ServiceRequestAttachments serviceRequestAttachments) {

		getPersistence().cacheResult(serviceRequestAttachments);
	}

	/**
	 * Caches the service request attachmentses in the entity cache if it is enabled.
	 *
	 * @param serviceRequestAttachmentses the service request attachmentses
	 */
	public static void cacheResult(
		List<ServiceRequestAttachments> serviceRequestAttachmentses) {

		getPersistence().cacheResult(serviceRequestAttachmentses);
	}

	/**
	 * Creates a new service request attachments with the primary key. Does not add the service request attachments to the database.
	 *
	 * @param FILE_ID the primary key for the new service request attachments
	 * @return the new service request attachments
	 */
	public static ServiceRequestAttachments create(long FILE_ID) {
		return getPersistence().create(FILE_ID);
	}

	/**
	 * Removes the service request attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param FILE_ID the primary key of the service request attachments
	 * @return the service request attachments that was removed
	 * @throws NoSuchServiceRequestAttachmentsException if a service request attachments with the primary key could not be found
	 */
	public static ServiceRequestAttachments remove(long FILE_ID)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestAttachmentsException {

		return getPersistence().remove(FILE_ID);
	}

	public static ServiceRequestAttachments updateImpl(
		ServiceRequestAttachments serviceRequestAttachments) {

		return getPersistence().updateImpl(serviceRequestAttachments);
	}

	/**
	 * Returns the service request attachments with the primary key or throws a <code>NoSuchServiceRequestAttachmentsException</code> if it could not be found.
	 *
	 * @param FILE_ID the primary key of the service request attachments
	 * @return the service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a service request attachments with the primary key could not be found
	 */
	public static ServiceRequestAttachments findByPrimaryKey(long FILE_ID)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestAttachmentsException {

		return getPersistence().findByPrimaryKey(FILE_ID);
	}

	/**
	 * Returns the service request attachments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param FILE_ID the primary key of the service request attachments
	 * @return the service request attachments, or <code>null</code> if a service request attachments with the primary key could not be found
	 */
	public static ServiceRequestAttachments fetchByPrimaryKey(long FILE_ID) {
		return getPersistence().fetchByPrimaryKey(FILE_ID);
	}

	/**
	 * Returns all the service request attachmentses.
	 *
	 * @return the service request attachmentses
	 */
	public static List<ServiceRequestAttachments> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ServiceRequestAttachments> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ServiceRequestAttachments> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestAttachments> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ServiceRequestAttachments> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestAttachments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the service request attachmentses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of service request attachmentses.
	 *
	 * @return the number of service request attachmentses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ServiceRequestAttachmentsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ServiceRequestAttachmentsPersistence,
		 ServiceRequestAttachmentsPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ServiceRequestAttachmentsPersistence.class);

		ServiceTracker
			<ServiceRequestAttachmentsPersistence,
			 ServiceRequestAttachmentsPersistence> serviceTracker =
				new ServiceTracker
					<ServiceRequestAttachmentsPersistence,
					 ServiceRequestAttachmentsPersistence>(
						 bundle.getBundleContext(),
						 ServiceRequestAttachmentsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}