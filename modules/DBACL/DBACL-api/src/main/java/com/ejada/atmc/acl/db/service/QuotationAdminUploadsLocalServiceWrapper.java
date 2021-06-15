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
 * Provides a wrapper for {@link QuotationAdminUploadsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationAdminUploadsLocalService
 * @generated
 */
public class QuotationAdminUploadsLocalServiceWrapper
	implements QuotationAdminUploadsLocalService,
			   ServiceWrapper<QuotationAdminUploadsLocalService> {

	public QuotationAdminUploadsLocalServiceWrapper(
		QuotationAdminUploadsLocalService quotationAdminUploadsLocalService) {

		_quotationAdminUploadsLocalService = quotationAdminUploadsLocalService;
	}

	/**
	 * Adds the quotation admin uploads to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationAdminUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationAdminUploads the quotation admin uploads
	 * @return the quotation admin uploads that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationAdminUploads
		addQuotationAdminUploads(
			com.ejada.atmc.acl.db.model.QuotationAdminUploads
				quotationAdminUploads) {

		return _quotationAdminUploadsLocalService.addQuotationAdminUploads(
			quotationAdminUploads);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationAdminUploadsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new quotation admin uploads with the primary key. Does not add the quotation admin uploads to the database.
	 *
	 * @param id the primary key for the new quotation admin uploads
	 * @return the new quotation admin uploads
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationAdminUploads
		createQuotationAdminUploads(int id) {

		return _quotationAdminUploadsLocalService.createQuotationAdminUploads(
			id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationAdminUploadsLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the quotation admin uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationAdminUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the quotation admin uploads
	 * @return the quotation admin uploads that was removed
	 * @throws PortalException if a quotation admin uploads with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationAdminUploads
			deleteQuotationAdminUploads(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationAdminUploadsLocalService.deleteQuotationAdminUploads(
			id);
	}

	/**
	 * Deletes the quotation admin uploads from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationAdminUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationAdminUploads the quotation admin uploads
	 * @return the quotation admin uploads that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationAdminUploads
		deleteQuotationAdminUploads(
			com.ejada.atmc.acl.db.model.QuotationAdminUploads
				quotationAdminUploads) {

		return _quotationAdminUploadsLocalService.deleteQuotationAdminUploads(
			quotationAdminUploads);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _quotationAdminUploadsLocalService.dynamicQuery();
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

		return _quotationAdminUploadsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationAdminUploadsModelImpl</code>.
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

		return _quotationAdminUploadsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationAdminUploadsModelImpl</code>.
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

		return _quotationAdminUploadsLocalService.dynamicQuery(
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

		return _quotationAdminUploadsLocalService.dynamicQueryCount(
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

		return _quotationAdminUploadsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.QuotationAdminUploads
		fetchQuotationAdminUploads(int id) {

		return _quotationAdminUploadsLocalService.fetchQuotationAdminUploads(
			id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _quotationAdminUploadsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.ejada.atmc.acl.db.model.QuotationAdminUploadsAdminFileBlobModel
		getAdminFileBlobModel(java.io.Serializable primaryKey) {

		return _quotationAdminUploadsLocalService.getAdminFileBlobModel(
			primaryKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _quotationAdminUploadsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _quotationAdminUploadsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationAdminUploadsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the quotation admin uploads with the primary key.
	 *
	 * @param id the primary key of the quotation admin uploads
	 * @return the quotation admin uploads
	 * @throws PortalException if a quotation admin uploads with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationAdminUploads
			getQuotationAdminUploads(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationAdminUploadsLocalService.getQuotationAdminUploads(id);
	}

	/**
	 * Returns a range of all the quotation admin uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation admin uploadses
	 * @param end the upper bound of the range of quotation admin uploadses (not inclusive)
	 * @return the range of quotation admin uploadses
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.QuotationAdminUploads>
		getQuotationAdminUploadses(int start, int end) {

		return _quotationAdminUploadsLocalService.getQuotationAdminUploadses(
			start, end);
	}

	/**
	 * Returns the number of quotation admin uploadses.
	 *
	 * @return the number of quotation admin uploadses
	 */
	@Override
	public int getQuotationAdminUploadsesCount() {
		return _quotationAdminUploadsLocalService.
			getQuotationAdminUploadsesCount();
	}

	@Override
	public java.io.InputStream openAdminFileInputStream(long id) {
		return _quotationAdminUploadsLocalService.openAdminFileInputStream(id);
	}

	/**
	 * Updates the quotation admin uploads in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationAdminUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationAdminUploads the quotation admin uploads
	 * @return the quotation admin uploads that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationAdminUploads
		updateQuotationAdminUploads(
			com.ejada.atmc.acl.db.model.QuotationAdminUploads
				quotationAdminUploads) {

		return _quotationAdminUploadsLocalService.updateQuotationAdminUploads(
			quotationAdminUploads);
	}

	@Override
	public QuotationAdminUploadsLocalService getWrappedService() {
		return _quotationAdminUploadsLocalService;
	}

	@Override
	public void setWrappedService(
		QuotationAdminUploadsLocalService quotationAdminUploadsLocalService) {

		_quotationAdminUploadsLocalService = quotationAdminUploadsLocalService;
	}

	private QuotationAdminUploadsLocalService
		_quotationAdminUploadsLocalService;

}