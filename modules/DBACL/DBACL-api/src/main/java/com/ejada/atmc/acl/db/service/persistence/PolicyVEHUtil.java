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

import com.ejada.atmc.acl.db.model.PolicyVEH;

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
 * The persistence utility for the policy veh service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.PolicyVEHPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyVEHPersistence
 * @generated
 */
public class PolicyVEHUtil {

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
	public static void clearCache(PolicyVEH policyVEH) {
		getPersistence().clearCache(policyVEH);
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
	public static Map<Serializable, PolicyVEH> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PolicyVEH> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PolicyVEH> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PolicyVEH> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PolicyVEH> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PolicyVEH update(PolicyVEH policyVEH) {
		return getPersistence().update(policyVEH);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PolicyVEH update(
		PolicyVEH policyVEH, ServiceContext serviceContext) {

		return getPersistence().update(policyVEH, serviceContext);
	}

	/**
	 * Returns all the policy vehs where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @return the matching policy vehs
	 */
	public static List<PolicyVEH> findByPolicyNoVehicleSeqCustom(
		String policyNo, String vehicleSeqCustom) {

		return getPersistence().findByPolicyNoVehicleSeqCustom(
			policyNo, vehicleSeqCustom);
	}

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
	public static List<PolicyVEH> findByPolicyNoVehicleSeqCustom(
		String policyNo, String vehicleSeqCustom, int start, int end) {

		return getPersistence().findByPolicyNoVehicleSeqCustom(
			policyNo, vehicleSeqCustom, start, end);
	}

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
	public static List<PolicyVEH> findByPolicyNoVehicleSeqCustom(
		String policyNo, String vehicleSeqCustom, int start, int end,
		OrderByComparator<PolicyVEH> orderByComparator) {

		return getPersistence().findByPolicyNoVehicleSeqCustom(
			policyNo, vehicleSeqCustom, start, end, orderByComparator);
	}

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
	public static List<PolicyVEH> findByPolicyNoVehicleSeqCustom(
		String policyNo, String vehicleSeqCustom, int start, int end,
		OrderByComparator<PolicyVEH> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPolicyNoVehicleSeqCustom(
			policyNo, vehicleSeqCustom, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first policy veh in the ordered set where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	public static PolicyVEH findByPolicyNoVehicleSeqCustom_First(
			String policyNo, String vehicleSeqCustom,
			OrderByComparator<PolicyVEH> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getPersistence().findByPolicyNoVehicleSeqCustom_First(
			policyNo, vehicleSeqCustom, orderByComparator);
	}

	/**
	 * Returns the first policy veh in the ordered set where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	public static PolicyVEH fetchByPolicyNoVehicleSeqCustom_First(
		String policyNo, String vehicleSeqCustom,
		OrderByComparator<PolicyVEH> orderByComparator) {

		return getPersistence().fetchByPolicyNoVehicleSeqCustom_First(
			policyNo, vehicleSeqCustom, orderByComparator);
	}

	/**
	 * Returns the last policy veh in the ordered set where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	public static PolicyVEH findByPolicyNoVehicleSeqCustom_Last(
			String policyNo, String vehicleSeqCustom,
			OrderByComparator<PolicyVEH> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getPersistence().findByPolicyNoVehicleSeqCustom_Last(
			policyNo, vehicleSeqCustom, orderByComparator);
	}

	/**
	 * Returns the last policy veh in the ordered set where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	public static PolicyVEH fetchByPolicyNoVehicleSeqCustom_Last(
		String policyNo, String vehicleSeqCustom,
		OrderByComparator<PolicyVEH> orderByComparator) {

		return getPersistence().fetchByPolicyNoVehicleSeqCustom_Last(
			policyNo, vehicleSeqCustom, orderByComparator);
	}

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
	public static PolicyVEH[] findByPolicyNoVehicleSeqCustom_PrevAndNext(
			PolicyVEHPK policyVEHPK, String policyNo, String vehicleSeqCustom,
			OrderByComparator<PolicyVEH> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getPersistence().findByPolicyNoVehicleSeqCustom_PrevAndNext(
			policyVEHPK, policyNo, vehicleSeqCustom, orderByComparator);
	}

	/**
	 * Removes all the policy vehs where policyNo = &#63; and vehicleSeqCustom = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 */
	public static void removeByPolicyNoVehicleSeqCustom(
		String policyNo, String vehicleSeqCustom) {

		getPersistence().removeByPolicyNoVehicleSeqCustom(
			policyNo, vehicleSeqCustom);
	}

	/**
	 * Returns the number of policy vehs where policyNo = &#63; and vehicleSeqCustom = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @return the number of matching policy vehs
	 */
	public static int countByPolicyNoVehicleSeqCustom(
		String policyNo, String vehicleSeqCustom) {

		return getPersistence().countByPolicyNoVehicleSeqCustom(
			policyNo, vehicleSeqCustom);
	}

	/**
	 * Returns all the policy vehs where vehicleSeqCustom = &#63;.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @return the matching policy vehs
	 */
	public static List<PolicyVEH> findByVehicleSeqCustom(
		String vehicleSeqCustom) {

		return getPersistence().findByVehicleSeqCustom(vehicleSeqCustom);
	}

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
	public static List<PolicyVEH> findByVehicleSeqCustom(
		String vehicleSeqCustom, int start, int end) {

		return getPersistence().findByVehicleSeqCustom(
			vehicleSeqCustom, start, end);
	}

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
	public static List<PolicyVEH> findByVehicleSeqCustom(
		String vehicleSeqCustom, int start, int end,
		OrderByComparator<PolicyVEH> orderByComparator) {

		return getPersistence().findByVehicleSeqCustom(
			vehicleSeqCustom, start, end, orderByComparator);
	}

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
	public static List<PolicyVEH> findByVehicleSeqCustom(
		String vehicleSeqCustom, int start, int end,
		OrderByComparator<PolicyVEH> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByVehicleSeqCustom(
			vehicleSeqCustom, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first policy veh in the ordered set where vehicleSeqCustom = &#63;.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	public static PolicyVEH findByVehicleSeqCustom_First(
			String vehicleSeqCustom,
			OrderByComparator<PolicyVEH> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getPersistence().findByVehicleSeqCustom_First(
			vehicleSeqCustom, orderByComparator);
	}

	/**
	 * Returns the first policy veh in the ordered set where vehicleSeqCustom = &#63;.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	public static PolicyVEH fetchByVehicleSeqCustom_First(
		String vehicleSeqCustom,
		OrderByComparator<PolicyVEH> orderByComparator) {

		return getPersistence().fetchByVehicleSeqCustom_First(
			vehicleSeqCustom, orderByComparator);
	}

	/**
	 * Returns the last policy veh in the ordered set where vehicleSeqCustom = &#63;.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	public static PolicyVEH findByVehicleSeqCustom_Last(
			String vehicleSeqCustom,
			OrderByComparator<PolicyVEH> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getPersistence().findByVehicleSeqCustom_Last(
			vehicleSeqCustom, orderByComparator);
	}

	/**
	 * Returns the last policy veh in the ordered set where vehicleSeqCustom = &#63;.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	public static PolicyVEH fetchByVehicleSeqCustom_Last(
		String vehicleSeqCustom,
		OrderByComparator<PolicyVEH> orderByComparator) {

		return getPersistence().fetchByVehicleSeqCustom_Last(
			vehicleSeqCustom, orderByComparator);
	}

	/**
	 * Returns the policy vehs before and after the current policy veh in the ordered set where vehicleSeqCustom = &#63;.
	 *
	 * @param policyVEHPK the primary key of the current policy veh
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy veh
	 * @throws NoSuchPolicyVEHException if a policy veh with the primary key could not be found
	 */
	public static PolicyVEH[] findByVehicleSeqCustom_PrevAndNext(
			PolicyVEHPK policyVEHPK, String vehicleSeqCustom,
			OrderByComparator<PolicyVEH> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getPersistence().findByVehicleSeqCustom_PrevAndNext(
			policyVEHPK, vehicleSeqCustom, orderByComparator);
	}

	/**
	 * Removes all the policy vehs where vehicleSeqCustom = &#63; from the database.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 */
	public static void removeByVehicleSeqCustom(String vehicleSeqCustom) {
		getPersistence().removeByVehicleSeqCustom(vehicleSeqCustom);
	}

	/**
	 * Returns the number of policy vehs where vehicleSeqCustom = &#63;.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom
	 * @return the number of matching policy vehs
	 */
	public static int countByVehicleSeqCustom(String vehicleSeqCustom) {
		return getPersistence().countByVehicleSeqCustom(vehicleSeqCustom);
	}

	/**
	 * Returns all the policy vehs where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @return the matching policy vehs
	 */
	public static List<PolicyVEH> findByEnPlateNo(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3) {

		return getPersistence().findByEnPlateNo(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3);
	}

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
	public static List<PolicyVEH> findByEnPlateNo(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3,
		int start, int end) {

		return getPersistence().findByEnPlateNo(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3, start, end);
	}

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
	public static List<PolicyVEH> findByEnPlateNo(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3,
		int start, int end, OrderByComparator<PolicyVEH> orderByComparator) {

		return getPersistence().findByEnPlateNo(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3, start, end,
			orderByComparator);
	}

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
	public static List<PolicyVEH> findByEnPlateNo(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3,
		int start, int end, OrderByComparator<PolicyVEH> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEnPlateNo(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3, start, end,
			orderByComparator, useFinderCache);
	}

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
	public static PolicyVEH findByEnPlateNo_First(
			long enPlateNo, String enPlateL1, String enPlateL2,
			String enPlateL3, OrderByComparator<PolicyVEH> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getPersistence().findByEnPlateNo_First(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3, orderByComparator);
	}

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
	public static PolicyVEH fetchByEnPlateNo_First(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3,
		OrderByComparator<PolicyVEH> orderByComparator) {

		return getPersistence().fetchByEnPlateNo_First(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3, orderByComparator);
	}

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
	public static PolicyVEH findByEnPlateNo_Last(
			long enPlateNo, String enPlateL1, String enPlateL2,
			String enPlateL3, OrderByComparator<PolicyVEH> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getPersistence().findByEnPlateNo_Last(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3, orderByComparator);
	}

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
	public static PolicyVEH fetchByEnPlateNo_Last(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3,
		OrderByComparator<PolicyVEH> orderByComparator) {

		return getPersistence().fetchByEnPlateNo_Last(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3, orderByComparator);
	}

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
	public static PolicyVEH[] findByEnPlateNo_PrevAndNext(
			PolicyVEHPK policyVEHPK, long enPlateNo, String enPlateL1,
			String enPlateL2, String enPlateL3,
			OrderByComparator<PolicyVEH> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getPersistence().findByEnPlateNo_PrevAndNext(
			policyVEHPK, enPlateNo, enPlateL1, enPlateL2, enPlateL3,
			orderByComparator);
	}

	/**
	 * Removes all the policy vehs where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63; from the database.
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 */
	public static void removeByEnPlateNo(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3) {

		getPersistence().removeByEnPlateNo(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3);
	}

	/**
	 * Returns the number of policy vehs where enPlateNo = &#63; and enPlateL1 = &#63; and enPlateL2 = &#63; and enPlateL3 = &#63;.
	 *
	 * @param enPlateNo the en plate no
	 * @param enPlateL1 the en plate l1
	 * @param enPlateL2 the en plate l2
	 * @param enPlateL3 the en plate l3
	 * @return the number of matching policy vehs
	 */
	public static int countByEnPlateNo(
		long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3) {

		return getPersistence().countByEnPlateNo(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3);
	}

	/**
	 * Returns the policy veh where policyNo = &#63; or throws a <code>NoSuchPolicyVEHException</code> if it could not be found.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy veh
	 * @throws NoSuchPolicyVEHException if a matching policy veh could not be found
	 */
	public static PolicyVEH findBypolicyNumber(String policyNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getPersistence().findBypolicyNumber(policyNo);
	}

	/**
	 * Returns the policy veh where policyNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	public static PolicyVEH fetchBypolicyNumber(String policyNo) {
		return getPersistence().fetchBypolicyNumber(policyNo);
	}

	/**
	 * Returns the policy veh where policyNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyNo the policy no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy veh, or <code>null</code> if a matching policy veh could not be found
	 */
	public static PolicyVEH fetchBypolicyNumber(
		String policyNo, boolean useFinderCache) {

		return getPersistence().fetchBypolicyNumber(policyNo, useFinderCache);
	}

	/**
	 * Removes the policy veh where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 * @return the policy veh that was removed
	 */
	public static PolicyVEH removeBypolicyNumber(String policyNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getPersistence().removeBypolicyNumber(policyNo);
	}

	/**
	 * Returns the number of policy vehs where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching policy vehs
	 */
	public static int countBypolicyNumber(String policyNo) {
		return getPersistence().countBypolicyNumber(policyNo);
	}

	/**
	 * Returns all the policy vehs where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @return the matching policy vehs
	 */
	public static List<PolicyVEH> findByArPlateNo(
		String arPlateNo, String arPlateL1, String arPlateL2,
		String arPlateL3) {

		return getPersistence().findByArPlateNo(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3);
	}

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
	public static List<PolicyVEH> findByArPlateNo(
		String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3,
		int start, int end) {

		return getPersistence().findByArPlateNo(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3, start, end);
	}

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
	public static List<PolicyVEH> findByArPlateNo(
		String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3,
		int start, int end, OrderByComparator<PolicyVEH> orderByComparator) {

		return getPersistence().findByArPlateNo(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3, start, end,
			orderByComparator);
	}

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
	public static List<PolicyVEH> findByArPlateNo(
		String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3,
		int start, int end, OrderByComparator<PolicyVEH> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByArPlateNo(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3, start, end,
			orderByComparator, useFinderCache);
	}

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
	public static PolicyVEH findByArPlateNo_First(
			String arPlateNo, String arPlateL1, String arPlateL2,
			String arPlateL3, OrderByComparator<PolicyVEH> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getPersistence().findByArPlateNo_First(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3, orderByComparator);
	}

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
	public static PolicyVEH fetchByArPlateNo_First(
		String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3,
		OrderByComparator<PolicyVEH> orderByComparator) {

		return getPersistence().fetchByArPlateNo_First(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3, orderByComparator);
	}

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
	public static PolicyVEH findByArPlateNo_Last(
			String arPlateNo, String arPlateL1, String arPlateL2,
			String arPlateL3, OrderByComparator<PolicyVEH> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getPersistence().findByArPlateNo_Last(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3, orderByComparator);
	}

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
	public static PolicyVEH fetchByArPlateNo_Last(
		String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3,
		OrderByComparator<PolicyVEH> orderByComparator) {

		return getPersistence().fetchByArPlateNo_Last(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3, orderByComparator);
	}

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
	public static PolicyVEH[] findByArPlateNo_PrevAndNext(
			PolicyVEHPK policyVEHPK, String arPlateNo, String arPlateL1,
			String arPlateL2, String arPlateL3,
			OrderByComparator<PolicyVEH> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getPersistence().findByArPlateNo_PrevAndNext(
			policyVEHPK, arPlateNo, arPlateL1, arPlateL2, arPlateL3,
			orderByComparator);
	}

	/**
	 * Removes all the policy vehs where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63; from the database.
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 */
	public static void removeByArPlateNo(
		String arPlateNo, String arPlateL1, String arPlateL2,
		String arPlateL3) {

		getPersistence().removeByArPlateNo(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3);
	}

	/**
	 * Returns the number of policy vehs where arPlateNo = &#63; and arPlateL1 = &#63; and arPlateL2 = &#63; and arPlateL3 = &#63;.
	 *
	 * @param arPlateNo the ar plate no
	 * @param arPlateL1 the ar plate l1
	 * @param arPlateL2 the ar plate l2
	 * @param arPlateL3 the ar plate l3
	 * @return the number of matching policy vehs
	 */
	public static int countByArPlateNo(
		String arPlateNo, String arPlateL1, String arPlateL2,
		String arPlateL3) {

		return getPersistence().countByArPlateNo(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3);
	}

	/**
	 * Caches the policy veh in the entity cache if it is enabled.
	 *
	 * @param policyVEH the policy veh
	 */
	public static void cacheResult(PolicyVEH policyVEH) {
		getPersistence().cacheResult(policyVEH);
	}

	/**
	 * Caches the policy vehs in the entity cache if it is enabled.
	 *
	 * @param policyVEHs the policy vehs
	 */
	public static void cacheResult(List<PolicyVEH> policyVEHs) {
		getPersistence().cacheResult(policyVEHs);
	}

	/**
	 * Creates a new policy veh with the primary key. Does not add the policy veh to the database.
	 *
	 * @param policyVEHPK the primary key for the new policy veh
	 * @return the new policy veh
	 */
	public static PolicyVEH create(PolicyVEHPK policyVEHPK) {
		return getPersistence().create(policyVEHPK);
	}

	/**
	 * Removes the policy veh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyVEHPK the primary key of the policy veh
	 * @return the policy veh that was removed
	 * @throws NoSuchPolicyVEHException if a policy veh with the primary key could not be found
	 */
	public static PolicyVEH remove(PolicyVEHPK policyVEHPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getPersistence().remove(policyVEHPK);
	}

	public static PolicyVEH updateImpl(PolicyVEH policyVEH) {
		return getPersistence().updateImpl(policyVEH);
	}

	/**
	 * Returns the policy veh with the primary key or throws a <code>NoSuchPolicyVEHException</code> if it could not be found.
	 *
	 * @param policyVEHPK the primary key of the policy veh
	 * @return the policy veh
	 * @throws NoSuchPolicyVEHException if a policy veh with the primary key could not be found
	 */
	public static PolicyVEH findByPrimaryKey(PolicyVEHPK policyVEHPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getPersistence().findByPrimaryKey(policyVEHPK);
	}

	/**
	 * Returns the policy veh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyVEHPK the primary key of the policy veh
	 * @return the policy veh, or <code>null</code> if a policy veh with the primary key could not be found
	 */
	public static PolicyVEH fetchByPrimaryKey(PolicyVEHPK policyVEHPK) {
		return getPersistence().fetchByPrimaryKey(policyVEHPK);
	}

	/**
	 * Returns all the policy vehs.
	 *
	 * @return the policy vehs
	 */
	public static List<PolicyVEH> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<PolicyVEH> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<PolicyVEH> findAll(
		int start, int end, OrderByComparator<PolicyVEH> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<PolicyVEH> findAll(
		int start, int end, OrderByComparator<PolicyVEH> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the policy vehs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of policy vehs.
	 *
	 * @return the number of policy vehs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static PolicyVEHPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PolicyVEHPersistence, PolicyVEHPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PolicyVEHPersistence.class);

		ServiceTracker<PolicyVEHPersistence, PolicyVEHPersistence>
			serviceTracker =
				new ServiceTracker<PolicyVEHPersistence, PolicyVEHPersistence>(
					bundle.getBundleContext(), PolicyVEHPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}