package com.ejada.atmc.web.actions;

import com.ejada.atmc.web.constants.AdminLoginPortletKeys;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;


@Component(
		property = {
			"javax.portlet.name="+ AdminLoginPortletKeys.AdminLogin,
			"mvc.command.name=/adminLogin/adminLogin"
		},
		service = MVCRenderCommand.class
	)
public class AdminLoginRenderCmd implements MVCRenderCommand{

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		boolean loginredirect = (renderRequest.getParameter("loginredirect") != null);

		System.out.println("login redirect:" + loginredirect);
		if (loginredirect)
			return "/adminLogin/view.jsp";
		else 
			return "/adminLogin/view.jsp";
	}

}
