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

package com.atmc.acl.rest.service.impl;

import com.atmc.acl.rest.service.FirebaseLocalServiceUtil;
import com.atmc.acl.rest.service.base.FirebaseServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the firebase remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.atmc.acl.rest.service.FirebaseService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    FirebaseServiceBaseImpl
 */
@Component(
		property = { "json.web.service.context.name=rest", "json.web.service.context.path=Firebase" },
		service = AopService.class
)
public class FirebaseServiceImpl extends FirebaseServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.atmc.acl.rest.service.FirebaseServiceUtil</code> to access
	 * the firebase remote service.
	 */
	public void sendNotification(String tokenId, String title, String message) {
		FirebaseLocalServiceUtil.sendNotification(tokenId, title, message);
	}
}