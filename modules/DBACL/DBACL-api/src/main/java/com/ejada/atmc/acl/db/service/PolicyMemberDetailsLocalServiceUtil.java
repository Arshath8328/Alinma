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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for PolicyMemberDetails. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.PolicyMemberDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyMemberDetailsLocalService
 * @generated
 */
public class PolicyMemberDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.PolicyMemberDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static com.ejada.atmc.acl.db.model.PolicyMemberDetails
		addPolicyMemberDetails(
			com.ejada.atmc.acl.db.model.PolicyMemberDetails
				policyMemberDetails) {

		return getService().addPolicyMemberDetails(policyMemberDetails);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new policy member details with the primary key. Does not add the policy member details to the database.
	 *
	 * @param memberId the primary key for the new policy member details
	 * @return the new policy member details
	 */
	public static com.ejada.atmc.acl.db.model.PolicyMemberDetails
		createPolicyMemberDetails(long memberId) {

		return getService().createPolicyMemberDetails(memberId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static com.ejada.atmc.acl.db.model.PolicyMemberDetails
			deletePolicyMemberDetails(long memberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePolicyMemberDetails(memberId);
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
	public static com.ejada.atmc.acl.db.model.PolicyMemberDetails
		deletePolicyMemberDetails(
			com.ejada.atmc.acl.db.model.PolicyMemberDetails
				policyMemberDetails) {

		return getService().deletePolicyMemberDetails(policyMemberDetails);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.ejada.atmc.acl.db.model.PolicyMemberDetails
		fetchPolicyMemberDetails(long memberId) {

		return getService().fetchPolicyMemberDetails(memberId);
	}

	public static java.util.List
		<com.ejada.atmc.acl.db.model.PolicyMemberDetails> findByPolicyNo(
			String policyNo) {

		return getService().findByPolicyNo(policyNo);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the policy member details with the primary key.
	 *
	 * @param memberId the primary key of the policy member details
	 * @return the policy member details
	 * @throws PortalException if a policy member details with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.PolicyMemberDetails
			getPolicyMemberDetails(long memberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPolicyMemberDetails(memberId);
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
	public static java.util.List
		<com.ejada.atmc.acl.db.model.PolicyMemberDetails>
			getPolicyMemberDetailses(int start, int end) {

		return getService().getPolicyMemberDetailses(start, end);
	}

	/**
	 * Returns the number of policy member detailses.
	 *
	 * @return the number of policy member detailses
	 */
	public static int getPolicyMemberDetailsesCount() {
		return getService().getPolicyMemberDetailsesCount();
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
	public static com.ejada.atmc.acl.db.model.PolicyMemberDetails
		updatePolicyMemberDetails(
			com.ejada.atmc.acl.db.model.PolicyMemberDetails
				policyMemberDetails) {

		return getService().updatePolicyMemberDetails(policyMemberDetails);
	}

	public static PolicyMemberDetailsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PolicyMemberDetailsLocalService, PolicyMemberDetailsLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PolicyMemberDetailsLocalService.class);

		ServiceTracker
			<PolicyMemberDetailsLocalService, PolicyMemberDetailsLocalService>
				serviceTracker =
					new ServiceTracker
						<PolicyMemberDetailsLocalService,
						 PolicyMemberDetailsLocalService>(
							 bundle.getBundleContext(),
							 PolicyMemberDetailsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}