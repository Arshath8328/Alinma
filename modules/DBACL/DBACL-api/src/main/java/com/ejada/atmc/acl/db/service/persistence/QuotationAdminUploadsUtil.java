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

import com.ejada.atmc.acl.db.model.QuotationAdminUploads;

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
 * The persistence utility for the quotation admin uploads service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.QuotationAdminUploadsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationAdminUploadsPersistence
 * @generated
 */
public class QuotationAdminUploadsUtil {

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
	public static void clearCache(QuotationAdminUploads quotationAdminUploads) {
		getPersistence().clearCache(quotationAdminUploads);
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
	public static Map<Serializable, QuotationAdminUploads> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<QuotationAdminUploads> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuotationAdminUploads> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuotationAdminUploads> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QuotationAdminUploads> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QuotationAdminUploads update(
		QuotationAdminUploads quotationAdminUploads) {

		return getPersistence().update(quotationAdminUploads);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QuotationAdminUploads update(
		QuotationAdminUploads quotationAdminUploads,
		ServiceContext serviceContext) {

		return getPersistence().update(quotationAdminUploads, serviceContext);
	}

	/**
	 * Returns all the quotation admin uploadses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation admin uploadses
	 */
	public static List<QuotationAdminUploads> findByQuotationId(
		long quotationId) {

		return getPersistence().findByQuotationId(quotationId);
	}

	/**
	 * Returns a range of all the quotation admin uploadses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation admin uploadses
	 * @param end the upper bound of the range of quotation admin uploadses (not inclusive)
	 * @return the range of matching quotation admin uploadses
	 */
	public static List<QuotationAdminUploads> findByQuotationId(
		long quotationId, int start, int end) {

		return getPersistence().findByQuotationId(quotationId, start, end);
	}

	/**
	 * Returns an ordered range of all the quotation admin uploadses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation admin uploadses
	 * @param end the upper bound of the range of quotation admin uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotation admin uploadses
	 */
	public static List<QuotationAdminUploads> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<QuotationAdminUploads> orderByComparator) {

		return getPersistence().findByQuotationId(
			quotationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the quotation admin uploadses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation admin uploadses
	 * @param end the upper bound of the range of quotation admin uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotation admin uploadses
	 */
	public static List<QuotationAdminUploads> findByQuotationId(
		long quotationId, int start, int end,
		OrderByComparator<QuotationAdminUploads> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByQuotationId(
			quotationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first quotation admin uploads in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation admin uploads
	 * @throws NoSuchQuotationAdminUploadsException if a matching quotation admin uploads could not be found
	 */
	public static QuotationAdminUploads findByQuotationId_First(
			long quotationId,
			OrderByComparator<QuotationAdminUploads> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationAdminUploadsException {

		return getPersistence().findByQuotationId_First(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the first quotation admin uploads in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation admin uploads, or <code>null</code> if a matching quotation admin uploads could not be found
	 */
	public static QuotationAdminUploads fetchByQuotationId_First(
		long quotationId,
		OrderByComparator<QuotationAdminUploads> orderByComparator) {

		return getPersistence().fetchByQuotationId_First(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the last quotation admin uploads in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation admin uploads
	 * @throws NoSuchQuotationAdminUploadsException if a matching quotation admin uploads could not be found
	 */
	public static QuotationAdminUploads findByQuotationId_Last(
			long quotationId,
			OrderByComparator<QuotationAdminUploads> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationAdminUploadsException {

		return getPersistence().findByQuotationId_Last(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the last quotation admin uploads in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation admin uploads, or <code>null</code> if a matching quotation admin uploads could not be found
	 */
	public static QuotationAdminUploads fetchByQuotationId_Last(
		long quotationId,
		OrderByComparator<QuotationAdminUploads> orderByComparator) {

		return getPersistence().fetchByQuotationId_Last(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the quotation admin uploadses before and after the current quotation admin uploads in the ordered set where quotationId = &#63;.
	 *
	 * @param id the primary key of the current quotation admin uploads
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation admin uploads
	 * @throws NoSuchQuotationAdminUploadsException if a quotation admin uploads with the primary key could not be found
	 */
	public static QuotationAdminUploads[] findByQuotationId_PrevAndNext(
			int id, long quotationId,
			OrderByComparator<QuotationAdminUploads> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationAdminUploadsException {

		return getPersistence().findByQuotationId_PrevAndNext(
			id, quotationId, orderByComparator);
	}

	/**
	 * Removes all the quotation admin uploadses where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	public static void removeByQuotationId(long quotationId) {
		getPersistence().removeByQuotationId(quotationId);
	}

	/**
	 * Returns the number of quotation admin uploadses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation admin uploadses
	 */
	public static int countByQuotationId(long quotationId) {
		return getPersistence().countByQuotationId(quotationId);
	}

	/**
	 * Caches the quotation admin uploads in the entity cache if it is enabled.
	 *
	 * @param quotationAdminUploads the quotation admin uploads
	 */
	public static void cacheResult(
		QuotationAdminUploads quotationAdminUploads) {

		getPersistence().cacheResult(quotationAdminUploads);
	}

	/**
	 * Caches the quotation admin uploadses in the entity cache if it is enabled.
	 *
	 * @param quotationAdminUploadses the quotation admin uploadses
	 */
	public static void cacheResult(
		List<QuotationAdminUploads> quotationAdminUploadses) {

		getPersistence().cacheResult(quotationAdminUploadses);
	}

	/**
	 * Creates a new quotation admin uploads with the primary key. Does not add the quotation admin uploads to the database.
	 *
	 * @param id the primary key for the new quotation admin uploads
	 * @return the new quotation admin uploads
	 */
	public static QuotationAdminUploads create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the quotation admin uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the quotation admin uploads
	 * @return the quotation admin uploads that was removed
	 * @throws NoSuchQuotationAdminUploadsException if a quotation admin uploads with the primary key could not be found
	 */
	public static QuotationAdminUploads remove(int id)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationAdminUploadsException {

		return getPersistence().remove(id);
	}

	public static QuotationAdminUploads updateImpl(
		QuotationAdminUploads quotationAdminUploads) {

		return getPersistence().updateImpl(quotationAdminUploads);
	}

	/**
	 * Returns the quotation admin uploads with the primary key or throws a <code>NoSuchQuotationAdminUploadsException</code> if it could not be found.
	 *
	 * @param id the primary key of the quotation admin uploads
	 * @return the quotation admin uploads
	 * @throws NoSuchQuotationAdminUploadsException if a quotation admin uploads with the primary key could not be found
	 */
	public static QuotationAdminUploads findByPrimaryKey(int id)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationAdminUploadsException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the quotation admin uploads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the quotation admin uploads
	 * @return the quotation admin uploads, or <code>null</code> if a quotation admin uploads with the primary key could not be found
	 */
	public static QuotationAdminUploads fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the quotation admin uploadses.
	 *
	 * @return the quotation admin uploadses
	 */
	public static List<QuotationAdminUploads> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the quotation admin uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation admin uploadses
	 * @param end the upper bound of the range of quotation admin uploadses (not inclusive)
	 * @return the range of quotation admin uploadses
	 */
	public static List<QuotationAdminUploads> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the quotation admin uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation admin uploadses
	 * @param end the upper bound of the range of quotation admin uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotation admin uploadses
	 */
	public static List<QuotationAdminUploads> findAll(
		int start, int end,
		OrderByComparator<QuotationAdminUploads> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the quotation admin uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation admin uploadses
	 * @param end the upper bound of the range of quotation admin uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotation admin uploadses
	 */
	public static List<QuotationAdminUploads> findAll(
		int start, int end,
		OrderByComparator<QuotationAdminUploads> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the quotation admin uploadses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of quotation admin uploadses.
	 *
	 * @return the number of quotation admin uploadses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QuotationAdminUploadsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QuotationAdminUploadsPersistence, QuotationAdminUploadsPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			QuotationAdminUploadsPersistence.class);

		ServiceTracker
			<QuotationAdminUploadsPersistence, QuotationAdminUploadsPersistence>
				serviceTracker =
					new ServiceTracker
						<QuotationAdminUploadsPersistence,
						 QuotationAdminUploadsPersistence>(
							 bundle.getBundleContext(),
							 QuotationAdminUploadsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}