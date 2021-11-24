/*
 * MenuPortlet.java Jan 28, 2018  
 *
 * Copyright (c) 2005-2012 Ejada Solutions.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Ejada
 * Solutions, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Ejada.
 */
package vacancies.portlet.portlet;

import com.atmc.bsl.db.service.CodeMasterDetailsLocalServiceUtil;
import com.atmc.bsl.db.service.ContentEngineLocalServiceUtil;
import com.atmc.web.util.FileUtil;
import com.ejada.atmc.acl.db.service.SendEmailServiceUtil;
import com.ejada.atmc.bsl.db.domain.codemaster.CodeMasterDetails;
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
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import vacancies.portlet.constants.VacanciesPortletKeys;

/**
 * @author Gasser
 *
 */
@Component(
	immediate = true,
	property = { 
		"com.liferay.portlet.display-category=ATMC",
		"com.liferay.portlet.instanceable=false", 
		"javax.portlet.display-name=ATMC Vacancies Form",
		"javax.portlet.init-param.template-path=/", 
		"javax.portlet.init-param.view-template=/applyForm.jsp",
		"javax.portlet.name=" + VacanciesPortletKeys.VACANCIES_FORM,
		"javax.portlet.resource-bundle=content.Language", 
		"javax.portlet.security-role-ref=guest,power-user,user" 
	},
	service = Portlet.class
)
public class VacanciesFormPortlet extends MVCPortlet {

	private static final String MASTER_CODE = "NATIONALITY";

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		HttpServletRequest servletRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String currLocale = themeDisplay.getLocale().toString();

		List<CodeMasterDetails> nationalitiesList = new ArrayList<CodeMasterDetails>();
		try {
			nationalitiesList = CodeMasterDetailsLocalServiceUtil.findCodeMasterDesc(MASTER_CODE, currLocale);
			renderRequest.setAttribute("nationalityData", nationalitiesList);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

		String jobTitle = ContentEngineLocalServiceUtil.getVacanyTitleByArticleId(themeDisplay, servletRequest.getParameter(VacanciesPortletKeys.JOB_ID));

		renderRequest.setAttribute(VacanciesPortletKeys.JOB_TITLE, jobTitle);
		super.doView(renderRequest, renderResponse);

	}

	public void applyForVacancy(ActionRequest actionRequest, ActionResponse actionResponse) {
		String applicantName = (String) actionRequest.getParameter("applicantName");
		String nationality = (String) actionRequest.getParameter("nationality");
		String appDOB_H = (String) actionRequest.getParameter("appDOB_H");
		String address = (String) actionRequest.getParameter("address");
		String gender = (String) actionRequest.getParameter("gender");
		String maritalStatus = (String) actionRequest.getParameter("maritalStatus");
		String phone = (String) actionRequest.getParameter("phone");
		String mail = (String) actionRequest.getParameter("mail");
		String highestDegree = (String) actionRequest.getParameter("highestDegree");
		String major = (String) actionRequest.getParameter("major");
		String yearsExp = (String) actionRequest.getParameter("yearsExp");
		String currentEmp = (String) actionRequest.getParameter("currentEmp");
		String currentPos = (String) actionRequest.getParameter("currentPos");
		String salary = (String) actionRequest.getParameter("salary");
		String engProficiency = (String) actionRequest.getParameter("engProficiency");
		String computerSkills = (String) actionRequest.getParameter("computerSkills");
		Boolean ifceFlag = Boolean.valueOf(actionRequest.getParameter("ifceFlag")).booleanValue();
		String jobTitle = (String) actionRequest.getParameter("jobTitle");

		HttpServletRequest reqcaptcha = PortalUtil.getHttpServletRequest(actionRequest);
		try {
			CaptchaUtil.check(actionRequest);
			_log.info("CAPTCHA validated successfully");
			// SessionMessages.add(actionRequest, PortalUtil.getPortletId(reqcaptcha) +
			// SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			// SessionErrors.add(request, "successMessage");
		} catch (CaptchaException e) {
			SessionErrors.add(actionRequest, "errorMessage");
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			_log.info("CAPTCHA not validated successfully");
//			return;
		}
		// Getting the uploaded files
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File idFile = uploadPortletRequest.getFile("idFile");
		String fileName = uploadPortletRequest.getFileName("idFile");

		HashSet<String> acceptedTypes = new HashSet<>();
		acceptedTypes.add("application/pdf");
		acceptedTypes.add("application/vnd.openxmlformats-officedocument.wordprocessingml.document"); // docx
		acceptedTypes.add("application/msword"); // doc

//		boolean isFileTypeAccepted = FileUtil.isAcceptedFileType(idFile, acceptedTypes);
		boolean isFileTypeAccepted;
		try {
			isFileTypeAccepted = FileUtil.validateFile(idFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE);
		} catch (Exception e1) {
			SessionErrors.add(actionRequest, "file.failed");
			return;
		}
		boolean isFileExecutable = FileUtil.isExecutable(idFile);

		String mailMessage = "";
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		mailMessage += LanguageUtil.get(request, "personal_det") + "\n";
		mailMessage += LanguageUtil.get(request, "full_name") + " : " + applicantName + "\n";
		mailMessage += LanguageUtil.get(request, "nationality") + " : " + nationality + "\n";
		mailMessage += LanguageUtil.get(request, "dob_h") + " : " + appDOB_H + "\n";
		mailMessage += LanguageUtil.get(request, "address") + " : " + address + "\n";
		mailMessage += LanguageUtil.get(request, "gender") + " : " + gender + "\n";
		mailMessage += LanguageUtil.get(request, "marital_status") + " : " + maritalStatus + "\n";
		mailMessage += LanguageUtil.get(request, "phone") + " : " + phone + "\n";
		mailMessage += LanguageUtil.get(request, "email_address") + " : " + mail + "\n";
		mailMessage += LanguageUtil.get(request, "qualifications") + "\n";
		mailMessage += LanguageUtil.get(request, "highest_deg") + " : " + highestDegree + "\n";
		mailMessage += LanguageUtil.get(request, "major") + " : " + major + "\n";
		mailMessage += LanguageUtil.get(request, "ifce_certified") + " : " + ifceFlag + "\n";
		mailMessage += LanguageUtil.get(request, "experience") + "\n";
		mailMessage += LanguageUtil.get(request, "years_exp") + " : " + yearsExp + "\n";
		mailMessage += LanguageUtil.get(request, "current_emp") + " : " + currentEmp + "\n";
		mailMessage += LanguageUtil.get(request, "curr_pos") + " : " + currentPos + "\n";
		mailMessage += LanguageUtil.get(request, "curr_salary") + " : " + salary + "\n";
		mailMessage += LanguageUtil.get(request, "skills") + "\n";
		mailMessage += LanguageUtil.get(request, "pro_eng_lang") + " : " + engProficiency + "\n";
		mailMessage += LanguageUtil.get(request, "computer_skills") + " : " + computerSkills + "\n";

		List<File> files = new ArrayList<>();
		List<String> filesName = new ArrayList<>();

		if (isFileTypeAccepted && !isFileExecutable) {
			_log.info("We have file to attach");
			files.add(idFile);
			filesName.add(fileName);
		}

		boolean mailflag = SendEmailServiceUtil.sendEmail(PropsUtil.get("vacanciesMail"), jobTitle, mailMessage, filesName, files);
		if (mailflag) {
			_log.info("Email sent Successfully");
			try {
				if (request.getParameter("sendCopyCB") != null && request.getParameter("sendCopyCB").equals("on")) {
					boolean mailCopyFlag = SendEmailServiceUtil.sendEmail(mail, jobTitle, mailMessage, filesName, files);
					if (!mailCopyFlag)
						SessionErrors.add(request, "email_copy_failed");
					else
						SessionMessages.add(request, "email_copy_success");
				}
				actionResponse.sendRedirect("/web/customer/vacancies");
				SessionMessages.add(request, "email_success");
			} catch (IOException e) {
				_log.error(e.getMessage(), e);
			}
		} else {
			_log.error("Failed to send Email");
			SessionErrors.add(request, "email_failed");
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(VacanciesFormPortlet.class);

	@Override
	protected void addSuccessMessage(ActionRequest actionRequest, ActionResponse actionResponse) {
		return;
	}
}
