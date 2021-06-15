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

import com.ejada.atmc.acl.db.model.PolicyHDR;

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
 * The persistence utility for the policy hdr service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.PolicyHDRPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyHDRPersistence
 * @generated
 */
public class PolicyHDRUtil {

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
	public static void clearCache(PolicyHDR policyHDR) {
		getPersistence().clearCache(policyHDR);
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
	public static Map<Serializable, PolicyHDR> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PolicyHDR> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PolicyHDR> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PolicyHDR> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PolicyHDR> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PolicyHDR update(PolicyHDR policyHDR) {
		return getPersistence().update(policyHDR);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PolicyHDR update(
		PolicyHDR policyHDR, ServiceContext serviceContext) {

		return getPersistence().update(policyHDR, serviceContext);
	}

	/**
	 * Returns the policy hdr where policyNo = &#63; or throws a <code>NoSuchPolicyHDRException</code> if it could not be found.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	public static PolicyHDR findByPolicyNo(String policyNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException {

		return getPersistence().findByPolicyNo(policyNo);
	}

	/**
	 * Returns the policy hdr where policyNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	public static PolicyHDR fetchByPolicyNo(String policyNo) {
		return getPersistence().fetchByPolicyNo(policyNo);
	}

	/**
	 * Returns the policy hdr where policyNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyNo the policy no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	public static PolicyHDR fetchByPolicyNo(
		String policyNo, boolean useFinderCache) {

		return getPersistence().fetchByPolicyNo(policyNo, useFinderCache);
	}

	/**
	 * Removes the policy hdr where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 * @return the policy hdr that was removed
	 */
	public static PolicyHDR removeByPolicyNo(String policyNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException {

		return getPersistence().removeByPolicyNo(policyNo);
	}

	/**
	 * Returns the number of policy hdrs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching policy hdrs
	 */
	public static int countByPolicyNo(String policyNo) {
		return getPersistence().countByPolicyNo(policyNo);
	}

	/**
	 * Returns all the policy hdrs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy hdrs
	 */
	public static List<PolicyHDR> findByMULTI_POLICY(String policyNo) {
		return getPersistence().findByMULTI_POLICY(policyNo);
	}

	/**
	 * Returns a range of all the policy hdrs where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @return the range of matching policy hdrs
	 */
	public static List<PolicyHDR> findByMULTI_POLICY(
		String policyNo, int start, int end) {

		return getPersistence().findByMULTI_POLICY(policyNo, start, end);
	}

	/**
	 * Returns an ordered range of all the policy hdrs where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy hdrs
	 */
	public static List<PolicyHDR> findByMULTI_POLICY(
		String policyNo, int start, int end,
		OrderByComparator<PolicyHDR> orderByComparator) {

		return getPersistence().findByMULTI_POLICY(
			policyNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy hdrs where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy hdrs
	 */
	public static List<PolicyHDR> findByMULTI_POLICY(
		String policyNo, int start, int end,
		OrderByComparator<PolicyHDR> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByMULTI_POLICY(
			policyNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first policy hdr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	public static PolicyHDR findByMULTI_POLICY_First(
			String policyNo, OrderByComparator<PolicyHDR> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException {

		return getPersistence().findByMULTI_POLICY_First(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the first policy hdr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	public static PolicyHDR fetchByMULTI_POLICY_First(
		String policyNo, OrderByComparator<PolicyHDR> orderByComparator) {

		return getPersistence().fetchByMULTI_POLICY_First(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the last policy hdr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	public static PolicyHDR findByMULTI_POLICY_Last(
			String policyNo, OrderByComparator<PolicyHDR> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException {

		return getPersistence().findByMULTI_POLICY_Last(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the last policy hdr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	public static PolicyHDR fetchByMULTI_POLICY_Last(
		String policyNo, OrderByComparator<PolicyHDR> orderByComparator) {

		return getPersistence().fetchByMULTI_POLICY_Last(
			policyNo, orderByComparator);
	}

	/**
	 * Returns all the policy hdrs where policyNo = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param policyNos the policy nos
	 * @return the matching policy hdrs
	 */
	public static List<PolicyHDR> findByMULTI_POLICY(String[] policyNos) {
		return getPersistence().findByMULTI_POLICY(policyNos);
	}

	/**
	 * Returns a range of all the policy hdrs where policyNo = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param policyNos the policy nos
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @return the range of matching policy hdrs
	 */
	public static List<PolicyHDR> findByMULTI_POLICY(
		String[] policyNos, int start, int end) {

		return getPersistence().findByMULTI_POLICY(policyNos, start, end);
	}

	/**
	 * Returns an ordered range of all the policy hdrs where policyNo = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param policyNos the policy nos
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy hdrs
	 */
	public static List<PolicyHDR> findByMULTI_POLICY(
		String[] policyNos, int start, int end,
		OrderByComparator<PolicyHDR> orderByComparator) {

		return getPersistence().findByMULTI_POLICY(
			policyNos, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy hdrs where policyNo = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy hdrs
	 */
	public static List<PolicyHDR> findByMULTI_POLICY(
		String[] policyNos, int start, int end,
		OrderByComparator<PolicyHDR> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByMULTI_POLICY(
			policyNos, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the policy hdrs where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 */
	public static void removeByMULTI_POLICY(String policyNo) {
		getPersistence().removeByMULTI_POLICY(policyNo);
	}

	/**
	 * Returns the number of policy hdrs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching policy hdrs
	 */
	public static int countByMULTI_POLICY(String policyNo) {
		return getPersistence().countByMULTI_POLICY(policyNo);
	}

	/**
	 * Returns the number of policy hdrs where policyNo = any &#63;.
	 *
	 * @param policyNos the policy nos
	 * @return the number of matching policy hdrs
	 */
	public static int countByMULTI_POLICY(String[] policyNos) {
		return getPersistence().countByMULTI_POLICY(policyNos);
	}

	/**
	 * Returns all the policy hdrs where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @return the matching policy hdrs
	 */
	public static List<PolicyHDR> findByinsuredMobileNo(String insuredMobile) {
		return getPersistence().findByinsuredMobileNo(insuredMobile);
	}

	/**
	 * Returns a range of all the policy hdrs where insuredMobile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param insuredMobile the insured mobile
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @return the range of matching policy hdrs
	 */
	public static List<PolicyHDR> findByinsuredMobileNo(
		String insuredMobile, int start, int end) {

		return getPersistence().findByinsuredMobileNo(
			insuredMobile, start, end);
	}

	/**
	 * Returns an ordered range of all the policy hdrs where insuredMobile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param insuredMobile the insured mobile
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy hdrs
	 */
	public static List<PolicyHDR> findByinsuredMobileNo(
		String insuredMobile, int start, int end,
		OrderByComparator<PolicyHDR> orderByComparator) {

		return getPersistence().findByinsuredMobileNo(
			insuredMobile, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy hdrs where insuredMobile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param insuredMobile the insured mobile
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy hdrs
	 */
	public static List<PolicyHDR> findByinsuredMobileNo(
		String insuredMobile, int start, int end,
		OrderByComparator<PolicyHDR> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByinsuredMobileNo(
			insuredMobile, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first policy hdr in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	public static PolicyHDR findByinsuredMobileNo_First(
			String insuredMobile,
			OrderByComparator<PolicyHDR> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException {

		return getPersistence().findByinsuredMobileNo_First(
			insuredMobile, orderByComparator);
	}

	/**
	 * Returns the first policy hdr in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	public static PolicyHDR fetchByinsuredMobileNo_First(
		String insuredMobile, OrderByComparator<PolicyHDR> orderByComparator) {

		return getPersistence().fetchByinsuredMobileNo_First(
			insuredMobile, orderByComparator);
	}

	/**
	 * Returns the last policy hdr in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	public static PolicyHDR findByinsuredMobileNo_Last(
			String insuredMobile,
			OrderByComparator<PolicyHDR> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException {

		return getPersistence().findByinsuredMobileNo_Last(
			insuredMobile, orderByComparator);
	}

	/**
	 * Returns the last policy hdr in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	public static PolicyHDR fetchByinsuredMobileNo_Last(
		String insuredMobile, OrderByComparator<PolicyHDR> orderByComparator) {

		return getPersistence().fetchByinsuredMobileNo_Last(
			insuredMobile, orderByComparator);
	}

	/**
	 * Returns the policy hdrs before and after the current policy hdr in the ordered set where insuredMobile = &#63;.
	 *
	 * @param policyNo the primary key of the current policy hdr
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy hdr
	 * @throws NoSuchPolicyHDRException if a policy hdr with the primary key could not be found
	 */
	public static PolicyHDR[] findByinsuredMobileNo_PrevAndNext(
			String policyNo, String insuredMobile,
			OrderByComparator<PolicyHDR> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException {

		return getPersistence().findByinsuredMobileNo_PrevAndNext(
			policyNo, insuredMobile, orderByComparator);
	}

	/**
	 * Removes all the policy hdrs where insuredMobile = &#63; from the database.
	 *
	 * @param insuredMobile the insured mobile
	 */
	public static void removeByinsuredMobileNo(String insuredMobile) {
		getPersistence().removeByinsuredMobileNo(insuredMobile);
	}

	/**
	 * Returns the number of policy hdrs where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @return the number of matching policy hdrs
	 */
	public static int countByinsuredMobileNo(String insuredMobile) {
		return getPersistence().countByinsuredMobileNo(insuredMobile);
	}

	/**
	 * Returns all the policy hdrs where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @return the matching policy hdrs
	 */
	public static List<PolicyHDR> findByiqamaIdAndStatus(
		String iqamaId, String policyStatus) {

		return getPersistence().findByiqamaIdAndStatus(iqamaId, policyStatus);
	}

	/**
	 * Returns a range of all the policy hdrs where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @return the range of matching policy hdrs
	 */
	public static List<PolicyHDR> findByiqamaIdAndStatus(
		String iqamaId, String policyStatus, int start, int end) {

		return getPersistence().findByiqamaIdAndStatus(
			iqamaId, policyStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the policy hdrs where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy hdrs
	 */
	public static List<PolicyHDR> findByiqamaIdAndStatus(
		String iqamaId, String policyStatus, int start, int end,
		OrderByComparator<PolicyHDR> orderByComparator) {

		return getPersistence().findByiqamaIdAndStatus(
			iqamaId, policyStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy hdrs where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy hdrs
	 */
	public static List<PolicyHDR> findByiqamaIdAndStatus(
		String iqamaId, String policyStatus, int start, int end,
		OrderByComparator<PolicyHDR> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByiqamaIdAndStatus(
			iqamaId, policyStatus, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first policy hdr in the ordered set where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	public static PolicyHDR findByiqamaIdAndStatus_First(
			String iqamaId, String policyStatus,
			OrderByComparator<PolicyHDR> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException {

		return getPersistence().findByiqamaIdAndStatus_First(
			iqamaId, policyStatus, orderByComparator);
	}

	/**
	 * Returns the first policy hdr in the ordered set where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	public static PolicyHDR fetchByiqamaIdAndStatus_First(
		String iqamaId, String policyStatus,
		OrderByComparator<PolicyHDR> orderByComparator) {

		return getPersistence().fetchByiqamaIdAndStatus_First(
			iqamaId, policyStatus, orderByComparator);
	}

	/**
	 * Returns the last policy hdr in the ordered set where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	public static PolicyHDR findByiqamaIdAndStatus_Last(
			String iqamaId, String policyStatus,
			OrderByComparator<PolicyHDR> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException {

		return getPersistence().findByiqamaIdAndStatus_Last(
			iqamaId, policyStatus, orderByComparator);
	}

	/**
	 * Returns the last policy hdr in the ordered set where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	public static PolicyHDR fetchByiqamaIdAndStatus_Last(
		String iqamaId, String policyStatus,
		OrderByComparator<PolicyHDR> orderByComparator) {

		return getPersistence().fetchByiqamaIdAndStatus_Last(
			iqamaId, policyStatus, orderByComparator);
	}

	/**
	 * Returns the policy hdrs before and after the current policy hdr in the ordered set where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param policyNo the primary key of the current policy hdr
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy hdr
	 * @throws NoSuchPolicyHDRException if a policy hdr with the primary key could not be found
	 */
	public static PolicyHDR[] findByiqamaIdAndStatus_PrevAndNext(
			String policyNo, String iqamaId, String policyStatus,
			OrderByComparator<PolicyHDR> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException {

		return getPersistence().findByiqamaIdAndStatus_PrevAndNext(
			policyNo, iqamaId, policyStatus, orderByComparator);
	}

	/**
	 * Removes all the policy hdrs where iqamaId = &#63; and policyStatus = &#63; from the database.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 */
	public static void removeByiqamaIdAndStatus(
		String iqamaId, String policyStatus) {

		getPersistence().removeByiqamaIdAndStatus(iqamaId, policyStatus);
	}

	/**
	 * Returns the number of policy hdrs where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @return the number of matching policy hdrs
	 */
	public static int countByiqamaIdAndStatus(
		String iqamaId, String policyStatus) {

		return getPersistence().countByiqamaIdAndStatus(iqamaId, policyStatus);
	}

	/**
	 * Caches the policy hdr in the entity cache if it is enabled.
	 *
	 * @param policyHDR the policy hdr
	 */
	public static void cacheResult(PolicyHDR policyHDR) {
		getPersistence().cacheResult(policyHDR);
	}

	/**
	 * Caches the policy hdrs in the entity cache if it is enabled.
	 *
	 * @param policyHDRs the policy hdrs
	 */
	public static void cacheResult(List<PolicyHDR> policyHDRs) {
		getPersistence().cacheResult(policyHDRs);
	}

	/**
	 * Creates a new policy hdr with the primary key. Does not add the policy hdr to the database.
	 *
	 * @param policyNo the primary key for the new policy hdr
	 * @return the new policy hdr
	 */
	public static PolicyHDR create(String policyNo) {
		return getPersistence().create(policyNo);
	}

	/**
	 * Removes the policy hdr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyNo the primary key of the policy hdr
	 * @return the policy hdr that was removed
	 * @throws NoSuchPolicyHDRException if a policy hdr with the primary key could not be found
	 */
	public static PolicyHDR remove(String policyNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException {

		return getPersistence().remove(policyNo);
	}

	public static PolicyHDR updateImpl(PolicyHDR policyHDR) {
		return getPersistence().updateImpl(policyHDR);
	}

	/**
	 * Returns the policy hdr with the primary key or throws a <code>NoSuchPolicyHDRException</code> if it could not be found.
	 *
	 * @param policyNo the primary key of the policy hdr
	 * @return the policy hdr
	 * @throws NoSuchPolicyHDRException if a policy hdr with the primary key could not be found
	 */
	public static PolicyHDR findByPrimaryKey(String policyNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException {

		return getPersistence().findByPrimaryKey(policyNo);
	}

	/**
	 * Returns the policy hdr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyNo the primary key of the policy hdr
	 * @return the policy hdr, or <code>null</code> if a policy hdr with the primary key could not be found
	 */
	public static PolicyHDR fetchByPrimaryKey(String policyNo) {
		return getPersistence().fetchByPrimaryKey(policyNo);
	}

	/**
	 * Returns all the policy hdrs.
	 *
	 * @return the policy hdrs
	 */
	public static List<PolicyHDR> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the policy hdrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @return the range of policy hdrs
	 */
	public static List<PolicyHDR> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the policy hdrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy hdrs
	 */
	public static List<PolicyHDR> findAll(
		int start, int end, OrderByComparator<PolicyHDR> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy hdrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy hdrs
	 */
	public static List<PolicyHDR> findAll(
		int start, int end, OrderByComparator<PolicyHDR> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the policy hdrs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of policy hdrs.
	 *
	 * @return the number of policy hdrs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PolicyHDRPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PolicyHDRPersistence, PolicyHDRPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PolicyHDRPersistence.class);

		ServiceTracker<PolicyHDRPersistence, PolicyHDRPersistence>
			serviceTracker =
				new ServiceTracker<PolicyHDRPersistence, PolicyHDRPersistence>(
					bundle.getBundleContext(), PolicyHDRPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}