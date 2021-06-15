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
 * Provides the local service utility for MuroorTPUploads. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.MuroorTPUploadsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MuroorTPUploadsLocalService
 * @generated
 */
public class MuroorTPUploadsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.MuroorTPUploadsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static com.ejada.atmc.acl.db.model.MuroorTPUploads
		addMuroorTPUploads(
			com.ejada.atmc.acl.db.model.MuroorTPUploads muroorTPUploads) {

		return getService().addMuroorTPUploads(muroorTPUploads);
	}

	/**
	 * Creates a new muroor tp uploads with the primary key. Does not add the muroor tp uploads to the database.
	 *
	 * @param id the primary key for the new muroor tp uploads
	 * @return the new muroor tp uploads
	 */
	public static com.ejada.atmc.acl.db.model.MuroorTPUploads
		createMuroorTPUploads(int id) {

		return getService().createMuroorTPUploads(id);
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
	public static com.ejada.atmc.acl.db.model.MuroorTPUploads
			deleteMuroorTPUploads(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteMuroorTPUploads(id);
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
	public static com.ejada.atmc.acl.db.model.MuroorTPUploads
		deleteMuroorTPUploads(
			com.ejada.atmc.acl.db.model.MuroorTPUploads muroorTPUploads) {

		return getService().deleteMuroorTPUploads(muroorTPUploads);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.MuroorTPUploadsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.MuroorTPUploadsModelImpl</code>.
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

	public static com.ejada.atmc.acl.db.model.MuroorTPUploads
		fetchMuroorTPUploads(int id) {

		return getService().fetchMuroorTPUploads(id);
	}

	public static Object[] findUploadsData(String intmNo) {
		return getService().findUploadsData(intmNo);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.ejada.atmc.acl.db.model.MuroorTPUploadsBankIbanBlobModel
		getBankIbanBlobModel(java.io.Serializable primaryKey) {

		return getService().getBankIbanBlobModel(primaryKey);
	}

	public static
		com.ejada.atmc.acl.db.model.MuroorTPUploadsDriverLicenseBlobModel
			getDriverLicenseBlobModel(java.io.Serializable primaryKey) {

		return getService().getDriverLicenseBlobModel(primaryKey);
	}

	public static com.ejada.atmc.acl.db.model.MuroorTPUploadsFrontPhotoBlobModel
		getFrontPhotoBlobModel(java.io.Serializable primaryKey) {

		return getService().getFrontPhotoBlobModel(primaryKey);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static
		com.ejada.atmc.acl.db.model.MuroorTPUploadsLeftSidePhotoBlobModel
			getLeftSidePhotoBlobModel(java.io.Serializable primaryKey) {

		return getService().getLeftSidePhotoBlobModel(primaryKey);
	}

	/**
	 * Returns the muroor tp uploads with the primary key.
	 *
	 * @param id the primary key of the muroor tp uploads
	 * @return the muroor tp uploads
	 * @throws PortalException if a muroor tp uploads with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.MuroorTPUploads
			getMuroorTPUploads(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMuroorTPUploads(id);
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
	public static java.util.List<com.ejada.atmc.acl.db.model.MuroorTPUploads>
		getMuroorTPUploadses(int start, int end) {

		return getService().getMuroorTPUploadses(start, end);
	}

	/**
	 * Returns the number of muroor tp uploadses.
	 *
	 * @return the number of muroor tp uploadses
	 */
	public static int getMuroorTPUploadsesCount() {
		return getService().getMuroorTPUploadsesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.ejada.atmc.acl.db.model.MuroorTPUploadsOwnerIdBlobModel
		getOwnerIdBlobModel(java.io.Serializable primaryKey) {

		return getService().getOwnerIdBlobModel(primaryKey);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static com.ejada.atmc.acl.db.model.MuroorTPUploadsRearPhotoBlobModel
		getRearPhotoBlobModel(java.io.Serializable primaryKey) {

		return getService().getRearPhotoBlobModel(primaryKey);
	}

	public static
		com.ejada.atmc.acl.db.model.MuroorTPUploadsRightSidePhotoBlobModel
			getRightSidePhotoBlobModel(java.io.Serializable primaryKey) {

		return getService().getRightSidePhotoBlobModel(primaryKey);
	}

	public static com.ejada.atmc.acl.db.model.MuroorTPUploadsVehRegistBlobModel
		getVehRegistBlobModel(java.io.Serializable primaryKey) {

		return getService().getVehRegistBlobModel(primaryKey);
	}

	public static java.io.InputStream openBankIbanInputStream(long id) {
		return getService().openBankIbanInputStream(id);
	}

	public static java.io.InputStream openDriverLicenseInputStream(long id) {
		return getService().openDriverLicenseInputStream(id);
	}

	public static java.io.InputStream openFrontPhotoInputStream(long id) {
		return getService().openFrontPhotoInputStream(id);
	}

	public static java.io.InputStream openLeftSidePhotoInputStream(long id) {
		return getService().openLeftSidePhotoInputStream(id);
	}

	public static java.io.InputStream openOwnerIdInputStream(long id) {
		return getService().openOwnerIdInputStream(id);
	}

	public static java.io.InputStream openRearPhotoInputStream(long id) {
		return getService().openRearPhotoInputStream(id);
	}

	public static java.io.InputStream openRightSidePhotoInputStream(long id) {
		return getService().openRightSidePhotoInputStream(id);
	}

	public static java.io.InputStream openVehRegistInputStream(long id) {
		return getService().openVehRegistInputStream(id);
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
	public static com.ejada.atmc.acl.db.model.MuroorTPUploads
		updateMuroorTPUploads(
			com.ejada.atmc.acl.db.model.MuroorTPUploads muroorTPUploads) {

		return getService().updateMuroorTPUploads(muroorTPUploads);
	}

	public static MuroorTPUploadsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MuroorTPUploadsLocalService, MuroorTPUploadsLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			MuroorTPUploadsLocalService.class);

		ServiceTracker<MuroorTPUploadsLocalService, MuroorTPUploadsLocalService>
			serviceTracker =
				new ServiceTracker
					<MuroorTPUploadsLocalService, MuroorTPUploadsLocalService>(
						bundle.getBundleContext(),
						MuroorTPUploadsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}