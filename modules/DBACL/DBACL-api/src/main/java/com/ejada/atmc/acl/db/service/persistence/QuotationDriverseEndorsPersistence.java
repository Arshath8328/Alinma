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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationDriverseEndorsException;
import com.ejada.atmc.acl.db.model.QuotationDriverseEndors;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the quotation driverse endors service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationDriverseEndorsUtil
 * @generated
 */
@ProviderType
public interface QuotationDriverseEndorsPersistence
	extends BasePersistence<QuotationDriverseEndors> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuotationDriverseEndorsUtil} to access the quotation driverse endors persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the quotation driverse endorses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching quotation driverse endorses
	 */
	public java.util.List<QuotationDriverseEndors> findByStatus(String status);

	/**
	 * Returns a range of all the quotation driverse endorses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriverseEndorsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of quotation driverse endorses
	 * @param end the upper bound of the range of quotation driverse endorses (not inclusive)
	 * @return the range of matching quotation driverse endorses
	 */
	public java.util.List<QuotationDriverseEndors> findByStatus(
		String status, int start, int end);

	/**
	 * Returns an ordered range of all the quotation driverse endorses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriverseEndorsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of quotation driverse endorses
	 * @param end the upper bound of the range of quotation driverse endorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotation driverse endorses
	 */
	public java.util.List<QuotationDriverseEndors> findByStatus(
		String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<QuotationDriverseEndors> orderByComparator);

	/**
	 * Returns an ordered range of all the quotation driverse endorses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriverseEndorsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of quotation driverse endorses
	 * @param end the upper bound of the range of quotation driverse endorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotation driverse endorses
	 */
	public java.util.List<QuotationDriverseEndors> findByStatus(
		String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<QuotationDriverseEndors> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first quotation driverse endors in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a matching quotation driverse endors could not be found
	 */
	public QuotationDriverseEndors findByStatus_First(
			String status,
			com.liferay.portal.kernel.util.OrderByComparator
				<QuotationDriverseEndors> orderByComparator)
		throws NoSuchQuotationDriverseEndorsException;

	/**
	 * Returns the first quotation driverse endors in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	public QuotationDriverseEndors fetchByStatus_First(
		String status,
		com.liferay.portal.kernel.util.OrderByComparator
			<QuotationDriverseEndors> orderByComparator);

	/**
	 * Returns the last quotation driverse endors in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a matching quotation driverse endors could not be found
	 */
	public QuotationDriverseEndors findByStatus_Last(
			String status,
			com.liferay.portal.kernel.util.OrderByComparator
				<QuotationDriverseEndors> orderByComparator)
		throws NoSuchQuotationDriverseEndorsException;

	/**
	 * Returns the last quotation driverse endors in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	public QuotationDriverseEndors fetchByStatus_Last(
		String status,
		com.liferay.portal.kernel.util.OrderByComparator
			<QuotationDriverseEndors> orderByComparator);

	/**
	 * Returns the quotation driverse endorses before and after the current quotation driverse endors in the ordered set where status = &#63;.
	 *
	 * @param addDriverId the primary key of the current quotation driverse endors
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a quotation driverse endors with the primary key could not be found
	 */
	public QuotationDriverseEndors[] findByStatus_PrevAndNext(
			long addDriverId, String status,
			com.liferay.portal.kernel.util.OrderByComparator
				<QuotationDriverseEndors> orderByComparator)
		throws NoSuchQuotationDriverseEndorsException;

	/**
	 * Removes all the quotation driverse endorses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(String status);

	/**
	 * Returns the number of quotation driverse endorses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching quotation driverse endorses
	 */
	public int countByStatus(String status);

	/**
	 * Returns the quotation driverse endors where status = &#63; or throws a <code>NoSuchQuotationDriverseEndorsException</code> if it could not be found.
	 *
	 * @param status the status
	 * @return the matching quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a matching quotation driverse endors could not be found
	 */
	public QuotationDriverseEndors findByeachStatus(String status)
		throws NoSuchQuotationDriverseEndorsException;

	/**
	 * Returns the quotation driverse endors where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param status the status
	 * @return the matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	public QuotationDriverseEndors fetchByeachStatus(String status);

	/**
	 * Returns the quotation driverse endors where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	public QuotationDriverseEndors fetchByeachStatus(
		String status, boolean useFinderCache);

	/**
	 * Removes the quotation driverse endors where status = &#63; from the database.
	 *
	 * @param status the status
	 * @return the quotation driverse endors that was removed
	 */
	public QuotationDriverseEndors removeByeachStatus(String status)
		throws NoSuchQuotationDriverseEndorsException;

	/**
	 * Returns the number of quotation driverse endorses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching quotation driverse endorses
	 */
	public int countByeachStatus(String status);

	/**
	 * Returns the quotation driverse endors where driverId = &#63; or throws a <code>NoSuchQuotationDriverseEndorsException</code> if it could not be found.
	 *
	 * @param driverId the driver ID
	 * @return the matching quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a matching quotation driverse endors could not be found
	 */
	public QuotationDriverseEndors findByDriverId(String driverId)
		throws NoSuchQuotationDriverseEndorsException;

	/**
	 * Returns the quotation driverse endors where driverId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param driverId the driver ID
	 * @return the matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	public QuotationDriverseEndors fetchByDriverId(String driverId);

	/**
	 * Returns the quotation driverse endors where driverId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param driverId the driver ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	public QuotationDriverseEndors fetchByDriverId(
		String driverId, boolean useFinderCache);

	/**
	 * Removes the quotation driverse endors where driverId = &#63; from the database.
	 *
	 * @param driverId the driver ID
	 * @return the quotation driverse endors that was removed
	 */
	public QuotationDriverseEndors removeByDriverId(String driverId)
		throws NoSuchQuotationDriverseEndorsException;

	/**
	 * Returns the number of quotation driverse endorses where driverId = &#63;.
	 *
	 * @param driverId the driver ID
	 * @return the number of matching quotation driverse endorses
	 */
	public int countByDriverId(String driverId);

	/**
	 * Returns the quotation driverse endors where policyNumber = &#63; or throws a <code>NoSuchQuotationDriverseEndorsException</code> if it could not be found.
	 *
	 * @param policyNumber the policy number
	 * @return the matching quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a matching quotation driverse endors could not be found
	 */
	public QuotationDriverseEndors findBypolicyNumber(String policyNumber)
		throws NoSuchQuotationDriverseEndorsException;

	/**
	 * Returns the quotation driverse endors where policyNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyNumber the policy number
	 * @return the matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	public QuotationDriverseEndors fetchBypolicyNumber(String policyNumber);

	/**
	 * Returns the quotation driverse endors where policyNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyNumber the policy number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	public QuotationDriverseEndors fetchBypolicyNumber(
		String policyNumber, boolean useFinderCache);

	/**
	 * Removes the quotation driverse endors where policyNumber = &#63; from the database.
	 *
	 * @param policyNumber the policy number
	 * @return the quotation driverse endors that was removed
	 */
	public QuotationDriverseEndors removeBypolicyNumber(String policyNumber)
		throws NoSuchQuotationDriverseEndorsException;

	/**
	 * Returns the number of quotation driverse endorses where policyNumber = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @return the number of matching quotation driverse endorses
	 */
	public int countBypolicyNumber(String policyNumber);

	/**
	 * Caches the quotation driverse endors in the entity cache if it is enabled.
	 *
	 * @param quotationDriverseEndors the quotation driverse endors
	 */
	public void cacheResult(QuotationDriverseEndors quotationDriverseEndors);

	/**
	 * Caches the quotation driverse endorses in the entity cache if it is enabled.
	 *
	 * @param quotationDriverseEndorses the quotation driverse endorses
	 */
	public void cacheResult(
		java.util.List<QuotationDriverseEndors> quotationDriverseEndorses);

	/**
	 * Creates a new quotation driverse endors with the primary key. Does not add the quotation driverse endors to the database.
	 *
	 * @param addDriverId the primary key for the new quotation driverse endors
	 * @return the new quotation driverse endors
	 */
	public QuotationDriverseEndors create(long addDriverId);

	/**
	 * Removes the quotation driverse endors with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addDriverId the primary key of the quotation driverse endors
	 * @return the quotation driverse endors that was removed
	 * @throws NoSuchQuotationDriverseEndorsException if a quotation driverse endors with the primary key could not be found
	 */
	public QuotationDriverseEndors remove(long addDriverId)
		throws NoSuchQuotationDriverseEndorsException;

	public QuotationDriverseEndors updateImpl(
		QuotationDriverseEndors quotationDriverseEndors);

	/**
	 * Returns the quotation driverse endors with the primary key or throws a <code>NoSuchQuotationDriverseEndorsException</code> if it could not be found.
	 *
	 * @param addDriverId the primary key of the quotation driverse endors
	 * @return the quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a quotation driverse endors with the primary key could not be found
	 */
	public QuotationDriverseEndors findByPrimaryKey(long addDriverId)
		throws NoSuchQuotationDriverseEndorsException;

	/**
	 * Returns the quotation driverse endors with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addDriverId the primary key of the quotation driverse endors
	 * @return the quotation driverse endors, or <code>null</code> if a quotation driverse endors with the primary key could not be found
	 */
	public QuotationDriverseEndors fetchByPrimaryKey(long addDriverId);

	/**
	 * Returns all the quotation driverse endorses.
	 *
	 * @return the quotation driverse endorses
	 */
	public java.util.List<QuotationDriverseEndors> findAll();

	/**
	 * Returns a range of all the quotation driverse endorses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriverseEndorsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation driverse endorses
	 * @param end the upper bound of the range of quotation driverse endorses (not inclusive)
	 * @return the range of quotation driverse endorses
	 */
	public java.util.List<QuotationDriverseEndors> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the quotation driverse endorses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriverseEndorsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation driverse endorses
	 * @param end the upper bound of the range of quotation driverse endorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotation driverse endorses
	 */
	public java.util.List<QuotationDriverseEndors> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<QuotationDriverseEndors> orderByComparator);

	/**
	 * Returns an ordered range of all the quotation driverse endorses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationDriverseEndorsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation driverse endorses
	 * @param end the upper bound of the range of quotation driverse endorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotation driverse endorses
	 */
	public java.util.List<QuotationDriverseEndors> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<QuotationDriverseEndors> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the quotation driverse endorses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of quotation driverse endorses.
	 *
	 * @return the number of quotation driverse endorses
	 */
	public int countAll();

}