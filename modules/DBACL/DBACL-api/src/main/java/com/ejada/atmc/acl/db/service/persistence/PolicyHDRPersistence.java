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

import com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException;
import com.ejada.atmc.acl.db.model.PolicyHDR;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the policy hdr service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyHDRUtil
 * @generated
 */
@ProviderType
public interface PolicyHDRPersistence extends BasePersistence<PolicyHDR> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PolicyHDRUtil} to access the policy hdr persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the policy hdr where policyNo = &#63; or throws a <code>NoSuchPolicyHDRException</code> if it could not be found.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	public PolicyHDR findByPolicyNo(String policyNo)
		throws NoSuchPolicyHDRException;

	/**
	 * Returns the policy hdr where policyNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	public PolicyHDR fetchByPolicyNo(String policyNo);

	/**
	 * Returns the policy hdr where policyNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyNo the policy no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	public PolicyHDR fetchByPolicyNo(String policyNo, boolean useFinderCache);

	/**
	 * Removes the policy hdr where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 * @return the policy hdr that was removed
	 */
	public PolicyHDR removeByPolicyNo(String policyNo)
		throws NoSuchPolicyHDRException;

	/**
	 * Returns the number of policy hdrs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching policy hdrs
	 */
	public int countByPolicyNo(String policyNo);

	/**
	 * Returns all the policy hdrs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy hdrs
	 */
	public java.util.List<PolicyHDR> findByMULTI_POLICY(String policyNo);

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
	public java.util.List<PolicyHDR> findByMULTI_POLICY(
		String policyNo, int start, int end);

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
	public java.util.List<PolicyHDR> findByMULTI_POLICY(
		String policyNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
			orderByComparator);

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
	public java.util.List<PolicyHDR> findByMULTI_POLICY(
		String policyNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first policy hdr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	public PolicyHDR findByMULTI_POLICY_First(
			String policyNo,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
				orderByComparator)
		throws NoSuchPolicyHDRException;

	/**
	 * Returns the first policy hdr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	public PolicyHDR fetchByMULTI_POLICY_First(
		String policyNo,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
			orderByComparator);

	/**
	 * Returns the last policy hdr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	public PolicyHDR findByMULTI_POLICY_Last(
			String policyNo,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
				orderByComparator)
		throws NoSuchPolicyHDRException;

	/**
	 * Returns the last policy hdr in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	public PolicyHDR fetchByMULTI_POLICY_Last(
		String policyNo,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
			orderByComparator);

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
	public java.util.List<PolicyHDR> findByMULTI_POLICY(String[] policyNos);

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
	public java.util.List<PolicyHDR> findByMULTI_POLICY(
		String[] policyNos, int start, int end);

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
	public java.util.List<PolicyHDR> findByMULTI_POLICY(
		String[] policyNos, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
			orderByComparator);

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
	public java.util.List<PolicyHDR> findByMULTI_POLICY(
		String[] policyNos, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the policy hdrs where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 */
	public void removeByMULTI_POLICY(String policyNo);

	/**
	 * Returns the number of policy hdrs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching policy hdrs
	 */
	public int countByMULTI_POLICY(String policyNo);

	/**
	 * Returns the number of policy hdrs where policyNo = any &#63;.
	 *
	 * @param policyNos the policy nos
	 * @return the number of matching policy hdrs
	 */
	public int countByMULTI_POLICY(String[] policyNos);

	/**
	 * Returns all the policy hdrs where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @return the matching policy hdrs
	 */
	public java.util.List<PolicyHDR> findByinsuredMobileNo(
		String insuredMobile);

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
	public java.util.List<PolicyHDR> findByinsuredMobileNo(
		String insuredMobile, int start, int end);

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
	public java.util.List<PolicyHDR> findByinsuredMobileNo(
		String insuredMobile, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
			orderByComparator);

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
	public java.util.List<PolicyHDR> findByinsuredMobileNo(
		String insuredMobile, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first policy hdr in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	public PolicyHDR findByinsuredMobileNo_First(
			String insuredMobile,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
				orderByComparator)
		throws NoSuchPolicyHDRException;

	/**
	 * Returns the first policy hdr in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	public PolicyHDR fetchByinsuredMobileNo_First(
		String insuredMobile,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
			orderByComparator);

	/**
	 * Returns the last policy hdr in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	public PolicyHDR findByinsuredMobileNo_Last(
			String insuredMobile,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
				orderByComparator)
		throws NoSuchPolicyHDRException;

	/**
	 * Returns the last policy hdr in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	public PolicyHDR fetchByinsuredMobileNo_Last(
		String insuredMobile,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
			orderByComparator);

	/**
	 * Returns the policy hdrs before and after the current policy hdr in the ordered set where insuredMobile = &#63;.
	 *
	 * @param policyNo the primary key of the current policy hdr
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy hdr
	 * @throws NoSuchPolicyHDRException if a policy hdr with the primary key could not be found
	 */
	public PolicyHDR[] findByinsuredMobileNo_PrevAndNext(
			String policyNo, String insuredMobile,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
				orderByComparator)
		throws NoSuchPolicyHDRException;

	/**
	 * Removes all the policy hdrs where insuredMobile = &#63; from the database.
	 *
	 * @param insuredMobile the insured mobile
	 */
	public void removeByinsuredMobileNo(String insuredMobile);

	/**
	 * Returns the number of policy hdrs where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @return the number of matching policy hdrs
	 */
	public int countByinsuredMobileNo(String insuredMobile);

	/**
	 * Returns all the policy hdrs where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @return the matching policy hdrs
	 */
	public java.util.List<PolicyHDR> findByiqamaIdAndStatus(
		String iqamaId, String policyStatus);

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
	public java.util.List<PolicyHDR> findByiqamaIdAndStatus(
		String iqamaId, String policyStatus, int start, int end);

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
	public java.util.List<PolicyHDR> findByiqamaIdAndStatus(
		String iqamaId, String policyStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
			orderByComparator);

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
	public java.util.List<PolicyHDR> findByiqamaIdAndStatus(
		String iqamaId, String policyStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first policy hdr in the ordered set where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	public PolicyHDR findByiqamaIdAndStatus_First(
			String iqamaId, String policyStatus,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
				orderByComparator)
		throws NoSuchPolicyHDRException;

	/**
	 * Returns the first policy hdr in the ordered set where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	public PolicyHDR fetchByiqamaIdAndStatus_First(
		String iqamaId, String policyStatus,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
			orderByComparator);

	/**
	 * Returns the last policy hdr in the ordered set where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy hdr
	 * @throws NoSuchPolicyHDRException if a matching policy hdr could not be found
	 */
	public PolicyHDR findByiqamaIdAndStatus_Last(
			String iqamaId, String policyStatus,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
				orderByComparator)
		throws NoSuchPolicyHDRException;

	/**
	 * Returns the last policy hdr in the ordered set where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy hdr, or <code>null</code> if a matching policy hdr could not be found
	 */
	public PolicyHDR fetchByiqamaIdAndStatus_Last(
		String iqamaId, String policyStatus,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
			orderByComparator);

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
	public PolicyHDR[] findByiqamaIdAndStatus_PrevAndNext(
			String policyNo, String iqamaId, String policyStatus,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
				orderByComparator)
		throws NoSuchPolicyHDRException;

	/**
	 * Removes all the policy hdrs where iqamaId = &#63; and policyStatus = &#63; from the database.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 */
	public void removeByiqamaIdAndStatus(String iqamaId, String policyStatus);

	/**
	 * Returns the number of policy hdrs where iqamaId = &#63; and policyStatus = &#63;.
	 *
	 * @param iqamaId the iqama ID
	 * @param policyStatus the policy status
	 * @return the number of matching policy hdrs
	 */
	public int countByiqamaIdAndStatus(String iqamaId, String policyStatus);

	/**
	 * Caches the policy hdr in the entity cache if it is enabled.
	 *
	 * @param policyHDR the policy hdr
	 */
	public void cacheResult(PolicyHDR policyHDR);

	/**
	 * Caches the policy hdrs in the entity cache if it is enabled.
	 *
	 * @param policyHDRs the policy hdrs
	 */
	public void cacheResult(java.util.List<PolicyHDR> policyHDRs);

	/**
	 * Creates a new policy hdr with the primary key. Does not add the policy hdr to the database.
	 *
	 * @param policyNo the primary key for the new policy hdr
	 * @return the new policy hdr
	 */
	public PolicyHDR create(String policyNo);

	/**
	 * Removes the policy hdr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyNo the primary key of the policy hdr
	 * @return the policy hdr that was removed
	 * @throws NoSuchPolicyHDRException if a policy hdr with the primary key could not be found
	 */
	public PolicyHDR remove(String policyNo) throws NoSuchPolicyHDRException;

	public PolicyHDR updateImpl(PolicyHDR policyHDR);

	/**
	 * Returns the policy hdr with the primary key or throws a <code>NoSuchPolicyHDRException</code> if it could not be found.
	 *
	 * @param policyNo the primary key of the policy hdr
	 * @return the policy hdr
	 * @throws NoSuchPolicyHDRException if a policy hdr with the primary key could not be found
	 */
	public PolicyHDR findByPrimaryKey(String policyNo)
		throws NoSuchPolicyHDRException;

	/**
	 * Returns the policy hdr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyNo the primary key of the policy hdr
	 * @return the policy hdr, or <code>null</code> if a policy hdr with the primary key could not be found
	 */
	public PolicyHDR fetchByPrimaryKey(String policyNo);

	/**
	 * Returns all the policy hdrs.
	 *
	 * @return the policy hdrs
	 */
	public java.util.List<PolicyHDR> findAll();

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
	public java.util.List<PolicyHDR> findAll(int start, int end);

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
	public java.util.List<PolicyHDR> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
			orderByComparator);

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
	public java.util.List<PolicyHDR> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyHDR>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the policy hdrs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of policy hdrs.
	 *
	 * @return the number of policy hdrs
	 */
	public int countAll();

}