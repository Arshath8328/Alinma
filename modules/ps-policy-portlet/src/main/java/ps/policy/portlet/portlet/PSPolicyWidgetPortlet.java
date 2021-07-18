//package com.ejada.atmc.portlet;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.ResourceBundle;
//
//import javax.portlet.Portlet;
//import javax.portlet.PortletException;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//
//import org.osgi.service.component.annotations.Component;
//
//import com.atmc.acl.db.model.PSPolicy;
//import com.ejada.atmc.acl.db.service.lnp2_policymastrLocalServiceUtil;
//import com.ejada.atmc.constants.PSPolicyPortletKeys;
//import com.liferay.portal.kernel.exception.PortalException;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.model.User;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
//import com.liferay.portal.kernel.service.UserLocalServiceUtil;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.ResourceBundleUtil;
//import com.liferay.portal.kernel.util.WebKeys;
//
//@Component(
//		immediate = true,
//		property = {
//			"com.liferay.portlet.display-category=category.sample",
//			"com.liferay.portlet.instanceable=true",
//			"javax.portlet.display-name=PSPolicyWidget Portlet",
//			"javax.portlet.init-param.template-path=/",
//			"javax.portlet.init-param.view-template=/Widget/view.jsp",
//			"javax.portlet.name=" + PSPolicyPortletKeys.PSPolicyWidget,
//			"javax.portlet.resource-bundle=content.Language",
//			"javax.portlet.security-role-ref=power-user,user"
//		},
//		service = Portlet.class
//	)
//
//public class PSPolicyWidgetPortlet extends MVCPortlet{
//
//	public static final Log LOG = LogFactoryUtil.getLog(PSPolicyWidgetPortlet.class);
//	
//	@Override
//	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
//			throws IOException, PortletException {
//		try {
//			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//			ResourceBundle resourceBundle = ResourceBundleUtil.getBundle("content.Language", themeDisplay.getLocale() , getClass());
//			User loggedInUser = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
////			List<PSPolicy> list = lnp2_policymastrLocalServiceUtil.findAllPSPolicyByIqamaId("1082373075");
//			List<PSPolicy> list = lnp2_policymastrLocalServiceUtil.findAllPSPolicyByIqamaId(loggedInUser.getScreenName());
//			LOG.info("-----------------------------------------PSPolicyWidget : "+list);
//			renderRequest.setAttribute("PSPolicyList", list);
//		} catch (PortalException e) {
//			LOG.error(e.getMessage(), e);
//		}
//		super.render(renderRequest, renderResponse);
//	}
//	
//}
