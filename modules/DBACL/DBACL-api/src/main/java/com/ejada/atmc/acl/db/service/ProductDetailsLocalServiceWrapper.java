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

package com.ejada.atmc.acl.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductDetailsLocalService
 * @generated
 */
public class ProductDetailsLocalServiceWrapper
	implements ProductDetailsLocalService,
			   ServiceWrapper<ProductDetailsLocalService> {

	public ProductDetailsLocalServiceWrapper(
		ProductDetailsLocalService productDetailsLocalService) {

		_productDetailsLocalService = productDetailsLocalService;
	}

	/**
	 * Adds the product details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productDetails the product details
	 * @return the product details that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ProductDetails addProductDetails(
		com.ejada.atmc.acl.db.model.ProductDetails productDetails) {

		return _productDetailsLocalService.addProductDetails(productDetails);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productDetailsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new product details with the primary key. Does not add the product details to the database.
	 *
	 * @param sysId the primary key for the new product details
	 * @return the new product details
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ProductDetails createProductDetails(
		long sysId) {

		return _productDetailsLocalService.createProductDetails(sysId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productDetailsLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the product details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sysId the primary key of the product details
	 * @return the product details that was removed
	 * @throws PortalException if a product details with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ProductDetails deleteProductDetails(
			long sysId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productDetailsLocalService.deleteProductDetails(sysId);
	}

	/**
	 * Deletes the product details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productDetails the product details
	 * @return the product details that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ProductDetails deleteProductDetails(
		com.ejada.atmc.acl.db.model.ProductDetails productDetails) {

		return _productDetailsLocalService.deleteProductDetails(productDetails);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productDetailsLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _productDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ProductDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _productDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ProductDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _productDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _productDetailsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _productDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.ProductDetails fetchProductDetails(
		long sysId) {

		return _productDetailsLocalService.fetchProductDetails(sysId);
	}

	@Override
	public com.ejada.atmc.acl.db.model.ProductDetails findByProductCode(
			String productCode)
		throws com.ejada.atmc.acl.db.exception.NoSuchProductDetailsException {

		return _productDetailsLocalService.findByProductCode(productCode);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productDetailsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the product details with the primary key.
	 *
	 * @param sysId the primary key of the product details
	 * @return the product details
	 * @throws PortalException if a product details with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ProductDetails getProductDetails(
			long sysId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productDetailsLocalService.getProductDetails(sysId);
	}

	/**
	 * Returns a range of all the product detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ProductDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product detailses
	 * @param end the upper bound of the range of product detailses (not inclusive)
	 * @return the range of product detailses
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.ProductDetails>
		getProductDetailses(int start, int end) {

		return _productDetailsLocalService.getProductDetailses(start, end);
	}

	/**
	 * Returns the number of product detailses.
	 *
	 * @return the number of product detailses
	 */
	@Override
	public int getProductDetailsesCount() {
		return _productDetailsLocalService.getProductDetailsesCount();
	}

	/**
	 * Updates the product details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productDetails the product details
	 * @return the product details that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ProductDetails updateProductDetails(
		com.ejada.atmc.acl.db.model.ProductDetails productDetails) {

		return _productDetailsLocalService.updateProductDetails(productDetails);
	}

	@Override
	public ProductDetailsLocalService getWrappedService() {
		return _productDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		ProductDetailsLocalService productDetailsLocalService) {

		_productDetailsLocalService = productDetailsLocalService;
	}

	private ProductDetailsLocalService _productDetailsLocalService;

}