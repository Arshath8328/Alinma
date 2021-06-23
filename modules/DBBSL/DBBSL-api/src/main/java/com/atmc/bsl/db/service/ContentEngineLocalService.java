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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ContentEngine. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ContentEngineLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor = { PortalException.class, SystemException.class })
public interface ContentEngineLocalService extends BaseLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to
	 * <code>com.atmc.bsl.db.service.impl.ContentEngineLocalServiceImpl</code> and
	 * rerun ServiceBuilder to automatically copy the method declarations to this
	 * interface. Consume the content engine local service via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link
	 * ContentEngineLocalServiceUtil} if injection and service tracking are not
	 * available.
	 */

	/**
	 * Get the latest 3 news in the news folder
	 *
	 * @param themeDisplay
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<String> getHomeNews(ThemeDisplay themeDisplay);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * Gets the templated content strings for the vacancies, they must be in the
	 * vacancies folder
	 *
	 * @param themeDisplay
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Vector<Set<String>> getVacancies(ThemeDisplay themeDisplay, String locationSearch, String departmentSearch);

	/**
	 * Gets the vacancy title by articleID
	 *
	 * @return the vacancy title
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getVacanyTitleByArticleId(ThemeDisplay themeDisplay, String articleId);

}