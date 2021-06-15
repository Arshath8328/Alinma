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

import com.ejada.atmc.acl.db.model.QuotationDriverseEndors;

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
 * The persistence utility for the quotation driverse endors service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.QuotationDriverseEndorsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationDriverseEndorsPersistence
 * @generated
 */
public class QuotationDriverseEndorsUtil {

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
		QuotationDriverseEndors quotationDriverseEndors) {

		getPersistence().clearCache(quotationDriverseEndors);
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
	public static Map<Serializable, QuotationDriverseEndors> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<QuotationDriverseEndors> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuotationDriverseEndors> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuotationDriverseEndors> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QuotationDriverseEndors> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QuotationDriverseEndors update(
		QuotationDriverseEndors quotationDriverseEndors) {

		return getPersistence().update(quotationDriverseEndors);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QuotationDriverseEndors update(
		QuotationDriverseEndors quotationDriverseEndors,
		ServiceContext serviceContext) {

		return getPersistence().update(quotationDriverseEndors, serviceContext);
	}

	/**
	 * Returns all the quotation driverse endorses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching quotation driverse endorses
	 */
	public static List<QuotationDriverseEndors> findByStatus(String status) {
		return getPersistence().findByStatus(status);
	}

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
	public static List<QuotationDriverseEndors> findByStatus(
		String status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

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
	public static List<QuotationDriverseEndors> findByStatus(
		String status, int start, int end,
		OrderByComparator<QuotationDriverseEndors> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

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
	public static List<QuotationDriverseEndors> findByStatus(
		String status, int start, int end,
		OrderByComparator<QuotationDriverseEndors> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first quotation driverse endors in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a matching quotation driverse endors could not be found
	 */
	public static QuotationDriverseEndors findByStatus_First(
			String status,
			OrderByComparator<QuotationDriverseEndors> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationDriverseEndorsException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first quotation driverse endors in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	public static QuotationDriverseEndors fetchByStatus_First(
		String status,
		OrderByComparator<QuotationDriverseEndors> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last quotation driverse endors in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a matching quotation driverse endors could not be found
	 */
	public static QuotationDriverseEndors findByStatus_Last(
			String status,
			OrderByComparator<QuotationDriverseEndors> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationDriverseEndorsException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last quotation driverse endors in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	public static QuotationDriverseEndors fetchByStatus_Last(
		String status,
		OrderByComparator<QuotationDriverseEndors> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the quotation driverse endorses before and after the current quotation driverse endors in the ordered set where status = &#63;.
	 *
	 * @param addDriverId the primary key of the current quotation driverse endors
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a quotation driverse endors with the primary key could not be found
	 */
	public static QuotationDriverseEndors[] findByStatus_PrevAndNext(
			long addDriverId, String status,
			OrderByComparator<QuotationDriverseEndors> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationDriverseEndorsException {

		return getPersistence().findByStatus_PrevAndNext(
			addDriverId, status, orderByComparator);
	}

	/**
	 * Removes all the quotation driverse endorses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(String status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of quotation driverse endorses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching quotation driverse endorses
	 */
	public static int countByStatus(String status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns the quotation driverse endors where status = &#63; or throws a <code>NoSuchQuotationDriverseEndorsException</code> if it could not be found.
	 *
	 * @param status the status
	 * @return the matching quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a matching quotation driverse endors could not be found
	 */
	public static QuotationDriverseEndors findByeachStatus(String status)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationDriverseEndorsException {

		return getPersistence().findByeachStatus(status);
	}

	/**
	 * Returns the quotation driverse endors where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param status the status
	 * @return the matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	public static QuotationDriverseEndors fetchByeachStatus(String status) {
		return getPersistence().fetchByeachStatus(status);
	}

	/**
	 * Returns the quotation driverse endors where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	public static QuotationDriverseEndors fetchByeachStatus(
		String status, boolean useFinderCache) {

		return getPersistence().fetchByeachStatus(status, useFinderCache);
	}

	/**
	 * Removes the quotation driverse endors where status = &#63; from the database.
	 *
	 * @param status the status
	 * @return the quotation driverse endors that was removed
	 */
	public static QuotationDriverseEndors removeByeachStatus(String status)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationDriverseEndorsException {

		return getPersistence().removeByeachStatus(status);
	}

	/**
	 * Returns the number of quotation driverse endorses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching quotation driverse endorses
	 */
	public static int countByeachStatus(String status) {
		return getPersistence().countByeachStatus(status);
	}

	/**
	 * Returns the quotation driverse endors where driverId = &#63; or throws a <code>NoSuchQuotationDriverseEndorsException</code> if it could not be found.
	 *
	 * @param driverId the driver ID
	 * @return the matching quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a matching quotation driverse endors could not be found
	 */
	public static QuotationDriverseEndors findByDriverId(String driverId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationDriverseEndorsException {

		return getPersistence().findByDriverId(driverId);
	}

	/**
	 * Returns the quotation driverse endors where driverId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param driverId the driver ID
	 * @return the matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	public static QuotationDriverseEndors fetchByDriverId(String driverId) {
		return getPersistence().fetchByDriverId(driverId);
	}

	/**
	 * Returns the quotation driverse endors where driverId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param driverId the driver ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	public static QuotationDriverseEndors fetchByDriverId(
		String driverId, boolean useFinderCache) {

		return getPersistence().fetchByDriverId(driverId, useFinderCache);
	}

	/**
	 * Removes the quotation driverse endors where driverId = &#63; from the database.
	 *
	 * @param driverId the driver ID
	 * @return the quotation driverse endors that was removed
	 */
	public static QuotationDriverseEndors removeByDriverId(String driverId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationDriverseEndorsException {

		return getPersistence().removeByDriverId(driverId);
	}

	/**
	 * Returns the number of quotation driverse endorses where driverId = &#63;.
	 *
	 * @param driverId the driver ID
	 * @return the number of matching quotation driverse endorses
	 */
	public static int countByDriverId(String driverId) {
		return getPersistence().countByDriverId(driverId);
	}

	/**
	 * Returns the quotation driverse endors where policyNumber = &#63; or throws a <code>NoSuchQuotationDriverseEndorsException</code> if it could not be found.
	 *
	 * @param policyNumber the policy number
	 * @return the matching quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a matching quotation driverse endors could not be found
	 */
	public static QuotationDriverseEndors findBypolicyNumber(
			String policyNumber)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationDriverseEndorsException {

		return getPersistence().findBypolicyNumber(policyNumber);
	}

	/**
	 * Returns the quotation driverse endors where policyNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyNumber the policy number
	 * @return the matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	public static QuotationDriverseEndors fetchBypolicyNumber(
		String policyNumber) {

		return getPersistence().fetchBypolicyNumber(policyNumber);
	}

	/**
	 * Returns the quotation driverse endors where policyNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyNumber the policy number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotation driverse endors, or <code>null</code> if a matching quotation driverse endors could not be found
	 */
	public static QuotationDriverseEndors fetchBypolicyNumber(
		String policyNumber, boolean useFinderCache) {

		return getPersistence().fetchBypolicyNumber(
			policyNumber, useFinderCache);
	}

	/**
	 * Removes the quotation driverse endors where policyNumber = &#63; from the database.
	 *
	 * @param policyNumber the policy number
	 * @return the quotation driverse endors that was removed
	 */
	public static QuotationDriverseEndors removeBypolicyNumber(
			String policyNumber)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationDriverseEndorsException {

		return getPersistence().removeBypolicyNumber(policyNumber);
	}

	/**
	 * Returns the number of quotation driverse endorses where policyNumber = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @return the number of matching quotation driverse endorses
	 */
	public static int countBypolicyNumber(String policyNumber) {
		return getPersistence().countBypolicyNumber(policyNumber);
	}

	/**
	 * Caches the quotation driverse endors in the entity cache if it is enabled.
	 *
	 * @param quotationDriverseEndors the quotation driverse endors
	 */
	public static void cacheResult(
		QuotationDriverseEndors quotationDriverseEndors) {

		getPersistence().cacheResult(quotationDriverseEndors);
	}

	/**
	 * Caches the quotation driverse endorses in the entity cache if it is enabled.
	 *
	 * @param quotationDriverseEndorses the quotation driverse endorses
	 */
	public static void cacheResult(
		List<QuotationDriverseEndors> quotationDriverseEndorses) {

		getPersistence().cacheResult(quotationDriverseEndorses);
	}

	/**
	 * Creates a new quotation driverse endors with the primary key. Does not add the quotation driverse endors to the database.
	 *
	 * @param addDriverId the primary key for the new quotation driverse endors
	 * @return the new quotation driverse endors
	 */
	public static QuotationDriverseEndors create(long addDriverId) {
		return getPersistence().create(addDriverId);
	}

	/**
	 * Removes the quotation driverse endors with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addDriverId the primary key of the quotation driverse endors
	 * @return the quotation driverse endors that was removed
	 * @throws NoSuchQuotationDriverseEndorsException if a quotation driverse endors with the primary key could not be found
	 */
	public static QuotationDriverseEndors remove(long addDriverId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationDriverseEndorsException {

		return getPersistence().remove(addDriverId);
	}

	public static QuotationDriverseEndors updateImpl(
		QuotationDriverseEndors quotationDriverseEndors) {

		return getPersistence().updateImpl(quotationDriverseEndors);
	}

	/**
	 * Returns the quotation driverse endors with the primary key or throws a <code>NoSuchQuotationDriverseEndorsException</code> if it could not be found.
	 *
	 * @param addDriverId the primary key of the quotation driverse endors
	 * @return the quotation driverse endors
	 * @throws NoSuchQuotationDriverseEndorsException if a quotation driverse endors with the primary key could not be found
	 */
	public static QuotationDriverseEndors findByPrimaryKey(long addDriverId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationDriverseEndorsException {

		return getPersistence().findByPrimaryKey(addDriverId);
	}

	/**
	 * Returns the quotation driverse endors with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addDriverId the primary key of the quotation driverse endors
	 * @return the quotation driverse endors, or <code>null</code> if a quotation driverse endors with the primary key could not be found
	 */
	public static QuotationDriverseEndors fetchByPrimaryKey(long addDriverId) {
		return getPersistence().fetchByPrimaryKey(addDriverId);
	}

	/**
	 * Returns all the quotation driverse endorses.
	 *
	 * @return the quotation driverse endorses
	 */
	public static List<QuotationDriverseEndors> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<QuotationDriverseEndors> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<QuotationDriverseEndors> findAll(
		int start, int end,
		OrderByComparator<QuotationDriverseEndors> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<QuotationDriverseEndors> findAll(
		int start, int end,
		OrderByComparator<QuotationDriverseEndors> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the quotation driverse endorses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of quotation driverse endorses.
	 *
	 * @return the number of quotation driverse endorses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QuotationDriverseEndorsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QuotationDriverseEndorsPersistence, QuotationDriverseEndorsPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			QuotationDriverseEndorsPersistence.class);

		ServiceTracker
			<QuotationDriverseEndorsPersistence,
			 QuotationDriverseEndorsPersistence> serviceTracker =
				new ServiceTracker
					<QuotationDriverseEndorsPersistence,
					 QuotationDriverseEndorsPersistence>(
						 bundle.getBundleContext(),
						 QuotationDriverseEndorsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}