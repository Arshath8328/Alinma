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
 * Provides a wrapper for {@link SrvReqService}.
 *
 * @author Brian Wing Shun Chan
 * @see SrvReqService
 * @generated
 */
public class SrvReqServiceWrapper
	implements ServiceWrapper<SrvReqService>, SrvReqService {

	public SrvReqServiceWrapper(SrvReqService srvReqService) {
		_srvReqService = srvReqService;
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> addNewServiceRequest(
		com.atmc.bsl.db.domain.serviceRequest.ServiceRequest srvRequest,
		String lang) {

		return _srvReqService.addNewServiceRequest(srvRequest, lang);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _srvReqService.getOSGiServiceIdentifier();
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.serviceRequest.ServiceRequest>>
				getServiceRequestsListByIdStatus(
					String iqamaId, String[] status)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _srvReqService.getServiceRequestsListByIdStatus(iqamaId, status);
	}

	@Override
	public boolean sendEmail(String mailTo, String emailMsg, String msgTitle) {
		return _srvReqService.sendEmail(mailTo, emailMsg, msgTitle);
	}

	@Override
	public void sendSMS(
		java.util.Locale locale, String mobileNumber, String refNo,
		String msgKey) {

		_srvReqService.sendSMS(locale, mobileNumber, refNo, msgKey);
	}

	@Override
	public SrvReqService getWrappedService() {
		return _srvReqService;
	}

	@Override
	public void setWrappedService(SrvReqService srvReqService) {
		_srvReqService = srvReqService;
	}

	private SrvReqService _srvReqService;

}