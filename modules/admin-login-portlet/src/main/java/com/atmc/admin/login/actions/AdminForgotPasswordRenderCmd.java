package com.atmc.admin.login.actions;

import com.atmc.admin.login.portlet.constants.AdminLoginPortletKeys;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		property = {
			"javax.portlet.name=" + AdminLoginPortletKeys.ADMINLOGIN,
			"mvc.command.name=/adminLogin/forgot_password"
		},
		service = MVCRenderCommand.class
	)
public class AdminForgotPasswordRenderCmd implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		Company company = themeDisplay.getCompany();

		if (!company.isSendPassword() && !company.isSendPasswordResetLink()) {
			return "/adminLogin/view.jsp";
		}

		renderResponse.setTitle(themeDisplay.translate("forgot-password"));

		return "/adminLogin/forgot_password.jsp";
	}
}
