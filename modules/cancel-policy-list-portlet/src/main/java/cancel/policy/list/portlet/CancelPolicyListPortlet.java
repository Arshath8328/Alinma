package cancel.policy.list.portlet;

import cancel.policy.list.constants.CancelPolicyListPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;


import com.ejada.atmc.acl.db.exception.NoSuchPolicyCancelationException;
import com.ejada.atmc.acl.db.model.PolicyCancelation;
import com.ejada.atmc.acl.db.service.PolicyCancelationLocalServiceUtil;
import com.atmc.bsl.db.service.NotificationsLocalServiceUtil;
import com.atmc.web.common.NotificationTypes.Type;
import com.atmc.web.util.FileUtil;
import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author vidit
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CancelPolicyList Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CancelPolicyListPortletKeys.CANCELPOLICYLIST,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CancelPolicyListPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(CancelPolicyListPortlet.class);

	@Override
	public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		String myViewParam = ParamUtil.getString(request, "myview");
		String myview = myViewParam.equals("") ? null : myViewParam;
		String view = null;
		String parentViewParam = ParamUtil.getString(request, "myParentView");
		String myParentView = parentViewParam.equals("") ? null : parentViewParam;
		if (myParentView != null && myview == null) {
			myview = myParentView;
		}
		if (myview == null || myview.equals("view")) {
			int quotationsCount;
			quotationsCount = PolicyCancelationLocalServiceUtil.getPolicyCancelationsCount();
			List<PolicyCancelation> policyCanc = PolicyCancelationLocalServiceUtil.getPolicyCancelations(-1, -1);
			request.setAttribute("canclePolicyTotalCount", quotationsCount);
			request.setAttribute("policyCanc", policyCanc);
		}
		view = "/" + (myview == null ? "view" : myview) + ".jsp";
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	public void policyDetails(ActionRequest request, ActionResponse response) throws NoSuchPolicyCancelationException {
		String policyNumber = ParamUtil.getString(request, "policyNumber");
		PolicyCancelation policyDetails = PolicyCancelationLocalServiceUtil.findByPolicyNum(policyNumber);
		request.setAttribute("policyDetails", policyDetails);
	}

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		_log.info("inside serve resource ");
		String name = ParamUtil.getString(resourceRequest, "type");
		String policyNumber = ParamUtil.getString(resourceRequest, "policyNumber");
		String fileType = "";
		if (name.equals("ibanFile")) {
			String ibanFileNameParam = ParamUtil.getString(resourceRequest, "ibanFileName");
			String ibanFileName = ibanFileNameParam.equals("") ? null : ibanFileNameParam;
			if (ibanFileName != null && ibanFileName.indexOf(".") > -1)
				fileType = ibanFileName.substring(ibanFileName.indexOf(".") + 1, ibanFileName.length());
			ibanFileName += "." + fileType;
			byte[] ibanFile = null;
			try {
				ibanFile = PolicyCancelationLocalServiceUtil.findIbanFile(policyNumber);
			} catch (NoSuchPolicyCancelationException e) {
				_log.error(e.getMessage(), e);
			}
			resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + ibanFileName + "\"");

			if (fileType.trim().equalsIgnoreCase("txt")) {
				resourceResponse.setContentType("text/plain");
			} else if (fileType.trim().equalsIgnoreCase("doc")) {
				resourceResponse.setContentType("application/msword");
			} else if (fileType.trim().equalsIgnoreCase("xls")) {
				resourceResponse.setContentType("application/vnd.ms-excel");
			} else if (fileType.trim().equalsIgnoreCase("pdf")) {
				resourceResponse.setContentType("application/pdf");
			} else if (fileType.trim().equalsIgnoreCase("ppt")) {
				resourceResponse.setContentType("application/ppt");
			} else if (fileType.trim().equalsIgnoreCase("mp4")) {
				resourceResponse.setContentType("video/mp4");
			} else if (fileType.trim().equalsIgnoreCase("png")) {
				resourceResponse.setContentType("image/png");
			} else if (fileType.trim().equalsIgnoreCase("jpg") || fileType.trim().equalsIgnoreCase("jpeg")) {
				resourceResponse.setContentType("image/jpeg");
			} else {
				resourceResponse.setContentType("application/octet-stream");
			}
			resourceResponse.setContentLength(ibanFile.length);
			OutputStream out = resourceResponse.getPortletOutputStream();
			out.write(ibanFile);
			out.close();
		}

		if (name.equals("validFile")) {
			String validFileNameParam = ParamUtil.getString(resourceRequest, "validFileName");
			String validFileName = validFileNameParam.equals("") ? null : validFileNameParam;
			byte[] validFile = null;
			try {
				validFile = PolicyCancelationLocalServiceUtil.findValidFile(policyNumber);

				if (validFileName != null && validFileName.indexOf(".") > -1)
					fileType = validFileName.substring(validFileName.indexOf(".") + 1, validFileName.length());
				validFileName += "." + fileType;

			} catch (NoSuchPolicyCancelationException e) {
				_log.error(e.getMessage(), e);
			}
			resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + validFileName + "\"");
			if (fileType.trim().equalsIgnoreCase("txt")) {
				resourceResponse.setContentType("text/plain");
			} else if (fileType.trim().equalsIgnoreCase("doc")) {
				resourceResponse.setContentType("application/msword");
			} else if (fileType.trim().equalsIgnoreCase("xls")) {
				resourceResponse.setContentType("application/vnd.ms-excel");
			} else if (fileType.trim().equalsIgnoreCase("pdf")) {
				resourceResponse.setContentType("application/pdf");
			} else if (fileType.trim().equalsIgnoreCase("ppt")) {
				resourceResponse.setContentType("application/ppt");
			} else if (fileType.trim().equalsIgnoreCase("mp4")) {
				resourceResponse.setContentType("video/mp4");
			} else if (fileType.trim().equalsIgnoreCase("png")) {
				resourceResponse.setContentType("image/png");
			} else if (fileType.trim().equalsIgnoreCase("jpg") || fileType.trim().equalsIgnoreCase("jpeg")) {
				resourceResponse.setContentType("image/jpeg");
			} else {
				resourceResponse.setContentType("application/octet-stream");
			}
			resourceResponse.setContentLength(validFile.length);
			OutputStream out = resourceResponse.getPortletOutputStream();
			out.write(validFile);
			out.close();
		}
		if (name.equals("workinProgress")) {
			PrintWriter writer = null;
			String polNumberProgressParam = ParamUtil.getString(resourceRequest, "policyNumber");
			String polNumworkProgress = polNumberProgressParam.equals("") ? null : polNumberProgressParam;
			try {
				PolicyCancelation polCanc = PolicyCancelationLocalServiceUtil.findByPolicyNum(polNumworkProgress);
				polCanc.setStatus("WP");
				PolicyCancelationLocalServiceUtil.updatePolicyCancelation(polCanc);
				/*
				 * _log.info("lang key " + LanguageUtil.get(resourceRequest.getLocale(), "WORK_IN_PROGESS_MESSAGE"));
				 * SMSLocalServiceUtil.sendSms(LanguageUtil.get(resourceRequest.getLocale(), "WORK_IN_PROGESS_MESSAGE"),mobileNumber);
				 */
				String[] mailParams = { polCanc.getInsuredName(), polCanc.getPolicyNumber() };
				String[] smsParams = { polCanc.getPolicyNumber() };
				List<File> fileList = new ArrayList<>();
				List<String> fileNames = new ArrayList<>();
				/*
				 * SMSLocalServiceUtil.sendSms(LanguageUtil.get(request.getLocale(), ""), "0567462212");
				 */
				NotificationsLocalServiceUtil.notifyUser(resourceRequest.getLocale(), String.valueOf(Type.POILCY_ENDORSEMENT_WP), polCanc.getInsuredEmail(), polCanc.getInsuredMobile(), mailParams,
						smsParams, fileList, fileNames, mailParams, themeDisplay.getUser().getUserId(), themeDisplay.getUser().getCompanyId());
				writer = resourceResponse.getWriter();
				writer.print("success");
			} catch (PortalException e) {
				writer = resourceResponse.getWriter();
				writer.print("error");
				_log.error(e.getMessage(), e);
			}
		}

	}

	public void rejectDetails(ActionRequest actionRequest, ActionResponse response) throws PortalException, SQLException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String policyNumber = ParamUtil.getString(actionRequest, "policyNumber");
		String rejectionReason = ParamUtil.getString(actionRequest, "rejectionReason");
		if (!policyNumber.equals("")) {
			PolicyCancelation pol = PolicyCancelationLocalServiceUtil.findByPolicyNum(policyNumber);
			pol.setServicemessage(rejectionReason);
			pol.setStatus("RJ");
			PolicyCancelationLocalServiceUtil.updatePolicyCancelation(pol);
			String[] mailParams = { pol.getInsuredName(), pol.getPolicyNumber() };
			String[] smsParams = { pol.getPolicyNumber() };
			List<File> fileList = new ArrayList<>();
			List<String> fileNames = new ArrayList<>();
			NotificationsLocalServiceUtil.notifyUser(actionRequest.getLocale(), String.valueOf(Type.POILCY_ENDORSEMENT_REJECTED), pol.getInsuredEmail(), pol.getInsuredMobile(), mailParams, smsParams,
					fileList, fileNames, mailParams, themeDisplay.getUser().getUserId(), themeDisplay.getUser().getCompanyId());
		}
	}

	public void approveDetails(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String policyNumber = ParamUtil.getString(actionRequest, "policyNumber");
		File endorsementFile = uploadPortletRequest.getFile("uploadFile");
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
		String fileName = endorsementFile.getName();
		try {
			PolicyCancelation pol = PolicyCancelationLocalServiceUtil.findByPolicyNum(policyNumber);
			pol.setStatus("PC");
			PolicyCancelationLocalServiceUtil.updatePolicyCancelation(pol);
			String[] mailParams = { pol.getInsuredName(), pol.getPolicyNumber() };
			String[] smsParams = { pol.getPolicyNumber() };
			List<File> fileList = new ArrayList<>();

			if (fileValidate(endorsementFile, ".jpg", ".jpeg", null, 1)) {
				try {
					if (FileUtil.validateFile(endorsementFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE)) {
						fileList.add(endorsementFile);
						List<String> fileNames = new ArrayList<String>();
						fileNames.add(fileName);
						/*
						 * SMSLocalServiceUtil.sendSms(LanguageUtil.get(request.getLocale(), ""), "0567462212");
						 */
						NotificationsLocalServiceUtil.notifyUser(actionRequest.getLocale(), String.valueOf(Type.POILCY_ENDORSEMENT_SUCCESS), pol.getInsuredEmail(), pol.getInsuredMobile(), mailParams,
								smsParams, fileList, fileNames, mailParams, themeDisplay.getUser().getUserId(), themeDisplay.getUser().getCompanyId());
					} else
						_log.info("File Validation Failed!");
				} catch (Exception e) {
					SessionErrors.add(actionRequest, "invalid_file_name");
					return;
				}
			} else {
				SessionErrors.add(actionRequest, "file.failed");
			}
		} catch (NoSuchPolicyCancelationException | IOException e) {
			_log.error(e.getMessage(), e);
		}
	}

	public boolean fileValidate(File file, String extensionFile, String extensionFile1, String extensionFile2, long acceptFileSize) throws IOException {
		String fileName = file.getName().toUpperCase();
		if (fileName.split("[.]").length > 1) {
			return false;
		}

		boolean extension = fileName.endsWith(extensionFile) || fileName.endsWith(Validator.isNotNull(extensionFile1) ? "" : extensionFile1)
				|| fileName.endsWith(Validator.isNotNull(extensionFile2) ? "" : extensionFile2);
		if (!extension) {
			return false;
		}
		FileInputStream in = null;
		try {
//			   Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
//			   Matcher m = p.matcher(fileName);
//			   boolean b = m.find();
//			   if(b){
//				   return false;
//			   }
			boolean fileSizelesser = file.length() * (1024 * 1024) > acceptFileSize;
			if (fileSizelesser) {
				return false;
			}
			in = new FileInputStream(file);
			byte[] magic = new byte[3];
			int count = in.read(magic);
			if (count < 3)
				return false;
			return magic[0] == 0xFF && magic[1] == 0xD8 && magic[2] == 0xFF;
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException ex) {
			}
		}
	}
}