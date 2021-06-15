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

import com.ejada.atmc.acl.db.exception.NoSuchClaimTPSearchException;
import com.ejada.atmc.acl.db.model.ClaimTPSearch;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the claim tp search service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimTPSearchUtil
 * @generated
 */
@ProviderType
public interface ClaimTPSearchPersistence
	extends BasePersistence<ClaimTPSearch> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClaimTPSearchUtil} to access the claim tp search persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the claim tp search in the entity cache if it is enabled.
	 *
	 * @param claimTPSearch the claim tp search
	 */
	public void cacheResult(ClaimTPSearch claimTPSearch);

	/**
	 * Caches the claim tp searches in the entity cache if it is enabled.
	 *
	 * @param claimTPSearches the claim tp searches
	 */
	public void cacheResult(java.util.List<ClaimTPSearch> claimTPSearches);

	/**
	 * Creates a new claim tp search with the primary key. Does not add the claim tp search to the database.
	 *
	 * @param claimTPSearchPK the primary key for the new claim tp search
	 * @return the new claim tp search
	 */
	public ClaimTPSearch create(ClaimTPSearchPK claimTPSearchPK);

	/**
	 * Removes the claim tp search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimTPSearchPK the primary key of the claim tp search
	 * @return the claim tp search that was removed
	 * @throws NoSuchClaimTPSearchException if a claim tp search with the primary key could not be found
	 */
	public ClaimTPSearch remove(ClaimTPSearchPK claimTPSearchPK)
		throws NoSuchClaimTPSearchException;

	public ClaimTPSearch updateImpl(ClaimTPSearch claimTPSearch);

	/**
	 * Returns the claim tp search with the primary key or throws a <code>NoSuchClaimTPSearchException</code> if it could not be found.
	 *
	 * @param claimTPSearchPK the primary key of the claim tp search
	 * @return the claim tp search
	 * @throws NoSuchClaimTPSearchException if a claim tp search with the primary key could not be found
	 */
	public ClaimTPSearch findByPrimaryKey(ClaimTPSearchPK claimTPSearchPK)
		throws NoSuchClaimTPSearchException;

	/**
	 * Returns the claim tp search with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimTPSearchPK the primary key of the claim tp search
	 * @return the claim tp search, or <code>null</code> if a claim tp search with the primary key could not be found
	 */
	public ClaimTPSearch fetchByPrimaryKey(ClaimTPSearchPK claimTPSearchPK);

	/**
	 * Returns all the claim tp searches.
	 *
	 * @return the claim tp searches
	 */
	public java.util.List<ClaimTPSearch> findAll();

	/**
	 * Returns a range of all the claim tp searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimTPSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim tp searches
	 * @param end the upper bound of the range of claim tp searches (not inclusive)
	 * @return the range of claim tp searches
	 */
	public java.util.List<ClaimTPSearch> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the claim tp searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimTPSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim tp searches
	 * @param end the upper bound of the range of claim tp searches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of claim tp searches
	 */
	public java.util.List<ClaimTPSearch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimTPSearch>
			orderByComparator);

	/**
	 * Returns an ordered range of all the claim tp searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimTPSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim tp searches
	 * @param end the upper bound of the range of claim tp searches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of claim tp searches
	 */
	public java.util.List<ClaimTPSearch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimTPSearch>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the claim tp searches from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of claim tp searches.
	 *
	 * @return the number of claim tp searches
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}