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

package com.atmc.bsl.db.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Policy. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.PolicyLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyLocalService
 * @generated
 */
public class PolicyLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.PolicyLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Policy findPolicyByPolicyNo(String policyNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findPolicyByPolicyNo(policyNo);
	}

	public static PolicyVehicle getCustomVeh(String policyNo, String vehId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCustomVeh(policyNo, vehId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<Policy> getPoliciesByIqamaId(
			String iqamaId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPoliciesByIqamaId(iqamaId, start, end);
	}

	public static long getPoliciesCountByIqamaId(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPoliciesCountByIqamaId(iqamaId);
	}

	public static Policy getPolicyByPolicyNo(String policyNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPolicyByPolicyNo(policyNo);
	}

	public static java.util.List<java.util.HashMap<String, Object>>
			getPolicySummary(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPolicySummary(iqamaId);
	}

	public static java.util.List<Policy> getTopPolicies(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTopPolicies(iqamaId);
	}

	public static java.util.List<Policy> getUpcomingPolicyRenewals(
			String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUpcomingPolicyRenewals(iqamaId);
	}

	public static Long getUpcomingRenewalsCount(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUpcomingRenewalsCount(iqamaId);
	}

	public static Policy getVehiclePolicyData(
		String plateNo, String plateL1, String plateL2, String plateL3,
		String language) {

		return getService().getVehiclePolicyData(
			plateNo, plateL1, plateL2, plateL3, language);
	}

	public static PolicyLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PolicyLocalService, PolicyLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PolicyLocalService.class);

		ServiceTracker<PolicyLocalService, PolicyLocalService> serviceTracker =
			new ServiceTracker<PolicyLocalService, PolicyLocalService>(
				bundle.getBundleContext(), PolicyLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}