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

import com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException;
import com.ejada.atmc.acl.db.model.PolicyVEH;
import com.ejada.atmc.acl.db.service.base.PolicyVEHLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the policy veh local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.db.service.PolicyVEHLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    PolicyVEHLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.ejada.atmc.acl.db.model.PolicyVEH",
		service = AopService.class
)
public class PolicyVEHLocalServiceImpl extends PolicyVEHLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ejada.atmc.acl.db.service.PolicyVEHLocalService</code> via
	 * injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ejada.atmc.acl.db.service.PolicyVEHLocalServiceUtil</code>.
	 */
	public List<PolicyVEH> findByPolicyNumber(String policyNo) {
		return policyVEHFinder.findByPolicyNumber(policyNo);
	}

	public List<PolicyVEH> findByVehicleCustomNo(String vehicleSeqCustom) throws NoSuchPolicyVEHException {
		return policyVEHPersistence.findByVehicleSeqCustom(vehicleSeqCustom);
	}

	public List<PolicyVEH> findByEnPlateNo(long enPlateNo, String enPlateL1, String enPlateL2, String enPlateL3) throws NoSuchPolicyVEHException {
		return policyVEHPersistence.findByEnPlateNo(enPlateNo, enPlateL1, enPlateL2, enPlateL3);
	}

	public List<PolicyVEH> findByArPlateNo(String arPlateNo, String arPlateL1, String arPlateL2, String arPlateL3) throws NoSuchPolicyVEHException {
		return policyVEHPersistence.findByArPlateNo(arPlateNo, arPlateL1, arPlateL2, arPlateL3);
	}

	public List<PolicyVEH> findByPolicyNumberVehicleCustomNo(String policyNumber, String vehicleSeqCustom) {
		return policyVEHPersistence.findByPolicyNoVehicleSeqCustom(policyNumber, vehicleSeqCustom);

	}

	public PolicyVEH findByPolicyNo(String policyNumber) throws NoSuchPolicyVEHException {
		return policyVEHPersistence.findBypolicyNumber(policyNumber);
	}
}