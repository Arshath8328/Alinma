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

import com.ejada.atmc.acl.db.model.YakeenDataSave;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the yakeen data save service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.YakeenDataSavePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see YakeenDataSavePersistence
 * @generated
 */
public class YakeenDataSaveUtil {

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
	public static void clearCache(YakeenDataSave yakeenDataSave) {
		getPersistence().clearCache(yakeenDataSave);
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
	public static Map<Serializable, YakeenDataSave> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<YakeenDataSave> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<YakeenDataSave> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<YakeenDataSave> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<YakeenDataSave> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static YakeenDataSave update(YakeenDataSave yakeenDataSave) {
		return getPersistence().update(yakeenDataSave);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static YakeenDataSave update(
		YakeenDataSave yakeenDataSave, ServiceContext serviceContext) {

		return getPersistence().update(yakeenDataSave, serviceContext);
	}

	/**
	 * Returns the yakeen data save where Id = &#63; and dob = &#63; and status = &#63; and serviceName = &#63; or throws a <code>NoSuchYakeenDataSaveException</code> if it could not be found.
	 *
	 * @param Id the ID
	 * @param dob the dob
	 * @param status the status
	 * @param serviceName the service name
	 * @return the matching yakeen data save
	 * @throws NoSuchYakeenDataSaveException if a matching yakeen data save could not be found
	 */
	public static YakeenDataSave findByiqamaDobStatusServiceName(
			String Id, Date dob, String status, String serviceName)
		throws com.ejada.atmc.acl.db.exception.NoSuchYakeenDataSaveException {

		return getPersistence().findByiqamaDobStatusServiceName(
			Id, dob, status, serviceName);
	}

	/**
	 * Returns the yakeen data save where Id = &#63; and dob = &#63; and status = &#63; and serviceName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param Id the ID
	 * @param dob the dob
	 * @param status the status
	 * @param serviceName the service name
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	public static YakeenDataSave fetchByiqamaDobStatusServiceName(
		String Id, Date dob, String status, String serviceName) {

		return getPersistence().fetchByiqamaDobStatusServiceName(
			Id, dob, status, serviceName);
	}

	/**
	 * Returns the yakeen data save where Id = &#63; and dob = &#63; and status = &#63; and serviceName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param Id the ID
	 * @param dob the dob
	 * @param status the status
	 * @param serviceName the service name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	public static YakeenDataSave fetchByiqamaDobStatusServiceName(
		String Id, Date dob, String status, String serviceName,
		boolean useFinderCache) {

		return getPersistence().fetchByiqamaDobStatusServiceName(
			Id, dob, status, serviceName, useFinderCache);
	}

	/**
	 * Removes the yakeen data save where Id = &#63; and dob = &#63; and status = &#63; and serviceName = &#63; from the database.
	 *
	 * @param Id the ID
	 * @param dob the dob
	 * @param status the status
	 * @param serviceName the service name
	 * @return the yakeen data save that was removed
	 */
	public static YakeenDataSave removeByiqamaDobStatusServiceName(
			String Id, Date dob, String status, String serviceName)
		throws com.ejada.atmc.acl.db.exception.NoSuchYakeenDataSaveException {

		return getPersistence().removeByiqamaDobStatusServiceName(
			Id, dob, status, serviceName);
	}

	/**
	 * Returns the number of yakeen data saves where Id = &#63; and dob = &#63; and status = &#63; and serviceName = &#63;.
	 *
	 * @param Id the ID
	 * @param dob the dob
	 * @param status the status
	 * @param serviceName the service name
	 * @return the number of matching yakeen data saves
	 */
	public static int countByiqamaDobStatusServiceName(
		String Id, Date dob, String status, String serviceName) {

		return getPersistence().countByiqamaDobStatusServiceName(
			Id, dob, status, serviceName);
	}

	/**
	 * Returns the yakeen data save where serviceName = &#63; and status = &#63; and Id = &#63; or throws a <code>NoSuchYakeenDataSaveException</code> if it could not be found.
	 *
	 * @param serviceName the service name
	 * @param status the status
	 * @param Id the ID
	 * @return the matching yakeen data save
	 * @throws NoSuchYakeenDataSaveException if a matching yakeen data save could not be found
	 */
	public static YakeenDataSave findByiqamaStatusServiceName(
			String serviceName, String status, String Id)
		throws com.ejada.atmc.acl.db.exception.NoSuchYakeenDataSaveException {

		return getPersistence().findByiqamaStatusServiceName(
			serviceName, status, Id);
	}

	/**
	 * Returns the yakeen data save where serviceName = &#63; and status = &#63; and Id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param serviceName the service name
	 * @param status the status
	 * @param Id the ID
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	public static YakeenDataSave fetchByiqamaStatusServiceName(
		String serviceName, String status, String Id) {

		return getPersistence().fetchByiqamaStatusServiceName(
			serviceName, status, Id);
	}

	/**
	 * Returns the yakeen data save where serviceName = &#63; and status = &#63; and Id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param serviceName the service name
	 * @param status the status
	 * @param Id the ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	public static YakeenDataSave fetchByiqamaStatusServiceName(
		String serviceName, String status, String Id, boolean useFinderCache) {

		return getPersistence().fetchByiqamaStatusServiceName(
			serviceName, status, Id, useFinderCache);
	}

	/**
	 * Removes the yakeen data save where serviceName = &#63; and status = &#63; and Id = &#63; from the database.
	 *
	 * @param serviceName the service name
	 * @param status the status
	 * @param Id the ID
	 * @return the yakeen data save that was removed
	 */
	public static YakeenDataSave removeByiqamaStatusServiceName(
			String serviceName, String status, String Id)
		throws com.ejada.atmc.acl.db.exception.NoSuchYakeenDataSaveException {

		return getPersistence().removeByiqamaStatusServiceName(
			serviceName, status, Id);
	}

	/**
	 * Returns the number of yakeen data saves where serviceName = &#63; and status = &#63; and Id = &#63;.
	 *
	 * @param serviceName the service name
	 * @param status the status
	 * @param Id the ID
	 * @return the number of matching yakeen data saves
	 */
	public static int countByiqamaStatusServiceName(
		String serviceName, String status, String Id) {

		return getPersistence().countByiqamaStatusServiceName(
			serviceName, status, Id);
	}

	/**
	 * Returns the yakeen data save where Id = &#63; and sequenceNumber = &#63; and serviceName = &#63; and status = &#63; or throws a <code>NoSuchYakeenDataSaveException</code> if it could not be found.
	 *
	 * @param Id the ID
	 * @param sequenceNumber the sequence number
	 * @param serviceName the service name
	 * @param status the status
	 * @return the matching yakeen data save
	 * @throws NoSuchYakeenDataSaveException if a matching yakeen data save could not be found
	 */
	public static YakeenDataSave findBycitIzenCarInfoIdSeq(
			String Id, String sequenceNumber, String serviceName, String status)
		throws com.ejada.atmc.acl.db.exception.NoSuchYakeenDataSaveException {

		return getPersistence().findBycitIzenCarInfoIdSeq(
			Id, sequenceNumber, serviceName, status);
	}

	/**
	 * Returns the yakeen data save where Id = &#63; and sequenceNumber = &#63; and serviceName = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param Id the ID
	 * @param sequenceNumber the sequence number
	 * @param serviceName the service name
	 * @param status the status
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	public static YakeenDataSave fetchBycitIzenCarInfoIdSeq(
		String Id, String sequenceNumber, String serviceName, String status) {

		return getPersistence().fetchBycitIzenCarInfoIdSeq(
			Id, sequenceNumber, serviceName, status);
	}

	/**
	 * Returns the yakeen data save where Id = &#63; and sequenceNumber = &#63; and serviceName = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param Id the ID
	 * @param sequenceNumber the sequence number
	 * @param serviceName the service name
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	public static YakeenDataSave fetchBycitIzenCarInfoIdSeq(
		String Id, String sequenceNumber, String serviceName, String status,
		boolean useFinderCache) {

		return getPersistence().fetchBycitIzenCarInfoIdSeq(
			Id, sequenceNumber, serviceName, status, useFinderCache);
	}

	/**
	 * Removes the yakeen data save where Id = &#63; and sequenceNumber = &#63; and serviceName = &#63; and status = &#63; from the database.
	 *
	 * @param Id the ID
	 * @param sequenceNumber the sequence number
	 * @param serviceName the service name
	 * @param status the status
	 * @return the yakeen data save that was removed
	 */
	public static YakeenDataSave removeBycitIzenCarInfoIdSeq(
			String Id, String sequenceNumber, String serviceName, String status)
		throws com.ejada.atmc.acl.db.exception.NoSuchYakeenDataSaveException {

		return getPersistence().removeBycitIzenCarInfoIdSeq(
			Id, sequenceNumber, serviceName, status);
	}

	/**
	 * Returns the number of yakeen data saves where Id = &#63; and sequenceNumber = &#63; and serviceName = &#63; and status = &#63;.
	 *
	 * @param Id the ID
	 * @param sequenceNumber the sequence number
	 * @param serviceName the service name
	 * @param status the status
	 * @return the number of matching yakeen data saves
	 */
	public static int countBycitIzenCarInfoIdSeq(
		String Id, String sequenceNumber, String serviceName, String status) {

		return getPersistence().countBycitIzenCarInfoIdSeq(
			Id, sequenceNumber, serviceName, status);
	}

	/**
	 * Returns the yakeen data save where sequenceNumber = &#63; or throws a <code>NoSuchYakeenDataSaveException</code> if it could not be found.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the matching yakeen data save
	 * @throws NoSuchYakeenDataSaveException if a matching yakeen data save could not be found
	 */
	public static YakeenDataSave findByVehicleSequence(String sequenceNumber)
		throws com.ejada.atmc.acl.db.exception.NoSuchYakeenDataSaveException {

		return getPersistence().findByVehicleSequence(sequenceNumber);
	}

	/**
	 * Returns the yakeen data save where sequenceNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	public static YakeenDataSave fetchByVehicleSequence(String sequenceNumber) {
		return getPersistence().fetchByVehicleSequence(sequenceNumber);
	}

	/**
	 * Returns the yakeen data save where sequenceNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sequenceNumber the sequence number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	public static YakeenDataSave fetchByVehicleSequence(
		String sequenceNumber, boolean useFinderCache) {

		return getPersistence().fetchByVehicleSequence(
			sequenceNumber, useFinderCache);
	}

	/**
	 * Removes the yakeen data save where sequenceNumber = &#63; from the database.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the yakeen data save that was removed
	 */
	public static YakeenDataSave removeByVehicleSequence(String sequenceNumber)
		throws com.ejada.atmc.acl.db.exception.NoSuchYakeenDataSaveException {

		return getPersistence().removeByVehicleSequence(sequenceNumber);
	}

	/**
	 * Returns the number of yakeen data saves where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the number of matching yakeen data saves
	 */
	public static int countByVehicleSequence(String sequenceNumber) {
		return getPersistence().countByVehicleSequence(sequenceNumber);
	}

	/**
	 * Caches the yakeen data save in the entity cache if it is enabled.
	 *
	 * @param yakeenDataSave the yakeen data save
	 */
	public static void cacheResult(YakeenDataSave yakeenDataSave) {
		getPersistence().cacheResult(yakeenDataSave);
	}

	/**
	 * Caches the yakeen data saves in the entity cache if it is enabled.
	 *
	 * @param yakeenDataSaves the yakeen data saves
	 */
	public static void cacheResult(List<YakeenDataSave> yakeenDataSaves) {
		getPersistence().cacheResult(yakeenDataSaves);
	}

	/**
	 * Creates a new yakeen data save with the primary key. Does not add the yakeen data save to the database.
	 *
	 * @param Id the primary key for the new yakeen data save
	 * @return the new yakeen data save
	 */
	public static YakeenDataSave create(String Id) {
		return getPersistence().create(Id);
	}

	/**
	 * Removes the yakeen data save with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the yakeen data save
	 * @return the yakeen data save that was removed
	 * @throws NoSuchYakeenDataSaveException if a yakeen data save with the primary key could not be found
	 */
	public static YakeenDataSave remove(String Id)
		throws com.ejada.atmc.acl.db.exception.NoSuchYakeenDataSaveException {

		return getPersistence().remove(Id);
	}

	public static YakeenDataSave updateImpl(YakeenDataSave yakeenDataSave) {
		return getPersistence().updateImpl(yakeenDataSave);
	}

	/**
	 * Returns the yakeen data save with the primary key or throws a <code>NoSuchYakeenDataSaveException</code> if it could not be found.
	 *
	 * @param Id the primary key of the yakeen data save
	 * @return the yakeen data save
	 * @throws NoSuchYakeenDataSaveException if a yakeen data save with the primary key could not be found
	 */
	public static YakeenDataSave findByPrimaryKey(String Id)
		throws com.ejada.atmc.acl.db.exception.NoSuchYakeenDataSaveException {

		return getPersistence().findByPrimaryKey(Id);
	}

	/**
	 * Returns the yakeen data save with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the yakeen data save
	 * @return the yakeen data save, or <code>null</code> if a yakeen data save with the primary key could not be found
	 */
	public static YakeenDataSave fetchByPrimaryKey(String Id) {
		return getPersistence().fetchByPrimaryKey(Id);
	}

	/**
	 * Returns all the yakeen data saves.
	 *
	 * @return the yakeen data saves
	 */
	public static List<YakeenDataSave> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the yakeen data saves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>YakeenDataSaveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of yakeen data saves
	 * @param end the upper bound of the range of yakeen data saves (not inclusive)
	 * @return the range of yakeen data saves
	 */
	public static List<YakeenDataSave> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the yakeen data saves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>YakeenDataSaveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of yakeen data saves
	 * @param end the upper bound of the range of yakeen data saves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of yakeen data saves
	 */
	public static List<YakeenDataSave> findAll(
		int start, int end,
		OrderByComparator<YakeenDataSave> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the yakeen data saves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>YakeenDataSaveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of yakeen data saves
	 * @param end the upper bound of the range of yakeen data saves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of yakeen data saves
	 */
	public static List<YakeenDataSave> findAll(
		int start, int end, OrderByComparator<YakeenDataSave> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the yakeen data saves from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of yakeen data saves.
	 *
	 * @return the number of yakeen data saves
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static YakeenDataSavePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<YakeenDataSavePersistence, YakeenDataSavePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			YakeenDataSavePersistence.class);

		ServiceTracker<YakeenDataSavePersistence, YakeenDataSavePersistence>
			serviceTracker =
				new ServiceTracker
					<YakeenDataSavePersistence, YakeenDataSavePersistence>(
						bundle.getBundleContext(),
						YakeenDataSavePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}