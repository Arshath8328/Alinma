/**
 * 
 */
package com.ejada.atmc.web.util;



import com.ejada.atmc.web.common.UserInfo;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Basel
 *
 */
public class SessionUtil {

	public static final String USER_INFO_KEY = "USERINFOKEY";
	private static final Log _log = LogFactoryUtil.getLog(SessionUtil.class);
	
	public static UserInfo getUserInfo(ActionRequest actionRequest)
	{
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		return getUserInfo(request);
	}
	

	public static UserInfo getUserInfo(RenderRequest renderRequest)
	{
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		return getUserInfo(request);
	}
	
	public static UserInfo getUserInfo(HttpServletRequest request)
	{
		HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(request);
		HttpSession pSession =  originalRequest.getSession();
		UserInfo userInfo  = (UserInfo)pSession.getAttribute(USER_INFO_KEY);
		
		if (userInfo == null)
		{
			_log.info("No user Info in session.returning a new one");
			userInfo =  new UserInfo();
			pSession.setAttribute(USER_INFO_KEY, userInfo);
		}
		
		return userInfo;
		
	}

	
}
