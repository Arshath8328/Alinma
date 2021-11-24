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

package com.atmc.bsl.db.service.impl;

import com.atmc.bsl.db.service.PolicyLocalServiceUtil;
import com.atmc.bsl.db.service.base.PolicyServiceBaseImpl;
import com.ejada.atmc.bsl.db.domain.ReturnCodes;
import com.ejada.atmc.bsl.db.domain.ServiceOutput;
import com.ejada.atmc.bsl.db.domain.policy.Policy;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.HashMap;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the policy remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.PolicyService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=dbbsl",
		"json.web.service.context.path=Policy" }, service = AopService.class)
public class PolicyServiceImpl extends PolicyServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.atmc.bsl.db.service.PolicyServiceUtil} to access the policy remote
	 * service.
	 */
	public ServiceOutput<List<Policy>> getPoliciesByIqamaId(String iqamaId, int startRow, int endRow)
			throws PortalException {
		ServiceOutput<List<Policy>> svcOutput = new ServiceOutput<List<Policy>>();
		try {
			List<Policy> policyList = PolicyLocalServiceUtil.getPoliciesByIqamaId(iqamaId, startRow, endRow);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(policyList);

		} catch (Exception e) {
			// TODO: handle exception
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return svcOutput;
	}

	public ServiceOutput<Long> getPoliciesCountByIqamaId(String iqamaId) throws PortalException {
		ServiceOutput<Long> svcOutput = new ServiceOutput<Long>();
		try {
			long policyListCont = PolicyLocalServiceUtil.getPoliciesCountByIqamaId(iqamaId);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(policyListCont);

		} catch (Exception e) {
			// TODO: handle exception
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return svcOutput;
	}

	public ServiceOutput<List<Policy>> getUpcomingPolicyRenewals(String iqamaId) throws PortalException {
		ServiceOutput<List<Policy>> srvOutput = new ServiceOutput<List<Policy>>();
		try {
			List<Policy> upcomingPolicies = PolicyLocalServiceUtil.getUpcomingPolicyRenewals(iqamaId);
			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
			srvOutput.setOutputObject(upcomingPolicies);
		} catch (Exception e) {
			// TODO: handle exception
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;
	}

	public ServiceOutput<List<HashMap<String, Object>>> getPolicySummary(String iqamaId) throws PortalException {
		ServiceOutput<List<HashMap<String, Object>>> srvOutput = new ServiceOutput<List<HashMap<String, Object>>>();
		try {
			List<HashMap<String, Object>> policiesSummary = PolicyLocalServiceUtil.getPolicySummary(iqamaId);
			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
			srvOutput.setOutputObject(policiesSummary);
		} catch (Exception e) {
			// TODO: handle exception
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;
	}

	public ServiceOutput<Policy> getPolicyByPolicyNo(String policyNo) throws PortalException {
		ServiceOutput<Policy> srvOutput = new ServiceOutput<Policy>();
		try {
			Policy policy = PolicyLocalServiceUtil.findPolicyByPolicyNo(policyNo);
			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
			srvOutput.setOutputObject(policy);
		} catch (Exception e) {
			// TODO: handle exception
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;
	}
}