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

import com.ejada.atmc.acl.db.exception.NoSuchPayFortRefException;
import com.ejada.atmc.acl.db.model.PayFortRef;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pay fort ref service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayFortRefUtil
 * @generated
 */
@ProviderType
public interface PayFortRefPersistence extends BasePersistence<PayFortRef> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PayFortRefUtil} to access the pay fort ref persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the pay fort ref where payFortRefNo = &#63; and status = &#63; or throws a <code>NoSuchPayFortRefException</code> if it could not be found.
	 *
	 * @param payFortRefNo the pay fort ref no
	 * @param status the status
	 * @return the matching pay fort ref
	 * @throws NoSuchPayFortRefException if a matching pay fort ref could not be found
	 */
	public PayFortRef findByrefNoStatus(String payFortRefNo, String status)
		throws NoSuchPayFortRefException;

	/**
	 * Returns the pay fort ref where payFortRefNo = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param payFortRefNo the pay fort ref no
	 * @param status the status
	 * @return the matching pay fort ref, or <code>null</code> if a matching pay fort ref could not be found
	 */
	public PayFortRef fetchByrefNoStatus(String payFortRefNo, String status);

	/**
	 * Returns the pay fort ref where payFortRefNo = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param payFortRefNo the pay fort ref no
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pay fort ref, or <code>null</code> if a matching pay fort ref could not be found
	 */
	public PayFortRef fetchByrefNoStatus(
		String payFortRefNo, String status, boolean useFinderCache);

	/**
	 * Removes the pay fort ref where payFortRefNo = &#63; and status = &#63; from the database.
	 *
	 * @param payFortRefNo the pay fort ref no
	 * @param status the status
	 * @return the pay fort ref that was removed
	 */
	public PayFortRef removeByrefNoStatus(String payFortRefNo, String status)
		throws NoSuchPayFortRefException;

	/**
	 * Returns the number of pay fort refs where payFortRefNo = &#63; and status = &#63;.
	 *
	 * @param payFortRefNo the pay fort ref no
	 * @param status the status
	 * @return the number of matching pay fort refs
	 */
	public int countByrefNoStatus(String payFortRefNo, String status);

	/**
	 * Caches the pay fort ref in the entity cache if it is enabled.
	 *
	 * @param payFortRef the pay fort ref
	 */
	public void cacheResult(PayFortRef payFortRef);

	/**
	 * Caches the pay fort refs in the entity cache if it is enabled.
	 *
	 * @param payFortRefs the pay fort refs
	 */
	public void cacheResult(java.util.List<PayFortRef> payFortRefs);

	/**
	 * Creates a new pay fort ref with the primary key. Does not add the pay fort ref to the database.
	 *
	 * @param id the primary key for the new pay fort ref
	 * @return the new pay fort ref
	 */
	public PayFortRef create(int id);

	/**
	 * Removes the pay fort ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the pay fort ref
	 * @return the pay fort ref that was removed
	 * @throws NoSuchPayFortRefException if a pay fort ref with the primary key could not be found
	 */
	public PayFortRef remove(int id) throws NoSuchPayFortRefException;

	public PayFortRef updateImpl(PayFortRef payFortRef);

	/**
	 * Returns the pay fort ref with the primary key or throws a <code>NoSuchPayFortRefException</code> if it could not be found.
	 *
	 * @param id the primary key of the pay fort ref
	 * @return the pay fort ref
	 * @throws NoSuchPayFortRefException if a pay fort ref with the primary key could not be found
	 */
	public PayFortRef findByPrimaryKey(int id) throws NoSuchPayFortRefException;

	/**
	 * Returns the pay fort ref with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the pay fort ref
	 * @return the pay fort ref, or <code>null</code> if a pay fort ref with the primary key could not be found
	 */
	public PayFortRef fetchByPrimaryKey(int id);

	/**
	 * Returns all the pay fort refs.
	 *
	 * @return the pay fort refs
	 */
	public java.util.List<PayFortRef> findAll();

	/**
	 * Returns a range of all the pay fort refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayFortRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay fort refs
	 * @param end the upper bound of the range of pay fort refs (not inclusive)
	 * @return the range of pay fort refs
	 */
	public java.util.List<PayFortRef> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the pay fort refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayFortRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay fort refs
	 * @param end the upper bound of the range of pay fort refs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pay fort refs
	 */
	public java.util.List<PayFortRef> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayFortRef>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pay fort refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayFortRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay fort refs
	 * @param end the upper bound of the range of pay fort refs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pay fort refs
	 */
	public java.util.List<PayFortRef> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayFortRef>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pay fort refs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pay fort refs.
	 *
	 * @return the number of pay fort refs
	 */
	public int countAll();

}