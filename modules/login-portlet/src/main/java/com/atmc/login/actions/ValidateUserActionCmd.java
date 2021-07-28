/**
 * 
 */
package com.atmc.login.actions;

import com.atmc.web.constants.LoginPortletKeys;
import com.atmc.web.constants.OTPPortletKeys;
import com.liferay.portal.kernel.exception.CompanyMaxUsersException;
import com.liferay.portal.kernel.exception.CookieNotSupportedException;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PasswordExpiredException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserIdException;
import com.liferay.portal.kernel.exception.UserLockoutException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.exception.UserScreenNameException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManager;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Basel
 *
 */
@Component(
		property =
		{ "javax.portlet.name=" + LoginPortletKeys.LOGIN, "mvc.command.name=/login/validate" },
		service = MVCActionCommand.class
)

public class ValidateUserActionCmd extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest request = _portal.getOriginalServletRequest(_portal.getHttpServletRequest(actionRequest));
		HttpServletResponse response = _portal.getHttpServletResponse(actionResponse);

		String cmd = ParamUtil.getString(actionRequest, "CMD");
		// boolean rememberMe = ParamUtil.getBoolean(actionRequest, "rememberMe");

		// QName qName = new QName("http://atmcweb.com/events", "login-redirect");
		// actionResponse.setEvent(qName, "loginredirect");
		// actionResponse.setRenderParameter("loginredirect", "true");

		System.out.println("validating user");
		// actionResponse.setRenderParameter("mvcRenderCommandName", "/auth/otp");

		System.out.println("validateUser");
		// response.setRenderParameter("step", "2");

		Layout layout = (Layout) actionRequest.getAttribute(WebKeys.LAYOUT);

		PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, OTPPortletKeys.OTP, layout, PortletRequest.ACTION_PHASE);

		portletURL.setWindowState(LiferayWindowState.POP_UP);
		portletURL.setParameter("mvcRenderCommandName", "/auth/otp");
		portletURL.setParameter(ActionRequest.ACTION_NAME, "/auth/otp");
		portletURL.setParameter("CMD", "SEND");

		actionResponse.sendRedirect(portletURL.toString());

		// sendRedirect(actionRequest, actionResponse, portletURL.toString());

	}

	private static final Log	_log	= LogFactoryUtil.getLog(ValidateUserActionCmd.class);

	@Reference
	private Portal				_portal;

}
