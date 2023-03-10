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

import com.ejada.atmc.acl.db.exception.NoSuchSMSException;
import com.ejada.atmc.acl.db.model.SMS;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the Sms Table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SMSUtil
 * @generated
 */
@ProviderType
public interface SMSPersistence extends BasePersistence<SMS> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SMSUtil} to access the Sms Table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the Sms Table in the entity cache if it is enabled.
	 *
	 * @param sms the Sms Table
	 */
	public void cacheResult(SMS sms);

	/**
	 * Caches the Sms Tables in the entity cache if it is enabled.
	 *
	 * @param smses the Sms Tables
	 */
	public void cacheResult(java.util.List<SMS> smses);

	/**
	 * Creates a new Sms Table with the primary key. Does not add the Sms Table to the database.
	 *
	 * @param ID the primary key for the new Sms Table
	 * @return the new Sms Table
	 */
	public SMS create(long ID);

	/**
	 * Removes the Sms Table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the Sms Table
	 * @return the Sms Table that was removed
	 * @throws NoSuchSMSException if a Sms Table with the primary key could not be found
	 */
	public SMS remove(long ID) throws NoSuchSMSException;

	public SMS updateImpl(SMS sms);

	/**
	 * Returns the Sms Table with the primary key or throws a <code>NoSuchSMSException</code> if it could not be found.
	 *
	 * @param ID the primary key of the Sms Table
	 * @return the Sms Table
	 * @throws NoSuchSMSException if a Sms Table with the primary key could not be found
	 */
	public SMS findByPrimaryKey(long ID) throws NoSuchSMSException;

	/**
	 * Returns the Sms Table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the Sms Table
	 * @return the Sms Table, or <code>null</code> if a Sms Table with the primary key could not be found
	 */
	public SMS fetchByPrimaryKey(long ID);

	/**
	 * Returns all the Sms Tables.
	 *
	 * @return the Sms Tables
	 */
	public java.util.List<SMS> findAll();

	/**
	 * Returns a range of all the Sms Tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of Sms Tables
	 * @param end the upper bound of the range of Sms Tables (not inclusive)
	 * @return the range of Sms Tables
	 */
	public java.util.List<SMS> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the Sms Tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of Sms Tables
	 * @param end the upper bound of the range of Sms Tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Sms Tables
	 */
	public java.util.List<SMS> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SMS>
			orderByComparator);

	/**
	 * Returns an ordered range of all the Sms Tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of Sms Tables
	 * @param end the upper bound of the range of Sms Tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of Sms Tables
	 */
	public java.util.List<SMS> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SMS> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the Sms Tables from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of Sms Tables.
	 *
	 * @return the number of Sms Tables
	 */
	public int countAll();

}