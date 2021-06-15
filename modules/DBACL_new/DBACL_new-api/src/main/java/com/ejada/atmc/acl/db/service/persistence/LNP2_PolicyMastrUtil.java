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

import com.ejada.atmc.acl.db.model.LNP2_PolicyMastr;

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
 * The persistence utility for the lnp2_ policy mastr service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.LNP2_PolicyMastrPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LNP2_PolicyMastrPersistence
 * @generated
 */
public class LNP2_PolicyMastrUtil {

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
	public static void clearCache(LNP2_PolicyMastr lnp2_PolicyMastr) {
		getPersistence().clearCache(lnp2_PolicyMastr);
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
	public static Map<Serializable, LNP2_PolicyMastr> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LNP2_PolicyMastr> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LNP2_PolicyMastr> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LNP2_PolicyMastr> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LNP2_PolicyMastr> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LNP2_PolicyMastr update(LNP2_PolicyMastr lnp2_PolicyMastr) {
		return getPersistence().update(lnp2_PolicyMastr);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LNP2_PolicyMastr update(
		LNP2_PolicyMastr lnp2_PolicyMastr, ServiceContext serviceContext) {

		return getPersistence().update(lnp2_PolicyMastr, serviceContext);
	}

	/**
	 * Returns the lnp2_ policy mastr where np1_proposal = &#63; or throws a <code>NoSuchLNP2_PolicyMastrException</code> if it could not be found.
	 *
	 * @param np1_proposal the np1_proposal
	 * @return the matching lnp2_ policy mastr
	 * @throws NoSuchLNP2_PolicyMastrException if a matching lnp2_ policy mastr could not be found
	 */
	public static LNP2_PolicyMastr findBynp1_proposal(String np1_proposal)
		throws com.ejada.atmc.acl.db.exception.NoSuchLNP2_PolicyMastrException {

		return getPersistence().findBynp1_proposal(np1_proposal);
	}

	/**
	 * Returns the lnp2_ policy mastr where np1_proposal = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param np1_proposal the np1_proposal
	 * @return the matching lnp2_ policy mastr, or <code>null</code> if a matching lnp2_ policy mastr could not be found
	 */
	public static LNP2_PolicyMastr fetchBynp1_proposal(String np1_proposal) {
		return getPersistence().fetchBynp1_proposal(np1_proposal);
	}

	/**
	 * Returns the lnp2_ policy mastr where np1_proposal = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param np1_proposal the np1_proposal
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching lnp2_ policy mastr, or <code>null</code> if a matching lnp2_ policy mastr could not be found
	 */
	public static LNP2_PolicyMastr fetchBynp1_proposal(
		String np1_proposal, boolean useFinderCache) {

		return getPersistence().fetchBynp1_proposal(
			np1_proposal, useFinderCache);
	}

	/**
	 * Removes the lnp2_ policy mastr where np1_proposal = &#63; from the database.
	 *
	 * @param np1_proposal the np1_proposal
	 * @return the lnp2_ policy mastr that was removed
	 */
	public static LNP2_PolicyMastr removeBynp1_proposal(String np1_proposal)
		throws com.ejada.atmc.acl.db.exception.NoSuchLNP2_PolicyMastrException {

		return getPersistence().removeBynp1_proposal(np1_proposal);
	}

	/**
	 * Returns the number of lnp2_ policy mastrs where np1_proposal = &#63;.
	 *
	 * @param np1_proposal the np1_proposal
	 * @return the number of matching lnp2_ policy mastrs
	 */
	public static int countBynp1_proposal(String np1_proposal) {
		return getPersistence().countBynp1_proposal(np1_proposal);
	}

	/**
	 * Caches the lnp2_ policy mastr in the entity cache if it is enabled.
	 *
	 * @param lnp2_PolicyMastr the lnp2_ policy mastr
	 */
	public static void cacheResult(LNP2_PolicyMastr lnp2_PolicyMastr) {
		getPersistence().cacheResult(lnp2_PolicyMastr);
	}

	/**
	 * Caches the lnp2_ policy mastrs in the entity cache if it is enabled.
	 *
	 * @param lnp2_PolicyMastrs the lnp2_ policy mastrs
	 */
	public static void cacheResult(List<LNP2_PolicyMastr> lnp2_PolicyMastrs) {
		getPersistence().cacheResult(lnp2_PolicyMastrs);
	}

	/**
	 * Creates a new lnp2_ policy mastr with the primary key. Does not add the lnp2_ policy mastr to the database.
	 *
	 * @param np1_proposal the primary key for the new lnp2_ policy mastr
	 * @return the new lnp2_ policy mastr
	 */
	public static LNP2_PolicyMastr create(String np1_proposal) {
		return getPersistence().create(np1_proposal);
	}

	/**
	 * Removes the lnp2_ policy mastr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param np1_proposal the primary key of the lnp2_ policy mastr
	 * @return the lnp2_ policy mastr that was removed
	 * @throws NoSuchLNP2_PolicyMastrException if a lnp2_ policy mastr with the primary key could not be found
	 */
	public static LNP2_PolicyMastr remove(String np1_proposal)
		throws com.ejada.atmc.acl.db.exception.NoSuchLNP2_PolicyMastrException {

		return getPersistence().remove(np1_proposal);
	}

	public static LNP2_PolicyMastr updateImpl(
		LNP2_PolicyMastr lnp2_PolicyMastr) {

		return getPersistence().updateImpl(lnp2_PolicyMastr);
	}

	/**
	 * Returns the lnp2_ policy mastr with the primary key or throws a <code>NoSuchLNP2_PolicyMastrException</code> if it could not be found.
	 *
	 * @param np1_proposal the primary key of the lnp2_ policy mastr
	 * @return the lnp2_ policy mastr
	 * @throws NoSuchLNP2_PolicyMastrException if a lnp2_ policy mastr with the primary key could not be found
	 */
	public static LNP2_PolicyMastr findByPrimaryKey(String np1_proposal)
		throws com.ejada.atmc.acl.db.exception.NoSuchLNP2_PolicyMastrException {

		return getPersistence().findByPrimaryKey(np1_proposal);
	}

	/**
	 * Returns the lnp2_ policy mastr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param np1_proposal the primary key of the lnp2_ policy mastr
	 * @return the lnp2_ policy mastr, or <code>null</code> if a lnp2_ policy mastr with the primary key could not be found
	 */
	public static LNP2_PolicyMastr fetchByPrimaryKey(String np1_proposal) {
		return getPersistence().fetchByPrimaryKey(np1_proposal);
	}

	/**
	 * Returns all the lnp2_ policy mastrs.
	 *
	 * @return the lnp2_ policy mastrs
	 */
	public static List<LNP2_PolicyMastr> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the lnp2_ policy mastrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LNP2_PolicyMastrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lnp2_ policy mastrs
	 * @param end the upper bound of the range of lnp2_ policy mastrs (not inclusive)
	 * @return the range of lnp2_ policy mastrs
	 */
	public static List<LNP2_PolicyMastr> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the lnp2_ policy mastrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LNP2_PolicyMastrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lnp2_ policy mastrs
	 * @param end the upper bound of the range of lnp2_ policy mastrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lnp2_ policy mastrs
	 */
	public static List<LNP2_PolicyMastr> findAll(
		int start, int end,
		OrderByComparator<LNP2_PolicyMastr> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lnp2_ policy mastrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LNP2_PolicyMastrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lnp2_ policy mastrs
	 * @param end the upper bound of the range of lnp2_ policy mastrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lnp2_ policy mastrs
	 */
	public static List<LNP2_PolicyMastr> findAll(
		int start, int end,
		OrderByComparator<LNP2_PolicyMastr> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the lnp2_ policy mastrs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of lnp2_ policy mastrs.
	 *
	 * @return the number of lnp2_ policy mastrs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LNP2_PolicyMastrPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LNP2_PolicyMastrPersistence, LNP2_PolicyMastrPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			LNP2_PolicyMastrPersistence.class);

		ServiceTracker<LNP2_PolicyMastrPersistence, LNP2_PolicyMastrPersistence>
			serviceTracker =
				new ServiceTracker
					<LNP2_PolicyMastrPersistence, LNP2_PolicyMastrPersistence>(
						bundle.getBundleContext(),
						LNP2_PolicyMastrPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}