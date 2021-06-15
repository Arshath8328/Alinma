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

import com.ejada.atmc.acl.db.model.ClaimHDR;
import com.ejada.atmc.acl.db.service.base.ClaimHDRLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import java.sql.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the Claim hdr local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.db.service.ClaimHDRLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    ClaimHDRLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.ejada.atmc.acl.db.model.ClaimHDR",
		service = AopService.class
)
public class ClaimHDRLocalServiceImpl extends ClaimHDRLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ejada.atmc.acl.db.service.ClaimHDRLocalService</code> via
	 * injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ejada.atmc.acl.db.service.ClaimHDRLocalServiceUtil</code>.
	 */
	public List<ClaimHDR> findClaimsByIqamaId(String iqamaId) throws PortalException {
		return claimHDRFinder.findClaimsByIqamaId(iqamaId);
	}

	public List<Object[]> findAllClaimsPolicyByIqamaId(String iqamaId) throws PortalException {
		return claimHDRFinder.findClaimsPolicyByIqamaId(iqamaId);
	}

	public List<ClaimHDR> findClaimsByExcludeStatus(String iqamaId, String status) throws PortalException {
		return claimHDRFinder.findClaimsByExcludeStatus(iqamaId, status);
	}

	public List<Object[]> findClaimsPolicyStatus(String iqamaId, String status, String policyType, Date fromDate, Date toDate)
			throws PortalException {
		return claimHDRFinder.findClaimsPolicyStatus(iqamaId, status, policyType, fromDate, toDate);
	}

	public List<Object[]> findClaimsPolicyBy() throws PortalException {
		return claimHDRFinder.findClaimsPolicyBy();
	}

	public List<Object[]> findClaimsPolicyStatusAdmin(String status, String Surveyor, String refNo, int from, int to) throws PortalException {
		return claimHDRFinder.findClaimsPolicyStatusAdmin(status, Surveyor, refNo, from, to);
	}

	public int findClaimsCountsPolicyStatusAdmin(String status, String Surveyor, String refNo) throws PortalException {
		return claimHDRFinder.findClaimsCountsPolicyStatusAdmin(status, Surveyor, refNo);
	}
}