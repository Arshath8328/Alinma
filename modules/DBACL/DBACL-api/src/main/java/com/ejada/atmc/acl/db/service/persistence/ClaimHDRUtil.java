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

import com.ejada.atmc.acl.db.model.ClaimHDR;

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
 * The persistence utility for the claim hdr service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.ClaimHDRPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimHDRPersistence
 * @generated
 */
public class ClaimHDRUtil {

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
	public static void clearCache(ClaimHDR claimHDR) {
		getPersistence().clearCache(claimHDR);
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
	public static Map<Serializable, ClaimHDR> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ClaimHDR> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ClaimHDR> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ClaimHDR> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ClaimHDR> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ClaimHDR update(ClaimHDR claimHDR) {
		return getPersistence().update(claimHDR);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ClaimHDR update(
		ClaimHDR claimHDR, ServiceContext serviceContext) {

		return getPersistence().update(claimHDR, serviceContext);
	}

	/**
	 * Returns all the claim hdrs where iqamaId = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @return the matching claim hdrs
	 */
	public static List<ClaimHDR> findByIqamaId(String iqamaId) {
		return getPersistence().findByIqamaId(iqamaId);
	}

	/**
	 * Returns a range of all the claim hdrs where iqamaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param iqamaId the iqama ID
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @return the range of matching claim hdrs
	 */
	public static List<ClaimHDR> findByIqamaId(
		String iqamaId, int start, int end) {

		return getPersistence().findByIqamaId(iqamaId, start, end);
	}

	/**
	 * Returns an ordered range of all the claim hdrs where iqamaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param iqamaId the iqama ID
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim hdrs
	 */
	public static List<ClaimHDR> findByIqamaId(
		String iqamaId, int start, int end,
		OrderByComparator<ClaimHDR> orderByComparator) {

		return getPersistence().findByIqamaId(
			iqamaId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the claim hdrs where iqamaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param iqamaId the iqama ID
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim hdrs
	 */
	public static List<ClaimHDR> findByIqamaId(
		String iqamaId, int start, int end,
		OrderByComparator<ClaimHDR> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByIqamaId(
			iqamaId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first claim hdr in the ordered set where iqamaId = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim hdr
	 * @throws NoSuchClaimHDRException if a matching claim hdr could not be found
	 */
	public static ClaimHDR findByIqamaId_First(
			String iqamaId, OrderByComparator<ClaimHDR> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchClaimHDRException {

		return getPersistence().findByIqamaId_First(iqamaId, orderByComparator);
	}

	/**
	 * Returns the first claim hdr in the ordered set where iqamaId = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim hdr, or <code>null</code> if a matching claim hdr could not be found
	 */
	public static ClaimHDR fetchByIqamaId_First(
		String iqamaId, OrderByComparator<ClaimHDR> orderByComparator) {

		return getPersistence().fetchByIqamaId_First(
			iqamaId, orderByComparator);
	}

	/**
	 * Returns the last claim hdr in the ordered set where iqamaId = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim hdr
	 * @throws NoSuchClaimHDRException if a matching claim hdr could not be found
	 */
	public static ClaimHDR findByIqamaId_Last(
			String iqamaId, OrderByComparator<ClaimHDR> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchClaimHDRException {

		return getPersistence().findByIqamaId_Last(iqamaId, orderByComparator);
	}

	/**
	 * Returns the last claim hdr in the ordered set where iqamaId = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim hdr, or <code>null</code> if a matching claim hdr could not be found
	 */
	public static ClaimHDR fetchByIqamaId_Last(
		String iqamaId, OrderByComparator<ClaimHDR> orderByComparator) {

		return getPersistence().fetchByIqamaId_Last(iqamaId, orderByComparator);
	}

	/**
	 * Returns the claim hdrs before and after the current claim hdr in the ordered set where iqamaId = &#63;.
	 *
	 * @param claimHDRPK the primary key of the current claim hdr
	 * @param iqamaId the iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim hdr
	 * @throws NoSuchClaimHDRException if a claim hdr with the primary key could not be found
	 */
	public static ClaimHDR[] findByIqamaId_PrevAndNext(
			ClaimHDRPK claimHDRPK, String iqamaId,
			OrderByComparator<ClaimHDR> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchClaimHDRException {

		return getPersistence().findByIqamaId_PrevAndNext(
			claimHDRPK, iqamaId, orderByComparator);
	}

	/**
	 * Removes all the claim hdrs where iqamaId = &#63; from the database.
	 *
	 * @param iqamaId the iqama ID
	 */
	public static void removeByIqamaId(String iqamaId) {
		getPersistence().removeByIqamaId(iqamaId);
	}

	/**
	 * Returns the number of claim hdrs where iqamaId = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @return the number of matching claim hdrs
	 */
	public static int countByIqamaId(String iqamaId) {
		return getPersistence().countByIqamaId(iqamaId);
	}

	/**
	 * Returns all the claim hdrs where claimNo = &#63;.
	 *
	 * @param claimNo the claim no
	 * @return the matching claim hdrs
	 */
	public static List<ClaimHDR> findByclaimNo(String claimNo) {
		return getPersistence().findByclaimNo(claimNo);
	}

	/**
	 * Returns a range of all the claim hdrs where claimNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param claimNo the claim no
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @return the range of matching claim hdrs
	 */
	public static List<ClaimHDR> findByclaimNo(
		String claimNo, int start, int end) {

		return getPersistence().findByclaimNo(claimNo, start, end);
	}

	/**
	 * Returns an ordered range of all the claim hdrs where claimNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param claimNo the claim no
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim hdrs
	 */
	public static List<ClaimHDR> findByclaimNo(
		String claimNo, int start, int end,
		OrderByComparator<ClaimHDR> orderByComparator) {

		return getPersistence().findByclaimNo(
			claimNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the claim hdrs where claimNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param claimNo the claim no
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim hdrs
	 */
	public static List<ClaimHDR> findByclaimNo(
		String claimNo, int start, int end,
		OrderByComparator<ClaimHDR> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByclaimNo(
			claimNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first claim hdr in the ordered set where claimNo = &#63;.
	 *
	 * @param claimNo the claim no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim hdr
	 * @throws NoSuchClaimHDRException if a matching claim hdr could not be found
	 */
	public static ClaimHDR findByclaimNo_First(
			String claimNo, OrderByComparator<ClaimHDR> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchClaimHDRException {

		return getPersistence().findByclaimNo_First(claimNo, orderByComparator);
	}

	/**
	 * Returns the first claim hdr in the ordered set where claimNo = &#63;.
	 *
	 * @param claimNo the claim no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim hdr, or <code>null</code> if a matching claim hdr could not be found
	 */
	public static ClaimHDR fetchByclaimNo_First(
		String claimNo, OrderByComparator<ClaimHDR> orderByComparator) {

		return getPersistence().fetchByclaimNo_First(
			claimNo, orderByComparator);
	}

	/**
	 * Returns the last claim hdr in the ordered set where claimNo = &#63;.
	 *
	 * @param claimNo the claim no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim hdr
	 * @throws NoSuchClaimHDRException if a matching claim hdr could not be found
	 */
	public static ClaimHDR findByclaimNo_Last(
			String claimNo, OrderByComparator<ClaimHDR> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchClaimHDRException {

		return getPersistence().findByclaimNo_Last(claimNo, orderByComparator);
	}

	/**
	 * Returns the last claim hdr in the ordered set where claimNo = &#63;.
	 *
	 * @param claimNo the claim no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim hdr, or <code>null</code> if a matching claim hdr could not be found
	 */
	public static ClaimHDR fetchByclaimNo_Last(
		String claimNo, OrderByComparator<ClaimHDR> orderByComparator) {

		return getPersistence().fetchByclaimNo_Last(claimNo, orderByComparator);
	}

	/**
	 * Returns the claim hdrs before and after the current claim hdr in the ordered set where claimNo = &#63;.
	 *
	 * @param claimHDRPK the primary key of the current claim hdr
	 * @param claimNo the claim no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim hdr
	 * @throws NoSuchClaimHDRException if a claim hdr with the primary key could not be found
	 */
	public static ClaimHDR[] findByclaimNo_PrevAndNext(
			ClaimHDRPK claimHDRPK, String claimNo,
			OrderByComparator<ClaimHDR> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchClaimHDRException {

		return getPersistence().findByclaimNo_PrevAndNext(
			claimHDRPK, claimNo, orderByComparator);
	}

	/**
	 * Removes all the claim hdrs where claimNo = &#63; from the database.
	 *
	 * @param claimNo the claim no
	 */
	public static void removeByclaimNo(String claimNo) {
		getPersistence().removeByclaimNo(claimNo);
	}

	/**
	 * Returns the number of claim hdrs where claimNo = &#63;.
	 *
	 * @param claimNo the claim no
	 * @return the number of matching claim hdrs
	 */
	public static int countByclaimNo(String claimNo) {
		return getPersistence().countByclaimNo(claimNo);
	}

	/**
	 * Caches the claim hdr in the entity cache if it is enabled.
	 *
	 * @param claimHDR the claim hdr
	 */
	public static void cacheResult(ClaimHDR claimHDR) {
		getPersistence().cacheResult(claimHDR);
	}

	/**
	 * Caches the claim hdrs in the entity cache if it is enabled.
	 *
	 * @param claimHDRs the claim hdrs
	 */
	public static void cacheResult(List<ClaimHDR> claimHDRs) {
		getPersistence().cacheResult(claimHDRs);
	}

	/**
	 * Creates a new claim hdr with the primary key. Does not add the claim hdr to the database.
	 *
	 * @param claimHDRPK the primary key for the new claim hdr
	 * @return the new claim hdr
	 */
	public static ClaimHDR create(ClaimHDRPK claimHDRPK) {
		return getPersistence().create(claimHDRPK);
	}

	/**
	 * Removes the claim hdr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimHDRPK the primary key of the claim hdr
	 * @return the claim hdr that was removed
	 * @throws NoSuchClaimHDRException if a claim hdr with the primary key could not be found
	 */
	public static ClaimHDR remove(ClaimHDRPK claimHDRPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchClaimHDRException {

		return getPersistence().remove(claimHDRPK);
	}

	public static ClaimHDR updateImpl(ClaimHDR claimHDR) {
		return getPersistence().updateImpl(claimHDR);
	}

	/**
	 * Returns the claim hdr with the primary key or throws a <code>NoSuchClaimHDRException</code> if it could not be found.
	 *
	 * @param claimHDRPK the primary key of the claim hdr
	 * @return the claim hdr
	 * @throws NoSuchClaimHDRException if a claim hdr with the primary key could not be found
	 */
	public static ClaimHDR findByPrimaryKey(ClaimHDRPK claimHDRPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchClaimHDRException {

		return getPersistence().findByPrimaryKey(claimHDRPK);
	}

	/**
	 * Returns the claim hdr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimHDRPK the primary key of the claim hdr
	 * @return the claim hdr, or <code>null</code> if a claim hdr with the primary key could not be found
	 */
	public static ClaimHDR fetchByPrimaryKey(ClaimHDRPK claimHDRPK) {
		return getPersistence().fetchByPrimaryKey(claimHDRPK);
	}

	/**
	 * Returns all the claim hdrs.
	 *
	 * @return the claim hdrs
	 */
	public static List<ClaimHDR> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the claim hdrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @return the range of claim hdrs
	 */
	public static List<ClaimHDR> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the claim hdrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of claim hdrs
	 */
	public static List<ClaimHDR> findAll(
		int start, int end, OrderByComparator<ClaimHDR> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the claim hdrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of claim hdrs
	 */
	public static List<ClaimHDR> findAll(
		int start, int end, OrderByComparator<ClaimHDR> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the claim hdrs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of claim hdrs.
	 *
	 * @return the number of claim hdrs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static ClaimHDRPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ClaimHDRPersistence, ClaimHDRPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ClaimHDRPersistence.class);

		ServiceTracker<ClaimHDRPersistence, ClaimHDRPersistence>
			serviceTracker =
				new ServiceTracker<ClaimHDRPersistence, ClaimHDRPersistence>(
					bundle.getBundleContext(), ClaimHDRPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}