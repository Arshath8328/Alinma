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
 * Provides a wrapper for {@link ProductCoversLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductCoversLocalService
 * @generated
 */
public class ProductCoversLocalServiceWrapper
	implements ProductCoversLocalService,
			   ServiceWrapper<ProductCoversLocalService> {

	public ProductCoversLocalServiceWrapper(
		ProductCoversLocalService productCoversLocalService) {

		_productCoversLocalService = productCoversLocalService;
	}

	/**
	 * Adds the product covers to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductCoversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productCovers the product covers
	 * @return the product covers that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ProductCovers addProductCovers(
		com.ejada.atmc.acl.db.model.ProductCovers productCovers) {

		return _productCoversLocalService.addProductCovers(productCovers);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productCoversLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new product covers with the primary key. Does not add the product covers to the database.
	 *
	 * @param productCoversPK the primary key for the new product covers
	 * @return the new product covers
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ProductCovers createProductCovers(
		com.ejada.atmc.acl.db.service.persistence.ProductCoversPK
			productCoversPK) {

		return _productCoversLocalService.createProductCovers(productCoversPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productCoversLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the product covers from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductCoversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productCovers the product covers
	 * @return the product covers that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ProductCovers deleteProductCovers(
		com.ejada.atmc.acl.db.model.ProductCovers productCovers) {

		return _productCoversLocalService.deleteProductCovers(productCovers);
	}

	/**
	 * Deletes the product covers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductCoversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productCoversPK the primary key of the product covers
	 * @return the product covers that was removed
	 * @throws PortalException if a product covers with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ProductCovers deleteProductCovers(
			com.ejada.atmc.acl.db.service.persistence.ProductCoversPK
				productCoversPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productCoversLocalService.deleteProductCovers(productCoversPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productCoversLocalService.dynamicQuery();
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

		return _productCoversLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ProductCoversModelImpl</code>.
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

		return _productCoversLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ProductCoversModelImpl</code>.
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

		return _productCoversLocalService.dynamicQuery(
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

		return _productCoversLocalService.dynamicQueryCount(dynamicQuery);
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

		return _productCoversLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.ProductCovers fetchProductCovers(
		com.ejada.atmc.acl.db.service.persistence.ProductCoversPK
			productCoversPK) {

		return _productCoversLocalService.fetchProductCovers(productCoversPK);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.ProductCovers>
		findByCoverCode(String coverCode) {

		return _productCoversLocalService.findByCoverCode(coverCode);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.ProductCovers>
		findByCoverCodeProductCode(String coverCode, long productCode) {

		return _productCoversLocalService.findByCoverCodeProductCode(
			coverCode, productCode);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.ProductCovers>
		findByProductCode(long productCode) {

		return _productCoversLocalService.findByProductCode(productCode);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productCoversLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productCoversLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productCoversLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productCoversLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the product covers with the primary key.
	 *
	 * @param productCoversPK the primary key of the product covers
	 * @return the product covers
	 * @throws PortalException if a product covers with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ProductCovers getProductCovers(
			com.ejada.atmc.acl.db.service.persistence.ProductCoversPK
				productCoversPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productCoversLocalService.getProductCovers(productCoversPK);
	}

	/**
	 * Returns a range of all the product coverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @return the range of product coverses
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.ProductCovers>
		getProductCoverses(int start, int end) {

		return _productCoversLocalService.getProductCoverses(start, end);
	}

	/**
	 * Returns the number of product coverses.
	 *
	 * @return the number of product coverses
	 */
	@Override
	public int getProductCoversesCount() {
		return _productCoversLocalService.getProductCoversesCount();
	}

	/**
	 * Updates the product covers in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductCoversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productCovers the product covers
	 * @return the product covers that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ProductCovers updateProductCovers(
		com.ejada.atmc.acl.db.model.ProductCovers productCovers) {

		return _productCoversLocalService.updateProductCovers(productCovers);
	}

	@Override
	public ProductCoversLocalService getWrappedService() {
		return _productCoversLocalService;
	}

	@Override
	public void setWrappedService(
		ProductCoversLocalService productCoversLocalService) {

		_productCoversLocalService = productCoversLocalService;
	}

	private ProductCoversLocalService _productCoversLocalService;

}