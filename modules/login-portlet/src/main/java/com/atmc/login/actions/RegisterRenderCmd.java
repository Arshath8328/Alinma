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


import com.atmc.login.constants.LoginPortletKeys;
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
		"javax.portlet.name=" + LoginPortletKeys.LOGIN,
		"mvc.command.name=/login/register"
	},
	service = MVCRenderCommand.class
)
public class RegisterRenderCmd implements MVCRenderCommand {
	Log _log = LogFactoryUtil.getLog(this.getClass());
	
	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		boolean loginredirect = (renderRequest.getParameter("loginredirect") != null);
		_log.info("login redirect:" + loginredirect);
		
		boolean changePwd = (renderRequest.getParameter("changePwd") != null);
		_log.info("changePwd:" + changePwd);
		if (loginredirect)
			return "/login_redirect.jsp";
		else if (changePwd)
			return "/register_step3.jsp";
		else
			return "/register_step1.jsp";
	}

}