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

import com.ejada.atmc.acl.db.model.Customer;

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
 * The persistence utility for the customer service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.CustomerPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomerPersistence
 * @generated
 */
public class CustomerUtil {

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
	public static void clearCache(Customer customer) {
		getPersistence().clearCache(customer);
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
	public static Map<Serializable, Customer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Customer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Customer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Customer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Customer> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Customer update(Customer customer) {
		return getPersistence().update(customer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Customer update(
		Customer customer, ServiceContext serviceContext) {

		return getPersistence().update(customer, serviceContext);
	}

	/**
	 * Returns all the customers where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching customers
	 */
	public static List<Customer> findBycustomerId(String id) {
		return getPersistence().findBycustomerId(id);
	}

	/**
	 * Returns a range of all the customers where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @return the range of matching customers
	 */
	public static List<Customer> findBycustomerId(
		String id, int start, int end) {

		return getPersistence().findBycustomerId(id, start, end);
	}

	/**
	 * Returns an ordered range of all the customers where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching customers
	 */
	public static List<Customer> findBycustomerId(
		String id, int start, int end,
		OrderByComparator<Customer> orderByComparator) {

		return getPersistence().findBycustomerId(
			id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the customers where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching customers
	 */
	public static List<Customer> findBycustomerId(
		String id, int start, int end,
		OrderByComparator<Customer> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBycustomerId(
			id, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first customer in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	public static Customer findBycustomerId_First(
			String id, OrderByComparator<Customer> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustomerException {

		return getPersistence().findBycustomerId_First(id, orderByComparator);
	}

	/**
	 * Returns the first customer in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer, or <code>null</code> if a matching customer could not be found
	 */
	public static Customer fetchBycustomerId_First(
		String id, OrderByComparator<Customer> orderByComparator) {

		return getPersistence().fetchBycustomerId_First(id, orderByComparator);
	}

	/**
	 * Returns the last customer in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	public static Customer findBycustomerId_Last(
			String id, OrderByComparator<Customer> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustomerException {

		return getPersistence().findBycustomerId_Last(id, orderByComparator);
	}

	/**
	 * Returns the last customer in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer, or <code>null</code> if a matching customer could not be found
	 */
	public static Customer fetchBycustomerId_Last(
		String id, OrderByComparator<Customer> orderByComparator) {

		return getPersistence().fetchBycustomerId_Last(id, orderByComparator);
	}

	/**
	 * Removes all the customers where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public static void removeBycustomerId(String id) {
		getPersistence().removeBycustomerId(id);
	}

	/**
	 * Returns the number of customers where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching customers
	 */
	public static int countBycustomerId(String id) {
		return getPersistence().countBycustomerId(id);
	}

	/**
	 * Caches the customer in the entity cache if it is enabled.
	 *
	 * @param customer the customer
	 */
	public static void cacheResult(Customer customer) {
		getPersistence().cacheResult(customer);
	}

	/**
	 * Caches the customers in the entity cache if it is enabled.
	 *
	 * @param customers the customers
	 */
	public static void cacheResult(List<Customer> customers) {
		getPersistence().cacheResult(customers);
	}

	/**
	 * Creates a new customer with the primary key. Does not add the customer to the database.
	 *
	 * @param id the primary key for the new customer
	 * @return the new customer
	 */
	public static Customer create(String id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the customer
	 * @return the customer that was removed
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	public static Customer remove(String id)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustomerException {

		return getPersistence().remove(id);
	}

	public static Customer updateImpl(Customer customer) {
		return getPersistence().updateImpl(customer);
	}

	/**
	 * Returns the customer with the primary key or throws a <code>NoSuchCustomerException</code> if it could not be found.
	 *
	 * @param id the primary key of the customer
	 * @return the customer
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	public static Customer findByPrimaryKey(String id)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustomerException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the customer
	 * @return the customer, or <code>null</code> if a customer with the primary key could not be found
	 */
	public static Customer fetchByPrimaryKey(String id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the customers.
	 *
	 * @return the customers
	 */
	public static List<Customer> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @return the range of customers
	 */
	public static List<Customer> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of customers
	 */
	public static List<Customer> findAll(
		int start, int end, OrderByComparator<Customer> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of customers
	 */
	public static List<Customer> findAll(
		int start, int end, OrderByComparator<Customer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the customers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of customers.
	 *
	 * @return the number of customers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CustomerPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CustomerPersistence, CustomerPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CustomerPersistence.class);

		ServiceTracker<CustomerPersistence, CustomerPersistence>
			serviceTracker =
				new ServiceTracker<CustomerPersistence, CustomerPersistence>(
					bundle.getBundleContext(), CustomerPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}