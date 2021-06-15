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

package com.ejada.atmc.acl.db.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface ServiceRequestMasterFinder {

	public java.util.List<com.ejada.atmc.acl.db.model.ServiceRequestMaster>
		findServiceRequestsByIqamaId(String iqamaId);

	public java.util.List<com.ejada.atmc.acl.db.model.ServiceRequestMaster>
		findServiceRequestsByIdStatus(String iqamaId, String[] lstStatus);

	public java.util.List<com.ejada.atmc.acl.db.model.ServiceRequestMaster>
		findServiceRequestsByEscalationFlag(
			String userRole, String closedStatus, boolean isAdmin);

	public java.util.List<com.ejada.atmc.acl.db.model.ServiceRequestMaster>
		findServiceRequestsByReqStatus(String[] lstStatus);

	public java.util.List<com.ejada.atmc.acl.db.model.ServiceRequestMaster>
		findServiceRequestsByReqRoleStatus(String[] lstStatus, String role);

	public java.util.List<Object> findServiceRequestsByStatusRoleAdmin(
		String role, String[] lstStatus, String customerID,
		boolean escalationFlag, int from, int to, String orderBy,
		String orderDir);

	public int countServiceRequestsByStatusRoleAdmin(
		String role, String[] lstStatus, String customerID,
		boolean escalationFlag);

}