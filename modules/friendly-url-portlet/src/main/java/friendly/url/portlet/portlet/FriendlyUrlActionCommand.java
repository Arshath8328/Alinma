package friendly.url.portlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

import friendly.url.portlet.constants.FriendlyUrlPortletKeys;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + FriendlyUrlPortletKeys.FRIENDLYURL,
                "mvc.command.name=action"
        },
        service = MVCActionCommand.class
)

public class FriendlyUrlActionCommand extends BaseMVCActionCommand {
	Log log = LogFactoryUtil.getLog(FriendlyUrlActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		log.info("In GetTokenMVCRenderCommand::::::::::");
		log.info("token::::::::::" + actionRequest.getParameter("token"));
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL actionUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		actionUrl.setWindowState(LiferayWindowState.NORMAL);
//		actionUrl.setPortletMode(LiferayPortletMode.VIEW);
		actionUrl.setParameter("mvcRenderCommandName", "RenderMethod");
//		actionUrl.setParameter("mvcPath", "/message.jsp");
		actionRequest.setAttribute("resultactionURL", actionUrl.toString());	
//		actionResponse.setRenderParameter("mvcPath", "/message.jsp");
			
	}

}
