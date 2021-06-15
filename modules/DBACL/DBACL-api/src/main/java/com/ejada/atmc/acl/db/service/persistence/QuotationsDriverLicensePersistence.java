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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationsDriverLicenseException;
import com.ejada.atmc.acl.db.model.QuotationsDriverLicense;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the quotations driver license service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsDriverLicenseUtil
 * @generated
 */
@ProviderType
public interface QuotationsDriverLicensePersistence
	extends BasePersistence<QuotationsDriverLicense> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuotationsDriverLicenseUtil} to access the quotations driver license persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the quotations driver licenses where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @return the matching quotations driver licenses
	 */
	public java.util.List<QuotationsDriverLicense> findByQuotationIdDriverId(
		long quotationId, long driverId);

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
	public java.util.List<QuotationsDriverLicense> findByQuotationIdDriverId(
		long quotationId, long driverId, int start, int end);

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
	public java.util.List<QuotationsDriverLicense> findByQuotationIdDriverId(
		long quotationId, long driverId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<QuotationsDriverLicense> orderByComparator);

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
	public java.util.List<QuotationsDriverLicense> findByQuotationIdDriverId(
		long quotationId, long driverId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<QuotationsDriverLicense> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first quotations driver license in the ordered set where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations driver license
	 * @throws NoSuchQuotationsDriverLicenseException if a matching quotations driver license could not be found
	 */
	public QuotationsDriverLicense findByQuotationIdDriverId_First(
			long quotationId, long driverId,
			com.liferay.portal.kernel.util.OrderByComparator
				<QuotationsDriverLicense> orderByComparator)
		throws NoSuchQuotationsDriverLicenseException;

	/**
	 * Returns the first quotations driver license in the ordered set where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations driver license, or <code>null</code> if a matching quotations driver license could not be found
	 */
	public QuotationsDriverLicense fetchByQuotationIdDriverId_First(
		long quotationId, long driverId,
		com.liferay.portal.kernel.util.OrderByComparator
			<QuotationsDriverLicense> orderByComparator);

	/**
	 * Returns the last quotations driver license in the ordered set where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations driver license
	 * @throws NoSuchQuotationsDriverLicenseException if a matching quotations driver license could not be found
	 */
	public QuotationsDriverLicense findByQuotationIdDriverId_Last(
			long quotationId, long driverId,
			com.liferay.portal.kernel.util.OrderByComparator
				<QuotationsDriverLicense> orderByComparator)
		throws NoSuchQuotationsDriverLicenseException;

	/**
	 * Returns the last quotations driver license in the ordered set where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations driver license, or <code>null</code> if a matching quotations driver license could not be found
	 */
	public QuotationsDriverLicense fetchByQuotationIdDriverId_Last(
		long quotationId, long driverId,
		com.liferay.portal.kernel.util.OrderByComparator
			<QuotationsDriverLicense> orderByComparator);

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
	public QuotationsDriverLicense[] findByQuotationIdDriverId_PrevAndNext(
			long licenseId, long quotationId, long driverId,
			com.liferay.portal.kernel.util.OrderByComparator
				<QuotationsDriverLicense> orderByComparator)
		throws NoSuchQuotationsDriverLicenseException;

	/**
	 * Removes all the quotations driver licenses where quotationId = &#63; and driverId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 */
	public void removeByQuotationIdDriverId(long quotationId, long driverId);

	/**
	 * Returns the number of quotations driver licenses where quotationId = &#63; and driverId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @return the number of matching quotations driver licenses
	 */
	public int countByQuotationIdDriverId(long quotationId, long driverId);

	/**
	 * Caches the quotations driver license in the entity cache if it is enabled.
	 *
	 * @param quotationsDriverLicense the quotations driver license
	 */
	public void cacheResult(QuotationsDriverLicense quotationsDriverLicense);

	/**
	 * Caches the quotations driver licenses in the entity cache if it is enabled.
	 *
	 * @param quotationsDriverLicenses the quotations driver licenses
	 */
	public void cacheResult(
		java.util.List<QuotationsDriverLicense> quotationsDriverLicenses);

	/**
	 * Creates a new quotations driver license with the primary key. Does not add the quotations driver license to the database.
	 *
	 * @param licenseId the primary key for the new quotations driver license
	 * @return the new quotations driver license
	 */
	public QuotationsDriverLicense create(long licenseId);

	/**
	 * Removes the quotations driver license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param licenseId the primary key of the quotations driver license
	 * @return the quotations driver license that was removed
	 * @throws NoSuchQuotationsDriverLicenseException if a quotations driver license with the primary key could not be found
	 */
	public QuotationsDriverLicense remove(long licenseId)
		throws NoSuchQuotationsDriverLicenseException;

	public QuotationsDriverLicense updateImpl(
		QuotationsDriverLicense quotationsDriverLicense);

	/**
	 * Returns the quotations driver license with the primary key or throws a <code>NoSuchQuotationsDriverLicenseException</code> if it could not be found.
	 *
	 * @param licenseId the primary key of the quotations driver license
	 * @return the quotations driver license
	 * @throws NoSuchQuotationsDriverLicenseException if a quotations driver license with the primary key could not be found
	 */
	public QuotationsDriverLicense findByPrimaryKey(long licenseId)
		throws NoSuchQuotationsDriverLicenseException;

	/**
	 * Returns the quotations driver license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param licenseId the primary key of the quotations driver license
	 * @return the quotations driver license, or <code>null</code> if a quotations driver license with the primary key could not be found
	 */
	public QuotationsDriverLicense fetchByPrimaryKey(long licenseId);

	/**
	 * Returns all the quotations driver licenses.
	 *
	 * @return the quotations driver licenses
	 */
	public java.util.List<QuotationsDriverLicense> findAll();

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
	public java.util.List<QuotationsDriverLicense> findAll(int start, int end);

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
	public java.util.List<QuotationsDriverLicense> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<QuotationsDriverLicense> orderByComparator);

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
	public java.util.List<QuotationsDriverLicense> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<QuotationsDriverLicense> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the quotations driver licenses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of quotations driver licenses.
	 *
	 * @return the number of quotations driver licenses
	 */
	public int countAll();

}