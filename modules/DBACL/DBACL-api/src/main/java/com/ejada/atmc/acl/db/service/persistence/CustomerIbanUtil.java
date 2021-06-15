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

import com.ejada.atmc.acl.db.model.CustomerIban;

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
 * The persistence utility for the customer iban service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.CustomerIbanPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomerIbanPersistence
 * @generated
 */
public class CustomerIbanUtil {

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
	public static void clearCache(CustomerIban customerIban) {
		getPersistence().clearCache(customerIban);
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
	public static Map<Serializable, CustomerIban> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CustomerIban> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CustomerIban> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CustomerIban> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CustomerIban> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CustomerIban update(CustomerIban customerIban) {
		return getPersistence().update(customerIban);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CustomerIban update(
		CustomerIban customerIban, ServiceContext serviceContext) {

		return getPersistence().update(customerIban, serviceContext);
	}

	/**
	 * Returns all the customer ibans where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching customer ibans
	 */
	public static List<CustomerIban> findByCustomerIbanById(String id) {
		return getPersistence().findByCustomerIbanById(id);
	}

	/**
	 * Returns a range of all the customer ibans where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerIbanModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of customer ibans
	 * @param end the upper bound of the range of customer ibans (not inclusive)
	 * @return the range of matching customer ibans
	 */
	public static List<CustomerIban> findByCustomerIbanById(
		String id, int start, int end) {

		return getPersistence().findByCustomerIbanById(id, start, end);
	}

	/**
	 * Returns an ordered range of all the customer ibans where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerIbanModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of customer ibans
	 * @param end the upper bound of the range of customer ibans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching customer ibans
	 */
	public static List<CustomerIban> findByCustomerIbanById(
		String id, int start, int end,
		OrderByComparator<CustomerIban> orderByComparator) {

		return getPersistence().findByCustomerIbanById(
			id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the customer ibans where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerIbanModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of customer ibans
	 * @param end the upper bound of the range of customer ibans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching customer ibans
	 */
	public static List<CustomerIban> findByCustomerIbanById(
		String id, int start, int end,
		OrderByComparator<CustomerIban> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCustomerIbanById(
			id, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first customer iban in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer iban
	 * @throws NoSuchCustomerIbanException if a matching customer iban could not be found
	 */
	public static CustomerIban findByCustomerIbanById_First(
			String id, OrderByComparator<CustomerIban> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustomerIbanException {

		return getPersistence().findByCustomerIbanById_First(
			id, orderByComparator);
	}

	/**
	 * Returns the first customer iban in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer iban, or <code>null</code> if a matching customer iban could not be found
	 */
	public static CustomerIban fetchByCustomerIbanById_First(
		String id, OrderByComparator<CustomerIban> orderByComparator) {

		return getPersistence().fetchByCustomerIbanById_First(
			id, orderByComparator);
	}

	/**
	 * Returns the last customer iban in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer iban
	 * @throws NoSuchCustomerIbanException if a matching customer iban could not be found
	 */
	public static CustomerIban findByCustomerIbanById_Last(
			String id, OrderByComparator<CustomerIban> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustomerIbanException {

		return getPersistence().findByCustomerIbanById_Last(
			id, orderByComparator);
	}

	/**
	 * Returns the last customer iban in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer iban, or <code>null</code> if a matching customer iban could not be found
	 */
	public static CustomerIban fetchByCustomerIbanById_Last(
		String id, OrderByComparator<CustomerIban> orderByComparator) {

		return getPersistence().fetchByCustomerIbanById_Last(
			id, orderByComparator);
	}

	/**
	 * Removes all the customer ibans where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public static void removeByCustomerIbanById(String id) {
		getPersistence().removeByCustomerIbanById(id);
	}

	/**
	 * Returns the number of customer ibans where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching customer ibans
	 */
	public static int countByCustomerIbanById(String id) {
		return getPersistence().countByCustomerIbanById(id);
	}

	/**
	 * Caches the customer iban in the entity cache if it is enabled.
	 *
	 * @param customerIban the customer iban
	 */
	public static void cacheResult(CustomerIban customerIban) {
		getPersistence().cacheResult(customerIban);
	}

	/**
	 * Caches the customer ibans in the entity cache if it is enabled.
	 *
	 * @param customerIbans the customer ibans
	 */
	public static void cacheResult(List<CustomerIban> customerIbans) {
		getPersistence().cacheResult(customerIbans);
	}

	/**
	 * Creates a new customer iban with the primary key. Does not add the customer iban to the database.
	 *
	 * @param id the primary key for the new customer iban
	 * @return the new customer iban
	 */
	public static CustomerIban create(String id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the customer iban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the customer iban
	 * @return the customer iban that was removed
	 * @throws NoSuchCustomerIbanException if a customer iban with the primary key could not be found
	 */
	public static CustomerIban remove(String id)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustomerIbanException {

		return getPersistence().remove(id);
	}

	public static CustomerIban updateImpl(CustomerIban customerIban) {
		return getPersistence().updateImpl(customerIban);
	}

	/**
	 * Returns the customer iban with the primary key or throws a <code>NoSuchCustomerIbanException</code> if it could not be found.
	 *
	 * @param id the primary key of the customer iban
	 * @return the customer iban
	 * @throws NoSuchCustomerIbanException if a customer iban with the primary key could not be found
	 */
	public static CustomerIban findByPrimaryKey(String id)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustomerIbanException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the customer iban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the customer iban
	 * @return the customer iban, or <code>null</code> if a customer iban with the primary key could not be found
	 */
	public static CustomerIban fetchByPrimaryKey(String id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the customer ibans.
	 *
	 * @return the customer ibans
	 */
	public static List<CustomerIban> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the customer ibans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerIbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer ibans
	 * @param end the upper bound of the range of customer ibans (not inclusive)
	 * @return the range of customer ibans
	 */
	public static List<CustomerIban> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the customer ibans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerIbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer ibans
	 * @param end the upper bound of the range of customer ibans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of customer ibans
	 */
	public static List<CustomerIban> findAll(
		int start, int end, OrderByComparator<CustomerIban> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the customer ibans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerIbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer ibans
	 * @param end the upper bound of the range of customer ibans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of customer ibans
	 */
	public static List<CustomerIban> findAll(
		int start, int end, OrderByComparator<CustomerIban> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the customer ibans from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of customer ibans.
	 *
	 * @return the number of customer ibans
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CustomerIbanPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CustomerIbanPersistence, CustomerIbanPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CustomerIbanPersistence.class);

		ServiceTracker<CustomerIbanPersistence, CustomerIbanPersistence>
			serviceTracker =
				new ServiceTracker
					<CustomerIbanPersistence, CustomerIbanPersistence>(
						bundle.getBundleContext(),
						CustomerIbanPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}