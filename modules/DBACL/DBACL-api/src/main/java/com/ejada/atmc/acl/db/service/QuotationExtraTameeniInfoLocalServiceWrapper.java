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
 * Provides a wrapper for {@link QuotationExtraTameeniInfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationExtraTameeniInfoLocalService
 * @generated
 */
public class QuotationExtraTameeniInfoLocalServiceWrapper
	implements QuotationExtraTameeniInfoLocalService,
			   ServiceWrapper<QuotationExtraTameeniInfoLocalService> {

	public QuotationExtraTameeniInfoLocalServiceWrapper(
		QuotationExtraTameeniInfoLocalService
			quotationExtraTameeniInfoLocalService) {

		_quotationExtraTameeniInfoLocalService =
			quotationExtraTameeniInfoLocalService;
	}

	/**
	 * Adds the quotation extra tameeni info to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationExtraTameeniInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationExtraTameeniInfo the quotation extra tameeni info
	 * @return the quotation extra tameeni info that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationExtraTameeniInfo
		addQuotationExtraTameeniInfo(
			com.ejada.atmc.acl.db.model.QuotationExtraTameeniInfo
				quotationExtraTameeniInfo) {

		return _quotationExtraTameeniInfoLocalService.
			addQuotationExtraTameeniInfo(quotationExtraTameeniInfo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationExtraTameeniInfoLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new quotation extra tameeni info with the primary key. Does not add the quotation extra tameeni info to the database.
	 *
	 * @param quotationId the primary key for the new quotation extra tameeni info
	 * @return the new quotation extra tameeni info
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationExtraTameeniInfo
		createQuotationExtraTameeniInfo(long quotationId) {

		return _quotationExtraTameeniInfoLocalService.
			createQuotationExtraTameeniInfo(quotationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationExtraTameeniInfoLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the quotation extra tameeni info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationExtraTameeniInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationId the primary key of the quotation extra tameeni info
	 * @return the quotation extra tameeni info that was removed
	 * @throws PortalException if a quotation extra tameeni info with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationExtraTameeniInfo
			deleteQuotationExtraTameeniInfo(long quotationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationExtraTameeniInfoLocalService.
			deleteQuotationExtraTameeniInfo(quotationId);
	}

	/**
	 * Deletes the quotation extra tameeni info from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationExtraTameeniInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationExtraTameeniInfo the quotation extra tameeni info
	 * @return the quotation extra tameeni info that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationExtraTameeniInfo
		deleteQuotationExtraTameeniInfo(
			com.ejada.atmc.acl.db.model.QuotationExtraTameeniInfo
				quotationExtraTameeniInfo) {

		return _quotationExtraTameeniInfoLocalService.
			deleteQuotationExtraTameeniInfo(quotationExtraTameeniInfo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _quotationExtraTameeniInfoLocalService.dynamicQuery();
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

		return _quotationExtraTameeniInfoLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationExtraTameeniInfoModelImpl</code>.
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

		return _quotationExtraTameeniInfoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationExtraTameeniInfoModelImpl</code>.
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

		return _quotationExtraTameeniInfoLocalService.dynamicQuery(
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

		return _quotationExtraTameeniInfoLocalService.dynamicQueryCount(
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

		return _quotationExtraTameeniInfoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.QuotationExtraTameeniInfo
		fetchQuotationExtraTameeniInfo(long quotationId) {

		return _quotationExtraTameeniInfoLocalService.
			fetchQuotationExtraTameeniInfo(quotationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _quotationExtraTameeniInfoLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _quotationExtraTameeniInfoLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _quotationExtraTameeniInfoLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationExtraTameeniInfoLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the quotation extra tameeni info with the primary key.
	 *
	 * @param quotationId the primary key of the quotation extra tameeni info
	 * @return the quotation extra tameeni info
	 * @throws PortalException if a quotation extra tameeni info with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationExtraTameeniInfo
			getQuotationExtraTameeniInfo(long quotationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationExtraTameeniInfoLocalService.
			getQuotationExtraTameeniInfo(quotationId);
	}

	/**
	 * Returns a range of all the quotation extra tameeni infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationExtraTameeniInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation extra tameeni infos
	 * @param end the upper bound of the range of quotation extra tameeni infos (not inclusive)
	 * @return the range of quotation extra tameeni infos
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.QuotationExtraTameeniInfo>
		getQuotationExtraTameeniInfos(int start, int end) {

		return _quotationExtraTameeniInfoLocalService.
			getQuotationExtraTameeniInfos(start, end);
	}

	/**
	 * Returns the number of quotation extra tameeni infos.
	 *
	 * @return the number of quotation extra tameeni infos
	 */
	@Override
	public int getQuotationExtraTameeniInfosCount() {
		return _quotationExtraTameeniInfoLocalService.
			getQuotationExtraTameeniInfosCount();
	}

	/**
	 * Updates the quotation extra tameeni info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationExtraTameeniInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationExtraTameeniInfo the quotation extra tameeni info
	 * @return the quotation extra tameeni info that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationExtraTameeniInfo
		updateQuotationExtraTameeniInfo(
			com.ejada.atmc.acl.db.model.QuotationExtraTameeniInfo
				quotationExtraTameeniInfo) {

		return _quotationExtraTameeniInfoLocalService.
			updateQuotationExtraTameeniInfo(quotationExtraTameeniInfo);
	}

	@Override
	public QuotationExtraTameeniInfoLocalService getWrappedService() {
		return _quotationExtraTameeniInfoLocalService;
	}

	@Override
	public void setWrappedService(
		QuotationExtraTameeniInfoLocalService
			quotationExtraTameeniInfoLocalService) {

		_quotationExtraTameeniInfoLocalService =
			quotationExtraTameeniInfoLocalService;
	}

	private QuotationExtraTameeniInfoLocalService
		_quotationExtraTameeniInfoLocalService;

}