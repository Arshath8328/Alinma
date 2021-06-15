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

import com.ejada.atmc.acl.db.exception.NoSuchPolicyCancelationException;
import com.ejada.atmc.acl.db.model.PolicyCancelation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the policy cancelation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyCancelationUtil
 * @generated
 */
@ProviderType
public interface PolicyCancelationPersistence
	extends BasePersistence<PolicyCancelation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PolicyCancelationUtil} to access the policy cancelation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the policy cancelation where policyNumber = &#63; or throws a <code>NoSuchPolicyCancelationException</code> if it could not be found.
	 *
	 * @param policyNumber the policy number
	 * @return the matching policy cancelation
	 * @throws NoSuchPolicyCancelationException if a matching policy cancelation could not be found
	 */
	public PolicyCancelation findBypolicyNum(String policyNumber)
		throws NoSuchPolicyCancelationException;

	/**
	 * Returns the policy cancelation where policyNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyNumber the policy number
	 * @return the matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	public PolicyCancelation fetchBypolicyNum(String policyNumber);

	/**
	 * Returns the policy cancelation where policyNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyNumber the policy number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	public PolicyCancelation fetchBypolicyNum(
		String policyNumber, boolean useFinderCache);

	/**
	 * Removes the policy cancelation where policyNumber = &#63; from the database.
	 *
	 * @param policyNumber the policy number
	 * @return the policy cancelation that was removed
	 */
	public PolicyCancelation removeBypolicyNum(String policyNumber)
		throws NoSuchPolicyCancelationException;

	/**
	 * Returns the number of policy cancelations where policyNumber = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @return the number of matching policy cancelations
	 */
	public int countBypolicyNum(String policyNumber);

	/**
	 * Returns all the policy cancelations where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @return the matching policy cancelations
	 */
	public java.util.List<PolicyCancelation> findByinsuredId(String insuredId);

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
	public java.util.List<PolicyCancelation> findByinsuredId(
		String insuredId, int start, int end);

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
	public java.util.List<PolicyCancelation> findByinsuredId(
		String insuredId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyCancelation>
			orderByComparator);

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
	public java.util.List<PolicyCancelation> findByinsuredId(
		String insuredId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyCancelation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first policy cancelation in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy cancelation
	 * @throws NoSuchPolicyCancelationException if a matching policy cancelation could not be found
	 */
	public PolicyCancelation findByinsuredId_First(
			String insuredId,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyCancelation>
				orderByComparator)
		throws NoSuchPolicyCancelationException;

	/**
	 * Returns the first policy cancelation in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	public PolicyCancelation fetchByinsuredId_First(
		String insuredId,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyCancelation>
			orderByComparator);

	/**
	 * Returns the last policy cancelation in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy cancelation
	 * @throws NoSuchPolicyCancelationException if a matching policy cancelation could not be found
	 */
	public PolicyCancelation findByinsuredId_Last(
			String insuredId,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyCancelation>
				orderByComparator)
		throws NoSuchPolicyCancelationException;

	/**
	 * Returns the last policy cancelation in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	public PolicyCancelation fetchByinsuredId_Last(
		String insuredId,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyCancelation>
			orderByComparator);

	/**
	 * Returns the policy cancelations before and after the current policy cancelation in the ordered set where insuredId = &#63;.
	 *
	 * @param Id the primary key of the current policy cancelation
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy cancelation
	 * @throws NoSuchPolicyCancelationException if a policy cancelation with the primary key could not be found
	 */
	public PolicyCancelation[] findByinsuredId_PrevAndNext(
			String Id, String insuredId,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyCancelation>
				orderByComparator)
		throws NoSuchPolicyCancelationException;

	/**
	 * Removes all the policy cancelations where insuredId = &#63; from the database.
	 *
	 * @param insuredId the insured ID
	 */
	public void removeByinsuredId(String insuredId);

	/**
	 * Returns the number of policy cancelations where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @return the number of matching policy cancelations
	 */
	public int countByinsuredId(String insuredId);

	/**
	 * Returns all the policy cancelations where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching policy cancelations
	 */
	public java.util.List<PolicyCancelation> findBystatusAll(String status);

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
	public java.util.List<PolicyCancelation> findBystatusAll(
		String status, int start, int end);

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
	public java.util.List<PolicyCancelation> findBystatusAll(
		String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyCancelation>
			orderByComparator);

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
	public java.util.List<PolicyCancelation> findBystatusAll(
		String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyCancelation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first policy cancelation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy cancelation
	 * @throws NoSuchPolicyCancelationException if a matching policy cancelation could not be found
	 */
	public PolicyCancelation findBystatusAll_First(
			String status,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyCancelation>
				orderByComparator)
		throws NoSuchPolicyCancelationException;

	/**
	 * Returns the first policy cancelation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	public PolicyCancelation fetchBystatusAll_First(
		String status,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyCancelation>
			orderByComparator);

	/**
	 * Returns the last policy cancelation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy cancelation
	 * @throws NoSuchPolicyCancelationException if a matching policy cancelation could not be found
	 */
	public PolicyCancelation findBystatusAll_Last(
			String status,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyCancelation>
				orderByComparator)
		throws NoSuchPolicyCancelationException;

	/**
	 * Returns the last policy cancelation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	public PolicyCancelation fetchBystatusAll_Last(
		String status,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyCancelation>
			orderByComparator);

	/**
	 * Returns the policy cancelations before and after the current policy cancelation in the ordered set where status = &#63;.
	 *
	 * @param Id the primary key of the current policy cancelation
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy cancelation
	 * @throws NoSuchPolicyCancelationException if a policy cancelation with the primary key could not be found
	 */
	public PolicyCancelation[] findBystatusAll_PrevAndNext(
			String Id, String status,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyCancelation>
				orderByComparator)
		throws NoSuchPolicyCancelationException;

	/**
	 * Removes all the policy cancelations where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeBystatusAll(String status);

	/**
	 * Returns the number of policy cancelations where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching policy cancelations
	 */
	public int countBystatusAll(String status);

	/**
	 * Returns the policy cancelation where status = &#63; or throws a <code>NoSuchPolicyCancelationException</code> if it could not be found.
	 *
	 * @param status the status
	 * @return the matching policy cancelation
	 * @throws NoSuchPolicyCancelationException if a matching policy cancelation could not be found
	 */
	public PolicyCancelation findBystatus(String status)
		throws NoSuchPolicyCancelationException;

	/**
	 * Returns the policy cancelation where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param status the status
	 * @return the matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	public PolicyCancelation fetchBystatus(String status);

	/**
	 * Returns the policy cancelation where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy cancelation, or <code>null</code> if a matching policy cancelation could not be found
	 */
	public PolicyCancelation fetchBystatus(
		String status, boolean useFinderCache);

	/**
	 * Removes the policy cancelation where status = &#63; from the database.
	 *
	 * @param status the status
	 * @return the policy cancelation that was removed
	 */
	public PolicyCancelation removeBystatus(String status)
		throws NoSuchPolicyCancelationException;

	/**
	 * Returns the number of policy cancelations where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching policy cancelations
	 */
	public int countBystatus(String status);

	/**
	 * Caches the policy cancelation in the entity cache if it is enabled.
	 *
	 * @param policyCancelation the policy cancelation
	 */
	public void cacheResult(PolicyCancelation policyCancelation);

	/**
	 * Caches the policy cancelations in the entity cache if it is enabled.
	 *
	 * @param policyCancelations the policy cancelations
	 */
	public void cacheResult(
		java.util.List<PolicyCancelation> policyCancelations);

	/**
	 * Creates a new policy cancelation with the primary key. Does not add the policy cancelation to the database.
	 *
	 * @param Id the primary key for the new policy cancelation
	 * @return the new policy cancelation
	 */
	public PolicyCancelation create(String Id);

	/**
	 * Removes the policy cancelation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the policy cancelation
	 * @return the policy cancelation that was removed
	 * @throws NoSuchPolicyCancelationException if a policy cancelation with the primary key could not be found
	 */
	public PolicyCancelation remove(String Id)
		throws NoSuchPolicyCancelationException;

	public PolicyCancelation updateImpl(PolicyCancelation policyCancelation);

	/**
	 * Returns the policy cancelation with the primary key or throws a <code>NoSuchPolicyCancelationException</code> if it could not be found.
	 *
	 * @param Id the primary key of the policy cancelation
	 * @return the policy cancelation
	 * @throws NoSuchPolicyCancelationException if a policy cancelation with the primary key could not be found
	 */
	public PolicyCancelation findByPrimaryKey(String Id)
		throws NoSuchPolicyCancelationException;

	/**
	 * Returns the policy cancelation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the policy cancelation
	 * @return the policy cancelation, or <code>null</code> if a policy cancelation with the primary key could not be found
	 */
	public PolicyCancelation fetchByPrimaryKey(String Id);

	/**
	 * Returns all the policy cancelations.
	 *
	 * @return the policy cancelations
	 */
	public java.util.List<PolicyCancelation> findAll();

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
	public java.util.List<PolicyCancelation> findAll(int start, int end);

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
	public java.util.List<PolicyCancelation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyCancelation>
			orderByComparator);

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
	public java.util.List<PolicyCancelation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyCancelation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the policy cancelations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of policy cancelations.
	 *
	 * @return the number of policy cancelations
	 */
	public int countAll();

}