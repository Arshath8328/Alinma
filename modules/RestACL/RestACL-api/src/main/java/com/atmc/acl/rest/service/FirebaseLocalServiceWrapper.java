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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FirebaseLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FirebaseLocalService
 * @generated
 */
public class FirebaseLocalServiceWrapper
	implements FirebaseLocalService, ServiceWrapper<FirebaseLocalService> {

	public FirebaseLocalServiceWrapper(
		FirebaseLocalService firebaseLocalService) {

		_firebaseLocalService = firebaseLocalService;
	}

	/**
	 * @return the fcmUrl
	 */
	@Override
	public String getFcmUrl() {
		return _firebaseLocalService.getFcmUrl();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _firebaseLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @return the serverKey
	 */
	@Override
	public String getServerKey() {
		return _firebaseLocalService.getServerKey();
	}

	@Override
	public void sendNotification(String tokenId, String title, String message) {
		_firebaseLocalService.sendNotification(tokenId, title, message);
	}

	/**
	 * @param fcmUrl the fcmUrl to set
	 */
	@Override
	public void setFcmUrl(String fcmUrl) {
		_firebaseLocalService.setFcmUrl(fcmUrl);
	}

	/**
	 * @param serverKey the serverKey to set
	 */
	@Override
	public void setServerKey(String serverKey) {
		_firebaseLocalService.setServerKey(serverKey);
	}

	@Override
	public FirebaseLocalService getWrappedService() {
		return _firebaseLocalService;
	}

	@Override
	public void setWrappedService(FirebaseLocalService firebaseLocalService) {
		_firebaseLocalService = firebaseLocalService;
	}

	private FirebaseLocalService _firebaseLocalService;

}