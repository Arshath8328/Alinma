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

import com.ejada.atmc.acl.db.exception.NoSuchPolicyVehDrvException;
import com.ejada.atmc.acl.db.model.PolicyVehDrv;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the policy veh drv service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyVehDrvUtil
 * @generated
 */
@ProviderType
public interface PolicyVehDrvPersistence extends BasePersistence<PolicyVehDrv> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PolicyVehDrvUtil} to access the policy veh drv persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the policy veh drvs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy veh drvs
	 */
	public java.util.List<PolicyVehDrv> findBypolNumber(String policyNo);

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
	public java.util.List<PolicyVehDrv> findBypolNumber(
		String policyNo, int start, int end);

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
	public java.util.List<PolicyVehDrv> findBypolNumber(
		String policyNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVehDrv>
			orderByComparator);

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
	public java.util.List<PolicyVehDrv> findBypolNumber(
		String policyNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVehDrv>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first policy veh drv in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh drv
	 * @throws NoSuchPolicyVehDrvException if a matching policy veh drv could not be found
	 */
	public PolicyVehDrv findBypolNumber_First(
			String policyNo,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVehDrv>
				orderByComparator)
		throws NoSuchPolicyVehDrvException;

	/**
	 * Returns the first policy veh drv in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh drv, or <code>null</code> if a matching policy veh drv could not be found
	 */
	public PolicyVehDrv fetchBypolNumber_First(
		String policyNo,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVehDrv>
			orderByComparator);

	/**
	 * Returns the last policy veh drv in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh drv
	 * @throws NoSuchPolicyVehDrvException if a matching policy veh drv could not be found
	 */
	public PolicyVehDrv findBypolNumber_Last(
			String policyNo,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVehDrv>
				orderByComparator)
		throws NoSuchPolicyVehDrvException;

	/**
	 * Returns the last policy veh drv in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh drv, or <code>null</code> if a matching policy veh drv could not be found
	 */
	public PolicyVehDrv fetchBypolNumber_Last(
		String policyNo,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVehDrv>
			orderByComparator);

	/**
	 * Returns the policy veh drvs before and after the current policy veh drv in the ordered set where policyNo = &#63;.
	 *
	 * @param policyVehDrvPK the primary key of the current policy veh drv
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy veh drv
	 * @throws NoSuchPolicyVehDrvException if a policy veh drv with the primary key could not be found
	 */
	public PolicyVehDrv[] findBypolNumber_PrevAndNext(
			PolicyVehDrvPK policyVehDrvPK, String policyNo,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVehDrv>
				orderByComparator)
		throws NoSuchPolicyVehDrvException;

	/**
	 * Removes all the policy veh drvs where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 */
	public void removeBypolNumber(String policyNo);

	/**
	 * Returns the number of policy veh drvs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching policy veh drvs
	 */
	public int countBypolNumber(String policyNo);

	/**
	 * Caches the policy veh drv in the entity cache if it is enabled.
	 *
	 * @param policyVehDrv the policy veh drv
	 */
	public void cacheResult(PolicyVehDrv policyVehDrv);

	/**
	 * Caches the policy veh drvs in the entity cache if it is enabled.
	 *
	 * @param policyVehDrvs the policy veh drvs
	 */
	public void cacheResult(java.util.List<PolicyVehDrv> policyVehDrvs);

	/**
	 * Creates a new policy veh drv with the primary key. Does not add the policy veh drv to the database.
	 *
	 * @param policyVehDrvPK the primary key for the new policy veh drv
	 * @return the new policy veh drv
	 */
	public PolicyVehDrv create(PolicyVehDrvPK policyVehDrvPK);

	/**
	 * Removes the policy veh drv with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyVehDrvPK the primary key of the policy veh drv
	 * @return the policy veh drv that was removed
	 * @throws NoSuchPolicyVehDrvException if a policy veh drv with the primary key could not be found
	 */
	public PolicyVehDrv remove(PolicyVehDrvPK policyVehDrvPK)
		throws NoSuchPolicyVehDrvException;

	public PolicyVehDrv updateImpl(PolicyVehDrv policyVehDrv);

	/**
	 * Returns the policy veh drv with the primary key or throws a <code>NoSuchPolicyVehDrvException</code> if it could not be found.
	 *
	 * @param policyVehDrvPK the primary key of the policy veh drv
	 * @return the policy veh drv
	 * @throws NoSuchPolicyVehDrvException if a policy veh drv with the primary key could not be found
	 */
	public PolicyVehDrv findByPrimaryKey(PolicyVehDrvPK policyVehDrvPK)
		throws NoSuchPolicyVehDrvException;

	/**
	 * Returns the policy veh drv with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyVehDrvPK the primary key of the policy veh drv
	 * @return the policy veh drv, or <code>null</code> if a policy veh drv with the primary key could not be found
	 */
	public PolicyVehDrv fetchByPrimaryKey(PolicyVehDrvPK policyVehDrvPK);

	/**
	 * Returns all the policy veh drvs.
	 *
	 * @return the policy veh drvs
	 */
	public java.util.List<PolicyVehDrv> findAll();

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
	public java.util.List<PolicyVehDrv> findAll(int start, int end);

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
	public java.util.List<PolicyVehDrv> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVehDrv>
			orderByComparator);

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
	public java.util.List<PolicyVehDrv> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVehDrv>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the policy veh drvs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of policy veh drvs.
	 *
	 * @return the number of policy veh drvs
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}