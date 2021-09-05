package admin.customer.service.actions;

import com.atmc.web.constants.AdminCustomerServiceListPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property =
		{ "javax.portlet.name=" + AdminCustomerServiceListPortletKeys.ASSIGN,
				"mvc.command.name=/adminCustomerServiceList/assign_to" },
		service = MVCRenderCommand.class
)
public class AdminAssignRequestRenderCmd implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		if (renderRequest.getAttribute("result") != null && (Boolean) renderRequest.getAttribute("result") == false) {
			SessionErrors.add(PortalUtil.getLiferayPortletRequest(renderRequest), "close_error");
		}
		return "/adminCustomerServiceList/assign_to.jsp";
	}

}
