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

import com.ejada.atmc.acl.db.exception.NoSuchBeneficiaryDetailsException;
import com.ejada.atmc.acl.db.model.BeneficiaryDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the beneficiary details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BeneficiaryDetailsUtil
 * @generated
 */
@ProviderType
public interface BeneficiaryDetailsPersistence
	extends BasePersistence<BeneficiaryDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BeneficiaryDetailsUtil} to access the beneficiary details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the beneficiary detailses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the matching beneficiary detailses
	 */
	public java.util.List<BeneficiaryDetails> findByPolicyNo(String policyNo);

	/**
	 * Returns a range of all the beneficiary detailses where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BeneficiaryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of beneficiary detailses
	 * @param end the upper bound of the range of beneficiary detailses (not inclusive)
	 * @return the range of matching beneficiary detailses
	 */
	public java.util.List<BeneficiaryDetails> findByPolicyNo(
		String policyNo, int start, int end);

	/**
	 * Returns an ordered range of all the beneficiary detailses where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BeneficiaryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of beneficiary detailses
	 * @param end the upper bound of the range of beneficiary detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching beneficiary detailses
	 */
	public java.util.List<BeneficiaryDetails> findByPolicyNo(
		String policyNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BeneficiaryDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the beneficiary detailses where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BeneficiaryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of beneficiary detailses
	 * @param end the upper bound of the range of beneficiary detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching beneficiary detailses
	 */
	public java.util.List<BeneficiaryDetails> findByPolicyNo(
		String policyNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BeneficiaryDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first beneficiary details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching beneficiary details
	 * @throws NoSuchBeneficiaryDetailsException if a matching beneficiary details could not be found
	 */
	public BeneficiaryDetails findByPolicyNo_First(
			String policyNo,
			com.liferay.portal.kernel.util.OrderByComparator<BeneficiaryDetails>
				orderByComparator)
		throws NoSuchBeneficiaryDetailsException;

	/**
	 * Returns the first beneficiary details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching beneficiary details, or <code>null</code> if a matching beneficiary details could not be found
	 */
	public BeneficiaryDetails fetchByPolicyNo_First(
		String policyNo,
		com.liferay.portal.kernel.util.OrderByComparator<BeneficiaryDetails>
			orderByComparator);

	/**
	 * Returns the last beneficiary details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching beneficiary details
	 * @throws NoSuchBeneficiaryDetailsException if a matching beneficiary details could not be found
	 */
	public BeneficiaryDetails findByPolicyNo_Last(
			String policyNo,
			com.liferay.portal.kernel.util.OrderByComparator<BeneficiaryDetails>
				orderByComparator)
		throws NoSuchBeneficiaryDetailsException;

	/**
	 * Returns the last beneficiary details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching beneficiary details, or <code>null</code> if a matching beneficiary details could not be found
	 */
	public BeneficiaryDetails fetchByPolicyNo_Last(
		String policyNo,
		com.liferay.portal.kernel.util.OrderByComparator<BeneficiaryDetails>
			orderByComparator);

	/**
	 * Returns the beneficiary detailses before and after the current beneficiary details in the ordered set where policyNo = &#63;.
	 *
	 * @param benfId the primary key of the current beneficiary details
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next beneficiary details
	 * @throws NoSuchBeneficiaryDetailsException if a beneficiary details with the primary key could not be found
	 */
	public BeneficiaryDetails[] findByPolicyNo_PrevAndNext(
			long benfId, String policyNo,
			com.liferay.portal.kernel.util.OrderByComparator<BeneficiaryDetails>
				orderByComparator)
		throws NoSuchBeneficiaryDetailsException;

	/**
	 * Removes all the beneficiary detailses where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 */
	public void removeByPolicyNo(String policyNo);

	/**
	 * Returns the number of beneficiary detailses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching beneficiary detailses
	 */
	public int countByPolicyNo(String policyNo);

	/**
	 * Caches the beneficiary details in the entity cache if it is enabled.
	 *
	 * @param beneficiaryDetails the beneficiary details
	 */
	public void cacheResult(BeneficiaryDetails beneficiaryDetails);

	/**
	 * Caches the beneficiary detailses in the entity cache if it is enabled.
	 *
	 * @param beneficiaryDetailses the beneficiary detailses
	 */
	public void cacheResult(
		java.util.List<BeneficiaryDetails> beneficiaryDetailses);

	/**
	 * Creates a new beneficiary details with the primary key. Does not add the beneficiary details to the database.
	 *
	 * @param benfId the primary key for the new beneficiary details
	 * @return the new beneficiary details
	 */
	public BeneficiaryDetails create(long benfId);

	/**
	 * Removes the beneficiary details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param benfId the primary key of the beneficiary details
	 * @return the beneficiary details that was removed
	 * @throws NoSuchBeneficiaryDetailsException if a beneficiary details with the primary key could not be found
	 */
	public BeneficiaryDetails remove(long benfId)
		throws NoSuchBeneficiaryDetailsException;

	public BeneficiaryDetails updateImpl(BeneficiaryDetails beneficiaryDetails);

	/**
	 * Returns the beneficiary details with the primary key or throws a <code>NoSuchBeneficiaryDetailsException</code> if it could not be found.
	 *
	 * @param benfId the primary key of the beneficiary details
	 * @return the beneficiary details
	 * @throws NoSuchBeneficiaryDetailsException if a beneficiary details with the primary key could not be found
	 */
	public BeneficiaryDetails findByPrimaryKey(long benfId)
		throws NoSuchBeneficiaryDetailsException;

	/**
	 * Returns the beneficiary details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param benfId the primary key of the beneficiary details
	 * @return the beneficiary details, or <code>null</code> if a beneficiary details with the primary key could not be found
	 */
	public BeneficiaryDetails fetchByPrimaryKey(long benfId);

	/**
	 * Returns all the beneficiary detailses.
	 *
	 * @return the beneficiary detailses
	 */
	public java.util.List<BeneficiaryDetails> findAll();

	/**
	 * Returns a range of all the beneficiary detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BeneficiaryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of beneficiary detailses
	 * @param end the upper bound of the range of beneficiary detailses (not inclusive)
	 * @return the range of beneficiary detailses
	 */
	public java.util.List<BeneficiaryDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the beneficiary detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BeneficiaryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of beneficiary detailses
	 * @param end the upper bound of the range of beneficiary detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of beneficiary detailses
	 */
	public java.util.List<BeneficiaryDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BeneficiaryDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the beneficiary detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BeneficiaryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of beneficiary detailses
	 * @param end the upper bound of the range of beneficiary detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of beneficiary detailses
	 */
	public java.util.List<BeneficiaryDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BeneficiaryDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the beneficiary detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of beneficiary detailses.
	 *
	 * @return the number of beneficiary detailses
	 */
	public int countAll();

}