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
 * Provides a wrapper for {@link ClaimHDRLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimHDRLocalService
 * @generated
 */
public class ClaimHDRLocalServiceWrapper
	implements ClaimHDRLocalService, ServiceWrapper<ClaimHDRLocalService> {

	public ClaimHDRLocalServiceWrapper(
		ClaimHDRLocalService claimHDRLocalService) {

		_claimHDRLocalService = claimHDRLocalService;
	}

	/**
	 * Adds the claim hdr to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimHDRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimHDR the claim hdr
	 * @return the claim hdr that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimHDR addClaimHDR(
		com.ejada.atmc.acl.db.model.ClaimHDR claimHDR) {

		return _claimHDRLocalService.addClaimHDR(claimHDR);
	}

	/**
	 * Creates a new claim hdr with the primary key. Does not add the claim hdr to the database.
	 *
	 * @param claimHDRPK the primary key for the new claim hdr
	 * @return the new claim hdr
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimHDR createClaimHDR(
		com.ejada.atmc.acl.db.service.persistence.ClaimHDRPK claimHDRPK) {

		return _claimHDRLocalService.createClaimHDR(claimHDRPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimHDRLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the claim hdr from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimHDRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimHDR the claim hdr
	 * @return the claim hdr that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimHDR deleteClaimHDR(
		com.ejada.atmc.acl.db.model.ClaimHDR claimHDR) {

		return _claimHDRLocalService.deleteClaimHDR(claimHDR);
	}

	/**
	 * Deletes the claim hdr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimHDRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimHDRPK the primary key of the claim hdr
	 * @return the claim hdr that was removed
	 * @throws PortalException if a claim hdr with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimHDR deleteClaimHDR(
			com.ejada.atmc.acl.db.service.persistence.ClaimHDRPK claimHDRPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimHDRLocalService.deleteClaimHDR(claimHDRPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimHDRLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _claimHDRLocalService.dynamicQuery();
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

		return _claimHDRLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ClaimHDRModelImpl</code>.
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

		return _claimHDRLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ClaimHDRModelImpl</code>.
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

		return _claimHDRLocalService.dynamicQuery(
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

		return _claimHDRLocalService.dynamicQueryCount(dynamicQuery);
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

		return _claimHDRLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.ClaimHDR fetchClaimHDR(
		com.ejada.atmc.acl.db.service.persistence.ClaimHDRPK claimHDRPK) {

		return _claimHDRLocalService.fetchClaimHDR(claimHDRPK);
	}

	@Override
	public java.util.List<Object[]> findAllClaimsPolicyByIqamaId(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimHDRLocalService.findAllClaimsPolicyByIqamaId(iqamaId);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.ClaimHDR>
			findClaimsByExcludeStatus(String iqamaId, String status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimHDRLocalService.findClaimsByExcludeStatus(iqamaId, status);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.ClaimHDR>
			findClaimsByIqamaId(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimHDRLocalService.findClaimsByIqamaId(iqamaId);
	}

	@Override
	public int findClaimsCountsPolicyStatusAdmin(
			String status, String Surveyor, String refNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimHDRLocalService.findClaimsCountsPolicyStatusAdmin(
			status, Surveyor, refNo);
	}

	@Override
	public java.util.List<Object[]> findClaimsPolicyBy()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimHDRLocalService.findClaimsPolicyBy();
	}

	@Override
	public java.util.List<Object[]> findClaimsPolicyStatus(
			String iqamaId, String status, String policyType,
			java.sql.Date fromDate, java.sql.Date toDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimHDRLocalService.findClaimsPolicyStatus(
			iqamaId, status, policyType, fromDate, toDate);
	}

	@Override
	public java.util.List<Object[]> findClaimsPolicyStatusAdmin(
			String status, String Surveyor, String refNo, int from, int to)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimHDRLocalService.findClaimsPolicyStatusAdmin(
			status, Surveyor, refNo, from, to);
	}

	/**
	 * Returns the claim hdr with the primary key.
	 *
	 * @param claimHDRPK the primary key of the claim hdr
	 * @return the claim hdr
	 * @throws PortalException if a claim hdr with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimHDR getClaimHDR(
			com.ejada.atmc.acl.db.service.persistence.ClaimHDRPK claimHDRPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimHDRLocalService.getClaimHDR(claimHDRPK);
	}

	/**
	 * Returns a range of all the claim hdrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @return the range of claim hdrs
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.ClaimHDR> getClaimHDRs(
		int start, int end) {

		return _claimHDRLocalService.getClaimHDRs(start, end);
	}

	/**
	 * Returns the number of claim hdrs.
	 *
	 * @return the number of claim hdrs
	 */
	@Override
	public int getClaimHDRsCount() {
		return _claimHDRLocalService.getClaimHDRsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _claimHDRLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimHDRLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the claim hdr in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimHDRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimHDR the claim hdr
	 * @return the claim hdr that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.ClaimHDR updateClaimHDR(
		com.ejada.atmc.acl.db.model.ClaimHDR claimHDR) {

		return _claimHDRLocalService.updateClaimHDR(claimHDR);
	}

	@Override
	public ClaimHDRLocalService getWrappedService() {
		return _claimHDRLocalService;
	}

	@Override
	public void setWrappedService(ClaimHDRLocalService claimHDRLocalService) {
		_claimHDRLocalService = claimHDRLocalService;
	}

	private ClaimHDRLocalService _claimHDRLocalService;

}