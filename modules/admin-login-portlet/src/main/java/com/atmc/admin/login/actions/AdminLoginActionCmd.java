package com.atmc.admin.login.actions;

import com.atmc.admin.login.portlet.constants.AdminLoginPortletKeys;
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
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Hadeer
 *
 */
@Component(
		property = { "javax.portlet.name=" + AdminLoginPortletKeys.ADMINLOGIN, "mvc.command.name=/adminLogin/adminLogin" },
		service = MVCActionCommand.class
)
public class AdminLoginActionCmd extends BaseMVCActionCommand {
	public static Log	_log	= LogFactoryUtil.getLog(AdminLoginActionCmd.class);

	@Reference
	private Portal		_portal;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));

		HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);

		String login = ParamUtil.getString(actionRequest, "login");
		String password = actionRequest.getParameter("password");
		boolean rememberMe = ParamUtil.getBoolean(actionRequest, "rememberMe");
		String authType = CompanyConstants.AUTH_TYPE_EA;
		try {
			AuthenticatedSessionManagerUtil.login(request, response, login, password, rememberMe, authType);
		} catch (Exception e) {
			if (e instanceof AuthException) {
				Throwable cause = e.getCause();

				if (cause instanceof PasswordExpiredException || cause instanceof UserLockoutException) {

					SessionErrors.add(actionRequest, cause.getClass(), cause);
					return;
				} else {

					SessionErrors.add(actionRequest, e.getClass());
					return;
				}
			} else if (e instanceof CompanyMaxUsersException || e instanceof CookieNotSupportedException || e instanceof NoSuchUserException
					|| e instanceof PasswordExpiredException || e instanceof UserEmailAddressException || e instanceof UserIdException
					|| e instanceof UserLockoutException || e instanceof UserPasswordException || e instanceof UserScreenNameException) {

				SessionErrors.add(actionRequest, e.getClass(), e);
				return;

			} else {

				_portal.sendError(e, actionRequest, actionResponse);

				return;
			}

		}

		_log.info("after Login");
		// String path = themeDisplay.getPathMain();
		String path = "/group/staff/dashboard";
		actionResponse.sendRedirect(path);

	}
}
