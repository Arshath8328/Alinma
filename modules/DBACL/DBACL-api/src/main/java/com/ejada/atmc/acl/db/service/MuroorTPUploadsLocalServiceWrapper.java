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
 * Provides a wrapper for {@link MuroorTPUploadsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MuroorTPUploadsLocalService
 * @generated
 */
public class MuroorTPUploadsLocalServiceWrapper
	implements MuroorTPUploadsLocalService,
			   ServiceWrapper<MuroorTPUploadsLocalService> {

	public MuroorTPUploadsLocalServiceWrapper(
		MuroorTPUploadsLocalService muroorTPUploadsLocalService) {

		_muroorTPUploadsLocalService = muroorTPUploadsLocalService;
	}

	/**
	 * Adds the muroor tp uploads to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MuroorTPUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param muroorTPUploads the muroor tp uploads
	 * @return the muroor tp uploads that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.MuroorTPUploads addMuroorTPUploads(
		com.ejada.atmc.acl.db.model.MuroorTPUploads muroorTPUploads) {

		return _muroorTPUploadsLocalService.addMuroorTPUploads(muroorTPUploads);
	}

	/**
	 * Creates a new muroor tp uploads with the primary key. Does not add the muroor tp uploads to the database.
	 *
	 * @param id the primary key for the new muroor tp uploads
	 * @return the new muroor tp uploads
	 */
	@Override
	public com.ejada.atmc.acl.db.model.MuroorTPUploads createMuroorTPUploads(
		int id) {

		return _muroorTPUploadsLocalService.createMuroorTPUploads(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _muroorTPUploadsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the muroor tp uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MuroorTPUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the muroor tp uploads
	 * @return the muroor tp uploads that was removed
	 * @throws PortalException if a muroor tp uploads with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.MuroorTPUploads deleteMuroorTPUploads(
			int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _muroorTPUploadsLocalService.deleteMuroorTPUploads(id);
	}

	/**
	 * Deletes the muroor tp uploads from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MuroorTPUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param muroorTPUploads the muroor tp uploads
	 * @return the muroor tp uploads that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.MuroorTPUploads deleteMuroorTPUploads(
		com.ejada.atmc.acl.db.model.MuroorTPUploads muroorTPUploads) {

		return _muroorTPUploadsLocalService.deleteMuroorTPUploads(
			muroorTPUploads);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _muroorTPUploadsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _muroorTPUploadsLocalService.dynamicQuery();
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

		return _muroorTPUploadsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.MuroorTPUploadsModelImpl</code>.
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

		return _muroorTPUploadsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.MuroorTPUploadsModelImpl</code>.
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

		return _muroorTPUploadsLocalService.dynamicQuery(
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

		return _muroorTPUploadsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _muroorTPUploadsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.MuroorTPUploads fetchMuroorTPUploads(
		int id) {

		return _muroorTPUploadsLocalService.fetchMuroorTPUploads(id);
	}

	@Override
	public Object[] findUploadsData(String intmNo) {
		return _muroorTPUploadsLocalService.findUploadsData(intmNo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _muroorTPUploadsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.ejada.atmc.acl.db.model.MuroorTPUploadsBankIbanBlobModel
		getBankIbanBlobModel(java.io.Serializable primaryKey) {

		return _muroorTPUploadsLocalService.getBankIbanBlobModel(primaryKey);
	}

	@Override
	public com.ejada.atmc.acl.db.model.MuroorTPUploadsDriverLicenseBlobModel
		getDriverLicenseBlobModel(java.io.Serializable primaryKey) {

		return _muroorTPUploadsLocalService.getDriverLicenseBlobModel(
			primaryKey);
	}

	@Override
	public com.ejada.atmc.acl.db.model.MuroorTPUploadsFrontPhotoBlobModel
		getFrontPhotoBlobModel(java.io.Serializable primaryKey) {

		return _muroorTPUploadsLocalService.getFrontPhotoBlobModel(primaryKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _muroorTPUploadsLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public com.ejada.atmc.acl.db.model.MuroorTPUploadsLeftSidePhotoBlobModel
		getLeftSidePhotoBlobModel(java.io.Serializable primaryKey) {

		return _muroorTPUploadsLocalService.getLeftSidePhotoBlobModel(
			primaryKey);
	}

	/**
	 * Returns the muroor tp uploads with the primary key.
	 *
	 * @param id the primary key of the muroor tp uploads
	 * @return the muroor tp uploads
	 * @throws PortalException if a muroor tp uploads with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.MuroorTPUploads getMuroorTPUploads(
			int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _muroorTPUploadsLocalService.getMuroorTPUploads(id);
	}

	/**
	 * Returns a range of all the muroor tp uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.MuroorTPUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of muroor tp uploadses
	 * @param end the upper bound of the range of muroor tp uploadses (not inclusive)
	 * @return the range of muroor tp uploadses
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.MuroorTPUploads>
		getMuroorTPUploadses(int start, int end) {

		return _muroorTPUploadsLocalService.getMuroorTPUploadses(start, end);
	}

	/**
	 * Returns the number of muroor tp uploadses.
	 *
	 * @return the number of muroor tp uploadses
	 */
	@Override
	public int getMuroorTPUploadsesCount() {
		return _muroorTPUploadsLocalService.getMuroorTPUploadsesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _muroorTPUploadsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.ejada.atmc.acl.db.model.MuroorTPUploadsOwnerIdBlobModel
		getOwnerIdBlobModel(java.io.Serializable primaryKey) {

		return _muroorTPUploadsLocalService.getOwnerIdBlobModel(primaryKey);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _muroorTPUploadsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.ejada.atmc.acl.db.model.MuroorTPUploadsRearPhotoBlobModel
		getRearPhotoBlobModel(java.io.Serializable primaryKey) {

		return _muroorTPUploadsLocalService.getRearPhotoBlobModel(primaryKey);
	}

	@Override
	public com.ejada.atmc.acl.db.model.MuroorTPUploadsRightSidePhotoBlobModel
		getRightSidePhotoBlobModel(java.io.Serializable primaryKey) {

		return _muroorTPUploadsLocalService.getRightSidePhotoBlobModel(
			primaryKey);
	}

	@Override
	public com.ejada.atmc.acl.db.model.MuroorTPUploadsVehRegistBlobModel
		getVehRegistBlobModel(java.io.Serializable primaryKey) {

		return _muroorTPUploadsLocalService.getVehRegistBlobModel(primaryKey);
	}

	@Override
	public java.io.InputStream openBankIbanInputStream(long id) {
		return _muroorTPUploadsLocalService.openBankIbanInputStream(id);
	}

	@Override
	public java.io.InputStream openDriverLicenseInputStream(long id) {
		return _muroorTPUploadsLocalService.openDriverLicenseInputStream(id);
	}

	@Override
	public java.io.InputStream openFrontPhotoInputStream(long id) {
		return _muroorTPUploadsLocalService.openFrontPhotoInputStream(id);
	}

	@Override
	public java.io.InputStream openLeftSidePhotoInputStream(long id) {
		return _muroorTPUploadsLocalService.openLeftSidePhotoInputStream(id);
	}

	@Override
	public java.io.InputStream openOwnerIdInputStream(long id) {
		return _muroorTPUploadsLocalService.openOwnerIdInputStream(id);
	}

	@Override
	public java.io.InputStream openRearPhotoInputStream(long id) {
		return _muroorTPUploadsLocalService.openRearPhotoInputStream(id);
	}

	@Override
	public java.io.InputStream openRightSidePhotoInputStream(long id) {
		return _muroorTPUploadsLocalService.openRightSidePhotoInputStream(id);
	}

	@Override
	public java.io.InputStream openVehRegistInputStream(long id) {
		return _muroorTPUploadsLocalService.openVehRegistInputStream(id);
	}

	/**
	 * Updates the muroor tp uploads in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MuroorTPUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param muroorTPUploads the muroor tp uploads
	 * @return the muroor tp uploads that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.MuroorTPUploads updateMuroorTPUploads(
		com.ejada.atmc.acl.db.model.MuroorTPUploads muroorTPUploads) {

		return _muroorTPUploadsLocalService.updateMuroorTPUploads(
			muroorTPUploads);
	}

	@Override
	public MuroorTPUploadsLocalService getWrappedService() {
		return _muroorTPUploadsLocalService;
	}

	@Override
	public void setWrappedService(
		MuroorTPUploadsLocalService muroorTPUploadsLocalService) {

		_muroorTPUploadsLocalService = muroorTPUploadsLocalService;
	}

	private MuroorTPUploadsLocalService _muroorTPUploadsLocalService;

}