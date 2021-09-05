package admin.customer.service.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import admin.customer.service.constants.AdminCustomerServiceListPortletKeys;

@Component(
	immediate = true,
	property = { 
		"com.liferay.portlet.display-category=ATMC",
		"com.liferay.portlet.instanceable=false", 
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.display-name=ATMC Assign Service Request Portlet", 
		"javax.portlet.init-param.template-path=/adminCustomerServiceList/",
		"javax.portlet.init-param.view-template=/adminCustomerServiceList/assign_to.jsp", 
		"javax.portlet.name=" + AdminCustomerServiceListPortletKeys.ASSIGN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=guest,power-user,user" 
		},
	service = Portlet.class)
public class AssignServiceRequestPortlet extends MVCPortlet {

	@Override
	protected void addSuccessMessage(ActionRequest actionRequest, ActionResponse actionResponse) {
		return;
	}
}
