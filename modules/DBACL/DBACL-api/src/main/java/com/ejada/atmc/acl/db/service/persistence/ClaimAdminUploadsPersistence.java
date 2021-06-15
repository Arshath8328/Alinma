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

import com.ejada.atmc.acl.db.exception.NoSuchClaimAdminUploadsException;
import com.ejada.atmc.acl.db.model.ClaimAdminUploads;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the claim admin uploads service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimAdminUploadsUtil
 * @generated
 */
@ProviderType
public interface ClaimAdminUploadsPersistence
	extends BasePersistence<ClaimAdminUploads> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClaimAdminUploadsUtil} to access the claim admin uploads persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the claim admin uploadses where refNo = &#63;.
	 *
	 * @param refNo the ref no
	 * @return the matching claim admin uploadses
	 */
	public java.util.List<ClaimAdminUploads> findByrefNo(String refNo);

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
	public java.util.List<ClaimAdminUploads> findByrefNo(
		String refNo, int start, int end);

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
	public java.util.List<ClaimAdminUploads> findByrefNo(
		String refNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimAdminUploads>
			orderByComparator);

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
	public java.util.List<ClaimAdminUploads> findByrefNo(
		String refNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimAdminUploads>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first claim admin uploads in the ordered set where refNo = &#63;.
	 *
	 * @param refNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim admin uploads
	 * @throws NoSuchClaimAdminUploadsException if a matching claim admin uploads could not be found
	 */
	public ClaimAdminUploads findByrefNo_First(
			String refNo,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimAdminUploads>
				orderByComparator)
		throws NoSuchClaimAdminUploadsException;

	/**
	 * Returns the first claim admin uploads in the ordered set where refNo = &#63;.
	 *
	 * @param refNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching claim admin uploads, or <code>null</code> if a matching claim admin uploads could not be found
	 */
	public ClaimAdminUploads fetchByrefNo_First(
		String refNo,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimAdminUploads>
			orderByComparator);

	/**
	 * Returns the last claim admin uploads in the ordered set where refNo = &#63;.
	 *
	 * @param refNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim admin uploads
	 * @throws NoSuchClaimAdminUploadsException if a matching claim admin uploads could not be found
	 */
	public ClaimAdminUploads findByrefNo_Last(
			String refNo,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimAdminUploads>
				orderByComparator)
		throws NoSuchClaimAdminUploadsException;

	/**
	 * Returns the last claim admin uploads in the ordered set where refNo = &#63;.
	 *
	 * @param refNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching claim admin uploads, or <code>null</code> if a matching claim admin uploads could not be found
	 */
	public ClaimAdminUploads fetchByrefNo_Last(
		String refNo,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimAdminUploads>
			orderByComparator);

	/**
	 * Returns the claim admin uploadses before and after the current claim admin uploads in the ordered set where refNo = &#63;.
	 *
	 * @param id the primary key of the current claim admin uploads
	 * @param refNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next claim admin uploads
	 * @throws NoSuchClaimAdminUploadsException if a claim admin uploads with the primary key could not be found
	 */
	public ClaimAdminUploads[] findByrefNo_PrevAndNext(
			int id, String refNo,
			com.liferay.portal.kernel.util.OrderByComparator<ClaimAdminUploads>
				orderByComparator)
		throws NoSuchClaimAdminUploadsException;

	/**
	 * Removes all the claim admin uploadses where refNo = &#63; from the database.
	 *
	 * @param refNo the ref no
	 */
	public void removeByrefNo(String refNo);

	/**
	 * Returns the number of claim admin uploadses where refNo = &#63;.
	 *
	 * @param refNo the ref no
	 * @return the number of matching claim admin uploadses
	 */
	public int countByrefNo(String refNo);

	/**
	 * Caches the claim admin uploads in the entity cache if it is enabled.
	 *
	 * @param claimAdminUploads the claim admin uploads
	 */
	public void cacheResult(ClaimAdminUploads claimAdminUploads);

	/**
	 * Caches the claim admin uploadses in the entity cache if it is enabled.
	 *
	 * @param claimAdminUploadses the claim admin uploadses
	 */
	public void cacheResult(
		java.util.List<ClaimAdminUploads> claimAdminUploadses);

	/**
	 * Creates a new claim admin uploads with the primary key. Does not add the claim admin uploads to the database.
	 *
	 * @param id the primary key for the new claim admin uploads
	 * @return the new claim admin uploads
	 */
	public ClaimAdminUploads create(int id);

	/**
	 * Removes the claim admin uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the claim admin uploads
	 * @return the claim admin uploads that was removed
	 * @throws NoSuchClaimAdminUploadsException if a claim admin uploads with the primary key could not be found
	 */
	public ClaimAdminUploads remove(int id)
		throws NoSuchClaimAdminUploadsException;

	public ClaimAdminUploads updateImpl(ClaimAdminUploads claimAdminUploads);

	/**
	 * Returns the claim admin uploads with the primary key or throws a <code>NoSuchClaimAdminUploadsException</code> if it could not be found.
	 *
	 * @param id the primary key of the claim admin uploads
	 * @return the claim admin uploads
	 * @throws NoSuchClaimAdminUploadsException if a claim admin uploads with the primary key could not be found
	 */
	public ClaimAdminUploads findByPrimaryKey(int id)
		throws NoSuchClaimAdminUploadsException;

	/**
	 * Returns the claim admin uploads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the claim admin uploads
	 * @return the claim admin uploads, or <code>null</code> if a claim admin uploads with the primary key could not be found
	 */
	public ClaimAdminUploads fetchByPrimaryKey(int id);

	/**
	 * Returns all the claim admin uploadses.
	 *
	 * @return the claim admin uploadses
	 */
	public java.util.List<ClaimAdminUploads> findAll();

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
	public java.util.List<ClaimAdminUploads> findAll(int start, int end);

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
	public java.util.List<ClaimAdminUploads> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimAdminUploads>
			orderByComparator);

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
	public java.util.List<ClaimAdminUploads> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimAdminUploads>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the claim admin uploadses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of claim admin uploadses.
	 *
	 * @return the number of claim admin uploadses
	 */
	public int countAll();

}