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

import com.ejada.atmc.acl.db.model.ServiceRequestAttachments;
import com.ejada.atmc.acl.db.service.base.ServiceRequestAttachmentsLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the service request attachments local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.db.service.ServiceRequestAttachmentsLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    ServiceRequestAttachmentsLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.ejada.atmc.acl.db.model.ServiceRequestAttachments",
		service = AopService.class
)
public class ServiceRequestAttachmentsLocalServiceImpl extends ServiceRequestAttachmentsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.ejada.atmc.acl.db.service.ServiceRequestAttachmentsLocalServiceUtil} to access the service request attachments
	 * local service.
	 */
	public List<ServiceRequestAttachments> findSrvReqAttachmentsByActionId(String actionId) {
		return serviceRequestAttachmentsFinder.findServiceRequestAttachmentByActionId(actionId);
	}

	public List<ServiceRequestAttachments> findSrvReqAttachmentsByRefNo(String refNo) {
		return serviceRequestAttachmentsFinder.findServiceRequestAttachmentByRefNo(refNo);
	}
}