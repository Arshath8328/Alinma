/*
 * MenuPortlet.java Jan 28, 2018  
 *
 * Copyright (c) 2005-2012 Ejada Solutions.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Ejada
 * Solutions, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Ejada.
 */
package vacancies.portlet.portlet;

import com.atmc.bsl.db.service.ContentEngineLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import vacancies.portlet.constants.VacanciesPortletKeys;

/**
 * @author Gasser
 *
 */
@Component(
	immediate = true, 
	property = { 
		"com.liferay.portlet.display-category=ATMC", 
		"com.liferay.portlet.instanceable=false", 
		"javax.portlet.display-name=ATMC Vacancies Portlet",
		"javax.portlet.init-param.template-path=/", 
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + VacanciesPortletKeys.VACANCIES,
		"javax.portlet.resource-bundle=content.Language", 
		"javax.portlet.security-role-ref=guest,power-user,user" 
	},
	service = Portlet.class
)
public class VacanciesPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(VacanciesPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		HttpServletRequest servletRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		if (servletRequest.getParameter(VacanciesPortletKeys.JOB_ID) != null) {
			renderRequest.setAttribute(VacanciesPortletKeys.JOB_ID, servletRequest.getParameter(VacanciesPortletKeys.JOB_ID));
			PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/redirector.jsp");
			dispatcher.forward(renderRequest, renderResponse);
		} else {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

			String locationSearch = renderRequest.getParameter("vacancyLocation");
			String departmentSearch = renderRequest.getParameter("vacancyDepartment");
			renderRequest.setAttribute(VacanciesPortletKeys.VACANCIES, ContentEngineLocalServiceUtil.getVacancies(themeDisplay, locationSearch, departmentSearch));
			super.doView(renderRequest, renderResponse);
		}

	}

	public void searchVacs(ActionRequest req, ActionResponse res) {
		_log.info("action" + req.getParameter("vacancyLocation") + req.getParameter("vacancyDepartment"));
	}
}
