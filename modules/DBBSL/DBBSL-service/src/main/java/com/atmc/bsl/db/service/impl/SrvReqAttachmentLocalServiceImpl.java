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

package com.atmc.bsl.db.service.impl;

import com.atmc.bsl.db.domain.serviceRequest.ServiceRequestAttachment;
import com.atmc.bsl.db.service.base.SrvReqAttachmentLocalServiceBaseImpl;
import com.ejada.atmc.acl.db.exception.NoSuchServiceRequestAttachmentsException;
import com.ejada.atmc.acl.db.model.ServiceRequestAttachments;
import com.ejada.atmc.acl.db.service.ServiceRequestAttachmentsLocalServiceUtil;
import com.ejada.atmc.acl.db.service.persistence.ServiceRequestAttachmentsUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.io.ByteArrayFileInputStream;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the srv req attachment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.SrvReqAttachmentLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SrvReqAttachmentLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.atmc.bsl.db.model.SrvReqAttachment", service = AopService.class)
public class SrvReqAttachmentLocalServiceImpl extends SrvReqAttachmentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.atmc.bsl.db.service.SrvReqAttachmentLocalServiceUtil} to access the
	 * srv req attachment local service.
	 */
	public List<ServiceRequestAttachment> getServiceRequestAttachmentListbyRefNo(String refNo) {
		List<ServiceRequestAttachments> attachmentList = ServiceRequestAttachmentsLocalServiceUtil
				.findSrvReqAttachmentsByRefNo(refNo);
		try {
			return getCustomServiceRequestAttachments(attachmentList);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<ServiceRequestAttachment> getServiceRequestAttachmentListbyActionId(String actionId) {
		List<ServiceRequestAttachments> attachmentList = ServiceRequestAttachmentsLocalServiceUtil
				.findSrvReqAttachmentsByActionId(actionId);
		try {
			return getCustomServiceRequestAttachments(attachmentList);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private List<ServiceRequestAttachment> getCustomServiceRequestAttachments(
			List<ServiceRequestAttachments> attachmentList) throws PortalException {
		List<ServiceRequestAttachment> customList = new ArrayList<>();

		if (attachmentList != null && !attachmentList.isEmpty()) {
			for (ServiceRequestAttachments attachment : attachmentList) {
				ServiceRequestAttachment file = new ServiceRequestAttachment();
				file.setReferenceNo(attachment.getREFERENCE_NO());
				file.setFileName(attachment.getFILE_NAME());
				file.setFileId(attachment.getFILE_ID());
				// file.setFileContent(attachment.getFILE_CONTENT());
				file.setActionId(attachment.getACTION_ID());
				customList.add(file);
			}
		}
		return customList;
	}

	public String addNewServiceRequestAttachment(ServiceRequestAttachment attachment) {
		// TODO Auto-generated method stub
		ServiceRequestAttachments item = ServiceRequestAttachmentsLocalServiceUtil
				.createServiceRequestAttachments(CounterLocalServiceUtil.increment());
		item.setREFERENCE_NO(attachment.getReferenceNo());
		item.setFILE_NAME(attachment.getFileName());
		item.setFILE_ID(attachment.getFileId());
		item.setFILE_CONTENT(attachment.getFileContent());
		item.setACTION_ID(attachment.getActionId());
		ServiceRequestAttachmentsLocalServiceUtil.updateServiceRequestAttachments(item);
		return String.valueOf(item.getACTION_ID());
	}

	public String saveServiceRequestFiles(String refNo, File file, String fileName, String actionId) {

		ByteArrayFileInputStream inputStream = null;
		if (file != null) {
			inputStream = new ByteArrayFileInputStream(file, 1024);
			ServiceRequestAttachments item = ServiceRequestAttachmentsLocalServiceUtil
					.createServiceRequestAttachments(CounterLocalServiceUtil.increment());
			item.setREFERENCE_NO(refNo);
			item.setFILE_NAME(fileName);
			OutputBlob blobOutput = new OutputBlob(inputStream, file.length());
			item.setFILE_CONTENT(blobOutput);
			item.setACTION_ID(actionId);
			ServiceRequestAttachmentsLocalServiceUtil.updateServiceRequestAttachments(item);
			return String.valueOf(item.getACTION_ID());
		} else {
			return null;
		}
	}

	public ServiceRequestAttachments downloadAttachmentFile(String fileID) {
		ServiceRequestAttachments file;
		try {
			file = ServiceRequestAttachmentsUtil.findByPrimaryKey(Long.valueOf(fileID));
			_log.info("file-id : " + file.getFILE_ID());
			return file;
		} catch (NoSuchServiceRequestAttachmentsException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
			return null;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int deleteAttachmentFile(String fileID) {
		ServiceRequestAttachments file;
		try {
//			file = ServiceRequestAttachmentsUtil.remove(Long.valueOf(fileID));
			ServiceRequestAttachmentsLocalServiceUtil.deleteServiceRequestAttachments(Long.valueOf(fileID));
			return 1;
		} catch (NoSuchServiceRequestAttachmentsException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		} catch (NumberFormatException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		} catch (PortalException e) {
			_log.error(e.getMessage());
			e.printStackTrace();
		}
		return -1;
	}

	private static final Log _log = LogFactoryUtil.getLog(SrvReqAttachmentLocalServiceBaseImpl.class);

}