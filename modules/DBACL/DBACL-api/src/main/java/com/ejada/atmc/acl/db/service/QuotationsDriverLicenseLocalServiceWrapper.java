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
 * Provides a wrapper for {@link QuotationsDriverLicenseLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsDriverLicenseLocalService
 * @generated
 */
public class QuotationsDriverLicenseLocalServiceWrapper
	implements QuotationsDriverLicenseLocalService,
			   ServiceWrapper<QuotationsDriverLicenseLocalService> {

	public QuotationsDriverLicenseLocalServiceWrapper(
		QuotationsDriverLicenseLocalService
			quotationsDriverLicenseLocalService) {

		_quotationsDriverLicenseLocalService =
			quotationsDriverLicenseLocalService;
	}

	/**
	 * Adds the quotations driver license to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsDriverLicenseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsDriverLicense the quotations driver license
	 * @return the quotations driver license that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsDriverLicense
		addQuotationsDriverLicense(
			com.ejada.atmc.acl.db.model.QuotationsDriverLicense
				quotationsDriverLicense) {

		return _quotationsDriverLicenseLocalService.addQuotationsDriverLicense(
			quotationsDriverLicense);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsDriverLicenseLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new quotations driver license with the primary key. Does not add the quotations driver license to the database.
	 *
	 * @param licenseId the primary key for the new quotations driver license
	 * @return the new quotations driver license
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsDriverLicense
		createQuotationsDriverLicense(long licenseId) {

		return _quotationsDriverLicenseLocalService.
			createQuotationsDriverLicense(licenseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsDriverLicenseLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the quotations driver license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsDriverLicenseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param licenseId the primary key of the quotations driver license
	 * @return the quotations driver license that was removed
	 * @throws PortalException if a quotations driver license with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsDriverLicense
			deleteQuotationsDriverLicense(long licenseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsDriverLicenseLocalService.
			deleteQuotationsDriverLicense(licenseId);
	}

	/**
	 * Deletes the quotations driver license from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsDriverLicenseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsDriverLicense the quotations driver license
	 * @return the quotations driver license that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsDriverLicense
		deleteQuotationsDriverLicense(
			com.ejada.atmc.acl.db.model.QuotationsDriverLicense
				quotationsDriverLicense) {

		return _quotationsDriverLicenseLocalService.
			deleteQuotationsDriverLicense(quotationsDriverLicense);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _quotationsDriverLicenseLocalService.dynamicQuery();
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

		return _quotationsDriverLicenseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsDriverLicenseModelImpl</code>.
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

		return _quotationsDriverLicenseLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsDriverLicenseModelImpl</code>.
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

		return _quotationsDriverLicenseLocalService.dynamicQuery(
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

		return _quotationsDriverLicenseLocalService.dynamicQueryCount(
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

		return _quotationsDriverLicenseLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.QuotationsDriverLicense
		fetchQuotationsDriverLicense(long licenseId) {

		return _quotationsDriverLicenseLocalService.
			fetchQuotationsDriverLicense(licenseId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _quotationsDriverLicenseLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _quotationsDriverLicenseLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _quotationsDriverLicenseLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsDriverLicenseLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the quotations driver license with the primary key.
	 *
	 * @param licenseId the primary key of the quotations driver license
	 * @return the quotations driver license
	 * @throws PortalException if a quotations driver license with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsDriverLicense
			getQuotationsDriverLicense(long licenseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsDriverLicenseLocalService.getQuotationsDriverLicense(
			licenseId);
	}

	/**
	 * Returns a range of all the quotations driver licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsDriverLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations driver licenses
	 * @param end the upper bound of the range of quotations driver licenses (not inclusive)
	 * @return the range of quotations driver licenses
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.QuotationsDriverLicense>
		getQuotationsDriverLicenses(int start, int end) {

		return _quotationsDriverLicenseLocalService.getQuotationsDriverLicenses(
			start, end);
	}

	/**
	 * Returns the number of quotations driver licenses.
	 *
	 * @return the number of quotations driver licenses
	 */
	@Override
	public int getQuotationsDriverLicensesCount() {
		return _quotationsDriverLicenseLocalService.
			getQuotationsDriverLicensesCount();
	}

	/**
	 * Updates the quotations driver license in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsDriverLicenseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsDriverLicense the quotations driver license
	 * @return the quotations driver license that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsDriverLicense
		updateQuotationsDriverLicense(
			com.ejada.atmc.acl.db.model.QuotationsDriverLicense
				quotationsDriverLicense) {

		return _quotationsDriverLicenseLocalService.
			updateQuotationsDriverLicense(quotationsDriverLicense);
	}

	@Override
	public QuotationsDriverLicenseLocalService getWrappedService() {
		return _quotationsDriverLicenseLocalService;
	}

	@Override
	public void setWrappedService(
		QuotationsDriverLicenseLocalService
			quotationsDriverLicenseLocalService) {

		_quotationsDriverLicenseLocalService =
			quotationsDriverLicenseLocalService;
	}

	private QuotationsDriverLicenseLocalService
		_quotationsDriverLicenseLocalService;

}