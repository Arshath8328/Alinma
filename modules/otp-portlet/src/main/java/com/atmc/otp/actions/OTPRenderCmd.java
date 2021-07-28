package com.atmc.otp.actions;

import com.atmc.otp.constants.OtpPortletKeys;
import com.atmc.web.constants.LoginPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+ OtpPortletKeys.OTP,
                "mvc.command.name=/auth/otp"
        },
        service = MVCRenderCommand.class
)
public class OTPRenderCmd implements MVCRenderCommand{
    Log _log = LogFactoryUtil.getLog(OTPRenderCmd.class);
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

		_log.info("OTP render");
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
				WebKeys.THEME_DISPLAY);
		boolean otpRedirect = (renderRequest.getPortletSession().getAttribute("otpredirect") != null);
		boolean requestMobile = (renderRequest.getPortletSession().getAttribute("requestmobile") != null);

		
		_log.info("otp redirect:" + otpRedirect);
		_log.info("mobile from request:" + requestMobile);
		if (otpRedirect)
		{
			renderRequest.getPortletSession().removeAttribute("otpredirect");
			return "/otp_redirect.jsp";
		}
		
		if (themeDisplay.isSignedIn() || requestMobile)
	
			return "/otp_auth_user.jsp";
		else 
			return "/otp_unauth_user.jsp";
		
	}

}
