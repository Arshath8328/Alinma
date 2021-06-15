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
 * Provides a wrapper for {@link PolicyVehCvrLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyVehCvrLocalService
 * @generated
 */
public class PolicyVehCvrLocalServiceWrapper
	implements PolicyVehCvrLocalService,
			   ServiceWrapper<PolicyVehCvrLocalService> {

	public PolicyVehCvrLocalServiceWrapper(
		PolicyVehCvrLocalService policyVehCvrLocalService) {

		_policyVehCvrLocalService = policyVehCvrLocalService;
	}

	/**
	 * Adds the policy veh cvr to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyVehCvrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyVehCvr the policy veh cvr
	 * @return the policy veh cvr that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyVehCvr addPolicyVehCvr(
		com.ejada.atmc.acl.db.model.PolicyVehCvr policyVehCvr) {

		return _policyVehCvrLocalService.addPolicyVehCvr(policyVehCvr);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyVehCvrLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new policy veh cvr with the primary key. Does not add the policy veh cvr to the database.
	 *
	 * @param policyVehCvrPK the primary key for the new policy veh cvr
	 * @return the new policy veh cvr
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyVehCvr createPolicyVehCvr(
		com.ejada.atmc.acl.db.service.persistence.PolicyVehCvrPK
			policyVehCvrPK) {

		return _policyVehCvrLocalService.createPolicyVehCvr(policyVehCvrPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyVehCvrLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the policy veh cvr from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyVehCvrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyVehCvr the policy veh cvr
	 * @return the policy veh cvr that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyVehCvr deletePolicyVehCvr(
		com.ejada.atmc.acl.db.model.PolicyVehCvr policyVehCvr) {

		return _policyVehCvrLocalService.deletePolicyVehCvr(policyVehCvr);
	}

	/**
	 * Deletes the policy veh cvr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyVehCvrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyVehCvrPK the primary key of the policy veh cvr
	 * @return the policy veh cvr that was removed
	 * @throws PortalException if a policy veh cvr with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyVehCvr deletePolicyVehCvr(
			com.ejada.atmc.acl.db.service.persistence.PolicyVehCvrPK
				policyVehCvrPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyVehCvrLocalService.deletePolicyVehCvr(policyVehCvrPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _policyVehCvrLocalService.dynamicQuery();
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

		return _policyVehCvrLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyVehCvrModelImpl</code>.
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

		return _policyVehCvrLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyVehCvrModelImpl</code>.
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

		return _policyVehCvrLocalService.dynamicQuery(
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

		return _policyVehCvrLocalService.dynamicQueryCount(dynamicQuery);
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

		return _policyVehCvrLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.PolicyVehCvr fetchPolicyVehCvr(
		com.ejada.atmc.acl.db.service.persistence.PolicyVehCvrPK
			policyVehCvrPK) {

		return _policyVehCvrLocalService.fetchPolicyVehCvr(policyVehCvrPK);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyVehCvr>
		findByPolicyNumber(String policyNo) {

		return _policyVehCvrLocalService.findByPolicyNumber(policyNo);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyVehCvr>
		findByPolicyNumberVehicleId(String policyNo, long vehId) {

		return _policyVehCvrLocalService.findByPolicyNumberVehicleId(
			policyNo, vehId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _policyVehCvrLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyVehCvrLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the policy veh cvr with the primary key.
	 *
	 * @param policyVehCvrPK the primary key of the policy veh cvr
	 * @return the policy veh cvr
	 * @throws PortalException if a policy veh cvr with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyVehCvr getPolicyVehCvr(
			com.ejada.atmc.acl.db.service.persistence.PolicyVehCvrPK
				policyVehCvrPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyVehCvrLocalService.getPolicyVehCvr(policyVehCvrPK);
	}

	/**
	 * Returns a range of all the policy veh cvrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyVehCvrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy veh cvrs
	 * @param end the upper bound of the range of policy veh cvrs (not inclusive)
	 * @return the range of policy veh cvrs
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyVehCvr>
		getPolicyVehCvrs(int start, int end) {

		return _policyVehCvrLocalService.getPolicyVehCvrs(start, end);
	}

	/**
	 * Returns the number of policy veh cvrs.
	 *
	 * @return the number of policy veh cvrs
	 */
	@Override
	public int getPolicyVehCvrsCount() {
		return _policyVehCvrLocalService.getPolicyVehCvrsCount();
	}

	/**
	 * Updates the policy veh cvr in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyVehCvrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyVehCvr the policy veh cvr
	 * @return the policy veh cvr that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyVehCvr updatePolicyVehCvr(
		com.ejada.atmc.acl.db.model.PolicyVehCvr policyVehCvr) {

		return _policyVehCvrLocalService.updatePolicyVehCvr(policyVehCvr);
	}

	@Override
	public PolicyVehCvrLocalService getWrappedService() {
		return _policyVehCvrLocalService;
	}

	@Override
	public void setWrappedService(
		PolicyVehCvrLocalService policyVehCvrLocalService) {

		_policyVehCvrLocalService = policyVehCvrLocalService;
	}

	private PolicyVehCvrLocalService _policyVehCvrLocalService;

}