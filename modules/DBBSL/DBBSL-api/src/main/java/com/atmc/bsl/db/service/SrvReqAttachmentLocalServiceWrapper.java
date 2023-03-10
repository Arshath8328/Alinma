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
 * Provides a wrapper for {@link SrvReqAttachmentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SrvReqAttachmentLocalService
 * @generated
 */
public class SrvReqAttachmentLocalServiceWrapper
	implements ServiceWrapper<SrvReqAttachmentLocalService>,
			   SrvReqAttachmentLocalService {

	public SrvReqAttachmentLocalServiceWrapper(
		SrvReqAttachmentLocalService srvReqAttachmentLocalService) {

		_srvReqAttachmentLocalService = srvReqAttachmentLocalService;
	}

	@Override
	public String addNewServiceRequestAttachment(
		com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequestAttachment
			attachment) {

		return _srvReqAttachmentLocalService.addNewServiceRequestAttachment(
			attachment);
	}

	@Override
	public int deleteAttachmentFile(String fileID) {
		return _srvReqAttachmentLocalService.deleteAttachmentFile(fileID);
	}

	@Override
	public com.ejada.atmc.acl.db.model.ServiceRequestAttachments
		downloadAttachmentFile(String fileID) {

		return _srvReqAttachmentLocalService.downloadAttachmentFile(fileID);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _srvReqAttachmentLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List
		<com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequestAttachment>
			getServiceRequestAttachmentListbyActionId(String actionId) {

		return _srvReqAttachmentLocalService.
			getServiceRequestAttachmentListbyActionId(actionId);
	}

	@Override
	public java.util.List
		<com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequestAttachment>
			getServiceRequestAttachmentListbyRefNo(String refNo) {

		return _srvReqAttachmentLocalService.
			getServiceRequestAttachmentListbyRefNo(refNo);
	}

	@Override
	public String saveServiceRequestFiles(
		String refNo, java.io.File file, String fileName, String actionId) {

		return _srvReqAttachmentLocalService.saveServiceRequestFiles(
			refNo, file, fileName, actionId);
	}

	@Override
	public SrvReqAttachmentLocalService getWrappedService() {
		return _srvReqAttachmentLocalService;
	}

	@Override
	public void setWrappedService(
		SrvReqAttachmentLocalService srvReqAttachmentLocalService) {

		_srvReqAttachmentLocalService = srvReqAttachmentLocalService;
	}

	private SrvReqAttachmentLocalService _srvReqAttachmentLocalService;

}