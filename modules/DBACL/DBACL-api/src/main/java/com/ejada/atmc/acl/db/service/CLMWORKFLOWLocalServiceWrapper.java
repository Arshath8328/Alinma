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
 * Provides a wrapper for {@link CLMWORKFLOWLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CLMWORKFLOWLocalService
 * @generated
 */
public class CLMWORKFLOWLocalServiceWrapper
	implements CLMWORKFLOWLocalService,
			   ServiceWrapper<CLMWORKFLOWLocalService> {

	public CLMWORKFLOWLocalServiceWrapper(
		CLMWORKFLOWLocalService clmworkflowLocalService) {

		_clmworkflowLocalService = clmworkflowLocalService;
	}

	/**
	 * Adds the clmworkflow to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMWORKFLOWLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clmworkflow the clmworkflow
	 * @return the clmworkflow that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMWORKFLOW addCLMWORKFLOW(
		com.ejada.atmc.acl.db.model.CLMWORKFLOW clmworkflow) {

		return _clmworkflowLocalService.addCLMWORKFLOW(clmworkflow);
	}

	/**
	 * Creates a new clmworkflow with the primary key. Does not add the clmworkflow to the database.
	 *
	 * @param id the primary key for the new clmworkflow
	 * @return the new clmworkflow
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMWORKFLOW createCLMWORKFLOW(int id) {
		return _clmworkflowLocalService.createCLMWORKFLOW(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmworkflowLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the clmworkflow from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMWORKFLOWLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clmworkflow the clmworkflow
	 * @return the clmworkflow that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMWORKFLOW deleteCLMWORKFLOW(
		com.ejada.atmc.acl.db.model.CLMWORKFLOW clmworkflow) {

		return _clmworkflowLocalService.deleteCLMWORKFLOW(clmworkflow);
	}

	/**
	 * Deletes the clmworkflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMWORKFLOWLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the clmworkflow
	 * @return the clmworkflow that was removed
	 * @throws PortalException if a clmworkflow with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMWORKFLOW deleteCLMWORKFLOW(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmworkflowLocalService.deleteCLMWORKFLOW(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmworkflowLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _clmworkflowLocalService.dynamicQuery();
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

		return _clmworkflowLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CLMWORKFLOWModelImpl</code>.
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

		return _clmworkflowLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CLMWORKFLOWModelImpl</code>.
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

		return _clmworkflowLocalService.dynamicQuery(
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

		return _clmworkflowLocalService.dynamicQueryCount(dynamicQuery);
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

		return _clmworkflowLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CLMWORKFLOW fetchCLMWORKFLOW(int id) {
		return _clmworkflowLocalService.fetchCLMWORKFLOW(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _clmworkflowLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the clmworkflow with the primary key.
	 *
	 * @param id the primary key of the clmworkflow
	 * @return the clmworkflow
	 * @throws PortalException if a clmworkflow with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMWORKFLOW getCLMWORKFLOW(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmworkflowLocalService.getCLMWORKFLOW(id);
	}

	/**
	 * Returns a range of all the clmworkflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CLMWORKFLOWModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmworkflows
	 * @param end the upper bound of the range of clmworkflows (not inclusive)
	 * @return the range of clmworkflows
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.CLMWORKFLOW>
		getCLMWORKFLOWs(int start, int end) {

		return _clmworkflowLocalService.getCLMWORKFLOWs(start, end);
	}

	/**
	 * Returns the number of clmworkflows.
	 *
	 * @return the number of clmworkflows
	 */
	@Override
	public int getCLMWORKFLOWsCount() {
		return _clmworkflowLocalService.getCLMWORKFLOWsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _clmworkflowLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _clmworkflowLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmworkflowLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the clmworkflow in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMWORKFLOWLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clmworkflow the clmworkflow
	 * @return the clmworkflow that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMWORKFLOW updateCLMWORKFLOW(
		com.ejada.atmc.acl.db.model.CLMWORKFLOW clmworkflow) {

		return _clmworkflowLocalService.updateCLMWORKFLOW(clmworkflow);
	}

	@Override
	public CLMWORKFLOWLocalService getWrappedService() {
		return _clmworkflowLocalService;
	}

	@Override
	public void setWrappedService(
		CLMWORKFLOWLocalService clmworkflowLocalService) {

		_clmworkflowLocalService = clmworkflowLocalService;
	}

	private CLMWORKFLOWLocalService _clmworkflowLocalService;

}