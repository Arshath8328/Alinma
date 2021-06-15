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

package com.ejada.atmc.acl.db.service.impl;

import com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException;
import com.ejada.atmc.acl.db.model.PolicyHDR;
import com.ejada.atmc.acl.db.service.base.PolicyHDRLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
		property = "model.class.name=com.ejada.atmc.acl.db.model.PolicyHDR",
		service = AopService.class
)
public class PolicyHDRLocalServiceImpl extends PolicyHDRLocalServiceBaseImpl {

	public List<PolicyHDR> findByIqamaId(String iqamaId, int start, int end) throws SystemException {
		return policyHDRFinder.findByIqamaId(iqamaId, start, end);
	}

	public Long findUpcomingRenewalsCount(String iqamaId) throws SystemException {
		return policyHDRFinder.findUpcomingRenewalsCount(iqamaId);
	}

	public List<PolicyHDR> findTopPolicies(String iqamaId) throws SystemException {
		return policyHDRFinder.findTopPolicies(iqamaId);
	}

	public List<PolicyHDR> findMultiPolicies(String[] policyNumbers) throws SystemException {
		return policyHDRPersistence.findByMULTI_POLICY(policyNumbers);
	}

	public List<PolicyHDR> getUpcomingPolicyRenewals(String iqamaId) throws SystemException {
		return policyHDRFinder.findUpcomingPolicyRenewals(iqamaId);
	}

	public List<PolicyHDR> findPolicyList(String iqamaId, String[] status) throws SystemException {
		return policyHDRFinder.findPolicyList(iqamaId, status);
	}

	public PolicyHDR findByPolicyNo(String policyNo) throws NoSuchPolicyHDRException {
		return policyHDRPersistence.findByPolicyNo(policyNo);
	}

	public boolean checkLoyalty(String iqamaId, String vehId, Date expiryDate) throws PortalException {
		return policyHDRFinder.findLoyaltyByIqamaIdVehIdExpDate(iqamaId, vehId, expiryDate);
	}

	public String findPolicyNajmStatus(String policyNo) throws PortalException {
		return policyHDRFinder.findPolicyNajmStatus(policyNo);
	}

	public long findCountByIqamaId(String iqamaId) throws PortalException {
		return policyHDRFinder.findCountByIqamaId(iqamaId);
	}

	public List<PolicyHDR> findByinsuredMobileNo(String insuredMobileNo) throws PortalException {
		return policyHDRPersistence.findByinsuredMobileNo(insuredMobileNo);
	}

	public List<PolicyHDR> findByiqamaIdAndStatus(String iqamaId, String status) throws PortalException {
		return policyHDRPersistence.findByiqamaIdAndStatus(iqamaId, status);
	}
}