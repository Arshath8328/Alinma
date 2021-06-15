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

import com.ejada.atmc.acl.db.model.PolicyMemberDetails;

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
 * The persistence utility for the policy member details service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.PolicyMemberDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyMemberDetailsPersistence
 * @generated
 */
public class PolicyMemberDetailsUtil {

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
	public static void clearCache(PolicyMemberDetails policyMemberDetails) {
		getPersistence().clearCache(policyMemberDetails);
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
	public static Map<Serializable, PolicyMemberDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PolicyMemberDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PolicyMemberDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PolicyMemberDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PolicyMemberDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PolicyMemberDetails update(
		PolicyMemberDetails policyMemberDetails) {

		return getPersistence().update(policyMemberDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PolicyMemberDetails update(
		PolicyMemberDetails policyMemberDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(policyMemberDetails, serviceContext);
	}

	/**
	 * Returns all the policy member detailses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the matching policy member detailses
	 */
	public static List<PolicyMemberDetails> findByPolicyNo(String policyNo) {
		return getPersistence().findByPolicyNo(policyNo);
	}

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
	public static List<PolicyMemberDetails> findByPolicyNo(
		String policyNo, int start, int end) {

		return getPersistence().findByPolicyNo(policyNo, start, end);
	}

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
	public static List<PolicyMemberDetails> findByPolicyNo(
		String policyNo, int start, int end,
		OrderByComparator<PolicyMemberDetails> orderByComparator) {

		return getPersistence().findByPolicyNo(
			policyNo, start, end, orderByComparator);
	}

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
	public static List<PolicyMemberDetails> findByPolicyNo(
		String policyNo, int start, int end,
		OrderByComparator<PolicyMemberDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPolicyNo(
			policyNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first policy member details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy member details
	 * @throws NoSuchPolicyMemberDetailsException if a matching policy member details could not be found
	 */
	public static PolicyMemberDetails findByPolicyNo_First(
			String policyNo,
			OrderByComparator<PolicyMemberDetails> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyMemberDetailsException {

		return getPersistence().findByPolicyNo_First(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the first policy member details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy member details, or <code>null</code> if a matching policy member details could not be found
	 */
	public static PolicyMemberDetails fetchByPolicyNo_First(
		String policyNo,
		OrderByComparator<PolicyMemberDetails> orderByComparator) {

		return getPersistence().fetchByPolicyNo_First(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the last policy member details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy member details
	 * @throws NoSuchPolicyMemberDetailsException if a matching policy member details could not be found
	 */
	public static PolicyMemberDetails findByPolicyNo_Last(
			String policyNo,
			OrderByComparator<PolicyMemberDetails> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyMemberDetailsException {

		return getPersistence().findByPolicyNo_Last(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the last policy member details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy member details, or <code>null</code> if a matching policy member details could not be found
	 */
	public static PolicyMemberDetails fetchByPolicyNo_Last(
		String policyNo,
		OrderByComparator<PolicyMemberDetails> orderByComparator) {

		return getPersistence().fetchByPolicyNo_Last(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the policy member detailses before and after the current policy member details in the ordered set where policyNo = &#63;.
	 *
	 * @param memberId the primary key of the current policy member details
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy member details
	 * @throws NoSuchPolicyMemberDetailsException if a policy member details with the primary key could not be found
	 */
	public static PolicyMemberDetails[] findByPolicyNo_PrevAndNext(
			long memberId, String policyNo,
			OrderByComparator<PolicyMemberDetails> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyMemberDetailsException {

		return getPersistence().findByPolicyNo_PrevAndNext(
			memberId, policyNo, orderByComparator);
	}

	/**
	 * Removes all the policy member detailses where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 */
	public static void removeByPolicyNo(String policyNo) {
		getPersistence().removeByPolicyNo(policyNo);
	}

	/**
	 * Returns the number of policy member detailses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching policy member detailses
	 */
	public static int countByPolicyNo(String policyNo) {
		return getPersistence().countByPolicyNo(policyNo);
	}

	/**
	 * Caches the policy member details in the entity cache if it is enabled.
	 *
	 * @param policyMemberDetails the policy member details
	 */
	public static void cacheResult(PolicyMemberDetails policyMemberDetails) {
		getPersistence().cacheResult(policyMemberDetails);
	}

	/**
	 * Caches the policy member detailses in the entity cache if it is enabled.
	 *
	 * @param policyMemberDetailses the policy member detailses
	 */
	public static void cacheResult(
		List<PolicyMemberDetails> policyMemberDetailses) {

		getPersistence().cacheResult(policyMemberDetailses);
	}

	/**
	 * Creates a new policy member details with the primary key. Does not add the policy member details to the database.
	 *
	 * @param memberId the primary key for the new policy member details
	 * @return the new policy member details
	 */
	public static PolicyMemberDetails create(long memberId) {
		return getPersistence().create(memberId);
	}

	/**
	 * Removes the policy member details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberId the primary key of the policy member details
	 * @return the policy member details that was removed
	 * @throws NoSuchPolicyMemberDetailsException if a policy member details with the primary key could not be found
	 */
	public static PolicyMemberDetails remove(long memberId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyMemberDetailsException {

		return getPersistence().remove(memberId);
	}

	public static PolicyMemberDetails updateImpl(
		PolicyMemberDetails policyMemberDetails) {

		return getPersistence().updateImpl(policyMemberDetails);
	}

	/**
	 * Returns the policy member details with the primary key or throws a <code>NoSuchPolicyMemberDetailsException</code> if it could not be found.
	 *
	 * @param memberId the primary key of the policy member details
	 * @return the policy member details
	 * @throws NoSuchPolicyMemberDetailsException if a policy member details with the primary key could not be found
	 */
	public static PolicyMemberDetails findByPrimaryKey(long memberId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyMemberDetailsException {

		return getPersistence().findByPrimaryKey(memberId);
	}

	/**
	 * Returns the policy member details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberId the primary key of the policy member details
	 * @return the policy member details, or <code>null</code> if a policy member details with the primary key could not be found
	 */
	public static PolicyMemberDetails fetchByPrimaryKey(long memberId) {
		return getPersistence().fetchByPrimaryKey(memberId);
	}

	/**
	 * Returns all the policy member detailses.
	 *
	 * @return the policy member detailses
	 */
	public static List<PolicyMemberDetails> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<PolicyMemberDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<PolicyMemberDetails> findAll(
		int start, int end,
		OrderByComparator<PolicyMemberDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<PolicyMemberDetails> findAll(
		int start, int end,
		OrderByComparator<PolicyMemberDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the policy member detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of policy member detailses.
	 *
	 * @return the number of policy member detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PolicyMemberDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PolicyMemberDetailsPersistence, PolicyMemberDetailsPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PolicyMemberDetailsPersistence.class);

		ServiceTracker
			<PolicyMemberDetailsPersistence, PolicyMemberDetailsPersistence>
				serviceTracker =
					new ServiceTracker
						<PolicyMemberDetailsPersistence,
						 PolicyMemberDetailsPersistence>(
							 bundle.getBundleContext(),
							 PolicyMemberDetailsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}