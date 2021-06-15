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

package com.ejada.atmc.acl.ws.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for OLPPayment. This utility wraps
 * <code>com.ejada.atmc.acl.ws.service.impl.OLPPaymentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see OLPPaymentLocalService
 * @generated
 */
public class OLPPaymentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.ws.service.impl.OLPPaymentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.ejada.atmc.acl.ws.domain.ConfirmOLPPayment confirmPayment(
		String transactionIdEnc) {

		return getService().confirmPayment(transactionIdEnc);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.ejada.atmc.acl.ws.domain.InitiateOLPPayment
		initiatePayment(
			String olpAlias, double amount, String currency,
			String merchantLandingURL, String merchantFailureURL) {

		return getService().initiatePayment(
			olpAlias, amount, currency, merchantLandingURL, merchantFailureURL);
	}

	public static OLPPaymentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<OLPPaymentLocalService, OLPPaymentLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(OLPPaymentLocalService.class);

		ServiceTracker<OLPPaymentLocalService, OLPPaymentLocalService>
			serviceTracker =
				new ServiceTracker
					<OLPPaymentLocalService, OLPPaymentLocalService>(
						bundle.getBundleContext(), OLPPaymentLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}