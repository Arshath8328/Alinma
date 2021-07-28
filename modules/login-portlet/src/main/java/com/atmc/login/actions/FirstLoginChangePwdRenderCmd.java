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

package com.atmc.login.actions;


import com.atmc.web.constants.FirstLoginChangePwdPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Basel A.Aziz
 */
@Component(
	property = {
		"javax.portlet.name="+ FirstLoginChangePwdPortletKeys.FIRST_LOGIN_CHG_PWD,
		"mvc.command.name=/login/firstLoginChgPwd"
	},
	service = MVCRenderCommand.class
)
public class FirstLoginChangePwdRenderCmd implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		
		_log.debug("First Login Change Pwd render");
		
		boolean reminderQueryError = (renderRequest.getParameter("reminderQueryError")!=null);
		if (reminderQueryError)
			return "/firstLoginChgPwd/reminder_query.jsp";
		
		return "/firstLoginChgPwd/view.jsp";
		
	}
	
	private static final Log _log = LogFactoryUtil.getLog(FirstLoginChangePwdRenderCmd.class);

}