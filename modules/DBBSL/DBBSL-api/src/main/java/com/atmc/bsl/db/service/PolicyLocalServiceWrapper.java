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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PolicyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyLocalService
 * @generated
 */
public class PolicyLocalServiceWrapper
	implements PolicyLocalService, ServiceWrapper<PolicyLocalService> {

	public PolicyLocalServiceWrapper(PolicyLocalService policyLocalService) {
		_policyLocalService = policyLocalService;
	}

	@Override
	public Policy findPolicyByPolicyNo(String policyNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.findPolicyByPolicyNo(policyNo);
	}

	@Override
	public PolicyVehicle getCustomVeh(String policyNo, String vehId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.getCustomVeh(policyNo, vehId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _policyLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<Policy> getPoliciesByIqamaId(
			String iqamaId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.getPoliciesByIqamaId(iqamaId, start, end);
	}

	@Override
	public long getPoliciesCountByIqamaId(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.getPoliciesCountByIqamaId(iqamaId);
	}

	@Override
	public Policy getPolicyByPolicyNo(String policyNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.getPolicyByPolicyNo(policyNo);
	}

	@Override
	public java.util.List<java.util.HashMap<String, Object>> getPolicySummary(
			String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.getPolicySummary(iqamaId);
	}

	@Override
	public java.util.List<Policy> getTopPolicies(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.getTopPolicies(iqamaId);
	}

	@Override
	public java.util.List<Policy> getUpcomingPolicyRenewals(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.getUpcomingPolicyRenewals(iqamaId);
	}

	@Override
	public Long getUpcomingRenewalsCount(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.getUpcomingRenewalsCount(iqamaId);
	}

	@Override
	public Policy getVehiclePolicyData(
		String plateNo, String plateL1, String plateL2, String plateL3,
		String language) {

		return _policyLocalService.getVehiclePolicyData(
			plateNo, plateL1, plateL2, plateL3, language);
	}

	@Override
	public PolicyLocalService getWrappedService() {
		return _policyLocalService;
	}

	@Override
	public void setWrappedService(PolicyLocalService policyLocalService) {
		_policyLocalService = policyLocalService;
	}

	private PolicyLocalService _policyLocalService;

}