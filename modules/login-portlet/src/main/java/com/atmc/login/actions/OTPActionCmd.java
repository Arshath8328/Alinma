package com.atmc.login.actions;

/**
 * 
 */

import com.atmc.bsl.db.service.OTPLocalServiceUtil;
import com.atmc.login.constants.LoginPortletKeys;
import com.ejada.atmc.web.common.UserInfo;
import com.ejada.atmc.web.constants.OTPPortletKeys;
import com.ejada.atmc.web.util.SessionUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Basel
 *
 */
@Component(
		property =
		{ "javax.portlet.name=" + LoginPortletKeys.LOGIN, "mvc.command.name=/auth/otp" },
		service = MVCActionCommand.class
)

public class OTPActionCmd extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		_log.info("OTP Action amd");

		String cmd = ParamUtil.getString(actionRequest, OTPPortletKeys.CMD);

		if (cmd.equals(OTPPortletKeys.CMD_SEND))
			sendOTP(actionRequest, actionResponse);
		else if (cmd.equals(OTPPortletKeys.CMD_RESEND))
			resendOTP(actionRequest, actionResponse);
		else if (cmd.equals(OTPPortletKeys.CMD_VALIDATE))
			validateOTP(actionRequest, actionResponse);

	}

	protected void sendOTP(ActionRequest actionRequest, ActionResponse actionResponse) {
		_log.info("sending OTP");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		actionRequest.getPortletSession().setAttribute("otpSent", false);

		UserInfo userInfo = SessionUtil.getUserInfo(actionRequest);
		if (userInfo.getOtpSecret() == null)
			userInfo.setOtpSecret(OTPLocalServiceUtil.generateSecret());

		String sendTo = ParamUtil.getString(actionRequest, OTPPortletKeys.SEND_TO);
		if (sendTo != null && sendTo.equals(OTPPortletKeys.SEND_TO_EMAIL)) {
			if (themeDisplay.isSignedIn()) {
				_log.info("sending OTP to email " + themeDisplay.getUser().getEmailAddress());
				boolean otpSent = OTPLocalServiceUtil.sendOTPToEmail(themeDisplay.getLocale(), userInfo.getOtpSecret(), themeDisplay.getUser().getEmailAddress());
				if (!otpSent)
					SessionErrors.add(actionRequest, "otpsenderror");
			} else {
				_log.error("User is not signed in. OTP wont be sebt to EMAIL");
				SessionErrors.add(actionRequest, "otpsenderror");
			}

		} else {
			String mobile = getMobileNumber(actionRequest);
			String email = StringPool.NULL;
			try {
				User userExist = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), ParamUtil.getString(actionRequest, "login", StringPool.NULL));
				if (Validator.isNotNull(userExist)) {
					email = userExist.getEmailAddress();
				}
			} catch (PortalException e) {
				_log.error(e.getMessage(), e);
			}
			if (mobile != null) {
				_log.info("sending OTP to mobile " + mobile);

				boolean otpSent = OTPLocalServiceUtil.sendOTP(themeDisplay.getLocale(), userInfo.getOtpSecret(), mobile);
				boolean otpSentEmail = OTPLocalServiceUtil.sendOTPToEmail(themeDisplay.getLocale(), userInfo.getOtpSecret(), email);
				if (!otpSent || !otpSentEmail)
					SessionErrors.add(actionRequest, "otpsenderror");
			} else {
				_log.error("User has no registered mobile");
				SessionErrors.add(actionRequest, "otpsenderror");
			}
		}
	}

	private String getMobileNumber(ActionRequest actionRequest) {
		String mobile = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		actionRequest.getPortletSession().removeAttribute("requestmobile");
		UserInfo userInfo = SessionUtil.getUserInfo(actionRequest);
		// try to get mobile number from request
		if (!(ParamUtil.getString(actionRequest, OTPPortletKeys.MOBILE_NUMBER).isEmpty())) {
			mobile = ParamUtil.getString(actionRequest, OTPPortletKeys.MOBILE_NUMBER);
			actionRequest.getPortletSession().setAttribute("requestmobile", "true");
		} else if (!(ParamUtil.getString(httpRequest, OTPPortletKeys.MOBILE_NUMBER).isEmpty())) {
			mobile = ParamUtil.getString(httpRequest, OTPPortletKeys.MOBILE_NUMBER);
			actionRequest.getPortletSession().setAttribute("requestmobile", "true");
			actionRequest.setAttribute(OTPPortletKeys.MOBILE_NUMBER, mobile);
			PortletSession ps1 = actionRequest.getPortletSession();
			ps1.setAttribute("mob", mobile, PortletSession.APPLICATION_SCOPE);
		} else {
			if (themeDisplay.isSignedIn()) {
				if (themeDisplay.getUser().getPhones() != null && !themeDisplay.getUser().getPhones().isEmpty())
					mobile = themeDisplay.getUser().getPhones().iterator().next().getNumber();
			} else
				mobile = userInfo.getMobile();
		}
		return mobile;
	}

	private String resendMobileNumber(ActionRequest actionRequest) {
		String mobile = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		actionRequest.getPortletSession().removeAttribute("requestmobile");
		UserInfo userInfo = SessionUtil.getUserInfo(actionRequest);
		PortletSession ps = actionRequest.getPortletSession();
		mobile = (String) ps.getAttribute("mob", PortletSession.APPLICATION_SCOPE);
		_log.info("mobile number " + mobile);

		// try to get mobile number from request
		if (mobile != null) {
			actionRequest.setAttribute(OTPPortletKeys.MOBILE_NUMBER, mobile);
			actionRequest.getPortletSession().setAttribute("mobile_no", mobile);
			actionRequest.getPortletSession().setAttribute("requestmobile", "true");
		} else {
			if (themeDisplay.isSignedIn()) {
				if (themeDisplay.getUser().getPhones() != null && !themeDisplay.getUser().getPhones().isEmpty())
					mobile = themeDisplay.getUser().getPhones().iterator().next().getNumber();
			} else
				mobile = userInfo.getMobile();
		}
		return mobile;
	}

	protected void resendOTP(ActionRequest actionRequest, ActionResponse actionResponse) {
		_log.info("resending OTP");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UserInfo userInfo = SessionUtil.getUserInfo(actionRequest);
		userInfo.setOtpSecret(OTPLocalServiceUtil.generateSecret());
		_log.info("OTP secret:" + userInfo.getOtpSecret());

		String sendTo = ParamUtil.getString(actionRequest, OTPPortletKeys.SEND_TO);
		if (sendTo != null && sendTo.equals(OTPPortletKeys.SEND_TO_EMAIL)) {
			if (themeDisplay.isSignedIn()) {
				_log.info("sending OTP to email " + themeDisplay.getUser().getEmailAddress());
				boolean otpSent = OTPLocalServiceUtil.sendOTPToEmail(themeDisplay.getLocale(), userInfo.getOtpSecret(), themeDisplay.getUser().getEmailAddress());
				if (!otpSent)
					SessionErrors.add(actionRequest, "otpsenderror");
				else {
					actionResponse.setRenderParameter("otpSent", "true");
					actionRequest.getPortletSession().setAttribute("otpSent", true);
				}
			} else {
				_log.error("User is not signed in. OTP wont be sebt to EMAIL");
				SessionErrors.add(actionRequest, "otpsenderror");
			}
		} else {
			String mobile = resendMobileNumber(actionRequest);
			String email = StringPool.NULL;
			try {
				User userExist = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), ParamUtil.getString(actionRequest, "login", StringPool.NULL));
				if (Validator.isNotNull(userExist)) {
					email = userExist.getEmailAddress();
				}
			} catch (PortalException e) {
				_log.error(e.getMessage(), e);
			}
			if (mobile != null) {
				_log.info("Resending OTP to mobile " + mobile);

				boolean otpSent = OTPLocalServiceUtil.sendOTP(themeDisplay.getLocale(), userInfo.getOtpSecret(), mobile);
				boolean otpSentEmail = OTPLocalServiceUtil.sendOTPToEmail(themeDisplay.getLocale(), userInfo.getOtpSecret(), email);
				if (!otpSent || !otpSentEmail)
					SessionErrors.add(actionRequest, "otpsenderror");
				else {
					actionResponse.setRenderParameter("otpSent", "true");
					actionRequest.getPortletSession().setAttribute("otpSent", true);
				}
			} else {
				_log.info(" user has no registered mobile");
				SessionErrors.add(actionRequest, "otpsenderror");
			}
		}
	}

	protected void validateOTP(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		_log.info("validating OTP");
		String otp = ParamUtil.getString(actionRequest, "otp");
		UserInfo userInfo = SessionUtil.getUserInfo(actionRequest);
		_log.info("OTP secret:" + userInfo.getOtpSecret());
		boolean otpValidated = OTPLocalServiceUtil.validateOTP(userInfo.getOtpSecret(), otp);

		if (otpValidated) {
			actionRequest.getPortletSession().removeAttribute("mob");
			String redirect = ParamUtil.getString(actionRequest, OTPPortletKeys.REDIRECT_URL);
			String redirectJsMethod = ParamUtil.getString(actionRequest, OTPPortletKeys.REDIRECT_JS_METHOD);
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			boolean requestMobile = (actionRequest.getPortletSession().getAttribute("requestmobile") != null);

			if (themeDisplay.isSignedIn() || requestMobile) {
				// actionRequest.setAttribute("otpredirect", "true");
				actionRequest.getPortletSession().setAttribute("otpredirect", "true");
				actionResponse.setRenderParameter(OTPPortletKeys.REDIRECT_URL, redirect);
				actionResponse.setRenderParameter(OTPPortletKeys.REDIRECT_JS_METHOD, redirectJsMethod);
			} else {
				actionResponse.sendRedirect(redirect);
			}
		} else {
			SessionErrors.add(actionRequest, "otperror");

			boolean otpSent = (Boolean) actionRequest.getPortletSession().getAttribute("otpSent");
			if (otpSent)
				actionResponse.setRenderParameter("otpSent", "true");
		}

	}

	private static final Log	_log	= LogFactoryUtil.getLog(OTPActionCmd.class);

	@Reference
	private Portal				_portal;

}
