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

import com.ejada.atmc.acl.db.model.Quotations;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the quotations service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.QuotationsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsPersistence
 * @generated
 */
public class QuotationsUtil {

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
	public static void clearCache(Quotations quotations) {
		getPersistence().clearCache(quotations);
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
	public static Map<Serializable, Quotations> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Quotations> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Quotations> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Quotations> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Quotations update(Quotations quotations) {
		return getPersistence().update(quotations);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Quotations update(
		Quotations quotations, ServiceContext serviceContext) {

		return getPersistence().update(quotations, serviceContext);
	}

	/**
	 * Returns all the quotationses where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @return the matching quotationses
	 */
	public static List<Quotations> findByInsuredId(long insuredId) {
		return getPersistence().findByInsuredId(insuredId);
	}

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
	public static List<Quotations> findByInsuredId(
		long insuredId, int start, int end) {

		return getPersistence().findByInsuredId(insuredId, start, end);
	}

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
	public static List<Quotations> findByInsuredId(
		long insuredId, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().findByInsuredId(
			insuredId, start, end, orderByComparator);
	}

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
	public static List<Quotations> findByInsuredId(
		long insuredId, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByInsuredId(
			insuredId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first quotations in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public static Quotations findByInsuredId_First(
			long insuredId, OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByInsuredId_First(
			insuredId, orderByComparator);
	}

	/**
	 * Returns the first quotations in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public static Quotations fetchByInsuredId_First(
		long insuredId, OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().fetchByInsuredId_First(
			insuredId, orderByComparator);
	}

	/**
	 * Returns the last quotations in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public static Quotations findByInsuredId_Last(
			long insuredId, OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByInsuredId_Last(
			insuredId, orderByComparator);
	}

	/**
	 * Returns the last quotations in the ordered set where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public static Quotations fetchByInsuredId_Last(
		long insuredId, OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().fetchByInsuredId_Last(
			insuredId, orderByComparator);
	}

	/**
	 * Returns the quotationses before and after the current quotations in the ordered set where insuredId = &#63;.
	 *
	 * @param quotationId the primary key of the current quotations
	 * @param insuredId the insured ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	public static Quotations[] findByInsuredId_PrevAndNext(
			long quotationId, long insuredId,
			OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByInsuredId_PrevAndNext(
			quotationId, insuredId, orderByComparator);
	}

	/**
	 * Removes all the quotationses where insuredId = &#63; from the database.
	 *
	 * @param insuredId the insured ID
	 */
	public static void removeByInsuredId(long insuredId) {
		getPersistence().removeByInsuredId(insuredId);
	}

	/**
	 * Returns the number of quotationses where insuredId = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @return the number of matching quotationses
	 */
	public static int countByInsuredId(long insuredId) {
		return getPersistence().countByInsuredId(insuredId);
	}

	/**
	 * Returns all the quotationses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotationses
	 */
	public static List<Quotations> findByQuotationId(long quotationId) {
		return getPersistence().findByQuotationId(quotationId);
	}

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
	public static List<Quotations> findByQuotationId(
		long quotationId, int start, int end) {

		return getPersistence().findByQuotationId(quotationId, start, end);
	}

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
	public static List<Quotations> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().findByQuotationId(
			quotationId, start, end, orderByComparator);
	}

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
	public static List<Quotations> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByQuotationId(
			quotationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first quotations in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public static Quotations findByQuotationId_First(
			long quotationId, OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByQuotationId_First(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the first quotations in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public static Quotations fetchByQuotationId_First(
		long quotationId, OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().fetchByQuotationId_First(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the last quotations in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public static Quotations findByQuotationId_Last(
			long quotationId, OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByQuotationId_Last(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the last quotations in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public static Quotations fetchByQuotationId_Last(
		long quotationId, OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().fetchByQuotationId_Last(
			quotationId, orderByComparator);
	}

	/**
	 * Removes all the quotationses where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	public static void removeByQuotationId(long quotationId) {
		getPersistence().removeByQuotationId(quotationId);
	}

	/**
	 * Returns the number of quotationses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotationses
	 */
	public static int countByQuotationId(long quotationId) {
		return getPersistence().countByQuotationId(quotationId);
	}

	/**
	 * Returns all the quotationses where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @return the matching quotationses
	 */
	public static List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String quoteStatus) {

		return getPersistence().findByInsuredIdAndStatus(
			insuredId, quoteStatus);
	}

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
	public static List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String quoteStatus, int start, int end) {

		return getPersistence().findByInsuredIdAndStatus(
			insuredId, quoteStatus, start, end);
	}

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
	public static List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String quoteStatus, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().findByInsuredIdAndStatus(
			insuredId, quoteStatus, start, end, orderByComparator);
	}

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
	public static List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String quoteStatus, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByInsuredIdAndStatus(
			insuredId, quoteStatus, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first quotations in the ordered set where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public static Quotations findByInsuredIdAndStatus_First(
			long insuredId, String quoteStatus,
			OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByInsuredIdAndStatus_First(
			insuredId, quoteStatus, orderByComparator);
	}

	/**
	 * Returns the first quotations in the ordered set where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public static Quotations fetchByInsuredIdAndStatus_First(
		long insuredId, String quoteStatus,
		OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().fetchByInsuredIdAndStatus_First(
			insuredId, quoteStatus, orderByComparator);
	}

	/**
	 * Returns the last quotations in the ordered set where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public static Quotations findByInsuredIdAndStatus_Last(
			long insuredId, String quoteStatus,
			OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByInsuredIdAndStatus_Last(
			insuredId, quoteStatus, orderByComparator);
	}

	/**
	 * Returns the last quotations in the ordered set where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public static Quotations fetchByInsuredIdAndStatus_Last(
		long insuredId, String quoteStatus,
		OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().fetchByInsuredIdAndStatus_Last(
			insuredId, quoteStatus, orderByComparator);
	}

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
	public static Quotations[] findByInsuredIdAndStatus_PrevAndNext(
			long quotationId, long insuredId, String quoteStatus,
			OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByInsuredIdAndStatus_PrevAndNext(
			quotationId, insuredId, quoteStatus, orderByComparator);
	}

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
	public static List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String[] quoteStatuses) {

		return getPersistence().findByInsuredIdAndStatus(
			insuredId, quoteStatuses);
	}

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
	public static List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String[] quoteStatuses, int start, int end) {

		return getPersistence().findByInsuredIdAndStatus(
			insuredId, quoteStatuses, start, end);
	}

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
	public static List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String[] quoteStatuses, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().findByInsuredIdAndStatus(
			insuredId, quoteStatuses, start, end, orderByComparator);
	}

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
	public static List<Quotations> findByInsuredIdAndStatus(
		long insuredId, String[] quoteStatuses, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByInsuredIdAndStatus(
			insuredId, quoteStatuses, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the quotationses where insuredId = &#63; and quoteStatus = &#63; from the database.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 */
	public static void removeByInsuredIdAndStatus(
		long insuredId, String quoteStatus) {

		getPersistence().removeByInsuredIdAndStatus(insuredId, quoteStatus);
	}

	/**
	 * Returns the number of quotationses where insuredId = &#63; and quoteStatus = &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatus the quote status
	 * @return the number of matching quotationses
	 */
	public static int countByInsuredIdAndStatus(
		long insuredId, String quoteStatus) {

		return getPersistence().countByInsuredIdAndStatus(
			insuredId, quoteStatus);
	}

	/**
	 * Returns the number of quotationses where insuredId = &#63; and quoteStatus = any &#63;.
	 *
	 * @param insuredId the insured ID
	 * @param quoteStatuses the quote statuses
	 * @return the number of matching quotationses
	 */
	public static int countByInsuredIdAndStatus(
		long insuredId, String[] quoteStatuses) {

		return getPersistence().countByInsuredIdAndStatus(
			insuredId, quoteStatuses);
	}

	/**
	 * Returns all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @return the matching quotationses
	 */
	public static List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String quoteStatus) {

		return getPersistence().findByDateExpiredQuots(
			vehicleEstExpiryDate, quoteStatus);
	}

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
	public static List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String quoteStatus, int start, int end) {

		return getPersistence().findByDateExpiredQuots(
			vehicleEstExpiryDate, quoteStatus, start, end);
	}

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
	public static List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String quoteStatus, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().findByDateExpiredQuots(
			vehicleEstExpiryDate, quoteStatus, start, end, orderByComparator);
	}

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
	public static List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String quoteStatus, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDateExpiredQuots(
			vehicleEstExpiryDate, quoteStatus, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first quotations in the ordered set where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public static Quotations findByDateExpiredQuots_First(
			Date vehicleEstExpiryDate, String quoteStatus,
			OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByDateExpiredQuots_First(
			vehicleEstExpiryDate, quoteStatus, orderByComparator);
	}

	/**
	 * Returns the first quotations in the ordered set where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public static Quotations fetchByDateExpiredQuots_First(
		Date vehicleEstExpiryDate, String quoteStatus,
		OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().fetchByDateExpiredQuots_First(
			vehicleEstExpiryDate, quoteStatus, orderByComparator);
	}

	/**
	 * Returns the last quotations in the ordered set where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public static Quotations findByDateExpiredQuots_Last(
			Date vehicleEstExpiryDate, String quoteStatus,
			OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByDateExpiredQuots_Last(
			vehicleEstExpiryDate, quoteStatus, orderByComparator);
	}

	/**
	 * Returns the last quotations in the ordered set where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public static Quotations fetchByDateExpiredQuots_Last(
		Date vehicleEstExpiryDate, String quoteStatus,
		OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().fetchByDateExpiredQuots_Last(
			vehicleEstExpiryDate, quoteStatus, orderByComparator);
	}

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
	public static Quotations[] findByDateExpiredQuots_PrevAndNext(
			long quotationId, Date vehicleEstExpiryDate, String quoteStatus,
			OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByDateExpiredQuots_PrevAndNext(
			quotationId, vehicleEstExpiryDate, quoteStatus, orderByComparator);
	}

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
	public static List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String[] quoteStatuses) {

		return getPersistence().findByDateExpiredQuots(
			vehicleEstExpiryDate, quoteStatuses);
	}

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
	public static List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String[] quoteStatuses, int start, int end) {

		return getPersistence().findByDateExpiredQuots(
			vehicleEstExpiryDate, quoteStatuses, start, end);
	}

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
	public static List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String[] quoteStatuses, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().findByDateExpiredQuots(
			vehicleEstExpiryDate, quoteStatuses, start, end, orderByComparator);
	}

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
	public static List<Quotations> findByDateExpiredQuots(
		Date vehicleEstExpiryDate, String[] quoteStatuses, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDateExpiredQuots(
			vehicleEstExpiryDate, quoteStatuses, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63; from the database.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 */
	public static void removeByDateExpiredQuots(
		Date vehicleEstExpiryDate, String quoteStatus) {

		getPersistence().removeByDateExpiredQuots(
			vehicleEstExpiryDate, quoteStatus);
	}

	/**
	 * Returns the number of quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @return the number of matching quotationses
	 */
	public static int countByDateExpiredQuots(
		Date vehicleEstExpiryDate, String quoteStatus) {

		return getPersistence().countByDateExpiredQuots(
			vehicleEstExpiryDate, quoteStatus);
	}

	/**
	 * Returns the number of quotationses where vehicleEstExpiryDate &lt; &#63; and quoteStatus = any &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatuses the quote statuses
	 * @return the number of matching quotationses
	 */
	public static int countByDateExpiredQuots(
		Date vehicleEstExpiryDate, String[] quoteStatuses) {

		return getPersistence().countByDateExpiredQuots(
			vehicleEstExpiryDate, quoteStatuses);
	}

	/**
	 * Returns all the quotationses where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @return the matching quotationses
	 */
	public static List<Quotations> findByPendingQuots(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag) {

		return getPersistence().findByPendingQuots(
			vehicleEstExpiryDate, quoteStatus, smsFlag);
	}

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
	public static List<Quotations> findByPendingQuots(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
		int start, int end) {

		return getPersistence().findByPendingQuots(
			vehicleEstExpiryDate, quoteStatus, smsFlag, start, end);
	}

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
	public static List<Quotations> findByPendingQuots(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
		int start, int end, OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().findByPendingQuots(
			vehicleEstExpiryDate, quoteStatus, smsFlag, start, end,
			orderByComparator);
	}

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
	public static List<Quotations> findByPendingQuots(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
		int start, int end, OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPendingQuots(
			vehicleEstExpiryDate, quoteStatus, smsFlag, start, end,
			orderByComparator, useFinderCache);
	}

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
	public static Quotations findByPendingQuots_First(
			Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
			OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByPendingQuots_First(
			vehicleEstExpiryDate, quoteStatus, smsFlag, orderByComparator);
	}

	/**
	 * Returns the first quotations in the ordered set where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public static Quotations fetchByPendingQuots_First(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
		OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().fetchByPendingQuots_First(
			vehicleEstExpiryDate, quoteStatus, smsFlag, orderByComparator);
	}

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
	public static Quotations findByPendingQuots_Last(
			Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
			OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByPendingQuots_Last(
			vehicleEstExpiryDate, quoteStatus, smsFlag, orderByComparator);
	}

	/**
	 * Returns the last quotations in the ordered set where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public static Quotations fetchByPendingQuots_Last(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag,
		OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().fetchByPendingQuots_Last(
			vehicleEstExpiryDate, quoteStatus, smsFlag, orderByComparator);
	}

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
	public static Quotations[] findByPendingQuots_PrevAndNext(
			long quotationId, Date vehicleEstExpiryDate, String quoteStatus,
			boolean smsFlag, OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByPendingQuots_PrevAndNext(
			quotationId, vehicleEstExpiryDate, quoteStatus, smsFlag,
			orderByComparator);
	}

	/**
	 * Removes all the quotationses where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63; from the database.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 */
	public static void removeByPendingQuots(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag) {

		getPersistence().removeByPendingQuots(
			vehicleEstExpiryDate, quoteStatus, smsFlag);
	}

	/**
	 * Returns the number of quotationses where vehicleEstExpiryDate &gt; &#63; and quoteStatus = &#63; and smsFlag = &#63;.
	 *
	 * @param vehicleEstExpiryDate the vehicle est expiry date
	 * @param quoteStatus the quote status
	 * @param smsFlag the sms flag
	 * @return the number of matching quotationses
	 */
	public static int countByPendingQuots(
		Date vehicleEstExpiryDate, String quoteStatus, boolean smsFlag) {

		return getPersistence().countByPendingQuots(
			vehicleEstExpiryDate, quoteStatus, smsFlag);
	}

	/**
	 * Returns all the quotationses where quoteStatus = &#63;.
	 *
	 * @param quoteStatus the quote status
	 * @return the matching quotationses
	 */
	public static List<Quotations> findByQuotsStatus(String quoteStatus) {
		return getPersistence().findByQuotsStatus(quoteStatus);
	}

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
	public static List<Quotations> findByQuotsStatus(
		String quoteStatus, int start, int end) {

		return getPersistence().findByQuotsStatus(quoteStatus, start, end);
	}

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
	public static List<Quotations> findByQuotsStatus(
		String quoteStatus, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().findByQuotsStatus(
			quoteStatus, start, end, orderByComparator);
	}

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
	public static List<Quotations> findByQuotsStatus(
		String quoteStatus, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByQuotsStatus(
			quoteStatus, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first quotations in the ordered set where quoteStatus = &#63;.
	 *
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public static Quotations findByQuotsStatus_First(
			String quoteStatus, OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByQuotsStatus_First(
			quoteStatus, orderByComparator);
	}

	/**
	 * Returns the first quotations in the ordered set where quoteStatus = &#63;.
	 *
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public static Quotations fetchByQuotsStatus_First(
		String quoteStatus, OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().fetchByQuotsStatus_First(
			quoteStatus, orderByComparator);
	}

	/**
	 * Returns the last quotations in the ordered set where quoteStatus = &#63;.
	 *
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public static Quotations findByQuotsStatus_Last(
			String quoteStatus, OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByQuotsStatus_Last(
			quoteStatus, orderByComparator);
	}

	/**
	 * Returns the last quotations in the ordered set where quoteStatus = &#63;.
	 *
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public static Quotations fetchByQuotsStatus_Last(
		String quoteStatus, OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().fetchByQuotsStatus_Last(
			quoteStatus, orderByComparator);
	}

	/**
	 * Returns the quotationses before and after the current quotations in the ordered set where quoteStatus = &#63;.
	 *
	 * @param quotationId the primary key of the current quotations
	 * @param quoteStatus the quote status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	public static Quotations[] findByQuotsStatus_PrevAndNext(
			long quotationId, String quoteStatus,
			OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByQuotsStatus_PrevAndNext(
			quotationId, quoteStatus, orderByComparator);
	}

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
	public static List<Quotations> findByQuotsStatus(String[] quoteStatuses) {
		return getPersistence().findByQuotsStatus(quoteStatuses);
	}

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
	public static List<Quotations> findByQuotsStatus(
		String[] quoteStatuses, int start, int end) {

		return getPersistence().findByQuotsStatus(quoteStatuses, start, end);
	}

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
	public static List<Quotations> findByQuotsStatus(
		String[] quoteStatuses, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().findByQuotsStatus(
			quoteStatuses, start, end, orderByComparator);
	}

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
	public static List<Quotations> findByQuotsStatus(
		String[] quoteStatuses, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByQuotsStatus(
			quoteStatuses, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the quotationses where quoteStatus = &#63; from the database.
	 *
	 * @param quoteStatus the quote status
	 */
	public static void removeByQuotsStatus(String quoteStatus) {
		getPersistence().removeByQuotsStatus(quoteStatus);
	}

	/**
	 * Returns the number of quotationses where quoteStatus = &#63;.
	 *
	 * @param quoteStatus the quote status
	 * @return the number of matching quotationses
	 */
	public static int countByQuotsStatus(String quoteStatus) {
		return getPersistence().countByQuotsStatus(quoteStatus);
	}

	/**
	 * Returns the number of quotationses where quoteStatus = any &#63;.
	 *
	 * @param quoteStatuses the quote statuses
	 * @return the number of matching quotationses
	 */
	public static int countByQuotsStatus(String[] quoteStatuses) {
		return getPersistence().countByQuotsStatus(quoteStatuses);
	}

	/**
	 * Returns all the quotationses where referenceNo = &#63;.
	 *
	 * @param referenceNo the reference no
	 * @return the matching quotationses
	 */
	public static List<Quotations> findByReferenceNo(String referenceNo) {
		return getPersistence().findByReferenceNo(referenceNo);
	}

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
	public static List<Quotations> findByReferenceNo(
		String referenceNo, int start, int end) {

		return getPersistence().findByReferenceNo(referenceNo, start, end);
	}

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
	public static List<Quotations> findByReferenceNo(
		String referenceNo, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().findByReferenceNo(
			referenceNo, start, end, orderByComparator);
	}

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
	public static List<Quotations> findByReferenceNo(
		String referenceNo, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByReferenceNo(
			referenceNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first quotations in the ordered set where referenceNo = &#63;.
	 *
	 * @param referenceNo the reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public static Quotations findByReferenceNo_First(
			String referenceNo, OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByReferenceNo_First(
			referenceNo, orderByComparator);
	}

	/**
	 * Returns the first quotations in the ordered set where referenceNo = &#63;.
	 *
	 * @param referenceNo the reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public static Quotations fetchByReferenceNo_First(
		String referenceNo, OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().fetchByReferenceNo_First(
			referenceNo, orderByComparator);
	}

	/**
	 * Returns the last quotations in the ordered set where referenceNo = &#63;.
	 *
	 * @param referenceNo the reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public static Quotations findByReferenceNo_Last(
			String referenceNo, OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByReferenceNo_Last(
			referenceNo, orderByComparator);
	}

	/**
	 * Returns the last quotations in the ordered set where referenceNo = &#63;.
	 *
	 * @param referenceNo the reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public static Quotations fetchByReferenceNo_Last(
		String referenceNo, OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().fetchByReferenceNo_Last(
			referenceNo, orderByComparator);
	}

	/**
	 * Returns the quotationses before and after the current quotations in the ordered set where referenceNo = &#63;.
	 *
	 * @param quotationId the primary key of the current quotations
	 * @param referenceNo the reference no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	public static Quotations[] findByReferenceNo_PrevAndNext(
			long quotationId, String referenceNo,
			OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByReferenceNo_PrevAndNext(
			quotationId, referenceNo, orderByComparator);
	}

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
	public static List<Quotations> findByReferenceNo(String[] referenceNos) {
		return getPersistence().findByReferenceNo(referenceNos);
	}

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
	public static List<Quotations> findByReferenceNo(
		String[] referenceNos, int start, int end) {

		return getPersistence().findByReferenceNo(referenceNos, start, end);
	}

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
	public static List<Quotations> findByReferenceNo(
		String[] referenceNos, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().findByReferenceNo(
			referenceNos, start, end, orderByComparator);
	}

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
	public static List<Quotations> findByReferenceNo(
		String[] referenceNos, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByReferenceNo(
			referenceNos, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the quotationses where referenceNo = &#63; from the database.
	 *
	 * @param referenceNo the reference no
	 */
	public static void removeByReferenceNo(String referenceNo) {
		getPersistence().removeByReferenceNo(referenceNo);
	}

	/**
	 * Returns the number of quotationses where referenceNo = &#63;.
	 *
	 * @param referenceNo the reference no
	 * @return the number of matching quotationses
	 */
	public static int countByReferenceNo(String referenceNo) {
		return getPersistence().countByReferenceNo(referenceNo);
	}

	/**
	 * Returns the number of quotationses where referenceNo = any &#63;.
	 *
	 * @param referenceNos the reference nos
	 * @return the number of matching quotationses
	 */
	public static int countByReferenceNo(String[] referenceNos) {
		return getPersistence().countByReferenceNo(referenceNos);
	}

	/**
	 * Returns the quotations where policyNo = &#63; or throws a <code>NoSuchQuotationsException</code> if it could not be found.
	 *
	 * @param policyNo the policy no
	 * @return the matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public static Quotations findByPolicyNo(String policyNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByPolicyNo(policyNo);
	}

	/**
	 * Returns the quotations where policyNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyNo the policy no
	 * @return the matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public static Quotations fetchByPolicyNo(String policyNo) {
		return getPersistence().fetchByPolicyNo(policyNo);
	}

	/**
	 * Returns the quotations where policyNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyNo the policy no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public static Quotations fetchByPolicyNo(
		String policyNo, boolean useFinderCache) {

		return getPersistence().fetchByPolicyNo(policyNo, useFinderCache);
	}

	/**
	 * Removes the quotations where policyNo = &#63; from the database.
	 *
	 * @param policyNo the policy no
	 * @return the quotations that was removed
	 */
	public static Quotations removeByPolicyNo(String policyNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().removeByPolicyNo(policyNo);
	}

	/**
	 * Returns the number of quotationses where policyNo = &#63;.
	 *
	 * @param policyNo the policy no
	 * @return the number of matching quotationses
	 */
	public static int countByPolicyNo(String policyNo) {
		return getPersistence().countByPolicyNo(policyNo);
	}

	/**
	 * Returns all the quotationses where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @return the matching quotationses
	 */
	public static List<Quotations> findByinsuredMobile(long insuredMobile) {
		return getPersistence().findByinsuredMobile(insuredMobile);
	}

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
	public static List<Quotations> findByinsuredMobile(
		long insuredMobile, int start, int end) {

		return getPersistence().findByinsuredMobile(insuredMobile, start, end);
	}

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
	public static List<Quotations> findByinsuredMobile(
		long insuredMobile, int start, int end,
		OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().findByinsuredMobile(
			insuredMobile, start, end, orderByComparator);
	}

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
	public static List<Quotations> findByinsuredMobile(
		long insuredMobile, int start, int end,
		OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByinsuredMobile(
			insuredMobile, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first quotations in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public static Quotations findByinsuredMobile_First(
			long insuredMobile, OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByinsuredMobile_First(
			insuredMobile, orderByComparator);
	}

	/**
	 * Returns the first quotations in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public static Quotations fetchByinsuredMobile_First(
		long insuredMobile, OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().fetchByinsuredMobile_First(
			insuredMobile, orderByComparator);
	}

	/**
	 * Returns the last quotations in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations
	 * @throws NoSuchQuotationsException if a matching quotations could not be found
	 */
	public static Quotations findByinsuredMobile_Last(
			long insuredMobile, OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByinsuredMobile_Last(
			insuredMobile, orderByComparator);
	}

	/**
	 * Returns the last quotations in the ordered set where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotations, or <code>null</code> if a matching quotations could not be found
	 */
	public static Quotations fetchByinsuredMobile_Last(
		long insuredMobile, OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().fetchByinsuredMobile_Last(
			insuredMobile, orderByComparator);
	}

	/**
	 * Returns the quotationses before and after the current quotations in the ordered set where insuredMobile = &#63;.
	 *
	 * @param quotationId the primary key of the current quotations
	 * @param insuredMobile the insured mobile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	public static Quotations[] findByinsuredMobile_PrevAndNext(
			long quotationId, long insuredMobile,
			OrderByComparator<Quotations> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByinsuredMobile_PrevAndNext(
			quotationId, insuredMobile, orderByComparator);
	}

	/**
	 * Removes all the quotationses where insuredMobile = &#63; from the database.
	 *
	 * @param insuredMobile the insured mobile
	 */
	public static void removeByinsuredMobile(long insuredMobile) {
		getPersistence().removeByinsuredMobile(insuredMobile);
	}

	/**
	 * Returns the number of quotationses where insuredMobile = &#63;.
	 *
	 * @param insuredMobile the insured mobile
	 * @return the number of matching quotationses
	 */
	public static int countByinsuredMobile(long insuredMobile) {
		return getPersistence().countByinsuredMobile(insuredMobile);
	}

	/**
	 * Caches the quotations in the entity cache if it is enabled.
	 *
	 * @param quotations the quotations
	 */
	public static void cacheResult(Quotations quotations) {
		getPersistence().cacheResult(quotations);
	}

	/**
	 * Caches the quotationses in the entity cache if it is enabled.
	 *
	 * @param quotationses the quotationses
	 */
	public static void cacheResult(List<Quotations> quotationses) {
		getPersistence().cacheResult(quotationses);
	}

	/**
	 * Creates a new quotations with the primary key. Does not add the quotations to the database.
	 *
	 * @param quotationId the primary key for the new quotations
	 * @return the new quotations
	 */
	public static Quotations create(long quotationId) {
		return getPersistence().create(quotationId);
	}

	/**
	 * Removes the quotations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quotationId the primary key of the quotations
	 * @return the quotations that was removed
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	public static Quotations remove(long quotationId)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().remove(quotationId);
	}

	public static Quotations updateImpl(Quotations quotations) {
		return getPersistence().updateImpl(quotations);
	}

	/**
	 * Returns the quotations with the primary key or throws a <code>NoSuchQuotationsException</code> if it could not be found.
	 *
	 * @param quotationId the primary key of the quotations
	 * @return the quotations
	 * @throws NoSuchQuotationsException if a quotations with the primary key could not be found
	 */
	public static Quotations findByPrimaryKey(long quotationId)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getPersistence().findByPrimaryKey(quotationId);
	}

	/**
	 * Returns the quotations with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quotationId the primary key of the quotations
	 * @return the quotations, or <code>null</code> if a quotations with the primary key could not be found
	 */
	public static Quotations fetchByPrimaryKey(long quotationId) {
		return getPersistence().fetchByPrimaryKey(quotationId);
	}

	/**
	 * Returns all the quotationses.
	 *
	 * @return the quotationses
	 */
	public static List<Quotations> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Quotations> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Quotations> findAll(
		int start, int end, OrderByComparator<Quotations> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Quotations> findAll(
		int start, int end, OrderByComparator<Quotations> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the quotationses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of quotationses.
	 *
	 * @return the number of quotationses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QuotationsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<QuotationsPersistence, QuotationsPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(QuotationsPersistence.class);

		ServiceTracker<QuotationsPersistence, QuotationsPersistence>
			serviceTracker =
				new ServiceTracker
					<QuotationsPersistence, QuotationsPersistence>(
						bundle.getBundleContext(), QuotationsPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}