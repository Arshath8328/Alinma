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

import com.ejada.atmc.acl.db.model.QuotationExtraTameeniInfo;

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
 * The persistence utility for the quotation extra tameeni info service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.QuotationExtraTameeniInfoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationExtraTameeniInfoPersistence
 * @generated
 */
public class QuotationExtraTameeniInfoUtil {

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
		QuotationExtraTameeniInfo quotationExtraTameeniInfo) {

		getPersistence().clearCache(quotationExtraTameeniInfo);
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
	public static Map<Serializable, QuotationExtraTameeniInfo>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<QuotationExtraTameeniInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuotationExtraTameeniInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuotationExtraTameeniInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QuotationExtraTameeniInfo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QuotationExtraTameeniInfo update(
		QuotationExtraTameeniInfo quotationExtraTameeniInfo) {

		return getPersistence().update(quotationExtraTameeniInfo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QuotationExtraTameeniInfo update(
		QuotationExtraTameeniInfo quotationExtraTameeniInfo,
		ServiceContext serviceContext) {

		return getPersistence().update(
			quotationExtraTameeniInfo, serviceContext);
	}

	/**
	 * Returns the quotation extra tameeni info where quotationId = &#63; or throws a <code>NoSuchQuotationExtraTameeniInfoException</code> if it could not be found.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation extra tameeni info
	 * @throws NoSuchQuotationExtraTameeniInfoException if a matching quotation extra tameeni info could not be found
	 */
	public static QuotationExtraTameeniInfo findByQuotationId(long quotationId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationExtraTameeniInfoException {

		return getPersistence().findByQuotationId(quotationId);
	}

	/**
	 * Returns the quotation extra tameeni info where quotationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation extra tameeni info, or <code>null</code> if a matching quotation extra tameeni info could not be found
	 */
	public static QuotationExtraTameeniInfo fetchByQuotationId(
		long quotationId) {

		return getPersistence().fetchByQuotationId(quotationId);
	}

	/**
	 * Returns the quotation extra tameeni info where quotationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quotationId the quotation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotation extra tameeni info, or <code>null</code> if a matching quotation extra tameeni info could not be found
	 */
	public static QuotationExtraTameeniInfo fetchByQuotationId(
		long quotationId, boolean useFinderCache) {

		return getPersistence().fetchByQuotationId(quotationId, useFinderCache);
	}

	/**
	 * Removes the quotation extra tameeni info where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 * @return the quotation extra tameeni info that was removed
	 */
	public static QuotationExtraTameeniInfo removeByQuotationId(
			long quotationId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationExtraTameeniInfoException {

		return getPersistence().removeByQuotationId(quotationId);
	}

	/**
	 * Returns the number of quotation extra tameeni infos where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation extra tameeni infos
	 */
	public static int countByQuotationId(long quotationId) {
		return getPersistence().countByQuotationId(quotationId);
	}

	/**
	 * Caches the quotation extra tameeni info in the entity cache if it is enabled.
	 *
	 * @param quotationExtraTameeniInfo the quotation extra tameeni info
	 */
	public static void cacheResult(
		QuotationExtraTameeniInfo quotationExtraTameeniInfo) {

		getPersistence().cacheResult(quotationExtraTameeniInfo);
	}

	/**
	 * Caches the quotation extra tameeni infos in the entity cache if it is enabled.
	 *
	 * @param quotationExtraTameeniInfos the quotation extra tameeni infos
	 */
	public static void cacheResult(
		List<QuotationExtraTameeniInfo> quotationExtraTameeniInfos) {

		getPersistence().cacheResult(quotationExtraTameeniInfos);
	}

	/**
	 * Creates a new quotation extra tameeni info with the primary key. Does not add the quotation extra tameeni info to the database.
	 *
	 * @param quotationId the primary key for the new quotation extra tameeni info
	 * @return the new quotation extra tameeni info
	 */
	public static QuotationExtraTameeniInfo create(long quotationId) {
		return getPersistence().create(quotationId);
	}

	/**
	 * Removes the quotation extra tameeni info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quotationId the primary key of the quotation extra tameeni info
	 * @return the quotation extra tameeni info that was removed
	 * @throws NoSuchQuotationExtraTameeniInfoException if a quotation extra tameeni info with the primary key could not be found
	 */
	public static QuotationExtraTameeniInfo remove(long quotationId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationExtraTameeniInfoException {

		return getPersistence().remove(quotationId);
	}

	public static QuotationExtraTameeniInfo updateImpl(
		QuotationExtraTameeniInfo quotationExtraTameeniInfo) {

		return getPersistence().updateImpl(quotationExtraTameeniInfo);
	}

	/**
	 * Returns the quotation extra tameeni info with the primary key or throws a <code>NoSuchQuotationExtraTameeniInfoException</code> if it could not be found.
	 *
	 * @param quotationId the primary key of the quotation extra tameeni info
	 * @return the quotation extra tameeni info
	 * @throws NoSuchQuotationExtraTameeniInfoException if a quotation extra tameeni info with the primary key could not be found
	 */
	public static QuotationExtraTameeniInfo findByPrimaryKey(long quotationId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationExtraTameeniInfoException {

		return getPersistence().findByPrimaryKey(quotationId);
	}

	/**
	 * Returns the quotation extra tameeni info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quotationId the primary key of the quotation extra tameeni info
	 * @return the quotation extra tameeni info, or <code>null</code> if a quotation extra tameeni info with the primary key could not be found
	 */
	public static QuotationExtraTameeniInfo fetchByPrimaryKey(
		long quotationId) {

		return getPersistence().fetchByPrimaryKey(quotationId);
	}

	/**
	 * Returns all the quotation extra tameeni infos.
	 *
	 * @return the quotation extra tameeni infos
	 */
	public static List<QuotationExtraTameeniInfo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the quotation extra tameeni infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationExtraTameeniInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation extra tameeni infos
	 * @param end the upper bound of the range of quotation extra tameeni infos (not inclusive)
	 * @return the range of quotation extra tameeni infos
	 */
	public static List<QuotationExtraTameeniInfo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the quotation extra tameeni infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationExtraTameeniInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation extra tameeni infos
	 * @param end the upper bound of the range of quotation extra tameeni infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotation extra tameeni infos
	 */
	public static List<QuotationExtraTameeniInfo> findAll(
		int start, int end,
		OrderByComparator<QuotationExtraTameeniInfo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the quotation extra tameeni infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationExtraTameeniInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation extra tameeni infos
	 * @param end the upper bound of the range of quotation extra tameeni infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotation extra tameeni infos
	 */
	public static List<QuotationExtraTameeniInfo> findAll(
		int start, int end,
		OrderByComparator<QuotationExtraTameeniInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the quotation extra tameeni infos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of quotation extra tameeni infos.
	 *
	 * @return the number of quotation extra tameeni infos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QuotationExtraTameeniInfoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QuotationExtraTameeniInfoPersistence,
		 QuotationExtraTameeniInfoPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			QuotationExtraTameeniInfoPersistence.class);

		ServiceTracker
			<QuotationExtraTameeniInfoPersistence,
			 QuotationExtraTameeniInfoPersistence> serviceTracker =
				new ServiceTracker
					<QuotationExtraTameeniInfoPersistence,
					 QuotationExtraTameeniInfoPersistence>(
						 bundle.getBundleContext(),
						 QuotationExtraTameeniInfoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}