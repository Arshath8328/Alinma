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

import com.ejada.atmc.acl.db.model.ProductDetails;

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
 * The persistence utility for the product details service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.ProductDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductDetailsPersistence
 * @generated
 */
public class ProductDetailsUtil {

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
	public static void clearCache(ProductDetails productDetails) {
		getPersistence().clearCache(productDetails);
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
	public static Map<Serializable, ProductDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductDetails update(ProductDetails productDetails) {
		return getPersistence().update(productDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductDetails update(
		ProductDetails productDetails, ServiceContext serviceContext) {

		return getPersistence().update(productDetails, serviceContext);
	}

	/**
	 * Returns the product details where productCode = &#63; or throws a <code>NoSuchProductDetailsException</code> if it could not be found.
	 *
	 * @param productCode the product code
	 * @return the matching product details
	 * @throws NoSuchProductDetailsException if a matching product details could not be found
	 */
	public static ProductDetails findByProductCode(String productCode)
		throws com.ejada.atmc.acl.db.exception.NoSuchProductDetailsException {

		return getPersistence().findByProductCode(productCode);
	}

	/**
	 * Returns the product details where productCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productCode the product code
	 * @return the matching product details, or <code>null</code> if a matching product details could not be found
	 */
	public static ProductDetails fetchByProductCode(String productCode) {
		return getPersistence().fetchByProductCode(productCode);
	}

	/**
	 * Returns the product details where productCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productCode the product code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product details, or <code>null</code> if a matching product details could not be found
	 */
	public static ProductDetails fetchByProductCode(
		String productCode, boolean useFinderCache) {

		return getPersistence().fetchByProductCode(productCode, useFinderCache);
	}

	/**
	 * Removes the product details where productCode = &#63; from the database.
	 *
	 * @param productCode the product code
	 * @return the product details that was removed
	 */
	public static ProductDetails removeByProductCode(String productCode)
		throws com.ejada.atmc.acl.db.exception.NoSuchProductDetailsException {

		return getPersistence().removeByProductCode(productCode);
	}

	/**
	 * Returns the number of product detailses where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @return the number of matching product detailses
	 */
	public static int countByProductCode(String productCode) {
		return getPersistence().countByProductCode(productCode);
	}

	/**
	 * Caches the product details in the entity cache if it is enabled.
	 *
	 * @param productDetails the product details
	 */
	public static void cacheResult(ProductDetails productDetails) {
		getPersistence().cacheResult(productDetails);
	}

	/**
	 * Caches the product detailses in the entity cache if it is enabled.
	 *
	 * @param productDetailses the product detailses
	 */
	public static void cacheResult(List<ProductDetails> productDetailses) {
		getPersistence().cacheResult(productDetailses);
	}

	/**
	 * Creates a new product details with the primary key. Does not add the product details to the database.
	 *
	 * @param sysId the primary key for the new product details
	 * @return the new product details
	 */
	public static ProductDetails create(long sysId) {
		return getPersistence().create(sysId);
	}

	/**
	 * Removes the product details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sysId the primary key of the product details
	 * @return the product details that was removed
	 * @throws NoSuchProductDetailsException if a product details with the primary key could not be found
	 */
	public static ProductDetails remove(long sysId)
		throws com.ejada.atmc.acl.db.exception.NoSuchProductDetailsException {

		return getPersistence().remove(sysId);
	}

	public static ProductDetails updateImpl(ProductDetails productDetails) {
		return getPersistence().updateImpl(productDetails);
	}

	/**
	 * Returns the product details with the primary key or throws a <code>NoSuchProductDetailsException</code> if it could not be found.
	 *
	 * @param sysId the primary key of the product details
	 * @return the product details
	 * @throws NoSuchProductDetailsException if a product details with the primary key could not be found
	 */
	public static ProductDetails findByPrimaryKey(long sysId)
		throws com.ejada.atmc.acl.db.exception.NoSuchProductDetailsException {

		return getPersistence().findByPrimaryKey(sysId);
	}

	/**
	 * Returns the product details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sysId the primary key of the product details
	 * @return the product details, or <code>null</code> if a product details with the primary key could not be found
	 */
	public static ProductDetails fetchByPrimaryKey(long sysId) {
		return getPersistence().fetchByPrimaryKey(sysId);
	}

	/**
	 * Returns all the product detailses.
	 *
	 * @return the product detailses
	 */
	public static List<ProductDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the product detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product detailses
	 * @param end the upper bound of the range of product detailses (not inclusive)
	 * @return the range of product detailses
	 */
	public static List<ProductDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the product detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product detailses
	 * @param end the upper bound of the range of product detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product detailses
	 */
	public static List<ProductDetails> findAll(
		int start, int end,
		OrderByComparator<ProductDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product detailses
	 * @param end the upper bound of the range of product detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product detailses
	 */
	public static List<ProductDetails> findAll(
		int start, int end, OrderByComparator<ProductDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the product detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of product detailses.
	 *
	 * @return the number of product detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProductDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ProductDetailsPersistence, ProductDetailsPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ProductDetailsPersistence.class);

		ServiceTracker<ProductDetailsPersistence, ProductDetailsPersistence>
			serviceTracker =
				new ServiceTracker
					<ProductDetailsPersistence, ProductDetailsPersistence>(
						bundle.getBundleContext(),
						ProductDetailsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}