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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationCoversException;
import com.ejada.atmc.acl.db.model.QuotationCovers;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the quotation covers service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationCoversUtil
 * @generated
 */
@ProviderType
public interface QuotationCoversPersistence
	extends BasePersistence<QuotationCovers> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuotationCoversUtil} to access the quotation covers persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the quotation coverses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation coverses
	 */
	public java.util.List<QuotationCovers> findByQuotationId(long quotationId);

	/**
	 * Returns a range of all the quotation coverses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationCoversModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation coverses
	 * @param end the upper bound of the range of quotation coverses (not inclusive)
	 * @return the range of matching quotation coverses
	 */
	public java.util.List<QuotationCovers> findByQuotationId(
		long quotationId, int start, int end);

	/**
	 * Returns an ordered range of all the quotation coverses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationCoversModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation coverses
	 * @param end the upper bound of the range of quotation coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotation coverses
	 */
	public java.util.List<QuotationCovers> findByQuotationId(
		long quotationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationCovers>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotation coverses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationCoversModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation coverses
	 * @param end the upper bound of the range of quotation coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotation coverses
	 */
	public java.util.List<QuotationCovers> findByQuotationId(
		long quotationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationCovers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first quotation covers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation covers
	 * @throws NoSuchQuotationCoversException if a matching quotation covers could not be found
	 */
	public QuotationCovers findByQuotationId_First(
			long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator<QuotationCovers>
				orderByComparator)
		throws NoSuchQuotationCoversException;

	/**
	 * Returns the first quotation covers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation covers, or <code>null</code> if a matching quotation covers could not be found
	 */
	public QuotationCovers fetchByQuotationId_First(
		long quotationId,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationCovers>
			orderByComparator);

	/**
	 * Returns the last quotation covers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation covers
	 * @throws NoSuchQuotationCoversException if a matching quotation covers could not be found
	 */
	public QuotationCovers findByQuotationId_Last(
			long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator<QuotationCovers>
				orderByComparator)
		throws NoSuchQuotationCoversException;

	/**
	 * Returns the last quotation covers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation covers, or <code>null</code> if a matching quotation covers could not be found
	 */
	public QuotationCovers fetchByQuotationId_Last(
		long quotationId,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationCovers>
			orderByComparator);

	/**
	 * Returns the quotation coverses before and after the current quotation covers in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationCoversPK the primary key of the current quotation covers
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation covers
	 * @throws NoSuchQuotationCoversException if a quotation covers with the primary key could not be found
	 */
	public QuotationCovers[] findByQuotationId_PrevAndNext(
			QuotationCoversPK quotationCoversPK, long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator<QuotationCovers>
				orderByComparator)
		throws NoSuchQuotationCoversException;

	/**
	 * Removes all the quotation coverses where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	public void removeByQuotationId(long quotationId);

	/**
	 * Returns the number of quotation coverses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation coverses
	 */
	public int countByQuotationId(long quotationId);

	/**
	 * Caches the quotation covers in the entity cache if it is enabled.
	 *
	 * @param quotationCovers the quotation covers
	 */
	public void cacheResult(QuotationCovers quotationCovers);

	/**
	 * Caches the quotation coverses in the entity cache if it is enabled.
	 *
	 * @param quotationCoverses the quotation coverses
	 */
	public void cacheResult(java.util.List<QuotationCovers> quotationCoverses);

	/**
	 * Creates a new quotation covers with the primary key. Does not add the quotation covers to the database.
	 *
	 * @param quotationCoversPK the primary key for the new quotation covers
	 * @return the new quotation covers
	 */
	public QuotationCovers create(QuotationCoversPK quotationCoversPK);

	/**
	 * Removes the quotation covers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quotationCoversPK the primary key of the quotation covers
	 * @return the quotation covers that was removed
	 * @throws NoSuchQuotationCoversException if a quotation covers with the primary key could not be found
	 */
	public QuotationCovers remove(QuotationCoversPK quotationCoversPK)
		throws NoSuchQuotationCoversException;

	public QuotationCovers updateImpl(QuotationCovers quotationCovers);

	/**
	 * Returns the quotation covers with the primary key or throws a <code>NoSuchQuotationCoversException</code> if it could not be found.
	 *
	 * @param quotationCoversPK the primary key of the quotation covers
	 * @return the quotation covers
	 * @throws NoSuchQuotationCoversException if a quotation covers with the primary key could not be found
	 */
	public QuotationCovers findByPrimaryKey(QuotationCoversPK quotationCoversPK)
		throws NoSuchQuotationCoversException;

	/**
	 * Returns the quotation covers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quotationCoversPK the primary key of the quotation covers
	 * @return the quotation covers, or <code>null</code> if a quotation covers with the primary key could not be found
	 */
	public QuotationCovers fetchByPrimaryKey(
		QuotationCoversPK quotationCoversPK);

	/**
	 * Returns all the quotation coverses.
	 *
	 * @return the quotation coverses
	 */
	public java.util.List<QuotationCovers> findAll();

	/**
	 * Returns a range of all the quotation coverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationCoversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation coverses
	 * @param end the upper bound of the range of quotation coverses (not inclusive)
	 * @return the range of quotation coverses
	 */
	public java.util.List<QuotationCovers> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the quotation coverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationCoversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation coverses
	 * @param end the upper bound of the range of quotation coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotation coverses
	 */
	public java.util.List<QuotationCovers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationCovers>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotation coverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationCoversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation coverses
	 * @param end the upper bound of the range of quotation coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotation coverses
	 */
	public java.util.List<QuotationCovers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationCovers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the quotation coverses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of quotation coverses.
	 *
	 * @return the number of quotation coverses
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}