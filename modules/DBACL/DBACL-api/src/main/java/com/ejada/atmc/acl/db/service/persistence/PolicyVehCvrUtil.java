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

import com.ejada.atmc.acl.db.model.PolicyVehCvr;

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
 * The persistence utility for the policy veh cvr service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.PolicyVehCvrPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyVehCvrPersistence
 * @generated
 */
public class PolicyVehCvrUtil {

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
	public static void clearCache(PolicyVehCvr policyVehCvr) {
		getPersistence().clearCache(policyVehCvr);
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
	public static Map<Serializable, PolicyVehCvr> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PolicyVehCvr> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PolicyVehCvr> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PolicyVehCvr> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PolicyVehCvr> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PolicyVehCvr update(PolicyVehCvr policyVehCvr) {
		return getPersistence().update(policyVehCvr);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PolicyVehCvr update(
		PolicyVehCvr policyVehCvr, ServiceContext serviceContext) {

		return getPersistence().update(policyVehCvr, serviceContext);
	}

	/**
	 * Returns all the policy veh cvrs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy veh cvrs
	 */
	public static List<PolicyVehCvr> findByPolicyNo(String policyNo) {
		return getPersistence().findByPolicyNo(policyNo);
	}

	/**
	 * Returns a range of all the policy veh cvrs where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehCvrModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy veh cvrs
	 * @param end the upper bound of the range of policy veh cvrs (not inclusive)
	 * @return the range of matching policy veh cvrs
	 */
	public static List<PolicyVehCvr> findByPolicyNo(
		String policyNo, int start, int end) {

		return getPersistence().findByPolicyNo(policyNo, start, end);
	}

	/**
	 * Returns an ordered range of all the policy veh cvrs where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehCvrModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy veh cvrs
	 * @param end the upper bound of the range of policy veh cvrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy veh cvrs
	 */
	public static List<PolicyVehCvr> findByPolicyNo(
		String policyNo, int start, int end,
		OrderByComparator<PolicyVehCvr> orderByComparator) {

		return getPersistence().findByPolicyNo(
			policyNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy veh cvrs where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehCvrModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy veh cvrs
	 * @param end the upper bound of the range of policy veh cvrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy veh cvrs
	 */
	public static List<PolicyVehCvr> findByPolicyNo(
		String policyNo, int start, int end,
		OrderByComparator<PolicyVehCvr> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPolicyNo(
			policyNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first policy veh cvr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a matching policy veh cvr could not be found
	 */
	public static PolicyVehCvr findByPolicyNo_First(
			String policyNo, OrderByComparator<PolicyVehCvr> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVehCvrException {

		return getPersistence().findByPolicyNo_First(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the first policy veh cvr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh cvr, or <code>null</code> if a matching policy veh cvr could not be found
	 */
	public static PolicyVehCvr fetchByPolicyNo_First(
		String policyNo, OrderByComparator<PolicyVehCvr> orderByComparator) {

		return getPersistence().fetchByPolicyNo_First(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the last policy veh cvr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a matching policy veh cvr could not be found
	 */
	public static PolicyVehCvr findByPolicyNo_Last(
			String policyNo, OrderByComparator<PolicyVehCvr> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVehCvrException {

		return getPersistence().findByPolicyNo_Last(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the last policy veh cvr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh cvr, or <code>null</code> if a matching policy veh cvr could not be found
	 */
	public static PolicyVehCvr fetchByPolicyNo_Last(
		String policyNo, OrderByComparator<PolicyVehCvr> orderByComparator) {

		return getPersistence().fetchByPolicyNo_Last(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the policy veh cvrs before and after the current policy veh cvr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyVehCvrPK the primary key of the current policy veh cvr
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a policy veh cvr with the primary key could not be found
	 */
	public static PolicyVehCvr[] findByPolicyNo_PrevAndNext(
			PolicyVehCvrPK policyVehCvrPK, String policyNo,
			OrderByComparator<PolicyVehCvr> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVehCvrException {

		return getPersistence().findByPolicyNo_PrevAndNext(
			policyVehCvrPK, policyNo, orderByComparator);
	}

	/**
	 * Removes all the policy veh cvrs where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 */
	public static void removeByPolicyNo(String policyNo) {
		getPersistence().removeByPolicyNo(policyNo);
	}

	/**
	 * Returns the number of policy veh cvrs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching policy veh cvrs
	 */
	public static int countByPolicyNo(String policyNo) {
		return getPersistence().countByPolicyNo(policyNo);
	}

	/**
	 * Returns all the policy veh cvrs where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @return the matching policy veh cvrs
	 */
	public static List<PolicyVehCvr> findByPolicyNoVehId(
		String policyNo, String vehId) {

		return getPersistence().findByPolicyNoVehId(policyNo, vehId);
	}

	/**
	 * Returns a range of all the policy veh cvrs where policyNo = &#63; and vehId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehCvrModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param start the lower bound of the range of policy veh cvrs
	 * @param end the upper bound of the range of policy veh cvrs (not inclusive)
	 * @return the range of matching policy veh cvrs
	 */
	public static List<PolicyVehCvr> findByPolicyNoVehId(
		String policyNo, String vehId, int start, int end) {

		return getPersistence().findByPolicyNoVehId(
			policyNo, vehId, start, end);
	}

	/**
	 * Returns an ordered range of all the policy veh cvrs where policyNo = &#63; and vehId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehCvrModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param start the lower bound of the range of policy veh cvrs
	 * @param end the upper bound of the range of policy veh cvrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy veh cvrs
	 */
	public static List<PolicyVehCvr> findByPolicyNoVehId(
		String policyNo, String vehId, int start, int end,
		OrderByComparator<PolicyVehCvr> orderByComparator) {

		return getPersistence().findByPolicyNoVehId(
			policyNo, vehId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy veh cvrs where policyNo = &#63; and vehId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehCvrModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param start the lower bound of the range of policy veh cvrs
	 * @param end the upper bound of the range of policy veh cvrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy veh cvrs
	 */
	public static List<PolicyVehCvr> findByPolicyNoVehId(
		String policyNo, String vehId, int start, int end,
		OrderByComparator<PolicyVehCvr> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPolicyNoVehId(
			policyNo, vehId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first policy veh cvr in the ordered set where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a matching policy veh cvr could not be found
	 */
	public static PolicyVehCvr findByPolicyNoVehId_First(
			String policyNo, String vehId,
			OrderByComparator<PolicyVehCvr> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVehCvrException {

		return getPersistence().findByPolicyNoVehId_First(
			policyNo, vehId, orderByComparator);
	}

	/**
	 * Returns the first policy veh cvr in the ordered set where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh cvr, or <code>null</code> if a matching policy veh cvr could not be found
	 */
	public static PolicyVehCvr fetchByPolicyNoVehId_First(
		String policyNo, String vehId,
		OrderByComparator<PolicyVehCvr> orderByComparator) {

		return getPersistence().fetchByPolicyNoVehId_First(
			policyNo, vehId, orderByComparator);
	}

	/**
	 * Returns the last policy veh cvr in the ordered set where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a matching policy veh cvr could not be found
	 */
	public static PolicyVehCvr findByPolicyNoVehId_Last(
			String policyNo, String vehId,
			OrderByComparator<PolicyVehCvr> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVehCvrException {

		return getPersistence().findByPolicyNoVehId_Last(
			policyNo, vehId, orderByComparator);
	}

	/**
	 * Returns the last policy veh cvr in the ordered set where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh cvr, or <code>null</code> if a matching policy veh cvr could not be found
	 */
	public static PolicyVehCvr fetchByPolicyNoVehId_Last(
		String policyNo, String vehId,
		OrderByComparator<PolicyVehCvr> orderByComparator) {

		return getPersistence().fetchByPolicyNoVehId_Last(
			policyNo, vehId, orderByComparator);
	}

	/**
	 * Returns the policy veh cvrs before and after the current policy veh cvr in the ordered set where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyVehCvrPK the primary key of the current policy veh cvr
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a policy veh cvr with the primary key could not be found
	 */
	public static PolicyVehCvr[] findByPolicyNoVehId_PrevAndNext(
			PolicyVehCvrPK policyVehCvrPK, String policyNo, String vehId,
			OrderByComparator<PolicyVehCvr> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVehCvrException {

		return getPersistence().findByPolicyNoVehId_PrevAndNext(
			policyVehCvrPK, policyNo, vehId, orderByComparator);
	}

	/**
	 * Removes all the policy veh cvrs where policyNo = &#63; and vehId = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 */
	public static void removeByPolicyNoVehId(String policyNo, String vehId) {
		getPersistence().removeByPolicyNoVehId(policyNo, vehId);
	}

	/**
	 * Returns the number of policy veh cvrs where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @return the number of matching policy veh cvrs
	 */
	public static int countByPolicyNoVehId(String policyNo, String vehId) {
		return getPersistence().countByPolicyNoVehId(policyNo, vehId);
	}

	/**
	 * Caches the policy veh cvr in the entity cache if it is enabled.
	 *
	 * @param policyVehCvr the policy veh cvr
	 */
	public static void cacheResult(PolicyVehCvr policyVehCvr) {
		getPersistence().cacheResult(policyVehCvr);
	}

	/**
	 * Caches the policy veh cvrs in the entity cache if it is enabled.
	 *
	 * @param policyVehCvrs the policy veh cvrs
	 */
	public static void cacheResult(List<PolicyVehCvr> policyVehCvrs) {
		getPersistence().cacheResult(policyVehCvrs);
	}

	/**
	 * Creates a new policy veh cvr with the primary key. Does not add the policy veh cvr to the database.
	 *
	 * @param policyVehCvrPK the primary key for the new policy veh cvr
	 * @return the new policy veh cvr
	 */
	public static PolicyVehCvr create(PolicyVehCvrPK policyVehCvrPK) {
		return getPersistence().create(policyVehCvrPK);
	}

	/**
	 * Removes the policy veh cvr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyVehCvrPK the primary key of the policy veh cvr
	 * @return the policy veh cvr that was removed
	 * @throws NoSuchPolicyVehCvrException if a policy veh cvr with the primary key could not be found
	 */
	public static PolicyVehCvr remove(PolicyVehCvrPK policyVehCvrPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVehCvrException {

		return getPersistence().remove(policyVehCvrPK);
	}

	public static PolicyVehCvr updateImpl(PolicyVehCvr policyVehCvr) {
		return getPersistence().updateImpl(policyVehCvr);
	}

	/**
	 * Returns the policy veh cvr with the primary key or throws a <code>NoSuchPolicyVehCvrException</code> if it could not be found.
	 *
	 * @param policyVehCvrPK the primary key of the policy veh cvr
	 * @return the policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a policy veh cvr with the primary key could not be found
	 */
	public static PolicyVehCvr findByPrimaryKey(PolicyVehCvrPK policyVehCvrPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVehCvrException {

		return getPersistence().findByPrimaryKey(policyVehCvrPK);
	}

	/**
	 * Returns the policy veh cvr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyVehCvrPK the primary key of the policy veh cvr
	 * @return the policy veh cvr, or <code>null</code> if a policy veh cvr with the primary key could not be found
	 */
	public static PolicyVehCvr fetchByPrimaryKey(
		PolicyVehCvrPK policyVehCvrPK) {

		return getPersistence().fetchByPrimaryKey(policyVehCvrPK);
	}

	/**
	 * Returns all the policy veh cvrs.
	 *
	 * @return the policy veh cvrs
	 */
	public static List<PolicyVehCvr> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the policy veh cvrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehCvrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy veh cvrs
	 * @param end the upper bound of the range of policy veh cvrs (not inclusive)
	 * @return the range of policy veh cvrs
	 */
	public static List<PolicyVehCvr> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the policy veh cvrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehCvrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy veh cvrs
	 * @param end the upper bound of the range of policy veh cvrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy veh cvrs
	 */
	public static List<PolicyVehCvr> findAll(
		int start, int end, OrderByComparator<PolicyVehCvr> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy veh cvrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehCvrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy veh cvrs
	 * @param end the upper bound of the range of policy veh cvrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy veh cvrs
	 */
	public static List<PolicyVehCvr> findAll(
		int start, int end, OrderByComparator<PolicyVehCvr> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the policy veh cvrs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of policy veh cvrs.
	 *
	 * @return the number of policy veh cvrs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static PolicyVehCvrPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PolicyVehCvrPersistence, PolicyVehCvrPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PolicyVehCvrPersistence.class);

		ServiceTracker<PolicyVehCvrPersistence, PolicyVehCvrPersistence>
			serviceTracker =
				new ServiceTracker
					<PolicyVehCvrPersistence, PolicyVehCvrPersistence>(
						bundle.getBundleContext(),
						PolicyVehCvrPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}