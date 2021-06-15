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

import com.ejada.atmc.acl.db.exception.NoSuchClaimODSearchException;
import com.ejada.atmc.acl.db.model.ClaimODSearch;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the claim od search service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimODSearchUtil
 * @generated
 */
@ProviderType
public interface ClaimODSearchPersistence
	extends BasePersistence<ClaimODSearch> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClaimODSearchUtil} to access the claim od search persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the claim od search in the entity cache if it is enabled.
	 *
	 * @param claimODSearch the claim od search
	 */
	public void cacheResult(ClaimODSearch claimODSearch);

	/**
	 * Caches the claim od searches in the entity cache if it is enabled.
	 *
	 * @param claimODSearches the claim od searches
	 */
	public void cacheResult(java.util.List<ClaimODSearch> claimODSearches);

	/**
	 * Creates a new claim od search with the primary key. Does not add the claim od search to the database.
	 *
	 * @param claimODSearchPK the primary key for the new claim od search
	 * @return the new claim od search
	 */
	public ClaimODSearch create(ClaimODSearchPK claimODSearchPK);

	/**
	 * Removes the claim od search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimODSearchPK the primary key of the claim od search
	 * @return the claim od search that was removed
	 * @throws NoSuchClaimODSearchException if a claim od search with the primary key could not be found
	 */
	public ClaimODSearch remove(ClaimODSearchPK claimODSearchPK)
		throws NoSuchClaimODSearchException;

	public ClaimODSearch updateImpl(ClaimODSearch claimODSearch);

	/**
	 * Returns the claim od search with the primary key or throws a <code>NoSuchClaimODSearchException</code> if it could not be found.
	 *
	 * @param claimODSearchPK the primary key of the claim od search
	 * @return the claim od search
	 * @throws NoSuchClaimODSearchException if a claim od search with the primary key could not be found
	 */
	public ClaimODSearch findByPrimaryKey(ClaimODSearchPK claimODSearchPK)
		throws NoSuchClaimODSearchException;

	/**
	 * Returns the claim od search with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimODSearchPK the primary key of the claim od search
	 * @return the claim od search, or <code>null</code> if a claim od search with the primary key could not be found
	 */
	public ClaimODSearch fetchByPrimaryKey(ClaimODSearchPK claimODSearchPK);

	/**
	 * Returns all the claim od searches.
	 *
	 * @return the claim od searches
	 */
	public java.util.List<ClaimODSearch> findAll();

	/**
	 * Returns a range of all the claim od searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimODSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim od searches
	 * @param end the upper bound of the range of claim od searches (not inclusive)
	 * @return the range of claim od searches
	 */
	public java.util.List<ClaimODSearch> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the claim od searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimODSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim od searches
	 * @param end the upper bound of the range of claim od searches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of claim od searches
	 */
	public java.util.List<ClaimODSearch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimODSearch>
			orderByComparator);

	/**
	 * Returns an ordered range of all the claim od searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimODSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim od searches
	 * @param end the upper bound of the range of claim od searches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of claim od searches
	 */
	public java.util.List<ClaimODSearch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClaimODSearch>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the claim od searches from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of claim od searches.
	 *
	 * @return the number of claim od searches
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}