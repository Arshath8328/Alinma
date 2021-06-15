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
 * Provides the local service utility for PolicyVehDrv. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.PolicyVehDrvLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyVehDrvLocalService
 * @generated
 */
public class PolicyVehDrvLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.PolicyVehDrvLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the policy veh drv to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyVehDrvLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyVehDrv the policy veh drv
	 * @return the policy veh drv that was added
	 */
	public static com.ejada.atmc.acl.db.model.PolicyVehDrv addPolicyVehDrv(
		com.ejada.atmc.acl.db.model.PolicyVehDrv policyVehDrv) {

		return getService().addPolicyVehDrv(policyVehDrv);
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
	 * Creates a new policy veh drv with the primary key. Does not add the policy veh drv to the database.
	 *
	 * @param policyVehDrvPK the primary key for the new policy veh drv
	 * @return the new policy veh drv
	 */
	public static com.ejada.atmc.acl.db.model.PolicyVehDrv createPolicyVehDrv(
		com.ejada.atmc.acl.db.service.persistence.PolicyVehDrvPK
			policyVehDrvPK) {

		return getService().createPolicyVehDrv(policyVehDrvPK);
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
	 * Deletes the policy veh drv from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyVehDrvLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyVehDrv the policy veh drv
	 * @return the policy veh drv that was removed
	 */
	public static com.ejada.atmc.acl.db.model.PolicyVehDrv deletePolicyVehDrv(
		com.ejada.atmc.acl.db.model.PolicyVehDrv policyVehDrv) {

		return getService().deletePolicyVehDrv(policyVehDrv);
	}

	/**
	 * Deletes the policy veh drv with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyVehDrvLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyVehDrvPK the primary key of the policy veh drv
	 * @return the policy veh drv that was removed
	 * @throws PortalException if a policy veh drv with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.PolicyVehDrv deletePolicyVehDrv(
			com.ejada.atmc.acl.db.service.persistence.PolicyVehDrvPK
				policyVehDrvPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePolicyVehDrv(policyVehDrvPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyVehDrvModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyVehDrvModelImpl</code>.
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

	public static com.ejada.atmc.acl.db.model.PolicyVehDrv fetchPolicyVehDrv(
		com.ejada.atmc.acl.db.service.persistence.PolicyVehDrvPK
			policyVehDrvPK) {

		return getService().fetchPolicyVehDrv(policyVehDrvPK);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyVehDrv>
		findByPolicyNumberVehicleId(String policyNo, long vehId) {

		return getService().findByPolicyNumberVehicleId(policyNo, vehId);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyVehDrv>
		findBypolNumber(String policyNo) {

		return getService().findBypolNumber(policyNo);
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
	 * Returns the policy veh drv with the primary key.
	 *
	 * @param policyVehDrvPK the primary key of the policy veh drv
	 * @return the policy veh drv
	 * @throws PortalException if a policy veh drv with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.PolicyVehDrv getPolicyVehDrv(
			com.ejada.atmc.acl.db.service.persistence.PolicyVehDrvPK
				policyVehDrvPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPolicyVehDrv(policyVehDrvPK);
	}

	/**
	 * Returns a range of all the policy veh drvs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyVehDrvModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy veh drvs
	 * @param end the upper bound of the range of policy veh drvs (not inclusive)
	 * @return the range of policy veh drvs
	 */
	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyVehDrv>
		getPolicyVehDrvs(int start, int end) {

		return getService().getPolicyVehDrvs(start, end);
	}

	/**
	 * Returns the number of policy veh drvs.
	 *
	 * @return the number of policy veh drvs
	 */
	public static int getPolicyVehDrvsCount() {
		return getService().getPolicyVehDrvsCount();
	}

	/**
	 * Updates the policy veh drv in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyVehDrvLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyVehDrv the policy veh drv
	 * @return the policy veh drv that was updated
	 */
	public static com.ejada.atmc.acl.db.model.PolicyVehDrv updatePolicyVehDrv(
		com.ejada.atmc.acl.db.model.PolicyVehDrv policyVehDrv) {

		return getService().updatePolicyVehDrv(policyVehDrv);
	}

	public static PolicyVehDrvLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PolicyVehDrvLocalService, PolicyVehDrvLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PolicyVehDrvLocalService.class);

		ServiceTracker<PolicyVehDrvLocalService, PolicyVehDrvLocalService>
			serviceTracker =
				new ServiceTracker
					<PolicyVehDrvLocalService, PolicyVehDrvLocalService>(
						bundle.getBundleContext(),
						PolicyVehDrvLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}