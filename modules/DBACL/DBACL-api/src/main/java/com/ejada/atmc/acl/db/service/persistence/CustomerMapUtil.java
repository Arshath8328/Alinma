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

import com.ejada.atmc.acl.db.model.CustomerMap;

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
 * The persistence utility for the customer map service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.CustomerMapPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomerMapPersistence
 * @generated
 */
public class CustomerMapUtil {

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
	public static void clearCache(CustomerMap customerMap) {
		getPersistence().clearCache(customerMap);
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
	public static Map<Serializable, CustomerMap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CustomerMap> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CustomerMap update(CustomerMap customerMap) {
		return getPersistence().update(customerMap);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CustomerMap update(
		CustomerMap customerMap, ServiceContext serviceContext) {

		return getPersistence().update(customerMap, serviceContext);
	}

	/**
	 * Returns all the customer maps where custCatg = &#63; and custType = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @return the matching customer maps
	 */
	public static List<CustomerMap> findByCatgAndType(
		String custCatg, String custType) {

		return getPersistence().findByCatgAndType(custCatg, custType);
	}

	/**
	 * Returns a range of all the customer maps where custCatg = &#63; and custType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerMapModelImpl</code>.
	 * </p>
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param start the lower bound of the range of customer maps
	 * @param end the upper bound of the range of customer maps (not inclusive)
	 * @return the range of matching customer maps
	 */
	public static List<CustomerMap> findByCatgAndType(
		String custCatg, String custType, int start, int end) {

		return getPersistence().findByCatgAndType(
			custCatg, custType, start, end);
	}

	/**
	 * Returns an ordered range of all the customer maps where custCatg = &#63; and custType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerMapModelImpl</code>.
	 * </p>
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param start the lower bound of the range of customer maps
	 * @param end the upper bound of the range of customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching customer maps
	 */
	public static List<CustomerMap> findByCatgAndType(
		String custCatg, String custType, int start, int end,
		OrderByComparator<CustomerMap> orderByComparator) {

		return getPersistence().findByCatgAndType(
			custCatg, custType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the customer maps where custCatg = &#63; and custType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerMapModelImpl</code>.
	 * </p>
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param start the lower bound of the range of customer maps
	 * @param end the upper bound of the range of customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching customer maps
	 */
	public static List<CustomerMap> findByCatgAndType(
		String custCatg, String custType, int start, int end,
		OrderByComparator<CustomerMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCatgAndType(
			custCatg, custType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first customer map in the ordered set where custCatg = &#63; and custType = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer map
	 * @throws NoSuchCustomerMapException if a matching customer map could not be found
	 */
	public static CustomerMap findByCatgAndType_First(
			String custCatg, String custType,
			OrderByComparator<CustomerMap> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustomerMapException {

		return getPersistence().findByCatgAndType_First(
			custCatg, custType, orderByComparator);
	}

	/**
	 * Returns the first customer map in the ordered set where custCatg = &#63; and custType = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer map, or <code>null</code> if a matching customer map could not be found
	 */
	public static CustomerMap fetchByCatgAndType_First(
		String custCatg, String custType,
		OrderByComparator<CustomerMap> orderByComparator) {

		return getPersistence().fetchByCatgAndType_First(
			custCatg, custType, orderByComparator);
	}

	/**
	 * Returns the last customer map in the ordered set where custCatg = &#63; and custType = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer map
	 * @throws NoSuchCustomerMapException if a matching customer map could not be found
	 */
	public static CustomerMap findByCatgAndType_Last(
			String custCatg, String custType,
			OrderByComparator<CustomerMap> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustomerMapException {

		return getPersistence().findByCatgAndType_Last(
			custCatg, custType, orderByComparator);
	}

	/**
	 * Returns the last customer map in the ordered set where custCatg = &#63; and custType = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer map, or <code>null</code> if a matching customer map could not be found
	 */
	public static CustomerMap fetchByCatgAndType_Last(
		String custCatg, String custType,
		OrderByComparator<CustomerMap> orderByComparator) {

		return getPersistence().fetchByCatgAndType_Last(
			custCatg, custType, orderByComparator);
	}

	/**
	 * Returns the customer maps before and after the current customer map in the ordered set where custCatg = &#63; and custType = &#63;.
	 *
	 * @param refCode the primary key of the current customer map
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next customer map
	 * @throws NoSuchCustomerMapException if a customer map with the primary key could not be found
	 */
	public static CustomerMap[] findByCatgAndType_PrevAndNext(
			String refCode, String custCatg, String custType,
			OrderByComparator<CustomerMap> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustomerMapException {

		return getPersistence().findByCatgAndType_PrevAndNext(
			refCode, custCatg, custType, orderByComparator);
	}

	/**
	 * Removes all the customer maps where custCatg = &#63; and custType = &#63; from the database.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 */
	public static void removeByCatgAndType(String custCatg, String custType) {
		getPersistence().removeByCatgAndType(custCatg, custType);
	}

	/**
	 * Returns the number of customer maps where custCatg = &#63; and custType = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @return the number of matching customer maps
	 */
	public static int countByCatgAndType(String custCatg, String custType) {
		return getPersistence().countByCatgAndType(custCatg, custType);
	}

	/**
	 * Returns all the customer maps where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @return the matching customer maps
	 */
	public static List<CustomerMap> findByCatgTypeCode(
		String custCatg, String custType, String premiaCode) {

		return getPersistence().findByCatgTypeCode(
			custCatg, custType, premiaCode);
	}

	/**
	 * Returns a range of all the customer maps where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerMapModelImpl</code>.
	 * </p>
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @param start the lower bound of the range of customer maps
	 * @param end the upper bound of the range of customer maps (not inclusive)
	 * @return the range of matching customer maps
	 */
	public static List<CustomerMap> findByCatgTypeCode(
		String custCatg, String custType, String premiaCode, int start,
		int end) {

		return getPersistence().findByCatgTypeCode(
			custCatg, custType, premiaCode, start, end);
	}

	/**
	 * Returns an ordered range of all the customer maps where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerMapModelImpl</code>.
	 * </p>
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @param start the lower bound of the range of customer maps
	 * @param end the upper bound of the range of customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching customer maps
	 */
	public static List<CustomerMap> findByCatgTypeCode(
		String custCatg, String custType, String premiaCode, int start, int end,
		OrderByComparator<CustomerMap> orderByComparator) {

		return getPersistence().findByCatgTypeCode(
			custCatg, custType, premiaCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the customer maps where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerMapModelImpl</code>.
	 * </p>
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @param start the lower bound of the range of customer maps
	 * @param end the upper bound of the range of customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching customer maps
	 */
	public static List<CustomerMap> findByCatgTypeCode(
		String custCatg, String custType, String premiaCode, int start, int end,
		OrderByComparator<CustomerMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCatgTypeCode(
			custCatg, custType, premiaCode, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first customer map in the ordered set where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer map
	 * @throws NoSuchCustomerMapException if a matching customer map could not be found
	 */
	public static CustomerMap findByCatgTypeCode_First(
			String custCatg, String custType, String premiaCode,
			OrderByComparator<CustomerMap> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustomerMapException {

		return getPersistence().findByCatgTypeCode_First(
			custCatg, custType, premiaCode, orderByComparator);
	}

	/**
	 * Returns the first customer map in the ordered set where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer map, or <code>null</code> if a matching customer map could not be found
	 */
	public static CustomerMap fetchByCatgTypeCode_First(
		String custCatg, String custType, String premiaCode,
		OrderByComparator<CustomerMap> orderByComparator) {

		return getPersistence().fetchByCatgTypeCode_First(
			custCatg, custType, premiaCode, orderByComparator);
	}

	/**
	 * Returns the last customer map in the ordered set where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer map
	 * @throws NoSuchCustomerMapException if a matching customer map could not be found
	 */
	public static CustomerMap findByCatgTypeCode_Last(
			String custCatg, String custType, String premiaCode,
			OrderByComparator<CustomerMap> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustomerMapException {

		return getPersistence().findByCatgTypeCode_Last(
			custCatg, custType, premiaCode, orderByComparator);
	}

	/**
	 * Returns the last customer map in the ordered set where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer map, or <code>null</code> if a matching customer map could not be found
	 */
	public static CustomerMap fetchByCatgTypeCode_Last(
		String custCatg, String custType, String premiaCode,
		OrderByComparator<CustomerMap> orderByComparator) {

		return getPersistence().fetchByCatgTypeCode_Last(
			custCatg, custType, premiaCode, orderByComparator);
	}

	/**
	 * Returns the customer maps before and after the current customer map in the ordered set where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * @param refCode the primary key of the current customer map
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next customer map
	 * @throws NoSuchCustomerMapException if a customer map with the primary key could not be found
	 */
	public static CustomerMap[] findByCatgTypeCode_PrevAndNext(
			String refCode, String custCatg, String custType, String premiaCode,
			OrderByComparator<CustomerMap> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustomerMapException {

		return getPersistence().findByCatgTypeCode_PrevAndNext(
			refCode, custCatg, custType, premiaCode, orderByComparator);
	}

	/**
	 * Removes all the customer maps where custCatg = &#63; and custType = &#63; and premiaCode = &#63; from the database.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 */
	public static void removeByCatgTypeCode(
		String custCatg, String custType, String premiaCode) {

		getPersistence().removeByCatgTypeCode(custCatg, custType, premiaCode);
	}

	/**
	 * Returns the number of customer maps where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @return the number of matching customer maps
	 */
	public static int countByCatgTypeCode(
		String custCatg, String custType, String premiaCode) {

		return getPersistence().countByCatgTypeCode(
			custCatg, custType, premiaCode);
	}

	/**
	 * Caches the customer map in the entity cache if it is enabled.
	 *
	 * @param customerMap the customer map
	 */
	public static void cacheResult(CustomerMap customerMap) {
		getPersistence().cacheResult(customerMap);
	}

	/**
	 * Caches the customer maps in the entity cache if it is enabled.
	 *
	 * @param customerMaps the customer maps
	 */
	public static void cacheResult(List<CustomerMap> customerMaps) {
		getPersistence().cacheResult(customerMaps);
	}

	/**
	 * Creates a new customer map with the primary key. Does not add the customer map to the database.
	 *
	 * @param refCode the primary key for the new customer map
	 * @return the new customer map
	 */
	public static CustomerMap create(String refCode) {
		return getPersistence().create(refCode);
	}

	/**
	 * Removes the customer map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param refCode the primary key of the customer map
	 * @return the customer map that was removed
	 * @throws NoSuchCustomerMapException if a customer map with the primary key could not be found
	 */
	public static CustomerMap remove(String refCode)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustomerMapException {

		return getPersistence().remove(refCode);
	}

	public static CustomerMap updateImpl(CustomerMap customerMap) {
		return getPersistence().updateImpl(customerMap);
	}

	/**
	 * Returns the customer map with the primary key or throws a <code>NoSuchCustomerMapException</code> if it could not be found.
	 *
	 * @param refCode the primary key of the customer map
	 * @return the customer map
	 * @throws NoSuchCustomerMapException if a customer map with the primary key could not be found
	 */
	public static CustomerMap findByPrimaryKey(String refCode)
		throws com.ejada.atmc.acl.db.exception.NoSuchCustomerMapException {

		return getPersistence().findByPrimaryKey(refCode);
	}

	/**
	 * Returns the customer map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param refCode the primary key of the customer map
	 * @return the customer map, or <code>null</code> if a customer map with the primary key could not be found
	 */
	public static CustomerMap fetchByPrimaryKey(String refCode) {
		return getPersistence().fetchByPrimaryKey(refCode);
	}

	/**
	 * Returns all the customer maps.
	 *
	 * @return the customer maps
	 */
	public static List<CustomerMap> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer maps
	 * @param end the upper bound of the range of customer maps (not inclusive)
	 * @return the range of customer maps
	 */
	public static List<CustomerMap> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer maps
	 * @param end the upper bound of the range of customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of customer maps
	 */
	public static List<CustomerMap> findAll(
		int start, int end, OrderByComparator<CustomerMap> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer maps
	 * @param end the upper bound of the range of customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of customer maps
	 */
	public static List<CustomerMap> findAll(
		int start, int end, OrderByComparator<CustomerMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the customer maps from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of customer maps.
	 *
	 * @return the number of customer maps
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CustomerMapPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CustomerMapPersistence, CustomerMapPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CustomerMapPersistence.class);

		ServiceTracker<CustomerMapPersistence, CustomerMapPersistence>
			serviceTracker =
				new ServiceTracker
					<CustomerMapPersistence, CustomerMapPersistence>(
						bundle.getBundleContext(), CustomerMapPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}