package friendly.url.portlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import friendly.url.portlet.constants.FriendlyUrlPortletKeys;

@Component(
		immediate = true,
		property = {
               "javax.portlet.name=" + FriendlyUrlPortletKeys.FRIENDLYURL,		

			 "mvc.command.name=/demo"
		},
		service = MVCRenderCommand.class
	)
public class FriendlyUrlRenderCommand implements MVCRenderCommand {
	Log log = LogFactoryUtil.getLog(FriendlyUrlRenderCommand.class);

//	@Override
//	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
//		log.info("In GetTokenMVCRenderCommand::::::::::");
//		log.info("token::::::::::" + renderRequest.getParameter("token"));
//		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		PortletURL actionUrl = PortletURLFactoryUtil.create(renderRequest, themeDisplay.getPortletDisplay().getId(),
//				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
//		actionUrl.setWindowState(LiferayWindowState.NORMAL);
////		actionUrl.setPortletMode(LiferayPortletMode.VIEW);
//		actionUrl.setParameter("javax.portlet.action", "RenderMethod");
//		actionUrl.setParameter("mvcPath", "/message.jsp");
//		renderRequest.setAttribute("resultactionURL", actionUrl.toString());
////		return "/message.jsp";
//		return "";
//	}

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        long appId = ParamUtil.getLong(renderRequest, "appId");
		return "/message.jsp";
	}
}
