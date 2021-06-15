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

import com.ejada.atmc.acl.db.model.QuotationsDriverLicense;

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
 * The persistence utility for the quotations driver license service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.QuotationsDriverLicensePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsDriverLicensePersistence
 * @generated
 */
public class QuotationsDriverLicenseUtil {

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
	public static void clearCache(
		QuotationsDriverLicense quotationsDriverLicense) {

		getPersistence().clearCache(quotationsDriverLicense);
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
	public static Map<Serializable, QuotationsDriverLicense> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<QuotationsDriverLicense> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuotationsDriverLicense> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuotationsDriverLicense> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QuotationsDriverLicense> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QuotationsDriverLicense update(
		QuotationsDriverLicense quotationsDriverLicense) {

		return getPersistence().update(quotationsDriverLicense);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QuotationsDriverLicense update(
		QuotationsDriverLicense quotationsDriverLicense,
		ServiceContext serviceContext) {

		return getPersistence().update(quotationsDriverLicense, serviceContext);
	}

	/**
	 * Returns all the quotations driver licenses where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @return the matching quotations driver licenses
	 */
	public static List<QuotationsDriverLicense> findByQuotationIdDriverId(
		long quotationId, long driverId) {

		return getPersistence().findByQuotationIdDriverId(
			quotationId, driverId);
	}

	/**
	 * Returns a range of all the quotations driver licenses where quotationId = &#63; and driverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsDriverLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param start the lower bound of the range of quotations driver licenses
	 * @param end the upper bound of the range of quotations driver licenses (not inclusive)
	 * @return the range of matching quotations driver licenses
	 */
	public static List<QuotationsDriverLicense> findByQuotationIdDriverId(
		long quotationId, long driverId, int start, int end) {

		return getPersistence().findByQuotationIdDriverId(
			quotationId, driverId, start, end);
	}

	/**
	 * Returns an ordered range of all the quotations driver licenses where quotationId = &#63; and driverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsDriverLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param start the lower bound of the range of quotations driver licenses
	 * @param end the upper bound of the range of quotations driver licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotations driver licenses
	 */
	public static List<QuotationsDriverLicense> findByQuotationIdDriverId(
		long quotationId, long driverId, int start, int end,
		OrderByComparator<QuotationsDriverLicense> orderByComparator) {

		return getPersistence().findByQuotationIdDriverId(
			quotationId, driverId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the quotations driver licenses where quotationId = &#63; and driverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsDriverLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param start the lower bound of the range of quotations driver licenses
	 * @param end the upper bound of the range of quotations driver licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotations driver licenses
	 */
	public static List<QuotationsDriverLicense> findByQuotationIdDriverId(
		long quotationId, long driverId, int start, int end,
		OrderByComparator<QuotationsDriverLicense> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByQuotationIdDriverId(
			quotationId, driverId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first quotations driver license in the ordered set where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations driver license
	 * @throws NoSuchQuotationsDriverLicenseException if a matching quotations driver license could not be found
	 */
	public static QuotationsDriverLicense findByQuotationIdDriverId_First(
			long quotationId, long driverId,
			OrderByComparator<QuotationsDriverLicense> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationsDriverLicenseException {

		return getPersistence().findByQuotationIdDriverId_First(
			quotationId, driverId, orderByComparator);
	}

	/**
	 * Returns the first quotations driver license in the ordered set where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations driver license, or <code>null</code> if a matching quotations driver license could not be found
	 */
	public static QuotationsDriverLicense fetchByQuotationIdDriverId_First(
		long quotationId, long driverId,
		OrderByComparator<QuotationsDriverLicense> orderByComparator) {

		return getPersistence().fetchByQuotationIdDriverId_First(
			quotationId, driverId, orderByComparator);
	}

	/**
	 * Returns the last quotations driver license in the ordered set where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations driver license
	 * @throws NoSuchQuotationsDriverLicenseException if a matching quotations driver license could not be found
	 */
	public static QuotationsDriverLicense findByQuotationIdDriverId_Last(
			long quotationId, long driverId,
			OrderByComparator<QuotationsDriverLicense> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationsDriverLicenseException {

		return getPersistence().findByQuotationIdDriverId_Last(
			quotationId, driverId, orderByComparator);
	}

	/**
	 * Returns the last quotations driver license in the ordered set where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations driver license, or <code>null</code> if a matching quotations driver license could not be found
	 */
	public static QuotationsDriverLicense fetchByQuotationIdDriverId_Last(
		long quotationId, long driverId,
		OrderByComparator<QuotationsDriverLicense> orderByComparator) {

		return getPersistence().fetchByQuotationIdDriverId_Last(
			quotationId, driverId, orderByComparator);
	}

	/**
	 * Returns the quotations driver licenses before and after the current quotations driver license in the ordered set where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param licenseId the primary key of the current quotations driver license
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations driver license
	 * @throws NoSuchQuotationsDriverLicenseException if a quotations driver license with the primary key could not be found
	 */
	public static QuotationsDriverLicense[]
			findByQuotationIdDriverId_PrevAndNext(
				long licenseId, long quotationId, long driverId,
				OrderByComparator<QuotationsDriverLicense> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationsDriverLicenseException {

		return getPersistence().findByQuotationIdDriverId_PrevAndNext(
			licenseId, quotationId, driverId, orderByComparator);
	}

	/**
	 * Removes all the quotations driver licenses where quotationId = &#63; and driverId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 */
	public static void removeByQuotationIdDriverId(
		long quotationId, long driverId) {

		getPersistence().removeByQuotationIdDriverId(quotationId, driverId);
	}

	/**
	 * Returns the number of quotations driver licenses where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @return the number of matching quotations driver licenses
	 */
	public static int countByQuotationIdDriverId(
		long quotationId, long driverId) {

		return getPersistence().countByQuotationIdDriverId(
			quotationId, driverId);
	}

	/**
	 * Caches the quotations driver license in the entity cache if it is enabled.
	 *
	 * @param quotationsDriverLicense the quotations driver license
	 */
	public static void cacheResult(
		QuotationsDriverLicense quotationsDriverLicense) {

		getPersistence().cacheResult(quotationsDriverLicense);
	}

	/**
	 * Caches the quotations driver licenses in the entity cache if it is enabled.
	 *
	 * @param quotationsDriverLicenses the quotations driver licenses
	 */
	public static void cacheResult(
		List<QuotationsDriverLicense> quotationsDriverLicenses) {

		getPersistence().cacheResult(quotationsDriverLicenses);
	}

	/**
	 * Creates a new quotations driver license with the primary key. Does not add the quotations driver license to the database.
	 *
	 * @param licenseId the primary key for the new quotations driver license
	 * @return the new quotations driver license
	 */
	public static QuotationsDriverLicense create(long licenseId) {
		return getPersistence().create(licenseId);
	}

	/**
	 * Removes the quotations driver license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param licenseId the primary key of the quotations driver license
	 * @return the quotations driver license that was removed
	 * @throws NoSuchQuotationsDriverLicenseException if a quotations driver license with the primary key could not be found
	 */
	public static QuotationsDriverLicense remove(long licenseId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationsDriverLicenseException {

		return getPersistence().remove(licenseId);
	}

	public static QuotationsDriverLicense updateImpl(
		QuotationsDriverLicense quotationsDriverLicense) {

		return getPersistence().updateImpl(quotationsDriverLicense);
	}

	/**
	 * Returns the quotations driver license with the primary key or throws a <code>NoSuchQuotationsDriverLicenseException</code> if it could not be found.
	 *
	 * @param licenseId the primary key of the quotations driver license
	 * @return the quotations driver license
	 * @throws NoSuchQuotationsDriverLicenseException if a quotations driver license with the primary key could not be found
	 */
	public static QuotationsDriverLicense findByPrimaryKey(long licenseId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationsDriverLicenseException {

		return getPersistence().findByPrimaryKey(licenseId);
	}

	/**
	 * Returns the quotations driver license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param licenseId the primary key of the quotations driver license
	 * @return the quotations driver license, or <code>null</code> if a quotations driver license with the primary key could not be found
	 */
	public static QuotationsDriverLicense fetchByPrimaryKey(long licenseId) {
		return getPersistence().fetchByPrimaryKey(licenseId);
	}

	/**
	 * Returns all the quotations driver licenses.
	 *
	 * @return the quotations driver licenses
	 */
	public static List<QuotationsDriverLicense> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the quotations driver licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsDriverLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations driver licenses
	 * @param end the upper bound of the range of quotations driver licenses (not inclusive)
	 * @return the range of quotations driver licenses
	 */
	public static List<QuotationsDriverLicense> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the quotations driver licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsDriverLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations driver licenses
	 * @param end the upper bound of the range of quotations driver licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotations driver licenses
	 */
	public static List<QuotationsDriverLicense> findAll(
		int start, int end,
		OrderByComparator<QuotationsDriverLicense> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the quotations driver licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsDriverLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations driver licenses
	 * @param end the upper bound of the range of quotations driver licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotations driver licenses
	 */
	public static List<QuotationsDriverLicense> findAll(
		int start, int end,
		OrderByComparator<QuotationsDriverLicense> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the quotations driver licenses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of quotations driver licenses.
	 *
	 * @return the number of quotations driver licenses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QuotationsDriverLicensePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QuotationsDriverLicensePersistence, QuotationsDriverLicensePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			QuotationsDriverLicensePersistence.class);

		ServiceTracker
			<QuotationsDriverLicensePersistence,
			 QuotationsDriverLicensePersistence> serviceTracker =
				new ServiceTracker
					<QuotationsDriverLicensePersistence,
					 QuotationsDriverLicensePersistence>(
						 bundle.getBundleContext(),
						 QuotationsDriverLicensePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}