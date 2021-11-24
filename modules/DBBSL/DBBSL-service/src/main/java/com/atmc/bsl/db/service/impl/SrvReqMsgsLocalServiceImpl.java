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

import com.atmc.bsl.db.service.base.SrvReqMsgsLocalServiceBaseImpl;
import com.ejada.atmc.acl.db.model.ServiceRequestMessages;
import com.ejada.atmc.acl.db.service.ServiceRequestMessagesLocalServiceUtil;
import com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequestMessage;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the srv req msgs local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.SrvReqMsgsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SrvReqMsgsLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.atmc.bsl.db.model.SrvReqMsgs", service = AopService.class)
public class SrvReqMsgsLocalServiceImpl extends SrvReqMsgsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.atmc.bsl.db.service.SrvReqMsgsLocalServiceUtil} to access the srv
	 * req msgs local service.
	 */
	@Override
	public List<ServiceRequestMessage> getServiceRequestMessageListbyRefNo(String referenceNo) {
		List<ServiceRequestMessages> msgsList = ServiceRequestMessagesLocalServiceUtil
				.findSrvsReqMsgsByRefNo(referenceNo);
		try {
			return getCustomServiceRequestMessages(msgsList);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private List<ServiceRequestMessage> getCustomServiceRequestMessages(List<ServiceRequestMessages> srvReqList)
			throws PortalException {
		List<ServiceRequestMessage> msgList = new ArrayList<>();

		if (srvReqList != null && !srvReqList.isEmpty()) {
			for (ServiceRequestMessages message : srvReqList) {
				ServiceRequestMessage msg = new ServiceRequestMessage();
				msg.setMessageId(String.valueOf(message.getMESSAGE_ID()));
				msg.setMessageTxt(message.getUSER_MESSAGE());
				msg.setRefNo(message.getREFERENCE_NO());
				msg.setTimeStamp(message.getTIME_STAMP());
				msg.setUserId(String.valueOf(message.getUSER_ID()));
				msg.setUserName(String.valueOf(message.getUSER_NAME()));
				msg.setUserType(message.getUSER_TYPE());
				msgList.add(msg);
			}
		}
		return msgList;
	}

	@Override
	public int addReplyMessage(ServiceRequestMessage msg) {
		// TODO Auto-generated method stub
		ServiceRequestMessages message = ServiceRequestMessagesLocalServiceUtil
				.createServiceRequestMessages(CounterLocalServiceUtil.increment());

		message.setREFERENCE_NO(msg.getRefNo());
		message.setUSER_ID(msg.getUserId());
		message.setUSER_NAME(msg.getUserName());
		message.setUSER_MESSAGE(msg.getMessageTxt());
		message.setTIME_STAMP(msg.getTimeStamp());
		message.setUSER_TYPE(msg.getUserType());

		ServiceRequestMessagesLocalServiceUtil.updateServiceRequestMessages(message);
		return 0;
	}

}