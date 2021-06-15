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
 * Provides a wrapper for {@link QuotationsNajmDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsNajmDetailsLocalService
 * @generated
 */
public class QuotationsNajmDetailsLocalServiceWrapper
	implements QuotationsNajmDetailsLocalService,
			   ServiceWrapper<QuotationsNajmDetailsLocalService> {

	public QuotationsNajmDetailsLocalServiceWrapper(
		QuotationsNajmDetailsLocalService quotationsNajmDetailsLocalService) {

		_quotationsNajmDetailsLocalService = quotationsNajmDetailsLocalService;
	}

	/**
	 * Adds the quotations najm details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsNajmDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsNajmDetails the quotations najm details
	 * @return the quotations najm details that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsNajmDetails
		addQuotationsNajmDetails(
			com.ejada.atmc.acl.db.model.QuotationsNajmDetails
				quotationsNajmDetails) {

		return _quotationsNajmDetailsLocalService.addQuotationsNajmDetails(
			quotationsNajmDetails);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsNajmDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new quotations najm details with the primary key. Does not add the quotations najm details to the database.
	 *
	 * @param quotationsNajmDetailsPK the primary key for the new quotations najm details
	 * @return the new quotations najm details
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsNajmDetails
		createQuotationsNajmDetails(
			com.ejada.atmc.acl.db.service.persistence.QuotationsNajmDetailsPK
				quotationsNajmDetailsPK) {

		return _quotationsNajmDetailsLocalService.createQuotationsNajmDetails(
			quotationsNajmDetailsPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsNajmDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the quotations najm details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsNajmDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsNajmDetails the quotations najm details
	 * @return the quotations najm details that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsNajmDetails
		deleteQuotationsNajmDetails(
			com.ejada.atmc.acl.db.model.QuotationsNajmDetails
				quotationsNajmDetails) {

		return _quotationsNajmDetailsLocalService.deleteQuotationsNajmDetails(
			quotationsNajmDetails);
	}

	/**
	 * Deletes the quotations najm details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsNajmDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsNajmDetailsPK the primary key of the quotations najm details
	 * @return the quotations najm details that was removed
	 * @throws PortalException if a quotations najm details with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsNajmDetails
			deleteQuotationsNajmDetails(
				com.ejada.atmc.acl.db.service.persistence.
					QuotationsNajmDetailsPK quotationsNajmDetailsPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsNajmDetailsLocalService.deleteQuotationsNajmDetails(
			quotationsNajmDetailsPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _quotationsNajmDetailsLocalService.dynamicQuery();
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

		return _quotationsNajmDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsNajmDetailsModelImpl</code>.
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

		return _quotationsNajmDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsNajmDetailsModelImpl</code>.
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

		return _quotationsNajmDetailsLocalService.dynamicQuery(
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

		return _quotationsNajmDetailsLocalService.dynamicQueryCount(
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

		return _quotationsNajmDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.QuotationsNajmDetails
		fetchQuotationsNajmDetails(
			com.ejada.atmc.acl.db.service.persistence.QuotationsNajmDetailsPK
				quotationsNajmDetailsPK) {

		return _quotationsNajmDetailsLocalService.fetchQuotationsNajmDetails(
			quotationsNajmDetailsPK);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _quotationsNajmDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsNajmDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the quotations najm details with the primary key.
	 *
	 * @param quotationsNajmDetailsPK the primary key of the quotations najm details
	 * @return the quotations najm details
	 * @throws PortalException if a quotations najm details with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsNajmDetails
			getQuotationsNajmDetails(
				com.ejada.atmc.acl.db.service.persistence.
					QuotationsNajmDetailsPK quotationsNajmDetailsPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsNajmDetailsLocalService.getQuotationsNajmDetails(
			quotationsNajmDetailsPK);
	}

	/**
	 * Returns a range of all the quotations najm detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsNajmDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations najm detailses
	 * @param end the upper bound of the range of quotations najm detailses (not inclusive)
	 * @return the range of quotations najm detailses
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.QuotationsNajmDetails>
		getQuotationsNajmDetailses(int start, int end) {

		return _quotationsNajmDetailsLocalService.getQuotationsNajmDetailses(
			start, end);
	}

	/**
	 * Returns the number of quotations najm detailses.
	 *
	 * @return the number of quotations najm detailses
	 */
	@Override
	public int getQuotationsNajmDetailsesCount() {
		return _quotationsNajmDetailsLocalService.
			getQuotationsNajmDetailsesCount();
	}

	/**
	 * Updates the quotations najm details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsNajmDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsNajmDetails the quotations najm details
	 * @return the quotations najm details that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsNajmDetails
		updateQuotationsNajmDetails(
			com.ejada.atmc.acl.db.model.QuotationsNajmDetails
				quotationsNajmDetails) {

		return _quotationsNajmDetailsLocalService.updateQuotationsNajmDetails(
			quotationsNajmDetails);
	}

	@Override
	public QuotationsNajmDetailsLocalService getWrappedService() {
		return _quotationsNajmDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		QuotationsNajmDetailsLocalService quotationsNajmDetailsLocalService) {

		_quotationsNajmDetailsLocalService = quotationsNajmDetailsLocalService;
	}

	private QuotationsNajmDetailsLocalService
		_quotationsNajmDetailsLocalService;

}