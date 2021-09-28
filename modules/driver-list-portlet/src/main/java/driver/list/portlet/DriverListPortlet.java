package driver.list.portlet;

import com.atmc.bsl.db.service.NotificationsLocalServiceUtil;
import com.atmc.web.util.FileUtil;
import com.ejada.atmc.acl.db.exception.NoSuchQuotationDriverseEndorsException;
import com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException;
import com.ejada.atmc.acl.db.model.QuotationDriverseEndors;
import com.ejada.atmc.acl.db.model.PolicyHDR;
import com.ejada.atmc.acl.db.service.PolicyHDRLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationDriverseEndorsLocalServiceUtil;
import com.ejada.atmc.acl.db.service.SMSLocalServiceUtil;
import com.atmc.web.common.NotificationTypes.Type;
import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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

/**
 * @author vidit
 */
@Component(
	immediate = true,
	property = { 
		"com.liferay.portlet.display-category=ATMC", 
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.display-name=DriverList Portlet" 
	}, 
	service = Portlet.class
)
public class DriverListPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(DriverListPortlet.class);

	@Override
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException {

		String myview = request.getParameter("myview");
		String view = null;
		String myParentView = request.getParameter("myParentView");
		if (myParentView != null && myview == null) {
			myview = myParentView;
		}
		if (myview == null || myview.equals("view")) {
			int quotationsCount;
			quotationsCount = QuotationDriverseEndorsLocalServiceUtil.getQuotationDriverseEndorsesCount();
			List<QuotationDriverseEndors> policyCanc = QuotationDriverseEndorsLocalServiceUtil.getQuotationDriverseEndorses(-1, -1);
			request.setAttribute("canclePolicyTotalCount", quotationsCount);
			request.setAttribute("policyCanc", policyCanc);
		}
		if (myview != null && myview.equals("details")) {
			String driverId = request.getParameter("driverId");
			_log.info("driverId >>>>>>>>>>" + driverId);
			try {
				QuotationDriverseEndors driverDetails = QuotationDriverseEndorsLocalServiceUtil.driverId(driverId);
				request.setAttribute("driverDetails", driverDetails);
				PolicyHDR policyHdr = PolicyHDRLocalServiceUtil.findByPolicyNo(driverDetails.getPolicyNumber());
				request.setAttribute("mobileNumber", policyHdr.getInsuredMobile());
				request.setAttribute("insuredEmail", policyHdr.getInsuredEmail());

			} catch (NoSuchQuotationDriverseEndorsException | NoSuchPolicyHDRException e) {
				_log.error(e.getMessage(), e);
			}
		}
		view = "/" + (myview == null ? "view" : myview) + ".jsp";
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		PrintWriter writer = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		_log.info("inside serve resource ");
		String name = resourceRequest.getParameter("type");
		if (name.equals("workinProgress")) {
			String mobileNumber = resourceRequest.getParameter("mobile");
			if (!Pattern.compile("(^05)([0-9]{8})").matcher(mobileNumber).find())
				mobileNumber = "";
			String policyNumber = resourceRequest.getParameter("policyNumber");
			String insuredEmail = resourceRequest.getParameter("insuredEmail");
			if (!Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$").matcher(insuredEmail).find())
				insuredEmail = "";
			try {
				QuotationDriverseEndors quotationDriverseEndors = QuotationDriverseEndorsLocalServiceUtil.findByPolicyNumber(policyNumber);
				quotationDriverseEndors.setStatus("WP");
				QuotationDriverseEndorsLocalServiceUtil.updateQuotationDriverseEndors(quotationDriverseEndors);
				_log.info("lang key " + LanguageUtil.get(resourceRequest.getLocale(), "WORK_IN_PROGESS_MESSAGE"));
				SMSLocalServiceUtil.sendSms(LanguageUtil.get(resourceRequest.getLocale(), "WORK_IN_PROGESS_MESSAGE"), mobileNumber);
				String[] mailParams = { quotationDriverseEndors.getDriverName(), quotationDriverseEndors.getPolicyNumber() };
				String[] smsParams = { quotationDriverseEndors.getPolicyNumber() };
				List<File> fileList = new ArrayList<>();
				List<String> fileNames = new ArrayList<>();
				NotificationsLocalServiceUtil.notifyUser(resourceRequest.getLocale(), String.valueOf(Type.POILCY_ENDORSEMENT_WP), insuredEmail, mobileNumber, mailParams, smsParams, fileList,
						fileNames, mailParams, themeDisplay.getUser().getUserId(), themeDisplay.getUser().getCompanyId());
				writer = resourceResponse.getWriter();
				writer.print("success");
			} catch (PortalException e) {
				writer.print("error");
				_log.error(e.getMessage(), e);
			} catch (SQLException e) {
				_log.error(e.getMessage(), e);
			}

		}
	}

	public void rejectDetails(ActionRequest actionRequest, ActionResponse response) throws PortalException, SQLException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String policyNumber = actionRequest.getParameter("policyNumber");
		String mobileNumber = actionRequest.getParameter("mobile");
		String insuredEmail = actionRequest.getParameter("insuredEmail");
		if (!policyNumber.equals(null)) {
			QuotationDriverseEndors pol = QuotationDriverseEndorsLocalServiceUtil.findByPolicyNumber(policyNumber);
			/* pol.setrej(rejectionReason); */
			pol.setStatus("RJ");
			QuotationDriverseEndorsLocalServiceUtil.updateQuotationDriverseEndors(pol);
			String[] mailParams = { pol.getDriverName(), pol.getPolicyNumber() };
			String[] smsParams = { pol.getPolicyNumber() };
			List<File> fileList = new ArrayList<>();
			List<String> fileNames = new ArrayList<>();
			NotificationsLocalServiceUtil.notifyUser(actionRequest.getLocale(), String.valueOf(Type.POILCY_ENDORSEMENT_REJECTED), insuredEmail, mobileNumber, mailParams, smsParams, fileList,
					fileNames, mailParams, themeDisplay.getUser().getUserId(), themeDisplay.getUser().getCompanyId());
		}
	}

	public void approveDetails(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String mobileNumber = actionRequest.getParameter("mobile");
		if (!Pattern.compile("(^05)([0-9]{8})").matcher(mobileNumber).find())
			mobileNumber = "";
		String policyNumber = actionRequest.getParameter("policyNumber");
		String insuredEmail = actionRequest.getParameter("insuredEmail");
		if (!Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$").matcher(insuredEmail).find())
			insuredEmail = "";

		try {
			CaptchaUtil.check(actionRequest);
			_log.info("CAPTCHA validated successfully");
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			SessionErrors.add(actionRequest, "successMessage");
		} catch (CaptchaException e) {
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			SessionErrors.add(actionRequest, "errorMessage");
			_log.info("CAPTCHA not validated");
			actionRequest.setAttribute("errorCaptcha", true);
			_log.error(e.getMessage(), e);
			return;
		}

		File endorsementFile = uploadPortletRequest.getFile("uploadFile");
		String fileName = endorsementFile.getName();
		try {
			QuotationDriverseEndors pol = QuotationDriverseEndorsLocalServiceUtil.findByPolicyNumber(policyNumber);
			pol.setStatus("PC");
			QuotationDriverseEndorsLocalServiceUtil.updateQuotationDriverseEndors(pol);
			String[] mailParams = { pol.getDriverName(), pol.getPolicyNumber() };
			String[] smsParams = { pol.getPolicyNumber() };
			List<File> fileList = new ArrayList<>();
			List<String> fileNames = new ArrayList<>();
			try {
				if (FileUtil.validateFile(endorsementFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE)) {
					fileList.add(endorsementFile);
					fileNames.add(fileName);
				}
			} catch (Exception e) {
				SessionErrors.add(actionRequest, "invalid_file_name");
				return;
			}
			NotificationsLocalServiceUtil.notifyUser(actionRequest.getLocale(), String.valueOf(Type.POILCY_ENDORSEMENT_SUCCESS), insuredEmail, mobileNumber, mailParams, smsParams, fileList, fileNames,
					mailParams, themeDisplay.getUser().getUserId(), themeDisplay.getUser().getCompanyId());
			/*
			 * SMSLocalServiceUtil.sendSms(LanguageUtil.get(request.getLocale(), ""),
			 * "0567462212");
			 */
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

	}

}