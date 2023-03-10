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
 * Provides the remote service utility for SrvReq. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.SrvReqServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SrvReqService
 * @generated
 */
public class SrvReqServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.SrvReqServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String>
		addNewServiceRequest(
			com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequest srvRequest,
			String lang) {

		return getService().addNewServiceRequest(srvRequest, lang);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequest>>
				getServiceRequestsListByIdStatus(
					String iqamaId, String[] status)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getServiceRequestsListByIdStatus(iqamaId, status);
	}

	public static boolean sendEmail(
		String mailTo, String emailMsg, String msgTitle) {

		return getService().sendEmail(mailTo, emailMsg, msgTitle);
	}

	public static void sendSMS(
		java.util.Locale locale, String mobileNumber, String refNo,
		String msgKey) {

		getService().sendSMS(locale, mobileNumber, refNo, msgKey);
	}

	public static SrvReqService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SrvReqService, SrvReqService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SrvReqService.class);

		ServiceTracker<SrvReqService, SrvReqService> serviceTracker =
			new ServiceTracker<SrvReqService, SrvReqService>(
				bundle.getBundleContext(), SrvReqService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}