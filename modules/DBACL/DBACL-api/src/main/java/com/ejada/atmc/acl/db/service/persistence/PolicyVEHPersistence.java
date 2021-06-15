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

import com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException;
import com.ejada.atmc.acl.db.model.PolicyVEH;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the policy veh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyVEHUtil
 * @generated
 */
@ProviderType
public interface PolicyVEHPersistence extends BasePersistence<PolicyVEH> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PolicyVEHUtil} to access the policy veh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the policy vehs where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @return the matching policy vehs
	 */
	public java.util.List<PolicyVEH> findByPolicyNoVehicleSeqCustom(
		String policyNo, String vehicleSeqCustom);

	/**
	 * Returns a range of all the policy vehs where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @return the range of matching policy vehs
	 */
	public java.util.List<PolicyVEH> findByPolicyNoVehicleSeqCustom(
		String policyNo, String vehicleSeqCustom, int start, int end);

	/**
	 * Returns an ordered range of all the policy vehs where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy vehs
	 */
	public java.util.List<PolicyVEH> findByPolicyNoVehicleSeqCustom(
		String policyNo, String vehicleSeqCustom, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
			orderByComparator);

	/**
	 * Returns an ordered range of all the policy vehs where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy vehs
	 */
	public java.util.List<PolicyVEH> findByPolicyNoVehicleSeqCustom(
		String policyNo, String vehicleSeqCustom, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first policy veh in the ordered set where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	public PolicyVEH findByPolicyNoVehicleSeqCustom_First(
			String policyNo, String vehicleSeqCustom,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
				orderByComparator)
		throws NoSuchPolicyVEHException;

	/**
	 * Returns the first policy veh in the ordered set where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	public PolicyVEH fetchByPolicyNoVehicleSeqCustom_First(
		String policyNo, String vehicleSeqCustom,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
			orderByComparator);

	/**
	 * Returns the last policy veh in the ordered set where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	public PolicyVEH findByPolicyNoVehicleSeqCustom_Last(
			String policyNo, String vehicleSeqCustom,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
				orderByComparator)
		throws NoSuchPolicyVEHException;

	/**
	 * Returns the last policy veh in the ordered set where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	public PolicyVEH fetchByPolicyNoVehicleSeqCustom_Last(
		String policyNo, String vehicleSeqCustom,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
			orderByComparator);

	/**
	 * Returns the policy vehs before and after the current policy veh in the ordered set where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyVEHPK the primary key of the current policy veh
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy veh
	 * @throws NoSuchPolicyVEHException if a policy veh with the primary key could not be found
	 */
	public PolicyVEH[] findByPolicyNoVehicleSeqCustom_PrevAndNext(
			PolicyVEHPK policyVEHPK, String policyNo, String vehicleSeqCustom,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
				orderByComparator)
		throws NoSuchPolicyVEHException;

	/**
	 * Removes all the policy vehs where policyNo = &#63; and vehicleSeqCustom = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 */
	public void removeByPolicyNoVehicleSeqCustom(
		String policyNo, String vehicleSeqCustom);

	/**
	 * Returns the number of policy vehs where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @return the number of matching policy vehs
	 */
	public int countByPolicyNoVehicleSeqCustom(
		String policyNo, String vehicleSeqCustom);

	/**
	 * Returns all the policy vehs where vehicleSeqCustom = &#63;.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @return the matching policy vehs
	 */
	public java.util.List<PolicyVEH> findByVehicleSeqCustom(
		String vehicleSeqCustom);

	/**
	 * Returns a range of all the policy vehs where vehicleSeqCustom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @return the range of matching policy vehs
	 */
	public java.util.List<PolicyVEH> findByVehicleSeqCustom(
		String vehicleSeqCustom, int start, int end);

	/**
	 * Returns an ordered range of all the policy vehs where vehicleSeqCustom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy vehs
	 */
	public java.util.List<PolicyVEH> findByVehicleSeqCustom(
		String vehicleSeqCustom, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
			orderByComparator);

	/**
	 * Returns an ordered range of all the policy vehs where vehicleSeqCustom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy vehs
	 */
	public java.util.List<PolicyVEH> findByVehicleSeqCustom(
		String vehicleSeqCustom, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first policy veh in the ordered set where vehicleSeqCustom = &#63;.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	public PolicyVEH findByVehicleSeqCustom_First(
			String vehicleSeqCustom,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
				orderByComparator)
		throws NoSuchPolicyVEHException;

	/**
	 * Returns the first policy veh in the ordered set where vehicleSeqCustom = &#63;.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	public PolicyVEH fetchByVehicleSeqCustom_First(
		String vehicleSeqCustom,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
			orderByComparator);

	/**
	 * Returns the last policy veh in the ordered set where vehicleSeqCustom = &#63;.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	public PolicyVEH findByVehicleSeqCustom_Last(
			String vehicleSeqCustom,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
				orderByComparator)
		throws NoSuchPolicyVEHException;

	/**
	 * Returns the last policy veh in the ordered set where vehicleSeqCustom = &#63;.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	public PolicyVEH fetchByVehicleSeqCustom_Last(
		String vehicleSeqCustom,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
			orderByComparator);

	/**
	 * Returns the policy vehs before and after the current policy veh in the ordered set where vehicleSeqCustom = &#63;.
	 *
	 * @param policyVEHPK the primary key of the current policy veh
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy veh
	 * @throws NoSuchPolicyVEHException if a policy veh with the primary key could not be found
	 */
	public PolicyVEH[] findByVehicleSeqCustom_PrevAndNext(
			PolicyVEHPK policyVEHPK, String vehicleSeqCustom,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
				orderByComparator)
		throws NoSuchPolicyVEHException;

	/**
	 * Removes all the policy vehs where vehicleSeqCustom = &#63; from the database.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 */
	public void removeByVehicleSeqCustom(String vehicleSeqCustom);

	/**
	 * Returns the number of policy vehs where vehicleSeqCustom = &#63;.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @return the number of matching policy vehs
	 */
	public int countByVehicleSeqCustom(String vehicleSeqCustom);

	/**
	 * Returns all the policy vehs where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @return the matching policy vehs
	 */
	public java.util.List<PolicyVEH> findByEnPlateNo(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3);

	/**
	 * Returns a range of all the policy vehs where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @return the range of matching policy vehs
	 */
	public java.util.List<PolicyVEH> findByEnPlateNo(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3,
		int start, int end);

	/**
	 * Returns an ordered range of all the policy vehs where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy vehs
	 */
	public java.util.List<PolicyVEH> findByEnPlateNo(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
			orderByComparator);

	/**
	 * Returns an ordered range of all the policy vehs where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy vehs
	 */
	public java.util.List<PolicyVEH> findByEnPlateNo(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first policy veh in the ordered set where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	public PolicyVEH findByEnPlateNo_First(
			long enPlateNo, String enPlateL1, String enPlateL2,
			String enPlateL3,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
				orderByComparator)
		throws NoSuchPolicyVEHException;

	/**
	 * Returns the first policy veh in the ordered set where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	public PolicyVEH fetchByEnPlateNo_First(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
			orderByComparator);

	/**
	 * Returns the last policy veh in the ordered set where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	public PolicyVEH findByEnPlateNo_Last(
			long enPlateNo, String enPlateL1, String enPlateL2,
			String enPlateL3,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
				orderByComparator)
		throws NoSuchPolicyVEHException;

	/**
	 * Returns the last policy veh in the ordered set where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	public PolicyVEH fetchByEnPlateNo_Last(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
			orderByComparator);

	/**
	 * Returns the policy vehs before and after the current policy veh in the ordered set where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * @param policyVEHPK the primary key of the current policy veh
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy veh
	 * @throws NoSuchPolicyVEHException if a policy veh with the primary key could not be found
	 */
	public PolicyVEH[] findByEnPlateNo_PrevAndNext(
			PolicyVEHPK policyVEHPK, long enPlateNo, String enPlateL1,
			String enPlateL2, String enPlateL3,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
				orderByComparator)
		throws NoSuchPolicyVEHException;

	/**
	 * Removes all the policy vehs where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63; from the database.
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 */
	public void removeByEnPlateNo(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3);

	/**
	 * Returns the number of policy vehs where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @return the number of matching policy vehs
	 */
	public int countByEnPlateNo(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3);

	/**
	 * Returns the policy veh where policyNo = &#63; or throws a <code>NoSuchPolicyVEHException</code> if it could not be found.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	public PolicyVEH findBypolicyNumber(String policyNo)
		throws NoSuchPolicyVEHException;

	/**
	 * Returns the policy veh where policyNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	public PolicyVEH fetchBypolicyNumber(String policyNo);

	/**
	 * Returns the policy veh where policyNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyNo the policy no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	public PolicyVEH fetchBypolicyNumber(
		String policyNo, boolean useFinderCache);

	/**
	 * Removes the policy veh where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 * @return the policy veh that was removed
	 */
	public PolicyVEH removeBypolicyNumber(String policyNo)
		throws NoSuchPolicyVEHException;

	/**
	 * Returns the number of policy vehs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching policy vehs
	 */
	public int countBypolicyNumber(String policyNo);

	/**
	 * Returns all the policy vehs where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @return the matching policy vehs
	 */
	public java.util.List<PolicyVEH> findByArPlateNo(
		String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3);

	/**
	 * Returns a range of all the policy vehs where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @return the range of matching policy vehs
	 */
	public java.util.List<PolicyVEH> findByArPlateNo(
		String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3,
		int start, int end);

	/**
	 * Returns an ordered range of all the policy vehs where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy vehs
	 */
	public java.util.List<PolicyVEH> findByArPlateNo(
		String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
			orderByComparator);

	/**
	 * Returns an ordered range of all the policy vehs where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy vehs
	 */
	public java.util.List<PolicyVEH> findByArPlateNo(
		String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first policy veh in the ordered set where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	public PolicyVEH findByArPlateNo_First(
			String arPlateNo, String arPlateL1, String arPlateL2,
			String arPlateL3,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
				orderByComparator)
		throws NoSuchPolicyVEHException;

	/**
	 * Returns the first policy veh in the ordered set where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	public PolicyVEH fetchByArPlateNo_First(
		String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
			orderByComparator);

	/**
	 * Returns the last policy veh in the ordered set where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	public PolicyVEH findByArPlateNo_Last(
			String arPlateNo, String arPlateL1, String arPlateL2,
			String arPlateL3,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
				orderByComparator)
		throws NoSuchPolicyVEHException;

	/**
	 * Returns the last policy veh in the ordered set where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	public PolicyVEH fetchByArPlateNo_Last(
		String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
			orderByComparator);

	/**
	 * Returns the policy vehs before and after the current policy veh in the ordered set where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * @param policyVEHPK the primary key of the current policy veh
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy veh
	 * @throws NoSuchPolicyVEHException if a policy veh with the primary key could not be found
	 */
	public PolicyVEH[] findByArPlateNo_PrevAndNext(
			PolicyVEHPK policyVEHPK, String arPlateNo, String arPlateL1,
			String arPlateL2, String arPlateL3,
			com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
				orderByComparator)
		throws NoSuchPolicyVEHException;

	/**
	 * Removes all the policy vehs where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63; from the database.
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 */
	public void removeByArPlateNo(
		String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3);

	/**
	 * Returns the number of policy vehs where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @return the number of matching policy vehs
	 */
	public int countByArPlateNo(
		String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3);

	/**
	 * Caches the policy veh in the entity cache if it is enabled.
	 *
	 * @param policyVEH the policy veh
	 */
	public void cacheResult(PolicyVEH policyVEH);

	/**
	 * Caches the policy vehs in the entity cache if it is enabled.
	 *
	 * @param policyVEHs the policy vehs
	 */
	public void cacheResult(java.util.List<PolicyVEH> policyVEHs);

	/**
	 * Creates a new policy veh with the primary key. Does not add the policy veh to the database.
	 *
	 * @param policyVEHPK the primary key for the new policy veh
	 * @return the new policy veh
	 */
	public PolicyVEH create(PolicyVEHPK policyVEHPK);

	/**
	 * Removes the policy veh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyVEHPK the primary key of the policy veh
	 * @return the policy veh that was removed
	 * @throws NoSuchPolicyVEHException if a policy veh with the primary key could not be found
	 */
	public PolicyVEH remove(PolicyVEHPK policyVEHPK)
		throws NoSuchPolicyVEHException;

	public PolicyVEH updateImpl(PolicyVEH policyVEH);

	/**
	 * Returns the policy veh with the primary key or throws a <code>NoSuchPolicyVEHException</code> if it could not be found.
	 *
	 * @param policyVEHPK the primary key of the policy veh
	 * @return the policy veh
	 * @throws NoSuchPolicyVEHException if a policy veh with the primary key could not be found
	 */
	public PolicyVEH findByPrimaryKey(PolicyVEHPK policyVEHPK)
		throws NoSuchPolicyVEHException;

	/**
	 * Returns the policy veh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyVEHPK the primary key of the policy veh
	 * @return the policy veh, or <code>null</code> if a policy veh with the primary key could not be found
	 */
	public PolicyVEH fetchByPrimaryKey(PolicyVEHPK policyVEHPK);

	/**
	 * Returns all the policy vehs.
	 *
	 * @return the policy vehs
	 */
	public java.util.List<PolicyVEH> findAll();

	/**
	 * Returns a range of all the policy vehs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @return the range of policy vehs
	 */
	public java.util.List<PolicyVEH> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the policy vehs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy vehs
	 */
	public java.util.List<PolicyVEH> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
			orderByComparator);

	/**
	 * Returns an ordered range of all the policy vehs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy vehs
	 */
	public java.util.List<PolicyVEH> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyVEH>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the policy vehs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of policy vehs.
	 *
	 * @return the number of policy vehs
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}