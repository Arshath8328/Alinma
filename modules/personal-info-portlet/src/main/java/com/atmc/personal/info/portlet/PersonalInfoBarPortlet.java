package com.atmc.personal.info.portlet;

import com.atmc.personal.info.constants.PersonalInfoBarPortletKeys;
//import com.atmc.web.common.UserInfo;
//import com.atmc.web.constants.PersonalInfoBarPortletKeys;
//import com.atmc.web.util.SessionUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Basel
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=ATMC",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=ATMC Personal Info Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PersonalInfoBarPortletKeys.PERSONALINFOBAR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.supported-processing-event=login-redirect;http://atmcweb.com/events",		
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PersonalInfoBarPortlet extends MVCPortlet {
	
	

	public void logout(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException
	{
		HttpServletRequest request = _portal.getOriginalServletRequest(
				_portal.getHttpServletRequest(actionRequest));
		HttpServletResponse response = _portal.getHttpServletResponse(
				actionResponse);
		
		try {
			AuthenticatedSessionManagerUtil.logout(request, response);

			actionRequest.setAttribute(WebKeys.LOGOUT, Boolean.TRUE);

			actionResponse.sendRedirect("/web/customer");
		}
		catch (Exception e) {
			_log.error(e, e);

			_portal.sendError(e, actionRequest, actionResponse);
		}

	}
	
	public void selectOrg(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException
	{
		System.out.println("selectOrg called");
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay.isSignedIn())
		{
			String orgCRNumber = ParamUtil.getString(actionRequest, "orgCRNumber");
			String orgName = ParamUtil.getString(actionRequest, "orgName");
			long orgId = ParamUtil.getLong(actionRequest, "orgId");
			
			System.out.println("orgCRNumber:" + orgCRNumber);
//			UserInfo userInfo = SessionUtil.getUserInfo(actionRequest);
//			userInfo.setSelectedOrgCRNumber(orgCRNumber);
//			userInfo.setSelectedOrgName(orgName);
//			userInfo.setSelectedOrgId(orgId);
//			userInfo.setOrgMode(true);
			actionResponse.sendRedirect("/group/customer/dashboard");
			
		}

	}
	
	public void selectOwn(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException
	{
		System.out.println("selectOwn called");
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay.isSignedIn())
		{
//			UserInfo userInfo = SessionUtil.getUserInfo(actionRequest);
//			userInfo.setSelectedOrgCRNumber(null);
//			userInfo.setOrgMode(false);
			actionResponse.sendRedirect("/group/customer/dashboard");
		}

	}
	
	
	public void viewProfile(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException
	{
		System.out.println("viewProfile called");
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay.isSignedIn())
		{
			// redirect to view profile page
			//actionResponse.sendRedirect("/group/customer/dashboard");
		}

	}
	
	
	@Override
	protected void addSuccessMessage(ActionRequest actionRequest, ActionResponse actionResponse)
	{
		return;
	}

	private static final Log _log = LogFactoryUtil.getLog(
			PersonalInfoBarPortlet.class);

	@Reference
	private Portal _portal;

}