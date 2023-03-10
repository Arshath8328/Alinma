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

import com.ejada.atmc.acl.db.exception.NoSuchCompDiscountException;
import com.ejada.atmc.acl.db.model.CompDiscount;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the comp discount service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompDiscountUtil
 * @generated
 */
@ProviderType
public interface CompDiscountPersistence extends BasePersistence<CompDiscount> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CompDiscountUtil} to access the comp discount persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the comp discount in the entity cache if it is enabled.
	 *
	 * @param compDiscount the comp discount
	 */
	public void cacheResult(CompDiscount compDiscount);

	/**
	 * Caches the comp discounts in the entity cache if it is enabled.
	 *
	 * @param compDiscounts the comp discounts
	 */
	public void cacheResult(java.util.List<CompDiscount> compDiscounts);

	/**
	 * Creates a new comp discount with the primary key. Does not add the comp discount to the database.
	 *
	 * @param iqamaId the primary key for the new comp discount
	 * @return the new comp discount
	 */
	public CompDiscount create(String iqamaId);

	/**
	 * Removes the comp discount with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param iqamaId the primary key of the comp discount
	 * @return the comp discount that was removed
	 * @throws NoSuchCompDiscountException if a comp discount with the primary key could not be found
	 */
	public CompDiscount remove(String iqamaId)
		throws NoSuchCompDiscountException;

	public CompDiscount updateImpl(CompDiscount compDiscount);

	/**
	 * Returns the comp discount with the primary key or throws a <code>NoSuchCompDiscountException</code> if it could not be found.
	 *
	 * @param iqamaId the primary key of the comp discount
	 * @return the comp discount
	 * @throws NoSuchCompDiscountException if a comp discount with the primary key could not be found
	 */
	public CompDiscount findByPrimaryKey(String iqamaId)
		throws NoSuchCompDiscountException;

	/**
	 * Returns the comp discount with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param iqamaId the primary key of the comp discount
	 * @return the comp discount, or <code>null</code> if a comp discount with the primary key could not be found
	 */
	public CompDiscount fetchByPrimaryKey(String iqamaId);

	/**
	 * Returns all the comp discounts.
	 *
	 * @return the comp discounts
	 */
	public java.util.List<CompDiscount> findAll();

	/**
	 * Returns a range of all the comp discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompDiscountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comp discounts
	 * @param end the upper bound of the range of comp discounts (not inclusive)
	 * @return the range of comp discounts
	 */
	public java.util.List<CompDiscount> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the comp discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompDiscountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comp discounts
	 * @param end the upper bound of the range of comp discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comp discounts
	 */
	public java.util.List<CompDiscount> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompDiscount>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comp discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompDiscountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comp discounts
	 * @param end the upper bound of the range of comp discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of comp discounts
	 */
	public java.util.List<CompDiscount> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompDiscount>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the comp discounts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of comp discounts.
	 *
	 * @return the number of comp discounts
	 */
	public int countAll();

}