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
 * Provides a wrapper for {@link SrvReqActionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SrvReqActionLocalService
 * @generated
 */
public class SrvReqActionLocalServiceWrapper
		implements ServiceWrapper<SrvReqActionLocalService>, SrvReqActionLocalService {

	public SrvReqActionLocalServiceWrapper(SrvReqActionLocalService srvReqActionLocalService) {

		_srvReqActionLocalService = srvReqActionLocalService;
	}

	@Override
	public String addNewServiceRequestAction(com.atmc.bsl.db.domain.serviceRequest.ServiceRequestAction action) {

		return _srvReqActionLocalService.addNewServiceRequestAction(action);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _srvReqActionLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.serviceRequest.ServiceRequestAction> getServiceRequestActionListbyRefNo(
			String refNo) {

		return _srvReqActionLocalService.getServiceRequestActionListbyRefNo(refNo);
	}

	@Override
	public SrvReqActionLocalService getWrappedService() {
		return _srvReqActionLocalService;
	}

	@Override
	public void setWrappedService(SrvReqActionLocalService srvReqActionLocalService) {

		_srvReqActionLocalService = srvReqActionLocalService;
	}

	private SrvReqActionLocalService _srvReqActionLocalService;

}