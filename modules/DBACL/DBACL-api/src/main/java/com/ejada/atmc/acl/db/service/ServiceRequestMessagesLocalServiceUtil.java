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
 * Provides the local service utility for ServiceRequestMessages. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.ServiceRequestMessagesLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestMessagesLocalService
 * @generated
 */
public class ServiceRequestMessagesLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.ServiceRequestMessagesLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the service request messages to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestMessagesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestMessages the service request messages
	 * @return the service request messages that was added
	 */
	public static com.ejada.atmc.acl.db.model.ServiceRequestMessages
		addServiceRequestMessages(
			com.ejada.atmc.acl.db.model.ServiceRequestMessages
				serviceRequestMessages) {

		return getService().addServiceRequestMessages(serviceRequestMessages);
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
	 * Creates a new service request messages with the primary key. Does not add the service request messages to the database.
	 *
	 * @param MESSAGE_ID the primary key for the new service request messages
	 * @return the new service request messages
	 */
	public static com.ejada.atmc.acl.db.model.ServiceRequestMessages
		createServiceRequestMessages(long MESSAGE_ID) {

		return getService().createServiceRequestMessages(MESSAGE_ID);
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
	 * Deletes the service request messages with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestMessagesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param MESSAGE_ID the primary key of the service request messages
	 * @return the service request messages that was removed
	 * @throws PortalException if a service request messages with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.ServiceRequestMessages
			deleteServiceRequestMessages(long MESSAGE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteServiceRequestMessages(MESSAGE_ID);
	}

	/**
	 * Deletes the service request messages from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestMessagesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestMessages the service request messages
	 * @return the service request messages that was removed
	 */
	public static com.ejada.atmc.acl.db.model.ServiceRequestMessages
		deleteServiceRequestMessages(
			com.ejada.atmc.acl.db.model.ServiceRequestMessages
				serviceRequestMessages) {

		return getService().deleteServiceRequestMessages(
			serviceRequestMessages);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ServiceRequestMessagesModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ServiceRequestMessagesModelImpl</code>.
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

	public static com.ejada.atmc.acl.db.model.ServiceRequestMessages
		fetchServiceRequestMessages(long MESSAGE_ID) {

		return getService().fetchServiceRequestMessages(MESSAGE_ID);
	}

	public static java.util.List
		<com.ejada.atmc.acl.db.model.ServiceRequestMessages>
			findSrvsReqMsgsByRefNo(String refNo) {

		return getService().findSrvsReqMsgsByRefNo(refNo);
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
	 * Returns the service request messages with the primary key.
	 *
	 * @param MESSAGE_ID the primary key of the service request messages
	 * @return the service request messages
	 * @throws PortalException if a service request messages with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.ServiceRequestMessages
			getServiceRequestMessages(long MESSAGE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getServiceRequestMessages(MESSAGE_ID);
	}

	/**
	 * Returns a range of all the service request messageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ServiceRequestMessagesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request messageses
	 * @param end the upper bound of the range of service request messageses (not inclusive)
	 * @return the range of service request messageses
	 */
	public static java.util.List
		<com.ejada.atmc.acl.db.model.ServiceRequestMessages>
			getServiceRequestMessageses(int start, int end) {

		return getService().getServiceRequestMessageses(start, end);
	}

	/**
	 * Returns the number of service request messageses.
	 *
	 * @return the number of service request messageses
	 */
	public static int getServiceRequestMessagesesCount() {
		return getService().getServiceRequestMessagesesCount();
	}

	/**
	 * Updates the service request messages in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestMessagesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestMessages the service request messages
	 * @return the service request messages that was updated
	 */
	public static com.ejada.atmc.acl.db.model.ServiceRequestMessages
		updateServiceRequestMessages(
			com.ejada.atmc.acl.db.model.ServiceRequestMessages
				serviceRequestMessages) {

		return getService().updateServiceRequestMessages(
			serviceRequestMessages);
	}

	public static ServiceRequestMessagesLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ServiceRequestMessagesLocalService, ServiceRequestMessagesLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ServiceRequestMessagesLocalService.class);

		ServiceTracker
			<ServiceRequestMessagesLocalService,
			 ServiceRequestMessagesLocalService> serviceTracker =
				new ServiceTracker
					<ServiceRequestMessagesLocalService,
					 ServiceRequestMessagesLocalService>(
						 bundle.getBundleContext(),
						 ServiceRequestMessagesLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}