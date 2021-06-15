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
 * Provides a wrapper for {@link QuotationSurveyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationSurveyLocalService
 * @generated
 */
public class QuotationSurveyLocalServiceWrapper
	implements QuotationSurveyLocalService,
			   ServiceWrapper<QuotationSurveyLocalService> {

	public QuotationSurveyLocalServiceWrapper(
		QuotationSurveyLocalService quotationSurveyLocalService) {

		_quotationSurveyLocalService = quotationSurveyLocalService;
	}

	/**
	 * Adds the quotation survey to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationSurveyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationSurvey the quotation survey
	 * @return the quotation survey that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationSurvey addQuotationSurvey(
		com.ejada.atmc.acl.db.model.QuotationSurvey quotationSurvey) {

		return _quotationSurveyLocalService.addQuotationSurvey(quotationSurvey);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationSurveyLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new quotation survey with the primary key. Does not add the quotation survey to the database.
	 *
	 * @param surveyId the primary key for the new quotation survey
	 * @return the new quotation survey
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationSurvey createQuotationSurvey(
		long surveyId) {

		return _quotationSurveyLocalService.createQuotationSurvey(surveyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationSurveyLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the quotation survey with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationSurveyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param surveyId the primary key of the quotation survey
	 * @return the quotation survey that was removed
	 * @throws PortalException if a quotation survey with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationSurvey deleteQuotationSurvey(
			long surveyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationSurveyLocalService.deleteQuotationSurvey(surveyId);
	}

	/**
	 * Deletes the quotation survey from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationSurveyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationSurvey the quotation survey
	 * @return the quotation survey that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationSurvey deleteQuotationSurvey(
		com.ejada.atmc.acl.db.model.QuotationSurvey quotationSurvey) {

		return _quotationSurveyLocalService.deleteQuotationSurvey(
			quotationSurvey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _quotationSurveyLocalService.dynamicQuery();
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

		return _quotationSurveyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationSurveyModelImpl</code>.
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

		return _quotationSurveyLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationSurveyModelImpl</code>.
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

		return _quotationSurveyLocalService.dynamicQuery(
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

		return _quotationSurveyLocalService.dynamicQueryCount(dynamicQuery);
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

		return _quotationSurveyLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.QuotationSurvey fetchQuotationSurvey(
		long surveyId) {

		return _quotationSurveyLocalService.fetchQuotationSurvey(surveyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _quotationSurveyLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _quotationSurveyLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _quotationSurveyLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationSurveyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the quotation survey with the primary key.
	 *
	 * @param surveyId the primary key of the quotation survey
	 * @return the quotation survey
	 * @throws PortalException if a quotation survey with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationSurvey getQuotationSurvey(
			long surveyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationSurveyLocalService.getQuotationSurvey(surveyId);
	}

	/**
	 * Returns a range of all the quotation surveys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationSurveyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation surveys
	 * @param end the upper bound of the range of quotation surveys (not inclusive)
	 * @return the range of quotation surveys
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.QuotationSurvey>
		getQuotationSurveys(int start, int end) {

		return _quotationSurveyLocalService.getQuotationSurveys(start, end);
	}

	/**
	 * Returns the number of quotation surveys.
	 *
	 * @return the number of quotation surveys
	 */
	@Override
	public int getQuotationSurveysCount() {
		return _quotationSurveyLocalService.getQuotationSurveysCount();
	}

	@Override
	public com.ejada.atmc.acl.db.model.QuotationSurveySurveyVideoFileBlobModel
		getSurveyVideoFileBlobModel(java.io.Serializable primaryKey) {

		return _quotationSurveyLocalService.getSurveyVideoFileBlobModel(
			primaryKey);
	}

	@Override
	public java.io.InputStream openSurveyVideoFileInputStream(long surveyId) {
		return _quotationSurveyLocalService.openSurveyVideoFileInputStream(
			surveyId);
	}

	/**
	 * Updates the quotation survey in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationSurveyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationSurvey the quotation survey
	 * @return the quotation survey that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationSurvey updateQuotationSurvey(
		com.ejada.atmc.acl.db.model.QuotationSurvey quotationSurvey) {

		return _quotationSurveyLocalService.updateQuotationSurvey(
			quotationSurvey);
	}

	@Override
	public QuotationSurveyLocalService getWrappedService() {
		return _quotationSurveyLocalService;
	}

	@Override
	public void setWrappedService(
		QuotationSurveyLocalService quotationSurveyLocalService) {

		_quotationSurveyLocalService = quotationSurveyLocalService;
	}

	private QuotationSurveyLocalService _quotationSurveyLocalService;

}