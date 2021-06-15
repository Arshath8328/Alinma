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
 * Provides a wrapper for {@link LNP2_PolicyMastrLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LNP2_PolicyMastrLocalService
 * @generated
 */
public class LNP2_PolicyMastrLocalServiceWrapper
	implements LNP2_PolicyMastrLocalService,
			   ServiceWrapper<LNP2_PolicyMastrLocalService> {

	public LNP2_PolicyMastrLocalServiceWrapper(
		LNP2_PolicyMastrLocalService lnp2_PolicyMastrLocalService) {

		_lnp2_PolicyMastrLocalService = lnp2_PolicyMastrLocalService;
	}

	/**
	 * Adds the lnp2_ policy mastr to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LNP2_PolicyMastrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lnp2_PolicyMastr the lnp2_ policy mastr
	 * @return the lnp2_ policy mastr that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.LNP2_PolicyMastr addLNP2_PolicyMastr(
		com.ejada.atmc.acl.db.model.LNP2_PolicyMastr lnp2_PolicyMastr) {

		return _lnp2_PolicyMastrLocalService.addLNP2_PolicyMastr(
			lnp2_PolicyMastr);
	}

	/**
	 * Creates a new lnp2_ policy mastr with the primary key. Does not add the lnp2_ policy mastr to the database.
	 *
	 * @param np1_proposal the primary key for the new lnp2_ policy mastr
	 * @return the new lnp2_ policy mastr
	 */
	@Override
	public com.ejada.atmc.acl.db.model.LNP2_PolicyMastr createLNP2_PolicyMastr(
		String np1_proposal) {

		return _lnp2_PolicyMastrLocalService.createLNP2_PolicyMastr(
			np1_proposal);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lnp2_PolicyMastrLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the lnp2_ policy mastr from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LNP2_PolicyMastrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lnp2_PolicyMastr the lnp2_ policy mastr
	 * @return the lnp2_ policy mastr that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.LNP2_PolicyMastr deleteLNP2_PolicyMastr(
		com.ejada.atmc.acl.db.model.LNP2_PolicyMastr lnp2_PolicyMastr) {

		return _lnp2_PolicyMastrLocalService.deleteLNP2_PolicyMastr(
			lnp2_PolicyMastr);
	}

	/**
	 * Deletes the lnp2_ policy mastr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LNP2_PolicyMastrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param np1_proposal the primary key of the lnp2_ policy mastr
	 * @return the lnp2_ policy mastr that was removed
	 * @throws PortalException if a lnp2_ policy mastr with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.LNP2_PolicyMastr deleteLNP2_PolicyMastr(
			String np1_proposal)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lnp2_PolicyMastrLocalService.deleteLNP2_PolicyMastr(
			np1_proposal);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lnp2_PolicyMastrLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lnp2_PolicyMastrLocalService.dynamicQuery();
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

		return _lnp2_PolicyMastrLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.LNP2_PolicyMastrModelImpl</code>.
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

		return _lnp2_PolicyMastrLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.LNP2_PolicyMastrModelImpl</code>.
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

		return _lnp2_PolicyMastrLocalService.dynamicQuery(
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

		return _lnp2_PolicyMastrLocalService.dynamicQueryCount(dynamicQuery);
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

		return _lnp2_PolicyMastrLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.LNP2_PolicyMastr fetchLNP2_PolicyMastr(
		String np1_proposal) {

		return _lnp2_PolicyMastrLocalService.fetchLNP2_PolicyMastr(
			np1_proposal);
	}

	/**
	 * Returns the lnp2_ policy mastr with the primary key.
	 *
	 * @param np1_proposal the primary key of the lnp2_ policy mastr
	 * @return the lnp2_ policy mastr
	 * @throws PortalException if a lnp2_ policy mastr with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.LNP2_PolicyMastr getLNP2_PolicyMastr(
			String np1_proposal)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lnp2_PolicyMastrLocalService.getLNP2_PolicyMastr(np1_proposal);
	}

	/**
	 * Returns a range of all the lnp2_ policy mastrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.LNP2_PolicyMastrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lnp2_ policy mastrs
	 * @param end the upper bound of the range of lnp2_ policy mastrs (not inclusive)
	 * @return the range of lnp2_ policy mastrs
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.LNP2_PolicyMastr>
		getLNP2_PolicyMastrs(int start, int end) {

		return _lnp2_PolicyMastrLocalService.getLNP2_PolicyMastrs(start, end);
	}

	/**
	 * Returns the number of lnp2_ policy mastrs.
	 *
	 * @return the number of lnp2_ policy mastrs
	 */
	@Override
	public int getLNP2_PolicyMastrsCount() {
		return _lnp2_PolicyMastrLocalService.getLNP2_PolicyMastrsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lnp2_PolicyMastrLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lnp2_PolicyMastrLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the lnp2_ policy mastr in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LNP2_PolicyMastrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lnp2_PolicyMastr the lnp2_ policy mastr
	 * @return the lnp2_ policy mastr that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.LNP2_PolicyMastr updateLNP2_PolicyMastr(
		com.ejada.atmc.acl.db.model.LNP2_PolicyMastr lnp2_PolicyMastr) {

		return _lnp2_PolicyMastrLocalService.updateLNP2_PolicyMastr(
			lnp2_PolicyMastr);
	}

	@Override
	public LNP2_PolicyMastrLocalService getWrappedService() {
		return _lnp2_PolicyMastrLocalService;
	}

	@Override
	public void setWrappedService(
		LNP2_PolicyMastrLocalService lnp2_PolicyMastrLocalService) {

		_lnp2_PolicyMastrLocalService = lnp2_PolicyMastrLocalService;
	}

	private LNP2_PolicyMastrLocalService _lnp2_PolicyMastrLocalService;

}