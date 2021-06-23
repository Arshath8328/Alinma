package com.atmc.menu.portlet;

import com.atmc.menu.constants.MenuPortletKeys;
//import com.ejada.atmc.bsl.db.service.NotificationsLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

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

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
//		
//		
//		ThemeDisplay themeDisplay= (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		//long portletGroupId= themeDisplay.getPortletGroupdId();
//		long groupId= themeDisplay.getLayout().getGroupId();
//		Locale locale =  themeDisplay.getLocale();
//		List<Layout> publicLayouts = LayoutLocalServiceUtil.getLayouts(groupId, false);
//		List<Layout> privateLayouts = LayoutLocalServiceUtil.getLayouts(groupId, true);
//		Set<Long> hiddens = new HashSet<Long>(); 
//		//System.out.println(publicLayouts.size());
//		//System.out.println(privateLayouts.size());
////		for (int x=0 ; x < publicLayouts.size() ; x++ )
////		{
////			Layout l = publicLayouts.get(x);
////			if (l.getHidden())
////			{
////				hiddens.add(l.getLayoutId());
////				System.out.println("hiddens ++" + l.getLayoutId() + l.getName(locale));
//			//}
//				
//			//System.out.println("=====================================" );
//			//System.out.println(l.getLayoutId() + ":"  + l.getName(locale) + ":" + l.getFriendlyURL());
//			//System.out.println(l.getHidden());			System.out.println(l.hasChildren() );
//			//System.out.println(l.isRootLayout() );
//			//System.out.println(l.getParentLayoutId() );
//			
//		//}
//		renderRequest.setAttribute(MenuPortletKeys.SITE_LAYOUTS_PUBLIC, publicLayouts);
//		renderRequest.setAttribute(MenuPortletKeys.SITE_LAYOUTS_PRIVATE, privateLayouts);
//		//renderRequest.setAttribute(MenuPortletKeys.HIDDEN_LAYOUTS, hiddens);
//		
//		
//		try {
//			long notificationsCount = NotificationsLocalServiceUtil.getUnreadNotificationsCount(themeDisplay.getUserId());
//			renderRequest.setAttribute("notificationsCount", notificationsCount);
//			
//		} catch (PortalException e) {
//			e.printStackTrace();
//		}
//		
//		super.doView(renderRequest, renderResponse);
	}
}
