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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.Locale;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for UserMgmt. Methods of this service
 * will not have security checks based on the propagated JAAS credentials
 * because this service can only be accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserMgmtLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor = { PortalException.class, SystemException.class })
public interface UserMgmtLocalService extends BaseLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to
	 * <code>com.atmc.bsl.db.service.impl.UserMgmtLocalServiceImpl</code> and rerun
	 * ServiceBuilder to automatically copy the method declarations to this
	 * interface. Consume the user mgmt local service via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link
	 * UserMgmtLocalServiceUtil} if injection and service tracking are not
	 * available.
	 */
	public User changeFirstTimeLoginPassword(long userId, String password, String reminderQueryQuestion,
			String reminderQueryAnswer) throws PortalException;

	public boolean createOrg(String orgCRNumber, String orgName, String orgArabicName, ServiceContext context);

	public User createUser(long companyId, String login, String password, String englishName, String arabicName,
			Locale language, String mobile, String email, ServiceContext serviceContext) throws PortalException;

	public User createUser(long companyId, String login, String password, String englishName, String arabicName,
			Locale language, String mobile, String email, ServiceContext serviceContext, String reminderQueryQuestion,
			String reminderQueryAnswer) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getAdminId();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public void synchronizeOrgs(ServiceContext context);

}