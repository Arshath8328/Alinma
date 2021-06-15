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

import com.ejada.atmc.acl.db.model.ClaimAdminUploads;

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
 * The persistence utility for the claim admin uploads service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.ClaimAdminUploadsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimAdminUploadsPersistence
 * @generated
 */
public class ClaimAdminUploadsUtil {

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
	public static void clearCache(ClaimAdminUploads claimAdminUploads) {
		getPersistence().clearCache(claimAdminUploads);
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
	public static Map<Serializable, ClaimAdminUploads> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ClaimAdminUploads> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ClaimAdminUploads> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ClaimAdminUploads> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ClaimAdminUploads> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ClaimAdminUploads update(
		ClaimAdminUploads claimAdminUploads) {

		return getPersistence().update(claimAdminUploads);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ClaimAdminUploads update(
		ClaimAdminUploads claimAdminUploads, ServiceContext serviceContext) {

		return getPersistence().update(claimAdminUploads, serviceContext);
	}

	/**
	 * Returns all the claim admin uploadses where refNo = &#63;.
	 *
	 * @param refNo the ref no
	 * @return the matching claim admin uploadses
	 */
	public static List<ClaimAdminUploads> findByrefNo(String refNo) {
		return getPersistence().findByrefNo(refNo);
	}

	/**
	 * Returns a range of all the claim admin uploadses where refNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param refNo the ref no
	 * @param start the lower bound of the range of claim admin uploadses
	 * @param end the upper bound of the range of claim admin uploadses (not inclusive)
	 * @return the range of matching claim admin uploadses
	 */
	public static List<ClaimAdminUploads> findByrefNo(
		String refNo, int start, int end) {

		return getPersistence().findByrefNo(refNo, start, end);
	}

	/**
	 * Returns an ordered range of all the claim admin uploadses where refNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param refNo the ref no
	 * @param start the lower bound of the range of claim admin uploadses
	 * @param end the upper bound of the range of claim admin uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim admin uploadses
	 */
	public static List<ClaimAdminUploads> findByrefNo(
		String refNo, int start, int end,
		OrderByComparator<ClaimAdminUploads> orderByComparator) {

		return getPersistence().findByrefNo(
			refNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the claim admin uploadses where refNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param refNo the ref no
	 * @param start the lower bound of the range of claim admin uploadses
	 * @param end the upper bound of the range of claim admin uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim admin uploadses
	 */
	public static List<ClaimAdminUploads> findByrefNo(
		String refNo, int start, int end,
		OrderByComparator<ClaimAdminUploads> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByrefNo(
			refNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first claim admin uploads in the ordered set where refNo = &#63;.
	 *
	 * @param refNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim admin uploads
	 * @throws NoSuchClaimAdminUploadsException if a matching claim admin uploads could not be found
	 */
	public static ClaimAdminUploads findByrefNo_First(
			String refNo,
			OrderByComparator<ClaimAdminUploads> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchClaimAdminUploadsException {

		return getPersistence().findByrefNo_First(refNo, orderByComparator);
	}

	/**
	 * Returns the first claim admin uploads in the ordered set where refNo = &#63;.
	 *
	 * @param refNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim admin uploads, or <code>null</code> if a matching claim admin uploads could not be found
	 */
	public static ClaimAdminUploads fetchByrefNo_First(
		String refNo, OrderByComparator<ClaimAdminUploads> orderByComparator) {

		return getPersistence().fetchByrefNo_First(refNo, orderByComparator);
	}

	/**
	 * Returns the last claim admin uploads in the ordered set where refNo = &#63;.
	 *
	 * @param refNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim admin uploads
	 * @throws NoSuchClaimAdminUploadsException if a matching claim admin uploads could not be found
	 */
	public static ClaimAdminUploads findByrefNo_Last(
			String refNo,
			OrderByComparator<ClaimAdminUploads> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchClaimAdminUploadsException {

		return getPersistence().findByrefNo_Last(refNo, orderByComparator);
	}

	/**
	 * Returns the last claim admin uploads in the ordered set where refNo = &#63;.
	 *
	 * @param refNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim admin uploads, or <code>null</code> if a matching claim admin uploads could not be found
	 */
	public static ClaimAdminUploads fetchByrefNo_Last(
		String refNo, OrderByComparator<ClaimAdminUploads> orderByComparator) {

		return getPersistence().fetchByrefNo_Last(refNo, orderByComparator);
	}

	/**
	 * Returns the claim admin uploadses before and after the current claim admin uploads in the ordered set where refNo = &#63;.
	 *
	 * @param id the primary key of the current claim admin uploads
	 * @param refNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim admin uploads
	 * @throws NoSuchClaimAdminUploadsException if a claim admin uploads with the primary key could not be found
	 */
	public static ClaimAdminUploads[] findByrefNo_PrevAndNext(
			int id, String refNo,
			OrderByComparator<ClaimAdminUploads> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchClaimAdminUploadsException {

		return getPersistence().findByrefNo_PrevAndNext(
			id, refNo, orderByComparator);
	}

	/**
	 * Removes all the claim admin uploadses where refNo = &#63; from the database.
	 *
	 * @param refNo the ref no
	 */
	public static void removeByrefNo(String refNo) {
		getPersistence().removeByrefNo(refNo);
	}

	/**
	 * Returns the number of claim admin uploadses where refNo = &#63;.
	 *
	 * @param refNo the ref no
	 * @return the number of matching claim admin uploadses
	 */
	public static int countByrefNo(String refNo) {
		return getPersistence().countByrefNo(refNo);
	}

	/**
	 * Caches the claim admin uploads in the entity cache if it is enabled.
	 *
	 * @param claimAdminUploads the claim admin uploads
	 */
	public static void cacheResult(ClaimAdminUploads claimAdminUploads) {
		getPersistence().cacheResult(claimAdminUploads);
	}

	/**
	 * Caches the claim admin uploadses in the entity cache if it is enabled.
	 *
	 * @param claimAdminUploadses the claim admin uploadses
	 */
	public static void cacheResult(
		List<ClaimAdminUploads> claimAdminUploadses) {

		getPersistence().cacheResult(claimAdminUploadses);
	}

	/**
	 * Creates a new claim admin uploads with the primary key. Does not add the claim admin uploads to the database.
	 *
	 * @param id the primary key for the new claim admin uploads
	 * @return the new claim admin uploads
	 */
	public static ClaimAdminUploads create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the claim admin uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the claim admin uploads
	 * @return the claim admin uploads that was removed
	 * @throws NoSuchClaimAdminUploadsException if a claim admin uploads with the primary key could not be found
	 */
	public static ClaimAdminUploads remove(int id)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchClaimAdminUploadsException {

		return getPersistence().remove(id);
	}

	public static ClaimAdminUploads updateImpl(
		ClaimAdminUploads claimAdminUploads) {

		return getPersistence().updateImpl(claimAdminUploads);
	}

	/**
	 * Returns the claim admin uploads with the primary key or throws a <code>NoSuchClaimAdminUploadsException</code> if it could not be found.
	 *
	 * @param id the primary key of the claim admin uploads
	 * @return the claim admin uploads
	 * @throws NoSuchClaimAdminUploadsException if a claim admin uploads with the primary key could not be found
	 */
	public static ClaimAdminUploads findByPrimaryKey(int id)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchClaimAdminUploadsException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the claim admin uploads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the claim admin uploads
	 * @return the claim admin uploads, or <code>null</code> if a claim admin uploads with the primary key could not be found
	 */
	public static ClaimAdminUploads fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the claim admin uploadses.
	 *
	 * @return the claim admin uploadses
	 */
	public static List<ClaimAdminUploads> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the claim admin uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim admin uploadses
	 * @param end the upper bound of the range of claim admin uploadses (not inclusive)
	 * @return the range of claim admin uploadses
	 */
	public static List<ClaimAdminUploads> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the claim admin uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim admin uploadses
	 * @param end the upper bound of the range of claim admin uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of claim admin uploadses
	 */
	public static List<ClaimAdminUploads> findAll(
		int start, int end,
		OrderByComparator<ClaimAdminUploads> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the claim admin uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim admin uploadses
	 * @param end the upper bound of the range of claim admin uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of claim admin uploadses
	 */
	public static List<ClaimAdminUploads> findAll(
		int start, int end,
		OrderByComparator<ClaimAdminUploads> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the claim admin uploadses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of claim admin uploadses.
	 *
	 * @return the number of claim admin uploadses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ClaimAdminUploadsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ClaimAdminUploadsPersistence, ClaimAdminUploadsPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ClaimAdminUploadsPersistence.class);

		ServiceTracker
			<ClaimAdminUploadsPersistence, ClaimAdminUploadsPersistence>
				serviceTracker =
					new ServiceTracker
						<ClaimAdminUploadsPersistence,
						 ClaimAdminUploadsPersistence>(
							 bundle.getBundleContext(),
							 ClaimAdminUploadsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}