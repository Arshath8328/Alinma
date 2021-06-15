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
 * Provides a wrapper for {@link QuotationsSeqLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsSeqLocalService
 * @generated
 */
public class QuotationsSeqLocalServiceWrapper
	implements QuotationsSeqLocalService,
			   ServiceWrapper<QuotationsSeqLocalService> {

	public QuotationsSeqLocalServiceWrapper(
		QuotationsSeqLocalService quotationsSeqLocalService) {

		_quotationsSeqLocalService = quotationsSeqLocalService;
	}

	/**
	 * Adds the quotations seq to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsSeqLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsSeq the quotations seq
	 * @return the quotations seq that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsSeq addQuotationsSeq(
		com.ejada.atmc.acl.db.model.QuotationsSeq quotationsSeq) {

		return _quotationsSeqLocalService.addQuotationsSeq(quotationsSeq);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsSeqLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new quotations seq with the primary key. Does not add the quotations seq to the database.
	 *
	 * @param key the primary key for the new quotations seq
	 * @return the new quotations seq
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsSeq createQuotationsSeq(
		String key) {

		return _quotationsSeqLocalService.createQuotationsSeq(key);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsSeqLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the quotations seq from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsSeqLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsSeq the quotations seq
	 * @return the quotations seq that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsSeq deleteQuotationsSeq(
		com.ejada.atmc.acl.db.model.QuotationsSeq quotationsSeq) {

		return _quotationsSeqLocalService.deleteQuotationsSeq(quotationsSeq);
	}

	/**
	 * Deletes the quotations seq with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsSeqLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param key the primary key of the quotations seq
	 * @return the quotations seq that was removed
	 * @throws PortalException if a quotations seq with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsSeq deleteQuotationsSeq(
			String key)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsSeqLocalService.deleteQuotationsSeq(key);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _quotationsSeqLocalService.dynamicQuery();
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

		return _quotationsSeqLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsSeqModelImpl</code>.
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

		return _quotationsSeqLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsSeqModelImpl</code>.
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

		return _quotationsSeqLocalService.dynamicQuery(
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

		return _quotationsSeqLocalService.dynamicQueryCount(dynamicQuery);
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

		return _quotationsSeqLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.QuotationsSeq fetchQuotationsSeq(
		String key) {

		return _quotationsSeqLocalService.fetchQuotationsSeq(key);
	}

	@Override
	public com.ejada.atmc.acl.db.model.QuotationsSeq findByKey(String key)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsSeqException {

		return _quotationsSeqLocalService.findByKey(key);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _quotationsSeqLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsSeqLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the quotations seq with the primary key.
	 *
	 * @param key the primary key of the quotations seq
	 * @return the quotations seq
	 * @throws PortalException if a quotations seq with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsSeq getQuotationsSeq(
			String key)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationsSeqLocalService.getQuotationsSeq(key);
	}

	/**
	 * Returns a range of all the quotations seqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsSeqModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations seqs
	 * @param end the upper bound of the range of quotations seqs (not inclusive)
	 * @return the range of quotations seqs
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.QuotationsSeq>
		getQuotationsSeqs(int start, int end) {

		return _quotationsSeqLocalService.getQuotationsSeqs(start, end);
	}

	/**
	 * Returns the number of quotations seqs.
	 *
	 * @return the number of quotations seqs
	 */
	@Override
	public int getQuotationsSeqsCount() {
		return _quotationsSeqLocalService.getQuotationsSeqsCount();
	}

	/**
	 * Updates the quotations seq in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsSeqLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsSeq the quotations seq
	 * @return the quotations seq that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.QuotationsSeq updateQuotationsSeq(
		com.ejada.atmc.acl.db.model.QuotationsSeq quotationsSeq) {

		return _quotationsSeqLocalService.updateQuotationsSeq(quotationsSeq);
	}

	@Override
	public QuotationsSeqLocalService getWrappedService() {
		return _quotationsSeqLocalService;
	}

	@Override
	public void setWrappedService(
		QuotationsSeqLocalService quotationsSeqLocalService) {

		_quotationsSeqLocalService = quotationsSeqLocalService;
	}

	private QuotationsSeqLocalService _quotationsSeqLocalService;

}