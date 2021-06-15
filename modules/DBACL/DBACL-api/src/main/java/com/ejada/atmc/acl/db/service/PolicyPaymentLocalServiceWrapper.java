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
 * Provides a wrapper for {@link PolicyPaymentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyPaymentLocalService
 * @generated
 */
public class PolicyPaymentLocalServiceWrapper
	implements PolicyPaymentLocalService,
			   ServiceWrapper<PolicyPaymentLocalService> {

	public PolicyPaymentLocalServiceWrapper(
		PolicyPaymentLocalService policyPaymentLocalService) {

		_policyPaymentLocalService = policyPaymentLocalService;
	}

	/**
	 * Adds the policy payment to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyPaymentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyPayment the policy payment
	 * @return the policy payment that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyPayment addPolicyPayment(
		com.ejada.atmc.acl.db.model.PolicyPayment policyPayment) {

		return _policyPaymentLocalService.addPolicyPayment(policyPayment);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyPaymentLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new policy payment with the primary key. Does not add the policy payment to the database.
	 *
	 * @param policyPaymentPK the primary key for the new policy payment
	 * @return the new policy payment
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyPayment createPolicyPayment(
		com.ejada.atmc.acl.db.service.persistence.PolicyPaymentPK
			policyPaymentPK) {

		return _policyPaymentLocalService.createPolicyPayment(policyPaymentPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyPaymentLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the policy payment from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyPaymentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyPayment the policy payment
	 * @return the policy payment that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyPayment deletePolicyPayment(
		com.ejada.atmc.acl.db.model.PolicyPayment policyPayment) {

		return _policyPaymentLocalService.deletePolicyPayment(policyPayment);
	}

	/**
	 * Deletes the policy payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyPaymentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyPaymentPK the primary key of the policy payment
	 * @return the policy payment that was removed
	 * @throws PortalException if a policy payment with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyPayment deletePolicyPayment(
			com.ejada.atmc.acl.db.service.persistence.PolicyPaymentPK
				policyPaymentPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyPaymentLocalService.deletePolicyPayment(policyPaymentPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _policyPaymentLocalService.dynamicQuery();
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

		return _policyPaymentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyPaymentModelImpl</code>.
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

		return _policyPaymentLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyPaymentModelImpl</code>.
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

		return _policyPaymentLocalService.dynamicQuery(
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

		return _policyPaymentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _policyPaymentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.PolicyPayment fetchPolicyPayment(
		com.ejada.atmc.acl.db.service.persistence.PolicyPaymentPK
			policyPaymentPK) {

		return _policyPaymentLocalService.fetchPolicyPayment(policyPaymentPK);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyPayment>
		findByPolicyNo(String policyNo) {

		return _policyPaymentLocalService.findByPolicyNo(policyNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _policyPaymentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyPaymentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the policy payment with the primary key.
	 *
	 * @param policyPaymentPK the primary key of the policy payment
	 * @return the policy payment
	 * @throws PortalException if a policy payment with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyPayment getPolicyPayment(
			com.ejada.atmc.acl.db.service.persistence.PolicyPaymentPK
				policyPaymentPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyPaymentLocalService.getPolicyPayment(policyPaymentPK);
	}

	/**
	 * Returns a range of all the policy payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyPaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy payments
	 * @param end the upper bound of the range of policy payments (not inclusive)
	 * @return the range of policy payments
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PolicyPayment>
		getPolicyPayments(int start, int end) {

		return _policyPaymentLocalService.getPolicyPayments(start, end);
	}

	/**
	 * Returns the number of policy payments.
	 *
	 * @return the number of policy payments
	 */
	@Override
	public int getPolicyPaymentsCount() {
		return _policyPaymentLocalService.getPolicyPaymentsCount();
	}

	/**
	 * Updates the policy payment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyPaymentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyPayment the policy payment
	 * @return the policy payment that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PolicyPayment updatePolicyPayment(
		com.ejada.atmc.acl.db.model.PolicyPayment policyPayment) {

		return _policyPaymentLocalService.updatePolicyPayment(policyPayment);
	}

	@Override
	public PolicyPaymentLocalService getWrappedService() {
		return _policyPaymentLocalService;
	}

	@Override
	public void setWrappedService(
		PolicyPaymentLocalService policyPaymentLocalService) {

		_policyPaymentLocalService = policyPaymentLocalService;
	}

	private PolicyPaymentLocalService _policyPaymentLocalService;

}