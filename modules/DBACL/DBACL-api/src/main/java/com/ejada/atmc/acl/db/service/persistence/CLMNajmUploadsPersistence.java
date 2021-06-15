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

import com.ejada.atmc.acl.db.exception.NoSuchCLMNajmUploadsException;
import com.ejada.atmc.acl.db.model.CLMNajmUploads;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the clm najm uploads service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CLMNajmUploadsUtil
 * @generated
 */
@ProviderType
public interface CLMNajmUploadsPersistence
	extends BasePersistence<CLMNajmUploads> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CLMNajmUploadsUtil} to access the clm najm uploads persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the clm najm uploads where claimRefNo = &#63; or throws a <code>NoSuchCLMNajmUploadsException</code> if it could not be found.
	 *
	 * @param claimRefNo the claim ref no
	 * @return the matching clm najm uploads
	 * @throws NoSuchCLMNajmUploadsException if a matching clm najm uploads could not be found
	 */
	public CLMNajmUploads findByClaimRefNo(String claimRefNo)
		throws NoSuchCLMNajmUploadsException;

	/**
	 * Returns the clm najm uploads where claimRefNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param claimRefNo the claim ref no
	 * @return the matching clm najm uploads, or <code>null</code> if a matching clm najm uploads could not be found
	 */
	public CLMNajmUploads fetchByClaimRefNo(String claimRefNo);

	/**
	 * Returns the clm najm uploads where claimRefNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param claimRefNo the claim ref no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching clm najm uploads, or <code>null</code> if a matching clm najm uploads could not be found
	 */
	public CLMNajmUploads fetchByClaimRefNo(
		String claimRefNo, boolean useFinderCache);

	/**
	 * Removes the clm najm uploads where claimRefNo = &#63; from the database.
	 *
	 * @param claimRefNo the claim ref no
	 * @return the clm najm uploads that was removed
	 */
	public CLMNajmUploads removeByClaimRefNo(String claimRefNo)
		throws NoSuchCLMNajmUploadsException;

	/**
	 * Returns the number of clm najm uploadses where claimRefNo = &#63;.
	 *
	 * @param claimRefNo the claim ref no
	 * @return the number of matching clm najm uploadses
	 */
	public int countByClaimRefNo(String claimRefNo);

	/**
	 * Caches the clm najm uploads in the entity cache if it is enabled.
	 *
	 * @param clmNajmUploads the clm najm uploads
	 */
	public void cacheResult(CLMNajmUploads clmNajmUploads);

	/**
	 * Caches the clm najm uploadses in the entity cache if it is enabled.
	 *
	 * @param clmNajmUploadses the clm najm uploadses
	 */
	public void cacheResult(java.util.List<CLMNajmUploads> clmNajmUploadses);

	/**
	 * Creates a new clm najm uploads with the primary key. Does not add the clm najm uploads to the database.
	 *
	 * @param id the primary key for the new clm najm uploads
	 * @return the new clm najm uploads
	 */
	public CLMNajmUploads create(int id);

	/**
	 * Removes the clm najm uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the clm najm uploads
	 * @return the clm najm uploads that was removed
	 * @throws NoSuchCLMNajmUploadsException if a clm najm uploads with the primary key could not be found
	 */
	public CLMNajmUploads remove(int id) throws NoSuchCLMNajmUploadsException;

	public CLMNajmUploads updateImpl(CLMNajmUploads clmNajmUploads);

	/**
	 * Returns the clm najm uploads with the primary key or throws a <code>NoSuchCLMNajmUploadsException</code> if it could not be found.
	 *
	 * @param id the primary key of the clm najm uploads
	 * @return the clm najm uploads
	 * @throws NoSuchCLMNajmUploadsException if a clm najm uploads with the primary key could not be found
	 */
	public CLMNajmUploads findByPrimaryKey(int id)
		throws NoSuchCLMNajmUploadsException;

	/**
	 * Returns the clm najm uploads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the clm najm uploads
	 * @return the clm najm uploads, or <code>null</code> if a clm najm uploads with the primary key could not be found
	 */
	public CLMNajmUploads fetchByPrimaryKey(int id);

	/**
	 * Returns all the clm najm uploadses.
	 *
	 * @return the clm najm uploadses
	 */
	public java.util.List<CLMNajmUploads> findAll();

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
	public java.util.List<CLMNajmUploads> findAll(int start, int end);

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
	public java.util.List<CLMNajmUploads> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMNajmUploads>
			orderByComparator);

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
	public java.util.List<CLMNajmUploads> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMNajmUploads>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the clm najm uploadses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of clm najm uploadses.
	 *
	 * @return the number of clm najm uploadses
	 */
	public int countAll();

}