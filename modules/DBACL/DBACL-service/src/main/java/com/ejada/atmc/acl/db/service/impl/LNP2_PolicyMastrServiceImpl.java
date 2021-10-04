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

import com.ejada.atmc.acl.db.service.LNP2_PolicyMastrLocalServiceUtil;
import com.ejada.atmc.acl.db.service.base.LNP2_PolicyMastrServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the lnp2_ policy mastr remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.db.service.LNP2_PolicyMastrService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    LNP2_PolicyMastrServiceBaseImpl
 */
@Component(
		property = { "json.web.service.context.name=dbacl", "json.web.service.context.path=LNP2_PolicyMastr" },
		service = AopService.class
)
public class LNP2_PolicyMastrServiceImpl extends LNP2_PolicyMastrServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use
	 * <code>com.ejada.atmc.acl.db.service.LNP2_PolicyMastrServiceUtil</code> to access the lnp2_ policy mastr remote
	 * service.
	 */
	public Object findAllPSPolicyByIqamaId(String iqamaId) {
		try {
			return LNP2_PolicyMastrLocalServiceUtil.findAllPSPolicyByIqamaId(iqamaId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Object findPSPolicyStatementDetailsById(String id, String fromDate, String toDate) {
		try {
			return LNP2_PolicyMastrLocalServiceUtil.findPSPolicyStatementDetailsById(id, fromDate, toDate);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toDate;
	}
}