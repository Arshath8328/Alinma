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
 * Provides a wrapper for {@link PolicyMemberDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyMemberDetailsLocalService
 * @generated
 */
public class PolicyMemberDetailsLocalServiceWrapper
	implements PolicyMemberDetailsLocalService,
			   ServiceWrapper<PolicyMemberDetailsLocalService> {

	public PolicyMemberDetailsLocalServiceWrapper(
		PolicyMemberDetailsLocalService policyMemberDetailsLocalService) {

		_policyMemberDetailsLocalService = policyMemberDetailsLocalService;
	}

	/**
	 * Adds the policy member details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyMemberDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyMemberDetails the policy member details
	 * @return the policy member details that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyMemberDetails
		addPolicyMemberDetails(
			com.ejada.atmc.acl.db.model.PolicyMemberDetails
				policyMemberDetails) {

		return _policyMemberDetailsLocalService.addPolicyMemberDetails(
			policyMemberDetails);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyMemberDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new policy member details with the primary key. Does not add the policy member details to the database.
	 *
	 * @param memberId the primary key for the new policy member details
	 * @return the new policy member details
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyMemberDetails
		createPolicyMemberDetails(long memberId) {

		return _policyMemberDetailsLocalService.createPolicyMemberDetails(
			memberId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyMemberDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the policy member details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyMemberDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param memberId the primary key of the policy member details
	 * @return the policy member details that was removed
	 * @throws PortalException if a policy member details with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyMemberDetails
			deletePolicyMemberDetails(long memberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyMemberDetailsLocalService.deletePolicyMemberDetails(
			memberId);
	}

	/**
	 * Deletes the policy member details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyMemberDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyMemberDetails the policy member details
	 * @return the policy member details that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyMemberDetails
		deletePolicyMemberDetails(
			com.ejada.atmc.acl.db.model.PolicyMemberDetails
				policyMemberDetails) {

		return _policyMemberDetailsLocalService.deletePolicyMemberDetails(
			policyMemberDetails);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _policyMemberDetailsLocalService.dynamicQuery();
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

		return _policyMemberDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyMemberDetailsModelImpl</code>.
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

		return _policyMemberDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyMemberDetailsModelImpl</code>.
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

		return _policyMemberDetailsLocalService.dynamicQuery(
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

		return _policyMemberDetailsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _policyMemberDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.PolicyMemberDetails
		fetchPolicyMemberDetails(long memberId) {

		return _policyMemberDetailsLocalService.fetchPolicyMemberDetails(
			memberId);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyMemberDetails>
		findByPolicyNo(String policyNo) {

		return _policyMemberDetailsLocalService.findByPolicyNo(policyNo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _policyMemberDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _policyMemberDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _policyMemberDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyMemberDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the policy member details with the primary key.
	 *
	 * @param memberId the primary key of the policy member details
	 * @return the policy member details
	 * @throws PortalException if a policy member details with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyMemberDetails
			getPolicyMemberDetails(long memberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyMemberDetailsLocalService.getPolicyMemberDetails(
			memberId);
	}

	/**
	 * Returns a range of all the policy member detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyMemberDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy member detailses
	 * @param end the upper bound of the range of policy member detailses (not inclusive)
	 * @return the range of policy member detailses
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyMemberDetails>
		getPolicyMemberDetailses(int start, int end) {

		return _policyMemberDetailsLocalService.getPolicyMemberDetailses(
			start, end);
	}

	/**
	 * Returns the number of policy member detailses.
	 *
	 * @return the number of policy member detailses
	 */
	@Override
	public int getPolicyMemberDetailsesCount() {
		return _policyMemberDetailsLocalService.getPolicyMemberDetailsesCount();
	}

	/**
	 * Updates the policy member details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyMemberDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyMemberDetails the policy member details
	 * @return the policy member details that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyMemberDetails
		updatePolicyMemberDetails(
			com.ejada.atmc.acl.db.model.PolicyMemberDetails
				policyMemberDetails) {

		return _policyMemberDetailsLocalService.updatePolicyMemberDetails(
			policyMemberDetails);
	}

	@Override
	public PolicyMemberDetailsLocalService getWrappedService() {
		return _policyMemberDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		PolicyMemberDetailsLocalService policyMemberDetailsLocalService) {

		_policyMemberDetailsLocalService = policyMemberDetailsLocalService;
	}

	private PolicyMemberDetailsLocalService _policyMemberDetailsLocalService;

}