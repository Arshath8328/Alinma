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

import com.ejada.atmc.acl.db.model.ServiceRequestMaster;
import com.ejada.atmc.acl.db.service.base.ServiceRequestMasterLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the service request master local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.db.service.ServiceRequestMasterLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    ServiceRequestMasterLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.ejada.atmc.acl.db.model.ServiceRequestMaster",
		service = AopService.class
)
public class ServiceRequestMasterLocalServiceImpl extends ServiceRequestMasterLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.ejada.atmc.acl.db.service.ServiceRequestMasterLocalServiceUtil} to access the service request master local
	 * service.
	 */
	public List<ServiceRequestMaster> findSrvsReqsByIqamaId(String iqamaId) {
		return serviceRequestMasterFinder.findServiceRequestsByIqamaId(iqamaId);
	}

	public List<ServiceRequestMaster> findSrvsReqsByIdStatus(String iqamaId, String[] lstStatus) {
		return serviceRequestMasterFinder.findServiceRequestsByIdStatus(iqamaId, lstStatus);
	}

	public List<ServiceRequestMaster> findSrvsReqsByReqStatus(String[] status) {
		return serviceRequestMasterFinder.findServiceRequestsByReqStatus(status);
	}

	public List<ServiceRequestMaster> findSrvsReqsByReqRoleStatus(String[] status, String role) {
		return serviceRequestMasterFinder.findServiceRequestsByReqRoleStatus(status, role);
	}

	public List<ServiceRequestMaster> findSrvsReqsByEsclationFlag(String userRole, String closedStatus, boolean isAdmin) {
		return serviceRequestMasterFinder.findServiceRequestsByEscalationFlag(userRole, closedStatus, isAdmin);
	}

	public List<Object> findServiceRequestsByStatusRoleAdmin(String role, String[] lstStatus, String customerID, boolean escalationFlag, int from,
			int to, String orderBy, String orderDir) {
		return serviceRequestMasterFinder.findServiceRequestsByStatusRoleAdmin(role, lstStatus, customerID, escalationFlag, from, to, orderBy,
				orderDir);
	}

	public int countServiceRequestsByStatusRoleAdmin(String role, String[] lstStatus, String customerID, boolean escalationFlag) {
		return serviceRequestMasterFinder.countServiceRequestsByStatusRoleAdmin(role, lstStatus, customerID, escalationFlag);
	}
}