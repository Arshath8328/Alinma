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
 * Provides the local service utility for SrvReqAttachment. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.SrvReqAttachmentLocalServiceImpl</code>
 * and is an access point for service operations in application layer code
 * running on the local server. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SrvReqAttachmentLocalService
 * @generated
 */
public class SrvReqAttachmentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to
	 * <code>com.atmc.bsl.db.service.impl.SrvReqAttachmentLocalServiceImpl</code>
	 * and rerun ServiceBuilder to regenerate this class.
	 */
	public static String addNewServiceRequestAttachment(
			com.atmc.bsl.db.domain.serviceRequest.ServiceRequestAttachment attachment) {

		return getService().addNewServiceRequestAttachment(attachment);
	}

	public static int deleteAttachmentFile(String fileID) {
		return getService().deleteAttachmentFile(fileID);
	}

	public static com.ejada.atmc.acl.db.model.ServiceRequestAttachments downloadAttachmentFile(String fileID) {

		return getService().downloadAttachmentFile(fileID);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.atmc.bsl.db.domain.serviceRequest.ServiceRequestAttachment> getServiceRequestAttachmentListbyActionId(
			String actionId) {

		return getService().getServiceRequestAttachmentListbyActionId(actionId);
	}

	public static java.util.List<com.atmc.bsl.db.domain.serviceRequest.ServiceRequestAttachment> getServiceRequestAttachmentListbyRefNo(
			String refNo) {

		return getService().getServiceRequestAttachmentListbyRefNo(refNo);
	}

	public static String saveServiceRequestFiles(String refNo, java.io.File file, String fileName, String actionId) {

		return getService().saveServiceRequestFiles(refNo, file, fileName, actionId);
	}

	public static SrvReqAttachmentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SrvReqAttachmentLocalService, SrvReqAttachmentLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SrvReqAttachmentLocalService.class);

		ServiceTracker<SrvReqAttachmentLocalService, SrvReqAttachmentLocalService> serviceTracker = new ServiceTracker<SrvReqAttachmentLocalService, SrvReqAttachmentLocalService>(
				bundle.getBundleContext(), SrvReqAttachmentLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}