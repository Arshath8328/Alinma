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
 * Provides a wrapper for {@link CustomerIbanLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CustomerIbanLocalService
 * @generated
 */
public class CustomerIbanLocalServiceWrapper
	implements CustomerIbanLocalService,
			   ServiceWrapper<CustomerIbanLocalService> {

	public CustomerIbanLocalServiceWrapper(
		CustomerIbanLocalService customerIbanLocalService) {

		_customerIbanLocalService = customerIbanLocalService;
	}

	/**
	 * Adds the customer iban to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerIbanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customerIban the customer iban
	 * @return the customer iban that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CustomerIban addCustomerIban(
		com.ejada.atmc.acl.db.model.CustomerIban customerIban) {

		return _customerIbanLocalService.addCustomerIban(customerIban);
	}

	/**
	 * Creates a new customer iban with the primary key. Does not add the customer iban to the database.
	 *
	 * @param id the primary key for the new customer iban
	 * @return the new customer iban
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CustomerIban createCustomerIban(
		String id) {

		return _customerIbanLocalService.createCustomerIban(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customerIbanLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the customer iban from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerIbanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customerIban the customer iban
	 * @return the customer iban that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CustomerIban deleteCustomerIban(
		com.ejada.atmc.acl.db.model.CustomerIban customerIban) {

		return _customerIbanLocalService.deleteCustomerIban(customerIban);
	}

	/**
	 * Deletes the customer iban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerIbanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the customer iban
	 * @return the customer iban that was removed
	 * @throws PortalException if a customer iban with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CustomerIban deleteCustomerIban(
			String id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customerIbanLocalService.deleteCustomerIban(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customerIbanLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _customerIbanLocalService.dynamicQuery();
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

		return _customerIbanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CustomerIbanModelImpl</code>.
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

		return _customerIbanLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CustomerIbanModelImpl</code>.
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

		return _customerIbanLocalService.dynamicQuery(
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

		return _customerIbanLocalService.dynamicQueryCount(dynamicQuery);
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

		return _customerIbanLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CustomerIban fetchCustomerIban(
		String id) {

		return _customerIbanLocalService.fetchCustomerIban(id);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.CustomerIban>
			findByCustomerIbanDetails(String id)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchAtmcYakeenMakeModelException {

		return _customerIbanLocalService.findByCustomerIbanDetails(id);
	}

	/**
	 * Returns the customer iban with the primary key.
	 *
	 * @param id the primary key of the customer iban
	 * @return the customer iban
	 * @throws PortalException if a customer iban with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CustomerIban getCustomerIban(String id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customerIbanLocalService.getCustomerIban(id);
	}

	/**
	 * Returns a range of all the customer ibans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CustomerIbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer ibans
	 * @param end the upper bound of the range of customer ibans (not inclusive)
	 * @return the range of customer ibans
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.CustomerIban>
		getCustomerIbans(int start, int end) {

		return _customerIbanLocalService.getCustomerIbans(start, end);
	}

	/**
	 * Returns the number of customer ibans.
	 *
	 * @return the number of customer ibans
	 */
	@Override
	public int getCustomerIbansCount() {
		return _customerIbanLocalService.getCustomerIbansCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _customerIbanLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customerIbanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the customer iban in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerIbanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customerIban the customer iban
	 * @return the customer iban that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CustomerIban updateCustomerIban(
		com.ejada.atmc.acl.db.model.CustomerIban customerIban) {

		return _customerIbanLocalService.updateCustomerIban(customerIban);
	}

	@Override
	public CustomerIbanLocalService getWrappedService() {
		return _customerIbanLocalService;
	}

	@Override
	public void setWrappedService(
		CustomerIbanLocalService customerIbanLocalService) {

		_customerIbanLocalService = customerIbanLocalService;
	}

	private CustomerIbanLocalService _customerIbanLocalService;

}