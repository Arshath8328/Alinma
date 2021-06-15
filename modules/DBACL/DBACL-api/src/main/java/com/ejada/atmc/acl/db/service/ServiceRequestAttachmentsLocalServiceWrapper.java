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
 * Provides a wrapper for {@link ServiceRequestAttachmentsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestAttachmentsLocalService
 * @generated
 */
public class ServiceRequestAttachmentsLocalServiceWrapper
	implements ServiceRequestAttachmentsLocalService,
			   ServiceWrapper<ServiceRequestAttachmentsLocalService> {

	public ServiceRequestAttachmentsLocalServiceWrapper(
		ServiceRequestAttachmentsLocalService
			serviceRequestAttachmentsLocalService) {

		_serviceRequestAttachmentsLocalService =
			serviceRequestAttachmentsLocalService;
	}

	/**
	 * Adds the service request attachments to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestAttachmentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestAttachments the service request attachments
	 * @return the service request attachments that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestAttachments
		addServiceRequestAttachments(
			com.ejada.atmc.acl.db.model.ServiceRequestAttachments
				serviceRequestAttachments) {

		return _serviceRequestAttachmentsLocalService.
			addServiceRequestAttachments(serviceRequestAttachments);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestAttachmentsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new service request attachments with the primary key. Does not add the service request attachments to the database.
	 *
	 * @param FILE_ID the primary key for the new service request attachments
	 * @return the new service request attachments
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestAttachments
		createServiceRequestAttachments(long FILE_ID) {

		return _serviceRequestAttachmentsLocalService.
			createServiceRequestAttachments(FILE_ID);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestAttachmentsLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the service request attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestAttachmentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param FILE_ID the primary key of the service request attachments
	 * @return the service request attachments that was removed
	 * @throws PortalException if a service request attachments with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestAttachments
			deleteServiceRequestAttachments(long FILE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestAttachmentsLocalService.
			deleteServiceRequestAttachments(FILE_ID);
	}

	/**
	 * Deletes the service request attachments from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestAttachmentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestAttachments the service request attachments
	 * @return the service request attachments that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestAttachments
		deleteServiceRequestAttachments(
			com.ejada.atmc.acl.db.model.ServiceRequestAttachments
				serviceRequestAttachments) {

		return _serviceRequestAttachmentsLocalService.
			deleteServiceRequestAttachments(serviceRequestAttachments);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _serviceRequestAttachmentsLocalService.dynamicQuery();
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

		return _serviceRequestAttachmentsLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ServiceRequestAttachmentsModelImpl</code>.
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

		return _serviceRequestAttachmentsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ServiceRequestAttachmentsModelImpl</code>.
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

		return _serviceRequestAttachmentsLocalService.dynamicQuery(
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

		return _serviceRequestAttachmentsLocalService.dynamicQueryCount(
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

		return _serviceRequestAttachmentsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestAttachments
		fetchServiceRequestAttachments(long FILE_ID) {

		return _serviceRequestAttachmentsLocalService.
			fetchServiceRequestAttachments(FILE_ID);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.ServiceRequestAttachments>
		findSrvReqAttachmentsByActionId(String actionId) {

		return _serviceRequestAttachmentsLocalService.
			findSrvReqAttachmentsByActionId(actionId);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.ServiceRequestAttachments>
		findSrvReqAttachmentsByRefNo(String refNo) {

		return _serviceRequestAttachmentsLocalService.
			findSrvReqAttachmentsByRefNo(refNo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _serviceRequestAttachmentsLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public
		com.ejada.atmc.acl.db.model.
			ServiceRequestAttachmentsFILE_CONTENTBlobModel
				getFILE_CONTENTBlobModel(java.io.Serializable primaryKey) {

		return _serviceRequestAttachmentsLocalService.getFILE_CONTENTBlobModel(
			primaryKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _serviceRequestAttachmentsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _serviceRequestAttachmentsLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestAttachmentsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the service request attachments with the primary key.
	 *
	 * @param FILE_ID the primary key of the service request attachments
	 * @return the service request attachments
	 * @throws PortalException if a service request attachments with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestAttachments
			getServiceRequestAttachments(long FILE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestAttachmentsLocalService.
			getServiceRequestAttachments(FILE_ID);
	}

	/**
	 * Returns a range of all the service request attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ServiceRequestAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request attachmentses
	 * @param end the upper bound of the range of service request attachmentses (not inclusive)
	 * @return the range of service request attachmentses
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.ServiceRequestAttachments>
		getServiceRequestAttachmentses(int start, int end) {

		return _serviceRequestAttachmentsLocalService.
			getServiceRequestAttachmentses(start, end);
	}

	/**
	 * Returns the number of service request attachmentses.
	 *
	 * @return the number of service request attachmentses
	 */
	@Override
	public int getServiceRequestAttachmentsesCount() {
		return _serviceRequestAttachmentsLocalService.
			getServiceRequestAttachmentsesCount();
	}

	@Override
	public java.io.InputStream openFILE_CONTENTInputStream(long FILE_ID) {
		return _serviceRequestAttachmentsLocalService.
			openFILE_CONTENTInputStream(FILE_ID);
	}

	/**
	 * Updates the service request attachments in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestAttachmentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestAttachments the service request attachments
	 * @return the service request attachments that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestAttachments
		updateServiceRequestAttachments(
			com.ejada.atmc.acl.db.model.ServiceRequestAttachments
				serviceRequestAttachments) {

		return _serviceRequestAttachmentsLocalService.
			updateServiceRequestAttachments(serviceRequestAttachments);
	}

	@Override
	public ServiceRequestAttachmentsLocalService getWrappedService() {
		return _serviceRequestAttachmentsLocalService;
	}

	@Override
	public void setWrappedService(
		ServiceRequestAttachmentsLocalService
			serviceRequestAttachmentsLocalService) {

		_serviceRequestAttachmentsLocalService =
			serviceRequestAttachmentsLocalService;
	}

	private ServiceRequestAttachmentsLocalService
		_serviceRequestAttachmentsLocalService;

}