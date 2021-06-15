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

import com.ejada.atmc.acl.db.exception.NoSuchCustomerIbanException;
import com.ejada.atmc.acl.db.model.CustomerIban;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the customer iban service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomerIbanUtil
 * @generated
 */
@ProviderType
public interface CustomerIbanPersistence extends BasePersistence<CustomerIban> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CustomerIbanUtil} to access the customer iban persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the customer ibans where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching customer ibans
	 */
	public java.util.List<CustomerIban> findByCustomerIbanById(String id);

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
	public java.util.List<CustomerIban> findByCustomerIbanById(
		String id, int start, int end);

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
	public java.util.List<CustomerIban> findByCustomerIbanById(
		String id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomerIban>
			orderByComparator);

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
	public java.util.List<CustomerIban> findByCustomerIbanById(
		String id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomerIban>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first customer iban in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer iban
	 * @throws NoSuchCustomerIbanException if a matching customer iban could not be found
	 */
	public CustomerIban findByCustomerIbanById_First(
			String id,
			com.liferay.portal.kernel.util.OrderByComparator<CustomerIban>
				orderByComparator)
		throws NoSuchCustomerIbanException;

	/**
	 * Returns the first customer iban in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer iban, or <code>null</code> if a matching customer iban could not be found
	 */
	public CustomerIban fetchByCustomerIbanById_First(
		String id,
		com.liferay.portal.kernel.util.OrderByComparator<CustomerIban>
			orderByComparator);

	/**
	 * Returns the last customer iban in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer iban
	 * @throws NoSuchCustomerIbanException if a matching customer iban could not be found
	 */
	public CustomerIban findByCustomerIbanById_Last(
			String id,
			com.liferay.portal.kernel.util.OrderByComparator<CustomerIban>
				orderByComparator)
		throws NoSuchCustomerIbanException;

	/**
	 * Returns the last customer iban in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer iban, or <code>null</code> if a matching customer iban could not be found
	 */
	public CustomerIban fetchByCustomerIbanById_Last(
		String id,
		com.liferay.portal.kernel.util.OrderByComparator<CustomerIban>
			orderByComparator);

	/**
	 * Removes all the customer ibans where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public void removeByCustomerIbanById(String id);

	/**
	 * Returns the number of customer ibans where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching customer ibans
	 */
	public int countByCustomerIbanById(String id);

	/**
	 * Caches the customer iban in the entity cache if it is enabled.
	 *
	 * @param customerIban the customer iban
	 */
	public void cacheResult(CustomerIban customerIban);

	/**
	 * Caches the customer ibans in the entity cache if it is enabled.
	 *
	 * @param customerIbans the customer ibans
	 */
	public void cacheResult(java.util.List<CustomerIban> customerIbans);

	/**
	 * Creates a new customer iban with the primary key. Does not add the customer iban to the database.
	 *
	 * @param id the primary key for the new customer iban
	 * @return the new customer iban
	 */
	public CustomerIban create(String id);

	/**
	 * Removes the customer iban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the customer iban
	 * @return the customer iban that was removed
	 * @throws NoSuchCustomerIbanException if a customer iban with the primary key could not be found
	 */
	public CustomerIban remove(String id) throws NoSuchCustomerIbanException;

	public CustomerIban updateImpl(CustomerIban customerIban);

	/**
	 * Returns the customer iban with the primary key or throws a <code>NoSuchCustomerIbanException</code> if it could not be found.
	 *
	 * @param id the primary key of the customer iban
	 * @return the customer iban
	 * @throws NoSuchCustomerIbanException if a customer iban with the primary key could not be found
	 */
	public CustomerIban findByPrimaryKey(String id)
		throws NoSuchCustomerIbanException;

	/**
	 * Returns the customer iban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the customer iban
	 * @return the customer iban, or <code>null</code> if a customer iban with the primary key could not be found
	 */
	public CustomerIban fetchByPrimaryKey(String id);

	/**
	 * Returns all the customer ibans.
	 *
	 * @return the customer ibans
	 */
	public java.util.List<CustomerIban> findAll();

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
	public java.util.List<CustomerIban> findAll(int start, int end);

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
	public java.util.List<CustomerIban> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomerIban>
			orderByComparator);

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
	public java.util.List<CustomerIban> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomerIban>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the customer ibans from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of customer ibans.
	 *
	 * @return the number of customer ibans
	 */
	public int countAll();

}