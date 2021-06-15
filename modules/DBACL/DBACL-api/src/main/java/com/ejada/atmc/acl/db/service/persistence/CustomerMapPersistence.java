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

import com.ejada.atmc.acl.db.exception.NoSuchCustomerMapException;
import com.ejada.atmc.acl.db.model.CustomerMap;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the customer map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomerMapUtil
 * @generated
 */
@ProviderType
public interface CustomerMapPersistence extends BasePersistence<CustomerMap> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CustomerMapUtil} to access the customer map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the customer maps where custCatg = &#63; and custType = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @return the matching customer maps
	 */
	public java.util.List<CustomerMap> findByCatgAndType(
		String custCatg, String custType);

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
	public java.util.List<CustomerMap> findByCatgAndType(
		String custCatg, String custType, int start, int end);

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
	public java.util.List<CustomerMap> findByCatgAndType(
		String custCatg, String custType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomerMap>
			orderByComparator);

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
	public java.util.List<CustomerMap> findByCatgAndType(
		String custCatg, String custType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomerMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first customer map in the ordered set where custCatg = &#63; and custType = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer map
	 * @throws NoSuchCustomerMapException if a matching customer map could not be found
	 */
	public CustomerMap findByCatgAndType_First(
			String custCatg, String custType,
			com.liferay.portal.kernel.util.OrderByComparator<CustomerMap>
				orderByComparator)
		throws NoSuchCustomerMapException;

	/**
	 * Returns the first customer map in the ordered set where custCatg = &#63; and custType = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer map, or <code>null</code> if a matching customer map could not be found
	 */
	public CustomerMap fetchByCatgAndType_First(
		String custCatg, String custType,
		com.liferay.portal.kernel.util.OrderByComparator<CustomerMap>
			orderByComparator);

	/**
	 * Returns the last customer map in the ordered set where custCatg = &#63; and custType = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer map
	 * @throws NoSuchCustomerMapException if a matching customer map could not be found
	 */
	public CustomerMap findByCatgAndType_Last(
			String custCatg, String custType,
			com.liferay.portal.kernel.util.OrderByComparator<CustomerMap>
				orderByComparator)
		throws NoSuchCustomerMapException;

	/**
	 * Returns the last customer map in the ordered set where custCatg = &#63; and custType = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer map, or <code>null</code> if a matching customer map could not be found
	 */
	public CustomerMap fetchByCatgAndType_Last(
		String custCatg, String custType,
		com.liferay.portal.kernel.util.OrderByComparator<CustomerMap>
			orderByComparator);

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
	public CustomerMap[] findByCatgAndType_PrevAndNext(
			String refCode, String custCatg, String custType,
			com.liferay.portal.kernel.util.OrderByComparator<CustomerMap>
				orderByComparator)
		throws NoSuchCustomerMapException;

	/**
	 * Removes all the customer maps where custCatg = &#63; and custType = &#63; from the database.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 */
	public void removeByCatgAndType(String custCatg, String custType);

	/**
	 * Returns the number of customer maps where custCatg = &#63; and custType = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @return the number of matching customer maps
	 */
	public int countByCatgAndType(String custCatg, String custType);

	/**
	 * Returns all the customer maps where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @return the matching customer maps
	 */
	public java.util.List<CustomerMap> findByCatgTypeCode(
		String custCatg, String custType, String premiaCode);

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
	public java.util.List<CustomerMap> findByCatgTypeCode(
		String custCatg, String custType, String premiaCode, int start,
		int end);

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
	public java.util.List<CustomerMap> findByCatgTypeCode(
		String custCatg, String custType, String premiaCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomerMap>
			orderByComparator);

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
	public java.util.List<CustomerMap> findByCatgTypeCode(
		String custCatg, String custType, String premiaCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomerMap>
			orderByComparator,
		boolean useFinderCache);

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
	public CustomerMap findByCatgTypeCode_First(
			String custCatg, String custType, String premiaCode,
			com.liferay.portal.kernel.util.OrderByComparator<CustomerMap>
				orderByComparator)
		throws NoSuchCustomerMapException;

	/**
	 * Returns the first customer map in the ordered set where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer map, or <code>null</code> if a matching customer map could not be found
	 */
	public CustomerMap fetchByCatgTypeCode_First(
		String custCatg, String custType, String premiaCode,
		com.liferay.portal.kernel.util.OrderByComparator<CustomerMap>
			orderByComparator);

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
	public CustomerMap findByCatgTypeCode_Last(
			String custCatg, String custType, String premiaCode,
			com.liferay.portal.kernel.util.OrderByComparator<CustomerMap>
				orderByComparator)
		throws NoSuchCustomerMapException;

	/**
	 * Returns the last customer map in the ordered set where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer map, or <code>null</code> if a matching customer map could not be found
	 */
	public CustomerMap fetchByCatgTypeCode_Last(
		String custCatg, String custType, String premiaCode,
		com.liferay.portal.kernel.util.OrderByComparator<CustomerMap>
			orderByComparator);

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
	public CustomerMap[] findByCatgTypeCode_PrevAndNext(
			String refCode, String custCatg, String custType, String premiaCode,
			com.liferay.portal.kernel.util.OrderByComparator<CustomerMap>
				orderByComparator)
		throws NoSuchCustomerMapException;

	/**
	 * Removes all the customer maps where custCatg = &#63; and custType = &#63; and premiaCode = &#63; from the database.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 */
	public void removeByCatgTypeCode(
		String custCatg, String custType, String premiaCode);

	/**
	 * Returns the number of customer maps where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @return the number of matching customer maps
	 */
	public int countByCatgTypeCode(
		String custCatg, String custType, String premiaCode);

	/**
	 * Caches the customer map in the entity cache if it is enabled.
	 *
	 * @param customerMap the customer map
	 */
	public void cacheResult(CustomerMap customerMap);

	/**
	 * Caches the customer maps in the entity cache if it is enabled.
	 *
	 * @param customerMaps the customer maps
	 */
	public void cacheResult(java.util.List<CustomerMap> customerMaps);

	/**
	 * Creates a new customer map with the primary key. Does not add the customer map to the database.
	 *
	 * @param refCode the primary key for the new customer map
	 * @return the new customer map
	 */
	public CustomerMap create(String refCode);

	/**
	 * Removes the customer map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param refCode the primary key of the customer map
	 * @return the customer map that was removed
	 * @throws NoSuchCustomerMapException if a customer map with the primary key could not be found
	 */
	public CustomerMap remove(String refCode) throws NoSuchCustomerMapException;

	public CustomerMap updateImpl(CustomerMap customerMap);

	/**
	 * Returns the customer map with the primary key or throws a <code>NoSuchCustomerMapException</code> if it could not be found.
	 *
	 * @param refCode the primary key of the customer map
	 * @return the customer map
	 * @throws NoSuchCustomerMapException if a customer map with the primary key could not be found
	 */
	public CustomerMap findByPrimaryKey(String refCode)
		throws NoSuchCustomerMapException;

	/**
	 * Returns the customer map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param refCode the primary key of the customer map
	 * @return the customer map, or <code>null</code> if a customer map with the primary key could not be found
	 */
	public CustomerMap fetchByPrimaryKey(String refCode);

	/**
	 * Returns all the customer maps.
	 *
	 * @return the customer maps
	 */
	public java.util.List<CustomerMap> findAll();

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
	public java.util.List<CustomerMap> findAll(int start, int end);

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
	public java.util.List<CustomerMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomerMap>
			orderByComparator);

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
	public java.util.List<CustomerMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomerMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the customer maps from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of customer maps.
	 *
	 * @return the number of customer maps
	 */
	public int countAll();

}