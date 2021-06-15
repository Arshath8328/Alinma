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

import com.ejada.atmc.acl.db.model.PolicyVehDrv;

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
 * The persistence utility for the policy veh drv service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.PolicyVehDrvPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyVehDrvPersistence
 * @generated
 */
public class PolicyVehDrvUtil {

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
	public static void clearCache(PolicyVehDrv policyVehDrv) {
		getPersistence().clearCache(policyVehDrv);
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
	public static Map<Serializable, PolicyVehDrv> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PolicyVehDrv> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PolicyVehDrv> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PolicyVehDrv> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PolicyVehDrv> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PolicyVehDrv update(PolicyVehDrv policyVehDrv) {
		return getPersistence().update(policyVehDrv);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PolicyVehDrv update(
		PolicyVehDrv policyVehDrv, ServiceContext serviceContext) {

		return getPersistence().update(policyVehDrv, serviceContext);
	}

	/**
	 * Returns all the policy veh drvs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy veh drvs
	 */
	public static List<PolicyVehDrv> findBypolNumber(String policyNo) {
		return getPersistence().findBypolNumber(policyNo);
	}

	/**
	 * Returns a range of all the policy veh drvs where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehDrvModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy veh drvs
	 * @param end the upper bound of the range of policy veh drvs (not inclusive)
	 * @return the range of matching policy veh drvs
	 */
	public static List<PolicyVehDrv> findBypolNumber(
		String policyNo, int start, int end) {

		return getPersistence().findBypolNumber(policyNo, start, end);
	}

	/**
	 * Returns an ordered range of all the policy veh drvs where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehDrvModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy veh drvs
	 * @param end the upper bound of the range of policy veh drvs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy veh drvs
	 */
	public static List<PolicyVehDrv> findBypolNumber(
		String policyNo, int start, int end,
		OrderByComparator<PolicyVehDrv> orderByComparator) {

		return getPersistence().findBypolNumber(
			policyNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy veh drvs where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehDrvModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy veh drvs
	 * @param end the upper bound of the range of policy veh drvs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy veh drvs
	 */
	public static List<PolicyVehDrv> findBypolNumber(
		String policyNo, int start, int end,
		OrderByComparator<PolicyVehDrv> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBypolNumber(
			policyNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first policy veh drv in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh drv
	 * @throws NoSuchPolicyVehDrvException if a matching policy veh drv could not be found
	 */
	public static PolicyVehDrv findBypolNumber_First(
			String policyNo, OrderByComparator<PolicyVehDrv> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVehDrvException {

		return getPersistence().findBypolNumber_First(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the first policy veh drv in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh drv, or <code>null</code> if a matching policy veh drv could not be found
	 */
	public static PolicyVehDrv fetchBypolNumber_First(
		String policyNo, OrderByComparator<PolicyVehDrv> orderByComparator) {

		return getPersistence().fetchBypolNumber_First(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the last policy veh drv in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh drv
	 * @throws NoSuchPolicyVehDrvException if a matching policy veh drv could not be found
	 */
	public static PolicyVehDrv findBypolNumber_Last(
			String policyNo, OrderByComparator<PolicyVehDrv> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVehDrvException {

		return getPersistence().findBypolNumber_Last(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the last policy veh drv in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh drv, or <code>null</code> if a matching policy veh drv could not be found
	 */
	public static PolicyVehDrv fetchBypolNumber_Last(
		String policyNo, OrderByComparator<PolicyVehDrv> orderByComparator) {

		return getPersistence().fetchBypolNumber_Last(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the policy veh drvs before and after the current policy veh drv in the ordered set where policyNo = &#63;.
	 *
	 * @param policyVehDrvPK the primary key of the current policy veh drv
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy veh drv
	 * @throws NoSuchPolicyVehDrvException if a policy veh drv with the primary key could not be found
	 */
	public static PolicyVehDrv[] findBypolNumber_PrevAndNext(
			PolicyVehDrvPK policyVehDrvPK, String policyNo,
			OrderByComparator<PolicyVehDrv> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVehDrvException {

		return getPersistence().findBypolNumber_PrevAndNext(
			policyVehDrvPK, policyNo, orderByComparator);
	}

	/**
	 * Removes all the policy veh drvs where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 */
	public static void removeBypolNumber(String policyNo) {
		getPersistence().removeBypolNumber(policyNo);
	}

	/**
	 * Returns the number of policy veh drvs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching policy veh drvs
	 */
	public static int countBypolNumber(String policyNo) {
		return getPersistence().countBypolNumber(policyNo);
	}

	/**
	 * Caches the policy veh drv in the entity cache if it is enabled.
	 *
	 * @param policyVehDrv the policy veh drv
	 */
	public static void cacheResult(PolicyVehDrv policyVehDrv) {
		getPersistence().cacheResult(policyVehDrv);
	}

	/**
	 * Caches the policy veh drvs in the entity cache if it is enabled.
	 *
	 * @param policyVehDrvs the policy veh drvs
	 */
	public static void cacheResult(List<PolicyVehDrv> policyVehDrvs) {
		getPersistence().cacheResult(policyVehDrvs);
	}

	/**
	 * Creates a new policy veh drv with the primary key. Does not add the policy veh drv to the database.
	 *
	 * @param policyVehDrvPK the primary key for the new policy veh drv
	 * @return the new policy veh drv
	 */
	public static PolicyVehDrv create(PolicyVehDrvPK policyVehDrvPK) {
		return getPersistence().create(policyVehDrvPK);
	}

	/**
	 * Removes the policy veh drv with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyVehDrvPK the primary key of the policy veh drv
	 * @return the policy veh drv that was removed
	 * @throws NoSuchPolicyVehDrvException if a policy veh drv with the primary key could not be found
	 */
	public static PolicyVehDrv remove(PolicyVehDrvPK policyVehDrvPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVehDrvException {

		return getPersistence().remove(policyVehDrvPK);
	}

	public static PolicyVehDrv updateImpl(PolicyVehDrv policyVehDrv) {
		return getPersistence().updateImpl(policyVehDrv);
	}

	/**
	 * Returns the policy veh drv with the primary key or throws a <code>NoSuchPolicyVehDrvException</code> if it could not be found.
	 *
	 * @param policyVehDrvPK the primary key of the policy veh drv
	 * @return the policy veh drv
	 * @throws NoSuchPolicyVehDrvException if a policy veh drv with the primary key could not be found
	 */
	public static PolicyVehDrv findByPrimaryKey(PolicyVehDrvPK policyVehDrvPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVehDrvException {

		return getPersistence().findByPrimaryKey(policyVehDrvPK);
	}

	/**
	 * Returns the policy veh drv with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyVehDrvPK the primary key of the policy veh drv
	 * @return the policy veh drv, or <code>null</code> if a policy veh drv with the primary key could not be found
	 */
	public static PolicyVehDrv fetchByPrimaryKey(
		PolicyVehDrvPK policyVehDrvPK) {

		return getPersistence().fetchByPrimaryKey(policyVehDrvPK);
	}

	/**
	 * Returns all the policy veh drvs.
	 *
	 * @return the policy veh drvs
	 */
	public static List<PolicyVehDrv> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the policy veh drvs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehDrvModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy veh drvs
	 * @param end the upper bound of the range of policy veh drvs (not inclusive)
	 * @return the range of policy veh drvs
	 */
	public static List<PolicyVehDrv> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the policy veh drvs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehDrvModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy veh drvs
	 * @param end the upper bound of the range of policy veh drvs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy veh drvs
	 */
	public static List<PolicyVehDrv> findAll(
		int start, int end, OrderByComparator<PolicyVehDrv> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy veh drvs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVehDrvModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy veh drvs
	 * @param end the upper bound of the range of policy veh drvs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy veh drvs
	 */
	public static List<PolicyVehDrv> findAll(
		int start, int end, OrderByComparator<PolicyVehDrv> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the policy veh drvs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of policy veh drvs.
	 *
	 * @return the number of policy veh drvs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static PolicyVehDrvPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PolicyVehDrvPersistence, PolicyVehDrvPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PolicyVehDrvPersistence.class);

		ServiceTracker<PolicyVehDrvPersistence, PolicyVehDrvPersistence>
			serviceTracker =
				new ServiceTracker
					<PolicyVehDrvPersistence, PolicyVehDrvPersistence>(
						bundle.getBundleContext(),
						PolicyVehDrvPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}