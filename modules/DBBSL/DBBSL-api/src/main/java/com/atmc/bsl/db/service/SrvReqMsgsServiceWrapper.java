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
 * Provides a wrapper for {@link SrvReqMsgsService}.
 *
 * @author Brian Wing Shun Chan
 * @see SrvReqMsgsService
 * @generated
 */
public class SrvReqMsgsServiceWrapper
	implements ServiceWrapper<SrvReqMsgsService>, SrvReqMsgsService {

	public SrvReqMsgsServiceWrapper(SrvReqMsgsService srvReqMsgsService) {
		_srvReqMsgsService = srvReqMsgsService;
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.ServiceOutput<String> addReplyMessage(
		com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequestMessage msg) {

		return _srvReqMsgsService.addReplyMessage(msg);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _srvReqMsgsService.getOSGiServiceIdentifier();
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.ServiceOutput
		<java.util.List
			<com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequestMessage>>
				getServiceRequestMessageListbyRefNo(String referenceNo) {

		return _srvReqMsgsService.getServiceRequestMessageListbyRefNo(
			referenceNo);
	}

	@Override
	public SrvReqMsgsService getWrappedService() {
		return _srvReqMsgsService;
	}

	@Override
	public void setWrappedService(SrvReqMsgsService srvReqMsgsService) {
		_srvReqMsgsService = srvReqMsgsService;
	}

	private SrvReqMsgsService _srvReqMsgsService;

}