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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationDriversException;
import com.ejada.atmc.acl.db.model.QuotationDrivers;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the quotation drivers service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationDriversUtil
 * @generated
 */
@ProviderType
public interface QuotationDriversPersistence
	extends BasePersistence<QuotationDrivers> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuotationDriversUtil} to access the quotation drivers persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the quotation drivers where addDriverId = &#63; and quotationId = &#63; or throws a <code>NoSuchQuotationDriversException</code> if it could not be found.
	 *
	 * @param addDriverId the add driver ID
	 * @param quotationId the quotation ID
	 * @return the matching quotation drivers
	 * @throws NoSuchQuotationDriversException if a matching quotation drivers could not be found
	 */
	public QuotationDrivers findByAddDriverIdQuotationId(
			long addDriverId, long quotationId)
		throws NoSuchQuotationDriversException;

	/**
	 * Returns the quotation drivers where addDriverId = &#63; and quotationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param addDriverId the add driver ID
	 * @param quotationId the quotation ID
	 * @return the matching quotation drivers, or <code>null</code> if a matching quotation drivers could not be found
	 */
	public QuotationDrivers fetchByAddDriverIdQuotationId(
		long addDriverId, long quotationId);

	/**
	 * Returns the quotation drivers where addDriverId = &#63; and quotationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param addDriverId the add driver ID
	 * @param quotationId the quotation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotation drivers, or <code>null</code> if a matching quotation drivers could not be found
	 */
	public QuotationDrivers fetchByAddDriverIdQuotationId(
		long addDriverId, long quotationId, boolean useFinderCache);

	/**
	 * Removes the quotation drivers where addDriverId = &#63; and quotationId = &#63; from the database.
	 *
	 * @param addDriverId the add driver ID
	 * @param quotationId the quotation ID
	 * @return the quotation drivers that was removed
	 */
	public QuotationDrivers removeByAddDriverIdQuotationId(
			long addDriverId, long quotationId)
		throws NoSuchQuotationDriversException;

	/**
	 * Returns the number of quotation driverses where addDriverId = &#63; and quotationId = &#63;.
	 *
	 * @param addDriverId the add driver ID
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation driverses
	 */
	public int countByAddDriverIdQuotationId(
		long addDriverId, long quotationId);

	/**
	 * Returns all the quotation driverses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation driverses
	 */
	public java.util.List<QuotationDrivers> findByQuotationId(long quotationId);

	/**
	 * Returns a range of all the quotation driverses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @return the range of matching quotation driverses
	 */
	public java.util.List<QuotationDrivers> findByQuotationId(
		long quotationId, int start, int end);

	/**
	 * Returns an ordered range of all the quotation driverses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotation driverses
	 */
	public java.util.List<QuotationDrivers> findByQuotationId(
		long quotationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationDrivers>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotation driverses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotation driverses
	 */
	public java.util.List<QuotationDrivers> findByQuotationId(
		long quotationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationDrivers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first quotation drivers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation drivers
	 * @throws NoSuchQuotationDriversException if a matching quotation drivers could not be found
	 */
	public QuotationDrivers findByQuotationId_First(
			long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator<QuotationDrivers>
				orderByComparator)
		throws NoSuchQuotationDriversException;

	/**
	 * Returns the first quotation drivers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation drivers, or <code>null</code> if a matching quotation drivers could not be found
	 */
	public QuotationDrivers fetchByQuotationId_First(
		long quotationId,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationDrivers>
			orderByComparator);

	/**
	 * Returns the last quotation drivers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation drivers
	 * @throws NoSuchQuotationDriversException if a matching quotation drivers could not be found
	 */
	public QuotationDrivers findByQuotationId_Last(
			long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator<QuotationDrivers>
				orderByComparator)
		throws NoSuchQuotationDriversException;

	/**
	 * Returns the last quotation drivers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation drivers, or <code>null</code> if a matching quotation drivers could not be found
	 */
	public QuotationDrivers fetchByQuotationId_Last(
		long quotationId,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationDrivers>
			orderByComparator);

	/**
	 * Returns the quotation driverses before and after the current quotation drivers in the ordered set where quotationId = &#63;.
	 *
	 * @param addDriverId the primary key of the current quotation drivers
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation drivers
	 * @throws NoSuchQuotationDriversException if a quotation drivers with the primary key could not be found
	 */
	public QuotationDrivers[] findByQuotationId_PrevAndNext(
			long addDriverId, long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator<QuotationDrivers>
				orderByComparator)
		throws NoSuchQuotationDriversException;

	/**
	 * Removes all the quotation driverses where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	public void removeByQuotationId(long quotationId);

	/**
	 * Returns the number of quotation driverses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation driverses
	 */
	public int countByQuotationId(long quotationId);

	/**
	 * Returns all the quotation driverses where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @return the matching quotation driverses
	 */
	public java.util.List<QuotationDrivers> findByQuotationIdIsDriverUnder21(
		boolean isDriverUnder21, long quotationId);

	/**
	 * Returns a range of all the quotation driverses where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @return the range of matching quotation driverses
	 */
	public java.util.List<QuotationDrivers> findByQuotationIdIsDriverUnder21(
		boolean isDriverUnder21, long quotationId, int start, int end);

	/**
	 * Returns an ordered range of all the quotation driverses where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotation driverses
	 */
	public java.util.List<QuotationDrivers> findByQuotationIdIsDriverUnder21(
		boolean isDriverUnder21, long quotationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationDrivers>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotation driverses where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotation driverses
	 */
	public java.util.List<QuotationDrivers> findByQuotationIdIsDriverUnder21(
		boolean isDriverUnder21, long quotationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationDrivers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first quotation drivers in the ordered set where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation drivers
	 * @throws NoSuchQuotationDriversException if a matching quotation drivers could not be found
	 */
	public QuotationDrivers findByQuotationIdIsDriverUnder21_First(
			boolean isDriverUnder21, long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator<QuotationDrivers>
				orderByComparator)
		throws NoSuchQuotationDriversException;

	/**
	 * Returns the first quotation drivers in the ordered set where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation drivers, or <code>null</code> if a matching quotation drivers could not be found
	 */
	public QuotationDrivers fetchByQuotationIdIsDriverUnder21_First(
		boolean isDriverUnder21, long quotationId,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationDrivers>
			orderByComparator);

	/**
	 * Returns the last quotation drivers in the ordered set where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation drivers
	 * @throws NoSuchQuotationDriversException if a matching quotation drivers could not be found
	 */
	public QuotationDrivers findByQuotationIdIsDriverUnder21_Last(
			boolean isDriverUnder21, long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator<QuotationDrivers>
				orderByComparator)
		throws NoSuchQuotationDriversException;

	/**
	 * Returns the last quotation drivers in the ordered set where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation drivers, or <code>null</code> if a matching quotation drivers could not be found
	 */
	public QuotationDrivers fetchByQuotationIdIsDriverUnder21_Last(
		boolean isDriverUnder21, long quotationId,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationDrivers>
			orderByComparator);

	/**
	 * Returns the quotation driverses before and after the current quotation drivers in the ordered set where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param addDriverId the primary key of the current quotation drivers
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation drivers
	 * @throws NoSuchQuotationDriversException if a quotation drivers with the primary key could not be found
	 */
	public QuotationDrivers[] findByQuotationIdIsDriverUnder21_PrevAndNext(
			long addDriverId, boolean isDriverUnder21, long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator<QuotationDrivers>
				orderByComparator)
		throws NoSuchQuotationDriversException;

	/**
	 * Removes all the quotation driverses where isDriverUnder21 = &#63; and quotationId = &#63; from the database.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 */
	public void removeByQuotationIdIsDriverUnder21(
		boolean isDriverUnder21, long quotationId);

	/**
	 * Returns the number of quotation driverses where isDriverUnder21 = &#63; and quotationId = &#63;.
	 *
	 * @param isDriverUnder21 the is driver under21
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation driverses
	 */
	public int countByQuotationIdIsDriverUnder21(
		boolean isDriverUnder21, long quotationId);

	/**
	 * Caches the quotation drivers in the entity cache if it is enabled.
	 *
	 * @param quotationDrivers the quotation drivers
	 */
	public void cacheResult(QuotationDrivers quotationDrivers);

	/**
	 * Caches the quotation driverses in the entity cache if it is enabled.
	 *
	 * @param quotationDriverses the quotation driverses
	 */
	public void cacheResult(
		java.util.List<QuotationDrivers> quotationDriverses);

	/**
	 * Creates a new quotation drivers with the primary key. Does not add the quotation drivers to the database.
	 *
	 * @param addDriverId the primary key for the new quotation drivers
	 * @return the new quotation drivers
	 */
	public QuotationDrivers create(long addDriverId);

	/**
	 * Removes the quotation drivers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addDriverId the primary key of the quotation drivers
	 * @return the quotation drivers that was removed
	 * @throws NoSuchQuotationDriversException if a quotation drivers with the primary key could not be found
	 */
	public QuotationDrivers remove(long addDriverId)
		throws NoSuchQuotationDriversException;

	public QuotationDrivers updateImpl(QuotationDrivers quotationDrivers);

	/**
	 * Returns the quotation drivers with the primary key or throws a <code>NoSuchQuotationDriversException</code> if it could not be found.
	 *
	 * @param addDriverId the primary key of the quotation drivers
	 * @return the quotation drivers
	 * @throws NoSuchQuotationDriversException if a quotation drivers with the primary key could not be found
	 */
	public QuotationDrivers findByPrimaryKey(long addDriverId)
		throws NoSuchQuotationDriversException;

	/**
	 * Returns the quotation drivers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addDriverId the primary key of the quotation drivers
	 * @return the quotation drivers, or <code>null</code> if a quotation drivers with the primary key could not be found
	 */
	public QuotationDrivers fetchByPrimaryKey(long addDriverId);

	/**
	 * Returns all the quotation driverses.
	 *
	 * @return the quotation driverses
	 */
	public java.util.List<QuotationDrivers> findAll();

	/**
	 * Returns a range of all the quotation driverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @return the range of quotation driverses
	 */
	public java.util.List<QuotationDrivers> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the quotation driverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotation driverses
	 */
	public java.util.List<QuotationDrivers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationDrivers>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotation driverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotation driverses
	 */
	public java.util.List<QuotationDrivers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationDrivers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the quotation driverses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of quotation driverses.
	 *
	 * @return the number of quotation driverses
	 */
	public int countAll();

}