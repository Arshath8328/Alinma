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
 * Provides a wrapper for {@link ContentEngineLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContentEngineLocalService
 * @generated
 */
public class ContentEngineLocalServiceWrapper
		implements ContentEngineLocalService, ServiceWrapper<ContentEngineLocalService> {

	public ContentEngineLocalServiceWrapper(ContentEngineLocalService contentEngineLocalService) {

		_contentEngineLocalService = contentEngineLocalService;
	}

	/**
	 * Get the latest 3 news in the news folder
	 *
	 * @param themeDisplay
	 * @return
	 */
	@Override
	public java.util.List<String> getHomeNews(com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay) {

		return _contentEngineLocalService.getHomeNews(themeDisplay);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _contentEngineLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Gets the templated content strings for the vacancies, they must be in the
	 * vacancies folder
	 *
	 * @param themeDisplay
	 * @return
	 */
	@Override
	public java.util.Vector<java.util.Set<String>> getVacancies(
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay, String locationSearch, String departmentSearch) {

		return _contentEngineLocalService.getVacancies(themeDisplay, locationSearch, departmentSearch);
	}

	/**
	 * Gets the vacancy title by articleID
	 *
	 * @return the vacancy title
	 */
	@Override
	public String getVacanyTitleByArticleId(com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
			String articleId) {

		return _contentEngineLocalService.getVacanyTitleByArticleId(themeDisplay, articleId);
	}

	@Override
	public ContentEngineLocalService getWrappedService() {
		return _contentEngineLocalService;
	}

	@Override
	public void setWrappedService(ContentEngineLocalService contentEngineLocalService) {

		_contentEngineLocalService = contentEngineLocalService;
	}

	private ContentEngineLocalService _contentEngineLocalService;

}