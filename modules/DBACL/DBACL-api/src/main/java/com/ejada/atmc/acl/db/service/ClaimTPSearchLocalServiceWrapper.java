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
 * Provides a wrapper for {@link ClaimTPSearchLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimTPSearchLocalService
 * @generated
 */
public class ClaimTPSearchLocalServiceWrapper
	implements ClaimTPSearchLocalService,
			   ServiceWrapper<ClaimTPSearchLocalService> {

	public ClaimTPSearchLocalServiceWrapper(
		ClaimTPSearchLocalService claimTPSearchLocalService) {

		_claimTPSearchLocalService = claimTPSearchLocalService;
	}

	/**
	 * Adds the claim tp search to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimTPSearchLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimTPSearch the claim tp search
	 * @return the claim tp search that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimTPSearch addClaimTPSearch(
		com.ejada.atmc.acl.db.model.ClaimTPSearch claimTPSearch) {

		return _claimTPSearchLocalService.addClaimTPSearch(claimTPSearch);
	}

	/**
	 * Creates a new claim tp search with the primary key. Does not add the claim tp search to the database.
	 *
	 * @param claimTPSearchPK the primary key for the new claim tp search
	 * @return the new claim tp search
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimTPSearch createClaimTPSearch(
		com.ejada.atmc.acl.db.service.persistence.ClaimTPSearchPK
			claimTPSearchPK) {

		return _claimTPSearchLocalService.createClaimTPSearch(claimTPSearchPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimTPSearchLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the claim tp search from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimTPSearchLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimTPSearch the claim tp search
	 * @return the claim tp search that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimTPSearch deleteClaimTPSearch(
		com.ejada.atmc.acl.db.model.ClaimTPSearch claimTPSearch) {

		return _claimTPSearchLocalService.deleteClaimTPSearch(claimTPSearch);
	}

	/**
	 * Deletes the claim tp search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimTPSearchLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimTPSearchPK the primary key of the claim tp search
	 * @return the claim tp search that was removed
	 * @throws PortalException if a claim tp search with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimTPSearch deleteClaimTPSearch(
			com.ejada.atmc.acl.db.service.persistence.ClaimTPSearchPK
				claimTPSearchPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimTPSearchLocalService.deleteClaimTPSearch(claimTPSearchPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimTPSearchLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _claimTPSearchLocalService.dynamicQuery();
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

		return _claimTPSearchLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ClaimTPSearchModelImpl</code>.
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

		return _claimTPSearchLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ClaimTPSearchModelImpl</code>.
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

		return _claimTPSearchLocalService.dynamicQuery(
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

		return _claimTPSearchLocalService.dynamicQueryCount(dynamicQuery);
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

		return _claimTPSearchLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.ClaimTPSearch fetchClaimTPSearch(
		com.ejada.atmc.acl.db.service.persistence.ClaimTPSearchPK
			claimTPSearchPK) {

		return _claimTPSearchLocalService.fetchClaimTPSearch(claimTPSearchPK);
	}

	/**
	 * Returns the claim tp search with the primary key.
	 *
	 * @param claimTPSearchPK the primary key of the claim tp search
	 * @return the claim tp search
	 * @throws PortalException if a claim tp search with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimTPSearch getClaimTPSearch(
			com.ejada.atmc.acl.db.service.persistence.ClaimTPSearchPK
				claimTPSearchPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimTPSearchLocalService.getClaimTPSearch(claimTPSearchPK);
	}

	/**
	 * Returns a range of all the claim tp searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ClaimTPSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim tp searches
	 * @param end the upper bound of the range of claim tp searches (not inclusive)
	 * @return the range of claim tp searches
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.ClaimTPSearch>
		getClaimTPSearches(int start, int end) {

		return _claimTPSearchLocalService.getClaimTPSearches(start, end);
	}

	/**
	 * Returns the number of claim tp searches.
	 *
	 * @return the number of claim tp searches
	 */
	@Override
	public int getClaimTPSearchesCount() {
		return _claimTPSearchLocalService.getClaimTPSearchesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _claimTPSearchLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimTPSearchLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the claim tp search in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimTPSearchLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimTPSearch the claim tp search
	 * @return the claim tp search that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimTPSearch updateClaimTPSearch(
		com.ejada.atmc.acl.db.model.ClaimTPSearch claimTPSearch) {

		return _claimTPSearchLocalService.updateClaimTPSearch(claimTPSearch);
	}

	@Override
	public ClaimTPSearchLocalService getWrappedService() {
		return _claimTPSearchLocalService;
	}

	@Override
	public void setWrappedService(
		ClaimTPSearchLocalService claimTPSearchLocalService) {

		_claimTPSearchLocalService = claimTPSearchLocalService;
	}

	private ClaimTPSearchLocalService _claimTPSearchLocalService;

}