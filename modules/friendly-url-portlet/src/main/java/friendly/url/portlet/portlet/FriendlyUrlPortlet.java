package friendly.url.portlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import friendly.url.portlet.constants.FriendlyUrlPortletKeys;

/**
 * @author bhavik
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=FriendlyUrl",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FriendlyUrlPortletKeys.FRIENDLYURL,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FriendlyUrlPortlet extends MVCPortlet {
	Log log = LogFactoryUtil.getLog(FriendlyUrlPortlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		super.render(renderRequest, renderResponse);
	}
//	@ProcessAction(name = "processThis")
//	public void action(ActionRequest actionRequest, ActionResponse actionResponse)
//			throws IOException, PortletException {
//		log.info("In GetTokenMVCRenderCommand::::::::::");
//		log.info("token::::::::::" + actionRequest.getParameter("token"));
//		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		PortletURL actionUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
//				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
//		actionUrl.setWindowState(LiferayWindowState.NORMAL);
////		actionUrl.setPortletMode(LiferayPortletMode.VIEW);
//		actionUrl.setParameter("javax.portlet.action", "RenderMethod");
//		actionUrl.setParameter("mvcPath", "/message.jsp");
//		actionRequest.setAttribute("resultactionURL", actionUrl.toString());	
//		actionResponse.setRenderParameter("mvcPath", "/message.jsp");
//		super.processAction(actionRequest, actionResponse);
//	}
}