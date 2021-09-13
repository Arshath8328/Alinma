package customer.service.request.portlet;

import com.atmc.bsl.db.domain.serviceRequest.ServiceRequest;
import com.atmc.bsl.db.domain.serviceRequest.ServiceRequestMessage;
import com.atmc.bsl.db.service.GsonUtilsLocalServiceUtil;
import com.atmc.bsl.db.service.SrvReqLocalServiceUtil;
import com.atmc.bsl.db.service.SrvReqMsgsLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.owasp.encoder.Encode;

import customer.service.request.constants.CustomerServiceRequestListPortletKeys;

/**
 * 
 * @author AhmedAEFattah
 *
 */

@Component(
	immediate = true,
	property = { 
		"com.liferay.portlet.display-category=ATMC",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=ATMC Customer Service Requests List Portlet", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/messages_list.jsp", 
		"javax.portlet.name=" + CustomerServiceRequestListPortletKeys.CUSTOMER_SERVICE_LIST,
		"javax.portlet.resource-bundle=content.Language", 
		"javax.portlet.security-role-ref=power-user,user" 
	}, 
	service = Portlet.class
)
public class CustomerServiceRequestsListPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(CustomerServiceRequestsListPortlet.class);

	public CustomerServiceRequestsListPortlet() {
		_log.info("Customer Service Requests List Constructor");
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String myview = (renderRequest.getParameter("myview") != null) ? renderRequest.getParameter("myview") : "messages_list";
		String view = "/" + myview + ".jsp";
		try {
			if (myview.equals("messages_list")) {
				String iqamaId = PortalUtil.getUser(renderRequest).getScreenName();
				List<ServiceRequest> msgList = SrvReqLocalServiceUtil.getServiceRequestsListbyUserID(iqamaId);
				renderRequest.setAttribute("msgsList", msgList);
			} else if (myview.equals("message_details")) {
				_log.error("Viewiing Message Details");
			}
			PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
			dispatcher.forward(renderRequest, renderResponse);
			super.doView(renderRequest, renderResponse);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}

	public void messageDetails(ActionRequest req, ActionResponse res) {
		String msgDetails = req.getParameter("msgDetails");
		ServiceRequest message = (ServiceRequest) GsonUtilsLocalServiceUtil.fromGson(msgDetails, ServiceRequest.class);
		req.setAttribute("reqMessage", message);
		List<ServiceRequestMessage> msgList = SrvReqMsgsLocalServiceUtil.getServiceRequestMessageListbyRefNo(message.getReferenceNo());
		req.setAttribute("messagesList", msgList);
	}

	@Override
	protected void addSuccessMessage(ActionRequest actionRequest, ActionResponse actionResponse) {
		return;
	}

	public void replyMessageAction(ActionRequest req, ActionResponse res) {
		_log.error("in the action compose msg");
		String msgText = req.getParameter("replyTxt") != null ? req.getParameter("replyTxt") : "";
		msgText = Encode.forHtmlContent(msgText);
		String refNo = req.getParameter("refNo") != null ? req.getParameter("refNo") : "";

		User loggedInUser = null;
		try {
			loggedInUser = PortalUtil.getUser(req);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

		ServiceRequestMessage msg = new ServiceRequestMessage();

		msg.setMessageTxt(msgText);
		msg.setRefNo(refNo);
		msg.setTimeStamp(new Date());
		msg.setUserId(loggedInUser.getScreenName());
		msg.setUserName(loggedInUser.getFirstName() + " " + loggedInUser.getLastName());

		msg.setUserType(CustomerServiceRequestListPortletKeys.USER_TYPE_CUSTOMER);

		int result = SrvReqMsgsLocalServiceUtil.addReplyMessage(msg);

		req.setAttribute("result", result == 1);

		String view = "/message_details.jsp";
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
		try {
			dispatcher.forward(req, res);
		} catch (PortletException | IOException e) {
			_log.error(e.getMessage(), e);
		}
	}

	public void serveResource(ResourceRequest req, ResourceResponse res) throws IOException, PortletException {
		_log.error("in the action compose msg");
		String msgText = req.getParameter("replyTxt") != null ? req.getParameter("replyTxt") : "";
		String refNo = req.getParameter("refNo") != null ? req.getParameter("refNo") : "";

		User loggedInUser = null;
		try {
			loggedInUser = PortalUtil.getUser(req);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

		ServiceRequestMessage msg = new ServiceRequestMessage();

		msg.setMessageTxt(msgText);
		msg.setRefNo(refNo);
		msg.setTimeStamp(new Date());
		msg.setUserId(loggedInUser.getScreenName());
		msg.setUserName(loggedInUser.getFirstName() + " " + loggedInUser.getLastName());

		msg.setUserType(CustomerServiceRequestListPortletKeys.USER_TYPE_CUSTOMER);

		int result = SrvReqMsgsLocalServiceUtil.addReplyMessage(msg);

		PrintWriter writer = res.getWriter();

		if (result == 1)
			writer.print("success");
		else
			writer.print("error");

	}

}
