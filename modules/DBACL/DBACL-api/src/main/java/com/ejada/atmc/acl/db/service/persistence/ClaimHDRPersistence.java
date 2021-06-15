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

import com.ejada.atmc.acl.db.exception.NoSuchClaimHDRException;
import com.ejada.atmc.acl.db.model.ClaimHDR;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the claim hdr service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimHDRUtil
 * @generated
 */
@ProviderType
public interface ClaimHDRPersistence extends BasePersistence<ClaimHDR> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClaimHDRUtil} to access the claim hdr persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the claim hdrs where iqamaId = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @return the matching claim hdrs
	 */
	public java.util.List<ClaimHDR> findByIqamaId(String iqamaId);

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
	public java.util.List<ClaimHDR> findByIqamaId(
		String iqamaId, int start, int end);

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
	public java.util.List<ClaimHDR> findByIqamaId(
		String iqamaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimHDR>
			orderByComparator);

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
	public java.util.List<ClaimHDR> findByIqamaId(
		String iqamaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimHDR>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first claim hdr in the ordered set where iqamaId = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim hdr
	 * @throws NoSuchClaimHDRException if a matching claim hdr could not be found
	 */
	public ClaimHDR findByIqamaId_First(
			String iqamaId,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimHDR>
				orderByComparator)
		throws NoSuchClaimHDRException;

	/**
	 * Returns the first claim hdr in the ordered set where iqamaId = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim hdr, or <code>null</code> if a matching claim hdr could not be found
	 */
	public ClaimHDR fetchByIqamaId_First(
		String iqamaId,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimHDR>
			orderByComparator);

	/**
	 * Returns the last claim hdr in the ordered set where iqamaId = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim hdr
	 * @throws NoSuchClaimHDRException if a matching claim hdr could not be found
	 */
	public ClaimHDR findByIqamaId_Last(
			String iqamaId,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimHDR>
				orderByComparator)
		throws NoSuchClaimHDRException;

	/**
	 * Returns the last claim hdr in the ordered set where iqamaId = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim hdr, or <code>null</code> if a matching claim hdr could not be found
	 */
	public ClaimHDR fetchByIqamaId_Last(
		String iqamaId,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimHDR>
			orderByComparator);

	/**
	 * Returns the claim hdrs before and after the current claim hdr in the ordered set where iqamaId = &#63;.
	 *
	 * @param claimHDRPK the primary key of the current claim hdr
	 * @param iqamaId the iqama ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim hdr
	 * @throws NoSuchClaimHDRException if a claim hdr with the primary key could not be found
	 */
	public ClaimHDR[] findByIqamaId_PrevAndNext(
			ClaimHDRPK claimHDRPK, String iqamaId,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimHDR>
				orderByComparator)
		throws NoSuchClaimHDRException;

	/**
	 * Removes all the claim hdrs where iqamaId = &#63; from the database.
	 *
	 * @param iqamaId the iqama ID
	 */
	public void removeByIqamaId(String iqamaId);

	/**
	 * Returns the number of claim hdrs where iqamaId = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @return the number of matching claim hdrs
	 */
	public int countByIqamaId(String iqamaId);

	/**
	 * Returns all the claim hdrs where claimNo = &#63;.
	 *
	 * @param claimNo the claim no
	 * @return the matching claim hdrs
	 */
	public java.util.List<ClaimHDR> findByclaimNo(String claimNo);

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
	public java.util.List<ClaimHDR> findByclaimNo(
		String claimNo, int start, int end);

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
	public java.util.List<ClaimHDR> findByclaimNo(
		String claimNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimHDR>
			orderByComparator);

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
	public java.util.List<ClaimHDR> findByclaimNo(
		String claimNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimHDR>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first claim hdr in the ordered set where claimNo = &#63;.
	 *
	 * @param claimNo the claim no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim hdr
	 * @throws NoSuchClaimHDRException if a matching claim hdr could not be found
	 */
	public ClaimHDR findByclaimNo_First(
			String claimNo,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimHDR>
				orderByComparator)
		throws NoSuchClaimHDRException;

	/**
	 * Returns the first claim hdr in the ordered set where claimNo = &#63;.
	 *
	 * @param claimNo the claim no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim hdr, or <code>null</code> if a matching claim hdr could not be found
	 */
	public ClaimHDR fetchByclaimNo_First(
		String claimNo,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimHDR>
			orderByComparator);

	/**
	 * Returns the last claim hdr in the ordered set where claimNo = &#63;.
	 *
	 * @param claimNo the claim no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim hdr
	 * @throws NoSuchClaimHDRException if a matching claim hdr could not be found
	 */
	public ClaimHDR findByclaimNo_Last(
			String claimNo,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimHDR>
				orderByComparator)
		throws NoSuchClaimHDRException;

	/**
	 * Returns the last claim hdr in the ordered set where claimNo = &#63;.
	 *
	 * @param claimNo the claim no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim hdr, or <code>null</code> if a matching claim hdr could not be found
	 */
	public ClaimHDR fetchByclaimNo_Last(
		String claimNo,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimHDR>
			orderByComparator);

	/**
	 * Returns the claim hdrs before and after the current claim hdr in the ordered set where claimNo = &#63;.
	 *
	 * @param claimHDRPK the primary key of the current claim hdr
	 * @param claimNo the claim no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim hdr
	 * @throws NoSuchClaimHDRException if a claim hdr with the primary key could not be found
	 */
	public ClaimHDR[] findByclaimNo_PrevAndNext(
			ClaimHDRPK claimHDRPK, String claimNo,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimHDR>
				orderByComparator)
		throws NoSuchClaimHDRException;

	/**
	 * Removes all the claim hdrs where claimNo = &#63; from the database.
	 *
	 * @param claimNo the claim no
	 */
	public void removeByclaimNo(String claimNo);

	/**
	 * Returns the number of claim hdrs where claimNo = &#63;.
	 *
	 * @param claimNo the claim no
	 * @return the number of matching claim hdrs
	 */
	public int countByclaimNo(String claimNo);

	/**
	 * Caches the claim hdr in the entity cache if it is enabled.
	 *
	 * @param claimHDR the claim hdr
	 */
	public void cacheResult(ClaimHDR claimHDR);

	/**
	 * Caches the claim hdrs in the entity cache if it is enabled.
	 *
	 * @param claimHDRs the claim hdrs
	 */
	public void cacheResult(java.util.List<ClaimHDR> claimHDRs);

	/**
	 * Creates a new claim hdr with the primary key. Does not add the claim hdr to the database.
	 *
	 * @param claimHDRPK the primary key for the new claim hdr
	 * @return the new claim hdr
	 */
	public ClaimHDR create(ClaimHDRPK claimHDRPK);

	/**
	 * Removes the claim hdr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimHDRPK the primary key of the claim hdr
	 * @return the claim hdr that was removed
	 * @throws NoSuchClaimHDRException if a claim hdr with the primary key could not be found
	 */
	public ClaimHDR remove(ClaimHDRPK claimHDRPK)
		throws NoSuchClaimHDRException;

	public ClaimHDR updateImpl(ClaimHDR claimHDR);

	/**
	 * Returns the claim hdr with the primary key or throws a <code>NoSuchClaimHDRException</code> if it could not be found.
	 *
	 * @param claimHDRPK the primary key of the claim hdr
	 * @return the claim hdr
	 * @throws NoSuchClaimHDRException if a claim hdr with the primary key could not be found
	 */
	public ClaimHDR findByPrimaryKey(ClaimHDRPK claimHDRPK)
		throws NoSuchClaimHDRException;

	/**
	 * Returns the claim hdr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimHDRPK the primary key of the claim hdr
	 * @return the claim hdr, or <code>null</code> if a claim hdr with the primary key could not be found
	 */
	public ClaimHDR fetchByPrimaryKey(ClaimHDRPK claimHDRPK);

	/**
	 * Returns all the claim hdrs.
	 *
	 * @return the claim hdrs
	 */
	public java.util.List<ClaimHDR> findAll();

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
	public java.util.List<ClaimHDR> findAll(int start, int end);

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
	public java.util.List<ClaimHDR> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimHDR>
			orderByComparator);

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
	public java.util.List<ClaimHDR> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimHDR>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the claim hdrs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of claim hdrs.
	 *
	 * @return the number of claim hdrs
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}