package report.fraud.portlet.portlet;

import com.atmc.web.util.FileUtil;
import com.ejada.atmc.acl.db.service.SendEmailServiceUtil;
import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.util.PropsUtil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import report.fraud.portlet.constants.ReportFraudPortletKeys;

/**
 * @author vidit
 */
@Component(
		immediate = true, 
		property = {
			"com.liferay.portlet.display-category=ATMC",
			"com.liferay.portlet.instanceable=false", 
			"javax.portlet.display-name=ATMC Report Fraud Portlet",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/report.jsp",
			"javax.portlet.name=" + ReportFraudPortletKeys.REPORTFRAUD,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=guest,power-user,user" 
		},
		service = Portlet.class
)
public class ReportFraudPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// long portletGroupId= themeDisplay.getPortletGroupdId();
		long groupId = themeDisplay.getLayout().getGroupId();
		long parentId = themeDisplay.getLayout().getParentLayoutId();
		List<Layout> publicLayouts = LayoutLocalServiceUtil.getLayouts(groupId, false);
		List<Layout> siblingsLayouts = new ArrayList<>();
		for (int x = 0; x < publicLayouts.size(); x++) {
			if (publicLayouts.get(x).getParentLayoutId() == parentId)
				siblingsLayouts.add(publicLayouts.get(x));

		}
		// renderRequest.setAttribute(SideMenuPortletsKeys.SIBLINGS_LAYOUTS_PUBLIC,
		// siblingsLayouts);

		super.doView(renderRequest, renderResponse);
	}

	public void reportFraudAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		Date incidentDate = ParamUtil.getDate(actionRequest, "dateOfIncident", sdf);
		String dateInc = sdf.format(incidentDate);
		String locationOfIncident = ParamUtil.getString(actionRequest,"locationOfIncident");
		String rafIAM = ParamUtil.getString(actionRequest,"rafIAM");
		String rafOther = ParamUtil.getString(actionRequest,"rafOther");
		String rafDescribe = ParamUtil.getString(actionRequest,"rafDescribe");
		String rafDescribeOther = ParamUtil.getString(actionRequest,"rafDescribeOther");
		String rafCaseRelated = ParamUtil.getString(actionRequest,"rafCaseRelated");
		String rafCaseRelatedOther = ParamUtil.getString(actionRequest,"rafCaseRelatedOther");
		String otherLocation = ParamUtil.getString(actionRequest,"other_location");

		String caseDetails = ParamUtil.getString(actionRequest,"caseDetails");
		String financialLoss = ParamUtil.getString(actionRequest,"financialLoss");
		String anyOtherLoss = ParamUtil.getString(actionRequest,"anyOtherLoss");
		String likelyHoodOfCase = ParamUtil.getString(actionRequest,"likelyHoodOfCase");

		String rafDtlAbuse = ParamUtil.getString(actionRequest,"rafDtlAbuse");
		String rafCompany = ParamUtil.getString(actionRequest,"rafCompany");
		String rafFullName = ParamUtil.getString(actionRequest,"rafFullName");
		String rafPolicyNumber = ParamUtil.getString(actionRequest,"rafPolicyNumber");
		String rafMobileNum = ParamUtil.getString(actionRequest,"rafMobileNum");
		String rafEmail = ParamUtil.getString(actionRequest,"rafEmail");
		String rafAddInf = ParamUtil.getString(actionRequest,"rafAddInf");

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File idFile = uploadPortletRequest.getFile("idFile");
		String fileName = uploadPortletRequest.getFileName("idFile");

		HashSet<String> acceptedTypes = new HashSet<>();
		acceptedTypes.add("application/pdf");
		acceptedTypes.add("application/vnd.openxmlformats-officedocument.wordprocessingml.document"); // docx
		acceptedTypes.add("application/msword"); // doc

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

//		boolean isFileTypeAccepted = FileUtil.isAcceptedFileType(idFile, acceptedTypes);
		boolean isFileTypeAccepted;
		try {
			isFileTypeAccepted = FileUtil.validateFile(idFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE);
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "file.failed");
			return;
		}
		boolean isFileExecutable = FileUtil.isExecutable(idFile);

		String mailMessage = "";
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		PortletConfig portletConfig = (PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
		SessionMessages.add(request, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

		if (rafIAM == null && rafDescribe == null && rafCaseRelated == null) {
			actionResponse.sendRedirect("/web/customer/report_a_fraud");
			return;
		}
		mailMessage += LanguageUtil.get(request, "date_of_incident") + " : " + dateInc + "\n";

		if (!(locationOfIncident.equals("-1"))) {
			mailMessage += LanguageUtil.get(request, "location_of_incident") + " : " + locationOfIncident + "\n";
		} else {
			mailMessage += LanguageUtil.get(request, "location_of_incident") + " : " + LanguageUtil.get(request, "other") + "\n";
			mailMessage += LanguageUtil.get(request, "other_plz_specify") + " : " + otherLocation + "\n";
		}

		// mailMessage+= LanguageUtil.get(request, "i_am") +" : "+ locationOfIncident
		// +"\n";
		if (!(rafIAM.equals("-1"))) {
			mailMessage += LanguageUtil.get(request, "i_am") + " : " + rafIAM + "\n";
		} else {
			mailMessage += LanguageUtil.get(request, "i_am") + " : " + LanguageUtil.get(request, "other") + "\n";
			mailMessage += LanguageUtil.get(request, "other_plz_specify") + " : " + rafOther + "\n";
		}

		if (!(rafDescribe.equals("-1"))) {
			mailMessage += LanguageUtil.get(request, "which_describe_you") + " : " + rafDescribe + "\n";
		} else {
			mailMessage += LanguageUtil.get(request, "which_describe_you") + " : " + LanguageUtil.get(request, "other") + "\n";
			mailMessage += LanguageUtil.get(request, "other_plz_specify") + " : " + rafDescribeOther + "\n";
		}

		if (!(rafCaseRelated.equals("-1"))) {
			mailMessage += LanguageUtil.get(request, "case_related_to") + " : " + rafCaseRelated + "\n" + "\n";
		} else {
			mailMessage += LanguageUtil.get(request, "case_related_to") + " : " + LanguageUtil.get(request, "other") + "\n";
			mailMessage += LanguageUtil.get(request, "other_plz_specify") + " : " + rafCaseRelatedOther + "\n";
		}
		mailMessage += LanguageUtil.get(request, "case_details") + " : " + caseDetails + "\n";
		mailMessage += LanguageUtil.get(request, "financial_loss") + " : " + financialLoss + "\n";
		mailMessage += LanguageUtil.get(request, "any_other_loss") + " : " + anyOtherLoss + "\n";
		mailMessage += LanguageUtil.get(request, "likelyhood_of_case") + " : " + likelyHoodOfCase + "\n" + "\n";
		mailMessage += LanguageUtil.get(request, "abuse_fraud_dtls") + " : " + rafDtlAbuse + "\n";
		mailMessage += LanguageUtil.get(request, "company_name") + " : " + rafCompany + "\n";
		mailMessage += LanguageUtil.get(request, "full_name") + " : " + rafFullName + "\n";
		mailMessage += LanguageUtil.get(request, "atmc_policy_no") + " : " + rafPolicyNumber + "\n";
		mailMessage += LanguageUtil.get(request, "mobile_number") + " : " + rafMobileNum + "\n";
		mailMessage += LanguageUtil.get(request, "e_mail") + " : " + rafEmail + "\n";
		mailMessage += LanguageUtil.get(request, "additional_info") + " : " + rafAddInf + "\n";

		List<File> files = new ArrayList<>();
		List<String> filesName = new ArrayList<>();

		if (isFileTypeAccepted && !isFileExecutable) {
			_log.info("We have file to attach");
			files.add(idFile);
			filesName.add(fileName);
		}

		boolean mailflag = SendEmailServiceUtil.sendEmail(PropsUtil.get("reportFraudMail"), "A Fraud Report", mailMessage, filesName, files);
		if (mailflag) {
			_log.info("Email sent Successfully");
			SessionMessages.add(request, "email_success");
		} else {
			_log.error("Failed to send Email");
			SessionErrors.add(request, "email_failed");
		}

	}

	private static final Log _log = LogFactoryUtil.getLog(ReportFraudPortlet.class);
}