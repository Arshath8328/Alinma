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

import com.ejada.atmc.acl.db.model.CLMNajmUploads;

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
 * The persistence utility for the clm najm uploads service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.CLMNajmUploadsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CLMNajmUploadsPersistence
 * @generated
 */
public class CLMNajmUploadsUtil {

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
	public static void clearCache(CLMNajmUploads clmNajmUploads) {
		getPersistence().clearCache(clmNajmUploads);
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
	public static Map<Serializable, CLMNajmUploads> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CLMNajmUploads> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CLMNajmUploads> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CLMNajmUploads> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CLMNajmUploads> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CLMNajmUploads update(CLMNajmUploads clmNajmUploads) {
		return getPersistence().update(clmNajmUploads);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CLMNajmUploads update(
		CLMNajmUploads clmNajmUploads, ServiceContext serviceContext) {

		return getPersistence().update(clmNajmUploads, serviceContext);
	}

	/**
	 * Returns the clm najm uploads where claimRefNo = &#63; or throws a <code>NoSuchCLMNajmUploadsException</code> if it could not be found.
	 *
	 * @param claimRefNo the claim ref no
	 * @return the matching clm najm uploads
	 * @throws NoSuchCLMNajmUploadsException if a matching clm najm uploads could not be found
	 */
	public static CLMNajmUploads findByClaimRefNo(String claimRefNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmUploadsException {

		return getPersistence().findByClaimRefNo(claimRefNo);
	}

	/**
	 * Returns the clm najm uploads where claimRefNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param claimRefNo the claim ref no
	 * @return the matching clm najm uploads, or <code>null</code> if a matching clm najm uploads could not be found
	 */
	public static CLMNajmUploads fetchByClaimRefNo(String claimRefNo) {
		return getPersistence().fetchByClaimRefNo(claimRefNo);
	}

	/**
	 * Returns the clm najm uploads where claimRefNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param claimRefNo the claim ref no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching clm najm uploads, or <code>null</code> if a matching clm najm uploads could not be found
	 */
	public static CLMNajmUploads fetchByClaimRefNo(
		String claimRefNo, boolean useFinderCache) {

		return getPersistence().fetchByClaimRefNo(claimRefNo, useFinderCache);
	}

	/**
	 * Removes the clm najm uploads where claimRefNo = &#63; from the database.
	 *
	 * @param claimRefNo the claim ref no
	 * @return the clm najm uploads that was removed
	 */
	public static CLMNajmUploads removeByClaimRefNo(String claimRefNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmUploadsException {

		return getPersistence().removeByClaimRefNo(claimRefNo);
	}

	/**
	 * Returns the number of clm najm uploadses where claimRefNo = &#63;.
	 *
	 * @param claimRefNo the claim ref no
	 * @return the number of matching clm najm uploadses
	 */
	public static int countByClaimRefNo(String claimRefNo) {
		return getPersistence().countByClaimRefNo(claimRefNo);
	}

	/**
	 * Caches the clm najm uploads in the entity cache if it is enabled.
	 *
	 * @param clmNajmUploads the clm najm uploads
	 */
	public static void cacheResult(CLMNajmUploads clmNajmUploads) {
		getPersistence().cacheResult(clmNajmUploads);
	}

	/**
	 * Caches the clm najm uploadses in the entity cache if it is enabled.
	 *
	 * @param clmNajmUploadses the clm najm uploadses
	 */
	public static void cacheResult(List<CLMNajmUploads> clmNajmUploadses) {
		getPersistence().cacheResult(clmNajmUploadses);
	}

	/**
	 * Creates a new clm najm uploads with the primary key. Does not add the clm najm uploads to the database.
	 *
	 * @param id the primary key for the new clm najm uploads
	 * @return the new clm najm uploads
	 */
	public static CLMNajmUploads create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the clm najm uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the clm najm uploads
	 * @return the clm najm uploads that was removed
	 * @throws NoSuchCLMNajmUploadsException if a clm najm uploads with the primary key could not be found
	 */
	public static CLMNajmUploads remove(int id)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmUploadsException {

		return getPersistence().remove(id);
	}

	public static CLMNajmUploads updateImpl(CLMNajmUploads clmNajmUploads) {
		return getPersistence().updateImpl(clmNajmUploads);
	}

	/**
	 * Returns the clm najm uploads with the primary key or throws a <code>NoSuchCLMNajmUploadsException</code> if it could not be found.
	 *
	 * @param id the primary key of the clm najm uploads
	 * @return the clm najm uploads
	 * @throws NoSuchCLMNajmUploadsException if a clm najm uploads with the primary key could not be found
	 */
	public static CLMNajmUploads findByPrimaryKey(int id)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmUploadsException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the clm najm uploads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the clm najm uploads
	 * @return the clm najm uploads, or <code>null</code> if a clm najm uploads with the primary key could not be found
	 */
	public static CLMNajmUploads fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the clm najm uploadses.
	 *
	 * @return the clm najm uploadses
	 */
	public static List<CLMNajmUploads> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the clm najm uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clm najm uploadses
	 * @param end the upper bound of the range of clm najm uploadses (not inclusive)
	 * @return the range of clm najm uploadses
	 */
	public static List<CLMNajmUploads> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the clm najm uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clm najm uploadses
	 * @param end the upper bound of the range of clm najm uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clm najm uploadses
	 */
	public static List<CLMNajmUploads> findAll(
		int start, int end,
		OrderByComparator<CLMNajmUploads> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the clm najm uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clm najm uploadses
	 * @param end the upper bound of the range of clm najm uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of clm najm uploadses
	 */
	public static List<CLMNajmUploads> findAll(
		int start, int end, OrderByComparator<CLMNajmUploads> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the clm najm uploadses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of clm najm uploadses.
	 *
	 * @return the number of clm najm uploadses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CLMNajmUploadsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CLMNajmUploadsPersistence, CLMNajmUploadsPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CLMNajmUploadsPersistence.class);

		ServiceTracker<CLMNajmUploadsPersistence, CLMNajmUploadsPersistence>
			serviceTracker =
				new ServiceTracker
					<CLMNajmUploadsPersistence, CLMNajmUploadsPersistence>(
						bundle.getBundleContext(),
						CLMNajmUploadsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}