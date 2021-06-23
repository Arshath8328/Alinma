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

package com.atmc.mob.acl.ws.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Ods. This utility wraps
 * <code>com.atmc.mob.acl.ws.service.impl.OdsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see OdsLocalService
 * @generated
 */
public class OdsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.atmc.mob.acl.ws.service.impl.OdsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @param odsClaimInt
	 * @return ODSCIResponse
	 * @see
	 */
	public static com.atmc.mob.acl.ws.domain.ods.ODSCIResponse
		claimIntimation(
			com.atmc.mob.acl.ws.domain.ods.ODSClaimIntimation
				odsClaimInt) {

		return getService().claimIntimation(odsClaimInt);
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
	 * @param insured
	 * @param policy
	 * @param vehicle
	 * @return ODSPIResponse
	 * @see
	 */
	public static com.atmc.mob.acl.ws.domain.ods.ODSPIResponse
		policyIssuance(
			com.atmc.mob.acl.ws.domain.ods.ODSInsured insured,
			com.atmc.mob.acl.ws.domain.ods.ODSPolicy policy,
			java.util.List<com.atmc.mob.acl.ws.domain.ods.ODSVehicleInfo>
				vehicleInfoList) {

		return getService().policyIssuance(insured, policy, vehicleInfoList);
	}

	public static OdsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OdsLocalService, OdsLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(OdsLocalService.class);

		ServiceTracker<OdsLocalService, OdsLocalService> serviceTracker =
			new ServiceTracker<OdsLocalService, OdsLocalService>(
				bundle.getBundleContext(), OdsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}