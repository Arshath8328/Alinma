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
 * Provides a wrapper for {@link ServiceRequestHistoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestHistoryLocalService
 * @generated
 */
public class ServiceRequestHistoryLocalServiceWrapper
	implements ServiceRequestHistoryLocalService,
			   ServiceWrapper<ServiceRequestHistoryLocalService> {

	public ServiceRequestHistoryLocalServiceWrapper(
		ServiceRequestHistoryLocalService serviceRequestHistoryLocalService) {

		_serviceRequestHistoryLocalService = serviceRequestHistoryLocalService;
	}

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
	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestHistory
		addServiceRequestHistory(
			com.ejada.atmc.acl.db.model.ServiceRequestHistory
				serviceRequestHistory) {

		return _serviceRequestHistoryLocalService.addServiceRequestHistory(
			serviceRequestHistory);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestHistoryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new service request history with the primary key. Does not add the service request history to the database.
	 *
	 * @param ACTION_ID the primary key for the new service request history
	 * @return the new service request history
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestHistory
		createServiceRequestHistory(long ACTION_ID) {

		return _serviceRequestHistoryLocalService.createServiceRequestHistory(
			ACTION_ID);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestHistoryLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestHistory
			deleteServiceRequestHistory(long ACTION_ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestHistoryLocalService.deleteServiceRequestHistory(
			ACTION_ID);
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
	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestHistory
		deleteServiceRequestHistory(
			com.ejada.atmc.acl.db.model.ServiceRequestHistory
				serviceRequestHistory) {

		return _serviceRequestHistoryLocalService.deleteServiceRequestHistory(
			serviceRequestHistory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _serviceRequestHistoryLocalService.dynamicQuery();
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

		return _serviceRequestHistoryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _serviceRequestHistoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _serviceRequestHistoryLocalService.dynamicQuery(
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

		return _serviceRequestHistoryLocalService.dynamicQueryCount(
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

		return _serviceRequestHistoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestHistory
		fetchServiceRequestHistory(long ACTION_ID) {

		return _serviceRequestHistoryLocalService.fetchServiceRequestHistory(
			ACTION_ID);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.ServiceRequestHistory>
		findSrvReqHistoryByRefNo(String refNo) {

		return _serviceRequestHistoryLocalService.findSrvReqHistoryByRefNo(
			refNo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _serviceRequestHistoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _serviceRequestHistoryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _serviceRequestHistoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestHistoryLocalService.getPersistedModel(
			primaryKeyObj);
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
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.ServiceRequestHistory>
		getServiceRequestHistories(int start, int end) {

		return _serviceRequestHistoryLocalService.getServiceRequestHistories(
			start, end);
	}

	/**
	 * Returns the number of service request histories.
	 *
	 * @return the number of service request histories
	 */
	@Override
	public int getServiceRequestHistoriesCount() {
		return _serviceRequestHistoryLocalService.
			getServiceRequestHistoriesCount();
	}

	/**
	 * Returns the service request history with the primary key.
	 *
	 * @param ACTION_ID the primary key of the service request history
	 * @return the service request history
	 * @throws PortalException if a service request history with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestHistory
			getServiceRequestHistory(long ACTION_ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestHistoryLocalService.getServiceRequestHistory(
			ACTION_ID);
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
	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestHistory
		updateServiceRequestHistory(
			com.ejada.atmc.acl.db.model.ServiceRequestHistory
				serviceRequestHistory) {

		return _serviceRequestHistoryLocalService.updateServiceRequestHistory(
			serviceRequestHistory);
	}

	@Override
	public ServiceRequestHistoryLocalService getWrappedService() {
		return _serviceRequestHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		ServiceRequestHistoryLocalService serviceRequestHistoryLocalService) {

		_serviceRequestHistoryLocalService = serviceRequestHistoryLocalService;
	}

	private ServiceRequestHistoryLocalService
		_serviceRequestHistoryLocalService;

}