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

import com.atmc.bsl.db.domain.ServiceOutput;
import com.atmc.bsl.db.domain.serviceRequest.ServiceRequest;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;
import java.util.Locale;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for SrvReq. Methods of this service are
 * expected to have security checks based on the propagated JAAS credentials
 * because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SrvReqServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor = { PortalException.class, SystemException.class })
public interface SrvReqService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to
	 * <code>com.atmc.bsl.db.service.impl.SrvReqServiceImpl</code> and rerun
	 * ServiceBuilder to automatically copy the method declarations to this
	 * interface. Consume the srv req remote service via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link
	 * SrvReqServiceUtil} if injection and service tracking are not available.
	 */
	@JSONWebService(method = "POST", value = "add-new-service-request")
	public ServiceOutput<String> addNewServiceRequest(ServiceRequest srvRequest, String lang);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<ServiceRequest>> getServiceRequestsListByIdStatus(String iqamaId, String[] status)
			throws PortalException;

	public boolean sendEmail(String mailTo, String emailMsg, String msgTitle);

	public void sendSMS(Locale locale, String mobileNumber, String refNo, String msgKey);

}