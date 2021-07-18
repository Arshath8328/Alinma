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
 * Provides the remote service utility for Policy. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.PolicyServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyService
 * @generated
 */
public class PolicyServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.PolicyServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.policy.Policy>>
				getPoliciesByIqamaId(String iqamaId, int startRow, int endRow)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPoliciesByIqamaId(iqamaId, startRow, endRow);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Long>
			getPoliciesCountByIqamaId(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPoliciesCountByIqamaId(iqamaId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.policy.Policy> getPolicyByPolicyNo(
				String policyNo)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPolicyByPolicyNo(policyNo);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<java.util.HashMap<String, Object>>> getPolicySummary(
				String iqamaId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPolicySummary(iqamaId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.policy.Policy>>
				getUpcomingPolicyRenewals(String iqamaId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUpcomingPolicyRenewals(iqamaId);
	}

	public static PolicyService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PolicyService, PolicyService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PolicyService.class);

		ServiceTracker<PolicyService, PolicyService> serviceTracker =
			new ServiceTracker<PolicyService, PolicyService>(
				bundle.getBundleContext(), PolicyService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}