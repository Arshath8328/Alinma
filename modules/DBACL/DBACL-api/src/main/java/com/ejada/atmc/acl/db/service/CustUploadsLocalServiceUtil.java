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
 * Provides the local service utility for CustUploads. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.CustUploadsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CustUploadsLocalService
 * @generated
 */
public class CustUploadsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.CustUploadsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the cust uploads to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param custUploads the cust uploads
	 * @return the cust uploads that was added
	 */
	public static com.ejada.atmc.acl.db.model.CustUploads addCustUploads(
		com.ejada.atmc.acl.db.model.CustUploads custUploads) {

		return getService().addCustUploads(custUploads);
	}

	/**
	 * Creates a new cust uploads with the primary key. Does not add the cust uploads to the database.
	 *
	 * @param id the primary key for the new cust uploads
	 * @return the new cust uploads
	 */
	public static com.ejada.atmc.acl.db.model.CustUploads createCustUploads(
		long id) {

		return getService().createCustUploads(id);
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
	 * Deletes the cust uploads from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param custUploads the cust uploads
	 * @return the cust uploads that was removed
	 */
	public static com.ejada.atmc.acl.db.model.CustUploads deleteCustUploads(
		com.ejada.atmc.acl.db.model.CustUploads custUploads) {

		return getService().deleteCustUploads(custUploads);
	}

	/**
	 * Deletes the cust uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the cust uploads
	 * @return the cust uploads that was removed
	 * @throws PortalException if a cust uploads with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.CustUploads deleteCustUploads(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCustUploads(id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CustUploadsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CustUploadsModelImpl</code>.
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

	public static com.ejada.atmc.acl.db.model.CustUploads fetchCustUploads(
		long id) {

		return getService().fetchCustUploads(id);
	}

	public static long findIdByQuotationId(String quotationId) {
		return getService().findIdByQuotationId(quotationId);
	}

	public static java.sql.Blob findIDFileByFileId(long fileId) {
		return getService().findIDFileByFileId(fileId);
	}

	public static String findidFileNameByQuotationId(String quotationId) {
		return getService().findidFileNameByQuotationId(quotationId);
	}

	public static String findistCardByQuotationId(String quotationId) {
		return getService().findistCardByQuotationId(quotationId);
	}

	public static String findlicenseByQuotationId(String quotationId) {
		return getService().findlicenseByQuotationId(quotationId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.ejada.atmc.acl.db.model.CustUploadsCarBackFileBlobModel
		getCarBackFileBlobModel(java.io.Serializable primaryKey) {

		return getService().getCarBackFileBlobModel(primaryKey);
	}

	public static com.ejada.atmc.acl.db.model.CustUploadsCarFrontFileBlobModel
		getCarFrontFileBlobModel(java.io.Serializable primaryKey) {

		return getService().getCarFrontFileBlobModel(primaryKey);
	}

	public static com.ejada.atmc.acl.db.model.CustUploadsCarLeftFileBlobModel
		getCarLeftFileBlobModel(java.io.Serializable primaryKey) {

		return getService().getCarLeftFileBlobModel(primaryKey);
	}

	public static com.ejada.atmc.acl.db.model.CustUploadsCarRightFileBlobModel
		getCarRightFileBlobModel(java.io.Serializable primaryKey) {

		return getService().getCarRightFileBlobModel(primaryKey);
	}

	/**
	 * Returns the cust uploads with the primary key.
	 *
	 * @param id the primary key of the cust uploads
	 * @return the cust uploads
	 * @throws PortalException if a cust uploads with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.CustUploads getCustUploads(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCustUploads(id);
	}

	/**
	 * Returns a range of all the cust uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CustUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cust uploadses
	 * @param end the upper bound of the range of cust uploadses (not inclusive)
	 * @return the range of cust uploadses
	 */
	public static java.util.List<com.ejada.atmc.acl.db.model.CustUploads>
		getCustUploadses(int start, int end) {

		return getService().getCustUploadses(start, end);
	}

	/**
	 * Returns the number of cust uploadses.
	 *
	 * @return the number of cust uploadses
	 */
	public static int getCustUploadsesCount() {
		return getService().getCustUploadsesCount();
	}

	public static
		com.ejada.atmc.acl.db.model.CustUploadsEngChassisNoFileBlobModel
			getEngChassisNoFileBlobModel(java.io.Serializable primaryKey) {

		return getService().getEngChassisNoFileBlobModel(primaryKey);
	}

	public static com.ejada.atmc.acl.db.model.CustUploadsIdFileBlobModel
		getIdFileBlobModel(java.io.Serializable primaryKey) {

		return getService().getIdFileBlobModel(primaryKey);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static com.ejada.atmc.acl.db.model.CustUploadsIstCardFileBlobModel
		getIstCardFileBlobModel(java.io.Serializable primaryKey) {

		return getService().getIstCardFileBlobModel(primaryKey);
	}

	public static com.ejada.atmc.acl.db.model.CustUploadsLeaseFileBlobModel
		getLeaseFileBlobModel(java.io.Serializable primaryKey) {

		return getService().getLeaseFileBlobModel(primaryKey);
	}

	public static com.ejada.atmc.acl.db.model.CustUploadsLicenseFileBlobModel
		getLicenseFileBlobModel(java.io.Serializable primaryKey) {

		return getService().getLicenseFileBlobModel(primaryKey);
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

	public static java.io.InputStream openCarBackFileInputStream(long id) {
		return getService().openCarBackFileInputStream(id);
	}

	public static java.io.InputStream openCarFrontFileInputStream(long id) {
		return getService().openCarFrontFileInputStream(id);
	}

	public static java.io.InputStream openCarLeftFileInputStream(long id) {
		return getService().openCarLeftFileInputStream(id);
	}

	public static java.io.InputStream openCarRightFileInputStream(long id) {
		return getService().openCarRightFileInputStream(id);
	}

	public static java.io.InputStream openEngChassisNoFileInputStream(long id) {
		return getService().openEngChassisNoFileInputStream(id);
	}

	public static java.io.InputStream openIdFileInputStream(long id) {
		return getService().openIdFileInputStream(id);
	}

	public static java.io.InputStream openIstCardFileInputStream(long id) {
		return getService().openIstCardFileInputStream(id);
	}

	public static java.io.InputStream openLeaseFileInputStream(long id) {
		return getService().openLeaseFileInputStream(id);
	}

	public static java.io.InputStream openLicenseFileInputStream(long id) {
		return getService().openLicenseFileInputStream(id);
	}

	/**
	 * Updates the cust uploads in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param custUploads the cust uploads
	 * @return the cust uploads that was updated
	 */
	public static com.ejada.atmc.acl.db.model.CustUploads updateCustUploads(
		com.ejada.atmc.acl.db.model.CustUploads custUploads) {

		return getService().updateCustUploads(custUploads);
	}

	public static CustUploadsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CustUploadsLocalService, CustUploadsLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CustUploadsLocalService.class);

		ServiceTracker<CustUploadsLocalService, CustUploadsLocalService>
			serviceTracker =
				new ServiceTracker
					<CustUploadsLocalService, CustUploadsLocalService>(
						bundle.getBundleContext(),
						CustUploadsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}