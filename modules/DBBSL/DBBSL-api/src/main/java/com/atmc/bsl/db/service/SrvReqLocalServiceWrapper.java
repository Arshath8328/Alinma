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
 * Provides a wrapper for {@link SrvReqLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SrvReqLocalService
 * @generated
 */
public class SrvReqLocalServiceWrapper implements ServiceWrapper<SrvReqLocalService>, SrvReqLocalService {

	public SrvReqLocalServiceWrapper(SrvReqLocalService srvReqLocalService) {
		_srvReqLocalService = srvReqLocalService;
	}

	@Override
	public String addNewServiceRequest(com.atmc.bsl.db.domain.serviceRequest.ServiceRequest srvRequest,
			String creator) {

		return _srvReqLocalService.addNewServiceRequest(srvRequest, creator);
	}

	@Override
	public int countSrvReqListByRoleStatusCustID(String[] status, String role, String customerID,
			boolean escalationFlag) {

		return _srvReqLocalService.countSrvReqListByRoleStatusCustID(status, role, customerID, escalationFlag);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _srvReqLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.atmc.bsl.db.domain.serviceRequest.ServiceRequest getServiceRequestbyRefNo(String refNo) {

		return _srvReqLocalService.getServiceRequestbyRefNo(refNo);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.serviceRequest.ServiceRequest> getServiceRequestsListByEscalationFlag(
			String userRole, String closedStatus, boolean isAdmin) {

		return _srvReqLocalService.getServiceRequestsListByEscalationFlag(userRole, closedStatus, isAdmin);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.serviceRequest.ServiceRequest> getServiceRequestsListByStatus(
			String[] status, String role) {

		return _srvReqLocalService.getServiceRequestsListByStatus(status, role);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.serviceRequest.ServiceRequest> getServiceRequestsListbyUserID(
			String userID) {

		return _srvReqLocalService.getServiceRequestsListbyUserID(userID);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.serviceRequest.ServiceRequest> getSrvReqListByRoleStatusCustID(
			String[] status, String role, String customerID, boolean escalationFlag, int from, int to, String orderBy,
			String orderDir) {

		return _srvReqLocalService.getSrvReqListByRoleStatusCustID(status, role, customerID, escalationFlag, from, to,
				orderBy, orderDir);
	}

	@Override
	public int updateServiceRequest(com.atmc.bsl.db.domain.serviceRequest.ServiceRequest srvRequest) {

		return _srvReqLocalService.updateServiceRequest(srvRequest);
	}

	@Override
	public int updateServiceRequestAssignedRole(String refNo, String role, String status) {

		return _srvReqLocalService.updateServiceRequestAssignedRole(refNo, role, status);
	}

	@Override
	public SrvReqLocalService getWrappedService() {
		return _srvReqLocalService;
	}

	@Override
	public void setWrappedService(SrvReqLocalService srvReqLocalService) {
		_srvReqLocalService = srvReqLocalService;
	}

	private SrvReqLocalService _srvReqLocalService;

}