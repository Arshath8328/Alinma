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
 * Provides a wrapper for {@link CompDiscountLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CompDiscountLocalService
 * @generated
 */
public class CompDiscountLocalServiceWrapper
	implements CompDiscountLocalService,
			   ServiceWrapper<CompDiscountLocalService> {

	public CompDiscountLocalServiceWrapper(
		CompDiscountLocalService compDiscountLocalService) {

		_compDiscountLocalService = compDiscountLocalService;
	}

	/**
	 * Adds the comp discount to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompDiscountLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param compDiscount the comp discount
	 * @return the comp discount that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CompDiscount addCompDiscount(
		com.ejada.atmc.acl.db.model.CompDiscount compDiscount) {

		return _compDiscountLocalService.addCompDiscount(compDiscount);
	}

	/**
	 * Creates a new comp discount with the primary key. Does not add the comp discount to the database.
	 *
	 * @param iqamaId the primary key for the new comp discount
	 * @return the new comp discount
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CompDiscount createCompDiscount(
		String iqamaId) {

		return _compDiscountLocalService.createCompDiscount(iqamaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _compDiscountLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the comp discount from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompDiscountLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param compDiscount the comp discount
	 * @return the comp discount that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CompDiscount deleteCompDiscount(
		com.ejada.atmc.acl.db.model.CompDiscount compDiscount) {

		return _compDiscountLocalService.deleteCompDiscount(compDiscount);
	}

	/**
	 * Deletes the comp discount with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompDiscountLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param iqamaId the primary key of the comp discount
	 * @return the comp discount that was removed
	 * @throws PortalException if a comp discount with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CompDiscount deleteCompDiscount(
			String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _compDiscountLocalService.deleteCompDiscount(iqamaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _compDiscountLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _compDiscountLocalService.dynamicQuery();
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

		return _compDiscountLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CompDiscountModelImpl</code>.
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

		return _compDiscountLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CompDiscountModelImpl</code>.
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

		return _compDiscountLocalService.dynamicQuery(
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

		return _compDiscountLocalService.dynamicQueryCount(dynamicQuery);
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

		return _compDiscountLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CompDiscount fetchCompDiscount(
		String iqamaId) {

		return _compDiscountLocalService.fetchCompDiscount(iqamaId);
	}

	/**
	 * Returns the comp discount with the primary key.
	 *
	 * @param iqamaId the primary key of the comp discount
	 * @return the comp discount
	 * @throws PortalException if a comp discount with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CompDiscount getCompDiscount(
			String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _compDiscountLocalService.getCompDiscount(iqamaId);
	}

	/**
	 * Returns a range of all the comp discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CompDiscountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comp discounts
	 * @param end the upper bound of the range of comp discounts (not inclusive)
	 * @return the range of comp discounts
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.CompDiscount>
		getCompDiscounts(int start, int end) {

		return _compDiscountLocalService.getCompDiscounts(start, end);
	}

	/**
	 * Returns the number of comp discounts.
	 *
	 * @return the number of comp discounts
	 */
	@Override
	public int getCompDiscountsCount() {
		return _compDiscountLocalService.getCompDiscountsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _compDiscountLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _compDiscountLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the comp discount in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompDiscountLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param compDiscount the comp discount
	 * @return the comp discount that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CompDiscount updateCompDiscount(
		com.ejada.atmc.acl.db.model.CompDiscount compDiscount) {

		return _compDiscountLocalService.updateCompDiscount(compDiscount);
	}

	@Override
	public CompDiscountLocalService getWrappedService() {
		return _compDiscountLocalService;
	}

	@Override
	public void setWrappedService(
		CompDiscountLocalService compDiscountLocalService) {

		_compDiscountLocalService = compDiscountLocalService;
	}

	private CompDiscountLocalService _compDiscountLocalService;

}