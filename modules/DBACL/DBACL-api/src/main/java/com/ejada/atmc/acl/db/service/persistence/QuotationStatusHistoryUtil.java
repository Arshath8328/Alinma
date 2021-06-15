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

import com.ejada.atmc.acl.db.model.QuotationStatusHistory;

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
 * The persistence utility for the quotation status history service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.QuotationStatusHistoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationStatusHistoryPersistence
 * @generated
 */
public class QuotationStatusHistoryUtil {

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
	public static void clearCache(
		QuotationStatusHistory quotationStatusHistory) {

		getPersistence().clearCache(quotationStatusHistory);
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
	public static Map<Serializable, QuotationStatusHistory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<QuotationStatusHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuotationStatusHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuotationStatusHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QuotationStatusHistory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QuotationStatusHistory update(
		QuotationStatusHistory quotationStatusHistory) {

		return getPersistence().update(quotationStatusHistory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QuotationStatusHistory update(
		QuotationStatusHistory quotationStatusHistory,
		ServiceContext serviceContext) {

		return getPersistence().update(quotationStatusHistory, serviceContext);
	}

	/**
	 * Returns all the quotation status histories where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation status histories
	 */
	public static List<QuotationStatusHistory> findByQuotationId(
		long quotationId) {

		return getPersistence().findByQuotationId(quotationId);
	}

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
	public static List<QuotationStatusHistory> findByQuotationId(
		long quotationId, int start, int end) {

		return getPersistence().findByQuotationId(quotationId, start, end);
	}

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
	public static List<QuotationStatusHistory> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<QuotationStatusHistory> orderByComparator) {

		return getPersistence().findByQuotationId(
			quotationId, start, end, orderByComparator);
	}

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
	public static List<QuotationStatusHistory> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<QuotationStatusHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByQuotationId(
			quotationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first quotation status history in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation status history
	 * @throws NoSuchQuotationStatusHistoryException if a matching quotation status history could not be found
	 */
	public static QuotationStatusHistory findByQuotationId_First(
			long quotationId,
			OrderByComparator<QuotationStatusHistory> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationStatusHistoryException {

		return getPersistence().findByQuotationId_First(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the first quotation status history in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation status history, or <code>null</code> if a matching quotation status history could not be found
	 */
	public static QuotationStatusHistory fetchByQuotationId_First(
		long quotationId,
		OrderByComparator<QuotationStatusHistory> orderByComparator) {

		return getPersistence().fetchByQuotationId_First(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the last quotation status history in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation status history
	 * @throws NoSuchQuotationStatusHistoryException if a matching quotation status history could not be found
	 */
	public static QuotationStatusHistory findByQuotationId_Last(
			long quotationId,
			OrderByComparator<QuotationStatusHistory> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationStatusHistoryException {

		return getPersistence().findByQuotationId_Last(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the last quotation status history in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation status history, or <code>null</code> if a matching quotation status history could not be found
	 */
	public static QuotationStatusHistory fetchByQuotationId_Last(
		long quotationId,
		OrderByComparator<QuotationStatusHistory> orderByComparator) {

		return getPersistence().fetchByQuotationId_Last(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the quotation status histories before and after the current quotation status history in the ordered set where quotationId = &#63;.
	 *
	 * @param historyId the primary key of the current quotation status history
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation status history
	 * @throws NoSuchQuotationStatusHistoryException if a quotation status history with the primary key could not be found
	 */
	public static QuotationStatusHistory[] findByQuotationId_PrevAndNext(
			long historyId, long quotationId,
			OrderByComparator<QuotationStatusHistory> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationStatusHistoryException {

		return getPersistence().findByQuotationId_PrevAndNext(
			historyId, quotationId, orderByComparator);
	}

	/**
	 * Removes all the quotation status histories where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	public static void removeByQuotationId(long quotationId) {
		getPersistence().removeByQuotationId(quotationId);
	}

	/**
	 * Returns the number of quotation status histories where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation status histories
	 */
	public static int countByQuotationId(long quotationId) {
		return getPersistence().countByQuotationId(quotationId);
	}

	/**
	 * Caches the quotation status history in the entity cache if it is enabled.
	 *
	 * @param quotationStatusHistory the quotation status history
	 */
	public static void cacheResult(
		QuotationStatusHistory quotationStatusHistory) {

		getPersistence().cacheResult(quotationStatusHistory);
	}

	/**
	 * Caches the quotation status histories in the entity cache if it is enabled.
	 *
	 * @param quotationStatusHistories the quotation status histories
	 */
	public static void cacheResult(
		List<QuotationStatusHistory> quotationStatusHistories) {

		getPersistence().cacheResult(quotationStatusHistories);
	}

	/**
	 * Creates a new quotation status history with the primary key. Does not add the quotation status history to the database.
	 *
	 * @param historyId the primary key for the new quotation status history
	 * @return the new quotation status history
	 */
	public static QuotationStatusHistory create(long historyId) {
		return getPersistence().create(historyId);
	}

	/**
	 * Removes the quotation status history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param historyId the primary key of the quotation status history
	 * @return the quotation status history that was removed
	 * @throws NoSuchQuotationStatusHistoryException if a quotation status history with the primary key could not be found
	 */
	public static QuotationStatusHistory remove(long historyId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationStatusHistoryException {

		return getPersistence().remove(historyId);
	}

	public static QuotationStatusHistory updateImpl(
		QuotationStatusHistory quotationStatusHistory) {

		return getPersistence().updateImpl(quotationStatusHistory);
	}

	/**
	 * Returns the quotation status history with the primary key or throws a <code>NoSuchQuotationStatusHistoryException</code> if it could not be found.
	 *
	 * @param historyId the primary key of the quotation status history
	 * @return the quotation status history
	 * @throws NoSuchQuotationStatusHistoryException if a quotation status history with the primary key could not be found
	 */
	public static QuotationStatusHistory findByPrimaryKey(long historyId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationStatusHistoryException {

		return getPersistence().findByPrimaryKey(historyId);
	}

	/**
	 * Returns the quotation status history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param historyId the primary key of the quotation status history
	 * @return the quotation status history, or <code>null</code> if a quotation status history with the primary key could not be found
	 */
	public static QuotationStatusHistory fetchByPrimaryKey(long historyId) {
		return getPersistence().fetchByPrimaryKey(historyId);
	}

	/**
	 * Returns all the quotation status histories.
	 *
	 * @return the quotation status histories
	 */
	public static List<QuotationStatusHistory> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<QuotationStatusHistory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<QuotationStatusHistory> findAll(
		int start, int end,
		OrderByComparator<QuotationStatusHistory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<QuotationStatusHistory> findAll(
		int start, int end,
		OrderByComparator<QuotationStatusHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the quotation status histories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of quotation status histories.
	 *
	 * @return the number of quotation status histories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QuotationStatusHistoryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QuotationStatusHistoryPersistence, QuotationStatusHistoryPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			QuotationStatusHistoryPersistence.class);

		ServiceTracker
			<QuotationStatusHistoryPersistence,
			 QuotationStatusHistoryPersistence> serviceTracker =
				new ServiceTracker
					<QuotationStatusHistoryPersistence,
					 QuotationStatusHistoryPersistence>(
						 bundle.getBundleContext(),
						 QuotationStatusHistoryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}