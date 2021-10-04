/**
 * 
 */
package com.atmc.login.actions;


import com.ejada.atmc.acl.db.model.Customer;
import com.ejada.atmc.acl.db.service.CustomerLocalServiceUtil;
import com.atmc.login.constants.LoginPortletKeys;
import com.atmc.web.common.UserInfo;
import com.atmc.web.constants.FirstLoginChangePwdPortletKeys;
import com.atmc.web.constants.OTPPortletKeys;
import com.atmc.web.util.SessionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserScreenNameException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.WindowStateException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Basel
 *
 */
@Component(
		property = {
			"javax.portlet.name="+ LoginPortletKeys.LOGIN,
			"mvc.command.name=/login/register"
		},
		service = MVCActionCommand.class
	)

public class RegisterActionCmd extends BaseMVCActionCommand {

	
	private static final Log _log = LogFactoryUtil.getLog(RegisterActionCmd.class);
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

			String cmd = ParamUtil.getString(actionRequest, LoginPortletKeys.CMD);
			
			if (cmd.equals(LoginPortletKeys.CMD_VALIDATE_USER))
				validateUser(actionRequest, actionResponse);
			else if (cmd.equals(LoginPortletKeys.CMD_CHANGE_PWD))
				changePassword(actionRequest, actionResponse);			

	}
	
	protected void validateUser(ActionRequest actionRequest, ActionResponse actionResponse) throws WindowStateException, IOException, PortalException {

		_log.info("RegisterActionCmd:validateUser");


		String idIqama = ParamUtil.getString(actionRequest, "idiqama");
		String email = ParamUtil.getString(actionRequest, "emailAddress");
		_log.info("idIqama "+idIqama
				+"Pattern.compile(idIqama).matcher(\"^[0-9]+$\").find() "+ 
				Pattern.compile(idIqama).matcher("\\d+").find() +" idIqama.length() : "+ idIqama.length());
		if (idIqama.matches("^[0-9]+$") && idIqama.length()==10){
			Customer customer = CustomerLocalServiceUtil.fetchCustomer(idIqama);

			Company company = PortalUtil.getCompany(actionRequest);


			if (customer != null) {

				User user = UserLocalServiceUtil.fetchUserByScreenName(company.getCompanyId(), idIqama);
				if (user == null) {

					user = UserLocalServiceUtil.fetchUserByEmailAddress(company.getCompanyId(), email);

					if (user == null) {
						PortletSession pSession = actionRequest.getPortletSession();

						UserInfo userInfo = SessionUtil.getUserInfo(actionRequest);
						userInfo.setArabicName(customer.getNameAr());
						userInfo.setEnglishName(customer.getNameEn());
						userInfo.setEmail(email);
						userInfo.setId(customer.getId());
						userInfo.setMobile(customer.getPhone());
						//userInfo.setOtpSecret(OTPLocalServiceUtil.generateSecret());
						//SessionUtil.setUserInfo(actionRequest, userInfo);

						pSession.setAttribute(FirstLoginChangePwdPortletKeys.CMD, FirstLoginChangePwdPortletKeys.CMD_CREATE_USER, PortletSession.APPLICATION_SCOPE);


						Layout layout = (Layout) actionRequest.getAttribute(WebKeys.LAYOUT);

						PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, OTPPortletKeys.OTP, layout, PortletRequest.ACTION_PHASE);

						portletURL.setWindowState(LiferayWindowState.POP_UP);
						portletURL.setParameter("mvcRenderCommandName", "/auth/otp");
						portletURL.setParameter(ActionRequest.ACTION_NAME, "/auth/otp");
						portletURL.setParameter(OTPPortletKeys.CMD, OTPPortletKeys.CMD_SEND);

						PortletURL redirectURL = PortletURLFactoryUtil.create(actionRequest, LoginPortletKeys.LOGIN, layout, PortletRequest.ACTION_PHASE);

						redirectURL.setWindowState(LiferayWindowState.POP_UP);
						redirectURL.setParameter("mvcRenderCommandName", "/login/register");
						redirectURL.setParameter(ActionRequest.ACTION_NAME, "/login/register");
						redirectURL.setParameter(LoginPortletKeys.CMD, LoginPortletKeys.CMD_CHANGE_PWD);

						portletURL.setParameter(OTPPortletKeys.REDIRECT_URL, redirectURL.toString());


						actionResponse.sendRedirect(portletURL.toString());

					} else {
						UserEmailAddressException.MustNotBeDuplicate e = new UserEmailAddressException.MustNotBeDuplicate(user.getUserId(), user.getEmailAddress());
						SessionErrors.add(actionRequest, e.getClass(), e);
					}


				} else {
					UserScreenNameException.MustNotBeDuplicate e = new UserScreenNameException.MustNotBeDuplicate(user.getUserId(), user.getScreenName());
					SessionErrors.add(actionRequest, e.getClass(), e);
				}


			} else {
				UserScreenNameException.MustNotBeNull e = new UserScreenNameException.MustNotBeNull();
				SessionErrors.add(actionRequest, e.getClass(), e);
			}

	}	else {
			_log.info("Invalid idIqama");
		}

	}

	
	protected void changePassword(ActionRequest actionRequest, ActionResponse actionResponse) throws WindowStateException, IOException, PortalException
	{
		actionResponse.setRenderParameter("loginredirect", "true");
		actionResponse.setRenderParameter("isRegister", "true");
	}
	
	

}
