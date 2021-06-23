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

import com.atmc.bsl.db.domain.serviceRequest.ServiceRequestAction;
import com.atmc.bsl.db.service.base.SrvReqActionLocalServiceBaseImpl;
import com.ejada.atmc.acl.db.model.ServiceRequestHistory;
import com.ejada.atmc.acl.db.service.ServiceRequestHistoryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the srv req action local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.SrvReqActionLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SrvReqActionLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.atmc.bsl.db.model.SrvReqAction", service = AopService.class)
public class SrvReqActionLocalServiceImpl extends SrvReqActionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.ejada.atmc.bsl.db.service.SrvReqActionLocalServiceUtil} to access the srv
	 * req action local service.
	 */
	public List<ServiceRequestAction> getServiceRequestActionListbyRefNo(String refNo) {
		List<ServiceRequestHistory> historyList = ServiceRequestHistoryLocalServiceUtil.findSrvReqHistoryByRefNo(refNo);
		try {
			return getCustomServiceRequestActions(historyList);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String addNewServiceRequestAction(ServiceRequestAction action) {
		// TODO Auto-generated method stub
		ServiceRequestHistory item = ServiceRequestHistoryLocalServiceUtil
				.createServiceRequestHistory(CounterLocalServiceUtil.increment());
		item.setACTION_DATE(action.getActionDate());
		item.setACTION_DETAILS(action.getActionDetails());
		item.setACTION_REMARKS(action.getActionRemarks());
		item.setACTION_TYPE(action.getActionType());
		item.setREFERENCE_NO(action.getReferenceNo());
		ServiceRequestHistoryLocalServiceUtil.updateServiceRequestHistory(item);
		return String.valueOf(item.getACTION_ID());
	}

	private List<ServiceRequestAction> getCustomServiceRequestActions(List<ServiceRequestHistory> historyList)
			throws PortalException {
		List<ServiceRequestAction> history = new ArrayList<>();

		if (historyList != null && !historyList.isEmpty()) {
			for (ServiceRequestHistory action : historyList) {
				ServiceRequestAction item = new ServiceRequestAction();
				item.setActionDate(action.getACTION_DATE());
				item.setActionDetails(action.getACTION_DETAILS());
				item.setActionID(action.getACTION_ID());
				item.setActionRemarks(action.getACTION_REMARKS());
				item.setActionType(action.getACTION_TYPE());
				item.setReferenceNo(action.getREFERENCE_NO());
				history.add(item);
			}
		}
		return history;
	}
}