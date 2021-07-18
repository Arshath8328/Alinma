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
 * Provides a wrapper for {@link FirebaseService}.
 *
 * @author Brian Wing Shun Chan
 * @see FirebaseService
 * @generated
 */
public class FirebaseServiceWrapper
	implements FirebaseService, ServiceWrapper<FirebaseService> {

	public FirebaseServiceWrapper(FirebaseService firebaseService) {
		_firebaseService = firebaseService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _firebaseService.getOSGiServiceIdentifier();
	}

	@Override
	public void sendNotification(String tokenId, String title, String message) {
		_firebaseService.sendNotification(tokenId, title, message);
	}

	@Override
	public FirebaseService getWrappedService() {
		return _firebaseService;
	}

	@Override
	public void setWrappedService(FirebaseService firebaseService) {
		_firebaseService = firebaseService;
	}

	private FirebaseService _firebaseService;

}