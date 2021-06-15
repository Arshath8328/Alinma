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
 * Provides the local service utility for PolicyVEH. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.PolicyVEHLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyVEHLocalService
 * @generated
 */
public class PolicyVEHLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.PolicyVEHLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static com.ejada.atmc.acl.db.model.PolicyVEH addPolicyVEH(
		com.ejada.atmc.acl.db.model.PolicyVEH policyVEH) {

		return getService().addPolicyVEH(policyVEH);
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
	 * Creates a new policy veh with the primary key. Does not add the policy veh to the database.
	 *
	 * @param policyVEHPK the primary key for the new policy veh
	 * @return the new policy veh
	 */
	public static com.ejada.atmc.acl.db.model.PolicyVEH createPolicyVEH(
		com.ejada.atmc.acl.db.service.persistence.PolicyVEHPK policyVEHPK) {

		return getService().createPolicyVEH(policyVEHPK);
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
	 * Deletes the policy veh from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyVEHLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyVEH the policy veh
	 * @return the policy veh that was removed
	 */
	public static com.ejada.atmc.acl.db.model.PolicyVEH deletePolicyVEH(
		com.ejada.atmc.acl.db.model.PolicyVEH policyVEH) {

		return getService().deletePolicyVEH(policyVEH);
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
	public static com.ejada.atmc.acl.db.model.PolicyVEH deletePolicyVEH(
			com.ejada.atmc.acl.db.service.persistence.PolicyVEHPK policyVEHPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePolicyVEH(policyVEHPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyVEHModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyVEHModelImpl</code>.
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

	public static com.ejada.atmc.acl.db.model.PolicyVEH fetchPolicyVEH(
		com.ejada.atmc.acl.db.service.persistence.PolicyVEHPK policyVEHPK) {

		return getService().fetchPolicyVEH(policyVEHPK);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyVEH>
			findByArPlateNo(
				String arPlateNo, String arPlateL1, String arPlateL2,
				String arPlateL3)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getService().findByArPlateNo(
			arPlateNo, arPlateL1, arPlateL2, arPlateL3);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyVEH>
			findByEnPlateNo(
				long enPlateNo, String enPlateL1, String enPlateL2,
				String enPlateL3)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getService().findByEnPlateNo(
			enPlateNo, enPlateL1, enPlateL2, enPlateL3);
	}

	public static com.ejada.atmc.acl.db.model.PolicyVEH findByPolicyNo(
			String policyNumber)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getService().findByPolicyNo(policyNumber);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyVEH>
		findByPolicyNumber(String policyNo) {

		return getService().findByPolicyNumber(policyNo);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyVEH>
		findByPolicyNumberVehicleCustomNo(
			String policyNumber, String vehicleSeqCustom) {

		return getService().findByPolicyNumberVehicleCustomNo(
			policyNumber, vehicleSeqCustom);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyVEH>
			findByVehicleCustomNo(String vehicleSeqCustom)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getService().findByVehicleCustomNo(vehicleSeqCustom);
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
	 * Returns the policy veh with the primary key.
	 *
	 * @param policyVEHPK the primary key of the policy veh
	 * @return the policy veh
	 * @throws PortalException if a policy veh with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.PolicyVEH getPolicyVEH(
			com.ejada.atmc.acl.db.service.persistence.PolicyVEHPK policyVEHPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPolicyVEH(policyVEHPK);
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
	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyVEH>
		getPolicyVEHs(int start, int end) {

		return getService().getPolicyVEHs(start, end);
	}

	/**
	 * Returns the number of policy vehs.
	 *
	 * @return the number of policy vehs
	 */
	public static int getPolicyVEHsCount() {
		return getService().getPolicyVEHsCount();
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
	public static com.ejada.atmc.acl.db.model.PolicyVEH updatePolicyVEH(
		com.ejada.atmc.acl.db.model.PolicyVEH policyVEH) {

		return getService().updatePolicyVEH(policyVEH);
	}

	public static PolicyVEHLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PolicyVEHLocalService, PolicyVEHLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PolicyVEHLocalService.class);

		ServiceTracker<PolicyVEHLocalService, PolicyVEHLocalService>
			serviceTracker =
				new ServiceTracker
					<PolicyVEHLocalService, PolicyVEHLocalService>(
						bundle.getBundleContext(), PolicyVEHLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}