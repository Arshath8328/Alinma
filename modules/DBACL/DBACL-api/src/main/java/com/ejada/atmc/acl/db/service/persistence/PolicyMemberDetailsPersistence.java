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

import com.ejada.atmc.acl.db.exception.NoSuchPolicyMemberDetailsException;
import com.ejada.atmc.acl.db.model.PolicyMemberDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the policy member details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyMemberDetailsUtil
 * @generated
 */
@ProviderType
public interface PolicyMemberDetailsPersistence
	extends BasePersistence<PolicyMemberDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PolicyMemberDetailsUtil} to access the policy member details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the policy member detailses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy member detailses
	 */
	public java.util.List<PolicyMemberDetails> findByPolicyNo(String policyNo);

	/**
	 * Returns a range of all the policy member detailses where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyMemberDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy member detailses
	 * @param end the upper bound of the range of policy member detailses (not inclusive)
	 * @return the range of matching policy member detailses
	 */
	public java.util.List<PolicyMemberDetails> findByPolicyNo(
		String policyNo, int start, int end);

	/**
	 * Returns an ordered range of all the policy member detailses where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyMemberDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy member detailses
	 * @param end the upper bound of the range of policy member detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy member detailses
	 */
	public java.util.List<PolicyMemberDetails> findByPolicyNo(
		String policyNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyMemberDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the policy member detailses where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyMemberDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of policy member detailses
	 * @param end the upper bound of the range of policy member detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy member detailses
	 */
	public java.util.List<PolicyMemberDetails> findByPolicyNo(
		String policyNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyMemberDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first policy member details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy member details
	 * @throws NoSuchPolicyMemberDetailsException if a matching policy member details could not be found
	 */
	public PolicyMemberDetails findByPolicyNo_First(
			String policyNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<PolicyMemberDetails> orderByComparator)
		throws NoSuchPolicyMemberDetailsException;

	/**
	 * Returns the first policy member details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy member details, or <code>null</code> if a matching policy member details could not be found
	 */
	public PolicyMemberDetails fetchByPolicyNo_First(
		String policyNo,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyMemberDetails>
			orderByComparator);

	/**
	 * Returns the last policy member details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy member details
	 * @throws NoSuchPolicyMemberDetailsException if a matching policy member details could not be found
	 */
	public PolicyMemberDetails findByPolicyNo_Last(
			String policyNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<PolicyMemberDetails> orderByComparator)
		throws NoSuchPolicyMemberDetailsException;

	/**
	 * Returns the last policy member details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy member details, or <code>null</code> if a matching policy member details could not be found
	 */
	public PolicyMemberDetails fetchByPolicyNo_Last(
		String policyNo,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyMemberDetails>
			orderByComparator);

	/**
	 * Returns the policy member detailses before and after the current policy member details in the ordered set where policyNo = &#63;.
	 *
	 * @param memberId the primary key of the current policy member details
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy member details
	 * @throws NoSuchPolicyMemberDetailsException if a policy member details with the primary key could not be found
	 */
	public PolicyMemberDetails[] findByPolicyNo_PrevAndNext(
			long memberId, String policyNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<PolicyMemberDetails> orderByComparator)
		throws NoSuchPolicyMemberDetailsException;

	/**
	 * Removes all the policy member detailses where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 */
	public void removeByPolicyNo(String policyNo);

	/**
	 * Returns the number of policy member detailses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching policy member detailses
	 */
	public int countByPolicyNo(String policyNo);

	/**
	 * Caches the policy member details in the entity cache if it is enabled.
	 *
	 * @param policyMemberDetails the policy member details
	 */
	public void cacheResult(PolicyMemberDetails policyMemberDetails);

	/**
	 * Caches the policy member detailses in the entity cache if it is enabled.
	 *
	 * @param policyMemberDetailses the policy member detailses
	 */
	public void cacheResult(
		java.util.List<PolicyMemberDetails> policyMemberDetailses);

	/**
	 * Creates a new policy member details with the primary key. Does not add the policy member details to the database.
	 *
	 * @param memberId the primary key for the new policy member details
	 * @return the new policy member details
	 */
	public PolicyMemberDetails create(long memberId);

	/**
	 * Removes the policy member details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberId the primary key of the policy member details
	 * @return the policy member details that was removed
	 * @throws NoSuchPolicyMemberDetailsException if a policy member details with the primary key could not be found
	 */
	public PolicyMemberDetails remove(long memberId)
		throws NoSuchPolicyMemberDetailsException;

	public PolicyMemberDetails updateImpl(
		PolicyMemberDetails policyMemberDetails);

	/**
	 * Returns the policy member details with the primary key or throws a <code>NoSuchPolicyMemberDetailsException</code> if it could not be found.
	 *
	 * @param memberId the primary key of the policy member details
	 * @return the policy member details
	 * @throws NoSuchPolicyMemberDetailsException if a policy member details with the primary key could not be found
	 */
	public PolicyMemberDetails findByPrimaryKey(long memberId)
		throws NoSuchPolicyMemberDetailsException;

	/**
	 * Returns the policy member details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberId the primary key of the policy member details
	 * @return the policy member details, or <code>null</code> if a policy member details with the primary key could not be found
	 */
	public PolicyMemberDetails fetchByPrimaryKey(long memberId);

	/**
	 * Returns all the policy member detailses.
	 *
	 * @return the policy member detailses
	 */
	public java.util.List<PolicyMemberDetails> findAll();

	/**
	 * Returns a range of all the policy member detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyMemberDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy member detailses
	 * @param end the upper bound of the range of policy member detailses (not inclusive)
	 * @return the range of policy member detailses
	 */
	public java.util.List<PolicyMemberDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the policy member detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyMemberDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy member detailses
	 * @param end the upper bound of the range of policy member detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy member detailses
	 */
	public java.util.List<PolicyMemberDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyMemberDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the policy member detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyMemberDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy member detailses
	 * @param end the upper bound of the range of policy member detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy member detailses
	 */
	public java.util.List<PolicyMemberDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyMemberDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the policy member detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of policy member detailses.
	 *
	 * @return the number of policy member detailses
	 */
	public int countAll();

}