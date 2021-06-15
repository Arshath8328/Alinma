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
 * Provides a wrapper for {@link QuotationDriverseEndorsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationDriverseEndorsLocalService
 * @generated
 */
public class QuotationDriverseEndorsLocalServiceWrapper
	implements QuotationDriverseEndorsLocalService,
			   ServiceWrapper<QuotationDriverseEndorsLocalService> {

	public QuotationDriverseEndorsLocalServiceWrapper(
		QuotationDriverseEndorsLocalService
			quotationDriverseEndorsLocalService) {

		_quotationDriverseEndorsLocalService =
			quotationDriverseEndorsLocalService;
	}

	/**
	 * Adds the quotation driverse endors to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationDriverseEndorsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationDriverseEndors the quotation driverse endors
	 * @return the quotation driverse endors that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationDriverseEndors
		addQuotationDriverseEndors(
			com.ejada.atmc.acl.db.model.QuotationDriverseEndors
				quotationDriverseEndors) {

		return _quotationDriverseEndorsLocalService.addQuotationDriverseEndors(
			quotationDriverseEndors);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationDriverseEndorsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new quotation driverse endors with the primary key. Does not add the quotation driverse endors to the database.
	 *
	 * @param addDriverId the primary key for the new quotation driverse endors
	 * @return the new quotation driverse endors
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationDriverseEndors
		createQuotationDriverseEndors(long addDriverId) {

		return _quotationDriverseEndorsLocalService.
			createQuotationDriverseEndors(addDriverId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationDriverseEndorsLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the quotation driverse endors with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationDriverseEndorsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addDriverId the primary key of the quotation driverse endors
	 * @return the quotation driverse endors that was removed
	 * @throws PortalException if a quotation driverse endors with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationDriverseEndors
			deleteQuotationDriverseEndors(long addDriverId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationDriverseEndorsLocalService.
			deleteQuotationDriverseEndors(addDriverId);
	}

	/**
	 * Deletes the quotation driverse endors from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationDriverseEndorsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationDriverseEndors the quotation driverse endors
	 * @return the quotation driverse endors that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationDriverseEndors
		deleteQuotationDriverseEndors(
			com.ejada.atmc.acl.db.model.QuotationDriverseEndors
				quotationDriverseEndors) {

		return _quotationDriverseEndorsLocalService.
			deleteQuotationDriverseEndors(quotationDriverseEndors);
	}

	@Override
	public com.ejada.atmc.acl.db.model.QuotationDriverseEndors driverId(
			String driverId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationDriverseEndorsException {

		return _quotationDriverseEndorsLocalService.driverId(driverId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _quotationDriverseEndorsLocalService.dynamicQuery();
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

		return _quotationDriverseEndorsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationDriverseEndorsModelImpl</code>.
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

		return _quotationDriverseEndorsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationDriverseEndorsModelImpl</code>.
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

		return _quotationDriverseEndorsLocalService.dynamicQuery(
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

		return _quotationDriverseEndorsLocalService.dynamicQueryCount(
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

		return _quotationDriverseEndorsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.QuotationDriverseEndors
		fetchQuotationDriverseEndors(long addDriverId) {

		return _quotationDriverseEndorsLocalService.
			fetchQuotationDriverseEndors(addDriverId);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.QuotationDriverseEndors>
		findAllDrivEndorsByStatus(String status) {

		return _quotationDriverseEndorsLocalService.findAllDrivEndorsByStatus(
			status);
	}

	@Override
	public com.ejada.atmc.acl.db.model.QuotationDriverseEndors
			findByPolicyNumber(String policyNumber)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationDriverseEndorsException {

		return _quotationDriverseEndorsLocalService.findByPolicyNumber(
			policyNumber);
	}

	@Override
	public com.ejada.atmc.acl.db.model.QuotationDriverseEndors
			findEachDrivEndorsByStatus(String status)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchQuotationDriverseEndorsException {

		return _quotationDriverseEndorsLocalService.findEachDrivEndorsByStatus(
			status);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _quotationDriverseEndorsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _quotationDriverseEndorsLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public com.ejada.atmc.acl.db.model.
		QuotationDriverseEndorsInsuredRelationProofBlobModel
			getInsuredRelationProofBlobModel(java.io.Serializable primaryKey) {

		return _quotationDriverseEndorsLocalService.
			getInsuredRelationProofBlobModel(primaryKey);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _quotationDriverseEndorsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationDriverseEndorsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the quotation driverse endors with the primary key.
	 *
	 * @param addDriverId the primary key of the quotation driverse endors
	 * @return the quotation driverse endors
	 * @throws PortalException if a quotation driverse endors with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationDriverseEndors
			getQuotationDriverseEndors(long addDriverId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationDriverseEndorsLocalService.getQuotationDriverseEndors(
			addDriverId);
	}

	/**
	 * Returns a range of all the quotation driverse endorses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationDriverseEndorsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation driverse endorses
	 * @param end the upper bound of the range of quotation driverse endorses (not inclusive)
	 * @return the range of quotation driverse endorses
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.QuotationDriverseEndors>
		getQuotationDriverseEndorses(int start, int end) {

		return _quotationDriverseEndorsLocalService.
			getQuotationDriverseEndorses(start, end);
	}

	/**
	 * Returns the number of quotation driverse endorses.
	 *
	 * @return the number of quotation driverse endorses
	 */
	@Override
	public int getQuotationDriverseEndorsesCount() {
		return _quotationDriverseEndorsLocalService.
			getQuotationDriverseEndorsesCount();
	}

	@Override
	public java.io.InputStream openInsuredRelationProofInputStream(
		long addDriverId) {

		return _quotationDriverseEndorsLocalService.
			openInsuredRelationProofInputStream(addDriverId);
	}

	/**
	 * Updates the quotation driverse endors in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationDriverseEndorsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationDriverseEndors the quotation driverse endors
	 * @return the quotation driverse endors that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationDriverseEndors
		updateQuotationDriverseEndors(
			com.ejada.atmc.acl.db.model.QuotationDriverseEndors
				quotationDriverseEndors) {

		return _quotationDriverseEndorsLocalService.
			updateQuotationDriverseEndors(quotationDriverseEndors);
	}

	@Override
	public QuotationDriverseEndorsLocalService getWrappedService() {
		return _quotationDriverseEndorsLocalService;
	}

	@Override
	public void setWrappedService(
		QuotationDriverseEndorsLocalService
			quotationDriverseEndorsLocalService) {

		_quotationDriverseEndorsLocalService =
			quotationDriverseEndorsLocalService;
	}

	private QuotationDriverseEndorsLocalService
		_quotationDriverseEndorsLocalService;

}