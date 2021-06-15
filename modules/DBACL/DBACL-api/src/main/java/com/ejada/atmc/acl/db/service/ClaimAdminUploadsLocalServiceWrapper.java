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
 * Provides a wrapper for {@link ClaimAdminUploadsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimAdminUploadsLocalService
 * @generated
 */
public class ClaimAdminUploadsLocalServiceWrapper
	implements ClaimAdminUploadsLocalService,
			   ServiceWrapper<ClaimAdminUploadsLocalService> {

	public ClaimAdminUploadsLocalServiceWrapper(
		ClaimAdminUploadsLocalService claimAdminUploadsLocalService) {

		_claimAdminUploadsLocalService = claimAdminUploadsLocalService;
	}

	/**
	 * Adds the claim admin uploads to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimAdminUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimAdminUploads the claim admin uploads
	 * @return the claim admin uploads that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimAdminUploads addClaimAdminUploads(
		com.ejada.atmc.acl.db.model.ClaimAdminUploads claimAdminUploads) {

		return _claimAdminUploadsLocalService.addClaimAdminUploads(
			claimAdminUploads);
	}

	/**
	 * Creates a new claim admin uploads with the primary key. Does not add the claim admin uploads to the database.
	 *
	 * @param id the primary key for the new claim admin uploads
	 * @return the new claim admin uploads
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimAdminUploads
		createClaimAdminUploads(int id) {

		return _claimAdminUploadsLocalService.createClaimAdminUploads(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimAdminUploadsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the claim admin uploads from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimAdminUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimAdminUploads the claim admin uploads
	 * @return the claim admin uploads that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimAdminUploads
		deleteClaimAdminUploads(
			com.ejada.atmc.acl.db.model.ClaimAdminUploads claimAdminUploads) {

		return _claimAdminUploadsLocalService.deleteClaimAdminUploads(
			claimAdminUploads);
	}

	/**
	 * Deletes the claim admin uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimAdminUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the claim admin uploads
	 * @return the claim admin uploads that was removed
	 * @throws PortalException if a claim admin uploads with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimAdminUploads
			deleteClaimAdminUploads(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimAdminUploadsLocalService.deleteClaimAdminUploads(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimAdminUploadsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _claimAdminUploadsLocalService.dynamicQuery();
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

		return _claimAdminUploadsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ClaimAdminUploadsModelImpl</code>.
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

		return _claimAdminUploadsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ClaimAdminUploadsModelImpl</code>.
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

		return _claimAdminUploadsLocalService.dynamicQuery(
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

		return _claimAdminUploadsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _claimAdminUploadsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.ClaimAdminUploads fetchClaimAdminUploads(
		int id) {

		return _claimAdminUploadsLocalService.fetchClaimAdminUploads(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _claimAdminUploadsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.ejada.atmc.acl.db.model.ClaimAdminUploadsAdminFileBlobModel
		getAdminFileBlobModel(java.io.Serializable primaryKey) {

		return _claimAdminUploadsLocalService.getAdminFileBlobModel(primaryKey);
	}

	/**
	 * Returns the claim admin uploads with the primary key.
	 *
	 * @param id the primary key of the claim admin uploads
	 * @return the claim admin uploads
	 * @throws PortalException if a claim admin uploads with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimAdminUploads getClaimAdminUploads(
			int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimAdminUploadsLocalService.getClaimAdminUploads(id);
	}

	/**
	 * Returns a range of all the claim admin uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ClaimAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim admin uploadses
	 * @param end the upper bound of the range of claim admin uploadses (not inclusive)
	 * @return the range of claim admin uploadses
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.ClaimAdminUploads>
		getClaimAdminUploadses(int start, int end) {

		return _claimAdminUploadsLocalService.getClaimAdminUploadses(
			start, end);
	}

	/**
	 * Returns the number of claim admin uploadses.
	 *
	 * @return the number of claim admin uploadses
	 */
	@Override
	public int getClaimAdminUploadsesCount() {
		return _claimAdminUploadsLocalService.getClaimAdminUploadsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _claimAdminUploadsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _claimAdminUploadsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimAdminUploadsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.io.InputStream openAdminFileInputStream(long id) {
		return _claimAdminUploadsLocalService.openAdminFileInputStream(id);
	}

	/**
	 * Updates the claim admin uploads in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimAdminUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimAdminUploads the claim admin uploads
	 * @return the claim admin uploads that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimAdminUploads
		updateClaimAdminUploads(
			com.ejada.atmc.acl.db.model.ClaimAdminUploads claimAdminUploads) {

		return _claimAdminUploadsLocalService.updateClaimAdminUploads(
			claimAdminUploads);
	}

	@Override
	public ClaimAdminUploadsLocalService getWrappedService() {
		return _claimAdminUploadsLocalService;
	}

	@Override
	public void setWrappedService(
		ClaimAdminUploadsLocalService claimAdminUploadsLocalService) {

		_claimAdminUploadsLocalService = claimAdminUploadsLocalService;
	}

	private ClaimAdminUploadsLocalService _claimAdminUploadsLocalService;

}