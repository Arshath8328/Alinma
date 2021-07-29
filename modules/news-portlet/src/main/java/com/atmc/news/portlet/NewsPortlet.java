package com.atmc.news.portlet;

import com.atmc.bsl.db.service.ContentEngineLocalServiceUtil;
import com.atmc.news.constants.NewsPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author vidit
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=News",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + NewsPortletKeys.NEWS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NewsPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(NewsPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		renderRequest.setAttribute(NewsPortletKeys.NEWS, ContentEngineLocalServiceUtil.getHomeNews(themeDisplay));
		super.doView(renderRequest, renderResponse);

	}

	public void searchVacs(ActionRequest req, ActionResponse res) {
		_log.info("action" + req.getParameter("vacancyLocation") + req.getParameter("vacancyDepartment"));
	}
}