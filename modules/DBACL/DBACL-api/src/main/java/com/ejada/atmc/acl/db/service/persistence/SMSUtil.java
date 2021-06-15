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

import com.ejada.atmc.acl.db.model.SMS;

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
 * The persistence utility for the Sms Table service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.SMSPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SMSPersistence
 * @generated
 */
public class SMSUtil {

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
	public static void clearCache(SMS sms) {
		getPersistence().clearCache(sms);
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
	public static Map<Serializable, SMS> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SMS> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SMS> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SMS> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SMS> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SMS update(SMS sms) {
		return getPersistence().update(sms);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SMS update(SMS sms, ServiceContext serviceContext) {
		return getPersistence().update(sms, serviceContext);
	}

	/**
	 * Caches the Sms Table in the entity cache if it is enabled.
	 *
	 * @param sms the Sms Table
	 */
	public static void cacheResult(SMS sms) {
		getPersistence().cacheResult(sms);
	}

	/**
	 * Caches the Sms Tables in the entity cache if it is enabled.
	 *
	 * @param smses the Sms Tables
	 */
	public static void cacheResult(List<SMS> smses) {
		getPersistence().cacheResult(smses);
	}

	/**
	 * Creates a new Sms Table with the primary key. Does not add the Sms Table to the database.
	 *
	 * @param ID the primary key for the new Sms Table
	 * @return the new Sms Table
	 */
	public static SMS create(long ID) {
		return getPersistence().create(ID);
	}

	/**
	 * Removes the Sms Table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the Sms Table
	 * @return the Sms Table that was removed
	 * @throws NoSuchSMSException if a Sms Table with the primary key could not be found
	 */
	public static SMS remove(long ID)
		throws com.ejada.atmc.acl.db.exception.NoSuchSMSException {

		return getPersistence().remove(ID);
	}

	public static SMS updateImpl(SMS sms) {
		return getPersistence().updateImpl(sms);
	}

	/**
	 * Returns the Sms Table with the primary key or throws a <code>NoSuchSMSException</code> if it could not be found.
	 *
	 * @param ID the primary key of the Sms Table
	 * @return the Sms Table
	 * @throws NoSuchSMSException if a Sms Table with the primary key could not be found
	 */
	public static SMS findByPrimaryKey(long ID)
		throws com.ejada.atmc.acl.db.exception.NoSuchSMSException {

		return getPersistence().findByPrimaryKey(ID);
	}

	/**
	 * Returns the Sms Table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the Sms Table
	 * @return the Sms Table, or <code>null</code> if a Sms Table with the primary key could not be found
	 */
	public static SMS fetchByPrimaryKey(long ID) {
		return getPersistence().fetchByPrimaryKey(ID);
	}

	/**
	 * Returns all the Sms Tables.
	 *
	 * @return the Sms Tables
	 */
	public static List<SMS> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the Sms Tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of Sms Tables
	 * @param end the upper bound of the range of Sms Tables (not inclusive)
	 * @return the range of Sms Tables
	 */
	public static List<SMS> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the Sms Tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of Sms Tables
	 * @param end the upper bound of the range of Sms Tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Sms Tables
	 */
	public static List<SMS> findAll(
		int start, int end, OrderByComparator<SMS> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the Sms Tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of Sms Tables
	 * @param end the upper bound of the range of Sms Tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of Sms Tables
	 */
	public static List<SMS> findAll(
		int start, int end, OrderByComparator<SMS> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the Sms Tables from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of Sms Tables.
	 *
	 * @return the number of Sms Tables
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SMSPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SMSPersistence, SMSPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SMSPersistence.class);

		ServiceTracker<SMSPersistence, SMSPersistence> serviceTracker =
			new ServiceTracker<SMSPersistence, SMSPersistence>(
				bundle.getBundleContext(), SMSPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}