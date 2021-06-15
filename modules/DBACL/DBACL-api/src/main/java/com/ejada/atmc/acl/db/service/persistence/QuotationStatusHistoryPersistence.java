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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationStatusHistoryException;
import com.ejada.atmc.acl.db.model.QuotationStatusHistory;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the quotation status history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationStatusHistoryUtil
 * @generated
 */
@ProviderType
public interface QuotationStatusHistoryPersistence
	extends BasePersistence<QuotationStatusHistory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuotationStatusHistoryUtil} to access the quotation status history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the quotation status histories where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation status histories
	 */
	public java.util.List<QuotationStatusHistory> findByQuotationId(
		long quotationId);

	/**
	 * Returns a range of all the quotation status histories where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationStatusHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation status histories
	 * @param end the upper bound of the range of quotation status histories (not inclusive)
	 * @return the range of matching quotation status histories
	 */
	public java.util.List<QuotationStatusHistory> findByQuotationId(
		long quotationId, int start, int end);

	/**
	 * Returns an ordered range of all the quotation status histories where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationStatusHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation status histories
	 * @param end the upper bound of the range of quotation status histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotation status histories
	 */
	public java.util.List<QuotationStatusHistory> findByQuotationId(
		long quotationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationStatusHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotation status histories where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationStatusHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation status histories
	 * @param end the upper bound of the range of quotation status histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotation status histories
	 */
	public java.util.List<QuotationStatusHistory> findByQuotationId(
		long quotationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationStatusHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first quotation status history in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation status history
	 * @throws NoSuchQuotationStatusHistoryException if a matching quotation status history could not be found
	 */
	public QuotationStatusHistory findByQuotationId_First(
			long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<QuotationStatusHistory> orderByComparator)
		throws NoSuchQuotationStatusHistoryException;

	/**
	 * Returns the first quotation status history in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation status history, or <code>null</code> if a matching quotation status history could not be found
	 */
	public QuotationStatusHistory fetchByQuotationId_First(
		long quotationId,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationStatusHistory>
			orderByComparator);

	/**
	 * Returns the last quotation status history in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation status history
	 * @throws NoSuchQuotationStatusHistoryException if a matching quotation status history could not be found
	 */
	public QuotationStatusHistory findByQuotationId_Last(
			long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<QuotationStatusHistory> orderByComparator)
		throws NoSuchQuotationStatusHistoryException;

	/**
	 * Returns the last quotation status history in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation status history, or <code>null</code> if a matching quotation status history could not be found
	 */
	public QuotationStatusHistory fetchByQuotationId_Last(
		long quotationId,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationStatusHistory>
			orderByComparator);

	/**
	 * Returns the quotation status histories before and after the current quotation status history in the ordered set where quotationId = &#63;.
	 *
	 * @param historyId the primary key of the current quotation status history
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation status history
	 * @throws NoSuchQuotationStatusHistoryException if a quotation status history with the primary key could not be found
	 */
	public QuotationStatusHistory[] findByQuotationId_PrevAndNext(
			long historyId, long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<QuotationStatusHistory> orderByComparator)
		throws NoSuchQuotationStatusHistoryException;

	/**
	 * Removes all the quotation status histories where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	public void removeByQuotationId(long quotationId);

	/**
	 * Returns the number of quotation status histories where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation status histories
	 */
	public int countByQuotationId(long quotationId);

	/**
	 * Caches the quotation status history in the entity cache if it is enabled.
	 *
	 * @param quotationStatusHistory the quotation status history
	 */
	public void cacheResult(QuotationStatusHistory quotationStatusHistory);

	/**
	 * Caches the quotation status histories in the entity cache if it is enabled.
	 *
	 * @param quotationStatusHistories the quotation status histories
	 */
	public void cacheResult(
		java.util.List<QuotationStatusHistory> quotationStatusHistories);

	/**
	 * Creates a new quotation status history with the primary key. Does not add the quotation status history to the database.
	 *
	 * @param historyId the primary key for the new quotation status history
	 * @return the new quotation status history
	 */
	public QuotationStatusHistory create(long historyId);

	/**
	 * Removes the quotation status history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param historyId the primary key of the quotation status history
	 * @return the quotation status history that was removed
	 * @throws NoSuchQuotationStatusHistoryException if a quotation status history with the primary key could not be found
	 */
	public QuotationStatusHistory remove(long historyId)
		throws NoSuchQuotationStatusHistoryException;

	public QuotationStatusHistory updateImpl(
		QuotationStatusHistory quotationStatusHistory);

	/**
	 * Returns the quotation status history with the primary key or throws a <code>NoSuchQuotationStatusHistoryException</code> if it could not be found.
	 *
	 * @param historyId the primary key of the quotation status history
	 * @return the quotation status history
	 * @throws NoSuchQuotationStatusHistoryException if a quotation status history with the primary key could not be found
	 */
	public QuotationStatusHistory findByPrimaryKey(long historyId)
		throws NoSuchQuotationStatusHistoryException;

	/**
	 * Returns the quotation status history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param historyId the primary key of the quotation status history
	 * @return the quotation status history, or <code>null</code> if a quotation status history with the primary key could not be found
	 */
	public QuotationStatusHistory fetchByPrimaryKey(long historyId);

	/**
	 * Returns all the quotation status histories.
	 *
	 * @return the quotation status histories
	 */
	public java.util.List<QuotationStatusHistory> findAll();

	/**
	 * Returns a range of all the quotation status histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationStatusHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation status histories
	 * @param end the upper bound of the range of quotation status histories (not inclusive)
	 * @return the range of quotation status histories
	 */
	public java.util.List<QuotationStatusHistory> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the quotation status histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationStatusHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation status histories
	 * @param end the upper bound of the range of quotation status histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotation status histories
	 */
	public java.util.List<QuotationStatusHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationStatusHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotation status histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationStatusHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation status histories
	 * @param end the upper bound of the range of quotation status histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotation status histories
	 */
	public java.util.List<QuotationStatusHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationStatusHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the quotation status histories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of quotation status histories.
	 *
	 * @return the number of quotation status histories
	 */
	public int countAll();

}