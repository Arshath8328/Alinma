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

import com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequest;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SrvReq. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see SrvReqLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SrvReqLocalService extends BaseLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.SrvReqLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the srv req local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link SrvReqLocalServiceUtil} if injection and service tracking are not available.
	 */
	public String addNewServiceRequest(
		ServiceRequest srvRequest, String creator);

	public int countSrvReqListByRoleStatusCustID(
		String[] status, String role, String customerID,
		boolean escalationFlag);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceRequest getServiceRequestbyRefNo(String refNo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ServiceRequest> getServiceRequestsListByEscalationFlag(
		String userRole, String closedStatus, boolean isAdmin);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ServiceRequest> getServiceRequestsListByStatus(
		String[] status, String role);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ServiceRequest> getServiceRequestsListbyUserID(String userID);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ServiceRequest> getSrvReqListByRoleStatusCustID(
		String[] status, String role, String customerID, boolean escalationFlag,
		int from, int to, String orderBy, String orderDir);

	public int updateServiceRequest(ServiceRequest srvRequest);

	public int updateServiceRequestAssignedRole(
		String refNo, String role, String status);

}