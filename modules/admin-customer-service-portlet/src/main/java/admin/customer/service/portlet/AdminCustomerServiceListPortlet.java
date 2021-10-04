package admin.customer.service.portlet;

import com.atmc.bsl.db.domain.serviceRequest.ServiceRequest;
import com.atmc.bsl.db.domain.serviceRequest.ServiceRequestAction;
import com.atmc.bsl.db.domain.serviceRequest.ServiceRequestAttachment;
import com.atmc.bsl.db.domain.serviceRequest.ServiceRequestMessage;
import com.atmc.bsl.db.service.GsonUtilsLocalServiceUtil;
import com.atmc.bsl.db.service.SrvReqActionLocalServiceUtil;
import com.atmc.bsl.db.service.SrvReqAttachmentLocalServiceUtil;
import com.atmc.bsl.db.service.SrvReqLocalServiceUtil;
import com.atmc.bsl.db.service.SrvReqMsgsLocalServiceUtil;
import com.atmc.web.constants.CustomerServiceRequestListPortletKeys;
import com.atmc.web.util.FileUtil;
import com.ejada.atmc.acl.db.model.ServiceRequestAttachments;
import com.ejada.atmc.acl.db.service.SMSLocalServiceUtil;
import com.ejada.atmc.acl.db.service.SendEmailServiceUtil;
import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.petra.io.StreamUtil;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.io.ByteArrayFileInputStream;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspFactory;

import org.osgi.service.component.annotations.Component;
import org.owasp.encoder.Encode;

import admin.customer.service.constants.AdminCustomerServiceListPortletKeys;

@Component(	
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=ATMC",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.add-default-resource=true",
		"javax.portlet.display-name=ATMC Admin Customer Service List Portlet",
		"javax.portlet.init-param.template-path=/adminCustomerServiceList/",
		"javax.portlet.init-param.view-template=/adminCustomerServiceList/view.jsp", 
		"javax.portlet.name=" + AdminCustomerServiceListPortletKeys.AdminListPortlet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
	},
	service = Portlet.class
)
public class AdminCustomerServiceListPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(AdminCustomerServiceListPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		// Auto-generated method stub
		String myview = (renderRequest.getParameter("myview") != null) ? renderRequest.getParameter("myview") : "view2";
		try {
			User user = ((ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY)).getUser();
			String userRole = getUserRole(user);
			Boolean isCustomerService = userRole.equals(AdminCustomerServiceListPortletKeys.USER_ROLES.CUSTOMER_SERVICE_ROLE.getValue());

			if (!isCustomerService && myview.equals("compose_message"))
				myview = "view";
			renderRequest.setAttribute("userRole", userRole);
			renderRequest.setAttribute("isCustomerService", isCustomerService);
			renderRequest.setAttribute("iqamaId", user.getScreenName());
			if (myview.equals("view")) {
//				List<ServiceRequest> result = SrvReqLocalServiceUtil.getServiceRequestsListByStatus(
//						new String[]{CustomerServiceRequestListPortletKeys.REQUEST_STATUS_NEW, CustomerServiceRequestListPortletKeys.REQUEST_STATUS_OPEN},userRole);
//				renderRequest.setAttribute("msgsList", result);
//				_log.error("Returned Messages  : " +  result.size());
			} else if (myview.equals("closed_requests")) {
//				List<ServiceRequest> result = SrvReqLocalServiceUtil.getServiceRequestsListByStatus(
//						new String[]{CustomerServiceRequestListPortletKeys.REQUEST_STATUS_CLOSED}, userRole);
//				renderRequest.setAttribute("msgsList", result);
			} else if (myview.equals("escalated_requests")) {
//				List<ServiceRequest> result = SrvReqLocalServiceUtil.getServiceRequestsListByEscalationFlag(userRole, CustomerServiceRequestListPortletKeys.REQUEST_STATUS_CLOSED
//						, userRole.equals(AdminCustomerServiceListPortletKeys.USER_ROLES.CUSTOMER_SERVICE_ROLE.getValue()));
//				renderRequest.setAttribute("msgsList", result);
			} else if (myview.equals("internal_messages")) {
				List<ServiceRequestAction> result = SrvReqActionLocalServiceUtil.getServiceRequestActionListbyRefNo(renderRequest.getParameter("refNo"));
				renderRequest.setAttribute("actionList", result);
			}

			if (renderRequest.getParameter("result") != null && Boolean.valueOf(renderRequest.getParameter("result")) == true) {
				SessionMessages.add(renderRequest, "close_success");
			} else if (renderRequest.getParameter("result") != null && Boolean.valueOf(renderRequest.getParameter("result")) == false) {
				SessionMessages.add(renderRequest, "close_error");
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/adminCustomerServiceList/" + myview + ".jsp");
		dispatcher.forward(renderRequest, renderResponse);
	}

//	public void srvReqDetails(ActionRequest req, ActionResponse res)
//	{
//		String refNo = req.getParameter("refNo");
//		_log.error("Admin Request Details Action, RefNo : " + refNo);
//		
//		/** Get Message Details **/
//		ServiceRequest message = SrvReqLocalServiceUtil.getServiceRequestbyRefNo(refNo);
//		req.setAttribute("reqMessage", message);
//
//		/** Get List of Message Replies */
//		List<ServiceRequestMessage> msgList = SrvReqMsgsLocalServiceUtil.getServiceRequestMessageListbyRefNo(message.getReferenceNo());
//		req.setAttribute("messagesList", msgList);
//		
//		/** Get All Attachments **/
//		List<ServiceRequestAttachment> attachList = SrvReqAttachmentLocalServiceUtil.getServiceRequestAttachmentListbyRefNo(refNo);
//		req.setAttribute("attachList", attachList);
//		
//	}

	public void srvReqClose(ActionRequest req, ActionResponse res) {
		try {
			String refNo = req.getParameter("refNo");
			_log.info("Admin Request Close Action, RefNo : " + refNo);
			ServiceRequest srvRequest = SrvReqLocalServiceUtil.getServiceRequestbyRefNo(refNo);
			srvRequest.setRequestStatus(CustomerServiceRequestListPortletKeys.REQUEST_STATUS_CLOSED);
			int result = SrvReqLocalServiceUtil.updateServiceRequest(srvRequest);
			if (result == 0) {
				SessionMessages.add(req, "close_success");
				HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
				if (srvRequest.getRequestCategory().equals("complaints")) {
					sendSMS(request, srvRequest.getMobile(), srvRequest.getReferenceNo(), "CLOSURE_SERVICE_REQUEST_COMPLAINT_SMS");
				} else if (srvRequest.getRequestCategory().equals("inquiries")) {
					String mailMessage = LanguageUtil.format(request, "CLOSURE_SERVICE_REQUEST_INQUIRY", new String[] { srvRequest.getCreatorUserName().split(" ")[0], refNo });
					String mailTitle = LanguageUtil.get(request, "CLOSURE_SERVICE_REQUEST_INQUIRY_TITLE");
					sendEmail(srvRequest.getEmail(), mailMessage, mailTitle);
				}
			} else {
				SessionErrors.add(req, "close_error");
			}
		} catch (Exception ex) {
			SessionErrors.add(req, "close_error");

		}
	}
	
	public static void sendEmail(String mailTo, String emailMsg, String msgTitle) {
		List<File> files = new ArrayList<>();
		List<String> filesName = new ArrayList<>();
		_log.info("Customer Service - Sending Mail To : " + mailTo);
		_log.info("Customer Service - Mail  Msg : " + emailMsg);
		boolean mailflag = SendEmailServiceUtil.sendEmail(mailTo, msgTitle, emailMsg, filesName, files);
		if (mailflag) {
			_log.info("Email sent Successfully");
		} else {
			_log.error("Failed to send Email");
		}
	}

	public static void sendSMS(HttpServletRequest request, String mobileNumber, String refNo, String msgKey) {
		try {
			_log.info("Customer Service - Sending SMS To : " + mobileNumber);
			_log.info("Customer Service - SMS RefNo : " + refNo);
			String smsMsg = "";
			smsMsg = LanguageUtil.format(request, msgKey, refNo);
			SMSLocalServiceUtil.sendSms(smsMsg, mobileNumber);
			_log.info("Sent SMS Message : " + smsMsg);
			_log.info("SMS sent Successfully");
			// SessionMessages.add(request, "sms_success");
		} catch (PortalException | SQLException ex) {
			_log.error("Failed to send SMS");
			// SessionErrors.add(request,"sms_failed");
		}
	}

	public void srvReqEscalate(ActionRequest req, ActionResponse res) {
		try {
			String refNo = req.getParameter("refNo");
			_log.error("Admin Request Ecalate Action, RefNo : " + refNo);
			ServiceRequest srvRequest = SrvReqLocalServiceUtil.getServiceRequestbyRefNo(refNo);
			srvRequest.setRequestStatus(CustomerServiceRequestListPortletKeys.REQUEST_STATUS_PENDING);
			srvRequest.setEscalatedFlag(Boolean.TRUE);
			int result = SrvReqLocalServiceUtil.updateServiceRequest(srvRequest);
			if (result == 0) {
				SessionMessages.add(req, "escalate_success");
			} else {
				SessionErrors.add(req, "escalate_error");
			}
		} catch (Exception ex) {
			SessionErrors.add(req, "escalate_error");

		}
	}

	public void assignRequestToRole(ActionRequest request, ActionResponse response) {

		String refNo = request.getParameter("refNo");

		try {
			CaptchaUtil.check(request);
			_log.info("CAPTCHA validated successfully");
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			SessionErrors.add(request, "successMessage");
		} catch (CaptchaException e) {
			// Auto-generated catch block
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			SessionErrors.add(request, "errorMessage");
			_log.info("CAPTCHA not validated");
			request.setAttribute("errorCaptcha", true);
			_log.error(e.getMessage(), e);
			return;
		}

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
		ByteArrayFileInputStream inputStream = null;
		try {
			_log.error(refNo);

			/*************************
			 * Add new Action record in Service Request History
			 ****************************/
			ServiceRequestAction action = new ServiceRequestAction();
			action.setActionDate(new Date());

			String details = AdminCustomerServiceListPortletKeys.USER_ROLES.CUSTOMER_SERVICE_ROLE.getValue() + " " + LanguageUtil.get(uploadPortletRequest, "assigned") + " " + refNo + " "
					+ LanguageUtil.get(uploadPortletRequest, "to") + " " + request.getParameter("roleDD");
			action.setActionDetails(details);
			action.setActionRemarks(Encode.forHtmlContent(request.getParameter("addNote")));
			action.setActionType(String.valueOf(AdminCustomerServiceListPortletKeys.ACTION_TYPES.ASSIGNED_TO.getValue()));
			action.setReferenceNo(refNo);
			String actionID = SrvReqActionLocalServiceUtil.addNewServiceRequestAction(action);

			/**********************
			 * Save Uploaded Attachments in Service Request Attachments
			 ************************/
			File[] uploadedFiles = uploadPortletRequest.getFiles("uploadFile");

			if (uploadedFiles != null && uploadedFiles.length > 0) {
				for (File file : uploadedFiles) {
					if (file != null)
						if (FileUtil.validateFile(file, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE))
							SrvReqAttachmentLocalServiceUtil.saveServiceRequestFiles(refNo, file, file.getName(), actionID);
						else
							SessionErrors.add(request, "file.failed");
				}
			}
			SrvReqLocalServiceUtil.updateServiceRequestAssignedRole(refNo, request.getParameter("roleDD"), CustomerServiceRequestListPortletKeys.REQUEST_STATUS_ASSIGNED);

			request.setAttribute("result", true);

		} catch (Exception e) {
			// : handle exception
			_log.error(e.getMessage(), e);
			request.setAttribute("result", false);
		} finally {
			try {
				StreamUtil.cleanUp(inputStream);
			} catch (IOException e) {
				_log.error(e.getMessage(), e);
			}
		}

	}

	public void serveResource(ResourceRequest req, ResourceResponse res) throws IOException, PortletException {
		_log.info("in the action compose msg");
		String replyTxt = ParamUtil.getString(req, "replyTxt");
		String msgText = Encode.forHtmlContent(replyTxt);
//		String msgText = req.getParameter("replyTxt");
		String refNo = req.getParameter("refNo");
		String fileID = req.getParameter("fileID");
		String actionName = req.getParameter("actionName");

		if (msgText != null && refNo != null && actionName != null && actionName.equals("reply")) {
			User loggedInUser = null;
			try {
				loggedInUser = PortalUtil.getUser(req);
			} catch (PortalException e) {
				// Auto-generated catch block
				_log.error(e.getMessage(), e);
			}

			ServiceRequestMessage msg = new ServiceRequestMessage();

			msg.setMessageTxt(msgText);
			msg.setRefNo(refNo);
			msg.setTimeStamp(new Date());
			msg.setUserId(loggedInUser.getScreenName());
			msg.setUserName(loggedInUser.getFirstName() + " " + loggedInUser.getLastName());

			msg.setUserType(CustomerServiceRequestListPortletKeys.USER_TYPE_ADMIN);

			int result = SrvReqMsgsLocalServiceUtil.addReplyMessage(msg);

			PrintWriter writer = res.getWriter();

			if (result == 1)
				writer.print("success");
			else
				writer.print("error");
		} else if (msgText != null && refNo != null && actionName != null && actionName.equals("comment")) {
			User loggedInUser = null;
			String userRole = "";
			try {
				loggedInUser = PortalUtil.getUser(req);
				userRole = getUserRole(loggedInUser);
			} catch (PortalException e) {
				// Auto-generated catch block
				_log.error(e.getMessage(), e);
			}

			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(req);
			ServiceRequestAction action = new ServiceRequestAction();

			String details = userRole + " " + LanguageUtil.get(uploadPortletRequest, "replied") + " " + LanguageUtil.get(uploadPortletRequest, "on") + " " + refNo;
			action.setActionDetails(details);

			action.setActionRemarks(msgText);
			action.setActionDate(new Date());
			action.setActionType(AdminCustomerServiceListPortletKeys.ACTION_TYPES.REPLIED.getValue());
			action.setReferenceNo(refNo);
			String actionID = SrvReqActionLocalServiceUtil.addNewServiceRequestAction(action);

			if (!userRole.equals(AdminCustomerServiceListPortletKeys.USER_ROLES.CUSTOMER_SERVICE_ROLE.getValue())) {
				SrvReqLocalServiceUtil.updateServiceRequestAssignedRole(refNo, AdminCustomerServiceListPortletKeys.USER_ROLES.CUSTOMER_SERVICE_ROLE.getValue(),
						CustomerServiceRequestListPortletKeys.REQUEST_STATUS_ASSIGNED);
			}

			PrintWriter writer = res.getWriter();
			if (actionID.equals("0.0L"))
				writer.print("success");
			else
				writer.print("error");
		} else if (fileID != null && actionName != null && actionName.equals("download")) {
			String fileType = "";
			byte[] pdf = null;
			try {
				String fileId = req.getParameter("fileID");
				ServiceRequestAttachments file = SrvReqAttachmentLocalServiceUtil.downloadAttachmentFile(fileID);
				fileType = file.getFILE_NAME().substring(file.getFILE_NAME().indexOf(".") + 1, file.getFILE_NAME().length());
				pdf = file.getFILE_CONTENT().getBytes(1, (int) file.getFILE_CONTENT().length());
				res.setProperty("Content-Disposition", "attachment; filename=\"" + file.getFILE_NAME() + "\"");
				res.setContentLength(pdf.length);
				addContentType(res, fileType);
				OutputStream out = res.getPortletOutputStream();
				out.write(pdf);
				out.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	private void addContentType(ResourceResponse res, String fileType) {
		if (fileType.trim().equalsIgnoreCase("txt")) {
			res.setContentType("text/plain");
		} else if (fileType.trim().equalsIgnoreCase("doc")) {
			res.setContentType("application/msword");
		} else if (fileType.trim().equalsIgnoreCase("xls")) {
			res.setContentType("application/vnd.ms-excel");
		} else if (fileType.trim().equalsIgnoreCase("pdf")) {
			res.setContentType("application/pdf");
		} else if (fileType.trim().equalsIgnoreCase("ppt")) {
			res.setContentType("application/ppt");
		} else {
			res.setContentType("application/octet-stream");
		}
	}

	public void deleteFile(ActionRequest request, ActionResponse response) {
		String fileID = request.getParameter("fileID");
		int result = SrvReqAttachmentLocalServiceUtil.deleteAttachmentFile(fileID);

		if (result == 1)
			SessionMessages.add(request, "file_delete_success");
		else if (result == -1)
			SessionErrors.add(request, "file_delete_error");

		String refNo = request.getParameter("refNo");
		_log.error("Admin Request Details Action, RefNo : " + refNo);

		/** Get Message Details JSON and unmarshal it **/
		String msgDetails = (String) request.getParameter("msgDetails");
		ServiceRequest message = (ServiceRequest) GsonUtilsLocalServiceUtil.fromGson(msgDetails, ServiceRequest.class);
		request.setAttribute("reqMessage", message);

		/** Get List of Message Replies */
		List<ServiceRequestMessage> msgList = SrvReqMsgsLocalServiceUtil.getServiceRequestMessageListbyRefNo(message.getReferenceNo());
		request.setAttribute("messagesList", msgList);

		/** Get All Attachments **/
		List<ServiceRequestAttachment> attachList = SrvReqAttachmentLocalServiceUtil.getServiceRequestAttachmentListbyRefNo(refNo);
		request.setAttribute("attachList", attachList);
	}

	@Override
	protected void addSuccessMessage(ActionRequest actionRequest, ActionResponse actionResponse) {
		return;
	}

	public static String getUserRole(User user) {
		List<Role> roles = (List<Role>) RoleLocalServiceUtil.getUserRoles(user.getUserId());
		String userRole = "";
		for (Role role : roles) {
			// _log.error("\n" + (role.getName() +"###"+ role.getRoleId() + " >>>>
			// exists : " +
			// AdminCustomerServiceListPortletKeys.USER_ROLES.isRoleExist(role.getName()) )
			// );
			if (AdminCustomerServiceListPortletKeys.USER_ROLES.isRoleExist(role.getName())) {
				userRole = role.getName();
				break;
			}
		}
		return userRole;
	}
}
