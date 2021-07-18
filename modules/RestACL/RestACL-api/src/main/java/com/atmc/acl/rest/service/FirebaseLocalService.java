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

package com.atmc.acl.rest.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Firebase. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see FirebaseLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface FirebaseLocalService extends BaseLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.atmc.acl.rest.service.impl.FirebaseLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the firebase local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link FirebaseLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * @return the fcmUrl
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getFcmUrl();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @return the serverKey
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getServerKey();

	public void sendNotification(String tokenId, String title, String message);

	/**
	 * @param fcmUrl the fcmUrl to set
	 */
	public void setFcmUrl(String fcmUrl);

	/**
	 * @param serverKey the serverKey to set
	 */
	public void setServerKey(String serverKey);

}