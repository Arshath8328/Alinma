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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CustomerIban. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.CustomerIbanLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CustomerIbanLocalService
 * @generated
 */
public class CustomerIbanLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.CustomerIbanLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static com.ejada.atmc.acl.db.model.CustomerIban addCustomerIban(
		com.ejada.atmc.acl.db.model.CustomerIban customerIban) {

		return getService().addCustomerIban(customerIban);
	}

	/**
	 * Creates a new customer iban with the primary key. Does not add the customer iban to the database.
	 *
	 * @param id the primary key for the new customer iban
	 * @return the new customer iban
	 */
	public static com.ejada.atmc.acl.db.model.CustomerIban createCustomerIban(
		String id) {

		return getService().createCustomerIban(id);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static com.ejada.atmc.acl.db.model.CustomerIban deleteCustomerIban(
		com.ejada.atmc.acl.db.model.CustomerIban customerIban) {

		return getService().deleteCustomerIban(customerIban);
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
	public static com.ejada.atmc.acl.db.model.CustomerIban deleteCustomerIban(
			String id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCustomerIban(id);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.ejada.atmc.acl.db.model.CustomerIban fetchCustomerIban(
		String id) {

		return getService().fetchCustomerIban(id);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.CustomerIban>
			findByCustomerIbanDetails(String id)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchAtmcYakeenMakeModelException {

		return getService().findByCustomerIbanDetails(id);
	}

	/**
	 * Returns the customer iban with the primary key.
	 *
	 * @param id the primary key of the customer iban
	 * @return the customer iban
	 * @throws PortalException if a customer iban with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.CustomerIban getCustomerIban(
			String id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCustomerIban(id);
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
	public static java.util.List<com.ejada.atmc.acl.db.model.CustomerIban>
		getCustomerIbans(int start, int end) {

		return getService().getCustomerIbans(start, end);
	}

	/**
	 * Returns the number of customer ibans.
	 *
	 * @return the number of customer ibans
	 */
	public static int getCustomerIbansCount() {
		return getService().getCustomerIbansCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static com.ejada.atmc.acl.db.model.CustomerIban updateCustomerIban(
		com.ejada.atmc.acl.db.model.CustomerIban customerIban) {

		return getService().updateCustomerIban(customerIban);
	}

	public static CustomerIbanLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CustomerIbanLocalService, CustomerIbanLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CustomerIbanLocalService.class);

		ServiceTracker<CustomerIbanLocalService, CustomerIbanLocalService>
			serviceTracker =
				new ServiceTracker
					<CustomerIbanLocalService, CustomerIbanLocalService>(
						bundle.getBundleContext(),
						CustomerIbanLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}