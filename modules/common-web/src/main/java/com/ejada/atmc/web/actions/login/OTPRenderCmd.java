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

package com.ejada.atmc.web.actions.login;


import com.ejada.atmc.web.constants.OTPPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Basel A.Aziz
 */
@Component(
	property = {
		"javax.portlet.name=" + OTPPortletKeys.OTP,
		"mvc.command.name=/auth/otp"
	},
	service = MVCRenderCommand.class
)
public class OTPRenderCmd implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		_log.info("OTP render");
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
				WebKeys.THEME_DISPLAY);
		boolean otpRedirect = (renderRequest.getPortletSession().getAttribute("otpredirect") != null);
		boolean requestMobile = (renderRequest.getPortletSession().getAttribute("requestmobile") != null);

		
		_log.info("otp redirect:" + otpRedirect);
		_log.info("mobile from request:" + requestMobile);
		if (otpRedirect)
		{
			renderRequest.getPortletSession().removeAttribute("otpredirect");
			return "/otp/otp_redirect.jsp";
		}
		
		if (themeDisplay.isSignedIn() || requestMobile)
	
			return "/otp/otp_auth_user.jsp";
		else 
			return "/otp/otp_unauth_user.jsp";
		
	}
	
	private static final Log _log = LogFactoryUtil.getLog(
			OTPRenderCmd.class);


}