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
 * Provides the local service utility for ServiceRequestHistory. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.ServiceRequestHistoryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestHistoryLocalService
 * @generated
 */
public class ServiceRequestHistoryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.ServiceRequestHistoryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the service request history to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestHistory the service request history
	 * @return the service request history that was added
	 */
	public static com.ejada.atmc.acl.db.model.ServiceRequestHistory
		addServiceRequestHistory(
			com.ejada.atmc.acl.db.model.ServiceRequestHistory
				serviceRequestHistory) {

		return getService().addServiceRequestHistory(serviceRequestHistory);
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
	 * Creates a new service request history with the primary key. Does not add the service request history to the database.
	 *
	 * @param ACTION_ID the primary key for the new service request history
	 * @return the new service request history
	 */
	public static com.ejada.atmc.acl.db.model.ServiceRequestHistory
		createServiceRequestHistory(long ACTION_ID) {

		return getService().createServiceRequestHistory(ACTION_ID);
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

	/**
	 * Deletes the service request history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ACTION_ID the primary key of the service request history
	 * @return the service request history that was removed
	 * @throws PortalException if a service request history with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.ServiceRequestHistory
			deleteServiceRequestHistory(long ACTION_ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteServiceRequestHistory(ACTION_ID);
	}

	/**
	 * Deletes the service request history from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestHistory the service request history
	 * @return the service request history that was removed
	 */
	public static com.ejada.atmc.acl.db.model.ServiceRequestHistory
		deleteServiceRequestHistory(
			com.ejada.atmc.acl.db.model.ServiceRequestHistory
				serviceRequestHistory) {

		return getService().deleteServiceRequestHistory(serviceRequestHistory);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ServiceRequestHistoryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ServiceRequestHistoryModelImpl</code>.
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

	public static com.ejada.atmc.acl.db.model.ServiceRequestHistory
		fetchServiceRequestHistory(long ACTION_ID) {

		return getService().fetchServiceRequestHistory(ACTION_ID);
	}

	public static java.util.List
		<com.ejada.atmc.acl.db.model.ServiceRequestHistory>
			findSrvReqHistoryByRefNo(String refNo) {

		return getService().findSrvReqHistoryByRefNo(refNo);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
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
	 * Returns a range of all the service request histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ServiceRequestHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request histories
	 * @param end the upper bound of the range of service request histories (not inclusive)
	 * @return the range of service request histories
	 */
	public static java.util.List
		<com.ejada.atmc.acl.db.model.ServiceRequestHistory>
			getServiceRequestHistories(int start, int end) {

		return getService().getServiceRequestHistories(start, end);
	}

	/**
	 * Returns the number of service request histories.
	 *
	 * @return the number of service request histories
	 */
	public static int getServiceRequestHistoriesCount() {
		return getService().getServiceRequestHistoriesCount();
	}

	/**
	 * Returns the service request history with the primary key.
	 *
	 * @param ACTION_ID the primary key of the service request history
	 * @return the service request history
	 * @throws PortalException if a service request history with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.ServiceRequestHistory
			getServiceRequestHistory(long ACTION_ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getServiceRequestHistory(ACTION_ID);
	}

	/**
	 * Updates the service request history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestHistory the service request history
	 * @return the service request history that was updated
	 */
	public static com.ejada.atmc.acl.db.model.ServiceRequestHistory
		updateServiceRequestHistory(
			com.ejada.atmc.acl.db.model.ServiceRequestHistory
				serviceRequestHistory) {

		return getService().updateServiceRequestHistory(serviceRequestHistory);
	}

	public static ServiceRequestHistoryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ServiceRequestHistoryLocalService, ServiceRequestHistoryLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ServiceRequestHistoryLocalService.class);

		ServiceTracker
			<ServiceRequestHistoryLocalService,
			 ServiceRequestHistoryLocalService> serviceTracker =
				new ServiceTracker
					<ServiceRequestHistoryLocalService,
					 ServiceRequestHistoryLocalService>(
						 bundle.getBundleContext(),
						 ServiceRequestHistoryLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}