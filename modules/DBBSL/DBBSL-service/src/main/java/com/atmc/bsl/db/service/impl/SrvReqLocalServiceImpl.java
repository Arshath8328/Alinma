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

import com.atmc.bsl.db.domain.serviceRequest.ServiceRequest;
import com.atmc.bsl.db.service.base.SrvReqLocalServiceBaseImpl;
import com.ejada.atmc.acl.db.model.ServiceRequestMaster;
import com.ejada.atmc.acl.db.service.ServiceRequestMasterLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the srv req local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.atmc.bsl.db.service.SrvReqLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    SrvReqLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.atmc.bsl.db.model.SrvReq",
		service = AopService.class
)
public class SrvReqLocalServiceImpl extends SrvReqLocalServiceBaseImpl {

	private static final Log _log = LogFactoryUtil.getLog(SrvReqLocalServiceImpl.class);

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.atmc.bsl.db.service.SrvReqLocalServiceUtil} to
	 * access the srv req local service.
	 */
	@Override
	public List<ServiceRequest> getServiceRequestsListbyUserID(String userID) {
		List<ServiceRequestMaster> requestList = ServiceRequestMasterLocalServiceUtil.findSrvsReqsByIqamaId(userID);
		return getCustomServiceRequestList(requestList);
	}

	@Override
	public ServiceRequest getServiceRequestbyRefNo(String refNo) {
		ServiceRequestMaster request;
		try {
			request = ServiceRequestMasterLocalServiceUtil.getServiceRequestMaster(refNo);
			return getCustomServiceMessage(request);
		} catch (PortalException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ServiceRequest> getServiceRequestsListByStatus(String[] status, String role) {
		List<ServiceRequestMaster> requestList = null;

		if (role.equals("Customer Service")) {
			requestList = ServiceRequestMasterLocalServiceUtil.findSrvsReqsByReqStatus(status);
		} else {
			requestList = ServiceRequestMasterLocalServiceUtil.findSrvsReqsByReqRoleStatus(status, role);
		}
		return getCustomServiceRequestList(requestList);
	}

	@Override
	public List<ServiceRequest> getSrvReqListByRoleStatusCustID(String[] status, String role, String customerID, boolean escalationFlag, int from, int to, String orderBy, String orderDir) {
		List<Object> requestList = null;
		if (from > 1)
			from = from + 1;
		if (orderBy != null && orderBy.equals(""))
			orderBy = "CREATION_DATE";
		if (orderDir != null && orderDir.equals(""))
			orderDir = "ASC";
		if (role.equals("Customer Service")) {
			requestList = ServiceRequestMasterLocalServiceUtil.findServiceRequestsByStatusRoleAdmin(null, status, customerID, escalationFlag, from, to, orderBy, orderDir);
		} else {
			requestList = ServiceRequestMasterLocalServiceUtil.findServiceRequestsByStatusRoleAdmin(role, status, customerID, escalationFlag, from, to, orderBy, orderDir);
		}
		return getAdminCustomServiceRequestList(requestList);
	}

	@Override
	public int countSrvReqListByRoleStatusCustID(String[] status, String role, String customerID, boolean escalationFlag) {
		if (role.equals("Customer Service")) {
			return ServiceRequestMasterLocalServiceUtil.countServiceRequestsByStatusRoleAdmin(null, status, customerID, escalationFlag);
		} else {
			return ServiceRequestMasterLocalServiceUtil.countServiceRequestsByStatusRoleAdmin(role, status, customerID, escalationFlag);
		}
	}

	@Override
	public List<ServiceRequest> getServiceRequestsListByEscalationFlag(String userRole, String closedStatus, boolean isAdmin) {
		List<ServiceRequestMaster> requestList = ServiceRequestMasterLocalServiceUtil.findSrvsReqsByEsclationFlag(userRole, closedStatus, isAdmin);
		return getCustomServiceRequestList(requestList);
	}

	private List<ServiceRequest> getCustomServiceRequestList(List<ServiceRequestMaster> srvReqList) {
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

	private List<ServiceRequest> getAdminCustomServiceRequestList(List<Object> srvReqList) {
		List<ServiceRequest> msgList = new ArrayList<>();

		if (srvReqList != null && !srvReqList.isEmpty()) {
			for (Object obj : srvReqList) {
				ServiceRequestMaster message = (ServiceRequestMaster) obj;
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

	private ServiceRequest getCustomServiceMessage(ServiceRequestMaster message) {
		ServiceRequest request = new ServiceRequest();
		if (message != null) {
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
		}
		return request;
	}

	@Override
	public String addNewServiceRequest(ServiceRequest srvRequest, String creator) {
		try {
			srvRequest.log();
			ServiceRequestMaster req = ServiceRequestMasterLocalServiceUtil.createServiceRequestMaster(String.valueOf(CounterLocalServiceUtil.increment()));
			_log.info(req.toString());
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
			req.setCREATION_DATE(srvRequest.getCreationDate());
			req.setCREATOR_USER_TYPE(srvRequest.getCreatorUserType());
			req.setUSER_NAME(srvRequest.getCreatorUserName());
			req.setASSIGNED_TO(srvRequest.getAssignedTo());
			req.setIBAN_NUMBER(srvRequest.getIbanNumber());
			req.setESCALATION_FLAG(srvRequest.isEscalatedFlag());
			ServiceRequestMasterLocalServiceUtil.updateServiceRequestMaster(req);
			return req.getREFERENCE_NO().toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateServiceRequest(ServiceRequest srvRequest) {
		try {
			srvRequest.log();
			ServiceRequestMaster req = ServiceRequestMasterLocalServiceUtil.getServiceRequestMaster(srvRequest.getReferenceNo());
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
			req.setCREATION_DATE(srvRequest.getCreationDate());
			req.setCREATOR_USER_TYPE(srvRequest.getCreatorUserType());
			req.setUSER_NAME(srvRequest.getCreatorUserName());
			req.setASSIGNED_TO(srvRequest.getAssignedTo());
			req.setIBAN_NUMBER(srvRequest.getIbanNumber());
			req.setESCALATION_FLAG(srvRequest.isEscalatedFlag());
			ServiceRequestMasterLocalServiceUtil.updateServiceRequestMaster(req);
			return 0;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 1;
		}
	}

	@Override
	public int updateServiceRequestAssignedRole(String refNo, String role, String status) {
		try {
			ServiceRequestMaster req = ServiceRequestMasterLocalServiceUtil.getServiceRequestMaster(refNo);
			req.setASSIGNED_TO(role);
			req.setREQUEST_STATUS(status);
			ServiceRequestMasterLocalServiceUtil.updateServiceRequestMaster(req);
			return 0;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 1;
		}
	}

}