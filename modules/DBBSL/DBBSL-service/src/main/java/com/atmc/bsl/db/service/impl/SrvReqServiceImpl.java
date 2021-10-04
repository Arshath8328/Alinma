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
import com.atmc.bsl.db.domain.serviceRequest.ServiceRequest;
import com.atmc.bsl.db.service.base.SrvReqServiceBaseImpl;
import com.ejada.atmc.acl.db.model.ServiceRequestMaster;
import com.ejada.atmc.acl.db.service.SMSLocalServiceUtil;
import com.ejada.atmc.acl.db.service.SendEmailServiceUtil;
import com.ejada.atmc.acl.db.service.ServiceRequestMasterLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the srv req remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.atmc.bsl.db.service.SrvReqService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    SrvReqServiceBaseImpl
 */
@Component(
		property =
		{ "json.web.service.context.name=dbbsl", "json.web.service.context.path=SrvReq" },
		service = AopService.class
)
public class SrvReqServiceImpl extends SrvReqServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.atmc.bsl.db.service.SrvReqServiceUtil} to access the
	 * srv req remote service.
	 */
	private static final Log _log = LogFactoryUtil.getLog(SrvReqServiceImpl.class);

	public ServiceOutput<List<ServiceRequest>> getServiceRequestsListByIdStatus(String iqamaId, String[] status) throws PortalException {
		ServiceOutput<List<ServiceRequest>> svcOutput = new ServiceOutput<List<ServiceRequest>>();
		try {
			List<ServiceRequestMaster> requestList = ServiceRequestMasterLocalServiceUtil.findSrvsReqsByIdStatus(iqamaId, status);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(getCustomServiceRequests(requestList));
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;

	}

	private List<ServiceRequest> getCustomServiceRequests(List<ServiceRequestMaster> srvReqList) {
		List<ServiceRequest> msgList = new ArrayList<>();

		if (srvReqList != null && !srvReqList.isEmpty()) {
			for (ServiceRequestMaster message : srvReqList) {
				ServiceRequest request = new ServiceRequest();
				request.setReferenceNo(message.getREFERENCE_NO());
				request.setSource(message.getSOURCE());
				request.setRequestCategory(message.getREQUEST_CATEGORY());
				request.setRequestType(message.getREQUEST_TYPE());
				request.setProductType(message.getPRODUCT_TYPE());
				request.setRequestMessage(message.getREQUEST_MESSAGE());
				request.setIqamaId(message.getIQAMA_ID());
				request.setEmail(message.getEMAIL());
				request.setMobile(message.getMOBILE());
				request.setRequestStatus(message.getREQUEST_STATUS());
				request.setEmailFlag(message.isEMAIL_FLAG());
				request.setCreatorUserId(message.getCREATOR_USER_ID());
				request.setCreationDate(message.getCREATION_DATE());
				request.setCreatorUserType(message.getCREATOR_USER_TYPE());
				request.setCreatorUserName(message.getUSER_NAME());
				request.setAssignedTo(message.getASSIGNED_TO());
				request.setIbanNumber(message.getIBAN_NUMBER());
				request.setEscalatedFlag(message.isESCALATION_FLAG());
				msgList.add(request);
			}
		}
		return msgList;
	}

	@JSONWebService(
			value = "add-new-service-request",
			method = "POST"
	)
	public ServiceOutput<String> addNewServiceRequest(ServiceRequest srvRequest, String lang) {
		// TODO Auto-generated method stub
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		String refNo = null;

		try {
			srvRequest.log();
			ServiceRequestMaster req = ServiceRequestMasterLocalServiceUtil.createServiceRequestMaster(String.valueOf(CounterLocalServiceUtil.increment()));
			req.setSOURCE(srvRequest.getSource());
			req.setREQUEST_CATEGORY(srvRequest.getRequestCategory());
			req.setREQUEST_TYPE(srvRequest.getRequestType());
			req.setPRODUCT_TYPE(srvRequest.getProductType());
			req.setREQUEST_MESSAGE(srvRequest.getRequestMessage());
			req.setIQAMA_ID(srvRequest.getIqamaId());
			req.setEMAIL(srvRequest.getEmail());
			req.setMOBILE(srvRequest.getMobile());
			req.setREQUEST_STATUS(srvRequest.getRequestStatus());
			req.setEMAIL_FLAG(srvRequest.isEmailFlag());
			req.setCREATOR_USER_ID(srvRequest.getCreatorUserId());
			req.setCREATION_DATE(new Date());
			req.setCREATOR_USER_TYPE(srvRequest.getCreatorUserType());
			req.setUSER_NAME(srvRequest.getCreatorUserName());
			req.setASSIGNED_TO(srvRequest.getAssignedTo());
			req.setIBAN_NUMBER(srvRequest.getIbanNumber());
			req.setESCALATION_FLAG(srvRequest.isEscalatedFlag());
			ServiceRequestMasterLocalServiceUtil.updateServiceRequestMaster(req);
			svcOutput.setOutputCode(ServiceOutput.SUCCESS);
			svcOutput.setOutputObject(req.getREFERENCE_NO().toString());

			refNo = req.getREFERENCE_NO().toString();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			svcOutput.setOutputCode(ServiceOutput.FAIL);
			svcOutput.setOutputObject(null);
		}

		try {
			if (lang.equals("en"))
				lang += "_US";
			else
				lang += "_SA";
			Locale locale = new Locale(lang);
			String mailMessage = "", mailTitle = "";
			if (refNo != null) {
				if (srvRequest.getRequestCategory().equals("complaints")) {
					mailMessage = LanguageUtil.format(locale, "SERVICE_REQUEST_COMPLAINT", new String[] { srvRequest.getCreatorUserName().split(" ")[0], refNo });
					mailTitle = LanguageUtil.get(locale, "SERVICE_REQUEST_COMPLAINT_TITLE");
					sendSMS(locale, srvRequest.getMobile(), refNo, "SERVICE_REQUEST_COMPLAINT_SMS");
				} else if (srvRequest.getRequestCategory().equals("inquiries")) {
					mailMessage = LanguageUtil.format(locale, "SERVICE_REQUEST_INQUIRY", new String[] { srvRequest.getCreatorUserName().split(" ")[0], refNo });
					mailTitle = LanguageUtil.get(locale, "SERVICE_REQUEST_INQUIRY_TITLE");
				} else if (srvRequest.getRequestCategory().equals("suggestions")) {
					mailMessage = LanguageUtil.format(locale, "SERVICE_REQUEST_SUGGESTION", new String[] { srvRequest.getCreatorUserName().split(" ")[0], refNo });
					mailTitle = LanguageUtil.get(locale, "SERVICE_REQUEST_SUGGESTION_TITLE");
				}
				sendEmail(srvRequest.getEmail(), mailMessage, mailTitle);
			} else {
				svcOutput.setOutputCode(ServiceOutput.FAIL);
				svcOutput.setOutputObject(null);
			}
		} catch (Exception eex) {
			eex.printStackTrace();
			svcOutput.setOutputCode(ServiceOutput.USER_EMAIL_ADDRESS_FAIL);
			svcOutput.setOutputObject(null);
		}
		return svcOutput;
	}

	public boolean sendEmail(String mailTo, String emailMsg, String msgTitle) {
		List<File> files = new ArrayList<File>();
		List<String> filesName = new ArrayList<String>();
		_log.info("Customer Service - Sending Mail To : " + mailTo);
		_log.info("Customer Service - Mail  Msg : " + emailMsg);
		boolean mailflag = SendEmailServiceUtil.sendEmail(mailTo, msgTitle, emailMsg, filesName, files);
		_log.info("Email sending Flag : " + mailflag);
		return mailflag;
	}

	public void sendSMS(Locale locale, String mobileNumber, String refNo, String msgKey) {
		try {
			_log.info("Customer Service - Sending SMS To : " + mobileNumber);
			_log.info("Customer Service - SMS RefNo : " + refNo);
			String smsMsg = "";
			smsMsg = LanguageUtil.format(locale, msgKey, refNo);
			SMSLocalServiceUtil.sendSms(smsMsg, mobileNumber);
			_log.info("Sent SMS Message : " + smsMsg);
			_log.info("SMS sent Successfully");
		} catch (PortalException | SQLException ex) {
			_log.error("Failed to send SMS");
		}
	}

}