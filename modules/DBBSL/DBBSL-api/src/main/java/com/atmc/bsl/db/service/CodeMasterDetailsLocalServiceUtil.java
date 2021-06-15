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
 * Provides the local service utility for CodeMasterDetails. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.CodeMasterDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CodeMasterDetailsLocalService
 * @generated
 */
public class CodeMasterDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.CodeMasterDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.List
		<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>
				findByCodeCodeFreez(String code, String codeFreezYN)
			throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return getService().findByCodeCodeFreez(code, codeFreezYN);
	}

	public static java.util.List
		<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>
				findCodeMasterDesc(String code, String locale)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findCodeMasterDesc(code, locale);
	}

	public static String getCodeMasterDesc(
			String code, String codeSub, String locale)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCodeMasterDesc(code, codeSub, locale);
	}

	public static java.util.List
		<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails> getCustomCodes(
				String code)
			throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return getService().getCustomCodes(code);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CodeMasterDetailsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CodeMasterDetailsLocalService, CodeMasterDetailsLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CodeMasterDetailsLocalService.class);

		ServiceTracker
			<CodeMasterDetailsLocalService, CodeMasterDetailsLocalService>
				serviceTracker =
					new ServiceTracker
						<CodeMasterDetailsLocalService,
						 CodeMasterDetailsLocalService>(
							 bundle.getBundleContext(),
							 CodeMasterDetailsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}