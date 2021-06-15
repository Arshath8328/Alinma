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
 * Provides a wrapper for {@link CLMSTATUSHISTORYLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CLMSTATUSHISTORYLocalService
 * @generated
 */
public class CLMSTATUSHISTORYLocalServiceWrapper
	implements CLMSTATUSHISTORYLocalService,
			   ServiceWrapper<CLMSTATUSHISTORYLocalService> {

	public CLMSTATUSHISTORYLocalServiceWrapper(
		CLMSTATUSHISTORYLocalService clmstatushistoryLocalService) {

		_clmstatushistoryLocalService = clmstatushistoryLocalService;
	}

	/**
	 * Adds the clmstatushistory to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMSTATUSHISTORYLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clmstatushistory the clmstatushistory
	 * @return the clmstatushistory that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMSTATUSHISTORY addCLMSTATUSHISTORY(
		com.ejada.atmc.acl.db.model.CLMSTATUSHISTORY clmstatushistory) {

		return _clmstatushistoryLocalService.addCLMSTATUSHISTORY(
			clmstatushistory);
	}

	/**
	 * Creates a new clmstatushistory with the primary key. Does not add the clmstatushistory to the database.
	 *
	 * @param id the primary key for the new clmstatushistory
	 * @return the new clmstatushistory
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMSTATUSHISTORY createCLMSTATUSHISTORY(
		int id) {

		return _clmstatushistoryLocalService.createCLMSTATUSHISTORY(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmstatushistoryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the clmstatushistory from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMSTATUSHISTORYLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clmstatushistory the clmstatushistory
	 * @return the clmstatushistory that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMSTATUSHISTORY deleteCLMSTATUSHISTORY(
		com.ejada.atmc.acl.db.model.CLMSTATUSHISTORY clmstatushistory) {

		return _clmstatushistoryLocalService.deleteCLMSTATUSHISTORY(
			clmstatushistory);
	}

	/**
	 * Deletes the clmstatushistory with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMSTATUSHISTORYLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the clmstatushistory
	 * @return the clmstatushistory that was removed
	 * @throws PortalException if a clmstatushistory with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMSTATUSHISTORY deleteCLMSTATUSHISTORY(
			int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmstatushistoryLocalService.deleteCLMSTATUSHISTORY(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmstatushistoryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _clmstatushistoryLocalService.dynamicQuery();
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

		return _clmstatushistoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CLMSTATUSHISTORYModelImpl</code>.
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

		return _clmstatushistoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CLMSTATUSHISTORYModelImpl</code>.
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

		return _clmstatushistoryLocalService.dynamicQuery(
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

		return _clmstatushistoryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _clmstatushistoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CLMSTATUSHISTORY fetchCLMSTATUSHISTORY(
		int id) {

		return _clmstatushistoryLocalService.fetchCLMSTATUSHISTORY(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _clmstatushistoryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the clmstatushistory with the primary key.
	 *
	 * @param id the primary key of the clmstatushistory
	 * @return the clmstatushistory
	 * @throws PortalException if a clmstatushistory with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMSTATUSHISTORY getCLMSTATUSHISTORY(
			int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmstatushistoryLocalService.getCLMSTATUSHISTORY(id);
	}

	/**
	 * Returns a range of all the clmstatushistories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CLMSTATUSHISTORYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatushistories
	 * @param end the upper bound of the range of clmstatushistories (not inclusive)
	 * @return the range of clmstatushistories
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.CLMSTATUSHISTORY>
		getCLMSTATUSHISTORYs(int start, int end) {

		return _clmstatushistoryLocalService.getCLMSTATUSHISTORYs(start, end);
	}

	/**
	 * Returns the number of clmstatushistories.
	 *
	 * @return the number of clmstatushistories
	 */
	@Override
	public int getCLMSTATUSHISTORYsCount() {
		return _clmstatushistoryLocalService.getCLMSTATUSHISTORYsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _clmstatushistoryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _clmstatushistoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmstatushistoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the clmstatushistory in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMSTATUSHISTORYLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clmstatushistory the clmstatushistory
	 * @return the clmstatushistory that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMSTATUSHISTORY updateCLMSTATUSHISTORY(
		com.ejada.atmc.acl.db.model.CLMSTATUSHISTORY clmstatushistory) {

		return _clmstatushistoryLocalService.updateCLMSTATUSHISTORY(
			clmstatushistory);
	}

	@Override
	public CLMSTATUSHISTORYLocalService getWrappedService() {
		return _clmstatushistoryLocalService;
	}

	@Override
	public void setWrappedService(
		CLMSTATUSHISTORYLocalService clmstatushistoryLocalService) {

		_clmstatushistoryLocalService = clmstatushistoryLocalService;
	}

	private CLMSTATUSHISTORYLocalService _clmstatushistoryLocalService;

}