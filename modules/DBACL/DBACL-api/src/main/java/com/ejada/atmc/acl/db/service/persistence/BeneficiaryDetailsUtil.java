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

import com.ejada.atmc.acl.db.model.BeneficiaryDetails;

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
 * The persistence utility for the beneficiary details service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.BeneficiaryDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BeneficiaryDetailsPersistence
 * @generated
 */
public class BeneficiaryDetailsUtil {

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
	public static void clearCache(BeneficiaryDetails beneficiaryDetails) {
		getPersistence().clearCache(beneficiaryDetails);
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
	public static Map<Serializable, BeneficiaryDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BeneficiaryDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BeneficiaryDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BeneficiaryDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BeneficiaryDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BeneficiaryDetails update(
		BeneficiaryDetails beneficiaryDetails) {

		return getPersistence().update(beneficiaryDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BeneficiaryDetails update(
		BeneficiaryDetails beneficiaryDetails, ServiceContext serviceContext) {

		return getPersistence().update(beneficiaryDetails, serviceContext);
	}

	/**
	 * Returns all the beneficiary detailses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the matching beneficiary detailses
	 */
	public static List<BeneficiaryDetails> findByPolicyNo(String policyNo) {
		return getPersistence().findByPolicyNo(policyNo);
	}

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
	public static List<BeneficiaryDetails> findByPolicyNo(
		String policyNo, int start, int end) {

		return getPersistence().findByPolicyNo(policyNo, start, end);
	}

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
	public static List<BeneficiaryDetails> findByPolicyNo(
		String policyNo, int start, int end,
		OrderByComparator<BeneficiaryDetails> orderByComparator) {

		return getPersistence().findByPolicyNo(
			policyNo, start, end, orderByComparator);
	}

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
	public static List<BeneficiaryDetails> findByPolicyNo(
		String policyNo, int start, int end,
		OrderByComparator<BeneficiaryDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPolicyNo(
			policyNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first beneficiary details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching beneficiary details
	 * @throws NoSuchBeneficiaryDetailsException if a matching beneficiary details could not be found
	 */
	public static BeneficiaryDetails findByPolicyNo_First(
			String policyNo,
			OrderByComparator<BeneficiaryDetails> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchBeneficiaryDetailsException {

		return getPersistence().findByPolicyNo_First(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the first beneficiary details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching beneficiary details, or <code>null</code> if a matching beneficiary details could not be found
	 */
	public static BeneficiaryDetails fetchByPolicyNo_First(
		String policyNo,
		OrderByComparator<BeneficiaryDetails> orderByComparator) {

		return getPersistence().fetchByPolicyNo_First(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the last beneficiary details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching beneficiary details
	 * @throws NoSuchBeneficiaryDetailsException if a matching beneficiary details could not be found
	 */
	public static BeneficiaryDetails findByPolicyNo_Last(
			String policyNo,
			OrderByComparator<BeneficiaryDetails> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchBeneficiaryDetailsException {

		return getPersistence().findByPolicyNo_Last(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the last beneficiary details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching beneficiary details, or <code>null</code> if a matching beneficiary details could not be found
	 */
	public static BeneficiaryDetails fetchByPolicyNo_Last(
		String policyNo,
		OrderByComparator<BeneficiaryDetails> orderByComparator) {

		return getPersistence().fetchByPolicyNo_Last(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the beneficiary detailses before and after the current beneficiary details in the ordered set where policyNo = &#63;.
	 *
	 * @param benfId the primary key of the current beneficiary details
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next beneficiary details
	 * @throws NoSuchBeneficiaryDetailsException if a beneficiary details with the primary key could not be found
	 */
	public static BeneficiaryDetails[] findByPolicyNo_PrevAndNext(
			long benfId, String policyNo,
			OrderByComparator<BeneficiaryDetails> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchBeneficiaryDetailsException {

		return getPersistence().findByPolicyNo_PrevAndNext(
			benfId, policyNo, orderByComparator);
	}

	/**
	 * Removes all the beneficiary detailses where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 */
	public static void removeByPolicyNo(String policyNo) {
		getPersistence().removeByPolicyNo(policyNo);
	}

	/**
	 * Returns the number of beneficiary detailses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching beneficiary detailses
	 */
	public static int countByPolicyNo(String policyNo) {
		return getPersistence().countByPolicyNo(policyNo);
	}

	/**
	 * Caches the beneficiary details in the entity cache if it is enabled.
	 *
	 * @param beneficiaryDetails the beneficiary details
	 */
	public static void cacheResult(BeneficiaryDetails beneficiaryDetails) {
		getPersistence().cacheResult(beneficiaryDetails);
	}

	/**
	 * Caches the beneficiary detailses in the entity cache if it is enabled.
	 *
	 * @param beneficiaryDetailses the beneficiary detailses
	 */
	public static void cacheResult(
		List<BeneficiaryDetails> beneficiaryDetailses) {

		getPersistence().cacheResult(beneficiaryDetailses);
	}

	/**
	 * Creates a new beneficiary details with the primary key. Does not add the beneficiary details to the database.
	 *
	 * @param benfId the primary key for the new beneficiary details
	 * @return the new beneficiary details
	 */
	public static BeneficiaryDetails create(long benfId) {
		return getPersistence().create(benfId);
	}

	/**
	 * Removes the beneficiary details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param benfId the primary key of the beneficiary details
	 * @return the beneficiary details that was removed
	 * @throws NoSuchBeneficiaryDetailsException if a beneficiary details with the primary key could not be found
	 */
	public static BeneficiaryDetails remove(long benfId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchBeneficiaryDetailsException {

		return getPersistence().remove(benfId);
	}

	public static BeneficiaryDetails updateImpl(
		BeneficiaryDetails beneficiaryDetails) {

		return getPersistence().updateImpl(beneficiaryDetails);
	}

	/**
	 * Returns the beneficiary details with the primary key or throws a <code>NoSuchBeneficiaryDetailsException</code> if it could not be found.
	 *
	 * @param benfId the primary key of the beneficiary details
	 * @return the beneficiary details
	 * @throws NoSuchBeneficiaryDetailsException if a beneficiary details with the primary key could not be found
	 */
	public static BeneficiaryDetails findByPrimaryKey(long benfId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchBeneficiaryDetailsException {

		return getPersistence().findByPrimaryKey(benfId);
	}

	/**
	 * Returns the beneficiary details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param benfId the primary key of the beneficiary details
	 * @return the beneficiary details, or <code>null</code> if a beneficiary details with the primary key could not be found
	 */
	public static BeneficiaryDetails fetchByPrimaryKey(long benfId) {
		return getPersistence().fetchByPrimaryKey(benfId);
	}

	/**
	 * Returns all the beneficiary detailses.
	 *
	 * @return the beneficiary detailses
	 */
	public static List<BeneficiaryDetails> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<BeneficiaryDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<BeneficiaryDetails> findAll(
		int start, int end,
		OrderByComparator<BeneficiaryDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<BeneficiaryDetails> findAll(
		int start, int end,
		OrderByComparator<BeneficiaryDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the beneficiary detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of beneficiary detailses.
	 *
	 * @return the number of beneficiary detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BeneficiaryDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<BeneficiaryDetailsPersistence, BeneficiaryDetailsPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			BeneficiaryDetailsPersistence.class);

		ServiceTracker
			<BeneficiaryDetailsPersistence, BeneficiaryDetailsPersistence>
				serviceTracker =
					new ServiceTracker
						<BeneficiaryDetailsPersistence,
						 BeneficiaryDetailsPersistence>(
							 bundle.getBundleContext(),
							 BeneficiaryDetailsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}