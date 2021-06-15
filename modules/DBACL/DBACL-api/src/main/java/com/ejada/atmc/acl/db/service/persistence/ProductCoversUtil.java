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

import com.ejada.atmc.acl.db.model.ProductCovers;

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
 * The persistence utility for the product covers service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.ProductCoversPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductCoversPersistence
 * @generated
 */
public class ProductCoversUtil {

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
	public static void clearCache(ProductCovers productCovers) {
		getPersistence().clearCache(productCovers);
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
	public static Map<Serializable, ProductCovers> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductCovers> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductCovers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductCovers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductCovers> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductCovers update(ProductCovers productCovers) {
		return getPersistence().update(productCovers);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductCovers update(
		ProductCovers productCovers, ServiceContext serviceContext) {

		return getPersistence().update(productCovers, serviceContext);
	}

	/**
	 * Returns all the product coverses where coverCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @return the matching product coverses
	 */
	public static List<ProductCovers> findByCoverCode(String coverCode) {
		return getPersistence().findByCoverCode(coverCode);
	}

	/**
	 * Returns a range of all the product coverses where coverCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param coverCode the cover code
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @return the range of matching product coverses
	 */
	public static List<ProductCovers> findByCoverCode(
		String coverCode, int start, int end) {

		return getPersistence().findByCoverCode(coverCode, start, end);
	}

	/**
	 * Returns an ordered range of all the product coverses where coverCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param coverCode the cover code
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product coverses
	 */
	public static List<ProductCovers> findByCoverCode(
		String coverCode, int start, int end,
		OrderByComparator<ProductCovers> orderByComparator) {

		return getPersistence().findByCoverCode(
			coverCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product coverses where coverCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param coverCode the cover code
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product coverses
	 */
	public static List<ProductCovers> findByCoverCode(
		String coverCode, int start, int end,
		OrderByComparator<ProductCovers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCoverCode(
			coverCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product covers in the ordered set where coverCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product covers
	 * @throws NoSuchProductCoversException if a matching product covers could not be found
	 */
	public static ProductCovers findByCoverCode_First(
			String coverCode,
			OrderByComparator<ProductCovers> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchProductCoversException {

		return getPersistence().findByCoverCode_First(
			coverCode, orderByComparator);
	}

	/**
	 * Returns the first product covers in the ordered set where coverCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product covers, or <code>null</code> if a matching product covers could not be found
	 */
	public static ProductCovers fetchByCoverCode_First(
		String coverCode, OrderByComparator<ProductCovers> orderByComparator) {

		return getPersistence().fetchByCoverCode_First(
			coverCode, orderByComparator);
	}

	/**
	 * Returns the last product covers in the ordered set where coverCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product covers
	 * @throws NoSuchProductCoversException if a matching product covers could not be found
	 */
	public static ProductCovers findByCoverCode_Last(
			String coverCode,
			OrderByComparator<ProductCovers> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchProductCoversException {

		return getPersistence().findByCoverCode_Last(
			coverCode, orderByComparator);
	}

	/**
	 * Returns the last product covers in the ordered set where coverCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product covers, or <code>null</code> if a matching product covers could not be found
	 */
	public static ProductCovers fetchByCoverCode_Last(
		String coverCode, OrderByComparator<ProductCovers> orderByComparator) {

		return getPersistence().fetchByCoverCode_Last(
			coverCode, orderByComparator);
	}

	/**
	 * Returns the product coverses before and after the current product covers in the ordered set where coverCode = &#63;.
	 *
	 * @param productCoversPK the primary key of the current product covers
	 * @param coverCode the cover code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product covers
	 * @throws NoSuchProductCoversException if a product covers with the primary key could not be found
	 */
	public static ProductCovers[] findByCoverCode_PrevAndNext(
			ProductCoversPK productCoversPK, String coverCode,
			OrderByComparator<ProductCovers> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchProductCoversException {

		return getPersistence().findByCoverCode_PrevAndNext(
			productCoversPK, coverCode, orderByComparator);
	}

	/**
	 * Removes all the product coverses where coverCode = &#63; from the database.
	 *
	 * @param coverCode the cover code
	 */
	public static void removeByCoverCode(String coverCode) {
		getPersistence().removeByCoverCode(coverCode);
	}

	/**
	 * Returns the number of product coverses where coverCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @return the number of matching product coverses
	 */
	public static int countByCoverCode(String coverCode) {
		return getPersistence().countByCoverCode(coverCode);
	}

	/**
	 * Returns all the product coverses where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @return the matching product coverses
	 */
	public static List<ProductCovers> findByProductCode(long productCode) {
		return getPersistence().findByProductCode(productCode);
	}

	/**
	 * Returns a range of all the product coverses where productCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param productCode the product code
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @return the range of matching product coverses
	 */
	public static List<ProductCovers> findByProductCode(
		long productCode, int start, int end) {

		return getPersistence().findByProductCode(productCode, start, end);
	}

	/**
	 * Returns an ordered range of all the product coverses where productCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param productCode the product code
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product coverses
	 */
	public static List<ProductCovers> findByProductCode(
		long productCode, int start, int end,
		OrderByComparator<ProductCovers> orderByComparator) {

		return getPersistence().findByProductCode(
			productCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product coverses where productCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param productCode the product code
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product coverses
	 */
	public static List<ProductCovers> findByProductCode(
		long productCode, int start, int end,
		OrderByComparator<ProductCovers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProductCode(
			productCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product covers in the ordered set where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product covers
	 * @throws NoSuchProductCoversException if a matching product covers could not be found
	 */
	public static ProductCovers findByProductCode_First(
			long productCode,
			OrderByComparator<ProductCovers> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchProductCoversException {

		return getPersistence().findByProductCode_First(
			productCode, orderByComparator);
	}

	/**
	 * Returns the first product covers in the ordered set where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product covers, or <code>null</code> if a matching product covers could not be found
	 */
	public static ProductCovers fetchByProductCode_First(
		long productCode, OrderByComparator<ProductCovers> orderByComparator) {

		return getPersistence().fetchByProductCode_First(
			productCode, orderByComparator);
	}

	/**
	 * Returns the last product covers in the ordered set where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product covers
	 * @throws NoSuchProductCoversException if a matching product covers could not be found
	 */
	public static ProductCovers findByProductCode_Last(
			long productCode,
			OrderByComparator<ProductCovers> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchProductCoversException {

		return getPersistence().findByProductCode_Last(
			productCode, orderByComparator);
	}

	/**
	 * Returns the last product covers in the ordered set where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product covers, or <code>null</code> if a matching product covers could not be found
	 */
	public static ProductCovers fetchByProductCode_Last(
		long productCode, OrderByComparator<ProductCovers> orderByComparator) {

		return getPersistence().fetchByProductCode_Last(
			productCode, orderByComparator);
	}

	/**
	 * Returns the product coverses before and after the current product covers in the ordered set where productCode = &#63;.
	 *
	 * @param productCoversPK the primary key of the current product covers
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product covers
	 * @throws NoSuchProductCoversException if a product covers with the primary key could not be found
	 */
	public static ProductCovers[] findByProductCode_PrevAndNext(
			ProductCoversPK productCoversPK, long productCode,
			OrderByComparator<ProductCovers> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchProductCoversException {

		return getPersistence().findByProductCode_PrevAndNext(
			productCoversPK, productCode, orderByComparator);
	}

	/**
	 * Removes all the product coverses where productCode = &#63; from the database.
	 *
	 * @param productCode the product code
	 */
	public static void removeByProductCode(long productCode) {
		getPersistence().removeByProductCode(productCode);
	}

	/**
	 * Returns the number of product coverses where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @return the number of matching product coverses
	 */
	public static int countByProductCode(long productCode) {
		return getPersistence().countByProductCode(productCode);
	}

	/**
	 * Returns all the product coverses where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @return the matching product coverses
	 */
	public static List<ProductCovers> findByCoverCodeProductCode(
		String coverCode, long productCode) {

		return getPersistence().findByCoverCodeProductCode(
			coverCode, productCode);
	}

	/**
	 * Returns a range of all the product coverses where coverCode = &#63; and productCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @return the range of matching product coverses
	 */
	public static List<ProductCovers> findByCoverCodeProductCode(
		String coverCode, long productCode, int start, int end) {

		return getPersistence().findByCoverCodeProductCode(
			coverCode, productCode, start, end);
	}

	/**
	 * Returns an ordered range of all the product coverses where coverCode = &#63; and productCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product coverses
	 */
	public static List<ProductCovers> findByCoverCodeProductCode(
		String coverCode, long productCode, int start, int end,
		OrderByComparator<ProductCovers> orderByComparator) {

		return getPersistence().findByCoverCodeProductCode(
			coverCode, productCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product coverses where coverCode = &#63; and productCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product coverses
	 */
	public static List<ProductCovers> findByCoverCodeProductCode(
		String coverCode, long productCode, int start, int end,
		OrderByComparator<ProductCovers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCoverCodeProductCode(
			coverCode, productCode, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first product covers in the ordered set where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product covers
	 * @throws NoSuchProductCoversException if a matching product covers could not be found
	 */
	public static ProductCovers findByCoverCodeProductCode_First(
			String coverCode, long productCode,
			OrderByComparator<ProductCovers> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchProductCoversException {

		return getPersistence().findByCoverCodeProductCode_First(
			coverCode, productCode, orderByComparator);
	}

	/**
	 * Returns the first product covers in the ordered set where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product covers, or <code>null</code> if a matching product covers could not be found
	 */
	public static ProductCovers fetchByCoverCodeProductCode_First(
		String coverCode, long productCode,
		OrderByComparator<ProductCovers> orderByComparator) {

		return getPersistence().fetchByCoverCodeProductCode_First(
			coverCode, productCode, orderByComparator);
	}

	/**
	 * Returns the last product covers in the ordered set where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product covers
	 * @throws NoSuchProductCoversException if a matching product covers could not be found
	 */
	public static ProductCovers findByCoverCodeProductCode_Last(
			String coverCode, long productCode,
			OrderByComparator<ProductCovers> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchProductCoversException {

		return getPersistence().findByCoverCodeProductCode_Last(
			coverCode, productCode, orderByComparator);
	}

	/**
	 * Returns the last product covers in the ordered set where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product covers, or <code>null</code> if a matching product covers could not be found
	 */
	public static ProductCovers fetchByCoverCodeProductCode_Last(
		String coverCode, long productCode,
		OrderByComparator<ProductCovers> orderByComparator) {

		return getPersistence().fetchByCoverCodeProductCode_Last(
			coverCode, productCode, orderByComparator);
	}

	/**
	 * Returns the product coverses before and after the current product covers in the ordered set where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param productCoversPK the primary key of the current product covers
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product covers
	 * @throws NoSuchProductCoversException if a product covers with the primary key could not be found
	 */
	public static ProductCovers[] findByCoverCodeProductCode_PrevAndNext(
			ProductCoversPK productCoversPK, String coverCode, long productCode,
			OrderByComparator<ProductCovers> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchProductCoversException {

		return getPersistence().findByCoverCodeProductCode_PrevAndNext(
			productCoversPK, coverCode, productCode, orderByComparator);
	}

	/**
	 * Removes all the product coverses where coverCode = &#63; and productCode = &#63; from the database.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 */
	public static void removeByCoverCodeProductCode(
		String coverCode, long productCode) {

		getPersistence().removeByCoverCodeProductCode(coverCode, productCode);
	}

	/**
	 * Returns the number of product coverses where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @return the number of matching product coverses
	 */
	public static int countByCoverCodeProductCode(
		String coverCode, long productCode) {

		return getPersistence().countByCoverCodeProductCode(
			coverCode, productCode);
	}

	/**
	 * Caches the product covers in the entity cache if it is enabled.
	 *
	 * @param productCovers the product covers
	 */
	public static void cacheResult(ProductCovers productCovers) {
		getPersistence().cacheResult(productCovers);
	}

	/**
	 * Caches the product coverses in the entity cache if it is enabled.
	 *
	 * @param productCoverses the product coverses
	 */
	public static void cacheResult(List<ProductCovers> productCoverses) {
		getPersistence().cacheResult(productCoverses);
	}

	/**
	 * Creates a new product covers with the primary key. Does not add the product covers to the database.
	 *
	 * @param productCoversPK the primary key for the new product covers
	 * @return the new product covers
	 */
	public static ProductCovers create(ProductCoversPK productCoversPK) {
		return getPersistence().create(productCoversPK);
	}

	/**
	 * Removes the product covers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productCoversPK the primary key of the product covers
	 * @return the product covers that was removed
	 * @throws NoSuchProductCoversException if a product covers with the primary key could not be found
	 */
	public static ProductCovers remove(ProductCoversPK productCoversPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchProductCoversException {

		return getPersistence().remove(productCoversPK);
	}

	public static ProductCovers updateImpl(ProductCovers productCovers) {
		return getPersistence().updateImpl(productCovers);
	}

	/**
	 * Returns the product covers with the primary key or throws a <code>NoSuchProductCoversException</code> if it could not be found.
	 *
	 * @param productCoversPK the primary key of the product covers
	 * @return the product covers
	 * @throws NoSuchProductCoversException if a product covers with the primary key could not be found
	 */
	public static ProductCovers findByPrimaryKey(
			ProductCoversPK productCoversPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchProductCoversException {

		return getPersistence().findByPrimaryKey(productCoversPK);
	}

	/**
	 * Returns the product covers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productCoversPK the primary key of the product covers
	 * @return the product covers, or <code>null</code> if a product covers with the primary key could not be found
	 */
	public static ProductCovers fetchByPrimaryKey(
		ProductCoversPK productCoversPK) {

		return getPersistence().fetchByPrimaryKey(productCoversPK);
	}

	/**
	 * Returns all the product coverses.
	 *
	 * @return the product coverses
	 */
	public static List<ProductCovers> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the product coverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @return the range of product coverses
	 */
	public static List<ProductCovers> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the product coverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product coverses
	 */
	public static List<ProductCovers> findAll(
		int start, int end,
		OrderByComparator<ProductCovers> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product coverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product coverses
	 */
	public static List<ProductCovers> findAll(
		int start, int end, OrderByComparator<ProductCovers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the product coverses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of product coverses.
	 *
	 * @return the number of product coverses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static ProductCoversPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ProductCoversPersistence, ProductCoversPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProductCoversPersistence.class);

		ServiceTracker<ProductCoversPersistence, ProductCoversPersistence>
			serviceTracker =
				new ServiceTracker
					<ProductCoversPersistence, ProductCoversPersistence>(
						bundle.getBundleContext(),
						ProductCoversPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}