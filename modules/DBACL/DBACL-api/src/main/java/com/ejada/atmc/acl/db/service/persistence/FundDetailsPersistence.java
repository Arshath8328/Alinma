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

import com.ejada.atmc.acl.db.exception.NoSuchFundDetailsException;
import com.ejada.atmc.acl.db.model.FundDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the fund details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FundDetailsUtil
 * @generated
 */
@ProviderType
public interface FundDetailsPersistence extends BasePersistence<FundDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FundDetailsUtil} to access the fund details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the fund detailses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the matching fund detailses
	 */
	public java.util.List<FundDetails> findByPolicyNo(String policyNo);

	/**
	 * Returns a range of all the fund detailses where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FundDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of fund detailses
	 * @param end the upper bound of the range of fund detailses (not inclusive)
	 * @return the range of matching fund detailses
	 */
	public java.util.List<FundDetails> findByPolicyNo(
		String policyNo, int start, int end);

	/**
	 * Returns an ordered range of all the fund detailses where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FundDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of fund detailses
	 * @param end the upper bound of the range of fund detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fund detailses
	 */
	public java.util.List<FundDetails> findByPolicyNo(
		String policyNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the fund detailses where policyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FundDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param start the lower bound of the range of fund detailses
	 * @param end the upper bound of the range of fund detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fund detailses
	 */
	public java.util.List<FundDetails> findByPolicyNo(
		String policyNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first fund details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund details
	 * @throws NoSuchFundDetailsException if a matching fund details could not be found
	 */
	public FundDetails findByPolicyNo_First(
			String policyNo,
			com.liferay.portal.kernel.util.OrderByComparator<FundDetails>
				orderByComparator)
		throws NoSuchFundDetailsException;

	/**
	 * Returns the first fund details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund details, or <code>null</code> if a matching fund details could not be found
	 */
	public FundDetails fetchByPolicyNo_First(
		String policyNo,
		com.liferay.portal.kernel.util.OrderByComparator<FundDetails>
			orderByComparator);

	/**
	 * Returns the last fund details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund details
	 * @throws NoSuchFundDetailsException if a matching fund details could not be found
	 */
	public FundDetails findByPolicyNo_Last(
			String policyNo,
			com.liferay.portal.kernel.util.OrderByComparator<FundDetails>
				orderByComparator)
		throws NoSuchFundDetailsException;

	/**
	 * Returns the last fund details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund details, or <code>null</code> if a matching fund details could not be found
	 */
	public FundDetails fetchByPolicyNo_Last(
		String policyNo,
		com.liferay.portal.kernel.util.OrderByComparator<FundDetails>
			orderByComparator);

	/**
	 * Returns the fund detailses before and after the current fund details in the ordered set where policyNo = &#63;.
	 *
	 * @param fundName the primary key of the current fund details
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fund details
	 * @throws NoSuchFundDetailsException if a fund details with the primary key could not be found
	 */
	public FundDetails[] findByPolicyNo_PrevAndNext(
			String fundName, String policyNo,
			com.liferay.portal.kernel.util.OrderByComparator<FundDetails>
				orderByComparator)
		throws NoSuchFundDetailsException;

	/**
	 * Removes all the fund detailses where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 */
	public void removeByPolicyNo(String policyNo);

	/**
	 * Returns the number of fund detailses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching fund detailses
	 */
	public int countByPolicyNo(String policyNo);

	/**
	 * Caches the fund details in the entity cache if it is enabled.
	 *
	 * @param fundDetails the fund details
	 */
	public void cacheResult(FundDetails fundDetails);

	/**
	 * Caches the fund detailses in the entity cache if it is enabled.
	 *
	 * @param fundDetailses the fund detailses
	 */
	public void cacheResult(java.util.List<FundDetails> fundDetailses);

	/**
	 * Creates a new fund details with the primary key. Does not add the fund details to the database.
	 *
	 * @param fundName the primary key for the new fund details
	 * @return the new fund details
	 */
	public FundDetails create(String fundName);

	/**
	 * Removes the fund details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fundName the primary key of the fund details
	 * @return the fund details that was removed
	 * @throws NoSuchFundDetailsException if a fund details with the primary key could not be found
	 */
	public FundDetails remove(String fundName)
		throws NoSuchFundDetailsException;

	public FundDetails updateImpl(FundDetails fundDetails);

	/**
	 * Returns the fund details with the primary key or throws a <code>NoSuchFundDetailsException</code> if it could not be found.
	 *
	 * @param fundName the primary key of the fund details
	 * @return the fund details
	 * @throws NoSuchFundDetailsException if a fund details with the primary key could not be found
	 */
	public FundDetails findByPrimaryKey(String fundName)
		throws NoSuchFundDetailsException;

	/**
	 * Returns the fund details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fundName the primary key of the fund details
	 * @return the fund details, or <code>null</code> if a fund details with the primary key could not be found
	 */
	public FundDetails fetchByPrimaryKey(String fundName);

	/**
	 * Returns all the fund detailses.
	 *
	 * @return the fund detailses
	 */
	public java.util.List<FundDetails> findAll();

	/**
	 * Returns a range of all the fund detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FundDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fund detailses
	 * @param end the upper bound of the range of fund detailses (not inclusive)
	 * @return the range of fund detailses
	 */
	public java.util.List<FundDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the fund detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FundDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fund detailses
	 * @param end the upper bound of the range of fund detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fund detailses
	 */
	public java.util.List<FundDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the fund detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FundDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fund detailses
	 * @param end the upper bound of the range of fund detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of fund detailses
	 */
	public java.util.List<FundDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the fund detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of fund detailses.
	 *
	 * @return the number of fund detailses
	 */
	public int countAll();

}