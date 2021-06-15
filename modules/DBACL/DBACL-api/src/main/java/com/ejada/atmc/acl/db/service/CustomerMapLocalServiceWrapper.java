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
 * Provides a wrapper for {@link CustomerMapLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CustomerMapLocalService
 * @generated
 */
public class CustomerMapLocalServiceWrapper
	implements CustomerMapLocalService,
			   ServiceWrapper<CustomerMapLocalService> {

	public CustomerMapLocalServiceWrapper(
		CustomerMapLocalService customerMapLocalService) {

		_customerMapLocalService = customerMapLocalService;
	}

	/**
	 * Adds the customer map to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customerMap the customer map
	 * @return the customer map that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CustomerMap addCustomerMap(
		com.ejada.atmc.acl.db.model.CustomerMap customerMap) {

		return _customerMapLocalService.addCustomerMap(customerMap);
	}

	/**
	 * Creates a new customer map with the primary key. Does not add the customer map to the database.
	 *
	 * @param refCode the primary key for the new customer map
	 * @return the new customer map
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CustomerMap createCustomerMap(
		String refCode) {

		return _customerMapLocalService.createCustomerMap(refCode);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customerMapLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the customer map from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customerMap the customer map
	 * @return the customer map that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CustomerMap deleteCustomerMap(
		com.ejada.atmc.acl.db.model.CustomerMap customerMap) {

		return _customerMapLocalService.deleteCustomerMap(customerMap);
	}

	/**
	 * Deletes the customer map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param refCode the primary key of the customer map
	 * @return the customer map that was removed
	 * @throws PortalException if a customer map with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CustomerMap deleteCustomerMap(
			String refCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customerMapLocalService.deleteCustomerMap(refCode);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customerMapLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _customerMapLocalService.dynamicQuery();
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

		return _customerMapLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CustomerMapModelImpl</code>.
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

		return _customerMapLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CustomerMapModelImpl</code>.
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

		return _customerMapLocalService.dynamicQuery(
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

		return _customerMapLocalService.dynamicQueryCount(dynamicQuery);
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

		return _customerMapLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CustomerMap fetchCustomerMap(
		String refCode) {

		return _customerMapLocalService.fetchCustomerMap(refCode);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.CustomerMap>
		findByCustCatgAndType(String custCatg, String custType) {

		return _customerMapLocalService.findByCustCatgAndType(
			custCatg, custType);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.CustomerMap>
		findByCustCatgTypeCode(
			String custCatg, String custType, String premiaCode) {

		return _customerMapLocalService.findByCustCatgTypeCode(
			custCatg, custType, premiaCode);
	}

	/**
	 * Returns the customer map with the primary key.
	 *
	 * @param refCode the primary key of the customer map
	 * @return the customer map
	 * @throws PortalException if a customer map with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CustomerMap getCustomerMap(
			String refCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customerMapLocalService.getCustomerMap(refCode);
	}

	/**
	 * Returns a range of all the customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CustomerMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer maps
	 * @param end the upper bound of the range of customer maps (not inclusive)
	 * @return the range of customer maps
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.CustomerMap>
		getCustomerMaps(int start, int end) {

		return _customerMapLocalService.getCustomerMaps(start, end);
	}

	/**
	 * Returns the number of customer maps.
	 *
	 * @return the number of customer maps
	 */
	@Override
	public int getCustomerMapsCount() {
		return _customerMapLocalService.getCustomerMapsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _customerMapLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customerMapLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the customer map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customerMap the customer map
	 * @return the customer map that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CustomerMap updateCustomerMap(
		com.ejada.atmc.acl.db.model.CustomerMap customerMap) {

		return _customerMapLocalService.updateCustomerMap(customerMap);
	}

	@Override
	public CustomerMapLocalService getWrappedService() {
		return _customerMapLocalService;
	}

	@Override
	public void setWrappedService(
		CustomerMapLocalService customerMapLocalService) {

		_customerMapLocalService = customerMapLocalService;
	}

	private CustomerMapLocalService _customerMapLocalService;

}