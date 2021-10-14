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

import com.ejada.atmc.acl.db.exception.NoSuchClaimIntimationMtrException;
import com.ejada.atmc.acl.db.model.ClaimIntimationMtr;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the claim intimation mtr service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimIntimationMtrUtil
 * @generated
 */
@ProviderType
public interface ClaimIntimationMtrPersistence
	extends BasePersistence<ClaimIntimationMtr> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClaimIntimationMtrUtil} to access the claim intimation mtr persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the claim intimation mtrs where intimationReferenceNo = &#63;.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @return the matching claim intimation mtrs
	 */
	public java.util.List<ClaimIntimationMtr> findByintimationReferenceNo(
		String intimationReferenceNo);

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
	public java.util.List<ClaimIntimationMtr> findByintimationReferenceNo(
		String intimationReferenceNo, int start, int end);

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
	public java.util.List<ClaimIntimationMtr> findByintimationReferenceNo(
		String intimationReferenceNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
			orderByComparator);

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
	public java.util.List<ClaimIntimationMtr> findByintimationReferenceNo(
		String intimationReferenceNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first claim intimation mtr in the ordered set where intimationReferenceNo = &#63;.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a matching claim intimation mtr could not be found
	 */
	public ClaimIntimationMtr findByintimationReferenceNo_First(
			String intimationReferenceNo,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
				orderByComparator)
		throws NoSuchClaimIntimationMtrException;

	/**
	 * Returns the first claim intimation mtr in the ordered set where intimationReferenceNo = &#63;.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim intimation mtr, or <code>null</code> if a matching claim intimation mtr could not be found
	 */
	public ClaimIntimationMtr fetchByintimationReferenceNo_First(
		String intimationReferenceNo,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
			orderByComparator);

	/**
	 * Returns the last claim intimation mtr in the ordered set where intimationReferenceNo = &#63;.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a matching claim intimation mtr could not be found
	 */
	public ClaimIntimationMtr findByintimationReferenceNo_Last(
			String intimationReferenceNo,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
				orderByComparator)
		throws NoSuchClaimIntimationMtrException;

	/**
	 * Returns the last claim intimation mtr in the ordered set where intimationReferenceNo = &#63;.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim intimation mtr, or <code>null</code> if a matching claim intimation mtr could not be found
	 */
	public ClaimIntimationMtr fetchByintimationReferenceNo_Last(
		String intimationReferenceNo,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
			orderByComparator);

	/**
	 * Returns the claim intimation mtrs before and after the current claim intimation mtr in the ordered set where intimationReferenceNo = &#63;.
	 *
	 * @param claimIntimationMotorId the primary key of the current claim intimation mtr
	 * @param intimationReferenceNo the intimation reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a claim intimation mtr with the primary key could not be found
	 */
	public ClaimIntimationMtr[] findByintimationReferenceNo_PrevAndNext(
			long claimIntimationMotorId, String intimationReferenceNo,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
				orderByComparator)
		throws NoSuchClaimIntimationMtrException;

	/**
	 * Removes all the claim intimation mtrs where intimationReferenceNo = &#63; from the database.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 */
	public void removeByintimationReferenceNo(String intimationReferenceNo);

	/**
	 * Returns the number of claim intimation mtrs where intimationReferenceNo = &#63;.
	 *
	 * @param intimationReferenceNo the intimation reference no
	 * @return the number of matching claim intimation mtrs
	 */
	public int countByintimationReferenceNo(String intimationReferenceNo);

	/**
	 * Returns all the claim intimation mtrs where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the matching claim intimation mtrs
	 */
	public java.util.List<ClaimIntimationMtr> findBymobileNo(String mobileNo);

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
	public java.util.List<ClaimIntimationMtr> findBymobileNo(
		String mobileNo, int start, int end);

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
	public java.util.List<ClaimIntimationMtr> findBymobileNo(
		String mobileNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
			orderByComparator);

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
	public java.util.List<ClaimIntimationMtr> findBymobileNo(
		String mobileNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first claim intimation mtr in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a matching claim intimation mtr could not be found
	 */
	public ClaimIntimationMtr findBymobileNo_First(
			String mobileNo,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
				orderByComparator)
		throws NoSuchClaimIntimationMtrException;

	/**
	 * Returns the first claim intimation mtr in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim intimation mtr, or <code>null</code> if a matching claim intimation mtr could not be found
	 */
	public ClaimIntimationMtr fetchBymobileNo_First(
		String mobileNo,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
			orderByComparator);

	/**
	 * Returns the last claim intimation mtr in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a matching claim intimation mtr could not be found
	 */
	public ClaimIntimationMtr findBymobileNo_Last(
			String mobileNo,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
				orderByComparator)
		throws NoSuchClaimIntimationMtrException;

	/**
	 * Returns the last claim intimation mtr in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim intimation mtr, or <code>null</code> if a matching claim intimation mtr could not be found
	 */
	public ClaimIntimationMtr fetchBymobileNo_Last(
		String mobileNo,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
			orderByComparator);

	/**
	 * Returns the claim intimation mtrs before and after the current claim intimation mtr in the ordered set where mobileNo = &#63;.
	 *
	 * @param claimIntimationMotorId the primary key of the current claim intimation mtr
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a claim intimation mtr with the primary key could not be found
	 */
	public ClaimIntimationMtr[] findBymobileNo_PrevAndNext(
			long claimIntimationMotorId, String mobileNo,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
				orderByComparator)
		throws NoSuchClaimIntimationMtrException;

	/**
	 * Removes all the claim intimation mtrs where mobileNo = &#63; from the database.
	 *
	 * @param mobileNo the mobile no
	 */
	public void removeBymobileNo(String mobileNo);

	/**
	 * Returns the number of claim intimation mtrs where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the number of matching claim intimation mtrs
	 */
	public int countBymobileNo(String mobileNo);

	/**
	 * Returns all the claim intimation mtrs where driverNationalId = &#63;.
	 *
	 * @param driverNationalId the driver national ID
	 * @return the matching claim intimation mtrs
	 */
	public java.util.List<ClaimIntimationMtr> findBydriverNationalId(
		long driverNationalId);

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
	public java.util.List<ClaimIntimationMtr> findBydriverNationalId(
		long driverNationalId, int start, int end);

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
	public java.util.List<ClaimIntimationMtr> findBydriverNationalId(
		long driverNationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
			orderByComparator);

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
	public java.util.List<ClaimIntimationMtr> findBydriverNationalId(
		long driverNationalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first claim intimation mtr in the ordered set where driverNationalId = &#63;.
	 *
	 * @param driverNationalId the driver national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a matching claim intimation mtr could not be found
	 */
	public ClaimIntimationMtr findBydriverNationalId_First(
			long driverNationalId,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
				orderByComparator)
		throws NoSuchClaimIntimationMtrException;

	/**
	 * Returns the first claim intimation mtr in the ordered set where driverNationalId = &#63;.
	 *
	 * @param driverNationalId the driver national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim intimation mtr, or <code>null</code> if a matching claim intimation mtr could not be found
	 */
	public ClaimIntimationMtr fetchBydriverNationalId_First(
		long driverNationalId,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
			orderByComparator);

	/**
	 * Returns the last claim intimation mtr in the ordered set where driverNationalId = &#63;.
	 *
	 * @param driverNationalId the driver national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a matching claim intimation mtr could not be found
	 */
	public ClaimIntimationMtr findBydriverNationalId_Last(
			long driverNationalId,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
				orderByComparator)
		throws NoSuchClaimIntimationMtrException;

	/**
	 * Returns the last claim intimation mtr in the ordered set where driverNationalId = &#63;.
	 *
	 * @param driverNationalId the driver national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim intimation mtr, or <code>null</code> if a matching claim intimation mtr could not be found
	 */
	public ClaimIntimationMtr fetchBydriverNationalId_Last(
		long driverNationalId,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
			orderByComparator);

	/**
	 * Returns the claim intimation mtrs before and after the current claim intimation mtr in the ordered set where driverNationalId = &#63;.
	 *
	 * @param claimIntimationMotorId the primary key of the current claim intimation mtr
	 * @param driverNationalId the driver national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a claim intimation mtr with the primary key could not be found
	 */
	public ClaimIntimationMtr[] findBydriverNationalId_PrevAndNext(
			long claimIntimationMotorId, long driverNationalId,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
				orderByComparator)
		throws NoSuchClaimIntimationMtrException;

	/**
	 * Removes all the claim intimation mtrs where driverNationalId = &#63; from the database.
	 *
	 * @param driverNationalId the driver national ID
	 */
	public void removeBydriverNationalId(long driverNationalId);

	/**
	 * Returns the number of claim intimation mtrs where driverNationalId = &#63;.
	 *
	 * @param driverNationalId the driver national ID
	 * @return the number of matching claim intimation mtrs
	 */
	public int countBydriverNationalId(long driverNationalId);

	/**
	 * Caches the claim intimation mtr in the entity cache if it is enabled.
	 *
	 * @param claimIntimationMtr the claim intimation mtr
	 */
	public void cacheResult(ClaimIntimationMtr claimIntimationMtr);

	/**
	 * Caches the claim intimation mtrs in the entity cache if it is enabled.
	 *
	 * @param claimIntimationMtrs the claim intimation mtrs
	 */
	public void cacheResult(
		java.util.List<ClaimIntimationMtr> claimIntimationMtrs);

	/**
	 * Creates a new claim intimation mtr with the primary key. Does not add the claim intimation mtr to the database.
	 *
	 * @param claimIntimationMotorId the primary key for the new claim intimation mtr
	 * @return the new claim intimation mtr
	 */
	public ClaimIntimationMtr create(long claimIntimationMotorId);

	/**
	 * Removes the claim intimation mtr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimIntimationMotorId the primary key of the claim intimation mtr
	 * @return the claim intimation mtr that was removed
	 * @throws NoSuchClaimIntimationMtrException if a claim intimation mtr with the primary key could not be found
	 */
	public ClaimIntimationMtr remove(long claimIntimationMotorId)
		throws NoSuchClaimIntimationMtrException;

	public ClaimIntimationMtr updateImpl(ClaimIntimationMtr claimIntimationMtr);

	/**
	 * Returns the claim intimation mtr with the primary key or throws a <code>NoSuchClaimIntimationMtrException</code> if it could not be found.
	 *
	 * @param claimIntimationMotorId the primary key of the claim intimation mtr
	 * @return the claim intimation mtr
	 * @throws NoSuchClaimIntimationMtrException if a claim intimation mtr with the primary key could not be found
	 */
	public ClaimIntimationMtr findByPrimaryKey(long claimIntimationMotorId)
		throws NoSuchClaimIntimationMtrException;

	/**
	 * Returns the claim intimation mtr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimIntimationMotorId the primary key of the claim intimation mtr
	 * @return the claim intimation mtr, or <code>null</code> if a claim intimation mtr with the primary key could not be found
	 */
	public ClaimIntimationMtr fetchByPrimaryKey(long claimIntimationMotorId);

	/**
	 * Returns all the claim intimation mtrs.
	 *
	 * @return the claim intimation mtrs
	 */
	public java.util.List<ClaimIntimationMtr> findAll();

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
	public java.util.List<ClaimIntimationMtr> findAll(int start, int end);

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
	public java.util.List<ClaimIntimationMtr> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
			orderByComparator);

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
	public java.util.List<ClaimIntimationMtr> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimIntimationMtr>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the claim intimation mtrs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of claim intimation mtrs.
	 *
	 * @return the number of claim intimation mtrs
	 */
	public int countAll();

}