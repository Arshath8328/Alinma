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

import com.ejada.atmc.acl.db.model.ServiceRequestAttachments;
import com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequestAttachment;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.io.File;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SrvReqAttachment. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see SrvReqAttachmentLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SrvReqAttachmentLocalService extends BaseLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.SrvReqAttachmentLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the srv req attachment local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link SrvReqAttachmentLocalServiceUtil} if injection and service tracking are not available.
	 */
	public String addNewServiceRequestAttachment(
		ServiceRequestAttachment attachment);

	public int deleteAttachmentFile(String fileID);

	public ServiceRequestAttachments downloadAttachmentFile(String fileID);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ServiceRequestAttachment>
		getServiceRequestAttachmentListbyActionId(String actionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ServiceRequestAttachment>
		getServiceRequestAttachmentListbyRefNo(String refNo);

	public String saveServiceRequestFiles(
		String refNo, File file, String fileName, String actionId);

}