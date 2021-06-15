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
 * Provides a wrapper for {@link CLMSTATUSLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CLMSTATUSLocalService
 * @generated
 */
public class CLMSTATUSLocalServiceWrapper
	implements CLMSTATUSLocalService, ServiceWrapper<CLMSTATUSLocalService> {

	public CLMSTATUSLocalServiceWrapper(
		CLMSTATUSLocalService clmstatusLocalService) {

		_clmstatusLocalService = clmstatusLocalService;
	}

	/**
	 * Adds the clmstatus to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMSTATUSLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clmstatus the clmstatus
	 * @return the clmstatus that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMSTATUS addCLMSTATUS(
		com.ejada.atmc.acl.db.model.CLMSTATUS clmstatus) {

		return _clmstatusLocalService.addCLMSTATUS(clmstatus);
	}

	/**
	 * Creates a new clmstatus with the primary key. Does not add the clmstatus to the database.
	 *
	 * @param RefNo the primary key for the new clmstatus
	 * @return the new clmstatus
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMSTATUS createCLMSTATUS(String RefNo) {
		return _clmstatusLocalService.createCLMSTATUS(RefNo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmstatusLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the clmstatus from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMSTATUSLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clmstatus the clmstatus
	 * @return the clmstatus that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMSTATUS deleteCLMSTATUS(
		com.ejada.atmc.acl.db.model.CLMSTATUS clmstatus) {

		return _clmstatusLocalService.deleteCLMSTATUS(clmstatus);
	}

	/**
	 * Deletes the clmstatus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMSTATUSLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param RefNo the primary key of the clmstatus
	 * @return the clmstatus that was removed
	 * @throws PortalException if a clmstatus with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMSTATUS deleteCLMSTATUS(String RefNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmstatusLocalService.deleteCLMSTATUS(RefNo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmstatusLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _clmstatusLocalService.dynamicQuery();
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

		return _clmstatusLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CLMSTATUSModelImpl</code>.
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

		return _clmstatusLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CLMSTATUSModelImpl</code>.
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

		return _clmstatusLocalService.dynamicQuery(
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

		return _clmstatusLocalService.dynamicQueryCount(dynamicQuery);
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

		return _clmstatusLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CLMSTATUS fetchCLMSTATUS(String RefNo) {
		return _clmstatusLocalService.fetchCLMSTATUS(RefNo);
	}

	/**
	 * Returns the clmstatus with the primary key.
	 *
	 * @param RefNo the primary key of the clmstatus
	 * @return the clmstatus
	 * @throws PortalException if a clmstatus with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMSTATUS getCLMSTATUS(String RefNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmstatusLocalService.getCLMSTATUS(RefNo);
	}

	/**
	 * Returns a range of all the clmstatuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CLMSTATUSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatuses
	 * @param end the upper bound of the range of clmstatuses (not inclusive)
	 * @return the range of clmstatuses
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.CLMSTATUS> getCLMSTATUSs(
		int start, int end) {

		return _clmstatusLocalService.getCLMSTATUSs(start, end);
	}

	/**
	 * Returns the number of clmstatuses.
	 *
	 * @return the number of clmstatuses
	 */
	@Override
	public int getCLMSTATUSsCount() {
		return _clmstatusLocalService.getCLMSTATUSsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _clmstatusLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmstatusLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the clmstatus in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMSTATUSLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clmstatus the clmstatus
	 * @return the clmstatus that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMSTATUS updateCLMSTATUS(
		com.ejada.atmc.acl.db.model.CLMSTATUS clmstatus) {

		return _clmstatusLocalService.updateCLMSTATUS(clmstatus);
	}

	@Override
	public CLMSTATUSLocalService getWrappedService() {
		return _clmstatusLocalService;
	}

	@Override
	public void setWrappedService(CLMSTATUSLocalService clmstatusLocalService) {
		_clmstatusLocalService = clmstatusLocalService;
	}

	private CLMSTATUSLocalService _clmstatusLocalService;

}