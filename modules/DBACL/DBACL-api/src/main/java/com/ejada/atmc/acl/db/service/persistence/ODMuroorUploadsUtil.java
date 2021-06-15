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

import com.ejada.atmc.acl.db.model.ODMuroorUploads;

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
 * The persistence utility for the od muroor uploads service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.ODMuroorUploadsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ODMuroorUploadsPersistence
 * @generated
 */
public class ODMuroorUploadsUtil {

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
	public static void clearCache(ODMuroorUploads odMuroorUploads) {
		getPersistence().clearCache(odMuroorUploads);
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
	public static Map<Serializable, ODMuroorUploads> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ODMuroorUploads> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ODMuroorUploads> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ODMuroorUploads> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ODMuroorUploads> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ODMuroorUploads update(ODMuroorUploads odMuroorUploads) {
		return getPersistence().update(odMuroorUploads);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ODMuroorUploads update(
		ODMuroorUploads odMuroorUploads, ServiceContext serviceContext) {

		return getPersistence().update(odMuroorUploads, serviceContext);
	}

	/**
	 * Returns the od muroor uploads where claimIntimationNo = &#63; or throws a <code>NoSuchODMuroorUploadsException</code> if it could not be found.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the matching od muroor uploads
	 * @throws NoSuchODMuroorUploadsException if a matching od muroor uploads could not be found
	 */
	public static ODMuroorUploads findByclaimIntimationNo(
			String claimIntimationNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchODMuroorUploadsException {

		return getPersistence().findByclaimIntimationNo(claimIntimationNo);
	}

	/**
	 * Returns the od muroor uploads where claimIntimationNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the matching od muroor uploads, or <code>null</code> if a matching od muroor uploads could not be found
	 */
	public static ODMuroorUploads fetchByclaimIntimationNo(
		String claimIntimationNo) {

		return getPersistence().fetchByclaimIntimationNo(claimIntimationNo);
	}

	/**
	 * Returns the od muroor uploads where claimIntimationNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching od muroor uploads, or <code>null</code> if a matching od muroor uploads could not be found
	 */
	public static ODMuroorUploads fetchByclaimIntimationNo(
		String claimIntimationNo, boolean useFinderCache) {

		return getPersistence().fetchByclaimIntimationNo(
			claimIntimationNo, useFinderCache);
	}

	/**
	 * Removes the od muroor uploads where claimIntimationNo = &#63; from the database.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the od muroor uploads that was removed
	 */
	public static ODMuroorUploads removeByclaimIntimationNo(
			String claimIntimationNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchODMuroorUploadsException {

		return getPersistence().removeByclaimIntimationNo(claimIntimationNo);
	}

	/**
	 * Returns the number of od muroor uploadses where claimIntimationNo = &#63;.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the number of matching od muroor uploadses
	 */
	public static int countByclaimIntimationNo(String claimIntimationNo) {
		return getPersistence().countByclaimIntimationNo(claimIntimationNo);
	}

	/**
	 * Caches the od muroor uploads in the entity cache if it is enabled.
	 *
	 * @param odMuroorUploads the od muroor uploads
	 */
	public static void cacheResult(ODMuroorUploads odMuroorUploads) {
		getPersistence().cacheResult(odMuroorUploads);
	}

	/**
	 * Caches the od muroor uploadses in the entity cache if it is enabled.
	 *
	 * @param odMuroorUploadses the od muroor uploadses
	 */
	public static void cacheResult(List<ODMuroorUploads> odMuroorUploadses) {
		getPersistence().cacheResult(odMuroorUploadses);
	}

	/**
	 * Creates a new od muroor uploads with the primary key. Does not add the od muroor uploads to the database.
	 *
	 * @param id the primary key for the new od muroor uploads
	 * @return the new od muroor uploads
	 */
	public static ODMuroorUploads create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the od muroor uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the od muroor uploads
	 * @return the od muroor uploads that was removed
	 * @throws NoSuchODMuroorUploadsException if a od muroor uploads with the primary key could not be found
	 */
	public static ODMuroorUploads remove(int id)
		throws com.ejada.atmc.acl.db.exception.NoSuchODMuroorUploadsException {

		return getPersistence().remove(id);
	}

	public static ODMuroorUploads updateImpl(ODMuroorUploads odMuroorUploads) {
		return getPersistence().updateImpl(odMuroorUploads);
	}

	/**
	 * Returns the od muroor uploads with the primary key or throws a <code>NoSuchODMuroorUploadsException</code> if it could not be found.
	 *
	 * @param id the primary key of the od muroor uploads
	 * @return the od muroor uploads
	 * @throws NoSuchODMuroorUploadsException if a od muroor uploads with the primary key could not be found
	 */
	public static ODMuroorUploads findByPrimaryKey(int id)
		throws com.ejada.atmc.acl.db.exception.NoSuchODMuroorUploadsException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the od muroor uploads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the od muroor uploads
	 * @return the od muroor uploads, or <code>null</code> if a od muroor uploads with the primary key could not be found
	 */
	public static ODMuroorUploads fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the od muroor uploadses.
	 *
	 * @return the od muroor uploadses
	 */
	public static List<ODMuroorUploads> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the od muroor uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ODMuroorUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of od muroor uploadses
	 * @param end the upper bound of the range of od muroor uploadses (not inclusive)
	 * @return the range of od muroor uploadses
	 */
	public static List<ODMuroorUploads> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the od muroor uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ODMuroorUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of od muroor uploadses
	 * @param end the upper bound of the range of od muroor uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of od muroor uploadses
	 */
	public static List<ODMuroorUploads> findAll(
		int start, int end,
		OrderByComparator<ODMuroorUploads> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the od muroor uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ODMuroorUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of od muroor uploadses
	 * @param end the upper bound of the range of od muroor uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of od muroor uploadses
	 */
	public static List<ODMuroorUploads> findAll(
		int start, int end,
		OrderByComparator<ODMuroorUploads> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the od muroor uploadses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of od muroor uploadses.
	 *
	 * @return the number of od muroor uploadses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ODMuroorUploadsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ODMuroorUploadsPersistence, ODMuroorUploadsPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ODMuroorUploadsPersistence.class);

		ServiceTracker<ODMuroorUploadsPersistence, ODMuroorUploadsPersistence>
			serviceTracker =
				new ServiceTracker
					<ODMuroorUploadsPersistence, ODMuroorUploadsPersistence>(
						bundle.getBundleContext(),
						ODMuroorUploadsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}