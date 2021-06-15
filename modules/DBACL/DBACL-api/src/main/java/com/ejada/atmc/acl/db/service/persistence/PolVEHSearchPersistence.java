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

import com.ejada.atmc.acl.db.exception.NoSuchPolVEHSearchException;
import com.ejada.atmc.acl.db.model.PolVEHSearch;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pol veh search service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolVEHSearchUtil
 * @generated
 */
@ProviderType
public interface PolVEHSearchPersistence extends BasePersistence<PolVEHSearch> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PolVEHSearchUtil} to access the pol veh search persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the pol veh search in the entity cache if it is enabled.
	 *
	 * @param polVEHSearch the pol veh search
	 */
	public void cacheResult(PolVEHSearch polVEHSearch);

	/**
	 * Caches the pol veh searches in the entity cache if it is enabled.
	 *
	 * @param polVEHSearches the pol veh searches
	 */
	public void cacheResult(java.util.List<PolVEHSearch> polVEHSearches);

	/**
	 * Creates a new pol veh search with the primary key. Does not add the pol veh search to the database.
	 *
	 * @param polVEHSearchPK the primary key for the new pol veh search
	 * @return the new pol veh search
	 */
	public PolVEHSearch create(PolVEHSearchPK polVEHSearchPK);

	/**
	 * Removes the pol veh search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param polVEHSearchPK the primary key of the pol veh search
	 * @return the pol veh search that was removed
	 * @throws NoSuchPolVEHSearchException if a pol veh search with the primary key could not be found
	 */
	public PolVEHSearch remove(PolVEHSearchPK polVEHSearchPK)
		throws NoSuchPolVEHSearchException;

	public PolVEHSearch updateImpl(PolVEHSearch polVEHSearch);

	/**
	 * Returns the pol veh search with the primary key or throws a <code>NoSuchPolVEHSearchException</code> if it could not be found.
	 *
	 * @param polVEHSearchPK the primary key of the pol veh search
	 * @return the pol veh search
	 * @throws NoSuchPolVEHSearchException if a pol veh search with the primary key could not be found
	 */
	public PolVEHSearch findByPrimaryKey(PolVEHSearchPK polVEHSearchPK)
		throws NoSuchPolVEHSearchException;

	/**
	 * Returns the pol veh search with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param polVEHSearchPK the primary key of the pol veh search
	 * @return the pol veh search, or <code>null</code> if a pol veh search with the primary key could not be found
	 */
	public PolVEHSearch fetchByPrimaryKey(PolVEHSearchPK polVEHSearchPK);

	/**
	 * Returns all the pol veh searches.
	 *
	 * @return the pol veh searches
	 */
	public java.util.List<PolVEHSearch> findAll();

	/**
	 * Returns a range of all the pol veh searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolVEHSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pol veh searches
	 * @param end the upper bound of the range of pol veh searches (not inclusive)
	 * @return the range of pol veh searches
	 */
	public java.util.List<PolVEHSearch> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the pol veh searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolVEHSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pol veh searches
	 * @param end the upper bound of the range of pol veh searches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pol veh searches
	 */
	public java.util.List<PolVEHSearch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolVEHSearch>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pol veh searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolVEHSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pol veh searches
	 * @param end the upper bound of the range of pol veh searches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pol veh searches
	 */
	public java.util.List<PolVEHSearch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolVEHSearch>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pol veh searches from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pol veh searches.
	 *
	 * @return the number of pol veh searches
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}