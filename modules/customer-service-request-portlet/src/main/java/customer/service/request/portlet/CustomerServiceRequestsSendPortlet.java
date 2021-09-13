package customer.service.request.portlet;

import com.atmc.bsl.db.domain.serviceRequest.ServiceRequest;
import com.atmc.bsl.db.service.SrvReqLocalServiceUtil;
import com.atmc.web.constants.CustomerServiceRequestListPortletKeys;
import com.ejada.atmc.acl.db.service.SMSLocalServiceUtil;
import com.ejada.atmc.acl.db.service.SendEmailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
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

import org.osgi.service.component.annotations.Component;
import org.owasp.encoder.Encode;

import customer.service.request.constants.CustomerServiceRequestSendPortletKeys;

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
		"javax.portlet.display-name=ATMC Customer Service Request Send Portlet", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/compose_message.jsp", 
		"javax.portlet.name=" + CustomerServiceRequestSendPortletKeys.CUSTOMER_SERVICE_SEND,
		"javax.portlet.resource-bundle=content.Language", 
		"javax.portlet.security-role-ref=guest,power-user,user" 
	},
	service = Portlet.class
)
public class CustomerServiceRequestsSendPortlet extends MVCPortlet {

	public CustomerServiceRequestsSendPortlet() {
		_log.info("Customer Service Send Constructor");
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String myview = (renderRequest.getParameter("myview") != null) ? renderRequest.getParameter("myview") : "compose_message";
		String view = "/" + myview + ".jsp";
		_log.info("*********************************************************************************************");
		_log.info("Customer Service Request Send Portlet");
		_log.info(myview);
		_log.info(view);
		_log.info("*********************************************************************************************");
		super.doView(renderRequest, renderResponse);
	}

	public void serveResource(ResourceRequest req, ResourceResponse res) throws IOException, PortletException {
		try {
			Pattern pattern;
			Matcher matcher;

			String creator = CustomerServiceRequestListPortletKeys.USER_TYPE_CUSTOMER;
			ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
			boolean isUserSignedIn = themeDisplay.isSignedIn();
			Boolean emailFlag = false;
			User loggedInUser = null;
			try {
				loggedInUser = PortalUtil.getUser(req);
			} catch (PortalException e) {
				_log.error(e.getMessage(), e);
			}

			/*
			 * HttpServletRequest reqcaptcha = PortalUtil.getHttpServletRequest(req); try {
			 * CaptchaUtil.check(req); _log.info("CAPTCHA validated successfully");
			 * SessionMessages.add(req, PortalUtil.getPortletId(reqcaptcha) +
			 * SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			 * //SessionErrors.add(request, "successMessage"); } catch (CaptchaException e)
			 * { // Auto-generated catch block SessionMessages.add(req,
			 * PortalUtil.getPortletId(reqcaptcha) +
			 * SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			 * SessionErrors.add(reqcaptcha, "errorMessage");
			 * _log.info("CAPTCHA not validated successfully"); _log.error(e.getMessage(), e); return;
			 * }
			 */
			pattern = Pattern.compile("^['a-zA-Z_\\u0600-\\u06FF\\s]+$");
			String msgCategory = ParamUtil.getString(req, "srvReqCatDD", null);
			if (!pattern.matcher(msgCategory).find()) {
				_log.error("invalid msgCategory");
				msgCategory = null;
			}

			String productID = req.getParameter("productID");

			String msgTxtJsp = ParamUtil.getString(req, "msgTxt");

			String msgText = Encode.forHtmlContent(msgTxtJsp);

			// String msgText = req.getParameter("msgTxt");

			_log.info("*********************************************************************************************");
			_log.info("Create New Service Request");
			_log.info("msg Category : " + msgCategory);
			_log.info("Product ID : " + productID);
			_log.info("Msg Text : " + msgText);
			if (msgCategory != null && productID != null && msgText != null) {
				String msgType = null;
				if (req.getParameter("complaintTypesDD") != null && !req.getParameter("complaintTypesDD").equals("-1"))
					msgType = req.getParameter("complaintTypesDD");
				else if (req.getParameter("inquiryTypesDD") != null && !req.getParameter("inquiryTypesDD").equals("-1"))
					msgType = req.getParameter("inquiryTypesDD");
				else if (req.getParameter("suggestionTypesDD") != null && !req.getParameter("suggestionTypesDD").equals("-1"))
					msgType = req.getParameter("suggestionTypesDD");

				_log.info("Msg Type : " + msgType);

				ServiceRequest srvRequest = new ServiceRequest();

				if (isUserSignedIn) {
					srvRequest.setEmail(loggedInUser.getEmailAddress());
					srvRequest.setMobile(loggedInUser.getPhones().get(0).getNumber());
					srvRequest.setIqamaId(loggedInUser.getScreenName());
					srvRequest.setEmailFlag(Boolean.TRUE);
					srvRequest.setCreatorUserId(loggedInUser.getScreenName());
					srvRequest.setCreatorUserName(loggedInUser.getFirstName() + " " + loggedInUser.getLastName());
				} else {
					String custEmail = req.getParameter("custEmail");
					if (Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$").matcher(custEmail).find())
						srvRequest.setEmail(custEmail);
					else
						_log.error("Invalid custEmail");
					pattern = Pattern.compile("(^05)([0-9]{8})");
					matcher = pattern.matcher(req.getParameter("custMobile"));
					boolean matchFound = matcher.find();
					if (matchFound) {
						srvRequest.setMobile(req.getParameter("custMobile"));
					} else {
						_log.error("Invalid Mobile Number");
					}

//					srvRequest.setMobile(req.getParameter("custMobile"));
//					srvRequest.setIqamaId(req.getParameter("iqamaID"));
					pattern = Pattern.compile("^[0-9]+$");
					if (pattern.matcher(req.getParameter("iqamaID")).find() && req.getParameter("iqamaID").length() == 10) {
						srvRequest.setIqamaId(req.getParameter("iqamaID"));
					} else {
						_log.error("invalid iqamaID");
					}

					emailFlag = (req.getParameter("sendCopyCB") != null && req.getParameter("sendCopyCB").equals("on")) ? Boolean.TRUE : Boolean.FALSE;
					srvRequest.setEmailFlag(emailFlag);
					srvRequest.setCreatorUserId("Guest");
					creator = CustomerServiceRequestListPortletKeys.USER_TYPE_GUEST;
					srvRequest.setCreatorUserName(req.getParameter("custName"));
				}
				srvRequest.setSource(CustomerServiceRequestListPortletKeys.WEB_SOURCE);
				srvRequest.setRequestCategory(msgCategory);
				srvRequest.setRequestType(msgType);
				srvRequest.setProductType(productID);
				srvRequest.setRequestMessage(msgText);
				srvRequest.setRequestStatus(CustomerServiceRequestListPortletKeys.REQUEST_STATUS_NEW);
				srvRequest.setCreationDate(new Date());
				java.text.SimpleDateFormat simpleDateFormat1 = new java.text.SimpleDateFormat("yyyyMMdd");
				srvRequest.setCreationDateString(simpleDateFormat1.format(srvRequest.getCreationDate()));
				srvRequest.setAssignedTo(CustomerServiceRequestListPortletKeys.CUSTOMER_SERVICE);
				srvRequest.setCreatorUserType(creator);
				srvRequest.setIbanNumber("");
				_log.info(srvRequest.toString());
				List<ServiceRequest> msgList = SrvReqLocalServiceUtil.getServiceRequestsListbyUserID(srvRequest.getIqamaId());
				for (ServiceRequest serviceRequest : msgList) {
					serviceRequest.setCreationDateString(simpleDateFormat1.format(serviceRequest.getCreationDate()));
					if (serviceRequest.toString().equals(srvRequest.toString())) {
						PrintWriter writer = res.getWriter();
						writer.print("success");
						return;
					}
				}
				String refNo = SrvReqLocalServiceUtil.addNewServiceRequest(srvRequest, creator);
				_log.info("Customer Service New Request refNo : " + refNo);
				srvRequest.setReferenceNo(refNo);
				_log.error("isUserSignedIn >>> " + isUserSignedIn);
				_log.error("emailFlag >>> " + emailFlag);
				if (isUserSignedIn || emailFlag) {
					String mailMessage = "", mailTitle = "";
					HttpServletRequest request = PortalUtil.getHttpServletRequest(req);

					if (msgCategory.equals("complaints")) {
						mailMessage = LanguageUtil.format(request, "SERVICE_REQUEST_COMPLAINT", new String[] { srvRequest.getCreatorUserName().split(" ")[0], refNo });
						mailTitle = LanguageUtil.get(request, "SERVICE_REQUEST_COMPLAINT_TITLE");
						sendSMS(request, srvRequest.getMobile(), refNo, "SERVICE_REQUEST_COMPLAINT_SMS");
					} else if (msgCategory.equals("inquiries")) {
						mailMessage = LanguageUtil.format(request, "SERVICE_REQUEST_INQUIRY", new String[] { srvRequest.getCreatorUserName().split(" ")[0], refNo });
						mailTitle = LanguageUtil.get(request, "SERVICE_REQUEST_INQUIRY_TITLE");
					} else if (msgCategory.equals("suggestions")) {
						mailMessage = LanguageUtil.format(request, "SERVICE_REQUEST_SUGGESTION", new String[] { srvRequest.getCreatorUserName().split(" ")[0], refNo });
						mailTitle = LanguageUtil.get(request, "SERVICE_REQUEST_SUGGESTION_TITLE");
					}
					sendEmail(request, srvRequest.getEmail(), mailMessage, mailTitle);
				}

				PrintWriter writer = res.getWriter();
				writer.print("success");
			} else {
				PrintWriter writer = res.getWriter();
				writer.print("error");
			}
			_log.info("*********************************************************************************************");

		} catch (Exception ex) {
			PrintWriter writer = res.getWriter();
			writer.print("error");
			ex.printStackTrace();
		}
	}

	public static void sendEmail(HttpServletRequest req, String mailTo, String emailMsg, String msgTitle) {
		List<File> files = new ArrayList<>();
		List<String> filesName = new ArrayList<>();
		_log.info("Customer Service - Sending Mail To : " + mailTo);
		_log.info("Customer Service - Mail  Msg : " + emailMsg);
		boolean mailflag = SendEmailServiceUtil.sendEmail(mailTo, msgTitle, emailMsg, filesName, files);
		if (mailflag) {
			_log.info("Email sent Successfully");
			// SessionMessages.add(req, "email_success");
		} else {
			_log.error("Failed to send Email");
			// SessionErrors.add(req,"email_failed");
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

	@Override
	protected void addSuccessMessage(ActionRequest actionRequest, ActionResponse actionResponse) {
	}

	private static final Log _log = LogFactoryUtil.getLog(CustomerServiceRequestsSendPortlet.class);
}
