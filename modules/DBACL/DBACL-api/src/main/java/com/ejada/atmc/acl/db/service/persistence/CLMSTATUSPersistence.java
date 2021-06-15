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

import com.ejada.atmc.acl.db.exception.NoSuchCLMSTATUSException;
import com.ejada.atmc.acl.db.model.CLMSTATUS;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the clmstatus service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CLMSTATUSUtil
 * @generated
 */
@ProviderType
public interface CLMSTATUSPersistence extends BasePersistence<CLMSTATUS> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CLMSTATUSUtil} to access the clmstatus persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the clmstatus in the entity cache if it is enabled.
	 *
	 * @param clmstatus the clmstatus
	 */
	public void cacheResult(CLMSTATUS clmstatus);

	/**
	 * Caches the clmstatuses in the entity cache if it is enabled.
	 *
	 * @param clmstatuses the clmstatuses
	 */
	public void cacheResult(java.util.List<CLMSTATUS> clmstatuses);

	/**
	 * Creates a new clmstatus with the primary key. Does not add the clmstatus to the database.
	 *
	 * @param RefNo the primary key for the new clmstatus
	 * @return the new clmstatus
	 */
	public CLMSTATUS create(String RefNo);

	/**
	 * Removes the clmstatus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param RefNo the primary key of the clmstatus
	 * @return the clmstatus that was removed
	 * @throws NoSuchCLMSTATUSException if a clmstatus with the primary key could not be found
	 */
	public CLMSTATUS remove(String RefNo) throws NoSuchCLMSTATUSException;

	public CLMSTATUS updateImpl(CLMSTATUS clmstatus);

	/**
	 * Returns the clmstatus with the primary key or throws a <code>NoSuchCLMSTATUSException</code> if it could not be found.
	 *
	 * @param RefNo the primary key of the clmstatus
	 * @return the clmstatus
	 * @throws NoSuchCLMSTATUSException if a clmstatus with the primary key could not be found
	 */
	public CLMSTATUS findByPrimaryKey(String RefNo)
		throws NoSuchCLMSTATUSException;

	/**
	 * Returns the clmstatus with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param RefNo the primary key of the clmstatus
	 * @return the clmstatus, or <code>null</code> if a clmstatus with the primary key could not be found
	 */
	public CLMSTATUS fetchByPrimaryKey(String RefNo);

	/**
	 * Returns all the clmstatuses.
	 *
	 * @return the clmstatuses
	 */
	public java.util.List<CLMSTATUS> findAll();

	/**
	 * Returns a range of all the clmstatuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatuses
	 * @param end the upper bound of the range of clmstatuses (not inclusive)
	 * @return the range of clmstatuses
	 */
	public java.util.List<CLMSTATUS> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the clmstatuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatuses
	 * @param end the upper bound of the range of clmstatuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clmstatuses
	 */
	public java.util.List<CLMSTATUS> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMSTATUS>
			orderByComparator);

	/**
	 * Returns an ordered range of all the clmstatuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatuses
	 * @param end the upper bound of the range of clmstatuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of clmstatuses
	 */
	public java.util.List<CLMSTATUS> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMSTATUS>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the clmstatuses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of clmstatuses.
	 *
	 * @return the number of clmstatuses
	 */
	public int countAll();

}