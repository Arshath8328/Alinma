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
 * Provides a wrapper for {@link ServiceRequestMessagesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestMessagesLocalService
 * @generated
 */
public class ServiceRequestMessagesLocalServiceWrapper
	implements ServiceRequestMessagesLocalService,
			   ServiceWrapper<ServiceRequestMessagesLocalService> {

	public ServiceRequestMessagesLocalServiceWrapper(
		ServiceRequestMessagesLocalService serviceRequestMessagesLocalService) {

		_serviceRequestMessagesLocalService =
			serviceRequestMessagesLocalService;
	}

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
	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestMessages
		addServiceRequestMessages(
			com.ejada.atmc.acl.db.model.ServiceRequestMessages
				serviceRequestMessages) {

		return _serviceRequestMessagesLocalService.addServiceRequestMessages(
			serviceRequestMessages);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestMessagesLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new service request messages with the primary key. Does not add the service request messages to the database.
	 *
	 * @param MESSAGE_ID the primary key for the new service request messages
	 * @return the new service request messages
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestMessages
		createServiceRequestMessages(long MESSAGE_ID) {

		return _serviceRequestMessagesLocalService.createServiceRequestMessages(
			MESSAGE_ID);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestMessagesLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestMessages
			deleteServiceRequestMessages(long MESSAGE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestMessagesLocalService.deleteServiceRequestMessages(
			MESSAGE_ID);
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
	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestMessages
		deleteServiceRequestMessages(
			com.ejada.atmc.acl.db.model.ServiceRequestMessages
				serviceRequestMessages) {

		return _serviceRequestMessagesLocalService.deleteServiceRequestMessages(
			serviceRequestMessages);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _serviceRequestMessagesLocalService.dynamicQuery();
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

		return _serviceRequestMessagesLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _serviceRequestMessagesLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _serviceRequestMessagesLocalService.dynamicQuery(
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

		return _serviceRequestMessagesLocalService.dynamicQueryCount(
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

		return _serviceRequestMessagesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestMessages
		fetchServiceRequestMessages(long MESSAGE_ID) {

		return _serviceRequestMessagesLocalService.fetchServiceRequestMessages(
			MESSAGE_ID);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.ServiceRequestMessages>
		findSrvsReqMsgsByRefNo(String refNo) {

		return _serviceRequestMessagesLocalService.findSrvsReqMsgsByRefNo(
			refNo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _serviceRequestMessagesLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _serviceRequestMessagesLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _serviceRequestMessagesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestMessagesLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the service request messages with the primary key.
	 *
	 * @param MESSAGE_ID the primary key of the service request messages
	 * @return the service request messages
	 * @throws PortalException if a service request messages with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestMessages
			getServiceRequestMessages(long MESSAGE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestMessagesLocalService.getServiceRequestMessages(
			MESSAGE_ID);
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
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.ServiceRequestMessages>
		getServiceRequestMessageses(int start, int end) {

		return _serviceRequestMessagesLocalService.getServiceRequestMessageses(
			start, end);
	}

	/**
	 * Returns the number of service request messageses.
	 *
	 * @return the number of service request messageses
	 */
	@Override
	public int getServiceRequestMessagesesCount() {
		return _serviceRequestMessagesLocalService.
			getServiceRequestMessagesesCount();
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
	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestMessages
		updateServiceRequestMessages(
			com.ejada.atmc.acl.db.model.ServiceRequestMessages
				serviceRequestMessages) {

		return _serviceRequestMessagesLocalService.updateServiceRequestMessages(
			serviceRequestMessages);
	}

	@Override
	public ServiceRequestMessagesLocalService getWrappedService() {
		return _serviceRequestMessagesLocalService;
	}

	@Override
	public void setWrappedService(
		ServiceRequestMessagesLocalService serviceRequestMessagesLocalService) {

		_serviceRequestMessagesLocalService =
			serviceRequestMessagesLocalService;
	}

	private ServiceRequestMessagesLocalService
		_serviceRequestMessagesLocalService;

}