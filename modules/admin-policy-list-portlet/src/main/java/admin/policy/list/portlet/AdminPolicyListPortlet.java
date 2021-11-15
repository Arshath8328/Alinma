package admin.policy.list.portlet;

import admin.policy.list.constants.AdminPolicyListPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.owasp.encoder.Encode;

import com.ejada.atmc.acl.db.model.QuotationAdminUploads;
import com.atmc.bsl.db.domain.quotation.Quotation;
import com.atmc.bsl.db.service.NotificationsLocalServiceUtil;
import com.atmc.bsl.db.service.QuotationLocalServiceUtil;
import com.atmc.web.common.NotificationTypes.Type;
import com.atmc.web.constants.BuyMotorPolicyPortletKeys;
import com.atmc.web.util.FileUtil;
import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.petra.io.StreamUtil;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.io.ByteArrayFileInputStream;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
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
		"javax.portlet.display-name=ATMC Admin Policy List Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AdminPolicyListPortletKeys.ADMINPOLICYLIST,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AdminPolicyListPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(AdminPolicyListPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String myViewParam = ParamUtil.getString(renderRequest, "myview");
		String myParentViewParam = ParamUtil.getString(renderRequest, "myParentView");

		String myview = myViewParam.equals("") ? null : myViewParam;
		String myParentView = myParentViewParam.equals("") ? null : myParentViewParam;

		if (myParentView != null && myview == null) {
			myview = myParentView;
		}
		if (myview == null || myview.equals("view")) {
			int quotationsCount;
			try {
				quotationsCount = QuotationLocalServiceUtil.getAdminQuotationsCount();
				renderRequest.setAttribute("quotationsTotalCount", quotationsCount);

			} catch (PortalException e) {
				_log.error(e.getMessage(), e);
			}

		}
		String view = "/" + (myview == null ? "view" : myview) + ".jsp";
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
		dispatcher.include(renderRequest, renderResponse);
	}

	public void quotationDetails(ActionRequest request, ActionResponse response) {

		long quotationId = ParamUtil.getLong(request, "quotationId");
		try {
			Quotation quotation = QuotationLocalServiceUtil.getAdminQuotationByQuotationId(quotationId);
			request.setAttribute("quotation", quotation);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

	}

	public void submitFile(ActionRequest request, ActionResponse response) {

		long quotationId = ParamUtil.getLong(request, "quotationId");
		try {
			CaptchaUtil.check(request);
			_log.info("CAPTCHA validated successfully");
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			SessionErrors.add(request, "successMessage");
		} catch (CaptchaException e) {
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

			File adminFile = uploadPortletRequest.getFile("adminFile");
			String fileName = uploadPortletRequest.getFileName("adminFile");
			if (!adminFile.exists()) {
				_log.info("ID is Empty File");
			}
			if ((adminFile != null) && adminFile.exists()) {
				if (FileUtil.validateFile(adminFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE))
					QuotationLocalServiceUtil.saveAdminFiles(quotationId, adminFile, fileName);
				else
					SessionErrors.add(request, "file.failed");
			}

			Quotation quotation = QuotationLocalServiceUtil.getAdminQuotationByQuotationId(quotationId);
			request.setAttribute("quotation", quotation);

		} catch (Exception e) {
		} finally {
			try {
				StreamUtil.cleanUp(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void deleteFile(ActionRequest request, ActionResponse response) {

		int fileId = ParamUtil.getInteger(request, "fileId");
		long quotationId = ParamUtil.getLong(request, "quotationId");
		QuotationLocalServiceUtil.removeAdminFiles(fileId);
		Quotation quotation;
		try {
			quotation = QuotationLocalServiceUtil.getAdminQuotationByQuotationId(quotationId);
			request.setAttribute("quotation", quotation);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

	}

	public void downloadFile(ActionRequest request, ActionResponse response) {

		int fileId = ParamUtil.getInteger(request, "fileId");
		long quotationId = ParamUtil.getLong(request, "quotationId");

		QuotationLocalServiceUtil.downloadAdminFiles(fileId);
		Quotation quotation;
		try {
			quotation = QuotationLocalServiceUtil.getAdminQuotationByQuotationId(quotationId);
			request.setAttribute("quotation", quotation);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

	}

	public void rejectQuotation(ActionRequest request, ActionResponse response) throws PortalException {
		long quotationId = ParamUtil.getLong(request, "quotationId");
		String quotationStatus = ParamUtil.getString(request, "quotationStatus");
		User user = PortalUtil.getUser(request);
		Date date = new Date();
		String[] reason = ParamUtil.getString(request, "reason").split(",");
		String reasonVal = reason[0];
		String reasonType = reason[1]; // 0 For Hard Rejection Reason - 1 For Video Surevy Rejection Reasons
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(request);
		String reasonTxt = LanguageUtil.get(httpReq, "reject_reason_" + reasonVal);
		if (reasonType != null && reasonType.equals("1") && quotationStatus.equals(BuyMotorPolicyPortletKeys.QUOTATION_STATUS_PENDING_SURVEY_APPROVE)) {
			int noOfVideos = QuotationLocalServiceUtil.findQuotationSurveyVideo(String.valueOf(quotationId)).size();
			if (noOfVideos >= 5)
				QuotationLocalServiceUtil.rejectQuotation(quotationId, user.getEmailAddress(), date, reasonTxt, null);
			else
				QuotationLocalServiceUtil.rejectQuotation(quotationId, user.getEmailAddress(), date, reasonTxt, "PS");
		} else {
			QuotationLocalServiceUtil.rejectQuotation(quotationId, user.getEmailAddress(), date, reasonTxt, null);
		}
	}

	public void acceptQuotation(ActionRequest request, ActionResponse response) throws PortalException {
		long quotationId = ParamUtil.getLong(request, "quotationId");
		String insName = ParamUtil.getString(request, "insName");
		String insEmail = ParamUtil.getString(request, "insEmail");
		String insMobile = ParamUtil.getString(request, "insMobile");

		if (!Pattern.matches("^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$", insEmail))
			insEmail = "";

		if (!Pattern.matches("^[0-9]+$", insMobile))
			insMobile = "";

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		User user = PortalUtil.getUser(request);
		Date date = new Date();
		String reason = Encode.forHtmlContent(ParamUtil.getString(request, "reason"));
		String quotAcc = QuotationLocalServiceUtil.acceptQuotation(quotationId, user.getEmailAddress(), date, reason);
		if (quotAcc.equals("succ")) {
			String[] mailArgs = { insName, PropsUtil.get("branchLocatorURL") };
			String[] smsArgs = { PropsUtil.get("branchLocatorURL") };
			NotificationsLocalServiceUtil.notifyUser(themeDisplay.getLocale(), Type.QUOTATION_GENERATION_OD_PENDING_PAYMENT.val(), insEmail, insMobile, mailArgs, smsArgs, new ArrayList<File>(),
					new ArrayList<>(), null, 0, 0);
		}

	}

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String custFileParam = ParamUtil.getString(resourceRequest, "cust");
		String custTypeFileParam = ParamUtil.getString(resourceRequest, "type");

		String custFile = custFileParam.equals("") ? null : custFileParam;
		String custTypeFile = custTypeFileParam.equals("") ? null : custTypeFileParam;

		_log.info("custFile:" + custFile + "...custTypeFile:" + custTypeFile);

		try {
			String fileType = "";
			byte[] pdf = null;

			if (custFile != null && custFile.equals("false")) {
				int fileId = ParamUtil.getInteger(resourceRequest, "fileId"); // Integer.parseInt(resourceRequest.getParameter("fileId"));
				QuotationAdminUploads file = QuotationLocalServiceUtil.downloadAdminFiles(fileId);
				fileType = file.getFileName().substring(file.getFileName().indexOf(".") + 1, file.getFileName().length());
				pdf = file.getAdminFile().getBytes(1, (int) file.getAdminFile().length());
				resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + file.getFileName() + "\"");
			} else if (custTypeFile.equals("video")) {
				String quoteID = ParamUtil.getString(resourceRequest, "quoteId");// resourceRequest.getParameter("quoteID");
				String videoID = ParamUtil.getString(resourceRequest, "videoId");// resourceRequest.getParameter("videoID");
				String fileNameParam = ParamUtil.getString(resourceRequest, "fileName");
				String fileName = fileNameParam.equals("") ? null : fileNameParam;

				_log.info("File is video.quoteID:" + quoteID + ".videoID:" + videoID + ".File name:" + fileName);

				pdf = QuotationLocalServiceUtil.findQuotationSurveyFile(Long.parseLong(videoID));

				if (fileName != null && fileName.indexOf(".") != -1) {
					fileType = fileName.split("\\.")[1];
				} else {
					fileType = "mp4";
				}

				_log.info("Video extension:" + fileType);

				resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			} else {
				long fileId = ParamUtil.getLong(resourceRequest, "fileId");// Long.parseLong(resourceRequest.getParameter("fileId"));
				String fileName = ParamUtil.getString(resourceRequest, "fileName");// resourceRequest.getParameter("fileName");
				String originalFileName = ParamUtil.getString(resourceRequest, "originalFileName");// resourceRequest.getParameter("originalFileName");

				_log.info("File Name:" + fileName + "..originalFileName:" + originalFileName);
				if (!fileName.equals("") && fileName.indexOf(".") > -1)
					fileType = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
				else if (!originalFileName.equals("") && originalFileName.indexOf(".") > -1) {
					_log.info("In original");
					fileType = originalFileName.substring(originalFileName.indexOf(".") + 1, originalFileName.length());
					fileName += "." + fileType;
				} else {
					_log.info("In else");
					fileType = "png";
					fileName += ".png";
				}

				_log.info("fileType:" + fileType);
				_log.info("fileName:" + fileName);

				if (custTypeFile.equals("carFront")) {
					pdf = QuotationLocalServiceUtil.findCustuploadsVehFront(fileId);
				} else if (custTypeFile.equals("carBack")) {
					pdf = QuotationLocalServiceUtil.findCustuploadsVehBack(fileId);
				} else if (custTypeFile.equals("carRight")) {
					pdf = QuotationLocalServiceUtil.findCustuploadsVehRight(fileId);
				} else if (custTypeFile.equals("carLeft")) {
					pdf = QuotationLocalServiceUtil.findCustuploadsVehLeft(fileId);
				} else if (custTypeFile.equals("engChassis")) {
					pdf = QuotationLocalServiceUtil.findCustuploadsChassisNo(fileId);
				} else if (custTypeFile.equals("leaseFile")) {
					pdf = QuotationLocalServiceUtil.findCustuploadsLeaseFile(fileId);
				} else if (custTypeFile.equals("istCard")) {
					pdf = QuotationLocalServiceUtil.findCustuploadsIstCardFile(fileId);
				} else if (custTypeFile.equals("custCard")) {
					pdf = QuotationLocalServiceUtil.findCustuploadsIstCardFile(fileId);
				} else if (custTypeFile.equals("relationProof")) {
					pdf = QuotationLocalServiceUtil.findInsuredRelationProof(fileId);
				}

				resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			}

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

			resourceResponse.setContentLength(pdf.length);
			OutputStream out = resourceResponse.getPortletOutputStream();
			out.write(pdf);
			out.close();

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

	}

	@Override
	protected void addSuccessMessage(ActionRequest actionRequest, ActionResponse actionResponse) {
		return;
	}
}