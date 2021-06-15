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
 * Provides a wrapper for {@link CustUploadsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CustUploadsLocalService
 * @generated
 */
public class CustUploadsLocalServiceWrapper
	implements CustUploadsLocalService,
			   ServiceWrapper<CustUploadsLocalService> {

	public CustUploadsLocalServiceWrapper(
		CustUploadsLocalService custUploadsLocalService) {

		_custUploadsLocalService = custUploadsLocalService;
	}

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
	@Override
	public com.ejada.atmc.acl.db.model.CustUploads addCustUploads(
		com.ejada.atmc.acl.db.model.CustUploads custUploads) {

		return _custUploadsLocalService.addCustUploads(custUploads);
	}

	/**
	 * Creates a new cust uploads with the primary key. Does not add the cust uploads to the database.
	 *
	 * @param id the primary key for the new cust uploads
	 * @return the new cust uploads
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CustUploads createCustUploads(long id) {
		return _custUploadsLocalService.createCustUploads(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _custUploadsLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.ejada.atmc.acl.db.model.CustUploads deleteCustUploads(
		com.ejada.atmc.acl.db.model.CustUploads custUploads) {

		return _custUploadsLocalService.deleteCustUploads(custUploads);
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
	@Override
	public com.ejada.atmc.acl.db.model.CustUploads deleteCustUploads(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _custUploadsLocalService.deleteCustUploads(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _custUploadsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _custUploadsLocalService.dynamicQuery();
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

		return _custUploadsLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _custUploadsLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _custUploadsLocalService.dynamicQuery(
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

		return _custUploadsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _custUploadsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CustUploads fetchCustUploads(long id) {
		return _custUploadsLocalService.fetchCustUploads(id);
	}

	@Override
	public long findIdByQuotationId(String quotationId) {
		return _custUploadsLocalService.findIdByQuotationId(quotationId);
	}

	@Override
	public java.sql.Blob findIDFileByFileId(long fileId) {
		return _custUploadsLocalService.findIDFileByFileId(fileId);
	}

	@Override
	public String findidFileNameByQuotationId(String quotationId) {
		return _custUploadsLocalService.findidFileNameByQuotationId(
			quotationId);
	}

	@Override
	public String findistCardByQuotationId(String quotationId) {
		return _custUploadsLocalService.findistCardByQuotationId(quotationId);
	}

	@Override
	public String findlicenseByQuotationId(String quotationId) {
		return _custUploadsLocalService.findlicenseByQuotationId(quotationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _custUploadsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.ejada.atmc.acl.db.model.CustUploadsCarBackFileBlobModel
		getCarBackFileBlobModel(java.io.Serializable primaryKey) {

		return _custUploadsLocalService.getCarBackFileBlobModel(primaryKey);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CustUploadsCarFrontFileBlobModel
		getCarFrontFileBlobModel(java.io.Serializable primaryKey) {

		return _custUploadsLocalService.getCarFrontFileBlobModel(primaryKey);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CustUploadsCarLeftFileBlobModel
		getCarLeftFileBlobModel(java.io.Serializable primaryKey) {

		return _custUploadsLocalService.getCarLeftFileBlobModel(primaryKey);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CustUploadsCarRightFileBlobModel
		getCarRightFileBlobModel(java.io.Serializable primaryKey) {

		return _custUploadsLocalService.getCarRightFileBlobModel(primaryKey);
	}

	/**
	 * Returns the cust uploads with the primary key.
	 *
	 * @param id the primary key of the cust uploads
	 * @return the cust uploads
	 * @throws PortalException if a cust uploads with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CustUploads getCustUploads(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _custUploadsLocalService.getCustUploads(id);
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
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.CustUploads>
		getCustUploadses(int start, int end) {

		return _custUploadsLocalService.getCustUploadses(start, end);
	}

	/**
	 * Returns the number of cust uploadses.
	 *
	 * @return the number of cust uploadses
	 */
	@Override
	public int getCustUploadsesCount() {
		return _custUploadsLocalService.getCustUploadsesCount();
	}

	@Override
	public com.ejada.atmc.acl.db.model.CustUploadsEngChassisNoFileBlobModel
		getEngChassisNoFileBlobModel(java.io.Serializable primaryKey) {

		return _custUploadsLocalService.getEngChassisNoFileBlobModel(
			primaryKey);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CustUploadsIdFileBlobModel
		getIdFileBlobModel(java.io.Serializable primaryKey) {

		return _custUploadsLocalService.getIdFileBlobModel(primaryKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _custUploadsLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public com.ejada.atmc.acl.db.model.CustUploadsIstCardFileBlobModel
		getIstCardFileBlobModel(java.io.Serializable primaryKey) {

		return _custUploadsLocalService.getIstCardFileBlobModel(primaryKey);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CustUploadsLeaseFileBlobModel
		getLeaseFileBlobModel(java.io.Serializable primaryKey) {

		return _custUploadsLocalService.getLeaseFileBlobModel(primaryKey);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CustUploadsLicenseFileBlobModel
		getLicenseFileBlobModel(java.io.Serializable primaryKey) {

		return _custUploadsLocalService.getLicenseFileBlobModel(primaryKey);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _custUploadsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _custUploadsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.io.InputStream openCarBackFileInputStream(long id) {
		return _custUploadsLocalService.openCarBackFileInputStream(id);
	}

	@Override
	public java.io.InputStream openCarFrontFileInputStream(long id) {
		return _custUploadsLocalService.openCarFrontFileInputStream(id);
	}

	@Override
	public java.io.InputStream openCarLeftFileInputStream(long id) {
		return _custUploadsLocalService.openCarLeftFileInputStream(id);
	}

	@Override
	public java.io.InputStream openCarRightFileInputStream(long id) {
		return _custUploadsLocalService.openCarRightFileInputStream(id);
	}

	@Override
	public java.io.InputStream openEngChassisNoFileInputStream(long id) {
		return _custUploadsLocalService.openEngChassisNoFileInputStream(id);
	}

	@Override
	public java.io.InputStream openIdFileInputStream(long id) {
		return _custUploadsLocalService.openIdFileInputStream(id);
	}

	@Override
	public java.io.InputStream openIstCardFileInputStream(long id) {
		return _custUploadsLocalService.openIstCardFileInputStream(id);
	}

	@Override
	public java.io.InputStream openLeaseFileInputStream(long id) {
		return _custUploadsLocalService.openLeaseFileInputStream(id);
	}

	@Override
	public java.io.InputStream openLicenseFileInputStream(long id) {
		return _custUploadsLocalService.openLicenseFileInputStream(id);
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
	@Override
	public com.ejada.atmc.acl.db.model.CustUploads updateCustUploads(
		com.ejada.atmc.acl.db.model.CustUploads custUploads) {

		return _custUploadsLocalService.updateCustUploads(custUploads);
	}

	@Override
	public CustUploadsLocalService getWrappedService() {
		return _custUploadsLocalService;
	}

	@Override
	public void setWrappedService(
		CustUploadsLocalService custUploadsLocalService) {

		_custUploadsLocalService = custUploadsLocalService;
	}

	private CustUploadsLocalService _custUploadsLocalService;

}