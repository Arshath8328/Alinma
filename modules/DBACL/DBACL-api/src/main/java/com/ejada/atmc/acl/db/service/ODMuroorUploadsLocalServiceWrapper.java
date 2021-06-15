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
 * Provides a wrapper for {@link ODMuroorUploadsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ODMuroorUploadsLocalService
 * @generated
 */
public class ODMuroorUploadsLocalServiceWrapper
	implements ODMuroorUploadsLocalService,
			   ServiceWrapper<ODMuroorUploadsLocalService> {

	public ODMuroorUploadsLocalServiceWrapper(
		ODMuroorUploadsLocalService odMuroorUploadsLocalService) {

		_odMuroorUploadsLocalService = odMuroorUploadsLocalService;
	}

	/**
	 * Adds the od muroor uploads to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ODMuroorUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param odMuroorUploads the od muroor uploads
	 * @return the od muroor uploads that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ODMuroorUploads addODMuroorUploads(
		com.ejada.atmc.acl.db.model.ODMuroorUploads odMuroorUploads) {

		return _odMuroorUploadsLocalService.addODMuroorUploads(odMuroorUploads);
	}

	/**
	 * Creates a new od muroor uploads with the primary key. Does not add the od muroor uploads to the database.
	 *
	 * @param id the primary key for the new od muroor uploads
	 * @return the new od muroor uploads
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ODMuroorUploads createODMuroorUploads(
		int id) {

		return _odMuroorUploadsLocalService.createODMuroorUploads(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _odMuroorUploadsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the od muroor uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ODMuroorUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the od muroor uploads
	 * @return the od muroor uploads that was removed
	 * @throws PortalException if a od muroor uploads with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ODMuroorUploads deleteODMuroorUploads(
			int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _odMuroorUploadsLocalService.deleteODMuroorUploads(id);
	}

	/**
	 * Deletes the od muroor uploads from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ODMuroorUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param odMuroorUploads the od muroor uploads
	 * @return the od muroor uploads that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ODMuroorUploads deleteODMuroorUploads(
		com.ejada.atmc.acl.db.model.ODMuroorUploads odMuroorUploads) {

		return _odMuroorUploadsLocalService.deleteODMuroorUploads(
			odMuroorUploads);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _odMuroorUploadsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _odMuroorUploadsLocalService.dynamicQuery();
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

		return _odMuroorUploadsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ODMuroorUploadsModelImpl</code>.
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

		return _odMuroorUploadsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ODMuroorUploadsModelImpl</code>.
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

		return _odMuroorUploadsLocalService.dynamicQuery(
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

		return _odMuroorUploadsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _odMuroorUploadsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.ODMuroorUploads fetchODMuroorUploads(
		int id) {

		return _odMuroorUploadsLocalService.fetchODMuroorUploads(id);
	}

	@Override
	public Object[] findUploadsData(String intmNo) {
		return _odMuroorUploadsLocalService.findUploadsData(intmNo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _odMuroorUploadsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.ejada.atmc.acl.db.model.ODMuroorUploadsDriverLicenseBlobModel
		getDriverLicenseBlobModel(java.io.Serializable primaryKey) {

		return _odMuroorUploadsLocalService.getDriverLicenseBlobModel(
			primaryKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _odMuroorUploadsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the od muroor uploads with the primary key.
	 *
	 * @param id the primary key of the od muroor uploads
	 * @return the od muroor uploads
	 * @throws PortalException if a od muroor uploads with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ODMuroorUploads getODMuroorUploads(
			int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _odMuroorUploadsLocalService.getODMuroorUploads(id);
	}

	/**
	 * Returns a range of all the od muroor uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ODMuroorUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of od muroor uploadses
	 * @param end the upper bound of the range of od muroor uploadses (not inclusive)
	 * @return the range of od muroor uploadses
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.ODMuroorUploads>
		getODMuroorUploadses(int start, int end) {

		return _odMuroorUploadsLocalService.getODMuroorUploadses(start, end);
	}

	/**
	 * Returns the number of od muroor uploadses.
	 *
	 * @return the number of od muroor uploadses
	 */
	@Override
	public int getODMuroorUploadsesCount() {
		return _odMuroorUploadsLocalService.getODMuroorUploadsesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _odMuroorUploadsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _odMuroorUploadsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.ejada.atmc.acl.db.model.ODMuroorUploadsPolicyCopyBlobModel
		getPolicyCopyBlobModel(java.io.Serializable primaryKey) {

		return _odMuroorUploadsLocalService.getPolicyCopyBlobModel(primaryKey);
	}

	@Override
	public com.ejada.atmc.acl.db.model.ODMuroorUploadsVehRegistBlobModel
		getVehRegistBlobModel(java.io.Serializable primaryKey) {

		return _odMuroorUploadsLocalService.getVehRegistBlobModel(primaryKey);
	}

	@Override
	public java.io.InputStream openDriverLicenseInputStream(long id) {
		return _odMuroorUploadsLocalService.openDriverLicenseInputStream(id);
	}

	@Override
	public java.io.InputStream openPolicyCopyInputStream(long id) {
		return _odMuroorUploadsLocalService.openPolicyCopyInputStream(id);
	}

	@Override
	public java.io.InputStream openVehRegistInputStream(long id) {
		return _odMuroorUploadsLocalService.openVehRegistInputStream(id);
	}

	/**
	 * Updates the od muroor uploads in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ODMuroorUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param odMuroorUploads the od muroor uploads
	 * @return the od muroor uploads that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ODMuroorUploads updateODMuroorUploads(
		com.ejada.atmc.acl.db.model.ODMuroorUploads odMuroorUploads) {

		return _odMuroorUploadsLocalService.updateODMuroorUploads(
			odMuroorUploads);
	}

	@Override
	public ODMuroorUploadsLocalService getWrappedService() {
		return _odMuroorUploadsLocalService;
	}

	@Override
	public void setWrappedService(
		ODMuroorUploadsLocalService odMuroorUploadsLocalService) {

		_odMuroorUploadsLocalService = odMuroorUploadsLocalService;
	}

	private ODMuroorUploadsLocalService _odMuroorUploadsLocalService;

}