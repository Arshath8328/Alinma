package first.login.change.pwd.portlet;

import first.login.change.pwd.constants.FirstLoginChangePwdPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author vidit
 */
@Component(
		immediate = true, 
		property = { 
			"com.liferay.portlet.display-category=ATMC", 
			"com.liferay.portlet.instanceable=false", 
			"com.liferay.portlet.private-session-attributes=false",
			"javax.portlet.display-name=ATMC First Login Change Pwd Portlet",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/reminder_query.jsp", 
			"javax.portlet.name=" + FirstLoginChangePwdPortletKeys.FIRSTLOGINCHANGEPWD,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=guest,power-user,user"
		}, 
		service = Portlet.class
)
public class FirstLoginChangePwdPortlet extends MVCPortlet {
}