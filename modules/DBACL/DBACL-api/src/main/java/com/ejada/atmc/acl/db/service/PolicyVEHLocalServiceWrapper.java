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
 * Provides a wrapper for {@link PolicyVEHLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyVEHLocalService
 * @generated
 */
public class PolicyVEHLocalServiceWrapper
	implements PolicyVEHLocalService, ServiceWrapper<PolicyVEHLocalService> {

	public PolicyVEHLocalServiceWrapper(
		PolicyVEHLocalService policyVEHLocalService) {

		_policyVEHLocalService = policyVEHLocalService;
	}

	/**
	 * Adds the policy veh to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyVEHLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyVEH the policy veh
	 * @return the policy veh that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyVEH addPolicyVEH(
		com.ejada.atmc.acl.db.model.PolicyVEH policyVEH) {

		return _policyVEHLocalService.addPolicyVEH(policyVEH);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyVEHLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new policy veh with the primary key. Does not add the policy veh to the database.
	 *
	 * @param policyVEHPK the primary key for the new policy veh
	 * @return the new policy veh
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyVEH createPolicyVEH(
		com.ejada.atmc.acl.db.service.persistence.PolicyVEHPK policyVEHPK) {

		return _policyVEHLocalService.createPolicyVEH(policyVEHPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyVEHLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the policy veh from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyVEHLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyVEH the policy veh
	 * @return the policy veh that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyVEH deletePolicyVEH(
		com.ejada.atmc.acl.db.model.PolicyVEH policyVEH) {

		return _policyVEHLocalService.deletePolicyVEH(policyVEH);
	}

	/**
	 * Deletes the policy veh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyVEHLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyVEHPK the primary key of the policy veh
	 * @return the policy veh that was removed
	 * @throws PortalException if a policy veh with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyVEH deletePolicyVEH(
			com.ejada.atmc.acl.db.service.persistence.PolicyVEHPK policyVEHPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyVEHLocalService.deletePolicyVEH(policyVEHPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _policyVEHLocalService.dynamicQuery();
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

		return _policyVEHLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyVEHModelImpl</code>.
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

		return _policyVEHLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyVEHModelImpl</code>.
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

		return _policyVEHLocalService.dynamicQuery(
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

		return _policyVEHLocalService.dynamicQueryCount(dynamicQuery);
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

		return _policyVEHLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.PolicyVEH fetchPolicyVEH(
		com.ejada.atmc.acl.db.service.persistence.PolicyVEHPK policyVEHPK) {

		return _policyVEHLocalService.fetchPolicyVEH(policyVEHPK);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyVEH>
			findByArPlateNo(
				String arPlateNo, String arPlateL1, String arPlateL2,
				String arPlateL3)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return _policyVEHLocalService.findByArPlateNo(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyVEH>
			findByEnPlateNo(
				long enPlateNo, String enPlateL1, String enPlateL2,
				String enPlateL3)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return _policyVEHLocalService.findByEnPlateNo(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3);
	}

	@Override
	public com.ejada.atmc.acl.db.model.PolicyVEH findByPolicyNo(
			String policyNumber)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return _policyVEHLocalService.findByPolicyNo(policyNumber);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyVEH>
		findByPolicyNumber(String policyNo) {

		return _policyVEHLocalService.findByPolicyNumber(policyNo);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyVEH>
		findByPolicyNumberVehicleCustomNo(
			String policyNumber, String vehicleSeqCustom) {

		return _policyVEHLocalService.findByPolicyNumberVehicleCustomNo(
			policyNumber, vehicleSeqCustom);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyVEH>
			findByVehicleCustomNo(String vehicleSeqCustom)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return _policyVEHLocalService.findByVehicleCustomNo(vehicleSeqCustom);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _policyVEHLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyVEHLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the policy veh with the primary key.
	 *
	 * @param policyVEHPK the primary key of the policy veh
	 * @return the policy veh
	 * @throws PortalException if a policy veh with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyVEH getPolicyVEH(
			com.ejada.atmc.acl.db.service.persistence.PolicyVEHPK policyVEHPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyVEHLocalService.getPolicyVEH(policyVEHPK);
	}

	/**
	 * Returns a range of all the policy vehs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyVEHModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy vehs
	 * @param end the upper bound of the range of policy vehs (not inclusive)
	 * @return the range of policy vehs
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyVEH> getPolicyVEHs(
		int start, int end) {

		return _policyVEHLocalService.getPolicyVEHs(start, end);
	}

	/**
	 * Returns the number of policy vehs.
	 *
	 * @return the number of policy vehs
	 */
	@Override
	public int getPolicyVEHsCount() {
		return _policyVEHLocalService.getPolicyVEHsCount();
	}

	/**
	 * Updates the policy veh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyVEHLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyVEH the policy veh
	 * @return the policy veh that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyVEH updatePolicyVEH(
		com.ejada.atmc.acl.db.model.PolicyVEH policyVEH) {

		return _policyVEHLocalService.updatePolicyVEH(policyVEH);
	}

	@Override
	public PolicyVEHLocalService getWrappedService() {
		return _policyVEHLocalService;
	}

	@Override
	public void setWrappedService(PolicyVEHLocalService policyVEHLocalService) {
		_policyVEHLocalService = policyVEHLocalService;
	}

	private PolicyVEHLocalService _policyVEHLocalService;

}