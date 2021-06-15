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
 * Provides a wrapper for {@link WorkshopVehicleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkshopVehicleLocalService
 * @generated
 */
public class WorkshopVehicleLocalServiceWrapper
	implements ServiceWrapper<WorkshopVehicleLocalService>,
			   WorkshopVehicleLocalService {

	public WorkshopVehicleLocalServiceWrapper(
		WorkshopVehicleLocalService workshopVehicleLocalService) {

		_workshopVehicleLocalService = workshopVehicleLocalService;
	}

	/**
	 * Adds the workshop vehicle to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkshopVehicleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workshopVehicle the workshop vehicle
	 * @return the workshop vehicle that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.WorkshopVehicle addWorkshopVehicle(
		com.ejada.atmc.acl.db.model.WorkshopVehicle workshopVehicle) {

		return _workshopVehicleLocalService.addWorkshopVehicle(workshopVehicle);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workshopVehicleLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new workshop vehicle with the primary key. Does not add the workshop vehicle to the database.
	 *
	 * @param id the primary key for the new workshop vehicle
	 * @return the new workshop vehicle
	 */
	@Override
	public com.ejada.atmc.acl.db.model.WorkshopVehicle createWorkshopVehicle(
		int id) {

		return _workshopVehicleLocalService.createWorkshopVehicle(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workshopVehicleLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the workshop vehicle with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkshopVehicleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the workshop vehicle
	 * @return the workshop vehicle that was removed
	 * @throws PortalException if a workshop vehicle with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.WorkshopVehicle deleteWorkshopVehicle(
			int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workshopVehicleLocalService.deleteWorkshopVehicle(id);
	}

	/**
	 * Deletes the workshop vehicle from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkshopVehicleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workshopVehicle the workshop vehicle
	 * @return the workshop vehicle that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.WorkshopVehicle deleteWorkshopVehicle(
		com.ejada.atmc.acl.db.model.WorkshopVehicle workshopVehicle) {

		return _workshopVehicleLocalService.deleteWorkshopVehicle(
			workshopVehicle);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workshopVehicleLocalService.dynamicQuery();
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

		return _workshopVehicleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.WorkshopVehicleModelImpl</code>.
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

		return _workshopVehicleLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.WorkshopVehicleModelImpl</code>.
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

		return _workshopVehicleLocalService.dynamicQuery(
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

		return _workshopVehicleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _workshopVehicleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.WorkshopVehicle fetchWorkshopVehicle(
		int id) {

		return _workshopVehicleLocalService.fetchWorkshopVehicle(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _workshopVehicleLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _workshopVehicleLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _workshopVehicleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workshopVehicleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the workshop vehicle with the primary key.
	 *
	 * @param id the primary key of the workshop vehicle
	 * @return the workshop vehicle
	 * @throws PortalException if a workshop vehicle with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.WorkshopVehicle getWorkshopVehicle(
			int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workshopVehicleLocalService.getWorkshopVehicle(id);
	}

	/**
	 * Returns a range of all the workshop vehicles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.WorkshopVehicleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of workshop vehicles
	 * @param end the upper bound of the range of workshop vehicles (not inclusive)
	 * @return the range of workshop vehicles
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.WorkshopVehicle>
		getWorkshopVehicles(int start, int end) {

		return _workshopVehicleLocalService.getWorkshopVehicles(start, end);
	}

	/**
	 * Returns the number of workshop vehicles.
	 *
	 * @return the number of workshop vehicles
	 */
	@Override
	public int getWorkshopVehiclesCount() {
		return _workshopVehicleLocalService.getWorkshopVehiclesCount();
	}

	/**
	 * Updates the workshop vehicle in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkshopVehicleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workshopVehicle the workshop vehicle
	 * @return the workshop vehicle that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.WorkshopVehicle updateWorkshopVehicle(
		com.ejada.atmc.acl.db.model.WorkshopVehicle workshopVehicle) {

		return _workshopVehicleLocalService.updateWorkshopVehicle(
			workshopVehicle);
	}

	@Override
	public WorkshopVehicleLocalService getWrappedService() {
		return _workshopVehicleLocalService;
	}

	@Override
	public void setWrappedService(
		WorkshopVehicleLocalService workshopVehicleLocalService) {

		_workshopVehicleLocalService = workshopVehicleLocalService;
	}

	private WorkshopVehicleLocalService _workshopVehicleLocalService;

}