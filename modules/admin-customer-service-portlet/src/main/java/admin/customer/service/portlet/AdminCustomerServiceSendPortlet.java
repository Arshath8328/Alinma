package admin.customer.service.portlet;

import com.atmc.bsl.db.domain.serviceRequest.ServiceRequest;
import com.atmc.bsl.db.service.SrvReqLocalServiceUtil;
import com.atmc.web.constants.CustomerServiceRequestListPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.owasp.encoder.Encode;

import admin.customer.service.constants.AdminCustomerServiceListPortletKeys;

@Component(	immediate = true, 
			property = { 
				"com.liferay.portlet.display-category=ATMC",
				"com.liferay.portlet.instanceable=true", 
				"com.liferay.portlet.add-default-resource=true",
				"javax.portlet.display-name=ATMC Admin Customer Service Send Portlet",
				"javax.portlet.init-param.template-path=/adminCustomerServiceList/",
				"javax.portlet.init-param.view-template=/adminCustomerServiceList/compose_message.jsp", 
				"javax.portlet.name=" + AdminCustomerServiceListPortletKeys.AdminSendPortlet,
				"javax.portlet.resource-bundle=content.Language", 
				"javax.portlet.security-role-ref=power-user,user" 
			}, 
			service = Portlet.class)
public class AdminCustomerServiceSendPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		// Auto-generated method stub
		User user = ((ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY)).getUser();
		String userRole = "";
		userRole = AdminCustomerServiceListPortlet.getUserRole(user);
		Boolean isCustomerService = userRole.equals(AdminCustomerServiceListPortletKeys.USER_ROLES.CUSTOMER_SERVICE_ROLE.getValue());
		if (!isCustomerService) {
			HttpServletResponse res = PortalUtil.getHttpServletResponse(renderResponse);
			res.sendRedirect("/group/staff/manage_customer_service");
		}

		super.doView(renderRequest, renderResponse);
	}

	public void serveResource(ResourceRequest req, ResourceResponse res) throws IOException, PortletException {
		try {
			String creator = CustomerServiceRequestListPortletKeys.USER_TYPE_ADMIN;
			Boolean emailFlag = false;
			User loggedInUser = null;
			try {
				loggedInUser = PortalUtil.getUser(req);
			} catch (PortalException e) {
				// Auto-generated catch block
				_log.error(e.getMessage(), e);
			}

			String msgCategory = req.getParameter("srvReqCatDD");
			String productID = req.getParameter("productID");
			String msgText = Encode.forHtmlContent(req.getParameter("msgTxt"));
			if (msgCategory != null && productID != null && msgText != null) {
				String msgType = null;
				if (req.getParameter("complaintTypesDD") != null && !req.getParameter("complaintTypesDD").equals("-1"))
					msgType = req.getParameter("complaintTypesDD");
				else if (req.getParameter("inquiryTypesDD") != null && !req.getParameter("inquiryTypesDD").equals("-1"))
					msgType = req.getParameter("inquiryTypesDD");
				else if (req.getParameter("suggestionTypesDD") != null && !req.getParameter("suggestionTypesDD").equals("-1"))
					msgType = req.getParameter("suggestionTypesDD");

				ServiceRequest srvRequest = new ServiceRequest();

				String iqamaId = req.getParameter("iqamaID");

				String custEmail = req.getParameter("custEmail");
				if (Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$").matcher(custEmail).find())
					srvRequest.setEmail(req.getParameter("custEmail"));
				else
					_log.error("Invalid custEmail");

				if (Pattern.compile("^[0-9]+$").matcher(req.getParameter("custMobile")).find())
					srvRequest.setMobile(req.getParameter("custMobile"));
				else
					_log.error("invalid custMobile");

				if (Pattern.compile("^[0-9]+$").matcher(iqamaId).find())
					srvRequest.setIqamaId(iqamaId);
				else
					_log.error("Invalid IqamaId");

				emailFlag = (req.getParameter("sendCopyCB") != null && req.getParameter("sendCopyCB").equals("on")) ? Boolean.TRUE : Boolean.FALSE;
				srvRequest.setEmailFlag(emailFlag);
				srvRequest.setCreatorUserId(loggedInUser.getScreenName());
				srvRequest.setCreatorUserName(req.getParameter("custName"));

				srvRequest.setSource(CustomerServiceRequestListPortletKeys.WEB_SOURCE);
				srvRequest.setRequestCategory(msgCategory);
				srvRequest.setRequestType(msgType);
				srvRequest.setProductType(productID);
				srvRequest.setRequestMessage(msgText);
				srvRequest.setRequestStatus(CustomerServiceRequestListPortletKeys.REQUEST_STATUS_NEW);
				srvRequest.setCreationDate(new Date());
				srvRequest.setAssignedTo(CustomerServiceRequestListPortletKeys.CUSTOMER_SERVICE);
				srvRequest.setCreatorUserType(creator);

				srvRequest.setIbanNumber("");

				String refNo = SrvReqLocalServiceUtil.addNewServiceRequest(srvRequest, creator);
				srvRequest.setReferenceNo(refNo);

				if (emailFlag) {
					String mailMessage = "", mailTitle = "";
					HttpServletRequest request = PortalUtil.getHttpServletRequest(req);

					if (msgCategory.equals("complaints")) {
						mailMessage = LanguageUtil.format(request, "SERVICE_REQUEST_COMPLAINT", new String[] { srvRequest.getCreatorUserName().split(" ")[0], refNo });
						mailTitle = LanguageUtil.get(request, "SERVICE_REQUEST_COMPLAINT_TITLE");
						AdminCustomerServiceListPortlet.sendSMS(request, srvRequest.getMobile(), refNo, "SERVICE_REQUEST_COMPLAINT_SMS");
					} else if (msgCategory.equals("inquiries")) {
						mailMessage = LanguageUtil.format(request, "SERVICE_REQUEST_INQUIRY", new String[] { srvRequest.getCreatorUserName().split(" ")[0], refNo });
						mailTitle = LanguageUtil.get(request, "SERVICE_REQUEST_INQUIRY_TITLE");
					} else if (msgCategory.equals("suggestions")) {
						mailMessage = LanguageUtil.format(request, "SERVICE_REQUEST_SUGGESTION", new String[] { srvRequest.getCreatorUserName().split(" ")[0], refNo });
						mailTitle = LanguageUtil.get(request, "SERVICE_REQUEST_SUGGESTION_TITLE");
					}
					AdminCustomerServiceListPortlet.sendEmail(srvRequest.getEmail(), mailMessage, mailTitle);
				}

				PrintWriter writer = res.getWriter();
				writer.print("success");
			} else {
				PrintWriter writer = res.getWriter();
				writer.print("error");
			}
		} catch (Exception ex) {
			PrintWriter writer = res.getWriter();
			writer.print("error");
		}
	}

	@Override
	protected void addSuccessMessage(ActionRequest actionRequest, ActionResponse actionResponse) {
		return;
	}

	private static final Log _log = LogFactoryUtil.getLog(AdminCustomerServiceSendPortlet.class);
}
