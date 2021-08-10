package com.atmc.ps.policy.portlet;

import com.atmc.ps.policy.constants.PsPolicyPortletKeys;
import com.ejada.atmc.acl.db.custom.model.PSPolicy;
import com.ejada.atmc.acl.db.service.LNP2_PolicyMastrLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=PSPolicyWidget Portlet",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/Widget/view.jsp",
			"javax.portlet.name=" + PsPolicyPortletKeys.PSPolicyWidget,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class PSPolicyWidgetPortlet extends MVCPortlet{

	public static final Log LOG = LogFactoryUtil.getLog(PSPolicyWidgetPortlet.class);
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User loggedInUser = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
			List<PSPolicy> list = LNP2_PolicyMastrLocalServiceUtil.findAllPSPolicyByIqamaId(loggedInUser.getScreenName());
			LOG.info("-----------------------------------------PSPolicyWidget : "+list);
			renderRequest.setAttribute("PSPolicyList", list);
		} catch (PortalException e) {
			LOG.error(e.getMessage(), e);
		}
		super.render(renderRequest, renderResponse);
	}
	
}
