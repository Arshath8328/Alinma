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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationsUserAddressException;
import com.ejada.atmc.acl.db.model.QuotationsUserAddress;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the quotations user address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsUserAddressUtil
 * @generated
 */
@ProviderType
public interface QuotationsUserAddressPersistence
	extends BasePersistence<QuotationsUserAddress> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuotationsUserAddressUtil} to access the quotations user address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the quotations user address where quotationId = &#63; and driverId = &#63; and isNatAddress = &#63; or throws a <code>NoSuchQuotationsUserAddressException</code> if it could not be found.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param isNatAddress the is nat address
	 * @return the matching quotations user address
	 * @throws NoSuchQuotationsUserAddressException if a matching quotations user address could not be found
	 */
	public QuotationsUserAddress findByQuotationIdDriverId(
			long quotationId, long driverId, boolean isNatAddress)
		throws NoSuchQuotationsUserAddressException;

	/**
	 * Returns the quotations user address where quotationId = &#63; and driverId = &#63; and isNatAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param isNatAddress the is nat address
	 * @return the matching quotations user address, or <code>null</code> if a matching quotations user address could not be found
	 */
	public QuotationsUserAddress fetchByQuotationIdDriverId(
		long quotationId, long driverId, boolean isNatAddress);

	/**
	 * Returns the quotations user address where quotationId = &#63; and driverId = &#63; and isNatAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param isNatAddress the is nat address
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotations user address, or <code>null</code> if a matching quotations user address could not be found
	 */
	public QuotationsUserAddress fetchByQuotationIdDriverId(
		long quotationId, long driverId, boolean isNatAddress,
		boolean useFinderCache);

	/**
	 * Removes the quotations user address where quotationId = &#63; and driverId = &#63; and isNatAddress = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param isNatAddress the is nat address
	 * @return the quotations user address that was removed
	 */
	public QuotationsUserAddress removeByQuotationIdDriverId(
			long quotationId, long driverId, boolean isNatAddress)
		throws NoSuchQuotationsUserAddressException;

	/**
	 * Returns the number of quotations user addresses where quotationId = &#63; and driverId = &#63; and isNatAddress = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param isNatAddress the is nat address
	 * @return the number of matching quotations user addresses
	 */
	public int countByQuotationIdDriverId(
		long quotationId, long driverId, boolean isNatAddress);

	/**
	 * Caches the quotations user address in the entity cache if it is enabled.
	 *
	 * @param quotationsUserAddress the quotations user address
	 */
	public void cacheResult(QuotationsUserAddress quotationsUserAddress);

	/**
	 * Caches the quotations user addresses in the entity cache if it is enabled.
	 *
	 * @param quotationsUserAddresses the quotations user addresses
	 */
	public void cacheResult(
		java.util.List<QuotationsUserAddress> quotationsUserAddresses);

	/**
	 * Creates a new quotations user address with the primary key. Does not add the quotations user address to the database.
	 *
	 * @param userAddressId the primary key for the new quotations user address
	 * @return the new quotations user address
	 */
	public QuotationsUserAddress create(long userAddressId);

	/**
	 * Removes the quotations user address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userAddressId the primary key of the quotations user address
	 * @return the quotations user address that was removed
	 * @throws NoSuchQuotationsUserAddressException if a quotations user address with the primary key could not be found
	 */
	public QuotationsUserAddress remove(long userAddressId)
		throws NoSuchQuotationsUserAddressException;

	public QuotationsUserAddress updateImpl(
		QuotationsUserAddress quotationsUserAddress);

	/**
	 * Returns the quotations user address with the primary key or throws a <code>NoSuchQuotationsUserAddressException</code> if it could not be found.
	 *
	 * @param userAddressId the primary key of the quotations user address
	 * @return the quotations user address
	 * @throws NoSuchQuotationsUserAddressException if a quotations user address with the primary key could not be found
	 */
	public QuotationsUserAddress findByPrimaryKey(long userAddressId)
		throws NoSuchQuotationsUserAddressException;

	/**
	 * Returns the quotations user address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userAddressId the primary key of the quotations user address
	 * @return the quotations user address, or <code>null</code> if a quotations user address with the primary key could not be found
	 */
	public QuotationsUserAddress fetchByPrimaryKey(long userAddressId);

	/**
	 * Returns all the quotations user addresses.
	 *
	 * @return the quotations user addresses
	 */
	public java.util.List<QuotationsUserAddress> findAll();

	/**
	 * Returns a range of all the quotations user addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsUserAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations user addresses
	 * @param end the upper bound of the range of quotations user addresses (not inclusive)
	 * @return the range of quotations user addresses
	 */
	public java.util.List<QuotationsUserAddress> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the quotations user addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsUserAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations user addresses
	 * @param end the upper bound of the range of quotations user addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotations user addresses
	 */
	public java.util.List<QuotationsUserAddress> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationsUserAddress>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotations user addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsUserAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations user addresses
	 * @param end the upper bound of the range of quotations user addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotations user addresses
	 */
	public java.util.List<QuotationsUserAddress> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationsUserAddress>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the quotations user addresses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of quotations user addresses.
	 *
	 * @return the number of quotations user addresses
	 */
	public int countAll();

}