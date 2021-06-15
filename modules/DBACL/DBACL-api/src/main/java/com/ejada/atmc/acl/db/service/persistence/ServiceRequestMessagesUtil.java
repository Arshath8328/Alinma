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

import com.ejada.atmc.acl.db.model.ServiceRequestMessages;

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
 * The persistence utility for the service request messages service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.ServiceRequestMessagesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestMessagesPersistence
 * @generated
 */
public class ServiceRequestMessagesUtil {

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
		ServiceRequestMessages serviceRequestMessages) {

		getPersistence().clearCache(serviceRequestMessages);
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
	public static Map<Serializable, ServiceRequestMessages> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ServiceRequestMessages> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ServiceRequestMessages> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ServiceRequestMessages> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ServiceRequestMessages> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ServiceRequestMessages update(
		ServiceRequestMessages serviceRequestMessages) {

		return getPersistence().update(serviceRequestMessages);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ServiceRequestMessages update(
		ServiceRequestMessages serviceRequestMessages,
		ServiceContext serviceContext) {

		return getPersistence().update(serviceRequestMessages, serviceContext);
	}

	/**
	 * Returns all the service request messageses where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @return the matching service request messageses
	 */
	public static List<ServiceRequestMessages> findByrefNo(
		String REFERENCE_NO) {

		return getPersistence().findByrefNo(REFERENCE_NO);
	}

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
	public static List<ServiceRequestMessages> findByrefNo(
		String REFERENCE_NO, int start, int end) {

		return getPersistence().findByrefNo(REFERENCE_NO, start, end);
	}

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
	public static List<ServiceRequestMessages> findByrefNo(
		String REFERENCE_NO, int start, int end,
		OrderByComparator<ServiceRequestMessages> orderByComparator) {

		return getPersistence().findByrefNo(
			REFERENCE_NO, start, end, orderByComparator);
	}

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
	public static List<ServiceRequestMessages> findByrefNo(
		String REFERENCE_NO, int start, int end,
		OrderByComparator<ServiceRequestMessages> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByrefNo(
			REFERENCE_NO, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first service request messages in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request messages
	 * @throws NoSuchServiceRequestMessagesException if a matching service request messages could not be found
	 */
	public static ServiceRequestMessages findByrefNo_First(
			String REFERENCE_NO,
			OrderByComparator<ServiceRequestMessages> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestMessagesException {

		return getPersistence().findByrefNo_First(
			REFERENCE_NO, orderByComparator);
	}

	/**
	 * Returns the first service request messages in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request messages, or <code>null</code> if a matching service request messages could not be found
	 */
	public static ServiceRequestMessages fetchByrefNo_First(
		String REFERENCE_NO,
		OrderByComparator<ServiceRequestMessages> orderByComparator) {

		return getPersistence().fetchByrefNo_First(
			REFERENCE_NO, orderByComparator);
	}

	/**
	 * Returns the last service request messages in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request messages
	 * @throws NoSuchServiceRequestMessagesException if a matching service request messages could not be found
	 */
	public static ServiceRequestMessages findByrefNo_Last(
			String REFERENCE_NO,
			OrderByComparator<ServiceRequestMessages> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestMessagesException {

		return getPersistence().findByrefNo_Last(
			REFERENCE_NO, orderByComparator);
	}

	/**
	 * Returns the last service request messages in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request messages, or <code>null</code> if a matching service request messages could not be found
	 */
	public static ServiceRequestMessages fetchByrefNo_Last(
		String REFERENCE_NO,
		OrderByComparator<ServiceRequestMessages> orderByComparator) {

		return getPersistence().fetchByrefNo_Last(
			REFERENCE_NO, orderByComparator);
	}

	/**
	 * Returns the service request messageses before and after the current service request messages in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param MESSAGE_ID the primary key of the current service request messages
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request messages
	 * @throws NoSuchServiceRequestMessagesException if a service request messages with the primary key could not be found
	 */
	public static ServiceRequestMessages[] findByrefNo_PrevAndNext(
			long MESSAGE_ID, String REFERENCE_NO,
			OrderByComparator<ServiceRequestMessages> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestMessagesException {

		return getPersistence().findByrefNo_PrevAndNext(
			MESSAGE_ID, REFERENCE_NO, orderByComparator);
	}

	/**
	 * Removes all the service request messageses where REFERENCE_NO = &#63; from the database.
	 *
	 * @param REFERENCE_NO the reference_no
	 */
	public static void removeByrefNo(String REFERENCE_NO) {
		getPersistence().removeByrefNo(REFERENCE_NO);
	}

	/**
	 * Returns the number of service request messageses where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @return the number of matching service request messageses
	 */
	public static int countByrefNo(String REFERENCE_NO) {
		return getPersistence().countByrefNo(REFERENCE_NO);
	}

	/**
	 * Caches the service request messages in the entity cache if it is enabled.
	 *
	 * @param serviceRequestMessages the service request messages
	 */
	public static void cacheResult(
		ServiceRequestMessages serviceRequestMessages) {

		getPersistence().cacheResult(serviceRequestMessages);
	}

	/**
	 * Caches the service request messageses in the entity cache if it is enabled.
	 *
	 * @param serviceRequestMessageses the service request messageses
	 */
	public static void cacheResult(
		List<ServiceRequestMessages> serviceRequestMessageses) {

		getPersistence().cacheResult(serviceRequestMessageses);
	}

	/**
	 * Creates a new service request messages with the primary key. Does not add the service request messages to the database.
	 *
	 * @param MESSAGE_ID the primary key for the new service request messages
	 * @return the new service request messages
	 */
	public static ServiceRequestMessages create(long MESSAGE_ID) {
		return getPersistence().create(MESSAGE_ID);
	}

	/**
	 * Removes the service request messages with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param MESSAGE_ID the primary key of the service request messages
	 * @return the service request messages that was removed
	 * @throws NoSuchServiceRequestMessagesException if a service request messages with the primary key could not be found
	 */
	public static ServiceRequestMessages remove(long MESSAGE_ID)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestMessagesException {

		return getPersistence().remove(MESSAGE_ID);
	}

	public static ServiceRequestMessages updateImpl(
		ServiceRequestMessages serviceRequestMessages) {

		return getPersistence().updateImpl(serviceRequestMessages);
	}

	/**
	 * Returns the service request messages with the primary key or throws a <code>NoSuchServiceRequestMessagesException</code> if it could not be found.
	 *
	 * @param MESSAGE_ID the primary key of the service request messages
	 * @return the service request messages
	 * @throws NoSuchServiceRequestMessagesException if a service request messages with the primary key could not be found
	 */
	public static ServiceRequestMessages findByPrimaryKey(long MESSAGE_ID)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestMessagesException {

		return getPersistence().findByPrimaryKey(MESSAGE_ID);
	}

	/**
	 * Returns the service request messages with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param MESSAGE_ID the primary key of the service request messages
	 * @return the service request messages, or <code>null</code> if a service request messages with the primary key could not be found
	 */
	public static ServiceRequestMessages fetchByPrimaryKey(long MESSAGE_ID) {
		return getPersistence().fetchByPrimaryKey(MESSAGE_ID);
	}

	/**
	 * Returns all the service request messageses.
	 *
	 * @return the service request messageses
	 */
	public static List<ServiceRequestMessages> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ServiceRequestMessages> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ServiceRequestMessages> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestMessages> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ServiceRequestMessages> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestMessages> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the service request messageses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of service request messageses.
	 *
	 * @return the number of service request messageses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ServiceRequestMessagesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ServiceRequestMessagesPersistence, ServiceRequestMessagesPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ServiceRequestMessagesPersistence.class);

		ServiceTracker
			<ServiceRequestMessagesPersistence,
			 ServiceRequestMessagesPersistence> serviceTracker =
				new ServiceTracker
					<ServiceRequestMessagesPersistence,
					 ServiceRequestMessagesPersistence>(
						 bundle.getBundleContext(),
						 ServiceRequestMessagesPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}