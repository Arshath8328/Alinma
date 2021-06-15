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

import com.ejada.atmc.acl.db.exception.NoSuchMuroorTPUploadsException;
import com.ejada.atmc.acl.db.model.MuroorTPUploads;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the muroor tp uploads service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MuroorTPUploadsUtil
 * @generated
 */
@ProviderType
public interface MuroorTPUploadsPersistence
	extends BasePersistence<MuroorTPUploads> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MuroorTPUploadsUtil} to access the muroor tp uploads persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the muroor tp uploads where claimIntimationNo = &#63; or throws a <code>NoSuchMuroorTPUploadsException</code> if it could not be found.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the matching muroor tp uploads
	 * @throws NoSuchMuroorTPUploadsException if a matching muroor tp uploads could not be found
	 */
	public MuroorTPUploads findByclaimIntimationNo(String claimIntimationNo)
		throws NoSuchMuroorTPUploadsException;

	/**
	 * Returns the muroor tp uploads where claimIntimationNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the matching muroor tp uploads, or <code>null</code> if a matching muroor tp uploads could not be found
	 */
	public MuroorTPUploads fetchByclaimIntimationNo(String claimIntimationNo);

	/**
	 * Returns the muroor tp uploads where claimIntimationNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching muroor tp uploads, or <code>null</code> if a matching muroor tp uploads could not be found
	 */
	public MuroorTPUploads fetchByclaimIntimationNo(
		String claimIntimationNo, boolean useFinderCache);

	/**
	 * Removes the muroor tp uploads where claimIntimationNo = &#63; from the database.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the muroor tp uploads that was removed
	 */
	public MuroorTPUploads removeByclaimIntimationNo(String claimIntimationNo)
		throws NoSuchMuroorTPUploadsException;

	/**
	 * Returns the number of muroor tp uploadses where claimIntimationNo = &#63;.
	 *
	 * @param claimIntimationNo the claim intimation no
	 * @return the number of matching muroor tp uploadses
	 */
	public int countByclaimIntimationNo(String claimIntimationNo);

	/**
	 * Caches the muroor tp uploads in the entity cache if it is enabled.
	 *
	 * @param muroorTPUploads the muroor tp uploads
	 */
	public void cacheResult(MuroorTPUploads muroorTPUploads);

	/**
	 * Caches the muroor tp uploadses in the entity cache if it is enabled.
	 *
	 * @param muroorTPUploadses the muroor tp uploadses
	 */
	public void cacheResult(java.util.List<MuroorTPUploads> muroorTPUploadses);

	/**
	 * Creates a new muroor tp uploads with the primary key. Does not add the muroor tp uploads to the database.
	 *
	 * @param id the primary key for the new muroor tp uploads
	 * @return the new muroor tp uploads
	 */
	public MuroorTPUploads create(int id);

	/**
	 * Removes the muroor tp uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the muroor tp uploads
	 * @return the muroor tp uploads that was removed
	 * @throws NoSuchMuroorTPUploadsException if a muroor tp uploads with the primary key could not be found
	 */
	public MuroorTPUploads remove(int id) throws NoSuchMuroorTPUploadsException;

	public MuroorTPUploads updateImpl(MuroorTPUploads muroorTPUploads);

	/**
	 * Returns the muroor tp uploads with the primary key or throws a <code>NoSuchMuroorTPUploadsException</code> if it could not be found.
	 *
	 * @param id the primary key of the muroor tp uploads
	 * @return the muroor tp uploads
	 * @throws NoSuchMuroorTPUploadsException if a muroor tp uploads with the primary key could not be found
	 */
	public MuroorTPUploads findByPrimaryKey(int id)
		throws NoSuchMuroorTPUploadsException;

	/**
	 * Returns the muroor tp uploads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the muroor tp uploads
	 * @return the muroor tp uploads, or <code>null</code> if a muroor tp uploads with the primary key could not be found
	 */
	public MuroorTPUploads fetchByPrimaryKey(int id);

	/**
	 * Returns all the muroor tp uploadses.
	 *
	 * @return the muroor tp uploadses
	 */
	public java.util.List<MuroorTPUploads> findAll();

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
	public java.util.List<MuroorTPUploads> findAll(int start, int end);

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
	public java.util.List<MuroorTPUploads> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MuroorTPUploads>
			orderByComparator);

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
	public java.util.List<MuroorTPUploads> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MuroorTPUploads>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the muroor tp uploadses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of muroor tp uploadses.
	 *
	 * @return the number of muroor tp uploadses
	 */
	public int countAll();

}