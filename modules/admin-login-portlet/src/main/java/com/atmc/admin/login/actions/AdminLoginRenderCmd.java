package com.atmc.admin.login.actions;

import com.atmc.admin.login.portlet.constants.AdminLoginPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		property = { "javax.portlet.name=" + AdminLoginPortletKeys.ADMINLOGIN, "mvc.command.name=/adminLogin/adminLogin" },
		service = MVCRenderCommand.class
)
public class AdminLoginRenderCmd implements MVCRenderCommand {

	public static Log _log = LogFactoryUtil.getLog(AdminLoginRenderCmd.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

		boolean loginredirect = (renderRequest.getParameter("loginredirect") != null);

		_log.info("login redirect:" + loginredirect);
		if (loginredirect)
			return "/adminLogin/view.jsp";
		else
			return "/adminLogin/view.jsp";
	}

}
