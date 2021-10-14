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

import com.ejada.atmc.acl.db.model.ClaimIntimationMtr;

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
 * The persistence utility for the claim intimation mtr service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.ClaimIntimationMtrPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimIntimationMtrPersistence
 * @generated
 */
public class ClaimIntimationMtrUtil {

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
	public static void clearCache(ClaimIntimationMtr claimIntimationMtr) {
		getPersistence().clearCache(claimIntimationMtr);
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
	public static Map<Serializable, ClaimIntimationMtr> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ClaimIntimationMtr> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ClaimIntimationMtr> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ClaimIntimationMtr> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ClaimIntimationMtr update(
		ClaimIntimationMtr claimIntimationMtr) {

		return getPersistence().update(claimIntimationMtr);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ClaimIntimationMtr update(
		ClaimIntimationMtr claimIntimationMtr, ServiceContext serviceContext) {

		return getPersistence().update(claimIntimationMtr, serviceContext);
	}

	/**
	 * Returns all the claim intimation mtrs where intimationReferenceNo = &#63;.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @return the matching claim intimation mtrs
	 */
	public static List<ClaimIntimationMtr> findByintimationReferenceNo(
		String intimationReferenceNo) {

		return getPersistence().findByintimationReferenceNo(
			intimationReferenceNo);
	}

	/**
	 * Returns a range of all the claim intimation mtrs where intimationReferenceNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @return the range of matching claim intimation mtrs
	 */
	public static List<ClaimIntimationMtr> findByintimationReferenceNo(
		String intimationReferenceNo, int start, int end) {

		return getPersistence().findByintimationReferenceNo(
			intimationReferenceNo, start, end);
	}

	/**
	 * Returns an ordered range of all the claim intimation mtrs where intimationReferenceNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim intimation mtrs
	 */
	public static List<ClaimIntimationMtr> findByintimationReferenceNo(
		String intimationReferenceNo, int start, int end,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		return getPersistence().findByintimationReferenceNo(
			intimationReferenceNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the claim intimation mtrs where intimationReferenceNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim intimation mtrs
	 */
	public static List<ClaimIntimationMtr> findByintimationReferenceNo(
		String intimationReferenceNo, int start, int end,
		OrderByComparator<ClaimIntimationMtr> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByintimationReferenceNo(
			intimationReferenceNo, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first claim intimation mtr in the ordered set where intimationReferenceNo = &#63;.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a matching claim intimation mtr could not be found
	 */
	public static ClaimIntimationMtr findByintimationReferenceNo_First(
			String intimationReferenceNo,
			OrderByComparator<ClaimIntimationMtr> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchClaimIntimationMtrException {

		return getPersistence().findByintimationReferenceNo_First(
			intimationReferenceNo, orderByComparator);
	}

	/**
	 * Returns the first claim intimation mtr in the ordered set where intimationReferenceNo = &#63;.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim intimation mtr, or <code>null</code> if a matching claim intimation mtr could not be found
	 */
	public static ClaimIntimationMtr fetchByintimationReferenceNo_First(
		String intimationReferenceNo,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		return getPersistence().fetchByintimationReferenceNo_First(
			intimationReferenceNo, orderByComparator);
	}

	/**
	 * Returns the last claim intimation mtr in the ordered set where intimationReferenceNo = &#63;.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a matching claim intimation mtr could not be found
	 */
	public static ClaimIntimationMtr findByintimationReferenceNo_Last(
			String intimationReferenceNo,
			OrderByComparator<ClaimIntimationMtr> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchClaimIntimationMtrException {

		return getPersistence().findByintimationReferenceNo_Last(
			intimationReferenceNo, orderByComparator);
	}

	/**
	 * Returns the last claim intimation mtr in the ordered set where intimationReferenceNo = &#63;.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim intimation mtr, or <code>null</code> if a matching claim intimation mtr could not be found
	 */
	public static ClaimIntimationMtr fetchByintimationReferenceNo_Last(
		String intimationReferenceNo,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		return getPersistence().fetchByintimationReferenceNo_Last(
			intimationReferenceNo, orderByComparator);
	}

	/**
	 * Returns the claim intimation mtrs before and after the current claim intimation mtr in the ordered set where intimationReferenceNo = &#63;.
	 *
	 * @param claimIntimationMotorId the primary key of the current claim intimation mtr
	 * @param intimationReferenceNo the intimation reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a claim intimation mtr with the primary key could not be found
	 */
	public static ClaimIntimationMtr[] findByintimationReferenceNo_PrevAndNext(
			long claimIntimationMotorId, String intimationReferenceNo,
			OrderByComparator<ClaimIntimationMtr> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchClaimIntimationMtrException {

		return getPersistence().findByintimationReferenceNo_PrevAndNext(
			claimIntimationMotorId, intimationReferenceNo, orderByComparator);
	}

	/**
	 * Removes all the claim intimation mtrs where intimationReferenceNo = &#63; from the database.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 */
	public static void removeByintimationReferenceNo(
		String intimationReferenceNo) {

		getPersistence().removeByintimationReferenceNo(intimationReferenceNo);
	}

	/**
	 * Returns the number of claim intimation mtrs where intimationReferenceNo = &#63;.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @return the number of matching claim intimation mtrs
	 */
	public static int countByintimationReferenceNo(
		String intimationReferenceNo) {

		return getPersistence().countByintimationReferenceNo(
			intimationReferenceNo);
	}

	/**
	 * Returns all the claim intimation mtrs where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the matching claim intimation mtrs
	 */
	public static List<ClaimIntimationMtr> findBymobileNo(String mobileNo) {
		return getPersistence().findBymobileNo(mobileNo);
	}

	/**
	 * Returns a range of all the claim intimation mtrs where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @return the range of matching claim intimation mtrs
	 */
	public static List<ClaimIntimationMtr> findBymobileNo(
		String mobileNo, int start, int end) {

		return getPersistence().findBymobileNo(mobileNo, start, end);
	}

	/**
	 * Returns an ordered range of all the claim intimation mtrs where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim intimation mtrs
	 */
	public static List<ClaimIntimationMtr> findBymobileNo(
		String mobileNo, int start, int end,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		return getPersistence().findBymobileNo(
			mobileNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the claim intimation mtrs where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim intimation mtrs
	 */
	public static List<ClaimIntimationMtr> findBymobileNo(
		String mobileNo, int start, int end,
		OrderByComparator<ClaimIntimationMtr> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBymobileNo(
			mobileNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first claim intimation mtr in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a matching claim intimation mtr could not be found
	 */
	public static ClaimIntimationMtr findBymobileNo_First(
			String mobileNo,
			OrderByComparator<ClaimIntimationMtr> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchClaimIntimationMtrException {

		return getPersistence().findBymobileNo_First(
			mobileNo, orderByComparator);
	}

	/**
	 * Returns the first claim intimation mtr in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim intimation mtr, or <code>null</code> if a matching claim intimation mtr could not be found
	 */
	public static ClaimIntimationMtr fetchBymobileNo_First(
		String mobileNo,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		return getPersistence().fetchBymobileNo_First(
			mobileNo, orderByComparator);
	}

	/**
	 * Returns the last claim intimation mtr in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a matching claim intimation mtr could not be found
	 */
	public static ClaimIntimationMtr findBymobileNo_Last(
			String mobileNo,
			OrderByComparator<ClaimIntimationMtr> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchClaimIntimationMtrException {

		return getPersistence().findBymobileNo_Last(
			mobileNo, orderByComparator);
	}

	/**
	 * Returns the last claim intimation mtr in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim intimation mtr, or <code>null</code> if a matching claim intimation mtr could not be found
	 */
	public static ClaimIntimationMtr fetchBymobileNo_Last(
		String mobileNo,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		return getPersistence().fetchBymobileNo_Last(
			mobileNo, orderByComparator);
	}

	/**
	 * Returns the claim intimation mtrs before and after the current claim intimation mtr in the ordered set where mobileNo = &#63;.
	 *
	 * @param claimIntimationMotorId the primary key of the current claim intimation mtr
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a claim intimation mtr with the primary key could not be found
	 */
	public static ClaimIntimationMtr[] findBymobileNo_PrevAndNext(
			long claimIntimationMotorId, String mobileNo,
			OrderByComparator<ClaimIntimationMtr> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchClaimIntimationMtrException {

		return getPersistence().findBymobileNo_PrevAndNext(
			claimIntimationMotorId, mobileNo, orderByComparator);
	}

	/**
	 * Removes all the claim intimation mtrs where mobileNo = &#63; from the database.
	 *
	 * @param mobileNo the mobile no
	 */
	public static void removeBymobileNo(String mobileNo) {
		getPersistence().removeBymobileNo(mobileNo);
	}

	/**
	 * Returns the number of claim intimation mtrs where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the number of matching claim intimation mtrs
	 */
	public static int countBymobileNo(String mobileNo) {
		return getPersistence().countBymobileNo(mobileNo);
	}

	/**
	 * Returns all the claim intimation mtrs where driverNationalId = &#63;.
	 *
	 * @param driverNationalId the driver national ID
	 * @return the matching claim intimation mtrs
	 */
	public static List<ClaimIntimationMtr> findBydriverNationalId(
		long driverNationalId) {

		return getPersistence().findBydriverNationalId(driverNationalId);
	}

	/**
	 * Returns a range of all the claim intimation mtrs where driverNationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param driverNationalId the driver national ID
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @return the range of matching claim intimation mtrs
	 */
	public static List<ClaimIntimationMtr> findBydriverNationalId(
		long driverNationalId, int start, int end) {

		return getPersistence().findBydriverNationalId(
			driverNationalId, start, end);
	}

	/**
	 * Returns an ordered range of all the claim intimation mtrs where driverNationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param driverNationalId the driver national ID
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching claim intimation mtrs
	 */
	public static List<ClaimIntimationMtr> findBydriverNationalId(
		long driverNationalId, int start, int end,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		return getPersistence().findBydriverNationalId(
			driverNationalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the claim intimation mtrs where driverNationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param driverNationalId the driver national ID
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching claim intimation mtrs
	 */
	public static List<ClaimIntimationMtr> findBydriverNationalId(
		long driverNationalId, int start, int end,
		OrderByComparator<ClaimIntimationMtr> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydriverNationalId(
			driverNationalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first claim intimation mtr in the ordered set where driverNationalId = &#63;.
	 *
	 * @param driverNationalId the driver national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a matching claim intimation mtr could not be found
	 */
	public static ClaimIntimationMtr findBydriverNationalId_First(
			long driverNationalId,
			OrderByComparator<ClaimIntimationMtr> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchClaimIntimationMtrException {

		return getPersistence().findBydriverNationalId_First(
			driverNationalId, orderByComparator);
	}

	/**
	 * Returns the first claim intimation mtr in the ordered set where driverNationalId = &#63;.
	 *
	 * @param driverNationalId the driver national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim intimation mtr, or <code>null</code> if a matching claim intimation mtr could not be found
	 */
	public static ClaimIntimationMtr fetchBydriverNationalId_First(
		long driverNationalId,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		return getPersistence().fetchBydriverNationalId_First(
			driverNationalId, orderByComparator);
	}

	/**
	 * Returns the last claim intimation mtr in the ordered set where driverNationalId = &#63;.
	 *
	 * @param driverNationalId the driver national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a matching claim intimation mtr could not be found
	 */
	public static ClaimIntimationMtr findBydriverNationalId_Last(
			long driverNationalId,
			OrderByComparator<ClaimIntimationMtr> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchClaimIntimationMtrException {

		return getPersistence().findBydriverNationalId_Last(
			driverNationalId, orderByComparator);
	}

	/**
	 * Returns the last claim intimation mtr in the ordered set where driverNationalId = &#63;.
	 *
	 * @param driverNationalId the driver national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim intimation mtr, or <code>null</code> if a matching claim intimation mtr could not be found
	 */
	public static ClaimIntimationMtr fetchBydriverNationalId_Last(
		long driverNationalId,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		return getPersistence().fetchBydriverNationalId_Last(
			driverNationalId, orderByComparator);
	}

	/**
	 * Returns the claim intimation mtrs before and after the current claim intimation mtr in the ordered set where driverNationalId = &#63;.
	 *
	 * @param claimIntimationMotorId the primary key of the current claim intimation mtr
	 * @param driverNationalId the driver national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a claim intimation mtr with the primary key could not be found
	 */
	public static ClaimIntimationMtr[] findBydriverNationalId_PrevAndNext(
			long claimIntimationMotorId, long driverNationalId,
			OrderByComparator<ClaimIntimationMtr> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchClaimIntimationMtrException {

		return getPersistence().findBydriverNationalId_PrevAndNext(
			claimIntimationMotorId, driverNationalId, orderByComparator);
	}

	/**
	 * Removes all the claim intimation mtrs where driverNationalId = &#63; from the database.
	 *
	 * @param driverNationalId the driver national ID
	 */
	public static void removeBydriverNationalId(long driverNationalId) {
		getPersistence().removeBydriverNationalId(driverNationalId);
	}

	/**
	 * Returns the number of claim intimation mtrs where driverNationalId = &#63;.
	 *
	 * @param driverNationalId the driver national ID
	 * @return the number of matching claim intimation mtrs
	 */
	public static int countBydriverNationalId(long driverNationalId) {
		return getPersistence().countBydriverNationalId(driverNationalId);
	}

	/**
	 * Caches the claim intimation mtr in the entity cache if it is enabled.
	 *
	 * @param claimIntimationMtr the claim intimation mtr
	 */
	public static void cacheResult(ClaimIntimationMtr claimIntimationMtr) {
		getPersistence().cacheResult(claimIntimationMtr);
	}

	/**
	 * Caches the claim intimation mtrs in the entity cache if it is enabled.
	 *
	 * @param claimIntimationMtrs the claim intimation mtrs
	 */
	public static void cacheResult(
		List<ClaimIntimationMtr> claimIntimationMtrs) {

		getPersistence().cacheResult(claimIntimationMtrs);
	}

	/**
	 * Creates a new claim intimation mtr with the primary key. Does not add the claim intimation mtr to the database.
	 *
	 * @param claimIntimationMotorId the primary key for the new claim intimation mtr
	 * @return the new claim intimation mtr
	 */
	public static ClaimIntimationMtr create(long claimIntimationMotorId) {
		return getPersistence().create(claimIntimationMotorId);
	}

	/**
	 * Removes the claim intimation mtr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimIntimationMotorId the primary key of the claim intimation mtr
	 * @return the claim intimation mtr that was removed
	 * @throws NoSuchClaimIntimationMtrException if a claim intimation mtr with the primary key could not be found
	 */
	public static ClaimIntimationMtr remove(long claimIntimationMotorId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchClaimIntimationMtrException {

		return getPersistence().remove(claimIntimationMotorId);
	}

	public static ClaimIntimationMtr updateImpl(
		ClaimIntimationMtr claimIntimationMtr) {

		return getPersistence().updateImpl(claimIntimationMtr);
	}

	/**
	 * Returns the claim intimation mtr with the primary key or throws a <code>NoSuchClaimIntimationMtrException</code> if it could not be found.
	 *
	 * @param claimIntimationMotorId the primary key of the claim intimation mtr
	 * @return the claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a claim intimation mtr with the primary key could not be found
	 */
	public static ClaimIntimationMtr findByPrimaryKey(
			long claimIntimationMotorId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchClaimIntimationMtrException {

		return getPersistence().findByPrimaryKey(claimIntimationMotorId);
	}

	/**
	 * Returns the claim intimation mtr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimIntimationMotorId the primary key of the claim intimation mtr
	 * @return the claim intimation mtr, or <code>null</code> if a claim intimation mtr with the primary key could not be found
	 */
	public static ClaimIntimationMtr fetchByPrimaryKey(
		long claimIntimationMotorId) {

		return getPersistence().fetchByPrimaryKey(claimIntimationMotorId);
	}

	/**
	 * Returns all the claim intimation mtrs.
	 *
	 * @return the claim intimation mtrs
	 */
	public static List<ClaimIntimationMtr> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the claim intimation mtrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @return the range of claim intimation mtrs
	 */
	public static List<ClaimIntimationMtr> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the claim intimation mtrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of claim intimation mtrs
	 */
	public static List<ClaimIntimationMtr> findAll(
		int start, int end,
		OrderByComparator<ClaimIntimationMtr> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the claim intimation mtrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of claim intimation mtrs
	 */
	public static List<ClaimIntimationMtr> findAll(
		int start, int end,
		OrderByComparator<ClaimIntimationMtr> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the claim intimation mtrs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of claim intimation mtrs.
	 *
	 * @return the number of claim intimation mtrs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ClaimIntimationMtrPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ClaimIntimationMtrPersistence, ClaimIntimationMtrPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ClaimIntimationMtrPersistence.class);

		ServiceTracker
			<ClaimIntimationMtrPersistence, ClaimIntimationMtrPersistence>
				serviceTracker =
					new ServiceTracker
						<ClaimIntimationMtrPersistence,
						 ClaimIntimationMtrPersistence>(
							 bundle.getBundleContext(),
							 ClaimIntimationMtrPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}