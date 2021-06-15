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

import com.ejada.atmc.acl.db.exception.NoSuchCLMSTATUSHISTORYException;
import com.ejada.atmc.acl.db.model.CLMSTATUSHISTORY;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the clmstatushistory service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CLMSTATUSHISTORYUtil
 * @generated
 */
@ProviderType
public interface CLMSTATUSHISTORYPersistence
	extends BasePersistence<CLMSTATUSHISTORY> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CLMSTATUSHISTORYUtil} to access the clmstatushistory persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the clmstatushistories where RefNo = &#63;.
	 *
	 * @param RefNo the ref no
	 * @return the matching clmstatushistories
	 */
	public java.util.List<CLMSTATUSHISTORY> findByRefNo(String RefNo);

	/**
	 * Returns a range of all the clmstatushistories where RefNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSHISTORYModelImpl</code>.
	 * </p>
	 *
	 * @param RefNo the ref no
	 * @param start the lower bound of the range of clmstatushistories
	 * @param end the upper bound of the range of clmstatushistories (not inclusive)
	 * @return the range of matching clmstatushistories
	 */
	public java.util.List<CLMSTATUSHISTORY> findByRefNo(
		String RefNo, int start, int end);

	/**
	 * Returns an ordered range of all the clmstatushistories where RefNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSHISTORYModelImpl</code>.
	 * </p>
	 *
	 * @param RefNo the ref no
	 * @param start the lower bound of the range of clmstatushistories
	 * @param end the upper bound of the range of clmstatushistories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clmstatushistories
	 */
	public java.util.List<CLMSTATUSHISTORY> findByRefNo(
		String RefNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMSTATUSHISTORY>
			orderByComparator);

	/**
	 * Returns an ordered range of all the clmstatushistories where RefNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSHISTORYModelImpl</code>.
	 * </p>
	 *
	 * @param RefNo the ref no
	 * @param start the lower bound of the range of clmstatushistories
	 * @param end the upper bound of the range of clmstatushistories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching clmstatushistories
	 */
	public java.util.List<CLMSTATUSHISTORY> findByRefNo(
		String RefNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMSTATUSHISTORY>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first clmstatushistory in the ordered set where RefNo = &#63;.
	 *
	 * @param RefNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clmstatushistory
	 * @throws NoSuchCLMSTATUSHISTORYException if a matching clmstatushistory could not be found
	 */
	public CLMSTATUSHISTORY findByRefNo_First(
			String RefNo,
			com.liferay.portal.kernel.util.OrderByComparator<CLMSTATUSHISTORY>
				orderByComparator)
		throws NoSuchCLMSTATUSHISTORYException;

	/**
	 * Returns the first clmstatushistory in the ordered set where RefNo = &#63;.
	 *
	 * @param RefNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clmstatushistory, or <code>null</code> if a matching clmstatushistory could not be found
	 */
	public CLMSTATUSHISTORY fetchByRefNo_First(
		String RefNo,
		com.liferay.portal.kernel.util.OrderByComparator<CLMSTATUSHISTORY>
			orderByComparator);

	/**
	 * Returns the last clmstatushistory in the ordered set where RefNo = &#63;.
	 *
	 * @param RefNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clmstatushistory
	 * @throws NoSuchCLMSTATUSHISTORYException if a matching clmstatushistory could not be found
	 */
	public CLMSTATUSHISTORY findByRefNo_Last(
			String RefNo,
			com.liferay.portal.kernel.util.OrderByComparator<CLMSTATUSHISTORY>
				orderByComparator)
		throws NoSuchCLMSTATUSHISTORYException;

	/**
	 * Returns the last clmstatushistory in the ordered set where RefNo = &#63;.
	 *
	 * @param RefNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clmstatushistory, or <code>null</code> if a matching clmstatushistory could not be found
	 */
	public CLMSTATUSHISTORY fetchByRefNo_Last(
		String RefNo,
		com.liferay.portal.kernel.util.OrderByComparator<CLMSTATUSHISTORY>
			orderByComparator);

	/**
	 * Returns the clmstatushistories before and after the current clmstatushistory in the ordered set where RefNo = &#63;.
	 *
	 * @param id the primary key of the current clmstatushistory
	 * @param RefNo the ref no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clmstatushistory
	 * @throws NoSuchCLMSTATUSHISTORYException if a clmstatushistory with the primary key could not be found
	 */
	public CLMSTATUSHISTORY[] findByRefNo_PrevAndNext(
			int id, String RefNo,
			com.liferay.portal.kernel.util.OrderByComparator<CLMSTATUSHISTORY>
				orderByComparator)
		throws NoSuchCLMSTATUSHISTORYException;

	/**
	 * Removes all the clmstatushistories where RefNo = &#63; from the database.
	 *
	 * @param RefNo the ref no
	 */
	public void removeByRefNo(String RefNo);

	/**
	 * Returns the number of clmstatushistories where RefNo = &#63;.
	 *
	 * @param RefNo the ref no
	 * @return the number of matching clmstatushistories
	 */
	public int countByRefNo(String RefNo);

	/**
	 * Caches the clmstatushistory in the entity cache if it is enabled.
	 *
	 * @param clmstatushistory the clmstatushistory
	 */
	public void cacheResult(CLMSTATUSHISTORY clmstatushistory);

	/**
	 * Caches the clmstatushistories in the entity cache if it is enabled.
	 *
	 * @param clmstatushistories the clmstatushistories
	 */
	public void cacheResult(
		java.util.List<CLMSTATUSHISTORY> clmstatushistories);

	/**
	 * Creates a new clmstatushistory with the primary key. Does not add the clmstatushistory to the database.
	 *
	 * @param id the primary key for the new clmstatushistory
	 * @return the new clmstatushistory
	 */
	public CLMSTATUSHISTORY create(int id);

	/**
	 * Removes the clmstatushistory with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the clmstatushistory
	 * @return the clmstatushistory that was removed
	 * @throws NoSuchCLMSTATUSHISTORYException if a clmstatushistory with the primary key could not be found
	 */
	public CLMSTATUSHISTORY remove(int id)
		throws NoSuchCLMSTATUSHISTORYException;

	public CLMSTATUSHISTORY updateImpl(CLMSTATUSHISTORY clmstatushistory);

	/**
	 * Returns the clmstatushistory with the primary key or throws a <code>NoSuchCLMSTATUSHISTORYException</code> if it could not be found.
	 *
	 * @param id the primary key of the clmstatushistory
	 * @return the clmstatushistory
	 * @throws NoSuchCLMSTATUSHISTORYException if a clmstatushistory with the primary key could not be found
	 */
	public CLMSTATUSHISTORY findByPrimaryKey(int id)
		throws NoSuchCLMSTATUSHISTORYException;

	/**
	 * Returns the clmstatushistory with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the clmstatushistory
	 * @return the clmstatushistory, or <code>null</code> if a clmstatushistory with the primary key could not be found
	 */
	public CLMSTATUSHISTORY fetchByPrimaryKey(int id);

	/**
	 * Returns all the clmstatushistories.
	 *
	 * @return the clmstatushistories
	 */
	public java.util.List<CLMSTATUSHISTORY> findAll();

	/**
	 * Returns a range of all the clmstatushistories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSHISTORYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatushistories
	 * @param end the upper bound of the range of clmstatushistories (not inclusive)
	 * @return the range of clmstatushistories
	 */
	public java.util.List<CLMSTATUSHISTORY> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the clmstatushistories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSHISTORYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatushistories
	 * @param end the upper bound of the range of clmstatushistories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clmstatushistories
	 */
	public java.util.List<CLMSTATUSHISTORY> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMSTATUSHISTORY>
			orderByComparator);

	/**
	 * Returns an ordered range of all the clmstatushistories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSHISTORYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatushistories
	 * @param end the upper bound of the range of clmstatushistories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of clmstatushistories
	 */
	public java.util.List<CLMSTATUSHISTORY> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMSTATUSHISTORY>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the clmstatushistories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of clmstatushistories.
	 *
	 * @return the number of clmstatushistories
	 */
	public int countAll();

}