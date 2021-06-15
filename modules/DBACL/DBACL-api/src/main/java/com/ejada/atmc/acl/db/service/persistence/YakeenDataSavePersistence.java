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

import com.ejada.atmc.acl.db.exception.NoSuchYakeenDataSaveException;
import com.ejada.atmc.acl.db.model.YakeenDataSave;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the yakeen data save service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see YakeenDataSaveUtil
 * @generated
 */
@ProviderType
public interface YakeenDataSavePersistence
	extends BasePersistence<YakeenDataSave> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link YakeenDataSaveUtil} to access the yakeen data save persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the yakeen data save where Id = &#63; and dob = &#63; and status = &#63; and serviceName = &#63; or throws a <code>NoSuchYakeenDataSaveException</code> if it could not be found.
	 *
	 * @param Id the ID
	 * @param dob the dob
	 * @param status the status
	 * @param serviceName the service name
	 * @return the matching yakeen data save
	 * @throws NoSuchYakeenDataSaveException if a matching yakeen data save could not be found
	 */
	public YakeenDataSave findByiqamaDobStatusServiceName(
			String Id, Date dob, String status, String serviceName)
		throws NoSuchYakeenDataSaveException;

	/**
	 * Returns the yakeen data save where Id = &#63; and dob = &#63; and status = &#63; and serviceName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param Id the ID
	 * @param dob the dob
	 * @param status the status
	 * @param serviceName the service name
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	public YakeenDataSave fetchByiqamaDobStatusServiceName(
		String Id, Date dob, String status, String serviceName);

	/**
	 * Returns the yakeen data save where Id = &#63; and dob = &#63; and status = &#63; and serviceName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param Id the ID
	 * @param dob the dob
	 * @param status the status
	 * @param serviceName the service name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	public YakeenDataSave fetchByiqamaDobStatusServiceName(
		String Id, Date dob, String status, String serviceName,
		boolean useFinderCache);

	/**
	 * Removes the yakeen data save where Id = &#63; and dob = &#63; and status = &#63; and serviceName = &#63; from the database.
	 *
	 * @param Id the ID
	 * @param dob the dob
	 * @param status the status
	 * @param serviceName the service name
	 * @return the yakeen data save that was removed
	 */
	public YakeenDataSave removeByiqamaDobStatusServiceName(
			String Id, Date dob, String status, String serviceName)
		throws NoSuchYakeenDataSaveException;

	/**
	 * Returns the number of yakeen data saves where Id = &#63; and dob = &#63; and status = &#63; and serviceName = &#63;.
	 *
	 * @param Id the ID
	 * @param dob the dob
	 * @param status the status
	 * @param serviceName the service name
	 * @return the number of matching yakeen data saves
	 */
	public int countByiqamaDobStatusServiceName(
		String Id, Date dob, String status, String serviceName);

	/**
	 * Returns the yakeen data save where serviceName = &#63; and status = &#63; and Id = &#63; or throws a <code>NoSuchYakeenDataSaveException</code> if it could not be found.
	 *
	 * @param serviceName the service name
	 * @param status the status
	 * @param Id the ID
	 * @return the matching yakeen data save
	 * @throws NoSuchYakeenDataSaveException if a matching yakeen data save could not be found
	 */
	public YakeenDataSave findByiqamaStatusServiceName(
			String serviceName, String status, String Id)
		throws NoSuchYakeenDataSaveException;

	/**
	 * Returns the yakeen data save where serviceName = &#63; and status = &#63; and Id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param serviceName the service name
	 * @param status the status
	 * @param Id the ID
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	public YakeenDataSave fetchByiqamaStatusServiceName(
		String serviceName, String status, String Id);

	/**
	 * Returns the yakeen data save where serviceName = &#63; and status = &#63; and Id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param serviceName the service name
	 * @param status the status
	 * @param Id the ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	public YakeenDataSave fetchByiqamaStatusServiceName(
		String serviceName, String status, String Id, boolean useFinderCache);

	/**
	 * Removes the yakeen data save where serviceName = &#63; and status = &#63; and Id = &#63; from the database.
	 *
	 * @param serviceName the service name
	 * @param status the status
	 * @param Id the ID
	 * @return the yakeen data save that was removed
	 */
	public YakeenDataSave removeByiqamaStatusServiceName(
			String serviceName, String status, String Id)
		throws NoSuchYakeenDataSaveException;

	/**
	 * Returns the number of yakeen data saves where serviceName = &#63; and status = &#63; and Id = &#63;.
	 *
	 * @param serviceName the service name
	 * @param status the status
	 * @param Id the ID
	 * @return the number of matching yakeen data saves
	 */
	public int countByiqamaStatusServiceName(
		String serviceName, String status, String Id);

	/**
	 * Returns the yakeen data save where Id = &#63; and sequenceNumber = &#63; and serviceName = &#63; and status = &#63; or throws a <code>NoSuchYakeenDataSaveException</code> if it could not be found.
	 *
	 * @param Id the ID
	 * @param sequenceNumber the sequence number
	 * @param serviceName the service name
	 * @param status the status
	 * @return the matching yakeen data save
	 * @throws NoSuchYakeenDataSaveException if a matching yakeen data save could not be found
	 */
	public YakeenDataSave findBycitIzenCarInfoIdSeq(
			String Id, String sequenceNumber, String serviceName, String status)
		throws NoSuchYakeenDataSaveException;

	/**
	 * Returns the yakeen data save where Id = &#63; and sequenceNumber = &#63; and serviceName = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param Id the ID
	 * @param sequenceNumber the sequence number
	 * @param serviceName the service name
	 * @param status the status
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	public YakeenDataSave fetchBycitIzenCarInfoIdSeq(
		String Id, String sequenceNumber, String serviceName, String status);

	/**
	 * Returns the yakeen data save where Id = &#63; and sequenceNumber = &#63; and serviceName = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param Id the ID
	 * @param sequenceNumber the sequence number
	 * @param serviceName the service name
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	public YakeenDataSave fetchBycitIzenCarInfoIdSeq(
		String Id, String sequenceNumber, String serviceName, String status,
		boolean useFinderCache);

	/**
	 * Removes the yakeen data save where Id = &#63; and sequenceNumber = &#63; and serviceName = &#63; and status = &#63; from the database.
	 *
	 * @param Id the ID
	 * @param sequenceNumber the sequence number
	 * @param serviceName the service name
	 * @param status the status
	 * @return the yakeen data save that was removed
	 */
	public YakeenDataSave removeBycitIzenCarInfoIdSeq(
			String Id, String sequenceNumber, String serviceName, String status)
		throws NoSuchYakeenDataSaveException;

	/**
	 * Returns the number of yakeen data saves where Id = &#63; and sequenceNumber = &#63; and serviceName = &#63; and status = &#63;.
	 *
	 * @param Id the ID
	 * @param sequenceNumber the sequence number
	 * @param serviceName the service name
	 * @param status the status
	 * @return the number of matching yakeen data saves
	 */
	public int countBycitIzenCarInfoIdSeq(
		String Id, String sequenceNumber, String serviceName, String status);

	/**
	 * Returns the yakeen data save where sequenceNumber = &#63; or throws a <code>NoSuchYakeenDataSaveException</code> if it could not be found.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the matching yakeen data save
	 * @throws NoSuchYakeenDataSaveException if a matching yakeen data save could not be found
	 */
	public YakeenDataSave findByVehicleSequence(String sequenceNumber)
		throws NoSuchYakeenDataSaveException;

	/**
	 * Returns the yakeen data save where sequenceNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	public YakeenDataSave fetchByVehicleSequence(String sequenceNumber);

	/**
	 * Returns the yakeen data save where sequenceNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sequenceNumber the sequence number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	public YakeenDataSave fetchByVehicleSequence(
		String sequenceNumber, boolean useFinderCache);

	/**
	 * Removes the yakeen data save where sequenceNumber = &#63; from the database.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the yakeen data save that was removed
	 */
	public YakeenDataSave removeByVehicleSequence(String sequenceNumber)
		throws NoSuchYakeenDataSaveException;

	/**
	 * Returns the number of yakeen data saves where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the number of matching yakeen data saves
	 */
	public int countByVehicleSequence(String sequenceNumber);

	/**
	 * Caches the yakeen data save in the entity cache if it is enabled.
	 *
	 * @param yakeenDataSave the yakeen data save
	 */
	public void cacheResult(YakeenDataSave yakeenDataSave);

	/**
	 * Caches the yakeen data saves in the entity cache if it is enabled.
	 *
	 * @param yakeenDataSaves the yakeen data saves
	 */
	public void cacheResult(java.util.List<YakeenDataSave> yakeenDataSaves);

	/**
	 * Creates a new yakeen data save with the primary key. Does not add the yakeen data save to the database.
	 *
	 * @param Id the primary key for the new yakeen data save
	 * @return the new yakeen data save
	 */
	public YakeenDataSave create(String Id);

	/**
	 * Removes the yakeen data save with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the yakeen data save
	 * @return the yakeen data save that was removed
	 * @throws NoSuchYakeenDataSaveException if a yakeen data save with the primary key could not be found
	 */
	public YakeenDataSave remove(String Id)
		throws NoSuchYakeenDataSaveException;

	public YakeenDataSave updateImpl(YakeenDataSave yakeenDataSave);

	/**
	 * Returns the yakeen data save with the primary key or throws a <code>NoSuchYakeenDataSaveException</code> if it could not be found.
	 *
	 * @param Id the primary key of the yakeen data save
	 * @return the yakeen data save
	 * @throws NoSuchYakeenDataSaveException if a yakeen data save with the primary key could not be found
	 */
	public YakeenDataSave findByPrimaryKey(String Id)
		throws NoSuchYakeenDataSaveException;

	/**
	 * Returns the yakeen data save with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the yakeen data save
	 * @return the yakeen data save, or <code>null</code> if a yakeen data save with the primary key could not be found
	 */
	public YakeenDataSave fetchByPrimaryKey(String Id);

	/**
	 * Returns all the yakeen data saves.
	 *
	 * @return the yakeen data saves
	 */
	public java.util.List<YakeenDataSave> findAll();

	/**
	 * Returns a range of all the yakeen data saves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>YakeenDataSaveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of yakeen data saves
	 * @param end the upper bound of the range of yakeen data saves (not inclusive)
	 * @return the range of yakeen data saves
	 */
	public java.util.List<YakeenDataSave> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the yakeen data saves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>YakeenDataSaveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of yakeen data saves
	 * @param end the upper bound of the range of yakeen data saves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of yakeen data saves
	 */
	public java.util.List<YakeenDataSave> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<YakeenDataSave>
			orderByComparator);

	/**
	 * Returns an ordered range of all the yakeen data saves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>YakeenDataSaveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of yakeen data saves
	 * @param end the upper bound of the range of yakeen data saves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of yakeen data saves
	 */
	public java.util.List<YakeenDataSave> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<YakeenDataSave>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the yakeen data saves from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of yakeen data saves.
	 *
	 * @return the number of yakeen data saves
	 */
	public int countAll();

}