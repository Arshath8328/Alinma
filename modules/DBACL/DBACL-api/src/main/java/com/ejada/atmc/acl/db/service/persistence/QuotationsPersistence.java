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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationsException;
import com.ejada.atmc.acl.db.model.Quotations;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the quotations service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsUtil
 * @generated
 */
@ProviderType
public interface QuotationsPersistence extends BasePersistence<Quotations> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuotationsUtil} to access the quotations persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the quotationses where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @return the matching quotationses
	 */
	public java.util.List<Quotations> findByInsuredId(long insuredId);

	/**
	 * Returns a range of all the quotationses where insuredId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	public java.util.List<Quotations> findByInsuredId(
		long insuredId, int start, int end);

	/**
	 * Returns an ordered range of all the quotationses where insuredId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByInsuredId(
		long insuredId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotationses where insuredId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByInsuredId(
		long insuredId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first quotations in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public Quotations findByInsuredId_First(
			long insuredId,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns the first quotations in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public Quotations fetchByInsuredId_First(
		long insuredId,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns the last quotations in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public Quotations findByInsuredId_Last(
			long insuredId,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns the last quotations in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public Quotations fetchByInsuredId_Last(
		long insuredId,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns the quotationses before and after the current quotations in the ordered set where insuredId = &#63;.
	 *
	 * @param quotationId the primary key of the current quotations
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	public Quotations[] findByInsuredId_PrevAndNext(
			long quotationId, long insuredId,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Removes all the quotationses where insuredId = &#63; from the database.
	 *
	 * @param insuredId the insured ID
	 */
	public void removeByInsuredId(long insuredId);

	/**
	 * Returns the number of quotationses where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @return the number of matching quotationses
	 */
	public int countByInsuredId(long insuredId);

	/**
	 * Returns all the quotationses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotationses
	 */
	public java.util.List<Quotations> findByQuotationId(long quotationId);

	/**
	 * Returns a range of all the quotationses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	public java.util.List<Quotations> findByQuotationId(
		long quotationId, int start, int end);

	/**
	 * Returns an ordered range of all the quotationses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByQuotationId(
		long quotationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotationses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByQuotationId(
		long quotationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first quotations in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public Quotations findByQuotationId_First(
			long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns the first quotations in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public Quotations fetchByQuotationId_First(
		long quotationId,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns the last quotations in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public Quotations findByQuotationId_Last(
			long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns the last quotations in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public Quotations fetchByQuotationId_Last(
		long quotationId,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Removes all the quotationses where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	public void removeByQuotationId(long quotationId);

	/**
	 * Returns the number of quotationses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotationses
	 */
	public int countByQuotationId(long quotationId);

	/**
	 * Returns all the quotationses where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @return the matching quotationses
	 */
	public java.util.List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String quoteStatus);

	/**
	 * Returns a range of all the quotationses where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	public java.util.List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String quoteStatus, int start, int end);

	/**
	 * Returns an ordered range of all the quotationses where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String quoteStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotationses where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String quoteStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first quotations in the ordered set where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public Quotations findByInsuredIdAndStatus_First(
			long insuredId, String quoteStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns the first quotations in the ordered set where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public Quotations fetchByInsuredIdAndStatus_First(
		long insuredId, String quoteStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns the last quotations in the ordered set where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public Quotations findByInsuredIdAndStatus_Last(
			long insuredId, String quoteStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns the last quotations in the ordered set where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public Quotations fetchByInsuredIdAndStatus_Last(
		long insuredId, String quoteStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns the quotationses before and after the current quotations in the ordered set where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param quotationId the primary key of the current quotations
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	public Quotations[] findByInsuredIdAndStatus_PrevAndNext(
			long quotationId, long insuredId, String quoteStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns all the quotationses where insuredId = &#63; and quoteStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatuses the quote statuses
	 * @return the matching quotationses
	 */
	public java.util.List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String[] quoteStatuses);

	/**
	 * Returns a range of all the quotationses where insuredId = &#63; and quoteStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatuses the quote statuses
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	public java.util.List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String[] quoteStatuses, int start, int end);

	/**
	 * Returns an ordered range of all the quotationses where insuredId = &#63; and quoteStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatuses the quote statuses
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String[] quoteStatuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotationses where insuredId = &#63; and quoteStatus = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String[] quoteStatuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the quotationses where insuredId = &#63; and quoteStatus = &#63; from the database.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 */
	public void removeByInsuredIdAndStatus(long insuredId, String quoteStatus);

	/**
	 * Returns the number of quotationses where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @return the number of matching quotationses
	 */
	public int countByInsuredIdAndStatus(long insuredId, String quoteStatus);

	/**
	 * Returns the number of quotationses where insuredId = &#63; and quoteStatus = any &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatuses the quote statuses
	 * @return the number of matching quotationses
	 */
	public int countByInsuredIdAndStatus(
		long insuredId, String[] quoteStatuses);

	/**
	 * Returns all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @return the matching quotationses
	 */
	public java.util.List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String quoteStatus);

	/**
	 * Returns a range of all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	public java.util.List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String quoteStatus, int start, int end);

	/**
	 * Returns an ordered range of all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String quoteStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String quoteStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first quotations in the ordered set where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public Quotations findByDateExpiredQuots_First(
			Date vehicleEstExpiryDate, String quoteStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns the first quotations in the ordered set where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public Quotations fetchByDateExpiredQuots_First(
		Date vehicleEstExpiryDate, String quoteStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns the last quotations in the ordered set where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public Quotations findByDateExpiredQuots_Last(
			Date vehicleEstExpiryDate, String quoteStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns the last quotations in the ordered set where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public Quotations fetchByDateExpiredQuots_Last(
		Date vehicleEstExpiryDate, String quoteStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns the quotationses before and after the current quotations in the ordered set where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param quotationId the primary key of the current quotations
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	public Quotations[] findByDateExpiredQuots_PrevAndNext(
			long quotationId, Date vehicleEstExpiryDate, String quoteStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatuses the quote statuses
	 * @return the matching quotationses
	 */
	public java.util.List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String[] quoteStatuses);

	/**
	 * Returns a range of all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatuses the quote statuses
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	public java.util.List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String[] quoteStatuses, int start, int end);

	/**
	 * Returns an ordered range of all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatuses the quote statuses
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String[] quoteStatuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String[] quoteStatuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63; from the database.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 */
	public void removeByDateExpiredQuots(
		Date vehicleEstExpiryDate, String quoteStatus);

	/**
	 * Returns the number of quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @return the number of matching quotationses
	 */
	public int countByDateExpiredQuots(
		Date vehicleEstExpiryDate, String quoteStatus);

	/**
	 * Returns the number of quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = any &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatuses the quote statuses
	 * @return the number of matching quotationses
	 */
	public int countByDateExpiredQuots(
		Date vehicleEstExpiryDate, String[] quoteStatuses);

	/**
	 * Returns all the quotationses where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @return the matching quotationses
	 */
	public java.util.List<Quotations> findByPendingQuots(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag);

	/**
	 * Returns a range of all the quotationses where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	public java.util.List<Quotations> findByPendingQuots(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
		int start, int end);

	/**
	 * Returns an ordered range of all the quotationses where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByPendingQuots(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotationses where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByPendingQuots(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first quotations in the ordered set where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public Quotations findByPendingQuots_First(
			Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns the first quotations in the ordered set where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public Quotations fetchByPendingQuots_First(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns the last quotations in the ordered set where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public Quotations findByPendingQuots_Last(
			Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns the last quotations in the ordered set where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public Quotations fetchByPendingQuots_Last(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns the quotationses before and after the current quotations in the ordered set where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * @param quotationId the primary key of the current quotations
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	public Quotations[] findByPendingQuots_PrevAndNext(
			long quotationId, Date vehicleEstExpiryDate, String quoteStatus,
			boolean smsFlag,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Removes all the quotationses where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63; from the database.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 */
	public void removeByPendingQuots(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag);

	/**
	 * Returns the number of quotationses where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @return the number of matching quotationses
	 */
	public int countByPendingQuots(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag);

	/**
	 * Returns all the quotationses where quoteStatus = &#63;.
	 *
	 * @param quoteStatus the quote status
	 * @return the matching quotationses
	 */
	public java.util.List<Quotations> findByQuotsStatus(String quoteStatus);

	/**
	 * Returns a range of all the quotationses where quoteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	public java.util.List<Quotations> findByQuotsStatus(
		String quoteStatus, int start, int end);

	/**
	 * Returns an ordered range of all the quotationses where quoteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByQuotsStatus(
		String quoteStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotationses where quoteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByQuotsStatus(
		String quoteStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first quotations in the ordered set where quoteStatus = &#63;.
	 *
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public Quotations findByQuotsStatus_First(
			String quoteStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns the first quotations in the ordered set where quoteStatus = &#63;.
	 *
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public Quotations fetchByQuotsStatus_First(
		String quoteStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns the last quotations in the ordered set where quoteStatus = &#63;.
	 *
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public Quotations findByQuotsStatus_Last(
			String quoteStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns the last quotations in the ordered set where quoteStatus = &#63;.
	 *
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public Quotations fetchByQuotsStatus_Last(
		String quoteStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns the quotationses before and after the current quotations in the ordered set where quoteStatus = &#63;.
	 *
	 * @param quotationId the primary key of the current quotations
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	public Quotations[] findByQuotsStatus_PrevAndNext(
			long quotationId, String quoteStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns all the quotationses where quoteStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quoteStatuses the quote statuses
	 * @return the matching quotationses
	 */
	public java.util.List<Quotations> findByQuotsStatus(String[] quoteStatuses);

	/**
	 * Returns a range of all the quotationses where quoteStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quoteStatuses the quote statuses
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	public java.util.List<Quotations> findByQuotsStatus(
		String[] quoteStatuses, int start, int end);

	/**
	 * Returns an ordered range of all the quotationses where quoteStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quoteStatuses the quote statuses
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByQuotsStatus(
		String[] quoteStatuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotationses where quoteStatus = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param quoteStatus the quote status
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByQuotsStatus(
		String[] quoteStatuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the quotationses where quoteStatus = &#63; from the database.
	 *
	 * @param quoteStatus the quote status
	 */
	public void removeByQuotsStatus(String quoteStatus);

	/**
	 * Returns the number of quotationses where quoteStatus = &#63;.
	 *
	 * @param quoteStatus the quote status
	 * @return the number of matching quotationses
	 */
	public int countByQuotsStatus(String quoteStatus);

	/**
	 * Returns the number of quotationses where quoteStatus = any &#63;.
	 *
	 * @param quoteStatuses the quote statuses
	 * @return the number of matching quotationses
	 */
	public int countByQuotsStatus(String[] quoteStatuses);

	/**
	 * Returns all the quotationses where referenceNo = &#63;.
	 *
	 * @param referenceNo the reference no
	 * @return the matching quotationses
	 */
	public java.util.List<Quotations> findByReferenceNo(String referenceNo);

	/**
	 * Returns a range of all the quotationses where referenceNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param referenceNo the reference no
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	public java.util.List<Quotations> findByReferenceNo(
		String referenceNo, int start, int end);

	/**
	 * Returns an ordered range of all the quotationses where referenceNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param referenceNo the reference no
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByReferenceNo(
		String referenceNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotationses where referenceNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param referenceNo the reference no
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByReferenceNo(
		String referenceNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first quotations in the ordered set where referenceNo = &#63;.
	 *
	 * @param referenceNo the reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public Quotations findByReferenceNo_First(
			String referenceNo,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns the first quotations in the ordered set where referenceNo = &#63;.
	 *
	 * @param referenceNo the reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public Quotations fetchByReferenceNo_First(
		String referenceNo,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns the last quotations in the ordered set where referenceNo = &#63;.
	 *
	 * @param referenceNo the reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public Quotations findByReferenceNo_Last(
			String referenceNo,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns the last quotations in the ordered set where referenceNo = &#63;.
	 *
	 * @param referenceNo the reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public Quotations fetchByReferenceNo_Last(
		String referenceNo,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns the quotationses before and after the current quotations in the ordered set where referenceNo = &#63;.
	 *
	 * @param quotationId the primary key of the current quotations
	 * @param referenceNo the reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	public Quotations[] findByReferenceNo_PrevAndNext(
			long quotationId, String referenceNo,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns all the quotationses where referenceNo = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param referenceNos the reference nos
	 * @return the matching quotationses
	 */
	public java.util.List<Quotations> findByReferenceNo(String[] referenceNos);

	/**
	 * Returns a range of all the quotationses where referenceNo = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param referenceNos the reference nos
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	public java.util.List<Quotations> findByReferenceNo(
		String[] referenceNos, int start, int end);

	/**
	 * Returns an ordered range of all the quotationses where referenceNo = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param referenceNos the reference nos
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByReferenceNo(
		String[] referenceNos, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotationses where referenceNo = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param referenceNo the reference no
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByReferenceNo(
		String[] referenceNos, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the quotationses where referenceNo = &#63; from the database.
	 *
	 * @param referenceNo the reference no
	 */
	public void removeByReferenceNo(String referenceNo);

	/**
	 * Returns the number of quotationses where referenceNo = &#63;.
	 *
	 * @param referenceNo the reference no
	 * @return the number of matching quotationses
	 */
	public int countByReferenceNo(String referenceNo);

	/**
	 * Returns the number of quotationses where referenceNo = any &#63;.
	 *
	 * @param referenceNos the reference nos
	 * @return the number of matching quotationses
	 */
	public int countByReferenceNo(String[] referenceNos);

	/**
	 * Returns the quotations where policyNo = &#63; or throws a <code>NoSuchQuotationsException</code> if it could not be found.
	 *
	 * @param policyNo the policy no
	 * @return the matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public Quotations findByPolicyNo(String policyNo)
		throws NoSuchQuotationsException;

	/**
	 * Returns the quotations where policyNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyNo the policy no
	 * @return the matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public Quotations fetchByPolicyNo(String policyNo);

	/**
	 * Returns the quotations where policyNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyNo the policy no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public Quotations fetchByPolicyNo(String policyNo, boolean useFinderCache);

	/**
	 * Removes the quotations where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 * @return the quotations that was removed
	 */
	public Quotations removeByPolicyNo(String policyNo)
		throws NoSuchQuotationsException;

	/**
	 * Returns the number of quotationses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching quotationses
	 */
	public int countByPolicyNo(String policyNo);

	/**
	 * Returns all the quotationses where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @return the matching quotationses
	 */
	public java.util.List<Quotations> findByinsuredMobile(long insuredMobile);

	/**
	 * Returns a range of all the quotationses where insuredMobile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredMobile the insured mobile
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of matching quotationses
	 */
	public java.util.List<Quotations> findByinsuredMobile(
		long insuredMobile, int start, int end);

	/**
	 * Returns an ordered range of all the quotationses where insuredMobile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredMobile the insured mobile
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByinsuredMobile(
		long insuredMobile, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotationses where insuredMobile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param insuredMobile the insured mobile
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotationses
	 */
	public java.util.List<Quotations> findByinsuredMobile(
		long insuredMobile, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first quotations in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public Quotations findByinsuredMobile_First(
			long insuredMobile,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns the first quotations in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public Quotations fetchByinsuredMobile_First(
		long insuredMobile,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns the last quotations in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public Quotations findByinsuredMobile_Last(
			long insuredMobile,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Returns the last quotations in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public Quotations fetchByinsuredMobile_Last(
		long insuredMobile,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns the quotationses before and after the current quotations in the ordered set where insuredMobile = &#63;.
	 *
	 * @param quotationId the primary key of the current quotations
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	public Quotations[] findByinsuredMobile_PrevAndNext(
			long quotationId, long insuredMobile,
			com.liferay.portal.kernel.util.OrderByComparator<Quotations>
				orderByComparator)
		throws NoSuchQuotationsException;

	/**
	 * Removes all the quotationses where insuredMobile = &#63; from the database.
	 *
	 * @param insuredMobile the insured mobile
	 */
	public void removeByinsuredMobile(long insuredMobile);

	/**
	 * Returns the number of quotationses where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @return the number of matching quotationses
	 */
	public int countByinsuredMobile(long insuredMobile);

	/**
	 * Caches the quotations in the entity cache if it is enabled.
	 *
	 * @param quotations the quotations
	 */
	public void cacheResult(Quotations quotations);

	/**
	 * Caches the quotationses in the entity cache if it is enabled.
	 *
	 * @param quotationses the quotationses
	 */
	public void cacheResult(java.util.List<Quotations> quotationses);

	/**
	 * Creates a new quotations with the primary key. Does not add the quotations to the database.
	 *
	 * @param quotationId the primary key for the new quotations
	 * @return the new quotations
	 */
	public Quotations create(long quotationId);

	/**
	 * Removes the quotations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quotationId the primary key of the quotations
	 * @return the quotations that was removed
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	public Quotations remove(long quotationId) throws NoSuchQuotationsException;

	public Quotations updateImpl(Quotations quotations);

	/**
	 * Returns the quotations with the primary key or throws a <code>NoSuchQuotationsException</code> if it could not be found.
	 *
	 * @param quotationId the primary key of the quotations
	 * @return the quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	public Quotations findByPrimaryKey(long quotationId)
		throws NoSuchQuotationsException;

	/**
	 * Returns the quotations with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quotationId the primary key of the quotations
	 * @return the quotations, or <code>null</code> if a quotations with the primary key could not be found
	 */
	public Quotations fetchByPrimaryKey(long quotationId);

	/**
	 * Returns all the quotationses.
	 *
	 * @return the quotationses
	 */
	public java.util.List<Quotations> findAll();

	/**
	 * Returns a range of all the quotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of quotationses
	 */
	public java.util.List<Quotations> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the quotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotationses
	 */
	public java.util.List<Quotations> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotationses
	 */
	public java.util.List<Quotations> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Quotations>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the quotationses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of quotationses.
	 *
	 * @return the number of quotationses
	 */
	public int countAll();

}