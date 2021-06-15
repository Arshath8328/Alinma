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
 * Provides a wrapper for {@link QuotationsUserAddressLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsUserAddressLocalService
 * @generated
 */
public class QuotationsUserAddressLocalServiceWrapper
	implements QuotationsUserAddressLocalService,
			   ServiceWrapper<QuotationsUserAddressLocalService> {

	public QuotationsUserAddressLocalServiceWrapper(
		QuotationsUserAddressLocalService quotationsUserAddressLocalService) {

		_quotationsUserAddressLocalService = quotationsUserAddressLocalService;
	}

	/**
	 * Adds the quotations user address to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsUserAddressLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsUserAddress the quotations user address
	 * @return the quotations user address that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsUserAddress
		addQuotationsUserAddress(
			com.ejada.atmc.acl.db.model.QuotationsUserAddress
				quotationsUserAddress) {

		return _quotationsUserAddressLocalService.addQuotationsUserAddress(
			quotationsUserAddress);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsUserAddressLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new quotations user address with the primary key. Does not add the quotations user address to the database.
	 *
	 * @param userAddressId the primary key for the new quotations user address
	 * @return the new quotations user address
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsUserAddress
		createQuotationsUserAddress(long userAddressId) {

		return _quotationsUserAddressLocalService.createQuotationsUserAddress(
			userAddressId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsUserAddressLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the quotations user address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsUserAddressLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userAddressId the primary key of the quotations user address
	 * @return the quotations user address that was removed
	 * @throws PortalException if a quotations user address with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsUserAddress
			deleteQuotationsUserAddress(long userAddressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsUserAddressLocalService.deleteQuotationsUserAddress(
			userAddressId);
	}

	/**
	 * Deletes the quotations user address from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsUserAddressLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsUserAddress the quotations user address
	 * @return the quotations user address that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsUserAddress
		deleteQuotationsUserAddress(
			com.ejada.atmc.acl.db.model.QuotationsUserAddress
				quotationsUserAddress) {

		return _quotationsUserAddressLocalService.deleteQuotationsUserAddress(
			quotationsUserAddress);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _quotationsUserAddressLocalService.dynamicQuery();
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

		return _quotationsUserAddressLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsUserAddressModelImpl</code>.
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

		return _quotationsUserAddressLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsUserAddressModelImpl</code>.
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

		return _quotationsUserAddressLocalService.dynamicQuery(
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

		return _quotationsUserAddressLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _quotationsUserAddressLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.QuotationsUserAddress
		fetchQuotationsUserAddress(long userAddressId) {

		return _quotationsUserAddressLocalService.fetchQuotationsUserAddress(
			userAddressId);
	}

	@Override
	public com.ejada.atmc.acl.db.model.QuotationsUserAddress
		findByQuotationIdDriverId(
			long quotationId, long driverId, boolean isNatAddress) {

		return _quotationsUserAddressLocalService.findByQuotationIdDriverId(
			quotationId, driverId, isNatAddress);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _quotationsUserAddressLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _quotationsUserAddressLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _quotationsUserAddressLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsUserAddressLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the quotations user address with the primary key.
	 *
	 * @param userAddressId the primary key of the quotations user address
	 * @return the quotations user address
	 * @throws PortalException if a quotations user address with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsUserAddress
			getQuotationsUserAddress(long userAddressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsUserAddressLocalService.getQuotationsUserAddress(
			userAddressId);
	}

	/**
	 * Returns a range of all the quotations user addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsUserAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations user addresses
	 * @param end the upper bound of the range of quotations user addresses (not inclusive)
	 * @return the range of quotations user addresses
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.QuotationsUserAddress>
		getQuotationsUserAddresses(int start, int end) {

		return _quotationsUserAddressLocalService.getQuotationsUserAddresses(
			start, end);
	}

	/**
	 * Returns the number of quotations user addresses.
	 *
	 * @return the number of quotations user addresses
	 */
	@Override
	public int getQuotationsUserAddressesCount() {
		return _quotationsUserAddressLocalService.
			getQuotationsUserAddressesCount();
	}

	/**
	 * Updates the quotations user address in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsUserAddressLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsUserAddress the quotations user address
	 * @return the quotations user address that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsUserAddress
		updateQuotationsUserAddress(
			com.ejada.atmc.acl.db.model.QuotationsUserAddress
				quotationsUserAddress) {

		return _quotationsUserAddressLocalService.updateQuotationsUserAddress(
			quotationsUserAddress);
	}

	@Override
	public QuotationsUserAddressLocalService getWrappedService() {
		return _quotationsUserAddressLocalService;
	}

	@Override
	public void setWrappedService(
		QuotationsUserAddressLocalService quotationsUserAddressLocalService) {

		_quotationsUserAddressLocalService = quotationsUserAddressLocalService;
	}

	private QuotationsUserAddressLocalService
		_quotationsUserAddressLocalService;

}