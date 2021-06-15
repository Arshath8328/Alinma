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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationsNajmDetailsException;
import com.ejada.atmc.acl.db.model.QuotationsNajmDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the quotations najm details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsNajmDetailsUtil
 * @generated
 */
@ProviderType
public interface QuotationsNajmDetailsPersistence
	extends BasePersistence<QuotationsNajmDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuotationsNajmDetailsUtil} to access the quotations najm details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the quotations najm details where caseNumber = &#63; and quotationId = &#63; or throws a <code>NoSuchQuotationsNajmDetailsException</code> if it could not be found.
	 *
	 * @param caseNumber the case number
	 * @param quotationId the quotation ID
	 * @return the matching quotations najm details
	 * @throws NoSuchQuotationsNajmDetailsException if a matching quotations najm details could not be found
	 */
	public QuotationsNajmDetails findByCaseNumberQuotationId(
			String caseNumber, long quotationId)
		throws NoSuchQuotationsNajmDetailsException;

	/**
	 * Returns the quotations najm details where caseNumber = &#63; and quotationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param caseNumber the case number
	 * @param quotationId the quotation ID
	 * @return the matching quotations najm details, or <code>null</code> if a matching quotations najm details could not be found
	 */
	public QuotationsNajmDetails fetchByCaseNumberQuotationId(
		String caseNumber, long quotationId);

	/**
	 * Returns the quotations najm details where caseNumber = &#63; and quotationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param caseNumber the case number
	 * @param quotationId the quotation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotations najm details, or <code>null</code> if a matching quotations najm details could not be found
	 */
	public QuotationsNajmDetails fetchByCaseNumberQuotationId(
		String caseNumber, long quotationId, boolean useFinderCache);

	/**
	 * Removes the quotations najm details where caseNumber = &#63; and quotationId = &#63; from the database.
	 *
	 * @param caseNumber the case number
	 * @param quotationId the quotation ID
	 * @return the quotations najm details that was removed
	 */
	public QuotationsNajmDetails removeByCaseNumberQuotationId(
			String caseNumber, long quotationId)
		throws NoSuchQuotationsNajmDetailsException;

	/**
	 * Returns the number of quotations najm detailses where caseNumber = &#63; and quotationId = &#63;.
	 *
	 * @param caseNumber the case number
	 * @param quotationId the quotation ID
	 * @return the number of matching quotations najm detailses
	 */
	public int countByCaseNumberQuotationId(
		String caseNumber, long quotationId);

	/**
	 * Returns all the quotations najm detailses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotations najm detailses
	 */
	public java.util.List<QuotationsNajmDetails> findByQuotationId(
		long quotationId);

	/**
	 * Returns a range of all the quotations najm detailses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsNajmDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotations najm detailses
	 * @param end the upper bound of the range of quotations najm detailses (not inclusive)
	 * @return the range of matching quotations najm detailses
	 */
	public java.util.List<QuotationsNajmDetails> findByQuotationId(
		long quotationId, int start, int end);

	/**
	 * Returns an ordered range of all the quotations najm detailses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsNajmDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotations najm detailses
	 * @param end the upper bound of the range of quotations najm detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotations najm detailses
	 */
	public java.util.List<QuotationsNajmDetails> findByQuotationId(
		long quotationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationsNajmDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotations najm detailses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsNajmDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotations najm detailses
	 * @param end the upper bound of the range of quotations najm detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotations najm detailses
	 */
	public java.util.List<QuotationsNajmDetails> findByQuotationId(
		long quotationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationsNajmDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first quotations najm details in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations najm details
	 * @throws NoSuchQuotationsNajmDetailsException if a matching quotations najm details could not be found
	 */
	public QuotationsNajmDetails findByQuotationId_First(
			long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<QuotationsNajmDetails> orderByComparator)
		throws NoSuchQuotationsNajmDetailsException;

	/**
	 * Returns the first quotations najm details in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations najm details, or <code>null</code> if a matching quotations najm details could not be found
	 */
	public QuotationsNajmDetails fetchByQuotationId_First(
		long quotationId,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationsNajmDetails>
			orderByComparator);

	/**
	 * Returns the last quotations najm details in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations najm details
	 * @throws NoSuchQuotationsNajmDetailsException if a matching quotations najm details could not be found
	 */
	public QuotationsNajmDetails findByQuotationId_Last(
			long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<QuotationsNajmDetails> orderByComparator)
		throws NoSuchQuotationsNajmDetailsException;

	/**
	 * Returns the last quotations najm details in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations najm details, or <code>null</code> if a matching quotations najm details could not be found
	 */
	public QuotationsNajmDetails fetchByQuotationId_Last(
		long quotationId,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationsNajmDetails>
			orderByComparator);

	/**
	 * Returns the quotations najm detailses before and after the current quotations najm details in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationsNajmDetailsPK the primary key of the current quotations najm details
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations najm details
	 * @throws NoSuchQuotationsNajmDetailsException if a quotations najm details with the primary key could not be found
	 */
	public QuotationsNajmDetails[] findByQuotationId_PrevAndNext(
			QuotationsNajmDetailsPK quotationsNajmDetailsPK, long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<QuotationsNajmDetails> orderByComparator)
		throws NoSuchQuotationsNajmDetailsException;

	/**
	 * Removes all the quotations najm detailses where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	public void removeByQuotationId(long quotationId);

	/**
	 * Returns the number of quotations najm detailses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotations najm detailses
	 */
	public int countByQuotationId(long quotationId);

	/**
	 * Caches the quotations najm details in the entity cache if it is enabled.
	 *
	 * @param quotationsNajmDetails the quotations najm details
	 */
	public void cacheResult(QuotationsNajmDetails quotationsNajmDetails);

	/**
	 * Caches the quotations najm detailses in the entity cache if it is enabled.
	 *
	 * @param quotationsNajmDetailses the quotations najm detailses
	 */
	public void cacheResult(
		java.util.List<QuotationsNajmDetails> quotationsNajmDetailses);

	/**
	 * Creates a new quotations najm details with the primary key. Does not add the quotations najm details to the database.
	 *
	 * @param quotationsNajmDetailsPK the primary key for the new quotations najm details
	 * @return the new quotations najm details
	 */
	public QuotationsNajmDetails create(
		QuotationsNajmDetailsPK quotationsNajmDetailsPK);

	/**
	 * Removes the quotations najm details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quotationsNajmDetailsPK the primary key of the quotations najm details
	 * @return the quotations najm details that was removed
	 * @throws NoSuchQuotationsNajmDetailsException if a quotations najm details with the primary key could not be found
	 */
	public QuotationsNajmDetails remove(
			QuotationsNajmDetailsPK quotationsNajmDetailsPK)
		throws NoSuchQuotationsNajmDetailsException;

	public QuotationsNajmDetails updateImpl(
		QuotationsNajmDetails quotationsNajmDetails);

	/**
	 * Returns the quotations najm details with the primary key or throws a <code>NoSuchQuotationsNajmDetailsException</code> if it could not be found.
	 *
	 * @param quotationsNajmDetailsPK the primary key of the quotations najm details
	 * @return the quotations najm details
	 * @throws NoSuchQuotationsNajmDetailsException if a quotations najm details with the primary key could not be found
	 */
	public QuotationsNajmDetails findByPrimaryKey(
			QuotationsNajmDetailsPK quotationsNajmDetailsPK)
		throws NoSuchQuotationsNajmDetailsException;

	/**
	 * Returns the quotations najm details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quotationsNajmDetailsPK the primary key of the quotations najm details
	 * @return the quotations najm details, or <code>null</code> if a quotations najm details with the primary key could not be found
	 */
	public QuotationsNajmDetails fetchByPrimaryKey(
		QuotationsNajmDetailsPK quotationsNajmDetailsPK);

	/**
	 * Returns all the quotations najm detailses.
	 *
	 * @return the quotations najm detailses
	 */
	public java.util.List<QuotationsNajmDetails> findAll();

	/**
	 * Returns a range of all the quotations najm detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsNajmDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations najm detailses
	 * @param end the upper bound of the range of quotations najm detailses (not inclusive)
	 * @return the range of quotations najm detailses
	 */
	public java.util.List<QuotationsNajmDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the quotations najm detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsNajmDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations najm detailses
	 * @param end the upper bound of the range of quotations najm detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotations najm detailses
	 */
	public java.util.List<QuotationsNajmDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationsNajmDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotations najm detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsNajmDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations najm detailses
	 * @param end the upper bound of the range of quotations najm detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotations najm detailses
	 */
	public java.util.List<QuotationsNajmDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationsNajmDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the quotations najm detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of quotations najm detailses.
	 *
	 * @return the number of quotations najm detailses
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}