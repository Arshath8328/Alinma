/**
 * 
 */
package com.atmc.login.actions;

import com.atmc.bsl.db.service.OTPLocalServiceUtil;
import com.atmc.login.constants.LoginPortletKeys;
//import com.ejada.atmc.bsl.db.service.OTPLocalServiceUtil;
import com.ejada.atmc.web.common.UserInfo;
import com.ejada.atmc.web.constants.FirstLoginChangePwdPortletKeys;
import com.ejada.atmc.web.constants.OTPPortletKeys;
import com.ejada.atmc.web.util.SessionUtil;
import com.liferay.portal.kernel.exception.CompanyMaxUsersException;
import com.liferay.portal.kernel.exception.CookieNotSupportedException;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PasswordExpiredException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserIdException;
import com.liferay.portal.kernel.exception.UserLockoutException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.exception.UserScreenNameException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.auth.Authenticator;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManager;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Basel
 *
 */
@Component(
		property =
		{ "javax.portlet.name=" + LoginPortletKeys.LOGIN, "mvc.command.name=/login/login" },
		service = MVCActionCommand.class
)

public class LoginActionCmd extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Auto-generated method stub

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String cmd = ParamUtil.getString(actionRequest, LoginPortletKeys.CMD);
			if (cmd.equals(LoginPortletKeys.CMD_LOGIN))
				login(themeDisplay, actionRequest, actionResponse);
			else if (cmd.equals(LoginPortletKeys.CMD_AUTH))
				authenticate(themeDisplay, actionRequest, actionResponse);
		} catch (Exception e) {
			if (e instanceof AuthException) {
				Throwable cause = e.getCause();
				hideDefaultErrorMessage(actionRequest);
				if (cause instanceof PasswordExpiredException || cause instanceof UserLockoutException) {

					SessionErrors.add(actionRequest, cause.getClass(), cause);
				} else {
					if (_log.isInfoEnabled()) {
						_log.info("Authentication failed");
					}

					SessionErrors.add(actionRequest, e.getClass());
				}
			} else if (e instanceof CompanyMaxUsersException || e instanceof CookieNotSupportedException || e instanceof NoSuchUserException || e instanceof PasswordExpiredException
					|| e instanceof UserEmailAddressException || e instanceof UserIdException || e instanceof UserLockoutException || e instanceof UserPasswordException
					|| e instanceof UserScreenNameException)
			{

				hideDefaultErrorMessage(actionRequest);
				SessionErrors.add(actionRequest, e.getClass(), e);

			} else {
				_log.error(e, e);

				_portal.sendError(e, actionRequest, actionResponse);

				return;
			}

			postProcessAuthFailure(actionRequest, actionResponse);
		}
	}

	protected void login(ThemeDisplay themeDisplay, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		HttpServletRequest request = _portal.getOriginalServletRequest(_portal.getHttpServletRequest(actionRequest));
		HttpServletResponse response = _portal.getHttpServletResponse(actionResponse);

		PortletSession pSession = actionRequest.getPortletSession();

		String login = (String) pSession.getAttribute("login");
		String password = (String) pSession.getAttribute("password");
		boolean rememberMe = (Boolean) pSession.getAttribute("rememberMe");

		if (!themeDisplay.isSignedIn()) {

			String authType = CompanyConstants.AUTH_TYPE_SN;
			_authenticatedSessionManager.login(request, response, login, password, rememberMe, authType);

			initUserSession(actionRequest, login);
		}

		actionResponse.setRenderParameter("loginredirect", "true");

	}

	protected void authenticate(ThemeDisplay themeDisplay, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_log.info("authenticate >>>>>>>>>>>>>>");
		HttpServletRequest request = _portal.getOriginalServletRequest(_portal.getHttpServletRequest(actionRequest));
		HttpServletResponse response = _portal.getHttpServletResponse(actionResponse);
		String login = ParamUtil.getString(actionRequest, "login");
		if (login.length() != 10) {
			_log.error("Invalid Login-Id");
			return;
		}
		String password = actionRequest.getParameter("password");
		boolean rememberMe = ParamUtil.getBoolean(actionRequest, "rememberMe");
		String authType = CompanyConstants.AUTH_TYPE_SN;
		Company company = PortalUtil.getCompany(request);
		Map<String, String[]> headerMap = new HashMap<>();
		Enumeration<String> enu1 = request.getHeaderNames();
		while (enu1.hasMoreElements()) {
			String name = enu1.nextElement();
			Enumeration<String> enu2 = request.getHeaders(name);
			List<String> headers = new ArrayList<>();
			while (enu2.hasMoreElements()) {
				String value = enu2.nextElement();
				headers.add(value);
			}
			headerMap.put(name, headers.toArray(new String[headers.size()]));
		}
		Map<String, String[]> parameterMap = request.getParameterMap();
		Map<String, Object> resultsMap = new HashMap<>();

		// authenticate user
		int authResult = Authenticator.FAILURE;
		authResult = UserLocalServiceUtil.authenticateByScreenName(company.getCompanyId(), login, password, headerMap, parameterMap, resultsMap);

		User user = (User) resultsMap.get("user");

		if (authResult != Authenticator.SUCCESS) {
			if (user != null) {
				user = UserLocalServiceUtil.fetchUser(user.getUserId());
			}

			if (user != null) {
				UserLocalServiceUtil.checkLockout(user);
			}

			throw new AuthException();
		}

		// user authenticated successfully
		// populate session
		PortletSession pSession = actionRequest.getPortletSession();

		pSession.setAttribute("login", login);
		pSession.setAttribute("password", password);
		pSession.setAttribute("rememberMe", rememberMe);

		UserInfo userInfo = SessionUtil.getUserInfo(actionRequest);
		userInfo.setArabicName(user.getFullName());
		userInfo.setEnglishName(user.getFullName());
		userInfo.setEmail(user.getEmailAddress());
		userInfo.setId(user.getScreenName());
		userInfo.setMobile(user.getPhones().iterator().next().getNumber());
		userInfo.setUserId(user.getUserId());

		// redirect to OTP
		Layout layout = (Layout) actionRequest.getAttribute(WebKeys.LAYOUT);

		PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, OTPPortletKeys.OTP, layout, PortletRequest.ACTION_PHASE);

		portletURL.setWindowState(LiferayWindowState.POP_UP);
		portletURL.setParameter("mvcRenderCommandName", "/auth/otp");
		portletURL.setParameter(ActionRequest.ACTION_NAME, "/auth/otp");
		portletURL.setParameter(OTPPortletKeys.CMD, OTPPortletKeys.CMD_SEND);
		portletURL.setParameter(OTPPortletKeys.MODE_LOGIN, "true");
		portletURL.setParameter("login", login);

		PortletURL redirectURL = PortletURLFactoryUtil.create(actionRequest, LoginPortletKeys.LOGIN, layout, PortletRequest.ACTION_PHASE);
		redirectURL.setWindowState(LiferayWindowState.POP_UP);

		// first time login case, redirect to change password
		if (user.getPasswordReset() && user.getLastLoginDate() == null) {
			pSession.setAttribute(FirstLoginChangePwdPortletKeys.CMD, FirstLoginChangePwdPortletKeys.CMD_CHANGE_PWD, PortletSession.APPLICATION_SCOPE);

			redirectURL.setParameter("mvcRenderCommandName", "/login/register");
			redirectURL.setParameter(ActionRequest.ACTION_NAME, "/login/register");
			redirectURL.setParameter(LoginPortletKeys.CMD, LoginPortletKeys.CMD_CHANGE_PWD);

		} else {
			redirectURL.setParameter("mvcRenderCommandName", "/login/login");
			redirectURL.setParameter(ActionRequest.ACTION_NAME, "/login/login");
			redirectURL.setParameter(LoginPortletKeys.CMD, LoginPortletKeys.CMD_LOGIN);
		}

		portletURL.setParameter(OTPPortletKeys.REDIRECT_URL, redirectURL.toString());

		actionResponse.sendRedirect(portletURL.toString());

	}

	protected void postProcessAuthFailure(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(actionRequest);

		String portletName = liferayPortletRequest.getPortletName();

		Layout layout = (Layout) actionRequest.getAttribute(WebKeys.LAYOUT);

		PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, portletName, layout, PortletRequest.RENDER_PHASE);

		portletURL.setParameter("saveLastPath", Boolean.FALSE.toString());
		portletURL.setWindowState(LiferayWindowState.POP_UP);

		String login = ParamUtil.getString(actionRequest, "login");

		if (Validator.isNotNull(login)) {
			SessionErrors.add(actionRequest, "login", login);
		}

		actionResponse.sendRedirect(portletURL.toString());
	}

	protected void initUserSession(ActionRequest actionRequest, String login) throws PortalException {
		Company company = PortalUtil.getCompany(actionRequest);
		User user = UserLocalServiceUtil.fetchUserByScreenName(company.getCompanyId(), login);
		UserInfo userInfo = SessionUtil.getUserInfo(actionRequest);
		userInfo.setArabicName((String) user.getExpandoBridge().getAttribute("arabicName", false));
		userInfo.setEnglishName(user.getFullName());
		userInfo.setEmail(user.getEmailAddress());
		userInfo.setId(user.getScreenName());
		userInfo.setMobile(user.getPhones().iterator().next().getNumber());
		userInfo.setUserId(user.getUserId());
		userInfo.setOrgMode(false);
		userInfo.setOtpSecret(OTPLocalServiceUtil.generateSecret());

	}

	private static final Log			_log	= LogFactoryUtil.getLog(LoginActionCmd.class);

	@Reference
	private AuthenticatedSessionManager	_authenticatedSessionManager;

	@Reference
	private Portal						_portal;

}
