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

import com.ejada.atmc.acl.db.model.PolicyPayment;

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
 * The persistence utility for the policy payment service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.PolicyPaymentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyPaymentPersistence
 * @generated
 */
public class PolicyPaymentUtil {

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
	public static void clearCache(PolicyPayment policyPayment) {
		getPersistence().clearCache(policyPayment);
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
	public static Map<Serializable, PolicyPayment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PolicyPayment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PolicyPayment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PolicyPayment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PolicyPayment> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PolicyPayment update(PolicyPayment policyPayment) {
		return getPersistence().update(policyPayment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PolicyPayment update(
		PolicyPayment policyPayment, ServiceContext serviceContext) {

		return getPersistence().update(policyPayment, serviceContext);
	}

	/**
	 * Caches the policy payment in the entity cache if it is enabled.
	 *
	 * @param policyPayment the policy payment
	 */
	public static void cacheResult(PolicyPayment policyPayment) {
		getPersistence().cacheResult(policyPayment);
	}

	/**
	 * Caches the policy payments in the entity cache if it is enabled.
	 *
	 * @param policyPayments the policy payments
	 */
	public static void cacheResult(List<PolicyPayment> policyPayments) {
		getPersistence().cacheResult(policyPayments);
	}

	/**
	 * Creates a new policy payment with the primary key. Does not add the policy payment to the database.
	 *
	 * @param policyPaymentPK the primary key for the new policy payment
	 * @return the new policy payment
	 */
	public static PolicyPayment create(PolicyPaymentPK policyPaymentPK) {
		return getPersistence().create(policyPaymentPK);
	}

	/**
	 * Removes the policy payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyPaymentPK the primary key of the policy payment
	 * @return the policy payment that was removed
	 * @throws NoSuchPolicyPaymentException if a policy payment with the primary key could not be found
	 */
	public static PolicyPayment remove(PolicyPaymentPK policyPaymentPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyPaymentException {

		return getPersistence().remove(policyPaymentPK);
	}

	public static PolicyPayment updateImpl(PolicyPayment policyPayment) {
		return getPersistence().updateImpl(policyPayment);
	}

	/**
	 * Returns the policy payment with the primary key or throws a <code>NoSuchPolicyPaymentException</code> if it could not be found.
	 *
	 * @param policyPaymentPK the primary key of the policy payment
	 * @return the policy payment
	 * @throws NoSuchPolicyPaymentException if a policy payment with the primary key could not be found
	 */
	public static PolicyPayment findByPrimaryKey(
			PolicyPaymentPK policyPaymentPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyPaymentException {

		return getPersistence().findByPrimaryKey(policyPaymentPK);
	}

	/**
	 * Returns the policy payment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyPaymentPK the primary key of the policy payment
	 * @return the policy payment, or <code>null</code> if a policy payment with the primary key could not be found
	 */
	public static PolicyPayment fetchByPrimaryKey(
		PolicyPaymentPK policyPaymentPK) {

		return getPersistence().fetchByPrimaryKey(policyPaymentPK);
	}

	/**
	 * Returns all the policy payments.
	 *
	 * @return the policy payments
	 */
	public static List<PolicyPayment> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the policy payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyPaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy payments
	 * @param end the upper bound of the range of policy payments (not inclusive)
	 * @return the range of policy payments
	 */
	public static List<PolicyPayment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the policy payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyPaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy payments
	 * @param end the upper bound of the range of policy payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy payments
	 */
	public static List<PolicyPayment> findAll(
		int start, int end,
		OrderByComparator<PolicyPayment> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyPaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy payments
	 * @param end the upper bound of the range of policy payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy payments
	 */
	public static List<PolicyPayment> findAll(
		int start, int end, OrderByComparator<PolicyPayment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the policy payments from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of policy payments.
	 *
	 * @return the number of policy payments
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static PolicyPaymentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PolicyPaymentPersistence, PolicyPaymentPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PolicyPaymentPersistence.class);

		ServiceTracker<PolicyPaymentPersistence, PolicyPaymentPersistence>
			serviceTracker =
				new ServiceTracker
					<PolicyPaymentPersistence, PolicyPaymentPersistence>(
						bundle.getBundleContext(),
						PolicyPaymentPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}