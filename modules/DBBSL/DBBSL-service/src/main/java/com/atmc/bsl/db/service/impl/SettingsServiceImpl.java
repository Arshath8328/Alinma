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

package com.atmc.bsl.db.service.impl;

import com.atmc.bsl.db.service.SettingsLocalServiceUtil;
import com.atmc.bsl.db.service.base.SettingsServiceBaseImpl;
import com.ejada.atmc.bsl.db.domain.ReturnCodes;
import com.ejada.atmc.bsl.db.domain.ServiceOutput;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the settings remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.SettingsService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SettingsServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=dbbsl",
		"json.web.service.context.path=Settings" }, service = AopService.class)
public class SettingsServiceImpl extends SettingsServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.atmc.bsl.db.service.SettingsServiceUtil} to access the settings
	 * remote service.
	 */
	public ServiceOutput<String> updateEmail(String companyId, String screenName, String Email) throws PortalException {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			SettingsLocalServiceUtil.updateEmailFn(Long.valueOf(companyId), screenName, Email);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;
	}

	public ServiceOutput<String> updateMobile(String companyId, String screenName, String phoneNo)
			throws PortalException {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			SettingsLocalServiceUtil.updateMobileFn(Long.valueOf(companyId), screenName, phoneNo);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return svcOutput;
	}

	public ServiceOutput<String> changePassword(String companyId, String screenName, String currentPassword,
			String password1, String password2) {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			SettingsLocalServiceUtil.changePasswordFn(Long.valueOf(companyId), screenName, currentPassword, password1,
					password2);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			// svcOutput.setOutputObject(settingOut);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return svcOutput;
	}
}