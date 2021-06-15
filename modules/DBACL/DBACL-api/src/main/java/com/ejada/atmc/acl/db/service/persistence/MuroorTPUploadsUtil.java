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

import com.ejada.atmc.acl.db.model.MuroorTPUploads;

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
 * The persistence utility for the muroor tp uploads service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.MuroorTPUploadsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MuroorTPUploadsPersistence
 * @generated
 */
public class MuroorTPUploadsUtil {

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
	public static void clearCache(MuroorTPUploads muroorTPUploads) {
		getPersistence().clearCache(muroorTPUploads);
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
	public static Map<Serializable, MuroorTPUploads> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MuroorTPUploads> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MuroorTPUploads> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MuroorTPUploads> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MuroorTPUploads> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MuroorTPUploads update(MuroorTPUploads muroorTPUploads) {
		return getPersistence().update(muroorTPUploads);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MuroorTPUploads update(
		MuroorTPUploads muroorTPUploads, ServiceContext serviceContext) {

		return getPersistence().update(muroorTPUploads, serviceContext);
	}

	/**
	 * Returns the muroor tp uploads where claimIntimationNo = &#63; or throws a <code>NoSuchMuroorTPUploadsException</code> if it could not be found.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the matching muroor tp uploads
	 * @throws NoSuchMuroorTPUploadsException if a matching muroor tp uploads could not be found
	 */
	public static MuroorTPUploads findByclaimIntimationNo(
			String claimIntimationNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchMuroorTPUploadsException {

		return getPersistence().findByclaimIntimationNo(claimIntimationNo);
	}

	/**
	 * Returns the muroor tp uploads where claimIntimationNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the matching muroor tp uploads, or <code>null</code> if a matching muroor tp uploads could not be found
	 */
	public static MuroorTPUploads fetchByclaimIntimationNo(
		String claimIntimationNo) {

		return getPersistence().fetchByclaimIntimationNo(claimIntimationNo);
	}

	/**
	 * Returns the muroor tp uploads where claimIntimationNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching muroor tp uploads, or <code>null</code> if a matching muroor tp uploads could not be found
	 */
	public static MuroorTPUploads fetchByclaimIntimationNo(
		String claimIntimationNo, boolean useFinderCache) {

		return getPersistence().fetchByclaimIntimationNo(
			claimIntimationNo, useFinderCache);
	}

	/**
	 * Removes the muroor tp uploads where claimIntimationNo = &#63; from the database.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the muroor tp uploads that was removed
	 */
	public static MuroorTPUploads removeByclaimIntimationNo(
			String claimIntimationNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchMuroorTPUploadsException {

		return getPersistence().removeByclaimIntimationNo(claimIntimationNo);
	}

	/**
	 * Returns the number of muroor tp uploadses where claimIntimationNo = &#63;.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the number of matching muroor tp uploadses
	 */
	public static int countByclaimIntimationNo(String claimIntimationNo) {
		return getPersistence().countByclaimIntimationNo(claimIntimationNo);
	}

	/**
	 * Caches the muroor tp uploads in the entity cache if it is enabled.
	 *
	 * @param muroorTPUploads the muroor tp uploads
	 */
	public static void cacheResult(MuroorTPUploads muroorTPUploads) {
		getPersistence().cacheResult(muroorTPUploads);
	}

	/**
	 * Caches the muroor tp uploadses in the entity cache if it is enabled.
	 *
	 * @param muroorTPUploadses the muroor tp uploadses
	 */
	public static void cacheResult(List<MuroorTPUploads> muroorTPUploadses) {
		getPersistence().cacheResult(muroorTPUploadses);
	}

	/**
	 * Creates a new muroor tp uploads with the primary key. Does not add the muroor tp uploads to the database.
	 *
	 * @param id the primary key for the new muroor tp uploads
	 * @return the new muroor tp uploads
	 */
	public static MuroorTPUploads create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the muroor tp uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the muroor tp uploads
	 * @return the muroor tp uploads that was removed
	 * @throws NoSuchMuroorTPUploadsException if a muroor tp uploads with the primary key could not be found
	 */
	public static MuroorTPUploads remove(int id)
		throws com.ejada.atmc.acl.db.exception.NoSuchMuroorTPUploadsException {

		return getPersistence().remove(id);
	}

	public static MuroorTPUploads updateImpl(MuroorTPUploads muroorTPUploads) {
		return getPersistence().updateImpl(muroorTPUploads);
	}

	/**
	 * Returns the muroor tp uploads with the primary key or throws a <code>NoSuchMuroorTPUploadsException</code> if it could not be found.
	 *
	 * @param id the primary key of the muroor tp uploads
	 * @return the muroor tp uploads
	 * @throws NoSuchMuroorTPUploadsException if a muroor tp uploads with the primary key could not be found
	 */
	public static MuroorTPUploads findByPrimaryKey(int id)
		throws com.ejada.atmc.acl.db.exception.NoSuchMuroorTPUploadsException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the muroor tp uploads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the muroor tp uploads
	 * @return the muroor tp uploads, or <code>null</code> if a muroor tp uploads with the primary key could not be found
	 */
	public static MuroorTPUploads fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the muroor tp uploadses.
	 *
	 * @return the muroor tp uploadses
	 */
	public static List<MuroorTPUploads> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the muroor tp uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MuroorTPUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of muroor tp uploadses
	 * @param end the upper bound of the range of muroor tp uploadses (not inclusive)
	 * @return the range of muroor tp uploadses
	 */
	public static List<MuroorTPUploads> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the muroor tp uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MuroorTPUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of muroor tp uploadses
	 * @param end the upper bound of the range of muroor tp uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of muroor tp uploadses
	 */
	public static List<MuroorTPUploads> findAll(
		int start, int end,
		OrderByComparator<MuroorTPUploads> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the muroor tp uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MuroorTPUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of muroor tp uploadses
	 * @param end the upper bound of the range of muroor tp uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of muroor tp uploadses
	 */
	public static List<MuroorTPUploads> findAll(
		int start, int end,
		OrderByComparator<MuroorTPUploads> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the muroor tp uploadses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of muroor tp uploadses.
	 *
	 * @return the number of muroor tp uploadses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MuroorTPUploadsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MuroorTPUploadsPersistence, MuroorTPUploadsPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			MuroorTPUploadsPersistence.class);

		ServiceTracker<MuroorTPUploadsPersistence, MuroorTPUploadsPersistence>
			serviceTracker =
				new ServiceTracker
					<MuroorTPUploadsPersistence, MuroorTPUploadsPersistence>(
						bundle.getBundleContext(),
						MuroorTPUploadsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}