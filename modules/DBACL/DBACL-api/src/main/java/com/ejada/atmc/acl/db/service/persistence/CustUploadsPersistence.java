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

import com.ejada.atmc.acl.db.exception.NoSuchCustUploadsException;
import com.ejada.atmc.acl.db.model.CustUploads;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cust uploads service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustUploadsUtil
 * @generated
 */
@ProviderType
public interface CustUploadsPersistence extends BasePersistence<CustUploads> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CustUploadsUtil} to access the cust uploads persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the cust uploads where quotId = &#63; or throws a <code>NoSuchCustUploadsException</code> if it could not be found.
	 *
	 * @param quotId the quot ID
	 * @return the matching cust uploads
	 * @throws NoSuchCustUploadsException if a matching cust uploads could not be found
	 */
	public CustUploads findByquotId(String quotId)
		throws NoSuchCustUploadsException;

	/**
	 * Returns the cust uploads where quotId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quotId the quot ID
	 * @return the matching cust uploads, or <code>null</code> if a matching cust uploads could not be found
	 */
	public CustUploads fetchByquotId(String quotId);

	/**
	 * Returns the cust uploads where quotId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quotId the quot ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cust uploads, or <code>null</code> if a matching cust uploads could not be found
	 */
	public CustUploads fetchByquotId(String quotId, boolean useFinderCache);

	/**
	 * Removes the cust uploads where quotId = &#63; from the database.
	 *
	 * @param quotId the quot ID
	 * @return the cust uploads that was removed
	 */
	public CustUploads removeByquotId(String quotId)
		throws NoSuchCustUploadsException;

	/**
	 * Returns the number of cust uploadses where quotId = &#63;.
	 *
	 * @param quotId the quot ID
	 * @return the number of matching cust uploadses
	 */
	public int countByquotId(String quotId);

	/**
	 * Caches the cust uploads in the entity cache if it is enabled.
	 *
	 * @param custUploads the cust uploads
	 */
	public void cacheResult(CustUploads custUploads);

	/**
	 * Caches the cust uploadses in the entity cache if it is enabled.
	 *
	 * @param custUploadses the cust uploadses
	 */
	public void cacheResult(java.util.List<CustUploads> custUploadses);

	/**
	 * Creates a new cust uploads with the primary key. Does not add the cust uploads to the database.
	 *
	 * @param id the primary key for the new cust uploads
	 * @return the new cust uploads
	 */
	public CustUploads create(long id);

	/**
	 * Removes the cust uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cust uploads
	 * @return the cust uploads that was removed
	 * @throws NoSuchCustUploadsException if a cust uploads with the primary key could not be found
	 */
	public CustUploads remove(long id) throws NoSuchCustUploadsException;

	public CustUploads updateImpl(CustUploads custUploads);

	/**
	 * Returns the cust uploads with the primary key or throws a <code>NoSuchCustUploadsException</code> if it could not be found.
	 *
	 * @param id the primary key of the cust uploads
	 * @return the cust uploads
	 * @throws NoSuchCustUploadsException if a cust uploads with the primary key could not be found
	 */
	public CustUploads findByPrimaryKey(long id)
		throws NoSuchCustUploadsException;

	/**
	 * Returns the cust uploads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cust uploads
	 * @return the cust uploads, or <code>null</code> if a cust uploads with the primary key could not be found
	 */
	public CustUploads fetchByPrimaryKey(long id);

	/**
	 * Returns all the cust uploadses.
	 *
	 * @return the cust uploadses
	 */
	public java.util.List<CustUploads> findAll();

	/**
	 * Returns a range of all the cust uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cust uploadses
	 * @param end the upper bound of the range of cust uploadses (not inclusive)
	 * @return the range of cust uploadses
	 */
	public java.util.List<CustUploads> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cust uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cust uploadses
	 * @param end the upper bound of the range of cust uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cust uploadses
	 */
	public java.util.List<CustUploads> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustUploads>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cust uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cust uploadses
	 * @param end the upper bound of the range of cust uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cust uploadses
	 */
	public java.util.List<CustUploads> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustUploads>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cust uploadses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cust uploadses.
	 *
	 * @return the number of cust uploadses
	 */
	public int countAll();

}