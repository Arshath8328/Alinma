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

import com.ejada.atmc.acl.db.exception.NoSuchPolicyVehCvrException;
import com.ejada.atmc.acl.db.model.PolicyVehCvr;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the policy veh cvr service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyVehCvrUtil
 * @generated
 */
@ProviderType
public interface PolicyVehCvrPersistence extends BasePersistence<PolicyVehCvr> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PolicyVehCvrUtil} to access the policy veh cvr persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the policy veh cvrs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy veh cvrs
	 */
	public java.util.List<PolicyVehCvr> findByPolicyNo(String policyNo);

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
	public java.util.List<PolicyVehCvr> findByPolicyNo(
		String policyNo, int start, int end);

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
	public java.util.List<PolicyVehCvr> findByPolicyNo(
		String policyNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVehCvr>
			orderByComparator);

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
	public java.util.List<PolicyVehCvr> findByPolicyNo(
		String policyNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVehCvr>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first policy veh cvr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a matching policy veh cvr could not be found
	 */
	public PolicyVehCvr findByPolicyNo_First(
			String policyNo,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVehCvr>
				orderByComparator)
		throws NoSuchPolicyVehCvrException;

	/**
	 * Returns the first policy veh cvr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh cvr, or <code>null</code> if a matching policy veh cvr could not be found
	 */
	public PolicyVehCvr fetchByPolicyNo_First(
		String policyNo,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVehCvr>
			orderByComparator);

	/**
	 * Returns the last policy veh cvr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a matching policy veh cvr could not be found
	 */
	public PolicyVehCvr findByPolicyNo_Last(
			String policyNo,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVehCvr>
				orderByComparator)
		throws NoSuchPolicyVehCvrException;

	/**
	 * Returns the last policy veh cvr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh cvr, or <code>null</code> if a matching policy veh cvr could not be found
	 */
	public PolicyVehCvr fetchByPolicyNo_Last(
		String policyNo,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVehCvr>
			orderByComparator);

	/**
	 * Returns the policy veh cvrs before and after the current policy veh cvr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyVehCvrPK the primary key of the current policy veh cvr
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a policy veh cvr with the primary key could not be found
	 */
	public PolicyVehCvr[] findByPolicyNo_PrevAndNext(
			PolicyVehCvrPK policyVehCvrPK, String policyNo,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVehCvr>
				orderByComparator)
		throws NoSuchPolicyVehCvrException;

	/**
	 * Removes all the policy veh cvrs where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 */
	public void removeByPolicyNo(String policyNo);

	/**
	 * Returns the number of policy veh cvrs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching policy veh cvrs
	 */
	public int countByPolicyNo(String policyNo);

	/**
	 * Returns all the policy veh cvrs where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @return the matching policy veh cvrs
	 */
	public java.util.List<PolicyVehCvr> findByPolicyNoVehId(
		String policyNo, String vehId);

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
	public java.util.List<PolicyVehCvr> findByPolicyNoVehId(
		String policyNo, String vehId, int start, int end);

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
	public java.util.List<PolicyVehCvr> findByPolicyNoVehId(
		String policyNo, String vehId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVehCvr>
			orderByComparator);

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
	public java.util.List<PolicyVehCvr> findByPolicyNoVehId(
		String policyNo, String vehId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVehCvr>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first policy veh cvr in the ordered set where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a matching policy veh cvr could not be found
	 */
	public PolicyVehCvr findByPolicyNoVehId_First(
			String policyNo, String vehId,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVehCvr>
				orderByComparator)
		throws NoSuchPolicyVehCvrException;

	/**
	 * Returns the first policy veh cvr in the ordered set where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh cvr, or <code>null</code> if a matching policy veh cvr could not be found
	 */
	public PolicyVehCvr fetchByPolicyNoVehId_First(
		String policyNo, String vehId,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVehCvr>
			orderByComparator);

	/**
	 * Returns the last policy veh cvr in the ordered set where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a matching policy veh cvr could not be found
	 */
	public PolicyVehCvr findByPolicyNoVehId_Last(
			String policyNo, String vehId,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVehCvr>
				orderByComparator)
		throws NoSuchPolicyVehCvrException;

	/**
	 * Returns the last policy veh cvr in the ordered set where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh cvr, or <code>null</code> if a matching policy veh cvr could not be found
	 */
	public PolicyVehCvr fetchByPolicyNoVehId_Last(
		String policyNo, String vehId,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVehCvr>
			orderByComparator);

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
	public PolicyVehCvr[] findByPolicyNoVehId_PrevAndNext(
			PolicyVehCvrPK policyVehCvrPK, String policyNo, String vehId,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVehCvr>
				orderByComparator)
		throws NoSuchPolicyVehCvrException;

	/**
	 * Removes all the policy veh cvrs where policyNo = &#63; and vehId = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 */
	public void removeByPolicyNoVehId(String policyNo, String vehId);

	/**
	 * Returns the number of policy veh cvrs where policyNo = &#63; and vehId = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehId the veh ID
	 * @return the number of matching policy veh cvrs
	 */
	public int countByPolicyNoVehId(String policyNo, String vehId);

	/**
	 * Caches the policy veh cvr in the entity cache if it is enabled.
	 *
	 * @param policyVehCvr the policy veh cvr
	 */
	public void cacheResult(PolicyVehCvr policyVehCvr);

	/**
	 * Caches the policy veh cvrs in the entity cache if it is enabled.
	 *
	 * @param policyVehCvrs the policy veh cvrs
	 */
	public void cacheResult(java.util.List<PolicyVehCvr> policyVehCvrs);

	/**
	 * Creates a new policy veh cvr with the primary key. Does not add the policy veh cvr to the database.
	 *
	 * @param policyVehCvrPK the primary key for the new policy veh cvr
	 * @return the new policy veh cvr
	 */
	public PolicyVehCvr create(PolicyVehCvrPK policyVehCvrPK);

	/**
	 * Removes the policy veh cvr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyVehCvrPK the primary key of the policy veh cvr
	 * @return the policy veh cvr that was removed
	 * @throws NoSuchPolicyVehCvrException if a policy veh cvr with the primary key could not be found
	 */
	public PolicyVehCvr remove(PolicyVehCvrPK policyVehCvrPK)
		throws NoSuchPolicyVehCvrException;

	public PolicyVehCvr updateImpl(PolicyVehCvr policyVehCvr);

	/**
	 * Returns the policy veh cvr with the primary key or throws a <code>NoSuchPolicyVehCvrException</code> if it could not be found.
	 *
	 * @param policyVehCvrPK the primary key of the policy veh cvr
	 * @return the policy veh cvr
	 * @throws NoSuchPolicyVehCvrException if a policy veh cvr with the primary key could not be found
	 */
	public PolicyVehCvr findByPrimaryKey(PolicyVehCvrPK policyVehCvrPK)
		throws NoSuchPolicyVehCvrException;

	/**
	 * Returns the policy veh cvr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyVehCvrPK the primary key of the policy veh cvr
	 * @return the policy veh cvr, or <code>null</code> if a policy veh cvr with the primary key could not be found
	 */
	public PolicyVehCvr fetchByPrimaryKey(PolicyVehCvrPK policyVehCvrPK);

	/**
	 * Returns all the policy veh cvrs.
	 *
	 * @return the policy veh cvrs
	 */
	public java.util.List<PolicyVehCvr> findAll();

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
	public java.util.List<PolicyVehCvr> findAll(int start, int end);

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
	public java.util.List<PolicyVehCvr> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVehCvr>
			orderByComparator);

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
	public java.util.List<PolicyVehCvr> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVehCvr>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the policy veh cvrs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of policy veh cvrs.
	 *
	 * @return the number of policy veh cvrs
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}