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

package com.ejada.atmc.acl.db.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Validation. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.ValidationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ValidationLocalService
 * @generated
 */
public class ValidationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.ValidationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static int IbanValidation(
			String countryCode, String bankCode, String accNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.sql.SQLException {

		return getService().IbanValidation(countryCode, bankCode, accNo);
	}

	public static ValidationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ValidationLocalService, ValidationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ValidationLocalService.class);

		ServiceTracker<ValidationLocalService, ValidationLocalService>
			serviceTracker =
				new ServiceTracker
					<ValidationLocalService, ValidationLocalService>(
						bundle.getBundleContext(), ValidationLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}