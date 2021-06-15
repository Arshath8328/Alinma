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
 * Provides a wrapper for {@link PolicyHDRLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyHDRLocalService
 * @generated
 */
public class PolicyHDRLocalServiceWrapper
	implements PolicyHDRLocalService, ServiceWrapper<PolicyHDRLocalService> {

	public PolicyHDRLocalServiceWrapper(
		PolicyHDRLocalService policyHDRLocalService) {

		_policyHDRLocalService = policyHDRLocalService;
	}

	/**
	 * Adds the policy hdr to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyHDRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyHDR the policy hdr
	 * @return the policy hdr that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyHDR addPolicyHDR(
		com.ejada.atmc.acl.db.model.PolicyHDR policyHDR) {

		return _policyHDRLocalService.addPolicyHDR(policyHDR);
	}

	@Override
	public boolean checkLoyalty(
			String iqamaId, String vehId, java.util.Date expiryDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyHDRLocalService.checkLoyalty(iqamaId, vehId, expiryDate);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyHDRLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new policy hdr with the primary key. Does not add the policy hdr to the database.
	 *
	 * @param policyNo the primary key for the new policy hdr
	 * @return the new policy hdr
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyHDR createPolicyHDR(
		String policyNo) {

		return _policyHDRLocalService.createPolicyHDR(policyNo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyHDRLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the policy hdr from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyHDRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyHDR the policy hdr
	 * @return the policy hdr that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyHDR deletePolicyHDR(
		com.ejada.atmc.acl.db.model.PolicyHDR policyHDR) {

		return _policyHDRLocalService.deletePolicyHDR(policyHDR);
	}

	/**
	 * Deletes the policy hdr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyHDRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyNo the primary key of the policy hdr
	 * @return the policy hdr that was removed
	 * @throws PortalException if a policy hdr with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyHDR deletePolicyHDR(
			String policyNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyHDRLocalService.deletePolicyHDR(policyNo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _policyHDRLocalService.dynamicQuery();
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

		return _policyHDRLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyHDRModelImpl</code>.
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

		return _policyHDRLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyHDRModelImpl</code>.
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

		return _policyHDRLocalService.dynamicQuery(
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

		return _policyHDRLocalService.dynamicQueryCount(dynamicQuery);
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

		return _policyHDRLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.PolicyHDR fetchPolicyHDR(
		String policyNo) {

		return _policyHDRLocalService.fetchPolicyHDR(policyNo);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR>
			findByinsuredMobileNo(String insuredMobileNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyHDRLocalService.findByinsuredMobileNo(insuredMobileNo);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR> findByIqamaId(
			String iqamaId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _policyHDRLocalService.findByIqamaId(iqamaId, start, end);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR>
			findByiqamaIdAndStatus(String iqamaId, String status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyHDRLocalService.findByiqamaIdAndStatus(iqamaId, status);
	}

	@Override
	public com.ejada.atmc.acl.db.model.PolicyHDR findByPolicyNo(String policyNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException {

		return _policyHDRLocalService.findByPolicyNo(policyNo);
	}

	@Override
	public long findCountByIqamaId(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyHDRLocalService.findCountByIqamaId(iqamaId);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR>
			findMultiPolicies(String[] policyNumbers)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _policyHDRLocalService.findMultiPolicies(policyNumbers);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR> findPolicyList(
			String iqamaId, String[] status)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _policyHDRLocalService.findPolicyList(iqamaId, status);
	}

	@Override
	public String findPolicyNajmStatus(String policyNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyHDRLocalService.findPolicyNajmStatus(policyNo);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR>
			findTopPolicies(String iqamaId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _policyHDRLocalService.findTopPolicies(iqamaId);
	}

	@Override
	public Long findUpcomingRenewalsCount(String iqamaId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _policyHDRLocalService.findUpcomingRenewalsCount(iqamaId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _policyHDRLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyHDRLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the policy hdr with the primary key.
	 *
	 * @param policyNo the primary key of the policy hdr
	 * @return the policy hdr
	 * @throws PortalException if a policy hdr with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyHDR getPolicyHDR(String policyNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyHDRLocalService.getPolicyHDR(policyNo);
	}

	/**
	 * Returns a range of all the policy hdrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @return the range of policy hdrs
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR> getPolicyHDRs(
		int start, int end) {

		return _policyHDRLocalService.getPolicyHDRs(start, end);
	}

	/**
	 * Returns the number of policy hdrs.
	 *
	 * @return the number of policy hdrs
	 */
	@Override
	public int getPolicyHDRsCount() {
		return _policyHDRLocalService.getPolicyHDRsCount();
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR>
			getUpcomingPolicyRenewals(String iqamaId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _policyHDRLocalService.getUpcomingPolicyRenewals(iqamaId);
	}

	/**
	 * Updates the policy hdr in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyHDRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyHDR the policy hdr
	 * @return the policy hdr that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyHDR updatePolicyHDR(
		com.ejada.atmc.acl.db.model.PolicyHDR policyHDR) {

		return _policyHDRLocalService.updatePolicyHDR(policyHDR);
	}

	@Override
	public PolicyHDRLocalService getWrappedService() {
		return _policyHDRLocalService;
	}

	@Override
	public void setWrappedService(PolicyHDRLocalService policyHDRLocalService) {
		_policyHDRLocalService = policyHDRLocalService;
	}

	private PolicyHDRLocalService _policyHDRLocalService;

}