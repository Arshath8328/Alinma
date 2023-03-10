package com.atmc.admin.login.actions;

import com.atmc.admin.login.constants.AdminLoginPortletKeys;
import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.captcha.CaptchaConfigurationException;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.RequiredReminderQueryException;
import com.liferay.portal.kernel.exception.SendPasswordException;
import com.liferay.portal.kernel.exception.UserActiveException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserLockoutException;
import com.liferay.portal.kernel.exception.UserReminderQueryException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = {
			"javax.portlet.name="+ AdminLoginPortletKeys.ADMINLOGIN,
			"mvc.command.name=/adminLogin/forgot_password"
		},
		service = MVCActionCommand.class
	)
public class AdminForgotPasswordActionCmd  extends BaseMVCActionCommand{

	protected void checkCaptcha(ActionRequest actionRequest)
			throws CaptchaConfigurationException, CaptchaException {

			//CaptchaConfiguration captchaConfiguration = getCaptchaConfiguration();

			//if (captchaConfiguration.sendPasswordCaptchaEnabled()) {
				CaptchaUtil.check(actionRequest);
			//}
		}

		protected void checkReminderQueries(
				ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

			PortletSession portletSession = actionRequest.getPortletSession();

			int step = ParamUtil.getInteger(actionRequest, "step");

			if (step == 1) {
				checkCaptcha(actionRequest);

				portletSession.removeAttribute(
					WebKeys.FORGOT_PASSWORD_REMINDER_ATTEMPTS);
				portletSession.removeAttribute(
					WebKeys.FORGOT_PASSWORD_REMINDER_USER_EMAIL_ADDRESS);
			}

			User user = getUser(actionRequest);

			portletSession.setAttribute(
				WebKeys.FORGOT_PASSWORD_REMINDER_USER_EMAIL_ADDRESS,
				user.getEmailAddress());

			actionRequest.setAttribute(WebKeys.FORGOT_PASSWORD_REMINDER_USER, user);

			if (step == 2) {
				Integer reminderAttempts = (Integer)portletSession.getAttribute(
					WebKeys.FORGOT_PASSWORD_REMINDER_ATTEMPTS);

				if (reminderAttempts == null) {
					reminderAttempts = 0;
				}
				else if (reminderAttempts > 2) {
					checkCaptcha(actionRequest);
				}

				reminderAttempts++;

				portletSession.setAttribute(
					WebKeys.FORGOT_PASSWORD_REMINDER_ATTEMPTS, reminderAttempts);

				sendPassword(actionRequest, actionResponse);
			}
		}

		@Override
		protected void doProcessAction(
				ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

			Company company = themeDisplay.getCompany();

			if (!company.isSendPassword() && !company.isSendPasswordResetLink()) {
				throw new PrincipalException.MustBeEnabled(
					company.getCompanyId(),
					PropsKeys.COMPANY_SECURITY_SEND_PASSWORD,
					PropsKeys.COMPANY_SECURITY_SEND_PASSWORD_RESET_LINK);
			}

			try {
				if (GetterUtil.getBoolean(PropsUtil.get(PropsKeys.USERS_REMINDER_QUERIES_ENABLED))) {
					checkReminderQueries(actionRequest, actionResponse);
				}
				else {
					checkCaptcha(actionRequest);

					sendPassword(actionRequest, actionResponse);
				}
			}
			catch (Exception e) {
				if (e instanceof CaptchaConfigurationException ||
					e instanceof CaptchaTextException ||
					e instanceof UserEmailAddressException) {

					SessionErrors.add(actionRequest, e.getClass());
				}
				else if (e instanceof NoSuchUserException ||
						 e instanceof RequiredReminderQueryException ||
						 e instanceof SendPasswordException ||
						 e instanceof UserActiveException ||
						 e instanceof UserLockoutException ||
						 e instanceof UserReminderQueryException) {

					if (GetterUtil.getBoolean(PropsUtil.get(PropsKeys.LOGIN_SECURE_FORGOT_PASSWORD))) {
						sendRedirect(actionRequest, actionResponse, null);
					}
					else {
						SessionErrors.add(actionRequest, e.getClass(), e);
					}
				}
				else {
					_portal.sendError(e, actionRequest, actionResponse);
				}
			}
		}

//		protected CaptchaConfiguration getCaptchaConfiguration()
//			throws CaptchaConfigurationException {
	//
//			try {
//				return _configurationProvider.getSystemConfiguration(
//					CaptchaConfiguration.class);
//			}
//			catch (Exception e) {
//				throw new CaptchaConfigurationException(e);
//			}
//		}

		protected User getUser(ActionRequest actionRequest) throws Exception {
			PortletSession portletSession = actionRequest.getPortletSession();

			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

			String sessionEmailAddress = (String)portletSession.getAttribute(
				WebKeys.FORGOT_PASSWORD_REMINDER_USER_EMAIL_ADDRESS);

			User user = null;

			if (Validator.isNotNull(sessionEmailAddress)) {
				user = _userLocalService.getUserByEmailAddress(
					themeDisplay.getCompanyId(), sessionEmailAddress);
			}
			else {
				long userId = ParamUtil.getLong(actionRequest, "userId");
				String screenName = ParamUtil.getString(
					actionRequest, "screenName");
				String emailAddress = ParamUtil.getString(
					actionRequest, "emailAddress");

				if (Validator.isNotNull(emailAddress)) {
					user = _userLocalService.getUserByEmailAddress(
						themeDisplay.getCompanyId(), emailAddress);
				}
				else if (Validator.isNotNull(screenName)) {
					user = _userLocalService.getUserByScreenName(
						themeDisplay.getCompanyId(), screenName);
				}
				else if (userId > 0) {
					user = _userLocalService.getUserById(userId);
				}
				else {
					throw new NoSuchUserException("User does not exist");
				}
			}

			if (!user.isActive()) {
				throw new UserActiveException("Inactive user " + user.getUuid());
			}

			_userLocalService.checkLockout(user);

			return user;
		}

		protected void sendPassword(
				ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

			Company company = themeDisplay.getCompany();

			User user = getUser(actionRequest);

			if (GetterUtil.getBoolean(PropsUtil.get(PropsKeys.USERS_REMINDER_QUERIES_ENABLED))) {
				if (GetterUtil.getBoolean(PropsUtil.get(PropsKeys.USERS_REMINDER_QUERIES_REQUIRED)) &&
					!user.hasReminderQuery()) {

					throw new RequiredReminderQueryException(
						"No reminder query or answer is defined for user " +
							user.getUserId());
				}

				String answer = ParamUtil.getString(actionRequest, "answer");

				if (!user.getReminderQueryAnswer().equals(answer)) {
					throw new UserReminderQueryException(
						"Reminder query answer does not match answer");
				}
			}

			PortletPreferences portletPreferences = actionRequest.getPreferences();

			String languageId = LanguageUtil.getLanguageId(actionRequest);

			String emailFromName = portletPreferences.getValue(
				"emailFromName", null);
			String emailFromAddress = portletPreferences.getValue(
				"emailFromAddress", null);
			String emailToAddress = user.getEmailAddress();

			String emailParam = "emailPasswordSent";

			if (company.isSendPasswordResetLink()) {
				emailParam = "emailPasswordReset";
			}

			String subject = portletPreferences.getValue(
				emailParam + "Subject_" + languageId, null);
			String body = portletPreferences.getValue(
				emailParam + "Body_" + languageId, null);

//			LoginUtil.sendPassword(
//				actionRequest, emailFromName, emailFromAddress, emailToAddress,
//				subject, body);

			HttpServletRequest request = _portal.getHttpServletRequest(
				actionRequest);

			SessionMessages.add(request, "passwordSent");

			sendRedirect(actionRequest, actionResponse, null);
		}

		@Reference(unbind = "-")
		protected void setUserLocalService(UserLocalService userLocalService) {
			_userLocalService = userLocalService;
		}

		@Reference
		private ConfigurationProvider _configurationProvider;

		@Reference
		private Portal _portal;

		private UserLocalService _userLocalService;

}
