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

import com.ejada.atmc.acl.db.model.QuotationsUserAddress;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the quotations user address service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.QuotationsUserAddressPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsUserAddressPersistence
 * @generated
 */
public class QuotationsUserAddressUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(QuotationsUserAddress quotationsUserAddress) {
		getPersistence().clearCache(quotationsUserAddress);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, QuotationsUserAddress> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<QuotationsUserAddress> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuotationsUserAddress> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuotationsUserAddress> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QuotationsUserAddress> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QuotationsUserAddress update(
		QuotationsUserAddress quotationsUserAddress) {

		return getPersistence().update(quotationsUserAddress);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QuotationsUserAddress update(
		QuotationsUserAddress quotationsUserAddress,
		ServiceContext serviceContext) {

		return getPersistence().update(quotationsUserAddress, serviceContext);
	}

	/**
	 * Returns the quotations user address where quotationId = &#63; and driverId = &#63; and isNatAddress = &#63; or throws a <code>NoSuchQuotationsUserAddressException</code> if it could not be found.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param isNatAddress the is nat address
	 * @return the matching quotations user address
	 * @throws NoSuchQuotationsUserAddressException if a matching quotations user address could not be found
	 */
	public static QuotationsUserAddress findByQuotationIdDriverId(
			long quotationId, long driverId, boolean isNatAddress)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationsUserAddressException {

		return getPersistence().findByQuotationIdDriverId(
			quotationId, driverId, isNatAddress);
	}

	/**
	 * Returns the quotations user address where quotationId = &#63; and driverId = &#63; and isNatAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param isNatAddress the is nat address
	 * @return the matching quotations user address, or <code>null</code> if a matching quotations user address could not be found
	 */
	public static QuotationsUserAddress fetchByQuotationIdDriverId(
		long quotationId, long driverId, boolean isNatAddress) {

		return getPersistence().fetchByQuotationIdDriverId(
			quotationId, driverId, isNatAddress);
	}

	/**
	 * Returns the quotations user address where quotationId = &#63; and driverId = &#63; and isNatAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param isNatAddress the is nat address
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotations user address, or <code>null</code> if a matching quotations user address could not be found
	 */
	public static QuotationsUserAddress fetchByQuotationIdDriverId(
		long quotationId, long driverId, boolean isNatAddress,
		boolean useFinderCache) {

		return getPersistence().fetchByQuotationIdDriverId(
			quotationId, driverId, isNatAddress, useFinderCache);
	}

	/**
	 * Removes the quotations user address where quotationId = &#63; and driverId = &#63; and isNatAddress = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param isNatAddress the is nat address
	 * @return the quotations user address that was removed
	 */
	public static QuotationsUserAddress removeByQuotationIdDriverId(
			long quotationId, long driverId, boolean isNatAddress)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationsUserAddressException {

		return getPersistence().removeByQuotationIdDriverId(
			quotationId, driverId, isNatAddress);
	}

	/**
	 * Returns the number of quotations user addresses where quotationId = &#63; and driverId = &#63; and isNatAddress = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param isNatAddress the is nat address
	 * @return the number of matching quotations user addresses
	 */
	public static int countByQuotationIdDriverId(
		long quotationId, long driverId, boolean isNatAddress) {

		return getPersistence().countByQuotationIdDriverId(
			quotationId, driverId, isNatAddress);
	}

	/**
	 * Caches the quotations user address in the entity cache if it is enabled.
	 *
	 * @param quotationsUserAddress the quotations user address
	 */
	public static void cacheResult(
		QuotationsUserAddress quotationsUserAddress) {

		getPersistence().cacheResult(quotationsUserAddress);
	}

	/**
	 * Caches the quotations user addresses in the entity cache if it is enabled.
	 *
	 * @param quotationsUserAddresses the quotations user addresses
	 */
	public static void cacheResult(
		List<QuotationsUserAddress> quotationsUserAddresses) {

		getPersistence().cacheResult(quotationsUserAddresses);
	}

	/**
	 * Creates a new quotations user address with the primary key. Does not add the quotations user address to the database.
	 *
	 * @param userAddressId the primary key for the new quotations user address
	 * @return the new quotations user address
	 */
	public static QuotationsUserAddress create(long userAddressId) {
		return getPersistence().create(userAddressId);
	}

	/**
	 * Removes the quotations user address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userAddressId the primary key of the quotations user address
	 * @return the quotations user address that was removed
	 * @throws NoSuchQuotationsUserAddressException if a quotations user address with the primary key could not be found
	 */
	public static QuotationsUserAddress remove(long userAddressId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationsUserAddressException {

		return getPersistence().remove(userAddressId);
	}

	public static QuotationsUserAddress updateImpl(
		QuotationsUserAddress quotationsUserAddress) {

		return getPersistence().updateImpl(quotationsUserAddress);
	}

	/**
	 * Returns the quotations user address with the primary key or throws a <code>NoSuchQuotationsUserAddressException</code> if it could not be found.
	 *
	 * @param userAddressId the primary key of the quotations user address
	 * @return the quotations user address
	 * @throws NoSuchQuotationsUserAddressException if a quotations user address with the primary key could not be found
	 */
	public static QuotationsUserAddress findByPrimaryKey(long userAddressId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationsUserAddressException {

		return getPersistence().findByPrimaryKey(userAddressId);
	}

	/**
	 * Returns the quotations user address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userAddressId the primary key of the quotations user address
	 * @return the quotations user address, or <code>null</code> if a quotations user address with the primary key could not be found
	 */
	public static QuotationsUserAddress fetchByPrimaryKey(long userAddressId) {
		return getPersistence().fetchByPrimaryKey(userAddressId);
	}

	/**
	 * Returns all the quotations user addresses.
	 *
	 * @return the quotations user addresses
	 */
	public static List<QuotationsUserAddress> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<QuotationsUserAddress> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<QuotationsUserAddress> findAll(
		int start, int end,
		OrderByComparator<QuotationsUserAddress> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<QuotationsUserAddress> findAll(
		int start, int end,
		OrderByComparator<QuotationsUserAddress> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the quotations user addresses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of quotations user addresses.
	 *
	 * @return the number of quotations user addresses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QuotationsUserAddressPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QuotationsUserAddressPersistence, QuotationsUserAddressPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			QuotationsUserAddressPersistence.class);

		ServiceTracker
			<QuotationsUserAddressPersistence, QuotationsUserAddressPersistence>
				serviceTracker =
					new ServiceTracker
						<QuotationsUserAddressPersistence,
						 QuotationsUserAddressPersistence>(
							 bundle.getBundleContext(),
							 QuotationsUserAddressPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}