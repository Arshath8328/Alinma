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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for SrvReq. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.SrvReqLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SrvReqLocalService
 * @generated
 */
public class SrvReqLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.SrvReqLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static String addNewServiceRequest(
		com.atmc.bsl.db.domain.serviceRequest.ServiceRequest srvRequest,
		String creator) {

		return getService().addNewServiceRequest(srvRequest, creator);
	}

	public static int countSrvReqListByRoleStatusCustID(
		String[] status, String role, String customerID,
		boolean escalationFlag) {

		return getService().countSrvReqListByRoleStatusCustID(
			status, role, customerID, escalationFlag);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.atmc.bsl.db.domain.serviceRequest.ServiceRequest
		getServiceRequestbyRefNo(String refNo) {

		return getService().getServiceRequestbyRefNo(refNo);
	}

	public static java.util.List
		<com.atmc.bsl.db.domain.serviceRequest.ServiceRequest>
			getServiceRequestsListByEscalationFlag(
				String userRole, String closedStatus, boolean isAdmin) {

		return getService().getServiceRequestsListByEscalationFlag(
			userRole, closedStatus, isAdmin);
	}

	public static java.util.List
		<com.atmc.bsl.db.domain.serviceRequest.ServiceRequest>
			getServiceRequestsListByStatus(String[] status, String role) {

		return getService().getServiceRequestsListByStatus(status, role);
	}

	public static java.util.List
		<com.atmc.bsl.db.domain.serviceRequest.ServiceRequest>
			getServiceRequestsListbyUserID(String userID) {

		return getService().getServiceRequestsListbyUserID(userID);
	}

	public static java.util.List
		<com.atmc.bsl.db.domain.serviceRequest.ServiceRequest>
			getSrvReqListByRoleStatusCustID(
				String[] status, String role, String customerID,
				boolean escalationFlag, int from, int to, String orderBy,
				String orderDir) {

		return getService().getSrvReqListByRoleStatusCustID(
			status, role, customerID, escalationFlag, from, to, orderBy,
			orderDir);
	}

	public static int updateServiceRequest(
		com.atmc.bsl.db.domain.serviceRequest.ServiceRequest srvRequest) {

		return getService().updateServiceRequest(srvRequest);
	}

	public static int updateServiceRequestAssignedRole(
		String refNo, String role, String status) {

		return getService().updateServiceRequestAssignedRole(
			refNo, role, status);
	}

	public static SrvReqLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SrvReqLocalService, SrvReqLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SrvReqLocalService.class);

		ServiceTracker<SrvReqLocalService, SrvReqLocalService> serviceTracker =
			new ServiceTracker<SrvReqLocalService, SrvReqLocalService>(
				bundle.getBundleContext(), SrvReqLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}