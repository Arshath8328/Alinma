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
 * Provides a wrapper for {@link PolicyService}.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyService
 * @generated
 */
public class PolicyServiceWrapper
	implements PolicyService, ServiceWrapper<PolicyService> {

	public PolicyServiceWrapper(PolicyService policyService) {
		_policyService = policyService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _policyService.getOSGiServiceIdentifier();
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.ejada.atmc.bsl.db.domain.policy.Policy>>
				getPoliciesByIqamaId(String iqamaId, int startRow, int endRow)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _policyService.getPoliciesByIqamaId(iqamaId, startRow, endRow);
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.ServiceOutput<Long> getPoliciesCountByIqamaId(
			String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyService.getPoliciesCountByIqamaId(iqamaId);
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.ServiceOutput
		<com.ejada.atmc.bsl.db.domain.policy.Policy> getPolicyByPolicyNo(
				String policyNo)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _policyService.getPolicyByPolicyNo(policyNo);
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<java.util.HashMap<String, Object>>> getPolicySummary(
				String iqamaId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _policyService.getPolicySummary(iqamaId);
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.ejada.atmc.bsl.db.domain.policy.Policy>>
				getUpcomingPolicyRenewals(String iqamaId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _policyService.getUpcomingPolicyRenewals(iqamaId);
	}

	@Override
	public PolicyService getWrappedService() {
		return _policyService;
	}

	@Override
	public void setWrappedService(PolicyService policyService) {
		_policyService = policyService;
	}

	private PolicyService _policyService;

}