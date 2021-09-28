package service.requests.widget.portlet.portlet;

import com.atmc.bsl.db.domain.serviceRequest.ServiceRequest;
import com.atmc.bsl.db.service.SrvReqLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import service.requests.widget.portlet.constants.ServiceRequestsWidgetPortletKeys;

/**
 * @author vidit
 */
@Component(
	immediate = true, 
	property = { 
		"com.liferay.portlet.display-category=ATMC", 
		"com.liferay.portlet.instanceable=true", 
		"javax.portlet.display-name=ServiceRequestsWidget Portlet",
		"javax.portlet.init-param.template-path=/", 
		"javax.portlet.init-param.view-template=/dashboard/service_requests_widget.jsp",
		"javax.portlet.name=" + ServiceRequestsWidgetPortletKeys.SERVICEREQUESTSWIDGET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
	},
	service = Portlet.class
)
public class ServiceRequestsWidgetPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(ServiceRequestsWidgetPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		String iqamaId = "";
		try {
			iqamaId = PortalUtil.getUser(renderRequest).getScreenName().toString();
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}
		List<ServiceRequest> msgList = SrvReqLocalServiceUtil.getServiceRequestsListbyUserID(iqamaId);
		renderRequest.setAttribute("msgsList", msgList);

		super.doView(renderRequest, renderResponse);
	}
}