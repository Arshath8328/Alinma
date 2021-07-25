package com.atmc.menu.portlet;

import com.atmc.bsl.db.service.NotificationsLocalServiceUtil;
import com.atmc.menu.constants.MenuPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gasser 
 *
 */
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=ATMC",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=ATMC Menu Portlet",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.name=" + MenuPortletKeys.MENU,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=guest,power-user,user"
		},
		service = Portlet.class
)
public class MenuPortlet extends MVCPortlet
{
	private static final Log _log = LogFactoryUtil.getLog(MenuPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// long portletGroupId= themeDisplay.getPortletGroupdId();
		long groupId = themeDisplay.getLayout().getGroupId();
		List<Layout> publicLayouts = LayoutLocalServiceUtil.getLayouts(groupId, false);
		List<Layout> privateLayouts = LayoutLocalServiceUtil.getLayouts(groupId, true);
		// _log.info(publicLayouts.size());
		// _log.info(privateLayouts.size());
//		for (int x=0 ; x < publicLayouts.size() ; x++ )
//		{
//			Layout l = publicLayouts.get(x);
//			if (l.getHidden())
//			{
//				hiddens.add(l.getLayoutId());
//				_log.info("hiddens ++" + l.getLayoutId() + l.getName(locale));
		// }

		// _log.info("=====================================" );
		// _log.info(l.getLayoutId() + ":" + l.getName(locale) + ":" +
		// l.getFriendlyURL());
		// _log.info(l.getHidden()); _log.info(l.hasChildren() );
		// _log.info(l.isRootLayout() );
		// _log.info(l.getParentLayoutId() );

		// }
		renderRequest.setAttribute(MenuPortletKeys.SITE_LAYOUTS_PUBLIC, publicLayouts);
		renderRequest.setAttribute(MenuPortletKeys.SITE_LAYOUTS_PRIVATE, privateLayouts);
		// renderRequest.setAttribute(MenuPortletKeys.HIDDEN_LAYOUTS, hiddens);

		try {
			long notificationsCount = NotificationsLocalServiceUtil.getUnreadNotificationsCount(themeDisplay.getUserId());
			renderRequest.setAttribute("notificationsCount", notificationsCount);

		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}
}
