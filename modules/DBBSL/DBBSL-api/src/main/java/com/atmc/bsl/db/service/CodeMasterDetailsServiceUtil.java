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
 * Provides the remote service utility for CodeMasterDetails. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.CodeMasterDetailsServiceImpl</code> and is
 * an access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be accessed
 * remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CodeMasterDetailsService
 * @generated
 */
public class CodeMasterDetailsServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to
	 * <code>com.atmc.bsl.db.service.impl.CodeMasterDetailsServiceImpl</code> and
	 * rerun ServiceBuilder to regenerate this class.
	 */
	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>> getByCodeCodeFreez(
			String code, String codeFreezYN) throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getByCodeCodeFreez(code, codeFreezYN);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>> getCodeMasterList(
			String code, String locale) {

		return getService().getCodeMasterList(code, locale);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>> getCustomCodes(
			String code) {

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

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<String>> getQuickQuoteData(String locale) {

		return getService().getQuickQuoteData(locale);
	}

	public static CodeMasterDetailsService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CodeMasterDetailsService, CodeMasterDetailsService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CodeMasterDetailsService.class);

		ServiceTracker<CodeMasterDetailsService, CodeMasterDetailsService> serviceTracker = new ServiceTracker<CodeMasterDetailsService, CodeMasterDetailsService>(
				bundle.getBundleContext(), CodeMasterDetailsService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}