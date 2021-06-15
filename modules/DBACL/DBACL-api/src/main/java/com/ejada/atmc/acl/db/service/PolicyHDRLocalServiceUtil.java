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
 * Provides the local service utility for PolicyHDR. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.PolicyHDRLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyHDRLocalService
 * @generated
 */
public class PolicyHDRLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.PolicyHDRLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static com.ejada.atmc.acl.db.model.PolicyHDR addPolicyHDR(
		com.ejada.atmc.acl.db.model.PolicyHDR policyHDR) {

		return getService().addPolicyHDR(policyHDR);
	}

	public static boolean checkLoyalty(
			String iqamaId, String vehId, java.util.Date expiryDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().checkLoyalty(iqamaId, vehId, expiryDate);
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
	 * Creates a new policy hdr with the primary key. Does not add the policy hdr to the database.
	 *
	 * @param policyNo the primary key for the new policy hdr
	 * @return the new policy hdr
	 */
	public static com.ejada.atmc.acl.db.model.PolicyHDR createPolicyHDR(
		String policyNo) {

		return getService().createPolicyHDR(policyNo);
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
	 * Deletes the policy hdr from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyHDRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyHDR the policy hdr
	 * @return the policy hdr that was removed
	 */
	public static com.ejada.atmc.acl.db.model.PolicyHDR deletePolicyHDR(
		com.ejada.atmc.acl.db.model.PolicyHDR policyHDR) {

		return getService().deletePolicyHDR(policyHDR);
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
	public static com.ejada.atmc.acl.db.model.PolicyHDR deletePolicyHDR(
			String policyNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePolicyHDR(policyNo);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyHDRModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyHDRModelImpl</code>.
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

	public static com.ejada.atmc.acl.db.model.PolicyHDR fetchPolicyHDR(
		String policyNo) {

		return getService().fetchPolicyHDR(policyNo);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR>
			findByinsuredMobileNo(String insuredMobileNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findByinsuredMobileNo(insuredMobileNo);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR>
			findByIqamaId(String iqamaId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findByIqamaId(iqamaId, start, end);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR>
			findByiqamaIdAndStatus(String iqamaId, String status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findByiqamaIdAndStatus(iqamaId, status);
	}

	public static com.ejada.atmc.acl.db.model.PolicyHDR findByPolicyNo(
			String policyNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException {

		return getService().findByPolicyNo(policyNo);
	}

	public static long findCountByIqamaId(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findCountByIqamaId(iqamaId);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR>
			findMultiPolicies(String[] policyNumbers)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findMultiPolicies(policyNumbers);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR>
			findPolicyList(String iqamaId, String[] status)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findPolicyList(iqamaId, status);
	}

	public static String findPolicyNajmStatus(String policyNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findPolicyNajmStatus(policyNo);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR>
			findTopPolicies(String iqamaId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findTopPolicies(iqamaId);
	}

	public static Long findUpcomingRenewalsCount(String iqamaId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findUpcomingRenewalsCount(iqamaId);
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
	 * Returns the policy hdr with the primary key.
	 *
	 * @param policyNo the primary key of the policy hdr
	 * @return the policy hdr
	 * @throws PortalException if a policy hdr with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.PolicyHDR getPolicyHDR(
			String policyNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPolicyHDR(policyNo);
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
	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR>
		getPolicyHDRs(int start, int end) {

		return getService().getPolicyHDRs(start, end);
	}

	/**
	 * Returns the number of policy hdrs.
	 *
	 * @return the number of policy hdrs
	 */
	public static int getPolicyHDRsCount() {
		return getService().getPolicyHDRsCount();
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR>
			getUpcomingPolicyRenewals(String iqamaId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getUpcomingPolicyRenewals(iqamaId);
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
	public static com.ejada.atmc.acl.db.model.PolicyHDR updatePolicyHDR(
		com.ejada.atmc.acl.db.model.PolicyHDR policyHDR) {

		return getService().updatePolicyHDR(policyHDR);
	}

	public static PolicyHDRLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PolicyHDRLocalService, PolicyHDRLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PolicyHDRLocalService.class);

		ServiceTracker<PolicyHDRLocalService, PolicyHDRLocalService>
			serviceTracker =
				new ServiceTracker
					<PolicyHDRLocalService, PolicyHDRLocalService>(
						bundle.getBundleContext(), PolicyHDRLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}