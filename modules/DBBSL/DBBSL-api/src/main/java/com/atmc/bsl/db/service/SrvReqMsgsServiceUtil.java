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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for SrvReqMsgs. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.SrvReqMsgsServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SrvReqMsgsService
 * @generated
 */
public class SrvReqMsgsServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.SrvReqMsgsServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.atmc.bsl.db.domain.ServiceOutput<String> addReplyMessage(
		com.atmc.bsl.db.domain.serviceRequest.ServiceRequestMessage msg) {

		return getService().addReplyMessage(msg);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List
			<com.atmc.bsl.db.domain.serviceRequest.ServiceRequestMessage>>
				getServiceRequestMessageListbyRefNo(String referenceNo) {

		return getService().getServiceRequestMessageListbyRefNo(referenceNo);
	}

	public static SrvReqMsgsService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SrvReqMsgsService, SrvReqMsgsService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SrvReqMsgsService.class);

		ServiceTracker<SrvReqMsgsService, SrvReqMsgsService> serviceTracker =
			new ServiceTracker<SrvReqMsgsService, SrvReqMsgsService>(
				bundle.getBundleContext(), SrvReqMsgsService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}