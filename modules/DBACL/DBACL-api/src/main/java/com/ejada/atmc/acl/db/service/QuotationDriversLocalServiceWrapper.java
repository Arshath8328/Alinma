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
 * Provides a wrapper for {@link QuotationDriversLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationDriversLocalService
 * @generated
 */
public class QuotationDriversLocalServiceWrapper
	implements QuotationDriversLocalService,
			   ServiceWrapper<QuotationDriversLocalService> {

	public QuotationDriversLocalServiceWrapper(
		QuotationDriversLocalService quotationDriversLocalService) {

		_quotationDriversLocalService = quotationDriversLocalService;
	}

	/**
	 * Adds the quotation drivers to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationDriversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationDrivers the quotation drivers
	 * @return the quotation drivers that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationDrivers addQuotationDrivers(
		com.ejada.atmc.acl.db.model.QuotationDrivers quotationDrivers) {

		return _quotationDriversLocalService.addQuotationDrivers(
			quotationDrivers);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationDriversLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new quotation drivers with the primary key. Does not add the quotation drivers to the database.
	 *
	 * @param addDriverId the primary key for the new quotation drivers
	 * @return the new quotation drivers
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationDrivers createQuotationDrivers(
		long addDriverId) {

		return _quotationDriversLocalService.createQuotationDrivers(
			addDriverId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationDriversLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the quotation drivers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationDriversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addDriverId the primary key of the quotation drivers
	 * @return the quotation drivers that was removed
	 * @throws PortalException if a quotation drivers with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationDrivers deleteQuotationDrivers(
			long addDriverId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationDriversLocalService.deleteQuotationDrivers(
			addDriverId);
	}

	/**
	 * Deletes the quotation drivers from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationDriversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationDrivers the quotation drivers
	 * @return the quotation drivers that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationDrivers deleteQuotationDrivers(
		com.ejada.atmc.acl.db.model.QuotationDrivers quotationDrivers) {

		return _quotationDriversLocalService.deleteQuotationDrivers(
			quotationDrivers);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _quotationDriversLocalService.dynamicQuery();
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

		return _quotationDriversLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationDriversModelImpl</code>.
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

		return _quotationDriversLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationDriversModelImpl</code>.
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

		return _quotationDriversLocalService.dynamicQuery(
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

		return _quotationDriversLocalService.dynamicQueryCount(dynamicQuery);
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

		return _quotationDriversLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.QuotationDrivers fetchQuotationDrivers(
		long addDriverId) {

		return _quotationDriversLocalService.fetchQuotationDrivers(addDriverId);
	}

	@Override
	public com.ejada.atmc.acl.db.model.QuotationDrivers
			findByAddDriverIdQuotationId(long quotationId, long addDriverId)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationDriversException {

		return _quotationDriversLocalService.findByAddDriverIdQuotationId(
			quotationId, addDriverId);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.QuotationDrivers>
		findByQuotationId(long quotationId) {

		return _quotationDriversLocalService.findByQuotationId(quotationId);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.QuotationDrivers>
		findUnderAgeDriversByQuotationId(long quotationId) {

		return _quotationDriversLocalService.findUnderAgeDriversByQuotationId(
			quotationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _quotationDriversLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _quotationDriversLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public
		com.ejada.atmc.acl.db.model.
			QuotationDriversInsuredRelationProofBlobModel
				getInsuredRelationProofBlobModel(
					java.io.Serializable primaryKey) {

		return _quotationDriversLocalService.getInsuredRelationProofBlobModel(
			primaryKey);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _quotationDriversLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationDriversLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the quotation drivers with the primary key.
	 *
	 * @param addDriverId the primary key of the quotation drivers
	 * @return the quotation drivers
	 * @throws PortalException if a quotation drivers with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationDrivers getQuotationDrivers(
			long addDriverId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationDriversLocalService.getQuotationDrivers(addDriverId);
	}

	/**
	 * Returns a range of all the quotation driverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @return the range of quotation driverses
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.QuotationDrivers>
		getQuotationDriverses(int start, int end) {

		return _quotationDriversLocalService.getQuotationDriverses(start, end);
	}

	/**
	 * Returns the number of quotation driverses.
	 *
	 * @return the number of quotation driverses
	 */
	@Override
	public int getQuotationDriversesCount() {
		return _quotationDriversLocalService.getQuotationDriversesCount();
	}

	@Override
	public java.io.InputStream openInsuredRelationProofInputStream(
		long addDriverId) {

		return _quotationDriversLocalService.
			openInsuredRelationProofInputStream(addDriverId);
	}

	/**
	 * Updates the quotation drivers in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationDriversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationDrivers the quotation drivers
	 * @return the quotation drivers that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationDrivers updateQuotationDrivers(
		com.ejada.atmc.acl.db.model.QuotationDrivers quotationDrivers) {

		return _quotationDriversLocalService.updateQuotationDrivers(
			quotationDrivers);
	}

	@Override
	public QuotationDriversLocalService getWrappedService() {
		return _quotationDriversLocalService;
	}

	@Override
	public void setWrappedService(
		QuotationDriversLocalService quotationDriversLocalService) {

		_quotationDriversLocalService = quotationDriversLocalService;
	}

	private QuotationDriversLocalService _quotationDriversLocalService;

}