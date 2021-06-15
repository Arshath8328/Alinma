package com.atmc.side.menu.portlet;

import com.atmc.side.menu.constants.SideMenuPortletKeys;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author bhavik
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=SideMenu",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/side.jsp",
		"javax.portlet.name=" + SideMenuPortletKeys.SIDE_MENU,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SideMenuPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getLayout().getGroupId();
		long parentId = themeDisplay.getLayout().getParentLayoutId();
		Locale locale = themeDisplay.getLocale();
		List<Layout> publicLayouts = LayoutLocalServiceUtil.getLayouts(groupId, false);
		List<Layout> siblingsLayouts = new ArrayList<>();
		for (int x = 0; x < publicLayouts.size(); x++) {
			if (publicLayouts.get(x).getParentLayoutId() == parentId)
				siblingsLayouts.add(publicLayouts.get(x));

		}
		renderRequest.setAttribute(SideMenuPortletKeys.SIBLINGS_LAYOUTS_PUBLIC, siblingsLayouts);

		super.doView(renderRequest, renderResponse);
	}
}