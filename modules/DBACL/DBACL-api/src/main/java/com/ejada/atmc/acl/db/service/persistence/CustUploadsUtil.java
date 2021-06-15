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

import com.ejada.atmc.acl.db.model.CustUploads;

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
 * The persistence utility for the cust uploads service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.CustUploadsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustUploadsPersistence
 * @generated
 */
public class CustUploadsUtil {

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
	public static void clearCache(CustUploads custUploads) {
		getPersistence().clearCache(custUploads);
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
	public static Map<Serializable, CustUploads> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CustUploads> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CustUploads> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CustUploads> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CustUploads> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CustUploads update(CustUploads custUploads) {
		return getPersistence().update(custUploads);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CustUploads update(
		CustUploads custUploads, ServiceContext serviceContext) {

		return getPersistence().update(custUploads, serviceContext);
	}

	/**
	 * Returns the cust uploads where quotId = &#63; or throws a <code>NoSuchCustUploadsException</code> if it could not be found.
	 *
	 * @param quotId the quot ID
	 * @return the matching cust uploads
	 * @throws NoSuchCustUploadsException if a matching cust uploads could not be found
	 */
	public static CustUploads findByquotId(String quotId)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustUploadsException {

		return getPersistence().findByquotId(quotId);
	}

	/**
	 * Returns the cust uploads where quotId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quotId the quot ID
	 * @return the matching cust uploads, or <code>null</code> if a matching cust uploads could not be found
	 */
	public static CustUploads fetchByquotId(String quotId) {
		return getPersistence().fetchByquotId(quotId);
	}

	/**
	 * Returns the cust uploads where quotId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quotId the quot ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cust uploads, or <code>null</code> if a matching cust uploads could not be found
	 */
	public static CustUploads fetchByquotId(
		String quotId, boolean useFinderCache) {

		return getPersistence().fetchByquotId(quotId, useFinderCache);
	}

	/**
	 * Removes the cust uploads where quotId = &#63; from the database.
	 *
	 * @param quotId the quot ID
	 * @return the cust uploads that was removed
	 */
	public static CustUploads removeByquotId(String quotId)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustUploadsException {

		return getPersistence().removeByquotId(quotId);
	}

	/**
	 * Returns the number of cust uploadses where quotId = &#63;.
	 *
	 * @param quotId the quot ID
	 * @return the number of matching cust uploadses
	 */
	public static int countByquotId(String quotId) {
		return getPersistence().countByquotId(quotId);
	}

	/**
	 * Caches the cust uploads in the entity cache if it is enabled.
	 *
	 * @param custUploads the cust uploads
	 */
	public static void cacheResult(CustUploads custUploads) {
		getPersistence().cacheResult(custUploads);
	}

	/**
	 * Caches the cust uploadses in the entity cache if it is enabled.
	 *
	 * @param custUploadses the cust uploadses
	 */
	public static void cacheResult(List<CustUploads> custUploadses) {
		getPersistence().cacheResult(custUploadses);
	}

	/**
	 * Creates a new cust uploads with the primary key. Does not add the cust uploads to the database.
	 *
	 * @param id the primary key for the new cust uploads
	 * @return the new cust uploads
	 */
	public static CustUploads create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the cust uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cust uploads
	 * @return the cust uploads that was removed
	 * @throws NoSuchCustUploadsException if a cust uploads with the primary key could not be found
	 */
	public static CustUploads remove(long id)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustUploadsException {

		return getPersistence().remove(id);
	}

	public static CustUploads updateImpl(CustUploads custUploads) {
		return getPersistence().updateImpl(custUploads);
	}

	/**
	 * Returns the cust uploads with the primary key or throws a <code>NoSuchCustUploadsException</code> if it could not be found.
	 *
	 * @param id the primary key of the cust uploads
	 * @return the cust uploads
	 * @throws NoSuchCustUploadsException if a cust uploads with the primary key could not be found
	 */
	public static CustUploads findByPrimaryKey(long id)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustUploadsException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the cust uploads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cust uploads
	 * @return the cust uploads, or <code>null</code> if a cust uploads with the primary key could not be found
	 */
	public static CustUploads fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the cust uploadses.
	 *
	 * @return the cust uploadses
	 */
	public static List<CustUploads> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cust uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cust uploadses
	 * @param end the upper bound of the range of cust uploadses (not inclusive)
	 * @return the range of cust uploadses
	 */
	public static List<CustUploads> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cust uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cust uploadses
	 * @param end the upper bound of the range of cust uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cust uploadses
	 */
	public static List<CustUploads> findAll(
		int start, int end, OrderByComparator<CustUploads> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cust uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cust uploadses
	 * @param end the upper bound of the range of cust uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cust uploadses
	 */
	public static List<CustUploads> findAll(
		int start, int end, OrderByComparator<CustUploads> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cust uploadses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cust uploadses.
	 *
	 * @return the number of cust uploadses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CustUploadsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CustUploadsPersistence, CustUploadsPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CustUploadsPersistence.class);

		ServiceTracker<CustUploadsPersistence, CustUploadsPersistence>
			serviceTracker =
				new ServiceTracker
					<CustUploadsPersistence, CustUploadsPersistence>(
						bundle.getBundleContext(), CustUploadsPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}