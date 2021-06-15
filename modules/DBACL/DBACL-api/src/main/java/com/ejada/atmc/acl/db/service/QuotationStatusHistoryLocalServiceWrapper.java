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
 * Provides a wrapper for {@link QuotationStatusHistoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationStatusHistoryLocalService
 * @generated
 */
public class QuotationStatusHistoryLocalServiceWrapper
	implements QuotationStatusHistoryLocalService,
			   ServiceWrapper<QuotationStatusHistoryLocalService> {

	public QuotationStatusHistoryLocalServiceWrapper(
		QuotationStatusHistoryLocalService quotationStatusHistoryLocalService) {

		_quotationStatusHistoryLocalService =
			quotationStatusHistoryLocalService;
	}

	/**
	 * Adds the quotation status history to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationStatusHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationStatusHistory the quotation status history
	 * @return the quotation status history that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationStatusHistory
		addQuotationStatusHistory(
			com.ejada.atmc.acl.db.model.QuotationStatusHistory
				quotationStatusHistory) {

		return _quotationStatusHistoryLocalService.addQuotationStatusHistory(
			quotationStatusHistory);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationStatusHistoryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new quotation status history with the primary key. Does not add the quotation status history to the database.
	 *
	 * @param historyId the primary key for the new quotation status history
	 * @return the new quotation status history
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationStatusHistory
		createQuotationStatusHistory(long historyId) {

		return _quotationStatusHistoryLocalService.createQuotationStatusHistory(
			historyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationStatusHistoryLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the quotation status history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationStatusHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param historyId the primary key of the quotation status history
	 * @return the quotation status history that was removed
	 * @throws PortalException if a quotation status history with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationStatusHistory
			deleteQuotationStatusHistory(long historyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationStatusHistoryLocalService.deleteQuotationStatusHistory(
			historyId);
	}

	/**
	 * Deletes the quotation status history from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationStatusHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationStatusHistory the quotation status history
	 * @return the quotation status history that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationStatusHistory
		deleteQuotationStatusHistory(
			com.ejada.atmc.acl.db.model.QuotationStatusHistory
				quotationStatusHistory) {

		return _quotationStatusHistoryLocalService.deleteQuotationStatusHistory(
			quotationStatusHistory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _quotationStatusHistoryLocalService.dynamicQuery();
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

		return _quotationStatusHistoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationStatusHistoryModelImpl</code>.
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

		return _quotationStatusHistoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationStatusHistoryModelImpl</code>.
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

		return _quotationStatusHistoryLocalService.dynamicQuery(
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

		return _quotationStatusHistoryLocalService.dynamicQueryCount(
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

		return _quotationStatusHistoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.QuotationStatusHistory
		fetchQuotationStatusHistory(long historyId) {

		return _quotationStatusHistoryLocalService.fetchQuotationStatusHistory(
			historyId);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.QuotationStatusHistory>
		findByQuotationId(long qID) {

		return _quotationStatusHistoryLocalService.findByQuotationId(qID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _quotationStatusHistoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _quotationStatusHistoryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _quotationStatusHistoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationStatusHistoryLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns a range of all the quotation status histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationStatusHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation status histories
	 * @param end the upper bound of the range of quotation status histories (not inclusive)
	 * @return the range of quotation status histories
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.QuotationStatusHistory>
		getQuotationStatusHistories(int start, int end) {

		return _quotationStatusHistoryLocalService.getQuotationStatusHistories(
			start, end);
	}

	/**
	 * Returns the number of quotation status histories.
	 *
	 * @return the number of quotation status histories
	 */
	@Override
	public int getQuotationStatusHistoriesCount() {
		return _quotationStatusHistoryLocalService.
			getQuotationStatusHistoriesCount();
	}

	/**
	 * Returns the quotation status history with the primary key.
	 *
	 * @param historyId the primary key of the quotation status history
	 * @return the quotation status history
	 * @throws PortalException if a quotation status history with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationStatusHistory
			getQuotationStatusHistory(long historyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationStatusHistoryLocalService.getQuotationStatusHistory(
			historyId);
	}

	/**
	 * Updates the quotation status history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationStatusHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationStatusHistory the quotation status history
	 * @return the quotation status history that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationStatusHistory
		updateQuotationStatusHistory(
			com.ejada.atmc.acl.db.model.QuotationStatusHistory
				quotationStatusHistory) {

		return _quotationStatusHistoryLocalService.updateQuotationStatusHistory(
			quotationStatusHistory);
	}

	@Override
	public QuotationStatusHistoryLocalService getWrappedService() {
		return _quotationStatusHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		QuotationStatusHistoryLocalService quotationStatusHistoryLocalService) {

		_quotationStatusHistoryLocalService =
			quotationStatusHistoryLocalService;
	}

	private QuotationStatusHistoryLocalService
		_quotationStatusHistoryLocalService;

}