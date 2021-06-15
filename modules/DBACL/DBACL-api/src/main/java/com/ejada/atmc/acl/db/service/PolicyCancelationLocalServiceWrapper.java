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
 * Provides a wrapper for {@link PolicyCancelationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyCancelationLocalService
 * @generated
 */
public class PolicyCancelationLocalServiceWrapper
	implements PolicyCancelationLocalService,
			   ServiceWrapper<PolicyCancelationLocalService> {

	public PolicyCancelationLocalServiceWrapper(
		PolicyCancelationLocalService policyCancelationLocalService) {

		_policyCancelationLocalService = policyCancelationLocalService;
	}

	/**
	 * Adds the policy cancelation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyCancelationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyCancelation the policy cancelation
	 * @return the policy cancelation that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyCancelation addPolicyCancelation(
		com.ejada.atmc.acl.db.model.PolicyCancelation policyCancelation) {

		return _policyCancelationLocalService.addPolicyCancelation(
			policyCancelation);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyCancelationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new policy cancelation with the primary key. Does not add the policy cancelation to the database.
	 *
	 * @param Id the primary key for the new policy cancelation
	 * @return the new policy cancelation
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyCancelation
		createPolicyCancelation(String Id) {

		return _policyCancelationLocalService.createPolicyCancelation(Id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyCancelationLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the policy cancelation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyCancelationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyCancelation the policy cancelation
	 * @return the policy cancelation that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyCancelation
		deletePolicyCancelation(
			com.ejada.atmc.acl.db.model.PolicyCancelation policyCancelation) {

		return _policyCancelationLocalService.deletePolicyCancelation(
			policyCancelation);
	}

	/**
	 * Deletes the policy cancelation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyCancelationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param Id the primary key of the policy cancelation
	 * @return the policy cancelation that was removed
	 * @throws PortalException if a policy cancelation with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyCancelation
			deletePolicyCancelation(String Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyCancelationLocalService.deletePolicyCancelation(Id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _policyCancelationLocalService.dynamicQuery();
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

		return _policyCancelationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyCancelationModelImpl</code>.
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

		return _policyCancelationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyCancelationModelImpl</code>.
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

		return _policyCancelationLocalService.dynamicQuery(
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

		return _policyCancelationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _policyCancelationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.PolicyCancelation fetchPolicyCancelation(
		String Id) {

		return _policyCancelationLocalService.fetchPolicyCancelation(Id);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyCancelation>
			findByInsuredId(String id)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return _policyCancelationLocalService.findByInsuredId(id);
	}

	@Override
	public com.ejada.atmc.acl.db.model.PolicyCancelation findByPolicyNum(
			String policyNumber)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return _policyCancelationLocalService.findByPolicyNum(policyNumber);
	}

	@Override
	public byte[] findIbanFile(String policyNumber)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return _policyCancelationLocalService.findIbanFile(policyNumber);
	}

	@Override
	public byte[] findValidFile(String policyNumber)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return _policyCancelationLocalService.findValidFile(policyNumber);
	}

	@Override
	public com.ejada.atmc.acl.db.model.PolicyCancelationIbanImageBlobModel
		getIbanImageBlobModel(java.io.Serializable primaryKey) {

		return _policyCancelationLocalService.getIbanImageBlobModel(primaryKey);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _policyCancelationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.ejada.atmc.acl.db.model.PolicyCancelationOtherFileBlobModel
		getOtherFileBlobModel(java.io.Serializable primaryKey) {

		return _policyCancelationLocalService.getOtherFileBlobModel(primaryKey);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyCancelationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the policy cancelation with the primary key.
	 *
	 * @param Id the primary key of the policy cancelation
	 * @return the policy cancelation
	 * @throws PortalException if a policy cancelation with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyCancelation getPolicyCancelation(
			String Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyCancelationLocalService.getPolicyCancelation(Id);
	}

	/**
	 * Returns a range of all the policy cancelations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @return the range of policy cancelations
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyCancelation>
		getPolicyCancelations(int start, int end) {

		return _policyCancelationLocalService.getPolicyCancelations(start, end);
	}

	/**
	 * Returns the number of policy cancelations.
	 *
	 * @return the number of policy cancelations
	 */
	@Override
	public int getPolicyCancelationsCount() {
		return _policyCancelationLocalService.getPolicyCancelationsCount();
	}

	@Override
	public com.ejada.atmc.acl.db.model.PolicyCancelationValidFileBlobModel
		getValidFileBlobModel(java.io.Serializable primaryKey) {

		return _policyCancelationLocalService.getValidFileBlobModel(primaryKey);
	}

	@Override
	public java.io.InputStream openIbanImageInputStream(long Id) {
		return _policyCancelationLocalService.openIbanImageInputStream(Id);
	}

	@Override
	public java.io.InputStream openOtherFileInputStream(long Id) {
		return _policyCancelationLocalService.openOtherFileInputStream(Id);
	}

	@Override
	public java.io.InputStream openValidFileInputStream(long Id) {
		return _policyCancelationLocalService.openValidFileInputStream(Id);
	}

	@Override
	public com.ejada.atmc.acl.db.model.PolicyCancelation status(String status)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return _policyCancelationLocalService.status(status);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyCancelation>
			statusAll(String status)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return _policyCancelationLocalService.statusAll(status);
	}

	/**
	 * Updates the policy cancelation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyCancelationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyCancelation the policy cancelation
	 * @return the policy cancelation that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyCancelation
		updatePolicyCancelation(
			com.ejada.atmc.acl.db.model.PolicyCancelation policyCancelation) {

		return _policyCancelationLocalService.updatePolicyCancelation(
			policyCancelation);
	}

	@Override
	public PolicyCancelationLocalService getWrappedService() {
		return _policyCancelationLocalService;
	}

	@Override
	public void setWrappedService(
		PolicyCancelationLocalService policyCancelationLocalService) {

		_policyCancelationLocalService = policyCancelationLocalService;
	}

	private PolicyCancelationLocalService _policyCancelationLocalService;

}