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

import com.ejada.atmc.acl.db.model.QuotationsNajmDetails;

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
 * The persistence utility for the quotations najm details service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.QuotationsNajmDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsNajmDetailsPersistence
 * @generated
 */
public class QuotationsNajmDetailsUtil {

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
	public static void clearCache(QuotationsNajmDetails quotationsNajmDetails) {
		getPersistence().clearCache(quotationsNajmDetails);
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
	public static Map<Serializable, QuotationsNajmDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<QuotationsNajmDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuotationsNajmDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuotationsNajmDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QuotationsNajmDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QuotationsNajmDetails update(
		QuotationsNajmDetails quotationsNajmDetails) {

		return getPersistence().update(quotationsNajmDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QuotationsNajmDetails update(
		QuotationsNajmDetails quotationsNajmDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(quotationsNajmDetails, serviceContext);
	}

	/**
	 * Returns the quotations najm details where caseNumber = &#63; and quotationId = &#63; or throws a <code>NoSuchQuotationsNajmDetailsException</code> if it could not be found.
	 *
	 * @param caseNumber the case number
	 * @param quotationId the quotation ID
	 * @return the matching quotations najm details
	 * @throws NoSuchQuotationsNajmDetailsException if a matching quotations najm details could not be found
	 */
	public static QuotationsNajmDetails findByCaseNumberQuotationId(
			String caseNumber, long quotationId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationsNajmDetailsException {

		return getPersistence().findByCaseNumberQuotationId(
			caseNumber, quotationId);
	}

	/**
	 * Returns the quotations najm details where caseNumber = &#63; and quotationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param caseNumber the case number
	 * @param quotationId the quotation ID
	 * @return the matching quotations najm details, or <code>null</code> if a matching quotations najm details could not be found
	 */
	public static QuotationsNajmDetails fetchByCaseNumberQuotationId(
		String caseNumber, long quotationId) {

		return getPersistence().fetchByCaseNumberQuotationId(
			caseNumber, quotationId);
	}

	/**
	 * Returns the quotations najm details where caseNumber = &#63; and quotationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param caseNumber the case number
	 * @param quotationId the quotation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotations najm details, or <code>null</code> if a matching quotations najm details could not be found
	 */
	public static QuotationsNajmDetails fetchByCaseNumberQuotationId(
		String caseNumber, long quotationId, boolean useFinderCache) {

		return getPersistence().fetchByCaseNumberQuotationId(
			caseNumber, quotationId, useFinderCache);
	}

	/**
	 * Removes the quotations najm details where caseNumber = &#63; and quotationId = &#63; from the database.
	 *
	 * @param caseNumber the case number
	 * @param quotationId the quotation ID
	 * @return the quotations najm details that was removed
	 */
	public static QuotationsNajmDetails removeByCaseNumberQuotationId(
			String caseNumber, long quotationId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationsNajmDetailsException {

		return getPersistence().removeByCaseNumberQuotationId(
			caseNumber, quotationId);
	}

	/**
	 * Returns the number of quotations najm detailses where caseNumber = &#63; and quotationId = &#63;.
	 *
	 * @param caseNumber the case number
	 * @param quotationId the quotation ID
	 * @return the number of matching quotations najm detailses
	 */
	public static int countByCaseNumberQuotationId(
		String caseNumber, long quotationId) {

		return getPersistence().countByCaseNumberQuotationId(
			caseNumber, quotationId);
	}

	/**
	 * Returns all the quotations najm detailses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotations najm detailses
	 */
	public static List<QuotationsNajmDetails> findByQuotationId(
		long quotationId) {

		return getPersistence().findByQuotationId(quotationId);
	}

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
	public static List<QuotationsNajmDetails> findByQuotationId(
		long quotationId, int start, int end) {

		return getPersistence().findByQuotationId(quotationId, start, end);
	}

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
	public static List<QuotationsNajmDetails> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<QuotationsNajmDetails> orderByComparator) {

		return getPersistence().findByQuotationId(
			quotationId, start, end, orderByComparator);
	}

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
	public static List<QuotationsNajmDetails> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<QuotationsNajmDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByQuotationId(
			quotationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first quotations najm details in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations najm details
	 * @throws NoSuchQuotationsNajmDetailsException if a matching quotations najm details could not be found
	 */
	public static QuotationsNajmDetails findByQuotationId_First(
			long quotationId,
			OrderByComparator<QuotationsNajmDetails> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationsNajmDetailsException {

		return getPersistence().findByQuotationId_First(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the first quotations najm details in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations najm details, or <code>null</code> if a matching quotations najm details could not be found
	 */
	public static QuotationsNajmDetails fetchByQuotationId_First(
		long quotationId,
		OrderByComparator<QuotationsNajmDetails> orderByComparator) {

		return getPersistence().fetchByQuotationId_First(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the last quotations najm details in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations najm details
	 * @throws NoSuchQuotationsNajmDetailsException if a matching quotations najm details could not be found
	 */
	public static QuotationsNajmDetails findByQuotationId_Last(
			long quotationId,
			OrderByComparator<QuotationsNajmDetails> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationsNajmDetailsException {

		return getPersistence().findByQuotationId_Last(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the last quotations najm details in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations najm details, or <code>null</code> if a matching quotations najm details could not be found
	 */
	public static QuotationsNajmDetails fetchByQuotationId_Last(
		long quotationId,
		OrderByComparator<QuotationsNajmDetails> orderByComparator) {

		return getPersistence().fetchByQuotationId_Last(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the quotations najm detailses before and after the current quotations najm details in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationsNajmDetailsPK the primary key of the current quotations najm details
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations najm details
	 * @throws NoSuchQuotationsNajmDetailsException if a quotations najm details with the primary key could not be found
	 */
	public static QuotationsNajmDetails[] findByQuotationId_PrevAndNext(
			QuotationsNajmDetailsPK quotationsNajmDetailsPK, long quotationId,
			OrderByComparator<QuotationsNajmDetails> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationsNajmDetailsException {

		return getPersistence().findByQuotationId_PrevAndNext(
			quotationsNajmDetailsPK, quotationId, orderByComparator);
	}

	/**
	 * Removes all the quotations najm detailses where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	public static void removeByQuotationId(long quotationId) {
		getPersistence().removeByQuotationId(quotationId);
	}

	/**
	 * Returns the number of quotations najm detailses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotations najm detailses
	 */
	public static int countByQuotationId(long quotationId) {
		return getPersistence().countByQuotationId(quotationId);
	}

	/**
	 * Caches the quotations najm details in the entity cache if it is enabled.
	 *
	 * @param quotationsNajmDetails the quotations najm details
	 */
	public static void cacheResult(
		QuotationsNajmDetails quotationsNajmDetails) {

		getPersistence().cacheResult(quotationsNajmDetails);
	}

	/**
	 * Caches the quotations najm detailses in the entity cache if it is enabled.
	 *
	 * @param quotationsNajmDetailses the quotations najm detailses
	 */
	public static void cacheResult(
		List<QuotationsNajmDetails> quotationsNajmDetailses) {

		getPersistence().cacheResult(quotationsNajmDetailses);
	}

	/**
	 * Creates a new quotations najm details with the primary key. Does not add the quotations najm details to the database.
	 *
	 * @param quotationsNajmDetailsPK the primary key for the new quotations najm details
	 * @return the new quotations najm details
	 */
	public static QuotationsNajmDetails create(
		QuotationsNajmDetailsPK quotationsNajmDetailsPK) {

		return getPersistence().create(quotationsNajmDetailsPK);
	}

	/**
	 * Removes the quotations najm details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quotationsNajmDetailsPK the primary key of the quotations najm details
	 * @return the quotations najm details that was removed
	 * @throws NoSuchQuotationsNajmDetailsException if a quotations najm details with the primary key could not be found
	 */
	public static QuotationsNajmDetails remove(
			QuotationsNajmDetailsPK quotationsNajmDetailsPK)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationsNajmDetailsException {

		return getPersistence().remove(quotationsNajmDetailsPK);
	}

	public static QuotationsNajmDetails updateImpl(
		QuotationsNajmDetails quotationsNajmDetails) {

		return getPersistence().updateImpl(quotationsNajmDetails);
	}

	/**
	 * Returns the quotations najm details with the primary key or throws a <code>NoSuchQuotationsNajmDetailsException</code> if it could not be found.
	 *
	 * @param quotationsNajmDetailsPK the primary key of the quotations najm details
	 * @return the quotations najm details
	 * @throws NoSuchQuotationsNajmDetailsException if a quotations najm details with the primary key could not be found
	 */
	public static QuotationsNajmDetails findByPrimaryKey(
			QuotationsNajmDetailsPK quotationsNajmDetailsPK)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationsNajmDetailsException {

		return getPersistence().findByPrimaryKey(quotationsNajmDetailsPK);
	}

	/**
	 * Returns the quotations najm details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quotationsNajmDetailsPK the primary key of the quotations najm details
	 * @return the quotations najm details, or <code>null</code> if a quotations najm details with the primary key could not be found
	 */
	public static QuotationsNajmDetails fetchByPrimaryKey(
		QuotationsNajmDetailsPK quotationsNajmDetailsPK) {

		return getPersistence().fetchByPrimaryKey(quotationsNajmDetailsPK);
	}

	/**
	 * Returns all the quotations najm detailses.
	 *
	 * @return the quotations najm detailses
	 */
	public static List<QuotationsNajmDetails> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<QuotationsNajmDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<QuotationsNajmDetails> findAll(
		int start, int end,
		OrderByComparator<QuotationsNajmDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<QuotationsNajmDetails> findAll(
		int start, int end,
		OrderByComparator<QuotationsNajmDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the quotations najm detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of quotations najm detailses.
	 *
	 * @return the number of quotations najm detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static QuotationsNajmDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QuotationsNajmDetailsPersistence, QuotationsNajmDetailsPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			QuotationsNajmDetailsPersistence.class);

		ServiceTracker
			<QuotationsNajmDetailsPersistence, QuotationsNajmDetailsPersistence>
				serviceTracker =
					new ServiceTracker
						<QuotationsNajmDetailsPersistence,
						 QuotationsNajmDetailsPersistence>(
							 bundle.getBundleContext(),
							 QuotationsNajmDetailsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}