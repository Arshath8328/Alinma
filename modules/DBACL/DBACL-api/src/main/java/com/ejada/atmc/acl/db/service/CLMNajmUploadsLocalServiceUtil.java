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
 * Provides the local service utility for CLMNajmUploads. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.CLMNajmUploadsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CLMNajmUploadsLocalService
 * @generated
 */
public class CLMNajmUploadsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.CLMNajmUploadsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the clm najm uploads to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMNajmUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clmNajmUploads the clm najm uploads
	 * @return the clm najm uploads that was added
	 */
	public static com.ejada.atmc.acl.db.model.CLMNajmUploads addCLMNajmUploads(
		com.ejada.atmc.acl.db.model.CLMNajmUploads clmNajmUploads) {

		return getService().addCLMNajmUploads(clmNajmUploads);
	}

	/**
	 * Creates a new clm najm uploads with the primary key. Does not add the clm najm uploads to the database.
	 *
	 * @param id the primary key for the new clm najm uploads
	 * @return the new clm najm uploads
	 */
	public static com.ejada.atmc.acl.db.model.CLMNajmUploads
		createCLMNajmUploads(int id) {

		return getService().createCLMNajmUploads(id);
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
	 * Deletes the clm najm uploads from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMNajmUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clmNajmUploads the clm najm uploads
	 * @return the clm najm uploads that was removed
	 */
	public static com.ejada.atmc.acl.db.model.CLMNajmUploads
		deleteCLMNajmUploads(
			com.ejada.atmc.acl.db.model.CLMNajmUploads clmNajmUploads) {

		return getService().deleteCLMNajmUploads(clmNajmUploads);
	}

	/**
	 * Deletes the clm najm uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMNajmUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the clm najm uploads
	 * @return the clm najm uploads that was removed
	 * @throws PortalException if a clm najm uploads with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.CLMNajmUploads
			deleteCLMNajmUploads(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCLMNajmUploads(id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CLMNajmUploadsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CLMNajmUploadsModelImpl</code>.
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

	public static com.ejada.atmc.acl.db.model.CLMNajmUploads
		fetchCLMNajmUploads(int id) {

		return getService().fetchCLMNajmUploads(id);
	}

	public static java.util.List<Object[]> findFilesNames(String refNo) {
		return getService().findFilesNames(refNo);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.ejada.atmc.acl.db.model.CLMNajmUploadsBankIbanBlobModel
		getBankIbanBlobModel(java.io.Serializable primaryKey) {

		return getService().getBankIbanBlobModel(primaryKey);
	}

	/**
	 * Returns the clm najm uploads with the primary key.
	 *
	 * @param id the primary key of the clm najm uploads
	 * @return the clm najm uploads
	 * @throws PortalException if a clm najm uploads with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.CLMNajmUploads getCLMNajmUploads(
			int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCLMNajmUploads(id);
	}

	/**
	 * Returns a range of all the clm najm uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CLMNajmUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clm najm uploadses
	 * @param end the upper bound of the range of clm najm uploadses (not inclusive)
	 * @return the range of clm najm uploadses
	 */
	public static java.util.List<com.ejada.atmc.acl.db.model.CLMNajmUploads>
		getCLMNajmUploadses(int start, int end) {

		return getService().getCLMNajmUploadses(start, end);
	}

	/**
	 * Returns the number of clm najm uploadses.
	 *
	 * @return the number of clm najm uploadses
	 */
	public static int getCLMNajmUploadsesCount() {
		return getService().getCLMNajmUploadsesCount();
	}

	public static
		com.ejada.atmc.acl.db.model.CLMNajmUploadsDamageEstQuotBlobModel
			getDamageEstQuotBlobModel(java.io.Serializable primaryKey) {

		return getService().getDamageEstQuotBlobModel(primaryKey);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static com.ejada.atmc.acl.db.model.CLMNajmUploadsNajmSlipBlobModel
		getNajmSlipBlobModel(java.io.Serializable primaryKey) {

		return getService().getNajmSlipBlobModel(primaryKey);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.ejada.atmc.acl.db.model.CLMNajmUploadsOwnerIdBlobModel
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

	public static java.io.InputStream openBankIbanInputStream(long id) {
		return getService().openBankIbanInputStream(id);
	}

	public static java.io.InputStream openDamageEstQuotInputStream(long id) {
		return getService().openDamageEstQuotInputStream(id);
	}

	public static java.io.InputStream openNajmSlipInputStream(long id) {
		return getService().openNajmSlipInputStream(id);
	}

	public static java.io.InputStream openOwnerIdInputStream(long id) {
		return getService().openOwnerIdInputStream(id);
	}

	/**
	 * Updates the clm najm uploads in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMNajmUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clmNajmUploads the clm najm uploads
	 * @return the clm najm uploads that was updated
	 */
	public static com.ejada.atmc.acl.db.model.CLMNajmUploads
		updateCLMNajmUploads(
			com.ejada.atmc.acl.db.model.CLMNajmUploads clmNajmUploads) {

		return getService().updateCLMNajmUploads(clmNajmUploads);
	}

	public static CLMNajmUploadsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CLMNajmUploadsLocalService, CLMNajmUploadsLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CLMNajmUploadsLocalService.class);

		ServiceTracker<CLMNajmUploadsLocalService, CLMNajmUploadsLocalService>
			serviceTracker =
				new ServiceTracker
					<CLMNajmUploadsLocalService, CLMNajmUploadsLocalService>(
						bundle.getBundleContext(),
						CLMNajmUploadsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}