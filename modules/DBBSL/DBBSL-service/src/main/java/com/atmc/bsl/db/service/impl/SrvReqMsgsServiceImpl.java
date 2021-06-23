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

import com.atmc.bsl.db.domain.ReturnCodes;
import com.atmc.bsl.db.domain.ServiceOutput;
import com.atmc.bsl.db.domain.serviceRequest.ServiceRequestMessage;
import com.atmc.bsl.db.service.base.SrvReqMsgsServiceBaseImpl;
import com.ejada.atmc.acl.db.model.ServiceRequestMessages;
import com.ejada.atmc.acl.db.service.ServiceRequestMessagesLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the srv req msgs remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.SrvReqMsgsService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SrvReqMsgsServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=dbbsl",
		"json.web.service.context.path=SrvReqMsgs" }, service = AopService.class)
public class SrvReqMsgsServiceImpl extends SrvReqMsgsServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.ejada.atmc.bsl.db.service.SrvReqMsgsServiceUtil} to access the srv req
	 * msgs remote service.
	 */
	public ServiceOutput<List<ServiceRequestMessage>> getServiceRequestMessageListbyRefNo(String referenceNo) {
		ServiceOutput<List<ServiceRequestMessage>> svcOutput = new ServiceOutput<List<ServiceRequestMessage>>();
		try {
			List<ServiceRequestMessages> msgsList = ServiceRequestMessagesLocalServiceUtil
					.findSrvsReqMsgsByRefNo(referenceNo);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(getCustomServiceRequestMessages(msgsList));
			return svcOutput;
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

	@JSONWebService(value = "add-reply-message", method = "POST")
	public ServiceOutput<String> addReplyMessage(ServiceRequestMessage msg) {

		// ServiceRequestMessage msg =
		// (ServiceRequestMessage)GsonUtilsLocalServiceUtil.fromGson(replyObj,
		// ServiceRequestMessage.class);
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			// TODO Auto-generated method stub
			ServiceRequestMessages message = ServiceRequestMessagesLocalServiceUtil
					.createServiceRequestMessages(CounterLocalServiceUtil.increment());

			message.setREFERENCE_NO(msg.getRefNo());
			message.setUSER_ID(msg.getUserId());
			message.setUSER_NAME(msg.getUserName());
			message.setUSER_MESSAGE(msg.getMessageTxt());
			message.setTIME_STAMP(new Date());
			message.setUSER_TYPE(msg.getUserType());

			ServiceRequestMessagesLocalServiceUtil.updateServiceRequestMessages(message);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject("0");
			return svcOutput;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}