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

import com.ejada.atmc.acl.db.exception.NoSuchODMuroorUploadsException;
import com.ejada.atmc.acl.db.model.ODMuroorUploads;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the od muroor uploads service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ODMuroorUploadsUtil
 * @generated
 */
@ProviderType
public interface ODMuroorUploadsPersistence
	extends BasePersistence<ODMuroorUploads> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ODMuroorUploadsUtil} to access the od muroor uploads persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the od muroor uploads where claimIntimationNo = &#63; or throws a <code>NoSuchODMuroorUploadsException</code> if it could not be found.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the matching od muroor uploads
	 * @throws NoSuchODMuroorUploadsException if a matching od muroor uploads could not be found
	 */
	public ODMuroorUploads findByclaimIntimationNo(String claimIntimationNo)
		throws NoSuchODMuroorUploadsException;

	/**
	 * Returns the od muroor uploads where claimIntimationNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the matching od muroor uploads, or <code>null</code> if a matching od muroor uploads could not be found
	 */
	public ODMuroorUploads fetchByclaimIntimationNo(String claimIntimationNo);

	/**
	 * Returns the od muroor uploads where claimIntimationNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching od muroor uploads, or <code>null</code> if a matching od muroor uploads could not be found
	 */
	public ODMuroorUploads fetchByclaimIntimationNo(
		String claimIntimationNo, boolean useFinderCache);

	/**
	 * Removes the od muroor uploads where claimIntimationNo = &#63; from the database.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the od muroor uploads that was removed
	 */
	public ODMuroorUploads removeByclaimIntimationNo(String claimIntimationNo)
		throws NoSuchODMuroorUploadsException;

	/**
	 * Returns the number of od muroor uploadses where claimIntimationNo = &#63;.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the number of matching od muroor uploadses
	 */
	public int countByclaimIntimationNo(String claimIntimationNo);

	/**
	 * Caches the od muroor uploads in the entity cache if it is enabled.
	 *
	 * @param odMuroorUploads the od muroor uploads
	 */
	public void cacheResult(ODMuroorUploads odMuroorUploads);

	/**
	 * Caches the od muroor uploadses in the entity cache if it is enabled.
	 *
	 * @param odMuroorUploadses the od muroor uploadses
	 */
	public void cacheResult(java.util.List<ODMuroorUploads> odMuroorUploadses);

	/**
	 * Creates a new od muroor uploads with the primary key. Does not add the od muroor uploads to the database.
	 *
	 * @param id the primary key for the new od muroor uploads
	 * @return the new od muroor uploads
	 */
	public ODMuroorUploads create(int id);

	/**
	 * Removes the od muroor uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the od muroor uploads
	 * @return the od muroor uploads that was removed
	 * @throws NoSuchODMuroorUploadsException if a od muroor uploads with the primary key could not be found
	 */
	public ODMuroorUploads remove(int id) throws NoSuchODMuroorUploadsException;

	public ODMuroorUploads updateImpl(ODMuroorUploads odMuroorUploads);

	/**
	 * Returns the od muroor uploads with the primary key or throws a <code>NoSuchODMuroorUploadsException</code> if it could not be found.
	 *
	 * @param id the primary key of the od muroor uploads
	 * @return the od muroor uploads
	 * @throws NoSuchODMuroorUploadsException if a od muroor uploads with the primary key could not be found
	 */
	public ODMuroorUploads findByPrimaryKey(int id)
		throws NoSuchODMuroorUploadsException;

	/**
	 * Returns the od muroor uploads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the od muroor uploads
	 * @return the od muroor uploads, or <code>null</code> if a od muroor uploads with the primary key could not be found
	 */
	public ODMuroorUploads fetchByPrimaryKey(int id);

	/**
	 * Returns all the od muroor uploadses.
	 *
	 * @return the od muroor uploadses
	 */
	public java.util.List<ODMuroorUploads> findAll();

	/**
	 * Returns a range of all the od muroor uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ODMuroorUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of od muroor uploadses
	 * @param end the upper bound of the range of od muroor uploadses (not inclusive)
	 * @return the range of od muroor uploadses
	 */
	public java.util.List<ODMuroorUploads> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the od muroor uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ODMuroorUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of od muroor uploadses
	 * @param end the upper bound of the range of od muroor uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of od muroor uploadses
	 */
	public java.util.List<ODMuroorUploads> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ODMuroorUploads>
			orderByComparator);

	/**
	 * Returns an ordered range of all the od muroor uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ODMuroorUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of od muroor uploadses
	 * @param end the upper bound of the range of od muroor uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of od muroor uploadses
	 */
	public java.util.List<ODMuroorUploads> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ODMuroorUploads>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the od muroor uploadses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of od muroor uploadses.
	 *
	 * @return the number of od muroor uploadses
	 */
	public int countAll();

}