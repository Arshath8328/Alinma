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

import com.ejada.atmc.acl.db.model.PolicyCancelation;

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
 * The persistence utility for the policy cancelation service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.PolicyCancelationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyCancelationPersistence
 * @generated
 */
public class PolicyCancelationUtil {

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
	public static void clearCache(PolicyCancelation policyCancelation) {
		getPersistence().clearCache(policyCancelation);
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
	public static Map<Serializable, PolicyCancelation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PolicyCancelation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PolicyCancelation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PolicyCancelation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PolicyCancelation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PolicyCancelation update(
		PolicyCancelation policyCancelation) {

		return getPersistence().update(policyCancelation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PolicyCancelation update(
		PolicyCancelation policyCancelation, ServiceContext serviceContext) {

		return getPersistence().update(policyCancelation, serviceContext);
	}

	/**
	 * Returns the policy cancelation where policyNumber = &#63; or throws a <code>NoSuchPolicyCancelationException</code> if it could not be found.
	 *
	 * @param policyNumber the policy number
	 * @return the matching policy cancelation
	 * @throws NoSuchPolicyCancelationException if a matching policy cancelation could not be found
	 */
	public static PolicyCancelation findBypolicyNum(String policyNumber)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return getPersistence().findBypolicyNum(policyNumber);
	}

	/**
	 * Returns the policy cancelation where policyNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyNumber the policy number
	 * @return the matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	public static PolicyCancelation fetchBypolicyNum(String policyNumber) {
		return getPersistence().fetchBypolicyNum(policyNumber);
	}

	/**
	 * Returns the policy cancelation where policyNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyNumber the policy number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	public static PolicyCancelation fetchBypolicyNum(
		String policyNumber, boolean useFinderCache) {

		return getPersistence().fetchBypolicyNum(policyNumber, useFinderCache);
	}

	/**
	 * Removes the policy cancelation where policyNumber = &#63; from the database.
	 *
	 * @param policyNumber the policy number
	 * @return the policy cancelation that was removed
	 */
	public static PolicyCancelation removeBypolicyNum(String policyNumber)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return getPersistence().removeBypolicyNum(policyNumber);
	}

	/**
	 * Returns the number of policy cancelations where policyNumber = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @return the number of matching policy cancelations
	 */
	public static int countBypolicyNum(String policyNumber) {
		return getPersistence().countBypolicyNum(policyNumber);
	}

	/**
	 * Returns all the policy cancelations where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @return the matching policy cancelations
	 */
	public static List<PolicyCancelation> findByinsuredId(String insuredId) {
		return getPersistence().findByinsuredId(insuredId);
	}

	/**
	 * Returns a range of all the policy cancelations where insuredId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @return the range of matching policy cancelations
	 */
	public static List<PolicyCancelation> findByinsuredId(
		String insuredId, int start, int end) {

		return getPersistence().findByinsuredId(insuredId, start, end);
	}

	/**
	 * Returns an ordered range of all the policy cancelations where insuredId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy cancelations
	 */
	public static List<PolicyCancelation> findByinsuredId(
		String insuredId, int start, int end,
		OrderByComparator<PolicyCancelation> orderByComparator) {

		return getPersistence().findByinsuredId(
			insuredId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy cancelations where insuredId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy cancelations
	 */
	public static List<PolicyCancelation> findByinsuredId(
		String insuredId, int start, int end,
		OrderByComparator<PolicyCancelation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByinsuredId(
			insuredId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first policy cancelation in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy cancelation
	 * @throws NoSuchPolicyCancelationException if a matching policy cancelation could not be found
	 */
	public static PolicyCancelation findByinsuredId_First(
			String insuredId,
			OrderByComparator<PolicyCancelation> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return getPersistence().findByinsuredId_First(
			insuredId, orderByComparator);
	}

	/**
	 * Returns the first policy cancelation in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	public static PolicyCancelation fetchByinsuredId_First(
		String insuredId,
		OrderByComparator<PolicyCancelation> orderByComparator) {

		return getPersistence().fetchByinsuredId_First(
			insuredId, orderByComparator);
	}

	/**
	 * Returns the last policy cancelation in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy cancelation
	 * @throws NoSuchPolicyCancelationException if a matching policy cancelation could not be found
	 */
	public static PolicyCancelation findByinsuredId_Last(
			String insuredId,
			OrderByComparator<PolicyCancelation> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return getPersistence().findByinsuredId_Last(
			insuredId, orderByComparator);
	}

	/**
	 * Returns the last policy cancelation in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	public static PolicyCancelation fetchByinsuredId_Last(
		String insuredId,
		OrderByComparator<PolicyCancelation> orderByComparator) {

		return getPersistence().fetchByinsuredId_Last(
			insuredId, orderByComparator);
	}

	/**
	 * Returns the policy cancelations before and after the current policy cancelation in the ordered set where insuredId = &#63;.
	 *
	 * @param Id the primary key of the current policy cancelation
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy cancelation
	 * @throws NoSuchPolicyCancelationException if a policy cancelation with the primary key could not be found
	 */
	public static PolicyCancelation[] findByinsuredId_PrevAndNext(
			String Id, String insuredId,
			OrderByComparator<PolicyCancelation> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return getPersistence().findByinsuredId_PrevAndNext(
			Id, insuredId, orderByComparator);
	}

	/**
	 * Removes all the policy cancelations where insuredId = &#63; from the database.
	 *
	 * @param insuredId the insured ID
	 */
	public static void removeByinsuredId(String insuredId) {
		getPersistence().removeByinsuredId(insuredId);
	}

	/**
	 * Returns the number of policy cancelations where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @return the number of matching policy cancelations
	 */
	public static int countByinsuredId(String insuredId) {
		return getPersistence().countByinsuredId(insuredId);
	}

	/**
	 * Returns all the policy cancelations where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching policy cancelations
	 */
	public static List<PolicyCancelation> findBystatusAll(String status) {
		return getPersistence().findBystatusAll(status);
	}

	/**
	 * Returns a range of all the policy cancelations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @return the range of matching policy cancelations
	 */
	public static List<PolicyCancelation> findBystatusAll(
		String status, int start, int end) {

		return getPersistence().findBystatusAll(status, start, end);
	}

	/**
	 * Returns an ordered range of all the policy cancelations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy cancelations
	 */
	public static List<PolicyCancelation> findBystatusAll(
		String status, int start, int end,
		OrderByComparator<PolicyCancelation> orderByComparator) {

		return getPersistence().findBystatusAll(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy cancelations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy cancelations
	 */
	public static List<PolicyCancelation> findBystatusAll(
		String status, int start, int end,
		OrderByComparator<PolicyCancelation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBystatusAll(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first policy cancelation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy cancelation
	 * @throws NoSuchPolicyCancelationException if a matching policy cancelation could not be found
	 */
	public static PolicyCancelation findBystatusAll_First(
			String status,
			OrderByComparator<PolicyCancelation> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return getPersistence().findBystatusAll_First(
			status, orderByComparator);
	}

	/**
	 * Returns the first policy cancelation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	public static PolicyCancelation fetchBystatusAll_First(
		String status, OrderByComparator<PolicyCancelation> orderByComparator) {

		return getPersistence().fetchBystatusAll_First(
			status, orderByComparator);
	}

	/**
	 * Returns the last policy cancelation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy cancelation
	 * @throws NoSuchPolicyCancelationException if a matching policy cancelation could not be found
	 */
	public static PolicyCancelation findBystatusAll_Last(
			String status,
			OrderByComparator<PolicyCancelation> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return getPersistence().findBystatusAll_Last(status, orderByComparator);
	}

	/**
	 * Returns the last policy cancelation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	public static PolicyCancelation fetchBystatusAll_Last(
		String status, OrderByComparator<PolicyCancelation> orderByComparator) {

		return getPersistence().fetchBystatusAll_Last(
			status, orderByComparator);
	}

	/**
	 * Returns the policy cancelations before and after the current policy cancelation in the ordered set where status = &#63;.
	 *
	 * @param Id the primary key of the current policy cancelation
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy cancelation
	 * @throws NoSuchPolicyCancelationException if a policy cancelation with the primary key could not be found
	 */
	public static PolicyCancelation[] findBystatusAll_PrevAndNext(
			String Id, String status,
			OrderByComparator<PolicyCancelation> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return getPersistence().findBystatusAll_PrevAndNext(
			Id, status, orderByComparator);
	}

	/**
	 * Removes all the policy cancelations where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeBystatusAll(String status) {
		getPersistence().removeBystatusAll(status);
	}

	/**
	 * Returns the number of policy cancelations where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching policy cancelations
	 */
	public static int countBystatusAll(String status) {
		return getPersistence().countBystatusAll(status);
	}

	/**
	 * Returns the policy cancelation where status = &#63; or throws a <code>NoSuchPolicyCancelationException</code> if it could not be found.
	 *
	 * @param status the status
	 * @return the matching policy cancelation
	 * @throws NoSuchPolicyCancelationException if a matching policy cancelation could not be found
	 */
	public static PolicyCancelation findBystatus(String status)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return getPersistence().findBystatus(status);
	}

	/**
	 * Returns the policy cancelation where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param status the status
	 * @return the matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	public static PolicyCancelation fetchBystatus(String status) {
		return getPersistence().fetchBystatus(status);
	}

	/**
	 * Returns the policy cancelation where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	public static PolicyCancelation fetchBystatus(
		String status, boolean useFinderCache) {

		return getPersistence().fetchBystatus(status, useFinderCache);
	}

	/**
	 * Removes the policy cancelation where status = &#63; from the database.
	 *
	 * @param status the status
	 * @return the policy cancelation that was removed
	 */
	public static PolicyCancelation removeBystatus(String status)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return getPersistence().removeBystatus(status);
	}

	/**
	 * Returns the number of policy cancelations where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching policy cancelations
	 */
	public static int countBystatus(String status) {
		return getPersistence().countBystatus(status);
	}

	/**
	 * Caches the policy cancelation in the entity cache if it is enabled.
	 *
	 * @param policyCancelation the policy cancelation
	 */
	public static void cacheResult(PolicyCancelation policyCancelation) {
		getPersistence().cacheResult(policyCancelation);
	}

	/**
	 * Caches the policy cancelations in the entity cache if it is enabled.
	 *
	 * @param policyCancelations the policy cancelations
	 */
	public static void cacheResult(List<PolicyCancelation> policyCancelations) {
		getPersistence().cacheResult(policyCancelations);
	}

	/**
	 * Creates a new policy cancelation with the primary key. Does not add the policy cancelation to the database.
	 *
	 * @param Id the primary key for the new policy cancelation
	 * @return the new policy cancelation
	 */
	public static PolicyCancelation create(String Id) {
		return getPersistence().create(Id);
	}

	/**
	 * Removes the policy cancelation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the policy cancelation
	 * @return the policy cancelation that was removed
	 * @throws NoSuchPolicyCancelationException if a policy cancelation with the primary key could not be found
	 */
	public static PolicyCancelation remove(String Id)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return getPersistence().remove(Id);
	}

	public static PolicyCancelation updateImpl(
		PolicyCancelation policyCancelation) {

		return getPersistence().updateImpl(policyCancelation);
	}

	/**
	 * Returns the policy cancelation with the primary key or throws a <code>NoSuchPolicyCancelationException</code> if it could not be found.
	 *
	 * @param Id the primary key of the policy cancelation
	 * @return the policy cancelation
	 * @throws NoSuchPolicyCancelationException if a policy cancelation with the primary key could not be found
	 */
	public static PolicyCancelation findByPrimaryKey(String Id)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return getPersistence().findByPrimaryKey(Id);
	}

	/**
	 * Returns the policy cancelation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the policy cancelation
	 * @return the policy cancelation, or <code>null</code> if a policy cancelation with the primary key could not be found
	 */
	public static PolicyCancelation fetchByPrimaryKey(String Id) {
		return getPersistence().fetchByPrimaryKey(Id);
	}

	/**
	 * Returns all the policy cancelations.
	 *
	 * @return the policy cancelations
	 */
	public static List<PolicyCancelation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the policy cancelations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @return the range of policy cancelations
	 */
	public static List<PolicyCancelation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the policy cancelations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy cancelations
	 */
	public static List<PolicyCancelation> findAll(
		int start, int end,
		OrderByComparator<PolicyCancelation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy cancelations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy cancelations
	 */
	public static List<PolicyCancelation> findAll(
		int start, int end,
		OrderByComparator<PolicyCancelation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the policy cancelations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of policy cancelations.
	 *
	 * @return the number of policy cancelations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PolicyCancelationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PolicyCancelationPersistence, PolicyCancelationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PolicyCancelationPersistence.class);

		ServiceTracker
			<PolicyCancelationPersistence, PolicyCancelationPersistence>
				serviceTracker =
					new ServiceTracker
						<PolicyCancelationPersistence,
						 PolicyCancelationPersistence>(
							 bundle.getBundleContext(),
							 PolicyCancelationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}