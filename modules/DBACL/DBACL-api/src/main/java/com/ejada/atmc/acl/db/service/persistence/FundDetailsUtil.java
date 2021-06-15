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

import com.ejada.atmc.acl.db.model.FundDetails;

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
 * The persistence utility for the fund details service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.FundDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FundDetailsPersistence
 * @generated
 */
public class FundDetailsUtil {

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
	public static void clearCache(FundDetails fundDetails) {
		getPersistence().clearCache(fundDetails);
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
	public static Map<Serializable, FundDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FundDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FundDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FundDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FundDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FundDetails update(FundDetails fundDetails) {
		return getPersistence().update(fundDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FundDetails update(
		FundDetails fundDetails, ServiceContext serviceContext) {

		return getPersistence().update(fundDetails, serviceContext);
	}

	/**
	 * Returns all the fund detailses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the matching fund detailses
	 */
	public static List<FundDetails> findByPolicyNo(String policyNo) {
		return getPersistence().findByPolicyNo(policyNo);
	}

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
	public static List<FundDetails> findByPolicyNo(
		String policyNo, int start, int end) {

		return getPersistence().findByPolicyNo(policyNo, start, end);
	}

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
	public static List<FundDetails> findByPolicyNo(
		String policyNo, int start, int end,
		OrderByComparator<FundDetails> orderByComparator) {

		return getPersistence().findByPolicyNo(
			policyNo, start, end, orderByComparator);
	}

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
	public static List<FundDetails> findByPolicyNo(
		String policyNo, int start, int end,
		OrderByComparator<FundDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPolicyNo(
			policyNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first fund details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund details
	 * @throws NoSuchFundDetailsException if a matching fund details could not be found
	 */
	public static FundDetails findByPolicyNo_First(
			String policyNo, OrderByComparator<FundDetails> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchFundDetailsException {

		return getPersistence().findByPolicyNo_First(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the first fund details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund details, or <code>null</code> if a matching fund details could not be found
	 */
	public static FundDetails fetchByPolicyNo_First(
		String policyNo, OrderByComparator<FundDetails> orderByComparator) {

		return getPersistence().fetchByPolicyNo_First(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the last fund details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund details
	 * @throws NoSuchFundDetailsException if a matching fund details could not be found
	 */
	public static FundDetails findByPolicyNo_Last(
			String policyNo, OrderByComparator<FundDetails> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchFundDetailsException {

		return getPersistence().findByPolicyNo_Last(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the last fund details in the ordered set where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund details, or <code>null</code> if a matching fund details could not be found
	 */
	public static FundDetails fetchByPolicyNo_Last(
		String policyNo, OrderByComparator<FundDetails> orderByComparator) {

		return getPersistence().fetchByPolicyNo_Last(
			policyNo, orderByComparator);
	}

	/**
	 * Returns the fund detailses before and after the current fund details in the ordered set where policyNo = &#63;.
	 *
	 * @param fundName the primary key of the current fund details
	 * @param policyNo the policy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fund details
	 * @throws NoSuchFundDetailsException if a fund details with the primary key could not be found
	 */
	public static FundDetails[] findByPolicyNo_PrevAndNext(
			String fundName, String policyNo,
			OrderByComparator<FundDetails> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchFundDetailsException {

		return getPersistence().findByPolicyNo_PrevAndNext(
			fundName, policyNo, orderByComparator);
	}

	/**
	 * Removes all the fund detailses where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 */
	public static void removeByPolicyNo(String policyNo) {
		getPersistence().removeByPolicyNo(policyNo);
	}

	/**
	 * Returns the number of fund detailses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching fund detailses
	 */
	public static int countByPolicyNo(String policyNo) {
		return getPersistence().countByPolicyNo(policyNo);
	}

	/**
	 * Caches the fund details in the entity cache if it is enabled.
	 *
	 * @param fundDetails the fund details
	 */
	public static void cacheResult(FundDetails fundDetails) {
		getPersistence().cacheResult(fundDetails);
	}

	/**
	 * Caches the fund detailses in the entity cache if it is enabled.
	 *
	 * @param fundDetailses the fund detailses
	 */
	public static void cacheResult(List<FundDetails> fundDetailses) {
		getPersistence().cacheResult(fundDetailses);
	}

	/**
	 * Creates a new fund details with the primary key. Does not add the fund details to the database.
	 *
	 * @param fundName the primary key for the new fund details
	 * @return the new fund details
	 */
	public static FundDetails create(String fundName) {
		return getPersistence().create(fundName);
	}

	/**
	 * Removes the fund details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fundName the primary key of the fund details
	 * @return the fund details that was removed
	 * @throws NoSuchFundDetailsException if a fund details with the primary key could not be found
	 */
	public static FundDetails remove(String fundName)
		throws com.ejada.atmc.acl.db.exception.NoSuchFundDetailsException {

		return getPersistence().remove(fundName);
	}

	public static FundDetails updateImpl(FundDetails fundDetails) {
		return getPersistence().updateImpl(fundDetails);
	}

	/**
	 * Returns the fund details with the primary key or throws a <code>NoSuchFundDetailsException</code> if it could not be found.
	 *
	 * @param fundName the primary key of the fund details
	 * @return the fund details
	 * @throws NoSuchFundDetailsException if a fund details with the primary key could not be found
	 */
	public static FundDetails findByPrimaryKey(String fundName)
		throws com.ejada.atmc.acl.db.exception.NoSuchFundDetailsException {

		return getPersistence().findByPrimaryKey(fundName);
	}

	/**
	 * Returns the fund details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fundName the primary key of the fund details
	 * @return the fund details, or <code>null</code> if a fund details with the primary key could not be found
	 */
	public static FundDetails fetchByPrimaryKey(String fundName) {
		return getPersistence().fetchByPrimaryKey(fundName);
	}

	/**
	 * Returns all the fund detailses.
	 *
	 * @return the fund detailses
	 */
	public static List<FundDetails> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<FundDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<FundDetails> findAll(
		int start, int end, OrderByComparator<FundDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<FundDetails> findAll(
		int start, int end, OrderByComparator<FundDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the fund detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of fund detailses.
	 *
	 * @return the number of fund detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FundDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<FundDetailsPersistence, FundDetailsPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FundDetailsPersistence.class);

		ServiceTracker<FundDetailsPersistence, FundDetailsPersistence>
			serviceTracker =
				new ServiceTracker
					<FundDetailsPersistence, FundDetailsPersistence>(
						bundle.getBundleContext(), FundDetailsPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}