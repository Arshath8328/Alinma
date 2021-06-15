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
 * Provides a wrapper for {@link ClaimODSearchLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimODSearchLocalService
 * @generated
 */
public class ClaimODSearchLocalServiceWrapper
	implements ClaimODSearchLocalService,
			   ServiceWrapper<ClaimODSearchLocalService> {

	public ClaimODSearchLocalServiceWrapper(
		ClaimODSearchLocalService claimODSearchLocalService) {

		_claimODSearchLocalService = claimODSearchLocalService;
	}

	/**
	 * Adds the claim od search to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimODSearchLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimODSearch the claim od search
	 * @return the claim od search that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimODSearch addClaimODSearch(
		com.ejada.atmc.acl.db.model.ClaimODSearch claimODSearch) {

		return _claimODSearchLocalService.addClaimODSearch(claimODSearch);
	}

	/**
	 * Creates a new claim od search with the primary key. Does not add the claim od search to the database.
	 *
	 * @param claimODSearchPK the primary key for the new claim od search
	 * @return the new claim od search
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimODSearch createClaimODSearch(
		com.ejada.atmc.acl.db.service.persistence.ClaimODSearchPK
			claimODSearchPK) {

		return _claimODSearchLocalService.createClaimODSearch(claimODSearchPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimODSearchLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the claim od search from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimODSearchLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimODSearch the claim od search
	 * @return the claim od search that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimODSearch deleteClaimODSearch(
		com.ejada.atmc.acl.db.model.ClaimODSearch claimODSearch) {

		return _claimODSearchLocalService.deleteClaimODSearch(claimODSearch);
	}

	/**
	 * Deletes the claim od search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimODSearchLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimODSearchPK the primary key of the claim od search
	 * @return the claim od search that was removed
	 * @throws PortalException if a claim od search with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimODSearch deleteClaimODSearch(
			com.ejada.atmc.acl.db.service.persistence.ClaimODSearchPK
				claimODSearchPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimODSearchLocalService.deleteClaimODSearch(claimODSearchPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimODSearchLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _claimODSearchLocalService.dynamicQuery();
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

		return _claimODSearchLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ClaimODSearchModelImpl</code>.
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

		return _claimODSearchLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ClaimODSearchModelImpl</code>.
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

		return _claimODSearchLocalService.dynamicQuery(
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

		return _claimODSearchLocalService.dynamicQueryCount(dynamicQuery);
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

		return _claimODSearchLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.ClaimODSearch fetchClaimODSearch(
		com.ejada.atmc.acl.db.service.persistence.ClaimODSearchPK
			claimODSearchPK) {

		return _claimODSearchLocalService.fetchClaimODSearch(claimODSearchPK);
	}

	/**
	 * Returns the claim od search with the primary key.
	 *
	 * @param claimODSearchPK the primary key of the claim od search
	 * @return the claim od search
	 * @throws PortalException if a claim od search with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimODSearch getClaimODSearch(
			com.ejada.atmc.acl.db.service.persistence.ClaimODSearchPK
				claimODSearchPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimODSearchLocalService.getClaimODSearch(claimODSearchPK);
	}

	/**
	 * Returns a range of all the claim od searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ClaimODSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim od searches
	 * @param end the upper bound of the range of claim od searches (not inclusive)
	 * @return the range of claim od searches
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.ClaimODSearch>
		getClaimODSearches(int start, int end) {

		return _claimODSearchLocalService.getClaimODSearches(start, end);
	}

	/**
	 * Returns the number of claim od searches.
	 *
	 * @return the number of claim od searches
	 */
	@Override
	public int getClaimODSearchesCount() {
		return _claimODSearchLocalService.getClaimODSearchesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _claimODSearchLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimODSearchLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the claim od search in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimODSearchLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimODSearch the claim od search
	 * @return the claim od search that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimODSearch updateClaimODSearch(
		com.ejada.atmc.acl.db.model.ClaimODSearch claimODSearch) {

		return _claimODSearchLocalService.updateClaimODSearch(claimODSearch);
	}

	@Override
	public ClaimODSearchLocalService getWrappedService() {
		return _claimODSearchLocalService;
	}

	@Override
	public void setWrappedService(
		ClaimODSearchLocalService claimODSearchLocalService) {

		_claimODSearchLocalService = claimODSearchLocalService;
	}

	private ClaimODSearchLocalService _claimODSearchLocalService;

}