package com.atmc.admin.login.actions;

import com.atmc.admin.login.constants.AdminLoginPortletKeys;
import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		property =
		{ "javax.portlet.name=" + AdminLoginPortletKeys.ADMINLOGIN, "mvc.command.name=/adminLogin/captcha" },
		service = MVCResourceCommand.class
)
public class AdminCaptchaResourceCmd implements MVCResourceCommand {
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		try {
			CaptchaUtil.serveImage(resourceRequest, resourceResponse);

			return false;
		} catch (Exception e) {
			_log.error(e.getMessage(), e);

			return true;
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(AdminCaptchaResourceCmd.class);

}
