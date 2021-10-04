package first.login.change.pwd.actions;

import com.atmc.bsl.db.service.UserMgmtLocalServiceUtil;
import com.atmc.web.common.UserInfo;
import com.atmc.web.util.SessionUtil;
import com.liferay.portal.kernel.exception.EmailAddressException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.exception.UserReminderQueryException;
import com.liferay.portal.kernel.exception.UserScreenNameException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManager;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.users.admin.kernel.util.UsersAdmin;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import first.login.change.pwd.constants.FirstLoginChangePwdPortletKeys;

/**
 * @author Basel
 *
 */
@Component(
		property = {
			"javax.portlet.name="+ FirstLoginChangePwdPortletKeys.FIRSTLOGINCHANGEPWD,
			"mvc.command.name=/login/firstLoginChgPwd"
		},
		service = MVCActionCommand.class
	)

public class FirstLoginChangePwdActionCmd extends BaseMVCActionCommand {

	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		PortletSession pSession = actionRequest.getPortletSession();
		
		String cmd = ParamUtil.getString(actionRequest, FirstLoginChangePwdPortletKeys.CMD);
		if (cmd == null || cmd.isEmpty())
			cmd = (String)pSession.getAttribute(FirstLoginChangePwdPortletKeys.CMD,PortletSession.APPLICATION_SCOPE);
		
		if (cmd.equals(FirstLoginChangePwdPortletKeys.CMD_CREATE_USER))
			createUser(actionRequest, actionResponse);
		else if (cmd.equals(FirstLoginChangePwdPortletKeys.CMD_CHANGE_PWD))
			changePassword(actionRequest, actionResponse);
		else if (cmd.equals(FirstLoginChangePwdPortletKeys.CMD_UPDATE_REMINDER_QUERY))
			updateReminderQuery(actionRequest, actionResponse);
		
			
	}
	
	
	protected void changePassword(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception
	{
		String password = ParamUtil.getString(actionRequest, "password");
		UserInfo userInfo = SessionUtil.getUserInfo(actionRequest);
		PortletSession pSession = actionRequest.getPortletSession();
		String question = (String)pSession.getAttribute("reminderQueryQuestion");
		String answer = (String)pSession.getAttribute("reminderQueryAnswer");

		
		try {
			UserMgmtLocalServiceUtil.changeFirstTimeLoginPassword(userInfo.getUserId(), password,question,answer);
			login(actionRequest, actionResponse,userInfo.getId(),password);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void createUser(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception
	{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UserInfo userInfo = SessionUtil.getUserInfo(actionRequest);
		Company company = PortalUtil.getCompany(actionRequest);
		long companyId = company.getCompanyId();
		String password = ParamUtil.getString(actionRequest, "password");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);
		PortletSession pSession = actionRequest.getPortletSession();
		String question = (String)pSession.getAttribute("reminderQueryQuestion");
		String answer = (String)pSession.getAttribute("reminderQueryAnswer");

		try 
		{
			
			UserMgmtLocalServiceUtil.createUser(companyId, userInfo.getId(), password, userInfo.getEnglishName(), userInfo.getArabicName(), themeDisplay.getLocale(), userInfo.getMobile(), userInfo.getEmail(), serviceContext,question,answer);			
			login(actionRequest, actionResponse,userInfo.getId(),password);
			
		} catch (PortalException e) {
			if (e instanceof UserEmailAddressException.MustNotBeDuplicate ||
					 e instanceof UserScreenNameException.MustNotBeDuplicate ||
					 e instanceof EmailAddressException ||
					 e instanceof UserEmailAddressException ||
					 e instanceof UserPasswordException ||
					 e instanceof UserScreenNameException) {

				hideDefaultErrorMessage(actionRequest);
				SessionErrors.add(actionRequest, e.getClass(), e);
			}
			else{
				throw e;
			}		
		}

	}

	protected void login(ActionRequest actionRequest, ActionResponse actionResponse, String login, String password)
		throws Exception {

		HttpServletRequest request = _portal.getOriginalServletRequest(
			_portal.getHttpServletRequest(actionRequest));
		HttpServletResponse response = _portal.getHttpServletResponse(
			actionResponse);
		
		boolean rememberMe = false;
		String authType = CompanyConstants.AUTH_TYPE_SN;
		_authenticatedSessionManager.login(request, response, login, password, rememberMe, authType);

		actionResponse.sendRedirect("/group/customer/dashboard");

	}
	
	
	protected void updateReminderQuery(ActionRequest actionRequest, ActionResponse actionResponse) 
	{

		String question = ParamUtil.getString(actionRequest, "reminderQueryQuestion");
		String answer = ParamUtil.getString(actionRequest, "reminderQueryAnswer");

		if (question.equals(UsersAdmin.CUSTOM_QUESTION)) {
			question = ParamUtil.getString(
					actionRequest, "reminderQueryCustomQuestion");
		}
		
		if (question.isEmpty() || answer.isEmpty())
		{
			UserReminderQueryException e = new UserReminderQueryException(); 
			hideDefaultErrorMessage(actionRequest);
			SessionErrors.add(actionRequest, e.getClass());
			actionResponse.setRenderParameter("reminderQueryError", "true");
		}
		else
		{
			PortletSession pSession = actionRequest.getPortletSession();
			pSession.setAttribute("reminderQueryQuestion", question);
			pSession.setAttribute("reminderQueryAnswer", answer);
		}
		
	}

	private static final Log _log = LogFactoryUtil.getLog(FirstLoginChangePwdActionCmd.class);

	@Reference
	private Portal _portal;
	
	@Reference
	private AuthenticatedSessionManager _authenticatedSessionManager;

}
