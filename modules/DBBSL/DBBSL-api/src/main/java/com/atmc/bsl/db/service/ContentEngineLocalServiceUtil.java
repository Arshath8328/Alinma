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
 * Provides the local service utility for ContentEngine. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.ContentEngineLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ContentEngineLocalService
 * @generated
 */
public class ContentEngineLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to
	 * <code>com.atmc.bsl.db.service.impl.ContentEngineLocalServiceImpl</code> and
	 * rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Get the latest 3 news in the news folder
	 *
	 * @param themeDisplay
	 * @return
	 */
	public static java.util.List<String> getHomeNews(com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay) {

		return getService().getHomeNews(themeDisplay);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Gets the templated content strings for the vacancies, they must be in the
	 * vacancies folder
	 *
	 * @param themeDisplay
	 * @return
	 */
	public static java.util.Vector<java.util.Set<String>> getVacancies(
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay, String locationSearch, String departmentSearch) {

		return getService().getVacancies(themeDisplay, locationSearch, departmentSearch);
	}

	/**
	 * Gets the vacancy title by articleID
	 *
	 * @return the vacancy title
	 */
	public static String getVacanyTitleByArticleId(com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
			String articleId) {

		return getService().getVacanyTitleByArticleId(themeDisplay, articleId);
	}

	public static ContentEngineLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ContentEngineLocalService, ContentEngineLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ContentEngineLocalService.class);

		ServiceTracker<ContentEngineLocalService, ContentEngineLocalService> serviceTracker = new ServiceTracker<ContentEngineLocalService, ContentEngineLocalService>(
				bundle.getBundleContext(), ContentEngineLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}